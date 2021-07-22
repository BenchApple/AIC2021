// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.concurrent.atomic;

import java.lang.reflect.Field;
import aic2021.engine.BytecodeManager;
import sun.misc.Unsafe;

public class AtomicStampedReference<V>
{
    private volatile Pair<V> pair;
    private static final Unsafe UNSAFE;
    private static final long pairOffset;
    
    public AtomicStampedReference(final V v, final int n) {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(4);
            this.pair = Pair.of(v, n);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public V getReference() {
        try {
            final V reference = this.pair.reference;
            BytecodeManager.incBytecodes(4);
            return reference;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public int getStamp() {
        try {
            final int stamp = this.pair.stamp;
            BytecodeManager.incBytecodes(4);
            return stamp;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public V get(final int[] array) {
        try {
            final Pair<V> pair = this.pair;
            BytecodeManager.incBytecodes(3);
            array[0] = pair.stamp;
            BytecodeManager.incBytecodes(5);
            final V reference = pair.reference;
            BytecodeManager.incBytecodes(3);
            return reference;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public boolean weakCompareAndSet(final V v, final V v2, final int n, final int n2) {
        try {
            BytecodeManager.incBytecodes(6);
            final boolean compareAndSet = this.compareAndSet(v, v2, n, n2);
            BytecodeManager.incBytecodes(1);
            return compareAndSet;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public boolean compareAndSet(final V v, final V v2, final int n, final int n2) {
        try {
            final Pair<V> pair = this.pair;
            BytecodeManager.incBytecodes(3);
            final V reference = pair.reference;
            BytecodeManager.incBytecodes(4);
            boolean b = false;
            Label_0118: {
                Label_0112: {
                    if (v == reference) {
                        final int stamp = pair.stamp;
                        BytecodeManager.incBytecodes(4);
                        if (n == stamp) {
                            final V reference2 = pair.reference;
                            BytecodeManager.incBytecodes(4);
                            Label_0103: {
                                if (v2 == reference2) {
                                    final int stamp2 = pair.stamp;
                                    BytecodeManager.incBytecodes(4);
                                    if (n2 == stamp2) {
                                        break Label_0103;
                                    }
                                }
                                final Pair<V> pair2 = pair;
                                BytecodeManager.incBytecodes(4);
                                BytecodeManager.incBytecodes(1);
                                final Pair<V> of = Pair.of(v2, n2);
                                BytecodeManager.incBytecodes(1);
                                final boolean casPair = this.casPair(pair2, of);
                                BytecodeManager.incBytecodes(1);
                                if (!casPair) {
                                    break Label_0112;
                                }
                            }
                            b = true;
                            BytecodeManager.incBytecodes(2);
                            break Label_0118;
                        }
                    }
                }
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
    
    public void set(final V v, final int n) {
        try {
            final Pair<V> pair = this.pair;
            BytecodeManager.incBytecodes(3);
            final V reference = pair.reference;
            BytecodeManager.incBytecodes(4);
            Label_0055: {
                if (v == reference) {
                    final int stamp = pair.stamp;
                    BytecodeManager.incBytecodes(4);
                    if (n == stamp) {
                        break Label_0055;
                    }
                }
                BytecodeManager.incBytecodes(4);
                this.pair = Pair.of(v, n);
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public boolean attemptStamp(final V v, final int n) {
        try {
            final Pair<V> pair = this.pair;
            BytecodeManager.incBytecodes(3);
            final V reference = pair.reference;
            BytecodeManager.incBytecodes(4);
            boolean b = false;
            Label_0084: {
                Label_0078: {
                    if (v == reference) {
                        final int stamp = pair.stamp;
                        BytecodeManager.incBytecodes(4);
                        if (n != stamp) {
                            final Pair<V> pair2 = pair;
                            BytecodeManager.incBytecodes(4);
                            BytecodeManager.incBytecodes(1);
                            final Pair<V> of = Pair.of(v, n);
                            BytecodeManager.incBytecodes(1);
                            final boolean casPair = this.casPair(pair2, of);
                            BytecodeManager.incBytecodes(1);
                            if (!casPair) {
                                break Label_0078;
                            }
                        }
                        b = true;
                        BytecodeManager.incBytecodes(2);
                        break Label_0084;
                    }
                }
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
    
    private boolean casPair(final Pair<V> expected, final Pair<V> x) {
        try {
            final Unsafe unsafe = AtomicStampedReference.UNSAFE;
            final long pairOffset = AtomicStampedReference.pairOffset;
            BytecodeManager.incBytecodes(6);
            final boolean compareAndSwapObject = unsafe.compareAndSwapObject(this, pairOffset, expected, x);
            BytecodeManager.incBytecodes(1);
            return compareAndSwapObject;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static long objectFieldOffset(final Unsafe unsafe, final String s, final Class<?> clazz) {
        try {
            try {
                BytecodeManager.incBytecodes(4);
                final Field declaredField = clazz.getDeclaredField(s);
                BytecodeManager.incBytecodes(1);
                final long objectFieldOffset = unsafe.objectFieldOffset(declaredField);
                BytecodeManager.incBytecodes(1);
                return objectFieldOffset;
            }
            catch (NoSuchFieldException ex) {
                BytecodeManager.incBytecodes(501);
                BytecodeManager.incBytecodes(4);
                final NoSuchFieldError noSuchFieldError = new NoSuchFieldError(s);
                BytecodeManager.incBytecodes(1);
                final NoSuchFieldError noSuchFieldError2 = noSuchFieldError;
                final NoSuchFieldException cause = ex;
                BytecodeManager.incBytecodes(3);
                noSuchFieldError2.initCause(cause);
                BytecodeManager.incBytecodes(1);
                final NoSuchFieldError noSuchFieldError3 = noSuchFieldError;
                BytecodeManager.incBytecodes(2);
                throw noSuchFieldError3;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        catch (VirtualMachineError virtualMachineError) {
            throw virtualMachineError;
        }
    }
    
    static {
        try {
            BytecodeManager.incBytecodes(1);
            UNSAFE = Unsafe.getUnsafe();
            BytecodeManager.incBytecodes(1);
            final Unsafe unsafe = AtomicStampedReference.UNSAFE;
            final String s = "pair";
            final Class<AtomicStampedReference> clazz = AtomicStampedReference.class;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
            pairOffset = objectFieldOffset(unsafe, s, clazz);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static class Pair<T>
    {
        final T reference;
        final int stamp;
        
        private Pair(final T reference, final int stamp) {
            try {
                BytecodeManager.incBytecodes(2);
                this.reference = reference;
                BytecodeManager.incBytecodes(3);
                this.stamp = stamp;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static <T> Pair<T> of(final T t, final int n) {
            try {
                BytecodeManager.incBytecodes(5);
                final Pair<T> pair = new Pair<T>(t, n);
                BytecodeManager.incBytecodes(1);
                return pair;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
}
