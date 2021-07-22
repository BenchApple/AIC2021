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

public class LinkedList<E> extends AbstractSequentialList<E> implements List<E>, Deque<E>, Cloneable, Serializable
{
    transient int size;
    transient Node<E> first;
    transient Node<E> last;
    private static final long serialVersionUID = 876323262645176354L;
    
    public LinkedList() {
        try {
            BytecodeManager.incBytecodes(2);
            this.size = 0;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public LinkedList(final Collection<? extends E> collection) {
        try {
            BytecodeManager.incBytecodes(2);
            this();
            BytecodeManager.incBytecodes(3);
            this.addAll(collection);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void linkFirst(final E e) {
        try {
            final Node<E> first = this.first;
            BytecodeManager.incBytecodes(3);
            final Node<Object> node = null;
            final Node<E> node2 = first;
            BytecodeManager.incBytecodes(6);
            final Node prev = new Node<E>(node, e, (Node<Object>)node2);
            BytecodeManager.incBytecodes(1);
            this.first = (Node<E>)prev;
            BytecodeManager.incBytecodes(3);
            final Node<E> node3 = first;
            BytecodeManager.incBytecodes(2);
            if (node3 == null) {
                this.last = (Node<E>)prev;
                BytecodeManager.incBytecodes(4);
            }
            else {
                first.prev = (Node<E>)prev;
                BytecodeManager.incBytecodes(3);
            }
            ++this.size;
            BytecodeManager.incBytecodes(6);
            ++this.modCount;
            BytecodeManager.incBytecodes(6);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    void linkLast(final E e) {
        try {
            final Node<E> last = this.last;
            BytecodeManager.incBytecodes(3);
            final Node<E> node = last;
            final Node<E> node2 = null;
            BytecodeManager.incBytecodes(6);
            final Node next = new Node<E>((Node<Object>)node, e, (Node<Object>)node2);
            BytecodeManager.incBytecodes(1);
            this.last = (Node<E>)next;
            BytecodeManager.incBytecodes(3);
            final Node<E> node3 = last;
            BytecodeManager.incBytecodes(2);
            if (node3 == null) {
                this.first = (Node<E>)next;
                BytecodeManager.incBytecodes(4);
            }
            else {
                last.next = (Node<E>)next;
                BytecodeManager.incBytecodes(3);
            }
            ++this.size;
            BytecodeManager.incBytecodes(6);
            ++this.modCount;
            BytecodeManager.incBytecodes(6);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    void linkBefore(final E e, final Node<E> node) {
        try {
            final Node<E> prev = node.prev;
            BytecodeManager.incBytecodes(3);
            final Node<E> node2 = prev;
            BytecodeManager.incBytecodes(6);
            final Node next = new Node<E>(node2, e, node);
            BytecodeManager.incBytecodes(1);
            node.prev = (Node<E>)next;
            BytecodeManager.incBytecodes(3);
            final Node<E> node3 = prev;
            BytecodeManager.incBytecodes(2);
            if (node3 == null) {
                this.first = (Node<E>)next;
                BytecodeManager.incBytecodes(4);
            }
            else {
                prev.next = (Node<E>)next;
                BytecodeManager.incBytecodes(3);
            }
            ++this.size;
            BytecodeManager.incBytecodes(6);
            ++this.modCount;
            BytecodeManager.incBytecodes(6);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private E unlinkFirst(final Node<E> node) {
        try {
            final E item = node.item;
            BytecodeManager.incBytecodes(3);
            final Node<E> next = node.next;
            BytecodeManager.incBytecodes(3);
            node.item = null;
            BytecodeManager.incBytecodes(3);
            node.next = null;
            BytecodeManager.incBytecodes(3);
            this.first = next;
            BytecodeManager.incBytecodes(3);
            final Node<E> node2 = next;
            BytecodeManager.incBytecodes(2);
            if (node2 == null) {
                this.last = null;
                BytecodeManager.incBytecodes(4);
            }
            else {
                next.prev = null;
                BytecodeManager.incBytecodes(3);
            }
            --this.size;
            BytecodeManager.incBytecodes(6);
            ++this.modCount;
            BytecodeManager.incBytecodes(6);
            final E e = item;
            BytecodeManager.incBytecodes(2);
            return e;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private E unlinkLast(final Node<E> node) {
        try {
            final E item = node.item;
            BytecodeManager.incBytecodes(3);
            final Node<E> prev = node.prev;
            BytecodeManager.incBytecodes(3);
            node.item = null;
            BytecodeManager.incBytecodes(3);
            node.prev = null;
            BytecodeManager.incBytecodes(3);
            this.last = prev;
            BytecodeManager.incBytecodes(3);
            final Node<E> node2 = prev;
            BytecodeManager.incBytecodes(2);
            if (node2 == null) {
                this.first = null;
                BytecodeManager.incBytecodes(4);
            }
            else {
                prev.next = null;
                BytecodeManager.incBytecodes(3);
            }
            --this.size;
            BytecodeManager.incBytecodes(6);
            ++this.modCount;
            BytecodeManager.incBytecodes(6);
            final E e = item;
            BytecodeManager.incBytecodes(2);
            return e;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    E unlink(final Node<E> node) {
        try {
            final E item = node.item;
            BytecodeManager.incBytecodes(3);
            final Node<E> next = node.next;
            BytecodeManager.incBytecodes(3);
            final Node<E> prev = node.prev;
            BytecodeManager.incBytecodes(3);
            final Node<E> node2 = prev;
            BytecodeManager.incBytecodes(2);
            if (node2 == null) {
                this.first = next;
                BytecodeManager.incBytecodes(4);
            }
            else {
                prev.next = next;
                BytecodeManager.incBytecodes(3);
                node.prev = null;
                BytecodeManager.incBytecodes(3);
            }
            final Node<E> node3 = next;
            BytecodeManager.incBytecodes(2);
            if (node3 == null) {
                this.last = prev;
                BytecodeManager.incBytecodes(4);
            }
            else {
                next.prev = prev;
                BytecodeManager.incBytecodes(3);
                node.next = null;
                BytecodeManager.incBytecodes(3);
            }
            node.item = null;
            BytecodeManager.incBytecodes(3);
            --this.size;
            BytecodeManager.incBytecodes(6);
            ++this.modCount;
            BytecodeManager.incBytecodes(6);
            final E e = item;
            BytecodeManager.incBytecodes(2);
            return e;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public E getFirst() {
        try {
            final Node<E> first = this.first;
            BytecodeManager.incBytecodes(3);
            final Node<E> node = first;
            BytecodeManager.incBytecodes(2);
            if (node == null) {
                BytecodeManager.incBytecodes(3);
                final NoSuchElementException ex = new NoSuchElementException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final E item = first.item;
            BytecodeManager.incBytecodes(3);
            return item;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public E getLast() {
        try {
            final Node<E> last = this.last;
            BytecodeManager.incBytecodes(3);
            final Node<E> node = last;
            BytecodeManager.incBytecodes(2);
            if (node == null) {
                BytecodeManager.incBytecodes(3);
                final NoSuchElementException ex = new NoSuchElementException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final E item = last.item;
            BytecodeManager.incBytecodes(3);
            return item;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public E removeFirst() {
        try {
            final Node<E> first = this.first;
            BytecodeManager.incBytecodes(3);
            final Node<E> node = first;
            BytecodeManager.incBytecodes(2);
            if (node == null) {
                BytecodeManager.incBytecodes(3);
                final NoSuchElementException ex = new NoSuchElementException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final Node<E> node2 = first;
            BytecodeManager.incBytecodes(3);
            final Object unlinkFirst = this.unlinkFirst((Node<Object>)node2);
            BytecodeManager.incBytecodes(1);
            return (E)unlinkFirst;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public E removeLast() {
        try {
            final Node<E> last = this.last;
            BytecodeManager.incBytecodes(3);
            final Node<E> node = last;
            BytecodeManager.incBytecodes(2);
            if (node == null) {
                BytecodeManager.incBytecodes(3);
                final NoSuchElementException ex = new NoSuchElementException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final Node<E> node2 = last;
            BytecodeManager.incBytecodes(3);
            final Object unlinkLast = this.unlinkLast((Node<Object>)node2);
            BytecodeManager.incBytecodes(1);
            return (E)unlinkLast;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void addFirst(final E e) {
        try {
            BytecodeManager.incBytecodes(3);
            this.linkFirst(e);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void addLast(final E e) {
        try {
            BytecodeManager.incBytecodes(3);
            this.linkLast(e);
            BytecodeManager.incBytecodes(1);
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
    public boolean add(final E e) {
        try {
            BytecodeManager.incBytecodes(3);
            this.linkLast(e);
            final boolean b = true;
            BytecodeManager.incBytecodes(2);
            return b;
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
                Node<E> node = this.first;
                BytecodeManager.incBytecodes(3);
                while (true) {
                    final Node<E> node2 = node;
                    BytecodeManager.incBytecodes(2);
                    if (node2 == null) {
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    final E item = node.item;
                    BytecodeManager.incBytecodes(3);
                    if (item == null) {
                        final Node<E> node3 = node;
                        BytecodeManager.incBytecodes(3);
                        this.unlink(node3);
                        BytecodeManager.incBytecodes(1);
                        final boolean b = true;
                        BytecodeManager.incBytecodes(2);
                        return b;
                    }
                    node = node.next;
                    BytecodeManager.incBytecodes(4);
                }
            }
            else {
                Node<E> node4 = this.first;
                BytecodeManager.incBytecodes(3);
                while (true) {
                    final Node<E> node5 = node4;
                    BytecodeManager.incBytecodes(2);
                    if (node5 == null) {
                        break;
                    }
                    final E item2 = node4.item;
                    BytecodeManager.incBytecodes(4);
                    final boolean equals = o.equals(item2);
                    BytecodeManager.incBytecodes(1);
                    if (equals) {
                        final Node<E> node6 = node4;
                        BytecodeManager.incBytecodes(3);
                        this.unlink(node6);
                        BytecodeManager.incBytecodes(1);
                        final boolean b2 = true;
                        BytecodeManager.incBytecodes(2);
                        return b2;
                    }
                    node4 = node4.next;
                    BytecodeManager.incBytecodes(4);
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
            this.checkPositionIndex(n);
            BytecodeManager.incBytecodes(2);
            final Object[] array = collection.toArray();
            BytecodeManager.incBytecodes(1);
            final int length = array.length;
            BytecodeManager.incBytecodes(3);
            final int n2 = length;
            BytecodeManager.incBytecodes(2);
            if (n2 == 0) {
                final boolean b = false;
                BytecodeManager.incBytecodes(2);
                return b;
            }
            final int size = this.size;
            BytecodeManager.incBytecodes(4);
            Node<E> node;
            Node<E> node2;
            if (n == size) {
                node = null;
                BytecodeManager.incBytecodes(2);
                node2 = this.last;
                BytecodeManager.incBytecodes(4);
            }
            else {
                BytecodeManager.incBytecodes(3);
                node = this.node(n);
                BytecodeManager.incBytecodes(1);
                node2 = node.prev;
                BytecodeManager.incBytecodes(3);
            }
            final Object[] array2 = array;
            final int length2 = array2.length;
            int n3 = 0;
            BytecodeManager.incBytecodes(7);
            while (true) {
                final int n4 = n3;
                final int n5 = length2;
                BytecodeManager.incBytecodes(3);
                if (n4 >= n5) {
                    break;
                }
                final Object o = array2[n3];
                BytecodeManager.incBytecodes(4);
                final Object o2 = o;
                BytecodeManager.incBytecodes(2);
                final Node<Object> node3 = (Node<Object>)node2;
                final E e = (E)o2;
                final Node<E> node4 = null;
                BytecodeManager.incBytecodes(6);
                final Node node5 = new Node<Object>(node3, e, (Node<Object>)node4);
                BytecodeManager.incBytecodes(1);
                final Node<Object> node6 = (Node<Object>)node2;
                BytecodeManager.incBytecodes(2);
                if (node6 == null) {
                    this.first = (Node<E>)node5;
                    BytecodeManager.incBytecodes(4);
                }
                else {
                    node2.next = (Node<E>)node5;
                    BytecodeManager.incBytecodes(3);
                }
                node2 = (Node<E>)node5;
                BytecodeManager.incBytecodes(2);
                ++n3;
                BytecodeManager.incBytecodes(2);
            }
            final Node<E> node7 = node;
            BytecodeManager.incBytecodes(2);
            if (node7 == null) {
                this.last = node2;
                BytecodeManager.incBytecodes(4);
            }
            else {
                node2.next = node;
                BytecodeManager.incBytecodes(3);
                node.prev = node2;
                BytecodeManager.incBytecodes(3);
            }
            this.size += length;
            BytecodeManager.incBytecodes(6);
            ++this.modCount;
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
    public void clear() {
        try {
            Node<E> first = this.first;
            BytecodeManager.incBytecodes(3);
            while (true) {
                final Node<E> node = first;
                BytecodeManager.incBytecodes(2);
                if (node == null) {
                    break;
                }
                final Node<E> next = first.next;
                BytecodeManager.incBytecodes(3);
                first.item = null;
                BytecodeManager.incBytecodes(3);
                first.next = null;
                BytecodeManager.incBytecodes(3);
                first.prev = null;
                BytecodeManager.incBytecodes(3);
                first = next;
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
            final Node<E> node2 = null;
            this.last = node2;
            this.first = node2;
            BytecodeManager.incBytecodes(6);
            this.size = 0;
            BytecodeManager.incBytecodes(3);
            ++this.modCount;
            BytecodeManager.incBytecodes(6);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public E get(final int n) {
        try {
            BytecodeManager.incBytecodes(3);
            this.checkElementIndex(n);
            BytecodeManager.incBytecodes(3);
            final E item = this.node(n).item;
            BytecodeManager.incBytecodes(2);
            return item;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public E set(final int n, final E item) {
        try {
            BytecodeManager.incBytecodes(3);
            this.checkElementIndex(n);
            BytecodeManager.incBytecodes(3);
            final Node<E> node = this.node(n);
            BytecodeManager.incBytecodes(1);
            final E item2 = node.item;
            BytecodeManager.incBytecodes(3);
            node.item = item;
            BytecodeManager.incBytecodes(3);
            final E e = item2;
            BytecodeManager.incBytecodes(2);
            return e;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void add(final int n, final E e) {
        try {
            BytecodeManager.incBytecodes(3);
            this.checkPositionIndex(n);
            final int size = this.size;
            BytecodeManager.incBytecodes(4);
            if (n == size) {
                BytecodeManager.incBytecodes(3);
                this.linkLast(e);
                BytecodeManager.incBytecodes(1);
            }
            else {
                BytecodeManager.incBytecodes(5);
                final Node<E> node = this.node(n);
                BytecodeManager.incBytecodes(1);
                this.linkBefore(e, node);
            }
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
            this.checkElementIndex(n);
            BytecodeManager.incBytecodes(4);
            final Node<E> node = this.node(n);
            BytecodeManager.incBytecodes(1);
            final Object unlink = this.unlink((Node<Object>)node);
            BytecodeManager.incBytecodes(1);
            return (E)unlink;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private boolean isElementIndex(final int n) {
        try {
            BytecodeManager.incBytecodes(2);
            boolean b = false;
            Label_0037: {
                if (n >= 0) {
                    final int size = this.size;
                    BytecodeManager.incBytecodes(4);
                    if (n < size) {
                        b = true;
                        BytecodeManager.incBytecodes(2);
                        break Label_0037;
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
    
    private boolean isPositionIndex(final int n) {
        try {
            BytecodeManager.incBytecodes(2);
            boolean b = false;
            Label_0037: {
                if (n >= 0) {
                    final int size = this.size;
                    BytecodeManager.incBytecodes(4);
                    if (n <= size) {
                        b = true;
                        BytecodeManager.incBytecodes(2);
                        break Label_0037;
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
    
    private void checkElementIndex(final int n) {
        try {
            BytecodeManager.incBytecodes(3);
            final boolean elementIndex = this.isElementIndex(n);
            BytecodeManager.incBytecodes(1);
            if (!elementIndex) {
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
    
    private void checkPositionIndex(final int n) {
        try {
            BytecodeManager.incBytecodes(3);
            final boolean positionIndex = this.isPositionIndex(n);
            BytecodeManager.incBytecodes(1);
            if (!positionIndex) {
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
    
    Node<E> node(final int n) {
        try {
            final int n2 = this.size >> 1;
            BytecodeManager.incBytecodes(6);
            if (n < n2) {
                Node<E> node = this.first;
                BytecodeManager.incBytecodes(3);
                int n3 = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n4 = n3;
                    BytecodeManager.incBytecodes(3);
                    if (n4 >= n) {
                        break;
                    }
                    node = node.next;
                    BytecodeManager.incBytecodes(3);
                    ++n3;
                    BytecodeManager.incBytecodes(2);
                }
                final Node<E> node2 = node;
                BytecodeManager.incBytecodes(2);
                return node2;
            }
            Node<E> node3 = this.last;
            BytecodeManager.incBytecodes(3);
            int n5 = this.size - 1;
            BytecodeManager.incBytecodes(5);
            while (true) {
                final int n6 = n5;
                BytecodeManager.incBytecodes(3);
                if (n6 <= n) {
                    break;
                }
                node3 = node3.prev;
                BytecodeManager.incBytecodes(3);
                --n5;
                BytecodeManager.incBytecodes(2);
            }
            final Node<E> node4 = node3;
            BytecodeManager.incBytecodes(2);
            return node4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public int indexOf(final Object o) {
        try {
            int n = 0;
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            if (o == null) {
                Node<E> node = this.first;
                BytecodeManager.incBytecodes(3);
                while (true) {
                    final Node<E> node2 = node;
                    BytecodeManager.incBytecodes(2);
                    if (node2 == null) {
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    final E item = node.item;
                    BytecodeManager.incBytecodes(3);
                    if (item == null) {
                        final int n2 = n;
                        BytecodeManager.incBytecodes(2);
                        return n2;
                    }
                    ++n;
                    BytecodeManager.incBytecodes(1);
                    node = node.next;
                    BytecodeManager.incBytecodes(4);
                }
            }
            else {
                Node<E> node3 = this.first;
                BytecodeManager.incBytecodes(3);
                while (true) {
                    final Node<E> node4 = node3;
                    BytecodeManager.incBytecodes(2);
                    if (node4 == null) {
                        break;
                    }
                    final E item2 = node3.item;
                    BytecodeManager.incBytecodes(4);
                    final boolean equals = o.equals(item2);
                    BytecodeManager.incBytecodes(1);
                    if (equals) {
                        final int n3 = n;
                        BytecodeManager.incBytecodes(2);
                        return n3;
                    }
                    ++n;
                    BytecodeManager.incBytecodes(1);
                    node3 = node3.next;
                    BytecodeManager.incBytecodes(4);
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
    public int lastIndexOf(final Object o) {
        try {
            int size = this.size;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(2);
            if (o == null) {
                Node<E> node = this.last;
                BytecodeManager.incBytecodes(3);
                while (true) {
                    final Node<E> node2 = node;
                    BytecodeManager.incBytecodes(2);
                    if (node2 == null) {
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    --size;
                    BytecodeManager.incBytecodes(1);
                    final E item = node.item;
                    BytecodeManager.incBytecodes(3);
                    if (item == null) {
                        final int n = size;
                        BytecodeManager.incBytecodes(2);
                        return n;
                    }
                    node = node.prev;
                    BytecodeManager.incBytecodes(4);
                }
            }
            else {
                Node<E> node3 = this.last;
                BytecodeManager.incBytecodes(3);
                while (true) {
                    final Node<E> node4 = node3;
                    BytecodeManager.incBytecodes(2);
                    if (node4 == null) {
                        break;
                    }
                    --size;
                    BytecodeManager.incBytecodes(1);
                    final E item2 = node3.item;
                    BytecodeManager.incBytecodes(4);
                    final boolean equals = o.equals(item2);
                    BytecodeManager.incBytecodes(1);
                    if (equals) {
                        final int n2 = size;
                        BytecodeManager.incBytecodes(2);
                        return n2;
                    }
                    node3 = node3.prev;
                    BytecodeManager.incBytecodes(4);
                }
            }
            final int n3 = -1;
            BytecodeManager.incBytecodes(2);
            return n3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public E peek() {
        try {
            final Node<E> first = this.first;
            BytecodeManager.incBytecodes(3);
            final Node<E> node = first;
            BytecodeManager.incBytecodes(2);
            E item;
            if (node == null) {
                item = null;
                BytecodeManager.incBytecodes(2);
            }
            else {
                item = first.item;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
            return item;
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
    public E poll() {
        try {
            final Node<E> first = this.first;
            BytecodeManager.incBytecodes(3);
            final Node<E> node = first;
            BytecodeManager.incBytecodes(2);
            Object unlinkFirst;
            if (node == null) {
                unlinkFirst = null;
                BytecodeManager.incBytecodes(2);
            }
            else {
                final Node<Object> node2 = (Node<Object>)first;
                BytecodeManager.incBytecodes(3);
                unlinkFirst = this.unlinkFirst(node2);
            }
            BytecodeManager.incBytecodes(1);
            return (E)unlinkFirst;
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
    public boolean offer(final E e) {
        try {
            BytecodeManager.incBytecodes(3);
            final boolean add = this.add(e);
            BytecodeManager.incBytecodes(1);
            return add;
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
    public E peekFirst() {
        try {
            final Node<E> first = this.first;
            BytecodeManager.incBytecodes(3);
            final Node<E> node = first;
            BytecodeManager.incBytecodes(2);
            E item;
            if (node == null) {
                item = null;
                BytecodeManager.incBytecodes(2);
            }
            else {
                item = first.item;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
            return item;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public E peekLast() {
        try {
            final Node<E> last = this.last;
            BytecodeManager.incBytecodes(3);
            final Node<E> node = last;
            BytecodeManager.incBytecodes(2);
            E item;
            if (node == null) {
                item = null;
                BytecodeManager.incBytecodes(2);
            }
            else {
                item = last.item;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
            return item;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public E pollFirst() {
        try {
            final Node<E> first = this.first;
            BytecodeManager.incBytecodes(3);
            final Node<E> node = first;
            BytecodeManager.incBytecodes(2);
            Object unlinkFirst;
            if (node == null) {
                unlinkFirst = null;
                BytecodeManager.incBytecodes(2);
            }
            else {
                final Node<Object> node2 = (Node<Object>)first;
                BytecodeManager.incBytecodes(3);
                unlinkFirst = this.unlinkFirst(node2);
            }
            BytecodeManager.incBytecodes(1);
            return (E)unlinkFirst;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public E pollLast() {
        try {
            final Node<E> last = this.last;
            BytecodeManager.incBytecodes(3);
            final Node<E> node = last;
            BytecodeManager.incBytecodes(2);
            Object unlinkLast;
            if (node == null) {
                unlinkLast = null;
                BytecodeManager.incBytecodes(2);
            }
            else {
                final Node<Object> node2 = (Node<Object>)last;
                BytecodeManager.incBytecodes(3);
                unlinkLast = this.unlinkLast(node2);
            }
            BytecodeManager.incBytecodes(1);
            return (E)unlinkLast;
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
    
    @Override
    public boolean removeFirstOccurrence(final Object o) {
        try {
            BytecodeManager.incBytecodes(3);
            final boolean remove = this.remove(o);
            BytecodeManager.incBytecodes(1);
            return remove;
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
                Node<E> node = this.last;
                BytecodeManager.incBytecodes(3);
                while (true) {
                    final Node<E> node2 = node;
                    BytecodeManager.incBytecodes(2);
                    if (node2 == null) {
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    final E item = node.item;
                    BytecodeManager.incBytecodes(3);
                    if (item == null) {
                        final Node<E> node3 = node;
                        BytecodeManager.incBytecodes(3);
                        this.unlink(node3);
                        BytecodeManager.incBytecodes(1);
                        final boolean b = true;
                        BytecodeManager.incBytecodes(2);
                        return b;
                    }
                    node = node.prev;
                    BytecodeManager.incBytecodes(4);
                }
            }
            else {
                Node<E> node4 = this.last;
                BytecodeManager.incBytecodes(3);
                while (true) {
                    final Node<E> node5 = node4;
                    BytecodeManager.incBytecodes(2);
                    if (node5 == null) {
                        break;
                    }
                    final E item2 = node4.item;
                    BytecodeManager.incBytecodes(4);
                    final boolean equals = o.equals(item2);
                    BytecodeManager.incBytecodes(1);
                    if (equals) {
                        final Node<E> node6 = node4;
                        BytecodeManager.incBytecodes(3);
                        this.unlink(node6);
                        BytecodeManager.incBytecodes(1);
                        final boolean b2 = true;
                        BytecodeManager.incBytecodes(2);
                        return b2;
                    }
                    node4 = node4.prev;
                    BytecodeManager.incBytecodes(4);
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
    
    @Override
    public ListIterator<E> listIterator(final int n) {
        try {
            BytecodeManager.incBytecodes(3);
            this.checkPositionIndex(n);
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
    
    private LinkedList<E> superClone() {
        try {
            try {
                BytecodeManager.incBytecodes(2);
                final LinkedList list = (LinkedList)super.clone();
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                return list;
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
    
    public Object clone() {
        try {
            BytecodeManager.incBytecodes(2);
            final LinkedList<E> superClone = this.superClone();
            BytecodeManager.incBytecodes(1);
            final LinkedList<E> list = superClone;
            final LinkedList<E> list2 = superClone;
            final Node<E> node = null;
            list2.last = node;
            list.first = node;
            BytecodeManager.incBytecodes(6);
            superClone.size = 0;
            BytecodeManager.incBytecodes(3);
            superClone.modCount = 0;
            BytecodeManager.incBytecodes(3);
            Node<E> node2 = this.first;
            BytecodeManager.incBytecodes(3);
            while (true) {
                final Node<E> node3 = node2;
                BytecodeManager.incBytecodes(2);
                if (node3 == null) {
                    break;
                }
                final LinkedList<E> list3 = superClone;
                final E item = node2.item;
                BytecodeManager.incBytecodes(4);
                list3.add((Object)item);
                BytecodeManager.incBytecodes(1);
                node2 = node2.next;
                BytecodeManager.incBytecodes(4);
            }
            final LinkedList<E> list4 = superClone;
            BytecodeManager.incBytecodes(2);
            return list4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public Object[] toArray() {
        try {
            final Object[] array = new Object[this.size];
            BytecodeManager.incBytecodes(3);
            int n = 0;
            BytecodeManager.incBytecodes(2);
            Node<E> node = this.first;
            BytecodeManager.incBytecodes(3);
            while (true) {
                final Node<E> node2 = node;
                BytecodeManager.incBytecodes(2);
                if (node2 == null) {
                    break;
                }
                array[n++] = node.item;
                BytecodeManager.incBytecodes(6);
                node = node.next;
                BytecodeManager.incBytecodes(4);
            }
            final Object[] array2 = array;
            BytecodeManager.incBytecodes(2);
            return array2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public <T> T[] toArray(T[] array) {
        try {
            final int length = array.length;
            final int size = this.size;
            BytecodeManager.incBytecodes(5);
            if (length < size) {
                final T[] array2 = array;
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                final Class<? extends Object[]> class1 = array2.getClass();
                BytecodeManager.incBytecodes(1);
                final Class<?> componentType = class1.getComponentType();
                final int size2 = this.size;
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
                array = (T[])Array.newInstance(componentType, size2);
                BytecodeManager.incBytecodes(3);
            }
            int n = 0;
            BytecodeManager.incBytecodes(2);
            final T[] array3 = array;
            BytecodeManager.incBytecodes(2);
            Node<E> node = this.first;
            BytecodeManager.incBytecodes(3);
            while (true) {
                final Node<E> node2 = node;
                BytecodeManager.incBytecodes(2);
                if (node2 == null) {
                    break;
                }
                array3[n++] = (T)node.item;
                BytecodeManager.incBytecodes(6);
                node = node.next;
                BytecodeManager.incBytecodes(4);
            }
            final int length2 = array.length;
            final int size3 = this.size;
            BytecodeManager.incBytecodes(5);
            if (length2 > size3) {
                array[this.size] = null;
                BytecodeManager.incBytecodes(5);
            }
            final T[] array4 = array;
            BytecodeManager.incBytecodes(2);
            return array4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) throws IOException {
        try {
            BytecodeManager.incBytecodes(2);
            objectOutputStream.defaultWriteObject();
            final int size = this.size;
            BytecodeManager.incBytecodes(4);
            objectOutputStream.writeInt(size);
            Node<E> node = this.first;
            BytecodeManager.incBytecodes(3);
            while (true) {
                final Node<E> node2 = node;
                BytecodeManager.incBytecodes(2);
                if (node2 == null) {
                    break;
                }
                final E item = node.item;
                BytecodeManager.incBytecodes(4);
                objectOutputStream.writeObject(item);
                node = node.next;
                BytecodeManager.incBytecodes(4);
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
            int n = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n2 = n;
                final int n3 = int1;
                BytecodeManager.incBytecodes(3);
                if (n2 >= n3) {
                    break;
                }
                BytecodeManager.incBytecodes(3);
                final Object object = objectInputStream.readObject();
                BytecodeManager.incBytecodes(1);
                this.linkLast((E)object);
                ++n;
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
            final int n2 = 0;
            BytecodeManager.incBytecodes(6);
            final LLSpliterator llSpliterator = new LLSpliterator<E>(this, n, n2);
            BytecodeManager.incBytecodes(1);
            return (Spliterator<E>)llSpliterator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private class ListItr implements ListIterator<E>
    {
        private Node<E> lastReturned;
        private Node<E> next;
        private int nextIndex;
        private int expectedModCount;
        
        ListItr(final int nextIndex) {
            try {
                BytecodeManager.incBytecodes(5);
                this.expectedModCount = LinkedList.this.modCount;
                BytecodeManager.incBytecodes(5);
                final int size = LinkedList.this.size;
                BytecodeManager.incBytecodes(5);
                Node<E> node;
                if (nextIndex == size) {
                    node = null;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    BytecodeManager.incBytecodes(3);
                    node = LinkedList.this.node(nextIndex);
                }
                this.next = node;
                BytecodeManager.incBytecodes(1);
                this.nextIndex = nextIndex;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean hasNext() {
            try {
                final int nextIndex = this.nextIndex;
                final int size = LinkedList.this.size;
                BytecodeManager.incBytecodes(6);
                boolean b;
                if (nextIndex < size) {
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
                BytecodeManager.incBytecodes(2);
                final boolean hasNext = this.hasNext();
                BytecodeManager.incBytecodes(1);
                if (!hasNext) {
                    BytecodeManager.incBytecodes(3);
                    final NoSuchElementException ex = new NoSuchElementException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                this.lastReturned = this.next;
                BytecodeManager.incBytecodes(4);
                this.next = this.next.next;
                BytecodeManager.incBytecodes(5);
                ++this.nextIndex;
                BytecodeManager.incBytecodes(6);
                final E item = this.lastReturned.item;
                BytecodeManager.incBytecodes(4);
                return item;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean hasPrevious() {
            try {
                final int nextIndex = this.nextIndex;
                BytecodeManager.incBytecodes(3);
                boolean b;
                if (nextIndex > 0) {
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
                BytecodeManager.incBytecodes(2);
                final boolean hasPrevious = this.hasPrevious();
                BytecodeManager.incBytecodes(1);
                if (!hasPrevious) {
                    BytecodeManager.incBytecodes(3);
                    final NoSuchElementException ex = new NoSuchElementException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final Node<E> next = this.next;
                BytecodeManager.incBytecodes(5);
                Node<E> next2;
                Node<E> lastReturned;
                if (next == null) {
                    lastReturned = (next2 = LinkedList.this.last);
                    BytecodeManager.incBytecodes(4);
                }
                else {
                    lastReturned = (next2 = this.next.prev);
                    BytecodeManager.incBytecodes(3);
                }
                this.next = next2;
                this.lastReturned = lastReturned;
                BytecodeManager.incBytecodes(3);
                --this.nextIndex;
                BytecodeManager.incBytecodes(6);
                final E item = this.lastReturned.item;
                BytecodeManager.incBytecodes(4);
                return item;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int nextIndex() {
            try {
                final int nextIndex = this.nextIndex;
                BytecodeManager.incBytecodes(3);
                return nextIndex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int previousIndex() {
            try {
                final int n = this.nextIndex - 1;
                BytecodeManager.incBytecodes(5);
                return n;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void remove() {
            try {
                BytecodeManager.incBytecodes(2);
                this.checkForComodification();
                final Node<E> lastReturned = this.lastReturned;
                BytecodeManager.incBytecodes(3);
                if (lastReturned == null) {
                    BytecodeManager.incBytecodes(3);
                    final IllegalStateException ex = new IllegalStateException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final Node<E> next = this.lastReturned.next;
                BytecodeManager.incBytecodes(4);
                final LinkedList this$0 = LinkedList.this;
                final Node<E> lastReturned2 = this.lastReturned;
                BytecodeManager.incBytecodes(5);
                this$0.unlink(lastReturned2);
                BytecodeManager.incBytecodes(1);
                final Node<E> next2 = this.next;
                final Node<E> lastReturned3 = this.lastReturned;
                BytecodeManager.incBytecodes(5);
                if (next2 == lastReturned3) {
                    this.next = next;
                    BytecodeManager.incBytecodes(4);
                }
                else {
                    --this.nextIndex;
                    BytecodeManager.incBytecodes(6);
                }
                this.lastReturned = null;
                BytecodeManager.incBytecodes(3);
                ++this.expectedModCount;
                BytecodeManager.incBytecodes(6);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void set(final E item) {
            try {
                final Node<E> lastReturned = this.lastReturned;
                BytecodeManager.incBytecodes(3);
                if (lastReturned == null) {
                    BytecodeManager.incBytecodes(3);
                    final IllegalStateException ex = new IllegalStateException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                BytecodeManager.incBytecodes(2);
                this.checkForComodification();
                this.lastReturned.item = item;
                BytecodeManager.incBytecodes(4);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void add(final E e) {
            try {
                BytecodeManager.incBytecodes(2);
                this.checkForComodification();
                this.lastReturned = null;
                BytecodeManager.incBytecodes(3);
                final Node<E> next = this.next;
                BytecodeManager.incBytecodes(3);
                if (next == null) {
                    final LinkedList this$0 = LinkedList.this;
                    BytecodeManager.incBytecodes(4);
                    this$0.linkLast(e);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    final LinkedList this$2 = LinkedList.this;
                    final Node<E> next2 = this.next;
                    BytecodeManager.incBytecodes(6);
                    this$2.linkBefore(e, next2);
                }
                ++this.nextIndex;
                BytecodeManager.incBytecodes(6);
                ++this.expectedModCount;
                BytecodeManager.incBytecodes(6);
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
                while (true) {
                    final int modCount = LinkedList.this.modCount;
                    final int expectedModCount = this.expectedModCount;
                    BytecodeManager.incBytecodes(6);
                    if (modCount != expectedModCount) {
                        break;
                    }
                    final int nextIndex = this.nextIndex;
                    final int size = LinkedList.this.size;
                    BytecodeManager.incBytecodes(6);
                    if (nextIndex >= size) {
                        break;
                    }
                    final E item = this.next.item;
                    BytecodeManager.incBytecodes(5);
                    consumer.accept(item);
                    this.lastReturned = this.next;
                    BytecodeManager.incBytecodes(4);
                    this.next = this.next.next;
                    BytecodeManager.incBytecodes(5);
                    ++this.nextIndex;
                    BytecodeManager.incBytecodes(7);
                }
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
                final int modCount = LinkedList.this.modCount;
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
    
    private static class Node<E>
    {
        E item;
        Node<E> next;
        Node<E> prev;
        
        Node(final Node<E> prev, final E item, final Node<E> next) {
            try {
                BytecodeManager.incBytecodes(2);
                this.item = item;
                BytecodeManager.incBytecodes(3);
                this.next = next;
                BytecodeManager.incBytecodes(3);
                this.prev = prev;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private class DescendingIterator implements Iterator<E>
    {
        private final ListItr itr;
        
        private DescendingIterator() {
            try {
                BytecodeManager.incBytecodes(5);
                final LinkedList this$2 = LinkedList.this;
                final LinkedList this$3 = LinkedList.this;
                BytecodeManager.incBytecodes(8);
                final int size = this$3.size();
                BytecodeManager.incBytecodes(1);
                this.itr = this$2.new ListItr(size);
                BytecodeManager.incBytecodes(2);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean hasNext() {
            try {
                final ListItr itr = this.itr;
                BytecodeManager.incBytecodes(3);
                final boolean hasPrevious = itr.hasPrevious();
                BytecodeManager.incBytecodes(1);
                return hasPrevious;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public E next() {
            try {
                final ListItr itr = this.itr;
                BytecodeManager.incBytecodes(3);
                final E previous = itr.previous();
                BytecodeManager.incBytecodes(1);
                return previous;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void remove() {
            try {
                final ListItr itr = this.itr;
                BytecodeManager.incBytecodes(3);
                itr.remove();
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class LLSpliterator<E> implements Spliterator<E>
    {
        static final int BATCH_UNIT = 1024;
        static final int MAX_BATCH = 33554432;
        final LinkedList<E> list;
        Node<E> current;
        int est;
        int expectedModCount;
        int batch;
        
        LLSpliterator(final LinkedList<E> list, final int est, final int expectedModCount) {
            try {
                BytecodeManager.incBytecodes(2);
                this.list = list;
                BytecodeManager.incBytecodes(3);
                this.est = est;
                BytecodeManager.incBytecodes(3);
                this.expectedModCount = expectedModCount;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        final int getEst() {
            try {
                int est = this.est;
                BytecodeManager.incBytecodes(5);
                if (est < 0) {
                    final LinkedList<E> list2;
                    final LinkedList<E> list = list2 = this.list;
                    BytecodeManager.incBytecodes(5);
                    if (list == null) {
                        final int est2 = 0;
                        this.est = est2;
                        est = est2;
                        BytecodeManager.incBytecodes(6);
                    }
                    else {
                        this.expectedModCount = list2.modCount;
                        BytecodeManager.incBytecodes(4);
                        this.current = list2.first;
                        BytecodeManager.incBytecodes(4);
                        final int size = list2.size;
                        this.est = size;
                        est = size;
                        BytecodeManager.incBytecodes(6);
                    }
                }
                final int n = est;
                BytecodeManager.incBytecodes(2);
                return n;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public long estimateSize() {
            try {
                BytecodeManager.incBytecodes(2);
                final long n = this.getEst();
                BytecodeManager.incBytecodes(2);
                return n;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Spliterator<E> trySplit() {
            try {
                BytecodeManager.incBytecodes(2);
                final int est = this.getEst();
                BytecodeManager.incBytecodes(1);
                final int n = est;
                final int n2 = 1;
                BytecodeManager.incBytecodes(3);
                if (n > n2) {
                    Node<E> current;
                    final Node<E> node = current = this.current;
                    BytecodeManager.incBytecodes(5);
                    if (node != null) {
                        int n3 = this.batch + 1024;
                        BytecodeManager.incBytecodes(5);
                        final int n4 = n3;
                        final int n5 = est;
                        BytecodeManager.incBytecodes(3);
                        if (n4 > n5) {
                            n3 = est;
                            BytecodeManager.incBytecodes(2);
                        }
                        final int n6 = n3;
                        final int n7 = 33554432;
                        BytecodeManager.incBytecodes(3);
                        if (n6 > n7) {
                            n3 = 33554432;
                            BytecodeManager.incBytecodes(2);
                        }
                        final Object[] array = new Object[n3];
                        BytecodeManager.incBytecodes(2);
                        int batch = 0;
                        BytecodeManager.incBytecodes(2);
                        int i;
                        int n8;
                        do {
                            array[batch++] = current.item;
                            final Node<E> node2 = current = current.next;
                            BytecodeManager.incBytecodes(11);
                            if (node2 == null) {
                                break;
                            }
                            i = batch;
                            n8 = n3;
                            BytecodeManager.incBytecodes(3);
                        } while (i < n8);
                        this.current = current;
                        BytecodeManager.incBytecodes(3);
                        this.batch = batch;
                        BytecodeManager.incBytecodes(3);
                        this.est = est - batch;
                        BytecodeManager.incBytecodes(5);
                        final Object[] array2 = array;
                        final int n9 = 0;
                        final int n10 = batch;
                        final int n11 = 16;
                        BytecodeManager.incBytecodes(5);
                        final Spliterator<Object> spliterator = (Spliterator<Object>)Spliterators.spliterator(array2, n9, n10, n11);
                        BytecodeManager.incBytecodes(1);
                        return (Spliterator<E>)spliterator;
                    }
                }
                final Spliterator<E> spliterator2 = null;
                BytecodeManager.incBytecodes(2);
                return spliterator2;
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
                BytecodeManager.incBytecodes(2);
                int est;
                final int n = est = this.getEst();
                BytecodeManager.incBytecodes(3);
                if (n > 0) {
                    Node<E> node2;
                    final Node<E> node = node2 = this.current;
                    BytecodeManager.incBytecodes(5);
                    if (node != null) {
                        this.current = null;
                        BytecodeManager.incBytecodes(3);
                        this.est = 0;
                        BytecodeManager.incBytecodes(3);
                        int i;
                        do {
                            final E item = node2.item;
                            BytecodeManager.incBytecodes(3);
                            node2 = node2.next;
                            BytecodeManager.incBytecodes(3);
                            final E e = item;
                            BytecodeManager.incBytecodes(3);
                            consumer.accept(e);
                            final Node<E> node3 = node2;
                            BytecodeManager.incBytecodes(2);
                            if (node3 == null) {
                                break;
                            }
                            i = --est;
                            BytecodeManager.incBytecodes(3);
                        } while (i > 0);
                    }
                }
                final int modCount = this.list.modCount;
                final int expectedModCount = this.expectedModCount;
                BytecodeManager.incBytecodes(6);
                if (modCount != expectedModCount) {
                    BytecodeManager.incBytecodes(3);
                    final ConcurrentModificationException ex2 = new ConcurrentModificationException();
                    BytecodeManager.incBytecodes(1);
                    throw ex2;
                }
                BytecodeManager.incBytecodes(1);
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
                final int est = this.getEst();
                BytecodeManager.incBytecodes(1);
                if (est > 0) {
                    final Node<E> current;
                    final Node<E> node = current = this.current;
                    BytecodeManager.incBytecodes(5);
                    if (node != null) {
                        --this.est;
                        BytecodeManager.incBytecodes(6);
                        final E item = current.item;
                        BytecodeManager.incBytecodes(3);
                        this.current = current.next;
                        BytecodeManager.incBytecodes(4);
                        final E e = item;
                        BytecodeManager.incBytecodes(3);
                        consumer.accept(e);
                        final int modCount = this.list.modCount;
                        final int expectedModCount = this.expectedModCount;
                        BytecodeManager.incBytecodes(6);
                        if (modCount != expectedModCount) {
                            BytecodeManager.incBytecodes(3);
                            final ConcurrentModificationException ex2 = new ConcurrentModificationException();
                            BytecodeManager.incBytecodes(1);
                            throw ex2;
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
