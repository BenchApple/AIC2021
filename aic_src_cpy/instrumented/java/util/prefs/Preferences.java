// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.prefs;

import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;
import aic2021.engine.BytecodeManager;
import java.security.Permission;

public abstract class Preferences
{
    private static final PreferencesFactory factory;
    public static final int MAX_KEY_LENGTH = 80;
    public static final int MAX_VALUE_LENGTH = 8192;
    public static final int MAX_NAME_LENGTH = 80;
    private static Permission prefsPerm;
    
    private static PreferencesFactory factory() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: ldc             3
        //     6: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     9: invokespecial   instrumented/java/util/prefs/Preferences$1.<init>:()V
        //    12: ldc             1
        //    14: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    17: invokestatic    java/security/AccessController.doPrivileged:(Ljava/security/PrivilegedAction;)Ljava/lang/Object;
        //    20: checkcast       Ljava/lang/String;
        //    23: astore_0       
        //    24: ldc             2
        //    26: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    29: aload_0        
        //    30: ldc             2
        //    32: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    35: ifnull          250
        //    38: aload_0        
        //    39: iconst_0       
        //    40: ldc             2
        //    42: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    45: ldc             1
        //    47: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    50: invokestatic    java/lang/ClassLoader.getSystemClassLoader:()Ljava/lang/ClassLoader;
        //    53: ldc             1
        //    55: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    58: invokestatic    java/lang/Class.forName:(Ljava/lang/String;ZLjava/lang/ClassLoader;)Ljava/lang/Class;
        //    61: ldc             1
        //    63: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    66: invokevirtual   java/lang/Class.newInstance:()Ljava/lang/Object;
        //    69: checkcast       Linstrumented/java/util/prefs/PreferencesFactory;
        //    72: ldc             1
        //    74: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    77: ldc             1
        //    79: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    82: areturn        
        //    83: astore_1       
        //    84: ldc             501
        //    86: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    89: ldc             1
        //    91: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    94: invokestatic    java/lang/System.getSecurityManager:()Ljava/lang/SecurityManager;
        //    97: astore_2       
        //    98: ldc             1
        //   100: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   103: aload_2        
        //   104: ldc             2
        //   106: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   109: ifnull          133
        //   112: aload_2        
        //   113: new             Ljava/security/AllPermission;
        //   116: dup            
        //   117: ldc             4
        //   119: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   122: invokespecial   java/security/AllPermission.<init>:()V
        //   125: ldc             1
        //   127: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   130: invokevirtual   java/lang/SecurityManager.checkPermission:(Ljava/security/Permission;)V
        //   133: aload_0        
        //   134: iconst_0       
        //   135: ldc             2
        //   137: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   140: ldc             1
        //   142: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   145: invokestatic    java/lang/Thread.currentThread:()Ljava/lang/Thread;
        //   148: ldc             1
        //   150: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   153: invokevirtual   java/lang/Thread.getContextClassLoader:()Ljava/lang/ClassLoader;
        //   156: ldc             1
        //   158: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   161: invokestatic    java/lang/Class.forName:(Ljava/lang/String;ZLjava/lang/ClassLoader;)Ljava/lang/Class;
        //   164: ldc             1
        //   166: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   169: invokevirtual   java/lang/Class.newInstance:()Ljava/lang/Object;
        //   172: checkcast       Linstrumented/java/util/prefs/PreferencesFactory;
        //   175: ldc             1
        //   177: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   180: ldc             1
        //   182: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   185: areturn        
        //   186: astore_2       
        //   187: ldc             501
        //   189: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   192: new             Ljava/lang/InternalError;
        //   195: dup            
        //   196: new             Ljava/lang/StringBuilder;
        //   199: dup            
        //   200: ldc             5
        //   202: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   205: invokespecial   java/lang/StringBuilder.<init>:()V
        //   208: ldc             "Can't instantiate Preferences factory "
        //   210: ldc             2
        //   212: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   215: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   218: aload_0        
        //   219: ldc             2
        //   221: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   224: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   227: ldc             1
        //   229: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   232: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   235: aload_2        
        //   236: ldc             2
        //   238: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   241: invokespecial   java/lang/InternalError.<init>:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   244: ldc             1
        //   246: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   249: athrow         
        //   250: new             Linstrumented/java/util/prefs/Preferences$2;
        //   253: dup            
        //   254: ldc             3
        //   256: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   259: invokespecial   instrumented/java/util/prefs/Preferences$2.<init>:()V
        //   262: ldc             1
        //   264: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   267: invokestatic    java/security/AccessController.doPrivileged:(Ljava/security/PrivilegedAction;)Ljava/lang/Object;
        //   270: checkcast       Linstrumented/java/util/prefs/PreferencesFactory;
        //   273: ldc             2
        //   275: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   278: areturn        
        //   279: athrow         
        //   280: athrow         
        //    StackMapTable: 00 06 FF 00 53 00 01 07 00 2C 00 01 07 00 18 FD 00 31 07 00 18 07 00 4C FF 00 34 00 02 07 00 2C 07 00 18 00 01 07 00 18 FA 00 3F FF 00 1C 00 00 00 01 07 00 6F FF 00 00 00 00 00 01 07 00 16
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  38     280    280    281    Ljava/lang/VirtualMachineError;
        //  38     77     83     250    Ljava/lang/Exception;
        //  89     180    186    250    Ljava/lang/Exception;
        //  0      279    279    280    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0133:
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
    
    private static PreferencesFactory factory1() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     2: ldc             1
        //     4: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     7: ldc             1
        //     9: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    12: invokestatic    java/lang/ClassLoader.getSystemClassLoader:()Ljava/lang/ClassLoader;
        //    15: ldc             1
        //    17: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    20: invokestatic    instrumented/java/util/ServiceLoader.load:(Ljava/lang/Class;Ljava/lang/ClassLoader;)Linstrumented/java/util/ServiceLoader;
        //    23: ldc             1
        //    25: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    28: invokevirtual   instrumented/java/util/ServiceLoader.iterator:()Ljava/util/Iterator;
        //    31: astore_0       
        //    32: ldc             1
        //    34: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    37: aload_0        
        //    38: ldc             2
        //    40: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    43: invokeinterface java/util/Iterator.hasNext:()Z
        //    48: ldc             1
        //    50: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    53: ifeq            122
        //    56: aload_0        
        //    57: ldc             2
        //    59: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    62: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    67: checkcast       Linstrumented/java/util/prefs/PreferencesFactory;
        //    70: ldc             1
        //    72: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    75: ldc             1
        //    77: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    80: areturn        
        //    81: astore_1       
        //    82: ldc             501
        //    84: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    87: aload_1        
        //    88: ldc             2
        //    90: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    93: invokevirtual   instrumented/java/util/ServiceConfigurationError.getCause:()Ljava/lang/Throwable;
        //    96: instanceof      Ljava/lang/SecurityException;
        //    99: ldc             2
        //   101: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   104: ifeq            115
        //   107: ldc             1
        //   109: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   112: goto            37
        //   115: aload_1        
        //   116: ldc             2
        //   118: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   121: athrow         
        //   122: ldc             "os.name"
        //   124: ldc             2
        //   126: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   129: invokestatic    java/lang/System.getProperty:(Ljava/lang/String;)Ljava/lang/String;
        //   132: astore_1       
        //   133: ldc             1
        //   135: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   138: aload_1        
        //   139: ldc             "Windows"
        //   141: ldc             3
        //   143: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   146: invokevirtual   java/lang/String.startsWith:(Ljava/lang/String;)Z
        //   149: ldc             1
        //   151: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   154: ifeq            168
        //   157: ldc             "java.util.prefs.WindowsPreferencesFactory"
        //   159: astore_2       
        //   160: ldc             3
        //   162: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   165: goto            206
        //   168: aload_1        
        //   169: ldc             "OS X"
        //   171: ldc             3
        //   173: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   176: invokevirtual   java/lang/String.contains:(Ljava/lang/CharSequence;)Z
        //   179: ldc             1
        //   181: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   184: ifeq            198
        //   187: ldc             "java.util.prefs.MacOSXPreferencesFactory"
        //   189: astore_2       
        //   190: ldc             3
        //   192: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   195: goto            206
        //   198: ldc             "java.util.prefs.FileSystemPreferencesFactory"
        //   200: astore_2       
        //   201: ldc             2
        //   203: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   206: aload_2        
        //   207: iconst_0       
        //   208: ldc             Linstrumented/java/util/prefs/Preferences;.class
        //   210: ldc             3
        //   212: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   215: ldc             1
        //   217: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   220: invokevirtual   java/lang/Class.getClassLoader:()Ljava/lang/ClassLoader;
        //   223: ldc             1
        //   225: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   228: invokestatic    java/lang/Class.forName:(Ljava/lang/String;ZLjava/lang/ClassLoader;)Ljava/lang/Class;
        //   231: ldc             1
        //   233: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   236: invokevirtual   java/lang/Class.newInstance:()Ljava/lang/Object;
        //   239: checkcast       Linstrumented/java/util/prefs/PreferencesFactory;
        //   242: ldc             1
        //   244: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   247: ldc             1
        //   249: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   252: areturn        
        //   253: astore_3       
        //   254: ldc             501
        //   256: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   259: new             Ljava/lang/InternalError;
        //   262: dup            
        //   263: new             Ljava/lang/StringBuilder;
        //   266: dup            
        //   267: ldc             5
        //   269: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   272: invokespecial   java/lang/StringBuilder.<init>:()V
        //   275: ldc             "Can't instantiate platform default Preferences factory "
        //   277: ldc             2
        //   279: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   282: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   285: aload_2        
        //   286: ldc             2
        //   288: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   291: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   294: ldc             1
        //   296: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   299: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   302: aload_3        
        //   303: ldc             2
        //   305: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   308: invokespecial   java/lang/InternalError.<init>:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   311: ldc             1
        //   313: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   316: athrow         
        //   317: athrow         
        //   318: athrow         
        //    StackMapTable: 00 0A FC 00 25 07 00 7E 6B 07 00 72 FC 00 21 07 00 72 FA 00 06 FC 00 2D 07 00 2C 1D FC 00 07 07 00 2C 6E 07 00 18 FF 00 3F 00 00 00 01 07 00 6F FF 00 00 00 00 00 01 07 00 16
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                              
        //  -----  -----  -----  -----  --------------------------------------------------
        //  56     318    318    319    Ljava/lang/VirtualMachineError;
        //  56     75     81     122    Linstrumented/java/util/ServiceConfigurationError;
        //  206    247    253    317    Ljava/lang/Exception;
        //  0      317    317    318    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0115:
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
    
    public static Preferences userNodeForPackage(final Class<?> clazz) {
        try {
            BytecodeManager.incBytecodes(1);
            final Preferences userRoot = userRoot();
            BytecodeManager.incBytecodes(2);
            final String nodeName = nodeName(clazz);
            BytecodeManager.incBytecodes(1);
            final Preferences node = userRoot.node(nodeName);
            BytecodeManager.incBytecodes(1);
            return node;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static Preferences systemNodeForPackage(final Class<?> clazz) {
        try {
            BytecodeManager.incBytecodes(1);
            final Preferences systemRoot = systemRoot();
            BytecodeManager.incBytecodes(2);
            final String nodeName = nodeName(clazz);
            BytecodeManager.incBytecodes(1);
            final Preferences node = systemRoot.node(nodeName);
            BytecodeManager.incBytecodes(1);
            return node;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static String nodeName(final Class<?> clazz) {
        try {
            BytecodeManager.incBytecodes(2);
            final boolean array = clazz.isArray();
            BytecodeManager.incBytecodes(1);
            if (array) {
                final String s = "Arrays have no associated preferences node.";
                BytecodeManager.incBytecodes(4);
                final IllegalArgumentException ex = new IllegalArgumentException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(2);
            final String name = clazz.getName();
            BytecodeManager.incBytecodes(1);
            final String s2 = name;
            final int ch = 46;
            BytecodeManager.incBytecodes(3);
            final int lastIndex = s2.lastIndexOf(ch);
            BytecodeManager.incBytecodes(1);
            final int n = lastIndex;
            BytecodeManager.incBytecodes(2);
            if (n < 0) {
                final String s3 = "/<unnamed>";
                BytecodeManager.incBytecodes(2);
                return s3;
            }
            final String s4 = name;
            final int beginIndex = 0;
            final int endIndex = lastIndex;
            BytecodeManager.incBytecodes(4);
            final String substring = s4.substring(beginIndex, endIndex);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            final StringBuilder sb = new StringBuilder();
            final String str = "/";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append = sb.append(str);
            final String s5 = substring;
            final char oldChar = '.';
            final char newChar = '/';
            BytecodeManager.incBytecodes(4);
            final String replace = s5.replace(oldChar, newChar);
            BytecodeManager.incBytecodes(1);
            final StringBuilder append2 = append.append(replace);
            BytecodeManager.incBytecodes(1);
            final String string = append2.toString();
            BytecodeManager.incBytecodes(1);
            return string;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static Preferences userRoot() {
        try {
            BytecodeManager.incBytecodes(1);
            final SecurityManager securityManager = System.getSecurityManager();
            BytecodeManager.incBytecodes(1);
            final SecurityManager securityManager2 = securityManager;
            BytecodeManager.incBytecodes(2);
            if (securityManager2 != null) {
                final SecurityManager securityManager3 = securityManager;
                final Permission prefsPerm = Preferences.prefsPerm;
                BytecodeManager.incBytecodes(3);
                securityManager3.checkPermission(prefsPerm);
            }
            final PreferencesFactory factory = Preferences.factory;
            BytecodeManager.incBytecodes(2);
            final Preferences userRoot = factory.userRoot();
            BytecodeManager.incBytecodes(1);
            return userRoot;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static Preferences systemRoot() {
        try {
            BytecodeManager.incBytecodes(1);
            final SecurityManager securityManager = System.getSecurityManager();
            BytecodeManager.incBytecodes(1);
            final SecurityManager securityManager2 = securityManager;
            BytecodeManager.incBytecodes(2);
            if (securityManager2 != null) {
                final SecurityManager securityManager3 = securityManager;
                final Permission prefsPerm = Preferences.prefsPerm;
                BytecodeManager.incBytecodes(3);
                securityManager3.checkPermission(prefsPerm);
            }
            final PreferencesFactory factory = Preferences.factory;
            BytecodeManager.incBytecodes(2);
            final Preferences systemRoot = factory.systemRoot();
            BytecodeManager.incBytecodes(1);
            return systemRoot;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    protected Preferences() {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public abstract void put(final String p0, final String p1);
    
    public abstract String get(final String p0, final String p1);
    
    public abstract void remove(final String p0);
    
    public abstract void clear() throws BackingStoreException;
    
    public abstract void putInt(final String p0, final int p1);
    
    public abstract int getInt(final String p0, final int p1);
    
    public abstract void putLong(final String p0, final long p1);
    
    public abstract long getLong(final String p0, final long p1);
    
    public abstract void putBoolean(final String p0, final boolean p1);
    
    public abstract boolean getBoolean(final String p0, final boolean p1);
    
    public abstract void putFloat(final String p0, final float p1);
    
    public abstract float getFloat(final String p0, final float p1);
    
    public abstract void putDouble(final String p0, final double p1);
    
    public abstract double getDouble(final String p0, final double p1);
    
    public abstract void putByteArray(final String p0, final byte[] p1);
    
    public abstract byte[] getByteArray(final String p0, final byte[] p1);
    
    public abstract String[] keys() throws BackingStoreException;
    
    public abstract String[] childrenNames() throws BackingStoreException;
    
    public abstract Preferences parent();
    
    public abstract Preferences node(final String p0);
    
    public abstract boolean nodeExists(final String p0) throws BackingStoreException;
    
    public abstract void removeNode() throws BackingStoreException;
    
    public abstract String name();
    
    public abstract String absolutePath();
    
    public abstract boolean isUserNode();
    
    @Override
    public abstract String toString();
    
    public abstract void flush() throws BackingStoreException;
    
    public abstract void sync() throws BackingStoreException;
    
    public abstract void addPreferenceChangeListener(final PreferenceChangeListener p0);
    
    public abstract void removePreferenceChangeListener(final PreferenceChangeListener p0);
    
    public abstract void addNodeChangeListener(final NodeChangeListener p0);
    
    public abstract void removeNodeChangeListener(final NodeChangeListener p0);
    
    public abstract void exportNode(final OutputStream p0) throws IOException, BackingStoreException;
    
    public abstract void exportSubtree(final OutputStream p0) throws IOException, BackingStoreException;
    
    public static void importPreferences(final InputStream inputStream) throws IOException, InvalidPreferencesFormatException {
        try {
            BytecodeManager.incBytecodes(2);
            XmlSupport.importPreferences(inputStream);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static {
        try {
            BytecodeManager.incBytecodes(1);
            factory = factory();
            BytecodeManager.incBytecodes(1);
            final String name = "preferences";
            BytecodeManager.incBytecodes(4);
            Preferences.prefsPerm = new RuntimePermission(name);
            BytecodeManager.incBytecodes(2);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
