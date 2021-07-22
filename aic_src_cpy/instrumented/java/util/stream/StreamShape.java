// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.stream;

import aic2021.engine.BytecodeManager;

enum StreamShape
{
    REFERENCE, 
    INT_VALUE, 
    LONG_VALUE, 
    DOUBLE_VALUE;
    
    private StreamShape() {
        try {
            BytecodeManager.incBytecodes(4);
            super(name, ordinal);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static {
        try {
            final String s = "REFERENCE";
            final int n = 0;
            BytecodeManager.incBytecodes(5);
            BytecodeManager.incBytecodes(1);
            final String s2 = "INT_VALUE";
            final int n2 = 1;
            BytecodeManager.incBytecodes(5);
            BytecodeManager.incBytecodes(1);
            final String s3 = "LONG_VALUE";
            final int n3 = 2;
            BytecodeManager.incBytecodes(5);
            BytecodeManager.incBytecodes(1);
            final String s4 = "DOUBLE_VALUE";
            final int n4 = 3;
            BytecodeManager.incBytecodes(5);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(19);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
