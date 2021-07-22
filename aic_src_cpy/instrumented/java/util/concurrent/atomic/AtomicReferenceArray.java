// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.concurrent.atomic;

import java.lang.reflect.Field;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.lang.reflect.Array;
import java.io.ObjectInputStream;
import instrumented.java.util.function.BinaryOperator;
import instrumented.java.util.function.UnaryOperator;
import instrumented.java.util.Arrays;
import aic2021.engine.BytecodeManager;
import sun.misc.Unsafe;
import java.io.Serializable;

public class AtomicReferenceArray<E> implements Serializable
{
    private static final long serialVersionUID = -6209656149925076980L;
    private static final Unsafe unsafe;
    private static final int base;
    private static final int shift;
    private static final long arrayFieldOffset;
    private final Object[] array;
    
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
            final long n2 = ((long)n << AtomicReferenceArray.shift) + AtomicReferenceArray.base;
            BytecodeManager.incBytecodes(8);
            return n2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public AtomicReferenceArray(final int n) {
        try {
            BytecodeManager.incBytecodes(2);
            this.array = new Object[n];
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public AtomicReferenceArray(final E[] array) {
        try {
            BytecodeManager.incBytecodes(2);
            final int length = array.length;
            final Class<Object[]> clazz = Object[].class;
            BytecodeManager.incBytecodes(6);
            this.array = Arrays.copyOf(array, length, (Class<? extends Object[]>)clazz);
            BytecodeManager.incBytecodes(1);
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
    
    public final E get(final int n) {
        try {
            BytecodeManager.incBytecodes(4);
            final long checkedByteOffset = this.checkedByteOffset(n);
            BytecodeManager.incBytecodes(1);
            final E raw = this.getRaw(checkedByteOffset);
            BytecodeManager.incBytecodes(1);
            return raw;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private E getRaw(final long offset) {
        try {
            final Unsafe unsafe = AtomicReferenceArray.unsafe;
            final Object[] array = this.array;
            BytecodeManager.incBytecodes(5);
            final Object objectVolatile = unsafe.getObjectVolatile(array, offset);
            BytecodeManager.incBytecodes(1);
            return (E)objectVolatile;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final void set(final int n, final E x) {
        try {
            final Unsafe unsafe = AtomicReferenceArray.unsafe;
            final Object[] array = this.array;
            BytecodeManager.incBytecodes(6);
            final long checkedByteOffset = this.checkedByteOffset(n);
            BytecodeManager.incBytecodes(2);
            unsafe.putObjectVolatile(array, checkedByteOffset, x);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final void lazySet(final int n, final E x) {
        try {
            final Unsafe unsafe = AtomicReferenceArray.unsafe;
            final Object[] array = this.array;
            BytecodeManager.incBytecodes(6);
            final long checkedByteOffset = this.checkedByteOffset(n);
            BytecodeManager.incBytecodes(2);
            unsafe.putOrderedObject(array, checkedByteOffset, x);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final E getAndSet(final int n, final E newValue) {
        try {
            final Unsafe unsafe = AtomicReferenceArray.unsafe;
            final Object[] array = this.array;
            BytecodeManager.incBytecodes(6);
            final long checkedByteOffset = this.checkedByteOffset(n);
            BytecodeManager.incBytecodes(2);
            final Object andSetObject = unsafe.getAndSetObject(array, checkedByteOffset, newValue);
            BytecodeManager.incBytecodes(1);
            return (E)andSetObject;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final boolean compareAndSet(final int n, final E e, final E e2) {
        try {
            BytecodeManager.incBytecodes(4);
            final long checkedByteOffset = this.checkedByteOffset(n);
            BytecodeManager.incBytecodes(3);
            final boolean compareAndSetRaw = this.compareAndSetRaw(checkedByteOffset, e, e2);
            BytecodeManager.incBytecodes(1);
            return compareAndSetRaw;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private boolean compareAndSetRaw(final long offset, final E expected, final E x) {
        try {
            final Unsafe unsafe = AtomicReferenceArray.unsafe;
            final Object[] array = this.array;
            BytecodeManager.incBytecodes(7);
            final boolean compareAndSwapObject = unsafe.compareAndSwapObject(array, offset, expected, x);
            BytecodeManager.incBytecodes(1);
            return compareAndSwapObject;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final boolean weakCompareAndSet(final int n, final E e, final E e2) {
        try {
            BytecodeManager.incBytecodes(5);
            final boolean compareAndSet = this.compareAndSet(n, e, e2);
            BytecodeManager.incBytecodes(1);
            return compareAndSet;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final E getAndUpdate(final int n, final UnaryOperator<E> unaryOperator) {
        try {
            BytecodeManager.incBytecodes(3);
            final long checkedByteOffset = this.checkedByteOffset(n);
            BytecodeManager.incBytecodes(1);
            boolean compareAndSetRaw;
            E raw;
            do {
                final long n2 = checkedByteOffset;
                BytecodeManager.incBytecodes(3);
                raw = this.getRaw(n2);
                BytecodeManager.incBytecodes(1);
                final E e = raw;
                BytecodeManager.incBytecodes(3);
                final Object apply = unaryOperator.apply(e);
                BytecodeManager.incBytecodes(1);
                final long n3 = checkedByteOffset;
                final E e2 = raw;
                final Object o = apply;
                BytecodeManager.incBytecodes(5);
                compareAndSetRaw = this.compareAndSetRaw(n3, e2, (E)o);
                BytecodeManager.incBytecodes(1);
            } while (!compareAndSetRaw);
            final E e3 = raw;
            BytecodeManager.incBytecodes(2);
            return e3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final E updateAndGet(final int n, final UnaryOperator<E> unaryOperator) {
        try {
            BytecodeManager.incBytecodes(3);
            final long checkedByteOffset = this.checkedByteOffset(n);
            BytecodeManager.incBytecodes(1);
            boolean compareAndSetRaw;
            Object apply;
            do {
                final long n2 = checkedByteOffset;
                BytecodeManager.incBytecodes(3);
                final E raw = this.getRaw(n2);
                BytecodeManager.incBytecodes(1);
                final E e = raw;
                BytecodeManager.incBytecodes(3);
                apply = unaryOperator.apply(e);
                BytecodeManager.incBytecodes(1);
                final long n3 = checkedByteOffset;
                final E e2 = raw;
                final Object o = apply;
                BytecodeManager.incBytecodes(5);
                compareAndSetRaw = this.compareAndSetRaw(n3, e2, (E)o);
                BytecodeManager.incBytecodes(1);
            } while (!compareAndSetRaw);
            final Object o2 = apply;
            BytecodeManager.incBytecodes(2);
            return (E)o2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final E getAndAccumulate(final int n, final E e, final BinaryOperator<E> binaryOperator) {
        try {
            BytecodeManager.incBytecodes(3);
            final long checkedByteOffset = this.checkedByteOffset(n);
            BytecodeManager.incBytecodes(1);
            boolean compareAndSetRaw;
            E raw;
            do {
                final long n2 = checkedByteOffset;
                BytecodeManager.incBytecodes(3);
                raw = this.getRaw(n2);
                BytecodeManager.incBytecodes(1);
                final E e2 = raw;
                BytecodeManager.incBytecodes(4);
                final Object apply = binaryOperator.apply(e2, e);
                BytecodeManager.incBytecodes(1);
                final long n3 = checkedByteOffset;
                final E e3 = raw;
                final Object o = apply;
                BytecodeManager.incBytecodes(5);
                compareAndSetRaw = this.compareAndSetRaw(n3, e3, (E)o);
                BytecodeManager.incBytecodes(1);
            } while (!compareAndSetRaw);
            final E e4 = raw;
            BytecodeManager.incBytecodes(2);
            return e4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final E accumulateAndGet(final int n, final E e, final BinaryOperator<E> binaryOperator) {
        try {
            BytecodeManager.incBytecodes(3);
            final long checkedByteOffset = this.checkedByteOffset(n);
            BytecodeManager.incBytecodes(1);
            boolean compareAndSetRaw;
            Object apply;
            do {
                final long n2 = checkedByteOffset;
                BytecodeManager.incBytecodes(3);
                final E raw = this.getRaw(n2);
                BytecodeManager.incBytecodes(1);
                final E e2 = raw;
                BytecodeManager.incBytecodes(4);
                apply = binaryOperator.apply(e2, e);
                BytecodeManager.incBytecodes(1);
                final long n3 = checkedByteOffset;
                final E e3 = raw;
                final Object o = apply;
                BytecodeManager.incBytecodes(5);
                compareAndSetRaw = this.compareAndSetRaw(n3, e3, (E)o);
                BytecodeManager.incBytecodes(1);
            } while (!compareAndSetRaw);
            final Object o2 = apply;
            BytecodeManager.incBytecodes(2);
            return (E)o2;
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
                final E raw = this.getRaw(byteOffset);
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
    
    private void readObject(final ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException, InvalidObjectException {
        try {
            BytecodeManager.incBytecodes(2);
            final ObjectInputStream.GetField fields = objectInputStream.readFields();
            final String s = "array";
            final Object o = null;
            BytecodeManager.incBytecodes(3);
            Object o2 = fields.get(s, o);
            BytecodeManager.incBytecodes(1);
            final Object o3 = o2;
            BytecodeManager.incBytecodes(2);
            if (o3 != null) {
                final Object o4 = o2;
                BytecodeManager.incBytecodes(2);
                final Class<? extends Object[]> class1 = ((Object[])o4).getClass();
                BytecodeManager.incBytecodes(1);
                final boolean array = class1.isArray();
                BytecodeManager.incBytecodes(1);
                if (array) {
                    final Object o5 = o2;
                    BytecodeManager.incBytecodes(2);
                    final Class<? extends Object[]> class2 = ((Object[])o5).getClass();
                    final Class<Object[]> clazz = Object[].class;
                    BytecodeManager.incBytecodes(2);
                    if (class2 != clazz) {
                        final Object[] array2 = (Object[])o2;
                        final Object[] array3 = (Object[])o2;
                        BytecodeManager.incBytecodes(5);
                        final int length = Array.getLength(array3);
                        final Class<Object[]> clazz2 = Object[].class;
                        BytecodeManager.incBytecodes(2);
                        o2 = Arrays.copyOf(array2, length, (Class<? extends Object[]>)clazz2);
                        BytecodeManager.incBytecodes(1);
                    }
                    final Unsafe unsafe = AtomicReferenceArray.unsafe;
                    final long arrayFieldOffset = AtomicReferenceArray.arrayFieldOffset;
                    final Object[] x = (Object[])o2;
                    BytecodeManager.incBytecodes(5);
                    unsafe.putObjectVolatile(this, arrayFieldOffset, x);
                    BytecodeManager.incBytecodes(1);
                    return;
                }
            }
            final String reason = "Not array type";
            BytecodeManager.incBytecodes(4);
            final InvalidObjectException ex = new InvalidObjectException(reason);
            BytecodeManager.incBytecodes(1);
            throw ex;
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
                    unsafe = Unsafe.getUnsafe();
                    BytecodeManager.incBytecodes(1);
                    final Unsafe unsafe2 = AtomicReferenceArray.unsafe;
                    final Class<AtomicReferenceArray> clazz = AtomicReferenceArray.class;
                    final String name = "array";
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(1);
                    final Field declaredField = clazz.getDeclaredField(name);
                    BytecodeManager.incBytecodes(1);
                    arrayFieldOffset = unsafe2.objectFieldOffset(declaredField);
                    BytecodeManager.incBytecodes(1);
                    final Unsafe unsafe3 = AtomicReferenceArray.unsafe;
                    final Class<Object[]> arrayClass = Object[].class;
                    BytecodeManager.incBytecodes(3);
                    base = unsafe3.arrayBaseOffset(arrayClass);
                    BytecodeManager.incBytecodes(1);
                    final Unsafe unsafe4 = AtomicReferenceArray.unsafe;
                    final Class<Object[]> arrayClass2 = Object[].class;
                    BytecodeManager.incBytecodes(3);
                    final int arrayIndexScale = unsafe4.arrayIndexScale(arrayClass2);
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
                catch (Exception ex) {
                    BytecodeManager.incBytecodes(501);
                    final Exception cause = ex;
                    BytecodeManager.incBytecodes(4);
                    final Error error2 = new Error(cause);
                    BytecodeManager.incBytecodes(1);
                    throw error2;
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
