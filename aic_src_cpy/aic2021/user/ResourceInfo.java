// 
// Decompiled by Procyon v0.5.36
// 

package aic2021.user;

public class ResourceInfo
{
    public Resource resourceType;
    public int amount;
    public Location location;
    
    public ResourceInfo(final Resource resourceType, final int amount, final Location location) {
        this.resourceType = resourceType;
        this.amount = amount;
        this.location = location;
    }
    
    public Resource getResourceType() {
        return this.resourceType;
    }
    
    public int getAmount() {
        return this.amount;
    }
    
    public Location getLocation() {
        return this.location;
    }
}
