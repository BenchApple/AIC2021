// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.security.Permission;
import aic2021.engine.BytecodeManager;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.security.PermissionCollection;

final class PropertyPermissionCollection extends PermissionCollection implements Serializable
{
    private transient Map<String, PropertyPermission> perms;
    private boolean all_allowed;
    private static final long serialVersionUID = 7015263904581634791L;
    private static final ObjectStreamField[] serialPersistentFields;
    
    public PropertyPermissionCollection() {
        try {
            BytecodeManager.incBytecodes(2);
            final int n = 32;
            BytecodeManager.incBytecodes(5);
            this.perms = new HashMap<String, PropertyPermission>(n);
            BytecodeManager.incBytecodes(1);
            this.all_allowed = false;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void add(final Permission p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: instanceof      Linstrumented/java/util/PropertyPermission;
        //     4: ldc             3
        //     6: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     9: ifne            69
        //    12: new             Ljava/lang/IllegalArgumentException;
        //    15: dup            
        //    16: new             Ljava/lang/StringBuilder;
        //    19: dup            
        //    20: ldc             5
        //    22: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    25: invokespecial   java/lang/StringBuilder.<init>:()V
        //    28: ldc             "invalid permission: "
        //    30: ldc             2
        //    32: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    35: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    38: aload_1        
        //    39: ldc             2
        //    41: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    44: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //    47: ldc             1
        //    49: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    52: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    55: ldc             1
        //    57: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    60: invokespecial   java/lang/IllegalArgumentException.<init>:(Ljava/lang/String;)V
        //    63: ldc             1
        //    65: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    68: athrow         
        //    69: aload_0        
        //    70: ldc             2
        //    72: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    75: invokevirtual   instrumented/java/util/PropertyPermissionCollection.isReadOnly:()Z
        //    78: ldc             1
        //    80: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    83: ifeq            106
        //    86: new             Ljava/lang/SecurityException;
        //    89: dup            
        //    90: ldc             "attempt to add a Permission to a readonly PermissionCollection"
        //    92: ldc             4
        //    94: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    97: invokespecial   java/lang/SecurityException.<init>:(Ljava/lang/String;)V
        //   100: ldc             1
        //   102: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   105: athrow         
        //   106: aload_1        
        //   107: checkcast       Linstrumented/java/util/PropertyPermission;
        //   110: astore_2       
        //   111: ldc             3
        //   113: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   116: aload_2        
        //   117: ldc             2
        //   119: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   122: invokevirtual   instrumented/java/util/PropertyPermission.getName:()Ljava/lang/String;
        //   125: astore_3       
        //   126: ldc             1
        //   128: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   131: aload_0        
        //   132: dup            
        //   133: astore          4
        //   135: pop            
        //   136: ldc             4
        //   138: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   141: aload_0        
        //   142: getfield        instrumented/java/util/PropertyPermissionCollection.perms:Linstrumented/java/util/Map;
        //   145: aload_3        
        //   146: ldc             4
        //   148: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   151: invokeinterface instrumented/java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //   156: checkcast       Linstrumented/java/util/PropertyPermission;
        //   159: astore          5
        //   161: ldc             2
        //   163: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   166: aload           5
        //   168: ldc             2
        //   170: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   173: ifnull          294
        //   176: aload           5
        //   178: ldc             2
        //   180: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   183: invokevirtual   instrumented/java/util/PropertyPermission.getMask:()I
        //   186: istore          6
        //   188: ldc             1
        //   190: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   193: aload_2        
        //   194: ldc             2
        //   196: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   199: invokevirtual   instrumented/java/util/PropertyPermission.getMask:()I
        //   202: istore          7
        //   204: ldc             1
        //   206: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   209: iload           6
        //   211: iload           7
        //   213: ldc             3
        //   215: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   218: if_icmpeq       286
        //   221: iload           6
        //   223: iload           7
        //   225: ior            
        //   226: istore          8
        //   228: ldc             4
        //   230: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   233: iload           8
        //   235: ldc             2
        //   237: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   240: invokestatic    instrumented/java/util/PropertyPermission.getActions:(I)Ljava/lang/String;
        //   243: astore          9
        //   245: ldc             1
        //   247: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   250: aload_0        
        //   251: getfield        instrumented/java/util/PropertyPermissionCollection.perms:Linstrumented/java/util/Map;
        //   254: aload_3        
        //   255: new             Linstrumented/java/util/PropertyPermission;
        //   258: dup            
        //   259: aload_3        
        //   260: aload           9
        //   262: ldc             8
        //   264: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   267: invokespecial   instrumented/java/util/PropertyPermission.<init>:(Ljava/lang/String;Ljava/lang/String;)V
        //   270: ldc             1
        //   272: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   275: invokeinterface instrumented/java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   280: pop            
        //   281: ldc             1
        //   283: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   286: ldc             1
        //   288: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   291: goto            316
        //   294: aload_0        
        //   295: getfield        instrumented/java/util/PropertyPermissionCollection.perms:Linstrumented/java/util/Map;
        //   298: aload_3        
        //   299: aload_2        
        //   300: ldc             5
        //   302: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   305: invokeinterface instrumented/java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   310: pop            
        //   311: ldc             1
        //   313: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   316: aload           4
        //   318: pop            
        //   319: ldc             2
        //   321: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   324: ldc             1
        //   326: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   329: goto            350
        //   332: astore          10
        //   334: aload           4
        //   336: pop            
        //   337: ldc             503
        //   339: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   342: aload           10
        //   344: ldc             2
        //   346: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   349: athrow         
        //   350: aload_0        
        //   351: getfield        instrumented/java/util/PropertyPermissionCollection.all_allowed:Z
        //   354: ldc             3
        //   356: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   359: ifne            391
        //   362: aload_3        
        //   363: ldc             "*"
        //   365: ldc             3
        //   367: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   370: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   373: ldc             1
        //   375: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   378: ifeq            391
        //   381: aload_0        
        //   382: iconst_1       
        //   383: putfield        instrumented/java/util/PropertyPermissionCollection.all_allowed:Z
        //   386: ldc             3
        //   388: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   391: ldc             1
        //   393: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   396: return         
        //   397: athrow         
        //   398: athrow         
        //    StackMapTable: 00 0A FB 00 45 24 FF 00 B3 00 06 07 00 02 07 00 74 07 00 3A 07 00 76 07 00 78 07 00 3A 00 00 07 FA 00 15 4F 07 00 34 FA 00 11 28 FF 00 05 00 00 00 01 07 00 34 FF 00 00 00 00 00 01 07 00 38
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  141    398    398    399    Ljava/lang/VirtualMachineError;
        //  141    324    332    350    Any
        //  332    342    332    350    Any
        //  0      397    397    398    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0286:
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
    public boolean implies(final Permission p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: instanceof      Linstrumented/java/util/PropertyPermission;
        //     4: ldc             3
        //     6: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     9: ifne            19
        //    12: iconst_0       
        //    13: ldc             2
        //    15: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    18: ireturn        
        //    19: aload_1        
        //    20: checkcast       Linstrumented/java/util/PropertyPermission;
        //    23: astore_2       
        //    24: ldc             3
        //    26: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    29: aload_2        
        //    30: ldc             2
        //    32: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    35: invokevirtual   instrumented/java/util/PropertyPermission.getMask:()I
        //    38: istore          4
        //    40: ldc             1
        //    42: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    45: iconst_0       
        //    46: istore          5
        //    48: ldc             2
        //    50: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    53: aload_0        
        //    54: getfield        instrumented/java/util/PropertyPermissionCollection.all_allowed:Z
        //    57: ldc             3
        //    59: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    62: ifeq            184
        //    65: aload_0        
        //    66: dup            
        //    67: astore          6
        //    69: pop            
        //    70: ldc             4
        //    72: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    75: aload_0        
        //    76: getfield        instrumented/java/util/PropertyPermissionCollection.perms:Linstrumented/java/util/Map;
        //    79: ldc             "*"
        //    81: ldc             4
        //    83: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    86: invokeinterface instrumented/java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //    91: checkcast       Linstrumented/java/util/PropertyPermission;
        //    94: astore_3       
        //    95: ldc             2
        //    97: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   100: aload           6
        //   102: pop            
        //   103: ldc             2
        //   105: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   108: ldc             1
        //   110: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   113: goto            134
        //   116: astore          7
        //   118: aload           6
        //   120: pop            
        //   121: ldc             503
        //   123: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   126: aload           7
        //   128: ldc             2
        //   130: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   133: athrow         
        //   134: aload_3        
        //   135: ldc             2
        //   137: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   140: ifnull          184
        //   143: iload           5
        //   145: aload_3        
        //   146: ldc             3
        //   148: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   151: invokevirtual   instrumented/java/util/PropertyPermission.getMask:()I
        //   154: ior            
        //   155: istore          5
        //   157: ldc             2
        //   159: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   162: iload           5
        //   164: iload           4
        //   166: iand           
        //   167: iload           4
        //   169: ldc             5
        //   171: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   174: if_icmpne       184
        //   177: iconst_1       
        //   178: ldc             2
        //   180: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   183: ireturn        
        //   184: aload_2        
        //   185: ldc             2
        //   187: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   190: invokevirtual   instrumented/java/util/PropertyPermission.getName:()Ljava/lang/String;
        //   193: astore          6
        //   195: ldc             1
        //   197: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   200: aload_0        
        //   201: dup            
        //   202: astore          7
        //   204: pop            
        //   205: ldc             4
        //   207: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   210: aload_0        
        //   211: getfield        instrumented/java/util/PropertyPermissionCollection.perms:Linstrumented/java/util/Map;
        //   214: aload           6
        //   216: ldc             4
        //   218: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   221: invokeinterface instrumented/java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //   226: checkcast       Linstrumented/java/util/PropertyPermission;
        //   229: astore_3       
        //   230: ldc             2
        //   232: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   235: aload           7
        //   237: pop            
        //   238: ldc             2
        //   240: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   243: ldc             1
        //   245: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   248: goto            269
        //   251: astore          8
        //   253: aload           7
        //   255: pop            
        //   256: ldc             503
        //   258: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   261: aload           8
        //   263: ldc             2
        //   265: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   268: athrow         
        //   269: aload_3        
        //   270: ldc             2
        //   272: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   275: ifnull          319
        //   278: iload           5
        //   280: aload_3        
        //   281: ldc             3
        //   283: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   286: invokevirtual   instrumented/java/util/PropertyPermission.getMask:()I
        //   289: ior            
        //   290: istore          5
        //   292: ldc             2
        //   294: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   297: iload           5
        //   299: iload           4
        //   301: iand           
        //   302: iload           4
        //   304: ldc             5
        //   306: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   309: if_icmpne       319
        //   312: iconst_1       
        //   313: ldc             2
        //   315: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   318: ireturn        
        //   319: aload           6
        //   321: ldc             2
        //   323: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   326: invokevirtual   java/lang/String.length:()I
        //   329: iconst_1       
        //   330: isub           
        //   331: istore          8
        //   333: ldc             3
        //   335: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   338: aload           6
        //   340: ldc             "."
        //   342: iload           8
        //   344: ldc             4
        //   346: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   349: invokevirtual   java/lang/String.lastIndexOf:(Ljava/lang/String;I)I
        //   352: dup            
        //   353: istore          7
        //   355: iconst_m1      
        //   356: ldc             4
        //   358: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   361: if_icmpeq       557
        //   364: new             Ljava/lang/StringBuilder;
        //   367: dup            
        //   368: ldc             3
        //   370: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   373: invokespecial   java/lang/StringBuilder.<init>:()V
        //   376: aload           6
        //   378: iconst_0       
        //   379: iload           7
        //   381: iconst_1       
        //   382: iadd           
        //   383: ldc             6
        //   385: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   388: invokevirtual   java/lang/String.substring:(II)Ljava/lang/String;
        //   391: ldc             1
        //   393: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   396: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   399: ldc             "*"
        //   401: ldc             2
        //   403: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   406: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   409: ldc             1
        //   411: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   414: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   417: astore          6
        //   419: ldc             1
        //   421: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   424: aload_0        
        //   425: dup            
        //   426: astore          9
        //   428: pop            
        //   429: ldc             4
        //   431: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   434: aload_0        
        //   435: getfield        instrumented/java/util/PropertyPermissionCollection.perms:Linstrumented/java/util/Map;
        //   438: aload           6
        //   440: ldc             4
        //   442: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   445: invokeinterface instrumented/java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //   450: checkcast       Linstrumented/java/util/PropertyPermission;
        //   453: astore_3       
        //   454: ldc             2
        //   456: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   459: aload           9
        //   461: pop            
        //   462: ldc             2
        //   464: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   467: ldc             1
        //   469: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   472: goto            493
        //   475: astore          10
        //   477: aload           9
        //   479: pop            
        //   480: ldc             503
        //   482: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   485: aload           10
        //   487: ldc             2
        //   489: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   492: athrow         
        //   493: aload_3        
        //   494: ldc             2
        //   496: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   499: ifnull          543
        //   502: iload           5
        //   504: aload_3        
        //   505: ldc             3
        //   507: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   510: invokevirtual   instrumented/java/util/PropertyPermission.getMask:()I
        //   513: ior            
        //   514: istore          5
        //   516: ldc             2
        //   518: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   521: iload           5
        //   523: iload           4
        //   525: iand           
        //   526: iload           4
        //   528: ldc             5
        //   530: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   533: if_icmpne       543
        //   536: iconst_1       
        //   537: ldc             2
        //   539: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   542: ireturn        
        //   543: iload           7
        //   545: iconst_1       
        //   546: isub           
        //   547: istore          8
        //   549: ldc             5
        //   551: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   554: goto            338
        //   557: iconst_0       
        //   558: ldc             2
        //   560: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   563: ireturn        
        //   564: athrow         
        //   565: athrow         
        //    StackMapTable: 00 0E 13 FF 00 60 00 07 07 00 02 07 00 74 07 00 3A 00 01 01 07 00 78 00 01 07 00 34 FF 00 11 00 06 07 00 02 07 00 74 07 00 3A 07 00 3A 01 01 00 00 FF 00 31 00 06 07 00 02 07 00 74 07 00 3A 00 01 01 00 00 FF 00 42 00 08 07 00 02 07 00 74 07 00 3A 00 01 01 07 00 76 07 00 78 00 01 07 00 34 FF 00 11 00 07 07 00 02 07 00 74 07 00 3A 07 00 3A 01 01 07 00 76 00 00 31 FD 00 12 00 01 FF 00 88 00 0A 07 00 02 07 00 74 07 00 3A 07 00 3A 01 01 07 00 76 01 01 07 00 78 00 01 07 00 34 FA 00 11 31 0D FF 00 06 00 00 00 01 07 00 34 FF 00 00 00 00 00 01 07 00 38
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  75     565    565    566    Ljava/lang/VirtualMachineError;
        //  75     108    116    134    Any
        //  116    126    116    134    Any
        //  210    243    251    269    Any
        //  251    261    251    269    Any
        //  434    467    475    493    Any
        //  475    485    475    493    Any
        //  0      564    564    565    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0134:
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
    
    public Enumeration<Permission> elements() {
        try {
            BytecodeManager.incBytecodes(4);
            try {
                final PropertyPermissionCollection collection = this;
                final Map<String, PropertyPermission> map = collection.perms;
                final int n = 3;
                BytecodeManager.incBytecodes(n);
                final Collection<PropertyPermission> collection2 = map.values();
                final int n2 = 1;
                BytecodeManager.incBytecodes(n2);
                final Enumeration<Permission> enumeration = Collections.enumeration((Collection<Permission>)collection2);
                final int n3 = 2;
                BytecodeManager.incBytecodes(n3);
                final int n4 = 1;
                BytecodeManager.incBytecodes(n4);
                return enumeration;
            }
            finally {
                BytecodeManager.incBytecodes(503);
                BytecodeManager.incBytecodes(2);
            }
        }
        finally {}
        try {
            final PropertyPermissionCollection collection = this;
            final Map<String, PropertyPermission> map = collection.perms;
            final int n = 3;
            BytecodeManager.incBytecodes(n);
            final Collection<PropertyPermission> collection2 = map.values();
            final int n2 = 1;
            BytecodeManager.incBytecodes(n2);
            final Enumeration<Permission> enumeration = Collections.enumeration((Collection<Permission>)collection2);
            final int n3 = 2;
            BytecodeManager.incBytecodes(n3);
            final int n4 = 1;
            BytecodeManager.incBytecodes(n4);
            return enumeration;
        }
        catch (VirtualMachineError virtualMachineError) {
            throw virtualMachineError;
        }
    }
    
    private void writeObject(final ObjectOutputStream p0) throws IOException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: aload_0        
        //     5: getfield        instrumented/java/util/PropertyPermissionCollection.perms:Linstrumented/java/util/Map;
        //     8: ldc             4
        //    10: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    13: ldc             1
        //    15: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    18: invokeinterface instrumented/java/util/Map.size:()I
        //    23: iconst_2       
        //    24: imul           
        //    25: ldc             3
        //    27: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    30: invokespecial   instrumented/java/util/Hashtable.<init>:(I)V
        //    33: astore_2       
        //    34: ldc             1
        //    36: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    39: aload_0        
        //    40: dup            
        //    41: astore_3       
        //    42: pop            
        //    43: ldc             4
        //    45: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    48: aload_2        
        //    49: aload_0        
        //    50: getfield        instrumented/java/util/PropertyPermissionCollection.perms:Linstrumented/java/util/Map;
        //    53: ldc             4
        //    55: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    58: invokevirtual   instrumented/java/util/Hashtable.putAll:(Linstrumented/java/util/Map;)V
        //    61: aload_3        
        //    62: pop            
        //    63: ldc             2
        //    65: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    68: ldc             1
        //    70: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    73: goto            93
        //    76: astore          4
        //    78: aload_3        
        //    79: pop            
        //    80: ldc             503
        //    82: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    85: aload           4
        //    87: ldc             2
        //    89: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    92: athrow         
        //    93: aload_1        
        //    94: ldc             2
        //    96: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    99: invokevirtual   java/io/ObjectOutputStream.putFields:()Ljava/io/ObjectOutputStream$PutField;
        //   102: astore_3       
        //   103: ldc             1
        //   105: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   108: aload_3        
        //   109: ldc             "all_allowed"
        //   111: aload_0        
        //   112: getfield        instrumented/java/util/PropertyPermissionCollection.all_allowed:Z
        //   115: ldc             5
        //   117: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   120: invokevirtual   java/io/ObjectOutputStream$PutField.put:(Ljava/lang/String;Z)V
        //   123: aload_3        
        //   124: ldc             "permissions"
        //   126: aload_2        
        //   127: ldc             4
        //   129: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   132: invokevirtual   java/io/ObjectOutputStream$PutField.put:(Ljava/lang/String;Ljava/lang/Object;)V
        //   135: aload_1        
        //   136: ldc             2
        //   138: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   141: invokevirtual   java/io/ObjectOutputStream.writeFields:()V
        //   144: ldc             1
        //   146: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   149: return         
        //   150: athrow         
        //   151: athrow         
        //    Exceptions:
        //  throws java.io.IOException
        //    StackMapTable: 00 04 FF 00 4C 00 04 07 00 02 07 00 10 07 00 A1 07 00 78 00 01 07 00 34 FA 00 10 FF 00 38 00 00 00 01 07 00 34 FF 00 00 00 00 00 01 07 00 38
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  48     151    151    152    Ljava/lang/VirtualMachineError;
        //  48     68     76     93     Any
        //  76     85     76     93     Any
        //  0      150    150    151    Any
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
    
    private void readObject(final ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            BytecodeManager.incBytecodes(2);
            final ObjectInputStream.GetField fields = objectInputStream.readFields();
            BytecodeManager.incBytecodes(1);
            final ObjectInputStream.GetField getField = fields;
            final String s = "all_allowed";
            final boolean b = false;
            BytecodeManager.incBytecodes(5);
            this.all_allowed = getField.get(s, b);
            BytecodeManager.incBytecodes(1);
            final ObjectInputStream.GetField getField2 = fields;
            final String s2 = "permissions";
            final Object o = null;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
            final Hashtable hashtable = (Hashtable)getField2.get(s2, o);
            BytecodeManager.incBytecodes(2);
            final Hashtable hashtable2 = hashtable;
            BytecodeManager.incBytecodes(5);
            final int n = hashtable2.size() * 2;
            BytecodeManager.incBytecodes(3);
            this.perms = new HashMap<String, PropertyPermission>(n);
            BytecodeManager.incBytecodes(1);
            final Map<String, PropertyPermission> perms = this.perms;
            final Hashtable hashtable3 = hashtable;
            BytecodeManager.incBytecodes(4);
            perms.putAll(hashtable3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static {
        try {
            final ObjectStreamField[] serialPersistentFields2 = new ObjectStreamField[2];
            final int n = 0;
            final String name = "permissions";
            final Class<Hashtable> type = Hashtable.class;
            BytecodeManager.incBytecodes(8);
            serialPersistentFields2[n] = new ObjectStreamField(name, type);
            final int n2 = 1;
            final String name2 = "all_allowed";
            final Class<Boolean> type2 = Boolean.TYPE;
            BytecodeManager.incBytecodes(8);
            serialPersistentFields2[n2] = new ObjectStreamField(name2, type2);
            serialPersistentFields = serialPersistentFields2;
            BytecodeManager.incBytecodes(3);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
