// 
// Decompiled by Procyon v0.5.36
// 

package java.util.zip;

import aic2021.engine.BytecodeManager;

public class Deflater
{
    private final ZStreamRef zsRef;
    private byte[] buf;
    private int off;
    private int len;
    private int level;
    private int strategy;
    private boolean setParams;
    private boolean finish;
    private boolean finished;
    private long bytesRead;
    private long bytesWritten;
    public static final int DEFLATED = 8;
    public static final int NO_COMPRESSION = 0;
    public static final int BEST_SPEED = 1;
    public static final int BEST_COMPRESSION = 9;
    public static final int DEFAULT_COMPRESSION = -1;
    public static final int FILTERED = 1;
    public static final int HUFFMAN_ONLY = 2;
    public static final int DEFAULT_STRATEGY = 0;
    public static final int NO_FLUSH = 0;
    public static final int SYNC_FLUSH = 2;
    public static final int FULL_FLUSH = 3;
    static final /* synthetic */ boolean $assertionsDisabled;
    
    public Deflater(final int level, final boolean b) {
        try {
            BytecodeManager.incBytecodes(2);
            this.buf = new byte[0];
            BytecodeManager.incBytecodes(3);
            this.level = level;
            BytecodeManager.incBytecodes(3);
            this.strategy = 0;
            BytecodeManager.incBytecodes(3);
            final int n = 0;
            BytecodeManager.incBytecodes(7);
            final long init = init(level, n, b);
            BytecodeManager.incBytecodes(1);
            this.zsRef = new ZStreamRef(init);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Deflater(final int level) {
        try {
            final boolean nowrap = false;
            BytecodeManager.incBytecodes(4);
            this(level, nowrap);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Deflater() {
        try {
            final int level = -1;
            final boolean nowrap = false;
            BytecodeManager.incBytecodes(4);
            this(level, nowrap);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void setInput(final byte[] p0, final int p1, final int p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             2
        //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     6: ifnonnull       27
        //     9: new             Ljava/lang/NullPointerException;
        //    12: dup            
        //    13: ldc             3
        //    15: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    18: invokespecial   java/lang/NullPointerException.<init>:()V
        //    21: ldc             1
        //    23: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    26: athrow         
        //    27: iload_2        
        //    28: ldc             2
        //    30: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    33: iflt            58
        //    36: iload_3        
        //    37: ldc             2
        //    39: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    42: iflt            58
        //    45: iload_2        
        //    46: aload_1        
        //    47: arraylength    
        //    48: iload_3        
        //    49: isub           
        //    50: ldc             6
        //    52: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    55: if_icmple       76
        //    58: new             Ljava/lang/ArrayIndexOutOfBoundsException;
        //    61: dup            
        //    62: ldc             3
        //    64: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    67: invokespecial   java/lang/ArrayIndexOutOfBoundsException.<init>:()V
        //    70: ldc             1
        //    72: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    75: athrow         
        //    76: aload_0        
        //    77: getfield        java/util/zip/Deflater.zsRef:Ljava/util/zip/ZStreamRef;
        //    80: dup            
        //    81: astore          4
        //    83: pop            
        //    84: ldc             5
        //    86: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    89: aload_0        
        //    90: aload_1        
        //    91: putfield        java/util/zip/Deflater.buf:[B
        //    94: ldc             3
        //    96: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    99: aload_0        
        //   100: iload_2        
        //   101: putfield        java/util/zip/Deflater.off:I
        //   104: ldc             3
        //   106: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   109: aload_0        
        //   110: iload_3        
        //   111: putfield        java/util/zip/Deflater.len:I
        //   114: ldc             3
        //   116: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   119: aload           4
        //   121: pop            
        //   122: ldc             2
        //   124: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   127: ldc             1
        //   129: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   132: goto            153
        //   135: astore          5
        //   137: aload           4
        //   139: pop            
        //   140: ldc             503
        //   142: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   145: aload           5
        //   147: ldc             2
        //   149: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   152: athrow         
        //   153: ldc             1
        //   155: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   158: return         
        //   159: athrow         
        //   160: athrow         
        //    StackMapTable: 00 07 1B 1E 11 FF 00 3A 00 05 07 00 02 07 00 5B 01 01 07 00 04 00 01 07 00 47 FA 00 11 FF 00 05 00 00 00 01 07 00 47 FF 00 00 00 00 00 01 07 00 4E
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  89     160    160    161    Ljava/lang/VirtualMachineError;
        //  89     127    135    153    Any
        //  135    145    135    153    Any
        //  0      159    159    160    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0153:
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
    
    public void setInput(final byte[] input) {
        try {
            final int off = 0;
            final int length = input.length;
            BytecodeManager.incBytecodes(6);
            this.setInput(input, off, length);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void setDictionary(final byte[] p0, final int p1, final int p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             2
        //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     6: ifnonnull       27
        //     9: new             Ljava/lang/NullPointerException;
        //    12: dup            
        //    13: ldc             3
        //    15: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    18: invokespecial   java/lang/NullPointerException.<init>:()V
        //    21: ldc             1
        //    23: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    26: athrow         
        //    27: iload_2        
        //    28: ldc             2
        //    30: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    33: iflt            58
        //    36: iload_3        
        //    37: ldc             2
        //    39: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    42: iflt            58
        //    45: iload_2        
        //    46: aload_1        
        //    47: arraylength    
        //    48: iload_3        
        //    49: isub           
        //    50: ldc             6
        //    52: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    55: if_icmple       76
        //    58: new             Ljava/lang/ArrayIndexOutOfBoundsException;
        //    61: dup            
        //    62: ldc             3
        //    64: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    67: invokespecial   java/lang/ArrayIndexOutOfBoundsException.<init>:()V
        //    70: ldc             1
        //    72: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    75: athrow         
        //    76: aload_0        
        //    77: getfield        java/util/zip/Deflater.zsRef:Ljava/util/zip/ZStreamRef;
        //    80: dup            
        //    81: astore          4
        //    83: pop            
        //    84: ldc             5
        //    86: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    89: aload_0        
        //    90: ldc             2
        //    92: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    95: invokespecial   java/util/zip/Deflater.ensureOpen:()V
        //    98: aload_0        
        //    99: getfield        java/util/zip/Deflater.zsRef:Ljava/util/zip/ZStreamRef;
        //   102: ldc             3
        //   104: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   107: invokevirtual   java/util/zip/ZStreamRef.address:()J
        //   110: aload_1        
        //   111: iload_2        
        //   112: iload_3        
        //   113: ldc             4
        //   115: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   118: invokestatic    java/util/zip/Deflater.setDictionary:(J[BII)V
        //   121: aload           4
        //   123: pop            
        //   124: ldc             2
        //   126: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   129: ldc             1
        //   131: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   134: goto            155
        //   137: astore          5
        //   139: aload           4
        //   141: pop            
        //   142: ldc             503
        //   144: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   147: aload           5
        //   149: ldc             2
        //   151: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   154: athrow         
        //   155: ldc             1
        //   157: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   160: return         
        //   161: athrow         
        //   162: athrow         
        //    StackMapTable: 00 07 1B 1E 11 FF 00 3C 00 05 07 00 02 07 00 5B 01 01 07 00 04 00 01 07 00 47 FA 00 11 FF 00 05 00 00 00 01 07 00 47 FF 00 00 00 00 00 01 07 00 4E
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  89     162    162    163    Ljava/lang/VirtualMachineError;
        //  89     129    137    155    Any
        //  137    147    137    155    Any
        //  0      161    161    162    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0155:
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
    
    public void setDictionary(final byte[] dictionary) {
        try {
            final int off = 0;
            final int length = dictionary.length;
            BytecodeManager.incBytecodes(6);
            this.setDictionary(dictionary, off, length);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void setStrategy(final int p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             2
        //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     6: tableswitch {
        //                0: 32
        //                1: 32
        //                2: 32
        //          default: 40
        //        }
        //    32: ldc             1
        //    34: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    37: goto            58
        //    40: new             Ljava/lang/IllegalArgumentException;
        //    43: dup            
        //    44: ldc             3
        //    46: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    49: invokespecial   java/lang/IllegalArgumentException.<init>:()V
        //    52: ldc             1
        //    54: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    57: athrow         
        //    58: aload_0        
        //    59: getfield        java/util/zip/Deflater.zsRef:Ljava/util/zip/ZStreamRef;
        //    62: dup            
        //    63: astore_2       
        //    64: pop            
        //    65: ldc             5
        //    67: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    70: aload_0        
        //    71: getfield        java/util/zip/Deflater.strategy:I
        //    74: iload_1        
        //    75: ldc             4
        //    77: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    80: if_icmpeq       103
        //    83: aload_0        
        //    84: iload_1        
        //    85: putfield        java/util/zip/Deflater.strategy:I
        //    88: ldc             3
        //    90: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    93: aload_0        
        //    94: iconst_1       
        //    95: putfield        java/util/zip/Deflater.setParams:Z
        //    98: ldc             3
        //   100: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   103: aload_2        
        //   104: pop            
        //   105: ldc             2
        //   107: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   110: ldc             1
        //   112: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   115: goto            133
        //   118: astore_3       
        //   119: aload_2        
        //   120: pop            
        //   121: ldc             503
        //   123: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   126: aload_3        
        //   127: ldc             2
        //   129: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   132: athrow         
        //   133: ldc             1
        //   135: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   138: return         
        //   139: athrow         
        //   140: athrow         
        //    StackMapTable: 00 08 20 07 11 FC 00 2C 07 00 04 4E 07 00 47 FA 00 0E FF 00 05 00 00 00 01 07 00 47 FF 00 00 00 00 00 01 07 00 4E
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  70     140    140    141    Ljava/lang/VirtualMachineError;
        //  70     110    118    133    Any
        //  118    126    118    133    Any
        //  0      139    139    140    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0103:
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
    
    public void setLevel(final int p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             2
        //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     6: iflt            20
        //     9: iload_1        
        //    10: bipush          9
        //    12: ldc             3
        //    14: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    17: if_icmple       50
        //    20: iload_1        
        //    21: iconst_m1      
        //    22: ldc             3
        //    24: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    27: if_icmpeq       50
        //    30: new             Ljava/lang/IllegalArgumentException;
        //    33: dup            
        //    34: ldc             "invalid compression level"
        //    36: ldc             4
        //    38: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    41: invokespecial   java/lang/IllegalArgumentException.<init>:(Ljava/lang/String;)V
        //    44: ldc             1
        //    46: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    49: athrow         
        //    50: aload_0        
        //    51: getfield        java/util/zip/Deflater.zsRef:Ljava/util/zip/ZStreamRef;
        //    54: dup            
        //    55: astore_2       
        //    56: pop            
        //    57: ldc             5
        //    59: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    62: aload_0        
        //    63: getfield        java/util/zip/Deflater.level:I
        //    66: iload_1        
        //    67: ldc             4
        //    69: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    72: if_icmpeq       95
        //    75: aload_0        
        //    76: iload_1        
        //    77: putfield        java/util/zip/Deflater.level:I
        //    80: ldc             3
        //    82: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    85: aload_0        
        //    86: iconst_1       
        //    87: putfield        java/util/zip/Deflater.setParams:Z
        //    90: ldc             3
        //    92: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    95: aload_2        
        //    96: pop            
        //    97: ldc             2
        //    99: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   102: ldc             1
        //   104: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   107: goto            125
        //   110: astore_3       
        //   111: aload_2        
        //   112: pop            
        //   113: ldc             503
        //   115: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   118: aload_3        
        //   119: ldc             2
        //   121: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   124: athrow         
        //   125: ldc             1
        //   127: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   130: return         
        //   131: athrow         
        //   132: athrow         
        //    StackMapTable: 00 07 14 1D FC 00 2C 07 00 04 4E 07 00 47 FA 00 0E FF 00 05 00 00 00 01 07 00 47 FF 00 00 00 00 00 01 07 00 4E
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  62     132    132    133    Ljava/lang/VirtualMachineError;
        //  62     102    110    125    Any
        //  110    118    110    125    Any
        //  0      131    131    132    Any
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
    
    public boolean needsInput() {
        try {
            final int len = this.len;
            BytecodeManager.incBytecodes(3);
            boolean b;
            if (len <= 0) {
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
    
    public void finish() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        java/util/zip/Deflater.zsRef:Ljava/util/zip/ZStreamRef;
        //     4: dup            
        //     5: astore_1       
        //     6: pop            
        //     7: ldc             5
        //     9: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    12: aload_0        
        //    13: iconst_1       
        //    14: putfield        java/util/zip/Deflater.finish:Z
        //    17: ldc             3
        //    19: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    22: aload_1        
        //    23: pop            
        //    24: ldc             2
        //    26: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    29: ldc             1
        //    31: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    34: goto            52
        //    37: astore_2       
        //    38: aload_1        
        //    39: pop            
        //    40: ldc             503
        //    42: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    45: aload_2        
        //    46: ldc             2
        //    48: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    51: athrow         
        //    52: ldc             1
        //    54: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    57: return         
        //    58: athrow         
        //    59: athrow         
        //    StackMapTable: 00 04 FF 00 25 00 02 07 00 02 07 00 04 00 01 07 00 47 FA 00 0E FF 00 05 00 00 00 01 07 00 47 FF 00 00 00 00 00 01 07 00 4E
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  12     59     59     60     Ljava/lang/VirtualMachineError;
        //  12     29     37     52     Any
        //  37     45     37     52     Any
        //  0      58     58     59     Any
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
    
    public boolean finished() {
        try {
            final ZStreamRef zsRef = this.zsRef;
            BytecodeManager.incBytecodes(5);
            try {
                final Deflater deflater = this;
                final boolean b = deflater.finished;
                final int n = 4;
                BytecodeManager.incBytecodes(n);
                final int n2 = 1;
                BytecodeManager.incBytecodes(n2);
                return b;
            }
            finally {
                BytecodeManager.incBytecodes(503);
                BytecodeManager.incBytecodes(2);
            }
        }
        finally {}
        try {
            final Deflater deflater = this;
            final boolean b = deflater.finished;
            final int n = 4;
            BytecodeManager.incBytecodes(n);
            final int n2 = 1;
            BytecodeManager.incBytecodes(n2);
            return b;
        }
        catch (VirtualMachineError virtualMachineError) {
            throw virtualMachineError;
        }
    }
    
    public int deflate(final byte[] output, final int off, final int len) {
        try {
            final int flush = 0;
            BytecodeManager.incBytecodes(6);
            final int deflate = this.deflate(output, off, len, flush);
            BytecodeManager.incBytecodes(1);
            return deflate;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public int deflate(final byte[] output) {
        try {
            final int off = 0;
            final int length = output.length;
            final int flush = 0;
            BytecodeManager.incBytecodes(7);
            final int deflate = this.deflate(output, off, length, flush);
            BytecodeManager.incBytecodes(1);
            return deflate;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public int deflate(final byte[] p0, final int p1, final int p2, final int p3) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             2
        //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     6: ifnonnull       27
        //     9: new             Ljava/lang/NullPointerException;
        //    12: dup            
        //    13: ldc             3
        //    15: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    18: invokespecial   java/lang/NullPointerException.<init>:()V
        //    21: ldc             1
        //    23: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    26: athrow         
        //    27: iload_2        
        //    28: ldc             2
        //    30: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    33: iflt            58
        //    36: iload_3        
        //    37: ldc             2
        //    39: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    42: iflt            58
        //    45: iload_2        
        //    46: aload_1        
        //    47: arraylength    
        //    48: iload_3        
        //    49: isub           
        //    50: ldc             6
        //    52: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    55: if_icmple       76
        //    58: new             Ljava/lang/ArrayIndexOutOfBoundsException;
        //    61: dup            
        //    62: ldc             3
        //    64: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    67: invokespecial   java/lang/ArrayIndexOutOfBoundsException.<init>:()V
        //    70: ldc             1
        //    72: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    75: athrow         
        //    76: aload_0        
        //    77: getfield        java/util/zip/Deflater.zsRef:Ljava/util/zip/ZStreamRef;
        //    80: dup            
        //    81: astore          5
        //    83: pop            
        //    84: ldc             5
        //    86: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    89: aload_0        
        //    90: ldc             2
        //    92: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    95: invokespecial   java/util/zip/Deflater.ensureOpen:()V
        //    98: iload           4
        //   100: ldc             2
        //   102: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   105: ifeq            130
        //   108: iload           4
        //   110: iconst_2       
        //   111: ldc             3
        //   113: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   116: if_icmpeq       130
        //   119: iload           4
        //   121: iconst_3       
        //   122: ldc             3
        //   124: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   127: if_icmpne       229
        //   130: aload_0        
        //   131: getfield        java/util/zip/Deflater.len:I
        //   134: istore          6
        //   136: ldc             3
        //   138: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   141: aload_0        
        //   142: aload_0        
        //   143: getfield        java/util/zip/Deflater.zsRef:Ljava/util/zip/ZStreamRef;
        //   146: ldc             4
        //   148: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   151: invokevirtual   java/util/zip/ZStreamRef.address:()J
        //   154: aload_1        
        //   155: iload_2        
        //   156: iload_3        
        //   157: iload           4
        //   159: ldc             5
        //   161: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   164: invokespecial   java/util/zip/Deflater.deflateBytes:(J[BIII)I
        //   167: istore          7
        //   169: ldc             1
        //   171: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   174: aload_0        
        //   175: dup            
        //   176: getfield        java/util/zip/Deflater.bytesWritten:J
        //   179: iload           7
        //   181: i2l            
        //   182: ladd           
        //   183: putfield        java/util/zip/Deflater.bytesWritten:J
        //   186: ldc             7
        //   188: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   191: aload_0        
        //   192: dup            
        //   193: getfield        java/util/zip/Deflater.bytesRead:J
        //   196: iload           6
        //   198: aload_0        
        //   199: getfield        java/util/zip/Deflater.len:I
        //   202: isub           
        //   203: i2l            
        //   204: ladd           
        //   205: putfield        java/util/zip/Deflater.bytesRead:J
        //   208: ldc             10
        //   210: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   213: iload           7
        //   215: aload           5
        //   217: pop            
        //   218: ldc             3
        //   220: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   223: ldc             1
        //   225: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   228: ireturn        
        //   229: new             Ljava/lang/IllegalArgumentException;
        //   232: dup            
        //   233: ldc             3
        //   235: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   238: invokespecial   java/lang/IllegalArgumentException.<init>:()V
        //   241: ldc             1
        //   243: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   246: athrow         
        //   247: astore          8
        //   249: aload           5
        //   251: pop            
        //   252: ldc             503
        //   254: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   257: aload           8
        //   259: ldc             2
        //   261: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   264: athrow         
        //   265: athrow         
        //   266: athrow         
        //    StackMapTable: 00 08 1B 1E 11 FC 00 35 07 00 04 FB 00 62 51 07 00 47 FF 00 11 00 00 00 01 07 00 47 FF 00 00 00 00 00 01 07 00 4E
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  89     266    266    267    Ljava/lang/VirtualMachineError;
        //  89     223    247    265    Any
        //  229    257    247    265    Any
        //  0      265    265    266    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0130:
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
    
    public int getAdler() {
        try {
            final ZStreamRef zsRef = this.zsRef;
            BytecodeManager.incBytecodes(5);
            try {
                final Deflater deflater = this;
                final int n = 2;
                BytecodeManager.incBytecodes(n);
                deflater.ensureOpen();
                final Deflater deflater2 = this;
                final ZStreamRef zStreamRef = deflater2.zsRef;
                final int n2 = 3;
                BytecodeManager.incBytecodes(n2);
                final long n3 = zStreamRef.address();
                final int n4 = 1;
                BytecodeManager.incBytecodes(n4);
                final int n5 = getAdler(n3);
                final int n6 = 2;
                BytecodeManager.incBytecodes(n6);
                final int n7 = 1;
                BytecodeManager.incBytecodes(n7);
                return n5;
            }
            finally {
                BytecodeManager.incBytecodes(503);
                BytecodeManager.incBytecodes(2);
            }
        }
        finally {}
        try {
            final Deflater deflater = this;
            final int n = 2;
            BytecodeManager.incBytecodes(n);
            deflater.ensureOpen();
            final Deflater deflater2 = this;
            final ZStreamRef zStreamRef = deflater2.zsRef;
            final int n2 = 3;
            BytecodeManager.incBytecodes(n2);
            final long n3 = zStreamRef.address();
            final int n4 = 1;
            BytecodeManager.incBytecodes(n4);
            final int n5 = getAdler(n3);
            final int n6 = 2;
            BytecodeManager.incBytecodes(n6);
            final int n7 = 1;
            BytecodeManager.incBytecodes(n7);
            return n5;
        }
        catch (VirtualMachineError virtualMachineError) {
            throw virtualMachineError;
        }
    }
    
    public int getTotalIn() {
        try {
            BytecodeManager.incBytecodes(2);
            final int n = (int)this.getBytesRead();
            BytecodeManager.incBytecodes(2);
            return n;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public long getBytesRead() {
        try {
            final ZStreamRef zsRef = this.zsRef;
            BytecodeManager.incBytecodes(5);
            try {
                final Deflater deflater = this;
                final int n = 2;
                BytecodeManager.incBytecodes(n);
                deflater.ensureOpen();
                final Deflater deflater2 = this;
                final long n2 = deflater2.bytesRead;
                final int n3 = 4;
                BytecodeManager.incBytecodes(n3);
                final int n4 = 1;
                BytecodeManager.incBytecodes(n4);
                return n2;
            }
            finally {
                BytecodeManager.incBytecodes(503);
                BytecodeManager.incBytecodes(2);
            }
        }
        finally {}
        try {
            final Deflater deflater = this;
            final int n = 2;
            BytecodeManager.incBytecodes(n);
            deflater.ensureOpen();
            final Deflater deflater2 = this;
            final long n2 = deflater2.bytesRead;
            final int n3 = 4;
            BytecodeManager.incBytecodes(n3);
            final int n4 = 1;
            BytecodeManager.incBytecodes(n4);
            return n2;
        }
        catch (VirtualMachineError virtualMachineError) {
            throw virtualMachineError;
        }
    }
    
    public int getTotalOut() {
        try {
            BytecodeManager.incBytecodes(2);
            final int n = (int)this.getBytesWritten();
            BytecodeManager.incBytecodes(2);
            return n;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public long getBytesWritten() {
        try {
            final ZStreamRef zsRef = this.zsRef;
            BytecodeManager.incBytecodes(5);
            try {
                final Deflater deflater = this;
                final int n = 2;
                BytecodeManager.incBytecodes(n);
                deflater.ensureOpen();
                final Deflater deflater2 = this;
                final long n2 = deflater2.bytesWritten;
                final int n3 = 4;
                BytecodeManager.incBytecodes(n3);
                final int n4 = 1;
                BytecodeManager.incBytecodes(n4);
                return n2;
            }
            finally {
                BytecodeManager.incBytecodes(503);
                BytecodeManager.incBytecodes(2);
            }
        }
        finally {}
        try {
            final Deflater deflater = this;
            final int n = 2;
            BytecodeManager.incBytecodes(n);
            deflater.ensureOpen();
            final Deflater deflater2 = this;
            final long n2 = deflater2.bytesWritten;
            final int n3 = 4;
            BytecodeManager.incBytecodes(n3);
            final int n4 = 1;
            BytecodeManager.incBytecodes(n4);
            return n2;
        }
        catch (VirtualMachineError virtualMachineError) {
            throw virtualMachineError;
        }
    }
    
    public void reset() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        java/util/zip/Deflater.zsRef:Ljava/util/zip/ZStreamRef;
        //     4: dup            
        //     5: astore_1       
        //     6: pop            
        //     7: ldc             5
        //     9: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    12: aload_0        
        //    13: ldc             2
        //    15: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    18: invokespecial   java/util/zip/Deflater.ensureOpen:()V
        //    21: aload_0        
        //    22: getfield        java/util/zip/Deflater.zsRef:Ljava/util/zip/ZStreamRef;
        //    25: ldc             3
        //    27: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    30: invokevirtual   java/util/zip/ZStreamRef.address:()J
        //    33: ldc             1
        //    35: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    38: invokestatic    java/util/zip/Deflater.reset:(J)V
        //    41: aload_0        
        //    42: iconst_0       
        //    43: putfield        java/util/zip/Deflater.finish:Z
        //    46: ldc             3
        //    48: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    51: aload_0        
        //    52: iconst_0       
        //    53: putfield        java/util/zip/Deflater.finished:Z
        //    56: ldc             3
        //    58: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    61: aload_0        
        //    62: aload_0        
        //    63: iconst_0       
        //    64: dup_x1         
        //    65: putfield        java/util/zip/Deflater.len:I
        //    68: putfield        java/util/zip/Deflater.off:I
        //    71: ldc             6
        //    73: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    76: aload_0        
        //    77: aload_0        
        //    78: lconst_0       
        //    79: dup2_x1        
        //    80: putfield        java/util/zip/Deflater.bytesWritten:J
        //    83: putfield        java/util/zip/Deflater.bytesRead:J
        //    86: ldc             6
        //    88: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    91: aload_1        
        //    92: pop            
        //    93: ldc             2
        //    95: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    98: ldc             1
        //   100: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   103: goto            121
        //   106: astore_2       
        //   107: aload_1        
        //   108: pop            
        //   109: ldc             503
        //   111: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   114: aload_2        
        //   115: ldc             2
        //   117: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   120: athrow         
        //   121: ldc             1
        //   123: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   126: return         
        //   127: athrow         
        //   128: athrow         
        //    StackMapTable: 00 04 FF 00 6A 00 02 07 00 02 07 00 04 00 01 07 00 47 FA 00 0E FF 00 05 00 00 00 01 07 00 47 FF 00 00 00 00 00 01 07 00 4E
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  12     128    128    129    Ljava/lang/VirtualMachineError;
        //  12     98     106    121    Any
        //  106    114    106    121    Any
        //  0      127    127    128    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0121:
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
    
    public void end() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        java/util/zip/Deflater.zsRef:Ljava/util/zip/ZStreamRef;
        //     4: dup            
        //     5: astore_1       
        //     6: pop            
        //     7: ldc             5
        //     9: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    12: aload_0        
        //    13: getfield        java/util/zip/Deflater.zsRef:Ljava/util/zip/ZStreamRef;
        //    16: ldc             3
        //    18: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    21: invokevirtual   java/util/zip/ZStreamRef.address:()J
        //    24: lstore_2       
        //    25: ldc             1
        //    27: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    30: aload_0        
        //    31: getfield        java/util/zip/Deflater.zsRef:Ljava/util/zip/ZStreamRef;
        //    34: ldc             3
        //    36: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    39: invokevirtual   java/util/zip/ZStreamRef.clear:()V
        //    42: lload_2        
        //    43: lconst_0       
        //    44: lcmp           
        //    45: ldc             4
        //    47: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    50: ifeq            72
        //    53: lload_2        
        //    54: ldc             2
        //    56: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    59: invokestatic    java/util/zip/Deflater.end:(J)V
        //    62: aload_0        
        //    63: aconst_null    
        //    64: putfield        java/util/zip/Deflater.buf:[B
        //    67: ldc             3
        //    69: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    72: aload_1        
        //    73: pop            
        //    74: ldc             2
        //    76: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    79: ldc             1
        //    81: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    84: goto            104
        //    87: astore          4
        //    89: aload_1        
        //    90: pop            
        //    91: ldc             503
        //    93: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    96: aload           4
        //    98: ldc             2
        //   100: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   103: athrow         
        //   104: ldc             1
        //   106: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   109: return         
        //   110: athrow         
        //   111: athrow         
        //    StackMapTable: 00 05 FC 00 48 07 00 04 4E 07 00 47 FA 00 10 FF 00 05 00 00 00 01 07 00 47 FF 00 00 00 00 00 01 07 00 4E
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  12     111    111    112    Ljava/lang/VirtualMachineError;
        //  12     79     87     104    Any
        //  87     96     87     104    Any
        //  0      110    110    111    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0072:
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
    
    @Override
    protected void finalize() {
        try {
            BytecodeManager.incBytecodes(2);
            this.end();
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void ensureOpen() {
        try {
            final boolean $assertionsDisabled = Deflater.$assertionsDisabled;
            BytecodeManager.incBytecodes(2);
            if (!$assertionsDisabled) {
                final ZStreamRef zsRef = this.zsRef;
                BytecodeManager.incBytecodes(3);
                final boolean holdsLock = Thread.holdsLock(zsRef);
                BytecodeManager.incBytecodes(1);
                if (!holdsLock) {
                    BytecodeManager.incBytecodes(3);
                    final AssertionError assertionError = new AssertionError();
                    BytecodeManager.incBytecodes(1);
                    throw assertionError;
                }
            }
            final ZStreamRef zsRef2 = this.zsRef;
            BytecodeManager.incBytecodes(3);
            final long n = lcmp(zsRef2.address(), 0L);
            BytecodeManager.incBytecodes(3);
            if (n == 0) {
                final String s = "Deflater has been closed";
                BytecodeManager.incBytecodes(4);
                final NullPointerException ex = new NullPointerException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static native void initIDs();
    
    private static native long init(final int p0, final int p1, final boolean p2);
    
    private static native void setDictionary(final long p0, final byte[] p1, final int p2, final int p3);
    
    private native int deflateBytes(final long p0, final byte[] p1, final int p2, final int p3, final int p4);
    
    private static native int getAdler(final long p0);
    
    private static native void reset(final long p0);
    
    private static native void end(final long p0);
    
    static {
        try {
            final Class<Deflater> clazz = Deflater.class;
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
            BytecodeManager.incBytecodes(1);
            initIDs();
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
