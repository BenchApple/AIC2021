// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.function;

import instrumented.java.util.Objects;
import aic2021.engine.BytecodeManager;

@FunctionalInterface
public interface BiConsumer<T, U>
{
    void accept(final T p0, final U p1);
    
    default BiConsumer<T, U> andThen(final BiConsumer<? super T, ? super U> biConsumer) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(biConsumer);
            BytecodeManager.incBytecodes(1);
            final BiConsumer<T, U> biConsumer2 = (t, u) -> {
                try {
                    BytecodeManager.incBytecodes(4);
                    this.accept(t, u);
                    BytecodeManager.incBytecodes(4);
                    biConsumer.accept((Object)t, (Object)u);
                    BytecodeManager.incBytecodes(1);
                    return;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            BytecodeManager.incBytecodes(3);
            return biConsumer2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
