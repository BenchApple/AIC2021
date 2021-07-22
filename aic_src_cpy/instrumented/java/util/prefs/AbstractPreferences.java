// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.prefs;

import instrumented.java.util.LinkedList;
import java.io.IOException;
import java.io.OutputStream;
import java.security.AccessController;
import java.security.PrivilegedAction;
import instrumented.java.util.StringTokenizer;
import instrumented.java.util.Collection;
import instrumented.java.util.HashMap;
import aic2021.engine.BytecodeManager;
import instrumented.java.util.EventObject;
import instrumented.java.util.List;
import instrumented.java.util.Map;

public abstract class AbstractPreferences extends Preferences
{
    private final String name;
    private final String absolutePath;
    final AbstractPreferences parent;
    private final AbstractPreferences root;
    protected boolean newNode;
    private Map<String, AbstractPreferences> kidCache;
    private boolean removed;
    private PreferenceChangeListener[] prefListeners;
    private NodeChangeListener[] nodeListeners;
    protected final Object lock;
    private static final String[] EMPTY_STRING_ARRAY;
    private static final AbstractPreferences[] EMPTY_ABSTRACT_PREFS_ARRAY;
    private static final List<EventObject> eventQueue;
    private static Thread eventDispatchThread;
    
    protected AbstractPreferences(final AbstractPreferences parent, final String name) {
        try {
            BytecodeManager.incBytecodes(2);
            this.newNode = false;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(4);
            this.kidCache = new HashMap<String, AbstractPreferences>();
            BytecodeManager.incBytecodes(1);
            this.removed = false;
            BytecodeManager.incBytecodes(3);
            this.prefListeners = new PreferenceChangeListener[0];
            BytecodeManager.incBytecodes(3);
            this.nodeListeners = new NodeChangeListener[0];
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(4);
            this.lock = new Object();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            if (parent == null) {
                final String anObject = "";
                BytecodeManager.incBytecodes(3);
                final boolean equals = name.equals(anObject);
                BytecodeManager.incBytecodes(1);
                if (!equals) {
                    BytecodeManager.incBytecodes(5);
                    final StringBuilder sb = new StringBuilder();
                    final String str = "Root name '";
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append = sb.append(str);
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append2 = append.append(name);
                    final String str2 = "' must be \"\"";
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append3 = append2.append(str2);
                    BytecodeManager.incBytecodes(1);
                    final String string = append3.toString();
                    BytecodeManager.incBytecodes(1);
                    final IllegalArgumentException ex = new IllegalArgumentException(string);
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                this.absolutePath = "/";
                BytecodeManager.incBytecodes(3);
                this.root = this;
                BytecodeManager.incBytecodes(4);
            }
            else {
                final int ch = 47;
                BytecodeManager.incBytecodes(3);
                final int index = name.indexOf(ch);
                final int n = -1;
                BytecodeManager.incBytecodes(2);
                if (index != n) {
                    BytecodeManager.incBytecodes(5);
                    final StringBuilder sb2 = new StringBuilder();
                    final String str3 = "Name '";
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append4 = sb2.append(str3);
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append5 = append4.append(name);
                    final String str4 = "' contains '/'";
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append6 = append5.append(str4);
                    BytecodeManager.incBytecodes(1);
                    final String string2 = append6.toString();
                    BytecodeManager.incBytecodes(1);
                    final IllegalArgumentException ex2 = new IllegalArgumentException(string2);
                    BytecodeManager.incBytecodes(1);
                    throw ex2;
                }
                final String anObject2 = "";
                BytecodeManager.incBytecodes(3);
                final boolean equals2 = name.equals(anObject2);
                BytecodeManager.incBytecodes(1);
                if (equals2) {
                    final String s = "Illegal name: empty string";
                    BytecodeManager.incBytecodes(4);
                    final IllegalArgumentException ex3 = new IllegalArgumentException(s);
                    BytecodeManager.incBytecodes(1);
                    throw ex3;
                }
                this.root = parent.root;
                BytecodeManager.incBytecodes(4);
                final AbstractPreferences root = this.root;
                BytecodeManager.incBytecodes(5);
                String absolutePath;
                if (parent == root) {
                    BytecodeManager.incBytecodes(3);
                    final StringBuilder sb3 = new StringBuilder();
                    final String str5 = "/";
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append7 = sb3.append(str5);
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append8 = append7.append(name);
                    BytecodeManager.incBytecodes(1);
                    absolutePath = append8.toString();
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    BytecodeManager.incBytecodes(3);
                    final StringBuilder sb4 = new StringBuilder();
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    final String absolutePath2 = parent.absolutePath();
                    BytecodeManager.incBytecodes(1);
                    final StringBuilder append9 = sb4.append(absolutePath2);
                    final String str6 = "/";
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append10 = append9.append(str6);
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append11 = append10.append(name);
                    BytecodeManager.incBytecodes(1);
                    absolutePath = append11.toString();
                }
                this.absolutePath = absolutePath;
                BytecodeManager.incBytecodes(1);
            }
            this.name = name;
            BytecodeManager.incBytecodes(3);
            this.parent = parent;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void put(final String p0, final String p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             2
        //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     6: ifnull          18
        //     9: aload_2        
        //    10: ldc             2
        //    12: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    15: ifnonnull       36
        //    18: new             Ljava/lang/NullPointerException;
        //    21: dup            
        //    22: ldc             3
        //    24: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    27: invokespecial   java/lang/NullPointerException.<init>:()V
        //    30: ldc             1
        //    32: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    35: athrow         
        //    36: aload_1        
        //    37: ldc             2
        //    39: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    42: invokevirtual   java/lang/String.length:()I
        //    45: bipush          80
        //    47: ldc             2
        //    49: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    52: if_icmple       112
        //    55: new             Ljava/lang/IllegalArgumentException;
        //    58: dup            
        //    59: new             Ljava/lang/StringBuilder;
        //    62: dup            
        //    63: ldc             5
        //    65: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    68: invokespecial   java/lang/StringBuilder.<init>:()V
        //    71: ldc             "Key too long: "
        //    73: ldc             2
        //    75: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    78: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    81: aload_1        
        //    82: ldc             2
        //    84: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    87: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    90: ldc             1
        //    92: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    95: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    98: ldc             1
        //   100: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   103: invokespecial   java/lang/IllegalArgumentException.<init>:(Ljava/lang/String;)V
        //   106: ldc             1
        //   108: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   111: athrow         
        //   112: aload_2        
        //   113: ldc             2
        //   115: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   118: invokevirtual   java/lang/String.length:()I
        //   121: sipush          8192
        //   124: ldc             2
        //   126: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   129: if_icmple       189
        //   132: new             Ljava/lang/IllegalArgumentException;
        //   135: dup            
        //   136: new             Ljava/lang/StringBuilder;
        //   139: dup            
        //   140: ldc             5
        //   142: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   145: invokespecial   java/lang/StringBuilder.<init>:()V
        //   148: ldc             "Value too long: "
        //   150: ldc             2
        //   152: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   155: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   158: aload_2        
        //   159: ldc             2
        //   161: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   164: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   167: ldc             1
        //   169: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   172: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   175: ldc             1
        //   177: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   180: invokespecial   java/lang/IllegalArgumentException.<init>:(Ljava/lang/String;)V
        //   183: ldc             1
        //   185: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   188: athrow         
        //   189: aload_0        
        //   190: getfield        instrumented/java/util/prefs/AbstractPreferences.lock:Ljava/lang/Object;
        //   193: dup            
        //   194: astore_3       
        //   195: pop            
        //   196: ldc             5
        //   198: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   201: aload_0        
        //   202: getfield        instrumented/java/util/prefs/AbstractPreferences.removed:Z
        //   205: ldc             3
        //   207: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   210: ifeq            233
        //   213: new             Ljava/lang/IllegalStateException;
        //   216: dup            
        //   217: ldc             "Node has been removed."
        //   219: ldc             4
        //   221: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   224: invokespecial   java/lang/IllegalStateException.<init>:(Ljava/lang/String;)V
        //   227: ldc             1
        //   229: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   232: athrow         
        //   233: aload_0        
        //   234: aload_1        
        //   235: aload_2        
        //   236: ldc             4
        //   238: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   241: invokevirtual   instrumented/java/util/prefs/AbstractPreferences.putSpi:(Ljava/lang/String;Ljava/lang/String;)V
        //   244: aload_0        
        //   245: aload_1        
        //   246: aload_2        
        //   247: ldc             4
        //   249: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   252: invokespecial   instrumented/java/util/prefs/AbstractPreferences.enqueuePreferenceChangeEvent:(Ljava/lang/String;Ljava/lang/String;)V
        //   255: aload_3        
        //   256: pop            
        //   257: ldc             2
        //   259: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   262: ldc             1
        //   264: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   267: goto            287
        //   270: astore          4
        //   272: aload_3        
        //   273: pop            
        //   274: ldc             503
        //   276: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   279: aload           4
        //   281: ldc             2
        //   283: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   286: athrow         
        //   287: ldc             1
        //   289: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   292: return         
        //   293: athrow         
        //   294: athrow         
        //    StackMapTable: 00 09 12 11 FB 00 4B FB 00 4C FC 00 2B 07 00 4D 64 07 00 85 FA 00 10 FF 00 05 00 00 00 01 07 00 85 FF 00 00 00 00 00 01 07 00 89
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  201    294    294    295    Ljava/lang/VirtualMachineError;
        //  201    262    270    287    Any
        //  270    279    270    287    Any
        //  0      293    293    294    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0233:
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
    public String get(final String p0, final String p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             2
        //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     6: ifnonnull       29
        //     9: new             Ljava/lang/NullPointerException;
        //    12: dup            
        //    13: ldc             "Null key"
        //    15: ldc             4
        //    17: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    20: invokespecial   java/lang/NullPointerException.<init>:(Ljava/lang/String;)V
        //    23: ldc             1
        //    25: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    28: athrow         
        //    29: aload_0        
        //    30: getfield        instrumented/java/util/prefs/AbstractPreferences.lock:Ljava/lang/Object;
        //    33: dup            
        //    34: astore_3       
        //    35: pop            
        //    36: ldc             5
        //    38: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    41: aload_0        
        //    42: getfield        instrumented/java/util/prefs/AbstractPreferences.removed:Z
        //    45: ldc             3
        //    47: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    50: ifeq            73
        //    53: new             Ljava/lang/IllegalStateException;
        //    56: dup            
        //    57: ldc             "Node has been removed."
        //    59: ldc             4
        //    61: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    64: invokespecial   java/lang/IllegalStateException.<init>:(Ljava/lang/String;)V
        //    67: ldc             1
        //    69: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    72: athrow         
        //    73: aconst_null    
        //    74: astore          4
        //    76: ldc             2
        //    78: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    81: aload_0        
        //    82: aload_1        
        //    83: ldc             3
        //    85: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    88: invokevirtual   instrumented/java/util/prefs/AbstractPreferences.getSpi:(Ljava/lang/String;)Ljava/lang/String;
        //    91: astore          4
        //    93: ldc             1
        //    95: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    98: ldc             1
        //   100: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   103: goto            113
        //   106: astore          5
        //   108: ldc             501
        //   110: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   113: aload           4
        //   115: ldc             2
        //   117: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   120: ifnonnull       132
        //   123: aload_2        
        //   124: ldc             2
        //   126: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   129: goto            139
        //   132: aload           4
        //   134: ldc             1
        //   136: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   139: aload_3        
        //   140: pop            
        //   141: ldc             2
        //   143: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   146: ldc             1
        //   148: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   151: areturn        
        //   152: astore          6
        //   154: aload_3        
        //   155: pop            
        //   156: ldc             503
        //   158: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   161: aload           6
        //   163: ldc             2
        //   165: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   168: athrow         
        //   169: athrow         
        //   170: athrow         
        //    StackMapTable: 00 09 1D FC 00 2B 07 00 4D FF 00 20 00 05 07 00 02 07 00 54 07 00 54 07 00 4D 07 00 54 00 01 07 00 A4 06 12 46 07 00 54 FF 00 0C 00 04 07 00 02 07 00 54 07 00 54 07 00 4D 00 01 07 00 85 FF 00 10 00 00 00 01 07 00 85 FF 00 00 00 00 00 01 07 00 89
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  41     170    170    171    Ljava/lang/VirtualMachineError;
        //  81     98     106    113    Ljava/lang/Exception;
        //  41     146    152    169    Any
        //  152    161    152    169    Any
        //  0      169    169    170    Any
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
    public void remove(final String p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "Specified key cannot be null"
        //     3: ldc             3
        //     5: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     8: invokestatic    instrumented/java/util/Objects.requireNonNull:(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
        //    11: pop            
        //    12: ldc             1
        //    14: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    17: aload_0        
        //    18: getfield        instrumented/java/util/prefs/AbstractPreferences.lock:Ljava/lang/Object;
        //    21: dup            
        //    22: astore_2       
        //    23: pop            
        //    24: ldc             5
        //    26: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    29: aload_0        
        //    30: getfield        instrumented/java/util/prefs/AbstractPreferences.removed:Z
        //    33: ldc             3
        //    35: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    38: ifeq            61
        //    41: new             Ljava/lang/IllegalStateException;
        //    44: dup            
        //    45: ldc             "Node has been removed."
        //    47: ldc             4
        //    49: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    52: invokespecial   java/lang/IllegalStateException.<init>:(Ljava/lang/String;)V
        //    55: ldc             1
        //    57: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    60: athrow         
        //    61: aload_0        
        //    62: aload_1        
        //    63: ldc             3
        //    65: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    68: invokevirtual   instrumented/java/util/prefs/AbstractPreferences.removeSpi:(Ljava/lang/String;)V
        //    71: aload_0        
        //    72: aload_1        
        //    73: aconst_null    
        //    74: ldc             4
        //    76: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    79: invokespecial   instrumented/java/util/prefs/AbstractPreferences.enqueuePreferenceChangeEvent:(Ljava/lang/String;Ljava/lang/String;)V
        //    82: aload_2        
        //    83: pop            
        //    84: ldc             2
        //    86: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    89: ldc             1
        //    91: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    94: goto            112
        //    97: astore_3       
        //    98: aload_2        
        //    99: pop            
        //   100: ldc             503
        //   102: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   105: aload_3        
        //   106: ldc             2
        //   108: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   111: athrow         
        //   112: ldc             1
        //   114: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   117: return         
        //   118: athrow         
        //   119: athrow         
        //    StackMapTable: 00 05 FC 00 3D 07 00 4D 63 07 00 85 FA 00 0E FF 00 05 00 00 00 01 07 00 85 FF 00 00 00 00 00 01 07 00 89
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  29     119    119    120    Ljava/lang/VirtualMachineError;
        //  29     89     97     112    Any
        //  97     105    97     112    Any
        //  0      118    118    119    Any
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
    public void clear() throws BackingStoreException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        instrumented/java/util/prefs/AbstractPreferences.lock:Ljava/lang/Object;
        //     4: dup            
        //     5: astore_1       
        //     6: pop            
        //     7: ldc             5
        //     9: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    12: aload_0        
        //    13: ldc             2
        //    15: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    18: invokevirtual   instrumented/java/util/prefs/AbstractPreferences.keys:()[Ljava/lang/String;
        //    21: astore_2       
        //    22: ldc             1
        //    24: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    27: iconst_0       
        //    28: istore_3       
        //    29: ldc             2
        //    31: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    34: iload_3        
        //    35: aload_2        
        //    36: arraylength    
        //    37: ldc             4
        //    39: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    42: if_icmpge       68
        //    45: aload_0        
        //    46: aload_2        
        //    47: iload_3        
        //    48: aaload         
        //    49: ldc             5
        //    51: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    54: invokevirtual   instrumented/java/util/prefs/AbstractPreferences.remove:(Ljava/lang/String;)V
        //    57: iinc            3, 1
        //    60: ldc             2
        //    62: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    65: goto            34
        //    68: aload_1        
        //    69: pop            
        //    70: ldc             2
        //    72: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    75: ldc             1
        //    77: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    80: goto            100
        //    83: astore          4
        //    85: aload_1        
        //    86: pop            
        //    87: ldc             503
        //    89: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    92: aload           4
        //    94: ldc             2
        //    96: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    99: athrow         
        //   100: ldc             1
        //   102: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   105: return         
        //   106: athrow         
        //   107: athrow         
        //    Exceptions:
        //  throws instrumented.java.util.prefs.BackingStoreException
        //    StackMapTable: 00 06 FE 00 22 07 00 4D 07 00 C0 01 F9 00 21 4E 07 00 85 FA 00 10 FF 00 05 00 00 00 01 07 00 85 FF 00 00 00 00 00 01 07 00 89
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  12     107    107    108    Ljava/lang/VirtualMachineError;
        //  12     75     83     100    Any
        //  83     92     83     100    Any
        //  0      106    106    107    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0034:
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
    public void putInt(final String s, final int i) {
        try {
            BytecodeManager.incBytecodes(4);
            final String string = Integer.toString(i);
            BytecodeManager.incBytecodes(1);
            this.put(s, string);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public int getInt(final String p0, final int p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: istore_3       
        //     2: ldc             2
        //     4: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     7: aload_0        
        //     8: aload_1        
        //     9: aconst_null    
        //    10: ldc             4
        //    12: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    15: invokevirtual   instrumented/java/util/prefs/AbstractPreferences.get:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //    18: astore          4
        //    20: ldc             1
        //    22: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    25: aload           4
        //    27: ldc             2
        //    29: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    32: ifnull          51
        //    35: aload           4
        //    37: ldc             2
        //    39: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    42: invokestatic    java/lang/Integer.parseInt:(Ljava/lang/String;)I
        //    45: istore_3       
        //    46: ldc             1
        //    48: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    51: ldc             1
        //    53: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    56: goto            66
        //    59: astore          4
        //    61: ldc             501
        //    63: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    66: iload_3        
        //    67: ldc             2
        //    69: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    72: ireturn        
        //    73: athrow         
        //    74: athrow         
        //    StackMapTable: 00 05 FC 00 33 01 47 07 00 CF 06 FF 00 06 00 00 00 01 07 00 85 FF 00 00 00 00 00 01 07 00 89
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                             
        //  -----  -----  -----  -----  ---------------------------------
        //  7      74     74     75     Ljava/lang/VirtualMachineError;
        //  7      51     59     66     Ljava/lang/NumberFormatException;
        //  0      73     73     74     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0051:
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
    public void putLong(final String s, final long i) {
        try {
            BytecodeManager.incBytecodes(4);
            final String string = Long.toString(i);
            BytecodeManager.incBytecodes(1);
            this.put(s, string);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public long getLong(final String p0, final long p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: lstore          4
        //     3: ldc             2
        //     5: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     8: aload_0        
        //     9: aload_1        
        //    10: aconst_null    
        //    11: ldc             4
        //    13: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    16: invokevirtual   instrumented/java/util/prefs/AbstractPreferences.get:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //    19: astore          6
        //    21: ldc             1
        //    23: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    26: aload           6
        //    28: ldc             2
        //    30: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    33: ifnull          53
        //    36: aload           6
        //    38: ldc             2
        //    40: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    43: invokestatic    java/lang/Long.parseLong:(Ljava/lang/String;)J
        //    46: lstore          4
        //    48: ldc             1
        //    50: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    53: ldc             1
        //    55: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    58: goto            68
        //    61: astore          6
        //    63: ldc             501
        //    65: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    68: lload           4
        //    70: ldc             2
        //    72: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    75: lreturn        
        //    76: athrow         
        //    77: athrow         
        //    StackMapTable: 00 05 FC 00 35 04 47 07 00 CF 06 FF 00 07 00 00 00 01 07 00 85 FF 00 00 00 00 00 01 07 00 89
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                             
        //  -----  -----  -----  -----  ---------------------------------
        //  8      77     77     78     Ljava/lang/VirtualMachineError;
        //  8      53     61     68     Ljava/lang/NumberFormatException;
        //  0      76     76     77     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0053:
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
    public void putBoolean(final String s, final boolean b) {
        try {
            BytecodeManager.incBytecodes(4);
            final String value = String.valueOf(b);
            BytecodeManager.incBytecodes(1);
            this.put(s, value);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean getBoolean(final String s, final boolean b) {
        try {
            boolean b2 = b;
            BytecodeManager.incBytecodes(2);
            final String s2 = null;
            BytecodeManager.incBytecodes(4);
            final String value = this.get(s, s2);
            BytecodeManager.incBytecodes(1);
            final String s3 = value;
            BytecodeManager.incBytecodes(2);
            if (s3 != null) {
                final String s4 = value;
                final String anotherString = "true";
                BytecodeManager.incBytecodes(3);
                final boolean equalsIgnoreCase = s4.equalsIgnoreCase(anotherString);
                BytecodeManager.incBytecodes(1);
                if (equalsIgnoreCase) {
                    b2 = true;
                    BytecodeManager.incBytecodes(3);
                }
                else {
                    final String s5 = value;
                    final String anotherString2 = "false";
                    BytecodeManager.incBytecodes(3);
                    final boolean equalsIgnoreCase2 = s5.equalsIgnoreCase(anotherString2);
                    BytecodeManager.incBytecodes(1);
                    if (equalsIgnoreCase2) {
                        b2 = false;
                        BytecodeManager.incBytecodes(2);
                    }
                }
            }
            final boolean b3 = b2;
            BytecodeManager.incBytecodes(2);
            return b3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void putFloat(final String s, final float f) {
        try {
            BytecodeManager.incBytecodes(4);
            final String string = Float.toString(f);
            BytecodeManager.incBytecodes(1);
            this.put(s, string);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public float getFloat(final String p0, final float p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: fstore_3       
        //     2: ldc             2
        //     4: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     7: aload_0        
        //     8: aload_1        
        //     9: aconst_null    
        //    10: ldc             4
        //    12: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    15: invokevirtual   instrumented/java/util/prefs/AbstractPreferences.get:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //    18: astore          4
        //    20: ldc             1
        //    22: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    25: aload           4
        //    27: ldc             2
        //    29: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    32: ifnull          51
        //    35: aload           4
        //    37: ldc             2
        //    39: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    42: invokestatic    java/lang/Float.parseFloat:(Ljava/lang/String;)F
        //    45: fstore_3       
        //    46: ldc             1
        //    48: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    51: ldc             1
        //    53: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    56: goto            66
        //    59: astore          4
        //    61: ldc             501
        //    63: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    66: fload_3        
        //    67: ldc             2
        //    69: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    72: freturn        
        //    73: athrow         
        //    74: athrow         
        //    StackMapTable: 00 05 FC 00 33 02 47 07 00 CF 06 FF 00 06 00 00 00 01 07 00 85 FF 00 00 00 00 00 01 07 00 89
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                             
        //  -----  -----  -----  -----  ---------------------------------
        //  7      74     74     75     Ljava/lang/VirtualMachineError;
        //  7      51     59     66     Ljava/lang/NumberFormatException;
        //  0      73     73     74     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0051:
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
    public void putDouble(final String s, final double d) {
        try {
            BytecodeManager.incBytecodes(4);
            final String string = Double.toString(d);
            BytecodeManager.incBytecodes(1);
            this.put(s, string);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public double getDouble(final String p0, final double p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: dstore          4
        //     3: ldc             2
        //     5: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     8: aload_0        
        //     9: aload_1        
        //    10: aconst_null    
        //    11: ldc             4
        //    13: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    16: invokevirtual   instrumented/java/util/prefs/AbstractPreferences.get:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //    19: astore          6
        //    21: ldc             1
        //    23: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    26: aload           6
        //    28: ldc             2
        //    30: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    33: ifnull          53
        //    36: aload           6
        //    38: ldc             2
        //    40: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    43: invokestatic    java/lang/Double.parseDouble:(Ljava/lang/String;)D
        //    46: dstore          4
        //    48: ldc             1
        //    50: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    53: ldc             1
        //    55: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    58: goto            68
        //    61: astore          6
        //    63: ldc             501
        //    65: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    68: dload           4
        //    70: ldc             2
        //    72: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    75: dreturn        
        //    76: athrow         
        //    77: athrow         
        //    StackMapTable: 00 05 FC 00 35 03 47 07 00 CF 06 FF 00 07 00 00 00 01 07 00 85 FF 00 00 00 00 00 01 07 00 89
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                             
        //  -----  -----  -----  -----  ---------------------------------
        //  8      77     77     78     Ljava/lang/VirtualMachineError;
        //  8      53     61     68     Ljava/lang/NumberFormatException;
        //  0      76     76     77     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0053:
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
    public void putByteArray(final String s, final byte[] array) {
        try {
            BytecodeManager.incBytecodes(4);
            final String byteArrayToBase64 = Base64.byteArrayToBase64(array);
            BytecodeManager.incBytecodes(1);
            this.put(s, byteArrayToBase64);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public byte[] getByteArray(final String p0, final byte[] p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore_3       
        //     2: ldc             2
        //     4: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     7: aload_0        
        //     8: aload_1        
        //     9: aconst_null    
        //    10: ldc             4
        //    12: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    15: invokevirtual   instrumented/java/util/prefs/AbstractPreferences.get:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //    18: astore          4
        //    20: ldc             1
        //    22: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    25: aload           4
        //    27: ldc             2
        //    29: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    32: ifnull          51
        //    35: aload           4
        //    37: ldc             2
        //    39: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    42: invokestatic    instrumented/java/util/prefs/Base64.base64ToByteArray:(Ljava/lang/String;)[B
        //    45: astore_3       
        //    46: ldc             1
        //    48: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    51: ldc             1
        //    53: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    56: goto            66
        //    59: astore          5
        //    61: ldc             501
        //    63: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    66: aload_3        
        //    67: ldc             2
        //    69: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    72: areturn        
        //    73: athrow         
        //    74: athrow         
        //    StackMapTable: 00 05 FD 00 33 07 01 1E 07 00 54 47 07 01 18 06 FF 00 06 00 00 00 01 07 00 85 FF 00 00 00 00 00 01 07 00 89
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  25     74     74     75     Ljava/lang/VirtualMachineError;
        //  25     51     59     66     Ljava/lang/RuntimeException;
        //  0      73     73     74     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0051:
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
    public String[] keys() throws BackingStoreException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        instrumented/java/util/prefs/AbstractPreferences.lock:Ljava/lang/Object;
        //     4: dup            
        //     5: astore_1       
        //     6: pop            
        //     7: ldc             5
        //     9: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    12: aload_0        
        //    13: getfield        instrumented/java/util/prefs/AbstractPreferences.removed:Z
        //    16: ldc             3
        //    18: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    21: ifeq            44
        //    24: new             Ljava/lang/IllegalStateException;
        //    27: dup            
        //    28: ldc             "Node has been removed."
        //    30: ldc             4
        //    32: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    35: invokespecial   java/lang/IllegalStateException.<init>:(Ljava/lang/String;)V
        //    38: ldc             1
        //    40: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    43: athrow         
        //    44: aload_0        
        //    45: ldc             2
        //    47: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    50: invokevirtual   instrumented/java/util/prefs/AbstractPreferences.keysSpi:()[Ljava/lang/String;
        //    53: aload_1        
        //    54: pop            
        //    55: ldc             2
        //    57: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    60: ldc             1
        //    62: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    65: areturn        
        //    66: astore_2       
        //    67: aload_1        
        //    68: pop            
        //    69: ldc             503
        //    71: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    74: aload_2        
        //    75: ldc             2
        //    77: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    80: athrow         
        //    81: athrow         
        //    82: athrow         
        //    Exceptions:
        //  throws instrumented.java.util.prefs.BackingStoreException
        //    StackMapTable: 00 04 FC 00 2C 07 00 4D 55 07 00 85 FF 00 0E 00 00 00 01 07 00 85 FF 00 00 00 00 00 01 07 00 89
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  12     82     82     83     Ljava/lang/VirtualMachineError;
        //  12     60     66     81     Any
        //  66     74     66     81     Any
        //  0      81     81     82     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0044:
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
    public String[] childrenNames() throws BackingStoreException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        instrumented/java/util/prefs/AbstractPreferences.lock:Ljava/lang/Object;
        //     4: dup            
        //     5: astore_1       
        //     6: pop            
        //     7: ldc             5
        //     9: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    12: aload_0        
        //    13: getfield        instrumented/java/util/prefs/AbstractPreferences.removed:Z
        //    16: ldc             3
        //    18: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    21: ifeq            44
        //    24: new             Ljava/lang/IllegalStateException;
        //    27: dup            
        //    28: ldc             "Node has been removed."
        //    30: ldc             4
        //    32: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    35: invokespecial   java/lang/IllegalStateException.<init>:(Ljava/lang/String;)V
        //    38: ldc             1
        //    40: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    43: athrow         
        //    44: new             Linstrumented/java/util/TreeSet;
        //    47: dup            
        //    48: aload_0        
        //    49: getfield        instrumented/java/util/prefs/AbstractPreferences.kidCache:Linstrumented/java/util/Map;
        //    52: ldc             5
        //    54: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    57: invokeinterface instrumented/java/util/Map.keySet:()Linstrumented/java/util/Set;
        //    62: ldc             1
        //    64: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    67: invokespecial   instrumented/java/util/TreeSet.<init>:(Linstrumented/java/util/Collection;)V
        //    70: astore_2       
        //    71: ldc             1
        //    73: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    76: aload_0        
        //    77: ldc             2
        //    79: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    82: invokevirtual   instrumented/java/util/prefs/AbstractPreferences.childrenNamesSpi:()[Ljava/lang/String;
        //    85: astore_3       
        //    86: aload_3        
        //    87: arraylength    
        //    88: istore          4
        //    90: iconst_0       
        //    91: istore          5
        //    93: ldc_w           6
        //    96: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    99: iload           5
        //   101: iload           4
        //   103: ldc             3
        //   105: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   108: if_icmpge       152
        //   111: aload_3        
        //   112: iload           5
        //   114: aaload         
        //   115: astore          6
        //   117: ldc             4
        //   119: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   122: aload_2        
        //   123: aload           6
        //   125: ldc             3
        //   127: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   130: invokeinterface instrumented/java/util/Set.add:(Ljava/lang/Object;)Z
        //   135: pop            
        //   136: ldc             1
        //   138: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   141: iinc            5, 1
        //   144: ldc             2
        //   146: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   149: goto            99
        //   152: aload_2        
        //   153: getstatic       instrumented/java/util/prefs/AbstractPreferences.EMPTY_STRING_ARRAY:[Ljava/lang/String;
        //   156: ldc             3
        //   158: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   161: invokeinterface instrumented/java/util/Set.toArray:([Ljava/lang/Object;)[Ljava/lang/Object;
        //   166: checkcast       [Ljava/lang/String;
        //   169: aload_1        
        //   170: pop            
        //   171: ldc             3
        //   173: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   176: ldc             1
        //   178: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   181: areturn        
        //   182: astore          7
        //   184: aload_1        
        //   185: pop            
        //   186: ldc             503
        //   188: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   191: aload           7
        //   193: ldc             2
        //   195: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   198: athrow         
        //   199: athrow         
        //   200: athrow         
        //    Exceptions:
        //  throws instrumented.java.util.prefs.BackingStoreException
        //    StackMapTable: 00 06 FC 00 2C 07 00 4D FF 00 36 00 06 07 00 02 07 00 4D 07 01 33 07 00 C0 01 01 00 00 F8 00 34 FF 00 1D 00 02 07 00 02 07 00 4D 00 01 07 00 85 FF 00 10 00 00 00 01 07 00 85 FF 00 00 00 00 00 01 07 00 89
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  12     200    200    201    Ljava/lang/VirtualMachineError;
        //  12     176    182    199    Any
        //  182    191    182    199    Any
        //  0      199    199    200    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0044:
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
    
    protected final AbstractPreferences[] cachedChildren() {
        try {
            final Map<String, AbstractPreferences> kidCache = this.kidCache;
            BytecodeManager.incBytecodes(3);
            final Collection<AbstractPreferences> values = kidCache.values();
            final AbstractPreferences[] empty_ABSTRACT_PREFS_ARRAY = AbstractPreferences.EMPTY_ABSTRACT_PREFS_ARRAY;
            BytecodeManager.incBytecodes(2);
            final AbstractPreferences[] array = values.toArray(empty_ABSTRACT_PREFS_ARRAY);
            BytecodeManager.incBytecodes(2);
            return array;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public Preferences parent() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        instrumented/java/util/prefs/AbstractPreferences.lock:Ljava/lang/Object;
        //     4: dup            
        //     5: astore_1       
        //     6: pop            
        //     7: ldc             5
        //     9: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    12: aload_0        
        //    13: getfield        instrumented/java/util/prefs/AbstractPreferences.removed:Z
        //    16: ldc             3
        //    18: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    21: ifeq            44
        //    24: new             Ljava/lang/IllegalStateException;
        //    27: dup            
        //    28: ldc             "Node has been removed."
        //    30: ldc             4
        //    32: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    35: invokespecial   java/lang/IllegalStateException.<init>:(Ljava/lang/String;)V
        //    38: ldc             1
        //    40: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    43: athrow         
        //    44: aload_0        
        //    45: getfield        instrumented/java/util/prefs/AbstractPreferences.parent:Linstrumented/java/util/prefs/AbstractPreferences;
        //    48: aload_1        
        //    49: pop            
        //    50: ldc             4
        //    52: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    55: ldc             1
        //    57: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    60: areturn        
        //    61: astore_2       
        //    62: aload_1        
        //    63: pop            
        //    64: ldc             503
        //    66: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    69: aload_2        
        //    70: ldc             2
        //    72: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    75: athrow         
        //    76: athrow         
        //    77: athrow         
        //    StackMapTable: 00 04 FC 00 2C 07 00 4D 50 07 00 85 FF 00 0E 00 00 00 01 07 00 85 FF 00 00 00 00 00 01 07 00 89
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  12     77     77     78     Ljava/lang/VirtualMachineError;
        //  12     55     61     76     Any
        //  61     69     61     76     Any
        //  0      76     76     77     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0044:
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
    public Preferences node(final String p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        instrumented/java/util/prefs/AbstractPreferences.lock:Ljava/lang/Object;
        //     4: dup            
        //     5: astore_2       
        //     6: pop            
        //     7: ldc             5
        //     9: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    12: aload_0        
        //    13: getfield        instrumented/java/util/prefs/AbstractPreferences.removed:Z
        //    16: ldc             3
        //    18: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    21: ifeq            44
        //    24: new             Ljava/lang/IllegalStateException;
        //    27: dup            
        //    28: ldc             "Node has been removed."
        //    30: ldc             4
        //    32: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    35: invokespecial   java/lang/IllegalStateException.<init>:(Ljava/lang/String;)V
        //    38: ldc             1
        //    40: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    43: athrow         
        //    44: aload_1        
        //    45: ldc             ""
        //    47: ldc             3
        //    49: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    52: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //    55: ldc             1
        //    57: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    60: ifeq            77
        //    63: aload_0        
        //    64: aload_2        
        //    65: pop            
        //    66: ldc             3
        //    68: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    71: ldc             1
        //    73: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    76: areturn        
        //    77: aload_1        
        //    78: ldc             "/"
        //    80: ldc             3
        //    82: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    85: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //    88: ldc             1
        //    90: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    93: ifeq            113
        //    96: aload_0        
        //    97: getfield        instrumented/java/util/prefs/AbstractPreferences.root:Linstrumented/java/util/prefs/AbstractPreferences;
        //   100: aload_2        
        //   101: pop            
        //   102: ldc             4
        //   104: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   107: ldc             1
        //   109: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   112: areturn        
        //   113: aload_1        
        //   114: iconst_0       
        //   115: ldc             3
        //   117: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   120: invokevirtual   java/lang/String.charAt:(I)C
        //   123: bipush          47
        //   125: ldc             2
        //   127: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   130: if_icmpeq       172
        //   133: aload_0        
        //   134: new             Linstrumented/java/util/StringTokenizer;
        //   137: dup            
        //   138: aload_1        
        //   139: ldc             "/"
        //   141: iconst_1       
        //   142: ldc_w           7
        //   145: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   148: invokespecial   instrumented/java/util/StringTokenizer.<init>:(Ljava/lang/String;Ljava/lang/String;Z)V
        //   151: ldc             1
        //   153: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   156: invokespecial   instrumented/java/util/prefs/AbstractPreferences.node:(Linstrumented/java/util/StringTokenizer;)Linstrumented/java/util/prefs/Preferences;
        //   159: aload_2        
        //   160: pop            
        //   161: ldc             2
        //   163: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   166: ldc             1
        //   168: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   171: areturn        
        //   172: aload_2        
        //   173: pop            
        //   174: ldc             2
        //   176: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   179: ldc             1
        //   181: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   184: goto            202
        //   187: astore_3       
        //   188: aload_2        
        //   189: pop            
        //   190: ldc             503
        //   192: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   195: aload_3        
        //   196: ldc             2
        //   198: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   201: athrow         
        //   202: aload_0        
        //   203: getfield        instrumented/java/util/prefs/AbstractPreferences.root:Linstrumented/java/util/prefs/AbstractPreferences;
        //   206: new             Linstrumented/java/util/StringTokenizer;
        //   209: dup            
        //   210: aload_1        
        //   211: iconst_1       
        //   212: ldc_w           7
        //   215: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   218: invokevirtual   java/lang/String.substring:(I)Ljava/lang/String;
        //   221: ldc             "/"
        //   223: iconst_1       
        //   224: ldc             3
        //   226: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   229: invokespecial   instrumented/java/util/StringTokenizer.<init>:(Ljava/lang/String;Ljava/lang/String;Z)V
        //   232: ldc             1
        //   234: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   237: invokespecial   instrumented/java/util/prefs/AbstractPreferences.node:(Linstrumented/java/util/StringTokenizer;)Linstrumented/java/util/prefs/Preferences;
        //   240: ldc             1
        //   242: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   245: areturn        
        //   246: athrow         
        //   247: athrow         
        //    StackMapTable: 00 08 FC 00 2C 07 00 4D 20 23 3A 4E 07 00 85 FA 00 0E FF 00 2B 00 00 00 01 07 00 85 FF 00 00 00 00 00 01 07 00 89
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  12     247    247    248    Ljava/lang/VirtualMachineError;
        //  12     71     187    202    Any
        //  77     107    187    202    Any
        //  113    166    187    202    Any
        //  172    179    187    202    Any
        //  187    195    187    202    Any
        //  0      246    246    247    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0044:
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
    
    private Preferences node(final StringTokenizer p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             2
        //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     6: invokevirtual   instrumented/java/util/StringTokenizer.nextToken:()Ljava/lang/String;
        //     9: astore_2       
        //    10: ldc             1
        //    12: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    15: aload_2        
        //    16: ldc             "/"
        //    18: ldc             3
        //    20: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    23: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //    26: ldc             1
        //    28: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    31: ifeq            55
        //    34: new             Ljava/lang/IllegalArgumentException;
        //    37: dup            
        //    38: ldc_w           "Consecutive slashes in path"
        //    41: ldc             4
        //    43: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    46: invokespecial   java/lang/IllegalArgumentException.<init>:(Ljava/lang/String;)V
        //    49: ldc             1
        //    51: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    54: athrow         
        //    55: aload_0        
        //    56: getfield        instrumented/java/util/prefs/AbstractPreferences.lock:Ljava/lang/Object;
        //    59: dup            
        //    60: astore_3       
        //    61: pop            
        //    62: ldc             5
        //    64: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    67: aload_0        
        //    68: getfield        instrumented/java/util/prefs/AbstractPreferences.kidCache:Linstrumented/java/util/Map;
        //    71: aload_2        
        //    72: ldc             4
        //    74: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    77: invokeinterface instrumented/java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //    82: checkcast       Linstrumented/java/util/prefs/AbstractPreferences;
        //    85: astore          4
        //    87: ldc             2
        //    89: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    92: aload           4
        //    94: ldc             2
        //    96: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    99: ifnonnull       254
        //   102: aload_2        
        //   103: ldc             2
        //   105: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   108: invokevirtual   java/lang/String.length:()I
        //   111: bipush          80
        //   113: ldc             2
        //   115: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   118: if_icmple       190
        //   121: new             Ljava/lang/IllegalArgumentException;
        //   124: dup            
        //   125: new             Ljava/lang/StringBuilder;
        //   128: dup            
        //   129: ldc             5
        //   131: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   134: invokespecial   java/lang/StringBuilder.<init>:()V
        //   137: ldc_w           "Node name "
        //   140: ldc             2
        //   142: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   145: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   148: aload_2        
        //   149: ldc             2
        //   151: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   154: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   157: ldc_w           " too long"
        //   160: ldc             2
        //   162: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   165: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   168: ldc             1
        //   170: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   173: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   176: ldc             1
        //   178: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   181: invokespecial   java/lang/IllegalArgumentException.<init>:(Ljava/lang/String;)V
        //   184: ldc             1
        //   186: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   189: athrow         
        //   190: aload_0        
        //   191: aload_2        
        //   192: ldc             3
        //   194: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   197: invokevirtual   instrumented/java/util/prefs/AbstractPreferences.childSpi:(Ljava/lang/String;)Linstrumented/java/util/prefs/AbstractPreferences;
        //   200: astore          4
        //   202: ldc             1
        //   204: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   207: aload           4
        //   209: getfield        instrumented/java/util/prefs/AbstractPreferences.newNode:Z
        //   212: ldc             3
        //   214: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   217: ifeq            231
        //   220: aload_0        
        //   221: aload           4
        //   223: ldc             3
        //   225: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   228: invokespecial   instrumented/java/util/prefs/AbstractPreferences.enqueueNodeAddedEvent:(Linstrumented/java/util/prefs/Preferences;)V
        //   231: aload_0        
        //   232: getfield        instrumented/java/util/prefs/AbstractPreferences.kidCache:Linstrumented/java/util/Map;
        //   235: aload_2        
        //   236: aload           4
        //   238: ldc             5
        //   240: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   243: invokeinterface instrumented/java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   248: pop            
        //   249: ldc             1
        //   251: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   254: aload_1        
        //   255: ldc             2
        //   257: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   260: invokevirtual   instrumented/java/util/StringTokenizer.hasMoreTokens:()Z
        //   263: ldc             1
        //   265: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   268: ifne            286
        //   271: aload           4
        //   273: aload_3        
        //   274: pop            
        //   275: ldc             3
        //   277: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   280: ldc             1
        //   282: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   285: areturn        
        //   286: aload_1        
        //   287: ldc             2
        //   289: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   292: invokevirtual   instrumented/java/util/StringTokenizer.nextToken:()Ljava/lang/String;
        //   295: pop            
        //   296: ldc             1
        //   298: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   301: aload_1        
        //   302: ldc             2
        //   304: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   307: invokevirtual   instrumented/java/util/StringTokenizer.hasMoreTokens:()Z
        //   310: ldc             1
        //   312: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   315: ifne            339
        //   318: new             Ljava/lang/IllegalArgumentException;
        //   321: dup            
        //   322: ldc_w           "Path ends with slash"
        //   325: ldc             4
        //   327: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   330: invokespecial   java/lang/IllegalArgumentException.<init>:(Ljava/lang/String;)V
        //   333: ldc             1
        //   335: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   338: athrow         
        //   339: aload           4
        //   341: aload_1        
        //   342: ldc             3
        //   344: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   347: invokespecial   instrumented/java/util/prefs/AbstractPreferences.node:(Linstrumented/java/util/StringTokenizer;)Linstrumented/java/util/prefs/Preferences;
        //   350: aload_3        
        //   351: pop            
        //   352: ldc             2
        //   354: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   357: ldc             1
        //   359: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   362: areturn        
        //   363: astore          5
        //   365: aload_3        
        //   366: pop            
        //   367: ldc             503
        //   369: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   372: aload           5
        //   374: ldc             2
        //   376: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   379: athrow         
        //   380: athrow         
        //   381: athrow         
        //    StackMapTable: 00 09 FC 00 37 07 00 54 FD 00 86 07 00 4D 07 00 02 28 16 1F 34 FF 00 17 00 04 07 00 02 07 01 51 07 00 54 07 00 4D 00 01 07 00 85 FF 00 10 00 00 00 01 07 00 85 FF 00 00 00 00 00 01 07 00 89
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  67     381    381    382    Ljava/lang/VirtualMachineError;
        //  67     280    363    380    Any
        //  286    357    363    380    Any
        //  363    372    363    380    Any
        //  0      380    380    381    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0190:
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
    public boolean nodeExists(final String p0) throws BackingStoreException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        instrumented/java/util/prefs/AbstractPreferences.lock:Ljava/lang/Object;
        //     4: dup            
        //     5: astore_2       
        //     6: pop            
        //     7: ldc             5
        //     9: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    12: aload_1        
        //    13: ldc             ""
        //    15: ldc             3
        //    17: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    20: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //    23: ldc             1
        //    25: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    28: ifeq            71
        //    31: aload_0        
        //    32: getfield        instrumented/java/util/prefs/AbstractPreferences.removed:Z
        //    35: ldc             3
        //    37: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    40: ifne            52
        //    43: iconst_1       
        //    44: ldc             2
        //    46: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    49: goto            58
        //    52: iconst_0       
        //    53: ldc             1
        //    55: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    58: aload_2        
        //    59: pop            
        //    60: ldc             2
        //    62: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    65: ldc             1
        //    67: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    70: ireturn        
        //    71: aload_0        
        //    72: getfield        instrumented/java/util/prefs/AbstractPreferences.removed:Z
        //    75: ldc             3
        //    77: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    80: ifeq            103
        //    83: new             Ljava/lang/IllegalStateException;
        //    86: dup            
        //    87: ldc             "Node has been removed."
        //    89: ldc             4
        //    91: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    94: invokespecial   java/lang/IllegalStateException.<init>:(Ljava/lang/String;)V
        //    97: ldc             1
        //    99: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   102: athrow         
        //   103: aload_1        
        //   104: ldc             "/"
        //   106: ldc             3
        //   108: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   111: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   114: ldc             1
        //   116: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   119: ifeq            136
        //   122: iconst_1       
        //   123: aload_2        
        //   124: pop            
        //   125: ldc             3
        //   127: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   130: ldc             1
        //   132: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   135: ireturn        
        //   136: aload_1        
        //   137: iconst_0       
        //   138: ldc             3
        //   140: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   143: invokevirtual   java/lang/String.charAt:(I)C
        //   146: bipush          47
        //   148: ldc             2
        //   150: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   153: if_icmpeq       195
        //   156: aload_0        
        //   157: new             Linstrumented/java/util/StringTokenizer;
        //   160: dup            
        //   161: aload_1        
        //   162: ldc             "/"
        //   164: iconst_1       
        //   165: ldc_w           7
        //   168: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   171: invokespecial   instrumented/java/util/StringTokenizer.<init>:(Ljava/lang/String;Ljava/lang/String;Z)V
        //   174: ldc             1
        //   176: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   179: invokespecial   instrumented/java/util/prefs/AbstractPreferences.nodeExists:(Linstrumented/java/util/StringTokenizer;)Z
        //   182: aload_2        
        //   183: pop            
        //   184: ldc             2
        //   186: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   189: ldc             1
        //   191: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   194: ireturn        
        //   195: aload_2        
        //   196: pop            
        //   197: ldc             2
        //   199: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   202: ldc             1
        //   204: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   207: goto            225
        //   210: astore_3       
        //   211: aload_2        
        //   212: pop            
        //   213: ldc             503
        //   215: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   218: aload_3        
        //   219: ldc             2
        //   221: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   224: athrow         
        //   225: aload_0        
        //   226: getfield        instrumented/java/util/prefs/AbstractPreferences.root:Linstrumented/java/util/prefs/AbstractPreferences;
        //   229: new             Linstrumented/java/util/StringTokenizer;
        //   232: dup            
        //   233: aload_1        
        //   234: iconst_1       
        //   235: ldc_w           7
        //   238: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   241: invokevirtual   java/lang/String.substring:(I)Ljava/lang/String;
        //   244: ldc             "/"
        //   246: iconst_1       
        //   247: ldc             3
        //   249: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   252: invokespecial   instrumented/java/util/StringTokenizer.<init>:(Ljava/lang/String;Ljava/lang/String;Z)V
        //   255: ldc             1
        //   257: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   260: invokespecial   instrumented/java/util/prefs/AbstractPreferences.nodeExists:(Linstrumented/java/util/StringTokenizer;)Z
        //   263: ldc             1
        //   265: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   268: ireturn        
        //   269: athrow         
        //   270: athrow         
        //    Exceptions:
        //  throws instrumented.java.util.prefs.BackingStoreException
        //    StackMapTable: 00 0A FC 00 34 07 00 4D 45 01 0C 1F 20 3A 4E 07 00 85 FA 00 0E FF 00 2B 00 00 00 01 07 00 85 FF 00 00 00 00 00 01 07 00 89
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  12     270    270    271    Ljava/lang/VirtualMachineError;
        //  12     65     210    225    Any
        //  71     130    210    225    Any
        //  136    189    210    225    Any
        //  195    202    210    225    Any
        //  210    218    210    225    Any
        //  0      269    269    270    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0052:
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
    
    private boolean nodeExists(final StringTokenizer p0) throws BackingStoreException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             2
        //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     6: invokevirtual   instrumented/java/util/StringTokenizer.nextToken:()Ljava/lang/String;
        //     9: astore_2       
        //    10: ldc             1
        //    12: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    15: aload_2        
        //    16: ldc             "/"
        //    18: ldc             3
        //    20: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    23: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //    26: ldc             1
        //    28: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    31: ifeq            55
        //    34: new             Ljava/lang/IllegalArgumentException;
        //    37: dup            
        //    38: ldc_w           "Consecutive slashes in path"
        //    41: ldc             4
        //    43: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    46: invokespecial   java/lang/IllegalArgumentException.<init>:(Ljava/lang/String;)V
        //    49: ldc             1
        //    51: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    54: athrow         
        //    55: aload_0        
        //    56: getfield        instrumented/java/util/prefs/AbstractPreferences.lock:Ljava/lang/Object;
        //    59: dup            
        //    60: astore_3       
        //    61: pop            
        //    62: ldc             5
        //    64: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    67: aload_0        
        //    68: getfield        instrumented/java/util/prefs/AbstractPreferences.kidCache:Linstrumented/java/util/Map;
        //    71: aload_2        
        //    72: ldc             4
        //    74: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    77: invokeinterface instrumented/java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //    82: checkcast       Linstrumented/java/util/prefs/AbstractPreferences;
        //    85: astore          4
        //    87: ldc             2
        //    89: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    92: aload           4
        //    94: ldc             2
        //    96: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    99: ifnonnull       119
        //   102: aload_0        
        //   103: aload_2        
        //   104: ldc             3
        //   106: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   109: invokevirtual   instrumented/java/util/prefs/AbstractPreferences.getChild:(Ljava/lang/String;)Linstrumented/java/util/prefs/AbstractPreferences;
        //   112: astore          4
        //   114: ldc             1
        //   116: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   119: aload           4
        //   121: ldc             2
        //   123: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   126: ifnonnull       143
        //   129: iconst_0       
        //   130: aload_3        
        //   131: pop            
        //   132: ldc             3
        //   134: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   137: ldc             1
        //   139: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   142: ireturn        
        //   143: aload_1        
        //   144: ldc             2
        //   146: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   149: invokevirtual   instrumented/java/util/StringTokenizer.hasMoreTokens:()Z
        //   152: ldc             1
        //   154: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   157: ifne            174
        //   160: iconst_1       
        //   161: aload_3        
        //   162: pop            
        //   163: ldc             3
        //   165: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   168: ldc             1
        //   170: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   173: ireturn        
        //   174: aload_1        
        //   175: ldc             2
        //   177: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   180: invokevirtual   instrumented/java/util/StringTokenizer.nextToken:()Ljava/lang/String;
        //   183: pop            
        //   184: ldc             1
        //   186: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   189: aload_1        
        //   190: ldc             2
        //   192: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   195: invokevirtual   instrumented/java/util/StringTokenizer.hasMoreTokens:()Z
        //   198: ldc             1
        //   200: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   203: ifne            227
        //   206: new             Ljava/lang/IllegalArgumentException;
        //   209: dup            
        //   210: ldc_w           "Path ends with slash"
        //   213: ldc             4
        //   215: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   218: invokespecial   java/lang/IllegalArgumentException.<init>:(Ljava/lang/String;)V
        //   221: ldc             1
        //   223: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   226: athrow         
        //   227: aload           4
        //   229: aload_1        
        //   230: ldc             3
        //   232: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   235: invokespecial   instrumented/java/util/prefs/AbstractPreferences.nodeExists:(Linstrumented/java/util/StringTokenizer;)Z
        //   238: aload_3        
        //   239: pop            
        //   240: ldc             2
        //   242: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   245: ldc             1
        //   247: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   250: ireturn        
        //   251: astore          5
        //   253: aload_3        
        //   254: pop            
        //   255: ldc             503
        //   257: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   260: aload           5
        //   262: ldc             2
        //   264: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   267: athrow         
        //   268: athrow         
        //   269: athrow         
        //    Exceptions:
        //  throws instrumented.java.util.prefs.BackingStoreException
        //    StackMapTable: 00 08 FC 00 37 07 00 54 FD 00 3F 07 00 4D 07 00 02 17 1E 34 FF 00 17 00 04 07 00 02 07 01 51 07 00 54 07 00 4D 00 01 07 00 85 FF 00 10 00 00 00 01 07 00 85 FF 00 00 00 00 00 01 07 00 89
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  67     269    269    270    Ljava/lang/VirtualMachineError;
        //  67     137    251    268    Any
        //  143    168    251    268    Any
        //  174    245    251    268    Any
        //  251    260    251    268    Any
        //  0      268    268    269    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0119:
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
    public void removeNode() throws BackingStoreException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: aload_0        
        //     2: getfield        instrumented/java/util/prefs/AbstractPreferences.root:Linstrumented/java/util/prefs/AbstractPreferences;
        //     5: ldc             4
        //     7: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    10: if_acmpne       34
        //    13: new             Ljava/lang/UnsupportedOperationException;
        //    16: dup            
        //    17: ldc_w           "Can't remove the root!"
        //    20: ldc             4
        //    22: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    25: invokespecial   java/lang/UnsupportedOperationException.<init>:(Ljava/lang/String;)V
        //    28: ldc             1
        //    30: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    33: athrow         
        //    34: aload_0        
        //    35: getfield        instrumented/java/util/prefs/AbstractPreferences.parent:Linstrumented/java/util/prefs/AbstractPreferences;
        //    38: getfield        instrumented/java/util/prefs/AbstractPreferences.lock:Ljava/lang/Object;
        //    41: dup            
        //    42: astore_1       
        //    43: pop            
        //    44: ldc_w           6
        //    47: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    50: aload_0        
        //    51: ldc             2
        //    53: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    56: invokespecial   instrumented/java/util/prefs/AbstractPreferences.removeNode2:()V
        //    59: aload_0        
        //    60: getfield        instrumented/java/util/prefs/AbstractPreferences.parent:Linstrumented/java/util/prefs/AbstractPreferences;
        //    63: getfield        instrumented/java/util/prefs/AbstractPreferences.kidCache:Linstrumented/java/util/Map;
        //    66: aload_0        
        //    67: getfield        instrumented/java/util/prefs/AbstractPreferences.name:Ljava/lang/String;
        //    70: ldc_w           6
        //    73: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    76: invokeinterface instrumented/java/util/Map.remove:(Ljava/lang/Object;)Ljava/lang/Object;
        //    81: pop            
        //    82: ldc             1
        //    84: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    87: aload_1        
        //    88: pop            
        //    89: ldc             2
        //    91: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    94: ldc             1
        //    96: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    99: goto            117
        //   102: astore_2       
        //   103: aload_1        
        //   104: pop            
        //   105: ldc             503
        //   107: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   110: aload_2        
        //   111: ldc             2
        //   113: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   116: athrow         
        //   117: ldc             1
        //   119: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   122: return         
        //   123: athrow         
        //   124: athrow         
        //    Exceptions:
        //  throws instrumented.java.util.prefs.BackingStoreException
        //    StackMapTable: 00 05 22 FF 00 43 00 02 07 00 02 07 00 4D 00 01 07 00 85 FA 00 0E FF 00 05 00 00 00 01 07 00 85 FF 00 00 00 00 00 01 07 00 89
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  50     124    124    125    Ljava/lang/VirtualMachineError;
        //  50     94     102    117    Any
        //  102    110    102    117    Any
        //  0      123    123    124    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0117:
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
    
    private void removeNode2() throws BackingStoreException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        instrumented/java/util/prefs/AbstractPreferences.lock:Ljava/lang/Object;
        //     4: dup            
        //     5: astore_1       
        //     6: pop            
        //     7: ldc             5
        //     9: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    12: aload_0        
        //    13: getfield        instrumented/java/util/prefs/AbstractPreferences.removed:Z
        //    16: ldc             3
        //    18: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    21: ifeq            45
        //    24: new             Ljava/lang/IllegalStateException;
        //    27: dup            
        //    28: ldc_w           "Node already removed."
        //    31: ldc             4
        //    33: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    36: invokespecial   java/lang/IllegalStateException.<init>:(Ljava/lang/String;)V
        //    39: ldc             1
        //    41: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    44: athrow         
        //    45: aload_0        
        //    46: ldc             2
        //    48: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    51: invokevirtual   instrumented/java/util/prefs/AbstractPreferences.childrenNamesSpi:()[Ljava/lang/String;
        //    54: astore_2       
        //    55: ldc             1
        //    57: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    60: iconst_0       
        //    61: istore_3       
        //    62: ldc             2
        //    64: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    67: iload_3        
        //    68: aload_2        
        //    69: arraylength    
        //    70: ldc             4
        //    72: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    75: if_icmpge       151
        //    78: aload_0        
        //    79: getfield        instrumented/java/util/prefs/AbstractPreferences.kidCache:Linstrumented/java/util/Map;
        //    82: aload_2        
        //    83: iload_3        
        //    84: aaload         
        //    85: ldc_w           6
        //    88: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    91: invokeinterface instrumented/java/util/Map.containsKey:(Ljava/lang/Object;)Z
        //    96: ldc             1
        //    98: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   101: ifne            140
        //   104: aload_0        
        //   105: getfield        instrumented/java/util/prefs/AbstractPreferences.kidCache:Linstrumented/java/util/Map;
        //   108: aload_2        
        //   109: iload_3        
        //   110: aaload         
        //   111: aload_0        
        //   112: aload_2        
        //   113: iload_3        
        //   114: aaload         
        //   115: ldc_w           10
        //   118: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   121: invokevirtual   instrumented/java/util/prefs/AbstractPreferences.childSpi:(Ljava/lang/String;)Linstrumented/java/util/prefs/AbstractPreferences;
        //   124: ldc             1
        //   126: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   129: invokeinterface instrumented/java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   134: pop            
        //   135: ldc             1
        //   137: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   140: iinc            3, 1
        //   143: ldc             2
        //   145: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   148: goto            67
        //   151: aload_0        
        //   152: getfield        instrumented/java/util/prefs/AbstractPreferences.kidCache:Linstrumented/java/util/Map;
        //   155: ldc             3
        //   157: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   160: invokeinterface instrumented/java/util/Map.values:()Linstrumented/java/util/Collection;
        //   165: ldc             1
        //   167: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   170: invokeinterface instrumented/java/util/Collection.iterator:()Ljava/util/Iterator;
        //   175: astore_3       
        //   176: ldc             1
        //   178: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   181: aload_3        
        //   182: ldc             2
        //   184: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   187: invokeinterface java/util/Iterator.hasNext:()Z
        //   192: ldc             1
        //   194: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   197: ifeq            252
        //   200: aload_3        
        //   201: ldc             2
        //   203: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   206: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   211: checkcast       Linstrumented/java/util/prefs/AbstractPreferences;
        //   214: ldc             2
        //   216: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   219: invokespecial   instrumented/java/util/prefs/AbstractPreferences.removeNode2:()V
        //   222: aload_3        
        //   223: ldc             2
        //   225: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   228: invokeinterface java/util/Iterator.remove:()V
        //   233: ldc             1
        //   235: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   238: goto            181
        //   241: astore          4
        //   243: ldc_w           502
        //   246: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   249: goto            181
        //   252: aload_0        
        //   253: ldc             2
        //   255: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   258: invokevirtual   instrumented/java/util/prefs/AbstractPreferences.removeNodeSpi:()V
        //   261: aload_0        
        //   262: iconst_1       
        //   263: putfield        instrumented/java/util/prefs/AbstractPreferences.removed:Z
        //   266: ldc             3
        //   268: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   271: aload_0        
        //   272: getfield        instrumented/java/util/prefs/AbstractPreferences.parent:Linstrumented/java/util/prefs/AbstractPreferences;
        //   275: aload_0        
        //   276: ldc             4
        //   278: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   281: invokespecial   instrumented/java/util/prefs/AbstractPreferences.enqueueNodeRemovedEvent:(Linstrumented/java/util/prefs/Preferences;)V
        //   284: aload_1        
        //   285: pop            
        //   286: ldc             2
        //   288: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   291: ldc             1
        //   293: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   296: goto            316
        //   299: astore          5
        //   301: aload_1        
        //   302: pop            
        //   303: ldc             503
        //   305: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   308: aload           5
        //   310: ldc             2
        //   312: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   315: athrow         
        //   316: ldc             1
        //   318: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   321: return         
        //   322: athrow         
        //   323: athrow         
        //    Exceptions:
        //  throws instrumented.java.util.prefs.BackingStoreException
        //    StackMapTable: 00 0B FC 00 2D 07 00 4D FD 00 15 07 00 C0 01 FB 00 48 FA 00 0A FC 00 1D 07 01 96 7B 07 00 BB FA 00 0A FF 00 2E 00 02 07 00 02 07 00 4D 00 01 07 00 85 FA 00 10 FF 00 05 00 00 00 01 07 00 85 FF 00 00 00 00 00 01 07 00 89
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                                
        //  -----  -----  -----  -----  ----------------------------------------------------
        //  12     323    323    324    Ljava/lang/VirtualMachineError;
        //  200    233    241    252    Linstrumented/java/util/prefs/BackingStoreException;
        //  12     291    299    316    Any
        //  299    308    299    316    Any
        //  0      322    322    323    Any
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
    public String name() {
        try {
            final String name = this.name;
            BytecodeManager.incBytecodes(3);
            return name;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public String absolutePath() {
        try {
            final String absolutePath = this.absolutePath;
            BytecodeManager.incBytecodes(3);
            return absolutePath;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean isUserNode() {
        try {
            BytecodeManager.incBytecodes(4);
            final PrivilegedAction<Boolean> action = new PrivilegedAction<Boolean>() {
                {
                    BytecodeManager.incBytecodes(1);
                }
                
                @Override
                public Boolean run() {
                    try {
                        final AbstractPreferences this$0 = AbstractPreferences.this;
                        BytecodeManager.incBytecodes(3);
                        final AbstractPreferences access$000 = AbstractPreferences.access$000(this$0);
                        BytecodeManager.incBytecodes(1);
                        final Preferences userRoot = Preferences.userRoot();
                        BytecodeManager.incBytecodes(1);
                        boolean b;
                        if (access$000 == userRoot) {
                            b = true;
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            b = false;
                            BytecodeManager.incBytecodes(1);
                        }
                        BytecodeManager.incBytecodes(1);
                        final Boolean value = b;
                        BytecodeManager.incBytecodes(1);
                        return value;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
            };
            BytecodeManager.incBytecodes(1);
            final Boolean b = AccessController.doPrivileged((PrivilegedAction<Boolean>)action);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
            final boolean booleanValue = b;
            BytecodeManager.incBytecodes(1);
            return booleanValue;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void addPreferenceChangeListener(final PreferenceChangeListener p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             2
        //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     6: ifnonnull       30
        //     9: new             Ljava/lang/NullPointerException;
        //    12: dup            
        //    13: ldc_w           "Change listener is null."
        //    16: ldc             4
        //    18: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    21: invokespecial   java/lang/NullPointerException.<init>:(Ljava/lang/String;)V
        //    24: ldc             1
        //    26: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    29: athrow         
        //    30: aload_0        
        //    31: getfield        instrumented/java/util/prefs/AbstractPreferences.lock:Ljava/lang/Object;
        //    34: dup            
        //    35: astore_2       
        //    36: pop            
        //    37: ldc             5
        //    39: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    42: aload_0        
        //    43: getfield        instrumented/java/util/prefs/AbstractPreferences.removed:Z
        //    46: ldc             3
        //    48: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    51: ifeq            74
        //    54: new             Ljava/lang/IllegalStateException;
        //    57: dup            
        //    58: ldc             "Node has been removed."
        //    60: ldc             4
        //    62: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    65: invokespecial   java/lang/IllegalStateException.<init>:(Ljava/lang/String;)V
        //    68: ldc             1
        //    70: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    73: athrow         
        //    74: aload_0        
        //    75: getfield        instrumented/java/util/prefs/AbstractPreferences.prefListeners:[Linstrumented/java/util/prefs/PreferenceChangeListener;
        //    78: astore_3       
        //    79: ldc             3
        //    81: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    84: aload_0        
        //    85: aload_3        
        //    86: arraylength    
        //    87: iconst_1       
        //    88: iadd           
        //    89: anewarray       Linstrumented/java/util/prefs/PreferenceChangeListener;
        //    92: putfield        instrumented/java/util/prefs/AbstractPreferences.prefListeners:[Linstrumented/java/util/prefs/PreferenceChangeListener;
        //    95: ldc_w           6
        //    98: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   101: aload_3        
        //   102: iconst_0       
        //   103: aload_0        
        //   104: getfield        instrumented/java/util/prefs/AbstractPreferences.prefListeners:[Linstrumented/java/util/prefs/PreferenceChangeListener;
        //   107: iconst_0       
        //   108: aload_3        
        //   109: arraylength    
        //   110: ldc_w           8
        //   113: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   116: invokestatic    java/lang/System.arraycopy:(Ljava/lang/Object;ILjava/lang/Object;II)V
        //   119: aload_0        
        //   120: getfield        instrumented/java/util/prefs/AbstractPreferences.prefListeners:[Linstrumented/java/util/prefs/PreferenceChangeListener;
        //   123: aload_3        
        //   124: arraylength    
        //   125: aload_1        
        //   126: aastore        
        //   127: ldc_w           6
        //   130: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   133: aload_2        
        //   134: pop            
        //   135: ldc             2
        //   137: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   140: ldc             1
        //   142: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   145: goto            165
        //   148: astore          4
        //   150: aload_2        
        //   151: pop            
        //   152: ldc             503
        //   154: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   157: aload           4
        //   159: ldc             2
        //   161: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   164: athrow         
        //   165: ldc             1
        //   167: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   170: invokestatic    instrumented/java/util/prefs/AbstractPreferences.startEventDispatchThreadIfNecessary:()V
        //   173: ldc             1
        //   175: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   178: return         
        //   179: athrow         
        //   180: athrow         
        //    StackMapTable: 00 06 1E FC 00 2B 07 00 4D F7 00 49 07 00 85 FA 00 10 FF 00 0D 00 00 00 01 07 00 85 FF 00 00 00 00 00 01 07 00 89
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  42     180    180    181    Ljava/lang/VirtualMachineError;
        //  42     140    148    165    Any
        //  148    157    148    165    Any
        //  0      179    179    180    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0074:
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
    public void removePreferenceChangeListener(final PreferenceChangeListener p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        instrumented/java/util/prefs/AbstractPreferences.lock:Ljava/lang/Object;
        //     4: dup            
        //     5: astore_2       
        //     6: pop            
        //     7: ldc             5
        //     9: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    12: aload_0        
        //    13: getfield        instrumented/java/util/prefs/AbstractPreferences.removed:Z
        //    16: ldc             3
        //    18: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    21: ifeq            44
        //    24: new             Ljava/lang/IllegalStateException;
        //    27: dup            
        //    28: ldc             "Node has been removed."
        //    30: ldc             4
        //    32: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    35: invokespecial   java/lang/IllegalStateException.<init>:(Ljava/lang/String;)V
        //    38: ldc             1
        //    40: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    43: athrow         
        //    44: aload_0        
        //    45: getfield        instrumented/java/util/prefs/AbstractPreferences.prefListeners:[Linstrumented/java/util/prefs/PreferenceChangeListener;
        //    48: ldc             3
        //    50: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    53: ifnull          69
        //    56: aload_0        
        //    57: getfield        instrumented/java/util/prefs/AbstractPreferences.prefListeners:[Linstrumented/java/util/prefs/PreferenceChangeListener;
        //    60: arraylength    
        //    61: ldc             4
        //    63: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    66: ifne            90
        //    69: new             Ljava/lang/IllegalArgumentException;
        //    72: dup            
        //    73: ldc_w           "Listener not registered."
        //    76: ldc             4
        //    78: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    81: invokespecial   java/lang/IllegalArgumentException.<init>:(Ljava/lang/String;)V
        //    84: ldc             1
        //    86: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    89: athrow         
        //    90: aload_0        
        //    91: getfield        instrumented/java/util/prefs/AbstractPreferences.prefListeners:[Linstrumented/java/util/prefs/PreferenceChangeListener;
        //    94: arraylength    
        //    95: iconst_1       
        //    96: isub           
        //    97: anewarray       Linstrumented/java/util/prefs/PreferenceChangeListener;
        //   100: astore_3       
        //   101: ldc_w           6
        //   104: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   107: iconst_0       
        //   108: istore          4
        //   110: ldc             2
        //   112: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   115: iload           4
        //   117: aload_3        
        //   118: arraylength    
        //   119: ldc             4
        //   121: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   124: if_icmpge       167
        //   127: aload_0        
        //   128: getfield        instrumented/java/util/prefs/AbstractPreferences.prefListeners:[Linstrumented/java/util/prefs/PreferenceChangeListener;
        //   131: iload           4
        //   133: aaload         
        //   134: aload_1        
        //   135: ldc_w           6
        //   138: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   141: if_acmpeq       167
        //   144: aload_3        
        //   145: iload           4
        //   147: aload_0        
        //   148: getfield        instrumented/java/util/prefs/AbstractPreferences.prefListeners:[Linstrumented/java/util/prefs/PreferenceChangeListener;
        //   151: iload           4
        //   153: iinc            4, 1
        //   156: aaload         
        //   157: aastore        
        //   158: ldc_w           9
        //   161: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   164: goto            115
        //   167: iload           4
        //   169: aload_3        
        //   170: arraylength    
        //   171: ldc             4
        //   173: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   176: if_icmpne       217
        //   179: aload_0        
        //   180: getfield        instrumented/java/util/prefs/AbstractPreferences.prefListeners:[Linstrumented/java/util/prefs/PreferenceChangeListener;
        //   183: iload           4
        //   185: aaload         
        //   186: aload_1        
        //   187: ldc_w           6
        //   190: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   193: if_acmpeq       217
        //   196: new             Ljava/lang/IllegalArgumentException;
        //   199: dup            
        //   200: ldc_w           "Listener not registered."
        //   203: ldc             4
        //   205: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   208: invokespecial   java/lang/IllegalArgumentException.<init>:(Ljava/lang/String;)V
        //   211: ldc             1
        //   213: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   216: athrow         
        //   217: iload           4
        //   219: aload_3        
        //   220: arraylength    
        //   221: ldc             4
        //   223: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   226: if_icmpge       252
        //   229: aload_3        
        //   230: iload           4
        //   232: aload_0        
        //   233: getfield        instrumented/java/util/prefs/AbstractPreferences.prefListeners:[Linstrumented/java/util/prefs/PreferenceChangeListener;
        //   236: iinc            4, 1
        //   239: iload           4
        //   241: aaload         
        //   242: aastore        
        //   243: ldc_w           9
        //   246: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   249: goto            217
        //   252: aload_0        
        //   253: aload_3        
        //   254: putfield        instrumented/java/util/prefs/AbstractPreferences.prefListeners:[Linstrumented/java/util/prefs/PreferenceChangeListener;
        //   257: ldc             3
        //   259: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   262: aload_2        
        //   263: pop            
        //   264: ldc             2
        //   266: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   269: ldc             1
        //   271: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   274: goto            294
        //   277: astore          5
        //   279: aload_2        
        //   280: pop            
        //   281: ldc             503
        //   283: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   286: aload           5
        //   288: ldc             2
        //   290: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   293: athrow         
        //   294: ldc             1
        //   296: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   299: return         
        //   300: athrow         
        //   301: athrow         
        //    StackMapTable: 00 0B FC 00 2C 07 00 4D 18 14 FD 00 18 07 01 C7 01 33 31 22 FF 00 18 00 03 07 00 02 07 00 45 07 00 4D 00 01 07 00 85 FA 00 10 FF 00 05 00 00 00 01 07 00 85 FF 00 00 00 00 00 01 07 00 89
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  12     301    301    302    Ljava/lang/VirtualMachineError;
        //  12     269    277    294    Any
        //  277    286    277    294    Any
        //  0      300    300    301    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0044:
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
    public void addNodeChangeListener(final NodeChangeListener p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             2
        //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     6: ifnonnull       30
        //     9: new             Ljava/lang/NullPointerException;
        //    12: dup            
        //    13: ldc_w           "Change listener is null."
        //    16: ldc             4
        //    18: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    21: invokespecial   java/lang/NullPointerException.<init>:(Ljava/lang/String;)V
        //    24: ldc             1
        //    26: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    29: athrow         
        //    30: aload_0        
        //    31: getfield        instrumented/java/util/prefs/AbstractPreferences.lock:Ljava/lang/Object;
        //    34: dup            
        //    35: astore_2       
        //    36: pop            
        //    37: ldc             5
        //    39: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    42: aload_0        
        //    43: getfield        instrumented/java/util/prefs/AbstractPreferences.removed:Z
        //    46: ldc             3
        //    48: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    51: ifeq            74
        //    54: new             Ljava/lang/IllegalStateException;
        //    57: dup            
        //    58: ldc             "Node has been removed."
        //    60: ldc             4
        //    62: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    65: invokespecial   java/lang/IllegalStateException.<init>:(Ljava/lang/String;)V
        //    68: ldc             1
        //    70: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    73: athrow         
        //    74: aload_0        
        //    75: getfield        instrumented/java/util/prefs/AbstractPreferences.nodeListeners:[Linstrumented/java/util/prefs/NodeChangeListener;
        //    78: ldc             3
        //    80: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    83: ifnonnull       115
        //    86: aload_0        
        //    87: iconst_1       
        //    88: anewarray       Linstrumented/java/util/prefs/NodeChangeListener;
        //    91: putfield        instrumented/java/util/prefs/AbstractPreferences.nodeListeners:[Linstrumented/java/util/prefs/NodeChangeListener;
        //    94: ldc             3
        //    96: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    99: aload_0        
        //   100: getfield        instrumented/java/util/prefs/AbstractPreferences.nodeListeners:[Linstrumented/java/util/prefs/NodeChangeListener;
        //   103: iconst_0       
        //   104: aload_1        
        //   105: aastore        
        //   106: ldc_w           6
        //   109: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   112: goto            174
        //   115: aload_0        
        //   116: getfield        instrumented/java/util/prefs/AbstractPreferences.nodeListeners:[Linstrumented/java/util/prefs/NodeChangeListener;
        //   119: astore_3       
        //   120: ldc             3
        //   122: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   125: aload_0        
        //   126: aload_3        
        //   127: arraylength    
        //   128: iconst_1       
        //   129: iadd           
        //   130: anewarray       Linstrumented/java/util/prefs/NodeChangeListener;
        //   133: putfield        instrumented/java/util/prefs/AbstractPreferences.nodeListeners:[Linstrumented/java/util/prefs/NodeChangeListener;
        //   136: ldc_w           6
        //   139: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   142: aload_3        
        //   143: iconst_0       
        //   144: aload_0        
        //   145: getfield        instrumented/java/util/prefs/AbstractPreferences.nodeListeners:[Linstrumented/java/util/prefs/NodeChangeListener;
        //   148: iconst_0       
        //   149: aload_3        
        //   150: arraylength    
        //   151: ldc_w           8
        //   154: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   157: invokestatic    java/lang/System.arraycopy:(Ljava/lang/Object;ILjava/lang/Object;II)V
        //   160: aload_0        
        //   161: getfield        instrumented/java/util/prefs/AbstractPreferences.nodeListeners:[Linstrumented/java/util/prefs/NodeChangeListener;
        //   164: aload_3        
        //   165: arraylength    
        //   166: aload_1        
        //   167: aastore        
        //   168: ldc_w           6
        //   171: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   174: aload_2        
        //   175: pop            
        //   176: ldc             2
        //   178: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   181: ldc             1
        //   183: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   186: goto            206
        //   189: astore          4
        //   191: aload_2        
        //   192: pop            
        //   193: ldc             503
        //   195: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   198: aload           4
        //   200: ldc             2
        //   202: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   205: athrow         
        //   206: ldc             1
        //   208: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   211: invokestatic    instrumented/java/util/prefs/AbstractPreferences.startEventDispatchThreadIfNecessary:()V
        //   214: ldc             1
        //   216: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   219: return         
        //   220: athrow         
        //   221: athrow         
        //    StackMapTable: 00 08 1E FC 00 2B 07 00 4D 28 3A 4E 07 00 85 FA 00 10 FF 00 0D 00 00 00 01 07 00 85 FF 00 00 00 00 00 01 07 00 89
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  42     221    221    222    Ljava/lang/VirtualMachineError;
        //  42     181    189    206    Any
        //  189    198    189    206    Any
        //  0      220    220    221    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0074:
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
    public void removeNodeChangeListener(final NodeChangeListener p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        instrumented/java/util/prefs/AbstractPreferences.lock:Ljava/lang/Object;
        //     4: dup            
        //     5: astore_2       
        //     6: pop            
        //     7: ldc             5
        //     9: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    12: aload_0        
        //    13: getfield        instrumented/java/util/prefs/AbstractPreferences.removed:Z
        //    16: ldc             3
        //    18: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    21: ifeq            44
        //    24: new             Ljava/lang/IllegalStateException;
        //    27: dup            
        //    28: ldc             "Node has been removed."
        //    30: ldc             4
        //    32: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    35: invokespecial   java/lang/IllegalStateException.<init>:(Ljava/lang/String;)V
        //    38: ldc             1
        //    40: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    43: athrow         
        //    44: aload_0        
        //    45: getfield        instrumented/java/util/prefs/AbstractPreferences.nodeListeners:[Linstrumented/java/util/prefs/NodeChangeListener;
        //    48: ldc             3
        //    50: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    53: ifnull          69
        //    56: aload_0        
        //    57: getfield        instrumented/java/util/prefs/AbstractPreferences.nodeListeners:[Linstrumented/java/util/prefs/NodeChangeListener;
        //    60: arraylength    
        //    61: ldc             4
        //    63: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    66: ifne            90
        //    69: new             Ljava/lang/IllegalArgumentException;
        //    72: dup            
        //    73: ldc_w           "Listener not registered."
        //    76: ldc             4
        //    78: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    81: invokespecial   java/lang/IllegalArgumentException.<init>:(Ljava/lang/String;)V
        //    84: ldc             1
        //    86: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    89: athrow         
        //    90: iconst_0       
        //    91: istore_3       
        //    92: ldc             2
        //    94: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    97: iload_3        
        //    98: aload_0        
        //    99: getfield        instrumented/java/util/prefs/AbstractPreferences.nodeListeners:[Linstrumented/java/util/prefs/NodeChangeListener;
        //   102: arraylength    
        //   103: ldc             5
        //   105: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   108: if_icmpge       138
        //   111: aload_0        
        //   112: getfield        instrumented/java/util/prefs/AbstractPreferences.nodeListeners:[Linstrumented/java/util/prefs/NodeChangeListener;
        //   115: iload_3        
        //   116: aaload         
        //   117: aload_1        
        //   118: ldc_w           6
        //   121: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   124: if_acmpeq       138
        //   127: iinc            3, 1
        //   130: ldc             2
        //   132: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   135: goto            97
        //   138: iload_3        
        //   139: aload_0        
        //   140: getfield        instrumented/java/util/prefs/AbstractPreferences.nodeListeners:[Linstrumented/java/util/prefs/NodeChangeListener;
        //   143: arraylength    
        //   144: ldc             5
        //   146: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   149: if_icmpne       173
        //   152: new             Ljava/lang/IllegalArgumentException;
        //   155: dup            
        //   156: ldc_w           "Listener not registered."
        //   159: ldc             4
        //   161: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   164: invokespecial   java/lang/IllegalArgumentException.<init>:(Ljava/lang/String;)V
        //   167: ldc             1
        //   169: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   172: athrow         
        //   173: aload_0        
        //   174: getfield        instrumented/java/util/prefs/AbstractPreferences.nodeListeners:[Linstrumented/java/util/prefs/NodeChangeListener;
        //   177: arraylength    
        //   178: iconst_1       
        //   179: isub           
        //   180: anewarray       Linstrumented/java/util/prefs/NodeChangeListener;
        //   183: astore          4
        //   185: ldc_w           6
        //   188: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   191: iload_3        
        //   192: ldc             2
        //   194: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   197: ifeq            218
        //   200: aload_0        
        //   201: getfield        instrumented/java/util/prefs/AbstractPreferences.nodeListeners:[Linstrumented/java/util/prefs/NodeChangeListener;
        //   204: iconst_0       
        //   205: aload           4
        //   207: iconst_0       
        //   208: iload_3        
        //   209: ldc_w           7
        //   212: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   215: invokestatic    java/lang/System.arraycopy:(Ljava/lang/Object;ILjava/lang/Object;II)V
        //   218: iload_3        
        //   219: aload           4
        //   221: arraylength    
        //   222: ldc             4
        //   224: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   227: if_icmpeq       254
        //   230: aload_0        
        //   231: getfield        instrumented/java/util/prefs/AbstractPreferences.nodeListeners:[Linstrumented/java/util/prefs/NodeChangeListener;
        //   234: iload_3        
        //   235: iconst_1       
        //   236: iadd           
        //   237: aload           4
        //   239: iload_3        
        //   240: aload           4
        //   242: arraylength    
        //   243: iload_3        
        //   244: isub           
        //   245: ldc_w           12
        //   248: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   251: invokestatic    java/lang/System.arraycopy:(Ljava/lang/Object;ILjava/lang/Object;II)V
        //   254: aload_0        
        //   255: aload           4
        //   257: putfield        instrumented/java/util/prefs/AbstractPreferences.nodeListeners:[Linstrumented/java/util/prefs/NodeChangeListener;
        //   260: ldc             3
        //   262: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   265: aload_2        
        //   266: pop            
        //   267: ldc             2
        //   269: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   272: ldc             1
        //   274: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   277: goto            297
        //   280: astore          5
        //   282: aload_2        
        //   283: pop            
        //   284: ldc             503
        //   286: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   289: aload           5
        //   291: ldc             2
        //   293: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   296: athrow         
        //   297: ldc             1
        //   299: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   302: return         
        //   303: athrow         
        //   304: athrow         
        //    StackMapTable: 00 0C FC 00 2C 07 00 4D 18 14 FC 00 06 01 28 22 FC 00 2C 07 01 CC 23 FF 00 19 00 03 07 00 02 07 00 49 07 00 4D 00 01 07 00 85 FA 00 10 FF 00 05 00 00 00 01 07 00 85 FF 00 00 00 00 00 01 07 00 89
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  12     304    304    305    Ljava/lang/VirtualMachineError;
        //  12     272    280    297    Any
        //  280    289    280    297    Any
        //  0      303    303    304    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0044:
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
    
    protected abstract void putSpi(final String p0, final String p1);
    
    protected abstract String getSpi(final String p0);
    
    protected abstract void removeSpi(final String p0);
    
    protected abstract void removeNodeSpi() throws BackingStoreException;
    
    protected abstract String[] keysSpi() throws BackingStoreException;
    
    protected abstract String[] childrenNamesSpi() throws BackingStoreException;
    
    protected AbstractPreferences getChild(final String p0) throws BackingStoreException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        instrumented/java/util/prefs/AbstractPreferences.lock:Ljava/lang/Object;
        //     4: dup            
        //     5: astore_2       
        //     6: pop            
        //     7: ldc             5
        //     9: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    12: aload_0        
        //    13: ldc             2
        //    15: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    18: invokevirtual   instrumented/java/util/prefs/AbstractPreferences.childrenNames:()[Ljava/lang/String;
        //    21: astore_3       
        //    22: ldc             1
        //    24: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    27: iconst_0       
        //    28: istore          4
        //    30: ldc             2
        //    32: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    35: iload           4
        //    37: aload_3        
        //    38: arraylength    
        //    39: ldc             4
        //    41: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    44: if_icmpge       105
        //    47: aload_3        
        //    48: iload           4
        //    50: aaload         
        //    51: aload_1        
        //    52: ldc             5
        //    54: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    57: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //    60: ldc             1
        //    62: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    65: ifeq            94
        //    68: aload_0        
        //    69: aload_3        
        //    70: iload           4
        //    72: aaload         
        //    73: ldc             5
        //    75: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    78: invokevirtual   instrumented/java/util/prefs/AbstractPreferences.childSpi:(Ljava/lang/String;)Linstrumented/java/util/prefs/AbstractPreferences;
        //    81: aload_2        
        //    82: pop            
        //    83: ldc             2
        //    85: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    88: ldc             1
        //    90: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    93: areturn        
        //    94: iinc            4, 1
        //    97: ldc             2
        //    99: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   102: goto            35
        //   105: aload_2        
        //   106: pop            
        //   107: ldc             2
        //   109: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   112: ldc             1
        //   114: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   117: goto            137
        //   120: astore          5
        //   122: aload_2        
        //   123: pop            
        //   124: ldc             503
        //   126: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   129: aload           5
        //   131: ldc             2
        //   133: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   136: athrow         
        //   137: aconst_null    
        //   138: ldc             2
        //   140: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   143: areturn        
        //   144: athrow         
        //   145: athrow         
        //    Exceptions:
        //  throws instrumented.java.util.prefs.BackingStoreException
        //    StackMapTable: 00 07 FE 00 23 07 00 4D 07 00 C0 01 3A F9 00 0A 4E 07 00 85 FA 00 10 FF 00 06 00 00 00 01 07 00 85 FF 00 00 00 00 00 01 07 00 89
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  12     145    145    146    Ljava/lang/VirtualMachineError;
        //  12     88     120    137    Any
        //  94     112    120    137    Any
        //  120    129    120    137    Any
        //  0      144    144    145    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0035:
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
    
    protected abstract AbstractPreferences childSpi(final String p0);
    
    @Override
    public String toString() {
        try {
            BytecodeManager.incBytecodes(3);
            final StringBuilder sb = new StringBuilder();
            BytecodeManager.incBytecodes(2);
            final boolean userNode = this.isUserNode();
            BytecodeManager.incBytecodes(1);
            String str;
            if (userNode) {
                str = "User";
                BytecodeManager.incBytecodes(2);
            }
            else {
                str = "System";
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            final StringBuilder append = sb.append(str);
            final String str2 = " Preference Node: ";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append2 = append.append(str2);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
            final String absolutePath = this.absolutePath();
            BytecodeManager.incBytecodes(1);
            final StringBuilder append3 = append2.append(absolutePath);
            BytecodeManager.incBytecodes(1);
            final String string = append3.toString();
            BytecodeManager.incBytecodes(1);
            return string;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void sync() throws BackingStoreException {
        try {
            BytecodeManager.incBytecodes(2);
            this.sync2();
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void sync2() throws BackingStoreException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        instrumented/java/util/prefs/AbstractPreferences.lock:Ljava/lang/Object;
        //     4: dup            
        //     5: astore_2       
        //     6: pop            
        //     7: ldc             5
        //     9: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    12: aload_0        
        //    13: getfield        instrumented/java/util/prefs/AbstractPreferences.removed:Z
        //    16: ldc             3
        //    18: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    21: ifeq            45
        //    24: new             Ljava/lang/IllegalStateException;
        //    27: dup            
        //    28: ldc_w           "Node has been removed"
        //    31: ldc             4
        //    33: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    36: invokespecial   java/lang/IllegalStateException.<init>:(Ljava/lang/String;)V
        //    39: ldc             1
        //    41: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    44: athrow         
        //    45: aload_0        
        //    46: ldc             2
        //    48: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    51: invokevirtual   instrumented/java/util/prefs/AbstractPreferences.syncSpi:()V
        //    54: aload_0        
        //    55: ldc             2
        //    57: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    60: invokevirtual   instrumented/java/util/prefs/AbstractPreferences.cachedChildren:()[Linstrumented/java/util/prefs/AbstractPreferences;
        //    63: astore_1       
        //    64: ldc             1
        //    66: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    69: aload_2        
        //    70: pop            
        //    71: ldc             2
        //    73: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    76: ldc             1
        //    78: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    81: goto            99
        //    84: astore_3       
        //    85: aload_2        
        //    86: pop            
        //    87: ldc             503
        //    89: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    92: aload_3        
        //    93: ldc             2
        //    95: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    98: athrow         
        //    99: iconst_0       
        //   100: istore_2       
        //   101: ldc             2
        //   103: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   106: iload_2        
        //   107: aload_1        
        //   108: arraylength    
        //   109: ldc             4
        //   111: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   114: if_icmpge       139
        //   117: aload_1        
        //   118: iload_2        
        //   119: aaload         
        //   120: ldc             4
        //   122: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   125: invokespecial   instrumented/java/util/prefs/AbstractPreferences.sync2:()V
        //   128: iinc            2, 1
        //   131: ldc             2
        //   133: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   136: goto            106
        //   139: ldc             1
        //   141: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   144: return         
        //   145: athrow         
        //   146: athrow         
        //    Exceptions:
        //  throws instrumented.java.util.prefs.BackingStoreException
        //    StackMapTable: 00 07 FD 00 2D 00 07 00 4D 66 07 00 85 FF 00 0E 00 02 07 00 02 07 01 48 00 00 FC 00 06 01 FA 00 20 FF 00 05 00 00 00 01 07 00 85 FF 00 00 00 00 00 01 07 00 89
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  12     146    146    147    Ljava/lang/VirtualMachineError;
        //  12     76     84     99     Any
        //  84     92     84     99     Any
        //  0      145    145    146    Any
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
    
    protected abstract void syncSpi() throws BackingStoreException;
    
    @Override
    public void flush() throws BackingStoreException {
        try {
            BytecodeManager.incBytecodes(2);
            this.flush2();
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void flush2() throws BackingStoreException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        instrumented/java/util/prefs/AbstractPreferences.lock:Ljava/lang/Object;
        //     4: dup            
        //     5: astore_2       
        //     6: pop            
        //     7: ldc             5
        //     9: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    12: aload_0        
        //    13: ldc             2
        //    15: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    18: invokevirtual   instrumented/java/util/prefs/AbstractPreferences.flushSpi:()V
        //    21: aload_0        
        //    22: getfield        instrumented/java/util/prefs/AbstractPreferences.removed:Z
        //    25: ldc             3
        //    27: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    30: ifeq            46
        //    33: aload_2        
        //    34: pop            
        //    35: ldc             2
        //    37: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    40: ldc             1
        //    42: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    45: return         
        //    46: aload_0        
        //    47: ldc             2
        //    49: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    52: invokevirtual   instrumented/java/util/prefs/AbstractPreferences.cachedChildren:()[Linstrumented/java/util/prefs/AbstractPreferences;
        //    55: astore_1       
        //    56: ldc             1
        //    58: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    61: aload_2        
        //    62: pop            
        //    63: ldc             2
        //    65: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    68: ldc             1
        //    70: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    73: goto            91
        //    76: astore_3       
        //    77: aload_2        
        //    78: pop            
        //    79: ldc             503
        //    81: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    84: aload_3        
        //    85: ldc             2
        //    87: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    90: athrow         
        //    91: iconst_0       
        //    92: istore_2       
        //    93: ldc             2
        //    95: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    98: iload_2        
        //    99: aload_1        
        //   100: arraylength    
        //   101: ldc             4
        //   103: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   106: if_icmpge       131
        //   109: aload_1        
        //   110: iload_2        
        //   111: aaload         
        //   112: ldc             4
        //   114: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   117: invokespecial   instrumented/java/util/prefs/AbstractPreferences.flush2:()V
        //   120: iinc            2, 1
        //   123: ldc             2
        //   125: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   128: goto            98
        //   131: ldc             1
        //   133: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   136: return         
        //   137: athrow         
        //   138: athrow         
        //    Exceptions:
        //  throws instrumented.java.util.prefs.BackingStoreException
        //    StackMapTable: 00 07 FD 00 2E 00 07 00 4D 5D 07 00 85 FF 00 0E 00 02 07 00 02 07 01 48 00 00 FC 00 06 01 FA 00 20 FF 00 05 00 00 00 01 07 00 85 FF 00 00 00 00 00 01 07 00 89
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  12     138    138    139    Ljava/lang/VirtualMachineError;
        //  12     40     76     91     Any
        //  46     68     76     91     Any
        //  76     84     76     91     Any
        //  0      137    137    138    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0046:
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
    
    protected abstract void flushSpi() throws BackingStoreException;
    
    protected boolean isRemoved() {
        try {
            final Object lock = this.lock;
            BytecodeManager.incBytecodes(5);
            try {
                final AbstractPreferences abstractPreferences = this;
                final boolean b = abstractPreferences.removed;
                final int n = 4;
                BytecodeManager.incBytecodes(n);
                final int n2 = 1;
                BytecodeManager.incBytecodes(n2);
                return b;
            }
            finally {
                BytecodeManager.incBytecodes(503);
                BytecodeManager.incBytecodes(2);
            }
        }
        finally {}
        try {
            final AbstractPreferences abstractPreferences = this;
            final boolean b = abstractPreferences.removed;
            final int n = 4;
            BytecodeManager.incBytecodes(n);
            final int n2 = 1;
            BytecodeManager.incBytecodes(n2);
            return b;
        }
        catch (VirtualMachineError virtualMachineError) {
            throw virtualMachineError;
        }
    }
    
    private static synchronized void startEventDispatchThreadIfNecessary() {
        try {
            final Thread eventDispatchThread = AbstractPreferences.eventDispatchThread;
            BytecodeManager.incBytecodes(2);
            if (eventDispatchThread == null) {
                final PrivilegedAction<Boolean> privilegedAction = null;
                BytecodeManager.incBytecodes(4);
                AbstractPreferences.eventDispatchThread = new EventDispatchThread();
                BytecodeManager.incBytecodes(1);
                final Thread eventDispatchThread2 = AbstractPreferences.eventDispatchThread;
                final boolean daemon = true;
                BytecodeManager.incBytecodes(3);
                eventDispatchThread2.setDaemon(daemon);
                final Thread eventDispatchThread3 = AbstractPreferences.eventDispatchThread;
                BytecodeManager.incBytecodes(2);
                eventDispatchThread3.start();
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    PreferenceChangeListener[] prefListeners() {
        try {
            final Object lock = this.lock;
            BytecodeManager.incBytecodes(5);
            try {
                final AbstractPreferences abstractPreferences = this;
                final PreferenceChangeListener[] array = abstractPreferences.prefListeners;
                final int n = 4;
                BytecodeManager.incBytecodes(n);
                final int n2 = 1;
                BytecodeManager.incBytecodes(n2);
                return array;
            }
            finally {
                BytecodeManager.incBytecodes(503);
                BytecodeManager.incBytecodes(2);
            }
        }
        finally {}
        try {
            final AbstractPreferences abstractPreferences = this;
            final PreferenceChangeListener[] array = abstractPreferences.prefListeners;
            final int n = 4;
            BytecodeManager.incBytecodes(n);
            final int n2 = 1;
            BytecodeManager.incBytecodes(n2);
            return array;
        }
        catch (VirtualMachineError virtualMachineError) {
            throw virtualMachineError;
        }
    }
    
    NodeChangeListener[] nodeListeners() {
        try {
            final Object lock = this.lock;
            BytecodeManager.incBytecodes(5);
            try {
                final AbstractPreferences abstractPreferences = this;
                final NodeChangeListener[] array = abstractPreferences.nodeListeners;
                final int n = 4;
                BytecodeManager.incBytecodes(n);
                final int n2 = 1;
                BytecodeManager.incBytecodes(n2);
                return array;
            }
            finally {
                BytecodeManager.incBytecodes(503);
                BytecodeManager.incBytecodes(2);
            }
        }
        finally {}
        try {
            final AbstractPreferences abstractPreferences = this;
            final NodeChangeListener[] array = abstractPreferences.nodeListeners;
            final int n = 4;
            BytecodeManager.incBytecodes(n);
            final int n2 = 1;
            BytecodeManager.incBytecodes(n2);
            return array;
        }
        catch (VirtualMachineError virtualMachineError) {
            throw virtualMachineError;
        }
    }
    
    private void enqueuePreferenceChangeEvent(final String p0, final String p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        instrumented/java/util/prefs/AbstractPreferences.prefListeners:[Linstrumented/java/util/prefs/PreferenceChangeListener;
        //     4: arraylength    
        //     5: ldc             4
        //     7: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    10: ifeq            102
        //    13: getstatic       instrumented/java/util/prefs/AbstractPreferences.eventQueue:Linstrumented/java/util/List;
        //    16: dup            
        //    17: astore_3       
        //    18: pop            
        //    19: ldc             4
        //    21: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    24: getstatic       instrumented/java/util/prefs/AbstractPreferences.eventQueue:Linstrumented/java/util/List;
        //    27: new             Linstrumented/java/util/prefs/PreferenceChangeEvent;
        //    30: dup            
        //    31: aload_0        
        //    32: aload_1        
        //    33: aload_2        
        //    34: ldc_w           7
        //    37: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    40: invokespecial   instrumented/java/util/prefs/PreferenceChangeEvent.<init>:(Linstrumented/java/util/prefs/Preferences;Ljava/lang/String;Ljava/lang/String;)V
        //    43: ldc             1
        //    45: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    48: invokeinterface instrumented/java/util/List.add:(Ljava/lang/Object;)Z
        //    53: pop            
        //    54: ldc             1
        //    56: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    59: getstatic       instrumented/java/util/prefs/AbstractPreferences.eventQueue:Linstrumented/java/util/List;
        //    62: ldc             2
        //    64: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    67: invokevirtual   java/lang/Object.notify:()V
        //    70: aload_3        
        //    71: pop            
        //    72: ldc             2
        //    74: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    77: ldc             1
        //    79: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    82: goto            102
        //    85: astore          4
        //    87: aload_3        
        //    88: pop            
        //    89: ldc             503
        //    91: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    94: aload           4
        //    96: ldc             2
        //    98: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   101: athrow         
        //   102: ldc             1
        //   104: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   107: return         
        //   108: athrow         
        //   109: athrow         
        //    StackMapTable: 00 04 FF 00 55 00 04 07 00 02 07 00 54 07 00 54 07 00 4D 00 01 07 00 85 FA 00 10 FF 00 05 00 00 00 01 07 00 85 FF 00 00 00 00 00 01 07 00 89
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  24     109    109    110    Ljava/lang/VirtualMachineError;
        //  24     77     85     102    Any
        //  85     94     85     102    Any
        //  0      108    108    109    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0102:
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
    
    private void enqueueNodeAddedEvent(final Preferences p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        instrumented/java/util/prefs/AbstractPreferences.nodeListeners:[Linstrumented/java/util/prefs/NodeChangeListener;
        //     4: arraylength    
        //     5: ldc             4
        //     7: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    10: ifeq            100
        //    13: getstatic       instrumented/java/util/prefs/AbstractPreferences.eventQueue:Linstrumented/java/util/List;
        //    16: dup            
        //    17: astore_2       
        //    18: pop            
        //    19: ldc             4
        //    21: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    24: getstatic       instrumented/java/util/prefs/AbstractPreferences.eventQueue:Linstrumented/java/util/List;
        //    27: new             Linstrumented/java/util/prefs/AbstractPreferences$NodeAddedEvent;
        //    30: dup            
        //    31: aload_0        
        //    32: aload_0        
        //    33: aload_1        
        //    34: ldc_w           7
        //    37: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    40: invokespecial   instrumented/java/util/prefs/AbstractPreferences$NodeAddedEvent.<init>:(Linstrumented/java/util/prefs/AbstractPreferences;Linstrumented/java/util/prefs/Preferences;Linstrumented/java/util/prefs/Preferences;)V
        //    43: ldc             1
        //    45: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    48: invokeinterface instrumented/java/util/List.add:(Ljava/lang/Object;)Z
        //    53: pop            
        //    54: ldc             1
        //    56: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    59: getstatic       instrumented/java/util/prefs/AbstractPreferences.eventQueue:Linstrumented/java/util/List;
        //    62: ldc             2
        //    64: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    67: invokevirtual   java/lang/Object.notify:()V
        //    70: aload_2        
        //    71: pop            
        //    72: ldc             2
        //    74: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    77: ldc             1
        //    79: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    82: goto            100
        //    85: astore_3       
        //    86: aload_2        
        //    87: pop            
        //    88: ldc             503
        //    90: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    93: aload_3        
        //    94: ldc             2
        //    96: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    99: athrow         
        //   100: ldc             1
        //   102: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   105: return         
        //   106: athrow         
        //   107: athrow         
        //    StackMapTable: 00 04 FF 00 55 00 03 07 00 02 07 00 04 07 00 4D 00 01 07 00 85 FA 00 0E FF 00 05 00 00 00 01 07 00 85 FF 00 00 00 00 00 01 07 00 89
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  24     107    107    108    Ljava/lang/VirtualMachineError;
        //  24     77     85     100    Any
        //  85     93     85     100    Any
        //  0      106    106    107    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0100:
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
    
    private void enqueueNodeRemovedEvent(final Preferences p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        instrumented/java/util/prefs/AbstractPreferences.nodeListeners:[Linstrumented/java/util/prefs/NodeChangeListener;
        //     4: arraylength    
        //     5: ldc             4
        //     7: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    10: ifeq            100
        //    13: getstatic       instrumented/java/util/prefs/AbstractPreferences.eventQueue:Linstrumented/java/util/List;
        //    16: dup            
        //    17: astore_2       
        //    18: pop            
        //    19: ldc             4
        //    21: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    24: getstatic       instrumented/java/util/prefs/AbstractPreferences.eventQueue:Linstrumented/java/util/List;
        //    27: new             Linstrumented/java/util/prefs/AbstractPreferences$NodeRemovedEvent;
        //    30: dup            
        //    31: aload_0        
        //    32: aload_0        
        //    33: aload_1        
        //    34: ldc_w           7
        //    37: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    40: invokespecial   instrumented/java/util/prefs/AbstractPreferences$NodeRemovedEvent.<init>:(Linstrumented/java/util/prefs/AbstractPreferences;Linstrumented/java/util/prefs/Preferences;Linstrumented/java/util/prefs/Preferences;)V
        //    43: ldc             1
        //    45: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    48: invokeinterface instrumented/java/util/List.add:(Ljava/lang/Object;)Z
        //    53: pop            
        //    54: ldc             1
        //    56: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    59: getstatic       instrumented/java/util/prefs/AbstractPreferences.eventQueue:Linstrumented/java/util/List;
        //    62: ldc             2
        //    64: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    67: invokevirtual   java/lang/Object.notify:()V
        //    70: aload_2        
        //    71: pop            
        //    72: ldc             2
        //    74: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    77: ldc             1
        //    79: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    82: goto            100
        //    85: astore_3       
        //    86: aload_2        
        //    87: pop            
        //    88: ldc             503
        //    90: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    93: aload_3        
        //    94: ldc             2
        //    96: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    99: athrow         
        //   100: ldc             1
        //   102: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   105: return         
        //   106: athrow         
        //   107: athrow         
        //    StackMapTable: 00 04 FF 00 55 00 03 07 00 02 07 00 04 07 00 4D 00 01 07 00 85 FA 00 0E FF 00 05 00 00 00 01 07 00 85 FF 00 00 00 00 00 01 07 00 89
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  24     107    107    108    Ljava/lang/VirtualMachineError;
        //  24     77     85     100    Any
        //  85     93     85     100    Any
        //  0      106    106    107    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0100:
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
    public void exportNode(final OutputStream outputStream) throws IOException, BackingStoreException {
        try {
            final boolean b = false;
            BytecodeManager.incBytecodes(4);
            XmlSupport.export(outputStream, this, b);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void exportSubtree(final OutputStream outputStream) throws IOException, BackingStoreException {
        try {
            final boolean b = true;
            BytecodeManager.incBytecodes(4);
            XmlSupport.export(outputStream, this, b);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static /* synthetic */ AbstractPreferences access$000(final AbstractPreferences abstractPreferences) {
        try {
            final AbstractPreferences root = abstractPreferences.root;
            BytecodeManager.incBytecodes(3);
            return root;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static {
        try {
            EMPTY_STRING_ARRAY = new String[0];
            BytecodeManager.incBytecodes(2);
            EMPTY_ABSTRACT_PREFS_ARRAY = new AbstractPreferences[0];
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(3);
            eventQueue = new LinkedList<EventObject>();
            BytecodeManager.incBytecodes(1);
            AbstractPreferences.eventDispatchThread = null;
            BytecodeManager.incBytecodes(3);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private class NodeAddedEvent extends NodeChangeEvent
    {
        private static final long serialVersionUID = -6743557530157328528L;
        
        NodeAddedEvent(final Preferences preferences, final Preferences preferences2) {
            try {
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(4);
                super(preferences, preferences2);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private class NodeRemovedEvent extends NodeChangeEvent
    {
        private static final long serialVersionUID = 8735497392918824837L;
        
        NodeRemovedEvent(final Preferences preferences, final Preferences preferences2) {
            try {
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(4);
                super(preferences, preferences2);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private static class EventDispatchThread extends Thread
    {
        private EventDispatchThread() {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void run() {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: astore_1       
            //     2: ldc             2
            //     4: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //     7: ldc             1
            //     9: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    12: invokestatic    instrumented/java/util/prefs/AbstractPreferences.access$100:()Linstrumented/java/util/List;
            //    15: dup            
            //    16: astore_2       
            //    17: pop            
            //    18: ldc             3
            //    20: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    23: ldc             1
            //    25: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    28: invokestatic    instrumented/java/util/prefs/AbstractPreferences.access$100:()Linstrumented/java/util/List;
            //    31: ldc             1
            //    33: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    36: invokeinterface instrumented/java/util/List.isEmpty:()Z
            //    41: ldc             1
            //    43: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    46: ifeq            73
            //    49: ldc             1
            //    51: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    54: invokestatic    instrumented/java/util/prefs/AbstractPreferences.access$100:()Linstrumented/java/util/List;
            //    57: ldc             1
            //    59: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    62: invokevirtual   java/lang/Object.wait:()V
            //    65: ldc             1
            //    67: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    70: goto            23
            //    73: ldc             1
            //    75: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    78: invokestatic    instrumented/java/util/prefs/AbstractPreferences.access$100:()Linstrumented/java/util/List;
            //    81: iconst_0       
            //    82: ldc             2
            //    84: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    87: invokeinterface instrumented/java/util/List.remove:(I)Ljava/lang/Object;
            //    92: checkcast       Linstrumented/java/util/EventObject;
            //    95: astore_1       
            //    96: ldc             2
            //    98: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   101: ldc             1
            //   103: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   106: goto            128
            //   109: astore_3       
            //   110: ldc             501
            //   112: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   115: aload_2        
            //   116: pop            
            //   117: ldc             2
            //   119: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   122: ldc             1
            //   124: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   127: return         
            //   128: aload_2        
            //   129: pop            
            //   130: ldc             2
            //   132: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   135: ldc             1
            //   137: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   140: goto            160
            //   143: astore          4
            //   145: aload_2        
            //   146: pop            
            //   147: ldc             503
            //   149: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   152: aload           4
            //   154: ldc             2
            //   156: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   159: athrow         
            //   160: aload_1        
            //   161: ldc             2
            //   163: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   166: invokevirtual   instrumented/java/util/EventObject.getSource:()Ljava/lang/Object;
            //   169: checkcast       Linstrumented/java/util/prefs/AbstractPreferences;
            //   172: astore_2       
            //   173: ldc             2
            //   175: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   178: aload_1        
            //   179: instanceof      Linstrumented/java/util/prefs/PreferenceChangeEvent;
            //   182: ldc             3
            //   184: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   187: ifeq            272
            //   190: aload_1        
            //   191: checkcast       Linstrumented/java/util/prefs/PreferenceChangeEvent;
            //   194: astore_3       
            //   195: ldc             3
            //   197: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   200: aload_2        
            //   201: ldc             2
            //   203: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   206: invokevirtual   instrumented/java/util/prefs/AbstractPreferences.prefListeners:()[Linstrumented/java/util/prefs/PreferenceChangeListener;
            //   209: astore          4
            //   211: ldc             1
            //   213: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   216: iconst_0       
            //   217: istore          5
            //   219: ldc             2
            //   221: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   224: iload           5
            //   226: aload           4
            //   228: arraylength    
            //   229: ldc             4
            //   231: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   234: if_icmpge       264
            //   237: aload           4
            //   239: iload           5
            //   241: aaload         
            //   242: aload_3        
            //   243: ldc             5
            //   245: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   248: invokeinterface instrumented/java/util/prefs/PreferenceChangeListener.preferenceChange:(Linstrumented/java/util/prefs/PreferenceChangeEvent;)V
            //   253: iinc            5, 1
            //   256: ldc             2
            //   258: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   261: goto            224
            //   264: ldc             1
            //   266: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   269: goto            414
            //   272: aload_1        
            //   273: checkcast       Linstrumented/java/util/prefs/NodeChangeEvent;
            //   276: astore_3       
            //   277: ldc             3
            //   279: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   282: aload_2        
            //   283: ldc             2
            //   285: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   288: invokevirtual   instrumented/java/util/prefs/AbstractPreferences.nodeListeners:()[Linstrumented/java/util/prefs/NodeChangeListener;
            //   291: astore          4
            //   293: ldc             1
            //   295: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   298: aload_3        
            //   299: instanceof      Linstrumented/java/util/prefs/AbstractPreferences$NodeAddedEvent;
            //   302: ldc             3
            //   304: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   307: ifeq            366
            //   310: iconst_0       
            //   311: istore          5
            //   313: ldc             2
            //   315: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   318: iload           5
            //   320: aload           4
            //   322: arraylength    
            //   323: ldc             4
            //   325: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   328: if_icmpge       358
            //   331: aload           4
            //   333: iload           5
            //   335: aaload         
            //   336: aload_3        
            //   337: ldc             5
            //   339: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   342: invokeinterface instrumented/java/util/prefs/NodeChangeListener.childAdded:(Linstrumented/java/util/prefs/NodeChangeEvent;)V
            //   347: iinc            5, 1
            //   350: ldc             2
            //   352: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   355: goto            318
            //   358: ldc             1
            //   360: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   363: goto            414
            //   366: iconst_0       
            //   367: istore          5
            //   369: ldc             2
            //   371: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   374: iload           5
            //   376: aload           4
            //   378: arraylength    
            //   379: ldc             4
            //   381: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   384: if_icmpge       414
            //   387: aload           4
            //   389: iload           5
            //   391: aaload         
            //   392: aload_3        
            //   393: ldc             5
            //   395: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   398: invokeinterface instrumented/java/util/prefs/NodeChangeListener.childRemoved:(Linstrumented/java/util/prefs/NodeChangeEvent;)V
            //   403: iinc            5, 1
            //   406: ldc             2
            //   408: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   411: goto            374
            //   414: ldc             1
            //   416: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   419: goto            0
            //   422: athrow         
            //   423: athrow         
            //    StackMapTable: 00 11 00 FD 00 16 07 00 27 07 00 29 31 63 07 00 20 12 4E 07 00 1B FA 00 10 FF 00 3F 00 06 07 00 02 07 00 27 07 00 07 07 00 3E 07 00 44 01 00 00 F8 00 27 07 FE 00 2D 07 00 4E 07 00 54 01 FA 00 27 07 FC 00 07 01 FF 00 27 00 01 07 00 02 00 00 FF 00 07 00 00 00 01 07 00 1B FF 00 00 00 00 00 01 07 00 1E
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                            
            //  -----  -----  -----  -----  --------------------------------
            //  23     423    423    424    Ljava/lang/VirtualMachineError;
            //  23     101    109    128    Ljava/lang/InterruptedException;
            //  23     122    143    160    Any
            //  128    135    143    160    Any
            //  143    152    143    160    Any
            //  0      422    422    423    Any
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0023:
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
    }
}
