// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.logging;

import sun.misc.JavaLangAccess;
import sun.misc.SharedSecrets;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import aic2021.engine.BytecodeManager;
import instrumented.java.util.ResourceBundle;
import instrumented.java.util.concurrent.atomic.AtomicInteger;
import instrumented.java.util.concurrent.atomic.AtomicLong;
import java.io.Serializable;

public class LogRecord implements Serializable
{
    private static final AtomicLong globalSequenceNumber;
    private static final int MIN_SEQUENTIAL_THREAD_ID = 1073741823;
    private static final AtomicInteger nextThreadId;
    private static final ThreadLocal<Integer> threadIds;
    private Level level;
    private long sequenceNumber;
    private String sourceClassName;
    private String sourceMethodName;
    private String message;
    private int threadID;
    private long millis;
    private Throwable thrown;
    private String loggerName;
    private String resourceBundleName;
    private transient boolean needToInferCaller;
    private transient Object[] parameters;
    private transient ResourceBundle resourceBundle;
    private static final long serialVersionUID = 5372048053134512534L;
    
    private int defaultThreadID() {
        try {
            BytecodeManager.incBytecodes(1);
            final Thread currentThread = Thread.currentThread();
            BytecodeManager.incBytecodes(1);
            final long id = currentThread.getId();
            BytecodeManager.incBytecodes(1);
            final long n = lcmp(id, 1073741823L);
            BytecodeManager.incBytecodes(4);
            if (n < 0) {
                final int n2 = (int)id;
                BytecodeManager.incBytecodes(3);
                return n2;
            }
            final ThreadLocal<Integer> threadIds = LogRecord.threadIds;
            BytecodeManager.incBytecodes(2);
            Integer value = threadIds.get();
            BytecodeManager.incBytecodes(2);
            final Integer n3 = value;
            BytecodeManager.incBytecodes(2);
            if (n3 == null) {
                final AtomicInteger nextThreadId = LogRecord.nextThreadId;
                BytecodeManager.incBytecodes(2);
                final int andIncrement = nextThreadId.getAndIncrement();
                BytecodeManager.incBytecodes(1);
                value = andIncrement;
                BytecodeManager.incBytecodes(1);
                final ThreadLocal<Integer> threadIds2 = LogRecord.threadIds;
                final Integer value2 = value;
                BytecodeManager.incBytecodes(3);
                threadIds2.set(value2);
            }
            final Integer n4 = value;
            BytecodeManager.incBytecodes(2);
            final int intValue = n4;
            BytecodeManager.incBytecodes(1);
            return intValue;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public LogRecord(final Level level, final String message) {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            level.getClass();
            BytecodeManager.incBytecodes(1);
            this.level = level;
            BytecodeManager.incBytecodes(3);
            this.message = message;
            BytecodeManager.incBytecodes(3);
            final AtomicLong globalSequenceNumber = LogRecord.globalSequenceNumber;
            BytecodeManager.incBytecodes(3);
            this.sequenceNumber = globalSequenceNumber.getAndIncrement();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            this.threadID = this.defaultThreadID();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            this.millis = System.currentTimeMillis();
            BytecodeManager.incBytecodes(1);
            this.needToInferCaller = true;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public String getLoggerName() {
        try {
            final String loggerName = this.loggerName;
            BytecodeManager.incBytecodes(3);
            return loggerName;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void setLoggerName(final String loggerName) {
        try {
            this.loggerName = loggerName;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public ResourceBundle getResourceBundle() {
        try {
            final ResourceBundle resourceBundle = this.resourceBundle;
            BytecodeManager.incBytecodes(3);
            return resourceBundle;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void setResourceBundle(final ResourceBundle resourceBundle) {
        try {
            this.resourceBundle = resourceBundle;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public String getResourceBundleName() {
        try {
            final String resourceBundleName = this.resourceBundleName;
            BytecodeManager.incBytecodes(3);
            return resourceBundleName;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void setResourceBundleName(final String resourceBundleName) {
        try {
            this.resourceBundleName = resourceBundleName;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Level getLevel() {
        try {
            final Level level = this.level;
            BytecodeManager.incBytecodes(3);
            return level;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void setLevel(final Level level) {
        try {
            BytecodeManager.incBytecodes(2);
            if (level == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            this.level = level;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public long getSequenceNumber() {
        try {
            final long sequenceNumber = this.sequenceNumber;
            BytecodeManager.incBytecodes(3);
            return sequenceNumber;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void setSequenceNumber(final long sequenceNumber) {
        try {
            this.sequenceNumber = sequenceNumber;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public String getSourceClassName() {
        try {
            final boolean needToInferCaller = this.needToInferCaller;
            BytecodeManager.incBytecodes(3);
            if (needToInferCaller) {
                BytecodeManager.incBytecodes(2);
                this.inferCaller();
            }
            final String sourceClassName = this.sourceClassName;
            BytecodeManager.incBytecodes(3);
            return sourceClassName;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void setSourceClassName(final String sourceClassName) {
        try {
            this.sourceClassName = sourceClassName;
            BytecodeManager.incBytecodes(3);
            this.needToInferCaller = false;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public String getSourceMethodName() {
        try {
            final boolean needToInferCaller = this.needToInferCaller;
            BytecodeManager.incBytecodes(3);
            if (needToInferCaller) {
                BytecodeManager.incBytecodes(2);
                this.inferCaller();
            }
            final String sourceMethodName = this.sourceMethodName;
            BytecodeManager.incBytecodes(3);
            return sourceMethodName;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void setSourceMethodName(final String sourceMethodName) {
        try {
            this.sourceMethodName = sourceMethodName;
            BytecodeManager.incBytecodes(3);
            this.needToInferCaller = false;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public String getMessage() {
        try {
            final String message = this.message;
            BytecodeManager.incBytecodes(3);
            return message;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void setMessage(final String message) {
        try {
            this.message = message;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Object[] getParameters() {
        try {
            final Object[] parameters = this.parameters;
            BytecodeManager.incBytecodes(3);
            return parameters;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void setParameters(final Object[] parameters) {
        try {
            this.parameters = parameters;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public int getThreadID() {
        try {
            final int threadID = this.threadID;
            BytecodeManager.incBytecodes(3);
            return threadID;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void setThreadID(final int threadID) {
        try {
            this.threadID = threadID;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public long getMillis() {
        try {
            final long millis = this.millis;
            BytecodeManager.incBytecodes(3);
            return millis;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void setMillis(final long millis) {
        try {
            this.millis = millis;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Throwable getThrown() {
        try {
            final Throwable thrown = this.thrown;
            BytecodeManager.incBytecodes(3);
            return thrown;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void setThrown(final Throwable thrown) {
        try {
            this.thrown = thrown;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) throws IOException {
        try {
            BytecodeManager.incBytecodes(2);
            objectOutputStream.defaultWriteObject();
            final int val = 1;
            BytecodeManager.incBytecodes(3);
            objectOutputStream.writeByte(val);
            final int val2 = 0;
            BytecodeManager.incBytecodes(3);
            objectOutputStream.writeByte(val2);
            final Object[] parameters = this.parameters;
            BytecodeManager.incBytecodes(3);
            if (parameters == null) {
                final int val3 = -1;
                BytecodeManager.incBytecodes(3);
                objectOutputStream.writeInt(val3);
                BytecodeManager.incBytecodes(1);
                return;
            }
            final int length = this.parameters.length;
            BytecodeManager.incBytecodes(5);
            objectOutputStream.writeInt(length);
            int n = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n2 = n;
                final int length2 = this.parameters.length;
                BytecodeManager.incBytecodes(5);
                if (n2 >= length2) {
                    break;
                }
                final Object o = this.parameters[n];
                BytecodeManager.incBytecodes(5);
                if (o == null) {
                    final Object obj = null;
                    BytecodeManager.incBytecodes(3);
                    objectOutputStream.writeObject(obj);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    final Object o2 = this.parameters[n];
                    BytecodeManager.incBytecodes(6);
                    final String string = o2.toString();
                    BytecodeManager.incBytecodes(1);
                    objectOutputStream.writeObject(string);
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
    
    private void readObject(final ObjectInputStream p0) throws IOException, ClassNotFoundException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             2
        //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     6: invokevirtual   java/io/ObjectInputStream.defaultReadObject:()V
        //     9: aload_1        
        //    10: ldc             2
        //    12: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    15: invokevirtual   java/io/ObjectInputStream.readByte:()B
        //    18: istore_2       
        //    19: ldc             1
        //    21: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    24: aload_1        
        //    25: ldc             2
        //    27: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    30: invokevirtual   java/io/ObjectInputStream.readByte:()B
        //    33: istore_3       
        //    34: ldc             1
        //    36: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    39: iload_2        
        //    40: iconst_1       
        //    41: ldc             3
        //    43: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    46: if_icmpeq       125
        //    49: new             Ljava/io/IOException;
        //    52: dup            
        //    53: new             Ljava/lang/StringBuilder;
        //    56: dup            
        //    57: ldc             5
        //    59: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    62: invokespecial   java/lang/StringBuilder.<init>:()V
        //    65: ldc             "LogRecord: bad version: "
        //    67: ldc             2
        //    69: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    72: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    75: iload_2        
        //    76: ldc             2
        //    78: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    81: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //    84: ldc             "."
        //    86: ldc             2
        //    88: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    91: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    94: iload_3        
        //    95: ldc             2
        //    97: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   100: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   103: ldc             1
        //   105: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   108: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   111: ldc             1
        //   113: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   116: invokespecial   java/io/IOException.<init>:(Ljava/lang/String;)V
        //   119: ldc             1
        //   121: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   124: athrow         
        //   125: aload_1        
        //   126: ldc             2
        //   128: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   131: invokevirtual   java/io/ObjectInputStream.readInt:()I
        //   134: istore          4
        //   136: ldc             1
        //   138: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   141: iload           4
        //   143: iconst_m1      
        //   144: ldc             3
        //   146: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   149: if_icmpne       165
        //   152: aload_0        
        //   153: aconst_null    
        //   154: putfield        instrumented/java/util/logging/LogRecord.parameters:[Ljava/lang/Object;
        //   157: ldc             4
        //   159: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   162: goto            234
        //   165: aload_0        
        //   166: iload           4
        //   168: anewarray       Ljava/lang/Object;
        //   171: putfield        instrumented/java/util/logging/LogRecord.parameters:[Ljava/lang/Object;
        //   174: ldc             3
        //   176: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   179: iconst_0       
        //   180: istore          5
        //   182: ldc             2
        //   184: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   187: iload           5
        //   189: aload_0        
        //   190: getfield        instrumented/java/util/logging/LogRecord.parameters:[Ljava/lang/Object;
        //   193: arraylength    
        //   194: ldc             5
        //   196: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   199: if_icmpge       234
        //   202: aload_0        
        //   203: getfield        instrumented/java/util/logging/LogRecord.parameters:[Ljava/lang/Object;
        //   206: iload           5
        //   208: aload_1        
        //   209: ldc             5
        //   211: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   214: invokevirtual   java/io/ObjectInputStream.readObject:()Ljava/lang/Object;
        //   217: aastore        
        //   218: ldc             1
        //   220: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   223: iinc            5, 1
        //   226: ldc             2
        //   228: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   231: goto            187
        //   234: aload_0        
        //   235: getfield        instrumented/java/util/logging/LogRecord.resourceBundleName:Ljava/lang/String;
        //   238: ldc             3
        //   240: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   243: ifnull          323
        //   246: aload_0        
        //   247: getfield        instrumented/java/util/logging/LogRecord.resourceBundleName:Ljava/lang/String;
        //   250: ldc             2
        //   252: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   255: ldc             1
        //   257: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   260: invokestatic    instrumented/java/util/Locale.getDefault:()Linstrumented/java/util/Locale;
        //   263: ldc             1
        //   265: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   268: invokestatic    java/lang/ClassLoader.getSystemClassLoader:()Ljava/lang/ClassLoader;
        //   271: ldc             1
        //   273: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   276: invokestatic    instrumented/java/util/ResourceBundle.getBundle:(Ljava/lang/String;Linstrumented/java/util/Locale;Ljava/lang/ClassLoader;)Linstrumented/java/util/ResourceBundle;
        //   279: astore          5
        //   281: ldc             1
        //   283: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   286: aload_0        
        //   287: aload           5
        //   289: putfield        instrumented/java/util/logging/LogRecord.resourceBundle:Linstrumented/java/util/ResourceBundle;
        //   292: ldc             3
        //   294: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   297: ldc             1
        //   299: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   302: goto            323
        //   305: astore          5
        //   307: ldc_w           501
        //   310: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   313: aload_0        
        //   314: aconst_null    
        //   315: putfield        instrumented/java/util/logging/LogRecord.resourceBundle:Linstrumented/java/util/ResourceBundle;
        //   318: ldc             3
        //   320: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   323: aload_0        
        //   324: iconst_0       
        //   325: putfield        instrumented/java/util/logging/LogRecord.needToInferCaller:Z
        //   328: ldc             3
        //   330: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   333: ldc             1
        //   335: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   338: return         
        //   339: athrow         
        //   340: athrow         
        //    Exceptions:
        //  throws java.io.IOException
        //  throws java.lang.ClassNotFoundException
        //    StackMapTable: 00 08 FD 00 7D 01 01 FC 00 27 01 FC 00 15 01 FA 00 2E F7 00 46 07 00 D5 11 FF 00 0F 00 00 00 01 07 00 5E FF 00 00 00 00 00 01 07 00 D3
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                             
        //  -----  -----  -----  -----  -------------------------------------------------
        //  246    340    340    341    Ljava/lang/VirtualMachineError;
        //  246    297    305    323    Linstrumented/java/util/MissingResourceException;
        //  0      339    339    340    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0323:
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
    
    private void inferCaller() {
        try {
            this.needToInferCaller = false;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
            final JavaLangAccess javaLangAccess = SharedSecrets.getJavaLangAccess();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            final Throwable t = new Throwable();
            BytecodeManager.incBytecodes(1);
            final JavaLangAccess javaLangAccess2 = javaLangAccess;
            final Throwable t2 = t;
            BytecodeManager.incBytecodes(3);
            final int stackTraceDepth = javaLangAccess2.getStackTraceDepth(t2);
            BytecodeManager.incBytecodes(1);
            boolean b = true;
            BytecodeManager.incBytecodes(2);
            int n = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n2 = n;
                final int n3 = stackTraceDepth;
                BytecodeManager.incBytecodes(3);
                if (n2 >= n3) {
                    BytecodeManager.incBytecodes(1);
                    return;
                }
                final JavaLangAccess javaLangAccess3 = javaLangAccess;
                final Throwable t3 = t;
                final int n4 = n;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
                final StackTraceElement stackTraceElement = javaLangAccess3.getStackTraceElement(t3, n4);
                BytecodeManager.incBytecodes(1);
                final StackTraceElement stackTraceElement2 = stackTraceElement;
                BytecodeManager.incBytecodes(2);
                final String className = stackTraceElement2.getClassName();
                BytecodeManager.incBytecodes(1);
                final String s = className;
                BytecodeManager.incBytecodes(3);
                final boolean loggerImplFrame = this.isLoggerImplFrame(s);
                BytecodeManager.incBytecodes(1);
                final boolean b2 = b;
                BytecodeManager.incBytecodes(2);
                if (b2) {
                    final boolean b3 = loggerImplFrame;
                    BytecodeManager.incBytecodes(2);
                    if (b3) {
                        b = false;
                        BytecodeManager.incBytecodes(3);
                    }
                }
                else {
                    final boolean b4 = loggerImplFrame;
                    BytecodeManager.incBytecodes(2);
                    if (!b4) {
                        final String s2 = className;
                        final String prefix = "java.lang.reflect.";
                        BytecodeManager.incBytecodes(3);
                        final boolean startsWith = s2.startsWith(prefix);
                        BytecodeManager.incBytecodes(1);
                        if (!startsWith) {
                            final String s3 = className;
                            final String prefix2 = "sun.reflect.";
                            BytecodeManager.incBytecodes(3);
                            final boolean startsWith2 = s3.startsWith(prefix2);
                            BytecodeManager.incBytecodes(1);
                            if (!startsWith2) {
                                final String sourceClassName = className;
                                BytecodeManager.incBytecodes(3);
                                this.setSourceClassName(sourceClassName);
                                final StackTraceElement stackTraceElement3 = stackTraceElement;
                                BytecodeManager.incBytecodes(3);
                                final String methodName = stackTraceElement3.getMethodName();
                                BytecodeManager.incBytecodes(1);
                                this.setSourceMethodName(methodName);
                                BytecodeManager.incBytecodes(1);
                                return;
                            }
                        }
                    }
                }
                ++n;
                BytecodeManager.incBytecodes(2);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private boolean isLoggerImplFrame(final String s) {
        try {
            final String anObject = "java.util.logging.Logger";
            BytecodeManager.incBytecodes(3);
            final boolean equals = s.equals(anObject);
            BytecodeManager.incBytecodes(1);
            boolean b = false;
            Label_0085: {
                if (!equals) {
                    final String prefix = "java.util.logging.LoggingProxyImpl";
                    BytecodeManager.incBytecodes(2);
                    BytecodeManager.incBytecodes(1);
                    final boolean startsWith = s.startsWith(prefix);
                    BytecodeManager.incBytecodes(1);
                    if (!startsWith) {
                        final String prefix2 = "sun.util.logging.";
                        BytecodeManager.incBytecodes(2);
                        BytecodeManager.incBytecodes(1);
                        final boolean startsWith2 = s.startsWith(prefix2);
                        BytecodeManager.incBytecodes(1);
                        if (!startsWith2) {
                            b = false;
                            BytecodeManager.incBytecodes(1);
                            break Label_0085;
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
    
    static {
        try {
            final long n = 0L;
            BytecodeManager.incBytecodes(4);
            globalSequenceNumber = new AtomicLong(n);
            BytecodeManager.incBytecodes(1);
            final int n2 = 1073741823;
            BytecodeManager.incBytecodes(4);
            nextThreadId = new AtomicInteger(n2);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            threadIds = new ThreadLocal<Integer>();
            BytecodeManager.incBytecodes(2);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
