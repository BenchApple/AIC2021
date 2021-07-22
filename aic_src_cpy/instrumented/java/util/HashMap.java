// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import instrumented.java.util.function.Consumer;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import instrumented.java.util.function.BiConsumer;
import instrumented.java.util.function.BiFunction;
import instrumented.java.util.function.Function;
import java.util.Iterator;
import java.lang.reflect.Type;
import java.lang.reflect.ParameterizedType;
import aic2021.engine.BytecodeManager;
import java.io.Serializable;

public class HashMap<K, V> extends AbstractMap<K, V> implements Map<K, V>, Cloneable, Serializable
{
    private static final long serialVersionUID = 362498820763181265L;
    static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final int MAXIMUM_CAPACITY = 1073741824;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    static final int TREEIFY_THRESHOLD = 8;
    static final int UNTREEIFY_THRESHOLD = 6;
    static final int MIN_TREEIFY_CAPACITY = 64;
    transient Node<K, V>[] table;
    transient Set<Entry<K, V>> entrySet;
    transient int size;
    transient int modCount;
    int threshold;
    final float loadFactor;
    
    static final int hash(final Object o) {
        try {
            BytecodeManager.incBytecodes(2);
            int n;
            if (o == null) {
                n = 0;
                BytecodeManager.incBytecodes(2);
            }
            else {
                BytecodeManager.incBytecodes(2);
                final int hashCode = o.hashCode();
                n = (hashCode ^ hashCode >>> 16);
                BytecodeManager.incBytecodes(6);
            }
            BytecodeManager.incBytecodes(1);
            return n;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static Class<?> comparableClassFor(final Object o) {
        try {
            final boolean b = o instanceof Comparable;
            BytecodeManager.incBytecodes(3);
            if (b) {
                BytecodeManager.incBytecodes(2);
                final Class<?> class1;
                final Class<?> clazz = class1 = o.getClass();
                final Class<String> clazz2 = String.class;
                BytecodeManager.incBytecodes(4);
                if (clazz == clazz2) {
                    final Class<?> clazz3 = class1;
                    BytecodeManager.incBytecodes(2);
                    return clazz3;
                }
                final Class<?> clazz4 = class1;
                BytecodeManager.incBytecodes(2);
                final Type[] genericInterfaces;
                final Type[] array = genericInterfaces = clazz4.getGenericInterfaces();
                BytecodeManager.incBytecodes(3);
                if (array != null) {
                    int n = 0;
                    BytecodeManager.incBytecodes(2);
                    while (true) {
                        final int n2 = n;
                        final int length = genericInterfaces.length;
                        BytecodeManager.incBytecodes(4);
                        if (n2 >= length) {
                            break;
                        }
                        final Type type;
                        final boolean b2 = (type = genericInterfaces[n]) instanceof ParameterizedType;
                        BytecodeManager.incBytecodes(7);
                        if (b2) {
                            final ParameterizedType parameterizedType = (ParameterizedType)type;
                            BytecodeManager.incBytecodes(4);
                            BytecodeManager.incBytecodes(1);
                            final Type rawType = parameterizedType.getRawType();
                            final Class<Comparable> clazz5 = Comparable.class;
                            BytecodeManager.incBytecodes(2);
                            if (rawType == clazz5) {
                                final ParameterizedType parameterizedType2 = parameterizedType;
                                BytecodeManager.incBytecodes(1);
                                BytecodeManager.incBytecodes(1);
                                final Type[] actualTypeArguments;
                                final Type[] array2 = actualTypeArguments = parameterizedType2.getActualTypeArguments();
                                BytecodeManager.incBytecodes(3);
                                if (array2 != null) {
                                    final int length2 = actualTypeArguments.length;
                                    final int n3 = 1;
                                    BytecodeManager.incBytecodes(4);
                                    if (length2 == n3) {
                                        final Type type2 = actualTypeArguments[0];
                                        final Class<?> clazz6 = class1;
                                        BytecodeManager.incBytecodes(5);
                                        if (type2 == clazz6) {
                                            final Class<?> clazz7 = class1;
                                            BytecodeManager.incBytecodes(2);
                                            return clazz7;
                                        }
                                    }
                                }
                            }
                        }
                        ++n;
                        BytecodeManager.incBytecodes(2);
                    }
                }
            }
            final Class<?> clazz8 = null;
            BytecodeManager.incBytecodes(2);
            return clazz8;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static int compareComparables(final Class<?> clazz, final Object o, final Object o2) {
        try {
            BytecodeManager.incBytecodes(2);
            int compareTo = 0;
            Label_0056: {
                if (o2 != null) {
                    BytecodeManager.incBytecodes(2);
                    final Class<?> class1 = o2.getClass();
                    BytecodeManager.incBytecodes(2);
                    if (class1 == clazz) {
                        final Comparable comparable = (Comparable)o;
                        BytecodeManager.incBytecodes(3);
                        BytecodeManager.incBytecodes(1);
                        compareTo = comparable.compareTo(o2);
                        break Label_0056;
                    }
                }
                compareTo = 0;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
            return compareTo;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static final int tableSizeFor(final int n) {
        try {
            final int n2 = n - 1;
            BytecodeManager.incBytecodes(4);
            final int n3 = n2 | n2 >>> 1;
            BytecodeManager.incBytecodes(6);
            final int n4 = n3 | n3 >>> 2;
            BytecodeManager.incBytecodes(6);
            final int n5 = n4 | n4 >>> 4;
            BytecodeManager.incBytecodes(6);
            final int n6 = n5 | n5 >>> 8;
            BytecodeManager.incBytecodes(6);
            final int n7 = n6 | n6 >>> 16;
            BytecodeManager.incBytecodes(6);
            final int n8 = n7;
            BytecodeManager.incBytecodes(2);
            int n9;
            if (n8 < 0) {
                n9 = 1;
                BytecodeManager.incBytecodes(2);
            }
            else {
                final int n10 = n7;
                final int n11 = 1073741824;
                BytecodeManager.incBytecodes(3);
                if (n10 >= n11) {
                    n9 = 1073741824;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    n9 = n7 + 1;
                    BytecodeManager.incBytecodes(3);
                }
            }
            BytecodeManager.incBytecodes(1);
            return n9;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public HashMap(int n, final float f) {
        try {
            BytecodeManager.incBytecodes(2);
            final int n2 = n;
            BytecodeManager.incBytecodes(2);
            if (n2 < 0) {
                BytecodeManager.incBytecodes(5);
                final StringBuilder sb = new StringBuilder();
                final String str = "Illegal initial capacity: ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb.append(str);
                final int i = n;
                BytecodeManager.incBytecodes(2);
                final StringBuilder append2 = append.append(i);
                BytecodeManager.incBytecodes(1);
                final String string = append2.toString();
                BytecodeManager.incBytecodes(1);
                final IllegalArgumentException ex = new IllegalArgumentException(string);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final int n3 = n;
            final int n4 = 1073741824;
            BytecodeManager.incBytecodes(3);
            if (n3 > n4) {
                n = 1073741824;
                BytecodeManager.incBytecodes(2);
            }
            final float n5 = fcmpg(f, 0.0f);
            BytecodeManager.incBytecodes(4);
            if (n5 > 0) {
                BytecodeManager.incBytecodes(2);
                final boolean naN = Float.isNaN(f);
                BytecodeManager.incBytecodes(1);
                if (!naN) {
                    this.loadFactor = f;
                    BytecodeManager.incBytecodes(3);
                    final int n6 = n;
                    BytecodeManager.incBytecodes(3);
                    this.threshold = tableSizeFor(n6);
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    return;
                }
            }
            BytecodeManager.incBytecodes(5);
            final StringBuilder sb2 = new StringBuilder();
            final String str2 = "Illegal load factor: ";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append3 = sb2.append(str2);
            BytecodeManager.incBytecodes(2);
            final StringBuilder append4 = append3.append(f);
            BytecodeManager.incBytecodes(1);
            final String string2 = append4.toString();
            BytecodeManager.incBytecodes(1);
            final IllegalArgumentException ex2 = new IllegalArgumentException(string2);
            BytecodeManager.incBytecodes(1);
            throw ex2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public HashMap(final int n) {
        try {
            final float n2 = 0.75f;
            BytecodeManager.incBytecodes(4);
            this(n, n2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public HashMap() {
        try {
            BytecodeManager.incBytecodes(2);
            this.loadFactor = 0.75f;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public HashMap(final Map<? extends K, ? extends V> map) {
        try {
            BytecodeManager.incBytecodes(2);
            this.loadFactor = 0.75f;
            BytecodeManager.incBytecodes(3);
            final boolean b = false;
            BytecodeManager.incBytecodes(4);
            this.putMapEntries(map, b);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final void putMapEntries(final Map<? extends K, ? extends V> map, final boolean b) {
        try {
            BytecodeManager.incBytecodes(2);
            final int size = map.size();
            BytecodeManager.incBytecodes(1);
            final int n = size;
            BytecodeManager.incBytecodes(2);
            if (n > 0) {
                final Node<K, V>[] table = this.table;
                BytecodeManager.incBytecodes(3);
                if (table == null) {
                    final float n2 = size / this.loadFactor + 1.0f;
                    BytecodeManager.incBytecodes(8);
                    final float n3 = fcmpg(n2, 1.07374182E9f);
                    BytecodeManager.incBytecodes(4);
                    int n4;
                    if (n3 < 0) {
                        n4 = (int)n2;
                        BytecodeManager.incBytecodes(3);
                    }
                    else {
                        n4 = 1073741824;
                        BytecodeManager.incBytecodes(1);
                    }
                    final int n5 = n4;
                    BytecodeManager.incBytecodes(1);
                    final int n6 = n5;
                    final int threshold = this.threshold;
                    BytecodeManager.incBytecodes(4);
                    if (n6 > threshold) {
                        final int n7 = n5;
                        BytecodeManager.incBytecodes(3);
                        this.threshold = tableSizeFor(n7);
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    final int n8 = size;
                    final int threshold2 = this.threshold;
                    BytecodeManager.incBytecodes(4);
                    if (n8 > threshold2) {
                        BytecodeManager.incBytecodes(2);
                        this.resize();
                        BytecodeManager.incBytecodes(1);
                    }
                }
                BytecodeManager.incBytecodes(2);
                final Set<Entry<? extends K, ? extends V>> entrySet = map.entrySet();
                BytecodeManager.incBytecodes(1);
                final Iterator<Entry<? extends K, ? extends V>> iterator = entrySet.iterator();
                BytecodeManager.incBytecodes(1);
                while (true) {
                    final Iterator<Entry<? extends K, ? extends V>> iterator2 = iterator;
                    BytecodeManager.incBytecodes(2);
                    final boolean hasNext = iterator2.hasNext();
                    BytecodeManager.incBytecodes(1);
                    if (!hasNext) {
                        break;
                    }
                    final Iterator<Entry<? extends K, ? extends V>> iterator3 = iterator;
                    BytecodeManager.incBytecodes(2);
                    final Entry<? extends K, ? extends V> entry = iterator3.next();
                    BytecodeManager.incBytecodes(2);
                    final Entry<? extends K, ? extends V> entry2 = entry;
                    BytecodeManager.incBytecodes(2);
                    final K key = (K)entry2.getKey();
                    BytecodeManager.incBytecodes(1);
                    final Entry<? extends K, ? extends V> entry3 = entry;
                    BytecodeManager.incBytecodes(2);
                    final V value = (V)entry3.getValue();
                    BytecodeManager.incBytecodes(1);
                    final K k = key;
                    BytecodeManager.incBytecodes(3);
                    final int hash = hash(k);
                    final K i = key;
                    final V v = value;
                    final boolean b2 = false;
                    BytecodeManager.incBytecodes(5);
                    this.putVal(hash, i, v, b2, b);
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                }
            }
            BytecodeManager.incBytecodes(1);
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
    public V get(final Object o) {
        try {
            BytecodeManager.incBytecodes(3);
            final int hash = hash(o);
            BytecodeManager.incBytecodes(2);
            final Node<K, V> node = this.getNode(hash, o);
            BytecodeManager.incBytecodes(3);
            V value;
            if (node == null) {
                value = null;
                BytecodeManager.incBytecodes(2);
            }
            else {
                value = node.value;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
            return value;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final Node<K, V> getNode(final int n, final Object o) {
        try {
            final Node<K, V>[] table;
            final Node<K, V>[] array = table = this.table;
            BytecodeManager.incBytecodes(5);
            if (array != null) {
                final int length = table.length;
                BytecodeManager.incBytecodes(5);
                if (length > 0) {
                    final Node<K, V> node2;
                    final Node<K, V> node = node2 = table[length - 1 & n];
                    BytecodeManager.incBytecodes(10);
                    if (node != null) {
                        final int hash = node2.hash;
                        BytecodeManager.incBytecodes(4);
                        Label_0118: {
                            if (hash == n) {
                                final K key = node2.key;
                                BytecodeManager.incBytecodes(6);
                                if (key != o) {
                                    BytecodeManager.incBytecodes(2);
                                    if (o == null) {
                                        break Label_0118;
                                    }
                                    final K obj = key;
                                    BytecodeManager.incBytecodes(2);
                                    BytecodeManager.incBytecodes(1);
                                    final boolean equals = o.equals(obj);
                                    BytecodeManager.incBytecodes(1);
                                    if (!equals) {
                                        break Label_0118;
                                    }
                                }
                                final Node<K, V> node3 = node2;
                                BytecodeManager.incBytecodes(2);
                                return node3;
                            }
                        }
                        Node<K, V> node5;
                        final Node<K, V> node4 = node5 = node2.next;
                        BytecodeManager.incBytecodes(5);
                        if (node4 != null) {
                            final boolean b = node2 instanceof TreeNode;
                            BytecodeManager.incBytecodes(3);
                            if (b) {
                                final TreeNode<K, V> treeNode = (TreeNode<K, V>)node2;
                                BytecodeManager.incBytecodes(5);
                                final TreeNode<K, V> treeNode2 = treeNode.getTreeNode(n, o);
                                BytecodeManager.incBytecodes(1);
                                return treeNode2;
                            }
                            Node<K, V> node6;
                            do {
                                final int hash2 = node5.hash;
                                BytecodeManager.incBytecodes(4);
                                Label_0240: {
                                    if (hash2 == n) {
                                        final K key2 = node5.key;
                                        BytecodeManager.incBytecodes(6);
                                        if (key2 != o) {
                                            BytecodeManager.incBytecodes(2);
                                            if (o == null) {
                                                break Label_0240;
                                            }
                                            final K obj2 = key2;
                                            BytecodeManager.incBytecodes(2);
                                            BytecodeManager.incBytecodes(1);
                                            final boolean equals2 = o.equals(obj2);
                                            BytecodeManager.incBytecodes(1);
                                            if (!equals2) {
                                                break Label_0240;
                                            }
                                        }
                                        final Node<K, V> node7 = node5;
                                        BytecodeManager.incBytecodes(2);
                                        return node7;
                                    }
                                }
                                node6 = (node5 = node5.next);
                                BytecodeManager.incBytecodes(5);
                            } while (node6 != null);
                        }
                    }
                }
            }
            final Node<K, V> node8 = null;
            BytecodeManager.incBytecodes(2);
            return node8;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean containsKey(final Object o) {
        try {
            BytecodeManager.incBytecodes(3);
            final int hash = hash(o);
            BytecodeManager.incBytecodes(2);
            final Node<K, V> node = this.getNode(hash, o);
            BytecodeManager.incBytecodes(1);
            boolean b;
            if (node != null) {
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
    public V put(final K k, final V v) {
        try {
            BytecodeManager.incBytecodes(3);
            final int hash = hash(k);
            final boolean b = false;
            final boolean b2 = true;
            BytecodeManager.incBytecodes(5);
            final Object putVal = this.putVal(hash, k, v, b, b2);
            BytecodeManager.incBytecodes(1);
            return (V)putVal;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final V putVal(final int n, final K k, final V value, final boolean b, final boolean b2) {
        try {
            Node<K, V>[] array2;
            final Node<K, V>[] array = array2 = this.table;
            BytecodeManager.incBytecodes(5);
            int n2 = 0;
            Label_0049: {
                if (array != null) {
                    n2 = array2.length;
                    BytecodeManager.incBytecodes(5);
                    if (n2 != 0) {
                        break Label_0049;
                    }
                }
                BytecodeManager.incBytecodes(2);
                n2 = (array2 = this.resize()).length;
                BytecodeManager.incBytecodes(4);
            }
            final int n3;
            Node<K, V> node2;
            final Node<K, V> node = node2 = array2[n3 = (n2 - 1 & n)];
            BytecodeManager.incBytecodes(12);
            if (node == null) {
                final Node<K, V>[] array3 = array2;
                final int n4 = n3;
                final Node<K, V> node3 = null;
                BytecodeManager.incBytecodes(8);
                array3[n4] = this.newNode(n, k, value, node3);
                BytecodeManager.incBytecodes(2);
            }
            else {
                final int hash = node2.hash;
                BytecodeManager.incBytecodes(4);
                Node<K, V> node4 = null;
                Label_0388: {
                    Label_0175: {
                        if (hash == n) {
                            final K key = node2.key;
                            BytecodeManager.incBytecodes(6);
                            if (key != k) {
                                BytecodeManager.incBytecodes(2);
                                if (k == null) {
                                    break Label_0175;
                                }
                                final K obj = key;
                                BytecodeManager.incBytecodes(2);
                                BytecodeManager.incBytecodes(1);
                                final boolean equals = k.equals(obj);
                                BytecodeManager.incBytecodes(1);
                                if (!equals) {
                                    break Label_0175;
                                }
                            }
                            node4 = node2;
                            BytecodeManager.incBytecodes(3);
                            break Label_0388;
                        }
                    }
                    final boolean b3 = node2 instanceof TreeNode;
                    BytecodeManager.incBytecodes(3);
                    if (b3) {
                        final TreeNode<K, V> treeNode = (TreeNode<K, V>)node2;
                        final Node<K, V>[] array4 = array2;
                        BytecodeManager.incBytecodes(8);
                        node4 = treeNode.putTreeVal(this, array4, n, k, value);
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        int n5 = 0;
                        BytecodeManager.incBytecodes(2);
                        while (true) {
                            final Node<K, V> node5 = node4 = node2.next;
                            BytecodeManager.incBytecodes(5);
                            if (node5 == null) {
                                final TreeNode<K, V> treeNode2 = (TreeNode<K, V>)node2;
                                final Node<K, V> node6 = null;
                                BytecodeManager.incBytecodes(7);
                                treeNode2.next = (Node<K, V>)this.newNode(n, (K)k, (V)value, (Node<K, V>)node6);
                                BytecodeManager.incBytecodes(1);
                                final int n6 = n5;
                                final int n7 = 7;
                                BytecodeManager.incBytecodes(3);
                                if (n6 >= n7) {
                                    final Node<K, V>[] array5 = array2;
                                    BytecodeManager.incBytecodes(4);
                                    this.treeifyBin(array5, n);
                                    BytecodeManager.incBytecodes(1);
                                    break;
                                }
                                break;
                            }
                            else {
                                final int hash2 = node4.hash;
                                BytecodeManager.incBytecodes(4);
                                if (hash2 == n) {
                                    final K key2 = node4.key;
                                    BytecodeManager.incBytecodes(6);
                                    if (key2 == k) {
                                        break;
                                    }
                                    BytecodeManager.incBytecodes(2);
                                    if (k != null) {
                                        final K obj2 = key2;
                                        BytecodeManager.incBytecodes(2);
                                        BytecodeManager.incBytecodes(1);
                                        final boolean equals2 = k.equals(obj2);
                                        BytecodeManager.incBytecodes(1);
                                        if (equals2) {
                                            BytecodeManager.incBytecodes(1);
                                            break;
                                        }
                                    }
                                }
                                node2 = node4;
                                BytecodeManager.incBytecodes(2);
                                ++n5;
                                BytecodeManager.incBytecodes(2);
                            }
                        }
                    }
                }
                final Node<K, V> node7 = node4;
                BytecodeManager.incBytecodes(2);
                if (node7 != null) {
                    final V value2 = node4.value;
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(2);
                    Label_0441: {
                        if (b) {
                            final V v = value2;
                            BytecodeManager.incBytecodes(2);
                            if (v != null) {
                                break Label_0441;
                            }
                        }
                        node4.value = value;
                        BytecodeManager.incBytecodes(3);
                    }
                    final Node<K, V> node8 = node4;
                    BytecodeManager.incBytecodes(3);
                    this.afterNodeAccess(node8);
                    final V v2 = value2;
                    BytecodeManager.incBytecodes(2);
                    return v2;
                }
            }
            ++this.modCount;
            BytecodeManager.incBytecodes(6);
            final int n8 = ++this.size;
            final int threshold = this.threshold;
            BytecodeManager.incBytecodes(10);
            if (n8 > threshold) {
                BytecodeManager.incBytecodes(2);
                this.resize();
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(3);
            this.afterNodeInsertion(b2);
            final V v3 = null;
            BytecodeManager.incBytecodes(2);
            return v3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final Node<K, V>[] resize() {
        try {
            final Node<K, V>[] table = this.table;
            BytecodeManager.incBytecodes(3);
            final Node<K, V>[] array = table;
            BytecodeManager.incBytecodes(2);
            int length;
            if (array == null) {
                length = 0;
                BytecodeManager.incBytecodes(2);
            }
            else {
                length = table.length;
                BytecodeManager.incBytecodes(2);
            }
            final int n = length;
            BytecodeManager.incBytecodes(1);
            final int threshold = this.threshold;
            BytecodeManager.incBytecodes(3);
            int threshold2 = 0;
            BytecodeManager.incBytecodes(2);
            final int n2 = n;
            BytecodeManager.incBytecodes(2);
            int n6;
            if (n2 > 0) {
                final int n3 = n;
                final int n4 = 1073741824;
                BytecodeManager.incBytecodes(3);
                if (n3 >= n4) {
                    this.threshold = Integer.MAX_VALUE;
                    BytecodeManager.incBytecodes(3);
                    final Node<K, V>[] array2 = table;
                    BytecodeManager.incBytecodes(2);
                    return array2;
                }
                final int n5 = n6 = n << 1;
                final int n7 = 1073741824;
                BytecodeManager.incBytecodes(7);
                if (n5 < n7) {
                    final int n8 = n;
                    final int n9 = 16;
                    BytecodeManager.incBytecodes(3);
                    if (n8 >= n9) {
                        threshold2 = threshold << 1;
                        BytecodeManager.incBytecodes(5);
                    }
                }
            }
            else {
                final int n10 = threshold;
                BytecodeManager.incBytecodes(2);
                if (n10 > 0) {
                    n6 = threshold;
                    BytecodeManager.incBytecodes(3);
                }
                else {
                    n6 = 16;
                    BytecodeManager.incBytecodes(2);
                    threshold2 = 12;
                    BytecodeManager.incBytecodes(2);
                }
            }
            final int n11 = threshold2;
            BytecodeManager.incBytecodes(2);
            if (n11 == 0) {
                final float n12 = n6 * this.loadFactor;
                BytecodeManager.incBytecodes(6);
                final int n13 = n6;
                final int n14 = 1073741824;
                BytecodeManager.incBytecodes(3);
                int n16 = 0;
                Label_0245: {
                    if (n13 < n14) {
                        final float n15 = fcmpg(n12, 1.07374182E9f);
                        BytecodeManager.incBytecodes(4);
                        if (n15 < 0) {
                            n16 = (int)n12;
                            BytecodeManager.incBytecodes(3);
                            break Label_0245;
                        }
                    }
                    n16 = Integer.MAX_VALUE;
                    BytecodeManager.incBytecodes(1);
                }
                threshold2 = n16;
                BytecodeManager.incBytecodes(1);
            }
            this.threshold = threshold2;
            BytecodeManager.incBytecodes(3);
            final Node[] table2 = new Node[n6];
            BytecodeManager.incBytecodes(3);
            this.table = (Node<K, V>[])table2;
            BytecodeManager.incBytecodes(3);
            final Node<K, V>[] array3 = table;
            BytecodeManager.incBytecodes(2);
            if (array3 != null) {
                int n17 = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n18 = n17;
                    final int n19 = n;
                    BytecodeManager.incBytecodes(3);
                    if (n18 >= n19) {
                        break;
                    }
                    Node<K, V> node2;
                    final Node<K, V> node = node2 = table[n17];
                    BytecodeManager.incBytecodes(6);
                    if (node != null) {
                        table[n17] = null;
                        BytecodeManager.incBytecodes(4);
                        final Node<K, V> next = node2.next;
                        BytecodeManager.incBytecodes(3);
                        if (next == null) {
                            table2[node2.hash & n6 - 1] = node2;
                            BytecodeManager.incBytecodes(10);
                        }
                        else {
                            final boolean b = node2 instanceof TreeNode;
                            BytecodeManager.incBytecodes(3);
                            if (b) {
                                final TreeNode<K, V> treeNode = (TreeNode<K, V>)node2;
                                final Node<K, V>[] array4 = (Node<K, V>[])table2;
                                final int n20 = n17;
                                final int n21 = n;
                                BytecodeManager.incBytecodes(7);
                                treeNode.split(this, array4, n20, n21);
                                BytecodeManager.incBytecodes(1);
                            }
                            else {
                                Node<K, V> node3 = null;
                                Node<K, V> node4 = null;
                                BytecodeManager.incBytecodes(4);
                                Node<K, V> node5 = null;
                                Node<K, V> node6 = null;
                                BytecodeManager.incBytecodes(4);
                                TreeNode<K, V> treeNode2;
                                do {
                                    final Node<K, V> next2 = (Node<K, V>)node2.next;
                                    BytecodeManager.incBytecodes(3);
                                    final int n22 = node2.hash & n;
                                    BytecodeManager.incBytecodes(5);
                                    if (n22 == 0) {
                                        final Node<K, V> node7 = node4;
                                        BytecodeManager.incBytecodes(2);
                                        if (node7 == null) {
                                            node3 = node2;
                                            BytecodeManager.incBytecodes(3);
                                        }
                                        else {
                                            node4.next = node2;
                                            BytecodeManager.incBytecodes(3);
                                        }
                                        node4 = node2;
                                        BytecodeManager.incBytecodes(3);
                                    }
                                    else {
                                        final Node<K, V> node8 = node6;
                                        BytecodeManager.incBytecodes(2);
                                        if (node8 == null) {
                                            node5 = node2;
                                            BytecodeManager.incBytecodes(3);
                                        }
                                        else {
                                            node6.next = node2;
                                            BytecodeManager.incBytecodes(3);
                                        }
                                        node6 = node2;
                                        BytecodeManager.incBytecodes(2);
                                    }
                                    treeNode2 = (TreeNode<K, V>)(node2 = (Node<K, V>)next2);
                                    BytecodeManager.incBytecodes(4);
                                } while (treeNode2 != null);
                                final Node<K, V> node9 = node4;
                                BytecodeManager.incBytecodes(2);
                                if (node9 != null) {
                                    node4.next = null;
                                    BytecodeManager.incBytecodes(3);
                                    table2[n17] = node3;
                                    BytecodeManager.incBytecodes(4);
                                }
                                final Node<K, V> node10 = node6;
                                BytecodeManager.incBytecodes(2);
                                if (node10 != null) {
                                    node6.next = null;
                                    BytecodeManager.incBytecodes(3);
                                    table2[n17 + n] = node5;
                                    BytecodeManager.incBytecodes(6);
                                }
                            }
                        }
                    }
                    ++n17;
                    BytecodeManager.incBytecodes(2);
                }
            }
            final Node<K, V>[] array5 = (Node<K, V>[])table2;
            BytecodeManager.incBytecodes(2);
            return array5;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final void treeifyBin(final Node<K, V>[] array, final int n) {
        try {
            BytecodeManager.incBytecodes(2);
            Label_0190: {
                if (array != null) {
                    final int length = array.length;
                    final int n2 = 64;
                    BytecodeManager.incBytecodes(6);
                    if (length >= n2) {
                        final int n3;
                        Node<K, V> next;
                        final Node<K, V> node = next = array[n3 = (length - 1 & n)];
                        BytecodeManager.incBytecodes(12);
                        if (node == null) {
                            break Label_0190;
                        }
                        TreeNode<K, V> treeNode = null;
                        TreeNode<K, V> prev = null;
                        BytecodeManager.incBytecodes(4);
                        Node<K, V> node2;
                        do {
                            final Node<K, V> node3 = next;
                            final Node<K, V> node4 = null;
                            BytecodeManager.incBytecodes(4);
                            final TreeNode<K, V> replacementTreeNode = this.replacementTreeNode((Node<K, V>)node3, (Node<K, V>)node4);
                            BytecodeManager.incBytecodes(1);
                            final TreeNode<K, V> treeNode2 = prev;
                            BytecodeManager.incBytecodes(2);
                            if (treeNode2 == null) {
                                treeNode = (TreeNode<K, V>)replacementTreeNode;
                                BytecodeManager.incBytecodes(3);
                            }
                            else {
                                replacementTreeNode.prev = (TreeNode<K, V>)prev;
                                BytecodeManager.incBytecodes(3);
                                prev.next = (Node<K, V>)replacementTreeNode;
                                BytecodeManager.incBytecodes(3);
                            }
                            prev = (TreeNode<K, V>)replacementTreeNode;
                            BytecodeManager.incBytecodes(2);
                            node2 = (next = next.next);
                            BytecodeManager.incBytecodes(5);
                        } while (node2 != null);
                        final int n4 = n3;
                        final TreeNode<K, V> treeNode3 = treeNode;
                        array[n4] = treeNode3;
                        BytecodeManager.incBytecodes(6);
                        if (treeNode3 != null) {
                            final TreeNode<K, V> treeNode4 = treeNode;
                            BytecodeManager.incBytecodes(3);
                            treeNode4.treeify(array);
                        }
                        break Label_0190;
                    }
                }
                BytecodeManager.incBytecodes(2);
                this.resize();
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void putAll(final Map<? extends K, ? extends V> map) {
        try {
            final boolean b = true;
            BytecodeManager.incBytecodes(4);
            this.putMapEntries(map, b);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public V remove(final Object o) {
        try {
            BytecodeManager.incBytecodes(3);
            final int hash = hash(o);
            final Object o2 = null;
            final boolean b = false;
            final boolean b2 = true;
            BytecodeManager.incBytecodes(5);
            final Node<K, V> removeNode = this.removeNode(hash, o, o2, b, b2);
            BytecodeManager.incBytecodes(3);
            V value;
            if (removeNode == null) {
                value = null;
                BytecodeManager.incBytecodes(2);
            }
            else {
                value = removeNode.value;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
            return value;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final Node<K, V> removeNode(final int n, final Object o, final Object o2, final boolean b, final boolean b2) {
        try {
            final Node<K, V>[] table;
            final Node<K, V>[] array = table = this.table;
            BytecodeManager.incBytecodes(5);
            Label_0500: {
                if (array != null) {
                    final int length = table.length;
                    BytecodeManager.incBytecodes(5);
                    if (length > 0) {
                        final int n2;
                        Node<K, V> node2;
                        final Node<K, V> node = node2 = table[n2 = (length - 1 & n)];
                        BytecodeManager.incBytecodes(12);
                        if (node != null) {
                            Node<K, V> treeNode = null;
                            BytecodeManager.incBytecodes(2);
                            final int hash = node2.hash;
                            BytecodeManager.incBytecodes(4);
                            Label_0297: {
                                Label_0137: {
                                    if (hash == n) {
                                        final K key = node2.key;
                                        BytecodeManager.incBytecodes(6);
                                        if (key != o) {
                                            BytecodeManager.incBytecodes(2);
                                            if (o == null) {
                                                break Label_0137;
                                            }
                                            final K obj = key;
                                            BytecodeManager.incBytecodes(2);
                                            BytecodeManager.incBytecodes(1);
                                            final boolean equals = o.equals(obj);
                                            BytecodeManager.incBytecodes(1);
                                            if (!equals) {
                                                break Label_0137;
                                            }
                                        }
                                        treeNode = node2;
                                        BytecodeManager.incBytecodes(3);
                                        break Label_0297;
                                    }
                                }
                                Node<K, V> node4;
                                final Node<K, V> node3 = node4 = node2.next;
                                BytecodeManager.incBytecodes(5);
                                if (node3 != null) {
                                    final boolean b3 = node2 instanceof TreeNode;
                                    BytecodeManager.incBytecodes(3);
                                    if (b3) {
                                        final TreeNode<K, V> treeNode2 = (TreeNode<K, V>)node2;
                                        BytecodeManager.incBytecodes(5);
                                        treeNode = treeNode2.getTreeNode(n, o);
                                        BytecodeManager.incBytecodes(2);
                                    }
                                    else {
                                        Node<K, V> node5;
                                        do {
                                            final int hash2 = node4.hash;
                                            BytecodeManager.incBytecodes(4);
                                            Label_0272: {
                                                if (hash2 == n) {
                                                    final K key2 = node4.key;
                                                    BytecodeManager.incBytecodes(6);
                                                    if (key2 != o) {
                                                        BytecodeManager.incBytecodes(2);
                                                        if (o == null) {
                                                            break Label_0272;
                                                        }
                                                        final K obj2 = key2;
                                                        BytecodeManager.incBytecodes(2);
                                                        BytecodeManager.incBytecodes(1);
                                                        final boolean equals2 = o.equals(obj2);
                                                        BytecodeManager.incBytecodes(1);
                                                        if (!equals2) {
                                                            break Label_0272;
                                                        }
                                                    }
                                                    treeNode = node4;
                                                    BytecodeManager.incBytecodes(2);
                                                    BytecodeManager.incBytecodes(1);
                                                    break;
                                                }
                                            }
                                            node2 = node4;
                                            BytecodeManager.incBytecodes(2);
                                            node5 = (node4 = node4.next);
                                            BytecodeManager.incBytecodes(5);
                                        } while (node5 != null);
                                    }
                                }
                            }
                            final Node<K, V> node6 = treeNode;
                            BytecodeManager.incBytecodes(2);
                            if (node6 != null) {
                                BytecodeManager.incBytecodes(2);
                                if (b) {
                                    final V value = treeNode.value;
                                    BytecodeManager.incBytecodes(6);
                                    if (value != o2) {
                                        BytecodeManager.incBytecodes(2);
                                        if (o2 == null) {
                                            break Label_0500;
                                        }
                                        final V obj3 = value;
                                        BytecodeManager.incBytecodes(2);
                                        BytecodeManager.incBytecodes(1);
                                        final boolean equals3 = o2.equals(obj3);
                                        BytecodeManager.incBytecodes(1);
                                        if (!equals3) {
                                            break Label_0500;
                                        }
                                    }
                                }
                                final boolean b4 = treeNode instanceof TreeNode;
                                BytecodeManager.incBytecodes(3);
                                if (b4) {
                                    final TreeNode<K, V> treeNode3 = (TreeNode<K, V>)treeNode;
                                    final Node<K, V>[] array2 = table;
                                    BytecodeManager.incBytecodes(6);
                                    treeNode3.removeTreeNode(this, array2, b2);
                                    BytecodeManager.incBytecodes(1);
                                }
                                else {
                                    final TreeNode<K, V> treeNode4 = (TreeNode<K, V>)treeNode;
                                    final TreeNode<K, V> treeNode5 = (TreeNode<K, V>)node2;
                                    BytecodeManager.incBytecodes(3);
                                    if (treeNode4 == treeNode5) {
                                        table[n2] = treeNode.next;
                                        BytecodeManager.incBytecodes(6);
                                    }
                                    else {
                                        node2.next = treeNode.next;
                                        BytecodeManager.incBytecodes(4);
                                    }
                                }
                                ++this.modCount;
                                BytecodeManager.incBytecodes(6);
                                --this.size;
                                BytecodeManager.incBytecodes(6);
                                final TreeNode<K, V> treeNode6 = (TreeNode<K, V>)treeNode;
                                BytecodeManager.incBytecodes(3);
                                this.afterNodeRemoval(treeNode6);
                                final TreeNode<K, V> treeNode7 = (TreeNode<K, V>)treeNode;
                                BytecodeManager.incBytecodes(2);
                                return treeNode7;
                            }
                        }
                    }
                }
            }
            final Node<K, V> node7 = null;
            BytecodeManager.incBytecodes(2);
            return node7;
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
            final Node<K, V>[] table;
            final Node<K, V>[] array = table = this.table;
            BytecodeManager.incBytecodes(5);
            if (array != null) {
                final int size = this.size;
                BytecodeManager.incBytecodes(3);
                if (size > 0) {
                    this.size = 0;
                    BytecodeManager.incBytecodes(3);
                    int n = 0;
                    BytecodeManager.incBytecodes(2);
                    while (true) {
                        final int n2 = n;
                        final int length = table.length;
                        BytecodeManager.incBytecodes(4);
                        if (n2 >= length) {
                            break;
                        }
                        table[n] = null;
                        BytecodeManager.incBytecodes(4);
                        ++n;
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
    
    @Override
    public boolean containsValue(final Object o) {
        try {
            final Node<K, V>[] table;
            final Node<K, V>[] array = table = this.table;
            BytecodeManager.incBytecodes(5);
            Label_0148: {
                if (array != null) {
                    final int size = this.size;
                    BytecodeManager.incBytecodes(3);
                    if (size > 0) {
                        int n = 0;
                        BytecodeManager.incBytecodes(2);
                    Label_0115:
                        while (true) {
                            final int n2 = n;
                            final int length = table.length;
                            BytecodeManager.incBytecodes(4);
                            if (n2 >= length) {
                                break Label_0148;
                            }
                            Node<K, V> next = table[n];
                            BytecodeManager.incBytecodes(4);
                            while (true) {
                                final Node<K, V> node = next;
                                BytecodeManager.incBytecodes(2);
                                if (node == null) {
                                    break;
                                }
                                final V value = next.value;
                                BytecodeManager.incBytecodes(6);
                                if (value == o) {
                                    break Label_0115;
                                }
                                BytecodeManager.incBytecodes(2);
                                if (o != null) {
                                    final V obj = value;
                                    BytecodeManager.incBytecodes(2);
                                    BytecodeManager.incBytecodes(1);
                                    final boolean equals = o.equals(obj);
                                    BytecodeManager.incBytecodes(1);
                                    if (equals) {
                                        break Label_0115;
                                    }
                                }
                                next = next.next;
                                BytecodeManager.incBytecodes(4);
                            }
                            ++n;
                            BytecodeManager.incBytecodes(2);
                        }
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
    public Set<K> keySet() {
        try {
            final Set<K> keySet = this.keySet;
            BytecodeManager.incBytecodes(5);
            Set<K> set;
            if (keySet == null) {
                final KeySet keySet2 = (KeySet)(set = new KeySet());
                BytecodeManager.incBytecodes(5);
                this.keySet = keySet2;
                BytecodeManager.incBytecodes(3);
            }
            else {
                set = keySet;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return set;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public Collection<V> values() {
        try {
            final Collection<V> values = this.values;
            BytecodeManager.incBytecodes(5);
            Collection<V> collection;
            if (values == null) {
                final Values values2 = (Values)(collection = new Values());
                BytecodeManager.incBytecodes(5);
                this.values = values2;
                BytecodeManager.incBytecodes(3);
            }
            else {
                collection = values;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return collection;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public Set<Entry<K, V>> entrySet() {
        try {
            final Set<Entry<K, V>> entrySet = this.entrySet;
            BytecodeManager.incBytecodes(5);
            Set<Entry<K, V>> set;
            if (entrySet == null) {
                final EntrySet entrySet2 = (EntrySet)(set = new EntrySet());
                BytecodeManager.incBytecodes(5);
                this.entrySet = entrySet2;
                BytecodeManager.incBytecodes(3);
            }
            else {
                set = entrySet;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return set;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public V getOrDefault(final Object o, final V v) {
        try {
            BytecodeManager.incBytecodes(3);
            final int hash = hash(o);
            BytecodeManager.incBytecodes(2);
            final Node<K, V> node = this.getNode(hash, o);
            BytecodeManager.incBytecodes(3);
            V value;
            if (node == null) {
                value = v;
                BytecodeManager.incBytecodes(2);
            }
            else {
                value = node.value;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
            return value;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public V putIfAbsent(final K k, final V v) {
        try {
            BytecodeManager.incBytecodes(3);
            final int hash = hash(k);
            final boolean b = true;
            final boolean b2 = true;
            BytecodeManager.incBytecodes(5);
            final Object putVal = this.putVal(hash, k, v, b, b2);
            BytecodeManager.incBytecodes(1);
            return (V)putVal;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean remove(final Object o, final Object o2) {
        try {
            BytecodeManager.incBytecodes(3);
            final int hash = hash(o);
            final boolean b = true;
            final boolean b2 = true;
            BytecodeManager.incBytecodes(5);
            final Node<K, V> removeNode = this.removeNode(hash, o, o2, b, b2);
            BytecodeManager.incBytecodes(1);
            boolean b3;
            if (removeNode != null) {
                b3 = true;
                BytecodeManager.incBytecodes(2);
            }
            else {
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
    public boolean replace(final K k, final V obj, final V value) {
        try {
            BytecodeManager.incBytecodes(3);
            final int hash = hash(k);
            BytecodeManager.incBytecodes(2);
            final Node<K, V> node2;
            final Node<K, V> node = node2 = this.getNode(hash, k);
            BytecodeManager.incBytecodes(3);
            Label_0110: {
                if (node != null) {
                    final V value2;
                    final V v = value2 = node2.value;
                    BytecodeManager.incBytecodes(6);
                    if (v != obj) {
                        final V v2 = value2;
                        BytecodeManager.incBytecodes(2);
                        if (v2 == null) {
                            break Label_0110;
                        }
                        final V v3 = value2;
                        BytecodeManager.incBytecodes(2);
                        BytecodeManager.incBytecodes(1);
                        final boolean equals = v3.equals(obj);
                        BytecodeManager.incBytecodes(1);
                        if (!equals) {
                            break Label_0110;
                        }
                    }
                    node2.value = value;
                    BytecodeManager.incBytecodes(3);
                    final Node<K, V> node3 = node2;
                    BytecodeManager.incBytecodes(3);
                    this.afterNodeAccess(node3);
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
    public V replace(final K k, final V value) {
        try {
            BytecodeManager.incBytecodes(3);
            final int hash = hash(k);
            BytecodeManager.incBytecodes(2);
            final Node<K, V> node2;
            final Node<K, V> node = node2 = this.getNode(hash, k);
            BytecodeManager.incBytecodes(3);
            if (node != null) {
                final V value2 = node2.value;
                BytecodeManager.incBytecodes(3);
                node2.value = value;
                BytecodeManager.incBytecodes(3);
                final Node<K, V> node3 = node2;
                BytecodeManager.incBytecodes(3);
                this.afterNodeAccess(node3);
                final V v = value2;
                BytecodeManager.incBytecodes(2);
                return v;
            }
            final V v2 = null;
            BytecodeManager.incBytecodes(2);
            return v2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public V computeIfAbsent(final K k, final Function<? super K, ? extends V> function) {
        try {
            BytecodeManager.incBytecodes(2);
            if (function == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(2);
            final int hash = hash(k);
            BytecodeManager.incBytecodes(1);
            int n = 0;
            BytecodeManager.incBytecodes(2);
            TreeNode<K, Object> treeNode = null;
            BytecodeManager.incBytecodes(2);
            Object treeNode2 = null;
            BytecodeManager.incBytecodes(2);
            final int size = this.size;
            final int threshold = this.threshold;
            BytecodeManager.incBytecodes(5);
            Node<K, V>[] array2 = null;
            int n2 = 0;
            Label_0131: {
                if (size <= threshold) {
                    final Node<K, V>[] array = array2 = this.table;
                    BytecodeManager.incBytecodes(5);
                    if (array != null) {
                        n2 = array2.length;
                        BytecodeManager.incBytecodes(5);
                        if (n2 != 0) {
                            break Label_0131;
                        }
                    }
                }
                BytecodeManager.incBytecodes(2);
                n2 = (array2 = this.resize()).length;
                BytecodeManager.incBytecodes(4);
            }
            final int n3;
            final Node<K, V> node2;
            final Node<K, V> node = node2 = array2[n3 = (n2 - 1 & hash)];
            BytecodeManager.incBytecodes(12);
            if (node != null) {
                final boolean b = node2 instanceof TreeNode;
                BytecodeManager.incBytecodes(3);
                if (b) {
                    final TreeNode<K, Object> treeNode3 = treeNode = (TreeNode<K, Object>)node2;
                    final int n4 = hash;
                    BytecodeManager.incBytecodes(7);
                    treeNode2 = treeNode3.getTreeNode(n4, k);
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    Node<K, V> next = node2;
                    BytecodeManager.incBytecodes(2);
                    Node<K, V> node3;
                    do {
                        final int hash2 = next.hash;
                        final int n5 = hash;
                        BytecodeManager.incBytecodes(4);
                        Label_0286: {
                            if (hash2 == n5) {
                                final K key = next.key;
                                BytecodeManager.incBytecodes(6);
                                if (key != k) {
                                    BytecodeManager.incBytecodes(2);
                                    if (k == null) {
                                        break Label_0286;
                                    }
                                    final K obj = key;
                                    BytecodeManager.incBytecodes(2);
                                    BytecodeManager.incBytecodes(1);
                                    final boolean equals = k.equals(obj);
                                    BytecodeManager.incBytecodes(1);
                                    if (!equals) {
                                        break Label_0286;
                                    }
                                }
                                treeNode2 = next;
                                BytecodeManager.incBytecodes(2);
                                BytecodeManager.incBytecodes(1);
                                break;
                            }
                        }
                        ++n;
                        BytecodeManager.incBytecodes(1);
                        node3 = (next = next.next);
                        BytecodeManager.incBytecodes(5);
                    } while (node3 != null);
                }
                final Object o = treeNode2;
                BytecodeManager.incBytecodes(2);
                if (o != null) {
                    final V value = ((Node)treeNode2).value;
                    BytecodeManager.incBytecodes(5);
                    if (value != null) {
                        final Node node4 = (Node)treeNode2;
                        BytecodeManager.incBytecodes(3);
                        this.afterNodeAccess(node4);
                        final V v = value;
                        BytecodeManager.incBytecodes(2);
                        return (V)v;
                    }
                }
            }
            BytecodeManager.incBytecodes(3);
            final V apply = (V)function.apply(k);
            BytecodeManager.incBytecodes(1);
            final V v2 = apply;
            BytecodeManager.incBytecodes(2);
            if (v2 == null) {
                final V v3 = null;
                BytecodeManager.incBytecodes(2);
                return v3;
            }
            final Node<K, V> node5 = (Node<K, V>)treeNode2;
            BytecodeManager.incBytecodes(2);
            if (node5 != null) {
                ((Node)treeNode2).value = (V)apply;
                BytecodeManager.incBytecodes(3);
                final Node<K, V> node6 = (Node<K, V>)treeNode2;
                BytecodeManager.incBytecodes(3);
                this.afterNodeAccess(node6);
                final V v4 = apply;
                BytecodeManager.incBytecodes(2);
                return v4;
            }
            final TreeNode<K, Object> treeNode4 = treeNode;
            BytecodeManager.incBytecodes(2);
            if (treeNode4 != null) {
                final TreeNode<K, Object> treeNode5 = treeNode;
                final Node<K, V>[] array3 = array2;
                final int n6 = hash;
                final V v5 = apply;
                BytecodeManager.incBytecodes(7);
                treeNode5.putTreeVal((HashMap<K, Object>)this, (Node<K, Object>[])array3, n6, k, v5);
                BytecodeManager.incBytecodes(2);
            }
            else {
                final Node<K, V>[] array4 = array2;
                final int n7 = n3;
                final int n8 = hash;
                final V v6 = apply;
                final Node<K, V> node7 = node2;
                BytecodeManager.incBytecodes(8);
                array4[n7] = (Node<K, V>)this.newNode(n8, k, v6, (Node<K, Object>)node7);
                BytecodeManager.incBytecodes(1);
                final int n9 = n;
                final int n10 = 7;
                BytecodeManager.incBytecodes(3);
                if (n9 >= n10) {
                    final Node<K, V>[] array5 = array2;
                    final int n11 = hash;
                    BytecodeManager.incBytecodes(4);
                    this.treeifyBin(array5, n11);
                }
            }
            ++this.modCount;
            BytecodeManager.incBytecodes(6);
            ++this.size;
            BytecodeManager.incBytecodes(6);
            final boolean b2 = true;
            BytecodeManager.incBytecodes(3);
            this.afterNodeInsertion(b2);
            final V v7 = apply;
            BytecodeManager.incBytecodes(2);
            return v7;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public V computeIfPresent(final K k, final BiFunction<? super K, ? super V, ? extends V> biFunction) {
        try {
            BytecodeManager.incBytecodes(2);
            if (biFunction == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(2);
            final int hash = hash(k);
            BytecodeManager.incBytecodes(1);
            final int n = hash;
            BytecodeManager.incBytecodes(4);
            final Node<K, V> node2;
            final Node<K, V> node = node2 = this.getNode(n, k);
            BytecodeManager.incBytecodes(3);
            if (node != null) {
                final V value = node2.value;
                BytecodeManager.incBytecodes(5);
                if (value != null) {
                    final V v = value;
                    BytecodeManager.incBytecodes(4);
                    final V apply = (V)biFunction.apply(k, v);
                    BytecodeManager.incBytecodes(1);
                    final V v2 = apply;
                    BytecodeManager.incBytecodes(2);
                    if (v2 != null) {
                        node2.value = apply;
                        BytecodeManager.incBytecodes(3);
                        final Node<K, V> node3 = node2;
                        BytecodeManager.incBytecodes(3);
                        this.afterNodeAccess(node3);
                        final V v3 = apply;
                        BytecodeManager.incBytecodes(2);
                        return v3;
                    }
                    final int n2 = hash;
                    final Object o = null;
                    final boolean b = false;
                    final boolean b2 = true;
                    BytecodeManager.incBytecodes(7);
                    this.removeNode(n2, k, o, b, b2);
                    BytecodeManager.incBytecodes(1);
                }
            }
            final V v4 = null;
            BytecodeManager.incBytecodes(2);
            return v4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public V compute(final K k, final BiFunction<? super K, ? super V, ? extends V> biFunction) {
        try {
            BytecodeManager.incBytecodes(2);
            if (biFunction == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(2);
            final int hash = hash(k);
            BytecodeManager.incBytecodes(1);
            int n = 0;
            BytecodeManager.incBytecodes(2);
            TreeNode<K, Object> treeNode = null;
            BytecodeManager.incBytecodes(2);
            Object treeNode2 = null;
            BytecodeManager.incBytecodes(2);
            final int size = this.size;
            final int threshold = this.threshold;
            BytecodeManager.incBytecodes(5);
            Node<K, V>[] array2 = null;
            int n2 = 0;
            Label_0131: {
                if (size <= threshold) {
                    final Node<K, V>[] array = array2 = this.table;
                    BytecodeManager.incBytecodes(5);
                    if (array != null) {
                        n2 = array2.length;
                        BytecodeManager.incBytecodes(5);
                        if (n2 != 0) {
                            break Label_0131;
                        }
                    }
                }
                BytecodeManager.incBytecodes(2);
                n2 = (array2 = this.resize()).length;
                BytecodeManager.incBytecodes(4);
            }
            final int n3;
            final Node<K, V> node2;
            final Node<K, V> node = node2 = array2[n3 = (n2 - 1 & hash)];
            BytecodeManager.incBytecodes(12);
            if (node != null) {
                final boolean b = node2 instanceof TreeNode;
                BytecodeManager.incBytecodes(3);
                if (b) {
                    final TreeNode<K, Object> treeNode3 = treeNode = (TreeNode<K, Object>)node2;
                    final int n4 = hash;
                    BytecodeManager.incBytecodes(7);
                    treeNode2 = treeNode3.getTreeNode(n4, k);
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    Node<K, V> next = node2;
                    BytecodeManager.incBytecodes(2);
                    Node<K, V> node3;
                    do {
                        final int hash2 = next.hash;
                        final int n5 = hash;
                        BytecodeManager.incBytecodes(4);
                        Label_0286: {
                            if (hash2 == n5) {
                                final K key = next.key;
                                BytecodeManager.incBytecodes(6);
                                if (key != k) {
                                    BytecodeManager.incBytecodes(2);
                                    if (k == null) {
                                        break Label_0286;
                                    }
                                    final K obj = key;
                                    BytecodeManager.incBytecodes(2);
                                    BytecodeManager.incBytecodes(1);
                                    final boolean equals = k.equals(obj);
                                    BytecodeManager.incBytecodes(1);
                                    if (!equals) {
                                        break Label_0286;
                                    }
                                }
                                treeNode2 = next;
                                BytecodeManager.incBytecodes(2);
                                BytecodeManager.incBytecodes(1);
                                break;
                            }
                        }
                        ++n;
                        BytecodeManager.incBytecodes(1);
                        node3 = (next = next.next);
                        BytecodeManager.incBytecodes(5);
                    } while (node3 != null);
                }
            }
            final Object o = treeNode2;
            BytecodeManager.incBytecodes(2);
            Object value;
            if (o == null) {
                value = null;
                BytecodeManager.incBytecodes(2);
            }
            else {
                value = ((Node)treeNode2).value;
                BytecodeManager.incBytecodes(2);
            }
            final Object o2 = value;
            BytecodeManager.incBytecodes(1);
            final Object o3 = o2;
            BytecodeManager.incBytecodes(4);
            final V apply = (V)biFunction.apply(k, (Object)o3);
            BytecodeManager.incBytecodes(1);
            final Node node4 = (Node)treeNode2;
            BytecodeManager.incBytecodes(2);
            if (node4 != null) {
                final V v = apply;
                BytecodeManager.incBytecodes(2);
                if (v != null) {
                    ((Node)treeNode2).value = (V)apply;
                    BytecodeManager.incBytecodes(3);
                    final Node node5 = (Node)treeNode2;
                    BytecodeManager.incBytecodes(3);
                    this.afterNodeAccess(node5);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    final int n6 = hash;
                    final Object o4 = null;
                    final boolean b2 = false;
                    final boolean b3 = true;
                    BytecodeManager.incBytecodes(7);
                    this.removeNode(n6, k, o4, b2, b3);
                    BytecodeManager.incBytecodes(2);
                }
            }
            else {
                final V v2 = apply;
                BytecodeManager.incBytecodes(2);
                if (v2 != null) {
                    final TreeNode<K, Object> treeNode4 = treeNode;
                    BytecodeManager.incBytecodes(2);
                    if (treeNode4 != null) {
                        final TreeNode<K, Object> treeNode5 = treeNode;
                        final Node<K, Object>[] array3 = (Node<K, Object>[])array2;
                        final int n7 = hash;
                        final V v3 = apply;
                        BytecodeManager.incBytecodes(7);
                        treeNode5.putTreeVal((HashMap<K, Object>)this, array3, n7, k, v3);
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        final Node<K, Object>[] array4 = (Node<K, Object>[])array2;
                        final int n8 = n3;
                        final int n9 = hash;
                        final V v4 = apply;
                        final Node<K, Object> node6 = (Node<K, Object>)node2;
                        BytecodeManager.incBytecodes(8);
                        array4[n8] = this.newNode(n9, k, v4, node6);
                        BytecodeManager.incBytecodes(1);
                        final int n10 = n;
                        final int n11 = 7;
                        BytecodeManager.incBytecodes(3);
                        if (n10 >= n11) {
                            final Node<K, V>[] array5 = array2;
                            final int n12 = hash;
                            BytecodeManager.incBytecodes(4);
                            this.treeifyBin(array5, n12);
                        }
                    }
                    ++this.modCount;
                    BytecodeManager.incBytecodes(6);
                    ++this.size;
                    BytecodeManager.incBytecodes(6);
                    final boolean b4 = true;
                    BytecodeManager.incBytecodes(3);
                    this.afterNodeInsertion(b4);
                }
            }
            final V v5 = apply;
            BytecodeManager.incBytecodes(2);
            return v5;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public V merge(final K k, final V v, final BiFunction<? super V, ? super V, ? extends V> biFunction) {
        try {
            BytecodeManager.incBytecodes(2);
            if (v == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(2);
            if (biFunction == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex2 = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex2;
            }
            BytecodeManager.incBytecodes(2);
            final int hash = hash(k);
            BytecodeManager.incBytecodes(1);
            int n = 0;
            BytecodeManager.incBytecodes(2);
            TreeNode<K, V> treeNode = null;
            BytecodeManager.incBytecodes(2);
            Node<K, V> treeNode2 = null;
            BytecodeManager.incBytecodes(2);
            final int size = this.size;
            final int threshold = this.threshold;
            BytecodeManager.incBytecodes(5);
            Node<K, V>[] array2 = null;
            int n2 = 0;
            Label_0159: {
                if (size <= threshold) {
                    final Node<K, V>[] array = array2 = this.table;
                    BytecodeManager.incBytecodes(5);
                    if (array != null) {
                        n2 = array2.length;
                        BytecodeManager.incBytecodes(5);
                        if (n2 != 0) {
                            break Label_0159;
                        }
                    }
                }
                BytecodeManager.incBytecodes(2);
                n2 = (array2 = this.resize()).length;
                BytecodeManager.incBytecodes(4);
            }
            final int n3;
            final Node<K, V> node2;
            final Node<K, V> node = node2 = array2[n3 = (n2 - 1 & hash)];
            BytecodeManager.incBytecodes(12);
            if (node != null) {
                final boolean b = node2 instanceof TreeNode;
                BytecodeManager.incBytecodes(3);
                if (b) {
                    final TreeNode<K, V> treeNode3 = treeNode = (TreeNode<K, V>)node2;
                    final int n4 = hash;
                    BytecodeManager.incBytecodes(7);
                    treeNode2 = treeNode3.getTreeNode(n4, k);
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    TreeNode<K, V> next = (TreeNode<K, V>)node2;
                    BytecodeManager.incBytecodes(2);
                    Node<K, V> node3;
                    do {
                        final int hash2 = next.hash;
                        final int n5 = hash;
                        BytecodeManager.incBytecodes(4);
                        Label_0317: {
                            if (hash2 == n5) {
                                final K key = next.key;
                                BytecodeManager.incBytecodes(6);
                                if (key != k) {
                                    BytecodeManager.incBytecodes(2);
                                    if (k == null) {
                                        break Label_0317;
                                    }
                                    final K obj = key;
                                    BytecodeManager.incBytecodes(2);
                                    BytecodeManager.incBytecodes(1);
                                    final boolean equals = k.equals(obj);
                                    BytecodeManager.incBytecodes(1);
                                    if (!equals) {
                                        break Label_0317;
                                    }
                                }
                                treeNode2 = next;
                                BytecodeManager.incBytecodes(2);
                                BytecodeManager.incBytecodes(1);
                                break;
                            }
                        }
                        ++n;
                        BytecodeManager.incBytecodes(1);
                        node3 = (next = (TreeNode<K, V>)next.next);
                        BytecodeManager.incBytecodes(5);
                    } while (node3 != null);
                }
            }
            final Node<K, V> node4 = treeNode2;
            BytecodeManager.incBytecodes(2);
            if (node4 != null) {
                final V value = treeNode2.value;
                BytecodeManager.incBytecodes(3);
                V apply;
                if (value != null) {
                    final V value2 = treeNode2.value;
                    BytecodeManager.incBytecodes(5);
                    apply = (V)biFunction.apply(value2, v);
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    apply = v;
                    BytecodeManager.incBytecodes(2);
                }
                final V v2 = apply;
                BytecodeManager.incBytecodes(2);
                if (v2 != null) {
                    treeNode2.value = apply;
                    BytecodeManager.incBytecodes(3);
                    final Node<K, V> node5 = treeNode2;
                    BytecodeManager.incBytecodes(3);
                    this.afterNodeAccess(node5);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    final int n6 = hash;
                    final Object o = null;
                    final boolean b2 = false;
                    final boolean b3 = true;
                    BytecodeManager.incBytecodes(7);
                    this.removeNode(n6, k, o, b2, b3);
                    BytecodeManager.incBytecodes(1);
                }
                final V v3 = apply;
                BytecodeManager.incBytecodes(2);
                return v3;
            }
            BytecodeManager.incBytecodes(2);
            if (v != null) {
                final TreeNode<K, V> treeNode4 = treeNode;
                BytecodeManager.incBytecodes(2);
                if (treeNode4 != null) {
                    final TreeNode<K, V> treeNode5 = treeNode;
                    final Node<K, V>[] array3 = array2;
                    final int n7 = hash;
                    BytecodeManager.incBytecodes(7);
                    treeNode5.putTreeVal(this, array3, n7, k, v);
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final Node<K, V>[] array4 = array2;
                    final int n8 = n3;
                    final int n9 = hash;
                    final TreeNode<K, V> treeNode6 = (TreeNode<K, V>)node2;
                    BytecodeManager.incBytecodes(8);
                    array4[n8] = this.newNode(n9, k, v, treeNode6);
                    BytecodeManager.incBytecodes(1);
                    final int n10 = n;
                    final int n11 = 7;
                    BytecodeManager.incBytecodes(3);
                    if (n10 >= n11) {
                        final Node<K, V>[] array5 = array2;
                        final int n12 = hash;
                        BytecodeManager.incBytecodes(4);
                        this.treeifyBin(array5, n12);
                    }
                }
                ++this.modCount;
                BytecodeManager.incBytecodes(6);
                ++this.size;
                BytecodeManager.incBytecodes(6);
                final boolean b4 = true;
                BytecodeManager.incBytecodes(3);
                this.afterNodeInsertion(b4);
            }
            BytecodeManager.incBytecodes(2);
            return v;
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
            final int size = this.size;
            BytecodeManager.incBytecodes(3);
            if (size > 0) {
                final Node<K, V>[] table;
                final Node<K, V>[] array = table = this.table;
                BytecodeManager.incBytecodes(5);
                if (array != null) {
                    final int modCount = this.modCount;
                    BytecodeManager.incBytecodes(3);
                    int n = 0;
                    BytecodeManager.incBytecodes(2);
                    while (true) {
                        final int n2 = n;
                        final int length = table.length;
                        BytecodeManager.incBytecodes(4);
                        if (n2 >= length) {
                            break;
                        }
                        Node<K, V> next = table[n];
                        BytecodeManager.incBytecodes(4);
                        while (true) {
                            final Node<K, V> node = next;
                            BytecodeManager.incBytecodes(2);
                            if (node == null) {
                                break;
                            }
                            final K key = next.key;
                            final V value = next.value;
                            BytecodeManager.incBytecodes(6);
                            biConsumer.accept(key, value);
                            next = next.next;
                            BytecodeManager.incBytecodes(4);
                        }
                        ++n;
                        BytecodeManager.incBytecodes(2);
                    }
                    final int modCount2 = this.modCount;
                    final int n3 = modCount;
                    BytecodeManager.incBytecodes(4);
                    if (modCount2 != n3) {
                        BytecodeManager.incBytecodes(3);
                        final ConcurrentModificationException ex2 = new ConcurrentModificationException();
                        BytecodeManager.incBytecodes(1);
                        throw ex2;
                    }
                }
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
            final int size = this.size;
            BytecodeManager.incBytecodes(3);
            if (size > 0) {
                final Node<K, V>[] table;
                final Node<K, V>[] array = table = this.table;
                BytecodeManager.incBytecodes(5);
                if (array != null) {
                    final int modCount = this.modCount;
                    BytecodeManager.incBytecodes(3);
                    int n = 0;
                    BytecodeManager.incBytecodes(2);
                    while (true) {
                        final int n2 = n;
                        final int length = table.length;
                        BytecodeManager.incBytecodes(4);
                        if (n2 >= length) {
                            break;
                        }
                        Node<K, V> next = table[n];
                        BytecodeManager.incBytecodes(4);
                        while (true) {
                            final Node<K, V> node = next;
                            BytecodeManager.incBytecodes(2);
                            if (node == null) {
                                break;
                            }
                            final Node<K, V> node2 = next;
                            final K key = next.key;
                            final V value = next.value;
                            BytecodeManager.incBytecodes(7);
                            node2.value = (V)biFunction.apply(key, value);
                            BytecodeManager.incBytecodes(1);
                            next = next.next;
                            BytecodeManager.incBytecodes(4);
                        }
                        ++n;
                        BytecodeManager.incBytecodes(2);
                    }
                    final int modCount2 = this.modCount;
                    final int n3 = modCount;
                    BytecodeManager.incBytecodes(4);
                    if (modCount2 != n3) {
                        BytecodeManager.incBytecodes(3);
                        final ConcurrentModificationException ex2 = new ConcurrentModificationException();
                        BytecodeManager.incBytecodes(1);
                        throw ex2;
                    }
                }
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Object clone() {
        try {
            try {
                HashMap hashMap;
                try {
                    BytecodeManager.incBytecodes(2);
                    hashMap = (HashMap)super.clone();
                    BytecodeManager.incBytecodes(2);
                    BytecodeManager.incBytecodes(1);
                }
                catch (CloneNotSupportedException ex) {
                    BytecodeManager.incBytecodes(501);
                    final CloneNotSupportedException cause = ex;
                    BytecodeManager.incBytecodes(4);
                    final InternalError internalError = new InternalError(cause);
                    BytecodeManager.incBytecodes(1);
                    throw internalError;
                }
                final HashMap hashMap2 = hashMap;
                BytecodeManager.incBytecodes(2);
                hashMap2.reinitialize();
                final HashMap hashMap3 = hashMap;
                final boolean b = false;
                BytecodeManager.incBytecodes(4);
                hashMap3.putMapEntries(this, b);
                final HashMap hashMap4 = hashMap;
                BytecodeManager.incBytecodes(2);
                return hashMap4;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        catch (VirtualMachineError virtualMachineError) {
            throw virtualMachineError;
        }
    }
    
    final float loadFactor() {
        try {
            final float loadFactor = this.loadFactor;
            BytecodeManager.incBytecodes(3);
            return loadFactor;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final int capacity() {
        try {
            final Node<K, V>[] table = this.table;
            BytecodeManager.incBytecodes(3);
            int n;
            if (table != null) {
                n = this.table.length;
                BytecodeManager.incBytecodes(4);
            }
            else {
                final int threshold = this.threshold;
                BytecodeManager.incBytecodes(3);
                if (threshold > 0) {
                    n = this.threshold;
                    BytecodeManager.incBytecodes(3);
                }
                else {
                    n = 16;
                    BytecodeManager.incBytecodes(1);
                }
            }
            BytecodeManager.incBytecodes(1);
            return n;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) throws IOException {
        try {
            BytecodeManager.incBytecodes(2);
            final int capacity = this.capacity();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            objectOutputStream.defaultWriteObject();
            final int val = capacity;
            BytecodeManager.incBytecodes(3);
            objectOutputStream.writeInt(val);
            final int size = this.size;
            BytecodeManager.incBytecodes(4);
            objectOutputStream.writeInt(size);
            BytecodeManager.incBytecodes(3);
            this.internalWriteEntries(objectOutputStream);
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
            this.reinitialize();
            final float n = fcmpg(this.loadFactor, 0.0f);
            BytecodeManager.incBytecodes(5);
            if (n > 0) {
                final float loadFactor = this.loadFactor;
                BytecodeManager.incBytecodes(3);
                final boolean naN = Float.isNaN(loadFactor);
                BytecodeManager.incBytecodes(1);
                if (!naN) {
                    BytecodeManager.incBytecodes(2);
                    objectInputStream.readInt();
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(2);
                    final int int1 = objectInputStream.readInt();
                    BytecodeManager.incBytecodes(1);
                    final int n2 = int1;
                    BytecodeManager.incBytecodes(2);
                    if (n2 < 0) {
                        BytecodeManager.incBytecodes(5);
                        final StringBuilder sb = new StringBuilder();
                        final String str = "Illegal mappings count: ";
                        BytecodeManager.incBytecodes(2);
                        final StringBuilder append = sb.append(str);
                        final int i = int1;
                        BytecodeManager.incBytecodes(2);
                        final StringBuilder append2 = append.append(i);
                        BytecodeManager.incBytecodes(1);
                        final String string = append2.toString();
                        BytecodeManager.incBytecodes(1);
                        final InvalidObjectException ex = new InvalidObjectException(string);
                        BytecodeManager.incBytecodes(1);
                        throw ex;
                    }
                    final int n3 = int1;
                    BytecodeManager.incBytecodes(2);
                    if (n3 > 0) {
                        final float a = 0.25f;
                        final float loadFactor2 = this.loadFactor;
                        BytecodeManager.incBytecodes(4);
                        final float max = Math.max(a, loadFactor2);
                        final float b = 4.0f;
                        BytecodeManager.incBytecodes(2);
                        final float min = Math.min(max, b);
                        BytecodeManager.incBytecodes(1);
                        final float n4 = int1 / min + 1.0f;
                        BytecodeManager.incBytecodes(7);
                        final float n5 = fcmpg(n4, 16.0f);
                        BytecodeManager.incBytecodes(4);
                        int tableSize;
                        if (n5 < 0) {
                            tableSize = 16;
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            final float n6 = fcmpl(n4, 1.07374182E9f);
                            BytecodeManager.incBytecodes(4);
                            if (n6 >= 0) {
                                tableSize = 1073741824;
                                BytecodeManager.incBytecodes(2);
                            }
                            else {
                                final int n7 = (int)n4;
                                BytecodeManager.incBytecodes(2);
                                BytecodeManager.incBytecodes(1);
                                tableSize = tableSizeFor(n7);
                            }
                        }
                        final int n8 = tableSize;
                        BytecodeManager.incBytecodes(1);
                        final float n9 = n8 * min;
                        BytecodeManager.incBytecodes(5);
                        final int n10 = n8;
                        final int n11 = 1073741824;
                        BytecodeManager.incBytecodes(4);
                        int threshold = 0;
                        Label_0390: {
                            if (n10 < n11) {
                                final float n12 = fcmpg(n9, 1.07374182E9f);
                                BytecodeManager.incBytecodes(4);
                                if (n12 < 0) {
                                    threshold = (int)n9;
                                    BytecodeManager.incBytecodes(3);
                                    break Label_0390;
                                }
                            }
                            threshold = Integer.MAX_VALUE;
                            BytecodeManager.incBytecodes(1);
                        }
                        this.threshold = threshold;
                        BytecodeManager.incBytecodes(1);
                        final Node[] table = new Node[n8];
                        BytecodeManager.incBytecodes(3);
                        this.table = (Node<K, V>[])table;
                        BytecodeManager.incBytecodes(3);
                        int n13 = 0;
                        BytecodeManager.incBytecodes(2);
                        while (true) {
                            final int n14 = n13;
                            final int n15 = int1;
                            BytecodeManager.incBytecodes(3);
                            if (n14 >= n15) {
                                break;
                            }
                            BytecodeManager.incBytecodes(2);
                            final Object object = objectInputStream.readObject();
                            BytecodeManager.incBytecodes(1);
                            BytecodeManager.incBytecodes(2);
                            final Object object2 = objectInputStream.readObject();
                            BytecodeManager.incBytecodes(1);
                            final Object o = object;
                            BytecodeManager.incBytecodes(3);
                            final int hash = hash(o);
                            final Object o2 = object;
                            final Object o3 = object2;
                            final boolean b2 = false;
                            final boolean b3 = false;
                            BytecodeManager.incBytecodes(5);
                            this.putVal(hash, (K)o2, (V)o3, b2, b3);
                            BytecodeManager.incBytecodes(1);
                            ++n13;
                            BytecodeManager.incBytecodes(2);
                        }
                    }
                    BytecodeManager.incBytecodes(1);
                    return;
                }
            }
            BytecodeManager.incBytecodes(5);
            final StringBuilder sb2 = new StringBuilder();
            final String str2 = "Illegal load factor: ";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append3 = sb2.append(str2);
            final float loadFactor3 = this.loadFactor;
            BytecodeManager.incBytecodes(3);
            final StringBuilder append4 = append3.append(loadFactor3);
            BytecodeManager.incBytecodes(1);
            final String string2 = append4.toString();
            BytecodeManager.incBytecodes(1);
            final InvalidObjectException ex2 = new InvalidObjectException(string2);
            BytecodeManager.incBytecodes(1);
            throw ex2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    Node<K, V> newNode(final int n, final K k, final V v, final Node<K, V> node) {
        try {
            BytecodeManager.incBytecodes(7);
            final Node<K, V> node2 = new Node<K, V>(n, k, v, node);
            BytecodeManager.incBytecodes(1);
            return node2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    Node<K, V> replacementNode(final Node<K, V> node, final Node<K, V> node2) {
        try {
            final int hash = node.hash;
            final K key = node.key;
            final V value = node.value;
            BytecodeManager.incBytecodes(10);
            final Node node3 = new Node<K, V>(hash, key, value, node2);
            BytecodeManager.incBytecodes(1);
            return (Node<K, V>)node3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    TreeNode<K, V> newTreeNode(final int n, final K k, final V v, final Node<K, V> node) {
        try {
            BytecodeManager.incBytecodes(7);
            final TreeNode<K, V> treeNode = new TreeNode<K, V>(n, k, v, node);
            BytecodeManager.incBytecodes(1);
            return treeNode;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    TreeNode<K, V> replacementTreeNode(final Node<K, V> node, final Node<K, V> node2) {
        try {
            final int hash = node.hash;
            final K key = node.key;
            final V value = node.value;
            BytecodeManager.incBytecodes(10);
            final TreeNode treeNode = new TreeNode<K, V>(hash, key, value, node2);
            BytecodeManager.incBytecodes(1);
            return (TreeNode<K, V>)treeNode;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    void reinitialize() {
        try {
            this.table = null;
            BytecodeManager.incBytecodes(3);
            this.entrySet = null;
            BytecodeManager.incBytecodes(3);
            this.keySet = null;
            BytecodeManager.incBytecodes(3);
            this.values = null;
            BytecodeManager.incBytecodes(3);
            this.modCount = 0;
            BytecodeManager.incBytecodes(3);
            this.threshold = 0;
            BytecodeManager.incBytecodes(3);
            this.size = 0;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    void afterNodeAccess(final Node<K, V> node) {
        try {
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    void afterNodeInsertion(final boolean b) {
        try {
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    void afterNodeRemoval(final Node<K, V> node) {
        try {
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    void internalWriteEntries(final ObjectOutputStream objectOutputStream) throws IOException {
        try {
            final int size = this.size;
            BytecodeManager.incBytecodes(3);
            if (size > 0) {
                final Node<K, V>[] table;
                final Node<K, V>[] array = table = this.table;
                BytecodeManager.incBytecodes(5);
                if (array != null) {
                    int n = 0;
                    BytecodeManager.incBytecodes(2);
                    while (true) {
                        final int n2 = n;
                        final int length = table.length;
                        BytecodeManager.incBytecodes(4);
                        if (n2 >= length) {
                            break;
                        }
                        Node<K, V> next = table[n];
                        BytecodeManager.incBytecodes(4);
                        while (true) {
                            final Node<K, V> node = next;
                            BytecodeManager.incBytecodes(2);
                            if (node == null) {
                                break;
                            }
                            final K key = next.key;
                            BytecodeManager.incBytecodes(4);
                            objectOutputStream.writeObject(key);
                            final V value = next.value;
                            BytecodeManager.incBytecodes(4);
                            objectOutputStream.writeObject(value);
                            next = next.next;
                            BytecodeManager.incBytecodes(4);
                        }
                        ++n;
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
    
    static class Node<K, V> implements Entry<K, V>
    {
        final int hash;
        final K key;
        V value;
        Node<K, V> next;
        
        Node(final int hash, final K key, final V value, final Node<K, V> next) {
            try {
                BytecodeManager.incBytecodes(2);
                this.hash = hash;
                BytecodeManager.incBytecodes(3);
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
        
        @Override
        public final K getKey() {
            try {
                final K key = this.key;
                BytecodeManager.incBytecodes(3);
                return key;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final V getValue() {
            try {
                final V value = this.value;
                BytecodeManager.incBytecodes(3);
                return value;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final String toString() {
            try {
                BytecodeManager.incBytecodes(3);
                final StringBuilder sb = new StringBuilder();
                final K key = this.key;
                BytecodeManager.incBytecodes(3);
                final StringBuilder append = sb.append(key);
                final String str = "=";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append2 = append.append(str);
                final V value = this.value;
                BytecodeManager.incBytecodes(3);
                final StringBuilder append3 = append2.append(value);
                BytecodeManager.incBytecodes(1);
                final String string = append3.toString();
                BytecodeManager.incBytecodes(1);
                return string;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final int hashCode() {
            try {
                final K key = this.key;
                BytecodeManager.incBytecodes(3);
                final int hashCode = Objects.hashCode(key);
                final V value = this.value;
                BytecodeManager.incBytecodes(3);
                final int n = hashCode ^ Objects.hashCode(value);
                BytecodeManager.incBytecodes(2);
                return n;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final V setValue(final V value) {
            try {
                final V value2 = this.value;
                BytecodeManager.incBytecodes(3);
                this.value = value;
                BytecodeManager.incBytecodes(3);
                final V v = value2;
                BytecodeManager.incBytecodes(2);
                return v;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final boolean equals(final Object o) {
            try {
                BytecodeManager.incBytecodes(3);
                if (o == this) {
                    final boolean b = true;
                    BytecodeManager.incBytecodes(2);
                    return b;
                }
                final boolean b2 = o instanceof Entry;
                BytecodeManager.incBytecodes(3);
                if (b2) {
                    final Entry entry = (Entry)o;
                    BytecodeManager.incBytecodes(3);
                    final K key = this.key;
                    final Entry entry2 = entry;
                    BytecodeManager.incBytecodes(4);
                    final Object key2 = entry2.getKey();
                    BytecodeManager.incBytecodes(1);
                    final boolean equals = Objects.equals(key, key2);
                    BytecodeManager.incBytecodes(1);
                    if (equals) {
                        final V value = this.value;
                        final Entry entry3 = entry;
                        BytecodeManager.incBytecodes(3);
                        BytecodeManager.incBytecodes(1);
                        final Object value2 = entry3.getValue();
                        BytecodeManager.incBytecodes(1);
                        final boolean equals2 = Objects.equals(value, value2);
                        BytecodeManager.incBytecodes(1);
                        if (equals2) {
                            final boolean b3 = true;
                            BytecodeManager.incBytecodes(2);
                            return b3;
                        }
                    }
                }
                final boolean b4 = false;
                BytecodeManager.incBytecodes(2);
                return b4;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    final class KeySet extends AbstractSet<K>
    {
        KeySet() {
            try {
                BytecodeManager.incBytecodes(5);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final int size() {
            try {
                final int size = HashMap.this.size;
                BytecodeManager.incBytecodes(4);
                return size;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final void clear() {
            try {
                final HashMap this$0 = HashMap.this;
                BytecodeManager.incBytecodes(3);
                this$0.clear();
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final Iterator<K> iterator() {
            try {
                final HashMap this$0 = HashMap.this;
                BytecodeManager.incBytecodes(5);
                final KeyIterator keyIterator = this$0.new KeyIterator();
                BytecodeManager.incBytecodes(1);
                return keyIterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final boolean contains(final Object o) {
            try {
                final HashMap this$0 = HashMap.this;
                BytecodeManager.incBytecodes(4);
                final boolean containsKey = this$0.containsKey(o);
                BytecodeManager.incBytecodes(1);
                return containsKey;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final boolean remove(final Object o) {
            try {
                final HashMap this$0 = HashMap.this;
                BytecodeManager.incBytecodes(4);
                final int hash = HashMap.hash(o);
                final Object o2 = null;
                final boolean b = false;
                final boolean b2 = true;
                BytecodeManager.incBytecodes(5);
                final Node<K, V> removeNode = this$0.removeNode(hash, o, o2, b, b2);
                BytecodeManager.incBytecodes(1);
                boolean b3;
                if (removeNode != null) {
                    b3 = true;
                    BytecodeManager.incBytecodes(2);
                }
                else {
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
        public final Spliterator<K> spliterator() {
            try {
                final HashMap this$0 = HashMap.this;
                final int n = 0;
                final int n2 = -1;
                final int n3 = 0;
                final int n4 = 0;
                BytecodeManager.incBytecodes(9);
                final KeySpliterator keySpliterator = new KeySpliterator<K, Object>(this$0, n, n2, n3, n4);
                BytecodeManager.incBytecodes(1);
                return (Spliterator<K>)keySpliterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public final void forEach(final Consumer<? super K> consumer) {
            try {
                BytecodeManager.incBytecodes(2);
                if (consumer == null) {
                    BytecodeManager.incBytecodes(3);
                    final NullPointerException ex = new NullPointerException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final int size = HashMap.this.size;
                BytecodeManager.incBytecodes(4);
                if (size > 0) {
                    final Node<K, V>[] table;
                    final Node<K, V>[] array = table = HashMap.this.table;
                    BytecodeManager.incBytecodes(6);
                    if (array != null) {
                        final int modCount = HashMap.this.modCount;
                        BytecodeManager.incBytecodes(4);
                        int n = 0;
                        BytecodeManager.incBytecodes(2);
                        while (true) {
                            final int n2 = n;
                            final int length = table.length;
                            BytecodeManager.incBytecodes(4);
                            if (n2 >= length) {
                                break;
                            }
                            Node<K, V> next = table[n];
                            BytecodeManager.incBytecodes(4);
                            while (true) {
                                final Node<K, V> node = next;
                                BytecodeManager.incBytecodes(2);
                                if (node == null) {
                                    break;
                                }
                                final K key = next.key;
                                BytecodeManager.incBytecodes(4);
                                consumer.accept(key);
                                next = next.next;
                                BytecodeManager.incBytecodes(4);
                            }
                            ++n;
                            BytecodeManager.incBytecodes(2);
                        }
                        final int modCount2 = HashMap.this.modCount;
                        final int n3 = modCount;
                        BytecodeManager.incBytecodes(5);
                        if (modCount2 != n3) {
                            BytecodeManager.incBytecodes(3);
                            final ConcurrentModificationException ex2 = new ConcurrentModificationException();
                            BytecodeManager.incBytecodes(1);
                            throw ex2;
                        }
                    }
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    final class Values extends AbstractCollection<V>
    {
        Values() {
            try {
                BytecodeManager.incBytecodes(5);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final int size() {
            try {
                final int size = HashMap.this.size;
                BytecodeManager.incBytecodes(4);
                return size;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final void clear() {
            try {
                final HashMap this$0 = HashMap.this;
                BytecodeManager.incBytecodes(3);
                this$0.clear();
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final Iterator<V> iterator() {
            try {
                final HashMap this$0 = HashMap.this;
                BytecodeManager.incBytecodes(5);
                final ValueIterator valueIterator = this$0.new ValueIterator();
                BytecodeManager.incBytecodes(1);
                return valueIterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final boolean contains(final Object o) {
            try {
                final HashMap this$0 = HashMap.this;
                BytecodeManager.incBytecodes(4);
                final boolean containsValue = this$0.containsValue(o);
                BytecodeManager.incBytecodes(1);
                return containsValue;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final Spliterator<V> spliterator() {
            try {
                final HashMap this$0 = HashMap.this;
                final int n = 0;
                final int n2 = -1;
                final int n3 = 0;
                final int n4 = 0;
                BytecodeManager.incBytecodes(9);
                final ValueSpliterator valueSpliterator = new ValueSpliterator<Object, V>(this$0, n, n2, n3, n4);
                BytecodeManager.incBytecodes(1);
                return (Spliterator<V>)valueSpliterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public final void forEach(final Consumer<? super V> consumer) {
            try {
                BytecodeManager.incBytecodes(2);
                if (consumer == null) {
                    BytecodeManager.incBytecodes(3);
                    final NullPointerException ex = new NullPointerException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final int size = HashMap.this.size;
                BytecodeManager.incBytecodes(4);
                if (size > 0) {
                    final Node<K, V>[] table;
                    final Node<K, V>[] array = table = HashMap.this.table;
                    BytecodeManager.incBytecodes(6);
                    if (array != null) {
                        final int modCount = HashMap.this.modCount;
                        BytecodeManager.incBytecodes(4);
                        int n = 0;
                        BytecodeManager.incBytecodes(2);
                        while (true) {
                            final int n2 = n;
                            final int length = table.length;
                            BytecodeManager.incBytecodes(4);
                            if (n2 >= length) {
                                break;
                            }
                            Node<K, V> next = table[n];
                            BytecodeManager.incBytecodes(4);
                            while (true) {
                                final Node<K, V> node = next;
                                BytecodeManager.incBytecodes(2);
                                if (node == null) {
                                    break;
                                }
                                final V value = next.value;
                                BytecodeManager.incBytecodes(4);
                                consumer.accept(value);
                                next = next.next;
                                BytecodeManager.incBytecodes(4);
                            }
                            ++n;
                            BytecodeManager.incBytecodes(2);
                        }
                        final int modCount2 = HashMap.this.modCount;
                        final int n3 = modCount;
                        BytecodeManager.incBytecodes(5);
                        if (modCount2 != n3) {
                            BytecodeManager.incBytecodes(3);
                            final ConcurrentModificationException ex2 = new ConcurrentModificationException();
                            BytecodeManager.incBytecodes(1);
                            throw ex2;
                        }
                    }
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    final class EntrySet extends AbstractSet<Entry<K, V>>
    {
        EntrySet() {
            try {
                BytecodeManager.incBytecodes(5);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final int size() {
            try {
                final int size = HashMap.this.size;
                BytecodeManager.incBytecodes(4);
                return size;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final void clear() {
            try {
                final HashMap this$0 = HashMap.this;
                BytecodeManager.incBytecodes(3);
                this$0.clear();
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final Iterator<Entry<K, V>> iterator() {
            try {
                final HashMap this$0 = HashMap.this;
                BytecodeManager.incBytecodes(5);
                final EntryIterator entryIterator = this$0.new EntryIterator();
                BytecodeManager.incBytecodes(1);
                return entryIterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final boolean contains(final Object o) {
            try {
                final boolean b = o instanceof Entry;
                BytecodeManager.incBytecodes(3);
                if (!b) {
                    final boolean b2 = false;
                    BytecodeManager.incBytecodes(2);
                    return b2;
                }
                final Entry entry = (Entry)o;
                BytecodeManager.incBytecodes(3);
                final Entry entry2 = entry;
                BytecodeManager.incBytecodes(2);
                final Object key = entry2.getKey();
                BytecodeManager.incBytecodes(1);
                final HashMap this$0 = HashMap.this;
                final Object o2 = key;
                BytecodeManager.incBytecodes(4);
                final int hash = HashMap.hash(o2);
                final Object o3 = key;
                BytecodeManager.incBytecodes(2);
                final Node<K, V> node = this$0.getNode(hash, o3);
                BytecodeManager.incBytecodes(1);
                final Node<K, V> node2 = node;
                BytecodeManager.incBytecodes(2);
                boolean b3 = false;
                Label_0119: {
                    if (node2 != null) {
                        final Node<K, V> node3 = node;
                        final Entry entry3 = entry;
                        BytecodeManager.incBytecodes(3);
                        final boolean equals = node3.equals(entry3);
                        BytecodeManager.incBytecodes(1);
                        if (equals) {
                            b3 = true;
                            BytecodeManager.incBytecodes(2);
                            break Label_0119;
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
        public final boolean remove(final Object o) {
            try {
                final boolean b = o instanceof Entry;
                BytecodeManager.incBytecodes(3);
                if (b) {
                    final Entry entry = (Entry)o;
                    BytecodeManager.incBytecodes(3);
                    final Entry entry2 = entry;
                    BytecodeManager.incBytecodes(2);
                    final Object key = entry2.getKey();
                    BytecodeManager.incBytecodes(1);
                    final Entry entry3 = entry;
                    BytecodeManager.incBytecodes(2);
                    final Object value = entry3.getValue();
                    BytecodeManager.incBytecodes(1);
                    final HashMap this$0 = HashMap.this;
                    final Object o2 = key;
                    BytecodeManager.incBytecodes(4);
                    final int hash = HashMap.hash(o2);
                    final Object o3 = key;
                    final Object o4 = value;
                    final boolean b2 = true;
                    final boolean b3 = true;
                    BytecodeManager.incBytecodes(5);
                    final Node<K, V> removeNode = this$0.removeNode(hash, o3, o4, b2, b3);
                    BytecodeManager.incBytecodes(1);
                    boolean b4;
                    if (removeNode != null) {
                        b4 = true;
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        b4 = false;
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(1);
                    return b4;
                }
                final boolean b5 = false;
                BytecodeManager.incBytecodes(2);
                return b5;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final Spliterator<Entry<K, V>> spliterator() {
            try {
                final HashMap this$0 = HashMap.this;
                final int n = 0;
                final int n2 = -1;
                final int n3 = 0;
                final int n4 = 0;
                BytecodeManager.incBytecodes(9);
                final EntrySpliterator entrySpliterator = new EntrySpliterator<K, V>(this$0, n, n2, n3, n4);
                BytecodeManager.incBytecodes(1);
                return (Spliterator<Entry<K, V>>)entrySpliterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public final void forEach(final Consumer<? super Entry<K, V>> consumer) {
            try {
                BytecodeManager.incBytecodes(2);
                if (consumer == null) {
                    BytecodeManager.incBytecodes(3);
                    final NullPointerException ex = new NullPointerException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final int size = HashMap.this.size;
                BytecodeManager.incBytecodes(4);
                if (size > 0) {
                    final Node<K, V>[] table;
                    final Node<K, V>[] array = table = HashMap.this.table;
                    BytecodeManager.incBytecodes(6);
                    if (array != null) {
                        final int modCount = HashMap.this.modCount;
                        BytecodeManager.incBytecodes(4);
                        int n = 0;
                        BytecodeManager.incBytecodes(2);
                        while (true) {
                            final int n2 = n;
                            final int length = table.length;
                            BytecodeManager.incBytecodes(4);
                            if (n2 >= length) {
                                break;
                            }
                            Node<K, V> next = table[n];
                            BytecodeManager.incBytecodes(4);
                            while (true) {
                                final Node<K, V> node = next;
                                BytecodeManager.incBytecodes(2);
                                if (node == null) {
                                    break;
                                }
                                final Node<K, V> node2 = next;
                                BytecodeManager.incBytecodes(3);
                                consumer.accept(node2);
                                next = next.next;
                                BytecodeManager.incBytecodes(4);
                            }
                            ++n;
                            BytecodeManager.incBytecodes(2);
                        }
                        final int modCount2 = HashMap.this.modCount;
                        final int n3 = modCount;
                        BytecodeManager.incBytecodes(5);
                        if (modCount2 != n3) {
                            BytecodeManager.incBytecodes(3);
                            final ConcurrentModificationException ex2 = new ConcurrentModificationException();
                            BytecodeManager.incBytecodes(1);
                            throw ex2;
                        }
                    }
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    abstract class HashIterator
    {
        Node<K, V> next;
        Node<K, V> current;
        int expectedModCount;
        int index;
        
        HashIterator() {
            try {
                BytecodeManager.incBytecodes(5);
                this.expectedModCount = HashMap.this.modCount;
                BytecodeManager.incBytecodes(4);
                final Node<K, V>[] table = HashMap.this.table;
                BytecodeManager.incBytecodes(3);
                final Node<K, V> node = null;
                this.next = node;
                this.current = node;
                BytecodeManager.incBytecodes(6);
                this.index = 0;
                BytecodeManager.incBytecodes(3);
                final Node<K, V>[] array = table;
                BytecodeManager.incBytecodes(2);
                if (array != null) {
                    final int size = HashMap.this.size;
                    BytecodeManager.incBytecodes(3);
                    if (size > 0) {
                        Node<K, V> next;
                        do {
                            final int index = this.index;
                            final int length = table.length;
                            BytecodeManager.incBytecodes(5);
                            if (index >= length) {
                                break;
                            }
                            next = table[this.index++];
                            this.next = next;
                            BytecodeManager.incBytecodes(13);
                        } while (next == null);
                    }
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
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
        
        final Node<K, V> nextNode() {
            try {
                final Node<K, V> next = this.next;
                BytecodeManager.incBytecodes(3);
                final int modCount = HashMap.this.modCount;
                final int expectedModCount = this.expectedModCount;
                BytecodeManager.incBytecodes(6);
                if (modCount != expectedModCount) {
                    BytecodeManager.incBytecodes(3);
                    final ConcurrentModificationException ex = new ConcurrentModificationException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final Node<K, V> node = next;
                BytecodeManager.incBytecodes(2);
                if (node == null) {
                    BytecodeManager.incBytecodes(3);
                    final NoSuchElementException ex2 = new NoSuchElementException();
                    BytecodeManager.incBytecodes(1);
                    throw ex2;
                }
                final Node<K, V> current = next;
                this.current = current;
                final Node<K, V> next2 = current.next;
                this.next = next2;
                BytecodeManager.incBytecodes(9);
                if (next2 == null) {
                    final Node<K, V>[] table;
                    final Node<K, V>[] array = table = HashMap.this.table;
                    BytecodeManager.incBytecodes(6);
                    if (array != null) {
                        Node<K, V> next3;
                        do {
                            final int index = this.index;
                            final int length = table.length;
                            BytecodeManager.incBytecodes(5);
                            if (index >= length) {
                                break;
                            }
                            next3 = table[this.index++];
                            this.next = next3;
                            BytecodeManager.incBytecodes(13);
                        } while (next3 == null);
                    }
                }
                final Node<K, V> node2 = next;
                BytecodeManager.incBytecodes(2);
                return node2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public final void remove() {
            try {
                final Node<K, V> current = this.current;
                BytecodeManager.incBytecodes(3);
                final Node<K, V> node = current;
                BytecodeManager.incBytecodes(2);
                if (node == null) {
                    BytecodeManager.incBytecodes(3);
                    final IllegalStateException ex = new IllegalStateException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final int modCount = HashMap.this.modCount;
                final int expectedModCount = this.expectedModCount;
                BytecodeManager.incBytecodes(6);
                if (modCount != expectedModCount) {
                    BytecodeManager.incBytecodes(3);
                    final ConcurrentModificationException ex2 = new ConcurrentModificationException();
                    BytecodeManager.incBytecodes(1);
                    throw ex2;
                }
                this.current = null;
                BytecodeManager.incBytecodes(3);
                final K key = current.key;
                BytecodeManager.incBytecodes(3);
                final HashMap this$0 = HashMap.this;
                final K k = key;
                BytecodeManager.incBytecodes(4);
                final int hash = HashMap.hash(k);
                final K i = key;
                final Object o = null;
                final boolean b = false;
                final boolean b2 = false;
                BytecodeManager.incBytecodes(5);
                this$0.removeNode(hash, i, o, b, b2);
                BytecodeManager.incBytecodes(1);
                this.expectedModCount = HashMap.this.modCount;
                BytecodeManager.incBytecodes(5);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    final class KeyIterator extends HashIterator implements Iterator<K>
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
        public final K next() {
            try {
                BytecodeManager.incBytecodes(2);
                final K key = this.nextNode().key;
                BytecodeManager.incBytecodes(2);
                return key;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    final class ValueIterator extends HashIterator implements Iterator<V>
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
        public final V next() {
            try {
                BytecodeManager.incBytecodes(2);
                final V value = this.nextNode().value;
                BytecodeManager.incBytecodes(2);
                return value;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    final class EntryIterator extends HashIterator implements Iterator<Entry<K, V>>
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
        public final Entry<K, V> next() {
            try {
                BytecodeManager.incBytecodes(2);
                final Node<K, V> nextNode = this.nextNode();
                BytecodeManager.incBytecodes(1);
                return nextNode;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static class HashMapSpliterator<K, V>
    {
        final HashMap<K, V> map;
        Node<K, V> current;
        int index;
        int fence;
        int est;
        int expectedModCount;
        
        HashMapSpliterator(final HashMap<K, V> map, final int index, final int fence, final int est, final int expectedModCount) {
            try {
                BytecodeManager.incBytecodes(2);
                this.map = map;
                BytecodeManager.incBytecodes(3);
                this.index = index;
                BytecodeManager.incBytecodes(3);
                this.fence = fence;
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
        
        final int getFence() {
            try {
                int fence = this.fence;
                BytecodeManager.incBytecodes(5);
                if (fence < 0) {
                    final HashMap<K, V> map = this.map;
                    BytecodeManager.incBytecodes(3);
                    this.est = map.size;
                    BytecodeManager.incBytecodes(4);
                    this.expectedModCount = map.modCount;
                    BytecodeManager.incBytecodes(4);
                    final Node<K, V>[] table = map.table;
                    BytecodeManager.incBytecodes(3);
                    final Node<K, V>[] array = table;
                    BytecodeManager.incBytecodes(3);
                    int length;
                    int n;
                    if (array == null) {
                        n = (length = 0);
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        n = (length = table.length);
                        BytecodeManager.incBytecodes(2);
                    }
                    this.fence = length;
                    fence = n;
                    BytecodeManager.incBytecodes(3);
                }
                final int n2 = fence;
                BytecodeManager.incBytecodes(2);
                return n2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public final long estimateSize() {
            try {
                BytecodeManager.incBytecodes(2);
                this.getFence();
                BytecodeManager.incBytecodes(1);
                final long n = this.est;
                BytecodeManager.incBytecodes(4);
                return n;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class KeySpliterator<K, V> extends HashMapSpliterator<K, V> implements Spliterator<K>
    {
        KeySpliterator(final HashMap<K, V> hashMap, final int n, final int n2, final int n3, final int n4) {
            try {
                BytecodeManager.incBytecodes(7);
                super(hashMap, n, n2, n3, n4);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public KeySpliterator<K, V> trySplit() {
            try {
                BytecodeManager.incBytecodes(2);
                final int fence = this.getFence();
                final int index = this.index;
                final int n = index + fence >>> 1;
                BytecodeManager.incBytecodes(10);
                final int n2 = index;
                final int n3 = n;
                BytecodeManager.incBytecodes(3);
                KeySpliterator keySpliterator = null;
                Label_0095: {
                    if (n2 < n3) {
                        final Node<K, V> current = this.current;
                        BytecodeManager.incBytecodes(3);
                        if (current == null) {
                            final HashMap<K, V> map;
                            final int n4;
                            final int index2;
                            final int est;
                            final int expectedModCount;
                            keySpliterator = new KeySpliterator<K, V>((HashMap<Object, Object>)map, n4, index2, est, expectedModCount);
                            map = this.map;
                            n4 = index;
                            index2 = n;
                            this.index = index2;
                            est = this.est >>> 1;
                            this.est = est;
                            expectedModCount = this.expectedModCount;
                            BytecodeManager.incBytecodes(19);
                            break Label_0095;
                        }
                    }
                    keySpliterator = null;
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(1);
                return keySpliterator;
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
                final HashMap<K, V> map = this.map;
                BytecodeManager.incBytecodes(3);
                final Node<K, V>[] table = map.table;
                BytecodeManager.incBytecodes(3);
                int fence;
                final int n = fence = this.fence;
                BytecodeManager.incBytecodes(5);
                int expectedModCount;
                if (n < 0) {
                    final int modCount = map.modCount;
                    this.expectedModCount = modCount;
                    expectedModCount = modCount;
                    BytecodeManager.incBytecodes(6);
                    final Node<K, V>[] array = table;
                    BytecodeManager.incBytecodes(3);
                    int length;
                    int n2;
                    if (array == null) {
                        n2 = (length = 0);
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        n2 = (length = table.length);
                        BytecodeManager.incBytecodes(2);
                    }
                    this.fence = length;
                    fence = n2;
                    BytecodeManager.incBytecodes(4);
                }
                else {
                    expectedModCount = this.expectedModCount;
                    BytecodeManager.incBytecodes(3);
                }
                final Node<K, V>[] array2 = table;
                BytecodeManager.incBytecodes(2);
                Label_0325: {
                    if (array2 != null) {
                        final int length2 = table.length;
                        final int n3 = fence;
                        BytecodeManager.incBytecodes(4);
                        if (length2 >= n3) {
                            int index;
                            final int n4 = index = this.index;
                            BytecodeManager.incBytecodes(5);
                            if (n4 >= 0) {
                                final int n5 = index;
                                final int index2 = fence;
                                this.index = index2;
                                BytecodeManager.incBytecodes(6);
                                if (n5 >= index2) {
                                    final Node<K, V> current = this.current;
                                    BytecodeManager.incBytecodes(3);
                                    if (current == null) {
                                        break Label_0325;
                                    }
                                }
                                Node<K, V> node = this.current;
                                BytecodeManager.incBytecodes(3);
                                this.current = null;
                                BytecodeManager.incBytecodes(3);
                                while (true) {
                                    final Node<K, V> node2 = node;
                                    BytecodeManager.incBytecodes(2);
                                    if (node2 == null) {
                                        node = table[index++];
                                        BytecodeManager.incBytecodes(6);
                                    }
                                    else {
                                        final K key = node.key;
                                        BytecodeManager.incBytecodes(4);
                                        consumer.accept(key);
                                        node = node.next;
                                        BytecodeManager.incBytecodes(3);
                                    }
                                    final Node<K, V> node3 = node;
                                    BytecodeManager.incBytecodes(2);
                                    if (node3 == null) {
                                        final int n6 = index;
                                        final int n7 = fence;
                                        BytecodeManager.incBytecodes(3);
                                        if (n6 >= n7) {
                                            break;
                                        }
                                        continue;
                                    }
                                }
                                final int modCount2 = map.modCount;
                                final int n8 = expectedModCount;
                                BytecodeManager.incBytecodes(4);
                                if (modCount2 != n8) {
                                    BytecodeManager.incBytecodes(3);
                                    final ConcurrentModificationException ex2 = new ConcurrentModificationException();
                                    BytecodeManager.incBytecodes(1);
                                    throw ex2;
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
                final Node<K, V>[] table = this.map.table;
                BytecodeManager.incBytecodes(4);
                final Node<K, V>[] array = table;
                BytecodeManager.incBytecodes(2);
                if (array != null) {
                    final int length = table.length;
                    BytecodeManager.incBytecodes(4);
                    final int fence = this.getFence();
                    BytecodeManager.incBytecodes(3);
                    if (length >= fence) {
                        final int index = this.index;
                        BytecodeManager.incBytecodes(3);
                        if (index >= 0) {
                            while (true) {
                                final Node<K, V> current = this.current;
                                BytecodeManager.incBytecodes(3);
                                if (current == null) {
                                    final int index2 = this.index;
                                    final int n = fence;
                                    BytecodeManager.incBytecodes(4);
                                    if (index2 >= n) {
                                        break;
                                    }
                                }
                                final Node<K, V> current2 = this.current;
                                BytecodeManager.incBytecodes(3);
                                if (current2 == null) {
                                    this.current = table[this.index++];
                                    BytecodeManager.incBytecodes(12);
                                }
                                else {
                                    final K key = this.current.key;
                                    BytecodeManager.incBytecodes(4);
                                    this.current = this.current.next;
                                    BytecodeManager.incBytecodes(5);
                                    final K k = key;
                                    BytecodeManager.incBytecodes(3);
                                    consumer.accept(k);
                                    final int modCount = this.map.modCount;
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
        public int characteristics() {
            try {
                final int fence = this.fence;
                BytecodeManager.incBytecodes(3);
                int n = 0;
                Label_0047: {
                    if (fence >= 0) {
                        final int est = this.est;
                        final int size = this.map.size;
                        BytecodeManager.incBytecodes(6);
                        if (est != size) {
                            n = 0;
                            BytecodeManager.incBytecodes(1);
                            break Label_0047;
                        }
                    }
                    n = 64;
                    BytecodeManager.incBytecodes(2);
                }
                final int n2 = n | 0x1;
                BytecodeManager.incBytecodes(3);
                return n2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class ValueSpliterator<K, V> extends HashMapSpliterator<K, V> implements Spliterator<V>
    {
        ValueSpliterator(final HashMap<K, V> hashMap, final int n, final int n2, final int n3, final int n4) {
            try {
                BytecodeManager.incBytecodes(7);
                super(hashMap, n, n2, n3, n4);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public ValueSpliterator<K, V> trySplit() {
            try {
                BytecodeManager.incBytecodes(2);
                final int fence = this.getFence();
                final int index = this.index;
                final int n = index + fence >>> 1;
                BytecodeManager.incBytecodes(10);
                final int n2 = index;
                final int n3 = n;
                BytecodeManager.incBytecodes(3);
                ValueSpliterator valueSpliterator = null;
                Label_0095: {
                    if (n2 < n3) {
                        final Node<K, V> current = this.current;
                        BytecodeManager.incBytecodes(3);
                        if (current == null) {
                            final HashMap<K, V> map;
                            final int n4;
                            final int index2;
                            final int est;
                            final int expectedModCount;
                            valueSpliterator = new ValueSpliterator<K, V>((HashMap<Object, Object>)map, n4, index2, est, expectedModCount);
                            map = this.map;
                            n4 = index;
                            index2 = n;
                            this.index = index2;
                            est = this.est >>> 1;
                            this.est = est;
                            expectedModCount = this.expectedModCount;
                            BytecodeManager.incBytecodes(19);
                            break Label_0095;
                        }
                    }
                    valueSpliterator = null;
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(1);
                return valueSpliterator;
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
                final HashMap<K, V> map = this.map;
                BytecodeManager.incBytecodes(3);
                final Node<K, V>[] table = map.table;
                BytecodeManager.incBytecodes(3);
                int fence;
                final int n = fence = this.fence;
                BytecodeManager.incBytecodes(5);
                int expectedModCount;
                if (n < 0) {
                    final int modCount = map.modCount;
                    this.expectedModCount = modCount;
                    expectedModCount = modCount;
                    BytecodeManager.incBytecodes(6);
                    final Node<K, V>[] array = table;
                    BytecodeManager.incBytecodes(3);
                    int length;
                    int n2;
                    if (array == null) {
                        n2 = (length = 0);
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        n2 = (length = table.length);
                        BytecodeManager.incBytecodes(2);
                    }
                    this.fence = length;
                    fence = n2;
                    BytecodeManager.incBytecodes(4);
                }
                else {
                    expectedModCount = this.expectedModCount;
                    BytecodeManager.incBytecodes(3);
                }
                final Node<K, V>[] array2 = table;
                BytecodeManager.incBytecodes(2);
                Label_0325: {
                    if (array2 != null) {
                        final int length2 = table.length;
                        final int n3 = fence;
                        BytecodeManager.incBytecodes(4);
                        if (length2 >= n3) {
                            int index;
                            final int n4 = index = this.index;
                            BytecodeManager.incBytecodes(5);
                            if (n4 >= 0) {
                                final int n5 = index;
                                final int index2 = fence;
                                this.index = index2;
                                BytecodeManager.incBytecodes(6);
                                if (n5 >= index2) {
                                    final Node<K, V> current = this.current;
                                    BytecodeManager.incBytecodes(3);
                                    if (current == null) {
                                        break Label_0325;
                                    }
                                }
                                Node<K, V> node = this.current;
                                BytecodeManager.incBytecodes(3);
                                this.current = null;
                                BytecodeManager.incBytecodes(3);
                                while (true) {
                                    final Node<K, V> node2 = node;
                                    BytecodeManager.incBytecodes(2);
                                    if (node2 == null) {
                                        node = table[index++];
                                        BytecodeManager.incBytecodes(6);
                                    }
                                    else {
                                        final V value = node.value;
                                        BytecodeManager.incBytecodes(4);
                                        consumer.accept(value);
                                        node = node.next;
                                        BytecodeManager.incBytecodes(3);
                                    }
                                    final Node<K, V> node3 = node;
                                    BytecodeManager.incBytecodes(2);
                                    if (node3 == null) {
                                        final int n6 = index;
                                        final int n7 = fence;
                                        BytecodeManager.incBytecodes(3);
                                        if (n6 >= n7) {
                                            break;
                                        }
                                        continue;
                                    }
                                }
                                final int modCount2 = map.modCount;
                                final int n8 = expectedModCount;
                                BytecodeManager.incBytecodes(4);
                                if (modCount2 != n8) {
                                    BytecodeManager.incBytecodes(3);
                                    final ConcurrentModificationException ex2 = new ConcurrentModificationException();
                                    BytecodeManager.incBytecodes(1);
                                    throw ex2;
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
                final Node<K, V>[] table = this.map.table;
                BytecodeManager.incBytecodes(4);
                final Node<K, V>[] array = table;
                BytecodeManager.incBytecodes(2);
                if (array != null) {
                    final int length = table.length;
                    BytecodeManager.incBytecodes(4);
                    final int fence = this.getFence();
                    BytecodeManager.incBytecodes(3);
                    if (length >= fence) {
                        final int index = this.index;
                        BytecodeManager.incBytecodes(3);
                        if (index >= 0) {
                            while (true) {
                                final Node<K, V> current = this.current;
                                BytecodeManager.incBytecodes(3);
                                if (current == null) {
                                    final int index2 = this.index;
                                    final int n = fence;
                                    BytecodeManager.incBytecodes(4);
                                    if (index2 >= n) {
                                        break;
                                    }
                                }
                                final Node<K, V> current2 = this.current;
                                BytecodeManager.incBytecodes(3);
                                if (current2 == null) {
                                    this.current = table[this.index++];
                                    BytecodeManager.incBytecodes(12);
                                }
                                else {
                                    final V value = this.current.value;
                                    BytecodeManager.incBytecodes(4);
                                    this.current = this.current.next;
                                    BytecodeManager.incBytecodes(5);
                                    final V v = value;
                                    BytecodeManager.incBytecodes(3);
                                    consumer.accept(v);
                                    final int modCount = this.map.modCount;
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
        public int characteristics() {
            try {
                final int fence = this.fence;
                BytecodeManager.incBytecodes(3);
                int n = 0;
                Label_0047: {
                    if (fence >= 0) {
                        final int est = this.est;
                        final int size = this.map.size;
                        BytecodeManager.incBytecodes(6);
                        if (est != size) {
                            n = 0;
                            BytecodeManager.incBytecodes(1);
                            break Label_0047;
                        }
                    }
                    n = 64;
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(1);
                return n;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class EntrySpliterator<K, V> extends HashMapSpliterator<K, V> implements Spliterator<Entry<K, V>>
    {
        EntrySpliterator(final HashMap<K, V> hashMap, final int n, final int n2, final int n3, final int n4) {
            try {
                BytecodeManager.incBytecodes(7);
                super(hashMap, n, n2, n3, n4);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public EntrySpliterator<K, V> trySplit() {
            try {
                BytecodeManager.incBytecodes(2);
                final int fence = this.getFence();
                final int index = this.index;
                final int n = index + fence >>> 1;
                BytecodeManager.incBytecodes(10);
                final int n2 = index;
                final int n3 = n;
                BytecodeManager.incBytecodes(3);
                EntrySpliterator entrySpliterator = null;
                Label_0095: {
                    if (n2 < n3) {
                        final Node<K, V> current = this.current;
                        BytecodeManager.incBytecodes(3);
                        if (current == null) {
                            final HashMap<K, V> map;
                            final int n4;
                            final int index2;
                            final int est;
                            final int expectedModCount;
                            entrySpliterator = new EntrySpliterator<K, V>((HashMap<Object, Object>)map, n4, index2, est, expectedModCount);
                            map = this.map;
                            n4 = index;
                            index2 = n;
                            this.index = index2;
                            est = this.est >>> 1;
                            this.est = est;
                            expectedModCount = this.expectedModCount;
                            BytecodeManager.incBytecodes(19);
                            break Label_0095;
                        }
                    }
                    entrySpliterator = null;
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(1);
                return entrySpliterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void forEachRemaining(final Consumer<? super Entry<K, V>> consumer) {
            try {
                BytecodeManager.incBytecodes(2);
                if (consumer == null) {
                    BytecodeManager.incBytecodes(3);
                    final NullPointerException ex = new NullPointerException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final HashMap<K, V> map = this.map;
                BytecodeManager.incBytecodes(3);
                final Node<K, V>[] table = map.table;
                BytecodeManager.incBytecodes(3);
                int fence;
                final int n = fence = this.fence;
                BytecodeManager.incBytecodes(5);
                int expectedModCount;
                if (n < 0) {
                    final int modCount = map.modCount;
                    this.expectedModCount = modCount;
                    expectedModCount = modCount;
                    BytecodeManager.incBytecodes(6);
                    final Node<K, V>[] array = table;
                    BytecodeManager.incBytecodes(3);
                    int length;
                    int n2;
                    if (array == null) {
                        n2 = (length = 0);
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        n2 = (length = table.length);
                        BytecodeManager.incBytecodes(2);
                    }
                    this.fence = length;
                    fence = n2;
                    BytecodeManager.incBytecodes(4);
                }
                else {
                    expectedModCount = this.expectedModCount;
                    BytecodeManager.incBytecodes(3);
                }
                final Node<K, V>[] array2 = table;
                BytecodeManager.incBytecodes(2);
                Label_0322: {
                    if (array2 != null) {
                        final int length2 = table.length;
                        final int n3 = fence;
                        BytecodeManager.incBytecodes(4);
                        if (length2 >= n3) {
                            int index;
                            final int n4 = index = this.index;
                            BytecodeManager.incBytecodes(5);
                            if (n4 >= 0) {
                                final int n5 = index;
                                final int index2 = fence;
                                this.index = index2;
                                BytecodeManager.incBytecodes(6);
                                if (n5 >= index2) {
                                    final Node<K, V> current = this.current;
                                    BytecodeManager.incBytecodes(3);
                                    if (current == null) {
                                        break Label_0322;
                                    }
                                }
                                Node<K, V> node = this.current;
                                BytecodeManager.incBytecodes(3);
                                this.current = null;
                                BytecodeManager.incBytecodes(3);
                                while (true) {
                                    final Node<K, V> node2 = node;
                                    BytecodeManager.incBytecodes(2);
                                    if (node2 == null) {
                                        node = table[index++];
                                        BytecodeManager.incBytecodes(6);
                                    }
                                    else {
                                        final Node<K, V> node3 = node;
                                        BytecodeManager.incBytecodes(3);
                                        consumer.accept(node3);
                                        node = node.next;
                                        BytecodeManager.incBytecodes(3);
                                    }
                                    final Node<K, V> node4 = node;
                                    BytecodeManager.incBytecodes(2);
                                    if (node4 == null) {
                                        final int n6 = index;
                                        final int n7 = fence;
                                        BytecodeManager.incBytecodes(3);
                                        if (n6 >= n7) {
                                            break;
                                        }
                                        continue;
                                    }
                                }
                                final int modCount2 = map.modCount;
                                final int n8 = expectedModCount;
                                BytecodeManager.incBytecodes(4);
                                if (modCount2 != n8) {
                                    BytecodeManager.incBytecodes(3);
                                    final ConcurrentModificationException ex2 = new ConcurrentModificationException();
                                    BytecodeManager.incBytecodes(1);
                                    throw ex2;
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
        
        @Override
        public boolean tryAdvance(final Consumer<? super Entry<K, V>> consumer) {
            try {
                BytecodeManager.incBytecodes(2);
                if (consumer == null) {
                    BytecodeManager.incBytecodes(3);
                    final NullPointerException ex = new NullPointerException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final Node<K, V>[] table = this.map.table;
                BytecodeManager.incBytecodes(4);
                final Node<K, V>[] array = table;
                BytecodeManager.incBytecodes(2);
                if (array != null) {
                    final int length = table.length;
                    BytecodeManager.incBytecodes(4);
                    final int fence = this.getFence();
                    BytecodeManager.incBytecodes(3);
                    if (length >= fence) {
                        final int index = this.index;
                        BytecodeManager.incBytecodes(3);
                        if (index >= 0) {
                            while (true) {
                                final Node<K, V> current = this.current;
                                BytecodeManager.incBytecodes(3);
                                if (current == null) {
                                    final int index2 = this.index;
                                    final int n = fence;
                                    BytecodeManager.incBytecodes(4);
                                    if (index2 >= n) {
                                        break;
                                    }
                                }
                                final Node<K, V> current2 = this.current;
                                BytecodeManager.incBytecodes(3);
                                if (current2 == null) {
                                    this.current = table[this.index++];
                                    BytecodeManager.incBytecodes(12);
                                }
                                else {
                                    final Node<K, V> current3 = this.current;
                                    BytecodeManager.incBytecodes(3);
                                    this.current = this.current.next;
                                    BytecodeManager.incBytecodes(5);
                                    final Node<K, V> node = current3;
                                    BytecodeManager.incBytecodes(3);
                                    consumer.accept(node);
                                    final int modCount = this.map.modCount;
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
        public int characteristics() {
            try {
                final int fence = this.fence;
                BytecodeManager.incBytecodes(3);
                int n = 0;
                Label_0047: {
                    if (fence >= 0) {
                        final int est = this.est;
                        final int size = this.map.size;
                        BytecodeManager.incBytecodes(6);
                        if (est != size) {
                            n = 0;
                            BytecodeManager.incBytecodes(1);
                            break Label_0047;
                        }
                    }
                    n = 64;
                    BytecodeManager.incBytecodes(2);
                }
                final int n2 = n | 0x1;
                BytecodeManager.incBytecodes(3);
                return n2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class TreeNode<K, V> extends LinkedHashMap.Entry<K, V>
    {
        TreeNode<K, V> parent;
        TreeNode<K, V> left;
        TreeNode<K, V> right;
        TreeNode<K, V> prev;
        boolean red;
        static final /* synthetic */ boolean $assertionsDisabled;
        
        TreeNode(final int n, final K k, final V v, final Node<K, V> node) {
            try {
                BytecodeManager.incBytecodes(6);
                super(n, k, v, node);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        final TreeNode<K, V> root() {
            try {
                TreeNode treeNode = this;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final TreeNode<K, V> parent = treeNode.parent;
                    BytecodeManager.incBytecodes(5);
                    if (parent == null) {
                        break;
                    }
                    treeNode = parent;
                    BytecodeManager.incBytecodes(3);
                }
                final TreeNode treeNode2 = treeNode;
                BytecodeManager.incBytecodes(2);
                return treeNode2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static <K, V> void moveRootToFront(final Node<K, V>[] array, final TreeNode<K, V> prev) {
            try {
                BytecodeManager.incBytecodes(2);
                if (prev != null) {
                    BytecodeManager.incBytecodes(2);
                    if (array != null) {
                        final int length = array.length;
                        BytecodeManager.incBytecodes(5);
                        if (length > 0) {
                            final int n = length - 1 & prev.hash;
                            BytecodeManager.incBytecodes(7);
                            final TreeNode next = (TreeNode)array[n];
                            BytecodeManager.incBytecodes(5);
                            final TreeNode treeNode = next;
                            BytecodeManager.incBytecodes(3);
                            if (prev != treeNode) {
                                array[n] = prev;
                                BytecodeManager.incBytecodes(4);
                                final TreeNode<K, V> prev2 = prev.prev;
                                BytecodeManager.incBytecodes(3);
                                final Node<K, V> next2;
                                final Node<K, V> node = next2 = prev.next;
                                BytecodeManager.incBytecodes(5);
                                if (node != null) {
                                    ((TreeNode)next2).prev = (TreeNode<K, V>)prev2;
                                    BytecodeManager.incBytecodes(4);
                                }
                                final TreeNode<K, V> treeNode2 = prev2;
                                BytecodeManager.incBytecodes(2);
                                if (treeNode2 != null) {
                                    prev2.next = next2;
                                    BytecodeManager.incBytecodes(3);
                                }
                                final TreeNode treeNode3 = next;
                                BytecodeManager.incBytecodes(2);
                                if (treeNode3 != null) {
                                    next.prev = (TreeNode<K, V>)prev;
                                    BytecodeManager.incBytecodes(3);
                                }
                                prev.next = (Node<K, V>)next;
                                BytecodeManager.incBytecodes(3);
                                prev.prev = null;
                                BytecodeManager.incBytecodes(3);
                            }
                            final boolean $assertionsDisabled = TreeNode.$assertionsDisabled;
                            BytecodeManager.incBytecodes(2);
                            if (!$assertionsDisabled) {
                                BytecodeManager.incBytecodes(2);
                                final boolean checkInvariants = checkInvariants(prev);
                                BytecodeManager.incBytecodes(1);
                                if (!checkInvariants) {
                                    BytecodeManager.incBytecodes(3);
                                    final AssertionError assertionError = new AssertionError();
                                    BytecodeManager.incBytecodes(1);
                                    throw assertionError;
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
        
        final TreeNode<K, V> find(final int n, final Object o, Class<?> comparableClass) {
            try {
                TreeNode treeNode = this;
                BytecodeManager.incBytecodes(2);
                TreeNode treeNode2;
                do {
                    final TreeNode<K, V> left = treeNode.left;
                    final TreeNode<K, V> right = treeNode.right;
                    BytecodeManager.incBytecodes(6);
                    final int hash = treeNode.hash;
                    BytecodeManager.incBytecodes(6);
                    Label_0315: {
                        if (hash > n) {
                            treeNode = left;
                            BytecodeManager.incBytecodes(3);
                        }
                        else {
                            final int n2 = hash;
                            BytecodeManager.incBytecodes(3);
                            if (n2 >= n) {
                                final K key;
                                final K k = key = treeNode.key;
                                BytecodeManager.incBytecodes(6);
                                Label_0124: {
                                    if (k != o) {
                                        BytecodeManager.incBytecodes(2);
                                        if (o != null) {
                                            final K obj = key;
                                            BytecodeManager.incBytecodes(3);
                                            final boolean equals = o.equals(obj);
                                            BytecodeManager.incBytecodes(1);
                                            if (equals) {
                                                break Label_0124;
                                            }
                                        }
                                        final TreeNode<K, V> treeNode3 = left;
                                        BytecodeManager.incBytecodes(2);
                                        if (treeNode3 == null) {
                                            treeNode = right;
                                            BytecodeManager.incBytecodes(3);
                                            break Label_0315;
                                        }
                                        final TreeNode<K, V> treeNode4 = right;
                                        BytecodeManager.incBytecodes(2);
                                        if (treeNode4 == null) {
                                            treeNode = left;
                                            BytecodeManager.incBytecodes(3);
                                            break Label_0315;
                                        }
                                        final Class<?> clazz = comparableClass;
                                        BytecodeManager.incBytecodes(2);
                                        Label_0274: {
                                            if (clazz == null) {
                                                BytecodeManager.incBytecodes(1);
                                                BytecodeManager.incBytecodes(1);
                                                final Class<?> clazz2 = comparableClass = HashMap.comparableClassFor(o);
                                                BytecodeManager.incBytecodes(3);
                                                if (clazz2 == null) {
                                                    break Label_0274;
                                                }
                                            }
                                            final Class<?> clazz3 = comparableClass;
                                            final K i = key;
                                            BytecodeManager.incBytecodes(3);
                                            BytecodeManager.incBytecodes(1);
                                            final int compareComparables = HashMap.compareComparables(clazz3, o, i);
                                            BytecodeManager.incBytecodes(3);
                                            if (compareComparables != 0) {
                                                final int n3 = compareComparables;
                                                BytecodeManager.incBytecodes(2);
                                                TreeNode<K, V> treeNode5;
                                                if (n3 < 0) {
                                                    treeNode5 = left;
                                                    BytecodeManager.incBytecodes(2);
                                                }
                                                else {
                                                    treeNode5 = right;
                                                    BytecodeManager.incBytecodes(1);
                                                }
                                                treeNode = treeNode5;
                                                BytecodeManager.incBytecodes(2);
                                                break Label_0315;
                                            }
                                        }
                                        final TreeNode<K, V> treeNode6 = right;
                                        final Class<?> clazz4 = comparableClass;
                                        BytecodeManager.incBytecodes(5);
                                        final TreeNode find = treeNode6.find(n, o, clazz4);
                                        BytecodeManager.incBytecodes(3);
                                        if (find != null) {
                                            final TreeNode treeNode7 = find;
                                            BytecodeManager.incBytecodes(2);
                                            return (TreeNode<K, V>)treeNode7;
                                        }
                                        treeNode = left;
                                        BytecodeManager.incBytecodes(2);
                                        break Label_0315;
                                    }
                                }
                                final TreeNode treeNode8 = treeNode;
                                BytecodeManager.incBytecodes(2);
                                return treeNode8;
                            }
                            treeNode = right;
                            BytecodeManager.incBytecodes(3);
                        }
                    }
                    treeNode2 = treeNode;
                    BytecodeManager.incBytecodes(2);
                } while (treeNode2 != null);
                final TreeNode<K, V> treeNode9 = null;
                BytecodeManager.incBytecodes(2);
                return treeNode9;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        final TreeNode<K, V> getTreeNode(final int n, final Object o) {
            try {
                final TreeNode<K, V> parent = this.parent;
                BytecodeManager.incBytecodes(3);
                TreeNode<K, V> root;
                if (parent != null) {
                    BytecodeManager.incBytecodes(2);
                    root = this.root();
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    root = this;
                    BytecodeManager.incBytecodes(1);
                }
                final Class<?> clazz = null;
                BytecodeManager.incBytecodes(4);
                final TreeNode find = root.find(n, o, clazz);
                BytecodeManager.incBytecodes(1);
                return (TreeNode<K, V>)find;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static int tieBreakOrder(final Object o, final Object o2) {
            try {
                BytecodeManager.incBytecodes(2);
                int compareTo = 0;
                Label_0127: {
                    if (o != null) {
                        BytecodeManager.incBytecodes(2);
                        if (o2 != null) {
                            BytecodeManager.incBytecodes(1);
                            BytecodeManager.incBytecodes(1);
                            final Class<?> class1 = o.getClass();
                            BytecodeManager.incBytecodes(1);
                            final String name = class1.getName();
                            BytecodeManager.incBytecodes(1);
                            BytecodeManager.incBytecodes(1);
                            final Class<?> class2 = o2.getClass();
                            BytecodeManager.incBytecodes(1);
                            final String name2 = class2.getName();
                            BytecodeManager.incBytecodes(1);
                            compareTo = name.compareTo(name2);
                            BytecodeManager.incBytecodes(3);
                            if (compareTo != 0) {
                                break Label_0127;
                            }
                        }
                    }
                    BytecodeManager.incBytecodes(2);
                    final int identityHashCode = System.identityHashCode(o);
                    BytecodeManager.incBytecodes(2);
                    final int identityHashCode2 = System.identityHashCode(o2);
                    BytecodeManager.incBytecodes(1);
                    int n;
                    if (identityHashCode <= identityHashCode2) {
                        n = -1;
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        n = 1;
                        BytecodeManager.incBytecodes(1);
                    }
                    compareTo = n;
                    BytecodeManager.incBytecodes(1);
                }
                final int n2 = compareTo;
                BytecodeManager.incBytecodes(2);
                return n2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        final void treeify(final Node<K, V>[] array) {
            try {
                TreeNode balanceInsertion = null;
                BytecodeManager.incBytecodes(2);
                TreeNode treeNode = this;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final TreeNode treeNode2 = treeNode;
                    BytecodeManager.incBytecodes(2);
                    if (treeNode2 == null) {
                        break;
                    }
                    final TreeNode treeNode3 = (TreeNode)treeNode.next;
                    BytecodeManager.incBytecodes(4);
                    final TreeNode treeNode4 = treeNode;
                    final TreeNode treeNode5 = treeNode;
                    final TreeNode<K, V> treeNode6 = null;
                    treeNode5.right = treeNode6;
                    treeNode4.left = treeNode6;
                    BytecodeManager.incBytecodes(6);
                    final TreeNode treeNode7 = balanceInsertion;
                    BytecodeManager.incBytecodes(2);
                    if (treeNode7 == null) {
                        treeNode.parent = null;
                        BytecodeManager.incBytecodes(3);
                        treeNode.red = false;
                        BytecodeManager.incBytecodes(3);
                        balanceInsertion = treeNode;
                        BytecodeManager.incBytecodes(3);
                    }
                    else {
                        final K key = treeNode.key;
                        BytecodeManager.incBytecodes(3);
                        final int hash = treeNode.hash;
                        BytecodeManager.incBytecodes(3);
                        Class<?> comparableClass = null;
                        BytecodeManager.incBytecodes(2);
                        TreeNode treeNode8 = balanceInsertion;
                        BytecodeManager.incBytecodes(2);
                        int n2 = 0;
                        TreeNode parent;
                        while (true) {
                            final K key2 = treeNode8.key;
                            BytecodeManager.incBytecodes(3);
                            final int hash2 = treeNode8.hash;
                            final int n = hash;
                            BytecodeManager.incBytecodes(6);
                            Label_0278: {
                                if (hash2 > n) {
                                    n2 = -1;
                                    BytecodeManager.incBytecodes(3);
                                }
                                else {
                                    final int n3 = hash2;
                                    final int n4 = hash;
                                    BytecodeManager.incBytecodes(3);
                                    if (n3 < n4) {
                                        n2 = 1;
                                        BytecodeManager.incBytecodes(3);
                                    }
                                    else {
                                        final Class<?> clazz = comparableClass;
                                        BytecodeManager.incBytecodes(2);
                                        Label_0259: {
                                            if (clazz == null) {
                                                final K k = key;
                                                BytecodeManager.incBytecodes(1);
                                                BytecodeManager.incBytecodes(1);
                                                final Class<?> clazz2 = comparableClass = HashMap.comparableClassFor(k);
                                                BytecodeManager.incBytecodes(3);
                                                if (clazz2 == null) {
                                                    break Label_0259;
                                                }
                                            }
                                            final Class<?> clazz3 = comparableClass;
                                            final K i = key;
                                            final K j = key2;
                                            BytecodeManager.incBytecodes(3);
                                            BytecodeManager.incBytecodes(1);
                                            final int n5 = n2 = HashMap.compareComparables(clazz3, i, j);
                                            BytecodeManager.incBytecodes(3);
                                            if (n5 != 0) {
                                                break Label_0278;
                                            }
                                        }
                                        final K l = key;
                                        final K m = key2;
                                        BytecodeManager.incBytecodes(3);
                                        n2 = tieBreakOrder(l, m);
                                        BytecodeManager.incBytecodes(1);
                                    }
                                }
                            }
                            parent = treeNode8;
                            BytecodeManager.incBytecodes(2);
                            final int n6 = n2;
                            BytecodeManager.incBytecodes(2);
                            TreeNode<K, V> treeNode10;
                            TreeNode<K, V> treeNode9;
                            if (n6 <= 0) {
                                treeNode9 = (treeNode10 = treeNode8.left);
                                BytecodeManager.incBytecodes(3);
                            }
                            else {
                                treeNode9 = (treeNode10 = treeNode8.right);
                                BytecodeManager.incBytecodes(2);
                            }
                            treeNode8 = treeNode10;
                            BytecodeManager.incBytecodes(3);
                            if (treeNode9 == null) {
                                break;
                            }
                            BytecodeManager.incBytecodes(1);
                        }
                        treeNode.parent = parent;
                        BytecodeManager.incBytecodes(3);
                        final int n7 = n2;
                        BytecodeManager.incBytecodes(2);
                        if (n7 <= 0) {
                            parent.left = (TreeNode<K, V>)treeNode;
                            BytecodeManager.incBytecodes(4);
                        }
                        else {
                            parent.right = (TreeNode<K, V>)treeNode;
                            BytecodeManager.incBytecodes(3);
                        }
                        final TreeNode treeNode11 = balanceInsertion;
                        final TreeNode<K, V> treeNode12 = (TreeNode<K, V>)treeNode;
                        BytecodeManager.incBytecodes(3);
                        balanceInsertion = balanceInsertion(treeNode11, treeNode12);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                    }
                    treeNode = treeNode3;
                    BytecodeManager.incBytecodes(3);
                }
                final TreeNode treeNode13 = balanceInsertion;
                BytecodeManager.incBytecodes(3);
                moveRootToFront(array, treeNode13);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        final Node<K, V> untreeify(final HashMap<K, V> hashMap) {
            try {
                Node<K, V> node = null;
                Node<K, V> node2 = null;
                BytecodeManager.incBytecodes(4);
                Node<K, V> next = this;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final Node<K, V> node3 = next;
                    BytecodeManager.incBytecodes(2);
                    if (node3 == null) {
                        break;
                    }
                    final Node<K, V> node4 = next;
                    final Node<K, V> node5 = null;
                    BytecodeManager.incBytecodes(4);
                    final Node<K, V> replacementNode = hashMap.replacementNode(node4, node5);
                    BytecodeManager.incBytecodes(1);
                    final Node<K, V> node6 = node2;
                    BytecodeManager.incBytecodes(2);
                    if (node6 == null) {
                        node = replacementNode;
                        BytecodeManager.incBytecodes(3);
                    }
                    else {
                        node2.next = replacementNode;
                        BytecodeManager.incBytecodes(3);
                    }
                    node2 = replacementNode;
                    BytecodeManager.incBytecodes(2);
                    next = next.next;
                    BytecodeManager.incBytecodes(4);
                }
                final Node<K, V> node7 = node;
                BytecodeManager.incBytecodes(2);
                return node7;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        final TreeNode<K, V> putTreeVal(final HashMap<K, V> hashMap, final Node<K, V>[] array, final int n, final K k, final V v) {
            try {
                Class<?> comparableClass = null;
                BytecodeManager.incBytecodes(2);
                boolean b = false;
                BytecodeManager.incBytecodes(2);
                final TreeNode<K, V> parent = this.parent;
                BytecodeManager.incBytecodes(3);
                TreeNode<K, V> root;
                if (parent != null) {
                    BytecodeManager.incBytecodes(2);
                    root = this.root();
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    root = this;
                    BytecodeManager.incBytecodes(1);
                }
                final TreeNode<K, V> treeNode = root;
                BytecodeManager.incBytecodes(1);
                TreeNode<K, V> treeNode2 = treeNode;
                BytecodeManager.incBytecodes(2);
                int n2 = 0;
                TreeNode<K, V> treeNode7 = null;
                Block_12: {
                    TreeNode treeNode4 = null;
                    Label_0351: {
                        while (true) {
                            final int hash = treeNode2.hash;
                            BytecodeManager.incBytecodes(6);
                            Label_0378: {
                                if (hash > n) {
                                    n2 = -1;
                                    BytecodeManager.incBytecodes(3);
                                }
                                else {
                                    final int n3 = hash;
                                    BytecodeManager.incBytecodes(3);
                                    if (n3 < n) {
                                        n2 = 1;
                                        BytecodeManager.incBytecodes(3);
                                    }
                                    else {
                                        final K key;
                                        final K i = key = treeNode2.key;
                                        BytecodeManager.incBytecodes(6);
                                        if (i == k) {
                                            break;
                                        }
                                        BytecodeManager.incBytecodes(2);
                                        if (k != null) {
                                            final K obj = key;
                                            BytecodeManager.incBytecodes(3);
                                            final boolean equals = k.equals(obj);
                                            BytecodeManager.incBytecodes(1);
                                            if (equals) {
                                                break;
                                            }
                                        }
                                        final Class<?> clazz = comparableClass;
                                        BytecodeManager.incBytecodes(2);
                                        Label_0239: {
                                            if (clazz == null) {
                                                BytecodeManager.incBytecodes(1);
                                                BytecodeManager.incBytecodes(1);
                                                final Class<?> clazz2 = comparableClass = HashMap.comparableClassFor(k);
                                                BytecodeManager.incBytecodes(3);
                                                if (clazz2 == null) {
                                                    break Label_0239;
                                                }
                                            }
                                            final Class<?> clazz3 = comparableClass;
                                            final K j = key;
                                            BytecodeManager.incBytecodes(3);
                                            BytecodeManager.incBytecodes(1);
                                            final int n4 = n2 = HashMap.compareComparables(clazz3, k, j);
                                            BytecodeManager.incBytecodes(3);
                                            if (n4 != 0) {
                                                break Label_0378;
                                            }
                                        }
                                        final boolean b2 = b;
                                        BytecodeManager.incBytecodes(2);
                                        if (!b2) {
                                            b = true;
                                            BytecodeManager.incBytecodes(2);
                                            final TreeNode<K, V> left = treeNode2.left;
                                            BytecodeManager.incBytecodes(5);
                                            if (left != null) {
                                                final TreeNode<K, V> treeNode3 = left;
                                                final Class<?> clazz4 = comparableClass;
                                                BytecodeManager.incBytecodes(4);
                                                BytecodeManager.incBytecodes(1);
                                                treeNode4 = treeNode3.find(n, k, clazz4);
                                                BytecodeManager.incBytecodes(3);
                                                if (treeNode4 != null) {
                                                    break Label_0351;
                                                }
                                            }
                                            final TreeNode<K, V> right = treeNode2.right;
                                            BytecodeManager.incBytecodes(5);
                                            if (right != null) {
                                                final TreeNode<K, V> treeNode5 = right;
                                                final Class<?> clazz5 = comparableClass;
                                                BytecodeManager.incBytecodes(4);
                                                BytecodeManager.incBytecodes(1);
                                                final TreeNode treeNode6 = treeNode4 = treeNode5.find(n, k, clazz5);
                                                BytecodeManager.incBytecodes(3);
                                                if (treeNode6 != null) {
                                                    break Label_0351;
                                                }
                                            }
                                        }
                                        final K l = key;
                                        BytecodeManager.incBytecodes(3);
                                        n2 = tieBreakOrder(k, l);
                                        BytecodeManager.incBytecodes(1);
                                    }
                                }
                            }
                            treeNode7 = treeNode2;
                            BytecodeManager.incBytecodes(2);
                            final int n5 = n2;
                            BytecodeManager.incBytecodes(2);
                            TreeNode<K, V> treeNode9;
                            TreeNode<K, V> treeNode8;
                            if (n5 <= 0) {
                                treeNode8 = (treeNode9 = treeNode2.left);
                                BytecodeManager.incBytecodes(3);
                            }
                            else {
                                treeNode8 = (treeNode9 = treeNode2.right);
                                BytecodeManager.incBytecodes(2);
                            }
                            treeNode2 = treeNode9;
                            BytecodeManager.incBytecodes(3);
                            if (treeNode8 == null) {
                                break Block_12;
                            }
                            BytecodeManager.incBytecodes(1);
                        }
                        final TreeNode<K, V> treeNode10 = treeNode2;
                        BytecodeManager.incBytecodes(2);
                        return treeNode10;
                    }
                    final TreeNode treeNode11 = treeNode4;
                    BytecodeManager.incBytecodes(2);
                    return (TreeNode<K, V>)treeNode11;
                }
                final Node<K, V> next = treeNode7.next;
                BytecodeManager.incBytecodes(3);
                final Node<K, V> node = next;
                BytecodeManager.incBytecodes(6);
                final TreeNode<K, V> treeNode12 = hashMap.newTreeNode(n, k, v, node);
                BytecodeManager.incBytecodes(1);
                final int n6 = n2;
                BytecodeManager.incBytecodes(2);
                if (n6 <= 0) {
                    treeNode7.left = treeNode12;
                    BytecodeManager.incBytecodes(4);
                }
                else {
                    treeNode7.right = treeNode12;
                    BytecodeManager.incBytecodes(3);
                }
                treeNode7.next = treeNode12;
                BytecodeManager.incBytecodes(3);
                final TreeNode<K, V> treeNode13 = treeNode12;
                final TreeNode<K, V> treeNode14 = treeNode12;
                final TreeNode<K, V> treeNode15 = treeNode7;
                treeNode14.prev = treeNode15;
                treeNode13.parent = treeNode15;
                BytecodeManager.incBytecodes(6);
                final Node<K, V> node2 = next;
                BytecodeManager.incBytecodes(2);
                if (node2 != null) {
                    ((TreeNode)next).prev = treeNode12;
                    BytecodeManager.incBytecodes(4);
                }
                final TreeNode<K, V> treeNode16 = treeNode;
                final TreeNode<K, V> treeNode17 = treeNode12;
                BytecodeManager.incBytecodes(4);
                final TreeNode<K, V> balanceInsertion = balanceInsertion(treeNode16, treeNode17);
                BytecodeManager.incBytecodes(1);
                moveRootToFront(array, balanceInsertion);
                final TreeNode<K, V> treeNode18 = null;
                BytecodeManager.incBytecodes(2);
                return treeNode18;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        final void removeTreeNode(final HashMap<K, V> hashMap, final Node<K, V>[] array, final boolean b) {
            try {
                BytecodeManager.incBytecodes(2);
                if (array != null) {
                    final int length = array.length;
                    BytecodeManager.incBytecodes(5);
                    if (length != 0) {
                        final int n = length - 1 & this.hash;
                        BytecodeManager.incBytecodes(7);
                        TreeNode root;
                        Node<K, V> node = root = (TreeNode)array[n];
                        BytecodeManager.incBytecodes(7);
                        final TreeNode next = (TreeNode)this.next;
                        final TreeNode<K, V> prev = this.prev;
                        BytecodeManager.incBytecodes(7);
                        final TreeNode<K, V> treeNode = prev;
                        BytecodeManager.incBytecodes(2);
                        if (treeNode == null) {
                            node = (array[n] = (Node<K, V>)next);
                            BytecodeManager.incBytecodes(7);
                        }
                        else {
                            prev.next = (Node<K, V>)next;
                            BytecodeManager.incBytecodes(3);
                        }
                        final TreeNode<K, V> treeNode2 = next;
                        BytecodeManager.incBytecodes(2);
                        if (treeNode2 != null) {
                            next.prev = prev;
                            BytecodeManager.incBytecodes(3);
                        }
                        final Node<K, V> node2 = node;
                        BytecodeManager.incBytecodes(2);
                        if (node2 == null) {
                            BytecodeManager.incBytecodes(1);
                            return;
                        }
                        final TreeNode<K, V> parent = root.parent;
                        BytecodeManager.incBytecodes(3);
                        if (parent != null) {
                            final TreeNode treeNode3 = root;
                            BytecodeManager.incBytecodes(2);
                            root = treeNode3.root();
                            BytecodeManager.incBytecodes(1);
                        }
                        final TreeNode treeNode4 = root;
                        BytecodeManager.incBytecodes(2);
                        if (treeNode4 != null) {
                            final TreeNode<K, V> right = root.right;
                            BytecodeManager.incBytecodes(3);
                            if (right != null) {
                                final TreeNode<K, V> left = root.left;
                                BytecodeManager.incBytecodes(5);
                                if (left != null) {
                                    final TreeNode<K, V> left2 = left.left;
                                    BytecodeManager.incBytecodes(3);
                                    if (left2 != null) {
                                        final TreeNode<K, V> left3 = this.left;
                                        final TreeNode<K, V> right2 = this.right;
                                        BytecodeManager.incBytecodes(8);
                                        final TreeNode<K, V> treeNode5 = left3;
                                        BytecodeManager.incBytecodes(2);
                                        TreeNode<K, V> treeNode14 = null;
                                        Label_0763: {
                                            if (treeNode5 != null) {
                                                final TreeNode<K, V> treeNode6 = right2;
                                                BytecodeManager.incBytecodes(2);
                                                if (treeNode6 != null) {
                                                    TreeNode<K, V> right3 = right2;
                                                    BytecodeManager.incBytecodes(2);
                                                    while (true) {
                                                        final TreeNode<K, V> left4 = right3.left;
                                                        BytecodeManager.incBytecodes(5);
                                                        if (left4 == null) {
                                                            break;
                                                        }
                                                        right3 = left4;
                                                        BytecodeManager.incBytecodes(3);
                                                    }
                                                    final boolean red = right3.red;
                                                    right3.red = this.red;
                                                    this.red = red;
                                                    BytecodeManager.incBytecodes(10);
                                                    final TreeNode<K, V> right4 = right3.right;
                                                    BytecodeManager.incBytecodes(3);
                                                    final TreeNode<K, V> parent2 = this.parent;
                                                    BytecodeManager.incBytecodes(3);
                                                    final TreeNode<K, V> treeNode7 = right3;
                                                    final TreeNode<K, V> treeNode8 = right2;
                                                    BytecodeManager.incBytecodes(3);
                                                    if (treeNode7 == treeNode8) {
                                                        this.parent = right3;
                                                        BytecodeManager.incBytecodes(3);
                                                        right3.right = this;
                                                        BytecodeManager.incBytecodes(4);
                                                    }
                                                    else {
                                                        final TreeNode<K, V> parent3 = right3.parent;
                                                        BytecodeManager.incBytecodes(3);
                                                        final TreeNode<K, V> parent4 = parent3;
                                                        this.parent = parent4;
                                                        BytecodeManager.incBytecodes(5);
                                                        if (parent4 != null) {
                                                            final TreeNode<K, V> treeNode9 = right3;
                                                            final TreeNode<K, V> left5 = parent3.left;
                                                            BytecodeManager.incBytecodes(4);
                                                            if (treeNode9 == left5) {
                                                                parent3.left = this;
                                                                BytecodeManager.incBytecodes(4);
                                                            }
                                                            else {
                                                                parent3.right = this;
                                                                BytecodeManager.incBytecodes(3);
                                                            }
                                                        }
                                                        final TreeNode<K, V> treeNode10 = right3;
                                                        final TreeNode<K, V> right5 = right2;
                                                        treeNode10.right = right5;
                                                        BytecodeManager.incBytecodes(5);
                                                        if (right5 != null) {
                                                            right2.parent = right3;
                                                            BytecodeManager.incBytecodes(3);
                                                        }
                                                    }
                                                    this.left = null;
                                                    BytecodeManager.incBytecodes(3);
                                                    final TreeNode<K, V> right6 = right4;
                                                    this.right = right6;
                                                    BytecodeManager.incBytecodes(5);
                                                    if (right6 != null) {
                                                        right4.parent = this;
                                                        BytecodeManager.incBytecodes(3);
                                                    }
                                                    final TreeNode<K, V> treeNode11 = right3;
                                                    final TreeNode<K, V> left6 = left3;
                                                    treeNode11.left = left6;
                                                    BytecodeManager.incBytecodes(5);
                                                    if (left6 != null) {
                                                        left3.parent = right3;
                                                        BytecodeManager.incBytecodes(3);
                                                    }
                                                    final TreeNode<K, V> treeNode12 = right3;
                                                    final TreeNode<K, V> parent5 = parent2;
                                                    treeNode12.parent = parent5;
                                                    BytecodeManager.incBytecodes(5);
                                                    if (parent5 == null) {
                                                        root = right3;
                                                        BytecodeManager.incBytecodes(3);
                                                    }
                                                    else {
                                                        final TreeNode<K, V> left7 = parent2.left;
                                                        BytecodeManager.incBytecodes(4);
                                                        if (this == left7) {
                                                            parent2.left = right3;
                                                            BytecodeManager.incBytecodes(4);
                                                        }
                                                        else {
                                                            parent2.right = right3;
                                                            BytecodeManager.incBytecodes(3);
                                                        }
                                                    }
                                                    final TreeNode<K, V> treeNode13 = right4;
                                                    BytecodeManager.incBytecodes(2);
                                                    if (treeNode13 != null) {
                                                        treeNode14 = right4;
                                                        BytecodeManager.incBytecodes(3);
                                                    }
                                                    else {
                                                        treeNode14 = this;
                                                        BytecodeManager.incBytecodes(2);
                                                    }
                                                    BytecodeManager.incBytecodes(1);
                                                    break Label_0763;
                                                }
                                            }
                                            final TreeNode<K, V> treeNode15 = left3;
                                            BytecodeManager.incBytecodes(2);
                                            if (treeNode15 != null) {
                                                treeNode14 = left3;
                                                BytecodeManager.incBytecodes(3);
                                            }
                                            else {
                                                final TreeNode<K, V> treeNode16 = right2;
                                                BytecodeManager.incBytecodes(2);
                                                if (treeNode16 != null) {
                                                    treeNode14 = right2;
                                                    BytecodeManager.incBytecodes(3);
                                                }
                                                else {
                                                    treeNode14 = this;
                                                    BytecodeManager.incBytecodes(2);
                                                }
                                            }
                                        }
                                        final TreeNode<K, V> treeNode17 = treeNode14;
                                        BytecodeManager.incBytecodes(3);
                                        if (treeNode17 != this) {
                                            final TreeNode<K, V> treeNode18 = treeNode14;
                                            final TreeNode<K, V> parent6 = this.parent;
                                            treeNode18.parent = parent6;
                                            final TreeNode<K, V> treeNode19 = parent6;
                                            BytecodeManager.incBytecodes(6);
                                            final TreeNode<K, V> treeNode20 = treeNode19;
                                            BytecodeManager.incBytecodes(2);
                                            if (treeNode20 == null) {
                                                root = treeNode14;
                                                BytecodeManager.incBytecodes(3);
                                            }
                                            else {
                                                final TreeNode<K, V> left8 = treeNode19.left;
                                                BytecodeManager.incBytecodes(4);
                                                if (this == left8) {
                                                    treeNode19.left = treeNode14;
                                                    BytecodeManager.incBytecodes(4);
                                                }
                                                else {
                                                    treeNode19.right = treeNode14;
                                                    BytecodeManager.incBytecodes(3);
                                                }
                                            }
                                            final TreeNode<K, V> left9 = null;
                                            this.parent = left9;
                                            this.right = left9;
                                            this.left = left9;
                                            BytecodeManager.incBytecodes(9);
                                        }
                                        final boolean red2 = this.red;
                                        BytecodeManager.incBytecodes(3);
                                        TreeNode balanceDeletion;
                                        if (red2) {
                                            balanceDeletion = root;
                                            BytecodeManager.incBytecodes(2);
                                        }
                                        else {
                                            final TreeNode treeNode21 = root;
                                            final TreeNode<K, V> treeNode22 = treeNode14;
                                            BytecodeManager.incBytecodes(3);
                                            balanceDeletion = balanceDeletion(treeNode21, treeNode22);
                                        }
                                        final TreeNode treeNode23 = balanceDeletion;
                                        BytecodeManager.incBytecodes(1);
                                        final TreeNode<K, V> treeNode24 = treeNode14;
                                        BytecodeManager.incBytecodes(3);
                                        if (treeNode24 == this) {
                                            final TreeNode<K, V> parent7 = this.parent;
                                            BytecodeManager.incBytecodes(3);
                                            this.parent = null;
                                            BytecodeManager.incBytecodes(3);
                                            final TreeNode<K, V> treeNode25 = parent7;
                                            BytecodeManager.incBytecodes(2);
                                            if (treeNode25 != null) {
                                                final TreeNode<K, V> left10 = parent7.left;
                                                BytecodeManager.incBytecodes(4);
                                                if (this == left10) {
                                                    parent7.left = null;
                                                    BytecodeManager.incBytecodes(4);
                                                }
                                                else {
                                                    final TreeNode<K, V> right7 = parent7.right;
                                                    BytecodeManager.incBytecodes(4);
                                                    if (this == right7) {
                                                        parent7.right = null;
                                                        BytecodeManager.incBytecodes(3);
                                                    }
                                                }
                                            }
                                        }
                                        BytecodeManager.incBytecodes(2);
                                        if (b) {
                                            final TreeNode treeNode26 = treeNode23;
                                            BytecodeManager.incBytecodes(3);
                                            moveRootToFront(array, treeNode26);
                                        }
                                        BytecodeManager.incBytecodes(1);
                                        return;
                                    }
                                }
                            }
                        }
                        final int n2 = n;
                        final Node<K, V> node3 = node;
                        BytecodeManager.incBytecodes(5);
                        array[n2] = ((TreeNode)node3).untreeify(hashMap);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                        return;
                    }
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        final void split(final HashMap<K, V> hashMap, final Node<K, V>[] array, final int n, final int n2) {
            try {
                BytecodeManager.incBytecodes(2);
                TreeNode treeNode = null;
                TreeNode treeNode2 = null;
                BytecodeManager.incBytecodes(4);
                TreeNode treeNode3 = null;
                TreeNode treeNode4 = null;
                BytecodeManager.incBytecodes(4);
                int n3 = 0;
                int n4 = 0;
                BytecodeManager.incBytecodes(4);
                TreeNode treeNode5 = this;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final TreeNode<K, V> treeNode6 = (TreeNode<K, V>)treeNode5;
                    BytecodeManager.incBytecodes(2);
                    if (treeNode6 == null) {
                        break;
                    }
                    final TreeNode treeNode7 = (TreeNode)treeNode5.next;
                    BytecodeManager.incBytecodes(4);
                    treeNode5.next = null;
                    BytecodeManager.incBytecodes(3);
                    final int n5 = treeNode5.hash & n2;
                    BytecodeManager.incBytecodes(5);
                    if (n5 == 0) {
                        final TreeNode<K, V> treeNode8 = (TreeNode<K, V>)treeNode5;
                        final TreeNode prev = treeNode2;
                        treeNode8.prev = (TreeNode<K, V>)prev;
                        BytecodeManager.incBytecodes(5);
                        if (prev == null) {
                            treeNode = treeNode5;
                            BytecodeManager.incBytecodes(3);
                        }
                        else {
                            treeNode2.next = (Node<K, V>)treeNode5;
                            BytecodeManager.incBytecodes(3);
                        }
                        treeNode2 = treeNode5;
                        BytecodeManager.incBytecodes(2);
                        ++n3;
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        final TreeNode<K, V> treeNode9 = (TreeNode<K, V>)treeNode5;
                        final TreeNode prev2 = treeNode4;
                        treeNode9.prev = (TreeNode<K, V>)prev2;
                        BytecodeManager.incBytecodes(5);
                        if (prev2 == null) {
                            treeNode3 = treeNode5;
                            BytecodeManager.incBytecodes(3);
                        }
                        else {
                            treeNode4.next = (Node<K, V>)treeNode5;
                            BytecodeManager.incBytecodes(3);
                        }
                        treeNode4 = treeNode5;
                        BytecodeManager.incBytecodes(2);
                        ++n4;
                        BytecodeManager.incBytecodes(1);
                    }
                    treeNode5 = treeNode7;
                    BytecodeManager.incBytecodes(3);
                }
                final TreeNode treeNode10 = treeNode;
                BytecodeManager.incBytecodes(2);
                if (treeNode10 != null) {
                    final int n6 = n3;
                    final int n7 = 6;
                    BytecodeManager.incBytecodes(3);
                    if (n6 <= n7) {
                        final TreeNode treeNode11 = treeNode;
                        BytecodeManager.incBytecodes(5);
                        array[n] = treeNode11.untreeify(hashMap);
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        array[n] = treeNode;
                        BytecodeManager.incBytecodes(4);
                        final TreeNode treeNode12 = treeNode3;
                        BytecodeManager.incBytecodes(2);
                        if (treeNode12 != null) {
                            final TreeNode treeNode13 = treeNode;
                            BytecodeManager.incBytecodes(3);
                            treeNode13.treeify(array);
                        }
                    }
                }
                final TreeNode treeNode14 = treeNode3;
                BytecodeManager.incBytecodes(2);
                if (treeNode14 != null) {
                    final int n8 = n4;
                    final int n9 = 6;
                    BytecodeManager.incBytecodes(3);
                    if (n8 <= n9) {
                        final int n10 = n + n2;
                        final TreeNode treeNode15 = treeNode3;
                        BytecodeManager.incBytecodes(7);
                        array[n10] = treeNode15.untreeify(hashMap);
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        array[n + n2] = treeNode3;
                        BytecodeManager.incBytecodes(6);
                        final TreeNode treeNode16 = treeNode;
                        BytecodeManager.incBytecodes(2);
                        if (treeNode16 != null) {
                            final TreeNode treeNode17 = treeNode3;
                            BytecodeManager.incBytecodes(3);
                            treeNode17.treeify(array);
                        }
                    }
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static <K, V> TreeNode<K, V> rotateLeft(TreeNode<K, V> treeNode, final TreeNode<K, V> treeNode2) {
            try {
                BytecodeManager.incBytecodes(2);
                if (treeNode2 != null) {
                    final TreeNode<K, V> right;
                    final TreeNode<K, V> treeNode3 = right = treeNode2.right;
                    BytecodeManager.incBytecodes(5);
                    if (treeNode3 != null) {
                        final TreeNode<K, V> left = right.left;
                        treeNode2.right = left;
                        final TreeNode<K, V> treeNode4 = left;
                        BytecodeManager.incBytecodes(8);
                        if (left != null) {
                            treeNode4.parent = treeNode2;
                            BytecodeManager.incBytecodes(3);
                        }
                        final TreeNode<K, V> treeNode5 = right;
                        final TreeNode<K, V> parent = treeNode2.parent;
                        treeNode5.parent = parent;
                        final TreeNode<K, V> treeNode6 = parent;
                        BytecodeManager.incBytecodes(8);
                        if (parent == null) {
                            (treeNode = right).red = false;
                            BytecodeManager.incBytecodes(6);
                        }
                        else {
                            final TreeNode<K, V> left2 = treeNode6.left;
                            BytecodeManager.incBytecodes(4);
                            if (left2 == treeNode2) {
                                treeNode6.left = right;
                                BytecodeManager.incBytecodes(4);
                            }
                            else {
                                treeNode6.right = right;
                                BytecodeManager.incBytecodes(3);
                            }
                        }
                        right.left = treeNode2;
                        BytecodeManager.incBytecodes(3);
                        treeNode2.parent = right;
                        BytecodeManager.incBytecodes(3);
                    }
                }
                final TreeNode<K, V> treeNode7 = treeNode;
                BytecodeManager.incBytecodes(2);
                return treeNode7;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static <K, V> TreeNode<K, V> rotateRight(TreeNode<K, V> treeNode, final TreeNode<K, V> treeNode2) {
            try {
                BytecodeManager.incBytecodes(2);
                if (treeNode2 != null) {
                    final TreeNode<K, V> left;
                    final TreeNode<K, V> treeNode3 = left = treeNode2.left;
                    BytecodeManager.incBytecodes(5);
                    if (treeNode3 != null) {
                        final TreeNode<K, V> right = left.right;
                        treeNode2.left = right;
                        final TreeNode<K, V> treeNode4 = right;
                        BytecodeManager.incBytecodes(8);
                        if (right != null) {
                            treeNode4.parent = treeNode2;
                            BytecodeManager.incBytecodes(3);
                        }
                        final TreeNode<K, V> treeNode5 = left;
                        final TreeNode<K, V> parent = treeNode2.parent;
                        treeNode5.parent = parent;
                        final TreeNode<K, V> treeNode6 = parent;
                        BytecodeManager.incBytecodes(8);
                        if (parent == null) {
                            (treeNode = left).red = false;
                            BytecodeManager.incBytecodes(6);
                        }
                        else {
                            final TreeNode<K, V> right2 = treeNode6.right;
                            BytecodeManager.incBytecodes(4);
                            if (right2 == treeNode2) {
                                treeNode6.right = left;
                                BytecodeManager.incBytecodes(4);
                            }
                            else {
                                treeNode6.left = left;
                                BytecodeManager.incBytecodes(3);
                            }
                        }
                        left.right = treeNode2;
                        BytecodeManager.incBytecodes(3);
                        treeNode2.parent = left;
                        BytecodeManager.incBytecodes(3);
                    }
                }
                final TreeNode<K, V> treeNode7 = treeNode;
                BytecodeManager.incBytecodes(2);
                return treeNode7;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static <K, V> TreeNode<K, V> balanceInsertion(TreeNode<K, V> treeNode, TreeNode<K, V> treeNode2) {
            try {
                treeNode2.red = true;
                BytecodeManager.incBytecodes(3);
                while (true) {
                    LinkedHashMap.Entry<K, V> entry;
                    final TreeNode<K, V> treeNode3 = (TreeNode<K, V>)(entry = treeNode2.parent);
                    BytecodeManager.incBytecodes(5);
                    if (treeNode3 == null) {
                        treeNode2.red = false;
                        BytecodeManager.incBytecodes(3);
                        final TreeNode treeNode4 = treeNode2;
                        BytecodeManager.incBytecodes(2);
                        return (TreeNode<K, V>)treeNode4;
                    }
                    final boolean red = ((TreeNode)entry).red;
                    BytecodeManager.incBytecodes(3);
                    if (!red) {
                        break;
                    }
                    Object parent;
                    final TreeNode<K, V> treeNode5 = (TreeNode<K, V>)(parent = ((TreeNode)entry).parent);
                    BytecodeManager.incBytecodes(5);
                    if (treeNode5 == null) {
                        break;
                    }
                    final TreeNode treeNode6 = (TreeNode)entry;
                    final LinkedHashMap.Entry<K, V> left;
                    final TreeNode<K, V> treeNode7 = (TreeNode<K, V>)(left = ((TreeNode)parent).left);
                    BytecodeManager.incBytecodes(6);
                    if (treeNode6 == treeNode7) {
                        final LinkedHashMap.Entry<K, V> right;
                        final TreeNode<K, V> treeNode8 = (TreeNode<K, V>)(right = ((TreeNode)parent).right);
                        BytecodeManager.incBytecodes(5);
                        if (treeNode8 != null) {
                            final boolean red2 = ((TreeNode)right).red;
                            BytecodeManager.incBytecodes(3);
                            if (red2) {
                                ((TreeNode)right).red = false;
                                BytecodeManager.incBytecodes(3);
                                ((TreeNode)entry).red = false;
                                BytecodeManager.incBytecodes(3);
                                ((TreeNode)parent).red = true;
                                BytecodeManager.incBytecodes(3);
                                treeNode2 = (TreeNode)parent;
                                BytecodeManager.incBytecodes(3);
                                continue;
                            }
                        }
                        final TreeNode<K, V> treeNode9 = (TreeNode<K, V>)treeNode2;
                        final TreeNode<K, V> right2 = ((TreeNode)entry).right;
                        BytecodeManager.incBytecodes(4);
                        if (treeNode9 == right2) {
                            final TreeNode<Object, Object> treeNode10 = treeNode;
                            final TreeNode<K, V> treeNode11 = (TreeNode<K, V>)(treeNode2 = (TreeNode)entry);
                            BytecodeManager.incBytecodes(5);
                            treeNode = rotateLeft(treeNode10, (TreeNode<Object, Object>)treeNode11);
                            BytecodeManager.incBytecodes(1);
                            final TreeNode<K, V> treeNode12 = (TreeNode<K, V>)(entry = treeNode2.parent);
                            BytecodeManager.incBytecodes(5);
                            TreeNode<K, V> parent2;
                            if (treeNode12 == null) {
                                parent2 = null;
                                BytecodeManager.incBytecodes(2);
                            }
                            else {
                                parent2 = (TreeNode<K, V>)((TreeNode)entry).parent;
                                BytecodeManager.incBytecodes(2);
                            }
                            parent = parent2;
                            BytecodeManager.incBytecodes(1);
                        }
                        final TreeNode treeNode13 = (TreeNode)entry;
                        BytecodeManager.incBytecodes(2);
                        if (treeNode13 == null) {
                            continue;
                        }
                        ((TreeNode)entry).red = false;
                        BytecodeManager.incBytecodes(3);
                        final TreeNode treeNode14 = (TreeNode)parent;
                        BytecodeManager.incBytecodes(2);
                        if (treeNode14 == null) {
                            continue;
                        }
                        ((TreeNode)parent).red = true;
                        BytecodeManager.incBytecodes(3);
                        final TreeNode<Object, Object> treeNode15 = treeNode;
                        final TreeNode treeNode16 = (TreeNode)parent;
                        BytecodeManager.incBytecodes(3);
                        treeNode = rotateRight(treeNode15, treeNode16);
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        final LinkedHashMap.Entry<K, V> entry2 = left;
                        BytecodeManager.incBytecodes(2);
                        if (entry2 != null) {
                            final boolean red3 = ((TreeNode)left).red;
                            BytecodeManager.incBytecodes(3);
                            if (red3) {
                                ((TreeNode)left).red = false;
                                BytecodeManager.incBytecodes(3);
                                ((TreeNode)entry).red = false;
                                BytecodeManager.incBytecodes(3);
                                ((TreeNode)parent).red = true;
                                BytecodeManager.incBytecodes(3);
                                treeNode2 = (TreeNode)parent;
                                BytecodeManager.incBytecodes(3);
                                continue;
                            }
                        }
                        final TreeNode<K, V> treeNode17 = (TreeNode<K, V>)treeNode2;
                        final TreeNode<K, V> left2 = ((TreeNode)entry).left;
                        BytecodeManager.incBytecodes(4);
                        if (treeNode17 == left2) {
                            final TreeNode<Object, Object> treeNode18 = treeNode;
                            final TreeNode<K, V> treeNode19 = (TreeNode<K, V>)(treeNode2 = (TreeNode)entry);
                            BytecodeManager.incBytecodes(5);
                            treeNode = rotateRight(treeNode18, (TreeNode<Object, Object>)treeNode19);
                            BytecodeManager.incBytecodes(1);
                            final TreeNode<K, V> treeNode20 = (TreeNode<K, V>)(entry = treeNode2.parent);
                            BytecodeManager.incBytecodes(5);
                            TreeNode<K, V> parent3;
                            if (treeNode20 == null) {
                                parent3 = null;
                                BytecodeManager.incBytecodes(2);
                            }
                            else {
                                parent3 = (TreeNode<K, V>)((TreeNode)entry).parent;
                                BytecodeManager.incBytecodes(2);
                            }
                            parent = parent3;
                            BytecodeManager.incBytecodes(1);
                        }
                        final TreeNode treeNode21 = (TreeNode)entry;
                        BytecodeManager.incBytecodes(2);
                        if (treeNode21 == null) {
                            continue;
                        }
                        ((TreeNode)entry).red = false;
                        BytecodeManager.incBytecodes(3);
                        final TreeNode treeNode22 = (TreeNode)parent;
                        BytecodeManager.incBytecodes(2);
                        if (treeNode22 == null) {
                            continue;
                        }
                        ((TreeNode)parent).red = true;
                        BytecodeManager.incBytecodes(3);
                        final TreeNode<Object, Object> treeNode23 = treeNode;
                        final TreeNode treeNode24 = (TreeNode)parent;
                        BytecodeManager.incBytecodes(3);
                        treeNode = rotateLeft(treeNode23, treeNode24);
                        BytecodeManager.incBytecodes(2);
                    }
                }
                final TreeNode<Object, Object> treeNode25 = treeNode;
                BytecodeManager.incBytecodes(2);
                return (TreeNode<K, V>)treeNode25;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static <K, V> TreeNode<K, V> balanceDeletion(TreeNode<K, V> treeNode, TreeNode<K, V> treeNode2) {
            try {
                Block_3: {
                    Block_2: {
                        while (true) {
                            final TreeNode<Object, Object> treeNode3 = treeNode2;
                            BytecodeManager.incBytecodes(2);
                            if (treeNode3 == null) {
                                break;
                            }
                            final TreeNode<Object, Object> treeNode4 = treeNode2;
                            final TreeNode<Object, Object> treeNode5 = treeNode;
                            BytecodeManager.incBytecodes(3);
                            if (treeNode4 == treeNode5) {
                                break;
                            }
                            TreeNode<Object, Object> treeNode7;
                            final TreeNode<Object, Object> treeNode6 = treeNode7 = treeNode2.parent;
                            BytecodeManager.incBytecodes(5);
                            if (treeNode6 == null) {
                                break Block_2;
                            }
                            final boolean red = treeNode2.red;
                            BytecodeManager.incBytecodes(3);
                            if (red) {
                                break Block_3;
                            }
                            TreeNode<Object, Object> left;
                            final TreeNode<Object, Object> treeNode8 = left = treeNode7.left;
                            final TreeNode<Object, Object> treeNode9 = treeNode2;
                            BytecodeManager.incBytecodes(6);
                            if (treeNode8 == treeNode9) {
                                TreeNode<Object, Object> right;
                                final TreeNode<Object, Object> treeNode10 = right = treeNode7.right;
                                BytecodeManager.incBytecodes(5);
                                if (treeNode10 != null) {
                                    final boolean red2 = right.red;
                                    BytecodeManager.incBytecodes(3);
                                    if (red2) {
                                        right.red = false;
                                        BytecodeManager.incBytecodes(3);
                                        treeNode7.red = true;
                                        BytecodeManager.incBytecodes(3);
                                        final TreeNode<Object, Object> treeNode11 = treeNode;
                                        final TreeNode<Object, Object> treeNode12 = treeNode7;
                                        BytecodeManager.incBytecodes(3);
                                        treeNode = rotateLeft(treeNode11, treeNode12);
                                        BytecodeManager.incBytecodes(1);
                                        final TreeNode<Object, Object> treeNode13 = treeNode7 = treeNode2.parent;
                                        BytecodeManager.incBytecodes(5);
                                        TreeNode<Object, Object> right2;
                                        if (treeNode13 == null) {
                                            right2 = null;
                                            BytecodeManager.incBytecodes(2);
                                        }
                                        else {
                                            right2 = treeNode7.right;
                                            BytecodeManager.incBytecodes(2);
                                        }
                                        right = right2;
                                        BytecodeManager.incBytecodes(1);
                                    }
                                }
                                final TreeNode<Object, Object> treeNode14 = right;
                                BytecodeManager.incBytecodes(2);
                                if (treeNode14 == null) {
                                    treeNode2 = treeNode7;
                                    BytecodeManager.incBytecodes(3);
                                }
                                else {
                                    final TreeNode<Object, Object> left2 = right.left;
                                    final TreeNode<Object, Object> right3 = right.right;
                                    BytecodeManager.incBytecodes(6);
                                    final TreeNode<Object, Object> treeNode15 = right3;
                                    BytecodeManager.incBytecodes(2);
                                    Label_0538: {
                                        Label_0311: {
                                            if (treeNode15 != null) {
                                                final boolean red3 = right3.red;
                                                BytecodeManager.incBytecodes(3);
                                                if (red3) {
                                                    break Label_0311;
                                                }
                                            }
                                            final TreeNode<Object, Object> treeNode16 = left2;
                                            BytecodeManager.incBytecodes(2);
                                            if (treeNode16 != null) {
                                                final boolean red4 = left2.red;
                                                BytecodeManager.incBytecodes(3);
                                                if (red4) {
                                                    break Label_0311;
                                                }
                                            }
                                            right.red = true;
                                            BytecodeManager.incBytecodes(3);
                                            treeNode2 = treeNode7;
                                            BytecodeManager.incBytecodes(3);
                                            break Label_0538;
                                        }
                                        final TreeNode<Object, Object> treeNode17 = right3;
                                        BytecodeManager.incBytecodes(2);
                                        Label_0422: {
                                            if (treeNode17 != null) {
                                                final boolean red5 = right3.red;
                                                BytecodeManager.incBytecodes(3);
                                                if (red5) {
                                                    break Label_0422;
                                                }
                                            }
                                            final TreeNode<Object, Object> treeNode18 = left2;
                                            BytecodeManager.incBytecodes(2);
                                            if (treeNode18 != null) {
                                                left2.red = false;
                                                BytecodeManager.incBytecodes(3);
                                            }
                                            right.red = true;
                                            BytecodeManager.incBytecodes(3);
                                            final TreeNode<Object, Object> treeNode19 = treeNode;
                                            final TreeNode<Object, Object> treeNode20 = right;
                                            BytecodeManager.incBytecodes(3);
                                            treeNode = rotateRight(treeNode19, treeNode20);
                                            BytecodeManager.incBytecodes(1);
                                            final TreeNode<Object, Object> treeNode21 = treeNode7 = treeNode2.parent;
                                            BytecodeManager.incBytecodes(5);
                                            TreeNode<Object, Object> right4;
                                            if (treeNode21 == null) {
                                                right4 = null;
                                                BytecodeManager.incBytecodes(2);
                                            }
                                            else {
                                                right4 = treeNode7.right;
                                                BytecodeManager.incBytecodes(2);
                                            }
                                            right = right4;
                                            BytecodeManager.incBytecodes(1);
                                        }
                                        final TreeNode<Object, Object> treeNode22 = right;
                                        BytecodeManager.incBytecodes(2);
                                        if (treeNode22 != null) {
                                            final TreeNode<Object, Object> treeNode23 = right;
                                            final TreeNode<Object, Object> treeNode24 = treeNode7;
                                            BytecodeManager.incBytecodes(3);
                                            boolean red6;
                                            if (treeNode24 == null) {
                                                red6 = false;
                                                BytecodeManager.incBytecodes(2);
                                            }
                                            else {
                                                red6 = treeNode7.red;
                                                BytecodeManager.incBytecodes(2);
                                            }
                                            treeNode23.red = red6;
                                            BytecodeManager.incBytecodes(1);
                                            final TreeNode<Object, Object> right5 = right.right;
                                            BytecodeManager.incBytecodes(5);
                                            if (right5 != null) {
                                                right5.red = false;
                                                BytecodeManager.incBytecodes(3);
                                            }
                                        }
                                        final TreeNode<Object, Object> treeNode25 = treeNode7;
                                        BytecodeManager.incBytecodes(2);
                                        if (treeNode25 != null) {
                                            treeNode7.red = false;
                                            BytecodeManager.incBytecodes(3);
                                            final TreeNode<Object, Object> treeNode26 = treeNode;
                                            final TreeNode<Object, Object> treeNode27 = treeNode7;
                                            BytecodeManager.incBytecodes(3);
                                            treeNode = rotateLeft(treeNode26, treeNode27);
                                            BytecodeManager.incBytecodes(1);
                                        }
                                        treeNode2 = treeNode;
                                        BytecodeManager.incBytecodes(2);
                                    }
                                    BytecodeManager.incBytecodes(1);
                                }
                            }
                            else {
                                final TreeNode<Object, Object> treeNode28 = left;
                                BytecodeManager.incBytecodes(2);
                                if (treeNode28 != null) {
                                    final boolean red7 = left.red;
                                    BytecodeManager.incBytecodes(3);
                                    if (red7) {
                                        left.red = false;
                                        BytecodeManager.incBytecodes(3);
                                        treeNode7.red = true;
                                        BytecodeManager.incBytecodes(3);
                                        final TreeNode<Object, Object> treeNode29 = treeNode;
                                        final TreeNode<Object, Object> treeNode30 = treeNode7;
                                        BytecodeManager.incBytecodes(3);
                                        treeNode = rotateRight(treeNode29, treeNode30);
                                        BytecodeManager.incBytecodes(1);
                                        final TreeNode<Object, Object> treeNode31 = treeNode7 = treeNode2.parent;
                                        BytecodeManager.incBytecodes(5);
                                        TreeNode<Object, Object> left3;
                                        if (treeNode31 == null) {
                                            left3 = null;
                                            BytecodeManager.incBytecodes(2);
                                        }
                                        else {
                                            left3 = treeNode7.left;
                                            BytecodeManager.incBytecodes(2);
                                        }
                                        left = left3;
                                        BytecodeManager.incBytecodes(1);
                                    }
                                }
                                final TreeNode<Object, Object> treeNode32 = left;
                                BytecodeManager.incBytecodes(2);
                                if (treeNode32 == null) {
                                    treeNode2 = treeNode7;
                                    BytecodeManager.incBytecodes(3);
                                }
                                else {
                                    final TreeNode<Object, Object> left4 = left.left;
                                    final TreeNode<Object, Object> right6 = left.right;
                                    BytecodeManager.incBytecodes(6);
                                    final TreeNode<Object, Object> treeNode33 = left4;
                                    BytecodeManager.incBytecodes(2);
                                    Label_0964: {
                                        Label_0743: {
                                            if (treeNode33 != null) {
                                                final boolean red8 = left4.red;
                                                BytecodeManager.incBytecodes(3);
                                                if (red8) {
                                                    break Label_0743;
                                                }
                                            }
                                            final TreeNode<Object, Object> treeNode34 = right6;
                                            BytecodeManager.incBytecodes(2);
                                            if (treeNode34 != null) {
                                                final boolean red9 = right6.red;
                                                BytecodeManager.incBytecodes(3);
                                                if (red9) {
                                                    break Label_0743;
                                                }
                                            }
                                            left.red = true;
                                            BytecodeManager.incBytecodes(3);
                                            treeNode2 = treeNode7;
                                            BytecodeManager.incBytecodes(3);
                                            break Label_0964;
                                        }
                                        final TreeNode<Object, Object> treeNode35 = left4;
                                        BytecodeManager.incBytecodes(2);
                                        Label_0851: {
                                            if (treeNode35 != null) {
                                                final boolean red10 = left4.red;
                                                BytecodeManager.incBytecodes(3);
                                                if (red10) {
                                                    break Label_0851;
                                                }
                                            }
                                            final TreeNode<Object, Object> treeNode36 = right6;
                                            BytecodeManager.incBytecodes(2);
                                            if (treeNode36 != null) {
                                                right6.red = false;
                                                BytecodeManager.incBytecodes(3);
                                            }
                                            left.red = true;
                                            BytecodeManager.incBytecodes(3);
                                            final TreeNode<Object, Object> treeNode37 = treeNode;
                                            final TreeNode<Object, Object> treeNode38 = left;
                                            BytecodeManager.incBytecodes(3);
                                            treeNode = rotateLeft(treeNode37, treeNode38);
                                            BytecodeManager.incBytecodes(1);
                                            final TreeNode<Object, Object> treeNode39 = treeNode7 = treeNode2.parent;
                                            BytecodeManager.incBytecodes(5);
                                            TreeNode<Object, Object> left5;
                                            if (treeNode39 == null) {
                                                left5 = null;
                                                BytecodeManager.incBytecodes(2);
                                            }
                                            else {
                                                left5 = treeNode7.left;
                                                BytecodeManager.incBytecodes(2);
                                            }
                                            left = left5;
                                            BytecodeManager.incBytecodes(1);
                                        }
                                        final TreeNode<Object, Object> treeNode40 = left;
                                        BytecodeManager.incBytecodes(2);
                                        if (treeNode40 != null) {
                                            final TreeNode<Object, Object> treeNode41 = left;
                                            final TreeNode<Object, Object> treeNode42 = treeNode7;
                                            BytecodeManager.incBytecodes(3);
                                            boolean red11;
                                            if (treeNode42 == null) {
                                                red11 = false;
                                                BytecodeManager.incBytecodes(2);
                                            }
                                            else {
                                                red11 = treeNode7.red;
                                                BytecodeManager.incBytecodes(2);
                                            }
                                            treeNode41.red = red11;
                                            BytecodeManager.incBytecodes(1);
                                            final TreeNode<Object, Object> left6 = left.left;
                                            BytecodeManager.incBytecodes(5);
                                            if (left6 != null) {
                                                left6.red = false;
                                                BytecodeManager.incBytecodes(3);
                                            }
                                        }
                                        final TreeNode<Object, Object> treeNode43 = treeNode7;
                                        BytecodeManager.incBytecodes(2);
                                        if (treeNode43 != null) {
                                            treeNode7.red = false;
                                            BytecodeManager.incBytecodes(3);
                                            final TreeNode<Object, Object> treeNode44 = treeNode;
                                            final TreeNode<Object, Object> treeNode45 = treeNode7;
                                            BytecodeManager.incBytecodes(3);
                                            treeNode = rotateRight(treeNode44, treeNode45);
                                            BytecodeManager.incBytecodes(1);
                                        }
                                        treeNode2 = treeNode;
                                        BytecodeManager.incBytecodes(2);
                                    }
                                    BytecodeManager.incBytecodes(1);
                                }
                            }
                        }
                        final TreeNode<Object, Object> treeNode46 = treeNode;
                        BytecodeManager.incBytecodes(2);
                        return (TreeNode<K, V>)treeNode46;
                    }
                    treeNode2.red = false;
                    BytecodeManager.incBytecodes(3);
                    final TreeNode<Object, Object> treeNode47 = treeNode2;
                    BytecodeManager.incBytecodes(2);
                    return (TreeNode<K, V>)treeNode47;
                }
                treeNode2.red = false;
                BytecodeManager.incBytecodes(3);
                final TreeNode<K, V> treeNode48 = (TreeNode<K, V>)treeNode;
                BytecodeManager.incBytecodes(2);
                return treeNode48;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static <K, V> boolean checkInvariants(final TreeNode<K, V> treeNode) {
            try {
                final TreeNode<K, V> parent = treeNode.parent;
                final TreeNode<K, V> left = treeNode.left;
                final TreeNode<K, V> right = treeNode.right;
                BytecodeManager.incBytecodes(9);
                final TreeNode<K, V> prev = treeNode.prev;
                final TreeNode treeNode2 = (TreeNode)treeNode.next;
                BytecodeManager.incBytecodes(7);
                final TreeNode<K, V> treeNode3 = prev;
                BytecodeManager.incBytecodes(2);
                if (treeNode3 != null) {
                    final Node<K, V> next = prev.next;
                    BytecodeManager.incBytecodes(4);
                    if (next != treeNode) {
                        final boolean b = false;
                        BytecodeManager.incBytecodes(2);
                        return b;
                    }
                }
                final TreeNode treeNode4 = treeNode2;
                BytecodeManager.incBytecodes(2);
                if (treeNode4 != null) {
                    final TreeNode<K, V> prev2 = treeNode2.prev;
                    BytecodeManager.incBytecodes(4);
                    if (prev2 != treeNode) {
                        final boolean b2 = false;
                        BytecodeManager.incBytecodes(2);
                        return b2;
                    }
                }
                final TreeNode<K, V> treeNode5 = parent;
                BytecodeManager.incBytecodes(2);
                if (treeNode5 != null) {
                    final TreeNode<K, V> left2 = parent.left;
                    BytecodeManager.incBytecodes(4);
                    if (treeNode != left2) {
                        final TreeNode<K, V> right2 = parent.right;
                        BytecodeManager.incBytecodes(4);
                        if (treeNode != right2) {
                            final boolean b3 = false;
                            BytecodeManager.incBytecodes(2);
                            return b3;
                        }
                    }
                }
                final TreeNode<K, V> treeNode6 = left;
                BytecodeManager.incBytecodes(2);
                Label_0189: {
                    if (treeNode6 != null) {
                        final TreeNode<K, V> parent2 = left.parent;
                        BytecodeManager.incBytecodes(4);
                        if (parent2 == treeNode) {
                            final int hash = left.hash;
                            final int hash2 = treeNode.hash;
                            BytecodeManager.incBytecodes(5);
                            if (hash <= hash2) {
                                break Label_0189;
                            }
                        }
                        final boolean b4 = false;
                        BytecodeManager.incBytecodes(2);
                        return b4;
                    }
                }
                final TreeNode<K, V> treeNode7 = right;
                BytecodeManager.incBytecodes(2);
                Label_0234: {
                    if (treeNode7 != null) {
                        final TreeNode<K, V> parent3 = right.parent;
                        BytecodeManager.incBytecodes(4);
                        if (parent3 == treeNode) {
                            final int hash3 = right.hash;
                            final int hash4 = treeNode.hash;
                            BytecodeManager.incBytecodes(5);
                            if (hash3 >= hash4) {
                                break Label_0234;
                            }
                        }
                        final boolean b5 = false;
                        BytecodeManager.incBytecodes(2);
                        return b5;
                    }
                }
                final boolean red = treeNode.red;
                BytecodeManager.incBytecodes(3);
                if (red) {
                    final TreeNode<K, V> treeNode8 = left;
                    BytecodeManager.incBytecodes(2);
                    if (treeNode8 != null) {
                        final boolean red2 = left.red;
                        BytecodeManager.incBytecodes(3);
                        if (red2) {
                            final TreeNode<K, V> treeNode9 = right;
                            BytecodeManager.incBytecodes(2);
                            if (treeNode9 != null) {
                                final boolean red3 = right.red;
                                BytecodeManager.incBytecodes(3);
                                if (red3) {
                                    final boolean b6 = false;
                                    BytecodeManager.incBytecodes(2);
                                    return b6;
                                }
                            }
                        }
                    }
                }
                final TreeNode<K, V> treeNode10 = left;
                BytecodeManager.incBytecodes(2);
                if (treeNode10 != null) {
                    final TreeNode<K, V> treeNode11 = left;
                    BytecodeManager.incBytecodes(2);
                    final boolean checkInvariants = checkInvariants((TreeNode<Object, Object>)treeNode11);
                    BytecodeManager.incBytecodes(1);
                    if (!checkInvariants) {
                        final boolean b7 = false;
                        BytecodeManager.incBytecodes(2);
                        return b7;
                    }
                }
                final TreeNode<K, V> treeNode12 = right;
                BytecodeManager.incBytecodes(2);
                if (treeNode12 != null) {
                    final TreeNode<K, V> treeNode13 = right;
                    BytecodeManager.incBytecodes(2);
                    final boolean checkInvariants2 = checkInvariants((TreeNode<Object, Object>)treeNode13);
                    BytecodeManager.incBytecodes(1);
                    if (!checkInvariants2) {
                        final boolean b8 = false;
                        BytecodeManager.incBytecodes(2);
                        return b8;
                    }
                }
                final boolean b9 = true;
                BytecodeManager.incBytecodes(2);
                return b9;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static {
            try {
                final Class<HashMap> clazz = HashMap.class;
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
    }
}
