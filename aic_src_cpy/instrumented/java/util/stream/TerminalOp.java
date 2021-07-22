// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.stream;

import instrumented.java.util.Spliterator;
import aic2021.engine.BytecodeManager;

interface TerminalOp<E_IN, R>
{
    default StreamShape inputShape() {
        try {
            final StreamShape reference = StreamShape.REFERENCE;
            BytecodeManager.incBytecodes(2);
            return reference;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    default int getOpFlags() {
        try {
            final int n = 0;
            BytecodeManager.incBytecodes(2);
            return n;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    default <P_IN> R evaluateParallel(final PipelineHelper<E_IN> pipelineHelper, final Spliterator<P_IN> spliterator) {
        try {
            final boolean enabled = Tripwire.ENABLED;
            BytecodeManager.incBytecodes(2);
            if (enabled) {
                BytecodeManager.incBytecodes(2);
                final Class<? extends TerminalOp> class1 = this.getClass();
                final String s = "{0} triggering TerminalOp.evaluateParallel serial default";
                BytecodeManager.incBytecodes(2);
                Tripwire.trip(class1, s);
            }
            BytecodeManager.incBytecodes(4);
            final R evaluateSequential = this.evaluateSequential(pipelineHelper, (Spliterator<Object>)spliterator);
            BytecodeManager.incBytecodes(1);
            return evaluateSequential;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
     <P_IN> R evaluateSequential(final PipelineHelper<E_IN> p0, final Spliterator<P_IN> p1);
}
