// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.concurrent.atomic;

import instrumented.java.util.function.BinaryOperator;
import instrumented.java.util.function.UnaryOperator;
import aic2021.engine.BytecodeManager;
import sun.misc.Unsafe;
import java.io.Serializable;

public class AtomicReference<V> implements Serializable
{
    private static final long serialVersionUID = -1848883965231344442L;
    private static final Unsafe unsafe;
    private static final long valueOffset;
    private volatile V value;
    
    public AtomicReference(final V value) {
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
    
    public AtomicReference() {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final V get() {
        try {
            final V value = this.value;
            BytecodeManager.incBytecodes(3);
            return value;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final void set(final V value) {
        try {
            this.value = value;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final void lazySet(final V x) {
        try {
            final Unsafe unsafe = AtomicReference.unsafe;
            final long valueOffset = AtomicReference.valueOffset;
            BytecodeManager.incBytecodes(5);
            unsafe.putOrderedObject(this, valueOffset, x);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final boolean compareAndSet(final V expected, final V x) {
        try {
            final Unsafe unsafe = AtomicReference.unsafe;
            final long valueOffset = AtomicReference.valueOffset;
            BytecodeManager.incBytecodes(6);
            final boolean compareAndSwapObject = unsafe.compareAndSwapObject(this, valueOffset, expected, x);
            BytecodeManager.incBytecodes(1);
            return compareAndSwapObject;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final boolean weakCompareAndSet(final V expected, final V x) {
        try {
            final Unsafe unsafe = AtomicReference.unsafe;
            final long valueOffset = AtomicReference.valueOffset;
            BytecodeManager.incBytecodes(6);
            final boolean compareAndSwapObject = unsafe.compareAndSwapObject(this, valueOffset, expected, x);
            BytecodeManager.incBytecodes(1);
            return compareAndSwapObject;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final V getAndSet(final V newValue) {
        try {
            final Unsafe unsafe = AtomicReference.unsafe;
            final long valueOffset = AtomicReference.valueOffset;
            BytecodeManager.incBytecodes(5);
            final Object andSetObject = unsafe.getAndSetObject(this, valueOffset, newValue);
            BytecodeManager.incBytecodes(1);
            return (V)andSetObject;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final V getAndUpdate(final UnaryOperator<V> unaryOperator) {
        try {
            boolean compareAndSet;
            V value;
            do {
                BytecodeManager.incBytecodes(2);
                value = this.get();
                BytecodeManager.incBytecodes(1);
                final V v = value;
                BytecodeManager.incBytecodes(3);
                final Object apply = unaryOperator.apply(v);
                BytecodeManager.incBytecodes(1);
                final V v2 = value;
                final Object o = apply;
                BytecodeManager.incBytecodes(4);
                compareAndSet = this.compareAndSet(v2, (V)o);
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
    
    public final V updateAndGet(final UnaryOperator<V> unaryOperator) {
        try {
            boolean compareAndSet;
            Object apply;
            do {
                BytecodeManager.incBytecodes(2);
                final V value = this.get();
                BytecodeManager.incBytecodes(1);
                final V v = value;
                BytecodeManager.incBytecodes(3);
                apply = unaryOperator.apply(v);
                BytecodeManager.incBytecodes(1);
                final V v2 = value;
                final Object o = apply;
                BytecodeManager.incBytecodes(4);
                compareAndSet = this.compareAndSet(v2, (V)o);
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
    
    public final V getAndAccumulate(final V v, final BinaryOperator<V> binaryOperator) {
        try {
            boolean compareAndSet;
            V value;
            do {
                BytecodeManager.incBytecodes(2);
                value = this.get();
                BytecodeManager.incBytecodes(1);
                final V v2 = value;
                BytecodeManager.incBytecodes(4);
                final Object apply = binaryOperator.apply(v2, v);
                BytecodeManager.incBytecodes(1);
                final V v3 = value;
                final Object o = apply;
                BytecodeManager.incBytecodes(4);
                compareAndSet = this.compareAndSet(v3, (V)o);
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
    
    public final V accumulateAndGet(final V v, final BinaryOperator<V> binaryOperator) {
        try {
            boolean compareAndSet;
            Object apply;
            do {
                BytecodeManager.incBytecodes(2);
                final V value = this.get();
                BytecodeManager.incBytecodes(1);
                final V v2 = value;
                BytecodeManager.incBytecodes(4);
                apply = binaryOperator.apply(v2, v);
                BytecodeManager.incBytecodes(1);
                final V v3 = value;
                final Object o = apply;
                BytecodeManager.incBytecodes(4);
                compareAndSet = this.compareAndSet(v3, (V)o);
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
    
    @Override
    public String toString() {
        try {
            BytecodeManager.incBytecodes(2);
            final V value = this.get();
            BytecodeManager.incBytecodes(1);
            final String value2 = String.valueOf(value);
            BytecodeManager.incBytecodes(1);
            return value2;
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
        //     8: putstatic       instrumented/java/util/concurrent/atomic/AtomicReference.unsafe:Lsun/misc/Unsafe;
        //    11: ldc             1
        //    13: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    16: getstatic       instrumented/java/util/concurrent/atomic/AtomicReference.unsafe:Lsun/misc/Unsafe;
        //    19: ldc             Linstrumented/java/util/concurrent/atomic/AtomicReference;.class
        //    21: ldc             "value"
        //    23: ldc             3
        //    25: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    28: ldc             1
        //    30: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    33: invokevirtual   java/lang/Class.getDeclaredField:(Ljava/lang/String;)Ljava/lang/reflect/Field;
        //    36: ldc             1
        //    38: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    41: invokevirtual   sun/misc/Unsafe.objectFieldOffset:(Ljava/lang/reflect/Field;)J
        //    44: putstatic       instrumented/java/util/concurrent/atomic/AtomicReference.valueOffset:J
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
        //    StackMapTable: 00 04 7C 07 00 63 13 FF 00 05 00 00 00 01 07 00 24 FF 00 00 00 00 00 01 07 00 61
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
