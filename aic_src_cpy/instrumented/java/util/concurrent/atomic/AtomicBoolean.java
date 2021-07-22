// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.concurrent.atomic;

import aic2021.engine.BytecodeManager;
import sun.misc.Unsafe;
import java.io.Serializable;

public class AtomicBoolean implements Serializable
{
    private static final long serialVersionUID = 4654671469794556979L;
    private static final Unsafe unsafe;
    private static final long valueOffset;
    private volatile int value;
    
    public AtomicBoolean(final boolean b) {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(3);
            int value;
            if (b) {
                value = 1;
                BytecodeManager.incBytecodes(2);
            }
            else {
                value = 0;
                BytecodeManager.incBytecodes(1);
            }
            this.value = value;
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public AtomicBoolean() {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final boolean get() {
        try {
            final int value = this.value;
            BytecodeManager.incBytecodes(3);
            boolean b;
            if (value != 0) {
                b = true;
                BytecodeManager.incBytecodes(2);
            }
            else {
                b = false;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return b;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final boolean compareAndSet(final boolean b, final boolean b2) {
        try {
            BytecodeManager.incBytecodes(2);
            int n;
            if (b) {
                n = 1;
                BytecodeManager.incBytecodes(2);
            }
            else {
                n = 0;
                BytecodeManager.incBytecodes(1);
            }
            final int n2 = n;
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            int n3;
            if (b2) {
                n3 = 1;
                BytecodeManager.incBytecodes(2);
            }
            else {
                n3 = 0;
                BytecodeManager.incBytecodes(1);
            }
            final int n4 = n3;
            BytecodeManager.incBytecodes(1);
            final Unsafe unsafe = AtomicBoolean.unsafe;
            final long valueOffset = AtomicBoolean.valueOffset;
            final int expected = n2;
            final int x = n4;
            BytecodeManager.incBytecodes(6);
            final boolean compareAndSwapInt = unsafe.compareAndSwapInt(this, valueOffset, expected, x);
            BytecodeManager.incBytecodes(1);
            return compareAndSwapInt;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public boolean weakCompareAndSet(final boolean b, final boolean b2) {
        try {
            BytecodeManager.incBytecodes(2);
            int n;
            if (b) {
                n = 1;
                BytecodeManager.incBytecodes(2);
            }
            else {
                n = 0;
                BytecodeManager.incBytecodes(1);
            }
            final int n2 = n;
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            int n3;
            if (b2) {
                n3 = 1;
                BytecodeManager.incBytecodes(2);
            }
            else {
                n3 = 0;
                BytecodeManager.incBytecodes(1);
            }
            final int n4 = n3;
            BytecodeManager.incBytecodes(1);
            final Unsafe unsafe = AtomicBoolean.unsafe;
            final long valueOffset = AtomicBoolean.valueOffset;
            final int expected = n2;
            final int x = n4;
            BytecodeManager.incBytecodes(6);
            final boolean compareAndSwapInt = unsafe.compareAndSwapInt(this, valueOffset, expected, x);
            BytecodeManager.incBytecodes(1);
            return compareAndSwapInt;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final void set(final boolean b) {
        try {
            BytecodeManager.incBytecodes(3);
            int value;
            if (b) {
                value = 1;
                BytecodeManager.incBytecodes(2);
            }
            else {
                value = 0;
                BytecodeManager.incBytecodes(1);
            }
            this.value = value;
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final void lazySet(final boolean b) {
        try {
            BytecodeManager.incBytecodes(2);
            int n;
            if (b) {
                n = 1;
                BytecodeManager.incBytecodes(2);
            }
            else {
                n = 0;
                BytecodeManager.incBytecodes(1);
            }
            final int n2 = n;
            BytecodeManager.incBytecodes(1);
            final Unsafe unsafe = AtomicBoolean.unsafe;
            final long valueOffset = AtomicBoolean.valueOffset;
            final int x = n2;
            BytecodeManager.incBytecodes(5);
            unsafe.putOrderedInt(this, valueOffset, x);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final boolean getAndSet(final boolean b) {
        try {
            boolean compareAndSet;
            boolean value;
            do {
                BytecodeManager.incBytecodes(2);
                value = this.get();
                BytecodeManager.incBytecodes(1);
                final boolean b2 = value;
                BytecodeManager.incBytecodes(4);
                compareAndSet = this.compareAndSet(b2, b);
                BytecodeManager.incBytecodes(1);
            } while (!compareAndSet);
            final boolean b3 = value;
            BytecodeManager.incBytecodes(2);
            return b3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public String toString() {
        try {
            BytecodeManager.incBytecodes(2);
            final boolean value = this.get();
            BytecodeManager.incBytecodes(1);
            final String string = Boolean.toString(value);
            BytecodeManager.incBytecodes(1);
            return string;
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
        //     8: putstatic       instrumented/java/util/concurrent/atomic/AtomicBoolean.unsafe:Lsun/misc/Unsafe;
        //    11: ldc             1
        //    13: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    16: getstatic       instrumented/java/util/concurrent/atomic/AtomicBoolean.unsafe:Lsun/misc/Unsafe;
        //    19: ldc             Linstrumented/java/util/concurrent/atomic/AtomicBoolean;.class
        //    21: ldc             "value"
        //    23: ldc             3
        //    25: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    28: ldc             1
        //    30: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    33: invokevirtual   java/lang/Class.getDeclaredField:(Ljava/lang/String;)Ljava/lang/reflect/Field;
        //    36: ldc             1
        //    38: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    41: invokevirtual   sun/misc/Unsafe.objectFieldOffset:(Ljava/lang/reflect/Field;)J
        //    44: putstatic       instrumented/java/util/concurrent/atomic/AtomicBoolean.valueOffset:J
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
        //    StackMapTable: 00 04 7C 07 00 4C 13 FF 00 05 00 00 00 01 07 00 22 FF 00 00 00 00 00 01 07 00 4A
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
