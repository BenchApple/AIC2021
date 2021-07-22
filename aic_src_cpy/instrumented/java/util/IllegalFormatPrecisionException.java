// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import aic2021.engine.BytecodeManager;

public class IllegalFormatPrecisionException extends IllegalFormatException
{
    private static final long serialVersionUID = 18711008L;
    private int p;
    
    public IllegalFormatPrecisionException(final int p) {
        try {
            BytecodeManager.incBytecodes(2);
            this.p = p;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public int getPrecision() {
        try {
            final int p = this.p;
            BytecodeManager.incBytecodes(3);
            return p;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public String getMessage() {
        try {
            final int p = this.p;
            BytecodeManager.incBytecodes(3);
            final String string = Integer.toString(p);
            BytecodeManager.incBytecodes(1);
            return string;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
