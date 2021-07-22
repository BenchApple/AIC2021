// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.function;

import instrumented.java.util.Objects;
import aic2021.engine.BytecodeManager;

@FunctionalInterface
public interface Consumer<T>
{
    void accept(final T p0);
    
    default Consumer<T> andThen(final Consumer<? super T> consumer) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(consumer);
            BytecodeManager.incBytecodes(1);
            final Consumer<T> consumer2 = t -> {
                try {
                    BytecodeManager.incBytecodes(3);
                    this.accept(t);
                    BytecodeManager.incBytecodes(3);
                    consumer.accept((Object)t);
                    BytecodeManager.incBytecodes(1);
                    return;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            BytecodeManager.incBytecodes(3);
            return consumer2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
