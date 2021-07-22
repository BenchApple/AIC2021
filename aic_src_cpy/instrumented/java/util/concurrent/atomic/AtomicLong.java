// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.concurrent.atomic;

import instrumented.java.util.function.LongBinaryOperator;
import instrumented.java.util.function.LongUnaryOperator;
import aic2021.engine.BytecodeManager;
import sun.misc.Unsafe;
import java.io.Serializable;

public class AtomicLong extends Number implements Serializable
{
    private static final long serialVersionUID = 1927816293512124184L;
    private static final Unsafe unsafe;
    private static final long valueOffset;
    static final boolean VM_SUPPORTS_LONG_CAS;
    private volatile long value;
    
    private static native boolean VMSupportsCS8();
    
    public AtomicLong(final long value) {
        try {
            BytecodeManager.incBytecodes(2);
            this.value = value;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public AtomicLong() {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final long get() {
        try {
            final long value = this.value;
            BytecodeManager.incBytecodes(3);
            return value;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final void set(final long value) {
        try {
            this.value = value;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final void lazySet(final long x) {
        try {
            final Unsafe unsafe = AtomicLong.unsafe;
            final long valueOffset = AtomicLong.valueOffset;
            BytecodeManager.incBytecodes(5);
            unsafe.putOrderedLong(this, valueOffset, x);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final long getAndSet(final long newValue) {
        try {
            final Unsafe unsafe = AtomicLong.unsafe;
            final long valueOffset = AtomicLong.valueOffset;
            BytecodeManager.incBytecodes(5);
            final long andSetLong = unsafe.getAndSetLong(this, valueOffset, newValue);
            BytecodeManager.incBytecodes(1);
            return andSetLong;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final boolean compareAndSet(final long expected, final long x) {
        try {
            final Unsafe unsafe = AtomicLong.unsafe;
            final long valueOffset = AtomicLong.valueOffset;
            BytecodeManager.incBytecodes(6);
            final boolean compareAndSwapLong = unsafe.compareAndSwapLong(this, valueOffset, expected, x);
            BytecodeManager.incBytecodes(1);
            return compareAndSwapLong;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final boolean weakCompareAndSet(final long expected, final long x) {
        try {
            final Unsafe unsafe = AtomicLong.unsafe;
            final long valueOffset = AtomicLong.valueOffset;
            BytecodeManager.incBytecodes(6);
            final boolean compareAndSwapLong = unsafe.compareAndSwapLong(this, valueOffset, expected, x);
            BytecodeManager.incBytecodes(1);
            return compareAndSwapLong;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final long getAndIncrement() {
        try {
            final Unsafe unsafe = AtomicLong.unsafe;
            final long valueOffset = AtomicLong.valueOffset;
            final long delta = 1L;
            BytecodeManager.incBytecodes(5);
            final long andAddLong = unsafe.getAndAddLong(this, valueOffset, delta);
            BytecodeManager.incBytecodes(1);
            return andAddLong;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final long getAndDecrement() {
        try {
            final Unsafe unsafe = AtomicLong.unsafe;
            final long valueOffset = AtomicLong.valueOffset;
            final long delta = -1L;
            BytecodeManager.incBytecodes(5);
            final long andAddLong = unsafe.getAndAddLong(this, valueOffset, delta);
            BytecodeManager.incBytecodes(1);
            return andAddLong;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final long getAndAdd(final long delta) {
        try {
            final Unsafe unsafe = AtomicLong.unsafe;
            final long valueOffset = AtomicLong.valueOffset;
            BytecodeManager.incBytecodes(5);
            final long andAddLong = unsafe.getAndAddLong(this, valueOffset, delta);
            BytecodeManager.incBytecodes(1);
            return andAddLong;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final long incrementAndGet() {
        try {
            final Unsafe unsafe = AtomicLong.unsafe;
            final long valueOffset = AtomicLong.valueOffset;
            final long delta = 1L;
            BytecodeManager.incBytecodes(5);
            final long n = unsafe.getAndAddLong(this, valueOffset, delta) + 1L;
            BytecodeManager.incBytecodes(3);
            return n;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final long decrementAndGet() {
        try {
            final Unsafe unsafe = AtomicLong.unsafe;
            final long valueOffset = AtomicLong.valueOffset;
            final long delta = -1L;
            BytecodeManager.incBytecodes(5);
            final long n = unsafe.getAndAddLong(this, valueOffset, delta) - 1L;
            BytecodeManager.incBytecodes(3);
            return n;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final long addAndGet(final long delta) {
        try {
            final Unsafe unsafe = AtomicLong.unsafe;
            final long valueOffset = AtomicLong.valueOffset;
            BytecodeManager.incBytecodes(5);
            final long n = unsafe.getAndAddLong(this, valueOffset, delta) + delta;
            BytecodeManager.incBytecodes(3);
            return n;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final long getAndUpdate(final LongUnaryOperator longUnaryOperator) {
        try {
            boolean compareAndSet;
            long value;
            do {
                BytecodeManager.incBytecodes(2);
                value = this.get();
                BytecodeManager.incBytecodes(1);
                final long n = value;
                BytecodeManager.incBytecodes(3);
                final long applyAsLong = longUnaryOperator.applyAsLong(n);
                BytecodeManager.incBytecodes(1);
                final long n2 = value;
                final long n3 = applyAsLong;
                BytecodeManager.incBytecodes(4);
                compareAndSet = this.compareAndSet(n2, n3);
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
    
    public final long updateAndGet(final LongUnaryOperator longUnaryOperator) {
        try {
            boolean compareAndSet;
            long applyAsLong;
            do {
                BytecodeManager.incBytecodes(2);
                final long value = this.get();
                BytecodeManager.incBytecodes(1);
                final long n = value;
                BytecodeManager.incBytecodes(3);
                applyAsLong = longUnaryOperator.applyAsLong(n);
                BytecodeManager.incBytecodes(1);
                final long n2 = value;
                final long n3 = applyAsLong;
                BytecodeManager.incBytecodes(4);
                compareAndSet = this.compareAndSet(n2, n3);
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
    
    public final long getAndAccumulate(final long n, final LongBinaryOperator longBinaryOperator) {
        try {
            boolean compareAndSet;
            long value;
            do {
                BytecodeManager.incBytecodes(2);
                value = this.get();
                BytecodeManager.incBytecodes(1);
                final long n2 = value;
                BytecodeManager.incBytecodes(4);
                final long applyAsLong = longBinaryOperator.applyAsLong(n2, n);
                BytecodeManager.incBytecodes(1);
                final long n3 = value;
                final long n4 = applyAsLong;
                BytecodeManager.incBytecodes(4);
                compareAndSet = this.compareAndSet(n3, n4);
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
    
    public final long accumulateAndGet(final long n, final LongBinaryOperator longBinaryOperator) {
        try {
            boolean compareAndSet;
            long applyAsLong;
            do {
                BytecodeManager.incBytecodes(2);
                final long value = this.get();
                BytecodeManager.incBytecodes(1);
                final long n2 = value;
                BytecodeManager.incBytecodes(4);
                applyAsLong = longBinaryOperator.applyAsLong(n2, n);
                BytecodeManager.incBytecodes(1);
                final long n3 = value;
                final long n4 = applyAsLong;
                BytecodeManager.incBytecodes(4);
                compareAndSet = this.compareAndSet(n3, n4);
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
    
    @Override
    public String toString() {
        try {
            BytecodeManager.incBytecodes(2);
            final long value = this.get();
            BytecodeManager.incBytecodes(1);
            final String string = Long.toString(value);
            BytecodeManager.incBytecodes(1);
            return string;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public int intValue() {
        try {
            BytecodeManager.incBytecodes(2);
            final int n = (int)this.get();
            BytecodeManager.incBytecodes(2);
            return n;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public long longValue() {
        try {
            BytecodeManager.incBytecodes(2);
            final long value = this.get();
            BytecodeManager.incBytecodes(1);
            return value;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public float floatValue() {
        try {
            BytecodeManager.incBytecodes(2);
            final float n = (float)this.get();
            BytecodeManager.incBytecodes(2);
            return n;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public double doubleValue() {
        try {
            BytecodeManager.incBytecodes(2);
            final double n = (double)this.get();
            BytecodeManager.incBytecodes(2);
            return n;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     2: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     5: invokestatic    sun/misc/Unsafe.getUnsafe:()Lsun/misc/Unsafe;
        //     8: putstatic       instrumented/java/util/concurrent/atomic/AtomicLong.unsafe:Lsun/misc/Unsafe;
        //    11: ldc             1
        //    13: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    16: ldc             1
        //    18: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    21: invokestatic    instrumented/java/util/concurrent/atomic/AtomicLong.VMSupportsCS8:()Z
        //    24: putstatic       instrumented/java/util/concurrent/atomic/AtomicLong.VM_SUPPORTS_LONG_CAS:Z
        //    27: ldc             1
        //    29: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    32: getstatic       instrumented/java/util/concurrent/atomic/AtomicLong.unsafe:Lsun/misc/Unsafe;
        //    35: ldc             Linstrumented/java/util/concurrent/atomic/AtomicLong;.class
        //    37: ldc             "value"
        //    39: ldc             3
        //    41: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    44: ldc             1
        //    46: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    49: invokevirtual   java/lang/Class.getDeclaredField:(Ljava/lang/String;)Ljava/lang/reflect/Field;
        //    52: ldc             1
        //    54: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    57: invokevirtual   sun/misc/Unsafe.objectFieldOffset:(Ljava/lang/reflect/Field;)J
        //    60: putstatic       instrumented/java/util/concurrent/atomic/AtomicLong.valueOffset:J
        //    63: ldc             1
        //    65: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    68: ldc             1
        //    70: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    73: goto            96
        //    76: astore_0       
        //    77: new             Ljava/lang/Error;
        //    80: dup            
        //    81: aload_0        
        //    82: ldc             505
        //    84: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    87: invokespecial   java/lang/Error.<init>:(Ljava/lang/Throwable;)V
        //    90: ldc             1
        //    92: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    95: athrow         
        //    96: ldc             1
        //    98: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   101: return         
        //   102: athrow         
        //   103: athrow         
        //    StackMapTable: 00 04 F7 00 4C 07 00 75 13 FF 00 05 00 00 00 01 07 00 25 FF 00 00 00 00 00 01 07 00 73
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  32     103    103    104    Ljava/lang/VirtualMachineError;
        //  32     68     76     96     Ljava/lang/Exception;
        //  0      102    102    103    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0096:
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
}
