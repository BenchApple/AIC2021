// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.logging;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import aic2021.engine.BytecodeManager;

public abstract class Handler
{
    private static final int offValue;
    private final LogManager manager;
    private volatile Filter filter;
    private volatile Formatter formatter;
    private volatile Level logLevel;
    private volatile ErrorManager errorManager;
    private volatile String encoding;
    boolean sealed;
    
    protected Handler() {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            this.manager = LogManager.getLogManager();
            BytecodeManager.incBytecodes(1);
            this.logLevel = Level.ALL;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(4);
            this.errorManager = new ErrorManager();
            BytecodeManager.incBytecodes(1);
            this.sealed = true;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public abstract void publish(final LogRecord p0);
    
    public abstract void flush();
    
    public abstract void close() throws SecurityException;
    
    public synchronized void setFormatter(final Formatter formatter) throws SecurityException {
        try {
            BytecodeManager.incBytecodes(2);
            this.checkPermission();
            BytecodeManager.incBytecodes(2);
            formatter.getClass();
            BytecodeManager.incBytecodes(1);
            this.formatter = formatter;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Formatter getFormatter() {
        try {
            final Formatter formatter = this.formatter;
            BytecodeManager.incBytecodes(3);
            return formatter;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public synchronized void setEncoding(final String p0) throws SecurityException, UnsupportedEncodingException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             2
        //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     6: invokevirtual   instrumented/java/util/logging/Handler.checkPermission:()V
        //     9: aload_1        
        //    10: ldc             2
        //    12: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    15: ifnull          87
        //    18: aload_1        
        //    19: ldc             2
        //    21: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    24: invokestatic    java/nio/charset/Charset.isSupported:(Ljava/lang/String;)Z
        //    27: ldc             1
        //    29: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    32: ifne            54
        //    35: new             Ljava/io/UnsupportedEncodingException;
        //    38: dup            
        //    39: aload_1        
        //    40: ldc             4
        //    42: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    45: invokespecial   java/io/UnsupportedEncodingException.<init>:(Ljava/lang/String;)V
        //    48: ldc             1
        //    50: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    53: athrow         
        //    54: ldc             1
        //    56: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    59: goto            87
        //    62: astore_2       
        //    63: ldc             501
        //    65: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    68: new             Ljava/io/UnsupportedEncodingException;
        //    71: dup            
        //    72: aload_1        
        //    73: ldc             4
        //    75: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    78: invokespecial   java/io/UnsupportedEncodingException.<init>:(Ljava/lang/String;)V
        //    81: ldc             1
        //    83: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    86: athrow         
        //    87: aload_0        
        //    88: aload_1        
        //    89: putfield        instrumented/java/util/logging/Handler.encoding:Ljava/lang/String;
        //    92: ldc             3
        //    94: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    97: ldc             1
        //    99: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   102: return         
        //   103: athrow         
        //   104: athrow         
        //    Exceptions:
        //  throws java.lang.SecurityException
        //  throws java.io.UnsupportedEncodingException
        //    StackMapTable: 00 05 36 47 07 00 56 18 FF 00 0F 00 00 00 01 07 00 3B FF 00 00 00 00 00 01 07 00 54
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                          
        //  -----  -----  -----  -----  ----------------------------------------------
        //  18     104    104    105    Ljava/lang/VirtualMachineError;
        //  18     54     62     87     Ljava/nio/charset/IllegalCharsetNameException;
        //  0      103    103    104    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0054:
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
    
    public String getEncoding() {
        try {
            final String encoding = this.encoding;
            BytecodeManager.incBytecodes(3);
            return encoding;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public synchronized void setFilter(final Filter filter) throws SecurityException {
        try {
            BytecodeManager.incBytecodes(2);
            this.checkPermission();
            this.filter = filter;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Filter getFilter() {
        try {
            final Filter filter = this.filter;
            BytecodeManager.incBytecodes(3);
            return filter;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public synchronized void setErrorManager(final ErrorManager errorManager) {
        try {
            BytecodeManager.incBytecodes(2);
            this.checkPermission();
            BytecodeManager.incBytecodes(2);
            if (errorManager == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            this.errorManager = errorManager;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public ErrorManager getErrorManager() {
        try {
            BytecodeManager.incBytecodes(2);
            this.checkPermission();
            final ErrorManager errorManager = this.errorManager;
            BytecodeManager.incBytecodes(3);
            return errorManager;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    protected void reportError(final String s, final Exception ex, final int n) {
        try {
            try {
                try {
                    final ErrorManager errorManager = this.errorManager;
                    BytecodeManager.incBytecodes(6);
                    errorManager.error(s, ex, n);
                    BytecodeManager.incBytecodes(1);
                }
                catch (Exception ex3) {
                    BytecodeManager.incBytecodes(501);
                    final PrintStream err = System.err;
                    final String x = "Handler.reportError caught:";
                    BytecodeManager.incBytecodes(3);
                    err.println(x);
                    final Exception ex2 = ex3;
                    BytecodeManager.incBytecodes(2);
                    ex2.printStackTrace();
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        catch (VirtualMachineError virtualMachineError) {
            throw virtualMachineError;
        }
    }
    
    public synchronized void setLevel(final Level logLevel) throws SecurityException {
        try {
            BytecodeManager.incBytecodes(2);
            if (logLevel == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(2);
            this.checkPermission();
            this.logLevel = logLevel;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Level getLevel() {
        try {
            final Level logLevel = this.logLevel;
            BytecodeManager.incBytecodes(3);
            return logLevel;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public boolean isLoggable(final LogRecord logRecord) {
        try {
            BytecodeManager.incBytecodes(2);
            final Level level = this.getLevel();
            BytecodeManager.incBytecodes(1);
            final int intValue = level.intValue();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            final Level level2 = logRecord.getLevel();
            BytecodeManager.incBytecodes(1);
            final int intValue2 = level2.intValue();
            final int n = intValue;
            BytecodeManager.incBytecodes(2);
            if (intValue2 >= n) {
                final int n2 = intValue;
                final int offValue = Handler.offValue;
                BytecodeManager.incBytecodes(3);
                if (n2 != offValue) {
                    BytecodeManager.incBytecodes(2);
                    final Filter filter = this.getFilter();
                    BytecodeManager.incBytecodes(1);
                    final Filter filter2 = filter;
                    BytecodeManager.incBytecodes(2);
                    if (filter2 == null) {
                        final boolean b = true;
                        BytecodeManager.incBytecodes(2);
                        return b;
                    }
                    final Filter filter3 = filter;
                    BytecodeManager.incBytecodes(3);
                    final boolean loggable = filter3.isLoggable(logRecord);
                    BytecodeManager.incBytecodes(1);
                    return loggable;
                }
            }
            final boolean b2 = false;
            BytecodeManager.incBytecodes(2);
            return b2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    void checkPermission() throws SecurityException {
        try {
            final boolean sealed = this.sealed;
            BytecodeManager.incBytecodes(3);
            if (sealed) {
                final LogManager manager = this.manager;
                BytecodeManager.incBytecodes(3);
                manager.checkPermission();
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static {
        try {
            final Level off = Level.OFF;
            BytecodeManager.incBytecodes(2);
            offValue = off.intValue();
            BytecodeManager.incBytecodes(2);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
