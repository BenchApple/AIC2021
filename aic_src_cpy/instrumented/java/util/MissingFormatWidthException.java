// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import aic2021.engine.BytecodeManager;

public class MissingFormatWidthException extends IllegalFormatException
{
    private static final long serialVersionUID = 15560123L;
    private String s;
    
    public MissingFormatWidthException(final String s) {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            if (s == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            this.s = s;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public String getFormatSpecifier() {
        try {
            final String s = this.s;
            BytecodeManager.incBytecodes(3);
            return s;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public String getMessage() {
        try {
            final String s = this.s;
            BytecodeManager.incBytecodes(3);
            return s;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
