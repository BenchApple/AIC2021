// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import aic2021.engine.BytecodeManager;

public class MissingFormatArgumentException extends IllegalFormatException
{
    private static final long serialVersionUID = 19190115L;
    private String s;
    
    public MissingFormatArgumentException(final String s) {
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
            BytecodeManager.incBytecodes(3);
            final StringBuilder sb = new StringBuilder();
            final String str = "Format specifier '";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append = sb.append(str);
            final String s = this.s;
            BytecodeManager.incBytecodes(3);
            final StringBuilder append2 = append.append(s);
            final String str2 = "'";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append3 = append2.append(str2);
            BytecodeManager.incBytecodes(1);
            final String string = append3.toString();
            BytecodeManager.incBytecodes(1);
            return string;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
