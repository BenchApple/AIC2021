// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.math;

import aic2021.engine.BytecodeManager;

public enum RoundingMode
{
    UP(n2), 
    DOWN(n4), 
    CEILING(n6), 
    FLOOR(n8), 
    HALF_UP(n10), 
    HALF_DOWN(n12), 
    HALF_EVEN(n14), 
    UNNECESSARY(n16);
    
    final int oldMode;
    
    private RoundingMode(final int oldMode) {
        try {
            BytecodeManager.incBytecodes(4);
            super(name, ordinal);
            this.oldMode = oldMode;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static RoundingMode valueOf(final int n) {
        try {
            BytecodeManager.incBytecodes(2);
            switch (n) {
                case 0: {
                    final RoundingMode up = RoundingMode.UP;
                    BytecodeManager.incBytecodes(2);
                    return up;
                }
                case 1: {
                    final RoundingMode down = RoundingMode.DOWN;
                    BytecodeManager.incBytecodes(2);
                    return down;
                }
                case 2: {
                    final RoundingMode ceiling = RoundingMode.CEILING;
                    BytecodeManager.incBytecodes(2);
                    return ceiling;
                }
                case 3: {
                    final RoundingMode floor = RoundingMode.FLOOR;
                    BytecodeManager.incBytecodes(2);
                    return floor;
                }
                case 4: {
                    final RoundingMode half_UP = RoundingMode.HALF_UP;
                    BytecodeManager.incBytecodes(2);
                    return half_UP;
                }
                case 5: {
                    final RoundingMode half_DOWN = RoundingMode.HALF_DOWN;
                    BytecodeManager.incBytecodes(2);
                    return half_DOWN;
                }
                case 6: {
                    final RoundingMode half_EVEN = RoundingMode.HALF_EVEN;
                    BytecodeManager.incBytecodes(2);
                    return half_EVEN;
                }
                case 7: {
                    final RoundingMode unnecessary = RoundingMode.UNNECESSARY;
                    BytecodeManager.incBytecodes(2);
                    return unnecessary;
                }
                default: {
                    final String s = "argument out of range";
                    BytecodeManager.incBytecodes(4);
                    final IllegalArgumentException ex = new IllegalArgumentException(s);
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static {
        try {
            final String s = "UP";
            final int n = 0;
            final int n2 = 0;
            BytecodeManager.incBytecodes(6);
            BytecodeManager.incBytecodes(1);
            final String s2 = "DOWN";
            final int n3 = 1;
            final int n4 = 1;
            BytecodeManager.incBytecodes(6);
            BytecodeManager.incBytecodes(1);
            final String s3 = "CEILING";
            final int n5 = 2;
            final int n6 = 2;
            BytecodeManager.incBytecodes(6);
            BytecodeManager.incBytecodes(1);
            final String s4 = "FLOOR";
            final int n7 = 3;
            final int n8 = 3;
            BytecodeManager.incBytecodes(6);
            BytecodeManager.incBytecodes(1);
            final String s5 = "HALF_UP";
            final int n9 = 4;
            final int n10 = 4;
            BytecodeManager.incBytecodes(6);
            BytecodeManager.incBytecodes(1);
            final String s6 = "HALF_DOWN";
            final int n11 = 5;
            final int n12 = 5;
            BytecodeManager.incBytecodes(6);
            BytecodeManager.incBytecodes(1);
            final String s7 = "HALF_EVEN";
            final int n13 = 6;
            final int n14 = 6;
            BytecodeManager.incBytecodes(6);
            BytecodeManager.incBytecodes(1);
            final String s8 = "UNNECESSARY";
            final int n15 = 7;
            final int n16 = 7;
            BytecodeManager.incBytecodes(6);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(35);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
