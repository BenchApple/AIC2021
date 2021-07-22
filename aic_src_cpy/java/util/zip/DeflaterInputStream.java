// 
// Decompiled by Procyon v0.5.36
// 

package java.util.zip;

import java.io.InputStream;
import java.io.IOException;
import aic2021.engine.BytecodeManager;
import java.io.FilterInputStream;

public class DeflaterInputStream extends FilterInputStream
{
    protected final Deflater def;
    protected final byte[] buf;
    private byte[] rbuf;
    private boolean usesDefaultDeflater;
    private boolean reachEOF;
    
    private void ensureOpen() throws IOException {
        try {
            final InputStream in = this.in;
            BytecodeManager.incBytecodes(3);
            if (in == null) {
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
    
    public DeflaterInputStream(final InputStream inputStream) {
        try {
            BytecodeManager.incBytecodes(5);
            final Deflater deflater = new Deflater();
            BytecodeManager.incBytecodes(1);
            this(inputStream, deflater);
            this.usesDefaultDeflater = true;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public DeflaterInputStream(final InputStream inputStream, final Deflater deflater) {
        try {
            final int n = 512;
            BytecodeManager.incBytecodes(5);
            this(inputStream, deflater, n);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public DeflaterInputStream(final InputStream in, final Deflater def, final int n) {
        try {
            BytecodeManager.incBytecodes(3);
            super(in);
            this.rbuf = new byte[1];
            BytecodeManager.incBytecodes(3);
            this.usesDefaultDeflater = false;
            BytecodeManager.incBytecodes(3);
            this.reachEOF = false;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(2);
            if (in == null) {
                final String s = "Null input";
                BytecodeManager.incBytecodes(4);
                final NullPointerException ex = new NullPointerException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(2);
            if (def == null) {
                final String s2 = "Null deflater";
                BytecodeManager.incBytecodes(4);
                final NullPointerException ex2 = new NullPointerException(s2);
                BytecodeManager.incBytecodes(1);
                throw ex2;
            }
            final int n2 = 1;
            BytecodeManager.incBytecodes(3);
            if (n < n2) {
                final String s3 = "Buffer size < 1";
                BytecodeManager.incBytecodes(4);
                final IllegalArgumentException ex3 = new IllegalArgumentException(s3);
                BytecodeManager.incBytecodes(1);
                throw ex3;
            }
            this.def = def;
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
        //     1: getfield        java/util/zip/DeflaterInputStream.in:Ljava/io/InputStream;
        //     4: ldc             3
        //     6: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     9: ifnull          79
        //    12: aload_0        
        //    13: getfield        java/util/zip/DeflaterInputStream.usesDefaultDeflater:Z
        //    16: ldc             3
        //    18: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    21: ifeq            36
        //    24: aload_0        
        //    25: getfield        java/util/zip/DeflaterInputStream.def:Ljava/util/zip/Deflater;
        //    28: ldc             3
        //    30: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    33: invokevirtual   java/util/zip/Deflater.end:()V
        //    36: aload_0        
        //    37: getfield        java/util/zip/DeflaterInputStream.in:Ljava/io/InputStream;
        //    40: ldc             3
        //    42: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    45: invokevirtual   java/io/InputStream.close:()V
        //    48: aload_0        
        //    49: aconst_null    
        //    50: putfield        java/util/zip/DeflaterInputStream.in:Ljava/io/InputStream;
        //    53: ldc             3
        //    55: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    58: ldc             1
        //    60: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    63: goto            79
        //    66: astore_1       
        //    67: aload_0        
        //    68: aconst_null    
        //    69: putfield        java/util/zip/DeflaterInputStream.in:Ljava/io/InputStream;
        //    72: aload_1        
        //    73: ldc             506
        //    75: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    78: athrow         
        //    79: ldc             1
        //    81: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    84: return         
        //    85: athrow         
        //    86: athrow         
        //    Exceptions:
        //  throws java.io.IOException
        //    StackMapTable: 00 05 24 5D 07 00 26 0C FF 00 05 00 00 00 01 07 00 26 FF 00 00 00 00 00 01 07 00 50
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  12     86     86     87     Ljava/lang/VirtualMachineError;
        //  12     48     66     79     Any
        //  0      85     85     86     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0036:
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
    public int read() throws IOException {
        try {
            final byte[] rbuf = this.rbuf;
            final int n = 0;
            final int n2 = 1;
            BytecodeManager.incBytecodes(6);
            final int read = this.read(rbuf, n, n2);
            BytecodeManager.incBytecodes(1);
            final int n3 = read;
            BytecodeManager.incBytecodes(2);
            if (n3 <= 0) {
                final int n4 = -1;
                BytecodeManager.incBytecodes(2);
                return n4;
            }
            final int n5 = this.rbuf[0] & 0xFF;
            BytecodeManager.incBytecodes(7);
            return n5;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public int read(final byte[] output, int n, int n2) throws IOException {
        try {
            BytecodeManager.incBytecodes(2);
            this.ensureOpen();
            BytecodeManager.incBytecodes(2);
            if (output == null) {
                final String s = "Null buffer for read";
                BytecodeManager.incBytecodes(4);
                final NullPointerException ex = new NullPointerException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final int n3 = n;
            BytecodeManager.incBytecodes(2);
            if (n3 >= 0) {
                final int n4 = n2;
                BytecodeManager.incBytecodes(2);
                if (n4 >= 0) {
                    final int n5 = n2;
                    final int n6 = output.length - n;
                    BytecodeManager.incBytecodes(6);
                    if (n5 <= n6) {
                        final boolean b = n2 != 0;
                        BytecodeManager.incBytecodes(2);
                        if (!b) {
                            final int n7 = 0;
                            BytecodeManager.incBytecodes(2);
                            return n7;
                        }
                        int n8 = 0;
                        BytecodeManager.incBytecodes(2);
                        while (true) {
                            final int n9 = n2;
                            BytecodeManager.incBytecodes(2);
                            if (n9 <= 0) {
                                break;
                            }
                            final Deflater def = this.def;
                            BytecodeManager.incBytecodes(3);
                            final boolean finished = def.finished();
                            BytecodeManager.incBytecodes(1);
                            if (finished) {
                                break;
                            }
                            final Deflater def2 = this.def;
                            BytecodeManager.incBytecodes(3);
                            final boolean needsInput = def2.needsInput();
                            BytecodeManager.incBytecodes(1);
                            if (needsInput) {
                                final InputStream in = this.in;
                                final byte[] buf = this.buf;
                                final int off = 0;
                                final int length = this.buf.length;
                                BytecodeManager.incBytecodes(9);
                                final int read = in.read(buf, off, length);
                                BytecodeManager.incBytecodes(1);
                                final int n10 = read;
                                BytecodeManager.incBytecodes(2);
                                if (n10 < 0) {
                                    final Deflater def3 = this.def;
                                    BytecodeManager.incBytecodes(3);
                                    def3.finish();
                                    BytecodeManager.incBytecodes(1);
                                }
                                else {
                                    final int n11 = read;
                                    BytecodeManager.incBytecodes(2);
                                    if (n11 > 0) {
                                        final Deflater def4 = this.def;
                                        final byte[] buf2 = this.buf;
                                        final int off2 = 0;
                                        final int len = read;
                                        BytecodeManager.incBytecodes(7);
                                        def4.setInput(buf2, off2, len);
                                    }
                                }
                            }
                            final Deflater def5 = this.def;
                            final int off3 = n;
                            final int len2 = n2;
                            BytecodeManager.incBytecodes(6);
                            final int deflate = def5.deflate(output, off3, len2);
                            BytecodeManager.incBytecodes(1);
                            n8 += deflate;
                            BytecodeManager.incBytecodes(4);
                            n += deflate;
                            BytecodeManager.incBytecodes(4);
                            n2 -= deflate;
                            BytecodeManager.incBytecodes(4);
                            BytecodeManager.incBytecodes(1);
                        }
                        final int n12 = n8;
                        BytecodeManager.incBytecodes(2);
                        if (n12 == 0) {
                            final Deflater def6 = this.def;
                            BytecodeManager.incBytecodes(3);
                            final boolean finished2 = def6.finished();
                            BytecodeManager.incBytecodes(1);
                            if (finished2) {
                                this.reachEOF = true;
                                BytecodeManager.incBytecodes(3);
                                n8 = -1;
                                BytecodeManager.incBytecodes(2);
                            }
                        }
                        final int n13 = n8;
                        BytecodeManager.incBytecodes(2);
                        return n13;
                    }
                }
            }
            BytecodeManager.incBytecodes(3);
            final IndexOutOfBoundsException ex2 = new IndexOutOfBoundsException();
            BytecodeManager.incBytecodes(1);
            throw ex2;
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
            final int length = this.rbuf.length;
            final int n2 = 512;
            BytecodeManager.incBytecodes(5);
            if (length < n2) {
                this.rbuf = new byte[512];
                BytecodeManager.incBytecodes(3);
            }
            final long b = 2147483647L;
            BytecodeManager.incBytecodes(3);
            int n3 = (int)Math.min(a, b);
            BytecodeManager.incBytecodes(2);
            long n4 = 0L;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n5 = n3;
                BytecodeManager.incBytecodes(2);
                if (n5 <= 0) {
                    break;
                }
                final byte[] rbuf = this.rbuf;
                final int n6 = 0;
                final int n7 = n3;
                final int length2 = this.rbuf.length;
                BytecodeManager.incBytecodes(9);
                int length3;
                if (n7 <= length2) {
                    length3 = n3;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    length3 = this.rbuf.length;
                    BytecodeManager.incBytecodes(3);
                }
                BytecodeManager.incBytecodes(1);
                final int read = this.read(rbuf, n6, length3);
                BytecodeManager.incBytecodes(1);
                final int n8 = read;
                BytecodeManager.incBytecodes(2);
                if (n8 < 0) {
                    BytecodeManager.incBytecodes(1);
                    break;
                }
                n4 += read;
                BytecodeManager.incBytecodes(5);
                n3 -= read;
                BytecodeManager.incBytecodes(4);
                BytecodeManager.incBytecodes(1);
            }
            final long n9 = n4;
            BytecodeManager.incBytecodes(2);
            return n9;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
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
    public void mark(final int n) {
        try {
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void reset() throws IOException {
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
