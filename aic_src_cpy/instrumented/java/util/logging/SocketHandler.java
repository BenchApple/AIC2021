// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.logging;

import java.io.OutputStream;
import java.io.BufferedOutputStream;
import aic2021.engine.BytecodeManager;
import java.io.IOException;
import java.net.Socket;

public class SocketHandler extends StreamHandler
{
    private Socket sock;
    private String host;
    private int port;
    
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
        //    78: getstatic       instrumented/java/util/logging/Level.ALL:Linstrumented/java/util/logging/Level;
        //    81: ldc             2
        //    83: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    86: invokevirtual   instrumented/java/util/logging/LogManager.getLevelProperty:(Ljava/lang/String;Linstrumented/java/util/logging/Level;)Linstrumented/java/util/logging/Level;
        //    89: ldc             1
        //    91: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    94: invokevirtual   instrumented/java/util/logging/SocketHandler.setLevel:(Linstrumented/java/util/logging/Level;)V
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
        //   152: invokevirtual   instrumented/java/util/logging/SocketHandler.setFilter:(Linstrumented/java/util/logging/Filter;)V
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
        //   196: new             Linstrumented/java/util/logging/XMLFormatter;
        //   199: dup            
        //   200: ldc             3
        //   202: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   205: invokespecial   instrumented/java/util/logging/XMLFormatter.<init>:()V
        //   208: ldc             1
        //   210: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   213: invokevirtual   instrumented/java/util/logging/LogManager.getFormatterProperty:(Ljava/lang/String;Linstrumented/java/util/logging/Formatter;)Linstrumented/java/util/logging/Formatter;
        //   216: ldc             1
        //   218: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   221: invokevirtual   instrumented/java/util/logging/SocketHandler.setFormatter:(Linstrumented/java/util/logging/Formatter;)V
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
        //   279: invokevirtual   instrumented/java/util/logging/SocketHandler.setEncoding:(Ljava/lang/String;)V
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
        //   303: invokevirtual   instrumented/java/util/logging/SocketHandler.setEncoding:(Ljava/lang/String;)V
        //   306: ldc             1
        //   308: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   311: goto            321
        //   314: astore          4
        //   316: ldc             501
        //   318: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   321: aload_0        
        //   322: aload_1        
        //   323: new             Ljava/lang/StringBuilder;
        //   326: dup            
        //   327: ldc             5
        //   329: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   332: invokespecial   java/lang/StringBuilder.<init>:()V
        //   335: aload_2        
        //   336: ldc             2
        //   338: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   341: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   344: ldc             ".port"
        //   346: ldc             2
        //   348: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   351: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   354: ldc             1
        //   356: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   359: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   362: iconst_0       
        //   363: ldc             2
        //   365: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   368: invokevirtual   instrumented/java/util/logging/LogManager.getIntProperty:(Ljava/lang/String;I)I
        //   371: putfield        instrumented/java/util/logging/SocketHandler.port:I
        //   374: ldc             1
        //   376: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   379: aload_0        
        //   380: aload_1        
        //   381: new             Ljava/lang/StringBuilder;
        //   384: dup            
        //   385: ldc             5
        //   387: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   390: invokespecial   java/lang/StringBuilder.<init>:()V
        //   393: aload_2        
        //   394: ldc             2
        //   396: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   399: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   402: ldc             ".host"
        //   404: ldc             2
        //   406: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   409: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   412: ldc             1
        //   414: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   417: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   420: aconst_null    
        //   421: ldc             2
        //   423: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   426: invokevirtual   instrumented/java/util/logging/LogManager.getStringProperty:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   429: putfield        instrumented/java/util/logging/SocketHandler.host:Ljava/lang/String;
        //   432: ldc             1
        //   434: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   437: ldc             1
        //   439: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   442: return         
        //   443: athrow         
        //   444: athrow         
        //    StackMapTable: 00 05 FF 01 22 00 03 07 00 02 07 00 1A 07 00 6C 00 01 07 00 11 FF 00 17 00 04 07 00 02 07 00 1A 07 00 6C 07 00 11 00 01 07 00 11 FA 00 06 FF 00 79 00 00 00 01 07 00 7B FF 00 00 00 00 00 01 07 00 0F
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  224    444    444    445    Ljava/lang/VirtualMachineError;
        //  224    282    290    321    Ljava/lang/Exception;
        //  296    306    314    321    Ljava/lang/Exception;
        //  0      443    443    444    Any
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
    
    public SocketHandler() throws IOException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             2
        //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     6: invokespecial   instrumented/java/util/logging/StreamHandler.<init>:()V
        //     9: aload_0        
        //    10: iconst_0       
        //    11: putfield        instrumented/java/util/logging/SocketHandler.sealed:Z
        //    14: ldc             3
        //    16: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    19: aload_0        
        //    20: ldc             2
        //    22: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    25: invokespecial   instrumented/java/util/logging/SocketHandler.configure:()V
        //    28: aload_0        
        //    29: ldc             2
        //    31: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    34: invokespecial   instrumented/java/util/logging/SocketHandler.connect:()V
        //    37: ldc             1
        //    39: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    42: goto            133
        //    45: astore_1       
        //    46: ldc             501
        //    48: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    51: getstatic       java/lang/System.err:Ljava/io/PrintStream;
        //    54: new             Ljava/lang/StringBuilder;
        //    57: dup            
        //    58: ldc             4
        //    60: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    63: invokespecial   java/lang/StringBuilder.<init>:()V
        //    66: ldc             "SocketHandler: connect failed to "
        //    68: ldc             2
        //    70: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    73: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    76: aload_0        
        //    77: getfield        instrumented/java/util/logging/SocketHandler.host:Ljava/lang/String;
        //    80: ldc             3
        //    82: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    85: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    88: ldc             ":"
        //    90: ldc             2
        //    92: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    95: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    98: aload_0        
        //    99: getfield        instrumented/java/util/logging/SocketHandler.port:I
        //   102: ldc             3
        //   104: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   107: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   110: ldc             1
        //   112: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   115: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   118: ldc             1
        //   120: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   123: invokevirtual   java/io/PrintStream.println:(Ljava/lang/String;)V
        //   126: aload_1        
        //   127: ldc             2
        //   129: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   132: athrow         
        //   133: aload_0        
        //   134: iconst_1       
        //   135: putfield        instrumented/java/util/logging/SocketHandler.sealed:Z
        //   138: ldc             3
        //   140: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   143: ldc             1
        //   145: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   148: return         
        //   149: athrow         
        //   150: athrow         
        //    Exceptions:
        //  throws java.io.IOException
        //    StackMapTable: 00 04 FF 00 2D 00 01 07 00 02 00 01 07 00 7D FB 00 57 FF 00 0F 00 00 00 01 07 00 7B FF 00 00 00 00 00 01 07 00 0F
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  28     150    150    151    Ljava/lang/VirtualMachineError;
        //  28     37     45     133    Ljava/io/IOException;
        //  0      149    149    150    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0133:
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
    
    public SocketHandler(final String host, final int port) throws IOException {
        try {
            BytecodeManager.incBytecodes(2);
            this.sealed = false;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(2);
            this.configure();
            this.sealed = true;
            BytecodeManager.incBytecodes(3);
            this.port = port;
            BytecodeManager.incBytecodes(3);
            this.host = host;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(2);
            this.connect();
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void connect() throws IOException {
        try {
            final int port = this.port;
            BytecodeManager.incBytecodes(3);
            if (port == 0) {
                BytecodeManager.incBytecodes(5);
                final StringBuilder sb = new StringBuilder();
                final String str = "Bad port: ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb.append(str);
                final int port2 = this.port;
                BytecodeManager.incBytecodes(3);
                final StringBuilder append2 = append.append(port2);
                BytecodeManager.incBytecodes(1);
                final String string = append2.toString();
                BytecodeManager.incBytecodes(1);
                final IllegalArgumentException ex = new IllegalArgumentException(string);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final String host = this.host;
            BytecodeManager.incBytecodes(3);
            if (host == null) {
                BytecodeManager.incBytecodes(5);
                final StringBuilder sb2 = new StringBuilder();
                final String str2 = "Null host name: ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append3 = sb2.append(str2);
                final String host2 = this.host;
                BytecodeManager.incBytecodes(3);
                final StringBuilder append4 = append3.append(host2);
                BytecodeManager.incBytecodes(1);
                final String string2 = append4.toString();
                BytecodeManager.incBytecodes(1);
                final IllegalArgumentException ex2 = new IllegalArgumentException(string2);
                BytecodeManager.incBytecodes(1);
                throw ex2;
            }
            final String host3 = this.host;
            final int port3 = this.port;
            BytecodeManager.incBytecodes(8);
            this.sock = new Socket(host3, port3);
            BytecodeManager.incBytecodes(1);
            final Socket sock = this.sock;
            BytecodeManager.incBytecodes(3);
            final OutputStream outputStream = sock.getOutputStream();
            BytecodeManager.incBytecodes(1);
            final OutputStream out = outputStream;
            BytecodeManager.incBytecodes(4);
            final BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(out);
            BytecodeManager.incBytecodes(1);
            final BufferedOutputStream outputStream2 = bufferedOutputStream;
            BytecodeManager.incBytecodes(3);
            this.setOutputStream(outputStream2);
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
        //    10: getfield        instrumented/java/util/logging/SocketHandler.sock:Ljava/net/Socket;
        //    13: ldc             3
        //    15: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    18: ifnull          47
        //    21: aload_0        
        //    22: getfield        instrumented/java/util/logging/SocketHandler.sock:Ljava/net/Socket;
        //    25: ldc             3
        //    27: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    30: invokevirtual   java/net/Socket.close:()V
        //    33: ldc             1
        //    35: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    38: goto            47
        //    41: astore_1       
        //    42: ldc             501
        //    44: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    47: aload_0        
        //    48: aconst_null    
        //    49: putfield        instrumented/java/util/logging/SocketHandler.sock:Ljava/net/Socket;
        //    52: ldc             3
        //    54: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    57: ldc             1
        //    59: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    62: return         
        //    63: athrow         
        //    64: athrow         
        //    Exceptions:
        //  throws java.lang.SecurityException
        //    StackMapTable: 00 04 69 07 00 7D 05 FF 00 0F 00 00 00 01 07 00 7B FF 00 00 00 00 00 01 07 00 0F
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  21     64     64     65     Ljava/lang/VirtualMachineError;
        //  21     33     41     47     Ljava/io/IOException;
        //  0      63     63     64     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0047:
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
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
