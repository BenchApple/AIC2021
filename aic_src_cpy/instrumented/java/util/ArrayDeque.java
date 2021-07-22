// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import instrumented.java.util.function.Consumer;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.Iterator;
import aic2021.engine.BytecodeManager;
import java.io.Serializable;

public class ArrayDeque<E> extends AbstractCollection<E> implements Deque<E>, Cloneable, Serializable
{
    transient Object[] elements;
    transient int head;
    transient int tail;
    private static final int MIN_INITIAL_CAPACITY = 8;
    private static final long serialVersionUID = 2340985798034038923L;
    static final /* synthetic */ boolean $assertionsDisabled;
    
    private void allocateElements(final int n) {
        try {
            int n2 = 8;
            BytecodeManager.incBytecodes(2);
            final int n3 = n2;
            BytecodeManager.incBytecodes(3);
            if (n >= n3) {
                BytecodeManager.incBytecodes(2);
                final int n4 = n | n >>> 1;
                BytecodeManager.incBytecodes(6);
                final int n5 = n4 | n4 >>> 2;
                BytecodeManager.incBytecodes(6);
                final int n6 = n5 | n5 >>> 4;
                BytecodeManager.incBytecodes(6);
                final int n7 = n6 | n6 >>> 8;
                BytecodeManager.incBytecodes(6);
                n2 = (n7 | n7 >>> 16);
                BytecodeManager.incBytecodes(6);
                ++n2;
                BytecodeManager.incBytecodes(1);
                final int n8 = n2;
                BytecodeManager.incBytecodes(2);
                if (n8 < 0) {
                    n2 >>>= 1;
                    BytecodeManager.incBytecodes(4);
                }
            }
            this.elements = new Object[n2];
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void doubleCapacity() {
        try {
            final boolean $assertionsDisabled = ArrayDeque.$assertionsDisabled;
            BytecodeManager.incBytecodes(2);
            if (!$assertionsDisabled) {
                final int head = this.head;
                final int tail = this.tail;
                BytecodeManager.incBytecodes(5);
                if (head != tail) {
                    BytecodeManager.incBytecodes(3);
                    final AssertionError assertionError = new AssertionError();
                    BytecodeManager.incBytecodes(1);
                    throw assertionError;
                }
            }
            final int head2 = this.head;
            BytecodeManager.incBytecodes(3);
            final int length = this.elements.length;
            BytecodeManager.incBytecodes(4);
            final int n = length - head2;
            BytecodeManager.incBytecodes(4);
            final int n2 = length << 1;
            BytecodeManager.incBytecodes(4);
            final int n3 = n2;
            BytecodeManager.incBytecodes(2);
            if (n3 < 0) {
                final String s = "Sorry, deque too big";
                BytecodeManager.incBytecodes(4);
                final IllegalStateException ex = new IllegalStateException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final Object[] elements = new Object[n2];
            BytecodeManager.incBytecodes(2);
            final Object[] elements2 = this.elements;
            final int n4 = head2;
            final Object[] array = elements;
            final int n5 = 0;
            final int n6 = n;
            BytecodeManager.incBytecodes(7);
            System.arraycopy(elements2, n4, array, n5, n6);
            final Object[] elements3 = this.elements;
            final int n7 = 0;
            final Object[] array2 = elements;
            final int n8 = n;
            final int n9 = head2;
            BytecodeManager.incBytecodes(7);
            System.arraycopy(elements3, n7, array2, n8, n9);
            this.elements = elements;
            BytecodeManager.incBytecodes(3);
            this.head = 0;
            BytecodeManager.incBytecodes(3);
            this.tail = length;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private <T> T[] copyElements(final T[] array) {
        try {
            final int head = this.head;
            final int tail = this.tail;
            BytecodeManager.incBytecodes(5);
            if (head < tail) {
                final Object[] elements = this.elements;
                final int head2 = this.head;
                final int n = 0;
                BytecodeManager.incBytecodes(8);
                final int size = this.size();
                BytecodeManager.incBytecodes(1);
                System.arraycopy(elements, head2, array, n, size);
                BytecodeManager.incBytecodes(1);
            }
            else {
                final int head3 = this.head;
                final int tail2 = this.tail;
                BytecodeManager.incBytecodes(5);
                if (head3 > tail2) {
                    final int n2 = this.elements.length - this.head;
                    BytecodeManager.incBytecodes(7);
                    final Object[] elements2 = this.elements;
                    final int head4 = this.head;
                    final int n3 = 0;
                    final int n4 = n2;
                    BytecodeManager.incBytecodes(8);
                    System.arraycopy(elements2, head4, array, n3, n4);
                    final Object[] elements3 = this.elements;
                    final int n5 = 0;
                    final int n6 = n2;
                    final int tail3 = this.tail;
                    BytecodeManager.incBytecodes(8);
                    System.arraycopy(elements3, n5, array, n6, tail3);
                }
            }
            BytecodeManager.incBytecodes(2);
            return array;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public ArrayDeque() {
        try {
            BytecodeManager.incBytecodes(2);
            this.elements = new Object[16];
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public ArrayDeque(final int n) {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(3);
            this.allocateElements(n);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public ArrayDeque(final Collection<? extends E> collection) {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(3);
            final int size = collection.size();
            BytecodeManager.incBytecodes(1);
            this.allocateElements(size);
            BytecodeManager.incBytecodes(3);
            this.addAll(collection);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void addFirst(final E e) {
        try {
            BytecodeManager.incBytecodes(2);
            if (e == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            this.elements[this.head = (this.head - 1 & this.elements.length - 1)] = e;
            BytecodeManager.incBytecodes(17);
            final int head = this.head;
            final int tail = this.tail;
            BytecodeManager.incBytecodes(5);
            if (head == tail) {
                BytecodeManager.incBytecodes(2);
                this.doubleCapacity();
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void addLast(final E e) {
        try {
            BytecodeManager.incBytecodes(2);
            if (e == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            this.elements[this.tail] = e;
            BytecodeManager.incBytecodes(6);
            final int tail = this.tail + 1 & this.elements.length - 1;
            this.tail = tail;
            final int head = this.head;
            BytecodeManager.incBytecodes(16);
            if (tail == head) {
                BytecodeManager.incBytecodes(2);
                this.doubleCapacity();
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean offerFirst(final E e) {
        try {
            BytecodeManager.incBytecodes(3);
            this.addFirst(e);
            final boolean b = true;
            BytecodeManager.incBytecodes(2);
            return b;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean offerLast(final E e) {
        try {
            BytecodeManager.incBytecodes(3);
            this.addLast(e);
            final boolean b = true;
            BytecodeManager.incBytecodes(2);
            return b;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public E removeFirst() {
        try {
            BytecodeManager.incBytecodes(2);
            final E pollFirst = this.pollFirst();
            BytecodeManager.incBytecodes(1);
            final E e = pollFirst;
            BytecodeManager.incBytecodes(2);
            if (e == null) {
                BytecodeManager.incBytecodes(3);
                final NoSuchElementException ex = new NoSuchElementException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final E e2 = pollFirst;
            BytecodeManager.incBytecodes(2);
            return e2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public E removeLast() {
        try {
            BytecodeManager.incBytecodes(2);
            final E pollLast = this.pollLast();
            BytecodeManager.incBytecodes(1);
            final E e = pollLast;
            BytecodeManager.incBytecodes(2);
            if (e == null) {
                BytecodeManager.incBytecodes(3);
                final NoSuchElementException ex = new NoSuchElementException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final E e2 = pollLast;
            BytecodeManager.incBytecodes(2);
            return e2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public E pollFirst() {
        try {
            final int head = this.head;
            BytecodeManager.incBytecodes(3);
            final Object o = this.elements[head];
            BytecodeManager.incBytecodes(5);
            final Object o2 = o;
            BytecodeManager.incBytecodes(2);
            if (o2 == null) {
                final E e = null;
                BytecodeManager.incBytecodes(2);
                return e;
            }
            this.elements[head] = null;
            BytecodeManager.incBytecodes(5);
            this.head = (head + 1 & this.elements.length - 1);
            BytecodeManager.incBytecodes(11);
            final Object o3 = o;
            BytecodeManager.incBytecodes(2);
            return (E)o3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public E pollLast() {
        try {
            final int tail = this.tail - 1 & this.elements.length - 1;
            BytecodeManager.incBytecodes(11);
            final Object o = this.elements[tail];
            BytecodeManager.incBytecodes(5);
            final Object o2 = o;
            BytecodeManager.incBytecodes(2);
            if (o2 == null) {
                final E e = null;
                BytecodeManager.incBytecodes(2);
                return e;
            }
            this.elements[tail] = null;
            BytecodeManager.incBytecodes(5);
            this.tail = tail;
            BytecodeManager.incBytecodes(3);
            final Object o3 = o;
            BytecodeManager.incBytecodes(2);
            return (E)o3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public E getFirst() {
        try {
            final Object o = this.elements[this.head];
            BytecodeManager.incBytecodes(6);
            final Object o2 = o;
            BytecodeManager.incBytecodes(2);
            if (o2 == null) {
                BytecodeManager.incBytecodes(3);
                final NoSuchElementException ex = new NoSuchElementException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final Object o3 = o;
            BytecodeManager.incBytecodes(2);
            return (E)o3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public E getLast() {
        try {
            final Object o = this.elements[this.tail - 1 & this.elements.length - 1];
            BytecodeManager.incBytecodes(14);
            final Object o2 = o;
            BytecodeManager.incBytecodes(2);
            if (o2 == null) {
                BytecodeManager.incBytecodes(3);
                final NoSuchElementException ex = new NoSuchElementException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final Object o3 = o;
            BytecodeManager.incBytecodes(2);
            return (E)o3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public E peekFirst() {
        try {
            final Object o = this.elements[this.head];
            BytecodeManager.incBytecodes(6);
            return (E)o;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public E peekLast() {
        try {
            final Object o = this.elements[this.tail - 1 & this.elements.length - 1];
            BytecodeManager.incBytecodes(14);
            return (E)o;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean removeFirstOccurrence(final Object o) {
        try {
            BytecodeManager.incBytecodes(2);
            if (o == null) {
                final boolean b = false;
                BytecodeManager.incBytecodes(2);
                return b;
            }
            final int n = this.elements.length - 1;
            BytecodeManager.incBytecodes(6);
            int head = this.head;
            BytecodeManager.incBytecodes(3);
            while (true) {
                final Object o2 = this.elements[head];
                BytecodeManager.incBytecodes(7);
                if (o2 == null) {
                    final boolean b2 = false;
                    BytecodeManager.incBytecodes(2);
                    return b2;
                }
                final Object obj = o2;
                BytecodeManager.incBytecodes(3);
                final boolean equals = o.equals(obj);
                BytecodeManager.incBytecodes(1);
                if (equals) {
                    final int n2 = head;
                    BytecodeManager.incBytecodes(3);
                    this.delete(n2);
                    BytecodeManager.incBytecodes(1);
                    final boolean b3 = true;
                    BytecodeManager.incBytecodes(2);
                    return b3;
                }
                head = (head + 1 & n);
                BytecodeManager.incBytecodes(7);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean removeLastOccurrence(final Object o) {
        try {
            BytecodeManager.incBytecodes(2);
            if (o == null) {
                final boolean b = false;
                BytecodeManager.incBytecodes(2);
                return b;
            }
            final int n = this.elements.length - 1;
            BytecodeManager.incBytecodes(6);
            int n2 = this.tail - 1 & n;
            BytecodeManager.incBytecodes(7);
            while (true) {
                final Object o2 = this.elements[n2];
                BytecodeManager.incBytecodes(7);
                if (o2 == null) {
                    final boolean b2 = false;
                    BytecodeManager.incBytecodes(2);
                    return b2;
                }
                final Object obj = o2;
                BytecodeManager.incBytecodes(3);
                final boolean equals = o.equals(obj);
                BytecodeManager.incBytecodes(1);
                if (equals) {
                    final int n3 = n2;
                    BytecodeManager.incBytecodes(3);
                    this.delete(n3);
                    BytecodeManager.incBytecodes(1);
                    final boolean b3 = true;
                    BytecodeManager.incBytecodes(2);
                    return b3;
                }
                n2 = (n2 - 1 & n);
                BytecodeManager.incBytecodes(7);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean add(final E e) {
        try {
            BytecodeManager.incBytecodes(3);
            this.addLast(e);
            final boolean b = true;
            BytecodeManager.incBytecodes(2);
            return b;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean offer(final E e) {
        try {
            BytecodeManager.incBytecodes(3);
            final boolean offerLast = this.offerLast(e);
            BytecodeManager.incBytecodes(1);
            return offerLast;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public E remove() {
        try {
            BytecodeManager.incBytecodes(2);
            final E removeFirst = this.removeFirst();
            BytecodeManager.incBytecodes(1);
            return removeFirst;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public E poll() {
        try {
            BytecodeManager.incBytecodes(2);
            final E pollFirst = this.pollFirst();
            BytecodeManager.incBytecodes(1);
            return pollFirst;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public E element() {
        try {
            BytecodeManager.incBytecodes(2);
            final E first = this.getFirst();
            BytecodeManager.incBytecodes(1);
            return first;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public E peek() {
        try {
            BytecodeManager.incBytecodes(2);
            final E peekFirst = this.peekFirst();
            BytecodeManager.incBytecodes(1);
            return peekFirst;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void push(final E e) {
        try {
            BytecodeManager.incBytecodes(3);
            this.addFirst(e);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public E pop() {
        try {
            BytecodeManager.incBytecodes(2);
            final E removeFirst = this.removeFirst();
            BytecodeManager.incBytecodes(1);
            return removeFirst;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void checkInvariants() {
        try {
            final boolean $assertionsDisabled = ArrayDeque.$assertionsDisabled;
            BytecodeManager.incBytecodes(2);
            if (!$assertionsDisabled) {
                final Object o = this.elements[this.tail];
                BytecodeManager.incBytecodes(6);
                if (o != null) {
                    BytecodeManager.incBytecodes(3);
                    final AssertionError assertionError = new AssertionError();
                    BytecodeManager.incBytecodes(1);
                    throw assertionError;
                }
            }
            final boolean $assertionsDisabled2 = ArrayDeque.$assertionsDisabled;
            BytecodeManager.incBytecodes(2);
            Label_0160: {
                if (!$assertionsDisabled2) {
                    final int head = this.head;
                    final int tail = this.tail;
                    BytecodeManager.incBytecodes(5);
                    if (head == tail) {
                        final Object o2 = this.elements[this.head];
                        BytecodeManager.incBytecodes(6);
                        if (o2 == null) {
                            BytecodeManager.incBytecodes(1);
                            break Label_0160;
                        }
                    }
                    else {
                        final Object o3 = this.elements[this.head];
                        BytecodeManager.incBytecodes(6);
                        if (o3 != null) {
                            final Object o4 = this.elements[this.tail - 1 & this.elements.length - 1];
                            BytecodeManager.incBytecodes(14);
                            if (o4 != null) {
                                break Label_0160;
                            }
                        }
                    }
                    BytecodeManager.incBytecodes(3);
                    final AssertionError assertionError2 = new AssertionError();
                    BytecodeManager.incBytecodes(1);
                    throw assertionError2;
                }
            }
            final boolean $assertionsDisabled3 = ArrayDeque.$assertionsDisabled;
            BytecodeManager.incBytecodes(2);
            if (!$assertionsDisabled3) {
                final Object o5 = this.elements[this.head - 1 & this.elements.length - 1];
                BytecodeManager.incBytecodes(14);
                if (o5 != null) {
                    BytecodeManager.incBytecodes(3);
                    final AssertionError assertionError3 = new AssertionError();
                    BytecodeManager.incBytecodes(1);
                    throw assertionError3;
                }
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private boolean delete(final int n) {
        try {
            BytecodeManager.incBytecodes(2);
            this.checkInvariants();
            final Object[] elements = this.elements;
            BytecodeManager.incBytecodes(3);
            final int n2 = elements.length - 1;
            BytecodeManager.incBytecodes(5);
            final int head = this.head;
            BytecodeManager.incBytecodes(3);
            final int tail = this.tail;
            BytecodeManager.incBytecodes(3);
            final int n3 = n - head & n2;
            BytecodeManager.incBytecodes(6);
            final int n4 = tail - n & n2;
            BytecodeManager.incBytecodes(6);
            final int n5 = n3;
            final int n6 = tail - head & n2;
            BytecodeManager.incBytecodes(7);
            if (n5 >= n6) {
                BytecodeManager.incBytecodes(3);
                final ConcurrentModificationException ex = new ConcurrentModificationException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final int n7 = n3;
            final int n8 = n4;
            BytecodeManager.incBytecodes(3);
            if (n7 < n8) {
                final int n9 = head;
                BytecodeManager.incBytecodes(3);
                if (n9 <= n) {
                    final Object[] array = elements;
                    final int n10 = head;
                    final Object[] array2 = elements;
                    final int n11 = head + 1;
                    final int n12 = n3;
                    BytecodeManager.incBytecodes(8);
                    System.arraycopy(array, n10, array2, n11, n12);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    final Object[] array3 = elements;
                    final int n13 = 0;
                    final Object[] array4 = elements;
                    final int n14 = 1;
                    BytecodeManager.incBytecodes(6);
                    System.arraycopy(array3, n13, array4, n14, n);
                    elements[0] = elements[n2];
                    BytecodeManager.incBytecodes(6);
                    final Object[] array5 = elements;
                    final int n15 = head;
                    final Object[] array6 = elements;
                    final int n16 = head + 1;
                    final int n17 = n2 - head;
                    BytecodeManager.incBytecodes(10);
                    System.arraycopy(array5, n15, array6, n16, n17);
                }
                elements[head] = null;
                BytecodeManager.incBytecodes(4);
                this.head = (head + 1 & n2);
                BytecodeManager.incBytecodes(7);
                final boolean b = false;
                BytecodeManager.incBytecodes(2);
                return b;
            }
            final int n18 = tail;
            BytecodeManager.incBytecodes(3);
            if (n < n18) {
                final Object[] array7 = elements;
                final int n19 = n + 1;
                final Object[] array8 = elements;
                final int n20 = n4;
                BytecodeManager.incBytecodes(8);
                System.arraycopy(array7, n19, array8, n, n20);
                this.tail = tail - 1;
                BytecodeManager.incBytecodes(6);
            }
            else {
                final Object[] array9 = elements;
                final int n21 = n + 1;
                final Object[] array10 = elements;
                final int n22 = n2 - n;
                BytecodeManager.incBytecodes(10);
                System.arraycopy(array9, n21, array10, n, n22);
                elements[n2] = elements[0];
                BytecodeManager.incBytecodes(6);
                final Object[] array11 = elements;
                final int n23 = 1;
                final Object[] array12 = elements;
                final int n24 = 0;
                final int n25 = tail;
                BytecodeManager.incBytecodes(6);
                System.arraycopy(array11, n23, array12, n24, n25);
                this.tail = (tail - 1 & n2);
                BytecodeManager.incBytecodes(7);
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
    public int size() {
        try {
            final int n = this.tail - this.head & this.elements.length - 1;
            BytecodeManager.incBytecodes(12);
            return n;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean isEmpty() {
        try {
            final int head = this.head;
            final int tail = this.tail;
            BytecodeManager.incBytecodes(5);
            boolean b;
            if (head == tail) {
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
    public Iterator<E> iterator() {
        try {
            final Object object = null;
            BytecodeManager.incBytecodes(5);
            final DeqIterator deqIterator = new DeqIterator();
            BytecodeManager.incBytecodes(1);
            return deqIterator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public Iterator<E> descendingIterator() {
        try {
            final Object object = null;
            BytecodeManager.incBytecodes(5);
            final DescendingIterator descendingIterator = new DescendingIterator();
            BytecodeManager.incBytecodes(1);
            return descendingIterator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean contains(final Object o) {
        try {
            BytecodeManager.incBytecodes(2);
            if (o == null) {
                final boolean b = false;
                BytecodeManager.incBytecodes(2);
                return b;
            }
            final int n = this.elements.length - 1;
            BytecodeManager.incBytecodes(6);
            int head = this.head;
            BytecodeManager.incBytecodes(3);
            while (true) {
                final Object o2 = this.elements[head];
                BytecodeManager.incBytecodes(7);
                if (o2 == null) {
                    final boolean b2 = false;
                    BytecodeManager.incBytecodes(2);
                    return b2;
                }
                final Object obj = o2;
                BytecodeManager.incBytecodes(3);
                final boolean equals = o.equals(obj);
                BytecodeManager.incBytecodes(1);
                if (equals) {
                    final boolean b3 = true;
                    BytecodeManager.incBytecodes(2);
                    return b3;
                }
                head = (head + 1 & n);
                BytecodeManager.incBytecodes(7);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean remove(final Object o) {
        try {
            BytecodeManager.incBytecodes(3);
            final boolean removeFirstOccurrence = this.removeFirstOccurrence(o);
            BytecodeManager.incBytecodes(1);
            return removeFirstOccurrence;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void clear() {
        try {
            final int head = this.head;
            BytecodeManager.incBytecodes(3);
            final int tail = this.tail;
            BytecodeManager.incBytecodes(3);
            final int n = head;
            final int n2 = tail;
            BytecodeManager.incBytecodes(3);
            if (n != n2) {
                final int n3 = 0;
                this.tail = n3;
                this.head = n3;
                BytecodeManager.incBytecodes(6);
                int n4 = head;
                BytecodeManager.incBytecodes(2);
                final int n5 = this.elements.length - 1;
                BytecodeManager.incBytecodes(6);
                int i;
                int n6;
                do {
                    this.elements[n4] = null;
                    BytecodeManager.incBytecodes(5);
                    n4 = (n4 + 1 & n5);
                    BytecodeManager.incBytecodes(6);
                    i = n4;
                    n6 = tail;
                    BytecodeManager.incBytecodes(3);
                } while (i != n6);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public Object[] toArray() {
        try {
            BytecodeManager.incBytecodes(3);
            final Object[] array = new Object[this.size()];
            BytecodeManager.incBytecodes(1);
            final Object[] copyElements = this.copyElements(array);
            BytecodeManager.incBytecodes(1);
            return copyElements;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public <T> T[] toArray(T[] array) {
        try {
            BytecodeManager.incBytecodes(2);
            final int size = this.size();
            BytecodeManager.incBytecodes(1);
            final int length = array.length;
            final int n = size;
            BytecodeManager.incBytecodes(4);
            if (length < n) {
                final T[] array2 = array;
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                final Class<? extends Object[]> class1 = array2.getClass();
                BytecodeManager.incBytecodes(1);
                final Class<?> componentType = class1.getComponentType();
                final int length2 = size;
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                array = (T[])Array.newInstance(componentType, length2);
                BytecodeManager.incBytecodes(3);
            }
            final T[] array3 = array;
            BytecodeManager.incBytecodes(3);
            this.copyElements((Object[])array3);
            BytecodeManager.incBytecodes(1);
            final int length3 = array.length;
            final int n2 = size;
            BytecodeManager.incBytecodes(4);
            if (length3 > n2) {
                array[size] = null;
                BytecodeManager.incBytecodes(4);
            }
            final T[] array4 = array;
            BytecodeManager.incBytecodes(2);
            return array4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public ArrayDeque<E> clone() {
        try {
            try {
                BytecodeManager.incBytecodes(2);
                final ArrayDeque arrayDeque = (ArrayDeque)super.clone();
                BytecodeManager.incBytecodes(2);
                final ArrayDeque arrayDeque2 = arrayDeque;
                final Object[] elements = this.elements;
                final int length = this.elements.length;
                BytecodeManager.incBytecodes(7);
                arrayDeque2.elements = Arrays.copyOf(elements, length);
                BytecodeManager.incBytecodes(1);
                final ArrayDeque<E> arrayDeque3 = arrayDeque;
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                return arrayDeque3;
            }
            catch (CloneNotSupportedException ex) {
                BytecodeManager.incBytecodes(501);
                BytecodeManager.incBytecodes(3);
                final AssertionError assertionError = new AssertionError();
                BytecodeManager.incBytecodes(1);
                throw assertionError;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        catch (VirtualMachineError virtualMachineError) {
            throw virtualMachineError;
        }
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) throws IOException {
        try {
            BytecodeManager.incBytecodes(2);
            objectOutputStream.defaultWriteObject();
            BytecodeManager.incBytecodes(3);
            final int size = this.size();
            BytecodeManager.incBytecodes(1);
            objectOutputStream.writeInt(size);
            final int n = this.elements.length - 1;
            BytecodeManager.incBytecodes(6);
            int head = this.head;
            BytecodeManager.incBytecodes(3);
            while (true) {
                final int n2 = head;
                final int tail = this.tail;
                BytecodeManager.incBytecodes(4);
                if (n2 == tail) {
                    break;
                }
                final Object obj = this.elements[head];
                BytecodeManager.incBytecodes(6);
                objectOutputStream.writeObject(obj);
                head = (head + 1 & n);
                BytecodeManager.incBytecodes(7);
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
            final int int1 = objectInputStream.readInt();
            BytecodeManager.incBytecodes(1);
            final int n = int1;
            BytecodeManager.incBytecodes(3);
            this.allocateElements(n);
            this.head = 0;
            BytecodeManager.incBytecodes(3);
            this.tail = int1;
            BytecodeManager.incBytecodes(3);
            int n2 = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n3 = n2;
                final int n4 = int1;
                BytecodeManager.incBytecodes(3);
                if (n3 >= n4) {
                    break;
                }
                final Object[] elements = this.elements;
                final int n5 = n2;
                BytecodeManager.incBytecodes(5);
                elements[n5] = objectInputStream.readObject();
                BytecodeManager.incBytecodes(1);
                ++n2;
                BytecodeManager.incBytecodes(2);
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
            final int n = -1;
            final int n2 = -1;
            BytecodeManager.incBytecodes(6);
            final DeqSpliterator deqSpliterator = new DeqSpliterator<E>(this, n, n2);
            BytecodeManager.incBytecodes(1);
            return (Spliterator<E>)deqSpliterator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static /* synthetic */ boolean access$200(final ArrayDeque arrayDeque, final int n) {
        try {
            BytecodeManager.incBytecodes(3);
            final boolean delete = arrayDeque.delete(n);
            BytecodeManager.incBytecodes(1);
            return delete;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static {
        try {
            final Class<ArrayDeque> clazz = ArrayDeque.class;
            BytecodeManager.incBytecodes(2);
            final boolean desiredAssertionStatus = clazz.desiredAssertionStatus();
            BytecodeManager.incBytecodes(1);
            boolean $assertionsDisabled2;
            if (!desiredAssertionStatus) {
                $assertionsDisabled2 = true;
                BytecodeManager.incBytecodes(2);
            }
            else {
                $assertionsDisabled2 = false;
                BytecodeManager.incBytecodes(1);
            }
            $assertionsDisabled = $assertionsDisabled2;
            BytecodeManager.incBytecodes(2);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private class DeqIterator implements Iterator<E>
    {
        private int cursor;
        private int fence;
        private int lastRet;
        
        private DeqIterator() {
            try {
                BytecodeManager.incBytecodes(5);
                this.cursor = ArrayDeque.this.head;
                BytecodeManager.incBytecodes(5);
                this.fence = ArrayDeque.this.tail;
                BytecodeManager.incBytecodes(5);
                this.lastRet = -1;
                BytecodeManager.incBytecodes(4);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean hasNext() {
            try {
                final int cursor = this.cursor;
                final int fence = this.fence;
                BytecodeManager.incBytecodes(5);
                boolean b;
                if (cursor != fence) {
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
                final int cursor = this.cursor;
                final int fence = this.fence;
                BytecodeManager.incBytecodes(5);
                if (cursor == fence) {
                    BytecodeManager.incBytecodes(3);
                    final NoSuchElementException ex = new NoSuchElementException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final Object o = ArrayDeque.this.elements[this.cursor];
                BytecodeManager.incBytecodes(7);
                final int tail = ArrayDeque.this.tail;
                final int fence2 = this.fence;
                BytecodeManager.incBytecodes(6);
                if (tail == fence2) {
                    final Object o2 = o;
                    BytecodeManager.incBytecodes(2);
                    if (o2 != null) {
                        this.lastRet = this.cursor;
                        BytecodeManager.incBytecodes(4);
                        this.cursor = (this.cursor + 1 & ArrayDeque.this.elements.length - 1);
                        BytecodeManager.incBytecodes(13);
                        final Object o3 = o;
                        BytecodeManager.incBytecodes(2);
                        return (E)o3;
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
        public void remove() {
            try {
                final int lastRet = this.lastRet;
                BytecodeManager.incBytecodes(3);
                if (lastRet < 0) {
                    BytecodeManager.incBytecodes(3);
                    final IllegalStateException ex = new IllegalStateException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final ArrayDeque this$0 = ArrayDeque.this;
                final int lastRet2 = this.lastRet;
                BytecodeManager.incBytecodes(5);
                final boolean access$200 = ArrayDeque.access$200(this$0, lastRet2);
                BytecodeManager.incBytecodes(1);
                if (access$200) {
                    this.cursor = (this.cursor - 1 & ArrayDeque.this.elements.length - 1);
                    BytecodeManager.incBytecodes(13);
                    this.fence = ArrayDeque.this.tail;
                    BytecodeManager.incBytecodes(5);
                }
                this.lastRet = -1;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
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
                final Object[] elements = ArrayDeque.this.elements;
                BytecodeManager.incBytecodes(4);
                final int n = elements.length - 1;
                final int fence = this.fence;
                int cursor = this.cursor;
                BytecodeManager.incBytecodes(11);
                this.cursor = fence;
                BytecodeManager.incBytecodes(3);
                while (true) {
                    final int n2 = cursor;
                    final int n3 = fence;
                    BytecodeManager.incBytecodes(3);
                    if (n2 == n3) {
                        BytecodeManager.incBytecodes(1);
                        return;
                    }
                    final Object o = elements[cursor];
                    BytecodeManager.incBytecodes(4);
                    cursor = (cursor + 1 & n);
                    BytecodeManager.incBytecodes(6);
                    final Object o2 = o;
                    BytecodeManager.incBytecodes(2);
                    if (o2 == null) {
                        BytecodeManager.incBytecodes(3);
                        final ConcurrentModificationException ex = new ConcurrentModificationException();
                        BytecodeManager.incBytecodes(1);
                        throw ex;
                    }
                    final Object o3 = o;
                    BytecodeManager.incBytecodes(3);
                    consumer.accept((Object)o3);
                    BytecodeManager.incBytecodes(1);
                }
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private class DescendingIterator implements Iterator<E>
    {
        private int cursor;
        private int fence;
        private int lastRet;
        
        private DescendingIterator() {
            try {
                BytecodeManager.incBytecodes(5);
                this.cursor = ArrayDeque.this.tail;
                BytecodeManager.incBytecodes(5);
                this.fence = ArrayDeque.this.head;
                BytecodeManager.incBytecodes(5);
                this.lastRet = -1;
                BytecodeManager.incBytecodes(4);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean hasNext() {
            try {
                final int cursor = this.cursor;
                final int fence = this.fence;
                BytecodeManager.incBytecodes(5);
                boolean b;
                if (cursor != fence) {
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
                final int cursor = this.cursor;
                final int fence = this.fence;
                BytecodeManager.incBytecodes(5);
                if (cursor == fence) {
                    BytecodeManager.incBytecodes(3);
                    final NoSuchElementException ex = new NoSuchElementException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                this.cursor = (this.cursor - 1 & ArrayDeque.this.elements.length - 1);
                BytecodeManager.incBytecodes(13);
                final Object o = ArrayDeque.this.elements[this.cursor];
                BytecodeManager.incBytecodes(7);
                final int head = ArrayDeque.this.head;
                final int fence2 = this.fence;
                BytecodeManager.incBytecodes(6);
                if (head == fence2) {
                    final Object o2 = o;
                    BytecodeManager.incBytecodes(2);
                    if (o2 != null) {
                        this.lastRet = this.cursor;
                        BytecodeManager.incBytecodes(4);
                        final Object o3 = o;
                        BytecodeManager.incBytecodes(2);
                        return (E)o3;
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
        public void remove() {
            try {
                final int lastRet = this.lastRet;
                BytecodeManager.incBytecodes(3);
                if (lastRet < 0) {
                    BytecodeManager.incBytecodes(3);
                    final IllegalStateException ex = new IllegalStateException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final ArrayDeque this$0 = ArrayDeque.this;
                final int lastRet2 = this.lastRet;
                BytecodeManager.incBytecodes(5);
                final boolean access$200 = ArrayDeque.access$200(this$0, lastRet2);
                BytecodeManager.incBytecodes(1);
                if (!access$200) {
                    this.cursor = (this.cursor + 1 & ArrayDeque.this.elements.length - 1);
                    BytecodeManager.incBytecodes(13);
                    this.fence = ArrayDeque.this.head;
                    BytecodeManager.incBytecodes(5);
                }
                this.lastRet = -1;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class DeqSpliterator<E> implements Spliterator<E>
    {
        private final ArrayDeque<E> deq;
        private int fence;
        private int index;
        
        DeqSpliterator(final ArrayDeque<E> deq, final int index, final int fence) {
            try {
                BytecodeManager.incBytecodes(2);
                this.deq = deq;
                BytecodeManager.incBytecodes(3);
                this.index = index;
                BytecodeManager.incBytecodes(3);
                this.fence = fence;
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
                    final int tail = this.deq.tail;
                    this.fence = tail;
                    fence = tail;
                    BytecodeManager.incBytecodes(7);
                    this.index = this.deq.head;
                    BytecodeManager.incBytecodes(5);
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
        public DeqSpliterator<E> trySplit() {
            try {
                BytecodeManager.incBytecodes(2);
                int fence = this.getFence();
                final int index = this.index;
                final int length = this.deq.elements.length;
                BytecodeManager.incBytecodes(9);
                final int n = index;
                final int n2 = fence;
                BytecodeManager.incBytecodes(3);
                if (n != n2) {
                    final int n3 = index + 1 & length - 1;
                    final int n4 = fence;
                    BytecodeManager.incBytecodes(9);
                    if (n3 != n4) {
                        final int n5 = index;
                        final int n6 = fence;
                        BytecodeManager.incBytecodes(3);
                        if (n5 > n6) {
                            fence += length;
                            BytecodeManager.incBytecodes(4);
                        }
                        final int n7 = index + fence >>> 1 & length - 1;
                        BytecodeManager.incBytecodes(10);
                        final ArrayDeque<E> deq = this.deq;
                        final int n8 = index;
                        final int index2 = n7;
                        this.index = index2;
                        BytecodeManager.incBytecodes(10);
                        final DeqSpliterator deqSpliterator = new DeqSpliterator<E>((ArrayDeque<Object>)deq, n8, index2);
                        BytecodeManager.incBytecodes(1);
                        return deqSpliterator;
                    }
                }
                final DeqSpliterator<E> deqSpliterator2 = null;
                BytecodeManager.incBytecodes(2);
                return deqSpliterator2;
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
                final Object[] elements = this.deq.elements;
                BytecodeManager.incBytecodes(4);
                final int n = elements.length - 1;
                BytecodeManager.incBytecodes(7);
                final int fence = this.getFence();
                int index = this.index;
                BytecodeManager.incBytecodes(4);
                this.index = fence;
                BytecodeManager.incBytecodes(3);
                while (true) {
                    final int n2 = index;
                    final int n3 = fence;
                    BytecodeManager.incBytecodes(3);
                    if (n2 == n3) {
                        BytecodeManager.incBytecodes(1);
                        return;
                    }
                    final Object o = elements[index];
                    BytecodeManager.incBytecodes(4);
                    index = (index + 1 & n);
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
                    BytecodeManager.incBytecodes(1);
                }
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
                final Object[] elements = this.deq.elements;
                BytecodeManager.incBytecodes(4);
                final int n = elements.length - 1;
                BytecodeManager.incBytecodes(7);
                this.getFence();
                final int index = this.index;
                BytecodeManager.incBytecodes(4);
                final int n2 = index;
                final int fence = this.fence;
                BytecodeManager.incBytecodes(4);
                if (n2 == fence) {
                    final boolean b = false;
                    BytecodeManager.incBytecodes(2);
                    return b;
                }
                final Object o = elements[index];
                BytecodeManager.incBytecodes(4);
                this.index = (index + 1 & n);
                BytecodeManager.incBytecodes(7);
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
                final boolean b2 = true;
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
                int n = this.getFence() - this.index;
                BytecodeManager.incBytecodes(4);
                final int n2 = n;
                BytecodeManager.incBytecodes(2);
                if (n2 < 0) {
                    n += this.deq.elements.length;
                    BytecodeManager.incBytecodes(7);
                }
                final long n3 = n;
                BytecodeManager.incBytecodes(3);
                return n3;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int characteristics() {
            try {
                final int n = 16720;
                BytecodeManager.incBytecodes(2);
                return n;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
}
