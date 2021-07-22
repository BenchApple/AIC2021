// 
// Decompiled by Procyon v0.5.36
// 

package java.util.zip;

import aic2021.engine.BytecodeManager;

public class Inflater
{
    private final ZStreamRef zsRef;
    private byte[] buf;
    private int off;
    private int len;
    private boolean finished;
    private boolean needDict;
    private long bytesRead;
    private long bytesWritten;
    private static final byte[] defaultBuf;
    static final /* synthetic */ boolean $assertionsDisabled;
    
    public Inflater(final boolean b) {
        try {
            BytecodeManager.incBytecodes(2);
            this.buf = Inflater.defaultBuf;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(5);
            final long init = init(b);
            BytecodeManager.incBytecodes(1);
            this.zsRef = new ZStreamRef(init);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Inflater() {
        try {
            final boolean nowrap = false;
            BytecodeManager.incBytecodes(3);
            this(nowrap);
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
        //    77: getfield        java/util/zip/Inflater.zsRef:Ljava/util/zip/ZStreamRef;
        //    80: dup            
        //    81: astore          4
        //    83: pop            
        //    84: ldc             5
        //    86: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    89: aload_0        
        //    90: aload_1        
        //    91: putfield        java/util/zip/Inflater.buf:[B
        //    94: ldc             3
        //    96: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    99: aload_0        
        //   100: iload_2        
        //   101: putfield        java/util/zip/Inflater.off:I
        //   104: ldc             3
        //   106: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   109: aload_0        
        //   110: iload_3        
        //   111: putfield        java/util/zip/Inflater.len:I
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
        //    StackMapTable: 00 07 1B 1E 11 FF 00 3A 00 05 07 00 02 07 00 46 01 01 07 00 04 00 01 07 00 34 FA 00 11 FF 00 05 00 00 00 01 07 00 34 FF 00 00 00 00 00 01 07 00 3A
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
        //    77: getfield        java/util/zip/Inflater.zsRef:Ljava/util/zip/ZStreamRef;
        //    80: dup            
        //    81: astore          4
        //    83: pop            
        //    84: ldc             5
        //    86: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    89: aload_0        
        //    90: ldc             2
        //    92: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    95: invokespecial   java/util/zip/Inflater.ensureOpen:()V
        //    98: aload_0        
        //    99: getfield        java/util/zip/Inflater.zsRef:Ljava/util/zip/ZStreamRef;
        //   102: ldc             3
        //   104: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   107: invokevirtual   java/util/zip/ZStreamRef.address:()J
        //   110: aload_1        
        //   111: iload_2        
        //   112: iload_3        
        //   113: ldc             4
        //   115: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   118: invokestatic    java/util/zip/Inflater.setDictionary:(J[BII)V
        //   121: aload_0        
        //   122: iconst_0       
        //   123: putfield        java/util/zip/Inflater.needDict:Z
        //   126: ldc             3
        //   128: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   131: aload           4
        //   133: pop            
        //   134: ldc             2
        //   136: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   139: ldc             1
        //   141: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   144: goto            165
        //   147: astore          5
        //   149: aload           4
        //   151: pop            
        //   152: ldc             503
        //   154: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   157: aload           5
        //   159: ldc             2
        //   161: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   164: athrow         
        //   165: ldc             1
        //   167: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   170: return         
        //   171: athrow         
        //   172: athrow         
        //    StackMapTable: 00 07 1B 1E 11 FF 00 46 00 05 07 00 02 07 00 46 01 01 07 00 04 00 01 07 00 34 FA 00 11 FF 00 05 00 00 00 01 07 00 34 FF 00 00 00 00 00 01 07 00 3A
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  89     172    172    173    Ljava/lang/VirtualMachineError;
        //  89     139    147    165    Any
        //  147    157    147    165    Any
        //  0      171    171    172    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0165:
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
    
    public int getRemaining() {
        try {
            final ZStreamRef zsRef = this.zsRef;
            BytecodeManager.incBytecodes(5);
            try {
                final Inflater inflater = this;
                final int n = inflater.len;
                final int n2 = 4;
                BytecodeManager.incBytecodes(n2);
                final int n3 = 1;
                BytecodeManager.incBytecodes(n3);
                return n;
            }
            finally {
                BytecodeManager.incBytecodes(503);
                BytecodeManager.incBytecodes(2);
            }
        }
        finally {}
        try {
            final Inflater inflater = this;
            final int n = inflater.len;
            final int n2 = 4;
            BytecodeManager.incBytecodes(n2);
            final int n3 = 1;
            BytecodeManager.incBytecodes(n3);
            return n;
        }
        catch (VirtualMachineError virtualMachineError) {
            throw virtualMachineError;
        }
    }
    
    public boolean needsInput() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        java/util/zip/Inflater.zsRef:Ljava/util/zip/ZStreamRef;
        //     4: dup            
        //     5: astore_1       
        //     6: pop            
        //     7: ldc             5
        //     9: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    12: aload_0        
        //    13: getfield        java/util/zip/Inflater.len:I
        //    16: ldc             3
        //    18: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    21: ifgt            33
        //    24: iconst_1       
        //    25: ldc             2
        //    27: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    30: goto            39
        //    33: iconst_0       
        //    34: ldc             1
        //    36: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    39: aload_1        
        //    40: pop            
        //    41: ldc             2
        //    43: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    46: ldc             1
        //    48: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    51: ireturn        
        //    52: astore_2       
        //    53: aload_1        
        //    54: pop            
        //    55: ldc             503
        //    57: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    60: aload_2        
        //    61: ldc             2
        //    63: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    66: athrow         
        //    67: athrow         
        //    68: athrow         
        //    StackMapTable: 00 05 FC 00 21 07 00 04 45 01 4C 07 00 34 FF 00 0E 00 00 00 01 07 00 34 FF 00 00 00 00 00 01 07 00 3A
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  12     68     68     69     Ljava/lang/VirtualMachineError;
        //  12     46     52     67     Any
        //  52     60     52     67     Any
        //  0      67     67     68     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0033:
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
    
    public boolean needsDictionary() {
        try {
            final ZStreamRef zsRef = this.zsRef;
            BytecodeManager.incBytecodes(5);
            try {
                final Inflater inflater = this;
                final boolean b = inflater.needDict;
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
            final Inflater inflater = this;
            final boolean b = inflater.needDict;
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
    
    public boolean finished() {
        try {
            final ZStreamRef zsRef = this.zsRef;
            BytecodeManager.incBytecodes(5);
            try {
                final Inflater inflater = this;
                final boolean b = inflater.finished;
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
            final Inflater inflater = this;
            final boolean b = inflater.finished;
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
    
    public int inflate(final byte[] array, final int n, final int n2) throws DataFormatException {
        try {
            BytecodeManager.incBytecodes(2);
            if (array == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(2);
            if (n >= 0) {
                BytecodeManager.incBytecodes(2);
                if (n2 >= 0) {
                    final int n3 = array.length - n2;
                    BytecodeManager.incBytecodes(6);
                    if (n <= n3) {
                        final ZStreamRef zsRef = this.zsRef;
                        BytecodeManager.incBytecodes(5);
                        try {
                            final Inflater inflater = this;
                            final int n4 = 2;
                            BytecodeManager.incBytecodes(n4);
                            inflater.ensureOpen();
                            final Inflater inflater2 = this;
                            final int n5 = inflater2.len;
                            final int n6 = 3;
                            BytecodeManager.incBytecodes(n6);
                            final Inflater inflater3 = this;
                            final Inflater inflater4 = this;
                            final ZStreamRef zStreamRef = inflater4.zsRef;
                            final int n7 = 4;
                            BytecodeManager.incBytecodes(n7);
                            final long n8 = zStreamRef.address();
                            final byte[] array2 = array;
                            final int n9 = n;
                            final int n10 = n2;
                            final int n11 = 4;
                            BytecodeManager.incBytecodes(n11);
                            final int n12 = inflater3.inflateBytes(n8, array2, n9, n10);
                            final int n13 = 1;
                            BytecodeManager.incBytecodes(n13);
                            final Inflater inflater5 = this;
                            final long n14 = inflater5.bytesWritten;
                            final int n15 = n12;
                            final long n16 = n15;
                            final long n17 = n14 + n16;
                            inflater5.bytesWritten = n17;
                            final int n18 = 7;
                            BytecodeManager.incBytecodes(n18);
                            final Inflater inflater6 = this;
                            final long n19 = inflater6.bytesRead;
                            final int n20 = n5;
                            final Inflater inflater7 = this;
                            final int n21 = inflater7.len;
                            final int n22 = n20 - n21;
                            final long n23 = n22;
                            final long n24 = n19 + n23;
                            inflater6.bytesRead = n24;
                            final int n25 = 10;
                            BytecodeManager.incBytecodes(n25);
                            final int n26 = n12;
                            final int n27 = 3;
                            BytecodeManager.incBytecodes(n27);
                            final int n28 = 1;
                            BytecodeManager.incBytecodes(n28);
                            return n26;
                        }
                        finally {
                            BytecodeManager.incBytecodes(503);
                            BytecodeManager.incBytecodes(2);
                        }
                    }
                }
            }
            BytecodeManager.incBytecodes(3);
            final ArrayIndexOutOfBoundsException ex2 = new ArrayIndexOutOfBoundsException();
            BytecodeManager.incBytecodes(1);
            throw ex2;
        }
        finally {}
        try {
            final Inflater inflater = this;
            final int n4 = 2;
            BytecodeManager.incBytecodes(n4);
            inflater.ensureOpen();
            final Inflater inflater2 = this;
            final int n5 = inflater2.len;
            final int n6 = 3;
            BytecodeManager.incBytecodes(n6);
            final Inflater inflater3 = this;
            final Inflater inflater4 = this;
            final ZStreamRef zStreamRef = inflater4.zsRef;
            final int n7 = 4;
            BytecodeManager.incBytecodes(n7);
            final long n8 = zStreamRef.address();
            final byte[] array2 = array;
            final int n9 = n;
            final int n10 = n2;
            final int n11 = 4;
            BytecodeManager.incBytecodes(n11);
            final int n12 = inflater3.inflateBytes(n8, array2, n9, n10);
            final int n13 = 1;
            BytecodeManager.incBytecodes(n13);
            final Inflater inflater5 = this;
            final long n14 = inflater5.bytesWritten;
            final int n15 = n12;
            final long n16 = n15;
            final long n17 = n14 + n16;
            inflater5.bytesWritten = n17;
            final int n18 = 7;
            BytecodeManager.incBytecodes(n18);
            final Inflater inflater6 = this;
            final long n19 = inflater6.bytesRead;
            final int n20 = n5;
            final Inflater inflater7 = this;
            final int n21 = inflater7.len;
            final int n22 = n20 - n21;
            final long n23 = n22;
            final long n24 = n19 + n23;
            inflater6.bytesRead = n24;
            final int n25 = 10;
            BytecodeManager.incBytecodes(n25);
            final int n26 = n12;
            final int n27 = 3;
            BytecodeManager.incBytecodes(n27);
            final int n28 = 1;
            BytecodeManager.incBytecodes(n28);
            return n26;
        }
        catch (VirtualMachineError virtualMachineError) {
            throw virtualMachineError;
        }
    }
    
    public int inflate(final byte[] output) throws DataFormatException {
        try {
            final int off = 0;
            final int length = output.length;
            BytecodeManager.incBytecodes(6);
            final int inflate = this.inflate(output, off, length);
            BytecodeManager.incBytecodes(1);
            return inflate;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public int getAdler() {
        try {
            final ZStreamRef zsRef = this.zsRef;
            BytecodeManager.incBytecodes(5);
            try {
                final Inflater inflater = this;
                final int n = 2;
                BytecodeManager.incBytecodes(n);
                inflater.ensureOpen();
                final Inflater inflater2 = this;
                final ZStreamRef zStreamRef = inflater2.zsRef;
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
            final Inflater inflater = this;
            final int n = 2;
            BytecodeManager.incBytecodes(n);
            inflater.ensureOpen();
            final Inflater inflater2 = this;
            final ZStreamRef zStreamRef = inflater2.zsRef;
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
                final Inflater inflater = this;
                final int n = 2;
                BytecodeManager.incBytecodes(n);
                inflater.ensureOpen();
                final Inflater inflater2 = this;
                final long n2 = inflater2.bytesRead;
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
            final Inflater inflater = this;
            final int n = 2;
            BytecodeManager.incBytecodes(n);
            inflater.ensureOpen();
            final Inflater inflater2 = this;
            final long n2 = inflater2.bytesRead;
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
                final Inflater inflater = this;
                final int n = 2;
                BytecodeManager.incBytecodes(n);
                inflater.ensureOpen();
                final Inflater inflater2 = this;
                final long n2 = inflater2.bytesWritten;
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
            final Inflater inflater = this;
            final int n = 2;
            BytecodeManager.incBytecodes(n);
            inflater.ensureOpen();
            final Inflater inflater2 = this;
            final long n2 = inflater2.bytesWritten;
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
        //     1: getfield        java/util/zip/Inflater.zsRef:Ljava/util/zip/ZStreamRef;
        //     4: dup            
        //     5: astore_1       
        //     6: pop            
        //     7: ldc             5
        //     9: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    12: aload_0        
        //    13: ldc             2
        //    15: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    18: invokespecial   java/util/zip/Inflater.ensureOpen:()V
        //    21: aload_0        
        //    22: getfield        java/util/zip/Inflater.zsRef:Ljava/util/zip/ZStreamRef;
        //    25: ldc             3
        //    27: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    30: invokevirtual   java/util/zip/ZStreamRef.address:()J
        //    33: ldc             1
        //    35: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    38: invokestatic    java/util/zip/Inflater.reset:(J)V
        //    41: aload_0        
        //    42: getstatic       java/util/zip/Inflater.defaultBuf:[B
        //    45: putfield        java/util/zip/Inflater.buf:[B
        //    48: ldc             3
        //    50: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    53: aload_0        
        //    54: iconst_0       
        //    55: putfield        java/util/zip/Inflater.finished:Z
        //    58: ldc             3
        //    60: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    63: aload_0        
        //    64: iconst_0       
        //    65: putfield        java/util/zip/Inflater.needDict:Z
        //    68: ldc             3
        //    70: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    73: aload_0        
        //    74: aload_0        
        //    75: iconst_0       
        //    76: dup_x1         
        //    77: putfield        java/util/zip/Inflater.len:I
        //    80: putfield        java/util/zip/Inflater.off:I
        //    83: ldc             6
        //    85: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    88: aload_0        
        //    89: aload_0        
        //    90: lconst_0       
        //    91: dup2_x1        
        //    92: putfield        java/util/zip/Inflater.bytesWritten:J
        //    95: putfield        java/util/zip/Inflater.bytesRead:J
        //    98: ldc             6
        //   100: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   103: aload_1        
        //   104: pop            
        //   105: ldc             2
        //   107: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   110: ldc             1
        //   112: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   115: goto            133
        //   118: astore_2       
        //   119: aload_1        
        //   120: pop            
        //   121: ldc             503
        //   123: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   126: aload_2        
        //   127: ldc             2
        //   129: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   132: athrow         
        //   133: ldc             1
        //   135: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   138: return         
        //   139: athrow         
        //   140: athrow         
        //    StackMapTable: 00 04 FF 00 76 00 02 07 00 02 07 00 04 00 01 07 00 34 FA 00 0E FF 00 05 00 00 00 01 07 00 34 FF 00 00 00 00 00 01 07 00 3A
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  12     140    140    141    Ljava/lang/VirtualMachineError;
        //  12     110    118    133    Any
        //  118    126    118    133    Any
        //  0      139    139    140    Any
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
    
    public void end() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        java/util/zip/Inflater.zsRef:Ljava/util/zip/ZStreamRef;
        //     4: dup            
        //     5: astore_1       
        //     6: pop            
        //     7: ldc             5
        //     9: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    12: aload_0        
        //    13: getfield        java/util/zip/Inflater.zsRef:Ljava/util/zip/ZStreamRef;
        //    16: ldc             3
        //    18: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    21: invokevirtual   java/util/zip/ZStreamRef.address:()J
        //    24: lstore_2       
        //    25: ldc             1
        //    27: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    30: aload_0        
        //    31: getfield        java/util/zip/Inflater.zsRef:Ljava/util/zip/ZStreamRef;
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
        //    59: invokestatic    java/util/zip/Inflater.end:(J)V
        //    62: aload_0        
        //    63: aconst_null    
        //    64: putfield        java/util/zip/Inflater.buf:[B
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
        //    StackMapTable: 00 05 FC 00 48 07 00 04 4E 07 00 34 FA 00 10 FF 00 05 00 00 00 01 07 00 34 FF 00 00 00 00 00 01 07 00 3A
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
            final boolean $assertionsDisabled = Inflater.$assertionsDisabled;
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
                final String s = "Inflater has been closed";
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
    
    boolean ended() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     4: dup            
        //     5: astore_1       
        //     6: pop            
        //     7: ldc             5
        //     9: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    12: aload_0        
        //    13: getfield        java/util/zip/Inflater.zsRef:Ljava/util/zip/ZStreamRef;
        //    16: ldc             3
        //    18: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    21: invokevirtual   java/util/zip/ZStreamRef.address:()J
        //    24: lconst_0       
        //    25: lcmp           
        //    26: ldc             3
        //    28: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    31: ifne            43
        //    34: iconst_1       
        //    35: ldc             2
        //    37: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    40: goto            49
        //    43: iconst_0       
        //    44: ldc             1
        //    46: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    49: aload_1        
        //    50: pop            
        //    51: ldc             2
        //    53: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    56: ldc             1
        //    58: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    61: ireturn        
        //    62: astore_2       
        //    63: aload_1        
        //    64: pop            
        //    65: ldc             503
        //    67: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    70: aload_2        
        //    71: ldc             2
        //    73: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    76: athrow         
        //    77: athrow         
        //    78: athrow         
        //    StackMapTable: 00 05 FC 00 2B 07 00 04 45 01 4C 07 00 34 FF 00 0E 00 00 00 01 07 00 34 FF 00 00 00 00 00 01 07 00 3A
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  12     78     78     79     Ljava/lang/VirtualMachineError;
        //  12     56     62     77     Any
        //  62     70     62     77     Any
        //  0      77     77     78     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0043:
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
    
    private static native void initIDs();
    
    private static native long init(final boolean p0);
    
    private static native void setDictionary(final long p0, final byte[] p1, final int p2, final int p3);
    
    private native int inflateBytes(final long p0, final byte[] p1, final int p2, final int p3) throws DataFormatException;
    
    private static native int getAdler(final long p0);
    
    private static native void reset(final long p0);
    
    private static native void end(final long p0);
    
    static {
        try {
            final Class<Inflater> clazz = Inflater.class;
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
            Inflater.defaultBuf = new byte[0];
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
            initIDs();
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
