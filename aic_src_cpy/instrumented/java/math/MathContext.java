// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.math;

import java.io.IOException;
import java.io.StreamCorruptedException;
import java.io.ObjectInputStream;
import aic2021.engine.BytecodeManager;
import java.io.Serializable;

public final class MathContext implements Serializable
{
    private static final int DEFAULT_DIGITS = 9;
    private static final RoundingMode DEFAULT_ROUNDINGMODE;
    private static final int MIN_DIGITS = 0;
    private static final long serialVersionUID = 5579720004786848255L;
    public static final MathContext UNLIMITED;
    public static final MathContext DECIMAL32;
    public static final MathContext DECIMAL64;
    public static final MathContext DECIMAL128;
    final int precision;
    final RoundingMode roundingMode;
    
    public MathContext(final int n) {
        try {
            final RoundingMode default_ROUNDINGMODE = MathContext.DEFAULT_ROUNDINGMODE;
            BytecodeManager.incBytecodes(4);
            this(n, default_ROUNDINGMODE);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public MathContext(final int precision, final RoundingMode roundingMode) {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            if (precision < 0) {
                final String s = "Digits < 0";
                BytecodeManager.incBytecodes(4);
                final IllegalArgumentException ex = new IllegalArgumentException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(2);
            if (roundingMode == null) {
                final String s2 = "null RoundingMode";
                BytecodeManager.incBytecodes(4);
                final NullPointerException ex2 = new NullPointerException(s2);
                BytecodeManager.incBytecodes(1);
                throw ex2;
            }
            this.precision = precision;
            BytecodeManager.incBytecodes(3);
            this.roundingMode = roundingMode;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public MathContext(final String p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             2
        //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     6: invokespecial   java/lang/Object.<init>:()V
        //     9: iconst_0       
        //    10: istore_2       
        //    11: ldc             2
        //    13: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    16: aload_1        
        //    17: ldc             2
        //    19: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    22: ifnonnull       45
        //    25: new             Ljava/lang/NullPointerException;
        //    28: dup            
        //    29: ldc             "null String"
        //    31: ldc             4
        //    33: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    36: invokespecial   java/lang/NullPointerException.<init>:(Ljava/lang/String;)V
        //    39: ldc             1
        //    41: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    44: athrow         
        //    45: aload_1        
        //    46: ldc             "precision="
        //    48: ldc             3
        //    50: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    53: invokevirtual   java/lang/String.startsWith:(Ljava/lang/String;)Z
        //    56: ldc             1
        //    58: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    61: ifne            82
        //    64: new             Ljava/lang/RuntimeException;
        //    67: dup            
        //    68: ldc             3
        //    70: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    73: invokespecial   java/lang/RuntimeException.<init>:()V
        //    76: ldc             1
        //    78: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    81: athrow         
        //    82: aload_1        
        //    83: bipush          32
        //    85: ldc             3
        //    87: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    90: invokevirtual   java/lang/String.indexOf:(I)I
        //    93: istore          4
        //    95: ldc             1
        //    97: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   100: bipush          10
        //   102: istore          5
        //   104: ldc             2
        //   106: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   109: aload_1        
        //   110: bipush          10
        //   112: iload           4
        //   114: ldc             4
        //   116: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   119: invokevirtual   java/lang/String.substring:(II)Ljava/lang/String;
        //   122: ldc             1
        //   124: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   127: invokestatic    java/lang/Integer.parseInt:(Ljava/lang/String;)I
        //   130: istore_3       
        //   131: ldc             1
        //   133: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   136: aload_1        
        //   137: ldc             "roundingMode="
        //   139: iload           4
        //   141: iconst_1       
        //   142: iadd           
        //   143: ldc             6
        //   145: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   148: invokevirtual   java/lang/String.startsWith:(Ljava/lang/String;I)Z
        //   151: ldc             1
        //   153: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   156: ifne            177
        //   159: new             Ljava/lang/RuntimeException;
        //   162: dup            
        //   163: ldc             3
        //   165: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   168: invokespecial   java/lang/RuntimeException.<init>:()V
        //   171: ldc             1
        //   173: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   176: athrow         
        //   177: iload           4
        //   179: iconst_1       
        //   180: iadd           
        //   181: bipush          13
        //   183: iadd           
        //   184: istore          5
        //   186: ldc             6
        //   188: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   191: aload_1        
        //   192: iload           5
        //   194: aload_1        
        //   195: ldc             4
        //   197: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   200: invokevirtual   java/lang/String.length:()I
        //   203: ldc             1
        //   205: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   208: invokevirtual   java/lang/String.substring:(II)Ljava/lang/String;
        //   211: astore          6
        //   213: ldc             1
        //   215: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   218: aload_0        
        //   219: aload           6
        //   221: ldc             3
        //   223: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   226: invokestatic    instrumented/java/math/RoundingMode.valueOf:(Ljava/lang/String;)Linstrumented/java/math/RoundingMode;
        //   229: putfield        instrumented/java/math/MathContext.roundingMode:Linstrumented/java/math/RoundingMode;
        //   232: ldc             1
        //   234: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   237: ldc             1
        //   239: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   242: goto            272
        //   245: astore          4
        //   247: ldc             501
        //   249: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   252: new             Ljava/lang/IllegalArgumentException;
        //   255: dup            
        //   256: ldc             "bad string format"
        //   258: ldc             4
        //   260: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   263: invokespecial   java/lang/IllegalArgumentException.<init>:(Ljava/lang/String;)V
        //   266: ldc             1
        //   268: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   271: athrow         
        //   272: iload_3        
        //   273: ldc             2
        //   275: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   278: ifge            301
        //   281: new             Ljava/lang/IllegalArgumentException;
        //   284: dup            
        //   285: ldc             "Digits < 0"
        //   287: ldc             4
        //   289: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   292: invokespecial   java/lang/IllegalArgumentException.<init>:(Ljava/lang/String;)V
        //   295: ldc             1
        //   297: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   300: athrow         
        //   301: aload_0        
        //   302: iload_3        
        //   303: putfield        instrumented/java/math/MathContext.precision:I
        //   306: ldc             3
        //   308: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   311: ldc             1
        //   313: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   316: return         
        //   317: athrow         
        //   318: athrow         
        //    StackMapTable: 00 08 FF 00 2D 00 03 07 00 02 07 00 48 01 00 00 24 FE 00 5E 01 01 01 FF 00 43 00 03 07 00 02 07 00 48 01 00 01 07 00 44 FC 00 1A 01 1C FF 00 0F 00 00 00 01 07 00 29 FF 00 00 00 00 00 01 07 00 42
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  45     318    318    319    Ljava/lang/VirtualMachineError;
        //  45     237    245    272    Ljava/lang/RuntimeException;
        //  0      317    317    318    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0045:
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
    
    public int getPrecision() {
        try {
            final int precision = this.precision;
            BytecodeManager.incBytecodes(3);
            return precision;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public RoundingMode getRoundingMode() {
        try {
            final RoundingMode roundingMode = this.roundingMode;
            BytecodeManager.incBytecodes(3);
            return roundingMode;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean equals(final Object o) {
        try {
            final boolean b = o instanceof MathContext;
            BytecodeManager.incBytecodes(3);
            if (!b) {
                final boolean b2 = false;
                BytecodeManager.incBytecodes(2);
                return b2;
            }
            final MathContext mathContext = (MathContext)o;
            BytecodeManager.incBytecodes(3);
            final int precision = mathContext.precision;
            final int precision2 = this.precision;
            BytecodeManager.incBytecodes(5);
            boolean b3 = false;
            Label_0076: {
                if (precision == precision2) {
                    final RoundingMode roundingMode = mathContext.roundingMode;
                    final RoundingMode roundingMode2 = this.roundingMode;
                    BytecodeManager.incBytecodes(5);
                    if (roundingMode == roundingMode2) {
                        b3 = true;
                        BytecodeManager.incBytecodes(2);
                        break Label_0076;
                    }
                }
                b3 = false;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return b3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public int hashCode() {
        try {
            final int precision = this.precision;
            final RoundingMode roundingMode = this.roundingMode;
            BytecodeManager.incBytecodes(5);
            final int n = precision + roundingMode.hashCode() * 59;
            BytecodeManager.incBytecodes(4);
            return n;
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
            final String str = "precision=";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append = sb.append(str);
            final int precision = this.precision;
            BytecodeManager.incBytecodes(3);
            final StringBuilder append2 = append.append(precision);
            final String str2 = " ";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append3 = append2.append(str2);
            final String str3 = "roundingMode=";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append4 = append3.append(str3);
            final RoundingMode roundingMode = this.roundingMode;
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
            final String string = roundingMode.toString();
            BytecodeManager.incBytecodes(1);
            final StringBuilder append5 = append4.append(string);
            BytecodeManager.incBytecodes(1);
            final String string2 = append5.toString();
            BytecodeManager.incBytecodes(1);
            return string2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void readObject(final ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            BytecodeManager.incBytecodes(2);
            objectInputStream.defaultReadObject();
            final int precision = this.precision;
            BytecodeManager.incBytecodes(3);
            if (precision < 0) {
                final String s = "MathContext: invalid digits in stream";
                BytecodeManager.incBytecodes(2);
                final String reason = s;
                BytecodeManager.incBytecodes(4);
                final StreamCorruptedException ex = new StreamCorruptedException(reason);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final RoundingMode roundingMode = this.roundingMode;
            BytecodeManager.incBytecodes(3);
            if (roundingMode == null) {
                final String s2 = "MathContext: null roundingMode in stream";
                BytecodeManager.incBytecodes(2);
                final String reason2 = s2;
                BytecodeManager.incBytecodes(4);
                final StreamCorruptedException ex2 = new StreamCorruptedException(reason2);
                BytecodeManager.incBytecodes(1);
                throw ex2;
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static {
        try {
            DEFAULT_ROUNDINGMODE = RoundingMode.HALF_UP;
            BytecodeManager.incBytecodes(2);
            final int n = 0;
            final RoundingMode half_UP = RoundingMode.HALF_UP;
            BytecodeManager.incBytecodes(5);
            UNLIMITED = new MathContext(n, half_UP);
            BytecodeManager.incBytecodes(1);
            final int n2 = 7;
            final RoundingMode half_EVEN = RoundingMode.HALF_EVEN;
            BytecodeManager.incBytecodes(5);
            DECIMAL32 = new MathContext(n2, half_EVEN);
            BytecodeManager.incBytecodes(1);
            final int n3 = 16;
            final RoundingMode half_EVEN2 = RoundingMode.HALF_EVEN;
            BytecodeManager.incBytecodes(5);
            DECIMAL64 = new MathContext(n3, half_EVEN2);
            BytecodeManager.incBytecodes(1);
            final int n4 = 34;
            final RoundingMode half_EVEN3 = RoundingMode.HALF_EVEN;
            BytecodeManager.incBytecodes(5);
            DECIMAL128 = new MathContext(n4, half_EVEN3);
            BytecodeManager.incBytecodes(2);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
