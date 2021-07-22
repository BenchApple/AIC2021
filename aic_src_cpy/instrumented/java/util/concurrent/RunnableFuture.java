// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.concurrent;

public interface RunnableFuture<V> extends Runnable, Future<V>
{
    void run();
}
