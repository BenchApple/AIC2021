// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.function;

import instrumented.java.util.Objects;
import aic2021.engine.BytecodeManager;

@FunctionalInterface
public interface DoubleConsumer
{
    void accept(final double p0);
    
    default DoubleConsumer andThen(final DoubleConsumer doubleConsumer) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(doubleConsumer);
            BytecodeManager.incBytecodes(1);
            final DoubleConsumer doubleConsumer2 = n -> {
                try {
                    BytecodeManager.incBytecodes(3);
                    this.accept(n);
                    BytecodeManager.incBytecodes(3);
                    doubleConsumer.accept(n);
                    BytecodeManager.incBytecodes(1);
                    return;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            BytecodeManager.incBytecodes(3);
            return doubleConsumer2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
