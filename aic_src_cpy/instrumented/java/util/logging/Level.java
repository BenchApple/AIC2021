// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.logging;

import instrumented.java.util.HashMap;
import java.util.Iterator;
import instrumented.java.util.Collection;
import instrumented.java.util.ArrayList;
import instrumented.java.util.List;
import instrumented.java.util.Map;
import instrumented.java.util.ResourceBundle;
import aic2021.engine.BytecodeManager;
import instrumented.java.util.Locale;
import java.io.Serializable;

public class Level implements Serializable
{
    private static final String defaultBundle = "sun.util.logging.resources.logging";
    private final String name;
    private final int value;
    private final String resourceBundleName;
    private transient String localizedLevelName;
    private transient Locale cachedLocale;
    public static final Level OFF;
    public static final Level SEVERE;
    public static final Level WARNING;
    public static final Level INFO;
    public static final Level CONFIG;
    public static final Level FINE;
    public static final Level FINER;
    public static final Level FINEST;
    public static final Level ALL;
    private static final long serialVersionUID = -8176160795706313070L;
    
    protected Level(final String s, final int n) {
        try {
            final String s2 = null;
            BytecodeManager.incBytecodes(5);
            this(s, n, s2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    protected Level(final String s, final int n, final String s2) {
        try {
            final boolean b = true;
            BytecodeManager.incBytecodes(6);
            this(s, n, s2, b);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private Level(final String name, final int value, final String resourceBundleName, final boolean b) {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            if (name == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            this.name = name;
            BytecodeManager.incBytecodes(3);
            this.value = value;
            BytecodeManager.incBytecodes(3);
            this.resourceBundleName = resourceBundleName;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(3);
            String localizedLevelName;
            if (resourceBundleName == null) {
                localizedLevelName = name;
                BytecodeManager.incBytecodes(2);
            }
            else {
                localizedLevelName = null;
                BytecodeManager.incBytecodes(1);
            }
            this.localizedLevelName = localizedLevelName;
            BytecodeManager.incBytecodes(1);
            this.cachedLocale = null;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(2);
            if (b) {
                BytecodeManager.incBytecodes(2);
                KnownLevel.add(this);
            }
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
    
    public String getName() {
        try {
            final String name = this.name;
            BytecodeManager.incBytecodes(3);
            return name;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public String getLocalizedName() {
        try {
            BytecodeManager.incBytecodes(2);
            final String localizedLevelName = this.getLocalizedLevelName();
            BytecodeManager.incBytecodes(1);
            return localizedLevelName;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final String getLevelName() {
        try {
            final String name = this.name;
            BytecodeManager.incBytecodes(3);
            return name;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private String computeLocalizedLevelName(final Locale locale) {
        try {
            final String resourceBundleName = this.resourceBundleName;
            BytecodeManager.incBytecodes(4);
            final ResourceBundle bundle = ResourceBundle.getBundle(resourceBundleName, locale);
            BytecodeManager.incBytecodes(1);
            final ResourceBundle resourceBundle = bundle;
            final String name = this.name;
            BytecodeManager.incBytecodes(4);
            final String string = resourceBundle.getString(name);
            BytecodeManager.incBytecodes(1);
            final String s = "sun.util.logging.resources.logging";
            final String resourceBundleName2 = this.resourceBundleName;
            BytecodeManager.incBytecodes(4);
            final boolean equals = s.equals(resourceBundleName2);
            BytecodeManager.incBytecodes(1);
            final boolean b = equals;
            BytecodeManager.incBytecodes(2);
            if (!b) {
                final String s2 = string;
                BytecodeManager.incBytecodes(2);
                return s2;
            }
            final ResourceBundle resourceBundle2 = bundle;
            BytecodeManager.incBytecodes(2);
            final Locale locale2 = resourceBundle2.getLocale();
            BytecodeManager.incBytecodes(1);
            final Locale root = Locale.ROOT;
            final Locale locale3 = locale2;
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
            final boolean equals2 = root.equals(locale3);
            BytecodeManager.incBytecodes(1);
            Locale root3 = null;
            Label_0173: {
                if (!equals2) {
                    final String name2 = this.name;
                    final String s3 = string;
                    final Locale root2 = Locale.ROOT;
                    BytecodeManager.incBytecodes(4);
                    BytecodeManager.incBytecodes(1);
                    final String upperCase = s3.toUpperCase(root2);
                    BytecodeManager.incBytecodes(1);
                    final boolean equals3 = name2.equals(upperCase);
                    BytecodeManager.incBytecodes(1);
                    if (!equals3) {
                        root3 = locale2;
                        BytecodeManager.incBytecodes(1);
                        break Label_0173;
                    }
                }
                root3 = Locale.ROOT;
                BytecodeManager.incBytecodes(2);
            }
            final Locale locale4 = root3;
            BytecodeManager.incBytecodes(1);
            final Locale root4 = Locale.ROOT;
            final Locale locale5 = locale4;
            BytecodeManager.incBytecodes(3);
            final boolean equals4 = root4.equals(locale5);
            BytecodeManager.incBytecodes(1);
            String s4;
            if (equals4) {
                s4 = this.name;
                BytecodeManager.incBytecodes(3);
            }
            else {
                final String s5 = string;
                final Locale locale6 = locale4;
                BytecodeManager.incBytecodes(3);
                s4 = s5.toUpperCase(locale6);
            }
            BytecodeManager.incBytecodes(1);
            return s4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final String getCachedLocalizedLevelName() {
        try {
            final String localizedLevelName = this.localizedLevelName;
            BytecodeManager.incBytecodes(3);
            if (localizedLevelName != null) {
                final Locale cachedLocale = this.cachedLocale;
                BytecodeManager.incBytecodes(3);
                if (cachedLocale != null) {
                    final Locale cachedLocale2 = this.cachedLocale;
                    BytecodeManager.incBytecodes(3);
                    final Locale default1 = Locale.getDefault();
                    BytecodeManager.incBytecodes(1);
                    final boolean equals = cachedLocale2.equals(default1);
                    BytecodeManager.incBytecodes(1);
                    if (equals) {
                        final String localizedLevelName2 = this.localizedLevelName;
                        BytecodeManager.incBytecodes(3);
                        return localizedLevelName2;
                    }
                }
            }
            final String resourceBundleName = this.resourceBundleName;
            BytecodeManager.incBytecodes(3);
            if (resourceBundleName == null) {
                final String name = this.name;
                BytecodeManager.incBytecodes(3);
                return name;
            }
            final String s = null;
            BytecodeManager.incBytecodes(2);
            return s;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final synchronized String getLocalizedLevelName() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             2
        //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     6: invokevirtual   instrumented/java/util/logging/Level.getCachedLocalizedLevelName:()Ljava/lang/String;
        //     9: astore_1       
        //    10: ldc             1
        //    12: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    15: aload_1        
        //    16: ldc             2
        //    18: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    21: ifnull          31
        //    24: aload_1        
        //    25: ldc             2
        //    27: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    30: areturn        
        //    31: ldc             1
        //    33: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    36: invokestatic    instrumented/java/util/Locale.getDefault:()Linstrumented/java/util/Locale;
        //    39: astore_2       
        //    40: ldc             1
        //    42: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    45: aload_0        
        //    46: aload_0        
        //    47: aload_2        
        //    48: ldc             4
        //    50: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    53: invokespecial   instrumented/java/util/logging/Level.computeLocalizedLevelName:(Linstrumented/java/util/Locale;)Ljava/lang/String;
        //    56: putfield        instrumented/java/util/logging/Level.localizedLevelName:Ljava/lang/String;
        //    59: ldc             1
        //    61: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    64: ldc             1
        //    66: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    69: goto            91
        //    72: astore_3       
        //    73: ldc             501
        //    75: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    78: aload_0        
        //    79: aload_0        
        //    80: getfield        instrumented/java/util/logging/Level.name:Ljava/lang/String;
        //    83: putfield        instrumented/java/util/logging/Level.localizedLevelName:Ljava/lang/String;
        //    86: ldc             4
        //    88: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    91: aload_0        
        //    92: aload_2        
        //    93: putfield        instrumented/java/util/logging/Level.cachedLocale:Linstrumented/java/util/Locale;
        //    96: ldc             3
        //    98: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   101: aload_0        
        //   102: getfield        instrumented/java/util/logging/Level.localizedLevelName:Ljava/lang/String;
        //   105: ldc             3
        //   107: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   110: areturn        
        //   111: athrow         
        //   112: athrow         
        //    StackMapTable: 00 05 FC 00 1F 07 00 42 FF 00 28 00 03 07 00 02 07 00 42 07 00 6F 00 01 07 00 7E 12 FF 00 13 00 00 00 01 07 00 34 FF 00 00 00 00 00 01 07 00 7C
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  45     112    112    113    Ljava/lang/VirtualMachineError;
        //  45     64     72     91     Ljava/lang/Exception;
        //  0      111    111    112    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0091:
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
    
    static Level findLevel(final String p0) {
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
        //    33: invokestatic    instrumented/java/util/logging/Level$KnownLevel.findByName:(Ljava/lang/String;)Linstrumented/java/util/logging/Level$KnownLevel;
        //    36: astore_1       
        //    37: ldc             1
        //    39: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    42: aload_1        
        //    43: ldc             2
        //    45: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    48: ifnull          61
        //    51: aload_1        
        //    52: getfield        instrumented/java/util/logging/Level$KnownLevel.mirroredLevel:Linstrumented/java/util/logging/Level;
        //    55: ldc             3
        //    57: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    60: areturn        
        //    61: aload_0        
        //    62: ldc             2
        //    64: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    67: invokestatic    java/lang/Integer.parseInt:(Ljava/lang/String;)I
        //    70: istore_2       
        //    71: ldc             1
        //    73: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    76: iload_2        
        //    77: ldc             2
        //    79: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    82: invokestatic    instrumented/java/util/logging/Level$KnownLevel.findByValue:(I)Linstrumented/java/util/logging/Level$KnownLevel;
        //    85: astore_1       
        //    86: ldc             1
        //    88: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    91: aload_1        
        //    92: ldc             2
        //    94: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    97: ifnonnull       135
        //   100: new             Linstrumented/java/util/logging/Level;
        //   103: dup            
        //   104: aload_0        
        //   105: iload_2        
        //   106: ldc             5
        //   108: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   111: invokespecial   instrumented/java/util/logging/Level.<init>:(Ljava/lang/String;I)V
        //   114: astore_3       
        //   115: ldc             1
        //   117: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   120: iload_2        
        //   121: ldc             2
        //   123: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   126: invokestatic    instrumented/java/util/logging/Level$KnownLevel.findByValue:(I)Linstrumented/java/util/logging/Level$KnownLevel;
        //   129: astore_1       
        //   130: ldc             1
        //   132: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   135: aload_1        
        //   136: getfield        instrumented/java/util/logging/Level$KnownLevel.mirroredLevel:Linstrumented/java/util/logging/Level;
        //   139: ldc             2
        //   141: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   144: ldc             1
        //   146: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   149: areturn        
        //   150: astore_2       
        //   151: ldc             501
        //   153: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   156: aload_0        
        //   157: ldc             2
        //   159: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   162: invokestatic    instrumented/java/util/logging/Level$KnownLevel.findByLocalizedLevelName:(Ljava/lang/String;)Linstrumented/java/util/logging/Level$KnownLevel;
        //   165: astore_1       
        //   166: ldc             1
        //   168: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   171: aload_1        
        //   172: ldc             2
        //   174: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   177: ifnull          190
        //   180: aload_1        
        //   181: getfield        instrumented/java/util/logging/Level$KnownLevel.mirroredLevel:Linstrumented/java/util/logging/Level;
        //   184: ldc             3
        //   186: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   189: areturn        
        //   190: aconst_null    
        //   191: ldc             2
        //   193: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   196: areturn        
        //   197: athrow         
        //   198: athrow         
        //    StackMapTable: 00 07 1B FC 00 21 07 00 09 FC 00 49 01 FF 00 0E 00 02 07 00 42 07 00 09 00 01 07 00 87 27 FF 00 06 00 00 00 01 07 00 34 FF 00 00 00 00 00 01 07 00 7C
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                             
        //  -----  -----  -----  -----  ---------------------------------
        //  61     198    198    199    Ljava/lang/VirtualMachineError;
        //  61     144    150    197    Ljava/lang/NumberFormatException;
        //  0      197    197    198    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0061:
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
    public final String toString() {
        try {
            final String name = this.name;
            BytecodeManager.incBytecodes(3);
            return name;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final int intValue() {
        try {
            final int value = this.value;
            BytecodeManager.incBytecodes(3);
            return value;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private Object readResolve() {
        try {
            BytecodeManager.incBytecodes(2);
            final KnownLevel matches = KnownLevel.matches(this);
            BytecodeManager.incBytecodes(1);
            final KnownLevel knownLevel = matches;
            BytecodeManager.incBytecodes(2);
            if (knownLevel != null) {
                final Level levelObject = matches.levelObject;
                BytecodeManager.incBytecodes(3);
                return levelObject;
            }
            final String name = this.name;
            final int value = this.value;
            final String resourceBundleName = this.resourceBundleName;
            BytecodeManager.incBytecodes(9);
            final Level level = new Level(name, value, resourceBundleName);
            BytecodeManager.incBytecodes(1);
            final Level level2 = level;
            BytecodeManager.incBytecodes(2);
            return level2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static synchronized Level parse(final String p0) throws IllegalArgumentException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             2
        //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     6: invokevirtual   java/lang/String.length:()I
        //     9: pop            
        //    10: ldc             1
        //    12: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    15: aload_0        
        //    16: ldc             2
        //    18: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    21: invokestatic    instrumented/java/util/logging/Level$KnownLevel.findByName:(Ljava/lang/String;)Linstrumented/java/util/logging/Level$KnownLevel;
        //    24: astore_1       
        //    25: ldc             1
        //    27: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    30: aload_1        
        //    31: ldc             2
        //    33: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    36: ifnull          49
        //    39: aload_1        
        //    40: getfield        instrumented/java/util/logging/Level$KnownLevel.levelObject:Linstrumented/java/util/logging/Level;
        //    43: ldc             3
        //    45: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    48: areturn        
        //    49: aload_0        
        //    50: ldc             2
        //    52: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    55: invokestatic    java/lang/Integer.parseInt:(Ljava/lang/String;)I
        //    58: istore_2       
        //    59: ldc             1
        //    61: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    64: iload_2        
        //    65: ldc             2
        //    67: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    70: invokestatic    instrumented/java/util/logging/Level$KnownLevel.findByValue:(I)Linstrumented/java/util/logging/Level$KnownLevel;
        //    73: astore_1       
        //    74: ldc             1
        //    76: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    79: aload_1        
        //    80: ldc             2
        //    82: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    85: ifnonnull       123
        //    88: new             Linstrumented/java/util/logging/Level;
        //    91: dup            
        //    92: aload_0        
        //    93: iload_2        
        //    94: ldc             5
        //    96: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    99: invokespecial   instrumented/java/util/logging/Level.<init>:(Ljava/lang/String;I)V
        //   102: astore_3       
        //   103: ldc             1
        //   105: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   108: iload_2        
        //   109: ldc             2
        //   111: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   114: invokestatic    instrumented/java/util/logging/Level$KnownLevel.findByValue:(I)Linstrumented/java/util/logging/Level$KnownLevel;
        //   117: astore_1       
        //   118: ldc             1
        //   120: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   123: aload_1        
        //   124: getfield        instrumented/java/util/logging/Level$KnownLevel.levelObject:Linstrumented/java/util/logging/Level;
        //   127: ldc             2
        //   129: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   132: ldc             1
        //   134: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   137: areturn        
        //   138: astore_2       
        //   139: ldc             501
        //   141: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   144: aload_0        
        //   145: ldc             2
        //   147: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   150: invokestatic    instrumented/java/util/logging/Level$KnownLevel.findByLocalizedLevelName:(Ljava/lang/String;)Linstrumented/java/util/logging/Level$KnownLevel;
        //   153: astore_1       
        //   154: ldc             1
        //   156: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   159: aload_1        
        //   160: ldc             2
        //   162: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   165: ifnull          178
        //   168: aload_1        
        //   169: getfield        instrumented/java/util/logging/Level$KnownLevel.levelObject:Linstrumented/java/util/logging/Level;
        //   172: ldc             3
        //   174: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   177: areturn        
        //   178: new             Ljava/lang/IllegalArgumentException;
        //   181: dup            
        //   182: new             Ljava/lang/StringBuilder;
        //   185: dup            
        //   186: ldc             5
        //   188: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   191: invokespecial   java/lang/StringBuilder.<init>:()V
        //   194: ldc             "Bad level \""
        //   196: ldc             2
        //   198: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   201: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   204: aload_0        
        //   205: ldc             2
        //   207: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   210: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   213: ldc             "\""
        //   215: ldc             2
        //   217: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   220: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   223: ldc             1
        //   225: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   228: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   231: ldc             1
        //   233: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   236: invokespecial   java/lang/IllegalArgumentException.<init>:(Ljava/lang/String;)V
        //   239: ldc             1
        //   241: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   244: athrow         
        //   245: athrow         
        //   246: athrow         
        //    Exceptions:
        //  throws java.lang.IllegalArgumentException
        //    StackMapTable: 00 06 FC 00 31 07 00 09 FC 00 49 01 FF 00 0E 00 02 07 00 42 07 00 09 00 01 07 00 87 27 FF 00 42 00 00 00 01 07 00 34 FF 00 00 00 00 00 01 07 00 7C
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                             
        //  -----  -----  -----  -----  ---------------------------------
        //  49     246    246    247    Ljava/lang/VirtualMachineError;
        //  49     132    138    245    Ljava/lang/NumberFormatException;
        //  0      245    245    246    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0049:
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
    public boolean equals(final Object o) {
        try {
            try {
                final Level level = (Level)o;
                BytecodeManager.incBytecodes(3);
                final int value = level.value;
                final int value2 = this.value;
                BytecodeManager.incBytecodes(5);
                boolean b;
                if (value == value2) {
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
            catch (Exception ex) {
                BytecodeManager.incBytecodes(501);
                final boolean b2 = false;
                BytecodeManager.incBytecodes(2);
                return b2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        catch (VirtualMachineError virtualMachineError) {
            throw virtualMachineError;
        }
    }
    
    @Override
    public int hashCode() {
        try {
            final int value = this.value;
            BytecodeManager.incBytecodes(3);
            return value;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static /* synthetic */ String access$000(final Level level) {
        try {
            final String name = level.name;
            BytecodeManager.incBytecodes(3);
            return name;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static /* synthetic */ int access$100(final Level level) {
        try {
            final int value = level.value;
            BytecodeManager.incBytecodes(3);
            return value;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static /* synthetic */ String access$200(final Level level) {
        try {
            final String resourceBundleName = level.resourceBundleName;
            BytecodeManager.incBytecodes(3);
            return resourceBundleName;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static {
        try {
            final String s = "OFF";
            final int n = Integer.MAX_VALUE;
            final String s2 = "sun.util.logging.resources.logging";
            BytecodeManager.incBytecodes(6);
            OFF = new Level(s, n, s2);
            BytecodeManager.incBytecodes(1);
            final String s3 = "SEVERE";
            final int n2 = 1000;
            final String s4 = "sun.util.logging.resources.logging";
            BytecodeManager.incBytecodes(6);
            SEVERE = new Level(s3, n2, s4);
            BytecodeManager.incBytecodes(1);
            final String s5 = "WARNING";
            final int n3 = 900;
            final String s6 = "sun.util.logging.resources.logging";
            BytecodeManager.incBytecodes(6);
            WARNING = new Level(s5, n3, s6);
            BytecodeManager.incBytecodes(1);
            final String s7 = "INFO";
            final int n4 = 800;
            final String s8 = "sun.util.logging.resources.logging";
            BytecodeManager.incBytecodes(6);
            INFO = new Level(s7, n4, s8);
            BytecodeManager.incBytecodes(1);
            final String s9 = "CONFIG";
            final int n5 = 700;
            final String s10 = "sun.util.logging.resources.logging";
            BytecodeManager.incBytecodes(6);
            CONFIG = new Level(s9, n5, s10);
            BytecodeManager.incBytecodes(1);
            final String s11 = "FINE";
            final int n6 = 500;
            final String s12 = "sun.util.logging.resources.logging";
            BytecodeManager.incBytecodes(6);
            FINE = new Level(s11, n6, s12);
            BytecodeManager.incBytecodes(1);
            final String s13 = "FINER";
            final int n7 = 400;
            final String s14 = "sun.util.logging.resources.logging";
            BytecodeManager.incBytecodes(6);
            FINER = new Level(s13, n7, s14);
            BytecodeManager.incBytecodes(1);
            final String s15 = "FINEST";
            final int n8 = 300;
            final String s16 = "sun.util.logging.resources.logging";
            BytecodeManager.incBytecodes(6);
            FINEST = new Level(s15, n8, s16);
            BytecodeManager.incBytecodes(1);
            final String s17 = "ALL";
            final int n9 = Integer.MIN_VALUE;
            final String s18 = "sun.util.logging.resources.logging";
            BytecodeManager.incBytecodes(6);
            ALL = new Level(s17, n9, s18);
            BytecodeManager.incBytecodes(2);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static final class KnownLevel
    {
        private static Map<String, List<KnownLevel>> nameToLevels;
        private static Map<Integer, List<KnownLevel>> intToLevels;
        final Level levelObject;
        final Level mirroredLevel;
        
        KnownLevel(final Level level) {
            try {
                BytecodeManager.incBytecodes(2);
                this.levelObject = level;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(2);
                final Class<? extends Level> class1 = level.getClass();
                final Class<Level> clazz = Level.class;
                BytecodeManager.incBytecodes(2);
                if (class1 == clazz) {
                    this.mirroredLevel = level;
                    BytecodeManager.incBytecodes(4);
                }
                else {
                    BytecodeManager.incBytecodes(5);
                    final String access$000 = Level.access$000(level);
                    BytecodeManager.incBytecodes(2);
                    final int access$2 = Level.access$100(level);
                    BytecodeManager.incBytecodes(2);
                    final String access$3 = Level.access$200(level);
                    final boolean b = false;
                    final Object object = null;
                    BytecodeManager.incBytecodes(3);
                    this.mirroredLevel = new Level(access$000, access$2, access$3, b, object);
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static synchronized void add(final Level level) {
            try {
                BytecodeManager.incBytecodes(4);
                final KnownLevel knownLevel = new KnownLevel(level);
                BytecodeManager.incBytecodes(1);
                final Map<String, List<KnownLevel>> nameToLevels = KnownLevel.nameToLevels;
                BytecodeManager.incBytecodes(3);
                final String access$000 = Level.access$000(level);
                BytecodeManager.incBytecodes(1);
                List<KnownLevel> list = nameToLevels.get(access$000);
                BytecodeManager.incBytecodes(2);
                final List<KnownLevel> list2 = list;
                BytecodeManager.incBytecodes(2);
                if (list2 == null) {
                    BytecodeManager.incBytecodes(3);
                    list = new ArrayList<KnownLevel>();
                    BytecodeManager.incBytecodes(1);
                    final Map<String, List<KnownLevel>> nameToLevels2 = KnownLevel.nameToLevels;
                    BytecodeManager.incBytecodes(3);
                    final String access$2 = Level.access$000(level);
                    final List<KnownLevel> list3 = list;
                    BytecodeManager.incBytecodes(2);
                    nameToLevels2.put(access$2, list3);
                    BytecodeManager.incBytecodes(1);
                }
                final List<KnownLevel> list4 = list;
                final KnownLevel knownLevel2 = knownLevel;
                BytecodeManager.incBytecodes(3);
                list4.add(knownLevel2);
                BytecodeManager.incBytecodes(1);
                final Map<Integer, List<KnownLevel>> intToLevels = KnownLevel.intToLevels;
                BytecodeManager.incBytecodes(3);
                final int access$3 = Level.access$100(level);
                BytecodeManager.incBytecodes(1);
                final Integer value = access$3;
                BytecodeManager.incBytecodes(1);
                List<KnownLevel> list5 = intToLevels.get(value);
                BytecodeManager.incBytecodes(2);
                final List<KnownLevel> list6 = list5;
                BytecodeManager.incBytecodes(2);
                if (list6 == null) {
                    BytecodeManager.incBytecodes(3);
                    list5 = new ArrayList<KnownLevel>();
                    BytecodeManager.incBytecodes(1);
                    final Map<Integer, List<KnownLevel>> intToLevels2 = KnownLevel.intToLevels;
                    BytecodeManager.incBytecodes(3);
                    final int access$4 = Level.access$100(level);
                    BytecodeManager.incBytecodes(1);
                    final Integer value2 = access$4;
                    final List<KnownLevel> list7 = list5;
                    BytecodeManager.incBytecodes(2);
                    intToLevels2.put(value2, list7);
                    BytecodeManager.incBytecodes(1);
                }
                final List<KnownLevel> list8 = list5;
                final KnownLevel knownLevel3 = knownLevel;
                BytecodeManager.incBytecodes(3);
                list8.add(knownLevel3);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static synchronized KnownLevel findByName(final String s) {
            try {
                final Map<String, List<KnownLevel>> nameToLevels = KnownLevel.nameToLevels;
                BytecodeManager.incBytecodes(3);
                final List<KnownLevel> list = nameToLevels.get(s);
                BytecodeManager.incBytecodes(2);
                final List<KnownLevel> list2 = list;
                BytecodeManager.incBytecodes(2);
                if (list2 != null) {
                    final List<KnownLevel> list3 = list;
                    final int n = 0;
                    BytecodeManager.incBytecodes(3);
                    final KnownLevel knownLevel = list3.get(n);
                    BytecodeManager.incBytecodes(2);
                    return knownLevel;
                }
                final KnownLevel knownLevel2 = null;
                BytecodeManager.incBytecodes(2);
                return knownLevel2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static synchronized KnownLevel findByValue(final int i) {
            try {
                final Map<Integer, List<KnownLevel>> intToLevels = KnownLevel.intToLevels;
                BytecodeManager.incBytecodes(3);
                final Integer value = i;
                BytecodeManager.incBytecodes(1);
                final List<KnownLevel> list = intToLevels.get(value);
                BytecodeManager.incBytecodes(2);
                final List<KnownLevel> list2 = list;
                BytecodeManager.incBytecodes(2);
                if (list2 != null) {
                    final List<KnownLevel> list3 = list;
                    final int n = 0;
                    BytecodeManager.incBytecodes(3);
                    final KnownLevel knownLevel = list3.get(n);
                    BytecodeManager.incBytecodes(2);
                    return knownLevel;
                }
                final KnownLevel knownLevel2 = null;
                BytecodeManager.incBytecodes(2);
                return knownLevel2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static synchronized KnownLevel findByLocalizedLevelName(final String s) {
            try {
                final Map<String, List<KnownLevel>> nameToLevels = KnownLevel.nameToLevels;
                BytecodeManager.incBytecodes(2);
                final Collection<List<KnownLevel>> values = nameToLevels.values();
                BytecodeManager.incBytecodes(1);
                final Iterator<List<KnownLevel>> iterator = values.iterator();
                BytecodeManager.incBytecodes(1);
                while (true) {
                    final Iterator<List<KnownLevel>> iterator2 = iterator;
                    BytecodeManager.incBytecodes(2);
                    final boolean hasNext = iterator2.hasNext();
                    BytecodeManager.incBytecodes(1);
                    if (!hasNext) {
                        final KnownLevel knownLevel = null;
                        BytecodeManager.incBytecodes(2);
                        return knownLevel;
                    }
                    final Iterator<List<KnownLevel>> iterator3 = iterator;
                    BytecodeManager.incBytecodes(2);
                    final List<KnownLevel> list = iterator3.next();
                    BytecodeManager.incBytecodes(2);
                    final List<KnownLevel> list2 = list;
                    BytecodeManager.incBytecodes(2);
                    final Iterator<KnownLevel> iterator4 = list2.iterator();
                    BytecodeManager.incBytecodes(1);
                    while (true) {
                        final Iterator<KnownLevel> iterator5 = iterator4;
                        BytecodeManager.incBytecodes(2);
                        final boolean hasNext2 = iterator5.hasNext();
                        BytecodeManager.incBytecodes(1);
                        if (!hasNext2) {
                            BytecodeManager.incBytecodes(1);
                            break;
                        }
                        final Iterator<KnownLevel> iterator6 = iterator4;
                        BytecodeManager.incBytecodes(2);
                        final KnownLevel knownLevel2 = iterator6.next();
                        BytecodeManager.incBytecodes(2);
                        final Level levelObject = knownLevel2.levelObject;
                        BytecodeManager.incBytecodes(3);
                        final String localizedLevelName = levelObject.getLocalizedLevelName();
                        BytecodeManager.incBytecodes(1);
                        final String anObject = localizedLevelName;
                        BytecodeManager.incBytecodes(3);
                        final boolean equals = s.equals(anObject);
                        BytecodeManager.incBytecodes(1);
                        if (equals) {
                            final KnownLevel knownLevel3 = knownLevel2;
                            BytecodeManager.incBytecodes(2);
                            return knownLevel3;
                        }
                        BytecodeManager.incBytecodes(1);
                    }
                }
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static synchronized KnownLevel matches(final Level level) {
            try {
                final Map<String, List<KnownLevel>> nameToLevels = KnownLevel.nameToLevels;
                BytecodeManager.incBytecodes(3);
                final String access$000 = Level.access$000(level);
                BytecodeManager.incBytecodes(1);
                final List<KnownLevel> list = nameToLevels.get(access$000);
                BytecodeManager.incBytecodes(2);
                final List<KnownLevel> list2 = list;
                BytecodeManager.incBytecodes(2);
                Label_0243: {
                    if (list2 != null) {
                        final List<KnownLevel> list3 = list;
                        BytecodeManager.incBytecodes(2);
                        final Iterator<KnownLevel> iterator = list3.iterator();
                        BytecodeManager.incBytecodes(1);
                        KnownLevel knownLevel;
                        while (true) {
                            final Iterator<KnownLevel> iterator2 = iterator;
                            BytecodeManager.incBytecodes(2);
                            final boolean hasNext = iterator2.hasNext();
                            BytecodeManager.incBytecodes(1);
                            if (!hasNext) {
                                break Label_0243;
                            }
                            final Iterator<KnownLevel> iterator3 = iterator;
                            BytecodeManager.incBytecodes(2);
                            knownLevel = iterator3.next();
                            BytecodeManager.incBytecodes(2);
                            final Level mirroredLevel = knownLevel.mirroredLevel;
                            BytecodeManager.incBytecodes(3);
                            BytecodeManager.incBytecodes(2);
                            final int access$2 = Level.access$100(level);
                            final Level level2 = mirroredLevel;
                            BytecodeManager.incBytecodes(2);
                            final int access$3 = Level.access$100(level2);
                            BytecodeManager.incBytecodes(1);
                            if (access$2 == access$3) {
                                BytecodeManager.incBytecodes(1);
                                BytecodeManager.incBytecodes(1);
                                final String access$4 = Level.access$200(level);
                                final Level level3 = mirroredLevel;
                                BytecodeManager.incBytecodes(2);
                                final String access$5 = Level.access$200(level3);
                                BytecodeManager.incBytecodes(1);
                                if (access$4 == access$5) {
                                    break;
                                }
                                BytecodeManager.incBytecodes(1);
                                BytecodeManager.incBytecodes(1);
                                final String access$6 = Level.access$200(level);
                                BytecodeManager.incBytecodes(1);
                                if (access$6 != null) {
                                    BytecodeManager.incBytecodes(1);
                                    BytecodeManager.incBytecodes(1);
                                    final String access$7 = Level.access$200(level);
                                    final Level level4 = mirroredLevel;
                                    BytecodeManager.incBytecodes(2);
                                    final String access$8 = Level.access$200(level4);
                                    BytecodeManager.incBytecodes(1);
                                    final boolean equals = access$7.equals(access$8);
                                    BytecodeManager.incBytecodes(1);
                                    if (equals) {
                                        break;
                                    }
                                }
                            }
                            BytecodeManager.incBytecodes(1);
                        }
                        final KnownLevel knownLevel2 = knownLevel;
                        BytecodeManager.incBytecodes(2);
                        return knownLevel2;
                    }
                }
                final KnownLevel knownLevel3 = null;
                BytecodeManager.incBytecodes(2);
                return knownLevel3;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static {
            try {
                BytecodeManager.incBytecodes(3);
                KnownLevel.nameToLevels = new HashMap<String, List<KnownLevel>>();
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(3);
                KnownLevel.intToLevels = new HashMap<Integer, List<KnownLevel>>();
                BytecodeManager.incBytecodes(2);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
}
