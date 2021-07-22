// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.concurrent;

import instrumented.java.util.function.Consumer;
import instrumented.java.util.Spliterators;
import java.lang.reflect.Field;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import instrumented.java.util.Spliterator;
import java.util.Iterator;
import instrumented.java.util.Collection;
import instrumented.java.util.ArrayList;
import instrumented.java.util.NoSuchElementException;
import aic2021.engine.BytecodeManager;
import sun.misc.Unsafe;
import java.io.Serializable;
import instrumented.java.util.Deque;
import instrumented.java.util.AbstractCollection;

public class ConcurrentLinkedDeque<E> extends AbstractCollection<E> implements Deque<E>, Serializable
{
    private static final long serialVersionUID = 876323262645176354L;
    private transient volatile Node<E> head;
    private transient volatile Node<E> tail;
    private static final Node<Object> PREV_TERMINATOR;
    private static final Node<Object> NEXT_TERMINATOR;
    private static final int HOPS = 2;
    private static final Unsafe UNSAFE;
    private static final long headOffset;
    private static final long tailOffset;
    
    Node<E> prevTerminator() {
        try {
            final Node<Object> prev_TERMINATOR = ConcurrentLinkedDeque.PREV_TERMINATOR;
            BytecodeManager.incBytecodes(2);
            return (Node<E>)prev_TERMINATOR;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    Node<E> nextTerminator() {
        try {
            final Node<Object> next_TERMINATOR = ConcurrentLinkedDeque.NEXT_TERMINATOR;
            BytecodeManager.incBytecodes(2);
            return (Node<E>)next_TERMINATOR;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void linkFirst(final E e) {
        try {
            BytecodeManager.incBytecodes(2);
            checkNotNull(e);
            BytecodeManager.incBytecodes(4);
            final Node<E> node = new Node<E>(e);
            BytecodeManager.incBytecodes(1);
            Node<E> head2 = null;
            Node<E> head = null;
        Block_6:
            while (true) {
                head = (head2 = this.head);
                BytecodeManager.incBytecodes(5);
                while (true) {
                    final Node<E> prev = head2.prev;
                    BytecodeManager.incBytecodes(5);
                    if (prev != null) {
                        final Node<E> prev2 = (head2 = prev).prev;
                        BytecodeManager.incBytecodes(7);
                        if (prev2 != null) {
                            final Node<E> node2 = head;
                            final Node<E> node3 = head = this.head;
                            BytecodeManager.incBytecodes(6);
                            Node<E> node4;
                            if (node2 != node3) {
                                node4 = head;
                                BytecodeManager.incBytecodes(2);
                            }
                            else {
                                node4 = prev2;
                                BytecodeManager.incBytecodes(1);
                            }
                            head2 = node4;
                            BytecodeManager.incBytecodes(2);
                            continue;
                        }
                    }
                    final Node<E> next = head2.next;
                    final Node<E> node5 = head2;
                    BytecodeManager.incBytecodes(4);
                    if (next == node5) {
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    final Node<E> node6 = node;
                    final Node<E> node7 = head2;
                    BytecodeManager.incBytecodes(3);
                    node6.lazySetNext(node7);
                    final Node<E> node8 = head2;
                    final Node<E> node9 = null;
                    final Node<E> node10 = node;
                    BytecodeManager.incBytecodes(4);
                    final boolean casPrev = node8.casPrev(node9, node10);
                    BytecodeManager.incBytecodes(1);
                    if (casPrev) {
                        break Block_6;
                    }
                }
            }
            final Node<E> node11 = head2;
            final Node<E> node12 = head;
            BytecodeManager.incBytecodes(3);
            if (node11 != node12) {
                final Node<E> node13 = head;
                final Node<E> node14 = node;
                BytecodeManager.incBytecodes(4);
                this.casHead(node13, node14);
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void linkLast(final E e) {
        try {
            BytecodeManager.incBytecodes(2);
            checkNotNull(e);
            BytecodeManager.incBytecodes(4);
            final Node<E> node = new Node<E>(e);
            BytecodeManager.incBytecodes(1);
            Node<E> tail2 = null;
            Node<E> tail = null;
        Block_6:
            while (true) {
                tail = (tail2 = this.tail);
                BytecodeManager.incBytecodes(5);
                while (true) {
                    final Node<E> next = tail2.next;
                    BytecodeManager.incBytecodes(5);
                    if (next != null) {
                        final Node<E> next2 = (tail2 = next).next;
                        BytecodeManager.incBytecodes(7);
                        if (next2 != null) {
                            final Node<E> node2 = tail;
                            final Node<E> node3 = tail = this.tail;
                            BytecodeManager.incBytecodes(6);
                            Node<E> node4;
                            if (node2 != node3) {
                                node4 = tail;
                                BytecodeManager.incBytecodes(2);
                            }
                            else {
                                node4 = next2;
                                BytecodeManager.incBytecodes(1);
                            }
                            tail2 = node4;
                            BytecodeManager.incBytecodes(2);
                            continue;
                        }
                    }
                    final Node<E> prev = tail2.prev;
                    final Node<E> node5 = tail2;
                    BytecodeManager.incBytecodes(4);
                    if (prev == node5) {
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    final Node<E> node6 = node;
                    final Node<E> node7 = tail2;
                    BytecodeManager.incBytecodes(3);
                    node6.lazySetPrev(node7);
                    final Node<E> node8 = tail2;
                    final Node<E> node9 = null;
                    final Node<E> node10 = node;
                    BytecodeManager.incBytecodes(4);
                    final boolean casNext = node8.casNext(node9, node10);
                    BytecodeManager.incBytecodes(1);
                    if (casNext) {
                        break Block_6;
                    }
                }
            }
            final Node<E> node11 = tail2;
            final Node<E> node12 = tail;
            BytecodeManager.incBytecodes(3);
            if (node11 != node12) {
                final Node<E> node13 = tail;
                final Node<E> node14 = node;
                BytecodeManager.incBytecodes(4);
                this.casTail(node13, node14);
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    void unlink(final Node<E> node) {
        try {
            final Node<E> prev = node.prev;
            BytecodeManager.incBytecodes(3);
            final Node<E> next = node.next;
            BytecodeManager.incBytecodes(3);
            final Node<E> node2 = prev;
            BytecodeManager.incBytecodes(2);
            Label_0673: {
                if (node2 == null) {
                    final Node<E> node3 = next;
                    BytecodeManager.incBytecodes(4);
                    this.unlinkFirst(node, node3);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    final Node<E> node4 = next;
                    BytecodeManager.incBytecodes(2);
                    if (node4 == null) {
                        final Node<E> node5 = prev;
                        BytecodeManager.incBytecodes(4);
                        this.unlinkLast(node, node5);
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        int n = 1;
                        BytecodeManager.incBytecodes(2);
                        Node<E> node6 = prev;
                        BytecodeManager.incBytecodes(2);
                        Node<E> node7;
                        boolean b;
                        while (true) {
                            final E item = node6.item;
                            BytecodeManager.incBytecodes(3);
                            if (item != null) {
                                node7 = node6;
                                BytecodeManager.incBytecodes(2);
                                b = false;
                                BytecodeManager.incBytecodes(2);
                                BytecodeManager.incBytecodes(1);
                                break;
                            }
                            final Node<E> prev2 = node6.prev;
                            BytecodeManager.incBytecodes(3);
                            final Node<E> node8 = prev2;
                            BytecodeManager.incBytecodes(2);
                            if (node8 == null) {
                                final Node<E> next2 = node6.next;
                                final Node<E> node9 = node6;
                                BytecodeManager.incBytecodes(4);
                                if (next2 == node9) {
                                    BytecodeManager.incBytecodes(1);
                                    return;
                                }
                                node7 = node6;
                                BytecodeManager.incBytecodes(2);
                                b = true;
                                BytecodeManager.incBytecodes(2);
                                BytecodeManager.incBytecodes(1);
                                break;
                            }
                            else {
                                final Node<E> node10 = node6;
                                final Node<E> node11 = prev2;
                                BytecodeManager.incBytecodes(3);
                                if (node10 == node11) {
                                    BytecodeManager.incBytecodes(1);
                                    return;
                                }
                                node6 = prev2;
                                BytecodeManager.incBytecodes(2);
                                ++n;
                                BytecodeManager.incBytecodes(2);
                            }
                        }
                        Node<E> node12 = next;
                        BytecodeManager.incBytecodes(2);
                        Node<E> node13;
                        boolean b2;
                        while (true) {
                            final E item2 = node12.item;
                            BytecodeManager.incBytecodes(3);
                            if (item2 != null) {
                                node13 = node12;
                                BytecodeManager.incBytecodes(2);
                                b2 = false;
                                BytecodeManager.incBytecodes(2);
                                BytecodeManager.incBytecodes(1);
                                break;
                            }
                            final Node<E> next3 = node12.next;
                            BytecodeManager.incBytecodes(3);
                            final Node<E> node14 = next3;
                            BytecodeManager.incBytecodes(2);
                            if (node14 == null) {
                                final Node<E> prev3 = node12.prev;
                                final Node<E> node15 = node12;
                                BytecodeManager.incBytecodes(4);
                                if (prev3 == node15) {
                                    BytecodeManager.incBytecodes(1);
                                    return;
                                }
                                node13 = node12;
                                BytecodeManager.incBytecodes(2);
                                b2 = true;
                                BytecodeManager.incBytecodes(2);
                                BytecodeManager.incBytecodes(1);
                                break;
                            }
                            else {
                                final Node<E> node16 = node12;
                                final Node<E> node17 = next3;
                                BytecodeManager.incBytecodes(3);
                                if (node16 == node17) {
                                    BytecodeManager.incBytecodes(1);
                                    return;
                                }
                                node12 = next3;
                                BytecodeManager.incBytecodes(2);
                                ++n;
                                BytecodeManager.incBytecodes(2);
                            }
                        }
                        final int n2 = n;
                        final int n3 = 2;
                        BytecodeManager.incBytecodes(3);
                        if (n2 < n3) {
                            final boolean b3 = b | b2;
                            BytecodeManager.incBytecodes(4);
                            if (b3) {
                                BytecodeManager.incBytecodes(1);
                                return;
                            }
                        }
                        final Node<E> node18 = node7;
                        BytecodeManager.incBytecodes(3);
                        this.skipDeletedSuccessors(node18);
                        final Node<E> node19 = node13;
                        BytecodeManager.incBytecodes(3);
                        this.skipDeletedPredecessors(node19);
                        final boolean b4 = b | b2;
                        BytecodeManager.incBytecodes(4);
                        if (b4) {
                            final Node<E> next4 = node7.next;
                            final Node<E> node20 = node13;
                            BytecodeManager.incBytecodes(4);
                            if (next4 == node20) {
                                final Node<E> prev4 = node13.prev;
                                final Node<E> node21 = node7;
                                BytecodeManager.incBytecodes(4);
                                if (prev4 == node21) {
                                    final boolean b5 = b;
                                    BytecodeManager.incBytecodes(2);
                                    if (b5) {
                                        final Node<E> prev5 = node7.prev;
                                        BytecodeManager.incBytecodes(3);
                                        if (prev5 != null) {
                                            break Label_0673;
                                        }
                                        BytecodeManager.incBytecodes(1);
                                    }
                                    else {
                                        final E item3 = node7.item;
                                        BytecodeManager.incBytecodes(3);
                                        if (item3 == null) {
                                            break Label_0673;
                                        }
                                    }
                                    final boolean b6 = b2;
                                    BytecodeManager.incBytecodes(2);
                                    if (b6) {
                                        final Node<E> next5 = node13.next;
                                        BytecodeManager.incBytecodes(3);
                                        if (next5 != null) {
                                            break Label_0673;
                                        }
                                        BytecodeManager.incBytecodes(1);
                                    }
                                    else {
                                        final E item4 = node13.item;
                                        BytecodeManager.incBytecodes(3);
                                        if (item4 == null) {
                                            break Label_0673;
                                        }
                                    }
                                    BytecodeManager.incBytecodes(2);
                                    this.updateHead();
                                    BytecodeManager.incBytecodes(2);
                                    this.updateTail();
                                    final boolean b7 = b;
                                    BytecodeManager.incBytecodes(3);
                                    Node<E> prevTerminator;
                                    if (b7) {
                                        BytecodeManager.incBytecodes(2);
                                        prevTerminator = this.prevTerminator();
                                        BytecodeManager.incBytecodes(1);
                                    }
                                    else {
                                        prevTerminator = node;
                                        BytecodeManager.incBytecodes(1);
                                    }
                                    BytecodeManager.incBytecodes(1);
                                    node.lazySetPrev(prevTerminator);
                                    final boolean b8 = b2;
                                    BytecodeManager.incBytecodes(3);
                                    Node<E> nextTerminator;
                                    if (b8) {
                                        BytecodeManager.incBytecodes(2);
                                        nextTerminator = this.nextTerminator();
                                        BytecodeManager.incBytecodes(1);
                                    }
                                    else {
                                        nextTerminator = node;
                                        BytecodeManager.incBytecodes(1);
                                    }
                                    BytecodeManager.incBytecodes(1);
                                    node.lazySetNext(nextTerminator);
                                }
                            }
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
    
    private void unlinkFirst(final Node<E> node, final Node<E> node2) {
        try {
            Node<E> node3 = null;
            Node<E> node4 = node2;
            BytecodeManager.incBytecodes(4);
            Block_9: {
                while (true) {
                    final E item = node4.item;
                    BytecodeManager.incBytecodes(3);
                    if (item != null) {
                        break;
                    }
                    final Node<E> next;
                    final Node<E> node5 = next = node4.next;
                    BytecodeManager.incBytecodes(5);
                    if (node5 == null) {
                        break;
                    }
                    final Node<E> node6 = node4;
                    final Node<E> node7 = next;
                    BytecodeManager.incBytecodes(3);
                    if (node6 == node7) {
                        break Block_9;
                    }
                    node3 = node4;
                    BytecodeManager.incBytecodes(2);
                    node4 = next;
                    BytecodeManager.incBytecodes(3);
                }
                final Node<E> node8 = node3;
                BytecodeManager.incBytecodes(2);
                Label_0192: {
                    if (node8 != null) {
                        final Node<E> prev = node4.prev;
                        final Node<E> node9 = node4;
                        BytecodeManager.incBytecodes(4);
                        if (prev != node9) {
                            final Node<E> node10 = node4;
                            BytecodeManager.incBytecodes(4);
                            final boolean casNext = node.casNext(node2, node10);
                            BytecodeManager.incBytecodes(1);
                            if (casNext) {
                                final Node<E> node11 = node4;
                                BytecodeManager.incBytecodes(3);
                                this.skipDeletedPredecessors(node11);
                                final Node<E> prev2 = node.prev;
                                BytecodeManager.incBytecodes(3);
                                if (prev2 == null) {
                                    final Node<E> next2 = node4.next;
                                    BytecodeManager.incBytecodes(3);
                                    if (next2 != null) {
                                        final E item2 = node4.item;
                                        BytecodeManager.incBytecodes(3);
                                        if (item2 == null) {
                                            break Label_0192;
                                        }
                                    }
                                    final Node<E> prev3 = node4.prev;
                                    BytecodeManager.incBytecodes(4);
                                    if (prev3 == node) {
                                        BytecodeManager.incBytecodes(2);
                                        this.updateHead();
                                        BytecodeManager.incBytecodes(2);
                                        this.updateTail();
                                        final Node<E> node12 = node3;
                                        final Node<E> node13 = node3;
                                        BytecodeManager.incBytecodes(3);
                                        node12.lazySetNext(node13);
                                        final Node<E> node14 = node3;
                                        BytecodeManager.incBytecodes(3);
                                        final Node<E> prevTerminator = this.prevTerminator();
                                        BytecodeManager.incBytecodes(1);
                                        node14.lazySetPrev(prevTerminator);
                                    }
                                }
                            }
                        }
                    }
                }
                BytecodeManager.incBytecodes(1);
                return;
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void unlinkLast(final Node<E> node, final Node<E> node2) {
        try {
            Node<E> node3 = null;
            Node<E> node4 = node2;
            BytecodeManager.incBytecodes(4);
            Block_9: {
                while (true) {
                    final E item = node4.item;
                    BytecodeManager.incBytecodes(3);
                    if (item != null) {
                        break;
                    }
                    final Node<E> prev;
                    final Node<E> node5 = prev = node4.prev;
                    BytecodeManager.incBytecodes(5);
                    if (node5 == null) {
                        break;
                    }
                    final Node<E> node6 = node4;
                    final Node<E> node7 = prev;
                    BytecodeManager.incBytecodes(3);
                    if (node6 == node7) {
                        break Block_9;
                    }
                    node3 = node4;
                    BytecodeManager.incBytecodes(2);
                    node4 = prev;
                    BytecodeManager.incBytecodes(3);
                }
                final Node<E> node8 = node3;
                BytecodeManager.incBytecodes(2);
                Label_0192: {
                    if (node8 != null) {
                        final Node<E> next = node4.next;
                        final Node<E> node9 = node4;
                        BytecodeManager.incBytecodes(4);
                        if (next != node9) {
                            final Node<E> node10 = node4;
                            BytecodeManager.incBytecodes(4);
                            final boolean casPrev = node.casPrev(node2, node10);
                            BytecodeManager.incBytecodes(1);
                            if (casPrev) {
                                final Node<E> node11 = node4;
                                BytecodeManager.incBytecodes(3);
                                this.skipDeletedSuccessors(node11);
                                final Node<E> next2 = node.next;
                                BytecodeManager.incBytecodes(3);
                                if (next2 == null) {
                                    final Node<E> prev2 = node4.prev;
                                    BytecodeManager.incBytecodes(3);
                                    if (prev2 != null) {
                                        final E item2 = node4.item;
                                        BytecodeManager.incBytecodes(3);
                                        if (item2 == null) {
                                            break Label_0192;
                                        }
                                    }
                                    final Node<E> next3 = node4.next;
                                    BytecodeManager.incBytecodes(4);
                                    if (next3 == node) {
                                        BytecodeManager.incBytecodes(2);
                                        this.updateHead();
                                        BytecodeManager.incBytecodes(2);
                                        this.updateTail();
                                        final Node<E> node12 = node3;
                                        final Node<E> node13 = node3;
                                        BytecodeManager.incBytecodes(3);
                                        node12.lazySetPrev(node13);
                                        final Node<E> node14 = node3;
                                        BytecodeManager.incBytecodes(3);
                                        final Node<E> nextTerminator = this.nextTerminator();
                                        BytecodeManager.incBytecodes(1);
                                        node14.lazySetNext(nextTerminator);
                                    }
                                }
                            }
                        }
                    }
                }
                BytecodeManager.incBytecodes(1);
                return;
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private final void updateHead() {
        try {
            while (true) {
                final Node<E> head;
                final E item = (head = this.head).item;
                BytecodeManager.incBytecodes(6);
                if (item != null) {
                    break;
                }
                Node<E> prev;
                final Node<E> node = prev = head.prev;
                BytecodeManager.incBytecodes(5);
                if (node == null) {
                    break;
                }
                Block_4: {
                    while (true) {
                        final Node<E> prev2 = prev.prev;
                        BytecodeManager.incBytecodes(5);
                        if (prev2 == null) {
                            break;
                        }
                        final Node<E> prev3 = (prev = prev2).prev;
                        BytecodeManager.incBytecodes(7);
                        if (prev3 == null) {
                            break;
                        }
                        final Node<E> node2 = head;
                        final Node<E> head2 = this.head;
                        BytecodeManager.incBytecodes(4);
                        if (node2 != head2) {
                            break Block_4;
                        }
                        prev = prev3;
                        BytecodeManager.incBytecodes(3);
                    }
                    final Node<E> node3 = head;
                    final Node<E> node4 = prev;
                    BytecodeManager.incBytecodes(4);
                    final boolean casHead = this.casHead(node3, node4);
                    BytecodeManager.incBytecodes(1);
                    if (casHead) {
                        BytecodeManager.incBytecodes(1);
                        return;
                    }
                    continue;
                }
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private final void updateTail() {
        try {
            while (true) {
                final Node<E> tail;
                final E item = (tail = this.tail).item;
                BytecodeManager.incBytecodes(6);
                if (item != null) {
                    break;
                }
                Node<E> next;
                final Node<E> node = next = tail.next;
                BytecodeManager.incBytecodes(5);
                if (node == null) {
                    break;
                }
                Block_4: {
                    while (true) {
                        final Node<E> next2 = next.next;
                        BytecodeManager.incBytecodes(5);
                        if (next2 == null) {
                            break;
                        }
                        final Node<E> next3 = (next = next2).next;
                        BytecodeManager.incBytecodes(7);
                        if (next3 == null) {
                            break;
                        }
                        final Node<E> node2 = tail;
                        final Node<E> tail2 = this.tail;
                        BytecodeManager.incBytecodes(4);
                        if (node2 != tail2) {
                            break Block_4;
                        }
                        next = next3;
                        BytecodeManager.incBytecodes(3);
                    }
                    final Node<E> node3 = tail;
                    final Node<E> node4 = next;
                    BytecodeManager.incBytecodes(4);
                    final boolean casTail = this.casTail(node3, node4);
                    BytecodeManager.incBytecodes(1);
                    if (casTail) {
                        BytecodeManager.incBytecodes(1);
                        return;
                    }
                    continue;
                }
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void skipDeletedPredecessors(final Node<E> node) {
        try {
            Block_7: {
                while (true) {
                    final Node<E> prev = node.prev;
                    BytecodeManager.incBytecodes(3);
                    Node<E> node2 = prev;
                    BytecodeManager.incBytecodes(2);
                    Label_0149: {
                        while (true) {
                            final E item = node2.item;
                            BytecodeManager.incBytecodes(3);
                            if (item != null) {
                                BytecodeManager.incBytecodes(1);
                                break;
                            }
                            final Node<E> prev2 = node2.prev;
                            BytecodeManager.incBytecodes(3);
                            final Node<E> node3 = prev2;
                            BytecodeManager.incBytecodes(2);
                            if (node3 == null) {
                                final Node<E> next = node2.next;
                                final Node<E> node4 = node2;
                                BytecodeManager.incBytecodes(4);
                                if (next == node4) {
                                    BytecodeManager.incBytecodes(1);
                                    break Label_0149;
                                }
                                break;
                            }
                            else {
                                final Node<E> node5 = node2;
                                final Node<E> node6 = prev2;
                                BytecodeManager.incBytecodes(3);
                                if (node5 == node6) {
                                    BytecodeManager.incBytecodes(1);
                                    break Label_0149;
                                }
                                node2 = prev2;
                                BytecodeManager.incBytecodes(2);
                                BytecodeManager.incBytecodes(1);
                            }
                        }
                        final Node<E> node7 = prev;
                        final Node<E> node8 = node2;
                        BytecodeManager.incBytecodes(3);
                        if (node7 == node8) {
                            break;
                        }
                        final Node<E> node9 = prev;
                        final Node<E> node10 = node2;
                        BytecodeManager.incBytecodes(4);
                        final boolean casPrev = node.casPrev(node9, node10);
                        BytecodeManager.incBytecodes(1);
                        if (casPrev) {
                            break;
                        }
                    }
                    final E item2 = node.item;
                    BytecodeManager.incBytecodes(3);
                    if (item2 == null) {
                        final Node<E> next2 = node.next;
                        BytecodeManager.incBytecodes(3);
                        if (next2 != null) {
                            break Block_7;
                        }
                        continue;
                    }
                }
                BytecodeManager.incBytecodes(1);
                return;
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void skipDeletedSuccessors(final Node<E> node) {
        try {
            Block_7: {
                while (true) {
                    final Node<E> next = node.next;
                    BytecodeManager.incBytecodes(3);
                    Node<E> node2 = next;
                    BytecodeManager.incBytecodes(2);
                    Label_0149: {
                        while (true) {
                            final E item = node2.item;
                            BytecodeManager.incBytecodes(3);
                            if (item != null) {
                                BytecodeManager.incBytecodes(1);
                                break;
                            }
                            final Node<E> next2 = node2.next;
                            BytecodeManager.incBytecodes(3);
                            final Node<E> node3 = next2;
                            BytecodeManager.incBytecodes(2);
                            if (node3 == null) {
                                final Node<E> prev = node2.prev;
                                final Node<E> node4 = node2;
                                BytecodeManager.incBytecodes(4);
                                if (prev == node4) {
                                    BytecodeManager.incBytecodes(1);
                                    break Label_0149;
                                }
                                break;
                            }
                            else {
                                final Node<E> node5 = node2;
                                final Node<E> node6 = next2;
                                BytecodeManager.incBytecodes(3);
                                if (node5 == node6) {
                                    BytecodeManager.incBytecodes(1);
                                    break Label_0149;
                                }
                                node2 = next2;
                                BytecodeManager.incBytecodes(2);
                                BytecodeManager.incBytecodes(1);
                            }
                        }
                        final Node<E> node7 = next;
                        final Node<E> node8 = node2;
                        BytecodeManager.incBytecodes(3);
                        if (node7 == node8) {
                            break;
                        }
                        final Node<E> node9 = next;
                        final Node<E> node10 = node2;
                        BytecodeManager.incBytecodes(4);
                        final boolean casNext = node.casNext(node9, node10);
                        BytecodeManager.incBytecodes(1);
                        if (casNext) {
                            break;
                        }
                    }
                    final E item2 = node.item;
                    BytecodeManager.incBytecodes(3);
                    if (item2 == null) {
                        final Node<E> prev2 = node.prev;
                        BytecodeManager.incBytecodes(3);
                        if (prev2 != null) {
                            break Block_7;
                        }
                        continue;
                    }
                }
                BytecodeManager.incBytecodes(1);
                return;
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
            Node<E> first;
            if (node == node2) {
                BytecodeManager.incBytecodes(2);
                first = this.first();
                BytecodeManager.incBytecodes(1);
            }
            else {
                first = next;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return first;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final Node<E> pred(final Node<E> node) {
        try {
            final Node<E> prev = node.prev;
            BytecodeManager.incBytecodes(3);
            final Node<E> node2 = prev;
            BytecodeManager.incBytecodes(3);
            Node<E> last;
            if (node == node2) {
                BytecodeManager.incBytecodes(2);
                last = this.last();
                BytecodeManager.incBytecodes(1);
            }
            else {
                last = prev;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return last;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    Node<E> first() {
        try {
            boolean casHead;
            Node<E> head2;
            do {
                Node<E> head = head2 = this.head;
                BytecodeManager.incBytecodes(5);
                while (true) {
                    final Node<E> prev = head2.prev;
                    BytecodeManager.incBytecodes(5);
                    if (prev == null) {
                        break;
                    }
                    final Node<E> prev2 = (head2 = prev).prev;
                    BytecodeManager.incBytecodes(7);
                    if (prev2 == null) {
                        break;
                    }
                    final Node<E> node = head;
                    final Node<E> node2 = head = this.head;
                    BytecodeManager.incBytecodes(6);
                    Node<E> node3;
                    if (node != node2) {
                        node3 = head;
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        node3 = prev2;
                        BytecodeManager.incBytecodes(1);
                    }
                    head2 = node3;
                    BytecodeManager.incBytecodes(2);
                }
                final Node<E> node4 = head2;
                final Node<E> node5 = head;
                BytecodeManager.incBytecodes(3);
                if (node4 == node5) {
                    break;
                }
                final Node<E> node6 = head;
                final Node<E> node7 = head2;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
                casHead = this.casHead(node6, node7);
                BytecodeManager.incBytecodes(1);
            } while (!casHead);
            final Node<E> node8 = head2;
            BytecodeManager.incBytecodes(2);
            return node8;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    Node<E> last() {
        try {
            boolean casTail;
            Node<E> tail2;
            do {
                Node<E> tail = tail2 = this.tail;
                BytecodeManager.incBytecodes(5);
                while (true) {
                    final Node<E> next = tail2.next;
                    BytecodeManager.incBytecodes(5);
                    if (next == null) {
                        break;
                    }
                    final Node<E> next2 = (tail2 = next).next;
                    BytecodeManager.incBytecodes(7);
                    if (next2 == null) {
                        break;
                    }
                    final Node<E> node = tail;
                    final Node<E> node2 = tail = this.tail;
                    BytecodeManager.incBytecodes(6);
                    Node<E> node3;
                    if (node != node2) {
                        node3 = tail;
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        node3 = next2;
                        BytecodeManager.incBytecodes(1);
                    }
                    tail2 = node3;
                    BytecodeManager.incBytecodes(2);
                }
                final Node<E> node4 = tail2;
                final Node<E> node5 = tail;
                BytecodeManager.incBytecodes(3);
                if (node4 == node5) {
                    break;
                }
                final Node<E> node6 = tail;
                final Node<E> node7 = tail2;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
                casTail = this.casTail(node6, node7);
                BytecodeManager.incBytecodes(1);
            } while (!casTail);
            final Node<E> node8 = tail2;
            BytecodeManager.incBytecodes(2);
            return node8;
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
    
    private E screenNullResult(final E e) {
        try {
            BytecodeManager.incBytecodes(2);
            if (e == null) {
                BytecodeManager.incBytecodes(3);
                final NoSuchElementException ex = new NoSuchElementException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(2);
            return e;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private ArrayList<E> toArrayList() {
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
            return list3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public ConcurrentLinkedDeque() {
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
    
    public ConcurrentLinkedDeque(final Collection<? extends E> collection) {
        try {
            BytecodeManager.incBytecodes(2);
            Object o = null;
            Object o2 = null;
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
                final Node<E> node2 = (Node<E>)o;
                BytecodeManager.incBytecodes(2);
                if (node2 == null) {
                    o2 = (o = node);
                    BytecodeManager.incBytecodes(5);
                }
                else {
                    final Node<E> node3 = (Node<E>)o2;
                    final Node node4 = node;
                    BytecodeManager.incBytecodes(3);
                    node3.lazySetNext(node4);
                    final Node node5 = node;
                    final Node<E> node6 = (Node<E>)o2;
                    BytecodeManager.incBytecodes(3);
                    node5.lazySetPrev(node6);
                    o2 = node;
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(1);
            }
            final Node<E> node7 = (Node<E>)o;
            final Node<E> node8 = (Node<E>)o2;
            BytecodeManager.incBytecodes(4);
            this.initHeadTail(node7, node8);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void initHeadTail(Node<E> head, Node<E> tail) {
        try {
            final Node node = head;
            final Node<E> node2 = (Node<E>)tail;
            BytecodeManager.incBytecodes(3);
            if (node == node2) {
                final Node node3 = head;
                BytecodeManager.incBytecodes(2);
                if (node3 == null) {
                    final E e = null;
                    BytecodeManager.incBytecodes(4);
                    tail = (head = new Node<E>(e));
                    BytecodeManager.incBytecodes(4);
                }
                else {
                    final E e2 = null;
                    BytecodeManager.incBytecodes(4);
                    final Node node4 = new Node<E>(e2);
                    BytecodeManager.incBytecodes(1);
                    final Node<E> node5 = (Node<E>)tail;
                    final Node node6 = node4;
                    BytecodeManager.incBytecodes(3);
                    node5.lazySetNext(node6);
                    final Node node7 = node4;
                    final Node<E> node8 = (Node<E>)tail;
                    BytecodeManager.incBytecodes(3);
                    node7.lazySetPrev(node8);
                    tail = node4;
                    BytecodeManager.incBytecodes(2);
                }
            }
            this.head = (Node<E>)head;
            BytecodeManager.incBytecodes(3);
            this.tail = (Node<E>)tail;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
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
    public boolean offerFirst(final E e) {
        try {
            BytecodeManager.incBytecodes(3);
            this.linkFirst(e);
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
    public E peekFirst() {
        try {
            BytecodeManager.incBytecodes(2);
            Node<E> node = this.first();
            BytecodeManager.incBytecodes(1);
            while (true) {
                final Node<E> node2 = node;
                BytecodeManager.incBytecodes(2);
                if (node2 == null) {
                    final E e = null;
                    BytecodeManager.incBytecodes(2);
                    return e;
                }
                final E item = node.item;
                BytecodeManager.incBytecodes(3);
                final E e2 = item;
                BytecodeManager.incBytecodes(2);
                if (e2 != null) {
                    final E e3 = item;
                    BytecodeManager.incBytecodes(2);
                    return e3;
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
    public E peekLast() {
        try {
            BytecodeManager.incBytecodes(2);
            Node<E> node = this.last();
            BytecodeManager.incBytecodes(1);
            while (true) {
                final Node<E> node2 = node;
                BytecodeManager.incBytecodes(2);
                if (node2 == null) {
                    final E e = null;
                    BytecodeManager.incBytecodes(2);
                    return e;
                }
                final E item = node.item;
                BytecodeManager.incBytecodes(3);
                final E e2 = item;
                BytecodeManager.incBytecodes(2);
                if (e2 != null) {
                    final E e3 = item;
                    BytecodeManager.incBytecodes(2);
                    return e3;
                }
                final Node<E> node3 = node;
                BytecodeManager.incBytecodes(3);
                node = this.pred(node3);
                BytecodeManager.incBytecodes(2);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public E getFirst() {
        try {
            BytecodeManager.incBytecodes(3);
            final E peekFirst = this.peekFirst();
            BytecodeManager.incBytecodes(1);
            final Object screenNullResult = this.screenNullResult(peekFirst);
            BytecodeManager.incBytecodes(1);
            return (E)screenNullResult;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public E getLast() {
        try {
            BytecodeManager.incBytecodes(3);
            final E peekLast = this.peekLast();
            BytecodeManager.incBytecodes(1);
            final Object screenNullResult = this.screenNullResult(peekLast);
            BytecodeManager.incBytecodes(1);
            return (E)screenNullResult;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public E pollFirst() {
        try {
            BytecodeManager.incBytecodes(2);
            Node<E> node = this.first();
            BytecodeManager.incBytecodes(1);
            while (true) {
                final Node<E> node2 = node;
                BytecodeManager.incBytecodes(2);
                if (node2 == null) {
                    final E e = null;
                    BytecodeManager.incBytecodes(2);
                    return e;
                }
                final E item = node.item;
                BytecodeManager.incBytecodes(3);
                final E e2 = item;
                BytecodeManager.incBytecodes(2);
                if (e2 != null) {
                    final Node<E> node3 = node;
                    final E e3 = item;
                    final E e4 = null;
                    BytecodeManager.incBytecodes(4);
                    final boolean casItem = node3.casItem(e3, e4);
                    BytecodeManager.incBytecodes(1);
                    if (casItem) {
                        final Node<E> node4 = node;
                        BytecodeManager.incBytecodes(3);
                        this.unlink(node4);
                        final E e5 = item;
                        BytecodeManager.incBytecodes(2);
                        return e5;
                    }
                }
                final Node<E> node5 = node;
                BytecodeManager.incBytecodes(3);
                node = this.succ(node5);
                BytecodeManager.incBytecodes(2);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public E pollLast() {
        try {
            BytecodeManager.incBytecodes(2);
            Node<E> node = this.last();
            BytecodeManager.incBytecodes(1);
            while (true) {
                final Node<E> node2 = node;
                BytecodeManager.incBytecodes(2);
                if (node2 == null) {
                    final E e = null;
                    BytecodeManager.incBytecodes(2);
                    return e;
                }
                final E item = node.item;
                BytecodeManager.incBytecodes(3);
                final E e2 = item;
                BytecodeManager.incBytecodes(2);
                if (e2 != null) {
                    final Node<E> node3 = node;
                    final E e3 = item;
                    final E e4 = null;
                    BytecodeManager.incBytecodes(4);
                    final boolean casItem = node3.casItem(e3, e4);
                    BytecodeManager.incBytecodes(1);
                    if (casItem) {
                        final Node<E> node4 = node;
                        BytecodeManager.incBytecodes(3);
                        this.unlink(node4);
                        final E e5 = item;
                        BytecodeManager.incBytecodes(2);
                        return e5;
                    }
                }
                final Node<E> node5 = node;
                BytecodeManager.incBytecodes(3);
                node = this.pred(node5);
                BytecodeManager.incBytecodes(2);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public E removeFirst() {
        try {
            BytecodeManager.incBytecodes(3);
            final E pollFirst = this.pollFirst();
            BytecodeManager.incBytecodes(1);
            final Object screenNullResult = this.screenNullResult(pollFirst);
            BytecodeManager.incBytecodes(1);
            return (E)screenNullResult;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public E removeLast() {
        try {
            BytecodeManager.incBytecodes(3);
            final E pollLast = this.pollLast();
            BytecodeManager.incBytecodes(1);
            final Object screenNullResult = this.screenNullResult(pollLast);
            BytecodeManager.incBytecodes(1);
            return (E)screenNullResult;
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
    public boolean add(final E e) {
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
    public boolean removeFirstOccurrence(final Object o) {
        try {
            BytecodeManager.incBytecodes(2);
            checkNotNull(o);
            BytecodeManager.incBytecodes(2);
            Node<E> node = this.first();
            BytecodeManager.incBytecodes(1);
            while (true) {
                final Node<E> node2 = node;
                BytecodeManager.incBytecodes(2);
                if (node2 == null) {
                    final boolean b = false;
                    BytecodeManager.incBytecodes(2);
                    return b;
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
                        final Node<E> node3 = node;
                        final E e2 = item;
                        final E e3 = null;
                        BytecodeManager.incBytecodes(4);
                        final boolean casItem = node3.casItem(e2, e3);
                        BytecodeManager.incBytecodes(1);
                        if (casItem) {
                            final Node<E> node4 = node;
                            BytecodeManager.incBytecodes(3);
                            this.unlink(node4);
                            final boolean b2 = true;
                            BytecodeManager.incBytecodes(2);
                            return b2;
                        }
                    }
                }
                final Node<E> node5 = node;
                BytecodeManager.incBytecodes(3);
                node = this.succ(node5);
                BytecodeManager.incBytecodes(2);
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
            checkNotNull(o);
            BytecodeManager.incBytecodes(2);
            Node<E> node = this.last();
            BytecodeManager.incBytecodes(1);
            while (true) {
                final Node<E> node2 = node;
                BytecodeManager.incBytecodes(2);
                if (node2 == null) {
                    final boolean b = false;
                    BytecodeManager.incBytecodes(2);
                    return b;
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
                        final Node<E> node3 = node;
                        final E e2 = item;
                        final E e3 = null;
                        BytecodeManager.incBytecodes(4);
                        final boolean casItem = node3.casItem(e2, e3);
                        BytecodeManager.incBytecodes(1);
                        if (casItem) {
                            final Node<E> node4 = node;
                            BytecodeManager.incBytecodes(3);
                            this.unlink(node4);
                            final boolean b2 = true;
                            BytecodeManager.incBytecodes(2);
                            return b2;
                        }
                    }
                }
                final Node<E> node5 = node;
                BytecodeManager.incBytecodes(3);
                node = this.pred(node5);
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
    public boolean isEmpty() {
        try {
            BytecodeManager.incBytecodes(2);
            final Object peekFirst = this.peekFirst();
            BytecodeManager.incBytecodes(1);
            boolean b;
            if (peekFirst == null) {
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
                    final Node node7 = node3;
                    final Node<E> node8 = node2;
                    BytecodeManager.incBytecodes(3);
                    node7.lazySetPrev(node8);
                    node2 = (Node<E>)node3;
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(1);
            }
            final Node<E> node9 = node;
            BytecodeManager.incBytecodes(2);
            if (node9 == null) {
                final boolean b = false;
                BytecodeManager.incBytecodes(2);
                return b;
            }
            Node<E> tail = null;
        Block_10:
            while (true) {
                Node<E> tail2;
                tail = (tail2 = this.tail);
                BytecodeManager.incBytecodes(5);
                while (true) {
                    final Node<E> next2 = tail2.next;
                    BytecodeManager.incBytecodes(5);
                    if (next2 != null) {
                        final Node<E> next3 = (tail2 = next2).next;
                        BytecodeManager.incBytecodes(7);
                        if (next3 != null) {
                            final Node<E> node10 = tail;
                            final Node<E> node11 = tail = this.tail;
                            BytecodeManager.incBytecodes(6);
                            Node<E> node12;
                            if (node10 != node11) {
                                node12 = tail;
                                BytecodeManager.incBytecodes(2);
                            }
                            else {
                                node12 = next3;
                                BytecodeManager.incBytecodes(1);
                            }
                            tail2 = node12;
                            BytecodeManager.incBytecodes(2);
                            continue;
                        }
                    }
                    final Node<E> prev = tail2.prev;
                    final Node<E> node13 = tail2;
                    BytecodeManager.incBytecodes(4);
                    if (prev == node13) {
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    final Node<E> node14 = node;
                    final Node<E> node15 = tail2;
                    BytecodeManager.incBytecodes(3);
                    node14.lazySetPrev(node15);
                    final Node<E> node16 = tail2;
                    final Node<E> node17 = null;
                    final Node<E> node18 = node;
                    BytecodeManager.incBytecodes(4);
                    final boolean casNext = node16.casNext(node17, node18);
                    BytecodeManager.incBytecodes(1);
                    if (casNext) {
                        break Block_10;
                    }
                }
            }
            final Node<E> node19 = tail;
            final Node<E> node20 = node2;
            BytecodeManager.incBytecodes(4);
            final boolean casTail = this.casTail(node19, node20);
            BytecodeManager.incBytecodes(1);
            if (!casTail) {
                final Node<E> tail3 = this.tail;
                BytecodeManager.incBytecodes(3);
                final Node<E> next4 = node2.next;
                BytecodeManager.incBytecodes(3);
                if (next4 == null) {
                    final Node<E> node21 = tail3;
                    final Node<E> node22 = node2;
                    BytecodeManager.incBytecodes(4);
                    this.casTail(node21, node22);
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
    public void clear() {
        try {
            while (true) {
                BytecodeManager.incBytecodes(2);
                final Object pollFirst = this.pollFirst();
                BytecodeManager.incBytecodes(1);
                if (pollFirst == null) {
                    break;
                }
                BytecodeManager.incBytecodes(1);
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
            BytecodeManager.incBytecodes(2);
            final ArrayList<E> arrayList = this.toArrayList();
            BytecodeManager.incBytecodes(1);
            final Object[] array = arrayList.toArray();
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
            BytecodeManager.incBytecodes(2);
            final ArrayList<E> arrayList = this.toArrayList();
            BytecodeManager.incBytecodes(2);
            final T[] array2 = arrayList.toArray(array);
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
    public Iterator<E> descendingIterator() {
        try {
            final Object object = null;
            BytecodeManager.incBytecodes(5);
            final DescendingItr descendingItr = new DescendingItr();
            BytecodeManager.incBytecodes(1);
            return descendingItr;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public Spliterator<E> spliterator() {
        try {
            BytecodeManager.incBytecodes(4);
            final CLDSpliterator<E> cldSpliterator = new CLDSpliterator<E>(this);
            BytecodeManager.incBytecodes(1);
            return cldSpliterator;
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
            Object o = null;
            Object o2 = null;
            BytecodeManager.incBytecodes(4);
            while (true) {
                BytecodeManager.incBytecodes(2);
                final Object object = objectInputStream.readObject();
                BytecodeManager.incBytecodes(3);
                if (object == null) {
                    break;
                }
                final Object o3 = object;
                BytecodeManager.incBytecodes(4);
                final Node node = new Node<E>(o3);
                BytecodeManager.incBytecodes(1);
                final Node<E> node2 = (Node<E>)o;
                BytecodeManager.incBytecodes(2);
                if (node2 == null) {
                    o2 = (o = node);
                    BytecodeManager.incBytecodes(5);
                }
                else {
                    final Node<E> node3 = (Node<E>)o2;
                    final Node node4 = node;
                    BytecodeManager.incBytecodes(3);
                    node3.lazySetNext(node4);
                    final Node node5 = node;
                    final Node<E> node6 = (Node<E>)o2;
                    BytecodeManager.incBytecodes(3);
                    node5.lazySetPrev(node6);
                    o2 = node;
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(1);
            }
            final Node<E> node7 = (Node<E>)o;
            final Node<E> node8 = (Node<E>)o2;
            BytecodeManager.incBytecodes(4);
            this.initHeadTail(node7, node8);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private boolean casHead(final Node<E> expected, final Node<E> x) {
        try {
            final Unsafe unsafe = ConcurrentLinkedDeque.UNSAFE;
            final long headOffset = ConcurrentLinkedDeque.headOffset;
            BytecodeManager.incBytecodes(6);
            final boolean compareAndSwapObject = unsafe.compareAndSwapObject(this, headOffset, expected, x);
            BytecodeManager.incBytecodes(1);
            return compareAndSwapObject;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private boolean casTail(final Node<E> expected, final Node<E> x) {
        try {
            final Unsafe unsafe = ConcurrentLinkedDeque.UNSAFE;
            final long tailOffset = ConcurrentLinkedDeque.tailOffset;
            BytecodeManager.incBytecodes(6);
            final boolean compareAndSwapObject = unsafe.compareAndSwapObject(this, tailOffset, expected, x);
            BytecodeManager.incBytecodes(1);
            return compareAndSwapObject;
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
        //     3: dup            
        //     4: ldc             3
        //     6: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     9: invokespecial   instrumented/java/util/concurrent/ConcurrentLinkedDeque$Node.<init>:()V
        //    12: putstatic       instrumented/java/util/concurrent/ConcurrentLinkedDeque.PREV_TERMINATOR:Linstrumented/java/util/concurrent/ConcurrentLinkedDeque$Node;
        //    15: ldc             1
        //    17: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    20: getstatic       instrumented/java/util/concurrent/ConcurrentLinkedDeque.PREV_TERMINATOR:Linstrumented/java/util/concurrent/ConcurrentLinkedDeque$Node;
        //    23: getstatic       instrumented/java/util/concurrent/ConcurrentLinkedDeque.PREV_TERMINATOR:Linstrumented/java/util/concurrent/ConcurrentLinkedDeque$Node;
        //    26: putfield        instrumented/java/util/concurrent/ConcurrentLinkedDeque$Node.next:Linstrumented/java/util/concurrent/ConcurrentLinkedDeque$Node;
        //    29: ldc             3
        //    31: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    34: new             Linstrumented/java/util/concurrent/ConcurrentLinkedDeque$Node;
        //    37: dup            
        //    38: ldc             3
        //    40: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    43: invokespecial   instrumented/java/util/concurrent/ConcurrentLinkedDeque$Node.<init>:()V
        //    46: putstatic       instrumented/java/util/concurrent/ConcurrentLinkedDeque.NEXT_TERMINATOR:Linstrumented/java/util/concurrent/ConcurrentLinkedDeque$Node;
        //    49: ldc             1
        //    51: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    54: getstatic       instrumented/java/util/concurrent/ConcurrentLinkedDeque.NEXT_TERMINATOR:Linstrumented/java/util/concurrent/ConcurrentLinkedDeque$Node;
        //    57: getstatic       instrumented/java/util/concurrent/ConcurrentLinkedDeque.NEXT_TERMINATOR:Linstrumented/java/util/concurrent/ConcurrentLinkedDeque$Node;
        //    60: putfield        instrumented/java/util/concurrent/ConcurrentLinkedDeque$Node.prev:Linstrumented/java/util/concurrent/ConcurrentLinkedDeque$Node;
        //    63: ldc             3
        //    65: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    68: ldc             1
        //    70: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    73: invokestatic    sun/misc/Unsafe.getUnsafe:()Lsun/misc/Unsafe;
        //    76: putstatic       instrumented/java/util/concurrent/ConcurrentLinkedDeque.UNSAFE:Lsun/misc/Unsafe;
        //    79: ldc             1
        //    81: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    84: ldc             Linstrumented/java/util/concurrent/ConcurrentLinkedDeque;.class
        //    86: astore_0       
        //    87: ldc             2
        //    89: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    92: getstatic       instrumented/java/util/concurrent/ConcurrentLinkedDeque.UNSAFE:Lsun/misc/Unsafe;
        //    95: aload_0        
        //    96: ldc_w           "head"
        //    99: ldc             3
        //   101: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   104: ldc             1
        //   106: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   109: invokevirtual   java/lang/Class.getDeclaredField:(Ljava/lang/String;)Ljava/lang/reflect/Field;
        //   112: ldc             1
        //   114: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   117: invokevirtual   sun/misc/Unsafe.objectFieldOffset:(Ljava/lang/reflect/Field;)J
        //   120: putstatic       instrumented/java/util/concurrent/ConcurrentLinkedDeque.headOffset:J
        //   123: ldc             1
        //   125: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   128: getstatic       instrumented/java/util/concurrent/ConcurrentLinkedDeque.UNSAFE:Lsun/misc/Unsafe;
        //   131: aload_0        
        //   132: ldc_w           "tail"
        //   135: ldc             3
        //   137: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   140: ldc             1
        //   142: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   145: invokevirtual   java/lang/Class.getDeclaredField:(Ljava/lang/String;)Ljava/lang/reflect/Field;
        //   148: ldc             1
        //   150: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   153: invokevirtual   sun/misc/Unsafe.objectFieldOffset:(Ljava/lang/reflect/Field;)J
        //   156: putstatic       instrumented/java/util/concurrent/ConcurrentLinkedDeque.tailOffset:J
        //   159: ldc             1
        //   161: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   164: ldc             1
        //   166: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   169: goto            198
        //   172: astore_0       
        //   173: ldc_w           501
        //   176: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   179: new             Ljava/lang/Error;
        //   182: dup            
        //   183: aload_0        
        //   184: ldc             4
        //   186: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   189: invokespecial   java/lang/Error.<init>:(Ljava/lang/Throwable;)V
        //   192: ldc             1
        //   194: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   197: athrow         
        //   198: ldc             1
        //   200: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   203: return         
        //   204: athrow         
        //   205: athrow         
        //    StackMapTable: 00 04 F7 00 AC 07 01 36 19 FF 00 05 00 00 00 01 07 00 39 FF 00 00 00 00 00 01 07 01 34
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  68     205    205    206    Ljava/lang/VirtualMachineError;
        //  68     164    172    198    Ljava/lang/Exception;
        //  0      204    204    205    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0198:
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
    
    static final class Node<E>
    {
        volatile Node<E> prev;
        volatile E item;
        volatile Node<E> next;
        private static final Unsafe UNSAFE;
        private static final long prevOffset;
        private static final long itemOffset;
        private static final long nextOffset;
        
        Node() {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
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
        
        void lazySetPrev(final Node<E> x) {
            try {
                final Unsafe unsafe = Node.UNSAFE;
                final long prevOffset = Node.prevOffset;
                BytecodeManager.incBytecodes(5);
                unsafe.putOrderedObject(this, prevOffset, x);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        boolean casPrev(final Node<E> expected, final Node<E> x) {
            try {
                final Unsafe unsafe = Node.UNSAFE;
                final long prevOffset = Node.prevOffset;
                BytecodeManager.incBytecodes(6);
                final boolean compareAndSwapObject = unsafe.compareAndSwapObject(this, prevOffset, expected, x);
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
                        final String name = "prev";
                        BytecodeManager.incBytecodes(3);
                        BytecodeManager.incBytecodes(1);
                        final Field declaredField = clazz2.getDeclaredField(name);
                        BytecodeManager.incBytecodes(1);
                        prevOffset = unsafe.objectFieldOffset(declaredField);
                        BytecodeManager.incBytecodes(1);
                        final Unsafe unsafe2 = Node.UNSAFE;
                        final Class<Node> clazz3 = clazz;
                        final String name2 = "item";
                        BytecodeManager.incBytecodes(3);
                        BytecodeManager.incBytecodes(1);
                        final Field declaredField2 = clazz3.getDeclaredField(name2);
                        BytecodeManager.incBytecodes(1);
                        itemOffset = unsafe2.objectFieldOffset(declaredField2);
                        BytecodeManager.incBytecodes(1);
                        final Unsafe unsafe3 = Node.UNSAFE;
                        final Class<Node> clazz4 = clazz;
                        final String name3 = "next";
                        BytecodeManager.incBytecodes(3);
                        BytecodeManager.incBytecodes(1);
                        final Field declaredField3 = clazz4.getDeclaredField(name3);
                        BytecodeManager.incBytecodes(1);
                        nextOffset = unsafe3.objectFieldOffset(declaredField3);
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
    
    private abstract class AbstractItr implements Iterator<E>
    {
        private Node<E> nextNode;
        private E nextItem;
        private Node<E> lastRet;
        
        abstract Node<E> startNode();
        
        abstract Node<E> nextNode(final Node<E> p0);
        
        AbstractItr() {
            try {
                BytecodeManager.incBytecodes(5);
                BytecodeManager.incBytecodes(2);
                this.advance();
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private void advance() {
            try {
                this.lastRet = this.nextNode;
                BytecodeManager.incBytecodes(4);
                final Node<E> nextNode = this.nextNode;
                BytecodeManager.incBytecodes(3);
                Node<E> node;
                if (nextNode == null) {
                    BytecodeManager.incBytecodes(2);
                    node = this.startNode();
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    final Node<E> nextNode2 = this.nextNode;
                    BytecodeManager.incBytecodes(4);
                    node = this.nextNode(nextNode2);
                }
                Node<E> nextNode3 = node;
                BytecodeManager.incBytecodes(1);
                while (true) {
                    final Node<E> node2 = nextNode3;
                    BytecodeManager.incBytecodes(2);
                    if (node2 == null) {
                        this.nextNode = null;
                        BytecodeManager.incBytecodes(3);
                        this.nextItem = null;
                        BytecodeManager.incBytecodes(3);
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    final E item = nextNode3.item;
                    BytecodeManager.incBytecodes(3);
                    final E e = item;
                    BytecodeManager.incBytecodes(2);
                    if (e != null) {
                        this.nextNode = nextNode3;
                        BytecodeManager.incBytecodes(3);
                        this.nextItem = item;
                        BytecodeManager.incBytecodes(3);
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    final Node<E> node3 = nextNode3;
                    BytecodeManager.incBytecodes(3);
                    nextNode3 = this.nextNode(node3);
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean hasNext() {
            try {
                final E nextItem = this.nextItem;
                BytecodeManager.incBytecodes(3);
                boolean b;
                if (nextItem != null) {
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
                final E nextItem = this.nextItem;
                BytecodeManager.incBytecodes(3);
                final E e = nextItem;
                BytecodeManager.incBytecodes(2);
                if (e == null) {
                    BytecodeManager.incBytecodes(3);
                    final NoSuchElementException ex = new NoSuchElementException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                BytecodeManager.incBytecodes(2);
                this.advance();
                final E e2 = nextItem;
                BytecodeManager.incBytecodes(2);
                return e2;
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
                final ConcurrentLinkedDeque this$0 = ConcurrentLinkedDeque.this;
                final Node<E> node2 = lastRet;
                BytecodeManager.incBytecodes(4);
                this$0.unlink(node2);
                this.lastRet = null;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private class Itr extends AbstractItr
    {
        private Itr() {
            try {
                BytecodeManager.incBytecodes(6);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        Node<E> startNode() {
            try {
                final ConcurrentLinkedDeque this$0 = ConcurrentLinkedDeque.this;
                BytecodeManager.incBytecodes(3);
                final Node<E> first = this$0.first();
                BytecodeManager.incBytecodes(1);
                return first;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        Node<E> nextNode(final Node<E> node) {
            try {
                final ConcurrentLinkedDeque this$0 = ConcurrentLinkedDeque.this;
                BytecodeManager.incBytecodes(4);
                final Node<E> succ = this$0.succ(node);
                BytecodeManager.incBytecodes(1);
                return succ;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private class DescendingItr extends AbstractItr
    {
        private DescendingItr() {
            try {
                BytecodeManager.incBytecodes(6);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        Node<E> startNode() {
            try {
                final ConcurrentLinkedDeque this$0 = ConcurrentLinkedDeque.this;
                BytecodeManager.incBytecodes(3);
                final Node<E> last = this$0.last();
                BytecodeManager.incBytecodes(1);
                return last;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        Node<E> nextNode(final Node<E> node) {
            try {
                final ConcurrentLinkedDeque this$0 = ConcurrentLinkedDeque.this;
                BytecodeManager.incBytecodes(4);
                final Node<E> pred = this$0.pred(node);
                BytecodeManager.incBytecodes(1);
                return pred;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class CLDSpliterator<E> implements Spliterator<E>
    {
        static final int MAX_BATCH = 33554432;
        final ConcurrentLinkedDeque<E> queue;
        Node<E> current;
        int batch;
        boolean exhausted;
        
        CLDSpliterator(final ConcurrentLinkedDeque<E> queue) {
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
                final ConcurrentLinkedDeque<E> queue = this.queue;
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
                Label_0361: {
                    if (!exhausted) {
                        Node<E> node2;
                        final Node<E> node = node2 = this.current;
                        BytecodeManager.incBytecodes(5);
                        if (node == null) {
                            final ConcurrentLinkedDeque<E> concurrentLinkedDeque = queue;
                            BytecodeManager.incBytecodes(1);
                            BytecodeManager.incBytecodes(1);
                            final Node<E> node3 = node2 = concurrentLinkedDeque.first();
                            BytecodeManager.incBytecodes(3);
                            if (node3 == null) {
                                break Label_0361;
                            }
                        }
                        final E item = node2.item;
                        BytecodeManager.incBytecodes(3);
                        if (item == null) {
                            final Node<E> node4 = node2;
                            final Node<E> node5 = node2 = node2.next;
                            BytecodeManager.incBytecodes(6);
                            if (node4 == node5) {
                                final ConcurrentLinkedDeque<E> concurrentLinkedDeque2 = queue;
                                BytecodeManager.incBytecodes(3);
                                node2 = (this.current = concurrentLinkedDeque2.first());
                                BytecodeManager.incBytecodes(3);
                            }
                        }
                        final Node<E> node6 = node2;
                        BytecodeManager.incBytecodes(2);
                        if (node6 != null) {
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
                                    final E item2 = node2.item;
                                    array2[n7] = item2;
                                    BytecodeManager.incBytecodes(7);
                                    if (item2 != null) {
                                        ++batch2;
                                        BytecodeManager.incBytecodes(1);
                                    }
                                    final Node<E> node7 = node2;
                                    final Node<E> node8 = node2 = node2.next;
                                    BytecodeManager.incBytecodes(6);
                                    if (node7 == node8) {
                                        final ConcurrentLinkedDeque<E> concurrentLinkedDeque3 = queue;
                                        BytecodeManager.incBytecodes(2);
                                        node2 = concurrentLinkedDeque3.first();
                                        BytecodeManager.incBytecodes(1);
                                    }
                                    final Node<E> node9 = node2;
                                    BytecodeManager.incBytecodes(2);
                                    if (node9 == null) {
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
                final ConcurrentLinkedDeque<E> queue = this.queue;
                BytecodeManager.incBytecodes(3);
                final boolean exhausted = this.exhausted;
                BytecodeManager.incBytecodes(3);
                Label_0170: {
                    if (!exhausted) {
                        Node<E> node2;
                        final Node<E> node = node2 = this.current;
                        BytecodeManager.incBytecodes(5);
                        if (node == null) {
                            final ConcurrentLinkedDeque<E> concurrentLinkedDeque = queue;
                            BytecodeManager.incBytecodes(1);
                            BytecodeManager.incBytecodes(1);
                            final Node<E> node3 = node2 = concurrentLinkedDeque.first();
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
                                final ConcurrentLinkedDeque<E> concurrentLinkedDeque2 = queue;
                                BytecodeManager.incBytecodes(2);
                                node2 = concurrentLinkedDeque2.first();
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
                final ConcurrentLinkedDeque<E> queue = this.queue;
                BytecodeManager.incBytecodes(3);
                final boolean exhausted = this.exhausted;
                BytecodeManager.incBytecodes(3);
                Label_0201: {
                    if (!exhausted) {
                        Node<E> node2;
                        final Node<E> node = node2 = this.current;
                        BytecodeManager.incBytecodes(5);
                        if (node == null) {
                            final ConcurrentLinkedDeque<E> concurrentLinkedDeque = queue;
                            BytecodeManager.incBytecodes(1);
                            BytecodeManager.incBytecodes(1);
                            final Node<E> node3 = node2 = concurrentLinkedDeque.first();
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
                                final ConcurrentLinkedDeque<E> concurrentLinkedDeque2 = queue;
                                BytecodeManager.incBytecodes(2);
                                node2 = concurrentLinkedDeque2.first();
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
