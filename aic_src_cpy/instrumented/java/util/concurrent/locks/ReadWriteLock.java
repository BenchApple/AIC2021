// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.concurrent.locks;

public interface ReadWriteLock
{
    Lock readLock();
    
    Lock writeLock();
}
