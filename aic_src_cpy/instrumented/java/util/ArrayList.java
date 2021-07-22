// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import instrumented.java.util.function.UnaryOperator;
import instrumented.java.util.function.Predicate;
import instrumented.java.util.function.Consumer;
import java.util.Iterator;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import aic2021.engine.BytecodeManager;
import java.io.Serializable;

public class ArrayList<E> extends AbstractList<E> implements List<E>, RandomAccess, Cloneable, Serializable
{
    private static final long serialVersionUID = 8683452581122892189L;
    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] EMPTY_ELEMENTDATA;
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    transient Object[] elementData;
    private int size;
    private static final int MAX_ARRAY_SIZE = 2147483639;
    
    public ArrayList(final int i) {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            if (i > 0) {
                this.elementData = new Object[i];
                BytecodeManager.incBytecodes(4);
            }
            else {
                BytecodeManager.incBytecodes(2);
                if (i != 0) {
                    BytecodeManager.incBytecodes(5);
                    final StringBuilder sb = new StringBuilder();
                    final String str = "Illegal Capacity: ";
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append = sb.append(str);
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append2 = append.append(i);
                    BytecodeManager.incBytecodes(1);
                    final String string = append2.toString();
                    BytecodeManager.incBytecodes(1);
                    final IllegalArgumentException ex = new IllegalArgumentException(string);
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                this.elementData = ArrayList.EMPTY_ELEMENTDATA;
                BytecodeManager.incBytecodes(4);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public ArrayList() {
        try {
            BytecodeManager.incBytecodes(2);
            this.elementData = ArrayList.DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public ArrayList(final Collection<? extends E> collection) {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(3);
            this.elementData = collection.toArray();
            BytecodeManager.incBytecodes(1);
            final int length = this.elementData.length;
            this.size = length;
            BytecodeManager.incBytecodes(7);
            if (length != 0) {
                final Object[] elementData = this.elementData;
                BytecodeManager.incBytecodes(3);
                final Class<? extends Object[]> class1 = elementData.getClass();
                final Class<Object[]> clazz = Object[].class;
                BytecodeManager.incBytecodes(2);
                if (class1 != clazz) {
                    final Object[] elementData2 = this.elementData;
                    final int size = this.size;
                    final Class<Object[]> clazz2 = Object[].class;
                    BytecodeManager.incBytecodes(7);
                    this.elementData = Arrays.copyOf(elementData2, size, (Class<? extends Object[]>)clazz2);
                    BytecodeManager.incBytecodes(2);
                }
            }
            else {
                this.elementData = ArrayList.EMPTY_ELEMENTDATA;
                BytecodeManager.incBytecodes(3);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void trimToSize() {
        try {
            ++this.modCount;
            BytecodeManager.incBytecodes(6);
            final int size = this.size;
            final int length = this.elementData.length;
            BytecodeManager.incBytecodes(6);
            if (size < length) {
                final int size2 = this.size;
                BytecodeManager.incBytecodes(4);
                Object[] elementData;
                if (size2 == 0) {
                    elementData = ArrayList.EMPTY_ELEMENTDATA;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final Object[] elementData2 = this.elementData;
                    final int size3 = this.size;
                    BytecodeManager.incBytecodes(4);
                    BytecodeManager.incBytecodes(1);
                    elementData = Arrays.copyOf(elementData2, size3);
                }
                this.elementData = elementData;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void ensureCapacity(final int n) {
        try {
            final Object[] elementData = this.elementData;
            final Object[] defaultcapacity_EMPTY_ELEMENTDATA = ArrayList.DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
            BytecodeManager.incBytecodes(4);
            int n2;
            if (elementData != defaultcapacity_EMPTY_ELEMENTDATA) {
                n2 = 0;
                BytecodeManager.incBytecodes(2);
            }
            else {
                n2 = 10;
                BytecodeManager.incBytecodes(1);
            }
            final int n3 = n2;
            BytecodeManager.incBytecodes(1);
            final int n4 = n3;
            BytecodeManager.incBytecodes(3);
            if (n > n4) {
                BytecodeManager.incBytecodes(3);
                this.ensureExplicitCapacity(n);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void ensureCapacityInternal(int max) {
        try {
            final Object[] elementData = this.elementData;
            final Object[] defaultcapacity_EMPTY_ELEMENTDATA = ArrayList.DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
            BytecodeManager.incBytecodes(4);
            if (elementData == defaultcapacity_EMPTY_ELEMENTDATA) {
                final int a = 10;
                final int b = max;
                BytecodeManager.incBytecodes(3);
                max = Math.max(a, b);
                BytecodeManager.incBytecodes(1);
            }
            final int n = max;
            BytecodeManager.incBytecodes(3);
            this.ensureExplicitCapacity(n);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void ensureExplicitCapacity(final int n) {
        try {
            ++this.modCount;
            BytecodeManager.incBytecodes(6);
            final int n2 = n - this.elementData.length;
            BytecodeManager.incBytecodes(6);
            if (n2 > 0) {
                BytecodeManager.incBytecodes(3);
                this.grow(n);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void grow(final int n) {
        try {
            final int length = this.elementData.length;
            BytecodeManager.incBytecodes(4);
            int hugeCapacity = length + (length >> 1);
            BytecodeManager.incBytecodes(6);
            final int n2 = hugeCapacity - n;
            BytecodeManager.incBytecodes(4);
            if (n2 < 0) {
                hugeCapacity = n;
                BytecodeManager.incBytecodes(2);
            }
            final int n3 = hugeCapacity - 2147483639;
            BytecodeManager.incBytecodes(4);
            if (n3 > 0) {
                BytecodeManager.incBytecodes(2);
                hugeCapacity = hugeCapacity(n);
                BytecodeManager.incBytecodes(1);
            }
            final Object[] elementData = this.elementData;
            final int n4 = hugeCapacity;
            BytecodeManager.incBytecodes(5);
            this.elementData = Arrays.copyOf(elementData, n4);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static int hugeCapacity(final int n) {
        try {
            BytecodeManager.incBytecodes(2);
            if (n < 0) {
                BytecodeManager.incBytecodes(3);
                final OutOfMemoryError outOfMemoryError = new OutOfMemoryError();
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
    public int size() {
        try {
            final int size = this.size;
            BytecodeManager.incBytecodes(3);
            return size;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean isEmpty() {
        try {
            final int size = this.size;
            BytecodeManager.incBytecodes(3);
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
            BytecodeManager.incBytecodes(3);
            final int index = this.indexOf(o);
            BytecodeManager.incBytecodes(1);
            boolean b;
            if (index >= 0) {
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
    public int indexOf(final Object o) {
        try {
            BytecodeManager.incBytecodes(2);
            if (o == null) {
                int n = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n2 = n;
                    final int size = this.size;
                    BytecodeManager.incBytecodes(4);
                    if (n2 >= size) {
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    final Object o2 = this.elementData[n];
                    BytecodeManager.incBytecodes(5);
                    if (o2 == null) {
                        final int n3 = n;
                        BytecodeManager.incBytecodes(2);
                        return n3;
                    }
                    ++n;
                    BytecodeManager.incBytecodes(2);
                }
            }
            else {
                int n4 = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n5 = n4;
                    final int size2 = this.size;
                    BytecodeManager.incBytecodes(4);
                    if (n5 >= size2) {
                        break;
                    }
                    final Object obj = this.elementData[n4];
                    BytecodeManager.incBytecodes(6);
                    final boolean equals = o.equals(obj);
                    BytecodeManager.incBytecodes(1);
                    if (equals) {
                        final int n6 = n4;
                        BytecodeManager.incBytecodes(2);
                        return n6;
                    }
                    ++n4;
                    BytecodeManager.incBytecodes(2);
                }
            }
            final int n7 = -1;
            BytecodeManager.incBytecodes(2);
            return n7;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public int lastIndexOf(final Object o) {
        try {
            BytecodeManager.incBytecodes(2);
            if (o == null) {
                int n = this.size - 1;
                BytecodeManager.incBytecodes(5);
                while (true) {
                    final int n2 = n;
                    BytecodeManager.incBytecodes(2);
                    if (n2 < 0) {
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    final Object o2 = this.elementData[n];
                    BytecodeManager.incBytecodes(5);
                    if (o2 == null) {
                        final int n3 = n;
                        BytecodeManager.incBytecodes(2);
                        return n3;
                    }
                    --n;
                    BytecodeManager.incBytecodes(2);
                }
            }
            else {
                int n4 = this.size - 1;
                BytecodeManager.incBytecodes(5);
                while (true) {
                    final int n5 = n4;
                    BytecodeManager.incBytecodes(2);
                    if (n5 < 0) {
                        break;
                    }
                    final Object obj = this.elementData[n4];
                    BytecodeManager.incBytecodes(6);
                    final boolean equals = o.equals(obj);
                    BytecodeManager.incBytecodes(1);
                    if (equals) {
                        final int n6 = n4;
                        BytecodeManager.incBytecodes(2);
                        return n6;
                    }
                    --n4;
                    BytecodeManager.incBytecodes(2);
                }
            }
            final int n7 = -1;
            BytecodeManager.incBytecodes(2);
            return n7;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Object clone() {
        try {
            try {
                BytecodeManager.incBytecodes(2);
                final ArrayList list = (ArrayList)super.clone();
                BytecodeManager.incBytecodes(2);
                final ArrayList list2 = list;
                final Object[] elementData = this.elementData;
                final int size = this.size;
                BytecodeManager.incBytecodes(6);
                list2.elementData = Arrays.copyOf(elementData, size);
                BytecodeManager.incBytecodes(1);
                list.modCount = 0;
                BytecodeManager.incBytecodes(3);
                final ArrayList list3 = list;
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                return list3;
            }
            catch (CloneNotSupportedException ex) {
                BytecodeManager.incBytecodes(501);
                final CloneNotSupportedException cause = ex;
                BytecodeManager.incBytecodes(4);
                final InternalError internalError = new InternalError(cause);
                BytecodeManager.incBytecodes(1);
                throw internalError;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        catch (VirtualMachineError virtualMachineError) {
            throw virtualMachineError;
        }
    }
    
    @Override
    public Object[] toArray() {
        try {
            final Object[] elementData = this.elementData;
            final int size = this.size;
            BytecodeManager.incBytecodes(5);
            final Object[] copy = Arrays.copyOf(elementData, size);
            BytecodeManager.incBytecodes(1);
            return copy;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public <T> T[] toArray(final T[] array) {
        try {
            final int length = array.length;
            final int size = this.size;
            BytecodeManager.incBytecodes(5);
            if (length < size) {
                final Object[] elementData = this.elementData;
                final int size2 = this.size;
                BytecodeManager.incBytecodes(6);
                final Class<? extends Object[]> class1 = array.getClass();
                BytecodeManager.incBytecodes(1);
                final T[] array2 = Arrays.copyOf(elementData, size2, (Class<? extends T[]>)class1);
                BytecodeManager.incBytecodes(2);
                return array2;
            }
            final Object[] elementData2 = this.elementData;
            final int n = 0;
            final int n2 = 0;
            final int size3 = this.size;
            BytecodeManager.incBytecodes(8);
            System.arraycopy(elementData2, n, array, n2, size3);
            final int length2 = array.length;
            final int size4 = this.size;
            BytecodeManager.incBytecodes(5);
            if (length2 > size4) {
                array[this.size] = null;
                BytecodeManager.incBytecodes(5);
            }
            BytecodeManager.incBytecodes(2);
            return array;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    E elementData(final int n) {
        try {
            final Object o = this.elementData[n];
            BytecodeManager.incBytecodes(5);
            return (E)o;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public E get(final int n) {
        try {
            BytecodeManager.incBytecodes(3);
            this.rangeCheck(n);
            BytecodeManager.incBytecodes(3);
            final E elementData = this.elementData(n);
            BytecodeManager.incBytecodes(1);
            return elementData;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public E set(final int n, final E e) {
        try {
            BytecodeManager.incBytecodes(3);
            this.rangeCheck(n);
            BytecodeManager.incBytecodes(3);
            final E elementData = this.elementData(n);
            BytecodeManager.incBytecodes(1);
            this.elementData[n] = e;
            BytecodeManager.incBytecodes(5);
            final E e2 = elementData;
            BytecodeManager.incBytecodes(2);
            return e2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean add(final E e) {
        try {
            final int n = this.size + 1;
            BytecodeManager.incBytecodes(6);
            this.ensureCapacityInternal(n);
            this.elementData[this.size++] = e;
            BytecodeManager.incBytecodes(11);
            final boolean b = true;
            BytecodeManager.incBytecodes(2);
            return b;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void add(final int n, final E e) {
        try {
            BytecodeManager.incBytecodes(3);
            this.rangeCheckForAdd(n);
            final int n2 = this.size + 1;
            BytecodeManager.incBytecodes(6);
            this.ensureCapacityInternal(n2);
            final Object[] elementData = this.elementData;
            final Object[] elementData2 = this.elementData;
            final int n3 = n + 1;
            final int n4 = this.size - n;
            BytecodeManager.incBytecodes(13);
            System.arraycopy(elementData, n, elementData2, n3, n4);
            this.elementData[n] = e;
            BytecodeManager.incBytecodes(5);
            ++this.size;
            BytecodeManager.incBytecodes(6);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public E remove(final int n) {
        try {
            BytecodeManager.incBytecodes(3);
            this.rangeCheck(n);
            ++this.modCount;
            BytecodeManager.incBytecodes(6);
            BytecodeManager.incBytecodes(3);
            final E elementData = this.elementData(n);
            BytecodeManager.incBytecodes(1);
            final int n2 = this.size - n - 1;
            BytecodeManager.incBytecodes(7);
            final int n3 = n2;
            BytecodeManager.incBytecodes(2);
            if (n3 > 0) {
                final Object[] elementData2 = this.elementData;
                final int n4 = n + 1;
                final Object[] elementData3 = this.elementData;
                final int n5 = n2;
                BytecodeManager.incBytecodes(10);
                System.arraycopy(elementData2, n4, elementData3, n, n5);
            }
            this.elementData[--this.size] = null;
            BytecodeManager.incBytecodes(11);
            final E e = elementData;
            BytecodeManager.incBytecodes(2);
            return e;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean remove(final Object o) {
        try {
            BytecodeManager.incBytecodes(2);
            if (o == null) {
                int n = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n2 = n;
                    final int size = this.size;
                    BytecodeManager.incBytecodes(4);
                    if (n2 >= size) {
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    final Object o2 = this.elementData[n];
                    BytecodeManager.incBytecodes(5);
                    if (o2 == null) {
                        final int n3 = n;
                        BytecodeManager.incBytecodes(3);
                        this.fastRemove(n3);
                        final boolean b = true;
                        BytecodeManager.incBytecodes(2);
                        return b;
                    }
                    ++n;
                    BytecodeManager.incBytecodes(2);
                }
            }
            else {
                int n4 = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n5 = n4;
                    final int size2 = this.size;
                    BytecodeManager.incBytecodes(4);
                    if (n5 >= size2) {
                        break;
                    }
                    final Object obj = this.elementData[n4];
                    BytecodeManager.incBytecodes(6);
                    final boolean equals = o.equals(obj);
                    BytecodeManager.incBytecodes(1);
                    if (equals) {
                        final int n6 = n4;
                        BytecodeManager.incBytecodes(3);
                        this.fastRemove(n6);
                        final boolean b2 = true;
                        BytecodeManager.incBytecodes(2);
                        return b2;
                    }
                    ++n4;
                    BytecodeManager.incBytecodes(2);
                }
            }
            final boolean b3 = false;
            BytecodeManager.incBytecodes(2);
            return b3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void fastRemove(final int n) {
        try {
            ++this.modCount;
            BytecodeManager.incBytecodes(6);
            final int n2 = this.size - n - 1;
            BytecodeManager.incBytecodes(7);
            final int n3 = n2;
            BytecodeManager.incBytecodes(2);
            if (n3 > 0) {
                final Object[] elementData = this.elementData;
                final int n4 = n + 1;
                final Object[] elementData2 = this.elementData;
                final int n5 = n2;
                BytecodeManager.incBytecodes(10);
                System.arraycopy(elementData, n4, elementData2, n, n5);
            }
            this.elementData[--this.size] = null;
            BytecodeManager.incBytecodes(11);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void clear() {
        try {
            ++this.modCount;
            BytecodeManager.incBytecodes(6);
            int n = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n2 = n;
                final int size = this.size;
                BytecodeManager.incBytecodes(4);
                if (n2 >= size) {
                    break;
                }
                this.elementData[n] = null;
                BytecodeManager.incBytecodes(5);
                ++n;
                BytecodeManager.incBytecodes(2);
            }
            this.size = 0;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean addAll(final Collection<? extends E> collection) {
        try {
            BytecodeManager.incBytecodes(2);
            final Object[] array = collection.toArray();
            BytecodeManager.incBytecodes(1);
            final int length = array.length;
            BytecodeManager.incBytecodes(3);
            final int n = this.size + length;
            BytecodeManager.incBytecodes(6);
            this.ensureCapacityInternal(n);
            final Object[] array2 = array;
            final int n2 = 0;
            final Object[] elementData = this.elementData;
            final int size = this.size;
            final int n3 = length;
            BytecodeManager.incBytecodes(8);
            System.arraycopy(array2, n2, elementData, size, n3);
            this.size += length;
            BytecodeManager.incBytecodes(6);
            final int n4 = length;
            BytecodeManager.incBytecodes(2);
            boolean b;
            if (n4 != 0) {
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
    public boolean addAll(final int n, final Collection<? extends E> collection) {
        try {
            BytecodeManager.incBytecodes(3);
            this.rangeCheckForAdd(n);
            BytecodeManager.incBytecodes(2);
            final Object[] array = collection.toArray();
            BytecodeManager.incBytecodes(1);
            final int length = array.length;
            BytecodeManager.incBytecodes(3);
            final int n2 = this.size + length;
            BytecodeManager.incBytecodes(6);
            this.ensureCapacityInternal(n2);
            final int n3 = this.size - n;
            BytecodeManager.incBytecodes(5);
            final int n4 = n3;
            BytecodeManager.incBytecodes(2);
            if (n4 > 0) {
                final Object[] elementData = this.elementData;
                final Object[] elementData2 = this.elementData;
                final int n5 = n + length;
                final int n6 = n3;
                BytecodeManager.incBytecodes(10);
                System.arraycopy(elementData, n, elementData2, n5, n6);
            }
            final Object[] array2 = array;
            final int n7 = 0;
            final Object[] elementData3 = this.elementData;
            final int n8 = length;
            BytecodeManager.incBytecodes(7);
            System.arraycopy(array2, n7, elementData3, n, n8);
            this.size += length;
            BytecodeManager.incBytecodes(6);
            final int n9 = length;
            BytecodeManager.incBytecodes(2);
            boolean b;
            if (n9 != 0) {
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
    protected void removeRange(final int n, final int n2) {
        try {
            ++this.modCount;
            BytecodeManager.incBytecodes(6);
            final int n3 = this.size - n2;
            BytecodeManager.incBytecodes(5);
            final Object[] elementData = this.elementData;
            final Object[] elementData2 = this.elementData;
            final int n4 = n3;
            BytecodeManager.incBytecodes(8);
            System.arraycopy(elementData, n2, elementData2, n, n4);
            final int size = this.size - (n2 - n);
            BytecodeManager.incBytecodes(7);
            int n5 = size;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n6 = n5;
                final int size2 = this.size;
                BytecodeManager.incBytecodes(4);
                if (n6 >= size2) {
                    break;
                }
                this.elementData[n5] = null;
                BytecodeManager.incBytecodes(5);
                ++n5;
                BytecodeManager.incBytecodes(2);
            }
            this.size = size;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void rangeCheck(final int n) {
        try {
            final int size = this.size;
            BytecodeManager.incBytecodes(4);
            if (n >= size) {
                BytecodeManager.incBytecodes(5);
                final String outOfBoundsMsg = this.outOfBoundsMsg(n);
                BytecodeManager.incBytecodes(1);
                final IndexOutOfBoundsException ex = new IndexOutOfBoundsException(outOfBoundsMsg);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void rangeCheckForAdd(final int n) {
        try {
            final int size = this.size;
            BytecodeManager.incBytecodes(4);
            if (n <= size) {
                BytecodeManager.incBytecodes(2);
                if (n >= 0) {
                    BytecodeManager.incBytecodes(1);
                    return;
                }
            }
            BytecodeManager.incBytecodes(5);
            final String outOfBoundsMsg = this.outOfBoundsMsg(n);
            BytecodeManager.incBytecodes(1);
            final IndexOutOfBoundsException ex = new IndexOutOfBoundsException(outOfBoundsMsg);
            BytecodeManager.incBytecodes(1);
            throw ex;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private String outOfBoundsMsg(final int i) {
        try {
            BytecodeManager.incBytecodes(3);
            final StringBuilder sb = new StringBuilder();
            final String str = "Index: ";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append = sb.append(str);
            BytecodeManager.incBytecodes(2);
            final StringBuilder append2 = append.append(i);
            final String str2 = ", Size: ";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append3 = append2.append(str2);
            final int size = this.size;
            BytecodeManager.incBytecodes(3);
            final StringBuilder append4 = append3.append(size);
            BytecodeManager.incBytecodes(1);
            final String string = append4.toString();
            BytecodeManager.incBytecodes(1);
            return string;
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
            final boolean b = false;
            BytecodeManager.incBytecodes(4);
            final boolean batchRemove = this.batchRemove(collection, b);
            BytecodeManager.incBytecodes(1);
            return batchRemove;
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
            final boolean b = true;
            BytecodeManager.incBytecodes(4);
            final boolean batchRemove = this.batchRemove(collection, b);
            BytecodeManager.incBytecodes(1);
            return batchRemove;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private boolean batchRemove(final Collection<?> p0, final boolean p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        instrumented/java/util/ArrayList.elementData:[Ljava/lang/Object;
        //     4: astore_3       
        //     5: ldc             3
        //     7: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    10: iconst_0       
        //    11: istore          4
        //    13: iconst_0       
        //    14: istore          5
        //    16: ldc             4
        //    18: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    21: iconst_0       
        //    22: istore          6
        //    24: ldc             2
        //    26: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    29: iload           4
        //    31: aload_0        
        //    32: getfield        instrumented/java/util/ArrayList.size:I
        //    35: ldc             4
        //    37: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    40: if_icmpge       94
        //    43: aload_1        
        //    44: aload_3        
        //    45: iload           4
        //    47: aaload         
        //    48: ldc             5
        //    50: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    53: invokeinterface instrumented/java/util/Collection.contains:(Ljava/lang/Object;)Z
        //    58: iload_2        
        //    59: ldc             2
        //    61: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    64: if_icmpne       83
        //    67: aload_3        
        //    68: iload           5
        //    70: iinc            5, 1
        //    73: aload_3        
        //    74: iload           4
        //    76: aaload         
        //    77: aastore        
        //    78: ldc             7
        //    80: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    83: iinc            4, 1
        //    86: ldc             2
        //    88: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    91: goto            29
        //    94: iload           4
        //    96: aload_0        
        //    97: getfield        instrumented/java/util/ArrayList.size:I
        //   100: ldc             4
        //   102: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   105: if_icmpeq       146
        //   108: aload_3        
        //   109: iload           4
        //   111: aload_3        
        //   112: iload           5
        //   114: aload_0        
        //   115: getfield        instrumented/java/util/ArrayList.size:I
        //   118: iload           4
        //   120: isub           
        //   121: ldc             9
        //   123: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   126: invokestatic    java/lang/System.arraycopy:(Ljava/lang/Object;ILjava/lang/Object;II)V
        //   129: iload           5
        //   131: aload_0        
        //   132: getfield        instrumented/java/util/ArrayList.size:I
        //   135: iload           4
        //   137: isub           
        //   138: iadd           
        //   139: istore          5
        //   141: ldc             7
        //   143: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   146: iload           5
        //   148: aload_0        
        //   149: getfield        instrumented/java/util/ArrayList.size:I
        //   152: ldc             4
        //   154: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   157: if_icmpeq       412
        //   160: iload           5
        //   162: istore          7
        //   164: ldc             2
        //   166: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   169: iload           7
        //   171: aload_0        
        //   172: getfield        instrumented/java/util/ArrayList.size:I
        //   175: ldc             4
        //   177: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   180: if_icmpge       204
        //   183: aload_3        
        //   184: iload           7
        //   186: aconst_null    
        //   187: aastore        
        //   188: ldc             4
        //   190: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   193: iinc            7, 1
        //   196: ldc             2
        //   198: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   201: goto            169
        //   204: aload_0        
        //   205: dup            
        //   206: getfield        instrumented/java/util/ArrayList.modCount:I
        //   209: aload_0        
        //   210: getfield        instrumented/java/util/ArrayList.size:I
        //   213: iload           5
        //   215: isub           
        //   216: iadd           
        //   217: putfield        instrumented/java/util/ArrayList.modCount:I
        //   220: ldc             9
        //   222: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   225: aload_0        
        //   226: iload           5
        //   228: putfield        instrumented/java/util/ArrayList.size:I
        //   231: ldc             3
        //   233: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   236: iconst_1       
        //   237: istore          6
        //   239: ldc             3
        //   241: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   244: goto            412
        //   247: astore          8
        //   249: ldc             501
        //   251: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   254: iload           4
        //   256: aload_0        
        //   257: getfield        instrumented/java/util/ArrayList.size:I
        //   260: ldc             4
        //   262: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   265: if_icmpeq       306
        //   268: aload_3        
        //   269: iload           4
        //   271: aload_3        
        //   272: iload           5
        //   274: aload_0        
        //   275: getfield        instrumented/java/util/ArrayList.size:I
        //   278: iload           4
        //   280: isub           
        //   281: ldc             9
        //   283: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   286: invokestatic    java/lang/System.arraycopy:(Ljava/lang/Object;ILjava/lang/Object;II)V
        //   289: iload           5
        //   291: aload_0        
        //   292: getfield        instrumented/java/util/ArrayList.size:I
        //   295: iload           4
        //   297: isub           
        //   298: iadd           
        //   299: istore          5
        //   301: ldc             7
        //   303: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   306: iload           5
        //   308: aload_0        
        //   309: getfield        instrumented/java/util/ArrayList.size:I
        //   312: ldc             4
        //   314: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   317: if_icmpeq       404
        //   320: iload           5
        //   322: istore          9
        //   324: ldc             2
        //   326: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   329: iload           9
        //   331: aload_0        
        //   332: getfield        instrumented/java/util/ArrayList.size:I
        //   335: ldc             4
        //   337: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   340: if_icmpge       364
        //   343: aload_3        
        //   344: iload           9
        //   346: aconst_null    
        //   347: aastore        
        //   348: ldc             4
        //   350: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   353: iinc            9, 1
        //   356: ldc             2
        //   358: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   361: goto            329
        //   364: aload_0        
        //   365: dup            
        //   366: getfield        instrumented/java/util/ArrayList.modCount:I
        //   369: aload_0        
        //   370: getfield        instrumented/java/util/ArrayList.size:I
        //   373: iload           5
        //   375: isub           
        //   376: iadd           
        //   377: putfield        instrumented/java/util/ArrayList.modCount:I
        //   380: ldc             9
        //   382: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   385: aload_0        
        //   386: iload           5
        //   388: putfield        instrumented/java/util/ArrayList.size:I
        //   391: ldc             3
        //   393: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   396: iconst_1       
        //   397: istore          6
        //   399: ldc             2
        //   401: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   404: aload           8
        //   406: ldc             2
        //   408: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   411: athrow         
        //   412: iload           6
        //   414: ldc             2
        //   416: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   419: ireturn        
        //   420: athrow         
        //   421: athrow         
        //    Signature:
        //  (Linstrumented/java/util/Collection<*>;Z)Z
        //    StackMapTable: 00 0E FF 00 1D 00 07 07 00 02 07 00 5B 01 07 00 67 01 01 01 00 00 35 0A 33 FC 00 16 01 FA 00 22 6A 07 00 55 FD 00 3A 00 07 00 55 FC 00 16 01 FA 00 22 27 F9 00 07 FF 00 07 00 00 00 01 07 00 55 FF 00 00 00 00 00 01 07 00 9C
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  29     421    421    422    Ljava/lang/VirtualMachineError;
        //  29     94     247    412    Any
        //  247    254    247    412    Any
        //  0      420    420    421    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0029:
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
    
    private void writeObject(final ObjectOutputStream objectOutputStream) throws IOException {
        try {
            final int modCount = this.modCount;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(2);
            objectOutputStream.defaultWriteObject();
            final int size = this.size;
            BytecodeManager.incBytecodes(4);
            objectOutputStream.writeInt(size);
            int n = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n2 = n;
                final int size2 = this.size;
                BytecodeManager.incBytecodes(4);
                if (n2 >= size2) {
                    break;
                }
                final Object obj = this.elementData[n];
                BytecodeManager.incBytecodes(6);
                objectOutputStream.writeObject(obj);
                ++n;
                BytecodeManager.incBytecodes(2);
            }
            final int modCount2 = this.modCount;
            final int n3 = modCount;
            BytecodeManager.incBytecodes(4);
            if (modCount2 != n3) {
                BytecodeManager.incBytecodes(3);
                final ConcurrentModificationException ex = new ConcurrentModificationException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void readObject(final ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.elementData = ArrayList.EMPTY_ELEMENTDATA;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(2);
            objectInputStream.defaultReadObject();
            BytecodeManager.incBytecodes(2);
            objectInputStream.readInt();
            BytecodeManager.incBytecodes(1);
            final int size = this.size;
            BytecodeManager.incBytecodes(3);
            if (size > 0) {
                final int size2 = this.size;
                BytecodeManager.incBytecodes(4);
                this.ensureCapacityInternal(size2);
                final Object[] elementData = this.elementData;
                BytecodeManager.incBytecodes(3);
                int n = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n2 = n;
                    final int size3 = this.size;
                    BytecodeManager.incBytecodes(4);
                    if (n2 >= size3) {
                        break;
                    }
                    final Object[] array = elementData;
                    final int n3 = n;
                    BytecodeManager.incBytecodes(4);
                    array[n3] = objectInputStream.readObject();
                    BytecodeManager.incBytecodes(1);
                    ++n;
                    BytecodeManager.incBytecodes(2);
                }
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public ListIterator<E> listIterator(final int i) {
        try {
            BytecodeManager.incBytecodes(2);
            if (i >= 0) {
                final int size = this.size;
                BytecodeManager.incBytecodes(4);
                if (i <= size) {
                    BytecodeManager.incBytecodes(5);
                    final ListItr listItr = new ListItr(i);
                    BytecodeManager.incBytecodes(1);
                    return listItr;
                }
            }
            BytecodeManager.incBytecodes(5);
            final StringBuilder sb = new StringBuilder();
            final String str = "Index: ";
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
    
    @Override
    public ListIterator<E> listIterator() {
        try {
            final int n = 0;
            BytecodeManager.incBytecodes(5);
            final ListItr listItr = new ListItr(n);
            BytecodeManager.incBytecodes(1);
            return listItr;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public Iterator<E> iterator() {
        try {
            final Object object = null;
            BytecodeManager.incBytecodes(5);
            final Itr itr = new Itr();
            BytecodeManager.incBytecodes(1);
            return itr;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public List<E> subList(final int n, final int n2) {
        try {
            final int size = this.size;
            BytecodeManager.incBytecodes(5);
            subListRangeCheck(n, n2, size);
            final int n3 = 0;
            BytecodeManager.incBytecodes(8);
            final SubList list = new SubList(this, n3, n, n2);
            BytecodeManager.incBytecodes(1);
            return list;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static void subListRangeCheck(final int n, final int n2, final int n3) {
        try {
            BytecodeManager.incBytecodes(2);
            if (n < 0) {
                BytecodeManager.incBytecodes(5);
                final StringBuilder sb = new StringBuilder();
                final String str = "fromIndex = ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb.append(str);
                BytecodeManager.incBytecodes(2);
                final StringBuilder append2 = append.append(n);
                BytecodeManager.incBytecodes(1);
                final String string = append2.toString();
                BytecodeManager.incBytecodes(1);
                final IndexOutOfBoundsException ex = new IndexOutOfBoundsException(string);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(3);
            if (n2 > n3) {
                BytecodeManager.incBytecodes(5);
                final StringBuilder sb2 = new StringBuilder();
                final String str2 = "toIndex = ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append3 = sb2.append(str2);
                BytecodeManager.incBytecodes(2);
                final StringBuilder append4 = append3.append(n2);
                BytecodeManager.incBytecodes(1);
                final String string2 = append4.toString();
                BytecodeManager.incBytecodes(1);
                final IndexOutOfBoundsException ex2 = new IndexOutOfBoundsException(string2);
                BytecodeManager.incBytecodes(1);
                throw ex2;
            }
            BytecodeManager.incBytecodes(3);
            if (n > n2) {
                BytecodeManager.incBytecodes(5);
                final StringBuilder sb3 = new StringBuilder();
                final String str3 = "fromIndex(";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append5 = sb3.append(str3);
                BytecodeManager.incBytecodes(2);
                final StringBuilder append6 = append5.append(n);
                final String str4 = ") > toIndex(";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append7 = append6.append(str4);
                BytecodeManager.incBytecodes(2);
                final StringBuilder append8 = append7.append(n2);
                final String str5 = ")";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append9 = append8.append(str5);
                BytecodeManager.incBytecodes(1);
                final String string3 = append9.toString();
                BytecodeManager.incBytecodes(1);
                final IllegalArgumentException ex3 = new IllegalArgumentException(string3);
                BytecodeManager.incBytecodes(1);
                throw ex3;
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void forEach(final Consumer<? super E> consumer) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(consumer);
            BytecodeManager.incBytecodes(1);
            final int modCount = this.modCount;
            BytecodeManager.incBytecodes(3);
            final Object[] array = this.elementData;
            BytecodeManager.incBytecodes(4);
            final int size = this.size;
            BytecodeManager.incBytecodes(3);
            int n = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int modCount2 = this.modCount;
                final int n2 = modCount;
                BytecodeManager.incBytecodes(4);
                if (modCount2 != n2) {
                    break;
                }
                final int n3 = n;
                final int n4 = size;
                BytecodeManager.incBytecodes(3);
                if (n3 >= n4) {
                    break;
                }
                final Object o = array[n];
                BytecodeManager.incBytecodes(5);
                consumer.accept((Object)o);
                ++n;
                BytecodeManager.incBytecodes(2);
            }
            final int modCount3 = this.modCount;
            final int n5 = modCount;
            BytecodeManager.incBytecodes(4);
            if (modCount3 != n5) {
                BytecodeManager.incBytecodes(3);
                final ConcurrentModificationException ex = new ConcurrentModificationException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public Spliterator<E> spliterator() {
        try {
            final int n = 0;
            final int n2 = -1;
            final int n3 = 0;
            BytecodeManager.incBytecodes(7);
            final ArrayListSpliterator arrayListSpliterator = new ArrayListSpliterator<E>(this, n, n2, n3);
            BytecodeManager.incBytecodes(1);
            return (Spliterator<E>)arrayListSpliterator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean removeIf(final Predicate<? super E> predicate) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(predicate);
            BytecodeManager.incBytecodes(1);
            int n = 0;
            BytecodeManager.incBytecodes(2);
            final int size = this.size;
            BytecodeManager.incBytecodes(5);
            final BitSet set = new BitSet(size);
            BytecodeManager.incBytecodes(1);
            final int modCount = this.modCount;
            BytecodeManager.incBytecodes(3);
            final int size2 = this.size;
            BytecodeManager.incBytecodes(3);
            int n2 = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int modCount2 = this.modCount;
                final int n3 = modCount;
                BytecodeManager.incBytecodes(4);
                if (modCount2 != n3) {
                    break;
                }
                final int n4 = n2;
                final int n5 = size2;
                BytecodeManager.incBytecodes(3);
                if (n4 >= n5) {
                    break;
                }
                final Object o = this.elementData[n2];
                BytecodeManager.incBytecodes(5);
                final Object o2 = o;
                BytecodeManager.incBytecodes(3);
                final boolean test = predicate.test((Object)o2);
                BytecodeManager.incBytecodes(1);
                if (test) {
                    final BitSet set2 = set;
                    final int n6 = n2;
                    BytecodeManager.incBytecodes(3);
                    set2.set(n6);
                    ++n;
                    BytecodeManager.incBytecodes(1);
                }
                ++n2;
                BytecodeManager.incBytecodes(2);
            }
            final int modCount3 = this.modCount;
            final int n7 = modCount;
            BytecodeManager.incBytecodes(4);
            if (modCount3 != n7) {
                BytecodeManager.incBytecodes(3);
                final ConcurrentModificationException ex = new ConcurrentModificationException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final int n8 = n;
            BytecodeManager.incBytecodes(2);
            int n9;
            if (n8 > 0) {
                n9 = 1;
                BytecodeManager.incBytecodes(2);
            }
            else {
                n9 = 0;
                BytecodeManager.incBytecodes(1);
            }
            final boolean b = n9 != 0;
            BytecodeManager.incBytecodes(1);
            final boolean b2 = b;
            BytecodeManager.incBytecodes(2);
            if (b2) {
                final int size3 = size2 - n;
                BytecodeManager.incBytecodes(4);
                int nextClearBit = 0;
                int n10 = 0;
                BytecodeManager.incBytecodes(4);
                while (true) {
                    final int n11 = nextClearBit;
                    final int n12 = size2;
                    BytecodeManager.incBytecodes(3);
                    if (n11 >= n12) {
                        break;
                    }
                    final int n13 = n10;
                    final int n14 = size3;
                    BytecodeManager.incBytecodes(3);
                    if (n13 >= n14) {
                        break;
                    }
                    final BitSet set3 = set;
                    final int n15 = nextClearBit;
                    BytecodeManager.incBytecodes(3);
                    nextClearBit = set3.nextClearBit(n15);
                    BytecodeManager.incBytecodes(1);
                    this.elementData[n10] = this.elementData[nextClearBit];
                    BytecodeManager.incBytecodes(8);
                    ++nextClearBit;
                    ++n10;
                    BytecodeManager.incBytecodes(3);
                }
                int n16 = size3;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n17 = n16;
                    final int n18 = size2;
                    BytecodeManager.incBytecodes(3);
                    if (n17 >= n18) {
                        break;
                    }
                    this.elementData[n16] = null;
                    BytecodeManager.incBytecodes(5);
                    ++n16;
                    BytecodeManager.incBytecodes(2);
                }
                this.size = size3;
                BytecodeManager.incBytecodes(3);
                final int modCount4 = this.modCount;
                final int n19 = modCount;
                BytecodeManager.incBytecodes(4);
                if (modCount4 != n19) {
                    BytecodeManager.incBytecodes(3);
                    final ConcurrentModificationException ex2 = new ConcurrentModificationException();
                    BytecodeManager.incBytecodes(1);
                    throw ex2;
                }
                ++this.modCount;
                BytecodeManager.incBytecodes(6);
            }
            final boolean b3 = b;
            BytecodeManager.incBytecodes(2);
            return b3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void replaceAll(final UnaryOperator<E> unaryOperator) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(unaryOperator);
            BytecodeManager.incBytecodes(1);
            final int modCount = this.modCount;
            BytecodeManager.incBytecodes(3);
            final int size = this.size;
            BytecodeManager.incBytecodes(3);
            int n = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int modCount2 = this.modCount;
                final int n2 = modCount;
                BytecodeManager.incBytecodes(4);
                if (modCount2 != n2) {
                    break;
                }
                final int n3 = n;
                final int n4 = size;
                BytecodeManager.incBytecodes(3);
                if (n3 >= n4) {
                    break;
                }
                final Object[] elementData = this.elementData;
                final int n5 = n;
                final Object o = this.elementData[n];
                BytecodeManager.incBytecodes(9);
                elementData[n5] = unaryOperator.apply((E)o);
                BytecodeManager.incBytecodes(1);
                ++n;
                BytecodeManager.incBytecodes(2);
            }
            final int modCount3 = this.modCount;
            final int n6 = modCount;
            BytecodeManager.incBytecodes(4);
            if (modCount3 != n6) {
                BytecodeManager.incBytecodes(3);
                final ConcurrentModificationException ex = new ConcurrentModificationException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            ++this.modCount;
            BytecodeManager.incBytecodes(6);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void sort(final Comparator<? super E> comparator) {
        try {
            final int modCount = this.modCount;
            BytecodeManager.incBytecodes(3);
            final Object[] array = this.elementData;
            final int n = 0;
            final int size = this.size;
            BytecodeManager.incBytecodes(8);
            Arrays.sort(array, n, size, (Comparator<? super Object>)comparator);
            final int modCount2 = this.modCount;
            final int n2 = modCount;
            BytecodeManager.incBytecodes(4);
            if (modCount2 != n2) {
                BytecodeManager.incBytecodes(3);
                final ConcurrentModificationException ex = new ConcurrentModificationException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            ++this.modCount;
            BytecodeManager.incBytecodes(6);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static /* synthetic */ int access$100(final ArrayList list) {
        try {
            final int size = list.size;
            BytecodeManager.incBytecodes(3);
            return size;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static {
        try {
            EMPTY_ELEMENTDATA = new Object[0];
            BytecodeManager.incBytecodes(2);
            DEFAULTCAPACITY_EMPTY_ELEMENTDATA = new Object[0];
            BytecodeManager.incBytecodes(3);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private class Itr implements Iterator<E>
    {
        int cursor;
        int lastRet;
        int expectedModCount;
        
        private Itr() {
            try {
                BytecodeManager.incBytecodes(5);
                this.lastRet = -1;
                BytecodeManager.incBytecodes(3);
                this.expectedModCount = ArrayList.this.modCount;
                BytecodeManager.incBytecodes(6);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean hasNext() {
            try {
                final int cursor = this.cursor;
                final ArrayList this$0 = ArrayList.this;
                BytecodeManager.incBytecodes(5);
                final int access$100 = ArrayList.access$100(this$0);
                BytecodeManager.incBytecodes(1);
                boolean b;
                if (cursor != access$100) {
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
        public E next() {
            try {
                BytecodeManager.incBytecodes(2);
                this.checkForComodification();
                final int cursor = this.cursor;
                BytecodeManager.incBytecodes(3);
                final int n = cursor;
                final ArrayList this$0 = ArrayList.this;
                BytecodeManager.incBytecodes(4);
                final int access$100 = ArrayList.access$100(this$0);
                BytecodeManager.incBytecodes(1);
                if (n >= access$100) {
                    BytecodeManager.incBytecodes(3);
                    final NoSuchElementException ex = new NoSuchElementException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final Object[] elementData = ArrayList.this.elementData;
                BytecodeManager.incBytecodes(4);
                final int n2 = cursor;
                final int length = elementData.length;
                BytecodeManager.incBytecodes(4);
                if (n2 >= length) {
                    BytecodeManager.incBytecodes(3);
                    final ConcurrentModificationException ex2 = new ConcurrentModificationException();
                    BytecodeManager.incBytecodes(1);
                    throw ex2;
                }
                this.cursor = cursor + 1;
                BytecodeManager.incBytecodes(5);
                final Object[] array = elementData;
                final int lastRet = cursor;
                this.lastRet = lastRet;
                final Object o = array[lastRet];
                BytecodeManager.incBytecodes(7);
                return (E)o;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void remove() {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: getfield        instrumented/java/util/ArrayList$Itr.lastRet:I
            //     4: ldc             3
            //     6: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //     9: ifge            30
            //    12: new             Ljava/lang/IllegalStateException;
            //    15: dup            
            //    16: ldc             3
            //    18: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    21: invokespecial   java/lang/IllegalStateException.<init>:()V
            //    24: ldc             1
            //    26: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    29: athrow         
            //    30: aload_0        
            //    31: ldc             2
            //    33: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    36: invokevirtual   instrumented/java/util/ArrayList$Itr.checkForComodification:()V
            //    39: aload_0        
            //    40: getfield        instrumented/java/util/ArrayList$Itr.this$0:Linstrumented/java/util/ArrayList;
            //    43: aload_0        
            //    44: getfield        instrumented/java/util/ArrayList$Itr.lastRet:I
            //    47: ldc             5
            //    49: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    52: invokevirtual   instrumented/java/util/ArrayList.remove:(I)Ljava/lang/Object;
            //    55: pop            
            //    56: ldc             1
            //    58: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    61: aload_0        
            //    62: aload_0        
            //    63: getfield        instrumented/java/util/ArrayList$Itr.lastRet:I
            //    66: putfield        instrumented/java/util/ArrayList$Itr.cursor:I
            //    69: ldc             4
            //    71: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    74: aload_0        
            //    75: iconst_m1      
            //    76: putfield        instrumented/java/util/ArrayList$Itr.lastRet:I
            //    79: ldc             3
            //    81: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    84: aload_0        
            //    85: aload_0        
            //    86: getfield        instrumented/java/util/ArrayList$Itr.this$0:Linstrumented/java/util/ArrayList;
            //    89: getfield        instrumented/java/util/ArrayList.modCount:I
            //    92: putfield        instrumented/java/util/ArrayList$Itr.expectedModCount:I
            //    95: ldc             5
            //    97: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   100: ldc             1
            //   102: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   105: goto            132
            //   108: astore_1       
            //   109: ldc             501
            //   111: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   114: new             Linstrumented/java/util/ConcurrentModificationException;
            //   117: dup            
            //   118: ldc             3
            //   120: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   123: invokespecial   instrumented/java/util/ConcurrentModificationException.<init>:()V
            //   126: ldc             1
            //   128: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   131: athrow         
            //   132: ldc             1
            //   134: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   137: return         
            //   138: athrow         
            //   139: athrow         
            //    StackMapTable: 00 05 1E F7 00 4D 07 00 4D 17 FF 00 05 00 00 00 01 07 00 2C FF 00 00 00 00 00 01 07 00 4B
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                                 
            //  -----  -----  -----  -----  -------------------------------------
            //  39     139    139    140    Ljava/lang/VirtualMachineError;
            //  39     100    108    132    Ljava/lang/IndexOutOfBoundsException;
            //  0      138    138    139    Any
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0132:
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
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:576)
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
        
        public void forEachRemaining(final Consumer<? super E> consumer) {
            try {
                BytecodeManager.incBytecodes(2);
                Objects.requireNonNull(consumer);
                BytecodeManager.incBytecodes(1);
                final ArrayList this$0 = ArrayList.this;
                BytecodeManager.incBytecodes(3);
                final int access$100 = ArrayList.access$100(this$0);
                BytecodeManager.incBytecodes(1);
                int cursor = this.cursor;
                BytecodeManager.incBytecodes(3);
                final int n = cursor;
                final int n2 = access$100;
                BytecodeManager.incBytecodes(3);
                if (n >= n2) {
                    BytecodeManager.incBytecodes(1);
                    return;
                }
                final Object[] elementData = ArrayList.this.elementData;
                BytecodeManager.incBytecodes(4);
                final int n3 = cursor;
                final int length = elementData.length;
                BytecodeManager.incBytecodes(4);
                if (n3 >= length) {
                    BytecodeManager.incBytecodes(3);
                    final ConcurrentModificationException ex = new ConcurrentModificationException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                while (true) {
                    final int n4 = cursor;
                    final int n5 = access$100;
                    BytecodeManager.incBytecodes(3);
                    if (n4 == n5) {
                        break;
                    }
                    final int modCount = ArrayList.this.modCount;
                    final int expectedModCount = this.expectedModCount;
                    BytecodeManager.incBytecodes(6);
                    if (modCount != expectedModCount) {
                        break;
                    }
                    final Object o = elementData[cursor++];
                    BytecodeManager.incBytecodes(6);
                    consumer.accept((Object)o);
                    BytecodeManager.incBytecodes(1);
                }
                this.cursor = cursor;
                BytecodeManager.incBytecodes(3);
                this.lastRet = cursor - 1;
                BytecodeManager.incBytecodes(5);
                BytecodeManager.incBytecodes(2);
                this.checkForComodification();
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        final void checkForComodification() {
            try {
                final int modCount = ArrayList.this.modCount;
                final int expectedModCount = this.expectedModCount;
                BytecodeManager.incBytecodes(6);
                if (modCount != expectedModCount) {
                    BytecodeManager.incBytecodes(3);
                    final ConcurrentModificationException ex = new ConcurrentModificationException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private class ListItr extends Itr implements ListIterator<E>
    {
        ListItr(final int cursor) {
            try {
                BytecodeManager.incBytecodes(3);
                final Object object = null;
                BytecodeManager.incBytecodes(4);
                this.cursor = cursor;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean hasPrevious() {
            try {
                final int cursor = this.cursor;
                BytecodeManager.incBytecodes(3);
                boolean b;
                if (cursor != 0) {
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
        public int nextIndex() {
            try {
                final int cursor = this.cursor;
                BytecodeManager.incBytecodes(3);
                return cursor;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int previousIndex() {
            try {
                final int n = this.cursor - 1;
                BytecodeManager.incBytecodes(5);
                return n;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public E previous() {
            try {
                BytecodeManager.incBytecodes(2);
                this.checkForComodification();
                final int cursor = this.cursor - 1;
                BytecodeManager.incBytecodes(5);
                final int n = cursor;
                BytecodeManager.incBytecodes(2);
                if (n < 0) {
                    BytecodeManager.incBytecodes(3);
                    final NoSuchElementException ex = new NoSuchElementException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final Object[] elementData = ArrayList.this.elementData;
                BytecodeManager.incBytecodes(4);
                final int n2 = cursor;
                final int length = elementData.length;
                BytecodeManager.incBytecodes(4);
                if (n2 >= length) {
                    BytecodeManager.incBytecodes(3);
                    final ConcurrentModificationException ex2 = new ConcurrentModificationException();
                    BytecodeManager.incBytecodes(1);
                    throw ex2;
                }
                this.cursor = cursor;
                BytecodeManager.incBytecodes(3);
                final Object[] array = elementData;
                final int lastRet = cursor;
                this.lastRet = lastRet;
                final Object o = array[lastRet];
                BytecodeManager.incBytecodes(7);
                return (E)o;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void set(final E p0) {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: getfield        instrumented/java/util/ArrayList$ListItr.lastRet:I
            //     4: ldc             3
            //     6: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //     9: ifge            30
            //    12: new             Ljava/lang/IllegalStateException;
            //    15: dup            
            //    16: ldc             3
            //    18: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    21: invokespecial   java/lang/IllegalStateException.<init>:()V
            //    24: ldc             1
            //    26: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    29: athrow         
            //    30: aload_0        
            //    31: ldc             2
            //    33: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    36: invokevirtual   instrumented/java/util/ArrayList$ListItr.checkForComodification:()V
            //    39: aload_0        
            //    40: getfield        instrumented/java/util/ArrayList$ListItr.this$0:Linstrumented/java/util/ArrayList;
            //    43: aload_0        
            //    44: getfield        instrumented/java/util/ArrayList$ListItr.lastRet:I
            //    47: aload_1        
            //    48: ldc             6
            //    50: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    53: invokevirtual   instrumented/java/util/ArrayList.set:(ILjava/lang/Object;)Ljava/lang/Object;
            //    56: pop            
            //    57: ldc             1
            //    59: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    62: ldc             1
            //    64: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    67: goto            94
            //    70: astore_2       
            //    71: ldc             501
            //    73: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    76: new             Linstrumented/java/util/ConcurrentModificationException;
            //    79: dup            
            //    80: ldc             3
            //    82: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    85: invokespecial   instrumented/java/util/ConcurrentModificationException.<init>:()V
            //    88: ldc             1
            //    90: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    93: athrow         
            //    94: ldc             1
            //    96: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    99: return         
            //   100: athrow         
            //   101: athrow         
            //    Signature:
            //  (TE;)V
            //    StackMapTable: 00 05 1E 67 07 00 49 17 FF 00 05 00 00 00 01 07 00 26 FF 00 00 00 00 00 01 07 00 47
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                                 
            //  -----  -----  -----  -----  -------------------------------------
            //  39     101    101    102    Ljava/lang/VirtualMachineError;
            //  39     62     70     94     Ljava/lang/IndexOutOfBoundsException;
            //  0      100    100    101    Any
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0094:
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
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:576)
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
        
        @Override
        public void add(final E p0) {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: ldc             2
            //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //     6: invokevirtual   instrumented/java/util/ArrayList$ListItr.checkForComodification:()V
            //     9: aload_0        
            //    10: getfield        instrumented/java/util/ArrayList$ListItr.cursor:I
            //    13: istore_2       
            //    14: ldc             3
            //    16: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    19: aload_0        
            //    20: getfield        instrumented/java/util/ArrayList$ListItr.this$0:Linstrumented/java/util/ArrayList;
            //    23: iload_2        
            //    24: aload_1        
            //    25: ldc             5
            //    27: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    30: invokevirtual   instrumented/java/util/ArrayList.add:(ILjava/lang/Object;)V
            //    33: aload_0        
            //    34: iload_2        
            //    35: iconst_1       
            //    36: iadd           
            //    37: putfield        instrumented/java/util/ArrayList$ListItr.cursor:I
            //    40: ldc             5
            //    42: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    45: aload_0        
            //    46: iconst_m1      
            //    47: putfield        instrumented/java/util/ArrayList$ListItr.lastRet:I
            //    50: ldc             3
            //    52: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    55: aload_0        
            //    56: aload_0        
            //    57: getfield        instrumented/java/util/ArrayList$ListItr.this$0:Linstrumented/java/util/ArrayList;
            //    60: getfield        instrumented/java/util/ArrayList.modCount:I
            //    63: putfield        instrumented/java/util/ArrayList$ListItr.expectedModCount:I
            //    66: ldc             5
            //    68: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    71: ldc             1
            //    73: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    76: goto            103
            //    79: astore_2       
            //    80: ldc             501
            //    82: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    85: new             Linstrumented/java/util/ConcurrentModificationException;
            //    88: dup            
            //    89: ldc             3
            //    91: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    94: invokespecial   instrumented/java/util/ConcurrentModificationException.<init>:()V
            //    97: ldc             1
            //    99: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   102: athrow         
            //   103: ldc             1
            //   105: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   108: return         
            //   109: athrow         
            //   110: athrow         
            //    Signature:
            //  (TE;)V
            //    StackMapTable: 00 04 F7 00 4F 07 00 49 17 FF 00 05 00 00 00 01 07 00 26 FF 00 00 00 00 00 01 07 00 47
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                                 
            //  -----  -----  -----  -----  -------------------------------------
            //  9      110    110    111    Ljava/lang/VirtualMachineError;
            //  9      71     79     103    Ljava/lang/IndexOutOfBoundsException;
            //  0      109    109    110    Any
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0103:
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
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:576)
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
    
    private class SubList extends AbstractList<E> implements RandomAccess
    {
        private final AbstractList<E> parent;
        private final int parentOffset;
        private final int offset;
        int size;
        
        SubList(final AbstractList<E> parent, final int n, final int parentOffset, final int n2) {
            try {
                BytecodeManager.incBytecodes(5);
                this.parent = parent;
                BytecodeManager.incBytecodes(3);
                this.parentOffset = parentOffset;
                BytecodeManager.incBytecodes(3);
                this.offset = n + parentOffset;
                BytecodeManager.incBytecodes(5);
                this.size = n2 - parentOffset;
                BytecodeManager.incBytecodes(5);
                this.modCount = ArrayList.this.modCount;
                BytecodeManager.incBytecodes(4);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public E set(final int n, final E e) {
            try {
                BytecodeManager.incBytecodes(3);
                this.rangeCheck(n);
                BytecodeManager.incBytecodes(2);
                this.checkForComodification();
                final ArrayList this$0 = ArrayList.this;
                final int n2 = this.offset + n;
                BytecodeManager.incBytecodes(7);
                final Object elementData = this$0.elementData(n2);
                BytecodeManager.incBytecodes(1);
                ArrayList.this.elementData[this.offset + n] = e;
                BytecodeManager.incBytecodes(9);
                final Object o = elementData;
                BytecodeManager.incBytecodes(2);
                return (E)o;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public E get(final int n) {
            try {
                BytecodeManager.incBytecodes(3);
                this.rangeCheck(n);
                BytecodeManager.incBytecodes(2);
                this.checkForComodification();
                final ArrayList this$0 = ArrayList.this;
                final int n2 = this.offset + n;
                BytecodeManager.incBytecodes(7);
                final Object elementData = this$0.elementData(n2);
                BytecodeManager.incBytecodes(1);
                return (E)elementData;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int size() {
            try {
                BytecodeManager.incBytecodes(2);
                this.checkForComodification();
                final int size = this.size;
                BytecodeManager.incBytecodes(3);
                return size;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void add(final int n, final E e) {
            try {
                BytecodeManager.incBytecodes(3);
                this.rangeCheckForAdd(n);
                BytecodeManager.incBytecodes(2);
                this.checkForComodification();
                final AbstractList<E> parent = this.parent;
                final int n2 = this.parentOffset + n;
                BytecodeManager.incBytecodes(8);
                parent.add(n2, e);
                this.modCount = this.parent.modCount;
                BytecodeManager.incBytecodes(5);
                ++this.size;
                BytecodeManager.incBytecodes(6);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public E remove(final int n) {
            try {
                BytecodeManager.incBytecodes(3);
                this.rangeCheck(n);
                BytecodeManager.incBytecodes(2);
                this.checkForComodification();
                final AbstractList<E> parent = this.parent;
                final int n2 = this.parentOffset + n;
                BytecodeManager.incBytecodes(7);
                final E remove = parent.remove(n2);
                BytecodeManager.incBytecodes(1);
                this.modCount = this.parent.modCount;
                BytecodeManager.incBytecodes(5);
                --this.size;
                BytecodeManager.incBytecodes(6);
                final E e = remove;
                BytecodeManager.incBytecodes(2);
                return e;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        protected void removeRange(final int n, final int n2) {
            try {
                BytecodeManager.incBytecodes(2);
                this.checkForComodification();
                final AbstractList<E> parent = this.parent;
                final int n3 = this.parentOffset + n;
                final int n4 = this.parentOffset + n2;
                BytecodeManager.incBytecodes(11);
                parent.removeRange(n3, n4);
                this.modCount = this.parent.modCount;
                BytecodeManager.incBytecodes(5);
                this.size -= n2 - n;
                BytecodeManager.incBytecodes(8);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean addAll(final Collection<? extends E> collection) {
            try {
                final int size = this.size;
                BytecodeManager.incBytecodes(5);
                final boolean addAll = this.addAll(size, collection);
                BytecodeManager.incBytecodes(1);
                return addAll;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean addAll(final int n, final Collection<? extends E> collection) {
            try {
                BytecodeManager.incBytecodes(3);
                this.rangeCheckForAdd(n);
                BytecodeManager.incBytecodes(2);
                final int size = collection.size();
                BytecodeManager.incBytecodes(1);
                final int n2 = size;
                BytecodeManager.incBytecodes(2);
                if (n2 == 0) {
                    final boolean b = false;
                    BytecodeManager.incBytecodes(2);
                    return b;
                }
                BytecodeManager.incBytecodes(2);
                this.checkForComodification();
                final AbstractList<E> parent = this.parent;
                final int n3 = this.parentOffset + n;
                BytecodeManager.incBytecodes(8);
                parent.addAll(n3, collection);
                BytecodeManager.incBytecodes(1);
                this.modCount = this.parent.modCount;
                BytecodeManager.incBytecodes(5);
                this.size += size;
                BytecodeManager.incBytecodes(6);
                final boolean b2 = true;
                BytecodeManager.incBytecodes(2);
                return b2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Iterator<E> iterator() {
            try {
                BytecodeManager.incBytecodes(2);
                final ListIterator<E> listIterator = this.listIterator();
                BytecodeManager.incBytecodes(1);
                return listIterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public ListIterator<E> listIterator(final int n) {
            try {
                BytecodeManager.incBytecodes(2);
                this.checkForComodification();
                BytecodeManager.incBytecodes(3);
                this.rangeCheckForAdd(n);
                final int offset = this.offset;
                BytecodeManager.incBytecodes(3);
                final int n2 = offset;
                BytecodeManager.incBytecodes(6);
                final ListIterator<E> listIterator = new ListIterator<E>() {
                    int cursor = n;
                    int lastRet;
                    int expectedModCount;
                    
                    {
                        BytecodeManager.incBytecodes(4);
                        this.lastRet = -1;
                        BytecodeManager.incBytecodes(3);
                        this.expectedModCount = ArrayList.this.modCount;
                        BytecodeManager.incBytecodes(7);
                    }
                    
                    @Override
                    public boolean hasNext() {
                        try {
                            final int cursor = this.cursor;
                            final int size = SubList.this.size;
                            BytecodeManager.incBytecodes(6);
                            boolean b;
                            if (cursor != size) {
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
                    public E next() {
                        try {
                            BytecodeManager.incBytecodes(2);
                            this.checkForComodification();
                            final int cursor = this.cursor;
                            BytecodeManager.incBytecodes(3);
                            final int n = cursor;
                            final int size = SubList.this.size;
                            BytecodeManager.incBytecodes(5);
                            if (n >= size) {
                                BytecodeManager.incBytecodes(3);
                                final NoSuchElementException ex = new NoSuchElementException();
                                BytecodeManager.incBytecodes(1);
                                throw ex;
                            }
                            final Object[] elementData = ArrayList.this.elementData;
                            BytecodeManager.incBytecodes(5);
                            final int n2 = n2 + cursor;
                            final int length = elementData.length;
                            BytecodeManager.incBytecodes(7);
                            if (n2 >= length) {
                                BytecodeManager.incBytecodes(3);
                                final ConcurrentModificationException ex2 = new ConcurrentModificationException();
                                BytecodeManager.incBytecodes(1);
                                throw ex2;
                            }
                            this.cursor = cursor + 1;
                            BytecodeManager.incBytecodes(5);
                            final Object[] array = elementData;
                            final int val$offset = n2;
                            final int lastRet = cursor;
                            this.lastRet = lastRet;
                            final Object o = array[val$offset + lastRet];
                            BytecodeManager.incBytecodes(10);
                            return (E)o;
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                    
                    @Override
                    public boolean hasPrevious() {
                        try {
                            final int cursor = this.cursor;
                            BytecodeManager.incBytecodes(3);
                            boolean b;
                            if (cursor != 0) {
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
                    public E previous() {
                        try {
                            BytecodeManager.incBytecodes(2);
                            this.checkForComodification();
                            final int cursor = this.cursor - 1;
                            BytecodeManager.incBytecodes(5);
                            final int n = cursor;
                            BytecodeManager.incBytecodes(2);
                            if (n < 0) {
                                BytecodeManager.incBytecodes(3);
                                final NoSuchElementException ex = new NoSuchElementException();
                                BytecodeManager.incBytecodes(1);
                                throw ex;
                            }
                            final Object[] elementData = ArrayList.this.elementData;
                            BytecodeManager.incBytecodes(5);
                            final int n2 = n2 + cursor;
                            final int length = elementData.length;
                            BytecodeManager.incBytecodes(7);
                            if (n2 >= length) {
                                BytecodeManager.incBytecodes(3);
                                final ConcurrentModificationException ex2 = new ConcurrentModificationException();
                                BytecodeManager.incBytecodes(1);
                                throw ex2;
                            }
                            this.cursor = cursor;
                            BytecodeManager.incBytecodes(3);
                            final Object[] array = elementData;
                            final int val$offset = n2;
                            final int lastRet = cursor;
                            this.lastRet = lastRet;
                            final Object o = array[val$offset + lastRet];
                            BytecodeManager.incBytecodes(10);
                            return (E)o;
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                    
                    public void forEachRemaining(final Consumer<? super E> consumer) {
                        try {
                            BytecodeManager.incBytecodes(2);
                            Objects.requireNonNull(consumer);
                            BytecodeManager.incBytecodes(1);
                            final int size = SubList.this.size;
                            BytecodeManager.incBytecodes(4);
                            int cursor = this.cursor;
                            BytecodeManager.incBytecodes(3);
                            final int n = cursor;
                            final int n2 = size;
                            BytecodeManager.incBytecodes(3);
                            if (n >= n2) {
                                BytecodeManager.incBytecodes(1);
                                return;
                            }
                            final Object[] elementData = ArrayList.this.elementData;
                            BytecodeManager.incBytecodes(5);
                            final int n3 = n2 + cursor;
                            final int length = elementData.length;
                            BytecodeManager.incBytecodes(7);
                            if (n3 >= length) {
                                BytecodeManager.incBytecodes(3);
                                final ConcurrentModificationException ex = new ConcurrentModificationException();
                                BytecodeManager.incBytecodes(1);
                                throw ex;
                            }
                            while (true) {
                                final int n4 = cursor;
                                final int n5 = size;
                                BytecodeManager.incBytecodes(3);
                                if (n4 == n5) {
                                    break;
                                }
                                final int modCount = SubList.this.modCount;
                                final int expectedModCount = this.expectedModCount;
                                BytecodeManager.incBytecodes(6);
                                if (modCount != expectedModCount) {
                                    break;
                                }
                                final Object o = elementData[n2 + cursor++];
                                BytecodeManager.incBytecodes(9);
                                consumer.accept((Object)o);
                                BytecodeManager.incBytecodes(1);
                            }
                            final int n6 = cursor;
                            this.cursor = n6;
                            this.lastRet = n6;
                            BytecodeManager.incBytecodes(6);
                            BytecodeManager.incBytecodes(2);
                            this.checkForComodification();
                            BytecodeManager.incBytecodes(1);
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                    
                    @Override
                    public int nextIndex() {
                        try {
                            final int cursor = this.cursor;
                            BytecodeManager.incBytecodes(3);
                            return cursor;
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                    
                    @Override
                    public int previousIndex() {
                        try {
                            final int n = this.cursor - 1;
                            BytecodeManager.incBytecodes(5);
                            return n;
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                    
                    @Override
                    public void remove() {
                        // 
                        // This method could not be decompiled.
                        // 
                        // Original Bytecode:
                        // 
                        //     1: getfield        instrumented/java/util/ArrayList$SubList$1.lastRet:I
                        //     4: ldc             3
                        //     6: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                        //     9: ifge            30
                        //    12: new             Ljava/lang/IllegalStateException;
                        //    15: dup            
                        //    16: ldc             3
                        //    18: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                        //    21: invokespecial   java/lang/IllegalStateException.<init>:()V
                        //    24: ldc             1
                        //    26: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                        //    29: athrow         
                        //    30: aload_0        
                        //    31: ldc             2
                        //    33: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                        //    36: invokevirtual   instrumented/java/util/ArrayList$SubList$1.checkForComodification:()V
                        //    39: aload_0        
                        //    40: getfield        instrumented/java/util/ArrayList$SubList$1.this$1:Linstrumented/java/util/ArrayList$SubList;
                        //    43: aload_0        
                        //    44: getfield        instrumented/java/util/ArrayList$SubList$1.lastRet:I
                        //    47: ldc             5
                        //    49: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                        //    52: invokevirtual   instrumented/java/util/ArrayList$SubList.remove:(I)Ljava/lang/Object;
                        //    55: pop            
                        //    56: ldc             1
                        //    58: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                        //    61: aload_0        
                        //    62: aload_0        
                        //    63: getfield        instrumented/java/util/ArrayList$SubList$1.lastRet:I
                        //    66: putfield        instrumented/java/util/ArrayList$SubList$1.cursor:I
                        //    69: ldc             4
                        //    71: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                        //    74: aload_0        
                        //    75: iconst_m1      
                        //    76: putfield        instrumented/java/util/ArrayList$SubList$1.lastRet:I
                        //    79: ldc             3
                        //    81: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                        //    84: aload_0        
                        //    85: aload_0        
                        //    86: getfield        instrumented/java/util/ArrayList$SubList$1.this$1:Linstrumented/java/util/ArrayList$SubList;
                        //    89: getfield        instrumented/java/util/ArrayList$SubList.this$0:Linstrumented/java/util/ArrayList;
                        //    92: getfield        instrumented/java/util/ArrayList.modCount:I
                        //    95: putfield        instrumented/java/util/ArrayList$SubList$1.expectedModCount:I
                        //    98: ldc             6
                        //   100: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                        //   103: ldc             1
                        //   105: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                        //   108: goto            135
                        //   111: astore_1       
                        //   112: ldc             501
                        //   114: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                        //   117: new             Linstrumented/java/util/ConcurrentModificationException;
                        //   120: dup            
                        //   121: ldc             3
                        //   123: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                        //   126: invokespecial   instrumented/java/util/ConcurrentModificationException.<init>:()V
                        //   129: ldc             1
                        //   131: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                        //   134: athrow         
                        //   135: ldc             1
                        //   137: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                        //   140: return         
                        //   141: athrow         
                        //   142: athrow         
                        //    StackMapTable: 00 05 1E F7 00 50 07 00 70 17 FF 00 05 00 00 00 01 07 00 3C FF 00 00 00 00 00 01 07 00 6E
                        //    Exceptions:
                        //  Try           Handler
                        //  Start  End    Start  End    Type                                 
                        //  -----  -----  -----  -----  -------------------------------------
                        //  39     142    142    143    Ljava/lang/VirtualMachineError;
                        //  39     103    111    135    Ljava/lang/IndexOutOfBoundsException;
                        //  0      141    141    142    Any
                        // 
                        // The error that occurred was:
                        // 
                        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0135:
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
                        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformCall(AstMethodBodyBuilder.java:1164)
                        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformByteCode(AstMethodBodyBuilder.java:1009)
                        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformExpression(AstMethodBodyBuilder.java:540)
                        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformByteCode(AstMethodBodyBuilder.java:554)
                        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformExpression(AstMethodBodyBuilder.java:540)
                        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformNode(AstMethodBodyBuilder.java:392)
                        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformBlock(AstMethodBodyBuilder.java:333)
                        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformNode(AstMethodBodyBuilder.java:494)
                        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformBlock(AstMethodBodyBuilder.java:333)
                        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:294)
                        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
                        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
                        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
                        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
                        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
                        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
                        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:576)
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
                    
                    @Override
                    public void set(final E p0) {
                        // 
                        // This method could not be decompiled.
                        // 
                        // Original Bytecode:
                        // 
                        //     1: getfield        instrumented/java/util/ArrayList$SubList$1.lastRet:I
                        //     4: ldc             3
                        //     6: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                        //     9: ifge            30
                        //    12: new             Ljava/lang/IllegalStateException;
                        //    15: dup            
                        //    16: ldc             3
                        //    18: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                        //    21: invokespecial   java/lang/IllegalStateException.<init>:()V
                        //    24: ldc             1
                        //    26: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                        //    29: athrow         
                        //    30: aload_0        
                        //    31: ldc             2
                        //    33: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                        //    36: invokevirtual   instrumented/java/util/ArrayList$SubList$1.checkForComodification:()V
                        //    39: aload_0        
                        //    40: getfield        instrumented/java/util/ArrayList$SubList$1.this$1:Linstrumented/java/util/ArrayList$SubList;
                        //    43: getfield        instrumented/java/util/ArrayList$SubList.this$0:Linstrumented/java/util/ArrayList;
                        //    46: aload_0        
                        //    47: getfield        instrumented/java/util/ArrayList$SubList$1.val$offset:I
                        //    50: aload_0        
                        //    51: getfield        instrumented/java/util/ArrayList$SubList$1.lastRet:I
                        //    54: iadd           
                        //    55: aload_1        
                        //    56: ldc             10
                        //    58: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                        //    61: invokevirtual   instrumented/java/util/ArrayList.set:(ILjava/lang/Object;)Ljava/lang/Object;
                        //    64: pop            
                        //    65: ldc             1
                        //    67: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                        //    70: ldc             1
                        //    72: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                        //    75: goto            102
                        //    78: astore_2       
                        //    79: ldc             501
                        //    81: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                        //    84: new             Linstrumented/java/util/ConcurrentModificationException;
                        //    87: dup            
                        //    88: ldc             3
                        //    90: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                        //    93: invokespecial   instrumented/java/util/ConcurrentModificationException.<init>:()V
                        //    96: ldc             1
                        //    98: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                        //   101: athrow         
                        //   102: ldc             1
                        //   104: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                        //   107: return         
                        //   108: athrow         
                        //   109: athrow         
                        //    Signature:
                        //  (TE;)V
                        //    StackMapTable: 00 05 1E 6F 07 00 70 17 FF 00 05 00 00 00 01 07 00 3C FF 00 00 00 00 00 01 07 00 6E
                        //    Exceptions:
                        //  Try           Handler
                        //  Start  End    Start  End    Type                                 
                        //  -----  -----  -----  -----  -------------------------------------
                        //  39     109    109    110    Ljava/lang/VirtualMachineError;
                        //  39     70     78     102    Ljava/lang/IndexOutOfBoundsException;
                        //  0      108    108    109    Any
                        // 
                        // The error that occurred was:
                        // 
                        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0102:
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
                        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformCall(AstMethodBodyBuilder.java:1164)
                        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformByteCode(AstMethodBodyBuilder.java:1009)
                        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformExpression(AstMethodBodyBuilder.java:540)
                        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformByteCode(AstMethodBodyBuilder.java:554)
                        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformExpression(AstMethodBodyBuilder.java:540)
                        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformNode(AstMethodBodyBuilder.java:392)
                        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformBlock(AstMethodBodyBuilder.java:333)
                        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformNode(AstMethodBodyBuilder.java:494)
                        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformBlock(AstMethodBodyBuilder.java:333)
                        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:294)
                        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
                        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
                        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
                        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
                        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
                        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
                        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:576)
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
                    
                    @Override
                    public void add(final E p0) {
                        // 
                        // This method could not be decompiled.
                        // 
                        // Original Bytecode:
                        // 
                        //     1: ldc             2
                        //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                        //     6: invokevirtual   instrumented/java/util/ArrayList$SubList$1.checkForComodification:()V
                        //     9: aload_0        
                        //    10: getfield        instrumented/java/util/ArrayList$SubList$1.cursor:I
                        //    13: istore_2       
                        //    14: ldc             3
                        //    16: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                        //    19: aload_0        
                        //    20: getfield        instrumented/java/util/ArrayList$SubList$1.this$1:Linstrumented/java/util/ArrayList$SubList;
                        //    23: iload_2        
                        //    24: aload_1        
                        //    25: ldc             5
                        //    27: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                        //    30: invokevirtual   instrumented/java/util/ArrayList$SubList.add:(ILjava/lang/Object;)V
                        //    33: aload_0        
                        //    34: iload_2        
                        //    35: iconst_1       
                        //    36: iadd           
                        //    37: putfield        instrumented/java/util/ArrayList$SubList$1.cursor:I
                        //    40: ldc             5
                        //    42: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                        //    45: aload_0        
                        //    46: iconst_m1      
                        //    47: putfield        instrumented/java/util/ArrayList$SubList$1.lastRet:I
                        //    50: ldc             3
                        //    52: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                        //    55: aload_0        
                        //    56: aload_0        
                        //    57: getfield        instrumented/java/util/ArrayList$SubList$1.this$1:Linstrumented/java/util/ArrayList$SubList;
                        //    60: getfield        instrumented/java/util/ArrayList$SubList.this$0:Linstrumented/java/util/ArrayList;
                        //    63: getfield        instrumented/java/util/ArrayList.modCount:I
                        //    66: putfield        instrumented/java/util/ArrayList$SubList$1.expectedModCount:I
                        //    69: ldc             6
                        //    71: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                        //    74: ldc             1
                        //    76: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                        //    79: goto            106
                        //    82: astore_2       
                        //    83: ldc             501
                        //    85: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                        //    88: new             Linstrumented/java/util/ConcurrentModificationException;
                        //    91: dup            
                        //    92: ldc             3
                        //    94: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                        //    97: invokespecial   instrumented/java/util/ConcurrentModificationException.<init>:()V
                        //   100: ldc             1
                        //   102: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                        //   105: athrow         
                        //   106: ldc             1
                        //   108: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                        //   111: return         
                        //   112: athrow         
                        //   113: athrow         
                        //    Signature:
                        //  (TE;)V
                        //    StackMapTable: 00 04 F7 00 52 07 00 70 17 FF 00 05 00 00 00 01 07 00 3C FF 00 00 00 00 00 01 07 00 6E
                        //    Exceptions:
                        //  Try           Handler
                        //  Start  End    Start  End    Type                                 
                        //  -----  -----  -----  -----  -------------------------------------
                        //  9      113    113    114    Ljava/lang/VirtualMachineError;
                        //  9      74     82     106    Ljava/lang/IndexOutOfBoundsException;
                        //  0      112    112    113    Any
                        // 
                        // The error that occurred was:
                        // 
                        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0106:
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
                        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformCall(AstMethodBodyBuilder.java:1164)
                        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformByteCode(AstMethodBodyBuilder.java:1009)
                        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformExpression(AstMethodBodyBuilder.java:540)
                        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformByteCode(AstMethodBodyBuilder.java:554)
                        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformExpression(AstMethodBodyBuilder.java:540)
                        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformNode(AstMethodBodyBuilder.java:392)
                        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformBlock(AstMethodBodyBuilder.java:333)
                        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformNode(AstMethodBodyBuilder.java:494)
                        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformBlock(AstMethodBodyBuilder.java:333)
                        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:294)
                        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
                        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
                        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
                        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
                        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
                        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
                        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:576)
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
                    
                    final void checkForComodification() {
                        try {
                            final int expectedModCount = this.expectedModCount;
                            final int modCount = ArrayList.this.modCount;
                            BytecodeManager.incBytecodes(7);
                            if (expectedModCount != modCount) {
                                BytecodeManager.incBytecodes(3);
                                final ConcurrentModificationException ex = new ConcurrentModificationException();
                                BytecodeManager.incBytecodes(1);
                                throw ex;
                            }
                            BytecodeManager.incBytecodes(1);
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                };
                BytecodeManager.incBytecodes(1);
                return listIterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public List<E> subList(final int n, final int n2) {
            try {
                final int size = this.size;
                BytecodeManager.incBytecodes(5);
                ArrayList.subListRangeCheck(n, n2, size);
                final ArrayList this$0 = ArrayList.this;
                final int offset = this.offset;
                BytecodeManager.incBytecodes(10);
                final SubList list = new SubList(this, offset, n, n2);
                BytecodeManager.incBytecodes(1);
                return list;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private void rangeCheck(final int n) {
            try {
                BytecodeManager.incBytecodes(2);
                if (n >= 0) {
                    final int size = this.size;
                    BytecodeManager.incBytecodes(4);
                    if (n < size) {
                        BytecodeManager.incBytecodes(1);
                        return;
                    }
                }
                BytecodeManager.incBytecodes(5);
                final String outOfBoundsMsg = this.outOfBoundsMsg(n);
                BytecodeManager.incBytecodes(1);
                final IndexOutOfBoundsException ex = new IndexOutOfBoundsException(outOfBoundsMsg);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private void rangeCheckForAdd(final int n) {
            try {
                BytecodeManager.incBytecodes(2);
                if (n >= 0) {
                    final int size = this.size;
                    BytecodeManager.incBytecodes(4);
                    if (n <= size) {
                        BytecodeManager.incBytecodes(1);
                        return;
                    }
                }
                BytecodeManager.incBytecodes(5);
                final String outOfBoundsMsg = this.outOfBoundsMsg(n);
                BytecodeManager.incBytecodes(1);
                final IndexOutOfBoundsException ex = new IndexOutOfBoundsException(outOfBoundsMsg);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private String outOfBoundsMsg(final int i) {
            try {
                BytecodeManager.incBytecodes(3);
                final StringBuilder sb = new StringBuilder();
                final String str = "Index: ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb.append(str);
                BytecodeManager.incBytecodes(2);
                final StringBuilder append2 = append.append(i);
                final String str2 = ", Size: ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append3 = append2.append(str2);
                final int size = this.size;
                BytecodeManager.incBytecodes(3);
                final StringBuilder append4 = append3.append(size);
                BytecodeManager.incBytecodes(1);
                final String string = append4.toString();
                BytecodeManager.incBytecodes(1);
                return string;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private void checkForComodification() {
            try {
                final int modCount = ArrayList.this.modCount;
                final int modCount2 = this.modCount;
                BytecodeManager.incBytecodes(6);
                if (modCount != modCount2) {
                    BytecodeManager.incBytecodes(3);
                    final ConcurrentModificationException ex = new ConcurrentModificationException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Spliterator<E> spliterator() {
            try {
                BytecodeManager.incBytecodes(2);
                this.checkForComodification();
                final ArrayList this$0 = ArrayList.this;
                final int offset = this.offset;
                final int n = this.offset + this.size;
                final int modCount = this.modCount;
                BytecodeManager.incBytecodes(14);
                final ArrayListSpliterator arrayListSpliterator = new ArrayListSpliterator<E>(this$0, offset, n, modCount);
                BytecodeManager.incBytecodes(1);
                return (Spliterator<E>)arrayListSpliterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class ArrayListSpliterator<E> implements Spliterator<E>
    {
        private final ArrayList<E> list;
        private int index;
        private int fence;
        private int expectedModCount;
        
        ArrayListSpliterator(final ArrayList<E> list, final int index, final int fence, final int expectedModCount) {
            try {
                BytecodeManager.incBytecodes(2);
                this.list = list;
                BytecodeManager.incBytecodes(3);
                this.index = index;
                BytecodeManager.incBytecodes(3);
                this.fence = fence;
                BytecodeManager.incBytecodes(3);
                this.expectedModCount = expectedModCount;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private int getFence() {
            try {
                int fence = this.fence;
                BytecodeManager.incBytecodes(5);
                if (fence < 0) {
                    final ArrayList<E> list2;
                    final ArrayList<E> list = list2 = this.list;
                    BytecodeManager.incBytecodes(5);
                    if (list == null) {
                        final int fence2 = 0;
                        this.fence = fence2;
                        fence = fence2;
                        BytecodeManager.incBytecodes(6);
                    }
                    else {
                        this.expectedModCount = list2.modCount;
                        BytecodeManager.incBytecodes(4);
                        final ArrayList<Object> list3 = (ArrayList<Object>)list2;
                        BytecodeManager.incBytecodes(3);
                        final int access$100 = ArrayList.access$100(list3);
                        this.fence = access$100;
                        fence = access$100;
                        BytecodeManager.incBytecodes(3);
                    }
                }
                final int n = fence;
                BytecodeManager.incBytecodes(2);
                return n;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public ArrayListSpliterator<E> trySplit() {
            try {
                BytecodeManager.incBytecodes(2);
                final int fence = this.getFence();
                final int index = this.index;
                final int n = index + fence >>> 1;
                BytecodeManager.incBytecodes(10);
                final int n2 = index;
                final int n3 = n;
                BytecodeManager.incBytecodes(3);
                ArrayListSpliterator<E> arrayListSpliterator;
                if (n2 >= n3) {
                    arrayListSpliterator = null;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final ArrayList<E> list;
                    final int n4;
                    final int index2;
                    final int expectedModCount;
                    arrayListSpliterator = new ArrayListSpliterator<E>((ArrayList<Object>)list, n4, index2, expectedModCount);
                    list = this.list;
                    n4 = index;
                    index2 = n;
                    this.index = index2;
                    expectedModCount = this.expectedModCount;
                    BytecodeManager.incBytecodes(12);
                }
                BytecodeManager.incBytecodes(1);
                return arrayListSpliterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean tryAdvance(final Consumer<? super E> consumer) {
            try {
                BytecodeManager.incBytecodes(2);
                if (consumer == null) {
                    BytecodeManager.incBytecodes(3);
                    final NullPointerException ex = new NullPointerException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                BytecodeManager.incBytecodes(2);
                final int fence = this.getFence();
                final int index = this.index;
                BytecodeManager.incBytecodes(4);
                final int n = index;
                final int n2 = fence;
                BytecodeManager.incBytecodes(3);
                if (n >= n2) {
                    final boolean b = false;
                    BytecodeManager.incBytecodes(2);
                    return b;
                }
                this.index = index + 1;
                BytecodeManager.incBytecodes(5);
                final Object o = this.list.elementData[index];
                BytecodeManager.incBytecodes(6);
                final Object o2 = o;
                BytecodeManager.incBytecodes(3);
                consumer.accept((Object)o2);
                final int modCount = this.list.modCount;
                final int expectedModCount = this.expectedModCount;
                BytecodeManager.incBytecodes(6);
                if (modCount != expectedModCount) {
                    BytecodeManager.incBytecodes(3);
                    final ConcurrentModificationException ex2 = new ConcurrentModificationException();
                    BytecodeManager.incBytecodes(1);
                    throw ex2;
                }
                final boolean b2 = true;
                BytecodeManager.incBytecodes(2);
                return b2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void forEachRemaining(final Consumer<? super E> consumer) {
            try {
                BytecodeManager.incBytecodes(2);
                if (consumer == null) {
                    BytecodeManager.incBytecodes(3);
                    final NullPointerException ex = new NullPointerException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final ArrayList<E> list2;
                final ArrayList<E> list = list2 = this.list;
                BytecodeManager.incBytecodes(5);
                if (list != null) {
                    final Object[] elementData;
                    final Object[] array = elementData = list2.elementData;
                    BytecodeManager.incBytecodes(5);
                    if (array != null) {
                        int n2;
                        final int n = n2 = this.fence;
                        BytecodeManager.incBytecodes(5);
                        int n3;
                        if (n < 0) {
                            n3 = list2.modCount;
                            BytecodeManager.incBytecodes(3);
                            final ArrayList<E> list3 = list2;
                            BytecodeManager.incBytecodes(2);
                            n2 = ArrayList.access$100((ArrayList<Object>)list3);
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            n3 = this.expectedModCount;
                            BytecodeManager.incBytecodes(3);
                        }
                        int index;
                        final int n4 = index = this.index;
                        BytecodeManager.incBytecodes(5);
                        if (n4 >= 0) {
                            final int index2 = n2;
                            this.index = index2;
                            final int length = elementData.length;
                            BytecodeManager.incBytecodes(7);
                            if (index2 <= length) {
                                while (true) {
                                    final int n5 = index;
                                    final int n6 = n2;
                                    BytecodeManager.incBytecodes(3);
                                    if (n5 >= n6) {
                                        break;
                                    }
                                    final Object o = elementData[index];
                                    BytecodeManager.incBytecodes(4);
                                    final Object o2 = o;
                                    BytecodeManager.incBytecodes(3);
                                    consumer.accept((Object)o2);
                                    ++index;
                                    BytecodeManager.incBytecodes(2);
                                }
                                final int modCount = list2.modCount;
                                final int n7 = n3;
                                BytecodeManager.incBytecodes(4);
                                if (modCount == n7) {
                                    BytecodeManager.incBytecodes(1);
                                    return;
                                }
                            }
                        }
                    }
                }
                BytecodeManager.incBytecodes(3);
                final ConcurrentModificationException ex2 = new ConcurrentModificationException();
                BytecodeManager.incBytecodes(1);
                throw ex2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public long estimateSize() {
            try {
                BytecodeManager.incBytecodes(2);
                final long n = this.getFence() - this.index;
                BytecodeManager.incBytecodes(5);
                return n;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int characteristics() {
            try {
                final int n = 16464;
                BytecodeManager.incBytecodes(2);
                return n;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
}
