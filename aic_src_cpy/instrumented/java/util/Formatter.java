// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import java.text.NumberFormat;
import java.text.DecimalFormat;
import java.text.DateFormatSymbols;
import instrumented.java.math.RoundingMode;
import instrumented.java.math.MathContext;
import sun.misc.FormattedFloatingDecimal;
import java.time.temporal.TemporalAccessor;
import instrumented.java.math.BigDecimal;
import instrumented.java.math.BigInteger;
import instrumented.java.util.regex.Matcher;
import java.text.DecimalFormatSymbols;
import java.io.PrintStream;
import java.io.FileNotFoundException;
import java.io.Writer;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import java.io.File;
import java.nio.charset.UnsupportedCharsetException;
import java.nio.charset.IllegalCharsetNameException;
import java.io.UnsupportedEncodingException;
import aic2021.engine.BytecodeManager;
import java.nio.charset.Charset;
import instrumented.java.util.regex.Pattern;
import java.io.IOException;
import java.io.Flushable;
import java.io.Closeable;

public final class Formatter implements Closeable, Flushable
{
    private Appendable a;
    private final Locale l;
    private IOException lastException;
    private final char zero;
    private static double scaleUp;
    private static final int MAX_FD_CHARS = 30;
    private static final String formatSpecifier = "%(\\d+\\$)?([-#+ 0,(\\<]*)?(\\d+)?(\\.\\d+)?([tT])?([a-zA-Z%])";
    private static Pattern fsPattern;
    
    private static Charset toCharset(final String s) throws UnsupportedEncodingException {
        try {
            final String s2 = "charsetName";
            BytecodeManager.incBytecodes(3);
            Objects.requireNonNull(s, s2);
            BytecodeManager.incBytecodes(1);
            try {
                final String s3 = s;
                final int n = 2;
                BytecodeManager.incBytecodes(n);
                final Charset charset = Charset.forName(s3);
                final int n2 = 1;
                BytecodeManager.incBytecodes(n2);
                return charset;
            }
            catch (IllegalCharsetNameException | UnsupportedCharsetException ex2) {
                BytecodeManager.incBytecodes(501);
                final String s4 = s;
                BytecodeManager.incBytecodes(4);
                final UnsupportedEncodingException ex = new UnsupportedEncodingException(s4);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
        }
        finally {}
        try {
            final String s3 = s;
            final int n = 2;
            BytecodeManager.incBytecodes(n);
            final Charset charset = Charset.forName(s3);
            final int n2 = 1;
            BytecodeManager.incBytecodes(n2);
            return charset;
        }
        catch (VirtualMachineError virtualMachineError) {
            throw virtualMachineError;
        }
    }
    
    private static final Appendable nonNullAppendable(final Appendable appendable) {
        try {
            BytecodeManager.incBytecodes(2);
            if (appendable == null) {
                BytecodeManager.incBytecodes(3);
                final StringBuilder sb = new StringBuilder();
                BytecodeManager.incBytecodes(1);
                return sb;
            }
            BytecodeManager.incBytecodes(2);
            return appendable;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private Formatter(final Locale l, final Appendable a) {
        try {
            BytecodeManager.incBytecodes(2);
            this.a = a;
            BytecodeManager.incBytecodes(3);
            this.l = l;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(3);
            this.zero = getZero(l);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private Formatter(final Charset cs, final Locale locale, final File file) throws FileNotFoundException {
        try {
            BytecodeManager.incBytecodes(10);
            final FileOutputStream out = new FileOutputStream(file);
            BytecodeManager.incBytecodes(2);
            final OutputStreamWriter out2 = new OutputStreamWriter(out, cs);
            BytecodeManager.incBytecodes(1);
            final BufferedWriter bufferedWriter = new BufferedWriter(out2);
            BytecodeManager.incBytecodes(1);
            this(locale, bufferedWriter);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Formatter() {
        try {
            final Locale.Category format = Locale.Category.FORMAT;
            BytecodeManager.incBytecodes(3);
            final Locale default1 = Locale.getDefault(format);
            BytecodeManager.incBytecodes(3);
            final StringBuilder sb = new StringBuilder();
            BytecodeManager.incBytecodes(1);
            this(default1, sb);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Formatter(final Appendable appendable) {
        try {
            final Locale.Category format = Locale.Category.FORMAT;
            BytecodeManager.incBytecodes(3);
            final Locale default1 = Locale.getDefault(format);
            BytecodeManager.incBytecodes(2);
            final Appendable nonNullAppendable = nonNullAppendable(appendable);
            BytecodeManager.incBytecodes(1);
            this(default1, nonNullAppendable);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Formatter(final Locale locale) {
        try {
            BytecodeManager.incBytecodes(5);
            final StringBuilder sb = new StringBuilder();
            BytecodeManager.incBytecodes(1);
            this(locale, sb);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Formatter(final Appendable appendable, final Locale locale) {
        try {
            BytecodeManager.incBytecodes(4);
            final Appendable nonNullAppendable = nonNullAppendable(appendable);
            BytecodeManager.incBytecodes(1);
            this(locale, nonNullAppendable);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Formatter(final String name) throws FileNotFoundException {
        try {
            final Locale.Category format = Locale.Category.FORMAT;
            BytecodeManager.incBytecodes(3);
            final Locale default1 = Locale.getDefault(format);
            BytecodeManager.incBytecodes(8);
            final FileOutputStream out = new FileOutputStream(name);
            BytecodeManager.incBytecodes(1);
            final OutputStreamWriter out2 = new OutputStreamWriter(out);
            BytecodeManager.incBytecodes(1);
            final BufferedWriter bufferedWriter = new BufferedWriter(out2);
            BytecodeManager.incBytecodes(1);
            this(default1, bufferedWriter);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Formatter(final String s, final String s2) throws FileNotFoundException, UnsupportedEncodingException {
        try {
            final Locale.Category format = Locale.Category.FORMAT;
            BytecodeManager.incBytecodes(5);
            final Locale default1 = Locale.getDefault(format);
            BytecodeManager.incBytecodes(1);
            this(s, s2, default1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Formatter(final String pathname, final String s, final Locale locale) throws FileNotFoundException, UnsupportedEncodingException {
        try {
            BytecodeManager.incBytecodes(3);
            final Charset charset = toCharset(s);
            BytecodeManager.incBytecodes(5);
            final File file = new File(pathname);
            BytecodeManager.incBytecodes(1);
            this(charset, locale, file);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Formatter(final File file) throws FileNotFoundException {
        try {
            final Locale.Category format = Locale.Category.FORMAT;
            BytecodeManager.incBytecodes(3);
            final Locale default1 = Locale.getDefault(format);
            BytecodeManager.incBytecodes(8);
            final FileOutputStream out = new FileOutputStream(file);
            BytecodeManager.incBytecodes(1);
            final OutputStreamWriter out2 = new OutputStreamWriter(out);
            BytecodeManager.incBytecodes(1);
            final BufferedWriter bufferedWriter = new BufferedWriter(out2);
            BytecodeManager.incBytecodes(1);
            this(default1, bufferedWriter);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Formatter(final File file, final String s) throws FileNotFoundException, UnsupportedEncodingException {
        try {
            final Locale.Category format = Locale.Category.FORMAT;
            BytecodeManager.incBytecodes(5);
            final Locale default1 = Locale.getDefault(format);
            BytecodeManager.incBytecodes(1);
            this(file, s, default1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Formatter(final File file, final String s, final Locale locale) throws FileNotFoundException, UnsupportedEncodingException {
        try {
            BytecodeManager.incBytecodes(3);
            final Charset charset = toCharset(s);
            BytecodeManager.incBytecodes(3);
            this(charset, locale, file);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Formatter(final PrintStream printStream) {
        try {
            final Locale.Category format = Locale.Category.FORMAT;
            BytecodeManager.incBytecodes(3);
            final Locale default1 = Locale.getDefault(format);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
            final PrintStream printStream2 = Objects.requireNonNull(printStream);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
            this(default1, printStream2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Formatter(final OutputStream out) {
        try {
            final Locale.Category format = Locale.Category.FORMAT;
            BytecodeManager.incBytecodes(3);
            final Locale default1 = Locale.getDefault(format);
            BytecodeManager.incBytecodes(6);
            final OutputStreamWriter out2 = new OutputStreamWriter(out);
            BytecodeManager.incBytecodes(1);
            final BufferedWriter bufferedWriter = new BufferedWriter(out2);
            BytecodeManager.incBytecodes(1);
            this(default1, bufferedWriter);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Formatter(final OutputStream outputStream, final String s) throws UnsupportedEncodingException {
        try {
            final Locale.Category format = Locale.Category.FORMAT;
            BytecodeManager.incBytecodes(5);
            final Locale default1 = Locale.getDefault(format);
            BytecodeManager.incBytecodes(1);
            this(outputStream, s, default1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Formatter(final OutputStream out, final String charsetName, final Locale locale) throws UnsupportedEncodingException {
        try {
            BytecodeManager.incBytecodes(9);
            final OutputStreamWriter out2 = new OutputStreamWriter(out, charsetName);
            BytecodeManager.incBytecodes(1);
            final BufferedWriter bufferedWriter = new BufferedWriter(out2);
            BytecodeManager.incBytecodes(1);
            this(locale, bufferedWriter);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static char getZero(final Locale locale) {
        try {
            BytecodeManager.incBytecodes(2);
            if (locale != null) {
                final Locale us = Locale.US;
                BytecodeManager.incBytecodes(3);
                final boolean equals = locale.equals(us);
                BytecodeManager.incBytecodes(1);
                if (!equals) {
                    BytecodeManager.incBytecodes(2);
                    final DecimalFormatSymbols instance = DecimalFormatSymbols.getInstance(locale);
                    BytecodeManager.incBytecodes(1);
                    final DecimalFormatSymbols decimalFormatSymbols = instance;
                    BytecodeManager.incBytecodes(2);
                    final char zeroDigit = decimalFormatSymbols.getZeroDigit();
                    BytecodeManager.incBytecodes(1);
                    return zeroDigit;
                }
            }
            final char c = '0';
            BytecodeManager.incBytecodes(2);
            return c;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Locale locale() {
        try {
            BytecodeManager.incBytecodes(2);
            this.ensureOpen();
            final Locale l = this.l;
            BytecodeManager.incBytecodes(3);
            return l;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Appendable out() {
        try {
            BytecodeManager.incBytecodes(2);
            this.ensureOpen();
            final Appendable a = this.a;
            BytecodeManager.incBytecodes(3);
            return a;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public String toString() {
        try {
            BytecodeManager.incBytecodes(2);
            this.ensureOpen();
            final Appendable a = this.a;
            BytecodeManager.incBytecodes(3);
            final String string = a.toString();
            BytecodeManager.incBytecodes(1);
            return string;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void flush() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             2
        //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     6: invokespecial   instrumented/java/util/Formatter.ensureOpen:()V
        //     9: aload_0        
        //    10: getfield        instrumented/java/util/Formatter.a:Ljava/lang/Appendable;
        //    13: instanceof      Ljava/io/Flushable;
        //    16: ldc             4
        //    18: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    21: ifeq            65
        //    24: aload_0        
        //    25: getfield        instrumented/java/util/Formatter.a:Ljava/lang/Appendable;
        //    28: checkcast       Ljava/io/Flushable;
        //    31: ldc             4
        //    33: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    36: invokeinterface java/io/Flushable.flush:()V
        //    41: ldc             1
        //    43: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    46: goto            65
        //    49: astore_1       
        //    50: ldc             501
        //    52: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    55: aload_0        
        //    56: aload_1        
        //    57: putfield        instrumented/java/util/Formatter.lastException:Ljava/io/IOException;
        //    60: ldc             3
        //    62: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    65: ldc             1
        //    67: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    70: return         
        //    71: athrow         
        //    72: athrow         
        //    StackMapTable: 00 04 71 07 00 D7 0F FF 00 05 00 00 00 01 07 00 60 FF 00 00 00 00 00 01 07 00 3C
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  24     72     72     73     Ljava/lang/VirtualMachineError;
        //  24     41     49     65     Ljava/io/IOException;
        //  0      71     71     72     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0065:
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
    public void close() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        instrumented/java/util/Formatter.a:Ljava/lang/Appendable;
        //     4: ldc             3
        //     6: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     9: ifnonnull       18
        //    12: ldc             1
        //    14: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    17: return         
        //    18: aload_0        
        //    19: getfield        instrumented/java/util/Formatter.a:Ljava/lang/Appendable;
        //    22: instanceof      Ljava/io/Closeable;
        //    25: ldc             4
        //    27: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    30: ifeq            50
        //    33: aload_0        
        //    34: getfield        instrumented/java/util/Formatter.a:Ljava/lang/Appendable;
        //    37: checkcast       Ljava/io/Closeable;
        //    40: ldc             4
        //    42: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    45: invokeinterface java/io/Closeable.close:()V
        //    50: aload_0        
        //    51: aconst_null    
        //    52: putfield        instrumented/java/util/Formatter.a:Ljava/lang/Appendable;
        //    55: ldc             3
        //    57: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    60: ldc             1
        //    62: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    65: goto            115
        //    68: astore_1       
        //    69: ldc             501
        //    71: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    74: aload_0        
        //    75: aload_1        
        //    76: putfield        instrumented/java/util/Formatter.lastException:Ljava/io/IOException;
        //    79: ldc             3
        //    81: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    84: aload_0        
        //    85: aconst_null    
        //    86: putfield        instrumented/java/util/Formatter.a:Ljava/lang/Appendable;
        //    89: ldc             3
        //    91: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    94: ldc             1
        //    96: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    99: goto            115
        //   102: astore_2       
        //   103: aload_0        
        //   104: aconst_null    
        //   105: putfield        instrumented/java/util/Formatter.a:Ljava/lang/Appendable;
        //   108: aload_2        
        //   109: ldc             506
        //   111: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   114: athrow         
        //   115: ldc             1
        //   117: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   120: return         
        //   121: athrow         
        //   122: athrow         
        //    StackMapTable: 00 07 12 1F 51 07 00 D7 61 07 00 60 0C FF 00 05 00 00 00 01 07 00 60 FF 00 00 00 00 00 01 07 00 3C
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  18     122    122    123    Ljava/lang/VirtualMachineError;
        //  18     50     68     102    Ljava/io/IOException;
        //  18     50     102    115    Any
        //  68     84     102    115    Any
        //  0      121    121    122    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0018:
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
    
    private void ensureOpen() {
        try {
            final Appendable a = this.a;
            BytecodeManager.incBytecodes(3);
            if (a == null) {
                BytecodeManager.incBytecodes(3);
                final FormatterClosedException ex = new FormatterClosedException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public IOException ioException() {
        try {
            final IOException lastException = this.lastException;
            BytecodeManager.incBytecodes(3);
            return lastException;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Formatter format(final String s, final Object... array) {
        try {
            final Locale l = this.l;
            BytecodeManager.incBytecodes(6);
            final Formatter format = this.format(l, s, array);
            BytecodeManager.incBytecodes(1);
            return format;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Formatter format(final Locale p0, final String p1, final Object... p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             2
        //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     6: invokespecial   instrumented/java/util/Formatter.ensureOpen:()V
        //     9: iconst_m1      
        //    10: istore          4
        //    12: ldc             2
        //    14: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    17: iconst_m1      
        //    18: istore          5
        //    20: ldc             2
        //    22: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    25: aload_0        
        //    26: aload_2        
        //    27: ldc             3
        //    29: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    32: invokespecial   instrumented/java/util/Formatter.parse:(Ljava/lang/String;)[Linstrumented/java/util/Formatter$FormatString;
        //    35: astore          6
        //    37: ldc             1
        //    39: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    42: iconst_0       
        //    43: istore          7
        //    45: ldc             2
        //    47: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    50: iload           7
        //    52: aload           6
        //    54: arraylength    
        //    55: ldc             4
        //    57: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    60: if_icmpge       520
        //    63: aload           6
        //    65: iload           7
        //    67: aaload         
        //    68: astore          8
        //    70: ldc             4
        //    72: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    75: aload           8
        //    77: ldc             2
        //    79: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    82: invokeinterface instrumented/java/util/Formatter$FormatString.index:()I
        //    87: istore          9
        //    89: ldc             1
        //    91: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    94: iload           9
        //    96: ldc             2
        //    98: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   101: tableswitch {
        //               -4: 128
        //               -3: 150
        //               -2: 261
        //          default: 379
        //        }
        //   128: aload           8
        //   130: aconst_null    
        //   131: aload_1        
        //   132: ldc             4
        //   134: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   137: invokeinterface instrumented/java/util/Formatter$FormatString.print:(Ljava/lang/Object;Linstrumented/java/util/Locale;)V
        //   142: ldc             1
        //   144: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   147: goto            483
        //   150: iload           4
        //   152: ldc             2
        //   154: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   157: iflt            183
        //   160: aload_3        
        //   161: ldc             2
        //   163: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   166: ifnull          213
        //   169: iload           4
        //   171: aload_3        
        //   172: arraylength    
        //   173: iconst_1       
        //   174: isub           
        //   175: ldc             6
        //   177: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   180: if_icmple       213
        //   183: new             Linstrumented/java/util/MissingFormatArgumentException;
        //   186: dup            
        //   187: aload           8
        //   189: ldc             4
        //   191: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   194: invokeinterface instrumented/java/util/Formatter$FormatString.toString:()Ljava/lang/String;
        //   199: ldc             1
        //   201: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   204: invokespecial   instrumented/java/util/MissingFormatArgumentException.<init>:(Ljava/lang/String;)V
        //   207: ldc             1
        //   209: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   212: athrow         
        //   213: aload           8
        //   215: aload_3        
        //   216: ldc             3
        //   218: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   221: ifnonnull       233
        //   224: aconst_null    
        //   225: ldc             2
        //   227: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   230: goto            242
        //   233: aload_3        
        //   234: iload           4
        //   236: aaload         
        //   237: ldc             3
        //   239: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   242: aload_1        
        //   243: ldc             2
        //   245: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   248: invokeinterface instrumented/java/util/Formatter$FormatString.print:(Ljava/lang/Object;Linstrumented/java/util/Locale;)V
        //   253: ldc             1
        //   255: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   258: goto            483
        //   261: iinc            5, 1
        //   264: ldc             1
        //   266: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   269: iload           5
        //   271: istore          4
        //   273: ldc             2
        //   275: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   278: aload_3        
        //   279: ldc             2
        //   281: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   284: ifnull          331
        //   287: iload           5
        //   289: aload_3        
        //   290: arraylength    
        //   291: iconst_1       
        //   292: isub           
        //   293: ldc             6
        //   295: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   298: if_icmple       331
        //   301: new             Linstrumented/java/util/MissingFormatArgumentException;
        //   304: dup            
        //   305: aload           8
        //   307: ldc             4
        //   309: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   312: invokeinterface instrumented/java/util/Formatter$FormatString.toString:()Ljava/lang/String;
        //   317: ldc             1
        //   319: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   322: invokespecial   instrumented/java/util/MissingFormatArgumentException.<init>:(Ljava/lang/String;)V
        //   325: ldc             1
        //   327: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   330: athrow         
        //   331: aload           8
        //   333: aload_3        
        //   334: ldc             3
        //   336: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   339: ifnonnull       351
        //   342: aconst_null    
        //   343: ldc             2
        //   345: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   348: goto            360
        //   351: aload_3        
        //   352: iload           5
        //   354: aaload         
        //   355: ldc             3
        //   357: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   360: aload_1        
        //   361: ldc             2
        //   363: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   366: invokeinterface instrumented/java/util/Formatter$FormatString.print:(Ljava/lang/Object;Linstrumented/java/util/Locale;)V
        //   371: ldc             1
        //   373: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   376: goto            483
        //   379: iload           9
        //   381: iconst_1       
        //   382: isub           
        //   383: istore          4
        //   385: ldc             4
        //   387: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   390: aload_3        
        //   391: ldc             2
        //   393: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   396: ifnull          443
        //   399: iload           4
        //   401: aload_3        
        //   402: arraylength    
        //   403: iconst_1       
        //   404: isub           
        //   405: ldc             6
        //   407: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   410: if_icmple       443
        //   413: new             Linstrumented/java/util/MissingFormatArgumentException;
        //   416: dup            
        //   417: aload           8
        //   419: ldc             4
        //   421: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   424: invokeinterface instrumented/java/util/Formatter$FormatString.toString:()Ljava/lang/String;
        //   429: ldc             1
        //   431: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   434: invokespecial   instrumented/java/util/MissingFormatArgumentException.<init>:(Ljava/lang/String;)V
        //   437: ldc             1
        //   439: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   442: athrow         
        //   443: aload           8
        //   445: aload_3        
        //   446: ldc             3
        //   448: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   451: ifnonnull       463
        //   454: aconst_null    
        //   455: ldc             2
        //   457: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   460: goto            472
        //   463: aload_3        
        //   464: iload           4
        //   466: aaload         
        //   467: ldc             3
        //   469: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   472: aload_1        
        //   473: ldc             2
        //   475: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   478: invokeinterface instrumented/java/util/Formatter$FormatString.print:(Ljava/lang/Object;Linstrumented/java/util/Locale;)V
        //   483: ldc             1
        //   485: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   488: goto            509
        //   491: astore          10
        //   493: ldc             501
        //   495: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   498: aload_0        
        //   499: aload           10
        //   501: putfield        instrumented/java/util/Formatter.lastException:Ljava/io/IOException;
        //   504: ldc             3
        //   506: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   509: iinc            7, 1
        //   512: ldc             2
        //   514: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   517: goto            50
        //   520: aload_0        
        //   521: ldc             2
        //   523: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   526: areturn        
        //   527: athrow         
        //   528: athrow         
        //    StackMapTable: 00 15 FF 00 32 00 08 07 00 02 07 00 22 07 00 EF 07 00 F1 01 01 07 00 F3 01 00 00 FD 00 4D 07 00 1D 01 15 20 1D 53 07 00 1D FF 00 08 00 0A 07 00 02 07 00 22 07 00 EF 07 00 F1 01 01 07 00 F3 01 07 00 1D 01 00 02 07 00 1D 07 00 04 12 FB 00 45 53 07 00 1D FF 00 08 00 0A 07 00 02 07 00 22 07 00 EF 07 00 F1 01 01 07 00 F3 01 07 00 1D 01 00 02 07 00 1D 07 00 04 12 3F 53 07 00 1D FF 00 08 00 0A 07 00 02 07 00 22 07 00 EF 07 00 F1 01 01 07 00 F3 01 07 00 1D 01 00 02 07 00 1D 07 00 04 0A 47 07 00 D7 F9 00 11 FA 00 0A FF 00 06 00 00 00 01 07 00 60 FF 00 00 00 00 00 01 07 00 3C
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  94     528    528    529    Ljava/lang/VirtualMachineError;
        //  94     483    491    509    Ljava/io/IOException;
        //  0      527    527    528    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0128:
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
    
    private FormatString[] parse(final String s) {
        try {
            BytecodeManager.incBytecodes(3);
            final ArrayList<FixedString> list = new ArrayList<FixedString>();
            BytecodeManager.incBytecodes(1);
            final Pattern fsPattern = Formatter.fsPattern;
            BytecodeManager.incBytecodes(3);
            final Matcher matcher = fsPattern.matcher(s);
            BytecodeManager.incBytecodes(1);
            int end = 0;
            BytecodeManager.incBytecodes(4);
            final int length = s.length();
            BytecodeManager.incBytecodes(1);
            while (true) {
                final int n = end;
                final int n2 = length;
                BytecodeManager.incBytecodes(3);
                if (n >= n2) {
                    break;
                }
                final Matcher matcher2 = matcher;
                final int n3 = end;
                BytecodeManager.incBytecodes(3);
                final boolean find = matcher2.find(n3);
                BytecodeManager.incBytecodes(1);
                if (!find) {
                    final int n4 = end;
                    final int n5 = length;
                    BytecodeManager.incBytecodes(4);
                    checkText(s, n4, n5);
                    final ArrayList<FixedString> list2 = list;
                    final int beginIndex = end;
                    BytecodeManager.incBytecodes(7);
                    final String substring = s.substring(beginIndex);
                    BytecodeManager.incBytecodes(1);
                    final FixedString fixedString = new FixedString(substring);
                    BytecodeManager.incBytecodes(1);
                    list2.add(fixedString);
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    break;
                }
                final Matcher matcher3 = matcher;
                BytecodeManager.incBytecodes(2);
                final int start = matcher3.start();
                final int n6 = end;
                BytecodeManager.incBytecodes(2);
                if (start != n6) {
                    final int n7 = end;
                    final Matcher matcher4 = matcher;
                    BytecodeManager.incBytecodes(4);
                    final int start2 = matcher4.start();
                    BytecodeManager.incBytecodes(1);
                    checkText(s, n7, start2);
                    final ArrayList<FixedString> list3 = list;
                    final int beginIndex2 = end;
                    final Matcher matcher5 = matcher;
                    BytecodeManager.incBytecodes(8);
                    final int start3 = matcher5.start();
                    BytecodeManager.incBytecodes(1);
                    final String substring2 = s.substring(beginIndex2, start3);
                    BytecodeManager.incBytecodes(1);
                    final FixedString fixedString2 = new FixedString(substring2);
                    BytecodeManager.incBytecodes(1);
                    list3.add(fixedString2);
                    BytecodeManager.incBytecodes(1);
                }
                final ArrayList<FixedString> list4 = list;
                final Matcher matcher6 = matcher;
                BytecodeManager.incBytecodes(6);
                final FormatSpecifier formatSpecifier = new FormatSpecifier(matcher6);
                BytecodeManager.incBytecodes(1);
                list4.add((FixedString)formatSpecifier);
                BytecodeManager.incBytecodes(1);
                final Matcher matcher7 = matcher;
                BytecodeManager.incBytecodes(2);
                end = matcher7.end();
                BytecodeManager.incBytecodes(2);
            }
            final ArrayList<FixedString> list5 = list;
            final ArrayList<FixedString> list6 = list;
            BytecodeManager.incBytecodes(3);
            final FormatString[] array = new FormatString[list6.size()];
            BytecodeManager.incBytecodes(1);
            final FormatString[] array2 = list5.toArray(array);
            BytecodeManager.incBytecodes(2);
            return array2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static void checkText(final String s, final int n, final int n2) {
        try {
            int n3 = n;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n4 = n3;
                BytecodeManager.incBytecodes(3);
                if (n4 >= n2) {
                    BytecodeManager.incBytecodes(1);
                    return;
                }
                final int index = n3;
                BytecodeManager.incBytecodes(3);
                final char char1 = s.charAt(index);
                final int n5 = '%';
                BytecodeManager.incBytecodes(2);
                if (char1 == n5) {
                    final int n6 = n3;
                    final int n7 = n2 - 1;
                    BytecodeManager.incBytecodes(5);
                    char char2;
                    if (n6 == n7) {
                        char2 = '%';
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        final int index2 = n3 + 1;
                        BytecodeManager.incBytecodes(5);
                        char2 = s.charAt(index2);
                    }
                    final char c = char2;
                    BytecodeManager.incBytecodes(1);
                    final char c2 = c;
                    BytecodeManager.incBytecodes(4);
                    final String value = String.valueOf(c2);
                    BytecodeManager.incBytecodes(1);
                    final UnknownFormatConversionException ex = new UnknownFormatConversionException(value);
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                ++n3;
                BytecodeManager.incBytecodes(2);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static /* synthetic */ Appendable access$000(final Formatter formatter) {
        try {
            final Appendable a = formatter.a;
            BytecodeManager.incBytecodes(3);
            return a;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static /* synthetic */ double access$202(final double scaleUp) {
        try {
            Formatter.scaleUp = scaleUp;
            BytecodeManager.incBytecodes(4);
            return scaleUp;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static /* synthetic */ double access$200() {
        try {
            final double scaleUp = Formatter.scaleUp;
            BytecodeManager.incBytecodes(2);
            return scaleUp;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static /* synthetic */ char access$300(final Formatter formatter) {
        try {
            final char zero = formatter.zero;
            BytecodeManager.incBytecodes(3);
            return zero;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static {
        try {
            final String s = "%(\\d+\\$)?([-#+ 0,(\\<]*)?(\\d+)?(\\.\\d+)?([tT])?([a-zA-Z%])";
            BytecodeManager.incBytecodes(2);
            Formatter.fsPattern = Pattern.compile(s);
            BytecodeManager.incBytecodes(2);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private class FixedString implements FormatString
    {
        private String s;
        
        FixedString(final String s) {
            try {
                BytecodeManager.incBytecodes(5);
                this.s = s;
                BytecodeManager.incBytecodes(4);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int index() {
            try {
                final int n = -2;
                BytecodeManager.incBytecodes(2);
                return n;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void print(final Object o, final Locale locale) throws IOException {
            try {
                final Formatter this$0 = Formatter.this;
                BytecodeManager.incBytecodes(3);
                final Appendable access$000 = Formatter.access$000(this$0);
                final String s = this.s;
                BytecodeManager.incBytecodes(3);
                access$000.append(s);
                BytecodeManager.incBytecodes(2);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public String toString() {
            try {
                final String s = this.s;
                BytecodeManager.incBytecodes(3);
                return s;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    public enum BigDecimalLayoutForm
    {
        SCIENTIFIC, 
        DECIMAL_FLOAT;
        
        private BigDecimalLayoutForm() {
            try {
                BytecodeManager.incBytecodes(4);
                super(name, ordinal);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static {
            try {
                final String s = "SCIENTIFIC";
                final int n = 0;
                BytecodeManager.incBytecodes(5);
                BytecodeManager.incBytecodes(1);
                final String s2 = "DECIMAL_FLOAT";
                final int n2 = 1;
                BytecodeManager.incBytecodes(5);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(11);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private class FormatSpecifier implements FormatString
    {
        private int index;
        private Flags f;
        private int width;
        private int precision;
        private boolean dt;
        private char c;
        static final /* synthetic */ boolean $assertionsDisabled;
        
        private int index(final String p0) {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: ldc             2
            //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //     6: ifnull          98
            //     9: aload_0        
            //    10: aload_1        
            //    11: iconst_0       
            //    12: aload_1        
            //    13: ldc             5
            //    15: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    18: invokevirtual   java/lang/String.length:()I
            //    21: iconst_1       
            //    22: isub           
            //    23: ldc             3
            //    25: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    28: invokevirtual   java/lang/String.substring:(II)Ljava/lang/String;
            //    31: ldc             1
            //    33: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    36: invokestatic    java/lang/Integer.parseInt:(Ljava/lang/String;)I
            //    39: putfield        instrumented/java/util/Formatter$FormatSpecifier.index:I
            //    42: ldc             1
            //    44: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    47: ldc             1
            //    49: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    52: goto            108
            //    55: astore_2       
            //    56: ldc             501
            //    58: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    61: getstatic       instrumented/java/util/Formatter$FormatSpecifier.$assertionsDisabled:Z
            //    64: ldc             2
            //    66: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    69: ifne            90
            //    72: new             Ljava/lang/AssertionError;
            //    75: dup            
            //    76: ldc             3
            //    78: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    81: invokespecial   java/lang/AssertionError.<init>:()V
            //    84: ldc             1
            //    86: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    89: athrow         
            //    90: ldc             1
            //    92: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    95: goto            108
            //    98: aload_0        
            //    99: iconst_0       
            //   100: putfield        instrumented/java/util/Formatter$FormatSpecifier.index:I
            //   103: ldc             3
            //   105: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   108: aload_0        
            //   109: getfield        instrumented/java/util/Formatter$FormatSpecifier.index:I
            //   112: ldc             3
            //   114: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   117: ireturn        
            //   118: athrow         
            //   119: athrow         
            //    StackMapTable: 00 06 77 07 00 31 22 07 09 FF 00 09 00 00 00 01 07 00 57 FF 00 00 00 00 00 01 07 00 2F
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                             
            //  -----  -----  -----  -----  ---------------------------------
            //  9      119    119    120    Ljava/lang/VirtualMachineError;
            //  9      47     55     98     Ljava/lang/NumberFormatException;
            //  0      118    118    119    Any
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
        public int index() {
            try {
                final int index = this.index;
                BytecodeManager.incBytecodes(3);
                return index;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private Flags flags(final String s) {
            try {
                BytecodeManager.incBytecodes(3);
                this.f = Flags.parse(s);
                BytecodeManager.incBytecodes(1);
                final Flags f = this.f;
                final Flags previous = Flags.PREVIOUS;
                BytecodeManager.incBytecodes(4);
                final boolean contains = f.contains(previous);
                BytecodeManager.incBytecodes(1);
                if (contains) {
                    this.index = -1;
                    BytecodeManager.incBytecodes(3);
                }
                final Flags f2 = this.f;
                BytecodeManager.incBytecodes(3);
                return f2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        Flags flags() {
            try {
                final Flags f = this.f;
                BytecodeManager.incBytecodes(3);
                return f;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private int width(final String p0) {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: iconst_m1      
            //     2: putfield        instrumented/java/util/Formatter$FormatSpecifier.width:I
            //     5: ldc             3
            //     7: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    10: aload_1        
            //    11: ldc             2
            //    13: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    16: ifnull          114
            //    19: aload_0        
            //    20: aload_1        
            //    21: ldc             3
            //    23: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    26: invokestatic    java/lang/Integer.parseInt:(Ljava/lang/String;)I
            //    29: putfield        instrumented/java/util/Formatter$FormatSpecifier.width:I
            //    32: ldc             1
            //    34: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    37: aload_0        
            //    38: getfield        instrumented/java/util/Formatter$FormatSpecifier.width:I
            //    41: ldc             3
            //    43: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    46: ifge            71
            //    49: new             Linstrumented/java/util/IllegalFormatWidthException;
            //    52: dup            
            //    53: aload_0        
            //    54: getfield        instrumented/java/util/Formatter$FormatSpecifier.width:I
            //    57: ldc             5
            //    59: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    62: invokespecial   instrumented/java/util/IllegalFormatWidthException.<init>:(I)V
            //    65: ldc             1
            //    67: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    70: athrow         
            //    71: ldc             1
            //    73: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    76: goto            114
            //    79: astore_2       
            //    80: ldc             501
            //    82: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    85: getstatic       instrumented/java/util/Formatter$FormatSpecifier.$assertionsDisabled:Z
            //    88: ldc             2
            //    90: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    93: ifne            114
            //    96: new             Ljava/lang/AssertionError;
            //    99: dup            
            //   100: ldc             3
            //   102: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   105: invokespecial   java/lang/AssertionError.<init>:()V
            //   108: ldc             1
            //   110: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   113: athrow         
            //   114: aload_0        
            //   115: getfield        instrumented/java/util/Formatter$FormatSpecifier.width:I
            //   118: ldc             3
            //   120: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   123: ireturn        
            //   124: athrow         
            //   125: athrow         
            //    StackMapTable: 00 05 FB 00 47 47 07 00 31 22 FF 00 09 00 00 00 01 07 00 57 FF 00 00 00 00 00 01 07 00 2F
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                             
            //  -----  -----  -----  -----  ---------------------------------
            //  19     125    125    126    Ljava/lang/VirtualMachineError;
            //  19     71     79     114    Ljava/lang/NumberFormatException;
            //  0      124    124    125    Any
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0071:
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
        
        int width() {
            try {
                final int width = this.width;
                BytecodeManager.incBytecodes(3);
                return width;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private int precision(final String p0) {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: iconst_m1      
            //     2: putfield        instrumented/java/util/Formatter$FormatSpecifier.precision:I
            //     5: ldc             3
            //     7: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    10: aload_1        
            //    11: ldc             2
            //    13: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    16: ifnull          123
            //    19: aload_0        
            //    20: aload_1        
            //    21: iconst_1       
            //    22: ldc             4
            //    24: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    27: invokevirtual   java/lang/String.substring:(I)Ljava/lang/String;
            //    30: ldc             1
            //    32: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    35: invokestatic    java/lang/Integer.parseInt:(Ljava/lang/String;)I
            //    38: putfield        instrumented/java/util/Formatter$FormatSpecifier.precision:I
            //    41: ldc             1
            //    43: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    46: aload_0        
            //    47: getfield        instrumented/java/util/Formatter$FormatSpecifier.precision:I
            //    50: ldc             3
            //    52: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    55: ifge            80
            //    58: new             Linstrumented/java/util/IllegalFormatPrecisionException;
            //    61: dup            
            //    62: aload_0        
            //    63: getfield        instrumented/java/util/Formatter$FormatSpecifier.precision:I
            //    66: ldc             5
            //    68: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    71: invokespecial   instrumented/java/util/IllegalFormatPrecisionException.<init>:(I)V
            //    74: ldc             1
            //    76: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    79: athrow         
            //    80: ldc             1
            //    82: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    85: goto            123
            //    88: astore_2       
            //    89: ldc             501
            //    91: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    94: getstatic       instrumented/java/util/Formatter$FormatSpecifier.$assertionsDisabled:Z
            //    97: ldc             2
            //    99: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   102: ifne            123
            //   105: new             Ljava/lang/AssertionError;
            //   108: dup            
            //   109: ldc             3
            //   111: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   114: invokespecial   java/lang/AssertionError.<init>:()V
            //   117: ldc             1
            //   119: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   122: athrow         
            //   123: aload_0        
            //   124: getfield        instrumented/java/util/Formatter$FormatSpecifier.precision:I
            //   127: ldc             3
            //   129: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   132: ireturn        
            //   133: athrow         
            //   134: athrow         
            //    StackMapTable: 00 05 FB 00 50 47 07 00 31 22 FF 00 09 00 00 00 01 07 00 57 FF 00 00 00 00 00 01 07 00 2F
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                             
            //  -----  -----  -----  -----  ---------------------------------
            //  19     134    134    135    Ljava/lang/VirtualMachineError;
            //  19     80     88     123    Ljava/lang/NumberFormatException;
            //  0      133    133    134    Any
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0080:
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
        
        int precision() {
            try {
                final int precision = this.precision;
                BytecodeManager.incBytecodes(3);
                return precision;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private char conversion(final String s) {
            try {
                final int index = 0;
                BytecodeManager.incBytecodes(4);
                this.c = s.charAt(index);
                BytecodeManager.incBytecodes(1);
                final boolean dt = this.dt;
                BytecodeManager.incBytecodes(3);
                if (!dt) {
                    final char c = this.c;
                    BytecodeManager.incBytecodes(3);
                    final boolean valid = Conversion.isValid(c);
                    BytecodeManager.incBytecodes(1);
                    if (!valid) {
                        final char c2 = this.c;
                        BytecodeManager.incBytecodes(5);
                        final String value = String.valueOf(c2);
                        BytecodeManager.incBytecodes(1);
                        final UnknownFormatConversionException ex = new UnknownFormatConversionException(value);
                        BytecodeManager.incBytecodes(1);
                        throw ex;
                    }
                    final char c3 = this.c;
                    BytecodeManager.incBytecodes(3);
                    final boolean upperCase = Character.isUpperCase(c3);
                    BytecodeManager.incBytecodes(1);
                    if (upperCase) {
                        final Flags f = this.f;
                        final Flags uppercase = Flags.UPPERCASE;
                        BytecodeManager.incBytecodes(4);
                        Flags.access$100(f, uppercase);
                        BytecodeManager.incBytecodes(1);
                    }
                    final char c4 = this.c;
                    BytecodeManager.incBytecodes(4);
                    this.c = Character.toLowerCase(c4);
                    BytecodeManager.incBytecodes(1);
                    final char c5 = this.c;
                    BytecodeManager.incBytecodes(3);
                    final boolean text = Conversion.isText(c5);
                    BytecodeManager.incBytecodes(1);
                    if (text) {
                        this.index = -2;
                        BytecodeManager.incBytecodes(3);
                    }
                }
                final char c6 = this.c;
                BytecodeManager.incBytecodes(3);
                return c6;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private char conversion() {
            try {
                final char c = this.c;
                BytecodeManager.incBytecodes(3);
                return c;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        FormatSpecifier(final Matcher matcher) {
            try {
                BytecodeManager.incBytecodes(5);
                this.index = -1;
                BytecodeManager.incBytecodes(3);
                this.f = Flags.NONE;
                BytecodeManager.incBytecodes(3);
                this.dt = false;
                BytecodeManager.incBytecodes(3);
                int n = 1;
                BytecodeManager.incBytecodes(2);
                final int n2 = n++;
                BytecodeManager.incBytecodes(5);
                final String group = matcher.group(n2);
                BytecodeManager.incBytecodes(1);
                this.index(group);
                BytecodeManager.incBytecodes(1);
                final int n3 = n++;
                BytecodeManager.incBytecodes(5);
                final String group2 = matcher.group(n3);
                BytecodeManager.incBytecodes(1);
                this.flags(group2);
                BytecodeManager.incBytecodes(1);
                final int n4 = n++;
                BytecodeManager.incBytecodes(5);
                final String group3 = matcher.group(n4);
                BytecodeManager.incBytecodes(1);
                this.width(group3);
                BytecodeManager.incBytecodes(1);
                final int n5 = n++;
                BytecodeManager.incBytecodes(5);
                final String group4 = matcher.group(n5);
                BytecodeManager.incBytecodes(1);
                this.precision(group4);
                BytecodeManager.incBytecodes(1);
                final int n6 = n++;
                BytecodeManager.incBytecodes(4);
                final String group5 = matcher.group(n6);
                BytecodeManager.incBytecodes(1);
                final String s = group5;
                BytecodeManager.incBytecodes(2);
                if (s != null) {
                    this.dt = true;
                    BytecodeManager.incBytecodes(3);
                    final String s2 = group5;
                    final String anObject = "T";
                    BytecodeManager.incBytecodes(3);
                    final boolean equals = s2.equals(anObject);
                    BytecodeManager.incBytecodes(1);
                    if (equals) {
                        final Flags f = this.f;
                        final Flags uppercase = Flags.UPPERCASE;
                        BytecodeManager.incBytecodes(4);
                        Flags.access$100(f, uppercase);
                        BytecodeManager.incBytecodes(1);
                    }
                }
                final int n7 = n;
                BytecodeManager.incBytecodes(4);
                final String group6 = matcher.group(n7);
                BytecodeManager.incBytecodes(1);
                this.conversion(group6);
                BytecodeManager.incBytecodes(1);
                final boolean dt = this.dt;
                BytecodeManager.incBytecodes(3);
                if (dt) {
                    BytecodeManager.incBytecodes(2);
                    this.checkDateTime();
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    final char c = this.c;
                    BytecodeManager.incBytecodes(3);
                    final boolean general = Conversion.isGeneral(c);
                    BytecodeManager.incBytecodes(1);
                    if (general) {
                        BytecodeManager.incBytecodes(2);
                        this.checkGeneral();
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        final char c2 = this.c;
                        BytecodeManager.incBytecodes(3);
                        final boolean character = Conversion.isCharacter(c2);
                        BytecodeManager.incBytecodes(1);
                        if (character) {
                            BytecodeManager.incBytecodes(2);
                            this.checkCharacter();
                            BytecodeManager.incBytecodes(1);
                        }
                        else {
                            final char c3 = this.c;
                            BytecodeManager.incBytecodes(3);
                            final boolean integer = Conversion.isInteger(c3);
                            BytecodeManager.incBytecodes(1);
                            if (integer) {
                                BytecodeManager.incBytecodes(2);
                                this.checkInteger();
                                BytecodeManager.incBytecodes(1);
                            }
                            else {
                                final char c4 = this.c;
                                BytecodeManager.incBytecodes(3);
                                final boolean float1 = Conversion.isFloat(c4);
                                BytecodeManager.incBytecodes(1);
                                if (float1) {
                                    BytecodeManager.incBytecodes(2);
                                    this.checkFloat();
                                    BytecodeManager.incBytecodes(1);
                                }
                                else {
                                    final char c5 = this.c;
                                    BytecodeManager.incBytecodes(3);
                                    final boolean text = Conversion.isText(c5);
                                    BytecodeManager.incBytecodes(1);
                                    if (!text) {
                                        final char c6 = this.c;
                                        BytecodeManager.incBytecodes(5);
                                        final String value = String.valueOf(c6);
                                        BytecodeManager.incBytecodes(1);
                                        final UnknownFormatConversionException ex = new UnknownFormatConversionException(value);
                                        BytecodeManager.incBytecodes(1);
                                        throw ex;
                                    }
                                    BytecodeManager.incBytecodes(2);
                                    this.checkText();
                                    BytecodeManager.incBytecodes(1);
                                }
                            }
                        }
                    }
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void print(final Object o, final Locale locale) throws IOException {
            try {
                final boolean dt = this.dt;
                BytecodeManager.incBytecodes(3);
                if (dt) {
                    BytecodeManager.incBytecodes(4);
                    this.printDateTime(o, locale);
                    BytecodeManager.incBytecodes(1);
                    return;
                }
                final char c = this.c;
                BytecodeManager.incBytecodes(3);
                switch (c) {
                    case 100:
                    case 111:
                    case 120: {
                        BytecodeManager.incBytecodes(4);
                        this.printInteger(o, locale);
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    case 97:
                    case 101:
                    case 102:
                    case 103: {
                        BytecodeManager.incBytecodes(4);
                        this.printFloat(o, locale);
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    case 67:
                    case 99: {
                        BytecodeManager.incBytecodes(3);
                        this.printCharacter(o);
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    case 98: {
                        BytecodeManager.incBytecodes(3);
                        this.printBoolean(o);
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    case 115: {
                        BytecodeManager.incBytecodes(4);
                        this.printString(o, locale);
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    case 104: {
                        BytecodeManager.incBytecodes(3);
                        this.printHashCode(o);
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    case 110: {
                        final Formatter this$0 = Formatter.this;
                        BytecodeManager.incBytecodes(3);
                        final Appendable access$000 = Formatter.access$000(this$0);
                        BytecodeManager.incBytecodes(1);
                        final String lineSeparator = System.lineSeparator();
                        BytecodeManager.incBytecodes(1);
                        access$000.append(lineSeparator);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    case 37: {
                        final Formatter this$2 = Formatter.this;
                        BytecodeManager.incBytecodes(3);
                        final Appendable access$2 = Formatter.access$000(this$2);
                        final char c2 = '%';
                        BytecodeManager.incBytecodes(2);
                        access$2.append(c2);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    default: {
                        final boolean $assertionsDisabled = FormatSpecifier.$assertionsDisabled;
                        BytecodeManager.incBytecodes(2);
                        if (!$assertionsDisabled) {
                            BytecodeManager.incBytecodes(3);
                            final AssertionError assertionError = new AssertionError();
                            BytecodeManager.incBytecodes(1);
                            throw assertionError;
                        }
                        break;
                    }
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private void printInteger(final Object o, final Locale locale) throws IOException {
            try {
                BytecodeManager.incBytecodes(2);
                if (o == null) {
                    final String s = "null";
                    BytecodeManager.incBytecodes(3);
                    this.print(s);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    final boolean b = o instanceof Byte;
                    BytecodeManager.incBytecodes(3);
                    if (b) {
                        final Byte b2 = (Byte)o;
                        BytecodeManager.incBytecodes(4);
                        final byte byteValue = b2;
                        BytecodeManager.incBytecodes(2);
                        this.print(byteValue, locale);
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        final boolean b3 = o instanceof Short;
                        BytecodeManager.incBytecodes(3);
                        if (b3) {
                            final Short n = (Short)o;
                            BytecodeManager.incBytecodes(4);
                            final short shortValue = n;
                            BytecodeManager.incBytecodes(2);
                            this.print(shortValue, locale);
                            BytecodeManager.incBytecodes(1);
                        }
                        else {
                            final boolean b4 = o instanceof Integer;
                            BytecodeManager.incBytecodes(3);
                            if (b4) {
                                final Integer n2 = (Integer)o;
                                BytecodeManager.incBytecodes(4);
                                final int intValue = n2;
                                BytecodeManager.incBytecodes(2);
                                this.print(intValue, locale);
                                BytecodeManager.incBytecodes(1);
                            }
                            else {
                                final boolean b5 = o instanceof Long;
                                BytecodeManager.incBytecodes(3);
                                if (b5) {
                                    final Long n3 = (Long)o;
                                    BytecodeManager.incBytecodes(4);
                                    final long longValue = n3;
                                    BytecodeManager.incBytecodes(2);
                                    this.print(longValue, locale);
                                    BytecodeManager.incBytecodes(1);
                                }
                                else {
                                    final boolean b6 = o instanceof BigInteger;
                                    BytecodeManager.incBytecodes(3);
                                    if (b6) {
                                        final BigInteger bigInteger = (BigInteger)o;
                                        BytecodeManager.incBytecodes(5);
                                        this.print(bigInteger, locale);
                                        BytecodeManager.incBytecodes(1);
                                    }
                                    else {
                                        final char c = this.c;
                                        BytecodeManager.incBytecodes(5);
                                        this.failConversion(c, o);
                                    }
                                }
                            }
                        }
                    }
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private void printFloat(final Object o, final Locale locale) throws IOException {
            try {
                BytecodeManager.incBytecodes(2);
                if (o == null) {
                    final String s = "null";
                    BytecodeManager.incBytecodes(3);
                    this.print(s);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    final boolean b = o instanceof Float;
                    BytecodeManager.incBytecodes(3);
                    if (b) {
                        final Float n = (Float)o;
                        BytecodeManager.incBytecodes(4);
                        final float floatValue = n;
                        BytecodeManager.incBytecodes(2);
                        this.print(floatValue, locale);
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        final boolean b2 = o instanceof Double;
                        BytecodeManager.incBytecodes(3);
                        if (b2) {
                            final Double n2 = (Double)o;
                            BytecodeManager.incBytecodes(4);
                            final double doubleValue = n2;
                            BytecodeManager.incBytecodes(2);
                            this.print(doubleValue, locale);
                            BytecodeManager.incBytecodes(1);
                        }
                        else {
                            final boolean b3 = o instanceof BigDecimal;
                            BytecodeManager.incBytecodes(3);
                            if (b3) {
                                final BigDecimal bigDecimal = (BigDecimal)o;
                                BytecodeManager.incBytecodes(5);
                                this.print(bigDecimal, locale);
                                BytecodeManager.incBytecodes(1);
                            }
                            else {
                                final char c = this.c;
                                BytecodeManager.incBytecodes(5);
                                this.failConversion(c, o);
                            }
                        }
                    }
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private void printDateTime(final Object o, final Locale locale) throws IOException {
            try {
                BytecodeManager.incBytecodes(2);
                if (o == null) {
                    final String s = "null";
                    BytecodeManager.incBytecodes(3);
                    this.print(s);
                    BytecodeManager.incBytecodes(1);
                    return;
                }
                Calendar calendar = null;
                BytecodeManager.incBytecodes(2);
                final boolean b = o instanceof Long;
                BytecodeManager.incBytecodes(3);
                if (b) {
                    BytecodeManager.incBytecodes(2);
                    Locale us;
                    if (locale == null) {
                        us = Locale.US;
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        us = locale;
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(1);
                    calendar = Calendar.getInstance(us);
                    BytecodeManager.incBytecodes(1);
                    final Calendar calendar2 = calendar;
                    final Long n = (Long)o;
                    BytecodeManager.incBytecodes(4);
                    final long longValue = n;
                    BytecodeManager.incBytecodes(1);
                    calendar2.setTimeInMillis(longValue);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    final boolean b2 = o instanceof Date;
                    BytecodeManager.incBytecodes(3);
                    if (b2) {
                        BytecodeManager.incBytecodes(2);
                        Locale us2;
                        if (locale == null) {
                            us2 = Locale.US;
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            us2 = locale;
                            BytecodeManager.incBytecodes(1);
                        }
                        BytecodeManager.incBytecodes(1);
                        calendar = Calendar.getInstance(us2);
                        BytecodeManager.incBytecodes(1);
                        final Calendar calendar3 = calendar;
                        final Date time = (Date)o;
                        BytecodeManager.incBytecodes(4);
                        calendar3.setTime(time);
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        final boolean b3 = o instanceof Calendar;
                        BytecodeManager.incBytecodes(3);
                        if (b3) {
                            final Calendar calendar4 = (Calendar)o;
                            BytecodeManager.incBytecodes(3);
                            calendar = (Calendar)calendar4.clone();
                            BytecodeManager.incBytecodes(2);
                            final Calendar calendar5 = calendar;
                            final boolean lenient = true;
                            BytecodeManager.incBytecodes(3);
                            calendar5.setLenient(lenient);
                            BytecodeManager.incBytecodes(1);
                        }
                        else {
                            final boolean b4 = o instanceof TemporalAccessor;
                            BytecodeManager.incBytecodes(3);
                            if (b4) {
                                final TemporalAccessor temporalAccessor = (TemporalAccessor)o;
                                final char c = this.c;
                                BytecodeManager.incBytecodes(7);
                                this.print(temporalAccessor, c, locale);
                                BytecodeManager.incBytecodes(1);
                                return;
                            }
                            final char c2 = this.c;
                            BytecodeManager.incBytecodes(5);
                            this.failConversion(c2, o);
                        }
                    }
                }
                final Calendar calendar6 = calendar;
                final char c3 = this.c;
                BytecodeManager.incBytecodes(6);
                this.print(calendar6, c3, locale);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private void printCharacter(final Object o) throws IOException {
            try {
                BytecodeManager.incBytecodes(2);
                if (o == null) {
                    final String s = "null";
                    BytecodeManager.incBytecodes(3);
                    this.print(s);
                    BytecodeManager.incBytecodes(1);
                    return;
                }
                String string = null;
                BytecodeManager.incBytecodes(2);
                final boolean b = o instanceof Character;
                BytecodeManager.incBytecodes(3);
                if (b) {
                    final Character c = (Character)o;
                    BytecodeManager.incBytecodes(3);
                    string = c.toString();
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final boolean b2 = o instanceof Byte;
                    BytecodeManager.incBytecodes(3);
                    if (b2) {
                        final Byte b3 = (Byte)o;
                        BytecodeManager.incBytecodes(3);
                        final byte byteValue = b3;
                        BytecodeManager.incBytecodes(1);
                        final byte codePoint = byteValue;
                        BytecodeManager.incBytecodes(2);
                        final boolean validCodePoint = Character.isValidCodePoint(codePoint);
                        BytecodeManager.incBytecodes(1);
                        if (!validCodePoint) {
                            final byte b4 = byteValue;
                            BytecodeManager.incBytecodes(4);
                            final IllegalFormatCodePointException ex = new IllegalFormatCodePointException(b4);
                            BytecodeManager.incBytecodes(1);
                            throw ex;
                        }
                        final byte codePoint2 = byteValue;
                        BytecodeManager.incBytecodes(4);
                        final char[] chars = Character.toChars(codePoint2);
                        BytecodeManager.incBytecodes(1);
                        string = new String(chars);
                        BytecodeManager.incBytecodes(2);
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        final boolean b5 = o instanceof Short;
                        BytecodeManager.incBytecodes(3);
                        if (b5) {
                            final Short n = (Short)o;
                            BytecodeManager.incBytecodes(3);
                            final short shortValue = n;
                            BytecodeManager.incBytecodes(1);
                            final short codePoint3 = shortValue;
                            BytecodeManager.incBytecodes(2);
                            final boolean validCodePoint2 = Character.isValidCodePoint(codePoint3);
                            BytecodeManager.incBytecodes(1);
                            if (!validCodePoint2) {
                                final short n2 = shortValue;
                                BytecodeManager.incBytecodes(4);
                                final IllegalFormatCodePointException ex2 = new IllegalFormatCodePointException(n2);
                                BytecodeManager.incBytecodes(1);
                                throw ex2;
                            }
                            final short codePoint4 = shortValue;
                            BytecodeManager.incBytecodes(4);
                            final char[] chars2 = Character.toChars(codePoint4);
                            BytecodeManager.incBytecodes(1);
                            string = new String(chars2);
                            BytecodeManager.incBytecodes(2);
                            BytecodeManager.incBytecodes(1);
                        }
                        else {
                            final boolean b6 = o instanceof Integer;
                            BytecodeManager.incBytecodes(3);
                            if (b6) {
                                final Integer n3 = (Integer)o;
                                BytecodeManager.incBytecodes(3);
                                final int intValue = n3;
                                BytecodeManager.incBytecodes(1);
                                final int codePoint5 = intValue;
                                BytecodeManager.incBytecodes(2);
                                final boolean validCodePoint3 = Character.isValidCodePoint(codePoint5);
                                BytecodeManager.incBytecodes(1);
                                if (!validCodePoint3) {
                                    final int n4 = intValue;
                                    BytecodeManager.incBytecodes(4);
                                    final IllegalFormatCodePointException ex3 = new IllegalFormatCodePointException(n4);
                                    BytecodeManager.incBytecodes(1);
                                    throw ex3;
                                }
                                final int codePoint6 = intValue;
                                BytecodeManager.incBytecodes(4);
                                final char[] chars3 = Character.toChars(codePoint6);
                                BytecodeManager.incBytecodes(1);
                                string = new String(chars3);
                                BytecodeManager.incBytecodes(2);
                                BytecodeManager.incBytecodes(1);
                            }
                            else {
                                final char c2 = this.c;
                                BytecodeManager.incBytecodes(5);
                                this.failConversion(c2, o);
                            }
                        }
                    }
                }
                final String s2 = string;
                BytecodeManager.incBytecodes(3);
                this.print(s2);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private void printString(final Object o, final Locale locale) throws IOException {
            try {
                final boolean b = o instanceof Formattable;
                BytecodeManager.incBytecodes(3);
                if (b) {
                    Formatter this$0 = Formatter.this;
                    BytecodeManager.incBytecodes(3);
                    final Formatter formatter = this$0;
                    BytecodeManager.incBytecodes(2);
                    final Locale locale2 = formatter.locale();
                    BytecodeManager.incBytecodes(2);
                    if (locale2 != locale) {
                        final Formatter formatter2 = this$0;
                        BytecodeManager.incBytecodes(4);
                        final Appendable out = formatter2.out();
                        BytecodeManager.incBytecodes(2);
                        this$0 = new Formatter(out, locale);
                        BytecodeManager.incBytecodes(1);
                    }
                    final Formattable formattable = (Formattable)o;
                    final Formatter formatter3 = this$0;
                    final Flags f = this.f;
                    BytecodeManager.incBytecodes(6);
                    final int value = f.valueOf();
                    final int width = this.width;
                    final int precision = this.precision;
                    BytecodeManager.incBytecodes(5);
                    formattable.formatTo(formatter3, value, width, precision);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    final Flags f2 = this.f;
                    final Flags alternate = Flags.ALTERNATE;
                    BytecodeManager.incBytecodes(4);
                    final boolean contains = f2.contains(alternate);
                    BytecodeManager.incBytecodes(1);
                    if (contains) {
                        final Flags alternate2 = Flags.ALTERNATE;
                        final char c = 's';
                        BytecodeManager.incBytecodes(4);
                        this.failMismatch(alternate2, c);
                    }
                    BytecodeManager.incBytecodes(2);
                    if (o == null) {
                        final String s = "null";
                        BytecodeManager.incBytecodes(3);
                        this.print(s);
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        BytecodeManager.incBytecodes(3);
                        final String string = o.toString();
                        BytecodeManager.incBytecodes(1);
                        this.print(string);
                    }
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private void printBoolean(final Object o) throws IOException {
            try {
                BytecodeManager.incBytecodes(2);
                String string;
                if (o != null) {
                    final boolean b = o instanceof Boolean;
                    BytecodeManager.incBytecodes(3);
                    String s;
                    if (b) {
                        final Boolean b2 = (Boolean)o;
                        BytecodeManager.incBytecodes(2);
                        BytecodeManager.incBytecodes(1);
                        s = b2.toString();
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        final boolean b3 = true;
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                        s = Boolean.toString(b3);
                    }
                    string = s;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final boolean b4 = false;
                    BytecodeManager.incBytecodes(2);
                    string = Boolean.toString(b4);
                    BytecodeManager.incBytecodes(1);
                }
                final String s2 = string;
                BytecodeManager.incBytecodes(3);
                this.print(s2);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private void printHashCode(final Object o) throws IOException {
            try {
                BytecodeManager.incBytecodes(2);
                String hexString;
                if (o == null) {
                    hexString = "null";
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    final int hashCode = o.hashCode();
                    BytecodeManager.incBytecodes(1);
                    hexString = Integer.toHexString(hashCode);
                }
                final String s = hexString;
                BytecodeManager.incBytecodes(1);
                final String s2 = s;
                BytecodeManager.incBytecodes(3);
                this.print(s2);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private void print(String s) throws IOException {
            try {
                final int precision = this.precision;
                final int n = -1;
                BytecodeManager.incBytecodes(4);
                if (precision != n) {
                    final int precision2 = this.precision;
                    final String s2 = s;
                    BytecodeManager.incBytecodes(4);
                    final int length = s2.length();
                    BytecodeManager.incBytecodes(1);
                    if (precision2 < length) {
                        final String s3 = s;
                        final int beginIndex = 0;
                        final int precision3 = this.precision;
                        BytecodeManager.incBytecodes(5);
                        s = s3.substring(beginIndex, precision3);
                        BytecodeManager.incBytecodes(1);
                    }
                }
                final Flags f = this.f;
                final Flags uppercase = Flags.UPPERCASE;
                BytecodeManager.incBytecodes(4);
                final boolean contains = f.contains(uppercase);
                BytecodeManager.incBytecodes(1);
                if (contains) {
                    final String s4 = s;
                    BytecodeManager.incBytecodes(2);
                    s = s4.toUpperCase();
                    BytecodeManager.incBytecodes(1);
                }
                final Formatter this$0 = Formatter.this;
                BytecodeManager.incBytecodes(3);
                final Appendable access$000 = Formatter.access$000(this$0);
                final String s5 = s;
                BytecodeManager.incBytecodes(3);
                final String justify = this.justify(s5);
                BytecodeManager.incBytecodes(1);
                access$000.append(justify);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private String justify(final String str) {
            try {
                final int width = this.width;
                final int n = -1;
                BytecodeManager.incBytecodes(4);
                if (width == n) {
                    BytecodeManager.incBytecodes(2);
                    return str;
                }
                BytecodeManager.incBytecodes(3);
                final StringBuilder sb = new StringBuilder();
                BytecodeManager.incBytecodes(1);
                final Flags f = this.f;
                final Flags left_JUSTIFY = Flags.LEFT_JUSTIFY;
                BytecodeManager.incBytecodes(4);
                final boolean contains = f.contains(left_JUSTIFY);
                BytecodeManager.incBytecodes(1);
                final int width2 = this.width;
                BytecodeManager.incBytecodes(4);
                final int n2 = width2 - str.length();
                BytecodeManager.incBytecodes(2);
                final boolean b = contains;
                BytecodeManager.incBytecodes(2);
                if (!b) {
                    int n3 = 0;
                    BytecodeManager.incBytecodes(2);
                    while (true) {
                        final int n4 = n3;
                        final int n5 = n2;
                        BytecodeManager.incBytecodes(3);
                        if (n4 >= n5) {
                            break;
                        }
                        final StringBuilder sb2 = sb;
                        final char c = ' ';
                        BytecodeManager.incBytecodes(3);
                        sb2.append(c);
                        ++n3;
                        BytecodeManager.incBytecodes(3);
                    }
                }
                final StringBuilder sb3 = sb;
                BytecodeManager.incBytecodes(3);
                sb3.append(str);
                BytecodeManager.incBytecodes(1);
                final boolean b2 = contains;
                BytecodeManager.incBytecodes(2);
                if (b2) {
                    int n6 = 0;
                    BytecodeManager.incBytecodes(2);
                    while (true) {
                        final int n7 = n6;
                        final int n8 = n2;
                        BytecodeManager.incBytecodes(3);
                        if (n7 >= n8) {
                            break;
                        }
                        final StringBuilder sb4 = sb;
                        final char c2 = ' ';
                        BytecodeManager.incBytecodes(3);
                        sb4.append(c2);
                        ++n6;
                        BytecodeManager.incBytecodes(3);
                    }
                }
                final StringBuilder sb5 = sb;
                BytecodeManager.incBytecodes(2);
                final String string = sb5.toString();
                BytecodeManager.incBytecodes(1);
                return string;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public String toString() {
            try {
                final String str = "%";
                BytecodeManager.incBytecodes(4);
                final StringBuilder sb = new StringBuilder(str);
                BytecodeManager.incBytecodes(1);
                final Flags f = this.f;
                BytecodeManager.incBytecodes(3);
                final Flags dup = f.dup();
                final Flags uppercase = Flags.UPPERCASE;
                BytecodeManager.incBytecodes(2);
                final Flags remove = dup.remove(uppercase);
                BytecodeManager.incBytecodes(1);
                final StringBuilder sb2 = sb;
                final Flags flags = remove;
                BytecodeManager.incBytecodes(3);
                final String string = flags.toString();
                BytecodeManager.incBytecodes(1);
                sb2.append(string);
                BytecodeManager.incBytecodes(1);
                final int index = this.index;
                BytecodeManager.incBytecodes(3);
                if (index > 0) {
                    final StringBuilder sb3 = sb;
                    final int index2 = this.index;
                    BytecodeManager.incBytecodes(4);
                    final StringBuilder append = sb3.append(index2);
                    final char c = '$';
                    BytecodeManager.incBytecodes(2);
                    append.append(c);
                    BytecodeManager.incBytecodes(1);
                }
                final int width = this.width;
                final int n = -1;
                BytecodeManager.incBytecodes(4);
                if (width != n) {
                    final StringBuilder sb4 = sb;
                    final int width2 = this.width;
                    BytecodeManager.incBytecodes(4);
                    sb4.append(width2);
                    BytecodeManager.incBytecodes(1);
                }
                final int precision = this.precision;
                final int n2 = -1;
                BytecodeManager.incBytecodes(4);
                if (precision != n2) {
                    final StringBuilder sb5 = sb;
                    final char c2 = '.';
                    BytecodeManager.incBytecodes(3);
                    final StringBuilder append2 = sb5.append(c2);
                    final int precision2 = this.precision;
                    BytecodeManager.incBytecodes(3);
                    append2.append(precision2);
                    BytecodeManager.incBytecodes(1);
                }
                final boolean dt = this.dt;
                BytecodeManager.incBytecodes(3);
                if (dt) {
                    final StringBuilder sb6 = sb;
                    final Flags f2 = this.f;
                    final Flags uppercase2 = Flags.UPPERCASE;
                    BytecodeManager.incBytecodes(5);
                    final boolean contains = f2.contains(uppercase2);
                    BytecodeManager.incBytecodes(1);
                    char c3;
                    if (contains) {
                        c3 = 'T';
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        c3 = 't';
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(1);
                    sb6.append(c3);
                    BytecodeManager.incBytecodes(1);
                }
                final StringBuilder sb7 = sb;
                final Flags f3 = this.f;
                final Flags uppercase3 = Flags.UPPERCASE;
                BytecodeManager.incBytecodes(5);
                final boolean contains2 = f3.contains(uppercase3);
                BytecodeManager.incBytecodes(1);
                char c5;
                if (contains2) {
                    final char c4 = this.c;
                    BytecodeManager.incBytecodes(2);
                    BytecodeManager.incBytecodes(1);
                    c5 = Character.toUpperCase(c4);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    c5 = this.c;
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(1);
                sb7.append(c5);
                BytecodeManager.incBytecodes(1);
                final StringBuilder sb8 = sb;
                BytecodeManager.incBytecodes(2);
                final String string2 = sb8.toString();
                BytecodeManager.incBytecodes(1);
                return string2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private void checkGeneral() {
            try {
                final char c = this.c;
                final int n = 'b';
                BytecodeManager.incBytecodes(4);
                Label_0072: {
                    if (c != n) {
                        final char c2 = this.c;
                        final int n2 = 'h';
                        BytecodeManager.incBytecodes(4);
                        if (c2 != n2) {
                            break Label_0072;
                        }
                    }
                    final Flags f = this.f;
                    final Flags alternate = Flags.ALTERNATE;
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(1);
                    final boolean contains = f.contains(alternate);
                    BytecodeManager.incBytecodes(1);
                    if (contains) {
                        final Flags alternate2 = Flags.ALTERNATE;
                        final char c3 = this.c;
                        BytecodeManager.incBytecodes(5);
                        this.failMismatch(alternate2, c3);
                    }
                }
                final int width = this.width;
                final int n3 = -1;
                BytecodeManager.incBytecodes(4);
                if (width == n3) {
                    final Flags f2 = this.f;
                    final Flags left_JUSTIFY = Flags.LEFT_JUSTIFY;
                    BytecodeManager.incBytecodes(4);
                    final boolean contains2 = f2.contains(left_JUSTIFY);
                    BytecodeManager.incBytecodes(1);
                    if (contains2) {
                        BytecodeManager.incBytecodes(4);
                        final String string = this.toString();
                        BytecodeManager.incBytecodes(1);
                        final MissingFormatWidthException ex = new MissingFormatWidthException(string);
                        BytecodeManager.incBytecodes(1);
                        throw ex;
                    }
                }
                final Flags[] array = { Flags.PLUS, Flags.LEADING_SPACE, Flags.ZERO_PAD, Flags.GROUP, Flags.PARENTHESES };
                BytecodeManager.incBytecodes(23);
                this.checkBadFlags(array);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private void checkDateTime() {
            try {
                final int precision = this.precision;
                final int n = -1;
                BytecodeManager.incBytecodes(4);
                if (precision != n) {
                    final int precision2 = this.precision;
                    BytecodeManager.incBytecodes(5);
                    final IllegalFormatPrecisionException ex = new IllegalFormatPrecisionException(precision2);
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final char c = this.c;
                BytecodeManager.incBytecodes(3);
                final boolean valid = DateTime.isValid(c);
                BytecodeManager.incBytecodes(1);
                if (!valid) {
                    BytecodeManager.incBytecodes(5);
                    final StringBuilder sb = new StringBuilder();
                    final String str = "t";
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append = sb.append(str);
                    final char c2 = this.c;
                    BytecodeManager.incBytecodes(3);
                    final StringBuilder append2 = append.append(c2);
                    BytecodeManager.incBytecodes(1);
                    final String string = append2.toString();
                    BytecodeManager.incBytecodes(1);
                    final UnknownFormatConversionException ex2 = new UnknownFormatConversionException(string);
                    BytecodeManager.incBytecodes(1);
                    throw ex2;
                }
                final Flags[] array = { Flags.ALTERNATE, Flags.PLUS, Flags.LEADING_SPACE, Flags.ZERO_PAD, Flags.GROUP, Flags.PARENTHESES };
                BytecodeManager.incBytecodes(27);
                this.checkBadFlags(array);
                final int width = this.width;
                final int n2 = -1;
                BytecodeManager.incBytecodes(4);
                if (width == n2) {
                    final Flags f = this.f;
                    final Flags left_JUSTIFY = Flags.LEFT_JUSTIFY;
                    BytecodeManager.incBytecodes(4);
                    final boolean contains = f.contains(left_JUSTIFY);
                    BytecodeManager.incBytecodes(1);
                    if (contains) {
                        BytecodeManager.incBytecodes(4);
                        final String string2 = this.toString();
                        BytecodeManager.incBytecodes(1);
                        final MissingFormatWidthException ex3 = new MissingFormatWidthException(string2);
                        BytecodeManager.incBytecodes(1);
                        throw ex3;
                    }
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private void checkCharacter() {
            try {
                final int precision = this.precision;
                final int n = -1;
                BytecodeManager.incBytecodes(4);
                if (precision != n) {
                    final int precision2 = this.precision;
                    BytecodeManager.incBytecodes(5);
                    final IllegalFormatPrecisionException ex = new IllegalFormatPrecisionException(precision2);
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final Flags[] array = { Flags.ALTERNATE, Flags.PLUS, Flags.LEADING_SPACE, Flags.ZERO_PAD, Flags.GROUP, Flags.PARENTHESES };
                BytecodeManager.incBytecodes(27);
                this.checkBadFlags(array);
                final int width = this.width;
                final int n2 = -1;
                BytecodeManager.incBytecodes(4);
                if (width == n2) {
                    final Flags f = this.f;
                    final Flags left_JUSTIFY = Flags.LEFT_JUSTIFY;
                    BytecodeManager.incBytecodes(4);
                    final boolean contains = f.contains(left_JUSTIFY);
                    BytecodeManager.incBytecodes(1);
                    if (contains) {
                        BytecodeManager.incBytecodes(4);
                        final String string = this.toString();
                        BytecodeManager.incBytecodes(1);
                        final MissingFormatWidthException ex2 = new MissingFormatWidthException(string);
                        BytecodeManager.incBytecodes(1);
                        throw ex2;
                    }
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private void checkInteger() {
            try {
                BytecodeManager.incBytecodes(2);
                this.checkNumeric();
                final int precision = this.precision;
                final int n = -1;
                BytecodeManager.incBytecodes(4);
                if (precision != n) {
                    final int precision2 = this.precision;
                    BytecodeManager.incBytecodes(5);
                    final IllegalFormatPrecisionException ex = new IllegalFormatPrecisionException(precision2);
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final char c = this.c;
                final int n2 = 'd';
                BytecodeManager.incBytecodes(4);
                if (c == n2) {
                    final Flags[] array = { Flags.ALTERNATE };
                    BytecodeManager.incBytecodes(7);
                    this.checkBadFlags(array);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    final char c2 = this.c;
                    final int n3 = 'o';
                    BytecodeManager.incBytecodes(4);
                    if (c2 == n3) {
                        final Flags[] array2 = { Flags.GROUP };
                        BytecodeManager.incBytecodes(7);
                        this.checkBadFlags(array2);
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        final Flags[] array3 = { Flags.GROUP };
                        BytecodeManager.incBytecodes(7);
                        this.checkBadFlags(array3);
                    }
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private void checkBadFlags(final Flags... array) {
            try {
                int n = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n2 = n;
                    final int length = array.length;
                    BytecodeManager.incBytecodes(4);
                    if (n2 >= length) {
                        break;
                    }
                    final Flags f = this.f;
                    final Flags flags = array[n];
                    BytecodeManager.incBytecodes(6);
                    final boolean contains = f.contains(flags);
                    BytecodeManager.incBytecodes(1);
                    if (contains) {
                        final Flags flags2 = array[n];
                        final char c = this.c;
                        BytecodeManager.incBytecodes(7);
                        this.failMismatch(flags2, c);
                    }
                    ++n;
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private void checkFloat() {
            try {
                BytecodeManager.incBytecodes(2);
                this.checkNumeric();
                final char c = this.c;
                final int n = 'f';
                BytecodeManager.incBytecodes(4);
                if (c == n) {
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    final char c2 = this.c;
                    final int n2 = 'a';
                    BytecodeManager.incBytecodes(4);
                    if (c2 == n2) {
                        final Flags[] array = { Flags.PARENTHESES, Flags.GROUP };
                        BytecodeManager.incBytecodes(11);
                        this.checkBadFlags(array);
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        final char c3 = this.c;
                        final int n3 = 'e';
                        BytecodeManager.incBytecodes(4);
                        if (c3 == n3) {
                            final Flags[] array2 = { Flags.GROUP };
                            BytecodeManager.incBytecodes(7);
                            this.checkBadFlags(array2);
                            BytecodeManager.incBytecodes(1);
                        }
                        else {
                            final char c4 = this.c;
                            final int n4 = 'g';
                            BytecodeManager.incBytecodes(4);
                            if (c4 == n4) {
                                final Flags[] array3 = { Flags.ALTERNATE };
                                BytecodeManager.incBytecodes(7);
                                this.checkBadFlags(array3);
                            }
                        }
                    }
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private void checkNumeric() {
            try {
                final int width = this.width;
                final int n = -1;
                BytecodeManager.incBytecodes(4);
                if (width != n) {
                    final int width2 = this.width;
                    BytecodeManager.incBytecodes(3);
                    if (width2 < 0) {
                        final int width3 = this.width;
                        BytecodeManager.incBytecodes(5);
                        final IllegalFormatWidthException ex = new IllegalFormatWidthException(width3);
                        BytecodeManager.incBytecodes(1);
                        throw ex;
                    }
                }
                final int precision = this.precision;
                final int n2 = -1;
                BytecodeManager.incBytecodes(4);
                if (precision != n2) {
                    final int precision2 = this.precision;
                    BytecodeManager.incBytecodes(3);
                    if (precision2 < 0) {
                        final int precision3 = this.precision;
                        BytecodeManager.incBytecodes(5);
                        final IllegalFormatPrecisionException ex2 = new IllegalFormatPrecisionException(precision3);
                        BytecodeManager.incBytecodes(1);
                        throw ex2;
                    }
                }
                final int width4 = this.width;
                final int n3 = -1;
                BytecodeManager.incBytecodes(4);
                Label_0185: {
                    if (width4 == n3) {
                        final Flags f = this.f;
                        final Flags left_JUSTIFY = Flags.LEFT_JUSTIFY;
                        BytecodeManager.incBytecodes(3);
                        BytecodeManager.incBytecodes(1);
                        final boolean contains = f.contains(left_JUSTIFY);
                        BytecodeManager.incBytecodes(1);
                        if (!contains) {
                            final Flags f2 = this.f;
                            final Flags zero_PAD = Flags.ZERO_PAD;
                            BytecodeManager.incBytecodes(4);
                            final boolean contains2 = f2.contains(zero_PAD);
                            BytecodeManager.incBytecodes(1);
                            if (!contains2) {
                                break Label_0185;
                            }
                        }
                        BytecodeManager.incBytecodes(4);
                        final String string = this.toString();
                        BytecodeManager.incBytecodes(1);
                        final MissingFormatWidthException ex3 = new MissingFormatWidthException(string);
                        BytecodeManager.incBytecodes(1);
                        throw ex3;
                    }
                }
                final Flags f3 = this.f;
                final Flags plus = Flags.PLUS;
                BytecodeManager.incBytecodes(4);
                final boolean contains3 = f3.contains(plus);
                BytecodeManager.incBytecodes(1);
                Label_0282: {
                    if (contains3) {
                        final Flags f4 = this.f;
                        final Flags leading_SPACE = Flags.LEADING_SPACE;
                        BytecodeManager.incBytecodes(4);
                        final boolean contains4 = f4.contains(leading_SPACE);
                        BytecodeManager.incBytecodes(1);
                        if (contains4) {
                            break Label_0282;
                        }
                    }
                    final Flags f5 = this.f;
                    final Flags left_JUSTIFY2 = Flags.LEFT_JUSTIFY;
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(1);
                    final boolean contains5 = f5.contains(left_JUSTIFY2);
                    BytecodeManager.incBytecodes(1);
                    if (contains5) {
                        final Flags f6 = this.f;
                        final Flags zero_PAD2 = Flags.ZERO_PAD;
                        BytecodeManager.incBytecodes(4);
                        final boolean contains6 = f6.contains(zero_PAD2);
                        BytecodeManager.incBytecodes(1);
                        if (contains6) {
                            break Label_0282;
                        }
                    }
                    BytecodeManager.incBytecodes(1);
                    return;
                }
                final Flags f7 = this.f;
                BytecodeManager.incBytecodes(5);
                final String string2 = f7.toString();
                BytecodeManager.incBytecodes(1);
                final IllegalFormatFlagsException ex4 = new IllegalFormatFlagsException(string2);
                BytecodeManager.incBytecodes(1);
                throw ex4;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private void checkText() {
            try {
                final int precision = this.precision;
                final int n = -1;
                BytecodeManager.incBytecodes(4);
                if (precision != n) {
                    final int precision2 = this.precision;
                    BytecodeManager.incBytecodes(5);
                    final IllegalFormatPrecisionException ex = new IllegalFormatPrecisionException(precision2);
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final char c = this.c;
                BytecodeManager.incBytecodes(3);
                switch (c) {
                    case 37: {
                        final Flags f = this.f;
                        BytecodeManager.incBytecodes(3);
                        final int value = f.valueOf();
                        final Flags left_JUSTIFY = Flags.LEFT_JUSTIFY;
                        BytecodeManager.incBytecodes(2);
                        final int value2 = left_JUSTIFY.valueOf();
                        BytecodeManager.incBytecodes(1);
                        if (value != value2) {
                            final Flags f2 = this.f;
                            BytecodeManager.incBytecodes(2);
                            BytecodeManager.incBytecodes(1);
                            final int value3 = f2.valueOf();
                            final Flags none = Flags.NONE;
                            BytecodeManager.incBytecodes(2);
                            final int value4 = none.valueOf();
                            BytecodeManager.incBytecodes(1);
                            if (value3 != value4) {
                                final Flags f3 = this.f;
                                BytecodeManager.incBytecodes(5);
                                final String string = f3.toString();
                                BytecodeManager.incBytecodes(1);
                                final IllegalFormatFlagsException ex2 = new IllegalFormatFlagsException(string);
                                BytecodeManager.incBytecodes(1);
                                throw ex2;
                            }
                        }
                        final int width = this.width;
                        final int n2 = -1;
                        BytecodeManager.incBytecodes(4);
                        if (width != n2) {
                            break;
                        }
                        final Flags f4 = this.f;
                        final Flags left_JUSTIFY2 = Flags.LEFT_JUSTIFY;
                        BytecodeManager.incBytecodes(4);
                        final boolean contains = f4.contains(left_JUSTIFY2);
                        BytecodeManager.incBytecodes(1);
                        if (contains) {
                            BytecodeManager.incBytecodes(4);
                            final String string2 = this.toString();
                            BytecodeManager.incBytecodes(1);
                            final MissingFormatWidthException ex3 = new MissingFormatWidthException(string2);
                            BytecodeManager.incBytecodes(1);
                            throw ex3;
                        }
                        break;
                    }
                    case 110: {
                        final int width2 = this.width;
                        final int n3 = -1;
                        BytecodeManager.incBytecodes(4);
                        if (width2 != n3) {
                            final int width3 = this.width;
                            BytecodeManager.incBytecodes(5);
                            final IllegalFormatWidthException ex4 = new IllegalFormatWidthException(width3);
                            BytecodeManager.incBytecodes(1);
                            throw ex4;
                        }
                        final Flags f5 = this.f;
                        BytecodeManager.incBytecodes(3);
                        final int value5 = f5.valueOf();
                        final Flags none2 = Flags.NONE;
                        BytecodeManager.incBytecodes(2);
                        final int value6 = none2.valueOf();
                        BytecodeManager.incBytecodes(1);
                        if (value5 != value6) {
                            final Flags f6 = this.f;
                            BytecodeManager.incBytecodes(5);
                            final String string3 = f6.toString();
                            BytecodeManager.incBytecodes(1);
                            final IllegalFormatFlagsException ex5 = new IllegalFormatFlagsException(string3);
                            BytecodeManager.incBytecodes(1);
                            throw ex5;
                        }
                        break;
                    }
                    default: {
                        final boolean $assertionsDisabled = FormatSpecifier.$assertionsDisabled;
                        BytecodeManager.incBytecodes(2);
                        if (!$assertionsDisabled) {
                            BytecodeManager.incBytecodes(3);
                            final AssertionError assertionError = new AssertionError();
                            BytecodeManager.incBytecodes(1);
                            throw assertionError;
                        }
                        break;
                    }
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private void print(final byte b, final Locale locale) throws IOException {
            try {
                long n = b;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(2);
                Label_0097: {
                    if (b < 0) {
                        final char c = this.c;
                        final int n2 = 'o';
                        BytecodeManager.incBytecodes(4);
                        if (c != n2) {
                            final char c2 = this.c;
                            final int n3 = 'x';
                            BytecodeManager.incBytecodes(4);
                            if (c2 != n3) {
                                break Label_0097;
                            }
                        }
                        n += 256L;
                        BytecodeManager.incBytecodes(4);
                        final boolean $assertionsDisabled = FormatSpecifier.$assertionsDisabled;
                        BytecodeManager.incBytecodes(2);
                        if (!$assertionsDisabled) {
                            final long n4 = lcmp(n, 0L);
                            BytecodeManager.incBytecodes(4);
                            if (n4 < 0) {
                                final long detailMessage = n;
                                BytecodeManager.incBytecodes(4);
                                final AssertionError assertionError = new AssertionError(detailMessage);
                                BytecodeManager.incBytecodes(1);
                                throw assertionError;
                            }
                        }
                    }
                }
                final long n5 = n;
                BytecodeManager.incBytecodes(4);
                this.print(n5, locale);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private void print(final short n, final Locale locale) throws IOException {
            try {
                long n2 = n;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(2);
                Label_0097: {
                    if (n < 0) {
                        final char c = this.c;
                        final int n3 = 'o';
                        BytecodeManager.incBytecodes(4);
                        if (c != n3) {
                            final char c2 = this.c;
                            final int n4 = 'x';
                            BytecodeManager.incBytecodes(4);
                            if (c2 != n4) {
                                break Label_0097;
                            }
                        }
                        n2 += 65536L;
                        BytecodeManager.incBytecodes(4);
                        final boolean $assertionsDisabled = FormatSpecifier.$assertionsDisabled;
                        BytecodeManager.incBytecodes(2);
                        if (!$assertionsDisabled) {
                            final long n5 = lcmp(n2, 0L);
                            BytecodeManager.incBytecodes(4);
                            if (n5 < 0) {
                                final long detailMessage = n2;
                                BytecodeManager.incBytecodes(4);
                                final AssertionError assertionError = new AssertionError(detailMessage);
                                BytecodeManager.incBytecodes(1);
                                throw assertionError;
                            }
                        }
                    }
                }
                final long n6 = n2;
                BytecodeManager.incBytecodes(4);
                this.print(n6, locale);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private void print(final int n, final Locale locale) throws IOException {
            try {
                long n2 = n;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(2);
                Label_0097: {
                    if (n < 0) {
                        final char c = this.c;
                        final int n3 = 'o';
                        BytecodeManager.incBytecodes(4);
                        if (c != n3) {
                            final char c2 = this.c;
                            final int n4 = 'x';
                            BytecodeManager.incBytecodes(4);
                            if (c2 != n4) {
                                break Label_0097;
                            }
                        }
                        n2 += 4294967296L;
                        BytecodeManager.incBytecodes(4);
                        final boolean $assertionsDisabled = FormatSpecifier.$assertionsDisabled;
                        BytecodeManager.incBytecodes(2);
                        if (!$assertionsDisabled) {
                            final long n5 = lcmp(n2, 0L);
                            BytecodeManager.incBytecodes(4);
                            if (n5 < 0) {
                                final long detailMessage = n2;
                                BytecodeManager.incBytecodes(4);
                                final AssertionError assertionError = new AssertionError(detailMessage);
                                BytecodeManager.incBytecodes(1);
                                throw assertionError;
                            }
                        }
                    }
                }
                final long n6 = n2;
                BytecodeManager.incBytecodes(4);
                this.print(n6, locale);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private void print(final long n, final Locale locale) throws IOException {
            try {
                BytecodeManager.incBytecodes(3);
                final StringBuilder sb = new StringBuilder();
                BytecodeManager.incBytecodes(1);
                final char c = this.c;
                final int n2 = 'd';
                BytecodeManager.incBytecodes(4);
                if (c == n2) {
                    final long n3 = lcmp(n, 0L);
                    BytecodeManager.incBytecodes(4);
                    int n4;
                    if (n3 < 0) {
                        n4 = 1;
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        n4 = 0;
                        BytecodeManager.incBytecodes(1);
                    }
                    final boolean b = n4 != 0;
                    BytecodeManager.incBytecodes(1);
                    final long n5 = lcmp(n, 0L);
                    BytecodeManager.incBytecodes(4);
                    char[] array;
                    if (n5 < 0) {
                        final int radix = 10;
                        BytecodeManager.incBytecodes(3);
                        final String string = Long.toString(n, radix);
                        final int beginIndex = 1;
                        BytecodeManager.incBytecodes(2);
                        final String substring = string.substring(beginIndex);
                        BytecodeManager.incBytecodes(1);
                        array = substring.toCharArray();
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        final int radix2 = 10;
                        BytecodeManager.incBytecodes(3);
                        final String string2 = Long.toString(n, radix2);
                        BytecodeManager.incBytecodes(1);
                        array = string2.toCharArray();
                        BytecodeManager.incBytecodes(1);
                    }
                    final StringBuilder sb2 = sb;
                    final boolean b2 = b;
                    BytecodeManager.incBytecodes(4);
                    this.leadingSign(sb2, b2);
                    BytecodeManager.incBytecodes(1);
                    final StringBuilder sb3 = sb;
                    final char[] array2 = array;
                    final Flags f = this.f;
                    final int width = this.width;
                    final Flags f2 = this.f;
                    final boolean b3 = b;
                    BytecodeManager.incBytecodes(12);
                    final int adjustWidth = this.adjustWidth(width, f2, b3);
                    BytecodeManager.incBytecodes(2);
                    this.localizedMagnitude(sb3, array2, f, adjustWidth, locale);
                    BytecodeManager.incBytecodes(1);
                    final StringBuilder sb4 = sb;
                    final boolean b4 = b;
                    BytecodeManager.incBytecodes(4);
                    this.trailingSign(sb4, b4);
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    final char c2 = this.c;
                    final int n6 = 'o';
                    BytecodeManager.incBytecodes(4);
                    if (c2 == n6) {
                        final Flags[] array3 = { Flags.PARENTHESES, Flags.LEADING_SPACE, Flags.PLUS };
                        BytecodeManager.incBytecodes(15);
                        this.checkBadFlags(array3);
                        BytecodeManager.incBytecodes(2);
                        final String octalString = Long.toOctalString(n);
                        BytecodeManager.incBytecodes(1);
                        final Flags f3 = this.f;
                        final Flags alternate = Flags.ALTERNATE;
                        BytecodeManager.incBytecodes(4);
                        final boolean contains = f3.contains(alternate);
                        BytecodeManager.incBytecodes(1);
                        int length;
                        if (contains) {
                            final String s = octalString;
                            BytecodeManager.incBytecodes(1);
                            BytecodeManager.incBytecodes(1);
                            length = s.length() + 1;
                            BytecodeManager.incBytecodes(3);
                        }
                        else {
                            final String s2 = octalString;
                            BytecodeManager.incBytecodes(1);
                            BytecodeManager.incBytecodes(1);
                            length = s2.length();
                        }
                        final int n7 = length;
                        BytecodeManager.incBytecodes(1);
                        final Flags f4 = this.f;
                        final Flags alternate2 = Flags.ALTERNATE;
                        BytecodeManager.incBytecodes(4);
                        final boolean contains2 = f4.contains(alternate2);
                        BytecodeManager.incBytecodes(1);
                        if (contains2) {
                            final StringBuilder sb5 = sb;
                            final char c3 = '0';
                            BytecodeManager.incBytecodes(3);
                            sb5.append(c3);
                            BytecodeManager.incBytecodes(1);
                        }
                        final Flags f5 = this.f;
                        final Flags zero_PAD = Flags.ZERO_PAD;
                        BytecodeManager.incBytecodes(4);
                        final boolean contains3 = f5.contains(zero_PAD);
                        BytecodeManager.incBytecodes(1);
                        if (contains3) {
                            int n8 = 0;
                            BytecodeManager.incBytecodes(2);
                            while (true) {
                                final int n9 = n8;
                                final int n10 = this.width - n7;
                                BytecodeManager.incBytecodes(6);
                                if (n9 >= n10) {
                                    break;
                                }
                                final StringBuilder sb6 = sb;
                                final char c4 = '0';
                                BytecodeManager.incBytecodes(3);
                                sb6.append(c4);
                                ++n8;
                                BytecodeManager.incBytecodes(3);
                            }
                        }
                        final StringBuilder sb7 = sb;
                        final String str = octalString;
                        BytecodeManager.incBytecodes(3);
                        sb7.append(str);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        final char c5 = this.c;
                        final int n11 = 'x';
                        BytecodeManager.incBytecodes(4);
                        if (c5 == n11) {
                            final Flags[] array4 = { Flags.PARENTHESES, Flags.LEADING_SPACE, Flags.PLUS };
                            BytecodeManager.incBytecodes(15);
                            this.checkBadFlags(array4);
                            BytecodeManager.incBytecodes(2);
                            String s3 = Long.toHexString(n);
                            BytecodeManager.incBytecodes(1);
                            final Flags f6 = this.f;
                            final Flags alternate3 = Flags.ALTERNATE;
                            BytecodeManager.incBytecodes(4);
                            final boolean contains4 = f6.contains(alternate3);
                            BytecodeManager.incBytecodes(1);
                            int length2;
                            if (contains4) {
                                final String s4 = s3;
                                BytecodeManager.incBytecodes(1);
                                BytecodeManager.incBytecodes(1);
                                length2 = s4.length() + 2;
                                BytecodeManager.incBytecodes(3);
                            }
                            else {
                                final String s5 = s3;
                                BytecodeManager.incBytecodes(1);
                                BytecodeManager.incBytecodes(1);
                                length2 = s5.length();
                            }
                            final int n12 = length2;
                            BytecodeManager.incBytecodes(1);
                            final Flags f7 = this.f;
                            final Flags alternate4 = Flags.ALTERNATE;
                            BytecodeManager.incBytecodes(4);
                            final boolean contains5 = f7.contains(alternate4);
                            BytecodeManager.incBytecodes(1);
                            if (contains5) {
                                final StringBuilder sb8 = sb;
                                final Flags f8 = this.f;
                                final Flags uppercase = Flags.UPPERCASE;
                                BytecodeManager.incBytecodes(5);
                                final boolean contains6 = f8.contains(uppercase);
                                BytecodeManager.incBytecodes(1);
                                String str2;
                                if (contains6) {
                                    str2 = "0X";
                                    BytecodeManager.incBytecodes(2);
                                }
                                else {
                                    str2 = "0x";
                                    BytecodeManager.incBytecodes(1);
                                }
                                BytecodeManager.incBytecodes(1);
                                sb8.append(str2);
                                BytecodeManager.incBytecodes(1);
                            }
                            final Flags f9 = this.f;
                            final Flags zero_PAD2 = Flags.ZERO_PAD;
                            BytecodeManager.incBytecodes(4);
                            final boolean contains7 = f9.contains(zero_PAD2);
                            BytecodeManager.incBytecodes(1);
                            if (contains7) {
                                int n13 = 0;
                                BytecodeManager.incBytecodes(2);
                                while (true) {
                                    final int n14 = n13;
                                    final int n15 = this.width - n12;
                                    BytecodeManager.incBytecodes(6);
                                    if (n14 >= n15) {
                                        break;
                                    }
                                    final StringBuilder sb9 = sb;
                                    final char c6 = '0';
                                    BytecodeManager.incBytecodes(3);
                                    sb9.append(c6);
                                    ++n13;
                                    BytecodeManager.incBytecodes(3);
                                }
                            }
                            final Flags f10 = this.f;
                            final Flags uppercase2 = Flags.UPPERCASE;
                            BytecodeManager.incBytecodes(4);
                            final boolean contains8 = f10.contains(uppercase2);
                            BytecodeManager.incBytecodes(1);
                            if (contains8) {
                                final String s6 = s3;
                                BytecodeManager.incBytecodes(2);
                                s3 = s6.toUpperCase();
                                BytecodeManager.incBytecodes(1);
                            }
                            final StringBuilder sb10 = sb;
                            final String str3 = s3;
                            BytecodeManager.incBytecodes(3);
                            sb10.append(str3);
                            BytecodeManager.incBytecodes(1);
                        }
                    }
                }
                final Formatter this$0 = Formatter.this;
                BytecodeManager.incBytecodes(3);
                final Appendable access$000 = Formatter.access$000(this$0);
                final StringBuilder sb11 = sb;
                BytecodeManager.incBytecodes(3);
                final String string3 = sb11.toString();
                BytecodeManager.incBytecodes(1);
                final String justify = this.justify(string3);
                BytecodeManager.incBytecodes(1);
                access$000.append(justify);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private StringBuilder leadingSign(final StringBuilder sb, final boolean b) {
            try {
                BytecodeManager.incBytecodes(2);
                if (!b) {
                    final Flags f = this.f;
                    final Flags plus = Flags.PLUS;
                    BytecodeManager.incBytecodes(4);
                    final boolean contains = f.contains(plus);
                    BytecodeManager.incBytecodes(1);
                    if (contains) {
                        final char c = '+';
                        BytecodeManager.incBytecodes(3);
                        sb.append(c);
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        final Flags f2 = this.f;
                        final Flags leading_SPACE = Flags.LEADING_SPACE;
                        BytecodeManager.incBytecodes(4);
                        final boolean contains2 = f2.contains(leading_SPACE);
                        BytecodeManager.incBytecodes(1);
                        if (contains2) {
                            final char c2 = ' ';
                            BytecodeManager.incBytecodes(3);
                            sb.append(c2);
                            BytecodeManager.incBytecodes(2);
                        }
                    }
                }
                else {
                    final Flags f3 = this.f;
                    final Flags parentheses = Flags.PARENTHESES;
                    BytecodeManager.incBytecodes(4);
                    final boolean contains3 = f3.contains(parentheses);
                    BytecodeManager.incBytecodes(1);
                    if (contains3) {
                        final char c3 = '(';
                        BytecodeManager.incBytecodes(3);
                        sb.append(c3);
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        final char c4 = '-';
                        BytecodeManager.incBytecodes(3);
                        sb.append(c4);
                        BytecodeManager.incBytecodes(1);
                    }
                }
                BytecodeManager.incBytecodes(2);
                return sb;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private StringBuilder trailingSign(final StringBuilder sb, final boolean b) {
            try {
                BytecodeManager.incBytecodes(2);
                if (b) {
                    final Flags f = this.f;
                    final Flags parentheses = Flags.PARENTHESES;
                    BytecodeManager.incBytecodes(4);
                    final boolean contains = f.contains(parentheses);
                    BytecodeManager.incBytecodes(1);
                    if (contains) {
                        final char c = ')';
                        BytecodeManager.incBytecodes(3);
                        sb.append(c);
                        BytecodeManager.incBytecodes(1);
                    }
                }
                BytecodeManager.incBytecodes(2);
                return sb;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private void print(final BigInteger bigInteger, final Locale locale) throws IOException {
            try {
                BytecodeManager.incBytecodes(3);
                final StringBuilder sb = new StringBuilder();
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(2);
                final int signum = bigInteger.signum();
                final int n = -1;
                BytecodeManager.incBytecodes(2);
                int n2;
                if (signum == n) {
                    n2 = 1;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    n2 = 0;
                    BytecodeManager.incBytecodes(1);
                }
                final int n3 = n2;
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(2);
                final BigInteger abs = bigInteger.abs();
                BytecodeManager.incBytecodes(1);
                final StringBuilder sb2 = sb;
                final int n4 = n3;
                BytecodeManager.incBytecodes(4);
                this.leadingSign(sb2, (boolean)(n4 != 0));
                BytecodeManager.incBytecodes(1);
                final char c = this.c;
                final int n5 = 'd';
                BytecodeManager.incBytecodes(4);
                if (c == n5) {
                    final BigInteger bigInteger2 = abs;
                    BytecodeManager.incBytecodes(2);
                    final String string = bigInteger2.toString();
                    BytecodeManager.incBytecodes(1);
                    final char[] charArray = string.toCharArray();
                    BytecodeManager.incBytecodes(1);
                    final StringBuilder sb3 = sb;
                    final char[] array = charArray;
                    final Flags f = this.f;
                    final int width = this.width;
                    final Flags f2 = this.f;
                    final boolean b = n3 != 0;
                    BytecodeManager.incBytecodes(12);
                    final int adjustWidth = this.adjustWidth(width, f2, b);
                    BytecodeManager.incBytecodes(2);
                    this.localizedMagnitude(sb3, array, f, adjustWidth, locale);
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    final char c2 = this.c;
                    final int n6 = 'o';
                    BytecodeManager.incBytecodes(4);
                    if (c2 == n6) {
                        final BigInteger bigInteger3 = abs;
                        final int n7 = 8;
                        BytecodeManager.incBytecodes(3);
                        final String string2 = bigInteger3.toString(n7);
                        BytecodeManager.incBytecodes(1);
                        final String s = string2;
                        BytecodeManager.incBytecodes(2);
                        final int length = s.length();
                        final StringBuilder sb4 = sb;
                        BytecodeManager.incBytecodes(2);
                        int n8 = length + sb4.length();
                        BytecodeManager.incBytecodes(2);
                        final int n9 = n3;
                        BytecodeManager.incBytecodes(2);
                        if (n9 != 0) {
                            final Flags f3 = this.f;
                            final Flags parentheses = Flags.PARENTHESES;
                            BytecodeManager.incBytecodes(4);
                            final boolean contains = f3.contains(parentheses);
                            BytecodeManager.incBytecodes(1);
                            if (contains) {
                                ++n8;
                                BytecodeManager.incBytecodes(1);
                            }
                        }
                        final Flags f4 = this.f;
                        final Flags alternate = Flags.ALTERNATE;
                        BytecodeManager.incBytecodes(4);
                        final boolean contains2 = f4.contains(alternate);
                        BytecodeManager.incBytecodes(1);
                        if (contains2) {
                            ++n8;
                            BytecodeManager.incBytecodes(1);
                            final StringBuilder sb5 = sb;
                            final char c3 = '0';
                            BytecodeManager.incBytecodes(3);
                            sb5.append(c3);
                            BytecodeManager.incBytecodes(1);
                        }
                        final Flags f5 = this.f;
                        final Flags zero_PAD = Flags.ZERO_PAD;
                        BytecodeManager.incBytecodes(4);
                        final boolean contains3 = f5.contains(zero_PAD);
                        BytecodeManager.incBytecodes(1);
                        if (contains3) {
                            int n10 = 0;
                            BytecodeManager.incBytecodes(2);
                            while (true) {
                                final int n11 = n10;
                                final int n12 = this.width - n8;
                                BytecodeManager.incBytecodes(6);
                                if (n11 >= n12) {
                                    break;
                                }
                                final StringBuilder sb6 = sb;
                                final char c4 = '0';
                                BytecodeManager.incBytecodes(3);
                                sb6.append(c4);
                                BytecodeManager.incBytecodes(1);
                                ++n10;
                                BytecodeManager.incBytecodes(2);
                            }
                        }
                        final StringBuilder sb7 = sb;
                        final String str = string2;
                        BytecodeManager.incBytecodes(3);
                        sb7.append(str);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        final char c5 = this.c;
                        final int n13 = 'x';
                        BytecodeManager.incBytecodes(4);
                        if (c5 == n13) {
                            final BigInteger bigInteger4 = abs;
                            final int n14 = 16;
                            BytecodeManager.incBytecodes(3);
                            String s2 = bigInteger4.toString(n14);
                            BytecodeManager.incBytecodes(1);
                            final String s3 = s2;
                            BytecodeManager.incBytecodes(2);
                            final int length2 = s3.length();
                            final StringBuilder sb8 = sb;
                            BytecodeManager.incBytecodes(2);
                            int n15 = length2 + sb8.length();
                            BytecodeManager.incBytecodes(2);
                            final int n16 = n3;
                            BytecodeManager.incBytecodes(2);
                            if (n16 != 0) {
                                final Flags f6 = this.f;
                                final Flags parentheses2 = Flags.PARENTHESES;
                                BytecodeManager.incBytecodes(4);
                                final boolean contains4 = f6.contains(parentheses2);
                                BytecodeManager.incBytecodes(1);
                                if (contains4) {
                                    ++n15;
                                    BytecodeManager.incBytecodes(1);
                                }
                            }
                            final Flags f7 = this.f;
                            final Flags alternate2 = Flags.ALTERNATE;
                            BytecodeManager.incBytecodes(4);
                            final boolean contains5 = f7.contains(alternate2);
                            BytecodeManager.incBytecodes(1);
                            if (contains5) {
                                n15 += 2;
                                BytecodeManager.incBytecodes(1);
                                final StringBuilder sb9 = sb;
                                final Flags f8 = this.f;
                                final Flags uppercase = Flags.UPPERCASE;
                                BytecodeManager.incBytecodes(5);
                                final boolean contains6 = f8.contains(uppercase);
                                BytecodeManager.incBytecodes(1);
                                String str2;
                                if (contains6) {
                                    str2 = "0X";
                                    BytecodeManager.incBytecodes(2);
                                }
                                else {
                                    str2 = "0x";
                                    BytecodeManager.incBytecodes(1);
                                }
                                BytecodeManager.incBytecodes(1);
                                sb9.append(str2);
                                BytecodeManager.incBytecodes(1);
                            }
                            final Flags f9 = this.f;
                            final Flags zero_PAD2 = Flags.ZERO_PAD;
                            BytecodeManager.incBytecodes(4);
                            final boolean contains7 = f9.contains(zero_PAD2);
                            BytecodeManager.incBytecodes(1);
                            if (contains7) {
                                int n17 = 0;
                                BytecodeManager.incBytecodes(2);
                                while (true) {
                                    final int n18 = n17;
                                    final int n19 = this.width - n15;
                                    BytecodeManager.incBytecodes(6);
                                    if (n18 >= n19) {
                                        break;
                                    }
                                    final StringBuilder sb10 = sb;
                                    final char c6 = '0';
                                    BytecodeManager.incBytecodes(3);
                                    sb10.append(c6);
                                    BytecodeManager.incBytecodes(1);
                                    ++n17;
                                    BytecodeManager.incBytecodes(2);
                                }
                            }
                            final Flags f10 = this.f;
                            final Flags uppercase2 = Flags.UPPERCASE;
                            BytecodeManager.incBytecodes(4);
                            final boolean contains8 = f10.contains(uppercase2);
                            BytecodeManager.incBytecodes(1);
                            if (contains8) {
                                final String s4 = s2;
                                BytecodeManager.incBytecodes(2);
                                s2 = s4.toUpperCase();
                                BytecodeManager.incBytecodes(1);
                            }
                            final StringBuilder sb11 = sb;
                            final String str3 = s2;
                            BytecodeManager.incBytecodes(3);
                            sb11.append(str3);
                            BytecodeManager.incBytecodes(1);
                        }
                    }
                }
                final StringBuilder sb12 = sb;
                BytecodeManager.incBytecodes(4);
                final int signum2 = bigInteger.signum();
                final int n20 = -1;
                BytecodeManager.incBytecodes(2);
                boolean b2;
                if (signum2 == n20) {
                    b2 = true;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    b2 = false;
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
                this.trailingSign(sb12, b2);
                BytecodeManager.incBytecodes(1);
                final Formatter this$0 = Formatter.this;
                BytecodeManager.incBytecodes(3);
                final Appendable access$000 = Formatter.access$000(this$0);
                final StringBuilder sb13 = sb;
                BytecodeManager.incBytecodes(3);
                final String string3 = sb13.toString();
                BytecodeManager.incBytecodes(1);
                final String justify = this.justify(string3);
                BytecodeManager.incBytecodes(1);
                access$000.append(justify);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private void print(final float n, final Locale locale) throws IOException {
            try {
                final double n2 = n;
                BytecodeManager.incBytecodes(5);
                this.print(n2, locale);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private void print(final double a, final Locale locale) throws IOException {
            try {
                BytecodeManager.incBytecodes(3);
                final StringBuilder sb = new StringBuilder();
                BytecodeManager.incBytecodes(1);
                final double d2 = 0.0;
                BytecodeManager.incBytecodes(3);
                final int compare = Double.compare(a, d2);
                final int n = -1;
                BytecodeManager.incBytecodes(2);
                int n2;
                if (compare == n) {
                    n2 = 1;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    n2 = 0;
                    BytecodeManager.incBytecodes(1);
                }
                final boolean b = n2 != 0;
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(2);
                final boolean naN = Double.isNaN(a);
                BytecodeManager.incBytecodes(1);
                if (!naN) {
                    BytecodeManager.incBytecodes(2);
                    final double abs = Math.abs(a);
                    BytecodeManager.incBytecodes(1);
                    final StringBuilder sb2 = sb;
                    final boolean b2 = b;
                    BytecodeManager.incBytecodes(4);
                    this.leadingSign(sb2, b2);
                    BytecodeManager.incBytecodes(1);
                    final double v = abs;
                    BytecodeManager.incBytecodes(2);
                    final boolean infinite = Double.isInfinite(v);
                    BytecodeManager.incBytecodes(1);
                    if (!infinite) {
                        final StringBuilder sb3 = sb;
                        final double n3 = abs;
                        final Flags f = this.f;
                        final char c = this.c;
                        final int precision = this.precision;
                        final boolean b3 = b;
                        BytecodeManager.incBytecodes(12);
                        this.print(sb3, n3, locale, f, c, precision, b3);
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        final StringBuilder sb4 = sb;
                        final Flags f2 = this.f;
                        final Flags uppercase = Flags.UPPERCASE;
                        BytecodeManager.incBytecodes(5);
                        final boolean contains = f2.contains(uppercase);
                        BytecodeManager.incBytecodes(1);
                        String str;
                        if (contains) {
                            str = "INFINITY";
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            str = "Infinity";
                            BytecodeManager.incBytecodes(1);
                        }
                        BytecodeManager.incBytecodes(1);
                        sb4.append(str);
                        BytecodeManager.incBytecodes(1);
                    }
                    final StringBuilder sb5 = sb;
                    final boolean b4 = b;
                    BytecodeManager.incBytecodes(4);
                    this.trailingSign(sb5, b4);
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    final StringBuilder sb6 = sb;
                    final Flags f3 = this.f;
                    final Flags uppercase2 = Flags.UPPERCASE;
                    BytecodeManager.incBytecodes(5);
                    final boolean contains2 = f3.contains(uppercase2);
                    BytecodeManager.incBytecodes(1);
                    String str2;
                    if (contains2) {
                        str2 = "NAN";
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        str2 = "NaN";
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(1);
                    sb6.append(str2);
                    BytecodeManager.incBytecodes(1);
                }
                final Formatter this$0 = Formatter.this;
                BytecodeManager.incBytecodes(3);
                final Appendable access$000 = Formatter.access$000(this$0);
                final StringBuilder sb7 = sb;
                BytecodeManager.incBytecodes(3);
                final String string = sb7.toString();
                BytecodeManager.incBytecodes(1);
                final String justify = this.justify(string);
                BytecodeManager.incBytecodes(1);
                access$000.append(justify);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private void print(final StringBuilder sb, final double n, final Locale locale, final Flags flags, final char c, final int n2, final boolean b) throws IOException {
            try {
                final char c2 = 'e';
                BytecodeManager.incBytecodes(3);
                if (c == c2) {
                    final int n3 = -1;
                    BytecodeManager.incBytecodes(3);
                    int n4;
                    if (n2 == n3) {
                        n4 = 6;
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        n4 = n2;
                        BytecodeManager.incBytecodes(1);
                    }
                    final int n5 = n4;
                    BytecodeManager.incBytecodes(1);
                    final int n6 = n5;
                    final FormattedFloatingDecimal.Form scientific = FormattedFloatingDecimal.Form.SCIENTIFIC;
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(1);
                    final FormattedFloatingDecimal value = FormattedFloatingDecimal.valueOf(n, n6, scientific);
                    BytecodeManager.incBytecodes(1);
                    final FormattedFloatingDecimal formattedFloatingDecimal = value;
                    BytecodeManager.incBytecodes(3);
                    final char[] mantissa = formattedFloatingDecimal.getMantissa();
                    final int n7 = n5;
                    BytecodeManager.incBytecodes(2);
                    char[] array = this.addZeros(mantissa, n7);
                    BytecodeManager.incBytecodes(1);
                    final Flags alternate = Flags.ALTERNATE;
                    BytecodeManager.incBytecodes(3);
                    final boolean contains = flags.contains(alternate);
                    BytecodeManager.incBytecodes(1);
                    if (contains) {
                        final int n8 = n5;
                        BytecodeManager.incBytecodes(2);
                        if (n8 == 0) {
                            final char[] array2 = array;
                            BytecodeManager.incBytecodes(3);
                            array = this.addDot(array2);
                            BytecodeManager.incBytecodes(1);
                        }
                    }
                    final double n9 = dcmpl(n, 0.0);
                    BytecodeManager.incBytecodes(4);
                    char[] exponent;
                    if (n9 == 0) {
                        exponent = new char[] { '+', '0', '0' };
                        BytecodeManager.incBytecodes(14);
                    }
                    else {
                        final FormattedFloatingDecimal formattedFloatingDecimal2 = value;
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                        exponent = formattedFloatingDecimal2.getExponent();
                    }
                    final char[] array3 = exponent;
                    BytecodeManager.incBytecodes(1);
                    int n10 = this.width;
                    BytecodeManager.incBytecodes(3);
                    final int width = this.width;
                    final int n11 = -1;
                    BytecodeManager.incBytecodes(4);
                    if (width != n11) {
                        final int n12 = this.width - array3.length - 1;
                        BytecodeManager.incBytecodes(11);
                        n10 = this.adjustWidth(n12, flags, b);
                        BytecodeManager.incBytecodes(1);
                    }
                    final char[] array4 = array;
                    final int n13 = n10;
                    BytecodeManager.incBytecodes(7);
                    this.localizedMagnitude(sb, array4, flags, n13, locale);
                    BytecodeManager.incBytecodes(1);
                    final Flags uppercase = Flags.UPPERCASE;
                    BytecodeManager.incBytecodes(4);
                    final boolean contains2 = flags.contains(uppercase);
                    BytecodeManager.incBytecodes(1);
                    char c3;
                    if (contains2) {
                        c3 = 'E';
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        c3 = 'e';
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(1);
                    sb.append(c3);
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(2);
                    final Flags dup = flags.dup();
                    final Flags group = Flags.GROUP;
                    BytecodeManager.incBytecodes(2);
                    final Flags remove = dup.remove(group);
                    BytecodeManager.incBytecodes(1);
                    final char c4 = array3[0];
                    BytecodeManager.incBytecodes(4);
                    final boolean $assertionsDisabled = FormatSpecifier.$assertionsDisabled;
                    BytecodeManager.incBytecodes(2);
                    if (!$assertionsDisabled) {
                        final char c5 = c4;
                        final int n14 = '+';
                        BytecodeManager.incBytecodes(3);
                        if (c5 != n14) {
                            final char c6 = c4;
                            final int n15 = '-';
                            BytecodeManager.incBytecodes(3);
                            if (c6 != n15) {
                                BytecodeManager.incBytecodes(3);
                                final AssertionError assertionError = new AssertionError();
                                BytecodeManager.incBytecodes(1);
                                throw assertionError;
                            }
                        }
                    }
                    final char c7 = c4;
                    BytecodeManager.incBytecodes(3);
                    sb.append(c7);
                    BytecodeManager.incBytecodes(1);
                    final char[] array5 = new char[array3.length - 1];
                    BytecodeManager.incBytecodes(5);
                    final char[] array6 = array3;
                    final int n16 = 1;
                    final char[] array7 = array5;
                    final int n17 = 0;
                    final int n18 = array3.length - 1;
                    BytecodeManager.incBytecodes(9);
                    System.arraycopy(array6, n16, array7, n17, n18);
                    final StringBuilder sb2 = null;
                    final char[] array8 = array5;
                    final Flags flags2 = remove;
                    final int n19 = -1;
                    BytecodeManager.incBytecodes(8);
                    final StringBuilder localizedMagnitude = this.localizedMagnitude(sb2, array8, flags2, n19, locale);
                    BytecodeManager.incBytecodes(1);
                    sb.append((CharSequence)localizedMagnitude);
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    final char c8 = 'f';
                    BytecodeManager.incBytecodes(3);
                    if (c == c8) {
                        final int n20 = -1;
                        BytecodeManager.incBytecodes(3);
                        int n21;
                        if (n2 == n20) {
                            n21 = 6;
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            n21 = n2;
                            BytecodeManager.incBytecodes(1);
                        }
                        final int n22 = n21;
                        BytecodeManager.incBytecodes(1);
                        final int n23 = n22;
                        final FormattedFloatingDecimal.Form decimal_FLOAT = FormattedFloatingDecimal.Form.DECIMAL_FLOAT;
                        BytecodeManager.incBytecodes(3);
                        BytecodeManager.incBytecodes(1);
                        final FormattedFloatingDecimal value2 = FormattedFloatingDecimal.valueOf(n, n23, decimal_FLOAT);
                        BytecodeManager.incBytecodes(1);
                        final FormattedFloatingDecimal formattedFloatingDecimal3 = value2;
                        BytecodeManager.incBytecodes(3);
                        final char[] mantissa2 = formattedFloatingDecimal3.getMantissa();
                        final int n24 = n22;
                        BytecodeManager.incBytecodes(2);
                        char[] array9 = this.addZeros(mantissa2, n24);
                        BytecodeManager.incBytecodes(1);
                        final Flags alternate2 = Flags.ALTERNATE;
                        BytecodeManager.incBytecodes(3);
                        final boolean contains3 = flags.contains(alternate2);
                        BytecodeManager.incBytecodes(1);
                        if (contains3) {
                            final int n25 = n22;
                            BytecodeManager.incBytecodes(2);
                            if (n25 == 0) {
                                final char[] array10 = array9;
                                BytecodeManager.incBytecodes(3);
                                array9 = this.addDot(array10);
                                BytecodeManager.incBytecodes(1);
                            }
                        }
                        int n26 = this.width;
                        BytecodeManager.incBytecodes(3);
                        final int width2 = this.width;
                        final int n27 = -1;
                        BytecodeManager.incBytecodes(4);
                        if (width2 != n27) {
                            final int width3 = this.width;
                            BytecodeManager.incBytecodes(6);
                            n26 = this.adjustWidth(width3, flags, b);
                            BytecodeManager.incBytecodes(1);
                        }
                        final char[] array11 = array9;
                        final int n28 = n26;
                        BytecodeManager.incBytecodes(7);
                        this.localizedMagnitude(sb, array11, flags, n28, locale);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        final char c9 = 'g';
                        BytecodeManager.incBytecodes(3);
                        if (c == c9) {
                            int n29 = n2;
                            BytecodeManager.incBytecodes(2);
                            final int n30 = -1;
                            BytecodeManager.incBytecodes(3);
                            if (n2 == n30) {
                                n29 = 6;
                                BytecodeManager.incBytecodes(3);
                            }
                            else {
                                BytecodeManager.incBytecodes(2);
                                if (n2 == 0) {
                                    n29 = 1;
                                    BytecodeManager.incBytecodes(2);
                                }
                            }
                            final double n31 = dcmpl(n, 0.0);
                            BytecodeManager.incBytecodes(4);
                            Object exponent2;
                            char[] mantissa3;
                            int exponentRounded;
                            if (n31 == 0) {
                                exponent2 = null;
                                BytecodeManager.incBytecodes(2);
                                mantissa3 = new char[] { '0' };
                                BytecodeManager.incBytecodes(6);
                                exponentRounded = 0;
                                BytecodeManager.incBytecodes(3);
                            }
                            else {
                                final int n32 = n29;
                                final FormattedFloatingDecimal.Form general = FormattedFloatingDecimal.Form.GENERAL;
                                BytecodeManager.incBytecodes(3);
                                BytecodeManager.incBytecodes(1);
                                final FormattedFloatingDecimal value3 = FormattedFloatingDecimal.valueOf(n, n32, general);
                                BytecodeManager.incBytecodes(1);
                                final FormattedFloatingDecimal formattedFloatingDecimal4 = value3;
                                BytecodeManager.incBytecodes(2);
                                exponent2 = formattedFloatingDecimal4.getExponent();
                                BytecodeManager.incBytecodes(1);
                                final FormattedFloatingDecimal formattedFloatingDecimal5 = value3;
                                BytecodeManager.incBytecodes(2);
                                mantissa3 = formattedFloatingDecimal5.getMantissa();
                                BytecodeManager.incBytecodes(1);
                                final FormattedFloatingDecimal formattedFloatingDecimal6 = value3;
                                BytecodeManager.incBytecodes(2);
                                exponentRounded = formattedFloatingDecimal6.getExponentRounded();
                                BytecodeManager.incBytecodes(1);
                            }
                            final Object o = exponent2;
                            BytecodeManager.incBytecodes(2);
                            if (o != null) {
                                --n29;
                                BytecodeManager.incBytecodes(2);
                            }
                            else {
                                n29 -= exponentRounded + 1;
                                BytecodeManager.incBytecodes(6);
                            }
                            final char[] array12 = mantissa3;
                            final int n33 = n29;
                            BytecodeManager.incBytecodes(4);
                            char[] array13 = this.addZeros(array12, n33);
                            BytecodeManager.incBytecodes(1);
                            final Flags alternate3 = Flags.ALTERNATE;
                            BytecodeManager.incBytecodes(3);
                            final boolean contains4 = flags.contains(alternate3);
                            BytecodeManager.incBytecodes(1);
                            if (contains4) {
                                final int n34 = n29;
                                BytecodeManager.incBytecodes(2);
                                if (n34 == 0) {
                                    final char[] array14 = array13;
                                    BytecodeManager.incBytecodes(3);
                                    array13 = this.addDot(array14);
                                    BytecodeManager.incBytecodes(1);
                                }
                            }
                            int n35 = this.width;
                            BytecodeManager.incBytecodes(3);
                            final int width4 = this.width;
                            final int n36 = -1;
                            BytecodeManager.incBytecodes(4);
                            if (width4 != n36) {
                                final Object o2 = exponent2;
                                BytecodeManager.incBytecodes(2);
                                if (o2 != null) {
                                    final int n37 = this.width - exponent2.length - 1;
                                    BytecodeManager.incBytecodes(11);
                                    n35 = this.adjustWidth(n37, flags, b);
                                    BytecodeManager.incBytecodes(2);
                                }
                                else {
                                    final int width5 = this.width;
                                    BytecodeManager.incBytecodes(6);
                                    n35 = this.adjustWidth(width5, flags, b);
                                    BytecodeManager.incBytecodes(1);
                                }
                            }
                            final char[] array15 = array13;
                            final int n38 = n35;
                            BytecodeManager.incBytecodes(7);
                            this.localizedMagnitude(sb, array15, flags, n38, locale);
                            BytecodeManager.incBytecodes(1);
                            final Object o3 = exponent2;
                            BytecodeManager.incBytecodes(2);
                            if (o3 != null) {
                                final Flags uppercase2 = Flags.UPPERCASE;
                                BytecodeManager.incBytecodes(4);
                                final boolean contains5 = flags.contains(uppercase2);
                                BytecodeManager.incBytecodes(1);
                                char c10;
                                if (contains5) {
                                    c10 = 'E';
                                    BytecodeManager.incBytecodes(2);
                                }
                                else {
                                    c10 = 'e';
                                    BytecodeManager.incBytecodes(1);
                                }
                                BytecodeManager.incBytecodes(1);
                                sb.append(c10);
                                BytecodeManager.incBytecodes(1);
                                BytecodeManager.incBytecodes(2);
                                final Flags dup2 = flags.dup();
                                final Flags group2 = Flags.GROUP;
                                BytecodeManager.incBytecodes(2);
                                final Flags remove2 = dup2.remove(group2);
                                BytecodeManager.incBytecodes(1);
                                final char c11 = exponent2[0];
                                BytecodeManager.incBytecodes(4);
                                final boolean $assertionsDisabled2 = FormatSpecifier.$assertionsDisabled;
                                BytecodeManager.incBytecodes(2);
                                if (!$assertionsDisabled2) {
                                    final char c12 = c11;
                                    final int n39 = '+';
                                    BytecodeManager.incBytecodes(3);
                                    if (c12 != n39) {
                                        final char c13 = c11;
                                        final int n40 = '-';
                                        BytecodeManager.incBytecodes(3);
                                        if (c13 != n40) {
                                            BytecodeManager.incBytecodes(3);
                                            final AssertionError assertionError2 = new AssertionError();
                                            BytecodeManager.incBytecodes(1);
                                            throw assertionError2;
                                        }
                                    }
                                }
                                final char c14 = c11;
                                BytecodeManager.incBytecodes(3);
                                sb.append(c14);
                                BytecodeManager.incBytecodes(1);
                                final char[] array16 = new char[exponent2.length - 1];
                                BytecodeManager.incBytecodes(5);
                                final Object o4 = exponent2;
                                final int n41 = 1;
                                final char[] array17 = array16;
                                final int n42 = 0;
                                final int n43 = exponent2.length - 1;
                                BytecodeManager.incBytecodes(9);
                                System.arraycopy(o4, n41, array17, n42, n43);
                                final StringBuilder sb3 = null;
                                final char[] array18 = array16;
                                final Flags flags3 = remove2;
                                final int n44 = -1;
                                BytecodeManager.incBytecodes(8);
                                final StringBuilder localizedMagnitude2 = this.localizedMagnitude(sb3, array18, flags3, n44, locale);
                                BytecodeManager.incBytecodes(1);
                                sb.append((CharSequence)localizedMagnitude2);
                                BytecodeManager.incBytecodes(1);
                            }
                            BytecodeManager.incBytecodes(1);
                        }
                        else {
                            final char c15 = 'a';
                            BytecodeManager.incBytecodes(3);
                            if (c == c15) {
                                int n45 = n2;
                                BytecodeManager.incBytecodes(2);
                                final int n46 = -1;
                                BytecodeManager.incBytecodes(3);
                                if (n2 == n46) {
                                    n45 = 0;
                                    BytecodeManager.incBytecodes(3);
                                }
                                else {
                                    BytecodeManager.incBytecodes(2);
                                    if (n2 == 0) {
                                        n45 = 1;
                                        BytecodeManager.incBytecodes(2);
                                    }
                                }
                                final int n47 = n45;
                                BytecodeManager.incBytecodes(4);
                                final String hexDouble = this.hexDouble(n, n47);
                                BytecodeManager.incBytecodes(1);
                                final Flags uppercase3 = Flags.UPPERCASE;
                                BytecodeManager.incBytecodes(3);
                                final boolean contains6 = flags.contains(uppercase3);
                                BytecodeManager.incBytecodes(1);
                                final boolean b2 = contains6;
                                BytecodeManager.incBytecodes(3);
                                String str;
                                if (b2) {
                                    str = "0X";
                                    BytecodeManager.incBytecodes(2);
                                }
                                else {
                                    str = "0x";
                                    BytecodeManager.incBytecodes(1);
                                }
                                BytecodeManager.incBytecodes(1);
                                sb.append(str);
                                BytecodeManager.incBytecodes(1);
                                final Flags zero_PAD = Flags.ZERO_PAD;
                                BytecodeManager.incBytecodes(3);
                                final boolean contains7 = flags.contains(zero_PAD);
                                BytecodeManager.incBytecodes(1);
                                if (contains7) {
                                    int n48 = 0;
                                    BytecodeManager.incBytecodes(2);
                                    while (true) {
                                        final int n49 = n48;
                                        final int width6 = this.width;
                                        final String s = hexDouble;
                                        BytecodeManager.incBytecodes(5);
                                        final int n50 = width6 - s.length() - 2;
                                        BytecodeManager.incBytecodes(4);
                                        if (n49 >= n50) {
                                            break;
                                        }
                                        final char c16 = '0';
                                        BytecodeManager.incBytecodes(3);
                                        sb.append(c16);
                                        BytecodeManager.incBytecodes(1);
                                        ++n48;
                                        BytecodeManager.incBytecodes(2);
                                    }
                                }
                                final String s2 = hexDouble;
                                final int ch = 112;
                                BytecodeManager.incBytecodes(3);
                                final int index = s2.indexOf(ch);
                                BytecodeManager.incBytecodes(1);
                                final String s3 = hexDouble;
                                final int beginIndex = 0;
                                final int endIndex = index;
                                BytecodeManager.incBytecodes(4);
                                final String substring = s3.substring(beginIndex, endIndex);
                                BytecodeManager.incBytecodes(1);
                                char[] array19 = substring.toCharArray();
                                BytecodeManager.incBytecodes(1);
                                final boolean b3 = contains6;
                                BytecodeManager.incBytecodes(2);
                                if (b3) {
                                    final char[] value4 = array19;
                                    BytecodeManager.incBytecodes(4);
                                    final String s4 = new String(value4);
                                    BytecodeManager.incBytecodes(1);
                                    final String s5 = s4;
                                    final Locale us = Locale.US;
                                    BytecodeManager.incBytecodes(3);
                                    final String upperCase = s5.toUpperCase(us);
                                    BytecodeManager.incBytecodes(1);
                                    final String s6 = upperCase;
                                    BytecodeManager.incBytecodes(2);
                                    array19 = s6.toCharArray();
                                    BytecodeManager.incBytecodes(1);
                                }
                                final int n51 = n45;
                                BytecodeManager.incBytecodes(3);
                                char[] addZeros;
                                if (n51 != 0) {
                                    final char[] array20 = array19;
                                    final int n52 = n45;
                                    BytecodeManager.incBytecodes(4);
                                    addZeros = this.addZeros(array20, n52);
                                    BytecodeManager.incBytecodes(1);
                                }
                                else {
                                    addZeros = array19;
                                    BytecodeManager.incBytecodes(1);
                                }
                                BytecodeManager.incBytecodes(1);
                                sb.append(addZeros);
                                BytecodeManager.incBytecodes(1);
                                final boolean b4 = contains6;
                                BytecodeManager.incBytecodes(3);
                                char c17;
                                if (b4) {
                                    c17 = 'P';
                                    BytecodeManager.incBytecodes(2);
                                }
                                else {
                                    c17 = 'p';
                                    BytecodeManager.incBytecodes(1);
                                }
                                BytecodeManager.incBytecodes(1);
                                sb.append(c17);
                                BytecodeManager.incBytecodes(1);
                                final String s7 = hexDouble;
                                final int beginIndex2 = index + 1;
                                BytecodeManager.incBytecodes(6);
                                final String substring2 = s7.substring(beginIndex2);
                                BytecodeManager.incBytecodes(1);
                                sb.append(substring2);
                                BytecodeManager.incBytecodes(1);
                            }
                        }
                    }
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private char[] addZeros(final char[] array, final int n) {
            try {
                int n2 = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n3 = n2;
                    final int length = array.length;
                    BytecodeManager.incBytecodes(4);
                    if (n3 >= length) {
                        break;
                    }
                    final char c = array[n2];
                    final int n4 = '.';
                    BytecodeManager.incBytecodes(5);
                    if (c == n4) {
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    ++n2;
                    BytecodeManager.incBytecodes(2);
                }
                boolean b = false;
                BytecodeManager.incBytecodes(2);
                final int n5 = n2;
                final int length2 = array.length;
                BytecodeManager.incBytecodes(4);
                if (n5 == length2) {
                    b = true;
                    BytecodeManager.incBytecodes(2);
                }
                final int n6 = array.length - n2;
                final boolean b2 = b;
                BytecodeManager.incBytecodes(6);
                int n7;
                if (b2) {
                    n7 = 0;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    n7 = 1;
                    BytecodeManager.incBytecodes(1);
                }
                final int n8 = n6 - n7;
                BytecodeManager.incBytecodes(2);
                final boolean $assertionsDisabled = FormatSpecifier.$assertionsDisabled;
                BytecodeManager.incBytecodes(2);
                if (!$assertionsDisabled) {
                    final int n9 = n8;
                    BytecodeManager.incBytecodes(3);
                    if (n9 > n) {
                        BytecodeManager.incBytecodes(3);
                        final AssertionError assertionError = new AssertionError();
                        BytecodeManager.incBytecodes(1);
                        throw assertionError;
                    }
                }
                final int n10 = n8;
                BytecodeManager.incBytecodes(3);
                if (n10 == n) {
                    BytecodeManager.incBytecodes(2);
                    return array;
                }
                final int n11 = array.length + n - n8;
                final boolean b3 = b;
                BytecodeManager.incBytecodes(8);
                int n12;
                if (b3) {
                    n12 = 1;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    n12 = 0;
                    BytecodeManager.incBytecodes(1);
                }
                final char[] array2 = new char[n11 + n12];
                BytecodeManager.incBytecodes(2);
                final int n13 = 0;
                final char[] array3 = array2;
                final int n14 = 0;
                final int length3 = array.length;
                BytecodeManager.incBytecodes(7);
                System.arraycopy(array, n13, array3, n14, length3);
                int length4 = array.length;
                BytecodeManager.incBytecodes(3);
                final boolean b4 = b;
                BytecodeManager.incBytecodes(2);
                if (b4) {
                    array2[array.length] = '.';
                    BytecodeManager.incBytecodes(5);
                    ++length4;
                    BytecodeManager.incBytecodes(1);
                }
                int n15 = length4;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n16 = n15;
                    final int length5 = array2.length;
                    BytecodeManager.incBytecodes(4);
                    if (n16 >= length5) {
                        break;
                    }
                    array2[n15] = '0';
                    BytecodeManager.incBytecodes(4);
                    ++n15;
                    BytecodeManager.incBytecodes(2);
                }
                final char[] array4 = array2;
                BytecodeManager.incBytecodes(2);
                return array4;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private String hexDouble(double n, final int n2) {
            try {
                final double d = n;
                BytecodeManager.incBytecodes(2);
                final boolean finite = Double.isFinite(d);
                BytecodeManager.incBytecodes(1);
                if (finite) {
                    final double n3 = dcmpl(n, 0.0);
                    BytecodeManager.incBytecodes(4);
                    if (n3 != 0) {
                        BytecodeManager.incBytecodes(2);
                        if (n2 != 0) {
                            final int n4 = 13;
                            BytecodeManager.incBytecodes(3);
                            if (n2 < n4) {
                                final boolean $assertionsDisabled = FormatSpecifier.$assertionsDisabled;
                                BytecodeManager.incBytecodes(2);
                                Label_0122: {
                                    if (!$assertionsDisabled) {
                                        final int n5 = 1;
                                        BytecodeManager.incBytecodes(3);
                                        if (n2 >= n5) {
                                            final int n6 = 12;
                                            BytecodeManager.incBytecodes(3);
                                            if (n2 <= n6) {
                                                break Label_0122;
                                            }
                                        }
                                        BytecodeManager.incBytecodes(3);
                                        final AssertionError assertionError = new AssertionError();
                                        BytecodeManager.incBytecodes(1);
                                        throw assertionError;
                                    }
                                }
                                final double d2 = n;
                                BytecodeManager.incBytecodes(2);
                                final int exponent = Math.getExponent(d2);
                                BytecodeManager.incBytecodes(1);
                                final int n7 = exponent;
                                final int n8 = -1023;
                                BytecodeManager.incBytecodes(3);
                                int n9;
                                if (n7 == n8) {
                                    n9 = 1;
                                    BytecodeManager.incBytecodes(2);
                                }
                                else {
                                    n9 = 0;
                                    BytecodeManager.incBytecodes(1);
                                }
                                final int n10 = n9;
                                BytecodeManager.incBytecodes(1);
                                final int n11 = n10;
                                BytecodeManager.incBytecodes(2);
                                Label_0297: {
                                    if (n11 != 0) {
                                        final double d3 = 1.0;
                                        final int scaleFactor = 54;
                                        BytecodeManager.incBytecodes(3);
                                        final double scalb = Math.scalb(d3, scaleFactor);
                                        BytecodeManager.incBytecodes(1);
                                        Formatter.access$202(scalb);
                                        BytecodeManager.incBytecodes(1);
                                        final double n12 = n;
                                        BytecodeManager.incBytecodes(2);
                                        n = n12 * Formatter.access$200();
                                        BytecodeManager.incBytecodes(2);
                                        final double d4 = n;
                                        BytecodeManager.incBytecodes(2);
                                        final int exponent2 = Math.getExponent(d4);
                                        BytecodeManager.incBytecodes(1);
                                        final boolean $assertionsDisabled2 = FormatSpecifier.$assertionsDisabled;
                                        BytecodeManager.incBytecodes(2);
                                        if (!$assertionsDisabled2) {
                                            final int n13 = exponent2;
                                            final int n14 = -1022;
                                            BytecodeManager.incBytecodes(3);
                                            if (n13 >= n14) {
                                                final int n15 = exponent2;
                                                final int n16 = 1023;
                                                BytecodeManager.incBytecodes(3);
                                                if (n15 <= n16) {
                                                    break Label_0297;
                                                }
                                            }
                                            final int detailMessage = exponent2;
                                            BytecodeManager.incBytecodes(4);
                                            final AssertionError assertionError2 = new AssertionError(detailMessage);
                                            BytecodeManager.incBytecodes(1);
                                            throw assertionError2;
                                        }
                                    }
                                }
                                final int n17 = 1 + n2 * 4;
                                BytecodeManager.incBytecodes(6);
                                final int n18 = 53 - n17;
                                BytecodeManager.incBytecodes(4);
                                final boolean $assertionsDisabled3 = FormatSpecifier.$assertionsDisabled;
                                BytecodeManager.incBytecodes(2);
                                Label_0374: {
                                    if (!$assertionsDisabled3) {
                                        final int n19 = n18;
                                        final int n20 = 1;
                                        BytecodeManager.incBytecodes(3);
                                        if (n19 >= n20) {
                                            final int n21 = n18;
                                            final int n22 = 53;
                                            BytecodeManager.incBytecodes(3);
                                            if (n21 < n22) {
                                                break Label_0374;
                                            }
                                        }
                                        BytecodeManager.incBytecodes(3);
                                        final AssertionError assertionError3 = new AssertionError();
                                        BytecodeManager.incBytecodes(1);
                                        throw assertionError3;
                                    }
                                }
                                final double value = n;
                                BytecodeManager.incBytecodes(2);
                                final long doubleToLongBits = Double.doubleToLongBits(value);
                                BytecodeManager.incBytecodes(1);
                                long n23 = (doubleToLongBits & Long.MAX_VALUE) >> n18;
                                BytecodeManager.incBytecodes(6);
                                final long n24 = doubleToLongBits & ~(-1L << n18);
                                BytecodeManager.incBytecodes(8);
                                final long n25 = lcmp(n23 & 0x1L, 0L);
                                BytecodeManager.incBytecodes(6);
                                int n26;
                                if (n25 == 0) {
                                    n26 = 1;
                                    BytecodeManager.incBytecodes(2);
                                }
                                else {
                                    n26 = 0;
                                    BytecodeManager.incBytecodes(1);
                                }
                                final int n27 = n26;
                                BytecodeManager.incBytecodes(1);
                                final long n28 = lcmp(1L << n18 - 1 & n24, 0L);
                                BytecodeManager.incBytecodes(10);
                                int n29;
                                if (n28 != 0) {
                                    n29 = 1;
                                    BytecodeManager.incBytecodes(2);
                                }
                                else {
                                    n29 = 0;
                                    BytecodeManager.incBytecodes(1);
                                }
                                final int n30 = n29;
                                BytecodeManager.incBytecodes(1);
                                final int n31 = n18;
                                final int n32 = 1;
                                BytecodeManager.incBytecodes(3);
                                int n34 = 0;
                                Label_0557: {
                                    if (n31 > n32) {
                                        final long n33 = lcmp(~(1L << n18 - 1) & n24, 0L);
                                        BytecodeManager.incBytecodes(12);
                                        if (n33 != 0) {
                                            n34 = 1;
                                            BytecodeManager.incBytecodes(2);
                                            break Label_0557;
                                        }
                                    }
                                    n34 = 0;
                                    BytecodeManager.incBytecodes(1);
                                }
                                final int n35 = n34;
                                BytecodeManager.incBytecodes(1);
                                final int n36 = n27;
                                BytecodeManager.incBytecodes(2);
                                Label_0625: {
                                    Label_0614: {
                                        if (n36 != 0) {
                                            final int n37 = n30;
                                            BytecodeManager.incBytecodes(2);
                                            if (n37 != 0) {
                                                final int n38 = n35;
                                                BytecodeManager.incBytecodes(2);
                                                if (n38 != 0) {
                                                    break Label_0614;
                                                }
                                            }
                                        }
                                        final int n39 = n27;
                                        BytecodeManager.incBytecodes(2);
                                        if (n39 != 0) {
                                            break Label_0625;
                                        }
                                        final int n40 = n30;
                                        BytecodeManager.incBytecodes(2);
                                        if (n40 == 0) {
                                            break Label_0625;
                                        }
                                    }
                                    ++n23;
                                    BytecodeManager.incBytecodes(4);
                                }
                                final long n41 = doubleToLongBits & Long.MIN_VALUE;
                                BytecodeManager.incBytecodes(4);
                                final long n42 = n41 | n23 << n18;
                                BytecodeManager.incBytecodes(6);
                                final long n43 = n42;
                                BytecodeManager.incBytecodes(2);
                                final double longBitsToDouble = Double.longBitsToDouble(n43);
                                BytecodeManager.incBytecodes(1);
                                final double v = longBitsToDouble;
                                BytecodeManager.incBytecodes(2);
                                final boolean infinite = Double.isInfinite(v);
                                BytecodeManager.incBytecodes(1);
                                if (infinite) {
                                    final String s = "1.0p1024";
                                    BytecodeManager.incBytecodes(2);
                                    return s;
                                }
                                final double d5 = longBitsToDouble;
                                BytecodeManager.incBytecodes(2);
                                final String hexString = Double.toHexString(d5);
                                final int beginIndex = 2;
                                BytecodeManager.incBytecodes(2);
                                final String substring = hexString.substring(beginIndex);
                                BytecodeManager.incBytecodes(1);
                                final int n44 = n10;
                                BytecodeManager.incBytecodes(2);
                                if (n44 == 0) {
                                    final String s2 = substring;
                                    BytecodeManager.incBytecodes(2);
                                    return s2;
                                }
                                final String s3 = substring;
                                final int ch = 112;
                                BytecodeManager.incBytecodes(3);
                                final int index = s3.indexOf(ch);
                                BytecodeManager.incBytecodes(1);
                                final int n45 = index;
                                final int n46 = -1;
                                BytecodeManager.incBytecodes(3);
                                if (n45 != n46) {
                                    final String s4 = substring;
                                    final int beginIndex2 = index + 1;
                                    BytecodeManager.incBytecodes(5);
                                    final String substring2 = s4.substring(beginIndex2);
                                    BytecodeManager.incBytecodes(1);
                                    final String s5 = substring2;
                                    BytecodeManager.incBytecodes(2);
                                    final int n47 = Integer.parseInt(s5) - 54;
                                    BytecodeManager.incBytecodes(3);
                                    BytecodeManager.incBytecodes(3);
                                    final StringBuilder sb = new StringBuilder();
                                    final String s6 = substring;
                                    final int beginIndex3 = 0;
                                    final int endIndex = index;
                                    BytecodeManager.incBytecodes(4);
                                    final String substring3 = s6.substring(beginIndex3, endIndex);
                                    BytecodeManager.incBytecodes(1);
                                    final StringBuilder append = sb.append(substring3);
                                    final String str = "p";
                                    BytecodeManager.incBytecodes(2);
                                    final StringBuilder append2 = append.append(str);
                                    final int i = n47;
                                    BytecodeManager.incBytecodes(1);
                                    BytecodeManager.incBytecodes(1);
                                    final String string = Integer.toString(i);
                                    BytecodeManager.incBytecodes(1);
                                    final StringBuilder append3 = append2.append(string);
                                    BytecodeManager.incBytecodes(1);
                                    final String string2 = append3.toString();
                                    BytecodeManager.incBytecodes(1);
                                    return string2;
                                }
                                final boolean $assertionsDisabled4 = FormatSpecifier.$assertionsDisabled;
                                BytecodeManager.incBytecodes(2);
                                if (!$assertionsDisabled4) {
                                    BytecodeManager.incBytecodes(3);
                                    final AssertionError assertionError4 = new AssertionError();
                                    BytecodeManager.incBytecodes(1);
                                    throw assertionError4;
                                }
                                final String s7 = null;
                                BytecodeManager.incBytecodes(2);
                                return s7;
                            }
                        }
                    }
                }
                final double d6 = n;
                BytecodeManager.incBytecodes(2);
                final String hexString2 = Double.toHexString(d6);
                final int beginIndex4 = 2;
                BytecodeManager.incBytecodes(2);
                final String substring4 = hexString2.substring(beginIndex4);
                BytecodeManager.incBytecodes(1);
                return substring4;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private void print(final BigDecimal bigDecimal, final Locale locale) throws IOException {
            try {
                final char c = this.c;
                final int n = 'a';
                BytecodeManager.incBytecodes(4);
                if (c == n) {
                    final char c2 = this.c;
                    BytecodeManager.incBytecodes(5);
                    this.failConversion(c2, bigDecimal);
                }
                BytecodeManager.incBytecodes(3);
                final StringBuilder sb = new StringBuilder();
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(2);
                final int signum = bigDecimal.signum();
                final int n2 = -1;
                BytecodeManager.incBytecodes(2);
                int n3;
                if (signum == n2) {
                    n3 = 1;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    n3 = 0;
                    BytecodeManager.incBytecodes(1);
                }
                final boolean b = n3 != 0;
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(2);
                final BigDecimal abs = bigDecimal.abs();
                BytecodeManager.incBytecodes(1);
                final StringBuilder sb2 = sb;
                final boolean b2 = b;
                BytecodeManager.incBytecodes(4);
                this.leadingSign(sb2, b2);
                BytecodeManager.incBytecodes(1);
                final StringBuilder sb3 = sb;
                final BigDecimal bigDecimal2 = abs;
                final Flags f = this.f;
                final char c3 = this.c;
                final int precision = this.precision;
                final boolean b3 = b;
                BytecodeManager.incBytecodes(12);
                this.print(sb3, bigDecimal2, locale, f, c3, precision, b3);
                final StringBuilder sb4 = sb;
                final boolean b4 = b;
                BytecodeManager.incBytecodes(4);
                this.trailingSign(sb4, b4);
                BytecodeManager.incBytecodes(1);
                final Formatter this$0 = Formatter.this;
                BytecodeManager.incBytecodes(3);
                final Appendable access$000 = Formatter.access$000(this$0);
                final StringBuilder sb5 = sb;
                BytecodeManager.incBytecodes(3);
                final String string = sb5.toString();
                BytecodeManager.incBytecodes(1);
                final String justify = this.justify(string);
                BytecodeManager.incBytecodes(1);
                access$000.append(justify);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private void print(final StringBuilder sb, BigDecimal setScale, final Locale locale, final Flags flags, final char c, final int n, final boolean b) throws IOException {
            try {
                final char c2 = 'e';
                BytecodeManager.incBytecodes(3);
                if (c == c2) {
                    final int n2 = -1;
                    BytecodeManager.incBytecodes(3);
                    int n3;
                    if (n == n2) {
                        n3 = 6;
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        n3 = n;
                        BytecodeManager.incBytecodes(1);
                    }
                    final int n4 = n3;
                    BytecodeManager.incBytecodes(1);
                    final BigDecimal bigDecimal = setScale;
                    BytecodeManager.incBytecodes(2);
                    final int scale = bigDecimal.scale();
                    BytecodeManager.incBytecodes(1);
                    final BigDecimal bigDecimal2 = setScale;
                    BytecodeManager.incBytecodes(2);
                    final int precision = bigDecimal2.precision();
                    BytecodeManager.incBytecodes(1);
                    int n5 = 0;
                    BytecodeManager.incBytecodes(2);
                    final int n6 = n4;
                    final int n7 = precision - 1;
                    BytecodeManager.incBytecodes(5);
                    int n8;
                    if (n6 > n7) {
                        n8 = precision;
                        BytecodeManager.incBytecodes(2);
                        n5 = n4 - (precision - 1);
                        BytecodeManager.incBytecodes(7);
                    }
                    else {
                        n8 = n4 + 1;
                        BytecodeManager.incBytecodes(4);
                    }
                    final int n9 = n8;
                    BytecodeManager.incBytecodes(4);
                    final MathContext mathContext = new MathContext(n9);
                    BytecodeManager.incBytecodes(1);
                    final BigDecimal bigDecimal3 = setScale;
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(1);
                    final BigInteger unscaledValue = bigDecimal3.unscaledValue();
                    final int n10 = scale;
                    final MathContext mathContext2 = mathContext;
                    BytecodeManager.incBytecodes(3);
                    final BigDecimal bigDecimal4 = new BigDecimal(unscaledValue, n10, mathContext2);
                    BytecodeManager.incBytecodes(1);
                    final BigDecimal bigDecimal5 = bigDecimal4;
                    BytecodeManager.incBytecodes(4);
                    BytecodeManager.incBytecodes(1);
                    final BigInteger unscaledValue2 = bigDecimal5.unscaledValue();
                    final BigDecimal bigDecimal6 = bigDecimal4;
                    BytecodeManager.incBytecodes(2);
                    final int scale2 = bigDecimal6.scale();
                    final BigDecimalLayoutForm scientific = BigDecimalLayoutForm.SCIENTIFIC;
                    BytecodeManager.incBytecodes(2);
                    final BigDecimalLayout bigDecimalLayout = new BigDecimalLayout(unscaledValue2, scale2, scientific);
                    BytecodeManager.incBytecodes(1);
                    final BigDecimalLayout bigDecimalLayout2 = bigDecimalLayout;
                    BytecodeManager.incBytecodes(2);
                    char[] array = bigDecimalLayout2.mantissa();
                    BytecodeManager.incBytecodes(1);
                    final int n11 = precision;
                    final int n12 = 1;
                    BytecodeManager.incBytecodes(3);
                    Label_0345: {
                        if (n11 != n12) {
                            final BigDecimalLayout bigDecimalLayout3 = bigDecimalLayout;
                            BytecodeManager.incBytecodes(2);
                            final boolean hasDot = bigDecimalLayout3.hasDot();
                            BytecodeManager.incBytecodes(1);
                            if (hasDot) {
                                break Label_0345;
                            }
                        }
                        final int n13 = n5;
                        BytecodeManager.incBytecodes(2);
                        if (n13 <= 0) {
                            final Flags alternate = Flags.ALTERNATE;
                            BytecodeManager.incBytecodes(2);
                            BytecodeManager.incBytecodes(1);
                            final boolean contains = flags.contains(alternate);
                            BytecodeManager.incBytecodes(1);
                            if (!contains) {
                                break Label_0345;
                            }
                        }
                        final char[] array2 = array;
                        BytecodeManager.incBytecodes(3);
                        array = this.addDot(array2);
                        BytecodeManager.incBytecodes(1);
                    }
                    final char[] array3 = array;
                    final int n14 = n5;
                    BytecodeManager.incBytecodes(4);
                    final char[] trailingZeros = this.trailingZeros(array3, n14);
                    BytecodeManager.incBytecodes(1);
                    final BigDecimalLayout bigDecimalLayout4 = bigDecimalLayout;
                    BytecodeManager.incBytecodes(2);
                    final char[] exponent = bigDecimalLayout4.exponent();
                    BytecodeManager.incBytecodes(1);
                    int n15 = this.width;
                    BytecodeManager.incBytecodes(3);
                    final int width = this.width;
                    final int n16 = -1;
                    BytecodeManager.incBytecodes(4);
                    if (width != n16) {
                        final int n17 = this.width - exponent.length - 1;
                        BytecodeManager.incBytecodes(11);
                        n15 = this.adjustWidth(n17, flags, b);
                        BytecodeManager.incBytecodes(1);
                    }
                    final char[] array4 = trailingZeros;
                    final int n18 = n15;
                    BytecodeManager.incBytecodes(7);
                    this.localizedMagnitude(sb, array4, flags, n18, locale);
                    BytecodeManager.incBytecodes(1);
                    final Flags uppercase = Flags.UPPERCASE;
                    BytecodeManager.incBytecodes(4);
                    final boolean contains2 = flags.contains(uppercase);
                    BytecodeManager.incBytecodes(1);
                    char c3;
                    if (contains2) {
                        c3 = 'E';
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        c3 = 'e';
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(1);
                    sb.append(c3);
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(2);
                    final Flags dup = flags.dup();
                    final Flags group = Flags.GROUP;
                    BytecodeManager.incBytecodes(2);
                    final Flags remove = dup.remove(group);
                    BytecodeManager.incBytecodes(1);
                    final char c4 = exponent[0];
                    BytecodeManager.incBytecodes(4);
                    final boolean $assertionsDisabled = FormatSpecifier.$assertionsDisabled;
                    BytecodeManager.incBytecodes(2);
                    if (!$assertionsDisabled) {
                        final char c5 = c4;
                        final int n19 = '+';
                        BytecodeManager.incBytecodes(3);
                        if (c5 != n19) {
                            final char c6 = c4;
                            final int n20 = '-';
                            BytecodeManager.incBytecodes(3);
                            if (c6 != n20) {
                                BytecodeManager.incBytecodes(3);
                                final AssertionError assertionError = new AssertionError();
                                BytecodeManager.incBytecodes(1);
                                throw assertionError;
                            }
                        }
                    }
                    final char c7 = exponent[0];
                    BytecodeManager.incBytecodes(5);
                    sb.append(c7);
                    BytecodeManager.incBytecodes(1);
                    final char[] array5 = new char[exponent.length - 1];
                    BytecodeManager.incBytecodes(5);
                    final char[] array6 = exponent;
                    final int n21 = 1;
                    final char[] array7 = array5;
                    final int n22 = 0;
                    final int n23 = exponent.length - 1;
                    BytecodeManager.incBytecodes(9);
                    System.arraycopy(array6, n21, array7, n22, n23);
                    final StringBuilder sb2 = null;
                    final char[] array8 = array5;
                    final Flags flags2 = remove;
                    final int n24 = -1;
                    BytecodeManager.incBytecodes(8);
                    final StringBuilder localizedMagnitude = this.localizedMagnitude(sb2, array8, flags2, n24, locale);
                    BytecodeManager.incBytecodes(1);
                    sb.append((CharSequence)localizedMagnitude);
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    final char c8 = 'f';
                    BytecodeManager.incBytecodes(3);
                    if (c == c8) {
                        final int n25 = -1;
                        BytecodeManager.incBytecodes(3);
                        int n26;
                        if (n == n25) {
                            n26 = 6;
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            n26 = n;
                            BytecodeManager.incBytecodes(1);
                        }
                        final int n27 = n26;
                        BytecodeManager.incBytecodes(1);
                        final BigDecimal bigDecimal7 = setScale;
                        BytecodeManager.incBytecodes(2);
                        final int scale3 = bigDecimal7.scale();
                        BytecodeManager.incBytecodes(1);
                        final int n28 = scale3;
                        final int n29 = n27;
                        BytecodeManager.incBytecodes(3);
                        if (n28 > n29) {
                            final BigDecimal bigDecimal8 = setScale;
                            BytecodeManager.incBytecodes(2);
                            final int precision2 = bigDecimal8.precision();
                            BytecodeManager.incBytecodes(1);
                            final int n30 = precision2;
                            final int n31 = scale3;
                            BytecodeManager.incBytecodes(3);
                            if (n30 <= n31) {
                                final BigDecimal bigDecimal9 = setScale;
                                final int n32 = n27;
                                final RoundingMode half_UP = RoundingMode.HALF_UP;
                                BytecodeManager.incBytecodes(4);
                                setScale = bigDecimal9.setScale(n32, half_UP);
                                BytecodeManager.incBytecodes(2);
                            }
                            else {
                                final int n33 = precision2 - (scale3 - n27);
                                BytecodeManager.incBytecodes(6);
                                final BigDecimal bigDecimal10 = setScale;
                                BytecodeManager.incBytecodes(4);
                                final BigInteger unscaledValue3 = bigDecimal10.unscaledValue();
                                final int n34 = scale3;
                                final int n35 = n33;
                                BytecodeManager.incBytecodes(5);
                                final MathContext mathContext3 = new MathContext(n35);
                                BytecodeManager.incBytecodes(1);
                                setScale = new BigDecimal(unscaledValue3, n34, mathContext3);
                                BytecodeManager.incBytecodes(1);
                            }
                        }
                        final BigDecimal bigDecimal11 = setScale;
                        BytecodeManager.incBytecodes(4);
                        BytecodeManager.incBytecodes(1);
                        final BigInteger unscaledValue4 = bigDecimal11.unscaledValue();
                        final BigDecimal bigDecimal12 = setScale;
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                        final int scale4 = bigDecimal12.scale();
                        final BigDecimalLayoutForm decimal_FLOAT = BigDecimalLayoutForm.DECIMAL_FLOAT;
                        BytecodeManager.incBytecodes(2);
                        final BigDecimalLayout bigDecimalLayout5 = new BigDecimalLayout(unscaledValue4, scale4, decimal_FLOAT);
                        BytecodeManager.incBytecodes(1);
                        final BigDecimalLayout bigDecimalLayout6 = bigDecimalLayout5;
                        BytecodeManager.incBytecodes(2);
                        char[] array9 = bigDecimalLayout6.mantissa();
                        BytecodeManager.incBytecodes(1);
                        final BigDecimalLayout bigDecimalLayout7 = bigDecimalLayout5;
                        BytecodeManager.incBytecodes(2);
                        final int scale5 = bigDecimalLayout7.scale();
                        final int n36 = n27;
                        BytecodeManager.incBytecodes(2);
                        int n38;
                        if (scale5 < n36) {
                            final int n37 = n27;
                            final BigDecimalLayout bigDecimalLayout8 = bigDecimalLayout5;
                            BytecodeManager.incBytecodes(3);
                            n38 = n37 - bigDecimalLayout8.scale();
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            n38 = 0;
                            BytecodeManager.incBytecodes(1);
                        }
                        final int n39 = n38;
                        BytecodeManager.incBytecodes(1);
                        final BigDecimalLayout bigDecimalLayout9 = bigDecimalLayout5;
                        BytecodeManager.incBytecodes(2);
                        final int scale6 = bigDecimalLayout9.scale();
                        BytecodeManager.incBytecodes(1);
                        Label_1081: {
                            if (scale6 == 0) {
                                final Flags alternate2 = Flags.ALTERNATE;
                                BytecodeManager.incBytecodes(3);
                                final boolean contains3 = flags.contains(alternate2);
                                BytecodeManager.incBytecodes(1);
                                if (!contains3) {
                                    final int n40 = n39;
                                    BytecodeManager.incBytecodes(2);
                                    if (n40 <= 0) {
                                        break Label_1081;
                                    }
                                }
                                final BigDecimalLayout bigDecimalLayout10 = bigDecimalLayout5;
                                BytecodeManager.incBytecodes(3);
                                final char[] mantissa = bigDecimalLayout10.mantissa();
                                BytecodeManager.incBytecodes(1);
                                array9 = this.addDot(mantissa);
                                BytecodeManager.incBytecodes(1);
                            }
                        }
                        final char[] array10 = array9;
                        final int n41 = n39;
                        BytecodeManager.incBytecodes(4);
                        final char[] trailingZeros2 = this.trailingZeros(array10, n41);
                        BytecodeManager.incBytecodes(1);
                        final char[] array11 = trailingZeros2;
                        final int width2 = this.width;
                        BytecodeManager.incBytecodes(10);
                        final int adjustWidth = this.adjustWidth(width2, flags, b);
                        BytecodeManager.incBytecodes(2);
                        this.localizedMagnitude(sb, array11, flags, adjustWidth, locale);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        final char c9 = 'g';
                        BytecodeManager.incBytecodes(3);
                        if (c == c9) {
                            int n42 = n;
                            BytecodeManager.incBytecodes(2);
                            final int n43 = -1;
                            BytecodeManager.incBytecodes(3);
                            if (n == n43) {
                                n42 = 6;
                                BytecodeManager.incBytecodes(3);
                            }
                            else {
                                BytecodeManager.incBytecodes(2);
                                if (n == 0) {
                                    n42 = 1;
                                    BytecodeManager.incBytecodes(2);
                                }
                            }
                            final long n44 = 1L;
                            final int n45 = 4;
                            BytecodeManager.incBytecodes(3);
                            final BigDecimal value = BigDecimal.valueOf(n44, n45);
                            BytecodeManager.incBytecodes(1);
                            final long n46 = 1L;
                            final int n47 = -n42;
                            BytecodeManager.incBytecodes(4);
                            final BigDecimal value2 = BigDecimal.valueOf(n46, n47);
                            BytecodeManager.incBytecodes(1);
                            final BigDecimal bigDecimal13 = setScale;
                            final BigDecimal zero = BigDecimal.ZERO;
                            BytecodeManager.incBytecodes(3);
                            final boolean equals = bigDecimal13.equals(zero);
                            BytecodeManager.incBytecodes(1);
                            Label_1433: {
                                Label_1316: {
                                    if (!equals) {
                                        final BigDecimal bigDecimal14 = setScale;
                                        final BigDecimal bigDecimal15 = value;
                                        BytecodeManager.incBytecodes(2);
                                        BytecodeManager.incBytecodes(1);
                                        final int compareTo = bigDecimal14.compareTo(bigDecimal15);
                                        final int n48 = -1;
                                        BytecodeManager.incBytecodes(2);
                                        if (compareTo != n48) {
                                            final BigDecimal bigDecimal16 = setScale;
                                            final BigDecimal bigDecimal17 = value2;
                                            BytecodeManager.incBytecodes(2);
                                            BytecodeManager.incBytecodes(1);
                                            final int compareTo2 = bigDecimal16.compareTo(bigDecimal17);
                                            final int n49 = -1;
                                            BytecodeManager.incBytecodes(2);
                                            if (compareTo2 == n49) {
                                                break Label_1316;
                                            }
                                        }
                                        final BigDecimal bigDecimal18 = setScale;
                                        final char c10 = 'e';
                                        final int n50 = n42 - 1;
                                        BytecodeManager.incBytecodes(11);
                                        this.print(sb, bigDecimal18, locale, flags, c10, n50, b);
                                        break Label_1433;
                                    }
                                }
                                final BigDecimal bigDecimal19 = setScale;
                                BytecodeManager.incBytecodes(2);
                                final int n51 = -bigDecimal19.scale();
                                final BigDecimal bigDecimal20 = setScale;
                                BytecodeManager.incBytecodes(2);
                                BytecodeManager.incBytecodes(1);
                                final BigInteger unscaledValue5 = bigDecimal20.unscaledValue();
                                BytecodeManager.incBytecodes(1);
                                final String string = unscaledValue5.toString();
                                BytecodeManager.incBytecodes(1);
                                final int n52 = n51 + (string.length() - 1);
                                BytecodeManager.incBytecodes(4);
                                final int n53 = n42 - n52 - 1;
                                BytecodeManager.incBytecodes(6);
                                final BigDecimal bigDecimal21 = setScale;
                                final char c11 = 'f';
                                final int n54 = n53;
                                BytecodeManager.incBytecodes(9);
                                this.print(sb, bigDecimal21, locale, flags, c11, n54, b);
                                BytecodeManager.incBytecodes(1);
                            }
                            BytecodeManager.incBytecodes(1);
                        }
                        else {
                            final char c12 = 'a';
                            BytecodeManager.incBytecodes(3);
                            if (c == c12) {
                                final boolean $assertionsDisabled2 = FormatSpecifier.$assertionsDisabled;
                                BytecodeManager.incBytecodes(2);
                                if (!$assertionsDisabled2) {
                                    BytecodeManager.incBytecodes(3);
                                    final AssertionError assertionError2 = new AssertionError();
                                    BytecodeManager.incBytecodes(1);
                                    throw assertionError2;
                                }
                            }
                        }
                    }
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private int adjustWidth(final int n, final Flags flags, final boolean b) {
            try {
                int n2 = n;
                BytecodeManager.incBytecodes(2);
                final int n3 = n2;
                final int n4 = -1;
                BytecodeManager.incBytecodes(3);
                if (n3 != n4) {
                    BytecodeManager.incBytecodes(2);
                    if (b) {
                        final Flags parentheses = Flags.PARENTHESES;
                        BytecodeManager.incBytecodes(3);
                        final boolean contains = flags.contains(parentheses);
                        BytecodeManager.incBytecodes(1);
                        if (contains) {
                            --n2;
                            BytecodeManager.incBytecodes(1);
                        }
                    }
                }
                final int n5 = n2;
                BytecodeManager.incBytecodes(2);
                return n5;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private char[] addDot(final char[] array) {
            try {
                BytecodeManager.incBytecodes(2);
                final char[] array2 = new char[array.length + 1];
                BytecodeManager.incBytecodes(5);
                final int n = 0;
                final char[] array3 = array2;
                final int n2 = 0;
                final int length = array.length;
                BytecodeManager.incBytecodes(7);
                System.arraycopy(array, n, array3, n2, length);
                array2[array2.length - 1] = '.';
                BytecodeManager.incBytecodes(7);
                final char[] array4 = array2;
                BytecodeManager.incBytecodes(2);
                return array4;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private char[] trailingZeros(final char[] array, final int n) {
            try {
                char[] array2 = array;
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(2);
                if (n > 0) {
                    array2 = new char[array.length + n];
                    BytecodeManager.incBytecodes(5);
                    final int n2 = 0;
                    final char[] array3 = array2;
                    final int n3 = 0;
                    final int length = array.length;
                    BytecodeManager.incBytecodes(7);
                    System.arraycopy(array, n2, array3, n3, length);
                    int length2 = array.length;
                    BytecodeManager.incBytecodes(3);
                    while (true) {
                        final int n4 = length2;
                        final int length3 = array2.length;
                        BytecodeManager.incBytecodes(4);
                        if (n4 >= length3) {
                            break;
                        }
                        array2[length2] = '0';
                        BytecodeManager.incBytecodes(4);
                        ++length2;
                        BytecodeManager.incBytecodes(2);
                    }
                }
                final char[] array4 = array2;
                BytecodeManager.incBytecodes(2);
                return array4;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private void print(final Calendar calendar, final char c, final Locale locale) throws IOException {
            try {
                BytecodeManager.incBytecodes(3);
                final StringBuilder sb = new StringBuilder();
                BytecodeManager.incBytecodes(1);
                final StringBuilder sb2 = sb;
                BytecodeManager.incBytecodes(6);
                this.print(sb2, calendar, c, locale);
                BytecodeManager.incBytecodes(1);
                final StringBuilder sb3 = sb;
                BytecodeManager.incBytecodes(3);
                final String string = sb3.toString();
                BytecodeManager.incBytecodes(1);
                String s = this.justify(string);
                BytecodeManager.incBytecodes(1);
                final Flags f = this.f;
                final Flags uppercase = Flags.UPPERCASE;
                BytecodeManager.incBytecodes(4);
                final boolean contains = f.contains(uppercase);
                BytecodeManager.incBytecodes(1);
                if (contains) {
                    final String s2 = s;
                    BytecodeManager.incBytecodes(2);
                    s = s2.toUpperCase();
                    BytecodeManager.incBytecodes(1);
                }
                final Formatter this$0 = Formatter.this;
                BytecodeManager.incBytecodes(3);
                final Appendable access$000 = Formatter.access$000(this$0);
                final String s3 = s;
                BytecodeManager.incBytecodes(2);
                access$000.append(s3);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private Appendable print(StringBuilder sb, final Calendar calendar, final char c, final Locale locale) throws IOException {
            try {
                final StringBuilder sb2 = sb;
                BytecodeManager.incBytecodes(2);
                if (sb2 == null) {
                    BytecodeManager.incBytecodes(3);
                    sb = new StringBuilder();
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(2);
                switch (c) {
                    case 'H':
                    case 'I':
                    case 'k':
                    case 'l': {
                        final int n = 11;
                        BytecodeManager.incBytecodes(3);
                        int value = calendar.get(n);
                        BytecodeManager.incBytecodes(1);
                        final char c2 = 'I';
                        BytecodeManager.incBytecodes(3);
                        Label_0369: {
                            if (c != c2) {
                                final char c3 = 'l';
                                BytecodeManager.incBytecodes(3);
                                if (c != c3) {
                                    break Label_0369;
                                }
                            }
                            final int n2 = value;
                            BytecodeManager.incBytecodes(2);
                            int n5 = 0;
                            Label_0362: {
                                if (n2 != 0) {
                                    final int n3 = value;
                                    final int n4 = 12;
                                    BytecodeManager.incBytecodes(3);
                                    if (n3 != n4) {
                                        n5 = value % 12;
                                        BytecodeManager.incBytecodes(3);
                                        break Label_0362;
                                    }
                                }
                                n5 = 12;
                                BytecodeManager.incBytecodes(2);
                            }
                            value = n5;
                            BytecodeManager.incBytecodes(1);
                        }
                        final char c4 = 'H';
                        BytecodeManager.incBytecodes(3);
                        Flags flags = null;
                        Label_0410: {
                            if (c != c4) {
                                final char c5 = 'I';
                                BytecodeManager.incBytecodes(3);
                                if (c != c5) {
                                    flags = Flags.NONE;
                                    BytecodeManager.incBytecodes(1);
                                    break Label_0410;
                                }
                            }
                            flags = Flags.ZERO_PAD;
                            BytecodeManager.incBytecodes(2);
                        }
                        final Flags flags2 = flags;
                        BytecodeManager.incBytecodes(1);
                        final StringBuilder sb3 = sb;
                        final StringBuilder sb4 = null;
                        final long n6 = value;
                        final Flags flags3 = flags2;
                        final int n7 = 2;
                        BytecodeManager.incBytecodes(9);
                        final StringBuilder localizedMagnitude = this.localizedMagnitude(sb4, n6, flags3, n7, locale);
                        BytecodeManager.incBytecodes(1);
                        sb3.append((CharSequence)localizedMagnitude);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    case 'M': {
                        final int n8 = 12;
                        BytecodeManager.incBytecodes(3);
                        final int value2 = calendar.get(n8);
                        BytecodeManager.incBytecodes(1);
                        final Flags zero_PAD = Flags.ZERO_PAD;
                        BytecodeManager.incBytecodes(2);
                        final StringBuilder sb5 = sb;
                        final StringBuilder sb6 = null;
                        final long n9 = value2;
                        final Flags flags4 = zero_PAD;
                        final int n10 = 2;
                        BytecodeManager.incBytecodes(9);
                        final StringBuilder localizedMagnitude2 = this.localizedMagnitude(sb6, n9, flags4, n10, locale);
                        BytecodeManager.incBytecodes(1);
                        sb5.append((CharSequence)localizedMagnitude2);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    case 'N': {
                        final int n11 = 14;
                        BytecodeManager.incBytecodes(3);
                        final int n12 = calendar.get(n11) * 1000000;
                        BytecodeManager.incBytecodes(3);
                        final Flags zero_PAD2 = Flags.ZERO_PAD;
                        BytecodeManager.incBytecodes(2);
                        final StringBuilder sb7 = sb;
                        final StringBuilder sb8 = null;
                        final long n13 = n12;
                        final Flags flags5 = zero_PAD2;
                        final int n14 = 9;
                        BytecodeManager.incBytecodes(9);
                        final StringBuilder localizedMagnitude3 = this.localizedMagnitude(sb8, n13, flags5, n14, locale);
                        BytecodeManager.incBytecodes(1);
                        sb7.append((CharSequence)localizedMagnitude3);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    case 'L': {
                        final int n15 = 14;
                        BytecodeManager.incBytecodes(3);
                        final int value3 = calendar.get(n15);
                        BytecodeManager.incBytecodes(1);
                        final Flags zero_PAD3 = Flags.ZERO_PAD;
                        BytecodeManager.incBytecodes(2);
                        final StringBuilder sb9 = sb;
                        final StringBuilder sb10 = null;
                        final long n16 = value3;
                        final Flags flags6 = zero_PAD3;
                        final int n17 = 3;
                        BytecodeManager.incBytecodes(9);
                        final StringBuilder localizedMagnitude4 = this.localizedMagnitude(sb10, n16, flags6, n17, locale);
                        BytecodeManager.incBytecodes(1);
                        sb9.append((CharSequence)localizedMagnitude4);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    case 'Q': {
                        BytecodeManager.incBytecodes(2);
                        final long timeInMillis = calendar.getTimeInMillis();
                        BytecodeManager.incBytecodes(1);
                        final Flags none = Flags.NONE;
                        BytecodeManager.incBytecodes(2);
                        final StringBuilder sb11 = sb;
                        final StringBuilder sb12 = null;
                        final long n18 = timeInMillis;
                        final Flags flags7 = none;
                        final int width = this.width;
                        BytecodeManager.incBytecodes(9);
                        final StringBuilder localizedMagnitude5 = this.localizedMagnitude(sb12, n18, flags7, width, locale);
                        BytecodeManager.incBytecodes(1);
                        sb11.append((CharSequence)localizedMagnitude5);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    case 'p': {
                        String[] amPmStrings = { "AM", "PM" };
                        BytecodeManager.incBytecodes(10);
                        BytecodeManager.incBytecodes(2);
                        if (locale != null) {
                            final Locale us = Locale.US;
                            BytecodeManager.incBytecodes(3);
                            if (locale != us) {
                                BytecodeManager.incBytecodes(2);
                                final DateFormatSymbols instance = DateFormatSymbols.getInstance(locale);
                                BytecodeManager.incBytecodes(1);
                                final DateFormatSymbols dateFormatSymbols = instance;
                                BytecodeManager.incBytecodes(2);
                                amPmStrings = dateFormatSymbols.getAmPmStrings();
                                BytecodeManager.incBytecodes(1);
                            }
                        }
                        final String[] array = amPmStrings;
                        final int n19 = 9;
                        BytecodeManager.incBytecodes(4);
                        final String s = array[calendar.get(n19)];
                        BytecodeManager.incBytecodes(2);
                        final StringBuilder sb13 = sb;
                        final String s2 = s;
                        BytecodeManager.incBytecodes(4);
                        Locale us2;
                        if (locale != null) {
                            us2 = locale;
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            us2 = Locale.US;
                            BytecodeManager.incBytecodes(1);
                        }
                        BytecodeManager.incBytecodes(1);
                        final String lowerCase = s2.toLowerCase(us2);
                        BytecodeManager.incBytecodes(1);
                        sb13.append(lowerCase);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    case 's': {
                        BytecodeManager.incBytecodes(2);
                        final long n20 = calendar.getTimeInMillis() / 1000L;
                        BytecodeManager.incBytecodes(3);
                        final Flags none2 = Flags.NONE;
                        BytecodeManager.incBytecodes(2);
                        final StringBuilder sb14 = sb;
                        final StringBuilder sb15 = null;
                        final long n21 = n20;
                        final Flags flags8 = none2;
                        final int width2 = this.width;
                        BytecodeManager.incBytecodes(9);
                        final StringBuilder localizedMagnitude6 = this.localizedMagnitude(sb15, n21, flags8, width2, locale);
                        BytecodeManager.incBytecodes(1);
                        sb14.append((CharSequence)localizedMagnitude6);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    case 'S': {
                        final int n22 = 13;
                        BytecodeManager.incBytecodes(3);
                        final int value4 = calendar.get(n22);
                        BytecodeManager.incBytecodes(1);
                        final Flags zero_PAD4 = Flags.ZERO_PAD;
                        BytecodeManager.incBytecodes(2);
                        final StringBuilder sb16 = sb;
                        final StringBuilder sb17 = null;
                        final long n23 = value4;
                        final Flags flags9 = zero_PAD4;
                        final int n24 = 2;
                        BytecodeManager.incBytecodes(9);
                        final StringBuilder localizedMagnitude7 = this.localizedMagnitude(sb17, n23, flags9, n24, locale);
                        BytecodeManager.incBytecodes(1);
                        sb16.append((CharSequence)localizedMagnitude7);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    case 'z': {
                        final int n25 = 15;
                        BytecodeManager.incBytecodes(3);
                        final int value5 = calendar.get(n25);
                        final int n26 = 16;
                        BytecodeManager.incBytecodes(3);
                        int n27 = value5 + calendar.get(n26);
                        BytecodeManager.incBytecodes(2);
                        final int n28 = n27;
                        BytecodeManager.incBytecodes(2);
                        int n29;
                        if (n28 < 0) {
                            n29 = 1;
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            n29 = 0;
                            BytecodeManager.incBytecodes(1);
                        }
                        final int n30 = n29;
                        BytecodeManager.incBytecodes(1);
                        final StringBuilder sb18 = sb;
                        final int n31 = n30;
                        BytecodeManager.incBytecodes(3);
                        char c6;
                        if (n31 != 0) {
                            c6 = '-';
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            c6 = '+';
                            BytecodeManager.incBytecodes(1);
                        }
                        BytecodeManager.incBytecodes(1);
                        sb18.append(c6);
                        BytecodeManager.incBytecodes(1);
                        final int n32 = n30;
                        BytecodeManager.incBytecodes(2);
                        if (n32 != 0) {
                            n27 = -n27;
                            BytecodeManager.incBytecodes(3);
                        }
                        final int n33 = n27 / 60000;
                        BytecodeManager.incBytecodes(4);
                        final int n34 = n33 / 60 * 100 + n33 % 60;
                        BytecodeManager.incBytecodes(10);
                        final Flags zero_PAD5 = Flags.ZERO_PAD;
                        BytecodeManager.incBytecodes(2);
                        final StringBuilder sb19 = sb;
                        final StringBuilder sb20 = null;
                        final long n35 = n34;
                        final Flags flags10 = zero_PAD5;
                        final int n36 = 4;
                        BytecodeManager.incBytecodes(9);
                        final StringBuilder localizedMagnitude8 = this.localizedMagnitude(sb20, n35, flags10, n36, locale);
                        BytecodeManager.incBytecodes(1);
                        sb19.append((CharSequence)localizedMagnitude8);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    case 'Z': {
                        BytecodeManager.incBytecodes(2);
                        final TimeZone timeZone = calendar.getTimeZone();
                        BytecodeManager.incBytecodes(1);
                        final StringBuilder sb21 = sb;
                        final TimeZone timeZone2 = timeZone;
                        final int n37 = 16;
                        BytecodeManager.incBytecodes(5);
                        final int value6 = calendar.get(n37);
                        BytecodeManager.incBytecodes(1);
                        boolean b;
                        if (value6 != 0) {
                            b = true;
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            b = false;
                            BytecodeManager.incBytecodes(1);
                        }
                        final int n38 = 0;
                        BytecodeManager.incBytecodes(3);
                        Locale us3;
                        if (locale == null) {
                            us3 = Locale.US;
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            us3 = locale;
                            BytecodeManager.incBytecodes(1);
                        }
                        BytecodeManager.incBytecodes(1);
                        final String displayName = timeZone2.getDisplayName(b, n38, us3);
                        BytecodeManager.incBytecodes(1);
                        sb21.append(displayName);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    case 'A':
                    case 'a': {
                        final int n39 = 7;
                        BytecodeManager.incBytecodes(3);
                        final int value7 = calendar.get(n39);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(2);
                        Locale us4;
                        if (locale == null) {
                            us4 = Locale.US;
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            us4 = locale;
                            BytecodeManager.incBytecodes(1);
                        }
                        final Locale locale2 = us4;
                        BytecodeManager.incBytecodes(1);
                        final Locale locale3 = locale2;
                        BytecodeManager.incBytecodes(2);
                        final DateFormatSymbols instance2 = DateFormatSymbols.getInstance(locale3);
                        BytecodeManager.incBytecodes(1);
                        final char c7 = 'A';
                        BytecodeManager.incBytecodes(3);
                        if (c == c7) {
                            final StringBuilder sb22 = sb;
                            final DateFormatSymbols dateFormatSymbols2 = instance2;
                            BytecodeManager.incBytecodes(3);
                            final String str = dateFormatSymbols2.getWeekdays()[value7];
                            BytecodeManager.incBytecodes(3);
                            sb22.append(str);
                            BytecodeManager.incBytecodes(2);
                            break;
                        }
                        final StringBuilder sb23 = sb;
                        final DateFormatSymbols dateFormatSymbols3 = instance2;
                        BytecodeManager.incBytecodes(3);
                        final String str2 = dateFormatSymbols3.getShortWeekdays()[value7];
                        BytecodeManager.incBytecodes(3);
                        sb23.append(str2);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    case 'B':
                    case 'b':
                    case 'h': {
                        final int n40 = 2;
                        BytecodeManager.incBytecodes(3);
                        final int value8 = calendar.get(n40);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(2);
                        Locale us5;
                        if (locale == null) {
                            us5 = Locale.US;
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            us5 = locale;
                            BytecodeManager.incBytecodes(1);
                        }
                        final Locale locale4 = us5;
                        BytecodeManager.incBytecodes(1);
                        final Locale locale5 = locale4;
                        BytecodeManager.incBytecodes(2);
                        final DateFormatSymbols instance3 = DateFormatSymbols.getInstance(locale5);
                        BytecodeManager.incBytecodes(1);
                        final char c8 = 'B';
                        BytecodeManager.incBytecodes(3);
                        if (c == c8) {
                            final StringBuilder sb24 = sb;
                            final DateFormatSymbols dateFormatSymbols4 = instance3;
                            BytecodeManager.incBytecodes(3);
                            final String str3 = dateFormatSymbols4.getMonths()[value8];
                            BytecodeManager.incBytecodes(3);
                            sb24.append(str3);
                            BytecodeManager.incBytecodes(2);
                            break;
                        }
                        final StringBuilder sb25 = sb;
                        final DateFormatSymbols dateFormatSymbols5 = instance3;
                        BytecodeManager.incBytecodes(3);
                        final String str4 = dateFormatSymbols5.getShortMonths()[value8];
                        BytecodeManager.incBytecodes(3);
                        sb25.append(str4);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    case 'C':
                    case 'Y':
                    case 'y': {
                        final int n41 = 1;
                        BytecodeManager.incBytecodes(3);
                        int value9 = calendar.get(n41);
                        BytecodeManager.incBytecodes(1);
                        int n42 = 2;
                        BytecodeManager.incBytecodes(2);
                        BytecodeManager.incBytecodes(2);
                        switch (c) {
                            case 'C': {
                                value9 /= 100;
                                BytecodeManager.incBytecodes(4);
                                BytecodeManager.incBytecodes(1);
                                break;
                            }
                            case 'y': {
                                value9 %= 100;
                                BytecodeManager.incBytecodes(4);
                                BytecodeManager.incBytecodes(1);
                                break;
                            }
                            case 'Y': {
                                n42 = 4;
                                BytecodeManager.incBytecodes(2);
                                break;
                            }
                        }
                        final Flags zero_PAD6 = Flags.ZERO_PAD;
                        BytecodeManager.incBytecodes(2);
                        final StringBuilder sb26 = sb;
                        final StringBuilder sb27 = null;
                        final long n43 = value9;
                        final Flags flags11 = zero_PAD6;
                        final int n44 = n42;
                        BytecodeManager.incBytecodes(9);
                        final StringBuilder localizedMagnitude9 = this.localizedMagnitude(sb27, n43, flags11, n44, locale);
                        BytecodeManager.incBytecodes(1);
                        sb26.append((CharSequence)localizedMagnitude9);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    case 'd':
                    case 'e': {
                        final int n45 = 5;
                        BytecodeManager.incBytecodes(3);
                        final int value10 = calendar.get(n45);
                        BytecodeManager.incBytecodes(1);
                        final char c9 = 'd';
                        BytecodeManager.incBytecodes(3);
                        Flags flags12;
                        if (c == c9) {
                            flags12 = Flags.ZERO_PAD;
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            flags12 = Flags.NONE;
                            BytecodeManager.incBytecodes(1);
                        }
                        final Flags flags13 = flags12;
                        BytecodeManager.incBytecodes(1);
                        final StringBuilder sb28 = sb;
                        final StringBuilder sb29 = null;
                        final long n46 = value10;
                        final Flags flags14 = flags13;
                        final int n47 = 2;
                        BytecodeManager.incBytecodes(9);
                        final StringBuilder localizedMagnitude10 = this.localizedMagnitude(sb29, n46, flags14, n47, locale);
                        BytecodeManager.incBytecodes(1);
                        sb28.append((CharSequence)localizedMagnitude10);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    case 'j': {
                        final int n48 = 6;
                        BytecodeManager.incBytecodes(3);
                        final int value11 = calendar.get(n48);
                        BytecodeManager.incBytecodes(1);
                        final Flags zero_PAD7 = Flags.ZERO_PAD;
                        BytecodeManager.incBytecodes(2);
                        final StringBuilder sb30 = sb;
                        final StringBuilder sb31 = null;
                        final long n49 = value11;
                        final Flags flags15 = zero_PAD7;
                        final int n50 = 3;
                        BytecodeManager.incBytecodes(9);
                        final StringBuilder localizedMagnitude11 = this.localizedMagnitude(sb31, n49, flags15, n50, locale);
                        BytecodeManager.incBytecodes(1);
                        sb30.append((CharSequence)localizedMagnitude11);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    case 'm': {
                        final int n51 = 2;
                        BytecodeManager.incBytecodes(3);
                        final int n52 = calendar.get(n51) + 1;
                        BytecodeManager.incBytecodes(3);
                        final Flags zero_PAD8 = Flags.ZERO_PAD;
                        BytecodeManager.incBytecodes(2);
                        final StringBuilder sb32 = sb;
                        final StringBuilder sb33 = null;
                        final long n53 = n52;
                        final Flags flags16 = zero_PAD8;
                        final int n54 = 2;
                        BytecodeManager.incBytecodes(9);
                        final StringBuilder localizedMagnitude12 = this.localizedMagnitude(sb33, n53, flags16, n54, locale);
                        BytecodeManager.incBytecodes(1);
                        sb32.append((CharSequence)localizedMagnitude12);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    case 'R':
                    case 'T': {
                        final char c10 = ':';
                        BytecodeManager.incBytecodes(2);
                        final StringBuilder sb34 = sb;
                        final char c11 = 'H';
                        BytecodeManager.incBytecodes(6);
                        final Appendable print = this.print(sb34, calendar, c11, locale);
                        final char c12 = c10;
                        BytecodeManager.incBytecodes(2);
                        print.append(c12);
                        BytecodeManager.incBytecodes(1);
                        final StringBuilder sb35 = sb;
                        final char c13 = 'M';
                        BytecodeManager.incBytecodes(6);
                        this.print(sb35, calendar, c13, locale);
                        BytecodeManager.incBytecodes(1);
                        final char c14 = 'T';
                        BytecodeManager.incBytecodes(3);
                        if (c == c14) {
                            final StringBuilder sb36 = sb;
                            final char c15 = c10;
                            BytecodeManager.incBytecodes(3);
                            sb36.append(c15);
                            BytecodeManager.incBytecodes(1);
                            final StringBuilder sb37 = sb;
                            final char c16 = 'S';
                            BytecodeManager.incBytecodes(6);
                            this.print(sb37, calendar, c16, locale);
                            BytecodeManager.incBytecodes(2);
                            break;
                        }
                        break;
                    }
                    case 'r': {
                        final char c17 = ':';
                        BytecodeManager.incBytecodes(2);
                        final StringBuilder sb38 = sb;
                        final char c18 = 'I';
                        BytecodeManager.incBytecodes(6);
                        final Appendable print2 = this.print(sb38, calendar, c18, locale);
                        final char c19 = c17;
                        BytecodeManager.incBytecodes(2);
                        print2.append(c19);
                        BytecodeManager.incBytecodes(1);
                        final StringBuilder sb39 = sb;
                        final char c20 = 'M';
                        BytecodeManager.incBytecodes(6);
                        final Appendable print3 = this.print(sb39, calendar, c20, locale);
                        final char c21 = c17;
                        BytecodeManager.incBytecodes(2);
                        print3.append(c21);
                        BytecodeManager.incBytecodes(1);
                        final StringBuilder sb40 = sb;
                        final char c22 = 'S';
                        BytecodeManager.incBytecodes(6);
                        final Appendable print4 = this.print(sb40, calendar, c22, locale);
                        final char c23 = ' ';
                        BytecodeManager.incBytecodes(2);
                        print4.append(c23);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(3);
                        final StringBuilder sb41 = new StringBuilder();
                        BytecodeManager.incBytecodes(1);
                        final StringBuilder sb42 = sb41;
                        final char c24 = 'p';
                        BytecodeManager.incBytecodes(6);
                        this.print(sb42, calendar, c24, locale);
                        BytecodeManager.incBytecodes(1);
                        final StringBuilder sb43 = sb;
                        final StringBuilder sb44 = sb41;
                        BytecodeManager.incBytecodes(3);
                        final String string = sb44.toString();
                        BytecodeManager.incBytecodes(2);
                        Locale us6;
                        if (locale != null) {
                            us6 = locale;
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            us6 = Locale.US;
                            BytecodeManager.incBytecodes(1);
                        }
                        BytecodeManager.incBytecodes(1);
                        final String upperCase = string.toUpperCase(us6);
                        BytecodeManager.incBytecodes(1);
                        sb43.append(upperCase);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    case 'c': {
                        final char c25 = ' ';
                        BytecodeManager.incBytecodes(2);
                        final StringBuilder sb45 = sb;
                        final char c26 = 'a';
                        BytecodeManager.incBytecodes(6);
                        final Appendable print5 = this.print(sb45, calendar, c26, locale);
                        final char c27 = c25;
                        BytecodeManager.incBytecodes(2);
                        print5.append(c27);
                        BytecodeManager.incBytecodes(1);
                        final StringBuilder sb46 = sb;
                        final char c28 = 'b';
                        BytecodeManager.incBytecodes(6);
                        final Appendable print6 = this.print(sb46, calendar, c28, locale);
                        final char c29 = c25;
                        BytecodeManager.incBytecodes(2);
                        print6.append(c29);
                        BytecodeManager.incBytecodes(1);
                        final StringBuilder sb47 = sb;
                        final char c30 = 'd';
                        BytecodeManager.incBytecodes(6);
                        final Appendable print7 = this.print(sb47, calendar, c30, locale);
                        final char c31 = c25;
                        BytecodeManager.incBytecodes(2);
                        print7.append(c31);
                        BytecodeManager.incBytecodes(1);
                        final StringBuilder sb48 = sb;
                        final char c32 = 'T';
                        BytecodeManager.incBytecodes(6);
                        final Appendable print8 = this.print(sb48, calendar, c32, locale);
                        final char c33 = c25;
                        BytecodeManager.incBytecodes(2);
                        print8.append(c33);
                        BytecodeManager.incBytecodes(1);
                        final StringBuilder sb49 = sb;
                        final char c34 = 'Z';
                        BytecodeManager.incBytecodes(6);
                        final Appendable print9 = this.print(sb49, calendar, c34, locale);
                        final char c35 = c25;
                        BytecodeManager.incBytecodes(2);
                        print9.append(c35);
                        BytecodeManager.incBytecodes(1);
                        final StringBuilder sb50 = sb;
                        final char c36 = 'Y';
                        BytecodeManager.incBytecodes(6);
                        this.print(sb50, calendar, c36, locale);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    case 'D': {
                        final char c37 = '/';
                        BytecodeManager.incBytecodes(2);
                        final StringBuilder sb51 = sb;
                        final char c38 = 'm';
                        BytecodeManager.incBytecodes(6);
                        final Appendable print10 = this.print(sb51, calendar, c38, locale);
                        final char c39 = c37;
                        BytecodeManager.incBytecodes(2);
                        print10.append(c39);
                        BytecodeManager.incBytecodes(1);
                        final StringBuilder sb52 = sb;
                        final char c40 = 'd';
                        BytecodeManager.incBytecodes(6);
                        final Appendable print11 = this.print(sb52, calendar, c40, locale);
                        final char c41 = c37;
                        BytecodeManager.incBytecodes(2);
                        print11.append(c41);
                        BytecodeManager.incBytecodes(1);
                        final StringBuilder sb53 = sb;
                        final char c42 = 'y';
                        BytecodeManager.incBytecodes(6);
                        this.print(sb53, calendar, c42, locale);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    case 'F': {
                        final char c43 = '-';
                        BytecodeManager.incBytecodes(2);
                        final StringBuilder sb54 = sb;
                        final char c44 = 'Y';
                        BytecodeManager.incBytecodes(6);
                        final Appendable print12 = this.print(sb54, calendar, c44, locale);
                        final char c45 = c43;
                        BytecodeManager.incBytecodes(2);
                        print12.append(c45);
                        BytecodeManager.incBytecodes(1);
                        final StringBuilder sb55 = sb;
                        final char c46 = 'm';
                        BytecodeManager.incBytecodes(6);
                        final Appendable print13 = this.print(sb55, calendar, c46, locale);
                        final char c47 = c43;
                        BytecodeManager.incBytecodes(2);
                        print13.append(c47);
                        BytecodeManager.incBytecodes(1);
                        final StringBuilder sb56 = sb;
                        final char c48 = 'd';
                        BytecodeManager.incBytecodes(6);
                        this.print(sb56, calendar, c48, locale);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    default: {
                        final boolean $assertionsDisabled = FormatSpecifier.$assertionsDisabled;
                        BytecodeManager.incBytecodes(2);
                        if (!$assertionsDisabled) {
                            BytecodeManager.incBytecodes(3);
                            final AssertionError assertionError = new AssertionError();
                            BytecodeManager.incBytecodes(1);
                            throw assertionError;
                        }
                        break;
                    }
                }
                final StringBuilder sb57 = sb;
                BytecodeManager.incBytecodes(2);
                return sb57;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private void print(final TemporalAccessor temporalAccessor, final char c, final Locale locale) throws IOException {
            try {
                BytecodeManager.incBytecodes(3);
                final StringBuilder sb = new StringBuilder();
                BytecodeManager.incBytecodes(1);
                final StringBuilder sb2 = sb;
                BytecodeManager.incBytecodes(6);
                this.print(sb2, temporalAccessor, c, locale);
                BytecodeManager.incBytecodes(1);
                final StringBuilder sb3 = sb;
                BytecodeManager.incBytecodes(3);
                final String string = sb3.toString();
                BytecodeManager.incBytecodes(1);
                String s = this.justify(string);
                BytecodeManager.incBytecodes(1);
                final Flags f = this.f;
                final Flags uppercase = Flags.UPPERCASE;
                BytecodeManager.incBytecodes(4);
                final boolean contains = f.contains(uppercase);
                BytecodeManager.incBytecodes(1);
                if (contains) {
                    final String s2 = s;
                    BytecodeManager.incBytecodes(2);
                    s = s2.toUpperCase();
                    BytecodeManager.incBytecodes(1);
                }
                final Formatter this$0 = Formatter.this;
                BytecodeManager.incBytecodes(3);
                final Appendable access$000 = Formatter.access$000(this$0);
                final String s3 = s;
                BytecodeManager.incBytecodes(2);
                access$000.append(s3);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private Appendable print(final StringBuilder p0, final TemporalAccessor p1, final char p2, final Locale p3) throws IOException {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: ldc             2
            //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //     6: ifnonnull       27
            //     9: new             Ljava/lang/StringBuilder;
            //    12: dup            
            //    13: ldc             3
            //    15: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    18: invokespecial   java/lang/StringBuilder.<init>:()V
            //    21: astore_1       
            //    22: ldc             1
            //    24: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    27: iload_3        
            //    28: ldc             2
            //    30: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    33: tableswitch {
            //              130: 1633
            //              131: 1789
            //              132: 1942
            //              133: 2908
            //              134: 3122
            //              135: 3015
            //              136: 3122
            //              137: 280
            //              138: 408
            //              139: 3122
            //              140: 3122
            //              141: 687
            //              142: 536
            //              143: 609
            //              144: 3122
            //              145: 3122
            //              146: 760
            //              147: 2359
            //              148: 1100
            //              149: 2359
            //              150: 3122
            //              151: 3122
            //              152: 3122
            //              153: 3122
            //              154: 1942
            //              155: 1374
            //              156: 3122
            //              157: 3122
            //              158: 3122
            //              159: 3122
            //              160: 3122
            //              161: 3122
            //              162: 1633
            //              163: 1789
            //              164: 2699
            //              165: 2113
            //              166: 2113
            //              167: 3122
            //              168: 3122
            //              169: 1789
            //              170: 3122
            //              171: 2213
            //              172: 344
            //              173: 472
            //              174: 2286
            //              175: 3122
            //              176: 3122
            //              177: 859
            //              178: 3122
            //              179: 2477
            //              180: 1025
            //              181: 3122
            //              182: 3122
            //              183: 3122
            //              184: 3122
            //              185: 3122
            //              186: 1942
            //              187: 1173
            //          default: 3122
            //        }
            //   280: aload_2        
            //   281: getstatic       java/time/temporal/ChronoField.HOUR_OF_DAY:Ljava/time/temporal/ChronoField;
            //   284: ldc             3
            //   286: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   289: invokeinterface java/time/temporal/TemporalAccessor.get:(Ljava/time/temporal/TemporalField;)I
            //   294: istore          5
            //   296: ldc             1
            //   298: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   301: aload_1        
            //   302: aload_0        
            //   303: aconst_null    
            //   304: iload           5
            //   306: i2l            
            //   307: getstatic       instrumented/java/util/Formatter$Flags.ZERO_PAD:Linstrumented/java/util/Formatter$Flags;
            //   310: iconst_2       
            //   311: aload           4
            //   313: ldc_w           9
            //   316: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   319: invokespecial   instrumented/java/util/Formatter$FormatSpecifier.localizedMagnitude:(Ljava/lang/StringBuilder;JLinstrumented/java/util/Formatter$Flags;ILinstrumented/java/util/Locale;)Ljava/lang/StringBuilder;
            //   322: ldc             1
            //   324: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   327: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
            //   330: pop            
            //   331: ldc             1
            //   333: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   336: ldc             1
            //   338: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   341: goto            3151
            //   344: aload_2        
            //   345: getstatic       java/time/temporal/ChronoField.HOUR_OF_DAY:Ljava/time/temporal/ChronoField;
            //   348: ldc             3
            //   350: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   353: invokeinterface java/time/temporal/TemporalAccessor.get:(Ljava/time/temporal/TemporalField;)I
            //   358: istore          5
            //   360: ldc             1
            //   362: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   365: aload_1        
            //   366: aload_0        
            //   367: aconst_null    
            //   368: iload           5
            //   370: i2l            
            //   371: getstatic       instrumented/java/util/Formatter$Flags.NONE:Linstrumented/java/util/Formatter$Flags;
            //   374: iconst_2       
            //   375: aload           4
            //   377: ldc_w           9
            //   380: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   383: invokespecial   instrumented/java/util/Formatter$FormatSpecifier.localizedMagnitude:(Ljava/lang/StringBuilder;JLinstrumented/java/util/Formatter$Flags;ILinstrumented/java/util/Locale;)Ljava/lang/StringBuilder;
            //   386: ldc             1
            //   388: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   391: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
            //   394: pop            
            //   395: ldc             1
            //   397: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   400: ldc             1
            //   402: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   405: goto            3151
            //   408: aload_2        
            //   409: getstatic       java/time/temporal/ChronoField.CLOCK_HOUR_OF_AMPM:Ljava/time/temporal/ChronoField;
            //   412: ldc             3
            //   414: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   417: invokeinterface java/time/temporal/TemporalAccessor.get:(Ljava/time/temporal/TemporalField;)I
            //   422: istore          5
            //   424: ldc             1
            //   426: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   429: aload_1        
            //   430: aload_0        
            //   431: aconst_null    
            //   432: iload           5
            //   434: i2l            
            //   435: getstatic       instrumented/java/util/Formatter$Flags.ZERO_PAD:Linstrumented/java/util/Formatter$Flags;
            //   438: iconst_2       
            //   439: aload           4
            //   441: ldc_w           9
            //   444: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   447: invokespecial   instrumented/java/util/Formatter$FormatSpecifier.localizedMagnitude:(Ljava/lang/StringBuilder;JLinstrumented/java/util/Formatter$Flags;ILinstrumented/java/util/Locale;)Ljava/lang/StringBuilder;
            //   450: ldc             1
            //   452: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   455: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
            //   458: pop            
            //   459: ldc             1
            //   461: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   464: ldc             1
            //   466: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   469: goto            3151
            //   472: aload_2        
            //   473: getstatic       java/time/temporal/ChronoField.CLOCK_HOUR_OF_AMPM:Ljava/time/temporal/ChronoField;
            //   476: ldc             3
            //   478: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   481: invokeinterface java/time/temporal/TemporalAccessor.get:(Ljava/time/temporal/TemporalField;)I
            //   486: istore          5
            //   488: ldc             1
            //   490: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   493: aload_1        
            //   494: aload_0        
            //   495: aconst_null    
            //   496: iload           5
            //   498: i2l            
            //   499: getstatic       instrumented/java/util/Formatter$Flags.NONE:Linstrumented/java/util/Formatter$Flags;
            //   502: iconst_2       
            //   503: aload           4
            //   505: ldc_w           9
            //   508: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   511: invokespecial   instrumented/java/util/Formatter$FormatSpecifier.localizedMagnitude:(Ljava/lang/StringBuilder;JLinstrumented/java/util/Formatter$Flags;ILinstrumented/java/util/Locale;)Ljava/lang/StringBuilder;
            //   514: ldc             1
            //   516: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   519: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
            //   522: pop            
            //   523: ldc             1
            //   525: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   528: ldc             1
            //   530: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   533: goto            3151
            //   536: aload_2        
            //   537: getstatic       java/time/temporal/ChronoField.MINUTE_OF_HOUR:Ljava/time/temporal/ChronoField;
            //   540: ldc             3
            //   542: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   545: invokeinterface java/time/temporal/TemporalAccessor.get:(Ljava/time/temporal/TemporalField;)I
            //   550: istore          5
            //   552: ldc             1
            //   554: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   557: getstatic       instrumented/java/util/Formatter$Flags.ZERO_PAD:Linstrumented/java/util/Formatter$Flags;
            //   560: astore          6
            //   562: ldc             2
            //   564: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   567: aload_1        
            //   568: aload_0        
            //   569: aconst_null    
            //   570: iload           5
            //   572: i2l            
            //   573: aload           6
            //   575: iconst_2       
            //   576: aload           4
            //   578: ldc_w           9
            //   581: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   584: invokespecial   instrumented/java/util/Formatter$FormatSpecifier.localizedMagnitude:(Ljava/lang/StringBuilder;JLinstrumented/java/util/Formatter$Flags;ILinstrumented/java/util/Locale;)Ljava/lang/StringBuilder;
            //   587: ldc             1
            //   589: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   592: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
            //   595: pop            
            //   596: ldc             1
            //   598: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   601: ldc             1
            //   603: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   606: goto            3151
            //   609: aload_2        
            //   610: getstatic       java/time/temporal/ChronoField.MILLI_OF_SECOND:Ljava/time/temporal/ChronoField;
            //   613: ldc             3
            //   615: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   618: invokeinterface java/time/temporal/TemporalAccessor.get:(Ljava/time/temporal/TemporalField;)I
            //   623: ldc_w           1000000
            //   626: imul           
            //   627: istore          5
            //   629: ldc             3
            //   631: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   634: getstatic       instrumented/java/util/Formatter$Flags.ZERO_PAD:Linstrumented/java/util/Formatter$Flags;
            //   637: astore          6
            //   639: ldc             2
            //   641: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   644: aload_1        
            //   645: aload_0        
            //   646: aconst_null    
            //   647: iload           5
            //   649: i2l            
            //   650: aload           6
            //   652: bipush          9
            //   654: aload           4
            //   656: ldc_w           9
            //   659: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   662: invokespecial   instrumented/java/util/Formatter$FormatSpecifier.localizedMagnitude:(Ljava/lang/StringBuilder;JLinstrumented/java/util/Formatter$Flags;ILinstrumented/java/util/Locale;)Ljava/lang/StringBuilder;
            //   665: ldc             1
            //   667: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   670: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
            //   673: pop            
            //   674: ldc             1
            //   676: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   679: ldc             1
            //   681: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   684: goto            3151
            //   687: aload_2        
            //   688: getstatic       java/time/temporal/ChronoField.MILLI_OF_SECOND:Ljava/time/temporal/ChronoField;
            //   691: ldc             3
            //   693: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   696: invokeinterface java/time/temporal/TemporalAccessor.get:(Ljava/time/temporal/TemporalField;)I
            //   701: istore          5
            //   703: ldc             1
            //   705: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   708: getstatic       instrumented/java/util/Formatter$Flags.ZERO_PAD:Linstrumented/java/util/Formatter$Flags;
            //   711: astore          6
            //   713: ldc             2
            //   715: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   718: aload_1        
            //   719: aload_0        
            //   720: aconst_null    
            //   721: iload           5
            //   723: i2l            
            //   724: aload           6
            //   726: iconst_3       
            //   727: aload           4
            //   729: ldc_w           9
            //   732: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   735: invokespecial   instrumented/java/util/Formatter$FormatSpecifier.localizedMagnitude:(Ljava/lang/StringBuilder;JLinstrumented/java/util/Formatter$Flags;ILinstrumented/java/util/Locale;)Ljava/lang/StringBuilder;
            //   738: ldc             1
            //   740: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   743: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
            //   746: pop            
            //   747: ldc             1
            //   749: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   752: ldc             1
            //   754: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   757: goto            3151
            //   760: aload_2        
            //   761: getstatic       java/time/temporal/ChronoField.INSTANT_SECONDS:Ljava/time/temporal/ChronoField;
            //   764: ldc             3
            //   766: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   769: invokeinterface java/time/temporal/TemporalAccessor.getLong:(Ljava/time/temporal/TemporalField;)J
            //   774: ldc2_w          1000
            //   777: lmul           
            //   778: aload_2        
            //   779: getstatic       java/time/temporal/ChronoField.MILLI_OF_SECOND:Ljava/time/temporal/ChronoField;
            //   782: ldc             4
            //   784: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   787: ldc             1
            //   789: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   792: invokeinterface java/time/temporal/TemporalAccessor.getLong:(Ljava/time/temporal/TemporalField;)J
            //   797: ladd           
            //   798: lstore          5
            //   800: ldc             2
            //   802: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   805: getstatic       instrumented/java/util/Formatter$Flags.NONE:Linstrumented/java/util/Formatter$Flags;
            //   808: astore          7
            //   810: ldc             2
            //   812: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   815: aload_1        
            //   816: aload_0        
            //   817: aconst_null    
            //   818: lload           5
            //   820: aload           7
            //   822: aload_0        
            //   823: getfield        instrumented/java/util/Formatter$FormatSpecifier.width:I
            //   826: aload           4
            //   828: ldc_w           9
            //   831: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   834: invokespecial   instrumented/java/util/Formatter$FormatSpecifier.localizedMagnitude:(Ljava/lang/StringBuilder;JLinstrumented/java/util/Formatter$Flags;ILinstrumented/java/util/Locale;)Ljava/lang/StringBuilder;
            //   837: ldc             1
            //   839: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   842: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
            //   845: pop            
            //   846: ldc             1
            //   848: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   851: ldc             1
            //   853: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   856: goto            3151
            //   859: iconst_2       
            //   860: anewarray       Ljava/lang/String;
            //   863: dup            
            //   864: iconst_0       
            //   865: ldc_w           "AM"
            //   868: aastore        
            //   869: dup            
            //   870: iconst_1       
            //   871: ldc_w           "PM"
            //   874: aastore        
            //   875: astore          5
            //   877: ldc_w           10
            //   880: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   883: aload           4
            //   885: ldc             2
            //   887: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   890: ifnull          940
            //   893: aload           4
            //   895: getstatic       instrumented/java/util/Locale.US:Linstrumented/java/util/Locale;
            //   898: ldc             3
            //   900: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   903: if_acmpeq       940
            //   906: aload           4
            //   908: ldc             2
            //   910: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   913: invokestatic    java/text/DateFormatSymbols.getInstance:(Linstrumented/java/util/Locale;)Ljava/text/DateFormatSymbols;
            //   916: astore          6
            //   918: ldc             1
            //   920: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   923: aload           6
            //   925: ldc             2
            //   927: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   930: invokevirtual   java/text/DateFormatSymbols.getAmPmStrings:()[Ljava/lang/String;
            //   933: astore          5
            //   935: ldc             1
            //   937: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   940: aload           5
            //   942: aload_2        
            //   943: getstatic       java/time/temporal/ChronoField.AMPM_OF_DAY:Ljava/time/temporal/ChronoField;
            //   946: ldc             4
            //   948: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   951: invokeinterface java/time/temporal/TemporalAccessor.get:(Ljava/time/temporal/TemporalField;)I
            //   956: aaload         
            //   957: astore          6
            //   959: ldc             2
            //   961: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   964: aload_1        
            //   965: aload           6
            //   967: aload           4
            //   969: ldc             4
            //   971: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   974: ifnull          987
            //   977: aload           4
            //   979: ldc             2
            //   981: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   984: goto            995
            //   987: getstatic       instrumented/java/util/Locale.US:Linstrumented/java/util/Locale;
            //   990: ldc             1
            //   992: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   995: ldc             1
            //   997: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1000: invokevirtual   java/lang/String.toLowerCase:(Linstrumented/java/util/Locale;)Ljava/lang/String;
            //  1003: ldc             1
            //  1005: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1008: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //  1011: pop            
            //  1012: ldc             1
            //  1014: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1017: ldc             1
            //  1019: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1022: goto            3151
            //  1025: aload_2        
            //  1026: getstatic       java/time/temporal/ChronoField.INSTANT_SECONDS:Ljava/time/temporal/ChronoField;
            //  1029: ldc             3
            //  1031: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1034: invokeinterface java/time/temporal/TemporalAccessor.getLong:(Ljava/time/temporal/TemporalField;)J
            //  1039: lstore          5
            //  1041: ldc             1
            //  1043: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1046: getstatic       instrumented/java/util/Formatter$Flags.NONE:Linstrumented/java/util/Formatter$Flags;
            //  1049: astore          7
            //  1051: ldc             2
            //  1053: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1056: aload_1        
            //  1057: aload_0        
            //  1058: aconst_null    
            //  1059: lload           5
            //  1061: aload           7
            //  1063: aload_0        
            //  1064: getfield        instrumented/java/util/Formatter$FormatSpecifier.width:I
            //  1067: aload           4
            //  1069: ldc_w           9
            //  1072: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1075: invokespecial   instrumented/java/util/Formatter$FormatSpecifier.localizedMagnitude:(Ljava/lang/StringBuilder;JLinstrumented/java/util/Formatter$Flags;ILinstrumented/java/util/Locale;)Ljava/lang/StringBuilder;
            //  1078: ldc             1
            //  1080: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1083: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
            //  1086: pop            
            //  1087: ldc             1
            //  1089: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1092: ldc             1
            //  1094: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1097: goto            3151
            //  1100: aload_2        
            //  1101: getstatic       java/time/temporal/ChronoField.SECOND_OF_MINUTE:Ljava/time/temporal/ChronoField;
            //  1104: ldc             3
            //  1106: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1109: invokeinterface java/time/temporal/TemporalAccessor.get:(Ljava/time/temporal/TemporalField;)I
            //  1114: istore          5
            //  1116: ldc             1
            //  1118: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1121: getstatic       instrumented/java/util/Formatter$Flags.ZERO_PAD:Linstrumented/java/util/Formatter$Flags;
            //  1124: astore          6
            //  1126: ldc             2
            //  1128: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1131: aload_1        
            //  1132: aload_0        
            //  1133: aconst_null    
            //  1134: iload           5
            //  1136: i2l            
            //  1137: aload           6
            //  1139: iconst_2       
            //  1140: aload           4
            //  1142: ldc_w           9
            //  1145: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1148: invokespecial   instrumented/java/util/Formatter$FormatSpecifier.localizedMagnitude:(Ljava/lang/StringBuilder;JLinstrumented/java/util/Formatter$Flags;ILinstrumented/java/util/Locale;)Ljava/lang/StringBuilder;
            //  1151: ldc             1
            //  1153: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1156: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
            //  1159: pop            
            //  1160: ldc             1
            //  1162: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1165: ldc             1
            //  1167: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1170: goto            3151
            //  1173: aload_2        
            //  1174: getstatic       java/time/temporal/ChronoField.OFFSET_SECONDS:Ljava/time/temporal/ChronoField;
            //  1177: ldc             3
            //  1179: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1182: invokeinterface java/time/temporal/TemporalAccessor.get:(Ljava/time/temporal/TemporalField;)I
            //  1187: istore          5
            //  1189: ldc             1
            //  1191: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1194: iload           5
            //  1196: ldc             2
            //  1198: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1201: ifge            1213
            //  1204: iconst_1       
            //  1205: ldc             2
            //  1207: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1210: goto            1219
            //  1213: iconst_0       
            //  1214: ldc             1
            //  1216: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1219: istore          6
            //  1221: ldc             1
            //  1223: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1226: aload_1        
            //  1227: iload           6
            //  1229: ldc             3
            //  1231: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1234: ifeq            1247
            //  1237: bipush          45
            //  1239: ldc             2
            //  1241: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1244: goto            1254
            //  1247: bipush          43
            //  1249: ldc             1
            //  1251: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1254: ldc             1
            //  1256: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1259: invokevirtual   java/lang/StringBuilder.append:(C)Ljava/lang/StringBuilder;
            //  1262: pop            
            //  1263: ldc             1
            //  1265: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1268: iload           6
            //  1270: ldc             2
            //  1272: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1275: ifeq            1288
            //  1278: iload           5
            //  1280: ineg           
            //  1281: istore          5
            //  1283: ldc             3
            //  1285: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1288: iload           5
            //  1290: bipush          60
            //  1292: idiv           
            //  1293: istore          7
            //  1295: ldc             4
            //  1297: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1300: iload           7
            //  1302: bipush          60
            //  1304: idiv           
            //  1305: bipush          100
            //  1307: imul           
            //  1308: iload           7
            //  1310: bipush          60
            //  1312: irem           
            //  1313: iadd           
            //  1314: istore          8
            //  1316: ldc_w           10
            //  1319: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1322: getstatic       instrumented/java/util/Formatter$Flags.ZERO_PAD:Linstrumented/java/util/Formatter$Flags;
            //  1325: astore          9
            //  1327: ldc             2
            //  1329: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1332: aload_1        
            //  1333: aload_0        
            //  1334: aconst_null    
            //  1335: iload           8
            //  1337: i2l            
            //  1338: aload           9
            //  1340: iconst_4       
            //  1341: aload           4
            //  1343: ldc_w           9
            //  1346: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1349: invokespecial   instrumented/java/util/Formatter$FormatSpecifier.localizedMagnitude:(Ljava/lang/StringBuilder;JLinstrumented/java/util/Formatter$Flags;ILinstrumented/java/util/Locale;)Ljava/lang/StringBuilder;
            //  1352: ldc             1
            //  1354: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1357: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
            //  1360: pop            
            //  1361: ldc             1
            //  1363: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1366: ldc             1
            //  1368: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1371: goto            3151
            //  1374: aload_2        
            //  1375: ldc             2
            //  1377: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1380: invokestatic    java/time/temporal/TemporalQueries.zone:()Ljava/time/temporal/TemporalQuery;
            //  1383: ldc             1
            //  1385: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1388: invokeinterface java/time/temporal/TemporalAccessor.query:(Ljava/time/temporal/TemporalQuery;)Ljava/lang/Object;
            //  1393: checkcast       Ljava/time/ZoneId;
            //  1396: astore          5
            //  1398: ldc             2
            //  1400: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1403: aload           5
            //  1405: ldc             2
            //  1407: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1410: ifnonnull       1441
            //  1413: new             Linstrumented/java/util/IllegalFormatConversionException;
            //  1416: dup            
            //  1417: iload_3        
            //  1418: aload_2        
            //  1419: ldc             5
            //  1421: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1424: invokevirtual   java/lang/Object.getClass:()Ljava/lang/Class;
            //  1427: ldc             1
            //  1429: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1432: invokespecial   instrumented/java/util/IllegalFormatConversionException.<init>:(CLjava/lang/Class;)V
            //  1435: ldc             1
            //  1437: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1440: athrow         
            //  1441: aload           5
            //  1443: instanceof      Ljava/time/ZoneOffset;
            //  1446: ldc             3
            //  1448: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1451: ifne            1600
            //  1454: aload_2        
            //  1455: getstatic       java/time/temporal/ChronoField.INSTANT_SECONDS:Ljava/time/temporal/ChronoField;
            //  1458: ldc             2
            //  1460: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1463: ldc             1
            //  1465: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1468: invokeinterface java/time/temporal/TemporalAccessor.isSupported:(Ljava/time/temporal/TemporalField;)Z
            //  1473: ldc             1
            //  1475: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1478: ifeq            1600
            //  1481: aload_2        
            //  1482: ldc             2
            //  1484: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1487: invokestatic    java/time/Instant.from:(Ljava/time/temporal/TemporalAccessor;)Ljava/time/Instant;
            //  1490: astore          6
            //  1492: ldc             1
            //  1494: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1497: aload_1        
            //  1498: aload           5
            //  1500: ldc             3
            //  1502: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1505: invokevirtual   java/time/ZoneId.getId:()Ljava/lang/String;
            //  1508: ldc             1
            //  1510: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1513: invokestatic    instrumented/java/util/TimeZone.getTimeZone:(Ljava/lang/String;)Linstrumented/java/util/TimeZone;
            //  1516: aload           5
            //  1518: ldc             1
            //  1520: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1523: ldc             1
            //  1525: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1528: invokevirtual   java/time/ZoneId.getRules:()Ljava/time/zone/ZoneRules;
            //  1531: aload           6
            //  1533: ldc             2
            //  1535: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1538: invokevirtual   java/time/zone/ZoneRules.isDaylightSavings:(Ljava/time/Instant;)Z
            //  1541: iconst_0       
            //  1542: aload           4
            //  1544: ldc             3
            //  1546: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1549: ifnonnull       1563
            //  1552: getstatic       instrumented/java/util/Locale.US:Linstrumented/java/util/Locale;
            //  1555: ldc             2
            //  1557: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1560: goto            1570
            //  1563: aload           4
            //  1565: ldc             1
            //  1567: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1570: ldc             1
            //  1572: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1575: invokevirtual   instrumented/java/util/TimeZone.getDisplayName:(ZILinstrumented/java/util/Locale;)Ljava/lang/String;
            //  1578: ldc             1
            //  1580: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1583: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //  1586: pop            
            //  1587: ldc             1
            //  1589: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1592: ldc             1
            //  1594: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1597: goto            3151
            //  1600: aload_1        
            //  1601: aload           5
            //  1603: ldc             3
            //  1605: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1608: invokevirtual   java/time/ZoneId.getId:()Ljava/lang/String;
            //  1611: ldc             1
            //  1613: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1616: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //  1619: pop            
            //  1620: ldc             1
            //  1622: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1625: ldc             1
            //  1627: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1630: goto            3151
            //  1633: aload_2        
            //  1634: getstatic       java/time/temporal/ChronoField.DAY_OF_WEEK:Ljava/time/temporal/ChronoField;
            //  1637: ldc             3
            //  1639: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1642: invokeinterface java/time/temporal/TemporalAccessor.get:(Ljava/time/temporal/TemporalField;)I
            //  1647: bipush          7
            //  1649: irem           
            //  1650: iconst_1       
            //  1651: iadd           
            //  1652: istore          5
            //  1654: ldc             5
            //  1656: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1659: aload           4
            //  1661: ldc             2
            //  1663: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1666: ifnonnull       1680
            //  1669: getstatic       instrumented/java/util/Locale.US:Linstrumented/java/util/Locale;
            //  1672: ldc             2
            //  1674: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1677: goto            1687
            //  1680: aload           4
            //  1682: ldc             1
            //  1684: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1687: astore          6
            //  1689: ldc             1
            //  1691: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1694: aload           6
            //  1696: ldc             2
            //  1698: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1701: invokestatic    java/text/DateFormatSymbols.getInstance:(Linstrumented/java/util/Locale;)Ljava/text/DateFormatSymbols;
            //  1704: astore          7
            //  1706: ldc             1
            //  1708: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1711: iload_3        
            //  1712: bipush          65
            //  1714: ldc             3
            //  1716: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1719: if_icmpne       1753
            //  1722: aload_1        
            //  1723: aload           7
            //  1725: ldc             3
            //  1727: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1730: invokevirtual   java/text/DateFormatSymbols.getWeekdays:()[Ljava/lang/String;
            //  1733: iload           5
            //  1735: aaload         
            //  1736: ldc             3
            //  1738: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1741: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //  1744: pop            
            //  1745: ldc             2
            //  1747: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1750: goto            3151
            //  1753: aload_1        
            //  1754: aload           7
            //  1756: ldc             3
            //  1758: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1761: invokevirtual   java/text/DateFormatSymbols.getShortWeekdays:()[Ljava/lang/String;
            //  1764: iload           5
            //  1766: aaload         
            //  1767: ldc             3
            //  1769: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1772: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //  1775: pop            
            //  1776: ldc             1
            //  1778: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1781: ldc             1
            //  1783: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1786: goto            3151
            //  1789: aload_2        
            //  1790: getstatic       java/time/temporal/ChronoField.MONTH_OF_YEAR:Ljava/time/temporal/ChronoField;
            //  1793: ldc             3
            //  1795: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1798: invokeinterface java/time/temporal/TemporalAccessor.get:(Ljava/time/temporal/TemporalField;)I
            //  1803: iconst_1       
            //  1804: isub           
            //  1805: istore          5
            //  1807: ldc             3
            //  1809: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1812: aload           4
            //  1814: ldc             2
            //  1816: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1819: ifnonnull       1833
            //  1822: getstatic       instrumented/java/util/Locale.US:Linstrumented/java/util/Locale;
            //  1825: ldc             2
            //  1827: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1830: goto            1840
            //  1833: aload           4
            //  1835: ldc             1
            //  1837: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1840: astore          6
            //  1842: ldc             1
            //  1844: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1847: aload           6
            //  1849: ldc             2
            //  1851: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1854: invokestatic    java/text/DateFormatSymbols.getInstance:(Linstrumented/java/util/Locale;)Ljava/text/DateFormatSymbols;
            //  1857: astore          7
            //  1859: ldc             1
            //  1861: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1864: iload_3        
            //  1865: bipush          66
            //  1867: ldc             3
            //  1869: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1872: if_icmpne       1906
            //  1875: aload_1        
            //  1876: aload           7
            //  1878: ldc             3
            //  1880: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1883: invokevirtual   java/text/DateFormatSymbols.getMonths:()[Ljava/lang/String;
            //  1886: iload           5
            //  1888: aaload         
            //  1889: ldc             3
            //  1891: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1894: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //  1897: pop            
            //  1898: ldc             2
            //  1900: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1903: goto            3151
            //  1906: aload_1        
            //  1907: aload           7
            //  1909: ldc             3
            //  1911: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1914: invokevirtual   java/text/DateFormatSymbols.getShortMonths:()[Ljava/lang/String;
            //  1917: iload           5
            //  1919: aaload         
            //  1920: ldc             3
            //  1922: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1925: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //  1928: pop            
            //  1929: ldc             1
            //  1931: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1934: ldc             1
            //  1936: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1939: goto            3151
            //  1942: aload_2        
            //  1943: getstatic       java/time/temporal/ChronoField.YEAR_OF_ERA:Ljava/time/temporal/ChronoField;
            //  1946: ldc             3
            //  1948: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1951: invokeinterface java/time/temporal/TemporalAccessor.get:(Ljava/time/temporal/TemporalField;)I
            //  1956: istore          5
            //  1958: ldc             1
            //  1960: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1963: iconst_2       
            //  1964: istore          6
            //  1966: ldc             2
            //  1968: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1971: iload_3        
            //  1972: ldc             2
            //  1974: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  1977: lookupswitch {
            //               67: 2012
            //               89: 2052
            //              121: 2032
            //          default: 2060
            //        }
            //  2012: iload           5
            //  2014: bipush          100
            //  2016: idiv           
            //  2017: istore          5
            //  2019: ldc             4
            //  2021: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2024: ldc             1
            //  2026: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2029: goto            2060
            //  2032: iload           5
            //  2034: bipush          100
            //  2036: irem           
            //  2037: istore          5
            //  2039: ldc             4
            //  2041: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2044: ldc             1
            //  2046: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2049: goto            2060
            //  2052: iconst_4       
            //  2053: istore          6
            //  2055: ldc             2
            //  2057: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2060: getstatic       instrumented/java/util/Formatter$Flags.ZERO_PAD:Linstrumented/java/util/Formatter$Flags;
            //  2063: astore          7
            //  2065: ldc             2
            //  2067: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2070: aload_1        
            //  2071: aload_0        
            //  2072: aconst_null    
            //  2073: iload           5
            //  2075: i2l            
            //  2076: aload           7
            //  2078: iload           6
            //  2080: aload           4
            //  2082: ldc_w           9
            //  2085: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2088: invokespecial   instrumented/java/util/Formatter$FormatSpecifier.localizedMagnitude:(Ljava/lang/StringBuilder;JLinstrumented/java/util/Formatter$Flags;ILinstrumented/java/util/Locale;)Ljava/lang/StringBuilder;
            //  2091: ldc             1
            //  2093: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2096: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
            //  2099: pop            
            //  2100: ldc             1
            //  2102: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2105: ldc             1
            //  2107: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2110: goto            3151
            //  2113: aload_2        
            //  2114: getstatic       java/time/temporal/ChronoField.DAY_OF_MONTH:Ljava/time/temporal/ChronoField;
            //  2117: ldc             3
            //  2119: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2122: invokeinterface java/time/temporal/TemporalAccessor.get:(Ljava/time/temporal/TemporalField;)I
            //  2127: istore          5
            //  2129: ldc             1
            //  2131: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2134: iload_3        
            //  2135: bipush          100
            //  2137: ldc             3
            //  2139: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2142: if_icmpne       2156
            //  2145: getstatic       instrumented/java/util/Formatter$Flags.ZERO_PAD:Linstrumented/java/util/Formatter$Flags;
            //  2148: ldc             2
            //  2150: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2153: goto            2164
            //  2156: getstatic       instrumented/java/util/Formatter$Flags.NONE:Linstrumented/java/util/Formatter$Flags;
            //  2159: ldc             1
            //  2161: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2164: astore          6
            //  2166: ldc             1
            //  2168: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2171: aload_1        
            //  2172: aload_0        
            //  2173: aconst_null    
            //  2174: iload           5
            //  2176: i2l            
            //  2177: aload           6
            //  2179: iconst_2       
            //  2180: aload           4
            //  2182: ldc_w           9
            //  2185: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2188: invokespecial   instrumented/java/util/Formatter$FormatSpecifier.localizedMagnitude:(Ljava/lang/StringBuilder;JLinstrumented/java/util/Formatter$Flags;ILinstrumented/java/util/Locale;)Ljava/lang/StringBuilder;
            //  2191: ldc             1
            //  2193: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2196: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
            //  2199: pop            
            //  2200: ldc             1
            //  2202: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2205: ldc             1
            //  2207: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2210: goto            3151
            //  2213: aload_2        
            //  2214: getstatic       java/time/temporal/ChronoField.DAY_OF_YEAR:Ljava/time/temporal/ChronoField;
            //  2217: ldc             3
            //  2219: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2222: invokeinterface java/time/temporal/TemporalAccessor.get:(Ljava/time/temporal/TemporalField;)I
            //  2227: istore          5
            //  2229: ldc             1
            //  2231: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2234: getstatic       instrumented/java/util/Formatter$Flags.ZERO_PAD:Linstrumented/java/util/Formatter$Flags;
            //  2237: astore          6
            //  2239: ldc             2
            //  2241: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2244: aload_1        
            //  2245: aload_0        
            //  2246: aconst_null    
            //  2247: iload           5
            //  2249: i2l            
            //  2250: aload           6
            //  2252: iconst_3       
            //  2253: aload           4
            //  2255: ldc_w           9
            //  2258: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2261: invokespecial   instrumented/java/util/Formatter$FormatSpecifier.localizedMagnitude:(Ljava/lang/StringBuilder;JLinstrumented/java/util/Formatter$Flags;ILinstrumented/java/util/Locale;)Ljava/lang/StringBuilder;
            //  2264: ldc             1
            //  2266: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2269: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
            //  2272: pop            
            //  2273: ldc             1
            //  2275: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2278: ldc             1
            //  2280: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2283: goto            3151
            //  2286: aload_2        
            //  2287: getstatic       java/time/temporal/ChronoField.MONTH_OF_YEAR:Ljava/time/temporal/ChronoField;
            //  2290: ldc             3
            //  2292: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2295: invokeinterface java/time/temporal/TemporalAccessor.get:(Ljava/time/temporal/TemporalField;)I
            //  2300: istore          5
            //  2302: ldc             1
            //  2304: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2307: getstatic       instrumented/java/util/Formatter$Flags.ZERO_PAD:Linstrumented/java/util/Formatter$Flags;
            //  2310: astore          6
            //  2312: ldc             2
            //  2314: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2317: aload_1        
            //  2318: aload_0        
            //  2319: aconst_null    
            //  2320: iload           5
            //  2322: i2l            
            //  2323: aload           6
            //  2325: iconst_2       
            //  2326: aload           4
            //  2328: ldc_w           9
            //  2331: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2334: invokespecial   instrumented/java/util/Formatter$FormatSpecifier.localizedMagnitude:(Ljava/lang/StringBuilder;JLinstrumented/java/util/Formatter$Flags;ILinstrumented/java/util/Locale;)Ljava/lang/StringBuilder;
            //  2337: ldc             1
            //  2339: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2342: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
            //  2345: pop            
            //  2346: ldc             1
            //  2348: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2351: ldc             1
            //  2353: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2356: goto            3151
            //  2359: bipush          58
            //  2361: istore          5
            //  2363: ldc             2
            //  2365: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2368: aload_0        
            //  2369: aload_1        
            //  2370: aload_2        
            //  2371: bipush          72
            //  2373: aload           4
            //  2375: ldc_w           6
            //  2378: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2381: invokespecial   instrumented/java/util/Formatter$FormatSpecifier.print:(Ljava/lang/StringBuilder;Ljava/time/temporal/TemporalAccessor;CLinstrumented/java/util/Locale;)Ljava/lang/Appendable;
            //  2384: iload           5
            //  2386: ldc             2
            //  2388: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2391: invokeinterface java/lang/Appendable.append:(C)Ljava/lang/Appendable;
            //  2396: pop            
            //  2397: ldc             1
            //  2399: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2402: aload_0        
            //  2403: aload_1        
            //  2404: aload_2        
            //  2405: bipush          77
            //  2407: aload           4
            //  2409: ldc_w           6
            //  2412: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2415: invokespecial   instrumented/java/util/Formatter$FormatSpecifier.print:(Ljava/lang/StringBuilder;Ljava/time/temporal/TemporalAccessor;CLinstrumented/java/util/Locale;)Ljava/lang/Appendable;
            //  2418: pop            
            //  2419: ldc             1
            //  2421: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2424: iload_3        
            //  2425: bipush          84
            //  2427: ldc             3
            //  2429: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2432: if_icmpne       3151
            //  2435: aload_1        
            //  2436: iload           5
            //  2438: ldc             3
            //  2440: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2443: invokevirtual   java/lang/StringBuilder.append:(C)Ljava/lang/StringBuilder;
            //  2446: pop            
            //  2447: ldc             1
            //  2449: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2452: aload_0        
            //  2453: aload_1        
            //  2454: aload_2        
            //  2455: bipush          83
            //  2457: aload           4
            //  2459: ldc_w           6
            //  2462: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2465: invokespecial   instrumented/java/util/Formatter$FormatSpecifier.print:(Ljava/lang/StringBuilder;Ljava/time/temporal/TemporalAccessor;CLinstrumented/java/util/Locale;)Ljava/lang/Appendable;
            //  2468: pop            
            //  2469: ldc             2
            //  2471: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2474: goto            3151
            //  2477: bipush          58
            //  2479: istore          5
            //  2481: ldc             2
            //  2483: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2486: aload_0        
            //  2487: aload_1        
            //  2488: aload_2        
            //  2489: bipush          73
            //  2491: aload           4
            //  2493: ldc_w           6
            //  2496: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2499: invokespecial   instrumented/java/util/Formatter$FormatSpecifier.print:(Ljava/lang/StringBuilder;Ljava/time/temporal/TemporalAccessor;CLinstrumented/java/util/Locale;)Ljava/lang/Appendable;
            //  2502: iload           5
            //  2504: ldc             2
            //  2506: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2509: invokeinterface java/lang/Appendable.append:(C)Ljava/lang/Appendable;
            //  2514: pop            
            //  2515: ldc             1
            //  2517: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2520: aload_0        
            //  2521: aload_1        
            //  2522: aload_2        
            //  2523: bipush          77
            //  2525: aload           4
            //  2527: ldc_w           6
            //  2530: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2533: invokespecial   instrumented/java/util/Formatter$FormatSpecifier.print:(Ljava/lang/StringBuilder;Ljava/time/temporal/TemporalAccessor;CLinstrumented/java/util/Locale;)Ljava/lang/Appendable;
            //  2536: iload           5
            //  2538: ldc             2
            //  2540: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2543: invokeinterface java/lang/Appendable.append:(C)Ljava/lang/Appendable;
            //  2548: pop            
            //  2549: ldc             1
            //  2551: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2554: aload_0        
            //  2555: aload_1        
            //  2556: aload_2        
            //  2557: bipush          83
            //  2559: aload           4
            //  2561: ldc_w           6
            //  2564: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2567: invokespecial   instrumented/java/util/Formatter$FormatSpecifier.print:(Ljava/lang/StringBuilder;Ljava/time/temporal/TemporalAccessor;CLinstrumented/java/util/Locale;)Ljava/lang/Appendable;
            //  2570: bipush          32
            //  2572: ldc             2
            //  2574: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2577: invokeinterface java/lang/Appendable.append:(C)Ljava/lang/Appendable;
            //  2582: pop            
            //  2583: ldc             1
            //  2585: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2588: new             Ljava/lang/StringBuilder;
            //  2591: dup            
            //  2592: ldc             3
            //  2594: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2597: invokespecial   java/lang/StringBuilder.<init>:()V
            //  2600: astore          6
            //  2602: ldc             1
            //  2604: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2607: aload_0        
            //  2608: aload           6
            //  2610: aload_2        
            //  2611: bipush          112
            //  2613: aload           4
            //  2615: ldc_w           6
            //  2618: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2621: invokespecial   instrumented/java/util/Formatter$FormatSpecifier.print:(Ljava/lang/StringBuilder;Ljava/time/temporal/TemporalAccessor;CLinstrumented/java/util/Locale;)Ljava/lang/Appendable;
            //  2624: pop            
            //  2625: ldc             1
            //  2627: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2630: aload_1        
            //  2631: aload           6
            //  2633: ldc             3
            //  2635: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2638: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
            //  2641: aload           4
            //  2643: ldc             2
            //  2645: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2648: ifnull          2661
            //  2651: aload           4
            //  2653: ldc             2
            //  2655: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2658: goto            2669
            //  2661: getstatic       instrumented/java/util/Locale.US:Linstrumented/java/util/Locale;
            //  2664: ldc             1
            //  2666: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2669: ldc             1
            //  2671: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2674: invokevirtual   java/lang/String.toUpperCase:(Linstrumented/java/util/Locale;)Ljava/lang/String;
            //  2677: ldc             1
            //  2679: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2682: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //  2685: pop            
            //  2686: ldc             1
            //  2688: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2691: ldc             1
            //  2693: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2696: goto            3151
            //  2699: bipush          32
            //  2701: istore          5
            //  2703: ldc             2
            //  2705: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2708: aload_0        
            //  2709: aload_1        
            //  2710: aload_2        
            //  2711: bipush          97
            //  2713: aload           4
            //  2715: ldc_w           6
            //  2718: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2721: invokespecial   instrumented/java/util/Formatter$FormatSpecifier.print:(Ljava/lang/StringBuilder;Ljava/time/temporal/TemporalAccessor;CLinstrumented/java/util/Locale;)Ljava/lang/Appendable;
            //  2724: iload           5
            //  2726: ldc             2
            //  2728: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2731: invokeinterface java/lang/Appendable.append:(C)Ljava/lang/Appendable;
            //  2736: pop            
            //  2737: ldc             1
            //  2739: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2742: aload_0        
            //  2743: aload_1        
            //  2744: aload_2        
            //  2745: bipush          98
            //  2747: aload           4
            //  2749: ldc_w           6
            //  2752: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2755: invokespecial   instrumented/java/util/Formatter$FormatSpecifier.print:(Ljava/lang/StringBuilder;Ljava/time/temporal/TemporalAccessor;CLinstrumented/java/util/Locale;)Ljava/lang/Appendable;
            //  2758: iload           5
            //  2760: ldc             2
            //  2762: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2765: invokeinterface java/lang/Appendable.append:(C)Ljava/lang/Appendable;
            //  2770: pop            
            //  2771: ldc             1
            //  2773: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2776: aload_0        
            //  2777: aload_1        
            //  2778: aload_2        
            //  2779: bipush          100
            //  2781: aload           4
            //  2783: ldc_w           6
            //  2786: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2789: invokespecial   instrumented/java/util/Formatter$FormatSpecifier.print:(Ljava/lang/StringBuilder;Ljava/time/temporal/TemporalAccessor;CLinstrumented/java/util/Locale;)Ljava/lang/Appendable;
            //  2792: iload           5
            //  2794: ldc             2
            //  2796: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2799: invokeinterface java/lang/Appendable.append:(C)Ljava/lang/Appendable;
            //  2804: pop            
            //  2805: ldc             1
            //  2807: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2810: aload_0        
            //  2811: aload_1        
            //  2812: aload_2        
            //  2813: bipush          84
            //  2815: aload           4
            //  2817: ldc_w           6
            //  2820: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2823: invokespecial   instrumented/java/util/Formatter$FormatSpecifier.print:(Ljava/lang/StringBuilder;Ljava/time/temporal/TemporalAccessor;CLinstrumented/java/util/Locale;)Ljava/lang/Appendable;
            //  2826: iload           5
            //  2828: ldc             2
            //  2830: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2833: invokeinterface java/lang/Appendable.append:(C)Ljava/lang/Appendable;
            //  2838: pop            
            //  2839: ldc             1
            //  2841: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2844: aload_0        
            //  2845: aload_1        
            //  2846: aload_2        
            //  2847: bipush          90
            //  2849: aload           4
            //  2851: ldc_w           6
            //  2854: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2857: invokespecial   instrumented/java/util/Formatter$FormatSpecifier.print:(Ljava/lang/StringBuilder;Ljava/time/temporal/TemporalAccessor;CLinstrumented/java/util/Locale;)Ljava/lang/Appendable;
            //  2860: iload           5
            //  2862: ldc             2
            //  2864: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2867: invokeinterface java/lang/Appendable.append:(C)Ljava/lang/Appendable;
            //  2872: pop            
            //  2873: ldc             1
            //  2875: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2878: aload_0        
            //  2879: aload_1        
            //  2880: aload_2        
            //  2881: bipush          89
            //  2883: aload           4
            //  2885: ldc_w           6
            //  2888: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2891: invokespecial   instrumented/java/util/Formatter$FormatSpecifier.print:(Ljava/lang/StringBuilder;Ljava/time/temporal/TemporalAccessor;CLinstrumented/java/util/Locale;)Ljava/lang/Appendable;
            //  2894: pop            
            //  2895: ldc             1
            //  2897: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2900: ldc             1
            //  2902: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2905: goto            3151
            //  2908: bipush          47
            //  2910: istore          5
            //  2912: ldc             2
            //  2914: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2917: aload_0        
            //  2918: aload_1        
            //  2919: aload_2        
            //  2920: bipush          109
            //  2922: aload           4
            //  2924: ldc_w           6
            //  2927: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2930: invokespecial   instrumented/java/util/Formatter$FormatSpecifier.print:(Ljava/lang/StringBuilder;Ljava/time/temporal/TemporalAccessor;CLinstrumented/java/util/Locale;)Ljava/lang/Appendable;
            //  2933: iload           5
            //  2935: ldc             2
            //  2937: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2940: invokeinterface java/lang/Appendable.append:(C)Ljava/lang/Appendable;
            //  2945: pop            
            //  2946: ldc             1
            //  2948: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2951: aload_0        
            //  2952: aload_1        
            //  2953: aload_2        
            //  2954: bipush          100
            //  2956: aload           4
            //  2958: ldc_w           6
            //  2961: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2964: invokespecial   instrumented/java/util/Formatter$FormatSpecifier.print:(Ljava/lang/StringBuilder;Ljava/time/temporal/TemporalAccessor;CLinstrumented/java/util/Locale;)Ljava/lang/Appendable;
            //  2967: iload           5
            //  2969: ldc             2
            //  2971: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2974: invokeinterface java/lang/Appendable.append:(C)Ljava/lang/Appendable;
            //  2979: pop            
            //  2980: ldc             1
            //  2982: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2985: aload_0        
            //  2986: aload_1        
            //  2987: aload_2        
            //  2988: bipush          121
            //  2990: aload           4
            //  2992: ldc_w           6
            //  2995: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  2998: invokespecial   instrumented/java/util/Formatter$FormatSpecifier.print:(Ljava/lang/StringBuilder;Ljava/time/temporal/TemporalAccessor;CLinstrumented/java/util/Locale;)Ljava/lang/Appendable;
            //  3001: pop            
            //  3002: ldc             1
            //  3004: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  3007: ldc             1
            //  3009: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  3012: goto            3151
            //  3015: bipush          45
            //  3017: istore          5
            //  3019: ldc             2
            //  3021: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  3024: aload_0        
            //  3025: aload_1        
            //  3026: aload_2        
            //  3027: bipush          89
            //  3029: aload           4
            //  3031: ldc_w           6
            //  3034: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  3037: invokespecial   instrumented/java/util/Formatter$FormatSpecifier.print:(Ljava/lang/StringBuilder;Ljava/time/temporal/TemporalAccessor;CLinstrumented/java/util/Locale;)Ljava/lang/Appendable;
            //  3040: iload           5
            //  3042: ldc             2
            //  3044: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  3047: invokeinterface java/lang/Appendable.append:(C)Ljava/lang/Appendable;
            //  3052: pop            
            //  3053: ldc             1
            //  3055: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  3058: aload_0        
            //  3059: aload_1        
            //  3060: aload_2        
            //  3061: bipush          109
            //  3063: aload           4
            //  3065: ldc_w           6
            //  3068: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  3071: invokespecial   instrumented/java/util/Formatter$FormatSpecifier.print:(Ljava/lang/StringBuilder;Ljava/time/temporal/TemporalAccessor;CLinstrumented/java/util/Locale;)Ljava/lang/Appendable;
            //  3074: iload           5
            //  3076: ldc             2
            //  3078: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  3081: invokeinterface java/lang/Appendable.append:(C)Ljava/lang/Appendable;
            //  3086: pop            
            //  3087: ldc             1
            //  3089: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  3092: aload_0        
            //  3093: aload_1        
            //  3094: aload_2        
            //  3095: bipush          100
            //  3097: aload           4
            //  3099: ldc_w           6
            //  3102: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  3105: invokespecial   instrumented/java/util/Formatter$FormatSpecifier.print:(Ljava/lang/StringBuilder;Ljava/time/temporal/TemporalAccessor;CLinstrumented/java/util/Locale;)Ljava/lang/Appendable;
            //  3108: pop            
            //  3109: ldc             1
            //  3111: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  3114: ldc             1
            //  3116: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  3119: goto            3151
            //  3122: getstatic       instrumented/java/util/Formatter$FormatSpecifier.$assertionsDisabled:Z
            //  3125: ldc             2
            //  3127: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  3130: ifne            3151
            //  3133: new             Ljava/lang/AssertionError;
            //  3136: dup            
            //  3137: ldc             3
            //  3139: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  3142: invokespecial   java/lang/AssertionError.<init>:()V
            //  3145: ldc             1
            //  3147: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  3150: athrow         
            //  3151: ldc             1
            //  3153: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  3156: goto            3194
            //  3159: astore          5
            //  3161: ldc             501
            //  3163: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  3166: new             Linstrumented/java/util/IllegalFormatConversionException;
            //  3169: dup            
            //  3170: iload_3        
            //  3171: aload_2        
            //  3172: ldc             5
            //  3174: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  3177: invokevirtual   java/lang/Object.getClass:()Ljava/lang/Class;
            //  3180: ldc             1
            //  3182: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  3185: invokespecial   instrumented/java/util/IllegalFormatConversionException.<init>:(CLjava/lang/Class;)V
            //  3188: ldc             1
            //  3190: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  3193: athrow         
            //  3194: aload_1        
            //  3195: ldc             2
            //  3197: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //  3200: areturn        
            //  3201: athrow         
            //  3202: athrow         
            //    Exceptions:
            //  throws java.io.IOException
            //    StackMapTable: 00 39 1B FB 00 FC 3F 3F 3F 3F FB 00 48 FB 00 4D FB 00 48 FB 00 62 FC 00 50 07 03 00 FF 00 2E 00 07 07 00 02 07 01 B5 07 01 6C 01 07 01 4E 07 03 00 07 00 3B 00 02 07 01 B5 07 00 3B FF 00 07 00 07 07 00 02 07 01 B5 07 01 6C 01 07 01 4E 07 03 00 07 00 3B 00 03 07 01 B5 07 00 3B 07 01 4E F9 00 1D FB 00 4A FB 00 48 FC 00 27 01 45 01 FF 00 1B 00 07 07 00 02 07 01 B5 07 01 6C 01 07 01 4E 01 01 00 01 07 01 B5 FF 00 06 00 07 07 00 02 07 01 B5 07 01 6C 01 07 01 4E 01 01 00 02 07 01 B5 01 21 F9 00 55 FC 00 42 07 03 4E FF 00 79 00 07 07 00 02 07 01 B5 07 01 6C 01 07 01 4E 07 03 4E 07 03 5F 00 04 07 01 B5 07 03 0B 01 01 FF 00 06 00 07 07 00 02 07 01 B5 07 01 6C 01 07 01 4E 07 03 4E 07 03 5F 00 05 07 01 B5 07 03 0B 01 01 07 01 4E FA 00 1D FA 00 20 FC 00 2E 01 46 07 01 4E FD 00 41 07 01 4E 07 02 F7 F8 00 23 FC 00 2B 01 46 07 01 4E FD 00 41 07 01 4E 07 02 F7 F8 00 23 FD 00 45 01 01 13 13 07 F9 00 34 FC 00 2A 01 47 07 00 14 FA 00 30 FB 00 48 FB 00 48 FB 00 75 FF 00 B7 00 07 07 00 02 07 01 B5 07 01 6C 01 07 01 4E 01 07 01 B5 00 02 07 01 B5 07 00 3B FF 00 07 00 07 07 00 02 07 01 B5 07 01 6C 01 07 01 4E 01 07 01 B5 00 03 07 01 B5 07 00 3B 07 01 4E F9 00 1D FB 00 D0 FB 00 6A FB 00 6A 1C 47 07 03 20 22 FF 00 06 00 00 00 01 07 00 57 FF 00 00 00 00 00 01 07 00 2F
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                           
            //  -----  -----  -----  -----  -------------------------------
            //  27     3202   3202   3203   Ljava/lang/VirtualMachineError;
            //  27     3151   3159   3194   Ljava/time/DateTimeException;
            //  0      3201   3201   3202   Any
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
        
        private void failMismatch(final Flags flags, final char c) {
            try {
                BytecodeManager.incBytecodes(2);
                final String string = flags.toString();
                BytecodeManager.incBytecodes(1);
                final String s = string;
                BytecodeManager.incBytecodes(5);
                final FormatFlagsConversionMismatchException ex = new FormatFlagsConversionMismatchException(s, c);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private void failConversion(final char c, final Object o) {
            try {
                BytecodeManager.incBytecodes(5);
                final Class<?> class1 = o.getClass();
                BytecodeManager.incBytecodes(1);
                final IllegalFormatConversionException ex = new IllegalFormatConversionException(c, class1);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private char getZero(final Locale locale) {
            try {
                BytecodeManager.incBytecodes(2);
                if (locale != null) {
                    final Formatter this$0 = Formatter.this;
                    BytecodeManager.incBytecodes(4);
                    final Locale locale2 = this$0.locale();
                    BytecodeManager.incBytecodes(1);
                    final boolean equals = locale.equals(locale2);
                    BytecodeManager.incBytecodes(1);
                    if (!equals) {
                        BytecodeManager.incBytecodes(2);
                        final DecimalFormatSymbols instance = DecimalFormatSymbols.getInstance(locale);
                        BytecodeManager.incBytecodes(1);
                        final DecimalFormatSymbols decimalFormatSymbols = instance;
                        BytecodeManager.incBytecodes(2);
                        final char zeroDigit = decimalFormatSymbols.getZeroDigit();
                        BytecodeManager.incBytecodes(1);
                        return zeroDigit;
                    }
                }
                final Formatter this$2 = Formatter.this;
                BytecodeManager.incBytecodes(3);
                final char access$300 = Formatter.access$300(this$2);
                BytecodeManager.incBytecodes(1);
                return access$300;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private StringBuilder localizedMagnitude(final StringBuilder sb, final long i, final Flags flags, final int n, final Locale locale) {
            try {
                final int radix = 10;
                BytecodeManager.incBytecodes(3);
                final String string = Long.toString(i, radix);
                BytecodeManager.incBytecodes(1);
                final char[] charArray = string.toCharArray();
                BytecodeManager.incBytecodes(1);
                final char[] array = charArray;
                BytecodeManager.incBytecodes(7);
                final StringBuilder localizedMagnitude = this.localizedMagnitude(sb, array, flags, n, locale);
                BytecodeManager.incBytecodes(1);
                return localizedMagnitude;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private StringBuilder localizedMagnitude(StringBuilder sb, final char[] array, final Flags flags, final int n, final Locale locale) {
            try {
                final StringBuilder sb2 = sb;
                BytecodeManager.incBytecodes(2);
                if (sb2 == null) {
                    BytecodeManager.incBytecodes(3);
                    sb = new StringBuilder();
                    BytecodeManager.incBytecodes(1);
                }
                final StringBuilder sb3 = sb;
                BytecodeManager.incBytecodes(2);
                final int length = sb3.length();
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(3);
                final char zero = this.getZero(locale);
                BytecodeManager.incBytecodes(1);
                char groupingSeparator = '\0';
                BytecodeManager.incBytecodes(2);
                int groupingSize = -1;
                BytecodeManager.incBytecodes(2);
                char decimalSeparator = '\0';
                BytecodeManager.incBytecodes(2);
                final int length2 = array.length;
                BytecodeManager.incBytecodes(3);
                int n2 = length2;
                BytecodeManager.incBytecodes(2);
                int n3 = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n4 = n3;
                    final int n5 = length2;
                    BytecodeManager.incBytecodes(3);
                    if (n4 >= n5) {
                        break;
                    }
                    final char c = array[n3];
                    final int n6 = '.';
                    BytecodeManager.incBytecodes(5);
                    if (c == n6) {
                        n2 = n3;
                        BytecodeManager.incBytecodes(2);
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    ++n3;
                    BytecodeManager.incBytecodes(2);
                }
                final int n7 = n2;
                final int n8 = length2;
                BytecodeManager.incBytecodes(3);
                Label_0254: {
                    if (n7 < n8) {
                        BytecodeManager.incBytecodes(2);
                        if (locale != null) {
                            final Locale us = Locale.US;
                            BytecodeManager.incBytecodes(3);
                            final boolean equals = locale.equals(us);
                            BytecodeManager.incBytecodes(1);
                            if (!equals) {
                                BytecodeManager.incBytecodes(2);
                                final DecimalFormatSymbols instance = DecimalFormatSymbols.getInstance(locale);
                                BytecodeManager.incBytecodes(1);
                                final DecimalFormatSymbols decimalFormatSymbols = instance;
                                BytecodeManager.incBytecodes(2);
                                decimalSeparator = decimalFormatSymbols.getDecimalSeparator();
                                BytecodeManager.incBytecodes(1);
                                break Label_0254;
                            }
                        }
                        decimalSeparator = '.';
                        BytecodeManager.incBytecodes(3);
                    }
                }
                final Flags group = Flags.GROUP;
                BytecodeManager.incBytecodes(3);
                final boolean contains = flags.contains(group);
                BytecodeManager.incBytecodes(1);
                Label_0396: {
                    if (contains) {
                        BytecodeManager.incBytecodes(2);
                        if (locale != null) {
                            final Locale us2 = Locale.US;
                            BytecodeManager.incBytecodes(3);
                            final boolean equals2 = locale.equals(us2);
                            BytecodeManager.incBytecodes(1);
                            if (!equals2) {
                                BytecodeManager.incBytecodes(2);
                                final DecimalFormatSymbols instance2 = DecimalFormatSymbols.getInstance(locale);
                                BytecodeManager.incBytecodes(1);
                                final DecimalFormatSymbols decimalFormatSymbols2 = instance2;
                                BytecodeManager.incBytecodes(2);
                                groupingSeparator = decimalFormatSymbols2.getGroupingSeparator();
                                BytecodeManager.incBytecodes(1);
                                BytecodeManager.incBytecodes(2);
                                final DecimalFormat decimalFormat = (DecimalFormat)NumberFormat.getIntegerInstance(locale);
                                BytecodeManager.incBytecodes(2);
                                final DecimalFormat decimalFormat2 = decimalFormat;
                                BytecodeManager.incBytecodes(2);
                                groupingSize = decimalFormat2.getGroupingSize();
                                BytecodeManager.incBytecodes(1);
                                break Label_0396;
                            }
                        }
                        groupingSeparator = ',';
                        BytecodeManager.incBytecodes(2);
                        groupingSize = 3;
                        BytecodeManager.incBytecodes(3);
                    }
                }
                int n9 = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n10 = n9;
                    final int n11 = length2;
                    BytecodeManager.incBytecodes(3);
                    if (n10 >= n11) {
                        break;
                    }
                    final int n12 = n9;
                    final int n13 = n2;
                    BytecodeManager.incBytecodes(3);
                    if (n12 == n13) {
                        final StringBuilder sb4 = sb;
                        final char c2 = decimalSeparator;
                        BytecodeManager.incBytecodes(3);
                        sb4.append(c2);
                        BytecodeManager.incBytecodes(1);
                        groupingSeparator = '\0';
                        BytecodeManager.incBytecodes(2);
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        final char c3 = array[n9];
                        BytecodeManager.incBytecodes(4);
                        final StringBuilder sb5 = sb;
                        final char c4 = (char)(c3 - '0' + zero);
                        BytecodeManager.incBytecodes(8);
                        sb5.append(c4);
                        BytecodeManager.incBytecodes(1);
                        final char c5 = groupingSeparator;
                        BytecodeManager.incBytecodes(2);
                        if (c5 != '\0') {
                            final int n14 = n9;
                            final int n15 = n2 - 1;
                            BytecodeManager.incBytecodes(5);
                            if (n14 != n15) {
                                final int n16 = (n2 - n9) % groupingSize;
                                final int n17 = 1;
                                BytecodeManager.incBytecodes(7);
                                if (n16 == n17) {
                                    final StringBuilder sb6 = sb;
                                    final char c6 = groupingSeparator;
                                    BytecodeManager.incBytecodes(3);
                                    sb6.append(c6);
                                    BytecodeManager.incBytecodes(1);
                                }
                            }
                        }
                    }
                    ++n9;
                    BytecodeManager.incBytecodes(2);
                }
                final StringBuilder sb7 = sb;
                BytecodeManager.incBytecodes(2);
                final int length3 = sb7.length();
                BytecodeManager.incBytecodes(1);
                final int n18 = -1;
                BytecodeManager.incBytecodes(3);
                if (n != n18) {
                    final Flags zero_PAD = Flags.ZERO_PAD;
                    BytecodeManager.incBytecodes(3);
                    final boolean contains2 = flags.contains(zero_PAD);
                    BytecodeManager.incBytecodes(1);
                    if (contains2) {
                        int n19 = 0;
                        BytecodeManager.incBytecodes(2);
                        while (true) {
                            final int n20 = n19;
                            final int n21 = n - length3;
                            BytecodeManager.incBytecodes(5);
                            if (n20 >= n21) {
                                break;
                            }
                            final StringBuilder sb8 = sb;
                            final int offset = length;
                            final char c7 = zero;
                            BytecodeManager.incBytecodes(4);
                            sb8.insert(offset, c7);
                            BytecodeManager.incBytecodes(1);
                            ++n19;
                            BytecodeManager.incBytecodes(2);
                        }
                    }
                }
                final StringBuilder sb9 = sb;
                BytecodeManager.incBytecodes(2);
                return sb9;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static {
            try {
                final Class<Formatter> clazz = Formatter.class;
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
                BytecodeManager.incBytecodes(2);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private class BigDecimalLayout
        {
            private StringBuilder mant;
            private StringBuilder exp;
            private boolean dot;
            private int scale;
            
            public BigDecimalLayout(final BigInteger bigInteger, final int n, final BigDecimalLayoutForm bigDecimalLayoutForm) {
                try {
                    BytecodeManager.incBytecodes(5);
                    this.dot = false;
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(5);
                    this.layout(bigInteger, n, bigDecimalLayoutForm);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            public boolean hasDot() {
                try {
                    final boolean dot = this.dot;
                    BytecodeManager.incBytecodes(3);
                    return dot;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            public int scale() {
                try {
                    final int scale = this.scale;
                    BytecodeManager.incBytecodes(3);
                    return scale;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            public char[] layoutChars() {
                try {
                    final StringBuilder mant = this.mant;
                    BytecodeManager.incBytecodes(5);
                    final StringBuilder sb = new StringBuilder(mant);
                    BytecodeManager.incBytecodes(1);
                    final StringBuilder exp = this.exp;
                    BytecodeManager.incBytecodes(3);
                    if (exp != null) {
                        final StringBuilder sb2 = sb;
                        final char c = 'E';
                        BytecodeManager.incBytecodes(3);
                        sb2.append(c);
                        BytecodeManager.incBytecodes(1);
                        final StringBuilder sb3 = sb;
                        final StringBuilder exp2 = this.exp;
                        BytecodeManager.incBytecodes(4);
                        sb3.append((CharSequence)exp2);
                        BytecodeManager.incBytecodes(1);
                    }
                    final StringBuilder sb4 = sb;
                    BytecodeManager.incBytecodes(3);
                    final char[] charArray = this.toCharArray(sb4);
                    BytecodeManager.incBytecodes(1);
                    return charArray;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            public char[] mantissa() {
                try {
                    final StringBuilder mant = this.mant;
                    BytecodeManager.incBytecodes(4);
                    final char[] charArray = this.toCharArray(mant);
                    BytecodeManager.incBytecodes(1);
                    return charArray;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            public char[] exponent() {
                try {
                    final StringBuilder exp = this.exp;
                    BytecodeManager.incBytecodes(4);
                    final char[] charArray = this.toCharArray(exp);
                    BytecodeManager.incBytecodes(1);
                    return charArray;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            private char[] toCharArray(final StringBuilder sb) {
                try {
                    BytecodeManager.incBytecodes(2);
                    if (sb == null) {
                        final char[] array = null;
                        BytecodeManager.incBytecodes(2);
                        return array;
                    }
                    BytecodeManager.incBytecodes(2);
                    final char[] array2 = new char[sb.length()];
                    BytecodeManager.incBytecodes(1);
                    final int n = 0;
                    final int length = array2.length;
                    final char[] array3 = array2;
                    final int n2 = 0;
                    BytecodeManager.incBytecodes(7);
                    sb.getChars(n, length, array3, n2);
                    final char[] array4 = array2;
                    BytecodeManager.incBytecodes(2);
                    return array4;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            private void layout(final BigInteger bigInteger, final int n, final BigDecimalLayoutForm bigDecimalLayoutForm) {
                try {
                    BytecodeManager.incBytecodes(2);
                    final String string = bigInteger.toString();
                    BytecodeManager.incBytecodes(1);
                    final char[] charArray = string.toCharArray();
                    BytecodeManager.incBytecodes(1);
                    this.scale = n;
                    BytecodeManager.incBytecodes(3);
                    final int capacity = charArray.length + 14;
                    BytecodeManager.incBytecodes(8);
                    this.mant = new StringBuilder(capacity);
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(2);
                    if (n == 0) {
                        final int length = charArray.length;
                        BytecodeManager.incBytecodes(3);
                        final int n2 = length;
                        final int n3 = 1;
                        BytecodeManager.incBytecodes(3);
                        if (n2 > n3) {
                            final StringBuilder mant = this.mant;
                            final char c = charArray[0];
                            BytecodeManager.incBytecodes(6);
                            mant.append(c);
                            BytecodeManager.incBytecodes(1);
                            final BigDecimalLayoutForm scientific = BigDecimalLayoutForm.SCIENTIFIC;
                            BytecodeManager.incBytecodes(3);
                            if (bigDecimalLayoutForm == scientific) {
                                final StringBuilder mant2 = this.mant;
                                final char c2 = '.';
                                BytecodeManager.incBytecodes(4);
                                mant2.append(c2);
                                BytecodeManager.incBytecodes(1);
                                this.dot = true;
                                BytecodeManager.incBytecodes(3);
                                final StringBuilder mant3 = this.mant;
                                final char[] str = charArray;
                                final int offset = 1;
                                final int len = length - 1;
                                BytecodeManager.incBytecodes(8);
                                mant3.append(str, offset, len);
                                BytecodeManager.incBytecodes(1);
                                final String str2 = "+";
                                BytecodeManager.incBytecodes(5);
                                this.exp = new StringBuilder(str2);
                                BytecodeManager.incBytecodes(1);
                                final int n4 = length;
                                final int n5 = 10;
                                BytecodeManager.incBytecodes(3);
                                if (n4 < n5) {
                                    final StringBuilder exp = this.exp;
                                    final String str3 = "0";
                                    BytecodeManager.incBytecodes(4);
                                    final StringBuilder append = exp.append(str3);
                                    final int i = length - 1;
                                    BytecodeManager.incBytecodes(4);
                                    append.append(i);
                                    BytecodeManager.incBytecodes(2);
                                }
                                else {
                                    final StringBuilder exp2 = this.exp;
                                    final int j = length - 1;
                                    BytecodeManager.incBytecodes(6);
                                    exp2.append(j);
                                    BytecodeManager.incBytecodes(2);
                                }
                            }
                            else {
                                final StringBuilder mant4 = this.mant;
                                final char[] str4 = charArray;
                                final int offset2 = 1;
                                final int len2 = length - 1;
                                BytecodeManager.incBytecodes(8);
                                mant4.append(str4, offset2, len2);
                                BytecodeManager.incBytecodes(2);
                            }
                        }
                        else {
                            final StringBuilder mant5 = this.mant;
                            final char[] str5 = charArray;
                            BytecodeManager.incBytecodes(4);
                            mant5.append(str5);
                            BytecodeManager.incBytecodes(1);
                            final BigDecimalLayoutForm scientific2 = BigDecimalLayoutForm.SCIENTIFIC;
                            BytecodeManager.incBytecodes(3);
                            if (bigDecimalLayoutForm == scientific2) {
                                final String str6 = "+00";
                                BytecodeManager.incBytecodes(5);
                                this.exp = new StringBuilder(str6);
                                BytecodeManager.incBytecodes(1);
                            }
                        }
                        BytecodeManager.incBytecodes(1);
                        return;
                    }
                    final long n6 = -n + (long)(charArray.length - 1);
                    BytecodeManager.incBytecodes(10);
                    final BigDecimalLayoutForm decimal_FLOAT = BigDecimalLayoutForm.DECIMAL_FLOAT;
                    BytecodeManager.incBytecodes(3);
                    if (bigDecimalLayoutForm == decimal_FLOAT) {
                        int n7 = n - charArray.length;
                        BytecodeManager.incBytecodes(5);
                        final int n8 = n7;
                        BytecodeManager.incBytecodes(2);
                        if (n8 >= 0) {
                            final StringBuilder mant6 = this.mant;
                            final String str7 = "0.";
                            BytecodeManager.incBytecodes(4);
                            mant6.append(str7);
                            BytecodeManager.incBytecodes(1);
                            this.dot = true;
                            BytecodeManager.incBytecodes(3);
                            while (true) {
                                final int n9 = n7;
                                BytecodeManager.incBytecodes(2);
                                if (n9 <= 0) {
                                    break;
                                }
                                final StringBuilder mant7 = this.mant;
                                final char c3 = '0';
                                BytecodeManager.incBytecodes(4);
                                mant7.append(c3);
                                --n7;
                                BytecodeManager.incBytecodes(3);
                            }
                            final StringBuilder mant8 = this.mant;
                            final char[] str8 = charArray;
                            BytecodeManager.incBytecodes(4);
                            mant8.append(str8);
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            final int n10 = -n7;
                            final int length2 = charArray.length;
                            BytecodeManager.incBytecodes(5);
                            if (n10 < length2) {
                                final StringBuilder mant9 = this.mant;
                                final char[] str9 = charArray;
                                final int offset3 = 0;
                                final int len3 = -n7;
                                BytecodeManager.incBytecodes(7);
                                mant9.append(str9, offset3, len3);
                                BytecodeManager.incBytecodes(1);
                                final StringBuilder mant10 = this.mant;
                                final char c4 = '.';
                                BytecodeManager.incBytecodes(4);
                                mant10.append(c4);
                                BytecodeManager.incBytecodes(1);
                                this.dot = true;
                                BytecodeManager.incBytecodes(3);
                                final StringBuilder mant11 = this.mant;
                                final char[] str10 = charArray;
                                final int offset4 = -n7;
                                BytecodeManager.incBytecodes(7);
                                mant11.append(str10, offset4, n);
                                BytecodeManager.incBytecodes(2);
                            }
                            else {
                                final StringBuilder mant12 = this.mant;
                                final char[] str11 = charArray;
                                final int offset5 = 0;
                                final int length3 = charArray.length;
                                BytecodeManager.incBytecodes(7);
                                mant12.append(str11, offset5, length3);
                                BytecodeManager.incBytecodes(1);
                                int n11 = 0;
                                BytecodeManager.incBytecodes(2);
                                while (true) {
                                    final int n12 = n11;
                                    final int n13 = -n;
                                    BytecodeManager.incBytecodes(4);
                                    if (n12 >= n13) {
                                        break;
                                    }
                                    final StringBuilder mant13 = this.mant;
                                    final char c5 = '0';
                                    BytecodeManager.incBytecodes(4);
                                    mant13.append(c5);
                                    BytecodeManager.incBytecodes(1);
                                    ++n11;
                                    BytecodeManager.incBytecodes(2);
                                }
                                this.scale = 0;
                                BytecodeManager.incBytecodes(3);
                            }
                        }
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        final StringBuilder mant14 = this.mant;
                        final char c6 = charArray[0];
                        BytecodeManager.incBytecodes(6);
                        mant14.append(c6);
                        BytecodeManager.incBytecodes(1);
                        final int length4 = charArray.length;
                        final int n14 = 1;
                        BytecodeManager.incBytecodes(4);
                        if (length4 > n14) {
                            final StringBuilder mant15 = this.mant;
                            final char c7 = '.';
                            BytecodeManager.incBytecodes(4);
                            mant15.append(c7);
                            BytecodeManager.incBytecodes(1);
                            this.dot = true;
                            BytecodeManager.incBytecodes(3);
                            final StringBuilder mant16 = this.mant;
                            final char[] str12 = charArray;
                            final int offset6 = 1;
                            final int len4 = charArray.length - 1;
                            BytecodeManager.incBytecodes(9);
                            mant16.append(str12, offset6, len4);
                            BytecodeManager.incBytecodes(1);
                        }
                        BytecodeManager.incBytecodes(4);
                        this.exp = new StringBuilder();
                        BytecodeManager.incBytecodes(1);
                        final long n15 = lcmp(n6, 0L);
                        BytecodeManager.incBytecodes(4);
                        if (n15 != 0) {
                            final long a = n6;
                            BytecodeManager.incBytecodes(2);
                            final long abs = Math.abs(a);
                            BytecodeManager.incBytecodes(1);
                            final StringBuilder exp3 = this.exp;
                            final long n16 = lcmp(n6, 0L);
                            BytecodeManager.incBytecodes(6);
                            char c8;
                            if (n16 < 0) {
                                c8 = '-';
                                BytecodeManager.incBytecodes(2);
                            }
                            else {
                                c8 = '+';
                                BytecodeManager.incBytecodes(1);
                            }
                            BytecodeManager.incBytecodes(1);
                            exp3.append(c8);
                            BytecodeManager.incBytecodes(1);
                            final long n17 = lcmp(abs, 10L);
                            BytecodeManager.incBytecodes(4);
                            if (n17 < 0) {
                                final StringBuilder exp4 = this.exp;
                                final char c9 = '0';
                                BytecodeManager.incBytecodes(4);
                                exp4.append(c9);
                                BytecodeManager.incBytecodes(1);
                            }
                            final StringBuilder exp5 = this.exp;
                            final long lng = abs;
                            BytecodeManager.incBytecodes(4);
                            exp5.append(lng);
                            BytecodeManager.incBytecodes(1);
                            BytecodeManager.incBytecodes(1);
                        }
                        else {
                            final StringBuilder exp6 = this.exp;
                            final String str13 = "+00";
                            BytecodeManager.incBytecodes(4);
                            exp6.append(str13);
                            BytecodeManager.incBytecodes(1);
                        }
                    }
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
    }
    
    private static class Flags
    {
        private int flags;
        static final Flags NONE;
        static final Flags LEFT_JUSTIFY;
        static final Flags UPPERCASE;
        static final Flags ALTERNATE;
        static final Flags PLUS;
        static final Flags LEADING_SPACE;
        static final Flags ZERO_PAD;
        static final Flags GROUP;
        static final Flags PARENTHESES;
        static final Flags PREVIOUS;
        
        private Flags(final int flags) {
            try {
                BytecodeManager.incBytecodes(2);
                this.flags = flags;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public int valueOf() {
            try {
                final int flags = this.flags;
                BytecodeManager.incBytecodes(3);
                return flags;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public boolean contains(final Flags flags) {
            try {
                final int flags2 = this.flags;
                BytecodeManager.incBytecodes(4);
                final int n = flags2 & flags.valueOf();
                BytecodeManager.incBytecodes(3);
                final int value = flags.valueOf();
                BytecodeManager.incBytecodes(1);
                boolean b;
                if (n == value) {
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
        
        public Flags dup() {
            try {
                final int flags = this.flags;
                BytecodeManager.incBytecodes(5);
                final Flags flags2 = new Flags(flags);
                BytecodeManager.incBytecodes(1);
                return flags2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private Flags add(final Flags flags) {
            try {
                final int flags2 = this.flags;
                BytecodeManager.incBytecodes(5);
                this.flags = (flags2 | flags.valueOf());
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(2);
                return this;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public Flags remove(final Flags flags) {
            try {
                final int flags2 = this.flags;
                BytecodeManager.incBytecodes(5);
                this.flags = (flags2 & ~flags.valueOf());
                BytecodeManager.incBytecodes(4);
                BytecodeManager.incBytecodes(2);
                return this;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public static Flags parse(final String s) {
            try {
                BytecodeManager.incBytecodes(2);
                final char[] charArray = s.toCharArray();
                BytecodeManager.incBytecodes(1);
                final int n = 0;
                BytecodeManager.incBytecodes(4);
                final Flags flags = new Flags(n);
                BytecodeManager.incBytecodes(1);
                int n2 = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n3 = n2;
                    final int length = charArray.length;
                    BytecodeManager.incBytecodes(4);
                    if (n3 >= length) {
                        final Flags flags2 = flags;
                        BytecodeManager.incBytecodes(2);
                        return flags2;
                    }
                    final char c = charArray[n2];
                    BytecodeManager.incBytecodes(4);
                    final Flags parse = parse(c);
                    BytecodeManager.incBytecodes(1);
                    final Flags flags3 = flags;
                    final Flags flags4 = parse;
                    BytecodeManager.incBytecodes(3);
                    final boolean contains = flags3.contains(flags4);
                    BytecodeManager.incBytecodes(1);
                    if (contains) {
                        final Flags flags5 = parse;
                        BytecodeManager.incBytecodes(4);
                        final String string = flags5.toString();
                        BytecodeManager.incBytecodes(1);
                        final DuplicateFormatFlagsException ex = new DuplicateFormatFlagsException(string);
                        BytecodeManager.incBytecodes(1);
                        throw ex;
                    }
                    final Flags flags6 = flags;
                    final Flags flags7 = parse;
                    BytecodeManager.incBytecodes(3);
                    flags6.add(flags7);
                    BytecodeManager.incBytecodes(1);
                    ++n2;
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private static Flags parse(final char c) {
            try {
                BytecodeManager.incBytecodes(2);
                switch (c) {
                    case '-': {
                        final Flags left_JUSTIFY = Flags.LEFT_JUSTIFY;
                        BytecodeManager.incBytecodes(2);
                        return left_JUSTIFY;
                    }
                    case '#': {
                        final Flags alternate = Flags.ALTERNATE;
                        BytecodeManager.incBytecodes(2);
                        return alternate;
                    }
                    case '+': {
                        final Flags plus = Flags.PLUS;
                        BytecodeManager.incBytecodes(2);
                        return plus;
                    }
                    case ' ': {
                        final Flags leading_SPACE = Flags.LEADING_SPACE;
                        BytecodeManager.incBytecodes(2);
                        return leading_SPACE;
                    }
                    case '0': {
                        final Flags zero_PAD = Flags.ZERO_PAD;
                        BytecodeManager.incBytecodes(2);
                        return zero_PAD;
                    }
                    case ',': {
                        final Flags group = Flags.GROUP;
                        BytecodeManager.incBytecodes(2);
                        return group;
                    }
                    case '(': {
                        final Flags parentheses = Flags.PARENTHESES;
                        BytecodeManager.incBytecodes(2);
                        return parentheses;
                    }
                    case '<': {
                        final Flags previous = Flags.PREVIOUS;
                        BytecodeManager.incBytecodes(2);
                        return previous;
                    }
                    default: {
                        BytecodeManager.incBytecodes(4);
                        final String value = String.valueOf(c);
                        BytecodeManager.incBytecodes(1);
                        final UnknownFormatFlagsException ex = new UnknownFormatFlagsException(value);
                        BytecodeManager.incBytecodes(1);
                        throw ex;
                    }
                }
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public static String toString(final Flags flags) {
            try {
                BytecodeManager.incBytecodes(2);
                final String string = flags.toString();
                BytecodeManager.incBytecodes(1);
                return string;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public String toString() {
            try {
                BytecodeManager.incBytecodes(3);
                final StringBuilder sb = new StringBuilder();
                BytecodeManager.incBytecodes(1);
                final Flags left_JUSTIFY = Flags.LEFT_JUSTIFY;
                BytecodeManager.incBytecodes(3);
                final boolean contains = this.contains(left_JUSTIFY);
                BytecodeManager.incBytecodes(1);
                if (contains) {
                    final StringBuilder sb2 = sb;
                    final char c = '-';
                    BytecodeManager.incBytecodes(3);
                    sb2.append(c);
                    BytecodeManager.incBytecodes(1);
                }
                final Flags uppercase = Flags.UPPERCASE;
                BytecodeManager.incBytecodes(3);
                final boolean contains2 = this.contains(uppercase);
                BytecodeManager.incBytecodes(1);
                if (contains2) {
                    final StringBuilder sb3 = sb;
                    final char c2 = '^';
                    BytecodeManager.incBytecodes(3);
                    sb3.append(c2);
                    BytecodeManager.incBytecodes(1);
                }
                final Flags alternate = Flags.ALTERNATE;
                BytecodeManager.incBytecodes(3);
                final boolean contains3 = this.contains(alternate);
                BytecodeManager.incBytecodes(1);
                if (contains3) {
                    final StringBuilder sb4 = sb;
                    final char c3 = '#';
                    BytecodeManager.incBytecodes(3);
                    sb4.append(c3);
                    BytecodeManager.incBytecodes(1);
                }
                final Flags plus = Flags.PLUS;
                BytecodeManager.incBytecodes(3);
                final boolean contains4 = this.contains(plus);
                BytecodeManager.incBytecodes(1);
                if (contains4) {
                    final StringBuilder sb5 = sb;
                    final char c4 = '+';
                    BytecodeManager.incBytecodes(3);
                    sb5.append(c4);
                    BytecodeManager.incBytecodes(1);
                }
                final Flags leading_SPACE = Flags.LEADING_SPACE;
                BytecodeManager.incBytecodes(3);
                final boolean contains5 = this.contains(leading_SPACE);
                BytecodeManager.incBytecodes(1);
                if (contains5) {
                    final StringBuilder sb6 = sb;
                    final char c5 = ' ';
                    BytecodeManager.incBytecodes(3);
                    sb6.append(c5);
                    BytecodeManager.incBytecodes(1);
                }
                final Flags zero_PAD = Flags.ZERO_PAD;
                BytecodeManager.incBytecodes(3);
                final boolean contains6 = this.contains(zero_PAD);
                BytecodeManager.incBytecodes(1);
                if (contains6) {
                    final StringBuilder sb7 = sb;
                    final char c6 = '0';
                    BytecodeManager.incBytecodes(3);
                    sb7.append(c6);
                    BytecodeManager.incBytecodes(1);
                }
                final Flags group = Flags.GROUP;
                BytecodeManager.incBytecodes(3);
                final boolean contains7 = this.contains(group);
                BytecodeManager.incBytecodes(1);
                if (contains7) {
                    final StringBuilder sb8 = sb;
                    final char c7 = ',';
                    BytecodeManager.incBytecodes(3);
                    sb8.append(c7);
                    BytecodeManager.incBytecodes(1);
                }
                final Flags parentheses = Flags.PARENTHESES;
                BytecodeManager.incBytecodes(3);
                final boolean contains8 = this.contains(parentheses);
                BytecodeManager.incBytecodes(1);
                if (contains8) {
                    final StringBuilder sb9 = sb;
                    final char c8 = '(';
                    BytecodeManager.incBytecodes(3);
                    sb9.append(c8);
                    BytecodeManager.incBytecodes(1);
                }
                final Flags previous = Flags.PREVIOUS;
                BytecodeManager.incBytecodes(3);
                final boolean contains9 = this.contains(previous);
                BytecodeManager.incBytecodes(1);
                if (contains9) {
                    final StringBuilder sb10 = sb;
                    final char c9 = '<';
                    BytecodeManager.incBytecodes(3);
                    sb10.append(c9);
                    BytecodeManager.incBytecodes(1);
                }
                final StringBuilder sb11 = sb;
                BytecodeManager.incBytecodes(2);
                final String string = sb11.toString();
                BytecodeManager.incBytecodes(1);
                return string;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static /* synthetic */ Flags access$100(final Flags flags, final Flags flags2) {
            try {
                BytecodeManager.incBytecodes(3);
                final Flags add = flags.add(flags2);
                BytecodeManager.incBytecodes(1);
                return add;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static {
            try {
                final int n = 0;
                BytecodeManager.incBytecodes(4);
                NONE = new Flags(n);
                BytecodeManager.incBytecodes(1);
                final int n2 = 1;
                BytecodeManager.incBytecodes(4);
                LEFT_JUSTIFY = new Flags(n2);
                BytecodeManager.incBytecodes(1);
                final int n3 = 2;
                BytecodeManager.incBytecodes(4);
                UPPERCASE = new Flags(n3);
                BytecodeManager.incBytecodes(1);
                final int n4 = 4;
                BytecodeManager.incBytecodes(4);
                ALTERNATE = new Flags(n4);
                BytecodeManager.incBytecodes(1);
                final int n5 = 8;
                BytecodeManager.incBytecodes(4);
                PLUS = new Flags(n5);
                BytecodeManager.incBytecodes(1);
                final int n6 = 16;
                BytecodeManager.incBytecodes(4);
                LEADING_SPACE = new Flags(n6);
                BytecodeManager.incBytecodes(1);
                final int n7 = 32;
                BytecodeManager.incBytecodes(4);
                ZERO_PAD = new Flags(n7);
                BytecodeManager.incBytecodes(1);
                final int n8 = 64;
                BytecodeManager.incBytecodes(4);
                GROUP = new Flags(n8);
                BytecodeManager.incBytecodes(1);
                final int n9 = 128;
                BytecodeManager.incBytecodes(4);
                PARENTHESES = new Flags(n9);
                BytecodeManager.incBytecodes(1);
                final int n10 = 256;
                BytecodeManager.incBytecodes(4);
                PREVIOUS = new Flags(n10);
                BytecodeManager.incBytecodes(2);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private static class Conversion
    {
        static final char DECIMAL_INTEGER = 'd';
        static final char OCTAL_INTEGER = 'o';
        static final char HEXADECIMAL_INTEGER = 'x';
        static final char HEXADECIMAL_INTEGER_UPPER = 'X';
        static final char SCIENTIFIC = 'e';
        static final char SCIENTIFIC_UPPER = 'E';
        static final char GENERAL = 'g';
        static final char GENERAL_UPPER = 'G';
        static final char DECIMAL_FLOAT = 'f';
        static final char HEXADECIMAL_FLOAT = 'a';
        static final char HEXADECIMAL_FLOAT_UPPER = 'A';
        static final char CHARACTER = 'c';
        static final char CHARACTER_UPPER = 'C';
        static final char DATE_TIME = 't';
        static final char DATE_TIME_UPPER = 'T';
        static final char BOOLEAN = 'b';
        static final char BOOLEAN_UPPER = 'B';
        static final char STRING = 's';
        static final char STRING_UPPER = 'S';
        static final char HASHCODE = 'h';
        static final char HASHCODE_UPPER = 'H';
        static final char LINE_SEPARATOR = 'n';
        static final char PERCENT_SIGN = '%';
        
        private Conversion() {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static boolean isValid(final char c) {
            try {
                BytecodeManager.incBytecodes(2);
                final boolean general = isGeneral(c);
                BytecodeManager.incBytecodes(1);
                boolean b = false;
                Label_0116: {
                    if (!general) {
                        BytecodeManager.incBytecodes(2);
                        final boolean integer = isInteger(c);
                        BytecodeManager.incBytecodes(1);
                        if (!integer) {
                            BytecodeManager.incBytecodes(2);
                            final boolean float1 = isFloat(c);
                            BytecodeManager.incBytecodes(1);
                            if (!float1) {
                                BytecodeManager.incBytecodes(2);
                                final boolean text = isText(c);
                                BytecodeManager.incBytecodes(1);
                                if (!text) {
                                    final char c2 = 't';
                                    BytecodeManager.incBytecodes(3);
                                    if (c != c2) {
                                        BytecodeManager.incBytecodes(1);
                                        BytecodeManager.incBytecodes(1);
                                        final boolean character = isCharacter(c);
                                        BytecodeManager.incBytecodes(1);
                                        if (!character) {
                                            b = false;
                                            BytecodeManager.incBytecodes(1);
                                            break Label_0116;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    b = true;
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(1);
                return b;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static boolean isGeneral(final char c) {
            try {
                BytecodeManager.incBytecodes(2);
                switch (c) {
                    case 'B':
                    case 'H':
                    case 'S':
                    case 'b':
                    case 'h':
                    case 's': {
                        final boolean b = true;
                        BytecodeManager.incBytecodes(2);
                        return b;
                    }
                    default: {
                        final boolean b2 = false;
                        BytecodeManager.incBytecodes(2);
                        return b2;
                    }
                }
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static boolean isCharacter(final char c) {
            try {
                BytecodeManager.incBytecodes(2);
                switch (c) {
                    case 'C':
                    case 'c': {
                        final boolean b = true;
                        BytecodeManager.incBytecodes(2);
                        return b;
                    }
                    default: {
                        final boolean b2 = false;
                        BytecodeManager.incBytecodes(2);
                        return b2;
                    }
                }
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static boolean isInteger(final char c) {
            try {
                BytecodeManager.incBytecodes(2);
                switch (c) {
                    case 'X':
                    case 'd':
                    case 'o':
                    case 'x': {
                        final boolean b = true;
                        BytecodeManager.incBytecodes(2);
                        return b;
                    }
                    default: {
                        final boolean b2 = false;
                        BytecodeManager.incBytecodes(2);
                        return b2;
                    }
                }
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static boolean isFloat(final char c) {
            try {
                BytecodeManager.incBytecodes(2);
                switch (c) {
                    case 'A':
                    case 'E':
                    case 'G':
                    case 'a':
                    case 'e':
                    case 'f':
                    case 'g': {
                        final boolean b = true;
                        BytecodeManager.incBytecodes(2);
                        return b;
                    }
                    default: {
                        final boolean b2 = false;
                        BytecodeManager.incBytecodes(2);
                        return b2;
                    }
                }
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static boolean isText(final char c) {
            try {
                BytecodeManager.incBytecodes(2);
                switch (c) {
                    case '%':
                    case 'n': {
                        final boolean b = true;
                        BytecodeManager.incBytecodes(2);
                        return b;
                    }
                    default: {
                        final boolean b2 = false;
                        BytecodeManager.incBytecodes(2);
                        return b2;
                    }
                }
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private static class DateTime
    {
        static final char HOUR_OF_DAY_0 = 'H';
        static final char HOUR_0 = 'I';
        static final char HOUR_OF_DAY = 'k';
        static final char HOUR = 'l';
        static final char MINUTE = 'M';
        static final char NANOSECOND = 'N';
        static final char MILLISECOND = 'L';
        static final char MILLISECOND_SINCE_EPOCH = 'Q';
        static final char AM_PM = 'p';
        static final char SECONDS_SINCE_EPOCH = 's';
        static final char SECOND = 'S';
        static final char TIME = 'T';
        static final char ZONE_NUMERIC = 'z';
        static final char ZONE = 'Z';
        static final char NAME_OF_DAY_ABBREV = 'a';
        static final char NAME_OF_DAY = 'A';
        static final char NAME_OF_MONTH_ABBREV = 'b';
        static final char NAME_OF_MONTH = 'B';
        static final char CENTURY = 'C';
        static final char DAY_OF_MONTH_0 = 'd';
        static final char DAY_OF_MONTH = 'e';
        static final char NAME_OF_MONTH_ABBREV_X = 'h';
        static final char DAY_OF_YEAR = 'j';
        static final char MONTH = 'm';
        static final char YEAR_2 = 'y';
        static final char YEAR_4 = 'Y';
        static final char TIME_12_HOUR = 'r';
        static final char TIME_24_HOUR = 'R';
        static final char DATE_TIME = 'c';
        static final char DATE = 'D';
        static final char ISO_STANDARD_DATE = 'F';
        
        private DateTime() {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static boolean isValid(final char c) {
            try {
                BytecodeManager.incBytecodes(2);
                switch (c) {
                    case 'A':
                    case 'B':
                    case 'C':
                    case 'D':
                    case 'F':
                    case 'H':
                    case 'I':
                    case 'L':
                    case 'M':
                    case 'N':
                    case 'Q':
                    case 'R':
                    case 'S':
                    case 'T':
                    case 'Y':
                    case 'Z':
                    case 'a':
                    case 'b':
                    case 'c':
                    case 'd':
                    case 'e':
                    case 'h':
                    case 'j':
                    case 'k':
                    case 'l':
                    case 'm':
                    case 'p':
                    case 'r':
                    case 's':
                    case 'y':
                    case 'z': {
                        final boolean b = true;
                        BytecodeManager.incBytecodes(2);
                        return b;
                    }
                    default: {
                        final boolean b2 = false;
                        BytecodeManager.incBytecodes(2);
                        return b2;
                    }
                }
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private interface FormatString
    {
        int index();
        
        void print(final Object p0, final Locale p1) throws IOException;
        
        String toString();
    }
}
