// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.logging;

import java.io.UnsupportedEncodingException;
import java.io.OutputStreamWriter;
import aic2021.engine.BytecodeManager;
import java.io.Writer;
import java.io.OutputStream;

public class StreamHandler extends Handler
{
    private OutputStream output;
    private boolean doneHeader;
    private volatile Writer writer;
    
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
        //    60: ldc             ".level"
        //    62: ldc             2
        //    64: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    67: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    70: ldc             1
        //    72: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    75: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    78: getstatic       instrumented/java/util/logging/Level.INFO:Linstrumented/java/util/logging/Level;
        //    81: ldc             2
        //    83: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    86: invokevirtual   instrumented/java/util/logging/LogManager.getLevelProperty:(Ljava/lang/String;Linstrumented/java/util/logging/Level;)Linstrumented/java/util/logging/Level;
        //    89: ldc             1
        //    91: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    94: invokevirtual   instrumented/java/util/logging/StreamHandler.setLevel:(Linstrumented/java/util/logging/Level;)V
        //    97: aload_0        
        //    98: aload_1        
        //    99: new             Ljava/lang/StringBuilder;
        //   102: dup            
        //   103: ldc             5
        //   105: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   108: invokespecial   java/lang/StringBuilder.<init>:()V
        //   111: aload_2        
        //   112: ldc             2
        //   114: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   117: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   120: ldc             ".filter"
        //   122: ldc             2
        //   124: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   127: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   130: ldc             1
        //   132: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   135: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   138: aconst_null    
        //   139: ldc             2
        //   141: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   144: invokevirtual   instrumented/java/util/logging/LogManager.getFilterProperty:(Ljava/lang/String;Linstrumented/java/util/logging/Filter;)Linstrumented/java/util/logging/Filter;
        //   147: ldc             1
        //   149: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   152: invokevirtual   instrumented/java/util/logging/StreamHandler.setFilter:(Linstrumented/java/util/logging/Filter;)V
        //   155: aload_0        
        //   156: aload_1        
        //   157: new             Ljava/lang/StringBuilder;
        //   160: dup            
        //   161: ldc             5
        //   163: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   166: invokespecial   java/lang/StringBuilder.<init>:()V
        //   169: aload_2        
        //   170: ldc             2
        //   172: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   175: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   178: ldc             ".formatter"
        //   180: ldc             2
        //   182: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   185: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   188: ldc             1
        //   190: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   193: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   196: new             Linstrumented/java/util/logging/SimpleFormatter;
        //   199: dup            
        //   200: ldc             3
        //   202: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   205: invokespecial   instrumented/java/util/logging/SimpleFormatter.<init>:()V
        //   208: ldc             1
        //   210: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   213: invokevirtual   instrumented/java/util/logging/LogManager.getFormatterProperty:(Ljava/lang/String;Linstrumented/java/util/logging/Formatter;)Linstrumented/java/util/logging/Formatter;
        //   216: ldc             1
        //   218: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   221: invokevirtual   instrumented/java/util/logging/StreamHandler.setFormatter:(Linstrumented/java/util/logging/Formatter;)V
        //   224: aload_0        
        //   225: aload_1        
        //   226: new             Ljava/lang/StringBuilder;
        //   229: dup            
        //   230: ldc             5
        //   232: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   235: invokespecial   java/lang/StringBuilder.<init>:()V
        //   238: aload_2        
        //   239: ldc             2
        //   241: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   244: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   247: ldc             ".encoding"
        //   249: ldc             2
        //   251: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   254: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   257: ldc             1
        //   259: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   262: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   265: aconst_null    
        //   266: ldc             2
        //   268: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   271: invokevirtual   instrumented/java/util/logging/LogManager.getStringProperty:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   274: ldc             1
        //   276: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   279: invokevirtual   instrumented/java/util/logging/StreamHandler.setEncoding:(Ljava/lang/String;)V
        //   282: ldc             1
        //   284: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   287: goto            321
        //   290: astore_3       
        //   291: ldc             501
        //   293: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   296: aload_0        
        //   297: aconst_null    
        //   298: ldc             3
        //   300: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   303: invokevirtual   instrumented/java/util/logging/StreamHandler.setEncoding:(Ljava/lang/String;)V
        //   306: ldc             1
        //   308: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   311: goto            321
        //   314: astore          4
        //   316: ldc             501
        //   318: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   321: ldc             1
        //   323: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   326: return         
        //   327: athrow         
        //   328: athrow         
        //    StackMapTable: 00 05 FF 01 22 00 03 07 00 02 07 00 1A 07 00 6C 00 01 07 00 11 FF 00 17 00 04 07 00 02 07 00 1A 07 00 6C 07 00 11 00 01 07 00 11 FA 00 06 FF 00 05 00 00 00 01 07 00 6F FF 00 00 00 00 00 01 07 00 0F
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  224    328    328    329    Ljava/lang/VirtualMachineError;
        //  224    282    290    321    Ljava/lang/Exception;
        //  296    306    314    321    Ljava/lang/Exception;
        //  0      327    327    328    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0321:
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
    
    public StreamHandler() {
        try {
            BytecodeManager.incBytecodes(2);
            this.sealed = false;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(2);
            this.configure();
            this.sealed = true;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public StreamHandler(final OutputStream outputStream, final Formatter formatter) {
        try {
            BytecodeManager.incBytecodes(2);
            this.sealed = false;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(2);
            this.configure();
            BytecodeManager.incBytecodes(3);
            this.setFormatter(formatter);
            BytecodeManager.incBytecodes(3);
            this.setOutputStream(outputStream);
            this.sealed = true;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    protected synchronized void setOutputStream(final OutputStream p0) throws SecurityException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             2
        //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     6: ifnonnull       27
        //     9: new             Ljava/lang/NullPointerException;
        //    12: dup            
        //    13: ldc             3
        //    15: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    18: invokespecial   java/lang/NullPointerException.<init>:()V
        //    21: ldc             1
        //    23: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    26: athrow         
        //    27: aload_0        
        //    28: ldc             2
        //    30: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    33: invokespecial   instrumented/java/util/logging/StreamHandler.flushAndClose:()V
        //    36: aload_0        
        //    37: aload_1        
        //    38: putfield        instrumented/java/util/logging/StreamHandler.output:Ljava/io/OutputStream;
        //    41: ldc             3
        //    43: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    46: aload_0        
        //    47: iconst_0       
        //    48: putfield        instrumented/java/util/logging/StreamHandler.doneHeader:Z
        //    51: ldc             3
        //    53: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    56: aload_0        
        //    57: ldc             2
        //    59: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    62: invokevirtual   instrumented/java/util/logging/StreamHandler.getEncoding:()Ljava/lang/String;
        //    65: astore_2       
        //    66: ldc             1
        //    68: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    71: aload_2        
        //    72: ldc             2
        //    74: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    77: ifnonnull       108
        //    80: aload_0        
        //    81: new             Ljava/io/OutputStreamWriter;
        //    84: dup            
        //    85: aload_0        
        //    86: getfield        instrumented/java/util/logging/StreamHandler.output:Ljava/io/OutputStream;
        //    89: ldc             6
        //    91: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    94: invokespecial   java/io/OutputStreamWriter.<init>:(Ljava/io/OutputStream;)V
        //    97: putfield        instrumented/java/util/logging/StreamHandler.writer:Ljava/io/Writer;
        //   100: ldc             2
        //   102: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   105: goto            205
        //   108: aload_0        
        //   109: new             Ljava/io/OutputStreamWriter;
        //   112: dup            
        //   113: aload_0        
        //   114: getfield        instrumented/java/util/logging/StreamHandler.output:Ljava/io/OutputStream;
        //   117: aload_2        
        //   118: ldc             7
        //   120: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   123: invokespecial   java/io/OutputStreamWriter.<init>:(Ljava/io/OutputStream;Ljava/lang/String;)V
        //   126: putfield        instrumented/java/util/logging/StreamHandler.writer:Ljava/io/Writer;
        //   129: ldc             1
        //   131: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   134: ldc             1
        //   136: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   139: goto            205
        //   142: astore_3       
        //   143: ldc             501
        //   145: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   148: new             Ljava/lang/Error;
        //   151: dup            
        //   152: new             Ljava/lang/StringBuilder;
        //   155: dup            
        //   156: ldc             5
        //   158: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   161: invokespecial   java/lang/StringBuilder.<init>:()V
        //   164: ldc             "Unexpected exception "
        //   166: ldc             2
        //   168: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   171: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   174: aload_3        
        //   175: ldc             2
        //   177: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   180: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   183: ldc             1
        //   185: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   188: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   191: ldc             1
        //   193: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   196: invokespecial   java/lang/Error.<init>:(Ljava/lang/String;)V
        //   199: ldc             1
        //   201: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   204: athrow         
        //   205: ldc             1
        //   207: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   210: return         
        //   211: athrow         
        //   212: athrow         
        //    Exceptions:
        //  throws java.lang.SecurityException
        //    StackMapTable: 00 06 1B FC 00 50 07 00 6C 61 07 00 7E 3E FF 00 05 00 00 00 01 07 00 6F FF 00 00 00 00 00 01 07 00 0F
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                  
        //  -----  -----  -----  -----  --------------------------------------
        //  108    212    212    213    Ljava/lang/VirtualMachineError;
        //  108    134    142    205    Ljava/io/UnsupportedEncodingException;
        //  0      211    211    212    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0108:
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
    public synchronized void setEncoding(final String s) throws SecurityException, UnsupportedEncodingException {
        try {
            BytecodeManager.incBytecodes(3);
            super.setEncoding(s);
            final OutputStream output = this.output;
            BytecodeManager.incBytecodes(3);
            if (output == null) {
                BytecodeManager.incBytecodes(1);
                return;
            }
            BytecodeManager.incBytecodes(2);
            this.flush();
            BytecodeManager.incBytecodes(2);
            if (s == null) {
                final OutputStream output2 = this.output;
                BytecodeManager.incBytecodes(6);
                this.writer = new OutputStreamWriter(output2);
                BytecodeManager.incBytecodes(2);
            }
            else {
                final OutputStream output3 = this.output;
                BytecodeManager.incBytecodes(7);
                this.writer = new OutputStreamWriter(output3, s);
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public synchronized void publish(final LogRecord p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: aload_1        
        //     2: ldc             3
        //     4: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     7: invokevirtual   instrumented/java/util/logging/StreamHandler.isLoggable:(Linstrumented/java/util/logging/LogRecord;)Z
        //    10: ldc             1
        //    12: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    15: ifne            24
        //    18: ldc             1
        //    20: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    23: return         
        //    24: aload_0        
        //    25: ldc             2
        //    27: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    30: invokevirtual   instrumented/java/util/logging/StreamHandler.getFormatter:()Linstrumented/java/util/logging/Formatter;
        //    33: aload_1        
        //    34: ldc             2
        //    36: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    39: invokevirtual   instrumented/java/util/logging/Formatter.format:(Linstrumented/java/util/logging/LogRecord;)Ljava/lang/String;
        //    42: astore_2       
        //    43: ldc             1
        //    45: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    48: ldc             1
        //    50: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    53: goto            80
        //    56: astore_3       
        //    57: ldc             501
        //    59: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    62: aload_0        
        //    63: aconst_null    
        //    64: aload_3        
        //    65: iconst_5       
        //    66: ldc             5
        //    68: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    71: invokevirtual   instrumented/java/util/logging/StreamHandler.reportError:(Ljava/lang/String;Ljava/lang/Exception;I)V
        //    74: ldc             1
        //    76: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    79: return         
        //    80: aload_0        
        //    81: getfield        instrumented/java/util/logging/StreamHandler.doneHeader:Z
        //    84: ldc             3
        //    86: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    89: ifne            132
        //    92: aload_0        
        //    93: getfield        instrumented/java/util/logging/StreamHandler.writer:Ljava/io/Writer;
        //    96: aload_0        
        //    97: ldc             4
        //    99: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   102: invokevirtual   instrumented/java/util/logging/StreamHandler.getFormatter:()Linstrumented/java/util/logging/Formatter;
        //   105: aload_0        
        //   106: ldc             2
        //   108: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   111: invokevirtual   instrumented/java/util/logging/Formatter.getHead:(Linstrumented/java/util/logging/Handler;)Ljava/lang/String;
        //   114: ldc             1
        //   116: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   119: invokevirtual   java/io/Writer.write:(Ljava/lang/String;)V
        //   122: aload_0        
        //   123: iconst_1       
        //   124: putfield        instrumented/java/util/logging/StreamHandler.doneHeader:Z
        //   127: ldc             3
        //   129: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   132: aload_0        
        //   133: getfield        instrumented/java/util/logging/StreamHandler.writer:Ljava/io/Writer;
        //   136: aload_2        
        //   137: ldc             4
        //   139: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   142: invokevirtual   java/io/Writer.write:(Ljava/lang/String;)V
        //   145: ldc             1
        //   147: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   150: goto            171
        //   153: astore_3       
        //   154: ldc             501
        //   156: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   159: aload_0        
        //   160: aconst_null    
        //   161: aload_3        
        //   162: iconst_1       
        //   163: ldc             5
        //   165: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   168: invokevirtual   instrumented/java/util/logging/StreamHandler.reportError:(Ljava/lang/String;Ljava/lang/Exception;I)V
        //   171: ldc             1
        //   173: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   176: return         
        //   177: athrow         
        //   178: athrow         
        //    StackMapTable: 00 08 18 5F 07 00 11 FC 00 17 07 00 6C 33 54 07 00 11 11 FF 00 05 00 00 00 01 07 00 6F FF 00 00 00 00 00 01 07 00 0F
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  24     178    178    179    Ljava/lang/VirtualMachineError;
        //  24     48     56     80     Ljava/lang/Exception;
        //  80     145    153    171    Ljava/lang/Exception;
        //  0      177    177    178    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0024:
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
    public boolean isLoggable(final LogRecord logRecord) {
        try {
            final Writer writer = this.writer;
            BytecodeManager.incBytecodes(3);
            if (writer != null) {
                BytecodeManager.incBytecodes(2);
                if (logRecord != null) {
                    BytecodeManager.incBytecodes(3);
                    final boolean loggable = super.isLoggable(logRecord);
                    BytecodeManager.incBytecodes(1);
                    return loggable;
                }
            }
            final boolean b = false;
            BytecodeManager.incBytecodes(2);
            return b;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public synchronized void flush() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        instrumented/java/util/logging/StreamHandler.writer:Ljava/io/Writer;
        //     4: ldc             3
        //     6: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     9: ifnull          50
        //    12: aload_0        
        //    13: getfield        instrumented/java/util/logging/StreamHandler.writer:Ljava/io/Writer;
        //    16: ldc             3
        //    18: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    21: invokevirtual   java/io/Writer.flush:()V
        //    24: ldc             1
        //    26: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    29: goto            50
        //    32: astore_1       
        //    33: ldc             501
        //    35: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    38: aload_0        
        //    39: aconst_null    
        //    40: aload_1        
        //    41: iconst_2       
        //    42: ldc             5
        //    44: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    47: invokevirtual   instrumented/java/util/logging/StreamHandler.reportError:(Ljava/lang/String;Ljava/lang/Exception;I)V
        //    50: ldc             1
        //    52: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    55: return         
        //    56: athrow         
        //    57: athrow         
        //    StackMapTable: 00 04 60 07 00 11 11 FF 00 05 00 00 00 01 07 00 6F FF 00 00 00 00 00 01 07 00 0F
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  12     57     57     58     Ljava/lang/VirtualMachineError;
        //  12     24     32     50     Ljava/lang/Exception;
        //  0      56     56     57     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0050:
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
    
    private synchronized void flushAndClose() throws SecurityException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             2
        //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     6: invokevirtual   instrumented/java/util/logging/StreamHandler.checkPermission:()V
        //     9: aload_0        
        //    10: getfield        instrumented/java/util/logging/StreamHandler.writer:Ljava/io/Writer;
        //    13: ldc             3
        //    15: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    18: ifnull          173
        //    21: aload_0        
        //    22: getfield        instrumented/java/util/logging/StreamHandler.doneHeader:Z
        //    25: ldc             3
        //    27: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    30: ifne            73
        //    33: aload_0        
        //    34: getfield        instrumented/java/util/logging/StreamHandler.writer:Ljava/io/Writer;
        //    37: aload_0        
        //    38: ldc             4
        //    40: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    43: invokevirtual   instrumented/java/util/logging/StreamHandler.getFormatter:()Linstrumented/java/util/logging/Formatter;
        //    46: aload_0        
        //    47: ldc             2
        //    49: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    52: invokevirtual   instrumented/java/util/logging/Formatter.getHead:(Linstrumented/java/util/logging/Handler;)Ljava/lang/String;
        //    55: ldc             1
        //    57: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    60: invokevirtual   java/io/Writer.write:(Ljava/lang/String;)V
        //    63: aload_0        
        //    64: iconst_1       
        //    65: putfield        instrumented/java/util/logging/StreamHandler.doneHeader:Z
        //    68: ldc             3
        //    70: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    73: aload_0        
        //    74: getfield        instrumented/java/util/logging/StreamHandler.writer:Ljava/io/Writer;
        //    77: aload_0        
        //    78: ldc             4
        //    80: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    83: invokevirtual   instrumented/java/util/logging/StreamHandler.getFormatter:()Linstrumented/java/util/logging/Formatter;
        //    86: aload_0        
        //    87: ldc             2
        //    89: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    92: invokevirtual   instrumented/java/util/logging/Formatter.getTail:(Linstrumented/java/util/logging/Handler;)Ljava/lang/String;
        //    95: ldc             1
        //    97: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   100: invokevirtual   java/io/Writer.write:(Ljava/lang/String;)V
        //   103: aload_0        
        //   104: getfield        instrumented/java/util/logging/StreamHandler.writer:Ljava/io/Writer;
        //   107: ldc             3
        //   109: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   112: invokevirtual   java/io/Writer.flush:()V
        //   115: aload_0        
        //   116: getfield        instrumented/java/util/logging/StreamHandler.writer:Ljava/io/Writer;
        //   119: ldc             3
        //   121: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   124: invokevirtual   java/io/Writer.close:()V
        //   127: ldc             1
        //   129: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   132: goto            153
        //   135: astore_1       
        //   136: ldc             501
        //   138: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   141: aload_0        
        //   142: aconst_null    
        //   143: aload_1        
        //   144: iconst_3       
        //   145: ldc             5
        //   147: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   150: invokevirtual   instrumented/java/util/logging/StreamHandler.reportError:(Ljava/lang/String;Ljava/lang/Exception;I)V
        //   153: aload_0        
        //   154: aconst_null    
        //   155: putfield        instrumented/java/util/logging/StreamHandler.writer:Ljava/io/Writer;
        //   158: ldc             3
        //   160: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   163: aload_0        
        //   164: aconst_null    
        //   165: putfield        instrumented/java/util/logging/StreamHandler.output:Ljava/io/OutputStream;
        //   168: ldc             3
        //   170: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   173: ldc             1
        //   175: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   178: return         
        //   179: athrow         
        //   180: athrow         
        //    Exceptions:
        //  throws java.lang.SecurityException
        //    StackMapTable: 00 06 FB 00 49 7D 07 00 11 11 13 FF 00 05 00 00 00 01 07 00 6F FF 00 00 00 00 00 01 07 00 0F
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  21     180    180    181    Ljava/lang/VirtualMachineError;
        //  21     127    135    153    Ljava/lang/Exception;
        //  0      179    179    180    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0073:
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
    public synchronized void close() throws SecurityException {
        try {
            BytecodeManager.incBytecodes(2);
            this.flushAndClose();
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
