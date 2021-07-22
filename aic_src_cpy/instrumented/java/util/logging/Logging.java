// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.logging;

import instrumented.java.util.Enumeration;
import instrumented.java.util.ArrayList;
import instrumented.java.util.List;
import aic2021.engine.BytecodeManager;

class Logging implements LoggingMXBean
{
    private static LogManager logManager;
    private static String EMPTY_STRING;
    
    Logging() {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public List<String> getLoggerNames() {
        try {
            final LogManager logManager = Logging.logManager;
            BytecodeManager.incBytecodes(2);
            final Enumeration<String> loggerNames = logManager.getLoggerNames();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            final ArrayList<String> list = new ArrayList<String>();
            BytecodeManager.incBytecodes(1);
            while (true) {
                final Enumeration<String> enumeration = loggerNames;
                BytecodeManager.incBytecodes(2);
                final boolean hasMoreElements = enumeration.hasMoreElements();
                BytecodeManager.incBytecodes(1);
                if (!hasMoreElements) {
                    break;
                }
                final ArrayList<String> list2 = list;
                final Enumeration<String> enumeration2 = loggerNames;
                BytecodeManager.incBytecodes(3);
                final String nextElement = enumeration2.nextElement();
                BytecodeManager.incBytecodes(1);
                list2.add(nextElement);
                BytecodeManager.incBytecodes(2);
            }
            final ArrayList<String> list3 = list;
            BytecodeManager.incBytecodes(2);
            return list3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public String getLoggerLevel(final String s) {
        try {
            final LogManager logManager = Logging.logManager;
            BytecodeManager.incBytecodes(3);
            final Logger logger = logManager.getLogger(s);
            BytecodeManager.incBytecodes(1);
            final Logger logger2 = logger;
            BytecodeManager.incBytecodes(2);
            if (logger2 == null) {
                final String s2 = null;
                BytecodeManager.incBytecodes(2);
                return s2;
            }
            final Logger logger3 = logger;
            BytecodeManager.incBytecodes(2);
            final Level level = logger3.getLevel();
            BytecodeManager.incBytecodes(1);
            final Level level2 = level;
            BytecodeManager.incBytecodes(2);
            if (level2 == null) {
                final String empty_STRING = Logging.EMPTY_STRING;
                BytecodeManager.incBytecodes(2);
                return empty_STRING;
            }
            final Level level3 = level;
            BytecodeManager.incBytecodes(2);
            final String levelName = level3.getLevelName();
            BytecodeManager.incBytecodes(1);
            return levelName;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void setLoggerLevel(final String str, final String str2) {
        try {
            BytecodeManager.incBytecodes(2);
            if (str == null) {
                final String s = "loggerName is null";
                BytecodeManager.incBytecodes(4);
                final NullPointerException ex = new NullPointerException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final LogManager logManager = Logging.logManager;
            BytecodeManager.incBytecodes(3);
            final Logger logger = logManager.getLogger(str);
            BytecodeManager.incBytecodes(1);
            final Logger logger2 = logger;
            BytecodeManager.incBytecodes(2);
            if (logger2 == null) {
                BytecodeManager.incBytecodes(5);
                final StringBuilder sb = new StringBuilder();
                final String str3 = "Logger ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb.append(str3);
                BytecodeManager.incBytecodes(2);
                final StringBuilder append2 = append.append(str);
                final String str4 = "does not exist";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append3 = append2.append(str4);
                BytecodeManager.incBytecodes(1);
                final String string = append3.toString();
                BytecodeManager.incBytecodes(1);
                final IllegalArgumentException ex2 = new IllegalArgumentException(string);
                BytecodeManager.incBytecodes(1);
                throw ex2;
            }
            Level level = null;
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            if (str2 != null) {
                BytecodeManager.incBytecodes(2);
                level = Level.findLevel(str2);
                BytecodeManager.incBytecodes(1);
                final Level level2 = level;
                BytecodeManager.incBytecodes(2);
                if (level2 == null) {
                    BytecodeManager.incBytecodes(5);
                    final StringBuilder sb2 = new StringBuilder();
                    final String str5 = "Unknown level \"";
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append4 = sb2.append(str5);
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append5 = append4.append(str2);
                    final String str6 = "\"";
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append6 = append5.append(str6);
                    BytecodeManager.incBytecodes(1);
                    final String string2 = append6.toString();
                    BytecodeManager.incBytecodes(1);
                    final IllegalArgumentException ex3 = new IllegalArgumentException(string2);
                    BytecodeManager.incBytecodes(1);
                    throw ex3;
                }
            }
            final Logger logger3 = logger;
            final Level level3 = level;
            BytecodeManager.incBytecodes(3);
            logger3.setLevel(level3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public String getParentLoggerName(final String s) {
        try {
            final LogManager logManager = Logging.logManager;
            BytecodeManager.incBytecodes(3);
            final Logger logger = logManager.getLogger(s);
            BytecodeManager.incBytecodes(1);
            final Logger logger2 = logger;
            BytecodeManager.incBytecodes(2);
            if (logger2 == null) {
                final String s2 = null;
                BytecodeManager.incBytecodes(2);
                return s2;
            }
            final Logger logger3 = logger;
            BytecodeManager.incBytecodes(2);
            final Logger parent = logger3.getParent();
            BytecodeManager.incBytecodes(1);
            final Logger logger4 = parent;
            BytecodeManager.incBytecodes(2);
            if (logger4 == null) {
                final String empty_STRING = Logging.EMPTY_STRING;
                BytecodeManager.incBytecodes(2);
                return empty_STRING;
            }
            final Logger logger5 = parent;
            BytecodeManager.incBytecodes(2);
            final String name = logger5.getName();
            BytecodeManager.incBytecodes(1);
            return name;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static {
        try {
            BytecodeManager.incBytecodes(1);
            Logging.logManager = LogManager.getLogManager();
            BytecodeManager.incBytecodes(1);
            Logging.EMPTY_STRING = "";
            BytecodeManager.incBytecodes(3);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
