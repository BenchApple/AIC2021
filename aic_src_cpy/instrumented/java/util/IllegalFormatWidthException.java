// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import aic2021.engine.BytecodeManager;

public class IllegalFormatWidthException extends IllegalFormatException
{
    private static final long serialVersionUID = 16660902L;
    private int w;
    
    public IllegalFormatWidthException(final int w) {
        try {
            BytecodeManager.incBytecodes(2);
            this.w = w;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public int getWidth() {
        try {
            final int w = this.w;
            BytecodeManager.incBytecodes(3);
            return w;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public String getMessage() {
        try {
            final int w = this.w;
            BytecodeManager.incBytecodes(3);
            final String string = Integer.toString(w);
            BytecodeManager.incBytecodes(1);
            return string;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
