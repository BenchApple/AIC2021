// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.logging;

import sun.util.logging.LoggingSupport;
import java.io.Writer;
import java.io.PrintWriter;
import java.io.StringWriter;
import aic2021.engine.BytecodeManager;
import instrumented.java.util.Date;

public class SimpleFormatter extends Formatter
{
    private static final String format;
    private final Date dat;
    
    public SimpleFormatter() {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(4);
            this.dat = new Date();
            BytecodeManager.incBytecodes(2);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public synchronized String format(final LogRecord logRecord) {
        try {
            final Date dat = this.dat;
            BytecodeManager.incBytecodes(4);
            final long millis = logRecord.getMillis();
            BytecodeManager.incBytecodes(1);
            dat.setTime(millis);
            BytecodeManager.incBytecodes(2);
            final String sourceClassName = logRecord.getSourceClassName();
            BytecodeManager.incBytecodes(1);
            String s;
            if (sourceClassName != null) {
                BytecodeManager.incBytecodes(2);
                s = logRecord.getSourceClassName();
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(2);
                final String sourceMethodName = logRecord.getSourceMethodName();
                BytecodeManager.incBytecodes(1);
                if (sourceMethodName != null) {
                    BytecodeManager.incBytecodes(3);
                    final StringBuilder sb = new StringBuilder();
                    final String str = s;
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append = sb.append(str);
                    final String str2 = " ";
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append2 = append.append(str2);
                    BytecodeManager.incBytecodes(2);
                    final String sourceMethodName2 = logRecord.getSourceMethodName();
                    BytecodeManager.incBytecodes(1);
                    final StringBuilder append3 = append2.append(sourceMethodName2);
                    BytecodeManager.incBytecodes(1);
                    s = append3.toString();
                    BytecodeManager.incBytecodes(2);
                }
            }
            else {
                BytecodeManager.incBytecodes(2);
                s = logRecord.getLoggerName();
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(3);
            final String formatMessage = this.formatMessage(logRecord);
            BytecodeManager.incBytecodes(1);
            String string = "";
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            final Throwable thrown = logRecord.getThrown();
            BytecodeManager.incBytecodes(1);
            if (thrown != null) {
                BytecodeManager.incBytecodes(3);
                final StringWriter stringWriter = new StringWriter();
                BytecodeManager.incBytecodes(1);
                final StringWriter out = stringWriter;
                BytecodeManager.incBytecodes(4);
                final PrintWriter printWriter = new PrintWriter(out);
                BytecodeManager.incBytecodes(1);
                final PrintWriter printWriter2 = printWriter;
                BytecodeManager.incBytecodes(2);
                printWriter2.println();
                BytecodeManager.incBytecodes(2);
                final Throwable thrown2 = logRecord.getThrown();
                final PrintWriter s2 = printWriter;
                BytecodeManager.incBytecodes(2);
                thrown2.printStackTrace(s2);
                final PrintWriter printWriter3 = printWriter;
                BytecodeManager.incBytecodes(2);
                printWriter3.close();
                final StringWriter stringWriter2 = stringWriter;
                BytecodeManager.incBytecodes(2);
                string = stringWriter2.toString();
                BytecodeManager.incBytecodes(1);
            }
            final String format = SimpleFormatter.format;
            final Object[] args = new Object[6];
            args[0] = this.dat;
            args[1] = s;
            final int n = 2;
            BytecodeManager.incBytecodes(14);
            BytecodeManager.incBytecodes(1);
            args[n] = logRecord.getLoggerName();
            final int n2 = 3;
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(1);
            final Level level = logRecord.getLevel();
            BytecodeManager.incBytecodes(1);
            args[n2] = level.getLocalizedLevelName();
            args[4] = formatMessage;
            args[5] = string;
            BytecodeManager.incBytecodes(9);
            BytecodeManager.incBytecodes(1);
            final String format2 = String.format(format, args);
            BytecodeManager.incBytecodes(1);
            return format2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static {
        try {
            BytecodeManager.incBytecodes(1);
            format = LoggingSupport.getSimpleFormat();
            BytecodeManager.incBytecodes(2);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
