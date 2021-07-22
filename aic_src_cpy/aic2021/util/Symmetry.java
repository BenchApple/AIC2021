// 
// Decompiled by Procyon v0.5.36
// 

package aic2021.util;

import aic2021.user.Direction;

public enum Symmetry
{
    HORIZONTAL("horizontal"), 
    VERTICAL("vertical"), 
    ROTATIONAL("rotational");
    
    public String symName;
    
    public Direction getSymmetric(final Direction direction) {
        switch (this) {
            case VERTICAL: {
                return Direction.getDirection(direction.dx, -direction.dy);
            }
            case HORIZONTAL: {
                return Direction.getDirection(-direction.dx, direction.dy);
            }
            default: {
                return Direction.getDirection(-direction.dx, -direction.dy);
            }
        }
    }
    
    private Symmetry(final String symName) {
        this.symName = symName;
    }
}
