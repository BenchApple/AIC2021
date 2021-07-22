// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import aic2021.engine.BytecodeManager;

public class FormatFlagsConversionMismatchException extends IllegalFormatException
{
    private static final long serialVersionUID = 19120414L;
    private String f;
    private char c;
    
    public FormatFlagsConversionMismatchException(final String f, final char c) {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            if (f == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            this.f = f;
            BytecodeManager.incBytecodes(3);
            this.c = c;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public String getFlags() {
        try {
            final String f = this.f;
            BytecodeManager.incBytecodes(3);
            return f;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public char getConversion() {
        try {
            final char c = this.c;
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
            BytecodeManager.incBytecodes(3);
            final StringBuilder sb = new StringBuilder();
            final String str = "Conversion = ";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append = sb.append(str);
            final char c = this.c;
            BytecodeManager.incBytecodes(3);
            final StringBuilder append2 = append.append(c);
            final String str2 = ", Flags = ";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append3 = append2.append(str2);
            final String f = this.f;
            BytecodeManager.incBytecodes(3);
            final StringBuilder append4 = append3.append(f);
            BytecodeManager.incBytecodes(1);
            final String string = append4.toString();
            BytecodeManager.incBytecodes(1);
            return string;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
