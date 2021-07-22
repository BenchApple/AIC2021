// 
// Decompiled by Procyon v0.5.36
// 

package aic2021.engine;

import aic2021.util.random.CustomRandom;
import java.awt.Color;
import aic2021.user.FireInfo;
import java.util.ArrayList;
import aic2021.user.ResourceInfo;
import aic2021.util.GameAction;
import aic2021.util.VisibleCells;
import aic2021.util.GameLocation;
import aic2021.user.Resource;
import aic2021.user.Technology;
import aic2021.user.UnitType;
import aic2021.user.Team;
import aic2021.user.Location;
import aic2021.user.UnitInfo;
import aic2021.user.Direction;
import aic2021.gamelogs.GameLog;
import aic2021.user.UnitController;

public class UnitControllerImpl implements UnitController
{
    private Unit unit;
    private World world;
    private GameLog gameLog;
    private Direction[] directions;
    
    public UnitControllerImpl(final Unit unit, final World world, final GameLog gameLog) {
        this.directions = Direction.values();
        this.unit = unit;
        this.world = world;
        this.gameLog = gameLog;
    }
    
    @Override
    public UnitInfo getInfo() {
        return this.unit.toUnitInfo();
    }
    
    @Override
    public Location getLocation() {
        return this.unit.getGameLocation().toLocation();
    }
    
    @Override
    public Team getTeam() {
        return this.unit.getTeam();
    }
    
    private TeamInfo getTeamInfo() {
        return this.unit.getTeamInfo();
    }
    
    @Override
    public Team getOpponent() {
        return this.getTeam().getOpponent();
    }
    
    @Override
    public boolean canMove() {
        return this.unit.canMove() && !this.getType().isStructure();
    }
    
    @Override
    public boolean canAttack() {
        return this.unit.canAttack() && this.getType().canAttack();
    }
    
    @Override
    public int[] getResourcesCarried() {
        return this.unit.getResources();
    }
    
    @Override
    public UnitType getType() {
        return this.unit.getType();
    }
    
    private void sanityCheck() {
        if (!this.unit.sanityCheck(this)) {
            this.yield();
        }
    }
    
    @Override
    public boolean canLightTorch() {
        this.sanityCheck();
        return !this.getType().isStructure() && this.getType() != UnitType.WOLF && (this.getTeamInfo().hasTech(Technology.FLINT) || this.world.adjacentToLight(this.unit)) && this.getTeamInfo().hasResource(10, Resource.WOOD);
    }
    
    @Override
    public void lightTorch() {
        this.sanityCheck();
        if (!this.canLightTorch()) {
            if (Game.printWarnings) {
                System.err.println("UnitControllerImpl.lightTorch: Round " + this.getRound() + ": Unit " + this.getInfo().getID() + " cannot light torch.");
            }
            ThreadManager.punish();
            return;
        }
        this.getTeamInfo().addResources(-10, Resource.WOOD);
        this.unit.lightTorch();
    }
    
    @Override
    public boolean canMove(final Direction direction) {
        this.sanityCheck();
        if (direction == null) {
            if (Game.printWarnings) {
                System.err.println("UnitControllerImpl.canMove: Round " + this.getRound() + ": Unit " + this.getInfo().getID() + " cannot move in a null direction.");
            }
            ThreadManager.punish();
            return false;
        }
        return this.canMove() && (direction == Direction.ZERO || this.world.isAccessible(this.unit.getGameLocation().add(direction), this.unit.getType(), this.getTeamInfo()));
    }
    
    @Override
    public void move(final Direction obj) {
        if (this.unit.isDead()) {
            return;
        }
        this.sanityCheck();
        if (obj == null) {
            if (Game.printWarnings) {
                System.err.println("UnitControllerImpl.move: Round " + this.getRound() + ": Unit " + this.getInfo().getID() + " attempted to move in a null direction.");
            }
            ThreadManager.punish();
            return;
        }
        if (!this.canMove(obj)) {
            if (Game.printWarnings) {
                System.err.println("UnitControllerImpl.move: Round " + this.getRound() + ": Unit " + this.getInfo().getID() + " cannot move in the direction " + obj + ".");
            }
            ThreadManager.punish();
            return;
        }
        this.unit.addMovementCooldown(obj);
        if (obj == Direction.ZERO) {
            return;
        }
        this.world.moveUnit(this.unit, obj);
    }
    
    private boolean isObstructed(final GameLocation gameLocation, final GameLocation gameLocation2) {
        final VisibleCells instance = VisibleCells.getInstance();
        for (int n = gameLocation2.x - gameLocation.x + instance.center, n2 = gameLocation2.y - gameLocation.y + instance.center, i = 0; i < instance.offsetX[n][n2].length; ++i) {
            final GameLocation add = gameLocation.add(instance.offsetX[n][n2][i], instance.offsetY[n][n2][i]);
            if (!add.isEqual(gameLocation)) {
                if (!add.isEqual(gameLocation2)) {
                    if (this.world.getIns(add).isObstructed()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    @Override
    public boolean isObstructed(final Location obj, final Location obj2) {
        if (obj == null || obj2 == null) {
            ThreadManager.punish();
            return true;
        }
        final GameLocation gameLocation = new GameLocation(obj);
        final GameLocation gameLocation2 = new GameLocation(obj2);
        if (!this.canSenseLocationPrivate(obj, false) || !this.canSenseLocationPrivate(obj2, false)) {
            if (Game.printWarnings) {
                System.err.println("UnitControllerImpl.isObstructed: Round " + this.getRound() + ": Unit " + this.getInfo().getID() + " cannot sense locations " + obj + " or " + obj2 + ".");
            }
            ThreadManager.punish();
            return true;
        }
        return this.world.isOutOfMap(gameLocation) || this.world.isOutOfMap(gameLocation2) || this.isObstructed(gameLocation, gameLocation2);
    }
    
    @Override
    public boolean canAttack(final Location location) {
        this.sanityCheck();
        if (location == null) {
            if (Game.printWarnings) {
                System.err.println("UnitControllerImpl.canAttack: Round " + this.getRound() + ": Unit " + this.getInfo().getID() + " called with a null location.");
            }
            ThreadManager.punish();
            return false;
        }
        if (!this.canAttack()) {
            return false;
        }
        final GameLocation gameLocation = new GameLocation(location);
        return !this.world.isOutOfMap(gameLocation) && gameLocation.distanceSquared(this.unit.getGameLocation()) <= this.unit.getAttackRange() && !this.isObstructed(this.unit.getGameLocation(), gameLocation);
    }
    
    @Override
    public boolean canThrowTorch(final Location location) {
        this.sanityCheck();
        if (location == null) {
            if (Game.printWarnings) {
                System.err.println("UnitControllerImpl.canThrowTorch: Round " + this.getRound() + ": Unit " + this.getInfo().getID() + " called with a null location.");
            }
            ThreadManager.punish();
            return false;
        }
        if (this.unit.torchRounds == 0) {
            return false;
        }
        final GameLocation gameLocation = new GameLocation(location);
        return !this.world.isOutOfMap(gameLocation) && gameLocation.distanceSquared(this.unit.getGameLocation()) <= this.unit.getType().getTorchThrowRange() && !this.world.getIns(gameLocation).hasMountain() && !this.world.getIns(gameLocation).hasWater() && !this.isObstructed(this.unit.getGameLocation(), gameLocation);
    }
    
    @Override
    public void attack(final Location obj) {
        this.sanityCheck();
        if (this.unit.isDead()) {
            return;
        }
        if (!this.canAttack(obj)) {
            if (Game.printWarnings) {
                System.err.println("UnitControllerImpl.attack: Round " + this.getRound() + ": Unit " + this.getInfo().getID() + " cannot attack location " + obj + ".");
            }
            ThreadManager.punish();
            return;
        }
        final GameLocation gameLocation = new GameLocation(obj);
        this.unit.attack(gameLocation);
        this.gameLog.writeAction(GameAction.ATTACK, this.unit.getTeam(), new Object[] { this.unit.getGameLocation(), gameLocation });
        this.attackLocation(new GameLocation(obj));
    }
    
    @Override
    public void throwTorch(final Location obj) {
        this.sanityCheck();
        if (this.unit.isDead()) {
            return;
        }
        if (!this.canThrowTorch(obj)) {
            if (Game.printWarnings) {
                System.err.println("UnitControllerImpl.throwTorch: Round " + this.getRound() + ": Unit " + this.getInfo().getID() + " cannot attack location " + obj + ".");
            }
            ThreadManager.punish();
            return;
        }
        final GameLocation gameLocation = new GameLocation(obj);
        int n = 16;
        if (this.getTeamInfo().hasTech(Technology.COMBUSTION)) {
            n += 2;
        }
        this.world.getIns(gameLocation).putFire(this.unit.torchRounds, n);
        this.unit.removeSource();
    }
    
    private boolean canSenseLocationPrivate(final Location location, final boolean b) {
        if (location.distanceSquared(this.unit.getGameLocation().toLocation()) > this.unit.getVisionRange()) {
            return false;
        }
        final GameLocation gameLocation = new GameLocation(location);
        if (this.world.isOutOfMap(gameLocation)) {
            return false;
        }
        if (b) {
            return true;
        }
        final Cell ins = this.world.getIns(gameLocation);
        return ins != null && ins.getLuminosity() >= this.unit.getDetectionLevel();
    }
    
    @Override
    public boolean canSenseLocation(final Location location) {
        this.sanityCheck();
        if (location == null) {
            if (Game.printWarnings) {
                System.err.println("UnitControllerImpl.canSenseLocation: Round " + this.getRound() + ": Unit " + this.getInfo().getID() + " attempted to sense a null location.");
            }
            ThreadManager.punish();
            return false;
        }
        return this.canSenseLocationPrivate(location, false);
    }
    
    @Override
    public int senseIllumination(final Location obj) {
        this.sanityCheck();
        if (obj == null) {
            if (Game.printWarnings) {
                System.err.println("UnitControllerImpl.getIllumination: Round " + this.getRound() + ": Unit " + this.getInfo().getID() + " attempted to sense a null location.");
            }
            ThreadManager.punish();
            return 0;
        }
        if (!this.canSenseLocationPrivate(obj, true)) {
            if (Game.printWarnings) {
                System.err.println("UnitControllerImpl.getIllumination: Round " + this.getRound() + ": Unit " + this.getInfo().getID() + " can't sense location " + obj + ".");
            }
            ThreadManager.punish();
            return 0;
        }
        final Cell ins = this.world.getIns(new GameLocation(obj));
        if (ins == null) {
            return 0;
        }
        return ins.getLuminosity();
    }
    
    @Override
    public ResourceInfo[] senseResourceInfo(final Location obj) {
        this.sanityCheck();
        if (obj == null) {
            if (Game.printWarnings) {
                System.err.println("UnitControllerImpl.senseResourceInfo: Round " + this.getRound() + ": Unit " + this.getInfo().getID() + " attempted to sense a null location.");
            }
            ThreadManager.punish();
            return null;
        }
        if (!this.canSenseLocationPrivate(obj, false)) {
            if (Game.printWarnings) {
                System.err.println("UnitControllerImpl.senseResourceInfo: Round " + this.getRound() + ": Unit " + this.getInfo().getID() + " can't sense location " + obj + ".");
            }
            ThreadManager.punish();
            return null;
        }
        final GameLocation gameLocation = new GameLocation(obj);
        if (this.world.isOutOfMap(gameLocation)) {
            return null;
        }
        if (this.world.getIns(gameLocation).getLuminosity() < this.unit.detectionLevel) {
            return null;
        }
        final Resource[] values = Resource.values();
        final ResourceInfo[] array = new ResourceInfo[values.length];
        for (final Resource resource : values) {
            array[resource.ordinal()] = this.world.getIns(gameLocation).getResource(resource);
        }
        return array;
    }
    
    @Override
    public boolean isOutOfMap(final Location obj) {
        this.sanityCheck();
        if (obj == null) {
            if (Game.printWarnings) {
                System.err.println("UnitControllerImpl.isOutOfMap: Round " + this.getRound() + ": Unit " + this.getInfo().getID() + " attempted to sense a null location.");
            }
            ThreadManager.punish();
            return true;
        }
        if (obj.distanceSquared(this.unit.getGameLocation().toLocation()) > this.unit.getVisionRange()) {
            if (Game.printWarnings) {
                System.err.println("UnitControllerImpl.isOutOfMap: Round " + this.getRound() + ": Unit " + this.getInfo().getID() + " location outside vision range " + obj + ".");
            }
            ThreadManager.punish();
            return false;
        }
        return this.world.isOutOfMap(new GameLocation(obj));
    }
    
    @Override
    public Location[] getVisibleLocations(int min, final boolean b) {
        this.sanityCheck();
        if (min < 0) {
            ThreadManager.punish();
            return new Location[0];
        }
        final Location location = this.getLocation();
        min = Math.min(min, this.unit.getVisionRange());
        final VisibleCells instance = VisibleCells.getInstance();
        final ArrayList<Location> list = new ArrayList<Location>();
        final GameLocation gameLocation = new GameLocation(location);
        for (int n = 0; n < instance.sortedLocs.length && instance.sortedLocs[n].norm() <= min; ++n) {
            final Location add = location.add(instance.sortedLocs[n].x, instance.sortedLocs[n].y);
            if (b) {
                if (this.world.isOutOfMap(new GameLocation(add))) {
                    continue;
                }
                if (this.world.getIns(gameLocation.add(instance.sortedLocs[n])).getLuminosity() < this.unit.detectionLevel) {
                    continue;
                }
            }
            list.add(add);
        }
        return list.toArray(new Location[list.size()]);
    }
    
    @Override
    public UnitInfo senseUnitAtLocation(final Location obj) {
        this.sanityCheck();
        if (obj == null) {
            if (Game.printWarnings) {
                System.err.println("UnitControllerImpl.senseUnitAtLocation: Round " + this.getRound() + ": Unit " + this.getInfo().getID() + " attempted to sense a null location.");
            }
            ThreadManager.punish();
            return null;
        }
        if (!this.canSenseLocationPrivate(obj, this.getType() == UnitType.WOLF)) {
            if (Game.printWarnings) {
                System.err.println("UnitControllerImpl.senseUnitAtLocation: Round " + this.getRound() + ": Unit " + this.getInfo().getID() + " can't sense location " + obj + ".");
            }
            ThreadManager.punish();
            return null;
        }
        final Unit unit = this.world.getIns(new GameLocation(obj)).getUnit();
        if (unit != null) {
            return unit.toUnitInfo();
        }
        return null;
    }
    
    @Override
    public boolean hasWater(final Location obj) {
        this.sanityCheck();
        if (obj == null) {
            if (Game.printWarnings) {
                System.err.println("UnitControllerImpl.hasWater: Round " + this.getRound() + ": Unit " + this.getInfo().getID() + " attempted to sense a null location.");
            }
            ThreadManager.punish();
            return false;
        }
        if (!this.canSenseLocationPrivate(obj, false)) {
            if (Game.printWarnings) {
                System.err.println("UnitControllerImpl.hasWater: Round " + this.getRound() + ": Unit " + this.getInfo().getID() + " cannot sense location " + obj + ".");
            }
            ThreadManager.punish();
            return false;
        }
        final GameLocation gameLocation = new GameLocation(obj);
        return this.world.getIns(gameLocation).getLuminosity() >= this.unit.detectionLevel && this.world.getIns(gameLocation).hasWater();
    }
    
    @Override
    public boolean hasMountain(final Location obj) {
        this.sanityCheck();
        if (obj == null) {
            if (Game.printWarnings) {
                System.err.println("UnitControllerImpl.hasMountain: Round " + this.getRound() + ": Unit " + this.getInfo().getID() + " attempted to sense a null location.");
            }
            ThreadManager.punish();
            return false;
        }
        if (!this.canSenseLocationPrivate(obj, false)) {
            if (Game.printWarnings) {
                System.err.println("UnitControllerImpl.hasMountain: Round " + this.getRound() + ": Unit " + this.getInfo().getID() + " cannot sense location " + obj + ".");
            }
            ThreadManager.punish();
            return false;
        }
        final GameLocation gameLocation = new GameLocation(obj);
        return this.world.getIns(gameLocation).getLuminosity() >= this.unit.detectionLevel && this.world.getIns(gameLocation).hasMountain();
    }
    
    @Override
    public boolean hasTrap(final Location obj) {
        this.sanityCheck();
        if (obj == null) {
            if (Game.printWarnings) {
                System.err.println("UnitControllerImpl.hasTrap: Round " + this.getRound() + ": Unit " + this.getInfo().getID() + " attempted to sense a null location.");
            }
            ThreadManager.punish();
            return false;
        }
        if (!this.canSenseLocationPrivate(obj, false)) {
            if (Game.printWarnings) {
                System.err.println("UnitControllerImpl.hasTrap: Round " + this.getRound() + ": Unit " + this.getInfo().getID() + " cannot sense location " + obj + ".");
            }
            ThreadManager.punish();
            return false;
        }
        final GameLocation gameLocation = new GameLocation(obj);
        return this.world.getIns(gameLocation).getLuminosity() >= this.unit.detectionLevel && this.world.getIns(gameLocation).hasTrap();
    }
    
    @Override
    public FireInfo senseFireAtLocation(final Location obj) {
        this.sanityCheck();
        if (obj == null) {
            if (Game.printWarnings) {
                System.err.println("UnitControllerImpl.senseFireAtLocation: Round " + this.getRound() + ": Unit " + this.getInfo().getID() + " attempted to sense a null location.");
            }
            ThreadManager.punish();
            return null;
        }
        if (!this.canSenseLocationPrivate(obj, false)) {
            if (Game.printWarnings) {
                System.err.println("UnitControllerImpl.senseFireAtLocation: Round " + this.getRound() + ": Unit " + this.getInfo().getID() + " cannot sense location " + obj + ".");
            }
            ThreadManager.punish();
            return null;
        }
        final GameLocation gameLocation = new GameLocation(obj);
        if (this.world.getIns(gameLocation).getLuminosity() < this.unit.detectionLevel) {
            return null;
        }
        return this.world.getIns(gameLocation).getFireInfo();
    }
    
    private UnitInfo[] senseUnitsPrivate(int min, final Team team) {
        if (min < 0) {
            ThreadManager.punish();
            if (Game.printWarnings) {
                System.err.println("UnitControllerImpl.senseUnitsPrivate: Round " + this.getRound() + ": Unit " + this.getInfo().getID() + " called with negative radius " + min + ".");
            }
            return new UnitInfo[0];
        }
        min = Math.min(min, this.unit.getVisionRange());
        final ArrayList<UnitInfo> list = new ArrayList<UnitInfo>();
        final GameLocation gameLocation = this.unit.getGameLocation();
        final VisibleCells instance = VisibleCells.getInstance();
        for (int n = 0; n < instance.sortedLocs.length && instance.sortedLocs[n].norm() <= min; ++n) {
            final Cell ins = this.world.getIns(gameLocation.add(instance.sortedLocs[n]));
            if (ins != null) {
                if (this.getType() == UnitType.WOLF || ins.getLuminosity() >= this.unit.detectionLevel) {
                    if (gameLocation.distanceSquared(ins.getGameLocation()) <= this.unit.getVisionRange()) {
                        final Unit unit = ins.getUnit();
                        if (unit != null) {
                            if (unit != this.unit) {
                                if (team == null) {
                                    list.add(unit.toUnitInfo());
                                }
                                else if (unit.getTeam() == team) {
                                    list.add(unit.toUnitInfo());
                                }
                            }
                        }
                    }
                }
            }
        }
        return list.toArray(new UnitInfo[list.size()]);
    }
    
    @Override
    public UnitInfo[] senseUnits(final int n, final Team team) {
        return this.senseUnitsPrivate(n, team);
    }
    
    @Override
    public UnitInfo[] senseUnits(final Team team) {
        return this.senseUnitsPrivate(this.unit.getVisionRange(), team);
    }
    
    @Override
    public ResourceInfo[] senseResources(int min, final Resource resource) {
        this.sanityCheck();
        if (min < 0) {
            ThreadManager.punish();
            if (Game.printWarnings) {
                System.err.println("UnitControllerImpl.senseResources: Round " + this.getRound() + ": Unit " + this.getInfo().getID() + " called with negative radius " + min + ".");
            }
            return new ResourceInfo[0];
        }
        min = Math.min(min, this.unit.getVisionRange());
        final ArrayList<ResourceInfo> list = new ArrayList<ResourceInfo>();
        final GameLocation gameLocation = this.unit.getGameLocation();
        final VisibleCells instance = VisibleCells.getInstance();
        for (int n = 0; n < instance.sortedLocs.length && instance.sortedLocs[n].norm() <= min; ++n) {
            final Cell ins = this.world.getIns(gameLocation.add(instance.sortedLocs[n]));
            if (ins != null) {
                if (ins.getLuminosity() >= this.unit.getDetectionLevel()) {
                    if (gameLocation.distanceSquared(ins.getGameLocation()) <= this.unit.getVisionRange()) {
                        if (resource == null) {
                            final ResourceInfo resource2 = ins.getResource(Resource.FOOD);
                            if (resource2 != null) {
                                list.add(resource2);
                            }
                            final ResourceInfo resource3 = ins.getResource(Resource.WOOD);
                            if (resource3 != null) {
                                list.add(resource3);
                            }
                            final ResourceInfo resource4 = ins.getResource(Resource.STONE);
                            if (resource4 != null) {
                                list.add(resource4);
                            }
                        }
                        else {
                            final ResourceInfo resource5 = ins.getResource(resource);
                            if (resource5 != null) {
                                list.add(resource5);
                            }
                        }
                    }
                }
            }
        }
        return list.toArray(new ResourceInfo[list.size()]);
    }
    
    @Override
    public Location[] senseMountains(int min) {
        this.sanityCheck();
        if (min < 0) {
            ThreadManager.punish();
            if (Game.printWarnings) {
                System.err.println("UnitControllerImpl.senseMountains: Round " + this.getRound() + ": Unit " + this.getInfo().getID() + " called with negative radius " + min + ".");
            }
            return new Location[0];
        }
        min = Math.min(min, this.unit.getVisionRange());
        final ArrayList<Location> list = new ArrayList<Location>();
        final GameLocation gameLocation = this.unit.getGameLocation();
        final VisibleCells instance = VisibleCells.getInstance();
        for (int n = 0; n < instance.sortedLocs.length && instance.sortedLocs[n].norm() <= min; ++n) {
            final GameLocation add = gameLocation.add(instance.sortedLocs[n]);
            final Cell ins = this.world.getIns(add);
            if (ins != null) {
                if (ins.getLuminosity() >= this.unit.detectionLevel) {
                    if (gameLocation.distanceSquared(ins.getGameLocation()) <= this.unit.getVisionRange()) {
                        if (ins.hasMountain()) {
                            list.add(add.toLocation());
                        }
                    }
                }
            }
        }
        return list.toArray(new Location[list.size()]);
    }
    
    @Override
    public FireInfo[] senseFires(int min) {
        this.sanityCheck();
        if (min < 0) {
            ThreadManager.punish();
            if (Game.printWarnings) {
                System.err.println("UnitControllerImpl.senseFires: Round " + this.getRound() + ": Unit " + this.getInfo().getID() + " called with negative radius " + min + ".");
            }
            return new FireInfo[0];
        }
        min = Math.min(min, this.unit.getVisionRange());
        final ArrayList<FireInfo> list = new ArrayList<FireInfo>();
        final GameLocation gameLocation = this.unit.getGameLocation();
        final VisibleCells instance = VisibleCells.getInstance();
        for (int n = 0; n < instance.sortedLocs.length && instance.sortedLocs[n].norm() <= min; ++n) {
            final Cell ins = this.world.getIns(gameLocation.add(instance.sortedLocs[n]));
            if (ins != null) {
                if (ins.getLuminosity() >= this.unit.detectionLevel) {
                    if (gameLocation.distanceSquared(ins.getGameLocation()) <= this.unit.getVisionRange()) {
                        if (ins.hasFire()) {
                            list.add(ins.getFireInfo());
                        }
                    }
                }
            }
        }
        return list.toArray(new FireInfo[list.size()]);
    }
    
    @Override
    public FireInfo[] senseFires() {
        return this.senseFires(this.unit.getVisionRange());
    }
    
    @Override
    public Location[] senseTraps(int min) {
        this.sanityCheck();
        if (min < 0) {
            ThreadManager.punish();
            if (Game.printWarnings) {
                System.err.println("UnitControllerImpl.senseTraps: Round " + this.getRound() + ": Unit " + this.getInfo().getID() + " called with negative radius " + min + ".");
            }
            return new Location[0];
        }
        min = Math.min(min, this.unit.getVisionRange());
        final ArrayList<Location> list = new ArrayList<Location>();
        final GameLocation gameLocation = this.unit.getGameLocation();
        final VisibleCells instance = VisibleCells.getInstance();
        for (int n = 0; n < instance.sortedLocs.length && instance.sortedLocs[n].norm() <= min; ++n) {
            final GameLocation add = gameLocation.add(instance.sortedLocs[n]);
            final Cell ins = this.world.getIns(add);
            if (ins != null) {
                if (ins.getLuminosity() >= this.unit.detectionLevel) {
                    if (gameLocation.distanceSquared(ins.getGameLocation()) <= this.unit.getVisionRange()) {
                        if (ins.hasTrap()) {
                            list.add(add.toLocation());
                        }
                    }
                }
            }
        }
        return list.toArray(new Location[list.size()]);
    }
    
    @Override
    public Location[] senseTraps() {
        return this.senseTraps(this.getType().getVisionRange());
    }
    
    @Override
    public Location[] senseWater(int min) {
        this.sanityCheck();
        if (min < 0) {
            ThreadManager.punish();
            if (Game.printWarnings) {
                System.err.println("UnitControllerImpl.senseWater: Round " + this.getRound() + ": Unit " + this.getInfo().getID() + " called with negative radius " + min + ".");
            }
            return new Location[0];
        }
        min = Math.min(min, this.unit.getVisionRange());
        final ArrayList<Location> list = new ArrayList<Location>();
        final GameLocation gameLocation = this.unit.getGameLocation();
        final VisibleCells instance = VisibleCells.getInstance();
        for (int n = 0; n < instance.sortedLocs.length && instance.sortedLocs[n].norm() <= min; ++n) {
            final GameLocation add = gameLocation.add(instance.sortedLocs[n]);
            final Cell ins = this.world.getIns(add);
            if (ins != null) {
                if (ins.getLuminosity() >= this.unit.detectionLevel) {
                    if (gameLocation.distanceSquared(ins.getGameLocation()) <= this.unit.getVisionRange()) {
                        if (ins.hasWater()) {
                            list.add(add.toLocation());
                        }
                    }
                }
            }
        }
        return list.toArray(new Location[list.size()]);
    }
    
    @Override
    public ResourceInfo[] senseResources() {
        return this.senseResources(this.unit.getVisionRange(), null);
    }
    
    @Override
    public Location[] senseMountains() {
        return this.senseMountains(this.unit.getVisionRange());
    }
    
    @Override
    public UnitInfo[] senseUnits(final int n) {
        return this.senseUnitsPrivate(n, null);
    }
    
    @Override
    public UnitInfo[] senseUnits() {
        return this.senseUnits(this.unit.getVisionRange());
    }
    
    @Override
    public Location[] getVisibleLocations() {
        return this.getVisibleLocations(this.unit.getVisionRange(), false);
    }
    
    @Override
    public Location[] getVisibleLocations(final boolean b) {
        return this.getVisibleLocations(this.unit.getVisionRange(), b);
    }
    
    private boolean canSpawn(final UnitType unitType, final UnitType unitType2) {
        switch (unitType2) {
            case WOLF: {
                if (!this.getTeamInfo().hasTech(Technology.DOMESTICATION)) {
                    return false;
                }
                return unitType == UnitType.BASE || unitType == UnitType.SETTLEMENT;
            }
            case WORKER:
            case TRAPPER:
            case EXPLORER: {
                return unitType == UnitType.BASE || unitType == UnitType.SETTLEMENT;
            }
            case AXEMAN:
            case SPEARMAN: {
                return unitType == UnitType.BARRACKS;
            }
            case FARM:
            case SAWMILL:
            case QUARRY: {
                if (!this.getTeamInfo().hasTech(Technology.JOBS)) {
                    return false;
                }
                return unitType == UnitType.WORKER;
            }
            case SETTLEMENT: {
                return unitType == UnitType.WORKER;
            }
            case BARRACKS: {
                return this.getTeamInfo().hasTech(Technology.MILITARY_TRAINING) && unitType == UnitType.WORKER;
            }
            default: {
                return false;
            }
        }
    }
    
    @Override
    public boolean canSpawn(final UnitType obj, final Direction obj2) {
        this.sanityCheck();
        if (obj2 == null || obj == null) {
            if (Game.printWarnings) {
                System.err.println("UnitControllerImpl.canSpawn: Round " + this.getRound() + ": Unit " + this.getInfo().getID() + " invalid parameters: unit type: " + obj + ", direction: " + obj2 + ".");
            }
            ThreadManager.punish();
            return false;
        }
        if (!this.unit.isReady()) {
            return false;
        }
        if (!this.canSpawn(this.unit.getType(), obj)) {
            return false;
        }
        if (this.getTotalUnits() >= this.getMaxTotalUnits()) {
            return false;
        }
        final GameLocation add = this.unit.getGameLocation().add(obj2);
        return this.world.getIns(add) != null && this.world.isAccessible(add, obj, null) && this.getTeamInfo().hasResource(obj.getFoodCost(), Resource.FOOD) && this.getTeamInfo().hasResource(obj.getWoodCost(), Resource.WOOD) && this.getTeamInfo().hasResource(obj.getStoneCost(), Resource.STONE);
    }
    
    @Override
    public void spawn(final UnitType obj, final Direction obj2) {
        this.sanityCheck();
        if (this.unit.isDead()) {
            return;
        }
        if (!this.canSpawn(obj, obj2)) {
            if (Game.printWarnings) {
                System.err.println("UnitControllerImpl.spawn: Round " + this.getRound() + ": Unit " + this.getInfo().getID() + " cannot spawn a " + obj + " in the direction " + obj2 + ".");
            }
            ThreadManager.punish();
            return;
        }
        this.getTeamInfo().addResources(-obj.getWoodCost(), Resource.WOOD);
        this.getTeamInfo().addResources(-obj.getStoneCost(), Resource.STONE);
        this.getTeamInfo().addResources(-obj.getFoodCost(), Resource.FOOD);
        if (this.getTeamInfo().hasTech(Technology.TACTICS)) {
            this.getTeamInfo().addResources(0 * obj.getWoodCost(), Resource.WOOD);
            this.getTeamInfo().addResources(0 * obj.getStoneCost(), Resource.STONE);
            this.getTeamInfo().addResources(0 * obj.getFoodCost(), Resource.FOOD);
        }
        this.unit.getScheduleManager().createUnit(this.unit.getTeam(), this.unit.getGameLocation().add(obj2), this.unit, 10, obj);
        this.unit.spawn();
    }
    
    @Override
    public int getTotalUnits() {
        return this.world.nUnits[this.getTeam().ordinal()];
    }
    
    @Override
    public int getMaxTotalUnits() {
        int n = 75;
        if (this.getTeamInfo().hasTech(Technology.HUTS)) {
            n += 25;
        }
        if (this.getTeamInfo().hasTech(Technology.HOUSES)) {
            n += 25;
        }
        return n;
    }
    
    @Override
    public void killSelf() {
        this.sanityCheck();
        this.unit.kill();
    }
    
    @Override
    public boolean canGatherResources() {
        return this.unit.isReady() && !this.unit.hasGathered() && this.world.getIns(this.unit.gameLocation).getLuminosity() >= this.unit.detectionLevel && this.unit.getType() == UnitType.WORKER;
    }
    
    @Override
    public void gatherResources() {
        if (!this.canGatherResources()) {
            if (Game.printWarnings) {
                System.err.println("UnitControllerImpl.gatherResources: Round " + this.getRound() + ": Unit " + this.getInfo().getID() + " cannot gather food.");
            }
            ThreadManager.punish();
            return;
        }
        this.world.getIns(this.unit.getGameLocation()).gather(this.unit);
        this.unit.gather();
    }
    
    @Override
    public boolean canDeposit() {
        return this.unit.isReady() && this.unit.getType() == UnitType.WORKER && this.world.depositNearby(this.unit);
    }
    
    @Override
    public void deposit() {
        this.sanityCheck();
        if (!this.canDeposit()) {
            if (Game.printWarnings) {
                System.err.println("UnitControllerImpl.deposit: Round " + this.getRound() + ": Unit " + this.getInfo().getID() + " cannot deposit.");
            }
            ThreadManager.punish();
        }
        this.unit.depositResources();
    }
    
    @Override
    public boolean isAccessible(final Location obj) {
        this.sanityCheck();
        if (obj == null) {
            if (Game.printWarnings) {
                System.err.println("UnitControllerImpl.isAccessible: Round " + this.getRound() + ": Unit " + this.getInfo().getID() + " attempted to sense a null location.");
            }
            ThreadManager.punish();
            return false;
        }
        if (!this.canSenseLocation(obj)) {
            if (Game.printWarnings) {
                System.err.println("UnitControllerImpl.isAccessible: Round " + this.getRound() + ": Unit " + this.getInfo().getID() + " cannot sense location " + obj + ".");
            }
            ThreadManager.punish();
            return false;
        }
        final Cell ins = this.world.getIns(new GameLocation(obj));
        return ins != null && ins.getLuminosity() >= this.unit.detectionLevel && ins.isPassable(this.unit.getType(), this.getTeamInfo());
    }
    
    @Override
    public boolean canDisarm(final Location location) {
        this.sanityCheck();
        if (location == null) {
            if (Game.printWarnings) {
                System.err.println("UnitControllerImpl.canDisarm: Round " + this.getRound() + ": Unit " + this.getInfo().getID() + " called with a null location.");
            }
            ThreadManager.punish();
            return false;
        }
        if (this.getType() != UnitType.TRAPPER) {
            return false;
        }
        if (this.unit.hasDisarmed()) {
            return false;
        }
        final GameLocation gameLocation = new GameLocation(location);
        return !this.world.isOutOfMap(gameLocation) && gameLocation.distanceSquared(this.unit.getGameLocation()) <= this.unit.getAttackRange() && !this.isObstructed(this.unit.getGameLocation(), gameLocation);
    }
    
    @Override
    public void disarm(final Location obj) {
        this.sanityCheck();
        if (this.unit.isDead()) {
            return;
        }
        if (!this.canDisarm(obj)) {
            if (Game.printWarnings) {
                System.err.println("UnitControllerImpl.disarm: Round " + this.getRound() + ": Unit " + this.getInfo().getID() + " cannot disarm location " + obj + ".");
            }
            ThreadManager.punish();
            return;
        }
        this.world.getIns(new GameLocation(obj)).setTrap(false);
        this.unit.disarm();
    }
    
    @Override
    public boolean canDraw(final int n) {
        this.sanityCheck();
        if (this.world.getIns(this.unit.gameLocation).getLuminosity() < this.unit.detectionLevel) {
            return false;
        }
        if (this.getType().isStructure()) {
            return false;
        }
        if (this.getType() == UnitType.WOLF) {
            return false;
        }
        if (!this.getTeamInfo().hasTech(Technology.ROCK_ART)) {
            if (n < 0) {
                return false;
            }
            if (n > 100000) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public void draw(final int rockArtNum) {
        this.sanityCheck();
        if (this.unit.isDead()) {
            return;
        }
        if (!this.canDraw(rockArtNum)) {
            if (Game.printWarnings) {
                System.err.println("UnitControllerImpl.draw: Round " + this.getRound() + ": Unit " + this.getInfo().getID() + " cannot draw.");
            }
            ThreadManager.punish();
            return;
        }
        this.world.getIns(this.unit.gameLocation).setRockArtNum(rockArtNum);
    }
    
    @Override
    public boolean canRead(final Location location) {
        this.sanityCheck();
        if (location == null) {
            if (Game.printWarnings) {
                System.err.println("UnitControllerImpl.canRead: Round " + this.getRound() + ": Unit " + this.getInfo().getID() + " attempted to sense a null location.");
            }
            ThreadManager.punish();
            return false;
        }
        if (this.isOutOfMap(location)) {
            return false;
        }
        final GameLocation gameLocation = new GameLocation(location);
        return this.world.getIns(gameLocation) != null && this.world.getIns(gameLocation).getLuminosity() >= this.unit.detectionLevel && location.distanceSquared(this.unit.getGameLocation().toLocation()) <= this.unit.getVisionRange() && this.getType() != UnitType.WOLF;
    }
    
    @Override
    public int read(final Location obj) {
        this.sanityCheck();
        if (this.unit.isDead()) {
            return 0;
        }
        if (!this.canRead(obj)) {
            if (Game.printWarnings) {
                System.err.println("UnitControllerImpl.read: Round " + this.getRound() + ": Unit " + this.getInfo().getID() + " cannot read location " + obj + ".");
            }
            ThreadManager.punish();
            return 0;
        }
        return this.world.getIns(new GameLocation(obj)).getRockArt();
    }
    
    @Override
    public boolean canResearchTechnology(final Technology technology) {
        this.sanityCheck();
        if (technology == null) {
            if (Game.printWarnings) {
                System.err.println("UnitControllerImpl.canResearchTechnology: Round " + this.getRound() + ": Unit " + this.getInfo().getID() + " attempted to research a null technology.");
            }
            ThreadManager.punish();
            return false;
        }
        return this.getType() == UnitType.BASE && !this.getTeamInfo().hasTech(technology) && this.getTeamInfo().getTechLevel() >= technology.getLevelRequired() && this.getTeamInfo().hasResource(technology.getFoodCost(), Resource.FOOD) && this.getTeamInfo().hasResource(technology.getWoodCost(), Resource.WOOD) && this.getTeamInfo().hasResource(technology.getStoneCost(), Resource.STONE);
    }
    
    @Override
    public boolean isResearched(final Technology technology) {
        this.sanityCheck();
        if (technology == null) {
            if (Game.printWarnings) {
                System.err.println("UnitControllerImpl.isResearched: Round " + this.getRound() + ": Unit " + this.getInfo().getID() + " asked for a null technology.");
            }
            ThreadManager.punish();
            return false;
        }
        return this.getTeamInfo().hasTech(technology);
    }
    
    @Override
    public void researchTechnology(final Technology technology) {
        this.sanityCheck();
        if (this.unit.isDead()) {
            return;
        }
        if (!this.canResearchTechnology(technology)) {
            if (Game.printWarnings) {
                System.err.println("UnitControllerImpl.researchTechnology: Round " + this.getRound() + ": Unit " + this.getInfo().getID() + " cannot research technology " + technology.name() + ".");
            }
            ThreadManager.punish();
            return;
        }
        this.getTeamInfo().addResources(-technology.getFoodCost(), Resource.FOOD);
        this.getTeamInfo().addResources(-technology.getWoodCost(), Resource.WOOD);
        this.getTeamInfo().addResources(-technology.getStoneCost(), Resource.STONE);
        this.world.researchTech(this.getTeamInfo(), technology);
    }
    
    @Override
    public boolean canMakeSmokeSignal() {
        this.sanityCheck();
        if (this.unit.getCurrentAttackCooldown() >= 1.0f) {
            return false;
        }
        if (this.unit.getCurrentMoveCooldown() >= 1.0f) {
            return false;
        }
        boolean b = false;
        if (this.unit.torchIntensity > 0) {
            b = true;
        }
        if (this.unit.getType().getLuminousIntensity() > 0) {
            b = true;
        }
        return b;
    }
    
    @Override
    public void makeSmokeSignal(final int n) {
        this.sanityCheck();
        if (!this.canMakeSmokeSignal()) {
            if (Game.printWarnings) {
                System.err.println("UnitControllerImpl.makeSmokeSignal: Round " + this.getRound() + ": Unit " + this.getInfo().getID() + " cannot make smoke signal.");
            }
            ThreadManager.punish();
            return;
        }
        this.unit.makeSmokeSignal();
        this.world.addSignal(n);
        this.gameLog.writeSmokeInfo(this.unit.gameLocation, n);
    }
    
    @Override
    public boolean canReadSmokeSignals() {
        return this.getTeamInfo().hasTech(Technology.EUGENICS) || this.getType() != UnitType.WOLF;
    }
    
    @Override
    public int[] readSmokeSignals() {
        return this.world.getSmokeSignals();
    }
    
    @Override
    public int getRound() {
        return this.world.getRound();
    }
    
    @Override
    public int getEnergyUsed() {
        return this.unit.getBytecode();
    }
    
    @Override
    public int getEnergyLeft() {
        return 15000 - this.getEnergyUsed();
    }
    
    private double toPercentage(final double n) {
        return n / 15000.0;
    }
    
    @Override
    public double getPercentageOfEnergyLeft() {
        return this.toPercentage(this.getEnergyLeft());
    }
    
    @Override
    public double getPercentageOfEnergyUsed() {
        return this.toPercentage(this.getEnergyUsed());
    }
    
    @Override
    public void println(final Object x) {
        if (!Game.printWarnings) {
            return;
        }
        this.unit.sanityCheck(this);
        if (x == null) {
            System.err.println("Cannot print a null Object");
            ThreadManager.punish();
        }
        System.err.println(x);
        this.gameLog.writeAction(GameAction.DEBUG, this.unit.getTeam(), new Object[] { this.unit.getUnitId(), x.toString() });
    }
    
    private int toColorCoord(final int n) {
        if (n < 0) {
            return 0;
        }
        if (n >= 255) {
            return 255;
        }
        return n;
    }
    
    @Override
    public void drawPointDebug(final Location location, final int n, final int n2, final int n3) {
        this.unit.sanityCheck(this);
        if (!Game.printWarnings) {
            return;
        }
        if (location == null) {
            if (Game.printWarnings) {
                System.err.println("Cannot draw debug point at null Location");
            }
            ThreadManager.punish();
        }
        this.gameLog.writeAction(GameAction.DRAW_POINT, this.unit.getTeam(), new Object[] { this.unit.getUnitId(), new GameLocation(location), new Color(this.toColorCoord(n), this.toColorCoord(n2), this.toColorCoord(n3)) });
    }
    
    @Override
    public void drawLineDebug(final Location location, final Location location2, final int n, final int n2, final int n3) {
        this.unit.sanityCheck(this);
        if (!Game.printWarnings) {
            return;
        }
        if (location == null || location2 == null) {
            if (Game.printWarnings) {
                System.err.println("Cannot draw debug line at null Location");
            }
            ThreadManager.punish();
        }
        this.gameLog.writeAction(GameAction.DRAW_LINE, this.unit.getTeam(), new Object[] { this.unit.getUnitId(), new GameLocation(location), new GameLocation(location2), new Color(this.toColorCoord(n), this.toColorCoord(n2), this.toColorCoord(n3)) });
    }
    
    @Override
    public int getResource(final Resource resource) {
        return this.getTeamInfo().getResource(resource);
    }
    
    @Override
    public void yield() {
        this.sanityCheck();
        this.unit.pause();
    }
    
    @Override
    public double getRandomDouble() {
        return CustomRandom.getInstance().getRandom();
    }
    
    @Override
    public int getTechLevel(final Team team) {
        this.sanityCheck();
        if (team == null) {
            if (Game.printWarnings) {
                System.err.println("UnitControllerImpl.getTechLevel: Round " + this.getRound() + ": Unit " + this.getInfo().getID() + " null team as input.");
            }
            ThreadManager.punish();
            return 0;
        }
        if (team == this.getTeam()) {
            return this.getTeamInfo().getTechLevel();
        }
        if (team != this.getOpponent()) {
            return 0;
        }
        if (!this.getTeamInfo().hasTech(Technology.ROCK_ART)) {
            return 0;
        }
        return this.world.getTeamInfo(team).getTechLevel();
    }
    
    @Override
    public boolean hasResearched(final Technology technology, final Team team) {
        this.sanityCheck();
        if (team == null) {
            if (Game.printWarnings) {
                System.err.println("UnitControllerImpl.hasResearched: Round " + this.getRound() + ": Unit " + this.getInfo().getID() + " null team as input.");
            }
            ThreadManager.punish();
            return false;
        }
        if (technology == null) {
            if (Game.printWarnings) {
                System.err.println("UnitControllerImpl.hasResearched: Round " + this.getRound() + ": Unit " + this.getInfo().getID() + " null technology as input.");
            }
            ThreadManager.punish();
            return false;
        }
        if (team == this.getTeam()) {
            return this.getTeamInfo().hasTech(technology);
        }
        return team == this.getOpponent() && this.getTeamInfo().hasTech(Technology.ROCK_ART) && this.world.getTeamInfo(team).hasTech(technology);
    }
    
    private void attackLocation(final GameLocation gameLocation) {
        this.world.getIns(gameLocation).hit(this.unit);
        if (this.unit.type == UnitType.TRAPPER) {
            this.world.getIns(gameLocation).setTrap(true);
        }
    }
}
