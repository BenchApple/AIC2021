// 
// Decompiled by Procyon v0.5.36
// 

package aic2021.user;

public enum UnitType
{
    BASE, 
    WORKER, 
    SETTLEMENT, 
    BARRACKS, 
    FARM, 
    SAWMILL, 
    QUARRY, 
    EXPLORER, 
    TRAPPER, 
    AXEMAN, 
    SPEARMAN, 
    WOLF, 
    DEER;
    
    public final int maxHealth;
    public final int woodCost;
    public final int foodCost;
    public final int stoneCost;
    public final int attackRange;
    public final int minAttackRange;
    public final int attack;
    public final float attackCooldown;
    public final int visionRange;
    public final int movementRange;
    public final float movementCooldown;
    public final int detectionLevel;
    public final int luminousIntensity;
    public final int torchThrowRange;
    
    private UnitType() {
        this.maxHealth = GameConstants.MAX_HP_UNITS[this.ordinal()];
        this.woodCost = GameConstants.WOOD_UNIT_COSTS[this.ordinal()];
        this.foodCost = GameConstants.FOOD_UNIT_COSTS[this.ordinal()];
        this.stoneCost = GameConstants.STONE_UNIT_COSTS[this.ordinal()];
        this.attack = GameConstants.ATTACK_UNITS[this.ordinal()];
        this.attackRange = GameConstants.ATTACK_RANGE_UNITS[this.ordinal()];
        this.attackCooldown = GameConstants.ATTACK_COOLDOWN_UNITS[this.ordinal()];
        this.minAttackRange = GameConstants.MIN_ATTACK_RANGE_UNITS[this.ordinal()];
        this.visionRange = GameConstants.VIISON_RANGE_UNITS[this.ordinal()];
        this.movementRange = GameConstants.MOVEMENT_RANGE[this.ordinal()];
        this.movementCooldown = GameConstants.MOVEMENT_COOLDOWN_UNITS[this.ordinal()];
        this.detectionLevel = GameConstants.DETECTION_LEVEL[this.ordinal()];
        this.luminousIntensity = GameConstants.LUMINOUS_INTENSITY_UNITS[this.ordinal()];
        this.torchThrowRange = GameConstants.TORCH_THROW_RANGE[this.ordinal()];
    }
    
    public int getAttack() {
        return this.attack;
    }
    
    public float getAttackCooldown() {
        return this.attackCooldown;
    }
    
    public int getAttackRange() {
        return this.attackRange;
    }
    
    public int getMinAttackRange() {
        return this.minAttackRange;
    }
    
    public int getMaxHealth() {
        return this.maxHealth;
    }
    
    public int getWoodCost() {
        return this.woodCost;
    }
    
    public int getFoodCost() {
        return this.foodCost;
    }
    
    public int getStoneCost() {
        return this.stoneCost;
    }
    
    public int getTotalCost() {
        return this.stoneCost + this.woodCost + this.foodCost;
    }
    
    public int getVisionRange() {
        return this.visionRange;
    }
    
    public int getMovementRange() {
        return this.movementRange;
    }
    
    public float getMovementCooldown() {
        return this.movementCooldown;
    }
    
    public int getDetectionLevel() {
        return this.detectionLevel;
    }
    
    public int getLuminousIntensity() {
        return this.luminousIntensity;
    }
    
    public int getTorchThrowRange() {
        return this.torchThrowRange;
    }
    
    public boolean canMove() {
        return this.movementRange > 0;
    }
    
    public boolean canAttack() {
        return this.attack > 0 || this == UnitType.TRAPPER;
    }
    
    public boolean isStructure() {
        return this.movementRange <= 0;
    }
}
