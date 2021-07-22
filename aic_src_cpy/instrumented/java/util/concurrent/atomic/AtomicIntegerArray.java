// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.concurrent.atomic;

import instrumented.java.util.function.IntBinaryOperator;
import instrumented.java.util.function.IntUnaryOperator;
import aic2021.engine.BytecodeManager;
import sun.misc.Unsafe;
import java.io.Serializable;

public class AtomicIntegerArray implements Serializable
{
    private static final long serialVersionUID = 2862133569453604235L;
    private static final Unsafe unsafe;
    private static final int base;
    private static final int shift;
    private final int[] array;
    
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
            final long n2 = ((long)n << AtomicIntegerArray.shift) + AtomicIntegerArray.base;
            BytecodeManager.incBytecodes(8);
            return n2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public AtomicIntegerArray(final int n) {
        try {
            BytecodeManager.incBytecodes(2);
            this.array = new int[n];
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public AtomicIntegerArray(final int[] array) {
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
    
    public final int get(final int n) {
        try {
            BytecodeManager.incBytecodes(4);
            final long checkedByteOffset = this.checkedByteOffset(n);
            BytecodeManager.incBytecodes(1);
            final int raw = this.getRaw(checkedByteOffset);
            BytecodeManager.incBytecodes(1);
            return raw;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private int getRaw(final long offset) {
        try {
            final Unsafe unsafe = AtomicIntegerArray.unsafe;
            final int[] array = this.array;
            BytecodeManager.incBytecodes(5);
            final int intVolatile = unsafe.getIntVolatile(array, offset);
            BytecodeManager.incBytecodes(1);
            return intVolatile;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final void set(final int n, final int x) {
        try {
            final Unsafe unsafe = AtomicIntegerArray.unsafe;
            final int[] array = this.array;
            BytecodeManager.incBytecodes(6);
            final long checkedByteOffset = this.checkedByteOffset(n);
            BytecodeManager.incBytecodes(2);
            unsafe.putIntVolatile(array, checkedByteOffset, x);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final void lazySet(final int n, final int x) {
        try {
            final Unsafe unsafe = AtomicIntegerArray.unsafe;
            final int[] array = this.array;
            BytecodeManager.incBytecodes(6);
            final long checkedByteOffset = this.checkedByteOffset(n);
            BytecodeManager.incBytecodes(2);
            unsafe.putOrderedInt(array, checkedByteOffset, x);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final int getAndSet(final int n, final int newValue) {
        try {
            final Unsafe unsafe = AtomicIntegerArray.unsafe;
            final int[] array = this.array;
            BytecodeManager.incBytecodes(6);
            final long checkedByteOffset = this.checkedByteOffset(n);
            BytecodeManager.incBytecodes(2);
            final int andSetInt = unsafe.getAndSetInt(array, checkedByteOffset, newValue);
            BytecodeManager.incBytecodes(1);
            return andSetInt;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final boolean compareAndSet(final int n, final int n2, final int n3) {
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
    
    private boolean compareAndSetRaw(final long offset, final int expected, final int x) {
        try {
            final Unsafe unsafe = AtomicIntegerArray.unsafe;
            final int[] array = this.array;
            BytecodeManager.incBytecodes(7);
            final boolean compareAndSwapInt = unsafe.compareAndSwapInt(array, offset, expected, x);
            BytecodeManager.incBytecodes(1);
            return compareAndSwapInt;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final boolean weakCompareAndSet(final int n, final int n2, final int n3) {
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
    
    public final int getAndIncrement(final int n) {
        try {
            final int n2 = 1;
            BytecodeManager.incBytecodes(4);
            final int andAdd = this.getAndAdd(n, n2);
            BytecodeManager.incBytecodes(1);
            return andAdd;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final int getAndDecrement(final int n) {
        try {
            final int n2 = -1;
            BytecodeManager.incBytecodes(4);
            final int andAdd = this.getAndAdd(n, n2);
            BytecodeManager.incBytecodes(1);
            return andAdd;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final int getAndAdd(final int n, final int delta) {
        try {
            final Unsafe unsafe = AtomicIntegerArray.unsafe;
            final int[] array = this.array;
            BytecodeManager.incBytecodes(6);
            final long checkedByteOffset = this.checkedByteOffset(n);
            BytecodeManager.incBytecodes(2);
            final int andAddInt = unsafe.getAndAddInt(array, checkedByteOffset, delta);
            BytecodeManager.incBytecodes(1);
            return andAddInt;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final int incrementAndGet(final int n) {
        try {
            final int n2 = 1;
            BytecodeManager.incBytecodes(4);
            final int n3 = this.getAndAdd(n, n2) + 1;
            BytecodeManager.incBytecodes(3);
            return n3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final int decrementAndGet(final int n) {
        try {
            final int n2 = -1;
            BytecodeManager.incBytecodes(4);
            final int n3 = this.getAndAdd(n, n2) - 1;
            BytecodeManager.incBytecodes(3);
            return n3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final int addAndGet(final int n, final int n2) {
        try {
            BytecodeManager.incBytecodes(4);
            final int n3 = this.getAndAdd(n, n2) + n2;
            BytecodeManager.incBytecodes(3);
            return n3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final int getAndUpdate(final int n, final IntUnaryOperator intUnaryOperator) {
        try {
            BytecodeManager.incBytecodes(3);
            final long checkedByteOffset = this.checkedByteOffset(n);
            BytecodeManager.incBytecodes(1);
            boolean compareAndSetRaw;
            int raw;
            do {
                final long n2 = checkedByteOffset;
                BytecodeManager.incBytecodes(3);
                raw = this.getRaw(n2);
                BytecodeManager.incBytecodes(1);
                final int n3 = raw;
                BytecodeManager.incBytecodes(3);
                final int applyAsInt = intUnaryOperator.applyAsInt(n3);
                BytecodeManager.incBytecodes(1);
                final long n4 = checkedByteOffset;
                final int n5 = raw;
                final int n6 = applyAsInt;
                BytecodeManager.incBytecodes(5);
                compareAndSetRaw = this.compareAndSetRaw(n4, n5, n6);
                BytecodeManager.incBytecodes(1);
            } while (!compareAndSetRaw);
            final int n7 = raw;
            BytecodeManager.incBytecodes(2);
            return n7;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final int updateAndGet(final int n, final IntUnaryOperator intUnaryOperator) {
        try {
            BytecodeManager.incBytecodes(3);
            final long checkedByteOffset = this.checkedByteOffset(n);
            BytecodeManager.incBytecodes(1);
            boolean compareAndSetRaw;
            int applyAsInt;
            do {
                final long n2 = checkedByteOffset;
                BytecodeManager.incBytecodes(3);
                final int raw = this.getRaw(n2);
                BytecodeManager.incBytecodes(1);
                final int n3 = raw;
                BytecodeManager.incBytecodes(3);
                applyAsInt = intUnaryOperator.applyAsInt(n3);
                BytecodeManager.incBytecodes(1);
                final long n4 = checkedByteOffset;
                final int n5 = raw;
                final int n6 = applyAsInt;
                BytecodeManager.incBytecodes(5);
                compareAndSetRaw = this.compareAndSetRaw(n4, n5, n6);
                BytecodeManager.incBytecodes(1);
            } while (!compareAndSetRaw);
            final int n7 = applyAsInt;
            BytecodeManager.incBytecodes(2);
            return n7;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final int getAndAccumulate(final int n, final int n2, final IntBinaryOperator intBinaryOperator) {
        try {
            BytecodeManager.incBytecodes(3);
            final long checkedByteOffset = this.checkedByteOffset(n);
            BytecodeManager.incBytecodes(1);
            boolean compareAndSetRaw;
            int raw;
            do {
                final long n3 = checkedByteOffset;
                BytecodeManager.incBytecodes(3);
                raw = this.getRaw(n3);
                BytecodeManager.incBytecodes(1);
                final int n4 = raw;
                BytecodeManager.incBytecodes(4);
                final int applyAsInt = intBinaryOperator.applyAsInt(n4, n2);
                BytecodeManager.incBytecodes(1);
                final long n5 = checkedByteOffset;
                final int n6 = raw;
                final int n7 = applyAsInt;
                BytecodeManager.incBytecodes(5);
                compareAndSetRaw = this.compareAndSetRaw(n5, n6, n7);
                BytecodeManager.incBytecodes(1);
            } while (!compareAndSetRaw);
            final int n8 = raw;
            BytecodeManager.incBytecodes(2);
            return n8;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final int accumulateAndGet(final int n, final int n2, final IntBinaryOperator intBinaryOperator) {
        try {
            BytecodeManager.incBytecodes(3);
            final long checkedByteOffset = this.checkedByteOffset(n);
            BytecodeManager.incBytecodes(1);
            boolean compareAndSetRaw;
            int applyAsInt;
            do {
                final long n3 = checkedByteOffset;
                BytecodeManager.incBytecodes(3);
                final int raw = this.getRaw(n3);
                BytecodeManager.incBytecodes(1);
                final int n4 = raw;
                BytecodeManager.incBytecodes(4);
                applyAsInt = intBinaryOperator.applyAsInt(n4, n2);
                BytecodeManager.incBytecodes(1);
                final long n5 = checkedByteOffset;
                final int n6 = raw;
                final int n7 = applyAsInt;
                BytecodeManager.incBytecodes(5);
                compareAndSetRaw = this.compareAndSetRaw(n5, n6, n7);
                BytecodeManager.incBytecodes(1);
            } while (!compareAndSetRaw);
            final int n8 = applyAsInt;
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
                final int raw = this.getRaw(byteOffset);
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
            final Unsafe unsafe2 = AtomicIntegerArray.unsafe;
            final Class<int[]> arrayClass = int[].class;
            BytecodeManager.incBytecodes(3);
            base = unsafe2.arrayBaseOffset(arrayClass);
            BytecodeManager.incBytecodes(1);
            final Unsafe unsafe3 = AtomicIntegerArray.unsafe;
            final Class<int[]> arrayClass2 = int[].class;
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
