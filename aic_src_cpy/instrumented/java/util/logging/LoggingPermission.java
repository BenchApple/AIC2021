// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.logging;

import aic2021.engine.BytecodeManager;
import java.security.BasicPermission;

public final class LoggingPermission extends BasicPermission
{
    private static final long serialVersionUID = 63564341580231582L;
    
    public LoggingPermission(final String s, final String str) throws IllegalArgumentException {
        try {
            BytecodeManager.incBytecodes(3);
            super(s);
            final String anObject = "control";
            BytecodeManager.incBytecodes(3);
            final boolean equals = s.equals(anObject);
            BytecodeManager.incBytecodes(1);
            if (!equals) {
                BytecodeManager.incBytecodes(5);
                final StringBuilder sb = new StringBuilder();
                final String str2 = "name: ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb.append(str2);
                BytecodeManager.incBytecodes(2);
                final StringBuilder append2 = append.append(s);
                BytecodeManager.incBytecodes(1);
                final String string = append2.toString();
                BytecodeManager.incBytecodes(1);
                final IllegalArgumentException ex = new IllegalArgumentException(string);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(2);
            if (str != null) {
                BytecodeManager.incBytecodes(2);
                final int length = str.length();
                BytecodeManager.incBytecodes(1);
                if (length > 0) {
                    BytecodeManager.incBytecodes(5);
                    final StringBuilder sb2 = new StringBuilder();
                    final String str3 = "actions: ";
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append3 = sb2.append(str3);
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append4 = append3.append(str);
                    BytecodeManager.incBytecodes(1);
                    final String string2 = append4.toString();
                    BytecodeManager.incBytecodes(1);
                    final IllegalArgumentException ex2 = new IllegalArgumentException(string2);
                    BytecodeManager.incBytecodes(1);
                    throw ex2;
                }
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
