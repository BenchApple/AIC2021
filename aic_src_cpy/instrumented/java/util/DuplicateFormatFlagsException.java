// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import aic2021.engine.BytecodeManager;

public class DuplicateFormatFlagsException extends IllegalFormatException
{
    private static final long serialVersionUID = 18890531L;
    private String flags;
    
    public DuplicateFormatFlagsException(final String flags) {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            if (flags == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            this.flags = flags;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public String getFlags() {
        try {
            final String flags = this.flags;
            BytecodeManager.incBytecodes(3);
            return flags;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public String getMessage() {
        try {
            final String format = "Flags = '%s'";
            final Object[] args = { this.flags };
            BytecodeManager.incBytecodes(8);
            final String format2 = String.format(format, args);
            BytecodeManager.incBytecodes(1);
            return format2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
