// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.function;

import instrumented.java.util.Objects;
import aic2021.engine.BytecodeManager;

@FunctionalInterface
public interface BiFunction<T, U, R>
{
    R apply(final T p0, final U p1);
    
    default <V> BiFunction<T, U, V> andThen(final Function<? super R, ? extends V> function) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(function);
            BytecodeManager.incBytecodes(1);
            final R r;
            final R r2;
            final BiFunction<T, U, V> biFunction = (t, u) -> {
                try {
                    BytecodeManager.incBytecodes(5);
                    this.apply(t, u);
                    BytecodeManager.incBytecodes(1);
                    function.apply(r);
                    BytecodeManager.incBytecodes(1);
                    return (V)r2;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            BytecodeManager.incBytecodes(3);
            return biFunction;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
