// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.prefs;

import instrumented.java.util.StringTokenizer;
import java.io.ByteArrayOutputStream;
import aic2021.engine.BytecodeManager;
import sun.util.logging.PlatformLogger;

class WindowsPreferences extends AbstractPreferences
{
    private static PlatformLogger logger;
    private static final byte[] WINDOWS_ROOT_PATH;
    private static final int HKEY_CURRENT_USER = -2147483647;
    private static final int HKEY_LOCAL_MACHINE = -2147483646;
    private static final int USER_ROOT_NATIVE_HANDLE = -2147483647;
    private static final int SYSTEM_ROOT_NATIVE_HANDLE = -2147483646;
    private static final int MAX_WINDOWS_PATH_LENGTH = 256;
    static final Preferences userRoot;
    static final Preferences systemRoot;
    private static final int ERROR_SUCCESS = 0;
    private static final int ERROR_FILE_NOT_FOUND = 2;
    private static final int ERROR_ACCESS_DENIED = 5;
    private static final int NATIVE_HANDLE = 0;
    private static final int ERROR_CODE = 1;
    private static final int SUBKEYS_NUMBER = 0;
    private static final int VALUES_NUMBER = 2;
    private static final int MAX_KEY_LENGTH = 3;
    private static final int MAX_VALUE_NAME_LENGTH = 4;
    private static final int DISPOSITION = 2;
    private static final int REG_CREATED_NEW_KEY = 1;
    private static final int REG_OPENED_EXISTING_KEY = 2;
    private static final int NULL_NATIVE_HANDLE = 0;
    private static final int DELETE = 65536;
    private static final int KEY_QUERY_VALUE = 1;
    private static final int KEY_SET_VALUE = 2;
    private static final int KEY_CREATE_SUB_KEY = 4;
    private static final int KEY_ENUMERATE_SUB_KEYS = 8;
    private static final int KEY_READ = 131097;
    private static final int KEY_WRITE = 131078;
    private static final int KEY_ALL_ACCESS = 983103;
    private static int INIT_SLEEP_TIME;
    private static int MAX_ATTEMPTS;
    private boolean isBackingStoreAvailable;
    
    private static native int[] WindowsRegOpenKey(final int p0, final byte[] p1, final int p2);
    
    private static int[] WindowsRegOpenKey1(final int p0, final byte[] p1, final int p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: aload_1        
        //     2: iload_2        
        //     3: ldc             4
        //     5: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     8: invokestatic    instrumented/java/util/prefs/WindowsPreferences.WindowsRegOpenKey:(I[BI)[I
        //    11: astore_3       
        //    12: ldc             1
        //    14: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    17: aload_3        
        //    18: iconst_1       
        //    19: iaload         
        //    20: ldc             4
        //    22: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    25: ifne            35
        //    28: aload_3        
        //    29: ldc             2
        //    31: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    34: areturn        
        //    35: aload_3        
        //    36: iconst_1       
        //    37: iaload         
        //    38: iconst_2       
        //    39: ldc             5
        //    41: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    44: if_icmpne       209
        //    47: ldc             1
        //    49: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    52: invokestatic    instrumented/java/util/prefs/WindowsPreferences.logger:()Lsun/util/logging/PlatformLogger;
        //    55: new             Ljava/lang/StringBuilder;
        //    58: dup            
        //    59: ldc             3
        //    61: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    64: invokespecial   java/lang/StringBuilder.<init>:()V
        //    67: ldc             "Trying to recreate Windows registry node "
        //    69: ldc             2
        //    71: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    74: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    77: aload_1        
        //    78: ldc             1
        //    80: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    83: ldc             1
        //    85: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    88: invokestatic    instrumented/java/util/prefs/WindowsPreferences.byteArrayToString:([B)Ljava/lang/String;
        //    91: ldc             1
        //    93: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    96: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    99: ldc             " at root 0x"
        //   101: ldc             2
        //   103: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   106: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   109: iload_0        
        //   110: ldc             1
        //   112: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   115: ldc             1
        //   117: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   120: invokestatic    java/lang/Integer.toHexString:(I)Ljava/lang/String;
        //   123: ldc             1
        //   125: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   128: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   131: ldc             "."
        //   133: ldc             2
        //   135: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   138: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   141: ldc             1
        //   143: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   146: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   149: ldc             1
        //   151: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   154: invokevirtual   sun/util/logging/PlatformLogger.warning:(Ljava/lang/String;)V
        //   157: iload_0        
        //   158: aload_1        
        //   159: ldc             3
        //   161: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   164: invokestatic    instrumented/java/util/prefs/WindowsPreferences.WindowsRegCreateKeyEx:(I[B)[I
        //   167: iconst_0       
        //   168: iaload         
        //   169: istore          4
        //   171: ldc             3
        //   173: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   176: iload           4
        //   178: ldc             2
        //   180: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   183: invokestatic    instrumented/java/util/prefs/WindowsPreferences.WindowsRegCloseKey:(I)I
        //   186: pop            
        //   187: ldc             1
        //   189: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   192: iload_0        
        //   193: aload_1        
        //   194: iload_2        
        //   195: ldc             4
        //   197: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   200: invokestatic    instrumented/java/util/prefs/WindowsPreferences.WindowsRegOpenKey:(I[BI)[I
        //   203: ldc             1
        //   205: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   208: areturn        
        //   209: aload_3        
        //   210: iconst_1       
        //   211: iaload         
        //   212: iconst_5       
        //   213: ldc             5
        //   215: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   218: if_icmpeq       344
        //   221: getstatic       instrumented/java/util/prefs/WindowsPreferences.INIT_SLEEP_TIME:I
        //   224: i2l            
        //   225: lstore          4
        //   227: ldc             3
        //   229: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   232: iconst_0       
        //   233: istore          6
        //   235: ldc             2
        //   237: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   240: iload           6
        //   242: getstatic       instrumented/java/util/prefs/WindowsPreferences.MAX_ATTEMPTS:I
        //   245: ldc             3
        //   247: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   250: if_icmpge       344
        //   253: lload           4
        //   255: ldc             2
        //   257: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   260: invokestatic    java/lang/Thread.sleep:(J)V
        //   263: ldc             1
        //   265: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   268: goto            285
        //   271: astore          7
        //   273: ldc             501
        //   275: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   278: aload_3        
        //   279: ldc             2
        //   281: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   284: areturn        
        //   285: lload           4
        //   287: ldc2_w          2
        //   290: lmul           
        //   291: lstore          4
        //   293: ldc             4
        //   295: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   298: iload_0        
        //   299: aload_1        
        //   300: iload_2        
        //   301: ldc             4
        //   303: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   306: invokestatic    instrumented/java/util/prefs/WindowsPreferences.WindowsRegOpenKey:(I[BI)[I
        //   309: astore_3       
        //   310: ldc             1
        //   312: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   315: aload_3        
        //   316: iconst_1       
        //   317: iaload         
        //   318: ldc             4
        //   320: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   323: ifne            333
        //   326: aload_3        
        //   327: ldc             2
        //   329: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   332: areturn        
        //   333: iinc            6, 1
        //   336: ldc             2
        //   338: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   341: goto            240
        //   344: aload_3        
        //   345: ldc             2
        //   347: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   350: areturn        
        //   351: athrow         
        //   352: athrow         
        //    StackMapTable: 00 09 FC 00 23 07 00 4A FB 00 AD FD 00 1E 04 01 5E 07 00 40 0D 2F F9 00 0A FF 00 06 00 00 00 01 07 00 88 FF 00 00 00 00 00 01 07 00 3E
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                            
        //  -----  -----  -----  -----  --------------------------------
        //  253    352    352    353    Ljava/lang/VirtualMachineError;
        //  253    263    271    285    Ljava/lang/InterruptedException;
        //  0      351    351    352    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0285:
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
    
    private static native int WindowsRegCloseKey(final int p0);
    
    private static native int[] WindowsRegCreateKeyEx(final int p0, final byte[] p1);
    
    private static int[] WindowsRegCreateKeyEx1(final int p0, final byte[] p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: aload_1        
        //     2: ldc             3
        //     4: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     7: invokestatic    instrumented/java/util/prefs/WindowsPreferences.WindowsRegCreateKeyEx:(I[B)[I
        //    10: astore_2       
        //    11: ldc             1
        //    13: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    16: aload_2        
        //    17: iconst_1       
        //    18: iaload         
        //    19: ldc             4
        //    21: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    24: ifne            34
        //    27: aload_2        
        //    28: ldc             2
        //    30: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    33: areturn        
        //    34: getstatic       instrumented/java/util/prefs/WindowsPreferences.INIT_SLEEP_TIME:I
        //    37: i2l            
        //    38: lstore_3       
        //    39: ldc             3
        //    41: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    44: iconst_0       
        //    45: istore          5
        //    47: ldc             2
        //    49: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    52: iload           5
        //    54: getstatic       instrumented/java/util/prefs/WindowsPreferences.MAX_ATTEMPTS:I
        //    57: ldc             3
        //    59: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    62: if_icmpge       152
        //    65: lload_3        
        //    66: ldc             2
        //    68: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    71: invokestatic    java/lang/Thread.sleep:(J)V
        //    74: ldc             1
        //    76: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    79: goto            96
        //    82: astore          6
        //    84: ldc             501
        //    86: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    89: aload_2        
        //    90: ldc             2
        //    92: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    95: areturn        
        //    96: lload_3        
        //    97: ldc2_w          2
        //   100: lmul           
        //   101: lstore_3       
        //   102: ldc             4
        //   104: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   107: iload_0        
        //   108: aload_1        
        //   109: ldc             3
        //   111: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   114: invokestatic    instrumented/java/util/prefs/WindowsPreferences.WindowsRegCreateKeyEx:(I[B)[I
        //   117: astore_2       
        //   118: ldc             1
        //   120: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   123: aload_2        
        //   124: iconst_1       
        //   125: iaload         
        //   126: ldc             4
        //   128: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   131: ifne            141
        //   134: aload_2        
        //   135: ldc             2
        //   137: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   140: areturn        
        //   141: iinc            5, 1
        //   144: ldc             2
        //   146: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   149: goto            52
        //   152: aload_2        
        //   153: ldc             2
        //   155: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   158: areturn        
        //   159: athrow         
        //   160: athrow         
        //    StackMapTable: 00 08 FC 00 22 07 00 4A FD 00 11 04 01 5D 07 00 40 0D 2C F9 00 0A FF 00 06 00 00 00 01 07 00 88 FF 00 00 00 00 00 01 07 00 3E
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                            
        //  -----  -----  -----  -----  --------------------------------
        //  65     160    160    161    Ljava/lang/VirtualMachineError;
        //  65     74     82     96     Ljava/lang/InterruptedException;
        //  0      159    159    160    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0096:
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
    
    private static native int WindowsRegDeleteKey(final int p0, final byte[] p1);
    
    private static native int WindowsRegFlushKey(final int p0);
    
    private static int WindowsRegFlushKey1(final int p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             2
        //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     6: invokestatic    instrumented/java/util/prefs/WindowsPreferences.WindowsRegFlushKey:(I)I
        //     9: istore_1       
        //    10: ldc             1
        //    12: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    15: iload_1        
        //    16: ldc             2
        //    18: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    21: ifne            31
        //    24: iload_1        
        //    25: ldc             2
        //    27: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    30: ireturn        
        //    31: getstatic       instrumented/java/util/prefs/WindowsPreferences.INIT_SLEEP_TIME:I
        //    34: i2l            
        //    35: lstore_2       
        //    36: ldc             3
        //    38: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    41: iconst_0       
        //    42: istore          4
        //    44: ldc             2
        //    46: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    49: iload           4
        //    51: getstatic       instrumented/java/util/prefs/WindowsPreferences.MAX_ATTEMPTS:I
        //    54: ldc             3
        //    56: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    59: if_icmpge       146
        //    62: lload_2        
        //    63: ldc             2
        //    65: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    68: invokestatic    java/lang/Thread.sleep:(J)V
        //    71: ldc             1
        //    73: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    76: goto            93
        //    79: astore          5
        //    81: ldc             501
        //    83: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    86: iload_1        
        //    87: ldc             2
        //    89: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    92: ireturn        
        //    93: lload_2        
        //    94: ldc2_w          2
        //    97: lmul           
        //    98: lstore_2       
        //    99: ldc             4
        //   101: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   104: iload_0        
        //   105: ldc             2
        //   107: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   110: invokestatic    instrumented/java/util/prefs/WindowsPreferences.WindowsRegFlushKey:(I)I
        //   113: istore_1       
        //   114: ldc             1
        //   116: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   119: iload_1        
        //   120: ldc             2
        //   122: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   125: ifne            135
        //   128: iload_1        
        //   129: ldc             2
        //   131: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   134: ireturn        
        //   135: iinc            4, 1
        //   138: ldc             2
        //   140: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   143: goto            49
        //   146: iload_1        
        //   147: ldc             2
        //   149: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   152: ireturn        
        //   153: athrow         
        //   154: athrow         
        //    StackMapTable: 00 08 FC 00 1F 01 FD 00 11 04 01 5D 07 00 40 0D 29 F9 00 0A FF 00 06 00 00 00 01 07 00 88 FF 00 00 00 00 00 01 07 00 3E
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                            
        //  -----  -----  -----  -----  --------------------------------
        //  62     154    154    155    Ljava/lang/VirtualMachineError;
        //  62     71     79     93     Ljava/lang/InterruptedException;
        //  0      153    153    154    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0093:
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
    
    private static native byte[] WindowsRegQueryValueEx(final int p0, final byte[] p1);
    
    private static native int WindowsRegSetValueEx(final int p0, final byte[] p1, final byte[] p2);
    
    private static int WindowsRegSetValueEx1(final int p0, final byte[] p1, final byte[] p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: aload_1        
        //     2: aload_2        
        //     3: ldc             4
        //     5: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     8: invokestatic    instrumented/java/util/prefs/WindowsPreferences.WindowsRegSetValueEx:(I[B[B)I
        //    11: istore_3       
        //    12: ldc             1
        //    14: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    17: iload_3        
        //    18: ldc             2
        //    20: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    23: ifne            33
        //    26: iload_3        
        //    27: ldc             2
        //    29: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    32: ireturn        
        //    33: getstatic       instrumented/java/util/prefs/WindowsPreferences.INIT_SLEEP_TIME:I
        //    36: i2l            
        //    37: lstore          4
        //    39: ldc             3
        //    41: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    44: iconst_0       
        //    45: istore          6
        //    47: ldc             2
        //    49: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    52: iload           6
        //    54: getstatic       instrumented/java/util/prefs/WindowsPreferences.MAX_ATTEMPTS:I
        //    57: ldc             3
        //    59: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    62: if_icmpge       154
        //    65: lload           4
        //    67: ldc             2
        //    69: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    72: invokestatic    java/lang/Thread.sleep:(J)V
        //    75: ldc             1
        //    77: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    80: goto            97
        //    83: astore          7
        //    85: ldc             501
        //    87: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    90: iload_3        
        //    91: ldc             2
        //    93: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    96: ireturn        
        //    97: lload           4
        //    99: ldc2_w          2
        //   102: lmul           
        //   103: lstore          4
        //   105: ldc             4
        //   107: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   110: iload_0        
        //   111: aload_1        
        //   112: aload_2        
        //   113: ldc             4
        //   115: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   118: invokestatic    instrumented/java/util/prefs/WindowsPreferences.WindowsRegSetValueEx:(I[B[B)I
        //   121: istore_3       
        //   122: ldc             1
        //   124: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   127: iload_3        
        //   128: ldc             2
        //   130: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   133: ifne            143
        //   136: iload_3        
        //   137: ldc             2
        //   139: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   142: ireturn        
        //   143: iinc            6, 1
        //   146: ldc             2
        //   148: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   151: goto            52
        //   154: iload_3        
        //   155: ldc             2
        //   157: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   160: ireturn        
        //   161: athrow         
        //   162: athrow         
        //    StackMapTable: 00 08 FC 00 21 01 FD 00 12 04 01 5E 07 00 40 0D 2D F9 00 0A FF 00 06 00 00 00 01 07 00 88 FF 00 00 00 00 00 01 07 00 3E
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                            
        //  -----  -----  -----  -----  --------------------------------
        //  65     162    162    163    Ljava/lang/VirtualMachineError;
        //  65     75     83     97     Ljava/lang/InterruptedException;
        //  0      161    161    162    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0097:
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
    
    private static native int WindowsRegDeleteValue(final int p0, final byte[] p1);
    
    private static native int[] WindowsRegQueryInfoKey(final int p0);
    
    private static int[] WindowsRegQueryInfoKey1(final int p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             2
        //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     6: invokestatic    instrumented/java/util/prefs/WindowsPreferences.WindowsRegQueryInfoKey:(I)[I
        //     9: astore_1       
        //    10: ldc             1
        //    12: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    15: aload_1        
        //    16: iconst_1       
        //    17: iaload         
        //    18: ldc             4
        //    20: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    23: ifne            33
        //    26: aload_1        
        //    27: ldc             2
        //    29: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    32: areturn        
        //    33: getstatic       instrumented/java/util/prefs/WindowsPreferences.INIT_SLEEP_TIME:I
        //    36: i2l            
        //    37: lstore_2       
        //    38: ldc             3
        //    40: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    43: iconst_0       
        //    44: istore          4
        //    46: ldc             2
        //    48: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    51: iload           4
        //    53: getstatic       instrumented/java/util/prefs/WindowsPreferences.MAX_ATTEMPTS:I
        //    56: ldc             3
        //    58: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    61: if_icmpge       150
        //    64: lload_2        
        //    65: ldc             2
        //    67: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    70: invokestatic    java/lang/Thread.sleep:(J)V
        //    73: ldc             1
        //    75: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    78: goto            95
        //    81: astore          5
        //    83: ldc             501
        //    85: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    88: aload_1        
        //    89: ldc             2
        //    91: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    94: areturn        
        //    95: lload_2        
        //    96: ldc2_w          2
        //    99: lmul           
        //   100: lstore_2       
        //   101: ldc             4
        //   103: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   106: iload_0        
        //   107: ldc             2
        //   109: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   112: invokestatic    instrumented/java/util/prefs/WindowsPreferences.WindowsRegQueryInfoKey:(I)[I
        //   115: astore_1       
        //   116: ldc             1
        //   118: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   121: aload_1        
        //   122: iconst_1       
        //   123: iaload         
        //   124: ldc             4
        //   126: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   129: ifne            139
        //   132: aload_1        
        //   133: ldc             2
        //   135: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   138: areturn        
        //   139: iinc            4, 1
        //   142: ldc             2
        //   144: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   147: goto            51
        //   150: aload_1        
        //   151: ldc             2
        //   153: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   156: areturn        
        //   157: athrow         
        //   158: athrow         
        //    StackMapTable: 00 08 FC 00 21 07 00 4A FD 00 11 04 01 5D 07 00 40 0D 2B F9 00 0A FF 00 06 00 00 00 01 07 00 88 FF 00 00 00 00 00 01 07 00 3E
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                            
        //  -----  -----  -----  -----  --------------------------------
        //  64     158    158    159    Ljava/lang/VirtualMachineError;
        //  64     73     81     95     Ljava/lang/InterruptedException;
        //  0      157    157    158    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0095:
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
    
    private static native byte[] WindowsRegEnumKeyEx(final int p0, final int p1, final int p2);
    
    private static byte[] WindowsRegEnumKeyEx1(final int p0, final int p1, final int p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: iload_1        
        //     2: iload_2        
        //     3: ldc             4
        //     5: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     8: invokestatic    instrumented/java/util/prefs/WindowsPreferences.WindowsRegEnumKeyEx:(III)[B
        //    11: astore_3       
        //    12: ldc             1
        //    14: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    17: aload_3        
        //    18: ldc             2
        //    20: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    23: ifnull          33
        //    26: aload_3        
        //    27: ldc             2
        //    29: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    32: areturn        
        //    33: getstatic       instrumented/java/util/prefs/WindowsPreferences.INIT_SLEEP_TIME:I
        //    36: i2l            
        //    37: lstore          4
        //    39: ldc             3
        //    41: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    44: iconst_0       
        //    45: istore          6
        //    47: ldc             2
        //    49: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    52: iload           6
        //    54: getstatic       instrumented/java/util/prefs/WindowsPreferences.MAX_ATTEMPTS:I
        //    57: ldc             3
        //    59: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    62: if_icmpge       154
        //    65: lload           4
        //    67: ldc             2
        //    69: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    72: invokestatic    java/lang/Thread.sleep:(J)V
        //    75: ldc             1
        //    77: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    80: goto            97
        //    83: astore          7
        //    85: ldc             501
        //    87: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    90: aload_3        
        //    91: ldc             2
        //    93: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    96: areturn        
        //    97: lload           4
        //    99: ldc2_w          2
        //   102: lmul           
        //   103: lstore          4
        //   105: ldc             4
        //   107: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   110: iload_0        
        //   111: iload_1        
        //   112: iload_2        
        //   113: ldc             4
        //   115: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   118: invokestatic    instrumented/java/util/prefs/WindowsPreferences.WindowsRegEnumKeyEx:(III)[B
        //   121: astore_3       
        //   122: ldc             1
        //   124: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   127: aload_3        
        //   128: ldc             2
        //   130: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   133: ifnull          143
        //   136: aload_3        
        //   137: ldc             2
        //   139: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   142: areturn        
        //   143: iinc            6, 1
        //   146: ldc             2
        //   148: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   151: goto            52
        //   154: aload_3        
        //   155: ldc             2
        //   157: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   160: areturn        
        //   161: athrow         
        //   162: athrow         
        //    StackMapTable: 00 08 FC 00 21 07 00 A2 FD 00 12 04 01 5E 07 00 40 0D 2D F9 00 0A FF 00 06 00 00 00 01 07 00 88 FF 00 00 00 00 00 01 07 00 3E
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                            
        //  -----  -----  -----  -----  --------------------------------
        //  65     162    162    163    Ljava/lang/VirtualMachineError;
        //  65     75     83     97     Ljava/lang/InterruptedException;
        //  0      161    161    162    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0097:
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
    
    private static native byte[] WindowsRegEnumValue(final int p0, final int p1, final int p2);
    
    private static byte[] WindowsRegEnumValue1(final int p0, final int p1, final int p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: iload_1        
        //     2: iload_2        
        //     3: ldc             4
        //     5: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     8: invokestatic    instrumented/java/util/prefs/WindowsPreferences.WindowsRegEnumValue:(III)[B
        //    11: astore_3       
        //    12: ldc             1
        //    14: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    17: aload_3        
        //    18: ldc             2
        //    20: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    23: ifnull          33
        //    26: aload_3        
        //    27: ldc             2
        //    29: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    32: areturn        
        //    33: getstatic       instrumented/java/util/prefs/WindowsPreferences.INIT_SLEEP_TIME:I
        //    36: i2l            
        //    37: lstore          4
        //    39: ldc             3
        //    41: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    44: iconst_0       
        //    45: istore          6
        //    47: ldc             2
        //    49: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    52: iload           6
        //    54: getstatic       instrumented/java/util/prefs/WindowsPreferences.MAX_ATTEMPTS:I
        //    57: ldc             3
        //    59: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    62: if_icmpge       154
        //    65: lload           4
        //    67: ldc             2
        //    69: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    72: invokestatic    java/lang/Thread.sleep:(J)V
        //    75: ldc             1
        //    77: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    80: goto            97
        //    83: astore          7
        //    85: ldc             501
        //    87: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    90: aload_3        
        //    91: ldc             2
        //    93: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    96: areturn        
        //    97: lload           4
        //    99: ldc2_w          2
        //   102: lmul           
        //   103: lstore          4
        //   105: ldc             4
        //   107: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   110: iload_0        
        //   111: iload_1        
        //   112: iload_2        
        //   113: ldc             4
        //   115: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   118: invokestatic    instrumented/java/util/prefs/WindowsPreferences.WindowsRegEnumValue:(III)[B
        //   121: astore_3       
        //   122: ldc             1
        //   124: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   127: aload_3        
        //   128: ldc             2
        //   130: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   133: ifnull          143
        //   136: aload_3        
        //   137: ldc             2
        //   139: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   142: areturn        
        //   143: iinc            6, 1
        //   146: ldc             2
        //   148: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   151: goto            52
        //   154: aload_3        
        //   155: ldc             2
        //   157: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   160: areturn        
        //   161: athrow         
        //   162: athrow         
        //    StackMapTable: 00 08 FC 00 21 07 00 A2 FD 00 12 04 01 5E 07 00 40 0D 2D F9 00 0A FF 00 06 00 00 00 01 07 00 88 FF 00 00 00 00 00 01 07 00 3E
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                            
        //  -----  -----  -----  -----  --------------------------------
        //  65     162    162    163    Ljava/lang/VirtualMachineError;
        //  65     75     83     97     Ljava/lang/InterruptedException;
        //  0      161    161    162    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0097:
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
    
    private WindowsPreferences(final WindowsPreferences windowsPreferences, final String s) {
        try {
            BytecodeManager.incBytecodes(4);
            super(windowsPreferences, s);
            this.isBackingStoreAvailable = true;
            BytecodeManager.incBytecodes(3);
            final int n = 4;
            final int n2 = 131097;
            BytecodeManager.incBytecodes(4);
            final int openKey = windowsPreferences.openKey(n, n2);
            BytecodeManager.incBytecodes(1);
            final int n3 = openKey;
            BytecodeManager.incBytecodes(2);
            if (n3 == 0) {
                this.isBackingStoreAvailable = false;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
                return;
            }
            final int n4 = openKey;
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
            final byte[] windowsName = toWindowsName(s);
            BytecodeManager.incBytecodes(1);
            final int[] windowsRegCreateKeyEx1 = WindowsRegCreateKeyEx1(n4, windowsName);
            BytecodeManager.incBytecodes(1);
            final int n5 = windowsRegCreateKeyEx1[1];
            BytecodeManager.incBytecodes(4);
            if (n5 != 0) {
                BytecodeManager.incBytecodes(1);
                final PlatformLogger logger = logger();
                BytecodeManager.incBytecodes(3);
                final StringBuilder sb = new StringBuilder();
                final String str = "Could not create windows registry node ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb.append(str);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                final byte[] windowsAbsolutePath = this.windowsAbsolutePath();
                BytecodeManager.incBytecodes(1);
                final String byteArrayToString = byteArrayToString(windowsAbsolutePath);
                BytecodeManager.incBytecodes(1);
                final StringBuilder append2 = append.append(byteArrayToString);
                final String str2 = " at root 0x";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append3 = append2.append(str2);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                final int rootNativeHandle = this.rootNativeHandle();
                BytecodeManager.incBytecodes(1);
                final String hexString = Integer.toHexString(rootNativeHandle);
                BytecodeManager.incBytecodes(1);
                final StringBuilder append4 = append3.append(hexString);
                final String str3 = ". Windows RegCreateKeyEx(...) returned error code ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append5 = append4.append(str3);
                final int i = windowsRegCreateKeyEx1[1];
                BytecodeManager.incBytecodes(4);
                final StringBuilder append6 = append5.append(i);
                final String str4 = ".";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append7 = append6.append(str4);
                BytecodeManager.incBytecodes(1);
                final String string = append7.toString();
                BytecodeManager.incBytecodes(1);
                logger.warning(string);
                this.isBackingStoreAvailable = false;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
                return;
            }
            final int n6 = windowsRegCreateKeyEx1[2];
            final int n7 = 1;
            BytecodeManager.incBytecodes(6);
            boolean newNode;
            if (n6 == n7) {
                newNode = true;
                BytecodeManager.incBytecodes(2);
            }
            else {
                newNode = false;
                BytecodeManager.incBytecodes(1);
            }
            this.newNode = newNode;
            BytecodeManager.incBytecodes(1);
            final int n8 = openKey;
            BytecodeManager.incBytecodes(3);
            this.closeKey(n8);
            final int n9 = windowsRegCreateKeyEx1[0];
            BytecodeManager.incBytecodes(5);
            this.closeKey(n9);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private WindowsPreferences(final int n, final byte[] array) {
        try {
            final AbstractPreferences abstractPreferences = null;
            final String s = "";
            BytecodeManager.incBytecodes(4);
            super(abstractPreferences, s);
            this.isBackingStoreAvailable = true;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
            final int[] windowsRegCreateKeyEx1 = WindowsRegCreateKeyEx1(n, array);
            BytecodeManager.incBytecodes(1);
            final int n2 = windowsRegCreateKeyEx1[1];
            BytecodeManager.incBytecodes(4);
            if (n2 != 0) {
                BytecodeManager.incBytecodes(1);
                final PlatformLogger logger = logger();
                BytecodeManager.incBytecodes(3);
                final StringBuilder sb = new StringBuilder();
                final String str = "Could not open/create prefs root node ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb.append(str);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                final byte[] windowsAbsolutePath = this.windowsAbsolutePath();
                BytecodeManager.incBytecodes(1);
                final String byteArrayToString = byteArrayToString(windowsAbsolutePath);
                BytecodeManager.incBytecodes(1);
                final StringBuilder append2 = append.append(byteArrayToString);
                final String str2 = " at root 0x";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append3 = append2.append(str2);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                final int rootNativeHandle = this.rootNativeHandle();
                BytecodeManager.incBytecodes(1);
                final String hexString = Integer.toHexString(rootNativeHandle);
                BytecodeManager.incBytecodes(1);
                final StringBuilder append4 = append3.append(hexString);
                final String str3 = ". Windows RegCreateKeyEx(...) returned error code ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append5 = append4.append(str3);
                final int i = windowsRegCreateKeyEx1[1];
                BytecodeManager.incBytecodes(4);
                final StringBuilder append6 = append5.append(i);
                final String str4 = ".";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append7 = append6.append(str4);
                BytecodeManager.incBytecodes(1);
                final String string = append7.toString();
                BytecodeManager.incBytecodes(1);
                logger.warning(string);
                this.isBackingStoreAvailable = false;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
                return;
            }
            final int n3 = windowsRegCreateKeyEx1[2];
            final int n4 = 1;
            BytecodeManager.incBytecodes(6);
            boolean newNode;
            if (n3 == n4) {
                newNode = true;
                BytecodeManager.incBytecodes(2);
            }
            else {
                newNode = false;
                BytecodeManager.incBytecodes(1);
            }
            this.newNode = newNode;
            BytecodeManager.incBytecodes(1);
            final int n5 = windowsRegCreateKeyEx1[0];
            BytecodeManager.incBytecodes(5);
            this.closeKey(n5);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private byte[] windowsAbsolutePath() {
        try {
            BytecodeManager.incBytecodes(3);
            final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            BytecodeManager.incBytecodes(1);
            final ByteArrayOutputStream byteArrayOutputStream2 = byteArrayOutputStream;
            final byte[] windows_ROOT_PATH = WindowsPreferences.WINDOWS_ROOT_PATH;
            final int off = 0;
            final int len = WindowsPreferences.WINDOWS_ROOT_PATH.length - 1;
            BytecodeManager.incBytecodes(8);
            byteArrayOutputStream2.write(windows_ROOT_PATH, off, len);
            BytecodeManager.incBytecodes(4);
            final String absolutePath = this.absolutePath();
            final String s = "/";
            BytecodeManager.incBytecodes(2);
            final StringTokenizer stringTokenizer = new StringTokenizer(absolutePath, s);
            BytecodeManager.incBytecodes(1);
            while (true) {
                final StringTokenizer stringTokenizer2 = stringTokenizer;
                BytecodeManager.incBytecodes(2);
                final boolean hasMoreTokens = stringTokenizer2.hasMoreTokens();
                BytecodeManager.incBytecodes(1);
                if (!hasMoreTokens) {
                    break;
                }
                final ByteArrayOutputStream byteArrayOutputStream3 = byteArrayOutputStream;
                final int b = 92;
                BytecodeManager.incBytecodes(3);
                byteArrayOutputStream3.write(b);
                final StringTokenizer stringTokenizer3 = stringTokenizer;
                BytecodeManager.incBytecodes(2);
                final String nextToken = stringTokenizer3.nextToken();
                BytecodeManager.incBytecodes(1);
                final String s2 = nextToken;
                BytecodeManager.incBytecodes(2);
                final byte[] windowsName = toWindowsName(s2);
                BytecodeManager.incBytecodes(1);
                final ByteArrayOutputStream byteArrayOutputStream4 = byteArrayOutputStream;
                final byte[] b2 = windowsName;
                final int off2 = 0;
                final int len2 = windowsName.length - 1;
                BytecodeManager.incBytecodes(8);
                byteArrayOutputStream4.write(b2, off2, len2);
                BytecodeManager.incBytecodes(1);
            }
            final ByteArrayOutputStream byteArrayOutputStream5 = byteArrayOutputStream;
            final int b3 = 0;
            BytecodeManager.incBytecodes(3);
            byteArrayOutputStream5.write(b3);
            final ByteArrayOutputStream byteArrayOutputStream6 = byteArrayOutputStream;
            BytecodeManager.incBytecodes(2);
            final byte[] byteArray = byteArrayOutputStream6.toByteArray();
            BytecodeManager.incBytecodes(1);
            return byteArray;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private int openKey(final int n) {
        try {
            BytecodeManager.incBytecodes(4);
            final int openKey = this.openKey(n, n);
            BytecodeManager.incBytecodes(1);
            return openKey;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private int openKey(final int n, final int n2) {
        try {
            BytecodeManager.incBytecodes(3);
            final byte[] windowsAbsolutePath = this.windowsAbsolutePath();
            BytecodeManager.incBytecodes(3);
            final int openKey = this.openKey(windowsAbsolutePath, n, n2);
            BytecodeManager.incBytecodes(1);
            return openKey;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private int openKey(final byte[] array, final int n, final int n2) {
        try {
            final int length = array.length;
            final int n3 = 257;
            BytecodeManager.incBytecodes(4);
            if (length <= n3) {
                BytecodeManager.incBytecodes(2);
                final int rootNativeHandle = this.rootNativeHandle();
                BytecodeManager.incBytecodes(3);
                int[] array2 = WindowsRegOpenKey1(rootNativeHandle, array, n);
                BytecodeManager.incBytecodes(1);
                final int n4 = array2[1];
                final int n5 = 5;
                BytecodeManager.incBytecodes(5);
                if (n4 == n5) {
                    BytecodeManager.incBytecodes(3);
                    if (n2 != n) {
                        BytecodeManager.incBytecodes(2);
                        final int rootNativeHandle2 = this.rootNativeHandle();
                        BytecodeManager.incBytecodes(3);
                        array2 = WindowsRegOpenKey1(rootNativeHandle2, array, n2);
                        BytecodeManager.incBytecodes(1);
                    }
                }
                final int n6 = array2[1];
                BytecodeManager.incBytecodes(4);
                if (n6 != 0) {
                    BytecodeManager.incBytecodes(1);
                    final PlatformLogger logger = logger();
                    BytecodeManager.incBytecodes(3);
                    final StringBuilder sb = new StringBuilder();
                    final String str = "Could not open windows registry node ";
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append = sb.append(str);
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    final byte[] windowsAbsolutePath = this.windowsAbsolutePath();
                    BytecodeManager.incBytecodes(1);
                    final String byteArrayToString = byteArrayToString(windowsAbsolutePath);
                    BytecodeManager.incBytecodes(1);
                    final StringBuilder append2 = append.append(byteArrayToString);
                    final String str2 = " at root 0x";
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append3 = append2.append(str2);
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    final int rootNativeHandle3 = this.rootNativeHandle();
                    BytecodeManager.incBytecodes(1);
                    final String hexString = Integer.toHexString(rootNativeHandle3);
                    BytecodeManager.incBytecodes(1);
                    final StringBuilder append4 = append3.append(hexString);
                    final String str3 = ". Windows RegOpenKey(...) returned error code ";
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append5 = append4.append(str3);
                    final int i = array2[1];
                    BytecodeManager.incBytecodes(4);
                    final StringBuilder append6 = append5.append(i);
                    final String str4 = ".";
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append7 = append6.append(str4);
                    BytecodeManager.incBytecodes(1);
                    final String string = append7.toString();
                    BytecodeManager.incBytecodes(1);
                    logger.warning(string);
                    array2[0] = 0;
                    BytecodeManager.incBytecodes(4);
                    final int n7 = array2[1];
                    final int n8 = 5;
                    BytecodeManager.incBytecodes(5);
                    if (n7 == n8) {
                        BytecodeManager.incBytecodes(5);
                        final StringBuilder sb2 = new StringBuilder();
                        final String str5 = "Could not open windows registry node ";
                        BytecodeManager.incBytecodes(2);
                        final StringBuilder append8 = sb2.append(str5);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                        final byte[] windowsAbsolutePath2 = this.windowsAbsolutePath();
                        BytecodeManager.incBytecodes(1);
                        final String byteArrayToString2 = byteArrayToString(windowsAbsolutePath2);
                        BytecodeManager.incBytecodes(1);
                        final StringBuilder append9 = append8.append(byteArrayToString2);
                        final String str6 = " at root 0x";
                        BytecodeManager.incBytecodes(2);
                        final StringBuilder append10 = append9.append(str6);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                        final int rootNativeHandle4 = this.rootNativeHandle();
                        BytecodeManager.incBytecodes(1);
                        final String hexString2 = Integer.toHexString(rootNativeHandle4);
                        BytecodeManager.incBytecodes(1);
                        final StringBuilder append11 = append10.append(hexString2);
                        final String str7 = ": Access denied";
                        BytecodeManager.incBytecodes(2);
                        final StringBuilder append12 = append11.append(str7);
                        BytecodeManager.incBytecodes(1);
                        final String string2 = append12.toString();
                        BytecodeManager.incBytecodes(1);
                        final SecurityException ex = new SecurityException(string2);
                        BytecodeManager.incBytecodes(1);
                        throw ex;
                    }
                }
                final int n9 = array2[0];
                BytecodeManager.incBytecodes(4);
                return n9;
            }
            BytecodeManager.incBytecodes(3);
            final int rootNativeHandle5 = this.rootNativeHandle();
            BytecodeManager.incBytecodes(4);
            final int openKey = this.openKey(rootNativeHandle5, array, n, n2);
            BytecodeManager.incBytecodes(1);
            return openKey;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private int openKey(final int i, final byte[] array, final int n, final int n2) {
        try {
            final int length = array.length;
            final int n3 = 257;
            BytecodeManager.incBytecodes(4);
            if (length <= n3) {
                BytecodeManager.incBytecodes(4);
                int[] array2 = WindowsRegOpenKey1(i, array, n);
                BytecodeManager.incBytecodes(1);
                final int n4 = array2[1];
                final int n5 = 5;
                BytecodeManager.incBytecodes(5);
                if (n4 == n5) {
                    BytecodeManager.incBytecodes(3);
                    if (n2 != n) {
                        BytecodeManager.incBytecodes(4);
                        array2 = WindowsRegOpenKey1(i, array, n2);
                        BytecodeManager.incBytecodes(1);
                    }
                }
                final int n6 = array2[1];
                BytecodeManager.incBytecodes(4);
                if (n6 != 0) {
                    BytecodeManager.incBytecodes(1);
                    final PlatformLogger logger = logger();
                    BytecodeManager.incBytecodes(3);
                    final StringBuilder sb = new StringBuilder();
                    final String str = "Could not open windows registry node ";
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append = sb.append(str);
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    final byte[] windowsAbsolutePath = this.windowsAbsolutePath();
                    BytecodeManager.incBytecodes(1);
                    final String byteArrayToString = byteArrayToString(windowsAbsolutePath);
                    BytecodeManager.incBytecodes(1);
                    final StringBuilder append2 = append.append(byteArrayToString);
                    final String str2 = " at root 0x";
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append3 = append2.append(str2);
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    final String hexString = Integer.toHexString(i);
                    BytecodeManager.incBytecodes(1);
                    final StringBuilder append4 = append3.append(hexString);
                    final String str3 = ". Windows RegOpenKey(...) returned error code ";
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append5 = append4.append(str3);
                    final int j = array2[1];
                    BytecodeManager.incBytecodes(4);
                    final StringBuilder append6 = append5.append(j);
                    final String str4 = ".";
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append7 = append6.append(str4);
                    BytecodeManager.incBytecodes(1);
                    final String string = append7.toString();
                    BytecodeManager.incBytecodes(1);
                    logger.warning(string);
                    array2[0] = 0;
                    BytecodeManager.incBytecodes(4);
                }
                final int n7 = array2[0];
                BytecodeManager.incBytecodes(4);
                return n7;
            }
            int n8 = -1;
            BytecodeManager.incBytecodes(2);
            int n9 = 256;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n10 = n9;
                BytecodeManager.incBytecodes(2);
                if (n10 <= 0) {
                    break;
                }
                final byte b = array[n9];
                final int n11 = 92;
                BytecodeManager.incBytecodes(5);
                if (b == n11) {
                    n8 = n9;
                    BytecodeManager.incBytecodes(2);
                    BytecodeManager.incBytecodes(1);
                    break;
                }
                --n9;
                BytecodeManager.incBytecodes(2);
            }
            final byte[] array3 = new byte[n8 + 1];
            BytecodeManager.incBytecodes(4);
            final int n12 = 0;
            final byte[] array4 = array3;
            final int n13 = 0;
            final int n14 = n8;
            BytecodeManager.incBytecodes(6);
            System.arraycopy(array, n12, array4, n13, n14);
            array3[n8] = 0;
            BytecodeManager.incBytecodes(4);
            final byte[] array5 = new byte[array.length - n8 - 1];
            BytecodeManager.incBytecodes(7);
            final int n15 = n8 + 1;
            final byte[] array6 = array5;
            final int n16 = 0;
            final int length2 = array5.length;
            BytecodeManager.incBytecodes(9);
            System.arraycopy(array, n15, array6, n16, length2);
            final byte[] array7 = array3;
            BytecodeManager.incBytecodes(6);
            final int openKey = this.openKey(i, array7, n, n2);
            BytecodeManager.incBytecodes(1);
            final int n17 = openKey;
            BytecodeManager.incBytecodes(2);
            if (n17 == 0) {
                final int n18 = 0;
                BytecodeManager.incBytecodes(2);
                return n18;
            }
            final int n19 = openKey;
            final byte[] array8 = array5;
            BytecodeManager.incBytecodes(6);
            final int openKey2 = this.openKey(n19, array8, n, n2);
            BytecodeManager.incBytecodes(1);
            final int n20 = openKey;
            BytecodeManager.incBytecodes(3);
            this.closeKey(n20);
            final int n21 = openKey2;
            BytecodeManager.incBytecodes(2);
            return n21;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void closeKey(final int n) {
        try {
            BytecodeManager.incBytecodes(2);
            final int windowsRegCloseKey = WindowsRegCloseKey(n);
            BytecodeManager.incBytecodes(1);
            final int n2 = windowsRegCloseKey;
            BytecodeManager.incBytecodes(2);
            if (n2 != 0) {
                BytecodeManager.incBytecodes(1);
                final PlatformLogger logger = logger();
                BytecodeManager.incBytecodes(3);
                final StringBuilder sb = new StringBuilder();
                final String str = "Could not close windows registry node ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb.append(str);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                final byte[] windowsAbsolutePath = this.windowsAbsolutePath();
                BytecodeManager.incBytecodes(1);
                final String byteArrayToString = byteArrayToString(windowsAbsolutePath);
                BytecodeManager.incBytecodes(1);
                final StringBuilder append2 = append.append(byteArrayToString);
                final String str2 = " at root 0x";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append3 = append2.append(str2);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                final int rootNativeHandle = this.rootNativeHandle();
                BytecodeManager.incBytecodes(1);
                final String hexString = Integer.toHexString(rootNativeHandle);
                BytecodeManager.incBytecodes(1);
                final StringBuilder append4 = append3.append(hexString);
                final String str3 = ". Windows RegCloseKey(...) returned error code ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append5 = append4.append(str3);
                final int i = windowsRegCloseKey;
                BytecodeManager.incBytecodes(2);
                final StringBuilder append6 = append5.append(i);
                final String str4 = ".";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append7 = append6.append(str4);
                BytecodeManager.incBytecodes(1);
                final String string = append7.toString();
                BytecodeManager.incBytecodes(1);
                logger.warning(string);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    protected void putSpi(final String s, final String s2) {
        try {
            final int n = 2;
            BytecodeManager.incBytecodes(3);
            final int openKey = this.openKey(n);
            BytecodeManager.incBytecodes(1);
            final int n2 = openKey;
            BytecodeManager.incBytecodes(2);
            if (n2 == 0) {
                this.isBackingStoreAvailable = false;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
                return;
            }
            final int n3 = openKey;
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
            final byte[] windowsName = toWindowsName(s);
            BytecodeManager.incBytecodes(2);
            final byte[] windowsValueString = toWindowsValueString(s2);
            BytecodeManager.incBytecodes(1);
            final int windowsRegSetValueEx1 = WindowsRegSetValueEx1(n3, windowsName, windowsValueString);
            BytecodeManager.incBytecodes(1);
            final int n4 = windowsRegSetValueEx1;
            BytecodeManager.incBytecodes(2);
            if (n4 != 0) {
                BytecodeManager.incBytecodes(1);
                final PlatformLogger logger = logger();
                BytecodeManager.incBytecodes(3);
                final StringBuilder sb = new StringBuilder();
                final String str = "Could not assign value to key ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb.append(str);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                final byte[] windowsName2 = toWindowsName(s);
                BytecodeManager.incBytecodes(1);
                final String byteArrayToString = byteArrayToString(windowsName2);
                BytecodeManager.incBytecodes(1);
                final StringBuilder append2 = append.append(byteArrayToString);
                final String str2 = " at Windows registry node ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append3 = append2.append(str2);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                final byte[] windowsAbsolutePath = this.windowsAbsolutePath();
                BytecodeManager.incBytecodes(1);
                final String byteArrayToString2 = byteArrayToString(windowsAbsolutePath);
                BytecodeManager.incBytecodes(1);
                final StringBuilder append4 = append3.append(byteArrayToString2);
                final String str3 = " at root 0x";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append5 = append4.append(str3);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                final int rootNativeHandle = this.rootNativeHandle();
                BytecodeManager.incBytecodes(1);
                final String hexString = Integer.toHexString(rootNativeHandle);
                BytecodeManager.incBytecodes(1);
                final StringBuilder append6 = append5.append(hexString);
                final String str4 = ". Windows RegSetValueEx(...) returned error code ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append7 = append6.append(str4);
                final int i = windowsRegSetValueEx1;
                BytecodeManager.incBytecodes(2);
                final StringBuilder append8 = append7.append(i);
                final String str5 = ".";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append9 = append8.append(str5);
                BytecodeManager.incBytecodes(1);
                final String string = append9.toString();
                BytecodeManager.incBytecodes(1);
                logger.warning(string);
                this.isBackingStoreAvailable = false;
                BytecodeManager.incBytecodes(3);
            }
            final int n5 = openKey;
            BytecodeManager.incBytecodes(3);
            this.closeKey(n5);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    protected String getSpi(final String s) {
        try {
            final int n = 1;
            BytecodeManager.incBytecodes(3);
            final int openKey = this.openKey(n);
            BytecodeManager.incBytecodes(1);
            final int n2 = openKey;
            BytecodeManager.incBytecodes(2);
            if (n2 == 0) {
                final String s2 = null;
                BytecodeManager.incBytecodes(2);
                return s2;
            }
            final int n3 = openKey;
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
            final byte[] windowsName = toWindowsName(s);
            BytecodeManager.incBytecodes(1);
            final byte[] windowsRegQueryValueEx = WindowsRegQueryValueEx(n3, windowsName);
            BytecodeManager.incBytecodes(1);
            final byte[] array = windowsRegQueryValueEx;
            BytecodeManager.incBytecodes(2);
            if (array == null) {
                final int n4 = openKey;
                BytecodeManager.incBytecodes(3);
                this.closeKey(n4);
                final String s3 = null;
                BytecodeManager.incBytecodes(2);
                return s3;
            }
            final int n5 = openKey;
            BytecodeManager.incBytecodes(3);
            this.closeKey(n5);
            final byte[] array2 = windowsRegQueryValueEx;
            BytecodeManager.incBytecodes(4);
            final String javaValueString = toJavaValueString(array2);
            BytecodeManager.incBytecodes(1);
            return javaValueString;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    protected void removeSpi(final String s) {
        try {
            final int n = 2;
            BytecodeManager.incBytecodes(3);
            final int openKey = this.openKey(n);
            BytecodeManager.incBytecodes(1);
            final int n2 = openKey;
            BytecodeManager.incBytecodes(2);
            if (n2 == 0) {
                BytecodeManager.incBytecodes(1);
                return;
            }
            final int n3 = openKey;
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
            final byte[] windowsName = toWindowsName(s);
            BytecodeManager.incBytecodes(1);
            final int windowsRegDeleteValue = WindowsRegDeleteValue(n3, windowsName);
            BytecodeManager.incBytecodes(1);
            final int n4 = windowsRegDeleteValue;
            BytecodeManager.incBytecodes(2);
            if (n4 != 0) {
                final int n5 = windowsRegDeleteValue;
                final int n6 = 2;
                BytecodeManager.incBytecodes(3);
                if (n5 != n6) {
                    BytecodeManager.incBytecodes(1);
                    final PlatformLogger logger = logger();
                    BytecodeManager.incBytecodes(3);
                    final StringBuilder sb = new StringBuilder();
                    final String str = "Could not delete windows registry value ";
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append = sb.append(str);
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    final byte[] windowsAbsolutePath = this.windowsAbsolutePath();
                    BytecodeManager.incBytecodes(1);
                    final String byteArrayToString = byteArrayToString(windowsAbsolutePath);
                    BytecodeManager.incBytecodes(1);
                    final StringBuilder append2 = append.append(byteArrayToString);
                    final String str2 = "\\";
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append3 = append2.append(str2);
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    final byte[] windowsName2 = toWindowsName(s);
                    BytecodeManager.incBytecodes(1);
                    final StringBuilder append4 = append3.append(windowsName2);
                    final String str3 = " at root 0x";
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append5 = append4.append(str3);
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    final int rootNativeHandle = this.rootNativeHandle();
                    BytecodeManager.incBytecodes(1);
                    final String hexString = Integer.toHexString(rootNativeHandle);
                    BytecodeManager.incBytecodes(1);
                    final StringBuilder append6 = append5.append(hexString);
                    final String str4 = ". Windows RegDeleteValue(...) returned error code ";
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append7 = append6.append(str4);
                    final int i = windowsRegDeleteValue;
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append8 = append7.append(i);
                    final String str5 = ".";
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append9 = append8.append(str5);
                    BytecodeManager.incBytecodes(1);
                    final String string = append9.toString();
                    BytecodeManager.incBytecodes(1);
                    logger.warning(string);
                    this.isBackingStoreAvailable = false;
                    BytecodeManager.incBytecodes(3);
                }
            }
            final int n7 = openKey;
            BytecodeManager.incBytecodes(3);
            this.closeKey(n7);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    protected String[] keysSpi() throws BackingStoreException {
        try {
            final int n = 1;
            BytecodeManager.incBytecodes(3);
            final int openKey = this.openKey(n);
            BytecodeManager.incBytecodes(1);
            final int n2 = openKey;
            BytecodeManager.incBytecodes(2);
            if (n2 == 0) {
                BytecodeManager.incBytecodes(5);
                final StringBuilder sb = new StringBuilder();
                final String str = "Could not open windows registry node ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb.append(str);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                final byte[] windowsAbsolutePath = this.windowsAbsolutePath();
                BytecodeManager.incBytecodes(1);
                final String byteArrayToString = byteArrayToString(windowsAbsolutePath);
                BytecodeManager.incBytecodes(1);
                final StringBuilder append2 = append.append(byteArrayToString);
                final String str2 = " at root 0x";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append3 = append2.append(str2);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                final int rootNativeHandle = this.rootNativeHandle();
                BytecodeManager.incBytecodes(1);
                final String hexString = Integer.toHexString(rootNativeHandle);
                BytecodeManager.incBytecodes(1);
                final StringBuilder append4 = append3.append(hexString);
                final String str3 = ".";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append5 = append4.append(str3);
                BytecodeManager.incBytecodes(1);
                final String string = append5.toString();
                BytecodeManager.incBytecodes(1);
                final BackingStoreException ex = new BackingStoreException(string);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final int n3 = openKey;
            BytecodeManager.incBytecodes(2);
            final int[] windowsRegQueryInfoKey1 = WindowsRegQueryInfoKey1(n3);
            BytecodeManager.incBytecodes(1);
            final int n4 = windowsRegQueryInfoKey1[1];
            BytecodeManager.incBytecodes(4);
            if (n4 != 0) {
                BytecodeManager.incBytecodes(3);
                final StringBuilder sb2 = new StringBuilder();
                final String str4 = "Could not query windows registry node ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append6 = sb2.append(str4);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                final byte[] windowsAbsolutePath2 = this.windowsAbsolutePath();
                BytecodeManager.incBytecodes(1);
                final String byteArrayToString2 = byteArrayToString(windowsAbsolutePath2);
                BytecodeManager.incBytecodes(1);
                final StringBuilder append7 = append6.append(byteArrayToString2);
                final String str5 = " at root 0x";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append8 = append7.append(str5);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                final int rootNativeHandle2 = this.rootNativeHandle();
                BytecodeManager.incBytecodes(1);
                final String hexString2 = Integer.toHexString(rootNativeHandle2);
                BytecodeManager.incBytecodes(1);
                final StringBuilder append9 = append8.append(hexString2);
                final String str6 = ". Windows RegQueryInfoKeyEx(...) returned error code ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append10 = append9.append(str6);
                final int i = windowsRegQueryInfoKey1[1];
                BytecodeManager.incBytecodes(4);
                final StringBuilder append11 = append10.append(i);
                final String str7 = ".";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append12 = append11.append(str7);
                BytecodeManager.incBytecodes(1);
                final String string2 = append12.toString();
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                final PlatformLogger logger = logger();
                final String msg = string2;
                BytecodeManager.incBytecodes(2);
                logger.warning(msg);
                final String s = string2;
                BytecodeManager.incBytecodes(4);
                final BackingStoreException ex2 = new BackingStoreException(s);
                BytecodeManager.incBytecodes(1);
                throw ex2;
            }
            final int n5 = windowsRegQueryInfoKey1[4];
            BytecodeManager.incBytecodes(4);
            final int n6 = windowsRegQueryInfoKey1[2];
            BytecodeManager.incBytecodes(4);
            final int n7 = n6;
            BytecodeManager.incBytecodes(2);
            if (n7 == 0) {
                final int n8 = openKey;
                BytecodeManager.incBytecodes(3);
                this.closeKey(n8);
                final String[] array = new String[0];
                BytecodeManager.incBytecodes(2);
                return array;
            }
            final String[] array2 = new String[n6];
            BytecodeManager.incBytecodes(2);
            int n9 = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n10 = n9;
                final int n11 = n6;
                BytecodeManager.incBytecodes(3);
                if (n10 >= n11) {
                    final int n12 = openKey;
                    BytecodeManager.incBytecodes(3);
                    this.closeKey(n12);
                    final String[] array3 = array2;
                    BytecodeManager.incBytecodes(2);
                    return array3;
                }
                final int n13 = openKey;
                final int n14 = n9;
                final int n15 = n5 + 1;
                BytecodeManager.incBytecodes(6);
                final byte[] windowsRegEnumValue1 = WindowsRegEnumValue1(n13, n14, n15);
                BytecodeManager.incBytecodes(1);
                final byte[] array4 = windowsRegEnumValue1;
                BytecodeManager.incBytecodes(2);
                if (array4 == null) {
                    BytecodeManager.incBytecodes(3);
                    final StringBuilder sb3 = new StringBuilder();
                    final String str8 = "Could not enumerate value #";
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append13 = sb3.append(str8);
                    final int j = n9;
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append14 = append13.append(j);
                    final String str9 = "  of windows node ";
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append15 = append14.append(str9);
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    final byte[] windowsAbsolutePath3 = this.windowsAbsolutePath();
                    BytecodeManager.incBytecodes(1);
                    final String byteArrayToString3 = byteArrayToString(windowsAbsolutePath3);
                    BytecodeManager.incBytecodes(1);
                    final StringBuilder append16 = append15.append(byteArrayToString3);
                    final String str10 = " at root 0x";
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append17 = append16.append(str10);
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    final int rootNativeHandle3 = this.rootNativeHandle();
                    BytecodeManager.incBytecodes(1);
                    final String hexString3 = Integer.toHexString(rootNativeHandle3);
                    BytecodeManager.incBytecodes(1);
                    final StringBuilder append18 = append17.append(hexString3);
                    final String str11 = ".";
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append19 = append18.append(str11);
                    BytecodeManager.incBytecodes(1);
                    final String string3 = append19.toString();
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    final PlatformLogger logger2 = logger();
                    final String msg2 = string3;
                    BytecodeManager.incBytecodes(2);
                    logger2.warning(msg2);
                    final String s2 = string3;
                    BytecodeManager.incBytecodes(4);
                    final BackingStoreException ex3 = new BackingStoreException(s2);
                    BytecodeManager.incBytecodes(1);
                    throw ex3;
                }
                final String[] array5 = array2;
                final int n16 = n9;
                final byte[] array6 = windowsRegEnumValue1;
                BytecodeManager.incBytecodes(4);
                array5[n16] = toJavaName(array6);
                BytecodeManager.incBytecodes(1);
                ++n9;
                BytecodeManager.incBytecodes(2);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    protected String[] childrenNamesSpi() throws BackingStoreException {
        try {
            final int n = 9;
            BytecodeManager.incBytecodes(3);
            final int openKey = this.openKey(n);
            BytecodeManager.incBytecodes(1);
            final int n2 = openKey;
            BytecodeManager.incBytecodes(2);
            if (n2 == 0) {
                BytecodeManager.incBytecodes(5);
                final StringBuilder sb = new StringBuilder();
                final String str = "Could not open windows registry node ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb.append(str);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                final byte[] windowsAbsolutePath = this.windowsAbsolutePath();
                BytecodeManager.incBytecodes(1);
                final String byteArrayToString = byteArrayToString(windowsAbsolutePath);
                BytecodeManager.incBytecodes(1);
                final StringBuilder append2 = append.append(byteArrayToString);
                final String str2 = " at root 0x";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append3 = append2.append(str2);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                final int rootNativeHandle = this.rootNativeHandle();
                BytecodeManager.incBytecodes(1);
                final String hexString = Integer.toHexString(rootNativeHandle);
                BytecodeManager.incBytecodes(1);
                final StringBuilder append4 = append3.append(hexString);
                final String str3 = ".";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append5 = append4.append(str3);
                BytecodeManager.incBytecodes(1);
                final String string = append5.toString();
                BytecodeManager.incBytecodes(1);
                final BackingStoreException ex = new BackingStoreException(string);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final int n3 = openKey;
            BytecodeManager.incBytecodes(2);
            final int[] windowsRegQueryInfoKey1 = WindowsRegQueryInfoKey1(n3);
            BytecodeManager.incBytecodes(1);
            final int n4 = windowsRegQueryInfoKey1[1];
            BytecodeManager.incBytecodes(4);
            if (n4 != 0) {
                BytecodeManager.incBytecodes(3);
                final StringBuilder sb2 = new StringBuilder();
                final String str4 = "Could not query windows registry node ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append6 = sb2.append(str4);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                final byte[] windowsAbsolutePath2 = this.windowsAbsolutePath();
                BytecodeManager.incBytecodes(1);
                final String byteArrayToString2 = byteArrayToString(windowsAbsolutePath2);
                BytecodeManager.incBytecodes(1);
                final StringBuilder append7 = append6.append(byteArrayToString2);
                final String str5 = " at root 0x";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append8 = append7.append(str5);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                final int rootNativeHandle2 = this.rootNativeHandle();
                BytecodeManager.incBytecodes(1);
                final String hexString2 = Integer.toHexString(rootNativeHandle2);
                BytecodeManager.incBytecodes(1);
                final StringBuilder append9 = append8.append(hexString2);
                final String str6 = ". Windows RegQueryInfoKeyEx(...) returned error code ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append10 = append9.append(str6);
                final int i = windowsRegQueryInfoKey1[1];
                BytecodeManager.incBytecodes(4);
                final StringBuilder append11 = append10.append(i);
                final String str7 = ".";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append12 = append11.append(str7);
                BytecodeManager.incBytecodes(1);
                final String string2 = append12.toString();
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                final PlatformLogger logger = logger();
                final String msg = string2;
                BytecodeManager.incBytecodes(2);
                logger.warning(msg);
                final String s = string2;
                BytecodeManager.incBytecodes(4);
                final BackingStoreException ex2 = new BackingStoreException(s);
                BytecodeManager.incBytecodes(1);
                throw ex2;
            }
            final int n5 = windowsRegQueryInfoKey1[3];
            BytecodeManager.incBytecodes(4);
            final int n6 = windowsRegQueryInfoKey1[0];
            BytecodeManager.incBytecodes(4);
            final int n7 = n6;
            BytecodeManager.incBytecodes(2);
            if (n7 == 0) {
                final int n8 = openKey;
                BytecodeManager.incBytecodes(3);
                this.closeKey(n8);
                final String[] array = new String[0];
                BytecodeManager.incBytecodes(2);
                return array;
            }
            final String[] array2 = new String[n6];
            BytecodeManager.incBytecodes(2);
            final String[] array3 = new String[n6];
            BytecodeManager.incBytecodes(2);
            int n9 = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n10 = n9;
                final int n11 = n6;
                BytecodeManager.incBytecodes(3);
                if (n10 >= n11) {
                    final int n12 = openKey;
                    BytecodeManager.incBytecodes(3);
                    this.closeKey(n12);
                    final String[] array4 = array3;
                    BytecodeManager.incBytecodes(2);
                    return array4;
                }
                final int n13 = openKey;
                final int n14 = n9;
                final int n15 = n5 + 1;
                BytecodeManager.incBytecodes(6);
                final byte[] windowsRegEnumKeyEx1 = WindowsRegEnumKeyEx1(n13, n14, n15);
                BytecodeManager.incBytecodes(1);
                final byte[] array5 = windowsRegEnumKeyEx1;
                BytecodeManager.incBytecodes(2);
                if (array5 == null) {
                    BytecodeManager.incBytecodes(3);
                    final StringBuilder sb3 = new StringBuilder();
                    final String str8 = "Could not enumerate key #";
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append13 = sb3.append(str8);
                    final int j = n9;
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append14 = append13.append(j);
                    final String str9 = "  of windows node ";
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append15 = append14.append(str9);
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    final byte[] windowsAbsolutePath3 = this.windowsAbsolutePath();
                    BytecodeManager.incBytecodes(1);
                    final String byteArrayToString3 = byteArrayToString(windowsAbsolutePath3);
                    BytecodeManager.incBytecodes(1);
                    final StringBuilder append16 = append15.append(byteArrayToString3);
                    final String str10 = " at root 0x";
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append17 = append16.append(str10);
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    final int rootNativeHandle3 = this.rootNativeHandle();
                    BytecodeManager.incBytecodes(1);
                    final String hexString3 = Integer.toHexString(rootNativeHandle3);
                    BytecodeManager.incBytecodes(1);
                    final StringBuilder append18 = append17.append(hexString3);
                    final String str11 = ". ";
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append19 = append18.append(str11);
                    BytecodeManager.incBytecodes(1);
                    final String string3 = append19.toString();
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    final PlatformLogger logger2 = logger();
                    final String msg2 = string3;
                    BytecodeManager.incBytecodes(2);
                    logger2.warning(msg2);
                    final String s2 = string3;
                    BytecodeManager.incBytecodes(4);
                    final BackingStoreException ex3 = new BackingStoreException(s2);
                    BytecodeManager.incBytecodes(1);
                    throw ex3;
                }
                final byte[] array6 = windowsRegEnumKeyEx1;
                BytecodeManager.incBytecodes(2);
                final String javaName = toJavaName(array6);
                BytecodeManager.incBytecodes(1);
                array3[n9] = javaName;
                BytecodeManager.incBytecodes(4);
                ++n9;
                BytecodeManager.incBytecodes(2);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void flush() throws BackingStoreException {
        try {
            BytecodeManager.incBytecodes(2);
            final boolean removed = this.isRemoved();
            BytecodeManager.incBytecodes(1);
            if (removed) {
                final AbstractPreferences parent = this.parent;
                BytecodeManager.incBytecodes(3);
                parent.flush();
                BytecodeManager.incBytecodes(1);
                return;
            }
            final boolean isBackingStoreAvailable = this.isBackingStoreAvailable;
            BytecodeManager.incBytecodes(3);
            if (!isBackingStoreAvailable) {
                final String s = "flush(): Backing store not available.";
                BytecodeManager.incBytecodes(4);
                final BackingStoreException ex = new BackingStoreException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final int n = 131097;
            BytecodeManager.incBytecodes(3);
            final int openKey = this.openKey(n);
            BytecodeManager.incBytecodes(1);
            final int n2 = openKey;
            BytecodeManager.incBytecodes(2);
            if (n2 == 0) {
                BytecodeManager.incBytecodes(5);
                final StringBuilder sb = new StringBuilder();
                final String str = "Could not open windows registry node ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb.append(str);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                final byte[] windowsAbsolutePath = this.windowsAbsolutePath();
                BytecodeManager.incBytecodes(1);
                final String byteArrayToString = byteArrayToString(windowsAbsolutePath);
                BytecodeManager.incBytecodes(1);
                final StringBuilder append2 = append.append(byteArrayToString);
                final String str2 = " at root 0x";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append3 = append2.append(str2);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                final int rootNativeHandle = this.rootNativeHandle();
                BytecodeManager.incBytecodes(1);
                final String hexString = Integer.toHexString(rootNativeHandle);
                BytecodeManager.incBytecodes(1);
                final StringBuilder append4 = append3.append(hexString);
                final String str3 = ".";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append5 = append4.append(str3);
                BytecodeManager.incBytecodes(1);
                final String string = append5.toString();
                BytecodeManager.incBytecodes(1);
                final BackingStoreException ex2 = new BackingStoreException(string);
                BytecodeManager.incBytecodes(1);
                throw ex2;
            }
            final int n3 = openKey;
            BytecodeManager.incBytecodes(2);
            final int windowsRegFlushKey1 = WindowsRegFlushKey1(n3);
            BytecodeManager.incBytecodes(1);
            final int n4 = windowsRegFlushKey1;
            BytecodeManager.incBytecodes(2);
            if (n4 != 0) {
                BytecodeManager.incBytecodes(3);
                final StringBuilder sb2 = new StringBuilder();
                final String str4 = "Could not flush windows registry node ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append6 = sb2.append(str4);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                final byte[] windowsAbsolutePath2 = this.windowsAbsolutePath();
                BytecodeManager.incBytecodes(1);
                final String byteArrayToString2 = byteArrayToString(windowsAbsolutePath2);
                BytecodeManager.incBytecodes(1);
                final StringBuilder append7 = append6.append(byteArrayToString2);
                final String str5 = " at root 0x";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append8 = append7.append(str5);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                final int rootNativeHandle2 = this.rootNativeHandle();
                BytecodeManager.incBytecodes(1);
                final String hexString2 = Integer.toHexString(rootNativeHandle2);
                BytecodeManager.incBytecodes(1);
                final StringBuilder append9 = append8.append(hexString2);
                final String str6 = ". Windows RegFlushKey(...) returned error code ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append10 = append9.append(str6);
                final int i = windowsRegFlushKey1;
                BytecodeManager.incBytecodes(2);
                final StringBuilder append11 = append10.append(i);
                final String str7 = ".";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append12 = append11.append(str7);
                BytecodeManager.incBytecodes(1);
                final String string2 = append12.toString();
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                final PlatformLogger logger = logger();
                final String msg = string2;
                BytecodeManager.incBytecodes(2);
                logger.warning(msg);
                final String s2 = string2;
                BytecodeManager.incBytecodes(4);
                final BackingStoreException ex3 = new BackingStoreException(s2);
                BytecodeManager.incBytecodes(1);
                throw ex3;
            }
            final int n5 = openKey;
            BytecodeManager.incBytecodes(3);
            this.closeKey(n5);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void sync() throws BackingStoreException {
        try {
            BytecodeManager.incBytecodes(2);
            final boolean removed = this.isRemoved();
            BytecodeManager.incBytecodes(1);
            if (removed) {
                final String s = "Node has been removed";
                BytecodeManager.incBytecodes(4);
                final IllegalStateException ex = new IllegalStateException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(2);
            this.flush();
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    protected AbstractPreferences childSpi(final String s) {
        try {
            BytecodeManager.incBytecodes(5);
            final WindowsPreferences windowsPreferences = new WindowsPreferences(this, s);
            BytecodeManager.incBytecodes(1);
            return windowsPreferences;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void removeNodeSpi() throws BackingStoreException {
        try {
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
            final WindowsPreferences windowsPreferences = (WindowsPreferences)this.parent();
            final int n = 65536;
            BytecodeManager.incBytecodes(3);
            final int openKey = windowsPreferences.openKey(n);
            BytecodeManager.incBytecodes(1);
            final int n2 = openKey;
            BytecodeManager.incBytecodes(2);
            if (n2 == 0) {
                BytecodeManager.incBytecodes(5);
                final StringBuilder sb = new StringBuilder();
                final String str = "Could not open parent windows registry node of ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb.append(str);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                final byte[] windowsAbsolutePath = this.windowsAbsolutePath();
                BytecodeManager.incBytecodes(1);
                final String byteArrayToString = byteArrayToString(windowsAbsolutePath);
                BytecodeManager.incBytecodes(1);
                final StringBuilder append2 = append.append(byteArrayToString);
                final String str2 = " at root 0x";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append3 = append2.append(str2);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                final int rootNativeHandle = this.rootNativeHandle();
                BytecodeManager.incBytecodes(1);
                final String hexString = Integer.toHexString(rootNativeHandle);
                BytecodeManager.incBytecodes(1);
                final StringBuilder append4 = append3.append(hexString);
                final String str3 = ".";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append5 = append4.append(str3);
                BytecodeManager.incBytecodes(1);
                final String string = append5.toString();
                BytecodeManager.incBytecodes(1);
                final BackingStoreException ex = new BackingStoreException(string);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final int n3 = openKey;
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
            final String name = this.name();
            BytecodeManager.incBytecodes(1);
            final byte[] windowsName = toWindowsName(name);
            BytecodeManager.incBytecodes(1);
            final int windowsRegDeleteKey = WindowsRegDeleteKey(n3, windowsName);
            BytecodeManager.incBytecodes(1);
            final int n4 = windowsRegDeleteKey;
            BytecodeManager.incBytecodes(2);
            if (n4 != 0) {
                BytecodeManager.incBytecodes(3);
                final StringBuilder sb2 = new StringBuilder();
                final String str4 = "Could not delete windows registry node ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append6 = sb2.append(str4);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                final byte[] windowsAbsolutePath2 = this.windowsAbsolutePath();
                BytecodeManager.incBytecodes(1);
                final String byteArrayToString2 = byteArrayToString(windowsAbsolutePath2);
                BytecodeManager.incBytecodes(1);
                final StringBuilder append7 = append6.append(byteArrayToString2);
                final String str5 = " at root 0x";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append8 = append7.append(str5);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                final int rootNativeHandle2 = this.rootNativeHandle();
                BytecodeManager.incBytecodes(1);
                final String hexString2 = Integer.toHexString(rootNativeHandle2);
                BytecodeManager.incBytecodes(1);
                final StringBuilder append9 = append8.append(hexString2);
                final String str6 = ". Windows RegDeleteKeyEx(...) returned error code ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append10 = append9.append(str6);
                final int i = windowsRegDeleteKey;
                BytecodeManager.incBytecodes(2);
                final StringBuilder append11 = append10.append(i);
                final String str7 = ".";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append12 = append11.append(str7);
                BytecodeManager.incBytecodes(1);
                final String string2 = append12.toString();
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                final PlatformLogger logger = logger();
                final String msg = string2;
                BytecodeManager.incBytecodes(2);
                logger.warning(msg);
                final String s = string2;
                BytecodeManager.incBytecodes(4);
                final BackingStoreException ex2 = new BackingStoreException(s);
                BytecodeManager.incBytecodes(1);
                throw ex2;
            }
            final int n5 = openKey;
            BytecodeManager.incBytecodes(3);
            this.closeKey(n5);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static String toJavaName(final byte[] array) {
        try {
            BytecodeManager.incBytecodes(2);
            final String byteArrayToString = byteArrayToString(array);
            BytecodeManager.incBytecodes(1);
            final String s = byteArrayToString;
            BytecodeManager.incBytecodes(2);
            final int length = s.length();
            final int n = 1;
            BytecodeManager.incBytecodes(2);
            if (length > n) {
                final String s2 = byteArrayToString;
                final int beginIndex = 0;
                final int endIndex = 2;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
                final String substring = s2.substring(beginIndex, endIndex);
                final String anObject = "/!";
                BytecodeManager.incBytecodes(2);
                final boolean equals = substring.equals(anObject);
                BytecodeManager.incBytecodes(1);
                if (equals) {
                    final String s3 = byteArrayToString;
                    BytecodeManager.incBytecodes(2);
                    final String javaAlt64Name = toJavaAlt64Name(s3);
                    BytecodeManager.incBytecodes(1);
                    return javaAlt64Name;
                }
            }
            BytecodeManager.incBytecodes(3);
            final StringBuilder sb = new StringBuilder();
            BytecodeManager.incBytecodes(1);
            int n2 = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n3 = n2;
                final String s4 = byteArrayToString;
                BytecodeManager.incBytecodes(3);
                final int length2 = s4.length();
                BytecodeManager.incBytecodes(1);
                if (n3 >= length2) {
                    break;
                }
                final String s5 = byteArrayToString;
                final int index = n2;
                BytecodeManager.incBytecodes(3);
                char char1;
                final char c = char1 = s5.charAt(index);
                final int n4 = '/';
                BytecodeManager.incBytecodes(4);
                if (c == n4) {
                    char char2 = ' ';
                    BytecodeManager.incBytecodes(2);
                    final String s6 = byteArrayToString;
                    BytecodeManager.incBytecodes(2);
                    final int length3 = s6.length();
                    final int n5 = n2 + 1;
                    BytecodeManager.incBytecodes(4);
                    Label_0292: {
                        if (length3 > n5) {
                            final String s7 = byteArrayToString;
                            final int index2 = n2 + 1;
                            BytecodeManager.incBytecodes(4);
                            BytecodeManager.incBytecodes(1);
                            final char c2 = char2 = s7.charAt(index2);
                            final int n6 = 'A';
                            BytecodeManager.incBytecodes(4);
                            if (c2 >= n6) {
                                final char c3 = char2;
                                final int n7 = 'Z';
                                BytecodeManager.incBytecodes(3);
                                if (c3 <= n7) {
                                    char1 = char2;
                                    BytecodeManager.incBytecodes(2);
                                    ++n2;
                                    BytecodeManager.incBytecodes(2);
                                    break Label_0292;
                                }
                            }
                        }
                        final String s8 = byteArrayToString;
                        BytecodeManager.incBytecodes(2);
                        final int length4 = s8.length();
                        final int n8 = n2 + 1;
                        BytecodeManager.incBytecodes(4);
                        if (length4 > n8) {
                            final char c4 = char2;
                            final int n9 = '/';
                            BytecodeManager.incBytecodes(3);
                            if (c4 == n9) {
                                char1 = '\\';
                                BytecodeManager.incBytecodes(2);
                                ++n2;
                                BytecodeManager.incBytecodes(1);
                            }
                        }
                    }
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    final char c5 = char1;
                    final int n10 = '\\';
                    BytecodeManager.incBytecodes(3);
                    if (c5 == n10) {
                        char1 = '/';
                        BytecodeManager.incBytecodes(2);
                    }
                }
                final StringBuilder sb2 = sb;
                final char c6 = char1;
                BytecodeManager.incBytecodes(3);
                sb2.append(c6);
                BytecodeManager.incBytecodes(1);
                ++n2;
                BytecodeManager.incBytecodes(2);
            }
            final StringBuilder sb3 = sb;
            BytecodeManager.incBytecodes(2);
            final String string = sb3.toString();
            BytecodeManager.incBytecodes(1);
            return string;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static String toJavaAlt64Name(final String s) {
        try {
            final int beginIndex = 2;
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
            final String substring = s.substring(beginIndex);
            BytecodeManager.incBytecodes(1);
            final byte[] altBase64ToByteArray = Base64.altBase64ToByteArray(substring);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            final StringBuilder sb = new StringBuilder();
            BytecodeManager.incBytecodes(1);
            int n = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n2 = n;
                final int length = altBase64ToByteArray.length;
                BytecodeManager.incBytecodes(4);
                if (n2 >= length) {
                    break;
                }
                final int n3 = altBase64ToByteArray[n++] & 0xFF;
                BytecodeManager.incBytecodes(7);
                final int n4 = altBase64ToByteArray[n] & 0xFF;
                BytecodeManager.incBytecodes(6);
                final StringBuilder sb2 = sb;
                final char c = (char)((n3 << 8) + n4);
                BytecodeManager.incBytecodes(8);
                sb2.append(c);
                BytecodeManager.incBytecodes(1);
                ++n;
                BytecodeManager.incBytecodes(2);
            }
            final StringBuilder sb3 = sb;
            BytecodeManager.incBytecodes(2);
            final String string = sb3.toString();
            BytecodeManager.incBytecodes(1);
            return string;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static byte[] toWindowsName(final String s) {
        try {
            BytecodeManager.incBytecodes(3);
            final StringBuilder sb = new StringBuilder();
            BytecodeManager.incBytecodes(1);
            int n = 0;
            BytecodeManager.incBytecodes(2);
            Label_0237: {
                while (true) {
                    final int n2 = n;
                    BytecodeManager.incBytecodes(3);
                    final int length = s.length();
                    BytecodeManager.incBytecodes(1);
                    if (n2 >= length) {
                        break Label_0237;
                    }
                    final int index = n;
                    BytecodeManager.incBytecodes(3);
                    final char char1 = s.charAt(index);
                    BytecodeManager.incBytecodes(1);
                    final char c = char1;
                    final int n3 = ' ';
                    BytecodeManager.incBytecodes(3);
                    if (c < n3) {
                        break;
                    }
                    final char c2 = char1;
                    final int n4 = '\u007f';
                    BytecodeManager.incBytecodes(3);
                    if (c2 > n4) {
                        break;
                    }
                    final char c3 = char1;
                    final int n5 = '\\';
                    BytecodeManager.incBytecodes(3);
                    Label_0226: {
                        if (c3 == n5) {
                            final StringBuilder sb2 = sb;
                            final String str = "//";
                            BytecodeManager.incBytecodes(3);
                            sb2.append(str);
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            final char c4 = char1;
                            final int n6 = '/';
                            BytecodeManager.incBytecodes(3);
                            if (c4 == n6) {
                                final StringBuilder sb3 = sb;
                                final char c5 = '\\';
                                BytecodeManager.incBytecodes(3);
                                sb3.append(c5);
                                BytecodeManager.incBytecodes(2);
                            }
                            else {
                                final char c6 = char1;
                                final int n7 = 'A';
                                BytecodeManager.incBytecodes(3);
                                if (c6 >= n7) {
                                    final char c7 = char1;
                                    final int n8 = 'Z';
                                    BytecodeManager.incBytecodes(3);
                                    if (c7 <= n8) {
                                        final StringBuilder sb4 = sb;
                                        final char c8 = '/';
                                        BytecodeManager.incBytecodes(3);
                                        final StringBuilder append = sb4.append(c8);
                                        final char c9 = char1;
                                        BytecodeManager.incBytecodes(2);
                                        append.append(c9);
                                        BytecodeManager.incBytecodes(2);
                                        break Label_0226;
                                    }
                                }
                                final StringBuilder sb5 = sb;
                                final char c10 = char1;
                                BytecodeManager.incBytecodes(3);
                                sb5.append(c10);
                                BytecodeManager.incBytecodes(1);
                            }
                        }
                    }
                    ++n;
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(2);
                final byte[] windowsAlt64Name = toWindowsAlt64Name(s);
                BytecodeManager.incBytecodes(1);
                return windowsAlt64Name;
            }
            final StringBuilder sb6 = sb;
            BytecodeManager.incBytecodes(2);
            final String string = sb6.toString();
            BytecodeManager.incBytecodes(1);
            final byte[] stringToByteArray = stringToByteArray(string);
            BytecodeManager.incBytecodes(1);
            return stringToByteArray;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static byte[] toWindowsAlt64Name(final String s) {
        try {
            final int n = 2;
            BytecodeManager.incBytecodes(3);
            final byte[] array = new byte[n * s.length()];
            BytecodeManager.incBytecodes(2);
            int n2 = 0;
            BytecodeManager.incBytecodes(2);
            int n3 = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n4 = n3;
                BytecodeManager.incBytecodes(3);
                final int length = s.length();
                BytecodeManager.incBytecodes(1);
                if (n4 >= length) {
                    break;
                }
                final int index = n3;
                BytecodeManager.incBytecodes(3);
                final char char1 = s.charAt(index);
                BytecodeManager.incBytecodes(1);
                array[n2++] = (byte)(char1 >>> 8);
                BytecodeManager.incBytecodes(8);
                array[n2++] = (byte)char1;
                BytecodeManager.incBytecodes(6);
                ++n3;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(3);
            final StringBuilder sb = new StringBuilder();
            final String str = "/!";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append = sb.append(str);
            final byte[] array2 = array;
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
            final String byteArrayToAltBase64 = Base64.byteArrayToAltBase64(array2);
            BytecodeManager.incBytecodes(1);
            final StringBuilder append2 = append.append(byteArrayToAltBase64);
            BytecodeManager.incBytecodes(1);
            final String string = append2.toString();
            BytecodeManager.incBytecodes(1);
            final byte[] stringToByteArray = stringToByteArray(string);
            BytecodeManager.incBytecodes(1);
            return stringToByteArray;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static String toJavaValueString(final byte[] array) {
        try {
            BytecodeManager.incBytecodes(2);
            final String byteArrayToString = byteArrayToString(array);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            final StringBuilder sb = new StringBuilder();
            BytecodeManager.incBytecodes(1);
            int n = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n2 = n;
                final String s = byteArrayToString;
                BytecodeManager.incBytecodes(3);
                final int length = s.length();
                BytecodeManager.incBytecodes(1);
                if (n2 >= length) {
                    break;
                }
                final String s2 = byteArrayToString;
                final int index = n;
                BytecodeManager.incBytecodes(3);
                char char1;
                final char c = char1 = s2.charAt(index);
                final int n3 = '/';
                BytecodeManager.incBytecodes(4);
                if (c == n3) {
                    char char2 = ' ';
                    BytecodeManager.incBytecodes(2);
                    final String s3 = byteArrayToString;
                    BytecodeManager.incBytecodes(2);
                    final int length2 = s3.length();
                    final int n4 = n + 1;
                    BytecodeManager.incBytecodes(4);
                    Label_0360: {
                        if (length2 > n4) {
                            final String s4 = byteArrayToString;
                            final int index2 = n + 1;
                            BytecodeManager.incBytecodes(4);
                            BytecodeManager.incBytecodes(1);
                            final char c2 = char2 = s4.charAt(index2);
                            final int n5 = 'u';
                            BytecodeManager.incBytecodes(4);
                            if (c2 == n5) {
                                final String s5 = byteArrayToString;
                                BytecodeManager.incBytecodes(2);
                                final int length3 = s5.length();
                                final int n6 = n + 6;
                                BytecodeManager.incBytecodes(4);
                                if (length3 < n6) {
                                    BytecodeManager.incBytecodes(1);
                                    break;
                                }
                                final String s6 = byteArrayToString;
                                final int beginIndex = n + 2;
                                final int endIndex = n + 6;
                                BytecodeManager.incBytecodes(7);
                                BytecodeManager.incBytecodes(1);
                                final String substring = s6.substring(beginIndex, endIndex);
                                final int radix = 16;
                                BytecodeManager.incBytecodes(1);
                                BytecodeManager.incBytecodes(1);
                                char1 = (char)Integer.parseInt(substring, radix);
                                BytecodeManager.incBytecodes(2);
                                n += 5;
                                BytecodeManager.incBytecodes(2);
                                break Label_0360;
                            }
                        }
                        final String s7 = byteArrayToString;
                        BytecodeManager.incBytecodes(2);
                        final int length4 = s7.length();
                        final int n7 = n + 1;
                        BytecodeManager.incBytecodes(4);
                        if (length4 > n7) {
                            final String s8 = byteArrayToString;
                            final int index3 = n + 1;
                            BytecodeManager.incBytecodes(4);
                            BytecodeManager.incBytecodes(1);
                            final char char3 = s8.charAt(index3);
                            final int n8 = 'A';
                            BytecodeManager.incBytecodes(2);
                            if (char3 >= n8) {
                                final char c3 = char2;
                                final int n9 = 'Z';
                                BytecodeManager.incBytecodes(3);
                                if (c3 <= n9) {
                                    char1 = char2;
                                    BytecodeManager.incBytecodes(2);
                                    ++n;
                                    BytecodeManager.incBytecodes(2);
                                    break Label_0360;
                                }
                            }
                        }
                        final String s9 = byteArrayToString;
                        BytecodeManager.incBytecodes(2);
                        final int length5 = s9.length();
                        final int n10 = n + 1;
                        BytecodeManager.incBytecodes(4);
                        if (length5 > n10) {
                            final char c4 = char2;
                            final int n11 = '/';
                            BytecodeManager.incBytecodes(3);
                            if (c4 == n11) {
                                char1 = '\\';
                                BytecodeManager.incBytecodes(2);
                                ++n;
                                BytecodeManager.incBytecodes(1);
                            }
                        }
                    }
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    final char c5 = char1;
                    final int n12 = '\\';
                    BytecodeManager.incBytecodes(3);
                    if (c5 == n12) {
                        char1 = '/';
                        BytecodeManager.incBytecodes(2);
                    }
                }
                final StringBuilder sb2 = sb;
                final char c6 = char1;
                BytecodeManager.incBytecodes(3);
                sb2.append(c6);
                BytecodeManager.incBytecodes(1);
                ++n;
                BytecodeManager.incBytecodes(2);
            }
            final StringBuilder sb3 = sb;
            BytecodeManager.incBytecodes(2);
            final String string = sb3.toString();
            BytecodeManager.incBytecodes(1);
            return string;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static byte[] toWindowsValueString(final String s) {
        try {
            BytecodeManager.incBytecodes(3);
            final StringBuilder sb = new StringBuilder();
            BytecodeManager.incBytecodes(1);
            int n = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n2 = n;
                BytecodeManager.incBytecodes(3);
                final int length = s.length();
                BytecodeManager.incBytecodes(1);
                if (n2 >= length) {
                    break;
                }
                final int index = n;
                BytecodeManager.incBytecodes(3);
                final char char1 = s.charAt(index);
                BytecodeManager.incBytecodes(1);
                final char c = char1;
                final int n3 = ' ';
                BytecodeManager.incBytecodes(3);
                Label_0426: {
                    if (c >= n3) {
                        final char c2 = char1;
                        final int n4 = '\u007f';
                        BytecodeManager.incBytecodes(3);
                        if (c2 <= n4) {
                            final char c3 = char1;
                            final int n5 = '\\';
                            BytecodeManager.incBytecodes(3);
                            if (c3 == n5) {
                                final StringBuilder sb2 = sb;
                                final String str = "//";
                                BytecodeManager.incBytecodes(3);
                                sb2.append(str);
                                BytecodeManager.incBytecodes(2);
                                break Label_0426;
                            }
                            final char c4 = char1;
                            final int n6 = '/';
                            BytecodeManager.incBytecodes(3);
                            if (c4 == n6) {
                                final StringBuilder sb3 = sb;
                                final char c5 = '\\';
                                BytecodeManager.incBytecodes(3);
                                sb3.append(c5);
                                BytecodeManager.incBytecodes(2);
                                break Label_0426;
                            }
                            final char c6 = char1;
                            final int n7 = 'A';
                            BytecodeManager.incBytecodes(3);
                            if (c6 >= n7) {
                                final char c7 = char1;
                                final int n8 = 'Z';
                                BytecodeManager.incBytecodes(3);
                                if (c7 <= n8) {
                                    final StringBuilder sb4 = sb;
                                    final char c8 = '/';
                                    BytecodeManager.incBytecodes(3);
                                    final StringBuilder append = sb4.append(c8);
                                    final char c9 = char1;
                                    BytecodeManager.incBytecodes(2);
                                    append.append(c9);
                                    BytecodeManager.incBytecodes(2);
                                    break Label_0426;
                                }
                            }
                            final StringBuilder sb5 = sb;
                            final char c10 = char1;
                            BytecodeManager.incBytecodes(3);
                            sb5.append(c10);
                            BytecodeManager.incBytecodes(1);
                            break Label_0426;
                        }
                    }
                    final StringBuilder sb6 = sb;
                    final String str2 = "/u";
                    BytecodeManager.incBytecodes(3);
                    sb6.append(str2);
                    BytecodeManager.incBytecodes(1);
                    final int index2 = n;
                    BytecodeManager.incBytecodes(3);
                    final char char2 = s.charAt(index2);
                    BytecodeManager.incBytecodes(1);
                    final String hexString = Integer.toHexString(char2);
                    BytecodeManager.incBytecodes(1);
                    final String str3 = hexString;
                    BytecodeManager.incBytecodes(4);
                    final StringBuilder sb7 = new StringBuilder(str3);
                    BytecodeManager.incBytecodes(1);
                    final StringBuilder sb8 = sb7;
                    BytecodeManager.incBytecodes(2);
                    sb8.reverse();
                    BytecodeManager.incBytecodes(1);
                    final int n9 = 4;
                    final StringBuilder sb9 = sb7;
                    BytecodeManager.incBytecodes(3);
                    final int n10 = n9 - sb9.length();
                    BytecodeManager.incBytecodes(2);
                    int n11 = 0;
                    BytecodeManager.incBytecodes(2);
                    while (true) {
                        final int n12 = n11;
                        final int n13 = n10;
                        BytecodeManager.incBytecodes(3);
                        if (n12 >= n13) {
                            break;
                        }
                        final StringBuilder sb10 = sb7;
                        final char c11 = '0';
                        BytecodeManager.incBytecodes(3);
                        sb10.append(c11);
                        BytecodeManager.incBytecodes(1);
                        ++n11;
                        BytecodeManager.incBytecodes(2);
                    }
                    int n14 = 0;
                    BytecodeManager.incBytecodes(2);
                    while (true) {
                        final int n15 = n14;
                        final int n16 = 4;
                        BytecodeManager.incBytecodes(3);
                        if (n15 >= n16) {
                            break;
                        }
                        final StringBuilder sb11 = sb;
                        final StringBuilder sb12 = sb7;
                        final int n17 = 3 - n14;
                        BytecodeManager.incBytecodes(6);
                        final char char3 = sb12.charAt(n17);
                        BytecodeManager.incBytecodes(1);
                        sb11.append(char3);
                        BytecodeManager.incBytecodes(1);
                        ++n14;
                        BytecodeManager.incBytecodes(2);
                    }
                    BytecodeManager.incBytecodes(1);
                }
                ++n;
                BytecodeManager.incBytecodes(2);
            }
            final StringBuilder sb13 = sb;
            BytecodeManager.incBytecodes(2);
            final String string = sb13.toString();
            BytecodeManager.incBytecodes(1);
            final byte[] stringToByteArray = stringToByteArray(string);
            BytecodeManager.incBytecodes(1);
            return stringToByteArray;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private int rootNativeHandle() {
        try {
            BytecodeManager.incBytecodes(2);
            final boolean userNode = this.isUserNode();
            BytecodeManager.incBytecodes(1);
            int n;
            if (userNode) {
                n = -2147483647;
                BytecodeManager.incBytecodes(2);
            }
            else {
                n = -2147483646;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return n;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static byte[] stringToByteArray(final String s) {
        try {
            BytecodeManager.incBytecodes(2);
            final byte[] array = new byte[s.length() + 1];
            BytecodeManager.incBytecodes(3);
            int n = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n2 = n;
                BytecodeManager.incBytecodes(3);
                final int length = s.length();
                BytecodeManager.incBytecodes(1);
                if (n2 >= length) {
                    break;
                }
                final byte[] array2 = array;
                final int n3 = n;
                final int index = n;
                BytecodeManager.incBytecodes(5);
                array2[n3] = (byte)s.charAt(index);
                BytecodeManager.incBytecodes(2);
                ++n;
                BytecodeManager.incBytecodes(2);
            }
            final byte[] array3 = array;
            BytecodeManager.incBytecodes(3);
            array3[s.length()] = 0;
            BytecodeManager.incBytecodes(2);
            final byte[] array4 = array;
            BytecodeManager.incBytecodes(2);
            return array4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static String byteArrayToString(final byte[] array) {
        try {
            BytecodeManager.incBytecodes(3);
            final StringBuilder sb = new StringBuilder();
            BytecodeManager.incBytecodes(1);
            int n = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n2 = n;
                final int n3 = array.length - 1;
                BytecodeManager.incBytecodes(6);
                if (n2 >= n3) {
                    break;
                }
                final StringBuilder sb2 = sb;
                final char c = (char)array[n];
                BytecodeManager.incBytecodes(6);
                sb2.append(c);
                BytecodeManager.incBytecodes(1);
                ++n;
                BytecodeManager.incBytecodes(2);
            }
            final StringBuilder sb3 = sb;
            BytecodeManager.incBytecodes(2);
            final String string = sb3.toString();
            BytecodeManager.incBytecodes(1);
            return string;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    protected void flushSpi() throws BackingStoreException {
        try {
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    protected void syncSpi() throws BackingStoreException {
        try {
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static synchronized PlatformLogger logger() {
        try {
            final PlatformLogger logger = WindowsPreferences.logger;
            BytecodeManager.incBytecodes(2);
            if (logger == null) {
                final String name = "java.util.prefs";
                BytecodeManager.incBytecodes(2);
                WindowsPreferences.logger = PlatformLogger.getLogger(name);
                BytecodeManager.incBytecodes(1);
            }
            final PlatformLogger logger2 = WindowsPreferences.logger;
            BytecodeManager.incBytecodes(2);
            return logger2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static {
        try {
            final String s = "Software\\JavaSoft\\Prefs";
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
            WINDOWS_ROOT_PATH = stringToByteArray(s);
            BytecodeManager.incBytecodes(1);
            final int n = -2147483647;
            final byte[] windows_ROOT_PATH = WindowsPreferences.WINDOWS_ROOT_PATH;
            BytecodeManager.incBytecodes(5);
            userRoot = new WindowsPreferences(n, windows_ROOT_PATH);
            BytecodeManager.incBytecodes(1);
            final int n2 = -2147483646;
            final byte[] windows_ROOT_PATH2 = WindowsPreferences.WINDOWS_ROOT_PATH;
            BytecodeManager.incBytecodes(5);
            systemRoot = new WindowsPreferences(n2, windows_ROOT_PATH2);
            BytecodeManager.incBytecodes(1);
            WindowsPreferences.INIT_SLEEP_TIME = 50;
            BytecodeManager.incBytecodes(2);
            WindowsPreferences.MAX_ATTEMPTS = 5;
            BytecodeManager.incBytecodes(3);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
