// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.math;

import aic2021.engine.BytecodeManager;

class SignedMutableBigInteger extends MutableBigInteger
{
    int sign;
    
    SignedMutableBigInteger() {
        try {
            BytecodeManager.incBytecodes(2);
            this.sign = 1;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    SignedMutableBigInteger(final int n) {
        try {
            BytecodeManager.incBytecodes(3);
            super(n);
            this.sign = 1;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    SignedMutableBigInteger(final MutableBigInteger mutableBigInteger) {
        try {
            BytecodeManager.incBytecodes(3);
            super(mutableBigInteger);
            this.sign = 1;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    void signedAdd(final SignedMutableBigInteger signedMutableBigInteger) {
        try {
            final int sign = this.sign;
            final int sign2 = signedMutableBigInteger.sign;
            BytecodeManager.incBytecodes(5);
            if (sign == sign2) {
                BytecodeManager.incBytecodes(3);
                this.add(signedMutableBigInteger);
                BytecodeManager.incBytecodes(1);
            }
            else {
                final int sign3 = this.sign;
                BytecodeManager.incBytecodes(6);
                this.sign = sign3 * this.subtract(signedMutableBigInteger);
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    void signedAdd(final MutableBigInteger mutableBigInteger) {
        try {
            final int sign = this.sign;
            final int n = 1;
            BytecodeManager.incBytecodes(4);
            if (sign == n) {
                BytecodeManager.incBytecodes(3);
                this.add(mutableBigInteger);
                BytecodeManager.incBytecodes(1);
            }
            else {
                final int sign2 = this.sign;
                BytecodeManager.incBytecodes(6);
                this.sign = sign2 * this.subtract(mutableBigInteger);
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    void signedSubtract(final SignedMutableBigInteger signedMutableBigInteger) {
        try {
            final int sign = this.sign;
            final int sign2 = signedMutableBigInteger.sign;
            BytecodeManager.incBytecodes(5);
            if (sign == sign2) {
                final int sign3 = this.sign;
                BytecodeManager.incBytecodes(6);
                this.sign = sign3 * this.subtract(signedMutableBigInteger);
                BytecodeManager.incBytecodes(3);
            }
            else {
                BytecodeManager.incBytecodes(3);
                this.add(signedMutableBigInteger);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    void signedSubtract(final MutableBigInteger mutableBigInteger) {
        try {
            final int sign = this.sign;
            final int n = 1;
            BytecodeManager.incBytecodes(4);
            if (sign == n) {
                final int sign2 = this.sign;
                BytecodeManager.incBytecodes(6);
                this.sign = sign2 * this.subtract(mutableBigInteger);
                BytecodeManager.incBytecodes(3);
            }
            else {
                BytecodeManager.incBytecodes(3);
                this.add(mutableBigInteger);
            }
            final int intLen = this.intLen;
            BytecodeManager.incBytecodes(3);
            if (intLen == 0) {
                this.sign = 1;
                BytecodeManager.incBytecodes(3);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public String toString() {
        try {
            final int sign = this.sign;
            BytecodeManager.incBytecodes(4);
            final BigInteger bigInteger = this.toBigInteger(sign);
            BytecodeManager.incBytecodes(1);
            final String string = bigInteger.toString();
            BytecodeManager.incBytecodes(1);
            return string;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
