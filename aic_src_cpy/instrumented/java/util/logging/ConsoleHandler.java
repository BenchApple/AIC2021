// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.logging;

import java.io.PrintStream;
import java.io.OutputStream;
import aic2021.engine.BytecodeManager;

public class ConsoleHandler extends StreamHandler
{
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
        //    94: invokevirtual   instrumented/java/util/logging/ConsoleHandler.setLevel:(Linstrumented/java/util/logging/Level;)V
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
        //   152: invokevirtual   instrumented/java/util/logging/ConsoleHandler.setFilter:(Linstrumented/java/util/logging/Filter;)V
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
        //   221: invokevirtual   instrumented/java/util/logging/ConsoleHandler.setFormatter:(Linstrumented/java/util/logging/Formatter;)V
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
        //   279: invokevirtual   instrumented/java/util/logging/ConsoleHandler.setEncoding:(Ljava/lang/String;)V
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
        //   303: invokevirtual   instrumented/java/util/logging/ConsoleHandler.setEncoding:(Ljava/lang/String;)V
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
        //    StackMapTable: 00 05 FF 01 22 00 03 07 00 02 07 00 14 07 00 66 00 01 07 00 0B FF 00 17 00 04 07 00 02 07 00 14 07 00 66 07 00 0B 00 01 07 00 0B FA 00 06 FF 00 05 00 00 00 01 07 00 69 FF 00 00 00 00 00 01 07 00 09
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
    
    public ConsoleHandler() {
        try {
            BytecodeManager.incBytecodes(2);
            this.sealed = false;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(2);
            this.configure();
            final PrintStream err = System.err;
            BytecodeManager.incBytecodes(3);
            this.setOutputStream(err);
            this.sealed = true;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void publish(final LogRecord logRecord) {
        try {
            BytecodeManager.incBytecodes(3);
            super.publish(logRecord);
            BytecodeManager.incBytecodes(2);
            this.flush();
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void close() {
        try {
            BytecodeManager.incBytecodes(2);
            this.flush();
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
