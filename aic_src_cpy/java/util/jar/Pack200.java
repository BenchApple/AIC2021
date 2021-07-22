// 
// Decompiled by Procyon v0.5.36
// 

package java.util.jar;

import java.io.File;
import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.SortedMap;
import aic2021.engine.BytecodeManager;

public abstract class Pack200
{
    private static final String PACK_PROVIDER = "java.util.jar.Pack200.Packer";
    private static final String UNPACK_PROVIDER = "java.util.jar.Pack200.Unpacker";
    private static Class<?> packerImpl;
    private static Class<?> unpackerImpl;
    
    private Pack200() {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static synchronized Packer newPacker() {
        try {
            final String s = "java.util.jar.Pack200.Packer";
            BytecodeManager.incBytecodes(2);
            final Packer packer = (Packer)newInstance(s);
            BytecodeManager.incBytecodes(2);
            return packer;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static Unpacker newUnpacker() {
        try {
            final String s = "java.util.jar.Pack200.Unpacker";
            BytecodeManager.incBytecodes(2);
            final Unpacker unpacker = (Unpacker)newInstance(s);
            BytecodeManager.incBytecodes(2);
            return unpacker;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static synchronized Object newInstance(final String p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     2: astore_1       
        //     3: ldc             2
        //     5: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     8: ldc             "java.util.jar.Pack200.Packer"
        //    10: aload_0        
        //    11: ldc             3
        //    13: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    16: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //    19: ldc             1
        //    21: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    24: ifeq            38
        //    27: getstatic       java/util/jar/Pack200.packerImpl:Ljava/lang/Class;
        //    30: ldc             2
        //    32: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    35: goto            46
        //    38: getstatic       java/util/jar/Pack200.unpackerImpl:Ljava/lang/Class;
        //    41: ldc             1
        //    43: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    46: astore_2       
        //    47: ldc             1
        //    49: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    52: aload_2        
        //    53: ldc             2
        //    55: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    58: ifnonnull       177
        //    61: new             Lsun/security/action/GetPropertyAction;
        //    64: dup            
        //    65: aload_0        
        //    66: ldc             ""
        //    68: ldc             5
        //    70: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    73: invokespecial   sun/security/action/GetPropertyAction.<init>:(Ljava/lang/String;Ljava/lang/String;)V
        //    76: ldc             1
        //    78: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    81: invokestatic    java/security/AccessController.doPrivileged:(Ljava/security/PrivilegedAction;)Ljava/lang/Object;
        //    84: checkcast       Ljava/lang/String;
        //    87: astore_1       
        //    88: ldc             2
        //    90: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    93: aload_1        
        //    94: ldc             2
        //    96: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    99: ifnull          139
        //   102: aload_1        
        //   103: ldc             ""
        //   105: ldc             3
        //   107: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   110: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   113: ldc             1
        //   115: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   118: ifne            139
        //   121: aload_1        
        //   122: ldc             2
        //   124: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   127: invokestatic    java/lang/Class.forName:(Ljava/lang/String;)Ljava/lang/Class;
        //   130: astore_2       
        //   131: ldc             2
        //   133: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   136: goto            177
        //   139: ldc             "java.util.jar.Pack200.Packer"
        //   141: aload_0        
        //   142: ldc             3
        //   144: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   147: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   150: ldc             1
        //   152: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   155: ifeq            169
        //   158: ldc             Lcom/sun/java/util/jar/pack/PackerImpl;.class
        //   160: astore_2       
        //   161: ldc             3
        //   163: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   166: goto            177
        //   169: ldc             Lcom/sun/java/util/jar/pack/UnpackerImpl;.class
        //   171: astore_2       
        //   172: ldc             2
        //   174: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   177: aload_2        
        //   178: ldc             2
        //   180: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   183: invokevirtual   java/lang/Class.newInstance:()Ljava/lang/Object;
        //   186: ldc             1
        //   188: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   191: areturn        
        //   192: astore_2       
        //   193: ldc             501
        //   195: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   198: new             Ljava/lang/Error;
        //   201: dup            
        //   202: new             Ljava/lang/StringBuilder;
        //   205: dup            
        //   206: ldc             5
        //   208: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   211: invokespecial   java/lang/StringBuilder.<init>:()V
        //   214: ldc             "Class not found: "
        //   216: ldc             2
        //   218: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   221: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   224: aload_1        
        //   225: ldc             2
        //   227: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   230: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   233: ldc             ":\ncheck property "
        //   235: ldc             2
        //   237: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   240: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   243: aload_0        
        //   244: ldc             2
        //   246: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   249: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   252: ldc             " in your properties file."
        //   254: ldc             2
        //   256: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   259: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   262: ldc             1
        //   264: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   267: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   270: aload_2        
        //   271: ldc             2
        //   273: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   276: invokespecial   java/lang/Error.<init>:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   279: ldc             1
        //   281: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   284: athrow         
        //   285: astore_2       
        //   286: ldc             501
        //   288: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   291: new             Ljava/lang/Error;
        //   294: dup            
        //   295: new             Ljava/lang/StringBuilder;
        //   298: dup            
        //   299: ldc             5
        //   301: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   304: invokespecial   java/lang/StringBuilder.<init>:()V
        //   307: ldc             "Could not instantiate: "
        //   309: ldc             2
        //   311: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   314: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   317: aload_1        
        //   318: ldc             2
        //   320: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   323: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   326: ldc             ":\ncheck property "
        //   328: ldc             2
        //   330: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   333: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   336: aload_0        
        //   337: ldc             2
        //   339: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   342: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   345: ldc             " in your properties file."
        //   347: ldc             2
        //   349: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   352: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   355: ldc             1
        //   357: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   360: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   363: aload_2        
        //   364: ldc             2
        //   366: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   369: invokespecial   java/lang/Error.<init>:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   372: ldc             1
        //   374: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   377: athrow         
        //   378: astore_2       
        //   379: ldc             501
        //   381: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   384: new             Ljava/lang/Error;
        //   387: dup            
        //   388: new             Ljava/lang/StringBuilder;
        //   391: dup            
        //   392: ldc             5
        //   394: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   397: invokespecial   java/lang/StringBuilder.<init>:()V
        //   400: ldc             "Cannot access class: "
        //   402: ldc             2
        //   404: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   407: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   410: aload_1        
        //   411: ldc             2
        //   413: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   416: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   419: ldc             ":\ncheck property "
        //   421: ldc             2
        //   423: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   426: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   429: aload_0        
        //   430: ldc             2
        //   432: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   435: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   438: ldc             " in your properties file."
        //   440: ldc             2
        //   442: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   445: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   448: ldc             1
        //   450: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   453: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   456: aload_2        
        //   457: ldc             2
        //   459: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   462: invokespecial   java/lang/Error.<init>:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   465: ldc             1
        //   467: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   470: athrow         
        //   471: athrow         
        //   472: athrow         
        //    StackMapTable: 00 0A FC 00 26 07 00 39 47 07 00 43 FC 00 5C 07 00 43 1D 07 FF 00 0E 00 02 07 00 39 07 00 39 00 01 07 00 30 F7 00 5C 07 00 32 F7 00 5C 07 00 34 FF 00 5C 00 00 00 01 07 00 24 FF 00 00 00 00 00 01 07 00 2E
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                              
        //  -----  -----  -----  -----  ----------------------------------
        //  8      472    472    473    Ljava/lang/VirtualMachineError;
        //  8      186    192    285    Ljava/lang/ClassNotFoundException;
        //  8      186    285    378    Ljava/lang/InstantiationException;
        //  8      186    378    471    Ljava/lang/IllegalAccessException;
        //  0      471    471    472    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0038:
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
    
    @Deprecated(since = "11", forRemoval = true)
    public interface Packer
    {
        public static final String SEGMENT_LIMIT = "pack.segment.limit";
        public static final String KEEP_FILE_ORDER = "pack.keep.file.order";
        public static final String EFFORT = "pack.effort";
        public static final String DEFLATE_HINT = "pack.deflate.hint";
        public static final String MODIFICATION_TIME = "pack.modification.time";
        public static final String PASS_FILE_PFX = "pack.pass.file.";
        public static final String UNKNOWN_ATTRIBUTE = "pack.unknown.attribute";
        public static final String CLASS_ATTRIBUTE_PFX = "pack.class.attribute.";
        public static final String FIELD_ATTRIBUTE_PFX = "pack.field.attribute.";
        public static final String METHOD_ATTRIBUTE_PFX = "pack.method.attribute.";
        public static final String CODE_ATTRIBUTE_PFX = "pack.code.attribute.";
        public static final String PROGRESS = "pack.progress";
        public static final String KEEP = "keep";
        public static final String PASS = "pass";
        public static final String STRIP = "strip";
        public static final String ERROR = "error";
        public static final String TRUE = "true";
        public static final String FALSE = "false";
        public static final String LATEST = "latest";
        
        SortedMap<String, String> properties();
        
        void pack(final JarFile p0, final OutputStream p1) throws IOException;
        
        void pack(final JarInputStream p0, final OutputStream p1) throws IOException;
    }
    
    @Deprecated(since = "11", forRemoval = true)
    public interface Unpacker
    {
        public static final String KEEP = "keep";
        public static final String TRUE = "true";
        public static final String FALSE = "false";
        public static final String DEFLATE_HINT = "unpack.deflate.hint";
        public static final String PROGRESS = "unpack.progress";
        
        SortedMap<String, String> properties();
        
        void unpack(final InputStream p0, final JarOutputStream p1) throws IOException;
        
        void unpack(final File p0, final JarOutputStream p1) throws IOException;
    }
}
