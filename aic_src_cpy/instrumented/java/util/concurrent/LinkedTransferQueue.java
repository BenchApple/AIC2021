// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.concurrent;

import instrumented.java.util.function.Consumer;
import instrumented.java.util.Spliterators;
import instrumented.java.util.NoSuchElementException;
import java.lang.reflect.Field;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import instrumented.java.util.Collection;
import instrumented.java.util.Spliterator;
import instrumented.java.util.concurrent.locks.LockSupport;
import aic2021.engine.BytecodeManager;
import sun.misc.Unsafe;
import java.io.Serializable;
import instrumented.java.util.AbstractQueue;

public class LinkedTransferQueue<E> extends AbstractQueue<E> implements TransferQueue<E>, Serializable
{
    private static final long serialVersionUID = -3223113410248163686L;
    private static final boolean MP;
    private static final int FRONT_SPINS = 128;
    private static final int CHAINED_SPINS = 64;
    static final int SWEEP_THRESHOLD = 32;
    transient volatile Node head;
    private transient volatile Node tail;
    private transient volatile int sweepVotes;
    private static final int NOW = 0;
    private static final int ASYNC = 1;
    private static final int SYNC = 2;
    private static final int TIMED = 3;
    private static final Unsafe UNSAFE;
    private static final long headOffset;
    private static final long tailOffset;
    private static final long sweepVotesOffset;
    
    private boolean casTail(final Node expected, final Node x) {
        try {
            final Unsafe unsafe = LinkedTransferQueue.UNSAFE;
            final long tailOffset = LinkedTransferQueue.tailOffset;
            BytecodeManager.incBytecodes(6);
            final boolean compareAndSwapObject = unsafe.compareAndSwapObject(this, tailOffset, expected, x);
            BytecodeManager.incBytecodes(1);
            return compareAndSwapObject;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private boolean casHead(final Node expected, final Node x) {
        try {
            final Unsafe unsafe = LinkedTransferQueue.UNSAFE;
            final long headOffset = LinkedTransferQueue.headOffset;
            BytecodeManager.incBytecodes(6);
            final boolean compareAndSwapObject = unsafe.compareAndSwapObject(this, headOffset, expected, x);
            BytecodeManager.incBytecodes(1);
            return compareAndSwapObject;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private boolean casSweepVotes(final int expected, final int x) {
        try {
            final Unsafe unsafe = LinkedTransferQueue.UNSAFE;
            final long sweepVotesOffset = LinkedTransferQueue.sweepVotesOffset;
            BytecodeManager.incBytecodes(6);
            final boolean compareAndSwapInt = unsafe.compareAndSwapInt(this, sweepVotesOffset, expected, x);
            BytecodeManager.incBytecodes(1);
            return compareAndSwapInt;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static <E> E cast(final Object o) {
        try {
            BytecodeManager.incBytecodes(2);
            return (E)o;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private E xfer(final E e, final boolean b, final int n, final long n2) {
        try {
            BytecodeManager.incBytecodes(2);
            if (b) {
                BytecodeManager.incBytecodes(2);
                if (e == null) {
                    BytecodeManager.incBytecodes(3);
                    final NullPointerException ex = new NullPointerException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
            }
            Node node = null;
            BytecodeManager.incBytecodes(2);
            while (true) {
                Node head;
                Node node2 = head = this.head;
                BytecodeManager.incBytecodes(5);
                while (true) {
                    final Node node3 = head;
                    BytecodeManager.incBytecodes(2);
                    if (node3 == null) {
                        break;
                    }
                    final boolean isData = head.isData;
                    BytecodeManager.incBytecodes(3);
                    final Object item = head.item;
                    BytecodeManager.incBytecodes(3);
                    final Object o = item;
                    final Node node4 = head;
                    BytecodeManager.incBytecodes(3);
                    if (o != node4) {
                        final Node node5 = (Node)item;
                        BytecodeManager.incBytecodes(2);
                        boolean b2;
                        if (node5 != null) {
                            b2 = true;
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            b2 = false;
                            BytecodeManager.incBytecodes(1);
                        }
                        final boolean b3 = isData;
                        BytecodeManager.incBytecodes(2);
                        if (b2 == b3) {
                            final boolean b4 = isData;
                            BytecodeManager.incBytecodes(3);
                            if (b4 == b) {
                                BytecodeManager.incBytecodes(1);
                                break;
                            }
                            final Node node6 = head;
                            final Node node7 = (Node)item;
                            BytecodeManager.incBytecodes(4);
                            final boolean casItem = node6.casItem(node7, e);
                            BytecodeManager.incBytecodes(1);
                            if (casItem) {
                                Node next = head;
                                BytecodeManager.incBytecodes(2);
                                while (true) {
                                    final Node node8 = next;
                                    final Node node9 = node2;
                                    BytecodeManager.incBytecodes(3);
                                    if (node8 == node9) {
                                        break;
                                    }
                                    final Node next2 = next.next;
                                    BytecodeManager.incBytecodes(3);
                                    final Node head2 = this.head;
                                    final Node node10 = node2;
                                    BytecodeManager.incBytecodes(4);
                                    if (head2 == node10) {
                                        final Node node11 = node2;
                                        final Node node12 = next2;
                                        BytecodeManager.incBytecodes(4);
                                        Node node13;
                                        if (node12 == null) {
                                            node13 = next;
                                            BytecodeManager.incBytecodes(2);
                                        }
                                        else {
                                            node13 = next2;
                                            BytecodeManager.incBytecodes(1);
                                        }
                                        BytecodeManager.incBytecodes(1);
                                        final boolean casHead = this.casHead(node11, node13);
                                        BytecodeManager.incBytecodes(1);
                                        if (casHead) {
                                            final Node node14 = node2;
                                            BytecodeManager.incBytecodes(2);
                                            node14.forgetNext();
                                            BytecodeManager.incBytecodes(1);
                                            break;
                                        }
                                    }
                                    final Node node15 = node2 = this.head;
                                    BytecodeManager.incBytecodes(5);
                                    if (node15 == null) {
                                        break;
                                    }
                                    final Node node16 = next = node2.next;
                                    BytecodeManager.incBytecodes(5);
                                    if (node16 == null) {
                                        break;
                                    }
                                    final Node node17 = next;
                                    BytecodeManager.incBytecodes(1);
                                    BytecodeManager.incBytecodes(1);
                                    final boolean matched = node17.isMatched();
                                    BytecodeManager.incBytecodes(1);
                                    if (!matched) {
                                        BytecodeManager.incBytecodes(1);
                                        break;
                                    }
                                    BytecodeManager.incBytecodes(1);
                                }
                                final Thread waiter = head.waiter;
                                BytecodeManager.incBytecodes(3);
                                LockSupport.unpark(waiter);
                                final Node node18 = (Node)item;
                                BytecodeManager.incBytecodes(2);
                                final Object cast = cast(node18);
                                BytecodeManager.incBytecodes(1);
                                return (E)cast;
                            }
                        }
                    }
                    final Node next3 = head.next;
                    BytecodeManager.incBytecodes(3);
                    final Node node19 = head;
                    final Node node20 = next3;
                    BytecodeManager.incBytecodes(3);
                    Node node21;
                    if (node19 != node20) {
                        node21 = next3;
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        node21 = (node2 = this.head);
                        BytecodeManager.incBytecodes(4);
                    }
                    head = node21;
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(2);
                if (n == 0) {
                    break;
                }
                final Node node22 = node;
                BytecodeManager.incBytecodes(2);
                if (node22 == null) {
                    BytecodeManager.incBytecodes(5);
                    node = new Node(e, b);
                    BytecodeManager.incBytecodes(1);
                }
                final Node node23 = node;
                BytecodeManager.incBytecodes(4);
                final Node tryAppend = this.tryAppend(node23, b);
                BytecodeManager.incBytecodes(1);
                final Node node24 = tryAppend;
                BytecodeManager.incBytecodes(2);
                if (node24 == null) {
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    final int n3 = 1;
                    BytecodeManager.incBytecodes(3);
                    if (n != n3) {
                        final Node node25 = node;
                        final Node node26 = tryAppend;
                        final int n4 = 3;
                        BytecodeManager.incBytecodes(7);
                        boolean b5;
                        if (n == n4) {
                            b5 = true;
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            b5 = false;
                            BytecodeManager.incBytecodes(1);
                        }
                        BytecodeManager.incBytecodes(2);
                        final E awaitMatch = this.awaitMatch(node25, node26, e, b5, n2);
                        BytecodeManager.incBytecodes(1);
                        return awaitMatch;
                    }
                    break;
                }
            }
            BytecodeManager.incBytecodes(2);
            return e;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private Node tryAppend(Node node, final boolean b) {
        try {
            Node node2;
            Node tail = node2 = this.tail;
            BytecodeManager.incBytecodes(5);
            while (true) {
                final Node node3 = node2;
                BytecodeManager.incBytecodes(2);
                Label_0329: {
                    if (node3 == null) {
                        final Node node4 = node2 = this.head;
                        BytecodeManager.incBytecodes(5);
                        if (node4 == null) {
                            final Node node5 = null;
                            final Node node6 = node;
                            BytecodeManager.incBytecodes(4);
                            final boolean casHead = this.casHead(node5, node6);
                            BytecodeManager.incBytecodes(1);
                            if (casHead) {
                                final Node node7 = node;
                                BytecodeManager.incBytecodes(2);
                                return node7;
                            }
                            break Label_0329;
                        }
                    }
                    final Node node8 = node2;
                    BytecodeManager.incBytecodes(3);
                    final boolean cannotPrecede = node8.cannotPrecede(b);
                    BytecodeManager.incBytecodes(1);
                    if (cannotPrecede) {
                        final Node node9 = null;
                        BytecodeManager.incBytecodes(2);
                        return node9;
                    }
                    final Node next;
                    final Node node10 = next = node2.next;
                    BytecodeManager.incBytecodes(5);
                    if (node10 != null) {
                        final Node node11 = node2;
                        final Node node12 = tail;
                        BytecodeManager.incBytecodes(3);
                        Node node14 = null;
                        Label_0173: {
                            if (node11 != node12) {
                                final Node node13 = tail;
                                final Node tail2 = this.tail;
                                BytecodeManager.incBytecodes(6);
                                if (node13 != tail2) {
                                    node14 = (tail = tail2);
                                    BytecodeManager.incBytecodes(4);
                                    break Label_0173;
                                }
                            }
                            final Node node15 = node2;
                            final Node node16 = next;
                            BytecodeManager.incBytecodes(3);
                            if (node15 != node16) {
                                node14 = next;
                                BytecodeManager.incBytecodes(2);
                            }
                            else {
                                node14 = null;
                                BytecodeManager.incBytecodes(1);
                            }
                        }
                        node2 = node14;
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        final Node node17 = node2;
                        final Node node18 = null;
                        final Node node19 = node;
                        BytecodeManager.incBytecodes(4);
                        final boolean casNext = node17.casNext(node18, node19);
                        BytecodeManager.incBytecodes(1);
                        if (casNext) {
                            final Node node20 = node2;
                            final Node node21 = tail;
                            BytecodeManager.incBytecodes(3);
                            if (node20 != node21) {
                                while (true) {
                                    final Node tail3 = this.tail;
                                    final Node node22 = tail;
                                    BytecodeManager.incBytecodes(4);
                                    if (tail3 == node22) {
                                        final Node node23 = tail;
                                        final Node node24 = node;
                                        BytecodeManager.incBytecodes(4);
                                        final boolean casTail = this.casTail(node23, node24);
                                        BytecodeManager.incBytecodes(1);
                                        if (casTail) {
                                            break;
                                        }
                                    }
                                    final Node node25 = tail = this.tail;
                                    BytecodeManager.incBytecodes(5);
                                    if (node25 == null) {
                                        break;
                                    }
                                    final Node node26 = node = tail.next;
                                    BytecodeManager.incBytecodes(5);
                                    if (node26 == null) {
                                        break;
                                    }
                                    final Node node27 = node = node.next;
                                    BytecodeManager.incBytecodes(5);
                                    if (node27 == null) {
                                        break;
                                    }
                                    final Node node28 = node;
                                    final Node node29 = tail;
                                    BytecodeManager.incBytecodes(3);
                                    if (node28 == node29) {
                                        break;
                                    }
                                    BytecodeManager.incBytecodes(1);
                                }
                            }
                            final Node node30 = node2;
                            BytecodeManager.incBytecodes(2);
                            return node30;
                        }
                        node2 = node2.next;
                        BytecodeManager.incBytecodes(4);
                    }
                }
                BytecodeManager.incBytecodes(1);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private E awaitMatch(final Node node, final Node node2, final E e, final boolean b, long n) {
        try {
            BytecodeManager.incBytecodes(2);
            long n2;
            if (b) {
                BytecodeManager.incBytecodes(1);
                n2 = System.nanoTime() + n;
                BytecodeManager.incBytecodes(3);
            }
            else {
                n2 = 0L;
                BytecodeManager.incBytecodes(1);
            }
            final long n3 = n2;
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
            final Thread currentThread = Thread.currentThread();
            BytecodeManager.incBytecodes(1);
            int spins = -1;
            BytecodeManager.incBytecodes(2);
            ThreadLocalRandom current = null;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final Object item = node.item;
                BytecodeManager.incBytecodes(3);
                final Object o = item;
                BytecodeManager.incBytecodes(3);
                if (o != e) {
                    BytecodeManager.incBytecodes(2);
                    node.forgetContents();
                    final Object o2 = item;
                    BytecodeManager.incBytecodes(2);
                    final Object cast = cast(o2);
                    BytecodeManager.incBytecodes(1);
                    return (E)cast;
                }
                final Thread thread = currentThread;
                BytecodeManager.incBytecodes(2);
                final boolean interrupted = thread.isInterrupted();
                BytecodeManager.incBytecodes(1);
                Label_0202: {
                    if (!interrupted) {
                        BytecodeManager.incBytecodes(2);
                        if (!b) {
                            break Label_0202;
                        }
                        final long n4 = lcmp(n, 0L);
                        BytecodeManager.incBytecodes(4);
                        if (n4 > 0) {
                            break Label_0202;
                        }
                    }
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(1);
                    final boolean casItem = node.casItem(e, node);
                    BytecodeManager.incBytecodes(1);
                    if (casItem) {
                        BytecodeManager.incBytecodes(4);
                        this.unsplice(node2, node);
                        BytecodeManager.incBytecodes(2);
                        return e;
                    }
                }
                final int n5 = spins;
                BytecodeManager.incBytecodes(2);
                if (n5 < 0) {
                    final boolean isData = node.isData;
                    BytecodeManager.incBytecodes(4);
                    final int n6 = spins = spinsFor(node2, isData);
                    BytecodeManager.incBytecodes(3);
                    if (n6 > 0) {
                        BytecodeManager.incBytecodes(1);
                        current = ThreadLocalRandom.current();
                        BytecodeManager.incBytecodes(2);
                    }
                }
                else {
                    final int n7 = spins;
                    BytecodeManager.incBytecodes(2);
                    if (n7 > 0) {
                        --spins;
                        BytecodeManager.incBytecodes(1);
                        final ThreadLocalRandom threadLocalRandom = current;
                        final int n8 = 64;
                        BytecodeManager.incBytecodes(3);
                        final int nextInt = threadLocalRandom.nextInt(n8);
                        BytecodeManager.incBytecodes(1);
                        if (nextInt == 0) {
                            BytecodeManager.incBytecodes(1);
                            Thread.yield();
                            BytecodeManager.incBytecodes(1);
                        }
                    }
                    else {
                        final Thread waiter = node.waiter;
                        BytecodeManager.incBytecodes(3);
                        if (waiter == null) {
                            node.waiter = currentThread;
                            BytecodeManager.incBytecodes(4);
                        }
                        else {
                            BytecodeManager.incBytecodes(2);
                            if (b) {
                                final long n9 = n3;
                                BytecodeManager.incBytecodes(2);
                                n = n9 - System.nanoTime();
                                BytecodeManager.incBytecodes(2);
                                final long n10 = lcmp(n, 0L);
                                BytecodeManager.incBytecodes(4);
                                if (n10 > 0) {
                                    final long n11 = n;
                                    BytecodeManager.incBytecodes(3);
                                    LockSupport.parkNanos(this, n11);
                                    BytecodeManager.incBytecodes(1);
                                }
                            }
                            else {
                                BytecodeManager.incBytecodes(2);
                                LockSupport.park(this);
                            }
                        }
                    }
                }
                BytecodeManager.incBytecodes(1);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static int spinsFor(final Node node, final boolean b) {
        try {
            final boolean mp = LinkedTransferQueue.MP;
            BytecodeManager.incBytecodes(2);
            if (mp) {
                BytecodeManager.incBytecodes(2);
                if (node != null) {
                    final boolean isData = node.isData;
                    BytecodeManager.incBytecodes(4);
                    if (isData != b) {
                        final int n = 192;
                        BytecodeManager.incBytecodes(2);
                        return n;
                    }
                    BytecodeManager.incBytecodes(2);
                    final boolean matched = node.isMatched();
                    BytecodeManager.incBytecodes(1);
                    if (matched) {
                        final int n2 = 128;
                        BytecodeManager.incBytecodes(2);
                        return n2;
                    }
                    final Thread waiter = node.waiter;
                    BytecodeManager.incBytecodes(3);
                    if (waiter == null) {
                        final int n3 = 64;
                        BytecodeManager.incBytecodes(2);
                        return n3;
                    }
                }
            }
            final int n4 = 0;
            BytecodeManager.incBytecodes(2);
            return n4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final Node succ(final Node node) {
        try {
            final Node next = node.next;
            BytecodeManager.incBytecodes(3);
            final Node node2 = next;
            BytecodeManager.incBytecodes(3);
            Node head;
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
    
    private Node firstOfMode(final boolean b) {
        try {
            Node node = this.head;
            BytecodeManager.incBytecodes(3);
            while (true) {
                final Node node2 = node;
                BytecodeManager.incBytecodes(2);
                if (node2 == null) {
                    final Node node3 = null;
                    BytecodeManager.incBytecodes(2);
                    return node3;
                }
                final Node node4 = node;
                BytecodeManager.incBytecodes(2);
                final boolean matched = node4.isMatched();
                BytecodeManager.incBytecodes(1);
                if (!matched) {
                    final boolean isData = node.isData;
                    BytecodeManager.incBytecodes(4);
                    Node node5;
                    if (isData == b) {
                        node5 = node;
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        node5 = null;
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(1);
                    return node5;
                }
                final Node node6 = node;
                BytecodeManager.incBytecodes(3);
                node = this.succ(node6);
                BytecodeManager.incBytecodes(2);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final Node firstDataNode() {
        try {
            Node node = this.head;
            BytecodeManager.incBytecodes(3);
            while (true) {
                final Node node2 = node;
                BytecodeManager.incBytecodes(2);
                if (node2 == null) {
                    break;
                }
                final Object item = node.item;
                BytecodeManager.incBytecodes(3);
                final boolean isData = node.isData;
                BytecodeManager.incBytecodes(3);
                if (isData) {
                    final Object o = item;
                    BytecodeManager.incBytecodes(2);
                    if (o != null) {
                        final Object o2 = item;
                        final Node node3 = node;
                        BytecodeManager.incBytecodes(3);
                        if (o2 != node3) {
                            final Node node4 = node;
                            BytecodeManager.incBytecodes(2);
                            return node4;
                        }
                    }
                }
                else {
                    final Node node5 = (Node)item;
                    BytecodeManager.incBytecodes(2);
                    if (node5 == null) {
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                }
                final Node node6 = node;
                final Node node7 = node = node.next;
                BytecodeManager.incBytecodes(6);
                if (node6 == node7) {
                    node = this.head;
                    BytecodeManager.incBytecodes(3);
                }
                BytecodeManager.incBytecodes(1);
            }
            final Node node8 = null;
            BytecodeManager.incBytecodes(2);
            return node8;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private E firstDataItem() {
        try {
            Node node = this.head;
            BytecodeManager.incBytecodes(3);
            while (true) {
                final Node node2 = node;
                BytecodeManager.incBytecodes(2);
                if (node2 == null) {
                    final E e = null;
                    BytecodeManager.incBytecodes(2);
                    return e;
                }
                final Object item = node.item;
                BytecodeManager.incBytecodes(3);
                final boolean isData = node.isData;
                BytecodeManager.incBytecodes(3);
                if (isData) {
                    final Object o = item;
                    BytecodeManager.incBytecodes(2);
                    if (o != null) {
                        final Object o2 = item;
                        final Node node3 = node;
                        BytecodeManager.incBytecodes(3);
                        if (o2 != node3) {
                            final Node node4 = (Node)item;
                            BytecodeManager.incBytecodes(2);
                            final Object cast = cast(node4);
                            BytecodeManager.incBytecodes(1);
                            return (E)cast;
                        }
                    }
                }
                else {
                    final Node node5 = (Node)item;
                    BytecodeManager.incBytecodes(2);
                    if (node5 == null) {
                        final E e2 = null;
                        BytecodeManager.incBytecodes(2);
                        return e2;
                    }
                }
                final Node node6 = node;
                BytecodeManager.incBytecodes(3);
                node = this.succ(node6);
                BytecodeManager.incBytecodes(2);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private int countOfMode(final boolean b) {
        try {
            int n = 0;
            BytecodeManager.incBytecodes(2);
            Node node = this.head;
            BytecodeManager.incBytecodes(3);
            while (true) {
                final Node node2 = node;
                BytecodeManager.incBytecodes(2);
                if (node2 == null) {
                    break;
                }
                final Node node3 = node;
                BytecodeManager.incBytecodes(2);
                final boolean matched = node3.isMatched();
                BytecodeManager.incBytecodes(1);
                if (!matched) {
                    final boolean isData = node.isData;
                    BytecodeManager.incBytecodes(4);
                    if (isData != b) {
                        final int n2 = 0;
                        BytecodeManager.incBytecodes(2);
                        return n2;
                    }
                    final int n3 = ++n;
                    final int n4 = Integer.MAX_VALUE;
                    BytecodeManager.incBytecodes(4);
                    if (n3 == n4) {
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                }
                final Node next = node.next;
                BytecodeManager.incBytecodes(3);
                final Node node4 = next;
                final Node node5 = node;
                BytecodeManager.incBytecodes(3);
                if (node4 != node5) {
                    node = next;
                    BytecodeManager.incBytecodes(3);
                }
                else {
                    n = 0;
                    BytecodeManager.incBytecodes(2);
                    node = this.head;
                    BytecodeManager.incBytecodes(3);
                }
                BytecodeManager.incBytecodes(1);
            }
            final int n5 = n;
            BytecodeManager.incBytecodes(2);
            return n5;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public Spliterator<E> spliterator() {
        try {
            BytecodeManager.incBytecodes(4);
            final LTQSpliterator<E> ltqSpliterator = new LTQSpliterator<E>(this);
            BytecodeManager.incBytecodes(1);
            return ltqSpliterator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final void unsplice(final Node node, final Node node2) {
        try {
            BytecodeManager.incBytecodes(2);
            node2.forgetContents();
            BytecodeManager.incBytecodes(2);
            Label_0390: {
                if (node != null) {
                    BytecodeManager.incBytecodes(3);
                    if (node != node2) {
                        final Node next = node.next;
                        BytecodeManager.incBytecodes(4);
                        if (next == node2) {
                            final Node next2 = node2.next;
                            BytecodeManager.incBytecodes(3);
                            final Node node3 = next2;
                            BytecodeManager.incBytecodes(2);
                            if (node3 != null) {
                                final Node node4 = next2;
                                BytecodeManager.incBytecodes(3);
                                if (node4 == node2) {
                                    break Label_0390;
                                }
                                final Node node5 = next2;
                                BytecodeManager.incBytecodes(3);
                                BytecodeManager.incBytecodes(1);
                                final boolean casNext = node.casNext(node2, node5);
                                BytecodeManager.incBytecodes(1);
                                if (!casNext) {
                                    break Label_0390;
                                }
                                BytecodeManager.incBytecodes(2);
                                final boolean matched = node.isMatched();
                                BytecodeManager.incBytecodes(1);
                                if (!matched) {
                                    break Label_0390;
                                }
                            }
                            Block_11: {
                                Block_10: {
                                    while (true) {
                                        final Node head = this.head;
                                        BytecodeManager.incBytecodes(3);
                                        final Node node6 = head;
                                        BytecodeManager.incBytecodes(3);
                                        if (node6 == node) {
                                            break;
                                        }
                                        final Node node7 = head;
                                        BytecodeManager.incBytecodes(3);
                                        if (node7 == node2) {
                                            break;
                                        }
                                        final Node node8 = head;
                                        BytecodeManager.incBytecodes(2);
                                        if (node8 == null) {
                                            break;
                                        }
                                        final Node node9 = head;
                                        BytecodeManager.incBytecodes(2);
                                        final boolean matched2 = node9.isMatched();
                                        BytecodeManager.incBytecodes(1);
                                        if (!matched2) {
                                            break Block_10;
                                        }
                                        final Node next3 = head.next;
                                        BytecodeManager.incBytecodes(3);
                                        final Node node10 = next3;
                                        BytecodeManager.incBytecodes(2);
                                        if (node10 == null) {
                                            break Block_11;
                                        }
                                        final Node node11 = next3;
                                        final Node node12 = head;
                                        BytecodeManager.incBytecodes(3);
                                        if (node11 != node12) {
                                            final Node node13 = head;
                                            final Node node14 = next3;
                                            BytecodeManager.incBytecodes(4);
                                            final boolean casHead = this.casHead(node13, node14);
                                            BytecodeManager.incBytecodes(1);
                                            if (casHead) {
                                                final Node node15 = head;
                                                BytecodeManager.incBytecodes(2);
                                                node15.forgetNext();
                                            }
                                        }
                                        BytecodeManager.incBytecodes(1);
                                    }
                                    BytecodeManager.incBytecodes(1);
                                    return;
                                }
                                BytecodeManager.incBytecodes(1);
                                final Node next4 = node.next;
                                BytecodeManager.incBytecodes(4);
                                if (next4 == node) {
                                    break Label_0390;
                                }
                                final Node next5 = node2.next;
                                BytecodeManager.incBytecodes(4);
                                if (next5 == node2) {
                                    break Label_0390;
                                }
                                while (true) {
                                    final int sweepVotes = this.sweepVotes;
                                    BytecodeManager.incBytecodes(3);
                                    final int n = sweepVotes;
                                    final int n2 = 32;
                                    BytecodeManager.incBytecodes(3);
                                    if (n < n2) {
                                        final int n3 = sweepVotes;
                                        final int n4 = sweepVotes + 1;
                                        BytecodeManager.incBytecodes(6);
                                        final boolean casSweepVotes = this.casSweepVotes(n3, n4);
                                        BytecodeManager.incBytecodes(1);
                                        if (casSweepVotes) {
                                            BytecodeManager.incBytecodes(1);
                                            break Label_0390;
                                        }
                                    }
                                    else {
                                        final int n5 = sweepVotes;
                                        final int n6 = 0;
                                        BytecodeManager.incBytecodes(4);
                                        final boolean casSweepVotes2 = this.casSweepVotes(n5, n6);
                                        BytecodeManager.incBytecodes(1);
                                        if (casSweepVotes2) {
                                            BytecodeManager.incBytecodes(2);
                                            this.sweep();
                                            BytecodeManager.incBytecodes(1);
                                            break Label_0390;
                                        }
                                    }
                                    BytecodeManager.incBytecodes(1);
                                }
                            }
                            BytecodeManager.incBytecodes(1);
                            return;
                        }
                    }
                }
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void sweep() {
        try {
            Node node = this.head;
            BytecodeManager.incBytecodes(3);
            while (true) {
                final Node node2 = node;
                BytecodeManager.incBytecodes(2);
                if (node2 == null) {
                    break;
                }
                final Node next;
                final Node node3 = next = node.next;
                BytecodeManager.incBytecodes(5);
                if (node3 == null) {
                    break;
                }
                final Node node4 = next;
                BytecodeManager.incBytecodes(2);
                final boolean matched = node4.isMatched();
                BytecodeManager.incBytecodes(1);
                if (!matched) {
                    node = next;
                    BytecodeManager.incBytecodes(3);
                }
                else {
                    final Node next2;
                    final Node node5 = next2 = next.next;
                    BytecodeManager.incBytecodes(5);
                    if (node5 == null) {
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    final Node node6 = next;
                    final Node node7 = next2;
                    BytecodeManager.incBytecodes(3);
                    if (node6 == node7) {
                        node = this.head;
                        BytecodeManager.incBytecodes(4);
                    }
                    else {
                        final Node node8 = node;
                        final Node node9 = next;
                        final Node node10 = next2;
                        BytecodeManager.incBytecodes(4);
                        node8.casNext(node9, node10);
                        BytecodeManager.incBytecodes(2);
                    }
                }
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private boolean findAndRemove(final Object o) {
        try {
            BytecodeManager.incBytecodes(2);
            if (o != null) {
                Node node = null;
                Node node2 = this.head;
                BytecodeManager.incBytecodes(5);
                while (true) {
                    final Node node3 = node2;
                    BytecodeManager.incBytecodes(2);
                    if (node3 == null) {
                        break;
                    }
                    final Object item = node2.item;
                    BytecodeManager.incBytecodes(3);
                    final boolean isData = node2.isData;
                    BytecodeManager.incBytecodes(3);
                    if (isData) {
                        final Object o2 = item;
                        BytecodeManager.incBytecodes(2);
                        if (o2 != null) {
                            final Object o3 = item;
                            final Node node4 = node2;
                            BytecodeManager.incBytecodes(3);
                            if (o3 != node4) {
                                final Node obj = (Node)item;
                                BytecodeManager.incBytecodes(3);
                                final boolean equals = o.equals(obj);
                                BytecodeManager.incBytecodes(1);
                                if (equals) {
                                    final Node node5 = node2;
                                    BytecodeManager.incBytecodes(1);
                                    BytecodeManager.incBytecodes(1);
                                    final boolean tryMatchData = node5.tryMatchData();
                                    BytecodeManager.incBytecodes(1);
                                    if (tryMatchData) {
                                        final Node node6 = node;
                                        final Node node7 = node2;
                                        BytecodeManager.incBytecodes(4);
                                        this.unsplice(node6, node7);
                                        final boolean b = true;
                                        BytecodeManager.incBytecodes(2);
                                        return b;
                                    }
                                }
                            }
                        }
                    }
                    else {
                        final Node node8 = (Node)item;
                        BytecodeManager.incBytecodes(2);
                        if (node8 == null) {
                            BytecodeManager.incBytecodes(1);
                            break;
                        }
                    }
                    node = node2;
                    BytecodeManager.incBytecodes(2);
                    final Node node9 = node2 = node2.next;
                    final Node node10 = node;
                    BytecodeManager.incBytecodes(6);
                    if (node9 == node10) {
                        node = null;
                        BytecodeManager.incBytecodes(2);
                        node2 = this.head;
                        BytecodeManager.incBytecodes(3);
                    }
                    BytecodeManager.incBytecodes(1);
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
    
    public LinkedTransferQueue() {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public LinkedTransferQueue(final Collection<? extends E> collection) {
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
    
    @Override
    public void put(final E e) {
        try {
            final boolean b = true;
            final int n = 1;
            final long n2 = 0L;
            BytecodeManager.incBytecodes(6);
            this.xfer(e, b, n, n2);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean offer(final E e, final long n, final TimeUnit timeUnit) {
        try {
            final boolean b = true;
            final int n2 = 1;
            final long n3 = 0L;
            BytecodeManager.incBytecodes(6);
            this.xfer(e, b, n2, n3);
            BytecodeManager.incBytecodes(1);
            final boolean b2 = true;
            BytecodeManager.incBytecodes(2);
            return b2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean offer(final E e) {
        try {
            final boolean b = true;
            final int n = 1;
            final long n2 = 0L;
            BytecodeManager.incBytecodes(6);
            this.xfer(e, b, n, n2);
            BytecodeManager.incBytecodes(1);
            final boolean b2 = true;
            BytecodeManager.incBytecodes(2);
            return b2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean add(final E e) {
        try {
            final boolean b = true;
            final int n = 1;
            final long n2 = 0L;
            BytecodeManager.incBytecodes(6);
            this.xfer(e, b, n, n2);
            BytecodeManager.incBytecodes(1);
            final boolean b2 = true;
            BytecodeManager.incBytecodes(2);
            return b2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean tryTransfer(final E e) {
        try {
            final boolean b = true;
            final int n = 0;
            final long n2 = 0L;
            BytecodeManager.incBytecodes(6);
            final Object xfer = this.xfer(e, b, n, n2);
            BytecodeManager.incBytecodes(1);
            boolean b2;
            if (xfer == null) {
                b2 = true;
                BytecodeManager.incBytecodes(2);
            }
            else {
                b2 = false;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return b2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void transfer(final E e) throws InterruptedException {
        try {
            final boolean b = true;
            final int n = 2;
            final long n2 = 0L;
            BytecodeManager.incBytecodes(6);
            final Object xfer = this.xfer(e, b, n, n2);
            BytecodeManager.incBytecodes(1);
            if (xfer != null) {
                BytecodeManager.incBytecodes(1);
                Thread.interrupted();
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(3);
                final InterruptedException ex = new InterruptedException();
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
    public boolean tryTransfer(final E e, final long duration, final TimeUnit timeUnit) throws InterruptedException {
        try {
            final boolean b = true;
            final int n = 3;
            BytecodeManager.incBytecodes(7);
            final long nanos = timeUnit.toNanos(duration);
            BytecodeManager.incBytecodes(1);
            final Object xfer = this.xfer(e, b, n, nanos);
            BytecodeManager.incBytecodes(1);
            if (xfer == null) {
                final boolean b2 = true;
                BytecodeManager.incBytecodes(2);
                return b2;
            }
            BytecodeManager.incBytecodes(1);
            final boolean interrupted = Thread.interrupted();
            BytecodeManager.incBytecodes(1);
            if (!interrupted) {
                final boolean b3 = false;
                BytecodeManager.incBytecodes(2);
                return b3;
            }
            BytecodeManager.incBytecodes(3);
            final InterruptedException ex = new InterruptedException();
            BytecodeManager.incBytecodes(1);
            throw ex;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public E take() throws InterruptedException {
        try {
            final E e = null;
            final boolean b = false;
            final int n = 2;
            final long n2 = 0L;
            BytecodeManager.incBytecodes(6);
            final Object xfer = this.xfer(e, b, n, n2);
            BytecodeManager.incBytecodes(1);
            final Object o = xfer;
            BytecodeManager.incBytecodes(2);
            if (o != null) {
                final Object o2 = xfer;
                BytecodeManager.incBytecodes(2);
                return (E)o2;
            }
            BytecodeManager.incBytecodes(1);
            Thread.interrupted();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            final InterruptedException ex = new InterruptedException();
            BytecodeManager.incBytecodes(1);
            throw ex;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public E poll(final long duration, final TimeUnit timeUnit) throws InterruptedException {
        try {
            final E e = null;
            final boolean b = false;
            final int n = 3;
            BytecodeManager.incBytecodes(7);
            final long nanos = timeUnit.toNanos(duration);
            BytecodeManager.incBytecodes(1);
            final Object xfer = this.xfer(e, b, n, nanos);
            BytecodeManager.incBytecodes(1);
            final Object o = xfer;
            BytecodeManager.incBytecodes(2);
            if (o == null) {
                BytecodeManager.incBytecodes(1);
                final boolean interrupted = Thread.interrupted();
                BytecodeManager.incBytecodes(1);
                if (interrupted) {
                    BytecodeManager.incBytecodes(3);
                    final InterruptedException ex = new InterruptedException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
            }
            final Object o2 = xfer;
            BytecodeManager.incBytecodes(2);
            return (E)o2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public E poll() {
        try {
            final E e = null;
            final boolean b = false;
            final int n = 0;
            final long n2 = 0L;
            BytecodeManager.incBytecodes(6);
            final E xfer = this.xfer(e, b, n, n2);
            BytecodeManager.incBytecodes(1);
            return xfer;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public int drainTo(final Collection<? super E> collection) {
        try {
            BytecodeManager.incBytecodes(2);
            if (collection == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(3);
            if (collection == this) {
                BytecodeManager.incBytecodes(3);
                final IllegalArgumentException ex2 = new IllegalArgumentException();
                BytecodeManager.incBytecodes(1);
                throw ex2;
            }
            int n = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                BytecodeManager.incBytecodes(2);
                final Object poll = this.poll();
                BytecodeManager.incBytecodes(3);
                if (poll == null) {
                    break;
                }
                final Object o = poll;
                BytecodeManager.incBytecodes(3);
                collection.add((Object)o);
                BytecodeManager.incBytecodes(1);
                ++n;
                BytecodeManager.incBytecodes(2);
            }
            final int n2 = n;
            BytecodeManager.incBytecodes(2);
            return n2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public int drainTo(final Collection<? super E> collection, final int n) {
        try {
            BytecodeManager.incBytecodes(2);
            if (collection == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(3);
            if (collection == this) {
                BytecodeManager.incBytecodes(3);
                final IllegalArgumentException ex2 = new IllegalArgumentException();
                BytecodeManager.incBytecodes(1);
                throw ex2;
            }
            int n2 = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n3 = n2;
                BytecodeManager.incBytecodes(3);
                if (n3 >= n) {
                    break;
                }
                BytecodeManager.incBytecodes(2);
                final Object poll = this.poll();
                BytecodeManager.incBytecodes(3);
                if (poll == null) {
                    break;
                }
                final Object o = poll;
                BytecodeManager.incBytecodes(3);
                collection.add((Object)o);
                BytecodeManager.incBytecodes(1);
                ++n2;
                BytecodeManager.incBytecodes(2);
            }
            final int n4 = n2;
            BytecodeManager.incBytecodes(2);
            return n4;
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
    
    @Override
    public E peek() {
        try {
            BytecodeManager.incBytecodes(2);
            final E firstDataItem = this.firstDataItem();
            BytecodeManager.incBytecodes(1);
            return firstDataItem;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean isEmpty() {
        try {
            Node node = this.head;
            BytecodeManager.incBytecodes(3);
            while (true) {
                final Node node2 = node;
                BytecodeManager.incBytecodes(2);
                if (node2 == null) {
                    final boolean b = true;
                    BytecodeManager.incBytecodes(2);
                    return b;
                }
                final Node node3 = node;
                BytecodeManager.incBytecodes(2);
                final boolean matched = node3.isMatched();
                BytecodeManager.incBytecodes(1);
                if (!matched) {
                    final boolean isData = node.isData;
                    BytecodeManager.incBytecodes(3);
                    boolean b2;
                    if (!isData) {
                        b2 = true;
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        b2 = false;
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(1);
                    return b2;
                }
                final Node node4 = node;
                BytecodeManager.incBytecodes(3);
                node = this.succ(node4);
                BytecodeManager.incBytecodes(2);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean hasWaitingConsumer() {
        try {
            final boolean b = false;
            BytecodeManager.incBytecodes(3);
            final Node firstOfMode = this.firstOfMode(b);
            BytecodeManager.incBytecodes(1);
            boolean b2;
            if (firstOfMode != null) {
                b2 = true;
                BytecodeManager.incBytecodes(2);
            }
            else {
                b2 = false;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return b2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public int size() {
        try {
            final boolean b = true;
            BytecodeManager.incBytecodes(3);
            final int countOfMode = this.countOfMode(b);
            BytecodeManager.incBytecodes(1);
            return countOfMode;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public int getWaitingConsumerCount() {
        try {
            final boolean b = false;
            BytecodeManager.incBytecodes(3);
            final int countOfMode = this.countOfMode(b);
            BytecodeManager.incBytecodes(1);
            return countOfMode;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean remove(final Object o) {
        try {
            BytecodeManager.incBytecodes(3);
            final boolean andRemove = this.findAndRemove(o);
            BytecodeManager.incBytecodes(1);
            return andRemove;
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
            Node node = this.head;
            BytecodeManager.incBytecodes(3);
            while (true) {
                final Node node2 = node;
                BytecodeManager.incBytecodes(2);
                if (node2 == null) {
                    break;
                }
                final Object item = node.item;
                BytecodeManager.incBytecodes(3);
                final boolean isData = node.isData;
                BytecodeManager.incBytecodes(3);
                if (isData) {
                    final Object o2 = item;
                    BytecodeManager.incBytecodes(2);
                    if (o2 != null) {
                        final Object o3 = item;
                        final Node node3 = node;
                        BytecodeManager.incBytecodes(3);
                        if (o3 != node3) {
                            final Node obj = (Node)item;
                            BytecodeManager.incBytecodes(3);
                            final boolean equals = o.equals(obj);
                            BytecodeManager.incBytecodes(1);
                            if (equals) {
                                final boolean b2 = true;
                                BytecodeManager.incBytecodes(2);
                                return b2;
                            }
                        }
                    }
                }
                else {
                    final Node node4 = (Node)item;
                    BytecodeManager.incBytecodes(2);
                    if (node4 == null) {
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                }
                final Node node5 = node;
                BytecodeManager.incBytecodes(3);
                node = this.succ(node5);
                BytecodeManager.incBytecodes(2);
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
    public int remainingCapacity() {
        try {
            final int n = Integer.MAX_VALUE;
            BytecodeManager.incBytecodes(2);
            return n;
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
                final E next = iterator3.next();
                BytecodeManager.incBytecodes(1);
                final E obj = next;
                BytecodeManager.incBytecodes(3);
                objectOutputStream.writeObject(obj);
                BytecodeManager.incBytecodes(1);
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
            while (true) {
                BytecodeManager.incBytecodes(2);
                final Object object = objectInputStream.readObject();
                BytecodeManager.incBytecodes(1);
                final Object o = object;
                BytecodeManager.incBytecodes(2);
                if (o == null) {
                    break;
                }
                final Object o2 = object;
                BytecodeManager.incBytecodes(3);
                this.offer((E)o2);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     2: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     5: invokestatic    java/lang/Runtime.getRuntime:()Ljava/lang/Runtime;
        //     8: ldc             1
        //    10: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    13: invokevirtual   java/lang/Runtime.availableProcessors:()I
        //    16: iconst_1       
        //    17: ldc             2
        //    19: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    22: if_icmple       34
        //    25: iconst_1       
        //    26: ldc             2
        //    28: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    31: goto            40
        //    34: iconst_0       
        //    35: ldc             1
        //    37: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    40: putstatic       instrumented/java/util/concurrent/LinkedTransferQueue.MP:Z
        //    43: ldc             1
        //    45: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    48: ldc             1
        //    50: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    53: invokestatic    sun/misc/Unsafe.getUnsafe:()Lsun/misc/Unsafe;
        //    56: putstatic       instrumented/java/util/concurrent/LinkedTransferQueue.UNSAFE:Lsun/misc/Unsafe;
        //    59: ldc             1
        //    61: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    64: ldc             Linstrumented/java/util/concurrent/LinkedTransferQueue;.class
        //    66: astore_0       
        //    67: ldc             2
        //    69: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    72: getstatic       instrumented/java/util/concurrent/LinkedTransferQueue.UNSAFE:Lsun/misc/Unsafe;
        //    75: aload_0        
        //    76: ldc_w           "head"
        //    79: ldc             3
        //    81: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    84: ldc             1
        //    86: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    89: invokevirtual   java/lang/Class.getDeclaredField:(Ljava/lang/String;)Ljava/lang/reflect/Field;
        //    92: ldc             1
        //    94: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    97: invokevirtual   sun/misc/Unsafe.objectFieldOffset:(Ljava/lang/reflect/Field;)J
        //   100: putstatic       instrumented/java/util/concurrent/LinkedTransferQueue.headOffset:J
        //   103: ldc             1
        //   105: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   108: getstatic       instrumented/java/util/concurrent/LinkedTransferQueue.UNSAFE:Lsun/misc/Unsafe;
        //   111: aload_0        
        //   112: ldc_w           "tail"
        //   115: ldc             3
        //   117: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   120: ldc             1
        //   122: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   125: invokevirtual   java/lang/Class.getDeclaredField:(Ljava/lang/String;)Ljava/lang/reflect/Field;
        //   128: ldc             1
        //   130: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   133: invokevirtual   sun/misc/Unsafe.objectFieldOffset:(Ljava/lang/reflect/Field;)J
        //   136: putstatic       instrumented/java/util/concurrent/LinkedTransferQueue.tailOffset:J
        //   139: ldc             1
        //   141: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   144: getstatic       instrumented/java/util/concurrent/LinkedTransferQueue.UNSAFE:Lsun/misc/Unsafe;
        //   147: aload_0        
        //   148: ldc_w           "sweepVotes"
        //   151: ldc             3
        //   153: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   156: ldc             1
        //   158: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   161: invokevirtual   java/lang/Class.getDeclaredField:(Ljava/lang/String;)Ljava/lang/reflect/Field;
        //   164: ldc             1
        //   166: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   169: invokevirtual   sun/misc/Unsafe.objectFieldOffset:(Ljava/lang/reflect/Field;)J
        //   172: putstatic       instrumented/java/util/concurrent/LinkedTransferQueue.sweepVotesOffset:J
        //   175: ldc             1
        //   177: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   180: ldc             1
        //   182: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   185: goto            214
        //   188: astore_0       
        //   189: ldc_w           501
        //   192: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   195: new             Ljava/lang/Error;
        //   198: dup            
        //   199: aload_0        
        //   200: ldc             4
        //   202: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   205: invokespecial   java/lang/Error.<init>:(Ljava/lang/Throwable;)V
        //   208: ldc             1
        //   210: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   213: athrow         
        //   214: ldc             1
        //   216: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   219: return         
        //   220: athrow         
        //   221: athrow         
        //    StackMapTable: 00 06 22 45 01 F7 00 93 07 01 51 19 FF 00 05 00 00 00 01 07 00 46 FF 00 00 00 00 00 01 07 01 4F
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  48     221    221    222    Ljava/lang/VirtualMachineError;
        //  48     180    188    214    Ljava/lang/Exception;
        //  0      220    220    221    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0214:
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
    
    static final class Node
    {
        final boolean isData;
        volatile Object item;
        volatile Node next;
        volatile Thread waiter;
        private static final long serialVersionUID = -3375979862319811754L;
        private static final Unsafe UNSAFE;
        private static final long itemOffset;
        private static final long nextOffset;
        private static final long waiterOffset;
        
        final boolean casNext(final Node expected, final Node x) {
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
        
        final boolean casItem(final Object expected, final Object x) {
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
        
        Node(final Object x, final boolean isData) {
            try {
                BytecodeManager.incBytecodes(2);
                final Unsafe unsafe = Node.UNSAFE;
                final long itemOffset = Node.itemOffset;
                BytecodeManager.incBytecodes(5);
                unsafe.putObject(this, itemOffset, x);
                this.isData = isData;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        final void forgetNext() {
            try {
                final Unsafe unsafe = Node.UNSAFE;
                final long nextOffset = Node.nextOffset;
                BytecodeManager.incBytecodes(5);
                unsafe.putObject(this, nextOffset, this);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        final void forgetContents() {
            try {
                final Unsafe unsafe = Node.UNSAFE;
                final long itemOffset = Node.itemOffset;
                BytecodeManager.incBytecodes(5);
                unsafe.putObject(this, itemOffset, this);
                final Unsafe unsafe2 = Node.UNSAFE;
                final long waiterOffset = Node.waiterOffset;
                final Object x = null;
                BytecodeManager.incBytecodes(5);
                unsafe2.putObject(this, waiterOffset, x);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        final boolean isMatched() {
            try {
                final Object item = this.item;
                BytecodeManager.incBytecodes(3);
                final Object o = item;
                BytecodeManager.incBytecodes(3);
                boolean b2 = false;
                Label_0071: {
                    if (o != this) {
                        final Object o2 = item;
                        BytecodeManager.incBytecodes(2);
                        boolean b;
                        if (o2 == null) {
                            b = true;
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            b = false;
                            BytecodeManager.incBytecodes(1);
                        }
                        final boolean isData = this.isData;
                        BytecodeManager.incBytecodes(3);
                        if (b != isData) {
                            b2 = false;
                            BytecodeManager.incBytecodes(1);
                            break Label_0071;
                        }
                    }
                    b2 = true;
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(1);
                return b2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        final boolean isUnmatchedRequest() {
            try {
                final boolean isData = this.isData;
                BytecodeManager.incBytecodes(3);
                boolean b = false;
                Label_0039: {
                    if (!isData) {
                        final Object item = this.item;
                        BytecodeManager.incBytecodes(3);
                        if (item == null) {
                            b = true;
                            BytecodeManager.incBytecodes(2);
                            break Label_0039;
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
        
        final boolean cannotPrecede(final boolean b) {
            try {
                final boolean isData = this.isData;
                BytecodeManager.incBytecodes(3);
                final boolean b2 = isData;
                BytecodeManager.incBytecodes(3);
                boolean b5 = false;
                Label_0083: {
                    if (b2 != b) {
                        final Object item = this.item;
                        BytecodeManager.incBytecodes(6);
                        if (item != this) {
                            final Node node = (Node)item;
                            BytecodeManager.incBytecodes(2);
                            boolean b3;
                            if (node != null) {
                                b3 = true;
                                BytecodeManager.incBytecodes(2);
                            }
                            else {
                                b3 = false;
                                BytecodeManager.incBytecodes(1);
                            }
                            final boolean b4 = isData;
                            BytecodeManager.incBytecodes(2);
                            if (b3 == b4) {
                                b5 = true;
                                BytecodeManager.incBytecodes(2);
                                break Label_0083;
                            }
                        }
                    }
                    b5 = false;
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
                return b5;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        final boolean tryMatchData() {
            try {
                final Object item = this.item;
                BytecodeManager.incBytecodes(3);
                final Object o = item;
                BytecodeManager.incBytecodes(2);
                if (o != null) {
                    final Object o2 = item;
                    BytecodeManager.incBytecodes(3);
                    if (o2 != this) {
                        final Object o3 = item;
                        final Object o4 = null;
                        BytecodeManager.incBytecodes(4);
                        final boolean casItem = this.casItem(o3, o4);
                        BytecodeManager.incBytecodes(1);
                        if (casItem) {
                            final Thread waiter = this.waiter;
                            BytecodeManager.incBytecodes(3);
                            LockSupport.unpark(waiter);
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
                        final Unsafe unsafe3 = Node.UNSAFE;
                        final Class<Node> clazz4 = clazz;
                        final String name3 = "waiter";
                        BytecodeManager.incBytecodes(3);
                        BytecodeManager.incBytecodes(1);
                        final Field declaredField3 = clazz4.getDeclaredField(name3);
                        BytecodeManager.incBytecodes(1);
                        waiterOffset = unsafe3.objectFieldOffset(declaredField3);
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
    
    final class Itr implements Iterator<E>
    {
        private Node nextNode;
        private E nextItem;
        private Node lastRet;
        private Node lastPred;
        
        private void advance(final Node lastRet) {
            try {
                final Node lastRet2;
                final Node node = lastRet2 = this.lastRet;
                BytecodeManager.incBytecodes(5);
                Label_0187: {
                    if (node != null) {
                        final Node node2 = lastRet2;
                        BytecodeManager.incBytecodes(2);
                        final boolean matched = node2.isMatched();
                        BytecodeManager.incBytecodes(1);
                        if (!matched) {
                            this.lastPred = lastRet2;
                            BytecodeManager.incBytecodes(4);
                            break Label_0187;
                        }
                    }
                    final Node lastPred;
                    final Node node3 = lastPred = this.lastPred;
                    BytecodeManager.incBytecodes(5);
                    if (node3 != null) {
                        final Node node4 = lastPred;
                        BytecodeManager.incBytecodes(2);
                        final boolean matched2 = node4.isMatched();
                        BytecodeManager.incBytecodes(1);
                        if (!matched2) {
                            while (true) {
                                final Node next;
                                final Node node5 = next = lastPred.next;
                                BytecodeManager.incBytecodes(5);
                                if (node5 == null) {
                                    break Label_0187;
                                }
                                final Node node6 = next;
                                final Node node7 = lastPred;
                                BytecodeManager.incBytecodes(3);
                                if (node6 == node7) {
                                    break Label_0187;
                                }
                                final Node node8 = next;
                                BytecodeManager.incBytecodes(1);
                                BytecodeManager.incBytecodes(1);
                                final boolean matched3 = node8.isMatched();
                                BytecodeManager.incBytecodes(1);
                                if (!matched3) {
                                    break Label_0187;
                                }
                                final Node next2;
                                final Node node9 = next2 = next.next;
                                BytecodeManager.incBytecodes(5);
                                if (node9 == null) {
                                    break Label_0187;
                                }
                                final Node node10 = next2;
                                final Node node11 = next;
                                BytecodeManager.incBytecodes(3);
                                if (node10 == node11) {
                                    break Label_0187;
                                }
                                final Node node12 = lastPred;
                                final Node node13 = next;
                                final Node node14 = next2;
                                BytecodeManager.incBytecodes(4);
                                node12.casNext(node13, node14);
                                BytecodeManager.incBytecodes(2);
                            }
                        }
                    }
                    this.lastPred = null;
                    BytecodeManager.incBytecodes(4);
                }
                this.lastRet = lastRet;
                BytecodeManager.incBytecodes(3);
                Node node15 = lastRet;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final Node node16 = node15;
                    BytecodeManager.incBytecodes(2);
                    Node node17;
                    if (node16 == null) {
                        node17 = LinkedTransferQueue.this.head;
                        BytecodeManager.incBytecodes(4);
                    }
                    else {
                        node17 = node15.next;
                        BytecodeManager.incBytecodes(2);
                    }
                    final Node nextNode = node17;
                    BytecodeManager.incBytecodes(1);
                    final Node node18 = nextNode;
                    BytecodeManager.incBytecodes(2);
                    if (node18 == null) {
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    final Node node19 = nextNode;
                    final Node node20 = node15;
                    BytecodeManager.incBytecodes(3);
                    if (node19 == node20) {
                        node15 = null;
                        BytecodeManager.incBytecodes(2);
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        final Object item = nextNode.item;
                        BytecodeManager.incBytecodes(3);
                        final boolean isData = nextNode.isData;
                        BytecodeManager.incBytecodes(3);
                        if (isData) {
                            final Object o = item;
                            BytecodeManager.incBytecodes(2);
                            if (o != null) {
                                final Object o2 = item;
                                final Node node21 = nextNode;
                                BytecodeManager.incBytecodes(3);
                                if (o2 != node21) {
                                    final Node node22 = (Node)item;
                                    BytecodeManager.incBytecodes(3);
                                    this.nextItem = (E)LinkedTransferQueue.cast(node22);
                                    BytecodeManager.incBytecodes(1);
                                    this.nextNode = nextNode;
                                    BytecodeManager.incBytecodes(3);
                                    BytecodeManager.incBytecodes(1);
                                    return;
                                }
                            }
                        }
                        else {
                            final Node node23 = (Node)item;
                            BytecodeManager.incBytecodes(2);
                            if (node23 == null) {
                                BytecodeManager.incBytecodes(1);
                                break;
                            }
                        }
                        final Node node24 = node15;
                        BytecodeManager.incBytecodes(2);
                        if (node24 == null) {
                            node15 = nextNode;
                            BytecodeManager.incBytecodes(3);
                        }
                        else {
                            final Node next3;
                            final Node node25 = next3 = nextNode.next;
                            BytecodeManager.incBytecodes(5);
                            if (node25 == null) {
                                BytecodeManager.incBytecodes(1);
                                break;
                            }
                            final Node node26 = nextNode;
                            final Node node27 = next3;
                            BytecodeManager.incBytecodes(3);
                            if (node26 == node27) {
                                node15 = null;
                                BytecodeManager.incBytecodes(3);
                            }
                            else {
                                final Node node28 = node15;
                                final Node node29 = nextNode;
                                final Node node30 = next3;
                                BytecodeManager.incBytecodes(4);
                                node28.casNext(node29, node30);
                                BytecodeManager.incBytecodes(1);
                            }
                        }
                        BytecodeManager.incBytecodes(1);
                    }
                }
                this.nextNode = null;
                BytecodeManager.incBytecodes(3);
                this.nextItem = null;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        Itr() {
            try {
                BytecodeManager.incBytecodes(5);
                final Node node = null;
                BytecodeManager.incBytecodes(3);
                this.advance(node);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final boolean hasNext() {
            try {
                final Node nextNode = this.nextNode;
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
        public final E next() {
            try {
                final Node nextNode = this.nextNode;
                BytecodeManager.incBytecodes(3);
                final Node node = nextNode;
                BytecodeManager.incBytecodes(2);
                if (node == null) {
                    BytecodeManager.incBytecodes(3);
                    final NoSuchElementException ex = new NoSuchElementException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final E nextItem = this.nextItem;
                BytecodeManager.incBytecodes(3);
                final Node node2 = nextNode;
                BytecodeManager.incBytecodes(3);
                this.advance(node2);
                final E e = nextItem;
                BytecodeManager.incBytecodes(2);
                return e;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final void remove() {
            try {
                final Node lastRet = this.lastRet;
                BytecodeManager.incBytecodes(3);
                final Node node = lastRet;
                BytecodeManager.incBytecodes(2);
                if (node == null) {
                    BytecodeManager.incBytecodes(3);
                    final IllegalStateException ex = new IllegalStateException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                this.lastRet = null;
                BytecodeManager.incBytecodes(3);
                final Node node2 = lastRet;
                BytecodeManager.incBytecodes(2);
                final boolean tryMatchData = node2.tryMatchData();
                BytecodeManager.incBytecodes(1);
                if (tryMatchData) {
                    final LinkedTransferQueue this$0 = LinkedTransferQueue.this;
                    final Node lastPred = this.lastPred;
                    final Node node3 = lastRet;
                    BytecodeManager.incBytecodes(6);
                    this$0.unsplice(lastPred, node3);
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class LTQSpliterator<E> implements Spliterator<E>
    {
        static final int MAX_BATCH = 33554432;
        final LinkedTransferQueue<E> queue;
        Node current;
        int batch;
        boolean exhausted;
        
        LTQSpliterator(final LinkedTransferQueue<E> queue) {
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
                final LinkedTransferQueue<E> queue = this.queue;
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
                Label_0337: {
                    if (!exhausted) {
                        Node node2;
                        final Node node = node2 = this.current;
                        BytecodeManager.incBytecodes(5);
                        if (node == null) {
                            final LinkedTransferQueue<E> linkedTransferQueue = queue;
                            BytecodeManager.incBytecodes(1);
                            BytecodeManager.incBytecodes(1);
                            final Node node3 = node2 = linkedTransferQueue.firstDataNode();
                            BytecodeManager.incBytecodes(3);
                            if (node3 == null) {
                                break Label_0337;
                            }
                        }
                        final Node next = node2.next;
                        BytecodeManager.incBytecodes(3);
                        if (next != null) {
                            final Object[] array = new Object[n5];
                            BytecodeManager.incBytecodes(2);
                            int batch2 = 0;
                            BytecodeManager.incBytecodes(2);
                            boolean isData;
                            do {
                                final Object item = node2.item;
                                BytecodeManager.incBytecodes(3);
                                final Object o = item;
                                final Node node4 = node2;
                                BytecodeManager.incBytecodes(3);
                                if (o != node4) {
                                    final Object[] array2 = array;
                                    final int n6 = batch2;
                                    final Node node5 = (Node)item;
                                    array2[n6] = node5;
                                    BytecodeManager.incBytecodes(6);
                                    if (node5 != null) {
                                        ++batch2;
                                        BytecodeManager.incBytecodes(1);
                                    }
                                }
                                final Node node6 = node2;
                                final Node node7 = node2 = node2.next;
                                BytecodeManager.incBytecodes(6);
                                if (node6 == node7) {
                                    final LinkedTransferQueue<E> linkedTransferQueue2 = queue;
                                    BytecodeManager.incBytecodes(2);
                                    node2 = linkedTransferQueue2.firstDataNode();
                                    BytecodeManager.incBytecodes(1);
                                }
                                final Node node8 = node2;
                                BytecodeManager.incBytecodes(2);
                                if (node8 == null) {
                                    break;
                                }
                                final int n7 = batch2;
                                final int n8 = n5;
                                BytecodeManager.incBytecodes(3);
                                if (n7 >= n8) {
                                    break;
                                }
                                isData = node2.isData;
                                BytecodeManager.incBytecodes(3);
                            } while (isData);
                            final Node current = node2;
                            this.current = current;
                            BytecodeManager.incBytecodes(5);
                            if (current == null) {
                                this.exhausted = true;
                                BytecodeManager.incBytecodes(3);
                            }
                            final int n9 = batch2;
                            BytecodeManager.incBytecodes(2);
                            if (n9 > 0) {
                                this.batch = batch2;
                                BytecodeManager.incBytecodes(3);
                                final Object[] array3 = array;
                                final int n10 = 0;
                                final int n11 = batch2;
                                final int n12 = 4368;
                                BytecodeManager.incBytecodes(4);
                                BytecodeManager.incBytecodes(1);
                                final Spliterator<Object> spliterator = (Spliterator<Object>)Spliterators.spliterator(array3, n10, n11, n12);
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
                final LinkedTransferQueue<E> queue = this.queue;
                BytecodeManager.incBytecodes(3);
                final boolean exhausted = this.exhausted;
                BytecodeManager.incBytecodes(3);
                Label_0193: {
                    if (!exhausted) {
                        Node node2;
                        final Node node = node2 = this.current;
                        BytecodeManager.incBytecodes(5);
                        if (node == null) {
                            final LinkedTransferQueue<E> linkedTransferQueue = queue;
                            BytecodeManager.incBytecodes(1);
                            BytecodeManager.incBytecodes(1);
                            final Node node3 = node2 = linkedTransferQueue.firstDataNode();
                            BytecodeManager.incBytecodes(3);
                            if (node3 == null) {
                                break Label_0193;
                            }
                        }
                        this.exhausted = true;
                        BytecodeManager.incBytecodes(3);
                        boolean isData;
                        do {
                            final Object item = node2.item;
                            BytecodeManager.incBytecodes(3);
                            final Object o = item;
                            BytecodeManager.incBytecodes(2);
                            if (o != null) {
                                final Object o2 = item;
                                final Node node4 = node2;
                                BytecodeManager.incBytecodes(3);
                                if (o2 != node4) {
                                    final Node node5 = (Node)item;
                                    BytecodeManager.incBytecodes(3);
                                    consumer.accept((Object)node5);
                                }
                            }
                            final Node node6 = node2;
                            final Node node7 = node2 = node2.next;
                            BytecodeManager.incBytecodes(6);
                            if (node6 == node7) {
                                final LinkedTransferQueue<E> linkedTransferQueue2 = queue;
                                BytecodeManager.incBytecodes(2);
                                node2 = linkedTransferQueue2.firstDataNode();
                                BytecodeManager.incBytecodes(1);
                            }
                            final Node node8 = node2;
                            BytecodeManager.incBytecodes(2);
                            if (node8 == null) {
                                break;
                            }
                            isData = node2.isData;
                            BytecodeManager.incBytecodes(3);
                        } while (isData);
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
                final LinkedTransferQueue<E> queue = this.queue;
                BytecodeManager.incBytecodes(3);
                final boolean exhausted = this.exhausted;
                BytecodeManager.incBytecodes(3);
                Label_0226: {
                    if (!exhausted) {
                        Node node2;
                        final Node node = node2 = this.current;
                        BytecodeManager.incBytecodes(5);
                        if (node == null) {
                            final LinkedTransferQueue<E> linkedTransferQueue = queue;
                            BytecodeManager.incBytecodes(1);
                            BytecodeManager.incBytecodes(1);
                            final Node node3 = node2 = linkedTransferQueue.firstDataNode();
                            BytecodeManager.incBytecodes(3);
                            if (node3 == null) {
                                break Label_0226;
                            }
                        }
                        boolean isData;
                        Object item;
                        do {
                            final Object o = item = node2.item;
                            final Node node4 = node2;
                            BytecodeManager.incBytecodes(6);
                            if (o == node4) {
                                item = null;
                                BytecodeManager.incBytecodes(2);
                            }
                            final Node node5 = node2;
                            final Node node6 = node2 = node2.next;
                            BytecodeManager.incBytecodes(6);
                            if (node5 == node6) {
                                final LinkedTransferQueue<E> linkedTransferQueue2 = queue;
                                BytecodeManager.incBytecodes(2);
                                node2 = linkedTransferQueue2.firstDataNode();
                                BytecodeManager.incBytecodes(1);
                            }
                            final Object o2 = item;
                            BytecodeManager.incBytecodes(2);
                            if (o2 != null) {
                                break;
                            }
                            final Node node7 = node2;
                            BytecodeManager.incBytecodes(2);
                            if (node7 == null) {
                                break;
                            }
                            isData = node2.isData;
                            BytecodeManager.incBytecodes(3);
                        } while (isData);
                        final Node current = node2;
                        this.current = current;
                        BytecodeManager.incBytecodes(5);
                        if (current == null) {
                            this.exhausted = true;
                            BytecodeManager.incBytecodes(3);
                        }
                        final Object o3 = item;
                        BytecodeManager.incBytecodes(2);
                        if (o3 != null) {
                            final Object o4 = item;
                            BytecodeManager.incBytecodes(3);
                            consumer.accept((Object)o4);
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
