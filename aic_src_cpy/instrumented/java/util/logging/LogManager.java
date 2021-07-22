// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.logging;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import instrumented.java.util.Collection;
import java.lang.ref.WeakReference;
import instrumented.java.util.HashMap;
import java.lang.ref.Reference;
import instrumented.java.util.Hashtable;
import java.util.Iterator;
import java.io.PrintStream;
import java.io.InputStream;
import java.io.IOException;
import instrumented.java.util.Enumeration;
import java.security.AccessController;
import java.security.PrivilegedAction;
import instrumented.java.util.ArrayList;
import instrumented.java.util.List;
import java.beans.PropertyChangeListener;
import aic2021.engine.BytecodeManager;
import java.security.Permission;
import java.lang.ref.ReferenceQueue;
import instrumented.java.util.WeakHashMap;
import instrumented.java.util.Map;
import instrumented.java.util.Properties;

public class LogManager
{
    private static final LogManager manager;
    private volatile Properties props;
    private static final Level defaultLevel;
    private final Map<Object, Integer> listenerMap;
    private final LoggerContext systemContext;
    private final LoggerContext userContext;
    private volatile Logger rootLogger;
    private volatile boolean readPrimordialConfiguration;
    private boolean initializedGlobalHandlers;
    private boolean deathImminent;
    private boolean initializedCalled;
    private volatile boolean initializationDone;
    private WeakHashMap<Object, LoggerContext> contextsMap;
    private final ReferenceQueue<Logger> loggerRefQueue;
    private static final int MAX_ITERATIONS = 400;
    private final Permission controlPermission;
    private static LoggingMXBean loggingMXBean;
    public static final String LOGGING_MXBEAN_NAME = "java.util.logging:type=Logging";
    
    protected LogManager() {
        try {
            BytecodeManager.incBytecodes(2);
            final Void checkSubclassPermissions = checkSubclassPermissions();
            BytecodeManager.incBytecodes(1);
            this(checkSubclassPermissions);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private LogManager(final Void p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             2
        //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     6: invokespecial   java/lang/Object.<init>:()V
        //     9: aload_0        
        //    10: new             Linstrumented/java/util/Properties;
        //    13: dup            
        //    14: ldc             4
        //    16: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    19: invokespecial   instrumented/java/util/Properties.<init>:()V
        //    22: putfield        instrumented/java/util/logging/LogManager.props:Linstrumented/java/util/Properties;
        //    25: ldc             1
        //    27: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    30: aload_0        
        //    31: new             Linstrumented/java/util/HashMap;
        //    34: dup            
        //    35: ldc             4
        //    37: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    40: invokespecial   instrumented/java/util/HashMap.<init>:()V
        //    43: putfield        instrumented/java/util/logging/LogManager.listenerMap:Linstrumented/java/util/Map;
        //    46: ldc             1
        //    48: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    51: aload_0        
        //    52: new             Linstrumented/java/util/logging/LogManager$SystemLoggerContext;
        //    55: dup            
        //    56: aload_0        
        //    57: ldc             5
        //    59: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    62: invokespecial   instrumented/java/util/logging/LogManager$SystemLoggerContext.<init>:(Linstrumented/java/util/logging/LogManager;)V
        //    65: putfield        instrumented/java/util/logging/LogManager.systemContext:Linstrumented/java/util/logging/LogManager$LoggerContext;
        //    68: ldc             1
        //    70: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    73: aload_0        
        //    74: new             Linstrumented/java/util/logging/LogManager$LoggerContext;
        //    77: dup            
        //    78: aload_0        
        //    79: aconst_null    
        //    80: ldc             6
        //    82: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    85: invokespecial   instrumented/java/util/logging/LogManager$LoggerContext.<init>:(Linstrumented/java/util/logging/LogManager;Linstrumented/java/util/logging/LogManager$1;)V
        //    88: putfield        instrumented/java/util/logging/LogManager.userContext:Linstrumented/java/util/logging/LogManager$LoggerContext;
        //    91: ldc             1
        //    93: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    96: aload_0        
        //    97: iconst_1       
        //    98: putfield        instrumented/java/util/logging/LogManager.initializedGlobalHandlers:Z
        //   101: ldc             3
        //   103: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   106: aload_0        
        //   107: iconst_0       
        //   108: putfield        instrumented/java/util/logging/LogManager.initializedCalled:Z
        //   111: ldc             3
        //   113: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   116: aload_0        
        //   117: iconst_0       
        //   118: putfield        instrumented/java/util/logging/LogManager.initializationDone:Z
        //   121: ldc             3
        //   123: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   126: aload_0        
        //   127: aconst_null    
        //   128: putfield        instrumented/java/util/logging/LogManager.contextsMap:Linstrumented/java/util/WeakHashMap;
        //   131: ldc             3
        //   133: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   136: aload_0        
        //   137: new             Ljava/lang/ref/ReferenceQueue;
        //   140: dup            
        //   141: ldc             4
        //   143: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   146: invokespecial   java/lang/ref/ReferenceQueue.<init>:()V
        //   149: putfield        instrumented/java/util/logging/LogManager.loggerRefQueue:Ljava/lang/ref/ReferenceQueue;
        //   152: ldc             1
        //   154: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   157: aload_0        
        //   158: new             Linstrumented/java/util/logging/LoggingPermission;
        //   161: dup            
        //   162: ldc             "control"
        //   164: aconst_null    
        //   165: ldc             6
        //   167: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   170: invokespecial   instrumented/java/util/logging/LoggingPermission.<init>:(Ljava/lang/String;Ljava/lang/String;)V
        //   173: putfield        instrumented/java/util/logging/LogManager.controlPermission:Ljava/security/Permission;
        //   176: ldc             1
        //   178: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   181: ldc             1
        //   183: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   186: invokestatic    java/lang/Runtime.getRuntime:()Ljava/lang/Runtime;
        //   189: new             Linstrumented/java/util/logging/LogManager$Cleaner;
        //   192: dup            
        //   193: aload_0        
        //   194: aconst_null    
        //   195: ldc             5
        //   197: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   200: invokespecial   instrumented/java/util/logging/LogManager$Cleaner.<init>:(Linstrumented/java/util/logging/LogManager;Linstrumented/java/util/logging/LogManager$1;)V
        //   203: ldc             1
        //   205: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   208: invokevirtual   java/lang/Runtime.addShutdownHook:(Ljava/lang/Thread;)V
        //   211: ldc             1
        //   213: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   216: goto            225
        //   219: astore_2       
        //   220: ldc             501
        //   222: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   225: ldc             1
        //   227: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   230: return         
        //   231: athrow         
        //   232: athrow         
        //    StackMapTable: 00 04 FF 00 DB 00 02 07 00 02 07 00 A7 00 01 07 00 6A 05 FF 00 05 00 00 00 01 07 00 66 FF 00 00 00 00 00 01 07 00 68
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                             
        //  -----  -----  -----  -----  ---------------------------------
        //  181    232    232    233    Ljava/lang/VirtualMachineError;
        //  181    211    219    225    Ljava/lang/IllegalStateException;
        //  0      231    231    232    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0225:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2596)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createConstructor(AstBuilder.java:713)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:549)
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
    
    private static Void checkSubclassPermissions() {
        try {
            BytecodeManager.incBytecodes(1);
            final SecurityManager securityManager = System.getSecurityManager();
            BytecodeManager.incBytecodes(1);
            final SecurityManager securityManager2 = securityManager;
            BytecodeManager.incBytecodes(2);
            if (securityManager2 != null) {
                final SecurityManager securityManager3 = securityManager;
                final String name = "shutdownHooks";
                BytecodeManager.incBytecodes(5);
                final RuntimePermission perm = new RuntimePermission(name);
                BytecodeManager.incBytecodes(1);
                securityManager3.checkPermission(perm);
                final SecurityManager securityManager4 = securityManager;
                final String name2 = "setContextClassLoader";
                BytecodeManager.incBytecodes(5);
                final RuntimePermission perm2 = new RuntimePermission(name2);
                BytecodeManager.incBytecodes(1);
                securityManager4.checkPermission(perm2);
            }
            final Void void1 = null;
            BytecodeManager.incBytecodes(2);
            return void1;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final void ensureLogManagerInitialized() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore_1       
        //     2: ldc             2
        //     4: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     7: aload_0        
        //     8: getfield        instrumented/java/util/logging/LogManager.initializationDone:Z
        //    11: ldc             3
        //    13: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    16: ifne            31
        //    19: aload_1        
        //    20: getstatic       instrumented/java/util/logging/LogManager.manager:Linstrumented/java/util/logging/LogManager;
        //    23: ldc             3
        //    25: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    28: if_acmpeq       37
        //    31: ldc             1
        //    33: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    36: return         
        //    37: aload_0        
        //    38: dup            
        //    39: astore_2       
        //    40: pop            
        //    41: ldc             4
        //    43: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    46: aload_0        
        //    47: getfield        instrumented/java/util/logging/LogManager.initializedCalled:Z
        //    50: iconst_1       
        //    51: ldc             4
        //    53: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    56: if_icmpne       68
        //    59: iconst_1       
        //    60: ldc             2
        //    62: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    65: goto            74
        //    68: iconst_0       
        //    69: ldc             1
        //    71: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    74: istore_3       
        //    75: ldc             1
        //    77: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    80: getstatic       instrumented/java/util/logging/LogManager.$assertionsDisabled:Z
        //    83: ldc             2
        //    85: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    88: ifne            135
        //    91: aload_0        
        //    92: getfield        instrumented/java/util/logging/LogManager.initializedCalled:Z
        //    95: ldc             3
        //    97: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   100: ifne            135
        //   103: aload_0        
        //   104: getfield        instrumented/java/util/logging/LogManager.initializationDone:Z
        //   107: ldc             3
        //   109: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   112: ifeq            135
        //   115: new             Ljava/lang/AssertionError;
        //   118: dup            
        //   119: ldc             "Initialization can't be done if initialized has not been called!"
        //   121: ldc             4
        //   123: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   126: invokespecial   java/lang/AssertionError.<init>:(Ljava/lang/Object;)V
        //   129: ldc             1
        //   131: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   134: athrow         
        //   135: iload_3        
        //   136: ldc             2
        //   138: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   141: ifne            156
        //   144: aload_0        
        //   145: getfield        instrumented/java/util/logging/LogManager.initializationDone:Z
        //   148: ldc             3
        //   150: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   153: ifeq            169
        //   156: aload_2        
        //   157: pop            
        //   158: ldc             2
        //   160: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   163: ldc             1
        //   165: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   168: return         
        //   169: aload_0        
        //   170: iconst_1       
        //   171: putfield        instrumented/java/util/logging/LogManager.initializedCalled:Z
        //   174: ldc             3
        //   176: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   179: new             Linstrumented/java/util/logging/LogManager$2;
        //   182: dup            
        //   183: aload_0        
        //   184: aload_1        
        //   185: ldc             5
        //   187: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   190: invokespecial   instrumented/java/util/logging/LogManager$2.<init>:(Linstrumented/java/util/logging/LogManager;Linstrumented/java/util/logging/LogManager;)V
        //   193: ldc             1
        //   195: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   198: invokestatic    java/security/AccessController.doPrivileged:(Ljava/security/PrivilegedAction;)Ljava/lang/Object;
        //   201: pop            
        //   202: ldc             1
        //   204: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   207: aload_0        
        //   208: iconst_1       
        //   209: putfield        instrumented/java/util/logging/LogManager.initializationDone:Z
        //   212: ldc             3
        //   214: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   217: ldc             1
        //   219: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   222: goto            245
        //   225: astore          4
        //   227: ldc             501
        //   229: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   232: aload_0        
        //   233: iconst_1       
        //   234: putfield        instrumented/java/util/logging/LogManager.initializationDone:Z
        //   237: aload           4
        //   239: ldc             5
        //   241: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   244: athrow         
        //   245: aload_2        
        //   246: pop            
        //   247: ldc             2
        //   249: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   252: ldc             1
        //   254: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   257: goto            277
        //   260: astore          5
        //   262: aload_2        
        //   263: pop            
        //   264: ldc             503
        //   266: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   269: aload           5
        //   271: ldc             2
        //   273: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   276: athrow         
        //   277: ldc             1
        //   279: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   282: return         
        //   283: athrow         
        //   284: athrow         
        //    StackMapTable: 00 0D FC 00 1F 07 00 02 05 FC 00 1E 07 00 04 45 01 FC 00 3C 01 14 0C 77 07 00 66 FA 00 13 4E 07 00 66 FA 00 10 FF 00 05 00 00 00 01 07 00 66 FF 00 00 00 00 00 01 07 00 68
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  46     284    284    285    Ljava/lang/VirtualMachineError;
        //  179    207    225    245    Any
        //  225    232    225    245    Any
        //  46     163    260    277    Any
        //  169    252    260    277    Any
        //  260    269    260    277    Any
        //  0      283    283    284    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0068:
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
    
    public static LogManager getLogManager() {
        try {
            final LogManager manager = LogManager.manager;
            BytecodeManager.incBytecodes(2);
            if (manager != null) {
                final LogManager manager2 = LogManager.manager;
                BytecodeManager.incBytecodes(2);
                manager2.ensureLogManagerInitialized();
            }
            final LogManager manager3 = LogManager.manager;
            BytecodeManager.incBytecodes(2);
            return manager3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void readPrimordialConfiguration() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        instrumented/java/util/logging/LogManager.readPrimordialConfiguration:Z
        //     4: ldc             3
        //     6: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     9: ifne            206
        //    12: aload_0        
        //    13: dup            
        //    14: astore_1       
        //    15: pop            
        //    16: ldc             4
        //    18: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    21: aload_0        
        //    22: getfield        instrumented/java/util/logging/LogManager.readPrimordialConfiguration:Z
        //    25: ldc             3
        //    27: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    30: ifne            176
        //    33: getstatic       java/lang/System.out:Ljava/io/PrintStream;
        //    36: ldc             2
        //    38: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    41: ifnonnull       57
        //    44: aload_1        
        //    45: pop            
        //    46: ldc             2
        //    48: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    51: ldc             1
        //    53: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    56: return         
        //    57: aload_0        
        //    58: iconst_1       
        //    59: putfield        instrumented/java/util/logging/LogManager.readPrimordialConfiguration:Z
        //    62: ldc             3
        //    64: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    67: new             Linstrumented/java/util/logging/LogManager$3;
        //    70: dup            
        //    71: aload_0        
        //    72: ldc             4
        //    74: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    77: invokespecial   instrumented/java/util/logging/LogManager$3.<init>:(Linstrumented/java/util/logging/LogManager;)V
        //    80: ldc             1
        //    82: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    85: invokestatic    java/security/AccessController.doPrivileged:(Ljava/security/PrivilegedExceptionAction;)Ljava/lang/Object;
        //    88: pop            
        //    89: ldc             1
        //    91: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    94: ldc             1
        //    96: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    99: goto            176
        //   102: astore_2       
        //   103: ldc             501
        //   105: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   108: getstatic       instrumented/java/util/logging/LogManager.$assertionsDisabled:Z
        //   111: ldc             2
        //   113: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   116: ifne            176
        //   119: new             Ljava/lang/AssertionError;
        //   122: dup            
        //   123: new             Ljava/lang/StringBuilder;
        //   126: dup            
        //   127: ldc             5
        //   129: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   132: invokespecial   java/lang/StringBuilder.<init>:()V
        //   135: ldc             "Exception raised while reading logging configuration: "
        //   137: ldc             2
        //   139: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   142: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   145: aload_2        
        //   146: ldc             2
        //   148: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   151: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   154: ldc             1
        //   156: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   159: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   162: ldc             1
        //   164: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   167: invokespecial   java/lang/AssertionError.<init>:(Ljava/lang/Object;)V
        //   170: ldc             1
        //   172: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   175: athrow         
        //   176: aload_1        
        //   177: pop            
        //   178: ldc             2
        //   180: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   183: ldc             1
        //   185: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   188: goto            206
        //   191: astore_3       
        //   192: aload_1        
        //   193: pop            
        //   194: ldc             503
        //   196: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   199: aload_3        
        //   200: ldc             2
        //   202: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   205: athrow         
        //   206: ldc             1
        //   208: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   211: return         
        //   212: athrow         
        //   213: athrow         
        //    StackMapTable: 00 07 FC 00 39 07 00 04 6C 07 00 D9 FB 00 49 4E 07 00 66 FA 00 0E FF 00 05 00 00 00 01 07 00 66 FF 00 00 00 00 00 01 07 00 68
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  21     213    213    214    Ljava/lang/VirtualMachineError;
        //  67     94     102    176    Ljava/lang/Exception;
        //  21     51     191    206    Any
        //  57     183    191    206    Any
        //  191    199    191    206    Any
        //  0      212    212    213    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0057:
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
    
    @Deprecated
    public void addPropertyChangeListener(final PropertyChangeListener p0) throws SecurityException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             2
        //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     6: invokestatic    instrumented/java/util/Objects.requireNonNull:(Ljava/lang/Object;)Ljava/lang/Object;
        //     9: checkcast       Ljava/beans/PropertyChangeListener;
        //    12: astore_2       
        //    13: ldc             2
        //    15: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    18: aload_0        
        //    19: ldc             2
        //    21: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    24: invokevirtual   instrumented/java/util/logging/LogManager.checkPermission:()V
        //    27: aload_0        
        //    28: getfield        instrumented/java/util/logging/LogManager.listenerMap:Linstrumented/java/util/Map;
        //    31: dup            
        //    32: astore_3       
        //    33: pop            
        //    34: ldc             5
        //    36: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    39: aload_0        
        //    40: getfield        instrumented/java/util/logging/LogManager.listenerMap:Linstrumented/java/util/Map;
        //    43: aload_2        
        //    44: ldc             4
        //    46: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    49: invokeinterface instrumented/java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //    54: checkcast       Ljava/lang/Integer;
        //    57: astore          4
        //    59: ldc             2
        //    61: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    64: aload           4
        //    66: ldc             2
        //    68: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    71: ifnonnull       83
        //    74: iconst_1       
        //    75: ldc             2
        //    77: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    80: goto            100
        //    83: aload           4
        //    85: ldc             2
        //    87: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    90: invokevirtual   java/lang/Integer.intValue:()I
        //    93: iconst_1       
        //    94: iadd           
        //    95: ldc             2
        //    97: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   100: ldc             1
        //   102: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   105: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   108: astore          4
        //   110: ldc             1
        //   112: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   115: aload_0        
        //   116: getfield        instrumented/java/util/logging/LogManager.listenerMap:Linstrumented/java/util/Map;
        //   119: aload_2        
        //   120: aload           4
        //   122: ldc             5
        //   124: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   127: invokeinterface instrumented/java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   132: pop            
        //   133: ldc             1
        //   135: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   138: aload_3        
        //   139: pop            
        //   140: ldc             2
        //   142: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   145: ldc             1
        //   147: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   150: goto            170
        //   153: astore          5
        //   155: aload_3        
        //   156: pop            
        //   157: ldc             503
        //   159: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   162: aload           5
        //   164: ldc             2
        //   166: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   169: athrow         
        //   170: ldc             1
        //   172: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   175: return         
        //   176: athrow         
        //   177: athrow         
        //    Exceptions:
        //  throws java.lang.SecurityException
        //    StackMapTable: 00 06 FE 00 53 07 01 00 07 00 04 07 01 07 50 01 FF 00 34 00 04 07 00 02 07 01 00 07 01 00 07 00 04 00 01 07 00 66 FA 00 10 FF 00 05 00 00 00 01 07 00 66 FF 00 00 00 00 00 01 07 00 68
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  39     177    177    178    Ljava/lang/VirtualMachineError;
        //  39     145    153    170    Any
        //  153    162    153    170    Any
        //  0      176    176    177    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0083:
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
    
    @Deprecated
    public void removePropertyChangeListener(final PropertyChangeListener p0) throws SecurityException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             2
        //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     6: invokevirtual   instrumented/java/util/logging/LogManager.checkPermission:()V
        //     9: aload_1        
        //    10: ldc             2
        //    12: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    15: ifnull          230
        //    18: aload_1        
        //    19: astore_2       
        //    20: ldc             2
        //    22: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    25: aload_0        
        //    26: getfield        instrumented/java/util/logging/LogManager.listenerMap:Linstrumented/java/util/Map;
        //    29: dup            
        //    30: astore_3       
        //    31: pop            
        //    32: ldc             5
        //    34: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    37: aload_0        
        //    38: getfield        instrumented/java/util/logging/LogManager.listenerMap:Linstrumented/java/util/Map;
        //    41: aload_2        
        //    42: ldc             4
        //    44: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    47: invokeinterface instrumented/java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //    52: checkcast       Ljava/lang/Integer;
        //    55: astore          4
        //    57: ldc             2
        //    59: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    62: aload           4
        //    64: ldc             2
        //    66: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    69: ifnull          198
        //    72: aload           4
        //    74: ldc             2
        //    76: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    79: invokevirtual   java/lang/Integer.intValue:()I
        //    82: istore          5
        //    84: ldc             1
        //    86: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    89: iload           5
        //    91: iconst_1       
        //    92: ldc             3
        //    94: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    97: if_icmpne       124
        //   100: aload_0        
        //   101: getfield        instrumented/java/util/logging/LogManager.listenerMap:Linstrumented/java/util/Map;
        //   104: aload_2        
        //   105: ldc             4
        //   107: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   110: invokeinterface instrumented/java/util/Map.remove:(Ljava/lang/Object;)Ljava/lang/Object;
        //   115: pop            
        //   116: ldc             2
        //   118: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   121: goto            198
        //   124: getstatic       instrumented/java/util/logging/LogManager.$assertionsDisabled:Z
        //   127: ldc             2
        //   129: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   132: ifne            164
        //   135: iload           5
        //   137: iconst_1       
        //   138: ldc             3
        //   140: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   143: if_icmpgt       164
        //   146: new             Ljava/lang/AssertionError;
        //   149: dup            
        //   150: ldc             3
        //   152: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   155: invokespecial   java/lang/AssertionError.<init>:()V
        //   158: ldc             1
        //   160: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   163: athrow         
        //   164: aload_0        
        //   165: getfield        instrumented/java/util/logging/LogManager.listenerMap:Linstrumented/java/util/Map;
        //   168: aload_2        
        //   169: iload           5
        //   171: iconst_1       
        //   172: isub           
        //   173: ldc_w           7
        //   176: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   179: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   182: ldc             1
        //   184: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   187: invokeinterface instrumented/java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   192: pop            
        //   193: ldc             1
        //   195: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   198: aload_3        
        //   199: pop            
        //   200: ldc             2
        //   202: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   205: ldc             1
        //   207: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   210: goto            230
        //   213: astore          6
        //   215: aload_3        
        //   216: pop            
        //   217: ldc             503
        //   219: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   222: aload           6
        //   224: ldc             2
        //   226: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   229: athrow         
        //   230: ldc             1
        //   232: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   235: return         
        //   236: athrow         
        //   237: athrow         
        //    Exceptions:
        //  throws java.lang.SecurityException
        //    StackMapTable: 00 07 FF 00 7C 00 06 07 00 02 07 01 00 07 01 00 07 00 04 07 01 07 01 00 00 27 F9 00 21 4E 07 00 66 F9 00 10 FF 00 05 00 00 00 01 07 00 66 FF 00 00 00 00 00 01 07 00 68
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  37     237    237    238    Ljava/lang/VirtualMachineError;
        //  37     205    213    230    Any
        //  213    222    213    230    Any
        //  0      236    236    237    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0124:
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
    
    private LoggerContext getUserContext() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore_1       
        //     2: ldc             2
        //     4: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     7: ldc             1
        //     9: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    12: invokestatic    java/lang/System.getSecurityManager:()Ljava/lang/SecurityManager;
        //    15: astore_2       
        //    16: ldc             1
        //    18: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    21: ldc             1
        //    23: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    26: invokestatic    sun/misc/SharedSecrets.getJavaAWTAccess:()Lsun/misc/JavaAWTAccess;
        //    29: astore_3       
        //    30: ldc             1
        //    32: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    35: aload_2        
        //    36: ldc             2
        //    38: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    41: ifnull          231
        //    44: aload_3        
        //    45: ldc             2
        //    47: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    50: ifnull          231
        //    53: aload_3        
        //    54: ldc             2
        //    56: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    59: invokeinterface sun/misc/JavaAWTAccess.getAppletContext:()Ljava/lang/Object;
        //    64: astore          4
        //    66: ldc             1
        //    68: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    71: aload           4
        //    73: ldc             2
        //    75: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    78: ifnull          231
        //    81: aload_3        
        //    82: dup            
        //    83: astore          5
        //    85: pop            
        //    86: ldc             4
        //    88: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    91: aload_0        
        //    92: getfield        instrumented/java/util/logging/LogManager.contextsMap:Linstrumented/java/util/WeakHashMap;
        //    95: ldc             3
        //    97: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   100: ifnonnull       124
        //   103: aload_0        
        //   104: new             Linstrumented/java/util/WeakHashMap;
        //   107: dup            
        //   108: ldc             4
        //   110: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   113: invokespecial   instrumented/java/util/WeakHashMap.<init>:()V
        //   116: putfield        instrumented/java/util/logging/LogManager.contextsMap:Linstrumented/java/util/WeakHashMap;
        //   119: ldc             1
        //   121: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   124: aload_0        
        //   125: getfield        instrumented/java/util/logging/LogManager.contextsMap:Linstrumented/java/util/WeakHashMap;
        //   128: aload           4
        //   130: ldc             4
        //   132: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   135: invokevirtual   instrumented/java/util/WeakHashMap.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //   138: checkcast       Linstrumented/java/util/logging/LogManager$LoggerContext;
        //   141: astore_1       
        //   142: ldc             2
        //   144: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   147: aload_1        
        //   148: ldc             2
        //   150: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   153: ifnonnull       197
        //   156: new             Linstrumented/java/util/logging/LogManager$LoggerContext;
        //   159: dup            
        //   160: aload_0        
        //   161: aconst_null    
        //   162: ldc             5
        //   164: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   167: invokespecial   instrumented/java/util/logging/LogManager$LoggerContext.<init>:(Linstrumented/java/util/logging/LogManager;Linstrumented/java/util/logging/LogManager$1;)V
        //   170: astore_1       
        //   171: ldc             1
        //   173: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   176: aload_0        
        //   177: getfield        instrumented/java/util/logging/LogManager.contextsMap:Linstrumented/java/util/WeakHashMap;
        //   180: aload           4
        //   182: aload_1        
        //   183: ldc             5
        //   185: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   188: invokevirtual   instrumented/java/util/WeakHashMap.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   191: pop            
        //   192: ldc             1
        //   194: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   197: aload           5
        //   199: pop            
        //   200: ldc             2
        //   202: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   205: ldc             1
        //   207: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   210: goto            231
        //   213: astore          6
        //   215: aload           5
        //   217: pop            
        //   218: ldc             503
        //   220: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   223: aload           6
        //   225: ldc             2
        //   227: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   230: athrow         
        //   231: aload_1        
        //   232: ldc             2
        //   234: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   237: ifnull          249
        //   240: aload_1        
        //   241: ldc             2
        //   243: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   246: goto            258
        //   249: aload_0        
        //   250: getfield        instrumented/java/util/logging/LogManager.userContext:Linstrumented/java/util/logging/LogManager$LoggerContext;
        //   253: ldc             2
        //   255: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   258: ldc             1
        //   260: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   263: areturn        
        //   264: athrow         
        //   265: athrow         
        //    StackMapTable: 00 08 FF 00 7C 00 06 07 00 02 07 00 23 07 00 B7 07 01 23 07 00 04 07 00 04 00 00 FB 00 48 4F 07 00 66 F9 00 11 11 48 07 00 23 FF 00 05 00 00 00 01 07 00 66 FF 00 00 00 00 00 01 07 00 68
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  91     265    265    266    Ljava/lang/VirtualMachineError;
        //  91     205    213    231    Any
        //  213    223    213    231    Any
        //  0      264    264    265    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0124:
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
    
    final LoggerContext getSystemContext() {
        try {
            final LoggerContext systemContext = this.systemContext;
            BytecodeManager.incBytecodes(3);
            return systemContext;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private List<LoggerContext> contexts() {
        try {
            BytecodeManager.incBytecodes(3);
            final ArrayList<LoggerContext> list = new ArrayList<LoggerContext>();
            BytecodeManager.incBytecodes(1);
            final ArrayList<LoggerContext> list2 = list;
            BytecodeManager.incBytecodes(3);
            final LoggerContext systemContext = this.getSystemContext();
            BytecodeManager.incBytecodes(1);
            list2.add(systemContext);
            BytecodeManager.incBytecodes(1);
            final ArrayList<LoggerContext> list3 = list;
            BytecodeManager.incBytecodes(3);
            final LoggerContext userContext = this.getUserContext();
            BytecodeManager.incBytecodes(1);
            list3.add(userContext);
            BytecodeManager.incBytecodes(1);
            final ArrayList<LoggerContext> list4 = list;
            BytecodeManager.incBytecodes(2);
            return list4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    Logger demandLogger(final String s, final String s2, final Class<?> clazz) {
        try {
            BytecodeManager.incBytecodes(3);
            Logger logger = this.getLogger(s);
            BytecodeManager.incBytecodes(1);
            final Logger logger2 = logger;
            BytecodeManager.incBytecodes(2);
            if (logger2 == null) {
                final boolean b = false;
                BytecodeManager.incBytecodes(8);
                final Logger logger3 = new Logger(s, s2, clazz, this, b);
                BytecodeManager.incBytecodes(1);
                Logger logger4;
                do {
                    final Logger logger5 = logger3;
                    BytecodeManager.incBytecodes(3);
                    final boolean addLogger = this.addLogger(logger5);
                    BytecodeManager.incBytecodes(1);
                    if (addLogger) {
                        final Logger logger6 = logger3;
                        BytecodeManager.incBytecodes(2);
                        return logger6;
                    }
                    BytecodeManager.incBytecodes(3);
                    logger = this.getLogger(s);
                    BytecodeManager.incBytecodes(1);
                    logger4 = logger;
                    BytecodeManager.incBytecodes(2);
                } while (logger4 == null);
            }
            final Logger logger7 = logger;
            BytecodeManager.incBytecodes(2);
            return logger7;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    Logger demandSystemLogger(final String s, final String s2) {
        try {
            BytecodeManager.incBytecodes(2);
            final LoggerContext systemContext = this.getSystemContext();
            BytecodeManager.incBytecodes(3);
            final Logger demandLogger = systemContext.demandLogger(s, s2);
            BytecodeManager.incBytecodes(1);
            Logger logger;
            Logger logger3;
            do {
                final Logger logger2 = demandLogger;
                BytecodeManager.incBytecodes(3);
                final boolean addLogger = this.addLogger(logger2);
                BytecodeManager.incBytecodes(1);
                if (addLogger) {
                    logger3 = demandLogger;
                    BytecodeManager.incBytecodes(3);
                }
                else {
                    BytecodeManager.incBytecodes(3);
                    logger3 = this.getLogger(s);
                    BytecodeManager.incBytecodes(1);
                }
                logger = logger3;
                BytecodeManager.incBytecodes(2);
            } while (logger == null);
            final Logger logger4 = logger3;
            final Logger logger5 = demandLogger;
            BytecodeManager.incBytecodes(3);
            if (logger4 != logger5) {
                final Logger logger6 = demandLogger;
                BytecodeManager.incBytecodes(2);
                final int length = logger6.accessCheckedHandlers().length;
                BytecodeManager.incBytecodes(2);
                if (length == 0) {
                    final Logger logger7 = logger3;
                    BytecodeManager.incBytecodes(2);
                    final Logger logger8 = logger7;
                    final Logger logger9 = demandLogger;
                    BytecodeManager.incBytecodes(6);
                    final PrivilegedAction<Void> action = new PrivilegedAction<Void>() {
                        {
                            BytecodeManager.incBytecodes(1);
                        }
                        
                        @Override
                        public Void run() {
                            try {
                                final Logger val$l = logger8;
                                BytecodeManager.incBytecodes(3);
                                final Handler[] accessCheckedHandlers = val$l.accessCheckedHandlers();
                                final int length = accessCheckedHandlers.length;
                                int n = 0;
                                BytecodeManager.incBytecodes(6);
                                while (true) {
                                    final int n2 = n;
                                    final int n3 = length;
                                    BytecodeManager.incBytecodes(3);
                                    if (n2 >= n3) {
                                        break;
                                    }
                                    final Handler handler = accessCheckedHandlers[n];
                                    BytecodeManager.incBytecodes(4);
                                    final Logger val$sysLogger = logger9;
                                    final Handler handler2 = handler;
                                    BytecodeManager.incBytecodes(4);
                                    val$sysLogger.addHandler(handler2);
                                    ++n;
                                    BytecodeManager.incBytecodes(2);
                                }
                                final Void void1 = null;
                                BytecodeManager.incBytecodes(2);
                                return void1;
                            }
                            finally {
                                throw loadexception(java.lang.Throwable.class);
                            }
                        }
                    };
                    BytecodeManager.incBytecodes(1);
                    AccessController.doPrivileged((PrivilegedAction<Object>)action);
                    BytecodeManager.incBytecodes(1);
                }
            }
            final Logger logger10 = demandLogger;
            BytecodeManager.incBytecodes(2);
            return logger10;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void loadLoggerHandlers(final Logger logger, final String s, final String s2) {
        try {
            BytecodeManager.incBytecodes(6);
            final PrivilegedAction<Object> action = new PrivilegedAction<Object>() {
                {
                    BytecodeManager.incBytecodes(1);
                }
                
                @Override
                public Object run() {
                    // 
                    // This method could not be decompiled.
                    // 
                    // Original Bytecode:
                    // 
                    //     1: getfield        instrumented/java/util/logging/LogManager$5.this$0:Linstrumented/java/util/logging/LogManager;
                    //     4: aload_0        
                    //     5: getfield        instrumented/java/util/logging/LogManager$5.val$handlersPropertyName:Ljava/lang/String;
                    //     8: ldc             5
                    //    10: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //    13: invokestatic    instrumented/java/util/logging/LogManager.access$1300:(Linstrumented/java/util/logging/LogManager;Ljava/lang/String;)[Ljava/lang/String;
                    //    16: astore_1       
                    //    17: ldc             1
                    //    19: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //    22: iconst_0       
                    //    23: istore_2       
                    //    24: ldc             2
                    //    26: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //    29: iload_2        
                    //    30: aload_1        
                    //    31: arraylength    
                    //    32: ldc             4
                    //    34: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //    37: if_icmpge       419
                    //    40: aload_1        
                    //    41: iload_2        
                    //    42: aaload         
                    //    43: astore_3       
                    //    44: ldc             4
                    //    46: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //    49: ldc             1
                    //    51: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //    54: invokestatic    java/lang/ClassLoader.getSystemClassLoader:()Ljava/lang/ClassLoader;
                    //    57: aload_3        
                    //    58: ldc             2
                    //    60: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //    63: invokevirtual   java/lang/ClassLoader.loadClass:(Ljava/lang/String;)Ljava/lang/Class;
                    //    66: astore          4
                    //    68: ldc             1
                    //    70: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //    73: aload           4
                    //    75: ldc             2
                    //    77: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //    80: invokevirtual   java/lang/Class.newInstance:()Ljava/lang/Object;
                    //    83: checkcast       Linstrumented/java/util/logging/Handler;
                    //    86: astore          5
                    //    88: ldc             2
                    //    90: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //    93: aload_0        
                    //    94: getfield        instrumented/java/util/logging/LogManager$5.this$0:Linstrumented/java/util/logging/LogManager;
                    //    97: new             Ljava/lang/StringBuilder;
                    //   100: dup            
                    //   101: ldc             5
                    //   103: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   106: invokespecial   java/lang/StringBuilder.<init>:()V
                    //   109: aload_3        
                    //   110: ldc             2
                    //   112: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   115: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
                    //   118: ldc             ".level"
                    //   120: ldc             2
                    //   122: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   125: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
                    //   128: ldc             1
                    //   130: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   133: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
                    //   136: ldc             1
                    //   138: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   141: invokevirtual   instrumented/java/util/logging/LogManager.getProperty:(Ljava/lang/String;)Ljava/lang/String;
                    //   144: astore          6
                    //   146: ldc             1
                    //   148: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   151: aload           6
                    //   153: ldc             2
                    //   155: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   158: ifnull          258
                    //   161: aload           6
                    //   163: ldc             2
                    //   165: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   168: invokestatic    instrumented/java/util/logging/Level.findLevel:(Ljava/lang/String;)Linstrumented/java/util/logging/Level;
                    //   171: astore          7
                    //   173: ldc             1
                    //   175: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   178: aload           7
                    //   180: ldc             2
                    //   182: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   185: ifnull          208
                    //   188: aload           5
                    //   190: aload           7
                    //   192: ldc             3
                    //   194: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   197: invokevirtual   instrumented/java/util/logging/Handler.setLevel:(Linstrumented/java/util/logging/Level;)V
                    //   200: ldc             1
                    //   202: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   205: goto            258
                    //   208: getstatic       java/lang/System.err:Ljava/io/PrintStream;
                    //   211: new             Ljava/lang/StringBuilder;
                    //   214: dup            
                    //   215: ldc             4
                    //   217: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   220: invokespecial   java/lang/StringBuilder.<init>:()V
                    //   223: ldc             "Can't set level for "
                    //   225: ldc             2
                    //   227: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   230: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
                    //   233: aload_3        
                    //   234: ldc             2
                    //   236: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   239: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
                    //   242: ldc             1
                    //   244: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   247: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
                    //   250: ldc             1
                    //   252: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   255: invokevirtual   java/io/PrintStream.println:(Ljava/lang/String;)V
                    //   258: aload_0        
                    //   259: getfield        instrumented/java/util/logging/LogManager$5.val$logger:Linstrumented/java/util/logging/Logger;
                    //   262: aload           5
                    //   264: ldc             4
                    //   266: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   269: invokevirtual   instrumented/java/util/logging/Logger.addHandler:(Linstrumented/java/util/logging/Handler;)V
                    //   272: ldc             1
                    //   274: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   277: goto            408
                    //   280: astore          4
                    //   282: ldc             501
                    //   284: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   287: getstatic       java/lang/System.err:Ljava/io/PrintStream;
                    //   290: new             Ljava/lang/StringBuilder;
                    //   293: dup            
                    //   294: ldc             4
                    //   296: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   299: invokespecial   java/lang/StringBuilder.<init>:()V
                    //   302: ldc             "Can't load log handler \""
                    //   304: ldc             2
                    //   306: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   309: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
                    //   312: aload_3        
                    //   313: ldc             2
                    //   315: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   318: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
                    //   321: ldc             "\""
                    //   323: ldc             2
                    //   325: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   328: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
                    //   331: ldc             1
                    //   333: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   336: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
                    //   339: ldc             1
                    //   341: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   344: invokevirtual   java/io/PrintStream.println:(Ljava/lang/String;)V
                    //   347: getstatic       java/lang/System.err:Ljava/io/PrintStream;
                    //   350: new             Ljava/lang/StringBuilder;
                    //   353: dup            
                    //   354: ldc             4
                    //   356: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   359: invokespecial   java/lang/StringBuilder.<init>:()V
                    //   362: ldc             ""
                    //   364: ldc             2
                    //   366: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   369: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
                    //   372: aload           4
                    //   374: ldc             2
                    //   376: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   379: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
                    //   382: ldc             1
                    //   384: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   387: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
                    //   390: ldc             1
                    //   392: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   395: invokevirtual   java/io/PrintStream.println:(Ljava/lang/String;)V
                    //   398: aload           4
                    //   400: ldc             2
                    //   402: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   405: invokevirtual   java/lang/Exception.printStackTrace:()V
                    //   408: iinc            2, 1
                    //   411: ldc             2
                    //   413: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   416: goto            29
                    //   419: aconst_null    
                    //   420: ldc             2
                    //   422: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   425: areturn        
                    //   426: athrow         
                    //   427: athrow         
                    //    StackMapTable: 00 08 FD 00 1D 07 00 36 01 FF 00 B2 00 08 07 00 02 07 00 36 01 07 00 66 07 00 43 07 00 48 07 00 66 07 00 5B 00 00 FA 00 31 FF 00 15 00 04 07 00 02 07 00 36 01 07 00 66 00 01 07 00 2E FA 00 7F FA 00 0A FF 00 06 00 00 00 01 07 00 28 FF 00 00 00 00 00 01 07 00 2C
                    //    Exceptions:
                    //  Try           Handler
                    //  Start  End    Start  End    Type                           
                    //  -----  -----  -----  -----  -------------------------------
                    //  49     427    427    428    Ljava/lang/VirtualMachineError;
                    //  49     272    280    408    Ljava/lang/Exception;
                    //  0      426    426    427    Any
                    // 
                    // The error that occurred was:
                    // 
                    // java.lang.IllegalStateException: Expression is linked from several locations: Label_0208:
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
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformCall(AstMethodBodyBuilder.java:1164)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformByteCode(AstMethodBodyBuilder.java:1009)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformExpression(AstMethodBodyBuilder.java:540)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformByteCode(AstMethodBodyBuilder.java:554)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformExpression(AstMethodBodyBuilder.java:540)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformNode(AstMethodBodyBuilder.java:392)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformBlock(AstMethodBodyBuilder.java:333)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformNode(AstMethodBodyBuilder.java:494)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformBlock(AstMethodBodyBuilder.java:333)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:294)
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
            };
            BytecodeManager.incBytecodes(1);
            AccessController.doPrivileged((PrivilegedAction<Object>)action);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final void drainLoggerRefQueueBounded() {
        try {
            int n = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n2 = n;
                final int n3 = 400;
                BytecodeManager.incBytecodes(3);
                if (n2 >= n3) {
                    break;
                }
                final ReferenceQueue<Logger> loggerRefQueue = this.loggerRefQueue;
                BytecodeManager.incBytecodes(3);
                if (loggerRefQueue == null) {
                    BytecodeManager.incBytecodes(1);
                    break;
                }
                final ReferenceQueue<Logger> loggerRefQueue2 = this.loggerRefQueue;
                BytecodeManager.incBytecodes(3);
                final LoggerWeakRef loggerWeakRef = (LoggerWeakRef)loggerRefQueue2.poll();
                BytecodeManager.incBytecodes(2);
                final LoggerWeakRef loggerWeakRef2 = loggerWeakRef;
                BytecodeManager.incBytecodes(2);
                if (loggerWeakRef2 == null) {
                    BytecodeManager.incBytecodes(1);
                    break;
                }
                final LoggerWeakRef loggerWeakRef3 = loggerWeakRef;
                BytecodeManager.incBytecodes(2);
                loggerWeakRef3.dispose();
                ++n;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public boolean addLogger(final Logger logger) {
        try {
            BytecodeManager.incBytecodes(2);
            final String name = logger.getName();
            BytecodeManager.incBytecodes(1);
            final String s = name;
            BytecodeManager.incBytecodes(2);
            if (s == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(2);
            this.drainLoggerRefQueueBounded();
            BytecodeManager.incBytecodes(2);
            final LoggerContext userContext = this.getUserContext();
            BytecodeManager.incBytecodes(1);
            final LoggerContext loggerContext = userContext;
            BytecodeManager.incBytecodes(3);
            final boolean addLocalLogger = loggerContext.addLocalLogger(logger);
            BytecodeManager.incBytecodes(1);
            if (addLocalLogger) {
                final String s2 = name;
                BytecodeManager.incBytecodes(6);
                final StringBuilder sb = new StringBuilder();
                final String str = name;
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb.append(str);
                final String str2 = ".handlers";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append2 = append.append(str2);
                BytecodeManager.incBytecodes(1);
                final String string = append2.toString();
                BytecodeManager.incBytecodes(1);
                this.loadLoggerHandlers(logger, s2, string);
                final boolean b = true;
                BytecodeManager.incBytecodes(2);
                return b;
            }
            final boolean b2 = false;
            BytecodeManager.incBytecodes(2);
            return b2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static void doSetLevel(final Logger logger, final Level level) {
        try {
            BytecodeManager.incBytecodes(1);
            final SecurityManager securityManager = System.getSecurityManager();
            BytecodeManager.incBytecodes(1);
            final SecurityManager securityManager2 = securityManager;
            BytecodeManager.incBytecodes(2);
            if (securityManager2 == null) {
                BytecodeManager.incBytecodes(3);
                logger.setLevel(level);
                BytecodeManager.incBytecodes(1);
                return;
            }
            BytecodeManager.incBytecodes(5);
            final PrivilegedAction<Object> action = new PrivilegedAction<Object>() {
                {
                    BytecodeManager.incBytecodes(1);
                }
                
                @Override
                public Object run() {
                    try {
                        final Logger val$logger = logger;
                        final Level val$level = level;
                        BytecodeManager.incBytecodes(5);
                        val$logger.setLevel(val$level);
                        final Object o = null;
                        BytecodeManager.incBytecodes(2);
                        return o;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
            };
            BytecodeManager.incBytecodes(1);
            AccessController.doPrivileged((PrivilegedAction<Object>)action);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static void doSetParent(final Logger logger, final Logger parent) {
        try {
            BytecodeManager.incBytecodes(1);
            final SecurityManager securityManager = System.getSecurityManager();
            BytecodeManager.incBytecodes(1);
            final SecurityManager securityManager2 = securityManager;
            BytecodeManager.incBytecodes(2);
            if (securityManager2 == null) {
                BytecodeManager.incBytecodes(3);
                logger.setParent(parent);
                BytecodeManager.incBytecodes(1);
                return;
            }
            BytecodeManager.incBytecodes(5);
            final PrivilegedAction<Object> action = new PrivilegedAction<Object>() {
                {
                    BytecodeManager.incBytecodes(1);
                }
                
                @Override
                public Object run() {
                    try {
                        final Logger val$logger = logger;
                        final Logger val$parent = parent;
                        BytecodeManager.incBytecodes(5);
                        val$logger.setParent(val$parent);
                        final Object o = null;
                        BytecodeManager.incBytecodes(2);
                        return o;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
            };
            BytecodeManager.incBytecodes(1);
            AccessController.doPrivileged((PrivilegedAction<Object>)action);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Logger getLogger(final String s) {
        try {
            BytecodeManager.incBytecodes(2);
            final LoggerContext userContext = this.getUserContext();
            BytecodeManager.incBytecodes(2);
            final Logger logger = userContext.findLogger(s);
            BytecodeManager.incBytecodes(1);
            return logger;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Enumeration<String> getLoggerNames() {
        try {
            BytecodeManager.incBytecodes(2);
            final LoggerContext userContext = this.getUserContext();
            BytecodeManager.incBytecodes(1);
            final Enumeration<String> loggerNames = userContext.getLoggerNames();
            BytecodeManager.incBytecodes(1);
            return loggerNames;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void readConfiguration() throws IOException, SecurityException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             2
        //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     6: invokevirtual   instrumented/java/util/logging/LogManager.checkPermission:()V
        //     9: ldc_w           "java.util.logging.config.class"
        //    12: ldc             2
        //    14: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    17: invokestatic    java/lang/System.getProperty:(Ljava/lang/String;)Ljava/lang/String;
        //    20: astore_1       
        //    21: ldc             1
        //    23: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    26: aload_1        
        //    27: ldc             2
        //    29: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    32: ifnull          256
        //    35: ldc             1
        //    37: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    40: invokestatic    java/lang/ClassLoader.getSystemClassLoader:()Ljava/lang/ClassLoader;
        //    43: aload_1        
        //    44: ldc             2
        //    46: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    49: invokevirtual   java/lang/ClassLoader.loadClass:(Ljava/lang/String;)Ljava/lang/Class;
        //    52: astore_2       
        //    53: ldc             1
        //    55: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    58: aload_2        
        //    59: ldc             2
        //    61: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    64: invokevirtual   java/lang/Class.newInstance:()Ljava/lang/Object;
        //    67: pop            
        //    68: ldc             1
        //    70: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    73: ldc             1
        //    75: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    78: return         
        //    79: astore_2       
        //    80: ldc             501
        //    82: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    85: ldc             1
        //    87: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    90: invokestatic    java/lang/Thread.currentThread:()Ljava/lang/Thread;
        //    93: ldc             1
        //    95: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    98: invokevirtual   java/lang/Thread.getContextClassLoader:()Ljava/lang/ClassLoader;
        //   101: aload_1        
        //   102: ldc             2
        //   104: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   107: invokevirtual   java/lang/ClassLoader.loadClass:(Ljava/lang/String;)Ljava/lang/Class;
        //   110: astore_3       
        //   111: ldc             1
        //   113: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   116: aload_3        
        //   117: ldc             2
        //   119: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   122: invokevirtual   java/lang/Class.newInstance:()Ljava/lang/Object;
        //   125: pop            
        //   126: ldc             1
        //   128: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   131: ldc             1
        //   133: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   136: return         
        //   137: astore_2       
        //   138: ldc             501
        //   140: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   143: getstatic       java/lang/System.err:Ljava/io/PrintStream;
        //   146: new             Ljava/lang/StringBuilder;
        //   149: dup            
        //   150: ldc             4
        //   152: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   155: invokespecial   java/lang/StringBuilder.<init>:()V
        //   158: ldc_w           "Logging configuration class \""
        //   161: ldc             2
        //   163: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   166: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   169: aload_1        
        //   170: ldc             2
        //   172: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   175: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   178: ldc_w           "\" failed"
        //   181: ldc             2
        //   183: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   186: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   189: ldc             1
        //   191: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   194: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   197: ldc             1
        //   199: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   202: invokevirtual   java/io/PrintStream.println:(Ljava/lang/String;)V
        //   205: getstatic       java/lang/System.err:Ljava/io/PrintStream;
        //   208: new             Ljava/lang/StringBuilder;
        //   211: dup            
        //   212: ldc             4
        //   214: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   217: invokespecial   java/lang/StringBuilder.<init>:()V
        //   220: ldc_w           ""
        //   223: ldc             2
        //   225: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   228: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   231: aload_2        
        //   232: ldc             2
        //   234: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   237: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   240: ldc             1
        //   242: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   245: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   248: ldc             1
        //   250: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   253: invokevirtual   java/io/PrintStream.println:(Ljava/lang/String;)V
        //   256: ldc_w           "java.util.logging.config.file"
        //   259: ldc             2
        //   261: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   264: invokestatic    java/lang/System.getProperty:(Ljava/lang/String;)Ljava/lang/String;
        //   267: astore_2       
        //   268: ldc             1
        //   270: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   273: aload_2        
        //   274: ldc             2
        //   276: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   279: ifnonnull       388
        //   282: ldc_w           "java.home"
        //   285: ldc             2
        //   287: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   290: invokestatic    java/lang/System.getProperty:(Ljava/lang/String;)Ljava/lang/String;
        //   293: astore_2       
        //   294: ldc             1
        //   296: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   299: aload_2        
        //   300: ldc             2
        //   302: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   305: ifnonnull       329
        //   308: new             Ljava/lang/Error;
        //   311: dup            
        //   312: ldc_w           "Can't find java.home ??"
        //   315: ldc             4
        //   317: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   320: invokespecial   java/lang/Error.<init>:(Ljava/lang/String;)V
        //   323: ldc             1
        //   325: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   328: athrow         
        //   329: new             Ljava/io/File;
        //   332: dup            
        //   333: aload_2        
        //   334: ldc_w           "lib"
        //   337: ldc             5
        //   339: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   342: invokespecial   java/io/File.<init>:(Ljava/lang/String;Ljava/lang/String;)V
        //   345: astore_3       
        //   346: ldc             1
        //   348: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   351: new             Ljava/io/File;
        //   354: dup            
        //   355: aload_3        
        //   356: ldc_w           "logging.properties"
        //   359: ldc             5
        //   361: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   364: invokespecial   java/io/File.<init>:(Ljava/io/File;Ljava/lang/String;)V
        //   367: astore_3       
        //   368: ldc             1
        //   370: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   373: aload_3        
        //   374: ldc             2
        //   376: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   379: invokevirtual   java/io/File.getCanonicalPath:()Ljava/lang/String;
        //   382: astore_2       
        //   383: ldc             1
        //   385: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   388: new             Ljava/io/FileInputStream;
        //   391: dup            
        //   392: aload_2        
        //   393: ldc             4
        //   395: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   398: invokespecial   java/io/FileInputStream.<init>:(Ljava/lang/String;)V
        //   401: astore_3       
        //   402: aconst_null    
        //   403: astore          4
        //   405: ldc             3
        //   407: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   410: new             Ljava/io/BufferedInputStream;
        //   413: dup            
        //   414: aload_3        
        //   415: ldc             4
        //   417: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   420: invokespecial   java/io/BufferedInputStream.<init>:(Ljava/io/InputStream;)V
        //   423: astore          5
        //   425: ldc             1
        //   427: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   430: aload_0        
        //   431: aload           5
        //   433: ldc             3
        //   435: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   438: invokevirtual   instrumented/java/util/logging/LogManager.readConfiguration:(Ljava/io/InputStream;)V
        //   441: aload_3        
        //   442: ldc             2
        //   444: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   447: ifnull          615
        //   450: aload           4
        //   452: ldc             2
        //   454: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   457: ifnull          500
        //   460: aload_3        
        //   461: ldc             2
        //   463: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   466: invokevirtual   java/io/InputStream.close:()V
        //   469: ldc             1
        //   471: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   474: goto            615
        //   477: astore          5
        //   479: aload           4
        //   481: aload           5
        //   483: ldc_w           504
        //   486: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   489: invokevirtual   java/lang/Throwable.addSuppressed:(Ljava/lang/Throwable;)V
        //   492: ldc             1
        //   494: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   497: goto            615
        //   500: aload_3        
        //   501: ldc             2
        //   503: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   506: invokevirtual   java/io/InputStream.close:()V
        //   509: ldc             1
        //   511: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   514: goto            615
        //   517: astore          5
        //   519: aload           5
        //   521: astore          4
        //   523: aload           5
        //   525: ldc_w           505
        //   528: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   531: athrow         
        //   532: astore          6
        //   534: ldc             501
        //   536: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   539: aload_3        
        //   540: ldc             2
        //   542: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   545: ifnull          607
        //   548: aload           4
        //   550: ldc             2
        //   552: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   555: ifnull          598
        //   558: aload_3        
        //   559: ldc             2
        //   561: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   564: invokevirtual   java/io/InputStream.close:()V
        //   567: ldc             1
        //   569: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   572: goto            607
        //   575: astore          7
        //   577: aload           4
        //   579: aload           7
        //   581: ldc_w           504
        //   584: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   587: invokevirtual   java/lang/Throwable.addSuppressed:(Ljava/lang/Throwable;)V
        //   590: ldc             1
        //   592: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   595: goto            607
        //   598: aload_3        
        //   599: ldc             2
        //   601: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   604: invokevirtual   java/io/InputStream.close:()V
        //   607: aload           6
        //   609: ldc             2
        //   611: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   614: athrow         
        //   615: ldc             1
        //   617: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   620: return         
        //   621: athrow         
        //   622: athrow         
        //    Exceptions:
        //  throws java.io.IOException
        //  throws java.lang.SecurityException
        //    StackMapTable: 00 0F FF 00 4F 00 02 07 00 02 07 01 6C 00 01 07 01 91 79 07 00 D9 FB 00 76 FC 00 48 07 01 6C 3A FF 00 58 00 05 07 00 02 07 01 6C 07 01 6C 07 01 DF 07 00 66 00 01 07 00 66 16 50 07 00 66 4E 07 00 66 FF 00 2A 00 07 07 00 02 07 01 6C 07 01 6C 07 01 DF 07 00 66 00 07 00 66 00 01 07 00 66 16 08 FF 00 07 00 03 07 00 02 07 01 6C 07 01 6C 00 00 FF 00 05 00 00 00 01 07 00 66 FF 00 00 00 00 00 01 07 00 68
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                              
        //  -----  -----  -----  -----  ----------------------------------
        //  35     622    622    623    Ljava/lang/VirtualMachineError;
        //  35     73     79     137    Ljava/lang/ClassNotFoundException;
        //  35     73     137    256    Ljava/lang/Exception;
        //  79     131    137    256    Ljava/lang/Exception;
        //  460    469    477    500    Ljava/lang/Throwable;
        //  410    441    517    532    Ljava/lang/Throwable;
        //  410    441    532    615    Any
        //  558    567    575    598    Ljava/lang/Throwable;
        //  517    539    532    615    Any
        //  0      621    621    622    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0256:
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
    
    public void reset() throws SecurityException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             2
        //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     6: invokevirtual   instrumented/java/util/logging/LogManager.checkPermission:()V
        //     9: aload_0        
        //    10: dup            
        //    11: astore_1       
        //    12: pop            
        //    13: ldc             4
        //    15: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    18: aload_0        
        //    19: new             Linstrumented/java/util/Properties;
        //    22: dup            
        //    23: ldc             4
        //    25: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    28: invokespecial   instrumented/java/util/Properties.<init>:()V
        //    31: putfield        instrumented/java/util/logging/LogManager.props:Linstrumented/java/util/Properties;
        //    34: ldc             1
        //    36: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    39: aload_0        
        //    40: iconst_1       
        //    41: putfield        instrumented/java/util/logging/LogManager.initializedGlobalHandlers:Z
        //    44: ldc             3
        //    46: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    49: aload_1        
        //    50: pop            
        //    51: ldc             2
        //    53: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    56: ldc             1
        //    58: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    61: goto            79
        //    64: astore_2       
        //    65: aload_1        
        //    66: pop            
        //    67: ldc             503
        //    69: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    72: aload_2        
        //    73: ldc             2
        //    75: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    78: athrow         
        //    79: aload_0        
        //    80: ldc             2
        //    82: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    85: invokespecial   instrumented/java/util/logging/LogManager.contexts:()Linstrumented/java/util/List;
        //    88: ldc             1
        //    90: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    93: invokeinterface instrumented/java/util/List.iterator:()Ljava/util/Iterator;
        //    98: astore_1       
        //    99: ldc             1
        //   101: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   104: aload_1        
        //   105: ldc             2
        //   107: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   110: invokeinterface java/util/Iterator.hasNext:()Z
        //   115: ldc             1
        //   117: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   120: ifeq            253
        //   123: aload_1        
        //   124: ldc             2
        //   126: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   129: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   134: checkcast       Linstrumented/java/util/logging/LogManager$LoggerContext;
        //   137: astore_2       
        //   138: ldc             2
        //   140: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   143: aload_2        
        //   144: ldc             2
        //   146: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   149: invokevirtual   instrumented/java/util/logging/LogManager$LoggerContext.getLoggerNames:()Linstrumented/java/util/Enumeration;
        //   152: astore_3       
        //   153: ldc             1
        //   155: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   158: aload_3        
        //   159: ldc             2
        //   161: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   164: invokeinterface instrumented/java/util/Enumeration.hasMoreElements:()Z
        //   169: ldc             1
        //   171: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   174: ifeq            245
        //   177: aload_3        
        //   178: ldc             2
        //   180: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   183: invokeinterface instrumented/java/util/Enumeration.nextElement:()Ljava/lang/Object;
        //   188: checkcast       Ljava/lang/String;
        //   191: astore          4
        //   193: ldc             2
        //   195: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   198: aload_2        
        //   199: aload           4
        //   201: ldc             3
        //   203: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   206: invokevirtual   instrumented/java/util/logging/LogManager$LoggerContext.findLogger:(Ljava/lang/String;)Linstrumented/java/util/logging/Logger;
        //   209: astore          5
        //   211: ldc             1
        //   213: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   216: aload           5
        //   218: ldc             2
        //   220: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   223: ifnull          237
        //   226: aload_0        
        //   227: aload           5
        //   229: ldc             3
        //   231: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   234: invokespecial   instrumented/java/util/logging/LogManager.resetLogger:(Linstrumented/java/util/logging/Logger;)V
        //   237: ldc             1
        //   239: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   242: goto            158
        //   245: ldc             1
        //   247: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   250: goto            104
        //   253: ldc             1
        //   255: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   258: return         
        //   259: athrow         
        //   260: athrow         
        //    Exceptions:
        //  throws java.lang.SecurityException
        //    StackMapTable: 00 09 FF 00 40 00 02 07 00 02 07 00 04 00 01 07 00 66 FA 00 0E FC 00 18 07 01 F1 FD 00 35 07 00 23 07 01 FA FB 00 4E F9 00 07 FA 00 07 FF 00 05 00 00 00 01 07 00 66 FF 00 00 00 00 00 01 07 00 68
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  18     260    260    261    Ljava/lang/VirtualMachineError;
        //  18     56     64     79     Any
        //  64     72     64     79     Any
        //  0      259    259    260    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0079:
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
    
    private void resetLogger(final Logger p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             2
        //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     6: invokevirtual   instrumented/java/util/logging/Logger.getHandlers:()[Linstrumented/java/util/logging/Handler;
        //     9: astore_2       
        //    10: ldc             1
        //    12: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    15: iconst_0       
        //    16: istore_3       
        //    17: ldc             2
        //    19: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    22: iload_3        
        //    23: aload_2        
        //    24: arraylength    
        //    25: ldc             4
        //    27: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    30: if_icmpge       90
        //    33: aload_2        
        //    34: iload_3        
        //    35: aaload         
        //    36: astore          4
        //    38: ldc             4
        //    40: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    43: aload_1        
        //    44: aload           4
        //    46: ldc             3
        //    48: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    51: invokevirtual   instrumented/java/util/logging/Logger.removeHandler:(Linstrumented/java/util/logging/Handler;)V
        //    54: aload           4
        //    56: ldc             2
        //    58: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    61: invokevirtual   instrumented/java/util/logging/Handler.close:()V
        //    64: ldc             1
        //    66: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    69: goto            79
        //    72: astore          5
        //    74: ldc             501
        //    76: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    79: iinc            3, 1
        //    82: ldc             2
        //    84: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    87: goto            22
        //    90: aload_1        
        //    91: ldc             2
        //    93: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    96: invokevirtual   instrumented/java/util/logging/Logger.getName:()Ljava/lang/String;
        //    99: astore_3       
        //   100: ldc             1
        //   102: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   105: aload_3        
        //   106: ldc             2
        //   108: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   111: ifnull          154
        //   114: aload_3        
        //   115: ldc_w           ""
        //   118: ldc             3
        //   120: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   123: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   126: ldc             1
        //   128: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   131: ifeq            154
        //   134: aload_1        
        //   135: getstatic       instrumented/java/util/logging/LogManager.defaultLevel:Linstrumented/java/util/logging/Level;
        //   138: ldc             3
        //   140: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   143: invokevirtual   instrumented/java/util/logging/Logger.setLevel:(Linstrumented/java/util/logging/Level;)V
        //   146: ldc             1
        //   148: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   151: goto            164
        //   154: aload_1        
        //   155: aconst_null    
        //   156: ldc             3
        //   158: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   161: invokevirtual   instrumented/java/util/logging/Logger.setLevel:(Linstrumented/java/util/logging/Level;)V
        //   164: ldc             1
        //   166: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   169: return         
        //   170: athrow         
        //   171: athrow         
        //    StackMapTable: 00 08 FD 00 16 07 02 08 01 FF 00 31 00 05 07 00 02 07 01 44 07 02 08 01 07 02 0E 00 01 07 00 D9 FA 00 06 FA 00 0A FC 00 3F 07 01 6C 09 FF 00 05 00 00 00 01 07 00 66 FF 00 00 00 00 00 01 07 00 68
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  54     171    171    172    Ljava/lang/VirtualMachineError;
        //  54     64     72     79     Ljava/lang/Exception;
        //  0      170    170    171    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0079:
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
    
    private String[] parseClassNames(final String s) {
        try {
            BytecodeManager.incBytecodes(3);
            final String property = this.getProperty(s);
            BytecodeManager.incBytecodes(1);
            final String s2 = property;
            BytecodeManager.incBytecodes(2);
            if (s2 == null) {
                final String[] array = new String[0];
                BytecodeManager.incBytecodes(2);
                return array;
            }
            final String s3 = property;
            BytecodeManager.incBytecodes(2);
            final String trim = s3.trim();
            BytecodeManager.incBytecodes(1);
            int n = 0;
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(3);
            final ArrayList<String> list = new ArrayList<String>();
            BytecodeManager.incBytecodes(1);
            while (true) {
                final int n2 = n;
                final String s4 = trim;
                BytecodeManager.incBytecodes(3);
                final int length = s4.length();
                BytecodeManager.incBytecodes(1);
                if (n2 >= length) {
                    break;
                }
                int n3 = n;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n4 = n3;
                    final String s5 = trim;
                    BytecodeManager.incBytecodes(3);
                    final int length2 = s5.length();
                    BytecodeManager.incBytecodes(1);
                    if (n4 >= length2) {
                        break;
                    }
                    final String s6 = trim;
                    final int index = n3;
                    BytecodeManager.incBytecodes(3);
                    final char char1 = s6.charAt(index);
                    BytecodeManager.incBytecodes(1);
                    final boolean whitespace = Character.isWhitespace(char1);
                    BytecodeManager.incBytecodes(1);
                    if (whitespace) {
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    final String s7 = trim;
                    final int index2 = n3;
                    BytecodeManager.incBytecodes(3);
                    final char char2 = s7.charAt(index2);
                    final int n5 = ',';
                    BytecodeManager.incBytecodes(2);
                    if (char2 == n5) {
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    ++n3;
                    BytecodeManager.incBytecodes(2);
                }
                final String s8 = trim;
                final int beginIndex = n;
                final int endIndex = n3;
                BytecodeManager.incBytecodes(4);
                final String substring = s8.substring(beginIndex, endIndex);
                BytecodeManager.incBytecodes(1);
                n = n3 + 1;
                BytecodeManager.incBytecodes(4);
                final String s9 = substring;
                BytecodeManager.incBytecodes(2);
                final String trim2 = s9.trim();
                BytecodeManager.incBytecodes(1);
                final String s10 = trim2;
                BytecodeManager.incBytecodes(2);
                final int length3 = s10.length();
                BytecodeManager.incBytecodes(1);
                if (length3 == 0) {
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    final ArrayList<String> list2 = list;
                    final String s11 = trim2;
                    BytecodeManager.incBytecodes(3);
                    list2.add(s11);
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                }
            }
            final ArrayList<String> list3 = list;
            final ArrayList<String> list4 = list;
            BytecodeManager.incBytecodes(3);
            final String[] array2 = new String[list4.size()];
            BytecodeManager.incBytecodes(1);
            final String[] array3 = list3.toArray(array2);
            BytecodeManager.incBytecodes(2);
            return array3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void readConfiguration(final InputStream p0) throws IOException, SecurityException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             2
        //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     6: invokevirtual   instrumented/java/util/logging/LogManager.checkPermission:()V
        //     9: aload_0        
        //    10: ldc             2
        //    12: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    15: invokevirtual   instrumented/java/util/logging/LogManager.reset:()V
        //    18: aload_0        
        //    19: getfield        instrumented/java/util/logging/LogManager.props:Linstrumented/java/util/Properties;
        //    22: aload_1        
        //    23: ldc             4
        //    25: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    28: invokevirtual   instrumented/java/util/Properties.load:(Ljava/io/InputStream;)V
        //    31: aload_0        
        //    32: ldc_w           "config"
        //    35: ldc             3
        //    37: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    40: invokespecial   instrumented/java/util/logging/LogManager.parseClassNames:(Ljava/lang/String;)[Ljava/lang/String;
        //    43: astore_2       
        //    44: ldc             1
        //    46: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    49: iconst_0       
        //    50: istore_3       
        //    51: ldc             2
        //    53: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    56: iload_3        
        //    57: aload_2        
        //    58: arraylength    
        //    59: ldc             4
        //    61: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    64: if_icmpge       259
        //    67: aload_2        
        //    68: iload_3        
        //    69: aaload         
        //    70: astore          4
        //    72: ldc             4
        //    74: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    77: ldc             1
        //    79: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    82: invokestatic    java/lang/ClassLoader.getSystemClassLoader:()Ljava/lang/ClassLoader;
        //    85: aload           4
        //    87: ldc             2
        //    89: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    92: invokevirtual   java/lang/ClassLoader.loadClass:(Ljava/lang/String;)Ljava/lang/Class;
        //    95: astore          5
        //    97: ldc             1
        //    99: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   102: aload           5
        //   104: ldc             2
        //   106: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   109: invokevirtual   java/lang/Class.newInstance:()Ljava/lang/Object;
        //   112: pop            
        //   113: ldc             1
        //   115: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   118: ldc             1
        //   120: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   123: goto            248
        //   126: astore          5
        //   128: ldc             501
        //   130: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   133: getstatic       java/lang/System.err:Ljava/io/PrintStream;
        //   136: new             Ljava/lang/StringBuilder;
        //   139: dup            
        //   140: ldc             4
        //   142: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   145: invokespecial   java/lang/StringBuilder.<init>:()V
        //   148: ldc_w           "Can't load config class \""
        //   151: ldc             2
        //   153: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   156: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   159: aload           4
        //   161: ldc             2
        //   163: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   166: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   169: ldc_w           "\""
        //   172: ldc             2
        //   174: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   177: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   180: ldc             1
        //   182: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   185: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   188: ldc             1
        //   190: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   193: invokevirtual   java/io/PrintStream.println:(Ljava/lang/String;)V
        //   196: getstatic       java/lang/System.err:Ljava/io/PrintStream;
        //   199: new             Ljava/lang/StringBuilder;
        //   202: dup            
        //   203: ldc             4
        //   205: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   208: invokespecial   java/lang/StringBuilder.<init>:()V
        //   211: ldc_w           ""
        //   214: ldc             2
        //   216: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   219: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   222: aload           5
        //   224: ldc             2
        //   226: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   229: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   232: ldc             1
        //   234: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   237: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   240: ldc             1
        //   242: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   245: invokevirtual   java/io/PrintStream.println:(Ljava/lang/String;)V
        //   248: iinc            3, 1
        //   251: ldc             2
        //   253: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   256: goto            56
        //   259: aload_0        
        //   260: ldc             2
        //   262: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   265: invokespecial   instrumented/java/util/logging/LogManager.setLevelsOnExistingLoggers:()V
        //   268: aconst_null    
        //   269: astore_3       
        //   270: ldc             2
        //   272: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   275: aload_0        
        //   276: getfield        instrumented/java/util/logging/LogManager.listenerMap:Linstrumented/java/util/Map;
        //   279: dup            
        //   280: astore          4
        //   282: pop            
        //   283: ldc             5
        //   285: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   288: aload_0        
        //   289: getfield        instrumented/java/util/logging/LogManager.listenerMap:Linstrumented/java/util/Map;
        //   292: ldc             3
        //   294: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   297: invokeinterface instrumented/java/util/Map.isEmpty:()Z
        //   302: ldc             1
        //   304: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   307: ifne            332
        //   310: new             Linstrumented/java/util/HashMap;
        //   313: dup            
        //   314: aload_0        
        //   315: getfield        instrumented/java/util/logging/LogManager.listenerMap:Linstrumented/java/util/Map;
        //   318: ldc             5
        //   320: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   323: invokespecial   instrumented/java/util/HashMap.<init>:(Linstrumented/java/util/Map;)V
        //   326: astore_3       
        //   327: ldc             1
        //   329: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   332: aload           4
        //   334: pop            
        //   335: ldc             2
        //   337: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   340: ldc             1
        //   342: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   345: goto            366
        //   348: astore          6
        //   350: aload           4
        //   352: pop            
        //   353: ldc             503
        //   355: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   358: aload           6
        //   360: ldc             2
        //   362: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   365: athrow         
        //   366: aload_3        
        //   367: ldc             2
        //   369: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   372: ifnull          610
        //   375: getstatic       instrumented/java/util/logging/LogManager.$assertionsDisabled:Z
        //   378: ldc             2
        //   380: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   383: ifne            420
        //   386: ldc             1
        //   388: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   391: invokestatic    instrumented/java/util/logging/LogManager$Beans.isBeansPresent:()Z
        //   394: ldc             1
        //   396: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   399: ifne            420
        //   402: new             Ljava/lang/AssertionError;
        //   405: dup            
        //   406: ldc             3
        //   408: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   411: invokespecial   java/lang/AssertionError.<init>:()V
        //   414: ldc             1
        //   416: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   419: athrow         
        //   420: ldc             Linstrumented/java/util/logging/LogManager;.class
        //   422: aconst_null    
        //   423: aconst_null    
        //   424: aconst_null    
        //   425: ldc             5
        //   427: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   430: invokestatic    instrumented/java/util/logging/LogManager$Beans.newPropertyChangeEvent:(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   433: astore          4
        //   435: ldc             1
        //   437: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   440: aload_3        
        //   441: ldc             2
        //   443: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   446: invokeinterface instrumented/java/util/Map.entrySet:()Linstrumented/java/util/Set;
        //   451: ldc             1
        //   453: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   456: invokeinterface instrumented/java/util/Set.iterator:()Ljava/util/Iterator;
        //   461: astore          5
        //   463: ldc             1
        //   465: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   468: aload           5
        //   470: ldc             2
        //   472: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   475: invokeinterface java/util/Iterator.hasNext:()Z
        //   480: ldc             1
        //   482: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   485: ifeq            610
        //   488: aload           5
        //   490: ldc             2
        //   492: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   495: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   500: checkcast       Linstrumented/java/util/Map$Entry;
        //   503: astore          6
        //   505: ldc             2
        //   507: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   510: aload           6
        //   512: ldc             2
        //   514: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   517: invokeinterface instrumented/java/util/Map$Entry.getKey:()Ljava/lang/Object;
        //   522: astore          7
        //   524: ldc             1
        //   526: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   529: aload           6
        //   531: ldc             2
        //   533: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   536: invokeinterface instrumented/java/util/Map$Entry.getValue:()Ljava/lang/Object;
        //   541: checkcast       Ljava/lang/Integer;
        //   544: ldc             2
        //   546: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   549: invokevirtual   java/lang/Integer.intValue:()I
        //   552: istore          8
        //   554: ldc             1
        //   556: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   559: iconst_0       
        //   560: istore          9
        //   562: ldc             2
        //   564: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   567: iload           9
        //   569: iload           8
        //   571: ldc             3
        //   573: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   576: if_icmpge       602
        //   579: aload           7
        //   581: aload           4
        //   583: ldc             3
        //   585: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   588: invokestatic    instrumented/java/util/logging/LogManager$Beans.invokePropertyChange:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   591: iinc            9, 1
        //   594: ldc             2
        //   596: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   599: goto            567
        //   602: ldc             1
        //   604: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   607: goto            468
        //   610: aload_0        
        //   611: dup            
        //   612: astore          4
        //   614: pop            
        //   615: ldc             4
        //   617: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   620: aload_0        
        //   621: iconst_0       
        //   622: putfield        instrumented/java/util/logging/LogManager.initializedGlobalHandlers:Z
        //   625: ldc             3
        //   627: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   630: aload           4
        //   632: pop            
        //   633: ldc             2
        //   635: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   638: ldc             1
        //   640: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   643: goto            664
        //   646: astore          10
        //   648: aload           4
        //   650: pop            
        //   651: ldc             503
        //   653: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   656: aload           10
        //   658: ldc             2
        //   660: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   663: athrow         
        //   664: ldc             1
        //   666: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   669: return         
        //   670: athrow         
        //   671: athrow         
        //    Exceptions:
        //  throws java.io.IOException
        //  throws java.lang.SecurityException
        //    StackMapTable: 00 10 FD 00 38 07 02 34 01 FF 00 45 00 05 07 00 02 07 01 DF 07 02 34 01 07 01 6C 00 01 07 00 D9 FA 00 79 FA 00 0A FD 00 48 07 00 09 07 00 04 4F 07 00 66 FA 00 11 35 FD 00 2F 07 00 04 07 01 F1 FF 00 62 00 0A 07 00 02 07 01 DF 07 02 34 07 00 09 07 00 04 07 01 F1 07 00 07 07 00 04 01 01 00 00 FF 00 22 00 06 07 00 02 07 01 DF 07 02 34 07 00 09 07 00 04 07 01 F1 00 00 F9 00 07 FF 00 23 00 05 07 00 02 07 01 DF 07 02 34 07 00 09 07 00 04 00 01 07 00 66 FA 00 11 FF 00 05 00 00 00 01 07 00 66 FF 00 00 00 00 00 01 07 00 68
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  77     671    671    672    Ljava/lang/VirtualMachineError;
        //  77     118    126    248    Ljava/lang/Exception;
        //  288    340    348    366    Any
        //  348    358    348    366    Any
        //  620    638    646    664    Any
        //  646    656    646    664    Any
        //  0      670    670    671    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0248:
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
    
    public String getProperty(final String s) {
        try {
            final Properties props = this.props;
            BytecodeManager.incBytecodes(4);
            final String property = props.getProperty(s);
            BytecodeManager.incBytecodes(1);
            return property;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    String getStringProperty(final String s, final String s2) {
        try {
            BytecodeManager.incBytecodes(3);
            final String property = this.getProperty(s);
            BytecodeManager.incBytecodes(1);
            final String s3 = property;
            BytecodeManager.incBytecodes(2);
            if (s3 == null) {
                BytecodeManager.incBytecodes(2);
                return s2;
            }
            final String s4 = property;
            BytecodeManager.incBytecodes(2);
            final String trim = s4.trim();
            BytecodeManager.incBytecodes(1);
            return trim;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    int getIntProperty(final String p0, final int p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     2: ldc             3
        //     4: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     7: invokevirtual   instrumented/java/util/logging/LogManager.getProperty:(Ljava/lang/String;)Ljava/lang/String;
        //    10: astore_3       
        //    11: ldc             1
        //    13: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    16: aload_3        
        //    17: ldc             2
        //    19: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    22: ifnonnull       32
        //    25: iload_2        
        //    26: ldc             2
        //    28: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    31: ireturn        
        //    32: aload_3        
        //    33: ldc             2
        //    35: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    38: invokevirtual   java/lang/String.trim:()Ljava/lang/String;
        //    41: ldc             1
        //    43: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    46: invokestatic    java/lang/Integer.parseInt:(Ljava/lang/String;)I
        //    49: ldc             1
        //    51: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    54: ireturn        
        //    55: astore          4
        //    57: ldc             501
        //    59: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    62: iload_2        
        //    63: ldc             2
        //    65: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    68: ireturn        
        //    69: athrow         
        //    70: athrow         
        //    StackMapTable: 00 04 FC 00 20 07 01 6C 56 07 00 D9 FF 00 0D 00 00 00 01 07 00 66 FF 00 00 00 00 00 01 07 00 68
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  32     70     70     71     Ljava/lang/VirtualMachineError;
        //  32     49     55     69     Ljava/lang/Exception;
        //  0      69     69     70     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0032:
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
    
    boolean getBooleanProperty(final String s, final boolean b) {
        try {
            BytecodeManager.incBytecodes(3);
            final String property = this.getProperty(s);
            BytecodeManager.incBytecodes(1);
            final String s2 = property;
            BytecodeManager.incBytecodes(2);
            if (s2 == null) {
                BytecodeManager.incBytecodes(2);
                return b;
            }
            final String s3 = property;
            BytecodeManager.incBytecodes(2);
            final String lowerCase = s3.toLowerCase();
            BytecodeManager.incBytecodes(1);
            final String s4 = lowerCase;
            final String anObject = "true";
            BytecodeManager.incBytecodes(3);
            final boolean equals = s4.equals(anObject);
            BytecodeManager.incBytecodes(1);
            if (!equals) {
                final String s5 = lowerCase;
                final String anObject2 = "1";
                BytecodeManager.incBytecodes(3);
                final boolean equals2 = s5.equals(anObject2);
                BytecodeManager.incBytecodes(1);
                if (!equals2) {
                    final String s6 = lowerCase;
                    final String anObject3 = "false";
                    BytecodeManager.incBytecodes(3);
                    final boolean equals3 = s6.equals(anObject3);
                    BytecodeManager.incBytecodes(1);
                    if (!equals3) {
                        final String s7 = lowerCase;
                        final String anObject4 = "0";
                        BytecodeManager.incBytecodes(3);
                        final boolean equals4 = s7.equals(anObject4);
                        BytecodeManager.incBytecodes(1);
                        if (!equals4) {
                            BytecodeManager.incBytecodes(2);
                            return b;
                        }
                    }
                    final boolean b2 = false;
                    BytecodeManager.incBytecodes(2);
                    return b2;
                }
            }
            final boolean b3 = true;
            BytecodeManager.incBytecodes(2);
            return b3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    Level getLevelProperty(final String s, final Level level) {
        try {
            BytecodeManager.incBytecodes(3);
            final String property = this.getProperty(s);
            BytecodeManager.incBytecodes(1);
            final String s2 = property;
            BytecodeManager.incBytecodes(2);
            if (s2 == null) {
                BytecodeManager.incBytecodes(2);
                return level;
            }
            final String s3 = property;
            BytecodeManager.incBytecodes(2);
            final String trim = s3.trim();
            BytecodeManager.incBytecodes(1);
            final Level level2 = Level.findLevel(trim);
            BytecodeManager.incBytecodes(1);
            final Level level3 = level2;
            BytecodeManager.incBytecodes(2);
            Level level4;
            if (level3 != null) {
                level4 = level2;
                BytecodeManager.incBytecodes(2);
            }
            else {
                level4 = level;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return level4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    Filter getFilterProperty(final String p0, final Filter p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     2: ldc             3
        //     4: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     7: invokevirtual   instrumented/java/util/logging/LogManager.getProperty:(Ljava/lang/String;)Ljava/lang/String;
        //    10: astore_3       
        //    11: ldc             1
        //    13: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    16: aload_3        
        //    17: ldc             2
        //    19: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    22: ifnull          73
        //    25: ldc             1
        //    27: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    30: invokestatic    java/lang/ClassLoader.getSystemClassLoader:()Ljava/lang/ClassLoader;
        //    33: aload_3        
        //    34: ldc             2
        //    36: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    39: invokevirtual   java/lang/ClassLoader.loadClass:(Ljava/lang/String;)Ljava/lang/Class;
        //    42: astore          4
        //    44: ldc             1
        //    46: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    49: aload           4
        //    51: ldc             2
        //    53: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    56: invokevirtual   java/lang/Class.newInstance:()Ljava/lang/Object;
        //    59: checkcast       Linstrumented/java/util/logging/Filter;
        //    62: ldc             1
        //    64: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    67: ldc             1
        //    69: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    72: areturn        
        //    73: ldc             1
        //    75: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    78: goto            88
        //    81: astore          4
        //    83: ldc             501
        //    85: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    88: aload_2        
        //    89: ldc             2
        //    91: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    94: areturn        
        //    95: athrow         
        //    96: athrow         
        //    StackMapTable: 00 05 FC 00 49 07 01 6C 47 07 00 D9 06 FF 00 06 00 00 00 01 07 00 66 FF 00 00 00 00 00 01 07 00 68
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  16     96     96     97     Ljava/lang/VirtualMachineError;
        //  16     67     81     88     Ljava/lang/Exception;
        //  0      95     95     96     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0073:
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
    
    Formatter getFormatterProperty(final String p0, final Formatter p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     2: ldc             3
        //     4: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     7: invokevirtual   instrumented/java/util/logging/LogManager.getProperty:(Ljava/lang/String;)Ljava/lang/String;
        //    10: astore_3       
        //    11: ldc             1
        //    13: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    16: aload_3        
        //    17: ldc             2
        //    19: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    22: ifnull          73
        //    25: ldc             1
        //    27: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    30: invokestatic    java/lang/ClassLoader.getSystemClassLoader:()Ljava/lang/ClassLoader;
        //    33: aload_3        
        //    34: ldc             2
        //    36: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    39: invokevirtual   java/lang/ClassLoader.loadClass:(Ljava/lang/String;)Ljava/lang/Class;
        //    42: astore          4
        //    44: ldc             1
        //    46: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    49: aload           4
        //    51: ldc             2
        //    53: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    56: invokevirtual   java/lang/Class.newInstance:()Ljava/lang/Object;
        //    59: checkcast       Linstrumented/java/util/logging/Formatter;
        //    62: ldc             1
        //    64: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    67: ldc             1
        //    69: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    72: areturn        
        //    73: ldc             1
        //    75: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    78: goto            88
        //    81: astore          4
        //    83: ldc             501
        //    85: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    88: aload_2        
        //    89: ldc             2
        //    91: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    94: areturn        
        //    95: athrow         
        //    96: athrow         
        //    StackMapTable: 00 05 FC 00 49 07 01 6C 47 07 00 D9 06 FF 00 06 00 00 00 01 07 00 66 FF 00 00 00 00 00 01 07 00 68
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  16     96     96     97     Ljava/lang/VirtualMachineError;
        //  16     67     81     88     Ljava/lang/Exception;
        //  0      95     95     96     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0073:
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
    
    private synchronized void initializeGlobalHandlers() {
        try {
            final boolean initializedGlobalHandlers = this.initializedGlobalHandlers;
            BytecodeManager.incBytecodes(3);
            if (initializedGlobalHandlers) {
                BytecodeManager.incBytecodes(1);
                return;
            }
            this.initializedGlobalHandlers = true;
            BytecodeManager.incBytecodes(3);
            final boolean deathImminent = this.deathImminent;
            BytecodeManager.incBytecodes(3);
            if (deathImminent) {
                BytecodeManager.incBytecodes(1);
                return;
            }
            final Logger rootLogger = this.rootLogger;
            final String s = null;
            final String s2 = "handlers";
            BytecodeManager.incBytecodes(6);
            this.loadLoggerHandlers(rootLogger, s, s2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    void checkPermission() {
        try {
            BytecodeManager.incBytecodes(1);
            final SecurityManager securityManager = System.getSecurityManager();
            BytecodeManager.incBytecodes(1);
            final SecurityManager securityManager2 = securityManager;
            BytecodeManager.incBytecodes(2);
            if (securityManager2 != null) {
                final SecurityManager securityManager3 = securityManager;
                final Permission controlPermission = this.controlPermission;
                BytecodeManager.incBytecodes(4);
                securityManager3.checkPermission(controlPermission);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void checkAccess() throws SecurityException {
        try {
            BytecodeManager.incBytecodes(2);
            this.checkPermission();
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private synchronized void setLevelsOnExistingLoggers() {
        try {
            final Properties props = this.props;
            BytecodeManager.incBytecodes(3);
            final Enumeration<?> propertyNames = props.propertyNames();
            BytecodeManager.incBytecodes(1);
            while (true) {
                final Enumeration<?> enumeration = propertyNames;
                BytecodeManager.incBytecodes(2);
                final boolean hasMoreElements = enumeration.hasMoreElements();
                BytecodeManager.incBytecodes(1);
                if (!hasMoreElements) {
                    break;
                }
                final Enumeration<?> enumeration2 = propertyNames;
                BytecodeManager.incBytecodes(2);
                final String s = (String)enumeration2.nextElement();
                BytecodeManager.incBytecodes(2);
                final String s2 = s;
                final String suffix = ".level";
                BytecodeManager.incBytecodes(3);
                final boolean endsWith = s2.endsWith(suffix);
                BytecodeManager.incBytecodes(1);
                if (!endsWith) {
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    final String s3 = s;
                    BytecodeManager.incBytecodes(2);
                    final int n = s3.length() - 6;
                    BytecodeManager.incBytecodes(3);
                    final String s4 = s;
                    final int beginIndex = 0;
                    final int endIndex = n;
                    BytecodeManager.incBytecodes(4);
                    final String substring = s4.substring(beginIndex, endIndex);
                    BytecodeManager.incBytecodes(1);
                    final String s5 = s;
                    final Level level = null;
                    BytecodeManager.incBytecodes(4);
                    final Level levelProperty = this.getLevelProperty(s5, level);
                    BytecodeManager.incBytecodes(1);
                    final Level level2 = levelProperty;
                    BytecodeManager.incBytecodes(2);
                    if (level2 == null) {
                        final PrintStream err = System.err;
                        BytecodeManager.incBytecodes(4);
                        final StringBuilder sb = new StringBuilder();
                        final String str = "Bad level value for property: ";
                        BytecodeManager.incBytecodes(2);
                        final StringBuilder append = sb.append(str);
                        final String str2 = s;
                        BytecodeManager.incBytecodes(2);
                        final StringBuilder append2 = append.append(str2);
                        BytecodeManager.incBytecodes(1);
                        final String string = append2.toString();
                        BytecodeManager.incBytecodes(1);
                        err.println(string);
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        BytecodeManager.incBytecodes(2);
                        final List<LoggerContext> contexts = this.contexts();
                        BytecodeManager.incBytecodes(1);
                        final Iterator<LoggerContext> iterator = contexts.iterator();
                        BytecodeManager.incBytecodes(1);
                        while (true) {
                            final Iterator<LoggerContext> iterator2 = iterator;
                            BytecodeManager.incBytecodes(2);
                            final boolean hasNext = iterator2.hasNext();
                            BytecodeManager.incBytecodes(1);
                            if (!hasNext) {
                                break;
                            }
                            final Iterator<LoggerContext> iterator3 = iterator;
                            BytecodeManager.incBytecodes(2);
                            final LoggerContext loggerContext = iterator3.next();
                            BytecodeManager.incBytecodes(2);
                            final LoggerContext loggerContext2 = loggerContext;
                            final String s6 = substring;
                            BytecodeManager.incBytecodes(3);
                            final Logger logger = loggerContext2.findLogger(s6);
                            BytecodeManager.incBytecodes(1);
                            final Logger logger2 = logger;
                            BytecodeManager.incBytecodes(2);
                            if (logger2 == null) {
                                BytecodeManager.incBytecodes(1);
                            }
                            else {
                                final Logger logger3 = logger;
                                final Level level3 = levelProperty;
                                BytecodeManager.incBytecodes(3);
                                logger3.setLevel(level3);
                                BytecodeManager.incBytecodes(1);
                            }
                        }
                        BytecodeManager.incBytecodes(1);
                    }
                }
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static synchronized LoggingMXBean getLoggingMXBean() {
        try {
            final LoggingMXBean loggingMXBean = LogManager.loggingMXBean;
            BytecodeManager.incBytecodes(2);
            if (loggingMXBean == null) {
                BytecodeManager.incBytecodes(3);
                LogManager.loggingMXBean = new Logging();
                BytecodeManager.incBytecodes(1);
            }
            final LoggingMXBean loggingMXBean2 = LogManager.loggingMXBean;
            BytecodeManager.incBytecodes(2);
            return loggingMXBean2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static /* synthetic */ LogManager access$100() {
        try {
            final LogManager manager = LogManager.manager;
            BytecodeManager.incBytecodes(2);
            return manager;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static /* synthetic */ Logger access$500(final LogManager logManager) {
        try {
            final Logger rootLogger = logManager.rootLogger;
            BytecodeManager.incBytecodes(3);
            return rootLogger;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static /* synthetic */ void access$1100(final Logger logger, final Level level) {
        try {
            BytecodeManager.incBytecodes(3);
            doSetLevel(logger, level);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static /* synthetic */ void access$1200(final Logger logger, final Logger logger2) {
        try {
            BytecodeManager.incBytecodes(3);
            doSetParent(logger, logger2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static /* synthetic */ ReferenceQueue access$1400(final LogManager logManager) {
        try {
            final ReferenceQueue<Logger> loggerRefQueue = logManager.loggerRefQueue;
            BytecodeManager.incBytecodes(3);
            return loggerRefQueue;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static /* synthetic */ void access$1500(final LogManager logManager) {
        try {
            BytecodeManager.incBytecodes(2);
            logManager.initializeGlobalHandlers();
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static {
        try {
            final Class<LogManager> clazz = LogManager.class;
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
            defaultLevel = Level.INFO;
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(3);
            final PrivilegedAction<LogManager> action = new PrivilegedAction<LogManager>() {
                {
                    BytecodeManager.incBytecodes(1);
                }
                
                @Override
                public LogManager run() {
                    // 
                    // This method could not be decompiled.
                    // 
                    // Original Bytecode:
                    // 
                    //     1: astore_1       
                    //     2: ldc             2
                    //     4: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //     7: aconst_null    
                    //     8: astore_2       
                    //     9: ldc             2
                    //    11: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //    14: ldc             "java.util.logging.manager"
                    //    16: ldc             2
                    //    18: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //    21: invokestatic    java/lang/System.getProperty:(Ljava/lang/String;)Ljava/lang/String;
                    //    24: astore_2       
                    //    25: ldc             1
                    //    27: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //    30: aload_2        
                    //    31: ldc             2
                    //    33: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //    36: ifnull          150
                    //    39: ldc             1
                    //    41: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //    44: invokestatic    java/lang/ClassLoader.getSystemClassLoader:()Ljava/lang/ClassLoader;
                    //    47: aload_2        
                    //    48: ldc             1
                    //    50: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //    53: ldc             1
                    //    55: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //    58: invokevirtual   java/lang/ClassLoader.loadClass:(Ljava/lang/String;)Ljava/lang/Class;
                    //    61: astore_3       
                    //    62: ldc             1
                    //    64: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //    67: aload_3        
                    //    68: ldc             2
                    //    70: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //    73: invokevirtual   java/lang/Class.newInstance:()Ljava/lang/Object;
                    //    76: checkcast       Linstrumented/java/util/logging/LogManager;
                    //    79: astore_1       
                    //    80: ldc             2
                    //    82: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //    85: ldc             1
                    //    87: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //    90: goto            150
                    //    93: astore_3       
                    //    94: ldc             501
                    //    96: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //    99: ldc             1
                    //   101: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   104: invokestatic    java/lang/Thread.currentThread:()Ljava/lang/Thread;
                    //   107: ldc             1
                    //   109: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   112: invokevirtual   java/lang/Thread.getContextClassLoader:()Ljava/lang/ClassLoader;
                    //   115: aload_2        
                    //   116: ldc             2
                    //   118: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   121: invokevirtual   java/lang/ClassLoader.loadClass:(Ljava/lang/String;)Ljava/lang/Class;
                    //   124: astore          4
                    //   126: ldc             1
                    //   128: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   131: aload           4
                    //   133: ldc             2
                    //   135: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   138: invokevirtual   java/lang/Class.newInstance:()Ljava/lang/Object;
                    //   141: checkcast       Linstrumented/java/util/logging/LogManager;
                    //   144: astore_1       
                    //   145: ldc             2
                    //   147: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   150: ldc             1
                    //   152: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   155: goto            233
                    //   158: astore_3       
                    //   159: ldc             501
                    //   161: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   164: getstatic       java/lang/System.err:Ljava/io/PrintStream;
                    //   167: new             Ljava/lang/StringBuilder;
                    //   170: dup            
                    //   171: ldc             4
                    //   173: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   176: invokespecial   java/lang/StringBuilder.<init>:()V
                    //   179: ldc             "Could not load Logmanager \""
                    //   181: ldc             2
                    //   183: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   186: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
                    //   189: aload_2        
                    //   190: ldc             2
                    //   192: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   195: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
                    //   198: ldc             "\""
                    //   200: ldc             2
                    //   202: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   205: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
                    //   208: ldc             1
                    //   210: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   213: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
                    //   216: ldc             1
                    //   218: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   221: invokevirtual   java/io/PrintStream.println:(Ljava/lang/String;)V
                    //   224: aload_3        
                    //   225: ldc             2
                    //   227: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   230: invokevirtual   java/lang/Exception.printStackTrace:()V
                    //   233: aload_1        
                    //   234: ldc             2
                    //   236: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   239: ifnonnull       260
                    //   242: new             Linstrumented/java/util/logging/LogManager;
                    //   245: dup            
                    //   246: ldc             3
                    //   248: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   251: invokespecial   instrumented/java/util/logging/LogManager.<init>:()V
                    //   254: astore_1       
                    //   255: ldc             1
                    //   257: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   260: aload_1        
                    //   261: ldc             2
                    //   263: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   266: areturn        
                    //   267: athrow         
                    //   268: athrow         
                    //    StackMapTable: 00 07 FF 00 5D 00 03 07 00 02 07 00 0A 07 00 3A 00 01 07 00 1E 38 47 07 00 20 FB 00 4A 1A FF 00 06 00 00 00 01 07 00 18 FF 00 00 00 00 00 01 07 00 1C
                    //    Exceptions:
                    //  Try           Handler
                    //  Start  End    Start  End    Type                              
                    //  -----  -----  -----  -----  ----------------------------------
                    //  14     268    268    269    Ljava/lang/VirtualMachineError;
                    //  39     85     93     150    Ljava/lang/ClassNotFoundException;
                    //  14     150    158    233    Ljava/lang/Exception;
                    //  0      267    267    268    Any
                    // 
                    // The error that occurred was:
                    // 
                    // java.lang.IllegalStateException: Expression is linked from several locations: Label_0150:
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
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformCall(AstMethodBodyBuilder.java:1164)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformByteCode(AstMethodBodyBuilder.java:1009)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformExpression(AstMethodBodyBuilder.java:540)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformByteCode(AstMethodBodyBuilder.java:554)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformExpression(AstMethodBodyBuilder.java:540)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformNode(AstMethodBodyBuilder.java:392)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformBlock(AstMethodBodyBuilder.java:333)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformNode(AstMethodBodyBuilder.java:494)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformBlock(AstMethodBodyBuilder.java:333)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:294)
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
            };
            BytecodeManager.incBytecodes(1);
            manager = AccessController.doPrivileged((PrivilegedAction<LogManager>)action);
            BytecodeManager.incBytecodes(2);
            LogManager.loggingMXBean = null;
            BytecodeManager.incBytecodes(3);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private class Cleaner extends Thread
    {
        private Cleaner() {
            try {
                BytecodeManager.incBytecodes(5);
                final ClassLoader contextClassLoader = null;
                BytecodeManager.incBytecodes(3);
                this.setContextClassLoader(contextClassLoader);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void run() {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     2: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //     5: invokestatic    instrumented/java/util/logging/LogManager.access$100:()Linstrumented/java/util/logging/LogManager;
            //     8: astore_1       
            //     9: ldc             1
            //    11: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    14: aload_0        
            //    15: getfield        instrumented/java/util/logging/LogManager$Cleaner.this$0:Linstrumented/java/util/logging/LogManager;
            //    18: dup            
            //    19: astore_2       
            //    20: pop            
            //    21: ldc             5
            //    23: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    26: aload_0        
            //    27: getfield        instrumented/java/util/logging/LogManager$Cleaner.this$0:Linstrumented/java/util/logging/LogManager;
            //    30: iconst_1       
            //    31: ldc             4
            //    33: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    36: invokestatic    instrumented/java/util/logging/LogManager.access$202:(Linstrumented/java/util/logging/LogManager;Z)Z
            //    39: pop            
            //    40: ldc             1
            //    42: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    45: aload_0        
            //    46: getfield        instrumented/java/util/logging/LogManager$Cleaner.this$0:Linstrumented/java/util/logging/LogManager;
            //    49: iconst_1       
            //    50: ldc             4
            //    52: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    55: invokestatic    instrumented/java/util/logging/LogManager.access$302:(Linstrumented/java/util/logging/LogManager;Z)Z
            //    58: pop            
            //    59: ldc             1
            //    61: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    64: aload_2        
            //    65: pop            
            //    66: ldc             2
            //    68: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    71: ldc             1
            //    73: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    76: goto            94
            //    79: astore_3       
            //    80: aload_2        
            //    81: pop            
            //    82: ldc             503
            //    84: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    87: aload_3        
            //    88: ldc             2
            //    90: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    93: athrow         
            //    94: aload_0        
            //    95: getfield        instrumented/java/util/logging/LogManager$Cleaner.this$0:Linstrumented/java/util/logging/LogManager;
            //    98: ldc             3
            //   100: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   103: invokevirtual   instrumented/java/util/logging/LogManager.reset:()V
            //   106: ldc             1
            //   108: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   111: return         
            //   112: athrow         
            //   113: athrow         
            //    StackMapTable: 00 04 FF 00 4F 00 03 07 00 02 07 00 07 07 00 34 00 01 07 00 22 FA 00 0E FF 00 11 00 00 00 01 07 00 22 FF 00 00 00 00 00 01 07 00 25
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                           
            //  -----  -----  -----  -----  -------------------------------
            //  26     113    113    114    Ljava/lang/VirtualMachineError;
            //  26     71     79     94     Any
            //  79     87     79     94     Any
            //  0      112    112    113    Any
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0094:
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
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:576)
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
    }
    
    class LoggerContext
    {
        private final Hashtable<String, LoggerWeakRef> namedLoggers;
        private final LogNode root;
        static final /* synthetic */ boolean $assertionsDisabled;
        
        private LoggerContext() {
            try {
                BytecodeManager.incBytecodes(5);
                BytecodeManager.incBytecodes(4);
                this.namedLoggers = new Hashtable<String, LoggerWeakRef>();
                BytecodeManager.incBytecodes(1);
                final LogNode logNode = null;
                BytecodeManager.incBytecodes(6);
                this.root = new LogNode(logNode, this);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        final boolean requiresDefaultLoggers() {
            try {
                BytecodeManager.incBytecodes(2);
                final LogManager owner = this.getOwner();
                BytecodeManager.incBytecodes(1);
                final LogManager access$100 = LogManager.access$100();
                BytecodeManager.incBytecodes(1);
                int n;
                if (owner == access$100) {
                    n = 1;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    n = 0;
                    BytecodeManager.incBytecodes(1);
                }
                final boolean b = n != 0;
                BytecodeManager.incBytecodes(1);
                final boolean b2 = b;
                BytecodeManager.incBytecodes(2);
                if (b2) {
                    BytecodeManager.incBytecodes(2);
                    final LogManager owner2 = this.getOwner();
                    BytecodeManager.incBytecodes(1);
                    owner2.ensureLogManagerInitialized();
                }
                final boolean b3 = b;
                BytecodeManager.incBytecodes(2);
                return b3;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        final LogManager getOwner() {
            try {
                final LogManager this$0 = LogManager.this;
                BytecodeManager.incBytecodes(3);
                return this$0;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        final Logger getRootLogger() {
            try {
                BytecodeManager.incBytecodes(2);
                final LogManager owner = this.getOwner();
                BytecodeManager.incBytecodes(1);
                final Logger access$500 = LogManager.access$500(owner);
                BytecodeManager.incBytecodes(1);
                return access$500;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        final Logger getGlobalLogger() {
            try {
                final Logger global = Logger.global;
                BytecodeManager.incBytecodes(2);
                final Logger logger = global;
                BytecodeManager.incBytecodes(2);
                return logger;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        Logger demandLogger(final String s, final String s2) {
            try {
                BytecodeManager.incBytecodes(2);
                final LogManager owner = this.getOwner();
                BytecodeManager.incBytecodes(1);
                final LogManager logManager = owner;
                final Class<?> clazz = null;
                BytecodeManager.incBytecodes(5);
                final Logger demandLogger = logManager.demandLogger(s, s2, clazz);
                BytecodeManager.incBytecodes(1);
                return demandLogger;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private void ensureInitialized() {
            try {
                BytecodeManager.incBytecodes(2);
                final boolean requiresDefaultLoggers = this.requiresDefaultLoggers();
                BytecodeManager.incBytecodes(1);
                if (requiresDefaultLoggers) {
                    BytecodeManager.incBytecodes(3);
                    final Logger rootLogger = this.getRootLogger();
                    BytecodeManager.incBytecodes(1);
                    this.ensureDefaultLogger(rootLogger);
                    BytecodeManager.incBytecodes(3);
                    final Logger globalLogger = this.getGlobalLogger();
                    BytecodeManager.incBytecodes(1);
                    this.ensureDefaultLogger(globalLogger);
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        synchronized Logger findLogger(final String s) {
            try {
                BytecodeManager.incBytecodes(2);
                this.ensureInitialized();
                final Hashtable<String, LoggerWeakRef> namedLoggers = this.namedLoggers;
                BytecodeManager.incBytecodes(4);
                final LoggerWeakRef loggerWeakRef = namedLoggers.get(s);
                BytecodeManager.incBytecodes(2);
                final LoggerWeakRef loggerWeakRef2 = loggerWeakRef;
                BytecodeManager.incBytecodes(2);
                if (loggerWeakRef2 == null) {
                    final Logger logger = null;
                    BytecodeManager.incBytecodes(2);
                    return logger;
                }
                final LoggerWeakRef loggerWeakRef3 = loggerWeakRef;
                BytecodeManager.incBytecodes(2);
                final Logger logger2 = loggerWeakRef3.get();
                BytecodeManager.incBytecodes(2);
                final Logger logger3 = logger2;
                BytecodeManager.incBytecodes(2);
                if (logger3 == null) {
                    final LoggerWeakRef loggerWeakRef4 = loggerWeakRef;
                    BytecodeManager.incBytecodes(2);
                    loggerWeakRef4.dispose();
                }
                final Logger logger4 = logger2;
                BytecodeManager.incBytecodes(2);
                return logger4;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private void ensureAllDefaultLoggers(final Logger logger) {
            try {
                BytecodeManager.incBytecodes(2);
                final boolean requiresDefaultLoggers = this.requiresDefaultLoggers();
                BytecodeManager.incBytecodes(1);
                if (requiresDefaultLoggers) {
                    BytecodeManager.incBytecodes(2);
                    final String name = logger.getName();
                    BytecodeManager.incBytecodes(1);
                    final String s = name;
                    BytecodeManager.incBytecodes(2);
                    final boolean empty = s.isEmpty();
                    BytecodeManager.incBytecodes(1);
                    if (!empty) {
                        BytecodeManager.incBytecodes(3);
                        final Logger rootLogger = this.getRootLogger();
                        BytecodeManager.incBytecodes(1);
                        this.ensureDefaultLogger(rootLogger);
                        final String s2 = "global";
                        final String anObject = name;
                        BytecodeManager.incBytecodes(3);
                        final boolean equals = s2.equals(anObject);
                        BytecodeManager.incBytecodes(1);
                        if (!equals) {
                            BytecodeManager.incBytecodes(3);
                            final Logger globalLogger = this.getGlobalLogger();
                            BytecodeManager.incBytecodes(1);
                            this.ensureDefaultLogger(globalLogger);
                        }
                    }
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private void ensureDefaultLogger(final Logger logger) {
            try {
                BytecodeManager.incBytecodes(2);
                final boolean requiresDefaultLoggers = this.requiresDefaultLoggers();
                BytecodeManager.incBytecodes(1);
                Label_0064: {
                    if (requiresDefaultLoggers) {
                        BytecodeManager.incBytecodes(2);
                        if (logger != null) {
                            final Logger global = Logger.global;
                            BytecodeManager.incBytecodes(3);
                            if (logger != global) {
                                final LogManager this$0 = LogManager.this;
                                BytecodeManager.incBytecodes(3);
                                BytecodeManager.incBytecodes(1);
                                final Logger access$500 = LogManager.access$500(this$0);
                                BytecodeManager.incBytecodes(1);
                                if (logger != access$500) {
                                    break Label_0064;
                                }
                            }
                            final Hashtable<String, LoggerWeakRef> namedLoggers = this.namedLoggers;
                            BytecodeManager.incBytecodes(4);
                            final String name = logger.getName();
                            BytecodeManager.incBytecodes(1);
                            final boolean containsKey = namedLoggers.containsKey(name);
                            BytecodeManager.incBytecodes(1);
                            if (!containsKey) {
                                final boolean b = false;
                                BytecodeManager.incBytecodes(4);
                                this.addLocalLogger(logger, b);
                                BytecodeManager.incBytecodes(1);
                            }
                            BytecodeManager.incBytecodes(1);
                            return;
                        }
                    }
                }
                final boolean $assertionsDisabled = LoggerContext.$assertionsDisabled;
                BytecodeManager.incBytecodes(2);
                if (!$assertionsDisabled) {
                    BytecodeManager.incBytecodes(2);
                    if (logger != null) {
                        BytecodeManager.incBytecodes(3);
                        final AssertionError assertionError = new AssertionError();
                        BytecodeManager.incBytecodes(1);
                        throw assertionError;
                    }
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        boolean addLocalLogger(final Logger logger) {
            try {
                BytecodeManager.incBytecodes(4);
                final boolean requiresDefaultLoggers = this.requiresDefaultLoggers();
                BytecodeManager.incBytecodes(1);
                final boolean addLocalLogger = this.addLocalLogger(logger, requiresDefaultLoggers);
                BytecodeManager.incBytecodes(1);
                return addLocalLogger;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        synchronized boolean addLocalLogger(final Logger logger, final boolean b) {
            try {
                BytecodeManager.incBytecodes(2);
                if (b) {
                    BytecodeManager.incBytecodes(3);
                    this.ensureAllDefaultLoggers(logger);
                }
                BytecodeManager.incBytecodes(2);
                final String name = logger.getName();
                BytecodeManager.incBytecodes(1);
                final String s = name;
                BytecodeManager.incBytecodes(2);
                if (s == null) {
                    BytecodeManager.incBytecodes(3);
                    final NullPointerException ex = new NullPointerException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final Hashtable<String, LoggerWeakRef> namedLoggers = this.namedLoggers;
                final String s2 = name;
                BytecodeManager.incBytecodes(4);
                final LoggerWeakRef loggerWeakRef = namedLoggers.get(s2);
                BytecodeManager.incBytecodes(2);
                final LoggerWeakRef loggerWeakRef2 = loggerWeakRef;
                BytecodeManager.incBytecodes(2);
                if (loggerWeakRef2 != null) {
                    final LoggerWeakRef loggerWeakRef3 = loggerWeakRef;
                    BytecodeManager.incBytecodes(2);
                    final Object value = ((Reference<__Null>)loggerWeakRef3).get();
                    BytecodeManager.incBytecodes(1);
                    if (value != null) {
                        final boolean b2 = false;
                        BytecodeManager.incBytecodes(2);
                        return b2;
                    }
                    final LoggerWeakRef loggerWeakRef4 = loggerWeakRef;
                    BytecodeManager.incBytecodes(2);
                    loggerWeakRef4.dispose();
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(2);
                final LogManager owner = this.getOwner();
                BytecodeManager.incBytecodes(1);
                final LogManager logManager = owner;
                BytecodeManager.incBytecodes(3);
                logger.setLogManager(logManager);
                final LogManager logManager2 = owner;
                BytecodeManager.incBytecodes(5);
                logManager2.getClass();
                BytecodeManager.incBytecodes(3);
                final LoggerWeakRef loggerRef = logManager2.new LoggerWeakRef(logger);
                BytecodeManager.incBytecodes(1);
                final Hashtable<String, LoggerWeakRef> namedLoggers2 = this.namedLoggers;
                final String s3 = name;
                final LoggerWeakRef loggerWeakRef5 = loggerRef;
                BytecodeManager.incBytecodes(5);
                namedLoggers2.put(s3, loggerWeakRef5);
                BytecodeManager.incBytecodes(1);
                final LogManager logManager3 = owner;
                BytecodeManager.incBytecodes(4);
                final StringBuilder sb = new StringBuilder();
                final String str = name;
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb.append(str);
                final String str2 = ".level";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append2 = append.append(str2);
                BytecodeManager.incBytecodes(1);
                final String string = append2.toString();
                final Level level = null;
                BytecodeManager.incBytecodes(2);
                final Level levelProperty = logManager3.getLevelProperty(string, level);
                BytecodeManager.incBytecodes(1);
                final Level level2 = levelProperty;
                BytecodeManager.incBytecodes(2);
                if (level2 != null) {
                    BytecodeManager.incBytecodes(2);
                    final boolean levelInitialized = logger.isLevelInitialized();
                    BytecodeManager.incBytecodes(1);
                    if (!levelInitialized) {
                        final Level level3 = levelProperty;
                        BytecodeManager.incBytecodes(3);
                        LogManager.access$1100(logger, level3);
                    }
                }
                final String s4 = name;
                BytecodeManager.incBytecodes(4);
                this.processParentHandlers(logger, s4);
                final String s5 = name;
                BytecodeManager.incBytecodes(3);
                final LogNode node = this.getNode(s5);
                BytecodeManager.incBytecodes(1);
                node.loggerRef = loggerRef;
                BytecodeManager.incBytecodes(3);
                Logger logger2 = null;
                BytecodeManager.incBytecodes(2);
                LogNode logNode = node.parent;
                BytecodeManager.incBytecodes(3);
                while (true) {
                    final LogNode logNode2 = logNode;
                    BytecodeManager.incBytecodes(2);
                    if (logNode2 == null) {
                        break;
                    }
                    final LoggerWeakRef loggerRef2 = logNode.loggerRef;
                    BytecodeManager.incBytecodes(3);
                    final LoggerWeakRef loggerWeakRef6 = loggerRef2;
                    BytecodeManager.incBytecodes(2);
                    if (loggerWeakRef6 != null) {
                        final Reference<__Null> reference = (Reference<__Null>)loggerRef2;
                        BytecodeManager.incBytecodes(2);
                        logger2 = reference.get();
                        BytecodeManager.incBytecodes(2);
                        final Logger logger3 = logger2;
                        BytecodeManager.incBytecodes(2);
                        if (logger3 != null) {
                            BytecodeManager.incBytecodes(1);
                            break;
                        }
                    }
                    logNode = logNode.parent;
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(1);
                }
                final Logger logger4 = logger2;
                BytecodeManager.incBytecodes(2);
                if (logger4 != null) {
                    final Logger logger5 = logger2;
                    BytecodeManager.incBytecodes(3);
                    LogManager.access$1200(logger, logger5);
                }
                final LogNode logNode3 = node;
                BytecodeManager.incBytecodes(3);
                logNode3.walkAndSetParent(logger);
                final LoggerWeakRef loggerWeakRef7 = loggerRef;
                final LogNode node2 = node;
                BytecodeManager.incBytecodes(3);
                loggerWeakRef7.setNode(node2);
                final boolean b3 = true;
                BytecodeManager.incBytecodes(2);
                return b3;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        synchronized void removeLoggerRef(final String s, final LoggerWeakRef loggerWeakRef) {
            try {
                final Hashtable<String, LoggerWeakRef> namedLoggers = this.namedLoggers;
                BytecodeManager.incBytecodes(5);
                namedLoggers.remove(s, loggerWeakRef);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        synchronized Enumeration<String> getLoggerNames() {
            try {
                BytecodeManager.incBytecodes(2);
                this.ensureInitialized();
                final Hashtable<String, LoggerWeakRef> namedLoggers = this.namedLoggers;
                BytecodeManager.incBytecodes(3);
                final Enumeration<String> keys = namedLoggers.keys();
                BytecodeManager.incBytecodes(1);
                return keys;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private void processParentHandlers(final Logger logger, final String s) {
            try {
                BytecodeManager.incBytecodes(2);
                final LogManager owner = this.getOwner();
                BytecodeManager.incBytecodes(1);
                final LogManager logManager = owner;
                BytecodeManager.incBytecodes(7);
                final PrivilegedAction<Void> action = new PrivilegedAction<Void>() {
                    {
                        BytecodeManager.incBytecodes(1);
                    }
                    
                    @Override
                    public Void run() {
                        try {
                            final Logger val$logger = logger;
                            final LogManager val$owner = logManager;
                            BytecodeManager.incBytecodes(5);
                            final Logger access$500 = LogManager.access$500(val$owner);
                            BytecodeManager.incBytecodes(1);
                            if (val$logger != access$500) {
                                final LogManager val$owner2 = logManager;
                                BytecodeManager.incBytecodes(5);
                                final StringBuilder sb = new StringBuilder();
                                final String val$name = s;
                                BytecodeManager.incBytecodes(3);
                                final StringBuilder append = sb.append(val$name);
                                final String str = ".useParentHandlers";
                                BytecodeManager.incBytecodes(2);
                                final StringBuilder append2 = append.append(str);
                                BytecodeManager.incBytecodes(1);
                                final String string = append2.toString();
                                final boolean b = true;
                                BytecodeManager.incBytecodes(2);
                                final boolean booleanProperty = val$owner2.getBooleanProperty(string, b);
                                BytecodeManager.incBytecodes(1);
                                final boolean b2 = booleanProperty;
                                BytecodeManager.incBytecodes(2);
                                if (!b2) {
                                    final Logger val$logger2 = logger;
                                    final boolean useParentHandlers = false;
                                    BytecodeManager.incBytecodes(4);
                                    val$logger2.setUseParentHandlers(useParentHandlers);
                                }
                            }
                            final Void void1 = null;
                            BytecodeManager.incBytecodes(2);
                            return void1;
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                };
                BytecodeManager.incBytecodes(1);
                AccessController.doPrivileged((PrivilegedAction<Object>)action);
                BytecodeManager.incBytecodes(1);
                int n = 1;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final String str = ".";
                    final int fromIndex = n;
                    BytecodeManager.incBytecodes(4);
                    final int index = s.indexOf(str, fromIndex);
                    BytecodeManager.incBytecodes(1);
                    final int n2 = index;
                    BytecodeManager.incBytecodes(2);
                    if (n2 < 0) {
                        break;
                    }
                    final int beginIndex = 0;
                    final int endIndex = index;
                    BytecodeManager.incBytecodes(4);
                    final String substring = s.substring(beginIndex, endIndex);
                    BytecodeManager.incBytecodes(1);
                    final LogManager logManager2 = owner;
                    BytecodeManager.incBytecodes(4);
                    final StringBuilder sb = new StringBuilder();
                    final String str2 = substring;
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append = sb.append(str2);
                    final String str3 = ".level";
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append2 = append.append(str3);
                    BytecodeManager.incBytecodes(1);
                    final String string = append2.toString();
                    BytecodeManager.incBytecodes(1);
                    final String property = logManager2.getProperty(string);
                    BytecodeManager.incBytecodes(1);
                    Label_0242: {
                        if (property == null) {
                            final LogManager logManager3 = owner;
                            BytecodeManager.incBytecodes(4);
                            final StringBuilder sb2 = new StringBuilder();
                            final String str4 = substring;
                            BytecodeManager.incBytecodes(2);
                            final StringBuilder append3 = sb2.append(str4);
                            final String str5 = ".handlers";
                            BytecodeManager.incBytecodes(2);
                            final StringBuilder append4 = append3.append(str5);
                            BytecodeManager.incBytecodes(1);
                            final String string2 = append4.toString();
                            BytecodeManager.incBytecodes(1);
                            final String property2 = logManager3.getProperty(string2);
                            BytecodeManager.incBytecodes(1);
                            if (property2 == null) {
                                break Label_0242;
                            }
                        }
                        final String s2 = substring;
                        final String s3 = null;
                        BytecodeManager.incBytecodes(4);
                        this.demandLogger(s2, s3);
                        BytecodeManager.incBytecodes(1);
                    }
                    n = index + 1;
                    BytecodeManager.incBytecodes(4);
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        LogNode getNode(String substring) {
            try {
                final String s = substring;
                BytecodeManager.incBytecodes(2);
                if (s != null) {
                    final String s2 = substring;
                    final String anObject = "";
                    BytecodeManager.incBytecodes(3);
                    final boolean equals = s2.equals(anObject);
                    BytecodeManager.incBytecodes(1);
                    if (!equals) {
                        LogNode root = this.root;
                        BytecodeManager.incBytecodes(3);
                        while (true) {
                            final String s3 = substring;
                            BytecodeManager.incBytecodes(2);
                            final int length = s3.length();
                            BytecodeManager.incBytecodes(1);
                            if (length <= 0) {
                                break;
                            }
                            final String s4 = substring;
                            final String str = ".";
                            BytecodeManager.incBytecodes(3);
                            final int index = s4.indexOf(str);
                            BytecodeManager.incBytecodes(1);
                            final int n = index;
                            BytecodeManager.incBytecodes(2);
                            String substring2;
                            if (n > 0) {
                                final String s5 = substring;
                                final int beginIndex = 0;
                                final int endIndex = index;
                                BytecodeManager.incBytecodes(4);
                                substring2 = s5.substring(beginIndex, endIndex);
                                BytecodeManager.incBytecodes(1);
                                final String s6 = substring;
                                final int beginIndex2 = index + 1;
                                BytecodeManager.incBytecodes(5);
                                substring = s6.substring(beginIndex2);
                                BytecodeManager.incBytecodes(2);
                            }
                            else {
                                substring2 = substring;
                                BytecodeManager.incBytecodes(2);
                                substring = "";
                                BytecodeManager.incBytecodes(2);
                            }
                            final HashMap<String, LogNode> children = root.children;
                            BytecodeManager.incBytecodes(3);
                            if (children == null) {
                                final LogNode logNode = root;
                                BytecodeManager.incBytecodes(4);
                                logNode.children = new HashMap<String, LogNode>();
                                BytecodeManager.incBytecodes(1);
                            }
                            final HashMap<String, LogNode> children2 = root.children;
                            final String s7 = substring2;
                            BytecodeManager.incBytecodes(4);
                            LogNode logNode2 = children2.get(s7);
                            BytecodeManager.incBytecodes(2);
                            final LogNode logNode3 = logNode2;
                            BytecodeManager.incBytecodes(2);
                            if (logNode3 == null) {
                                final LogNode logNode4 = root;
                                BytecodeManager.incBytecodes(5);
                                logNode2 = new LogNode(logNode4, this);
                                BytecodeManager.incBytecodes(1);
                                final HashMap<String, LogNode> children3 = root.children;
                                final String s8 = substring2;
                                final LogNode logNode5 = logNode2;
                                BytecodeManager.incBytecodes(5);
                                children3.put(s8, logNode5);
                                BytecodeManager.incBytecodes(1);
                            }
                            root = logNode2;
                            BytecodeManager.incBytecodes(2);
                            BytecodeManager.incBytecodes(1);
                        }
                        final LogNode logNode6 = root;
                        BytecodeManager.incBytecodes(2);
                        return logNode6;
                    }
                }
                final LogNode root2 = this.root;
                BytecodeManager.incBytecodes(3);
                return root2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static {
            try {
                final Class<LogManager> clazz = LogManager.class;
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
                BytecodeManager.incBytecodes(2);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    final class SystemLoggerContext extends LoggerContext
    {
        SystemLoggerContext() {
            try {
                final PrivilegedAction<LogManager> privilegedAction = null;
                BytecodeManager.incBytecodes(7);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        Logger demandLogger(final String s, final String s2) {
            try {
                BytecodeManager.incBytecodes(3);
                Logger logger = this.findLogger(s);
                BytecodeManager.incBytecodes(1);
                final Logger logger2 = logger;
                BytecodeManager.incBytecodes(2);
                if (logger2 == null) {
                    final Class<?> clazz = null;
                    BytecodeManager.incBytecodes(7);
                    final LogManager owner = this.getOwner();
                    final boolean b = true;
                    BytecodeManager.incBytecodes(2);
                    final Logger logger3 = new Logger(s, s2, clazz, owner, b);
                    BytecodeManager.incBytecodes(1);
                    Logger logger4;
                    do {
                        final Logger logger5 = logger3;
                        BytecodeManager.incBytecodes(3);
                        final boolean addLocalLogger = this.addLocalLogger(logger5);
                        BytecodeManager.incBytecodes(1);
                        if (addLocalLogger) {
                            logger = logger3;
                            BytecodeManager.incBytecodes(3);
                        }
                        else {
                            BytecodeManager.incBytecodes(3);
                            logger = this.findLogger(s);
                            BytecodeManager.incBytecodes(1);
                        }
                        logger4 = logger;
                        BytecodeManager.incBytecodes(2);
                    } while (logger4 == null);
                }
                final Logger logger6 = logger;
                BytecodeManager.incBytecodes(2);
                return logger6;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    final class LoggerWeakRef extends WeakReference<Logger>
    {
        private String name;
        private LogNode node;
        private WeakReference<Logger> parentRef;
        private boolean disposed;
        
        LoggerWeakRef(final Logger referent) {
            try {
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(4);
                final ReferenceQueue access$1400 = LogManager.access$1400(LogManager.this);
                BytecodeManager.incBytecodes(1);
                super(referent, access$1400);
                this.disposed = false;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(3);
                this.name = referent.getName();
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        void dispose() {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     2: astore_1       
            //     3: pop            
            //     4: ldc             4
            //     6: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //     9: aload_0        
            //    10: getfield        instrumented/java/util/logging/LogManager$LoggerWeakRef.disposed:Z
            //    13: ldc             3
            //    15: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    18: ifeq            34
            //    21: aload_1        
            //    22: pop            
            //    23: ldc             2
            //    25: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    28: ldc             1
            //    30: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    33: return         
            //    34: aload_0        
            //    35: iconst_1       
            //    36: putfield        instrumented/java/util/logging/LogManager$LoggerWeakRef.disposed:Z
            //    39: ldc             3
            //    41: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    44: aload_1        
            //    45: pop            
            //    46: ldc             2
            //    48: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    51: ldc             1
            //    53: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    56: goto            74
            //    59: astore_2       
            //    60: aload_1        
            //    61: pop            
            //    62: ldc             503
            //    64: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    67: aload_2        
            //    68: ldc             2
            //    70: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    73: athrow         
            //    74: aload_0        
            //    75: getfield        instrumented/java/util/logging/LogManager$LoggerWeakRef.node:Linstrumented/java/util/logging/LogManager$LogNode;
            //    78: astore_1       
            //    79: ldc             3
            //    81: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    84: aload_1        
            //    85: ldc             2
            //    87: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    90: ifnull          195
            //    93: aload_1        
            //    94: getfield        instrumented/java/util/logging/LogManager$LogNode.context:Linstrumented/java/util/logging/LogManager$LoggerContext;
            //    97: dup            
            //    98: astore_2       
            //    99: pop            
            //   100: ldc             5
            //   102: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   105: aload_1        
            //   106: getfield        instrumented/java/util/logging/LogManager$LogNode.context:Linstrumented/java/util/logging/LogManager$LoggerContext;
            //   109: aload_0        
            //   110: getfield        instrumented/java/util/logging/LogManager$LoggerWeakRef.name:Ljava/lang/String;
            //   113: aload_0        
            //   114: ldc             6
            //   116: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   119: invokevirtual   instrumented/java/util/logging/LogManager$LoggerContext.removeLoggerRef:(Ljava/lang/String;Linstrumented/java/util/logging/LogManager$LoggerWeakRef;)V
            //   122: aload_0        
            //   123: aconst_null    
            //   124: putfield        instrumented/java/util/logging/LogManager$LoggerWeakRef.name:Ljava/lang/String;
            //   127: ldc             3
            //   129: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   132: aload_1        
            //   133: getfield        instrumented/java/util/logging/LogManager$LogNode.loggerRef:Linstrumented/java/util/logging/LogManager$LoggerWeakRef;
            //   136: aload_0        
            //   137: ldc             4
            //   139: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   142: if_acmpne       155
            //   145: aload_1        
            //   146: aconst_null    
            //   147: putfield        instrumented/java/util/logging/LogManager$LogNode.loggerRef:Linstrumented/java/util/logging/LogManager$LoggerWeakRef;
            //   150: ldc             3
            //   152: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   155: aload_0        
            //   156: aconst_null    
            //   157: putfield        instrumented/java/util/logging/LogManager$LoggerWeakRef.node:Linstrumented/java/util/logging/LogManager$LogNode;
            //   160: ldc             3
            //   162: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   165: aload_2        
            //   166: pop            
            //   167: ldc             2
            //   169: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   172: ldc             1
            //   174: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   177: goto            195
            //   180: astore_3       
            //   181: aload_2        
            //   182: pop            
            //   183: ldc             503
            //   185: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   188: aload_3        
            //   189: ldc             2
            //   191: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   194: athrow         
            //   195: aload_0        
            //   196: getfield        instrumented/java/util/logging/LogManager$LoggerWeakRef.parentRef:Ljava/lang/ref/WeakReference;
            //   199: ldc             3
            //   201: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   204: ifnull          257
            //   207: aload_0        
            //   208: getfield        instrumented/java/util/logging/LogManager$LoggerWeakRef.parentRef:Ljava/lang/ref/WeakReference;
            //   211: ldc             3
            //   213: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   216: invokevirtual   java/lang/ref/WeakReference.get:()Ljava/lang/Object;
            //   219: checkcast       Linstrumented/java/util/logging/Logger;
            //   222: astore_2       
            //   223: ldc             2
            //   225: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   228: aload_2        
            //   229: ldc             2
            //   231: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   234: ifnull          247
            //   237: aload_2        
            //   238: aload_0        
            //   239: ldc             3
            //   241: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   244: invokevirtual   instrumented/java/util/logging/Logger.removeChildLogger:(Linstrumented/java/util/logging/LogManager$LoggerWeakRef;)V
            //   247: aload_0        
            //   248: aconst_null    
            //   249: putfield        instrumented/java/util/logging/LogManager$LoggerWeakRef.parentRef:Ljava/lang/ref/WeakReference;
            //   252: ldc             3
            //   254: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   257: ldc             1
            //   259: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   262: return         
            //   263: athrow         
            //   264: athrow         
            //    StackMapTable: 00 0A FC 00 22 07 00 40 58 07 00 39 FA 00 0E FD 00 50 07 00 08 07 00 40 58 07 00 39 FA 00 0E FC 00 33 07 00 31 FA 00 09 FF 00 05 00 00 00 01 07 00 39 FF 00 00 00 00 00 01 07 00 3D
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                           
            //  -----  -----  -----  -----  -------------------------------
            //  9      264    264    265    Ljava/lang/VirtualMachineError;
            //  9      28     59     74     Any
            //  34     51     59     74     Any
            //  59     67     59     74     Any
            //  105    172    180    195    Any
            //  180    188    180    195    Any
            //  0      263    263    264    Any
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0034:
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
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:576)
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
        
        void setNode(final LogNode node) {
            try {
                this.node = node;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        void setParentRef(final WeakReference<Logger> parentRef) {
            try {
                this.parentRef = parentRef;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private static class LogNode
    {
        HashMap<String, LogNode> children;
        LoggerWeakRef loggerRef;
        LogNode parent;
        final LoggerContext context;
        
        LogNode(final LogNode parent, final LoggerContext context) {
            try {
                BytecodeManager.incBytecodes(2);
                this.parent = parent;
                BytecodeManager.incBytecodes(3);
                this.context = context;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        void walkAndSetParent(final Logger logger) {
            try {
                final HashMap<String, LogNode> children = this.children;
                BytecodeManager.incBytecodes(3);
                if (children == null) {
                    BytecodeManager.incBytecodes(1);
                    return;
                }
                final HashMap<String, LogNode> children2 = this.children;
                BytecodeManager.incBytecodes(3);
                final Collection<LogNode> values = children2.values();
                BytecodeManager.incBytecodes(1);
                final Iterator<LogNode> iterator = values.iterator();
                BytecodeManager.incBytecodes(1);
                while (true) {
                    final Iterator<LogNode> iterator2 = iterator;
                    BytecodeManager.incBytecodes(2);
                    final boolean hasNext = iterator2.hasNext();
                    BytecodeManager.incBytecodes(1);
                    if (!hasNext) {
                        break;
                    }
                    final Iterator<LogNode> iterator3 = iterator;
                    BytecodeManager.incBytecodes(2);
                    final LogNode logNode = iterator3.next();
                    BytecodeManager.incBytecodes(2);
                    final LoggerWeakRef loggerRef = logNode.loggerRef;
                    BytecodeManager.incBytecodes(3);
                    final LoggerWeakRef loggerWeakRef = loggerRef;
                    BytecodeManager.incBytecodes(2);
                    Logger logger2;
                    if (loggerWeakRef == null) {
                        logger2 = null;
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        final LoggerWeakRef loggerWeakRef2 = loggerRef;
                        BytecodeManager.incBytecodes(2);
                        logger2 = loggerWeakRef2.get();
                        BytecodeManager.incBytecodes(1);
                    }
                    final Logger logger3 = logger2;
                    BytecodeManager.incBytecodes(1);
                    final Logger logger4 = logger3;
                    BytecodeManager.incBytecodes(2);
                    if (logger4 == null) {
                        final LogNode logNode2 = logNode;
                        BytecodeManager.incBytecodes(3);
                        logNode2.walkAndSetParent(logger);
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        final Logger logger5 = logger3;
                        BytecodeManager.incBytecodes(3);
                        LogManager.access$1200(logger5, logger);
                    }
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private final class RootLogger extends Logger
    {
        private RootLogger() {
            try {
                BytecodeManager.incBytecodes(3);
                final String s = "";
                final String s2 = null;
                final Class<?> clazz = null;
                final boolean b = true;
                BytecodeManager.incBytecodes(7);
                super(s, s2, clazz, LogManager.this, b);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void log(final LogRecord logRecord) {
            try {
                final LogManager this$0 = LogManager.this;
                BytecodeManager.incBytecodes(3);
                LogManager.access$1500(this$0);
                BytecodeManager.incBytecodes(3);
                super.log(logRecord);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void addHandler(final Handler handler) {
            try {
                final LogManager this$0 = LogManager.this;
                BytecodeManager.incBytecodes(3);
                LogManager.access$1500(this$0);
                BytecodeManager.incBytecodes(3);
                super.addHandler(handler);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void removeHandler(final Handler handler) {
            try {
                final LogManager this$0 = LogManager.this;
                BytecodeManager.incBytecodes(3);
                LogManager.access$1500(this$0);
                BytecodeManager.incBytecodes(3);
                super.removeHandler(handler);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        Handler[] accessCheckedHandlers() {
            try {
                final LogManager this$0 = LogManager.this;
                BytecodeManager.incBytecodes(3);
                LogManager.access$1500(this$0);
                BytecodeManager.incBytecodes(2);
                final Handler[] accessCheckedHandlers = super.accessCheckedHandlers();
                BytecodeManager.incBytecodes(1);
                return accessCheckedHandlers;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private static class Beans
    {
        private static final Class<?> propertyChangeListenerClass;
        private static final Class<?> propertyChangeEventClass;
        private static final Method propertyChangeMethod;
        private static final Constructor<?> propertyEventCtor;
        
        private Beans() {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private static Class<?> getClass(final String name) {
            try {
                try {
                    final boolean initialize = true;
                    final Class<Beans> clazz = Beans.class;
                    BytecodeManager.incBytecodes(4);
                    final ClassLoader classLoader = clazz.getClassLoader();
                    BytecodeManager.incBytecodes(1);
                    final Class<?> forName = Class.forName(name, initialize, classLoader);
                    BytecodeManager.incBytecodes(1);
                    return forName;
                }
                catch (ClassNotFoundException ex) {
                    BytecodeManager.incBytecodes(501);
                    final Class<?> clazz2 = null;
                    BytecodeManager.incBytecodes(2);
                    return clazz2;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        private static Constructor<?> getConstructor(final Class<?> clazz, final Class<?>... parameterTypes) {
            try {
                try {
                    BytecodeManager.incBytecodes(2);
                    Constructor<?> declaredConstructor;
                    if (clazz == null) {
                        declaredConstructor = null;
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        BytecodeManager.incBytecodes(3);
                        declaredConstructor = clazz.getDeclaredConstructor(parameterTypes);
                    }
                    BytecodeManager.incBytecodes(1);
                    return declaredConstructor;
                }
                catch (NoSuchMethodException ex) {
                    BytecodeManager.incBytecodes(501);
                    final NoSuchMethodException detailMessage = ex;
                    BytecodeManager.incBytecodes(4);
                    final AssertionError assertionError = new AssertionError((Object)detailMessage);
                    BytecodeManager.incBytecodes(1);
                    throw assertionError;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        private static Method getMethod(final Class<?> clazz, final String name, final Class<?>... parameterTypes) {
            try {
                try {
                    BytecodeManager.incBytecodes(2);
                    Method method;
                    if (clazz == null) {
                        method = null;
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        BytecodeManager.incBytecodes(4);
                        method = clazz.getMethod(name, (Class[])parameterTypes);
                    }
                    BytecodeManager.incBytecodes(1);
                    return method;
                }
                catch (NoSuchMethodException ex) {
                    BytecodeManager.incBytecodes(501);
                    final NoSuchMethodException detailMessage = ex;
                    BytecodeManager.incBytecodes(4);
                    final AssertionError assertionError = new AssertionError((Object)detailMessage);
                    BytecodeManager.incBytecodes(1);
                    throw assertionError;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        static boolean isBeansPresent() {
            try {
                final Class<?> propertyChangeListenerClass = Beans.propertyChangeListenerClass;
                BytecodeManager.incBytecodes(2);
                boolean b = false;
                Label_0037: {
                    if (propertyChangeListenerClass != null) {
                        final Class<?> propertyChangeEventClass = Beans.propertyChangeEventClass;
                        BytecodeManager.incBytecodes(2);
                        if (propertyChangeEventClass != null) {
                            b = true;
                            BytecodeManager.incBytecodes(2);
                            break Label_0037;
                        }
                    }
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
        
        static Object newPropertyChangeEvent(final Object o, final String s, final Object o2, final Object o3) {
            try {
                try {
                    final Constructor<?> propertyEventCtor = Beans.propertyEventCtor;
                    final Object[] initargs = { o, s, o2, o3 };
                    BytecodeManager.incBytecodes(19);
                    final Object instance = propertyEventCtor.newInstance(initargs);
                    BytecodeManager.incBytecodes(1);
                    return instance;
                }
                catch (InstantiationException | IllegalAccessException ex4) {
                    final Object o5;
                    final Object o4 = o5;
                    BytecodeManager.incBytecodes(501);
                    final Object detailMessage = o4;
                    BytecodeManager.incBytecodes(4);
                    final AssertionError assertionError = new AssertionError(detailMessage);
                    BytecodeManager.incBytecodes(1);
                    throw assertionError;
                }
                catch (InvocationTargetException ex2) {
                    BytecodeManager.incBytecodes(501);
                    final InvocationTargetException ex = ex2;
                    BytecodeManager.incBytecodes(2);
                    final Throwable cause = ex.getCause();
                    BytecodeManager.incBytecodes(1);
                    final boolean b = cause instanceof Error;
                    BytecodeManager.incBytecodes(3);
                    if (b) {
                        final Error error = (Error)cause;
                        BytecodeManager.incBytecodes(3);
                        throw error;
                    }
                    final boolean b2 = cause instanceof RuntimeException;
                    BytecodeManager.incBytecodes(3);
                    if (b2) {
                        final RuntimeException ex3 = (RuntimeException)cause;
                        BytecodeManager.incBytecodes(3);
                        throw ex3;
                    }
                    final InvocationTargetException detailMessage2 = ex2;
                    BytecodeManager.incBytecodes(4);
                    final AssertionError assertionError2 = new AssertionError((Object)detailMessage2);
                    BytecodeManager.incBytecodes(1);
                    throw assertionError2;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        static void invokePropertyChange(final Object obj, final Object o) {
            try {
                try {
                    try {
                        final Method propertyChangeMethod = Beans.propertyChangeMethod;
                        final Object[] args = { o };
                        BytecodeManager.incBytecodes(8);
                        propertyChangeMethod.invoke(obj, args);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                    }
                    catch (IllegalAccessException ex) {
                        BytecodeManager.incBytecodes(501);
                        final IllegalAccessException detailMessage = ex;
                        BytecodeManager.incBytecodes(4);
                        final AssertionError assertionError = new AssertionError((Object)detailMessage);
                        BytecodeManager.incBytecodes(1);
                        throw assertionError;
                    }
                    catch (InvocationTargetException ex3) {
                        BytecodeManager.incBytecodes(501);
                        final InvocationTargetException ex2 = ex3;
                        BytecodeManager.incBytecodes(2);
                        final Throwable cause = ex2.getCause();
                        BytecodeManager.incBytecodes(1);
                        final boolean b = cause instanceof Error;
                        BytecodeManager.incBytecodes(3);
                        if (b) {
                            final Error error = (Error)cause;
                            BytecodeManager.incBytecodes(3);
                            throw error;
                        }
                        final boolean b2 = cause instanceof RuntimeException;
                        BytecodeManager.incBytecodes(3);
                        if (b2) {
                            final RuntimeException ex4 = (RuntimeException)cause;
                            BytecodeManager.incBytecodes(3);
                            throw ex4;
                        }
                        final InvocationTargetException detailMessage2 = ex3;
                        BytecodeManager.incBytecodes(4);
                        final AssertionError assertionError2 = new AssertionError((Object)detailMessage2);
                        BytecodeManager.incBytecodes(1);
                        throw assertionError2;
                    }
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        static {
            try {
                final String s = "java.beans.PropertyChangeListener";
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                propertyChangeListenerClass = getClass(s);
                BytecodeManager.incBytecodes(1);
                final String s2 = "java.beans.PropertyChangeEvent";
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                propertyChangeEventClass = getClass(s2);
                BytecodeManager.incBytecodes(1);
                final Class<?> propertyChangeListenerClass2 = Beans.propertyChangeListenerClass;
                final String s3 = "propertyChange";
                final Class[] array = { Beans.propertyChangeEventClass };
                BytecodeManager.incBytecodes(7);
                BytecodeManager.incBytecodes(1);
                propertyChangeMethod = getMethod(propertyChangeListenerClass2, s3, (Class<?>[])array);
                BytecodeManager.incBytecodes(1);
                final Class<?> propertyChangeEventClass2 = Beans.propertyChangeEventClass;
                final Class[] array2 = { Object.class, String.class, Object.class, Object.class };
                BytecodeManager.incBytecodes(18);
                BytecodeManager.incBytecodes(1);
                propertyEventCtor = getConstructor(propertyChangeEventClass2, (Class<?>[])array2);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
}
