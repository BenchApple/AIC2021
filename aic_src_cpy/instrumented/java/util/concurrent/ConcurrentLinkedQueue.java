// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.concurrent;

import instrumented.java.util.function.Consumer;
import instrumented.java.util.Spliterators;
import instrumented.java.util.NoSuchElementException;
import java.lang.reflect.Field;
import instrumented.java.util.Spliterator;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import instrumented.java.util.ArrayList;
import java.util.Iterator;
import instrumented.java.util.Collection;
import aic2021.engine.BytecodeManager;
import sun.misc.Unsafe;
import java.io.Serializable;
import instrumented.java.util.Queue;
import instrumented.java.util.AbstractQueue;

public class ConcurrentLinkedQueue<E> extends AbstractQueue<E> implements Queue<E>, Serializable
{
    private static final long serialVersionUID = 196745693267521676L;
    private transient volatile Node<E> head;
    private transient volatile Node<E> tail;
    private static final Unsafe UNSAFE;
    private static final long headOffset;
    private static final long tailOffset;
    
    public ConcurrentLinkedQueue() {
        try {
            BytecodeManager.incBytecodes(2);
            final E e = null;
            BytecodeManager.incBytecodes(6);
            final Node node = new Node<E>(e);
            this.tail = (Node<E>)node;
            this.head = (Node<E>)node;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public ConcurrentLinkedQueue(final Collection<? extends E> collection) {
        try {
            BytecodeManager.incBytecodes(2);
            Node<E> head = null;
            Node<E> tail = null;
            BytecodeManager.incBytecodes(4);
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
                BytecodeManager.incBytecodes(2);
                checkNotNull(e);
                final E e2 = next;
                BytecodeManager.incBytecodes(4);
                final Node node = new Node<E>(e2);
                BytecodeManager.incBytecodes(1);
                final Node<E> node2 = head;
                BytecodeManager.incBytecodes(2);
                if (node2 == null) {
                    tail = (head = (Node<E>)node);
                    BytecodeManager.incBytecodes(5);
                }
                else {
                    final Node<E> node3 = tail;
                    final Node node4 = node;
                    BytecodeManager.incBytecodes(3);
                    node3.lazySetNext(node4);
                    tail = (Node<E>)node;
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(1);
            }
            final Node<E> node5 = head;
            BytecodeManager.incBytecodes(2);
            if (node5 == null) {
                final E e3 = null;
                BytecodeManager.incBytecodes(4);
                tail = (head = new Node<E>(e3));
                BytecodeManager.incBytecodes(3);
            }
            this.head = head;
            BytecodeManager.incBytecodes(3);
            this.tail = tail;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
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
    
    final void updateHead(final Node<E> node, final Node<E> node2) {
        try {
            BytecodeManager.incBytecodes(3);
            if (node != node2) {
                BytecodeManager.incBytecodes(4);
                final boolean casHead = this.casHead(node, node2);
                BytecodeManager.incBytecodes(1);
                if (casHead) {
                    BytecodeManager.incBytecodes(3);
                    node.lazySetNext(node);
                }
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final Node<E> succ(final Node<E> node) {
        try {
            final Node<E> next = node.next;
            BytecodeManager.incBytecodes(3);
            final Node<E> node2 = next;
            BytecodeManager.incBytecodes(3);
            Node<E> head;
            if (node == node2) {
                head = this.head;
                BytecodeManager.incBytecodes(3);
            }
            else {
                head = next;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return head;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean offer(final E e) {
        try {
            BytecodeManager.incBytecodes(2);
            checkNotNull(e);
            BytecodeManager.incBytecodes(4);
            final Node<E> node = new Node<E>(e);
            BytecodeManager.incBytecodes(1);
            Node<E> tail;
            Node<E> node2 = tail = this.tail;
            BytecodeManager.incBytecodes(5);
            while (true) {
                final Node<E> next = tail.next;
                BytecodeManager.incBytecodes(3);
                final Node<E> node3 = next;
                BytecodeManager.incBytecodes(2);
                if (node3 == null) {
                    final Node<E> node4 = tail;
                    final Node<E> node5 = null;
                    final Node<E> node6 = node;
                    BytecodeManager.incBytecodes(4);
                    final boolean casNext = node4.casNext(node5, node6);
                    BytecodeManager.incBytecodes(1);
                    if (casNext) {
                        break;
                    }
                }
                else {
                    final Node<E> node7 = tail;
                    final Node<E> node8 = next;
                    BytecodeManager.incBytecodes(3);
                    if (node7 == node8) {
                        final Node<E> node9 = node2;
                        final Node<E> node10 = node2 = this.tail;
                        BytecodeManager.incBytecodes(6);
                        Node<E> head;
                        if (node9 != node10) {
                            head = node2;
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            head = this.head;
                            BytecodeManager.incBytecodes(2);
                        }
                        tail = head;
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        final Node<E> node11 = tail;
                        final Node<E> node12 = node2;
                        BytecodeManager.incBytecodes(3);
                        Node<E> node15 = null;
                        Label_0215: {
                            if (node11 != node12) {
                                final Node<E> node13 = node2;
                                final Node<E> node14 = node2 = this.tail;
                                BytecodeManager.incBytecodes(6);
                                if (node13 != node14) {
                                    node15 = node2;
                                    BytecodeManager.incBytecodes(2);
                                    break Label_0215;
                                }
                            }
                            node15 = next;
                            BytecodeManager.incBytecodes(1);
                        }
                        tail = node15;
                        BytecodeManager.incBytecodes(1);
                    }
                }
                BytecodeManager.incBytecodes(1);
            }
            final Node<E> node16 = tail;
            final Node<E> node17 = node2;
            BytecodeManager.incBytecodes(3);
            if (node16 != node17) {
                final Node<E> node18 = node2;
                final Node<E> node19 = node;
                BytecodeManager.incBytecodes(4);
                this.casTail(node18, node19);
                BytecodeManager.incBytecodes(1);
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
    public E poll() {
        try {
            while (true) {
                Node<E> head;
                final Node<E> node = head = this.head;
                BytecodeManager.incBytecodes(5);
                while (true) {
                    final E item = head.item;
                    BytecodeManager.incBytecodes(3);
                    final E e = item;
                    BytecodeManager.incBytecodes(2);
                    if (e != null) {
                        final Node<E> node2 = head;
                        final E e2 = item;
                        final E e3 = null;
                        BytecodeManager.incBytecodes(4);
                        final boolean casItem = node2.casItem(e2, e3);
                        BytecodeManager.incBytecodes(1);
                        if (casItem) {
                            final Node<E> node3 = head;
                            final Node<E> node4 = node;
                            BytecodeManager.incBytecodes(3);
                            if (node3 != node4) {
                                final Node<E> node5 = node;
                                final Node<E> next = head.next;
                                BytecodeManager.incBytecodes(7);
                                Node<E> node6;
                                if (next != null) {
                                    node6 = next;
                                    BytecodeManager.incBytecodes(2);
                                }
                                else {
                                    node6 = head;
                                    BytecodeManager.incBytecodes(1);
                                }
                                BytecodeManager.incBytecodes(1);
                                this.updateHead(node5, node6);
                            }
                            final E e4 = item;
                            BytecodeManager.incBytecodes(2);
                            return e4;
                        }
                    }
                    final Node<E> next2;
                    final Node<E> node7 = next2 = head.next;
                    BytecodeManager.incBytecodes(5);
                    if (node7 == null) {
                        final Node<E> node8 = node;
                        final Node<E> node9 = head;
                        BytecodeManager.incBytecodes(4);
                        this.updateHead(node8, node9);
                        final E e5 = null;
                        BytecodeManager.incBytecodes(2);
                        return e5;
                    }
                    final Node<E> node10 = head;
                    final Node<E> node11 = next2;
                    BytecodeManager.incBytecodes(3);
                    if (node10 == node11) {
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    head = next2;
                    BytecodeManager.incBytecodes(2);
                    BytecodeManager.incBytecodes(1);
                }
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public E peek() {
        try {
            Node<E> head = null;
            Node<E> node = null;
            E item = null;
        Label_0047:
            while (true) {
                node = (head = this.head);
                BytecodeManager.incBytecodes(5);
                while (true) {
                    item = head.item;
                    BytecodeManager.incBytecodes(3);
                    final E e = item;
                    BytecodeManager.incBytecodes(2);
                    if (e != null) {
                        break Label_0047;
                    }
                    final Node<E> next;
                    final Node<E> node2 = next = head.next;
                    BytecodeManager.incBytecodes(5);
                    if (node2 == null) {
                        break Label_0047;
                    }
                    final Node<E> node3 = head;
                    final Node<E> node4 = next;
                    BytecodeManager.incBytecodes(3);
                    if (node3 == node4) {
                        break;
                    }
                    head = next;
                    BytecodeManager.incBytecodes(2);
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
            }
            final Node<E> node5 = node;
            final Node<E> node6 = head;
            BytecodeManager.incBytecodes(4);
            this.updateHead(node5, node6);
            final E e2 = item;
            BytecodeManager.incBytecodes(2);
            return e2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    Node<E> first() {
        try {
            Node<E> head = null;
            Node<E> node = null;
            int n2 = 0;
        Label_0070:
            while (true) {
                node = (head = this.head);
                BytecodeManager.incBytecodes(5);
                while (true) {
                    final E item = head.item;
                    BytecodeManager.incBytecodes(3);
                    int n;
                    if (item != null) {
                        n = 1;
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        n = 0;
                        BytecodeManager.incBytecodes(1);
                    }
                    n2 = n;
                    BytecodeManager.incBytecodes(1);
                    final int n3 = n2;
                    BytecodeManager.incBytecodes(2);
                    if (n3 != 0) {
                        break Label_0070;
                    }
                    final Node<E> next;
                    final Node<E> node2 = next = head.next;
                    BytecodeManager.incBytecodes(5);
                    if (node2 == null) {
                        break Label_0070;
                    }
                    final Node<E> node3 = head;
                    final Node<E> node4 = next;
                    BytecodeManager.incBytecodes(3);
                    if (node3 == node4) {
                        break;
                    }
                    head = next;
                    BytecodeManager.incBytecodes(2);
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
            }
            final Node<E> node5 = node;
            final Node<E> node6 = head;
            BytecodeManager.incBytecodes(4);
            this.updateHead(node5, node6);
            final int n4 = n2;
            BytecodeManager.incBytecodes(2);
            Node<E> node7;
            if (n4 != 0) {
                node7 = head;
                BytecodeManager.incBytecodes(2);
            }
            else {
                node7 = null;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return node7;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean isEmpty() {
        try {
            BytecodeManager.incBytecodes(2);
            final Node<E> first = this.first();
            BytecodeManager.incBytecodes(1);
            boolean b;
            if (first == null) {
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
            int n = 0;
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            Node<E> node = this.first();
            BytecodeManager.incBytecodes(1);
            while (true) {
                final Node<E> node2 = node;
                BytecodeManager.incBytecodes(2);
                if (node2 == null) {
                    break;
                }
                final E item = node.item;
                BytecodeManager.incBytecodes(3);
                if (item != null) {
                    final int n2 = ++n;
                    final int n3 = Integer.MAX_VALUE;
                    BytecodeManager.incBytecodes(4);
                    if (n2 == n3) {
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                }
                final Node<E> node3 = node;
                BytecodeManager.incBytecodes(3);
                node = this.succ(node3);
                BytecodeManager.incBytecodes(2);
            }
            final int n4 = n;
            BytecodeManager.incBytecodes(2);
            return n4;
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
            BytecodeManager.incBytecodes(2);
            Node<E> node = this.first();
            BytecodeManager.incBytecodes(1);
            while (true) {
                final Node<E> node2 = node;
                BytecodeManager.incBytecodes(2);
                if (node2 == null) {
                    final boolean b2 = false;
                    BytecodeManager.incBytecodes(2);
                    return b2;
                }
                final E item = node.item;
                BytecodeManager.incBytecodes(3);
                final E e = item;
                BytecodeManager.incBytecodes(2);
                if (e != null) {
                    final E obj = item;
                    BytecodeManager.incBytecodes(3);
                    final boolean equals = o.equals(obj);
                    BytecodeManager.incBytecodes(1);
                    if (equals) {
                        final boolean b3 = true;
                        BytecodeManager.incBytecodes(2);
                        return b3;
                    }
                }
                final Node<E> node3 = node;
                BytecodeManager.incBytecodes(3);
                node = this.succ(node3);
                BytecodeManager.incBytecodes(2);
            }
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
                final boolean b = false;
                BytecodeManager.incBytecodes(2);
                return b;
            }
            Node<E> node = null;
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            Node<E> node2 = this.first();
            BytecodeManager.incBytecodes(1);
            while (true) {
                final Node<E> node3 = node2;
                BytecodeManager.incBytecodes(2);
                if (node3 == null) {
                    final boolean b2 = false;
                    BytecodeManager.incBytecodes(2);
                    return b2;
                }
                final E item = node2.item;
                BytecodeManager.incBytecodes(3);
                final E e = item;
                BytecodeManager.incBytecodes(2);
                if (e != null) {
                    final E obj = item;
                    BytecodeManager.incBytecodes(2);
                    BytecodeManager.incBytecodes(1);
                    final boolean equals = o.equals(obj);
                    BytecodeManager.incBytecodes(1);
                    if (equals) {
                        final Node<E> node4 = node2;
                        final E e2 = item;
                        final E e3 = null;
                        BytecodeManager.incBytecodes(3);
                        BytecodeManager.incBytecodes(1);
                        final boolean casItem = node4.casItem(e2, e3);
                        BytecodeManager.incBytecodes(1);
                        if (casItem) {
                            final Node<E> node5 = node2;
                            BytecodeManager.incBytecodes(3);
                            final Node<E> succ = this.succ(node5);
                            BytecodeManager.incBytecodes(1);
                            final Node<E> node6 = node;
                            BytecodeManager.incBytecodes(2);
                            if (node6 != null) {
                                final Node<E> node7 = succ;
                                BytecodeManager.incBytecodes(2);
                                if (node7 != null) {
                                    final Node<E> node8 = node;
                                    final Node<E> node9 = node2;
                                    final Node<E> node10 = succ;
                                    BytecodeManager.incBytecodes(4);
                                    node8.casNext(node9, node10);
                                    BytecodeManager.incBytecodes(1);
                                }
                            }
                            final boolean b3 = true;
                            BytecodeManager.incBytecodes(2);
                            return b3;
                        }
                    }
                }
                node = node2;
                BytecodeManager.incBytecodes(2);
                final Node<E> node11 = node2;
                BytecodeManager.incBytecodes(3);
                node2 = this.succ(node11);
                BytecodeManager.incBytecodes(2);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean addAll(final Collection<? extends E> collection) {
        try {
            BytecodeManager.incBytecodes(3);
            if (collection == this) {
                BytecodeManager.incBytecodes(3);
                final IllegalArgumentException ex = new IllegalArgumentException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            Node<E> node = null;
            Node<E> node2 = null;
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(2);
            final Iterator<Object> iterator = collection.iterator();
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
                BytecodeManager.incBytecodes(2);
                final E next = iterator3.next();
                BytecodeManager.incBytecodes(1);
                final E e = next;
                BytecodeManager.incBytecodes(2);
                checkNotNull(e);
                final E e2 = next;
                BytecodeManager.incBytecodes(4);
                final Node node3 = new Node<E>(e2);
                BytecodeManager.incBytecodes(1);
                final Node<E> node4 = node;
                BytecodeManager.incBytecodes(2);
                if (node4 == null) {
                    node2 = (node = (Node<E>)node3);
                    BytecodeManager.incBytecodes(5);
                }
                else {
                    final Node<E> node5 = node2;
                    final Node node6 = node3;
                    BytecodeManager.incBytecodes(3);
                    node5.lazySetNext(node6);
                    node2 = (Node<E>)node3;
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(1);
            }
            final Node<E> node7 = node;
            BytecodeManager.incBytecodes(2);
            if (node7 == null) {
                final boolean b = false;
                BytecodeManager.incBytecodes(2);
                return b;
            }
            Node<E> tail;
            Node<E> node8 = tail = this.tail;
            BytecodeManager.incBytecodes(5);
            while (true) {
                final Node<E> next2 = tail.next;
                BytecodeManager.incBytecodes(3);
                final Node<E> node9 = next2;
                BytecodeManager.incBytecodes(2);
                if (node9 == null) {
                    final Node<E> node10 = tail;
                    final Node<E> node11 = null;
                    final Node<E> node12 = node;
                    BytecodeManager.incBytecodes(4);
                    final boolean casNext = node10.casNext(node11, node12);
                    BytecodeManager.incBytecodes(1);
                    if (casNext) {
                        break;
                    }
                }
                else {
                    final Node<E> node13 = tail;
                    final Node<E> node14 = next2;
                    BytecodeManager.incBytecodes(3);
                    if (node13 == node14) {
                        final Node<E> node15 = node8;
                        final Node<E> node16 = node8 = this.tail;
                        BytecodeManager.incBytecodes(6);
                        Node<E> head;
                        if (node15 != node16) {
                            head = node8;
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            head = this.head;
                            BytecodeManager.incBytecodes(2);
                        }
                        tail = head;
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        final Node<E> node17 = tail;
                        final Node<E> node18 = node8;
                        BytecodeManager.incBytecodes(3);
                        Node<E> node21 = null;
                        Label_0419: {
                            if (node17 != node18) {
                                final Node<E> node19 = node8;
                                final Node<E> node20 = node8 = this.tail;
                                BytecodeManager.incBytecodes(6);
                                if (node19 != node20) {
                                    node21 = node8;
                                    BytecodeManager.incBytecodes(2);
                                    break Label_0419;
                                }
                            }
                            node21 = next2;
                            BytecodeManager.incBytecodes(1);
                        }
                        tail = node21;
                        BytecodeManager.incBytecodes(1);
                    }
                }
                BytecodeManager.incBytecodes(1);
            }
            final Node<E> node22 = node8;
            final Node<E> node23 = node2;
            BytecodeManager.incBytecodes(4);
            final boolean casTail = this.casTail(node22, node23);
            BytecodeManager.incBytecodes(1);
            if (!casTail) {
                final Node<E> tail2 = this.tail;
                BytecodeManager.incBytecodes(3);
                final Node<E> next3 = node2.next;
                BytecodeManager.incBytecodes(3);
                if (next3 == null) {
                    final Node<E> node24 = tail2;
                    final Node<E> node25 = node2;
                    BytecodeManager.incBytecodes(4);
                    this.casTail(node24, node25);
                    BytecodeManager.incBytecodes(1);
                }
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
    public Object[] toArray() {
        try {
            BytecodeManager.incBytecodes(3);
            final ArrayList<E> list = new ArrayList<E>();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            Node<E> node = this.first();
            BytecodeManager.incBytecodes(1);
            while (true) {
                final Node<E> node2 = node;
                BytecodeManager.incBytecodes(2);
                if (node2 == null) {
                    break;
                }
                final E item = node.item;
                BytecodeManager.incBytecodes(3);
                final E e = item;
                BytecodeManager.incBytecodes(2);
                if (e != null) {
                    final ArrayList<E> list2 = list;
                    final E e2 = item;
                    BytecodeManager.incBytecodes(3);
                    list2.add(e2);
                    BytecodeManager.incBytecodes(1);
                }
                final Node<E> node3 = node;
                BytecodeManager.incBytecodes(3);
                node = this.succ(node3);
                BytecodeManager.incBytecodes(2);
            }
            final ArrayList<E> list3 = list;
            BytecodeManager.incBytecodes(2);
            final Object[] array = list3.toArray();
            BytecodeManager.incBytecodes(1);
            return array;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public <T> T[] toArray(final T[] array) {
        try {
            int n = 0;
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            Node<E> node = this.first();
            BytecodeManager.incBytecodes(1);
            while (true) {
                final Node<E> node2 = node;
                BytecodeManager.incBytecodes(2);
                if (node2 == null) {
                    break;
                }
                final int n2 = n;
                final int length = array.length;
                BytecodeManager.incBytecodes(4);
                if (n2 >= length) {
                    break;
                }
                final E item = node.item;
                BytecodeManager.incBytecodes(3);
                final E e = item;
                BytecodeManager.incBytecodes(2);
                if (e != null) {
                    array[n++] = (T)item;
                    BytecodeManager.incBytecodes(5);
                }
                final Node<E> node3 = node;
                BytecodeManager.incBytecodes(3);
                node = this.succ(node3);
                BytecodeManager.incBytecodes(2);
            }
            final Node<E> node4 = node;
            BytecodeManager.incBytecodes(2);
            if (node4 == null) {
                final int n3 = n;
                final int length2 = array.length;
                BytecodeManager.incBytecodes(4);
                if (n3 < length2) {
                    array[n] = null;
                    BytecodeManager.incBytecodes(4);
                }
                BytecodeManager.incBytecodes(2);
                return array;
            }
            BytecodeManager.incBytecodes(3);
            final ArrayList<E> list = new ArrayList<E>();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            Node<E> node5 = this.first();
            BytecodeManager.incBytecodes(1);
            while (true) {
                final Node<E> node6 = node5;
                BytecodeManager.incBytecodes(2);
                if (node6 == null) {
                    break;
                }
                final E item2 = node5.item;
                BytecodeManager.incBytecodes(3);
                final E e2 = item2;
                BytecodeManager.incBytecodes(2);
                if (e2 != null) {
                    final ArrayList<E> list2 = list;
                    final E e3 = item2;
                    BytecodeManager.incBytecodes(3);
                    list2.add(e3);
                    BytecodeManager.incBytecodes(1);
                }
                final Node<E> node7 = node5;
                BytecodeManager.incBytecodes(3);
                node5 = this.succ(node7);
                BytecodeManager.incBytecodes(2);
            }
            final ArrayList<E> list3 = list;
            BytecodeManager.incBytecodes(3);
            final T[] array2 = list3.toArray(array);
            BytecodeManager.incBytecodes(1);
            return array2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public Iterator<E> iterator() {
        try {
            BytecodeManager.incBytecodes(4);
            final Itr itr = new Itr();
            BytecodeManager.incBytecodes(1);
            return itr;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) throws IOException {
        try {
            BytecodeManager.incBytecodes(2);
            objectOutputStream.defaultWriteObject();
            BytecodeManager.incBytecodes(2);
            Node<E> node = this.first();
            BytecodeManager.incBytecodes(1);
            while (true) {
                final Node<E> node2 = node;
                BytecodeManager.incBytecodes(2);
                if (node2 == null) {
                    break;
                }
                final E item = node.item;
                BytecodeManager.incBytecodes(3);
                final E e = item;
                BytecodeManager.incBytecodes(2);
                if (e != null) {
                    final E obj = item;
                    BytecodeManager.incBytecodes(3);
                    objectOutputStream.writeObject(obj);
                }
                final Node<E> node3 = node;
                BytecodeManager.incBytecodes(3);
                node = this.succ(node3);
                BytecodeManager.incBytecodes(2);
            }
            final Object obj2 = null;
            BytecodeManager.incBytecodes(3);
            objectOutputStream.writeObject(obj2);
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
            Node<E> head = null;
            Node<E> tail = null;
            BytecodeManager.incBytecodes(4);
            while (true) {
                BytecodeManager.incBytecodes(2);
                final Object object = objectInputStream.readObject();
                BytecodeManager.incBytecodes(3);
                if (object == null) {
                    break;
                }
                final Object o = object;
                BytecodeManager.incBytecodes(4);
                final Node node = new Node<E>(o);
                BytecodeManager.incBytecodes(1);
                final Node<E> node2 = head;
                BytecodeManager.incBytecodes(2);
                if (node2 == null) {
                    tail = (head = (Node<E>)node);
                    BytecodeManager.incBytecodes(5);
                }
                else {
                    final Node<Object> node3 = (Node<Object>)tail;
                    final Node node4 = node;
                    BytecodeManager.incBytecodes(3);
                    node3.lazySetNext(node4);
                    tail = (Node<E>)node;
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(1);
            }
            final Node<E> node5 = head;
            BytecodeManager.incBytecodes(2);
            if (node5 == null) {
                final E e = null;
                BytecodeManager.incBytecodes(4);
                tail = (head = new Node<E>(e));
                BytecodeManager.incBytecodes(3);
            }
            this.head = head;
            BytecodeManager.incBytecodes(3);
            this.tail = tail;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public Spliterator<E> spliterator() {
        try {
            BytecodeManager.incBytecodes(4);
            final CLQSpliterator<E> clqSpliterator = new CLQSpliterator<E>(this);
            BytecodeManager.incBytecodes(1);
            return clqSpliterator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static void checkNotNull(final Object o) {
        try {
            BytecodeManager.incBytecodes(2);
            if (o == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private boolean casTail(final Node<E> expected, final Node<E> x) {
        try {
            final Unsafe unsafe = ConcurrentLinkedQueue.UNSAFE;
            final long tailOffset = ConcurrentLinkedQueue.tailOffset;
            BytecodeManager.incBytecodes(6);
            final boolean compareAndSwapObject = unsafe.compareAndSwapObject(this, tailOffset, expected, x);
            BytecodeManager.incBytecodes(1);
            return compareAndSwapObject;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private boolean casHead(final Node<E> expected, final Node<E> x) {
        try {
            final Unsafe unsafe = ConcurrentLinkedQueue.UNSAFE;
            final long headOffset = ConcurrentLinkedQueue.headOffset;
            BytecodeManager.incBytecodes(6);
            final boolean compareAndSwapObject = unsafe.compareAndSwapObject(this, headOffset, expected, x);
            BytecodeManager.incBytecodes(1);
            return compareAndSwapObject;
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
                    final Class<ConcurrentLinkedQueue> clazz = ConcurrentLinkedQueue.class;
                    BytecodeManager.incBytecodes(2);
                    final Unsafe unsafe = ConcurrentLinkedQueue.UNSAFE;
                    final Class<ConcurrentLinkedQueue> clazz2 = clazz;
                    final String name = "head";
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(1);
                    final Field declaredField = clazz2.getDeclaredField(name);
                    BytecodeManager.incBytecodes(1);
                    headOffset = unsafe.objectFieldOffset(declaredField);
                    BytecodeManager.incBytecodes(1);
                    final Unsafe unsafe2 = ConcurrentLinkedQueue.UNSAFE;
                    final Class<ConcurrentLinkedQueue> clazz3 = clazz;
                    final String name2 = "tail";
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(1);
                    final Field declaredField2 = clazz3.getDeclaredField(name2);
                    BytecodeManager.incBytecodes(1);
                    tailOffset = unsafe2.objectFieldOffset(declaredField2);
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                }
                catch (Exception ex) {
                    BytecodeManager.incBytecodes(501);
                    final Exception cause = ex;
                    BytecodeManager.incBytecodes(4);
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
    
    private static class Node<E>
    {
        volatile E item;
        volatile Node<E> next;
        private static final Unsafe UNSAFE;
        private static final long itemOffset;
        private static final long nextOffset;
        
        Node(final E x) {
            try {
                BytecodeManager.incBytecodes(2);
                final Unsafe unsafe = Node.UNSAFE;
                final long itemOffset = Node.itemOffset;
                BytecodeManager.incBytecodes(5);
                unsafe.putObject(this, itemOffset, x);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        boolean casItem(final E expected, final E x) {
            try {
                final Unsafe unsafe = Node.UNSAFE;
                final long itemOffset = Node.itemOffset;
                BytecodeManager.incBytecodes(6);
                final boolean compareAndSwapObject = unsafe.compareAndSwapObject(this, itemOffset, expected, x);
                BytecodeManager.incBytecodes(1);
                return compareAndSwapObject;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        void lazySetNext(final Node<E> x) {
            try {
                final Unsafe unsafe = Node.UNSAFE;
                final long nextOffset = Node.nextOffset;
                BytecodeManager.incBytecodes(5);
                unsafe.putOrderedObject(this, nextOffset, x);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        boolean casNext(final Node<E> expected, final Node<E> x) {
            try {
                final Unsafe unsafe = Node.UNSAFE;
                final long nextOffset = Node.nextOffset;
                BytecodeManager.incBytecodes(6);
                final boolean compareAndSwapObject = unsafe.compareAndSwapObject(this, nextOffset, expected, x);
                BytecodeManager.incBytecodes(1);
                return compareAndSwapObject;
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
                        final Class<Node> clazz = Node.class;
                        BytecodeManager.incBytecodes(2);
                        final Unsafe unsafe = Node.UNSAFE;
                        final Class<Node> clazz2 = clazz;
                        final String name = "item";
                        BytecodeManager.incBytecodes(3);
                        BytecodeManager.incBytecodes(1);
                        final Field declaredField = clazz2.getDeclaredField(name);
                        BytecodeManager.incBytecodes(1);
                        itemOffset = unsafe.objectFieldOffset(declaredField);
                        BytecodeManager.incBytecodes(1);
                        final Unsafe unsafe2 = Node.UNSAFE;
                        final Class<Node> clazz3 = clazz;
                        final String name2 = "next";
                        BytecodeManager.incBytecodes(3);
                        BytecodeManager.incBytecodes(1);
                        final Field declaredField2 = clazz3.getDeclaredField(name2);
                        BytecodeManager.incBytecodes(1);
                        nextOffset = unsafe2.objectFieldOffset(declaredField2);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                    }
                    catch (Exception ex) {
                        BytecodeManager.incBytecodes(501);
                        final Exception cause = ex;
                        BytecodeManager.incBytecodes(4);
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
    
    private class Itr implements Iterator<E>
    {
        private Node<E> nextNode;
        private E nextItem;
        private Node<E> lastRet;
        
        Itr() {
            try {
                BytecodeManager.incBytecodes(5);
                BytecodeManager.incBytecodes(2);
                this.advance();
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private E advance() {
            try {
                this.lastRet = this.nextNode;
                BytecodeManager.incBytecodes(4);
                final E nextItem = this.nextItem;
                BytecodeManager.incBytecodes(3);
                final Node<E> nextNode = this.nextNode;
                BytecodeManager.incBytecodes(3);
                Node<E> nextNode2;
                Node<E> nextNode3;
                if (nextNode == null) {
                    final ConcurrentLinkedQueue this$0 = ConcurrentLinkedQueue.this;
                    BytecodeManager.incBytecodes(3);
                    nextNode2 = this$0.first();
                    BytecodeManager.incBytecodes(1);
                    nextNode3 = null;
                    BytecodeManager.incBytecodes(3);
                }
                else {
                    nextNode3 = this.nextNode;
                    BytecodeManager.incBytecodes(3);
                    final ConcurrentLinkedQueue this$2 = ConcurrentLinkedQueue.this;
                    final Node<E> nextNode4 = this.nextNode;
                    BytecodeManager.incBytecodes(5);
                    nextNode2 = this$2.succ(nextNode4);
                    BytecodeManager.incBytecodes(1);
                }
                while (true) {
                    final Node<E> node = nextNode2;
                    BytecodeManager.incBytecodes(2);
                    if (node == null) {
                        this.nextNode = null;
                        BytecodeManager.incBytecodes(3);
                        this.nextItem = null;
                        BytecodeManager.incBytecodes(3);
                        final E e = nextItem;
                        BytecodeManager.incBytecodes(2);
                        return e;
                    }
                    final E item = nextNode2.item;
                    BytecodeManager.incBytecodes(3);
                    final E e2 = item;
                    BytecodeManager.incBytecodes(2);
                    if (e2 != null) {
                        this.nextNode = nextNode2;
                        BytecodeManager.incBytecodes(3);
                        this.nextItem = item;
                        BytecodeManager.incBytecodes(3);
                        final E e3 = nextItem;
                        BytecodeManager.incBytecodes(2);
                        return e3;
                    }
                    final ConcurrentLinkedQueue this$3 = ConcurrentLinkedQueue.this;
                    final Node<E> node2 = nextNode2;
                    BytecodeManager.incBytecodes(4);
                    final Node<E> succ = this$3.succ(node2);
                    BytecodeManager.incBytecodes(1);
                    final Node<E> node3 = nextNode3;
                    BytecodeManager.incBytecodes(2);
                    if (node3 != null) {
                        final Node<E> node4 = succ;
                        BytecodeManager.incBytecodes(2);
                        if (node4 != null) {
                            final Node<E> node5 = nextNode3;
                            final Node<E> node6 = nextNode2;
                            final Node<E> node7 = succ;
                            BytecodeManager.incBytecodes(4);
                            node5.casNext(node6, node7);
                            BytecodeManager.incBytecodes(1);
                        }
                    }
                    nextNode2 = succ;
                    BytecodeManager.incBytecodes(2);
                    BytecodeManager.incBytecodes(1);
                }
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean hasNext() {
            try {
                final Node<E> nextNode = this.nextNode;
                BytecodeManager.incBytecodes(3);
                boolean b;
                if (nextNode != null) {
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
                final Node<E> nextNode = this.nextNode;
                BytecodeManager.incBytecodes(3);
                if (nextNode == null) {
                    BytecodeManager.incBytecodes(3);
                    final NoSuchElementException ex = new NoSuchElementException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                BytecodeManager.incBytecodes(2);
                final E advance = this.advance();
                BytecodeManager.incBytecodes(1);
                return advance;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void remove() {
            try {
                final Node<E> lastRet = this.lastRet;
                BytecodeManager.incBytecodes(3);
                final Node<E> node = lastRet;
                BytecodeManager.incBytecodes(2);
                if (node == null) {
                    BytecodeManager.incBytecodes(3);
                    final IllegalStateException ex = new IllegalStateException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                lastRet.item = null;
                BytecodeManager.incBytecodes(3);
                this.lastRet = null;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class CLQSpliterator<E> implements Spliterator<E>
    {
        static final int MAX_BATCH = 33554432;
        final ConcurrentLinkedQueue<E> queue;
        Node<E> current;
        int batch;
        boolean exhausted;
        
        CLQSpliterator(final ConcurrentLinkedQueue<E> queue) {
            try {
                BytecodeManager.incBytecodes(2);
                this.queue = queue;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Spliterator<E> trySplit() {
            try {
                final ConcurrentLinkedQueue<E> queue = this.queue;
                BytecodeManager.incBytecodes(3);
                final int batch = this.batch;
                BytecodeManager.incBytecodes(3);
                final int n = batch;
                BytecodeManager.incBytecodes(2);
                int n2;
                if (n <= 0) {
                    n2 = 1;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final int n3 = batch;
                    final int n4 = 33554432;
                    BytecodeManager.incBytecodes(3);
                    if (n3 >= n4) {
                        n2 = 33554432;
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        n2 = batch + 1;
                        BytecodeManager.incBytecodes(3);
                    }
                }
                final int n5 = n2;
                BytecodeManager.incBytecodes(1);
                final boolean exhausted = this.exhausted;
                BytecodeManager.incBytecodes(3);
                Label_0305: {
                    if (!exhausted) {
                        Node<E> node2;
                        final Node<E> node = node2 = this.current;
                        BytecodeManager.incBytecodes(5);
                        if (node == null) {
                            final ConcurrentLinkedQueue<E> concurrentLinkedQueue = queue;
                            BytecodeManager.incBytecodes(1);
                            BytecodeManager.incBytecodes(1);
                            final Node<E> node3 = node2 = concurrentLinkedQueue.first();
                            BytecodeManager.incBytecodes(3);
                            if (node3 == null) {
                                break Label_0305;
                            }
                        }
                        final Node<E> next = node2.next;
                        BytecodeManager.incBytecodes(3);
                        if (next != null) {
                            final Object[] array = new Object[n5];
                            BytecodeManager.incBytecodes(2);
                            int batch2 = 0;
                            BytecodeManager.incBytecodes(2);
                            int i;
                            int n6;
                            do {
                                final Object[] array2 = array;
                                final int n7 = batch2;
                                final E item = node2.item;
                                array2[n7] = item;
                                BytecodeManager.incBytecodes(7);
                                if (item != null) {
                                    ++batch2;
                                    BytecodeManager.incBytecodes(1);
                                }
                                final Node<E> node4 = node2;
                                final Node<E> node5 = node2 = node2.next;
                                BytecodeManager.incBytecodes(6);
                                if (node4 == node5) {
                                    final ConcurrentLinkedQueue<E> concurrentLinkedQueue2 = queue;
                                    BytecodeManager.incBytecodes(2);
                                    node2 = concurrentLinkedQueue2.first();
                                    BytecodeManager.incBytecodes(1);
                                }
                                final Node<E> node6 = node2;
                                BytecodeManager.incBytecodes(2);
                                if (node6 == null) {
                                    break;
                                }
                                i = batch2;
                                n6 = n5;
                                BytecodeManager.incBytecodes(3);
                            } while (i < n6);
                            final Node<E> current = node2;
                            this.current = current;
                            BytecodeManager.incBytecodes(5);
                            if (current == null) {
                                this.exhausted = true;
                                BytecodeManager.incBytecodes(3);
                            }
                            final int n8 = batch2;
                            BytecodeManager.incBytecodes(2);
                            if (n8 > 0) {
                                this.batch = batch2;
                                BytecodeManager.incBytecodes(3);
                                final Object[] array3 = array;
                                final int n9 = 0;
                                final int n10 = batch2;
                                final int n11 = 4368;
                                BytecodeManager.incBytecodes(4);
                                BytecodeManager.incBytecodes(1);
                                final Spliterator<Object> spliterator = (Spliterator<Object>)Spliterators.spliterator(array3, n9, n10, n11);
                                BytecodeManager.incBytecodes(1);
                                return (Spliterator<E>)spliterator;
                            }
                        }
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
                final ConcurrentLinkedQueue<E> queue = this.queue;
                BytecodeManager.incBytecodes(3);
                final boolean exhausted = this.exhausted;
                BytecodeManager.incBytecodes(3);
                Label_0170: {
                    if (!exhausted) {
                        Node<E> node2;
                        final Node<E> node = node2 = this.current;
                        BytecodeManager.incBytecodes(5);
                        if (node == null) {
                            final ConcurrentLinkedQueue<E> concurrentLinkedQueue = queue;
                            BytecodeManager.incBytecodes(1);
                            BytecodeManager.incBytecodes(1);
                            final Node<E> node3 = node2 = concurrentLinkedQueue.first();
                            BytecodeManager.incBytecodes(3);
                            if (node3 == null) {
                                break Label_0170;
                            }
                        }
                        this.exhausted = true;
                        BytecodeManager.incBytecodes(3);
                        Node<E> node4;
                        do {
                            final E item = node2.item;
                            BytecodeManager.incBytecodes(3);
                            final Node<E> node5 = node2;
                            final Node<E> node6 = node2 = node2.next;
                            BytecodeManager.incBytecodes(6);
                            if (node5 == node6) {
                                final ConcurrentLinkedQueue<E> concurrentLinkedQueue2 = queue;
                                BytecodeManager.incBytecodes(2);
                                node2 = concurrentLinkedQueue2.first();
                                BytecodeManager.incBytecodes(1);
                            }
                            final E e = item;
                            BytecodeManager.incBytecodes(2);
                            if (e != null) {
                                final E e2 = item;
                                BytecodeManager.incBytecodes(3);
                                consumer.accept(e2);
                            }
                            node4 = node2;
                            BytecodeManager.incBytecodes(2);
                        } while (node4 != null);
                    }
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
                final ConcurrentLinkedQueue<E> queue = this.queue;
                BytecodeManager.incBytecodes(3);
                final boolean exhausted = this.exhausted;
                BytecodeManager.incBytecodes(3);
                Label_0201: {
                    if (!exhausted) {
                        Node<E> node2;
                        final Node<E> node = node2 = this.current;
                        BytecodeManager.incBytecodes(5);
                        if (node == null) {
                            final ConcurrentLinkedQueue<E> concurrentLinkedQueue = queue;
                            BytecodeManager.incBytecodes(1);
                            BytecodeManager.incBytecodes(1);
                            final Node<E> node3 = node2 = concurrentLinkedQueue.first();
                            BytecodeManager.incBytecodes(3);
                            if (node3 == null) {
                                break Label_0201;
                            }
                        }
                        Node<E> node4;
                        E item;
                        do {
                            item = node2.item;
                            BytecodeManager.incBytecodes(3);
                            final Node<E> node5 = node2;
                            final Node<E> node6 = node2 = node2.next;
                            BytecodeManager.incBytecodes(6);
                            if (node5 == node6) {
                                final ConcurrentLinkedQueue<E> concurrentLinkedQueue2 = queue;
                                BytecodeManager.incBytecodes(2);
                                node2 = concurrentLinkedQueue2.first();
                                BytecodeManager.incBytecodes(1);
                            }
                            final E e = item;
                            BytecodeManager.incBytecodes(2);
                            if (e != null) {
                                break;
                            }
                            node4 = node2;
                            BytecodeManager.incBytecodes(2);
                        } while (node4 != null);
                        final Node<E> current = node2;
                        this.current = current;
                        BytecodeManager.incBytecodes(5);
                        if (current == null) {
                            this.exhausted = true;
                            BytecodeManager.incBytecodes(3);
                        }
                        final E e2 = item;
                        BytecodeManager.incBytecodes(2);
                        if (e2 != null) {
                            final E e3 = item;
                            BytecodeManager.incBytecodes(3);
                            consumer.accept(e3);
                            final boolean b = true;
                            BytecodeManager.incBytecodes(2);
                            return b;
                        }
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
                final long n = Long.MAX_VALUE;
                BytecodeManager.incBytecodes(2);
                return n;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int characteristics() {
            try {
                final int n = 4368;
                BytecodeManager.incBytecodes(2);
                return n;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
}
