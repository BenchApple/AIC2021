// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import java.lang.reflect.Array;
import java.util.Iterator;
import aic2021.engine.BytecodeManager;

public abstract class AbstractCollection<E> implements Collection<E>
{
    private static final int MAX_ARRAY_SIZE = 2147483639;
    
    protected AbstractCollection() {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public abstract Iterator<E> iterator();
    
    @Override
    public abstract int size();
    
    @Override
    public boolean isEmpty() {
        try {
            BytecodeManager.incBytecodes(2);
            final int size = this.size();
            BytecodeManager.incBytecodes(1);
            boolean b;
            if (size == 0) {
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
    
    @Override
    public boolean contains(final Object o) {
        try {
            BytecodeManager.incBytecodes(2);
            final Iterator<E> iterator = this.iterator();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            Label_0123: {
                if (o == null) {
                    E next;
                    do {
                        final Iterator<E> iterator2 = iterator;
                        BytecodeManager.incBytecodes(2);
                        final boolean hasNext = iterator2.hasNext();
                        BytecodeManager.incBytecodes(1);
                        if (!hasNext) {
                            break Label_0123;
                        }
                        final Iterator<E> iterator3 = iterator;
                        BytecodeManager.incBytecodes(2);
                        next = iterator3.next();
                        BytecodeManager.incBytecodes(1);
                    } while (next != null);
                    final boolean b = true;
                    BytecodeManager.incBytecodes(2);
                    return b;
                }
                boolean equals;
                do {
                    final Iterator<E> iterator4 = iterator;
                    BytecodeManager.incBytecodes(2);
                    final boolean hasNext2 = iterator4.hasNext();
                    BytecodeManager.incBytecodes(1);
                    if (!hasNext2) {
                        break Label_0123;
                    }
                    final Iterator<E> iterator5 = iterator;
                    BytecodeManager.incBytecodes(3);
                    final E next2 = iterator5.next();
                    BytecodeManager.incBytecodes(1);
                    equals = o.equals(next2);
                    BytecodeManager.incBytecodes(1);
                } while (!equals);
                final boolean b2 = true;
                BytecodeManager.incBytecodes(2);
                return b2;
            }
            final boolean b3 = false;
            BytecodeManager.incBytecodes(2);
            return b3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public Object[] toArray() {
        try {
            BytecodeManager.incBytecodes(2);
            final Object[] array = new Object[this.size()];
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            final Iterator<E> iterator = this.iterator();
            BytecodeManager.incBytecodes(1);
            int n = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n2 = n;
                final int length = array.length;
                BytecodeManager.incBytecodes(4);
                if (n2 >= length) {
                    final Iterator<E> iterator2 = iterator;
                    BytecodeManager.incBytecodes(2);
                    final boolean hasNext = iterator2.hasNext();
                    BytecodeManager.incBytecodes(1);
                    Object[] finishToArray;
                    if (hasNext) {
                        final Object[] array2 = array;
                        final Iterator<E> iterator3 = iterator;
                        BytecodeManager.incBytecodes(3);
                        finishToArray = finishToArray(array2, iterator3);
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        finishToArray = array;
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(1);
                    return finishToArray;
                }
                final Iterator<E> iterator4 = iterator;
                BytecodeManager.incBytecodes(2);
                final boolean hasNext2 = iterator4.hasNext();
                BytecodeManager.incBytecodes(1);
                if (!hasNext2) {
                    final Object[] array3 = array;
                    final int n3 = n;
                    BytecodeManager.incBytecodes(3);
                    final Object[] copy = Arrays.copyOf(array3, n3);
                    BytecodeManager.incBytecodes(1);
                    return copy;
                }
                final Object[] array4 = array;
                final int n4 = n;
                final Iterator<E> iterator5 = iterator;
                BytecodeManager.incBytecodes(4);
                array4[n4] = iterator5.next();
                BytecodeManager.incBytecodes(1);
                ++n;
                BytecodeManager.incBytecodes(2);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public <T> T[] toArray(final T[] array) {
        try {
            BytecodeManager.incBytecodes(2);
            final int size = this.size();
            BytecodeManager.incBytecodes(1);
            final int length = array.length;
            final int n = size;
            BytecodeManager.incBytecodes(4);
            Object[] array2;
            if (length >= n) {
                array2 = array;
                BytecodeManager.incBytecodes(2);
            }
            else {
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                final Class<? extends Object[]> class1 = array.getClass();
                BytecodeManager.incBytecodes(1);
                final Class<?> componentType = class1.getComponentType();
                final int length2 = size;
                BytecodeManager.incBytecodes(2);
                array2 = (Object[])Array.newInstance(componentType, length2);
                BytecodeManager.incBytecodes(2);
            }
            final T[] array3 = (T[])array2;
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            final Iterator<E> iterator = (Iterator<E>)this.iterator();
            BytecodeManager.incBytecodes(1);
            int n2 = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n3 = n2;
                final int length3 = array3.length;
                BytecodeManager.incBytecodes(4);
                if (n3 >= length3) {
                    final Iterator<E> iterator2 = iterator;
                    BytecodeManager.incBytecodes(2);
                    final boolean hasNext = iterator2.hasNext();
                    BytecodeManager.incBytecodes(1);
                    T[] finishToArray;
                    if (hasNext) {
                        final T[] array4 = array3;
                        final Iterator<E> iterator3 = iterator;
                        BytecodeManager.incBytecodes(3);
                        finishToArray = finishToArray(array4, iterator3);
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        finishToArray = array3;
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(1);
                    return finishToArray;
                }
                final Iterator<E> iterator4 = iterator;
                BytecodeManager.incBytecodes(2);
                final boolean hasNext2 = iterator4.hasNext();
                BytecodeManager.incBytecodes(1);
                if (!hasNext2) {
                    final T[] array5 = array3;
                    BytecodeManager.incBytecodes(3);
                    if (array == array5) {
                        array3[n2] = null;
                        BytecodeManager.incBytecodes(5);
                    }
                    else {
                        final int length4 = array.length;
                        final int n4 = n2;
                        BytecodeManager.incBytecodes(4);
                        if (length4 < n4) {
                            final T[] array6 = array3;
                            final int n5 = n2;
                            BytecodeManager.incBytecodes(3);
                            final T[] copy = Arrays.copyOf(array6, n5);
                            BytecodeManager.incBytecodes(1);
                            return copy;
                        }
                        final T[] array7 = array3;
                        final int n6 = 0;
                        final int n7 = 0;
                        final int n8 = n2;
                        BytecodeManager.incBytecodes(6);
                        System.arraycopy(array7, n6, array, n7, n8);
                        final int length5 = array.length;
                        final int n9 = n2;
                        BytecodeManager.incBytecodes(4);
                        if (length5 > n9) {
                            array[n2] = null;
                            BytecodeManager.incBytecodes(4);
                        }
                    }
                    BytecodeManager.incBytecodes(2);
                    return array;
                }
                final T[] array8 = array3;
                final int n10 = n2;
                final Iterator<T> iterator5 = (Iterator<T>)iterator;
                BytecodeManager.incBytecodes(4);
                array8[n10] = iterator5.next();
                BytecodeManager.incBytecodes(1);
                ++n2;
                BytecodeManager.incBytecodes(2);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static <T> T[] finishToArray(T[] copy, final Iterator<?> iterator) {
        try {
            int length = copy.length;
            BytecodeManager.incBytecodes(3);
            while (true) {
                BytecodeManager.incBytecodes(2);
                final boolean hasNext = iterator.hasNext();
                BytecodeManager.incBytecodes(1);
                if (!hasNext) {
                    break;
                }
                final int length2 = copy.length;
                BytecodeManager.incBytecodes(3);
                final int n = length;
                final int n2 = length2;
                BytecodeManager.incBytecodes(3);
                if (n == n2) {
                    int hugeCapacity = length2 + (length2 >> 1) + 1;
                    BytecodeManager.incBytecodes(8);
                    final int n3 = hugeCapacity - 2147483639;
                    BytecodeManager.incBytecodes(4);
                    if (n3 > 0) {
                        final int n4 = length2 + 1;
                        BytecodeManager.incBytecodes(4);
                        hugeCapacity = hugeCapacity(n4);
                        BytecodeManager.incBytecodes(1);
                    }
                    final T[] array = copy;
                    final int n5 = hugeCapacity;
                    BytecodeManager.incBytecodes(3);
                    copy = Arrays.copyOf(array, n5);
                    BytecodeManager.incBytecodes(1);
                }
                final T[] array2 = copy;
                final int n6 = length++;
                BytecodeManager.incBytecodes(5);
                array2[n6] = (T)iterator.next();
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            final int n7 = length;
            final int length3 = copy.length;
            BytecodeManager.incBytecodes(4);
            T[] copy2;
            if (n7 == length3) {
                copy2 = copy;
                BytecodeManager.incBytecodes(2);
            }
            else {
                final T[] array3 = copy;
                final int n8 = length;
                BytecodeManager.incBytecodes(3);
                copy2 = Arrays.copyOf(array3, n8);
            }
            BytecodeManager.incBytecodes(1);
            return copy2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static int hugeCapacity(final int n) {
        try {
            BytecodeManager.incBytecodes(2);
            if (n < 0) {
                final String s = "Required array size too large";
                BytecodeManager.incBytecodes(4);
                final OutOfMemoryError outOfMemoryError = new OutOfMemoryError(s);
                BytecodeManager.incBytecodes(1);
                throw outOfMemoryError;
            }
            final int n2 = 2147483639;
            BytecodeManager.incBytecodes(3);
            int n3;
            if (n > n2) {
                n3 = Integer.MAX_VALUE;
                BytecodeManager.incBytecodes(2);
            }
            else {
                n3 = 2147483639;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return n3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean add(final E e) {
        try {
            BytecodeManager.incBytecodes(3);
            final UnsupportedOperationException ex = new UnsupportedOperationException();
            BytecodeManager.incBytecodes(1);
            throw ex;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean remove(final Object o) {
        try {
            BytecodeManager.incBytecodes(2);
            final Iterator<E> iterator = this.iterator();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            Label_0145: {
                if (o == null) {
                    E next;
                    do {
                        final Iterator<E> iterator2 = iterator;
                        BytecodeManager.incBytecodes(2);
                        final boolean hasNext = iterator2.hasNext();
                        BytecodeManager.incBytecodes(1);
                        if (!hasNext) {
                            break Label_0145;
                        }
                        final Iterator<E> iterator3 = iterator;
                        BytecodeManager.incBytecodes(2);
                        next = iterator3.next();
                        BytecodeManager.incBytecodes(1);
                    } while (next != null);
                    final Iterator<E> iterator4 = iterator;
                    BytecodeManager.incBytecodes(2);
                    iterator4.remove();
                    final boolean b = true;
                    BytecodeManager.incBytecodes(2);
                    return b;
                }
                boolean equals;
                do {
                    final Iterator<E> iterator5 = iterator;
                    BytecodeManager.incBytecodes(2);
                    final boolean hasNext2 = iterator5.hasNext();
                    BytecodeManager.incBytecodes(1);
                    if (!hasNext2) {
                        break Label_0145;
                    }
                    final Iterator<E> iterator6 = iterator;
                    BytecodeManager.incBytecodes(3);
                    final E next2 = iterator6.next();
                    BytecodeManager.incBytecodes(1);
                    equals = o.equals(next2);
                    BytecodeManager.incBytecodes(1);
                } while (!equals);
                final Iterator<E> iterator7 = iterator;
                BytecodeManager.incBytecodes(2);
                iterator7.remove();
                final boolean b2 = true;
                BytecodeManager.incBytecodes(2);
                return b2;
            }
            final boolean b3 = false;
            BytecodeManager.incBytecodes(2);
            return b3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean containsAll(final Collection<?> collection) {
        try {
            BytecodeManager.incBytecodes(2);
            final Iterator<?> iterator = collection.iterator();
            BytecodeManager.incBytecodes(1);
            while (true) {
                final Iterator<?> iterator2 = iterator;
                BytecodeManager.incBytecodes(2);
                final boolean hasNext = iterator2.hasNext();
                BytecodeManager.incBytecodes(1);
                if (!hasNext) {
                    final boolean b = true;
                    BytecodeManager.incBytecodes(2);
                    return b;
                }
                final Iterator<?> iterator3 = iterator;
                BytecodeManager.incBytecodes(2);
                final Object next = iterator3.next();
                BytecodeManager.incBytecodes(1);
                final Object o = next;
                BytecodeManager.incBytecodes(3);
                final boolean contains = this.contains(o);
                BytecodeManager.incBytecodes(1);
                if (!contains) {
                    final boolean b2 = false;
                    BytecodeManager.incBytecodes(2);
                    return b2;
                }
                BytecodeManager.incBytecodes(1);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean addAll(final Collection<? extends E> collection) {
        try {
            boolean b = false;
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            final Iterator<? extends E> iterator = collection.iterator();
            BytecodeManager.incBytecodes(1);
            while (true) {
                final Iterator<? extends E> iterator2 = iterator;
                BytecodeManager.incBytecodes(2);
                final boolean hasNext = iterator2.hasNext();
                BytecodeManager.incBytecodes(1);
                if (!hasNext) {
                    break;
                }
                final Iterator<? extends E> iterator3 = iterator;
                BytecodeManager.incBytecodes(2);
                final E next = (E)iterator3.next();
                BytecodeManager.incBytecodes(1);
                final E e = next;
                BytecodeManager.incBytecodes(3);
                final boolean add = this.add(e);
                BytecodeManager.incBytecodes(1);
                if (add) {
                    b = true;
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(1);
            }
            final boolean b2 = b;
            BytecodeManager.incBytecodes(2);
            return b2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean removeAll(final Collection<?> collection) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(collection);
            BytecodeManager.incBytecodes(1);
            boolean b = false;
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            final Iterator<Object> iterator = this.iterator();
            BytecodeManager.incBytecodes(1);
            while (true) {
                final Iterator<Object> iterator2 = iterator;
                BytecodeManager.incBytecodes(2);
                final boolean hasNext = iterator2.hasNext();
                BytecodeManager.incBytecodes(1);
                if (!hasNext) {
                    break;
                }
                final Iterator<Object> iterator3 = iterator;
                BytecodeManager.incBytecodes(3);
                final Object next = iterator3.next();
                BytecodeManager.incBytecodes(1);
                final boolean contains = collection.contains(next);
                BytecodeManager.incBytecodes(1);
                if (!contains) {
                    continue;
                }
                final Iterator<Object> iterator4 = iterator;
                BytecodeManager.incBytecodes(2);
                iterator4.remove();
                b = true;
                BytecodeManager.incBytecodes(3);
            }
            final boolean b2 = b;
            BytecodeManager.incBytecodes(2);
            return b2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean retainAll(final Collection<?> collection) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(collection);
            BytecodeManager.incBytecodes(1);
            boolean b = false;
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            final Iterator<Object> iterator = this.iterator();
            BytecodeManager.incBytecodes(1);
            while (true) {
                final Iterator<Object> iterator2 = iterator;
                BytecodeManager.incBytecodes(2);
                final boolean hasNext = iterator2.hasNext();
                BytecodeManager.incBytecodes(1);
                if (!hasNext) {
                    break;
                }
                final Iterator<Object> iterator3 = iterator;
                BytecodeManager.incBytecodes(3);
                final Object next = iterator3.next();
                BytecodeManager.incBytecodes(1);
                final boolean contains = collection.contains(next);
                BytecodeManager.incBytecodes(1);
                if (contains) {
                    continue;
                }
                final Iterator<Object> iterator4 = iterator;
                BytecodeManager.incBytecodes(2);
                iterator4.remove();
                b = true;
                BytecodeManager.incBytecodes(3);
            }
            final boolean b2 = b;
            BytecodeManager.incBytecodes(2);
            return b2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void clear() {
        try {
            BytecodeManager.incBytecodes(2);
            final Iterator<E> iterator = this.iterator();
            BytecodeManager.incBytecodes(1);
            while (true) {
                final Iterator<E> iterator2 = iterator;
                BytecodeManager.incBytecodes(2);
                final boolean hasNext = iterator2.hasNext();
                BytecodeManager.incBytecodes(1);
                if (!hasNext) {
                    break;
                }
                final Iterator<E> iterator3 = iterator;
                BytecodeManager.incBytecodes(2);
                iterator3.next();
                BytecodeManager.incBytecodes(1);
                final Iterator<E> iterator4 = iterator;
                BytecodeManager.incBytecodes(2);
                iterator4.remove();
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public String toString() {
        try {
            BytecodeManager.incBytecodes(2);
            final Iterator<E> iterator = this.iterator();
            BytecodeManager.incBytecodes(1);
            final Iterator<E> iterator2 = iterator;
            BytecodeManager.incBytecodes(2);
            final boolean hasNext = iterator2.hasNext();
            BytecodeManager.incBytecodes(1);
            if (!hasNext) {
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
            while (true) {
                final Iterator<E> iterator3 = iterator;
                BytecodeManager.incBytecodes(2);
                final E next = iterator3.next();
                BytecodeManager.incBytecodes(1);
                final StringBuilder sb3 = sb;
                final E e = next;
                BytecodeManager.incBytecodes(4);
                Object obj;
                if (e == this) {
                    obj = "(this Collection)";
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    obj = next;
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
                sb3.append(obj);
                BytecodeManager.incBytecodes(1);
                final Iterator<E> iterator4 = iterator;
                BytecodeManager.incBytecodes(2);
                final boolean hasNext2 = iterator4.hasNext();
                BytecodeManager.incBytecodes(1);
                if (!hasNext2) {
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
                BytecodeManager.incBytecodes(1);
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
}
