// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import aic2021.engine.BytecodeManager;

public abstract class Dictionary<K, V>
{
    public Dictionary() {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public abstract int size();
    
    public abstract boolean isEmpty();
    
    public abstract Enumeration<K> keys();
    
    public abstract Enumeration<V> elements();
    
    public abstract V get(final Object p0);
    
    public abstract V put(final K p0, final V p1);
    
    public abstract V remove(final Object p0);
}
