// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.function;

import instrumented.java.util.Objects;
import aic2021.engine.BytecodeManager;

@FunctionalInterface
public interface IntUnaryOperator
{
    int applyAsInt(final int p0);
    
    default IntUnaryOperator compose(final IntUnaryOperator intUnaryOperator) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(intUnaryOperator);
            BytecodeManager.incBytecodes(1);
            final int n2;
            final int n3;
            final IntUnaryOperator intUnaryOperator2 = n -> {
                try {
                    BytecodeManager.incBytecodes(4);
                    intUnaryOperator.applyAsInt(n);
                    BytecodeManager.incBytecodes(1);
                    this.applyAsInt(n2);
                    BytecodeManager.incBytecodes(1);
                    return n3;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            BytecodeManager.incBytecodes(3);
            return intUnaryOperator2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    default IntUnaryOperator andThen(final IntUnaryOperator intUnaryOperator) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(intUnaryOperator);
            BytecodeManager.incBytecodes(1);
            final int n2;
            final int n3;
            final IntUnaryOperator intUnaryOperator2 = n -> {
                try {
                    BytecodeManager.incBytecodes(4);
                    this.applyAsInt(n);
                    BytecodeManager.incBytecodes(1);
                    intUnaryOperator.applyAsInt(n2);
                    BytecodeManager.incBytecodes(1);
                    return n3;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            BytecodeManager.incBytecodes(3);
            return intUnaryOperator2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    default IntUnaryOperator identity() {
        try {
            final IntUnaryOperator intUnaryOperator = n -> {
                try {
                    BytecodeManager.incBytecodes(2);
                    return n;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            BytecodeManager.incBytecodes(1);
            return intUnaryOperator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
