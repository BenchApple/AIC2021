// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import aic2021.engine.BytecodeManager;

public class IllformedLocaleException extends RuntimeException
{
    private static final long serialVersionUID = -5245986824925681401L;
    private int _errIdx;
    
    public IllformedLocaleException() {
        try {
            BytecodeManager.incBytecodes(2);
            this._errIdx = -1;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public IllformedLocaleException(final String message) {
        try {
            BytecodeManager.incBytecodes(3);
            super(message);
            this._errIdx = -1;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public IllformedLocaleException(final String str, final int n) {
        try {
            BytecodeManager.incBytecodes(4);
            final StringBuilder sb = new StringBuilder();
            BytecodeManager.incBytecodes(2);
            final StringBuilder append = sb.append(str);
            BytecodeManager.incBytecodes(2);
            String string;
            if (n < 0) {
                string = "";
                BytecodeManager.incBytecodes(2);
            }
            else {
                BytecodeManager.incBytecodes(3);
                final StringBuilder sb2 = new StringBuilder();
                final String str2 = " [at index ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append2 = sb2.append(str2);
                BytecodeManager.incBytecodes(2);
                final StringBuilder append3 = append2.append(n);
                final String str3 = "]";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append4 = append3.append(str3);
                BytecodeManager.incBytecodes(1);
                string = append4.toString();
            }
            BytecodeManager.incBytecodes(1);
            final StringBuilder append5 = append.append(string);
            BytecodeManager.incBytecodes(1);
            final String string2 = append5.toString();
            BytecodeManager.incBytecodes(1);
            super(string2);
            this._errIdx = -1;
            BytecodeManager.incBytecodes(3);
            this._errIdx = n;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public int getErrorIndex() {
        try {
            final int errIdx = this._errIdx;
            BytecodeManager.incBytecodes(3);
            return errIdx;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
