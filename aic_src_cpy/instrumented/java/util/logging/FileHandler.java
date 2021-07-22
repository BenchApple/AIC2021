// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.logging;

import instrumented.java.util.HashSet;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.io.OutputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import aic2021.engine.BytecodeManager;
import instrumented.java.util.Set;
import java.io.File;
import java.nio.channels.FileChannel;

public class FileHandler extends StreamHandler
{
    private MeteredStream meter;
    private boolean append;
    private int limit;
    private int count;
    private String pattern;
    private String lockFileName;
    private FileChannel lockFileChannel;
    private File[] files;
    private static final int MAX_LOCKS = 100;
    private static final Set<String> locks;
    
    private void open(final File file, final boolean append) throws IOException {
        try {
            int n = 0;
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            if (append) {
                BytecodeManager.incBytecodes(2);
                n = (int)file.length();
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(4);
            final String string = file.toString();
            BytecodeManager.incBytecodes(2);
            final FileOutputStream fileOutputStream = new FileOutputStream(string, append);
            BytecodeManager.incBytecodes(1);
            final FileOutputStream out = fileOutputStream;
            BytecodeManager.incBytecodes(4);
            final BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(out);
            BytecodeManager.incBytecodes(1);
            final BufferedOutputStream bufferedOutputStream2 = bufferedOutputStream;
            final int n2 = n;
            BytecodeManager.incBytecodes(7);
            this.meter = new MeteredStream(bufferedOutputStream2, n2);
            BytecodeManager.incBytecodes(1);
            final MeteredStream meter = this.meter;
            BytecodeManager.incBytecodes(4);
            this.setOutputStream(meter);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void configure() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     2: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     5: invokestatic    instrumented/java/util/logging/LogManager.getLogManager:()Linstrumented/java/util/logging/LogManager;
        //     8: astore_1       
        //     9: ldc             1
        //    11: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    14: aload_0        
        //    15: ldc             2
        //    17: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    20: invokevirtual   java/lang/Object.getClass:()Ljava/lang/Class;
        //    23: ldc             1
        //    25: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    28: invokevirtual   java/lang/Class.getName:()Ljava/lang/String;
        //    31: astore_2       
        //    32: ldc             1
        //    34: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    37: aload_0        
        //    38: aload_1        
        //    39: new             Ljava/lang/StringBuilder;
        //    42: dup            
        //    43: ldc             5
        //    45: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    48: invokespecial   java/lang/StringBuilder.<init>:()V
        //    51: aload_2        
        //    52: ldc             2
        //    54: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    57: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    60: ldc             ".pattern"
        //    62: ldc             2
        //    64: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    67: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    70: ldc             1
        //    72: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    75: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    78: ldc             "%h/java%u.log"
        //    80: ldc             2
        //    82: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    85: invokevirtual   instrumented/java/util/logging/LogManager.getStringProperty:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //    88: putfield        instrumented/java/util/logging/FileHandler.pattern:Ljava/lang/String;
        //    91: ldc             1
        //    93: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    96: aload_0        
        //    97: aload_1        
        //    98: new             Ljava/lang/StringBuilder;
        //   101: dup            
        //   102: ldc             5
        //   104: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   107: invokespecial   java/lang/StringBuilder.<init>:()V
        //   110: aload_2        
        //   111: ldc             2
        //   113: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   116: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   119: ldc             ".limit"
        //   121: ldc             2
        //   123: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   126: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   129: ldc             1
        //   131: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   134: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   137: iconst_0       
        //   138: ldc             2
        //   140: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   143: invokevirtual   instrumented/java/util/logging/LogManager.getIntProperty:(Ljava/lang/String;I)I
        //   146: putfield        instrumented/java/util/logging/FileHandler.limit:I
        //   149: ldc             1
        //   151: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   154: aload_0        
        //   155: getfield        instrumented/java/util/logging/FileHandler.limit:I
        //   158: ldc             3
        //   160: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   163: ifge            176
        //   166: aload_0        
        //   167: iconst_0       
        //   168: putfield        instrumented/java/util/logging/FileHandler.limit:I
        //   171: ldc             3
        //   173: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   176: aload_0        
        //   177: aload_1        
        //   178: new             Ljava/lang/StringBuilder;
        //   181: dup            
        //   182: ldc             5
        //   184: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   187: invokespecial   java/lang/StringBuilder.<init>:()V
        //   190: aload_2        
        //   191: ldc             2
        //   193: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   196: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   199: ldc             ".count"
        //   201: ldc             2
        //   203: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   206: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   209: ldc             1
        //   211: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   214: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   217: iconst_1       
        //   218: ldc             2
        //   220: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   223: invokevirtual   instrumented/java/util/logging/LogManager.getIntProperty:(Ljava/lang/String;I)I
        //   226: putfield        instrumented/java/util/logging/FileHandler.count:I
        //   229: ldc             1
        //   231: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   234: aload_0        
        //   235: getfield        instrumented/java/util/logging/FileHandler.count:I
        //   238: ldc             3
        //   240: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   243: ifgt            256
        //   246: aload_0        
        //   247: iconst_1       
        //   248: putfield        instrumented/java/util/logging/FileHandler.count:I
        //   251: ldc             3
        //   253: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   256: aload_0        
        //   257: aload_1        
        //   258: new             Ljava/lang/StringBuilder;
        //   261: dup            
        //   262: ldc             5
        //   264: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   267: invokespecial   java/lang/StringBuilder.<init>:()V
        //   270: aload_2        
        //   271: ldc             2
        //   273: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   276: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   279: ldc             ".append"
        //   281: ldc             2
        //   283: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   286: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   289: ldc             1
        //   291: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   294: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   297: iconst_0       
        //   298: ldc             2
        //   300: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   303: invokevirtual   instrumented/java/util/logging/LogManager.getBooleanProperty:(Ljava/lang/String;Z)Z
        //   306: putfield        instrumented/java/util/logging/FileHandler.append:Z
        //   309: ldc             1
        //   311: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   314: aload_0        
        //   315: aload_1        
        //   316: new             Ljava/lang/StringBuilder;
        //   319: dup            
        //   320: ldc             5
        //   322: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   325: invokespecial   java/lang/StringBuilder.<init>:()V
        //   328: aload_2        
        //   329: ldc             2
        //   331: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   334: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   337: ldc             ".level"
        //   339: ldc             2
        //   341: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   344: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   347: ldc             1
        //   349: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   352: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   355: getstatic       instrumented/java/util/logging/Level.ALL:Linstrumented/java/util/logging/Level;
        //   358: ldc             2
        //   360: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   363: invokevirtual   instrumented/java/util/logging/LogManager.getLevelProperty:(Ljava/lang/String;Linstrumented/java/util/logging/Level;)Linstrumented/java/util/logging/Level;
        //   366: ldc             1
        //   368: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   371: invokevirtual   instrumented/java/util/logging/FileHandler.setLevel:(Linstrumented/java/util/logging/Level;)V
        //   374: aload_0        
        //   375: aload_1        
        //   376: new             Ljava/lang/StringBuilder;
        //   379: dup            
        //   380: ldc             5
        //   382: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   385: invokespecial   java/lang/StringBuilder.<init>:()V
        //   388: aload_2        
        //   389: ldc             2
        //   391: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   394: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   397: ldc             ".filter"
        //   399: ldc             2
        //   401: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   404: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   407: ldc             1
        //   409: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   412: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   415: aconst_null    
        //   416: ldc             2
        //   418: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   421: invokevirtual   instrumented/java/util/logging/LogManager.getFilterProperty:(Ljava/lang/String;Linstrumented/java/util/logging/Filter;)Linstrumented/java/util/logging/Filter;
        //   424: ldc             1
        //   426: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   429: invokevirtual   instrumented/java/util/logging/FileHandler.setFilter:(Linstrumented/java/util/logging/Filter;)V
        //   432: aload_0        
        //   433: aload_1        
        //   434: new             Ljava/lang/StringBuilder;
        //   437: dup            
        //   438: ldc             5
        //   440: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   443: invokespecial   java/lang/StringBuilder.<init>:()V
        //   446: aload_2        
        //   447: ldc             2
        //   449: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   452: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   455: ldc             ".formatter"
        //   457: ldc             2
        //   459: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   462: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   465: ldc             1
        //   467: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   470: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   473: new             Linstrumented/java/util/logging/XMLFormatter;
        //   476: dup            
        //   477: ldc             3
        //   479: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   482: invokespecial   instrumented/java/util/logging/XMLFormatter.<init>:()V
        //   485: ldc             1
        //   487: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   490: invokevirtual   instrumented/java/util/logging/LogManager.getFormatterProperty:(Ljava/lang/String;Linstrumented/java/util/logging/Formatter;)Linstrumented/java/util/logging/Formatter;
        //   493: ldc             1
        //   495: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   498: invokevirtual   instrumented/java/util/logging/FileHandler.setFormatter:(Linstrumented/java/util/logging/Formatter;)V
        //   501: aload_0        
        //   502: aload_1        
        //   503: new             Ljava/lang/StringBuilder;
        //   506: dup            
        //   507: ldc             5
        //   509: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   512: invokespecial   java/lang/StringBuilder.<init>:()V
        //   515: aload_2        
        //   516: ldc             2
        //   518: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   521: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   524: ldc             ".encoding"
        //   526: ldc             2
        //   528: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   531: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   534: ldc             1
        //   536: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   539: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   542: aconst_null    
        //   543: ldc             2
        //   545: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   548: invokevirtual   instrumented/java/util/logging/LogManager.getStringProperty:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   551: ldc             1
        //   553: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   556: invokevirtual   instrumented/java/util/logging/FileHandler.setEncoding:(Ljava/lang/String;)V
        //   559: ldc             1
        //   561: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   564: goto            598
        //   567: astore_3       
        //   568: ldc             501
        //   570: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   573: aload_0        
        //   574: aconst_null    
        //   575: ldc             3
        //   577: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   580: invokevirtual   instrumented/java/util/logging/FileHandler.setEncoding:(Ljava/lang/String;)V
        //   583: ldc             1
        //   585: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   588: goto            598
        //   591: astore          4
        //   593: ldc             501
        //   595: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   598: ldc             1
        //   600: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   603: return         
        //   604: athrow         
        //   605: athrow         
        //    StackMapTable: 00 07 FD 00 B0 07 00 55 07 00 82 FB 00 4F F7 01 36 07 00 53 FF 00 17 00 04 07 00 02 07 00 55 07 00 82 07 00 53 00 01 07 00 53 FA 00 06 FF 00 05 00 00 00 01 07 00 4D FF 00 00 00 00 00 01 07 00 51
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  501    605    605    606    Ljava/lang/VirtualMachineError;
        //  501    559    567    598    Ljava/lang/Exception;
        //  573    583    591    598    Ljava/lang/Exception;
        //  0      604    604    605    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0598:
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
    
    public FileHandler() throws IOException, SecurityException {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            this.checkPermission();
            BytecodeManager.incBytecodes(2);
            this.configure();
            BytecodeManager.incBytecodes(2);
            this.openFiles();
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public FileHandler(final String pattern) throws IOException, SecurityException {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            final int length = pattern.length();
            final int n = 1;
            BytecodeManager.incBytecodes(2);
            if (length < n) {
                BytecodeManager.incBytecodes(3);
                final IllegalArgumentException ex = new IllegalArgumentException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(2);
            this.checkPermission();
            BytecodeManager.incBytecodes(2);
            this.configure();
            this.pattern = pattern;
            BytecodeManager.incBytecodes(3);
            this.limit = 0;
            BytecodeManager.incBytecodes(3);
            this.count = 1;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(2);
            this.openFiles();
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public FileHandler(final String pattern, final boolean append) throws IOException, SecurityException {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            final int length = pattern.length();
            final int n = 1;
            BytecodeManager.incBytecodes(2);
            if (length < n) {
                BytecodeManager.incBytecodes(3);
                final IllegalArgumentException ex = new IllegalArgumentException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(2);
            this.checkPermission();
            BytecodeManager.incBytecodes(2);
            this.configure();
            this.pattern = pattern;
            BytecodeManager.incBytecodes(3);
            this.limit = 0;
            BytecodeManager.incBytecodes(3);
            this.count = 1;
            BytecodeManager.incBytecodes(3);
            this.append = append;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(2);
            this.openFiles();
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public FileHandler(final String pattern, final int limit, final int count) throws IOException, SecurityException {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            if (limit >= 0) {
                final int n = 1;
                BytecodeManager.incBytecodes(3);
                if (count >= n) {
                    BytecodeManager.incBytecodes(2);
                    final int length = pattern.length();
                    final int n2 = 1;
                    BytecodeManager.incBytecodes(2);
                    if (length >= n2) {
                        BytecodeManager.incBytecodes(2);
                        this.checkPermission();
                        BytecodeManager.incBytecodes(2);
                        this.configure();
                        this.pattern = pattern;
                        BytecodeManager.incBytecodes(3);
                        this.limit = limit;
                        BytecodeManager.incBytecodes(3);
                        this.count = count;
                        BytecodeManager.incBytecodes(3);
                        BytecodeManager.incBytecodes(2);
                        this.openFiles();
                        BytecodeManager.incBytecodes(1);
                        return;
                    }
                }
            }
            BytecodeManager.incBytecodes(3);
            final IllegalArgumentException ex = new IllegalArgumentException();
            BytecodeManager.incBytecodes(1);
            throw ex;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public FileHandler(final String pattern, final int limit, final int count, final boolean append) throws IOException, SecurityException {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            if (limit >= 0) {
                final int n = 1;
                BytecodeManager.incBytecodes(3);
                if (count >= n) {
                    BytecodeManager.incBytecodes(2);
                    final int length = pattern.length();
                    final int n2 = 1;
                    BytecodeManager.incBytecodes(2);
                    if (length >= n2) {
                        BytecodeManager.incBytecodes(2);
                        this.checkPermission();
                        BytecodeManager.incBytecodes(2);
                        this.configure();
                        this.pattern = pattern;
                        BytecodeManager.incBytecodes(3);
                        this.limit = limit;
                        BytecodeManager.incBytecodes(3);
                        this.count = count;
                        BytecodeManager.incBytecodes(3);
                        this.append = append;
                        BytecodeManager.incBytecodes(3);
                        BytecodeManager.incBytecodes(2);
                        this.openFiles();
                        BytecodeManager.incBytecodes(1);
                        return;
                    }
                }
            }
            BytecodeManager.incBytecodes(3);
            final IllegalArgumentException ex = new IllegalArgumentException();
            BytecodeManager.incBytecodes(1);
            throw ex;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private boolean isParentWritable(final Path path) {
        try {
            BytecodeManager.incBytecodes(2);
            Path path2 = path.getParent();
            BytecodeManager.incBytecodes(1);
            final Path path3 = path2;
            BytecodeManager.incBytecodes(2);
            if (path3 == null) {
                BytecodeManager.incBytecodes(2);
                final Path absolutePath = path.toAbsolutePath();
                BytecodeManager.incBytecodes(1);
                path2 = absolutePath.getParent();
                BytecodeManager.incBytecodes(1);
            }
            final Path path4 = path2;
            BytecodeManager.incBytecodes(2);
            boolean b = false;
            Label_0094: {
                if (path4 != null) {
                    final Path path5 = path2;
                    BytecodeManager.incBytecodes(2);
                    final boolean writable = Files.isWritable(path5);
                    BytecodeManager.incBytecodes(1);
                    if (writable) {
                        b = true;
                        BytecodeManager.incBytecodes(2);
                        break Label_0094;
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
    
    private void openFiles() throws IOException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     2: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     5: invokestatic    instrumented/java/util/logging/LogManager.getLogManager:()Linstrumented/java/util/logging/LogManager;
        //     8: astore_1       
        //     9: ldc             1
        //    11: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    14: aload_1        
        //    15: ldc             2
        //    17: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    20: invokevirtual   instrumented/java/util/logging/LogManager.checkPermission:()V
        //    23: aload_0        
        //    24: getfield        instrumented/java/util/logging/FileHandler.count:I
        //    27: iconst_1       
        //    28: ldc             4
        //    30: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    33: if_icmpge       96
        //    36: new             Ljava/lang/IllegalArgumentException;
        //    39: dup            
        //    40: new             Ljava/lang/StringBuilder;
        //    43: dup            
        //    44: ldc             5
        //    46: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    49: invokespecial   java/lang/StringBuilder.<init>:()V
        //    52: ldc             "file count = "
        //    54: ldc             2
        //    56: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    59: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    62: aload_0        
        //    63: getfield        instrumented/java/util/logging/FileHandler.count:I
        //    66: ldc             3
        //    68: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    71: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //    74: ldc             1
        //    76: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    79: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    82: ldc             1
        //    84: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    87: invokespecial   java/lang/IllegalArgumentException.<init>:(Ljava/lang/String;)V
        //    90: ldc             1
        //    92: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    95: athrow         
        //    96: aload_0        
        //    97: getfield        instrumented/java/util/logging/FileHandler.limit:I
        //   100: ldc             3
        //   102: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   105: ifge            118
        //   108: aload_0        
        //   109: iconst_0       
        //   110: putfield        instrumented/java/util/logging/FileHandler.limit:I
        //   113: ldc             3
        //   115: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   118: new             Linstrumented/java/util/logging/FileHandler$InitializationErrorManager;
        //   121: dup            
        //   122: aconst_null    
        //   123: ldc             4
        //   125: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   128: invokespecial   instrumented/java/util/logging/FileHandler$InitializationErrorManager.<init>:(Linstrumented/java/util/logging/FileHandler$1;)V
        //   131: astore_2       
        //   132: ldc             1
        //   134: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   137: aload_0        
        //   138: aload_2        
        //   139: ldc             3
        //   141: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   144: invokevirtual   instrumented/java/util/logging/FileHandler.setErrorManager:(Linstrumented/java/util/logging/ErrorManager;)V
        //   147: iconst_m1      
        //   148: istore_3       
        //   149: ldc             2
        //   151: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   154: iinc            3, 1
        //   157: ldc             1
        //   159: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   162: iload_3        
        //   163: bipush          100
        //   165: ldc             3
        //   167: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   170: if_icmple       233
        //   173: new             Ljava/io/IOException;
        //   176: dup            
        //   177: new             Ljava/lang/StringBuilder;
        //   180: dup            
        //   181: ldc             5
        //   183: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   186: invokespecial   java/lang/StringBuilder.<init>:()V
        //   189: ldc             "Couldn't get lock for "
        //   191: ldc             2
        //   193: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   196: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   199: aload_0        
        //   200: getfield        instrumented/java/util/logging/FileHandler.pattern:Ljava/lang/String;
        //   203: ldc             3
        //   205: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   208: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   211: ldc             1
        //   213: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   216: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   219: ldc             1
        //   221: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   224: invokespecial   java/io/IOException.<init>:(Ljava/lang/String;)V
        //   227: ldc             1
        //   229: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   232: athrow         
        //   233: aload_0        
        //   234: new             Ljava/lang/StringBuilder;
        //   237: dup            
        //   238: ldc             4
        //   240: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   243: invokespecial   java/lang/StringBuilder.<init>:()V
        //   246: aload_0        
        //   247: aload_0        
        //   248: getfield        instrumented/java/util/logging/FileHandler.pattern:Ljava/lang/String;
        //   251: iconst_0       
        //   252: iload_3        
        //   253: ldc             6
        //   255: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   258: invokespecial   instrumented/java/util/logging/FileHandler.generate:(Ljava/lang/String;II)Ljava/io/File;
        //   261: ldc             1
        //   263: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   266: invokevirtual   java/io/File.toString:()Ljava/lang/String;
        //   269: ldc             1
        //   271: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   274: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   277: ldc             ".lck"
        //   279: ldc             2
        //   281: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   284: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   287: ldc             1
        //   289: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   292: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   295: putfield        instrumented/java/util/logging/FileHandler.lockFileName:Ljava/lang/String;
        //   298: ldc             1
        //   300: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   303: getstatic       instrumented/java/util/logging/FileHandler.locks:Linstrumented/java/util/Set;
        //   306: dup            
        //   307: astore          4
        //   309: pop            
        //   310: ldc             4
        //   312: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   315: getstatic       instrumented/java/util/logging/FileHandler.locks:Linstrumented/java/util/Set;
        //   318: aload_0        
        //   319: getfield        instrumented/java/util/logging/FileHandler.lockFileName:Ljava/lang/String;
        //   322: ldc             4
        //   324: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   327: invokeinterface instrumented/java/util/Set.contains:(Ljava/lang/Object;)Z
        //   332: ldc             1
        //   334: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   337: ifeq            356
        //   340: aload           4
        //   342: pop            
        //   343: ldc             2
        //   345: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   348: ldc             1
        //   350: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   353: goto            154
        //   356: aload_0        
        //   357: getfield        instrumented/java/util/logging/FileHandler.lockFileName:Ljava/lang/String;
        //   360: iconst_0       
        //   361: anewarray       Ljava/lang/String;
        //   364: ldc             4
        //   366: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   369: invokestatic    java/nio/file/Paths.get:(Ljava/lang/String;[Ljava/lang/String;)Ljava/nio/file/Path;
        //   372: astore          5
        //   374: ldc             1
        //   376: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   379: aconst_null    
        //   380: astore          6
        //   382: ldc             2
        //   384: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   387: iconst_m1      
        //   388: istore          7
        //   390: ldc             2
        //   392: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   395: iconst_0       
        //   396: istore          8
        //   398: ldc             2
        //   400: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   403: aload           6
        //   405: ldc             2
        //   407: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   410: ifnonnull       624
        //   413: iload           7
        //   415: iinc            7, 1
        //   418: iconst_1       
        //   419: ldc             4
        //   421: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   424: if_icmpge       624
        //   427: aload           5
        //   429: iconst_2       
        //   430: anewarray       Ljava/nio/file/OpenOption;
        //   433: dup            
        //   434: iconst_0       
        //   435: getstatic       java/nio/file/StandardOpenOption.CREATE_NEW:Ljava/nio/file/StandardOpenOption;
        //   438: aastore        
        //   439: dup            
        //   440: iconst_1       
        //   441: getstatic       java/nio/file/StandardOpenOption.WRITE:Ljava/nio/file/StandardOpenOption;
        //   444: aastore        
        //   445: ldc_w           11
        //   448: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   451: invokestatic    java/nio/channels/FileChannel.open:(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Ljava/nio/channels/FileChannel;
        //   454: astore          6
        //   456: ldc             1
        //   458: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   461: iconst_1       
        //   462: istore          8
        //   464: ldc             2
        //   466: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   469: ldc             1
        //   471: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   474: goto            403
        //   477: astore          9
        //   479: ldc             501
        //   481: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   484: aload           5
        //   486: iconst_1       
        //   487: anewarray       Ljava/nio/file/LinkOption;
        //   490: dup            
        //   491: iconst_0       
        //   492: getstatic       java/nio/file/LinkOption.NOFOLLOW_LINKS:Ljava/nio/file/LinkOption;
        //   495: aastore        
        //   496: ldc             7
        //   498: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   501: invokestatic    java/nio/file/Files.isRegularFile:(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Z
        //   504: ldc             1
        //   506: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   509: ifeq            608
        //   512: aload_0        
        //   513: aload           5
        //   515: ldc             2
        //   517: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   520: ldc             1
        //   522: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   525: invokespecial   instrumented/java/util/logging/FileHandler.isParentWritable:(Ljava/nio/file/Path;)Z
        //   528: ldc             1
        //   530: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   533: ifeq            608
        //   536: aload           5
        //   538: iconst_2       
        //   539: anewarray       Ljava/nio/file/OpenOption;
        //   542: dup            
        //   543: iconst_0       
        //   544: getstatic       java/nio/file/StandardOpenOption.WRITE:Ljava/nio/file/StandardOpenOption;
        //   547: aastore        
        //   548: dup            
        //   549: iconst_1       
        //   550: getstatic       java/nio/file/StandardOpenOption.APPEND:Ljava/nio/file/StandardOpenOption;
        //   553: aastore        
        //   554: ldc_w           11
        //   557: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   560: invokestatic    java/nio/channels/FileChannel.open:(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Ljava/nio/channels/FileChannel;
        //   563: astore          6
        //   565: ldc             1
        //   567: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   570: ldc             1
        //   572: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   575: goto            616
        //   578: astore          10
        //   580: ldc             501
        //   582: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   585: ldc             1
        //   587: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   590: goto            403
        //   593: astore          10
        //   595: ldc             501
        //   597: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   600: ldc             1
        //   602: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   605: goto            624
        //   608: ldc             1
        //   610: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   613: goto            624
        //   616: ldc             1
        //   618: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   621: goto            403
        //   624: aload           6
        //   626: ldc             2
        //   628: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   631: ifnonnull       650
        //   634: aload           4
        //   636: pop            
        //   637: ldc             2
        //   639: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   642: ldc             1
        //   644: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   647: goto            154
        //   650: aload_0        
        //   651: aload           6
        //   653: putfield        instrumented/java/util/logging/FileHandler.lockFileChannel:Ljava/nio/channels/FileChannel;
        //   656: ldc             3
        //   658: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   661: aload_0        
        //   662: getfield        instrumented/java/util/logging/FileHandler.lockFileChannel:Ljava/nio/channels/FileChannel;
        //   665: ldc             3
        //   667: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   670: invokevirtual   java/nio/channels/FileChannel.tryLock:()Ljava/nio/channels/FileLock;
        //   673: ldc             1
        //   675: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   678: ifnull          690
        //   681: iconst_1       
        //   682: ldc             2
        //   684: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   687: goto            696
        //   690: iconst_0       
        //   691: ldc             1
        //   693: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   696: istore          9
        //   698: ldc             1
        //   700: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   703: ldc             1
        //   705: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   708: goto            750
        //   711: astore          10
        //   713: ldc             501
        //   715: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   718: iload           8
        //   720: istore          9
        //   722: ldc             2
        //   724: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   727: ldc             1
        //   729: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   732: goto            750
        //   735: astore          10
        //   737: ldc             501
        //   739: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   742: iconst_0       
        //   743: istore          9
        //   745: ldc             2
        //   747: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   750: iload           9
        //   752: ldc             2
        //   754: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   757: ifeq            799
        //   760: getstatic       instrumented/java/util/logging/FileHandler.locks:Linstrumented/java/util/Set;
        //   763: aload_0        
        //   764: getfield        instrumented/java/util/logging/FileHandler.lockFileName:Ljava/lang/String;
        //   767: ldc             4
        //   769: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   772: invokeinterface instrumented/java/util/Set.add:(Ljava/lang/Object;)Z
        //   777: pop            
        //   778: ldc             1
        //   780: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   783: aload           4
        //   785: pop            
        //   786: ldc             2
        //   788: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   791: ldc             1
        //   793: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   796: goto            854
        //   799: aload_0        
        //   800: getfield        instrumented/java/util/logging/FileHandler.lockFileChannel:Ljava/nio/channels/FileChannel;
        //   803: ldc             3
        //   805: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   808: invokevirtual   java/nio/channels/FileChannel.close:()V
        //   811: aload           4
        //   813: pop            
        //   814: ldc             2
        //   816: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   819: ldc             1
        //   821: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   824: goto            846
        //   827: astore          11
        //   829: aload           4
        //   831: pop            
        //   832: ldc_w           503
        //   835: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   838: aload           11
        //   840: ldc             2
        //   842: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   845: athrow         
        //   846: ldc             1
        //   848: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   851: goto            154
        //   854: aload_0        
        //   855: aload_0        
        //   856: getfield        instrumented/java/util/logging/FileHandler.count:I
        //   859: anewarray       Ljava/io/File;
        //   862: putfield        instrumented/java/util/logging/FileHandler.files:[Ljava/io/File;
        //   865: ldc             4
        //   867: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   870: iconst_0       
        //   871: istore          4
        //   873: ldc             2
        //   875: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   878: iload           4
        //   880: aload_0        
        //   881: getfield        instrumented/java/util/logging/FileHandler.count:I
        //   884: ldc             4
        //   886: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   889: if_icmpge       932
        //   892: aload_0        
        //   893: getfield        instrumented/java/util/logging/FileHandler.files:[Ljava/io/File;
        //   896: iload           4
        //   898: aload_0        
        //   899: aload_0        
        //   900: getfield        instrumented/java/util/logging/FileHandler.pattern:Ljava/lang/String;
        //   903: iload           4
        //   905: iload_3        
        //   906: ldc_w           9
        //   909: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   912: invokespecial   instrumented/java/util/logging/FileHandler.generate:(Ljava/lang/String;II)Ljava/io/File;
        //   915: aastore        
        //   916: ldc             1
        //   918: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   921: iinc            4, 1
        //   924: ldc             2
        //   926: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   929: goto            878
        //   932: aload_0        
        //   933: getfield        instrumented/java/util/logging/FileHandler.append:Z
        //   936: ldc             3
        //   938: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   941: ifeq            968
        //   944: aload_0        
        //   945: aload_0        
        //   946: getfield        instrumented/java/util/logging/FileHandler.files:[Ljava/io/File;
        //   949: iconst_0       
        //   950: aaload         
        //   951: iconst_1       
        //   952: ldc             7
        //   954: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   957: invokespecial   instrumented/java/util/logging/FileHandler.open:(Ljava/io/File;Z)V
        //   960: ldc             1
        //   962: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   965: goto            977
        //   968: aload_0        
        //   969: ldc             2
        //   971: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   974: invokespecial   instrumented/java/util/logging/FileHandler.rotate:()V
        //   977: aload_2        
        //   978: getfield        instrumented/java/util/logging/FileHandler$InitializationErrorManager.lastException:Ljava/lang/Exception;
        //   981: astore          4
        //   983: ldc             3
        //   985: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   988: aload           4
        //   990: ldc             2
        //   992: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   995: ifnull          1105
        //   998: aload           4
        //  1000: instanceof      Ljava/io/IOException;
        //  1003: ldc             3
        //  1005: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1008: ifeq            1022
        //  1011: aload           4
        //  1013: checkcast       Ljava/io/IOException;
        //  1016: ldc             3
        //  1018: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1021: athrow         
        //  1022: aload           4
        //  1024: instanceof      Ljava/lang/SecurityException;
        //  1027: ldc             3
        //  1029: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1032: ifeq            1046
        //  1035: aload           4
        //  1037: checkcast       Ljava/lang/SecurityException;
        //  1040: ldc             3
        //  1042: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1045: athrow         
        //  1046: new             Ljava/io/IOException;
        //  1049: dup            
        //  1050: new             Ljava/lang/StringBuilder;
        //  1053: dup            
        //  1054: ldc             5
        //  1056: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1059: invokespecial   java/lang/StringBuilder.<init>:()V
        //  1062: ldc_w           "Exception: "
        //  1065: ldc             2
        //  1067: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1070: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  1073: aload           4
        //  1075: ldc             2
        //  1077: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1080: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //  1083: ldc             1
        //  1085: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1088: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //  1091: ldc             1
        //  1093: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1096: invokespecial   java/io/IOException.<init>:(Ljava/lang/String;)V
        //  1099: ldc             1
        //  1101: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1104: athrow         
        //  1105: aload_0        
        //  1106: new             Linstrumented/java/util/logging/ErrorManager;
        //  1109: dup            
        //  1110: ldc             4
        //  1112: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1115: invokespecial   instrumented/java/util/logging/ErrorManager.<init>:()V
        //  1118: ldc             1
        //  1120: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1123: invokevirtual   instrumented/java/util/logging/FileHandler.setErrorManager:(Linstrumented/java/util/logging/ErrorManager;)V
        //  1126: ldc             1
        //  1128: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1131: return         
        //  1132: athrow         
        //  1133: athrow         
        //    Exceptions:
        //  throws java.io.IOException
        //    StackMapTable: 00 1F FC 00 60 07 00 55 15 FD 00 23 07 00 09 01 FB 00 4E FC 00 7A 07 00 5B FF 00 2E 00 09 07 00 02 07 00 55 07 00 09 01 07 00 5B 07 00 D3 07 01 10 01 01 00 00 F7 00 49 07 00 E1 FF 00 64 00 0A 07 00 02 07 00 55 07 00 09 01 07 00 5B 07 00 D3 07 01 10 01 01 07 00 E1 00 01 07 00 E3 4E 07 00 24 0E FA 00 07 07 19 27 45 01 4E 07 00 24 57 07 00 E5 FC 00 0E 01 30 FF 00 1B 00 05 07 00 02 07 00 55 07 00 09 01 07 00 5B 00 01 07 00 4D FA 00 12 07 FC 00 17 01 FA 00 35 23 08 FC 00 2C 07 00 53 17 3A FF 00 1A 00 00 00 01 07 00 4D FF 00 00 00 00 00 01 07 00 51
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                            
        //  -----  -----  -----  -----  ------------------------------------------------
        //  315    1133   1133   1134   Ljava/lang/VirtualMachineError;
        //  427    469    477    624    Ljava/nio/file/FileAlreadyExistsException;
        //  536    570    578    593    Ljava/nio/file/NoSuchFileException;
        //  536    570    593    608    Ljava/io/IOException;
        //  661    703    711    735    Ljava/io/IOException;
        //  661    703    735    750    Ljava/nio/channels/OverlappingFileLockException;
        //  315    348    827    846    Any
        //  356    642    827    846    Any
        //  650    791    827    846    Any
        //  799    819    827    846    Any
        //  827    838    827    846    Any
        //  0      1132   1132   1133   Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0356:
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
    
    private File generate(final String s, final int n, final int n2) throws IOException {
        try {
            File file = null;
            BytecodeManager.incBytecodes(2);
            String s2 = "";
            BytecodeManager.incBytecodes(2);
            int n3 = 0;
            BytecodeManager.incBytecodes(2);
            boolean b = false;
            BytecodeManager.incBytecodes(2);
            boolean b2 = false;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n4 = n3;
                BytecodeManager.incBytecodes(3);
                final int length = s.length();
                BytecodeManager.incBytecodes(1);
                if (n4 >= length) {
                    final int count = this.count;
                    final int n5 = 1;
                    BytecodeManager.incBytecodes(4);
                    if (count > n5) {
                        final boolean b3 = b;
                        BytecodeManager.incBytecodes(2);
                        if (!b3) {
                            BytecodeManager.incBytecodes(3);
                            final StringBuilder sb = new StringBuilder();
                            final String str = s2;
                            BytecodeManager.incBytecodes(2);
                            final StringBuilder append = sb.append(str);
                            final String str2 = ".";
                            BytecodeManager.incBytecodes(2);
                            final StringBuilder append2 = append.append(str2);
                            BytecodeManager.incBytecodes(2);
                            final StringBuilder append3 = append2.append(n);
                            BytecodeManager.incBytecodes(1);
                            s2 = append3.toString();
                            BytecodeManager.incBytecodes(1);
                        }
                    }
                    BytecodeManager.incBytecodes(2);
                    if (n2 > 0) {
                        final boolean b4 = b2;
                        BytecodeManager.incBytecodes(2);
                        if (!b4) {
                            BytecodeManager.incBytecodes(3);
                            final StringBuilder sb2 = new StringBuilder();
                            final String str3 = s2;
                            BytecodeManager.incBytecodes(2);
                            final StringBuilder append4 = sb2.append(str3);
                            final String str4 = ".";
                            BytecodeManager.incBytecodes(2);
                            final StringBuilder append5 = append4.append(str4);
                            BytecodeManager.incBytecodes(2);
                            final StringBuilder append6 = append5.append(n2);
                            BytecodeManager.incBytecodes(1);
                            s2 = append6.toString();
                            BytecodeManager.incBytecodes(1);
                        }
                    }
                    final String s3 = s2;
                    BytecodeManager.incBytecodes(2);
                    final int length2 = s3.length();
                    BytecodeManager.incBytecodes(1);
                    if (length2 > 0) {
                        final File file2 = file;
                        BytecodeManager.incBytecodes(2);
                        if (file2 == null) {
                            final String pathname = s2;
                            BytecodeManager.incBytecodes(4);
                            file = new File(pathname);
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            final File parent = file;
                            final String child = s2;
                            BytecodeManager.incBytecodes(5);
                            file = new File(parent, child);
                            BytecodeManager.incBytecodes(1);
                        }
                    }
                    final File file3 = file;
                    BytecodeManager.incBytecodes(2);
                    return file3;
                }
                final int index = n3;
                BytecodeManager.incBytecodes(3);
                final char char1 = s.charAt(index);
                BytecodeManager.incBytecodes(1);
                ++n3;
                BytecodeManager.incBytecodes(1);
                char lowerCase = '\0';
                BytecodeManager.incBytecodes(2);
                final int n6 = n3;
                BytecodeManager.incBytecodes(3);
                final int length3 = s.length();
                BytecodeManager.incBytecodes(1);
                if (n6 < length3) {
                    final int index2 = n3;
                    BytecodeManager.incBytecodes(3);
                    final char char2 = s.charAt(index2);
                    BytecodeManager.incBytecodes(1);
                    lowerCase = Character.toLowerCase(char2);
                    BytecodeManager.incBytecodes(1);
                }
                final char c = char1;
                final int n7 = '/';
                BytecodeManager.incBytecodes(3);
                if (c == n7) {
                    final File file4 = file;
                    BytecodeManager.incBytecodes(2);
                    if (file4 == null) {
                        final String pathname2 = s2;
                        BytecodeManager.incBytecodes(4);
                        file = new File(pathname2);
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        final File parent2 = file;
                        final String child2 = s2;
                        BytecodeManager.incBytecodes(5);
                        file = new File(parent2, child2);
                        BytecodeManager.incBytecodes(1);
                    }
                    s2 = "";
                    BytecodeManager.incBytecodes(2);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    final char c2 = char1;
                    final int n8 = '%';
                    BytecodeManager.incBytecodes(3);
                    if (c2 == n8) {
                        final char c3 = lowerCase;
                        final int n9 = 't';
                        BytecodeManager.incBytecodes(3);
                        if (c3 == n9) {
                            final String key = "java.io.tmpdir";
                            BytecodeManager.incBytecodes(2);
                            String s4 = System.getProperty(key);
                            BytecodeManager.incBytecodes(1);
                            final String s5 = s4;
                            BytecodeManager.incBytecodes(2);
                            if (s5 == null) {
                                final String key2 = "user.home";
                                BytecodeManager.incBytecodes(2);
                                s4 = System.getProperty(key2);
                                BytecodeManager.incBytecodes(1);
                            }
                            final String pathname3 = s4;
                            BytecodeManager.incBytecodes(4);
                            file = new File(pathname3);
                            BytecodeManager.incBytecodes(1);
                            ++n3;
                            BytecodeManager.incBytecodes(1);
                            s2 = "";
                            BytecodeManager.incBytecodes(2);
                            BytecodeManager.incBytecodes(1);
                            continue;
                        }
                        final char c4 = lowerCase;
                        final int n10 = 'h';
                        BytecodeManager.incBytecodes(3);
                        if (c4 == n10) {
                            final String key3 = "user.home";
                            BytecodeManager.incBytecodes(4);
                            final String property = System.getProperty(key3);
                            BytecodeManager.incBytecodes(1);
                            file = new File(property);
                            BytecodeManager.incBytecodes(1);
                            BytecodeManager.incBytecodes(1);
                            final boolean setUID = isSetUID();
                            BytecodeManager.incBytecodes(1);
                            if (setUID) {
                                final String message = "can't use %h in set UID program";
                                BytecodeManager.incBytecodes(4);
                                final IOException ex = new IOException(message);
                                BytecodeManager.incBytecodes(1);
                                throw ex;
                            }
                            ++n3;
                            BytecodeManager.incBytecodes(1);
                            s2 = "";
                            BytecodeManager.incBytecodes(2);
                            BytecodeManager.incBytecodes(1);
                            continue;
                        }
                        else {
                            final char c5 = lowerCase;
                            final int n11 = 'g';
                            BytecodeManager.incBytecodes(3);
                            if (c5 == n11) {
                                BytecodeManager.incBytecodes(3);
                                final StringBuilder sb3 = new StringBuilder();
                                final String str5 = s2;
                                BytecodeManager.incBytecodes(2);
                                final StringBuilder append7 = sb3.append(str5);
                                BytecodeManager.incBytecodes(2);
                                final StringBuilder append8 = append7.append(n);
                                BytecodeManager.incBytecodes(1);
                                s2 = append8.toString();
                                BytecodeManager.incBytecodes(1);
                                b = true;
                                BytecodeManager.incBytecodes(2);
                                ++n3;
                                BytecodeManager.incBytecodes(1);
                                BytecodeManager.incBytecodes(1);
                                continue;
                            }
                            final char c6 = lowerCase;
                            final int n12 = 'u';
                            BytecodeManager.incBytecodes(3);
                            if (c6 == n12) {
                                BytecodeManager.incBytecodes(3);
                                final StringBuilder sb4 = new StringBuilder();
                                final String str6 = s2;
                                BytecodeManager.incBytecodes(2);
                                final StringBuilder append9 = sb4.append(str6);
                                BytecodeManager.incBytecodes(2);
                                final StringBuilder append10 = append9.append(n2);
                                BytecodeManager.incBytecodes(1);
                                s2 = append10.toString();
                                BytecodeManager.incBytecodes(1);
                                b2 = true;
                                BytecodeManager.incBytecodes(2);
                                ++n3;
                                BytecodeManager.incBytecodes(1);
                                BytecodeManager.incBytecodes(1);
                                continue;
                            }
                            final char c7 = lowerCase;
                            final int n13 = '%';
                            BytecodeManager.incBytecodes(3);
                            if (c7 == n13) {
                                BytecodeManager.incBytecodes(3);
                                final StringBuilder sb5 = new StringBuilder();
                                final String str7 = s2;
                                BytecodeManager.incBytecodes(2);
                                final StringBuilder append11 = sb5.append(str7);
                                final String str8 = "%";
                                BytecodeManager.incBytecodes(2);
                                final StringBuilder append12 = append11.append(str8);
                                BytecodeManager.incBytecodes(1);
                                s2 = append12.toString();
                                BytecodeManager.incBytecodes(1);
                                ++n3;
                                BytecodeManager.incBytecodes(1);
                                BytecodeManager.incBytecodes(1);
                                continue;
                            }
                        }
                    }
                    BytecodeManager.incBytecodes(3);
                    final StringBuilder sb6 = new StringBuilder();
                    final String str9 = s2;
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append13 = sb6.append(str9);
                    final char c8 = char1;
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append14 = append13.append(c8);
                    BytecodeManager.incBytecodes(1);
                    s2 = append14.toString();
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                }
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private synchronized void rotate() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             2
        //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     6: invokevirtual   instrumented/java/util/logging/FileHandler.getLevel:()Linstrumented/java/util/logging/Level;
        //     9: astore_1       
        //    10: ldc             1
        //    12: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    15: aload_0        
        //    16: getstatic       instrumented/java/util/logging/Level.OFF:Linstrumented/java/util/logging/Level;
        //    19: ldc             3
        //    21: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    24: invokevirtual   instrumented/java/util/logging/FileHandler.setLevel:(Linstrumented/java/util/logging/Level;)V
        //    27: aload_0        
        //    28: ldc             2
        //    30: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    33: invokespecial   instrumented/java/util/logging/StreamHandler.close:()V
        //    36: aload_0        
        //    37: getfield        instrumented/java/util/logging/FileHandler.count:I
        //    40: iconst_2       
        //    41: isub           
        //    42: istore_2       
        //    43: ldc             5
        //    45: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    48: iload_2        
        //    49: ldc             2
        //    51: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    54: iflt            163
        //    57: aload_0        
        //    58: getfield        instrumented/java/util/logging/FileHandler.files:[Ljava/io/File;
        //    61: iload_2        
        //    62: aaload         
        //    63: astore_3       
        //    64: ldc             5
        //    66: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    69: aload_0        
        //    70: getfield        instrumented/java/util/logging/FileHandler.files:[Ljava/io/File;
        //    73: iload_2        
        //    74: iconst_1       
        //    75: iadd           
        //    76: aaload         
        //    77: astore          4
        //    79: ldc             7
        //    81: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    84: aload_3        
        //    85: ldc             2
        //    87: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    90: invokevirtual   java/io/File.exists:()Z
        //    93: ldc             1
        //    95: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    98: ifeq            152
        //   101: aload           4
        //   103: ldc             2
        //   105: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   108: invokevirtual   java/io/File.exists:()Z
        //   111: ldc             1
        //   113: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   116: ifeq            135
        //   119: aload           4
        //   121: ldc             2
        //   123: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   126: invokevirtual   java/io/File.delete:()Z
        //   129: pop            
        //   130: ldc             1
        //   132: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   135: aload_3        
        //   136: aload           4
        //   138: ldc             3
        //   140: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   143: invokevirtual   java/io/File.renameTo:(Ljava/io/File;)Z
        //   146: pop            
        //   147: ldc             1
        //   149: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   152: iinc            2, -1
        //   155: ldc             2
        //   157: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   160: goto            48
        //   163: aload_0        
        //   164: aload_0        
        //   165: getfield        instrumented/java/util/logging/FileHandler.files:[Ljava/io/File;
        //   168: iconst_0       
        //   169: aaload         
        //   170: iconst_0       
        //   171: ldc             7
        //   173: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   176: invokespecial   instrumented/java/util/logging/FileHandler.open:(Ljava/io/File;Z)V
        //   179: ldc             1
        //   181: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   184: goto            205
        //   187: astore_2       
        //   188: ldc             501
        //   190: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   193: aload_0        
        //   194: aconst_null    
        //   195: aload_2        
        //   196: iconst_4       
        //   197: ldc             5
        //   199: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   202: invokevirtual   instrumented/java/util/logging/FileHandler.reportError:(Ljava/lang/String;Ljava/lang/Exception;I)V
        //   205: aload_0        
        //   206: aload_1        
        //   207: ldc             3
        //   209: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   212: invokevirtual   instrumented/java/util/logging/FileHandler.setLevel:(Linstrumented/java/util/logging/Level;)V
        //   215: ldc             1
        //   217: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   220: return         
        //   221: athrow         
        //   222: athrow         
        //    StackMapTable: 00 08 FD 00 30 07 00 92 01 FD 00 56 07 00 2D 07 00 2D F9 00 10 FA 00 0A 57 07 00 24 11 FF 00 0F 00 00 00 01 07 00 4D FF 00 00 00 00 00 01 07 00 51
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  163    222    222    223    Ljava/lang/VirtualMachineError;
        //  163    179    187    205    Ljava/io/IOException;
        //  0      221    221    222    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0163:
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
    public synchronized void publish(final LogRecord logRecord) {
        try {
            BytecodeManager.incBytecodes(3);
            final boolean loggable = this.isLoggable(logRecord);
            BytecodeManager.incBytecodes(1);
            if (!loggable) {
                BytecodeManager.incBytecodes(1);
                return;
            }
            BytecodeManager.incBytecodes(3);
            super.publish(logRecord);
            BytecodeManager.incBytecodes(2);
            this.flush();
            final int limit = this.limit;
            BytecodeManager.incBytecodes(3);
            if (limit > 0) {
                final int written = this.meter.written;
                final int limit2 = this.limit;
                BytecodeManager.incBytecodes(6);
                if (written >= limit2) {
                    BytecodeManager.incBytecodes(4);
                    final PrivilegedAction<Object> action = new PrivilegedAction<Object>() {
                        {
                            BytecodeManager.incBytecodes(1);
                        }
                        
                        @Override
                        public Object run() {
                            try {
                                final FileHandler this$0 = FileHandler.this;
                                BytecodeManager.incBytecodes(3);
                                FileHandler.access$100(this$0);
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
                }
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public synchronized void close() throws SecurityException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             2
        //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     6: invokespecial   instrumented/java/util/logging/StreamHandler.close:()V
        //     9: aload_0        
        //    10: getfield        instrumented/java/util/logging/FileHandler.lockFileName:Ljava/lang/String;
        //    13: ldc             3
        //    15: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    18: ifnonnull       27
        //    21: ldc             1
        //    23: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    26: return         
        //    27: aload_0        
        //    28: getfield        instrumented/java/util/logging/FileHandler.lockFileChannel:Ljava/nio/channels/FileChannel;
        //    31: ldc             3
        //    33: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    36: invokevirtual   java/nio/channels/FileChannel.close:()V
        //    39: ldc             1
        //    41: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    44: goto            53
        //    47: astore_1       
        //    48: ldc             501
        //    50: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    53: getstatic       instrumented/java/util/logging/FileHandler.locks:Linstrumented/java/util/Set;
        //    56: dup            
        //    57: astore_1       
        //    58: pop            
        //    59: ldc             4
        //    61: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    64: getstatic       instrumented/java/util/logging/FileHandler.locks:Linstrumented/java/util/Set;
        //    67: aload_0        
        //    68: getfield        instrumented/java/util/logging/FileHandler.lockFileName:Ljava/lang/String;
        //    71: ldc             4
        //    73: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    76: invokeinterface instrumented/java/util/Set.remove:(Ljava/lang/Object;)Z
        //    81: pop            
        //    82: ldc             1
        //    84: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    87: aload_1        
        //    88: pop            
        //    89: ldc             2
        //    91: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    94: ldc             1
        //    96: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    99: goto            118
        //   102: astore_2       
        //   103: aload_1        
        //   104: pop            
        //   105: ldc_w           503
        //   108: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   111: aload_2        
        //   112: ldc             2
        //   114: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   117: athrow         
        //   118: new             Ljava/io/File;
        //   121: dup            
        //   122: aload_0        
        //   123: getfield        instrumented/java/util/logging/FileHandler.lockFileName:Ljava/lang/String;
        //   126: ldc             5
        //   128: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   131: invokespecial   java/io/File.<init>:(Ljava/lang/String;)V
        //   134: ldc             1
        //   136: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   139: invokevirtual   java/io/File.delete:()Z
        //   142: pop            
        //   143: ldc             1
        //   145: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   148: aload_0        
        //   149: aconst_null    
        //   150: putfield        instrumented/java/util/logging/FileHandler.lockFileName:Ljava/lang/String;
        //   153: ldc             3
        //   155: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   158: aload_0        
        //   159: aconst_null    
        //   160: putfield        instrumented/java/util/logging/FileHandler.lockFileChannel:Ljava/nio/channels/FileChannel;
        //   163: ldc             3
        //   165: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   168: ldc             1
        //   170: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   173: return         
        //   174: athrow         
        //   175: athrow         
        //    Exceptions:
        //  throws java.lang.SecurityException
        //    StackMapTable: 00 07 1B 53 07 00 53 05 FF 00 30 00 02 07 00 02 07 00 5B 00 01 07 00 4D FA 00 0F FF 00 37 00 00 00 01 07 00 4D FF 00 00 00 00 00 01 07 00 51
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  27     175    175    176    Ljava/lang/VirtualMachineError;
        //  27     39     47     53     Ljava/lang/Exception;
        //  64     94     102    118    Any
        //  102    111    102    118    Any
        //  0      174    174    175    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0027:
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
    
    private static native boolean isSetUID();
    
    static /* synthetic */ void access$100(final FileHandler fileHandler) {
        try {
            BytecodeManager.incBytecodes(2);
            fileHandler.rotate();
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static {
        try {
            BytecodeManager.incBytecodes(3);
            locks = new HashSet<String>();
            BytecodeManager.incBytecodes(2);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private class MeteredStream extends OutputStream
    {
        final OutputStream out;
        int written;
        
        MeteredStream(final OutputStream out, final int written) {
            try {
                BytecodeManager.incBytecodes(5);
                this.out = out;
                BytecodeManager.incBytecodes(3);
                this.written = written;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void write(final int n) throws IOException {
            try {
                final OutputStream out = this.out;
                BytecodeManager.incBytecodes(4);
                out.write(n);
                ++this.written;
                BytecodeManager.incBytecodes(6);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void write(final byte[] b) throws IOException {
            try {
                final OutputStream out = this.out;
                BytecodeManager.incBytecodes(4);
                out.write(b);
                this.written += b.length;
                BytecodeManager.incBytecodes(7);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void write(final byte[] b, final int off, final int len) throws IOException {
            try {
                final OutputStream out = this.out;
                BytecodeManager.incBytecodes(6);
                out.write(b, off, len);
                this.written += len;
                BytecodeManager.incBytecodes(6);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void flush() throws IOException {
            try {
                final OutputStream out = this.out;
                BytecodeManager.incBytecodes(3);
                out.flush();
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void close() throws IOException {
            try {
                final OutputStream out = this.out;
                BytecodeManager.incBytecodes(3);
                out.close();
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private static class InitializationErrorManager extends ErrorManager
    {
        Exception lastException;
        
        private InitializationErrorManager() {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void error(final String s, final Exception lastException, final int n) {
            try {
                this.lastException = lastException;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
}
