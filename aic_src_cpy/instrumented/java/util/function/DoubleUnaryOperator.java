// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.function;

import instrumented.java.util.Objects;
import aic2021.engine.BytecodeManager;

@FunctionalInterface
public interface DoubleUnaryOperator
{
    double applyAsDouble(final double p0);
    
    default DoubleUnaryOperator compose(final DoubleUnaryOperator doubleUnaryOperator) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(doubleUnaryOperator);
            BytecodeManager.incBytecodes(1);
            final double n2;
            final double n3;
            final DoubleUnaryOperator doubleUnaryOperator2 = n -> {
                try {
                    BytecodeManager.incBytecodes(4);
                    doubleUnaryOperator.applyAsDouble(n);
                    BytecodeManager.incBytecodes(1);
                    this.applyAsDouble(n2);
                    BytecodeManager.incBytecodes(1);
                    return n3;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            BytecodeManager.incBytecodes(3);
            return doubleUnaryOperator2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    default DoubleUnaryOperator andThen(final DoubleUnaryOperator doubleUnaryOperator) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(doubleUnaryOperator);
            BytecodeManager.incBytecodes(1);
            final double n2;
            final double n3;
            final DoubleUnaryOperator doubleUnaryOperator2 = n -> {
                try {
                    BytecodeManager.incBytecodes(4);
                    this.applyAsDouble(n);
                    BytecodeManager.incBytecodes(1);
                    doubleUnaryOperator.applyAsDouble(n2);
                    BytecodeManager.incBytecodes(1);
                    return n3;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            BytecodeManager.incBytecodes(3);
            return doubleUnaryOperator2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    default DoubleUnaryOperator identity() {
        try {
            final DoubleUnaryOperator doubleUnaryOperator = n -> {
                try {
                    BytecodeManager.incBytecodes(2);
                    return n;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            BytecodeManager.incBytecodes(1);
            return doubleUnaryOperator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
