// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.concurrent.atomic;

import sun.misc.Unsafe;
import instrumented.java.util.function.IntBinaryOperator;
import instrumented.java.util.function.IntUnaryOperator;
import sun.reflect.CallerSensitive;
import sun.reflect.Reflection;
import aic2021.engine.BytecodeManager;

public abstract class AtomicIntegerFieldUpdater<T>
{
    @CallerSensitive
    public static <U> AtomicIntegerFieldUpdater<U> newUpdater(final Class<U> clazz, final String s) {
        try {
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(1);
            final Class callerClass = Reflection.getCallerClass();
            BytecodeManager.incBytecodes(1);
            final AtomicIntegerFieldUpdaterImpl atomicIntegerFieldUpdaterImpl = new AtomicIntegerFieldUpdaterImpl<U>(clazz, s, callerClass);
            BytecodeManager.incBytecodes(1);
            return (AtomicIntegerFieldUpdater<U>)atomicIntegerFieldUpdaterImpl;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    protected AtomicIntegerFieldUpdater() {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public abstract boolean compareAndSet(final T p0, final int p1, final int p2);
    
    public abstract boolean weakCompareAndSet(final T p0, final int p1, final int p2);
    
    public abstract void set(final T p0, final int p1);
    
    public abstract void lazySet(final T p0, final int p1);
    
    public abstract int get(final T p0);
    
    public int getAndSet(final T t, final int n) {
        try {
            boolean compareAndSet;
            int value;
            do {
                BytecodeManager.incBytecodes(3);
                value = this.get(t);
                BytecodeManager.incBytecodes(1);
                final int n2 = value;
                BytecodeManager.incBytecodes(5);
                compareAndSet = this.compareAndSet(t, n2, n);
                BytecodeManager.incBytecodes(1);
            } while (!compareAndSet);
            final int n3 = value;
            BytecodeManager.incBytecodes(2);
            return n3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public int getAndIncrement(final T t) {
        try {
            boolean compareAndSet;
            int value;
            do {
                BytecodeManager.incBytecodes(3);
                value = this.get(t);
                BytecodeManager.incBytecodes(1);
                final int n = value + 1;
                BytecodeManager.incBytecodes(4);
                final int n2 = value;
                final int n3 = n;
                BytecodeManager.incBytecodes(5);
                compareAndSet = this.compareAndSet(t, n2, n3);
                BytecodeManager.incBytecodes(1);
            } while (!compareAndSet);
            final int n4 = value;
            BytecodeManager.incBytecodes(2);
            return n4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public int getAndDecrement(final T t) {
        try {
            boolean compareAndSet;
            int value;
            do {
                BytecodeManager.incBytecodes(3);
                value = this.get(t);
                BytecodeManager.incBytecodes(1);
                final int n = value - 1;
                BytecodeManager.incBytecodes(4);
                final int n2 = value;
                final int n3 = n;
                BytecodeManager.incBytecodes(5);
                compareAndSet = this.compareAndSet(t, n2, n3);
                BytecodeManager.incBytecodes(1);
            } while (!compareAndSet);
            final int n4 = value;
            BytecodeManager.incBytecodes(2);
            return n4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public int getAndAdd(final T t, final int n) {
        try {
            boolean compareAndSet;
            int value;
            do {
                BytecodeManager.incBytecodes(3);
                value = this.get(t);
                BytecodeManager.incBytecodes(1);
                final int n2 = value + n;
                BytecodeManager.incBytecodes(4);
                final int n3 = value;
                final int n4 = n2;
                BytecodeManager.incBytecodes(5);
                compareAndSet = this.compareAndSet(t, n3, n4);
                BytecodeManager.incBytecodes(1);
            } while (!compareAndSet);
            final int n5 = value;
            BytecodeManager.incBytecodes(2);
            return n5;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public int incrementAndGet(final T t) {
        try {
            boolean compareAndSet;
            int n;
            do {
                BytecodeManager.incBytecodes(3);
                final int value = this.get(t);
                BytecodeManager.incBytecodes(1);
                n = value + 1;
                BytecodeManager.incBytecodes(4);
                final int n2 = value;
                final int n3 = n;
                BytecodeManager.incBytecodes(5);
                compareAndSet = this.compareAndSet(t, n2, n3);
                BytecodeManager.incBytecodes(1);
            } while (!compareAndSet);
            final int n4 = n;
            BytecodeManager.incBytecodes(2);
            return n4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public int decrementAndGet(final T t) {
        try {
            boolean compareAndSet;
            int n;
            do {
                BytecodeManager.incBytecodes(3);
                final int value = this.get(t);
                BytecodeManager.incBytecodes(1);
                n = value - 1;
                BytecodeManager.incBytecodes(4);
                final int n2 = value;
                final int n3 = n;
                BytecodeManager.incBytecodes(5);
                compareAndSet = this.compareAndSet(t, n2, n3);
                BytecodeManager.incBytecodes(1);
            } while (!compareAndSet);
            final int n4 = n;
            BytecodeManager.incBytecodes(2);
            return n4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public int addAndGet(final T t, final int n) {
        try {
            boolean compareAndSet;
            int n2;
            do {
                BytecodeManager.incBytecodes(3);
                final int value = this.get(t);
                BytecodeManager.incBytecodes(1);
                n2 = value + n;
                BytecodeManager.incBytecodes(4);
                final int n3 = value;
                final int n4 = n2;
                BytecodeManager.incBytecodes(5);
                compareAndSet = this.compareAndSet(t, n3, n4);
                BytecodeManager.incBytecodes(1);
            } while (!compareAndSet);
            final int n5 = n2;
            BytecodeManager.incBytecodes(2);
            return n5;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final int getAndUpdate(final T t, final IntUnaryOperator intUnaryOperator) {
        try {
            boolean compareAndSet;
            int value;
            do {
                BytecodeManager.incBytecodes(3);
                value = this.get(t);
                BytecodeManager.incBytecodes(1);
                final int n = value;
                BytecodeManager.incBytecodes(3);
                final int applyAsInt = intUnaryOperator.applyAsInt(n);
                BytecodeManager.incBytecodes(1);
                final int n2 = value;
                final int n3 = applyAsInt;
                BytecodeManager.incBytecodes(5);
                compareAndSet = this.compareAndSet(t, n2, n3);
                BytecodeManager.incBytecodes(1);
            } while (!compareAndSet);
            final int n4 = value;
            BytecodeManager.incBytecodes(2);
            return n4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final int updateAndGet(final T t, final IntUnaryOperator intUnaryOperator) {
        try {
            boolean compareAndSet;
            int applyAsInt;
            do {
                BytecodeManager.incBytecodes(3);
                final int value = this.get(t);
                BytecodeManager.incBytecodes(1);
                final int n = value;
                BytecodeManager.incBytecodes(3);
                applyAsInt = intUnaryOperator.applyAsInt(n);
                BytecodeManager.incBytecodes(1);
                final int n2 = value;
                final int n3 = applyAsInt;
                BytecodeManager.incBytecodes(5);
                compareAndSet = this.compareAndSet(t, n2, n3);
                BytecodeManager.incBytecodes(1);
            } while (!compareAndSet);
            final int n4 = applyAsInt;
            BytecodeManager.incBytecodes(2);
            return n4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final int getAndAccumulate(final T t, final int n, final IntBinaryOperator intBinaryOperator) {
        try {
            boolean compareAndSet;
            int value;
            do {
                BytecodeManager.incBytecodes(3);
                value = this.get(t);
                BytecodeManager.incBytecodes(1);
                final int n2 = value;
                BytecodeManager.incBytecodes(4);
                final int applyAsInt = intBinaryOperator.applyAsInt(n2, n);
                BytecodeManager.incBytecodes(1);
                final int n3 = value;
                final int n4 = applyAsInt;
                BytecodeManager.incBytecodes(5);
                compareAndSet = this.compareAndSet(t, n3, n4);
                BytecodeManager.incBytecodes(1);
            } while (!compareAndSet);
            final int n5 = value;
            BytecodeManager.incBytecodes(2);
            return n5;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final int accumulateAndGet(final T t, final int n, final IntBinaryOperator intBinaryOperator) {
        try {
            boolean compareAndSet;
            int applyAsInt;
            do {
                BytecodeManager.incBytecodes(3);
                final int value = this.get(t);
                BytecodeManager.incBytecodes(1);
                final int n2 = value;
                BytecodeManager.incBytecodes(4);
                applyAsInt = intBinaryOperator.applyAsInt(n2, n);
                BytecodeManager.incBytecodes(1);
                final int n3 = value;
                final int n4 = applyAsInt;
                BytecodeManager.incBytecodes(5);
                compareAndSet = this.compareAndSet(t, n3, n4);
                BytecodeManager.incBytecodes(1);
            } while (!compareAndSet);
            final int n5 = applyAsInt;
            BytecodeManager.incBytecodes(2);
            return n5;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static class AtomicIntegerFieldUpdaterImpl<T> extends AtomicIntegerFieldUpdater<T>
    {
        private static final Unsafe unsafe;
        private final long offset;
        private final Class<T> tclass;
        private final Class<?> cclass;
        
        AtomicIntegerFieldUpdaterImpl(final Class<T> p0, final String p1, final Class<?> p2) {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //     6: invokespecial   instrumented/java/util/concurrent/atomic/AtomicIntegerFieldUpdater.<init>:()V
            //     9: new             Linstrumented/java/util/concurrent/atomic/AtomicIntegerFieldUpdater$AtomicIntegerFieldUpdaterImpl$1;
            //    12: dup            
            //    13: aload_0        
            //    14: aload_1        
            //    15: aload_2        
            //    16: ldc             6
            //    18: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    21: invokespecial   instrumented/java/util/concurrent/atomic/AtomicIntegerFieldUpdater$AtomicIntegerFieldUpdaterImpl$1.<init>:(Linstrumented/java/util/concurrent/atomic/AtomicIntegerFieldUpdater$AtomicIntegerFieldUpdaterImpl;Ljava/lang/Class;Ljava/lang/String;)V
            //    24: ldc             1
            //    26: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    29: invokestatic    java/security/AccessController.doPrivileged:(Ljava/security/PrivilegedExceptionAction;)Ljava/lang/Object;
            //    32: checkcast       Ljava/lang/reflect/Field;
            //    35: astore          4
            //    37: ldc             2
            //    39: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    42: aload           4
            //    44: ldc             2
            //    46: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    49: invokevirtual   java/lang/reflect/Field.getModifiers:()I
            //    52: istore          5
            //    54: ldc             1
            //    56: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    59: aload_3        
            //    60: aload_1        
            //    61: aconst_null    
            //    62: iload           5
            //    64: ldc             5
            //    66: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    69: invokestatic    sun/reflect/misc/ReflectUtil.ensureMemberAccess:(Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Object;I)V
            //    72: aload_1        
            //    73: ldc             2
            //    75: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    78: invokevirtual   java/lang/Class.getClassLoader:()Ljava/lang/ClassLoader;
            //    81: astore          6
            //    83: ldc             1
            //    85: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    88: aload_3        
            //    89: ldc             2
            //    91: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    94: invokevirtual   java/lang/Class.getClassLoader:()Ljava/lang/ClassLoader;
            //    97: astore          7
            //    99: ldc             1
            //   101: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   104: aload           7
            //   106: ldc             2
            //   108: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   111: ifnull          170
            //   114: aload           7
            //   116: aload           6
            //   118: ldc             3
            //   120: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   123: if_acmpeq       170
            //   126: aload           6
            //   128: ldc             2
            //   130: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   133: ifnull          161
            //   136: aload           6
            //   138: aload           7
            //   140: ldc             2
            //   142: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   145: ldc             1
            //   147: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   150: invokestatic    instrumented/java/util/concurrent/atomic/AtomicIntegerFieldUpdater$AtomicIntegerFieldUpdaterImpl.isAncestor:(Ljava/lang/ClassLoader;Ljava/lang/ClassLoader;)Z
            //   153: ldc             1
            //   155: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   158: ifne            170
            //   161: aload_1        
            //   162: ldc             2
            //   164: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   167: invokestatic    sun/reflect/misc/ReflectUtil.checkPackageAccess:(Ljava/lang/Class;)V
            //   170: ldc             1
            //   172: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   175: goto            240
            //   178: astore          6
            //   180: ldc             501
            //   182: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   185: new             Ljava/lang/RuntimeException;
            //   188: dup            
            //   189: aload           6
            //   191: ldc             4
            //   193: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   196: invokevirtual   java/security/PrivilegedActionException.getException:()Ljava/lang/Exception;
            //   199: ldc             1
            //   201: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   204: invokespecial   java/lang/RuntimeException.<init>:(Ljava/lang/Throwable;)V
            //   207: ldc             1
            //   209: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   212: athrow         
            //   213: astore          6
            //   215: ldc             501
            //   217: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   220: new             Ljava/lang/RuntimeException;
            //   223: dup            
            //   224: aload           6
            //   226: ldc             4
            //   228: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   231: invokespecial   java/lang/RuntimeException.<init>:(Ljava/lang/Throwable;)V
            //   234: ldc             1
            //   236: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   239: athrow         
            //   240: aload           4
            //   242: ldc             2
            //   244: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   247: invokevirtual   java/lang/reflect/Field.getType:()Ljava/lang/Class;
            //   250: astore          6
            //   252: ldc             1
            //   254: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   257: aload           6
            //   259: getstatic       java/lang/Integer.TYPE:Ljava/lang/Class;
            //   262: ldc             3
            //   264: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   267: if_acmpeq       290
            //   270: new             Ljava/lang/IllegalArgumentException;
            //   273: dup            
            //   274: ldc             "Must be integer type"
            //   276: ldc             4
            //   278: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   281: invokespecial   java/lang/IllegalArgumentException.<init>:(Ljava/lang/String;)V
            //   284: ldc             1
            //   286: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   289: athrow         
            //   290: iload           5
            //   292: ldc             2
            //   294: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   297: invokestatic    java/lang/reflect/Modifier.isVolatile:(I)Z
            //   300: ldc             1
            //   302: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   305: ifne            328
            //   308: new             Ljava/lang/IllegalArgumentException;
            //   311: dup            
            //   312: ldc             "Must be volatile type"
            //   314: ldc             4
            //   316: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   319: invokespecial   java/lang/IllegalArgumentException.<init>:(Ljava/lang/String;)V
            //   322: ldc             1
            //   324: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   327: athrow         
            //   328: aload_0        
            //   329: iload           5
            //   331: ldc             3
            //   333: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   336: invokestatic    java/lang/reflect/Modifier.isProtected:(I)Z
            //   339: ldc             1
            //   341: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   344: ifeq            366
            //   347: aload_3        
            //   348: aload_1        
            //   349: ldc             3
            //   351: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   354: if_acmpeq       366
            //   357: aload_3        
            //   358: ldc             2
            //   360: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   363: goto            372
            //   366: aconst_null    
            //   367: ldc             1
            //   369: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   372: putfield        instrumented/java/util/concurrent/atomic/AtomicIntegerFieldUpdater$AtomicIntegerFieldUpdaterImpl.cclass:Ljava/lang/Class;
            //   375: ldc             1
            //   377: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   380: aload_0        
            //   381: aload_1        
            //   382: putfield        instrumented/java/util/concurrent/atomic/AtomicIntegerFieldUpdater$AtomicIntegerFieldUpdaterImpl.tclass:Ljava/lang/Class;
            //   385: ldc             3
            //   387: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   390: aload_0        
            //   391: getstatic       instrumented/java/util/concurrent/atomic/AtomicIntegerFieldUpdater$AtomicIntegerFieldUpdaterImpl.unsafe:Lsun/misc/Unsafe;
            //   394: aload           4
            //   396: ldc             4
            //   398: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   401: invokevirtual   sun/misc/Unsafe.objectFieldOffset:(Ljava/lang/reflect/Field;)J
            //   404: putfield        instrumented/java/util/concurrent/atomic/AtomicIntegerFieldUpdater$AtomicIntegerFieldUpdaterImpl.offset:J
            //   407: ldc             1
            //   409: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   412: ldc             1
            //   414: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   417: return         
            //   418: athrow         
            //   419: athrow         
            //    Signature:
            //  (Ljava/lang/Class<TT;>;Ljava/lang/String;Ljava/lang/Class<*>;)V
            //    StackMapTable: 00 0B FF 00 A1 00 08 07 00 02 07 00 3E 07 00 49 07 00 3E 07 00 31 01 07 00 4B 07 00 4B 00 00 F9 00 08 FF 00 07 00 04 07 00 02 07 00 3E 07 00 49 07 00 3E 00 01 07 00 18 62 07 00 1A FD 00 1A 07 00 31 01 FC 00 31 07 00 3E 25 65 07 00 02 FF 00 05 00 07 07 00 02 07 00 3E 07 00 49 07 00 3E 07 00 31 01 07 00 3E 00 02 07 00 02 07 00 3E FF 00 2D 00 00 00 01 07 00 85 FF 00 00 00 00 00 01 07 00 16
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                                     
            //  -----  -----  -----  -----  -----------------------------------------
            //  9      419    419    420    Ljava/lang/VirtualMachineError;
            //  9      170    178    213    Ljava/security/PrivilegedActionException;
            //  9      170    213    240    Ljava/lang/Exception;
            //  0      418    418    419    Any
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0161:
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
        
        private void fullCheck(final T t) {
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
        
        @Override
        public boolean compareAndSet(final T o, final int expected, final int x) {
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
                    this.fullCheck(o);
                }
                final Unsafe unsafe = AtomicIntegerFieldUpdaterImpl.unsafe;
                final long offset = this.offset;
                BytecodeManager.incBytecodes(7);
                final boolean compareAndSwapInt = unsafe.compareAndSwapInt(o, offset, expected, x);
                BytecodeManager.incBytecodes(1);
                return compareAndSwapInt;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean weakCompareAndSet(final T o, final int expected, final int x) {
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
                    this.fullCheck(o);
                }
                final Unsafe unsafe = AtomicIntegerFieldUpdaterImpl.unsafe;
                final long offset = this.offset;
                BytecodeManager.incBytecodes(7);
                final boolean compareAndSwapInt = unsafe.compareAndSwapInt(o, offset, expected, x);
                BytecodeManager.incBytecodes(1);
                return compareAndSwapInt;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void set(final T o, final int x) {
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
                    this.fullCheck(o);
                }
                final Unsafe unsafe = AtomicIntegerFieldUpdaterImpl.unsafe;
                final long offset = this.offset;
                BytecodeManager.incBytecodes(6);
                unsafe.putIntVolatile(o, offset, x);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void lazySet(final T o, final int x) {
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
                    this.fullCheck(o);
                }
                final Unsafe unsafe = AtomicIntegerFieldUpdaterImpl.unsafe;
                final long offset = this.offset;
                BytecodeManager.incBytecodes(6);
                unsafe.putOrderedInt(o, offset, x);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final int get(final T o) {
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
                    this.fullCheck(o);
                }
                final Unsafe unsafe = AtomicIntegerFieldUpdaterImpl.unsafe;
                final long offset = this.offset;
                BytecodeManager.incBytecodes(5);
                final int intVolatile = unsafe.getIntVolatile(o, offset);
                BytecodeManager.incBytecodes(1);
                return intVolatile;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int getAndSet(final T o, final int newValue) {
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
                    this.fullCheck(o);
                }
                final Unsafe unsafe = AtomicIntegerFieldUpdaterImpl.unsafe;
                final long offset = this.offset;
                BytecodeManager.incBytecodes(6);
                final int andSetInt = unsafe.getAndSetInt(o, offset, newValue);
                BytecodeManager.incBytecodes(1);
                return andSetInt;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int getAndIncrement(final T t) {
            try {
                final int n = 1;
                BytecodeManager.incBytecodes(4);
                final int andAdd = this.getAndAdd(t, n);
                BytecodeManager.incBytecodes(1);
                return andAdd;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int getAndDecrement(final T t) {
            try {
                final int n = -1;
                BytecodeManager.incBytecodes(4);
                final int andAdd = this.getAndAdd(t, n);
                BytecodeManager.incBytecodes(1);
                return andAdd;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int getAndAdd(final T o, final int delta) {
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
                    this.fullCheck(o);
                }
                final Unsafe unsafe = AtomicIntegerFieldUpdaterImpl.unsafe;
                final long offset = this.offset;
                BytecodeManager.incBytecodes(6);
                final int andAddInt = unsafe.getAndAddInt(o, offset, delta);
                BytecodeManager.incBytecodes(1);
                return andAddInt;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int incrementAndGet(final T t) {
            try {
                final int n = 1;
                BytecodeManager.incBytecodes(4);
                final int n2 = this.getAndAdd(t, n) + 1;
                BytecodeManager.incBytecodes(3);
                return n2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int decrementAndGet(final T t) {
            try {
                final int n = -1;
                BytecodeManager.incBytecodes(4);
                final int n2 = this.getAndAdd(t, n) - 1;
                BytecodeManager.incBytecodes(3);
                return n2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int addAndGet(final T t, final int n) {
            try {
                BytecodeManager.incBytecodes(4);
                final int n2 = this.getAndAdd(t, n) + n;
                BytecodeManager.incBytecodes(3);
                return n2;
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
