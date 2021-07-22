// 
// Decompiled by Procyon v0.5.36
// 

package aic2021.engine;

import aic2021.user.UnitInfo;
import aic2021.util.WinCondition;
import aic2021.user.Direction;
import java.lang.reflect.InvocationTargetException;
import aic2021.util.DeathException;
import aic2021.user.GameConstants;
import aic2021.user.Technology;
import aic2021.user.Resource;
import aic2021.gamelogs.GameLog;
import aic2021.util.random.SymmetricRandom;
import aic2021.util.GameLocation;
import aic2021.user.UnitType;
import aic2021.user.Team;
import aic2021.user.UnitController;
import java.lang.reflect.Method;

public class Unit extends Thread
{
    ScheduleManager scheduleManager;
    private final World world;
    private final ThreadManager threadManager;
    private Object unitPlayer;
    private Method unitPlayerRunMethod;
    private final UnitController unitController;
    private final int id;
    private final int internalId;
    private final TeamInfo teamInfo;
    private final Team team;
    private Boolean hasMoved;
    int bytecodeEndTurn;
    int health;
    int cocoonTurnsLeft;
    UnitType type;
    GameLocation gameLocation;
    GameLocation prevGameLocation;
    float currentMoveCooldown;
    float currentAttackCooldown;
    float moveCooldown;
    float attackCooldown;
    int maxHealth;
    int attack;
    int detectionLevel;
    boolean hasSpawned;
    boolean hasGathered;
    boolean hasDisarmed;
    private boolean dead;
    private int[] resources;
    int roundCreated;
    SymmetricRandom rand;
    int torchIntensity;
    int torchRounds;
    
    Unit(final ScheduleManager scheduleManager, final World world, final GameLog gameLog, final Team team, final int cocoonTurnsLeft, final UnitType type) {
        this.hasMoved = null;
        this.bytecodeEndTurn = 0;
        this.currentMoveCooldown = 0.0f;
        this.currentAttackCooldown = 0.0f;
        this.hasSpawned = false;
        this.hasGathered = false;
        this.hasDisarmed = false;
        this.dead = false;
        this.resources = new int[Resource.values().length];
        this.roundCreated = 0;
        this.rand = new SymmetricRandom();
        this.torchIntensity = 0;
        this.torchRounds = 0;
        this.id = world.getNewId();
        this.internalId = world.getNewInternalId();
        this.scheduleManager = scheduleManager;
        this.world = world;
        this.teamInfo = world.getTeamInfo(team);
        this.type = type;
        this.team = team;
        this.setStats();
        this.cocoonTurnsLeft = cocoonTurnsLeft;
        this.unitController = new UnitControllerImpl(this, world, gameLog);
        this.prevGameLocation = this.gameLocation;
        this.threadManager = new ThreadManager(this);
        this.roundCreated = world.getRound();
    }
    
    void setStats() {
        this.attack = this.type.getAttack();
        if ((this.type == UnitType.AXEMAN || this.type == UnitType.SPEARMAN) && this.teamInfo.hasTech(Technology.SHARPENERS)) {
            this.attack = (int)Math.round((1.0 + GameConstants.ATTACK_RATIO_INCREASE_SHARPENERS) * this.attack);
        }
        this.maxHealth = this.type.getMaxHealth();
        if (!this.type.isStructure()) {
            if (this.type == UnitType.WOLF && this.teamInfo.hasTech(Technology.EUGENICS)) {
                this.maxHealth += 20;
            }
            if (this.teamInfo.hasTech(Technology.COOKING)) {
                this.maxHealth = (int)Math.round((1.0 + GameConstants.MAX_HEALTH_RATIO_INCREASE_COOKING) * this.maxHealth);
            }
        }
        this.health = this.maxHealth;
        this.moveCooldown = this.type.getMovementCooldown();
        if (this.type == UnitType.WOLF && this.teamInfo.hasTech(Technology.EUGENICS)) {
            this.moveCooldown -= 0.5f;
        }
        this.attackCooldown = this.type.getAttackCooldown();
        if (this.teamInfo.hasTech(Technology.EXPERTISE)) {
            this.attackCooldown -= (float)(GameConstants.ATTACK_COOLDOWN_RATIO_DECREASE_EXPERTISE * this.attackCooldown);
        }
        this.detectionLevel = this.type.getDetectionLevel();
        if (this.teamInfo.hasTech(Technology.CRYSTALS)) {
            this.detectionLevel -= 2;
        }
    }
    
    void startTurn() {
        if (this.cocoonTurnsLeft > 0) {
            --this.cocoonTurnsLeft;
        }
        this.prevGameLocation = this.gameLocation;
        this.currentMoveCooldown = Math.max(0.0f, this.currentMoveCooldown - 1.0f);
        this.currentAttackCooldown = Math.max(0.0f, this.currentAttackCooldown - 1.0f);
        this.hasSpawned = false;
        this.hasMoved = false;
        this.hasGathered = false;
        this.hasDisarmed = false;
        --this.torchRounds;
        if (this.torchRounds == 0 && this.torchIntensity > 0) {
            this.removeSource();
        }
        if (this.torchRounds < 0) {
            this.torchRounds = 0;
        }
        if (this.type == UnitType.FARM) {
            this.teamInfo.addResources(1, Resource.FOOD);
        }
        if (this.type == UnitType.SAWMILL) {
            this.teamInfo.addResources(1, Resource.WOOD);
        }
        if (this.type == UnitType.QUARRY) {
            this.teamInfo.addResources(1, Resource.STONE);
        }
    }
    
    void lightTorch() {
        final boolean b = this.torchIntensity == 0;
        this.torchIntensity = 16;
        if (this.teamInfo.hasTech(Technology.COMBUSTION)) {
            this.torchIntensity += 2;
        }
        this.torchRounds = 150;
        if (this.teamInfo.hasTech(Technology.OIL)) {
            this.torchRounds = 250;
        }
        if (b) {
            this.world.addSource(this.torchIntensity, this.gameLocation, 1);
        }
    }
    
    void removeSource() {
        this.world.removeSource(this.torchIntensity, this.gameLocation, 1);
        this.torchIntensity = 0;
        this.torchRounds = 0;
    }
    
    void receiveDamage(final float n, final TeamInfo teamInfo) {
        this.health -= (int)n;
        this.health = Math.min(this.health, this.type.getMaxHealth());
        if (this.health <= 0 && !this.isDead()) {
            this.kill();
        }
    }
    
    void makeSmokeSignal() {
        float n = 10.0f;
        if (this.teamInfo.hasTech(Technology.VOCABULARY)) {
            n = 2.0f;
        }
        this.currentAttackCooldown += n;
        this.currentMoveCooldown += n;
    }
    
    void endTurn() {
    }
    
    @Override
    public void run() {
        if (this.getTeam() == Team.NEUTRAL) {
            this.runDeer();
            return;
        }
        try {
            this.getUnitPlayerInstanceAndRunMethod();
        }
        catch (DeathException ex3) {
            this.kill();
            this.removeThread();
            return;
        }
        try {
            this.unitPlayerRunMethod.invoke(this.unitPlayer, this.unitController);
        }
        catch (InvocationTargetException ex) {
            if (!(ex.getCause() instanceof DeathException)) {
                if (Game.printWarnings) {
                    ex.printStackTrace();
                }
            }
        }
        catch (Exception ex2) {
            if (Game.printWarnings) {
                ex2.printStackTrace();
            }
        }
        finally {
            this.kill();
            this.removeThread();
        }
    }
    
    void runDeer() {
        while (!this.isDead()) {
            this.pause();
            --this.cocoonTurnsLeft;
            if (this.cocoonTurnsLeft <= 0) {
                try {
                    new DeerUnitController().run(this.world, this, this.unitController);
                }
                catch (DeathException ex) {}
                catch (Throwable t) {
                    if (Game.printWarnings) {
                        t.printStackTrace();
                    }
                }
                finally {
                    this.kill();
                    this.removeThread();
                }
                return;
            }
        }
        this.kill();
        this.removeThread();
    }
    
    public void pause() {
        ThreadManager.resumeMaster();
    }
    
    void kill() {
        if (this.dead) {
            return;
        }
        this.dead = true;
        if (this.type == UnitType.DEER) {
            this.world.getIns(this.gameLocation).addResource(Resource.FOOD, 500);
        }
        else {
            final TeamInfo opponent = this.world.getOpponent(this.team);
            if (opponent != null) {
                for (final Resource resource : Resource.values()) {
                    opponent.addResources(this.resources[resource.ordinal()] / 2, resource);
                }
            }
        }
        this.world.removeUnitPermanently(this);
    }
    
    void removeThread() {
        this.scheduleManager.removeCurrentAction();
        ThreadManager.resumeMasterNonStop();
    }
    
    void depositResources() {
        this.teamInfo.addResources(this.resources);
        for (int i = 0; i < this.resources.length; ++i) {
            this.resources[i] = 0;
        }
    }
    
    boolean hasGathered() {
        return this.hasGathered;
    }
    
    void gather() {
        this.hasGathered = true;
    }
    
    boolean hasDisarmed() {
        return this.hasDisarmed;
    }
    
    void disarm() {
        this.hasDisarmed = true;
    }
    
    int getResource(final int n) {
        return this.resources[n];
    }
    
    public int[] getResources() {
        final int[] array = new int[Resource.values().length];
        for (int i = 0; i < array.length; ++i) {
            array[i] = this.resources[i];
        }
        return array;
    }
    
    void addResource(final int n, final int n2) {
        final int[] resources = this.resources;
        resources[n] += n2;
    }
    
    public boolean isDead() {
        return this.dead;
    }
    
    public int getUnitId() {
        return this.id;
    }
    
    public int getInternalId() {
        return this.internalId;
    }
    
    public Team getTeam() {
        return this.team;
    }
    
    public GameLocation getGameLocation() {
        return this.gameLocation;
    }
    
    public GameLocation getPrevGameLocation() {
        return this.prevGameLocation;
    }
    
    public int getHealth() {
        return this.health;
    }
    
    public int getMaxHealth() {
        return this.maxHealth;
    }
    
    public float getCurrentMoveCooldown() {
        return this.currentMoveCooldown;
    }
    
    public int getTorchIntensity() {
        return this.torchIntensity;
    }
    
    public int getTorchRounds() {
        return this.torchRounds;
    }
    
    public UnitType getType() {
        return this.type;
    }
    
    public float getCurrentAttackCooldown() {
        return this.currentAttackCooldown;
    }
    
    public int getConstructionTurns() {
        return this.cocoonTurnsLeft;
    }
    
    public int getAttack() {
        return this.attack;
    }
    
    public int getVisionRange() {
        return this.type.getVisionRange();
    }
    
    public int getAttackRange() {
        return this.type.getAttackRange();
    }
    
    public int getDetectionLevel() {
        return this.detectionLevel;
    }
    
    public float getMovementCooldown() {
        return this.moveCooldown;
    }
    
    public float getAttackCooldown() {
        return this.attackCooldown;
    }
    
    public int getBytecodeEndTurn() {
        return this.bytecodeEndTurn;
    }
    
    int getRoundCreated() {
        return this.roundCreated;
    }
    
    public void addMovementCooldown(final Direction direction) {
        if (direction.length() > 0.0f) {
            this.hasMoved = true;
        }
        float n = 1.0f;
        final Cell ins = this.world.getIns(this.gameLocation);
        if (ins != null && ins.hasWater() && !this.teamInfo.hasTech(Technology.NAVIGATION)) {
            n = 2.0f;
        }
        this.currentMoveCooldown += (float)Math.max(1.0, direction.length() * this.moveCooldown * n);
    }
    
    public void attack(final GameLocation gameLocation) {
        this.currentAttackCooldown += this.attackCooldown;
    }
    
    public void spawn() {
        this.hasSpawned = true;
    }
    
    boolean isReady() {
        return this.cocoonTurnsLeft <= 0;
    }
    
    public boolean canMove() {
        return this.isReady() && this.getType().canMove() && this.currentMoveCooldown < 1.0f;
    }
    
    public boolean canAttack() {
        return this.isReady() && this.getType().canAttack() && this.currentAttackCooldown < 1.0f;
    }
    
    public boolean hasSpawned() {
        return this.hasSpawned;
    }
    
    public TeamInfo getTeamInfo() {
        return this.teamInfo;
    }
    
    public boolean sanityCheck(final UnitControllerImpl unitControllerImpl) {
        if (unitControllerImpl == this.scheduleManager.getCurrentUnit().getUnitController()) {
            return true;
        }
        if (Game.printWarnings) {
            System.err.println("Player " + this.getTeamInfo().teamName + " is cheating!");
        }
        this.world.setWinner(this.getTeam().getOpponent(), WinCondition.CHEATING);
        return false;
    }
    
    public ScheduleManager getScheduleManager() {
        return this.scheduleManager;
    }
    
    public UnitInfo toUnitInfo() {
        return new UnitInfo(this);
    }
    
    UnitController getUnitController() {
        return this.unitController;
    }
    
    public int getBytecode() {
        return this.threadManager.getCurrentBytecode();
    }
    
    private void getUnitPlayerInstanceAndRunMethod() {
        final Class<?> unitPlayerClass = this.teamInfo.getUnitPlayerClass();
        try {
            this.unitPlayerRunMethod = unitPlayerClass.getMethod("run", UnitController.class);
        }
        catch (NoSuchMethodException | SecurityException ex2) {
            final Object o2;
            final Object o = o2;
            if (Game.printWarnings) {
                ((Throwable)o).printStackTrace();
            }
        }
        try {
            this.unitPlayer = unitPlayerClass.newInstance();
        }
        catch (DeathException ex) {
            throw ex;
        }
        catch (InstantiationException | IllegalAccessException ex3) {
            final Object o4;
            final Object o3 = o4;
            if (Game.printWarnings) {
                ((Throwable)o3).printStackTrace();
            }
        }
    }
    
    double getNextRandom() {
        return this.rand.poll();
    }
    
    ThreadManager getThreadManager() {
        return this.threadManager;
    }
}
