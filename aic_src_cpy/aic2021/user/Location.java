// 
// Decompiled by Procyon v0.5.36
// 

package aic2021.user;

import aic2021.engine.ThreadManager;
import aic2021.engine.Game;

public class Location
{
    public int x;
    public int y;
    
    public Location(final int x, final int y) {
        this.x = x;
        this.y = y;
    }
    
    public Location() {
        this.x = 0;
        this.y = 0;
    }
    
    public Location add(final Direction direction) {
        if (direction == null) {
            if (Game.warningsOn()) {
                System.err.println("Location.add: Trying to add a null direction to location " + this.toString() + ".");
            }
            ThreadManager.punish();
            return this;
        }
        return new Location(this.x + direction.dx, this.y + direction.dy);
    }
    
    public Location add(final int n, final int n2) {
        return new Location(this.x + n, this.y + n2);
    }
    
    public Direction directionTo(final Location location) {
        if (location == null) {
            if (Game.warningsOn()) {
                System.err.println("Location.directionTo: Trying to get the direction to a null Location.");
            }
            ThreadManager.punish();
            return Direction.ZERO;
        }
        return Direction.getDirection(location.x - this.x, location.y - this.y);
    }
    
    public boolean isEqual(final Location location) {
        return location != null && this.x == location.x && this.y == location.y;
    }
    
    public int distanceSquared(final Location location) {
        if (location == null) {
            if (Game.warningsOn()) {
                System.err.println("Location.distanceSquared: Trying to compute the distance to a null Location.");
            }
            ThreadManager.punish();
            return 0;
        }
        final int n = this.x - location.x;
        final int n2 = this.y - location.y;
        return n * n + n2 * n2;
    }
    
    @Override
    public String toString() {
        return "[" + this.x + "," + this.y + "]";
    }
}
