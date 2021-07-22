// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.function;

import instrumented.java.util.Objects;
import aic2021.engine.BytecodeManager;

@FunctionalInterface
public interface IntConsumer
{
    void accept(final int p0);
    
    default IntConsumer andThen(final IntConsumer intConsumer) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(intConsumer);
            BytecodeManager.incBytecodes(1);
            final IntConsumer intConsumer2 = n -> {
                try {
                    BytecodeManager.incBytecodes(3);
                    this.accept(n);
                    BytecodeManager.incBytecodes(3);
                    intConsumer.accept(n);
                    BytecodeManager.incBytecodes(1);
                    return;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            BytecodeManager.incBytecodes(3);
            return intConsumer2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
