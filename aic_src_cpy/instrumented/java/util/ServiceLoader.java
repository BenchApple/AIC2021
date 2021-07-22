// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import java.security.PrivilegedAction;
import java.io.IOException;
import java.io.BufferedReader;
import java.net.URL;
import java.security.AccessController;
import java.util.Iterator;
import aic2021.engine.BytecodeManager;
import java.security.AccessControlContext;

public final class ServiceLoader<S> implements Iterable<S>
{
    private static final String PREFIX = "META-INF/services/";
    private final Class<S> service;
    private final ClassLoader loader;
    private final AccessControlContext acc;
    private LinkedHashMap<String, S> providers;
    private LazyIterator lookupIterator;
    
    public void reload() {
        try {
            final LinkedHashMap<String, S> providers = this.providers;
            BytecodeManager.incBytecodes(3);
            providers.clear();
            final Class<S> service = this.service;
            final ClassLoader loader = this.loader;
            final Iterator<S> iterator = null;
            BytecodeManager.incBytecodes(10);
            this.lookupIterator = new LazyIterator((Class)service, loader);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private ServiceLoader(final Class<S> clazz, final ClassLoader classLoader) {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(4);
            this.providers = new LinkedHashMap<String, S>();
            BytecodeManager.incBytecodes(1);
            final String s = "Service interface cannot be null";
            BytecodeManager.incBytecodes(4);
            this.service = Objects.requireNonNull(clazz, s);
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(3);
            ClassLoader systemClassLoader;
            if (classLoader == null) {
                BytecodeManager.incBytecodes(1);
                systemClassLoader = ClassLoader.getSystemClassLoader();
                BytecodeManager.incBytecodes(1);
            }
            else {
                systemClassLoader = classLoader;
                BytecodeManager.incBytecodes(1);
            }
            this.loader = systemClassLoader;
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            final SecurityManager securityManager = System.getSecurityManager();
            BytecodeManager.incBytecodes(1);
            AccessControlContext context;
            if (securityManager != null) {
                BytecodeManager.incBytecodes(1);
                context = AccessController.getContext();
                BytecodeManager.incBytecodes(1);
            }
            else {
                context = null;
                BytecodeManager.incBytecodes(1);
            }
            this.acc = context;
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            this.reload();
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static void fail(final Class<?> clazz, final String str, final Throwable t) throws ServiceConfigurationError {
        try {
            BytecodeManager.incBytecodes(5);
            final StringBuilder sb = new StringBuilder();
            BytecodeManager.incBytecodes(2);
            final String name = clazz.getName();
            BytecodeManager.incBytecodes(1);
            final StringBuilder append = sb.append(name);
            final String str2 = ": ";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append2 = append.append(str2);
            BytecodeManager.incBytecodes(2);
            final StringBuilder append3 = append2.append(str);
            BytecodeManager.incBytecodes(1);
            final String string = append3.toString();
            BytecodeManager.incBytecodes(2);
            final ServiceConfigurationError serviceConfigurationError = new ServiceConfigurationError(string, t);
            BytecodeManager.incBytecodes(1);
            throw serviceConfigurationError;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static void fail(final Class<?> clazz, final String str) throws ServiceConfigurationError {
        try {
            BytecodeManager.incBytecodes(5);
            final StringBuilder sb = new StringBuilder();
            BytecodeManager.incBytecodes(2);
            final String name = clazz.getName();
            BytecodeManager.incBytecodes(1);
            final StringBuilder append = sb.append(name);
            final String str2 = ": ";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append2 = append.append(str2);
            BytecodeManager.incBytecodes(2);
            final StringBuilder append3 = append2.append(str);
            BytecodeManager.incBytecodes(1);
            final String string = append3.toString();
            BytecodeManager.incBytecodes(1);
            final ServiceConfigurationError serviceConfigurationError = new ServiceConfigurationError(string);
            BytecodeManager.incBytecodes(1);
            throw serviceConfigurationError;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static void fail(final Class<?> clazz, final URL obj, final int i, final String str) throws ServiceConfigurationError {
        try {
            BytecodeManager.incBytecodes(4);
            final StringBuilder sb = new StringBuilder();
            BytecodeManager.incBytecodes(2);
            final StringBuilder append = sb.append(obj);
            final String str2 = ":";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append2 = append.append(str2);
            BytecodeManager.incBytecodes(2);
            final StringBuilder append3 = append2.append(i);
            final String str3 = ": ";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append4 = append3.append(str3);
            BytecodeManager.incBytecodes(2);
            final StringBuilder append5 = append4.append(str);
            BytecodeManager.incBytecodes(1);
            final String string = append5.toString();
            BytecodeManager.incBytecodes(1);
            fail(clazz, string);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private int parseLine(final Class<?> clazz, final URL url, final BufferedReader bufferedReader, final int n, final List<String> list) throws IOException, ServiceConfigurationError {
        try {
            BytecodeManager.incBytecodes(2);
            String s = bufferedReader.readLine();
            BytecodeManager.incBytecodes(1);
            final String s2 = s;
            BytecodeManager.incBytecodes(2);
            if (s2 == null) {
                final int n2 = -1;
                BytecodeManager.incBytecodes(2);
                return n2;
            }
            final String s3 = s;
            final int ch = 35;
            BytecodeManager.incBytecodes(3);
            final int index = s3.indexOf(ch);
            BytecodeManager.incBytecodes(1);
            final int n3 = index;
            BytecodeManager.incBytecodes(2);
            if (n3 >= 0) {
                final String s4 = s;
                final int beginIndex = 0;
                final int endIndex = index;
                BytecodeManager.incBytecodes(4);
                s = s4.substring(beginIndex, endIndex);
                BytecodeManager.incBytecodes(1);
            }
            final String s5 = s;
            BytecodeManager.incBytecodes(2);
            final String trim = s5.trim();
            BytecodeManager.incBytecodes(1);
            final String s6 = trim;
            BytecodeManager.incBytecodes(2);
            final int length = s6.length();
            BytecodeManager.incBytecodes(1);
            final int n4 = length;
            BytecodeManager.incBytecodes(2);
            if (n4 != 0) {
                final String s7 = trim;
                final int ch2 = 32;
                BytecodeManager.incBytecodes(3);
                final int index2 = s7.indexOf(ch2);
                BytecodeManager.incBytecodes(1);
                Label_0180: {
                    if (index2 < 0) {
                        final String s8 = trim;
                        final int ch3 = 9;
                        BytecodeManager.incBytecodes(3);
                        final int index3 = s8.indexOf(ch3);
                        BytecodeManager.incBytecodes(1);
                        if (index3 < 0) {
                            break Label_0180;
                        }
                    }
                    final String s9 = "Illegal configuration-file syntax";
                    BytecodeManager.incBytecodes(5);
                    fail(clazz, url, n, s9);
                }
                final String s10 = trim;
                final int index4 = 0;
                BytecodeManager.incBytecodes(3);
                final int codePoint = s10.codePointAt(index4);
                BytecodeManager.incBytecodes(1);
                final int codePoint2 = codePoint;
                BytecodeManager.incBytecodes(2);
                final boolean javaIdentifierStart = Character.isJavaIdentifierStart(codePoint2);
                BytecodeManager.incBytecodes(1);
                if (!javaIdentifierStart) {
                    BytecodeManager.incBytecodes(6);
                    final StringBuilder sb = new StringBuilder();
                    final String str = "Illegal provider-class name: ";
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append = sb.append(str);
                    final String str2 = trim;
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append2 = append.append(str2);
                    BytecodeManager.incBytecodes(1);
                    final String string = append2.toString();
                    BytecodeManager.incBytecodes(1);
                    fail(clazz, url, n, string);
                }
                final int codePoint3 = codePoint;
                BytecodeManager.incBytecodes(2);
                int charCount = Character.charCount(codePoint3);
                BytecodeManager.incBytecodes(1);
                while (true) {
                    final int n5 = charCount;
                    final int n6 = length;
                    BytecodeManager.incBytecodes(3);
                    if (n5 >= n6) {
                        break;
                    }
                    final String s11 = trim;
                    final int index5 = charCount;
                    BytecodeManager.incBytecodes(3);
                    final int codePoint4 = s11.codePointAt(index5);
                    BytecodeManager.incBytecodes(1);
                    final int codePoint5 = codePoint4;
                    BytecodeManager.incBytecodes(2);
                    final boolean javaIdentifierPart = Character.isJavaIdentifierPart(codePoint5);
                    BytecodeManager.incBytecodes(1);
                    if (!javaIdentifierPart) {
                        final int n7 = codePoint4;
                        final int n8 = 46;
                        BytecodeManager.incBytecodes(3);
                        if (n7 != n8) {
                            BytecodeManager.incBytecodes(6);
                            final StringBuilder sb2 = new StringBuilder();
                            final String str3 = "Illegal provider-class name: ";
                            BytecodeManager.incBytecodes(2);
                            final StringBuilder append3 = sb2.append(str3);
                            final String str4 = trim;
                            BytecodeManager.incBytecodes(2);
                            final StringBuilder append4 = append3.append(str4);
                            BytecodeManager.incBytecodes(1);
                            final String string2 = append4.toString();
                            BytecodeManager.incBytecodes(1);
                            fail(clazz, url, n, string2);
                        }
                    }
                    final int n9 = charCount;
                    final int codePoint6 = codePoint4;
                    BytecodeManager.incBytecodes(3);
                    charCount = n9 + Character.charCount(codePoint6);
                    BytecodeManager.incBytecodes(3);
                }
                final LinkedHashMap<String, S> providers = this.providers;
                final String s12 = trim;
                BytecodeManager.incBytecodes(4);
                final boolean containsKey = providers.containsKey(s12);
                BytecodeManager.incBytecodes(1);
                if (!containsKey) {
                    final String s13 = trim;
                    BytecodeManager.incBytecodes(3);
                    final boolean contains = list.contains(s13);
                    BytecodeManager.incBytecodes(1);
                    if (!contains) {
                        final String s14 = trim;
                        BytecodeManager.incBytecodes(3);
                        list.add(s14);
                        BytecodeManager.incBytecodes(1);
                    }
                }
            }
            final int n10 = n + 1;
            BytecodeManager.incBytecodes(4);
            return n10;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private Iterator<String> parse(final Class<?> p0, final URL p1) throws ServiceConfigurationError {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore_3       
        //     2: ldc             2
        //     4: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     7: aconst_null    
        //     8: astore          4
        //    10: ldc             2
        //    12: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    15: new             Linstrumented/java/util/ArrayList;
        //    18: dup            
        //    19: ldc             3
        //    21: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    24: invokespecial   instrumented/java/util/ArrayList.<init>:()V
        //    27: astore          5
        //    29: ldc             1
        //    31: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    34: aload_2        
        //    35: ldc             2
        //    37: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    40: invokevirtual   java/net/URL.openStream:()Ljava/io/InputStream;
        //    43: astore_3       
        //    44: ldc             1
        //    46: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    49: new             Ljava/io/BufferedReader;
        //    52: dup            
        //    53: new             Ljava/io/InputStreamReader;
        //    56: dup            
        //    57: aload_3        
        //    58: ldc             "utf-8"
        //    60: ldc             7
        //    62: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    65: invokespecial   java/io/InputStreamReader.<init>:(Ljava/io/InputStream;Ljava/lang/String;)V
        //    68: ldc             1
        //    70: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    73: invokespecial   java/io/BufferedReader.<init>:(Ljava/io/Reader;)V
        //    76: astore          4
        //    78: ldc             1
        //    80: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    83: iconst_1       
        //    84: istore          6
        //    86: ldc             2
        //    88: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    91: aload_0        
        //    92: aload_1        
        //    93: aload_2        
        //    94: aload           4
        //    96: iload           6
        //    98: aload           5
        //   100: ldc             7
        //   102: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   105: invokespecial   instrumented/java/util/ServiceLoader.parseLine:(Ljava/lang/Class;Ljava/net/URL;Ljava/io/BufferedReader;ILinstrumented/java/util/List;)I
        //   108: dup            
        //   109: istore          6
        //   111: ldc             3
        //   113: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   116: iflt            127
        //   119: ldc             1
        //   121: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   124: goto            91
        //   127: aload           4
        //   129: ldc             2
        //   131: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   134: ifnull          147
        //   137: aload           4
        //   139: ldc             2
        //   141: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   144: invokevirtual   java/io/BufferedReader.close:()V
        //   147: aload_3        
        //   148: ldc             2
        //   150: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   153: ifnull          165
        //   156: aload_3        
        //   157: ldc             2
        //   159: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   162: invokevirtual   java/io/InputStream.close:()V
        //   165: ldc             1
        //   167: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   170: goto            376
        //   173: astore          6
        //   175: ldc             501
        //   177: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   180: aload_1        
        //   181: ldc             "Error closing configuration file"
        //   183: aload           6
        //   185: ldc             4
        //   187: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   190: invokestatic    instrumented/java/util/ServiceLoader.fail:(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   193: ldc             1
        //   195: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   198: goto            376
        //   201: astore          6
        //   203: ldc             501
        //   205: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   208: aload_1        
        //   209: ldc             "Error reading configuration file"
        //   211: aload           6
        //   213: ldc             4
        //   215: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   218: invokestatic    instrumented/java/util/ServiceLoader.fail:(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   221: aload           4
        //   223: ldc             2
        //   225: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   228: ifnull          241
        //   231: aload           4
        //   233: ldc             2
        //   235: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   238: invokevirtual   java/io/BufferedReader.close:()V
        //   241: aload_3        
        //   242: ldc             2
        //   244: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   247: ifnull          259
        //   250: aload_3        
        //   251: ldc             2
        //   253: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   256: invokevirtual   java/io/InputStream.close:()V
        //   259: ldc             1
        //   261: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   264: goto            376
        //   267: astore          6
        //   269: ldc             501
        //   271: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   274: aload_1        
        //   275: ldc             "Error closing configuration file"
        //   277: aload           6
        //   279: ldc             4
        //   281: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   284: invokestatic    instrumented/java/util/ServiceLoader.fail:(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   287: ldc             1
        //   289: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   292: goto            376
        //   295: astore          7
        //   297: ldc             501
        //   299: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   302: aload           4
        //   304: ldc             2
        //   306: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   309: ifnull          322
        //   312: aload           4
        //   314: ldc             2
        //   316: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   319: invokevirtual   java/io/BufferedReader.close:()V
        //   322: aload_3        
        //   323: ldc             2
        //   325: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   328: ifnull          340
        //   331: aload_3        
        //   332: ldc             2
        //   334: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   337: invokevirtual   java/io/InputStream.close:()V
        //   340: ldc             1
        //   342: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   345: goto            368
        //   348: astore          8
        //   350: ldc             501
        //   352: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   355: aload_1        
        //   356: ldc             "Error closing configuration file"
        //   358: aload           8
        //   360: ldc             4
        //   362: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   365: invokestatic    instrumented/java/util/ServiceLoader.fail:(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   368: aload           7
        //   370: ldc             2
        //   372: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   375: athrow         
        //   376: aload           5
        //   378: ldc             2
        //   380: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   383: invokevirtual   instrumented/java/util/ArrayList.iterator:()Ljava/util/Iterator;
        //   386: ldc             1
        //   388: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   391: areturn        
        //   392: athrow         
        //   393: athrow         
        //    Exceptions:
        //  throws instrumented.java.util.ServiceConfigurationError
        //    Signature:
        //  (Ljava/lang/Class<*>;Ljava/net/URL;)Ljava/util/Iterator<Ljava/lang/String;>;
        //    StackMapTable: 00 11 FF 00 5B 00 07 07 00 02 07 00 4C 07 00 D0 07 00 E1 07 00 91 07 00 CD 01 00 00 FA 00 23 13 11 47 07 00 8F 5B 07 00 8F 27 11 47 07 00 8F 5B 07 00 3C FD 00 1A 00 07 00 3C 11 47 07 00 8F 13 F9 00 07 FF 00 0F 00 00 00 01 07 00 3C FF 00 00 00 00 00 01 07 00 CB
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  34     393    393    394    Ljava/lang/VirtualMachineError;
        //  127    165    173    201    Ljava/io/IOException;
        //  34     127    201    295    Ljava/io/IOException;
        //  221    259    267    295    Ljava/io/IOException;
        //  34     127    295    376    Any
        //  201    221    295    376    Any
        //  302    340    348    368    Ljava/io/IOException;
        //  295    302    295    376    Any
        //  0      392    392    393    Any
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
    
    @Override
    public Iterator<S> iterator() {
        try {
            BytecodeManager.incBytecodes(4);
            final Iterator<S> iterator = new Iterator<S>() {
                Iterator<Map.Entry<String, S>> knownProviders;
                
                {
                    final ServiceLoader this$2 = ServiceLoader.this;
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(1);
                    final LinkedHashMap access$400 = ServiceLoader.access$400(this$2);
                    BytecodeManager.incBytecodes(1);
                    final Set<Map.Entry<String, S>> entrySet = access$400.entrySet();
                    BytecodeManager.incBytecodes(1);
                    this.knownProviders = entrySet.iterator();
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                }
                
                @Override
                public boolean hasNext() {
                    try {
                        final Iterator<Map.Entry<String, S>> knownProviders = this.knownProviders;
                        BytecodeManager.incBytecodes(3);
                        final boolean hasNext = knownProviders.hasNext();
                        BytecodeManager.incBytecodes(1);
                        if (hasNext) {
                            final boolean b = true;
                            BytecodeManager.incBytecodes(2);
                            return b;
                        }
                        final ServiceLoader this$0 = ServiceLoader.this;
                        BytecodeManager.incBytecodes(3);
                        final LazyIterator access$800 = ServiceLoader.access$800(this$0);
                        BytecodeManager.incBytecodes(1);
                        final boolean hasNext2 = access$800.hasNext();
                        BytecodeManager.incBytecodes(1);
                        return hasNext2;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public S next() {
                    try {
                        final Iterator<Map.Entry<String, S>> knownProviders = this.knownProviders;
                        BytecodeManager.incBytecodes(3);
                        final boolean hasNext = knownProviders.hasNext();
                        BytecodeManager.incBytecodes(1);
                        if (hasNext) {
                            final Iterator<Map.Entry<String, S>> knownProviders2 = this.knownProviders;
                            BytecodeManager.incBytecodes(3);
                            final Map.Entry<String, S> entry = knownProviders2.next();
                            BytecodeManager.incBytecodes(2);
                            final S value = entry.getValue();
                            BytecodeManager.incBytecodes(1);
                            return value;
                        }
                        final ServiceLoader this$0 = ServiceLoader.this;
                        BytecodeManager.incBytecodes(3);
                        final LazyIterator access$800 = ServiceLoader.access$800(this$0);
                        BytecodeManager.incBytecodes(1);
                        final S next = access$800.next();
                        BytecodeManager.incBytecodes(1);
                        return next;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public void remove() {
                    try {
                        BytecodeManager.incBytecodes(3);
                        final UnsupportedOperationException ex = new UnsupportedOperationException();
                        BytecodeManager.incBytecodes(1);
                        throw ex;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
            };
            BytecodeManager.incBytecodes(1);
            return iterator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <S> ServiceLoader<S> load(final Class<S> clazz, final ClassLoader classLoader) {
        try {
            BytecodeManager.incBytecodes(5);
            final ServiceLoader<S> serviceLoader = new ServiceLoader<S>(clazz, classLoader);
            BytecodeManager.incBytecodes(1);
            return serviceLoader;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <S> ServiceLoader<S> load(final Class<S> clazz) {
        try {
            BytecodeManager.incBytecodes(1);
            final Thread currentThread = Thread.currentThread();
            BytecodeManager.incBytecodes(1);
            final ClassLoader contextClassLoader = currentThread.getContextClassLoader();
            BytecodeManager.incBytecodes(1);
            final ClassLoader classLoader = contextClassLoader;
            BytecodeManager.incBytecodes(3);
            final ServiceLoader<S> load = load(clazz, classLoader);
            BytecodeManager.incBytecodes(1);
            return load;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <S> ServiceLoader<S> loadInstalled(final Class<S> clazz) {
        try {
            BytecodeManager.incBytecodes(1);
            ClassLoader classLoader = ClassLoader.getSystemClassLoader();
            BytecodeManager.incBytecodes(1);
            ClassLoader classLoader2 = null;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final ClassLoader classLoader3 = classLoader;
                BytecodeManager.incBytecodes(2);
                if (classLoader3 == null) {
                    break;
                }
                classLoader2 = classLoader;
                BytecodeManager.incBytecodes(2);
                final ClassLoader classLoader4 = classLoader;
                BytecodeManager.incBytecodes(2);
                classLoader = classLoader4.getParent();
                BytecodeManager.incBytecodes(2);
            }
            final ClassLoader classLoader5 = classLoader2;
            BytecodeManager.incBytecodes(3);
            final ServiceLoader<S> load = load(clazz, classLoader5);
            BytecodeManager.incBytecodes(1);
            return load;
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
            final String str = "java.util.ServiceLoader[";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append = sb.append(str);
            final Class<S> service = this.service;
            BytecodeManager.incBytecodes(3);
            final String name = service.getName();
            BytecodeManager.incBytecodes(1);
            final StringBuilder append2 = append.append(name);
            final String str2 = "]";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append3 = append2.append(str2);
            BytecodeManager.incBytecodes(1);
            final String string = append3.toString();
            BytecodeManager.incBytecodes(1);
            return string;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static /* synthetic */ LinkedHashMap access$400(final ServiceLoader serviceLoader) {
        try {
            final LinkedHashMap<String, S> providers = serviceLoader.providers;
            BytecodeManager.incBytecodes(3);
            return providers;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static /* synthetic */ AccessControlContext access$500(final ServiceLoader serviceLoader) {
        try {
            final AccessControlContext acc = serviceLoader.acc;
            BytecodeManager.incBytecodes(3);
            return acc;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static /* synthetic */ LazyIterator access$800(final ServiceLoader serviceLoader) {
        try {
            final LazyIterator lookupIterator = serviceLoader.lookupIterator;
            BytecodeManager.incBytecodes(3);
            return lookupIterator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private class LazyIterator implements Iterator<S>
    {
        Class<S> service;
        ClassLoader loader;
        Enumeration<URL> configs;
        Iterator<String> pending;
        String nextName;
        
        private LazyIterator(final Class<S> service, final ClassLoader loader) {
            try {
                BytecodeManager.incBytecodes(5);
                this.configs = null;
                BytecodeManager.incBytecodes(3);
                this.pending = null;
                BytecodeManager.incBytecodes(3);
                this.nextName = null;
                BytecodeManager.incBytecodes(3);
                this.service = service;
                BytecodeManager.incBytecodes(3);
                this.loader = loader;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private boolean hasNextService() {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: getfield        instrumented/java/util/ServiceLoader$LazyIterator.nextName:Ljava/lang/String;
            //     4: ldc             3
            //     6: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //     9: ifnull          19
            //    12: iconst_1       
            //    13: ldc             2
            //    15: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    18: ireturn        
            //    19: aload_0        
            //    20: getfield        instrumented/java/util/ServiceLoader$LazyIterator.configs:Linstrumented/java/util/Enumeration;
            //    23: ldc             3
            //    25: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    28: ifnonnull       171
            //    31: new             Ljava/lang/StringBuilder;
            //    34: dup            
            //    35: ldc             3
            //    37: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    40: invokespecial   java/lang/StringBuilder.<init>:()V
            //    43: ldc             "META-INF/services/"
            //    45: ldc             2
            //    47: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    50: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //    53: aload_0        
            //    54: getfield        instrumented/java/util/ServiceLoader$LazyIterator.service:Ljava/lang/Class;
            //    57: ldc             3
            //    59: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    62: invokevirtual   java/lang/Class.getName:()Ljava/lang/String;
            //    65: ldc             1
            //    67: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    70: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //    73: ldc             1
            //    75: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    78: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
            //    81: astore_1       
            //    82: ldc             1
            //    84: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    87: aload_0        
            //    88: getfield        instrumented/java/util/ServiceLoader$LazyIterator.loader:Ljava/lang/ClassLoader;
            //    91: ldc             3
            //    93: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    96: ifnonnull       120
            //    99: aload_0        
            //   100: aload_1        
            //   101: ldc             3
            //   103: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   106: invokestatic    java/lang/ClassLoader.getSystemResources:(Ljava/lang/String;)Linstrumented/java/util/Enumeration;
            //   109: putfield        instrumented/java/util/ServiceLoader$LazyIterator.configs:Linstrumented/java/util/Enumeration;
            //   112: ldc             2
            //   114: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   117: goto            142
            //   120: aload_0        
            //   121: aload_0        
            //   122: getfield        instrumented/java/util/ServiceLoader$LazyIterator.loader:Ljava/lang/ClassLoader;
            //   125: aload_1        
            //   126: ldc             5
            //   128: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   131: invokevirtual   java/lang/ClassLoader.getResources:(Ljava/lang/String;)Linstrumented/java/util/Enumeration;
            //   134: putfield        instrumented/java/util/ServiceLoader$LazyIterator.configs:Linstrumented/java/util/Enumeration;
            //   137: ldc             1
            //   139: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   142: ldc             1
            //   144: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   147: goto            171
            //   150: astore_1       
            //   151: ldc             501
            //   153: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   156: aload_0        
            //   157: getfield        instrumented/java/util/ServiceLoader$LazyIterator.service:Ljava/lang/Class;
            //   160: ldc             "Error locating configuration files"
            //   162: aload_1        
            //   163: ldc             5
            //   165: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   168: invokestatic    instrumented/java/util/ServiceLoader.access$100:(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Throwable;)V
            //   171: aload_0        
            //   172: getfield        instrumented/java/util/ServiceLoader$LazyIterator.pending:Ljava/util/Iterator;
            //   175: ldc             3
            //   177: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   180: ifnull          205
            //   183: aload_0        
            //   184: getfield        instrumented/java/util/ServiceLoader$LazyIterator.pending:Ljava/util/Iterator;
            //   187: ldc             3
            //   189: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   192: invokeinterface java/util/Iterator.hasNext:()Z
            //   197: ldc             1
            //   199: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   202: ifne            279
            //   205: aload_0        
            //   206: getfield        instrumented/java/util/ServiceLoader$LazyIterator.configs:Linstrumented/java/util/Enumeration;
            //   209: ldc             3
            //   211: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   214: invokeinterface instrumented/java/util/Enumeration.hasMoreElements:()Z
            //   219: ldc             1
            //   221: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   224: ifne            234
            //   227: iconst_0       
            //   228: ldc             2
            //   230: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   233: ireturn        
            //   234: aload_0        
            //   235: aload_0        
            //   236: getfield        instrumented/java/util/ServiceLoader$LazyIterator.this$0:Linstrumented/java/util/ServiceLoader;
            //   239: aload_0        
            //   240: getfield        instrumented/java/util/ServiceLoader$LazyIterator.service:Ljava/lang/Class;
            //   243: aload_0        
            //   244: getfield        instrumented/java/util/ServiceLoader$LazyIterator.configs:Linstrumented/java/util/Enumeration;
            //   247: ldc             8
            //   249: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   252: invokeinterface instrumented/java/util/Enumeration.nextElement:()Ljava/lang/Object;
            //   257: checkcast       Ljava/net/URL;
            //   260: ldc             2
            //   262: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   265: invokestatic    instrumented/java/util/ServiceLoader.access$200:(Linstrumented/java/util/ServiceLoader;Ljava/lang/Class;Ljava/net/URL;)Ljava/util/Iterator;
            //   268: putfield        instrumented/java/util/ServiceLoader$LazyIterator.pending:Ljava/util/Iterator;
            //   271: ldc             2
            //   273: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   276: goto            171
            //   279: aload_0        
            //   280: aload_0        
            //   281: getfield        instrumented/java/util/ServiceLoader$LazyIterator.pending:Ljava/util/Iterator;
            //   284: ldc             4
            //   286: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   289: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
            //   294: checkcast       Ljava/lang/String;
            //   297: putfield        instrumented/java/util/ServiceLoader$LazyIterator.nextName:Ljava/lang/String;
            //   300: ldc             2
            //   302: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   305: iconst_1       
            //   306: ldc             2
            //   308: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   311: ireturn        
            //   312: athrow         
            //   313: athrow         
            //    StackMapTable: 00 0A 13 FC 00 64 07 00 5D FA 00 15 47 07 00 42 14 21 1C 2C FF 00 20 00 00 00 01 07 00 3C FF 00 00 00 00 00 01 07 00 40
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                           
            //  -----  -----  -----  -----  -------------------------------
            //  31     313    313    314    Ljava/lang/VirtualMachineError;
            //  31     142    150    171    Ljava/io/IOException;
            //  0      312    312    313    Any
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0120:
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
        
        private S nextService() {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: ldc             2
            //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //     6: invokespecial   instrumented/java/util/ServiceLoader$LazyIterator.hasNextService:()Z
            //     9: ldc             1
            //    11: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    14: ifne            35
            //    17: new             Linstrumented/java/util/NoSuchElementException;
            //    20: dup            
            //    21: ldc             3
            //    23: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    26: invokespecial   instrumented/java/util/NoSuchElementException.<init>:()V
            //    29: ldc             1
            //    31: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    34: athrow         
            //    35: aload_0        
            //    36: getfield        instrumented/java/util/ServiceLoader$LazyIterator.nextName:Ljava/lang/String;
            //    39: astore_1       
            //    40: ldc             3
            //    42: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    45: aload_0        
            //    46: aconst_null    
            //    47: putfield        instrumented/java/util/ServiceLoader$LazyIterator.nextName:Ljava/lang/String;
            //    50: ldc             3
            //    52: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    55: aconst_null    
            //    56: astore_2       
            //    57: ldc             2
            //    59: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    62: aload_1        
            //    63: iconst_0       
            //    64: aload_0        
            //    65: getfield        instrumented/java/util/ServiceLoader$LazyIterator.loader:Ljava/lang/ClassLoader;
            //    68: ldc             5
            //    70: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    73: invokestatic    java/lang/Class.forName:(Ljava/lang/String;ZLjava/lang/ClassLoader;)Ljava/lang/Class;
            //    76: astore_2       
            //    77: ldc             1
            //    79: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    82: ldc             1
            //    84: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    87: goto            157
            //    90: astore_3       
            //    91: ldc             501
            //    93: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    96: aload_0        
            //    97: getfield        instrumented/java/util/ServiceLoader$LazyIterator.service:Ljava/lang/Class;
            //   100: new             Ljava/lang/StringBuilder;
            //   103: dup            
            //   104: ldc             5
            //   106: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   109: invokespecial   java/lang/StringBuilder.<init>:()V
            //   112: ldc             "Provider "
            //   114: ldc             2
            //   116: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   119: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   122: aload_1        
            //   123: ldc             2
            //   125: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   128: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   131: ldc             " not found"
            //   133: ldc             2
            //   135: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   138: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   141: ldc             1
            //   143: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   146: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
            //   149: ldc             1
            //   151: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   154: invokestatic    instrumented/java/util/ServiceLoader.access$300:(Ljava/lang/Class;Ljava/lang/String;)V
            //   157: aload_0        
            //   158: getfield        instrumented/java/util/ServiceLoader$LazyIterator.service:Ljava/lang/Class;
            //   161: aload_2        
            //   162: ldc             4
            //   164: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   167: invokevirtual   java/lang/Class.isAssignableFrom:(Ljava/lang/Class;)Z
            //   170: ldc             1
            //   172: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   175: ifne            239
            //   178: aload_0        
            //   179: getfield        instrumented/java/util/ServiceLoader$LazyIterator.service:Ljava/lang/Class;
            //   182: new             Ljava/lang/StringBuilder;
            //   185: dup            
            //   186: ldc             5
            //   188: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   191: invokespecial   java/lang/StringBuilder.<init>:()V
            //   194: ldc             "Provider "
            //   196: ldc             2
            //   198: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   201: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   204: aload_1        
            //   205: ldc             2
            //   207: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   210: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   213: ldc             " not a subtype"
            //   215: ldc             2
            //   217: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   220: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   223: ldc             1
            //   225: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   228: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
            //   231: ldc             1
            //   233: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   236: invokestatic    instrumented/java/util/ServiceLoader.access$300:(Ljava/lang/Class;Ljava/lang/String;)V
            //   239: aload_0        
            //   240: getfield        instrumented/java/util/ServiceLoader$LazyIterator.service:Ljava/lang/Class;
            //   243: aload_2        
            //   244: ldc             4
            //   246: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   249: invokevirtual   java/lang/Class.newInstance:()Ljava/lang/Object;
            //   252: ldc             1
            //   254: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   257: invokevirtual   java/lang/Class.cast:(Ljava/lang/Object;)Ljava/lang/Object;
            //   260: astore_3       
            //   261: ldc             1
            //   263: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   266: aload_0        
            //   267: getfield        instrumented/java/util/ServiceLoader$LazyIterator.this$0:Linstrumented/java/util/ServiceLoader;
            //   270: ldc             3
            //   272: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   275: invokestatic    instrumented/java/util/ServiceLoader.access$400:(Linstrumented/java/util/ServiceLoader;)Linstrumented/java/util/LinkedHashMap;
            //   278: aload_1        
            //   279: aload_3        
            //   280: ldc             3
            //   282: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   285: invokevirtual   instrumented/java/util/LinkedHashMap.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
            //   288: pop            
            //   289: ldc             1
            //   291: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   294: aload_3        
            //   295: ldc             1
            //   297: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   300: ldc             1
            //   302: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   305: areturn        
            //   306: astore_3       
            //   307: ldc             501
            //   309: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   312: aload_0        
            //   313: getfield        instrumented/java/util/ServiceLoader$LazyIterator.service:Ljava/lang/Class;
            //   316: new             Ljava/lang/StringBuilder;
            //   319: dup            
            //   320: ldc             5
            //   322: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   325: invokespecial   java/lang/StringBuilder.<init>:()V
            //   328: ldc             "Provider "
            //   330: ldc             2
            //   332: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   335: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   338: aload_1        
            //   339: ldc             2
            //   341: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   344: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   347: ldc             " could not be instantiated"
            //   349: ldc             2
            //   351: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   354: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   357: ldc             1
            //   359: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   362: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
            //   365: aload_3        
            //   366: ldc             2
            //   368: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   371: invokestatic    instrumented/java/util/ServiceLoader.access$100:(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Throwable;)V
            //   374: new             Ljava/lang/Error;
            //   377: dup            
            //   378: ldc             3
            //   380: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   383: invokespecial   java/lang/Error.<init>:()V
            //   386: ldc             1
            //   388: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   391: athrow         
            //   392: athrow         
            //   393: athrow         
            //    Signature:
            //  ()TS;
            //    StackMapTable: 00 07 23 FF 00 36 00 03 07 00 02 07 00 5D 07 00 4E 00 01 07 00 81 FB 00 42 FB 00 51 F7 00 42 07 00 3C FF 00 55 00 00 00 01 07 00 3C FF 00 00 00 00 00 01 07 00 40
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                              
            //  -----  -----  -----  -----  ----------------------------------
            //  62     393    393    394    Ljava/lang/VirtualMachineError;
            //  62     82     90     157    Ljava/lang/ClassNotFoundException;
            //  239    300    306    392    Ljava/lang/Throwable;
            //  0      392    392    393    Any
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0157:
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
        
        @Override
        public boolean hasNext() {
            try {
                final ServiceLoader this$0 = ServiceLoader.this;
                BytecodeManager.incBytecodes(3);
                final AccessControlContext access$500 = ServiceLoader.access$500(this$0);
                BytecodeManager.incBytecodes(1);
                if (access$500 == null) {
                    BytecodeManager.incBytecodes(2);
                    final boolean hasNextService = this.hasNextService();
                    BytecodeManager.incBytecodes(1);
                    return hasNextService;
                }
                BytecodeManager.incBytecodes(4);
                final PrivilegedAction<Boolean> privilegedAction = new PrivilegedAction<Boolean>() {
                    {
                        BytecodeManager.incBytecodes(1);
                    }
                    
                    @Override
                    public Boolean run() {
                        try {
                            final LazyIterator this$1 = LazyIterator.this;
                            BytecodeManager.incBytecodes(3);
                            final boolean access$600 = LazyIterator.access$600(this$1);
                            BytecodeManager.incBytecodes(1);
                            final Boolean value = access$600;
                            BytecodeManager.incBytecodes(1);
                            return value;
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                };
                BytecodeManager.incBytecodes(1);
                final PrivilegedAction<Boolean> action = privilegedAction;
                final ServiceLoader this$2 = ServiceLoader.this;
                BytecodeManager.incBytecodes(4);
                final AccessControlContext access$501 = ServiceLoader.access$500(this$2);
                BytecodeManager.incBytecodes(1);
                final Boolean b = AccessController.doPrivileged((PrivilegedAction<Boolean>)action, access$501);
                BytecodeManager.incBytecodes(2);
                final boolean booleanValue = b;
                BytecodeManager.incBytecodes(1);
                return booleanValue;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public S next() {
            try {
                final ServiceLoader this$0 = ServiceLoader.this;
                BytecodeManager.incBytecodes(3);
                final AccessControlContext access$500 = ServiceLoader.access$500(this$0);
                BytecodeManager.incBytecodes(1);
                if (access$500 == null) {
                    BytecodeManager.incBytecodes(2);
                    final S nextService = this.nextService();
                    BytecodeManager.incBytecodes(1);
                    return nextService;
                }
                BytecodeManager.incBytecodes(4);
                final PrivilegedAction<S> privilegedAction = new PrivilegedAction<S>() {
                    {
                        BytecodeManager.incBytecodes(1);
                    }
                    
                    @Override
                    public S run() {
                        try {
                            final LazyIterator this$1 = LazyIterator.this;
                            BytecodeManager.incBytecodes(3);
                            final Object access$700 = LazyIterator.access$700(this$1);
                            BytecodeManager.incBytecodes(1);
                            return (S)access$700;
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                };
                BytecodeManager.incBytecodes(1);
                final PrivilegedAction<S> action = privilegedAction;
                final ServiceLoader this$2 = ServiceLoader.this;
                BytecodeManager.incBytecodes(4);
                final AccessControlContext access$501 = ServiceLoader.access$500(this$2);
                BytecodeManager.incBytecodes(1);
                final S doPrivileged = AccessController.doPrivileged((PrivilegedAction<S>)action, access$501);
                BytecodeManager.incBytecodes(1);
                return doPrivileged;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void remove() {
            try {
                BytecodeManager.incBytecodes(3);
                final UnsupportedOperationException ex = new UnsupportedOperationException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static /* synthetic */ boolean access$600(final LazyIterator lazyIterator) {
            try {
                BytecodeManager.incBytecodes(2);
                final boolean hasNextService = lazyIterator.hasNextService();
                BytecodeManager.incBytecodes(1);
                return hasNextService;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static /* synthetic */ Object access$700(final LazyIterator lazyIterator) {
            try {
                BytecodeManager.incBytecodes(2);
                final Object nextService = lazyIterator.nextService();
                BytecodeManager.incBytecodes(1);
                return nextService;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
}
