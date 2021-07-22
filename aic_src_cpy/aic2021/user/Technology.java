// 
// Decompiled by Procyon v0.5.36
// 

package aic2021.user;

public enum Technology
{
    DOMESTICATION(0), 
    MILITARY_TRAINING(0), 
    BOXES(0), 
    RAFTS(0), 
    ROCK_ART(0), 
    COIN(0), 
    UTENSILS(0), 
    SHARPENERS(1), 
    COOKING(1), 
    EUGENICS(1), 
    NAVIGATION(1), 
    JOBS(1), 
    OIL(1), 
    VOCABULARY(1), 
    HUTS(1), 
    TACTICS(1), 
    CRYSTALS(2), 
    COMBUSTION(2), 
    SCHOOLS(2), 
    POISON(2), 
    EXPERTISE(2), 
    FLINT(2), 
    HOUSES(2), 
    WHEEL(3);
    
    private final int levelRequired;
    private final int foodCost;
    private final int woodCost;
    private final int stoneCost;
    
    private Technology(final int levelRequired) {
        this.levelRequired = levelRequired;
        this.foodCost = GameConstants.TECHNOLOGY_FOOD_COSTS[this.ordinal()];
        this.woodCost = GameConstants.TECHNOLOGY_WOOD_COSTS[this.ordinal()];
        this.stoneCost = GameConstants.TECHNOLOGY_STONE_COSTS[this.ordinal()];
    }
    
    public int getLevelRequired() {
        return this.levelRequired;
    }
    
    public int getFoodCost() {
        return this.foodCost;
    }
    
    public int getWoodCost() {
        return this.woodCost;
    }
    
    public int getStoneCost() {
        return this.stoneCost;
    }
}
