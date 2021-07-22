// 
// Decompiled by Procyon v0.5.36
// 

package aic2021.util;

import aic2021.user.Direction;
import aic2021.user.Location;

public class GameLocation
{
    public int x;
    public int y;
    Integer norm;
    Integer luminosityNorm;
    public static int offsetX;
    public static int offsetY;
    
    public Location toLocation() {
        return new Location(this.x + GameLocation.offsetX, this.y + GameLocation.offsetY);
    }
    
    public GameLocation() {
        this.norm = null;
        this.luminosityNorm = null;
    }
    
    public GameLocation(final Location location) {
        this.norm = null;
        this.luminosityNorm = null;
        if (location != null) {
            this.x = location.x - GameLocation.offsetX;
            this.y = location.y - GameLocation.offsetY;
        }
    }
    
    public GameLocation(final int x, final int y) {
        this.norm = null;
        this.luminosityNorm = null;
        this.x = x;
        this.y = y;
    }
    
    public GameLocation add(final Direction direction) {
        if (direction == null) {
            return this;
        }
        return new GameLocation(this.x + direction.dx, this.y + direction.dy);
    }
    
    public GameLocation add(final GameLocation gameLocation) {
        return new GameLocation(this.x + gameLocation.x, this.y + gameLocation.y);
    }
    
    public GameLocation add(final int n, final int n2) {
        return new GameLocation(this.x + n, this.y + n2);
    }
    
    public Direction directionTo(final GameLocation gameLocation) {
        if (gameLocation == null) {
            return Direction.ZERO;
        }
        return Direction.getDirection(gameLocation.x - this.x, gameLocation.y - this.y);
    }
    
    public int norm() {
        if (this.norm != null) {
            return this.norm;
        }
        this.norm = this.x * this.x + this.y * this.y;
        return this.norm;
    }
    
    public int luminosityNorm() {
        if (this.luminosityNorm != null) {
            return this.luminosityNorm;
        }
        final int min = Math.min(Math.abs(this.x), Math.abs(this.y));
        this.luminosityNorm = 3 * min + 2 * (Math.max(Math.abs(this.x), Math.abs(this.y)) - min);
        return this.luminosityNorm;
    }
    
    public boolean isEqual(final GameLocation gameLocation) {
        return gameLocation != null && this.x == gameLocation.x && this.y == gameLocation.y;
    }
    
    public int distanceSquared(final GameLocation gameLocation) {
        if (gameLocation == null) {
            return 0;
        }
        final int n = this.x - gameLocation.x;
        final int n2 = this.y - gameLocation.y;
        return n * n + n2 * n2;
    }
    
    public String toJson() {
        return "{x:" + this.x + ",y:" + this.y + "}";
    }
    
    @Override
    public String toString() {
        return this.toJson();
    }
    
    public int encode() {
        return this.x * 50 + this.y;
    }
    
    public GameLocation(final int n) {
        this.norm = null;
        this.luminosityNorm = null;
        this.x = n / 50;
        this.y = n % 50;
    }
}
