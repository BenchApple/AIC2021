// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.function;

import instrumented.java.util.Objects;
import aic2021.engine.BytecodeManager;

@FunctionalInterface
public interface LongUnaryOperator
{
    long applyAsLong(final long p0);
    
    default LongUnaryOperator compose(final LongUnaryOperator longUnaryOperator) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(longUnaryOperator);
            BytecodeManager.incBytecodes(1);
            final long n2;
            final long n3;
            final LongUnaryOperator longUnaryOperator2 = n -> {
                try {
                    BytecodeManager.incBytecodes(4);
                    longUnaryOperator.applyAsLong(n);
                    BytecodeManager.incBytecodes(1);
                    this.applyAsLong(n2);
                    BytecodeManager.incBytecodes(1);
                    return n3;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            BytecodeManager.incBytecodes(3);
            return longUnaryOperator2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    default LongUnaryOperator andThen(final LongUnaryOperator longUnaryOperator) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(longUnaryOperator);
            BytecodeManager.incBytecodes(1);
            final long n2;
            final long n3;
            final LongUnaryOperator longUnaryOperator2 = n -> {
                try {
                    BytecodeManager.incBytecodes(4);
                    this.applyAsLong(n);
                    BytecodeManager.incBytecodes(1);
                    longUnaryOperator.applyAsLong(n2);
                    BytecodeManager.incBytecodes(1);
                    return n3;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            BytecodeManager.incBytecodes(3);
            return longUnaryOperator2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    default LongUnaryOperator identity() {
        try {
            final LongUnaryOperator longUnaryOperator = n -> {
                try {
                    BytecodeManager.incBytecodes(2);
                    return n;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            BytecodeManager.incBytecodes(1);
            return longUnaryOperator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
