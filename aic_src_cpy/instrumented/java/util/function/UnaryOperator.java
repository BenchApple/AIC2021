// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.function;

import aic2021.engine.BytecodeManager;

@FunctionalInterface
public interface UnaryOperator<T> extends Function<T, T>
{
    default <T> UnaryOperator<T> identity() {
        try {
            final Function<Object, Object> function = o -> {
                try {
                    BytecodeManager.incBytecodes(2);
                    return o;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            BytecodeManager.incBytecodes(1);
            return (UnaryOperator<T>)function;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
