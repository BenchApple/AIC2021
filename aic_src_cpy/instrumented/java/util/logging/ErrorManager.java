// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.logging;

import java.io.PrintStream;
import aic2021.engine.BytecodeManager;

public class ErrorManager
{
    private boolean reported;
    public static final int GENERIC_FAILURE = 0;
    public static final int WRITE_FAILURE = 1;
    public static final int FLUSH_FAILURE = 2;
    public static final int CLOSE_FAILURE = 3;
    public static final int OPEN_FAILURE = 4;
    public static final int FORMAT_FAILURE = 5;
    
    public ErrorManager() {
        try {
            BytecodeManager.incBytecodes(2);
            this.reported = false;
            BytecodeManager.incBytecodes(4);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public synchronized void error(final String str, final Exception ex, final int i) {
        try {
            final boolean reported = this.reported;
            BytecodeManager.incBytecodes(3);
            if (reported) {
                BytecodeManager.incBytecodes(1);
                return;
            }
            this.reported = true;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(3);
            final StringBuilder sb = new StringBuilder();
            final String str2 = "java.util.logging.ErrorManager: ";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append = sb.append(str2);
            BytecodeManager.incBytecodes(2);
            final StringBuilder append2 = append.append(i);
            BytecodeManager.incBytecodes(1);
            String s = append2.toString();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            if (str != null) {
                BytecodeManager.incBytecodes(3);
                final StringBuilder sb2 = new StringBuilder();
                final String str3 = s;
                BytecodeManager.incBytecodes(2);
                final StringBuilder append3 = sb2.append(str3);
                final String str4 = ": ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append4 = append3.append(str4);
                BytecodeManager.incBytecodes(2);
                final StringBuilder append5 = append4.append(str);
                BytecodeManager.incBytecodes(1);
                s = append5.toString();
                BytecodeManager.incBytecodes(1);
            }
            final PrintStream err = System.err;
            final String x = s;
            BytecodeManager.incBytecodes(3);
            err.println(x);
            BytecodeManager.incBytecodes(2);
            if (ex != null) {
                BytecodeManager.incBytecodes(2);
                ex.printStackTrace();
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
