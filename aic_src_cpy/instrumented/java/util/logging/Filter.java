// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.logging;

@FunctionalInterface
public interface Filter
{
    boolean isLoggable(final LogRecord p0);
}
