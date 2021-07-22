// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.logging;

import instrumented.java.util.List;
import aic2021.engine.BytecodeManager;
import sun.util.logging.LoggingProxy;

class LoggingProxyImpl implements LoggingProxy
{
    static final LoggingProxy INSTANCE;
    
    private LoggingProxyImpl() {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Object getLogger(final String s) {
        try {
            BytecodeManager.incBytecodes(2);
            final Logger platformLogger = Logger.getPlatformLogger(s);
            BytecodeManager.incBytecodes(1);
            return platformLogger;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Object getLevel(final Object o) {
        try {
            final Logger logger = (Logger)o;
            BytecodeManager.incBytecodes(3);
            final Level level = logger.getLevel();
            BytecodeManager.incBytecodes(1);
            return level;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void setLevel(final Object o, final Object o2) {
        try {
            final Logger logger = (Logger)o;
            final Level level = (Level)o2;
            BytecodeManager.incBytecodes(5);
            logger.setLevel(level);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public boolean isLoggable(final Object o, final Object o2) {
        try {
            final Logger logger = (Logger)o;
            final Level level = (Level)o2;
            BytecodeManager.incBytecodes(5);
            final boolean loggable = logger.isLoggable(level);
            BytecodeManager.incBytecodes(1);
            return loggable;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void log(final Object o, final Object o2, final String s) {
        try {
            final Logger logger = (Logger)o;
            final Level level = (Level)o2;
            BytecodeManager.incBytecodes(6);
            logger.log(level, s);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void log(final Object o, final Object o2, final String s, final Throwable t) {
        try {
            final Logger logger = (Logger)o;
            final Level level = (Level)o2;
            BytecodeManager.incBytecodes(7);
            logger.log(level, s, t);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void log(final Object o, final Object o2, final String s, final Object... array) {
        try {
            final Logger logger = (Logger)o;
            final Level level = (Level)o2;
            BytecodeManager.incBytecodes(7);
            logger.log(level, s, array);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public List<String> getLoggerNames() {
        try {
            BytecodeManager.incBytecodes(1);
            final LoggingMXBean loggingMXBean = LogManager.getLoggingMXBean();
            BytecodeManager.incBytecodes(1);
            final List<String> loggerNames = loggingMXBean.getLoggerNames();
            BytecodeManager.incBytecodes(1);
            return loggerNames;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public String getLoggerLevel(final String s) {
        try {
            BytecodeManager.incBytecodes(1);
            final LoggingMXBean loggingMXBean = LogManager.getLoggingMXBean();
            BytecodeManager.incBytecodes(2);
            final String loggerLevel = loggingMXBean.getLoggerLevel(s);
            BytecodeManager.incBytecodes(1);
            return loggerLevel;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void setLoggerLevel(final String s, final String s2) {
        try {
            BytecodeManager.incBytecodes(1);
            final LoggingMXBean loggingMXBean = LogManager.getLoggingMXBean();
            BytecodeManager.incBytecodes(3);
            loggingMXBean.setLoggerLevel(s, s2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public String getParentLoggerName(final String s) {
        try {
            BytecodeManager.incBytecodes(1);
            final LoggingMXBean loggingMXBean = LogManager.getLoggingMXBean();
            BytecodeManager.incBytecodes(2);
            final String parentLoggerName = loggingMXBean.getParentLoggerName(s);
            BytecodeManager.incBytecodes(1);
            return parentLoggerName;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Object parseLevel(final String str) {
        try {
            BytecodeManager.incBytecodes(2);
            final Level level = Level.findLevel(str);
            BytecodeManager.incBytecodes(1);
            final Level level2 = level;
            BytecodeManager.incBytecodes(2);
            if (level2 == null) {
                BytecodeManager.incBytecodes(5);
                final StringBuilder sb = new StringBuilder();
                final String str2 = "Unknown level \"";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb.append(str2);
                BytecodeManager.incBytecodes(2);
                final StringBuilder append2 = append.append(str);
                final String str3 = "\"";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append3 = append2.append(str3);
                BytecodeManager.incBytecodes(1);
                final String string = append3.toString();
                BytecodeManager.incBytecodes(1);
                final IllegalArgumentException ex = new IllegalArgumentException(string);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final Level level3 = level;
            BytecodeManager.incBytecodes(2);
            return level3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public String getLevelName(final Object o) {
        try {
            final Level level = (Level)o;
            BytecodeManager.incBytecodes(3);
            final String levelName = level.getLevelName();
            BytecodeManager.incBytecodes(1);
            return levelName;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public int getLevelValue(final Object o) {
        try {
            final Level level = (Level)o;
            BytecodeManager.incBytecodes(3);
            final int intValue = level.intValue();
            BytecodeManager.incBytecodes(1);
            return intValue;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public String getProperty(final String s) {
        try {
            BytecodeManager.incBytecodes(1);
            final LogManager logManager = LogManager.getLogManager();
            BytecodeManager.incBytecodes(2);
            final String property = logManager.getProperty(s);
            BytecodeManager.incBytecodes(1);
            return property;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static {
        try {
            BytecodeManager.incBytecodes(3);
            INSTANCE = (LoggingProxy)new LoggingProxyImpl();
            BytecodeManager.incBytecodes(2);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
