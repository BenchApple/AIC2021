// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.concurrent;

import java.lang.invoke.SerializedLambda;
import instrumented.java.util.function.Consumer;
import instrumented.java.util.Collections;
import instrumented.java.util.AbstractCollection;
import instrumented.java.util.SortedSet;
import instrumented.java.util.Spliterator;
import instrumented.java.util.AbstractSet;
import java.lang.reflect.Field;
import instrumented.java.util.NavigableMap;
import instrumented.java.util.function.BiConsumer;
import instrumented.java.util.List;
import instrumented.java.util.NoSuchElementException;
import instrumented.java.util.Collection;
import instrumented.java.util.NavigableSet;
import instrumented.java.util.function.BiFunction;
import instrumented.java.util.function.Function;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import instrumented.java.util.Set;
import instrumented.java.util.ArrayList;
import instrumented.java.util.SortedMap;
import instrumented.java.util.Map;
import aic2021.engine.BytecodeManager;
import sun.misc.Unsafe;
import instrumented.java.util.Comparator;
import java.io.Serializable;
import instrumented.java.util.AbstractMap;

public class ConcurrentSkipListMap<K, V> extends AbstractMap<K, V> implements ConcurrentNavigableMap<K, V>, Cloneable, Serializable
{
    private static final long serialVersionUID = -8627078645895051609L;
    private static final Object BASE_HEADER;
    private transient volatile HeadIndex<K, V> head;
    final Comparator<? super K> comparator;
    private transient KeySet<K> keySet;
    private transient EntrySet<K, V> entrySet;
    private transient Values<V> values;
    private transient ConcurrentNavigableMap<K, V> descendingMap;
    private static final int EQ = 1;
    private static final int LT = 2;
    private static final int GT = 0;
    private static final Unsafe UNSAFE;
    private static final long headOffset;
    private static final long SECONDARY;
    
    private void initialize() {
        try {
            this.keySet = null;
            BytecodeManager.incBytecodes(3);
            this.entrySet = null;
            BytecodeManager.incBytecodes(3);
            this.values = null;
            BytecodeManager.incBytecodes(3);
            this.descendingMap = null;
            BytecodeManager.incBytecodes(3);
            final K k = null;
            final Object base_HEADER = ConcurrentSkipListMap.BASE_HEADER;
            final Node<K, V> node = null;
            BytecodeManager.incBytecodes(9);
            final Node node2 = new Node<K, V>(k, base_HEADER, (Node<Object, Object>)node);
            final Index<Object, Object> index = null;
            final Index<K, V> index2 = null;
            final int n = 1;
            BytecodeManager.incBytecodes(4);
            this.head = new HeadIndex<K, V>((Node<Object, Object>)node2, index, (Index<Object, Object>)index2, n);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private boolean casHead(final HeadIndex<K, V> expected, final HeadIndex<K, V> x) {
        try {
            final Unsafe unsafe = ConcurrentSkipListMap.UNSAFE;
            final long headOffset = ConcurrentSkipListMap.headOffset;
            BytecodeManager.incBytecodes(6);
            final boolean compareAndSwapObject = unsafe.compareAndSwapObject(this, headOffset, expected, x);
            BytecodeManager.incBytecodes(1);
            return compareAndSwapObject;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static final int cpr(final Comparator comparator, final Object o, final Object o2) {
        try {
            BytecodeManager.incBytecodes(2);
            int n;
            if (comparator != null) {
                BytecodeManager.incBytecodes(4);
                n = comparator.compare(o, o2);
                BytecodeManager.incBytecodes(1);
            }
            else {
                final Comparable comparable = (Comparable)o;
                BytecodeManager.incBytecodes(4);
                n = comparable.compareTo(o2);
            }
            BytecodeManager.incBytecodes(1);
            return n;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private Node<K, V> findPredecessor(final Object o, final Comparator<? super K> comparator) {
        try {
            BytecodeManager.incBytecodes(2);
            if (o == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            Index<K, V> head = null;
        Block_7:
            while (true) {
                head = this.head;
                Index<K, V> index = head.right;
                BytecodeManager.incBytecodes(6);
                while (true) {
                    final Index<K, V> index2 = index;
                    BytecodeManager.incBytecodes(2);
                    if (index2 != null) {
                        final Node<K, V> node = index.node;
                        BytecodeManager.incBytecodes(3);
                        final K key = node.key;
                        BytecodeManager.incBytecodes(3);
                        final Object value = node.value;
                        BytecodeManager.incBytecodes(3);
                        if (value == null) {
                            final Index<K, V> index3 = head;
                            final Index<K, V> index4 = index;
                            BytecodeManager.incBytecodes(3);
                            final boolean unlink = index3.unlink(index4);
                            BytecodeManager.incBytecodes(1);
                            if (!unlink) {
                                BytecodeManager.incBytecodes(1);
                                BytecodeManager.incBytecodes(1);
                                break;
                            }
                            index = head.right;
                            BytecodeManager.incBytecodes(3);
                            BytecodeManager.incBytecodes(1);
                            continue;
                        }
                        else {
                            final K k = key;
                            BytecodeManager.incBytecodes(4);
                            final int cpr = cpr(comparator, o, k);
                            BytecodeManager.incBytecodes(1);
                            if (cpr > 0) {
                                head = index;
                                BytecodeManager.incBytecodes(2);
                                index = index.right;
                                BytecodeManager.incBytecodes(3);
                                BytecodeManager.incBytecodes(1);
                                continue;
                            }
                        }
                    }
                    final Index<K, V> down;
                    final Index<K, V> index5 = down = head.down;
                    BytecodeManager.incBytecodes(5);
                    if (index5 == null) {
                        break Block_7;
                    }
                    head = down;
                    BytecodeManager.incBytecodes(2);
                    index = down.right;
                    BytecodeManager.incBytecodes(4);
                }
            }
            final Node<K, V> node2 = head.node;
            BytecodeManager.incBytecodes(3);
            return node2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private Node<K, V> findNode(final Object o) {
        try {
            BytecodeManager.incBytecodes(2);
            if (o == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final Comparator<? super K> comparator = this.comparator;
            BytecodeManager.incBytecodes(3);
        Label_0266:
            while (true) {
                final Comparator<? super K> comparator2 = comparator;
                BytecodeManager.incBytecodes(4);
                Node<K, V> predecessor = this.findPredecessor(o, comparator2);
                Node<K, V> next = predecessor.next;
                BytecodeManager.incBytecodes(4);
                while (true) {
                    final Node<K, V> node = next;
                    BytecodeManager.incBytecodes(2);
                    if (node == null) {
                        BytecodeManager.incBytecodes(1);
                        break Label_0266;
                    }
                    final Node<K, V> next2 = next.next;
                    BytecodeManager.incBytecodes(3);
                    final Node<K, V> node2 = next;
                    final Node<K, V> next3 = predecessor.next;
                    BytecodeManager.incBytecodes(4);
                    if (node2 != next3) {
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    final Object value = next.value;
                    BytecodeManager.incBytecodes(5);
                    if (value == null) {
                        final Node<K, V> node3 = next;
                        final Node<K, V> node4 = predecessor;
                        final Node<K, V> node5 = next2;
                        BytecodeManager.incBytecodes(4);
                        node3.helpDelete(node4, node5);
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    final Object value2 = predecessor.value;
                    BytecodeManager.incBytecodes(3);
                    if (value2 == null) {
                        break;
                    }
                    final Object o2 = value;
                    final Node<K, V> node6 = next;
                    BytecodeManager.incBytecodes(3);
                    if (o2 == node6) {
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    final Comparator<? super K> comparator3 = comparator;
                    final K key = next.key;
                    BytecodeManager.incBytecodes(5);
                    final int cpr = cpr(comparator3, o, key);
                    BytecodeManager.incBytecodes(3);
                    if (cpr == 0) {
                        final Node<K, V> node7 = next;
                        BytecodeManager.incBytecodes(2);
                        return node7;
                    }
                    final int n = cpr;
                    BytecodeManager.incBytecodes(2);
                    if (n < 0) {
                        BytecodeManager.incBytecodes(1);
                        break Label_0266;
                    }
                    predecessor = next;
                    BytecodeManager.incBytecodes(2);
                    next = next2;
                    BytecodeManager.incBytecodes(2);
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
            }
            final Node<K, V> node8 = null;
            BytecodeManager.incBytecodes(2);
            return node8;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private V doGet(final Object o) {
        try {
            BytecodeManager.incBytecodes(2);
            if (o == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final Comparator<? super K> comparator = this.comparator;
            BytecodeManager.incBytecodes(3);
        Label_0275:
            while (true) {
                final Comparator<? super K> comparator2 = comparator;
                BytecodeManager.incBytecodes(4);
                Node<K, V> predecessor = this.findPredecessor(o, comparator2);
                Node<K, V> next = predecessor.next;
                BytecodeManager.incBytecodes(4);
                while (true) {
                    final Node<K, V> node = next;
                    BytecodeManager.incBytecodes(2);
                    if (node == null) {
                        BytecodeManager.incBytecodes(1);
                        break Label_0275;
                    }
                    final Node<K, V> next2 = next.next;
                    BytecodeManager.incBytecodes(3);
                    final Node<K, V> node2 = next;
                    final Node<K, V> next3 = predecessor.next;
                    BytecodeManager.incBytecodes(4);
                    if (node2 != next3) {
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    final Object value;
                    final Object o2 = value = next.value;
                    BytecodeManager.incBytecodes(5);
                    if (o2 == null) {
                        final Node<K, V> node3 = next;
                        final Node<K, V> node4 = predecessor;
                        final Node<K, V> node5 = next2;
                        BytecodeManager.incBytecodes(4);
                        node3.helpDelete(node4, node5);
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    final Object value2 = predecessor.value;
                    BytecodeManager.incBytecodes(3);
                    if (value2 == null) {
                        break;
                    }
                    final Object o3 = value;
                    final Node<K, V> node6 = next;
                    BytecodeManager.incBytecodes(3);
                    if (o3 == node6) {
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    final Comparator<? super K> comparator3 = comparator;
                    final K key = next.key;
                    BytecodeManager.incBytecodes(5);
                    final int cpr = cpr(comparator3, o, key);
                    BytecodeManager.incBytecodes(3);
                    if (cpr == 0) {
                        final Node<K, V> node7 = (Node<K, V>)value;
                        BytecodeManager.incBytecodes(2);
                        final Node<K, V> node8 = node7;
                        BytecodeManager.incBytecodes(2);
                        return (V)node8;
                    }
                    final int n = cpr;
                    BytecodeManager.incBytecodes(2);
                    if (n < 0) {
                        BytecodeManager.incBytecodes(1);
                        break Label_0275;
                    }
                    predecessor = next;
                    BytecodeManager.incBytecodes(2);
                    next = next2;
                    BytecodeManager.incBytecodes(2);
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
            }
            final V v = null;
            BytecodeManager.incBytecodes(2);
            return v;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private V doPut(final K k, final V v, final boolean b) {
        try {
            BytecodeManager.incBytecodes(2);
            if (k == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final Comparator<? super K> comparator = this.comparator;
            BytecodeManager.incBytecodes(3);
            Node node10 = null;
            Label_0351: {
                Object value = null;
            Label_0273:
                while (true) {
                    final Comparator<? super K> comparator2 = comparator;
                    BytecodeManager.incBytecodes(4);
                    Node<K, V> predecessor = this.findPredecessor(k, comparator2);
                    Node<K, V> next = predecessor.next;
                    BytecodeManager.incBytecodes(4);
                    Label_0343: {
                        while (true) {
                            final Node<K, V> node = next;
                            BytecodeManager.incBytecodes(2);
                            if (node == null) {
                                break;
                            }
                            final Node<K, V> next2 = next.next;
                            BytecodeManager.incBytecodes(3);
                            final Node<K, V> node2 = next;
                            final Node<K, V> next3 = predecessor.next;
                            BytecodeManager.incBytecodes(4);
                            if (node2 != next3) {
                                BytecodeManager.incBytecodes(1);
                                break Label_0343;
                            }
                            final Object o = value = next.value;
                            BytecodeManager.incBytecodes(5);
                            if (o == null) {
                                final Node<K, V> node3 = next;
                                final Node<K, V> node4 = predecessor;
                                final Node<K, V> node5 = next2;
                                BytecodeManager.incBytecodes(4);
                                node3.helpDelete(node4, node5);
                                BytecodeManager.incBytecodes(1);
                                break Label_0343;
                            }
                            final Object value2 = predecessor.value;
                            BytecodeManager.incBytecodes(3);
                            if (value2 == null) {
                                break Label_0343;
                            }
                            final Object o2 = value;
                            final Node<K, V> node6 = next;
                            BytecodeManager.incBytecodes(3);
                            if (o2 == node6) {
                                BytecodeManager.incBytecodes(1);
                                break Label_0343;
                            }
                            final Comparator<? super K> comparator3 = comparator;
                            final K key = next.key;
                            BytecodeManager.incBytecodes(5);
                            final int cpr = cpr(comparator3, k, key);
                            BytecodeManager.incBytecodes(3);
                            if (cpr > 0) {
                                predecessor = next;
                                BytecodeManager.incBytecodes(2);
                                next = next2;
                                BytecodeManager.incBytecodes(2);
                                BytecodeManager.incBytecodes(1);
                            }
                            else {
                                final int n = cpr;
                                BytecodeManager.incBytecodes(2);
                                if (n != 0) {
                                    break;
                                }
                                BytecodeManager.incBytecodes(2);
                                if (b) {
                                    break Label_0273;
                                }
                                final Node<K, V> node7 = next;
                                final Node<K, V> node8 = (Node<K, V>)value;
                                BytecodeManager.incBytecodes(4);
                                final boolean casValue = node7.casValue(node8, v);
                                BytecodeManager.incBytecodes(1);
                                if (casValue) {
                                    break Label_0273;
                                }
                                break Label_0343;
                            }
                        }
                        final Node<Object, Object> node9 = (Node<Object, Object>)next;
                        BytecodeManager.incBytecodes(6);
                        node10 = new Node<K, V>(k, v, node9);
                        BytecodeManager.incBytecodes(1);
                        final Node<K, V> node11 = predecessor;
                        final Node<K, V> node12 = next;
                        final Node node13 = node10;
                        BytecodeManager.incBytecodes(4);
                        final boolean casNext = node11.casNext(node12, node13);
                        BytecodeManager.incBytecodes(1);
                        if (casNext) {
                            break Label_0351;
                        }
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(1);
                }
                final Node<K, V> node14 = (Node<K, V>)value;
                BytecodeManager.incBytecodes(2);
                final Node<K, V> node15 = node14;
                BytecodeManager.incBytecodes(2);
                return (V)node15;
            }
            BytecodeManager.incBytecodes(1);
            int nextSecondarySeed = ThreadLocalRandom.nextSecondarySeed();
            BytecodeManager.incBytecodes(1);
            final int n2 = nextSecondarySeed & 0x80000001;
            BytecodeManager.incBytecodes(4);
            Label_1184: {
                if (n2 == 0) {
                    int n3 = 1;
                    BytecodeManager.incBytecodes(2);
                    while (true) {
                        final int n4 = (nextSecondarySeed >>>= 1) & 0x1;
                        BytecodeManager.incBytecodes(8);
                        if (n4 == 0) {
                            break;
                        }
                        ++n3;
                        BytecodeManager.incBytecodes(2);
                    }
                    Index<K, V> index = null;
                    BytecodeManager.incBytecodes(2);
                    HeadIndex<K, V> headIndex = this.head;
                    BytecodeManager.incBytecodes(3);
                    final int n5 = n3;
                    final int level = headIndex.level;
                    BytecodeManager.incBytecodes(6);
                    if (n5 <= level) {
                        int n6 = 1;
                        BytecodeManager.incBytecodes(2);
                        while (true) {
                            final int n7 = n6;
                            final int n8 = n3;
                            BytecodeManager.incBytecodes(3);
                            if (n7 > n8) {
                                break;
                            }
                            final Node node16 = node10;
                            final Index<Object, Object> index2 = (Index<Object, Object>)index;
                            final Index<K, V> index3 = null;
                            BytecodeManager.incBytecodes(6);
                            index = (Index<K, V>)new Index<Object, Object>(node16, index2, (Index<Object, Object>)index3);
                            BytecodeManager.incBytecodes(1);
                            ++n6;
                            BytecodeManager.incBytecodes(2);
                        }
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        n3 = level + 1;
                        BytecodeManager.incBytecodes(4);
                        final Index[] array = new Index[n3 + 1];
                        BytecodeManager.incBytecodes(5);
                        int n9 = 1;
                        BytecodeManager.incBytecodes(2);
                        while (true) {
                            final int n10 = n9;
                            final int n11 = n3;
                            BytecodeManager.incBytecodes(3);
                            if (n10 > n11) {
                                break;
                            }
                            final Index[] array2 = array;
                            final int n12 = n9;
                            final Node node17 = node10;
                            final Index<Object, Object> index4 = (Index<Object, Object>)index;
                            final Index<Object, Object> index5 = null;
                            BytecodeManager.incBytecodes(8);
                            index = (Index<K, V>)(array2[n12] = new Index(node17, index4, index5));
                            BytecodeManager.incBytecodes(3);
                            ++n9;
                            BytecodeManager.incBytecodes(2);
                        }
                        while (true) {
                            headIndex = this.head;
                            BytecodeManager.incBytecodes(3);
                            final int level2 = headIndex.level;
                            BytecodeManager.incBytecodes(3);
                            final int n13 = n3;
                            final int n14 = level2;
                            BytecodeManager.incBytecodes(3);
                            if (n13 <= n14) {
                                BytecodeManager.incBytecodes(1);
                                break;
                            }
                            HeadIndex<K, V> headIndex2 = headIndex;
                            BytecodeManager.incBytecodes(2);
                            final Node<K, V> node18 = headIndex.node;
                            BytecodeManager.incBytecodes(3);
                            int n15 = level2 + 1;
                            BytecodeManager.incBytecodes(4);
                            while (true) {
                                final int n16 = n15;
                                final int n17 = n3;
                                BytecodeManager.incBytecodes(3);
                                if (n16 > n17) {
                                    break;
                                }
                                final Node<K, V> node19 = node18;
                                final HeadIndex<K, V> headIndex3 = headIndex2;
                                final Index index6 = array[n15];
                                final int n18 = n15;
                                BytecodeManager.incBytecodes(9);
                                headIndex2 = new HeadIndex<K, V>((Node<Object, Object>)node19, (Index<Object, Object>)headIndex3, index6, n18);
                                BytecodeManager.incBytecodes(1);
                                ++n15;
                                BytecodeManager.incBytecodes(2);
                            }
                            final HeadIndex<K, V> headIndex4 = headIndex;
                            final HeadIndex<K, V> headIndex5 = headIndex2;
                            BytecodeManager.incBytecodes(4);
                            final boolean casHead = this.casHead(headIndex4, headIndex5);
                            BytecodeManager.incBytecodes(1);
                            if (casHead) {
                                headIndex = headIndex2;
                                BytecodeManager.incBytecodes(2);
                                index = (Index<K, V>)array[n3 = level2];
                                BytecodeManager.incBytecodes(6);
                                BytecodeManager.incBytecodes(1);
                                break;
                            }
                            BytecodeManager.incBytecodes(1);
                        }
                    }
                    int n19 = n3;
                    BytecodeManager.incBytecodes(2);
                    while (true) {
                        int level3 = headIndex.level;
                        BytecodeManager.incBytecodes(3);
                        Index<K, V> down = headIndex;
                        Index<K, V> index7 = down.right;
                        Index<K, V> down2 = index;
                        BytecodeManager.incBytecodes(7);
                        while (true) {
                            final Index<K, V> index8 = down;
                            BytecodeManager.incBytecodes(2);
                            if (index8 == null) {
                                break Label_1184;
                            }
                            final Index<K, V> index9 = down2;
                            BytecodeManager.incBytecodes(2);
                            if (index9 == null) {
                                BytecodeManager.incBytecodes(1);
                                break Label_1184;
                            }
                            final Index<K, V> index10 = index7;
                            BytecodeManager.incBytecodes(2);
                            Label_1176: {
                                if (index10 != null) {
                                    final Node<K, V> node20 = index7.node;
                                    BytecodeManager.incBytecodes(3);
                                    final Comparator<? super K> comparator4 = comparator;
                                    final K key2 = node20.key;
                                    BytecodeManager.incBytecodes(5);
                                    final int cpr2 = cpr(comparator4, k, key2);
                                    BytecodeManager.incBytecodes(1);
                                    final Object value3 = node20.value;
                                    BytecodeManager.incBytecodes(3);
                                    if (value3 == null) {
                                        final Index<K, V> index11 = down;
                                        final Index<K, V> index12 = index7;
                                        BytecodeManager.incBytecodes(3);
                                        final boolean unlink = index11.unlink(index12);
                                        BytecodeManager.incBytecodes(1);
                                        if (!unlink) {
                                            BytecodeManager.incBytecodes(1);
                                            break Label_1176;
                                        }
                                        index7 = down.right;
                                        BytecodeManager.incBytecodes(3);
                                        BytecodeManager.incBytecodes(1);
                                        continue;
                                    }
                                    else {
                                        final int n20 = cpr2;
                                        BytecodeManager.incBytecodes(2);
                                        if (n20 > 0) {
                                            down = index7;
                                            BytecodeManager.incBytecodes(2);
                                            index7 = index7.right;
                                            BytecodeManager.incBytecodes(3);
                                            BytecodeManager.incBytecodes(1);
                                            continue;
                                        }
                                    }
                                }
                                final int n21 = level3;
                                final int n22 = n19;
                                BytecodeManager.incBytecodes(3);
                                if (n21 == n22) {
                                    final Index<K, V> index13 = down;
                                    final Index<K, V> index14 = index7;
                                    final Index<K, V> index15 = down2;
                                    BytecodeManager.incBytecodes(4);
                                    final boolean link = index13.link(index14, index15);
                                    BytecodeManager.incBytecodes(1);
                                    if (!link) {
                                        BytecodeManager.incBytecodes(1);
                                        break Label_1176;
                                    }
                                    final Object value4 = down2.node.value;
                                    BytecodeManager.incBytecodes(4);
                                    if (value4 == null) {
                                        BytecodeManager.incBytecodes(3);
                                        this.findNode(k);
                                        BytecodeManager.incBytecodes(1);
                                        BytecodeManager.incBytecodes(1);
                                        break Label_1184;
                                    }
                                    final int n23 = --n19;
                                    BytecodeManager.incBytecodes(3);
                                    if (n23 == 0) {
                                        BytecodeManager.incBytecodes(1);
                                        break Label_1184;
                                    }
                                }
                                final int n24 = --level3;
                                final int n25 = n19;
                                BytecodeManager.incBytecodes(4);
                                if (n24 >= n25) {
                                    final int n26 = level3;
                                    final int n27 = n3;
                                    BytecodeManager.incBytecodes(3);
                                    if (n26 < n27) {
                                        down2 = down2.down;
                                        BytecodeManager.incBytecodes(3);
                                    }
                                }
                                down = down.down;
                                BytecodeManager.incBytecodes(3);
                                index7 = down.right;
                                BytecodeManager.incBytecodes(4);
                                continue;
                            }
                            BytecodeManager.incBytecodes(1);
                            break;
                        }
                    }
                }
            }
            final V v2 = null;
            BytecodeManager.incBytecodes(2);
            return v2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final V doRemove(final Object o, final Object o2) {
        try {
            BytecodeManager.incBytecodes(2);
            if (o == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final Comparator<? super K> comparator = this.comparator;
            BytecodeManager.incBytecodes(3);
        Label_0448:
            while (true) {
                final Comparator<? super K> comparator2 = comparator;
                BytecodeManager.incBytecodes(4);
                Node<K, V> predecessor = this.findPredecessor(o, comparator2);
                Node<K, V> next = predecessor.next;
                BytecodeManager.incBytecodes(4);
                while (true) {
                    final Node<K, V> node = next;
                    BytecodeManager.incBytecodes(2);
                    if (node == null) {
                        BytecodeManager.incBytecodes(1);
                        break Label_0448;
                    }
                    final Node<K, V> next2 = next.next;
                    BytecodeManager.incBytecodes(3);
                    final Node<K, V> node2 = next;
                    final Node<K, V> next3 = predecessor.next;
                    BytecodeManager.incBytecodes(4);
                    if (node2 != next3) {
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    final Object value;
                    final Object o3 = value = next.value;
                    BytecodeManager.incBytecodes(5);
                    if (o3 == null) {
                        final Node<K, V> node3 = next;
                        final Node<K, V> node4 = predecessor;
                        final Node<K, V> node5 = next2;
                        BytecodeManager.incBytecodes(4);
                        node3.helpDelete(node4, node5);
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    final Object value2 = predecessor.value;
                    BytecodeManager.incBytecodes(3);
                    if (value2 == null) {
                        break;
                    }
                    final Object o4 = value;
                    final Node<K, V> node6 = next;
                    BytecodeManager.incBytecodes(3);
                    if (o4 == node6) {
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    final Comparator<? super K> comparator3 = comparator;
                    final K key = next.key;
                    BytecodeManager.incBytecodes(5);
                    final int cpr = cpr(comparator3, o, key);
                    BytecodeManager.incBytecodes(3);
                    if (cpr < 0) {
                        BytecodeManager.incBytecodes(1);
                        break Label_0448;
                    }
                    final int n = cpr;
                    BytecodeManager.incBytecodes(2);
                    if (n > 0) {
                        predecessor = next;
                        BytecodeManager.incBytecodes(2);
                        next = next2;
                        BytecodeManager.incBytecodes(2);
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        BytecodeManager.incBytecodes(2);
                        if (o2 != null) {
                            final Node<K, V> obj = (Node<K, V>)value;
                            BytecodeManager.incBytecodes(3);
                            final boolean equals = o2.equals(obj);
                            BytecodeManager.incBytecodes(1);
                            if (!equals) {
                                BytecodeManager.incBytecodes(1);
                                break Label_0448;
                            }
                        }
                        final Node<K, V> node7 = next;
                        final Node<K, V> node8 = (Node<K, V>)value;
                        final Object o5 = null;
                        BytecodeManager.incBytecodes(4);
                        final boolean casValue = node7.casValue(node8, o5);
                        BytecodeManager.incBytecodes(1);
                        if (!casValue) {
                            BytecodeManager.incBytecodes(1);
                            break;
                        }
                        final Node<K, V> node9 = next;
                        final Node<K, V> node10 = next2;
                        BytecodeManager.incBytecodes(3);
                        final boolean appendMarker = node9.appendMarker(node10);
                        BytecodeManager.incBytecodes(1);
                        Label_0423: {
                            if (appendMarker) {
                                final Node<K, V> node11 = predecessor;
                                final Node<K, V> node12 = next;
                                final Node<K, V> node13 = next2;
                                BytecodeManager.incBytecodes(4);
                                final boolean casNext = node11.casNext(node12, node13);
                                BytecodeManager.incBytecodes(1);
                                if (casNext) {
                                    final Comparator<? super K> comparator4 = comparator;
                                    BytecodeManager.incBytecodes(4);
                                    this.findPredecessor(o, comparator4);
                                    BytecodeManager.incBytecodes(1);
                                    final Index<K, V> right = this.head.right;
                                    BytecodeManager.incBytecodes(4);
                                    if (right == null) {
                                        BytecodeManager.incBytecodes(2);
                                        this.tryReduceLevel();
                                    }
                                    break Label_0423;
                                }
                            }
                            BytecodeManager.incBytecodes(3);
                            this.findNode(o);
                            BytecodeManager.incBytecodes(2);
                        }
                        final Node<K, V> node14 = (Node<K, V>)value;
                        BytecodeManager.incBytecodes(2);
                        final Node<K, V> node15 = node14;
                        BytecodeManager.incBytecodes(2);
                        return (V)node15;
                    }
                }
                BytecodeManager.incBytecodes(1);
            }
            final V v = null;
            BytecodeManager.incBytecodes(2);
            return v;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void tryReduceLevel() {
        try {
            final HeadIndex<K, V> head = this.head;
            BytecodeManager.incBytecodes(3);
            final int level = head.level;
            final int n = 3;
            BytecodeManager.incBytecodes(4);
            if (level > n) {
                final HeadIndex headIndex2;
                final HeadIndex headIndex = headIndex2 = (HeadIndex)head.down;
                BytecodeManager.incBytecodes(6);
                if (headIndex != null) {
                    final HeadIndex headIndex3 = (HeadIndex)headIndex2.down;
                    BytecodeManager.incBytecodes(6);
                    if (headIndex3 != null) {
                        final Index<K, V> right = headIndex3.right;
                        BytecodeManager.incBytecodes(3);
                        if (right == null) {
                            final Index<K, V> right2 = headIndex2.right;
                            BytecodeManager.incBytecodes(3);
                            if (right2 == null) {
                                final Index<K, V> right3 = head.right;
                                BytecodeManager.incBytecodes(3);
                                if (right3 == null) {
                                    final HeadIndex<K, V> headIndex4 = head;
                                    final HeadIndex headIndex5 = headIndex2;
                                    BytecodeManager.incBytecodes(3);
                                    BytecodeManager.incBytecodes(1);
                                    final boolean casHead = this.casHead(headIndex4, headIndex5);
                                    BytecodeManager.incBytecodes(1);
                                    if (casHead) {
                                        final Index<K, V> right4 = head.right;
                                        BytecodeManager.incBytecodes(3);
                                        if (right4 != null) {
                                            final HeadIndex headIndex6 = headIndex2;
                                            final HeadIndex<K, V> headIndex7 = head;
                                            BytecodeManager.incBytecodes(4);
                                            this.casHead(headIndex6, headIndex7);
                                            BytecodeManager.incBytecodes(1);
                                        }
                                    }
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
    
    final Node<K, V> findFirst() {
        try {
            while (true) {
                final Node<K, V> node2;
                final Node<K, V> next;
                final Node<K, V> node = next = (node2 = this.head.node).next;
                BytecodeManager.incBytecodes(9);
                if (node == null) {
                    final Node<K, V> node3 = null;
                    BytecodeManager.incBytecodes(2);
                    return node3;
                }
                final Object value = next.value;
                BytecodeManager.incBytecodes(3);
                if (value != null) {
                    final Node<K, V> node4 = next;
                    BytecodeManager.incBytecodes(2);
                    return node4;
                }
                final Node<K, V> node5 = next;
                final Node<K, V> node6 = node2;
                final Node<K, V> next2 = next.next;
                BytecodeManager.incBytecodes(5);
                node5.helpDelete(node6, next2);
                BytecodeManager.incBytecodes(1);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private Map.Entry<K, V> doRemoveFirstEntry() {
        try {
            while (true) {
                final Node<K, V> node2;
                final Node<K, V> next;
                final Node<K, V> node = next = (node2 = this.head.node).next;
                BytecodeManager.incBytecodes(9);
                if (node == null) {
                    final Map.Entry<K, V> entry = null;
                    BytecodeManager.incBytecodes(2);
                    return entry;
                }
                final Node<K, V> next2 = next.next;
                BytecodeManager.incBytecodes(3);
                final Node<K, V> node3 = next;
                final Node<K, V> next3 = node2.next;
                BytecodeManager.incBytecodes(4);
                if (node3 != next3) {
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    final Object value = next.value;
                    BytecodeManager.incBytecodes(3);
                    final Object o = value;
                    BytecodeManager.incBytecodes(2);
                    if (o == null) {
                        final Node<K, V> node4 = next;
                        final Node<K, V> node5 = node2;
                        final Node<K, V> node6 = next2;
                        BytecodeManager.incBytecodes(4);
                        node4.helpDelete(node5, node6);
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        final Node<K, V> node7 = next;
                        final Object o2 = value;
                        final Object o3 = null;
                        BytecodeManager.incBytecodes(4);
                        final boolean casValue = node7.casValue(o2, o3);
                        BytecodeManager.incBytecodes(1);
                        if (casValue) {
                            final Node<K, V> node8 = next;
                            final Node<K, V> node9 = next2;
                            BytecodeManager.incBytecodes(3);
                            final boolean appendMarker = node8.appendMarker(node9);
                            BytecodeManager.incBytecodes(1);
                            Label_0180: {
                                if (appendMarker) {
                                    final Node<K, V> node10 = node2;
                                    final Node<K, V> node11 = next;
                                    final Node<K, V> node12 = next2;
                                    BytecodeManager.incBytecodes(4);
                                    final boolean casNext = node10.casNext(node11, node12);
                                    BytecodeManager.incBytecodes(1);
                                    if (casNext) {
                                        break Label_0180;
                                    }
                                }
                                BytecodeManager.incBytecodes(2);
                                this.findFirst();
                                BytecodeManager.incBytecodes(1);
                            }
                            BytecodeManager.incBytecodes(2);
                            this.clearIndexToFirst();
                            final Object o4 = value;
                            BytecodeManager.incBytecodes(2);
                            final K key = next.key;
                            final V v = (V)o4;
                            BytecodeManager.incBytecodes(6);
                            final SimpleImmutableEntry simpleImmutableEntry = new SimpleImmutableEntry<K, V>(key, v);
                            BytecodeManager.incBytecodes(1);
                            return (Map.Entry<K, V>)simpleImmutableEntry;
                        }
                        BytecodeManager.incBytecodes(1);
                    }
                }
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void clearIndexToFirst() {
        try {
        Block_4:
            while (true) {
                Index<K, V> index = this.head;
                BytecodeManager.incBytecodes(3);
                while (true) {
                    final Index<K, V> right = index.right;
                    BytecodeManager.incBytecodes(3);
                    final Index<K, V> index2 = right;
                    BytecodeManager.incBytecodes(2);
                    if (index2 != null) {
                        final Index<K, V> index3 = right;
                        BytecodeManager.incBytecodes(2);
                        final boolean indexesDeletedNode = index3.indexesDeletedNode();
                        BytecodeManager.incBytecodes(1);
                        if (indexesDeletedNode) {
                            final Index<K, V> index4 = index;
                            final Index<K, V> index5 = right;
                            BytecodeManager.incBytecodes(3);
                            final boolean unlink = index4.unlink(index5);
                            BytecodeManager.incBytecodes(1);
                            if (!unlink) {
                                BytecodeManager.incBytecodes(1);
                                BytecodeManager.incBytecodes(1);
                                break;
                            }
                        }
                    }
                    final Index<K, V> index6 = index = index.down;
                    BytecodeManager.incBytecodes(5);
                    if (index6 == null) {
                        break Block_4;
                    }
                    BytecodeManager.incBytecodes(1);
                }
            }
            final Index<K, V> right2 = this.head.right;
            BytecodeManager.incBytecodes(4);
            if (right2 == null) {
                BytecodeManager.incBytecodes(2);
                this.tryReduceLevel();
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private Map.Entry<K, V> doRemoveLastEntry() {
        try {
            while (true) {
                BytecodeManager.incBytecodes(2);
                Node<K, V> predecessorOfLast = this.findPredecessorOfLast();
                BytecodeManager.incBytecodes(1);
                Node<K, V> next = predecessorOfLast.next;
                BytecodeManager.incBytecodes(3);
                final Node<K, V> node = next;
                BytecodeManager.incBytecodes(2);
                if (node == null) {
                    final Node<K, V> node2 = predecessorOfLast;
                    BytecodeManager.incBytecodes(2);
                    final boolean baseHeader = node2.isBaseHeader();
                    BytecodeManager.incBytecodes(1);
                    if (baseHeader) {
                        final Map.Entry<K, V> entry = null;
                        BytecodeManager.incBytecodes(2);
                        return entry;
                    }
                    continue;
                }
                else {
                    while (true) {
                        final Node<K, V> next2 = next.next;
                        BytecodeManager.incBytecodes(3);
                        final Node<K, V> node3 = next;
                        final Node<K, V> next3 = predecessorOfLast.next;
                        BytecodeManager.incBytecodes(4);
                        if (node3 != next3) {
                            BytecodeManager.incBytecodes(1);
                            break;
                        }
                        final Object value = next.value;
                        BytecodeManager.incBytecodes(3);
                        final Object o = value;
                        BytecodeManager.incBytecodes(2);
                        if (o == null) {
                            final Node<K, V> node4 = next;
                            final Node<K, V> node5 = predecessorOfLast;
                            final Node<K, V> node6 = next2;
                            BytecodeManager.incBytecodes(4);
                            node4.helpDelete(node5, node6);
                            BytecodeManager.incBytecodes(1);
                            break;
                        }
                        final Object value2 = predecessorOfLast.value;
                        BytecodeManager.incBytecodes(3);
                        if (value2 == null) {
                            break;
                        }
                        final Object o2 = value;
                        final Node<K, V> node7 = next;
                        BytecodeManager.incBytecodes(3);
                        if (o2 == node7) {
                            BytecodeManager.incBytecodes(1);
                            break;
                        }
                        final Node<K, V> node8 = next2;
                        BytecodeManager.incBytecodes(2);
                        if (node8 != null) {
                            predecessorOfLast = next;
                            BytecodeManager.incBytecodes(2);
                            next = next2;
                            BytecodeManager.incBytecodes(2);
                            BytecodeManager.incBytecodes(1);
                        }
                        else {
                            final Node<K, V> node9 = next;
                            final Node<K, V> node10 = (Node<K, V>)value;
                            final Object o3 = null;
                            BytecodeManager.incBytecodes(4);
                            final boolean casValue = node9.casValue(node10, o3);
                            BytecodeManager.incBytecodes(1);
                            if (!casValue) {
                                BytecodeManager.incBytecodes(1);
                                break;
                            }
                            final K key = next.key;
                            BytecodeManager.incBytecodes(3);
                            final Node<K, V> node11 = next;
                            final Node<K, V> node12 = next2;
                            BytecodeManager.incBytecodes(3);
                            final boolean appendMarker = node11.appendMarker(node12);
                            BytecodeManager.incBytecodes(1);
                            Label_0332: {
                                if (appendMarker) {
                                    final Node<K, V> node13 = predecessorOfLast;
                                    final Node<K, V> node14 = next;
                                    final Node<K, V> node15 = next2;
                                    BytecodeManager.incBytecodes(4);
                                    final boolean casNext = node13.casNext(node14, node15);
                                    BytecodeManager.incBytecodes(1);
                                    if (casNext) {
                                        final K k = key;
                                        final Comparator<? super K> comparator = this.comparator;
                                        BytecodeManager.incBytecodes(5);
                                        this.findPredecessor(k, comparator);
                                        BytecodeManager.incBytecodes(1);
                                        final Index<K, V> right = this.head.right;
                                        BytecodeManager.incBytecodes(4);
                                        if (right == null) {
                                            BytecodeManager.incBytecodes(2);
                                            this.tryReduceLevel();
                                        }
                                        break Label_0332;
                                    }
                                }
                                final K i = key;
                                BytecodeManager.incBytecodes(3);
                                this.findNode(i);
                                BytecodeManager.incBytecodes(2);
                            }
                            final Node<K, V> node16 = (Node<K, V>)value;
                            BytecodeManager.incBytecodes(2);
                            final K j = key;
                            final Node<K, V> node17 = node16;
                            BytecodeManager.incBytecodes(5);
                            final SimpleImmutableEntry simpleImmutableEntry = new SimpleImmutableEntry<K, V>(j, node17);
                            BytecodeManager.incBytecodes(1);
                            return (Map.Entry<K, V>)simpleImmutableEntry;
                        }
                    }
                    BytecodeManager.incBytecodes(1);
                }
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final Node<K, V> findLast() {
        try {
            Index<K, V> index = this.head;
            BytecodeManager.incBytecodes(3);
            Node<K, V> node = null;
        Block_5:
            while (true) {
                final Index<K, V> right;
                final Index<K, V> index2 = right = index.right;
                BytecodeManager.incBytecodes(5);
                if (index2 != null) {
                    final Index<K, V> index3 = right;
                    BytecodeManager.incBytecodes(2);
                    final boolean indexesDeletedNode = index3.indexesDeletedNode();
                    BytecodeManager.incBytecodes(1);
                    if (indexesDeletedNode) {
                        final Index<K, V> index4 = index;
                        final Index<K, V> index5 = right;
                        BytecodeManager.incBytecodes(3);
                        index4.unlink(index5);
                        BytecodeManager.incBytecodes(1);
                        index = this.head;
                        BytecodeManager.incBytecodes(4);
                    }
                    else {
                        index = right;
                        BytecodeManager.incBytecodes(3);
                    }
                }
                else {
                    final Index<K, V> down = index.down;
                    BytecodeManager.incBytecodes(5);
                    if (down != null) {
                        index = down;
                        BytecodeManager.incBytecodes(3);
                    }
                    else {
                        node = index.node;
                        Node<K, V> next = node.next;
                        BytecodeManager.incBytecodes(6);
                        while (true) {
                            final Node<K, V> node2 = next;
                            BytecodeManager.incBytecodes(2);
                            if (node2 == null) {
                                break Block_5;
                            }
                            final Node<K, V> next2 = next.next;
                            BytecodeManager.incBytecodes(3);
                            final Node<K, V> node3 = next;
                            final Node<K, V> next3 = node.next;
                            BytecodeManager.incBytecodes(4);
                            if (node3 != next3) {
                                BytecodeManager.incBytecodes(1);
                                break;
                            }
                            final Object value = next.value;
                            BytecodeManager.incBytecodes(3);
                            final Object o = value;
                            BytecodeManager.incBytecodes(2);
                            if (o == null) {
                                final Node<K, V> node4 = next;
                                final Node<K, V> node5 = node;
                                final Node<K, V> node6 = next2;
                                BytecodeManager.incBytecodes(4);
                                node4.helpDelete(node5, node6);
                                BytecodeManager.incBytecodes(1);
                                break;
                            }
                            final Object value2 = node.value;
                            BytecodeManager.incBytecodes(3);
                            if (value2 == null) {
                                break;
                            }
                            final Object o2 = value;
                            final Node<K, V> node7 = next;
                            BytecodeManager.incBytecodes(3);
                            if (o2 == node7) {
                                BytecodeManager.incBytecodes(1);
                                break;
                            }
                            node = next;
                            BytecodeManager.incBytecodes(2);
                            next = next2;
                            BytecodeManager.incBytecodes(2);
                            BytecodeManager.incBytecodes(1);
                        }
                        index = this.head;
                        BytecodeManager.incBytecodes(3);
                    }
                }
                BytecodeManager.incBytecodes(1);
            }
            final Node<K, V> node8 = node;
            BytecodeManager.incBytecodes(2);
            final boolean baseHeader = node8.isBaseHeader();
            BytecodeManager.incBytecodes(1);
            Node<K, V> node9;
            if (baseHeader) {
                node9 = null;
                BytecodeManager.incBytecodes(2);
            }
            else {
                node9 = node;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return node9;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private Node<K, V> findPredecessorOfLast() {
        try {
            Index<K, V> head = null;
        Label_0119:
            while (true) {
                head = this.head;
                BytecodeManager.incBytecodes(3);
                while (true) {
                    final Index<K, V> right;
                    final Index<K, V> index = right = head.right;
                    BytecodeManager.incBytecodes(5);
                    if (index != null) {
                        final Index<K, V> index2 = right;
                        BytecodeManager.incBytecodes(2);
                        final boolean indexesDeletedNode = index2.indexesDeletedNode();
                        BytecodeManager.incBytecodes(1);
                        if (indexesDeletedNode) {
                            final Index<K, V> index3 = head;
                            final Index<K, V> index4 = right;
                            BytecodeManager.incBytecodes(3);
                            index3.unlink(index4);
                            BytecodeManager.incBytecodes(1);
                            BytecodeManager.incBytecodes(1);
                            BytecodeManager.incBytecodes(1);
                            break;
                        }
                        final Node<K, V> next = right.node.next;
                        BytecodeManager.incBytecodes(4);
                        if (next != null) {
                            head = right;
                            BytecodeManager.incBytecodes(2);
                            BytecodeManager.incBytecodes(1);
                            continue;
                        }
                    }
                    final Index<K, V> down = head.down;
                    BytecodeManager.incBytecodes(5);
                    if (down == null) {
                        break Label_0119;
                    }
                    head = down;
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(1);
                }
            }
            final Node<K, V> node = head.node;
            BytecodeManager.incBytecodes(3);
            return node;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final Node<K, V> findNear(final K k, final int n, final Comparator<? super K> comparator) {
        try {
            BytecodeManager.incBytecodes(2);
            if (k == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            Node<K, V> predecessor = null;
            Block_12: {
                Node<K, V> next = null;
            Label_0283:
                while (true) {
                    BytecodeManager.incBytecodes(4);
                    predecessor = this.findPredecessor(k, comparator);
                    next = predecessor.next;
                    BytecodeManager.incBytecodes(4);
                    while (true) {
                        final Node<K, V> node = next;
                        BytecodeManager.incBytecodes(2);
                        if (node == null) {
                            final int n2 = n & 0x2;
                            BytecodeManager.incBytecodes(4);
                            Node<K, V> node3 = null;
                            Label_0107: {
                                if (n2 != 0) {
                                    final Node<K, V> node2 = predecessor;
                                    BytecodeManager.incBytecodes(2);
                                    final boolean baseHeader = node2.isBaseHeader();
                                    BytecodeManager.incBytecodes(1);
                                    if (!baseHeader) {
                                        node3 = predecessor;
                                        BytecodeManager.incBytecodes(1);
                                        break Label_0107;
                                    }
                                }
                                node3 = null;
                                BytecodeManager.incBytecodes(2);
                            }
                            BytecodeManager.incBytecodes(1);
                            return node3;
                        }
                        final Node<K, V> next2 = next.next;
                        BytecodeManager.incBytecodes(3);
                        final Node<K, V> node4 = next;
                        final Node<K, V> next3 = predecessor.next;
                        BytecodeManager.incBytecodes(4);
                        if (node4 != next3) {
                            BytecodeManager.incBytecodes(1);
                            break;
                        }
                        final Object value = next.value;
                        BytecodeManager.incBytecodes(5);
                        if (value == null) {
                            final Node<K, V> node5 = next;
                            final Node<K, V> node6 = predecessor;
                            final Node<K, V> node7 = next2;
                            BytecodeManager.incBytecodes(4);
                            node5.helpDelete(node6, node7);
                            BytecodeManager.incBytecodes(1);
                            break;
                        }
                        final Object value2 = predecessor.value;
                        BytecodeManager.incBytecodes(3);
                        if (value2 == null) {
                            break;
                        }
                        final Object o = value;
                        final Node<K, V> node8 = next;
                        BytecodeManager.incBytecodes(3);
                        if (o == node8) {
                            BytecodeManager.incBytecodes(1);
                            break;
                        }
                        final K key = next.key;
                        BytecodeManager.incBytecodes(5);
                        final int cpr = cpr(comparator, k, key);
                        BytecodeManager.incBytecodes(1);
                        final int n3 = cpr;
                        BytecodeManager.incBytecodes(2);
                        if (n3 == 0) {
                            final int n4 = n & 0x1;
                            BytecodeManager.incBytecodes(4);
                            if (n4 != 0) {
                                break Label_0283;
                            }
                        }
                        final int n5 = cpr;
                        BytecodeManager.incBytecodes(2);
                        if (n5 < 0) {
                            final int n6 = n & 0x2;
                            BytecodeManager.incBytecodes(4);
                            if (n6 == 0) {
                                break Label_0283;
                            }
                        }
                        final int n7 = cpr;
                        BytecodeManager.incBytecodes(2);
                        if (n7 <= 0) {
                            final int n8 = n & 0x2;
                            BytecodeManager.incBytecodes(4);
                            if (n8 != 0) {
                                break Block_12;
                            }
                        }
                        predecessor = next;
                        BytecodeManager.incBytecodes(2);
                        next = next2;
                        BytecodeManager.incBytecodes(2);
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(1);
                }
                final Node<K, V> node9 = next;
                BytecodeManager.incBytecodes(2);
                return node9;
            }
            final Node<K, V> node10 = predecessor;
            BytecodeManager.incBytecodes(2);
            final boolean baseHeader2 = node10.isBaseHeader();
            BytecodeManager.incBytecodes(1);
            Node<K, V> node11;
            if (baseHeader2) {
                node11 = null;
                BytecodeManager.incBytecodes(2);
            }
            else {
                node11 = predecessor;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return node11;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final SimpleImmutableEntry<K, V> getNear(final K k, final int n) {
        try {
            final Comparator<? super K> comparator = this.comparator;
            BytecodeManager.incBytecodes(3);
            while (true) {
                final Comparator<? super K> comparator2 = comparator;
                BytecodeManager.incBytecodes(5);
                final Node<K, V> near = this.findNear(k, n, comparator2);
                BytecodeManager.incBytecodes(1);
                final Node<K, V> node = near;
                BytecodeManager.incBytecodes(2);
                if (node == null) {
                    final SimpleImmutableEntry<K, V> simpleImmutableEntry = null;
                    BytecodeManager.incBytecodes(2);
                    return simpleImmutableEntry;
                }
                final Node<K, V> node2 = near;
                BytecodeManager.incBytecodes(2);
                final SimpleImmutableEntry<K, V> snapshot = node2.createSnapshot();
                BytecodeManager.incBytecodes(1);
                final SimpleImmutableEntry<K, V> simpleImmutableEntry2 = snapshot;
                BytecodeManager.incBytecodes(2);
                if (simpleImmutableEntry2 != null) {
                    final SimpleImmutableEntry<K, V> simpleImmutableEntry3 = snapshot;
                    BytecodeManager.incBytecodes(2);
                    return simpleImmutableEntry3;
                }
                BytecodeManager.incBytecodes(1);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public ConcurrentSkipListMap() {
        try {
            BytecodeManager.incBytecodes(2);
            this.comparator = null;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(2);
            this.initialize();
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public ConcurrentSkipListMap(final Comparator<? super K> comparator) {
        try {
            BytecodeManager.incBytecodes(2);
            this.comparator = comparator;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(2);
            this.initialize();
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public ConcurrentSkipListMap(final Map<? extends K, ? extends V> map) {
        try {
            BytecodeManager.incBytecodes(2);
            this.comparator = null;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(2);
            this.initialize();
            BytecodeManager.incBytecodes(3);
            this.putAll(map);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public ConcurrentSkipListMap(final SortedMap<K, ? extends V> sortedMap) {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(3);
            this.comparator = sortedMap.comparator();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            this.initialize();
            BytecodeManager.incBytecodes(3);
            this.buildFromSorted(sortedMap);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public ConcurrentSkipListMap<K, V> clone() {
        try {
            try {
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                final ConcurrentSkipListMap concurrentSkipListMap = (ConcurrentSkipListMap)super.clone();
                BytecodeManager.incBytecodes(2);
                final ConcurrentSkipListMap concurrentSkipListMap2 = concurrentSkipListMap;
                BytecodeManager.incBytecodes(2);
                concurrentSkipListMap2.initialize();
                final ConcurrentSkipListMap concurrentSkipListMap3 = concurrentSkipListMap;
                BytecodeManager.incBytecodes(3);
                concurrentSkipListMap3.buildFromSorted(this);
                final ConcurrentSkipListMap<K, V> concurrentSkipListMap4 = concurrentSkipListMap;
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                return concurrentSkipListMap4;
            }
            catch (CloneNotSupportedException ex) {
                BytecodeManager.incBytecodes(501);
                BytecodeManager.incBytecodes(3);
                final InternalError internalError = new InternalError();
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
    
    private void buildFromSorted(final SortedMap<K, ? extends V> sortedMap) {
        try {
            BytecodeManager.incBytecodes(2);
            if (sortedMap == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            HeadIndex<K, V> head = this.head;
            BytecodeManager.incBytecodes(3);
            Node<K, V> node = head.node;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(3);
            final ArrayList<Index<K, V>> list = new ArrayList<Index<K, V>>();
            BytecodeManager.incBytecodes(1);
            int n = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n2 = n;
                final int level = head.level;
                BytecodeManager.incBytecodes(4);
                if (n2 > level) {
                    break;
                }
                final ArrayList<Index<K, V>> list2 = list;
                final Index<K, V> index = null;
                BytecodeManager.incBytecodes(3);
                list2.add(index);
                BytecodeManager.incBytecodes(1);
                ++n;
                BytecodeManager.incBytecodes(2);
            }
            Index<K, V> down = head;
            BytecodeManager.incBytecodes(2);
            int level2 = head.level;
            BytecodeManager.incBytecodes(3);
            while (true) {
                final int n3 = level2;
                BytecodeManager.incBytecodes(2);
                if (n3 <= 0) {
                    break;
                }
                final ArrayList<Index<K, V>> list3 = list;
                final int n4 = level2;
                final Index<K, V> index2 = down;
                BytecodeManager.incBytecodes(4);
                list3.set(n4, index2);
                BytecodeManager.incBytecodes(1);
                down = down.down;
                BytecodeManager.incBytecodes(3);
                --level2;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
            final Set<Map.Entry<K, ? extends V>> entrySet = sortedMap.entrySet();
            BytecodeManager.incBytecodes(1);
            final Iterator<Map.Entry<K, ? extends V>> iterator = entrySet.iterator();
            BytecodeManager.incBytecodes(1);
            Label_0686: {
                while (true) {
                    final Iterator<Map.Entry<K, ? extends V>> iterator2 = iterator;
                    BytecodeManager.incBytecodes(2);
                    final boolean hasNext = iterator2.hasNext();
                    BytecodeManager.incBytecodes(1);
                    if (!hasNext) {
                        break Label_0686;
                    }
                    final Iterator<Map.Entry<K, ? extends V>> iterator3 = iterator;
                    BytecodeManager.incBytecodes(2);
                    final Map.Entry<K, ? extends V> entry = iterator3.next();
                    BytecodeManager.incBytecodes(2);
                    BytecodeManager.incBytecodes(1);
                    final ThreadLocalRandom current = ThreadLocalRandom.current();
                    BytecodeManager.incBytecodes(1);
                    int nextInt = current.nextInt();
                    BytecodeManager.incBytecodes(1);
                    int n5 = 0;
                    BytecodeManager.incBytecodes(2);
                    final int n6 = nextInt & 0x80000001;
                    BytecodeManager.incBytecodes(4);
                    if (n6 == 0) {
                        int i;
                        do {
                            ++n5;
                            BytecodeManager.incBytecodes(1);
                            i = ((nextInt >>>= 1) & 0x1);
                            BytecodeManager.incBytecodes(8);
                        } while (i != 0);
                        final int n7 = n5;
                        final int level3 = head.level;
                        BytecodeManager.incBytecodes(4);
                        if (n7 > level3) {
                            n5 = head.level + 1;
                            BytecodeManager.incBytecodes(5);
                        }
                    }
                    final Map.Entry<K, ? extends V> entry2 = entry;
                    BytecodeManager.incBytecodes(2);
                    final K key = entry2.getKey();
                    BytecodeManager.incBytecodes(1);
                    final Map.Entry<K, ? extends V> entry3 = entry;
                    BytecodeManager.incBytecodes(2);
                    final V value = (V)entry3.getValue();
                    BytecodeManager.incBytecodes(1);
                    final K k = key;
                    BytecodeManager.incBytecodes(2);
                    if (k == null) {
                        break;
                    }
                    final V v = value;
                    BytecodeManager.incBytecodes(2);
                    if (v == null) {
                        break;
                    }
                    final K j = key;
                    final V v2 = value;
                    final Node<K, V> node2 = null;
                    BytecodeManager.incBytecodes(6);
                    final Node next = new Node<K, V>(j, v2, (Node<Object, Object>)node2);
                    BytecodeManager.incBytecodes(1);
                    node.next = (Node<K, V>)next;
                    BytecodeManager.incBytecodes(3);
                    node = (Node<K, V>)next;
                    BytecodeManager.incBytecodes(2);
                    final int n8 = n5;
                    BytecodeManager.incBytecodes(2);
                    if (n8 > 0) {
                        Index<K, V> right = null;
                        BytecodeManager.incBytecodes(2);
                        int n9 = 1;
                        BytecodeManager.incBytecodes(2);
                        while (true) {
                            final int n10 = n9;
                            final int n11 = n5;
                            BytecodeManager.incBytecodes(3);
                            if (n10 > n11) {
                                break;
                            }
                            final Node node3 = next;
                            final Index<Object, Object> index3 = (Index<Object, Object>)right;
                            final Index<K, V> index4 = null;
                            BytecodeManager.incBytecodes(6);
                            right = (Index<K, V>)new Index<Object, Object>(node3, index3, (Index<Object, Object>)index4);
                            BytecodeManager.incBytecodes(1);
                            final int n12 = n9;
                            final int level4 = head.level;
                            BytecodeManager.incBytecodes(4);
                            if (n12 > level4) {
                                final Node<K, V> node4 = head.node;
                                final HeadIndex<K, V> headIndex = head;
                                final Index<K, V> index5 = right;
                                final int n13 = n9;
                                BytecodeManager.incBytecodes(8);
                                head = new HeadIndex<K, V>((Node<Object, Object>)node4, (Index<Object, Object>)headIndex, (Index<Object, Object>)index5, n13);
                                BytecodeManager.incBytecodes(1);
                            }
                            final int n14 = n9;
                            final ArrayList<Index<K, V>> list4 = list;
                            BytecodeManager.incBytecodes(3);
                            final int size = list4.size();
                            BytecodeManager.incBytecodes(1);
                            if (n14 < size) {
                                final ArrayList<Index<K, V>> list5 = list;
                                final int n15 = n9;
                                BytecodeManager.incBytecodes(3);
                                list5.get(n15).right = right;
                                BytecodeManager.incBytecodes(3);
                                final ArrayList<Index<K, V>> list6 = list;
                                final int n16 = n9;
                                final Index<K, V> index6 = right;
                                BytecodeManager.incBytecodes(4);
                                list6.set(n16, index6);
                                BytecodeManager.incBytecodes(2);
                            }
                            else {
                                final ArrayList<Index<K, V>> list7 = list;
                                final Index<K, V> index7 = right;
                                BytecodeManager.incBytecodes(3);
                                list7.add(index7);
                                BytecodeManager.incBytecodes(1);
                            }
                            ++n9;
                            BytecodeManager.incBytecodes(2);
                        }
                    }
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex2 = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex2;
            }
            this.head = head;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
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
            Node<K, V> node = this.findFirst();
            BytecodeManager.incBytecodes(1);
            while (true) {
                final Node<K, V> node2 = node;
                BytecodeManager.incBytecodes(2);
                if (node2 == null) {
                    break;
                }
                final Node<K, V> node3 = node;
                BytecodeManager.incBytecodes(2);
                final V validValue = node3.getValidValue();
                BytecodeManager.incBytecodes(1);
                final V v = validValue;
                BytecodeManager.incBytecodes(2);
                if (v != null) {
                    final K key = node.key;
                    BytecodeManager.incBytecodes(4);
                    objectOutputStream.writeObject(key);
                    final V obj = validValue;
                    BytecodeManager.incBytecodes(3);
                    objectOutputStream.writeObject(obj);
                }
                node = node.next;
                BytecodeManager.incBytecodes(4);
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
            BytecodeManager.incBytecodes(2);
            this.initialize();
            HeadIndex<K, V> head = this.head;
            BytecodeManager.incBytecodes(3);
            Node<K, V> node = head.node;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(3);
            final ArrayList<Index<K, V>> list = new ArrayList<Index<K, V>>();
            BytecodeManager.incBytecodes(1);
            int n = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n2 = n;
                final int level = head.level;
                BytecodeManager.incBytecodes(4);
                if (n2 > level) {
                    break;
                }
                final ArrayList<Object> list2 = (ArrayList<Object>)list;
                final Object o = null;
                BytecodeManager.incBytecodes(3);
                list2.add(o);
                BytecodeManager.incBytecodes(1);
                ++n;
                BytecodeManager.incBytecodes(2);
            }
            Object down = head;
            BytecodeManager.incBytecodes(2);
            int level2 = head.level;
            BytecodeManager.incBytecodes(3);
            while (true) {
                final int n3 = level2;
                BytecodeManager.incBytecodes(2);
                if (n3 <= 0) {
                    break;
                }
                final ArrayList<Index> list3 = (ArrayList<Index>)list;
                final int n4 = level2;
                final Object o2 = down;
                BytecodeManager.incBytecodes(4);
                list3.set(n4, (Index)o2);
                BytecodeManager.incBytecodes(1);
                down = ((Index)down).down;
                BytecodeManager.incBytecodes(3);
                --level2;
                BytecodeManager.incBytecodes(2);
            }
            while (true) {
                BytecodeManager.incBytecodes(2);
                final Object object = objectInputStream.readObject();
                BytecodeManager.incBytecodes(1);
                final Object o3 = object;
                BytecodeManager.incBytecodes(2);
                if (o3 == null) {
                    BytecodeManager.incBytecodes(1);
                    this.head = head;
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(1);
                    return;
                }
                BytecodeManager.incBytecodes(2);
                final Object object2 = objectInputStream.readObject();
                BytecodeManager.incBytecodes(1);
                final Object o4 = object2;
                BytecodeManager.incBytecodes(2);
                if (o4 == null) {
                    BytecodeManager.incBytecodes(3);
                    final NullPointerException ex = new NullPointerException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final Object o5 = object;
                BytecodeManager.incBytecodes(2);
                final Object o6 = object2;
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
                final ThreadLocalRandom current = ThreadLocalRandom.current();
                BytecodeManager.incBytecodes(1);
                int nextInt = current.nextInt();
                BytecodeManager.incBytecodes(1);
                int n5 = 0;
                BytecodeManager.incBytecodes(2);
                final int n6 = nextInt & 0x80000001;
                BytecodeManager.incBytecodes(4);
                if (n6 == 0) {
                    int i;
                    do {
                        ++n5;
                        BytecodeManager.incBytecodes(1);
                        i = ((nextInt >>>= 1) & 0x1);
                        BytecodeManager.incBytecodes(8);
                    } while (i != 0);
                    final int n7 = n5;
                    final int level3 = head.level;
                    BytecodeManager.incBytecodes(4);
                    if (n7 > level3) {
                        n5 = head.level + 1;
                        BytecodeManager.incBytecodes(5);
                    }
                }
                final K k = (K)o5;
                final Object o7 = o6;
                final Node<K, V> node2 = null;
                BytecodeManager.incBytecodes(6);
                final Node next = new Node<K, V>(k, o7, (Node<Object, Object>)node2);
                BytecodeManager.incBytecodes(1);
                node.next = (Node<K, V>)next;
                BytecodeManager.incBytecodes(3);
                node = (Node<K, V>)next;
                BytecodeManager.incBytecodes(2);
                final int n8 = n5;
                BytecodeManager.incBytecodes(2);
                if (n8 > 0) {
                    Object right = null;
                    BytecodeManager.incBytecodes(2);
                    int n9 = 1;
                    BytecodeManager.incBytecodes(2);
                    while (true) {
                        final int n10 = n9;
                        final int n11 = n5;
                        BytecodeManager.incBytecodes(3);
                        if (n10 > n11) {
                            break;
                        }
                        final Node node3 = next;
                        final Object o8 = right;
                        final Index<K, V> index = null;
                        BytecodeManager.incBytecodes(6);
                        right = new Index<Object, Object>(node3, (Index<Object, Object>)o8, (Index<Object, Object>)index);
                        BytecodeManager.incBytecodes(1);
                        final int n12 = n9;
                        final int level4 = head.level;
                        BytecodeManager.incBytecodes(4);
                        if (n12 > level4) {
                            final Node<K, V> node4 = head.node;
                            final HeadIndex<K, V> headIndex = head;
                            final Object o9 = right;
                            final int n13 = n9;
                            BytecodeManager.incBytecodes(8);
                            head = new HeadIndex<K, V>((Node<Object, Object>)node4, (Index<Object, Object>)headIndex, (Index<Object, Object>)o9, n13);
                            BytecodeManager.incBytecodes(1);
                        }
                        final int n14 = n9;
                        final ArrayList<Object> list4 = (ArrayList<Object>)list;
                        BytecodeManager.incBytecodes(3);
                        final int size = list4.size();
                        BytecodeManager.incBytecodes(1);
                        if (n14 < size) {
                            final ArrayList<Index> list5 = (ArrayList<Index>)list;
                            final int n15 = n9;
                            BytecodeManager.incBytecodes(3);
                            list5.get(n15).right = (Index<K, V>)right;
                            BytecodeManager.incBytecodes(3);
                            final ArrayList<Index<K, V>> list6 = list;
                            final int n16 = n9;
                            final Index<K, V> index2 = (Index<K, V>)right;
                            BytecodeManager.incBytecodes(4);
                            list6.set(n16, (Index<K, V>)index2);
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            final ArrayList<Index<K, V>> list7 = list;
                            final Index<K, V> index3 = (Index<K, V>)right;
                            BytecodeManager.incBytecodes(3);
                            list7.add((Index<K, V>)index3);
                            BytecodeManager.incBytecodes(1);
                        }
                        ++n9;
                        BytecodeManager.incBytecodes(2);
                    }
                }
                BytecodeManager.incBytecodes(1);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean containsKey(final Object o) {
        try {
            BytecodeManager.incBytecodes(3);
            final Object doGet = this.doGet(o);
            BytecodeManager.incBytecodes(1);
            boolean b;
            if (doGet != null) {
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
    public V get(final Object o) {
        try {
            BytecodeManager.incBytecodes(3);
            final V doGet = this.doGet(o);
            BytecodeManager.incBytecodes(1);
            return doGet;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public V getOrDefault(final Object o, final V v) {
        try {
            BytecodeManager.incBytecodes(3);
            final V doGet = this.doGet(o);
            BytecodeManager.incBytecodes(3);
            V v2;
            if (doGet == null) {
                v2 = v;
                BytecodeManager.incBytecodes(2);
            }
            else {
                v2 = doGet;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return v2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public V put(final K k, final V v) {
        try {
            BytecodeManager.incBytecodes(2);
            if (v == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final boolean b = false;
            BytecodeManager.incBytecodes(5);
            final Object doPut = this.doPut(k, v, b);
            BytecodeManager.incBytecodes(1);
            return (V)doPut;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public V remove(final Object o) {
        try {
            final Object o2 = null;
            BytecodeManager.incBytecodes(4);
            final V doRemove = this.doRemove(o, o2);
            BytecodeManager.incBytecodes(1);
            return doRemove;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean containsValue(final Object o) {
        try {
            BytecodeManager.incBytecodes(2);
            if (o == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(2);
            Node<K, V> node = this.findFirst();
            BytecodeManager.incBytecodes(1);
            while (true) {
                final Node<K, V> node2 = node;
                BytecodeManager.incBytecodes(2);
                if (node2 == null) {
                    final boolean b = false;
                    BytecodeManager.incBytecodes(2);
                    return b;
                }
                final Node<K, V> node3 = node;
                BytecodeManager.incBytecodes(2);
                final V validValue = node3.getValidValue();
                BytecodeManager.incBytecodes(1);
                final V v = validValue;
                BytecodeManager.incBytecodes(2);
                if (v != null) {
                    final V obj = validValue;
                    BytecodeManager.incBytecodes(3);
                    final boolean equals = o.equals(obj);
                    BytecodeManager.incBytecodes(1);
                    if (equals) {
                        final boolean b2 = true;
                        BytecodeManager.incBytecodes(2);
                        return b2;
                    }
                }
                node = node.next;
                BytecodeManager.incBytecodes(4);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public int size() {
        try {
            long n = 0L;
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            Node<K, V> node = this.findFirst();
            BytecodeManager.incBytecodes(1);
            while (true) {
                final Node<K, V> node2 = node;
                BytecodeManager.incBytecodes(2);
                if (node2 == null) {
                    break;
                }
                final Node<K, V> node3 = node;
                BytecodeManager.incBytecodes(2);
                final V validValue = node3.getValidValue();
                BytecodeManager.incBytecodes(1);
                if (validValue != null) {
                    ++n;
                    BytecodeManager.incBytecodes(4);
                }
                node = node.next;
                BytecodeManager.incBytecodes(4);
            }
            final long n2 = lcmp(n, 2147483647L);
            BytecodeManager.incBytecodes(4);
            int n3;
            if (n2 >= 0) {
                n3 = Integer.MAX_VALUE;
                BytecodeManager.incBytecodes(2);
            }
            else {
                n3 = (int)n;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
            return n3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean isEmpty() {
        try {
            BytecodeManager.incBytecodes(2);
            final Node<K, V> first = this.findFirst();
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
    public void clear() {
        try {
            BytecodeManager.incBytecodes(2);
            this.initialize();
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public V computeIfAbsent(final K k, final Function<? super K, ? extends V> function) {
        try {
            BytecodeManager.incBytecodes(2);
            if (k != null) {
                BytecodeManager.incBytecodes(2);
                if (function != null) {
                    BytecodeManager.incBytecodes(3);
                    Object doGet = this.doGet(k);
                    BytecodeManager.incBytecodes(3);
                    if (doGet == null) {
                        BytecodeManager.incBytecodes(2);
                        BytecodeManager.incBytecodes(1);
                        final V apply;
                        final Object o = apply = (V)function.apply(k);
                        BytecodeManager.incBytecodes(3);
                        if (o != null) {
                            final V v = apply;
                            final boolean b = true;
                            BytecodeManager.incBytecodes(5);
                            final Object doPut = this.doPut(k, v, b);
                            BytecodeManager.incBytecodes(3);
                            Object o2;
                            if (doPut == null) {
                                o2 = apply;
                                BytecodeManager.incBytecodes(2);
                            }
                            else {
                                o2 = doPut;
                                BytecodeManager.incBytecodes(1);
                            }
                            doGet = o2;
                            BytecodeManager.incBytecodes(1);
                        }
                    }
                    final Object o3 = doGet;
                    BytecodeManager.incBytecodes(2);
                    return (V)o3;
                }
            }
            BytecodeManager.incBytecodes(3);
            final NullPointerException ex = new NullPointerException();
            BytecodeManager.incBytecodes(1);
            throw ex;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public V computeIfPresent(final K k, final BiFunction<? super K, ? super V, ? extends V> biFunction) {
        try {
            BytecodeManager.incBytecodes(2);
            if (k != null) {
                BytecodeManager.incBytecodes(2);
                if (biFunction != null) {
                    while (true) {
                        BytecodeManager.incBytecodes(3);
                        final Node<K, V> node2;
                        final Node<K, V> node = node2 = this.findNode(k);
                        BytecodeManager.incBytecodes(3);
                        if (node == null) {
                            break;
                        }
                        final Object value = node2.value;
                        BytecodeManager.incBytecodes(5);
                        if (value == null) {
                            continue;
                        }
                        final Object o = value;
                        BytecodeManager.incBytecodes(2);
                        final Object o2 = o;
                        BytecodeManager.incBytecodes(4);
                        final V apply = (V)biFunction.apply(k, (Object)o2);
                        BytecodeManager.incBytecodes(1);
                        final V v = apply;
                        BytecodeManager.incBytecodes(2);
                        if (v != null) {
                            final Node<K, V> node3 = node2;
                            final Object o3 = o;
                            final V v2 = apply;
                            BytecodeManager.incBytecodes(4);
                            final boolean casValue = node3.casValue(o3, v2);
                            BytecodeManager.incBytecodes(1);
                            if (casValue) {
                                final V v3 = apply;
                                BytecodeManager.incBytecodes(2);
                                return v3;
                            }
                        }
                        else {
                            final Object o4 = o;
                            BytecodeManager.incBytecodes(4);
                            final V doRemove = this.doRemove(k, o4);
                            BytecodeManager.incBytecodes(1);
                            if (doRemove != null) {
                                BytecodeManager.incBytecodes(1);
                                break;
                            }
                        }
                        BytecodeManager.incBytecodes(1);
                    }
                    final V v4 = null;
                    BytecodeManager.incBytecodes(2);
                    return v4;
                }
            }
            BytecodeManager.incBytecodes(3);
            final NullPointerException ex = new NullPointerException();
            BytecodeManager.incBytecodes(1);
            throw ex;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public V compute(final K k, final BiFunction<? super K, ? super V, ? extends V> biFunction) {
        try {
            BytecodeManager.incBytecodes(2);
            if (k != null) {
                BytecodeManager.incBytecodes(2);
                if (biFunction != null) {
                    while (true) {
                        BytecodeManager.incBytecodes(3);
                        final Node<K, V> node2;
                        final Node<K, V> node = node2 = this.findNode(k);
                        BytecodeManager.incBytecodes(3);
                        if (node == null) {
                            final Object o = null;
                            BytecodeManager.incBytecodes(4);
                            final V apply;
                            final Object o2 = apply = (V)biFunction.apply(k, (Object)o);
                            BytecodeManager.incBytecodes(3);
                            if (o2 == null) {
                                BytecodeManager.incBytecodes(1);
                                break;
                            }
                            final V v = apply;
                            final boolean b = true;
                            BytecodeManager.incBytecodes(5);
                            final Object doPut = this.doPut(k, v, b);
                            BytecodeManager.incBytecodes(1);
                            if (doPut == null) {
                                final V v2 = apply;
                                BytecodeManager.incBytecodes(2);
                                return v2;
                            }
                        }
                        else {
                            final Object value = node2.value;
                            BytecodeManager.incBytecodes(5);
                            if (value != null) {
                                final Object o3 = value;
                                BytecodeManager.incBytecodes(2);
                                final Object o4 = o3;
                                BytecodeManager.incBytecodes(4);
                                final V apply2;
                                final Object o5 = apply2 = (V)biFunction.apply(k, (Object)o4);
                                BytecodeManager.incBytecodes(3);
                                if (o5 != null) {
                                    final Node<K, V> node3 = node2;
                                    final Object o6 = o3;
                                    final V v3 = apply2;
                                    BytecodeManager.incBytecodes(4);
                                    final boolean casValue = node3.casValue(o6, v3);
                                    BytecodeManager.incBytecodes(1);
                                    if (casValue) {
                                        final V v4 = apply2;
                                        BytecodeManager.incBytecodes(2);
                                        return v4;
                                    }
                                }
                                else {
                                    final Object o7 = o3;
                                    BytecodeManager.incBytecodes(4);
                                    final V doRemove = this.doRemove(k, o7);
                                    BytecodeManager.incBytecodes(1);
                                    if (doRemove != null) {
                                        BytecodeManager.incBytecodes(1);
                                        break;
                                    }
                                }
                            }
                        }
                        BytecodeManager.incBytecodes(1);
                    }
                    final V v5 = null;
                    BytecodeManager.incBytecodes(2);
                    return v5;
                }
            }
            BytecodeManager.incBytecodes(3);
            final NullPointerException ex = new NullPointerException();
            BytecodeManager.incBytecodes(1);
            throw ex;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public V merge(final K k, final V v, final BiFunction<? super V, ? super V, ? extends V> biFunction) {
        try {
            BytecodeManager.incBytecodes(2);
            if (k != null) {
                BytecodeManager.incBytecodes(2);
                if (v != null) {
                    BytecodeManager.incBytecodes(2);
                    if (biFunction != null) {
                        while (true) {
                            BytecodeManager.incBytecodes(3);
                            final Node<K, V> node2;
                            final Node<K, V> node = node2 = this.findNode(k);
                            BytecodeManager.incBytecodes(3);
                            if (node == null) {
                                final boolean b = true;
                                BytecodeManager.incBytecodes(5);
                                final Object doPut = this.doPut(k, v, b);
                                BytecodeManager.incBytecodes(1);
                                if (doPut == null) {
                                    BytecodeManager.incBytecodes(2);
                                    return v;
                                }
                            }
                            else {
                                final Object value = node2.value;
                                BytecodeManager.incBytecodes(5);
                                if (value != null) {
                                    final Object o = value;
                                    BytecodeManager.incBytecodes(2);
                                    final Object o2 = o;
                                    BytecodeManager.incBytecodes(4);
                                    final V apply;
                                    final Object o3 = apply = (V)biFunction.apply(o2, v);
                                    BytecodeManager.incBytecodes(3);
                                    if (o3 != null) {
                                        final Node<K, V> node3 = node2;
                                        final Object o4 = o;
                                        final V v2 = apply;
                                        BytecodeManager.incBytecodes(4);
                                        final boolean casValue = node3.casValue(o4, v2);
                                        BytecodeManager.incBytecodes(1);
                                        if (casValue) {
                                            final V v3 = apply;
                                            BytecodeManager.incBytecodes(2);
                                            return v3;
                                        }
                                    }
                                    else {
                                        final Object o5 = o;
                                        BytecodeManager.incBytecodes(4);
                                        final V doRemove = this.doRemove(k, o5);
                                        BytecodeManager.incBytecodes(1);
                                        if (doRemove != null) {
                                            final V v4 = null;
                                            BytecodeManager.incBytecodes(2);
                                            return v4;
                                        }
                                    }
                                }
                            }
                            BytecodeManager.incBytecodes(1);
                        }
                    }
                }
            }
            BytecodeManager.incBytecodes(3);
            final NullPointerException ex = new NullPointerException();
            BytecodeManager.incBytecodes(1);
            throw ex;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public NavigableSet<K> keySet() {
        try {
            final KeySet<K> keySet = this.keySet;
            BytecodeManager.incBytecodes(3);
            final KeySet<K> set = keySet;
            BytecodeManager.incBytecodes(2);
            KeySet<K> set2;
            if (set != null) {
                set2 = keySet;
                BytecodeManager.incBytecodes(2);
            }
            else {
                final KeySet<K> keySet2 = set2 = new KeySet<K>(this);
                BytecodeManager.incBytecodes(5);
                this.keySet = keySet2;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
            return set2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public NavigableSet<K> navigableKeySet() {
        try {
            final KeySet<K> keySet = this.keySet;
            BytecodeManager.incBytecodes(3);
            final KeySet<K> set = keySet;
            BytecodeManager.incBytecodes(2);
            KeySet<K> set2;
            if (set != null) {
                set2 = keySet;
                BytecodeManager.incBytecodes(2);
            }
            else {
                final KeySet<K> keySet2 = set2 = new KeySet<K>(this);
                BytecodeManager.incBytecodes(5);
                this.keySet = keySet2;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
            return set2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public Collection<V> values() {
        try {
            final Values<V> values = this.values;
            BytecodeManager.incBytecodes(3);
            final Values<V> values2 = values;
            BytecodeManager.incBytecodes(2);
            Values<V> values3;
            if (values2 != null) {
                values3 = values;
                BytecodeManager.incBytecodes(2);
            }
            else {
                final Values<V> values4 = values3 = new Values<V>(this);
                BytecodeManager.incBytecodes(5);
                this.values = values4;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
            return values3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        try {
            final EntrySet<K, V> entrySet = this.entrySet;
            BytecodeManager.incBytecodes(3);
            final EntrySet<K, V> set = entrySet;
            BytecodeManager.incBytecodes(2);
            EntrySet<K, V> set2;
            if (set != null) {
                set2 = entrySet;
                BytecodeManager.incBytecodes(2);
            }
            else {
                final EntrySet entrySet2 = set2 = new EntrySet<K, V>((ConcurrentNavigableMap<Object, Object>)this);
                BytecodeManager.incBytecodes(5);
                this.entrySet = (EntrySet<K, V>)entrySet2;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
            return (Set<Map.Entry<K, V>>)set2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public ConcurrentNavigableMap<K, V> descendingMap() {
        try {
            final ConcurrentNavigableMap<K, V> descendingMap = this.descendingMap;
            BytecodeManager.incBytecodes(3);
            final ConcurrentNavigableMap<K, V> concurrentNavigableMap = descendingMap;
            BytecodeManager.incBytecodes(2);
            ConcurrentNavigableMap<K, V> concurrentNavigableMap2;
            if (concurrentNavigableMap != null) {
                concurrentNavigableMap2 = descendingMap;
                BytecodeManager.incBytecodes(2);
            }
            else {
                final K k;
                final boolean b;
                final K i;
                final boolean b2;
                final boolean b3;
                final SubMap<K, V> descendingMap2 = (SubMap<K, V>)(concurrentNavigableMap2 = new SubMap<K, V>((ConcurrentSkipListMap<Object, Object>)this, k, b, i, b2, b3));
                k = null;
                b = false;
                i = null;
                b2 = false;
                b3 = true;
                BytecodeManager.incBytecodes(10);
                this.descendingMap = descendingMap2;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
            return concurrentNavigableMap2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public NavigableSet<K> descendingKeySet() {
        try {
            BytecodeManager.incBytecodes(2);
            final ConcurrentNavigableMap<K, V> descendingMap = this.descendingMap();
            BytecodeManager.incBytecodes(1);
            final NavigableSet<K> navigableKeySet = descendingMap.navigableKeySet();
            BytecodeManager.incBytecodes(1);
            return navigableKeySet;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean equals(final Object p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: aload_0        
        //     2: ldc             3
        //     4: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     7: if_acmpne       17
        //    10: iconst_1       
        //    11: ldc             2
        //    13: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    16: ireturn        
        //    17: aload_1        
        //    18: instanceof      Linstrumented/java/util/Map;
        //    21: ldc             3
        //    23: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    26: ifne            36
        //    29: iconst_0       
        //    30: ldc             2
        //    32: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    35: ireturn        
        //    36: aload_1        
        //    37: checkcast       Linstrumented/java/util/Map;
        //    40: astore_2       
        //    41: ldc             3
        //    43: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    46: aload_0        
        //    47: ldc             2
        //    49: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    52: invokevirtual   instrumented/java/util/concurrent/ConcurrentSkipListMap.entrySet:()Linstrumented/java/util/Set;
        //    55: ldc             1
        //    57: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    60: invokeinterface instrumented/java/util/Set.iterator:()Ljava/util/Iterator;
        //    65: astore_3       
        //    66: ldc             1
        //    68: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    71: aload_3        
        //    72: ldc             2
        //    74: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    77: invokeinterface java/util/Iterator.hasNext:()Z
        //    82: ldc             1
        //    84: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    87: ifeq            182
        //    90: aload_3        
        //    91: ldc             2
        //    93: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    96: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   101: checkcast       Linstrumented/java/util/Map$Entry;
        //   104: astore          4
        //   106: ldc             2
        //   108: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   111: aload           4
        //   113: ldc             2
        //   115: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   118: invokeinterface instrumented/java/util/Map$Entry.getValue:()Ljava/lang/Object;
        //   123: aload_2        
        //   124: aload           4
        //   126: ldc             3
        //   128: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   131: invokeinterface instrumented/java/util/Map$Entry.getKey:()Ljava/lang/Object;
        //   136: ldc             1
        //   138: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   141: invokeinterface instrumented/java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //   146: ldc             1
        //   148: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   151: invokevirtual   java/lang/Object.equals:(Ljava/lang/Object;)Z
        //   154: ldc             1
        //   156: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   159: ifne            174
        //   162: iconst_0       
        //   163: ldc             1
        //   165: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   168: ldc             1
        //   170: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   173: ireturn        
        //   174: ldc             1
        //   176: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   179: goto            71
        //   182: aload_2        
        //   183: ldc             2
        //   185: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   188: invokeinterface instrumented/java/util/Map.entrySet:()Linstrumented/java/util/Set;
        //   193: ldc             1
        //   195: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   198: invokeinterface instrumented/java/util/Set.iterator:()Ljava/util/Iterator;
        //   203: astore_3       
        //   204: ldc             1
        //   206: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   209: aload_3        
        //   210: ldc             2
        //   212: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   215: invokeinterface java/util/Iterator.hasNext:()Z
        //   220: ldc             1
        //   222: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   225: ifeq            356
        //   228: aload_3        
        //   229: ldc             2
        //   231: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   234: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   239: checkcast       Linstrumented/java/util/Map$Entry;
        //   242: astore          4
        //   244: ldc             2
        //   246: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   249: aload           4
        //   251: ldc             2
        //   253: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   256: invokeinterface instrumented/java/util/Map$Entry.getKey:()Ljava/lang/Object;
        //   261: astore          5
        //   263: ldc             1
        //   265: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   268: aload           4
        //   270: ldc             2
        //   272: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   275: invokeinterface instrumented/java/util/Map$Entry.getValue:()Ljava/lang/Object;
        //   280: astore          6
        //   282: ldc             1
        //   284: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   287: aload           5
        //   289: ldc             2
        //   291: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   294: ifnull          336
        //   297: aload           6
        //   299: ldc             2
        //   301: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   304: ifnull          336
        //   307: aload           6
        //   309: aload_0        
        //   310: aload           5
        //   312: ldc             4
        //   314: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   317: invokevirtual   instrumented/java/util/concurrent/ConcurrentSkipListMap.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //   320: ldc             1
        //   322: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   325: invokevirtual   java/lang/Object.equals:(Ljava/lang/Object;)Z
        //   328: ldc             1
        //   330: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   333: ifne            348
        //   336: iconst_0       
        //   337: ldc             1
        //   339: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   342: ldc             1
        //   344: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   347: ireturn        
        //   348: ldc             1
        //   350: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   353: goto            209
        //   356: iconst_1       
        //   357: ldc             1
        //   359: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   362: ldc             1
        //   364: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   367: ireturn        
        //   368: astore_3       
        //   369: ldc_w           501
        //   372: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   375: iconst_0       
        //   376: ldc             2
        //   378: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   381: ireturn        
        //   382: astore_3       
        //   383: ldc_w           501
        //   386: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   389: iconst_0       
        //   390: ldc             2
        //   392: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   395: ireturn        
        //   396: athrow         
        //   397: athrow         
        //    StackMapTable: 00 0D 11 12 FD 00 22 07 00 13 07 01 56 FB 00 66 FA 00 07 FC 00 1A 07 01 56 FE 00 7E 07 00 11 07 00 B9 07 00 B9 F8 00 0B FA 00 07 4B 07 01 C1 4D 07 00 A3 FF 00 0D 00 00 00 01 07 00 84 FF 00 00 00 00 00 01 07 01 38
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                            
        //  -----  -----  -----  -----  --------------------------------
        //  46     397    397    398    Ljava/lang/VirtualMachineError;
        //  46     168    368    382    Ljava/lang/ClassCastException;
        //  174    342    368    382    Ljava/lang/ClassCastException;
        //  348    362    368    382    Ljava/lang/ClassCastException;
        //  46     168    382    396    Ljava/lang/NullPointerException;
        //  174    342    382    396    Ljava/lang/NullPointerException;
        //  348    362    382    396    Ljava/lang/NullPointerException;
        //  0      396    396    397    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0071:
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
    
    @Override
    public V putIfAbsent(final K k, final V v) {
        try {
            BytecodeManager.incBytecodes(2);
            if (v == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final boolean b = true;
            BytecodeManager.incBytecodes(5);
            final Object doPut = this.doPut(k, v, b);
            BytecodeManager.incBytecodes(1);
            return (V)doPut;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean remove(final Object o, final Object o2) {
        try {
            BytecodeManager.incBytecodes(2);
            if (o == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(2);
            boolean b = false;
            Label_0070: {
                if (o2 != null) {
                    BytecodeManager.incBytecodes(4);
                    final Object doRemove = this.doRemove(o, o2);
                    BytecodeManager.incBytecodes(1);
                    if (doRemove != null) {
                        b = true;
                        BytecodeManager.incBytecodes(2);
                        break Label_0070;
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
    
    @Override
    public boolean replace(final K k, final V v, final V v2) {
        try {
            BytecodeManager.incBytecodes(2);
            if (k != null) {
                BytecodeManager.incBytecodes(2);
                if (v != null) {
                    BytecodeManager.incBytecodes(2);
                    if (v2 != null) {
                        while (true) {
                            BytecodeManager.incBytecodes(3);
                            final Node<K, V> node2;
                            final Node<K, V> node = node2 = this.findNode(k);
                            BytecodeManager.incBytecodes(3);
                            if (node == null) {
                                final boolean b = false;
                                BytecodeManager.incBytecodes(2);
                                return b;
                            }
                            final Object value;
                            final Object o = value = node2.value;
                            BytecodeManager.incBytecodes(5);
                            if (o != null) {
                                final Object obj = value;
                                BytecodeManager.incBytecodes(3);
                                final boolean equals = v.equals(obj);
                                BytecodeManager.incBytecodes(1);
                                if (!equals) {
                                    final boolean b2 = false;
                                    BytecodeManager.incBytecodes(2);
                                    return b2;
                                }
                                final Node<K, V> node3 = node2;
                                final Object o2 = value;
                                BytecodeManager.incBytecodes(4);
                                final boolean casValue = node3.casValue(o2, v2);
                                BytecodeManager.incBytecodes(1);
                                if (casValue) {
                                    final boolean b3 = true;
                                    BytecodeManager.incBytecodes(2);
                                    return b3;
                                }
                            }
                            BytecodeManager.incBytecodes(1);
                        }
                    }
                }
            }
            BytecodeManager.incBytecodes(3);
            final NullPointerException ex = new NullPointerException();
            BytecodeManager.incBytecodes(1);
            throw ex;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public V replace(final K k, final V v) {
        try {
            BytecodeManager.incBytecodes(2);
            if (k != null) {
                BytecodeManager.incBytecodes(2);
                if (v != null) {
                    while (true) {
                        BytecodeManager.incBytecodes(3);
                        final Node<K, V> node2;
                        final Node<K, V> node = node2 = this.findNode(k);
                        BytecodeManager.incBytecodes(3);
                        if (node == null) {
                            final V v2 = null;
                            BytecodeManager.incBytecodes(2);
                            return v2;
                        }
                        final Object value;
                        final Object o = value = node2.value;
                        BytecodeManager.incBytecodes(5);
                        if (o != null) {
                            final Node<K, V> node3 = node2;
                            final Object o2 = value;
                            BytecodeManager.incBytecodes(4);
                            final boolean casValue = node3.casValue(o2, v);
                            BytecodeManager.incBytecodes(1);
                            if (casValue) {
                                final Object o3 = value;
                                BytecodeManager.incBytecodes(2);
                                final Object o4 = o3;
                                BytecodeManager.incBytecodes(2);
                                return (V)o4;
                            }
                        }
                        BytecodeManager.incBytecodes(1);
                    }
                }
            }
            BytecodeManager.incBytecodes(3);
            final NullPointerException ex = new NullPointerException();
            BytecodeManager.incBytecodes(1);
            throw ex;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public Comparator<? super K> comparator() {
        try {
            final Comparator<? super K> comparator = this.comparator;
            BytecodeManager.incBytecodes(3);
            return comparator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public K firstKey() {
        try {
            BytecodeManager.incBytecodes(2);
            final Node<K, V> first = this.findFirst();
            BytecodeManager.incBytecodes(1);
            final Node<K, V> node = first;
            BytecodeManager.incBytecodes(2);
            if (node == null) {
                BytecodeManager.incBytecodes(3);
                final NoSuchElementException ex = new NoSuchElementException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final K key = first.key;
            BytecodeManager.incBytecodes(3);
            return key;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public K lastKey() {
        try {
            BytecodeManager.incBytecodes(2);
            final Node<K, V> last = this.findLast();
            BytecodeManager.incBytecodes(1);
            final Node<K, V> node = last;
            BytecodeManager.incBytecodes(2);
            if (node == null) {
                BytecodeManager.incBytecodes(3);
                final NoSuchElementException ex = new NoSuchElementException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final K key = last.key;
            BytecodeManager.incBytecodes(3);
            return key;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public ConcurrentNavigableMap<K, V> subMap(final K k, final boolean b, final K i, final boolean b2) {
        try {
            BytecodeManager.incBytecodes(2);
            if (k != null) {
                BytecodeManager.incBytecodes(2);
                if (i != null) {
                    final boolean b3 = false;
                    BytecodeManager.incBytecodes(9);
                    final SubMap subMap = new SubMap<K, V>((ConcurrentSkipListMap<Object, Object>)this, k, b, i, b2, b3);
                    BytecodeManager.incBytecodes(1);
                    return (ConcurrentNavigableMap<K, V>)subMap;
                }
            }
            BytecodeManager.incBytecodes(3);
            final NullPointerException ex = new NullPointerException();
            BytecodeManager.incBytecodes(1);
            throw ex;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public ConcurrentNavigableMap<K, V> headMap(final K k, final boolean b) {
        try {
            BytecodeManager.incBytecodes(2);
            if (k == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final K i = null;
            final boolean b2 = false;
            final boolean b3 = false;
            BytecodeManager.incBytecodes(9);
            final SubMap subMap = new SubMap<K, V>((ConcurrentSkipListMap<Object, Object>)this, i, b2, k, b, b3);
            BytecodeManager.incBytecodes(1);
            return (ConcurrentNavigableMap<K, V>)subMap;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public ConcurrentNavigableMap<K, V> tailMap(final K k, final boolean b) {
        try {
            BytecodeManager.incBytecodes(2);
            if (k == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final K i = null;
            final boolean b2 = false;
            final boolean b3 = false;
            BytecodeManager.incBytecodes(9);
            final SubMap subMap = new SubMap<K, V>((ConcurrentSkipListMap<Object, Object>)this, k, b, i, b2, b3);
            BytecodeManager.incBytecodes(1);
            return (ConcurrentNavigableMap<K, V>)subMap;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public ConcurrentNavigableMap<K, V> subMap(final K k, final K i) {
        try {
            final boolean b = true;
            final boolean b2 = false;
            BytecodeManager.incBytecodes(6);
            final ConcurrentNavigableMap<K, V> subMap = this.subMap(k, b, i, b2);
            BytecodeManager.incBytecodes(1);
            return subMap;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public ConcurrentNavigableMap<K, V> headMap(final K k) {
        try {
            final boolean b = false;
            BytecodeManager.incBytecodes(4);
            final ConcurrentNavigableMap<K, V> headMap = this.headMap(k, b);
            BytecodeManager.incBytecodes(1);
            return headMap;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public ConcurrentNavigableMap<K, V> tailMap(final K k) {
        try {
            final boolean b = true;
            BytecodeManager.incBytecodes(4);
            final ConcurrentNavigableMap<K, V> tailMap = this.tailMap(k, b);
            BytecodeManager.incBytecodes(1);
            return tailMap;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public Map.Entry<K, V> lowerEntry(final K k) {
        try {
            final int n = 2;
            BytecodeManager.incBytecodes(4);
            final SimpleImmutableEntry<K, V> near = this.getNear(k, n);
            BytecodeManager.incBytecodes(1);
            return near;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public K lowerKey(final K k) {
        try {
            final int n = 2;
            final Comparator<? super K> comparator = this.comparator;
            BytecodeManager.incBytecodes(6);
            final Node<K, V> near = this.findNear(k, n, comparator);
            BytecodeManager.incBytecodes(1);
            final Node<K, V> node = near;
            BytecodeManager.incBytecodes(2);
            K key;
            if (node == null) {
                key = null;
                BytecodeManager.incBytecodes(2);
            }
            else {
                key = near.key;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
            return key;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public Map.Entry<K, V> floorEntry(final K k) {
        try {
            final int n = 3;
            BytecodeManager.incBytecodes(4);
            final SimpleImmutableEntry<K, V> near = this.getNear(k, n);
            BytecodeManager.incBytecodes(1);
            return near;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public K floorKey(final K k) {
        try {
            final int n = 3;
            final Comparator<? super K> comparator = this.comparator;
            BytecodeManager.incBytecodes(6);
            final Node<K, V> near = this.findNear(k, n, comparator);
            BytecodeManager.incBytecodes(1);
            final Node<K, V> node = near;
            BytecodeManager.incBytecodes(2);
            K key;
            if (node == null) {
                key = null;
                BytecodeManager.incBytecodes(2);
            }
            else {
                key = near.key;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
            return key;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public Map.Entry<K, V> ceilingEntry(final K k) {
        try {
            final int n = 1;
            BytecodeManager.incBytecodes(4);
            final SimpleImmutableEntry<K, V> near = this.getNear(k, n);
            BytecodeManager.incBytecodes(1);
            return near;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public K ceilingKey(final K k) {
        try {
            final int n = 1;
            final Comparator<? super K> comparator = this.comparator;
            BytecodeManager.incBytecodes(6);
            final Node<K, V> near = this.findNear(k, n, comparator);
            BytecodeManager.incBytecodes(1);
            final Node<K, V> node = near;
            BytecodeManager.incBytecodes(2);
            K key;
            if (node == null) {
                key = null;
                BytecodeManager.incBytecodes(2);
            }
            else {
                key = near.key;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
            return key;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public Map.Entry<K, V> higherEntry(final K k) {
        try {
            final int n = 0;
            BytecodeManager.incBytecodes(4);
            final SimpleImmutableEntry<K, V> near = this.getNear(k, n);
            BytecodeManager.incBytecodes(1);
            return near;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public K higherKey(final K k) {
        try {
            final int n = 0;
            final Comparator<? super K> comparator = this.comparator;
            BytecodeManager.incBytecodes(6);
            final Node<K, V> near = this.findNear(k, n, comparator);
            BytecodeManager.incBytecodes(1);
            final Node<K, V> node = near;
            BytecodeManager.incBytecodes(2);
            K key;
            if (node == null) {
                key = null;
                BytecodeManager.incBytecodes(2);
            }
            else {
                key = near.key;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
            return key;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public Map.Entry<K, V> firstEntry() {
        try {
            while (true) {
                BytecodeManager.incBytecodes(2);
                final Node<K, V> first = this.findFirst();
                BytecodeManager.incBytecodes(1);
                final Node<K, V> node = first;
                BytecodeManager.incBytecodes(2);
                if (node == null) {
                    final Map.Entry<K, V> entry = null;
                    BytecodeManager.incBytecodes(2);
                    return entry;
                }
                final Node<K, V> node2 = first;
                BytecodeManager.incBytecodes(2);
                final SimpleImmutableEntry<K, V> snapshot = node2.createSnapshot();
                BytecodeManager.incBytecodes(1);
                final SimpleImmutableEntry<K, V> simpleImmutableEntry = snapshot;
                BytecodeManager.incBytecodes(2);
                if (simpleImmutableEntry != null) {
                    final SimpleImmutableEntry<K, V> simpleImmutableEntry2 = snapshot;
                    BytecodeManager.incBytecodes(2);
                    return simpleImmutableEntry2;
                }
                BytecodeManager.incBytecodes(1);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public Map.Entry<K, V> lastEntry() {
        try {
            while (true) {
                BytecodeManager.incBytecodes(2);
                final Node<K, V> last = this.findLast();
                BytecodeManager.incBytecodes(1);
                final Node<K, V> node = last;
                BytecodeManager.incBytecodes(2);
                if (node == null) {
                    final Map.Entry<K, V> entry = null;
                    BytecodeManager.incBytecodes(2);
                    return entry;
                }
                final Node<K, V> node2 = last;
                BytecodeManager.incBytecodes(2);
                final SimpleImmutableEntry<K, V> snapshot = node2.createSnapshot();
                BytecodeManager.incBytecodes(1);
                final SimpleImmutableEntry<K, V> simpleImmutableEntry = snapshot;
                BytecodeManager.incBytecodes(2);
                if (simpleImmutableEntry != null) {
                    final SimpleImmutableEntry<K, V> simpleImmutableEntry2 = snapshot;
                    BytecodeManager.incBytecodes(2);
                    return simpleImmutableEntry2;
                }
                BytecodeManager.incBytecodes(1);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public Map.Entry<K, V> pollFirstEntry() {
        try {
            BytecodeManager.incBytecodes(2);
            final Map.Entry<K, V> doRemoveFirstEntry = this.doRemoveFirstEntry();
            BytecodeManager.incBytecodes(1);
            return doRemoveFirstEntry;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public Map.Entry<K, V> pollLastEntry() {
        try {
            BytecodeManager.incBytecodes(2);
            final Map.Entry<K, V> doRemoveLastEntry = this.doRemoveLastEntry();
            BytecodeManager.incBytecodes(1);
            return doRemoveLastEntry;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    Iterator<K> keyIterator() {
        try {
            BytecodeManager.incBytecodes(4);
            final KeyIterator keyIterator = new KeyIterator();
            BytecodeManager.incBytecodes(1);
            return keyIterator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    Iterator<V> valueIterator() {
        try {
            BytecodeManager.incBytecodes(4);
            final ValueIterator valueIterator = new ValueIterator();
            BytecodeManager.incBytecodes(1);
            return valueIterator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    Iterator<Map.Entry<K, V>> entryIterator() {
        try {
            BytecodeManager.incBytecodes(4);
            final EntryIterator entryIterator = new EntryIterator();
            BytecodeManager.incBytecodes(1);
            return entryIterator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static final <E> List<E> toList(final Collection<E> collection) {
        try {
            BytecodeManager.incBytecodes(3);
            final ArrayList<E> list = new ArrayList<E>();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            final Iterator<E> iterator = collection.iterator();
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
                final ArrayList<E> list2 = list;
                final E e = next;
                BytecodeManager.incBytecodes(3);
                list2.add(e);
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
    
    @Override
    public void forEach(final BiConsumer<? super K, ? super V> biConsumer) {
        try {
            BytecodeManager.incBytecodes(2);
            if (biConsumer == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(2);
            Node<K, V> node = this.findFirst();
            BytecodeManager.incBytecodes(1);
            while (true) {
                final Node<K, V> node2 = node;
                BytecodeManager.incBytecodes(2);
                if (node2 == null) {
                    break;
                }
                final Node<K, V> node3 = node;
                BytecodeManager.incBytecodes(2);
                final V validValue = node3.getValidValue();
                BytecodeManager.incBytecodes(3);
                if (validValue != null) {
                    final K key = node.key;
                    final V v = validValue;
                    BytecodeManager.incBytecodes(5);
                    biConsumer.accept(key, v);
                }
                node = node.next;
                BytecodeManager.incBytecodes(4);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void replaceAll(final BiFunction<? super K, ? super V, ? extends V> biFunction) {
        try {
            BytecodeManager.incBytecodes(2);
            if (biFunction == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(2);
            Node<K, V> node = this.findFirst();
            BytecodeManager.incBytecodes(1);
            while (true) {
                final Node<K, V> node2 = node;
                BytecodeManager.incBytecodes(2);
                if (node2 == null) {
                    BytecodeManager.incBytecodes(1);
                    return;
                }
                while (true) {
                    final Node<K, V> node3 = node;
                    BytecodeManager.incBytecodes(2);
                    final V validValue;
                    final V v = validValue = node3.getValidValue();
                    BytecodeManager.incBytecodes(3);
                    if (v == null) {
                        break;
                    }
                    final K key = node.key;
                    final V v2 = validValue;
                    BytecodeManager.incBytecodes(5);
                    final V apply = (V)biFunction.apply(key, v2);
                    BytecodeManager.incBytecodes(1);
                    final V v3 = apply;
                    BytecodeManager.incBytecodes(2);
                    if (v3 == null) {
                        BytecodeManager.incBytecodes(3);
                        final NullPointerException ex2 = new NullPointerException();
                        BytecodeManager.incBytecodes(1);
                        throw ex2;
                    }
                    final Node<K, V> node4 = node;
                    final V v4 = validValue;
                    final V v5 = apply;
                    BytecodeManager.incBytecodes(4);
                    final boolean casValue = node4.casValue(v4, v5);
                    BytecodeManager.incBytecodes(1);
                    if (casValue) {
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    BytecodeManager.incBytecodes(1);
                }
                node = node.next;
                BytecodeManager.incBytecodes(4);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final KeySpliterator<K, V> keySpliterator() {
        try {
            final Comparator<? super K> comparator = this.comparator;
            BytecodeManager.incBytecodes(3);
            HeadIndex<K, V> head;
            Node<K, V> next;
            while (true) {
                final Node<K, V> node = (head = this.head).node;
                BytecodeManager.incBytecodes(6);
                final Node<K, V> node2 = next = node.next;
                BytecodeManager.incBytecodes(5);
                if (node2 == null) {
                    break;
                }
                final Object value = next.value;
                BytecodeManager.incBytecodes(3);
                if (value != null) {
                    break;
                }
                final Node<K, V> node3 = next;
                final Node<K, V> node4 = node;
                final Node<K, V> next2 = next.next;
                BytecodeManager.incBytecodes(5);
                node3.helpDelete(node4, next2);
                BytecodeManager.incBytecodes(1);
            }
            final Comparator<? super K> comparator2 = comparator;
            final HeadIndex<K, V> headIndex = head;
            final Node<K, V> node5 = next;
            final K k = null;
            final Node<K, V> node6 = next;
            BytecodeManager.incBytecodes(8);
            int n;
            if (node6 == null) {
                n = 0;
                BytecodeManager.incBytecodes(2);
            }
            else {
                n = Integer.MAX_VALUE;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            final KeySpliterator keySpliterator = new KeySpliterator<K, V>(comparator2, headIndex, node5, k, n);
            BytecodeManager.incBytecodes(1);
            return (KeySpliterator<K, V>)keySpliterator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final ValueSpliterator<K, V> valueSpliterator() {
        try {
            final Comparator<? super K> comparator = this.comparator;
            BytecodeManager.incBytecodes(3);
            HeadIndex<K, V> head;
            Node<K, V> next;
            while (true) {
                final Node<K, V> node = (head = this.head).node;
                BytecodeManager.incBytecodes(6);
                final Node<K, V> node2 = next = node.next;
                BytecodeManager.incBytecodes(5);
                if (node2 == null) {
                    break;
                }
                final Object value = next.value;
                BytecodeManager.incBytecodes(3);
                if (value != null) {
                    break;
                }
                final Node<K, V> node3 = next;
                final Node<K, V> node4 = node;
                final Node<K, V> next2 = next.next;
                BytecodeManager.incBytecodes(5);
                node3.helpDelete(node4, next2);
                BytecodeManager.incBytecodes(1);
            }
            final Comparator<? super K> comparator2 = comparator;
            final HeadIndex<K, V> headIndex = head;
            final Node<K, V> node5 = next;
            final K k = null;
            final Node<K, V> node6 = next;
            BytecodeManager.incBytecodes(8);
            int n;
            if (node6 == null) {
                n = 0;
                BytecodeManager.incBytecodes(2);
            }
            else {
                n = Integer.MAX_VALUE;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            final ValueSpliterator valueSpliterator = new ValueSpliterator<K, V>(comparator2, headIndex, node5, k, n);
            BytecodeManager.incBytecodes(1);
            return (ValueSpliterator<K, V>)valueSpliterator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final EntrySpliterator<K, V> entrySpliterator() {
        try {
            final Comparator<? super K> comparator = this.comparator;
            BytecodeManager.incBytecodes(3);
            HeadIndex<K, V> head;
            Node<K, V> next;
            while (true) {
                final Node<K, V> node = (head = this.head).node;
                BytecodeManager.incBytecodes(6);
                final Node<K, V> node2 = next = node.next;
                BytecodeManager.incBytecodes(5);
                if (node2 == null) {
                    break;
                }
                final Object value = next.value;
                BytecodeManager.incBytecodes(3);
                if (value != null) {
                    break;
                }
                final Node<K, V> node3 = next;
                final Node<K, V> node4 = node;
                final Node<K, V> next2 = next.next;
                BytecodeManager.incBytecodes(5);
                node3.helpDelete(node4, next2);
                BytecodeManager.incBytecodes(1);
            }
            final Comparator<? super K> comparator2 = comparator;
            final HeadIndex<K, V> headIndex = head;
            final Node<K, V> node5 = next;
            final K k = null;
            final Node<K, V> node6 = next;
            BytecodeManager.incBytecodes(8);
            int n;
            if (node6 == null) {
                n = 0;
                BytecodeManager.incBytecodes(2);
            }
            else {
                n = Integer.MAX_VALUE;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            final EntrySpliterator entrySpliterator = new EntrySpliterator<K, V>(comparator2, headIndex, node5, k, n);
            BytecodeManager.incBytecodes(1);
            return (EntrySpliterator<K, V>)entrySpliterator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static /* synthetic */ Object access$000() {
        try {
            final Object base_HEADER = ConcurrentSkipListMap.BASE_HEADER;
            BytecodeManager.incBytecodes(2);
            return base_HEADER;
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
        //     9: invokespecial   java/lang/Object.<init>:()V
        //    12: putstatic       instrumented/java/util/concurrent/ConcurrentSkipListMap.BASE_HEADER:Ljava/lang/Object;
        //    15: ldc             1
        //    17: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    20: ldc             1
        //    22: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    25: invokestatic    sun/misc/Unsafe.getUnsafe:()Lsun/misc/Unsafe;
        //    28: putstatic       instrumented/java/util/concurrent/ConcurrentSkipListMap.UNSAFE:Lsun/misc/Unsafe;
        //    31: ldc             1
        //    33: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    36: ldc             Linstrumented/java/util/concurrent/ConcurrentSkipListMap;.class
        //    38: astore_0       
        //    39: ldc             2
        //    41: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    44: getstatic       instrumented/java/util/concurrent/ConcurrentSkipListMap.UNSAFE:Lsun/misc/Unsafe;
        //    47: aload_0        
        //    48: ldc_w           "head"
        //    51: ldc             3
        //    53: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    56: ldc             1
        //    58: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    61: invokevirtual   java/lang/Class.getDeclaredField:(Ljava/lang/String;)Ljava/lang/reflect/Field;
        //    64: ldc             1
        //    66: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    69: invokevirtual   sun/misc/Unsafe.objectFieldOffset:(Ljava/lang/reflect/Field;)J
        //    72: putstatic       instrumented/java/util/concurrent/ConcurrentSkipListMap.headOffset:J
        //    75: ldc             1
        //    77: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    80: ldc_w           Ljava/lang/Thread;.class
        //    83: astore_1       
        //    84: ldc             2
        //    86: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    89: getstatic       instrumented/java/util/concurrent/ConcurrentSkipListMap.UNSAFE:Lsun/misc/Unsafe;
        //    92: aload_1        
        //    93: ldc_w           "threadLocalRandomSecondarySeed"
        //    96: ldc             3
        //    98: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   101: ldc             1
        //   103: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   106: invokevirtual   java/lang/Class.getDeclaredField:(Ljava/lang/String;)Ljava/lang/reflect/Field;
        //   109: ldc             1
        //   111: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   114: invokevirtual   sun/misc/Unsafe.objectFieldOffset:(Ljava/lang/reflect/Field;)J
        //   117: putstatic       instrumented/java/util/concurrent/ConcurrentSkipListMap.SECONDARY:J
        //   120: ldc             1
        //   122: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   125: ldc             1
        //   127: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   130: goto            159
        //   133: astore_0       
        //   134: ldc_w           501
        //   137: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   140: new             Ljava/lang/Error;
        //   143: dup            
        //   144: aload_0        
        //   145: ldc             4
        //   147: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   150: invokespecial   java/lang/Error.<init>:(Ljava/lang/Throwable;)V
        //   153: ldc             1
        //   155: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   158: athrow         
        //   159: ldc             1
        //   161: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   164: return         
        //   165: athrow         
        //   166: athrow         
        //    StackMapTable: 00 04 F7 00 85 07 02 22 19 FF 00 05 00 00 00 01 07 00 84 FF 00 00 00 00 00 01 07 01 38
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  20     166    166    167    Ljava/lang/VirtualMachineError;
        //  20     125    133    159    Ljava/lang/Exception;
        //  0      165    165    166    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0159:
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
    
    static final class Node<K, V>
    {
        final K key;
        volatile Object value;
        volatile Node<K, V> next;
        private static final Unsafe UNSAFE;
        private static final long valueOffset;
        private static final long nextOffset;
        
        Node(final K key, final Object value, final Node<K, V> next) {
            try {
                BytecodeManager.incBytecodes(2);
                this.key = key;
                BytecodeManager.incBytecodes(3);
                this.value = value;
                BytecodeManager.incBytecodes(3);
                this.next = next;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        Node(final Node<K, V> next) {
            try {
                BytecodeManager.incBytecodes(2);
                this.key = null;
                BytecodeManager.incBytecodes(3);
                this.value = this;
                BytecodeManager.incBytecodes(3);
                this.next = next;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        boolean casValue(final Object expected, final Object x) {
            try {
                final Unsafe unsafe = Node.UNSAFE;
                final long valueOffset = Node.valueOffset;
                BytecodeManager.incBytecodes(6);
                final boolean compareAndSwapObject = unsafe.compareAndSwapObject(this, valueOffset, expected, x);
                BytecodeManager.incBytecodes(1);
                return compareAndSwapObject;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        boolean casNext(final Node<K, V> expected, final Node<K, V> x) {
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
        
        boolean isMarker() {
            try {
                final Object value = this.value;
                BytecodeManager.incBytecodes(4);
                boolean b;
                if (value == this) {
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
        
        boolean isBaseHeader() {
            try {
                final Object value = this.value;
                BytecodeManager.incBytecodes(3);
                final Object access$000 = ConcurrentSkipListMap.access$000();
                BytecodeManager.incBytecodes(1);
                boolean b;
                if (value == access$000) {
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
        
        boolean appendMarker(final Node<K, V> node) {
            try {
                BytecodeManager.incBytecodes(6);
                final Node node2 = new Node((Node<Object, Object>)node);
                BytecodeManager.incBytecodes(1);
                final boolean casNext = this.casNext(node, node2);
                BytecodeManager.incBytecodes(1);
                return casNext;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        void helpDelete(final Node<K, V> node, final Node<K, V> node2) {
            try {
                final Node<K, V> next = this.next;
                BytecodeManager.incBytecodes(4);
                Label_0100: {
                    if (node2 == next) {
                        final Node<K, V> next2 = node.next;
                        BytecodeManager.incBytecodes(4);
                        if (this == next2) {
                            BytecodeManager.incBytecodes(2);
                            if (node2 != null) {
                                final Object value = node2.value;
                                BytecodeManager.incBytecodes(4);
                                if (value == node2) {
                                    final Node<K, V> next3 = node2.next;
                                    BytecodeManager.incBytecodes(5);
                                    node.casNext(this, next3);
                                    BytecodeManager.incBytecodes(1);
                                    break Label_0100;
                                }
                            }
                            BytecodeManager.incBytecodes(6);
                            final Node node3 = new Node((Node<Object, Object>)node2);
                            BytecodeManager.incBytecodes(1);
                            this.casNext(node2, node3);
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
        
        V getValidValue() {
            try {
                final Object value = this.value;
                BytecodeManager.incBytecodes(3);
                final Object o = value;
                BytecodeManager.incBytecodes(3);
                if (o != this) {
                    final Object o2 = value;
                    BytecodeManager.incBytecodes(2);
                    final Object access$000 = ConcurrentSkipListMap.access$000();
                    BytecodeManager.incBytecodes(1);
                    if (o2 != access$000) {
                        final Object o3 = value;
                        BytecodeManager.incBytecodes(2);
                        final Object o4 = o3;
                        BytecodeManager.incBytecodes(2);
                        return (V)o4;
                    }
                }
                final V v = null;
                BytecodeManager.incBytecodes(2);
                return v;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        SimpleImmutableEntry<K, V> createSnapshot() {
            try {
                final Object value = this.value;
                BytecodeManager.incBytecodes(3);
                final Object o = value;
                BytecodeManager.incBytecodes(2);
                if (o != null) {
                    final Object o2 = value;
                    BytecodeManager.incBytecodes(3);
                    if (o2 != this) {
                        final Object o3 = value;
                        BytecodeManager.incBytecodes(2);
                        final Object access$000 = ConcurrentSkipListMap.access$000();
                        BytecodeManager.incBytecodes(1);
                        if (o3 != access$000) {
                            final Object o4 = value;
                            BytecodeManager.incBytecodes(2);
                            final K key = this.key;
                            final V v = (V)o4;
                            BytecodeManager.incBytecodes(6);
                            final SimpleImmutableEntry simpleImmutableEntry = new SimpleImmutableEntry<K, V>(key, v);
                            BytecodeManager.incBytecodes(1);
                            return (SimpleImmutableEntry<K, V>)simpleImmutableEntry;
                        }
                    }
                }
                final SimpleImmutableEntry<K, V> simpleImmutableEntry2 = null;
                BytecodeManager.incBytecodes(2);
                return simpleImmutableEntry2;
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
                        final String name = "value";
                        BytecodeManager.incBytecodes(3);
                        BytecodeManager.incBytecodes(1);
                        final Field declaredField = clazz2.getDeclaredField(name);
                        BytecodeManager.incBytecodes(1);
                        valueOffset = unsafe.objectFieldOffset(declaredField);
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
    
    static class Index<K, V>
    {
        final Node<K, V> node;
        final Index<K, V> down;
        volatile Index<K, V> right;
        private static final Unsafe UNSAFE;
        private static final long rightOffset;
        
        Index(final Node<K, V> node, final Index<K, V> down, final Index<K, V> right) {
            try {
                BytecodeManager.incBytecodes(2);
                this.node = node;
                BytecodeManager.incBytecodes(3);
                this.down = down;
                BytecodeManager.incBytecodes(3);
                this.right = right;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        final boolean casRight(final Index<K, V> expected, final Index<K, V> x) {
            try {
                final Unsafe unsafe = Index.UNSAFE;
                final long rightOffset = Index.rightOffset;
                BytecodeManager.incBytecodes(6);
                final boolean compareAndSwapObject = unsafe.compareAndSwapObject(this, rightOffset, expected, x);
                BytecodeManager.incBytecodes(1);
                return compareAndSwapObject;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        final boolean indexesDeletedNode() {
            try {
                final Object value = this.node.value;
                BytecodeManager.incBytecodes(4);
                boolean b;
                if (value == null) {
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
        
        final boolean link(final Index<K, V> right, final Index<K, V> index) {
            try {
                final Node<K, V> node = this.node;
                BytecodeManager.incBytecodes(3);
                index.right = right;
                BytecodeManager.incBytecodes(3);
                final Object value = node.value;
                BytecodeManager.incBytecodes(3);
                boolean b = false;
                Label_0066: {
                    if (value != null) {
                        BytecodeManager.incBytecodes(4);
                        final boolean casRight = this.casRight(right, index);
                        BytecodeManager.incBytecodes(1);
                        if (casRight) {
                            b = true;
                            BytecodeManager.incBytecodes(2);
                            break Label_0066;
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
        
        final boolean unlink(final Index<K, V> index) {
            try {
                final Object value = this.node.value;
                BytecodeManager.incBytecodes(4);
                boolean b = false;
                Label_0052: {
                    if (value != null) {
                        final Index<K, V> right = index.right;
                        BytecodeManager.incBytecodes(5);
                        final boolean casRight = this.casRight(index, right);
                        BytecodeManager.incBytecodes(1);
                        if (casRight) {
                            b = true;
                            BytecodeManager.incBytecodes(2);
                            break Label_0052;
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
        
        static {
            try {
                try {
                    try {
                        BytecodeManager.incBytecodes(1);
                        UNSAFE = Unsafe.getUnsafe();
                        BytecodeManager.incBytecodes(1);
                        final Class<Index> clazz = Index.class;
                        BytecodeManager.incBytecodes(2);
                        final Unsafe unsafe = Index.UNSAFE;
                        final Class<Index> clazz2 = clazz;
                        final String name = "right";
                        BytecodeManager.incBytecodes(3);
                        BytecodeManager.incBytecodes(1);
                        final Field declaredField = clazz2.getDeclaredField(name);
                        BytecodeManager.incBytecodes(1);
                        rightOffset = unsafe.objectFieldOffset(declaredField);
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
    
    static final class HeadIndex<K, V> extends Index<K, V>
    {
        final int level;
        
        HeadIndex(final Node<K, V> node, final Index<K, V> index, final Index<K, V> index2, final int level) {
            try {
                BytecodeManager.incBytecodes(5);
                super(node, index, index2);
                this.level = level;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    abstract class Iter<T> implements Iterator<T>
    {
        Node<K, V> lastReturned;
        Node<K, V> next;
        V nextValue;
        
        Iter() {
            try {
                BytecodeManager.incBytecodes(5);
                while (true) {
                    BytecodeManager.incBytecodes(3);
                    final Node<K, V> first = ConcurrentSkipListMap.this.findFirst();
                    this.next = first;
                    BytecodeManager.incBytecodes(3);
                    if (first == null) {
                        break;
                    }
                    final Object value = this.next.value;
                    BytecodeManager.incBytecodes(4);
                    final Object o = value;
                    BytecodeManager.incBytecodes(2);
                    if (o != null) {
                        final Object o2 = value;
                        final Node<K, V> next = this.next;
                        BytecodeManager.incBytecodes(4);
                        if (o2 != next) {
                            final Node<K, V> nextValue = (Node<K, V>)value;
                            BytecodeManager.incBytecodes(2);
                            this.nextValue = (V)nextValue;
                            BytecodeManager.incBytecodes(3);
                            BytecodeManager.incBytecodes(1);
                            break;
                        }
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
        public final boolean hasNext() {
            try {
                final Node<K, V> next = this.next;
                BytecodeManager.incBytecodes(3);
                boolean b;
                if (next != null) {
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
        
        final void advance() {
            try {
                final Node<K, V> next = this.next;
                BytecodeManager.incBytecodes(3);
                if (next == null) {
                    BytecodeManager.incBytecodes(3);
                    final NoSuchElementException ex = new NoSuchElementException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                this.lastReturned = this.next;
                BytecodeManager.incBytecodes(4);
                while (true) {
                    final Node<K, V> next2 = this.next.next;
                    this.next = next2;
                    BytecodeManager.incBytecodes(7);
                    if (next2 == null) {
                        break;
                    }
                    final Object value = this.next.value;
                    BytecodeManager.incBytecodes(4);
                    final Object o = value;
                    BytecodeManager.incBytecodes(2);
                    if (o != null) {
                        final Object o2 = value;
                        final Node<K, V> next3 = this.next;
                        BytecodeManager.incBytecodes(4);
                        if (o2 != next3) {
                            final Node<K, V> nextValue = (Node<K, V>)value;
                            BytecodeManager.incBytecodes(2);
                            this.nextValue = (V)nextValue;
                            BytecodeManager.incBytecodes(3);
                            BytecodeManager.incBytecodes(1);
                            break;
                        }
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
        public void remove() {
            try {
                final Node<K, V> lastReturned = this.lastReturned;
                BytecodeManager.incBytecodes(3);
                final Node<K, V> node = lastReturned;
                BytecodeManager.incBytecodes(2);
                if (node == null) {
                    BytecodeManager.incBytecodes(3);
                    final IllegalStateException ex = new IllegalStateException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final ConcurrentSkipListMap this$0 = ConcurrentSkipListMap.this;
                final K key = lastReturned.key;
                BytecodeManager.incBytecodes(5);
                this$0.remove(key);
                BytecodeManager.incBytecodes(1);
                this.lastReturned = null;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    final class ValueIterator extends Iter<V>
    {
        ValueIterator() {
            try {
                BytecodeManager.incBytecodes(6);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public V next() {
            try {
                final V nextValue = this.nextValue;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(2);
                this.advance();
                final V v = nextValue;
                BytecodeManager.incBytecodes(2);
                return v;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    final class KeyIterator extends Iter<K>
    {
        KeyIterator() {
            try {
                BytecodeManager.incBytecodes(6);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public K next() {
            try {
                final Node<K, V> next = this.next;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(2);
                this.advance();
                final K key = next.key;
                BytecodeManager.incBytecodes(3);
                return key;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    final class EntryIterator extends Iter<Map.Entry<K, V>>
    {
        EntryIterator() {
            try {
                BytecodeManager.incBytecodes(6);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Map.Entry<K, V> next() {
            try {
                final Node<K, V> next = this.next;
                BytecodeManager.incBytecodes(3);
                final V nextValue = this.nextValue;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(2);
                this.advance();
                final K key = next.key;
                final V v = nextValue;
                BytecodeManager.incBytecodes(6);
                final SimpleImmutableEntry simpleImmutableEntry = new SimpleImmutableEntry<K, V>(key, v);
                BytecodeManager.incBytecodes(1);
                return (Map.Entry<K, V>)simpleImmutableEntry;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class KeySet<E> extends AbstractSet<E> implements NavigableSet<E>
    {
        final ConcurrentNavigableMap<E, ?> m;
        
        KeySet(final ConcurrentNavigableMap<E, ?> m) {
            try {
                BytecodeManager.incBytecodes(2);
                this.m = m;
                BytecodeManager.incBytecodes(4);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int size() {
            try {
                final ConcurrentNavigableMap<E, ?> m = this.m;
                BytecodeManager.incBytecodes(3);
                final int size = m.size();
                BytecodeManager.incBytecodes(1);
                return size;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean isEmpty() {
            try {
                final ConcurrentNavigableMap<E, ?> m = this.m;
                BytecodeManager.incBytecodes(3);
                final boolean empty = m.isEmpty();
                BytecodeManager.incBytecodes(1);
                return empty;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean contains(final Object o) {
            try {
                final ConcurrentNavigableMap<E, ?> m = this.m;
                BytecodeManager.incBytecodes(4);
                final boolean containsKey = m.containsKey(o);
                BytecodeManager.incBytecodes(1);
                return containsKey;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean remove(final Object o) {
            try {
                final ConcurrentNavigableMap<E, ?> m = this.m;
                BytecodeManager.incBytecodes(4);
                final Object remove = m.remove(o);
                BytecodeManager.incBytecodes(1);
                boolean b;
                if (remove != null) {
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
        public void clear() {
            try {
                final ConcurrentNavigableMap<E, ?> m = this.m;
                BytecodeManager.incBytecodes(3);
                m.clear();
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public E lower(final E e) {
            try {
                final ConcurrentNavigableMap<E, ?> m = this.m;
                BytecodeManager.incBytecodes(4);
                final E lowerKey = m.lowerKey(e);
                BytecodeManager.incBytecodes(1);
                return lowerKey;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public E floor(final E e) {
            try {
                final ConcurrentNavigableMap<E, ?> m = this.m;
                BytecodeManager.incBytecodes(4);
                final E floorKey = m.floorKey(e);
                BytecodeManager.incBytecodes(1);
                return floorKey;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public E ceiling(final E e) {
            try {
                final ConcurrentNavigableMap<E, ?> m = this.m;
                BytecodeManager.incBytecodes(4);
                final E ceilingKey = m.ceilingKey(e);
                BytecodeManager.incBytecodes(1);
                return ceilingKey;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public E higher(final E e) {
            try {
                final ConcurrentNavigableMap<E, ?> m = this.m;
                BytecodeManager.incBytecodes(4);
                final E higherKey = m.higherKey(e);
                BytecodeManager.incBytecodes(1);
                return higherKey;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Comparator<? super E> comparator() {
            try {
                final ConcurrentNavigableMap<E, ?> m = this.m;
                BytecodeManager.incBytecodes(3);
                final Comparator<? super Object> comparator = m.comparator();
                BytecodeManager.incBytecodes(1);
                return comparator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public E first() {
            try {
                final ConcurrentNavigableMap<E, ?> m = this.m;
                BytecodeManager.incBytecodes(3);
                final E firstKey = m.firstKey();
                BytecodeManager.incBytecodes(1);
                return firstKey;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public E last() {
            try {
                final ConcurrentNavigableMap<E, ?> m = this.m;
                BytecodeManager.incBytecodes(3);
                final E lastKey = m.lastKey();
                BytecodeManager.incBytecodes(1);
                return lastKey;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public E pollFirst() {
            try {
                final ConcurrentNavigableMap<E, ?> m = this.m;
                BytecodeManager.incBytecodes(3);
                final Map.Entry<Object, V> pollFirstEntry = m.pollFirstEntry();
                BytecodeManager.incBytecodes(1);
                final Map.Entry<Object, V> entry = pollFirstEntry;
                BytecodeManager.incBytecodes(2);
                Object key;
                if (entry == null) {
                    key = null;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final Map.Entry<Object, V> entry2 = pollFirstEntry;
                    BytecodeManager.incBytecodes(2);
                    key = entry2.getKey();
                }
                BytecodeManager.incBytecodes(1);
                return (E)key;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public E pollLast() {
            try {
                final ConcurrentNavigableMap<E, ?> m = this.m;
                BytecodeManager.incBytecodes(3);
                final Map.Entry<Object, V> pollLastEntry = m.pollLastEntry();
                BytecodeManager.incBytecodes(1);
                final Map.Entry<Object, V> entry = pollLastEntry;
                BytecodeManager.incBytecodes(2);
                Object key;
                if (entry == null) {
                    key = null;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final Map.Entry<Object, V> entry2 = pollLastEntry;
                    BytecodeManager.incBytecodes(2);
                    key = entry2.getKey();
                }
                BytecodeManager.incBytecodes(1);
                return (E)key;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Iterator<E> iterator() {
            try {
                final boolean b = this.m instanceof ConcurrentSkipListMap;
                BytecodeManager.incBytecodes(4);
                if (b) {
                    final ConcurrentSkipListMap concurrentSkipListMap = (ConcurrentSkipListMap)this.m;
                    BytecodeManager.incBytecodes(4);
                    final Iterator<E> keyIterator = concurrentSkipListMap.keyIterator();
                    BytecodeManager.incBytecodes(1);
                    return keyIterator;
                }
                final SubMap subMap = (SubMap)this.m;
                BytecodeManager.incBytecodes(4);
                final Iterator<E> keyIterator2 = subMap.keyIterator();
                BytecodeManager.incBytecodes(1);
                return keyIterator2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean equals(final Object p0) {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: aload_0        
            //     2: ldc             3
            //     4: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //     7: if_acmpne       17
            //    10: iconst_1       
            //    11: ldc             2
            //    13: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    16: ireturn        
            //    17: aload_1        
            //    18: instanceof      Linstrumented/java/util/Set;
            //    21: ldc             3
            //    23: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    26: ifne            36
            //    29: iconst_0       
            //    30: ldc             2
            //    32: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    35: ireturn        
            //    36: aload_1        
            //    37: checkcast       Linstrumented/java/util/Collection;
            //    40: astore_2       
            //    41: ldc             3
            //    43: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    46: aload_0        
            //    47: aload_2        
            //    48: ldc             3
            //    50: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    53: invokevirtual   instrumented/java/util/concurrent/ConcurrentSkipListMap$KeySet.containsAll:(Linstrumented/java/util/Collection;)Z
            //    56: ldc             1
            //    58: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    61: ifeq            93
            //    64: aload_2        
            //    65: aload_0        
            //    66: ldc             3
            //    68: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    71: invokeinterface instrumented/java/util/Collection.containsAll:(Linstrumented/java/util/Collection;)Z
            //    76: ldc             1
            //    78: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    81: ifeq            93
            //    84: iconst_1       
            //    85: ldc             2
            //    87: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    90: goto            99
            //    93: iconst_0       
            //    94: ldc             1
            //    96: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    99: ldc             1
            //   101: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   104: ireturn        
            //   105: astore_3       
            //   106: ldc             501
            //   108: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   111: iconst_0       
            //   112: ldc             2
            //   114: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   117: ireturn        
            //   118: astore_3       
            //   119: ldc             501
            //   121: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   124: iconst_0       
            //   125: ldc             2
            //   127: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   130: ireturn        
            //   131: athrow         
            //   132: athrow         
            //    StackMapTable: 00 08 11 12 FC 00 38 07 00 7E 45 01 45 07 00 78 4C 07 00 7A FF 00 0C 00 00 00 01 07 00 2A FF 00 00 00 00 00 01 07 00 76
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                            
            //  -----  -----  -----  -----  --------------------------------
            //  46     132    132    133    Ljava/lang/VirtualMachineError;
            //  46     99     105    118    Ljava/lang/ClassCastException;
            //  46     99     118    131    Ljava/lang/NullPointerException;
            //  0      131    131    132    Any
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0093:
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
        public Object[] toArray() {
            try {
                BytecodeManager.incBytecodes(2);
                final List<Object> list = ConcurrentSkipListMap.toList((Collection<Object>)this);
                BytecodeManager.incBytecodes(1);
                final Object[] array = list.toArray();
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
                final List<Object> list = ConcurrentSkipListMap.toList((Collection<Object>)this);
                BytecodeManager.incBytecodes(2);
                final T[] array2 = list.toArray(array);
                BytecodeManager.incBytecodes(1);
                return array2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Iterator<E> descendingIterator() {
            try {
                BytecodeManager.incBytecodes(2);
                final NavigableSet<E> descendingSet = this.descendingSet();
                BytecodeManager.incBytecodes(1);
                final Iterator<E> iterator = descendingSet.iterator();
                BytecodeManager.incBytecodes(1);
                return iterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public NavigableSet<E> subSet(final E e, final boolean b, final E e2, final boolean b2) {
            try {
                final ConcurrentNavigableMap<E, ?> m = this.m;
                BytecodeManager.incBytecodes(9);
                final ConcurrentNavigableMap<E, ?> subMap = m.subMap(e, b, e2, b2);
                BytecodeManager.incBytecodes(1);
                final KeySet set = new KeySet((ConcurrentNavigableMap<Object, ?>)subMap);
                BytecodeManager.incBytecodes(1);
                return set;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public NavigableSet<E> headSet(final E e, final boolean b) {
            try {
                final ConcurrentNavigableMap<E, ?> m = this.m;
                BytecodeManager.incBytecodes(7);
                final ConcurrentNavigableMap<E, ?> headMap = m.headMap(e, b);
                BytecodeManager.incBytecodes(1);
                final KeySet set = new KeySet((ConcurrentNavigableMap<Object, ?>)headMap);
                BytecodeManager.incBytecodes(1);
                return set;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public NavigableSet<E> tailSet(final E e, final boolean b) {
            try {
                final ConcurrentNavigableMap<E, ?> m = this.m;
                BytecodeManager.incBytecodes(7);
                final ConcurrentNavigableMap<E, ?> tailMap = m.tailMap(e, b);
                BytecodeManager.incBytecodes(1);
                final KeySet set = new KeySet((ConcurrentNavigableMap<Object, ?>)tailMap);
                BytecodeManager.incBytecodes(1);
                return set;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public NavigableSet<E> subSet(final E e, final E e2) {
            try {
                final boolean b = true;
                final boolean b2 = false;
                BytecodeManager.incBytecodes(6);
                final NavigableSet<E> subSet = this.subSet(e, b, e2, b2);
                BytecodeManager.incBytecodes(1);
                return subSet;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public NavigableSet<E> headSet(final E e) {
            try {
                final boolean b = false;
                BytecodeManager.incBytecodes(4);
                final NavigableSet<E> headSet = this.headSet(e, b);
                BytecodeManager.incBytecodes(1);
                return headSet;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public NavigableSet<E> tailSet(final E e) {
            try {
                final boolean b = true;
                BytecodeManager.incBytecodes(4);
                final NavigableSet<E> tailSet = this.tailSet(e, b);
                BytecodeManager.incBytecodes(1);
                return tailSet;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public NavigableSet<E> descendingSet() {
            try {
                final ConcurrentNavigableMap<E, ?> m = this.m;
                BytecodeManager.incBytecodes(5);
                final ConcurrentNavigableMap<E, ?> descendingMap = m.descendingMap();
                BytecodeManager.incBytecodes(1);
                final KeySet set = new KeySet((ConcurrentNavigableMap<Object, ?>)descendingMap);
                BytecodeManager.incBytecodes(1);
                return set;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Spliterator<E> spliterator() {
            try {
                final boolean b = this.m instanceof ConcurrentSkipListMap;
                BytecodeManager.incBytecodes(4);
                if (b) {
                    final ConcurrentSkipListMap concurrentSkipListMap = (ConcurrentSkipListMap)this.m;
                    BytecodeManager.incBytecodes(4);
                    final KeySpliterator<E, Object> keySpliterator = concurrentSkipListMap.keySpliterator();
                    BytecodeManager.incBytecodes(1);
                    return keySpliterator;
                }
                final SubMap subMap = (SubMap)this.m;
                BytecodeManager.incBytecodes(4);
                final Spliterator spliterator = (Spliterator)subMap.keyIterator();
                BytecodeManager.incBytecodes(2);
                return (Spliterator<E>)spliterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class Values<E> extends AbstractCollection<E>
    {
        final ConcurrentNavigableMap<?, E> m;
        
        Values(final ConcurrentNavigableMap<?, E> m) {
            try {
                BytecodeManager.incBytecodes(2);
                this.m = m;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Iterator<E> iterator() {
            try {
                final boolean b = this.m instanceof ConcurrentSkipListMap;
                BytecodeManager.incBytecodes(4);
                if (b) {
                    final ConcurrentSkipListMap concurrentSkipListMap = (ConcurrentSkipListMap)this.m;
                    BytecodeManager.incBytecodes(4);
                    final Iterator<E> valueIterator = concurrentSkipListMap.valueIterator();
                    BytecodeManager.incBytecodes(1);
                    return valueIterator;
                }
                final SubMap subMap = (SubMap)this.m;
                BytecodeManager.incBytecodes(4);
                final Iterator<E> valueIterator2 = subMap.valueIterator();
                BytecodeManager.incBytecodes(1);
                return valueIterator2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean isEmpty() {
            try {
                final ConcurrentNavigableMap<?, E> m = this.m;
                BytecodeManager.incBytecodes(3);
                final boolean empty = m.isEmpty();
                BytecodeManager.incBytecodes(1);
                return empty;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int size() {
            try {
                final ConcurrentNavigableMap<?, E> m = this.m;
                BytecodeManager.incBytecodes(3);
                final int size = m.size();
                BytecodeManager.incBytecodes(1);
                return size;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean contains(final Object o) {
            try {
                final ConcurrentNavigableMap<?, E> m = this.m;
                BytecodeManager.incBytecodes(4);
                final boolean containsValue = m.containsValue(o);
                BytecodeManager.incBytecodes(1);
                return containsValue;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void clear() {
            try {
                final ConcurrentNavigableMap<?, E> m = this.m;
                BytecodeManager.incBytecodes(3);
                m.clear();
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
                final List<Object> list = ConcurrentSkipListMap.toList((Collection<Object>)this);
                BytecodeManager.incBytecodes(1);
                final Object[] array = list.toArray();
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
                final List<Object> list = ConcurrentSkipListMap.toList((Collection<Object>)this);
                BytecodeManager.incBytecodes(2);
                final T[] array2 = list.toArray(array);
                BytecodeManager.incBytecodes(1);
                return array2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Spliterator<E> spliterator() {
            try {
                final boolean b = this.m instanceof ConcurrentSkipListMap;
                BytecodeManager.incBytecodes(4);
                if (b) {
                    final ConcurrentSkipListMap concurrentSkipListMap = (ConcurrentSkipListMap)this.m;
                    BytecodeManager.incBytecodes(4);
                    final ValueSpliterator<Object, E> valueSpliterator = concurrentSkipListMap.valueSpliterator();
                    BytecodeManager.incBytecodes(1);
                    return valueSpliterator;
                }
                final SubMap subMap = (SubMap)this.m;
                BytecodeManager.incBytecodes(4);
                final Spliterator spliterator = (Spliterator)subMap.valueIterator();
                BytecodeManager.incBytecodes(2);
                return (Spliterator<E>)spliterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class EntrySet<K1, V1> extends AbstractSet<Map.Entry<K1, V1>>
    {
        final ConcurrentNavigableMap<K1, V1> m;
        
        EntrySet(final ConcurrentNavigableMap<K1, V1> m) {
            try {
                BytecodeManager.incBytecodes(2);
                this.m = m;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Iterator<Map.Entry<K1, V1>> iterator() {
            try {
                final boolean b = this.m instanceof ConcurrentSkipListMap;
                BytecodeManager.incBytecodes(4);
                if (b) {
                    final ConcurrentSkipListMap concurrentSkipListMap = (ConcurrentSkipListMap)this.m;
                    BytecodeManager.incBytecodes(4);
                    final Iterator<Map.Entry<K1, V1>> entryIterator = concurrentSkipListMap.entryIterator();
                    BytecodeManager.incBytecodes(1);
                    return entryIterator;
                }
                final SubMap subMap = (SubMap)this.m;
                BytecodeManager.incBytecodes(4);
                final Iterator<Map.Entry<K1, V1>> entryIterator2 = subMap.entryIterator();
                BytecodeManager.incBytecodes(1);
                return entryIterator2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean contains(final Object o) {
            try {
                final boolean b = o instanceof Map.Entry;
                BytecodeManager.incBytecodes(3);
                if (!b) {
                    final boolean b2 = false;
                    BytecodeManager.incBytecodes(2);
                    return b2;
                }
                final Map.Entry entry = (Map.Entry)o;
                BytecodeManager.incBytecodes(3);
                final ConcurrentNavigableMap<K1, V1> m = this.m;
                final Map.Entry entry2 = entry;
                BytecodeManager.incBytecodes(4);
                final Object key = entry2.getKey();
                BytecodeManager.incBytecodes(1);
                final Object value = m.get(key);
                BytecodeManager.incBytecodes(1);
                final Object o2 = value;
                BytecodeManager.incBytecodes(2);
                boolean b3 = false;
                Label_0112: {
                    if (o2 != null) {
                        final Object o3 = value;
                        final Map.Entry entry3 = entry;
                        BytecodeManager.incBytecodes(3);
                        final Object value2 = entry3.getValue();
                        BytecodeManager.incBytecodes(1);
                        final boolean equals = o3.equals(value2);
                        BytecodeManager.incBytecodes(1);
                        if (equals) {
                            b3 = true;
                            BytecodeManager.incBytecodes(2);
                            break Label_0112;
                        }
                    }
                    b3 = false;
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
                return b3;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean remove(final Object o) {
            try {
                final boolean b = o instanceof Map.Entry;
                BytecodeManager.incBytecodes(3);
                if (!b) {
                    final boolean b2 = false;
                    BytecodeManager.incBytecodes(2);
                    return b2;
                }
                final Map.Entry entry = (Map.Entry)o;
                BytecodeManager.incBytecodes(3);
                final ConcurrentNavigableMap<K1, V1> m = this.m;
                final Map.Entry entry2 = entry;
                BytecodeManager.incBytecodes(4);
                final Object key = entry2.getKey();
                final Map.Entry entry3 = entry;
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                final Object value = entry3.getValue();
                BytecodeManager.incBytecodes(1);
                final boolean remove = m.remove(key, value);
                BytecodeManager.incBytecodes(1);
                return remove;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean isEmpty() {
            try {
                final ConcurrentNavigableMap<K1, V1> m = this.m;
                BytecodeManager.incBytecodes(3);
                final boolean empty = m.isEmpty();
                BytecodeManager.incBytecodes(1);
                return empty;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int size() {
            try {
                final ConcurrentNavigableMap<K1, V1> m = this.m;
                BytecodeManager.incBytecodes(3);
                final int size = m.size();
                BytecodeManager.incBytecodes(1);
                return size;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void clear() {
            try {
                final ConcurrentNavigableMap<K1, V1> m = this.m;
                BytecodeManager.incBytecodes(3);
                m.clear();
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean equals(final Object p0) {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: aload_0        
            //     2: ldc             3
            //     4: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //     7: if_acmpne       17
            //    10: iconst_1       
            //    11: ldc             2
            //    13: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    16: ireturn        
            //    17: aload_1        
            //    18: instanceof      Linstrumented/java/util/Set;
            //    21: ldc             3
            //    23: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    26: ifne            36
            //    29: iconst_0       
            //    30: ldc             2
            //    32: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    35: ireturn        
            //    36: aload_1        
            //    37: checkcast       Linstrumented/java/util/Collection;
            //    40: astore_2       
            //    41: ldc             3
            //    43: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    46: aload_0        
            //    47: aload_2        
            //    48: ldc             3
            //    50: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    53: invokevirtual   instrumented/java/util/concurrent/ConcurrentSkipListMap$EntrySet.containsAll:(Linstrumented/java/util/Collection;)Z
            //    56: ldc             1
            //    58: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    61: ifeq            93
            //    64: aload_2        
            //    65: aload_0        
            //    66: ldc             3
            //    68: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    71: invokeinterface instrumented/java/util/Collection.containsAll:(Linstrumented/java/util/Collection;)Z
            //    76: ldc             1
            //    78: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    81: ifeq            93
            //    84: iconst_1       
            //    85: ldc             2
            //    87: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    90: goto            99
            //    93: iconst_0       
            //    94: ldc             1
            //    96: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    99: ldc             1
            //   101: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   104: ireturn        
            //   105: astore_3       
            //   106: ldc             501
            //   108: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   111: iconst_0       
            //   112: ldc             2
            //   114: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   117: ireturn        
            //   118: astore_3       
            //   119: ldc             501
            //   121: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   124: iconst_0       
            //   125: ldc             2
            //   127: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   130: ireturn        
            //   131: athrow         
            //   132: athrow         
            //    StackMapTable: 00 08 11 12 FC 00 38 07 00 5D 45 01 45 07 00 57 4C 07 00 59 FF 00 0C 00 00 00 01 07 00 29 FF 00 00 00 00 00 01 07 00 55
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                            
            //  -----  -----  -----  -----  --------------------------------
            //  46     132    132    133    Ljava/lang/VirtualMachineError;
            //  46     99     105    118    Ljava/lang/ClassCastException;
            //  46     99     118    131    Ljava/lang/NullPointerException;
            //  0      131    131    132    Any
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0093:
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
        public Object[] toArray() {
            try {
                BytecodeManager.incBytecodes(2);
                final List<Object> list = ConcurrentSkipListMap.toList((Collection<Object>)this);
                BytecodeManager.incBytecodes(1);
                final Object[] array = list.toArray();
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
                final List<Object> list = ConcurrentSkipListMap.toList((Collection<Object>)this);
                BytecodeManager.incBytecodes(2);
                final T[] array2 = list.toArray(array);
                BytecodeManager.incBytecodes(1);
                return array2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Spliterator<Map.Entry<K1, V1>> spliterator() {
            try {
                final boolean b = this.m instanceof ConcurrentSkipListMap;
                BytecodeManager.incBytecodes(4);
                if (b) {
                    final ConcurrentSkipListMap concurrentSkipListMap = (ConcurrentSkipListMap)this.m;
                    BytecodeManager.incBytecodes(4);
                    final EntrySpliterator<K1, V1> entrySpliterator = concurrentSkipListMap.entrySpliterator();
                    BytecodeManager.incBytecodes(1);
                    return entrySpliterator;
                }
                final SubMap subMap = (SubMap)this.m;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
                final Spliterator spliterator = (Spliterator)subMap.entryIterator();
                BytecodeManager.incBytecodes(2);
                return (Spliterator<Map.Entry<K1, V1>>)spliterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class SubMap<K, V> extends AbstractMap<K, V> implements ConcurrentNavigableMap<K, V>, Cloneable, Serializable
    {
        private static final long serialVersionUID = -7647078645895051609L;
        private final ConcurrentSkipListMap<K, V> m;
        private final K lo;
        private final K hi;
        private final boolean loInclusive;
        private final boolean hiInclusive;
        private final boolean isDescending;
        private transient KeySet<K> keySetView;
        private transient Set<Map.Entry<K, V>> entrySetView;
        private transient Collection<V> valuesView;
        
        SubMap(final ConcurrentSkipListMap<K, V> m, final K lo, final boolean loInclusive, final K hi, final boolean hiInclusive, final boolean isDescending) {
            try {
                BytecodeManager.incBytecodes(2);
                final Comparator<? super K> comparator = m.comparator;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(2);
                if (lo != null) {
                    BytecodeManager.incBytecodes(2);
                    if (hi != null) {
                        final Comparator<? super K> comparator2 = comparator;
                        BytecodeManager.incBytecodes(3);
                        BytecodeManager.incBytecodes(1);
                        final int cpr = ConcurrentSkipListMap.cpr(comparator2, lo, hi);
                        BytecodeManager.incBytecodes(1);
                        if (cpr > 0) {
                            final String s = "inconsistent range";
                            BytecodeManager.incBytecodes(4);
                            final IllegalArgumentException ex = new IllegalArgumentException(s);
                            BytecodeManager.incBytecodes(1);
                            throw ex;
                        }
                    }
                }
                this.m = m;
                BytecodeManager.incBytecodes(3);
                this.lo = lo;
                BytecodeManager.incBytecodes(3);
                this.hi = hi;
                BytecodeManager.incBytecodes(3);
                this.loInclusive = loInclusive;
                BytecodeManager.incBytecodes(3);
                this.hiInclusive = hiInclusive;
                BytecodeManager.incBytecodes(3);
                this.isDescending = isDescending;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        boolean tooLow(final Object o, final Comparator<? super K> comparator) {
            try {
                final K lo = this.lo;
                BytecodeManager.incBytecodes(3);
                boolean b = false;
                Label_0072: {
                    Label_0066: {
                        if (lo != null) {
                            final K lo2 = this.lo;
                            BytecodeManager.incBytecodes(5);
                            final int cpr = ConcurrentSkipListMap.cpr(comparator, o, lo2);
                            BytecodeManager.incBytecodes(3);
                            if (cpr >= 0) {
                                final int n = cpr;
                                BytecodeManager.incBytecodes(2);
                                if (n != 0) {
                                    break Label_0066;
                                }
                                final boolean loInclusive = this.loInclusive;
                                BytecodeManager.incBytecodes(3);
                                if (loInclusive) {
                                    break Label_0066;
                                }
                            }
                            b = true;
                            BytecodeManager.incBytecodes(2);
                            break Label_0072;
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
        
        boolean tooHigh(final Object o, final Comparator<? super K> comparator) {
            try {
                final K hi = this.hi;
                BytecodeManager.incBytecodes(3);
                boolean b = false;
                Label_0072: {
                    Label_0066: {
                        if (hi != null) {
                            final K hi2 = this.hi;
                            BytecodeManager.incBytecodes(5);
                            final int cpr = ConcurrentSkipListMap.cpr(comparator, o, hi2);
                            BytecodeManager.incBytecodes(3);
                            if (cpr <= 0) {
                                final int n = cpr;
                                BytecodeManager.incBytecodes(2);
                                if (n != 0) {
                                    break Label_0066;
                                }
                                final boolean hiInclusive = this.hiInclusive;
                                BytecodeManager.incBytecodes(3);
                                if (hiInclusive) {
                                    break Label_0066;
                                }
                            }
                            b = true;
                            BytecodeManager.incBytecodes(2);
                            break Label_0072;
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
        
        boolean inBounds(final Object o, final Comparator<? super K> comparator) {
            try {
                BytecodeManager.incBytecodes(4);
                final boolean tooLow = this.tooLow(o, comparator);
                BytecodeManager.incBytecodes(1);
                boolean b = false;
                Label_0053: {
                    if (!tooLow) {
                        BytecodeManager.incBytecodes(4);
                        final boolean tooHigh = this.tooHigh(o, comparator);
                        BytecodeManager.incBytecodes(1);
                        if (!tooHigh) {
                            b = true;
                            BytecodeManager.incBytecodes(2);
                            break Label_0053;
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
        
        void checkKeyBounds(final K k, final Comparator<? super K> comparator) {
            try {
                BytecodeManager.incBytecodes(2);
                if (k == null) {
                    BytecodeManager.incBytecodes(3);
                    final NullPointerException ex = new NullPointerException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                BytecodeManager.incBytecodes(4);
                final boolean inBounds = this.inBounds(k, comparator);
                BytecodeManager.incBytecodes(1);
                if (!inBounds) {
                    final String s = "key out of range";
                    BytecodeManager.incBytecodes(4);
                    final IllegalArgumentException ex2 = new IllegalArgumentException(s);
                    BytecodeManager.incBytecodes(1);
                    throw ex2;
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        boolean isBeforeEnd(final Node<K, V> node, final Comparator<? super K> comparator) {
            try {
                BytecodeManager.incBytecodes(2);
                if (node == null) {
                    final boolean b = false;
                    BytecodeManager.incBytecodes(2);
                    return b;
                }
                final K hi = this.hi;
                BytecodeManager.incBytecodes(3);
                if (hi == null) {
                    final boolean b2 = true;
                    BytecodeManager.incBytecodes(2);
                    return b2;
                }
                final K key = node.key;
                BytecodeManager.incBytecodes(3);
                final K k = key;
                BytecodeManager.incBytecodes(2);
                if (k == null) {
                    final boolean b3 = true;
                    BytecodeManager.incBytecodes(2);
                    return b3;
                }
                final K i = key;
                final K hi2 = this.hi;
                BytecodeManager.incBytecodes(5);
                final int cpr = ConcurrentSkipListMap.cpr(comparator, i, hi2);
                BytecodeManager.incBytecodes(1);
                final int n = cpr;
                BytecodeManager.incBytecodes(2);
                Label_0114: {
                    if (n <= 0) {
                        final int n2 = cpr;
                        BytecodeManager.incBytecodes(2);
                        if (n2 == 0) {
                            final boolean hiInclusive = this.hiInclusive;
                            BytecodeManager.incBytecodes(3);
                            if (!hiInclusive) {
                                break Label_0114;
                            }
                        }
                        final boolean b4 = true;
                        BytecodeManager.incBytecodes(2);
                        return b4;
                    }
                }
                final boolean b5 = false;
                BytecodeManager.incBytecodes(2);
                return b5;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        Node<K, V> loNode(final Comparator<? super K> comparator) {
            try {
                final K lo = this.lo;
                BytecodeManager.incBytecodes(3);
                if (lo == null) {
                    final ConcurrentSkipListMap<K, V> m = this.m;
                    BytecodeManager.incBytecodes(3);
                    final Node<K, V> first = m.findFirst();
                    BytecodeManager.incBytecodes(1);
                    return first;
                }
                final boolean loInclusive = this.loInclusive;
                BytecodeManager.incBytecodes(3);
                if (loInclusive) {
                    final ConcurrentSkipListMap<K, V> i = this.m;
                    final K lo2 = this.lo;
                    final int n = 1;
                    BytecodeManager.incBytecodes(7);
                    final Node<K, V> near = i.findNear(lo2, n, comparator);
                    BytecodeManager.incBytecodes(1);
                    return near;
                }
                final ConcurrentSkipListMap<K, V> j = this.m;
                final K lo3 = this.lo;
                final int n2 = 0;
                BytecodeManager.incBytecodes(7);
                final Node<K, V> near2 = j.findNear(lo3, n2, comparator);
                BytecodeManager.incBytecodes(1);
                return near2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        Node<K, V> hiNode(final Comparator<? super K> comparator) {
            try {
                final K hi = this.hi;
                BytecodeManager.incBytecodes(3);
                if (hi == null) {
                    final ConcurrentSkipListMap<K, V> m = this.m;
                    BytecodeManager.incBytecodes(3);
                    final Node<K, V> last = m.findLast();
                    BytecodeManager.incBytecodes(1);
                    return last;
                }
                final boolean hiInclusive = this.hiInclusive;
                BytecodeManager.incBytecodes(3);
                if (hiInclusive) {
                    final ConcurrentSkipListMap<K, V> i = this.m;
                    final K hi2 = this.hi;
                    final int n = 3;
                    BytecodeManager.incBytecodes(7);
                    final Node<K, V> near = i.findNear(hi2, n, comparator);
                    BytecodeManager.incBytecodes(1);
                    return near;
                }
                final ConcurrentSkipListMap<K, V> j = this.m;
                final K hi3 = this.hi;
                final int n2 = 2;
                BytecodeManager.incBytecodes(7);
                final Node<K, V> near2 = j.findNear(hi3, n2, comparator);
                BytecodeManager.incBytecodes(1);
                return near2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        K lowestKey() {
            try {
                final Comparator<? super K> comparator = this.m.comparator;
                BytecodeManager.incBytecodes(4);
                final Comparator<? super K> comparator2 = comparator;
                BytecodeManager.incBytecodes(3);
                final Node<K, V> loNode = this.loNode(comparator2);
                BytecodeManager.incBytecodes(1);
                final Node<K, V> node = loNode;
                final Comparator<? super K> comparator3 = comparator;
                BytecodeManager.incBytecodes(4);
                final boolean beforeEnd = this.isBeforeEnd(node, comparator3);
                BytecodeManager.incBytecodes(1);
                if (beforeEnd) {
                    final K key = loNode.key;
                    BytecodeManager.incBytecodes(3);
                    return key;
                }
                BytecodeManager.incBytecodes(3);
                final NoSuchElementException ex = new NoSuchElementException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        K highestKey() {
            try {
                final Comparator<? super K> comparator = this.m.comparator;
                BytecodeManager.incBytecodes(4);
                final Comparator<? super K> comparator2 = comparator;
                BytecodeManager.incBytecodes(3);
                final Node<K, V> hiNode = this.hiNode(comparator2);
                BytecodeManager.incBytecodes(1);
                final Node<K, V> node = hiNode;
                BytecodeManager.incBytecodes(2);
                if (node != null) {
                    final K key = hiNode.key;
                    BytecodeManager.incBytecodes(3);
                    final K k = key;
                    final Comparator<? super K> comparator3 = comparator;
                    BytecodeManager.incBytecodes(4);
                    final boolean inBounds = this.inBounds(k, comparator3);
                    BytecodeManager.incBytecodes(1);
                    if (inBounds) {
                        final K i = key;
                        BytecodeManager.incBytecodes(2);
                        return i;
                    }
                }
                BytecodeManager.incBytecodes(3);
                final NoSuchElementException ex = new NoSuchElementException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        Map.Entry<K, V> lowestEntry() {
            try {
                final Comparator<? super K> comparator = this.m.comparator;
                BytecodeManager.incBytecodes(4);
                while (true) {
                    final Comparator<? super K> comparator2 = comparator;
                    BytecodeManager.incBytecodes(3);
                    final Node<K, V> loNode = this.loNode(comparator2);
                    BytecodeManager.incBytecodes(1);
                    final Node<K, V> node = loNode;
                    final Comparator<? super K> comparator3 = comparator;
                    BytecodeManager.incBytecodes(4);
                    final boolean beforeEnd = this.isBeforeEnd(node, comparator3);
                    BytecodeManager.incBytecodes(1);
                    if (!beforeEnd) {
                        final Map.Entry<K, V> entry = null;
                        BytecodeManager.incBytecodes(2);
                        return entry;
                    }
                    final Node<K, V> node2 = loNode;
                    BytecodeManager.incBytecodes(2);
                    final SimpleImmutableEntry<K, V> snapshot = node2.createSnapshot();
                    BytecodeManager.incBytecodes(1);
                    final SimpleImmutableEntry<K, V> simpleImmutableEntry = snapshot;
                    BytecodeManager.incBytecodes(2);
                    if (simpleImmutableEntry != null) {
                        final SimpleImmutableEntry<K, V> simpleImmutableEntry2 = snapshot;
                        BytecodeManager.incBytecodes(2);
                        return simpleImmutableEntry2;
                    }
                    BytecodeManager.incBytecodes(1);
                }
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        Map.Entry<K, V> highestEntry() {
            try {
                final Comparator<? super K> comparator = this.m.comparator;
                BytecodeManager.incBytecodes(4);
                SimpleImmutableEntry<K, V> snapshot = null;
                Block_3: {
                    while (true) {
                        final Comparator<? super K> comparator2 = comparator;
                        BytecodeManager.incBytecodes(3);
                        final Node<K, V> hiNode = this.hiNode(comparator2);
                        BytecodeManager.incBytecodes(1);
                        final Node<K, V> node = hiNode;
                        BytecodeManager.incBytecodes(2);
                        if (node == null) {
                            break;
                        }
                        final K key = hiNode.key;
                        final Comparator<? super K> comparator3 = comparator;
                        BytecodeManager.incBytecodes(5);
                        final boolean inBounds = this.inBounds(key, comparator3);
                        BytecodeManager.incBytecodes(1);
                        if (!inBounds) {
                            break;
                        }
                        final Node<K, V> node2 = hiNode;
                        BytecodeManager.incBytecodes(2);
                        snapshot = node2.createSnapshot();
                        BytecodeManager.incBytecodes(1);
                        final SimpleImmutableEntry<K, V> simpleImmutableEntry = snapshot;
                        BytecodeManager.incBytecodes(2);
                        if (simpleImmutableEntry != null) {
                            break Block_3;
                        }
                        BytecodeManager.incBytecodes(1);
                    }
                    final Map.Entry<K, V> entry = null;
                    BytecodeManager.incBytecodes(2);
                    return entry;
                }
                final SimpleImmutableEntry<K, V> simpleImmutableEntry2 = snapshot;
                BytecodeManager.incBytecodes(2);
                return simpleImmutableEntry2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        Map.Entry<K, V> removeLowest() {
            try {
                final Comparator<? super K> comparator = this.m.comparator;
                BytecodeManager.incBytecodes(4);
                while (true) {
                    final Comparator<? super K> comparator2 = comparator;
                    BytecodeManager.incBytecodes(3);
                    final Node<K, V> loNode = this.loNode(comparator2);
                    BytecodeManager.incBytecodes(1);
                    final Node<K, V> node = loNode;
                    BytecodeManager.incBytecodes(2);
                    if (node == null) {
                        final Map.Entry<K, V> entry = null;
                        BytecodeManager.incBytecodes(2);
                        return entry;
                    }
                    final K key = loNode.key;
                    BytecodeManager.incBytecodes(3);
                    final K k = key;
                    final Comparator<? super K> comparator3 = comparator;
                    BytecodeManager.incBytecodes(4);
                    final boolean inBounds = this.inBounds(k, comparator3);
                    BytecodeManager.incBytecodes(1);
                    if (!inBounds) {
                        final Map.Entry<K, V> entry2 = null;
                        BytecodeManager.incBytecodes(2);
                        return entry2;
                    }
                    final ConcurrentSkipListMap<K, V> m = this.m;
                    final K i = key;
                    final Object o = null;
                    BytecodeManager.incBytecodes(5);
                    final V doRemove = m.doRemove(i, o);
                    BytecodeManager.incBytecodes(1);
                    final V v = doRemove;
                    BytecodeManager.incBytecodes(2);
                    if (v != null) {
                        final K j = key;
                        final V v2 = doRemove;
                        BytecodeManager.incBytecodes(5);
                        final SimpleImmutableEntry simpleImmutableEntry = new SimpleImmutableEntry<K, V>(j, v2);
                        BytecodeManager.incBytecodes(1);
                        return (Map.Entry<K, V>)simpleImmutableEntry;
                    }
                    BytecodeManager.incBytecodes(1);
                }
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        Map.Entry<K, V> removeHighest() {
            try {
                final Comparator<? super K> comparator = this.m.comparator;
                BytecodeManager.incBytecodes(4);
                while (true) {
                    final Comparator<? super K> comparator2 = comparator;
                    BytecodeManager.incBytecodes(3);
                    final Node<K, V> hiNode = this.hiNode(comparator2);
                    BytecodeManager.incBytecodes(1);
                    final Node<K, V> node = hiNode;
                    BytecodeManager.incBytecodes(2);
                    if (node == null) {
                        final Map.Entry<K, V> entry = null;
                        BytecodeManager.incBytecodes(2);
                        return entry;
                    }
                    final K key = hiNode.key;
                    BytecodeManager.incBytecodes(3);
                    final K k = key;
                    final Comparator<? super K> comparator3 = comparator;
                    BytecodeManager.incBytecodes(4);
                    final boolean inBounds = this.inBounds(k, comparator3);
                    BytecodeManager.incBytecodes(1);
                    if (!inBounds) {
                        final Map.Entry<K, V> entry2 = null;
                        BytecodeManager.incBytecodes(2);
                        return entry2;
                    }
                    final ConcurrentSkipListMap<K, V> m = this.m;
                    final K i = key;
                    final Object o = null;
                    BytecodeManager.incBytecodes(5);
                    final V doRemove = m.doRemove(i, o);
                    BytecodeManager.incBytecodes(1);
                    final V v = doRemove;
                    BytecodeManager.incBytecodes(2);
                    if (v != null) {
                        final K j = key;
                        final V v2 = doRemove;
                        BytecodeManager.incBytecodes(5);
                        final SimpleImmutableEntry simpleImmutableEntry = new SimpleImmutableEntry<K, V>(j, v2);
                        BytecodeManager.incBytecodes(1);
                        return (Map.Entry<K, V>)simpleImmutableEntry;
                    }
                    BytecodeManager.incBytecodes(1);
                }
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        Map.Entry<K, V> getNearEntry(final K k, int n) {
            try {
                final Comparator<? super K> comparator = this.m.comparator;
                BytecodeManager.incBytecodes(4);
                final boolean isDescending = this.isDescending;
                BytecodeManager.incBytecodes(3);
                if (isDescending) {
                    final int n2 = n & 0x2;
                    BytecodeManager.incBytecodes(4);
                    if (n2 == 0) {
                        n |= 0x2;
                        BytecodeManager.incBytecodes(5);
                    }
                    else {
                        n &= 0xFFFFFFFD;
                        BytecodeManager.incBytecodes(4);
                    }
                }
                final Comparator<? super K> comparator2 = comparator;
                BytecodeManager.incBytecodes(4);
                final boolean tooLow = this.tooLow(k, comparator2);
                BytecodeManager.incBytecodes(1);
                if (tooLow) {
                    final int n3 = n & 0x2;
                    BytecodeManager.incBytecodes(4);
                    Map.Entry<K, V> lowestEntry;
                    if (n3 != 0) {
                        lowestEntry = null;
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        BytecodeManager.incBytecodes(2);
                        lowestEntry = this.lowestEntry();
                    }
                    BytecodeManager.incBytecodes(1);
                    return lowestEntry;
                }
                final Comparator<? super K> comparator3 = comparator;
                BytecodeManager.incBytecodes(4);
                final boolean tooHigh = this.tooHigh(k, comparator3);
                BytecodeManager.incBytecodes(1);
                if (tooHigh) {
                    final int n4 = n & 0x2;
                    BytecodeManager.incBytecodes(4);
                    Map.Entry<K, V> highestEntry;
                    if (n4 != 0) {
                        BytecodeManager.incBytecodes(2);
                        highestEntry = this.highestEntry();
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        highestEntry = null;
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(1);
                    return highestEntry;
                }
                K key2 = null;
                V validValue = null;
                Block_9: {
                    while (true) {
                        final ConcurrentSkipListMap<K, V> m = this.m;
                        final int n5 = n;
                        final Comparator<? super K> comparator4 = comparator;
                        BytecodeManager.incBytecodes(6);
                        final Node<K, V> near = m.findNear(k, n5, comparator4);
                        BytecodeManager.incBytecodes(1);
                        final Node<K, V> node = near;
                        BytecodeManager.incBytecodes(2);
                        if (node == null) {
                            break;
                        }
                        final K key = near.key;
                        final Comparator<? super K> comparator5 = comparator;
                        BytecodeManager.incBytecodes(5);
                        final boolean inBounds = this.inBounds(key, comparator5);
                        BytecodeManager.incBytecodes(1);
                        if (!inBounds) {
                            break;
                        }
                        key2 = near.key;
                        BytecodeManager.incBytecodes(3);
                        final Node<K, V> node2 = near;
                        BytecodeManager.incBytecodes(2);
                        validValue = node2.getValidValue();
                        BytecodeManager.incBytecodes(1);
                        final V v = validValue;
                        BytecodeManager.incBytecodes(2);
                        if (v != null) {
                            break Block_9;
                        }
                        BytecodeManager.incBytecodes(1);
                    }
                    final Map.Entry<K, V> entry = null;
                    BytecodeManager.incBytecodes(2);
                    return entry;
                }
                final K i = key2;
                final V v2 = validValue;
                BytecodeManager.incBytecodes(5);
                final SimpleImmutableEntry simpleImmutableEntry = new SimpleImmutableEntry<K, V>(i, v2);
                BytecodeManager.incBytecodes(1);
                return (Map.Entry<K, V>)simpleImmutableEntry;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        K getNearKey(final K k, int n) {
            try {
                final Comparator<? super K> comparator = this.m.comparator;
                BytecodeManager.incBytecodes(4);
                final boolean isDescending = this.isDescending;
                BytecodeManager.incBytecodes(3);
                if (isDescending) {
                    final int n2 = n & 0x2;
                    BytecodeManager.incBytecodes(4);
                    if (n2 == 0) {
                        n |= 0x2;
                        BytecodeManager.incBytecodes(5);
                    }
                    else {
                        n &= 0xFFFFFFFD;
                        BytecodeManager.incBytecodes(4);
                    }
                }
                final Comparator<? super K> comparator2 = comparator;
                BytecodeManager.incBytecodes(4);
                final boolean tooLow = this.tooLow(k, comparator2);
                BytecodeManager.incBytecodes(1);
                if (tooLow) {
                    final int n3 = n & 0x2;
                    BytecodeManager.incBytecodes(4);
                    if (n3 == 0) {
                        final Comparator<? super K> comparator3 = comparator;
                        BytecodeManager.incBytecodes(3);
                        final Node<K, V> loNode = this.loNode(comparator3);
                        BytecodeManager.incBytecodes(1);
                        final Node<K, V> node = loNode;
                        final Comparator<? super K> comparator4 = comparator;
                        BytecodeManager.incBytecodes(4);
                        final boolean beforeEnd = this.isBeforeEnd(node, comparator4);
                        BytecodeManager.incBytecodes(1);
                        if (beforeEnd) {
                            final K key = loNode.key;
                            BytecodeManager.incBytecodes(3);
                            return key;
                        }
                    }
                    final K i = null;
                    BytecodeManager.incBytecodes(2);
                    return i;
                }
                final Comparator<? super K> comparator5 = comparator;
                BytecodeManager.incBytecodes(4);
                final boolean tooHigh = this.tooHigh(k, comparator5);
                BytecodeManager.incBytecodes(1);
                if (tooHigh) {
                    final int n4 = n & 0x2;
                    BytecodeManager.incBytecodes(4);
                    if (n4 != 0) {
                        final Comparator<? super K> comparator6 = comparator;
                        BytecodeManager.incBytecodes(3);
                        final Node<K, V> hiNode = this.hiNode(comparator6);
                        BytecodeManager.incBytecodes(1);
                        final Node<K, V> node2 = hiNode;
                        BytecodeManager.incBytecodes(2);
                        if (node2 != null) {
                            final K key2 = hiNode.key;
                            BytecodeManager.incBytecodes(3);
                            final K j = key2;
                            final Comparator<? super K> comparator7 = comparator;
                            BytecodeManager.incBytecodes(4);
                            final boolean inBounds = this.inBounds(j, comparator7);
                            BytecodeManager.incBytecodes(1);
                            if (inBounds) {
                                final K l = key2;
                                BytecodeManager.incBytecodes(2);
                                return l;
                            }
                        }
                    }
                    final K m = null;
                    BytecodeManager.incBytecodes(2);
                    return m;
                }
                K key4 = null;
                Block_12: {
                    while (true) {
                        final ConcurrentSkipListMap<K, V> m2 = this.m;
                        final int n5 = n;
                        final Comparator<? super K> comparator8 = comparator;
                        BytecodeManager.incBytecodes(6);
                        final Node<K, V> near = m2.findNear(k, n5, comparator8);
                        BytecodeManager.incBytecodes(1);
                        final Node<K, V> node3 = near;
                        BytecodeManager.incBytecodes(2);
                        if (node3 == null) {
                            break;
                        }
                        final K key3 = near.key;
                        final Comparator<? super K> comparator9 = comparator;
                        BytecodeManager.incBytecodes(5);
                        final boolean inBounds2 = this.inBounds(key3, comparator9);
                        BytecodeManager.incBytecodes(1);
                        if (!inBounds2) {
                            break;
                        }
                        key4 = near.key;
                        BytecodeManager.incBytecodes(3);
                        final Node<K, V> node4 = near;
                        BytecodeManager.incBytecodes(2);
                        final V validValue = node4.getValidValue();
                        BytecodeManager.incBytecodes(1);
                        final V v = validValue;
                        BytecodeManager.incBytecodes(2);
                        if (v != null) {
                            break Block_12;
                        }
                        BytecodeManager.incBytecodes(1);
                    }
                    final K k2 = null;
                    BytecodeManager.incBytecodes(2);
                    return k2;
                }
                final K k3 = key4;
                BytecodeManager.incBytecodes(2);
                return k3;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean containsKey(final Object o) {
            try {
                BytecodeManager.incBytecodes(2);
                if (o == null) {
                    BytecodeManager.incBytecodes(3);
                    final NullPointerException ex = new NullPointerException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final Comparator<? super K> comparator = this.m.comparator;
                BytecodeManager.incBytecodes(6);
                final boolean inBounds = this.inBounds(o, comparator);
                BytecodeManager.incBytecodes(1);
                boolean b = false;
                Label_0088: {
                    if (inBounds) {
                        final ConcurrentSkipListMap<K, V> m = this.m;
                        BytecodeManager.incBytecodes(4);
                        final boolean containsKey = m.containsKey(o);
                        BytecodeManager.incBytecodes(1);
                        if (containsKey) {
                            b = true;
                            BytecodeManager.incBytecodes(2);
                            break Label_0088;
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
        
        @Override
        public V get(final Object o) {
            try {
                BytecodeManager.incBytecodes(2);
                if (o == null) {
                    BytecodeManager.incBytecodes(3);
                    final NullPointerException ex = new NullPointerException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final Comparator<? super K> comparator = this.m.comparator;
                BytecodeManager.incBytecodes(6);
                final boolean inBounds = this.inBounds(o, comparator);
                BytecodeManager.incBytecodes(1);
                V value;
                if (!inBounds) {
                    value = null;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final ConcurrentSkipListMap<K, V> m = this.m;
                    BytecodeManager.incBytecodes(4);
                    value = m.get(o);
                }
                BytecodeManager.incBytecodes(1);
                return value;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public V put(final K k, final V v) {
            try {
                final Comparator<? super K> comparator = this.m.comparator;
                BytecodeManager.incBytecodes(6);
                this.checkKeyBounds(k, comparator);
                final ConcurrentSkipListMap<K, V> m = this.m;
                BytecodeManager.incBytecodes(5);
                final V put = m.put(k, v);
                BytecodeManager.incBytecodes(1);
                return put;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public V remove(final Object o) {
            try {
                final Comparator<? super K> comparator = this.m.comparator;
                BytecodeManager.incBytecodes(6);
                final boolean inBounds = this.inBounds(o, comparator);
                BytecodeManager.incBytecodes(1);
                V remove;
                if (!inBounds) {
                    remove = null;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final ConcurrentSkipListMap<K, V> m = this.m;
                    BytecodeManager.incBytecodes(4);
                    remove = m.remove(o);
                }
                BytecodeManager.incBytecodes(1);
                return remove;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int size() {
            try {
                final Comparator<? super K> comparator = this.m.comparator;
                BytecodeManager.incBytecodes(4);
                long n = 0L;
                BytecodeManager.incBytecodes(2);
                final Comparator<? super K> comparator2 = comparator;
                BytecodeManager.incBytecodes(3);
                Node<K, V> node = this.loNode(comparator2);
                BytecodeManager.incBytecodes(1);
                while (true) {
                    final Node<K, V> node2 = node;
                    final Comparator<? super K> comparator3 = comparator;
                    BytecodeManager.incBytecodes(4);
                    final boolean beforeEnd = this.isBeforeEnd(node2, comparator3);
                    BytecodeManager.incBytecodes(1);
                    if (!beforeEnd) {
                        break;
                    }
                    final Node<K, V> node3 = node;
                    BytecodeManager.incBytecodes(2);
                    final V validValue = node3.getValidValue();
                    BytecodeManager.incBytecodes(1);
                    if (validValue != null) {
                        ++n;
                        BytecodeManager.incBytecodes(4);
                    }
                    node = node.next;
                    BytecodeManager.incBytecodes(4);
                }
                final long n2 = lcmp(n, 2147483647L);
                BytecodeManager.incBytecodes(4);
                int n3;
                if (n2 >= 0) {
                    n3 = Integer.MAX_VALUE;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    n3 = (int)n;
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(1);
                return n3;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean isEmpty() {
            try {
                final Comparator<? super K> comparator = this.m.comparator;
                BytecodeManager.incBytecodes(4);
                final Comparator<? super K> comparator2 = comparator;
                BytecodeManager.incBytecodes(4);
                final Node<K, V> loNode = this.loNode(comparator2);
                final Comparator<? super K> comparator3 = comparator;
                BytecodeManager.incBytecodes(2);
                final boolean beforeEnd = this.isBeforeEnd(loNode, comparator3);
                BytecodeManager.incBytecodes(1);
                boolean b;
                if (!beforeEnd) {
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
        public boolean containsValue(final Object o) {
            try {
                BytecodeManager.incBytecodes(2);
                if (o == null) {
                    BytecodeManager.incBytecodes(3);
                    final NullPointerException ex = new NullPointerException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final Comparator<? super K> comparator = this.m.comparator;
                BytecodeManager.incBytecodes(4);
                final Comparator<? super K> comparator2 = comparator;
                BytecodeManager.incBytecodes(3);
                Node<K, V> node = this.loNode(comparator2);
                BytecodeManager.incBytecodes(1);
                while (true) {
                    final Node<K, V> node2 = node;
                    final Comparator<? super K> comparator3 = comparator;
                    BytecodeManager.incBytecodes(4);
                    final boolean beforeEnd = this.isBeforeEnd(node2, comparator3);
                    BytecodeManager.incBytecodes(1);
                    if (!beforeEnd) {
                        final boolean b = false;
                        BytecodeManager.incBytecodes(2);
                        return b;
                    }
                    final Node<K, V> node3 = node;
                    BytecodeManager.incBytecodes(2);
                    final V validValue = node3.getValidValue();
                    BytecodeManager.incBytecodes(1);
                    final V v = validValue;
                    BytecodeManager.incBytecodes(2);
                    if (v != null) {
                        final V obj = validValue;
                        BytecodeManager.incBytecodes(3);
                        final boolean equals = o.equals(obj);
                        BytecodeManager.incBytecodes(1);
                        if (equals) {
                            final boolean b2 = true;
                            BytecodeManager.incBytecodes(2);
                            return b2;
                        }
                    }
                    node = node.next;
                    BytecodeManager.incBytecodes(4);
                }
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void clear() {
            try {
                final Comparator<? super K> comparator = this.m.comparator;
                BytecodeManager.incBytecodes(4);
                final Comparator<? super K> comparator2 = comparator;
                BytecodeManager.incBytecodes(3);
                Node<K, V> node = this.loNode(comparator2);
                BytecodeManager.incBytecodes(1);
                while (true) {
                    final Node<K, V> node2 = node;
                    final Comparator<? super K> comparator3 = comparator;
                    BytecodeManager.incBytecodes(4);
                    final boolean beforeEnd = this.isBeforeEnd(node2, comparator3);
                    BytecodeManager.incBytecodes(1);
                    if (!beforeEnd) {
                        break;
                    }
                    final Node<K, V> node3 = node;
                    BytecodeManager.incBytecodes(2);
                    final V validValue = node3.getValidValue();
                    BytecodeManager.incBytecodes(1);
                    if (validValue != null) {
                        final ConcurrentSkipListMap<K, V> m = this.m;
                        final K key = node.key;
                        BytecodeManager.incBytecodes(5);
                        m.remove(key);
                        BytecodeManager.incBytecodes(1);
                    }
                    node = node.next;
                    BytecodeManager.incBytecodes(4);
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public V putIfAbsent(final K k, final V v) {
            try {
                final Comparator<? super K> comparator = this.m.comparator;
                BytecodeManager.incBytecodes(6);
                this.checkKeyBounds(k, comparator);
                final ConcurrentSkipListMap<K, V> m = this.m;
                BytecodeManager.incBytecodes(5);
                final V putIfAbsent = m.putIfAbsent(k, v);
                BytecodeManager.incBytecodes(1);
                return putIfAbsent;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean remove(final Object o, final Object o2) {
            try {
                final Comparator<? super K> comparator = this.m.comparator;
                BytecodeManager.incBytecodes(6);
                final boolean inBounds = this.inBounds(o, comparator);
                BytecodeManager.incBytecodes(1);
                boolean b = false;
                Label_0062: {
                    if (inBounds) {
                        final ConcurrentSkipListMap<K, V> m = this.m;
                        BytecodeManager.incBytecodes(5);
                        final boolean remove = m.remove(o, o2);
                        BytecodeManager.incBytecodes(1);
                        if (remove) {
                            b = true;
                            BytecodeManager.incBytecodes(2);
                            break Label_0062;
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
        
        @Override
        public boolean replace(final K k, final V v, final V v2) {
            try {
                final Comparator<? super K> comparator = this.m.comparator;
                BytecodeManager.incBytecodes(6);
                this.checkKeyBounds(k, comparator);
                final ConcurrentSkipListMap<K, V> m = this.m;
                BytecodeManager.incBytecodes(6);
                final boolean replace = m.replace(k, v, v2);
                BytecodeManager.incBytecodes(1);
                return replace;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public V replace(final K k, final V v) {
            try {
                final Comparator<? super K> comparator = this.m.comparator;
                BytecodeManager.incBytecodes(6);
                this.checkKeyBounds(k, comparator);
                final ConcurrentSkipListMap<K, V> m = this.m;
                BytecodeManager.incBytecodes(5);
                final V replace = m.replace(k, v);
                BytecodeManager.incBytecodes(1);
                return replace;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Comparator<? super K> comparator() {
            try {
                final ConcurrentSkipListMap<K, V> m = this.m;
                BytecodeManager.incBytecodes(3);
                final Comparator<? super K> comparator = m.comparator();
                BytecodeManager.incBytecodes(1);
                final boolean isDescending = this.isDescending;
                BytecodeManager.incBytecodes(3);
                if (isDescending) {
                    final Comparator<? super K> comparator2 = comparator;
                    BytecodeManager.incBytecodes(2);
                    final Comparator<Object> reverseOrder = Collections.reverseOrder(comparator2);
                    BytecodeManager.incBytecodes(1);
                    return reverseOrder;
                }
                final Comparator<? super K> comparator3 = comparator;
                BytecodeManager.incBytecodes(2);
                return comparator3;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        SubMap<K, V> newSubMap(K lo, boolean loInclusive, K hi, boolean hiInclusive) {
            try {
                final Comparator<? super K> comparator = this.m.comparator;
                BytecodeManager.incBytecodes(4);
                final boolean isDescending = this.isDescending;
                BytecodeManager.incBytecodes(3);
                if (isDescending) {
                    final K k = lo;
                    BytecodeManager.incBytecodes(2);
                    lo = hi;
                    BytecodeManager.incBytecodes(2);
                    hi = k;
                    BytecodeManager.incBytecodes(2);
                    final boolean b = loInclusive;
                    BytecodeManager.incBytecodes(2);
                    loInclusive = hiInclusive;
                    BytecodeManager.incBytecodes(2);
                    hiInclusive = b;
                    BytecodeManager.incBytecodes(2);
                }
                final K lo2 = this.lo;
                BytecodeManager.incBytecodes(3);
                Label_0201: {
                    if (lo2 != null) {
                        final K i = lo;
                        BytecodeManager.incBytecodes(2);
                        if (i != null) {
                            final Comparator<? super K> comparator2 = comparator;
                            final K j = lo;
                            final K lo3 = this.lo;
                            BytecodeManager.incBytecodes(5);
                            final int cpr = ConcurrentSkipListMap.cpr(comparator2, j, lo3);
                            BytecodeManager.incBytecodes(1);
                            final int n = cpr;
                            BytecodeManager.incBytecodes(2);
                            if (n >= 0) {
                                final int n2 = cpr;
                                BytecodeManager.incBytecodes(2);
                                if (n2 != 0) {
                                    break Label_0201;
                                }
                                final boolean loInclusive2 = this.loInclusive;
                                BytecodeManager.incBytecodes(3);
                                if (loInclusive2) {
                                    break Label_0201;
                                }
                                final boolean b2 = loInclusive;
                                BytecodeManager.incBytecodes(2);
                                if (!b2) {
                                    break Label_0201;
                                }
                            }
                            final String s = "key out of range";
                            BytecodeManager.incBytecodes(4);
                            final IllegalArgumentException ex = new IllegalArgumentException(s);
                            BytecodeManager.incBytecodes(1);
                            throw ex;
                        }
                        lo = this.lo;
                        BytecodeManager.incBytecodes(3);
                        loInclusive = this.loInclusive;
                        BytecodeManager.incBytecodes(4);
                    }
                }
                final K hi2 = this.hi;
                BytecodeManager.incBytecodes(3);
                Label_0330: {
                    if (hi2 != null) {
                        final K l = hi;
                        BytecodeManager.incBytecodes(2);
                        if (l != null) {
                            final Comparator<? super K> comparator3 = comparator;
                            final K m = hi;
                            final K hi3 = this.hi;
                            BytecodeManager.incBytecodes(5);
                            final int cpr2 = ConcurrentSkipListMap.cpr(comparator3, m, hi3);
                            BytecodeManager.incBytecodes(1);
                            final int n3 = cpr2;
                            BytecodeManager.incBytecodes(2);
                            if (n3 <= 0) {
                                final int n4 = cpr2;
                                BytecodeManager.incBytecodes(2);
                                if (n4 != 0) {
                                    break Label_0330;
                                }
                                final boolean hiInclusive2 = this.hiInclusive;
                                BytecodeManager.incBytecodes(3);
                                if (hiInclusive2) {
                                    break Label_0330;
                                }
                                final boolean b3 = hiInclusive;
                                BytecodeManager.incBytecodes(2);
                                if (!b3) {
                                    break Label_0330;
                                }
                            }
                            final String s2 = "key out of range";
                            BytecodeManager.incBytecodes(4);
                            final IllegalArgumentException ex2 = new IllegalArgumentException(s2);
                            BytecodeManager.incBytecodes(1);
                            throw ex2;
                        }
                        hi = this.hi;
                        BytecodeManager.incBytecodes(3);
                        hiInclusive = this.hiInclusive;
                        BytecodeManager.incBytecodes(4);
                    }
                }
                final ConcurrentSkipListMap<K, V> m2 = this.m;
                final K k2 = lo;
                final boolean b4 = loInclusive;
                final K k3 = hi;
                final boolean b5 = hiInclusive;
                final boolean isDescending2 = this.isDescending;
                BytecodeManager.incBytecodes(11);
                final SubMap subMap = new SubMap<K, V>((ConcurrentSkipListMap<Object, Object>)m2, k2, b4, k3, b5, isDescending2);
                BytecodeManager.incBytecodes(1);
                return subMap;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public SubMap<K, V> subMap(final K k, final boolean b, final K i, final boolean b2) {
            try {
                BytecodeManager.incBytecodes(2);
                if (k != null) {
                    BytecodeManager.incBytecodes(2);
                    if (i != null) {
                        BytecodeManager.incBytecodes(6);
                        final SubMap<K, V> subMap = this.newSubMap(k, b, i, b2);
                        BytecodeManager.incBytecodes(1);
                        return subMap;
                    }
                }
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public SubMap<K, V> headMap(final K k, final boolean b) {
            try {
                BytecodeManager.incBytecodes(2);
                if (k == null) {
                    BytecodeManager.incBytecodes(3);
                    final NullPointerException ex = new NullPointerException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final K i = null;
                final boolean b2 = false;
                BytecodeManager.incBytecodes(6);
                final SubMap<K, V> subMap = this.newSubMap(i, b2, k, b);
                BytecodeManager.incBytecodes(1);
                return subMap;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public SubMap<K, V> tailMap(final K k, final boolean b) {
            try {
                BytecodeManager.incBytecodes(2);
                if (k == null) {
                    BytecodeManager.incBytecodes(3);
                    final NullPointerException ex = new NullPointerException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final K i = null;
                final boolean b2 = false;
                BytecodeManager.incBytecodes(6);
                final SubMap<K, V> subMap = this.newSubMap(k, b, i, b2);
                BytecodeManager.incBytecodes(1);
                return subMap;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public SubMap<K, V> subMap(final K k, final K i) {
            try {
                final boolean b = true;
                final boolean b2 = false;
                BytecodeManager.incBytecodes(6);
                final SubMap<K, V> subMap = this.subMap(k, b, i, b2);
                BytecodeManager.incBytecodes(1);
                return subMap;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public SubMap<K, V> headMap(final K k) {
            try {
                final boolean b = false;
                BytecodeManager.incBytecodes(4);
                final SubMap<K, V> headMap = this.headMap(k, b);
                BytecodeManager.incBytecodes(1);
                return headMap;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public SubMap<K, V> tailMap(final K k) {
            try {
                final boolean b = true;
                BytecodeManager.incBytecodes(4);
                final SubMap<K, V> tailMap = this.tailMap(k, b);
                BytecodeManager.incBytecodes(1);
                return tailMap;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public SubMap<K, V> descendingMap() {
            try {
                final ConcurrentSkipListMap<K, V> m = this.m;
                final K lo = this.lo;
                final boolean loInclusive = this.loInclusive;
                final K hi = this.hi;
                final boolean hiInclusive = this.hiInclusive;
                final boolean isDescending = this.isDescending;
                BytecodeManager.incBytecodes(15);
                boolean b;
                if (!isDescending) {
                    b = true;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    b = false;
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
                final SubMap subMap = new SubMap<K, V>((ConcurrentSkipListMap<Object, Object>)m, lo, loInclusive, hi, hiInclusive, b);
                BytecodeManager.incBytecodes(1);
                return subMap;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Map.Entry<K, V> ceilingEntry(final K k) {
            try {
                final int n = 1;
                BytecodeManager.incBytecodes(4);
                final Map.Entry<K, V> nearEntry = this.getNearEntry(k, n);
                BytecodeManager.incBytecodes(1);
                return nearEntry;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public K ceilingKey(final K k) {
            try {
                final int n = 1;
                BytecodeManager.incBytecodes(4);
                final Object nearKey = this.getNearKey(k, n);
                BytecodeManager.incBytecodes(1);
                return (K)nearKey;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Map.Entry<K, V> lowerEntry(final K k) {
            try {
                final int n = 2;
                BytecodeManager.incBytecodes(4);
                final Map.Entry<K, V> nearEntry = this.getNearEntry(k, n);
                BytecodeManager.incBytecodes(1);
                return nearEntry;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public K lowerKey(final K k) {
            try {
                final int n = 2;
                BytecodeManager.incBytecodes(4);
                final Object nearKey = this.getNearKey(k, n);
                BytecodeManager.incBytecodes(1);
                return (K)nearKey;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Map.Entry<K, V> floorEntry(final K k) {
            try {
                final int n = 3;
                BytecodeManager.incBytecodes(4);
                final Map.Entry<K, V> nearEntry = this.getNearEntry(k, n);
                BytecodeManager.incBytecodes(1);
                return nearEntry;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public K floorKey(final K k) {
            try {
                final int n = 3;
                BytecodeManager.incBytecodes(4);
                final Object nearKey = this.getNearKey(k, n);
                BytecodeManager.incBytecodes(1);
                return (K)nearKey;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Map.Entry<K, V> higherEntry(final K k) {
            try {
                final int n = 0;
                BytecodeManager.incBytecodes(4);
                final Map.Entry<K, V> nearEntry = this.getNearEntry(k, n);
                BytecodeManager.incBytecodes(1);
                return nearEntry;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public K higherKey(final K k) {
            try {
                final int n = 0;
                BytecodeManager.incBytecodes(4);
                final Object nearKey = this.getNearKey(k, n);
                BytecodeManager.incBytecodes(1);
                return (K)nearKey;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public K firstKey() {
            try {
                final boolean isDescending = this.isDescending;
                BytecodeManager.incBytecodes(3);
                K k;
                if (isDescending) {
                    BytecodeManager.incBytecodes(2);
                    k = this.highestKey();
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    BytecodeManager.incBytecodes(2);
                    k = this.lowestKey();
                }
                BytecodeManager.incBytecodes(1);
                return k;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public K lastKey() {
            try {
                final boolean isDescending = this.isDescending;
                BytecodeManager.incBytecodes(3);
                K k;
                if (isDescending) {
                    BytecodeManager.incBytecodes(2);
                    k = this.lowestKey();
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    BytecodeManager.incBytecodes(2);
                    k = this.highestKey();
                }
                BytecodeManager.incBytecodes(1);
                return k;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Map.Entry<K, V> firstEntry() {
            try {
                final boolean isDescending = this.isDescending;
                BytecodeManager.incBytecodes(3);
                Map.Entry<K, V> entry;
                if (isDescending) {
                    BytecodeManager.incBytecodes(2);
                    entry = this.highestEntry();
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    BytecodeManager.incBytecodes(2);
                    entry = this.lowestEntry();
                }
                BytecodeManager.incBytecodes(1);
                return entry;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Map.Entry<K, V> lastEntry() {
            try {
                final boolean isDescending = this.isDescending;
                BytecodeManager.incBytecodes(3);
                Map.Entry<K, V> entry;
                if (isDescending) {
                    BytecodeManager.incBytecodes(2);
                    entry = this.lowestEntry();
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    BytecodeManager.incBytecodes(2);
                    entry = this.highestEntry();
                }
                BytecodeManager.incBytecodes(1);
                return entry;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Map.Entry<K, V> pollFirstEntry() {
            try {
                final boolean isDescending = this.isDescending;
                BytecodeManager.incBytecodes(3);
                Map.Entry<K, V> entry;
                if (isDescending) {
                    BytecodeManager.incBytecodes(2);
                    entry = this.removeHighest();
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    BytecodeManager.incBytecodes(2);
                    entry = this.removeLowest();
                }
                BytecodeManager.incBytecodes(1);
                return entry;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Map.Entry<K, V> pollLastEntry() {
            try {
                final boolean isDescending = this.isDescending;
                BytecodeManager.incBytecodes(3);
                Map.Entry<K, V> entry;
                if (isDescending) {
                    BytecodeManager.incBytecodes(2);
                    entry = this.removeLowest();
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    BytecodeManager.incBytecodes(2);
                    entry = this.removeHighest();
                }
                BytecodeManager.incBytecodes(1);
                return entry;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public NavigableSet<K> keySet() {
            try {
                final KeySet<K> keySetView = this.keySetView;
                BytecodeManager.incBytecodes(3);
                final KeySet<K> set = keySetView;
                BytecodeManager.incBytecodes(2);
                KeySet<K> set2;
                if (set != null) {
                    set2 = keySetView;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final KeySet<K> keySetView2 = set2 = new KeySet<K>(this);
                    BytecodeManager.incBytecodes(5);
                    this.keySetView = keySetView2;
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(1);
                return set2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public NavigableSet<K> navigableKeySet() {
            try {
                final KeySet<K> keySetView = this.keySetView;
                BytecodeManager.incBytecodes(3);
                final KeySet<K> set = keySetView;
                BytecodeManager.incBytecodes(2);
                KeySet<K> set2;
                if (set != null) {
                    set2 = keySetView;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final KeySet<K> keySetView2 = set2 = new KeySet<K>(this);
                    BytecodeManager.incBytecodes(5);
                    this.keySetView = keySetView2;
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(1);
                return set2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Collection<V> values() {
            try {
                final Collection<V> valuesView = this.valuesView;
                BytecodeManager.incBytecodes(3);
                final Collection<V> collection = valuesView;
                BytecodeManager.incBytecodes(2);
                Collection<V> collection2;
                if (collection != null) {
                    collection2 = valuesView;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final Values<V> valuesView2 = (Values<V>)(collection2 = new Values<V>(this));
                    BytecodeManager.incBytecodes(5);
                    this.valuesView = valuesView2;
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(1);
                return collection2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Set<Map.Entry<K, V>> entrySet() {
            try {
                final Set<Map.Entry<K, V>> entrySetView = this.entrySetView;
                BytecodeManager.incBytecodes(3);
                final Set<Map.Entry<K, V>> set = entrySetView;
                BytecodeManager.incBytecodes(2);
                Set<Map.Entry<K, V>> set2;
                if (set != null) {
                    set2 = entrySetView;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final EntrySet entrySetView2 = (EntrySet)(set2 = (Set<Map.Entry<K, V>>)new EntrySet((ConcurrentNavigableMap<Object, Object>)this));
                    BytecodeManager.incBytecodes(5);
                    this.entrySetView = (Set<Map.Entry<K, V>>)entrySetView2;
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(1);
                return set2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public NavigableSet<K> descendingKeySet() {
            try {
                BytecodeManager.incBytecodes(2);
                final SubMap<K, V> descendingMap = this.descendingMap();
                BytecodeManager.incBytecodes(1);
                final NavigableSet navigableKeySet = descendingMap.navigableKeySet();
                BytecodeManager.incBytecodes(1);
                return (NavigableSet<K>)navigableKeySet;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        Iterator<K> keyIterator() {
            try {
                BytecodeManager.incBytecodes(4);
                final SubMapKeyIterator subMapKeyIterator = new SubMapKeyIterator();
                BytecodeManager.incBytecodes(1);
                return subMapKeyIterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        Iterator<V> valueIterator() {
            try {
                BytecodeManager.incBytecodes(4);
                final SubMapValueIterator subMapValueIterator = new SubMapValueIterator();
                BytecodeManager.incBytecodes(1);
                return subMapValueIterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        Iterator<Map.Entry<K, V>> entryIterator() {
            try {
                BytecodeManager.incBytecodes(4);
                final SubMapEntryIterator subMapEntryIterator = new SubMapEntryIterator();
                BytecodeManager.incBytecodes(1);
                return subMapEntryIterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static /* synthetic */ ConcurrentSkipListMap access$100(final SubMap subMap) {
            try {
                final ConcurrentSkipListMap<K, V> m = subMap.m;
                BytecodeManager.incBytecodes(3);
                return m;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static /* synthetic */ boolean access$200(final SubMap subMap) {
            try {
                final boolean isDescending = subMap.isDescending;
                BytecodeManager.incBytecodes(3);
                return isDescending;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        abstract class SubMapIter<T> implements Iterator<T>, Spliterator<T>
        {
            Node<K, V> lastReturned;
            Node<K, V> next;
            V nextValue;
            
            SubMapIter() {
                try {
                    BytecodeManager.incBytecodes(5);
                    BytecodeManager.incBytecodes(2);
                    final Comparator<? super K> comparator = SubMap.access$100(SubMap.this).comparator;
                    BytecodeManager.incBytecodes(2);
                    while (true) {
                        BytecodeManager.incBytecodes(3);
                        final boolean access$200 = SubMap.access$200(SubMap.this);
                        BytecodeManager.incBytecodes(1);
                        Node<K, V> next;
                        if (access$200) {
                            final Comparator<? super K> comparator2 = (Comparator<? super K>)comparator;
                            BytecodeManager.incBytecodes(3);
                            next = SubMap.this.hiNode(comparator2);
                            BytecodeManager.incBytecodes(1);
                        }
                        else {
                            final Comparator<? super K> comparator3 = (Comparator<? super K>)comparator;
                            BytecodeManager.incBytecodes(3);
                            next = SubMap.this.loNode(comparator3);
                        }
                        this.next = next;
                        BytecodeManager.incBytecodes(1);
                        final Node<K, V> next2 = this.next;
                        BytecodeManager.incBytecodes(3);
                        if (next2 == null) {
                            BytecodeManager.incBytecodes(1);
                            break;
                        }
                        final Object value = this.next.value;
                        BytecodeManager.incBytecodes(4);
                        final Object o = value;
                        BytecodeManager.incBytecodes(2);
                        if (o != null) {
                            final Object o2 = value;
                            final Node<K, V> next3 = this.next;
                            BytecodeManager.incBytecodes(4);
                            if (o2 != next3) {
                                final K key = this.next.key;
                                final Comparator<? super K> comparator4 = (Comparator<? super K>)comparator;
                                BytecodeManager.incBytecodes(6);
                                final boolean inBounds = SubMap.this.inBounds(key, comparator4);
                                BytecodeManager.incBytecodes(1);
                                if (!inBounds) {
                                    this.next = null;
                                    BytecodeManager.incBytecodes(4);
                                    break;
                                }
                                final Node<K, V> nextValue = (Node<K, V>)value;
                                BytecodeManager.incBytecodes(2);
                                this.nextValue = (V)nextValue;
                                BytecodeManager.incBytecodes(3);
                                BytecodeManager.incBytecodes(1);
                                break;
                            }
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
            public final boolean hasNext() {
                try {
                    final Node<K, V> next = this.next;
                    BytecodeManager.incBytecodes(3);
                    boolean b;
                    if (next != null) {
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
            
            final void advance() {
                try {
                    final Node<K, V> next = this.next;
                    BytecodeManager.incBytecodes(3);
                    if (next == null) {
                        BytecodeManager.incBytecodes(3);
                        final NoSuchElementException ex = new NoSuchElementException();
                        BytecodeManager.incBytecodes(1);
                        throw ex;
                    }
                    this.lastReturned = this.next;
                    BytecodeManager.incBytecodes(4);
                    final SubMap this$0 = SubMap.this;
                    BytecodeManager.incBytecodes(3);
                    final boolean access$200 = SubMap.access$200(this$0);
                    BytecodeManager.incBytecodes(1);
                    if (access$200) {
                        BytecodeManager.incBytecodes(2);
                        this.descend();
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        BytecodeManager.incBytecodes(2);
                        this.ascend();
                    }
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            private void ascend() {
                try {
                    final SubMap this$0 = SubMap.this;
                    BytecodeManager.incBytecodes(3);
                    final Comparator<? super K> comparator = SubMap.access$100(this$0).comparator;
                    BytecodeManager.incBytecodes(2);
                    while (true) {
                        this.next = this.next.next;
                        BytecodeManager.incBytecodes(5);
                        final Node<K, V> next = this.next;
                        BytecodeManager.incBytecodes(3);
                        if (next == null) {
                            BytecodeManager.incBytecodes(1);
                            break;
                        }
                        final Object value = this.next.value;
                        BytecodeManager.incBytecodes(4);
                        final Object o = value;
                        BytecodeManager.incBytecodes(2);
                        if (o != null) {
                            final Object o2 = value;
                            final Node<K, V> next2 = this.next;
                            BytecodeManager.incBytecodes(4);
                            if (o2 != next2) {
                                final SubMap this$2 = SubMap.this;
                                final K key = this.next.key;
                                final Comparator<? super K> comparator2 = (Comparator<? super K>)comparator;
                                BytecodeManager.incBytecodes(7);
                                final boolean tooHigh = this$2.tooHigh(key, comparator2);
                                BytecodeManager.incBytecodes(1);
                                if (tooHigh) {
                                    this.next = null;
                                    BytecodeManager.incBytecodes(4);
                                    break;
                                }
                                final Node<K, V> nextValue = (Node<K, V>)value;
                                BytecodeManager.incBytecodes(2);
                                this.nextValue = (V)nextValue;
                                BytecodeManager.incBytecodes(3);
                                BytecodeManager.incBytecodes(1);
                                break;
                            }
                        }
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            private void descend() {
                try {
                    final SubMap this$0 = SubMap.this;
                    BytecodeManager.incBytecodes(3);
                    final Comparator<? super K> comparator = SubMap.access$100(this$0).comparator;
                    BytecodeManager.incBytecodes(2);
                    while (true) {
                        final SubMap this$2 = SubMap.this;
                        BytecodeManager.incBytecodes(4);
                        final ConcurrentSkipListMap access$100 = SubMap.access$100(this$2);
                        final K key = this.lastReturned.key;
                        final int n = 2;
                        final Comparator<? super K> comparator2 = (Comparator<? super K>)comparator;
                        BytecodeManager.incBytecodes(6);
                        this.next = access$100.findNear(key, n, comparator2);
                        BytecodeManager.incBytecodes(1);
                        final Node<K, V> next = this.next;
                        BytecodeManager.incBytecodes(3);
                        if (next == null) {
                            BytecodeManager.incBytecodes(1);
                            break;
                        }
                        final Object value = this.next.value;
                        BytecodeManager.incBytecodes(4);
                        final Object o = value;
                        BytecodeManager.incBytecodes(2);
                        if (o != null) {
                            final Object o2 = value;
                            final Node<K, V> next2 = this.next;
                            BytecodeManager.incBytecodes(4);
                            if (o2 != next2) {
                                final SubMap this$3 = SubMap.this;
                                final K key2 = this.next.key;
                                final Comparator<? super K> comparator3 = (Comparator<? super K>)comparator;
                                BytecodeManager.incBytecodes(7);
                                final boolean tooLow = this$3.tooLow(key2, comparator3);
                                BytecodeManager.incBytecodes(1);
                                if (tooLow) {
                                    this.next = null;
                                    BytecodeManager.incBytecodes(4);
                                    break;
                                }
                                final Node<K, V> nextValue = (Node<K, V>)value;
                                BytecodeManager.incBytecodes(2);
                                this.nextValue = (V)nextValue;
                                BytecodeManager.incBytecodes(3);
                                BytecodeManager.incBytecodes(1);
                                break;
                            }
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
            public void remove() {
                try {
                    final Node<K, V> lastReturned = this.lastReturned;
                    BytecodeManager.incBytecodes(3);
                    final Node<K, V> node = lastReturned;
                    BytecodeManager.incBytecodes(2);
                    if (node == null) {
                        BytecodeManager.incBytecodes(3);
                        final IllegalStateException ex = new IllegalStateException();
                        BytecodeManager.incBytecodes(1);
                        throw ex;
                    }
                    final SubMap this$0 = SubMap.this;
                    BytecodeManager.incBytecodes(3);
                    final ConcurrentSkipListMap access$100 = SubMap.access$100(this$0);
                    final K key = lastReturned.key;
                    BytecodeManager.incBytecodes(3);
                    access$100.remove(key);
                    BytecodeManager.incBytecodes(1);
                    this.lastReturned = null;
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public Spliterator<T> trySplit() {
                try {
                    final Spliterator<T> spliterator = null;
                    BytecodeManager.incBytecodes(2);
                    return spliterator;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public boolean tryAdvance(final Consumer<? super T> consumer) {
                try {
                    BytecodeManager.incBytecodes(2);
                    final boolean hasNext = this.hasNext();
                    BytecodeManager.incBytecodes(1);
                    if (hasNext) {
                        BytecodeManager.incBytecodes(3);
                        final Object next = this.next();
                        BytecodeManager.incBytecodes(1);
                        consumer.accept((Object)next);
                        final boolean b = true;
                        BytecodeManager.incBytecodes(2);
                        return b;
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
            public void forEachRemaining(final Consumer<? super T> consumer) {
                try {
                    while (true) {
                        BytecodeManager.incBytecodes(2);
                        final boolean hasNext = this.hasNext();
                        BytecodeManager.incBytecodes(1);
                        if (!hasNext) {
                            break;
                        }
                        BytecodeManager.incBytecodes(3);
                        final Object next = this.next();
                        BytecodeManager.incBytecodes(1);
                        consumer.accept((Object)next);
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(1);
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
        }
        
        final class SubMapValueIterator extends SubMapIter<V>
        {
            SubMapValueIterator() {
                try {
                    BytecodeManager.incBytecodes(6);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public V next() {
                try {
                    final V nextValue = this.nextValue;
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(2);
                    this.advance();
                    final V v = nextValue;
                    BytecodeManager.incBytecodes(2);
                    return v;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public int characteristics() {
                try {
                    final int n = 0;
                    BytecodeManager.incBytecodes(2);
                    return n;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
        
        final class SubMapKeyIterator extends SubMapIter<K>
        {
            SubMapKeyIterator() {
                try {
                    BytecodeManager.incBytecodes(6);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public K next() {
                try {
                    final Node<K, V> next = this.next;
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(2);
                    this.advance();
                    final K key = next.key;
                    BytecodeManager.incBytecodes(3);
                    return key;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public int characteristics() {
                try {
                    final int n = 21;
                    BytecodeManager.incBytecodes(2);
                    return n;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public final Comparator<? super K> getComparator() {
                try {
                    final SubMap this$0 = SubMap.this;
                    BytecodeManager.incBytecodes(3);
                    final Comparator<? super K> comparator = this$0.comparator();
                    BytecodeManager.incBytecodes(1);
                    return comparator;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
        
        final class SubMapEntryIterator extends SubMapIter<Map.Entry<K, V>>
        {
            SubMapEntryIterator() {
                try {
                    BytecodeManager.incBytecodes(6);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public Map.Entry<K, V> next() {
                try {
                    final Node<K, V> next = this.next;
                    BytecodeManager.incBytecodes(3);
                    final V nextValue = this.nextValue;
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(2);
                    this.advance();
                    final K key = next.key;
                    final V v = nextValue;
                    BytecodeManager.incBytecodes(6);
                    final SimpleImmutableEntry simpleImmutableEntry = new SimpleImmutableEntry<K, V>(key, v);
                    BytecodeManager.incBytecodes(1);
                    return (Map.Entry<K, V>)simpleImmutableEntry;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public int characteristics() {
                try {
                    final int n = 1;
                    BytecodeManager.incBytecodes(2);
                    return n;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
    }
    
    abstract static class CSLMSpliterator<K, V>
    {
        final Comparator<? super K> comparator;
        final K fence;
        Index<K, V> row;
        Node<K, V> current;
        int est;
        
        CSLMSpliterator(final Comparator<? super K> comparator, final Index<K, V> row, final Node<K, V> current, final K fence, final int est) {
            try {
                BytecodeManager.incBytecodes(2);
                this.comparator = comparator;
                this.row = row;
                BytecodeManager.incBytecodes(6);
                this.current = current;
                this.fence = fence;
                this.est = est;
                BytecodeManager.incBytecodes(9);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public final long estimateSize() {
            try {
                final long n = this.est;
                BytecodeManager.incBytecodes(4);
                return n;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class KeySpliterator<K, V> extends CSLMSpliterator<K, V> implements Spliterator<K>
    {
        KeySpliterator(final Comparator<? super K> comparator, final Index<K, V> index, final Node<K, V> node, final K k, final int n) {
            try {
                BytecodeManager.incBytecodes(7);
                super(comparator, index, node, k, n);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Spliterator<K> trySplit() {
            try {
                final Comparator<? super K> comparator = this.comparator;
                BytecodeManager.incBytecodes(3);
                final K fence = this.fence;
                BytecodeManager.incBytecodes(3);
                final Node<K, V> current;
                final Node<K, V> node = current = this.current;
                BytecodeManager.incBytecodes(5);
                Label_0341: {
                    if (node != null) {
                        final K key = current.key;
                        BytecodeManager.incBytecodes(5);
                        if (key != null) {
                            Index<K, V> row = this.row;
                            BytecodeManager.incBytecodes(3);
                            Index<K, V> right;
                            Node<K, V> next;
                            K key2;
                            while (true) {
                                final Index<K, V> index = row;
                                BytecodeManager.incBytecodes(2);
                                if (index == null) {
                                    break Label_0341;
                                }
                                final Index<K, V> index2 = right = row.right;
                                BytecodeManager.incBytecodes(5);
                                if (index2 != null) {
                                    final Node<K, V> node2 = right.node;
                                    BytecodeManager.incBytecodes(5);
                                    if (node2 != null) {
                                        final Node<K, V> node3 = next = node2.next;
                                        BytecodeManager.incBytecodes(5);
                                        if (node3 != null) {
                                            final Object value = next.value;
                                            BytecodeManager.incBytecodes(3);
                                            if (value != null) {
                                                final K k = key2 = next.key;
                                                BytecodeManager.incBytecodes(5);
                                                if (k != null) {
                                                    final Comparator<? super K> comparator2 = comparator;
                                                    final K i = key2;
                                                    final K j = key;
                                                    BytecodeManager.incBytecodes(3);
                                                    BytecodeManager.incBytecodes(1);
                                                    final int cpr = ConcurrentSkipListMap.cpr(comparator2, i, j);
                                                    BytecodeManager.incBytecodes(1);
                                                    if (cpr > 0) {
                                                        final K l = fence;
                                                        BytecodeManager.incBytecodes(2);
                                                        if (l == null) {
                                                            break;
                                                        }
                                                        final Comparator<? super K> comparator3 = comparator;
                                                        final K m = key2;
                                                        final K k2 = fence;
                                                        BytecodeManager.incBytecodes(3);
                                                        BytecodeManager.incBytecodes(1);
                                                        final int cpr2 = ConcurrentSkipListMap.cpr(comparator3, m, k2);
                                                        BytecodeManager.incBytecodes(1);
                                                        if (cpr2 < 0) {
                                                            break;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                final Index<K, V> down = row.down;
                                this.row = down;
                                row = down;
                                BytecodeManager.incBytecodes(7);
                            }
                            this.current = next;
                            BytecodeManager.incBytecodes(3);
                            final Index<K, V> down2 = row.down;
                            BytecodeManager.incBytecodes(3);
                            final Index<K, V> right2 = right.right;
                            BytecodeManager.incBytecodes(4);
                            Index<K, V> down3;
                            if (right2 != null) {
                                down3 = right;
                                BytecodeManager.incBytecodes(2);
                            }
                            else {
                                down3 = right.down;
                                BytecodeManager.incBytecodes(2);
                            }
                            this.row = down3;
                            BytecodeManager.incBytecodes(1);
                            this.est -= this.est >>> 2;
                            BytecodeManager.incBytecodes(9);
                            final Comparator<? super K> comparator4 = comparator;
                            final Index<K, V> index3 = down2;
                            final Node<K, V> node4 = current;
                            final K k3 = key2;
                            final int est = this.est;
                            BytecodeManager.incBytecodes(9);
                            final KeySpliterator keySpliterator = new KeySpliterator<K, Object>((Comparator<? super Object>)comparator4, (Index<Object, Object>)index3, (Node<Object, Object>)node4, k3, est);
                            BytecodeManager.incBytecodes(1);
                            return keySpliterator;
                        }
                    }
                }
                final Spliterator<K> spliterator = null;
                BytecodeManager.incBytecodes(2);
                return spliterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void forEachRemaining(final Consumer<? super K> consumer) {
            try {
                BytecodeManager.incBytecodes(2);
                if (consumer == null) {
                    BytecodeManager.incBytecodes(3);
                    final NullPointerException ex = new NullPointerException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final Comparator<? super K> comparator = this.comparator;
                BytecodeManager.incBytecodes(3);
                final K fence = this.fence;
                BytecodeManager.incBytecodes(3);
                Node<K, V> node = this.current;
                BytecodeManager.incBytecodes(3);
                this.current = null;
                BytecodeManager.incBytecodes(3);
                while (true) {
                    final Node<K, V> node2 = node;
                    BytecodeManager.incBytecodes(2);
                    if (node2 == null) {
                        break;
                    }
                    final K key;
                    final K k = key = node.key;
                    BytecodeManager.incBytecodes(5);
                    if (k != null) {
                        final K i = fence;
                        BytecodeManager.incBytecodes(2);
                        if (i != null) {
                            final Comparator<? super K> comparator2 = comparator;
                            final K j = fence;
                            final K l = key;
                            BytecodeManager.incBytecodes(4);
                            final int cpr = ConcurrentSkipListMap.cpr(comparator2, j, l);
                            BytecodeManager.incBytecodes(1);
                            if (cpr <= 0) {
                                BytecodeManager.incBytecodes(1);
                                break;
                            }
                        }
                    }
                    final Object value = node.value;
                    BytecodeManager.incBytecodes(5);
                    if (value != null) {
                        final Object o = value;
                        final Node<K, V> node3 = node;
                        BytecodeManager.incBytecodes(3);
                        if (o != node3) {
                            final K m = key;
                            BytecodeManager.incBytecodes(3);
                            consumer.accept(m);
                        }
                    }
                    node = node.next;
                    BytecodeManager.incBytecodes(4);
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean tryAdvance(final Consumer<? super K> consumer) {
            try {
                BytecodeManager.incBytecodes(2);
                if (consumer == null) {
                    BytecodeManager.incBytecodes(3);
                    final NullPointerException ex = new NullPointerException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final Comparator<? super K> comparator = this.comparator;
                BytecodeManager.incBytecodes(3);
                final K fence = this.fence;
                BytecodeManager.incBytecodes(3);
                Node<K, V> current = this.current;
                BytecodeManager.incBytecodes(3);
                while (true) {
                    final Node<K, V> node = current;
                    BytecodeManager.incBytecodes(2);
                    if (node == null) {
                        break;
                    }
                    final K key;
                    final K k = key = current.key;
                    BytecodeManager.incBytecodes(5);
                    if (k != null) {
                        final K i = fence;
                        BytecodeManager.incBytecodes(2);
                        if (i != null) {
                            final Comparator<? super K> comparator2 = comparator;
                            final K j = fence;
                            final K l = key;
                            BytecodeManager.incBytecodes(4);
                            final int cpr = ConcurrentSkipListMap.cpr(comparator2, j, l);
                            BytecodeManager.incBytecodes(1);
                            if (cpr <= 0) {
                                current = null;
                                BytecodeManager.incBytecodes(2);
                                BytecodeManager.incBytecodes(1);
                                break;
                            }
                        }
                    }
                    final Object value = current.value;
                    BytecodeManager.incBytecodes(5);
                    if (value != null) {
                        final Object o = value;
                        final Node<K, V> node2 = current;
                        BytecodeManager.incBytecodes(3);
                        if (o != node2) {
                            this.current = current.next;
                            BytecodeManager.incBytecodes(4);
                            final K m = key;
                            BytecodeManager.incBytecodes(3);
                            consumer.accept(m);
                            final boolean b = true;
                            BytecodeManager.incBytecodes(2);
                            return b;
                        }
                    }
                    current = current.next;
                    BytecodeManager.incBytecodes(4);
                }
                this.current = current;
                BytecodeManager.incBytecodes(3);
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
                final int n = 4373;
                BytecodeManager.incBytecodes(2);
                return n;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final Comparator<? super K> getComparator() {
            try {
                final Comparator<? super K> comparator = this.comparator;
                BytecodeManager.incBytecodes(3);
                return comparator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class ValueSpliterator<K, V> extends CSLMSpliterator<K, V> implements Spliterator<V>
    {
        ValueSpliterator(final Comparator<? super K> comparator, final Index<K, V> index, final Node<K, V> node, final K k, final int n) {
            try {
                BytecodeManager.incBytecodes(7);
                super(comparator, index, node, k, n);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Spliterator<V> trySplit() {
            try {
                final Comparator<? super K> comparator = this.comparator;
                BytecodeManager.incBytecodes(3);
                final K fence = this.fence;
                BytecodeManager.incBytecodes(3);
                final Node<K, V> current;
                final Node<K, V> node = current = this.current;
                BytecodeManager.incBytecodes(5);
                Label_0341: {
                    if (node != null) {
                        final K key = current.key;
                        BytecodeManager.incBytecodes(5);
                        if (key != null) {
                            Index<K, V> row = this.row;
                            BytecodeManager.incBytecodes(3);
                            Index<K, V> right;
                            Node<K, V> next;
                            K key2;
                            while (true) {
                                final Index<K, V> index = row;
                                BytecodeManager.incBytecodes(2);
                                if (index == null) {
                                    break Label_0341;
                                }
                                final Index<K, V> index2 = right = row.right;
                                BytecodeManager.incBytecodes(5);
                                if (index2 != null) {
                                    final Node<K, V> node2 = right.node;
                                    BytecodeManager.incBytecodes(5);
                                    if (node2 != null) {
                                        final Node<K, V> node3 = next = node2.next;
                                        BytecodeManager.incBytecodes(5);
                                        if (node3 != null) {
                                            final Object value = next.value;
                                            BytecodeManager.incBytecodes(3);
                                            if (value != null) {
                                                final K k = key2 = next.key;
                                                BytecodeManager.incBytecodes(5);
                                                if (k != null) {
                                                    final Comparator<? super K> comparator2 = comparator;
                                                    final K i = key2;
                                                    final K j = key;
                                                    BytecodeManager.incBytecodes(3);
                                                    BytecodeManager.incBytecodes(1);
                                                    final int cpr = ConcurrentSkipListMap.cpr(comparator2, i, j);
                                                    BytecodeManager.incBytecodes(1);
                                                    if (cpr > 0) {
                                                        final K l = fence;
                                                        BytecodeManager.incBytecodes(2);
                                                        if (l == null) {
                                                            break;
                                                        }
                                                        final Comparator<? super K> comparator3 = comparator;
                                                        final K m = key2;
                                                        final K k2 = fence;
                                                        BytecodeManager.incBytecodes(3);
                                                        BytecodeManager.incBytecodes(1);
                                                        final int cpr2 = ConcurrentSkipListMap.cpr(comparator3, m, k2);
                                                        BytecodeManager.incBytecodes(1);
                                                        if (cpr2 < 0) {
                                                            break;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                final Index<K, V> down = row.down;
                                this.row = down;
                                row = down;
                                BytecodeManager.incBytecodes(7);
                            }
                            this.current = next;
                            BytecodeManager.incBytecodes(3);
                            final Index<K, V> down2 = row.down;
                            BytecodeManager.incBytecodes(3);
                            final Index<K, V> right2 = right.right;
                            BytecodeManager.incBytecodes(4);
                            Index<K, V> down3;
                            if (right2 != null) {
                                down3 = right;
                                BytecodeManager.incBytecodes(2);
                            }
                            else {
                                down3 = right.down;
                                BytecodeManager.incBytecodes(2);
                            }
                            this.row = down3;
                            BytecodeManager.incBytecodes(1);
                            this.est -= this.est >>> 2;
                            BytecodeManager.incBytecodes(9);
                            final Comparator<? super K> comparator4 = comparator;
                            final Index<K, V> index3 = down2;
                            final Node<K, V> node4 = current;
                            final K k3 = key2;
                            final int est = this.est;
                            BytecodeManager.incBytecodes(9);
                            final ValueSpliterator valueSpliterator = new ValueSpliterator<Object, V>((Comparator<? super Object>)comparator4, (Index<Object, Object>)index3, (Node<Object, Object>)node4, k3, est);
                            BytecodeManager.incBytecodes(1);
                            return valueSpliterator;
                        }
                    }
                }
                final Spliterator<V> spliterator = null;
                BytecodeManager.incBytecodes(2);
                return spliterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void forEachRemaining(final Consumer<? super V> consumer) {
            try {
                BytecodeManager.incBytecodes(2);
                if (consumer == null) {
                    BytecodeManager.incBytecodes(3);
                    final NullPointerException ex = new NullPointerException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final Comparator<? super K> comparator = this.comparator;
                BytecodeManager.incBytecodes(3);
                final K fence = this.fence;
                BytecodeManager.incBytecodes(3);
                Node<K, V> node = this.current;
                BytecodeManager.incBytecodes(3);
                this.current = null;
                BytecodeManager.incBytecodes(3);
                while (true) {
                    final Node<K, V> node2 = node;
                    BytecodeManager.incBytecodes(2);
                    if (node2 == null) {
                        break;
                    }
                    final K key = node.key;
                    BytecodeManager.incBytecodes(5);
                    if (key != null) {
                        final K k = fence;
                        BytecodeManager.incBytecodes(2);
                        if (k != null) {
                            final Comparator<? super K> comparator2 = comparator;
                            final K i = fence;
                            final K j = key;
                            BytecodeManager.incBytecodes(4);
                            final int cpr = ConcurrentSkipListMap.cpr(comparator2, i, j);
                            BytecodeManager.incBytecodes(1);
                            if (cpr <= 0) {
                                BytecodeManager.incBytecodes(1);
                                break;
                            }
                        }
                    }
                    final Object value;
                    final Object o = value = node.value;
                    BytecodeManager.incBytecodes(5);
                    if (o != null) {
                        final Object o2 = value;
                        final Node<K, V> node3 = node;
                        BytecodeManager.incBytecodes(3);
                        if (o2 != node3) {
                            final Node<K, V> node4 = (Node<K, V>)value;
                            BytecodeManager.incBytecodes(2);
                            final Node<K, V> node5 = node4;
                            BytecodeManager.incBytecodes(3);
                            consumer.accept((Object)node5);
                        }
                    }
                    node = node.next;
                    BytecodeManager.incBytecodes(4);
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean tryAdvance(final Consumer<? super V> consumer) {
            try {
                BytecodeManager.incBytecodes(2);
                if (consumer == null) {
                    BytecodeManager.incBytecodes(3);
                    final NullPointerException ex = new NullPointerException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final Comparator<? super K> comparator = this.comparator;
                BytecodeManager.incBytecodes(3);
                final K fence = this.fence;
                BytecodeManager.incBytecodes(3);
                Node<K, V> current = this.current;
                BytecodeManager.incBytecodes(3);
                while (true) {
                    final Node<K, V> node = current;
                    BytecodeManager.incBytecodes(2);
                    if (node == null) {
                        break;
                    }
                    final K key = current.key;
                    BytecodeManager.incBytecodes(5);
                    if (key != null) {
                        final K k = fence;
                        BytecodeManager.incBytecodes(2);
                        if (k != null) {
                            final Comparator<? super K> comparator2 = comparator;
                            final K i = fence;
                            final K j = key;
                            BytecodeManager.incBytecodes(4);
                            final int cpr = ConcurrentSkipListMap.cpr(comparator2, i, j);
                            BytecodeManager.incBytecodes(1);
                            if (cpr <= 0) {
                                current = null;
                                BytecodeManager.incBytecodes(2);
                                BytecodeManager.incBytecodes(1);
                                break;
                            }
                        }
                    }
                    final Object value;
                    final Object o = value = current.value;
                    BytecodeManager.incBytecodes(5);
                    if (o != null) {
                        final Object o2 = value;
                        final Node<K, V> node2 = current;
                        BytecodeManager.incBytecodes(3);
                        if (o2 != node2) {
                            this.current = current.next;
                            BytecodeManager.incBytecodes(4);
                            final Node<K, V> node3 = (Node<K, V>)value;
                            BytecodeManager.incBytecodes(2);
                            final Node<K, V> node4 = node3;
                            BytecodeManager.incBytecodes(3);
                            consumer.accept((Object)node4);
                            final boolean b = true;
                            BytecodeManager.incBytecodes(2);
                            return b;
                        }
                    }
                    current = current.next;
                    BytecodeManager.incBytecodes(4);
                }
                this.current = current;
                BytecodeManager.incBytecodes(3);
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
                final int n = 4368;
                BytecodeManager.incBytecodes(2);
                return n;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class EntrySpliterator<K, V> extends CSLMSpliterator<K, V> implements Spliterator<Map.Entry<K, V>>
    {
        EntrySpliterator(final Comparator<? super K> comparator, final Index<K, V> index, final Node<K, V> node, final K k, final int n) {
            try {
                BytecodeManager.incBytecodes(7);
                super(comparator, index, node, k, n);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Spliterator<Map.Entry<K, V>> trySplit() {
            try {
                final Comparator<? super K> comparator = this.comparator;
                BytecodeManager.incBytecodes(3);
                final K fence = this.fence;
                BytecodeManager.incBytecodes(3);
                final Node<K, V> current;
                final Node<K, V> node = current = this.current;
                BytecodeManager.incBytecodes(5);
                Label_0341: {
                    if (node != null) {
                        final K key = current.key;
                        BytecodeManager.incBytecodes(5);
                        if (key != null) {
                            Index<K, V> row = this.row;
                            BytecodeManager.incBytecodes(3);
                            Index<K, V> right;
                            Node<K, V> next;
                            K key2;
                            while (true) {
                                final Index<K, V> index = row;
                                BytecodeManager.incBytecodes(2);
                                if (index == null) {
                                    break Label_0341;
                                }
                                final Index<K, V> index2 = right = row.right;
                                BytecodeManager.incBytecodes(5);
                                if (index2 != null) {
                                    final Node<K, V> node2 = right.node;
                                    BytecodeManager.incBytecodes(5);
                                    if (node2 != null) {
                                        final Node<K, V> node3 = next = node2.next;
                                        BytecodeManager.incBytecodes(5);
                                        if (node3 != null) {
                                            final Object value = next.value;
                                            BytecodeManager.incBytecodes(3);
                                            if (value != null) {
                                                final K k = key2 = next.key;
                                                BytecodeManager.incBytecodes(5);
                                                if (k != null) {
                                                    final Comparator<? super K> comparator2 = comparator;
                                                    final K i = key2;
                                                    final K j = key;
                                                    BytecodeManager.incBytecodes(3);
                                                    BytecodeManager.incBytecodes(1);
                                                    final int cpr = ConcurrentSkipListMap.cpr(comparator2, i, j);
                                                    BytecodeManager.incBytecodes(1);
                                                    if (cpr > 0) {
                                                        final K l = fence;
                                                        BytecodeManager.incBytecodes(2);
                                                        if (l == null) {
                                                            break;
                                                        }
                                                        final Comparator<? super K> comparator3 = comparator;
                                                        final K m = key2;
                                                        final K k2 = fence;
                                                        BytecodeManager.incBytecodes(3);
                                                        BytecodeManager.incBytecodes(1);
                                                        final int cpr2 = ConcurrentSkipListMap.cpr(comparator3, m, k2);
                                                        BytecodeManager.incBytecodes(1);
                                                        if (cpr2 < 0) {
                                                            break;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                final Index<K, V> down = row.down;
                                this.row = down;
                                row = down;
                                BytecodeManager.incBytecodes(7);
                            }
                            this.current = next;
                            BytecodeManager.incBytecodes(3);
                            final Index<K, V> down2 = row.down;
                            BytecodeManager.incBytecodes(3);
                            final Index<K, V> right2 = right.right;
                            BytecodeManager.incBytecodes(4);
                            Index<K, V> down3;
                            if (right2 != null) {
                                down3 = right;
                                BytecodeManager.incBytecodes(2);
                            }
                            else {
                                down3 = right.down;
                                BytecodeManager.incBytecodes(2);
                            }
                            this.row = down3;
                            BytecodeManager.incBytecodes(1);
                            this.est -= this.est >>> 2;
                            BytecodeManager.incBytecodes(9);
                            final Comparator<? super K> comparator4 = comparator;
                            final Index<K, V> index3 = down2;
                            final Node<K, V> node4 = current;
                            final K k3 = key2;
                            final int est = this.est;
                            BytecodeManager.incBytecodes(9);
                            final EntrySpliterator entrySpliterator = new EntrySpliterator<Object, Object>((Comparator<? super Object>)comparator4, (Index<Object, Object>)index3, (Node<Object, Object>)node4, k3, est);
                            BytecodeManager.incBytecodes(1);
                            return entrySpliterator;
                        }
                    }
                }
                final Spliterator<Map.Entry<K, V>> spliterator = null;
                BytecodeManager.incBytecodes(2);
                return spliterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void forEachRemaining(final Consumer<? super Map.Entry<K, V>> consumer) {
            try {
                BytecodeManager.incBytecodes(2);
                if (consumer == null) {
                    BytecodeManager.incBytecodes(3);
                    final NullPointerException ex = new NullPointerException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final Comparator<? super K> comparator = this.comparator;
                BytecodeManager.incBytecodes(3);
                final K fence = this.fence;
                BytecodeManager.incBytecodes(3);
                Node<K, V> node = this.current;
                BytecodeManager.incBytecodes(3);
                this.current = null;
                BytecodeManager.incBytecodes(3);
                while (true) {
                    final Node<K, V> node2 = node;
                    BytecodeManager.incBytecodes(2);
                    if (node2 == null) {
                        break;
                    }
                    final K key;
                    final K k = key = node.key;
                    BytecodeManager.incBytecodes(5);
                    if (k != null) {
                        final K i = fence;
                        BytecodeManager.incBytecodes(2);
                        if (i != null) {
                            final Comparator<? super K> comparator2 = comparator;
                            final K j = fence;
                            final K l = key;
                            BytecodeManager.incBytecodes(4);
                            final int cpr = ConcurrentSkipListMap.cpr(comparator2, j, l);
                            BytecodeManager.incBytecodes(1);
                            if (cpr <= 0) {
                                BytecodeManager.incBytecodes(1);
                                break;
                            }
                        }
                    }
                    final Object value;
                    final Object o = value = node.value;
                    BytecodeManager.incBytecodes(5);
                    if (o != null) {
                        final Object o2 = value;
                        final Node<K, V> node3 = node;
                        BytecodeManager.incBytecodes(3);
                        if (o2 != node3) {
                            final Node<K, V> node4 = (Node<K, V>)value;
                            BytecodeManager.incBytecodes(2);
                            final K m = key;
                            final Node<K, V> node5 = node4;
                            BytecodeManager.incBytecodes(6);
                            final SimpleImmutableEntry simpleImmutableEntry = new SimpleImmutableEntry(m, node5);
                            BytecodeManager.incBytecodes(1);
                            consumer.accept((Object)simpleImmutableEntry);
                        }
                    }
                    node = node.next;
                    BytecodeManager.incBytecodes(4);
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean tryAdvance(final Consumer<? super Map.Entry<K, V>> consumer) {
            try {
                BytecodeManager.incBytecodes(2);
                if (consumer == null) {
                    BytecodeManager.incBytecodes(3);
                    final NullPointerException ex = new NullPointerException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final Comparator<? super K> comparator = this.comparator;
                BytecodeManager.incBytecodes(3);
                final K fence = this.fence;
                BytecodeManager.incBytecodes(3);
                Node<K, V> current = this.current;
                BytecodeManager.incBytecodes(3);
                while (true) {
                    final Node<K, V> node = current;
                    BytecodeManager.incBytecodes(2);
                    if (node == null) {
                        break;
                    }
                    final K key;
                    final K k = key = current.key;
                    BytecodeManager.incBytecodes(5);
                    if (k != null) {
                        final K i = fence;
                        BytecodeManager.incBytecodes(2);
                        if (i != null) {
                            final Comparator<? super K> comparator2 = comparator;
                            final K j = fence;
                            final K l = key;
                            BytecodeManager.incBytecodes(4);
                            final int cpr = ConcurrentSkipListMap.cpr(comparator2, j, l);
                            BytecodeManager.incBytecodes(1);
                            if (cpr <= 0) {
                                current = null;
                                BytecodeManager.incBytecodes(2);
                                BytecodeManager.incBytecodes(1);
                                break;
                            }
                        }
                    }
                    final Object value;
                    final Object o = value = current.value;
                    BytecodeManager.incBytecodes(5);
                    if (o != null) {
                        final Object o2 = value;
                        final Node<K, V> node2 = current;
                        BytecodeManager.incBytecodes(3);
                        if (o2 != node2) {
                            this.current = current.next;
                            BytecodeManager.incBytecodes(4);
                            final Node<K, V> node3 = (Node<K, V>)value;
                            BytecodeManager.incBytecodes(2);
                            final K m = key;
                            final Node<K, V> node4 = node3;
                            BytecodeManager.incBytecodes(6);
                            final SimpleImmutableEntry simpleImmutableEntry = new SimpleImmutableEntry(m, node4);
                            BytecodeManager.incBytecodes(1);
                            consumer.accept((Object)simpleImmutableEntry);
                            final boolean b = true;
                            BytecodeManager.incBytecodes(2);
                            return b;
                        }
                    }
                    current = current.next;
                    BytecodeManager.incBytecodes(4);
                }
                this.current = current;
                BytecodeManager.incBytecodes(3);
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
                final int n = 4373;
                BytecodeManager.incBytecodes(2);
                return n;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final Comparator<Map.Entry<K, V>> getComparator() {
            try {
                final Comparator<? super K> comparator = this.comparator;
                BytecodeManager.incBytecodes(3);
                if (comparator != null) {
                    final Comparator<? super K> comparator2 = this.comparator;
                    BytecodeManager.incBytecodes(3);
                    final Comparator<Map.Entry<Object, Object>> comparingByKey = Map.Entry.comparingByKey((Comparator<? super Object>)comparator2);
                    BytecodeManager.incBytecodes(1);
                    return (Comparator<Map.Entry<K, V>>)comparingByKey;
                }
                Comparable<Object> comparable;
                final Comparable<Object> comparable2;
                final Object o;
                final int n;
                final Comparator comparator3 = (entry, entry2) -> {
                    try {
                        BytecodeManager.incBytecodes(2);
                        comparable = entry.getKey();
                        BytecodeManager.incBytecodes(2);
                        BytecodeManager.incBytecodes(3);
                        entry2.getKey();
                        BytecodeManager.incBytecodes(1);
                        comparable2.compareTo(o);
                        BytecodeManager.incBytecodes(1);
                        return n;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                };
                BytecodeManager.incBytecodes(3);
                return (Comparator<Map.Entry<K, V>>)comparator3;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
}
