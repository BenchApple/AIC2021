// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.function;

import instrumented.java.util.Objects;
import aic2021.engine.BytecodeManager;
import instrumented.java.util.Comparator;

@FunctionalInterface
public interface BinaryOperator<T> extends BiFunction<T, T, T>
{
    default <T> BinaryOperator<T> minBy(final Comparator<? super T> comparator) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(comparator);
            BytecodeManager.incBytecodes(1);
            final Object o3;
            final Object o4;
            final BiFunction<Object, Object, Object> biFunction = (o, o2) -> {
                try {
                    BytecodeManager.incBytecodes(4);
                    comparator.compare((Object)o, (Object)o2);
                    BytecodeManager.incBytecodes(1);
                    if (o3 <= 0) {
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(1);
                    return o4;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            BytecodeManager.incBytecodes(2);
            return (BinaryOperator<T>)biFunction;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    default <T> BinaryOperator<T> maxBy(final Comparator<? super T> comparator) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(comparator);
            BytecodeManager.incBytecodes(1);
            final Object o3;
            final Object o4;
            final BiFunction<Object, Object, Object> biFunction = (o, o2) -> {
                try {
                    BytecodeManager.incBytecodes(4);
                    comparator.compare((Object)o, (Object)o2);
                    BytecodeManager.incBytecodes(1);
                    if (o3 >= 0) {
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(1);
                    return o4;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            BytecodeManager.incBytecodes(2);
            return (BinaryOperator<T>)biFunction;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
