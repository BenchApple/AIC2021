// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import aic2021.engine.BytecodeManager;

public class UnknownFormatFlagsException extends IllegalFormatException
{
    private static final long serialVersionUID = 19370506L;
    private String flags;
    
    public UnknownFormatFlagsException(final String flags) {
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
            BytecodeManager.incBytecodes(3);
            final StringBuilder sb = new StringBuilder();
            final String str = "Flags = ";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append = sb.append(str);
            final String flags = this.flags;
            BytecodeManager.incBytecodes(3);
            final StringBuilder append2 = append.append(flags);
            BytecodeManager.incBytecodes(1);
            final String string = append2.toString();
            BytecodeManager.incBytecodes(1);
            return string;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
