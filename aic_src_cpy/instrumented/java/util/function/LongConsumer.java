// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.function;

import instrumented.java.util.Objects;
import aic2021.engine.BytecodeManager;

@FunctionalInterface
public interface LongConsumer
{
    void accept(final long p0);
    
    default LongConsumer andThen(final LongConsumer longConsumer) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(longConsumer);
            BytecodeManager.incBytecodes(1);
            final LongConsumer longConsumer2 = n -> {
                try {
                    BytecodeManager.incBytecodes(3);
                    this.accept(n);
                    BytecodeManager.incBytecodes(3);
                    longConsumer.accept(n);
                    BytecodeManager.incBytecodes(1);
                    return;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            BytecodeManager.incBytecodes(3);
            return longConsumer2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
