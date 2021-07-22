// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.function;

import instrumented.java.util.Objects;
import aic2021.engine.BytecodeManager;

@FunctionalInterface
public interface Function<T, R>
{
    R apply(final T p0);
    
    default <V> Function<V, R> compose(final Function<? super V, ? extends T> function) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(function);
            BytecodeManager.incBytecodes(1);
            final T t;
            final R r;
            final Function<V, R> function2 = o -> {
                try {
                    BytecodeManager.incBytecodes(4);
                    function.apply((Object)o);
                    BytecodeManager.incBytecodes(1);
                    this.apply(t);
                    BytecodeManager.incBytecodes(1);
                    return r;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            BytecodeManager.incBytecodes(3);
            return function2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    default <V> Function<T, V> andThen(final Function<? super R, ? extends V> function) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(function);
            BytecodeManager.incBytecodes(1);
            final Object o;
            final R r;
            final Function<T, V> function2 = t -> {
                try {
                    BytecodeManager.incBytecodes(4);
                    this.apply(t);
                    BytecodeManager.incBytecodes(1);
                    function.apply((R)o);
                    BytecodeManager.incBytecodes(1);
                    return (V)r;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            BytecodeManager.incBytecodes(3);
            return function2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    default <T> Function<T, T> identity() {
        try {
            final Function<T, T> function = r -> {
                try {
                    BytecodeManager.incBytecodes(2);
                    return (T)r;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            BytecodeManager.incBytecodes(1);
            return function;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
