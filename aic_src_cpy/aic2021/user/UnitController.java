// 
// Decompiled by Procyon v0.5.36
// 

package aic2021.user;

public interface UnitController
{
    UnitInfo getInfo();
    
    Location getLocation();
    
    Team getTeam();
    
    Team getOpponent();
    
    boolean canMove();
    
    boolean canAttack();
    
    int[] getResourcesCarried();
    
    UnitType getType();
    
    boolean canLightTorch();
    
    void lightTorch();
    
    boolean canMove(final Direction p0);
    
    void move(final Direction p0);
    
    boolean isObstructed(final Location p0, final Location p1);
    
    boolean canAttack(final Location p0);
    
    boolean canThrowTorch(final Location p0);
    
    void attack(final Location p0);
    
    void throwTorch(final Location p0);
    
    boolean canSenseLocation(final Location p0);
    
    ResourceInfo[] senseResourceInfo(final Location p0);
    
    boolean isOutOfMap(final Location p0);
    
    Location[] getVisibleLocations(final int p0, final boolean p1);
    
    Location[] getVisibleLocations(final boolean p0);
    
    UnitInfo senseUnitAtLocation(final Location p0);
    
    boolean hasWater(final Location p0);
    
    boolean hasMountain(final Location p0);
    
    boolean hasTrap(final Location p0);
    
    FireInfo senseFireAtLocation(final Location p0);
    
    int senseIllumination(final Location p0);
    
    UnitInfo[] senseUnits(final int p0, final Team p1);
    
    UnitInfo[] senseUnits(final Team p0);
    
    ResourceInfo[] senseResources(final int p0, final Resource p1);
    
    Location[] senseMountains(final int p0);
    
    Location[] senseTraps(final int p0);
    
    Location[] senseTraps();
    
    Location[] senseWater(final int p0);
    
    ResourceInfo[] senseResources();
    
    Location[] senseMountains();
    
    FireInfo[] senseFires(final int p0);
    
    FireInfo[] senseFires();
    
    UnitInfo[] senseUnits(final int p0);
    
    UnitInfo[] senseUnits();
    
    Location[] getVisibleLocations();
    
    int getTotalUnits();
    
    int getMaxTotalUnits();
    
    void killSelf();
    
    boolean canSpawn(final UnitType p0, final Direction p1);
    
    void spawn(final UnitType p0, final Direction p1);
    
    boolean canGatherResources();
    
    void gatherResources();
    
    boolean canDeposit();
    
    void deposit();
    
    boolean isAccessible(final Location p0);
    
    boolean canDisarm(final Location p0);
    
    void disarm(final Location p0);
    
    boolean canDraw(final int p0);
    
    void draw(final int p0);
    
    boolean canRead(final Location p0);
    
    int read(final Location p0);
    
    boolean canMakeSmokeSignal();
    
    void makeSmokeSignal(final int p0);
    
    boolean canReadSmokeSignals();
    
    boolean canResearchTechnology(final Technology p0);
    
    void researchTechnology(final Technology p0);
    
    boolean isResearched(final Technology p0);
    
    int[] readSmokeSignals();
    
    int getRound();
    
    int getEnergyUsed();
    
    int getEnergyLeft();
    
    double getPercentageOfEnergyLeft();
    
    double getPercentageOfEnergyUsed();
    
    void println(final Object p0);
    
    void drawPointDebug(final Location p0, final int p1, final int p2, final int p3);
    
    void drawLineDebug(final Location p0, final Location p1, final int p2, final int p3, final int p4);
    
    int getResource(final Resource p0);
    
    double getRandomDouble();
    
    int getTechLevel(final Team p0);
    
    boolean hasResearched(final Technology p0, final Team p1);
    
    void yield();
}
