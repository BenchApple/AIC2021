// 
// Decompiled by Procyon v0.5.36
// 

package java.util.zip;

import java.io.EOFException;
import java.io.InputStream;
import java.io.IOException;
import aic2021.engine.BytecodeManager;

public class GZIPInputStream extends InflaterInputStream
{
    protected CRC32 crc;
    protected boolean eos;
    private boolean closed;
    public static final int GZIP_MAGIC = 35615;
    private static final int FTEXT = 1;
    private static final int FHCRC = 2;
    private static final int FEXTRA = 4;
    private static final int FNAME = 8;
    private static final int FCOMMENT = 16;
    private byte[] tmpbuf;
    
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
    
    public GZIPInputStream(final InputStream inputStream, final int size) throws IOException {
        try {
            final boolean nowrap = true;
            BytecodeManager.incBytecodes(6);
            final Inflater inf = new Inflater(nowrap);
            BytecodeManager.incBytecodes(2);
            super(inputStream, inf, size);
            BytecodeManager.incBytecodes(4);
            this.crc = new CRC32();
            BytecodeManager.incBytecodes(1);
            this.closed = false;
            BytecodeManager.incBytecodes(3);
            this.tmpbuf = new byte[128];
            BytecodeManager.incBytecodes(3);
            this.usesDefaultInflater = true;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(3);
            this.readHeader(inputStream);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public GZIPInputStream(final InputStream in) throws IOException {
        try {
            final int size = 512;
            BytecodeManager.incBytecodes(4);
            this(in, size);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public int read(final byte[] b, final int off, final int n) throws IOException {
        try {
            BytecodeManager.incBytecodes(2);
            this.ensureOpen();
            final boolean eos = this.eos;
            BytecodeManager.incBytecodes(3);
            if (eos) {
                final int n2 = -1;
                BytecodeManager.incBytecodes(2);
                return n2;
            }
            BytecodeManager.incBytecodes(5);
            final int read = super.read(b, off, n);
            BytecodeManager.incBytecodes(1);
            final int n3 = read;
            final int n4 = -1;
            BytecodeManager.incBytecodes(3);
            if (n3 == n4) {
                BytecodeManager.incBytecodes(2);
                final boolean trailer = this.readTrailer();
                BytecodeManager.incBytecodes(1);
                if (!trailer) {
                    BytecodeManager.incBytecodes(5);
                    final int read2 = this.read(b, off, n);
                    BytecodeManager.incBytecodes(1);
                    return read2;
                }
                this.eos = true;
                BytecodeManager.incBytecodes(4);
            }
            else {
                final CRC32 crc = this.crc;
                final int len = read;
                BytecodeManager.incBytecodes(6);
                crc.update(b, off, len);
            }
            final int n5 = read;
            BytecodeManager.incBytecodes(2);
            return n5;
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
                BytecodeManager.incBytecodes(2);
                super.close();
                this.eos = true;
                BytecodeManager.incBytecodes(3);
                this.closed = true;
                BytecodeManager.incBytecodes(3);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private int readHeader(final InputStream inputStream) throws IOException {
        try {
            final CRC32 crc = this.crc;
            BytecodeManager.incBytecodes(6);
            final CheckedInputStream checkedInputStream = new CheckedInputStream(inputStream, crc);
            BytecodeManager.incBytecodes(1);
            final CRC32 crc2 = this.crc;
            BytecodeManager.incBytecodes(3);
            crc2.reset();
            final CheckedInputStream in = checkedInputStream;
            BytecodeManager.incBytecodes(3);
            final int uShort = this.readUShort(in);
            final int n = 35615;
            BytecodeManager.incBytecodes(2);
            if (uShort != n) {
                final String s = "Not in GZIP format";
                BytecodeManager.incBytecodes(4);
                final ZipException ex = new ZipException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final CheckedInputStream in2 = checkedInputStream;
            BytecodeManager.incBytecodes(3);
            final int uByte = this.readUByte(in2);
            final int n2 = 8;
            BytecodeManager.incBytecodes(2);
            if (uByte != n2) {
                final String s2 = "Unsupported compression method";
                BytecodeManager.incBytecodes(4);
                final ZipException ex2 = new ZipException(s2);
                BytecodeManager.incBytecodes(1);
                throw ex2;
            }
            final CheckedInputStream in3 = checkedInputStream;
            BytecodeManager.incBytecodes(3);
            final int uByte2 = this.readUByte(in3);
            BytecodeManager.incBytecodes(1);
            final CheckedInputStream in4 = checkedInputStream;
            final int n3 = 6;
            BytecodeManager.incBytecodes(4);
            this.skipBytes(in4, n3);
            int n4 = 10;
            BytecodeManager.incBytecodes(2);
            final int n5 = uByte2 & 0x4;
            final int n6 = 4;
            BytecodeManager.incBytecodes(5);
            if (n5 == n6) {
                final CheckedInputStream in5 = checkedInputStream;
                BytecodeManager.incBytecodes(3);
                final int uShort2 = this.readUShort(in5);
                BytecodeManager.incBytecodes(1);
                final CheckedInputStream in6 = checkedInputStream;
                final int n7 = uShort2;
                BytecodeManager.incBytecodes(4);
                this.skipBytes(in6, n7);
                n4 += uShort2 + 2;
                BytecodeManager.incBytecodes(6);
            }
            final int n8 = uByte2 & 0x8;
            final int n9 = 8;
            BytecodeManager.incBytecodes(5);
            if (n8 == n9) {
                int i;
                do {
                    ++n4;
                    BytecodeManager.incBytecodes(1);
                    final CheckedInputStream in7 = checkedInputStream;
                    BytecodeManager.incBytecodes(3);
                    i = this.readUByte(in7);
                    BytecodeManager.incBytecodes(1);
                } while (i != 0);
            }
            final int n10 = uByte2 & 0x10;
            final int n11 = 16;
            BytecodeManager.incBytecodes(5);
            if (n10 == n11) {
                int j;
                do {
                    ++n4;
                    BytecodeManager.incBytecodes(1);
                    final CheckedInputStream in8 = checkedInputStream;
                    BytecodeManager.incBytecodes(3);
                    j = this.readUByte(in8);
                    BytecodeManager.incBytecodes(1);
                } while (j != 0);
            }
            final int n12 = uByte2 & 0x2;
            final int n13 = 2;
            BytecodeManager.incBytecodes(5);
            if (n12 == n13) {
                final CRC32 crc3 = this.crc;
                BytecodeManager.incBytecodes(3);
                final int n14 = (int)crc3.getValue() & 0xFFFF;
                BytecodeManager.incBytecodes(4);
                final CheckedInputStream in9 = checkedInputStream;
                BytecodeManager.incBytecodes(3);
                final int uShort3 = this.readUShort(in9);
                final int n15 = n14;
                BytecodeManager.incBytecodes(2);
                if (uShort3 != n15) {
                    final String s3 = "Corrupt GZIP header";
                    BytecodeManager.incBytecodes(4);
                    final ZipException ex3 = new ZipException(s3);
                    BytecodeManager.incBytecodes(1);
                    throw ex3;
                }
                n4 += 2;
                BytecodeManager.incBytecodes(1);
            }
            final CRC32 crc4 = this.crc;
            BytecodeManager.incBytecodes(3);
            crc4.reset();
            final int n16 = n4;
            BytecodeManager.incBytecodes(2);
            return n16;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private boolean readTrailer() throws IOException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        java/util/zip/GZIPInputStream.in:Ljava/io/InputStream;
        //     4: astore_1       
        //     5: ldc             3
        //     7: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    10: aload_0        
        //    11: getfield        java/util/zip/GZIPInputStream.inf:Ljava/util/zip/Inflater;
        //    14: ldc             3
        //    16: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    19: invokevirtual   java/util/zip/Inflater.getRemaining:()I
        //    22: istore_2       
        //    23: ldc             1
        //    25: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    28: iload_2        
        //    29: ldc             2
        //    31: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    34: ifle            92
        //    37: new             Ljava/io/SequenceInputStream;
        //    40: dup            
        //    41: new             Ljava/io/ByteArrayInputStream;
        //    44: dup            
        //    45: aload_0        
        //    46: getfield        java/util/zip/GZIPInputStream.buf:[B
        //    49: aload_0        
        //    50: getfield        java/util/zip/GZIPInputStream.len:I
        //    53: iload_2        
        //    54: isub           
        //    55: iload_2        
        //    56: ldc             12
        //    58: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    61: invokespecial   java/io/ByteArrayInputStream.<init>:([BII)V
        //    64: new             Ljava/util/zip/GZIPInputStream$1;
        //    67: dup            
        //    68: aload_0        
        //    69: aload_1        
        //    70: ldc             5
        //    72: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    75: invokespecial   java/util/zip/GZIPInputStream$1.<init>:(Ljava/util/zip/GZIPInputStream;Ljava/io/InputStream;)V
        //    78: ldc             1
        //    80: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    83: invokespecial   java/io/SequenceInputStream.<init>:(Ljava/io/InputStream;Ljava/io/InputStream;)V
        //    86: astore_1       
        //    87: ldc             1
        //    89: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    92: aload_0        
        //    93: aload_1        
        //    94: ldc             3
        //    96: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    99: invokespecial   java/util/zip/GZIPInputStream.readUInt:(Ljava/io/InputStream;)J
        //   102: aload_0        
        //   103: getfield        java/util/zip/GZIPInputStream.crc:Ljava/util/zip/CRC32;
        //   106: ldc             3
        //   108: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   111: invokevirtual   java/util/zip/CRC32.getValue:()J
        //   114: lcmp           
        //   115: ldc             2
        //   117: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   120: ifne            163
        //   123: aload_0        
        //   124: aload_1        
        //   125: ldc             2
        //   127: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   130: ldc             1
        //   132: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   135: invokespecial   java/util/zip/GZIPInputStream.readUInt:(Ljava/io/InputStream;)J
        //   138: aload_0        
        //   139: getfield        java/util/zip/GZIPInputStream.inf:Ljava/util/zip/Inflater;
        //   142: ldc             3
        //   144: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   147: invokevirtual   java/util/zip/Inflater.getBytesWritten:()J
        //   150: ldc2_w          4294967295
        //   153: land           
        //   154: lcmp           
        //   155: ldc             4
        //   157: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   160: ifeq            183
        //   163: new             Ljava/util/zip/ZipException;
        //   166: dup            
        //   167: ldc             "Corrupt GZIP trailer"
        //   169: ldc             4
        //   171: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   174: invokespecial   java/util/zip/ZipException.<init>:(Ljava/lang/String;)V
        //   177: ldc             1
        //   179: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   182: athrow         
        //   183: aload_0        
        //   184: getfield        java/util/zip/GZIPInputStream.in:Ljava/io/InputStream;
        //   187: ldc             3
        //   189: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   192: invokevirtual   java/io/InputStream.available:()I
        //   195: ldc             1
        //   197: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   200: ifgt            214
        //   203: iload_2        
        //   204: bipush          26
        //   206: ldc             3
        //   208: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   211: if_icmple       318
        //   214: bipush          8
        //   216: istore_3       
        //   217: ldc             2
        //   219: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   222: iload_3        
        //   223: aload_0        
        //   224: aload_1        
        //   225: ldc             4
        //   227: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   230: invokespecial   java/util/zip/GZIPInputStream.readHeader:(Ljava/io/InputStream;)I
        //   233: iadd           
        //   234: istore_3       
        //   235: ldc             2
        //   237: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   240: ldc             1
        //   242: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   245: goto            262
        //   248: astore          4
        //   250: ldc             501
        //   252: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   255: iconst_1       
        //   256: ldc             2
        //   258: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   261: ireturn        
        //   262: aload_0        
        //   263: getfield        java/util/zip/GZIPInputStream.inf:Ljava/util/zip/Inflater;
        //   266: ldc             3
        //   268: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   271: invokevirtual   java/util/zip/Inflater.reset:()V
        //   274: iload_2        
        //   275: iload_3        
        //   276: ldc             3
        //   278: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   281: if_icmple       311
        //   284: aload_0        
        //   285: getfield        java/util/zip/GZIPInputStream.inf:Ljava/util/zip/Inflater;
        //   288: aload_0        
        //   289: getfield        java/util/zip/GZIPInputStream.buf:[B
        //   292: aload_0        
        //   293: getfield        java/util/zip/GZIPInputStream.len:I
        //   296: iload_2        
        //   297: isub           
        //   298: iload_3        
        //   299: iadd           
        //   300: iload_2        
        //   301: iload_3        
        //   302: isub           
        //   303: ldc             14
        //   305: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   308: invokevirtual   java/util/zip/Inflater.setInput:([BII)V
        //   311: iconst_0       
        //   312: ldc             2
        //   314: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   317: ireturn        
        //   318: iconst_1       
        //   319: ldc             2
        //   321: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   324: ireturn        
        //   325: athrow         
        //   326: athrow         
        //    Exceptions:
        //  throws java.io.IOException
        //    StackMapTable: 00 0A FD 00 5C 07 00 A3 01 FB 00 46 13 1E FF 00 21 00 04 07 00 02 07 00 A3 01 01 00 01 07 00 1F 0D 30 FA 00 06 FF 00 06 00 00 00 01 07 00 30 FF 00 00 00 00 00 01 07 00 82
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  222    326    326    327    Ljava/lang/VirtualMachineError;
        //  222    240    248    262    Ljava/io/IOException;
        //  0      325    325    326    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0262:
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
    
    private long readUInt(final InputStream inputStream) throws IOException {
        try {
            BytecodeManager.incBytecodes(3);
            final long n = this.readUShort(inputStream);
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(3);
            final long n2 = (long)this.readUShort(inputStream) << 16 | n;
            BytecodeManager.incBytecodes(6);
            return n2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private int readUShort(final InputStream inputStream) throws IOException {
        try {
            BytecodeManager.incBytecodes(3);
            final int uByte = this.readUByte(inputStream);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            final int n = this.readUByte(inputStream) << 8 | uByte;
            BytecodeManager.incBytecodes(5);
            return n;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private int readUByte(final InputStream inputStream) throws IOException {
        try {
            BytecodeManager.incBytecodes(2);
            final int read = inputStream.read();
            BytecodeManager.incBytecodes(1);
            final int n = read;
            final int n2 = -1;
            BytecodeManager.incBytecodes(3);
            if (n == n2) {
                BytecodeManager.incBytecodes(3);
                final EOFException ex = new EOFException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final int n3 = read;
            final int n4 = -1;
            BytecodeManager.incBytecodes(3);
            if (n3 >= n4) {
                final int n5 = read;
                final int n6 = 255;
                BytecodeManager.incBytecodes(3);
                if (n5 <= n6) {
                    final int n7 = read;
                    BytecodeManager.incBytecodes(2);
                    return n7;
                }
            }
            BytecodeManager.incBytecodes(5);
            final StringBuilder sb = new StringBuilder();
            final InputStream in = this.in;
            BytecodeManager.incBytecodes(3);
            final Class<? extends InputStream> class1 = in.getClass();
            BytecodeManager.incBytecodes(1);
            final String name = class1.getName();
            BytecodeManager.incBytecodes(1);
            final StringBuilder append = sb.append(name);
            final String str = ".read() returned value out of range -1..255: ";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append2 = append.append(str);
            final int i = read;
            BytecodeManager.incBytecodes(2);
            final StringBuilder append3 = append2.append(i);
            BytecodeManager.incBytecodes(1);
            final String string = append3.toString();
            BytecodeManager.incBytecodes(1);
            final IOException ex2 = new IOException(string);
            BytecodeManager.incBytecodes(1);
            throw ex2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void skipBytes(final InputStream inputStream, int n) throws IOException {
        try {
            while (true) {
                final int n2 = n;
                BytecodeManager.incBytecodes(2);
                if (n2 <= 0) {
                    BytecodeManager.incBytecodes(1);
                    return;
                }
                final byte[] tmpbuf = this.tmpbuf;
                final int off = 0;
                final int n3 = n;
                final int length = this.tmpbuf.length;
                BytecodeManager.incBytecodes(9);
                int length2;
                if (n3 < length) {
                    length2 = n;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    length2 = this.tmpbuf.length;
                    BytecodeManager.incBytecodes(3);
                }
                BytecodeManager.incBytecodes(1);
                final int read = inputStream.read(tmpbuf, off, length2);
                BytecodeManager.incBytecodes(1);
                final int n4 = read;
                final int n5 = -1;
                BytecodeManager.incBytecodes(3);
                if (n4 == n5) {
                    BytecodeManager.incBytecodes(3);
                    final EOFException ex = new EOFException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                n -= read;
                BytecodeManager.incBytecodes(4);
                BytecodeManager.incBytecodes(1);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
