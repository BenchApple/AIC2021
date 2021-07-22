// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.logging;

import java.security.AccessController;
import instrumented.java.util.MissingResourceException;
import java.security.PrivilegedAction;
import instrumented.java.util.function.Supplier;
import sun.reflect.CallerSensitive;
import sun.reflect.Reflection;
import aic2021.engine.BytecodeManager;
import java.lang.ref.WeakReference;
import instrumented.java.util.ArrayList;
import instrumented.java.util.Locale;
import instrumented.java.util.ResourceBundle;
import instrumented.java.util.concurrent.CopyOnWriteArrayList;

public class Logger
{
    private static final Handler[] emptyHandlers;
    private static final int offValue;
    static final String SYSTEM_LOGGER_RB_NAME = "sun.util.logging.resources.logging";
    private static final LoggerBundle SYSTEM_BUNDLE;
    private static final LoggerBundle NO_RESOURCE_BUNDLE;
    private volatile LogManager manager;
    private String name;
    private final CopyOnWriteArrayList<Handler> handlers;
    private volatile LoggerBundle loggerBundle;
    private volatile boolean useParentHandlers;
    private volatile Filter filter;
    private boolean anonymous;
    private ResourceBundle catalog;
    private String catalogName;
    private Locale catalogLocale;
    private static final Object treeLock;
    private volatile Logger parent;
    private ArrayList<LogManager.LoggerWeakRef> kids;
    private volatile Level levelObject;
    private volatile int levelValue;
    private WeakReference<ClassLoader> callersClassLoaderRef;
    private final boolean isSystemLogger;
    public static final String GLOBAL_LOGGER_NAME = "global";
    @Deprecated
    public static final Logger global;
    static final /* synthetic */ boolean $assertionsDisabled;
    
    public static final Logger getGlobal() {
        try {
            BytecodeManager.incBytecodes(1);
            LogManager.getLogManager();
            BytecodeManager.incBytecodes(1);
            final Logger global = Logger.global;
            BytecodeManager.incBytecodes(2);
            return global;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    protected Logger(final String s, final String s2) {
        try {
            final Class<?> clazz = null;
            BytecodeManager.incBytecodes(5);
            final LogManager logManager = LogManager.getLogManager();
            final boolean b = false;
            BytecodeManager.incBytecodes(2);
            this(s, s2, clazz, logManager, b);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    Logger(final String name, final String s, final Class<?> clazz, final LogManager manager, final boolean isSystemLogger) {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(4);
            this.handlers = new CopyOnWriteArrayList<Handler>();
            BytecodeManager.incBytecodes(1);
            this.loggerBundle = Logger.NO_RESOURCE_BUNDLE;
            BytecodeManager.incBytecodes(3);
            this.useParentHandlers = true;
            BytecodeManager.incBytecodes(3);
            this.manager = manager;
            BytecodeManager.incBytecodes(3);
            this.isSystemLogger = isSystemLogger;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(4);
            this.setupResourceInfo(s, clazz);
            this.name = name;
            BytecodeManager.incBytecodes(3);
            final Level info = Level.INFO;
            BytecodeManager.incBytecodes(3);
            this.levelValue = info.intValue();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void setCallersClassLoaderRef(final Class<?> clazz) {
        try {
            BytecodeManager.incBytecodes(2);
            ClassLoader classLoader;
            if (clazz != null) {
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                classLoader = clazz.getClassLoader();
                BytecodeManager.incBytecodes(1);
            }
            else {
                classLoader = null;
                BytecodeManager.incBytecodes(1);
            }
            final ClassLoader classLoader2 = classLoader;
            BytecodeManager.incBytecodes(1);
            final ClassLoader classLoader3 = classLoader2;
            BytecodeManager.incBytecodes(2);
            if (classLoader3 != null) {
                final ClassLoader referent = classLoader2;
                BytecodeManager.incBytecodes(5);
                this.callersClassLoaderRef = new WeakReference<ClassLoader>(referent);
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private ClassLoader getCallersClassLoader() {
        try {
            final WeakReference<ClassLoader> callersClassLoaderRef = this.callersClassLoaderRef;
            BytecodeManager.incBytecodes(3);
            ClassLoader classLoader;
            if (callersClassLoaderRef != null) {
                final WeakReference<ClassLoader> callersClassLoaderRef2 = this.callersClassLoaderRef;
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
                classLoader = callersClassLoaderRef2.get();
                BytecodeManager.incBytecodes(2);
            }
            else {
                classLoader = null;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return classLoader;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private Logger(final String name) {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(4);
            this.handlers = new CopyOnWriteArrayList<Handler>();
            BytecodeManager.incBytecodes(1);
            this.loggerBundle = Logger.NO_RESOURCE_BUNDLE;
            BytecodeManager.incBytecodes(3);
            this.useParentHandlers = true;
            BytecodeManager.incBytecodes(3);
            this.name = name;
            BytecodeManager.incBytecodes(3);
            this.isSystemLogger = true;
            BytecodeManager.incBytecodes(3);
            final Level info = Level.INFO;
            BytecodeManager.incBytecodes(3);
            this.levelValue = info.intValue();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    void setLogManager(final LogManager manager) {
        try {
            this.manager = manager;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void checkPermission() throws SecurityException {
        try {
            final boolean anonymous = this.anonymous;
            BytecodeManager.incBytecodes(3);
            if (!anonymous) {
                final LogManager manager = this.manager;
                BytecodeManager.incBytecodes(3);
                if (manager == null) {
                    BytecodeManager.incBytecodes(2);
                    this.manager = LogManager.getLogManager();
                    BytecodeManager.incBytecodes(1);
                }
                final LogManager manager2 = this.manager;
                BytecodeManager.incBytecodes(3);
                manager2.checkPermission();
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static Logger demandLogger(final String s, final String s2, final Class<?> clazz) {
        try {
            BytecodeManager.incBytecodes(1);
            final LogManager logManager = LogManager.getLogManager();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
            final SecurityManager securityManager = System.getSecurityManager();
            BytecodeManager.incBytecodes(1);
            final SecurityManager securityManager2 = securityManager;
            BytecodeManager.incBytecodes(2);
            if (securityManager2 != null) {
                final boolean disableCallerCheck = SystemLoggerHelper.disableCallerCheck;
                BytecodeManager.incBytecodes(2);
                if (!disableCallerCheck) {
                    BytecodeManager.incBytecodes(2);
                    final ClassLoader classLoader = clazz.getClassLoader();
                    BytecodeManager.incBytecodes(1);
                    if (classLoader == null) {
                        final LogManager logManager2 = logManager;
                        BytecodeManager.incBytecodes(4);
                        final Logger demandSystemLogger = logManager2.demandSystemLogger(s, s2);
                        BytecodeManager.incBytecodes(1);
                        return demandSystemLogger;
                    }
                }
            }
            final LogManager logManager3 = logManager;
            BytecodeManager.incBytecodes(5);
            final Logger demandLogger = logManager3.demandLogger(s, s2, clazz);
            BytecodeManager.incBytecodes(1);
            return demandLogger;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @CallerSensitive
    public static Logger getLogger(final String s) {
        try {
            final String s2 = null;
            BytecodeManager.incBytecodes(3);
            final Class callerClass = Reflection.getCallerClass();
            BytecodeManager.incBytecodes(1);
            final Logger demandLogger = demandLogger(s, s2, callerClass);
            BytecodeManager.incBytecodes(1);
            return demandLogger;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @CallerSensitive
    public static Logger getLogger(final String s, final String s2) {
        try {
            BytecodeManager.incBytecodes(1);
            final Class callerClass = Reflection.getCallerClass();
            BytecodeManager.incBytecodes(1);
            final Class clazz = callerClass;
            BytecodeManager.incBytecodes(4);
            final Logger demandLogger = demandLogger(s, s2, clazz);
            BytecodeManager.incBytecodes(1);
            final Logger logger = demandLogger;
            final Class clazz2 = callerClass;
            BytecodeManager.incBytecodes(4);
            logger.setupResourceInfo(s2, clazz2);
            final Logger logger2 = demandLogger;
            BytecodeManager.incBytecodes(2);
            return logger2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static Logger getPlatformLogger(final String s) {
        try {
            BytecodeManager.incBytecodes(1);
            final LogManager logManager = LogManager.getLogManager();
            BytecodeManager.incBytecodes(1);
            final LogManager logManager2 = logManager;
            final String s2 = "sun.util.logging.resources.logging";
            BytecodeManager.incBytecodes(4);
            final Logger demandSystemLogger = logManager2.demandSystemLogger(s, s2);
            BytecodeManager.incBytecodes(1);
            final Logger logger = demandSystemLogger;
            BytecodeManager.incBytecodes(2);
            return logger;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static Logger getAnonymousLogger() {
        try {
            final String s = null;
            BytecodeManager.incBytecodes(2);
            final Logger anonymousLogger = getAnonymousLogger(s);
            BytecodeManager.incBytecodes(1);
            return anonymousLogger;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @CallerSensitive
    public static Logger getAnonymousLogger(final String s) {
        try {
            BytecodeManager.incBytecodes(1);
            final LogManager logManager = LogManager.getLogManager();
            BytecodeManager.incBytecodes(1);
            final LogManager logManager2 = logManager;
            BytecodeManager.incBytecodes(2);
            logManager2.drainLoggerRefQueueBounded();
            final String s2 = null;
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(1);
            final Class callerClass = Reflection.getCallerClass();
            final LogManager logManager3 = logManager;
            final boolean b = false;
            BytecodeManager.incBytecodes(3);
            final Logger logger = new Logger(s2, s, callerClass, logManager3, b);
            BytecodeManager.incBytecodes(1);
            logger.anonymous = true;
            BytecodeManager.incBytecodes(3);
            final LogManager logManager4 = logManager;
            final String s3 = "";
            BytecodeManager.incBytecodes(3);
            final Logger logger2 = logManager4.getLogger(s3);
            BytecodeManager.incBytecodes(1);
            final Logger logger3 = logger;
            final Logger logger4 = logger2;
            BytecodeManager.incBytecodes(3);
            logger3.doSetParent(logger4);
            final Logger logger5 = logger;
            BytecodeManager.incBytecodes(2);
            return logger5;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public ResourceBundle getResourceBundle() {
        try {
            BytecodeManager.incBytecodes(3);
            final String resourceBundleName = this.getResourceBundleName();
            final boolean b = true;
            BytecodeManager.incBytecodes(2);
            final ResourceBundle resourceBundle = this.findResourceBundle(resourceBundleName, b);
            BytecodeManager.incBytecodes(1);
            return resourceBundle;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public String getResourceBundleName() {
        try {
            final String resourceBundleName = this.loggerBundle.resourceBundleName;
            BytecodeManager.incBytecodes(4);
            return resourceBundleName;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void setFilter(final Filter filter) throws SecurityException {
        try {
            BytecodeManager.incBytecodes(2);
            this.checkPermission();
            this.filter = filter;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Filter getFilter() {
        try {
            final Filter filter = this.filter;
            BytecodeManager.incBytecodes(3);
            return filter;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void log(final LogRecord logRecord) {
        try {
            BytecodeManager.incBytecodes(3);
            final Level level = logRecord.getLevel();
            BytecodeManager.incBytecodes(1);
            final boolean loggable = this.isLoggable(level);
            BytecodeManager.incBytecodes(1);
            if (!loggable) {
                BytecodeManager.incBytecodes(1);
                return;
            }
            final Filter filter = this.filter;
            BytecodeManager.incBytecodes(3);
            final Filter filter2 = filter;
            BytecodeManager.incBytecodes(2);
            if (filter2 != null) {
                final Filter filter3 = filter;
                BytecodeManager.incBytecodes(3);
                final boolean loggable2 = filter3.isLoggable(logRecord);
                BytecodeManager.incBytecodes(1);
                if (!loggable2) {
                    BytecodeManager.incBytecodes(1);
                    return;
                }
            }
            Logger logger = this;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final Logger logger2 = logger;
                BytecodeManager.incBytecodes(2);
                if (logger2 == null) {
                    break;
                }
                final boolean isSystemLogger = this.isSystemLogger;
                BytecodeManager.incBytecodes(3);
                Handler[] array;
                if (isSystemLogger) {
                    final Logger logger3 = logger;
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    array = logger3.accessCheckedHandlers();
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    final Logger logger4 = logger;
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    array = logger4.getHandlers();
                }
                final Handler[] array2 = array;
                BytecodeManager.incBytecodes(1);
                final Handler[] array3 = array2;
                final int length = array3.length;
                int n = 0;
                BytecodeManager.incBytecodes(7);
                while (true) {
                    final int n2 = n;
                    final int n3 = length;
                    BytecodeManager.incBytecodes(3);
                    if (n2 >= n3) {
                        break;
                    }
                    final Handler handler = array3[n];
                    BytecodeManager.incBytecodes(4);
                    final Handler handler2 = handler;
                    BytecodeManager.incBytecodes(3);
                    handler2.publish(logRecord);
                    ++n;
                    BytecodeManager.incBytecodes(2);
                }
                final boolean isSystemLogger2 = this.isSystemLogger;
                BytecodeManager.incBytecodes(3);
                boolean b;
                if (isSystemLogger2) {
                    b = logger.useParentHandlers;
                    BytecodeManager.incBytecodes(3);
                }
                else {
                    final Logger logger5 = logger;
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    b = logger5.getUseParentHandlers();
                }
                final boolean b2 = b;
                BytecodeManager.incBytecodes(1);
                final boolean b3 = b2;
                BytecodeManager.incBytecodes(2);
                if (!b3) {
                    BytecodeManager.incBytecodes(1);
                    break;
                }
                final boolean isSystemLogger3 = this.isSystemLogger;
                BytecodeManager.incBytecodes(3);
                Logger logger6;
                if (isSystemLogger3) {
                    logger6 = logger.parent;
                    BytecodeManager.incBytecodes(3);
                }
                else {
                    final Logger logger7 = logger;
                    BytecodeManager.incBytecodes(2);
                    logger6 = logger7.getParent();
                }
                logger = logger6;
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void doLog(final LogRecord logRecord) {
        try {
            final String name = this.name;
            BytecodeManager.incBytecodes(4);
            logRecord.setLoggerName(name);
            BytecodeManager.incBytecodes(2);
            final LoggerBundle effectiveLoggerBundle = this.getEffectiveLoggerBundle();
            BytecodeManager.incBytecodes(1);
            final ResourceBundle userBundle = effectiveLoggerBundle.userBundle;
            BytecodeManager.incBytecodes(3);
            final String resourceBundleName = effectiveLoggerBundle.resourceBundleName;
            BytecodeManager.incBytecodes(3);
            final String s = resourceBundleName;
            BytecodeManager.incBytecodes(2);
            if (s != null) {
                final ResourceBundle resourceBundle = userBundle;
                BytecodeManager.incBytecodes(2);
                if (resourceBundle != null) {
                    final String resourceBundleName2 = resourceBundleName;
                    BytecodeManager.incBytecodes(3);
                    logRecord.setResourceBundleName(resourceBundleName2);
                    final ResourceBundle resourceBundle2 = userBundle;
                    BytecodeManager.incBytecodes(3);
                    logRecord.setResourceBundle(resourceBundle2);
                }
            }
            BytecodeManager.incBytecodes(3);
            this.log(logRecord);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void log(final Level level, final String s) {
        try {
            BytecodeManager.incBytecodes(3);
            final boolean loggable = this.isLoggable(level);
            BytecodeManager.incBytecodes(1);
            if (!loggable) {
                BytecodeManager.incBytecodes(1);
                return;
            }
            BytecodeManager.incBytecodes(5);
            final LogRecord logRecord = new LogRecord(level, s);
            BytecodeManager.incBytecodes(1);
            final LogRecord logRecord2 = logRecord;
            BytecodeManager.incBytecodes(3);
            this.doLog(logRecord2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void log(final Level level, final Supplier<String> supplier) {
        try {
            BytecodeManager.incBytecodes(3);
            final boolean loggable = this.isLoggable(level);
            BytecodeManager.incBytecodes(1);
            if (!loggable) {
                BytecodeManager.incBytecodes(1);
                return;
            }
            BytecodeManager.incBytecodes(5);
            final String s = supplier.get();
            BytecodeManager.incBytecodes(2);
            final LogRecord logRecord = new LogRecord(level, s);
            BytecodeManager.incBytecodes(1);
            final LogRecord logRecord2 = logRecord;
            BytecodeManager.incBytecodes(3);
            this.doLog(logRecord2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void log(final Level level, final String s, final Object o) {
        try {
            BytecodeManager.incBytecodes(3);
            final boolean loggable = this.isLoggable(level);
            BytecodeManager.incBytecodes(1);
            if (!loggable) {
                BytecodeManager.incBytecodes(1);
                return;
            }
            BytecodeManager.incBytecodes(5);
            final LogRecord logRecord = new LogRecord(level, s);
            BytecodeManager.incBytecodes(1);
            final Object[] array = { o };
            BytecodeManager.incBytecodes(6);
            final LogRecord logRecord2 = logRecord;
            final Object[] parameters = array;
            BytecodeManager.incBytecodes(3);
            logRecord2.setParameters(parameters);
            final LogRecord logRecord3 = logRecord;
            BytecodeManager.incBytecodes(3);
            this.doLog(logRecord3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void log(final Level level, final String s, final Object[] parameters) {
        try {
            BytecodeManager.incBytecodes(3);
            final boolean loggable = this.isLoggable(level);
            BytecodeManager.incBytecodes(1);
            if (!loggable) {
                BytecodeManager.incBytecodes(1);
                return;
            }
            BytecodeManager.incBytecodes(5);
            final LogRecord logRecord = new LogRecord(level, s);
            BytecodeManager.incBytecodes(1);
            final LogRecord logRecord2 = logRecord;
            BytecodeManager.incBytecodes(3);
            logRecord2.setParameters(parameters);
            final LogRecord logRecord3 = logRecord;
            BytecodeManager.incBytecodes(3);
            this.doLog(logRecord3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void log(final Level level, final String s, final Throwable thrown) {
        try {
            BytecodeManager.incBytecodes(3);
            final boolean loggable = this.isLoggable(level);
            BytecodeManager.incBytecodes(1);
            if (!loggable) {
                BytecodeManager.incBytecodes(1);
                return;
            }
            BytecodeManager.incBytecodes(5);
            final LogRecord logRecord = new LogRecord(level, s);
            BytecodeManager.incBytecodes(1);
            final LogRecord logRecord2 = logRecord;
            BytecodeManager.incBytecodes(3);
            logRecord2.setThrown(thrown);
            final LogRecord logRecord3 = logRecord;
            BytecodeManager.incBytecodes(3);
            this.doLog(logRecord3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void log(final Level level, final Throwable thrown, final Supplier<String> supplier) {
        try {
            BytecodeManager.incBytecodes(3);
            final boolean loggable = this.isLoggable(level);
            BytecodeManager.incBytecodes(1);
            if (!loggable) {
                BytecodeManager.incBytecodes(1);
                return;
            }
            BytecodeManager.incBytecodes(5);
            final String s = supplier.get();
            BytecodeManager.incBytecodes(2);
            final LogRecord logRecord = new LogRecord(level, s);
            BytecodeManager.incBytecodes(1);
            final LogRecord logRecord2 = logRecord;
            BytecodeManager.incBytecodes(3);
            logRecord2.setThrown(thrown);
            final LogRecord logRecord3 = logRecord;
            BytecodeManager.incBytecodes(3);
            this.doLog(logRecord3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void logp(final Level level, final String sourceClassName, final String sourceMethodName, final String s) {
        try {
            BytecodeManager.incBytecodes(3);
            final boolean loggable = this.isLoggable(level);
            BytecodeManager.incBytecodes(1);
            if (!loggable) {
                BytecodeManager.incBytecodes(1);
                return;
            }
            BytecodeManager.incBytecodes(5);
            final LogRecord logRecord = new LogRecord(level, s);
            BytecodeManager.incBytecodes(1);
            final LogRecord logRecord2 = logRecord;
            BytecodeManager.incBytecodes(3);
            logRecord2.setSourceClassName(sourceClassName);
            final LogRecord logRecord3 = logRecord;
            BytecodeManager.incBytecodes(3);
            logRecord3.setSourceMethodName(sourceMethodName);
            final LogRecord logRecord4 = logRecord;
            BytecodeManager.incBytecodes(3);
            this.doLog(logRecord4);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void logp(final Level level, final String sourceClassName, final String sourceMethodName, final Supplier<String> supplier) {
        try {
            BytecodeManager.incBytecodes(3);
            final boolean loggable = this.isLoggable(level);
            BytecodeManager.incBytecodes(1);
            if (!loggable) {
                BytecodeManager.incBytecodes(1);
                return;
            }
            BytecodeManager.incBytecodes(5);
            final String s = supplier.get();
            BytecodeManager.incBytecodes(2);
            final LogRecord logRecord = new LogRecord(level, s);
            BytecodeManager.incBytecodes(1);
            final LogRecord logRecord2 = logRecord;
            BytecodeManager.incBytecodes(3);
            logRecord2.setSourceClassName(sourceClassName);
            final LogRecord logRecord3 = logRecord;
            BytecodeManager.incBytecodes(3);
            logRecord3.setSourceMethodName(sourceMethodName);
            final LogRecord logRecord4 = logRecord;
            BytecodeManager.incBytecodes(3);
            this.doLog(logRecord4);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void logp(final Level level, final String sourceClassName, final String sourceMethodName, final String s, final Object o) {
        try {
            BytecodeManager.incBytecodes(3);
            final boolean loggable = this.isLoggable(level);
            BytecodeManager.incBytecodes(1);
            if (!loggable) {
                BytecodeManager.incBytecodes(1);
                return;
            }
            BytecodeManager.incBytecodes(5);
            final LogRecord logRecord = new LogRecord(level, s);
            BytecodeManager.incBytecodes(1);
            final LogRecord logRecord2 = logRecord;
            BytecodeManager.incBytecodes(3);
            logRecord2.setSourceClassName(sourceClassName);
            final LogRecord logRecord3 = logRecord;
            BytecodeManager.incBytecodes(3);
            logRecord3.setSourceMethodName(sourceMethodName);
            final Object[] array = { o };
            BytecodeManager.incBytecodes(6);
            final LogRecord logRecord4 = logRecord;
            final Object[] parameters = array;
            BytecodeManager.incBytecodes(3);
            logRecord4.setParameters(parameters);
            final LogRecord logRecord5 = logRecord;
            BytecodeManager.incBytecodes(3);
            this.doLog(logRecord5);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void logp(final Level level, final String sourceClassName, final String sourceMethodName, final String s, final Object[] parameters) {
        try {
            BytecodeManager.incBytecodes(3);
            final boolean loggable = this.isLoggable(level);
            BytecodeManager.incBytecodes(1);
            if (!loggable) {
                BytecodeManager.incBytecodes(1);
                return;
            }
            BytecodeManager.incBytecodes(5);
            final LogRecord logRecord = new LogRecord(level, s);
            BytecodeManager.incBytecodes(1);
            final LogRecord logRecord2 = logRecord;
            BytecodeManager.incBytecodes(3);
            logRecord2.setSourceClassName(sourceClassName);
            final LogRecord logRecord3 = logRecord;
            BytecodeManager.incBytecodes(3);
            logRecord3.setSourceMethodName(sourceMethodName);
            final LogRecord logRecord4 = logRecord;
            BytecodeManager.incBytecodes(3);
            logRecord4.setParameters(parameters);
            final LogRecord logRecord5 = logRecord;
            BytecodeManager.incBytecodes(3);
            this.doLog(logRecord5);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void logp(final Level level, final String sourceClassName, final String sourceMethodName, final String s, final Throwable thrown) {
        try {
            BytecodeManager.incBytecodes(3);
            final boolean loggable = this.isLoggable(level);
            BytecodeManager.incBytecodes(1);
            if (!loggable) {
                BytecodeManager.incBytecodes(1);
                return;
            }
            BytecodeManager.incBytecodes(5);
            final LogRecord logRecord = new LogRecord(level, s);
            BytecodeManager.incBytecodes(1);
            final LogRecord logRecord2 = logRecord;
            BytecodeManager.incBytecodes(3);
            logRecord2.setSourceClassName(sourceClassName);
            final LogRecord logRecord3 = logRecord;
            BytecodeManager.incBytecodes(3);
            logRecord3.setSourceMethodName(sourceMethodName);
            final LogRecord logRecord4 = logRecord;
            BytecodeManager.incBytecodes(3);
            logRecord4.setThrown(thrown);
            final LogRecord logRecord5 = logRecord;
            BytecodeManager.incBytecodes(3);
            this.doLog(logRecord5);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void logp(final Level level, final String sourceClassName, final String sourceMethodName, final Throwable thrown, final Supplier<String> supplier) {
        try {
            BytecodeManager.incBytecodes(3);
            final boolean loggable = this.isLoggable(level);
            BytecodeManager.incBytecodes(1);
            if (!loggable) {
                BytecodeManager.incBytecodes(1);
                return;
            }
            BytecodeManager.incBytecodes(5);
            final String s = supplier.get();
            BytecodeManager.incBytecodes(2);
            final LogRecord logRecord = new LogRecord(level, s);
            BytecodeManager.incBytecodes(1);
            final LogRecord logRecord2 = logRecord;
            BytecodeManager.incBytecodes(3);
            logRecord2.setSourceClassName(sourceClassName);
            final LogRecord logRecord3 = logRecord;
            BytecodeManager.incBytecodes(3);
            logRecord3.setSourceMethodName(sourceMethodName);
            final LogRecord logRecord4 = logRecord;
            BytecodeManager.incBytecodes(3);
            logRecord4.setThrown(thrown);
            final LogRecord logRecord5 = logRecord;
            BytecodeManager.incBytecodes(3);
            this.doLog(logRecord5);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void doLog(final LogRecord logRecord, final String resourceBundleName) {
        try {
            final String name = this.name;
            BytecodeManager.incBytecodes(4);
            logRecord.setLoggerName(name);
            BytecodeManager.incBytecodes(2);
            if (resourceBundleName != null) {
                BytecodeManager.incBytecodes(3);
                logRecord.setResourceBundleName(resourceBundleName);
                final boolean b = false;
                BytecodeManager.incBytecodes(5);
                final ResourceBundle resourceBundle = this.findResourceBundle(resourceBundleName, b);
                BytecodeManager.incBytecodes(1);
                logRecord.setResourceBundle(resourceBundle);
            }
            BytecodeManager.incBytecodes(3);
            this.log(logRecord);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void doLog(final LogRecord logRecord, final ResourceBundle resourceBundle) {
        try {
            final String name = this.name;
            BytecodeManager.incBytecodes(4);
            logRecord.setLoggerName(name);
            BytecodeManager.incBytecodes(2);
            if (resourceBundle != null) {
                BytecodeManager.incBytecodes(3);
                final String baseBundleName = resourceBundle.getBaseBundleName();
                BytecodeManager.incBytecodes(1);
                logRecord.setResourceBundleName(baseBundleName);
                BytecodeManager.incBytecodes(3);
                logRecord.setResourceBundle(resourceBundle);
            }
            BytecodeManager.incBytecodes(3);
            this.log(logRecord);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Deprecated
    public void logrb(final Level level, final String sourceClassName, final String sourceMethodName, final String s, final String s2) {
        try {
            BytecodeManager.incBytecodes(3);
            final boolean loggable = this.isLoggable(level);
            BytecodeManager.incBytecodes(1);
            if (!loggable) {
                BytecodeManager.incBytecodes(1);
                return;
            }
            BytecodeManager.incBytecodes(5);
            final LogRecord logRecord = new LogRecord(level, s2);
            BytecodeManager.incBytecodes(1);
            final LogRecord logRecord2 = logRecord;
            BytecodeManager.incBytecodes(3);
            logRecord2.setSourceClassName(sourceClassName);
            final LogRecord logRecord3 = logRecord;
            BytecodeManager.incBytecodes(3);
            logRecord3.setSourceMethodName(sourceMethodName);
            final LogRecord logRecord4 = logRecord;
            BytecodeManager.incBytecodes(4);
            this.doLog(logRecord4, s);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Deprecated
    public void logrb(final Level level, final String sourceClassName, final String sourceMethodName, final String s, final String s2, final Object o) {
        try {
            BytecodeManager.incBytecodes(3);
            final boolean loggable = this.isLoggable(level);
            BytecodeManager.incBytecodes(1);
            if (!loggable) {
                BytecodeManager.incBytecodes(1);
                return;
            }
            BytecodeManager.incBytecodes(5);
            final LogRecord logRecord = new LogRecord(level, s2);
            BytecodeManager.incBytecodes(1);
            final LogRecord logRecord2 = logRecord;
            BytecodeManager.incBytecodes(3);
            logRecord2.setSourceClassName(sourceClassName);
            final LogRecord logRecord3 = logRecord;
            BytecodeManager.incBytecodes(3);
            logRecord3.setSourceMethodName(sourceMethodName);
            final Object[] array = { o };
            BytecodeManager.incBytecodes(6);
            final LogRecord logRecord4 = logRecord;
            final Object[] parameters = array;
            BytecodeManager.incBytecodes(3);
            logRecord4.setParameters(parameters);
            final LogRecord logRecord5 = logRecord;
            BytecodeManager.incBytecodes(4);
            this.doLog(logRecord5, s);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Deprecated
    public void logrb(final Level level, final String sourceClassName, final String sourceMethodName, final String s, final String s2, final Object[] parameters) {
        try {
            BytecodeManager.incBytecodes(3);
            final boolean loggable = this.isLoggable(level);
            BytecodeManager.incBytecodes(1);
            if (!loggable) {
                BytecodeManager.incBytecodes(1);
                return;
            }
            BytecodeManager.incBytecodes(5);
            final LogRecord logRecord = new LogRecord(level, s2);
            BytecodeManager.incBytecodes(1);
            final LogRecord logRecord2 = logRecord;
            BytecodeManager.incBytecodes(3);
            logRecord2.setSourceClassName(sourceClassName);
            final LogRecord logRecord3 = logRecord;
            BytecodeManager.incBytecodes(3);
            logRecord3.setSourceMethodName(sourceMethodName);
            final LogRecord logRecord4 = logRecord;
            BytecodeManager.incBytecodes(3);
            logRecord4.setParameters(parameters);
            final LogRecord logRecord5 = logRecord;
            BytecodeManager.incBytecodes(4);
            this.doLog(logRecord5, s);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void logrb(final Level level, final String sourceClassName, final String sourceMethodName, final ResourceBundle resourceBundle, final String s, final Object... parameters) {
        try {
            BytecodeManager.incBytecodes(3);
            final boolean loggable = this.isLoggable(level);
            BytecodeManager.incBytecodes(1);
            if (!loggable) {
                BytecodeManager.incBytecodes(1);
                return;
            }
            BytecodeManager.incBytecodes(5);
            final LogRecord logRecord = new LogRecord(level, s);
            BytecodeManager.incBytecodes(1);
            final LogRecord logRecord2 = logRecord;
            BytecodeManager.incBytecodes(3);
            logRecord2.setSourceClassName(sourceClassName);
            final LogRecord logRecord3 = logRecord;
            BytecodeManager.incBytecodes(3);
            logRecord3.setSourceMethodName(sourceMethodName);
            BytecodeManager.incBytecodes(2);
            if (parameters != null) {
                final int length = parameters.length;
                BytecodeManager.incBytecodes(3);
                if (length != 0) {
                    final LogRecord logRecord4 = logRecord;
                    BytecodeManager.incBytecodes(3);
                    logRecord4.setParameters(parameters);
                }
            }
            final LogRecord logRecord5 = logRecord;
            BytecodeManager.incBytecodes(4);
            this.doLog(logRecord5, resourceBundle);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Deprecated
    public void logrb(final Level level, final String sourceClassName, final String sourceMethodName, final String s, final String s2, final Throwable thrown) {
        try {
            BytecodeManager.incBytecodes(3);
            final boolean loggable = this.isLoggable(level);
            BytecodeManager.incBytecodes(1);
            if (!loggable) {
                BytecodeManager.incBytecodes(1);
                return;
            }
            BytecodeManager.incBytecodes(5);
            final LogRecord logRecord = new LogRecord(level, s2);
            BytecodeManager.incBytecodes(1);
            final LogRecord logRecord2 = logRecord;
            BytecodeManager.incBytecodes(3);
            logRecord2.setSourceClassName(sourceClassName);
            final LogRecord logRecord3 = logRecord;
            BytecodeManager.incBytecodes(3);
            logRecord3.setSourceMethodName(sourceMethodName);
            final LogRecord logRecord4 = logRecord;
            BytecodeManager.incBytecodes(3);
            logRecord4.setThrown(thrown);
            final LogRecord logRecord5 = logRecord;
            BytecodeManager.incBytecodes(4);
            this.doLog(logRecord5, s);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void logrb(final Level level, final String sourceClassName, final String sourceMethodName, final ResourceBundle resourceBundle, final String s, final Throwable thrown) {
        try {
            BytecodeManager.incBytecodes(3);
            final boolean loggable = this.isLoggable(level);
            BytecodeManager.incBytecodes(1);
            if (!loggable) {
                BytecodeManager.incBytecodes(1);
                return;
            }
            BytecodeManager.incBytecodes(5);
            final LogRecord logRecord = new LogRecord(level, s);
            BytecodeManager.incBytecodes(1);
            final LogRecord logRecord2 = logRecord;
            BytecodeManager.incBytecodes(3);
            logRecord2.setSourceClassName(sourceClassName);
            final LogRecord logRecord3 = logRecord;
            BytecodeManager.incBytecodes(3);
            logRecord3.setSourceMethodName(sourceMethodName);
            final LogRecord logRecord4 = logRecord;
            BytecodeManager.incBytecodes(3);
            logRecord4.setThrown(thrown);
            final LogRecord logRecord5 = logRecord;
            BytecodeManager.incBytecodes(4);
            this.doLog(logRecord5, resourceBundle);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void entering(final String s, final String s2) {
        try {
            final Level finer = Level.FINER;
            final String s3 = "ENTRY";
            BytecodeManager.incBytecodes(6);
            this.logp(finer, s, s2, s3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void entering(final String s, final String s2, final Object o) {
        try {
            final Level finer = Level.FINER;
            final String s3 = "ENTRY {0}";
            BytecodeManager.incBytecodes(7);
            this.logp(finer, s, s2, s3, o);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void entering(final String s, final String s2, final Object[] array) {
        try {
            String string = "ENTRY";
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            if (array == null) {
                final Level finer = Level.FINER;
                final String s3 = string;
                BytecodeManager.incBytecodes(6);
                this.logp(finer, s, s2, s3);
                BytecodeManager.incBytecodes(1);
                return;
            }
            final Level finer2 = Level.FINER;
            BytecodeManager.incBytecodes(3);
            final boolean loggable = this.isLoggable(finer2);
            BytecodeManager.incBytecodes(1);
            if (!loggable) {
                BytecodeManager.incBytecodes(1);
                return;
            }
            int n = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n2 = n;
                final int length = array.length;
                BytecodeManager.incBytecodes(4);
                if (n2 >= length) {
                    break;
                }
                BytecodeManager.incBytecodes(3);
                final StringBuilder sb = new StringBuilder();
                final String str = string;
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb.append(str);
                final String str2 = " {";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append2 = append.append(str2);
                final int i = n;
                BytecodeManager.incBytecodes(2);
                final StringBuilder append3 = append2.append(i);
                final String str3 = "}";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append4 = append3.append(str3);
                BytecodeManager.incBytecodes(1);
                string = append4.toString();
                BytecodeManager.incBytecodes(1);
                ++n;
                BytecodeManager.incBytecodes(2);
            }
            final Level finer3 = Level.FINER;
            final String s4 = string;
            BytecodeManager.incBytecodes(7);
            this.logp(finer3, s, s2, s4, array);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void exiting(final String s, final String s2) {
        try {
            final Level finer = Level.FINER;
            final String s3 = "RETURN";
            BytecodeManager.incBytecodes(6);
            this.logp(finer, s, s2, s3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void exiting(final String s, final String s2, final Object o) {
        try {
            final Level finer = Level.FINER;
            final String s3 = "RETURN {0}";
            BytecodeManager.incBytecodes(7);
            this.logp(finer, s, s2, s3, o);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void throwing(final String sourceClassName, final String sourceMethodName, final Throwable thrown) {
        try {
            final Level finer = Level.FINER;
            BytecodeManager.incBytecodes(3);
            final boolean loggable = this.isLoggable(finer);
            BytecodeManager.incBytecodes(1);
            if (!loggable) {
                BytecodeManager.incBytecodes(1);
                return;
            }
            final Level finer2 = Level.FINER;
            final String s = "THROW";
            BytecodeManager.incBytecodes(5);
            final LogRecord logRecord = new LogRecord(finer2, s);
            BytecodeManager.incBytecodes(1);
            final LogRecord logRecord2 = logRecord;
            BytecodeManager.incBytecodes(3);
            logRecord2.setSourceClassName(sourceClassName);
            final LogRecord logRecord3 = logRecord;
            BytecodeManager.incBytecodes(3);
            logRecord3.setSourceMethodName(sourceMethodName);
            final LogRecord logRecord4 = logRecord;
            BytecodeManager.incBytecodes(3);
            logRecord4.setThrown(thrown);
            final LogRecord logRecord5 = logRecord;
            BytecodeManager.incBytecodes(3);
            this.doLog(logRecord5);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void severe(final String s) {
        try {
            final Level severe = Level.SEVERE;
            BytecodeManager.incBytecodes(4);
            this.log(severe, s);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void warning(final String s) {
        try {
            final Level warning = Level.WARNING;
            BytecodeManager.incBytecodes(4);
            this.log(warning, s);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void info(final String s) {
        try {
            final Level info = Level.INFO;
            BytecodeManager.incBytecodes(4);
            this.log(info, s);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void config(final String s) {
        try {
            final Level config = Level.CONFIG;
            BytecodeManager.incBytecodes(4);
            this.log(config, s);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void fine(final String s) {
        try {
            final Level fine = Level.FINE;
            BytecodeManager.incBytecodes(4);
            this.log(fine, s);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void finer(final String s) {
        try {
            final Level finer = Level.FINER;
            BytecodeManager.incBytecodes(4);
            this.log(finer, s);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void finest(final String s) {
        try {
            final Level finest = Level.FINEST;
            BytecodeManager.incBytecodes(4);
            this.log(finest, s);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void severe(final Supplier<String> supplier) {
        try {
            final Level severe = Level.SEVERE;
            BytecodeManager.incBytecodes(4);
            this.log(severe, supplier);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void warning(final Supplier<String> supplier) {
        try {
            final Level warning = Level.WARNING;
            BytecodeManager.incBytecodes(4);
            this.log(warning, supplier);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void info(final Supplier<String> supplier) {
        try {
            final Level info = Level.INFO;
            BytecodeManager.incBytecodes(4);
            this.log(info, supplier);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void config(final Supplier<String> supplier) {
        try {
            final Level config = Level.CONFIG;
            BytecodeManager.incBytecodes(4);
            this.log(config, supplier);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void fine(final Supplier<String> supplier) {
        try {
            final Level fine = Level.FINE;
            BytecodeManager.incBytecodes(4);
            this.log(fine, supplier);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void finer(final Supplier<String> supplier) {
        try {
            final Level finer = Level.FINER;
            BytecodeManager.incBytecodes(4);
            this.log(finer, supplier);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void finest(final Supplier<String> supplier) {
        try {
            final Level finest = Level.FINEST;
            BytecodeManager.incBytecodes(4);
            this.log(finest, supplier);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void setLevel(final Level p0) throws SecurityException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             2
        //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     6: invokespecial   instrumented/java/util/logging/Logger.checkPermission:()V
        //     9: getstatic       instrumented/java/util/logging/Logger.treeLock:Ljava/lang/Object;
        //    12: dup            
        //    13: astore_2       
        //    14: pop            
        //    15: ldc             4
        //    17: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    20: aload_0        
        //    21: aload_1        
        //    22: putfield        instrumented/java/util/logging/Logger.levelObject:Linstrumented/java/util/logging/Level;
        //    25: ldc             3
        //    27: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    30: aload_0        
        //    31: ldc             2
        //    33: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    36: invokespecial   instrumented/java/util/logging/Logger.updateEffectiveLevel:()V
        //    39: aload_2        
        //    40: pop            
        //    41: ldc             2
        //    43: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    46: ldc             1
        //    48: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    51: goto            70
        //    54: astore_3       
        //    55: aload_2        
        //    56: pop            
        //    57: ldc_w           503
        //    60: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    63: aload_3        
        //    64: ldc             2
        //    66: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    69: athrow         
        //    70: ldc             1
        //    72: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    75: return         
        //    76: athrow         
        //    77: athrow         
        //    Exceptions:
        //  throws java.lang.SecurityException
        //    StackMapTable: 00 04 FF 00 36 00 03 07 00 02 07 00 75 07 00 04 00 01 07 00 53 FA 00 0F FF 00 05 00 00 00 01 07 00 53 FF 00 00 00 00 00 01 07 01 9A
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  20     77     77     78     Ljava/lang/VirtualMachineError;
        //  20     46     54     70     Any
        //  54     63     54     70     Any
        //  0      76     76     77     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0070:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2596)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    final boolean isLevelInitialized() {
        try {
            final Level levelObject = this.levelObject;
            BytecodeManager.incBytecodes(3);
            boolean b;
            if (levelObject != null) {
                b = true;
                BytecodeManager.incBytecodes(2);
            }
            else {
                b = false;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return b;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Level getLevel() {
        try {
            final Level levelObject = this.levelObject;
            BytecodeManager.incBytecodes(3);
            return levelObject;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public boolean isLoggable(final Level level) {
        try {
            BytecodeManager.incBytecodes(2);
            final int intValue = level.intValue();
            final int levelValue = this.levelValue;
            BytecodeManager.incBytecodes(3);
            if (intValue >= levelValue) {
                final int levelValue2 = this.levelValue;
                final int offValue = Logger.offValue;
                BytecodeManager.incBytecodes(4);
                if (levelValue2 != offValue) {
                    final boolean b = true;
                    BytecodeManager.incBytecodes(2);
                    return b;
                }
            }
            final boolean b2 = false;
            BytecodeManager.incBytecodes(2);
            return b2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public String getName() {
        try {
            final String name = this.name;
            BytecodeManager.incBytecodes(3);
            return name;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void addHandler(final Handler handler) throws SecurityException {
        try {
            BytecodeManager.incBytecodes(2);
            handler.getClass();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            this.checkPermission();
            final CopyOnWriteArrayList<Handler> handlers = this.handlers;
            BytecodeManager.incBytecodes(4);
            handlers.add(handler);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void removeHandler(final Handler handler) throws SecurityException {
        try {
            BytecodeManager.incBytecodes(2);
            this.checkPermission();
            BytecodeManager.incBytecodes(2);
            if (handler == null) {
                BytecodeManager.incBytecodes(1);
                return;
            }
            final CopyOnWriteArrayList<Handler> handlers = this.handlers;
            BytecodeManager.incBytecodes(4);
            handlers.remove(handler);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Handler[] getHandlers() {
        try {
            BytecodeManager.incBytecodes(2);
            final Handler[] accessCheckedHandlers = this.accessCheckedHandlers();
            BytecodeManager.incBytecodes(1);
            return accessCheckedHandlers;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    Handler[] accessCheckedHandlers() {
        try {
            final CopyOnWriteArrayList<Handler> handlers = this.handlers;
            final Handler[] emptyHandlers = Logger.emptyHandlers;
            BytecodeManager.incBytecodes(4);
            final Handler[] array = handlers.toArray(emptyHandlers);
            BytecodeManager.incBytecodes(2);
            return array;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void setUseParentHandlers(final boolean useParentHandlers) {
        try {
            BytecodeManager.incBytecodes(2);
            this.checkPermission();
            this.useParentHandlers = useParentHandlers;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public boolean getUseParentHandlers() {
        try {
            final boolean useParentHandlers = this.useParentHandlers;
            BytecodeManager.incBytecodes(3);
            return useParentHandlers;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static ResourceBundle findSystemResourceBundle(final Locale locale) {
        try {
            BytecodeManager.incBytecodes(4);
            final PrivilegedAction<ResourceBundle> action = new PrivilegedAction<ResourceBundle>() {
                {
                    BytecodeManager.incBytecodes(1);
                }
                
                @Override
                public ResourceBundle run() {
                    try {
                        try {
                            final String s = "sun.util.logging.resources.logging";
                            final Locale val$locale = locale;
                            BytecodeManager.incBytecodes(3);
                            BytecodeManager.incBytecodes(1);
                            final ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
                            BytecodeManager.incBytecodes(1);
                            final ResourceBundle bundle = ResourceBundle.getBundle(s, val$locale, systemClassLoader);
                            BytecodeManager.incBytecodes(1);
                            return bundle;
                        }
                        catch (MissingResourceException ex2) {
                            BytecodeManager.incBytecodes(501);
                            final MissingResourceException ex = ex2;
                            BytecodeManager.incBytecodes(4);
                            final String string = ex.toString();
                            BytecodeManager.incBytecodes(1);
                            final InternalError internalError = new InternalError(string);
                            BytecodeManager.incBytecodes(1);
                            throw internalError;
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                    catch (VirtualMachineError virtualMachineError) {
                        throw virtualMachineError;
                    }
                }
            };
            BytecodeManager.incBytecodes(1);
            final ResourceBundle resourceBundle = AccessController.doPrivileged((PrivilegedAction<ResourceBundle>)action);
            BytecodeManager.incBytecodes(2);
            return resourceBundle;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private synchronized ResourceBundle findResourceBundle(final String p0, final boolean p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             2
        //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     6: ifnonnull       16
        //     9: aconst_null    
        //    10: ldc             2
        //    12: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    15: areturn        
        //    16: ldc             1
        //    18: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    21: invokestatic    instrumented/java/util/Locale.getDefault:()Linstrumented/java/util/Locale;
        //    24: astore_3       
        //    25: ldc             1
        //    27: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    30: aload_0        
        //    31: getfield        instrumented/java/util/logging/Logger.loggerBundle:Linstrumented/java/util/logging/Logger$LoggerBundle;
        //    34: astore          4
        //    36: ldc             3
        //    38: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    41: aload           4
        //    43: getfield        instrumented/java/util/logging/Logger$LoggerBundle.userBundle:Linstrumented/java/util/ResourceBundle;
        //    46: ldc             3
        //    48: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    51: ifnull          92
        //    54: aload_1        
        //    55: aload           4
        //    57: getfield        instrumented/java/util/logging/Logger$LoggerBundle.resourceBundleName:Ljava/lang/String;
        //    60: ldc             3
        //    62: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    65: ldc             1
        //    67: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    70: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //    73: ldc             1
        //    75: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    78: ifeq            92
        //    81: aload           4
        //    83: getfield        instrumented/java/util/logging/Logger$LoggerBundle.userBundle:Linstrumented/java/util/ResourceBundle;
        //    86: ldc             3
        //    88: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    91: areturn        
        //    92: aload_0        
        //    93: getfield        instrumented/java/util/logging/Logger.catalog:Linstrumented/java/util/ResourceBundle;
        //    96: ldc             3
        //    98: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   101: ifnull          161
        //   104: aload_3        
        //   105: aload_0        
        //   106: getfield        instrumented/java/util/logging/Logger.catalogLocale:Linstrumented/java/util/Locale;
        //   109: ldc             4
        //   111: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   114: invokevirtual   instrumented/java/util/Locale.equals:(Ljava/lang/Object;)Z
        //   117: ldc             1
        //   119: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   122: ifeq            161
        //   125: aload_1        
        //   126: aload_0        
        //   127: getfield        instrumented/java/util/logging/Logger.catalogName:Ljava/lang/String;
        //   130: ldc             3
        //   132: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   135: ldc             1
        //   137: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   140: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   143: ldc             1
        //   145: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   148: ifeq            161
        //   151: aload_0        
        //   152: getfield        instrumented/java/util/logging/Logger.catalog:Linstrumented/java/util/ResourceBundle;
        //   155: ldc             3
        //   157: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   160: areturn        
        //   161: aload_1        
        //   162: ldc             "sun.util.logging.resources.logging"
        //   164: ldc             3
        //   166: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   169: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   172: ldc             1
        //   174: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   177: ifeq            228
        //   180: aload_0        
        //   181: aload_3        
        //   182: ldc             3
        //   184: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   187: invokestatic    instrumented/java/util/logging/Logger.findSystemResourceBundle:(Linstrumented/java/util/Locale;)Linstrumented/java/util/ResourceBundle;
        //   190: putfield        instrumented/java/util/logging/Logger.catalog:Linstrumented/java/util/ResourceBundle;
        //   193: ldc             1
        //   195: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   198: aload_0        
        //   199: aload_1        
        //   200: putfield        instrumented/java/util/logging/Logger.catalogName:Ljava/lang/String;
        //   203: ldc             3
        //   205: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   208: aload_0        
        //   209: aload_3        
        //   210: putfield        instrumented/java/util/logging/Logger.catalogLocale:Linstrumented/java/util/Locale;
        //   213: ldc             3
        //   215: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   218: aload_0        
        //   219: getfield        instrumented/java/util/logging/Logger.catalog:Linstrumented/java/util/ResourceBundle;
        //   222: ldc             3
        //   224: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   227: areturn        
        //   228: ldc             1
        //   230: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   233: invokestatic    java/lang/Thread.currentThread:()Ljava/lang/Thread;
        //   236: ldc             1
        //   238: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   241: invokevirtual   java/lang/Thread.getContextClassLoader:()Ljava/lang/ClassLoader;
        //   244: astore          5
        //   246: ldc             1
        //   248: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   251: aload           5
        //   253: ldc             2
        //   255: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   258: ifnonnull       276
        //   261: ldc             1
        //   263: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   266: invokestatic    java/lang/ClassLoader.getSystemClassLoader:()Ljava/lang/ClassLoader;
        //   269: astore          5
        //   271: ldc             1
        //   273: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   276: aload_0        
        //   277: aload_1        
        //   278: aload_3        
        //   279: aload           5
        //   281: ldc             5
        //   283: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   286: invokestatic    instrumented/java/util/ResourceBundle.getBundle:(Ljava/lang/String;Linstrumented/java/util/Locale;Ljava/lang/ClassLoader;)Linstrumented/java/util/ResourceBundle;
        //   289: putfield        instrumented/java/util/logging/Logger.catalog:Linstrumented/java/util/ResourceBundle;
        //   292: ldc             1
        //   294: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   297: aload_0        
        //   298: aload_1        
        //   299: putfield        instrumented/java/util/logging/Logger.catalogName:Ljava/lang/String;
        //   302: ldc             3
        //   304: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   307: aload_0        
        //   308: aload_3        
        //   309: putfield        instrumented/java/util/logging/Logger.catalogLocale:Linstrumented/java/util/Locale;
        //   312: ldc             3
        //   314: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   317: aload_0        
        //   318: getfield        instrumented/java/util/logging/Logger.catalog:Linstrumented/java/util/ResourceBundle;
        //   321: ldc             2
        //   323: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   326: ldc             1
        //   328: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   331: areturn        
        //   332: astore          6
        //   334: ldc_w           501
        //   337: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   340: iload_2        
        //   341: ldc             2
        //   343: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   346: ifeq            465
        //   349: aload_0        
        //   350: ldc             2
        //   352: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   355: invokespecial   instrumented/java/util/logging/Logger.getCallersClassLoader:()Ljava/lang/ClassLoader;
        //   358: astore          6
        //   360: ldc             1
        //   362: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   365: aload           6
        //   367: ldc             2
        //   369: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   372: ifnull          387
        //   375: aload           6
        //   377: aload           5
        //   379: ldc             3
        //   381: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   384: if_acmpne       394
        //   387: aconst_null    
        //   388: ldc             2
        //   390: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   393: areturn        
        //   394: aload_0        
        //   395: aload_1        
        //   396: aload_3        
        //   397: aload           6
        //   399: ldc             5
        //   401: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   404: invokestatic    instrumented/java/util/ResourceBundle.getBundle:(Ljava/lang/String;Linstrumented/java/util/Locale;Ljava/lang/ClassLoader;)Linstrumented/java/util/ResourceBundle;
        //   407: putfield        instrumented/java/util/logging/Logger.catalog:Linstrumented/java/util/ResourceBundle;
        //   410: ldc             1
        //   412: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   415: aload_0        
        //   416: aload_1        
        //   417: putfield        instrumented/java/util/logging/Logger.catalogName:Ljava/lang/String;
        //   420: ldc             3
        //   422: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   425: aload_0        
        //   426: aload_3        
        //   427: putfield        instrumented/java/util/logging/Logger.catalogLocale:Linstrumented/java/util/Locale;
        //   430: ldc             3
        //   432: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   435: aload_0        
        //   436: getfield        instrumented/java/util/logging/Logger.catalog:Linstrumented/java/util/ResourceBundle;
        //   439: ldc             2
        //   441: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   444: ldc             1
        //   446: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   449: areturn        
        //   450: astore          7
        //   452: ldc_w           501
        //   455: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   458: aconst_null    
        //   459: ldc             2
        //   461: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   464: areturn        
        //   465: aconst_null    
        //   466: ldc             2
        //   468: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   471: areturn        
        //   472: athrow         
        //   473: athrow         
        //    StackMapTable: 00 0C 10 FD 00 4B 07 01 CA 07 00 0E FB 00 44 FB 00 42 FC 00 2F 07 00 88 77 07 01 C8 FC 00 36 07 00 88 06 77 07 01 C8 FA 00 0E FF 00 06 00 00 00 01 07 00 53 FF 00 00 00 00 00 01 07 01 9A
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                             
        //  -----  -----  -----  -----  -------------------------------------------------
        //  276    473    473    474    Ljava/lang/VirtualMachineError;
        //  276    326    332    472    Linstrumented/java/util/MissingResourceException;
        //  394    444    450    465    Linstrumented/java/util/MissingResourceException;
        //  0      472    472    473    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0276:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2596)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private synchronized void setupResourceInfo(final String str, final Class<?> callersClassLoaderRef) {
        try {
            final LoggerBundle loggerBundle = this.loggerBundle;
            BytecodeManager.incBytecodes(3);
            final String resourceBundleName = loggerBundle.resourceBundleName;
            BytecodeManager.incBytecodes(3);
            if (resourceBundleName != null) {
                final String resourceBundleName2 = loggerBundle.resourceBundleName;
                BytecodeManager.incBytecodes(4);
                final boolean equals = resourceBundleName2.equals(str);
                BytecodeManager.incBytecodes(1);
                if (equals) {
                    BytecodeManager.incBytecodes(1);
                    return;
                }
                BytecodeManager.incBytecodes(5);
                final StringBuilder sb = new StringBuilder();
                final String resourceBundleName3 = loggerBundle.resourceBundleName;
                BytecodeManager.incBytecodes(3);
                final StringBuilder append = sb.append(resourceBundleName3);
                final String str2 = " != ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append2 = append.append(str2);
                BytecodeManager.incBytecodes(2);
                final StringBuilder append3 = append2.append(str);
                BytecodeManager.incBytecodes(1);
                final String string = append3.toString();
                BytecodeManager.incBytecodes(1);
                final IllegalArgumentException ex = new IllegalArgumentException(string);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            else {
                BytecodeManager.incBytecodes(2);
                if (str == null) {
                    BytecodeManager.incBytecodes(1);
                    return;
                }
                BytecodeManager.incBytecodes(3);
                this.setCallersClassLoaderRef(callersClassLoaderRef);
                final boolean isSystemLogger = this.isSystemLogger;
                BytecodeManager.incBytecodes(3);
                if (isSystemLogger) {
                    BytecodeManager.incBytecodes(2);
                    final ClassLoader callersClassLoader = this.getCallersClassLoader();
                    BytecodeManager.incBytecodes(1);
                    if (callersClassLoader != null) {
                        BytecodeManager.incBytecodes(2);
                        this.checkPermission();
                    }
                }
                final boolean b = true;
                BytecodeManager.incBytecodes(4);
                final ResourceBundle resourceBundle = this.findResourceBundle(str, b);
                BytecodeManager.incBytecodes(1);
                if (resourceBundle == null) {
                    this.callersClassLoaderRef = null;
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(5);
                    final StringBuilder sb2 = new StringBuilder();
                    final String str3 = "Can't find ";
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append4 = sb2.append(str3);
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append5 = append4.append(str);
                    final String str4 = " bundle";
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append6 = append5.append(str4);
                    BytecodeManager.incBytecodes(1);
                    final String string2 = append6.toString();
                    final String s = "";
                    BytecodeManager.incBytecodes(3);
                    final MissingResourceException ex2 = new MissingResourceException(string2, str, s);
                    BytecodeManager.incBytecodes(1);
                    throw ex2;
                }
                final boolean $assertionsDisabled = Logger.$assertionsDisabled;
                BytecodeManager.incBytecodes(2);
                if (!$assertionsDisabled) {
                    final ResourceBundle userBundle = loggerBundle.userBundle;
                    BytecodeManager.incBytecodes(3);
                    if (userBundle != null) {
                        BytecodeManager.incBytecodes(3);
                        final AssertionError assertionError = new AssertionError();
                        BytecodeManager.incBytecodes(1);
                        throw assertionError;
                    }
                }
                final ResourceBundle resourceBundle2 = null;
                BytecodeManager.incBytecodes(4);
                this.loggerBundle = LoggerBundle.get(str, resourceBundle2);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void setResourceBundle(final ResourceBundle p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             2
        //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     6: invokespecial   instrumented/java/util/logging/Logger.checkPermission:()V
        //     9: aload_1        
        //    10: ldc             2
        //    12: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    15: invokevirtual   instrumented/java/util/ResourceBundle.getBaseBundleName:()Ljava/lang/String;
        //    18: astore_2       
        //    19: ldc             1
        //    21: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    24: aload_2        
        //    25: ldc             2
        //    27: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    30: ifnull          50
        //    33: aload_2        
        //    34: ldc             2
        //    36: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    39: invokevirtual   java/lang/String.isEmpty:()Z
        //    42: ldc             1
        //    44: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    47: ifeq            71
        //    50: new             Ljava/lang/IllegalArgumentException;
        //    53: dup            
        //    54: ldc_w           "resource bundle must have a name"
        //    57: ldc             4
        //    59: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    62: invokespecial   java/lang/IllegalArgumentException.<init>:(Ljava/lang/String;)V
        //    65: ldc             1
        //    67: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    70: athrow         
        //    71: aload_0        
        //    72: dup            
        //    73: astore_3       
        //    74: pop            
        //    75: ldc             4
        //    77: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    80: aload_0        
        //    81: getfield        instrumented/java/util/logging/Logger.loggerBundle:Linstrumented/java/util/logging/Logger$LoggerBundle;
        //    84: astore          4
        //    86: ldc             3
        //    88: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    91: aload           4
        //    93: getfield        instrumented/java/util/logging/Logger$LoggerBundle.resourceBundleName:Ljava/lang/String;
        //    96: ldc             3
        //    98: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   101: ifnull          131
        //   104: aload           4
        //   106: getfield        instrumented/java/util/logging/Logger$LoggerBundle.resourceBundleName:Ljava/lang/String;
        //   109: aload_2        
        //   110: ldc             3
        //   112: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   115: ldc             1
        //   117: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   120: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   123: ldc             1
        //   125: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   128: ifeq            140
        //   131: iconst_1       
        //   132: ldc             2
        //   134: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   137: goto            146
        //   140: iconst_0       
        //   141: ldc             1
        //   143: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   146: istore          5
        //   148: ldc             1
        //   150: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   153: iload           5
        //   155: ldc             2
        //   157: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   160: ifne            184
        //   163: new             Ljava/lang/IllegalArgumentException;
        //   166: dup            
        //   167: ldc_w           "can't replace resource bundle"
        //   170: ldc             4
        //   172: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   175: invokespecial   java/lang/IllegalArgumentException.<init>:(Ljava/lang/String;)V
        //   178: ldc             1
        //   180: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   183: athrow         
        //   184: aload_0        
        //   185: aload_2        
        //   186: aload_1        
        //   187: ldc             4
        //   189: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   192: invokestatic    instrumented/java/util/logging/Logger$LoggerBundle.get:(Ljava/lang/String;Linstrumented/java/util/ResourceBundle;)Linstrumented/java/util/logging/Logger$LoggerBundle;
        //   195: putfield        instrumented/java/util/logging/Logger.loggerBundle:Linstrumented/java/util/logging/Logger$LoggerBundle;
        //   198: ldc             1
        //   200: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   203: aload_3        
        //   204: pop            
        //   205: ldc             2
        //   207: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   210: ldc             1
        //   212: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   215: goto            236
        //   218: astore          6
        //   220: aload_3        
        //   221: pop            
        //   222: ldc_w           503
        //   225: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   228: aload           6
        //   230: ldc             2
        //   232: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   235: athrow         
        //   236: ldc             1
        //   238: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   241: return         
        //   242: athrow         
        //   243: athrow         
        //    StackMapTable: 00 0A FC 00 32 07 01 1C 14 FD 00 3B 07 00 04 07 00 0E 08 45 01 FC 00 25 01 FF 00 21 00 04 07 00 02 07 01 1A 07 01 1C 07 00 04 00 01 07 00 53 FA 00 11 FF 00 05 00 00 00 01 07 00 53 FF 00 00 00 00 00 01 07 01 9A
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  80     243    243    244    Ljava/lang/VirtualMachineError;
        //  80     210    218    236    Any
        //  218    228    218    236    Any
        //  0      242    242    243    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0131:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2596)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public Logger getParent() {
        try {
            final Logger parent = this.parent;
            BytecodeManager.incBytecodes(3);
            return parent;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void setParent(final Logger logger) {
        try {
            BytecodeManager.incBytecodes(2);
            if (logger == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final LogManager manager = this.manager;
            BytecodeManager.incBytecodes(3);
            if (manager == null) {
                BytecodeManager.incBytecodes(2);
                this.manager = LogManager.getLogManager();
                BytecodeManager.incBytecodes(1);
            }
            final LogManager manager2 = this.manager;
            BytecodeManager.incBytecodes(3);
            manager2.checkPermission();
            BytecodeManager.incBytecodes(3);
            this.doSetParent(logger);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void doSetParent(final Logger p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: astore_2       
        //     5: pop            
        //     6: ldc             4
        //     8: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    11: aconst_null    
        //    12: astore_3       
        //    13: ldc             2
        //    15: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    18: aload_0        
        //    19: getfield        instrumented/java/util/logging/Logger.parent:Linstrumented/java/util/logging/Logger;
        //    22: ldc             3
        //    24: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    27: ifnull          158
        //    30: aload_0        
        //    31: getfield        instrumented/java/util/logging/Logger.parent:Linstrumented/java/util/logging/Logger;
        //    34: getfield        instrumented/java/util/logging/Logger.kids:Linstrumented/java/util/ArrayList;
        //    37: ldc             4
        //    39: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    42: invokevirtual   instrumented/java/util/ArrayList.iterator:()Ljava/util/Iterator;
        //    45: astore          4
        //    47: ldc             1
        //    49: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    52: aload           4
        //    54: ldc             2
        //    56: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    59: invokeinterface java/util/Iterator.hasNext:()Z
        //    64: ldc             1
        //    66: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    69: ifeq            158
        //    72: aload           4
        //    74: ldc             2
        //    76: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    79: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    84: checkcast       Linstrumented/java/util/logging/LogManager$LoggerWeakRef;
        //    87: astore_3       
        //    88: ldc             2
        //    90: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    93: aload_3        
        //    94: ldc             2
        //    96: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    99: invokevirtual   instrumented/java/util/logging/LogManager$LoggerWeakRef.get:()Ljava/lang/Object;
        //   102: checkcast       Linstrumented/java/util/logging/Logger;
        //   105: astore          5
        //   107: ldc             2
        //   109: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   112: aload           5
        //   114: aload_0        
        //   115: ldc             3
        //   117: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   120: if_acmpne       143
        //   123: aload           4
        //   125: ldc             2
        //   127: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   130: invokeinterface java/util/Iterator.remove:()V
        //   135: ldc             1
        //   137: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   140: goto            158
        //   143: aconst_null    
        //   144: astore_3       
        //   145: ldc             2
        //   147: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   150: ldc             1
        //   152: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   155: goto            52
        //   158: aload_0        
        //   159: aload_1        
        //   160: putfield        instrumented/java/util/logging/Logger.parent:Linstrumented/java/util/logging/Logger;
        //   163: ldc             3
        //   165: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   168: aload_0        
        //   169: getfield        instrumented/java/util/logging/Logger.parent:Linstrumented/java/util/logging/Logger;
        //   172: getfield        instrumented/java/util/logging/Logger.kids:Linstrumented/java/util/ArrayList;
        //   175: ldc             4
        //   177: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   180: ifnonnull       209
        //   183: aload_0        
        //   184: getfield        instrumented/java/util/logging/Logger.parent:Linstrumented/java/util/logging/Logger;
        //   187: new             Linstrumented/java/util/ArrayList;
        //   190: dup            
        //   191: iconst_2       
        //   192: ldc_w           6
        //   195: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   198: invokespecial   instrumented/java/util/ArrayList.<init>:(I)V
        //   201: putfield        instrumented/java/util/logging/Logger.kids:Linstrumented/java/util/ArrayList;
        //   204: ldc             1
        //   206: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   209: aload_3        
        //   210: ldc             2
        //   212: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   215: ifnonnull       252
        //   218: new             Linstrumented/java/util/logging/LogManager$LoggerWeakRef;
        //   221: dup            
        //   222: aload_0        
        //   223: getfield        instrumented/java/util/logging/Logger.manager:Linstrumented/java/util/logging/LogManager;
        //   226: dup            
        //   227: ldc_w           6
        //   230: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   233: invokevirtual   java/lang/Object.getClass:()Ljava/lang/Class;
        //   236: pop            
        //   237: aload_0        
        //   238: ldc             3
        //   240: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   243: invokespecial   instrumented/java/util/logging/LogManager$LoggerWeakRef.<init>:(Linstrumented/java/util/logging/LogManager;Linstrumented/java/util/logging/Logger;)V
        //   246: astore_3       
        //   247: ldc             1
        //   249: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   252: aload_3        
        //   253: new             Ljava/lang/ref/WeakReference;
        //   256: dup            
        //   257: aload_0        
        //   258: getfield        instrumented/java/util/logging/Logger.parent:Linstrumented/java/util/logging/Logger;
        //   261: ldc_w           6
        //   264: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   267: invokespecial   java/lang/ref/WeakReference.<init>:(Ljava/lang/Object;)V
        //   270: ldc             1
        //   272: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   275: invokevirtual   instrumented/java/util/logging/LogManager$LoggerWeakRef.setParentRef:(Ljava/lang/ref/WeakReference;)V
        //   278: aload_0        
        //   279: getfield        instrumented/java/util/logging/Logger.parent:Linstrumented/java/util/logging/Logger;
        //   282: getfield        instrumented/java/util/logging/Logger.kids:Linstrumented/java/util/ArrayList;
        //   285: aload_3        
        //   286: ldc             5
        //   288: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   291: invokevirtual   instrumented/java/util/ArrayList.add:(Ljava/lang/Object;)Z
        //   294: pop            
        //   295: ldc             1
        //   297: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   300: aload_0        
        //   301: ldc             2
        //   303: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   306: invokespecial   instrumented/java/util/logging/Logger.updateEffectiveLevel:()V
        //   309: aload_2        
        //   310: pop            
        //   311: ldc             2
        //   313: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   316: ldc             1
        //   318: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   321: goto            342
        //   324: astore          6
        //   326: aload_2        
        //   327: pop            
        //   328: ldc_w           503
        //   331: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   334: aload           6
        //   336: ldc             2
        //   338: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   341: athrow         
        //   342: ldc             1
        //   344: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   347: return         
        //   348: athrow         
        //   349: athrow         
        //    StackMapTable: 00 09 FE 00 34 07 00 04 07 00 07 07 02 19 FC 00 5A 07 00 02 F9 00 0E 32 2A FF 00 47 00 03 07 00 02 07 00 02 07 00 04 00 01 07 00 53 FA 00 11 FF 00 05 00 00 00 01 07 00 53 FF 00 00 00 00 00 01 07 01 9A
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  11     349    349    350    Ljava/lang/VirtualMachineError;
        //  11     316    324    342    Any
        //  324    334    324    342    Any
        //  0      348    348    349    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0052:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2596)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    final void removeChildLogger(final LogManager.LoggerWeakRef p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: astore_2       
        //     5: pop            
        //     6: ldc             4
        //     8: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    11: aload_0        
        //    12: getfield        instrumented/java/util/logging/Logger.kids:Linstrumented/java/util/ArrayList;
        //    15: ldc             3
        //    17: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    20: invokevirtual   instrumented/java/util/ArrayList.iterator:()Ljava/util/Iterator;
        //    23: astore_3       
        //    24: ldc             1
        //    26: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    29: aload_3        
        //    30: ldc             2
        //    32: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    35: invokeinterface java/util/Iterator.hasNext:()Z
        //    40: ldc             1
        //    42: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    45: ifeq            112
        //    48: aload_3        
        //    49: ldc             2
        //    51: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    54: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    59: checkcast       Linstrumented/java/util/logging/LogManager$LoggerWeakRef;
        //    62: astore          4
        //    64: ldc             2
        //    66: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    69: aload           4
        //    71: aload_1        
        //    72: ldc             3
        //    74: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    77: if_acmpne       104
        //    80: aload_3        
        //    81: ldc             2
        //    83: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    86: invokeinterface java/util/Iterator.remove:()V
        //    91: aload_2        
        //    92: pop            
        //    93: ldc             2
        //    95: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    98: ldc             1
        //   100: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   103: return         
        //   104: ldc             1
        //   106: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   109: goto            29
        //   112: aload_2        
        //   113: pop            
        //   114: ldc             2
        //   116: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   119: ldc             1
        //   121: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   124: goto            145
        //   127: astore          5
        //   129: aload_2        
        //   130: pop            
        //   131: ldc_w           503
        //   134: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   137: aload           5
        //   139: ldc             2
        //   141: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   144: athrow         
        //   145: ldc             1
        //   147: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   150: return         
        //   151: athrow         
        //   152: athrow         
        //    StackMapTable: 00 07 FD 00 1D 07 00 04 07 02 19 FB 00 4A FA 00 07 4E 07 00 53 FA 00 11 FF 00 05 00 00 00 01 07 00 53 FF 00 00 00 00 00 01 07 01 9A
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  11     152    152    153    Ljava/lang/VirtualMachineError;
        //  11     98     127    145    Any
        //  104    119    127    145    Any
        //  127    137    127    145    Any
        //  0      151    151    152    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0029:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2596)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private void updateEffectiveLevel() {
        try {
            final Level levelObject = this.levelObject;
            BytecodeManager.incBytecodes(3);
            int levelValue;
            if (levelObject != null) {
                final Level levelObject2 = this.levelObject;
                BytecodeManager.incBytecodes(3);
                levelValue = levelObject2.intValue();
                BytecodeManager.incBytecodes(2);
            }
            else {
                final Logger parent = this.parent;
                BytecodeManager.incBytecodes(3);
                if (parent != null) {
                    levelValue = this.parent.levelValue;
                    BytecodeManager.incBytecodes(5);
                }
                else {
                    final Level info = Level.INFO;
                    BytecodeManager.incBytecodes(2);
                    levelValue = info.intValue();
                    BytecodeManager.incBytecodes(1);
                }
            }
            final int levelValue2 = this.levelValue;
            final int n = levelValue;
            BytecodeManager.incBytecodes(4);
            if (levelValue2 == n) {
                BytecodeManager.incBytecodes(1);
                return;
            }
            this.levelValue = levelValue;
            BytecodeManager.incBytecodes(3);
            final ArrayList<LogManager.LoggerWeakRef> kids = this.kids;
            BytecodeManager.incBytecodes(3);
            if (kids != null) {
                int n2 = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n3 = n2;
                    final ArrayList<LogManager.LoggerWeakRef> kids2 = this.kids;
                    BytecodeManager.incBytecodes(4);
                    final int size = kids2.size();
                    BytecodeManager.incBytecodes(1);
                    if (n3 >= size) {
                        break;
                    }
                    final ArrayList<LogManager.LoggerWeakRef> kids3 = this.kids;
                    final int n4 = n2;
                    BytecodeManager.incBytecodes(4);
                    final LogManager.LoggerWeakRef loggerWeakRef = kids3.get(n4);
                    BytecodeManager.incBytecodes(2);
                    final LogManager.LoggerWeakRef loggerWeakRef2 = loggerWeakRef;
                    BytecodeManager.incBytecodes(2);
                    final Logger logger = loggerWeakRef2.get();
                    BytecodeManager.incBytecodes(2);
                    final Logger logger2 = logger;
                    BytecodeManager.incBytecodes(2);
                    if (logger2 != null) {
                        final Logger logger3 = logger;
                        BytecodeManager.incBytecodes(2);
                        logger3.updateEffectiveLevel();
                    }
                    ++n2;
                    BytecodeManager.incBytecodes(2);
                }
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private LoggerBundle getEffectiveLoggerBundle() {
        try {
            final LoggerBundle loggerBundle = this.loggerBundle;
            BytecodeManager.incBytecodes(3);
            final LoggerBundle loggerBundle2 = loggerBundle;
            BytecodeManager.incBytecodes(2);
            final boolean systemBundle = loggerBundle2.isSystemBundle();
            BytecodeManager.incBytecodes(1);
            if (systemBundle) {
                final LoggerBundle system_BUNDLE = Logger.SYSTEM_BUNDLE;
                BytecodeManager.incBytecodes(2);
                return system_BUNDLE;
            }
            BytecodeManager.incBytecodes(2);
            final ResourceBundle resourceBundle = this.getResourceBundle();
            BytecodeManager.incBytecodes(1);
            final ResourceBundle resourceBundle2 = resourceBundle;
            BytecodeManager.incBytecodes(2);
            if (resourceBundle2 != null) {
                final ResourceBundle resourceBundle3 = resourceBundle;
                final ResourceBundle userBundle = loggerBundle.userBundle;
                BytecodeManager.incBytecodes(4);
                if (resourceBundle3 == userBundle) {
                    final LoggerBundle loggerBundle3 = loggerBundle;
                    BytecodeManager.incBytecodes(2);
                    return loggerBundle3;
                }
            }
            final ResourceBundle resourceBundle4 = resourceBundle;
            BytecodeManager.incBytecodes(2);
            if (resourceBundle4 != null) {
                BytecodeManager.incBytecodes(2);
                final String resourceBundleName = this.getResourceBundleName();
                BytecodeManager.incBytecodes(1);
                final String s = resourceBundleName;
                final ResourceBundle resourceBundle5 = resourceBundle;
                BytecodeManager.incBytecodes(3);
                final LoggerBundle value = LoggerBundle.get(s, resourceBundle5);
                BytecodeManager.incBytecodes(1);
                return value;
            }
            Logger parent = this.parent;
            BytecodeManager.incBytecodes(3);
            while (true) {
                final Logger logger = parent;
                BytecodeManager.incBytecodes(2);
                if (logger == null) {
                    final LoggerBundle no_RESOURCE_BUNDLE = Logger.NO_RESOURCE_BUNDLE;
                    BytecodeManager.incBytecodes(2);
                    return no_RESOURCE_BUNDLE;
                }
                final LoggerBundle loggerBundle4 = parent.loggerBundle;
                BytecodeManager.incBytecodes(3);
                final LoggerBundle loggerBundle5 = loggerBundle4;
                BytecodeManager.incBytecodes(2);
                final boolean systemBundle2 = loggerBundle5.isSystemBundle();
                BytecodeManager.incBytecodes(1);
                if (systemBundle2) {
                    final LoggerBundle system_BUNDLE2 = Logger.SYSTEM_BUNDLE;
                    BytecodeManager.incBytecodes(2);
                    return system_BUNDLE2;
                }
                final ResourceBundle userBundle2 = loggerBundle4.userBundle;
                BytecodeManager.incBytecodes(3);
                if (userBundle2 != null) {
                    final LoggerBundle loggerBundle6 = loggerBundle4;
                    BytecodeManager.incBytecodes(2);
                    return loggerBundle6;
                }
                final boolean isSystemLogger = this.isSystemLogger;
                BytecodeManager.incBytecodes(3);
                String s2;
                if (isSystemLogger) {
                    final boolean isSystemLogger2 = parent.isSystemLogger;
                    BytecodeManager.incBytecodes(3);
                    if (isSystemLogger2) {
                        s2 = loggerBundle4.resourceBundleName;
                        BytecodeManager.incBytecodes(3);
                    }
                    else {
                        s2 = null;
                        BytecodeManager.incBytecodes(2);
                    }
                }
                else {
                    final Logger logger2 = parent;
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    s2 = logger2.getResourceBundleName();
                }
                final String s3 = s2;
                BytecodeManager.incBytecodes(1);
                final String s4 = s3;
                BytecodeManager.incBytecodes(2);
                if (s4 != null) {
                    final String s5 = s3;
                    final String s6 = s3;
                    final boolean b = true;
                    BytecodeManager.incBytecodes(4);
                    BytecodeManager.incBytecodes(1);
                    final ResourceBundle resourceBundle6 = this.findResourceBundle(s6, b);
                    BytecodeManager.incBytecodes(1);
                    final LoggerBundle value2 = LoggerBundle.get(s5, resourceBundle6);
                    BytecodeManager.incBytecodes(1);
                    return value2;
                }
                final boolean isSystemLogger3 = this.isSystemLogger;
                BytecodeManager.incBytecodes(3);
                Logger logger3;
                if (isSystemLogger3) {
                    logger3 = parent.parent;
                    BytecodeManager.incBytecodes(3);
                }
                else {
                    final Logger logger4 = parent;
                    BytecodeManager.incBytecodes(2);
                    logger3 = logger4.getParent();
                }
                parent = logger3;
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static /* synthetic */ LoggerBundle access$000() {
        try {
            final LoggerBundle no_RESOURCE_BUNDLE = Logger.NO_RESOURCE_BUNDLE;
            BytecodeManager.incBytecodes(2);
            return no_RESOURCE_BUNDLE;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static /* synthetic */ LoggerBundle access$100() {
        try {
            final LoggerBundle system_BUNDLE = Logger.SYSTEM_BUNDLE;
            BytecodeManager.incBytecodes(2);
            return system_BUNDLE;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static {
        try {
            final Class<Logger> clazz = Logger.class;
            BytecodeManager.incBytecodes(2);
            final boolean desiredAssertionStatus = clazz.desiredAssertionStatus();
            BytecodeManager.incBytecodes(1);
            boolean $assertionsDisabled2;
            if (!desiredAssertionStatus) {
                $assertionsDisabled2 = true;
                BytecodeManager.incBytecodes(2);
            }
            else {
                $assertionsDisabled2 = false;
                BytecodeManager.incBytecodes(1);
            }
            $assertionsDisabled = $assertionsDisabled2;
            BytecodeManager.incBytecodes(1);
            emptyHandlers = new Handler[0];
            BytecodeManager.incBytecodes(2);
            final Level off = Level.OFF;
            BytecodeManager.incBytecodes(2);
            offValue = off.intValue();
            BytecodeManager.incBytecodes(1);
            final String s = "sun.util.logging.resources.logging";
            final ResourceBundle resourceBundle = null;
            final PrivilegedAction<ResourceBundle> privilegedAction = null;
            BytecodeManager.incBytecodes(6);
            SYSTEM_BUNDLE = new LoggerBundle(s, resourceBundle);
            BytecodeManager.incBytecodes(1);
            final String s2 = null;
            final ResourceBundle resourceBundle2 = null;
            final PrivilegedAction<ResourceBundle> privilegedAction2 = null;
            BytecodeManager.incBytecodes(6);
            NO_RESOURCE_BUNDLE = new LoggerBundle(s2, resourceBundle2);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            treeLock = new Object();
            BytecodeManager.incBytecodes(1);
            final String s3 = "global";
            BytecodeManager.incBytecodes(4);
            global = new Logger(s3);
            BytecodeManager.incBytecodes(2);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static final class LoggerBundle
    {
        final String resourceBundleName;
        final ResourceBundle userBundle;
        
        private LoggerBundle(final String resourceBundleName, final ResourceBundle userBundle) {
            try {
                BytecodeManager.incBytecodes(2);
                this.resourceBundleName = resourceBundleName;
                BytecodeManager.incBytecodes(3);
                this.userBundle = userBundle;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        boolean isSystemBundle() {
            try {
                final String s = "sun.util.logging.resources.logging";
                final String resourceBundleName = this.resourceBundleName;
                BytecodeManager.incBytecodes(4);
                final boolean equals = s.equals(resourceBundleName);
                BytecodeManager.incBytecodes(1);
                return equals;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static LoggerBundle get(final String anObject, final ResourceBundle resourceBundle) {
            try {
                BytecodeManager.incBytecodes(2);
                if (anObject == null) {
                    BytecodeManager.incBytecodes(2);
                    if (resourceBundle == null) {
                        BytecodeManager.incBytecodes(1);
                        final LoggerBundle access$000 = Logger.access$000();
                        BytecodeManager.incBytecodes(1);
                        return access$000;
                    }
                }
                final String s = "sun.util.logging.resources.logging";
                BytecodeManager.incBytecodes(3);
                final boolean equals = s.equals(anObject);
                BytecodeManager.incBytecodes(1);
                if (equals) {
                    BytecodeManager.incBytecodes(2);
                    if (resourceBundle == null) {
                        BytecodeManager.incBytecodes(1);
                        final LoggerBundle access$2 = Logger.access$100();
                        BytecodeManager.incBytecodes(1);
                        return access$2;
                    }
                }
                BytecodeManager.incBytecodes(5);
                final LoggerBundle loggerBundle = new LoggerBundle(anObject, resourceBundle);
                BytecodeManager.incBytecodes(1);
                return loggerBundle;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private static class SystemLoggerHelper
    {
        static boolean disableCallerCheck;
        
        private SystemLoggerHelper() {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private static boolean getBooleanProperty(final String s) {
            try {
                BytecodeManager.incBytecodes(4);
                final PrivilegedAction<String> action = new PrivilegedAction<String>() {
                    {
                        BytecodeManager.incBytecodes(1);
                    }
                    
                    @Override
                    public String run() {
                        try {
                            final String val$key = s;
                            BytecodeManager.incBytecodes(3);
                            final String property = System.getProperty(val$key);
                            BytecodeManager.incBytecodes(1);
                            return property;
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                };
                BytecodeManager.incBytecodes(1);
                final String s2 = AccessController.doPrivileged((PrivilegedAction<String>)action);
                BytecodeManager.incBytecodes(2);
                final String s3 = s2;
                BytecodeManager.incBytecodes(2);
                final Boolean value = Boolean.valueOf(s3);
                BytecodeManager.incBytecodes(1);
                final boolean booleanValue = value;
                BytecodeManager.incBytecodes(1);
                return booleanValue;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static {
            try {
                final String s = "sun.util.logging.disableCallerCheck";
                BytecodeManager.incBytecodes(2);
                SystemLoggerHelper.disableCallerCheck = getBooleanProperty(s);
                BytecodeManager.incBytecodes(2);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
}
