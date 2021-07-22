// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.concurrent.atomic;

import sun.misc.Unsafe;
import instrumented.java.util.function.LongBinaryOperator;
import instrumented.java.util.function.LongUnaryOperator;
import sun.reflect.CallerSensitive;
import sun.reflect.Reflection;
import aic2021.engine.BytecodeManager;

public abstract class AtomicLongFieldUpdater<T>
{
    @CallerSensitive
    public static <U> AtomicLongFieldUpdater<U> newUpdater(final Class<U> clazz, final String s) {
        try {
            BytecodeManager.incBytecodes(1);
            final Class callerClass = Reflection.getCallerClass();
            BytecodeManager.incBytecodes(1);
            final boolean vm_SUPPORTS_LONG_CAS = AtomicLong.VM_SUPPORTS_LONG_CAS;
            BytecodeManager.incBytecodes(2);
            if (vm_SUPPORTS_LONG_CAS) {
                final Class clazz2 = callerClass;
                BytecodeManager.incBytecodes(6);
                final CASUpdater casUpdater = new CASUpdater<U>(clazz, s, clazz2);
                BytecodeManager.incBytecodes(1);
                return (AtomicLongFieldUpdater<U>)casUpdater;
            }
            final Class clazz3 = callerClass;
            BytecodeManager.incBytecodes(6);
            final LockedUpdater lockedUpdater = new LockedUpdater<U>(clazz, s, clazz3);
            BytecodeManager.incBytecodes(1);
            return (AtomicLongFieldUpdater<U>)lockedUpdater;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    protected AtomicLongFieldUpdater() {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public abstract boolean compareAndSet(final T p0, final long p1, final long p2);
    
    public abstract boolean weakCompareAndSet(final T p0, final long p1, final long p2);
    
    public abstract void set(final T p0, final long p1);
    
    public abstract void lazySet(final T p0, final long p1);
    
    public abstract long get(final T p0);
    
    public long getAndSet(final T t, final long n) {
        try {
            boolean compareAndSet;
            long value;
            do {
                BytecodeManager.incBytecodes(3);
                value = this.get(t);
                BytecodeManager.incBytecodes(1);
                final long n2 = value;
                BytecodeManager.incBytecodes(5);
                compareAndSet = this.compareAndSet(t, n2, n);
                BytecodeManager.incBytecodes(1);
            } while (!compareAndSet);
            final long n3 = value;
            BytecodeManager.incBytecodes(2);
            return n3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public long getAndIncrement(final T t) {
        try {
            boolean compareAndSet;
            long value;
            do {
                BytecodeManager.incBytecodes(3);
                value = this.get(t);
                BytecodeManager.incBytecodes(1);
                final long n = value + 1L;
                BytecodeManager.incBytecodes(4);
                final long n2 = value;
                final long n3 = n;
                BytecodeManager.incBytecodes(5);
                compareAndSet = this.compareAndSet(t, n2, n3);
                BytecodeManager.incBytecodes(1);
            } while (!compareAndSet);
            final long n4 = value;
            BytecodeManager.incBytecodes(2);
            return n4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public long getAndDecrement(final T t) {
        try {
            boolean compareAndSet;
            long value;
            do {
                BytecodeManager.incBytecodes(3);
                value = this.get(t);
                BytecodeManager.incBytecodes(1);
                final long n = value - 1L;
                BytecodeManager.incBytecodes(4);
                final long n2 = value;
                final long n3 = n;
                BytecodeManager.incBytecodes(5);
                compareAndSet = this.compareAndSet(t, n2, n3);
                BytecodeManager.incBytecodes(1);
            } while (!compareAndSet);
            final long n4 = value;
            BytecodeManager.incBytecodes(2);
            return n4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public long getAndAdd(final T t, final long n) {
        try {
            boolean compareAndSet;
            long value;
            do {
                BytecodeManager.incBytecodes(3);
                value = this.get(t);
                BytecodeManager.incBytecodes(1);
                final long n2 = value + n;
                BytecodeManager.incBytecodes(4);
                final long n3 = value;
                final long n4 = n2;
                BytecodeManager.incBytecodes(5);
                compareAndSet = this.compareAndSet(t, n3, n4);
                BytecodeManager.incBytecodes(1);
            } while (!compareAndSet);
            final long n5 = value;
            BytecodeManager.incBytecodes(2);
            return n5;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public long incrementAndGet(final T t) {
        try {
            boolean compareAndSet;
            long n;
            do {
                BytecodeManager.incBytecodes(3);
                final long value = this.get(t);
                BytecodeManager.incBytecodes(1);
                n = value + 1L;
                BytecodeManager.incBytecodes(4);
                final long n2 = value;
                final long n3 = n;
                BytecodeManager.incBytecodes(5);
                compareAndSet = this.compareAndSet(t, n2, n3);
                BytecodeManager.incBytecodes(1);
            } while (!compareAndSet);
            final long n4 = n;
            BytecodeManager.incBytecodes(2);
            return n4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public long decrementAndGet(final T t) {
        try {
            boolean compareAndSet;
            long n;
            do {
                BytecodeManager.incBytecodes(3);
                final long value = this.get(t);
                BytecodeManager.incBytecodes(1);
                n = value - 1L;
                BytecodeManager.incBytecodes(4);
                final long n2 = value;
                final long n3 = n;
                BytecodeManager.incBytecodes(5);
                compareAndSet = this.compareAndSet(t, n2, n3);
                BytecodeManager.incBytecodes(1);
            } while (!compareAndSet);
            final long n4 = n;
            BytecodeManager.incBytecodes(2);
            return n4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public long addAndGet(final T t, final long n) {
        try {
            boolean compareAndSet;
            long n2;
            do {
                BytecodeManager.incBytecodes(3);
                final long value = this.get(t);
                BytecodeManager.incBytecodes(1);
                n2 = value + n;
                BytecodeManager.incBytecodes(4);
                final long n3 = value;
                final long n4 = n2;
                BytecodeManager.incBytecodes(5);
                compareAndSet = this.compareAndSet(t, n3, n4);
                BytecodeManager.incBytecodes(1);
            } while (!compareAndSet);
            final long n5 = n2;
            BytecodeManager.incBytecodes(2);
            return n5;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final long getAndUpdate(final T t, final LongUnaryOperator longUnaryOperator) {
        try {
            boolean compareAndSet;
            long value;
            do {
                BytecodeManager.incBytecodes(3);
                value = this.get(t);
                BytecodeManager.incBytecodes(1);
                final long n = value;
                BytecodeManager.incBytecodes(3);
                final long applyAsLong = longUnaryOperator.applyAsLong(n);
                BytecodeManager.incBytecodes(1);
                final long n2 = value;
                final long n3 = applyAsLong;
                BytecodeManager.incBytecodes(5);
                compareAndSet = this.compareAndSet(t, n2, n3);
                BytecodeManager.incBytecodes(1);
            } while (!compareAndSet);
            final long n4 = value;
            BytecodeManager.incBytecodes(2);
            return n4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final long updateAndGet(final T t, final LongUnaryOperator longUnaryOperator) {
        try {
            boolean compareAndSet;
            long applyAsLong;
            do {
                BytecodeManager.incBytecodes(3);
                final long value = this.get(t);
                BytecodeManager.incBytecodes(1);
                final long n = value;
                BytecodeManager.incBytecodes(3);
                applyAsLong = longUnaryOperator.applyAsLong(n);
                BytecodeManager.incBytecodes(1);
                final long n2 = value;
                final long n3 = applyAsLong;
                BytecodeManager.incBytecodes(5);
                compareAndSet = this.compareAndSet(t, n2, n3);
                BytecodeManager.incBytecodes(1);
            } while (!compareAndSet);
            final long n4 = applyAsLong;
            BytecodeManager.incBytecodes(2);
            return n4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final long getAndAccumulate(final T t, final long n, final LongBinaryOperator longBinaryOperator) {
        try {
            boolean compareAndSet;
            long value;
            do {
                BytecodeManager.incBytecodes(3);
                value = this.get(t);
                BytecodeManager.incBytecodes(1);
                final long n2 = value;
                BytecodeManager.incBytecodes(4);
                final long applyAsLong = longBinaryOperator.applyAsLong(n2, n);
                BytecodeManager.incBytecodes(1);
                final long n3 = value;
                final long n4 = applyAsLong;
                BytecodeManager.incBytecodes(5);
                compareAndSet = this.compareAndSet(t, n3, n4);
                BytecodeManager.incBytecodes(1);
            } while (!compareAndSet);
            final long n5 = value;
            BytecodeManager.incBytecodes(2);
            return n5;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final long accumulateAndGet(final T t, final long n, final LongBinaryOperator longBinaryOperator) {
        try {
            boolean compareAndSet;
            long applyAsLong;
            do {
                BytecodeManager.incBytecodes(3);
                final long value = this.get(t);
                BytecodeManager.incBytecodes(1);
                final long n2 = value;
                BytecodeManager.incBytecodes(4);
                applyAsLong = longBinaryOperator.applyAsLong(n2, n);
                BytecodeManager.incBytecodes(1);
                final long n3 = value;
                final long n4 = applyAsLong;
                BytecodeManager.incBytecodes(5);
                compareAndSet = this.compareAndSet(t, n3, n4);
                BytecodeManager.incBytecodes(1);
            } while (!compareAndSet);
            final long n5 = applyAsLong;
            BytecodeManager.incBytecodes(2);
            return n5;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
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
    
    private static class CASUpdater<T> extends AtomicLongFieldUpdater<T>
    {
        private static final Unsafe unsafe;
        private final long offset;
        private final Class<T> tclass;
        private final Class<?> cclass;
        
        CASUpdater(final Class<T> p0, final String p1, final Class<?> p2) {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //     6: invokespecial   instrumented/java/util/concurrent/atomic/AtomicLongFieldUpdater.<init>:()V
            //     9: new             Linstrumented/java/util/concurrent/atomic/AtomicLongFieldUpdater$CASUpdater$1;
            //    12: dup            
            //    13: aload_0        
            //    14: aload_1        
            //    15: aload_2        
            //    16: ldc             6
            //    18: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    21: invokespecial   instrumented/java/util/concurrent/atomic/AtomicLongFieldUpdater$CASUpdater$1.<init>:(Linstrumented/java/util/concurrent/atomic/AtomicLongFieldUpdater$CASUpdater;Ljava/lang/Class;Ljava/lang/String;)V
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
            //   150: invokestatic    instrumented/java/util/concurrent/atomic/AtomicLongFieldUpdater.access$000:(Ljava/lang/ClassLoader;Ljava/lang/ClassLoader;)Z
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
            //   259: getstatic       java/lang/Long.TYPE:Ljava/lang/Class;
            //   262: ldc             3
            //   264: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   267: if_acmpeq       290
            //   270: new             Ljava/lang/IllegalArgumentException;
            //   273: dup            
            //   274: ldc             "Must be long type"
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
            //   372: putfield        instrumented/java/util/concurrent/atomic/AtomicLongFieldUpdater$CASUpdater.cclass:Ljava/lang/Class;
            //   375: ldc             1
            //   377: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   380: aload_0        
            //   381: aload_1        
            //   382: putfield        instrumented/java/util/concurrent/atomic/AtomicLongFieldUpdater$CASUpdater.tclass:Ljava/lang/Class;
            //   385: ldc             3
            //   387: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   390: aload_0        
            //   391: getstatic       instrumented/java/util/concurrent/atomic/AtomicLongFieldUpdater$CASUpdater.unsafe:Lsun/misc/Unsafe;
            //   394: aload           4
            //   396: ldc             4
            //   398: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   401: invokevirtual   sun/misc/Unsafe.objectFieldOffset:(Ljava/lang/reflect/Field;)J
            //   404: putfield        instrumented/java/util/concurrent/atomic/AtomicLongFieldUpdater$CASUpdater.offset:J
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
        public boolean compareAndSet(final T o, final long expected, final long x) {
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
                final Unsafe unsafe = CASUpdater.unsafe;
                final long offset = this.offset;
                BytecodeManager.incBytecodes(7);
                final boolean compareAndSwapLong = unsafe.compareAndSwapLong(o, offset, expected, x);
                BytecodeManager.incBytecodes(1);
                return compareAndSwapLong;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean weakCompareAndSet(final T o, final long expected, final long x) {
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
                final Unsafe unsafe = CASUpdater.unsafe;
                final long offset = this.offset;
                BytecodeManager.incBytecodes(7);
                final boolean compareAndSwapLong = unsafe.compareAndSwapLong(o, offset, expected, x);
                BytecodeManager.incBytecodes(1);
                return compareAndSwapLong;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void set(final T o, final long x) {
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
                final Unsafe unsafe = CASUpdater.unsafe;
                final long offset = this.offset;
                BytecodeManager.incBytecodes(6);
                unsafe.putLongVolatile(o, offset, x);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void lazySet(final T o, final long x) {
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
                final Unsafe unsafe = CASUpdater.unsafe;
                final long offset = this.offset;
                BytecodeManager.incBytecodes(6);
                unsafe.putOrderedLong(o, offset, x);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public long get(final T o) {
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
                final Unsafe unsafe = CASUpdater.unsafe;
                final long offset = this.offset;
                BytecodeManager.incBytecodes(5);
                final long longVolatile = unsafe.getLongVolatile(o, offset);
                BytecodeManager.incBytecodes(1);
                return longVolatile;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public long getAndSet(final T o, final long newValue) {
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
                final Unsafe unsafe = CASUpdater.unsafe;
                final long offset = this.offset;
                BytecodeManager.incBytecodes(6);
                final long andSetLong = unsafe.getAndSetLong(o, offset, newValue);
                BytecodeManager.incBytecodes(1);
                return andSetLong;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public long getAndIncrement(final T t) {
            try {
                final long n = 1L;
                BytecodeManager.incBytecodes(4);
                final long andAdd = this.getAndAdd(t, n);
                BytecodeManager.incBytecodes(1);
                return andAdd;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public long getAndDecrement(final T t) {
            try {
                final long n = -1L;
                BytecodeManager.incBytecodes(4);
                final long andAdd = this.getAndAdd(t, n);
                BytecodeManager.incBytecodes(1);
                return andAdd;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public long getAndAdd(final T o, final long delta) {
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
                final Unsafe unsafe = CASUpdater.unsafe;
                final long offset = this.offset;
                BytecodeManager.incBytecodes(6);
                final long andAddLong = unsafe.getAndAddLong(o, offset, delta);
                BytecodeManager.incBytecodes(1);
                return andAddLong;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public long incrementAndGet(final T t) {
            try {
                final long n = 1L;
                BytecodeManager.incBytecodes(4);
                final long n2 = this.getAndAdd(t, n) + 1L;
                BytecodeManager.incBytecodes(3);
                return n2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public long decrementAndGet(final T t) {
            try {
                final long n = -1L;
                BytecodeManager.incBytecodes(4);
                final long n2 = this.getAndAdd(t, n) - 1L;
                BytecodeManager.incBytecodes(3);
                return n2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public long addAndGet(final T t, final long n) {
            try {
                BytecodeManager.incBytecodes(4);
                final long n2 = this.getAndAdd(t, n) + n;
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
    
    private static class LockedUpdater<T> extends AtomicLongFieldUpdater<T>
    {
        private static final Unsafe unsafe;
        private final long offset;
        private final Class<T> tclass;
        private final Class<?> cclass;
        
        LockedUpdater(final Class<T> p0, final String p1, final Class<?> p2) {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //     6: invokespecial   instrumented/java/util/concurrent/atomic/AtomicLongFieldUpdater.<init>:()V
            //     9: aconst_null    
            //    10: astore          4
            //    12: ldc             2
            //    14: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    17: iconst_0       
            //    18: istore          5
            //    20: ldc             2
            //    22: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    25: new             Linstrumented/java/util/concurrent/atomic/AtomicLongFieldUpdater$LockedUpdater$1;
            //    28: dup            
            //    29: aload_0        
            //    30: aload_1        
            //    31: aload_2        
            //    32: ldc             6
            //    34: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    37: invokespecial   instrumented/java/util/concurrent/atomic/AtomicLongFieldUpdater$LockedUpdater$1.<init>:(Linstrumented/java/util/concurrent/atomic/AtomicLongFieldUpdater$LockedUpdater;Ljava/lang/Class;Ljava/lang/String;)V
            //    40: ldc             1
            //    42: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    45: invokestatic    java/security/AccessController.doPrivileged:(Ljava/security/PrivilegedExceptionAction;)Ljava/lang/Object;
            //    48: checkcast       Ljava/lang/reflect/Field;
            //    51: astore          4
            //    53: ldc             2
            //    55: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    58: aload           4
            //    60: ldc             2
            //    62: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    65: invokevirtual   java/lang/reflect/Field.getModifiers:()I
            //    68: istore          5
            //    70: ldc             1
            //    72: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    75: aload_3        
            //    76: aload_1        
            //    77: aconst_null    
            //    78: iload           5
            //    80: ldc             5
            //    82: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    85: invokestatic    sun/reflect/misc/ReflectUtil.ensureMemberAccess:(Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Object;I)V
            //    88: aload_1        
            //    89: ldc             2
            //    91: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    94: invokevirtual   java/lang/Class.getClassLoader:()Ljava/lang/ClassLoader;
            //    97: astore          6
            //    99: ldc             1
            //   101: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   104: aload_3        
            //   105: ldc             2
            //   107: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   110: invokevirtual   java/lang/Class.getClassLoader:()Ljava/lang/ClassLoader;
            //   113: astore          7
            //   115: ldc             1
            //   117: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   120: aload           7
            //   122: ldc             2
            //   124: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   127: ifnull          186
            //   130: aload           7
            //   132: aload           6
            //   134: ldc             3
            //   136: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   139: if_acmpeq       186
            //   142: aload           6
            //   144: ldc             2
            //   146: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   149: ifnull          177
            //   152: aload           6
            //   154: aload           7
            //   156: ldc             2
            //   158: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   161: ldc             1
            //   163: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   166: invokestatic    instrumented/java/util/concurrent/atomic/AtomicLongFieldUpdater.access$000:(Ljava/lang/ClassLoader;Ljava/lang/ClassLoader;)Z
            //   169: ldc             1
            //   171: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   174: ifne            186
            //   177: aload_1        
            //   178: ldc             2
            //   180: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   183: invokestatic    sun/reflect/misc/ReflectUtil.checkPackageAccess:(Ljava/lang/Class;)V
            //   186: ldc             1
            //   188: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   191: goto            256
            //   194: astore          6
            //   196: ldc             501
            //   198: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   201: new             Ljava/lang/RuntimeException;
            //   204: dup            
            //   205: aload           6
            //   207: ldc             4
            //   209: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   212: invokevirtual   java/security/PrivilegedActionException.getException:()Ljava/lang/Exception;
            //   215: ldc             1
            //   217: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   220: invokespecial   java/lang/RuntimeException.<init>:(Ljava/lang/Throwable;)V
            //   223: ldc             1
            //   225: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   228: athrow         
            //   229: astore          6
            //   231: ldc             501
            //   233: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   236: new             Ljava/lang/RuntimeException;
            //   239: dup            
            //   240: aload           6
            //   242: ldc             4
            //   244: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   247: invokespecial   java/lang/RuntimeException.<init>:(Ljava/lang/Throwable;)V
            //   250: ldc             1
            //   252: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   255: athrow         
            //   256: aload           4
            //   258: ldc             2
            //   260: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   263: invokevirtual   java/lang/reflect/Field.getType:()Ljava/lang/Class;
            //   266: astore          6
            //   268: ldc             1
            //   270: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   273: aload           6
            //   275: getstatic       java/lang/Long.TYPE:Ljava/lang/Class;
            //   278: ldc             3
            //   280: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   283: if_acmpeq       306
            //   286: new             Ljava/lang/IllegalArgumentException;
            //   289: dup            
            //   290: ldc             "Must be long type"
            //   292: ldc             4
            //   294: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   297: invokespecial   java/lang/IllegalArgumentException.<init>:(Ljava/lang/String;)V
            //   300: ldc             1
            //   302: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   305: athrow         
            //   306: iload           5
            //   308: ldc             2
            //   310: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   313: invokestatic    java/lang/reflect/Modifier.isVolatile:(I)Z
            //   316: ldc             1
            //   318: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   321: ifne            344
            //   324: new             Ljava/lang/IllegalArgumentException;
            //   327: dup            
            //   328: ldc             "Must be volatile type"
            //   330: ldc             4
            //   332: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   335: invokespecial   java/lang/IllegalArgumentException.<init>:(Ljava/lang/String;)V
            //   338: ldc             1
            //   340: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   343: athrow         
            //   344: aload_0        
            //   345: iload           5
            //   347: ldc             3
            //   349: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   352: invokestatic    java/lang/reflect/Modifier.isProtected:(I)Z
            //   355: ldc             1
            //   357: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   360: ifeq            382
            //   363: aload_3        
            //   364: aload_1        
            //   365: ldc             3
            //   367: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   370: if_acmpeq       382
            //   373: aload_3        
            //   374: ldc             2
            //   376: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   379: goto            388
            //   382: aconst_null    
            //   383: ldc             1
            //   385: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   388: putfield        instrumented/java/util/concurrent/atomic/AtomicLongFieldUpdater$LockedUpdater.cclass:Ljava/lang/Class;
            //   391: ldc             1
            //   393: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   396: aload_0        
            //   397: aload_1        
            //   398: putfield        instrumented/java/util/concurrent/atomic/AtomicLongFieldUpdater$LockedUpdater.tclass:Ljava/lang/Class;
            //   401: ldc             3
            //   403: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   406: aload_0        
            //   407: getstatic       instrumented/java/util/concurrent/atomic/AtomicLongFieldUpdater$LockedUpdater.unsafe:Lsun/misc/Unsafe;
            //   410: aload           4
            //   412: ldc             4
            //   414: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   417: invokevirtual   sun/misc/Unsafe.objectFieldOffset:(Ljava/lang/reflect/Field;)J
            //   420: putfield        instrumented/java/util/concurrent/atomic/AtomicLongFieldUpdater$LockedUpdater.offset:J
            //   423: ldc             1
            //   425: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   428: ldc             1
            //   430: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   433: return         
            //   434: athrow         
            //   435: athrow         
            //    Signature:
            //  (Ljava/lang/Class<TT;>;Ljava/lang/String;Ljava/lang/Class<*>;)V
            //    StackMapTable: 00 0B FF 00 B1 00 08 07 00 02 07 00 3E 07 00 49 07 00 3E 07 00 31 01 07 00 4B 07 00 4B 00 00 F9 00 08 47 07 00 18 62 07 00 1A 1A FC 00 31 07 00 3E 25 65 07 00 02 FF 00 05 00 07 07 00 02 07 00 3E 07 00 49 07 00 3E 07 00 31 01 07 00 3E 00 02 07 00 02 07 00 3E FF 00 2D 00 00 00 01 07 00 85 FF 00 00 00 00 00 01 07 00 16
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                                     
            //  -----  -----  -----  -----  -----------------------------------------
            //  25     435    435    436    Ljava/lang/VirtualMachineError;
            //  25     186    194    229    Ljava/security/PrivilegedActionException;
            //  25     186    229    256    Ljava/lang/Exception;
            //  0      434    434    435    Any
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0177:
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
        public boolean compareAndSet(final T p0, final long p1, final long p2) {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: ldc             2
            //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //     6: ifnull          42
            //     9: aload_1        
            //    10: ldc             2
            //    12: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    15: invokevirtual   java/lang/Object.getClass:()Ljava/lang/Class;
            //    18: aload_0        
            //    19: getfield        instrumented/java/util/concurrent/atomic/AtomicLongFieldUpdater$LockedUpdater.tclass:Ljava/lang/Class;
            //    22: ldc             3
            //    24: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    27: if_acmpne       42
            //    30: aload_0        
            //    31: getfield        instrumented/java/util/concurrent/atomic/AtomicLongFieldUpdater$LockedUpdater.cclass:Ljava/lang/Class;
            //    34: ldc             3
            //    36: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    39: ifnull          52
            //    42: aload_0        
            //    43: aload_1        
            //    44: ldc             3
            //    46: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    49: invokespecial   instrumented/java/util/concurrent/atomic/AtomicLongFieldUpdater$LockedUpdater.fullCheck:(Ljava/lang/Object;)V
            //    52: aload_0        
            //    53: dup            
            //    54: astore          6
            //    56: pop            
            //    57: ldc             4
            //    59: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    62: getstatic       instrumented/java/util/concurrent/atomic/AtomicLongFieldUpdater$LockedUpdater.unsafe:Lsun/misc/Unsafe;
            //    65: aload_1        
            //    66: aload_0        
            //    67: getfield        instrumented/java/util/concurrent/atomic/AtomicLongFieldUpdater$LockedUpdater.offset:J
            //    70: ldc             5
            //    72: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    75: invokevirtual   sun/misc/Unsafe.getLong:(Ljava/lang/Object;J)J
            //    78: lstore          7
            //    80: ldc             1
            //    82: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    85: lload           7
            //    87: lload_2        
            //    88: lcmp           
            //    89: ldc             4
            //    91: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    94: ifeq            112
            //    97: iconst_0       
            //    98: aload           6
            //   100: pop            
            //   101: ldc             3
            //   103: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   106: ldc             1
            //   108: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   111: ireturn        
            //   112: getstatic       instrumented/java/util/concurrent/atomic/AtomicLongFieldUpdater$LockedUpdater.unsafe:Lsun/misc/Unsafe;
            //   115: aload_1        
            //   116: aload_0        
            //   117: getfield        instrumented/java/util/concurrent/atomic/AtomicLongFieldUpdater$LockedUpdater.offset:J
            //   120: lload           4
            //   122: ldc             6
            //   124: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   127: invokevirtual   sun/misc/Unsafe.putLong:(Ljava/lang/Object;JJ)V
            //   130: iconst_1       
            //   131: aload           6
            //   133: pop            
            //   134: ldc             3
            //   136: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   139: ldc             1
            //   141: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   144: ireturn        
            //   145: astore          9
            //   147: aload           6
            //   149: pop            
            //   150: ldc             503
            //   152: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   155: aload           9
            //   157: ldc             2
            //   159: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   162: athrow         
            //   163: athrow         
            //   164: athrow         
            //    Signature:
            //  (TT;JJ)Z
            //    StackMapTable: 00 06 2A 09 FD 00 3B 07 00 95 04 FF 00 20 00 05 07 00 02 07 00 95 04 04 07 00 95 00 01 07 00 85 FF 00 11 00 00 00 01 07 00 85 FF 00 00 00 00 00 01 07 00 16
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                           
            //  -----  -----  -----  -----  -------------------------------
            //  62     164    164    165    Ljava/lang/VirtualMachineError;
            //  62     106    145    163    Any
            //  112    139    145    163    Any
            //  145    155    145    163    Any
            //  0      163    163    164    Any
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0112:
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
        public boolean weakCompareAndSet(final T t, final long n, final long n2) {
            try {
                BytecodeManager.incBytecodes(5);
                final boolean compareAndSet = this.compareAndSet(t, n, n2);
                BytecodeManager.incBytecodes(1);
                return compareAndSet;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void set(final T p0, final long p1) {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: ldc             2
            //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //     6: ifnull          42
            //     9: aload_1        
            //    10: ldc             2
            //    12: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    15: invokevirtual   java/lang/Object.getClass:()Ljava/lang/Class;
            //    18: aload_0        
            //    19: getfield        instrumented/java/util/concurrent/atomic/AtomicLongFieldUpdater$LockedUpdater.tclass:Ljava/lang/Class;
            //    22: ldc             3
            //    24: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    27: if_acmpne       42
            //    30: aload_0        
            //    31: getfield        instrumented/java/util/concurrent/atomic/AtomicLongFieldUpdater$LockedUpdater.cclass:Ljava/lang/Class;
            //    34: ldc             3
            //    36: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    39: ifnull          52
            //    42: aload_0        
            //    43: aload_1        
            //    44: ldc             3
            //    46: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    49: invokespecial   instrumented/java/util/concurrent/atomic/AtomicLongFieldUpdater$LockedUpdater.fullCheck:(Ljava/lang/Object;)V
            //    52: aload_0        
            //    53: dup            
            //    54: astore          4
            //    56: pop            
            //    57: ldc             4
            //    59: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    62: getstatic       instrumented/java/util/concurrent/atomic/AtomicLongFieldUpdater$LockedUpdater.unsafe:Lsun/misc/Unsafe;
            //    65: aload_1        
            //    66: aload_0        
            //    67: getfield        instrumented/java/util/concurrent/atomic/AtomicLongFieldUpdater$LockedUpdater.offset:J
            //    70: lload_2        
            //    71: ldc             6
            //    73: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    76: invokevirtual   sun/misc/Unsafe.putLong:(Ljava/lang/Object;JJ)V
            //    79: aload           4
            //    81: pop            
            //    82: ldc             2
            //    84: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    87: ldc             1
            //    89: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    92: goto            113
            //    95: astore          5
            //    97: aload           4
            //    99: pop            
            //   100: ldc             503
            //   102: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   105: aload           5
            //   107: ldc             2
            //   109: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   112: athrow         
            //   113: ldc             1
            //   115: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   118: return         
            //   119: athrow         
            //   120: athrow         
            //    Signature:
            //  (TT;J)V
            //    StackMapTable: 00 06 2A 09 FF 00 2A 00 04 07 00 02 07 00 95 04 07 00 95 00 01 07 00 85 FA 00 11 FF 00 05 00 00 00 01 07 00 85 FF 00 00 00 00 00 01 07 00 16
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                           
            //  -----  -----  -----  -----  -------------------------------
            //  62     120    120    121    Ljava/lang/VirtualMachineError;
            //  62     87     95     113    Any
            //  95     105    95     113    Any
            //  0      119    119    120    Any
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0113:
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
        public void lazySet(final T t, final long n) {
            try {
                BytecodeManager.incBytecodes(4);
                this.set(t, n);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public long get(final T t) {
            try {
                BytecodeManager.incBytecodes(2);
                Label_0052: {
                    if (t != null) {
                        BytecodeManager.incBytecodes(2);
                        final Class<?> class1 = t.getClass();
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
                    this.fullCheck(t);
                }
                BytecodeManager.incBytecodes(4);
                try {
                    final Unsafe unsafe = LockedUpdater.unsafe;
                    final T t2 = t;
                    final LockedUpdater lockedUpdater = this;
                    final long n = lockedUpdater.offset;
                    final int n2 = 5;
                    BytecodeManager.incBytecodes(n2);
                    final long n3 = unsafe.getLong(t2, n);
                    final int n4 = 2;
                    BytecodeManager.incBytecodes(n4);
                    final int n5 = 1;
                    BytecodeManager.incBytecodes(n5);
                    return n3;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final Unsafe unsafe = LockedUpdater.unsafe;
                final T t2 = t;
                final LockedUpdater lockedUpdater = this;
                final long n = lockedUpdater.offset;
                final int n2 = 5;
                BytecodeManager.incBytecodes(n2);
                final long n3 = unsafe.getLong(t2, n);
                final int n4 = 2;
                BytecodeManager.incBytecodes(n4);
                final int n5 = 1;
                BytecodeManager.incBytecodes(n5);
                return n3;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
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
