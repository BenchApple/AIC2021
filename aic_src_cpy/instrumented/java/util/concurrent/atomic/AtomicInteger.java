// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.concurrent.atomic;

import instrumented.java.util.function.IntBinaryOperator;
import instrumented.java.util.function.IntUnaryOperator;
import aic2021.engine.BytecodeManager;
import sun.misc.Unsafe;
import java.io.Serializable;

public class AtomicInteger extends Number implements Serializable
{
    private static final long serialVersionUID = 6214790243416807050L;
    private static final Unsafe unsafe;
    private static final long valueOffset;
    private volatile int value;
    
    public AtomicInteger(final int value) {
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
    
    public AtomicInteger() {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final int get() {
        try {
            final int value = this.value;
            BytecodeManager.incBytecodes(3);
            return value;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final void set(final int value) {
        try {
            this.value = value;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final void lazySet(final int x) {
        try {
            final Unsafe unsafe = AtomicInteger.unsafe;
            final long valueOffset = AtomicInteger.valueOffset;
            BytecodeManager.incBytecodes(5);
            unsafe.putOrderedInt(this, valueOffset, x);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final int getAndSet(final int newValue) {
        try {
            final Unsafe unsafe = AtomicInteger.unsafe;
            final long valueOffset = AtomicInteger.valueOffset;
            BytecodeManager.incBytecodes(5);
            final int andSetInt = unsafe.getAndSetInt(this, valueOffset, newValue);
            BytecodeManager.incBytecodes(1);
            return andSetInt;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final boolean compareAndSet(final int expected, final int x) {
        try {
            final Unsafe unsafe = AtomicInteger.unsafe;
            final long valueOffset = AtomicInteger.valueOffset;
            BytecodeManager.incBytecodes(6);
            final boolean compareAndSwapInt = unsafe.compareAndSwapInt(this, valueOffset, expected, x);
            BytecodeManager.incBytecodes(1);
            return compareAndSwapInt;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final boolean weakCompareAndSet(final int expected, final int x) {
        try {
            final Unsafe unsafe = AtomicInteger.unsafe;
            final long valueOffset = AtomicInteger.valueOffset;
            BytecodeManager.incBytecodes(6);
            final boolean compareAndSwapInt = unsafe.compareAndSwapInt(this, valueOffset, expected, x);
            BytecodeManager.incBytecodes(1);
            return compareAndSwapInt;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final int getAndIncrement() {
        try {
            final Unsafe unsafe = AtomicInteger.unsafe;
            final long valueOffset = AtomicInteger.valueOffset;
            final int delta = 1;
            BytecodeManager.incBytecodes(5);
            final int andAddInt = unsafe.getAndAddInt(this, valueOffset, delta);
            BytecodeManager.incBytecodes(1);
            return andAddInt;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final int getAndDecrement() {
        try {
            final Unsafe unsafe = AtomicInteger.unsafe;
            final long valueOffset = AtomicInteger.valueOffset;
            final int delta = -1;
            BytecodeManager.incBytecodes(5);
            final int andAddInt = unsafe.getAndAddInt(this, valueOffset, delta);
            BytecodeManager.incBytecodes(1);
            return andAddInt;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final int getAndAdd(final int delta) {
        try {
            final Unsafe unsafe = AtomicInteger.unsafe;
            final long valueOffset = AtomicInteger.valueOffset;
            BytecodeManager.incBytecodes(5);
            final int andAddInt = unsafe.getAndAddInt(this, valueOffset, delta);
            BytecodeManager.incBytecodes(1);
            return andAddInt;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final int incrementAndGet() {
        try {
            final Unsafe unsafe = AtomicInteger.unsafe;
            final long valueOffset = AtomicInteger.valueOffset;
            final int delta = 1;
            BytecodeManager.incBytecodes(5);
            final int n = unsafe.getAndAddInt(this, valueOffset, delta) + 1;
            BytecodeManager.incBytecodes(3);
            return n;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final int decrementAndGet() {
        try {
            final Unsafe unsafe = AtomicInteger.unsafe;
            final long valueOffset = AtomicInteger.valueOffset;
            final int delta = -1;
            BytecodeManager.incBytecodes(5);
            final int n = unsafe.getAndAddInt(this, valueOffset, delta) - 1;
            BytecodeManager.incBytecodes(3);
            return n;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final int addAndGet(final int delta) {
        try {
            final Unsafe unsafe = AtomicInteger.unsafe;
            final long valueOffset = AtomicInteger.valueOffset;
            BytecodeManager.incBytecodes(5);
            final int n = unsafe.getAndAddInt(this, valueOffset, delta) + delta;
            BytecodeManager.incBytecodes(3);
            return n;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final int getAndUpdate(final IntUnaryOperator intUnaryOperator) {
        try {
            boolean compareAndSet;
            int value;
            do {
                BytecodeManager.incBytecodes(2);
                value = this.get();
                BytecodeManager.incBytecodes(1);
                final int n = value;
                BytecodeManager.incBytecodes(3);
                final int applyAsInt = intUnaryOperator.applyAsInt(n);
                BytecodeManager.incBytecodes(1);
                final int n2 = value;
                final int n3 = applyAsInt;
                BytecodeManager.incBytecodes(4);
                compareAndSet = this.compareAndSet(n2, n3);
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
    
    public final int updateAndGet(final IntUnaryOperator intUnaryOperator) {
        try {
            boolean compareAndSet;
            int applyAsInt;
            do {
                BytecodeManager.incBytecodes(2);
                final int value = this.get();
                BytecodeManager.incBytecodes(1);
                final int n = value;
                BytecodeManager.incBytecodes(3);
                applyAsInt = intUnaryOperator.applyAsInt(n);
                BytecodeManager.incBytecodes(1);
                final int n2 = value;
                final int n3 = applyAsInt;
                BytecodeManager.incBytecodes(4);
                compareAndSet = this.compareAndSet(n2, n3);
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
    
    public final int getAndAccumulate(final int n, final IntBinaryOperator intBinaryOperator) {
        try {
            boolean compareAndSet;
            int value;
            do {
                BytecodeManager.incBytecodes(2);
                value = this.get();
                BytecodeManager.incBytecodes(1);
                final int n2 = value;
                BytecodeManager.incBytecodes(4);
                final int applyAsInt = intBinaryOperator.applyAsInt(n2, n);
                BytecodeManager.incBytecodes(1);
                final int n3 = value;
                final int n4 = applyAsInt;
                BytecodeManager.incBytecodes(4);
                compareAndSet = this.compareAndSet(n3, n4);
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
    
    public final int accumulateAndGet(final int n, final IntBinaryOperator intBinaryOperator) {
        try {
            boolean compareAndSet;
            int applyAsInt;
            do {
                BytecodeManager.incBytecodes(2);
                final int value = this.get();
                BytecodeManager.incBytecodes(1);
                final int n2 = value;
                BytecodeManager.incBytecodes(4);
                applyAsInt = intBinaryOperator.applyAsInt(n2, n);
                BytecodeManager.incBytecodes(1);
                final int n3 = value;
                final int n4 = applyAsInt;
                BytecodeManager.incBytecodes(4);
                compareAndSet = this.compareAndSet(n3, n4);
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
    
    @Override
    public String toString() {
        try {
            BytecodeManager.incBytecodes(2);
            final int value = this.get();
            BytecodeManager.incBytecodes(1);
            final String string = Integer.toString(value);
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
            final int value = this.get();
            BytecodeManager.incBytecodes(1);
            return value;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public long longValue() {
        try {
            BytecodeManager.incBytecodes(2);
            final long n = this.get();
            BytecodeManager.incBytecodes(2);
            return n;
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
            final double n = this.get();
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
        //     8: putstatic       instrumented/java/util/concurrent/atomic/AtomicInteger.unsafe:Lsun/misc/Unsafe;
        //    11: ldc             1
        //    13: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    16: getstatic       instrumented/java/util/concurrent/atomic/AtomicInteger.unsafe:Lsun/misc/Unsafe;
        //    19: ldc             Linstrumented/java/util/concurrent/atomic/AtomicInteger;.class
        //    21: ldc             "value"
        //    23: ldc             3
        //    25: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    28: ldc             1
        //    30: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    33: invokevirtual   java/lang/Class.getDeclaredField:(Ljava/lang/String;)Ljava/lang/reflect/Field;
        //    36: ldc             1
        //    38: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    41: invokevirtual   sun/misc/Unsafe.objectFieldOffset:(Ljava/lang/reflect/Field;)J
        //    44: putstatic       instrumented/java/util/concurrent/atomic/AtomicInteger.valueOffset:J
        //    47: ldc             1
        //    49: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    52: ldc             1
        //    54: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    57: goto            80
        //    60: astore_0       
        //    61: new             Ljava/lang/Error;
        //    64: dup            
        //    65: aload_0        
        //    66: ldc             505
        //    68: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    71: invokespecial   java/lang/Error.<init>:(Ljava/lang/Throwable;)V
        //    74: ldc             1
        //    76: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    79: athrow         
        //    80: ldc             1
        //    82: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    85: return         
        //    86: athrow         
        //    87: athrow         
        //    StackMapTable: 00 04 7C 07 00 6F 13 FF 00 05 00 00 00 01 07 00 21 FF 00 00 00 00 00 01 07 00 6D
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  16     87     87     88     Ljava/lang/VirtualMachineError;
        //  16     52     60     80     Ljava/lang/Exception;
        //  0      86     86     87     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0080:
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
