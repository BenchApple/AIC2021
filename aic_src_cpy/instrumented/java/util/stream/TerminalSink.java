// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.stream;

import instrumented.java.util.function.Supplier;

interface TerminalSink<T, R> extends Sink<T>, Supplier<R>
{
}
