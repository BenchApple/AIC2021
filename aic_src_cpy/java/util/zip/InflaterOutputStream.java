// 
// Decompiled by Procyon v0.5.36
// 

package java.util.zip;

import java.io.OutputStream;
import java.io.IOException;
import aic2021.engine.BytecodeManager;
import java.io.FilterOutputStream;

public class InflaterOutputStream extends FilterOutputStream
{
    protected final Inflater inf;
    protected final byte[] buf;
    private final byte[] wbuf;
    private boolean usesDefaultInflater;
    private boolean closed;
    
    private void ensureOpen() throws IOException {
        try {
            final boolean closed = this.closed;
            BytecodeManager.incBytecodes(3);
            if (closed) {
                final String message = "Stream closed";
                BytecodeManager.incBytecodes(4);
                final IOException ex = new IOException(message);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public InflaterOutputStream(final OutputStream outputStream) {
        try {
            BytecodeManager.incBytecodes(5);
            final Inflater inflater = new Inflater();
            BytecodeManager.incBytecodes(1);
            this(outputStream, inflater);
            this.usesDefaultInflater = true;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public InflaterOutputStream(final OutputStream outputStream, final Inflater inflater) {
        try {
            final int n = 512;
            BytecodeManager.incBytecodes(5);
            this(outputStream, inflater, n);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public InflaterOutputStream(final OutputStream out, final Inflater inf, final int n) {
        try {
            BytecodeManager.incBytecodes(3);
            super(out);
            this.wbuf = new byte[1];
            BytecodeManager.incBytecodes(3);
            this.usesDefaultInflater = false;
            BytecodeManager.incBytecodes(3);
            this.closed = false;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(2);
            if (out == null) {
                final String s = "Null output";
                BytecodeManager.incBytecodes(4);
                final NullPointerException ex = new NullPointerException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(2);
            if (inf == null) {
                final String s2 = "Null inflater";
                BytecodeManager.incBytecodes(4);
                final NullPointerException ex2 = new NullPointerException(s2);
                BytecodeManager.incBytecodes(1);
                throw ex2;
            }
            BytecodeManager.incBytecodes(2);
            if (n <= 0) {
                final String s3 = "Buffer size < 1";
                BytecodeManager.incBytecodes(4);
                final IllegalArgumentException ex3 = new IllegalArgumentException(s3);
                BytecodeManager.incBytecodes(1);
                throw ex3;
            }
            this.inf = inf;
            BytecodeManager.incBytecodes(3);
            this.buf = new byte[n];
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void close() throws IOException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        java/util/zip/InflaterOutputStream.closed:Z
        //     4: ldc             3
        //     6: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     9: ifne            76
        //    12: aload_0        
        //    13: ldc             2
        //    15: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    18: invokevirtual   java/util/zip/InflaterOutputStream.finish:()V
        //    21: aload_0        
        //    22: getfield        java/util/zip/InflaterOutputStream.out:Ljava/io/OutputStream;
        //    25: ldc             3
        //    27: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    30: invokevirtual   java/io/OutputStream.close:()V
        //    33: aload_0        
        //    34: iconst_1       
        //    35: putfield        java/util/zip/InflaterOutputStream.closed:Z
        //    38: ldc             3
        //    40: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    43: ldc             1
        //    45: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    48: goto            76
        //    51: astore_1       
        //    52: aload_0        
        //    53: getfield        java/util/zip/InflaterOutputStream.out:Ljava/io/OutputStream;
        //    56: ldc             504
        //    58: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    61: invokevirtual   java/io/OutputStream.close:()V
        //    64: aload_0        
        //    65: iconst_1       
        //    66: putfield        java/util/zip/InflaterOutputStream.closed:Z
        //    69: aload_1        
        //    70: ldc             5
        //    72: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    75: athrow         
        //    76: ldc             1
        //    78: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    81: return         
        //    82: athrow         
        //    83: athrow         
        //    Exceptions:
        //  throws java.io.IOException
        //    StackMapTable: 00 04 73 07 00 24 18 FF 00 05 00 00 00 01 07 00 24 FF 00 00 00 00 00 01 07 00 4C
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  12     83     83     84     Ljava/lang/VirtualMachineError;
        //  12     21     51     76     Any
        //  0      82     82     83     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0076:
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
    public void flush() throws IOException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             2
        //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     6: invokespecial   java/util/zip/InflaterOutputStream.ensureOpen:()V
        //     9: aload_0        
        //    10: getfield        java/util/zip/InflaterOutputStream.inf:Ljava/util/zip/Inflater;
        //    13: ldc             3
        //    15: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    18: invokevirtual   java/util/zip/Inflater.finished:()Z
        //    21: ldc             1
        //    23: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    26: ifne            215
        //    29: aload_0        
        //    30: getfield        java/util/zip/InflaterOutputStream.inf:Ljava/util/zip/Inflater;
        //    33: ldc             3
        //    35: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    38: invokevirtual   java/util/zip/Inflater.finished:()Z
        //    41: ldc             1
        //    43: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    46: ifne            141
        //    49: aload_0        
        //    50: getfield        java/util/zip/InflaterOutputStream.inf:Ljava/util/zip/Inflater;
        //    53: ldc             3
        //    55: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    58: invokevirtual   java/util/zip/Inflater.needsInput:()Z
        //    61: ldc             1
        //    63: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    66: ifne            141
        //    69: aload_0        
        //    70: getfield        java/util/zip/InflaterOutputStream.inf:Ljava/util/zip/Inflater;
        //    73: aload_0        
        //    74: getfield        java/util/zip/InflaterOutputStream.buf:[B
        //    77: iconst_0       
        //    78: aload_0        
        //    79: getfield        java/util/zip/InflaterOutputStream.buf:[B
        //    82: arraylength    
        //    83: ldc             9
        //    85: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    88: invokevirtual   java/util/zip/Inflater.inflate:([BII)I
        //    91: istore_1       
        //    92: ldc             1
        //    94: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    97: iload_1        
        //    98: iconst_1       
        //    99: ldc             3
        //   101: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   104: if_icmpge       115
        //   107: ldc             1
        //   109: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   112: goto            141
        //   115: aload_0        
        //   116: getfield        java/util/zip/InflaterOutputStream.out:Ljava/io/OutputStream;
        //   119: aload_0        
        //   120: getfield        java/util/zip/InflaterOutputStream.buf:[B
        //   123: iconst_0       
        //   124: iload_1        
        //   125: ldc             7
        //   127: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   130: invokevirtual   java/io/OutputStream.write:([BII)V
        //   133: ldc             1
        //   135: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   138: goto            29
        //   141: aload_0        
        //   142: ldc             2
        //   144: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   147: invokespecial   java/io/FilterOutputStream.flush:()V
        //   150: ldc             1
        //   152: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   155: goto            215
        //   158: astore_1       
        //   159: ldc             501
        //   161: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   164: aload_1        
        //   165: ldc             2
        //   167: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   170: invokevirtual   java/util/zip/DataFormatException.getMessage:()Ljava/lang/String;
        //   173: astore_2       
        //   174: ldc             1
        //   176: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   179: aload_2        
        //   180: ldc             2
        //   182: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   185: ifnonnull       196
        //   188: ldc             "Invalid ZLIB data format"
        //   190: astore_2       
        //   191: ldc             2
        //   193: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   196: new             Ljava/util/zip/ZipException;
        //   199: dup            
        //   200: aload_2        
        //   201: ldc             4
        //   203: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   206: invokespecial   java/util/zip/ZipException.<init>:(Ljava/lang/String;)V
        //   209: ldc             1
        //   211: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   214: athrow         
        //   215: ldc             1
        //   217: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   220: return         
        //   221: athrow         
        //   222: athrow         
        //    Exceptions:
        //  throws java.io.IOException
        //    StackMapTable: 00 08 1D FC 00 55 01 FA 00 19 50 07 00 59 FD 00 25 07 00 59 07 00 77 F9 00 12 FF 00 05 00 00 00 01 07 00 24 FF 00 00 00 00 00 01 07 00 4C
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                               
        //  -----  -----  -----  -----  -----------------------------------
        //  29     222    222    223    Ljava/lang/VirtualMachineError;
        //  29     150    158    215    Ljava/util/zip/DataFormatException;
        //  0      221    221    222    Any
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
    
    public void finish() throws IOException {
        try {
            BytecodeManager.incBytecodes(2);
            this.ensureOpen();
            BytecodeManager.incBytecodes(2);
            this.flush();
            final boolean usesDefaultInflater = this.usesDefaultInflater;
            BytecodeManager.incBytecodes(3);
            if (usesDefaultInflater) {
                final Inflater inf = this.inf;
                BytecodeManager.incBytecodes(3);
                inf.end();
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void write(final int n) throws IOException {
        try {
            this.wbuf[0] = (byte)n;
            BytecodeManager.incBytecodes(6);
            final byte[] wbuf = this.wbuf;
            final int n2 = 0;
            final int n3 = 1;
            BytecodeManager.incBytecodes(6);
            this.write(wbuf, n2, n3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void write(final byte[] p0, final int p1, final int p2) throws IOException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             2
        //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     6: invokespecial   java/util/zip/InflaterOutputStream.ensureOpen:()V
        //     9: aload_1        
        //    10: ldc             2
        //    12: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    15: ifnonnull       38
        //    18: new             Ljava/lang/NullPointerException;
        //    21: dup            
        //    22: ldc             "Null buffer for read"
        //    24: ldc             4
        //    26: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    29: invokespecial   java/lang/NullPointerException.<init>:(Ljava/lang/String;)V
        //    32: ldc             1
        //    34: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    37: athrow         
        //    38: iload_2        
        //    39: ldc             2
        //    41: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    44: iflt            69
        //    47: iload_3        
        //    48: ldc             2
        //    50: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    53: iflt            69
        //    56: iload_3        
        //    57: aload_1        
        //    58: arraylength    
        //    59: iload_2        
        //    60: isub           
        //    61: ldc             6
        //    63: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    66: if_icmple       87
        //    69: new             Ljava/lang/IndexOutOfBoundsException;
        //    72: dup            
        //    73: ldc             3
        //    75: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    78: invokespecial   java/lang/IndexOutOfBoundsException.<init>:()V
        //    81: ldc             1
        //    83: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    86: athrow         
        //    87: iload_3        
        //    88: ldc             2
        //    90: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    93: ifne            102
        //    96: ldc             1
        //    98: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   101: return         
        //   102: aload_0        
        //   103: getfield        java/util/zip/InflaterOutputStream.inf:Ljava/util/zip/Inflater;
        //   106: ldc             3
        //   108: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   111: invokevirtual   java/util/zip/Inflater.needsInput:()Z
        //   114: ldc             1
        //   116: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   119: ifeq            212
        //   122: iload_3        
        //   123: iconst_1       
        //   124: ldc             3
        //   126: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   129: if_icmpge       140
        //   132: ldc             1
        //   134: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   137: goto            356
        //   140: iload_3        
        //   141: sipush          512
        //   144: ldc             3
        //   146: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   149: if_icmpge       161
        //   152: iload_3        
        //   153: ldc             2
        //   155: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   158: goto            169
        //   161: sipush          512
        //   164: ldc             1
        //   166: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   169: istore          5
        //   171: ldc             1
        //   173: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   176: aload_0        
        //   177: getfield        java/util/zip/InflaterOutputStream.inf:Ljava/util/zip/Inflater;
        //   180: aload_1        
        //   181: iload_2        
        //   182: iload           5
        //   184: ldc             6
        //   186: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   189: invokevirtual   java/util/zip/Inflater.setInput:([BII)V
        //   192: iload_2        
        //   193: iload           5
        //   195: iadd           
        //   196: istore_2       
        //   197: ldc             4
        //   199: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   202: iload_3        
        //   203: iload           5
        //   205: isub           
        //   206: istore_3       
        //   207: ldc             4
        //   209: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   212: aload_0        
        //   213: getfield        java/util/zip/InflaterOutputStream.inf:Ljava/util/zip/Inflater;
        //   216: aload_0        
        //   217: getfield        java/util/zip/InflaterOutputStream.buf:[B
        //   220: iconst_0       
        //   221: aload_0        
        //   222: getfield        java/util/zip/InflaterOutputStream.buf:[B
        //   225: arraylength    
        //   226: ldc             9
        //   228: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   231: invokevirtual   java/util/zip/Inflater.inflate:([BII)I
        //   234: istore          4
        //   236: ldc             1
        //   238: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   241: iload           4
        //   243: ldc             2
        //   245: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   248: ifle            270
        //   251: aload_0        
        //   252: getfield        java/util/zip/InflaterOutputStream.out:Ljava/io/OutputStream;
        //   255: aload_0        
        //   256: getfield        java/util/zip/InflaterOutputStream.buf:[B
        //   259: iconst_0       
        //   260: iload           4
        //   262: ldc             7
        //   264: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   267: invokevirtual   java/io/OutputStream.write:([BII)V
        //   270: iload           4
        //   272: ldc             2
        //   274: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   277: ifgt            212
        //   280: aload_0        
        //   281: getfield        java/util/zip/InflaterOutputStream.inf:Ljava/util/zip/Inflater;
        //   284: ldc             3
        //   286: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   289: invokevirtual   java/util/zip/Inflater.finished:()Z
        //   292: ldc             1
        //   294: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   297: ifeq            308
        //   300: ldc             1
        //   302: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   305: goto            356
        //   308: aload_0        
        //   309: getfield        java/util/zip/InflaterOutputStream.inf:Ljava/util/zip/Inflater;
        //   312: ldc             3
        //   314: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   317: invokevirtual   java/util/zip/Inflater.needsDictionary:()Z
        //   320: ldc             1
        //   322: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   325: ifeq            348
        //   328: new             Ljava/util/zip/ZipException;
        //   331: dup            
        //   332: ldc             "ZLIB dictionary missing"
        //   334: ldc             4
        //   336: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   339: invokespecial   java/util/zip/ZipException.<init>:(Ljava/lang/String;)V
        //   342: ldc             1
        //   344: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   347: athrow         
        //   348: ldc             1
        //   350: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   353: goto            102
        //   356: ldc             1
        //   358: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   361: goto            427
        //   364: astore          4
        //   366: ldc             501
        //   368: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   371: aload           4
        //   373: ldc             2
        //   375: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   378: invokevirtual   java/util/zip/DataFormatException.getMessage:()Ljava/lang/String;
        //   381: astore          5
        //   383: ldc             1
        //   385: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   388: aload           5
        //   390: ldc             2
        //   392: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   395: ifnonnull       407
        //   398: ldc             "Invalid ZLIB data format"
        //   400: astore          5
        //   402: ldc             2
        //   404: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   407: new             Ljava/util/zip/ZipException;
        //   410: dup            
        //   411: aload           5
        //   413: ldc             4
        //   415: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   418: invokespecial   java/util/zip/ZipException.<init>:(Ljava/lang/String;)V
        //   421: ldc             1
        //   423: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   426: athrow         
        //   427: ldc             1
        //   429: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   432: return         
        //   433: athrow         
        //   434: athrow         
        //    Exceptions:
        //  throws java.io.IOException
        //    StackMapTable: 00 11 26 1E 11 0E 25 14 47 01 2A FC 00 39 01 25 FA 00 27 07 47 07 00 59 FD 00 2A 07 00 59 07 00 77 F9 00 13 FF 00 05 00 00 00 01 07 00 24 FF 00 00 00 00 00 01 07 00 4C
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                               
        //  -----  -----  -----  -----  -----------------------------------
        //  102    434    434    435    Ljava/lang/VirtualMachineError;
        //  102    356    364    427    Ljava/util/zip/DataFormatException;
        //  0      433    433    434    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0102:
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
}
