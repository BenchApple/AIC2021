// 
// Decompiled by Procyon v0.5.36
// 

package java.util.zip;

import java.io.EOFException;
import jdk.internal.ref.CleanerFactory;
import java.lang.ref.Cleaner;
import sun.misc.SharedSecrets;
import java.util.jar.JarEntry;
import java.util.function.Function;
import jdk.internal.access.JavaUtilZipFileAccess;
import sun.misc.VM;
import instrumented.java.util.Spliterator;
import instrumented.java.util.stream.StreamSupport;
import java.util.Iterator;
import instrumented.java.util.Spliterators;
import instrumented.java.util.stream.Stream;
import instrumented.java.util.Enumeration;
import sun.misc.PerfCounter;
import instrumented.java.util.ArrayDeque;
import instrumented.java.util.WeakHashMap;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.io.IOException;
import java.io.File;
import aic2021.engine.BytecodeManager;
import instrumented.java.util.Deque;
import java.io.InputStream;
import instrumented.java.util.Map;
import java.io.Closeable;

public class ZipFile implements ZipConstants, Closeable
{
    private long jzfile;
    private final String name;
    private final int total;
    private final boolean locsig;
    private volatile boolean closeRequested;
    private static final int STORED = 0;
    private static final int DEFLATED = 8;
    public static final int OPEN_READ = 1;
    public static final int OPEN_DELETE = 4;
    private static final boolean usemmap;
    private ZipCoder zc;
    private final Map<InputStream, Inflater> streams;
    private Deque<Inflater> inflaterCache;
    private static final int JZENTRY_NAME = 0;
    private static final int JZENTRY_EXTRA = 1;
    private static final int JZENTRY_COMMENT = 2;
    
    private static native void initIDs();
    
    public ZipFile(final String pathname) throws IOException {
        try {
            BytecodeManager.incBytecodes(5);
            final File file = new File(pathname);
            final int mode = 1;
            BytecodeManager.incBytecodes(2);
            this(file, mode);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public ZipFile(final File file, final int mode) throws IOException {
        try {
            final Charset utf_8 = StandardCharsets.UTF_8;
            BytecodeManager.incBytecodes(5);
            this(file, mode, utf_8);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public ZipFile(final File file) throws ZipException, IOException {
        try {
            final int mode = 1;
            BytecodeManager.incBytecodes(4);
            this(file, mode);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public ZipFile(final File file, final int i, final Charset charset) throws IOException {
        try {
            BytecodeManager.incBytecodes(2);
            this.closeRequested = false;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(4);
            this.streams = new WeakHashMap();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(4);
            this.inflaterCache = new ArrayDeque();
            BytecodeManager.incBytecodes(1);
            final int n = i & 0x1;
            BytecodeManager.incBytecodes(4);
            if (n != 0) {
                final int n2 = i & 0xFFFFFFFA;
                BytecodeManager.incBytecodes(4);
                if (n2 == 0) {
                    BytecodeManager.incBytecodes(2);
                    final String path = file.getPath();
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    final SecurityManager securityManager = System.getSecurityManager();
                    BytecodeManager.incBytecodes(1);
                    final SecurityManager securityManager2 = securityManager;
                    BytecodeManager.incBytecodes(2);
                    if (securityManager2 != null) {
                        final SecurityManager securityManager3 = securityManager;
                        final String file2 = path;
                        BytecodeManager.incBytecodes(3);
                        securityManager3.checkRead(file2);
                        final int n3 = i & 0x4;
                        BytecodeManager.incBytecodes(4);
                        if (n3 != 0) {
                            final SecurityManager securityManager4 = securityManager;
                            final String file3 = path;
                            BytecodeManager.incBytecodes(3);
                            securityManager4.checkDelete(file3);
                        }
                    }
                    BytecodeManager.incBytecodes(2);
                    if (charset == null) {
                        final String s = "charset is null";
                        BytecodeManager.incBytecodes(4);
                        final NullPointerException ex = new NullPointerException(s);
                        BytecodeManager.incBytecodes(1);
                        throw ex;
                    }
                    BytecodeManager.incBytecodes(3);
                    this.zc = ZipCoder.get(charset);
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    final long nanoTime = System.nanoTime();
                    BytecodeManager.incBytecodes(1);
                    final String s2 = path;
                    BytecodeManager.incBytecodes(5);
                    final long lastModified = file.lastModified();
                    final boolean usemmap = ZipFile.usemmap;
                    BytecodeManager.incBytecodes(2);
                    this.jzfile = open(s2, i, lastModified, usemmap);
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    final PerfCounter zipFileOpenTime = PerfCounter.getZipFileOpenTime();
                    final long n4 = nanoTime;
                    BytecodeManager.incBytecodes(2);
                    zipFileOpenTime.addElapsedTimeFrom(n4);
                    BytecodeManager.incBytecodes(1);
                    final PerfCounter zipFileCount = PerfCounter.getZipFileCount();
                    BytecodeManager.incBytecodes(1);
                    zipFileCount.increment();
                    this.name = path;
                    BytecodeManager.incBytecodes(3);
                    final long jzfile = this.jzfile;
                    BytecodeManager.incBytecodes(4);
                    this.total = getTotal(jzfile);
                    BytecodeManager.incBytecodes(1);
                    final long jzfile2 = this.jzfile;
                    BytecodeManager.incBytecodes(4);
                    this.locsig = startsWithLOC(jzfile2);
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    return;
                }
            }
            BytecodeManager.incBytecodes(5);
            final StringBuilder sb = new StringBuilder();
            final String str = "Illegal mode: 0x";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append = sb.append(str);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
            final String hexString = Integer.toHexString(i);
            BytecodeManager.incBytecodes(1);
            final StringBuilder append2 = append.append(hexString);
            BytecodeManager.incBytecodes(1);
            final String string = append2.toString();
            BytecodeManager.incBytecodes(1);
            final IllegalArgumentException ex2 = new IllegalArgumentException(string);
            BytecodeManager.incBytecodes(1);
            throw ex2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public ZipFile(final String pathname, final Charset charset) throws IOException {
        try {
            BytecodeManager.incBytecodes(5);
            final File file = new File(pathname);
            final int mode = 1;
            BytecodeManager.incBytecodes(3);
            this(file, mode, charset);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public ZipFile(final File file, final Charset charset) throws IOException {
        try {
            final int mode = 1;
            BytecodeManager.incBytecodes(5);
            this(file, mode, charset);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public String getComment() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: dup            
        //     2: astore_1       
        //     3: pop            
        //     4: ldc             4
        //     6: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     9: aload_0        
        //    10: ldc             2
        //    12: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    15: invokespecial   java/util/zip/ZipFile.ensureOpen:()V
        //    18: aload_0        
        //    19: getfield        java/util/zip/ZipFile.jzfile:J
        //    22: ldc             3
        //    24: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    27: invokestatic    java/util/zip/ZipFile.getCommentBytes:(J)[B
        //    30: astore_2       
        //    31: ldc             1
        //    33: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    36: aload_2        
        //    37: ldc             2
        //    39: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    42: ifnonnull       59
        //    45: aconst_null    
        //    46: aload_1        
        //    47: pop            
        //    48: ldc             3
        //    50: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    53: ldc             1
        //    55: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    58: areturn        
        //    59: aload_0        
        //    60: getfield        java/util/zip/ZipFile.zc:Ljava/util/zip/ZipCoder;
        //    63: aload_2        
        //    64: aload_2        
        //    65: arraylength    
        //    66: ldc             6
        //    68: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    71: invokevirtual   java/util/zip/ZipCoder.toString:([BI)Ljava/lang/String;
        //    74: aload_1        
        //    75: pop            
        //    76: ldc             2
        //    78: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    81: ldc             1
        //    83: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    86: areturn        
        //    87: astore_3       
        //    88: aload_1        
        //    89: pop            
        //    90: ldc             503
        //    92: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    95: aload_3        
        //    96: ldc             2
        //    98: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   101: athrow         
        //   102: athrow         
        //   103: athrow         
        //    StackMapTable: 00 04 FD 00 3B 07 00 04 07 00 DB FF 00 1B 00 02 07 00 02 07 00 04 00 01 07 00 4D FF 00 0E 00 00 00 01 07 00 4D FF 00 00 00 00 00 01 07 00 D2
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  9      103    103    104    Ljava/lang/VirtualMachineError;
        //  9      53     87     102    Any
        //  59     81     87     102    Any
        //  87     95     87     102    Any
        //  0      102    102    103    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0059:
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
    
    public ZipEntry getEntry(final String p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             2
        //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     6: ifnonnull       29
        //     9: new             Ljava/lang/NullPointerException;
        //    12: dup            
        //    13: ldc             "name"
        //    15: ldc             4
        //    17: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    20: invokespecial   java/lang/NullPointerException.<init>:(Ljava/lang/String;)V
        //    23: ldc             1
        //    25: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    28: athrow         
        //    29: lconst_0       
        //    30: lstore_2       
        //    31: ldc             2
        //    33: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    36: aload_0        
        //    37: dup            
        //    38: astore          4
        //    40: pop            
        //    41: ldc             4
        //    43: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    46: aload_0        
        //    47: ldc             2
        //    49: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    52: invokespecial   java/util/zip/ZipFile.ensureOpen:()V
        //    55: aload_0        
        //    56: getfield        java/util/zip/ZipFile.jzfile:J
        //    59: aload_0        
        //    60: getfield        java/util/zip/ZipFile.zc:Ljava/util/zip/ZipCoder;
        //    63: aload_1        
        //    64: ldc             6
        //    66: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    69: invokevirtual   java/util/zip/ZipCoder.getBytes:(Ljava/lang/String;)[B
        //    72: iconst_1       
        //    73: ldc             2
        //    75: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    78: invokestatic    java/util/zip/ZipFile.getEntry:(J[BZ)J
        //    81: lstore_2       
        //    82: ldc             1
        //    84: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    87: lload_2        
        //    88: lconst_0       
        //    89: lcmp           
        //    90: ldc             4
        //    92: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    95: ifeq            145
        //    98: aload_0        
        //    99: aload_1        
        //   100: lload_2        
        //   101: ldc             4
        //   103: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   106: invokespecial   java/util/zip/ZipFile.getZipEntry:(Ljava/lang/String;J)Ljava/util/zip/ZipEntry;
        //   109: astore          5
        //   111: ldc             1
        //   113: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   116: aload_0        
        //   117: getfield        java/util/zip/ZipFile.jzfile:J
        //   120: lload_2        
        //   121: ldc             4
        //   123: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   126: invokestatic    java/util/zip/ZipFile.freeEntry:(JJ)V
        //   129: aload           5
        //   131: aload           4
        //   133: pop            
        //   134: ldc             3
        //   136: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   139: ldc             1
        //   141: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   144: areturn        
        //   145: aload           4
        //   147: pop            
        //   148: ldc             2
        //   150: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   153: ldc             1
        //   155: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   158: goto            179
        //   161: astore          6
        //   163: aload           4
        //   165: pop            
        //   166: ldc             503
        //   168: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   171: aload           6
        //   173: ldc             2
        //   175: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   178: athrow         
        //   179: aconst_null    
        //   180: ldc             2
        //   182: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   185: areturn        
        //   186: athrow         
        //   187: athrow         
        //    StackMapTable: 00 06 1D FD 00 73 04 07 00 04 4F 07 00 4D FA 00 11 FF 00 06 00 00 00 01 07 00 4D FF 00 00 00 00 00 01 07 00 D2
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  46     187    187    188    Ljava/lang/VirtualMachineError;
        //  46     139    161    179    Any
        //  145    153    161    179    Any
        //  161    171    161    179    Any
        //  0      186    186    187    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0145:
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
    
    private static native long getEntry(final long p0, final byte[] p1, final boolean p2);
    
    private static native void freeEntry(final long p0, final long p1);
    
    public InputStream getInputStream(final ZipEntry p0) throws IOException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             2
        //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     6: ifnonnull       29
        //     9: new             Ljava/lang/NullPointerException;
        //    12: dup            
        //    13: ldc             "entry"
        //    15: ldc             4
        //    17: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    20: invokespecial   java/lang/NullPointerException.<init>:(Ljava/lang/String;)V
        //    23: ldc             1
        //    25: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    28: athrow         
        //    29: lconst_0       
        //    30: lstore_2       
        //    31: ldc             2
        //    33: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    36: aconst_null    
        //    37: astore          4
        //    39: ldc             2
        //    41: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    44: aload_0        
        //    45: dup            
        //    46: astore          5
        //    48: pop            
        //    49: ldc             4
        //    51: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    54: aload_0        
        //    55: ldc             2
        //    57: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    60: invokespecial   java/util/zip/ZipFile.ensureOpen:()V
        //    63: aload_0        
        //    64: getfield        java/util/zip/ZipFile.zc:Ljava/util/zip/ZipCoder;
        //    67: ldc             3
        //    69: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    72: invokevirtual   java/util/zip/ZipCoder.isUTF8:()Z
        //    75: ldc             1
        //    77: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    80: ifne            138
        //    83: aload_1        
        //    84: getfield        java/util/zip/ZipEntry.flag:I
        //    87: sipush          2048
        //    90: iand           
        //    91: ldc             5
        //    93: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    96: ifeq            138
        //    99: aload_0        
        //   100: getfield        java/util/zip/ZipFile.jzfile:J
        //   103: aload_0        
        //   104: getfield        java/util/zip/ZipFile.zc:Ljava/util/zip/ZipCoder;
        //   107: aload_1        
        //   108: getfield        java/util/zip/ZipEntry.name:Ljava/lang/String;
        //   111: ldc_w           7
        //   114: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   117: invokevirtual   java/util/zip/ZipCoder.getBytesUTF8:(Ljava/lang/String;)[B
        //   120: iconst_0       
        //   121: ldc             2
        //   123: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   126: invokestatic    java/util/zip/ZipFile.getEntry:(J[BZ)J
        //   129: lstore_2       
        //   130: ldc             2
        //   132: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   135: goto            174
        //   138: aload_0        
        //   139: getfield        java/util/zip/ZipFile.jzfile:J
        //   142: aload_0        
        //   143: getfield        java/util/zip/ZipFile.zc:Ljava/util/zip/ZipCoder;
        //   146: aload_1        
        //   147: getfield        java/util/zip/ZipEntry.name:Ljava/lang/String;
        //   150: ldc_w           7
        //   153: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   156: invokevirtual   java/util/zip/ZipCoder.getBytes:(Ljava/lang/String;)[B
        //   159: iconst_0       
        //   160: ldc             2
        //   162: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   165: invokestatic    java/util/zip/ZipFile.getEntry:(J[BZ)J
        //   168: lstore_2       
        //   169: ldc             1
        //   171: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   174: lload_2        
        //   175: lconst_0       
        //   176: lcmp           
        //   177: ldc             4
        //   179: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   182: ifne            200
        //   185: aconst_null    
        //   186: aload           5
        //   188: pop            
        //   189: ldc             3
        //   191: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   194: ldc             1
        //   196: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   199: areturn        
        //   200: new             Ljava/util/zip/ZipFile$ZipFileInputStream;
        //   203: dup            
        //   204: aload_0        
        //   205: lload_2        
        //   206: ldc             5
        //   208: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   211: invokespecial   java/util/zip/ZipFile$ZipFileInputStream.<init>:(Ljava/util/zip/ZipFile;J)V
        //   214: astore          4
        //   216: ldc             1
        //   218: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   221: lload_2        
        //   222: ldc             2
        //   224: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   227: invokestatic    java/util/zip/ZipFile.getEntryMethod:(J)I
        //   230: ldc             1
        //   232: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   235: lookupswitch {
        //                0: 260
        //                8: 346
        //          default: 542
        //        }
        //   260: aload_0        
        //   261: getfield        java/util/zip/ZipFile.streams:Linstrumented/java/util/Map;
        //   264: dup            
        //   265: astore          6
        //   267: pop            
        //   268: ldc             5
        //   270: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   273: aload_0        
        //   274: getfield        java/util/zip/ZipFile.streams:Linstrumented/java/util/Map;
        //   277: aload           4
        //   279: aconst_null    
        //   280: ldc             5
        //   282: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   285: invokeinterface instrumented/java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   290: pop            
        //   291: ldc             1
        //   293: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   296: aload           6
        //   298: pop            
        //   299: ldc             2
        //   301: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   304: ldc             1
        //   306: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   309: goto            330
        //   312: astore          7
        //   314: aload           6
        //   316: pop            
        //   317: ldc             503
        //   319: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   322: aload           7
        //   324: ldc             2
        //   326: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   329: athrow         
        //   330: aload           4
        //   332: aload           5
        //   334: pop            
        //   335: ldc             3
        //   337: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   340: ldc             1
        //   342: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   345: areturn        
        //   346: lload_2        
        //   347: ldc             2
        //   349: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   352: invokestatic    java/util/zip/ZipFile.getEntrySize:(J)J
        //   355: ldc2_w          2
        //   358: ladd           
        //   359: lstore          6
        //   361: ldc             3
        //   363: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   366: lload           6
        //   368: ldc2_w          65536
        //   371: lcmp           
        //   372: ldc             4
        //   374: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   377: ifle            390
        //   380: ldc2_w          8192
        //   383: lstore          6
        //   385: ldc             2
        //   387: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   390: lload           6
        //   392: lconst_0       
        //   393: lcmp           
        //   394: ldc             4
        //   396: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   399: ifgt            412
        //   402: ldc2_w          4096
        //   405: lstore          6
        //   407: ldc             2
        //   409: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   412: aload_0        
        //   413: ldc             2
        //   415: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   418: invokespecial   java/util/zip/ZipFile.getInflater:()Ljava/util/zip/Inflater;
        //   421: astore          8
        //   423: ldc             1
        //   425: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   428: new             Ljava/util/zip/ZipFile$ZipFileInflaterInputStream;
        //   431: dup            
        //   432: aload_0        
        //   433: aload           4
        //   435: aload           8
        //   437: lload           6
        //   439: l2i            
        //   440: ldc             8
        //   442: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   445: invokespecial   java/util/zip/ZipFile$ZipFileInflaterInputStream.<init>:(Ljava/util/zip/ZipFile;Ljava/util/zip/ZipFile$ZipFileInputStream;Ljava/util/zip/Inflater;I)V
        //   448: astore          9
        //   450: ldc             1
        //   452: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   455: aload_0        
        //   456: getfield        java/util/zip/ZipFile.streams:Linstrumented/java/util/Map;
        //   459: dup            
        //   460: astore          10
        //   462: pop            
        //   463: ldc             5
        //   465: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   468: aload_0        
        //   469: getfield        java/util/zip/ZipFile.streams:Linstrumented/java/util/Map;
        //   472: aload           9
        //   474: aload           8
        //   476: ldc             5
        //   478: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   481: invokeinterface instrumented/java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   486: pop            
        //   487: ldc             1
        //   489: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   492: aload           10
        //   494: pop            
        //   495: ldc             2
        //   497: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   500: ldc             1
        //   502: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   505: goto            526
        //   508: astore          11
        //   510: aload           10
        //   512: pop            
        //   513: ldc             503
        //   515: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   518: aload           11
        //   520: ldc             2
        //   522: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   525: athrow         
        //   526: aload           9
        //   528: aload           5
        //   530: pop            
        //   531: ldc             3
        //   533: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   536: ldc             1
        //   538: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   541: areturn        
        //   542: new             Ljava/util/zip/ZipException;
        //   545: dup            
        //   546: ldc_w           "invalid compression method"
        //   549: ldc             4
        //   551: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   554: invokespecial   java/util/zip/ZipException.<init>:(Ljava/lang/String;)V
        //   557: ldc             1
        //   559: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   562: athrow         
        //   563: astore          12
        //   565: aload           5
        //   567: pop            
        //   568: ldc             503
        //   570: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   573: aload           12
        //   575: ldc             2
        //   577: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   580: athrow         
        //   581: athrow         
        //   582: athrow         
        //    Exceptions:
        //  throws java.io.IOException
        //    StackMapTable: 00 10 1D FE 00 6C 04 07 00 18 07 00 04 23 19 3B FF 00 33 00 06 07 00 02 07 00 FC 04 07 00 18 07 00 04 07 00 04 00 01 07 00 4D FA 00 11 0F FC 00 2B 04 15 FF 00 5F 00 09 07 00 02 07 00 FC 04 07 00 18 07 00 04 04 07 01 23 07 01 25 07 00 04 00 01 07 00 4D FA 00 11 F8 00 0F 54 07 00 4D FF 00 11 00 00 00 01 07 00 4D FF 00 00 00 00 00 01 07 00 D2
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  54     582    582    583    Ljava/lang/VirtualMachineError;
        //  273    304    312    330    Any
        //  312    322    312    330    Any
        //  468    500    508    526    Any
        //  508    518    508    526    Any
        //  54     194    563    581    Any
        //  200    340    563    581    Any
        //  346    536    563    581    Any
        //  542    573    563    581    Any
        //  0      581    581    582    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0138:
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
    
    private Inflater getInflater() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        java/util/zip/ZipFile.inflaterCache:Linstrumented/java/util/Deque;
        //     4: dup            
        //     5: astore_2       
        //     6: pop            
        //     7: ldc             5
        //     9: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    12: aconst_null    
        //    13: aload_0        
        //    14: getfield        java/util/zip/ZipFile.inflaterCache:Linstrumented/java/util/Deque;
        //    17: ldc             4
        //    19: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    22: invokeinterface instrumented/java/util/Deque.poll:()Ljava/lang/Object;
        //    27: checkcast       Ljava/util/zip/Inflater;
        //    30: dup            
        //    31: astore_1       
        //    32: ldc             4
        //    34: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    37: if_acmpeq       72
        //    40: iconst_0       
        //    41: aload_1        
        //    42: ldc             3
        //    44: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    47: invokevirtual   java/util/zip/Inflater.ended:()Z
        //    50: ldc             1
        //    52: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    55: if_icmpne       12
        //    58: aload_1        
        //    59: aload_2        
        //    60: pop            
        //    61: ldc             3
        //    63: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    66: ldc             1
        //    68: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    71: areturn        
        //    72: aload_2        
        //    73: pop            
        //    74: ldc             2
        //    76: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    79: ldc             1
        //    81: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    84: goto            102
        //    87: astore_3       
        //    88: aload_2        
        //    89: pop            
        //    90: ldc             503
        //    92: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    95: aload_3        
        //    96: ldc             2
        //    98: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   101: athrow         
        //   102: new             Ljava/util/zip/Inflater;
        //   105: dup            
        //   106: iconst_1       
        //   107: ldc             4
        //   109: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   112: invokespecial   java/util/zip/Inflater.<init>:(Z)V
        //   115: ldc             1
        //   117: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   120: areturn        
        //   121: athrow         
        //   122: athrow         
        //    StackMapTable: 00 06 FD 00 0C 00 07 00 04 FF 00 3B 00 03 07 00 02 07 01 23 07 00 04 00 00 FF 00 0E 00 03 07 00 02 00 07 00 04 00 01 07 00 4D FF 00 0E 00 02 07 00 02 07 01 23 00 00 FF 00 12 00 00 00 01 07 00 4D FF 00 00 00 00 00 01 07 00 D2
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  12     122    122    123    Ljava/lang/VirtualMachineError;
        //  12     66     87     102    Any
        //  72     79     87     102    Any
        //  87     95     87     102    Any
        //  0      121    121    122    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0012:
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
    
    private void releaseInflater(final Inflater p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: aload_1        
        //     2: ldc             3
        //     4: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     7: invokevirtual   java/util/zip/Inflater.ended:()Z
        //    10: ldc             1
        //    12: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    15: if_icmpne       90
        //    18: aload_1        
        //    19: ldc             2
        //    21: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    24: invokevirtual   java/util/zip/Inflater.reset:()V
        //    27: aload_0        
        //    28: getfield        java/util/zip/ZipFile.inflaterCache:Linstrumented/java/util/Deque;
        //    31: dup            
        //    32: astore_2       
        //    33: pop            
        //    34: ldc             5
        //    36: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    39: aload_0        
        //    40: getfield        java/util/zip/ZipFile.inflaterCache:Linstrumented/java/util/Deque;
        //    43: aload_1        
        //    44: ldc             4
        //    46: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    49: invokeinterface instrumented/java/util/Deque.add:(Ljava/lang/Object;)Z
        //    54: pop            
        //    55: ldc             1
        //    57: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    60: aload_2        
        //    61: pop            
        //    62: ldc             2
        //    64: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    67: ldc             1
        //    69: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    72: goto            90
        //    75: astore_3       
        //    76: aload_2        
        //    77: pop            
        //    78: ldc             503
        //    80: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    83: aload_3        
        //    84: ldc             2
        //    86: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    89: athrow         
        //    90: ldc             1
        //    92: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    95: return         
        //    96: athrow         
        //    97: athrow         
        //    StackMapTable: 00 04 FF 00 4B 00 03 07 00 02 07 01 23 07 00 04 00 01 07 00 4D FA 00 0E FF 00 05 00 00 00 01 07 00 4D FF 00 00 00 00 00 01 07 00 D2
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  39     97     97     98     Ljava/lang/VirtualMachineError;
        //  39     67     75     90     Any
        //  75     83     75     90     Any
        //  0      96     96     97     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0090:
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
    
    public Enumeration<? extends ZipEntry> entries() {
        try {
            BytecodeManager.incBytecodes(4);
            final ZipEntryIterator zipEntryIterator = new ZipEntryIterator();
            BytecodeManager.incBytecodes(1);
            return zipEntryIterator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Stream<? extends ZipEntry> stream() {
        try {
            BytecodeManager.incBytecodes(4);
            final ZipEntryIterator zipEntryIterator = new ZipEntryIterator();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
            final long n = this.size();
            final int n2 = 1297;
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
            final Spliterator<Object> spliterator = Spliterators.spliterator((Iterator<?>)zipEntryIterator, n, n2);
            final boolean b = false;
            BytecodeManager.incBytecodes(2);
            final Stream<Object> stream = StreamSupport.stream(spliterator, b);
            BytecodeManager.incBytecodes(1);
            return (Stream<? extends ZipEntry>)stream;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private ZipEntry getZipEntry(final String name, final long n) {
        try {
            BytecodeManager.incBytecodes(3);
            final ZipEntry zipEntry = new ZipEntry();
            BytecodeManager.incBytecodes(1);
            final ZipEntry zipEntry2 = zipEntry;
            BytecodeManager.incBytecodes(3);
            zipEntry2.flag = getEntryFlag(n);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            Label_0174: {
                if (name != null) {
                    zipEntry.name = name;
                    BytecodeManager.incBytecodes(4);
                }
                else {
                    final int n2 = 0;
                    BytecodeManager.incBytecodes(3);
                    final byte[] entryBytes = getEntryBytes(n, n2);
                    BytecodeManager.incBytecodes(1);
                    final ZipCoder zc = this.zc;
                    BytecodeManager.incBytecodes(3);
                    final boolean utf8 = zc.isUTF8();
                    BytecodeManager.incBytecodes(1);
                    if (!utf8) {
                        final int n3 = zipEntry.flag & 0x800;
                        BytecodeManager.incBytecodes(5);
                        if (n3 != 0) {
                            final ZipEntry zipEntry3 = zipEntry;
                            final ZipCoder zc2 = this.zc;
                            final byte[] ba = entryBytes;
                            final int length = entryBytes.length;
                            BytecodeManager.incBytecodes(7);
                            zipEntry3.name = zc2.toStringUTF8(ba, length);
                            BytecodeManager.incBytecodes(2);
                            break Label_0174;
                        }
                    }
                    final ZipEntry zipEntry4 = zipEntry;
                    final ZipCoder zc3 = this.zc;
                    final byte[] ba2 = entryBytes;
                    final int length2 = entryBytes.length;
                    BytecodeManager.incBytecodes(7);
                    zipEntry4.name = zc3.toString(ba2, length2);
                    BytecodeManager.incBytecodes(1);
                }
            }
            final ZipEntry zipEntry5 = zipEntry;
            BytecodeManager.incBytecodes(3);
            zipEntry5.xdostime = getEntryTime(n);
            BytecodeManager.incBytecodes(1);
            final ZipEntry zipEntry6 = zipEntry;
            BytecodeManager.incBytecodes(3);
            zipEntry6.crc = getEntryCrc(n);
            BytecodeManager.incBytecodes(1);
            final ZipEntry zipEntry7 = zipEntry;
            BytecodeManager.incBytecodes(3);
            zipEntry7.size = getEntrySize(n);
            BytecodeManager.incBytecodes(1);
            final ZipEntry zipEntry8 = zipEntry;
            BytecodeManager.incBytecodes(3);
            zipEntry8.csize = getEntryCSize(n);
            BytecodeManager.incBytecodes(1);
            final ZipEntry zipEntry9 = zipEntry;
            BytecodeManager.incBytecodes(3);
            zipEntry9.method = getEntryMethod(n);
            BytecodeManager.incBytecodes(1);
            final ZipEntry zipEntry10 = zipEntry;
            final int n4 = 1;
            BytecodeManager.incBytecodes(4);
            final byte[] entryBytes2 = getEntryBytes(n, n4);
            final boolean doZIP64 = false;
            BytecodeManager.incBytecodes(2);
            zipEntry10.setExtra0(entryBytes2, doZIP64);
            final int n5 = 2;
            BytecodeManager.incBytecodes(3);
            final byte[] entryBytes3 = getEntryBytes(n, n5);
            BytecodeManager.incBytecodes(1);
            final byte[] array = entryBytes3;
            BytecodeManager.incBytecodes(2);
            Label_0427: {
                if (array == null) {
                    zipEntry.comment = null;
                    BytecodeManager.incBytecodes(4);
                }
                else {
                    final ZipCoder zc4 = this.zc;
                    BytecodeManager.incBytecodes(3);
                    final boolean utf9 = zc4.isUTF8();
                    BytecodeManager.incBytecodes(1);
                    if (!utf9) {
                        final int n6 = zipEntry.flag & 0x800;
                        BytecodeManager.incBytecodes(5);
                        if (n6 != 0) {
                            final ZipEntry zipEntry11 = zipEntry;
                            final ZipCoder zc5 = this.zc;
                            final byte[] ba3 = entryBytes3;
                            final int length3 = entryBytes3.length;
                            BytecodeManager.incBytecodes(7);
                            zipEntry11.comment = zc5.toStringUTF8(ba3, length3);
                            BytecodeManager.incBytecodes(2);
                            break Label_0427;
                        }
                    }
                    final ZipEntry zipEntry12 = zipEntry;
                    final ZipCoder zc6 = this.zc;
                    final byte[] ba4 = entryBytes3;
                    final int length4 = entryBytes3.length;
                    BytecodeManager.incBytecodes(7);
                    zipEntry12.comment = zc6.toString(ba4, length4);
                    BytecodeManager.incBytecodes(1);
                }
            }
            final ZipEntry zipEntry13 = zipEntry;
            BytecodeManager.incBytecodes(2);
            return zipEntry13;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static native long getNextEntry(final long p0, final int p1);
    
    public int size() {
        try {
            BytecodeManager.incBytecodes(2);
            this.ensureOpen();
            final int total = this.total;
            BytecodeManager.incBytecodes(3);
            return total;
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
        //     1: getfield        java/util/zip/ZipFile.closeRequested:Z
        //     4: ldc             3
        //     6: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     9: ifeq            18
        //    12: ldc             1
        //    14: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    17: return         
        //    18: aload_0        
        //    19: iconst_1       
        //    20: putfield        java/util/zip/ZipFile.closeRequested:Z
        //    23: ldc             3
        //    25: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    28: aload_0        
        //    29: dup            
        //    30: astore_1       
        //    31: pop            
        //    32: ldc             4
        //    34: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    37: aload_0        
        //    38: getfield        java/util/zip/ZipFile.streams:Linstrumented/java/util/Map;
        //    41: dup            
        //    42: astore_2       
        //    43: pop            
        //    44: ldc             5
        //    46: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    49: iconst_0       
        //    50: aload_0        
        //    51: getfield        java/util/zip/ZipFile.streams:Linstrumented/java/util/Map;
        //    54: ldc             4
        //    56: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    59: invokeinterface instrumented/java/util/Map.isEmpty:()Z
        //    64: ldc             1
        //    66: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    69: if_icmpne       251
        //    72: new             Linstrumented/java/util/HashMap;
        //    75: dup            
        //    76: aload_0        
        //    77: getfield        java/util/zip/ZipFile.streams:Linstrumented/java/util/Map;
        //    80: ldc             5
        //    82: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    85: invokespecial   instrumented/java/util/HashMap.<init>:(Linstrumented/java/util/Map;)V
        //    88: astore_3       
        //    89: ldc             1
        //    91: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    94: aload_0        
        //    95: getfield        java/util/zip/ZipFile.streams:Linstrumented/java/util/Map;
        //    98: ldc             3
        //   100: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   103: invokeinterface instrumented/java/util/Map.clear:()V
        //   108: aload_3        
        //   109: ldc             2
        //   111: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   114: invokeinterface instrumented/java/util/Map.entrySet:()Linstrumented/java/util/Set;
        //   119: ldc             1
        //   121: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   124: invokeinterface instrumented/java/util/Set.iterator:()Ljava/util/Iterator;
        //   129: astore          4
        //   131: ldc             1
        //   133: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   136: aload           4
        //   138: ldc             2
        //   140: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   143: invokeinterface java/util/Iterator.hasNext:()Z
        //   148: ldc             1
        //   150: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   153: ifeq            251
        //   156: aload           4
        //   158: ldc             2
        //   160: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   163: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   168: checkcast       Linstrumented/java/util/Map$Entry;
        //   171: astore          5
        //   173: ldc             2
        //   175: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   178: aload           5
        //   180: ldc             2
        //   182: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   185: invokeinterface instrumented/java/util/Map$Entry.getKey:()Ljava/lang/Object;
        //   190: checkcast       Ljava/io/InputStream;
        //   193: ldc             2
        //   195: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   198: invokevirtual   java/io/InputStream.close:()V
        //   201: aload           5
        //   203: ldc             2
        //   205: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   208: invokeinterface instrumented/java/util/Map$Entry.getValue:()Ljava/lang/Object;
        //   213: checkcast       Ljava/util/zip/Inflater;
        //   216: astore          6
        //   218: ldc             2
        //   220: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   223: aload           6
        //   225: ldc             2
        //   227: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   230: ifnull          243
        //   233: aload           6
        //   235: ldc             2
        //   237: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   240: invokevirtual   java/util/zip/Inflater.end:()V
        //   243: ldc             1
        //   245: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   248: goto            136
        //   251: aload_2        
        //   252: pop            
        //   253: ldc             2
        //   255: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   258: ldc             1
        //   260: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   263: goto            283
        //   266: astore          7
        //   268: aload_2        
        //   269: pop            
        //   270: ldc             503
        //   272: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   275: aload           7
        //   277: ldc             2
        //   279: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   282: athrow         
        //   283: aload_0        
        //   284: getfield        java/util/zip/ZipFile.inflaterCache:Linstrumented/java/util/Deque;
        //   287: dup            
        //   288: astore_3       
        //   289: pop            
        //   290: ldc             5
        //   292: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   295: aconst_null    
        //   296: aload_0        
        //   297: getfield        java/util/zip/ZipFile.inflaterCache:Linstrumented/java/util/Deque;
        //   300: ldc             4
        //   302: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   305: invokeinterface instrumented/java/util/Deque.poll:()Ljava/lang/Object;
        //   310: checkcast       Ljava/util/zip/Inflater;
        //   313: dup            
        //   314: astore_2       
        //   315: ldc             4
        //   317: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   320: if_acmpeq       340
        //   323: aload_2        
        //   324: ldc             2
        //   326: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   329: invokevirtual   java/util/zip/Inflater.end:()V
        //   332: ldc             1
        //   334: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   337: goto            295
        //   340: aload_3        
        //   341: pop            
        //   342: ldc             2
        //   344: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   347: ldc             1
        //   349: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   352: goto            372
        //   355: astore          8
        //   357: aload_3        
        //   358: pop            
        //   359: ldc             503
        //   361: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   364: aload           8
        //   366: ldc             2
        //   368: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   371: athrow         
        //   372: aload_0        
        //   373: getfield        java/util/zip/ZipFile.jzfile:J
        //   376: lconst_0       
        //   377: lcmp           
        //   378: ldc             5
        //   380: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   383: ifeq            415
        //   386: aload_0        
        //   387: getfield        java/util/zip/ZipFile.jzfile:J
        //   390: lstore_3       
        //   391: ldc             3
        //   393: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   396: aload_0        
        //   397: lconst_0       
        //   398: putfield        java/util/zip/ZipFile.jzfile:J
        //   401: ldc             3
        //   403: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   406: lload_3        
        //   407: ldc             2
        //   409: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   412: invokestatic    java/util/zip/ZipFile.close:(J)V
        //   415: aload_1        
        //   416: pop            
        //   417: ldc             2
        //   419: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   422: ldc             1
        //   424: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   427: goto            447
        //   430: astore          9
        //   432: aload_1        
        //   433: pop            
        //   434: ldc             503
        //   436: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   439: aload           9
        //   441: ldc             2
        //   443: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   446: athrow         
        //   447: ldc             1
        //   449: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   452: return         
        //   453: athrow         
        //   454: athrow         
        //    Exceptions:
        //  throws java.io.IOException
        //    StackMapTable: 00 0F 12 FF 00 75 00 05 07 00 02 07 00 04 07 00 04 07 00 0D 07 01 97 00 00 FB 00 6A F9 00 07 4E 07 00 4D FA 00 10 FD 00 0B 00 07 00 04 FF 00 2C 00 04 07 00 02 07 00 04 07 01 23 07 00 04 00 00 FF 00 0E 00 04 07 00 02 07 00 04 00 07 00 04 00 01 07 00 4D FF 00 10 00 03 07 00 02 07 00 04 07 01 23 00 00 FA 00 2A 4E 07 00 4D FA 00 10 FF 00 05 00 00 00 01 07 00 4D FF 00 00 00 00 00 01 07 00 D2
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  37     454    454    455    Ljava/lang/VirtualMachineError;
        //  49     258    266    283    Any
        //  266    275    266    283    Any
        //  295    347    355    372    Any
        //  355    364    355    372    Any
        //  37     422    430    447    Any
        //  430    439    430    447    Any
        //  0      453    453    454    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0136:
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
    protected void finalize() throws IOException {
        try {
            BytecodeManager.incBytecodes(2);
            this.close();
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static native void close(final long p0);
    
    private void ensureOpen() {
        try {
            final boolean closeRequested = this.closeRequested;
            BytecodeManager.incBytecodes(3);
            if (closeRequested) {
                final String s = "zip file closed";
                BytecodeManager.incBytecodes(4);
                final IllegalStateException ex = new IllegalStateException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final long n = lcmp(this.jzfile, 0L);
            BytecodeManager.incBytecodes(5);
            if (n == 0) {
                final String s2 = "The object is not initialized.";
                BytecodeManager.incBytecodes(4);
                final IllegalStateException ex2 = new IllegalStateException(s2);
                BytecodeManager.incBytecodes(1);
                throw ex2;
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void ensureOpenOrZipException() throws IOException {
        try {
            final boolean closeRequested = this.closeRequested;
            BytecodeManager.incBytecodes(3);
            if (closeRequested) {
                final String s = "ZipFile closed";
                BytecodeManager.incBytecodes(4);
                final ZipException ex = new ZipException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private boolean startsWithLocHeader() {
        try {
            final boolean locsig = this.locsig;
            BytecodeManager.incBytecodes(3);
            return locsig;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static native long open(final String p0, final int p1, final long p2, final boolean p3) throws IOException;
    
    private static native int getTotal(final long p0);
    
    private static native boolean startsWithLOC(final long p0);
    
    private static native int read(final long p0, final long p1, final long p2, final byte[] p3, final int p4, final int p5);
    
    private static native long getEntryTime(final long p0);
    
    private static native long getEntryCrc(final long p0);
    
    private static native long getEntryCSize(final long p0);
    
    private static native long getEntrySize(final long p0);
    
    private static native int getEntryMethod(final long p0);
    
    private static native int getEntryFlag(final long p0);
    
    private static native byte[] getCommentBytes(final long p0);
    
    private static native byte[] getEntryBytes(final long p0, final int p1);
    
    private static native String getZipMessage(final long p0);
    
    static {
        try {
            BytecodeManager.incBytecodes(1);
            initIDs();
            final String s = "sun.zip.disableMemoryMapping";
            BytecodeManager.incBytecodes(2);
            final String savedProperty = VM.getSavedProperty(s);
            BytecodeManager.incBytecodes(1);
            final String s2 = savedProperty;
            BytecodeManager.incBytecodes(2);
            boolean usemmap2 = false;
            Label_0091: {
                Label_0076: {
                    if (s2 != null) {
                        final String s3 = savedProperty;
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                        final int length = s3.length();
                        BytecodeManager.incBytecodes(1);
                        if (length != 0) {
                            final String s4 = savedProperty;
                            final String anotherString = "true";
                            BytecodeManager.incBytecodes(3);
                            final boolean equalsIgnoreCase = s4.equalsIgnoreCase(anotherString);
                            BytecodeManager.incBytecodes(1);
                            if (!equalsIgnoreCase) {
                                break Label_0076;
                            }
                        }
                        usemmap2 = false;
                        BytecodeManager.incBytecodes(1);
                        break Label_0091;
                    }
                }
                usemmap2 = true;
                BytecodeManager.incBytecodes(2);
            }
            ZipFile.usemmap = usemmap2;
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            final JavaUtilZipFileAccess javaUtilZipFileAccess = new JavaUtilZipFileAccess() {
                @Override
                public boolean startsWithLocHeader(final ZipFile zip) {
                    return zip.res.zsrc.startsWithLoc;
                }
                
                @Override
                public String[] getMetaInfEntryNames(final ZipFile zip) {
                    return zip.getMetaInfEntryNames();
                }
                
                @Override
                public JarEntry getEntry(final ZipFile zip, final String name, final Function<String, JarEntry> func) {
                    return (JarEntry)zip.getEntry(name, func);
                }
                
                @Override
                public java.util.Enumeration<JarEntry> entries(final ZipFile zip, final Function<String, JarEntry> func) {
                    return zip.entries(func);
                }
                
                @Override
                public java.util.stream.Stream<JarEntry> stream(final ZipFile zip, final Function<String, JarEntry> func) {
                    return zip.stream(func);
                }
                
                @Override
                public java.util.stream.Stream<String> entryNameStream(final ZipFile zip) {
                    return zip.entryNameStream();
                }
            };
            BytecodeManager.incBytecodes(1);
            SharedSecrets.setJavaUtilZipFileAccess((sun.misc.JavaUtilZipFileAccess)javaUtilZipFileAccess);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private class ZipFileInflaterInputStream extends InflaterInputStream
    {
        private volatile boolean closeRequested;
        private boolean eof;
        private final Cleaner.Cleanable cleanable;
        
        ZipFileInflaterInputStream(final ZipFile zipFile, final ZipFileInputStream zfin, final CleanableResource res, final int size) {
            this(zipFile, zfin, res, res.getInflater(), size);
        }
        
        private ZipFileInflaterInputStream(final ZipFileInputStream zfin, final CleanableResource res, final Inflater inf, final int size) {
            super(zfin, inf, size);
            this.eof = false;
            this.cleanable = CleanerFactory.cleaner().register(this, new InflaterCleanupAction(inf, res));
        }
        
        @Override
        public void close() throws IOException {
            if (this.closeRequested) {
                return;
            }
            this.closeRequested = true;
            super.close();
            synchronized (ZipFile.this.res.istreams) {
                ZipFile.this.res.istreams.remove(this);
            }
            this.cleanable.clean();
        }
        
        @Override
        protected void fill() throws IOException {
            if (this.eof) {
                throw new EOFException("Unexpected end of ZLIB input stream");
            }
            this.len = this.in.read(this.buf, 0, this.buf.length);
            if (this.len == -1) {
                this.buf[0] = 0;
                this.len = 1;
                this.eof = true;
            }
            this.inf.setInput(this.buf, 0, this.len);
        }
        
        @Override
        public int available() throws IOException {
            if (this.closeRequested) {
                return 0;
            }
            final long avail = ((ZipFileInputStream)this.in).size() - this.inf.getBytesWritten();
            return (avail > 2147483647L) ? Integer.MAX_VALUE : ((int)avail);
        }
    }
    
    private class ZipEntryIterator implements Enumeration<ZipEntry>, Iterator<ZipEntry>
    {
        private int i;
        
        public ZipEntryIterator() {
            try {
                BytecodeManager.incBytecodes(5);
                this.i = 0;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(2);
                ZipFile.access$200(ZipFile.this);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean hasMoreElements() {
            try {
                BytecodeManager.incBytecodes(2);
                final boolean hasNext = this.hasNext();
                BytecodeManager.incBytecodes(1);
                return hasNext;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean hasNext() {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: getfield        java/util/zip/ZipFile$ZipEntryIterator.this$0:Ljava/util/zip/ZipFile;
            //     4: dup            
            //     5: astore_1       
            //     6: pop            
            //     7: ldc             5
            //     9: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    12: aload_0        
            //    13: getfield        java/util/zip/ZipFile$ZipEntryIterator.this$0:Ljava/util/zip/ZipFile;
            //    16: ldc             3
            //    18: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    21: invokestatic    java/util/zip/ZipFile.access$200:(Ljava/util/zip/ZipFile;)V
            //    24: aload_0        
            //    25: getfield        java/util/zip/ZipFile$ZipEntryIterator.i:I
            //    28: aload_0        
            //    29: getfield        java/util/zip/ZipFile$ZipEntryIterator.this$0:Ljava/util/zip/ZipFile;
            //    32: ldc             5
            //    34: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    37: invokestatic    java/util/zip/ZipFile.access$300:(Ljava/util/zip/ZipFile;)I
            //    40: ldc             1
            //    42: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    45: if_icmpge       57
            //    48: iconst_1       
            //    49: ldc             2
            //    51: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    54: goto            63
            //    57: iconst_0       
            //    58: ldc             1
            //    60: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    63: aload_1        
            //    64: pop            
            //    65: ldc             2
            //    67: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    70: ldc             1
            //    72: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    75: ireturn        
            //    76: astore_2       
            //    77: aload_1        
            //    78: pop            
            //    79: ldc             503
            //    81: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    84: aload_2        
            //    85: ldc             2
            //    87: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    90: athrow         
            //    91: athrow         
            //    92: athrow         
            //    StackMapTable: 00 05 FC 00 39 07 00 05 45 01 4C 07 00 29 FF 00 0E 00 00 00 01 07 00 29 FF 00 00 00 00 00 01 07 00 30
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                           
            //  -----  -----  -----  -----  -------------------------------
            //  12     92     92     93     Ljava/lang/VirtualMachineError;
            //  12     70     76     91     Any
            //  76     84     76     91     Any
            //  0      91     91     92     Any
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
        
        @Override
        public ZipEntry nextElement() {
            try {
                BytecodeManager.incBytecodes(2);
                final ZipEntry next = this.next();
                BytecodeManager.incBytecodes(1);
                return next;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public ZipEntry next() {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: getfield        java/util/zip/ZipFile$ZipEntryIterator.this$0:Ljava/util/zip/ZipFile;
            //     4: dup            
            //     5: astore_1       
            //     6: pop            
            //     7: ldc             5
            //     9: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    12: aload_0        
            //    13: getfield        java/util/zip/ZipFile$ZipEntryIterator.this$0:Ljava/util/zip/ZipFile;
            //    16: ldc             3
            //    18: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    21: invokestatic    java/util/zip/ZipFile.access$200:(Ljava/util/zip/ZipFile;)V
            //    24: aload_0        
            //    25: getfield        java/util/zip/ZipFile$ZipEntryIterator.i:I
            //    28: aload_0        
            //    29: getfield        java/util/zip/ZipFile$ZipEntryIterator.this$0:Ljava/util/zip/ZipFile;
            //    32: ldc             5
            //    34: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    37: invokestatic    java/util/zip/ZipFile.access$300:(Ljava/util/zip/ZipFile;)I
            //    40: ldc             1
            //    42: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    45: if_icmplt       66
            //    48: new             Linstrumented/java/util/NoSuchElementException;
            //    51: dup            
            //    52: ldc             3
            //    54: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    57: invokespecial   instrumented/java/util/NoSuchElementException.<init>:()V
            //    60: ldc             1
            //    62: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    65: athrow         
            //    66: aload_0        
            //    67: getfield        java/util/zip/ZipFile$ZipEntryIterator.this$0:Ljava/util/zip/ZipFile;
            //    70: ldc             3
            //    72: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    75: invokestatic    java/util/zip/ZipFile.access$400:(Ljava/util/zip/ZipFile;)J
            //    78: aload_0        
            //    79: dup            
            //    80: getfield        java/util/zip/ZipFile$ZipEntryIterator.i:I
            //    83: dup_x1         
            //    84: iconst_1       
            //    85: iadd           
            //    86: putfield        java/util/zip/ZipFile$ZipEntryIterator.i:I
            //    89: ldc             8
            //    91: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    94: invokestatic    java/util/zip/ZipFile.access$500:(JI)J
            //    97: lstore_2       
            //    98: ldc             1
            //   100: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   103: lload_2        
            //   104: lconst_0       
            //   105: lcmp           
            //   106: ldc             4
            //   108: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   111: ifne            358
            //   114: aload_0        
            //   115: getfield        java/util/zip/ZipFile$ZipEntryIterator.this$0:Ljava/util/zip/ZipFile;
            //   118: ldc             3
            //   120: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   123: invokestatic    java/util/zip/ZipFile.access$600:(Ljava/util/zip/ZipFile;)Z
            //   126: ldc             1
            //   128: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   131: ifeq            146
            //   134: ldc             "ZipFile concurrently closed"
            //   136: astore          4
            //   138: ldc             3
            //   140: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   143: goto            173
            //   146: aload_0        
            //   147: getfield        java/util/zip/ZipFile$ZipEntryIterator.this$0:Ljava/util/zip/ZipFile;
            //   150: ldc             3
            //   152: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   155: invokestatic    java/util/zip/ZipFile.access$400:(Ljava/util/zip/ZipFile;)J
            //   158: ldc             1
            //   160: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   163: invokestatic    java/util/zip/ZipFile.access$700:(J)Ljava/lang/String;
            //   166: astore          4
            //   168: ldc             1
            //   170: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   173: new             Ljava/util/zip/ZipError;
            //   176: dup            
            //   177: new             Ljava/lang/StringBuilder;
            //   180: dup            
            //   181: ldc             5
            //   183: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   186: invokespecial   java/lang/StringBuilder.<init>:()V
            //   189: ldc             "jzentry == 0,\n jzfile = "
            //   191: ldc             2
            //   193: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   196: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   199: aload_0        
            //   200: getfield        java/util/zip/ZipFile$ZipEntryIterator.this$0:Ljava/util/zip/ZipFile;
            //   203: ldc             2
            //   205: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   208: ldc             1
            //   210: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   213: invokestatic    java/util/zip/ZipFile.access$400:(Ljava/util/zip/ZipFile;)J
            //   216: ldc             1
            //   218: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   221: invokevirtual   java/lang/StringBuilder.append:(J)Ljava/lang/StringBuilder;
            //   224: ldc             ",\n total = "
            //   226: ldc             2
            //   228: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   231: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   234: aload_0        
            //   235: getfield        java/util/zip/ZipFile$ZipEntryIterator.this$0:Ljava/util/zip/ZipFile;
            //   238: ldc             2
            //   240: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   243: ldc             1
            //   245: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   248: invokestatic    java/util/zip/ZipFile.access$300:(Ljava/util/zip/ZipFile;)I
            //   251: ldc             1
            //   253: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   256: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
            //   259: ldc             ",\n name = "
            //   261: ldc             2
            //   263: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   266: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   269: aload_0        
            //   270: getfield        java/util/zip/ZipFile$ZipEntryIterator.this$0:Ljava/util/zip/ZipFile;
            //   273: ldc             2
            //   275: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   278: ldc             1
            //   280: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   283: invokestatic    java/util/zip/ZipFile.access$800:(Ljava/util/zip/ZipFile;)Ljava/lang/String;
            //   286: ldc             1
            //   288: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   291: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   294: ldc             ",\n i = "
            //   296: ldc             2
            //   298: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   301: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   304: aload_0        
            //   305: getfield        java/util/zip/ZipFile$ZipEntryIterator.i:I
            //   308: ldc             3
            //   310: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   313: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
            //   316: ldc             ",\n message = "
            //   318: ldc             2
            //   320: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   323: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   326: aload           4
            //   328: ldc             2
            //   330: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   333: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   336: ldc             1
            //   338: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   341: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
            //   344: ldc             1
            //   346: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   349: invokespecial   java/util/zip/ZipError.<init>:(Ljava/lang/String;)V
            //   352: ldc             1
            //   354: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   357: athrow         
            //   358: aload_0        
            //   359: getfield        java/util/zip/ZipFile$ZipEntryIterator.this$0:Ljava/util/zip/ZipFile;
            //   362: aconst_null    
            //   363: lload_2        
            //   364: ldc             5
            //   366: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   369: invokestatic    java/util/zip/ZipFile.access$900:(Ljava/util/zip/ZipFile;Ljava/lang/String;J)Ljava/util/zip/ZipEntry;
            //   372: astore          4
            //   374: ldc             1
            //   376: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   379: aload_0        
            //   380: getfield        java/util/zip/ZipFile$ZipEntryIterator.this$0:Ljava/util/zip/ZipFile;
            //   383: ldc             3
            //   385: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   388: invokestatic    java/util/zip/ZipFile.access$400:(Ljava/util/zip/ZipFile;)J
            //   391: lload_2        
            //   392: ldc             2
            //   394: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   397: invokestatic    java/util/zip/ZipFile.access$1000:(JJ)V
            //   400: aload           4
            //   402: aload_1        
            //   403: pop            
            //   404: ldc             3
            //   406: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   409: ldc             1
            //   411: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   414: areturn        
            //   415: astore          5
            //   417: aload_1        
            //   418: pop            
            //   419: ldc             503
            //   421: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   424: aload           5
            //   426: ldc             2
            //   428: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   431: athrow         
            //   432: athrow         
            //   433: athrow         
            //    StackMapTable: 00 07 FC 00 42 07 00 05 FC 00 4F 04 FC 00 1A 07 00 53 FA 00 B8 FF 00 38 00 02 07 00 02 07 00 05 00 01 07 00 29 FF 00 10 00 00 00 01 07 00 29 FF 00 00 00 00 00 01 07 00 30
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                           
            //  -----  -----  -----  -----  -------------------------------
            //  12     433    433    434    Ljava/lang/VirtualMachineError;
            //  12     409    415    432    Any
            //  415    424    415    432    Any
            //  0      432    432    433    Any
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0066:
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
    
    private class ZipFileInputStream extends InputStream
    {
        private volatile boolean closeRequested;
        private long pos;
        protected long rem;
        protected long size;
        
        ZipFileInputStream(final byte[] cen, final int cenpos) {
            this.rem = ZipUtils.CENSIZ(cen, cenpos);
            this.size = ZipUtils.CENLEN(cen, cenpos);
            this.pos = ZipUtils.CENOFF(cen, cenpos);
            if (this.rem == 4294967295L || this.size == 4294967295L || this.pos == 4294967295L) {
                this.checkZIP64(cen, cenpos);
            }
            this.pos = -(this.pos + ZipFile.this.res.zsrc.locpos);
        }
        
        private void checkZIP64(final byte[] cen, final int cenpos) {
            int off = cenpos + 46 + ZipUtils.CENNAM(cen, cenpos);
            final int end = off + ZipUtils.CENEXT(cen, cenpos);
            while (off + 4 < end) {
                final int tag = ZipUtils.get16(cen, off);
                int sz = ZipUtils.get16(cen, off + 2);
                off += 4;
                if (off + sz > end) {
                    break;
                }
                if (tag == 1) {
                    if (this.size == 4294967295L) {
                        if (sz < 8) {
                            break;
                        }
                        if (off + 8 > end) {
                            break;
                        }
                        this.size = ZipUtils.get64(cen, off);
                        sz -= 8;
                        off += 8;
                    }
                    if (this.rem == 4294967295L) {
                        if (sz < 8) {
                            break;
                        }
                        if (off + 8 > end) {
                            break;
                        }
                        this.rem = ZipUtils.get64(cen, off);
                        sz -= 8;
                        off += 8;
                    }
                    if (this.pos != 4294967295L || sz < 8) {
                        break;
                    }
                    if (off + 8 > end) {
                        break;
                    }
                    this.pos = ZipUtils.get64(cen, off);
                    sz -= 8;
                    off += 8;
                    break;
                }
                else {
                    off += sz;
                }
            }
        }
        
        private long initDataOffset() throws IOException {
            if (this.pos <= 0L) {
                final byte[] loc = new byte[30];
                this.pos = -this.pos;
                final int len = ZipFile.this.res.zsrc.readFullyAt(loc, 0, loc.length, this.pos);
                if (len != 30) {
                    throw new ZipException("ZipFile error reading zip file");
                }
                if (ZipUtils.LOCSIG(loc) != 67324752L) {
                    throw new ZipException("ZipFile invalid LOC header (bad signature)");
                }
                this.pos += 30 + ZipUtils.LOCNAM(loc) + ZipUtils.LOCEXT(loc);
            }
            return this.pos;
        }
        
        @Override
        public int read(final byte[] b, final int off, int len) throws IOException {
            synchronized (ZipFile.this) {
                ZipFile.this.ensureOpenOrZipException();
                this.initDataOffset();
                if (this.rem == 0L) {
                    return -1;
                }
                if (len > this.rem) {
                    len = (int)this.rem;
                }
                if (len <= 0) {
                    return 0;
                }
                len = ZipFile.this.res.zsrc.readAt(b, off, len, this.pos);
                if (len > 0) {
                    this.pos += len;
                    this.rem -= len;
                }
            }
            if (this.rem == 0L) {
                this.close();
            }
            return len;
        }
        
        @Override
        public int read() throws IOException {
            final byte[] b = { 0 };
            if (this.read(b, 0, 1) == 1) {
                return b[0] & 0xFF;
            }
            return -1;
        }
        
        @Override
        public long skip(long n) throws IOException {
            synchronized (ZipFile.this) {
                this.initDataOffset();
                if (n > this.rem) {
                    n = this.rem;
                }
                this.pos += n;
                this.rem -= n;
            }
            if (this.rem == 0L) {
                this.close();
            }
            return n;
        }
        
        @Override
        public int available() {
            return (this.rem > 2147483647L) ? Integer.MAX_VALUE : ((int)this.rem);
        }
        
        public long size() {
            return this.size;
        }
        
        @Override
        public void close() {
            if (this.closeRequested) {
                return;
            }
            this.closeRequested = true;
            this.rem = 0L;
            synchronized (ZipFile.this.res.istreams) {
                ZipFile.this.res.istreams.remove(this);
            }
        }
    }
}
