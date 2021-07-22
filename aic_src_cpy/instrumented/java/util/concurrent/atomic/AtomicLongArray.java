// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.concurrent.atomic;

import instrumented.java.util.function.LongBinaryOperator;
import instrumented.java.util.function.LongUnaryOperator;
import aic2021.engine.BytecodeManager;
import sun.misc.Unsafe;
import java.io.Serializable;

public class AtomicLongArray implements Serializable
{
    private static final long serialVersionUID = -2308431214976778248L;
    private static final Unsafe unsafe;
    private static final int base;
    private static final int shift;
    private final long[] array;
    
    private long checkedByteOffset(final int i) {
        try {
            BytecodeManager.incBytecodes(2);
            if (i >= 0) {
                final int length = this.array.length;
                BytecodeManager.incBytecodes(5);
                if (i < length) {
                    BytecodeManager.incBytecodes(2);
                    final long byteOffset = byteOffset(i);
                    BytecodeManager.incBytecodes(1);
                    return byteOffset;
                }
            }
            BytecodeManager.incBytecodes(5);
            final StringBuilder sb = new StringBuilder();
            final String str = "index ";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append = sb.append(str);
            BytecodeManager.incBytecodes(2);
            final StringBuilder append2 = append.append(i);
            BytecodeManager.incBytecodes(1);
            final String string = append2.toString();
            BytecodeManager.incBytecodes(1);
            final IndexOutOfBoundsException ex = new IndexOutOfBoundsException(string);
            BytecodeManager.incBytecodes(1);
            throw ex;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static long byteOffset(final int n) {
        try {
            final long n2 = ((long)n << AtomicLongArray.shift) + AtomicLongArray.base;
            BytecodeManager.incBytecodes(8);
            return n2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public AtomicLongArray(final int n) {
        try {
            BytecodeManager.incBytecodes(2);
            this.array = new long[n];
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public AtomicLongArray(final long[] array) {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(3);
            this.array = array.clone();
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final int length() {
        try {
            final int length = this.array.length;
            BytecodeManager.incBytecodes(4);
            return length;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final long get(final int n) {
        try {
            BytecodeManager.incBytecodes(4);
            final long checkedByteOffset = this.checkedByteOffset(n);
            BytecodeManager.incBytecodes(1);
            final long raw = this.getRaw(checkedByteOffset);
            BytecodeManager.incBytecodes(1);
            return raw;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private long getRaw(final long offset) {
        try {
            final Unsafe unsafe = AtomicLongArray.unsafe;
            final long[] array = this.array;
            BytecodeManager.incBytecodes(5);
            final long longVolatile = unsafe.getLongVolatile(array, offset);
            BytecodeManager.incBytecodes(1);
            return longVolatile;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final void set(final int n, final long x) {
        try {
            final Unsafe unsafe = AtomicLongArray.unsafe;
            final long[] array = this.array;
            BytecodeManager.incBytecodes(6);
            final long checkedByteOffset = this.checkedByteOffset(n);
            BytecodeManager.incBytecodes(2);
            unsafe.putLongVolatile(array, checkedByteOffset, x);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final void lazySet(final int n, final long x) {
        try {
            final Unsafe unsafe = AtomicLongArray.unsafe;
            final long[] array = this.array;
            BytecodeManager.incBytecodes(6);
            final long checkedByteOffset = this.checkedByteOffset(n);
            BytecodeManager.incBytecodes(2);
            unsafe.putOrderedLong(array, checkedByteOffset, x);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final long getAndSet(final int n, final long newValue) {
        try {
            final Unsafe unsafe = AtomicLongArray.unsafe;
            final long[] array = this.array;
            BytecodeManager.incBytecodes(6);
            final long checkedByteOffset = this.checkedByteOffset(n);
            BytecodeManager.incBytecodes(2);
            final long andSetLong = unsafe.getAndSetLong(array, checkedByteOffset, newValue);
            BytecodeManager.incBytecodes(1);
            return andSetLong;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final boolean compareAndSet(final int n, final long n2, final long n3) {
        try {
            BytecodeManager.incBytecodes(4);
            final long checkedByteOffset = this.checkedByteOffset(n);
            BytecodeManager.incBytecodes(3);
            final boolean compareAndSetRaw = this.compareAndSetRaw(checkedByteOffset, n2, n3);
            BytecodeManager.incBytecodes(1);
            return compareAndSetRaw;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private boolean compareAndSetRaw(final long offset, final long expected, final long x) {
        try {
            final Unsafe unsafe = AtomicLongArray.unsafe;
            final long[] array = this.array;
            BytecodeManager.incBytecodes(7);
            final boolean compareAndSwapLong = unsafe.compareAndSwapLong(array, offset, expected, x);
            BytecodeManager.incBytecodes(1);
            return compareAndSwapLong;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final boolean weakCompareAndSet(final int n, final long n2, final long n3) {
        try {
            BytecodeManager.incBytecodes(5);
            final boolean compareAndSet = this.compareAndSet(n, n2, n3);
            BytecodeManager.incBytecodes(1);
            return compareAndSet;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final long getAndIncrement(final int n) {
        try {
            final long n2 = 1L;
            BytecodeManager.incBytecodes(4);
            final long andAdd = this.getAndAdd(n, n2);
            BytecodeManager.incBytecodes(1);
            return andAdd;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final long getAndDecrement(final int n) {
        try {
            final long n2 = -1L;
            BytecodeManager.incBytecodes(4);
            final long andAdd = this.getAndAdd(n, n2);
            BytecodeManager.incBytecodes(1);
            return andAdd;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final long getAndAdd(final int n, final long delta) {
        try {
            final Unsafe unsafe = AtomicLongArray.unsafe;
            final long[] array = this.array;
            BytecodeManager.incBytecodes(6);
            final long checkedByteOffset = this.checkedByteOffset(n);
            BytecodeManager.incBytecodes(2);
            final long andAddLong = unsafe.getAndAddLong(array, checkedByteOffset, delta);
            BytecodeManager.incBytecodes(1);
            return andAddLong;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final long incrementAndGet(final int n) {
        try {
            final long n2 = 1L;
            BytecodeManager.incBytecodes(4);
            final long n3 = this.getAndAdd(n, n2) + 1L;
            BytecodeManager.incBytecodes(3);
            return n3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final long decrementAndGet(final int n) {
        try {
            final long n2 = -1L;
            BytecodeManager.incBytecodes(4);
            final long n3 = this.getAndAdd(n, n2) - 1L;
            BytecodeManager.incBytecodes(3);
            return n3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public long addAndGet(final int n, final long n2) {
        try {
            BytecodeManager.incBytecodes(4);
            final long n3 = this.getAndAdd(n, n2) + n2;
            BytecodeManager.incBytecodes(3);
            return n3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final long getAndUpdate(final int n, final LongUnaryOperator longUnaryOperator) {
        try {
            BytecodeManager.incBytecodes(3);
            final long checkedByteOffset = this.checkedByteOffset(n);
            BytecodeManager.incBytecodes(1);
            boolean compareAndSetRaw;
            long raw;
            do {
                final long n2 = checkedByteOffset;
                BytecodeManager.incBytecodes(3);
                raw = this.getRaw(n2);
                BytecodeManager.incBytecodes(1);
                final long n3 = raw;
                BytecodeManager.incBytecodes(3);
                final long applyAsLong = longUnaryOperator.applyAsLong(n3);
                BytecodeManager.incBytecodes(1);
                final long n4 = checkedByteOffset;
                final long n5 = raw;
                final long n6 = applyAsLong;
                BytecodeManager.incBytecodes(5);
                compareAndSetRaw = this.compareAndSetRaw(n4, n5, n6);
                BytecodeManager.incBytecodes(1);
            } while (!compareAndSetRaw);
            final long n7 = raw;
            BytecodeManager.incBytecodes(2);
            return n7;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final long updateAndGet(final int n, final LongUnaryOperator longUnaryOperator) {
        try {
            BytecodeManager.incBytecodes(3);
            final long checkedByteOffset = this.checkedByteOffset(n);
            BytecodeManager.incBytecodes(1);
            boolean compareAndSetRaw;
            long applyAsLong;
            do {
                final long n2 = checkedByteOffset;
                BytecodeManager.incBytecodes(3);
                final long raw = this.getRaw(n2);
                BytecodeManager.incBytecodes(1);
                final long n3 = raw;
                BytecodeManager.incBytecodes(3);
                applyAsLong = longUnaryOperator.applyAsLong(n3);
                BytecodeManager.incBytecodes(1);
                final long n4 = checkedByteOffset;
                final long n5 = raw;
                final long n6 = applyAsLong;
                BytecodeManager.incBytecodes(5);
                compareAndSetRaw = this.compareAndSetRaw(n4, n5, n6);
                BytecodeManager.incBytecodes(1);
            } while (!compareAndSetRaw);
            final long n7 = applyAsLong;
            BytecodeManager.incBytecodes(2);
            return n7;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final long getAndAccumulate(final int n, final long n2, final LongBinaryOperator longBinaryOperator) {
        try {
            BytecodeManager.incBytecodes(3);
            final long checkedByteOffset = this.checkedByteOffset(n);
            BytecodeManager.incBytecodes(1);
            boolean compareAndSetRaw;
            long raw;
            do {
                final long n3 = checkedByteOffset;
                BytecodeManager.incBytecodes(3);
                raw = this.getRaw(n3);
                BytecodeManager.incBytecodes(1);
                final long n4 = raw;
                BytecodeManager.incBytecodes(4);
                final long applyAsLong = longBinaryOperator.applyAsLong(n4, n2);
                BytecodeManager.incBytecodes(1);
                final long n5 = checkedByteOffset;
                final long n6 = raw;
                final long n7 = applyAsLong;
                BytecodeManager.incBytecodes(5);
                compareAndSetRaw = this.compareAndSetRaw(n5, n6, n7);
                BytecodeManager.incBytecodes(1);
            } while (!compareAndSetRaw);
            final long n8 = raw;
            BytecodeManager.incBytecodes(2);
            return n8;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final long accumulateAndGet(final int n, final long n2, final LongBinaryOperator longBinaryOperator) {
        try {
            BytecodeManager.incBytecodes(3);
            final long checkedByteOffset = this.checkedByteOffset(n);
            BytecodeManager.incBytecodes(1);
            boolean compareAndSetRaw;
            long applyAsLong;
            do {
                final long n3 = checkedByteOffset;
                BytecodeManager.incBytecodes(3);
                final long raw = this.getRaw(n3);
                BytecodeManager.incBytecodes(1);
                final long n4 = raw;
                BytecodeManager.incBytecodes(4);
                applyAsLong = longBinaryOperator.applyAsLong(n4, n2);
                BytecodeManager.incBytecodes(1);
                final long n5 = checkedByteOffset;
                final long n6 = raw;
                final long n7 = applyAsLong;
                BytecodeManager.incBytecodes(5);
                compareAndSetRaw = this.compareAndSetRaw(n5, n6, n7);
                BytecodeManager.incBytecodes(1);
            } while (!compareAndSetRaw);
            final long n8 = applyAsLong;
            BytecodeManager.incBytecodes(2);
            return n8;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public String toString() {
        try {
            final int n = this.array.length - 1;
            BytecodeManager.incBytecodes(6);
            final int n2 = n;
            final int n3 = -1;
            BytecodeManager.incBytecodes(3);
            if (n2 == n3) {
                final String s = "[]";
                BytecodeManager.incBytecodes(2);
                return s;
            }
            BytecodeManager.incBytecodes(3);
            final StringBuilder sb = new StringBuilder();
            BytecodeManager.incBytecodes(1);
            final StringBuilder sb2 = sb;
            final char c = '[';
            BytecodeManager.incBytecodes(3);
            sb2.append(c);
            BytecodeManager.incBytecodes(1);
            int n4 = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final StringBuilder sb3 = sb;
                final int n5 = n4;
                BytecodeManager.incBytecodes(4);
                final long byteOffset = byteOffset(n5);
                BytecodeManager.incBytecodes(1);
                final long raw = this.getRaw(byteOffset);
                BytecodeManager.incBytecodes(1);
                sb3.append(raw);
                BytecodeManager.incBytecodes(1);
                final int n6 = n4;
                final int n7 = n;
                BytecodeManager.incBytecodes(3);
                if (n6 == n7) {
                    break;
                }
                final StringBuilder sb4 = sb;
                final char c2 = ',';
                BytecodeManager.incBytecodes(3);
                final StringBuilder append = sb4.append(c2);
                final char c3 = ' ';
                BytecodeManager.incBytecodes(2);
                append.append(c3);
                BytecodeManager.incBytecodes(1);
                ++n4;
                BytecodeManager.incBytecodes(2);
            }
            final StringBuilder sb5 = sb;
            final char c4 = ']';
            BytecodeManager.incBytecodes(3);
            final StringBuilder append2 = sb5.append(c4);
            BytecodeManager.incBytecodes(1);
            final String string = append2.toString();
            BytecodeManager.incBytecodes(1);
            return string;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static {
        try {
            BytecodeManager.incBytecodes(1);
            unsafe = Unsafe.getUnsafe();
            BytecodeManager.incBytecodes(1);
            final Unsafe unsafe2 = AtomicLongArray.unsafe;
            final Class<long[]> arrayClass = long[].class;
            BytecodeManager.incBytecodes(3);
            base = unsafe2.arrayBaseOffset(arrayClass);
            BytecodeManager.incBytecodes(1);
            final Unsafe unsafe3 = AtomicLongArray.unsafe;
            final Class<long[]> arrayClass2 = long[].class;
            BytecodeManager.incBytecodes(3);
            final int arrayIndexScale = unsafe3.arrayIndexScale(arrayClass2);
            BytecodeManager.incBytecodes(1);
            final int n = arrayIndexScale & arrayIndexScale - 1;
            BytecodeManager.incBytecodes(6);
            if (n != 0) {
                final String message = "data type scale not a power of two";
                BytecodeManager.incBytecodes(4);
                final Error error = new Error(message);
                BytecodeManager.incBytecodes(1);
                throw error;
            }
            final int n2 = 31;
            final int i = arrayIndexScale;
            BytecodeManager.incBytecodes(3);
            shift = n2 - Integer.numberOfLeadingZeros(i);
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
