// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import instrumented.java.util.function.Consumer;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import aic2021.engine.BytecodeManager;
import java.io.Serializable;

public class PriorityQueue<E> extends AbstractQueue<E> implements Serializable
{
    private static final long serialVersionUID = -7720805057305804111L;
    private static final int DEFAULT_INITIAL_CAPACITY = 11;
    transient Object[] queue;
    private int size;
    private final Comparator<? super E> comparator;
    transient int modCount;
    private static final int MAX_ARRAY_SIZE = 2147483639;
    
    public PriorityQueue() {
        try {
            final int n = 11;
            final Comparator comparator = null;
            BytecodeManager.incBytecodes(4);
            this(n, comparator);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public PriorityQueue(final int n) {
        try {
            final Comparator comparator = null;
            BytecodeManager.incBytecodes(4);
            this(n, comparator);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public PriorityQueue(final Comparator<? super E> comparator) {
        try {
            final int n = 11;
            BytecodeManager.incBytecodes(4);
            this(n, comparator);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public PriorityQueue(final int n, final Comparator<? super E> comparator) {
        try {
            BytecodeManager.incBytecodes(2);
            this.size = 0;
            BytecodeManager.incBytecodes(3);
            this.modCount = 0;
            BytecodeManager.incBytecodes(3);
            final int n2 = 1;
            BytecodeManager.incBytecodes(3);
            if (n < n2) {
                BytecodeManager.incBytecodes(3);
                final IllegalArgumentException ex = new IllegalArgumentException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            this.queue = new Object[n];
            BytecodeManager.incBytecodes(3);
            this.comparator = comparator;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public PriorityQueue(final Collection<? extends E> collection) {
        try {
            BytecodeManager.incBytecodes(2);
            this.size = 0;
            BytecodeManager.incBytecodes(3);
            this.modCount = 0;
            BytecodeManager.incBytecodes(3);
            final boolean b = collection instanceof SortedSet;
            BytecodeManager.incBytecodes(3);
            if (b) {
                final SortedSet<? extends E> set = (SortedSet<? extends E>)collection;
                BytecodeManager.incBytecodes(3);
                final SortedSet<? extends E> set2 = set;
                BytecodeManager.incBytecodes(3);
                this.comparator = set2.comparator();
                BytecodeManager.incBytecodes(1);
                final SortedSet<? extends E> set3 = set;
                BytecodeManager.incBytecodes(3);
                this.initElementsFromCollection(set3);
                BytecodeManager.incBytecodes(1);
            }
            else {
                final boolean b2 = collection instanceof PriorityQueue;
                BytecodeManager.incBytecodes(3);
                if (b2) {
                    final PriorityQueue<? extends E> priorityQueue = (PriorityQueue<? extends E>)collection;
                    BytecodeManager.incBytecodes(3);
                    final PriorityQueue<? extends E> priorityQueue2 = priorityQueue;
                    BytecodeManager.incBytecodes(3);
                    this.comparator = priorityQueue2.comparator();
                    BytecodeManager.incBytecodes(1);
                    final PriorityQueue<? extends E> priorityQueue3 = priorityQueue;
                    BytecodeManager.incBytecodes(3);
                    this.initFromPriorityQueue(priorityQueue3);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    this.comparator = null;
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(3);
                    this.initFromCollection(collection);
                }
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public PriorityQueue(final PriorityQueue<? extends E> priorityQueue) {
        try {
            BytecodeManager.incBytecodes(2);
            this.size = 0;
            BytecodeManager.incBytecodes(3);
            this.modCount = 0;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(3);
            this.comparator = (Comparator<? super E>)priorityQueue.comparator();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            this.initFromPriorityQueue(priorityQueue);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public PriorityQueue(final SortedSet<? extends E> set) {
        try {
            BytecodeManager.incBytecodes(2);
            this.size = 0;
            BytecodeManager.incBytecodes(3);
            this.modCount = 0;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(3);
            this.comparator = set.comparator();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            this.initElementsFromCollection(set);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void initFromPriorityQueue(final PriorityQueue<? extends E> priorityQueue) {
        try {
            BytecodeManager.incBytecodes(2);
            final Class<? extends PriorityQueue> class1 = priorityQueue.getClass();
            final Class<PriorityQueue> clazz = PriorityQueue.class;
            BytecodeManager.incBytecodes(2);
            if (class1 == clazz) {
                BytecodeManager.incBytecodes(3);
                this.queue = priorityQueue.toArray();
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(3);
                this.size = priorityQueue.size();
                BytecodeManager.incBytecodes(2);
            }
            else {
                BytecodeManager.incBytecodes(3);
                this.initFromCollection(priorityQueue);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void initElementsFromCollection(final Collection<? extends E> collection) {
        try {
            BytecodeManager.incBytecodes(2);
            Object[] queue = collection.toArray();
            BytecodeManager.incBytecodes(1);
            final Object[] array = queue;
            BytecodeManager.incBytecodes(2);
            final Class<? extends Object[]> class1 = array.getClass();
            final Class<Object[]> clazz = Object[].class;
            BytecodeManager.incBytecodes(2);
            if (class1 != clazz) {
                final Object[] array2 = queue;
                final int length = queue.length;
                final Class<Object[]> clazz2 = Object[].class;
                BytecodeManager.incBytecodes(5);
                queue = Arrays.copyOf(array2, length, (Class<? extends Object[]>)clazz2);
                BytecodeManager.incBytecodes(1);
            }
            final int length2 = queue.length;
            BytecodeManager.incBytecodes(3);
            final int n = length2;
            final int n2 = 1;
            BytecodeManager.incBytecodes(3);
            Label_0145: {
                if (n != n2) {
                    final Comparator<? super E> comparator = this.comparator;
                    BytecodeManager.incBytecodes(3);
                    if (comparator == null) {
                        break Label_0145;
                    }
                }
                int n3 = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n4 = n3;
                    final int n5 = length2;
                    BytecodeManager.incBytecodes(3);
                    if (n4 >= n5) {
                        break;
                    }
                    final Object o = queue[n3];
                    BytecodeManager.incBytecodes(4);
                    if (o == null) {
                        BytecodeManager.incBytecodes(3);
                        final NullPointerException ex = new NullPointerException();
                        BytecodeManager.incBytecodes(1);
                        throw ex;
                    }
                    ++n3;
                    BytecodeManager.incBytecodes(2);
                }
            }
            this.queue = queue;
            BytecodeManager.incBytecodes(3);
            this.size = queue.length;
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void initFromCollection(final Collection<? extends E> collection) {
        try {
            BytecodeManager.incBytecodes(3);
            this.initElementsFromCollection(collection);
            BytecodeManager.incBytecodes(2);
            this.heapify();
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void grow(final int n) {
        try {
            final int length = this.queue.length;
            BytecodeManager.incBytecodes(4);
            final int n2 = length;
            final int n3 = length;
            final int n4 = 64;
            BytecodeManager.incBytecodes(4);
            int n5;
            if (n3 < n4) {
                n5 = length + 2;
                BytecodeManager.incBytecodes(4);
            }
            else {
                n5 = length >> 1;
                BytecodeManager.incBytecodes(3);
            }
            int hugeCapacity = n2 + n5;
            BytecodeManager.incBytecodes(2);
            final int n6 = hugeCapacity - 2147483639;
            BytecodeManager.incBytecodes(4);
            if (n6 > 0) {
                BytecodeManager.incBytecodes(2);
                hugeCapacity = hugeCapacity(n);
                BytecodeManager.incBytecodes(1);
            }
            final Object[] queue = this.queue;
            final int n7 = hugeCapacity;
            BytecodeManager.incBytecodes(5);
            this.queue = Arrays.copyOf(queue, n7);
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
    public boolean add(final E e) {
        try {
            BytecodeManager.incBytecodes(3);
            final boolean offer = this.offer(e);
            BytecodeManager.incBytecodes(1);
            return offer;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean offer(final E e) {
        try {
            BytecodeManager.incBytecodes(2);
            if (e == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            ++this.modCount;
            BytecodeManager.incBytecodes(6);
            final int size = this.size;
            BytecodeManager.incBytecodes(3);
            final int n = size;
            final int length = this.queue.length;
            BytecodeManager.incBytecodes(5);
            if (n >= length) {
                final int n2 = size + 1;
                BytecodeManager.incBytecodes(5);
                this.grow(n2);
            }
            this.size = size + 1;
            BytecodeManager.incBytecodes(5);
            final int n3 = size;
            BytecodeManager.incBytecodes(2);
            if (n3 == 0) {
                this.queue[0] = e;
                BytecodeManager.incBytecodes(6);
            }
            else {
                final int n4 = size;
                BytecodeManager.incBytecodes(4);
                this.siftUp(n4, e);
            }
            final boolean b = true;
            BytecodeManager.incBytecodes(2);
            return b;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public E peek() {
        try {
            final int size = this.size;
            BytecodeManager.incBytecodes(3);
            Object o;
            if (size == 0) {
                o = null;
                BytecodeManager.incBytecodes(2);
            }
            else {
                o = this.queue[0];
                BytecodeManager.incBytecodes(4);
            }
            BytecodeManager.incBytecodes(1);
            return (E)o;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private int indexOf(final Object o) {
        try {
            BytecodeManager.incBytecodes(2);
            if (o != null) {
                int n = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n2 = n;
                    final int size = this.size;
                    BytecodeManager.incBytecodes(4);
                    if (n2 >= size) {
                        break;
                    }
                    final Object obj = this.queue[n];
                    BytecodeManager.incBytecodes(6);
                    final boolean equals = o.equals(obj);
                    BytecodeManager.incBytecodes(1);
                    if (equals) {
                        final int n3 = n;
                        BytecodeManager.incBytecodes(2);
                        return n3;
                    }
                    ++n;
                    BytecodeManager.incBytecodes(2);
                }
            }
            final int n4 = -1;
            BytecodeManager.incBytecodes(2);
            return n4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean remove(final Object o) {
        try {
            BytecodeManager.incBytecodes(3);
            final int index = this.indexOf(o);
            BytecodeManager.incBytecodes(1);
            final int n = index;
            final int n2 = -1;
            BytecodeManager.incBytecodes(3);
            if (n == n2) {
                final boolean b = false;
                BytecodeManager.incBytecodes(2);
                return b;
            }
            final int n3 = index;
            BytecodeManager.incBytecodes(3);
            this.removeAt(n3);
            BytecodeManager.incBytecodes(1);
            final boolean b2 = true;
            BytecodeManager.incBytecodes(2);
            return b2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    boolean removeEq(final Object o) {
        try {
            int n = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n2 = n;
                final int size = this.size;
                BytecodeManager.incBytecodes(4);
                if (n2 >= size) {
                    final boolean b = false;
                    BytecodeManager.incBytecodes(2);
                    return b;
                }
                final Object o2 = this.queue[n];
                BytecodeManager.incBytecodes(6);
                if (o == o2) {
                    final int n3 = n;
                    BytecodeManager.incBytecodes(3);
                    this.removeAt(n3);
                    BytecodeManager.incBytecodes(1);
                    final boolean b2 = true;
                    BytecodeManager.incBytecodes(2);
                    return b2;
                }
                ++n;
                BytecodeManager.incBytecodes(2);
            }
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
            final int n = -1;
            BytecodeManager.incBytecodes(2);
            boolean b;
            if (index != n) {
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
    public Object[] toArray() {
        try {
            final Object[] queue = this.queue;
            final int size = this.size;
            BytecodeManager.incBytecodes(5);
            final Object[] copy = Arrays.copyOf(queue, size);
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
            final int size = this.size;
            BytecodeManager.incBytecodes(3);
            final int length = array.length;
            final int n = size;
            BytecodeManager.incBytecodes(4);
            if (length < n) {
                final Object[] queue = this.queue;
                final int n2 = size;
                BytecodeManager.incBytecodes(5);
                final Class<? extends Object[]> class1 = array.getClass();
                BytecodeManager.incBytecodes(1);
                final T[] array2 = Arrays.copyOf(queue, n2, (Class<? extends T[]>)class1);
                BytecodeManager.incBytecodes(2);
                return array2;
            }
            final Object[] queue2 = this.queue;
            final int n3 = 0;
            final int n4 = 0;
            final int n5 = size;
            BytecodeManager.incBytecodes(7);
            System.arraycopy(queue2, n3, array, n4, n5);
            final int length2 = array.length;
            final int n6 = size;
            BytecodeManager.incBytecodes(4);
            if (length2 > n6) {
                array[size] = null;
                BytecodeManager.incBytecodes(4);
            }
            BytecodeManager.incBytecodes(2);
            return array;
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
                this.queue[n] = null;
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
    public E poll() {
        try {
            final int size = this.size;
            BytecodeManager.incBytecodes(3);
            if (size == 0) {
                final E e = null;
                BytecodeManager.incBytecodes(2);
                return e;
            }
            final int size2 = this.size - 1;
            this.size = size2;
            final int n = size2;
            BytecodeManager.incBytecodes(8);
            ++this.modCount;
            BytecodeManager.incBytecodes(6);
            final Object o = this.queue[0];
            BytecodeManager.incBytecodes(5);
            final Object o2 = this.queue[n];
            BytecodeManager.incBytecodes(5);
            this.queue[n] = null;
            BytecodeManager.incBytecodes(5);
            final int n2 = n;
            BytecodeManager.incBytecodes(2);
            if (n2 != 0) {
                final int n3 = 0;
                final Object o3 = o2;
                BytecodeManager.incBytecodes(4);
                this.siftDown(n3, (E)o3);
            }
            final Object o4 = o;
            BytecodeManager.incBytecodes(2);
            return (E)o4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private E removeAt(final int n) {
        try {
            ++this.modCount;
            BytecodeManager.incBytecodes(6);
            final int size = this.size - 1;
            this.size = size;
            final int n2 = size;
            BytecodeManager.incBytecodes(8);
            final int n3 = n2;
            BytecodeManager.incBytecodes(3);
            if (n3 == n) {
                this.queue[n] = null;
                BytecodeManager.incBytecodes(6);
            }
            else {
                final Object o = this.queue[n2];
                BytecodeManager.incBytecodes(5);
                this.queue[n2] = null;
                BytecodeManager.incBytecodes(5);
                final Object o2 = o;
                BytecodeManager.incBytecodes(4);
                this.siftDown(n, (E)o2);
                final Object o3 = this.queue[n];
                final Object o4 = o;
                BytecodeManager.incBytecodes(6);
                if (o3 == o4) {
                    final Object o5 = o;
                    BytecodeManager.incBytecodes(4);
                    this.siftUp(n, (E)o5);
                    final Object o6 = this.queue[n];
                    final Object o7 = o;
                    BytecodeManager.incBytecodes(6);
                    if (o6 != o7) {
                        final Object o8 = o;
                        BytecodeManager.incBytecodes(2);
                        return (E)o8;
                    }
                }
            }
            final E e = null;
            BytecodeManager.incBytecodes(2);
            return e;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void siftUp(final int n, final E e) {
        try {
            final Comparator<? super E> comparator = this.comparator;
            BytecodeManager.incBytecodes(3);
            if (comparator != null) {
                BytecodeManager.incBytecodes(4);
                this.siftUpUsingComparator(n, e);
                BytecodeManager.incBytecodes(1);
            }
            else {
                BytecodeManager.incBytecodes(4);
                this.siftUpComparable(n, e);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void siftUpComparable(int n, final E e) {
        try {
            final Comparable comparable = (Comparable)e;
            BytecodeManager.incBytecodes(3);
            while (true) {
                final int n2 = n;
                BytecodeManager.incBytecodes(2);
                if (n2 <= 0) {
                    break;
                }
                final int n3 = n - 1 >>> 1;
                BytecodeManager.incBytecodes(6);
                final Object o = this.queue[n3];
                BytecodeManager.incBytecodes(5);
                final Comparable comparable2 = comparable;
                final Object o2 = o;
                BytecodeManager.incBytecodes(3);
                final int compareTo = comparable2.compareTo(o2);
                BytecodeManager.incBytecodes(1);
                if (compareTo >= 0) {
                    BytecodeManager.incBytecodes(1);
                    break;
                }
                this.queue[n] = o;
                BytecodeManager.incBytecodes(5);
                n = n3;
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
            this.queue[n] = comparable;
            BytecodeManager.incBytecodes(5);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void siftUpUsingComparator(int n, final E e) {
        try {
            while (true) {
                final int n2 = n;
                BytecodeManager.incBytecodes(2);
                if (n2 <= 0) {
                    break;
                }
                final int n3 = n - 1 >>> 1;
                BytecodeManager.incBytecodes(6);
                final Object o = this.queue[n3];
                BytecodeManager.incBytecodes(5);
                final Comparator<? super E> comparator = this.comparator;
                final Object o2 = o;
                BytecodeManager.incBytecodes(5);
                final int compare = comparator.compare(e, o2);
                BytecodeManager.incBytecodes(1);
                if (compare >= 0) {
                    BytecodeManager.incBytecodes(1);
                    break;
                }
                this.queue[n] = o;
                BytecodeManager.incBytecodes(5);
                n = n3;
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
            this.queue[n] = e;
            BytecodeManager.incBytecodes(5);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void siftDown(final int n, final E e) {
        try {
            final Comparator<? super E> comparator = this.comparator;
            BytecodeManager.incBytecodes(3);
            if (comparator != null) {
                BytecodeManager.incBytecodes(4);
                this.siftDownUsingComparator(n, e);
                BytecodeManager.incBytecodes(1);
            }
            else {
                BytecodeManager.incBytecodes(4);
                this.siftDownComparable(n, e);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void siftDownComparable(int n, final E e) {
        try {
            final Comparable comparable = (Comparable)e;
            BytecodeManager.incBytecodes(3);
            final int n2 = this.size >>> 1;
            BytecodeManager.incBytecodes(5);
            while (true) {
                final int n3 = n;
                final int n4 = n2;
                BytecodeManager.incBytecodes(3);
                if (n3 >= n4) {
                    break;
                }
                int n5 = (n << 1) + 1;
                BytecodeManager.incBytecodes(6);
                Object o = this.queue[n5];
                BytecodeManager.incBytecodes(5);
                final int n6 = n5 + 1;
                BytecodeManager.incBytecodes(4);
                final int n7 = n6;
                final int size = this.size;
                BytecodeManager.incBytecodes(4);
                if (n7 < size) {
                    final Comparable<Object> comparable2 = (Comparable<Object>)o;
                    final Object o2 = this.queue[n6];
                    BytecodeManager.incBytecodes(6);
                    BytecodeManager.incBytecodes(1);
                    final int compareTo = comparable2.compareTo(o2);
                    BytecodeManager.incBytecodes(1);
                    if (compareTo > 0) {
                        o = this.queue[n5 = n6];
                        BytecodeManager.incBytecodes(7);
                    }
                }
                final Comparable<Comparable<Object>> comparable3 = (Comparable<Comparable<Object>>)comparable;
                final Comparable<Object> comparable4 = (Comparable<Object>)o;
                BytecodeManager.incBytecodes(3);
                final int compareTo2 = comparable3.compareTo(comparable4);
                BytecodeManager.incBytecodes(1);
                if (compareTo2 <= 0) {
                    BytecodeManager.incBytecodes(1);
                    break;
                }
                this.queue[n] = o;
                BytecodeManager.incBytecodes(5);
                n = n5;
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
            this.queue[n] = comparable;
            BytecodeManager.incBytecodes(5);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void siftDownUsingComparator(int n, final E e) {
        try {
            final int n2 = this.size >>> 1;
            BytecodeManager.incBytecodes(5);
            while (true) {
                final int n3 = n;
                final int n4 = n2;
                BytecodeManager.incBytecodes(3);
                if (n3 >= n4) {
                    break;
                }
                int n5 = (n << 1) + 1;
                BytecodeManager.incBytecodes(6);
                Object o = this.queue[n5];
                BytecodeManager.incBytecodes(5);
                final int n6 = n5 + 1;
                BytecodeManager.incBytecodes(4);
                final int n7 = n6;
                final int size = this.size;
                BytecodeManager.incBytecodes(4);
                if (n7 < size) {
                    final Comparator<? super E> comparator = this.comparator;
                    final Object o2 = o;
                    final Object o3 = this.queue[n6];
                    BytecodeManager.incBytecodes(7);
                    BytecodeManager.incBytecodes(1);
                    final int compare = comparator.compare(o2, o3);
                    BytecodeManager.incBytecodes(1);
                    if (compare > 0) {
                        o = this.queue[n5 = n6];
                        BytecodeManager.incBytecodes(7);
                    }
                }
                final Comparator<? super E> comparator2 = this.comparator;
                final Object o4 = o;
                BytecodeManager.incBytecodes(5);
                final int compare2 = comparator2.compare(e, o4);
                BytecodeManager.incBytecodes(1);
                if (compare2 <= 0) {
                    BytecodeManager.incBytecodes(1);
                    break;
                }
                this.queue[n] = o;
                BytecodeManager.incBytecodes(5);
                n = n5;
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
            this.queue[n] = e;
            BytecodeManager.incBytecodes(5);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void heapify() {
        try {
            int n = (this.size >>> 1) - 1;
            BytecodeManager.incBytecodes(7);
            while (true) {
                final int n2 = n;
                BytecodeManager.incBytecodes(2);
                if (n2 < 0) {
                    break;
                }
                final int n3 = n;
                final Object o = this.queue[n];
                BytecodeManager.incBytecodes(7);
                this.siftDown(n3, (E)o);
                --n;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Comparator<? super E> comparator() {
        try {
            final Comparator<? super E> comparator = this.comparator;
            BytecodeManager.incBytecodes(3);
            return comparator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) throws IOException {
        try {
            BytecodeManager.incBytecodes(2);
            objectOutputStream.defaultWriteObject();
            final int a = 2;
            final int b = this.size + 1;
            BytecodeManager.incBytecodes(7);
            final int max = Math.max(a, b);
            BytecodeManager.incBytecodes(1);
            objectOutputStream.writeInt(max);
            int n = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n2 = n;
                final int size = this.size;
                BytecodeManager.incBytecodes(4);
                if (n2 >= size) {
                    break;
                }
                final Object obj = this.queue[n];
                BytecodeManager.incBytecodes(6);
                objectOutputStream.writeObject(obj);
                ++n;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void readObject(final ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            BytecodeManager.incBytecodes(2);
            objectInputStream.defaultReadObject();
            BytecodeManager.incBytecodes(2);
            objectInputStream.readInt();
            BytecodeManager.incBytecodes(1);
            this.queue = new Object[this.size];
            BytecodeManager.incBytecodes(4);
            int n = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n2 = n;
                final int size = this.size;
                BytecodeManager.incBytecodes(4);
                if (n2 >= size) {
                    break;
                }
                final Object[] queue = this.queue;
                final int n3 = n;
                BytecodeManager.incBytecodes(5);
                queue[n3] = objectInputStream.readObject();
                BytecodeManager.incBytecodes(1);
                ++n;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(2);
            this.heapify();
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final Spliterator<E> spliterator() {
        try {
            final int n = 0;
            final int n2 = -1;
            final int n3 = 0;
            BytecodeManager.incBytecodes(7);
            final PriorityQueueSpliterator priorityQueueSpliterator = new PriorityQueueSpliterator<E>(this, n, n2, n3);
            BytecodeManager.incBytecodes(1);
            return (Spliterator<E>)priorityQueueSpliterator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static /* synthetic */ int access$100(final PriorityQueue priorityQueue) {
        try {
            final int size = priorityQueue.size;
            BytecodeManager.incBytecodes(3);
            return size;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static /* synthetic */ Object access$200(final PriorityQueue priorityQueue, final int n) {
        try {
            BytecodeManager.incBytecodes(3);
            final Object remove = priorityQueue.removeAt(n);
            BytecodeManager.incBytecodes(1);
            return remove;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private final class Itr implements Iterator<E>
    {
        private int cursor;
        private int lastRet;
        private ArrayDeque<E> forgetMeNot;
        private E lastRetElt;
        private int expectedModCount;
        
        private Itr() {
            try {
                BytecodeManager.incBytecodes(5);
                this.cursor = 0;
                BytecodeManager.incBytecodes(3);
                this.lastRet = -1;
                BytecodeManager.incBytecodes(3);
                this.forgetMeNot = null;
                BytecodeManager.incBytecodes(3);
                this.lastRetElt = null;
                BytecodeManager.incBytecodes(3);
                this.expectedModCount = PriorityQueue.this.modCount;
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
                final PriorityQueue this$0 = PriorityQueue.this;
                BytecodeManager.incBytecodes(5);
                final int access$100 = PriorityQueue.access$100(this$0);
                BytecodeManager.incBytecodes(1);
                boolean b = false;
                Label_0076: {
                    Label_0061: {
                        if (cursor >= access$100) {
                            final ArrayDeque<E> forgetMeNot = this.forgetMeNot;
                            BytecodeManager.incBytecodes(3);
                            if (forgetMeNot != null) {
                                final ArrayDeque<E> forgetMeNot2 = this.forgetMeNot;
                                BytecodeManager.incBytecodes(2);
                                BytecodeManager.incBytecodes(1);
                                final boolean empty = forgetMeNot2.isEmpty();
                                BytecodeManager.incBytecodes(1);
                                if (!empty) {
                                    break Label_0061;
                                }
                            }
                            b = false;
                            BytecodeManager.incBytecodes(1);
                            break Label_0076;
                        }
                    }
                    b = true;
                    BytecodeManager.incBytecodes(2);
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
                final int expectedModCount = this.expectedModCount;
                final int modCount = PriorityQueue.this.modCount;
                BytecodeManager.incBytecodes(6);
                if (expectedModCount != modCount) {
                    BytecodeManager.incBytecodes(3);
                    final ConcurrentModificationException ex = new ConcurrentModificationException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final int cursor = this.cursor;
                final PriorityQueue this$0 = PriorityQueue.this;
                BytecodeManager.incBytecodes(5);
                final int access$100 = PriorityQueue.access$100(this$0);
                BytecodeManager.incBytecodes(1);
                if (cursor < access$100) {
                    final Object[] queue = PriorityQueue.this.queue;
                    final int lastRet = this.cursor++;
                    this.lastRet = lastRet;
                    final Object o = queue[lastRet];
                    BytecodeManager.incBytecodes(15);
                    return (E)o;
                }
                final ArrayDeque<E> forgetMeNot = this.forgetMeNot;
                BytecodeManager.incBytecodes(3);
                if (forgetMeNot != null) {
                    this.lastRet = -1;
                    BytecodeManager.incBytecodes(3);
                    final ArrayDeque<E> forgetMeNot2 = this.forgetMeNot;
                    BytecodeManager.incBytecodes(4);
                    this.lastRetElt = forgetMeNot2.poll();
                    BytecodeManager.incBytecodes(1);
                    final E lastRetElt = this.lastRetElt;
                    BytecodeManager.incBytecodes(3);
                    if (lastRetElt != null) {
                        final E lastRetElt2 = this.lastRetElt;
                        BytecodeManager.incBytecodes(3);
                        return lastRetElt2;
                    }
                }
                BytecodeManager.incBytecodes(3);
                final NoSuchElementException ex2 = new NoSuchElementException();
                BytecodeManager.incBytecodes(1);
                throw ex2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void remove() {
            try {
                final int expectedModCount = this.expectedModCount;
                final int modCount = PriorityQueue.this.modCount;
                BytecodeManager.incBytecodes(6);
                if (expectedModCount != modCount) {
                    BytecodeManager.incBytecodes(3);
                    final ConcurrentModificationException ex = new ConcurrentModificationException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final int lastRet = this.lastRet;
                final int n = -1;
                BytecodeManager.incBytecodes(4);
                if (lastRet != n) {
                    final PriorityQueue this$0 = PriorityQueue.this;
                    final int lastRet2 = this.lastRet;
                    BytecodeManager.incBytecodes(5);
                    final Object access$200 = PriorityQueue.access$200(this$0, lastRet2);
                    BytecodeManager.incBytecodes(1);
                    this.lastRet = -1;
                    BytecodeManager.incBytecodes(3);
                    final Object o = access$200;
                    BytecodeManager.incBytecodes(2);
                    if (o == null) {
                        --this.cursor;
                        BytecodeManager.incBytecodes(7);
                    }
                    else {
                        final ArrayDeque<E> forgetMeNot = this.forgetMeNot;
                        BytecodeManager.incBytecodes(3);
                        if (forgetMeNot == null) {
                            BytecodeManager.incBytecodes(4);
                            this.forgetMeNot = new ArrayDeque<E>();
                            BytecodeManager.incBytecodes(1);
                        }
                        final ArrayDeque<E> forgetMeNot2 = this.forgetMeNot;
                        final Object o2 = access$200;
                        BytecodeManager.incBytecodes(4);
                        forgetMeNot2.add((E)o2);
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    final E lastRetElt = this.lastRetElt;
                    BytecodeManager.incBytecodes(3);
                    if (lastRetElt == null) {
                        BytecodeManager.incBytecodes(3);
                        final IllegalStateException ex2 = new IllegalStateException();
                        BytecodeManager.incBytecodes(1);
                        throw ex2;
                    }
                    final PriorityQueue this$2 = PriorityQueue.this;
                    final E lastRetElt2 = this.lastRetElt;
                    BytecodeManager.incBytecodes(5);
                    this$2.removeEq(lastRetElt2);
                    BytecodeManager.incBytecodes(1);
                    this.lastRetElt = null;
                    BytecodeManager.incBytecodes(4);
                }
                this.expectedModCount = PriorityQueue.this.modCount;
                BytecodeManager.incBytecodes(5);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class PriorityQueueSpliterator<E> implements Spliterator<E>
    {
        private final PriorityQueue<E> pq;
        private int index;
        private int fence;
        private int expectedModCount;
        
        PriorityQueueSpliterator(final PriorityQueue<E> pq, final int index, final int fence, final int expectedModCount) {
            try {
                BytecodeManager.incBytecodes(2);
                this.pq = pq;
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
                    this.expectedModCount = this.pq.modCount;
                    BytecodeManager.incBytecodes(5);
                    final PriorityQueue<E> pq = this.pq;
                    BytecodeManager.incBytecodes(4);
                    final int access$100 = PriorityQueue.access$100((PriorityQueue<Object>)pq);
                    this.fence = access$100;
                    fence = access$100;
                    BytecodeManager.incBytecodes(3);
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
        public PriorityQueueSpliterator<E> trySplit() {
            try {
                BytecodeManager.incBytecodes(2);
                final int fence = this.getFence();
                final int index = this.index;
                final int n = index + fence >>> 1;
                BytecodeManager.incBytecodes(10);
                final int n2 = index;
                final int n3 = n;
                BytecodeManager.incBytecodes(3);
                PriorityQueueSpliterator<E> priorityQueueSpliterator;
                if (n2 >= n3) {
                    priorityQueueSpliterator = null;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final PriorityQueue<E> pq;
                    final int n4;
                    final int index2;
                    final int expectedModCount;
                    priorityQueueSpliterator = new PriorityQueueSpliterator<E>((PriorityQueue<Object>)pq, n4, index2, expectedModCount);
                    pq = this.pq;
                    n4 = index;
                    index2 = n;
                    this.index = index2;
                    expectedModCount = this.expectedModCount;
                    BytecodeManager.incBytecodes(12);
                }
                BytecodeManager.incBytecodes(1);
                return priorityQueueSpliterator;
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
                final PriorityQueue<E> pq;
                final PriorityQueue<E> priorityQueue = pq = this.pq;
                BytecodeManager.incBytecodes(5);
                if (priorityQueue != null) {
                    final Object[] queue;
                    final Object[] array = queue = pq.queue;
                    BytecodeManager.incBytecodes(5);
                    if (array != null) {
                        int n2;
                        final int n = n2 = this.fence;
                        BytecodeManager.incBytecodes(5);
                        int n3;
                        if (n < 0) {
                            n3 = pq.modCount;
                            BytecodeManager.incBytecodes(3);
                            final PriorityQueue<E> priorityQueue2 = pq;
                            BytecodeManager.incBytecodes(2);
                            n2 = PriorityQueue.access$100((PriorityQueue<Object>)priorityQueue2);
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
                            final int length = queue.length;
                            BytecodeManager.incBytecodes(7);
                            if (index2 <= length) {
                                while (true) {
                                    final int n5 = index;
                                    final int n6 = n2;
                                    BytecodeManager.incBytecodes(3);
                                    if (n5 < n6) {
                                        final Object o = queue[index];
                                        BytecodeManager.incBytecodes(6);
                                        if (o == null) {
                                            BytecodeManager.incBytecodes(1);
                                            break;
                                        }
                                        final Object o2 = o;
                                        BytecodeManager.incBytecodes(3);
                                        consumer.accept((Object)o2);
                                        BytecodeManager.incBytecodes(1);
                                        ++index;
                                        BytecodeManager.incBytecodes(2);
                                    }
                                    else {
                                        final int modCount = pq.modCount;
                                        final int n7 = n3;
                                        BytecodeManager.incBytecodes(4);
                                        if (modCount != n7) {
                                            BytecodeManager.incBytecodes(1);
                                            break;
                                        }
                                        BytecodeManager.incBytecodes(1);
                                        return;
                                    }
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
                BytecodeManager.incBytecodes(2);
                if (n >= 0) {
                    final int n2 = index;
                    final int n3 = fence;
                    BytecodeManager.incBytecodes(3);
                    if (n2 < n3) {
                        this.index = index + 1;
                        BytecodeManager.incBytecodes(5);
                        final Object o = this.pq.queue[index];
                        BytecodeManager.incBytecodes(6);
                        final Object o2 = o;
                        BytecodeManager.incBytecodes(2);
                        if (o2 == null) {
                            BytecodeManager.incBytecodes(3);
                            final ConcurrentModificationException ex2 = new ConcurrentModificationException();
                            BytecodeManager.incBytecodes(1);
                            throw ex2;
                        }
                        final Object o3 = o;
                        BytecodeManager.incBytecodes(3);
                        consumer.accept((Object)o3);
                        final int modCount = this.pq.modCount;
                        final int expectedModCount = this.expectedModCount;
                        BytecodeManager.incBytecodes(6);
                        if (modCount != expectedModCount) {
                            BytecodeManager.incBytecodes(3);
                            final ConcurrentModificationException ex3 = new ConcurrentModificationException();
                            BytecodeManager.incBytecodes(1);
                            throw ex3;
                        }
                        final boolean b = true;
                        BytecodeManager.incBytecodes(2);
                        return b;
                    }
                }
                final boolean b2 = false;
                BytecodeManager.incBytecodes(2);
                return b2;
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
                final int n = 16704;
                BytecodeManager.incBytecodes(2);
                return n;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
}
