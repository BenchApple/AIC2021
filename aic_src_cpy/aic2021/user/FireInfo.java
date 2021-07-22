// 
// Decompiled by Procyon v0.5.36
// 

package aic2021.user;

public class FireInfo
{
    public int duration;
    public int intensity;
    public Location location;
    
    public FireInfo(final int duration, final int intensity, final Location location) {
        this.duration = duration;
        this.intensity = intensity;
        this.location = location;
    }
    
    public int getDuration() {
        return this.duration;
    }
    
    public int getIntensity() {
        return this.intensity;
    }
    
    public Location getLocation() {
        return this.location;
    }
}
