// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.concurrent.locks;

import java.lang.reflect.Field;
import instrumented.java.util.concurrent.ThreadLocalRandom;
import aic2021.engine.BytecodeManager;
import sun.misc.Unsafe;

public class LockSupport
{
    private static final Unsafe UNSAFE;
    private static final long parkBlockerOffset;
    private static final long SEED;
    private static final long PROBE;
    private static final long SECONDARY;
    
    private LockSupport() {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static void setBlocker(final Thread o, final Object x) {
        try {
            final Unsafe unsafe = LockSupport.UNSAFE;
            final long parkBlockerOffset = LockSupport.parkBlockerOffset;
            BytecodeManager.incBytecodes(5);
            unsafe.putObject(o, parkBlockerOffset, x);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static void unpark(final Thread thread) {
        try {
            BytecodeManager.incBytecodes(2);
            if (thread != null) {
                final Unsafe unsafe = LockSupport.UNSAFE;
                BytecodeManager.incBytecodes(3);
                unsafe.unpark(thread);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static void park(final Object o) {
        try {
            BytecodeManager.incBytecodes(1);
            final Thread currentThread = Thread.currentThread();
            BytecodeManager.incBytecodes(1);
            final Thread thread = currentThread;
            BytecodeManager.incBytecodes(3);
            setBlocker(thread, o);
            final Unsafe unsafe = LockSupport.UNSAFE;
            final boolean isAbsolute = false;
            final long time = 0L;
            BytecodeManager.incBytecodes(4);
            unsafe.park(isAbsolute, time);
            final Thread thread2 = currentThread;
            final Object o2 = null;
            BytecodeManager.incBytecodes(3);
            setBlocker(thread2, o2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static void parkNanos(final Object o, final long time) {
        try {
            final long n = lcmp(time, 0L);
            BytecodeManager.incBytecodes(4);
            if (n > 0) {
                BytecodeManager.incBytecodes(1);
                final Thread currentThread = Thread.currentThread();
                BytecodeManager.incBytecodes(1);
                final Thread thread = currentThread;
                BytecodeManager.incBytecodes(3);
                setBlocker(thread, o);
                final Unsafe unsafe = LockSupport.UNSAFE;
                final boolean isAbsolute = false;
                BytecodeManager.incBytecodes(4);
                unsafe.park(isAbsolute, time);
                final Thread thread2 = currentThread;
                final Object o2 = null;
                BytecodeManager.incBytecodes(3);
                setBlocker(thread2, o2);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static void parkUntil(final Object o, final long time) {
        try {
            BytecodeManager.incBytecodes(1);
            final Thread currentThread = Thread.currentThread();
            BytecodeManager.incBytecodes(1);
            final Thread thread = currentThread;
            BytecodeManager.incBytecodes(3);
            setBlocker(thread, o);
            final Unsafe unsafe = LockSupport.UNSAFE;
            final boolean isAbsolute = true;
            BytecodeManager.incBytecodes(4);
            unsafe.park(isAbsolute, time);
            final Thread thread2 = currentThread;
            final Object o2 = null;
            BytecodeManager.incBytecodes(3);
            setBlocker(thread2, o2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static Object getBlocker(final Thread o) {
        try {
            BytecodeManager.incBytecodes(2);
            if (o == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final Unsafe unsafe = LockSupport.UNSAFE;
            final long parkBlockerOffset = LockSupport.parkBlockerOffset;
            BytecodeManager.incBytecodes(4);
            final Object objectVolatile = unsafe.getObjectVolatile(o, parkBlockerOffset);
            BytecodeManager.incBytecodes(1);
            return objectVolatile;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static void park() {
        try {
            final Unsafe unsafe = LockSupport.UNSAFE;
            final boolean isAbsolute = false;
            final long time = 0L;
            BytecodeManager.incBytecodes(4);
            unsafe.park(isAbsolute, time);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static void parkNanos(final long time) {
        try {
            final long n = lcmp(time, 0L);
            BytecodeManager.incBytecodes(4);
            if (n > 0) {
                final Unsafe unsafe = LockSupport.UNSAFE;
                final boolean isAbsolute = false;
                BytecodeManager.incBytecodes(4);
                unsafe.park(isAbsolute, time);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static void parkUntil(final long time) {
        try {
            final Unsafe unsafe = LockSupport.UNSAFE;
            final boolean isAbsolute = true;
            BytecodeManager.incBytecodes(4);
            unsafe.park(isAbsolute, time);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static final int nextSecondarySeed() {
        try {
            BytecodeManager.incBytecodes(1);
            final Thread currentThread = Thread.currentThread();
            BytecodeManager.incBytecodes(1);
            final Unsafe unsafe = LockSupport.UNSAFE;
            final Thread o = currentThread;
            final long secondary = LockSupport.SECONDARY;
            BytecodeManager.incBytecodes(4);
            final int int1;
            final int n = int1 = unsafe.getInt(o, secondary);
            BytecodeManager.incBytecodes(3);
            int nextInt;
            if (n != 0) {
                final int n2 = int1 ^ int1 << 13;
                BytecodeManager.incBytecodes(6);
                final int n3 = n2 ^ n2 >>> 17;
                BytecodeManager.incBytecodes(6);
                nextInt = (n3 ^ n3 << 5);
                BytecodeManager.incBytecodes(7);
            }
            else {
                BytecodeManager.incBytecodes(1);
                final ThreadLocalRandom current = ThreadLocalRandom.current();
                BytecodeManager.incBytecodes(1);
                final int n4 = nextInt = current.nextInt();
                BytecodeManager.incBytecodes(3);
                if (n4 == 0) {
                    nextInt = 1;
                    BytecodeManager.incBytecodes(2);
                }
            }
            final Unsafe unsafe2 = LockSupport.UNSAFE;
            final Thread o2 = currentThread;
            final long secondary2 = LockSupport.SECONDARY;
            final int x = nextInt;
            BytecodeManager.incBytecodes(5);
            unsafe2.putInt(o2, secondary2, x);
            final int n5 = nextInt;
            BytecodeManager.incBytecodes(2);
            return n5;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static {
        try {
            try {
                try {
                    BytecodeManager.incBytecodes(1);
                    UNSAFE = Unsafe.getUnsafe();
                    BytecodeManager.incBytecodes(1);
                    final Class<Thread> clazz = Thread.class;
                    BytecodeManager.incBytecodes(2);
                    final Unsafe unsafe = LockSupport.UNSAFE;
                    final Class<Thread> clazz2 = clazz;
                    final String name = "parkBlocker";
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(1);
                    final Field declaredField = clazz2.getDeclaredField(name);
                    BytecodeManager.incBytecodes(1);
                    parkBlockerOffset = unsafe.objectFieldOffset(declaredField);
                    BytecodeManager.incBytecodes(1);
                    final Unsafe unsafe2 = LockSupport.UNSAFE;
                    final Class<Thread> clazz3 = clazz;
                    final String name2 = "threadLocalRandomSeed";
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(1);
                    final Field declaredField2 = clazz3.getDeclaredField(name2);
                    BytecodeManager.incBytecodes(1);
                    SEED = unsafe2.objectFieldOffset(declaredField2);
                    BytecodeManager.incBytecodes(1);
                    final Unsafe unsafe3 = LockSupport.UNSAFE;
                    final Class<Thread> clazz4 = clazz;
                    final String name3 = "threadLocalRandomProbe";
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(1);
                    final Field declaredField3 = clazz4.getDeclaredField(name3);
                    BytecodeManager.incBytecodes(1);
                    PROBE = unsafe3.objectFieldOffset(declaredField3);
                    BytecodeManager.incBytecodes(1);
                    final Unsafe unsafe4 = LockSupport.UNSAFE;
                    final Class<Thread> clazz5 = clazz;
                    final String name4 = "threadLocalRandomSecondarySeed";
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(1);
                    final Field declaredField4 = clazz5.getDeclaredField(name4);
                    BytecodeManager.incBytecodes(1);
                    SECONDARY = unsafe4.objectFieldOffset(declaredField4);
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                }
                catch (Exception ex) {
                    final Exception cause = ex;
                    BytecodeManager.incBytecodes(505);
                    final Error error = new Error(cause);
                    BytecodeManager.incBytecodes(1);
                    throw error;
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        catch (VirtualMachineError virtualMachineError) {
            throw virtualMachineError;
        }
    }
}
