// 
// Decompiled by Procyon v0.5.36
// 

package aic2021.user;

public enum Direction
{
    NORTH(0, 1), 
    NORTHWEST(-1, 1), 
    WEST(-1, 0), 
    SOUTHWEST(-1, -1), 
    SOUTH(0, -1), 
    SOUTHEAST(1, -1), 
    EAST(1, 0), 
    NORTHEAST(1, 1), 
    ZERO(0, 0);
    
    public final int dx;
    public final int dy;
    private Integer lumNorm;
    private Float norm;
    
    private Direction(final int n, final int n2) {
        this.lumNorm = null;
        this.norm = null;
        this.dx = (int)Math.signum((float)n);
        this.dy = (int)Math.signum((float)n2);
    }
    
    public boolean isEqual(final Direction direction) {
        return direction != null && direction.dx == this.dx && direction.dy == this.dy;
    }
    
    public Direction rotateLeft() {
        if (this.ordinal() == 8) {
            return this;
        }
        if (this.ordinal() == 7) {
            return values()[0];
        }
        return values()[this.ordinal() + 1];
    }
    
    public Direction rotateRight() {
        if (this.ordinal() == 8) {
            return this;
        }
        if (this.ordinal() == 0) {
            return values()[7];
        }
        return values()[this.ordinal() - 1];
    }
    
    public Direction opposite() {
        if (this.ordinal() == 8) {
            return this;
        }
        if (this.ordinal() >= 4) {
            return values()[this.ordinal() - 4];
        }
        return values()[this.ordinal() + 4];
    }
    
    public float length() {
        if (this.norm == null) {
            this.norm = (float)Math.sqrt(this.dx * this.dx + this.dy * this.dy);
        }
        return this.norm;
    }
    
    public static Direction getDirection(int n, int n2) {
        n = (int)Math.signum((float)n);
        n2 = (int)Math.signum((float)n2);
        if (n == 0 && n2 == 1) {
            return Direction.NORTH;
        }
        if (n == -1 && n2 == 1) {
            return Direction.NORTHWEST;
        }
        if (n == -1 && n2 == 0) {
            return Direction.WEST;
        }
        if (n == -1 && n2 == -1) {
            return Direction.SOUTHWEST;
        }
        if (n == 0 && n2 == -1) {
            return Direction.SOUTH;
        }
        if (n == 1 && n2 == -1) {
            return Direction.SOUTHEAST;
        }
        if (n == 1 && n2 == 0) {
            return Direction.EAST;
        }
        if (n == 1 && n2 == 1) {
            return Direction.NORTHEAST;
        }
        return Direction.ZERO;
    }
    
    public int luminosityLength() {
        if (this.lumNorm == null) {
            final float length = this.length();
            if (length > 1.0f) {
                this.lumNorm = 3;
            }
            else if (length > 0.5) {
                this.lumNorm = 2;
            }
            else {
                this.lumNorm = 0;
            }
        }
        return this.lumNorm;
    }
}
