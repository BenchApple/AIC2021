// 
// Decompiled by Procyon v0.5.36
// 

package aic2021.util;

public enum WinCondition
{
    DESTRUCTION("Destruction"), 
    TECHNOLOGY("Technology"), 
    TECHLEVEL("Technology Level Tiebreak"), 
    TECHRESOURCES("Technology Resources Tiebreak"), 
    TOTALRESOURCES("Total resources Tiebreak"), 
    RANDOM("Random"), 
    SINGLE_PLAYER("Single player"), 
    CHEATING("Opponent cheated!!!");
    
    public String condition;
    
    private WinCondition(final String condition) {
        this.condition = condition;
    }
}
