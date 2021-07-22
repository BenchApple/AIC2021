// 
// Decompiled by Procyon v0.5.36
// 

package java.util.zip;

import java.io.EOFException;
import java.io.InputStream;
import java.io.IOException;
import aic2021.engine.BytecodeManager;
import java.io.FilterInputStream;

public class InflaterInputStream extends FilterInputStream
{
    protected Inflater inf;
    protected byte[] buf;
    protected int len;
    private boolean closed;
    private boolean reachEOF;
    boolean usesDefaultInflater;
    private byte[] singleByteBuf;
    private byte[] b;
    
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
    
    public InflaterInputStream(final InputStream in, final Inflater inf, final int n) {
        try {
            BytecodeManager.incBytecodes(3);
            super(in);
            this.closed = false;
            BytecodeManager.incBytecodes(3);
            this.reachEOF = false;
            BytecodeManager.incBytecodes(3);
            this.usesDefaultInflater = false;
            BytecodeManager.incBytecodes(3);
            this.singleByteBuf = new byte[1];
            BytecodeManager.incBytecodes(3);
            this.b = new byte[512];
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(2);
            if (in != null) {
                BytecodeManager.incBytecodes(2);
                if (inf != null) {
                    BytecodeManager.incBytecodes(2);
                    if (n <= 0) {
                        final String s = "buffer size <= 0";
                        BytecodeManager.incBytecodes(4);
                        final IllegalArgumentException ex = new IllegalArgumentException(s);
                        BytecodeManager.incBytecodes(1);
                        throw ex;
                    }
                    this.inf = inf;
                    BytecodeManager.incBytecodes(3);
                    this.buf = new byte[n];
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(1);
                    return;
                }
            }
            BytecodeManager.incBytecodes(3);
            final NullPointerException ex2 = new NullPointerException();
            BytecodeManager.incBytecodes(1);
            throw ex2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public InflaterInputStream(final InputStream in, final Inflater inf) {
        try {
            final int size = 512;
            BytecodeManager.incBytecodes(5);
            this(in, inf, size);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public InflaterInputStream(final InputStream in) {
        try {
            BytecodeManager.incBytecodes(5);
            final Inflater inf = new Inflater();
            BytecodeManager.incBytecodes(1);
            this(in, inf);
            this.usesDefaultInflater = true;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public int read() throws IOException {
        try {
            BytecodeManager.incBytecodes(2);
            this.ensureOpen();
            final byte[] singleByteBuf = this.singleByteBuf;
            final int off = 0;
            final int len = 1;
            BytecodeManager.incBytecodes(6);
            final int read = this.read(singleByteBuf, off, len);
            final int n = -1;
            BytecodeManager.incBytecodes(2);
            int unsignedInt;
            if (read == n) {
                unsignedInt = -1;
                BytecodeManager.incBytecodes(2);
            }
            else {
                final byte x = this.singleByteBuf[0];
                BytecodeManager.incBytecodes(5);
                unsignedInt = Byte.toUnsignedInt(x);
            }
            BytecodeManager.incBytecodes(1);
            return unsignedInt;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public int read(final byte[] p0, final int p1, final int p2) throws IOException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             2
        //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     6: invokespecial   java/util/zip/InflaterInputStream.ensureOpen:()V
        //     9: aload_1        
        //    10: ldc             2
        //    12: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    15: ifnonnull       36
        //    18: new             Ljava/lang/NullPointerException;
        //    21: dup            
        //    22: ldc             3
        //    24: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    27: invokespecial   java/lang/NullPointerException.<init>:()V
        //    30: ldc             1
        //    32: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    35: athrow         
        //    36: iload_2        
        //    37: ldc             2
        //    39: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    42: iflt            67
        //    45: iload_3        
        //    46: ldc             2
        //    48: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    51: iflt            67
        //    54: iload_3        
        //    55: aload_1        
        //    56: arraylength    
        //    57: iload_2        
        //    58: isub           
        //    59: ldc             6
        //    61: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    64: if_icmple       85
        //    67: new             Ljava/lang/IndexOutOfBoundsException;
        //    70: dup            
        //    71: ldc             3
        //    73: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    76: invokespecial   java/lang/IndexOutOfBoundsException.<init>:()V
        //    79: ldc             1
        //    81: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    84: athrow         
        //    85: iload_3        
        //    86: ldc             2
        //    88: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    91: ifne            101
        //    94: iconst_0       
        //    95: ldc             2
        //    97: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   100: ireturn        
        //   101: aload_0        
        //   102: getfield        java/util/zip/InflaterInputStream.inf:Ljava/util/zip/Inflater;
        //   105: aload_1        
        //   106: iload_2        
        //   107: iload_3        
        //   108: ldc             6
        //   110: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   113: invokevirtual   java/util/zip/Inflater.inflate:([BII)I
        //   116: dup            
        //   117: istore          4
        //   119: ldc             3
        //   121: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   124: ifne            226
        //   127: aload_0        
        //   128: getfield        java/util/zip/InflaterInputStream.inf:Ljava/util/zip/Inflater;
        //   131: ldc             3
        //   133: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   136: invokevirtual   java/util/zip/Inflater.finished:()Z
        //   139: ldc             1
        //   141: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   144: ifne            167
        //   147: aload_0        
        //   148: getfield        java/util/zip/InflaterInputStream.inf:Ljava/util/zip/Inflater;
        //   151: ldc             3
        //   153: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   156: invokevirtual   java/util/zip/Inflater.needsDictionary:()Z
        //   159: ldc             1
        //   161: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   164: ifeq            189
        //   167: aload_0        
        //   168: iconst_1       
        //   169: putfield        java/util/zip/InflaterInputStream.reachEOF:Z
        //   172: ldc             3
        //   174: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   177: iconst_m1      
        //   178: ldc             1
        //   180: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   183: ldc             1
        //   185: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   188: ireturn        
        //   189: aload_0        
        //   190: getfield        java/util/zip/InflaterInputStream.inf:Ljava/util/zip/Inflater;
        //   193: ldc             3
        //   195: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   198: invokevirtual   java/util/zip/Inflater.needsInput:()Z
        //   201: ldc             1
        //   203: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   206: ifeq            101
        //   209: aload_0        
        //   210: ldc             2
        //   212: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   215: invokevirtual   java/util/zip/InflaterInputStream.fill:()V
        //   218: ldc             1
        //   220: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   223: goto            101
        //   226: iload           4
        //   228: ldc             1
        //   230: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   233: ldc             1
        //   235: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   238: ireturn        
        //   239: astore          4
        //   241: ldc             501
        //   243: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   246: aload           4
        //   248: ldc             2
        //   250: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   253: invokevirtual   java/util/zip/DataFormatException.getMessage:()Ljava/lang/String;
        //   256: astore          5
        //   258: ldc             1
        //   260: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   263: new             Ljava/util/zip/ZipException;
        //   266: dup            
        //   267: aload           5
        //   269: ldc             4
        //   271: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   274: ifnull          287
        //   277: aload           5
        //   279: ldc             2
        //   281: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   284: goto            294
        //   287: ldc             "Invalid ZLIB data format"
        //   289: ldc             1
        //   291: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   294: ldc             1
        //   296: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   299: invokespecial   java/util/zip/ZipException.<init>:(Ljava/lang/String;)V
        //   302: ldc             1
        //   304: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   307: athrow         
        //   308: athrow         
        //   309: athrow         
        //    Exceptions:
        //  throws java.io.IOException
        //    StackMapTable: 00 0C 24 1E 11 0F FC 00 41 01 15 24 FF 00 0C 00 04 07 00 02 07 00 73 01 01 00 01 07 00 5F FF 00 2F 00 06 07 00 02 07 00 73 01 01 07 00 5F 07 00 7C 00 02 08 01 07 08 01 07 FF 00 06 00 06 07 00 02 07 00 73 01 01 07 00 5F 07 00 7C 00 03 08 01 07 08 01 07 07 00 7C FF 00 0D 00 00 00 01 07 00 28 FF 00 00 00 00 00 01 07 00 5D
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                               
        //  -----  -----  -----  -----  -----------------------------------
        //  101    309    309    310    Ljava/lang/VirtualMachineError;
        //  101    183    239    308    Ljava/util/zip/DataFormatException;
        //  189    233    239    308    Ljava/util/zip/DataFormatException;
        //  0      308    308    309    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0101:
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
    public int available() throws IOException {
        try {
            BytecodeManager.incBytecodes(2);
            this.ensureOpen();
            final boolean reachEOF = this.reachEOF;
            BytecodeManager.incBytecodes(3);
            if (reachEOF) {
                final int n = 0;
                BytecodeManager.incBytecodes(2);
                return n;
            }
            final int n2 = 1;
            BytecodeManager.incBytecodes(2);
            return n2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public long skip(final long a) throws IOException {
        try {
            final long n = lcmp(a, 0L);
            BytecodeManager.incBytecodes(4);
            if (n < 0) {
                final String s = "negative skip length";
                BytecodeManager.incBytecodes(4);
                final IllegalArgumentException ex = new IllegalArgumentException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(2);
            this.ensureOpen();
            final long b = 2147483647L;
            BytecodeManager.incBytecodes(3);
            final int n2 = (int)Math.min(a, b);
            BytecodeManager.incBytecodes(2);
            int n3 = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n4 = n3;
                final int n5 = n2;
                BytecodeManager.incBytecodes(3);
                if (n4 >= n5) {
                    break;
                }
                int length = n2 - n3;
                BytecodeManager.incBytecodes(4);
                final int n6 = length;
                final int length2 = this.b.length;
                BytecodeManager.incBytecodes(5);
                if (n6 > length2) {
                    length = this.b.length;
                    BytecodeManager.incBytecodes(4);
                }
                final byte[] b2 = this.b;
                final int off = 0;
                final int len = length;
                BytecodeManager.incBytecodes(6);
                final int read = this.read(b2, off, len);
                BytecodeManager.incBytecodes(1);
                final int n7 = read;
                final int n8 = -1;
                BytecodeManager.incBytecodes(3);
                if (n7 == n8) {
                    this.reachEOF = true;
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(1);
                    break;
                }
                n3 += read;
                BytecodeManager.incBytecodes(4);
                BytecodeManager.incBytecodes(1);
            }
            final long n9 = n3;
            BytecodeManager.incBytecodes(3);
            return n9;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void close() throws IOException {
        try {
            final boolean closed = this.closed;
            BytecodeManager.incBytecodes(3);
            if (!closed) {
                final boolean usesDefaultInflater = this.usesDefaultInflater;
                BytecodeManager.incBytecodes(3);
                if (usesDefaultInflater) {
                    final Inflater inf = this.inf;
                    BytecodeManager.incBytecodes(3);
                    inf.end();
                }
                final InputStream in = this.in;
                BytecodeManager.incBytecodes(3);
                in.close();
                this.closed = true;
                BytecodeManager.incBytecodes(3);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    protected void fill() throws IOException {
        try {
            BytecodeManager.incBytecodes(2);
            this.ensureOpen();
            final InputStream in = this.in;
            final byte[] buf = this.buf;
            final int off = 0;
            final int length = this.buf.length;
            BytecodeManager.incBytecodes(10);
            this.len = in.read(buf, off, length);
            BytecodeManager.incBytecodes(1);
            final int len = this.len;
            final int n = -1;
            BytecodeManager.incBytecodes(4);
            if (len == n) {
                final String s = "Unexpected end of ZLIB input stream";
                BytecodeManager.incBytecodes(4);
                final EOFException ex = new EOFException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final Inflater inf = this.inf;
            final byte[] buf2 = this.buf;
            final int off2 = 0;
            final int len2 = this.len;
            BytecodeManager.incBytecodes(8);
            inf.setInput(buf2, off2, len2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean markSupported() {
        try {
            final boolean b = false;
            BytecodeManager.incBytecodes(2);
            return b;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public synchronized void mark(final int n) {
        try {
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public synchronized void reset() throws IOException {
        try {
            final String message = "mark/reset not supported";
            BytecodeManager.incBytecodes(4);
            final IOException ex = new IOException(message);
            BytecodeManager.incBytecodes(1);
            throw ex;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
