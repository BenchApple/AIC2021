// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.concurrent.atomic;

import sun.misc.Unsafe;
import instrumented.java.util.function.BinaryOperator;
import instrumented.java.util.function.UnaryOperator;
import sun.reflect.CallerSensitive;
import sun.reflect.Reflection;
import aic2021.engine.BytecodeManager;

public abstract class AtomicReferenceFieldUpdater<T, V>
{
    @CallerSensitive
    public static <U, W> AtomicReferenceFieldUpdater<U, W> newUpdater(final Class<U> clazz, final Class<W> clazz2, final String s) {
        try {
            BytecodeManager.incBytecodes(5);
            BytecodeManager.incBytecodes(1);
            final Class callerClass = Reflection.getCallerClass();
            BytecodeManager.incBytecodes(1);
            final AtomicReferenceFieldUpdaterImpl atomicReferenceFieldUpdaterImpl = new AtomicReferenceFieldUpdaterImpl<U, W>(clazz, clazz2, s, callerClass);
            BytecodeManager.incBytecodes(1);
            return (AtomicReferenceFieldUpdater<U, W>)atomicReferenceFieldUpdaterImpl;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    protected AtomicReferenceFieldUpdater() {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public abstract boolean compareAndSet(final T p0, final V p1, final V p2);
    
    public abstract boolean weakCompareAndSet(final T p0, final V p1, final V p2);
    
    public abstract void set(final T p0, final V p1);
    
    public abstract void lazySet(final T p0, final V p1);
    
    public abstract V get(final T p0);
    
    public V getAndSet(final T t, final V v) {
        try {
            boolean compareAndSet;
            V value;
            do {
                BytecodeManager.incBytecodes(3);
                value = this.get(t);
                BytecodeManager.incBytecodes(1);
                final V v2 = value;
                BytecodeManager.incBytecodes(5);
                compareAndSet = this.compareAndSet(t, v2, v);
                BytecodeManager.incBytecodes(1);
            } while (!compareAndSet);
            final V v3 = value;
            BytecodeManager.incBytecodes(2);
            return v3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final V getAndUpdate(final T t, final UnaryOperator<V> unaryOperator) {
        try {
            boolean compareAndSet;
            V value;
            do {
                BytecodeManager.incBytecodes(3);
                value = this.get(t);
                BytecodeManager.incBytecodes(1);
                final V v = value;
                BytecodeManager.incBytecodes(3);
                final Object apply = unaryOperator.apply(v);
                BytecodeManager.incBytecodes(1);
                final V v2 = value;
                final Object o = apply;
                BytecodeManager.incBytecodes(5);
                compareAndSet = this.compareAndSet(t, v2, (V)o);
                BytecodeManager.incBytecodes(1);
            } while (!compareAndSet);
            final V v3 = value;
            BytecodeManager.incBytecodes(2);
            return v3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final V updateAndGet(final T t, final UnaryOperator<V> unaryOperator) {
        try {
            boolean compareAndSet;
            Object apply;
            do {
                BytecodeManager.incBytecodes(3);
                final V value = this.get(t);
                BytecodeManager.incBytecodes(1);
                final V v = value;
                BytecodeManager.incBytecodes(3);
                apply = unaryOperator.apply(v);
                BytecodeManager.incBytecodes(1);
                final V v2 = value;
                final Object o = apply;
                BytecodeManager.incBytecodes(5);
                compareAndSet = this.compareAndSet(t, v2, (V)o);
                BytecodeManager.incBytecodes(1);
            } while (!compareAndSet);
            final Object o2 = apply;
            BytecodeManager.incBytecodes(2);
            return (V)o2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final V getAndAccumulate(final T t, final V v, final BinaryOperator<V> binaryOperator) {
        try {
            boolean compareAndSet;
            V value;
            do {
                BytecodeManager.incBytecodes(3);
                value = this.get(t);
                BytecodeManager.incBytecodes(1);
                final V v2 = value;
                BytecodeManager.incBytecodes(4);
                final Object apply = binaryOperator.apply(v2, v);
                BytecodeManager.incBytecodes(1);
                final V v3 = value;
                final Object o = apply;
                BytecodeManager.incBytecodes(5);
                compareAndSet = this.compareAndSet(t, v3, (V)o);
                BytecodeManager.incBytecodes(1);
            } while (!compareAndSet);
            final V v4 = value;
            BytecodeManager.incBytecodes(2);
            return v4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final V accumulateAndGet(final T t, final V v, final BinaryOperator<V> binaryOperator) {
        try {
            boolean compareAndSet;
            Object apply;
            do {
                BytecodeManager.incBytecodes(3);
                final V value = this.get(t);
                BytecodeManager.incBytecodes(1);
                final V v2 = value;
                BytecodeManager.incBytecodes(4);
                apply = binaryOperator.apply(v2, v);
                BytecodeManager.incBytecodes(1);
                final V v3 = value;
                final Object o = apply;
                BytecodeManager.incBytecodes(5);
                compareAndSet = this.compareAndSet(t, v3, (V)o);
                BytecodeManager.incBytecodes(1);
            } while (!compareAndSet);
            final Object o2 = apply;
            BytecodeManager.incBytecodes(2);
            return (V)o2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static final class AtomicReferenceFieldUpdaterImpl<T, V> extends AtomicReferenceFieldUpdater<T, V>
    {
        private static final Unsafe unsafe;
        private final long offset;
        private final Class<T> tclass;
        private final Class<V> vclass;
        private final Class<?> cclass;
        
        AtomicReferenceFieldUpdaterImpl(final Class<T> p0, final Class<V> p1, final String p2, final Class<?> p3) {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //     6: invokespecial   instrumented/java/util/concurrent/atomic/AtomicReferenceFieldUpdater.<init>:()V
            //     9: new             Linstrumented/java/util/concurrent/atomic/AtomicReferenceFieldUpdater$AtomicReferenceFieldUpdaterImpl$1;
            //    12: dup            
            //    13: aload_0        
            //    14: aload_1        
            //    15: aload_3        
            //    16: ldc             6
            //    18: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    21: invokespecial   instrumented/java/util/concurrent/atomic/AtomicReferenceFieldUpdater$AtomicReferenceFieldUpdaterImpl$1.<init>:(Linstrumented/java/util/concurrent/atomic/AtomicReferenceFieldUpdater$AtomicReferenceFieldUpdaterImpl;Ljava/lang/Class;Ljava/lang/String;)V
            //    24: ldc             1
            //    26: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    29: invokestatic    java/security/AccessController.doPrivileged:(Ljava/security/PrivilegedExceptionAction;)Ljava/lang/Object;
            //    32: checkcast       Ljava/lang/reflect/Field;
            //    35: astore          5
            //    37: ldc             2
            //    39: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    42: aload           5
            //    44: ldc             2
            //    46: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    49: invokevirtual   java/lang/reflect/Field.getModifiers:()I
            //    52: istore          7
            //    54: ldc             1
            //    56: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    59: aload           4
            //    61: aload_1        
            //    62: aconst_null    
            //    63: iload           7
            //    65: ldc             5
            //    67: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    70: invokestatic    sun/reflect/misc/ReflectUtil.ensureMemberAccess:(Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Object;I)V
            //    73: aload_1        
            //    74: ldc             2
            //    76: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    79: invokevirtual   java/lang/Class.getClassLoader:()Ljava/lang/ClassLoader;
            //    82: astore          8
            //    84: ldc             1
            //    86: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    89: aload           4
            //    91: ldc             2
            //    93: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    96: invokevirtual   java/lang/Class.getClassLoader:()Ljava/lang/ClassLoader;
            //    99: astore          9
            //   101: ldc             1
            //   103: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   106: aload           9
            //   108: ldc             2
            //   110: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   113: ifnull          172
            //   116: aload           9
            //   118: aload           8
            //   120: ldc             3
            //   122: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   125: if_acmpeq       172
            //   128: aload           8
            //   130: ldc             2
            //   132: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   135: ifnull          163
            //   138: aload           8
            //   140: aload           9
            //   142: ldc             2
            //   144: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   147: ldc             1
            //   149: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   152: invokestatic    instrumented/java/util/concurrent/atomic/AtomicReferenceFieldUpdater$AtomicReferenceFieldUpdaterImpl.isAncestor:(Ljava/lang/ClassLoader;Ljava/lang/ClassLoader;)Z
            //   155: ldc             1
            //   157: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   160: ifne            172
            //   163: aload_1        
            //   164: ldc             2
            //   166: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   169: invokestatic    sun/reflect/misc/ReflectUtil.checkPackageAccess:(Ljava/lang/Class;)V
            //   172: aload           5
            //   174: ldc             2
            //   176: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   179: invokevirtual   java/lang/reflect/Field.getType:()Ljava/lang/Class;
            //   182: astore          6
            //   184: ldc             1
            //   186: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   189: ldc             1
            //   191: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   194: goto            259
            //   197: astore          8
            //   199: ldc             501
            //   201: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   204: new             Ljava/lang/RuntimeException;
            //   207: dup            
            //   208: aload           8
            //   210: ldc             4
            //   212: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   215: invokevirtual   java/security/PrivilegedActionException.getException:()Ljava/lang/Exception;
            //   218: ldc             1
            //   220: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   223: invokespecial   java/lang/RuntimeException.<init>:(Ljava/lang/Throwable;)V
            //   226: ldc             1
            //   228: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   231: athrow         
            //   232: astore          8
            //   234: ldc             501
            //   236: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   239: new             Ljava/lang/RuntimeException;
            //   242: dup            
            //   243: aload           8
            //   245: ldc             4
            //   247: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   250: invokespecial   java/lang/RuntimeException.<init>:(Ljava/lang/Throwable;)V
            //   253: ldc             1
            //   255: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   258: athrow         
            //   259: aload_2        
            //   260: aload           6
            //   262: ldc             3
            //   264: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   267: if_acmpeq       288
            //   270: new             Ljava/lang/ClassCastException;
            //   273: dup            
            //   274: ldc             3
            //   276: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   279: invokespecial   java/lang/ClassCastException.<init>:()V
            //   282: ldc             1
            //   284: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   287: athrow         
            //   288: aload_2        
            //   289: ldc             2
            //   291: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   294: invokevirtual   java/lang/Class.isPrimitive:()Z
            //   297: ldc             1
            //   299: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   302: ifeq            325
            //   305: new             Ljava/lang/IllegalArgumentException;
            //   308: dup            
            //   309: ldc             "Must be reference type"
            //   311: ldc             4
            //   313: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   316: invokespecial   java/lang/IllegalArgumentException.<init>:(Ljava/lang/String;)V
            //   319: ldc             1
            //   321: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   324: athrow         
            //   325: iload           7
            //   327: ldc             2
            //   329: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   332: invokestatic    java/lang/reflect/Modifier.isVolatile:(I)Z
            //   335: ldc             1
            //   337: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   340: ifne            363
            //   343: new             Ljava/lang/IllegalArgumentException;
            //   346: dup            
            //   347: ldc             "Must be volatile type"
            //   349: ldc             4
            //   351: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   354: invokespecial   java/lang/IllegalArgumentException.<init>:(Ljava/lang/String;)V
            //   357: ldc             1
            //   359: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   362: athrow         
            //   363: aload_0        
            //   364: iload           7
            //   366: ldc             3
            //   368: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   371: invokestatic    java/lang/reflect/Modifier.isProtected:(I)Z
            //   374: ldc             1
            //   376: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   379: ifeq            403
            //   382: aload           4
            //   384: aload_1        
            //   385: ldc             3
            //   387: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   390: if_acmpeq       403
            //   393: aload           4
            //   395: ldc             2
            //   397: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   400: goto            409
            //   403: aconst_null    
            //   404: ldc             1
            //   406: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   409: putfield        instrumented/java/util/concurrent/atomic/AtomicReferenceFieldUpdater$AtomicReferenceFieldUpdaterImpl.cclass:Ljava/lang/Class;
            //   412: ldc             1
            //   414: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   417: aload_0        
            //   418: aload_1        
            //   419: putfield        instrumented/java/util/concurrent/atomic/AtomicReferenceFieldUpdater$AtomicReferenceFieldUpdaterImpl.tclass:Ljava/lang/Class;
            //   422: ldc             3
            //   424: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   427: aload_2        
            //   428: ldc             Ljava/lang/Object;.class
            //   430: ldc             3
            //   432: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   435: if_acmpne       451
            //   438: aload_0        
            //   439: aconst_null    
            //   440: putfield        instrumented/java/util/concurrent/atomic/AtomicReferenceFieldUpdater$AtomicReferenceFieldUpdaterImpl.vclass:Ljava/lang/Class;
            //   443: ldc             4
            //   445: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   448: goto            461
            //   451: aload_0        
            //   452: aload_2        
            //   453: putfield        instrumented/java/util/concurrent/atomic/AtomicReferenceFieldUpdater$AtomicReferenceFieldUpdaterImpl.vclass:Ljava/lang/Class;
            //   456: ldc             3
            //   458: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   461: aload_0        
            //   462: getstatic       instrumented/java/util/concurrent/atomic/AtomicReferenceFieldUpdater$AtomicReferenceFieldUpdaterImpl.unsafe:Lsun/misc/Unsafe;
            //   465: aload           5
            //   467: ldc             4
            //   469: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   472: invokevirtual   sun/misc/Unsafe.objectFieldOffset:(Ljava/lang/reflect/Field;)J
            //   475: putfield        instrumented/java/util/concurrent/atomic/AtomicReferenceFieldUpdater$AtomicReferenceFieldUpdaterImpl.offset:J
            //   478: ldc             1
            //   480: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   483: ldc             1
            //   485: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   488: return         
            //   489: athrow         
            //   490: athrow         
            //    Signature:
            //  (Ljava/lang/Class<TT;>;Ljava/lang/Class<TV;>;Ljava/lang/String;Ljava/lang/Class<*>;)V
            //    StackMapTable: 00 0E FF 00 A3 00 0A 07 00 02 07 00 40 07 00 40 07 00 4B 07 00 40 07 00 33 00 01 07 00 4D 07 00 4D 00 00 08 FF 00 18 00 05 07 00 02 07 00 40 07 00 40 07 00 4B 07 00 40 00 01 07 00 1A 62 07 00 1C FE 00 1A 07 00 33 07 00 40 01 1C 24 25 67 07 00 02 FF 00 05 00 08 07 00 02 07 00 40 07 00 40 07 00 4B 07 00 40 07 00 33 07 00 40 01 00 02 07 00 02 07 00 40 29 09 FF 00 1B 00 00 00 01 07 00 8D FF 00 00 00 00 00 01 07 00 18
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                                     
            //  -----  -----  -----  -----  -----------------------------------------
            //  9      490    490    491    Ljava/lang/VirtualMachineError;
            //  9      189    197    232    Ljava/security/PrivilegedActionException;
            //  9      189    232    259    Ljava/lang/Exception;
            //  0      489    489    490    Any
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0163:
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
        
        private static boolean isAncestor(final ClassLoader classLoader, final ClassLoader classLoader2) {
            try {
                ClassLoader parent = classLoader;
                BytecodeManager.incBytecodes(2);
                ClassLoader classLoader3;
                do {
                    final ClassLoader classLoader4 = parent;
                    BytecodeManager.incBytecodes(2);
                    parent = classLoader4.getParent();
                    BytecodeManager.incBytecodes(1);
                    final ClassLoader classLoader5 = parent;
                    BytecodeManager.incBytecodes(3);
                    if (classLoader2 == classLoader5) {
                        final boolean b = true;
                        BytecodeManager.incBytecodes(2);
                        return b;
                    }
                    classLoader3 = parent;
                    BytecodeManager.incBytecodes(2);
                } while (classLoader3 != null);
                final boolean b2 = false;
                BytecodeManager.incBytecodes(2);
                return b2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        void targetCheck(final T t) {
            try {
                final Class<T> tclass = this.tclass;
                BytecodeManager.incBytecodes(4);
                final boolean instance = tclass.isInstance(t);
                BytecodeManager.incBytecodes(1);
                if (!instance) {
                    BytecodeManager.incBytecodes(3);
                    final ClassCastException ex = new ClassCastException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final Class<?> cclass = this.cclass;
                BytecodeManager.incBytecodes(3);
                if (cclass != null) {
                    BytecodeManager.incBytecodes(3);
                    this.ensureProtectedAccess(t);
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        void updateCheck(final T t, final V v) {
            try {
                final Class<T> tclass = this.tclass;
                BytecodeManager.incBytecodes(4);
                final boolean instance = tclass.isInstance(t);
                BytecodeManager.incBytecodes(1);
                Label_0068: {
                    if (instance) {
                        BytecodeManager.incBytecodes(2);
                        if (v != null) {
                            final Class<V> vclass = this.vclass;
                            BytecodeManager.incBytecodes(3);
                            if (vclass != null) {
                                final Class<V> vclass2 = this.vclass;
                                BytecodeManager.incBytecodes(3);
                                BytecodeManager.incBytecodes(1);
                                final boolean instance2 = vclass2.isInstance(v);
                                BytecodeManager.incBytecodes(1);
                                if (!instance2) {
                                    break Label_0068;
                                }
                            }
                        }
                        final Class<?> cclass = this.cclass;
                        BytecodeManager.incBytecodes(3);
                        if (cclass != null) {
                            BytecodeManager.incBytecodes(3);
                            this.ensureProtectedAccess(t);
                        }
                        BytecodeManager.incBytecodes(1);
                        return;
                    }
                }
                BytecodeManager.incBytecodes(3);
                final ClassCastException ex = new ClassCastException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean compareAndSet(final T o, final V expected, final V x) {
            try {
                BytecodeManager.incBytecodes(2);
                Label_0100: {
                    if (o != null) {
                        BytecodeManager.incBytecodes(2);
                        final Class<?> class1 = o.getClass();
                        final Class<T> tclass = this.tclass;
                        BytecodeManager.incBytecodes(3);
                        if (class1 == tclass) {
                            final Class<?> cclass = this.cclass;
                            BytecodeManager.incBytecodes(3);
                            if (cclass == null) {
                                BytecodeManager.incBytecodes(2);
                                if (x == null) {
                                    break Label_0100;
                                }
                                final Class<V> vclass = this.vclass;
                                BytecodeManager.incBytecodes(3);
                                if (vclass == null) {
                                    break Label_0100;
                                }
                                final Class<V> vclass2 = this.vclass;
                                BytecodeManager.incBytecodes(3);
                                BytecodeManager.incBytecodes(1);
                                final Class<?> class2 = x.getClass();
                                BytecodeManager.incBytecodes(1);
                                if (vclass2 == class2) {
                                    break Label_0100;
                                }
                            }
                        }
                    }
                    BytecodeManager.incBytecodes(4);
                    this.updateCheck(o, x);
                }
                final Unsafe unsafe = AtomicReferenceFieldUpdaterImpl.unsafe;
                final long offset = this.offset;
                BytecodeManager.incBytecodes(7);
                final boolean compareAndSwapObject = unsafe.compareAndSwapObject(o, offset, expected, x);
                BytecodeManager.incBytecodes(1);
                return compareAndSwapObject;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean weakCompareAndSet(final T o, final V expected, final V x) {
            try {
                BytecodeManager.incBytecodes(2);
                Label_0100: {
                    if (o != null) {
                        BytecodeManager.incBytecodes(2);
                        final Class<?> class1 = o.getClass();
                        final Class<T> tclass = this.tclass;
                        BytecodeManager.incBytecodes(3);
                        if (class1 == tclass) {
                            final Class<?> cclass = this.cclass;
                            BytecodeManager.incBytecodes(3);
                            if (cclass == null) {
                                BytecodeManager.incBytecodes(2);
                                if (x == null) {
                                    break Label_0100;
                                }
                                final Class<V> vclass = this.vclass;
                                BytecodeManager.incBytecodes(3);
                                if (vclass == null) {
                                    break Label_0100;
                                }
                                final Class<V> vclass2 = this.vclass;
                                BytecodeManager.incBytecodes(3);
                                BytecodeManager.incBytecodes(1);
                                final Class<?> class2 = x.getClass();
                                BytecodeManager.incBytecodes(1);
                                if (vclass2 == class2) {
                                    break Label_0100;
                                }
                            }
                        }
                    }
                    BytecodeManager.incBytecodes(4);
                    this.updateCheck(o, x);
                }
                final Unsafe unsafe = AtomicReferenceFieldUpdaterImpl.unsafe;
                final long offset = this.offset;
                BytecodeManager.incBytecodes(7);
                final boolean compareAndSwapObject = unsafe.compareAndSwapObject(o, offset, expected, x);
                BytecodeManager.incBytecodes(1);
                return compareAndSwapObject;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void set(final T o, final V x) {
            try {
                BytecodeManager.incBytecodes(2);
                Label_0100: {
                    if (o != null) {
                        BytecodeManager.incBytecodes(2);
                        final Class<?> class1 = o.getClass();
                        final Class<T> tclass = this.tclass;
                        BytecodeManager.incBytecodes(3);
                        if (class1 == tclass) {
                            final Class<?> cclass = this.cclass;
                            BytecodeManager.incBytecodes(3);
                            if (cclass == null) {
                                BytecodeManager.incBytecodes(2);
                                if (x == null) {
                                    break Label_0100;
                                }
                                final Class<V> vclass = this.vclass;
                                BytecodeManager.incBytecodes(3);
                                if (vclass == null) {
                                    break Label_0100;
                                }
                                final Class<V> vclass2 = this.vclass;
                                BytecodeManager.incBytecodes(3);
                                BytecodeManager.incBytecodes(1);
                                final Class<?> class2 = x.getClass();
                                BytecodeManager.incBytecodes(1);
                                if (vclass2 == class2) {
                                    break Label_0100;
                                }
                            }
                        }
                    }
                    BytecodeManager.incBytecodes(4);
                    this.updateCheck(o, x);
                }
                final Unsafe unsafe = AtomicReferenceFieldUpdaterImpl.unsafe;
                final long offset = this.offset;
                BytecodeManager.incBytecodes(6);
                unsafe.putObjectVolatile(o, offset, x);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void lazySet(final T o, final V x) {
            try {
                BytecodeManager.incBytecodes(2);
                Label_0100: {
                    if (o != null) {
                        BytecodeManager.incBytecodes(2);
                        final Class<?> class1 = o.getClass();
                        final Class<T> tclass = this.tclass;
                        BytecodeManager.incBytecodes(3);
                        if (class1 == tclass) {
                            final Class<?> cclass = this.cclass;
                            BytecodeManager.incBytecodes(3);
                            if (cclass == null) {
                                BytecodeManager.incBytecodes(2);
                                if (x == null) {
                                    break Label_0100;
                                }
                                final Class<V> vclass = this.vclass;
                                BytecodeManager.incBytecodes(3);
                                if (vclass == null) {
                                    break Label_0100;
                                }
                                final Class<V> vclass2 = this.vclass;
                                BytecodeManager.incBytecodes(3);
                                BytecodeManager.incBytecodes(1);
                                final Class<?> class2 = x.getClass();
                                BytecodeManager.incBytecodes(1);
                                if (vclass2 == class2) {
                                    break Label_0100;
                                }
                            }
                        }
                    }
                    BytecodeManager.incBytecodes(4);
                    this.updateCheck(o, x);
                }
                final Unsafe unsafe = AtomicReferenceFieldUpdaterImpl.unsafe;
                final long offset = this.offset;
                BytecodeManager.incBytecodes(6);
                unsafe.putOrderedObject(o, offset, x);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public V get(final T o) {
            try {
                BytecodeManager.incBytecodes(2);
                Label_0052: {
                    if (o != null) {
                        BytecodeManager.incBytecodes(2);
                        final Class<?> class1 = o.getClass();
                        final Class<T> tclass = this.tclass;
                        BytecodeManager.incBytecodes(3);
                        if (class1 == tclass) {
                            final Class<?> cclass = this.cclass;
                            BytecodeManager.incBytecodes(3);
                            if (cclass == null) {
                                break Label_0052;
                            }
                        }
                    }
                    BytecodeManager.incBytecodes(3);
                    this.targetCheck(o);
                }
                final Unsafe unsafe = AtomicReferenceFieldUpdaterImpl.unsafe;
                final long offset = this.offset;
                BytecodeManager.incBytecodes(5);
                final Object objectVolatile = unsafe.getObjectVolatile(o, offset);
                BytecodeManager.incBytecodes(1);
                return (V)objectVolatile;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public V getAndSet(final T o, final V newValue) {
            try {
                BytecodeManager.incBytecodes(2);
                Label_0100: {
                    if (o != null) {
                        BytecodeManager.incBytecodes(2);
                        final Class<?> class1 = o.getClass();
                        final Class<T> tclass = this.tclass;
                        BytecodeManager.incBytecodes(3);
                        if (class1 == tclass) {
                            final Class<?> cclass = this.cclass;
                            BytecodeManager.incBytecodes(3);
                            if (cclass == null) {
                                BytecodeManager.incBytecodes(2);
                                if (newValue == null) {
                                    break Label_0100;
                                }
                                final Class<V> vclass = this.vclass;
                                BytecodeManager.incBytecodes(3);
                                if (vclass == null) {
                                    break Label_0100;
                                }
                                final Class<V> vclass2 = this.vclass;
                                BytecodeManager.incBytecodes(3);
                                BytecodeManager.incBytecodes(1);
                                final Class<?> class2 = newValue.getClass();
                                BytecodeManager.incBytecodes(1);
                                if (vclass2 == class2) {
                                    break Label_0100;
                                }
                            }
                        }
                    }
                    BytecodeManager.incBytecodes(4);
                    this.updateCheck(o, newValue);
                }
                final Unsafe unsafe = AtomicReferenceFieldUpdaterImpl.unsafe;
                final long offset = this.offset;
                BytecodeManager.incBytecodes(6);
                final Object andSetObject = unsafe.getAndSetObject(o, offset, newValue);
                BytecodeManager.incBytecodes(1);
                return (V)andSetObject;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private void ensureProtectedAccess(final T t) {
            try {
                final Class<?> cclass = this.cclass;
                BytecodeManager.incBytecodes(4);
                final boolean instance = cclass.isInstance(t);
                BytecodeManager.incBytecodes(1);
                if (instance) {
                    BytecodeManager.incBytecodes(1);
                    return;
                }
                BytecodeManager.incBytecodes(7);
                final StringBuilder sb = new StringBuilder();
                final String str = "Class ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb.append(str);
                final Class<?> cclass2 = this.cclass;
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
                final String name = cclass2.getName();
                BytecodeManager.incBytecodes(1);
                final StringBuilder append2 = append.append(name);
                final String str2 = " can not access a protected member of class ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append3 = append2.append(str2);
                final Class<T> tclass = this.tclass;
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
                final String name2 = tclass.getName();
                BytecodeManager.incBytecodes(1);
                final StringBuilder append4 = append3.append(name2);
                final String str3 = " using an instance of ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append5 = append4.append(str3);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                final Class<?> class1 = t.getClass();
                BytecodeManager.incBytecodes(1);
                final String name3 = class1.getName();
                BytecodeManager.incBytecodes(1);
                final StringBuilder append6 = append5.append(name3);
                BytecodeManager.incBytecodes(1);
                final String string = append6.toString();
                BytecodeManager.incBytecodes(1);
                final IllegalAccessException cause = new IllegalAccessException(string);
                BytecodeManager.incBytecodes(1);
                final RuntimeException ex = new RuntimeException(cause);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static {
            try {
                BytecodeManager.incBytecodes(1);
                unsafe = Unsafe.getUnsafe();
                BytecodeManager.incBytecodes(2);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
}
