// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import aic2021.engine.BytecodeManager;

public class IllegalFormatConversionException extends IllegalFormatException
{
    private static final long serialVersionUID = 17000126L;
    private char c;
    private Class<?> arg;
    
    public IllegalFormatConversionException(final char c, final Class<?> arg) {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            if (arg == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            this.c = c;
            BytecodeManager.incBytecodes(3);
            this.arg = arg;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
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
    
    public Class<?> getArgumentClass() {
        try {
            final Class<?> arg = this.arg;
            BytecodeManager.incBytecodes(3);
            return arg;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public String getMessage() {
        try {
            final String format = "%c != %s";
            final Object[] args = new Object[2];
            final int n = 0;
            final char c = this.c;
            BytecodeManager.incBytecodes(7);
            args[n] = c;
            final int n2 = 1;
            final Class<?> arg = this.arg;
            BytecodeManager.incBytecodes(6);
            args[n2] = arg.getName();
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
