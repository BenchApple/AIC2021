// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.logging;

import aic2021.engine.BytecodeManager;

public abstract class Formatter
{
    protected Formatter() {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public abstract String format(final LogRecord p0);
    
    public String getHead(final Handler handler) {
        try {
            final String s = "";
            BytecodeManager.incBytecodes(2);
            return s;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public String getTail(final Handler handler) {
        try {
            final String s = "";
            BytecodeManager.incBytecodes(2);
            return s;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public synchronized String formatMessage(final LogRecord p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             2
        //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     6: invokevirtual   instrumented/java/util/logging/LogRecord.getMessage:()Ljava/lang/String;
        //     9: astore_2       
        //    10: ldc             1
        //    12: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    15: aload_1        
        //    16: ldc             2
        //    18: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    21: invokevirtual   instrumented/java/util/logging/LogRecord.getResourceBundle:()Linstrumented/java/util/ResourceBundle;
        //    24: astore_3       
        //    25: ldc             1
        //    27: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    30: aload_3        
        //    31: ldc             2
        //    33: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    36: ifnull          93
        //    39: aload_3        
        //    40: aload_1        
        //    41: ldc             3
        //    43: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    46: invokevirtual   instrumented/java/util/logging/LogRecord.getMessage:()Ljava/lang/String;
        //    49: ldc             1
        //    51: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    54: invokevirtual   instrumented/java/util/ResourceBundle.getString:(Ljava/lang/String;)Ljava/lang/String;
        //    57: astore_2       
        //    58: ldc             1
        //    60: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    63: ldc             1
        //    65: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    68: goto            93
        //    71: astore          4
        //    73: ldc             501
        //    75: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    78: aload_1        
        //    79: ldc             2
        //    81: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    84: invokevirtual   instrumented/java/util/logging/LogRecord.getMessage:()Ljava/lang/String;
        //    87: astore_2       
        //    88: ldc             1
        //    90: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    93: aload_1        
        //    94: ldc             2
        //    96: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    99: invokevirtual   instrumented/java/util/logging/LogRecord.getParameters:()[Ljava/lang/Object;
        //   102: astore          4
        //   104: ldc             1
        //   106: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   109: aload           4
        //   111: ldc             2
        //   113: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   116: ifnull          130
        //   119: aload           4
        //   121: arraylength    
        //   122: ldc             3
        //   124: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   127: ifne            142
        //   130: aload_2        
        //   131: ldc             1
        //   133: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   136: ldc             1
        //   138: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   141: areturn        
        //   142: aload_2        
        //   143: ldc             "{0"
        //   145: ldc             3
        //   147: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   150: invokevirtual   java/lang/String.indexOf:(Ljava/lang/String;)I
        //   153: ldc             1
        //   155: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   158: ifge            223
        //   161: aload_2        
        //   162: ldc             "{1"
        //   164: ldc             3
        //   166: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   169: invokevirtual   java/lang/String.indexOf:(Ljava/lang/String;)I
        //   172: ldc             1
        //   174: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   177: ifge            223
        //   180: aload_2        
        //   181: ldc             "{2"
        //   183: ldc             2
        //   185: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   188: ldc             1
        //   190: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   193: invokevirtual   java/lang/String.indexOf:(Ljava/lang/String;)I
        //   196: ldc             1
        //   198: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   201: ifge            223
        //   204: aload_2        
        //   205: ldc             "{3"
        //   207: ldc             3
        //   209: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   212: invokevirtual   java/lang/String.indexOf:(Ljava/lang/String;)I
        //   215: ldc             1
        //   217: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   220: iflt            240
        //   223: aload_2        
        //   224: aload           4
        //   226: ldc             3
        //   228: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   231: invokestatic    java/text/MessageFormat.format:(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //   234: ldc             1
        //   236: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   239: areturn        
        //   240: aload_2        
        //   241: ldc             1
        //   243: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   246: ldc             1
        //   248: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   251: areturn        
        //   252: astore          4
        //   254: ldc             501
        //   256: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   259: aload_2        
        //   260: ldc             2
        //   262: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   265: areturn        
        //   266: athrow         
        //   267: athrow         
        //    StackMapTable: 00 09 FF 00 47 00 04 07 00 02 07 00 23 07 00 34 07 00 2E 00 01 07 00 1F 15 FC 00 24 07 00 3B 0B FB 00 50 10 FF 00 0B 00 04 07 00 02 07 00 23 07 00 34 07 00 2E 00 01 07 00 21 FF 00 0D 00 00 00 01 07 00 13 FF 00 00 00 00 00 01 07 00 1D
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                             
        //  -----  -----  -----  -----  -------------------------------------------------
        //  39     267    267    268    Ljava/lang/VirtualMachineError;
        //  39     63     71     93     Linstrumented/java/util/MissingResourceException;
        //  93     136    252    266    Ljava/lang/Exception;
        //  142    234    252    266    Ljava/lang/Exception;
        //  240    246    252    266    Ljava/lang/Exception;
        //  0      266    266    267    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0093:
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
}
