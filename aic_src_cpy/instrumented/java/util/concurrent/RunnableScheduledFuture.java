// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.concurrent;

public interface RunnableScheduledFuture<V> extends RunnableFuture<V>, ScheduledFuture<V>
{
    boolean isPeriodic();
}
