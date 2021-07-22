// 
// Decompiled by Procyon v0.5.36
// 

package aic2021.engine;

import aic2021.user.FireInfo;
import aic2021.user.ResourceInfo;
import aic2021.user.GameConstants;
import aic2021.user.Technology;
import aic2021.util.random.SymmetricEnum;
import aic2021.util.random.SymmetricRandomDualQueue;
import aic2021.user.UnitType;
import java.util.Iterator;
import java.util.Collection;
import java.util.HashSet;
import aic2021.user.Resource;
import java.util.TreeSet;
import java.util.HashMap;
import aic2021.util.random.SymmetricRandom;
import aic2021.util.GameLocation;

public class Cell
{
    private World world;
    private Unit unit;
    final GameLocation gameLocation;
    int[] resources;
    boolean mountain;
    boolean water;
    int fireRounds;
    int fireIntensity;
    boolean hasTrap;
    boolean checked;
    SymmetricRandom rand;
    int rockArtNum;
    HashMap<Integer, Integer> sourceToIntensity;
    TreeSet<Integer> lIntensities;
    
    Cell(final World world, final GameLocation gameLocation) {
        this.resources = new int[Resource.values().length];
        this.mountain = false;
        this.water = false;
        this.fireRounds = 0;
        this.fireIntensity = 0;
        this.hasTrap = false;
        this.checked = false;
        this.rand = new SymmetricRandom();
        this.rockArtNum = 0;
        this.sourceToIntensity = new HashMap<Integer, Integer>();
        this.lIntensities = new TreeSet<Integer>();
        this.unit = null;
        this.world = world;
        this.gameLocation = gameLocation;
    }
    
    public int getLuminosity() {
        if (this.lIntensities.size() == 0) {
            return 0;
        }
        return this.lIntensities.last() >>> 20;
    }
    
    int getOpacity() {
        if (this.hasMountain()) {
            return 100;
        }
        if (this.resources[Resource.WOOD.ordinal()] > 0) {
            return 2;
        }
        return 1;
    }
    
    int encode(final GameLocation gameLocation, final int n) {
        return gameLocation.encode() << 1 | n;
    }
    
    void addLuminosity(final GameLocation gameLocation, final int i, final int n) {
        final int encode = this.encode(gameLocation, n);
        if (this.sourceToIntensity.keySet().contains(encode)) {
            System.err.println("ERROR when adding light: source already existed!");
        }
        this.sourceToIntensity.put(encode, i);
        this.lIntensities.add(i << 20 | encode);
    }
    
    int getLuminosity(final GameLocation gameLocation, final int n) {
        return this.sourceToIntensity.get(this.encode(gameLocation, n));
    }
    
    void removeLuminosity(final GameLocation gameLocation, final int n) {
        final int encode = this.encode(gameLocation, n);
        final Integer n2 = this.sourceToIntensity.get(encode);
        if (n2 == null) {
            System.err.println("ERROR when removing light: source didn't exist");
            return;
        }
        this.lIntensities.remove(n2 << 20 | encode);
        this.sourceToIntensity.remove(encode);
    }
    
    void setRockArtNum(final int rockArtNum) {
        this.rockArtNum = rockArtNum;
    }
    
    public int getRockArt() {
        return this.rockArtNum;
    }
    
    void putFire(final int fireRounds, final int fireIntensity) {
        final boolean b = this.fireIntensity == 0;
        this.fireRounds = fireRounds;
        this.fireIntensity = fireIntensity;
        if (b) {
            this.world.addSource(fireIntensity, this.gameLocation, 0);
        }
    }
    
    void addMountain() {
        this.mountain = true;
    }
    
    public boolean hasFire() {
        return this.fireIntensity > 0;
    }
    
    public boolean hasMountain() {
        return this.mountain;
    }
    
    public boolean hasWater() {
        return this.water;
    }
    
    public boolean hasTrap() {
        return this.hasTrap;
    }
    
    public void removeTrap() {
        this.hasTrap = false;
    }
    
    void setTrap(final boolean hasTrap) {
        this.hasTrap = hasTrap;
    }
    
    void addWater() {
        this.water = true;
    }
    
    void addResource(final Resource resource, final int n) {
        this.resources[resource.ordinal()] = n;
    }
    
    public GameLocation getGameLocation() {
        return this.gameLocation;
    }
    
    void recalculateIllum() {
        for (final Integer n : new HashSet<Integer>(this.sourceToIntensity.keySet())) {
            final int n2 = n >>> 1;
            final int n3 = n & 0x1;
            final GameLocation gameLocation = new GameLocation(n2);
            final int luminosity = this.world.getIns(gameLocation).getLuminosity(gameLocation, n3);
            this.world.removeSource(luminosity, gameLocation, n3);
            this.world.addSource(luminosity, gameLocation, n3);
        }
    }
    
    void check() {
        final int[] resources = this.resources;
        final int ordinal = Resource.FOOD.ordinal();
        resources[ordinal] -= 2;
        if (this.resources[Resource.FOOD.ordinal()] < 0) {
            this.resources[Resource.FOOD.ordinal()] = 0;
        }
        --this.fireRounds;
        if (this.fireRounds < 0) {
            this.fireRounds = 0;
        }
        if (this.fireRounds == 0 && this.fireIntensity > 0) {
            this.world.removeSource(this.fireIntensity, this.gameLocation, 0);
            this.fireIntensity = 0;
        }
        final double doubleValue = this.rand.poll();
        if (this.getLuminosity() <= 6 && doubleValue < 1.0E-4 && this.isAccessible(UnitType.DEER, null)) {
            this.world.putDeer(this.gameLocation);
            final Cell symmetric = this.world.getSymmetric(this.gameLocation);
            if (symmetric.unit == null) {
                return;
            }
            if (symmetric.unit.type != UnitType.DEER) {
                return;
            }
            if (symmetric.unit.getRoundCreated() != this.unit.getRoundCreated()) {
                return;
            }
            final SymmetricRandomDualQueue symmetricRandomDualQueue = new SymmetricRandomDualQueue();
            this.unit.rand.setDual(symmetricRandomDualQueue, SymmetricEnum.NON_SYMMETRIC);
            symmetric.unit.rand.setDual(symmetricRandomDualQueue, SymmetricEnum.SYMMETRIC);
        }
    }
    
    public void hit(final Unit unit) {
        final int attack = unit.getAttack();
        if (this.unit != null) {
            this.unit.receiveDamage((float)attack, unit.getTeamInfo());
        }
    }
    
    public boolean isPassable(final UnitType unitType, final TeamInfo teamInfo) {
        return !this.mountain && (!this.water || (teamInfo != null && teamInfo.hasTech(Technology.RAFTS)));
    }
    
    public Unit getUnit() {
        return this.unit;
    }
    
    void setUnit(final Unit unit) {
        this.unit = unit;
    }
    
    public boolean isAccessible(final UnitType unitType, final TeamInfo teamInfo) {
        return this.isPassable(unitType, teamInfo) && this.unit == null;
    }
    
    public void gather(final Unit unit) {
        final boolean b = this.resources[Resource.WOOD.ordinal()] > 0;
        for (int i = 0; i < this.resources.length; ++i) {
            if (this.resources[i] > 0) {
                int n = 100;
                if (unit.getTeamInfo().hasTech(Technology.BOXES)) {
                    n = 200;
                }
                int a = GameConstants.RESOURCES_WORKER_ROUND;
                if (unit.getTeamInfo().hasTech(Technology.UTENSILS)) {
                    a = GameConstants.RESOURCES_WORKER_ROUND_UTENSILS;
                }
                final int min = Math.min(Math.min(a, this.resources[i]), n - unit.getResource(i));
                if (min >= 0) {
                    final int[] resources = this.resources;
                    final int n2 = i;
                    resources[n2] -= min;
                    unit.addResource(i, min);
                }
            }
        }
        final boolean b2 = this.resources[Resource.WOOD.ordinal()] > 0;
        if (b && !b2) {
            this.recalculateIllum();
        }
    }
    
    ResourceInfo getResource(final Resource resource) {
        if (this.resources[resource.ordinal()] > 0) {
            return new ResourceInfo(resource, this.resources[resource.ordinal()], this.gameLocation.toLocation());
        }
        return null;
    }
    
    public FireInfo getFireInfo() {
        if (this.hasFire()) {
            return new FireInfo(this.fireRounds, this.fireIntensity, this.gameLocation.toLocation());
        }
        return null;
    }
    
    public ResourceInfo getFoodInfo() {
        if (this.resources[Resource.FOOD.ordinal()] > 0) {
            return new ResourceInfo(Resource.FOOD, this.resources[Resource.FOOD.ordinal()], this.gameLocation.toLocation());
        }
        return null;
    }
    
    public ResourceInfo getWoodInfo() {
        if (this.resources[Resource.WOOD.ordinal()] > 0) {
            return new ResourceInfo(Resource.WOOD, this.resources[Resource.WOOD.ordinal()], this.gameLocation.toLocation());
        }
        return null;
    }
    
    public ResourceInfo getStoneInfo() {
        if (this.resources[Resource.STONE.ordinal()] > 0) {
            return new ResourceInfo(Resource.STONE, this.resources[Resource.STONE.ordinal()], this.gameLocation.toLocation());
        }
        return null;
    }
    
    int[] getResources() {
        final int[] array = new int[this.resources.length];
        for (int i = 0; i < this.resources.length; ++i) {
            array[i] = this.resources[i];
        }
        return array;
    }
    
    public boolean isObstructed() {
        return this.mountain;
    }
}
