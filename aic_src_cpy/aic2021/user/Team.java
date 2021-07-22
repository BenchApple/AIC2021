// 
// Decompiled by Procyon v0.5.36
// 

package aic2021.user;

public enum Team
{
    A, 
    B, 
    NEUTRAL;
    
    public Team getOpponent() {
        if (this == Team.A) {
            return Team.B;
        }
        if (this == Team.B) {
            return Team.A;
        }
        return this;
    }
}
