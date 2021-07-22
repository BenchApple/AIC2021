// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.concurrent;

@FunctionalInterface
public interface Callable<V>
{
    V call() throws Exception;
}
