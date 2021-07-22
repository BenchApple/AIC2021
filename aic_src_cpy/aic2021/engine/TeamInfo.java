// 
// Decompiled by Procyon v0.5.36
// 

package aic2021.engine;

import aic2021.gamelogs.GameLog;
import aic2021.user.Technology;
import aic2021.user.Resource;
import aic2021.util.GameLocation;
import aic2021.user.Team;

public class TeamInfo
{
    Team team;
    TeamInfo opponent;
    String teamName;
    int[] resources;
    private GameLocation initialLocation;
    private Class<?> unitPlayerClass;
    int techLevel;
    boolean[] techs;
    int maxLevelTechs;
    
    public TeamInfo(final Team team, final GameLocation initialLocation, final String teamName, final boolean b) {
        this.unitPlayerClass = null;
        this.techLevel = 0;
        this.maxLevelTechs = 0;
        this.team = team;
        (this.resources = new int[Resource.values().length])[Resource.FOOD.ordinal()] = 100;
        this.resources[Resource.WOOD.ordinal()] = 100;
        this.resources[Resource.STONE.ordinal()] = 100;
        this.teamName = teamName;
        this.initialLocation = initialLocation;
        if (b) {
            this.unitPlayerClass = this.findUnitPlayerClass(teamName);
        }
        this.techs = new boolean[Technology.values().length];
    }
    
    public String getTeamName() {
        return this.teamName;
    }
    
    void setOpponent(final TeamInfo opponent) {
        this.opponent = opponent;
    }
    
    public Team getTeam() {
        return this.team;
    }
    
    private Class<?> findUnitPlayerClass(final String s) {
        final MyClassLoader myClassLoader = new MyClassLoader();
        Class<?> loadClass = null;
        try {
            loadClass = myClassLoader.loadClass(s + ".UnitPlayer");
        }
        catch (ClassNotFoundException x) {
            if (Game.printWarnings) {
                System.err.println(x);
                System.err.println("Error: UnitPlayer class not found for " + s);
            }
            System.exit(1);
        }
        return loadClass;
    }
    
    public void addResources(final int[] array) {
        for (int i = 0; i < array.length; ++i) {
            final int[] resources = this.resources;
            final int n = i;
            resources[n] += array[i];
        }
    }
    
    public void addResources(final int n, final Resource resource) {
        final int[] resources = this.resources;
        final int ordinal = resource.ordinal();
        resources[ordinal] += n;
    }
    
    public boolean hasResource(final int n, final Resource resource) {
        return this.resources[resource.ordinal()] >= n;
    }
    
    Class<?> getUnitPlayerClass() {
        return this.unitPlayerClass;
    }
    
    public int getResource(final Resource resource) {
        return this.resources[resource.ordinal()];
    }
    
    public int getTotalResources() {
        int n = 0;
        final Resource[] values = Resource.values();
        for (int length = values.length, i = 0; i < length; ++i) {
            n += this.resources[values[i].ordinal()];
        }
        return n;
    }
    
    void printResources(final GameLog gameLog) {
    }
    
    public int getTechLevel() {
        return this.techLevel;
    }
    
    public int getNTechs() {
        int n = 0;
        final boolean[] techs = this.techs;
        for (int length = techs.length, i = 0; i < length; ++i) {
            if (techs[i]) {
                ++n;
            }
        }
        return n;
    }
    
    boolean hasTech(final Technology technology) {
        return this.techs[technology.ordinal()];
    }
    
    void researchTech(final Technology technology) {
        this.techs[technology.ordinal()] = true;
        if (technology.getLevelRequired() == this.techLevel) {
            ++this.maxLevelTechs;
            if (this.maxLevelTechs >= 3) {
                this.maxLevelTechs = 0;
                ++this.techLevel;
            }
        }
        if (technology == Technology.SCHOOLS) {
            this.techLevel = 3;
        }
    }
    
    int getTechCosts() {
        int n = 0;
        for (final Technology technology : Technology.values()) {
            if (this.techs[technology.ordinal()]) {
                n = n + technology.getFoodCost() + technology.getWoodCost() + technology.getStoneCost();
            }
        }
        return n;
    }
}
