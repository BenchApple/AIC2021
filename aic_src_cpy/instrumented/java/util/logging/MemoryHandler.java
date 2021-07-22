// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.logging;

import aic2021.engine.BytecodeManager;

public class MemoryHandler extends Handler
{
    private static final int DEFAULT_SIZE = 1000;
    private volatile Level pushLevel;
    private int size;
    private Handler target;
    private LogRecord[] buffer;
    int start;
    int count;
    
    private void configure() {
        try {
            BytecodeManager.incBytecodes(1);
            final LogManager logManager = LogManager.getLogManager();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            final Class<? extends MemoryHandler> class1 = this.getClass();
            BytecodeManager.incBytecodes(1);
            final String name = class1.getName();
            BytecodeManager.incBytecodes(1);
            final LogManager logManager2 = logManager;
            BytecodeManager.incBytecodes(5);
            final StringBuilder sb = new StringBuilder();
            final String str = name;
            BytecodeManager.incBytecodes(2);
            final StringBuilder append = sb.append(str);
            final String str2 = ".push";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append2 = append.append(str2);
            BytecodeManager.incBytecodes(1);
            final String string = append2.toString();
            final Level severe = Level.SEVERE;
            BytecodeManager.incBytecodes(2);
            this.pushLevel = logManager2.getLevelProperty(string, severe);
            BytecodeManager.incBytecodes(1);
            final LogManager logManager3 = logManager;
            BytecodeManager.incBytecodes(5);
            final StringBuilder sb2 = new StringBuilder();
            final String str3 = name;
            BytecodeManager.incBytecodes(2);
            final StringBuilder append3 = sb2.append(str3);
            final String str4 = ".size";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append4 = append3.append(str4);
            BytecodeManager.incBytecodes(1);
            final String string2 = append4.toString();
            final int n = 1000;
            BytecodeManager.incBytecodes(2);
            this.size = logManager3.getIntProperty(string2, n);
            BytecodeManager.incBytecodes(1);
            final int size = this.size;
            BytecodeManager.incBytecodes(3);
            if (size <= 0) {
                this.size = 1000;
                BytecodeManager.incBytecodes(3);
            }
            final LogManager logManager4 = logManager;
            BytecodeManager.incBytecodes(5);
            final StringBuilder sb3 = new StringBuilder();
            final String str5 = name;
            BytecodeManager.incBytecodes(2);
            final StringBuilder append5 = sb3.append(str5);
            final String str6 = ".level";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append6 = append5.append(str6);
            BytecodeManager.incBytecodes(1);
            final String string3 = append6.toString();
            final Level all = Level.ALL;
            BytecodeManager.incBytecodes(2);
            final Level levelProperty = logManager4.getLevelProperty(string3, all);
            BytecodeManager.incBytecodes(1);
            this.setLevel(levelProperty);
            final LogManager logManager5 = logManager;
            BytecodeManager.incBytecodes(5);
            final StringBuilder sb4 = new StringBuilder();
            final String str7 = name;
            BytecodeManager.incBytecodes(2);
            final StringBuilder append7 = sb4.append(str7);
            final String str8 = ".filter";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append8 = append7.append(str8);
            BytecodeManager.incBytecodes(1);
            final String string4 = append8.toString();
            final Filter filter = null;
            BytecodeManager.incBytecodes(2);
            final Filter filterProperty = logManager5.getFilterProperty(string4, filter);
            BytecodeManager.incBytecodes(1);
            this.setFilter(filterProperty);
            final LogManager logManager6 = logManager;
            BytecodeManager.incBytecodes(5);
            final StringBuilder sb5 = new StringBuilder();
            final String str9 = name;
            BytecodeManager.incBytecodes(2);
            final StringBuilder append9 = sb5.append(str9);
            final String str10 = ".formatter";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append10 = append9.append(str10);
            BytecodeManager.incBytecodes(1);
            final String string5 = append10.toString();
            BytecodeManager.incBytecodes(3);
            final SimpleFormatter simpleFormatter = new SimpleFormatter();
            BytecodeManager.incBytecodes(1);
            final Formatter formatterProperty = logManager6.getFormatterProperty(string5, simpleFormatter);
            BytecodeManager.incBytecodes(1);
            this.setFormatter(formatterProperty);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public MemoryHandler() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             2
        //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     6: invokespecial   instrumented/java/util/logging/Handler.<init>:()V
        //     9: aload_0        
        //    10: iconst_0       
        //    11: putfield        instrumented/java/util/logging/MemoryHandler.sealed:Z
        //    14: ldc             3
        //    16: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    19: aload_0        
        //    20: ldc             2
        //    22: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    25: invokespecial   instrumented/java/util/logging/MemoryHandler.configure:()V
        //    28: aload_0        
        //    29: iconst_1       
        //    30: putfield        instrumented/java/util/logging/MemoryHandler.sealed:Z
        //    33: ldc             3
        //    35: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    38: ldc             1
        //    40: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    43: invokestatic    instrumented/java/util/logging/LogManager.getLogManager:()Linstrumented/java/util/logging/LogManager;
        //    46: astore_1       
        //    47: ldc             1
        //    49: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    52: aload_0        
        //    53: ldc             2
        //    55: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    58: invokevirtual   java/lang/Object.getClass:()Ljava/lang/Class;
        //    61: ldc             1
        //    63: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    66: invokevirtual   java/lang/Class.getName:()Ljava/lang/String;
        //    69: astore_2       
        //    70: ldc             1
        //    72: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    75: aload_1        
        //    76: new             Ljava/lang/StringBuilder;
        //    79: dup            
        //    80: ldc             4
        //    82: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    85: invokespecial   java/lang/StringBuilder.<init>:()V
        //    88: aload_2        
        //    89: ldc             2
        //    91: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    94: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    97: ldc             ".target"
        //    99: ldc             2
        //   101: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   104: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   107: ldc             1
        //   109: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   112: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   115: ldc             1
        //   117: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   120: invokevirtual   instrumented/java/util/logging/LogManager.getProperty:(Ljava/lang/String;)Ljava/lang/String;
        //   123: astore_3       
        //   124: ldc             1
        //   126: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   129: aload_3        
        //   130: ldc             2
        //   132: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   135: ifnonnull       205
        //   138: new             Ljava/lang/RuntimeException;
        //   141: dup            
        //   142: new             Ljava/lang/StringBuilder;
        //   145: dup            
        //   146: ldc             5
        //   148: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   151: invokespecial   java/lang/StringBuilder.<init>:()V
        //   154: ldc             "The handler "
        //   156: ldc             2
        //   158: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   161: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   164: aload_2        
        //   165: ldc             2
        //   167: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   170: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   173: ldc             " does not specify a target"
        //   175: ldc             2
        //   177: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   180: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   183: ldc             1
        //   185: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   188: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   191: ldc             1
        //   193: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   196: invokespecial   java/lang/RuntimeException.<init>:(Ljava/lang/String;)V
        //   199: ldc             1
        //   201: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   204: athrow         
        //   205: ldc             1
        //   207: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   210: invokestatic    java/lang/ClassLoader.getSystemClassLoader:()Ljava/lang/ClassLoader;
        //   213: aload_3        
        //   214: ldc             2
        //   216: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   219: invokevirtual   java/lang/ClassLoader.loadClass:(Ljava/lang/String;)Ljava/lang/Class;
        //   222: astore          4
        //   224: ldc             1
        //   226: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   229: aload_0        
        //   230: aload           4
        //   232: ldc             3
        //   234: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   237: invokevirtual   java/lang/Class.newInstance:()Ljava/lang/Object;
        //   240: checkcast       Linstrumented/java/util/logging/Handler;
        //   243: putfield        instrumented/java/util/logging/MemoryHandler.target:Linstrumented/java/util/logging/Handler;
        //   246: ldc             2
        //   248: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   251: ldc             1
        //   253: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   256: goto            335
        //   259: astore          5
        //   261: ldc             501
        //   263: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   266: new             Ljava/lang/RuntimeException;
        //   269: dup            
        //   270: new             Ljava/lang/StringBuilder;
        //   273: dup            
        //   274: ldc             5
        //   276: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   279: invokespecial   java/lang/StringBuilder.<init>:()V
        //   282: ldc             "MemoryHandler can't load handler target \""
        //   284: ldc             2
        //   286: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   289: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   292: aload_3        
        //   293: ldc             2
        //   295: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   298: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   301: ldc             "\""
        //   303: ldc             2
        //   305: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   308: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   311: ldc             1
        //   313: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   316: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   319: aload           5
        //   321: ldc             2
        //   323: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   326: invokespecial   java/lang/RuntimeException.<init>:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   329: ldc             1
        //   331: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   334: athrow         
        //   335: aload_0        
        //   336: ldc             2
        //   338: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   341: invokespecial   instrumented/java/util/logging/MemoryHandler.init:()V
        //   344: ldc             1
        //   346: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   349: return         
        //   350: athrow         
        //   351: athrow         
        //    StackMapTable: 00 05 FF 00 CD 00 04 07 00 02 07 00 1C 07 00 52 07 00 52 00 00 75 07 00 A5 FC 00 4B 07 00 29 FF 00 0E 00 00 00 01 07 00 74 FF 00 00 00 00 00 01 07 00 76
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                              
        //  -----  -----  -----  -----  ----------------------------------
        //  205    351    351    352    Ljava/lang/VirtualMachineError;
        //  205    251    259    335    Ljava/lang/ClassNotFoundException;
        //  205    251    259    335    Ljava/lang/InstantiationException;
        //  205    251    259    335    Ljava/lang/IllegalAccessException;
        //  0      350    350    351    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0205:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2596)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createConstructor(AstBuilder.java:713)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:549)
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
    
    private void init() {
        try {
            this.buffer = new LogRecord[this.size];
            BytecodeManager.incBytecodes(4);
            this.start = 0;
            BytecodeManager.incBytecodes(3);
            this.count = 0;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public MemoryHandler(final Handler target, final int size, final Level pushLevel) {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            if (target != null) {
                BytecodeManager.incBytecodes(2);
                if (pushLevel != null) {
                    BytecodeManager.incBytecodes(2);
                    if (size <= 0) {
                        BytecodeManager.incBytecodes(3);
                        final IllegalArgumentException ex = new IllegalArgumentException();
                        BytecodeManager.incBytecodes(1);
                        throw ex;
                    }
                    this.sealed = false;
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(2);
                    this.configure();
                    this.sealed = true;
                    BytecodeManager.incBytecodes(3);
                    this.target = target;
                    BytecodeManager.incBytecodes(3);
                    this.pushLevel = pushLevel;
                    BytecodeManager.incBytecodes(3);
                    this.size = size;
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(2);
                    this.init();
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
            final int n = (this.start + this.count) % this.buffer.length;
            BytecodeManager.incBytecodes(10);
            this.buffer[n] = logRecord;
            BytecodeManager.incBytecodes(5);
            final int count = this.count;
            final int length = this.buffer.length;
            BytecodeManager.incBytecodes(6);
            if (count < length) {
                ++this.count;
                BytecodeManager.incBytecodes(7);
            }
            else {
                ++this.start;
                BytecodeManager.incBytecodes(6);
                this.start %= this.buffer.length;
                BytecodeManager.incBytecodes(8);
            }
            BytecodeManager.incBytecodes(2);
            final Level level = logRecord.getLevel();
            BytecodeManager.incBytecodes(1);
            final int intValue = level.intValue();
            final Level pushLevel = this.pushLevel;
            BytecodeManager.incBytecodes(3);
            final int intValue2 = pushLevel.intValue();
            BytecodeManager.incBytecodes(1);
            if (intValue >= intValue2) {
                BytecodeManager.incBytecodes(2);
                this.push();
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public synchronized void push() {
        try {
            int n = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n2 = n;
                final int count = this.count;
                BytecodeManager.incBytecodes(4);
                if (n2 >= count) {
                    break;
                }
                final int n3 = (this.start + n) % this.buffer.length;
                BytecodeManager.incBytecodes(9);
                final LogRecord logRecord = this.buffer[n3];
                BytecodeManager.incBytecodes(5);
                final Handler target = this.target;
                final LogRecord logRecord2 = logRecord;
                BytecodeManager.incBytecodes(4);
                target.publish(logRecord2);
                ++n;
                BytecodeManager.incBytecodes(2);
            }
            this.start = 0;
            BytecodeManager.incBytecodes(3);
            this.count = 0;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void flush() {
        try {
            final Handler target = this.target;
            BytecodeManager.incBytecodes(3);
            target.flush();
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void close() throws SecurityException {
        try {
            final Handler target = this.target;
            BytecodeManager.incBytecodes(3);
            target.close();
            final Level off = Level.OFF;
            BytecodeManager.incBytecodes(3);
            this.setLevel(off);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public synchronized void setPushLevel(final Level pushLevel) throws SecurityException {
        try {
            BytecodeManager.incBytecodes(2);
            if (pushLevel == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(2);
            this.checkPermission();
            this.pushLevel = pushLevel;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Level getPushLevel() {
        try {
            final Level pushLevel = this.pushLevel;
            BytecodeManager.incBytecodes(3);
            return pushLevel;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean isLoggable(final LogRecord logRecord) {
        try {
            BytecodeManager.incBytecodes(3);
            final boolean loggable = super.isLoggable(logRecord);
            BytecodeManager.incBytecodes(1);
            return loggable;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
