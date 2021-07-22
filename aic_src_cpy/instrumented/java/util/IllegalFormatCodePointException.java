// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import aic2021.engine.BytecodeManager;

public class IllegalFormatCodePointException extends IllegalFormatException
{
    private static final long serialVersionUID = 19080630L;
    private int c;
    
    public IllegalFormatCodePointException(final int c) {
        try {
            BytecodeManager.incBytecodes(2);
            this.c = c;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public int getCodePoint() {
        try {
            final int c = this.c;
            BytecodeManager.incBytecodes(3);
            return c;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public String getMessage() {
        try {
            final String format = "Code point = %#x";
            final Object[] args = { null };
            final int n = 0;
            final int c = this.c;
            BytecodeManager.incBytecodes(7);
            args[n] = c;
            BytecodeManager.incBytecodes(2);
            final String format2 = String.format(format, args);
            BytecodeManager.incBytecodes(1);
            return format2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
