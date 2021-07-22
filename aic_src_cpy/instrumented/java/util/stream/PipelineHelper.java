// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.stream;

import instrumented.java.util.function.IntFunction;
import instrumented.java.util.Spliterator;
import aic2021.engine.BytecodeManager;

abstract class PipelineHelper<P_OUT>
{
    PipelineHelper() {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    abstract StreamShape getSourceShape();
    
    abstract int getStreamAndOpFlags();
    
    abstract <P_IN> long exactOutputSizeIfKnown(final Spliterator<P_IN> p0);
    
    abstract <P_IN, S extends Sink<P_OUT>> S wrapAndCopyInto(final S p0, final Spliterator<P_IN> p1);
    
    abstract <P_IN> void copyInto(final Sink<P_IN> p0, final Spliterator<P_IN> p1);
    
    abstract <P_IN> void copyIntoWithCancel(final Sink<P_IN> p0, final Spliterator<P_IN> p1);
    
    abstract <P_IN> Sink<P_IN> wrapSink(final Sink<P_OUT> p0);
    
    abstract <P_IN> Spliterator<P_OUT> wrapSpliterator(final Spliterator<P_IN> p0);
    
    abstract Node.Builder<P_OUT> makeNodeBuilder(final long p0, final IntFunction<P_OUT[]> p1);
    
    abstract <P_IN> Node<P_OUT> evaluate(final Spliterator<P_IN> p0, final boolean p1, final IntFunction<P_OUT[]> p2);
}
