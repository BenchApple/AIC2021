// 
// Decompiled by Procyon v0.5.36
// 

package aic2021.user;

import aic2021.engine.Unit;

public class UnitInfo
{
    private final Team team;
    private final int health;
    private final Location location;
    private final float currentMovementCooldown;
    private final float currentAttackCooldown;
    private final int constructionTurns;
    private final int id;
    private final UnitType type;
    private final int attack;
    private final float movementCooldown;
    private final float attackCooldown;
    private final int maxHealth;
    private final int detectionLevel;
    private final int torchIntensity;
    private final int torchRounds;
    
    public UnitInfo(final Unit unit) {
        this.team = unit.getTeam();
        this.health = unit.getHealth();
        this.location = unit.getGameLocation().toLocation();
        this.currentAttackCooldown = unit.getCurrentAttackCooldown();
        this.currentMovementCooldown = unit.getCurrentMoveCooldown();
        this.constructionTurns = unit.getConstructionTurns();
        this.id = unit.getUnitId();
        this.type = unit.getType();
        this.attack = unit.getAttack();
        this.movementCooldown = unit.getMovementCooldown();
        this.attackCooldown = unit.getAttackCooldown();
        this.maxHealth = unit.getMaxHealth();
        this.detectionLevel = unit.getDetectionLevel();
        this.torchIntensity = unit.getTorchIntensity();
        this.torchRounds = unit.getTorchRounds();
    }
    
    public Team getTeam() {
        return this.team;
    }
    
    public UnitType getType() {
        return this.type;
    }
    
    public Location getLocation() {
        return this.location;
    }
    
    public int getHealth() {
        return this.health;
    }
    
    public float getCurrentMovementCooldown() {
        return this.currentMovementCooldown;
    }
    
    public float getCurrentAttackCooldown() {
        return this.currentAttackCooldown;
    }
    
    public int getID() {
        return this.id;
    }
    
    public boolean isBeingConstructed() {
        return this.constructionTurns > 0;
    }
    
    public int getConstructionTurns() {
        return this.constructionTurns;
    }
    
    public int getAttack() {
        return this.attack;
    }
    
    public int getMaxHealth() {
        return this.maxHealth;
    }
    
    public int getDetectionLevel() {
        return this.detectionLevel;
    }
    
    public float getMovementCooldown() {
        return this.movementCooldown;
    }
    
    public float getAttackCooldown() {
        return this.attackCooldown;
    }
    
    public int getTorchIntensity() {
        return this.torchIntensity;
    }
    
    public int getTorchRounds() {
        return this.torchRounds;
    }
}
