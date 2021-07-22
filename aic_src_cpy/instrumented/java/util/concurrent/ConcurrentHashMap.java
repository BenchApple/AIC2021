// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.concurrent;

import java.lang.reflect.Array;
import instrumented.java.util.Arrays;
import instrumented.java.util.Spliterator;
import instrumented.java.util.NoSuchElementException;
import instrumented.java.util.concurrent.locks.LockSupport;
import sun.misc.Contended;
import instrumented.java.util.concurrent.locks.ReentrantLock;
import instrumented.java.util.function.ToIntFunction;
import instrumented.java.util.function.ToLongFunction;
import instrumented.java.util.function.ToDoubleFunction;
import instrumented.java.util.function.IntBinaryOperator;
import instrumented.java.util.function.ToIntBiFunction;
import instrumented.java.util.function.LongBinaryOperator;
import instrumented.java.util.function.ToLongBiFunction;
import instrumented.java.util.function.DoubleBinaryOperator;
import instrumented.java.util.function.ToDoubleBiFunction;
import instrumented.java.util.concurrent.atomic.AtomicReference;
import instrumented.java.util.function.Consumer;
import instrumented.java.util.Enumeration;
import instrumented.java.util.function.Function;
import instrumented.java.util.function.BiFunction;
import instrumented.java.util.function.BiConsumer;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import instrumented.java.util.Collection;
import java.util.Iterator;
import instrumented.java.util.Set;
import instrumented.java.util.Map;
import java.lang.reflect.Type;
import java.lang.reflect.ParameterizedType;
import aic2021.engine.BytecodeManager;
import sun.misc.Unsafe;
import java.io.ObjectStreamField;
import java.io.Serializable;
import instrumented.java.util.AbstractMap;

public class ConcurrentHashMap<K, V> extends AbstractMap<K, V> implements ConcurrentMap<K, V>, Serializable
{
    private static final long serialVersionUID = 7249069246763182397L;
    private static final int MAXIMUM_CAPACITY = 1073741824;
    private static final int DEFAULT_CAPACITY = 16;
    static final int MAX_ARRAY_SIZE = 2147483639;
    private static final int DEFAULT_CONCURRENCY_LEVEL = 16;
    private static final float LOAD_FACTOR = 0.75f;
    static final int TREEIFY_THRESHOLD = 8;
    static final int UNTREEIFY_THRESHOLD = 6;
    static final int MIN_TREEIFY_CAPACITY = 64;
    private static final int MIN_TRANSFER_STRIDE = 16;
    private static int RESIZE_STAMP_BITS;
    private static final int MAX_RESIZERS;
    private static final int RESIZE_STAMP_SHIFT;
    static final int MOVED = -1;
    static final int TREEBIN = -2;
    static final int RESERVED = -3;
    static final int HASH_BITS = Integer.MAX_VALUE;
    static final int NCPU;
    private static final ObjectStreamField[] serialPersistentFields;
    transient volatile Node<K, V>[] table;
    private transient volatile Node<K, V>[] nextTable;
    private transient volatile long baseCount;
    private transient volatile int sizeCtl;
    private transient volatile int transferIndex;
    private transient volatile int cellsBusy;
    private transient volatile CounterCell[] counterCells;
    private transient KeySetView<K, V> keySet;
    private transient ValuesView<K, V> values;
    private transient EntrySetView<K, V> entrySet;
    private static final Unsafe U;
    private static final long SIZECTL;
    private static final long TRANSFERINDEX;
    private static final long BASECOUNT;
    private static final long CELLSBUSY;
    private static final long CELLVALUE;
    private static final long ABASE;
    private static final int ASHIFT;
    
    static final int spread(final int n) {
        try {
            final int n2 = (n ^ n >>> 16) & Integer.MAX_VALUE;
            BytecodeManager.incBytecodes(8);
            return n2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static final int tableSizeFor(final int n) {
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
            Label_0062: {
                if (o2 != null) {
                    BytecodeManager.incBytecodes(2);
                    final Class<?> class1 = o2.getClass();
                    BytecodeManager.incBytecodes(2);
                    if (class1 == clazz) {
                        final Comparable comparable = (Comparable)o;
                        BytecodeManager.incBytecodes(3);
                        BytecodeManager.incBytecodes(1);
                        compareTo = comparable.compareTo(o2);
                        break Label_0062;
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
    
    static final <K, V> Node<K, V> tabAt(final Node<K, V>[] o, final int n) {
        try {
            final Unsafe u = ConcurrentHashMap.U;
            final long offset = ((long)n << ConcurrentHashMap.ASHIFT) + ConcurrentHashMap.ABASE;
            BytecodeManager.incBytecodes(9);
            final Node node = (Node)u.getObjectVolatile(o, offset);
            BytecodeManager.incBytecodes(2);
            return (Node<K, V>)node;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static final <K, V> boolean casTabAt(final Node<K, V>[] o, final int n, final Node<K, V> expected, final Node<K, V> x) {
        try {
            final Unsafe u = ConcurrentHashMap.U;
            final long offset = ((long)n << ConcurrentHashMap.ASHIFT) + ConcurrentHashMap.ABASE;
            BytecodeManager.incBytecodes(11);
            final boolean compareAndSwapObject = u.compareAndSwapObject(o, offset, expected, x);
            BytecodeManager.incBytecodes(1);
            return compareAndSwapObject;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static final <K, V> void setTabAt(final Node<K, V>[] o, final int n, final Node<K, V> x) {
        try {
            final Unsafe u = ConcurrentHashMap.U;
            final long offset = ((long)n << ConcurrentHashMap.ASHIFT) + ConcurrentHashMap.ABASE;
            BytecodeManager.incBytecodes(10);
            u.putObjectVolatile(o, offset, x);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public ConcurrentHashMap() {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public ConcurrentHashMap(final int n) {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            if (n < 0) {
                BytecodeManager.incBytecodes(3);
                final IllegalArgumentException ex = new IllegalArgumentException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final int n2 = 536870912;
            BytecodeManager.incBytecodes(3);
            int tableSize;
            if (n >= n2) {
                tableSize = 1073741824;
                BytecodeManager.incBytecodes(2);
            }
            else {
                final int n3 = n + (n >>> 1) + 1;
                BytecodeManager.incBytecodes(7);
                BytecodeManager.incBytecodes(1);
                tableSize = tableSizeFor(n3);
            }
            final int sizeCtl = tableSize;
            BytecodeManager.incBytecodes(1);
            this.sizeCtl = sizeCtl;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public ConcurrentHashMap(final Map<? extends K, ? extends V> map) {
        try {
            BytecodeManager.incBytecodes(2);
            this.sizeCtl = 16;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(3);
            this.putAll(map);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public ConcurrentHashMap(final int n, final float n2) {
        try {
            final int n3 = 1;
            BytecodeManager.incBytecodes(5);
            this(n, n2, n3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public ConcurrentHashMap(int n, final float n2, final int n3) {
        try {
            BytecodeManager.incBytecodes(2);
            final float n4 = fcmpl(n2, 0.0f);
            BytecodeManager.incBytecodes(4);
            if (n4 > 0) {
                final int n5 = n;
                BytecodeManager.incBytecodes(2);
                if (n5 >= 0) {
                    BytecodeManager.incBytecodes(2);
                    if (n3 > 0) {
                        final int n6 = n;
                        BytecodeManager.incBytecodes(3);
                        if (n6 < n3) {
                            n = n3;
                            BytecodeManager.incBytecodes(2);
                        }
                        final long n7 = (long)(1.0 + n / n2);
                        BytecodeManager.incBytecodes(10);
                        final long n8 = lcmp(n7, 1073741824L);
                        BytecodeManager.incBytecodes(4);
                        int tableSize;
                        if (n8 >= 0) {
                            tableSize = 1073741824;
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            final int n9 = (int)n7;
                            BytecodeManager.incBytecodes(2);
                            BytecodeManager.incBytecodes(1);
                            tableSize = tableSizeFor(n9);
                        }
                        final int sizeCtl = tableSize;
                        BytecodeManager.incBytecodes(1);
                        this.sizeCtl = sizeCtl;
                        BytecodeManager.incBytecodes(3);
                        BytecodeManager.incBytecodes(1);
                        return;
                    }
                }
            }
            BytecodeManager.incBytecodes(3);
            final IllegalArgumentException ex = new IllegalArgumentException();
            BytecodeManager.incBytecodes(1);
            throw ex;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public int size() {
        try {
            BytecodeManager.incBytecodes(2);
            final long sumCount = this.sumCount();
            BytecodeManager.incBytecodes(1);
            final long n = lcmp(sumCount, 0L);
            BytecodeManager.incBytecodes(4);
            int n2;
            if (n < 0) {
                n2 = 0;
                BytecodeManager.incBytecodes(2);
            }
            else {
                final long n3 = lcmp(sumCount, 2147483647L);
                BytecodeManager.incBytecodes(4);
                if (n3 > 0) {
                    n2 = Integer.MAX_VALUE;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    n2 = (int)sumCount;
                    BytecodeManager.incBytecodes(2);
                }
            }
            BytecodeManager.incBytecodes(1);
            return n2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean isEmpty() {
        try {
            BytecodeManager.incBytecodes(2);
            final long n = lcmp(this.sumCount(), 0L);
            BytecodeManager.incBytecodes(3);
            boolean b;
            if (n <= 0) {
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
            BytecodeManager.incBytecodes(2);
            final int hashCode = o.hashCode();
            BytecodeManager.incBytecodes(1);
            final int spread = spread(hashCode);
            BytecodeManager.incBytecodes(1);
            final Node<K, V>[] table;
            final Node<K, V>[] array = table = this.table;
            BytecodeManager.incBytecodes(5);
            Label_0322: {
                if (array != null) {
                    final int length = table.length;
                    BytecodeManager.incBytecodes(5);
                    if (length > 0) {
                        final Node<K, V>[] array2 = table;
                        final int n = length - 1 & spread;
                        BytecodeManager.incBytecodes(6);
                        BytecodeManager.incBytecodes(1);
                        Node<K, V> node2;
                        final Node<K, V> node = node2 = tabAt(array2, n);
                        BytecodeManager.incBytecodes(3);
                        if (node != null) {
                            final int hash = node2.hash;
                            final int n2 = spread;
                            BytecodeManager.incBytecodes(6);
                            Label_0228: {
                                if (hash == n2) {
                                    final K key;
                                    final K k = key = node2.key;
                                    BytecodeManager.incBytecodes(6);
                                    if (k != o) {
                                        final K i = key;
                                        BytecodeManager.incBytecodes(2);
                                        if (i == null) {
                                            break Label_0228;
                                        }
                                        final K obj = key;
                                        BytecodeManager.incBytecodes(3);
                                        final boolean equals = o.equals(obj);
                                        BytecodeManager.incBytecodes(1);
                                        if (!equals) {
                                            break Label_0228;
                                        }
                                    }
                                    final V val = node2.val;
                                    BytecodeManager.incBytecodes(3);
                                    return val;
                                }
                                final int n3 = hash;
                                BytecodeManager.incBytecodes(2);
                                if (n3 < 0) {
                                    final Node<K, V> node3 = node2;
                                    final int n4 = spread;
                                    BytecodeManager.incBytecodes(4);
                                    final Node<K, V> find = node3.find(n4, o);
                                    BytecodeManager.incBytecodes(3);
                                    V val2;
                                    if (find != null) {
                                        val2 = find.val;
                                        BytecodeManager.incBytecodes(3);
                                    }
                                    else {
                                        val2 = null;
                                        BytecodeManager.incBytecodes(1);
                                    }
                                    BytecodeManager.incBytecodes(1);
                                    return val2;
                                }
                            }
                            while (true) {
                                final Node<K, V> node4 = node2 = node2.next;
                                BytecodeManager.incBytecodes(5);
                                if (node4 == null) {
                                    break Label_0322;
                                }
                                final int hash2 = node2.hash;
                                final int n5 = spread;
                                BytecodeManager.incBytecodes(4);
                                if (hash2 != n5) {
                                    continue;
                                }
                                final K key2;
                                final K j = key2 = node2.key;
                                BytecodeManager.incBytecodes(6);
                                if (j == o) {
                                    break;
                                }
                                final K l = key2;
                                BytecodeManager.incBytecodes(2);
                                if (l == null) {
                                    continue;
                                }
                                final K obj2 = key2;
                                BytecodeManager.incBytecodes(2);
                                BytecodeManager.incBytecodes(1);
                                final boolean equals2 = o.equals(obj2);
                                BytecodeManager.incBytecodes(1);
                                if (equals2) {
                                    break;
                                }
                            }
                            final V val3 = node2.val;
                            BytecodeManager.incBytecodes(3);
                            return val3;
                        }
                    }
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
    
    @Override
    public boolean containsKey(final Object o) {
        try {
            BytecodeManager.incBytecodes(3);
            final Object value = this.get(o);
            BytecodeManager.incBytecodes(1);
            boolean b;
            if (value != null) {
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
            final Node<K, V>[] table;
            final Node<K, V>[] array = table = this.table;
            BytecodeManager.incBytecodes(5);
            Label_0159: {
                if (array != null) {
                    final Node<Object, Object>[] array2 = (Node<Object, Object>[])table;
                    final int length = ((Node<Object, Object>[])table).length;
                    final int n = 0;
                    final int length2 = ((Node<Object, Object>[])table).length;
                    BytecodeManager.incBytecodes(9);
                    final Traverser traverser = new Traverser<K, V>(array2, length, n, length2);
                    BytecodeManager.incBytecodes(1);
                    while (true) {
                        final Traverser traverser2 = traverser;
                        BytecodeManager.incBytecodes(2);
                        final Node<K, V> advance = traverser2.advance();
                        BytecodeManager.incBytecodes(3);
                        if (advance == null) {
                            break Label_0159;
                        }
                        final V val;
                        final V v = val = advance.val;
                        BytecodeManager.incBytecodes(6);
                        if (v == o) {
                            break;
                        }
                        final V v2 = val;
                        BytecodeManager.incBytecodes(2);
                        if (v2 != null) {
                            final V obj = val;
                            BytecodeManager.incBytecodes(3);
                            final boolean equals = o.equals(obj);
                            BytecodeManager.incBytecodes(1);
                            if (equals) {
                                break;
                            }
                        }
                        BytecodeManager.incBytecodes(1);
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
    public V put(final K k, final V v) {
        try {
            final boolean b = false;
            BytecodeManager.incBytecodes(5);
            final Object putVal = this.putVal(k, v, b);
            BytecodeManager.incBytecodes(1);
            return (V)putVal;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final V putVal(final K p0, final V p1, final boolean p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc_w           2
        //     4: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     7: ifnull          20
        //    10: aload_2        
        //    11: ldc_w           2
        //    14: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    17: ifnonnull       40
        //    20: new             Ljava/lang/NullPointerException;
        //    23: dup            
        //    24: ldc_w           3
        //    27: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    30: invokespecial   java/lang/NullPointerException.<init>:()V
        //    33: ldc_w           1
        //    36: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    39: athrow         
        //    40: aload_1        
        //    41: ldc_w           2
        //    44: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    47: invokevirtual   java/lang/Object.hashCode:()I
        //    50: ldc_w           1
        //    53: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    56: invokestatic    instrumented/java/util/concurrent/ConcurrentHashMap.spread:(I)I
        //    59: istore          4
        //    61: ldc_w           1
        //    64: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    67: iconst_0       
        //    68: istore          5
        //    70: ldc_w           2
        //    73: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    76: aload_0        
        //    77: getfield        instrumented/java/util/concurrent/ConcurrentHashMap.table:[Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //    80: astore          6
        //    82: ldc_w           3
        //    85: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    88: aload           6
        //    90: ldc_w           2
        //    93: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    96: ifnull          114
        //    99: aload           6
        //   101: arraylength    
        //   102: dup            
        //   103: istore          8
        //   105: ldc_w           5
        //   108: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   111: ifne            135
        //   114: aload_0        
        //   115: ldc_w           2
        //   118: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   121: invokespecial   instrumented/java/util/concurrent/ConcurrentHashMap.initTable:()[Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //   124: astore          6
        //   126: ldc_w           2
        //   129: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   132: goto            707
        //   135: aload           6
        //   137: iload           8
        //   139: iconst_1       
        //   140: isub           
        //   141: iload           4
        //   143: iand           
        //   144: dup            
        //   145: istore          9
        //   147: ldc_w           9
        //   150: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   153: invokestatic    instrumented/java/util/concurrent/ConcurrentHashMap.tabAt:([Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;I)Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //   156: dup            
        //   157: astore          7
        //   159: ldc_w           3
        //   162: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   165: ifnonnull       218
        //   168: aload           6
        //   170: iload           9
        //   172: aconst_null    
        //   173: new             Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //   176: dup            
        //   177: iload           4
        //   179: aload_1        
        //   180: aload_2        
        //   181: aconst_null    
        //   182: ldc_w           10
        //   185: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   188: invokespecial   instrumented/java/util/concurrent/ConcurrentHashMap$Node.<init>:(ILjava/lang/Object;Ljava/lang/Object;Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;)V
        //   191: ldc_w           1
        //   194: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   197: invokestatic    instrumented/java/util/concurrent/ConcurrentHashMap.casTabAt:([Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;ILinstrumented/java/util/concurrent/ConcurrentHashMap$Node;Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;)Z
        //   200: ldc_w           1
        //   203: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   206: ifeq            707
        //   209: ldc_w           1
        //   212: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   215: goto            716
        //   218: aload           7
        //   220: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$Node.hash:I
        //   223: dup            
        //   224: istore          10
        //   226: iconst_m1      
        //   227: ldc             6
        //   229: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   232: if_icmpne       259
        //   235: aload_0        
        //   236: aload           6
        //   238: aload           7
        //   240: ldc             4
        //   242: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   245: invokevirtual   instrumented/java/util/concurrent/ConcurrentHashMap.helpTransfer:([Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;)[Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //   248: astore          6
        //   250: ldc_w           2
        //   253: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   256: goto            707
        //   259: aconst_null    
        //   260: astore          11
        //   262: ldc_w           2
        //   265: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   268: aload           7
        //   270: dup            
        //   271: astore          12
        //   273: pop            
        //   274: ldc             4
        //   276: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   279: aload           6
        //   281: iload           9
        //   283: ldc_w           3
        //   286: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   289: invokestatic    instrumented/java/util/concurrent/ConcurrentHashMap.tabAt:([Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;I)Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //   292: aload           7
        //   294: ldc_w           2
        //   297: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   300: if_acmpne       612
        //   303: iload           10
        //   305: ldc_w           2
        //   308: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   311: iflt            525
        //   314: iconst_1       
        //   315: istore          5
        //   317: ldc_w           2
        //   320: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   323: aload           7
        //   325: astore          13
        //   327: ldc_w           2
        //   330: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   333: aload           13
        //   335: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$Node.hash:I
        //   338: iload           4
        //   340: ldc             4
        //   342: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   345: if_icmpne       440
        //   348: aload           13
        //   350: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$Node.key:Ljava/lang/Object;
        //   353: dup            
        //   354: astore          14
        //   356: aload_1        
        //   357: ldc             6
        //   359: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   362: if_acmpeq       403
        //   365: aload           14
        //   367: ldc_w           2
        //   370: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   373: ifnull          440
        //   376: aload_1        
        //   377: aload           14
        //   379: ldc_w           2
        //   382: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   385: ldc_w           1
        //   388: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   391: invokevirtual   java/lang/Object.equals:(Ljava/lang/Object;)Z
        //   394: ldc_w           1
        //   397: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   400: ifeq            440
        //   403: aload           13
        //   405: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$Node.val:Ljava/lang/Object;
        //   408: astore          11
        //   410: ldc_w           3
        //   413: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   416: iload_3        
        //   417: ldc_w           2
        //   420: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   423: ifne            516
        //   426: aload           13
        //   428: aload_2        
        //   429: putfield        instrumented/java/util/concurrent/ConcurrentHashMap$Node.val:Ljava/lang/Object;
        //   432: ldc             4
        //   434: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   437: goto            516
        //   440: aload           13
        //   442: astore          15
        //   444: ldc_w           2
        //   447: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   450: aload           13
        //   452: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$Node.next:Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //   455: dup            
        //   456: astore          13
        //   458: ldc_w           5
        //   461: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   464: ifnonnull       504
        //   467: aload           15
        //   469: new             Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //   472: dup            
        //   473: iload           4
        //   475: aload_1        
        //   476: aload_2        
        //   477: aconst_null    
        //   478: ldc             8
        //   480: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   483: invokespecial   instrumented/java/util/concurrent/ConcurrentHashMap$Node.<init>:(ILjava/lang/Object;Ljava/lang/Object;Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;)V
        //   486: putfield        instrumented/java/util/concurrent/ConcurrentHashMap$Node.next:Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //   489: ldc_w           1
        //   492: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   495: ldc_w           1
        //   498: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   501: goto            516
        //   504: iinc            5, 1
        //   507: ldc_w           2
        //   510: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   513: goto            333
        //   516: ldc_w           1
        //   519: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   522: goto            612
        //   525: aload           7
        //   527: instanceof      Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeBin;
        //   530: ldc_w           3
        //   533: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   536: ifeq            612
        //   539: iconst_2       
        //   540: istore          5
        //   542: ldc_w           2
        //   545: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   548: aload           7
        //   550: checkcast       Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeBin;
        //   553: iload           4
        //   555: aload_1        
        //   556: aload_2        
        //   557: ldc             6
        //   559: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   562: invokevirtual   instrumented/java/util/concurrent/ConcurrentHashMap$TreeBin.putTreeVal:(ILjava/lang/Object;Ljava/lang/Object;)Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
        //   565: dup            
        //   566: astore          13
        //   568: ldc_w           3
        //   571: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   574: ifnull          612
        //   577: aload           13
        //   579: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$Node.val:Ljava/lang/Object;
        //   582: astore          11
        //   584: ldc_w           3
        //   587: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   590: iload_3        
        //   591: ldc_w           2
        //   594: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   597: ifne            612
        //   600: aload           13
        //   602: aload_2        
        //   603: putfield        instrumented/java/util/concurrent/ConcurrentHashMap$Node.val:Ljava/lang/Object;
        //   606: ldc_w           3
        //   609: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   612: aload           12
        //   614: pop            
        //   615: ldc_w           2
        //   618: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   621: ldc_w           1
        //   624: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   627: goto            650
        //   630: astore          16
        //   632: aload           12
        //   634: pop            
        //   635: ldc_w           503
        //   638: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   641: aload           16
        //   643: ldc_w           2
        //   646: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   649: athrow         
        //   650: iload           5
        //   652: ldc_w           2
        //   655: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   658: ifeq            707
        //   661: iload           5
        //   663: bipush          8
        //   665: ldc_w           3
        //   668: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   671: if_icmplt       687
        //   674: aload_0        
        //   675: aload           6
        //   677: iload           9
        //   679: ldc             4
        //   681: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   684: invokespecial   instrumented/java/util/concurrent/ConcurrentHashMap.treeifyBin:([Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;I)V
        //   687: aload           11
        //   689: ldc_w           2
        //   692: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   695: ifnull          716
        //   698: aload           11
        //   700: ldc_w           2
        //   703: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   706: areturn        
        //   707: ldc_w           1
        //   710: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   713: goto            88
        //   716: aload_0        
        //   717: lconst_1       
        //   718: iload           5
        //   720: ldc             4
        //   722: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   725: invokespecial   instrumented/java/util/concurrent/ConcurrentHashMap.addCount:(JI)V
        //   728: aconst_null    
        //   729: ldc_w           2
        //   732: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   735: areturn        
        //   736: athrow         
        //   737: athrow         
        //    Signature:
        //  (TK;TV;Z)TV;
        //    StackMapTable: 00 15 14 13 FE 00 2F 01 01 07 01 7D 19 FD 00 14 00 01 FF 00 52 00 0A 07 00 02 07 01 08 07 01 08 01 01 01 07 01 7D 07 00 82 01 01 00 00 FC 00 28 01 FE 00 49 07 01 08 07 01 08 07 00 82 FC 00 45 07 01 08 FA 00 24 3F FA 00 0B 08 FB 00 56 51 07 00 FD FA 00 13 24 FF 00 13 00 07 07 00 02 07 01 08 07 01 08 01 01 01 07 01 7D 00 00 FA 00 08 FF 00 13 00 00 00 01 07 00 FD FF 00 00 00 00 00 01 07 01 9E
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  279    737    737    738    Ljava/lang/VirtualMachineError;
        //  279    621    630    650    Any
        //  630    641    630    650    Any
        //  0      736    736    737    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0333:
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
    public void putAll(final Map<? extends K, ? extends V> map) {
        try {
            BytecodeManager.incBytecodes(3);
            final int size = map.size();
            BytecodeManager.incBytecodes(1);
            this.tryPresize(size);
            BytecodeManager.incBytecodes(2);
            final Set<Map.Entry<? extends K, ? extends V>> entrySet = map.entrySet();
            BytecodeManager.incBytecodes(1);
            final Iterator<Map.Entry<? extends K, ? extends V>> iterator = entrySet.iterator();
            BytecodeManager.incBytecodes(1);
            while (true) {
                final Iterator<Map.Entry<? extends K, ? extends V>> iterator2 = iterator;
                BytecodeManager.incBytecodes(2);
                final boolean hasNext = iterator2.hasNext();
                BytecodeManager.incBytecodes(1);
                if (!hasNext) {
                    break;
                }
                final Iterator<Map.Entry<? extends K, ? extends V>> iterator3 = iterator;
                BytecodeManager.incBytecodes(2);
                final Map.Entry<? extends K, ? extends V> entry = iterator3.next();
                BytecodeManager.incBytecodes(2);
                final Map.Entry<? extends K, ? extends V> entry2 = entry;
                BytecodeManager.incBytecodes(3);
                final K key = (K)entry2.getKey();
                final Map.Entry<? extends K, ? extends V> entry3 = entry;
                BytecodeManager.incBytecodes(2);
                final V value = (V)entry3.getValue();
                final boolean b = false;
                BytecodeManager.incBytecodes(2);
                this.putVal(key, value, b);
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public V remove(final Object o) {
        try {
            final V v = null;
            final Object o2 = null;
            BytecodeManager.incBytecodes(5);
            final V replaceNode = this.replaceNode(o, v, o2);
            BytecodeManager.incBytecodes(1);
            return replaceNode;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final V replaceNode(final Object p0, final V p1, final Object p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc_w           2
        //     4: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     7: invokevirtual   java/lang/Object.hashCode:()I
        //    10: ldc_w           1
        //    13: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    16: invokestatic    instrumented/java/util/concurrent/ConcurrentHashMap.spread:(I)I
        //    19: istore          4
        //    21: ldc_w           1
        //    24: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    27: aload_0        
        //    28: getfield        instrumented/java/util/concurrent/ConcurrentHashMap.table:[Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //    31: astore          5
        //    33: ldc_w           3
        //    36: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    39: aload           5
        //    41: ldc_w           2
        //    44: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    47: ifnull          859
        //    50: aload           5
        //    52: arraylength    
        //    53: dup            
        //    54: istore          7
        //    56: ldc_w           5
        //    59: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    62: ifeq            859
        //    65: aload           5
        //    67: iload           7
        //    69: iconst_1       
        //    70: isub           
        //    71: iload           4
        //    73: iand           
        //    74: dup            
        //    75: istore          8
        //    77: ldc             8
        //    79: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    82: ldc_w           1
        //    85: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    88: invokestatic    instrumented/java/util/concurrent/ConcurrentHashMap.tabAt:([Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;I)Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //    91: dup            
        //    92: astore          6
        //    94: ldc_w           3
        //    97: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   100: ifnonnull       112
        //   103: ldc_w           1
        //   106: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   109: goto            859
        //   112: aload           6
        //   114: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$Node.hash:I
        //   117: dup            
        //   118: istore          9
        //   120: iconst_m1      
        //   121: ldc             6
        //   123: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   126: if_icmpne       153
        //   129: aload_0        
        //   130: aload           5
        //   132: aload           6
        //   134: ldc             4
        //   136: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   139: invokevirtual   instrumented/java/util/concurrent/ConcurrentHashMap.helpTransfer:([Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;)[Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //   142: astore          5
        //   144: ldc_w           2
        //   147: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   150: goto            850
        //   153: aconst_null    
        //   154: astore          10
        //   156: ldc_w           2
        //   159: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   162: iconst_0       
        //   163: istore          11
        //   165: ldc_w           2
        //   168: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   171: aload           6
        //   173: dup            
        //   174: astore          12
        //   176: pop            
        //   177: ldc             4
        //   179: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   182: aload           5
        //   184: iload           8
        //   186: ldc_w           3
        //   189: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   192: invokestatic    instrumented/java/util/concurrent/ConcurrentHashMap.tabAt:([Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;I)Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //   195: aload           6
        //   197: ldc_w           2
        //   200: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   203: if_acmpne       758
        //   206: iload           9
        //   208: ldc_w           2
        //   211: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   214: iflt            517
        //   217: iconst_1       
        //   218: istore          11
        //   220: ldc_w           2
        //   223: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   226: aload           6
        //   228: astore          13
        //   230: aconst_null    
        //   231: astore          14
        //   233: ldc             4
        //   235: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   238: aload           13
        //   240: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$Node.hash:I
        //   243: iload           4
        //   245: ldc             4
        //   247: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   250: if_icmpne       472
        //   253: aload           13
        //   255: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$Node.key:Ljava/lang/Object;
        //   258: dup            
        //   259: astore          15
        //   261: aload_1        
        //   262: ldc             6
        //   264: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   267: if_acmpeq       308
        //   270: aload           15
        //   272: ldc_w           2
        //   275: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   278: ifnull          472
        //   281: aload_1        
        //   282: aload           15
        //   284: ldc_w           2
        //   287: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   290: ldc_w           1
        //   293: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   296: invokevirtual   java/lang/Object.equals:(Ljava/lang/Object;)Z
        //   299: ldc_w           1
        //   302: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   305: ifeq            472
        //   308: aload           13
        //   310: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$Node.val:Ljava/lang/Object;
        //   313: astore          16
        //   315: ldc_w           3
        //   318: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   321: aload_3        
        //   322: ldc_w           2
        //   325: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   328: ifnull          381
        //   331: aload_3        
        //   332: aload           16
        //   334: ldc_w           3
        //   337: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   340: if_acmpeq       381
        //   343: aload           16
        //   345: ldc_w           2
        //   348: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   351: ifnull          508
        //   354: aload_3        
        //   355: aload           16
        //   357: ldc_w           2
        //   360: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   363: ldc_w           1
        //   366: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   369: invokevirtual   java/lang/Object.equals:(Ljava/lang/Object;)Z
        //   372: ldc_w           1
        //   375: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   378: ifeq            508
        //   381: aload           16
        //   383: astore          10
        //   385: ldc_w           2
        //   388: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   391: aload_2        
        //   392: ldc_w           2
        //   395: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   398: ifnull          415
        //   401: aload           13
        //   403: aload_2        
        //   404: putfield        instrumented/java/util/concurrent/ConcurrentHashMap$Node.val:Ljava/lang/Object;
        //   407: ldc             4
        //   409: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   412: goto            508
        //   415: aload           14
        //   417: ldc_w           2
        //   420: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   423: ifnull          445
        //   426: aload           14
        //   428: aload           13
        //   430: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$Node.next:Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //   433: putfield        instrumented/java/util/concurrent/ConcurrentHashMap$Node.next:Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //   436: ldc_w           5
        //   439: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   442: goto            508
        //   445: aload           5
        //   447: iload           8
        //   449: aload           13
        //   451: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$Node.next:Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //   454: ldc_w           5
        //   457: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   460: invokestatic    instrumented/java/util/concurrent/ConcurrentHashMap.setTabAt:([Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;ILinstrumented/java/util/concurrent/ConcurrentHashMap$Node;)V
        //   463: ldc_w           1
        //   466: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   469: goto            508
        //   472: aload           13
        //   474: astore          14
        //   476: ldc_w           2
        //   479: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   482: aload           13
        //   484: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$Node.next:Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //   487: dup            
        //   488: astore          13
        //   490: ldc_w           5
        //   493: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   496: ifnonnull       238
        //   499: ldc_w           1
        //   502: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   505: goto            508
        //   508: ldc_w           1
        //   511: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   514: goto            758
        //   517: aload           6
        //   519: instanceof      Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeBin;
        //   522: ldc_w           3
        //   525: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   528: ifeq            758
        //   531: iconst_1       
        //   532: istore          11
        //   534: ldc_w           2
        //   537: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   540: aload           6
        //   542: checkcast       Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeBin;
        //   545: astore          13
        //   547: ldc_w           3
        //   550: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   553: aload           13
        //   555: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeBin.root:Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
        //   558: dup            
        //   559: astore          14
        //   561: ldc_w           5
        //   564: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   567: ifnull          758
        //   570: aload           14
        //   572: iload           4
        //   574: aload_1        
        //   575: aconst_null    
        //   576: ldc             4
        //   578: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   581: ldc_w           1
        //   584: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   587: invokevirtual   instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.findTreeNode:(ILjava/lang/Object;Ljava/lang/Class;)Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
        //   590: dup            
        //   591: astore          15
        //   593: ldc_w           3
        //   596: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   599: ifnull          758
        //   602: aload           15
        //   604: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.val:Ljava/lang/Object;
        //   607: astore          16
        //   609: ldc_w           3
        //   612: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   615: aload_3        
        //   616: ldc_w           2
        //   619: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   622: ifnull          675
        //   625: aload_3        
        //   626: aload           16
        //   628: ldc_w           3
        //   631: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   634: if_acmpeq       675
        //   637: aload           16
        //   639: ldc_w           2
        //   642: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   645: ifnull          758
        //   648: aload_3        
        //   649: aload           16
        //   651: ldc_w           2
        //   654: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   657: ldc_w           1
        //   660: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   663: invokevirtual   java/lang/Object.equals:(Ljava/lang/Object;)Z
        //   666: ldc_w           1
        //   669: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   672: ifeq            758
        //   675: aload           16
        //   677: astore          10
        //   679: ldc_w           2
        //   682: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   685: aload_2        
        //   686: ldc_w           2
        //   689: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   692: ifnull          709
        //   695: aload           15
        //   697: aload_2        
        //   698: putfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.val:Ljava/lang/Object;
        //   701: ldc             4
        //   703: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   706: goto            758
        //   709: aload           13
        //   711: aload           15
        //   713: ldc_w           3
        //   716: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   719: invokevirtual   instrumented/java/util/concurrent/ConcurrentHashMap$TreeBin.removeTreeNode:(Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;)Z
        //   722: ldc_w           1
        //   725: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   728: ifeq            758
        //   731: aload           5
        //   733: iload           8
        //   735: aload           13
        //   737: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeBin.first:Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
        //   740: ldc_w           5
        //   743: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   746: invokestatic    instrumented/java/util/concurrent/ConcurrentHashMap.untreeify:(Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;)Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //   749: ldc_w           1
        //   752: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   755: invokestatic    instrumented/java/util/concurrent/ConcurrentHashMap.setTabAt:([Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;ILinstrumented/java/util/concurrent/ConcurrentHashMap$Node;)V
        //   758: aload           12
        //   760: pop            
        //   761: ldc_w           2
        //   764: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   767: ldc_w           1
        //   770: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   773: goto            796
        //   776: astore          17
        //   778: aload           12
        //   780: pop            
        //   781: ldc_w           503
        //   784: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   787: aload           17
        //   789: ldc_w           2
        //   792: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   795: athrow         
        //   796: iload           11
        //   798: ldc_w           2
        //   801: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   804: ifeq            850
        //   807: aload           10
        //   809: ldc_w           2
        //   812: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   815: ifnull          859
        //   818: aload_2        
        //   819: ldc_w           2
        //   822: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   825: ifnonnull       841
        //   828: aload_0        
        //   829: ldc2_w          -1
        //   832: iconst_m1      
        //   833: ldc             4
        //   835: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   838: invokespecial   instrumented/java/util/concurrent/ConcurrentHashMap.addCount:(JI)V
        //   841: aload           10
        //   843: ldc_w           2
        //   846: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   849: areturn        
        //   850: ldc_w           1
        //   853: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   856: goto            39
        //   859: aconst_null    
        //   860: ldc_w           2
        //   863: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   866: areturn        
        //   867: athrow         
        //   868: athrow         
        //    Signature:
        //  (Ljava/lang/Object;TV;Ljava/lang/Object;)TV;
        //    StackMapTable: 00 15 FD 00 27 01 07 01 7D FE 00 48 07 00 82 01 01 FC 00 28 01 FF 00 54 00 0F 07 00 02 07 01 08 07 01 08 07 01 08 01 07 01 7D 07 00 82 01 01 01 07 01 08 01 07 01 08 07 00 82 07 00 82 00 00 FC 00 45 07 01 08 FC 00 48 07 01 08 21 1D F9 00 1A F9 00 23 08 FF 00 9D 00 11 07 00 02 07 01 08 07 01 08 07 01 08 01 07 01 7D 07 00 82 01 01 01 07 01 08 01 07 01 08 07 00 A6 07 00 A9 07 00 A9 07 01 08 00 00 21 FF 00 30 00 0D 07 00 02 07 01 08 07 01 08 07 01 08 01 07 01 7D 07 00 82 01 01 01 07 01 08 01 07 01 08 00 00 51 07 00 FD FA 00 13 2C FF 00 08 00 06 07 00 02 07 01 08 07 01 08 07 01 08 01 07 01 7D 00 00 FA 00 08 FF 00 07 00 00 00 01 07 00 FD FF 00 00 00 00 00 01 07 01 9E
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  182    868    868    869    Ljava/lang/VirtualMachineError;
        //  182    767    776    796    Any
        //  776    787    776    796    Any
        //  0      867    867    868    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0238:
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
    public void clear() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: lstore_1       
        //     2: ldc_w           2
        //     5: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     8: iconst_0       
        //     9: istore_3       
        //    10: ldc_w           2
        //    13: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    16: aload_0        
        //    17: getfield        instrumented/java/util/concurrent/ConcurrentHashMap.table:[Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //    20: astore          4
        //    22: ldc_w           3
        //    25: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    28: aload           4
        //    30: ldc_w           2
        //    33: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    36: ifnull          342
        //    39: iload_3        
        //    40: aload           4
        //    42: arraylength    
        //    43: ldc             4
        //    45: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    48: if_icmpge       342
        //    51: aload           4
        //    53: iload_3        
        //    54: ldc_w           3
        //    57: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    60: invokestatic    instrumented/java/util/concurrent/ConcurrentHashMap.tabAt:([Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;I)Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //    63: astore          6
        //    65: ldc_w           1
        //    68: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    71: aload           6
        //    73: ldc_w           2
        //    76: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    79: ifnonnull       94
        //    82: iinc            3, 1
        //    85: ldc_w           2
        //    88: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    91: goto            333
        //    94: aload           6
        //    96: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$Node.hash:I
        //    99: dup            
        //   100: istore          5
        //   102: iconst_m1      
        //   103: ldc             6
        //   105: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   108: if_icmpne       143
        //   111: aload_0        
        //   112: aload           4
        //   114: aload           6
        //   116: ldc             4
        //   118: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   121: invokevirtual   instrumented/java/util/concurrent/ConcurrentHashMap.helpTransfer:([Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;)[Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //   124: astore          4
        //   126: ldc_w           1
        //   129: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   132: iconst_0       
        //   133: istore_3       
        //   134: ldc_w           3
        //   137: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   140: goto            333
        //   143: aload           6
        //   145: dup            
        //   146: astore          7
        //   148: pop            
        //   149: ldc             4
        //   151: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   154: aload           4
        //   156: iload_3        
        //   157: ldc_w           3
        //   160: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   163: invokestatic    instrumented/java/util/concurrent/ConcurrentHashMap.tabAt:([Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;I)Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //   166: aload           6
        //   168: ldc_w           2
        //   171: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   174: if_acmpne       295
        //   177: iload           5
        //   179: ldc_w           2
        //   182: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   185: iflt            199
        //   188: aload           6
        //   190: ldc_w           2
        //   193: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   196: goto            236
        //   199: aload           6
        //   201: instanceof      Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeBin;
        //   204: ldc_w           3
        //   207: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   210: ifeq            229
        //   213: aload           6
        //   215: checkcast       Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeBin;
        //   218: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeBin.first:Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
        //   221: ldc             4
        //   223: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   226: goto            236
        //   229: aconst_null    
        //   230: ldc_w           1
        //   233: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   236: astore          8
        //   238: ldc_w           1
        //   241: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   244: aload           8
        //   246: ldc_w           2
        //   249: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   252: ifnull          279
        //   255: lload_1        
        //   256: lconst_1       
        //   257: lsub           
        //   258: lstore_1       
        //   259: ldc             4
        //   261: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   264: aload           8
        //   266: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$Node.next:Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //   269: astore          8
        //   271: ldc             4
        //   273: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   276: goto            244
        //   279: aload           4
        //   281: iload_3        
        //   282: iinc            3, 1
        //   285: aconst_null    
        //   286: ldc_w           5
        //   289: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   292: invokestatic    instrumented/java/util/concurrent/ConcurrentHashMap.setTabAt:([Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;ILinstrumented/java/util/concurrent/ConcurrentHashMap$Node;)V
        //   295: aload           7
        //   297: pop            
        //   298: ldc_w           2
        //   301: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   304: ldc_w           1
        //   307: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   310: goto            333
        //   313: astore          9
        //   315: aload           7
        //   317: pop            
        //   318: ldc_w           503
        //   321: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   324: aload           9
        //   326: ldc_w           2
        //   329: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   332: athrow         
        //   333: ldc_w           1
        //   336: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   339: goto            28
        //   342: lload_1        
        //   343: lconst_0       
        //   344: lcmp           
        //   345: ldc             4
        //   347: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   350: ifeq            364
        //   353: aload_0        
        //   354: lload_1        
        //   355: iconst_m1      
        //   356: ldc             4
        //   358: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   361: invokespecial   instrumented/java/util/concurrent/ConcurrentHashMap.addCount:(JI)V
        //   364: ldc_w           1
        //   367: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   370: return         
        //   371: athrow         
        //   372: athrow         
        //    StackMapTable: 00 0F FE 00 1C 04 01 07 01 7D FD 00 41 00 07 00 82 FF 00 30 00 06 07 00 02 04 01 07 01 7D 01 07 00 82 00 00 FC 00 37 07 01 08 1D 46 07 00 82 FC 00 07 07 00 82 22 FA 00 0F 51 07 00 FD F8 00 13 08 15 FF 00 06 00 00 00 01 07 00 FD FF 00 00 00 00 00 01 07 01 9E
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  154    372    372    373    Ljava/lang/VirtualMachineError;
        //  154    304    313    333    Any
        //  313    324    313    333    Any
        //  0      371    371    372    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0199:
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
    public KeySetView<K, V> keySet() {
        try {
            final KeySetView<K, V> keySet = this.keySet;
            BytecodeManager.incBytecodes(5);
            KeySetView<K, V> keySetView;
            if (keySet != null) {
                keySetView = keySet;
                BytecodeManager.incBytecodes(2);
            }
            else {
                final V v;
                final KeySetView<K, V> keySet2 = keySetView = new KeySetView<K, V>((ConcurrentHashMap<Object, Object>)this, v);
                v = null;
                BytecodeManager.incBytecodes(6);
                this.keySet = keySet2;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
            return keySetView;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public Collection<V> values() {
        try {
            final ValuesView<K, V> values = this.values;
            BytecodeManager.incBytecodes(5);
            ValuesView<K, V> valuesView;
            if (values != null) {
                valuesView = values;
                BytecodeManager.incBytecodes(2);
            }
            else {
                final ValuesView values2 = valuesView = new ValuesView<K, V>((ConcurrentHashMap<Object, Object>)this);
                BytecodeManager.incBytecodes(5);
                this.values = (ValuesView<K, V>)values2;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
            return (Collection<V>)valuesView;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        try {
            final EntrySetView<K, V> entrySet = this.entrySet;
            BytecodeManager.incBytecodes(5);
            EntrySetView<K, V> entrySetView;
            if (entrySet != null) {
                entrySetView = entrySet;
                BytecodeManager.incBytecodes(2);
            }
            else {
                final EntrySetView<K, V> entrySet2 = entrySetView = new EntrySetView<K, V>(this);
                BytecodeManager.incBytecodes(5);
                this.entrySet = entrySet2;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
            return entrySetView;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public int hashCode() {
        try {
            int n = 0;
            BytecodeManager.incBytecodes(2);
            final Node<K, V>[] table;
            final Node<K, V>[] array = table = this.table;
            BytecodeManager.incBytecodes(5);
            if (array != null) {
                final Node<K, V>[] array2 = table;
                final int length = table.length;
                final int n2 = 0;
                final int length2 = table.length;
                BytecodeManager.incBytecodes(9);
                final Traverser traverser = new Traverser<K, V>(array2, length, n2, length2);
                BytecodeManager.incBytecodes(1);
                while (true) {
                    final Traverser traverser2 = traverser;
                    BytecodeManager.incBytecodes(2);
                    final Node<K, V> advance;
                    final Node<K, V> node = advance = traverser2.advance();
                    BytecodeManager.incBytecodes(3);
                    if (node == null) {
                        break;
                    }
                    final int n3 = n;
                    final K key = advance.key;
                    BytecodeManager.incBytecodes(4);
                    final int hashCode = key.hashCode();
                    final V val = advance.val;
                    BytecodeManager.incBytecodes(3);
                    n = n3 + (hashCode ^ val.hashCode());
                    BytecodeManager.incBytecodes(4);
                }
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
    public String toString() {
        try {
            final Node<K, V>[] table;
            final Node<K, V>[] array = table = this.table;
            BytecodeManager.incBytecodes(5);
            int length;
            if (array == null) {
                length = 0;
                BytecodeManager.incBytecodes(2);
            }
            else {
                length = ((Node<Object, Object>[])table).length;
                BytecodeManager.incBytecodes(2);
            }
            final int n = length;
            BytecodeManager.incBytecodes(1);
            final Node<Object, Object>[] array2 = (Node<Object, Object>[])table;
            final int n2 = n;
            final int n3 = 0;
            final int n4 = n;
            BytecodeManager.incBytecodes(7);
            final Traverser traverser = new Traverser<K, V>(array2, n2, n3, n4);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            final StringBuilder sb = new StringBuilder();
            BytecodeManager.incBytecodes(1);
            final StringBuilder sb2 = sb;
            final char c = '{';
            BytecodeManager.incBytecodes(3);
            sb2.append(c);
            BytecodeManager.incBytecodes(1);
            final Traverser traverser2 = traverser;
            BytecodeManager.incBytecodes(2);
            Node<K, V> node2;
            final Node<K, V> node = node2 = traverser2.advance();
            BytecodeManager.incBytecodes(3);
            if (node != null) {
                while (true) {
                    final K key = node2.key;
                    BytecodeManager.incBytecodes(3);
                    final V val = node2.val;
                    BytecodeManager.incBytecodes(3);
                    final StringBuilder sb3 = sb;
                    final K k = key;
                    BytecodeManager.incBytecodes(4);
                    Object obj;
                    if (k == this) {
                        obj = "(this Map)";
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        obj = key;
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(1);
                    sb3.append(obj);
                    BytecodeManager.incBytecodes(1);
                    final StringBuilder sb4 = sb;
                    final char c2 = '=';
                    BytecodeManager.incBytecodes(3);
                    sb4.append(c2);
                    BytecodeManager.incBytecodes(1);
                    final StringBuilder sb5 = sb;
                    final V v = val;
                    BytecodeManager.incBytecodes(4);
                    Object obj2;
                    if (v == this) {
                        obj2 = "(this Map)";
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        obj2 = val;
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(1);
                    sb5.append(obj2);
                    BytecodeManager.incBytecodes(1);
                    final Traverser traverser3 = traverser;
                    BytecodeManager.incBytecodes(2);
                    final Node<K, V> node3 = node2 = traverser3.advance();
                    BytecodeManager.incBytecodes(3);
                    if (node3 == null) {
                        break;
                    }
                    final StringBuilder sb6 = sb;
                    final char c3 = ',';
                    BytecodeManager.incBytecodes(3);
                    final StringBuilder append = sb6.append(c3);
                    final char c4 = ' ';
                    BytecodeManager.incBytecodes(2);
                    append.append(c4);
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
            }
            final StringBuilder sb7 = sb;
            final char c5 = '}';
            BytecodeManager.incBytecodes(3);
            final StringBuilder append2 = sb7.append(c5);
            BytecodeManager.incBytecodes(1);
            final String string = append2.toString();
            BytecodeManager.incBytecodes(1);
            return string;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean equals(final Object o) {
        try {
            BytecodeManager.incBytecodes(3);
            Label_0455: {
                if (o != this) {
                    final boolean b = o instanceof Map;
                    BytecodeManager.incBytecodes(3);
                    if (!b) {
                        final boolean b2 = false;
                        BytecodeManager.incBytecodes(2);
                        return b2;
                    }
                    final Map map = (Map)o;
                    BytecodeManager.incBytecodes(3);
                    final Node<K, V>[] table;
                    final Node<K, V>[] array = table = this.table;
                    BytecodeManager.incBytecodes(5);
                    int length;
                    if (array == null) {
                        length = 0;
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        length = ((Node<Object, Object>[])table).length;
                        BytecodeManager.incBytecodes(2);
                    }
                    final int n = length;
                    BytecodeManager.incBytecodes(1);
                    final Node<Object, Object>[] array2 = (Node<Object, Object>[])table;
                    final int n2 = n;
                    final int n3 = 0;
                    final int n4 = n;
                    BytecodeManager.incBytecodes(7);
                    final Traverser traverser = new Traverser<K, V>(array2, n2, n3, n4);
                    BytecodeManager.incBytecodes(1);
                    Label_0234: {
                        while (true) {
                            final Traverser traverser2 = traverser;
                            BytecodeManager.incBytecodes(2);
                            final Node<K, V> advance;
                            final Node<K, V> node = advance = traverser2.advance();
                            BytecodeManager.incBytecodes(3);
                            if (node == null) {
                                break Label_0234;
                            }
                            final V val = advance.val;
                            BytecodeManager.incBytecodes(3);
                            final Map<K, Object> map2 = (Map<K, Object>)map;
                            final K key = advance.key;
                            BytecodeManager.incBytecodes(4);
                            final Object value = map2.get(key);
                            BytecodeManager.incBytecodes(1);
                            final Object o2 = value;
                            BytecodeManager.incBytecodes(2);
                            if (o2 == null) {
                                break;
                            }
                            final Object o3 = value;
                            final V v = val;
                            BytecodeManager.incBytecodes(3);
                            if (o3 != v) {
                                final V v2 = (V)value;
                                final V obj = val;
                                BytecodeManager.incBytecodes(3);
                                final boolean equals = v2.equals(obj);
                                BytecodeManager.incBytecodes(1);
                                if (!equals) {
                                    break;
                                }
                            }
                            BytecodeManager.incBytecodes(1);
                        }
                        final boolean b3 = false;
                        BytecodeManager.incBytecodes(2);
                        return b3;
                    }
                    final Map<Object, Object> map3 = (Map<Object, Object>)map;
                    BytecodeManager.incBytecodes(2);
                    final Set<Map.Entry<Object, V>> entrySet = map3.entrySet();
                    BytecodeManager.incBytecodes(1);
                    final Iterator<Map.Entry<Object, V>> iterator = entrySet.iterator();
                    BytecodeManager.incBytecodes(1);
                    while (true) {
                        final Iterator<Map.Entry<Object, V>> iterator2 = iterator;
                        BytecodeManager.incBytecodes(2);
                        final boolean hasNext = iterator2.hasNext();
                        BytecodeManager.incBytecodes(1);
                        if (!hasNext) {
                            break Label_0455;
                        }
                        final Iterator<Map.Entry<Object, V>> iterator3 = iterator;
                        BytecodeManager.incBytecodes(2);
                        final Map.Entry<Object, V> entry = iterator3.next();
                        BytecodeManager.incBytecodes(2);
                        final Map.Entry<Object, V> entry2 = entry;
                        BytecodeManager.incBytecodes(2);
                        final Object key2 = entry2.getKey();
                        BytecodeManager.incBytecodes(3);
                        if (key2 == null) {
                            break;
                        }
                        final Map.Entry<Object, V> entry3 = entry;
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                        final V value2;
                        final V v3 = value2 = entry3.getValue();
                        BytecodeManager.incBytecodes(3);
                        if (v3 == null) {
                            break;
                        }
                        final Object o4 = key2;
                        BytecodeManager.incBytecodes(2);
                        BytecodeManager.incBytecodes(1);
                        final V value3;
                        final V v4 = value3 = this.get(o4);
                        BytecodeManager.incBytecodes(3);
                        if (v4 == null) {
                            break;
                        }
                        final V v5 = value2;
                        final V v6 = value3;
                        BytecodeManager.incBytecodes(3);
                        if (v5 != v6) {
                            final V v7 = (V)value2;
                            final V obj2 = value3;
                            BytecodeManager.incBytecodes(2);
                            BytecodeManager.incBytecodes(1);
                            final boolean equals2 = v7.equals(obj2);
                            BytecodeManager.incBytecodes(1);
                            if (!equals2) {
                                break;
                            }
                        }
                        BytecodeManager.incBytecodes(1);
                    }
                    final boolean b4 = false;
                    BytecodeManager.incBytecodes(2);
                    return b4;
                }
            }
            final boolean b5 = true;
            BytecodeManager.incBytecodes(2);
            return b5;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) throws IOException {
        try {
            int n = 0;
            BytecodeManager.incBytecodes(2);
            int n2 = 1;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n3 = n2;
                final int n4 = 16;
                BytecodeManager.incBytecodes(3);
                if (n3 >= n4) {
                    break;
                }
                ++n;
                BytecodeManager.incBytecodes(1);
                n2 <<= 1;
                BytecodeManager.incBytecodes(5);
            }
            final int n5 = 32 - n;
            BytecodeManager.incBytecodes(4);
            final int n6 = n2 - 1;
            BytecodeManager.incBytecodes(4);
            final Segment[] array = new Segment[16];
            BytecodeManager.incBytecodes(3);
            int n7 = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n8 = n7;
                final int length = array.length;
                BytecodeManager.incBytecodes(4);
                if (n8 >= length) {
                    break;
                }
                final Segment[] array2 = array;
                final int n9 = n7;
                final float n10 = 0.75f;
                BytecodeManager.incBytecodes(6);
                array2[n9] = new Segment(n10);
                BytecodeManager.incBytecodes(1);
                ++n7;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(2);
            final ObjectOutputStream.PutField putFields = objectOutputStream.putFields();
            final String s = "segments";
            final Segment[] array3 = array;
            BytecodeManager.incBytecodes(3);
            putFields.put(s, array3);
            BytecodeManager.incBytecodes(2);
            final ObjectOutputStream.PutField putFields2 = objectOutputStream.putFields();
            final String s2 = "segmentShift";
            final int n11 = n5;
            BytecodeManager.incBytecodes(3);
            putFields2.put(s2, n11);
            BytecodeManager.incBytecodes(2);
            final ObjectOutputStream.PutField putFields3 = objectOutputStream.putFields();
            final String s3 = "segmentMask";
            final int n12 = n6;
            BytecodeManager.incBytecodes(3);
            putFields3.put(s3, n12);
            BytecodeManager.incBytecodes(2);
            objectOutputStream.writeFields();
            final Node<K, V>[] table;
            final Node<K, V>[] array4 = table = this.table;
            BytecodeManager.incBytecodes(5);
            if (array4 != null) {
                final Node<Object, Object>[] array5 = (Node<Object, Object>[])table;
                final int length2 = ((Node<Object, Object>[])table).length;
                final int n13 = 0;
                final int length3 = ((Node<Object, Object>[])table).length;
                BytecodeManager.incBytecodes(9);
                final Traverser traverser = new Traverser<K, V>(array5, length2, n13, length3);
                BytecodeManager.incBytecodes(1);
                while (true) {
                    final Traverser traverser2 = traverser;
                    BytecodeManager.incBytecodes(2);
                    final Node<K, V> advance;
                    final Node<K, V> node = advance = traverser2.advance();
                    BytecodeManager.incBytecodes(3);
                    if (node == null) {
                        break;
                    }
                    final K key = advance.key;
                    BytecodeManager.incBytecodes(4);
                    objectOutputStream.writeObject(key);
                    final V val = advance.val;
                    BytecodeManager.incBytecodes(4);
                    objectOutputStream.writeObject(val);
                    BytecodeManager.incBytecodes(1);
                }
            }
            final Object obj = null;
            BytecodeManager.incBytecodes(3);
            objectOutputStream.writeObject(obj);
            final Object obj2 = null;
            BytecodeManager.incBytecodes(3);
            objectOutputStream.writeObject(obj2);
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void readObject(final ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.sizeCtl = -1;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(2);
            objectInputStream.defaultReadObject();
            long n = 0L;
            BytecodeManager.incBytecodes(2);
            Node<Object, Object> node = null;
            BytecodeManager.incBytecodes(2);
            while (true) {
                BytecodeManager.incBytecodes(2);
                final Object object = objectInputStream.readObject();
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(2);
                final Object object2 = objectInputStream.readObject();
                BytecodeManager.incBytecodes(1);
                final Object o = object;
                BytecodeManager.incBytecodes(2);
                if (o == null) {
                    break;
                }
                final Object o2 = object2;
                BytecodeManager.incBytecodes(2);
                if (o2 == null) {
                    break;
                }
                final Object o3 = object;
                BytecodeManager.incBytecodes(4);
                final int hashCode = o3.hashCode();
                BytecodeManager.incBytecodes(1);
                final int spread = spread(hashCode);
                final Object o4 = object;
                final Object o5 = object2;
                final Node<Object, Object> node2 = node;
                BytecodeManager.incBytecodes(4);
                node = new Node<Object, Object>(spread, o4, o5, node2);
                BytecodeManager.incBytecodes(1);
                ++n;
                BytecodeManager.incBytecodes(4);
                BytecodeManager.incBytecodes(1);
            }
            final long n2 = lcmp(n, 0L);
            BytecodeManager.incBytecodes(4);
            if (n2 == 0) {
                this.sizeCtl = 0;
                BytecodeManager.incBytecodes(4);
            }
            else {
                final long n3 = lcmp(n, 536870912L);
                BytecodeManager.incBytecodes(4);
                int tableSize;
                if (n3 >= 0) {
                    tableSize = 1073741824;
                    BytecodeManager.incBytecodes(3);
                }
                else {
                    final int n4 = (int)n;
                    BytecodeManager.incBytecodes(3);
                    final int n5 = n4 + (n4 >>> 1) + 1;
                    BytecodeManager.incBytecodes(8);
                    tableSize = tableSizeFor(n5);
                    BytecodeManager.incBytecodes(1);
                }
                final Node[] table = new Node[tableSize];
                BytecodeManager.incBytecodes(3);
                final int n6 = tableSize - 1;
                BytecodeManager.incBytecodes(4);
                long baseCount = 0L;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final Node<Object, Object> node3 = node;
                    BytecodeManager.incBytecodes(2);
                    if (node3 == null) {
                        break;
                    }
                    final Node<Object, Object> next = node.next;
                    BytecodeManager.incBytecodes(3);
                    final int hash = node.hash;
                    final int n7 = hash & n6;
                    BytecodeManager.incBytecodes(7);
                    final Node[] array = table;
                    final int n8 = n7;
                    BytecodeManager.incBytecodes(3);
                    final Map.Entry<K, V> tab;
                    final Node<K, V> node4 = (Node<K, V>)(tab = tabAt((Node<K, V>[])array, n8));
                    BytecodeManager.incBytecodes(3);
                    int n9;
                    if (node4 == null) {
                        n9 = 1;
                        BytecodeManager.incBytecodes(3);
                    }
                    else {
                        final Object key = node.key;
                        BytecodeManager.incBytecodes(3);
                        final int hash2 = ((Node)tab).hash;
                        BytecodeManager.incBytecodes(3);
                        if (hash2 < 0) {
                            final TreeBin<Object, Object> treeBin = (TreeBin<Object, Object>)tab;
                            BytecodeManager.incBytecodes(3);
                            final TreeBin<Object, Object> treeBin2 = treeBin;
                            final int n10 = hash;
                            final Object o6 = key;
                            final Object val = node.val;
                            BytecodeManager.incBytecodes(6);
                            final TreeNode<Object, Object> putTreeVal = treeBin2.putTreeVal(n10, o6, val);
                            BytecodeManager.incBytecodes(1);
                            if (putTreeVal == null) {
                                ++baseCount;
                                BytecodeManager.incBytecodes(4);
                            }
                            n9 = 0;
                            BytecodeManager.incBytecodes(2);
                            BytecodeManager.incBytecodes(1);
                        }
                        else {
                            int n11 = 0;
                            BytecodeManager.incBytecodes(2);
                            n9 = 1;
                            BytecodeManager.incBytecodes(2);
                            Map.Entry<K, V> next2 = tab;
                            BytecodeManager.incBytecodes(2);
                            Label_0611: {
                                while (true) {
                                    final Map.Entry<K, V> entry = next2;
                                    BytecodeManager.incBytecodes(2);
                                    if (entry == null) {
                                        break Label_0611;
                                    }
                                    final int hash3 = ((Node)next2).hash;
                                    final int n12 = hash;
                                    BytecodeManager.incBytecodes(4);
                                    if (hash3 == n12) {
                                        final K key2;
                                        final K k = key2 = ((Node)next2).key;
                                        final Object o7 = key;
                                        BytecodeManager.incBytecodes(6);
                                        if (k == o7) {
                                            break;
                                        }
                                        final K i = key2;
                                        BytecodeManager.incBytecodes(2);
                                        if (i != null) {
                                            final Object o8 = key;
                                            final K obj = key2;
                                            BytecodeManager.incBytecodes(2);
                                            BytecodeManager.incBytecodes(1);
                                            final boolean equals = o8.equals(obj);
                                            BytecodeManager.incBytecodes(1);
                                            if (equals) {
                                                break;
                                            }
                                        }
                                    }
                                    ++n11;
                                    BytecodeManager.incBytecodes(1);
                                    next2 = ((Node)next2).next;
                                    BytecodeManager.incBytecodes(4);
                                }
                                n9 = 0;
                                BytecodeManager.incBytecodes(2);
                                BytecodeManager.incBytecodes(1);
                            }
                            final int n13 = n9;
                            BytecodeManager.incBytecodes(2);
                            if (n13 != 0) {
                                final int n14 = n11;
                                final int n15 = 8;
                                BytecodeManager.incBytecodes(3);
                                if (n14 >= n15) {
                                    n9 = 0;
                                    BytecodeManager.incBytecodes(2);
                                    ++baseCount;
                                    BytecodeManager.incBytecodes(4);
                                    node.next = (Node<Object, Object>)tab;
                                    BytecodeManager.incBytecodes(3);
                                    TreeNode<Object, Object> treeNode = null;
                                    TreeNode<Object, Object> treeNode2 = null;
                                    BytecodeManager.incBytecodes(4);
                                    Node<Object, Object> next3 = node;
                                    BytecodeManager.incBytecodes(2);
                                    while (true) {
                                        final Node<Object, Object> node5 = next3;
                                        BytecodeManager.incBytecodes(2);
                                        if (node5 == null) {
                                            break;
                                        }
                                        final int hash4 = next3.hash;
                                        final Object key3 = next3.key;
                                        final Object val2 = next3.val;
                                        final Node<K, V> node6 = null;
                                        final TreeNode<K, V> treeNode3 = null;
                                        BytecodeManager.incBytecodes(11);
                                        final TreeNode next4 = new TreeNode<Object, Object>(hash4, key3, val2, (Node<Object, Object>)node6, (TreeNode<Object, Object>)treeNode3);
                                        BytecodeManager.incBytecodes(1);
                                        final TreeNode treeNode4 = next4;
                                        final TreeNode<K, V> prev = (TreeNode<K, V>)treeNode2;
                                        treeNode4.prev = prev;
                                        BytecodeManager.incBytecodes(5);
                                        if (prev == null) {
                                            treeNode = (TreeNode<Object, Object>)next4;
                                            BytecodeManager.incBytecodes(3);
                                        }
                                        else {
                                            treeNode2.next = (Node<Object, Object>)next4;
                                            BytecodeManager.incBytecodes(3);
                                        }
                                        treeNode2 = (TreeNode<Object, Object>)next4;
                                        BytecodeManager.incBytecodes(2);
                                        next3 = next3.next;
                                        BytecodeManager.incBytecodes(4);
                                    }
                                    final Node[] array2 = table;
                                    final int n16 = n7;
                                    final TreeNode<Object, Object> treeNode5 = treeNode;
                                    BytecodeManager.incBytecodes(6);
                                    final TreeBin treeBin3 = new TreeBin<Object, Object>(treeNode5);
                                    BytecodeManager.incBytecodes(1);
                                    setTabAt(array2, n16, (Node<Object, Object>)treeBin3);
                                }
                            }
                        }
                    }
                    final int n17 = n9;
                    BytecodeManager.incBytecodes(2);
                    if (n17 != 0) {
                        ++baseCount;
                        BytecodeManager.incBytecodes(4);
                        node.next = (Node<Object, Object>)tab;
                        BytecodeManager.incBytecodes(3);
                        final Node[] array3 = table;
                        final int n18 = n7;
                        final Node<Object, Object> node7 = node;
                        BytecodeManager.incBytecodes(4);
                        setTabAt(array3, n18, node7);
                    }
                    node = next;
                    BytecodeManager.incBytecodes(2);
                    BytecodeManager.incBytecodes(1);
                }
                this.table = (Node<K, V>[])table;
                BytecodeManager.incBytecodes(3);
                this.sizeCtl = tableSize - (tableSize >>> 2);
                BytecodeManager.incBytecodes(7);
                this.baseCount = baseCount;
                BytecodeManager.incBytecodes(3);
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
            final boolean b = true;
            BytecodeManager.incBytecodes(5);
            final Object putVal = this.putVal(k, v, b);
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
            BytecodeManager.incBytecodes(2);
            if (o == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(2);
            boolean b = false;
            Label_0079: {
                if (o2 != null) {
                    final V v = null;
                    BytecodeManager.incBytecodes(5);
                    final Object replaceNode = this.replaceNode(o, v, o2);
                    BytecodeManager.incBytecodes(1);
                    if (replaceNode != null) {
                        b = true;
                        BytecodeManager.incBytecodes(2);
                        break Label_0079;
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
                        BytecodeManager.incBytecodes(5);
                        final Object replaceNode = this.replaceNode(k, v2, v);
                        BytecodeManager.incBytecodes(1);
                        boolean b;
                        if (replaceNode != null) {
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
                    final Object o = null;
                    BytecodeManager.incBytecodes(5);
                    final V replaceNode = this.replaceNode(k, v, o);
                    BytecodeManager.incBytecodes(1);
                    return replaceNode;
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
    public V getOrDefault(final Object o, final V v) {
        try {
            BytecodeManager.incBytecodes(3);
            final V value = this.get(o);
            BytecodeManager.incBytecodes(3);
            V v2;
            if (value == null) {
                v2 = v;
                BytecodeManager.incBytecodes(2);
            }
            else {
                v2 = value;
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
    public void forEach(final BiConsumer<? super K, ? super V> biConsumer) {
        try {
            BytecodeManager.incBytecodes(2);
            if (biConsumer == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final Node<K, V>[] table;
            final Node<K, V>[] array = table = this.table;
            BytecodeManager.incBytecodes(5);
            if (array != null) {
                final Node<Object, Object>[] array2 = (Node<Object, Object>[])table;
                final int length = ((Node<Object, Object>[])table).length;
                final int n = 0;
                final int length2 = ((Node<Object, Object>[])table).length;
                BytecodeManager.incBytecodes(9);
                final Traverser traverser = new Traverser<K, V>(array2, length, n, length2);
                BytecodeManager.incBytecodes(1);
                while (true) {
                    final Traverser traverser2 = traverser;
                    BytecodeManager.incBytecodes(2);
                    final Node<K, V> advance;
                    final Node<K, V> node = advance = traverser2.advance();
                    BytecodeManager.incBytecodes(3);
                    if (node == null) {
                        break;
                    }
                    final K key = advance.key;
                    final V val = advance.val;
                    BytecodeManager.incBytecodes(6);
                    biConsumer.accept(key, val);
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
    public void replaceAll(final BiFunction<? super K, ? super V, ? extends V> biFunction) {
        try {
            BytecodeManager.incBytecodes(2);
            if (biFunction == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final Node<K, V>[] table;
            final Node<K, V>[] array = table = this.table;
            BytecodeManager.incBytecodes(5);
            if (array != null) {
                final Node<Object, Object>[] array2 = (Node<Object, Object>[])table;
                final int length = ((Node<Object, Object>[])table).length;
                final int n = 0;
                final int length2 = ((Node<Object, Object>[])table).length;
                BytecodeManager.incBytecodes(9);
                final Traverser traverser = new Traverser<K, V>(array2, length, n, length2);
                BytecodeManager.incBytecodes(1);
                while (true) {
                    final Traverser traverser2 = traverser;
                    BytecodeManager.incBytecodes(2);
                    final Node<K, V> advance;
                    final Node<K, V> node = advance = traverser2.advance();
                    BytecodeManager.incBytecodes(3);
                    if (node == null) {
                        break;
                    }
                    V v = advance.val;
                    BytecodeManager.incBytecodes(3);
                    final K key = advance.key;
                    BytecodeManager.incBytecodes(3);
                    while (true) {
                        final K k = key;
                        final V v2 = v;
                        BytecodeManager.incBytecodes(4);
                        final V apply = (V)biFunction.apply(k, v2);
                        BytecodeManager.incBytecodes(1);
                        final V v3 = apply;
                        BytecodeManager.incBytecodes(2);
                        if (v3 == null) {
                            BytecodeManager.incBytecodes(3);
                            final NullPointerException ex2 = new NullPointerException();
                            BytecodeManager.incBytecodes(1);
                            throw ex2;
                        }
                        final K i = key;
                        final V v4 = apply;
                        final V v5 = v;
                        BytecodeManager.incBytecodes(5);
                        final Object replaceNode = this.replaceNode(i, v4, v5);
                        BytecodeManager.incBytecodes(1);
                        if (replaceNode != null) {
                            break;
                        }
                        final K j = key;
                        BytecodeManager.incBytecodes(2);
                        BytecodeManager.incBytecodes(1);
                        final V v6 = v = this.get(j);
                        BytecodeManager.incBytecodes(3);
                        if (v6 == null) {
                            BytecodeManager.incBytecodes(1);
                            break;
                        }
                        BytecodeManager.incBytecodes(1);
                    }
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
    public V computeIfAbsent(final K p0, final Function<? super K, ? extends V> p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc_w           2
        //     4: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     7: ifnull          20
        //    10: aload_2        
        //    11: ldc_w           2
        //    14: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    17: ifnonnull       40
        //    20: new             Ljava/lang/NullPointerException;
        //    23: dup            
        //    24: ldc_w           3
        //    27: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    30: invokespecial   java/lang/NullPointerException.<init>:()V
        //    33: ldc_w           1
        //    36: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    39: athrow         
        //    40: aload_1        
        //    41: ldc_w           2
        //    44: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    47: invokevirtual   java/lang/Object.hashCode:()I
        //    50: ldc_w           1
        //    53: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    56: invokestatic    instrumented/java/util/concurrent/ConcurrentHashMap.spread:(I)I
        //    59: istore_3       
        //    60: ldc_w           1
        //    63: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    66: aconst_null    
        //    67: astore          4
        //    69: ldc_w           2
        //    72: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    75: iconst_0       
        //    76: istore          5
        //    78: ldc_w           2
        //    81: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    84: aload_0        
        //    85: getfield        instrumented/java/util/concurrent/ConcurrentHashMap.table:[Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //    88: astore          6
        //    90: ldc_w           3
        //    93: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    96: aload           6
        //    98: ldc_w           2
        //   101: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   104: ifnull          122
        //   107: aload           6
        //   109: arraylength    
        //   110: dup            
        //   111: istore          8
        //   113: ldc_w           5
        //   116: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   119: ifne            143
        //   122: aload_0        
        //   123: ldc_w           2
        //   126: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   129: invokespecial   instrumented/java/util/concurrent/ConcurrentHashMap.initTable:()[Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //   132: astore          6
        //   134: ldc_w           2
        //   137: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   140: goto            991
        //   143: aload           6
        //   145: iload           8
        //   147: iconst_1       
        //   148: isub           
        //   149: iload_3        
        //   150: iand           
        //   151: dup            
        //   152: istore          9
        //   154: ldc_w           9
        //   157: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   160: invokestatic    instrumented/java/util/concurrent/ConcurrentHashMap.tabAt:([Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;I)Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //   163: dup            
        //   164: astore          7
        //   166: ldc_w           3
        //   169: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   172: ifnonnull       422
        //   175: new             Linstrumented/java/util/concurrent/ConcurrentHashMap$ReservationNode;
        //   178: dup            
        //   179: ldc_w           3
        //   182: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   185: invokespecial   instrumented/java/util/concurrent/ConcurrentHashMap$ReservationNode.<init>:()V
        //   188: astore          11
        //   190: ldc_w           1
        //   193: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   196: aload           11
        //   198: dup            
        //   199: astore          12
        //   201: pop            
        //   202: ldc             4
        //   204: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   207: aload           6
        //   209: iload           9
        //   211: aconst_null    
        //   212: aload           11
        //   214: ldc_w           5
        //   217: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   220: invokestatic    instrumented/java/util/concurrent/ConcurrentHashMap.casTabAt:([Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;ILinstrumented/java/util/concurrent/ConcurrentHashMap$Node;Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;)Z
        //   223: ldc_w           1
        //   226: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   229: ifeq            355
        //   232: iconst_1       
        //   233: istore          5
        //   235: ldc_w           2
        //   238: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   241: aconst_null    
        //   242: astore          13
        //   244: ldc_w           2
        //   247: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   250: aload_2        
        //   251: aload_1        
        //   252: ldc_w           3
        //   255: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   258: invokeinterface instrumented/java/util/function/Function.apply:(Ljava/lang/Object;)Ljava/lang/Object;
        //   263: dup            
        //   264: astore          4
        //   266: ldc_w           3
        //   269: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   272: ifnull          301
        //   275: new             Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //   278: dup            
        //   279: iload_3        
        //   280: aload_1        
        //   281: aload           4
        //   283: aconst_null    
        //   284: ldc_w           7
        //   287: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   290: invokespecial   instrumented/java/util/concurrent/ConcurrentHashMap$Node.<init>:(ILjava/lang/Object;Ljava/lang/Object;Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;)V
        //   293: astore          13
        //   295: ldc_w           1
        //   298: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   301: aload           6
        //   303: iload           9
        //   305: aload           13
        //   307: ldc             4
        //   309: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   312: invokestatic    instrumented/java/util/concurrent/ConcurrentHashMap.setTabAt:([Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;ILinstrumented/java/util/concurrent/ConcurrentHashMap$Node;)V
        //   315: ldc_w           1
        //   318: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   321: goto            355
        //   324: astore          14
        //   326: ldc_w           501
        //   329: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   332: aload           6
        //   334: iload           9
        //   336: aload           13
        //   338: ldc             4
        //   340: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   343: invokestatic    instrumented/java/util/concurrent/ConcurrentHashMap.setTabAt:([Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;ILinstrumented/java/util/concurrent/ConcurrentHashMap$Node;)V
        //   346: aload           14
        //   348: ldc_w           2
        //   351: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   354: athrow         
        //   355: aload           12
        //   357: pop            
        //   358: ldc_w           2
        //   361: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   364: ldc_w           1
        //   367: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   370: goto            393
        //   373: astore          15
        //   375: aload           12
        //   377: pop            
        //   378: ldc_w           503
        //   381: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   384: aload           15
        //   386: ldc_w           2
        //   389: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   392: athrow         
        //   393: iload           5
        //   395: ldc_w           2
        //   398: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   401: ifeq            413
        //   404: ldc_w           1
        //   407: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   410: goto            1000
        //   413: ldc_w           1
        //   416: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   419: goto            991
        //   422: aload           7
        //   424: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$Node.hash:I
        //   427: dup            
        //   428: istore          10
        //   430: iconst_m1      
        //   431: ldc             6
        //   433: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   436: if_icmpne       463
        //   439: aload_0        
        //   440: aload           6
        //   442: aload           7
        //   444: ldc             4
        //   446: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   449: invokevirtual   instrumented/java/util/concurrent/ConcurrentHashMap.helpTransfer:([Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;)[Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //   452: astore          6
        //   454: ldc_w           2
        //   457: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   460: goto            991
        //   463: iconst_0       
        //   464: istore          11
        //   466: ldc_w           2
        //   469: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   472: aload           7
        //   474: dup            
        //   475: astore          12
        //   477: pop            
        //   478: ldc             4
        //   480: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   483: aload           6
        //   485: iload           9
        //   487: ldc_w           3
        //   490: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   493: invokestatic    instrumented/java/util/concurrent/ConcurrentHashMap.tabAt:([Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;I)Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //   496: aload           7
        //   498: ldc_w           2
        //   501: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   504: if_acmpne       896
        //   507: iload           10
        //   509: ldc_w           2
        //   512: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   515: iflt            741
        //   518: iconst_1       
        //   519: istore          5
        //   521: ldc_w           2
        //   524: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   527: aload           7
        //   529: astore          13
        //   531: ldc_w           2
        //   534: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   537: aload           13
        //   539: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$Node.hash:I
        //   542: iload_3        
        //   543: ldc             4
        //   545: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   548: if_icmpne       628
        //   551: aload           13
        //   553: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$Node.key:Ljava/lang/Object;
        //   556: dup            
        //   557: astore          14
        //   559: aload_1        
        //   560: ldc             6
        //   562: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   565: if_acmpeq       606
        //   568: aload           14
        //   570: ldc_w           2
        //   573: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   576: ifnull          628
        //   579: aload_1        
        //   580: aload           14
        //   582: ldc_w           2
        //   585: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   588: ldc_w           1
        //   591: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   594: invokevirtual   java/lang/Object.equals:(Ljava/lang/Object;)Z
        //   597: ldc_w           1
        //   600: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   603: ifeq            628
        //   606: aload           13
        //   608: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$Node.val:Ljava/lang/Object;
        //   611: astore          4
        //   613: ldc_w           3
        //   616: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   619: ldc_w           1
        //   622: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   625: goto            732
        //   628: aload           13
        //   630: astore          16
        //   632: ldc_w           2
        //   635: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   638: aload           13
        //   640: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$Node.next:Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //   643: dup            
        //   644: astore          13
        //   646: ldc_w           5
        //   649: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   652: ifnonnull       720
        //   655: aload_2        
        //   656: aload_1        
        //   657: ldc_w           3
        //   660: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   663: invokeinterface instrumented/java/util/function/Function.apply:(Ljava/lang/Object;)Ljava/lang/Object;
        //   668: dup            
        //   669: astore          4
        //   671: ldc_w           3
        //   674: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   677: ifnull          732
        //   680: iconst_1       
        //   681: istore          11
        //   683: ldc_w           2
        //   686: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   689: aload           16
        //   691: new             Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //   694: dup            
        //   695: iload_3        
        //   696: aload_1        
        //   697: aload           4
        //   699: aconst_null    
        //   700: ldc             8
        //   702: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   705: invokespecial   instrumented/java/util/concurrent/ConcurrentHashMap$Node.<init>:(ILjava/lang/Object;Ljava/lang/Object;Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;)V
        //   708: putfield        instrumented/java/util/concurrent/ConcurrentHashMap$Node.next:Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //   711: ldc_w           2
        //   714: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   717: goto            732
        //   720: iinc            5, 1
        //   723: ldc_w           2
        //   726: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   729: goto            537
        //   732: ldc_w           1
        //   735: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   738: goto            896
        //   741: aload           7
        //   743: instanceof      Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeBin;
        //   746: ldc_w           3
        //   749: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   752: ifeq            896
        //   755: iconst_2       
        //   756: istore          5
        //   758: ldc_w           2
        //   761: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   764: aload           7
        //   766: checkcast       Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeBin;
        //   769: astore          13
        //   771: ldc_w           3
        //   774: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   777: aload           13
        //   779: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeBin.root:Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
        //   782: dup            
        //   783: astore          14
        //   785: ldc_w           5
        //   788: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   791: ifnull          840
        //   794: aload           14
        //   796: iload_3        
        //   797: aload_1        
        //   798: aconst_null    
        //   799: ldc             4
        //   801: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   804: ldc_w           1
        //   807: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   810: invokevirtual   instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.findTreeNode:(ILjava/lang/Object;Ljava/lang/Class;)Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
        //   813: dup            
        //   814: astore          15
        //   816: ldc_w           3
        //   819: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   822: ifnull          840
        //   825: aload           15
        //   827: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.val:Ljava/lang/Object;
        //   830: astore          4
        //   832: ldc             4
        //   834: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   837: goto            896
        //   840: aload_2        
        //   841: aload_1        
        //   842: ldc_w           3
        //   845: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   848: invokeinterface instrumented/java/util/function/Function.apply:(Ljava/lang/Object;)Ljava/lang/Object;
        //   853: dup            
        //   854: astore          4
        //   856: ldc_w           3
        //   859: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   862: ifnull          896
        //   865: iconst_1       
        //   866: istore          11
        //   868: ldc_w           2
        //   871: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   874: aload           13
        //   876: iload_3        
        //   877: aload_1        
        //   878: aload           4
        //   880: ldc_w           5
        //   883: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   886: invokevirtual   instrumented/java/util/concurrent/ConcurrentHashMap$TreeBin.putTreeVal:(ILjava/lang/Object;Ljava/lang/Object;)Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
        //   889: pop            
        //   890: ldc_w           1
        //   893: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   896: aload           12
        //   898: pop            
        //   899: ldc_w           2
        //   902: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   905: ldc_w           1
        //   908: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   911: goto            934
        //   914: astore          17
        //   916: aload           12
        //   918: pop            
        //   919: ldc_w           503
        //   922: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   925: aload           17
        //   927: ldc_w           2
        //   930: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   933: athrow         
        //   934: iload           5
        //   936: ldc_w           2
        //   939: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   942: ifeq            991
        //   945: iload           5
        //   947: bipush          8
        //   949: ldc_w           3
        //   952: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   955: if_icmplt       971
        //   958: aload_0        
        //   959: aload           6
        //   961: iload           9
        //   963: ldc             4
        //   965: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   968: invokespecial   instrumented/java/util/concurrent/ConcurrentHashMap.treeifyBin:([Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;I)V
        //   971: iload           11
        //   973: ldc_w           2
        //   976: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   979: ifne            1000
        //   982: aload           4
        //   984: ldc_w           2
        //   987: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   990: areturn        
        //   991: ldc_w           1
        //   994: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   997: goto            96
        //  1000: aload           4
        //  1002: ldc_w           2
        //  1005: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1008: ifnull          1023
        //  1011: aload_0        
        //  1012: lconst_1       
        //  1013: iload           5
        //  1015: ldc             4
        //  1017: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1020: invokespecial   instrumented/java/util/concurrent/ConcurrentHashMap.addCount:(JI)V
        //  1023: aload           4
        //  1025: ldc_w           2
        //  1028: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1031: areturn        
        //  1032: athrow         
        //  1033: athrow         
        //    Signature:
        //  (TK;Linstrumented/java/util/function/Function<-TK;+TV;>;)TV;
        //    StackMapTable: 00 1D 14 13 FF 00 37 00 07 07 00 02 07 01 08 07 02 64 01 07 01 08 01 07 01 7D 00 00 19 FD 00 14 00 01 FF 00 9D 00 0E 07 00 02 07 01 08 07 02 64 01 07 01 08 01 07 01 7D 07 00 82 01 01 00 07 00 82 07 01 08 07 00 82 00 00 56 07 00 FD FA 00 1E 51 07 00 FD FA 00 13 F9 00 13 08 FC 00 28 01 FE 00 49 01 07 01 08 07 00 82 FC 00 44 07 01 08 FA 00 15 FB 00 5B FA 00 0B 08 FD 00 62 07 00 A6 07 00 A9 F9 00 37 51 07 00 FD FA 00 13 24 FF 00 13 00 07 07 00 02 07 01 08 07 02 64 01 07 01 08 01 07 01 7D 00 00 FA 00 08 16 FF 00 08 00 00 00 01 07 00 FD FF 00 00 00 00 00 01 07 01 9E
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  207    1033   1033   1034   Ljava/lang/VirtualMachineError;
        //  250    301    324    355    Any
        //  324    332    324    355    Any
        //  207    364    373    393    Any
        //  373    384    373    393    Any
        //  483    905    914    934    Any
        //  914    925    914    934    Any
        //  0      1032   1032   1033   Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0301:
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
    public V computeIfPresent(final K p0, final BiFunction<? super K, ? super V, ? extends V> p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc_w           2
        //     4: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     7: ifnull          20
        //    10: aload_2        
        //    11: ldc_w           2
        //    14: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    17: ifnonnull       40
        //    20: new             Ljava/lang/NullPointerException;
        //    23: dup            
        //    24: ldc_w           3
        //    27: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    30: invokespecial   java/lang/NullPointerException.<init>:()V
        //    33: ldc_w           1
        //    36: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    39: athrow         
        //    40: aload_1        
        //    41: ldc_w           2
        //    44: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    47: invokevirtual   java/lang/Object.hashCode:()I
        //    50: ldc_w           1
        //    53: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    56: invokestatic    instrumented/java/util/concurrent/ConcurrentHashMap.spread:(I)I
        //    59: istore_3       
        //    60: ldc_w           1
        //    63: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    66: aconst_null    
        //    67: astore          4
        //    69: ldc_w           2
        //    72: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    75: iconst_0       
        //    76: istore          5
        //    78: ldc_w           2
        //    81: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    84: iconst_0       
        //    85: istore          6
        //    87: ldc_w           2
        //    90: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    93: aload_0        
        //    94: getfield        instrumented/java/util/concurrent/ConcurrentHashMap.table:[Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //    97: astore          7
        //    99: ldc_w           3
        //   102: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   105: aload           7
        //   107: ldc_w           2
        //   110: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   113: ifnull          131
        //   116: aload           7
        //   118: arraylength    
        //   119: dup            
        //   120: istore          9
        //   122: ldc_w           5
        //   125: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   128: ifne            152
        //   131: aload_0        
        //   132: ldc_w           2
        //   135: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   138: invokespecial   instrumented/java/util/concurrent/ConcurrentHashMap.initTable:()[Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //   141: astore          7
        //   143: ldc_w           2
        //   146: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   149: goto            802
        //   152: aload           7
        //   154: iload           9
        //   156: iconst_1       
        //   157: isub           
        //   158: iload_3        
        //   159: iand           
        //   160: dup            
        //   161: istore          10
        //   163: ldc_w           9
        //   166: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   169: invokestatic    instrumented/java/util/concurrent/ConcurrentHashMap.tabAt:([Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;I)Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //   172: dup            
        //   173: astore          8
        //   175: ldc_w           3
        //   178: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   181: ifnonnull       193
        //   184: ldc_w           1
        //   187: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   190: goto            811
        //   193: aload           8
        //   195: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$Node.hash:I
        //   198: dup            
        //   199: istore          11
        //   201: iconst_m1      
        //   202: ldc             6
        //   204: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   207: if_icmpne       234
        //   210: aload_0        
        //   211: aload           7
        //   213: aload           8
        //   215: ldc             4
        //   217: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   220: invokevirtual   instrumented/java/util/concurrent/ConcurrentHashMap.helpTransfer:([Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;)[Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //   223: astore          7
        //   225: ldc_w           2
        //   228: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   231: goto            802
        //   234: aload           8
        //   236: dup            
        //   237: astore          12
        //   239: pop            
        //   240: ldc             4
        //   242: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   245: aload           7
        //   247: iload           10
        //   249: ldc_w           3
        //   252: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   255: invokestatic    instrumented/java/util/concurrent/ConcurrentHashMap.tabAt:([Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;I)Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //   258: aload           8
        //   260: ldc_w           2
        //   263: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   266: if_acmpne       744
        //   269: iload           11
        //   271: ldc_w           2
        //   274: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   277: iflt            550
        //   280: iconst_1       
        //   281: istore          6
        //   283: ldc_w           2
        //   286: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   289: aload           8
        //   291: astore          13
        //   293: aconst_null    
        //   294: astore          14
        //   296: ldc             4
        //   298: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   301: aload           13
        //   303: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$Node.hash:I
        //   306: iload_3        
        //   307: ldc             4
        //   309: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   312: if_icmpne       493
        //   315: aload           13
        //   317: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$Node.key:Ljava/lang/Object;
        //   320: dup            
        //   321: astore          15
        //   323: aload_1        
        //   324: ldc             6
        //   326: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   329: if_acmpeq       370
        //   332: aload           15
        //   334: ldc_w           2
        //   337: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   340: ifnull          493
        //   343: aload_1        
        //   344: aload           15
        //   346: ldc_w           2
        //   349: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   352: ldc_w           1
        //   355: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   358: invokevirtual   java/lang/Object.equals:(Ljava/lang/Object;)Z
        //   361: ldc_w           1
        //   364: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   367: ifeq            493
        //   370: aload_2        
        //   371: aload_1        
        //   372: aload           13
        //   374: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$Node.val:Ljava/lang/Object;
        //   377: ldc_w           5
        //   380: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   383: invokeinterface instrumented/java/util/function/BiFunction.apply:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   388: astore          4
        //   390: ldc_w           1
        //   393: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   396: aload           4
        //   398: ldc_w           2
        //   401: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   404: ifnull          422
        //   407: aload           13
        //   409: aload           4
        //   411: putfield        instrumented/java/util/concurrent/ConcurrentHashMap$Node.val:Ljava/lang/Object;
        //   414: ldc             4
        //   416: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   419: goto            541
        //   422: iconst_m1      
        //   423: istore          5
        //   425: ldc_w           2
        //   428: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   431: aload           13
        //   433: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$Node.next:Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //   436: astore          16
        //   438: ldc_w           3
        //   441: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   444: aload           14
        //   446: ldc_w           2
        //   449: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   452: ifnull          470
        //   455: aload           14
        //   457: aload           16
        //   459: putfield        instrumented/java/util/concurrent/ConcurrentHashMap$Node.next:Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //   462: ldc             4
        //   464: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   467: goto            484
        //   470: aload           7
        //   472: iload           10
        //   474: aload           16
        //   476: ldc             4
        //   478: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   481: invokestatic    instrumented/java/util/concurrent/ConcurrentHashMap.setTabAt:([Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;ILinstrumented/java/util/concurrent/ConcurrentHashMap$Node;)V
        //   484: ldc_w           1
        //   487: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   490: goto            541
        //   493: aload           13
        //   495: astore          14
        //   497: ldc_w           2
        //   500: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   503: aload           13
        //   505: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$Node.next:Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //   508: dup            
        //   509: astore          13
        //   511: ldc_w           5
        //   514: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   517: ifnonnull       529
        //   520: ldc_w           1
        //   523: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   526: goto            541
        //   529: iinc            6, 1
        //   532: ldc_w           2
        //   535: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   538: goto            301
        //   541: ldc_w           1
        //   544: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   547: goto            744
        //   550: aload           8
        //   552: instanceof      Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeBin;
        //   555: ldc_w           3
        //   558: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   561: ifeq            744
        //   564: iconst_2       
        //   565: istore          6
        //   567: ldc_w           2
        //   570: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   573: aload           8
        //   575: checkcast       Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeBin;
        //   578: astore          13
        //   580: ldc_w           3
        //   583: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   586: aload           13
        //   588: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeBin.root:Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
        //   591: dup            
        //   592: astore          14
        //   594: ldc_w           5
        //   597: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   600: ifnull          744
        //   603: aload           14
        //   605: iload_3        
        //   606: aload_1        
        //   607: aconst_null    
        //   608: ldc             4
        //   610: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   613: ldc_w           1
        //   616: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   619: invokevirtual   instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.findTreeNode:(ILjava/lang/Object;Ljava/lang/Class;)Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
        //   622: dup            
        //   623: astore          15
        //   625: ldc_w           3
        //   628: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   631: ifnull          744
        //   634: aload_2        
        //   635: aload_1        
        //   636: aload           15
        //   638: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.val:Ljava/lang/Object;
        //   641: ldc_w           5
        //   644: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   647: invokeinterface instrumented/java/util/function/BiFunction.apply:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   652: astore          4
        //   654: ldc_w           1
        //   657: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   660: aload           4
        //   662: ldc_w           2
        //   665: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   668: ifnull          686
        //   671: aload           15
        //   673: aload           4
        //   675: putfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.val:Ljava/lang/Object;
        //   678: ldc             4
        //   680: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   683: goto            744
        //   686: iconst_m1      
        //   687: istore          5
        //   689: ldc_w           2
        //   692: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   695: aload           13
        //   697: aload           15
        //   699: ldc_w           3
        //   702: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   705: invokevirtual   instrumented/java/util/concurrent/ConcurrentHashMap$TreeBin.removeTreeNode:(Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;)Z
        //   708: ldc_w           1
        //   711: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   714: ifeq            744
        //   717: aload           7
        //   719: iload           10
        //   721: aload           13
        //   723: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeBin.first:Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
        //   726: ldc_w           5
        //   729: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   732: invokestatic    instrumented/java/util/concurrent/ConcurrentHashMap.untreeify:(Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;)Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //   735: ldc_w           1
        //   738: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   741: invokestatic    instrumented/java/util/concurrent/ConcurrentHashMap.setTabAt:([Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;ILinstrumented/java/util/concurrent/ConcurrentHashMap$Node;)V
        //   744: aload           12
        //   746: pop            
        //   747: ldc_w           2
        //   750: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   753: ldc_w           1
        //   756: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   759: goto            782
        //   762: astore          17
        //   764: aload           12
        //   766: pop            
        //   767: ldc_w           503
        //   770: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   773: aload           17
        //   775: ldc_w           2
        //   778: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   781: athrow         
        //   782: iload           6
        //   784: ldc_w           2
        //   787: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   790: ifeq            802
        //   793: ldc_w           1
        //   796: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   799: goto            811
        //   802: ldc_w           1
        //   805: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   808: goto            105
        //   811: iload           5
        //   813: ldc_w           2
        //   816: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   819: ifeq            837
        //   822: aload_0        
        //   823: iload           5
        //   825: i2l            
        //   826: iload           6
        //   828: ldc_w           5
        //   831: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   834: invokespecial   instrumented/java/util/concurrent/ConcurrentHashMap.addCount:(JI)V
        //   837: aload           4
        //   839: ldc_w           2
        //   842: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   845: areturn        
        //   846: athrow         
        //   847: athrow         
        //    Signature:
        //  (TK;Linstrumented/java/util/function/BiFunction<-TK;-TV;+TV;>;)TV;
        //    StackMapTable: 00 19 14 13 FF 00 40 00 08 07 00 02 07 01 08 07 02 5D 01 07 01 08 01 01 07 01 7D 00 00 19 FD 00 14 00 01 FF 00 28 00 0B 07 00 02 07 01 08 07 02 5D 01 07 01 08 01 01 07 01 7D 07 00 82 01 01 00 00 FC 00 28 01 FE 00 42 07 01 08 07 00 82 07 00 82 FC 00 44 07 01 08 33 FC 00 2F 07 00 82 FA 00 0D FA 00 08 23 F9 00 0B 08 FE 00 87 07 00 A6 07 00 A9 07 00 A9 F8 00 39 51 07 00 FD FA 00 13 FF 00 13 00 08 07 00 02 07 01 08 07 02 5D 01 07 01 08 01 01 07 01 7D 00 00 FA 00 08 19 FF 00 08 00 00 00 01 07 00 FD FF 00 00 00 00 00 01 07 01 9E
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  245    847    847    848    Ljava/lang/VirtualMachineError;
        //  245    753    762    782    Any
        //  762    773    762    782    Any
        //  0      846    846    847    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0301:
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
    public V compute(final K p0, final BiFunction<? super K, ? super V, ? extends V> p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc_w           2
        //     4: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     7: ifnull          20
        //    10: aload_2        
        //    11: ldc_w           2
        //    14: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    17: ifnonnull       40
        //    20: new             Ljava/lang/NullPointerException;
        //    23: dup            
        //    24: ldc_w           3
        //    27: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    30: invokespecial   java/lang/NullPointerException.<init>:()V
        //    33: ldc_w           1
        //    36: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    39: athrow         
        //    40: aload_1        
        //    41: ldc_w           2
        //    44: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    47: invokevirtual   java/lang/Object.hashCode:()I
        //    50: ldc_w           1
        //    53: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    56: invokestatic    instrumented/java/util/concurrent/ConcurrentHashMap.spread:(I)I
        //    59: istore_3       
        //    60: ldc_w           1
        //    63: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    66: aconst_null    
        //    67: astore          4
        //    69: ldc_w           2
        //    72: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    75: iconst_0       
        //    76: istore          5
        //    78: ldc_w           2
        //    81: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    84: iconst_0       
        //    85: istore          6
        //    87: ldc_w           2
        //    90: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    93: aload_0        
        //    94: getfield        instrumented/java/util/concurrent/ConcurrentHashMap.table:[Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //    97: astore          7
        //    99: ldc_w           3
        //   102: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   105: aload           7
        //   107: ldc_w           2
        //   110: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   113: ifnull          131
        //   116: aload           7
        //   118: arraylength    
        //   119: dup            
        //   120: istore          9
        //   122: ldc_w           5
        //   125: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   128: ifne            152
        //   131: aload_0        
        //   132: ldc_w           2
        //   135: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   138: invokespecial   instrumented/java/util/concurrent/ConcurrentHashMap.initTable:()[Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //   141: astore          7
        //   143: ldc_w           2
        //   146: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   149: goto            1233
        //   152: aload           7
        //   154: iload           9
        //   156: iconst_1       
        //   157: isub           
        //   158: iload_3        
        //   159: iand           
        //   160: dup            
        //   161: istore          10
        //   163: ldc_w           9
        //   166: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   169: invokestatic    instrumented/java/util/concurrent/ConcurrentHashMap.tabAt:([Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;I)Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //   172: dup            
        //   173: astore          8
        //   175: ldc_w           3
        //   178: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   181: ifnonnull       440
        //   184: new             Linstrumented/java/util/concurrent/ConcurrentHashMap$ReservationNode;
        //   187: dup            
        //   188: ldc_w           3
        //   191: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   194: invokespecial   instrumented/java/util/concurrent/ConcurrentHashMap$ReservationNode.<init>:()V
        //   197: astore          12
        //   199: ldc_w           1
        //   202: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   205: aload           12
        //   207: dup            
        //   208: astore          13
        //   210: pop            
        //   211: ldc             4
        //   213: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   216: aload           7
        //   218: iload           10
        //   220: aconst_null    
        //   221: aload           12
        //   223: ldc_w           5
        //   226: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   229: invokestatic    instrumented/java/util/concurrent/ConcurrentHashMap.casTabAt:([Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;ILinstrumented/java/util/concurrent/ConcurrentHashMap$Node;Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;)Z
        //   232: ldc_w           1
        //   235: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   238: ifeq            373
        //   241: iconst_1       
        //   242: istore          6
        //   244: ldc_w           2
        //   247: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   250: aconst_null    
        //   251: astore          14
        //   253: ldc_w           2
        //   256: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   259: aload_2        
        //   260: aload_1        
        //   261: aconst_null    
        //   262: ldc             4
        //   264: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   267: invokeinterface instrumented/java/util/function/BiFunction.apply:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   272: dup            
        //   273: astore          4
        //   275: ldc_w           3
        //   278: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   281: ifnull          319
        //   284: iconst_1       
        //   285: istore          5
        //   287: ldc_w           2
        //   290: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   293: new             Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //   296: dup            
        //   297: iload_3        
        //   298: aload_1        
        //   299: aload           4
        //   301: aconst_null    
        //   302: ldc_w           7
        //   305: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   308: invokespecial   instrumented/java/util/concurrent/ConcurrentHashMap$Node.<init>:(ILjava/lang/Object;Ljava/lang/Object;Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;)V
        //   311: astore          14
        //   313: ldc_w           1
        //   316: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   319: aload           7
        //   321: iload           10
        //   323: aload           14
        //   325: ldc             4
        //   327: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   330: invokestatic    instrumented/java/util/concurrent/ConcurrentHashMap.setTabAt:([Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;ILinstrumented/java/util/concurrent/ConcurrentHashMap$Node;)V
        //   333: ldc_w           1
        //   336: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   339: goto            373
        //   342: astore          15
        //   344: ldc_w           501
        //   347: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   350: aload           7
        //   352: iload           10
        //   354: aload           14
        //   356: ldc             4
        //   358: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   361: invokestatic    instrumented/java/util/concurrent/ConcurrentHashMap.setTabAt:([Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;ILinstrumented/java/util/concurrent/ConcurrentHashMap$Node;)V
        //   364: aload           15
        //   366: ldc_w           2
        //   369: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   372: athrow         
        //   373: aload           13
        //   375: pop            
        //   376: ldc_w           2
        //   379: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   382: ldc_w           1
        //   385: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   388: goto            411
        //   391: astore          16
        //   393: aload           13
        //   395: pop            
        //   396: ldc_w           503
        //   399: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   402: aload           16
        //   404: ldc_w           2
        //   407: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   410: athrow         
        //   411: iload           6
        //   413: ldc_w           2
        //   416: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   419: ifeq            431
        //   422: ldc_w           1
        //   425: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   428: goto            1242
        //   431: ldc_w           1
        //   434: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   437: goto            1233
        //   440: aload           8
        //   442: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$Node.hash:I
        //   445: dup            
        //   446: istore          11
        //   448: iconst_m1      
        //   449: ldc             6
        //   451: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   454: if_icmpne       481
        //   457: aload_0        
        //   458: aload           7
        //   460: aload           8
        //   462: ldc             4
        //   464: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   467: invokevirtual   instrumented/java/util/concurrent/ConcurrentHashMap.helpTransfer:([Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;)[Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //   470: astore          7
        //   472: ldc_w           2
        //   475: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   478: goto            1233
        //   481: aload           8
        //   483: dup            
        //   484: astore          12
        //   486: pop            
        //   487: ldc             4
        //   489: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   492: aload           7
        //   494: iload           10
        //   496: ldc_w           3
        //   499: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   502: invokestatic    instrumented/java/util/concurrent/ConcurrentHashMap.tabAt:([Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;I)Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //   505: aload           8
        //   507: ldc_w           2
        //   510: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   513: if_acmpne       1149
        //   516: iload           11
        //   518: ldc_w           2
        //   521: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   524: iflt            860
        //   527: iconst_1       
        //   528: istore          6
        //   530: ldc_w           2
        //   533: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   536: aload           8
        //   538: astore          13
        //   540: aconst_null    
        //   541: astore          14
        //   543: ldc             4
        //   545: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   548: aload           13
        //   550: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$Node.hash:I
        //   553: iload_3        
        //   554: ldc             4
        //   556: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   559: if_icmpne       740
        //   562: aload           13
        //   564: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$Node.key:Ljava/lang/Object;
        //   567: dup            
        //   568: astore          15
        //   570: aload_1        
        //   571: ldc             6
        //   573: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   576: if_acmpeq       617
        //   579: aload           15
        //   581: ldc_w           2
        //   584: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   587: ifnull          740
        //   590: aload_1        
        //   591: aload           15
        //   593: ldc_w           2
        //   596: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   599: ldc_w           1
        //   602: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   605: invokevirtual   java/lang/Object.equals:(Ljava/lang/Object;)Z
        //   608: ldc_w           1
        //   611: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   614: ifeq            740
        //   617: aload_2        
        //   618: aload_1        
        //   619: aload           13
        //   621: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$Node.val:Ljava/lang/Object;
        //   624: ldc_w           5
        //   627: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   630: invokeinterface instrumented/java/util/function/BiFunction.apply:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   635: astore          4
        //   637: ldc_w           1
        //   640: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   643: aload           4
        //   645: ldc_w           2
        //   648: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   651: ifnull          669
        //   654: aload           13
        //   656: aload           4
        //   658: putfield        instrumented/java/util/concurrent/ConcurrentHashMap$Node.val:Ljava/lang/Object;
        //   661: ldc             4
        //   663: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   666: goto            851
        //   669: iconst_m1      
        //   670: istore          5
        //   672: ldc_w           2
        //   675: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   678: aload           13
        //   680: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$Node.next:Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //   683: astore          16
        //   685: ldc_w           3
        //   688: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   691: aload           14
        //   693: ldc_w           2
        //   696: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   699: ifnull          717
        //   702: aload           14
        //   704: aload           16
        //   706: putfield        instrumented/java/util/concurrent/ConcurrentHashMap$Node.next:Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //   709: ldc             4
        //   711: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   714: goto            731
        //   717: aload           7
        //   719: iload           10
        //   721: aload           16
        //   723: ldc             4
        //   725: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   728: invokestatic    instrumented/java/util/concurrent/ConcurrentHashMap.setTabAt:([Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;ILinstrumented/java/util/concurrent/ConcurrentHashMap$Node;)V
        //   731: ldc_w           1
        //   734: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   737: goto            851
        //   740: aload           13
        //   742: astore          14
        //   744: ldc_w           2
        //   747: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   750: aload           13
        //   752: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$Node.next:Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //   755: dup            
        //   756: astore          13
        //   758: ldc_w           5
        //   761: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   764: ifnonnull       839
        //   767: aload_2        
        //   768: aload_1        
        //   769: aconst_null    
        //   770: ldc             4
        //   772: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   775: invokeinterface instrumented/java/util/function/BiFunction.apply:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   780: astore          4
        //   782: ldc_w           1
        //   785: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   788: aload           4
        //   790: ldc_w           2
        //   793: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   796: ifnull          851
        //   799: iconst_1       
        //   800: istore          5
        //   802: ldc_w           2
        //   805: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   808: aload           14
        //   810: new             Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //   813: dup            
        //   814: iload_3        
        //   815: aload_1        
        //   816: aload           4
        //   818: aconst_null    
        //   819: ldc             8
        //   821: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   824: invokespecial   instrumented/java/util/concurrent/ConcurrentHashMap$Node.<init>:(ILjava/lang/Object;Ljava/lang/Object;Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;)V
        //   827: putfield        instrumented/java/util/concurrent/ConcurrentHashMap$Node.next:Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //   830: ldc_w           2
        //   833: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   836: goto            851
        //   839: iinc            6, 1
        //   842: ldc_w           2
        //   845: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   848: goto            548
        //   851: ldc_w           1
        //   854: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   857: goto            1149
        //   860: aload           8
        //   862: instanceof      Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeBin;
        //   865: ldc_w           3
        //   868: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   871: ifeq            1149
        //   874: iconst_1       
        //   875: istore          6
        //   877: ldc_w           2
        //   880: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   883: aload           8
        //   885: checkcast       Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeBin;
        //   888: astore          13
        //   890: ldc_w           3
        //   893: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   896: aload           13
        //   898: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeBin.root:Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
        //   901: dup            
        //   902: astore          14
        //   904: ldc_w           5
        //   907: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   910: ifnull          938
        //   913: aload           14
        //   915: iload_3        
        //   916: aload_1        
        //   917: aconst_null    
        //   918: ldc_w           5
        //   921: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   924: invokevirtual   instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.findTreeNode:(ILjava/lang/Object;Ljava/lang/Class;)Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
        //   927: astore          15
        //   929: ldc_w           2
        //   932: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   935: goto            947
        //   938: aconst_null    
        //   939: astore          15
        //   941: ldc_w           2
        //   944: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   947: aload           15
        //   949: ldc_w           2
        //   952: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   955: ifnonnull       968
        //   958: aconst_null    
        //   959: ldc_w           2
        //   962: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   965: goto            979
        //   968: aload           15
        //   970: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.val:Ljava/lang/Object;
        //   973: ldc_w           2
        //   976: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   979: astore          16
        //   981: ldc_w           1
        //   984: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   987: aload_2        
        //   988: aload_1        
        //   989: aload           16
        //   991: ldc             4
        //   993: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   996: invokeinterface instrumented/java/util/function/BiFunction.apply:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //  1001: astore          4
        //  1003: ldc_w           1
        //  1006: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1009: aload           4
        //  1011: ldc_w           2
        //  1014: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1017: ifnull          1080
        //  1020: aload           15
        //  1022: ldc_w           2
        //  1025: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1028: ifnull          1046
        //  1031: aload           15
        //  1033: aload           4
        //  1035: putfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.val:Ljava/lang/Object;
        //  1038: ldc             4
        //  1040: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1043: goto            1149
        //  1046: iconst_1       
        //  1047: istore          5
        //  1049: ldc_w           2
        //  1052: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1055: aload           13
        //  1057: iload_3        
        //  1058: aload_1        
        //  1059: aload           4
        //  1061: ldc_w           5
        //  1064: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1067: invokevirtual   instrumented/java/util/concurrent/ConcurrentHashMap$TreeBin.putTreeVal:(ILjava/lang/Object;Ljava/lang/Object;)Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
        //  1070: pop            
        //  1071: ldc_w           2
        //  1074: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1077: goto            1149
        //  1080: aload           15
        //  1082: ldc_w           2
        //  1085: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1088: ifnull          1149
        //  1091: iconst_m1      
        //  1092: istore          5
        //  1094: ldc_w           2
        //  1097: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1100: aload           13
        //  1102: aload           15
        //  1104: ldc_w           3
        //  1107: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1110: invokevirtual   instrumented/java/util/concurrent/ConcurrentHashMap$TreeBin.removeTreeNode:(Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;)Z
        //  1113: ldc_w           1
        //  1116: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1119: ifeq            1149
        //  1122: aload           7
        //  1124: iload           10
        //  1126: aload           13
        //  1128: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeBin.first:Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
        //  1131: ldc_w           5
        //  1134: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1137: invokestatic    instrumented/java/util/concurrent/ConcurrentHashMap.untreeify:(Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;)Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //  1140: ldc_w           1
        //  1143: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1146: invokestatic    instrumented/java/util/concurrent/ConcurrentHashMap.setTabAt:([Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;ILinstrumented/java/util/concurrent/ConcurrentHashMap$Node;)V
        //  1149: aload           12
        //  1151: pop            
        //  1152: ldc_w           2
        //  1155: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1158: ldc_w           1
        //  1161: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1164: goto            1187
        //  1167: astore          17
        //  1169: aload           12
        //  1171: pop            
        //  1172: ldc_w           503
        //  1175: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1178: aload           17
        //  1180: ldc_w           2
        //  1183: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1186: athrow         
        //  1187: iload           6
        //  1189: ldc_w           2
        //  1192: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1195: ifeq            1233
        //  1198: iload           6
        //  1200: bipush          8
        //  1202: ldc_w           3
        //  1205: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1208: if_icmplt       1242
        //  1211: aload_0        
        //  1212: aload           7
        //  1214: iload           10
        //  1216: ldc             4
        //  1218: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1221: invokespecial   instrumented/java/util/concurrent/ConcurrentHashMap.treeifyBin:([Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;I)V
        //  1224: ldc_w           1
        //  1227: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1230: goto            1242
        //  1233: ldc_w           1
        //  1236: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1239: goto            105
        //  1242: iload           5
        //  1244: ldc_w           2
        //  1247: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1250: ifeq            1268
        //  1253: aload_0        
        //  1254: iload           5
        //  1256: i2l            
        //  1257: iload           6
        //  1259: ldc_w           5
        //  1262: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1265: invokespecial   instrumented/java/util/concurrent/ConcurrentHashMap.addCount:(JI)V
        //  1268: aload           4
        //  1270: ldc_w           2
        //  1273: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1276: areturn        
        //  1277: athrow         
        //  1278: athrow         
        //    Signature:
        //  (TK;Linstrumented/java/util/function/BiFunction<-TK;-TV;+TV;>;)TV;
        //    StackMapTable: 00 24 14 13 FF 00 40 00 08 07 00 02 07 01 08 07 02 5D 01 07 01 08 01 01 07 01 7D 00 00 19 FD 00 14 00 01 FF 00 A6 00 0F 07 00 02 07 01 08 07 02 5D 01 07 01 08 01 01 07 01 7D 07 00 82 01 01 00 07 00 82 07 01 08 07 00 82 00 00 56 07 00 FD FA 00 1E 51 07 00 FD FA 00 13 F9 00 13 08 FC 00 28 01 FE 00 42 07 01 08 07 00 82 07 00 82 FC 00 44 07 01 08 33 FC 00 2F 07 00 82 FA 00 0D FA 00 08 FB 00 62 F9 00 0B 08 FD 00 4D 07 00 A6 07 00 A9 FC 00 08 07 00 A9 14 4A 07 01 08 FC 00 42 07 01 08 21 FF 00 44 00 0D 07 00 02 07 01 08 07 02 5D 01 07 01 08 01 01 07 01 7D 07 00 82 01 01 01 07 01 08 00 00 51 07 00 FD FA 00 13 FF 00 2D 00 08 07 00 02 07 01 08 07 02 5D 01 07 01 08 01 01 07 01 7D 00 00 FA 00 08 19 FF 00 08 00 00 00 01 07 00 FD FF 00 00 00 00 00 01 07 01 9E
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  216    1278   1278   1279   Ljava/lang/VirtualMachineError;
        //  259    319    342    373    Any
        //  342    350    342    373    Any
        //  216    382    391    411    Any
        //  391    402    391    411    Any
        //  492    1158   1167   1187   Any
        //  1167   1178   1167   1187   Any
        //  0      1277   1277   1278   Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0319:
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
    public V merge(final K p0, final V p1, final BiFunction<? super V, ? super V, ? extends V> p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc_w           2
        //     4: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     7: ifnull          30
        //    10: aload_2        
        //    11: ldc_w           2
        //    14: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    17: ifnull          30
        //    20: aload_3        
        //    21: ldc_w           2
        //    24: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    27: ifnonnull       50
        //    30: new             Ljava/lang/NullPointerException;
        //    33: dup            
        //    34: ldc_w           3
        //    37: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    40: invokespecial   java/lang/NullPointerException.<init>:()V
        //    43: ldc_w           1
        //    46: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    49: athrow         
        //    50: aload_1        
        //    51: ldc_w           2
        //    54: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    57: invokevirtual   java/lang/Object.hashCode:()I
        //    60: ldc_w           1
        //    63: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    66: invokestatic    instrumented/java/util/concurrent/ConcurrentHashMap.spread:(I)I
        //    69: istore          4
        //    71: ldc_w           1
        //    74: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    77: aconst_null    
        //    78: astore          5
        //    80: ldc_w           2
        //    83: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    86: iconst_0       
        //    87: istore          6
        //    89: ldc_w           2
        //    92: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    95: iconst_0       
        //    96: istore          7
        //    98: ldc_w           2
        //   101: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   104: aload_0        
        //   105: getfield        instrumented/java/util/concurrent/ConcurrentHashMap.table:[Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //   108: astore          8
        //   110: ldc_w           3
        //   113: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   116: aload           8
        //   118: ldc_w           2
        //   121: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   124: ifnull          142
        //   127: aload           8
        //   129: arraylength    
        //   130: dup            
        //   131: istore          10
        //   133: ldc_w           5
        //   136: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   139: ifne            163
        //   142: aload_0        
        //   143: ldc_w           2
        //   146: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   149: invokespecial   instrumented/java/util/concurrent/ConcurrentHashMap.initTable:()[Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //   152: astore          8
        //   154: ldc_w           2
        //   157: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   160: goto            1044
        //   163: aload           8
        //   165: iload           10
        //   167: iconst_1       
        //   168: isub           
        //   169: iload           4
        //   171: iand           
        //   172: dup            
        //   173: istore          11
        //   175: ldc_w           9
        //   178: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   181: invokestatic    instrumented/java/util/concurrent/ConcurrentHashMap.tabAt:([Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;I)Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //   184: dup            
        //   185: astore          9
        //   187: ldc_w           3
        //   190: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   193: ifnonnull       264
        //   196: aload           8
        //   198: iload           11
        //   200: aconst_null    
        //   201: new             Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //   204: dup            
        //   205: iload           4
        //   207: aload_1        
        //   208: aload_2        
        //   209: aconst_null    
        //   210: ldc_w           10
        //   213: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   216: invokespecial   instrumented/java/util/concurrent/ConcurrentHashMap$Node.<init>:(ILjava/lang/Object;Ljava/lang/Object;Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;)V
        //   219: ldc_w           1
        //   222: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   225: invokestatic    instrumented/java/util/concurrent/ConcurrentHashMap.casTabAt:([Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;ILinstrumented/java/util/concurrent/ConcurrentHashMap$Node;Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;)Z
        //   228: ldc_w           1
        //   231: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   234: ifeq            1044
        //   237: iconst_1       
        //   238: istore          6
        //   240: ldc_w           2
        //   243: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   246: aload_2        
        //   247: astore          5
        //   249: ldc_w           2
        //   252: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   255: ldc_w           1
        //   258: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   261: goto            1053
        //   264: aload           9
        //   266: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$Node.hash:I
        //   269: dup            
        //   270: istore          12
        //   272: iconst_m1      
        //   273: ldc             6
        //   275: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   278: if_icmpne       305
        //   281: aload_0        
        //   282: aload           8
        //   284: aload           9
        //   286: ldc             4
        //   288: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   291: invokevirtual   instrumented/java/util/concurrent/ConcurrentHashMap.helpTransfer:([Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;)[Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //   294: astore          8
        //   296: ldc_w           2
        //   299: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   302: goto            1044
        //   305: aload           9
        //   307: dup            
        //   308: astore          13
        //   310: pop            
        //   311: ldc             4
        //   313: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   316: aload           8
        //   318: iload           11
        //   320: ldc_w           3
        //   323: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   326: invokestatic    instrumented/java/util/concurrent/ConcurrentHashMap.tabAt:([Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;I)Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //   329: aload           9
        //   331: ldc_w           2
        //   334: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   337: if_acmpne       960
        //   340: iload           12
        //   342: ldc_w           2
        //   345: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   348: iflt            669
        //   351: iconst_1       
        //   352: istore          7
        //   354: ldc_w           2
        //   357: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   360: aload           9
        //   362: astore          14
        //   364: aconst_null    
        //   365: astore          15
        //   367: ldc             4
        //   369: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   372: aload           14
        //   374: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$Node.hash:I
        //   377: iload           4
        //   379: ldc             4
        //   381: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   384: if_icmpne       565
        //   387: aload           14
        //   389: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$Node.key:Ljava/lang/Object;
        //   392: dup            
        //   393: astore          16
        //   395: aload_1        
        //   396: ldc             6
        //   398: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   401: if_acmpeq       442
        //   404: aload           16
        //   406: ldc_w           2
        //   409: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   412: ifnull          565
        //   415: aload_1        
        //   416: aload           16
        //   418: ldc_w           2
        //   421: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   424: ldc_w           1
        //   427: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   430: invokevirtual   java/lang/Object.equals:(Ljava/lang/Object;)Z
        //   433: ldc_w           1
        //   436: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   439: ifeq            565
        //   442: aload_3        
        //   443: aload           14
        //   445: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$Node.val:Ljava/lang/Object;
        //   448: aload_2        
        //   449: ldc_w           5
        //   452: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   455: invokeinterface instrumented/java/util/function/BiFunction.apply:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   460: astore          5
        //   462: ldc_w           1
        //   465: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   468: aload           5
        //   470: ldc_w           2
        //   473: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   476: ifnull          494
        //   479: aload           14
        //   481: aload           5
        //   483: putfield        instrumented/java/util/concurrent/ConcurrentHashMap$Node.val:Ljava/lang/Object;
        //   486: ldc             4
        //   488: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   491: goto            660
        //   494: iconst_m1      
        //   495: istore          6
        //   497: ldc_w           2
        //   500: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   503: aload           14
        //   505: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$Node.next:Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //   508: astore          17
        //   510: ldc_w           3
        //   513: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   516: aload           15
        //   518: ldc_w           2
        //   521: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   524: ifnull          542
        //   527: aload           15
        //   529: aload           17
        //   531: putfield        instrumented/java/util/concurrent/ConcurrentHashMap$Node.next:Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //   534: ldc             4
        //   536: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   539: goto            556
        //   542: aload           8
        //   544: iload           11
        //   546: aload           17
        //   548: ldc             4
        //   550: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   553: invokestatic    instrumented/java/util/concurrent/ConcurrentHashMap.setTabAt:([Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;ILinstrumented/java/util/concurrent/ConcurrentHashMap$Node;)V
        //   556: ldc_w           1
        //   559: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   562: goto            660
        //   565: aload           14
        //   567: astore          15
        //   569: ldc_w           2
        //   572: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   575: aload           14
        //   577: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$Node.next:Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //   580: dup            
        //   581: astore          14
        //   583: ldc_w           5
        //   586: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   589: ifnonnull       648
        //   592: iconst_1       
        //   593: istore          6
        //   595: ldc_w           2
        //   598: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   601: aload_2        
        //   602: astore          5
        //   604: ldc_w           2
        //   607: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   610: aload           15
        //   612: new             Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //   615: dup            
        //   616: iload           4
        //   618: aload_1        
        //   619: aload           5
        //   621: aconst_null    
        //   622: ldc             8
        //   624: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   627: invokespecial   instrumented/java/util/concurrent/ConcurrentHashMap$Node.<init>:(ILjava/lang/Object;Ljava/lang/Object;Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;)V
        //   630: putfield        instrumented/java/util/concurrent/ConcurrentHashMap$Node.next:Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //   633: ldc_w           1
        //   636: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   639: ldc_w           1
        //   642: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   645: goto            660
        //   648: iinc            7, 1
        //   651: ldc_w           2
        //   654: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   657: goto            372
        //   660: ldc_w           1
        //   663: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   666: goto            960
        //   669: aload           9
        //   671: instanceof      Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeBin;
        //   674: ldc_w           3
        //   677: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   680: ifeq            960
        //   683: iconst_2       
        //   684: istore          7
        //   686: ldc_w           2
        //   689: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   692: aload           9
        //   694: checkcast       Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeBin;
        //   697: astore          14
        //   699: ldc_w           3
        //   702: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   705: aload           14
        //   707: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeBin.root:Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
        //   710: astore          15
        //   712: ldc_w           3
        //   715: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   718: aload           15
        //   720: ldc_w           2
        //   723: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   726: ifnonnull       739
        //   729: aconst_null    
        //   730: ldc_w           2
        //   733: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   736: goto            759
        //   739: aload           15
        //   741: iload           4
        //   743: aload_1        
        //   744: aconst_null    
        //   745: ldc             4
        //   747: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   750: ldc_w           1
        //   753: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   756: invokevirtual   instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.findTreeNode:(ILjava/lang/Object;Ljava/lang/Class;)Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
        //   759: astore          16
        //   761: ldc_w           1
        //   764: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   767: aload           16
        //   769: ldc_w           2
        //   772: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   775: ifnonnull       788
        //   778: aload_2        
        //   779: ldc_w           2
        //   782: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   785: goto            811
        //   788: aload_3        
        //   789: aload           16
        //   791: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.val:Ljava/lang/Object;
        //   794: aload_2        
        //   795: ldc             4
        //   797: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   800: ldc_w           1
        //   803: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   806: invokeinterface instrumented/java/util/function/BiFunction.apply:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   811: astore          5
        //   813: ldc_w           1
        //   816: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   819: aload           5
        //   821: ldc_w           2
        //   824: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   827: ifnull          891
        //   830: aload           16
        //   832: ldc_w           2
        //   835: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   838: ifnull          856
        //   841: aload           16
        //   843: aload           5
        //   845: putfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.val:Ljava/lang/Object;
        //   848: ldc             4
        //   850: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   853: goto            960
        //   856: iconst_1       
        //   857: istore          6
        //   859: ldc_w           2
        //   862: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   865: aload           14
        //   867: iload           4
        //   869: aload_1        
        //   870: aload           5
        //   872: ldc_w           5
        //   875: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   878: invokevirtual   instrumented/java/util/concurrent/ConcurrentHashMap$TreeBin.putTreeVal:(ILjava/lang/Object;Ljava/lang/Object;)Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
        //   881: pop            
        //   882: ldc_w           2
        //   885: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   888: goto            960
        //   891: aload           16
        //   893: ldc_w           2
        //   896: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   899: ifnull          960
        //   902: iconst_m1      
        //   903: istore          6
        //   905: ldc_w           2
        //   908: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   911: aload           14
        //   913: aload           16
        //   915: ldc_w           3
        //   918: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   921: invokevirtual   instrumented/java/util/concurrent/ConcurrentHashMap$TreeBin.removeTreeNode:(Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;)Z
        //   924: ldc_w           1
        //   927: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   930: ifeq            960
        //   933: aload           8
        //   935: iload           11
        //   937: aload           14
        //   939: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeBin.first:Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
        //   942: ldc_w           5
        //   945: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   948: invokestatic    instrumented/java/util/concurrent/ConcurrentHashMap.untreeify:(Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;)Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //   951: ldc_w           1
        //   954: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   957: invokestatic    instrumented/java/util/concurrent/ConcurrentHashMap.setTabAt:([Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;ILinstrumented/java/util/concurrent/ConcurrentHashMap$Node;)V
        //   960: aload           13
        //   962: pop            
        //   963: ldc_w           2
        //   966: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   969: ldc_w           1
        //   972: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   975: goto            998
        //   978: astore          18
        //   980: aload           13
        //   982: pop            
        //   983: ldc_w           503
        //   986: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   989: aload           18
        //   991: ldc_w           2
        //   994: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   997: athrow         
        //   998: iload           7
        //  1000: ldc_w           2
        //  1003: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1006: ifeq            1044
        //  1009: iload           7
        //  1011: bipush          8
        //  1013: ldc_w           3
        //  1016: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1019: if_icmplt       1053
        //  1022: aload_0        
        //  1023: aload           8
        //  1025: iload           11
        //  1027: ldc             4
        //  1029: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1032: invokespecial   instrumented/java/util/concurrent/ConcurrentHashMap.treeifyBin:([Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;I)V
        //  1035: ldc_w           1
        //  1038: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1041: goto            1053
        //  1044: ldc_w           1
        //  1047: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1050: goto            116
        //  1053: iload           6
        //  1055: ldc_w           2
        //  1058: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1061: ifeq            1079
        //  1064: aload_0        
        //  1065: iload           6
        //  1067: i2l            
        //  1068: iload           7
        //  1070: ldc_w           5
        //  1073: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1076: invokespecial   instrumented/java/util/concurrent/ConcurrentHashMap.addCount:(JI)V
        //  1079: aload           5
        //  1081: ldc_w           2
        //  1084: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1087: areturn        
        //  1088: athrow         
        //  1089: athrow         
        //    Signature:
        //  (TK;TV;Linstrumented/java/util/function/BiFunction<-TV;-TV;+TV;>;)TV;
        //    StackMapTable: 00 1E 1E 13 FF 00 41 00 09 07 00 02 07 01 08 07 01 08 07 02 5D 01 07 01 08 01 01 07 01 7D 00 00 19 FD 00 14 00 01 FF 00 64 00 0C 07 00 02 07 01 08 07 01 08 07 02 5D 01 07 01 08 01 01 07 01 7D 07 00 82 01 01 00 00 FC 00 28 01 FE 00 42 07 01 08 07 00 82 07 00 82 FC 00 45 07 01 08 33 FC 00 2F 07 00 82 FA 00 0D FA 00 08 FB 00 52 F9 00 0B 08 FD 00 45 07 00 A6 07 00 A9 53 07 00 A9 FC 00 1C 07 00 A9 56 07 01 08 2C 22 F8 00 44 51 07 00 FD FA 00 13 FF 00 2D 00 09 07 00 02 07 01 08 07 01 08 07 02 5D 01 07 01 08 01 01 07 01 7D 00 00 FA 00 08 19 FF 00 08 00 00 00 01 07 00 FD FF 00 00 00 00 00 01 07 01 9E
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  316    1089   1089   1090   Ljava/lang/VirtualMachineError;
        //  316    969    978    998    Any
        //  978    989    978    998    Any
        //  0      1088   1088   1089   Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0372:
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
    
    public boolean contains(final Object o) {
        try {
            BytecodeManager.incBytecodes(3);
            final boolean containsValue = this.containsValue(o);
            BytecodeManager.incBytecodes(1);
            return containsValue;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Enumeration<K> keys() {
        try {
            final Node<K, V>[] table;
            final Node<K, V>[] array = table = this.table;
            BytecodeManager.incBytecodes(5);
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
            final Node<K, V>[] array2 = table;
            final int n2 = n;
            final int n3 = 0;
            final int n4 = n;
            BytecodeManager.incBytecodes(8);
            final KeyIterator keyIterator = new KeyIterator<K, Object>(array2, n2, n3, n4, this);
            BytecodeManager.incBytecodes(1);
            return (Enumeration<K>)keyIterator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Enumeration<V> elements() {
        try {
            final Node<K, V>[] table;
            final Node<K, V>[] array = table = this.table;
            BytecodeManager.incBytecodes(5);
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
            final Node<K, V>[] array2 = table;
            final int n2 = n;
            final int n3 = 0;
            final int n4 = n;
            BytecodeManager.incBytecodes(8);
            final ValueIterator valueIterator = new ValueIterator<Object, V>(array2, n2, n3, n4, this);
            BytecodeManager.incBytecodes(1);
            return (Enumeration<V>)valueIterator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public long mappingCount() {
        try {
            BytecodeManager.incBytecodes(2);
            final long sumCount = this.sumCount();
            BytecodeManager.incBytecodes(1);
            final long n = lcmp(sumCount, 0L);
            BytecodeManager.incBytecodes(4);
            long n2;
            if (n < 0) {
                n2 = 0L;
                BytecodeManager.incBytecodes(2);
            }
            else {
                n2 = sumCount;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return n2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <K> KeySetView<K, Boolean> newKeySet() {
        try {
            BytecodeManager.incBytecodes(5);
            final ConcurrentHashMap<Object, Object> concurrentHashMap = new ConcurrentHashMap<Object, Object>();
            final Boolean true = Boolean.TRUE;
            BytecodeManager.incBytecodes(2);
            final KeySetView keySetView = new KeySetView<K, Boolean>(concurrentHashMap, true);
            BytecodeManager.incBytecodes(1);
            return (KeySetView<K, Boolean>)keySetView;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <K> KeySetView<K, Boolean> newKeySet(final int n) {
        try {
            BytecodeManager.incBytecodes(6);
            final ConcurrentHashMap<Object, Object> concurrentHashMap = new ConcurrentHashMap<Object, Object>(n);
            final Boolean true = Boolean.TRUE;
            BytecodeManager.incBytecodes(2);
            final KeySetView keySetView = new KeySetView<K, Boolean>(concurrentHashMap, true);
            BytecodeManager.incBytecodes(1);
            return (KeySetView<K, Boolean>)keySetView;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public KeySetView<K, V> keySet(final V v) {
        try {
            BytecodeManager.incBytecodes(2);
            if (v == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(5);
            final KeySetView<K, V> keySetView = new KeySetView<K, V>(this, v);
            BytecodeManager.incBytecodes(1);
            return keySetView;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static final int resizeStamp(final int i) {
        try {
            BytecodeManager.incBytecodes(2);
            final int n = Integer.numberOfLeadingZeros(i) | 1 << ConcurrentHashMap.RESIZE_STAMP_BITS - 1;
            BytecodeManager.incBytecodes(7);
            return n;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private final Node<K, V>[] initTable() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        instrumented/java/util/concurrent/ConcurrentHashMap.table:[Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //     4: dup            
        //     5: astore_1       
        //     6: ldc_w           5
        //     9: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    12: ifnull          26
        //    15: aload_1        
        //    16: arraylength    
        //    17: ldc_w           3
        //    20: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    23: ifne            237
        //    26: aload_0        
        //    27: getfield        instrumented/java/util/concurrent/ConcurrentHashMap.sizeCtl:I
        //    30: dup            
        //    31: istore_2       
        //    32: ldc_w           5
        //    35: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    38: ifge            59
        //    41: ldc_w           1
        //    44: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    47: invokestatic    java/lang/Thread.yield:()V
        //    50: ldc_w           1
        //    53: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    56: goto            0
        //    59: getstatic       instrumented/java/util/concurrent/ConcurrentHashMap.U:Lsun/misc/Unsafe;
        //    62: aload_0        
        //    63: getstatic       instrumented/java/util/concurrent/ConcurrentHashMap.SIZECTL:J
        //    66: iload_2        
        //    67: iconst_m1      
        //    68: ldc             6
        //    70: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    73: invokevirtual   sun/misc/Unsafe.compareAndSwapInt:(Ljava/lang/Object;JII)Z
        //    76: ldc_w           1
        //    79: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    82: ifeq            0
        //    85: aload_0        
        //    86: getfield        instrumented/java/util/concurrent/ConcurrentHashMap.table:[Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //    89: dup            
        //    90: astore_1       
        //    91: ldc_w           5
        //    94: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    97: ifnull          111
        //   100: aload_1        
        //   101: arraylength    
        //   102: ldc_w           3
        //   105: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   108: ifne            186
        //   111: iload_2        
        //   112: ldc_w           2
        //   115: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   118: ifle            131
        //   121: iload_2        
        //   122: ldc_w           2
        //   125: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   128: goto            139
        //   131: bipush          16
        //   133: ldc_w           1
        //   136: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   139: istore_3       
        //   140: ldc_w           1
        //   143: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   146: iload_3        
        //   147: anewarray       Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //   150: checkcast       [Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //   153: astore          4
        //   155: ldc_w           3
        //   158: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   161: aload_0        
        //   162: aload           4
        //   164: dup            
        //   165: astore_1       
        //   166: putfield        instrumented/java/util/concurrent/ConcurrentHashMap.table:[Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //   169: ldc_w           5
        //   172: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   175: iload_3        
        //   176: iload_3        
        //   177: iconst_2       
        //   178: iushr          
        //   179: isub           
        //   180: istore_2       
        //   181: ldc             6
        //   183: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   186: aload_0        
        //   187: iload_2        
        //   188: putfield        instrumented/java/util/concurrent/ConcurrentHashMap.sizeCtl:I
        //   191: ldc_w           3
        //   194: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   197: ldc_w           1
        //   200: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   203: goto            228
        //   206: astore          5
        //   208: ldc_w           501
        //   211: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   214: aload_0        
        //   215: iload_2        
        //   216: putfield        instrumented/java/util/concurrent/ConcurrentHashMap.sizeCtl:I
        //   219: aload           5
        //   221: ldc_w           5
        //   224: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   227: athrow         
        //   228: ldc_w           1
        //   231: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   234: goto            237
        //   237: aload_1        
        //   238: ldc_w           2
        //   241: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   244: areturn        
        //   245: athrow         
        //   246: athrow         
        //    Signature:
        //  ()[Linstrumented/java/util/concurrent/ConcurrentHashMap$Node<TK;TV;>;
        //    StackMapTable: 00 0C 00 FC 00 19 07 01 7D FC 00 20 01 33 13 47 01 2E 53 07 00 FD 15 FA 00 08 FF 00 07 00 00 00 01 07 00 FD FF 00 00 00 00 00 01 07 01 9E
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  85     246    246    247    Ljava/lang/VirtualMachineError;
        //  85     186    206    228    Any
        //  206    214    206    228    Any
        //  0      245    245    246    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0111:
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
    
    private final void addCount(final long n, final int n2) {
        try {
            final CounterCell[] counterCells;
            final CounterCell[] array = counterCells = this.counterCells;
            BytecodeManager.incBytecodes(5);
            long x = 0L;
            Label_0232: {
                if (array == null) {
                    final Unsafe u = ConcurrentHashMap.U;
                    final long basecount = ConcurrentHashMap.BASECOUNT;
                    final long baseCount = this.baseCount;
                    x = baseCount + n;
                    BytecodeManager.incBytecodes(12);
                    BytecodeManager.incBytecodes(1);
                    final boolean compareAndSwapLong = u.compareAndSwapLong(this, basecount, baseCount, x);
                    BytecodeManager.incBytecodes(1);
                    if (compareAndSwapLong) {
                        break Label_0232;
                    }
                }
                boolean compareAndSwapLong2 = true;
                BytecodeManager.incBytecodes(2);
                final CounterCell[] array2 = counterCells;
                BytecodeManager.incBytecodes(2);
                if (array2 != null) {
                    final int n3 = counterCells.length - 1;
                    BytecodeManager.incBytecodes(7);
                    if (n3 >= 0) {
                        final CounterCell[] array3 = counterCells;
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                        final CounterCell counterCell2;
                        final CounterCell counterCell = counterCell2 = array3[ThreadLocalRandom.getProbe() & n3];
                        BytecodeManager.incBytecodes(6);
                        if (counterCell != null) {
                            final Unsafe u2 = ConcurrentHashMap.U;
                            final CounterCell o = counterCell2;
                            final long cellvalue = ConcurrentHashMap.CELLVALUE;
                            final long value = counterCell2.value;
                            final long x2 = value + n;
                            BytecodeManager.incBytecodes(10);
                            BytecodeManager.incBytecodes(1);
                            compareAndSwapLong2 = u2.compareAndSwapLong(o, cellvalue, value, x2);
                            BytecodeManager.incBytecodes(3);
                            if (compareAndSwapLong2) {
                                final int n4 = 1;
                                BytecodeManager.incBytecodes(3);
                                if (n2 <= n4) {
                                    BytecodeManager.incBytecodes(1);
                                    return;
                                }
                                BytecodeManager.incBytecodes(2);
                                x = this.sumCount();
                                BytecodeManager.incBytecodes(1);
                                break Label_0232;
                            }
                        }
                    }
                }
                final boolean b = compareAndSwapLong2;
                BytecodeManager.incBytecodes(4);
                this.fullAddCount(n, b);
                BytecodeManager.incBytecodes(1);
                return;
            }
            BytecodeManager.incBytecodes(2);
            if (n2 >= 0) {
                while (true) {
                    final int sizeCtl;
                    final long n5 = lcmp(x, (long)(sizeCtl = this.sizeCtl));
                    BytecodeManager.incBytecodes(8);
                    if (n5 < 0) {
                        break;
                    }
                    final Node<K, V>[] table;
                    final Node<K, V>[] array4 = table = this.table;
                    BytecodeManager.incBytecodes(5);
                    if (array4 == null) {
                        break;
                    }
                    final int length = table.length;
                    final int n6 = 1073741824;
                    BytecodeManager.incBytecodes(6);
                    if (length >= n6) {
                        break;
                    }
                    final int n7 = length;
                    BytecodeManager.incBytecodes(2);
                    final int resizeStamp = resizeStamp(n7);
                    BytecodeManager.incBytecodes(1);
                    final int n8 = sizeCtl;
                    BytecodeManager.incBytecodes(2);
                    if (n8 < 0) {
                        final int n9 = sizeCtl >>> ConcurrentHashMap.RESIZE_STAMP_SHIFT;
                        final int n10 = resizeStamp;
                        BytecodeManager.incBytecodes(5);
                        if (n9 != n10) {
                            break;
                        }
                        final int n11 = sizeCtl;
                        final int n12 = resizeStamp + 1;
                        BytecodeManager.incBytecodes(5);
                        if (n11 == n12) {
                            break;
                        }
                        final int n13 = sizeCtl;
                        final int n14 = resizeStamp + ConcurrentHashMap.MAX_RESIZERS;
                        BytecodeManager.incBytecodes(5);
                        if (n13 == n14) {
                            break;
                        }
                        final Node<K, V>[] nextTable = this.nextTable;
                        BytecodeManager.incBytecodes(5);
                        if (nextTable == null) {
                            break;
                        }
                        final int transferIndex = this.transferIndex;
                        BytecodeManager.incBytecodes(3);
                        if (transferIndex <= 0) {
                            BytecodeManager.incBytecodes(1);
                            break;
                        }
                        final Unsafe u3 = ConcurrentHashMap.U;
                        final long sizectl = ConcurrentHashMap.SIZECTL;
                        final int expected = sizeCtl;
                        final int x3 = sizeCtl + 1;
                        BytecodeManager.incBytecodes(8);
                        final boolean compareAndSwapInt = u3.compareAndSwapInt(this, sizectl, expected, x3);
                        BytecodeManager.incBytecodes(1);
                        if (compareAndSwapInt) {
                            final Node<K, V>[] array5 = table;
                            final Node<K, V>[] array6 = nextTable;
                            BytecodeManager.incBytecodes(4);
                            this.transfer(array5, array6);
                            BytecodeManager.incBytecodes(1);
                        }
                    }
                    else {
                        final Unsafe u4 = ConcurrentHashMap.U;
                        final long sizectl2 = ConcurrentHashMap.SIZECTL;
                        final int expected2 = sizeCtl;
                        final int x4 = (resizeStamp << ConcurrentHashMap.RESIZE_STAMP_SHIFT) + 2;
                        BytecodeManager.incBytecodes(10);
                        final boolean compareAndSwapInt2 = u4.compareAndSwapInt(this, sizectl2, expected2, x4);
                        BytecodeManager.incBytecodes(1);
                        if (compareAndSwapInt2) {
                            final Node<K, V>[] array7 = table;
                            final Node<K, V>[] array8 = null;
                            BytecodeManager.incBytecodes(4);
                            this.transfer(array7, array8);
                        }
                    }
                    BytecodeManager.incBytecodes(2);
                    x = this.sumCount();
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
    
    final Node<K, V>[] helpTransfer(final Node<K, V>[] array, final Node<K, V> node) {
        try {
            BytecodeManager.incBytecodes(2);
            if (array != null) {
                final boolean b = node instanceof ForwardingNode;
                BytecodeManager.incBytecodes(3);
                if (b) {
                    final Node<K, V>[] nextTable;
                    final Node<K, V>[] array2 = nextTable = ((ForwardingNode)node).nextTable;
                    BytecodeManager.incBytecodes(6);
                    if (array2 != null) {
                        final int length = array.length;
                        BytecodeManager.incBytecodes(3);
                        final int resizeStamp = resizeStamp(length);
                        BytecodeManager.incBytecodes(1);
                        while (true) {
                            boolean compareAndSwapInt;
                            do {
                                final Node<K, V>[] array3 = nextTable;
                                final Node<K, V>[] nextTable2 = this.nextTable;
                                BytecodeManager.incBytecodes(4);
                                if (array3 == nextTable2) {
                                    final Node<K, V>[] table = this.table;
                                    BytecodeManager.incBytecodes(4);
                                    if (table == array) {
                                        final int sizeCtl;
                                        final int n = sizeCtl = this.sizeCtl;
                                        BytecodeManager.incBytecodes(5);
                                        if (n < 0) {
                                            final int n2 = sizeCtl >>> ConcurrentHashMap.RESIZE_STAMP_SHIFT;
                                            final int n3 = resizeStamp;
                                            BytecodeManager.incBytecodes(5);
                                            if (n2 == n3) {
                                                final int n4 = sizeCtl;
                                                final int n5 = resizeStamp + 1;
                                                BytecodeManager.incBytecodes(5);
                                                if (n4 != n5) {
                                                    final int n6 = sizeCtl;
                                                    final int n7 = resizeStamp + ConcurrentHashMap.MAX_RESIZERS;
                                                    BytecodeManager.incBytecodes(5);
                                                    if (n6 != n7) {
                                                        final int transferIndex = this.transferIndex;
                                                        BytecodeManager.incBytecodes(3);
                                                        if (transferIndex > 0) {
                                                            final Unsafe u = ConcurrentHashMap.U;
                                                            final long sizectl = ConcurrentHashMap.SIZECTL;
                                                            final int expected = sizeCtl;
                                                            final int x = sizeCtl + 1;
                                                            BytecodeManager.incBytecodes(8);
                                                            compareAndSwapInt = u.compareAndSwapInt(this, sizectl, expected, x);
                                                            BytecodeManager.incBytecodes(1);
                                                            continue;
                                                        }
                                                        BytecodeManager.incBytecodes(1);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                final Map.Entry<K, V>[] array4 = (Map.Entry<K, V>[])nextTable;
                                BytecodeManager.incBytecodes(2);
                                return (Node<K, V>[])array4;
                            } while (!compareAndSwapInt);
                            final Map.Entry<K, V>[] array5 = (Map.Entry<K, V>[])nextTable;
                            BytecodeManager.incBytecodes(4);
                            this.transfer(array, (Node<K, V>[])array5);
                            BytecodeManager.incBytecodes(1);
                            continue;
                        }
                    }
                }
            }
            final Node<K, V>[] table2 = this.table;
            BytecodeManager.incBytecodes(3);
            return table2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private final void tryPresize(final int p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc_w           536870912
        //     4: ldc_w           3
        //     7: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    10: if_icmplt       24
        //    13: ldc             1073741824
        //    15: ldc_w           2
        //    18: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    21: goto            46
        //    24: iload_1        
        //    25: iload_1        
        //    26: iconst_1       
        //    27: iushr          
        //    28: iadd           
        //    29: iconst_1       
        //    30: iadd           
        //    31: ldc_w           7
        //    34: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    37: ldc_w           1
        //    40: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    43: invokestatic    instrumented/java/util/concurrent/ConcurrentHashMap.tableSizeFor:(I)I
        //    46: istore_2       
        //    47: ldc_w           1
        //    50: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    53: aload_0        
        //    54: getfield        instrumented/java/util/concurrent/ConcurrentHashMap.sizeCtl:I
        //    57: dup            
        //    58: istore_3       
        //    59: ldc_w           5
        //    62: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    65: iflt            539
        //    68: aload_0        
        //    69: getfield        instrumented/java/util/concurrent/ConcurrentHashMap.table:[Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //    72: astore          4
        //    74: ldc_w           3
        //    77: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    80: aload           4
        //    82: ldc_w           2
        //    85: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    88: ifnull          106
        //    91: aload           4
        //    93: arraylength    
        //    94: dup            
        //    95: istore          5
        //    97: ldc_w           5
        //   100: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   103: ifne            274
        //   106: iload_3        
        //   107: iload_2        
        //   108: ldc_w           3
        //   111: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   114: if_icmple       127
        //   117: iload_3        
        //   118: ldc_w           2
        //   121: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   124: goto            134
        //   127: iload_2        
        //   128: ldc_w           1
        //   131: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   134: istore          5
        //   136: ldc_w           1
        //   139: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   142: getstatic       instrumented/java/util/concurrent/ConcurrentHashMap.U:Lsun/misc/Unsafe;
        //   145: aload_0        
        //   146: getstatic       instrumented/java/util/concurrent/ConcurrentHashMap.SIZECTL:J
        //   149: iload_3        
        //   150: iconst_m1      
        //   151: ldc             6
        //   153: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   156: invokevirtual   sun/misc/Unsafe.compareAndSwapInt:(Ljava/lang/Object;JII)Z
        //   159: ldc_w           1
        //   162: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   165: ifeq            530
        //   168: aload_0        
        //   169: getfield        instrumented/java/util/concurrent/ConcurrentHashMap.table:[Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //   172: aload           4
        //   174: ldc             4
        //   176: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   179: if_acmpne       223
        //   182: iload           5
        //   184: anewarray       Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //   187: checkcast       [Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //   190: astore          6
        //   192: ldc_w           3
        //   195: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   198: aload_0        
        //   199: aload           6
        //   201: putfield        instrumented/java/util/concurrent/ConcurrentHashMap.table:[Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //   204: ldc_w           3
        //   207: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   210: iload           5
        //   212: iload           5
        //   214: iconst_2       
        //   215: iushr          
        //   216: isub           
        //   217: istore_3       
        //   218: ldc             6
        //   220: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   223: aload_0        
        //   224: iload_3        
        //   225: putfield        instrumented/java/util/concurrent/ConcurrentHashMap.sizeCtl:I
        //   228: ldc_w           3
        //   231: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   234: ldc_w           1
        //   237: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   240: goto            265
        //   243: astore          7
        //   245: ldc_w           501
        //   248: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   251: aload_0        
        //   252: iload_3        
        //   253: putfield        instrumented/java/util/concurrent/ConcurrentHashMap.sizeCtl:I
        //   256: aload           7
        //   258: ldc_w           5
        //   261: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   264: athrow         
        //   265: ldc_w           1
        //   268: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   271: goto            530
        //   274: iload_2        
        //   275: iload_3        
        //   276: ldc_w           3
        //   279: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   282: if_icmple       539
        //   285: iload           5
        //   287: ldc             1073741824
        //   289: ldc_w           3
        //   292: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   295: if_icmplt       307
        //   298: ldc_w           1
        //   301: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   304: goto            539
        //   307: aload           4
        //   309: aload_0        
        //   310: getfield        instrumented/java/util/concurrent/ConcurrentHashMap.table:[Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //   313: ldc             4
        //   315: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   318: if_acmpne       530
        //   321: iload           5
        //   323: ldc_w           2
        //   326: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   329: invokestatic    instrumented/java/util/concurrent/ConcurrentHashMap.resizeStamp:(I)I
        //   332: istore          6
        //   334: ldc_w           1
        //   337: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   340: iload_3        
        //   341: ldc_w           2
        //   344: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   347: ifge            484
        //   350: iload_3        
        //   351: getstatic       instrumented/java/util/concurrent/ConcurrentHashMap.RESIZE_STAMP_SHIFT:I
        //   354: iushr          
        //   355: iload           6
        //   357: ldc_w           5
        //   360: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   363: if_icmpne       539
        //   366: iload_3        
        //   367: iload           6
        //   369: iconst_1       
        //   370: iadd           
        //   371: ldc_w           5
        //   374: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   377: if_icmpeq       539
        //   380: iload_3        
        //   381: iload           6
        //   383: getstatic       instrumented/java/util/concurrent/ConcurrentHashMap.MAX_RESIZERS:I
        //   386: iadd           
        //   387: ldc_w           5
        //   390: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   393: if_icmpeq       539
        //   396: aload_0        
        //   397: getfield        instrumented/java/util/concurrent/ConcurrentHashMap.nextTable:[Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //   400: dup            
        //   401: astore          7
        //   403: ldc_w           5
        //   406: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   409: ifnull          539
        //   412: aload_0        
        //   413: getfield        instrumented/java/util/concurrent/ConcurrentHashMap.transferIndex:I
        //   416: ldc_w           3
        //   419: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   422: ifgt            434
        //   425: ldc_w           1
        //   428: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   431: goto            539
        //   434: getstatic       instrumented/java/util/concurrent/ConcurrentHashMap.U:Lsun/misc/Unsafe;
        //   437: aload_0        
        //   438: getstatic       instrumented/java/util/concurrent/ConcurrentHashMap.SIZECTL:J
        //   441: iload_3        
        //   442: iload_3        
        //   443: iconst_1       
        //   444: iadd           
        //   445: ldc             8
        //   447: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   450: invokevirtual   sun/misc/Unsafe.compareAndSwapInt:(Ljava/lang/Object;JII)Z
        //   453: ldc_w           1
        //   456: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   459: ifeq            475
        //   462: aload_0        
        //   463: aload           4
        //   465: aload           7
        //   467: ldc             4
        //   469: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   472: invokespecial   instrumented/java/util/concurrent/ConcurrentHashMap.transfer:([Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;[Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;)V
        //   475: ldc_w           1
        //   478: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   481: goto            530
        //   484: getstatic       instrumented/java/util/concurrent/ConcurrentHashMap.U:Lsun/misc/Unsafe;
        //   487: aload_0        
        //   488: getstatic       instrumented/java/util/concurrent/ConcurrentHashMap.SIZECTL:J
        //   491: iload_3        
        //   492: iload           6
        //   494: getstatic       instrumented/java/util/concurrent/ConcurrentHashMap.RESIZE_STAMP_SHIFT:I
        //   497: ishl           
        //   498: iconst_2       
        //   499: iadd           
        //   500: ldc_w           10
        //   503: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   506: invokevirtual   sun/misc/Unsafe.compareAndSwapInt:(Ljava/lang/Object;JII)Z
        //   509: ldc_w           1
        //   512: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   515: ifeq            530
        //   518: aload_0        
        //   519: aload           4
        //   521: aconst_null    
        //   522: ldc             4
        //   524: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   527: invokespecial   instrumented/java/util/concurrent/ConcurrentHashMap.transfer:([Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;[Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;)V
        //   530: ldc_w           1
        //   533: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   536: goto            53
        //   539: ldc_w           1
        //   542: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   545: return         
        //   546: athrow         
        //   547: athrow         
        //    StackMapTable: 00 12 18 55 01 FC 00 06 01 FD 00 34 01 07 01 7D 14 46 01 FC 00 58 01 53 07 00 FD 15 08 20 FD 00 7E 01 07 01 7D FA 00 28 08 F8 00 2D 08 FF 00 06 00 00 00 01 07 00 FD FF 00 00 00 00 00 01 07 01 9E
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  168    547    547    548    Ljava/lang/VirtualMachineError;
        //  168    223    243    265    Any
        //  243    251    243    265    Any
        //  0      546    546    547    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0223:
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
    
    private final void transfer(final Node<K, V>[] p0, final Node<K, V>[] p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: arraylength    
        //     2: istore_3       
        //     3: ldc_w           3
        //     6: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     9: getstatic       instrumented/java/util/concurrent/ConcurrentHashMap.NCPU:I
        //    12: iconst_1       
        //    13: ldc_w           3
        //    16: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    19: if_icmple       37
        //    22: iload_3        
        //    23: iconst_3       
        //    24: iushr          
        //    25: getstatic       instrumented/java/util/concurrent/ConcurrentHashMap.NCPU:I
        //    28: idiv           
        //    29: ldc             6
        //    31: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    34: goto            44
        //    37: iload_3        
        //    38: ldc_w           1
        //    41: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    44: dup            
        //    45: istore          4
        //    47: bipush          16
        //    49: ldc             4
        //    51: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    54: if_icmpge       67
        //    57: bipush          16
        //    59: istore          4
        //    61: ldc_w           2
        //    64: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    67: aload_2        
        //    68: ldc_w           2
        //    71: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    74: ifnonnull       161
        //    77: iload_3        
        //    78: iconst_1       
        //    79: ishl           
        //    80: anewarray       Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //    83: checkcast       [Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //    86: astore          5
        //    88: ldc_w           5
        //    91: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    94: aload           5
        //    96: astore_2       
        //    97: ldc_w           2
        //   100: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   103: ldc_w           1
        //   106: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   109: goto            139
        //   112: astore          5
        //   114: ldc_w           501
        //   117: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   120: aload_0        
        //   121: ldc             2147483647
        //   123: putfield        instrumented/java/util/concurrent/ConcurrentHashMap.sizeCtl:I
        //   126: ldc_w           3
        //   129: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   132: ldc_w           1
        //   135: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   138: return         
        //   139: aload_0        
        //   140: aload_2        
        //   141: putfield        instrumented/java/util/concurrent/ConcurrentHashMap.nextTable:[Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //   144: ldc_w           3
        //   147: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   150: aload_0        
        //   151: iload_3        
        //   152: putfield        instrumented/java/util/concurrent/ConcurrentHashMap.transferIndex:I
        //   155: ldc_w           3
        //   158: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   161: aload_2        
        //   162: arraylength    
        //   163: istore          5
        //   165: ldc_w           3
        //   168: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   171: new             Linstrumented/java/util/concurrent/ConcurrentHashMap$ForwardingNode;
        //   174: dup            
        //   175: aload_2        
        //   176: ldc             4
        //   178: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   181: invokespecial   instrumented/java/util/concurrent/ConcurrentHashMap$ForwardingNode.<init>:([Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;)V
        //   184: astore          6
        //   186: ldc_w           1
        //   189: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   192: iconst_1       
        //   193: istore          7
        //   195: ldc_w           2
        //   198: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   201: iconst_0       
        //   202: istore          8
        //   204: ldc_w           2
        //   207: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   210: iconst_0       
        //   211: istore          9
        //   213: iconst_0       
        //   214: istore          10
        //   216: ldc             4
        //   218: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   221: iload           7
        //   223: ldc_w           2
        //   226: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   229: ifeq            415
        //   232: iinc            9, -1
        //   235: iload           9
        //   237: iload           10
        //   239: ldc             4
        //   241: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   244: if_icmpge       258
        //   247: iload           8
        //   249: ldc_w           2
        //   252: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   255: ifeq            270
        //   258: iconst_0       
        //   259: istore          7
        //   261: ldc_w           3
        //   264: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   267: goto            406
        //   270: aload_0        
        //   271: getfield        instrumented/java/util/concurrent/ConcurrentHashMap.transferIndex:I
        //   274: dup            
        //   275: istore          13
        //   277: ldc_w           5
        //   280: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   283: ifgt            307
        //   286: iconst_m1      
        //   287: istore          9
        //   289: ldc_w           2
        //   292: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   295: iconst_0       
        //   296: istore          7
        //   298: ldc_w           3
        //   301: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   304: goto            406
        //   307: getstatic       instrumented/java/util/concurrent/ConcurrentHashMap.U:Lsun/misc/Unsafe;
        //   310: aload_0        
        //   311: getstatic       instrumented/java/util/concurrent/ConcurrentHashMap.TRANSFERINDEX:J
        //   314: iload           13
        //   316: iload           13
        //   318: iload           4
        //   320: ldc_w           7
        //   323: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   326: if_icmple       342
        //   329: iload           13
        //   331: iload           4
        //   333: isub           
        //   334: ldc             4
        //   336: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   339: goto            349
        //   342: iconst_0       
        //   343: ldc_w           1
        //   346: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   349: dup            
        //   350: istore          14
        //   352: ldc_w           2
        //   355: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   358: ldc_w           1
        //   361: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   364: invokevirtual   sun/misc/Unsafe.compareAndSwapInt:(Ljava/lang/Object;JII)Z
        //   367: ldc_w           1
        //   370: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   373: ifeq            406
        //   376: iload           14
        //   378: istore          10
        //   380: ldc_w           2
        //   383: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   386: iload           13
        //   388: iconst_1       
        //   389: isub           
        //   390: istore          9
        //   392: ldc             4
        //   394: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   397: iconst_0       
        //   398: istore          7
        //   400: ldc_w           2
        //   403: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   406: ldc_w           1
        //   409: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   412: goto            221
        //   415: iload           9
        //   417: ldc_w           2
        //   420: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   423: iflt            453
        //   426: iload           9
        //   428: iload_3        
        //   429: ldc_w           3
        //   432: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   435: if_icmpge       453
        //   438: iload           9
        //   440: iload_3        
        //   441: iadd           
        //   442: iload           5
        //   444: ldc_w           5
        //   447: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   450: if_icmplt       609
        //   453: iload           8
        //   455: ldc_w           2
        //   458: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   461: ifeq            510
        //   464: aload_0        
        //   465: aconst_null    
        //   466: putfield        instrumented/java/util/concurrent/ConcurrentHashMap.nextTable:[Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //   469: ldc_w           3
        //   472: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   475: aload_0        
        //   476: aload_2        
        //   477: putfield        instrumented/java/util/concurrent/ConcurrentHashMap.table:[Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //   480: ldc_w           3
        //   483: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   486: aload_0        
        //   487: iload_3        
        //   488: iconst_1       
        //   489: ishl           
        //   490: iload_3        
        //   491: iconst_1       
        //   492: iushr          
        //   493: isub           
        //   494: putfield        instrumented/java/util/concurrent/ConcurrentHashMap.sizeCtl:I
        //   497: ldc_w           9
        //   500: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   503: ldc_w           1
        //   506: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   509: return         
        //   510: getstatic       instrumented/java/util/concurrent/ConcurrentHashMap.U:Lsun/misc/Unsafe;
        //   513: aload_0        
        //   514: getstatic       instrumented/java/util/concurrent/ConcurrentHashMap.SIZECTL:J
        //   517: aload_0        
        //   518: getfield        instrumented/java/util/concurrent/ConcurrentHashMap.sizeCtl:I
        //   521: dup            
        //   522: istore          13
        //   524: iload           13
        //   526: iconst_1       
        //   527: isub           
        //   528: ldc_w           11
        //   531: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   534: invokevirtual   sun/misc/Unsafe.compareAndSwapInt:(Ljava/lang/Object;JII)Z
        //   537: ldc_w           1
        //   540: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   543: ifeq            600
        //   546: iload           13
        //   548: iconst_2       
        //   549: isub           
        //   550: iload_3        
        //   551: ldc_w           5
        //   554: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   557: invokestatic    instrumented/java/util/concurrent/ConcurrentHashMap.resizeStamp:(I)I
        //   560: getstatic       instrumented/java/util/concurrent/ConcurrentHashMap.RESIZE_STAMP_SHIFT:I
        //   563: ishl           
        //   564: ldc_w           3
        //   567: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   570: if_icmpeq       580
        //   573: ldc_w           1
        //   576: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   579: return         
        //   580: iconst_1       
        //   581: dup            
        //   582: istore          7
        //   584: istore          8
        //   586: ldc             4
        //   588: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   591: iload_3        
        //   592: istore          9
        //   594: ldc_w           2
        //   597: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   600: ldc_w           1
        //   603: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   606: goto            1630
        //   609: aload_1        
        //   610: iload           9
        //   612: ldc_w           3
        //   615: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   618: invokestatic    instrumented/java/util/concurrent/ConcurrentHashMap.tabAt:([Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;I)Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //   621: dup            
        //   622: astore          11
        //   624: ldc_w           3
        //   627: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   630: ifnonnull       659
        //   633: aload_1        
        //   634: iload           9
        //   636: aconst_null    
        //   637: aload           6
        //   639: ldc_w           5
        //   642: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   645: invokestatic    instrumented/java/util/concurrent/ConcurrentHashMap.casTabAt:([Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;ILinstrumented/java/util/concurrent/ConcurrentHashMap$Node;Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;)Z
        //   648: istore          7
        //   650: ldc_w           2
        //   653: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   656: goto            1630
        //   659: aload           11
        //   661: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$Node.hash:I
        //   664: dup            
        //   665: istore          12
        //   667: iconst_m1      
        //   668: ldc             6
        //   670: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   673: if_icmpne       688
        //   676: iconst_1       
        //   677: istore          7
        //   679: ldc_w           3
        //   682: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   685: goto            1630
        //   688: aload           11
        //   690: dup            
        //   691: astore          13
        //   693: pop            
        //   694: ldc             4
        //   696: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   699: aload_1        
        //   700: iload           9
        //   702: ldc_w           3
        //   705: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   708: invokestatic    instrumented/java/util/concurrent/ConcurrentHashMap.tabAt:([Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;I)Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //   711: aload           11
        //   713: ldc_w           2
        //   716: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   719: if_acmpne       1592
        //   722: iload           12
        //   724: ldc_w           2
        //   727: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   730: iflt            1090
        //   733: iload           12
        //   735: iload_3        
        //   736: iand           
        //   737: istore          16
        //   739: ldc             4
        //   741: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   744: aload           11
        //   746: astore          17
        //   748: ldc_w           2
        //   751: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   754: aload           11
        //   756: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$Node.next:Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //   759: astore          18
        //   761: ldc_w           3
        //   764: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   767: aload           18
        //   769: ldc_w           2
        //   772: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   775: ifnull          841
        //   778: aload           18
        //   780: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$Node.hash:I
        //   783: iload_3        
        //   784: iand           
        //   785: istore          19
        //   787: ldc_w           5
        //   790: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   793: iload           19
        //   795: iload           16
        //   797: ldc_w           3
        //   800: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   803: if_icmpeq       826
        //   806: iload           19
        //   808: istore          16
        //   810: ldc_w           2
        //   813: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   816: aload           18
        //   818: astore          17
        //   820: ldc_w           2
        //   823: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   826: aload           18
        //   828: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$Node.next:Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //   831: astore          18
        //   833: ldc             4
        //   835: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   838: goto            767
        //   841: iload           16
        //   843: ldc_w           2
        //   846: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   849: ifne            874
        //   852: aload           17
        //   854: astore          14
        //   856: ldc_w           2
        //   859: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   862: aconst_null    
        //   863: astore          15
        //   865: ldc_w           3
        //   868: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   871: goto            893
        //   874: aload           17
        //   876: astore          15
        //   878: ldc_w           2
        //   881: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   884: aconst_null    
        //   885: astore          14
        //   887: ldc_w           2
        //   890: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   893: aload           11
        //   895: astore          18
        //   897: ldc_w           2
        //   900: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   903: aload           18
        //   905: aload           17
        //   907: ldc_w           3
        //   910: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   913: if_acmpeq       1031
        //   916: aload           18
        //   918: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$Node.hash:I
        //   921: istore          19
        //   923: aload           18
        //   925: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$Node.key:Ljava/lang/Object;
        //   928: astore          20
        //   930: aload           18
        //   932: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$Node.val:Ljava/lang/Object;
        //   935: astore          21
        //   937: ldc_w           9
        //   940: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   943: iload           19
        //   945: iload_3        
        //   946: iand           
        //   947: ldc             4
        //   949: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   952: ifne            987
        //   955: new             Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //   958: dup            
        //   959: iload           19
        //   961: aload           20
        //   963: aload           21
        //   965: aload           14
        //   967: ldc_w           7
        //   970: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   973: invokespecial   instrumented/java/util/concurrent/ConcurrentHashMap$Node.<init>:(ILjava/lang/Object;Ljava/lang/Object;Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;)V
        //   976: astore          14
        //   978: ldc_w           2
        //   981: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   984: goto            1016
        //   987: new             Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //   990: dup            
        //   991: iload           19
        //   993: aload           20
        //   995: aload           21
        //   997: aload           15
        //   999: ldc_w           7
        //  1002: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1005: invokespecial   instrumented/java/util/concurrent/ConcurrentHashMap$Node.<init>:(ILjava/lang/Object;Ljava/lang/Object;Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;)V
        //  1008: astore          15
        //  1010: ldc_w           1
        //  1013: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1016: aload           18
        //  1018: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$Node.next:Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //  1021: astore          18
        //  1023: ldc             4
        //  1025: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1028: goto            903
        //  1031: aload_2        
        //  1032: iload           9
        //  1034: aload           14
        //  1036: ldc             4
        //  1038: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1041: invokestatic    instrumented/java/util/concurrent/ConcurrentHashMap.setTabAt:([Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;ILinstrumented/java/util/concurrent/ConcurrentHashMap$Node;)V
        //  1044: aload_2        
        //  1045: iload           9
        //  1047: iload_3        
        //  1048: iadd           
        //  1049: aload           15
        //  1051: ldc             6
        //  1053: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1056: invokestatic    instrumented/java/util/concurrent/ConcurrentHashMap.setTabAt:([Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;ILinstrumented/java/util/concurrent/ConcurrentHashMap$Node;)V
        //  1059: aload_1        
        //  1060: iload           9
        //  1062: aload           6
        //  1064: ldc             4
        //  1066: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1069: invokestatic    instrumented/java/util/concurrent/ConcurrentHashMap.setTabAt:([Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;ILinstrumented/java/util/concurrent/ConcurrentHashMap$Node;)V
        //  1072: iconst_1       
        //  1073: istore          7
        //  1075: ldc_w           2
        //  1078: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1081: ldc_w           1
        //  1084: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1087: goto            1592
        //  1090: aload           11
        //  1092: instanceof      Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeBin;
        //  1095: ldc_w           3
        //  1098: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1101: ifeq            1592
        //  1104: aload           11
        //  1106: checkcast       Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeBin;
        //  1109: astore          16
        //  1111: ldc_w           3
        //  1114: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1117: aconst_null    
        //  1118: astore          17
        //  1120: aconst_null    
        //  1121: astore          18
        //  1123: ldc             4
        //  1125: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1128: aconst_null    
        //  1129: astore          19
        //  1131: aconst_null    
        //  1132: astore          20
        //  1134: ldc             4
        //  1136: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1139: iconst_0       
        //  1140: istore          21
        //  1142: iconst_0       
        //  1143: istore          22
        //  1145: ldc             4
        //  1147: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1150: aload           16
        //  1152: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeBin.first:Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
        //  1155: astore          23
        //  1157: ldc_w           3
        //  1160: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1163: aload           23
        //  1165: ldc_w           2
        //  1168: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1171: ifnull          1376
        //  1174: aload           23
        //  1176: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$Node.hash:I
        //  1179: istore          24
        //  1181: ldc_w           3
        //  1184: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1187: new             Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
        //  1190: dup            
        //  1191: iload           24
        //  1193: aload           23
        //  1195: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$Node.key:Ljava/lang/Object;
        //  1198: aload           23
        //  1200: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$Node.val:Ljava/lang/Object;
        //  1203: aconst_null    
        //  1204: aconst_null    
        //  1205: ldc_w           10
        //  1208: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1211: invokespecial   instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.<init>:(ILjava/lang/Object;Ljava/lang/Object;Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;)V
        //  1214: astore          25
        //  1216: ldc_w           1
        //  1219: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1222: iload           24
        //  1224: iload_3        
        //  1225: iand           
        //  1226: ldc             4
        //  1228: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1231: ifne            1299
        //  1234: aload           25
        //  1236: aload           18
        //  1238: dup_x1         
        //  1239: putfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.prev:Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
        //  1242: ldc_w           5
        //  1245: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1248: ifnonnull       1264
        //  1251: aload           25
        //  1253: astore          17
        //  1255: ldc_w           3
        //  1258: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1261: goto            1277
        //  1264: aload           18
        //  1266: aload           25
        //  1268: putfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.next:Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //  1271: ldc_w           3
        //  1274: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1277: aload           25
        //  1279: astore          18
        //  1281: ldc_w           2
        //  1284: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1287: iinc            21, 1
        //  1290: ldc_w           2
        //  1293: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1296: goto            1361
        //  1299: aload           25
        //  1301: aload           20
        //  1303: dup_x1         
        //  1304: putfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.prev:Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
        //  1307: ldc_w           5
        //  1310: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1313: ifnonnull       1329
        //  1316: aload           25
        //  1318: astore          19
        //  1320: ldc_w           3
        //  1323: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1326: goto            1342
        //  1329: aload           20
        //  1331: aload           25
        //  1333: putfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.next:Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //  1336: ldc_w           3
        //  1339: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1342: aload           25
        //  1344: astore          20
        //  1346: ldc_w           2
        //  1349: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1352: iinc            22, 1
        //  1355: ldc_w           1
        //  1358: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1361: aload           23
        //  1363: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$Node.next:Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //  1366: astore          23
        //  1368: ldc             4
        //  1370: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1373: goto            1163
        //  1376: iload           21
        //  1378: bipush          6
        //  1380: ldc_w           3
        //  1383: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1386: if_icmpgt       1409
        //  1389: aload           17
        //  1391: ldc_w           2
        //  1394: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1397: invokestatic    instrumented/java/util/concurrent/ConcurrentHashMap.untreeify:(Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;)Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //  1400: ldc_w           1
        //  1403: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1406: goto            1451
        //  1409: iload           22
        //  1411: ldc_w           2
        //  1414: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1417: ifeq            1443
        //  1420: new             Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeBin;
        //  1423: dup            
        //  1424: aload           17
        //  1426: ldc             4
        //  1428: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1431: invokespecial   instrumented/java/util/concurrent/ConcurrentHashMap$TreeBin.<init>:(Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;)V
        //  1434: ldc_w           1
        //  1437: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1440: goto            1451
        //  1443: aload           16
        //  1445: ldc_w           1
        //  1448: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1451: astore          14
        //  1453: ldc_w           1
        //  1456: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1459: iload           22
        //  1461: bipush          6
        //  1463: ldc_w           3
        //  1466: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1469: if_icmpgt       1492
        //  1472: aload           19
        //  1474: ldc_w           2
        //  1477: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1480: invokestatic    instrumented/java/util/concurrent/ConcurrentHashMap.untreeify:(Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;)Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //  1483: ldc_w           1
        //  1486: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1489: goto            1534
        //  1492: iload           21
        //  1494: ldc_w           2
        //  1497: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1500: ifeq            1526
        //  1503: new             Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeBin;
        //  1506: dup            
        //  1507: aload           19
        //  1509: ldc             4
        //  1511: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1514: invokespecial   instrumented/java/util/concurrent/ConcurrentHashMap$TreeBin.<init>:(Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;)V
        //  1517: ldc_w           1
        //  1520: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1523: goto            1534
        //  1526: aload           16
        //  1528: ldc_w           1
        //  1531: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1534: astore          15
        //  1536: ldc_w           1
        //  1539: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1542: aload_2        
        //  1543: iload           9
        //  1545: aload           14
        //  1547: ldc             4
        //  1549: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1552: invokestatic    instrumented/java/util/concurrent/ConcurrentHashMap.setTabAt:([Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;ILinstrumented/java/util/concurrent/ConcurrentHashMap$Node;)V
        //  1555: aload_2        
        //  1556: iload           9
        //  1558: iload_3        
        //  1559: iadd           
        //  1560: aload           15
        //  1562: ldc             6
        //  1564: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1567: invokestatic    instrumented/java/util/concurrent/ConcurrentHashMap.setTabAt:([Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;ILinstrumented/java/util/concurrent/ConcurrentHashMap$Node;)V
        //  1570: aload_1        
        //  1571: iload           9
        //  1573: aload           6
        //  1575: ldc             4
        //  1577: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1580: invokestatic    instrumented/java/util/concurrent/ConcurrentHashMap.setTabAt:([Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;ILinstrumented/java/util/concurrent/ConcurrentHashMap$Node;)V
        //  1583: iconst_1       
        //  1584: istore          7
        //  1586: ldc_w           2
        //  1589: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1592: aload           13
        //  1594: pop            
        //  1595: ldc_w           2
        //  1598: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1601: ldc_w           1
        //  1604: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1607: goto            1630
        //  1610: astore          26
        //  1612: aload           13
        //  1614: pop            
        //  1615: ldc_w           503
        //  1618: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1621: aload           26
        //  1623: ldc_w           2
        //  1626: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1629: athrow         
        //  1630: ldc_w           1
        //  1633: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //  1636: goto            221
        //  1639: athrow         
        //  1640: athrow         
        //    Signature:
        //  ([Linstrumented/java/util/concurrent/ConcurrentHashMap$Node<TK;TV;>;[Linstrumented/java/util/concurrent/ConcurrentHashMap$Node<TK;TV;>;)V
        //    StackMapTable: 00 32 FC 00 25 01 46 01 FC 00 16 01 6C 07 00 FD 1A 15 FF 00 3B 00 0B 07 00 02 07 01 7D 07 01 7D 01 01 01 07 00 43 01 01 01 01 00 00 24 0B FE 00 24 00 00 01 FF 00 22 00 0E 07 00 02 07 01 7D 07 01 7D 01 01 01 07 00 43 01 01 01 01 00 00 01 00 04 07 01 34 07 00 02 04 01 FF 00 06 00 0E 07 00 02 07 01 7D 07 01 7D 01 01 01 07 00 43 01 01 01 01 00 00 01 00 05 07 01 34 07 00 02 04 01 01 F8 00 38 08 25 38 FE 00 45 00 00 01 F8 00 13 08 FC 00 31 07 00 82 FC 00 1C 01 FF 00 4E 00 13 07 00 02 07 01 7D 07 01 7D 01 01 01 07 00 43 01 01 01 01 07 00 82 01 07 01 08 00 00 01 07 00 82 07 00 82 00 00 3A FA 00 0E 20 FF 00 12 00 12 07 00 02 07 01 7D 07 01 7D 01 01 01 07 00 43 01 01 01 01 07 00 82 01 07 01 08 07 00 82 07 00 82 01 07 00 82 00 00 FC 00 09 07 00 82 FE 00 53 01 07 01 08 07 01 08 F8 00 1C FA 00 0E FF 00 3A 00 0E 07 00 02 07 01 7D 07 01 7D 01 01 01 07 00 43 01 01 01 01 07 00 82 01 07 01 08 00 00 FF 00 48 00 18 07 00 02 07 01 7D 07 01 7D 01 01 01 07 00 43 01 01 01 01 07 00 82 01 07 01 08 00 00 07 00 A6 07 00 A9 07 00 A9 07 00 A9 07 00 A9 01 01 07 00 82 00 00 FD 00 64 01 07 00 A9 0C 15 1D 0C F9 00 12 FA 00 0E 20 21 47 07 00 82 FF 00 28 00 17 07 00 02 07 01 7D 07 01 7D 01 01 01 07 00 43 01 01 01 01 07 00 82 01 07 01 08 07 00 82 00 07 00 A6 07 00 A9 07 00 A9 07 00 A9 07 00 A9 01 01 00 00 21 47 07 00 82 FF 00 39 00 0E 07 00 02 07 01 7D 07 01 7D 01 01 01 07 00 43 01 01 01 01 07 00 82 01 07 01 08 00 00 51 07 00 FD F8 00 13 FF 00 08 00 00 00 01 07 00 FD FF 00 00 00 00 00 01 07 01 9E
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  77     1640   1640   1641   Ljava/lang/VirtualMachineError;
        //  77     103    112    139    Ljava/lang/Throwable;
        //  699    1601   1610   1630   Any
        //  1610   1621   1610   1630   Any
        //  0      1639   1639   1640   Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0139:
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
    
    final long sumCount() {
        try {
            final CounterCell[] counterCells = this.counterCells;
            BytecodeManager.incBytecodes(3);
            long baseCount = this.baseCount;
            BytecodeManager.incBytecodes(3);
            final CounterCell[] array = counterCells;
            BytecodeManager.incBytecodes(2);
            if (array != null) {
                int n = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n2 = n;
                    final int length = counterCells.length;
                    BytecodeManager.incBytecodes(4);
                    if (n2 >= length) {
                        break;
                    }
                    final CounterCell counterCell = counterCells[n];
                    BytecodeManager.incBytecodes(6);
                    if (counterCell != null) {
                        baseCount += counterCell.value;
                        BytecodeManager.incBytecodes(5);
                    }
                    ++n;
                    BytecodeManager.incBytecodes(2);
                }
            }
            final long n3 = baseCount;
            BytecodeManager.incBytecodes(2);
            return n3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private final void fullAddCount(final long p0, final boolean p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     6: invokestatic    instrumented/java/util/concurrent/ThreadLocalRandom.getProbe:()I
        //     9: dup            
        //    10: istore          4
        //    12: ldc_w           3
        //    15: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    18: ifne            55
        //    21: ldc_w           1
        //    24: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    27: invokestatic    instrumented/java/util/concurrent/ThreadLocalRandom.localInit:()V
        //    30: ldc_w           1
        //    33: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    36: invokestatic    instrumented/java/util/concurrent/ThreadLocalRandom.getProbe:()I
        //    39: istore          4
        //    41: ldc_w           1
        //    44: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    47: iconst_1       
        //    48: istore_3       
        //    49: ldc_w           2
        //    52: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    55: iconst_0       
        //    56: istore          5
        //    58: ldc_w           2
        //    61: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    64: aload_0        
        //    65: getfield        instrumented/java/util/concurrent/ConcurrentHashMap.counterCells:[Linstrumented/java/util/concurrent/ConcurrentHashMap$CounterCell;
        //    68: dup            
        //    69: astore          6
        //    71: ldc_w           5
        //    74: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    77: ifnull          702
        //    80: aload           6
        //    82: arraylength    
        //    83: dup            
        //    84: istore          8
        //    86: ldc_w           5
        //    89: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    92: ifle            702
        //    95: aload           6
        //    97: iload           8
        //    99: iconst_1       
        //   100: isub           
        //   101: iload           4
        //   103: iand           
        //   104: aaload         
        //   105: dup            
        //   106: astore          7
        //   108: ldc_w           10
        //   111: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   114: ifnonnull       354
        //   117: aload_0        
        //   118: getfield        instrumented/java/util/concurrent/ConcurrentHashMap.cellsBusy:I
        //   121: ldc_w           3
        //   124: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   127: ifne            342
        //   130: new             Linstrumented/java/util/concurrent/ConcurrentHashMap$CounterCell;
        //   133: dup            
        //   134: lload_1        
        //   135: ldc             4
        //   137: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   140: invokespecial   instrumented/java/util/concurrent/ConcurrentHashMap$CounterCell.<init>:(J)V
        //   143: astore          11
        //   145: ldc_w           1
        //   148: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   151: aload_0        
        //   152: getfield        instrumented/java/util/concurrent/ConcurrentHashMap.cellsBusy:I
        //   155: ldc_w           3
        //   158: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   161: ifne            342
        //   164: getstatic       instrumented/java/util/concurrent/ConcurrentHashMap.U:Lsun/misc/Unsafe;
        //   167: aload_0        
        //   168: getstatic       instrumented/java/util/concurrent/ConcurrentHashMap.CELLSBUSY:J
        //   171: iconst_0       
        //   172: iconst_1       
        //   173: ldc_w           5
        //   176: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   179: ldc_w           1
        //   182: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   185: invokevirtual   sun/misc/Unsafe.compareAndSwapInt:(Ljava/lang/Object;JII)Z
        //   188: ldc_w           1
        //   191: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   194: ifeq            342
        //   197: iconst_0       
        //   198: istore          12
        //   200: ldc_w           2
        //   203: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   206: aload_0        
        //   207: getfield        instrumented/java/util/concurrent/ConcurrentHashMap.counterCells:[Linstrumented/java/util/concurrent/ConcurrentHashMap$CounterCell;
        //   210: dup            
        //   211: astore          13
        //   213: ldc_w           5
        //   216: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   219: ifnull          280
        //   222: aload           13
        //   224: arraylength    
        //   225: dup            
        //   226: istore          14
        //   228: ldc_w           5
        //   231: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   234: ifle            280
        //   237: aload           13
        //   239: iload           14
        //   241: iconst_1       
        //   242: isub           
        //   243: iload           4
        //   245: iand           
        //   246: dup            
        //   247: istore          15
        //   249: aaload         
        //   250: ldc_w           10
        //   253: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   256: ifnonnull       280
        //   259: aload           13
        //   261: iload           15
        //   263: aload           11
        //   265: aastore        
        //   266: ldc             4
        //   268: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   271: iconst_1       
        //   272: istore          12
        //   274: ldc_w           2
        //   277: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   280: aload_0        
        //   281: iconst_0       
        //   282: putfield        instrumented/java/util/concurrent/ConcurrentHashMap.cellsBusy:I
        //   285: ldc_w           3
        //   288: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   291: ldc_w           1
        //   294: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   297: goto            322
        //   300: astore          16
        //   302: ldc_w           501
        //   305: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   308: aload_0        
        //   309: iconst_0       
        //   310: putfield        instrumented/java/util/concurrent/ConcurrentHashMap.cellsBusy:I
        //   313: aload           16
        //   315: ldc_w           5
        //   318: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   321: athrow         
        //   322: iload           12
        //   324: ldc_w           2
        //   327: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   330: ifeq            64
        //   333: ldc_w           1
        //   336: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   339: goto            969
        //   342: iconst_0       
        //   343: istore          5
        //   345: ldc_w           3
        //   348: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   351: goto            680
        //   354: iload_3        
        //   355: ldc_w           2
        //   358: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   361: ifne            375
        //   364: iconst_1       
        //   365: istore_3       
        //   366: ldc_w           3
        //   369: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   372: goto            680
        //   375: getstatic       instrumented/java/util/concurrent/ConcurrentHashMap.U:Lsun/misc/Unsafe;
        //   378: aload           7
        //   380: getstatic       instrumented/java/util/concurrent/ConcurrentHashMap.CELLVALUE:J
        //   383: aload           7
        //   385: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$CounterCell.value:J
        //   388: dup2           
        //   389: lstore          9
        //   391: lload           9
        //   393: lload_1        
        //   394: ladd           
        //   395: ldc_w           11
        //   398: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   401: invokevirtual   sun/misc/Unsafe.compareAndSwapLong:(Ljava/lang/Object;JJJ)Z
        //   404: ldc_w           1
        //   407: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   410: ifeq            422
        //   413: ldc_w           1
        //   416: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   419: goto            969
        //   422: aload_0        
        //   423: getfield        instrumented/java/util/concurrent/ConcurrentHashMap.counterCells:[Linstrumented/java/util/concurrent/ConcurrentHashMap$CounterCell;
        //   426: aload           6
        //   428: ldc             4
        //   430: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   433: if_acmpne       450
        //   436: iload           8
        //   438: getstatic       instrumented/java/util/concurrent/ConcurrentHashMap.NCPU:I
        //   441: ldc_w           3
        //   444: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   447: if_icmplt       462
        //   450: iconst_0       
        //   451: istore          5
        //   453: ldc_w           3
        //   456: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   459: goto            680
        //   462: iload           5
        //   464: ldc_w           2
        //   467: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   470: ifne            485
        //   473: iconst_1       
        //   474: istore          5
        //   476: ldc_w           3
        //   479: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   482: goto            680
        //   485: aload_0        
        //   486: getfield        instrumented/java/util/concurrent/ConcurrentHashMap.cellsBusy:I
        //   489: ldc_w           3
        //   492: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   495: ifne            680
        //   498: getstatic       instrumented/java/util/concurrent/ConcurrentHashMap.U:Lsun/misc/Unsafe;
        //   501: aload_0        
        //   502: getstatic       instrumented/java/util/concurrent/ConcurrentHashMap.CELLSBUSY:J
        //   505: iconst_0       
        //   506: iconst_1       
        //   507: ldc_w           5
        //   510: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   513: ldc_w           1
        //   516: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   519: invokevirtual   sun/misc/Unsafe.compareAndSwapInt:(Ljava/lang/Object;JII)Z
        //   522: ldc_w           1
        //   525: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   528: ifeq            680
        //   531: aload_0        
        //   532: getfield        instrumented/java/util/concurrent/ConcurrentHashMap.counterCells:[Linstrumented/java/util/concurrent/ConcurrentHashMap$CounterCell;
        //   535: aload           6
        //   537: ldc             4
        //   539: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   542: if_acmpne       620
        //   545: iload           8
        //   547: iconst_1       
        //   548: ishl           
        //   549: anewarray       Linstrumented/java/util/concurrent/ConcurrentHashMap$CounterCell;
        //   552: astore          11
        //   554: ldc             4
        //   556: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   559: iconst_0       
        //   560: istore          12
        //   562: ldc_w           2
        //   565: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   568: iload           12
        //   570: iload           8
        //   572: ldc_w           3
        //   575: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   578: if_icmpge       608
        //   581: aload           11
        //   583: iload           12
        //   585: aload           6
        //   587: iload           12
        //   589: aaload         
        //   590: aastore        
        //   591: ldc             6
        //   593: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   596: iinc            12, 1
        //   599: ldc_w           2
        //   602: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   605: goto            568
        //   608: aload_0        
        //   609: aload           11
        //   611: putfield        instrumented/java/util/concurrent/ConcurrentHashMap.counterCells:[Linstrumented/java/util/concurrent/ConcurrentHashMap$CounterCell;
        //   614: ldc_w           3
        //   617: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   620: aload_0        
        //   621: iconst_0       
        //   622: putfield        instrumented/java/util/concurrent/ConcurrentHashMap.cellsBusy:I
        //   625: ldc_w           3
        //   628: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   631: ldc_w           1
        //   634: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   637: goto            662
        //   640: astore          17
        //   642: ldc_w           501
        //   645: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   648: aload_0        
        //   649: iconst_0       
        //   650: putfield        instrumented/java/util/concurrent/ConcurrentHashMap.cellsBusy:I
        //   653: aload           17
        //   655: ldc_w           5
        //   658: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   661: athrow         
        //   662: iconst_0       
        //   663: istore          5
        //   665: ldc_w           2
        //   668: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   671: ldc_w           1
        //   674: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   677: goto            64
        //   680: iload           4
        //   682: ldc_w           2
        //   685: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   688: invokestatic    instrumented/java/util/concurrent/ThreadLocalRandom.advanceProbe:(I)I
        //   691: istore          4
        //   693: ldc_w           2
        //   696: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   699: goto            960
        //   702: aload_0        
        //   703: getfield        instrumented/java/util/concurrent/ConcurrentHashMap.cellsBusy:I
        //   706: ldc_w           3
        //   709: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   712: ifne            915
        //   715: aload_0        
        //   716: getfield        instrumented/java/util/concurrent/ConcurrentHashMap.counterCells:[Linstrumented/java/util/concurrent/ConcurrentHashMap$CounterCell;
        //   719: aload           6
        //   721: ldc             4
        //   723: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   726: if_acmpne       915
        //   729: getstatic       instrumented/java/util/concurrent/ConcurrentHashMap.U:Lsun/misc/Unsafe;
        //   732: aload_0        
        //   733: getstatic       instrumented/java/util/concurrent/ConcurrentHashMap.CELLSBUSY:J
        //   736: iconst_0       
        //   737: iconst_1       
        //   738: ldc_w           5
        //   741: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   744: ldc_w           1
        //   747: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   750: invokevirtual   sun/misc/Unsafe.compareAndSwapInt:(Ljava/lang/Object;JII)Z
        //   753: ldc_w           1
        //   756: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   759: ifeq            915
        //   762: iconst_0       
        //   763: istore          11
        //   765: ldc_w           2
        //   768: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   771: aload_0        
        //   772: getfield        instrumented/java/util/concurrent/ConcurrentHashMap.counterCells:[Linstrumented/java/util/concurrent/ConcurrentHashMap$CounterCell;
        //   775: aload           6
        //   777: ldc             4
        //   779: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   782: if_acmpne       844
        //   785: iconst_2       
        //   786: anewarray       Linstrumented/java/util/concurrent/ConcurrentHashMap$CounterCell;
        //   789: astore          12
        //   791: ldc_w           2
        //   794: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   797: aload           12
        //   799: iload           4
        //   801: iconst_1       
        //   802: iand           
        //   803: new             Linstrumented/java/util/concurrent/ConcurrentHashMap$CounterCell;
        //   806: dup            
        //   807: lload_1        
        //   808: ldc             8
        //   810: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   813: invokespecial   instrumented/java/util/concurrent/ConcurrentHashMap$CounterCell.<init>:(J)V
        //   816: aastore        
        //   817: ldc_w           1
        //   820: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   823: aload_0        
        //   824: aload           12
        //   826: putfield        instrumented/java/util/concurrent/ConcurrentHashMap.counterCells:[Linstrumented/java/util/concurrent/ConcurrentHashMap$CounterCell;
        //   829: ldc_w           3
        //   832: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   835: iconst_1       
        //   836: istore          11
        //   838: ldc_w           2
        //   841: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   844: aload_0        
        //   845: iconst_0       
        //   846: putfield        instrumented/java/util/concurrent/ConcurrentHashMap.cellsBusy:I
        //   849: ldc_w           3
        //   852: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   855: ldc_w           1
        //   858: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   861: goto            886
        //   864: astore          18
        //   866: ldc_w           501
        //   869: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   872: aload_0        
        //   873: iconst_0       
        //   874: putfield        instrumented/java/util/concurrent/ConcurrentHashMap.cellsBusy:I
        //   877: aload           18
        //   879: ldc_w           5
        //   882: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   885: athrow         
        //   886: iload           11
        //   888: ldc_w           2
        //   891: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   894: ifeq            906
        //   897: ldc_w           1
        //   900: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   903: goto            969
        //   906: ldc_w           1
        //   909: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   912: goto            960
        //   915: getstatic       instrumented/java/util/concurrent/ConcurrentHashMap.U:Lsun/misc/Unsafe;
        //   918: aload_0        
        //   919: getstatic       instrumented/java/util/concurrent/ConcurrentHashMap.BASECOUNT:J
        //   922: aload_0        
        //   923: getfield        instrumented/java/util/concurrent/ConcurrentHashMap.baseCount:J
        //   926: dup2           
        //   927: lstore          9
        //   929: lload           9
        //   931: lload_1        
        //   932: ladd           
        //   933: ldc_w           11
        //   936: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   939: invokevirtual   sun/misc/Unsafe.compareAndSwapLong:(Ljava/lang/Object;JJJ)Z
        //   942: ldc_w           1
        //   945: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   948: ifeq            960
        //   951: ldc_w           1
        //   954: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   957: goto            969
        //   960: ldc_w           1
        //   963: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   966: goto            64
        //   969: ldc_w           1
        //   972: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   975: return         
        //   976: athrow         
        //   977: athrow         
        //    StackMapTable: 00 1C FC 00 37 01 FC 00 08 01 FF 00 D7 00 0C 07 00 02 04 01 01 01 07 02 A1 07 00 1F 01 00 00 07 00 1F 01 00 00 53 07 00 FD 15 FF 00 13 00 08 07 00 02 04 01 01 01 07 02 A1 07 00 1F 01 00 00 0B 14 FC 00 2E 04 1B 0B 16 FD 00 52 07 02 A1 01 FA 00 27 FA 00 0B 53 07 00 FD 15 FA 00 11 F9 00 15 FF 00 8D 00 0B 07 00 02 04 01 01 01 07 02 A1 00 00 00 00 01 00 00 53 07 00 FD 15 FF 00 13 00 06 07 00 02 04 01 01 01 07 02 A1 00 00 08 FA 00 2C 08 FF 00 06 00 00 00 01 07 00 FD FF 00 00 00 00 00 01 07 01 9E
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  206    977    977    978    Ljava/lang/VirtualMachineError;
        //  206    280    300    322    Any
        //  300    308    300    322    Any
        //  531    620    640    662    Any
        //  640    648    640    662    Any
        //  771    844    864    886    Any
        //  864    872    864    886    Any
        //  0      976    976    977    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0280:
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
    
    private final void treeifyBin(final Node<K, V>[] p0, final int p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc_w           2
        //     4: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     7: ifnull          314
        //    10: aload_1        
        //    11: arraylength    
        //    12: dup            
        //    13: istore          4
        //    15: bipush          64
        //    17: ldc             6
        //    19: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    22: if_icmpge       48
        //    25: aload_0        
        //    26: iload           4
        //    28: iconst_1       
        //    29: ishl           
        //    30: ldc_w           5
        //    33: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    36: invokespecial   instrumented/java/util/concurrent/ConcurrentHashMap.tryPresize:(I)V
        //    39: ldc_w           1
        //    42: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    45: goto            314
        //    48: aload_1        
        //    49: iload_2        
        //    50: ldc_w           3
        //    53: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    56: invokestatic    instrumented/java/util/concurrent/ConcurrentHashMap.tabAt:([Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;I)Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //    59: dup            
        //    60: astore_3       
        //    61: ldc_w           3
        //    64: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    67: ifnull          314
        //    70: aload_3        
        //    71: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$Node.hash:I
        //    74: ldc_w           3
        //    77: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    80: iflt            314
        //    83: aload_3        
        //    84: dup            
        //    85: astore          6
        //    87: pop            
        //    88: ldc             4
        //    90: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    93: aload_1        
        //    94: iload_2        
        //    95: ldc_w           3
        //    98: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   101: invokestatic    instrumented/java/util/concurrent/ConcurrentHashMap.tabAt:([Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;I)Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //   104: aload_3        
        //   105: ldc_w           2
        //   108: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   111: if_acmpne       276
        //   114: aconst_null    
        //   115: astore          7
        //   117: aconst_null    
        //   118: astore          8
        //   120: ldc             4
        //   122: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   125: aload_3        
        //   126: astore          9
        //   128: ldc_w           2
        //   131: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   134: aload           9
        //   136: ldc_w           2
        //   139: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   142: ifnull          251
        //   145: new             Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
        //   148: dup            
        //   149: aload           9
        //   151: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$Node.hash:I
        //   154: aload           9
        //   156: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$Node.key:Ljava/lang/Object;
        //   159: aload           9
        //   161: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$Node.val:Ljava/lang/Object;
        //   164: aconst_null    
        //   165: aconst_null    
        //   166: ldc_w           11
        //   169: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   172: invokespecial   instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.<init>:(ILjava/lang/Object;Ljava/lang/Object;Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;)V
        //   175: astore          10
        //   177: ldc_w           1
        //   180: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   183: aload           10
        //   185: aload           8
        //   187: dup_x1         
        //   188: putfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.prev:Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
        //   191: ldc_w           5
        //   194: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   197: ifnonnull       213
        //   200: aload           10
        //   202: astore          7
        //   204: ldc_w           3
        //   207: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   210: goto            226
        //   213: aload           8
        //   215: aload           10
        //   217: putfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.next:Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //   220: ldc_w           3
        //   223: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   226: aload           10
        //   228: astore          8
        //   230: ldc_w           2
        //   233: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   236: aload           9
        //   238: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$Node.next:Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
        //   241: astore          9
        //   243: ldc             4
        //   245: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   248: goto            134
        //   251: aload_1        
        //   252: iload_2        
        //   253: new             Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeBin;
        //   256: dup            
        //   257: aload           7
        //   259: ldc             6
        //   261: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   264: invokespecial   instrumented/java/util/concurrent/ConcurrentHashMap$TreeBin.<init>:(Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;)V
        //   267: ldc_w           1
        //   270: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   273: invokestatic    instrumented/java/util/concurrent/ConcurrentHashMap.setTabAt:([Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;ILinstrumented/java/util/concurrent/ConcurrentHashMap$Node;)V
        //   276: aload           6
        //   278: pop            
        //   279: ldc_w           2
        //   282: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   285: ldc_w           1
        //   288: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   291: goto            314
        //   294: astore          11
        //   296: aload           6
        //   298: pop            
        //   299: ldc_w           503
        //   302: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   305: aload           11
        //   307: ldc_w           2
        //   310: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   313: athrow         
        //   314: ldc_w           1
        //   317: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   320: return         
        //   321: athrow         
        //   322: athrow         
        //    Signature:
        //  ([Linstrumented/java/util/concurrent/ConcurrentHashMap$Node<TK;TV;>;I)V
        //    StackMapTable: 00 0A FD 00 30 00 01 FF 00 55 00 0A 07 00 02 07 01 7D 01 07 00 82 01 00 07 01 08 07 00 A9 07 00 A9 07 00 82 00 00 FC 00 4E 07 00 A9 0C F9 00 18 F9 00 18 51 07 00 FD FF 00 13 00 03 07 00 02 07 01 7D 01 00 00 FF 00 06 00 00 00 01 07 00 FD FF 00 00 00 00 00 01 07 01 9E
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  93     322    322    323    Ljava/lang/VirtualMachineError;
        //  93     285    294    314    Any
        //  294    305    294    314    Any
        //  0      321    321    322    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0134:
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
    
    static <K, V> Node<K, V> untreeify(final Node<K, V> node) {
        try {
            Node<K, V> node2 = null;
            Node<K, V> node3 = null;
            BytecodeManager.incBytecodes(4);
            Node<K, V> next = node;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final Node<K, V> node4 = next;
                BytecodeManager.incBytecodes(2);
                if (node4 == null) {
                    break;
                }
                final int hash = next.hash;
                final K key = next.key;
                final V val = next.val;
                final Node<K, V> node5 = null;
                BytecodeManager.incBytecodes(10);
                final Node next2 = new Node<K, V>(hash, key, val, (Node<Object, Object>)node5);
                BytecodeManager.incBytecodes(1);
                final Node<K, V> node6 = node3;
                BytecodeManager.incBytecodes(2);
                if (node6 == null) {
                    node2 = (Node<K, V>)next2;
                    BytecodeManager.incBytecodes(3);
                }
                else {
                    node3.next = (Node<K, V>)next2;
                    BytecodeManager.incBytecodes(3);
                }
                node3 = (Node<K, V>)next2;
                BytecodeManager.incBytecodes(2);
                next = next.next;
                BytecodeManager.incBytecodes(4);
            }
            final Node<K, V> node7 = node2;
            BytecodeManager.incBytecodes(2);
            return node7;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final int batchFor(final long n) {
        try {
            final long n2 = lcmp(n, Long.MAX_VALUE);
            BytecodeManager.incBytecodes(4);
            if (n2 != 0) {
                BytecodeManager.incBytecodes(2);
                final long sumCount;
                final long n3 = lcmp(sumCount = this.sumCount(), 1L);
                BytecodeManager.incBytecodes(5);
                if (n3 > 0) {
                    final long n4 = lcmp(sumCount, n);
                    BytecodeManager.incBytecodes(4);
                    if (n4 >= 0) {
                        BytecodeManager.incBytecodes(1);
                        final int n5 = ForkJoinPool.getCommonPoolParallelism() << 2;
                        BytecodeManager.incBytecodes(3);
                        final long n6 = lcmp(n, 0L);
                        BytecodeManager.incBytecodes(4);
                        int n9 = 0;
                        Label_0122: {
                            if (n6 > 0) {
                                final long n8;
                                final long n7 = lcmp(n8 = sumCount / n, (long)n5);
                                BytecodeManager.incBytecodes(9);
                                if (n7 < 0) {
                                    n9 = (int)n8;
                                    BytecodeManager.incBytecodes(2);
                                    break Label_0122;
                                }
                            }
                            n9 = n5;
                            BytecodeManager.incBytecodes(2);
                        }
                        BytecodeManager.incBytecodes(1);
                        return n9;
                    }
                }
            }
            final int n10 = 0;
            BytecodeManager.incBytecodes(2);
            return n10;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void forEach(final long n, final BiConsumer<? super K, ? super V> biConsumer) {
        try {
            BytecodeManager.incBytecodes(2);
            if (biConsumer == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final BulkTask<Object, Object, ?> bulkTask = null;
            BytecodeManager.incBytecodes(5);
            BytecodeManager.incBytecodes(1);
            final int batch = this.batchFor(n);
            final int n2 = 0;
            final int n3 = 0;
            final Node<K, V>[] table = this.table;
            BytecodeManager.incBytecodes(6);
            final ForEachMappingTask forEachMappingTask = new ForEachMappingTask(bulkTask, batch, n2, n3, (Node<Object, Object>[])table, (BiConsumer<? super Object, ? super Object>)biConsumer);
            BytecodeManager.incBytecodes(1);
            forEachMappingTask.invoke();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public <U> void forEach(final long n, final BiFunction<? super K, ? super V, ? extends U> biFunction, final Consumer<? super U> consumer) {
        try {
            BytecodeManager.incBytecodes(2);
            if (biFunction != null) {
                BytecodeManager.incBytecodes(2);
                if (consumer != null) {
                    final BulkTask<Object, Object, ?> bulkTask = null;
                    BytecodeManager.incBytecodes(5);
                    BytecodeManager.incBytecodes(1);
                    final int batch = this.batchFor(n);
                    final int n2 = 0;
                    final int n3 = 0;
                    final Node<K, V>[] table = this.table;
                    BytecodeManager.incBytecodes(7);
                    final ForEachTransformedMappingTask forEachTransformedMappingTask = new ForEachTransformedMappingTask(bulkTask, batch, n2, n3, (Node<Object, Object>[])table, (BiFunction<? super Object, ? super Object, ?>)biFunction, (Consumer<? super Object>)consumer);
                    BytecodeManager.incBytecodes(1);
                    forEachTransformedMappingTask.invoke();
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    return;
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
    
    public <U> U search(final long n, final BiFunction<? super K, ? super V, ? extends U> biFunction) {
        try {
            BytecodeManager.incBytecodes(2);
            if (biFunction == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final BulkTask<Object, Object, ?> bulkTask = null;
            BytecodeManager.incBytecodes(5);
            BytecodeManager.incBytecodes(1);
            final int batch = this.batchFor(n);
            final int n2 = 0;
            final int n3 = 0;
            final Node<K, V>[] table = this.table;
            BytecodeManager.incBytecodes(8);
            final AtomicReference<Object> atomicReference = new AtomicReference<Object>();
            BytecodeManager.incBytecodes(1);
            final SearchMappingsTask searchMappingsTask = new SearchMappingsTask(bulkTask, batch, n2, n3, (Node<Object, Object>[])table, (BiFunction<? super Object, ? super Object, ?>)biFunction, atomicReference);
            BytecodeManager.incBytecodes(1);
            final U invoke = searchMappingsTask.invoke();
            BytecodeManager.incBytecodes(1);
            return invoke;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public <U> U reduce(final long n, final BiFunction<? super K, ? super V, ? extends U> biFunction, final BiFunction<? super U, ? super U, ? extends U> biFunction2) {
        try {
            BytecodeManager.incBytecodes(2);
            if (biFunction != null) {
                BytecodeManager.incBytecodes(2);
                if (biFunction2 != null) {
                    final BulkTask<Object, Object, ?> bulkTask = null;
                    BytecodeManager.incBytecodes(5);
                    BytecodeManager.incBytecodes(1);
                    final int batch = this.batchFor(n);
                    final int n2 = 0;
                    final int n3 = 0;
                    final Node<K, V>[] table = this.table;
                    final MapReduceMappingsTask<Object, Object, Object> mapReduceMappingsTask = null;
                    BytecodeManager.incBytecodes(8);
                    final MapReduceMappingsTask mapReduceMappingsTask2 = new MapReduceMappingsTask(bulkTask, batch, n2, n3, (Node<Object, Object>[])table, mapReduceMappingsTask, (BiFunction<? super Object, ? super Object, ?>)biFunction, (BiFunction<? super Object, ? super Object, ?>)biFunction2);
                    BytecodeManager.incBytecodes(1);
                    final U invoke = mapReduceMappingsTask2.invoke();
                    BytecodeManager.incBytecodes(1);
                    return invoke;
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
    
    public double reduceToDouble(final long n, final ToDoubleBiFunction<? super K, ? super V> toDoubleBiFunction, final double n2, final DoubleBinaryOperator doubleBinaryOperator) {
        try {
            BytecodeManager.incBytecodes(2);
            if (toDoubleBiFunction != null) {
                BytecodeManager.incBytecodes(2);
                if (doubleBinaryOperator != null) {
                    final BulkTask<Object, Object, ?> bulkTask = null;
                    BytecodeManager.incBytecodes(5);
                    BytecodeManager.incBytecodes(1);
                    final int batch = this.batchFor(n);
                    final int n3 = 0;
                    final int n4 = 0;
                    final Node<K, V>[] table = this.table;
                    final MapReduceMappingsToDoubleTask<Object, Object> mapReduceMappingsToDoubleTask = null;
                    BytecodeManager.incBytecodes(9);
                    final MapReduceMappingsToDoubleTask mapReduceMappingsToDoubleTask2 = new MapReduceMappingsToDoubleTask(bulkTask, batch, n3, n4, (Node<Object, Object>[])table, mapReduceMappingsToDoubleTask, (ToDoubleBiFunction<? super Object, ? super Object>)toDoubleBiFunction, n2, doubleBinaryOperator);
                    BytecodeManager.incBytecodes(1);
                    final Double n5 = mapReduceMappingsToDoubleTask2.invoke();
                    BytecodeManager.incBytecodes(2);
                    final double doubleValue = n5;
                    BytecodeManager.incBytecodes(1);
                    return doubleValue;
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
    
    public long reduceToLong(final long n, final ToLongBiFunction<? super K, ? super V> toLongBiFunction, final long n2, final LongBinaryOperator longBinaryOperator) {
        try {
            BytecodeManager.incBytecodes(2);
            if (toLongBiFunction != null) {
                BytecodeManager.incBytecodes(2);
                if (longBinaryOperator != null) {
                    final BulkTask<Object, Object, ?> bulkTask = null;
                    BytecodeManager.incBytecodes(5);
                    BytecodeManager.incBytecodes(1);
                    final int batch = this.batchFor(n);
                    final int n3 = 0;
                    final int n4 = 0;
                    final Node<K, V>[] table = this.table;
                    final MapReduceMappingsToLongTask<Object, Object> mapReduceMappingsToLongTask = null;
                    BytecodeManager.incBytecodes(9);
                    final MapReduceMappingsToLongTask mapReduceMappingsToLongTask2 = new MapReduceMappingsToLongTask(bulkTask, batch, n3, n4, (Node<Object, Object>[])table, mapReduceMappingsToLongTask, (ToLongBiFunction<? super Object, ? super Object>)toLongBiFunction, n2, longBinaryOperator);
                    BytecodeManager.incBytecodes(1);
                    final Long n5 = mapReduceMappingsToLongTask2.invoke();
                    BytecodeManager.incBytecodes(2);
                    final long longValue = n5;
                    BytecodeManager.incBytecodes(1);
                    return longValue;
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
    
    public int reduceToInt(final long n, final ToIntBiFunction<? super K, ? super V> toIntBiFunction, final int n2, final IntBinaryOperator intBinaryOperator) {
        try {
            BytecodeManager.incBytecodes(2);
            if (toIntBiFunction != null) {
                BytecodeManager.incBytecodes(2);
                if (intBinaryOperator != null) {
                    final BulkTask<Object, Object, ?> bulkTask = null;
                    BytecodeManager.incBytecodes(5);
                    BytecodeManager.incBytecodes(1);
                    final int batch = this.batchFor(n);
                    final int n3 = 0;
                    final int n4 = 0;
                    final Node<K, V>[] table = this.table;
                    final MapReduceMappingsToIntTask<Object, Object> mapReduceMappingsToIntTask = null;
                    BytecodeManager.incBytecodes(9);
                    final MapReduceMappingsToIntTask mapReduceMappingsToIntTask2 = new MapReduceMappingsToIntTask(bulkTask, batch, n3, n4, (Node<Object, Object>[])table, mapReduceMappingsToIntTask, (ToIntBiFunction<? super Object, ? super Object>)toIntBiFunction, n2, intBinaryOperator);
                    BytecodeManager.incBytecodes(1);
                    final Integer n5 = mapReduceMappingsToIntTask2.invoke();
                    BytecodeManager.incBytecodes(2);
                    final int intValue = n5;
                    BytecodeManager.incBytecodes(1);
                    return intValue;
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
    
    public void forEachKey(final long n, final Consumer<? super K> consumer) {
        try {
            BytecodeManager.incBytecodes(2);
            if (consumer == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final BulkTask<Object, Object, ?> bulkTask = null;
            BytecodeManager.incBytecodes(5);
            BytecodeManager.incBytecodes(1);
            final int batch = this.batchFor(n);
            final int n2 = 0;
            final int n3 = 0;
            final Node<K, V>[] table = this.table;
            BytecodeManager.incBytecodes(6);
            final ForEachKeyTask forEachKeyTask = new ForEachKeyTask(bulkTask, batch, n2, n3, (Node<Object, Object>[])table, (Consumer<? super Object>)consumer);
            BytecodeManager.incBytecodes(1);
            forEachKeyTask.invoke();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public <U> void forEachKey(final long n, final Function<? super K, ? extends U> function, final Consumer<? super U> consumer) {
        try {
            BytecodeManager.incBytecodes(2);
            if (function != null) {
                BytecodeManager.incBytecodes(2);
                if (consumer != null) {
                    final BulkTask<Object, Object, ?> bulkTask = null;
                    BytecodeManager.incBytecodes(5);
                    BytecodeManager.incBytecodes(1);
                    final int batch = this.batchFor(n);
                    final int n2 = 0;
                    final int n3 = 0;
                    final Node<K, V>[] table = this.table;
                    BytecodeManager.incBytecodes(7);
                    final ForEachTransformedKeyTask forEachTransformedKeyTask = new ForEachTransformedKeyTask(bulkTask, batch, n2, n3, (Node<Object, Object>[])table, (Function<? super Object, ?>)function, (Consumer<? super Object>)consumer);
                    BytecodeManager.incBytecodes(1);
                    forEachTransformedKeyTask.invoke();
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    return;
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
    
    public <U> U searchKeys(final long n, final Function<? super K, ? extends U> function) {
        try {
            BytecodeManager.incBytecodes(2);
            if (function == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final BulkTask<Object, Object, ?> bulkTask = null;
            BytecodeManager.incBytecodes(5);
            BytecodeManager.incBytecodes(1);
            final int batch = this.batchFor(n);
            final int n2 = 0;
            final int n3 = 0;
            final Node<K, V>[] table = this.table;
            BytecodeManager.incBytecodes(8);
            final AtomicReference<Object> atomicReference = new AtomicReference<Object>();
            BytecodeManager.incBytecodes(1);
            final SearchKeysTask searchKeysTask = new SearchKeysTask(bulkTask, batch, n2, n3, (Node<Object, Object>[])table, (Function<? super Object, ?>)function, atomicReference);
            BytecodeManager.incBytecodes(1);
            final U invoke = searchKeysTask.invoke();
            BytecodeManager.incBytecodes(1);
            return invoke;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public K reduceKeys(final long n, final BiFunction<? super K, ? super K, ? extends K> biFunction) {
        try {
            BytecodeManager.incBytecodes(2);
            if (biFunction == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final BulkTask<Object, Object, ?> bulkTask = null;
            BytecodeManager.incBytecodes(5);
            BytecodeManager.incBytecodes(1);
            final int batch = this.batchFor(n);
            final int n2 = 0;
            final int n3 = 0;
            final Node<K, V>[] table = this.table;
            final ReduceKeysTask<Object, Object> reduceKeysTask = null;
            BytecodeManager.incBytecodes(7);
            final ReduceKeysTask reduceKeysTask2 = new ReduceKeysTask(bulkTask, batch, n2, n3, (Node<Object, Object>[])table, reduceKeysTask, (BiFunction<? super Object, ? super Object, ?>)biFunction);
            BytecodeManager.incBytecodes(1);
            final K invoke = reduceKeysTask2.invoke();
            BytecodeManager.incBytecodes(1);
            return invoke;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public <U> U reduceKeys(final long n, final Function<? super K, ? extends U> function, final BiFunction<? super U, ? super U, ? extends U> biFunction) {
        try {
            BytecodeManager.incBytecodes(2);
            if (function != null) {
                BytecodeManager.incBytecodes(2);
                if (biFunction != null) {
                    final BulkTask<Object, Object, ?> bulkTask = null;
                    BytecodeManager.incBytecodes(5);
                    BytecodeManager.incBytecodes(1);
                    final int batch = this.batchFor(n);
                    final int n2 = 0;
                    final int n3 = 0;
                    final Node<K, V>[] table = this.table;
                    final MapReduceKeysTask<Object, Object, Object> mapReduceKeysTask = null;
                    BytecodeManager.incBytecodes(8);
                    final MapReduceKeysTask mapReduceKeysTask2 = new MapReduceKeysTask(bulkTask, batch, n2, n3, (Node<Object, Object>[])table, mapReduceKeysTask, (Function<? super Object, ?>)function, (BiFunction<? super Object, ? super Object, ?>)biFunction);
                    BytecodeManager.incBytecodes(1);
                    final U invoke = mapReduceKeysTask2.invoke();
                    BytecodeManager.incBytecodes(1);
                    return invoke;
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
    
    public double reduceKeysToDouble(final long n, final ToDoubleFunction<? super K> toDoubleFunction, final double n2, final DoubleBinaryOperator doubleBinaryOperator) {
        try {
            BytecodeManager.incBytecodes(2);
            if (toDoubleFunction != null) {
                BytecodeManager.incBytecodes(2);
                if (doubleBinaryOperator != null) {
                    final BulkTask<Object, Object, ?> bulkTask = null;
                    BytecodeManager.incBytecodes(5);
                    BytecodeManager.incBytecodes(1);
                    final int batch = this.batchFor(n);
                    final int n3 = 0;
                    final int n4 = 0;
                    final Node<K, V>[] table = this.table;
                    final MapReduceKeysToDoubleTask<Object, Object> mapReduceKeysToDoubleTask = null;
                    BytecodeManager.incBytecodes(9);
                    final MapReduceKeysToDoubleTask mapReduceKeysToDoubleTask2 = new MapReduceKeysToDoubleTask(bulkTask, batch, n3, n4, (Node<Object, Object>[])table, mapReduceKeysToDoubleTask, (ToDoubleFunction<? super Object>)toDoubleFunction, n2, doubleBinaryOperator);
                    BytecodeManager.incBytecodes(1);
                    final Double n5 = mapReduceKeysToDoubleTask2.invoke();
                    BytecodeManager.incBytecodes(2);
                    final double doubleValue = n5;
                    BytecodeManager.incBytecodes(1);
                    return doubleValue;
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
    
    public long reduceKeysToLong(final long n, final ToLongFunction<? super K> toLongFunction, final long n2, final LongBinaryOperator longBinaryOperator) {
        try {
            BytecodeManager.incBytecodes(2);
            if (toLongFunction != null) {
                BytecodeManager.incBytecodes(2);
                if (longBinaryOperator != null) {
                    final BulkTask<Object, Object, ?> bulkTask = null;
                    BytecodeManager.incBytecodes(5);
                    BytecodeManager.incBytecodes(1);
                    final int batch = this.batchFor(n);
                    final int n3 = 0;
                    final int n4 = 0;
                    final Node<K, V>[] table = this.table;
                    final MapReduceKeysToLongTask<Object, Object> mapReduceKeysToLongTask = null;
                    BytecodeManager.incBytecodes(9);
                    final MapReduceKeysToLongTask mapReduceKeysToLongTask2 = new MapReduceKeysToLongTask(bulkTask, batch, n3, n4, (Node<Object, Object>[])table, mapReduceKeysToLongTask, (ToLongFunction<? super Object>)toLongFunction, n2, longBinaryOperator);
                    BytecodeManager.incBytecodes(1);
                    final Long n5 = mapReduceKeysToLongTask2.invoke();
                    BytecodeManager.incBytecodes(2);
                    final long longValue = n5;
                    BytecodeManager.incBytecodes(1);
                    return longValue;
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
    
    public int reduceKeysToInt(final long n, final ToIntFunction<? super K> toIntFunction, final int n2, final IntBinaryOperator intBinaryOperator) {
        try {
            BytecodeManager.incBytecodes(2);
            if (toIntFunction != null) {
                BytecodeManager.incBytecodes(2);
                if (intBinaryOperator != null) {
                    final BulkTask<Object, Object, ?> bulkTask = null;
                    BytecodeManager.incBytecodes(5);
                    BytecodeManager.incBytecodes(1);
                    final int batch = this.batchFor(n);
                    final int n3 = 0;
                    final int n4 = 0;
                    final Node<K, V>[] table = this.table;
                    final MapReduceKeysToIntTask<Object, Object> mapReduceKeysToIntTask = null;
                    BytecodeManager.incBytecodes(9);
                    final MapReduceKeysToIntTask mapReduceKeysToIntTask2 = new MapReduceKeysToIntTask(bulkTask, batch, n3, n4, (Node<Object, Object>[])table, mapReduceKeysToIntTask, (ToIntFunction<? super Object>)toIntFunction, n2, intBinaryOperator);
                    BytecodeManager.incBytecodes(1);
                    final Integer n5 = mapReduceKeysToIntTask2.invoke();
                    BytecodeManager.incBytecodes(2);
                    final int intValue = n5;
                    BytecodeManager.incBytecodes(1);
                    return intValue;
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
    
    public void forEachValue(final long n, final Consumer<? super V> consumer) {
        try {
            BytecodeManager.incBytecodes(2);
            if (consumer == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final BulkTask<Object, Object, ?> bulkTask = null;
            BytecodeManager.incBytecodes(5);
            BytecodeManager.incBytecodes(1);
            final int batch = this.batchFor(n);
            final int n2 = 0;
            final int n3 = 0;
            final Node<K, V>[] table = this.table;
            BytecodeManager.incBytecodes(6);
            final ForEachValueTask forEachValueTask = new ForEachValueTask(bulkTask, batch, n2, n3, (Node<Object, Object>[])table, (Consumer<? super Object>)consumer);
            BytecodeManager.incBytecodes(1);
            forEachValueTask.invoke();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public <U> void forEachValue(final long n, final Function<? super V, ? extends U> function, final Consumer<? super U> consumer) {
        try {
            BytecodeManager.incBytecodes(2);
            if (function != null) {
                BytecodeManager.incBytecodes(2);
                if (consumer != null) {
                    final BulkTask<Object, Object, ?> bulkTask = null;
                    BytecodeManager.incBytecodes(5);
                    BytecodeManager.incBytecodes(1);
                    final int batch = this.batchFor(n);
                    final int n2 = 0;
                    final int n3 = 0;
                    final Node<K, V>[] table = this.table;
                    BytecodeManager.incBytecodes(7);
                    final ForEachTransformedValueTask forEachTransformedValueTask = new ForEachTransformedValueTask(bulkTask, batch, n2, n3, (Node<Object, Object>[])table, (Function<? super Object, ?>)function, (Consumer<? super Object>)consumer);
                    BytecodeManager.incBytecodes(1);
                    forEachTransformedValueTask.invoke();
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    return;
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
    
    public <U> U searchValues(final long n, final Function<? super V, ? extends U> function) {
        try {
            BytecodeManager.incBytecodes(2);
            if (function == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final BulkTask<Object, Object, ?> bulkTask = null;
            BytecodeManager.incBytecodes(5);
            BytecodeManager.incBytecodes(1);
            final int batch = this.batchFor(n);
            final int n2 = 0;
            final int n3 = 0;
            final Node<K, V>[] table = this.table;
            BytecodeManager.incBytecodes(8);
            final AtomicReference<Object> atomicReference = new AtomicReference<Object>();
            BytecodeManager.incBytecodes(1);
            final SearchValuesTask searchValuesTask = new SearchValuesTask(bulkTask, batch, n2, n3, (Node<Object, Object>[])table, (Function<? super Object, ?>)function, atomicReference);
            BytecodeManager.incBytecodes(1);
            final U invoke = searchValuesTask.invoke();
            BytecodeManager.incBytecodes(1);
            return invoke;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public V reduceValues(final long n, final BiFunction<? super V, ? super V, ? extends V> biFunction) {
        try {
            BytecodeManager.incBytecodes(2);
            if (biFunction == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final BulkTask<Object, Object, ?> bulkTask = null;
            BytecodeManager.incBytecodes(5);
            BytecodeManager.incBytecodes(1);
            final int batch = this.batchFor(n);
            final int n2 = 0;
            final int n3 = 0;
            final Node<K, V>[] table = this.table;
            final ReduceValuesTask<Object, Object> reduceValuesTask = null;
            BytecodeManager.incBytecodes(7);
            final ReduceValuesTask reduceValuesTask2 = new ReduceValuesTask(bulkTask, batch, n2, n3, (Node<Object, Object>[])table, reduceValuesTask, (BiFunction<? super Object, ? super Object, ?>)biFunction);
            BytecodeManager.incBytecodes(1);
            final V invoke = reduceValuesTask2.invoke();
            BytecodeManager.incBytecodes(1);
            return invoke;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public <U> U reduceValues(final long n, final Function<? super V, ? extends U> function, final BiFunction<? super U, ? super U, ? extends U> biFunction) {
        try {
            BytecodeManager.incBytecodes(2);
            if (function != null) {
                BytecodeManager.incBytecodes(2);
                if (biFunction != null) {
                    final BulkTask<Object, Object, ?> bulkTask = null;
                    BytecodeManager.incBytecodes(5);
                    BytecodeManager.incBytecodes(1);
                    final int batch = this.batchFor(n);
                    final int n2 = 0;
                    final int n3 = 0;
                    final Node<K, V>[] table = this.table;
                    final MapReduceValuesTask<Object, Object, Object> mapReduceValuesTask = null;
                    BytecodeManager.incBytecodes(8);
                    final MapReduceValuesTask mapReduceValuesTask2 = new MapReduceValuesTask(bulkTask, batch, n2, n3, (Node<Object, Object>[])table, mapReduceValuesTask, (Function<? super Object, ?>)function, (BiFunction<? super Object, ? super Object, ?>)biFunction);
                    BytecodeManager.incBytecodes(1);
                    final U invoke = mapReduceValuesTask2.invoke();
                    BytecodeManager.incBytecodes(1);
                    return invoke;
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
    
    public double reduceValuesToDouble(final long n, final ToDoubleFunction<? super V> toDoubleFunction, final double n2, final DoubleBinaryOperator doubleBinaryOperator) {
        try {
            BytecodeManager.incBytecodes(2);
            if (toDoubleFunction != null) {
                BytecodeManager.incBytecodes(2);
                if (doubleBinaryOperator != null) {
                    final BulkTask<Object, Object, ?> bulkTask = null;
                    BytecodeManager.incBytecodes(5);
                    BytecodeManager.incBytecodes(1);
                    final int batch = this.batchFor(n);
                    final int n3 = 0;
                    final int n4 = 0;
                    final Node<K, V>[] table = this.table;
                    final MapReduceValuesToDoubleTask<Object, Object> mapReduceValuesToDoubleTask = null;
                    BytecodeManager.incBytecodes(9);
                    final MapReduceValuesToDoubleTask mapReduceValuesToDoubleTask2 = new MapReduceValuesToDoubleTask(bulkTask, batch, n3, n4, (Node<Object, Object>[])table, mapReduceValuesToDoubleTask, (ToDoubleFunction<? super Object>)toDoubleFunction, n2, doubleBinaryOperator);
                    BytecodeManager.incBytecodes(1);
                    final Double n5 = mapReduceValuesToDoubleTask2.invoke();
                    BytecodeManager.incBytecodes(2);
                    final double doubleValue = n5;
                    BytecodeManager.incBytecodes(1);
                    return doubleValue;
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
    
    public long reduceValuesToLong(final long n, final ToLongFunction<? super V> toLongFunction, final long n2, final LongBinaryOperator longBinaryOperator) {
        try {
            BytecodeManager.incBytecodes(2);
            if (toLongFunction != null) {
                BytecodeManager.incBytecodes(2);
                if (longBinaryOperator != null) {
                    final BulkTask<Object, Object, ?> bulkTask = null;
                    BytecodeManager.incBytecodes(5);
                    BytecodeManager.incBytecodes(1);
                    final int batch = this.batchFor(n);
                    final int n3 = 0;
                    final int n4 = 0;
                    final Node<K, V>[] table = this.table;
                    final MapReduceValuesToLongTask<Object, Object> mapReduceValuesToLongTask = null;
                    BytecodeManager.incBytecodes(9);
                    final MapReduceValuesToLongTask mapReduceValuesToLongTask2 = new MapReduceValuesToLongTask(bulkTask, batch, n3, n4, (Node<Object, Object>[])table, mapReduceValuesToLongTask, (ToLongFunction<? super Object>)toLongFunction, n2, longBinaryOperator);
                    BytecodeManager.incBytecodes(1);
                    final Long n5 = mapReduceValuesToLongTask2.invoke();
                    BytecodeManager.incBytecodes(2);
                    final long longValue = n5;
                    BytecodeManager.incBytecodes(1);
                    return longValue;
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
    
    public int reduceValuesToInt(final long n, final ToIntFunction<? super V> toIntFunction, final int n2, final IntBinaryOperator intBinaryOperator) {
        try {
            BytecodeManager.incBytecodes(2);
            if (toIntFunction != null) {
                BytecodeManager.incBytecodes(2);
                if (intBinaryOperator != null) {
                    final BulkTask<Object, Object, ?> bulkTask = null;
                    BytecodeManager.incBytecodes(5);
                    BytecodeManager.incBytecodes(1);
                    final int batch = this.batchFor(n);
                    final int n3 = 0;
                    final int n4 = 0;
                    final Node<K, V>[] table = this.table;
                    final MapReduceValuesToIntTask<Object, Object> mapReduceValuesToIntTask = null;
                    BytecodeManager.incBytecodes(9);
                    final MapReduceValuesToIntTask mapReduceValuesToIntTask2 = new MapReduceValuesToIntTask(bulkTask, batch, n3, n4, (Node<Object, Object>[])table, mapReduceValuesToIntTask, (ToIntFunction<? super Object>)toIntFunction, n2, intBinaryOperator);
                    BytecodeManager.incBytecodes(1);
                    final Integer n5 = mapReduceValuesToIntTask2.invoke();
                    BytecodeManager.incBytecodes(2);
                    final int intValue = n5;
                    BytecodeManager.incBytecodes(1);
                    return intValue;
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
    
    public void forEachEntry(final long n, final Consumer<? super Map.Entry<K, V>> consumer) {
        try {
            BytecodeManager.incBytecodes(2);
            if (consumer == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final BulkTask<Object, Object, ?> bulkTask = null;
            BytecodeManager.incBytecodes(6);
            final int batch = this.batchFor(n);
            final int n2 = 0;
            final int n3 = 0;
            final Node<K, V>[] table = this.table;
            BytecodeManager.incBytecodes(6);
            final ForEachEntryTask forEachEntryTask = new ForEachEntryTask(bulkTask, batch, n2, n3, (Node<Object, Object>[])table, (Consumer<? super Map.Entry<Object, Object>>)consumer);
            BytecodeManager.incBytecodes(1);
            forEachEntryTask.invoke();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public <U> void forEachEntry(final long n, final Function<Map.Entry<K, V>, ? extends U> function, final Consumer<? super U> consumer) {
        try {
            BytecodeManager.incBytecodes(2);
            if (function != null) {
                BytecodeManager.incBytecodes(2);
                if (consumer != null) {
                    final BulkTask<Object, Object, ?> bulkTask = null;
                    BytecodeManager.incBytecodes(5);
                    BytecodeManager.incBytecodes(1);
                    final int batch = this.batchFor(n);
                    final int n2 = 0;
                    final int n3 = 0;
                    final Node<K, V>[] table = this.table;
                    BytecodeManager.incBytecodes(7);
                    final ForEachTransformedEntryTask forEachTransformedEntryTask = new ForEachTransformedEntryTask(bulkTask, batch, n2, n3, (Node<Object, Object>[])table, (Function<Map.Entry<Object, Object>, ?>)function, (Consumer<? super Object>)consumer);
                    BytecodeManager.incBytecodes(1);
                    forEachTransformedEntryTask.invoke();
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    return;
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
    
    public <U> U searchEntries(final long n, final Function<Map.Entry<K, V>, ? extends U> function) {
        try {
            BytecodeManager.incBytecodes(2);
            if (function == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final BulkTask<Object, Object, ?> bulkTask = null;
            BytecodeManager.incBytecodes(5);
            BytecodeManager.incBytecodes(1);
            final int batch = this.batchFor(n);
            final int n2 = 0;
            final int n3 = 0;
            final Node<K, V>[] table = this.table;
            BytecodeManager.incBytecodes(8);
            final AtomicReference<Object> atomicReference = new AtomicReference<Object>();
            BytecodeManager.incBytecodes(1);
            final SearchEntriesTask searchEntriesTask = new SearchEntriesTask(bulkTask, batch, n2, n3, (Node<Object, Object>[])table, (Function<Map.Entry<Object, Object>, ?>)function, atomicReference);
            BytecodeManager.incBytecodes(1);
            final U invoke = searchEntriesTask.invoke();
            BytecodeManager.incBytecodes(1);
            return invoke;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Map.Entry<K, V> reduceEntries(final long n, final BiFunction<Map.Entry<K, V>, Map.Entry<K, V>, ? extends Map.Entry<K, V>> biFunction) {
        try {
            BytecodeManager.incBytecodes(2);
            if (biFunction == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final BulkTask<Object, Object, ?> bulkTask = null;
            BytecodeManager.incBytecodes(5);
            BytecodeManager.incBytecodes(1);
            final int batch = this.batchFor(n);
            final int n2 = 0;
            final int n3 = 0;
            final Node<K, V>[] table = this.table;
            final ReduceEntriesTask<Object, Object> reduceEntriesTask = null;
            BytecodeManager.incBytecodes(7);
            final ReduceEntriesTask reduceEntriesTask2 = new ReduceEntriesTask(bulkTask, batch, n2, n3, (Node<Object, Object>[])table, reduceEntriesTask, (BiFunction<Map.Entry<Object, Object>, Map.Entry<Object, Object>, ? extends Map.Entry<Object, Object>>)biFunction);
            BytecodeManager.incBytecodes(1);
            final Map.Entry<K, V> entry = reduceEntriesTask2.invoke();
            BytecodeManager.incBytecodes(2);
            return entry;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public <U> U reduceEntries(final long n, final Function<Map.Entry<K, V>, ? extends U> function, final BiFunction<? super U, ? super U, ? extends U> biFunction) {
        try {
            BytecodeManager.incBytecodes(2);
            if (function != null) {
                BytecodeManager.incBytecodes(2);
                if (biFunction != null) {
                    final BulkTask<Object, Object, ?> bulkTask = null;
                    BytecodeManager.incBytecodes(5);
                    BytecodeManager.incBytecodes(1);
                    final int batch = this.batchFor(n);
                    final int n2 = 0;
                    final int n3 = 0;
                    final Node<K, V>[] table = this.table;
                    final MapReduceEntriesTask<Object, Object, Object> mapReduceEntriesTask = null;
                    BytecodeManager.incBytecodes(8);
                    final MapReduceEntriesTask mapReduceEntriesTask2 = new MapReduceEntriesTask(bulkTask, batch, n2, n3, (Node<Object, Object>[])table, mapReduceEntriesTask, (Function<Map.Entry<Object, Object>, ?>)function, (BiFunction<? super Object, ? super Object, ?>)biFunction);
                    BytecodeManager.incBytecodes(1);
                    final U invoke = mapReduceEntriesTask2.invoke();
                    BytecodeManager.incBytecodes(1);
                    return invoke;
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
    
    public double reduceEntriesToDouble(final long n, final ToDoubleFunction<Map.Entry<K, V>> toDoubleFunction, final double n2, final DoubleBinaryOperator doubleBinaryOperator) {
        try {
            BytecodeManager.incBytecodes(2);
            if (toDoubleFunction != null) {
                BytecodeManager.incBytecodes(2);
                if (doubleBinaryOperator != null) {
                    final BulkTask<Object, Object, ?> bulkTask = null;
                    BytecodeManager.incBytecodes(5);
                    BytecodeManager.incBytecodes(1);
                    final int batch = this.batchFor(n);
                    final int n3 = 0;
                    final int n4 = 0;
                    final Node<K, V>[] table = this.table;
                    final MapReduceEntriesToDoubleTask<Object, Object> mapReduceEntriesToDoubleTask = null;
                    BytecodeManager.incBytecodes(9);
                    final MapReduceEntriesToDoubleTask mapReduceEntriesToDoubleTask2 = new MapReduceEntriesToDoubleTask(bulkTask, batch, n3, n4, (Node<Object, Object>[])table, mapReduceEntriesToDoubleTask, (ToDoubleFunction<Map.Entry<Object, Object>>)toDoubleFunction, n2, doubleBinaryOperator);
                    BytecodeManager.incBytecodes(1);
                    final Double n5 = mapReduceEntriesToDoubleTask2.invoke();
                    BytecodeManager.incBytecodes(2);
                    final double doubleValue = n5;
                    BytecodeManager.incBytecodes(1);
                    return doubleValue;
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
    
    public long reduceEntriesToLong(final long n, final ToLongFunction<Map.Entry<K, V>> toLongFunction, final long n2, final LongBinaryOperator longBinaryOperator) {
        try {
            BytecodeManager.incBytecodes(2);
            if (toLongFunction != null) {
                BytecodeManager.incBytecodes(2);
                if (longBinaryOperator != null) {
                    final BulkTask<Object, Object, ?> bulkTask = null;
                    BytecodeManager.incBytecodes(5);
                    BytecodeManager.incBytecodes(1);
                    final int batch = this.batchFor(n);
                    final int n3 = 0;
                    final int n4 = 0;
                    final Node<K, V>[] table = this.table;
                    final MapReduceEntriesToLongTask<Object, Object> mapReduceEntriesToLongTask = null;
                    BytecodeManager.incBytecodes(9);
                    final MapReduceEntriesToLongTask mapReduceEntriesToLongTask2 = new MapReduceEntriesToLongTask(bulkTask, batch, n3, n4, (Node<Object, Object>[])table, mapReduceEntriesToLongTask, (ToLongFunction<Map.Entry<Object, Object>>)toLongFunction, n2, longBinaryOperator);
                    BytecodeManager.incBytecodes(1);
                    final Long n5 = mapReduceEntriesToLongTask2.invoke();
                    BytecodeManager.incBytecodes(2);
                    final long longValue = n5;
                    BytecodeManager.incBytecodes(1);
                    return longValue;
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
    
    public int reduceEntriesToInt(final long n, final ToIntFunction<Map.Entry<K, V>> toIntFunction, final int n2, final IntBinaryOperator intBinaryOperator) {
        try {
            BytecodeManager.incBytecodes(2);
            if (toIntFunction != null) {
                BytecodeManager.incBytecodes(2);
                if (intBinaryOperator != null) {
                    final BulkTask<Object, Object, ?> bulkTask = null;
                    BytecodeManager.incBytecodes(5);
                    BytecodeManager.incBytecodes(1);
                    final int batch = this.batchFor(n);
                    final int n3 = 0;
                    final int n4 = 0;
                    final Node<K, V>[] table = this.table;
                    final MapReduceEntriesToIntTask<Object, Object> mapReduceEntriesToIntTask = null;
                    BytecodeManager.incBytecodes(9);
                    final MapReduceEntriesToIntTask mapReduceEntriesToIntTask2 = new MapReduceEntriesToIntTask(bulkTask, batch, n3, n4, (Node<Object, Object>[])table, mapReduceEntriesToIntTask, (ToIntFunction<Map.Entry<Object, Object>>)toIntFunction, n2, intBinaryOperator);
                    BytecodeManager.incBytecodes(1);
                    final Integer n5 = mapReduceEntriesToIntTask2.invoke();
                    BytecodeManager.incBytecodes(2);
                    final int intValue = n5;
                    BytecodeManager.incBytecodes(1);
                    return intValue;
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
    
    static {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     2: putstatic       instrumented/java/util/concurrent/ConcurrentHashMap.RESIZE_STAMP_BITS:I
        //     5: ldc_w           2
        //     8: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    11: iconst_1       
        //    12: bipush          32
        //    14: getstatic       instrumented/java/util/concurrent/ConcurrentHashMap.RESIZE_STAMP_BITS:I
        //    17: isub           
        //    18: ishl           
        //    19: iconst_1       
        //    20: isub           
        //    21: putstatic       instrumented/java/util/concurrent/ConcurrentHashMap.MAX_RESIZERS:I
        //    24: ldc             8
        //    26: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    29: bipush          32
        //    31: getstatic       instrumented/java/util/concurrent/ConcurrentHashMap.RESIZE_STAMP_BITS:I
        //    34: isub           
        //    35: putstatic       instrumented/java/util/concurrent/ConcurrentHashMap.RESIZE_STAMP_SHIFT:I
        //    38: ldc             4
        //    40: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    43: ldc_w           1
        //    46: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    49: invokestatic    java/lang/Runtime.getRuntime:()Ljava/lang/Runtime;
        //    52: ldc_w           1
        //    55: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    58: invokevirtual   java/lang/Runtime.availableProcessors:()I
        //    61: putstatic       instrumented/java/util/concurrent/ConcurrentHashMap.NCPU:I
        //    64: ldc_w           1
        //    67: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    70: iconst_3       
        //    71: anewarray       Ljava/io/ObjectStreamField;
        //    74: dup            
        //    75: iconst_0       
        //    76: new             Ljava/io/ObjectStreamField;
        //    79: dup            
        //    80: ldc_w           "segments"
        //    83: ldc_w           [Linstrumented/java/util/concurrent/ConcurrentHashMap$Segment;.class
        //    86: ldc             8
        //    88: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    91: invokespecial   java/io/ObjectStreamField.<init>:(Ljava/lang/String;Ljava/lang/Class;)V
        //    94: aastore        
        //    95: dup            
        //    96: iconst_1       
        //    97: new             Ljava/io/ObjectStreamField;
        //   100: dup            
        //   101: ldc_w           "segmentMask"
        //   104: getstatic       java/lang/Integer.TYPE:Ljava/lang/Class;
        //   107: ldc             8
        //   109: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   112: invokespecial   java/io/ObjectStreamField.<init>:(Ljava/lang/String;Ljava/lang/Class;)V
        //   115: aastore        
        //   116: dup            
        //   117: iconst_2       
        //   118: new             Ljava/io/ObjectStreamField;
        //   121: dup            
        //   122: ldc_w           "segmentShift"
        //   125: getstatic       java/lang/Integer.TYPE:Ljava/lang/Class;
        //   128: ldc             8
        //   130: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   133: invokespecial   java/io/ObjectStreamField.<init>:(Ljava/lang/String;Ljava/lang/Class;)V
        //   136: aastore        
        //   137: putstatic       instrumented/java/util/concurrent/ConcurrentHashMap.serialPersistentFields:[Ljava/io/ObjectStreamField;
        //   140: ldc_w           2
        //   143: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   146: ldc_w           1
        //   149: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   152: invokestatic    sun/misc/Unsafe.getUnsafe:()Lsun/misc/Unsafe;
        //   155: putstatic       instrumented/java/util/concurrent/ConcurrentHashMap.U:Lsun/misc/Unsafe;
        //   158: ldc_w           1
        //   161: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   164: ldc             Linstrumented/java/util/concurrent/ConcurrentHashMap;.class
        //   166: astore_0       
        //   167: ldc_w           2
        //   170: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   173: getstatic       instrumented/java/util/concurrent/ConcurrentHashMap.U:Lsun/misc/Unsafe;
        //   176: aload_0        
        //   177: ldc_w           "sizeCtl"
        //   180: ldc_w           3
        //   183: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   186: ldc_w           1
        //   189: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   192: invokevirtual   java/lang/Class.getDeclaredField:(Ljava/lang/String;)Ljava/lang/reflect/Field;
        //   195: ldc_w           1
        //   198: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   201: invokevirtual   sun/misc/Unsafe.objectFieldOffset:(Ljava/lang/reflect/Field;)J
        //   204: putstatic       instrumented/java/util/concurrent/ConcurrentHashMap.SIZECTL:J
        //   207: ldc_w           1
        //   210: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   213: getstatic       instrumented/java/util/concurrent/ConcurrentHashMap.U:Lsun/misc/Unsafe;
        //   216: aload_0        
        //   217: ldc_w           "transferIndex"
        //   220: ldc_w           3
        //   223: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   226: ldc_w           1
        //   229: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   232: invokevirtual   java/lang/Class.getDeclaredField:(Ljava/lang/String;)Ljava/lang/reflect/Field;
        //   235: ldc_w           1
        //   238: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   241: invokevirtual   sun/misc/Unsafe.objectFieldOffset:(Ljava/lang/reflect/Field;)J
        //   244: putstatic       instrumented/java/util/concurrent/ConcurrentHashMap.TRANSFERINDEX:J
        //   247: ldc_w           1
        //   250: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   253: getstatic       instrumented/java/util/concurrent/ConcurrentHashMap.U:Lsun/misc/Unsafe;
        //   256: aload_0        
        //   257: ldc_w           "baseCount"
        //   260: ldc_w           3
        //   263: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   266: ldc_w           1
        //   269: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   272: invokevirtual   java/lang/Class.getDeclaredField:(Ljava/lang/String;)Ljava/lang/reflect/Field;
        //   275: ldc_w           1
        //   278: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   281: invokevirtual   sun/misc/Unsafe.objectFieldOffset:(Ljava/lang/reflect/Field;)J
        //   284: putstatic       instrumented/java/util/concurrent/ConcurrentHashMap.BASECOUNT:J
        //   287: ldc_w           1
        //   290: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   293: getstatic       instrumented/java/util/concurrent/ConcurrentHashMap.U:Lsun/misc/Unsafe;
        //   296: aload_0        
        //   297: ldc_w           "cellsBusy"
        //   300: ldc_w           3
        //   303: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   306: ldc_w           1
        //   309: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   312: invokevirtual   java/lang/Class.getDeclaredField:(Ljava/lang/String;)Ljava/lang/reflect/Field;
        //   315: ldc_w           1
        //   318: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   321: invokevirtual   sun/misc/Unsafe.objectFieldOffset:(Ljava/lang/reflect/Field;)J
        //   324: putstatic       instrumented/java/util/concurrent/ConcurrentHashMap.CELLSBUSY:J
        //   327: ldc_w           1
        //   330: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   333: ldc             Linstrumented/java/util/concurrent/ConcurrentHashMap$CounterCell;.class
        //   335: astore_1       
        //   336: ldc_w           2
        //   339: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   342: getstatic       instrumented/java/util/concurrent/ConcurrentHashMap.U:Lsun/misc/Unsafe;
        //   345: aload_1        
        //   346: ldc_w           "value"
        //   349: ldc_w           3
        //   352: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   355: ldc_w           1
        //   358: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   361: invokevirtual   java/lang/Class.getDeclaredField:(Ljava/lang/String;)Ljava/lang/reflect/Field;
        //   364: ldc_w           1
        //   367: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   370: invokevirtual   sun/misc/Unsafe.objectFieldOffset:(Ljava/lang/reflect/Field;)J
        //   373: putstatic       instrumented/java/util/concurrent/ConcurrentHashMap.CELLVALUE:J
        //   376: ldc_w           1
        //   379: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   382: ldc_w           [Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;.class
        //   385: astore_2       
        //   386: ldc_w           2
        //   389: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   392: getstatic       instrumented/java/util/concurrent/ConcurrentHashMap.U:Lsun/misc/Unsafe;
        //   395: aload_2        
        //   396: ldc_w           3
        //   399: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   402: invokevirtual   sun/misc/Unsafe.arrayBaseOffset:(Ljava/lang/Class;)I
        //   405: i2l            
        //   406: putstatic       instrumented/java/util/concurrent/ConcurrentHashMap.ABASE:J
        //   409: ldc_w           2
        //   412: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   415: getstatic       instrumented/java/util/concurrent/ConcurrentHashMap.U:Lsun/misc/Unsafe;
        //   418: aload_2        
        //   419: ldc_w           3
        //   422: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   425: invokevirtual   sun/misc/Unsafe.arrayIndexScale:(Ljava/lang/Class;)I
        //   428: istore_3       
        //   429: ldc_w           1
        //   432: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   435: iload_3        
        //   436: iload_3        
        //   437: iconst_1       
        //   438: isub           
        //   439: iand           
        //   440: ldc             6
        //   442: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   445: ifeq            470
        //   448: new             Ljava/lang/Error;
        //   451: dup            
        //   452: ldc_w           "data type scale not a power of two"
        //   455: ldc             4
        //   457: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   460: invokespecial   java/lang/Error.<init>:(Ljava/lang/String;)V
        //   463: ldc_w           1
        //   466: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   469: athrow         
        //   470: bipush          31
        //   472: iload_3        
        //   473: ldc_w           3
        //   476: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   479: invokestatic    java/lang/Integer.numberOfLeadingZeros:(I)I
        //   482: isub           
        //   483: putstatic       instrumented/java/util/concurrent/ConcurrentHashMap.ASHIFT:I
        //   486: ldc_w           2
        //   489: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   492: ldc_w           1
        //   495: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   498: goto            528
        //   501: astore_0       
        //   502: ldc_w           501
        //   505: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   508: new             Ljava/lang/Error;
        //   511: dup            
        //   512: aload_0        
        //   513: ldc             4
        //   515: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   518: invokespecial   java/lang/Error.<init>:(Ljava/lang/Throwable;)V
        //   521: ldc_w           1
        //   524: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   527: athrow         
        //   528: ldc_w           1
        //   531: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   534: return         
        //   535: athrow         
        //   536: athrow         
        //    StackMapTable: 00 05 FF 01 D6 00 04 07 01 10 07 01 10 07 01 10 01 00 00 FF 00 1E 00 00 00 01 07 03 8B 1A FF 00 06 00 00 00 01 07 00 FD FF 00 00 00 00 00 01 07 01 9E
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  146    536    536    537    Ljava/lang/VirtualMachineError;
        //  146    492    501    528    Ljava/lang/Exception;
        //  0      535    535    536    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0470:
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
    
    static class Node<K, V> implements Map.Entry<K, V>
    {
        final int hash;
        final K key;
        volatile V val;
        volatile Node<K, V> next;
        
        Node(final int hash, final K key, final V val, final Node<K, V> next) {
            try {
                BytecodeManager.incBytecodes(2);
                this.hash = hash;
                BytecodeManager.incBytecodes(3);
                this.key = key;
                BytecodeManager.incBytecodes(3);
                this.val = val;
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
                final V val = this.val;
                BytecodeManager.incBytecodes(3);
                return val;
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
                final int hashCode = key.hashCode();
                final V val = this.val;
                BytecodeManager.incBytecodes(3);
                final int n = hashCode ^ val.hashCode();
                BytecodeManager.incBytecodes(2);
                return n;
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
                final V val = this.val;
                BytecodeManager.incBytecodes(3);
                final StringBuilder append3 = append2.append(val);
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
        public final V setValue(final V v) {
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
        public final boolean equals(final Object o) {
            try {
                final boolean b = o instanceof Map.Entry;
                BytecodeManager.incBytecodes(3);
                boolean b2 = false;
                Label_0165: {
                    Label_0159: {
                        if (b) {
                            final Map.Entry entry = (Map.Entry)o;
                            BytecodeManager.incBytecodes(4);
                            BytecodeManager.incBytecodes(1);
                            final K key;
                            final K k = key = entry.getKey();
                            BytecodeManager.incBytecodes(3);
                            if (k != null) {
                                final Map.Entry<K, V> entry2 = (Map.Entry<K, V>)entry;
                                BytecodeManager.incBytecodes(1);
                                BytecodeManager.incBytecodes(1);
                                final V value;
                                final V v = value = entry2.getValue();
                                BytecodeManager.incBytecodes(3);
                                if (v != null) {
                                    final K i = key;
                                    final K key2 = this.key;
                                    BytecodeManager.incBytecodes(4);
                                    if (i != key2) {
                                        final K j = key;
                                        final K key3 = this.key;
                                        BytecodeManager.incBytecodes(3);
                                        BytecodeManager.incBytecodes(1);
                                        final boolean equals = j.equals(key3);
                                        BytecodeManager.incBytecodes(1);
                                        if (!equals) {
                                            break Label_0159;
                                        }
                                    }
                                    final V v2 = value;
                                    final V val = this.val;
                                    BytecodeManager.incBytecodes(6);
                                    if (v2 != val) {
                                        final V v3 = value;
                                        final V obj = val;
                                        BytecodeManager.incBytecodes(2);
                                        BytecodeManager.incBytecodes(1);
                                        final boolean equals2 = v3.equals(obj);
                                        BytecodeManager.incBytecodes(1);
                                        if (!equals2) {
                                            break Label_0159;
                                        }
                                    }
                                    b2 = true;
                                    BytecodeManager.incBytecodes(2);
                                    break Label_0165;
                                }
                            }
                        }
                    }
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
        
        Node<K, V> find(final int n, final Object o) {
            try {
                Node next = this;
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(2);
                if (o != null) {
                    Node<K, V> node;
                    do {
                        final int hash = next.hash;
                        BytecodeManager.incBytecodes(4);
                        Label_0086: {
                            if (hash == n) {
                                final K key;
                                final K k = key = next.key;
                                BytecodeManager.incBytecodes(6);
                                if (k != o) {
                                    final K i = key;
                                    BytecodeManager.incBytecodes(2);
                                    if (i == null) {
                                        break Label_0086;
                                    }
                                    final K obj = key;
                                    BytecodeManager.incBytecodes(2);
                                    BytecodeManager.incBytecodes(1);
                                    final boolean equals = o.equals(obj);
                                    BytecodeManager.incBytecodes(1);
                                    if (!equals) {
                                        break Label_0086;
                                    }
                                }
                                final Node node2 = next;
                                BytecodeManager.incBytecodes(2);
                                return node2;
                            }
                        }
                        node = (next = next.next);
                        BytecodeManager.incBytecodes(5);
                    } while (node != null);
                }
                final Node<K, V> node3 = null;
                BytecodeManager.incBytecodes(2);
                return node3;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static class Segment<K, V> extends ReentrantLock implements Serializable
    {
        private static final long serialVersionUID = 2249069246763182397L;
        final float loadFactor;
        
        Segment(final float loadFactor) {
            try {
                BytecodeManager.incBytecodes(2);
                this.loadFactor = loadFactor;
                BytecodeManager.incBytecodes(4);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class ForwardingNode<K, V> extends Node<K, V>
    {
        final Node<K, V>[] nextTable;
        
        ForwardingNode(final Node<K, V>[] nextTable) {
            try {
                final int n = -1;
                final Object o = null;
                final Object o2 = null;
                final Node<Object, Object> node = null;
                BytecodeManager.incBytecodes(6);
                super(n, o, o2, node);
                this.nextTable = nextTable;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        Node<K, V> find(final int n, final Object o) {
            try {
                Map.Entry<K, V>[] array = (Map.Entry<K, V>[])this.nextTable;
                BytecodeManager.incBytecodes(3);
                Node<K, V> node2 = null;
                Label_0147: {
                    while (true) {
                        BytecodeManager.incBytecodes(2);
                        if (o == null) {
                            break;
                        }
                        final Map.Entry<K, V>[] array2 = array;
                        BytecodeManager.incBytecodes(2);
                        if (array2 == null) {
                            break;
                        }
                        final int length = array.length;
                        BytecodeManager.incBytecodes(5);
                        if (length == 0) {
                            break;
                        }
                        final Map.Entry<K, V>[] array3 = array;
                        final int n2 = length - 1 & n;
                        BytecodeManager.incBytecodes(6);
                        BytecodeManager.incBytecodes(1);
                        final Node<K, V> node = node2 = ConcurrentHashMap.tabAt((Node<K, V>[])array3, n2);
                        BytecodeManager.incBytecodes(3);
                        if (node == null) {
                            break;
                        }
                        Block_10: {
                            while (true) {
                                final int hash = node2.hash;
                                BytecodeManager.incBytecodes(6);
                                if (hash == n) {
                                    final K key;
                                    final K k = key = node2.key;
                                    BytecodeManager.incBytecodes(6);
                                    if (k == o) {
                                        break Label_0147;
                                    }
                                    final K i = key;
                                    BytecodeManager.incBytecodes(2);
                                    if (i != null) {
                                        final K obj = key;
                                        BytecodeManager.incBytecodes(2);
                                        BytecodeManager.incBytecodes(1);
                                        final boolean equals = o.equals(obj);
                                        BytecodeManager.incBytecodes(1);
                                        if (equals) {
                                            break Label_0147;
                                        }
                                    }
                                }
                                final int n3 = hash;
                                BytecodeManager.incBytecodes(2);
                                if (n3 < 0) {
                                    break;
                                }
                                final Node<K, V> node3 = node2 = node2.next;
                                BytecodeManager.incBytecodes(5);
                                if (node3 == null) {
                                    break Block_10;
                                }
                                BytecodeManager.incBytecodes(1);
                            }
                            final boolean b = node2 instanceof ForwardingNode;
                            BytecodeManager.incBytecodes(3);
                            if (b) {
                                array = (Map.Entry<K, V>[])((ForwardingNode<Object, Object>)node2).nextTable;
                                BytecodeManager.incBytecodes(4);
                                BytecodeManager.incBytecodes(1);
                                continue;
                            }
                            final ForwardingNode<Object, Object> forwardingNode = (ForwardingNode<Object, Object>)node2;
                            BytecodeManager.incBytecodes(4);
                            final Node<Object, Object> find = forwardingNode.find(n, o);
                            BytecodeManager.incBytecodes(1);
                            return (Node<K, V>)find;
                        }
                        final Node<K, V> node4 = null;
                        BytecodeManager.incBytecodes(2);
                        return node4;
                    }
                    final Node<K, V> node5 = null;
                    BytecodeManager.incBytecodes(2);
                    return node5;
                }
                final Node<K, V> node6 = node2;
                BytecodeManager.incBytecodes(2);
                return node6;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class ReservationNode<K, V> extends Node<K, V>
    {
        ReservationNode() {
            try {
                final int n = -3;
                final Object o = null;
                final Object o2 = null;
                final Node<Object, Object> node = null;
                BytecodeManager.incBytecodes(6);
                super(n, o, o2, node);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        Node<K, V> find(final int n, final Object o) {
            try {
                final Node<K, V> node = null;
                BytecodeManager.incBytecodes(2);
                return node;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    @Contended
    static final class CounterCell
    {
        volatile long value;
        
        CounterCell(final long value) {
            try {
                BytecodeManager.incBytecodes(2);
                this.value = value;
                BytecodeManager.incBytecodes(4);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class TreeNode<K, V> extends Node<K, V>
    {
        TreeNode<K, V> parent;
        TreeNode<K, V> left;
        TreeNode<K, V> right;
        TreeNode<K, V> prev;
        boolean red;
        
        TreeNode(final int n, final K k, final V v, final Node<K, V> node, final TreeNode<K, V> parent) {
            try {
                BytecodeManager.incBytecodes(6);
                super(n, k, v, node);
                this.parent = parent;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        Node<K, V> find(final int n, final Object o) {
            try {
                final Class<?> clazz = null;
                BytecodeManager.incBytecodes(5);
                final TreeNode<K, V> treeNode = this.findTreeNode(n, o, clazz);
                BytecodeManager.incBytecodes(1);
                return treeNode;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        final TreeNode<K, V> findTreeNode(final int n, final Object o, Class<?> comparableClass) {
            try {
                BytecodeManager.incBytecodes(2);
                if (o != null) {
                    TreeNode treeNode = this;
                    BytecodeManager.incBytecodes(2);
                    TreeNode treeNode2;
                    do {
                        final TreeNode<K, V> left = treeNode.left;
                        final TreeNode<K, V> right = treeNode.right;
                        BytecodeManager.incBytecodes(6);
                        final int hash = treeNode.hash;
                        BytecodeManager.incBytecodes(6);
                        Label_0325: {
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
                                    Label_0134: {
                                        if (k != o) {
                                            final K i = key;
                                            BytecodeManager.incBytecodes(2);
                                            if (i != null) {
                                                final K obj = key;
                                                BytecodeManager.incBytecodes(3);
                                                final boolean equals = o.equals(obj);
                                                BytecodeManager.incBytecodes(1);
                                                if (equals) {
                                                    break Label_0134;
                                                }
                                            }
                                            final TreeNode<K, V> treeNode3 = left;
                                            BytecodeManager.incBytecodes(2);
                                            if (treeNode3 == null) {
                                                treeNode = right;
                                                BytecodeManager.incBytecodes(3);
                                                break Label_0325;
                                            }
                                            final TreeNode<K, V> treeNode4 = right;
                                            BytecodeManager.incBytecodes(2);
                                            if (treeNode4 == null) {
                                                treeNode = left;
                                                BytecodeManager.incBytecodes(3);
                                                break Label_0325;
                                            }
                                            final Class<?> clazz = comparableClass;
                                            BytecodeManager.incBytecodes(2);
                                            Label_0284: {
                                                if (clazz == null) {
                                                    BytecodeManager.incBytecodes(1);
                                                    BytecodeManager.incBytecodes(1);
                                                    final Class<?> clazz2 = comparableClass = ConcurrentHashMap.comparableClassFor(o);
                                                    BytecodeManager.incBytecodes(3);
                                                    if (clazz2 == null) {
                                                        break Label_0284;
                                                    }
                                                }
                                                final Class<?> clazz3 = comparableClass;
                                                final K j = key;
                                                BytecodeManager.incBytecodes(3);
                                                BytecodeManager.incBytecodes(1);
                                                final int compareComparables = ConcurrentHashMap.compareComparables(clazz3, o, j);
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
                                                    break Label_0325;
                                                }
                                            }
                                            final TreeNode<K, V> treeNode6 = right;
                                            final Class<?> clazz4 = comparableClass;
                                            BytecodeManager.incBytecodes(5);
                                            final TreeNode treeNode7 = treeNode6.findTreeNode(n, o, clazz4);
                                            BytecodeManager.incBytecodes(3);
                                            if (treeNode7 != null) {
                                                final TreeNode treeNode8 = treeNode7;
                                                BytecodeManager.incBytecodes(2);
                                                return (TreeNode<K, V>)treeNode8;
                                            }
                                            treeNode = left;
                                            BytecodeManager.incBytecodes(2);
                                            break Label_0325;
                                        }
                                    }
                                    final TreeNode treeNode9 = treeNode;
                                    BytecodeManager.incBytecodes(2);
                                    return treeNode9;
                                }
                                treeNode = right;
                                BytecodeManager.incBytecodes(3);
                            }
                        }
                        treeNode2 = treeNode;
                        BytecodeManager.incBytecodes(2);
                    } while (treeNode2 != null);
                }
                final TreeNode<K, V> treeNode10 = null;
                BytecodeManager.incBytecodes(2);
                return treeNode10;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class TreeBin<K, V> extends Node<K, V>
    {
        TreeNode<K, V> root;
        volatile TreeNode<K, V> first;
        volatile Thread waiter;
        volatile int lockState;
        static final int WRITER = 1;
        static final int WAITER = 2;
        static final int READER = 4;
        private static final Unsafe U;
        private static final long LOCKSTATE;
        static final /* synthetic */ boolean $assertionsDisabled;
        
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
        
        TreeBin(final TreeNode<K, V> first) {
            try {
                final int n = -2;
                final Object o = null;
                final Object o2 = null;
                final Node<Object, Object> node = null;
                BytecodeManager.incBytecodes(6);
                super(n, o, o2, node);
                this.first = first;
                BytecodeManager.incBytecodes(3);
                TreeNode<K, V> balanceInsertion = null;
                BytecodeManager.incBytecodes(2);
                TreeNode<K, V> treeNode = first;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final TreeNode<K, V> treeNode2 = treeNode;
                    BytecodeManager.incBytecodes(2);
                    if (treeNode2 == null) {
                        break;
                    }
                    final TreeNode treeNode3 = (TreeNode)treeNode.next;
                    BytecodeManager.incBytecodes(4);
                    final TreeNode<K, V> treeNode4 = treeNode;
                    final TreeNode<K, V> treeNode5 = treeNode;
                    final TreeNode<K, V> treeNode6 = null;
                    treeNode5.right = (TreeNode<K, V>)treeNode6;
                    treeNode4.left = (TreeNode<K, V>)treeNode6;
                    BytecodeManager.incBytecodes(6);
                    final TreeNode<K, V> treeNode7 = balanceInsertion;
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
                        TreeNode<K, V> treeNode8 = balanceInsertion;
                        BytecodeManager.incBytecodes(2);
                        int n3 = 0;
                        TreeNode<K, V> parent;
                        while (true) {
                            final K key2 = treeNode8.key;
                            BytecodeManager.incBytecodes(3);
                            final int hash2 = treeNode8.hash;
                            final int n2 = hash;
                            BytecodeManager.incBytecodes(6);
                            Label_0302: {
                                if (hash2 > n2) {
                                    n3 = -1;
                                    BytecodeManager.incBytecodes(3);
                                }
                                else {
                                    final int n4 = hash2;
                                    final int n5 = hash;
                                    BytecodeManager.incBytecodes(3);
                                    if (n4 < n5) {
                                        n3 = 1;
                                        BytecodeManager.incBytecodes(3);
                                    }
                                    else {
                                        final Class<?> clazz = comparableClass;
                                        BytecodeManager.incBytecodes(2);
                                        Label_0283: {
                                            if (clazz == null) {
                                                final K k = key;
                                                BytecodeManager.incBytecodes(1);
                                                BytecodeManager.incBytecodes(1);
                                                final Class<?> clazz2 = comparableClass = ConcurrentHashMap.comparableClassFor(k);
                                                BytecodeManager.incBytecodes(3);
                                                if (clazz2 == null) {
                                                    break Label_0283;
                                                }
                                            }
                                            final Class<?> clazz3 = comparableClass;
                                            final K i = key;
                                            final K j = key2;
                                            BytecodeManager.incBytecodes(3);
                                            BytecodeManager.incBytecodes(1);
                                            final int n6 = n3 = ConcurrentHashMap.compareComparables(clazz3, i, j);
                                            BytecodeManager.incBytecodes(3);
                                            if (n6 != 0) {
                                                break Label_0302;
                                            }
                                        }
                                        final K l = key;
                                        final K m = key2;
                                        BytecodeManager.incBytecodes(3);
                                        n3 = tieBreakOrder(l, m);
                                        BytecodeManager.incBytecodes(1);
                                    }
                                }
                            }
                            parent = treeNode8;
                            BytecodeManager.incBytecodes(2);
                            final int n7 = n3;
                            BytecodeManager.incBytecodes(2);
                            TreeNode<K, V> treeNode10;
                            TreeNode<K, V> treeNode9;
                            if (n7 <= 0) {
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
                        final int n8 = n3;
                        BytecodeManager.incBytecodes(2);
                        if (n8 <= 0) {
                            parent.left = treeNode;
                            BytecodeManager.incBytecodes(4);
                        }
                        else {
                            parent.right = treeNode;
                            BytecodeManager.incBytecodes(3);
                        }
                        final TreeNode<K, V> treeNode11 = balanceInsertion;
                        final TreeNode<K, V> treeNode12 = treeNode;
                        BytecodeManager.incBytecodes(3);
                        balanceInsertion = balanceInsertion(treeNode11, treeNode12);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                    }
                    treeNode = (TreeNode<K, V>)treeNode3;
                    BytecodeManager.incBytecodes(3);
                }
                this.root = balanceInsertion;
                BytecodeManager.incBytecodes(3);
                final boolean $assertionsDisabled = TreeBin.$assertionsDisabled;
                BytecodeManager.incBytecodes(2);
                if (!$assertionsDisabled) {
                    final TreeNode<K, V> root = this.root;
                    BytecodeManager.incBytecodes(3);
                    final boolean checkInvariants = checkInvariants(root);
                    BytecodeManager.incBytecodes(1);
                    if (!checkInvariants) {
                        BytecodeManager.incBytecodes(3);
                        final AssertionError assertionError = new AssertionError();
                        BytecodeManager.incBytecodes(1);
                        throw assertionError;
                    }
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private final void lockRoot() {
            try {
                final Unsafe u = TreeBin.U;
                final long lockstate = TreeBin.LOCKSTATE;
                final int expected = 0;
                final int x = 1;
                BytecodeManager.incBytecodes(6);
                final boolean compareAndSwapInt = u.compareAndSwapInt(this, lockstate, expected, x);
                BytecodeManager.incBytecodes(1);
                if (!compareAndSwapInt) {
                    BytecodeManager.incBytecodes(2);
                    this.contendedLock();
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private final void unlockRoot() {
            try {
                this.lockState = 0;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private final void contendedLock() {
            try {
                boolean b = false;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int lockState;
                    final int n = (lockState = this.lockState) & 0xFFFFFFFD;
                    BytecodeManager.incBytecodes(7);
                    if (n == 0) {
                        final Unsafe u = TreeBin.U;
                        final long lockstate = TreeBin.LOCKSTATE;
                        final int expected = lockState;
                        final int x = 1;
                        BytecodeManager.incBytecodes(6);
                        final boolean compareAndSwapInt = u.compareAndSwapInt(this, lockstate, expected, x);
                        BytecodeManager.incBytecodes(1);
                        if (compareAndSwapInt) {
                            break;
                        }
                        continue;
                    }
                    else {
                        final int n2 = lockState & 0x2;
                        BytecodeManager.incBytecodes(4);
                        if (n2 == 0) {
                            final Unsafe u2 = TreeBin.U;
                            final long lockstate2 = TreeBin.LOCKSTATE;
                            final int expected2 = lockState;
                            final int x2 = lockState | 0x2;
                            BytecodeManager.incBytecodes(8);
                            final boolean compareAndSwapInt2 = u2.compareAndSwapInt(this, lockstate2, expected2, x2);
                            BytecodeManager.incBytecodes(1);
                            if (!compareAndSwapInt2) {
                                continue;
                            }
                            b = true;
                            BytecodeManager.incBytecodes(2);
                            BytecodeManager.incBytecodes(2);
                            this.waiter = Thread.currentThread();
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            final boolean b2 = b;
                            BytecodeManager.incBytecodes(2);
                            if (!b2) {
                                continue;
                            }
                            BytecodeManager.incBytecodes(2);
                            LockSupport.park(this);
                            BytecodeManager.incBytecodes(1);
                        }
                    }
                }
                final boolean b3 = b;
                BytecodeManager.incBytecodes(2);
                if (b3) {
                    this.waiter = null;
                    BytecodeManager.incBytecodes(3);
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        final Node<K, V> find(final int p0, final Object p1) {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: ldc             2
            //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //     6: ifnull          349
            //     9: aload_0        
            //    10: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeBin.first:Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
            //    13: astore_3       
            //    14: ldc             3
            //    16: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    19: aload_3        
            //    20: ldc             2
            //    22: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    25: ifnull          349
            //    28: aload_0        
            //    29: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeBin.lockState:I
            //    32: dup            
            //    33: istore          4
            //    35: iconst_3       
            //    36: iand           
            //    37: ldc             7
            //    39: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    42: ifeq            128
            //    45: aload_3        
            //    46: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$Node.hash:I
            //    49: iload_1        
            //    50: ldc             4
            //    52: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    55: if_icmpne       115
            //    58: aload_3        
            //    59: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$Node.key:Ljava/lang/Object;
            //    62: dup            
            //    63: astore          5
            //    65: aload_2        
            //    66: ldc             6
            //    68: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    71: if_acmpeq       108
            //    74: aload           5
            //    76: ldc             2
            //    78: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    81: ifnull          115
            //    84: aload_2        
            //    85: aload           5
            //    87: ldc             2
            //    89: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    92: ldc             1
            //    94: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    97: invokevirtual   java/lang/Object.equals:(Ljava/lang/Object;)Z
            //   100: ldc             1
            //   102: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   105: ifeq            115
            //   108: aload_3        
            //   109: ldc             2
            //   111: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   114: areturn        
            //   115: aload_3        
            //   116: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$Node.next:Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
            //   119: astore_3       
            //   120: ldc             4
            //   122: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   125: goto            341
            //   128: getstatic       instrumented/java/util/concurrent/ConcurrentHashMap$TreeBin.U:Lsun/misc/Unsafe;
            //   131: aload_0        
            //   132: getstatic       instrumented/java/util/concurrent/ConcurrentHashMap$TreeBin.LOCKSTATE:J
            //   135: iload           4
            //   137: iload           4
            //   139: iconst_4       
            //   140: iadd           
            //   141: ldc             8
            //   143: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   146: invokevirtual   sun/misc/Unsafe.compareAndSwapInt:(Ljava/lang/Object;JII)Z
            //   149: ldc             1
            //   151: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   154: ifeq            341
            //   157: aload_0        
            //   158: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeBin.root:Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
            //   161: dup            
            //   162: astore          6
            //   164: ldc             5
            //   166: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   169: ifnonnull       181
            //   172: aconst_null    
            //   173: ldc             2
            //   175: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   178: goto            199
            //   181: aload           6
            //   183: iload_1        
            //   184: aload_2        
            //   185: aconst_null    
            //   186: ldc             4
            //   188: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   191: ldc             1
            //   193: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   196: invokevirtual   instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.findTreeNode:(ILjava/lang/Object;Ljava/lang/Class;)Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
            //   199: astore          7
            //   201: ldc             1
            //   203: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   206: getstatic       instrumented/java/util/concurrent/ConcurrentHashMap$TreeBin.U:Lsun/misc/Unsafe;
            //   209: aload_0        
            //   210: getstatic       instrumented/java/util/concurrent/ConcurrentHashMap$TreeBin.LOCKSTATE:J
            //   213: bipush          -4
            //   215: ldc             5
            //   217: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   220: invokevirtual   sun/misc/Unsafe.getAndAddInt:(Ljava/lang/Object;JI)I
            //   223: bipush          6
            //   225: ldc             2
            //   227: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   230: if_icmpne       258
            //   233: aload_0        
            //   234: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeBin.waiter:Ljava/lang/Thread;
            //   237: dup            
            //   238: astore          8
            //   240: ldc             5
            //   242: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   245: ifnull          258
            //   248: aload           8
            //   250: ldc             2
            //   252: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   255: invokestatic    instrumented/java/util/concurrent/locks/LockSupport.unpark:(Ljava/lang/Thread;)V
            //   258: ldc             1
            //   260: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   263: goto            333
            //   266: astore          9
            //   268: ldc             501
            //   270: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   273: getstatic       instrumented/java/util/concurrent/ConcurrentHashMap$TreeBin.U:Lsun/misc/Unsafe;
            //   276: aload_0        
            //   277: getstatic       instrumented/java/util/concurrent/ConcurrentHashMap$TreeBin.LOCKSTATE:J
            //   280: bipush          -4
            //   282: ldc             5
            //   284: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   287: invokevirtual   sun/misc/Unsafe.getAndAddInt:(Ljava/lang/Object;JI)I
            //   290: bipush          6
            //   292: ldc             2
            //   294: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   297: if_icmpne       325
            //   300: aload_0        
            //   301: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeBin.waiter:Ljava/lang/Thread;
            //   304: dup            
            //   305: astore          10
            //   307: ldc             5
            //   309: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   312: ifnull          325
            //   315: aload           10
            //   317: ldc             2
            //   319: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   322: invokestatic    instrumented/java/util/concurrent/locks/LockSupport.unpark:(Ljava/lang/Thread;)V
            //   325: aload           9
            //   327: ldc             2
            //   329: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   332: athrow         
            //   333: aload           7
            //   335: ldc             2
            //   337: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   340: areturn        
            //   341: ldc             1
            //   343: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   346: goto            19
            //   349: aconst_null    
            //   350: ldc             2
            //   352: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   355: areturn        
            //   356: athrow         
            //   357: athrow         
            //    Signature:
            //  (ILjava/lang/Object;)Linstrumented/java/util/concurrent/ConcurrentHashMap$Node<TK;TV;>;
            //    StackMapTable: 00 0E FC 00 13 07 00 05 FD 00 58 01 07 00 2B FA 00 06 0C FD 00 34 00 07 00 0C 51 07 00 0C FC 00 3A 07 00 0C FF 00 07 00 05 07 00 02 01 07 00 2B 07 00 05 01 00 01 07 00 44 FF 00 3A 00 0A 07 00 02 01 07 00 2B 07 00 05 01 00 00 00 00 07 00 44 00 00 FF 00 07 00 08 07 00 02 01 07 00 2B 07 00 05 01 00 07 00 0C 07 00 0C 00 00 FF 00 07 00 04 07 00 02 01 07 00 2B 07 00 05 00 00 FA 00 07 FF 00 06 00 00 00 01 07 00 44 FF 00 00 00 00 00 01 07 00 A3
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                           
            //  -----  -----  -----  -----  -------------------------------
            //  157    357    357    358    Ljava/lang/VirtualMachineError;
            //  157    206    266    333    Any
            //  266    273    266    333    Any
            //  0      356    356    357    Any
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0181:
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
        
        final TreeNode<K, V> putTreeVal(final int p0, final K p1, final V p2) {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: astore          4
            //     3: ldc             2
            //     5: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //     8: iconst_0       
            //     9: istore          5
            //    11: ldc             2
            //    13: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    16: aload_0        
            //    17: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeBin.root:Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
            //    20: astore          6
            //    22: ldc             3
            //    24: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    27: aload           6
            //    29: ldc             2
            //    31: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    34: ifnonnull       76
            //    37: aload_0        
            //    38: aload_0        
            //    39: new             Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
            //    42: dup            
            //    43: iload_1        
            //    44: aload_2        
            //    45: aload_3        
            //    46: aconst_null    
            //    47: aconst_null    
            //    48: ldc             10
            //    50: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    53: invokespecial   instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.<init>:(ILjava/lang/Object;Ljava/lang/Object;Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;)V
            //    56: dup_x1         
            //    57: putfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeBin.root:Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
            //    60: putfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeBin.first:Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
            //    63: ldc             3
            //    65: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    68: ldc             1
            //    70: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    73: goto            650
            //    76: aload           6
            //    78: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.hash:I
            //    81: dup            
            //    82: istore          8
            //    84: iload_1        
            //    85: ldc             6
            //    87: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    90: if_icmple       104
            //    93: iconst_m1      
            //    94: istore          7
            //    96: ldc             3
            //    98: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   101: goto            380
            //   104: iload           8
            //   106: iload_1        
            //   107: ldc             3
            //   109: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   112: if_icmpge       126
            //   115: iconst_1       
            //   116: istore          7
            //   118: ldc             3
            //   120: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   123: goto            380
            //   126: aload           6
            //   128: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.key:Ljava/lang/Object;
            //   131: dup            
            //   132: astore          9
            //   134: aload_2        
            //   135: ldc             6
            //   137: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   140: if_acmpeq       172
            //   143: aload           9
            //   145: ldc             2
            //   147: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   150: ifnull          180
            //   153: aload_2        
            //   154: aload           9
            //   156: ldc             3
            //   158: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   161: invokevirtual   java/lang/Object.equals:(Ljava/lang/Object;)Z
            //   164: ldc             1
            //   166: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   169: ifeq            180
            //   172: aload           6
            //   174: ldc             2
            //   176: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   179: areturn        
            //   180: aload           4
            //   182: ldc             2
            //   184: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   187: ifnonnull       215
            //   190: aload_2        
            //   191: ldc             1
            //   193: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   196: ldc             1
            //   198: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   201: invokestatic    instrumented/java/util/concurrent/ConcurrentHashMap.comparableClassFor:(Ljava/lang/Object;)Ljava/lang/Class;
            //   204: dup            
            //   205: astore          4
            //   207: ldc             3
            //   209: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   212: ifnull          244
            //   215: aload           4
            //   217: aload_2        
            //   218: aload           9
            //   220: ldc             3
            //   222: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   225: ldc             1
            //   227: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   230: invokestatic    instrumented/java/util/concurrent/ConcurrentHashMap.compareComparables:(Ljava/lang/Class;Ljava/lang/Object;Ljava/lang/Object;)I
            //   233: dup            
            //   234: istore          7
            //   236: ldc             3
            //   238: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   241: ifne            380
            //   244: iload           5
            //   246: ldc             2
            //   248: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   251: ifne            362
            //   254: iconst_1       
            //   255: istore          5
            //   257: ldc             2
            //   259: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   262: aload           6
            //   264: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.left:Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
            //   267: dup            
            //   268: astore          11
            //   270: ldc             5
            //   272: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   275: ifnull          308
            //   278: aload           11
            //   280: iload_1        
            //   281: aload_2        
            //   282: aload           4
            //   284: ldc             4
            //   286: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   289: ldc             1
            //   291: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   294: invokevirtual   instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.findTreeNode:(ILjava/lang/Object;Ljava/lang/Class;)Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
            //   297: dup            
            //   298: astore          10
            //   300: ldc             3
            //   302: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   305: ifnonnull       354
            //   308: aload           6
            //   310: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.right:Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
            //   313: dup            
            //   314: astore          11
            //   316: ldc             5
            //   318: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   321: ifnull          362
            //   324: aload           11
            //   326: iload_1        
            //   327: aload_2        
            //   328: aload           4
            //   330: ldc             4
            //   332: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   335: ldc             1
            //   337: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   340: invokevirtual   instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.findTreeNode:(ILjava/lang/Object;Ljava/lang/Class;)Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
            //   343: dup            
            //   344: astore          10
            //   346: ldc             3
            //   348: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   351: ifnull          362
            //   354: aload           10
            //   356: ldc             2
            //   358: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   361: areturn        
            //   362: aload_2        
            //   363: aload           9
            //   365: ldc             3
            //   367: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   370: invokestatic    instrumented/java/util/concurrent/ConcurrentHashMap$TreeBin.tieBreakOrder:(Ljava/lang/Object;Ljava/lang/Object;)I
            //   373: istore          7
            //   375: ldc             1
            //   377: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   380: aload           6
            //   382: astore          10
            //   384: ldc             2
            //   386: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   389: iload           7
            //   391: ldc             2
            //   393: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   396: ifgt            412
            //   399: aload           6
            //   401: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.left:Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
            //   404: ldc             3
            //   406: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   409: goto            422
            //   412: aload           6
            //   414: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.right:Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
            //   417: ldc             2
            //   419: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   422: dup            
            //   423: astore          6
            //   425: ldc             3
            //   427: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   430: ifnonnull       642
            //   433: aload_0        
            //   434: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeBin.first:Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
            //   437: astore          12
            //   439: ldc             3
            //   441: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   444: aload_0        
            //   445: new             Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
            //   448: dup            
            //   449: iload_1        
            //   450: aload_2        
            //   451: aload_3        
            //   452: aload           12
            //   454: aload           10
            //   456: ldc             9
            //   458: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   461: invokespecial   instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.<init>:(ILjava/lang/Object;Ljava/lang/Object;Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;)V
            //   464: dup            
            //   465: astore          11
            //   467: putfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeBin.first:Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
            //   470: ldc             3
            //   472: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   475: aload           12
            //   477: ldc             2
            //   479: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   482: ifnull          497
            //   485: aload           12
            //   487: aload           11
            //   489: putfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.prev:Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
            //   492: ldc             3
            //   494: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   497: iload           7
            //   499: ldc             2
            //   501: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   504: ifgt            522
            //   507: aload           10
            //   509: aload           11
            //   511: putfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.left:Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
            //   514: ldc             4
            //   516: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   519: goto            534
            //   522: aload           10
            //   524: aload           11
            //   526: putfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.right:Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
            //   529: ldc             3
            //   531: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   534: aload           10
            //   536: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.red:Z
            //   539: ldc             3
            //   541: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   544: ifne            561
            //   547: aload           11
            //   549: iconst_1       
            //   550: putfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.red:Z
            //   553: ldc             4
            //   555: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   558: goto            650
            //   561: aload_0        
            //   562: ldc             2
            //   564: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   567: invokespecial   instrumented/java/util/concurrent/ConcurrentHashMap$TreeBin.lockRoot:()V
            //   570: aload_0        
            //   571: aload_0        
            //   572: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeBin.root:Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
            //   575: aload           11
            //   577: ldc             5
            //   579: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   582: invokestatic    instrumented/java/util/concurrent/ConcurrentHashMap$TreeBin.balanceInsertion:(Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;)Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
            //   585: putfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeBin.root:Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
            //   588: ldc             1
            //   590: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   593: aload_0        
            //   594: ldc             2
            //   596: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   599: invokespecial   instrumented/java/util/concurrent/ConcurrentHashMap$TreeBin.unlockRoot:()V
            //   602: ldc             1
            //   604: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   607: goto            634
            //   610: astore          13
            //   612: ldc             501
            //   614: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   617: aload_0        
            //   618: ldc             2
            //   620: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   623: invokespecial   instrumented/java/util/concurrent/ConcurrentHashMap$TreeBin.unlockRoot:()V
            //   626: aload           13
            //   628: ldc             2
            //   630: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   633: athrow         
            //   634: ldc             1
            //   636: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   639: goto            650
            //   642: ldc             1
            //   644: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   647: goto            27
            //   650: getstatic       instrumented/java/util/concurrent/ConcurrentHashMap$TreeBin.$assertionsDisabled:Z
            //   653: ldc             2
            //   655: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   658: ifne            699
            //   661: aload_0        
            //   662: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeBin.root:Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
            //   665: ldc             3
            //   667: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   670: invokestatic    instrumented/java/util/concurrent/ConcurrentHashMap$TreeBin.checkInvariants:(Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;)Z
            //   673: ldc             1
            //   675: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   678: ifne            699
            //   681: new             Ljava/lang/AssertionError;
            //   684: dup            
            //   685: ldc             3
            //   687: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   690: invokespecial   java/lang/AssertionError.<init>:()V
            //   693: ldc             1
            //   695: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   698: athrow         
            //   699: aconst_null    
            //   700: ldc             2
            //   702: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   705: areturn        
            //   706: athrow         
            //   707: athrow         
            //    Signature:
            //  (ITK;TV;)Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode<TK;TV;>;
            //    StackMapTable: 00 19 FE 00 1B 07 00 31 01 07 00 0C 30 FD 00 1B 00 01 15 FC 00 2D 07 00 2B 07 22 1C FD 00 3F 00 07 00 0C FF 00 2D 00 0C 07 00 02 01 07 00 2B 07 00 2B 07 00 31 01 07 00 0C 00 01 07 00 2B 07 00 0C 07 00 0C 00 00 F9 00 07 FF 00 11 00 09 07 00 02 01 07 00 2B 07 00 2B 07 00 31 01 07 00 0C 01 01 00 00 FD 00 1F 00 07 00 0C 49 07 00 0C FD 00 4A 07 00 0C 07 00 0C 18 0B 1A 70 07 00 44 17 FF 00 07 00 07 07 00 02 01 07 00 2B 07 00 2B 07 00 31 01 07 00 0C 00 00 FA 00 07 30 FF 00 06 00 00 00 01 07 00 44 FF 00 00 00 00 00 01 07 00 A3
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                           
            //  -----  -----  -----  -----  -------------------------------
            //  570    707    707    708    Ljava/lang/VirtualMachineError;
            //  570    593    610    634    Any
            //  610    617    610    634    Any
            //  0      706    706    707    Any
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0634:
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
        
        final boolean removeTreeNode(final TreeNode<K, V> p0) {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.next:Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
            //     4: checkcast       Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
            //     7: astore_2       
            //     8: ldc             4
            //    10: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    13: aload_1        
            //    14: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.prev:Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
            //    17: astore_3       
            //    18: ldc             3
            //    20: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    23: aload_3        
            //    24: ldc             2
            //    26: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    29: ifnonnull       45
            //    32: aload_0        
            //    33: aload_2        
            //    34: putfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeBin.first:Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
            //    37: ldc             4
            //    39: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    42: goto            55
            //    45: aload_3        
            //    46: aload_2        
            //    47: putfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.next:Linstrumented/java/util/concurrent/ConcurrentHashMap$Node;
            //    50: ldc             3
            //    52: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    55: aload_2        
            //    56: ldc             2
            //    58: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    61: ifnull          74
            //    64: aload_2        
            //    65: aload_3        
            //    66: putfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.prev:Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
            //    69: ldc             3
            //    71: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    74: aload_0        
            //    75: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeBin.first:Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
            //    78: ldc             3
            //    80: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    83: ifnonnull       103
            //    86: aload_0        
            //    87: aconst_null    
            //    88: putfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeBin.root:Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
            //    91: ldc             3
            //    93: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    96: iconst_1       
            //    97: ldc             2
            //    99: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   102: ireturn        
            //   103: aload_0        
            //   104: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeBin.root:Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
            //   107: dup            
            //   108: astore          4
            //   110: ldc             5
            //   112: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   115: ifnull          160
            //   118: aload           4
            //   120: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.right:Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
            //   123: ldc             3
            //   125: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   128: ifnull          160
            //   131: aload           4
            //   133: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.left:Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
            //   136: dup            
            //   137: astore          5
            //   139: ldc             5
            //   141: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   144: ifnull          160
            //   147: aload           5
            //   149: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.left:Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
            //   152: ldc             3
            //   154: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   157: ifnonnull       167
            //   160: iconst_1       
            //   161: ldc             2
            //   163: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   166: ireturn        
            //   167: aload_0        
            //   168: ldc             2
            //   170: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   173: invokespecial   instrumented/java/util/concurrent/ConcurrentHashMap$TreeBin.lockRoot:()V
            //   176: aload_1        
            //   177: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.left:Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
            //   180: astore          7
            //   182: ldc             3
            //   184: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   187: aload_1        
            //   188: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.right:Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
            //   191: astore          8
            //   193: ldc             3
            //   195: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   198: aload           7
            //   200: ldc             2
            //   202: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   205: ifnull          608
            //   208: aload           8
            //   210: ldc             2
            //   212: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   215: ifnull          608
            //   218: aload           8
            //   220: astore          9
            //   222: ldc             2
            //   224: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   227: aload           9
            //   229: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.left:Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
            //   232: dup            
            //   233: astore          10
            //   235: ldc             5
            //   237: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   240: ifnull          255
            //   243: aload           10
            //   245: astore          9
            //   247: ldc             3
            //   249: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   252: goto            227
            //   255: aload           9
            //   257: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.red:Z
            //   260: istore          11
            //   262: aload           9
            //   264: aload_1        
            //   265: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.red:Z
            //   268: putfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.red:Z
            //   271: aload_1        
            //   272: iload           11
            //   274: putfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.red:Z
            //   277: ldc             10
            //   279: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   282: aload           9
            //   284: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.right:Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
            //   287: astore          12
            //   289: ldc             3
            //   291: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   294: aload_1        
            //   295: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.parent:Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
            //   298: astore          13
            //   300: ldc             3
            //   302: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   305: aload           9
            //   307: aload           8
            //   309: ldc             3
            //   311: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   314: if_acmpne       342
            //   317: aload_1        
            //   318: aload           9
            //   320: putfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.parent:Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
            //   323: ldc             3
            //   325: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   328: aload           9
            //   330: aload_1        
            //   331: putfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.right:Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
            //   334: ldc             4
            //   336: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   339: goto            437
            //   342: aload           9
            //   344: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.parent:Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
            //   347: astore          14
            //   349: ldc             3
            //   351: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   354: aload_1        
            //   355: aload           14
            //   357: dup_x1         
            //   358: putfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.parent:Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
            //   361: ldc             5
            //   363: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   366: ifnull          409
            //   369: aload           9
            //   371: aload           14
            //   373: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.left:Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
            //   376: ldc             4
            //   378: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   381: if_acmpne       398
            //   384: aload           14
            //   386: aload_1        
            //   387: putfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.left:Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
            //   390: ldc             4
            //   392: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   395: goto            409
            //   398: aload           14
            //   400: aload_1        
            //   401: putfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.right:Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
            //   404: ldc             3
            //   406: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   409: aload           9
            //   411: aload           8
            //   413: dup_x1         
            //   414: putfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.right:Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
            //   417: ldc             5
            //   419: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   422: ifnull          437
            //   425: aload           8
            //   427: aload           9
            //   429: putfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.parent:Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
            //   432: ldc             3
            //   434: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   437: aload_1        
            //   438: aconst_null    
            //   439: putfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.left:Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
            //   442: ldc             3
            //   444: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   447: aload_1        
            //   448: aload           12
            //   450: dup_x1         
            //   451: putfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.right:Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
            //   454: ldc             5
            //   456: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   459: ifnull          473
            //   462: aload           12
            //   464: aload_1        
            //   465: putfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.parent:Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
            //   468: ldc             3
            //   470: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   473: aload           9
            //   475: aload           7
            //   477: dup_x1         
            //   478: putfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.left:Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
            //   481: ldc             5
            //   483: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   486: ifnull          501
            //   489: aload           7
            //   491: aload           9
            //   493: putfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.parent:Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
            //   496: ldc             3
            //   498: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   501: aload           9
            //   503: aload           13
            //   505: dup_x1         
            //   506: putfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.parent:Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
            //   509: ldc             5
            //   511: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   514: ifnonnull       529
            //   517: aload           9
            //   519: astore          4
            //   521: ldc             3
            //   523: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   526: goto            570
            //   529: aload_1        
            //   530: aload           13
            //   532: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.left:Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
            //   535: ldc             4
            //   537: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   540: if_acmpne       558
            //   543: aload           13
            //   545: aload           9
            //   547: putfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.left:Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
            //   550: ldc             4
            //   552: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   555: goto            570
            //   558: aload           13
            //   560: aload           9
            //   562: putfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.right:Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
            //   565: ldc             3
            //   567: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   570: aload           12
            //   572: ldc             2
            //   574: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   577: ifnull          592
            //   580: aload           12
            //   582: astore          6
            //   584: ldc             3
            //   586: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   589: goto            600
            //   592: aload_1        
            //   593: astore          6
            //   595: ldc             2
            //   597: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   600: ldc             1
            //   602: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   605: goto            660
            //   608: aload           7
            //   610: ldc             2
            //   612: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   615: ifnull          630
            //   618: aload           7
            //   620: astore          6
            //   622: ldc             3
            //   624: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   627: goto            660
            //   630: aload           8
            //   632: ldc             2
            //   634: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   637: ifnull          652
            //   640: aload           8
            //   642: astore          6
            //   644: ldc             3
            //   646: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   649: goto            660
            //   652: aload_1        
            //   653: astore          6
            //   655: ldc             2
            //   657: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   660: aload           6
            //   662: aload_1        
            //   663: ldc             3
            //   665: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   668: if_acmpeq       771
            //   671: aload           6
            //   673: aload_1        
            //   674: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.parent:Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
            //   677: dup_x1         
            //   678: putfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.parent:Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
            //   681: astore          9
            //   683: ldc             6
            //   685: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   688: aload           9
            //   690: ldc             2
            //   692: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   695: ifnonnull       710
            //   698: aload           6
            //   700: astore          4
            //   702: ldc             3
            //   704: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   707: goto            751
            //   710: aload_1        
            //   711: aload           9
            //   713: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.left:Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
            //   716: ldc             4
            //   718: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   721: if_acmpne       739
            //   724: aload           9
            //   726: aload           6
            //   728: putfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.left:Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
            //   731: ldc             4
            //   733: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   736: goto            751
            //   739: aload           9
            //   741: aload           6
            //   743: putfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.right:Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
            //   746: ldc             3
            //   748: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   751: aload_1        
            //   752: aload_1        
            //   753: aload_1        
            //   754: aconst_null    
            //   755: dup_x1         
            //   756: putfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.parent:Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
            //   759: dup_x1         
            //   760: putfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.right:Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
            //   763: putfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.left:Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
            //   766: ldc             9
            //   768: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   771: aload_0        
            //   772: aload_1        
            //   773: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.red:Z
            //   776: ldc             4
            //   778: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   781: ifeq            794
            //   784: aload           4
            //   786: ldc             2
            //   788: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   791: goto            806
            //   794: aload           4
            //   796: aload           6
            //   798: ldc             3
            //   800: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   803: invokestatic    instrumented/java/util/concurrent/ConcurrentHashMap$TreeBin.balanceDeletion:(Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;)Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
            //   806: putfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeBin.root:Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
            //   809: ldc             1
            //   811: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   814: aload_1        
            //   815: aload           6
            //   817: ldc             3
            //   819: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   822: if_acmpne       903
            //   825: aload_1        
            //   826: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.parent:Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
            //   829: dup            
            //   830: astore          9
            //   832: ldc             5
            //   834: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   837: ifnull          903
            //   840: aload_1        
            //   841: aload           9
            //   843: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.left:Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
            //   846: ldc             4
            //   848: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   851: if_acmpne       868
            //   854: aload           9
            //   856: aconst_null    
            //   857: putfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.left:Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
            //   860: ldc             4
            //   862: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   865: goto            893
            //   868: aload_1        
            //   869: aload           9
            //   871: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.right:Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
            //   874: ldc             4
            //   876: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   879: if_acmpne       893
            //   882: aload           9
            //   884: aconst_null    
            //   885: putfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.right:Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
            //   888: ldc             3
            //   890: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   893: aload_1        
            //   894: aconst_null    
            //   895: putfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeNode.parent:Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
            //   898: ldc             3
            //   900: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   903: aload_0        
            //   904: ldc             2
            //   906: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   909: invokespecial   instrumented/java/util/concurrent/ConcurrentHashMap$TreeBin.unlockRoot:()V
            //   912: ldc             1
            //   914: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   917: goto            944
            //   920: astore          15
            //   922: ldc             501
            //   924: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   927: aload_0        
            //   928: ldc             2
            //   930: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   933: invokespecial   instrumented/java/util/concurrent/ConcurrentHashMap$TreeBin.unlockRoot:()V
            //   936: aload           15
            //   938: ldc             2
            //   940: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   943: athrow         
            //   944: getstatic       instrumented/java/util/concurrent/ConcurrentHashMap$TreeBin.$assertionsDisabled:Z
            //   947: ldc             2
            //   949: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   952: ifne            993
            //   955: aload_0        
            //   956: getfield        instrumented/java/util/concurrent/ConcurrentHashMap$TreeBin.root:Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;
            //   959: ldc             3
            //   961: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   964: invokestatic    instrumented/java/util/concurrent/ConcurrentHashMap$TreeBin.checkInvariants:(Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode;)Z
            //   967: ldc             1
            //   969: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   972: ifne            993
            //   975: new             Ljava/lang/AssertionError;
            //   978: dup            
            //   979: ldc             3
            //   981: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   984: invokespecial   java/lang/AssertionError.<init>:()V
            //   987: ldc             1
            //   989: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   992: athrow         
            //   993: iconst_0       
            //   994: ldc             2
            //   996: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   999: ireturn        
            //  1000: athrow         
            //  1001: athrow         
            //    Signature:
            //  (Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeNode<TK;TV;>;)Z
            //    StackMapTable: 00 25 FD 00 2D 07 00 0C 07 00 0C 09 12 1C FC 00 38 07 00 0C FC 00 06 07 00 0C FF 00 3B 00 0A 07 00 02 07 00 0C 07 00 0C 07 00 0C 07 00 0C 07 00 0C 00 07 00 0C 07 00 0C 07 00 0C 00 00 FC 00 1B 07 00 0C FE 00 56 01 07 00 0C 07 00 0C FC 00 37 07 00 0C 0A FA 00 1B 23 1B 1B 1C 0B 15 FF 00 07 00 09 07 00 02 07 00 0C 07 00 0C 07 00 0C 07 00 0C 07 00 0C 07 00 0C 07 00 0C 07 00 0C 00 00 FF 00 07 00 09 07 00 02 07 00 0C 07 00 0C 07 00 0C 07 00 0C 07 00 0C 00 07 00 0C 07 00 0C 00 00 15 15 FF 00 07 00 09 07 00 02 07 00 0C 07 00 0C 07 00 0C 07 00 0C 07 00 0C 07 00 0C 07 00 0C 07 00 0C 00 00 FC 00 31 07 00 0C 1C 0B FA 00 13 56 07 00 02 FF 00 0B 00 09 07 00 02 07 00 0C 07 00 0C 07 00 0C 07 00 0C 07 00 0C 07 00 0C 07 00 0C 07 00 0C 00 02 07 00 02 07 00 0C FC 00 3D 07 00 0C 18 FF 00 09 00 06 07 00 02 07 00 0C 07 00 0C 07 00 0C 07 00 0C 07 00 0C 00 00 50 07 00 44 17 30 FF 00 06 00 00 00 01 07 00 44 FF 00 00 00 00 00 01 07 00 A3
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                           
            //  -----  -----  -----  -----  -------------------------------
            //  176    1001   1001   1002   Ljava/lang/VirtualMachineError;
            //  176    903    920    944    Any
            //  920    927    920    944    Any
            //  0      1000   1000   1001   Any
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0227:
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
                    Node<K, V> node;
                    final TreeNode<K, V> treeNode3 = (TreeNode<K, V>)(node = treeNode2.parent);
                    BytecodeManager.incBytecodes(5);
                    if (treeNode3 == null) {
                        treeNode2.red = false;
                        BytecodeManager.incBytecodes(3);
                        final TreeNode treeNode4 = treeNode2;
                        BytecodeManager.incBytecodes(2);
                        return (TreeNode<K, V>)treeNode4;
                    }
                    final boolean red = ((TreeNode)node).red;
                    BytecodeManager.incBytecodes(3);
                    if (!red) {
                        break;
                    }
                    Object parent;
                    final TreeNode<K, V> treeNode5 = (TreeNode<K, V>)(parent = ((TreeNode)node).parent);
                    BytecodeManager.incBytecodes(5);
                    if (treeNode5 == null) {
                        break;
                    }
                    final TreeNode treeNode6 = (TreeNode)node;
                    final Node<K, V> left;
                    final TreeNode<K, V> treeNode7 = (TreeNode<K, V>)(left = ((TreeNode)parent).left);
                    BytecodeManager.incBytecodes(6);
                    if (treeNode6 == treeNode7) {
                        final Node<K, V> right;
                        final TreeNode<K, V> treeNode8 = (TreeNode<K, V>)(right = ((TreeNode)parent).right);
                        BytecodeManager.incBytecodes(5);
                        if (treeNode8 != null) {
                            final boolean red2 = ((TreeNode)right).red;
                            BytecodeManager.incBytecodes(3);
                            if (red2) {
                                ((TreeNode)right).red = false;
                                BytecodeManager.incBytecodes(3);
                                ((TreeNode)node).red = false;
                                BytecodeManager.incBytecodes(3);
                                ((TreeNode)parent).red = true;
                                BytecodeManager.incBytecodes(3);
                                treeNode2 = (TreeNode)parent;
                                BytecodeManager.incBytecodes(3);
                                continue;
                            }
                        }
                        final TreeNode<K, V> treeNode9 = (TreeNode<K, V>)treeNode2;
                        final TreeNode<K, V> right2 = ((TreeNode)node).right;
                        BytecodeManager.incBytecodes(4);
                        if (treeNode9 == right2) {
                            final TreeNode<Object, Object> treeNode10 = treeNode;
                            final TreeNode<K, V> treeNode11 = (TreeNode<K, V>)(treeNode2 = (TreeNode)node);
                            BytecodeManager.incBytecodes(5);
                            treeNode = rotateLeft(treeNode10, (TreeNode<Object, Object>)treeNode11);
                            BytecodeManager.incBytecodes(1);
                            final TreeNode<K, V> treeNode12 = (TreeNode<K, V>)(node = treeNode2.parent);
                            BytecodeManager.incBytecodes(5);
                            TreeNode<K, V> parent2;
                            if (treeNode12 == null) {
                                parent2 = null;
                                BytecodeManager.incBytecodes(2);
                            }
                            else {
                                parent2 = (TreeNode<K, V>)((TreeNode)node).parent;
                                BytecodeManager.incBytecodes(2);
                            }
                            parent = parent2;
                            BytecodeManager.incBytecodes(1);
                        }
                        final TreeNode treeNode13 = (TreeNode)node;
                        BytecodeManager.incBytecodes(2);
                        if (treeNode13 == null) {
                            continue;
                        }
                        ((TreeNode)node).red = false;
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
                        final Node<K, V> node2 = left;
                        BytecodeManager.incBytecodes(2);
                        if (node2 != null) {
                            final boolean red3 = ((TreeNode)left).red;
                            BytecodeManager.incBytecodes(3);
                            if (red3) {
                                ((TreeNode)left).red = false;
                                BytecodeManager.incBytecodes(3);
                                ((TreeNode)node).red = false;
                                BytecodeManager.incBytecodes(3);
                                ((TreeNode)parent).red = true;
                                BytecodeManager.incBytecodes(3);
                                treeNode2 = (TreeNode)parent;
                                BytecodeManager.incBytecodes(3);
                                continue;
                            }
                        }
                        final TreeNode<K, V> treeNode17 = (TreeNode<K, V>)treeNode2;
                        final TreeNode<K, V> left2 = ((TreeNode)node).left;
                        BytecodeManager.incBytecodes(4);
                        if (treeNode17 == left2) {
                            final TreeNode<Object, Object> treeNode18 = treeNode;
                            final TreeNode<K, V> treeNode19 = (TreeNode<K, V>)(treeNode2 = (TreeNode)node);
                            BytecodeManager.incBytecodes(5);
                            treeNode = rotateRight(treeNode18, (TreeNode<Object, Object>)treeNode19);
                            BytecodeManager.incBytecodes(1);
                            final TreeNode<K, V> treeNode20 = (TreeNode<K, V>)(node = treeNode2.parent);
                            BytecodeManager.incBytecodes(5);
                            TreeNode<K, V> parent3;
                            if (treeNode20 == null) {
                                parent3 = null;
                                BytecodeManager.incBytecodes(2);
                            }
                            else {
                                parent3 = (TreeNode<K, V>)((TreeNode)node).parent;
                                BytecodeManager.incBytecodes(2);
                            }
                            parent = parent3;
                            BytecodeManager.incBytecodes(1);
                        }
                        final TreeNode treeNode21 = (TreeNode)node;
                        BytecodeManager.incBytecodes(2);
                        if (treeNode21 == null) {
                            continue;
                        }
                        ((TreeNode)node).red = false;
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
        
        static <K, V> TreeNode<K, V> balanceDeletion(TreeNode<K, V> node, TreeNode<K, V> treeNode) {
            try {
                Block_3: {
                    Block_2: {
                        while (true) {
                            final TreeNode<K, V> treeNode2 = treeNode;
                            BytecodeManager.incBytecodes(2);
                            if (treeNode2 == null) {
                                break;
                            }
                            final TreeNode<K, V> treeNode3 = treeNode;
                            final Node<K, V> node2 = node;
                            BytecodeManager.incBytecodes(3);
                            if (treeNode3 == node2) {
                                break;
                            }
                            TreeNode<K, V> treeNode5;
                            final TreeNode<K, V> treeNode4 = treeNode5 = treeNode.parent;
                            BytecodeManager.incBytecodes(5);
                            if (treeNode4 == null) {
                                break Block_2;
                            }
                            final boolean red = treeNode.red;
                            BytecodeManager.incBytecodes(3);
                            if (red) {
                                break Block_3;
                            }
                            TreeNode<K, V> left;
                            final TreeNode<K, V> treeNode6 = left = treeNode5.left;
                            final TreeNode<K, V> treeNode7 = treeNode;
                            BytecodeManager.incBytecodes(6);
                            if (treeNode6 == treeNode7) {
                                TreeNode<K, V> right;
                                final TreeNode<K, V> treeNode8 = right = treeNode5.right;
                                BytecodeManager.incBytecodes(5);
                                if (treeNode8 != null) {
                                    final boolean red2 = right.red;
                                    BytecodeManager.incBytecodes(3);
                                    if (red2) {
                                        right.red = false;
                                        BytecodeManager.incBytecodes(3);
                                        treeNode5.red = true;
                                        BytecodeManager.incBytecodes(3);
                                        final Node<K, V> node3 = node;
                                        final TreeNode<K, V> treeNode9 = treeNode5;
                                        BytecodeManager.incBytecodes(3);
                                        node = rotateLeft((TreeNode<K, V>)node3, (TreeNode<K, V>)treeNode9);
                                        BytecodeManager.incBytecodes(1);
                                        final TreeNode<K, V> treeNode10 = treeNode5 = treeNode.parent;
                                        BytecodeManager.incBytecodes(5);
                                        TreeNode<K, V> right2;
                                        if (treeNode10 == null) {
                                            right2 = null;
                                            BytecodeManager.incBytecodes(2);
                                        }
                                        else {
                                            right2 = treeNode5.right;
                                            BytecodeManager.incBytecodes(2);
                                        }
                                        right = right2;
                                        BytecodeManager.incBytecodes(1);
                                    }
                                }
                                final TreeNode<K, V> treeNode11 = right;
                                BytecodeManager.incBytecodes(2);
                                if (treeNode11 == null) {
                                    treeNode = treeNode5;
                                    BytecodeManager.incBytecodes(3);
                                }
                                else {
                                    final TreeNode<K, V> left2 = right.left;
                                    final TreeNode<K, V> right3 = right.right;
                                    BytecodeManager.incBytecodes(6);
                                    final TreeNode<K, V> treeNode12 = right3;
                                    BytecodeManager.incBytecodes(2);
                                    Label_0538: {
                                        Label_0311: {
                                            if (treeNode12 != null) {
                                                final boolean red3 = right3.red;
                                                BytecodeManager.incBytecodes(3);
                                                if (red3) {
                                                    break Label_0311;
                                                }
                                            }
                                            final TreeNode<K, V> treeNode13 = left2;
                                            BytecodeManager.incBytecodes(2);
                                            if (treeNode13 != null) {
                                                final boolean red4 = left2.red;
                                                BytecodeManager.incBytecodes(3);
                                                if (red4) {
                                                    break Label_0311;
                                                }
                                            }
                                            right.red = true;
                                            BytecodeManager.incBytecodes(3);
                                            treeNode = treeNode5;
                                            BytecodeManager.incBytecodes(3);
                                            break Label_0538;
                                        }
                                        final TreeNode<K, V> treeNode14 = right3;
                                        BytecodeManager.incBytecodes(2);
                                        Label_0422: {
                                            if (treeNode14 != null) {
                                                final boolean red5 = right3.red;
                                                BytecodeManager.incBytecodes(3);
                                                if (red5) {
                                                    break Label_0422;
                                                }
                                            }
                                            final TreeNode<K, V> treeNode15 = left2;
                                            BytecodeManager.incBytecodes(2);
                                            if (treeNode15 != null) {
                                                left2.red = false;
                                                BytecodeManager.incBytecodes(3);
                                            }
                                            right.red = true;
                                            BytecodeManager.incBytecodes(3);
                                            final Node<K, V> node4 = node;
                                            final TreeNode<K, V> treeNode16 = right;
                                            BytecodeManager.incBytecodes(3);
                                            node = rotateRight((TreeNode<K, V>)node4, (TreeNode<K, V>)treeNode16);
                                            BytecodeManager.incBytecodes(1);
                                            final TreeNode<K, V> treeNode17 = treeNode5 = treeNode.parent;
                                            BytecodeManager.incBytecodes(5);
                                            TreeNode<K, V> right4;
                                            if (treeNode17 == null) {
                                                right4 = null;
                                                BytecodeManager.incBytecodes(2);
                                            }
                                            else {
                                                right4 = treeNode5.right;
                                                BytecodeManager.incBytecodes(2);
                                            }
                                            right = right4;
                                            BytecodeManager.incBytecodes(1);
                                        }
                                        final TreeNode<K, V> treeNode18 = right;
                                        BytecodeManager.incBytecodes(2);
                                        if (treeNode18 != null) {
                                            final TreeNode<K, V> treeNode19 = right;
                                            final TreeNode<K, V> treeNode20 = treeNode5;
                                            BytecodeManager.incBytecodes(3);
                                            boolean red6;
                                            if (treeNode20 == null) {
                                                red6 = false;
                                                BytecodeManager.incBytecodes(2);
                                            }
                                            else {
                                                red6 = treeNode5.red;
                                                BytecodeManager.incBytecodes(2);
                                            }
                                            treeNode19.red = red6;
                                            BytecodeManager.incBytecodes(1);
                                            final TreeNode<K, V> right5 = right.right;
                                            BytecodeManager.incBytecodes(5);
                                            if (right5 != null) {
                                                right5.red = false;
                                                BytecodeManager.incBytecodes(3);
                                            }
                                        }
                                        final TreeNode<K, V> treeNode21 = treeNode5;
                                        BytecodeManager.incBytecodes(2);
                                        if (treeNode21 != null) {
                                            treeNode5.red = false;
                                            BytecodeManager.incBytecodes(3);
                                            final Node<K, V> node5 = node;
                                            final TreeNode<K, V> treeNode22 = treeNode5;
                                            BytecodeManager.incBytecodes(3);
                                            node = rotateLeft((TreeNode<K, V>)node5, (TreeNode<K, V>)treeNode22);
                                            BytecodeManager.incBytecodes(1);
                                        }
                                        treeNode = (TreeNode<K, V>)node;
                                        BytecodeManager.incBytecodes(2);
                                    }
                                    BytecodeManager.incBytecodes(1);
                                }
                            }
                            else {
                                final TreeNode<K, V> treeNode23 = left;
                                BytecodeManager.incBytecodes(2);
                                if (treeNode23 != null) {
                                    final boolean red7 = left.red;
                                    BytecodeManager.incBytecodes(3);
                                    if (red7) {
                                        left.red = false;
                                        BytecodeManager.incBytecodes(3);
                                        treeNode5.red = true;
                                        BytecodeManager.incBytecodes(3);
                                        final Node<K, V> node6 = node;
                                        final TreeNode<K, V> treeNode24 = treeNode5;
                                        BytecodeManager.incBytecodes(3);
                                        node = rotateRight((TreeNode<K, V>)node6, (TreeNode<K, V>)treeNode24);
                                        BytecodeManager.incBytecodes(1);
                                        final TreeNode<K, V> treeNode25 = treeNode5 = treeNode.parent;
                                        BytecodeManager.incBytecodes(5);
                                        TreeNode<K, V> left3;
                                        if (treeNode25 == null) {
                                            left3 = null;
                                            BytecodeManager.incBytecodes(2);
                                        }
                                        else {
                                            left3 = treeNode5.left;
                                            BytecodeManager.incBytecodes(2);
                                        }
                                        left = left3;
                                        BytecodeManager.incBytecodes(1);
                                    }
                                }
                                final TreeNode<K, V> treeNode26 = left;
                                BytecodeManager.incBytecodes(2);
                                if (treeNode26 == null) {
                                    treeNode = treeNode5;
                                    BytecodeManager.incBytecodes(3);
                                }
                                else {
                                    final TreeNode<K, V> left4 = left.left;
                                    final TreeNode<K, V> right6 = left.right;
                                    BytecodeManager.incBytecodes(6);
                                    final TreeNode<K, V> treeNode27 = left4;
                                    BytecodeManager.incBytecodes(2);
                                    Label_0964: {
                                        Label_0743: {
                                            if (treeNode27 != null) {
                                                final boolean red8 = left4.red;
                                                BytecodeManager.incBytecodes(3);
                                                if (red8) {
                                                    break Label_0743;
                                                }
                                            }
                                            final TreeNode<K, V> treeNode28 = right6;
                                            BytecodeManager.incBytecodes(2);
                                            if (treeNode28 != null) {
                                                final boolean red9 = right6.red;
                                                BytecodeManager.incBytecodes(3);
                                                if (red9) {
                                                    break Label_0743;
                                                }
                                            }
                                            left.red = true;
                                            BytecodeManager.incBytecodes(3);
                                            treeNode = treeNode5;
                                            BytecodeManager.incBytecodes(3);
                                            break Label_0964;
                                        }
                                        final TreeNode<K, V> treeNode29 = left4;
                                        BytecodeManager.incBytecodes(2);
                                        Label_0851: {
                                            if (treeNode29 != null) {
                                                final boolean red10 = left4.red;
                                                BytecodeManager.incBytecodes(3);
                                                if (red10) {
                                                    break Label_0851;
                                                }
                                            }
                                            final TreeNode<K, V> treeNode30 = right6;
                                            BytecodeManager.incBytecodes(2);
                                            if (treeNode30 != null) {
                                                right6.red = false;
                                                BytecodeManager.incBytecodes(3);
                                            }
                                            left.red = true;
                                            BytecodeManager.incBytecodes(3);
                                            final Node<K, V> node7 = node;
                                            final TreeNode<K, V> treeNode31 = left;
                                            BytecodeManager.incBytecodes(3);
                                            node = rotateLeft((TreeNode<K, V>)node7, (TreeNode<K, V>)treeNode31);
                                            BytecodeManager.incBytecodes(1);
                                            final TreeNode<K, V> treeNode32 = treeNode5 = treeNode.parent;
                                            BytecodeManager.incBytecodes(5);
                                            TreeNode<K, V> left5;
                                            if (treeNode32 == null) {
                                                left5 = null;
                                                BytecodeManager.incBytecodes(2);
                                            }
                                            else {
                                                left5 = treeNode5.left;
                                                BytecodeManager.incBytecodes(2);
                                            }
                                            left = left5;
                                            BytecodeManager.incBytecodes(1);
                                        }
                                        final TreeNode<K, V> treeNode33 = left;
                                        BytecodeManager.incBytecodes(2);
                                        if (treeNode33 != null) {
                                            final TreeNode<K, V> treeNode34 = left;
                                            final TreeNode<K, V> treeNode35 = treeNode5;
                                            BytecodeManager.incBytecodes(3);
                                            boolean red11;
                                            if (treeNode35 == null) {
                                                red11 = false;
                                                BytecodeManager.incBytecodes(2);
                                            }
                                            else {
                                                red11 = treeNode5.red;
                                                BytecodeManager.incBytecodes(2);
                                            }
                                            treeNode34.red = red11;
                                            BytecodeManager.incBytecodes(1);
                                            final TreeNode<K, V> left6 = left.left;
                                            BytecodeManager.incBytecodes(5);
                                            if (left6 != null) {
                                                left6.red = false;
                                                BytecodeManager.incBytecodes(3);
                                            }
                                        }
                                        final TreeNode<K, V> treeNode36 = treeNode5;
                                        BytecodeManager.incBytecodes(2);
                                        if (treeNode36 != null) {
                                            treeNode5.red = false;
                                            BytecodeManager.incBytecodes(3);
                                            final Node<K, V> node8 = node;
                                            final TreeNode<K, V> treeNode37 = treeNode5;
                                            BytecodeManager.incBytecodes(3);
                                            node = rotateRight((TreeNode<K, V>)node8, (TreeNode<K, V>)treeNode37);
                                            BytecodeManager.incBytecodes(1);
                                        }
                                        treeNode = (TreeNode<K, V>)node;
                                        BytecodeManager.incBytecodes(2);
                                    }
                                    BytecodeManager.incBytecodes(1);
                                }
                            }
                        }
                        final Node<K, V> node9 = node;
                        BytecodeManager.incBytecodes(2);
                        return (TreeNode<K, V>)node9;
                    }
                    treeNode.red = false;
                    BytecodeManager.incBytecodes(3);
                    final TreeNode<K, V> treeNode38 = treeNode;
                    BytecodeManager.incBytecodes(2);
                    return treeNode38;
                }
                treeNode.red = false;
                BytecodeManager.incBytecodes(3);
                final Node<K, V> node10 = node;
                BytecodeManager.incBytecodes(2);
                return (TreeNode<K, V>)node10;
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
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     2: ldc             2
            //     4: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //     7: invokevirtual   java/lang/Class.desiredAssertionStatus:()Z
            //    10: ldc             1
            //    12: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    15: ifne            27
            //    18: iconst_1       
            //    19: ldc             2
            //    21: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    24: goto            33
            //    27: iconst_0       
            //    28: ldc             1
            //    30: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    33: putstatic       instrumented/java/util/concurrent/ConcurrentHashMap$TreeBin.$assertionsDisabled:Z
            //    36: ldc             1
            //    38: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    41: ldc             1
            //    43: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    46: invokestatic    sun/misc/Unsafe.getUnsafe:()Lsun/misc/Unsafe;
            //    49: putstatic       instrumented/java/util/concurrent/ConcurrentHashMap$TreeBin.U:Lsun/misc/Unsafe;
            //    52: ldc             1
            //    54: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    57: ldc             Linstrumented/java/util/concurrent/ConcurrentHashMap$TreeBin;.class
            //    59: astore_0       
            //    60: ldc             2
            //    62: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    65: getstatic       instrumented/java/util/concurrent/ConcurrentHashMap$TreeBin.U:Lsun/misc/Unsafe;
            //    68: aload_0        
            //    69: ldc             "lockState"
            //    71: ldc             3
            //    73: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    76: ldc             1
            //    78: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    81: invokevirtual   java/lang/Class.getDeclaredField:(Ljava/lang/String;)Ljava/lang/reflect/Field;
            //    84: ldc             1
            //    86: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    89: invokevirtual   sun/misc/Unsafe.objectFieldOffset:(Ljava/lang/reflect/Field;)J
            //    92: putstatic       instrumented/java/util/concurrent/ConcurrentHashMap$TreeBin.LOCKSTATE:J
            //    95: ldc             1
            //    97: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   100: ldc             1
            //   102: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   105: goto            133
            //   108: astore_0       
            //   109: ldc             501
            //   111: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   114: new             Ljava/lang/Error;
            //   117: dup            
            //   118: aload_0        
            //   119: ldc             4
            //   121: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   124: invokespecial   java/lang/Error.<init>:(Ljava/lang/Throwable;)V
            //   127: ldc             1
            //   129: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   132: athrow         
            //   133: ldc             1
            //   135: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   138: return         
            //   139: athrow         
            //   140: athrow         
            //    StackMapTable: 00 06 1B 45 01 F7 00 4A 07 00 D3 18 FF 00 05 00 00 00 01 07 00 44 FF 00 00 00 00 00 01 07 00 A3
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                           
            //  -----  -----  -----  -----  -------------------------------
            //  41     140    140    141    Ljava/lang/VirtualMachineError;
            //  41     100    108    133    Ljava/lang/Exception;
            //  0      139    139    140    Any
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0133:
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
    
    static final class TableStack<K, V>
    {
        int length;
        int index;
        Node<K, V>[] tab;
        TableStack<K, V> next;
        
        TableStack() {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static class Traverser<K, V>
    {
        Node<K, V>[] tab;
        Node<K, V> next;
        TableStack<K, V> stack;
        TableStack<K, V> spare;
        int index;
        int baseIndex;
        int baseLimit;
        final int baseSize;
        
        Traverser(final Node<K, V>[] tab, final int baseSize, final int n, final int baseLimit) {
            try {
                BytecodeManager.incBytecodes(2);
                this.tab = tab;
                BytecodeManager.incBytecodes(3);
                this.baseSize = baseSize;
                BytecodeManager.incBytecodes(3);
                this.index = n;
                this.baseIndex = n;
                BytecodeManager.incBytecodes(6);
                this.baseLimit = baseLimit;
                BytecodeManager.incBytecodes(3);
                this.next = null;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        final Node<K, V> advance() {
            try {
                Object o;
                final Node<K, V> node = (Node<K, V>)(o = this.next);
                BytecodeManager.incBytecodes(5);
                if (node != null) {
                    o = ((Node)o).next;
                    BytecodeManager.incBytecodes(3);
                }
                while (true) {
                    final Node node2 = (Node)o;
                    BytecodeManager.incBytecodes(2);
                    if (node2 != null) {
                        final Node next = (Node)o;
                        this.next = (Node<K, V>)next;
                        BytecodeManager.incBytecodes(5);
                        return (Node<K, V>)next;
                    }
                    final int baseIndex = this.baseIndex;
                    final int baseLimit = this.baseLimit;
                    BytecodeManager.incBytecodes(5);
                    if (baseIndex >= baseLimit) {
                        break;
                    }
                    final Node<K, V>[] tab;
                    final Node<K, V>[] array = tab = this.tab;
                    BytecodeManager.incBytecodes(5);
                    if (array == null) {
                        break;
                    }
                    final int length;
                    final int n = length = tab.length;
                    final int index;
                    final int n2 = index = this.index;
                    BytecodeManager.incBytecodes(9);
                    if (n <= n2) {
                        break;
                    }
                    final int n3 = index;
                    BytecodeManager.incBytecodes(2);
                    if (n3 < 0) {
                        break;
                    }
                    final Node<K, V>[] array2 = tab;
                    final int n4 = index;
                    BytecodeManager.incBytecodes(3);
                    final Node<K, V> node3 = (Node<K, V>)(o = ConcurrentHashMap.tabAt(array2, n4));
                    BytecodeManager.incBytecodes(3);
                    if (node3 != null) {
                        final int hash = ((Node)o).hash;
                        BytecodeManager.incBytecodes(3);
                        if (hash < 0) {
                            final boolean b = o instanceof ForwardingNode;
                            BytecodeManager.incBytecodes(3);
                            if (b) {
                                this.tab = (Node<K, V>[])((ForwardingNode)o).nextTable;
                                BytecodeManager.incBytecodes(5);
                                o = null;
                                BytecodeManager.incBytecodes(2);
                                final Node<K, V>[] array3 = tab;
                                final int n5 = index;
                                final int n6 = length;
                                BytecodeManager.incBytecodes(5);
                                this.pushState(array3, n5, n6);
                                BytecodeManager.incBytecodes(1);
                                continue;
                            }
                            final boolean b2 = o instanceof TreeBin;
                            BytecodeManager.incBytecodes(3);
                            if (b2) {
                                o = ((TreeBin)o).first;
                                BytecodeManager.incBytecodes(5);
                            }
                            else {
                                o = null;
                                BytecodeManager.incBytecodes(2);
                            }
                        }
                    }
                    final TableStack<K, V> stack = this.stack;
                    BytecodeManager.incBytecodes(3);
                    if (stack != null) {
                        final int n7 = length;
                        BytecodeManager.incBytecodes(3);
                        this.recoverState(n7);
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        final int index2 = index + this.baseSize;
                        this.index = index2;
                        final int n8 = length;
                        BytecodeManager.incBytecodes(9);
                        if (index2 >= n8) {
                            this.index = ++this.baseIndex;
                            BytecodeManager.incBytecodes(9);
                        }
                    }
                    BytecodeManager.incBytecodes(1);
                }
                final Node<K, V> next2 = null;
                this.next = next2;
                BytecodeManager.incBytecodes(5);
                return next2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private void pushState(final Node<K, V>[] tab, final int index, final int length) {
            try {
                TableStack<K, V> spare = this.spare;
                BytecodeManager.incBytecodes(3);
                final TableStack<K, V> tableStack = spare;
                BytecodeManager.incBytecodes(2);
                if (tableStack != null) {
                    this.spare = spare.next;
                    BytecodeManager.incBytecodes(5);
                }
                else {
                    BytecodeManager.incBytecodes(3);
                    spare = new TableStack<K, V>();
                    BytecodeManager.incBytecodes(1);
                }
                spare.tab = tab;
                BytecodeManager.incBytecodes(3);
                spare.length = length;
                BytecodeManager.incBytecodes(3);
                spare.index = index;
                BytecodeManager.incBytecodes(3);
                spare.next = this.stack;
                BytecodeManager.incBytecodes(4);
                this.stack = spare;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private void recoverState(int n) {
            try {
                TableStack<K, V> stack;
                while (true) {
                    final TableStack<K, V> tableStack = stack = this.stack;
                    BytecodeManager.incBytecodes(5);
                    if (tableStack == null) {
                        break;
                    }
                    final int length;
                    final int index = this.index + (length = stack.length);
                    this.index = index;
                    final int n2 = n;
                    BytecodeManager.incBytecodes(12);
                    if (index < n2) {
                        break;
                    }
                    n = length;
                    BytecodeManager.incBytecodes(2);
                    this.index = stack.index;
                    BytecodeManager.incBytecodes(4);
                    this.tab = stack.tab;
                    BytecodeManager.incBytecodes(4);
                    stack.tab = null;
                    BytecodeManager.incBytecodes(3);
                    final TableStack<K, V> next = stack.next;
                    BytecodeManager.incBytecodes(3);
                    stack.next = this.spare;
                    BytecodeManager.incBytecodes(4);
                    this.stack = next;
                    BytecodeManager.incBytecodes(3);
                    this.spare = stack;
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(1);
                }
                final TableStack<K, V> tableStack2 = stack;
                BytecodeManager.incBytecodes(2);
                if (tableStack2 == null) {
                    final int index2 = this.index + this.baseSize;
                    this.index = index2;
                    final int n3 = n;
                    BytecodeManager.incBytecodes(10);
                    if (index2 >= n3) {
                        this.index = ++this.baseIndex;
                        BytecodeManager.incBytecodes(9);
                    }
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static class BaseIterator<K, V> extends Traverser<K, V>
    {
        final ConcurrentHashMap<K, V> map;
        Node<K, V> lastReturned;
        
        BaseIterator(final Node<K, V>[] array, final int n, final int n2, final int n3, final ConcurrentHashMap<K, V> map) {
            try {
                BytecodeManager.incBytecodes(6);
                super(array, n, n2, n3);
                this.map = map;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(2);
                this.advance();
                BytecodeManager.incBytecodes(1);
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
        
        public final boolean hasMoreElements() {
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
        
        public final void remove() {
            try {
                final Node<K, V> lastReturned = this.lastReturned;
                BytecodeManager.incBytecodes(5);
                if (lastReturned == null) {
                    BytecodeManager.incBytecodes(3);
                    final IllegalStateException ex = new IllegalStateException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                this.lastReturned = null;
                BytecodeManager.incBytecodes(3);
                final ConcurrentHashMap<K, V> map = this.map;
                final K key = lastReturned.key;
                final V v = null;
                final Object o = null;
                BytecodeManager.incBytecodes(7);
                map.replaceNode(key, v, o);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class KeyIterator<K, V> extends BaseIterator<K, V> implements Iterator<K>, Enumeration<K>
    {
        KeyIterator(final Node<K, V>[] array, final int n, final int n2, final int n3, final ConcurrentHashMap<K, V> concurrentHashMap) {
            try {
                BytecodeManager.incBytecodes(7);
                super(array, n, n2, n3, concurrentHashMap);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final K next() {
            try {
                final Node<K, V> next;
                final Node<K, V> node = next = this.next;
                BytecodeManager.incBytecodes(5);
                if (node == null) {
                    BytecodeManager.incBytecodes(3);
                    final NoSuchElementException ex = new NoSuchElementException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final K key = next.key;
                BytecodeManager.incBytecodes(3);
                this.lastReturned = next;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(2);
                this.advance();
                BytecodeManager.incBytecodes(1);
                final K k = key;
                BytecodeManager.incBytecodes(2);
                return k;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final K nextElement() {
            try {
                BytecodeManager.incBytecodes(2);
                final K next = this.next();
                BytecodeManager.incBytecodes(1);
                return next;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class ValueIterator<K, V> extends BaseIterator<K, V> implements Iterator<V>, Enumeration<V>
    {
        ValueIterator(final Node<K, V>[] array, final int n, final int n2, final int n3, final ConcurrentHashMap<K, V> concurrentHashMap) {
            try {
                BytecodeManager.incBytecodes(7);
                super(array, n, n2, n3, concurrentHashMap);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final V next() {
            try {
                final Node<K, V> next;
                final Node<K, V> node = next = this.next;
                BytecodeManager.incBytecodes(5);
                if (node == null) {
                    BytecodeManager.incBytecodes(3);
                    final NoSuchElementException ex = new NoSuchElementException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final V val = next.val;
                BytecodeManager.incBytecodes(3);
                this.lastReturned = next;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(2);
                this.advance();
                BytecodeManager.incBytecodes(1);
                final V v = val;
                BytecodeManager.incBytecodes(2);
                return v;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final V nextElement() {
            try {
                BytecodeManager.incBytecodes(2);
                final V next = this.next();
                BytecodeManager.incBytecodes(1);
                return next;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class EntryIterator<K, V> extends BaseIterator<K, V> implements Iterator<Map.Entry<K, V>>
    {
        EntryIterator(final Node<K, V>[] array, final int n, final int n2, final int n3, final ConcurrentHashMap<K, V> concurrentHashMap) {
            try {
                BytecodeManager.incBytecodes(7);
                super(array, n, n2, n3, concurrentHashMap);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final Map.Entry<K, V> next() {
            try {
                final Node<K, V> next;
                final Node<K, V> node = next = this.next;
                BytecodeManager.incBytecodes(5);
                if (node == null) {
                    BytecodeManager.incBytecodes(3);
                    final NoSuchElementException ex = new NoSuchElementException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final K key = next.key;
                BytecodeManager.incBytecodes(3);
                final V val = next.val;
                BytecodeManager.incBytecodes(3);
                this.lastReturned = next;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(2);
                this.advance();
                BytecodeManager.incBytecodes(1);
                final K k = key;
                final V v = val;
                final ConcurrentHashMap<K, V> map = this.map;
                BytecodeManager.incBytecodes(7);
                final MapEntry mapEntry = new MapEntry<K, V>(k, v, (ConcurrentHashMap<Object, Object>)map);
                BytecodeManager.incBytecodes(1);
                return (Map.Entry<K, V>)mapEntry;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class MapEntry<K, V> implements Map.Entry<K, V>
    {
        final K key;
        V val;
        final ConcurrentHashMap<K, V> map;
        
        MapEntry(final K key, final V val, final ConcurrentHashMap<K, V> map) {
            try {
                BytecodeManager.incBytecodes(2);
                this.key = key;
                BytecodeManager.incBytecodes(3);
                this.val = val;
                BytecodeManager.incBytecodes(3);
                this.map = map;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public K getKey() {
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
        public V getValue() {
            try {
                final V val = this.val;
                BytecodeManager.incBytecodes(3);
                return val;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int hashCode() {
            try {
                final K key = this.key;
                BytecodeManager.incBytecodes(3);
                final int hashCode = key.hashCode();
                final V val = this.val;
                BytecodeManager.incBytecodes(3);
                final int n = hashCode ^ val.hashCode();
                BytecodeManager.incBytecodes(2);
                return n;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public String toString() {
            try {
                BytecodeManager.incBytecodes(3);
                final StringBuilder sb = new StringBuilder();
                final K key = this.key;
                BytecodeManager.incBytecodes(3);
                final StringBuilder append = sb.append(key);
                final String str = "=";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append2 = append.append(str);
                final V val = this.val;
                BytecodeManager.incBytecodes(3);
                final StringBuilder append3 = append2.append(val);
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
        public boolean equals(final Object o) {
            try {
                final boolean b = o instanceof Map.Entry;
                BytecodeManager.incBytecodes(3);
                boolean b2 = false;
                Label_0164: {
                    Label_0158: {
                        if (b) {
                            final Map.Entry entry = (Map.Entry)o;
                            BytecodeManager.incBytecodes(4);
                            BytecodeManager.incBytecodes(1);
                            final K key;
                            final K k = key = entry.getKey();
                            BytecodeManager.incBytecodes(3);
                            if (k != null) {
                                final Map.Entry<K, Object> entry2 = (Map.Entry<K, Object>)entry;
                                BytecodeManager.incBytecodes(1);
                                BytecodeManager.incBytecodes(1);
                                final Object value;
                                final Object o2 = value = entry2.getValue();
                                BytecodeManager.incBytecodes(3);
                                if (o2 != null) {
                                    final K i = key;
                                    final K key2 = this.key;
                                    BytecodeManager.incBytecodes(4);
                                    if (i != key2) {
                                        final K j = key;
                                        final K key3 = this.key;
                                        BytecodeManager.incBytecodes(3);
                                        BytecodeManager.incBytecodes(1);
                                        final boolean equals = j.equals(key3);
                                        BytecodeManager.incBytecodes(1);
                                        if (!equals) {
                                            break Label_0158;
                                        }
                                    }
                                    final Object o3 = value;
                                    final V val = this.val;
                                    BytecodeManager.incBytecodes(4);
                                    if (o3 != val) {
                                        final V v = (V)value;
                                        final V val2 = this.val;
                                        BytecodeManager.incBytecodes(3);
                                        BytecodeManager.incBytecodes(1);
                                        final boolean equals2 = v.equals(val2);
                                        BytecodeManager.incBytecodes(1);
                                        if (!equals2) {
                                            break Label_0158;
                                        }
                                    }
                                    b2 = true;
                                    BytecodeManager.incBytecodes(2);
                                    break Label_0164;
                                }
                            }
                        }
                    }
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
        public V setValue(final V val) {
            try {
                BytecodeManager.incBytecodes(2);
                if (val == null) {
                    BytecodeManager.incBytecodes(3);
                    final NullPointerException ex = new NullPointerException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final V val2 = this.val;
                BytecodeManager.incBytecodes(3);
                this.val = val;
                BytecodeManager.incBytecodes(3);
                final ConcurrentHashMap<K, V> map = this.map;
                final K key = this.key;
                BytecodeManager.incBytecodes(6);
                map.put(key, val);
                BytecodeManager.incBytecodes(1);
                final V v = val2;
                BytecodeManager.incBytecodes(2);
                return v;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class KeySpliterator<K, V> extends Traverser<K, V> implements Spliterator<K>
    {
        long est;
        
        KeySpliterator(final Node<K, V>[] array, final int n, final int n2, final int n3, final long est) {
            try {
                BytecodeManager.incBytecodes(6);
                super(array, n, n2, n3);
                this.est = est;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Spliterator<K> trySplit() {
            try {
                final int baseIndex = this.baseIndex;
                final int baseLimit;
                final int n = baseIndex + (baseLimit = this.baseLimit) >>> 1;
                final int n2 = baseIndex;
                BytecodeManager.incBytecodes(15);
                Spliterator<K> spliterator;
                if (n <= n2) {
                    spliterator = null;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final Node<K, V>[] tab;
                    final int baseSize;
                    final int baseLimit2;
                    final int n3;
                    final long est;
                    spliterator = new KeySpliterator<K, Object>((Node<Object, Object>[])tab, baseSize, baseLimit2, n3, est);
                    tab = this.tab;
                    baseSize = this.baseSize;
                    baseLimit2 = n;
                    this.baseLimit = baseLimit2;
                    n3 = baseLimit;
                    est = this.est >>> 1;
                    this.est = est;
                    BytecodeManager.incBytecodes(19);
                }
                BytecodeManager.incBytecodes(1);
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
                while (true) {
                    BytecodeManager.incBytecodes(2);
                    final Node<K, V> advance = this.advance();
                    BytecodeManager.incBytecodes(3);
                    if (advance == null) {
                        break;
                    }
                    final K key = advance.key;
                    BytecodeManager.incBytecodes(4);
                    consumer.accept(key);
                    BytecodeManager.incBytecodes(1);
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
                BytecodeManager.incBytecodes(2);
                final Node<K, V> advance = this.advance();
                BytecodeManager.incBytecodes(3);
                if (advance == null) {
                    final boolean b = false;
                    BytecodeManager.incBytecodes(2);
                    return b;
                }
                final K key = advance.key;
                BytecodeManager.incBytecodes(4);
                consumer.accept(key);
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
                final long est = this.est;
                BytecodeManager.incBytecodes(3);
                return est;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int characteristics() {
            try {
                final int n = 4353;
                BytecodeManager.incBytecodes(2);
                return n;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class ValueSpliterator<K, V> extends Traverser<K, V> implements Spliterator<V>
    {
        long est;
        
        ValueSpliterator(final Node<K, V>[] array, final int n, final int n2, final int n3, final long est) {
            try {
                BytecodeManager.incBytecodes(6);
                super(array, n, n2, n3);
                this.est = est;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Spliterator<V> trySplit() {
            try {
                final int baseIndex = this.baseIndex;
                final int baseLimit;
                final int n = baseIndex + (baseLimit = this.baseLimit) >>> 1;
                final int n2 = baseIndex;
                BytecodeManager.incBytecodes(15);
                Spliterator<V> spliterator;
                if (n <= n2) {
                    spliterator = null;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final Node<K, V>[] tab;
                    final int baseSize;
                    final int baseLimit2;
                    final int n3;
                    final long est;
                    spliterator = new ValueSpliterator<Object, V>((Node<Object, Object>[])tab, baseSize, baseLimit2, n3, est);
                    tab = this.tab;
                    baseSize = this.baseSize;
                    baseLimit2 = n;
                    this.baseLimit = baseLimit2;
                    n3 = baseLimit;
                    est = this.est >>> 1;
                    this.est = est;
                    BytecodeManager.incBytecodes(19);
                }
                BytecodeManager.incBytecodes(1);
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
                while (true) {
                    BytecodeManager.incBytecodes(2);
                    final Node<K, V> advance = this.advance();
                    BytecodeManager.incBytecodes(3);
                    if (advance == null) {
                        break;
                    }
                    final V val = advance.val;
                    BytecodeManager.incBytecodes(4);
                    consumer.accept(val);
                    BytecodeManager.incBytecodes(1);
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
                BytecodeManager.incBytecodes(2);
                final Node<K, V> advance = this.advance();
                BytecodeManager.incBytecodes(3);
                if (advance == null) {
                    final boolean b = false;
                    BytecodeManager.incBytecodes(2);
                    return b;
                }
                final V val = advance.val;
                BytecodeManager.incBytecodes(4);
                consumer.accept(val);
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
                final long est = this.est;
                BytecodeManager.incBytecodes(3);
                return est;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int characteristics() {
            try {
                final int n = 4352;
                BytecodeManager.incBytecodes(2);
                return n;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class EntrySpliterator<K, V> extends Traverser<K, V> implements Spliterator<Map.Entry<K, V>>
    {
        final ConcurrentHashMap<K, V> map;
        long est;
        
        EntrySpliterator(final Node<K, V>[] array, final int n, final int n2, final int n3, final long est, final ConcurrentHashMap<K, V> map) {
            try {
                BytecodeManager.incBytecodes(6);
                super(array, n, n2, n3);
                this.map = map;
                BytecodeManager.incBytecodes(3);
                this.est = est;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Spliterator<Map.Entry<K, V>> trySplit() {
            try {
                final int baseIndex = this.baseIndex;
                final int baseLimit;
                final int n = baseIndex + (baseLimit = this.baseLimit) >>> 1;
                final int n2 = baseIndex;
                BytecodeManager.incBytecodes(15);
                Object o;
                if (n <= n2) {
                    o = null;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final Node<K, V>[] tab;
                    final int baseSize;
                    final int baseLimit2;
                    final int n3;
                    final long est;
                    final ConcurrentHashMap<K, V> map;
                    o = new EntrySpliterator<Object, Object>((Node<Object, Object>[])tab, baseSize, baseLimit2, n3, est, (ConcurrentHashMap<Object, Object>)map);
                    tab = this.tab;
                    baseSize = this.baseSize;
                    baseLimit2 = n;
                    this.baseLimit = baseLimit2;
                    n3 = baseLimit;
                    est = this.est >>> 1;
                    this.est = est;
                    map = this.map;
                    BytecodeManager.incBytecodes(21);
                }
                BytecodeManager.incBytecodes(1);
                return (Spliterator<Map.Entry<K, V>>)o;
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
                while (true) {
                    BytecodeManager.incBytecodes(2);
                    final Node<K, V> advance;
                    final Node<K, V> node = advance = this.advance();
                    BytecodeManager.incBytecodes(3);
                    if (node == null) {
                        break;
                    }
                    final K key = advance.key;
                    final V val = advance.val;
                    final ConcurrentHashMap<K, V> map = this.map;
                    BytecodeManager.incBytecodes(10);
                    final MapEntry mapEntry = new MapEntry(key, val, (ConcurrentHashMap<Object, Object>)map);
                    BytecodeManager.incBytecodes(1);
                    consumer.accept((Object)mapEntry);
                    BytecodeManager.incBytecodes(1);
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
                BytecodeManager.incBytecodes(2);
                final Node<K, V> advance;
                final Node<K, V> node = advance = this.advance();
                BytecodeManager.incBytecodes(3);
                if (node == null) {
                    final boolean b = false;
                    BytecodeManager.incBytecodes(2);
                    return b;
                }
                final K key = advance.key;
                final V val = advance.val;
                final ConcurrentHashMap<K, V> map = this.map;
                BytecodeManager.incBytecodes(10);
                final MapEntry mapEntry = new MapEntry(key, val, (ConcurrentHashMap<Object, Object>)map);
                BytecodeManager.incBytecodes(1);
                consumer.accept((Object)mapEntry);
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
                final long est = this.est;
                BytecodeManager.incBytecodes(3);
                return est;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int characteristics() {
            try {
                final int n = 4353;
                BytecodeManager.incBytecodes(2);
                return n;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    abstract static class CollectionView<K, V, E> implements Collection<E>, Serializable
    {
        private static final long serialVersionUID = 7249069246763182397L;
        final ConcurrentHashMap<K, V> map;
        private static final String oomeMsg = "Required array size too large";
        
        CollectionView(final ConcurrentHashMap<K, V> map) {
            try {
                BytecodeManager.incBytecodes(2);
                this.map = map;
                BytecodeManager.incBytecodes(4);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public ConcurrentHashMap<K, V> getMap() {
            try {
                final ConcurrentHashMap<K, V> map = this.map;
                BytecodeManager.incBytecodes(3);
                return map;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final void clear() {
            try {
                final ConcurrentHashMap<K, V> map = this.map;
                BytecodeManager.incBytecodes(3);
                map.clear();
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final int size() {
            try {
                final ConcurrentHashMap<K, V> map = this.map;
                BytecodeManager.incBytecodes(3);
                final int size = map.size();
                BytecodeManager.incBytecodes(1);
                return size;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final boolean isEmpty() {
            try {
                final ConcurrentHashMap<K, V> map = this.map;
                BytecodeManager.incBytecodes(3);
                final boolean empty = map.isEmpty();
                BytecodeManager.incBytecodes(1);
                return empty;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public abstract Iterator<E> iterator();
        
        @Override
        public abstract boolean contains(final Object p0);
        
        @Override
        public abstract boolean remove(final Object p0);
        
        @Override
        public final Object[] toArray() {
            try {
                final ConcurrentHashMap<K, V> map = this.map;
                BytecodeManager.incBytecodes(3);
                final long mappingCount = map.mappingCount();
                BytecodeManager.incBytecodes(1);
                final long n = lcmp(mappingCount, 2147483639L);
                BytecodeManager.incBytecodes(4);
                if (n > 0) {
                    final String s = "Required array size too large";
                    BytecodeManager.incBytecodes(4);
                    final OutOfMemoryError outOfMemoryError = new OutOfMemoryError(s);
                    BytecodeManager.incBytecodes(1);
                    throw outOfMemoryError;
                }
                int n2 = (int)mappingCount;
                BytecodeManager.incBytecodes(3);
                Object[] copy = new Object[n2];
                BytecodeManager.incBytecodes(2);
                int n3 = 0;
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(2);
                final Iterator<E> iterator = this.iterator();
                BytecodeManager.incBytecodes(1);
                while (true) {
                    final Iterator<E> iterator2 = iterator;
                    BytecodeManager.incBytecodes(2);
                    final boolean hasNext = iterator2.hasNext();
                    BytecodeManager.incBytecodes(1);
                    if (!hasNext) {
                        final int n4 = n3;
                        final int n5 = n2;
                        BytecodeManager.incBytecodes(3);
                        Object[] copy2;
                        if (n4 == n5) {
                            copy2 = copy;
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            final Object[] array = copy;
                            final int n6 = n3;
                            BytecodeManager.incBytecodes(3);
                            copy2 = Arrays.copyOf(array, n6);
                        }
                        BytecodeManager.incBytecodes(1);
                        return copy2;
                    }
                    final Iterator<E> iterator3 = iterator;
                    BytecodeManager.incBytecodes(2);
                    final E next = iterator3.next();
                    BytecodeManager.incBytecodes(1);
                    final int n7 = n3;
                    final int n8 = n2;
                    BytecodeManager.incBytecodes(3);
                    if (n7 == n8) {
                        final int n9 = n2;
                        final int n10 = 2147483639;
                        BytecodeManager.incBytecodes(3);
                        if (n9 >= n10) {
                            final String s2 = "Required array size too large";
                            BytecodeManager.incBytecodes(4);
                            final OutOfMemoryError outOfMemoryError2 = new OutOfMemoryError(s2);
                            BytecodeManager.incBytecodes(1);
                            throw outOfMemoryError2;
                        }
                        final int n11 = n2;
                        final int n12 = 1073741819;
                        BytecodeManager.incBytecodes(3);
                        if (n11 >= n12) {
                            n2 = 2147483639;
                            BytecodeManager.incBytecodes(3);
                        }
                        else {
                            n2 += (n2 >>> 1) + 1;
                            BytecodeManager.incBytecodes(8);
                        }
                        final Object[] array2 = copy;
                        final int n13 = n2;
                        BytecodeManager.incBytecodes(3);
                        copy = Arrays.copyOf(array2, n13);
                        BytecodeManager.incBytecodes(1);
                    }
                    copy[n3++] = next;
                    BytecodeManager.incBytecodes(5);
                    BytecodeManager.incBytecodes(1);
                }
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final <T> T[] toArray(final T[] array) {
            try {
                final ConcurrentHashMap<K, V> map = this.map;
                BytecodeManager.incBytecodes(3);
                final long mappingCount = map.mappingCount();
                BytecodeManager.incBytecodes(1);
                final long n = lcmp(mappingCount, 2147483639L);
                BytecodeManager.incBytecodes(4);
                if (n > 0) {
                    final String s = "Required array size too large";
                    BytecodeManager.incBytecodes(4);
                    final OutOfMemoryError outOfMemoryError = new OutOfMemoryError(s);
                    BytecodeManager.incBytecodes(1);
                    throw outOfMemoryError;
                }
                final int n2 = (int)mappingCount;
                BytecodeManager.incBytecodes(3);
                final int length = array.length;
                final int n3 = n2;
                BytecodeManager.incBytecodes(4);
                Object[] array2;
                if (length >= n3) {
                    array2 = array;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    final Class<? extends Object[]> class1 = array.getClass();
                    BytecodeManager.incBytecodes(1);
                    final Class<?> componentType = class1.getComponentType();
                    final int length2 = n2;
                    BytecodeManager.incBytecodes(2);
                    array2 = (Object[])Array.newInstance(componentType, length2);
                    BytecodeManager.incBytecodes(2);
                }
                T[] copy = (T[])array2;
                BytecodeManager.incBytecodes(1);
                int length3 = copy.length;
                BytecodeManager.incBytecodes(3);
                int n4 = 0;
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(2);
                final Iterator<E> iterator = this.iterator();
                BytecodeManager.incBytecodes(1);
                while (true) {
                    final Iterator<E> iterator2 = iterator;
                    BytecodeManager.incBytecodes(2);
                    final boolean hasNext = iterator2.hasNext();
                    BytecodeManager.incBytecodes(1);
                    if (!hasNext) {
                        final T[] array3 = copy;
                        BytecodeManager.incBytecodes(3);
                        if (array == array3) {
                            final int n5 = n4;
                            final int n6 = length3;
                            BytecodeManager.incBytecodes(3);
                            if (n5 < n6) {
                                copy[n4] = null;
                                BytecodeManager.incBytecodes(4);
                                final T[] array4 = copy;
                                BytecodeManager.incBytecodes(2);
                                return array4;
                            }
                        }
                        final int n7 = n4;
                        final int n8 = length3;
                        BytecodeManager.incBytecodes(3);
                        T[] copy2;
                        if (n7 == n8) {
                            copy2 = copy;
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            final T[] array5 = copy;
                            final int n9 = n4;
                            BytecodeManager.incBytecodes(3);
                            copy2 = Arrays.copyOf(array5, n9);
                        }
                        BytecodeManager.incBytecodes(1);
                        return copy2;
                    }
                    final Iterator<E> iterator3 = iterator;
                    BytecodeManager.incBytecodes(2);
                    final E next = iterator3.next();
                    BytecodeManager.incBytecodes(1);
                    final int n10 = n4;
                    final int n11 = length3;
                    BytecodeManager.incBytecodes(3);
                    if (n10 == n11) {
                        final int n12 = length3;
                        final int n13 = 2147483639;
                        BytecodeManager.incBytecodes(3);
                        if (n12 >= n13) {
                            final String s2 = "Required array size too large";
                            BytecodeManager.incBytecodes(4);
                            final OutOfMemoryError outOfMemoryError2 = new OutOfMemoryError(s2);
                            BytecodeManager.incBytecodes(1);
                            throw outOfMemoryError2;
                        }
                        final int n14 = length3;
                        final int n15 = 1073741819;
                        BytecodeManager.incBytecodes(3);
                        if (n14 >= n15) {
                            length3 = 2147483639;
                            BytecodeManager.incBytecodes(3);
                        }
                        else {
                            length3 += (length3 >>> 1) + 1;
                            BytecodeManager.incBytecodes(8);
                        }
                        final T[] array6 = copy;
                        final int n16 = length3;
                        BytecodeManager.incBytecodes(3);
                        copy = Arrays.copyOf(array6, n16);
                        BytecodeManager.incBytecodes(1);
                    }
                    copy[n4++] = (T)next;
                    BytecodeManager.incBytecodes(5);
                    BytecodeManager.incBytecodes(1);
                }
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
                BytecodeManager.incBytecodes(1);
                final StringBuilder sb2 = sb;
                final char c = '[';
                BytecodeManager.incBytecodes(3);
                sb2.append(c);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(2);
                final Iterator<E> iterator = this.iterator();
                BytecodeManager.incBytecodes(1);
                final Iterator<E> iterator2 = iterator;
                BytecodeManager.incBytecodes(2);
                final boolean hasNext = iterator2.hasNext();
                BytecodeManager.incBytecodes(1);
                if (hasNext) {
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
        
        @Override
        public final boolean containsAll(final Collection<?> collection) {
            try {
                BytecodeManager.incBytecodes(3);
                Label_0105: {
                    if (collection != this) {
                        BytecodeManager.incBytecodes(2);
                        final Iterator<Object> iterator = collection.iterator();
                        BytecodeManager.incBytecodes(1);
                        while (true) {
                            final Iterator<Object> iterator2 = iterator;
                            BytecodeManager.incBytecodes(2);
                            final boolean hasNext = iterator2.hasNext();
                            BytecodeManager.incBytecodes(1);
                            if (!hasNext) {
                                break Label_0105;
                            }
                            final Iterator<Object> iterator3 = iterator;
                            BytecodeManager.incBytecodes(2);
                            final Object next = iterator3.next();
                            BytecodeManager.incBytecodes(1);
                            final Object o = next;
                            BytecodeManager.incBytecodes(2);
                            if (o == null) {
                                break;
                            }
                            final Object o2 = next;
                            BytecodeManager.incBytecodes(3);
                            final boolean contains = this.contains(o2);
                            BytecodeManager.incBytecodes(1);
                            if (!contains) {
                                break;
                            }
                            BytecodeManager.incBytecodes(1);
                        }
                        final boolean b = false;
                        BytecodeManager.incBytecodes(2);
                        return b;
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
        public final boolean removeAll(final Collection<?> collection) {
            try {
                BytecodeManager.incBytecodes(2);
                if (collection == null) {
                    BytecodeManager.incBytecodes(3);
                    final NullPointerException ex = new NullPointerException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
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
        public final boolean retainAll(final Collection<?> collection) {
            try {
                BytecodeManager.incBytecodes(2);
                if (collection == null) {
                    BytecodeManager.incBytecodes(3);
                    final NullPointerException ex = new NullPointerException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
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
    }
    
    public static class KeySetView<K, V> extends CollectionView<K, V, K> implements Set<K>, Serializable
    {
        private static final long serialVersionUID = 7249069246763182397L;
        private final V value;
        
        KeySetView(final ConcurrentHashMap<K, V> concurrentHashMap, final V value) {
            try {
                BytecodeManager.incBytecodes(3);
                super(concurrentHashMap);
                this.value = value;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public V getMappedValue() {
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
        public boolean contains(final Object o) {
            try {
                final ConcurrentHashMap<K, V> map = this.map;
                BytecodeManager.incBytecodes(4);
                final boolean containsKey = map.containsKey(o);
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
                final ConcurrentHashMap<K, V> map = this.map;
                BytecodeManager.incBytecodes(4);
                final V remove = map.remove(o);
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
        public Iterator<K> iterator() {
            try {
                final ConcurrentHashMap<K, V> map = this.map;
                BytecodeManager.incBytecodes(3);
                final Node<K, V>[] table;
                final Node<K, V>[] array = table = map.table;
                BytecodeManager.incBytecodes(5);
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
                final Node<K, V>[] array2 = table;
                final int n2 = n;
                final int n3 = 0;
                final int n4 = n;
                final ConcurrentHashMap<K, V> concurrentHashMap = map;
                BytecodeManager.incBytecodes(8);
                final KeyIterator keyIterator = new KeyIterator<K, Object>(array2, n2, n3, n4, concurrentHashMap);
                BytecodeManager.incBytecodes(1);
                return (Iterator<K>)keyIterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean add(final K k) {
            try {
                final V value = this.value;
                BytecodeManager.incBytecodes(5);
                if (value == null) {
                    BytecodeManager.incBytecodes(3);
                    final UnsupportedOperationException ex = new UnsupportedOperationException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final ConcurrentHashMap<K, V> map = this.map;
                final V v = value;
                final boolean b = true;
                BytecodeManager.incBytecodes(6);
                final V putVal = map.putVal((K)k, (V)v, b);
                BytecodeManager.incBytecodes(1);
                boolean b2;
                if (putVal == null) {
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
        public boolean addAll(final Collection<? extends K> collection) {
            try {
                boolean b = false;
                BytecodeManager.incBytecodes(2);
                final V value = this.value;
                BytecodeManager.incBytecodes(5);
                if (value == null) {
                    BytecodeManager.incBytecodes(3);
                    final UnsupportedOperationException ex = new UnsupportedOperationException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                BytecodeManager.incBytecodes(2);
                final Iterator<? extends K> iterator = collection.iterator();
                BytecodeManager.incBytecodes(1);
                while (true) {
                    final Iterator<? extends K> iterator2 = iterator;
                    BytecodeManager.incBytecodes(2);
                    final boolean hasNext = iterator2.hasNext();
                    BytecodeManager.incBytecodes(1);
                    if (!hasNext) {
                        break;
                    }
                    final Iterator<? extends K> iterator3 = iterator;
                    BytecodeManager.incBytecodes(2);
                    final K next = (K)iterator3.next();
                    BytecodeManager.incBytecodes(1);
                    final ConcurrentHashMap<K, V> map = this.map;
                    final K k = next;
                    final V v = value;
                    final boolean b2 = true;
                    BytecodeManager.incBytecodes(6);
                    final V putVal = map.putVal((K)k, (V)v, b2);
                    BytecodeManager.incBytecodes(1);
                    if (putVal == null) {
                        b = true;
                        BytecodeManager.incBytecodes(2);
                    }
                    BytecodeManager.incBytecodes(1);
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
        public int hashCode() {
            try {
                int n = 0;
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(2);
                final Iterator<K> iterator = this.iterator();
                BytecodeManager.incBytecodes(1);
                while (true) {
                    final Iterator<K> iterator2 = iterator;
                    BytecodeManager.incBytecodes(2);
                    final boolean hasNext = iterator2.hasNext();
                    BytecodeManager.incBytecodes(1);
                    if (!hasNext) {
                        break;
                    }
                    final Iterator<K> iterator3 = iterator;
                    BytecodeManager.incBytecodes(2);
                    final K next = iterator3.next();
                    BytecodeManager.incBytecodes(1);
                    final int n2 = n;
                    final K k = next;
                    BytecodeManager.incBytecodes(3);
                    n = n2 + k.hashCode();
                    BytecodeManager.incBytecodes(3);
                }
                final int n3 = n;
                BytecodeManager.incBytecodes(2);
                return n3;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean equals(final Object o) {
            try {
                final boolean b = o instanceof Set;
                BytecodeManager.incBytecodes(3);
                boolean b2 = false;
                Label_0085: {
                    Label_0079: {
                        if (b) {
                            final Set set2;
                            final Set set = set2 = (Set)o;
                            BytecodeManager.incBytecodes(6);
                            if (set != this) {
                                final Set set3 = set2;
                                BytecodeManager.incBytecodes(2);
                                BytecodeManager.incBytecodes(1);
                                final boolean containsAll = this.containsAll(set3);
                                BytecodeManager.incBytecodes(1);
                                if (!containsAll) {
                                    break Label_0079;
                                }
                                final Set set4 = set2;
                                BytecodeManager.incBytecodes(3);
                                final boolean containsAll2 = set4.containsAll(this);
                                BytecodeManager.incBytecodes(1);
                                if (!containsAll2) {
                                    break Label_0079;
                                }
                            }
                            b2 = true;
                            BytecodeManager.incBytecodes(2);
                            break Label_0085;
                        }
                    }
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
        public Spliterator<K> spliterator() {
            try {
                final ConcurrentHashMap<K, V> map = this.map;
                BytecodeManager.incBytecodes(3);
                final ConcurrentHashMap<K, V> concurrentHashMap = map;
                BytecodeManager.incBytecodes(2);
                final long sumCount = concurrentHashMap.sumCount();
                BytecodeManager.incBytecodes(1);
                final Node<K, V>[] table;
                final Node<K, V>[] array = table = map.table;
                BytecodeManager.incBytecodes(5);
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
                final Node<K, V>[] array2 = table;
                final int n2 = n;
                final int n3 = 0;
                final int n4 = n;
                final long n5 = lcmp(sumCount, 0L);
                BytecodeManager.incBytecodes(10);
                long n6;
                if (n5 < 0) {
                    n6 = 0L;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    n6 = sumCount;
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
                final KeySpliterator keySpliterator = new KeySpliterator<K, Object>(array2, n2, n3, n4, n6);
                BytecodeManager.incBytecodes(1);
                return (Spliterator<K>)keySpliterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public void forEach(final Consumer<? super K> consumer) {
            try {
                BytecodeManager.incBytecodes(2);
                if (consumer == null) {
                    BytecodeManager.incBytecodes(3);
                    final NullPointerException ex = new NullPointerException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final Node<K, V>[] table;
                final Node<K, V>[] array = table = this.map.table;
                BytecodeManager.incBytecodes(6);
                if (array != null) {
                    final Node<Object, Object>[] array2 = (Node<Object, Object>[])table;
                    final int length = ((Node<Object, Object>[])table).length;
                    final int n = 0;
                    final int length2 = ((Node<Object, Object>[])table).length;
                    BytecodeManager.incBytecodes(9);
                    final Traverser traverser = new Traverser<Object, Object>(array2, length, n, length2);
                    BytecodeManager.incBytecodes(1);
                    while (true) {
                        final Traverser traverser2 = traverser;
                        BytecodeManager.incBytecodes(2);
                        final Node<K, V> advance = traverser2.advance();
                        BytecodeManager.incBytecodes(3);
                        if (advance == null) {
                            break;
                        }
                        final K key = advance.key;
                        BytecodeManager.incBytecodes(4);
                        consumer.accept((Object)key);
                        BytecodeManager.incBytecodes(1);
                    }
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class ValuesView<K, V> extends CollectionView<K, V, V> implements Collection<V>, Serializable
    {
        private static final long serialVersionUID = 2249069246763182397L;
        
        ValuesView(final ConcurrentHashMap<K, V> concurrentHashMap) {
            try {
                BytecodeManager.incBytecodes(3);
                super(concurrentHashMap);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final boolean contains(final Object o) {
            try {
                final ConcurrentHashMap<K, V> map = this.map;
                BytecodeManager.incBytecodes(4);
                final boolean containsValue = map.containsValue(o);
                BytecodeManager.incBytecodes(1);
                return containsValue;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final boolean remove(final Object o) {
            try {
                BytecodeManager.incBytecodes(2);
                Label_0089: {
                    if (o != null) {
                        BytecodeManager.incBytecodes(2);
                        final Iterator<Object> iterator = this.iterator();
                        BytecodeManager.incBytecodes(1);
                        boolean equals;
                        do {
                            final Iterator<Object> iterator2 = iterator;
                            BytecodeManager.incBytecodes(2);
                            final boolean hasNext = iterator2.hasNext();
                            BytecodeManager.incBytecodes(1);
                            if (!hasNext) {
                                break Label_0089;
                            }
                            final Iterator<Object> iterator3 = iterator;
                            BytecodeManager.incBytecodes(3);
                            final Object next = iterator3.next();
                            BytecodeManager.incBytecodes(1);
                            equals = o.equals(next);
                            BytecodeManager.incBytecodes(1);
                        } while (!equals);
                        final Iterator<Object> iterator4 = iterator;
                        BytecodeManager.incBytecodes(2);
                        iterator4.remove();
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
        public final Iterator<V> iterator() {
            try {
                final ConcurrentHashMap<K, V> map = this.map;
                BytecodeManager.incBytecodes(3);
                final Node<K, V>[] table;
                final Node<K, V>[] array = table = map.table;
                BytecodeManager.incBytecodes(5);
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
                final Node<K, V>[] array2 = table;
                final int n2 = n;
                final int n3 = 0;
                final int n4 = n;
                final ConcurrentHashMap<K, V> concurrentHashMap = map;
                BytecodeManager.incBytecodes(8);
                final ValueIterator valueIterator = new ValueIterator<Object, V>(array2, n2, n3, n4, concurrentHashMap);
                BytecodeManager.incBytecodes(1);
                return (Iterator<V>)valueIterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final boolean add(final V v) {
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
        public final boolean addAll(final Collection<? extends V> collection) {
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
        public Spliterator<V> spliterator() {
            try {
                final ConcurrentHashMap<K, V> map = this.map;
                BytecodeManager.incBytecodes(3);
                final ConcurrentHashMap<K, V> concurrentHashMap = map;
                BytecodeManager.incBytecodes(2);
                final long sumCount = concurrentHashMap.sumCount();
                BytecodeManager.incBytecodes(1);
                final Node<K, V>[] table;
                final Node<K, V>[] array = table = map.table;
                BytecodeManager.incBytecodes(5);
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
                final Node<K, V>[] array2 = table;
                final int n2 = n;
                final int n3 = 0;
                final int n4 = n;
                final long n5 = lcmp(sumCount, 0L);
                BytecodeManager.incBytecodes(10);
                long n6;
                if (n5 < 0) {
                    n6 = 0L;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    n6 = sumCount;
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
                final ValueSpliterator valueSpliterator = new ValueSpliterator<Object, V>(array2, n2, n3, n4, n6);
                BytecodeManager.incBytecodes(1);
                return (Spliterator<V>)valueSpliterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public void forEach(final Consumer<? super V> consumer) {
            try {
                BytecodeManager.incBytecodes(2);
                if (consumer == null) {
                    BytecodeManager.incBytecodes(3);
                    final NullPointerException ex = new NullPointerException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final Node<K, V>[] table;
                final Node<K, V>[] array = table = this.map.table;
                BytecodeManager.incBytecodes(6);
                if (array != null) {
                    final Node<Object, Object>[] array2 = (Node<Object, Object>[])table;
                    final int length = ((Node<Object, Object>[])table).length;
                    final int n = 0;
                    final int length2 = ((Node<Object, Object>[])table).length;
                    BytecodeManager.incBytecodes(9);
                    final Traverser traverser = new Traverser<Object, Object>(array2, length, n, length2);
                    BytecodeManager.incBytecodes(1);
                    while (true) {
                        final Traverser traverser2 = traverser;
                        BytecodeManager.incBytecodes(2);
                        final Node<K, V> advance = traverser2.advance();
                        BytecodeManager.incBytecodes(3);
                        if (advance == null) {
                            break;
                        }
                        final V val = advance.val;
                        BytecodeManager.incBytecodes(4);
                        consumer.accept((Object)val);
                        BytecodeManager.incBytecodes(1);
                    }
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class EntrySetView<K, V> extends CollectionView<K, V, Map.Entry<K, V>> implements Set<Map.Entry<K, V>>, Serializable
    {
        private static final long serialVersionUID = 2249069246763182397L;
        
        EntrySetView(final ConcurrentHashMap<K, V> concurrentHashMap) {
            try {
                BytecodeManager.incBytecodes(3);
                super(concurrentHashMap);
                BytecodeManager.incBytecodes(1);
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
                boolean b2 = false;
                Label_0150: {
                    Label_0144: {
                        if (b) {
                            final Map.Entry entry = (Map.Entry)o;
                            BytecodeManager.incBytecodes(4);
                            BytecodeManager.incBytecodes(1);
                            final Object key = entry.getKey();
                            BytecodeManager.incBytecodes(3);
                            if (key != null) {
                                final ConcurrentHashMap<K, V> map = this.map;
                                final Object o2 = key;
                                BytecodeManager.incBytecodes(3);
                                BytecodeManager.incBytecodes(1);
                                final V value;
                                final V v = value = map.get(o2);
                                BytecodeManager.incBytecodes(3);
                                if (v != null) {
                                    final Map.Entry<Object, Object> entry2 = (Map.Entry<Object, Object>)entry;
                                    BytecodeManager.incBytecodes(1);
                                    BytecodeManager.incBytecodes(1);
                                    final Object value2;
                                    final Object o3 = value2 = entry2.getValue();
                                    BytecodeManager.incBytecodes(3);
                                    if (o3 != null) {
                                        final Object o4 = value2;
                                        final V v2 = value;
                                        BytecodeManager.incBytecodes(3);
                                        if (o4 != v2) {
                                            final Object o5 = value2;
                                            final V obj = value;
                                            BytecodeManager.incBytecodes(2);
                                            BytecodeManager.incBytecodes(1);
                                            final boolean equals = o5.equals(obj);
                                            BytecodeManager.incBytecodes(1);
                                            if (!equals) {
                                                break Label_0144;
                                            }
                                        }
                                        b2 = true;
                                        BytecodeManager.incBytecodes(2);
                                        break Label_0150;
                                    }
                                }
                            }
                        }
                    }
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
        public boolean remove(final Object o) {
            try {
                final boolean b = o instanceof Map.Entry;
                BytecodeManager.incBytecodes(3);
                boolean b2 = false;
                Label_0113: {
                    if (b) {
                        final Map.Entry entry = (Map.Entry)o;
                        BytecodeManager.incBytecodes(4);
                        BytecodeManager.incBytecodes(1);
                        final Object key = entry.getKey();
                        BytecodeManager.incBytecodes(3);
                        if (key != null) {
                            final Map.Entry<Object, Object> entry2 = (Map.Entry<Object, Object>)entry;
                            BytecodeManager.incBytecodes(1);
                            BytecodeManager.incBytecodes(1);
                            final Object value = entry2.getValue();
                            BytecodeManager.incBytecodes(3);
                            if (value != null) {
                                final ConcurrentHashMap<K, V> map = this.map;
                                final Object o2 = key;
                                final Object o3 = value;
                                BytecodeManager.incBytecodes(4);
                                BytecodeManager.incBytecodes(1);
                                final boolean remove = map.remove(o2, o3);
                                BytecodeManager.incBytecodes(1);
                                if (remove) {
                                    b2 = true;
                                    BytecodeManager.incBytecodes(2);
                                    break Label_0113;
                                }
                            }
                        }
                    }
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
        public Iterator<Map.Entry<K, V>> iterator() {
            try {
                final ConcurrentHashMap<K, V> map = this.map;
                BytecodeManager.incBytecodes(3);
                final Node<K, V>[] table;
                final Node<K, V>[] array = table = map.table;
                BytecodeManager.incBytecodes(5);
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
                final Node<K, V>[] array2 = table;
                final int n2 = n;
                final int n3 = 0;
                final int n4 = n;
                final ConcurrentHashMap<K, V> concurrentHashMap = map;
                BytecodeManager.incBytecodes(8);
                final EntryIterator entryIterator = new EntryIterator<K, V>(array2, n2, n3, n4, concurrentHashMap);
                BytecodeManager.incBytecodes(1);
                return (Iterator<Map.Entry<K, V>>)entryIterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean add(final Map.Entry<K, V> entry) {
            try {
                final ConcurrentHashMap<K, V> map = this.map;
                BytecodeManager.incBytecodes(4);
                final K key = entry.getKey();
                BytecodeManager.incBytecodes(2);
                final V value = entry.getValue();
                final boolean b = false;
                BytecodeManager.incBytecodes(2);
                final V putVal = map.putVal((K)key, (V)value, b);
                BytecodeManager.incBytecodes(1);
                boolean b2;
                if (putVal == null) {
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
        public boolean addAll(final Collection<? extends Map.Entry<K, V>> collection) {
            try {
                boolean b = false;
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(2);
                final Iterator<? extends Map.Entry<K, V>> iterator = collection.iterator();
                BytecodeManager.incBytecodes(1);
                while (true) {
                    final Iterator<? extends Map.Entry<K, V>> iterator2 = iterator;
                    BytecodeManager.incBytecodes(2);
                    final boolean hasNext = iterator2.hasNext();
                    BytecodeManager.incBytecodes(1);
                    if (!hasNext) {
                        break;
                    }
                    final Iterator<? extends Map.Entry<K, V>> iterator3 = iterator;
                    BytecodeManager.incBytecodes(2);
                    final Map.Entry<K, V> entry = (Map.Entry<K, V>)iterator3.next();
                    BytecodeManager.incBytecodes(2);
                    final Map.Entry<K, V> entry2 = entry;
                    BytecodeManager.incBytecodes(3);
                    final boolean add = this.add(entry2);
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
        public final int hashCode() {
            try {
                int n = 0;
                BytecodeManager.incBytecodes(2);
                final Node<K, V>[] table;
                final Node<K, V>[] array = table = this.map.table;
                BytecodeManager.incBytecodes(6);
                if (array != null) {
                    final Node<K, V>[] array2 = table;
                    final int length = table.length;
                    final int n2 = 0;
                    final int length2 = table.length;
                    BytecodeManager.incBytecodes(9);
                    final Traverser traverser = new Traverser<Object, Object>(array2, length, n2, length2);
                    BytecodeManager.incBytecodes(1);
                    while (true) {
                        final Traverser traverser2 = traverser;
                        BytecodeManager.incBytecodes(2);
                        final Node<K, V> advance = traverser2.advance();
                        BytecodeManager.incBytecodes(3);
                        if (advance == null) {
                            break;
                        }
                        final int n3 = n;
                        final Node<K, V> node = advance;
                        BytecodeManager.incBytecodes(3);
                        n = n3 + node.hashCode();
                        BytecodeManager.incBytecodes(3);
                    }
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
        public final boolean equals(final Object o) {
            try {
                final boolean b = o instanceof Set;
                BytecodeManager.incBytecodes(3);
                boolean b2 = false;
                Label_0085: {
                    Label_0079: {
                        if (b) {
                            final Set set2;
                            final Set set = set2 = (Set)o;
                            BytecodeManager.incBytecodes(6);
                            if (set != this) {
                                final Set set3 = set2;
                                BytecodeManager.incBytecodes(2);
                                BytecodeManager.incBytecodes(1);
                                final boolean containsAll = this.containsAll(set3);
                                BytecodeManager.incBytecodes(1);
                                if (!containsAll) {
                                    break Label_0079;
                                }
                                final Set set4 = set2;
                                BytecodeManager.incBytecodes(3);
                                final boolean containsAll2 = set4.containsAll(this);
                                BytecodeManager.incBytecodes(1);
                                if (!containsAll2) {
                                    break Label_0079;
                                }
                            }
                            b2 = true;
                            BytecodeManager.incBytecodes(2);
                            break Label_0085;
                        }
                    }
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
        public Spliterator<Map.Entry<K, V>> spliterator() {
            try {
                final ConcurrentHashMap<K, V> map = this.map;
                BytecodeManager.incBytecodes(3);
                final ConcurrentHashMap<K, V> concurrentHashMap = map;
                BytecodeManager.incBytecodes(2);
                final long sumCount = concurrentHashMap.sumCount();
                BytecodeManager.incBytecodes(1);
                final Node<K, V>[] table;
                final Node<K, V>[] array = table = map.table;
                BytecodeManager.incBytecodes(5);
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
                final Node<K, V>[] array2 = table;
                final int n2 = n;
                final int n3 = 0;
                final int n4 = n;
                final long n5 = lcmp(sumCount, 0L);
                BytecodeManager.incBytecodes(10);
                long n6;
                if (n5 < 0) {
                    n6 = 0L;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    n6 = sumCount;
                    BytecodeManager.incBytecodes(1);
                }
                final ConcurrentHashMap<K, V> concurrentHashMap2 = map;
                BytecodeManager.incBytecodes(2);
                final EntrySpliterator entrySpliterator = new EntrySpliterator<K, V>(array2, n2, n3, n4, n6, concurrentHashMap2);
                BytecodeManager.incBytecodes(1);
                return (Spliterator<Map.Entry<K, V>>)entrySpliterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public void forEach(final Consumer<? super Map.Entry<K, V>> consumer) {
            try {
                BytecodeManager.incBytecodes(2);
                if (consumer == null) {
                    BytecodeManager.incBytecodes(3);
                    final NullPointerException ex = new NullPointerException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final Node<K, V>[] table;
                final Node<K, V>[] array = table = this.map.table;
                BytecodeManager.incBytecodes(6);
                if (array != null) {
                    final Node<Object, Object>[] array2 = (Node<Object, Object>[])table;
                    final int length = ((Node<Object, Object>[])table).length;
                    final int n = 0;
                    final int length2 = ((Node<Object, Object>[])table).length;
                    BytecodeManager.incBytecodes(9);
                    final Traverser traverser = new Traverser<Object, Object>(array2, length, n, length2);
                    BytecodeManager.incBytecodes(1);
                    while (true) {
                        final Traverser traverser2 = traverser;
                        BytecodeManager.incBytecodes(2);
                        final Map.Entry<K, V> advance;
                        final Node<K, V> node = (Node<K, V>)(advance = (Map.Entry<K, V>)traverser2.advance());
                        BytecodeManager.incBytecodes(3);
                        if (node == null) {
                            break;
                        }
                        final K key = ((Node)advance).key;
                        final V val = ((Node)advance).val;
                        final ConcurrentHashMap<K, V> map = this.map;
                        BytecodeManager.incBytecodes(10);
                        final MapEntry mapEntry = new MapEntry(key, val, (ConcurrentHashMap<Object, Object>)map);
                        BytecodeManager.incBytecodes(1);
                        consumer.accept((Object)mapEntry);
                        BytecodeManager.incBytecodes(1);
                    }
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    abstract static class BulkTask<K, V, R> extends CountedCompleter<R>
    {
        Node<K, V>[] tab;
        Node<K, V> next;
        TableStack<K, V> stack;
        TableStack<K, V> spare;
        int index;
        int baseIndex;
        int baseLimit;
        final int baseSize;
        int batch;
        
        BulkTask(final BulkTask<K, V, ?> bulkTask, final int batch, final int n, final int baseLimit, final Node<K, V>[] tab) {
            try {
                BytecodeManager.incBytecodes(3);
                super(bulkTask);
                this.batch = batch;
                BytecodeManager.incBytecodes(3);
                this.baseIndex = n;
                this.index = n;
                BytecodeManager.incBytecodes(6);
                this.tab = tab;
                BytecodeManager.incBytecodes(5);
                if (tab == null) {
                    final int n2 = 0;
                    this.baseLimit = n2;
                    this.baseSize = n2;
                    BytecodeManager.incBytecodes(7);
                }
                else {
                    BytecodeManager.incBytecodes(2);
                    if (bulkTask == null) {
                        final int length = tab.length;
                        this.baseLimit = length;
                        this.baseSize = length;
                        BytecodeManager.incBytecodes(8);
                    }
                    else {
                        this.baseLimit = baseLimit;
                        BytecodeManager.incBytecodes(3);
                        this.baseSize = bulkTask.baseSize;
                        BytecodeManager.incBytecodes(4);
                    }
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        final Node<K, V> advance() {
            try {
                Object o;
                final Node<K, V> node = (Node<K, V>)(o = this.next);
                BytecodeManager.incBytecodes(5);
                if (node != null) {
                    o = ((Node)o).next;
                    BytecodeManager.incBytecodes(3);
                }
                while (true) {
                    final Node node2 = (Node)o;
                    BytecodeManager.incBytecodes(2);
                    if (node2 != null) {
                        final Node next = (Node)o;
                        this.next = (Node<K, V>)next;
                        BytecodeManager.incBytecodes(5);
                        return (Node<K, V>)next;
                    }
                    final int baseIndex = this.baseIndex;
                    final int baseLimit = this.baseLimit;
                    BytecodeManager.incBytecodes(5);
                    if (baseIndex >= baseLimit) {
                        break;
                    }
                    final Node<K, V>[] tab;
                    final Node<K, V>[] array = tab = this.tab;
                    BytecodeManager.incBytecodes(5);
                    if (array == null) {
                        break;
                    }
                    final int length;
                    final int n = length = tab.length;
                    final int index;
                    final int n2 = index = this.index;
                    BytecodeManager.incBytecodes(9);
                    if (n <= n2) {
                        break;
                    }
                    final int n3 = index;
                    BytecodeManager.incBytecodes(2);
                    if (n3 < 0) {
                        break;
                    }
                    final Node<K, V>[] array2 = tab;
                    final int n4 = index;
                    BytecodeManager.incBytecodes(3);
                    final Node<K, V> node3 = (Node<K, V>)(o = ConcurrentHashMap.tabAt(array2, n4));
                    BytecodeManager.incBytecodes(3);
                    if (node3 != null) {
                        final int hash = ((Node)o).hash;
                        BytecodeManager.incBytecodes(3);
                        if (hash < 0) {
                            final boolean b = o instanceof ForwardingNode;
                            BytecodeManager.incBytecodes(3);
                            if (b) {
                                this.tab = (Node<K, V>[])((ForwardingNode)o).nextTable;
                                BytecodeManager.incBytecodes(5);
                                o = null;
                                BytecodeManager.incBytecodes(2);
                                final Node<K, V>[] array3 = tab;
                                final int n5 = index;
                                final int n6 = length;
                                BytecodeManager.incBytecodes(5);
                                this.pushState(array3, n5, n6);
                                BytecodeManager.incBytecodes(1);
                                continue;
                            }
                            final boolean b2 = o instanceof TreeBin;
                            BytecodeManager.incBytecodes(3);
                            if (b2) {
                                o = ((TreeBin)o).first;
                                BytecodeManager.incBytecodes(5);
                            }
                            else {
                                o = null;
                                BytecodeManager.incBytecodes(2);
                            }
                        }
                    }
                    final TableStack<K, V> stack = this.stack;
                    BytecodeManager.incBytecodes(3);
                    if (stack != null) {
                        final int n7 = length;
                        BytecodeManager.incBytecodes(3);
                        this.recoverState(n7);
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        final int index2 = index + this.baseSize;
                        this.index = index2;
                        final int n8 = length;
                        BytecodeManager.incBytecodes(9);
                        if (index2 >= n8) {
                            this.index = ++this.baseIndex;
                            BytecodeManager.incBytecodes(9);
                        }
                    }
                    BytecodeManager.incBytecodes(1);
                }
                final Node<K, V> next2 = null;
                this.next = next2;
                BytecodeManager.incBytecodes(5);
                return next2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private void pushState(final Node<K, V>[] tab, final int index, final int length) {
            try {
                TableStack<K, V> spare = this.spare;
                BytecodeManager.incBytecodes(3);
                final TableStack<K, V> tableStack = spare;
                BytecodeManager.incBytecodes(2);
                if (tableStack != null) {
                    this.spare = spare.next;
                    BytecodeManager.incBytecodes(5);
                }
                else {
                    BytecodeManager.incBytecodes(3);
                    spare = new TableStack<K, V>();
                    BytecodeManager.incBytecodes(1);
                }
                spare.tab = tab;
                BytecodeManager.incBytecodes(3);
                spare.length = length;
                BytecodeManager.incBytecodes(3);
                spare.index = index;
                BytecodeManager.incBytecodes(3);
                spare.next = this.stack;
                BytecodeManager.incBytecodes(4);
                this.stack = spare;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private void recoverState(int n) {
            try {
                TableStack<K, V> stack;
                while (true) {
                    final TableStack<K, V> tableStack = stack = this.stack;
                    BytecodeManager.incBytecodes(5);
                    if (tableStack == null) {
                        break;
                    }
                    final int length;
                    final int index = this.index + (length = stack.length);
                    this.index = index;
                    final int n2 = n;
                    BytecodeManager.incBytecodes(12);
                    if (index < n2) {
                        break;
                    }
                    n = length;
                    BytecodeManager.incBytecodes(2);
                    this.index = stack.index;
                    BytecodeManager.incBytecodes(4);
                    this.tab = stack.tab;
                    BytecodeManager.incBytecodes(4);
                    stack.tab = null;
                    BytecodeManager.incBytecodes(3);
                    final TableStack<K, V> next = stack.next;
                    BytecodeManager.incBytecodes(3);
                    stack.next = this.spare;
                    BytecodeManager.incBytecodes(4);
                    this.stack = next;
                    BytecodeManager.incBytecodes(3);
                    this.spare = stack;
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(1);
                }
                final TableStack<K, V> tableStack2 = stack;
                BytecodeManager.incBytecodes(2);
                if (tableStack2 == null) {
                    final int index2 = this.index + this.baseSize;
                    this.index = index2;
                    final int n3 = n;
                    BytecodeManager.incBytecodes(10);
                    if (index2 >= n3) {
                        this.index = ++this.baseIndex;
                        BytecodeManager.incBytecodes(9);
                    }
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class ForEachKeyTask<K, V> extends BulkTask<K, V, Void>
    {
        final Consumer<? super K> action;
        
        ForEachKeyTask(final BulkTask<K, V, ?> bulkTask, final int n, final int n2, final int n3, final Node<K, V>[] array, final Consumer<? super K> action) {
            try {
                BytecodeManager.incBytecodes(7);
                super(bulkTask, n, n2, n3, array);
                this.action = action;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final void compute() {
            try {
                final Consumer<? super K> action;
                final Consumer<? super K> consumer = action = this.action;
                BytecodeManager.incBytecodes(5);
                if (consumer != null) {
                    final int baseIndex = this.baseIndex;
                    BytecodeManager.incBytecodes(3);
                    while (true) {
                        final int batch = this.batch;
                        BytecodeManager.incBytecodes(3);
                        if (batch <= 0) {
                            break;
                        }
                        final int baseLimit;
                        final int n = (baseLimit = this.baseLimit) + baseIndex >>> 1;
                        final int n2 = baseIndex;
                        BytecodeManager.incBytecodes(12);
                        if (n <= n2) {
                            break;
                        }
                        final int n3 = 1;
                        BytecodeManager.incBytecodes(3);
                        this.addToPendingCount(n3);
                        final int batch2 = this.batch >>> 1;
                        this.batch = batch2;
                        final int baseLimit2 = n;
                        this.baseLimit = baseLimit2;
                        final int n4 = baseLimit;
                        final Node<K, V>[] tab = this.tab;
                        final Consumer<? super K> consumer2 = action;
                        BytecodeManager.incBytecodes(19);
                        final ForEachKeyTask forEachKeyTask = new ForEachKeyTask((BulkTask<Object, Object, ?>)this, batch2, baseLimit2, n4, (Node<Object, Object>[])tab, (Consumer<? super Object>)consumer2);
                        BytecodeManager.incBytecodes(1);
                        forEachKeyTask.fork();
                        BytecodeManager.incBytecodes(2);
                    }
                    while (true) {
                        BytecodeManager.incBytecodes(2);
                        final Node<K, V> advance = this.advance();
                        BytecodeManager.incBytecodes(3);
                        if (advance == null) {
                            break;
                        }
                        final Consumer<? super K> consumer3 = action;
                        final K key = advance.key;
                        BytecodeManager.incBytecodes(4);
                        consumer3.accept(key);
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(2);
                    this.propagateCompletion();
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class ForEachValueTask<K, V> extends BulkTask<K, V, Void>
    {
        final Consumer<? super V> action;
        
        ForEachValueTask(final BulkTask<K, V, ?> bulkTask, final int n, final int n2, final int n3, final Node<K, V>[] array, final Consumer<? super V> action) {
            try {
                BytecodeManager.incBytecodes(7);
                super(bulkTask, n, n2, n3, array);
                this.action = action;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final void compute() {
            try {
                final Consumer<? super V> action;
                final Consumer<? super V> consumer = action = this.action;
                BytecodeManager.incBytecodes(5);
                if (consumer != null) {
                    final int baseIndex = this.baseIndex;
                    BytecodeManager.incBytecodes(3);
                    while (true) {
                        final int batch = this.batch;
                        BytecodeManager.incBytecodes(3);
                        if (batch <= 0) {
                            break;
                        }
                        final int baseLimit;
                        final int n = (baseLimit = this.baseLimit) + baseIndex >>> 1;
                        final int n2 = baseIndex;
                        BytecodeManager.incBytecodes(12);
                        if (n <= n2) {
                            break;
                        }
                        final int n3 = 1;
                        BytecodeManager.incBytecodes(3);
                        this.addToPendingCount(n3);
                        final int batch2 = this.batch >>> 1;
                        this.batch = batch2;
                        final int baseLimit2 = n;
                        this.baseLimit = baseLimit2;
                        final int n4 = baseLimit;
                        final Node<K, V>[] tab = this.tab;
                        final Consumer<? super V> consumer2 = action;
                        BytecodeManager.incBytecodes(19);
                        final ForEachValueTask forEachValueTask = new ForEachValueTask((BulkTask<Object, Object, ?>)this, batch2, baseLimit2, n4, (Node<Object, Object>[])tab, (Consumer<? super Object>)consumer2);
                        BytecodeManager.incBytecodes(1);
                        forEachValueTask.fork();
                        BytecodeManager.incBytecodes(2);
                    }
                    while (true) {
                        BytecodeManager.incBytecodes(2);
                        final Node<K, V> advance = this.advance();
                        BytecodeManager.incBytecodes(3);
                        if (advance == null) {
                            break;
                        }
                        final Consumer<? super V> consumer3 = action;
                        final V val = advance.val;
                        BytecodeManager.incBytecodes(4);
                        consumer3.accept(val);
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(2);
                    this.propagateCompletion();
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class ForEachEntryTask<K, V> extends BulkTask<K, V, Void>
    {
        final Consumer<? super Map.Entry<K, V>> action;
        
        ForEachEntryTask(final BulkTask<K, V, ?> bulkTask, final int n, final int n2, final int n3, final Node<K, V>[] array, final Consumer<? super Map.Entry<K, V>> action) {
            try {
                BytecodeManager.incBytecodes(7);
                super(bulkTask, n, n2, n3, array);
                this.action = action;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final void compute() {
            try {
                final Consumer<? super Map.Entry<K, V>> action;
                final Consumer<? super Map.Entry<K, V>> consumer = action = this.action;
                BytecodeManager.incBytecodes(5);
                if (consumer != null) {
                    final int baseIndex = this.baseIndex;
                    BytecodeManager.incBytecodes(3);
                    while (true) {
                        final int batch = this.batch;
                        BytecodeManager.incBytecodes(3);
                        if (batch <= 0) {
                            break;
                        }
                        final int baseLimit;
                        final int n = (baseLimit = this.baseLimit) + baseIndex >>> 1;
                        final int n2 = baseIndex;
                        BytecodeManager.incBytecodes(12);
                        if (n <= n2) {
                            break;
                        }
                        final int n3 = 1;
                        BytecodeManager.incBytecodes(3);
                        this.addToPendingCount(n3);
                        final int batch2 = this.batch >>> 1;
                        this.batch = batch2;
                        final int baseLimit2 = n;
                        this.baseLimit = baseLimit2;
                        final int n4 = baseLimit;
                        final Node<K, V>[] tab = this.tab;
                        final Consumer<? super Map.Entry<K, V>> consumer2 = action;
                        BytecodeManager.incBytecodes(19);
                        final ForEachEntryTask forEachEntryTask = new ForEachEntryTask((BulkTask<Object, Object, ?>)this, batch2, baseLimit2, n4, (Node<Object, Object>[])tab, (Consumer<? super Map.Entry<Object, Object>>)consumer2);
                        BytecodeManager.incBytecodes(1);
                        forEachEntryTask.fork();
                        BytecodeManager.incBytecodes(2);
                    }
                    while (true) {
                        BytecodeManager.incBytecodes(2);
                        final Node<K, V> advance = this.advance();
                        BytecodeManager.incBytecodes(3);
                        if (advance == null) {
                            break;
                        }
                        final Consumer<? super Map.Entry<K, V>> consumer3 = action;
                        final Node<K, V> node = advance;
                        BytecodeManager.incBytecodes(3);
                        consumer3.accept(node);
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(2);
                    this.propagateCompletion();
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class ForEachMappingTask<K, V> extends BulkTask<K, V, Void>
    {
        final BiConsumer<? super K, ? super V> action;
        
        ForEachMappingTask(final BulkTask<K, V, ?> bulkTask, final int n, final int n2, final int n3, final Node<K, V>[] array, final BiConsumer<? super K, ? super V> action) {
            try {
                BytecodeManager.incBytecodes(7);
                super(bulkTask, n, n2, n3, array);
                this.action = action;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final void compute() {
            try {
                final BiConsumer<? super K, ? super V> action;
                final BiConsumer<? super K, ? super V> biConsumer = action = this.action;
                BytecodeManager.incBytecodes(5);
                if (biConsumer != null) {
                    final int baseIndex = this.baseIndex;
                    BytecodeManager.incBytecodes(3);
                    while (true) {
                        final int batch = this.batch;
                        BytecodeManager.incBytecodes(3);
                        if (batch <= 0) {
                            break;
                        }
                        final int baseLimit;
                        final int n = (baseLimit = this.baseLimit) + baseIndex >>> 1;
                        final int n2 = baseIndex;
                        BytecodeManager.incBytecodes(12);
                        if (n <= n2) {
                            break;
                        }
                        final int n3 = 1;
                        BytecodeManager.incBytecodes(3);
                        this.addToPendingCount(n3);
                        final int batch2 = this.batch >>> 1;
                        this.batch = batch2;
                        final int baseLimit2 = n;
                        this.baseLimit = baseLimit2;
                        final int n4 = baseLimit;
                        final Node<K, V>[] tab = this.tab;
                        final BiConsumer<? super K, ? super V> biConsumer2 = action;
                        BytecodeManager.incBytecodes(19);
                        final ForEachMappingTask forEachMappingTask = new ForEachMappingTask((BulkTask<Object, Object, ?>)this, batch2, baseLimit2, n4, (Node<Object, Object>[])tab, (BiConsumer<? super Object, ? super Object>)biConsumer2);
                        BytecodeManager.incBytecodes(1);
                        forEachMappingTask.fork();
                        BytecodeManager.incBytecodes(2);
                    }
                    while (true) {
                        BytecodeManager.incBytecodes(2);
                        final Node<K, V> advance;
                        final Node<K, V> node = advance = this.advance();
                        BytecodeManager.incBytecodes(3);
                        if (node == null) {
                            break;
                        }
                        final BiConsumer<? super K, ? super V> biConsumer3 = action;
                        final K key = advance.key;
                        final V val = advance.val;
                        BytecodeManager.incBytecodes(6);
                        biConsumer3.accept(key, val);
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(2);
                    this.propagateCompletion();
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class ForEachTransformedKeyTask<K, V, U> extends BulkTask<K, V, Void>
    {
        final Function<? super K, ? extends U> transformer;
        final Consumer<? super U> action;
        
        ForEachTransformedKeyTask(final BulkTask<K, V, ?> bulkTask, final int n, final int n2, final int n3, final Node<K, V>[] array, final Function<? super K, ? extends U> transformer, final Consumer<? super U> action) {
            try {
                BytecodeManager.incBytecodes(7);
                super(bulkTask, n, n2, n3, array);
                this.transformer = transformer;
                this.action = action;
                BytecodeManager.incBytecodes(6);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final void compute() {
            try {
                final Function<? super K, ? extends U> transformer;
                final Function<? super K, ? extends U> function = transformer = this.transformer;
                BytecodeManager.incBytecodes(5);
                if (function != null) {
                    final Consumer<? super U> action;
                    final Consumer<? super U> consumer = action = this.action;
                    BytecodeManager.incBytecodes(5);
                    if (consumer != null) {
                        final int baseIndex = this.baseIndex;
                        BytecodeManager.incBytecodes(3);
                        while (true) {
                            final int batch = this.batch;
                            BytecodeManager.incBytecodes(3);
                            if (batch <= 0) {
                                break;
                            }
                            final int baseLimit;
                            final int n = (baseLimit = this.baseLimit) + baseIndex >>> 1;
                            final int n2 = baseIndex;
                            BytecodeManager.incBytecodes(12);
                            if (n <= n2) {
                                break;
                            }
                            final int n3 = 1;
                            BytecodeManager.incBytecodes(3);
                            this.addToPendingCount(n3);
                            final int batch2 = this.batch >>> 1;
                            this.batch = batch2;
                            final int baseLimit2 = n;
                            this.baseLimit = baseLimit2;
                            final int n4 = baseLimit;
                            final Node<K, V>[] tab = this.tab;
                            final Function<? super K, ? extends U> function2 = transformer;
                            final Consumer<? super U> consumer2 = action;
                            BytecodeManager.incBytecodes(20);
                            final ForEachTransformedKeyTask forEachTransformedKeyTask = new ForEachTransformedKeyTask((BulkTask<Object, Object, ?>)this, batch2, baseLimit2, n4, (Node<Object, Object>[])tab, (Function<? super Object, ?>)function2, (Consumer<? super Object>)consumer2);
                            BytecodeManager.incBytecodes(1);
                            forEachTransformedKeyTask.fork();
                            BytecodeManager.incBytecodes(2);
                        }
                        while (true) {
                            BytecodeManager.incBytecodes(2);
                            final Node<K, V> advance = this.advance();
                            BytecodeManager.incBytecodes(3);
                            if (advance == null) {
                                break;
                            }
                            final Function<? super K, ? extends U> function3 = transformer;
                            final K key = advance.key;
                            BytecodeManager.incBytecodes(4);
                            final U apply = (U)function3.apply(key);
                            BytecodeManager.incBytecodes(3);
                            if (apply != null) {
                                final Consumer<? super U> consumer3 = action;
                                final U u = apply;
                                BytecodeManager.incBytecodes(3);
                                consumer3.accept(u);
                            }
                            BytecodeManager.incBytecodes(1);
                        }
                        BytecodeManager.incBytecodes(2);
                        this.propagateCompletion();
                    }
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class ForEachTransformedValueTask<K, V, U> extends BulkTask<K, V, Void>
    {
        final Function<? super V, ? extends U> transformer;
        final Consumer<? super U> action;
        
        ForEachTransformedValueTask(final BulkTask<K, V, ?> bulkTask, final int n, final int n2, final int n3, final Node<K, V>[] array, final Function<? super V, ? extends U> transformer, final Consumer<? super U> action) {
            try {
                BytecodeManager.incBytecodes(7);
                super(bulkTask, n, n2, n3, array);
                this.transformer = transformer;
                this.action = action;
                BytecodeManager.incBytecodes(6);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final void compute() {
            try {
                final Function<? super V, ? extends U> transformer;
                final Function<? super V, ? extends U> function = transformer = this.transformer;
                BytecodeManager.incBytecodes(5);
                if (function != null) {
                    final Consumer<? super U> action;
                    final Consumer<? super U> consumer = action = this.action;
                    BytecodeManager.incBytecodes(5);
                    if (consumer != null) {
                        final int baseIndex = this.baseIndex;
                        BytecodeManager.incBytecodes(3);
                        while (true) {
                            final int batch = this.batch;
                            BytecodeManager.incBytecodes(3);
                            if (batch <= 0) {
                                break;
                            }
                            final int baseLimit;
                            final int n = (baseLimit = this.baseLimit) + baseIndex >>> 1;
                            final int n2 = baseIndex;
                            BytecodeManager.incBytecodes(12);
                            if (n <= n2) {
                                break;
                            }
                            final int n3 = 1;
                            BytecodeManager.incBytecodes(3);
                            this.addToPendingCount(n3);
                            final int batch2 = this.batch >>> 1;
                            this.batch = batch2;
                            final int baseLimit2 = n;
                            this.baseLimit = baseLimit2;
                            final int n4 = baseLimit;
                            final Node<K, V>[] tab = this.tab;
                            final Function<? super V, ? extends U> function2 = transformer;
                            final Consumer<? super U> consumer2 = action;
                            BytecodeManager.incBytecodes(20);
                            final ForEachTransformedValueTask forEachTransformedValueTask = new ForEachTransformedValueTask((BulkTask<Object, Object, ?>)this, batch2, baseLimit2, n4, (Node<Object, Object>[])tab, (Function<? super Object, ?>)function2, (Consumer<? super Object>)consumer2);
                            BytecodeManager.incBytecodes(1);
                            forEachTransformedValueTask.fork();
                            BytecodeManager.incBytecodes(2);
                        }
                        while (true) {
                            BytecodeManager.incBytecodes(2);
                            final Node<K, V> advance = this.advance();
                            BytecodeManager.incBytecodes(3);
                            if (advance == null) {
                                break;
                            }
                            final Function<? super V, ? extends U> function3 = transformer;
                            final V val = advance.val;
                            BytecodeManager.incBytecodes(4);
                            final U apply = (U)function3.apply(val);
                            BytecodeManager.incBytecodes(3);
                            if (apply != null) {
                                final Consumer<? super U> consumer3 = action;
                                final U u = apply;
                                BytecodeManager.incBytecodes(3);
                                consumer3.accept(u);
                            }
                            BytecodeManager.incBytecodes(1);
                        }
                        BytecodeManager.incBytecodes(2);
                        this.propagateCompletion();
                    }
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class ForEachTransformedEntryTask<K, V, U> extends BulkTask<K, V, Void>
    {
        final Function<Map.Entry<K, V>, ? extends U> transformer;
        final Consumer<? super U> action;
        
        ForEachTransformedEntryTask(final BulkTask<K, V, ?> bulkTask, final int n, final int n2, final int n3, final Node<K, V>[] array, final Function<Map.Entry<K, V>, ? extends U> transformer, final Consumer<? super U> action) {
            try {
                BytecodeManager.incBytecodes(7);
                super(bulkTask, n, n2, n3, array);
                this.transformer = transformer;
                this.action = action;
                BytecodeManager.incBytecodes(6);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final void compute() {
            try {
                final Function<Map.Entry<K, V>, ? extends U> transformer;
                final Function<Map.Entry<K, V>, ? extends U> function = transformer = this.transformer;
                BytecodeManager.incBytecodes(5);
                if (function != null) {
                    final Consumer<? super U> action;
                    final Consumer<? super U> consumer = action = this.action;
                    BytecodeManager.incBytecodes(5);
                    if (consumer != null) {
                        final int baseIndex = this.baseIndex;
                        BytecodeManager.incBytecodes(3);
                        while (true) {
                            final int batch = this.batch;
                            BytecodeManager.incBytecodes(3);
                            if (batch <= 0) {
                                break;
                            }
                            final int baseLimit;
                            final int n = (baseLimit = this.baseLimit) + baseIndex >>> 1;
                            final int n2 = baseIndex;
                            BytecodeManager.incBytecodes(12);
                            if (n <= n2) {
                                break;
                            }
                            final int n3 = 1;
                            BytecodeManager.incBytecodes(3);
                            this.addToPendingCount(n3);
                            final int batch2 = this.batch >>> 1;
                            this.batch = batch2;
                            final int baseLimit2 = n;
                            this.baseLimit = baseLimit2;
                            final int n4 = baseLimit;
                            final Node<K, V>[] tab = this.tab;
                            final Function<Map.Entry<K, V>, ? extends U> function2 = transformer;
                            final Consumer<? super U> consumer2 = action;
                            BytecodeManager.incBytecodes(20);
                            final ForEachTransformedEntryTask forEachTransformedEntryTask = new ForEachTransformedEntryTask((BulkTask<Object, Object, ?>)this, batch2, baseLimit2, n4, (Node<Object, Object>[])tab, (Function<Map.Entry<Object, Object>, ?>)function2, (Consumer<? super Object>)consumer2);
                            BytecodeManager.incBytecodes(1);
                            forEachTransformedEntryTask.fork();
                            BytecodeManager.incBytecodes(2);
                        }
                        while (true) {
                            BytecodeManager.incBytecodes(2);
                            final Node<Object, Object> advance = this.advance();
                            BytecodeManager.incBytecodes(3);
                            if (advance == null) {
                                break;
                            }
                            final Function<Map.Entry<K, V>, ? extends U> function3 = transformer;
                            final Node<Object, Object> node = advance;
                            BytecodeManager.incBytecodes(3);
                            final U apply = (U)function3.apply((Map.Entry<K, V>)node);
                            BytecodeManager.incBytecodes(3);
                            if (apply != null) {
                                final Consumer<? super U> consumer3 = action;
                                final U u = apply;
                                BytecodeManager.incBytecodes(3);
                                consumer3.accept(u);
                            }
                            BytecodeManager.incBytecodes(1);
                        }
                        BytecodeManager.incBytecodes(2);
                        this.propagateCompletion();
                    }
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class ForEachTransformedMappingTask<K, V, U> extends BulkTask<K, V, Void>
    {
        final BiFunction<? super K, ? super V, ? extends U> transformer;
        final Consumer<? super U> action;
        
        ForEachTransformedMappingTask(final BulkTask<K, V, ?> bulkTask, final int n, final int n2, final int n3, final Node<K, V>[] array, final BiFunction<? super K, ? super V, ? extends U> transformer, final Consumer<? super U> action) {
            try {
                BytecodeManager.incBytecodes(7);
                super(bulkTask, n, n2, n3, array);
                this.transformer = transformer;
                this.action = action;
                BytecodeManager.incBytecodes(6);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final void compute() {
            try {
                final BiFunction<? super K, ? super V, ? extends U> transformer;
                final BiFunction<? super K, ? super V, ? extends U> biFunction = transformer = this.transformer;
                BytecodeManager.incBytecodes(5);
                if (biFunction != null) {
                    final Consumer<? super U> action;
                    final Consumer<? super U> consumer = action = this.action;
                    BytecodeManager.incBytecodes(5);
                    if (consumer != null) {
                        final int baseIndex = this.baseIndex;
                        BytecodeManager.incBytecodes(3);
                        while (true) {
                            final int batch = this.batch;
                            BytecodeManager.incBytecodes(3);
                            if (batch <= 0) {
                                break;
                            }
                            final int baseLimit;
                            final int n = (baseLimit = this.baseLimit) + baseIndex >>> 1;
                            final int n2 = baseIndex;
                            BytecodeManager.incBytecodes(12);
                            if (n <= n2) {
                                break;
                            }
                            final int n3 = 1;
                            BytecodeManager.incBytecodes(3);
                            this.addToPendingCount(n3);
                            final int batch2 = this.batch >>> 1;
                            this.batch = batch2;
                            final int baseLimit2 = n;
                            this.baseLimit = baseLimit2;
                            final int n4 = baseLimit;
                            final Node<K, V>[] tab = this.tab;
                            final BiFunction<? super K, ? super V, ? extends U> biFunction2 = transformer;
                            final Consumer<? super U> consumer2 = action;
                            BytecodeManager.incBytecodes(20);
                            final ForEachTransformedMappingTask forEachTransformedMappingTask = new ForEachTransformedMappingTask((BulkTask<Object, Object, ?>)this, batch2, baseLimit2, n4, (Node<Object, Object>[])tab, (BiFunction<? super Object, ? super Object, ?>)biFunction2, (Consumer<? super Object>)consumer2);
                            BytecodeManager.incBytecodes(1);
                            forEachTransformedMappingTask.fork();
                            BytecodeManager.incBytecodes(2);
                        }
                        while (true) {
                            BytecodeManager.incBytecodes(2);
                            final Node<K, V> advance;
                            final Node<K, V> node = advance = this.advance();
                            BytecodeManager.incBytecodes(3);
                            if (node == null) {
                                break;
                            }
                            final BiFunction<? super K, ? super V, ? extends U> biFunction3 = transformer;
                            final K key = advance.key;
                            final V val = advance.val;
                            BytecodeManager.incBytecodes(6);
                            final U apply = (U)biFunction3.apply(key, val);
                            BytecodeManager.incBytecodes(3);
                            if (apply != null) {
                                final Consumer<? super U> consumer3 = action;
                                final U u = apply;
                                BytecodeManager.incBytecodes(3);
                                consumer3.accept(u);
                            }
                            BytecodeManager.incBytecodes(1);
                        }
                        BytecodeManager.incBytecodes(2);
                        this.propagateCompletion();
                    }
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class SearchKeysTask<K, V, U> extends BulkTask<K, V, U>
    {
        final Function<? super K, ? extends U> searchFunction;
        final AtomicReference<U> result;
        
        SearchKeysTask(final BulkTask<K, V, ?> bulkTask, final int n, final int n2, final int n3, final Node<K, V>[] array, final Function<? super K, ? extends U> searchFunction, final AtomicReference<U> result) {
            try {
                BytecodeManager.incBytecodes(7);
                super(bulkTask, n, n2, n3, array);
                this.searchFunction = searchFunction;
                this.result = result;
                BytecodeManager.incBytecodes(6);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final U getRawResult() {
            try {
                final AtomicReference<U> result = this.result;
                BytecodeManager.incBytecodes(3);
                final U value = result.get();
                BytecodeManager.incBytecodes(1);
                return value;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final void compute() {
            try {
                final Function<? super K, ? extends U> searchFunction;
                final Function<? super K, ? extends U> function = searchFunction = this.searchFunction;
                BytecodeManager.incBytecodes(5);
                if (function != null) {
                    final AtomicReference<U> result;
                    final AtomicReference<U> atomicReference = result = this.result;
                    BytecodeManager.incBytecodes(5);
                    if (atomicReference != null) {
                        final int baseIndex = this.baseIndex;
                        BytecodeManager.incBytecodes(3);
                        while (true) {
                            final int batch = this.batch;
                            BytecodeManager.incBytecodes(3);
                            if (batch <= 0) {
                                break;
                            }
                            final int baseLimit;
                            final int n = (baseLimit = this.baseLimit) + baseIndex >>> 1;
                            final int n2 = baseIndex;
                            BytecodeManager.incBytecodes(12);
                            if (n <= n2) {
                                break;
                            }
                            final AtomicReference<U> atomicReference2 = result;
                            BytecodeManager.incBytecodes(2);
                            final U value = atomicReference2.get();
                            BytecodeManager.incBytecodes(1);
                            if (value != null) {
                                BytecodeManager.incBytecodes(1);
                                return;
                            }
                            final int n3 = 1;
                            BytecodeManager.incBytecodes(3);
                            this.addToPendingCount(n3);
                            final int batch2 = this.batch >>> 1;
                            this.batch = batch2;
                            final int baseLimit2 = n;
                            this.baseLimit = baseLimit2;
                            final int n4 = baseLimit;
                            final Node<K, V>[] tab = this.tab;
                            final Function<? super K, ? extends U> function2 = searchFunction;
                            final AtomicReference<U> atomicReference3 = result;
                            BytecodeManager.incBytecodes(20);
                            final SearchKeysTask searchKeysTask = new SearchKeysTask((BulkTask<Object, Object, ?>)this, batch2, baseLimit2, n4, (Node<Object, Object>[])tab, (Function<? super Object, ?>)function2, (AtomicReference<Object>)atomicReference3);
                            BytecodeManager.incBytecodes(1);
                            searchKeysTask.fork();
                            BytecodeManager.incBytecodes(2);
                        }
                        while (true) {
                            final AtomicReference<U> atomicReference4 = result;
                            BytecodeManager.incBytecodes(2);
                            final U value2 = atomicReference4.get();
                            BytecodeManager.incBytecodes(1);
                            if (value2 != null) {
                                break;
                            }
                            BytecodeManager.incBytecodes(2);
                            final Node<K, V> advance = this.advance();
                            BytecodeManager.incBytecodes(3);
                            if (advance == null) {
                                BytecodeManager.incBytecodes(2);
                                this.propagateCompletion();
                                BytecodeManager.incBytecodes(1);
                                break;
                            }
                            final Function<? super K, ? extends U> function3 = searchFunction;
                            final K key = advance.key;
                            BytecodeManager.incBytecodes(4);
                            final U apply = (U)function3.apply(key);
                            BytecodeManager.incBytecodes(3);
                            if (apply != null) {
                                final AtomicReference<U> atomicReference5 = result;
                                final U u = null;
                                final U u2 = apply;
                                BytecodeManager.incBytecodes(4);
                                final boolean compareAndSet = atomicReference5.compareAndSet(u, u2);
                                BytecodeManager.incBytecodes(1);
                                if (compareAndSet) {
                                    BytecodeManager.incBytecodes(2);
                                    this.quietlyCompleteRoot();
                                    BytecodeManager.incBytecodes(1);
                                    break;
                                }
                                break;
                            }
                            else {
                                BytecodeManager.incBytecodes(1);
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
    }
    
    static final class SearchValuesTask<K, V, U> extends BulkTask<K, V, U>
    {
        final Function<? super V, ? extends U> searchFunction;
        final AtomicReference<U> result;
        
        SearchValuesTask(final BulkTask<K, V, ?> bulkTask, final int n, final int n2, final int n3, final Node<K, V>[] array, final Function<? super V, ? extends U> searchFunction, final AtomicReference<U> result) {
            try {
                BytecodeManager.incBytecodes(7);
                super(bulkTask, n, n2, n3, array);
                this.searchFunction = searchFunction;
                this.result = result;
                BytecodeManager.incBytecodes(6);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final U getRawResult() {
            try {
                final AtomicReference<U> result = this.result;
                BytecodeManager.incBytecodes(3);
                final U value = result.get();
                BytecodeManager.incBytecodes(1);
                return value;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final void compute() {
            try {
                final Function<? super V, ? extends U> searchFunction;
                final Function<? super V, ? extends U> function = searchFunction = this.searchFunction;
                BytecodeManager.incBytecodes(5);
                if (function != null) {
                    final AtomicReference<U> result;
                    final AtomicReference<U> atomicReference = result = this.result;
                    BytecodeManager.incBytecodes(5);
                    if (atomicReference != null) {
                        final int baseIndex = this.baseIndex;
                        BytecodeManager.incBytecodes(3);
                        while (true) {
                            final int batch = this.batch;
                            BytecodeManager.incBytecodes(3);
                            if (batch <= 0) {
                                break;
                            }
                            final int baseLimit;
                            final int n = (baseLimit = this.baseLimit) + baseIndex >>> 1;
                            final int n2 = baseIndex;
                            BytecodeManager.incBytecodes(12);
                            if (n <= n2) {
                                break;
                            }
                            final AtomicReference<U> atomicReference2 = result;
                            BytecodeManager.incBytecodes(2);
                            final U value = atomicReference2.get();
                            BytecodeManager.incBytecodes(1);
                            if (value != null) {
                                BytecodeManager.incBytecodes(1);
                                return;
                            }
                            final int n3 = 1;
                            BytecodeManager.incBytecodes(3);
                            this.addToPendingCount(n3);
                            final int batch2 = this.batch >>> 1;
                            this.batch = batch2;
                            final int baseLimit2 = n;
                            this.baseLimit = baseLimit2;
                            final int n4 = baseLimit;
                            final Node<K, V>[] tab = this.tab;
                            final Function<? super V, ? extends U> function2 = searchFunction;
                            final AtomicReference<U> atomicReference3 = result;
                            BytecodeManager.incBytecodes(20);
                            final SearchValuesTask searchValuesTask = new SearchValuesTask((BulkTask<Object, Object, ?>)this, batch2, baseLimit2, n4, (Node<Object, Object>[])tab, (Function<? super Object, ?>)function2, (AtomicReference<Object>)atomicReference3);
                            BytecodeManager.incBytecodes(1);
                            searchValuesTask.fork();
                            BytecodeManager.incBytecodes(2);
                        }
                        while (true) {
                            final AtomicReference<U> atomicReference4 = result;
                            BytecodeManager.incBytecodes(2);
                            final U value2 = atomicReference4.get();
                            BytecodeManager.incBytecodes(1);
                            if (value2 != null) {
                                break;
                            }
                            BytecodeManager.incBytecodes(2);
                            final Node<K, V> advance = this.advance();
                            BytecodeManager.incBytecodes(3);
                            if (advance == null) {
                                BytecodeManager.incBytecodes(2);
                                this.propagateCompletion();
                                BytecodeManager.incBytecodes(1);
                                break;
                            }
                            final Function<? super V, ? extends U> function3 = searchFunction;
                            final V val = advance.val;
                            BytecodeManager.incBytecodes(4);
                            final U apply = (U)function3.apply(val);
                            BytecodeManager.incBytecodes(3);
                            if (apply != null) {
                                final AtomicReference<U> atomicReference5 = result;
                                final U u = null;
                                final U u2 = apply;
                                BytecodeManager.incBytecodes(4);
                                final boolean compareAndSet = atomicReference5.compareAndSet(u, u2);
                                BytecodeManager.incBytecodes(1);
                                if (compareAndSet) {
                                    BytecodeManager.incBytecodes(2);
                                    this.quietlyCompleteRoot();
                                    BytecodeManager.incBytecodes(1);
                                    break;
                                }
                                break;
                            }
                            else {
                                BytecodeManager.incBytecodes(1);
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
    }
    
    static final class SearchEntriesTask<K, V, U> extends BulkTask<K, V, U>
    {
        final Function<Map.Entry<K, V>, ? extends U> searchFunction;
        final AtomicReference<U> result;
        
        SearchEntriesTask(final BulkTask<K, V, ?> bulkTask, final int n, final int n2, final int n3, final Node<K, V>[] array, final Function<Map.Entry<K, V>, ? extends U> searchFunction, final AtomicReference<U> result) {
            try {
                BytecodeManager.incBytecodes(7);
                super(bulkTask, n, n2, n3, array);
                this.searchFunction = searchFunction;
                this.result = result;
                BytecodeManager.incBytecodes(6);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final U getRawResult() {
            try {
                final AtomicReference<U> result = this.result;
                BytecodeManager.incBytecodes(3);
                final U value = result.get();
                BytecodeManager.incBytecodes(1);
                return value;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final void compute() {
            try {
                final Function<Map.Entry<K, V>, ? extends U> searchFunction;
                final Function<Map.Entry<K, V>, ? extends U> function = searchFunction = this.searchFunction;
                BytecodeManager.incBytecodes(5);
                if (function != null) {
                    final AtomicReference<U> result;
                    final AtomicReference<U> atomicReference = result = this.result;
                    BytecodeManager.incBytecodes(5);
                    if (atomicReference != null) {
                        final int baseIndex = this.baseIndex;
                        BytecodeManager.incBytecodes(3);
                        while (true) {
                            final int batch = this.batch;
                            BytecodeManager.incBytecodes(3);
                            if (batch <= 0) {
                                break;
                            }
                            final int baseLimit;
                            final int n = (baseLimit = this.baseLimit) + baseIndex >>> 1;
                            final int n2 = baseIndex;
                            BytecodeManager.incBytecodes(12);
                            if (n <= n2) {
                                break;
                            }
                            final AtomicReference<U> atomicReference2 = result;
                            BytecodeManager.incBytecodes(2);
                            final U value = atomicReference2.get();
                            BytecodeManager.incBytecodes(1);
                            if (value != null) {
                                BytecodeManager.incBytecodes(1);
                                return;
                            }
                            final int n3 = 1;
                            BytecodeManager.incBytecodes(3);
                            this.addToPendingCount(n3);
                            final int batch2 = this.batch >>> 1;
                            this.batch = batch2;
                            final int baseLimit2 = n;
                            this.baseLimit = baseLimit2;
                            final int n4 = baseLimit;
                            final Node<K, V>[] tab = this.tab;
                            final Function<Map.Entry<K, V>, ? extends U> function2 = searchFunction;
                            final AtomicReference<U> atomicReference3 = result;
                            BytecodeManager.incBytecodes(20);
                            final SearchEntriesTask searchEntriesTask = new SearchEntriesTask((BulkTask<Object, Object, ?>)this, batch2, baseLimit2, n4, (Node<Object, Object>[])tab, (Function<Map.Entry<Object, Object>, ?>)function2, (AtomicReference<Object>)atomicReference3);
                            BytecodeManager.incBytecodes(1);
                            searchEntriesTask.fork();
                            BytecodeManager.incBytecodes(2);
                        }
                        while (true) {
                            final AtomicReference<U> atomicReference4 = result;
                            BytecodeManager.incBytecodes(2);
                            final U value2 = atomicReference4.get();
                            BytecodeManager.incBytecodes(1);
                            if (value2 != null) {
                                break;
                            }
                            BytecodeManager.incBytecodes(2);
                            final Node<Object, Object> advance = this.advance();
                            BytecodeManager.incBytecodes(3);
                            if (advance == null) {
                                BytecodeManager.incBytecodes(2);
                                this.propagateCompletion();
                                BytecodeManager.incBytecodes(1);
                                break;
                            }
                            final Function<Map.Entry<K, V>, ? extends U> function3 = searchFunction;
                            final Node<Object, Object> node = advance;
                            BytecodeManager.incBytecodes(3);
                            final U apply = (U)function3.apply((Map.Entry<K, V>)node);
                            BytecodeManager.incBytecodes(3);
                            if (apply != null) {
                                final AtomicReference<U> atomicReference5 = result;
                                final U u = null;
                                final U u2 = apply;
                                BytecodeManager.incBytecodes(4);
                                final boolean compareAndSet = atomicReference5.compareAndSet(u, u2);
                                BytecodeManager.incBytecodes(1);
                                if (compareAndSet) {
                                    BytecodeManager.incBytecodes(2);
                                    this.quietlyCompleteRoot();
                                }
                                BytecodeManager.incBytecodes(1);
                                return;
                            }
                            BytecodeManager.incBytecodes(1);
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
    
    static final class SearchMappingsTask<K, V, U> extends BulkTask<K, V, U>
    {
        final BiFunction<? super K, ? super V, ? extends U> searchFunction;
        final AtomicReference<U> result;
        
        SearchMappingsTask(final BulkTask<K, V, ?> bulkTask, final int n, final int n2, final int n3, final Node<K, V>[] array, final BiFunction<? super K, ? super V, ? extends U> searchFunction, final AtomicReference<U> result) {
            try {
                BytecodeManager.incBytecodes(7);
                super(bulkTask, n, n2, n3, array);
                this.searchFunction = searchFunction;
                this.result = result;
                BytecodeManager.incBytecodes(6);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final U getRawResult() {
            try {
                final AtomicReference<U> result = this.result;
                BytecodeManager.incBytecodes(3);
                final U value = result.get();
                BytecodeManager.incBytecodes(1);
                return value;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final void compute() {
            try {
                final BiFunction<? super K, ? super V, ? extends U> searchFunction;
                final BiFunction<? super K, ? super V, ? extends U> biFunction = searchFunction = this.searchFunction;
                BytecodeManager.incBytecodes(5);
                if (biFunction != null) {
                    final AtomicReference<U> result;
                    final AtomicReference<U> atomicReference = result = this.result;
                    BytecodeManager.incBytecodes(5);
                    if (atomicReference != null) {
                        final int baseIndex = this.baseIndex;
                        BytecodeManager.incBytecodes(3);
                        while (true) {
                            final int batch = this.batch;
                            BytecodeManager.incBytecodes(3);
                            if (batch <= 0) {
                                break;
                            }
                            final int baseLimit;
                            final int n = (baseLimit = this.baseLimit) + baseIndex >>> 1;
                            final int n2 = baseIndex;
                            BytecodeManager.incBytecodes(12);
                            if (n <= n2) {
                                break;
                            }
                            final AtomicReference<U> atomicReference2 = result;
                            BytecodeManager.incBytecodes(2);
                            final U value = atomicReference2.get();
                            BytecodeManager.incBytecodes(1);
                            if (value != null) {
                                BytecodeManager.incBytecodes(1);
                                return;
                            }
                            final int n3 = 1;
                            BytecodeManager.incBytecodes(3);
                            this.addToPendingCount(n3);
                            final int batch2 = this.batch >>> 1;
                            this.batch = batch2;
                            final int baseLimit2 = n;
                            this.baseLimit = baseLimit2;
                            final int n4 = baseLimit;
                            final Node<K, V>[] tab = this.tab;
                            final BiFunction<? super K, ? super V, ? extends U> biFunction2 = searchFunction;
                            final AtomicReference<U> atomicReference3 = result;
                            BytecodeManager.incBytecodes(20);
                            final SearchMappingsTask searchMappingsTask = new SearchMappingsTask((BulkTask<Object, Object, ?>)this, batch2, baseLimit2, n4, (Node<Object, Object>[])tab, (BiFunction<? super Object, ? super Object, ?>)biFunction2, (AtomicReference<Object>)atomicReference3);
                            BytecodeManager.incBytecodes(1);
                            searchMappingsTask.fork();
                            BytecodeManager.incBytecodes(2);
                        }
                        while (true) {
                            final AtomicReference<U> atomicReference4 = result;
                            BytecodeManager.incBytecodes(2);
                            final U value2 = atomicReference4.get();
                            BytecodeManager.incBytecodes(1);
                            if (value2 != null) {
                                break;
                            }
                            BytecodeManager.incBytecodes(2);
                            final Node<K, V> advance;
                            final Node<K, V> node = advance = this.advance();
                            BytecodeManager.incBytecodes(3);
                            if (node == null) {
                                BytecodeManager.incBytecodes(2);
                                this.propagateCompletion();
                                BytecodeManager.incBytecodes(1);
                                break;
                            }
                            final BiFunction<? super K, ? super V, ? extends U> biFunction3 = searchFunction;
                            final K key = advance.key;
                            final V val = advance.val;
                            BytecodeManager.incBytecodes(6);
                            final U apply = (U)biFunction3.apply(key, val);
                            BytecodeManager.incBytecodes(3);
                            if (apply != null) {
                                final AtomicReference<U> atomicReference5 = result;
                                final U u = null;
                                final U u2 = apply;
                                BytecodeManager.incBytecodes(4);
                                final boolean compareAndSet = atomicReference5.compareAndSet(u, u2);
                                BytecodeManager.incBytecodes(1);
                                if (compareAndSet) {
                                    BytecodeManager.incBytecodes(2);
                                    this.quietlyCompleteRoot();
                                    BytecodeManager.incBytecodes(1);
                                    break;
                                }
                                break;
                            }
                            else {
                                BytecodeManager.incBytecodes(1);
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
    }
    
    static final class ReduceKeysTask<K, V> extends BulkTask<K, V, K>
    {
        final BiFunction<? super K, ? super K, ? extends K> reducer;
        K result;
        ReduceKeysTask<K, V> rights;
        ReduceKeysTask<K, V> nextRight;
        
        ReduceKeysTask(final BulkTask<K, V, ?> bulkTask, final int n, final int n2, final int n3, final Node<K, V>[] array, final ReduceKeysTask<K, V> nextRight, final BiFunction<? super K, ? super K, ? extends K> reducer) {
            try {
                BytecodeManager.incBytecodes(7);
                super(bulkTask, n, n2, n3, array);
                this.nextRight = nextRight;
                BytecodeManager.incBytecodes(3);
                this.reducer = reducer;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final K getRawResult() {
            try {
                final K result = this.result;
                BytecodeManager.incBytecodes(3);
                return result;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final void compute() {
            try {
                final BiFunction<? super K, ? super K, ? extends K> reducer;
                final BiFunction<? super K, ? super K, ? extends K> biFunction = reducer = this.reducer;
                BytecodeManager.incBytecodes(5);
                if (biFunction != null) {
                    final int baseIndex = this.baseIndex;
                    BytecodeManager.incBytecodes(3);
                    while (true) {
                        final int batch = this.batch;
                        BytecodeManager.incBytecodes(3);
                        if (batch <= 0) {
                            break;
                        }
                        final int baseLimit;
                        final int n = (baseLimit = this.baseLimit) + baseIndex >>> 1;
                        final int n2 = baseIndex;
                        BytecodeManager.incBytecodes(12);
                        if (n <= n2) {
                            break;
                        }
                        final int n3 = 1;
                        BytecodeManager.incBytecodes(3);
                        this.addToPendingCount(n3);
                        final int batch2 = this.batch >>> 1;
                        this.batch = batch2;
                        final int baseLimit2 = n;
                        this.baseLimit = baseLimit2;
                        final int n4 = baseLimit;
                        final Node<K, V>[] tab = this.tab;
                        final ReduceKeysTask<K, V> rights = this.rights;
                        final BiFunction<? super K, ? super K, ? extends K> biFunction2 = reducer;
                        BytecodeManager.incBytecodes(22);
                        final ReduceKeysTask rights2 = new ReduceKeysTask<K, V>(this, batch2, baseLimit2, n4, (Node<K, V>[])tab, rights, biFunction2);
                        this.rights = rights2;
                        BytecodeManager.incBytecodes(2);
                        BytecodeManager.incBytecodes(1);
                        rights2.fork();
                        BytecodeManager.incBytecodes(2);
                    }
                    Object result = null;
                    BytecodeManager.incBytecodes(2);
                    while (true) {
                        BytecodeManager.incBytecodes(2);
                        final Node<K, V> advance = this.advance();
                        BytecodeManager.incBytecodes(3);
                        if (advance == null) {
                            break;
                        }
                        final K key = advance.key;
                        BytecodeManager.incBytecodes(3);
                        final K k = (K)result;
                        BytecodeManager.incBytecodes(2);
                        K apply;
                        if (k == null) {
                            apply = key;
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            final K i = key;
                            BytecodeManager.incBytecodes(2);
                            if (i == null) {
                                apply = (K)result;
                                BytecodeManager.incBytecodes(2);
                            }
                            else {
                                final BiFunction<? super K, ? super K, ? extends K> biFunction3 = reducer;
                                final K j = (K)result;
                                final K l = key;
                                BytecodeManager.incBytecodes(4);
                                apply = (K)biFunction3.apply(j, l);
                            }
                        }
                        result = apply;
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                    }
                    this.result = (K)result;
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(2);
                    CountedCompleter<?> countedCompleter = this.firstComplete();
                    BytecodeManager.incBytecodes(1);
                    while (true) {
                        final CountedCompleter<?> countedCompleter2 = countedCompleter;
                        BytecodeManager.incBytecodes(2);
                        if (countedCompleter2 == null) {
                            break;
                        }
                        final ReduceKeysTask<?, ?> reduceKeysTask = (ReduceKeysTask<?, ?>)countedCompleter;
                        BytecodeManager.incBytecodes(3);
                        ReduceKeysTask<?, ?> rights3 = reduceKeysTask.rights;
                        BytecodeManager.incBytecodes(3);
                        while (true) {
                            final ReduceKeysTask<?, ?> reduceKeysTask2 = rights3;
                            BytecodeManager.incBytecodes(2);
                            if (reduceKeysTask2 == null) {
                                break;
                            }
                            final Object result2;
                            final Object o = result2 = rights3.result;
                            BytecodeManager.incBytecodes(5);
                            if (o != null) {
                                final ReduceKeysTask<?, ?> reduceKeysTask3 = reduceKeysTask;
                                final Object result3 = reduceKeysTask.result;
                                BytecodeManager.incBytecodes(6);
                                Object apply2;
                                if (result3 == null) {
                                    apply2 = result2;
                                    BytecodeManager.incBytecodes(2);
                                }
                                else {
                                    final BiFunction<? super K, ? super K, ? extends K> biFunction4 = reducer;
                                    final Object o2 = result3;
                                    final Object o3 = result2;
                                    BytecodeManager.incBytecodes(3);
                                    BytecodeManager.incBytecodes(1);
                                    apply2 = biFunction4.apply((K)o2, (K)o3);
                                }
                                reduceKeysTask3.result = apply2;
                                BytecodeManager.incBytecodes(1);
                            }
                            final ReduceKeysTask<?, ?> reduceKeysTask4 = reduceKeysTask;
                            final ReduceKeysTask<?, ?> nextRight = rights3.nextRight;
                            reduceKeysTask4.rights = nextRight;
                            rights3 = nextRight;
                            BytecodeManager.incBytecodes(6);
                            BytecodeManager.incBytecodes(1);
                        }
                        final ReduceKeysTask<?, ?> reduceKeysTask5 = (ReduceKeysTask<?, ?>)countedCompleter;
                        BytecodeManager.incBytecodes(2);
                        countedCompleter = reduceKeysTask5.nextComplete();
                        BytecodeManager.incBytecodes(2);
                    }
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class ReduceValuesTask<K, V> extends BulkTask<K, V, V>
    {
        final BiFunction<? super V, ? super V, ? extends V> reducer;
        V result;
        ReduceValuesTask<K, V> rights;
        ReduceValuesTask<K, V> nextRight;
        
        ReduceValuesTask(final BulkTask<K, V, ?> bulkTask, final int n, final int n2, final int n3, final Node<K, V>[] array, final ReduceValuesTask<K, V> nextRight, final BiFunction<? super V, ? super V, ? extends V> reducer) {
            try {
                BytecodeManager.incBytecodes(7);
                super(bulkTask, n, n2, n3, array);
                this.nextRight = nextRight;
                BytecodeManager.incBytecodes(3);
                this.reducer = reducer;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final V getRawResult() {
            try {
                final V result = this.result;
                BytecodeManager.incBytecodes(3);
                return result;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final void compute() {
            try {
                final BiFunction<? super V, ? super V, ? extends V> reducer;
                final BiFunction<? super V, ? super V, ? extends V> biFunction = reducer = this.reducer;
                BytecodeManager.incBytecodes(5);
                if (biFunction != null) {
                    final int baseIndex = this.baseIndex;
                    BytecodeManager.incBytecodes(3);
                    while (true) {
                        final int batch = this.batch;
                        BytecodeManager.incBytecodes(3);
                        if (batch <= 0) {
                            break;
                        }
                        final int baseLimit;
                        final int n = (baseLimit = this.baseLimit) + baseIndex >>> 1;
                        final int n2 = baseIndex;
                        BytecodeManager.incBytecodes(12);
                        if (n <= n2) {
                            break;
                        }
                        final int n3 = 1;
                        BytecodeManager.incBytecodes(3);
                        this.addToPendingCount(n3);
                        final int batch2 = this.batch >>> 1;
                        this.batch = batch2;
                        final int baseLimit2 = n;
                        this.baseLimit = baseLimit2;
                        final int n4 = baseLimit;
                        final Node<K, V>[] tab = this.tab;
                        final ReduceValuesTask<K, V> rights = this.rights;
                        final BiFunction<? super V, ? super V, ? extends V> biFunction2 = reducer;
                        BytecodeManager.incBytecodes(22);
                        final ReduceValuesTask rights2 = new ReduceValuesTask<K, V>(this, batch2, baseLimit2, n4, (Node<K, V>[])tab, rights, biFunction2);
                        this.rights = rights2;
                        BytecodeManager.incBytecodes(2);
                        BytecodeManager.incBytecodes(1);
                        rights2.fork();
                        BytecodeManager.incBytecodes(2);
                    }
                    Object result = null;
                    BytecodeManager.incBytecodes(2);
                    while (true) {
                        BytecodeManager.incBytecodes(2);
                        final Node<K, V> advance = this.advance();
                        BytecodeManager.incBytecodes(3);
                        if (advance == null) {
                            break;
                        }
                        final V val = advance.val;
                        BytecodeManager.incBytecodes(3);
                        final Object o = result;
                        BytecodeManager.incBytecodes(2);
                        V apply;
                        if (o == null) {
                            apply = val;
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            final BiFunction<? super V, ? super V, ? extends V> biFunction3 = reducer;
                            final Object o2 = result;
                            final V v = val;
                            BytecodeManager.incBytecodes(4);
                            apply = (V)biFunction3.apply((V)o2, v);
                        }
                        result = apply;
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                    }
                    this.result = (V)result;
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(2);
                    CountedCompleter<?> countedCompleter = this.firstComplete();
                    BytecodeManager.incBytecodes(1);
                    while (true) {
                        final CountedCompleter<?> countedCompleter2 = countedCompleter;
                        BytecodeManager.incBytecodes(2);
                        if (countedCompleter2 == null) {
                            break;
                        }
                        final ReduceValuesTask<?, ?> reduceValuesTask = (ReduceValuesTask<?, ?>)countedCompleter;
                        BytecodeManager.incBytecodes(3);
                        ReduceValuesTask<?, ?> rights3 = reduceValuesTask.rights;
                        BytecodeManager.incBytecodes(3);
                        while (true) {
                            final ReduceValuesTask<?, ?> reduceValuesTask2 = rights3;
                            BytecodeManager.incBytecodes(2);
                            if (reduceValuesTask2 == null) {
                                break;
                            }
                            final Object result2;
                            final Object o3 = result2 = rights3.result;
                            BytecodeManager.incBytecodes(5);
                            if (o3 != null) {
                                final ReduceValuesTask<?, ?> reduceValuesTask3 = reduceValuesTask;
                                final Object result3 = reduceValuesTask.result;
                                BytecodeManager.incBytecodes(6);
                                Object apply2;
                                if (result3 == null) {
                                    apply2 = result2;
                                    BytecodeManager.incBytecodes(2);
                                }
                                else {
                                    final BiFunction<? super V, ? super V, ? extends V> biFunction4 = reducer;
                                    final Object o4 = result3;
                                    final Object o5 = result2;
                                    BytecodeManager.incBytecodes(3);
                                    BytecodeManager.incBytecodes(1);
                                    apply2 = biFunction4.apply((V)o4, (V)o5);
                                }
                                reduceValuesTask3.result = apply2;
                                BytecodeManager.incBytecodes(1);
                            }
                            final ReduceValuesTask<?, ?> reduceValuesTask4 = reduceValuesTask;
                            final ReduceValuesTask<?, ?> nextRight = rights3.nextRight;
                            reduceValuesTask4.rights = nextRight;
                            rights3 = nextRight;
                            BytecodeManager.incBytecodes(6);
                            BytecodeManager.incBytecodes(1);
                        }
                        final ReduceValuesTask<?, ?> reduceValuesTask5 = (ReduceValuesTask<?, ?>)countedCompleter;
                        BytecodeManager.incBytecodes(2);
                        countedCompleter = reduceValuesTask5.nextComplete();
                        BytecodeManager.incBytecodes(2);
                    }
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class ReduceEntriesTask<K, V> extends BulkTask<K, V, Map.Entry<K, V>>
    {
        final BiFunction<Map.Entry<K, V>, Map.Entry<K, V>, ? extends Map.Entry<K, V>> reducer;
        Map.Entry<K, V> result;
        ReduceEntriesTask<K, V> rights;
        ReduceEntriesTask<K, V> nextRight;
        
        ReduceEntriesTask(final BulkTask<K, V, ?> bulkTask, final int n, final int n2, final int n3, final Node<K, V>[] array, final ReduceEntriesTask<K, V> nextRight, final BiFunction<Map.Entry<K, V>, Map.Entry<K, V>, ? extends Map.Entry<K, V>> reducer) {
            try {
                BytecodeManager.incBytecodes(7);
                super(bulkTask, n, n2, n3, array);
                this.nextRight = nextRight;
                BytecodeManager.incBytecodes(3);
                this.reducer = reducer;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final Map.Entry<K, V> getRawResult() {
            try {
                final Map.Entry<K, V> result = this.result;
                BytecodeManager.incBytecodes(3);
                return result;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final void compute() {
            try {
                final BiFunction<Map.Entry<K, V>, Map.Entry<K, V>, ? extends Map.Entry<K, V>> reducer;
                final BiFunction<Map.Entry<K, V>, Map.Entry<K, V>, ? extends Map.Entry<K, V>> biFunction = reducer = this.reducer;
                BytecodeManager.incBytecodes(5);
                if (biFunction != null) {
                    final int baseIndex = this.baseIndex;
                    BytecodeManager.incBytecodes(3);
                    while (true) {
                        final int batch = this.batch;
                        BytecodeManager.incBytecodes(3);
                        if (batch <= 0) {
                            break;
                        }
                        final int baseLimit;
                        final int n = (baseLimit = this.baseLimit) + baseIndex >>> 1;
                        final int n2 = baseIndex;
                        BytecodeManager.incBytecodes(12);
                        if (n <= n2) {
                            break;
                        }
                        final int n3 = 1;
                        BytecodeManager.incBytecodes(3);
                        this.addToPendingCount(n3);
                        final int batch2 = this.batch >>> 1;
                        this.batch = batch2;
                        final int baseLimit2 = n;
                        this.baseLimit = baseLimit2;
                        final int n4 = baseLimit;
                        final Node<K, V>[] tab = this.tab;
                        final ReduceEntriesTask<K, V> rights = this.rights;
                        final BiFunction<Map.Entry<Object, Object>, Map.Entry<Object, Object>, ? extends Map.Entry<Object, Object>> biFunction2 = (BiFunction<Map.Entry<Object, Object>, Map.Entry<Object, Object>, ? extends Map.Entry<Object, Object>>)reducer;
                        BytecodeManager.incBytecodes(22);
                        final ReduceEntriesTask rights2 = new ReduceEntriesTask<K, V>(this, batch2, baseLimit2, n4, (Node<K, V>[])tab, rights, (BiFunction<Map.Entry<K, V>, Map.Entry<K, V>, ? extends Map.Entry<K, V>>)biFunction2);
                        this.rights = rights2;
                        BytecodeManager.incBytecodes(2);
                        BytecodeManager.incBytecodes(1);
                        rights2.fork();
                        BytecodeManager.incBytecodes(2);
                    }
                    Map.Entry<Object, Object> result = null;
                    BytecodeManager.incBytecodes(2);
                    while (true) {
                        BytecodeManager.incBytecodes(2);
                        final Node<Object, Object> advance;
                        final Node<K, V> node = (Node<K, V>)(advance = (Node<Object, Object>)this.advance());
                        BytecodeManager.incBytecodes(3);
                        if (node == null) {
                            break;
                        }
                        final Map.Entry<Object, Object> entry = result;
                        BytecodeManager.incBytecodes(2);
                        Object o;
                        if (entry == null) {
                            o = advance;
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            final BiFunction<Map.Entry<K, V>, Map.Entry<K, V>, ? extends Map.Entry<K, V>> biFunction3 = reducer;
                            final Map.Entry<Object, Object> entry2 = result;
                            final Map.Entry<K, V> entry3 = (Map.Entry<K, V>)advance;
                            BytecodeManager.incBytecodes(4);
                            o = (Map.Entry<Object, Object>)biFunction3.apply((Map.Entry<K, V>)entry2, entry3);
                            BytecodeManager.incBytecodes(1);
                        }
                        result = (Map.Entry<Object, Object>)o;
                        BytecodeManager.incBytecodes(2);
                    }
                    this.result = (Map.Entry<K, V>)result;
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(2);
                    CountedCompleter<?> countedCompleter = this.firstComplete();
                    BytecodeManager.incBytecodes(1);
                    while (true) {
                        final CountedCompleter<?> countedCompleter2 = countedCompleter;
                        BytecodeManager.incBytecodes(2);
                        if (countedCompleter2 == null) {
                            break;
                        }
                        final ReduceEntriesTask<?, ?> reduceEntriesTask = (ReduceEntriesTask<?, ?>)countedCompleter;
                        BytecodeManager.incBytecodes(3);
                        ReduceEntriesTask<?, ?> rights3 = reduceEntriesTask.rights;
                        BytecodeManager.incBytecodes(3);
                        while (true) {
                            final ReduceEntriesTask<?, ?> reduceEntriesTask2 = rights3;
                            BytecodeManager.incBytecodes(2);
                            if (reduceEntriesTask2 == null) {
                                break;
                            }
                            final Map.Entry<?, ?> result2;
                            final Map.Entry<?, ?> entry4 = result2 = rights3.result;
                            BytecodeManager.incBytecodes(5);
                            if (entry4 != null) {
                                final ReduceEntriesTask<?, ?> reduceEntriesTask3 = reduceEntriesTask;
                                final Map.Entry<?, ?> result3 = reduceEntriesTask.result;
                                BytecodeManager.incBytecodes(6);
                                Map.Entry<?, ?> result4;
                                if (result3 == null) {
                                    result4 = result2;
                                    BytecodeManager.incBytecodes(2);
                                }
                                else {
                                    final BiFunction<Map.Entry<K, V>, Map.Entry<K, V>, ? extends Map.Entry<K, V>> biFunction4 = reducer;
                                    final Map.Entry<?, ?> entry5 = result3;
                                    final Map.Entry<?, ?> entry6 = result2;
                                    BytecodeManager.incBytecodes(3);
                                    BytecodeManager.incBytecodes(1);
                                    result4 = (Map.Entry<K, V>)biFunction4.apply((Map.Entry<K, V>)entry5, (Map.Entry<K, V>)entry6);
                                    BytecodeManager.incBytecodes(1);
                                }
                                reduceEntriesTask3.result = result4;
                                BytecodeManager.incBytecodes(1);
                            }
                            final ReduceEntriesTask<?, ?> reduceEntriesTask4 = reduceEntriesTask;
                            final ReduceEntriesTask<?, ?> nextRight = rights3.nextRight;
                            reduceEntriesTask4.rights = nextRight;
                            rights3 = nextRight;
                            BytecodeManager.incBytecodes(6);
                            BytecodeManager.incBytecodes(1);
                        }
                        final ReduceEntriesTask<?, ?> reduceEntriesTask5 = (ReduceEntriesTask<?, ?>)countedCompleter;
                        BytecodeManager.incBytecodes(2);
                        countedCompleter = reduceEntriesTask5.nextComplete();
                        BytecodeManager.incBytecodes(2);
                    }
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class MapReduceKeysTask<K, V, U> extends BulkTask<K, V, U>
    {
        final Function<? super K, ? extends U> transformer;
        final BiFunction<? super U, ? super U, ? extends U> reducer;
        U result;
        MapReduceKeysTask<K, V, U> rights;
        MapReduceKeysTask<K, V, U> nextRight;
        
        MapReduceKeysTask(final BulkTask<K, V, ?> bulkTask, final int n, final int n2, final int n3, final Node<K, V>[] array, final MapReduceKeysTask<K, V, U> nextRight, final Function<? super K, ? extends U> transformer, final BiFunction<? super U, ? super U, ? extends U> reducer) {
            try {
                BytecodeManager.incBytecodes(7);
                super(bulkTask, n, n2, n3, array);
                this.nextRight = nextRight;
                BytecodeManager.incBytecodes(3);
                this.transformer = transformer;
                BytecodeManager.incBytecodes(3);
                this.reducer = reducer;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final U getRawResult() {
            try {
                final U result = this.result;
                BytecodeManager.incBytecodes(3);
                return result;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final void compute() {
            try {
                final Function<? super K, ? extends U> transformer;
                final Function<? super K, ? extends U> function = transformer = this.transformer;
                BytecodeManager.incBytecodes(5);
                if (function != null) {
                    final BiFunction<? super U, ? super U, ? extends U> reducer;
                    final BiFunction<? super U, ? super U, ? extends U> biFunction = reducer = this.reducer;
                    BytecodeManager.incBytecodes(5);
                    if (biFunction != null) {
                        final int baseIndex = this.baseIndex;
                        BytecodeManager.incBytecodes(3);
                        while (true) {
                            final int batch = this.batch;
                            BytecodeManager.incBytecodes(3);
                            if (batch <= 0) {
                                break;
                            }
                            final int baseLimit;
                            final int n = (baseLimit = this.baseLimit) + baseIndex >>> 1;
                            final int n2 = baseIndex;
                            BytecodeManager.incBytecodes(12);
                            if (n <= n2) {
                                break;
                            }
                            final int n3 = 1;
                            BytecodeManager.incBytecodes(3);
                            this.addToPendingCount(n3);
                            final int batch2 = this.batch >>> 1;
                            this.batch = batch2;
                            final int baseLimit2 = n;
                            this.baseLimit = baseLimit2;
                            final int n4 = baseLimit;
                            final Node<K, V>[] tab = this.tab;
                            final MapReduceKeysTask<K, V, U> rights = this.rights;
                            final Function<? super Object, ? extends U> function2 = (Function<? super Object, ? extends U>)transformer;
                            final BiFunction<? super U, ? super U, ? extends U> biFunction2 = reducer;
                            BytecodeManager.incBytecodes(23);
                            final MapReduceKeysTask rights2 = new MapReduceKeysTask<K, V, U>(this, batch2, baseLimit2, n4, tab, rights, function2, biFunction2);
                            this.rights = rights2;
                            BytecodeManager.incBytecodes(2);
                            BytecodeManager.incBytecodes(1);
                            rights2.fork();
                            BytecodeManager.incBytecodes(2);
                        }
                        Object result = null;
                        BytecodeManager.incBytecodes(2);
                        while (true) {
                            BytecodeManager.incBytecodes(2);
                            final Node<K, V> advance = this.advance();
                            BytecodeManager.incBytecodes(3);
                            if (advance == null) {
                                break;
                            }
                            final Function<K, ? extends U> function3 = (Function<K, ? extends U>)transformer;
                            final K key = advance.key;
                            BytecodeManager.incBytecodes(4);
                            final U apply;
                            final Object o = apply = (U)function3.apply(key);
                            BytecodeManager.incBytecodes(3);
                            if (o != null) {
                                final Object o2 = result;
                                BytecodeManager.incBytecodes(2);
                                U apply2;
                                if (o2 == null) {
                                    apply2 = apply;
                                    BytecodeManager.incBytecodes(2);
                                }
                                else {
                                    final BiFunction<? super U, ? super U, ? extends U> biFunction3 = reducer;
                                    final Object o3 = result;
                                    final U u = apply;
                                    BytecodeManager.incBytecodes(4);
                                    apply2 = (U)biFunction3.apply((U)o3, u);
                                }
                                result = apply2;
                                BytecodeManager.incBytecodes(1);
                            }
                            BytecodeManager.incBytecodes(1);
                        }
                        this.result = (U)result;
                        BytecodeManager.incBytecodes(3);
                        BytecodeManager.incBytecodes(2);
                        CountedCompleter<?> countedCompleter = this.firstComplete();
                        BytecodeManager.incBytecodes(1);
                        while (true) {
                            final CountedCompleter<?> countedCompleter2 = countedCompleter;
                            BytecodeManager.incBytecodes(2);
                            if (countedCompleter2 == null) {
                                break;
                            }
                            final MapReduceKeysTask<?, ?, ?> mapReduceKeysTask = (MapReduceKeysTask<?, ?, ?>)countedCompleter;
                            BytecodeManager.incBytecodes(3);
                            MapReduceKeysTask<?, ?, ?> rights3 = mapReduceKeysTask.rights;
                            BytecodeManager.incBytecodes(3);
                            while (true) {
                                final MapReduceKeysTask<?, ?, ?> mapReduceKeysTask2 = rights3;
                                BytecodeManager.incBytecodes(2);
                                if (mapReduceKeysTask2 == null) {
                                    break;
                                }
                                final Object result2;
                                final Object o4 = result2 = rights3.result;
                                BytecodeManager.incBytecodes(5);
                                if (o4 != null) {
                                    final MapReduceKeysTask<?, ?, ?> mapReduceKeysTask3 = mapReduceKeysTask;
                                    final Object result3 = mapReduceKeysTask.result;
                                    BytecodeManager.incBytecodes(6);
                                    Object apply3;
                                    if (result3 == null) {
                                        apply3 = result2;
                                        BytecodeManager.incBytecodes(2);
                                    }
                                    else {
                                        final BiFunction<? super U, ? super U, ? extends U> biFunction4 = reducer;
                                        final Object o5 = result3;
                                        final Object o6 = result2;
                                        BytecodeManager.incBytecodes(3);
                                        BytecodeManager.incBytecodes(1);
                                        apply3 = biFunction4.apply((U)o5, (U)o6);
                                    }
                                    mapReduceKeysTask3.result = apply3;
                                    BytecodeManager.incBytecodes(1);
                                }
                                final MapReduceKeysTask<?, ?, ?> mapReduceKeysTask4 = mapReduceKeysTask;
                                final MapReduceKeysTask<?, ?, ?> nextRight = rights3.nextRight;
                                mapReduceKeysTask4.rights = nextRight;
                                rights3 = nextRight;
                                BytecodeManager.incBytecodes(6);
                                BytecodeManager.incBytecodes(1);
                            }
                            final MapReduceKeysTask<?, ?, ?> mapReduceKeysTask5 = (MapReduceKeysTask<?, ?, ?>)countedCompleter;
                            BytecodeManager.incBytecodes(2);
                            countedCompleter = mapReduceKeysTask5.nextComplete();
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
    }
    
    static final class MapReduceValuesTask<K, V, U> extends BulkTask<K, V, U>
    {
        final Function<? super V, ? extends U> transformer;
        final BiFunction<? super U, ? super U, ? extends U> reducer;
        U result;
        MapReduceValuesTask<K, V, U> rights;
        MapReduceValuesTask<K, V, U> nextRight;
        
        MapReduceValuesTask(final BulkTask<K, V, ?> bulkTask, final int n, final int n2, final int n3, final Node<K, V>[] array, final MapReduceValuesTask<K, V, U> nextRight, final Function<? super V, ? extends U> transformer, final BiFunction<? super U, ? super U, ? extends U> reducer) {
            try {
                BytecodeManager.incBytecodes(7);
                super(bulkTask, n, n2, n3, array);
                this.nextRight = nextRight;
                BytecodeManager.incBytecodes(3);
                this.transformer = transformer;
                BytecodeManager.incBytecodes(3);
                this.reducer = reducer;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final U getRawResult() {
            try {
                final U result = this.result;
                BytecodeManager.incBytecodes(3);
                return result;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final void compute() {
            try {
                final Function<? super V, ? extends U> transformer;
                final Function<? super V, ? extends U> function = transformer = this.transformer;
                BytecodeManager.incBytecodes(5);
                if (function != null) {
                    final BiFunction<? super U, ? super U, ? extends U> reducer;
                    final BiFunction<? super U, ? super U, ? extends U> biFunction = reducer = this.reducer;
                    BytecodeManager.incBytecodes(5);
                    if (biFunction != null) {
                        final int baseIndex = this.baseIndex;
                        BytecodeManager.incBytecodes(3);
                        while (true) {
                            final int batch = this.batch;
                            BytecodeManager.incBytecodes(3);
                            if (batch <= 0) {
                                break;
                            }
                            final int baseLimit;
                            final int n = (baseLimit = this.baseLimit) + baseIndex >>> 1;
                            final int n2 = baseIndex;
                            BytecodeManager.incBytecodes(12);
                            if (n <= n2) {
                                break;
                            }
                            final int n3 = 1;
                            BytecodeManager.incBytecodes(3);
                            this.addToPendingCount(n3);
                            final int batch2 = this.batch >>> 1;
                            this.batch = batch2;
                            final int baseLimit2 = n;
                            this.baseLimit = baseLimit2;
                            final int n4 = baseLimit;
                            final Node<K, V>[] tab = this.tab;
                            final MapReduceValuesTask<K, V, U> rights = this.rights;
                            final Function<? super Object, ? extends U> function2 = (Function<? super Object, ? extends U>)transformer;
                            final BiFunction<? super U, ? super U, ? extends U> biFunction2 = reducer;
                            BytecodeManager.incBytecodes(23);
                            final MapReduceValuesTask rights2 = new MapReduceValuesTask<K, V, U>(this, batch2, baseLimit2, n4, tab, rights, function2, biFunction2);
                            this.rights = rights2;
                            BytecodeManager.incBytecodes(2);
                            BytecodeManager.incBytecodes(1);
                            rights2.fork();
                            BytecodeManager.incBytecodes(2);
                        }
                        Object result = null;
                        BytecodeManager.incBytecodes(2);
                        while (true) {
                            BytecodeManager.incBytecodes(2);
                            final Node<K, V> advance = this.advance();
                            BytecodeManager.incBytecodes(3);
                            if (advance == null) {
                                break;
                            }
                            final Function<V, ? extends U> function3 = (Function<V, ? extends U>)transformer;
                            final V val = advance.val;
                            BytecodeManager.incBytecodes(4);
                            final U apply;
                            final Object o = apply = (U)function3.apply(val);
                            BytecodeManager.incBytecodes(3);
                            if (o != null) {
                                final Object o2 = result;
                                BytecodeManager.incBytecodes(2);
                                U apply2;
                                if (o2 == null) {
                                    apply2 = apply;
                                    BytecodeManager.incBytecodes(2);
                                }
                                else {
                                    final BiFunction<? super U, ? super U, ? extends U> biFunction3 = reducer;
                                    final Object o3 = result;
                                    final U u = apply;
                                    BytecodeManager.incBytecodes(4);
                                    apply2 = (U)biFunction3.apply((U)o3, u);
                                }
                                result = apply2;
                                BytecodeManager.incBytecodes(1);
                            }
                            BytecodeManager.incBytecodes(1);
                        }
                        this.result = (U)result;
                        BytecodeManager.incBytecodes(3);
                        BytecodeManager.incBytecodes(2);
                        CountedCompleter<?> countedCompleter = this.firstComplete();
                        BytecodeManager.incBytecodes(1);
                        while (true) {
                            final CountedCompleter<?> countedCompleter2 = countedCompleter;
                            BytecodeManager.incBytecodes(2);
                            if (countedCompleter2 == null) {
                                break;
                            }
                            final MapReduceValuesTask<?, ?, ?> mapReduceValuesTask = (MapReduceValuesTask<?, ?, ?>)countedCompleter;
                            BytecodeManager.incBytecodes(3);
                            MapReduceValuesTask<?, ?, ?> rights3 = mapReduceValuesTask.rights;
                            BytecodeManager.incBytecodes(3);
                            while (true) {
                                final MapReduceValuesTask<?, ?, ?> mapReduceValuesTask2 = rights3;
                                BytecodeManager.incBytecodes(2);
                                if (mapReduceValuesTask2 == null) {
                                    break;
                                }
                                final Object result2;
                                final Object o4 = result2 = rights3.result;
                                BytecodeManager.incBytecodes(5);
                                if (o4 != null) {
                                    final MapReduceValuesTask<?, ?, ?> mapReduceValuesTask3 = mapReduceValuesTask;
                                    final Object result3 = mapReduceValuesTask.result;
                                    BytecodeManager.incBytecodes(6);
                                    Object apply3;
                                    if (result3 == null) {
                                        apply3 = result2;
                                        BytecodeManager.incBytecodes(2);
                                    }
                                    else {
                                        final BiFunction<? super U, ? super U, ? extends U> biFunction4 = reducer;
                                        final Object o5 = result3;
                                        final Object o6 = result2;
                                        BytecodeManager.incBytecodes(3);
                                        BytecodeManager.incBytecodes(1);
                                        apply3 = biFunction4.apply((U)o5, (U)o6);
                                    }
                                    mapReduceValuesTask3.result = apply3;
                                    BytecodeManager.incBytecodes(1);
                                }
                                final MapReduceValuesTask<?, ?, ?> mapReduceValuesTask4 = mapReduceValuesTask;
                                final MapReduceValuesTask<?, ?, ?> nextRight = rights3.nextRight;
                                mapReduceValuesTask4.rights = nextRight;
                                rights3 = nextRight;
                                BytecodeManager.incBytecodes(6);
                                BytecodeManager.incBytecodes(1);
                            }
                            final MapReduceValuesTask<?, ?, ?> mapReduceValuesTask5 = (MapReduceValuesTask<?, ?, ?>)countedCompleter;
                            BytecodeManager.incBytecodes(2);
                            countedCompleter = mapReduceValuesTask5.nextComplete();
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
    }
    
    static final class MapReduceEntriesTask<K, V, U> extends BulkTask<K, V, U>
    {
        final Function<Map.Entry<K, V>, ? extends U> transformer;
        final BiFunction<? super U, ? super U, ? extends U> reducer;
        U result;
        MapReduceEntriesTask<K, V, U> rights;
        MapReduceEntriesTask<K, V, U> nextRight;
        
        MapReduceEntriesTask(final BulkTask<K, V, ?> bulkTask, final int n, final int n2, final int n3, final Node<K, V>[] array, final MapReduceEntriesTask<K, V, U> nextRight, final Function<Map.Entry<K, V>, ? extends U> transformer, final BiFunction<? super U, ? super U, ? extends U> reducer) {
            try {
                BytecodeManager.incBytecodes(7);
                super(bulkTask, n, n2, n3, array);
                this.nextRight = nextRight;
                BytecodeManager.incBytecodes(3);
                this.transformer = transformer;
                BytecodeManager.incBytecodes(3);
                this.reducer = reducer;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final U getRawResult() {
            try {
                final U result = this.result;
                BytecodeManager.incBytecodes(3);
                return result;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final void compute() {
            try {
                final Function<Map.Entry<K, V>, ? extends U> transformer;
                final Function<Map.Entry<K, V>, ? extends U> function = transformer = this.transformer;
                BytecodeManager.incBytecodes(5);
                if (function != null) {
                    final BiFunction<? super U, ? super U, ? extends U> reducer;
                    final BiFunction<? super U, ? super U, ? extends U> biFunction = reducer = this.reducer;
                    BytecodeManager.incBytecodes(5);
                    if (biFunction != null) {
                        final int baseIndex = this.baseIndex;
                        BytecodeManager.incBytecodes(3);
                        while (true) {
                            final int batch = this.batch;
                            BytecodeManager.incBytecodes(3);
                            if (batch <= 0) {
                                break;
                            }
                            final int baseLimit;
                            final int n = (baseLimit = this.baseLimit) + baseIndex >>> 1;
                            final int n2 = baseIndex;
                            BytecodeManager.incBytecodes(12);
                            if (n <= n2) {
                                break;
                            }
                            final int n3 = 1;
                            BytecodeManager.incBytecodes(3);
                            this.addToPendingCount(n3);
                            final int batch2 = this.batch >>> 1;
                            this.batch = batch2;
                            final int baseLimit2 = n;
                            this.baseLimit = baseLimit2;
                            final int n4 = baseLimit;
                            final Node<K, V>[] tab = this.tab;
                            final MapReduceEntriesTask<K, V, U> rights = this.rights;
                            final Function<Map.Entry<K, V>, ? extends U> function2 = transformer;
                            final BiFunction<? super U, ? super U, ? extends U> biFunction2 = reducer;
                            BytecodeManager.incBytecodes(23);
                            final MapReduceEntriesTask rights2 = new MapReduceEntriesTask<K, V, U>(this, batch2, baseLimit2, n4, tab, rights, function2, biFunction2);
                            this.rights = rights2;
                            BytecodeManager.incBytecodes(2);
                            BytecodeManager.incBytecodes(1);
                            rights2.fork();
                            BytecodeManager.incBytecodes(2);
                        }
                        Object result = null;
                        BytecodeManager.incBytecodes(2);
                        while (true) {
                            BytecodeManager.incBytecodes(2);
                            final Node<K, V> advance = this.advance();
                            BytecodeManager.incBytecodes(3);
                            if (advance == null) {
                                break;
                            }
                            final Function<Map.Entry<K, V>, ? extends U> function3 = transformer;
                            final Node<K, V> node = advance;
                            BytecodeManager.incBytecodes(3);
                            final U apply;
                            final Object o = apply = (U)function3.apply(node);
                            BytecodeManager.incBytecodes(3);
                            if (o != null) {
                                final Object o2 = result;
                                BytecodeManager.incBytecodes(2);
                                U apply2;
                                if (o2 == null) {
                                    apply2 = apply;
                                    BytecodeManager.incBytecodes(2);
                                }
                                else {
                                    final BiFunction<? super U, ? super U, ? extends U> biFunction3 = reducer;
                                    final Object o3 = result;
                                    final U u = apply;
                                    BytecodeManager.incBytecodes(4);
                                    apply2 = (U)biFunction3.apply((U)o3, u);
                                }
                                result = apply2;
                                BytecodeManager.incBytecodes(1);
                            }
                            BytecodeManager.incBytecodes(1);
                        }
                        this.result = (U)result;
                        BytecodeManager.incBytecodes(3);
                        BytecodeManager.incBytecodes(2);
                        CountedCompleter<?> countedCompleter = this.firstComplete();
                        BytecodeManager.incBytecodes(1);
                        while (true) {
                            final CountedCompleter<?> countedCompleter2 = countedCompleter;
                            BytecodeManager.incBytecodes(2);
                            if (countedCompleter2 == null) {
                                break;
                            }
                            final MapReduceEntriesTask<?, ?, ?> mapReduceEntriesTask = (MapReduceEntriesTask<?, ?, ?>)countedCompleter;
                            BytecodeManager.incBytecodes(3);
                            MapReduceEntriesTask<?, ?, ?> rights3 = mapReduceEntriesTask.rights;
                            BytecodeManager.incBytecodes(3);
                            while (true) {
                                final MapReduceEntriesTask<?, ?, ?> mapReduceEntriesTask2 = rights3;
                                BytecodeManager.incBytecodes(2);
                                if (mapReduceEntriesTask2 == null) {
                                    break;
                                }
                                final Object result2;
                                final Object o4 = result2 = rights3.result;
                                BytecodeManager.incBytecodes(5);
                                if (o4 != null) {
                                    final MapReduceEntriesTask<?, ?, ?> mapReduceEntriesTask3 = mapReduceEntriesTask;
                                    final Object result3 = mapReduceEntriesTask.result;
                                    BytecodeManager.incBytecodes(6);
                                    Object apply3;
                                    if (result3 == null) {
                                        apply3 = result2;
                                        BytecodeManager.incBytecodes(2);
                                    }
                                    else {
                                        final BiFunction<? super U, ? super U, ? extends U> biFunction4 = reducer;
                                        final Object o5 = result3;
                                        final Object o6 = result2;
                                        BytecodeManager.incBytecodes(3);
                                        BytecodeManager.incBytecodes(1);
                                        apply3 = biFunction4.apply((U)o5, (U)o6);
                                    }
                                    mapReduceEntriesTask3.result = apply3;
                                    BytecodeManager.incBytecodes(1);
                                }
                                final MapReduceEntriesTask<?, ?, ?> mapReduceEntriesTask4 = mapReduceEntriesTask;
                                final MapReduceEntriesTask<?, ?, ?> nextRight = rights3.nextRight;
                                mapReduceEntriesTask4.rights = nextRight;
                                rights3 = nextRight;
                                BytecodeManager.incBytecodes(6);
                                BytecodeManager.incBytecodes(1);
                            }
                            final MapReduceEntriesTask<?, ?, ?> mapReduceEntriesTask5 = (MapReduceEntriesTask<?, ?, ?>)countedCompleter;
                            BytecodeManager.incBytecodes(2);
                            countedCompleter = mapReduceEntriesTask5.nextComplete();
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
    }
    
    static final class MapReduceMappingsTask<K, V, U> extends BulkTask<K, V, U>
    {
        final BiFunction<? super K, ? super V, ? extends U> transformer;
        final BiFunction<? super U, ? super U, ? extends U> reducer;
        U result;
        MapReduceMappingsTask<K, V, U> rights;
        MapReduceMappingsTask<K, V, U> nextRight;
        
        MapReduceMappingsTask(final BulkTask<K, V, ?> bulkTask, final int n, final int n2, final int n3, final Node<K, V>[] array, final MapReduceMappingsTask<K, V, U> nextRight, final BiFunction<? super K, ? super V, ? extends U> transformer, final BiFunction<? super U, ? super U, ? extends U> reducer) {
            try {
                BytecodeManager.incBytecodes(7);
                super(bulkTask, n, n2, n3, array);
                this.nextRight = nextRight;
                BytecodeManager.incBytecodes(3);
                this.transformer = transformer;
                BytecodeManager.incBytecodes(3);
                this.reducer = reducer;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final U getRawResult() {
            try {
                final U result = this.result;
                BytecodeManager.incBytecodes(3);
                return result;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final void compute() {
            try {
                final BiFunction<? super K, ? super V, ? extends U> transformer;
                final BiFunction<? super K, ? super V, ? extends U> biFunction = transformer = this.transformer;
                BytecodeManager.incBytecodes(5);
                if (biFunction != null) {
                    final BiFunction<? super U, ? super U, ? extends U> reducer;
                    final BiFunction<? super U, ? super U, ? extends U> biFunction2 = reducer = this.reducer;
                    BytecodeManager.incBytecodes(5);
                    if (biFunction2 != null) {
                        final int baseIndex = this.baseIndex;
                        BytecodeManager.incBytecodes(3);
                        while (true) {
                            final int batch = this.batch;
                            BytecodeManager.incBytecodes(3);
                            if (batch <= 0) {
                                break;
                            }
                            final int baseLimit;
                            final int n = (baseLimit = this.baseLimit) + baseIndex >>> 1;
                            final int n2 = baseIndex;
                            BytecodeManager.incBytecodes(12);
                            if (n <= n2) {
                                break;
                            }
                            final int n3 = 1;
                            BytecodeManager.incBytecodes(3);
                            this.addToPendingCount(n3);
                            final int batch2 = this.batch >>> 1;
                            this.batch = batch2;
                            final int baseLimit2 = n;
                            this.baseLimit = baseLimit2;
                            final int n4 = baseLimit;
                            final Node<K, V>[] tab = this.tab;
                            final MapReduceMappingsTask<K, V, U> rights = this.rights;
                            final BiFunction<? super Object, ? super Object, ? extends U> biFunction3 = (BiFunction<? super Object, ? super Object, ? extends U>)transformer;
                            final BiFunction<? super U, ? super U, ? extends U> biFunction4 = reducer;
                            BytecodeManager.incBytecodes(23);
                            final MapReduceMappingsTask rights2 = new MapReduceMappingsTask<K, V, U>(this, batch2, baseLimit2, n4, tab, rights, biFunction3, biFunction4);
                            this.rights = rights2;
                            BytecodeManager.incBytecodes(2);
                            BytecodeManager.incBytecodes(1);
                            rights2.fork();
                            BytecodeManager.incBytecodes(2);
                        }
                        Object result = null;
                        BytecodeManager.incBytecodes(2);
                        while (true) {
                            BytecodeManager.incBytecodes(2);
                            final Node<K, V> advance;
                            final Node<K, V> node = advance = this.advance();
                            BytecodeManager.incBytecodes(3);
                            if (node == null) {
                                break;
                            }
                            final BiFunction<K, V, ? extends U> biFunction5 = (BiFunction<K, V, ? extends U>)transformer;
                            final K key = advance.key;
                            final V val = advance.val;
                            BytecodeManager.incBytecodes(6);
                            final U apply;
                            final Object o = apply = (U)biFunction5.apply(key, val);
                            BytecodeManager.incBytecodes(3);
                            if (o != null) {
                                final Object o2 = result;
                                BytecodeManager.incBytecodes(2);
                                U apply2;
                                if (o2 == null) {
                                    apply2 = apply;
                                    BytecodeManager.incBytecodes(2);
                                }
                                else {
                                    final BiFunction<? super U, ? super U, ? extends U> biFunction6 = reducer;
                                    final Object o3 = result;
                                    final U u = apply;
                                    BytecodeManager.incBytecodes(4);
                                    apply2 = (U)biFunction6.apply((U)o3, u);
                                }
                                result = apply2;
                                BytecodeManager.incBytecodes(1);
                            }
                            BytecodeManager.incBytecodes(1);
                        }
                        this.result = (U)result;
                        BytecodeManager.incBytecodes(3);
                        BytecodeManager.incBytecodes(2);
                        CountedCompleter<?> countedCompleter = this.firstComplete();
                        BytecodeManager.incBytecodes(1);
                        while (true) {
                            final CountedCompleter<?> countedCompleter2 = countedCompleter;
                            BytecodeManager.incBytecodes(2);
                            if (countedCompleter2 == null) {
                                break;
                            }
                            final MapReduceMappingsTask<?, ?, ?> mapReduceMappingsTask = (MapReduceMappingsTask<?, ?, ?>)countedCompleter;
                            BytecodeManager.incBytecodes(3);
                            MapReduceMappingsTask<?, ?, ?> rights3 = mapReduceMappingsTask.rights;
                            BytecodeManager.incBytecodes(3);
                            while (true) {
                                final MapReduceMappingsTask<?, ?, ?> mapReduceMappingsTask2 = rights3;
                                BytecodeManager.incBytecodes(2);
                                if (mapReduceMappingsTask2 == null) {
                                    break;
                                }
                                final Object result2;
                                final Object o4 = result2 = rights3.result;
                                BytecodeManager.incBytecodes(5);
                                if (o4 != null) {
                                    final MapReduceMappingsTask<?, ?, ?> mapReduceMappingsTask3 = mapReduceMappingsTask;
                                    final Object result3 = mapReduceMappingsTask.result;
                                    BytecodeManager.incBytecodes(6);
                                    Object apply3;
                                    if (result3 == null) {
                                        apply3 = result2;
                                        BytecodeManager.incBytecodes(2);
                                    }
                                    else {
                                        final BiFunction<? super U, ? super U, ? extends U> biFunction7 = reducer;
                                        final Object o5 = result3;
                                        final Object o6 = result2;
                                        BytecodeManager.incBytecodes(3);
                                        BytecodeManager.incBytecodes(1);
                                        apply3 = biFunction7.apply((U)o5, (U)o6);
                                    }
                                    mapReduceMappingsTask3.result = apply3;
                                    BytecodeManager.incBytecodes(1);
                                }
                                final MapReduceMappingsTask<?, ?, ?> mapReduceMappingsTask4 = mapReduceMappingsTask;
                                final MapReduceMappingsTask<?, ?, ?> nextRight = rights3.nextRight;
                                mapReduceMappingsTask4.rights = nextRight;
                                rights3 = nextRight;
                                BytecodeManager.incBytecodes(6);
                                BytecodeManager.incBytecodes(1);
                            }
                            final MapReduceMappingsTask<?, ?, ?> mapReduceMappingsTask5 = (MapReduceMappingsTask<?, ?, ?>)countedCompleter;
                            BytecodeManager.incBytecodes(2);
                            countedCompleter = mapReduceMappingsTask5.nextComplete();
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
    }
    
    static final class MapReduceKeysToDoubleTask<K, V> extends BulkTask<K, V, Double>
    {
        final ToDoubleFunction<? super K> transformer;
        final DoubleBinaryOperator reducer;
        final double basis;
        double result;
        MapReduceKeysToDoubleTask<K, V> rights;
        MapReduceKeysToDoubleTask<K, V> nextRight;
        
        MapReduceKeysToDoubleTask(final BulkTask<K, V, ?> bulkTask, final int n, final int n2, final int n3, final Node<K, V>[] array, final MapReduceKeysToDoubleTask<K, V> nextRight, final ToDoubleFunction<? super K> transformer, final double basis, final DoubleBinaryOperator reducer) {
            try {
                BytecodeManager.incBytecodes(7);
                super(bulkTask, n, n2, n3, array);
                this.nextRight = nextRight;
                BytecodeManager.incBytecodes(3);
                this.transformer = transformer;
                BytecodeManager.incBytecodes(3);
                this.basis = basis;
                this.reducer = reducer;
                BytecodeManager.incBytecodes(6);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final Double getRawResult() {
            try {
                final double result = this.result;
                BytecodeManager.incBytecodes(3);
                final Double value = result;
                BytecodeManager.incBytecodes(1);
                return value;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final void compute() {
            try {
                final ToDoubleFunction<? super K> transformer;
                final ToDoubleFunction<? super K> toDoubleFunction = transformer = this.transformer;
                BytecodeManager.incBytecodes(5);
                if (toDoubleFunction != null) {
                    final DoubleBinaryOperator reducer;
                    final DoubleBinaryOperator doubleBinaryOperator = reducer = this.reducer;
                    BytecodeManager.incBytecodes(5);
                    if (doubleBinaryOperator != null) {
                        double result = this.basis;
                        BytecodeManager.incBytecodes(3);
                        final int baseIndex = this.baseIndex;
                        BytecodeManager.incBytecodes(3);
                        while (true) {
                            final int batch = this.batch;
                            BytecodeManager.incBytecodes(3);
                            if (batch <= 0) {
                                break;
                            }
                            final int baseLimit;
                            final int n = (baseLimit = this.baseLimit) + baseIndex >>> 1;
                            final int n2 = baseIndex;
                            BytecodeManager.incBytecodes(12);
                            if (n <= n2) {
                                break;
                            }
                            final int n3 = 1;
                            BytecodeManager.incBytecodes(3);
                            this.addToPendingCount(n3);
                            final int batch2 = this.batch >>> 1;
                            this.batch = batch2;
                            final int baseLimit2 = n;
                            this.baseLimit = baseLimit2;
                            final int n4 = baseLimit;
                            final Node<K, V>[] tab = this.tab;
                            final MapReduceKeysToDoubleTask<K, V> rights = this.rights;
                            final ToDoubleFunction<? super Object> toDoubleFunction2 = (ToDoubleFunction<? super Object>)transformer;
                            final double n5 = result;
                            final DoubleBinaryOperator doubleBinaryOperator2 = reducer;
                            BytecodeManager.incBytecodes(24);
                            final MapReduceKeysToDoubleTask rights2 = new MapReduceKeysToDoubleTask<K, V>(this, batch2, baseLimit2, n4, (Node<K, V>[])tab, rights, toDoubleFunction2, n5, doubleBinaryOperator2);
                            this.rights = rights2;
                            BytecodeManager.incBytecodes(2);
                            BytecodeManager.incBytecodes(1);
                            rights2.fork();
                            BytecodeManager.incBytecodes(2);
                        }
                        while (true) {
                            BytecodeManager.incBytecodes(2);
                            final Node<K, V> advance = this.advance();
                            BytecodeManager.incBytecodes(3);
                            if (advance == null) {
                                break;
                            }
                            final DoubleBinaryOperator doubleBinaryOperator3 = reducer;
                            final double n6 = result;
                            final ToDoubleFunction<K> toDoubleFunction3 = (ToDoubleFunction<K>)transformer;
                            final K key = advance.key;
                            BytecodeManager.incBytecodes(6);
                            final double applyAsDouble = toDoubleFunction3.applyAsDouble(key);
                            BytecodeManager.incBytecodes(1);
                            result = doubleBinaryOperator3.applyAsDouble(n6, applyAsDouble);
                            BytecodeManager.incBytecodes(2);
                        }
                        this.result = result;
                        BytecodeManager.incBytecodes(3);
                        BytecodeManager.incBytecodes(2);
                        CountedCompleter<?> countedCompleter = this.firstComplete();
                        BytecodeManager.incBytecodes(1);
                        while (true) {
                            final CountedCompleter<?> countedCompleter2 = countedCompleter;
                            BytecodeManager.incBytecodes(2);
                            if (countedCompleter2 == null) {
                                break;
                            }
                            final MapReduceKeysToDoubleTask<?, ?> mapReduceKeysToDoubleTask = (MapReduceKeysToDoubleTask<?, ?>)countedCompleter;
                            BytecodeManager.incBytecodes(3);
                            MapReduceKeysToDoubleTask<?, ?> rights3 = mapReduceKeysToDoubleTask.rights;
                            BytecodeManager.incBytecodes(3);
                            while (true) {
                                final MapReduceKeysToDoubleTask<?, ?> mapReduceKeysToDoubleTask2 = rights3;
                                BytecodeManager.incBytecodes(2);
                                if (mapReduceKeysToDoubleTask2 == null) {
                                    break;
                                }
                                final MapReduceKeysToDoubleTask<?, ?> mapReduceKeysToDoubleTask3 = mapReduceKeysToDoubleTask;
                                final DoubleBinaryOperator doubleBinaryOperator4 = reducer;
                                final double result2 = mapReduceKeysToDoubleTask.result;
                                final double result3 = rights3.result;
                                BytecodeManager.incBytecodes(7);
                                mapReduceKeysToDoubleTask3.result = doubleBinaryOperator4.applyAsDouble(result2, result3);
                                BytecodeManager.incBytecodes(1);
                                final MapReduceKeysToDoubleTask<?, ?> mapReduceKeysToDoubleTask4 = mapReduceKeysToDoubleTask;
                                final MapReduceKeysToDoubleTask<?, ?> nextRight = rights3.nextRight;
                                mapReduceKeysToDoubleTask4.rights = nextRight;
                                rights3 = nextRight;
                                BytecodeManager.incBytecodes(7);
                            }
                            final MapReduceKeysToDoubleTask<?, ?> mapReduceKeysToDoubleTask5 = (MapReduceKeysToDoubleTask<?, ?>)countedCompleter;
                            BytecodeManager.incBytecodes(2);
                            countedCompleter = mapReduceKeysToDoubleTask5.nextComplete();
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
    }
    
    static final class MapReduceValuesToDoubleTask<K, V> extends BulkTask<K, V, Double>
    {
        final ToDoubleFunction<? super V> transformer;
        final DoubleBinaryOperator reducer;
        final double basis;
        double result;
        MapReduceValuesToDoubleTask<K, V> rights;
        MapReduceValuesToDoubleTask<K, V> nextRight;
        
        MapReduceValuesToDoubleTask(final BulkTask<K, V, ?> bulkTask, final int n, final int n2, final int n3, final Node<K, V>[] array, final MapReduceValuesToDoubleTask<K, V> nextRight, final ToDoubleFunction<? super V> transformer, final double basis, final DoubleBinaryOperator reducer) {
            try {
                BytecodeManager.incBytecodes(7);
                super(bulkTask, n, n2, n3, array);
                this.nextRight = nextRight;
                BytecodeManager.incBytecodes(3);
                this.transformer = transformer;
                BytecodeManager.incBytecodes(3);
                this.basis = basis;
                this.reducer = reducer;
                BytecodeManager.incBytecodes(6);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final Double getRawResult() {
            try {
                final double result = this.result;
                BytecodeManager.incBytecodes(3);
                final Double value = result;
                BytecodeManager.incBytecodes(1);
                return value;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final void compute() {
            try {
                final ToDoubleFunction<? super V> transformer;
                final ToDoubleFunction<? super V> toDoubleFunction = transformer = this.transformer;
                BytecodeManager.incBytecodes(5);
                if (toDoubleFunction != null) {
                    final DoubleBinaryOperator reducer;
                    final DoubleBinaryOperator doubleBinaryOperator = reducer = this.reducer;
                    BytecodeManager.incBytecodes(5);
                    if (doubleBinaryOperator != null) {
                        double result = this.basis;
                        BytecodeManager.incBytecodes(3);
                        final int baseIndex = this.baseIndex;
                        BytecodeManager.incBytecodes(3);
                        while (true) {
                            final int batch = this.batch;
                            BytecodeManager.incBytecodes(3);
                            if (batch <= 0) {
                                break;
                            }
                            final int baseLimit;
                            final int n = (baseLimit = this.baseLimit) + baseIndex >>> 1;
                            final int n2 = baseIndex;
                            BytecodeManager.incBytecodes(12);
                            if (n <= n2) {
                                break;
                            }
                            final int n3 = 1;
                            BytecodeManager.incBytecodes(3);
                            this.addToPendingCount(n3);
                            final int batch2 = this.batch >>> 1;
                            this.batch = batch2;
                            final int baseLimit2 = n;
                            this.baseLimit = baseLimit2;
                            final int n4 = baseLimit;
                            final Node<K, V>[] tab = this.tab;
                            final MapReduceValuesToDoubleTask<K, V> rights = this.rights;
                            final ToDoubleFunction<? super Object> toDoubleFunction2 = (ToDoubleFunction<? super Object>)transformer;
                            final double n5 = result;
                            final DoubleBinaryOperator doubleBinaryOperator2 = reducer;
                            BytecodeManager.incBytecodes(24);
                            final MapReduceValuesToDoubleTask rights2 = new MapReduceValuesToDoubleTask<K, V>(this, batch2, baseLimit2, n4, (Node<K, V>[])tab, rights, toDoubleFunction2, n5, doubleBinaryOperator2);
                            this.rights = rights2;
                            BytecodeManager.incBytecodes(2);
                            BytecodeManager.incBytecodes(1);
                            rights2.fork();
                            BytecodeManager.incBytecodes(2);
                        }
                        while (true) {
                            BytecodeManager.incBytecodes(2);
                            final Node<K, V> advance = this.advance();
                            BytecodeManager.incBytecodes(3);
                            if (advance == null) {
                                break;
                            }
                            final DoubleBinaryOperator doubleBinaryOperator3 = reducer;
                            final double n6 = result;
                            final ToDoubleFunction<V> toDoubleFunction3 = (ToDoubleFunction<V>)transformer;
                            final V val = advance.val;
                            BytecodeManager.incBytecodes(6);
                            final double applyAsDouble = toDoubleFunction3.applyAsDouble(val);
                            BytecodeManager.incBytecodes(1);
                            result = doubleBinaryOperator3.applyAsDouble(n6, applyAsDouble);
                            BytecodeManager.incBytecodes(2);
                        }
                        this.result = result;
                        BytecodeManager.incBytecodes(3);
                        BytecodeManager.incBytecodes(2);
                        CountedCompleter<?> countedCompleter = this.firstComplete();
                        BytecodeManager.incBytecodes(1);
                        while (true) {
                            final CountedCompleter<?> countedCompleter2 = countedCompleter;
                            BytecodeManager.incBytecodes(2);
                            if (countedCompleter2 == null) {
                                break;
                            }
                            final MapReduceValuesToDoubleTask<?, ?> mapReduceValuesToDoubleTask = (MapReduceValuesToDoubleTask<?, ?>)countedCompleter;
                            BytecodeManager.incBytecodes(3);
                            MapReduceValuesToDoubleTask<?, ?> rights3 = mapReduceValuesToDoubleTask.rights;
                            BytecodeManager.incBytecodes(3);
                            while (true) {
                                final MapReduceValuesToDoubleTask<?, ?> mapReduceValuesToDoubleTask2 = rights3;
                                BytecodeManager.incBytecodes(2);
                                if (mapReduceValuesToDoubleTask2 == null) {
                                    break;
                                }
                                final MapReduceValuesToDoubleTask<?, ?> mapReduceValuesToDoubleTask3 = mapReduceValuesToDoubleTask;
                                final DoubleBinaryOperator doubleBinaryOperator4 = reducer;
                                final double result2 = mapReduceValuesToDoubleTask.result;
                                final double result3 = rights3.result;
                                BytecodeManager.incBytecodes(7);
                                mapReduceValuesToDoubleTask3.result = doubleBinaryOperator4.applyAsDouble(result2, result3);
                                BytecodeManager.incBytecodes(1);
                                final MapReduceValuesToDoubleTask<?, ?> mapReduceValuesToDoubleTask4 = mapReduceValuesToDoubleTask;
                                final MapReduceValuesToDoubleTask<?, ?> nextRight = rights3.nextRight;
                                mapReduceValuesToDoubleTask4.rights = nextRight;
                                rights3 = nextRight;
                                BytecodeManager.incBytecodes(7);
                            }
                            final MapReduceValuesToDoubleTask<?, ?> mapReduceValuesToDoubleTask5 = (MapReduceValuesToDoubleTask<?, ?>)countedCompleter;
                            BytecodeManager.incBytecodes(2);
                            countedCompleter = mapReduceValuesToDoubleTask5.nextComplete();
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
    }
    
    static final class MapReduceEntriesToDoubleTask<K, V> extends BulkTask<K, V, Double>
    {
        final ToDoubleFunction<Map.Entry<K, V>> transformer;
        final DoubleBinaryOperator reducer;
        final double basis;
        double result;
        MapReduceEntriesToDoubleTask<K, V> rights;
        MapReduceEntriesToDoubleTask<K, V> nextRight;
        
        MapReduceEntriesToDoubleTask(final BulkTask<K, V, ?> bulkTask, final int n, final int n2, final int n3, final Node<K, V>[] array, final MapReduceEntriesToDoubleTask<K, V> nextRight, final ToDoubleFunction<Map.Entry<K, V>> transformer, final double basis, final DoubleBinaryOperator reducer) {
            try {
                BytecodeManager.incBytecodes(7);
                super(bulkTask, n, n2, n3, array);
                this.nextRight = nextRight;
                BytecodeManager.incBytecodes(3);
                this.transformer = transformer;
                BytecodeManager.incBytecodes(3);
                this.basis = basis;
                this.reducer = reducer;
                BytecodeManager.incBytecodes(6);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final Double getRawResult() {
            try {
                final double result = this.result;
                BytecodeManager.incBytecodes(3);
                final Double value = result;
                BytecodeManager.incBytecodes(1);
                return value;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final void compute() {
            try {
                final ToDoubleFunction<Map.Entry<K, V>> transformer;
                final ToDoubleFunction<Map.Entry<K, V>> toDoubleFunction = transformer = this.transformer;
                BytecodeManager.incBytecodes(5);
                if (toDoubleFunction != null) {
                    final DoubleBinaryOperator reducer;
                    final DoubleBinaryOperator doubleBinaryOperator = reducer = this.reducer;
                    BytecodeManager.incBytecodes(5);
                    if (doubleBinaryOperator != null) {
                        double result = this.basis;
                        BytecodeManager.incBytecodes(3);
                        final int baseIndex = this.baseIndex;
                        BytecodeManager.incBytecodes(3);
                        while (true) {
                            final int batch = this.batch;
                            BytecodeManager.incBytecodes(3);
                            if (batch <= 0) {
                                break;
                            }
                            final int baseLimit;
                            final int n = (baseLimit = this.baseLimit) + baseIndex >>> 1;
                            final int n2 = baseIndex;
                            BytecodeManager.incBytecodes(12);
                            if (n <= n2) {
                                break;
                            }
                            final int n3 = 1;
                            BytecodeManager.incBytecodes(3);
                            this.addToPendingCount(n3);
                            final int batch2 = this.batch >>> 1;
                            this.batch = batch2;
                            final int baseLimit2 = n;
                            this.baseLimit = baseLimit2;
                            final int n4 = baseLimit;
                            final Node<K, V>[] tab = this.tab;
                            final MapReduceEntriesToDoubleTask<K, V> rights = this.rights;
                            final ToDoubleFunction<Map.Entry<Object, Object>> toDoubleFunction2 = (ToDoubleFunction<Map.Entry<Object, Object>>)transformer;
                            final double n5 = result;
                            final DoubleBinaryOperator doubleBinaryOperator2 = reducer;
                            BytecodeManager.incBytecodes(24);
                            final MapReduceEntriesToDoubleTask rights2 = new MapReduceEntriesToDoubleTask<K, V>(this, batch2, baseLimit2, n4, (Node<K, V>[])tab, rights, (ToDoubleFunction<Map.Entry<K, V>>)toDoubleFunction2, n5, doubleBinaryOperator2);
                            this.rights = rights2;
                            BytecodeManager.incBytecodes(2);
                            BytecodeManager.incBytecodes(1);
                            rights2.fork();
                            BytecodeManager.incBytecodes(2);
                        }
                        while (true) {
                            BytecodeManager.incBytecodes(2);
                            final Node<Object, Object> advance = (Node<Object, Object>)this.advance();
                            BytecodeManager.incBytecodes(3);
                            if (advance == null) {
                                break;
                            }
                            final DoubleBinaryOperator doubleBinaryOperator3 = reducer;
                            final double n6 = result;
                            final ToDoubleFunction<Map.Entry<K, V>> toDoubleFunction3 = transformer;
                            final Map.Entry<K, V> entry = (Map.Entry<K, V>)advance;
                            BytecodeManager.incBytecodes(5);
                            final double applyAsDouble = toDoubleFunction3.applyAsDouble(entry);
                            BytecodeManager.incBytecodes(1);
                            result = doubleBinaryOperator3.applyAsDouble(n6, applyAsDouble);
                            BytecodeManager.incBytecodes(2);
                        }
                        this.result = result;
                        BytecodeManager.incBytecodes(3);
                        BytecodeManager.incBytecodes(2);
                        CountedCompleter<?> countedCompleter = this.firstComplete();
                        BytecodeManager.incBytecodes(1);
                        while (true) {
                            final CountedCompleter<?> countedCompleter2 = countedCompleter;
                            BytecodeManager.incBytecodes(2);
                            if (countedCompleter2 == null) {
                                break;
                            }
                            final MapReduceEntriesToDoubleTask<?, ?> mapReduceEntriesToDoubleTask = (MapReduceEntriesToDoubleTask<?, ?>)countedCompleter;
                            BytecodeManager.incBytecodes(3);
                            MapReduceEntriesToDoubleTask<?, ?> rights3 = mapReduceEntriesToDoubleTask.rights;
                            BytecodeManager.incBytecodes(3);
                            while (true) {
                                final MapReduceEntriesToDoubleTask<?, ?> mapReduceEntriesToDoubleTask2 = rights3;
                                BytecodeManager.incBytecodes(2);
                                if (mapReduceEntriesToDoubleTask2 == null) {
                                    break;
                                }
                                final MapReduceEntriesToDoubleTask<?, ?> mapReduceEntriesToDoubleTask3 = mapReduceEntriesToDoubleTask;
                                final DoubleBinaryOperator doubleBinaryOperator4 = reducer;
                                final double result2 = mapReduceEntriesToDoubleTask.result;
                                final double result3 = rights3.result;
                                BytecodeManager.incBytecodes(7);
                                mapReduceEntriesToDoubleTask3.result = doubleBinaryOperator4.applyAsDouble(result2, result3);
                                BytecodeManager.incBytecodes(1);
                                final MapReduceEntriesToDoubleTask<?, ?> mapReduceEntriesToDoubleTask4 = mapReduceEntriesToDoubleTask;
                                final MapReduceEntriesToDoubleTask<?, ?> nextRight = rights3.nextRight;
                                mapReduceEntriesToDoubleTask4.rights = nextRight;
                                rights3 = nextRight;
                                BytecodeManager.incBytecodes(7);
                            }
                            final MapReduceEntriesToDoubleTask<?, ?> mapReduceEntriesToDoubleTask5 = (MapReduceEntriesToDoubleTask<?, ?>)countedCompleter;
                            BytecodeManager.incBytecodes(2);
                            countedCompleter = mapReduceEntriesToDoubleTask5.nextComplete();
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
    }
    
    static final class MapReduceMappingsToDoubleTask<K, V> extends BulkTask<K, V, Double>
    {
        final ToDoubleBiFunction<? super K, ? super V> transformer;
        final DoubleBinaryOperator reducer;
        final double basis;
        double result;
        MapReduceMappingsToDoubleTask<K, V> rights;
        MapReduceMappingsToDoubleTask<K, V> nextRight;
        
        MapReduceMappingsToDoubleTask(final BulkTask<K, V, ?> bulkTask, final int n, final int n2, final int n3, final Node<K, V>[] array, final MapReduceMappingsToDoubleTask<K, V> nextRight, final ToDoubleBiFunction<? super K, ? super V> transformer, final double basis, final DoubleBinaryOperator reducer) {
            try {
                BytecodeManager.incBytecodes(7);
                super(bulkTask, n, n2, n3, array);
                this.nextRight = nextRight;
                BytecodeManager.incBytecodes(3);
                this.transformer = transformer;
                BytecodeManager.incBytecodes(3);
                this.basis = basis;
                this.reducer = reducer;
                BytecodeManager.incBytecodes(6);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final Double getRawResult() {
            try {
                final double result = this.result;
                BytecodeManager.incBytecodes(3);
                final Double value = result;
                BytecodeManager.incBytecodes(1);
                return value;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final void compute() {
            try {
                final ToDoubleBiFunction<? super K, ? super V> transformer;
                final ToDoubleBiFunction<? super K, ? super V> toDoubleBiFunction = transformer = this.transformer;
                BytecodeManager.incBytecodes(5);
                if (toDoubleBiFunction != null) {
                    final DoubleBinaryOperator reducer;
                    final DoubleBinaryOperator doubleBinaryOperator = reducer = this.reducer;
                    BytecodeManager.incBytecodes(5);
                    if (doubleBinaryOperator != null) {
                        double result = this.basis;
                        BytecodeManager.incBytecodes(3);
                        final int baseIndex = this.baseIndex;
                        BytecodeManager.incBytecodes(3);
                        while (true) {
                            final int batch = this.batch;
                            BytecodeManager.incBytecodes(3);
                            if (batch <= 0) {
                                break;
                            }
                            final int baseLimit;
                            final int n = (baseLimit = this.baseLimit) + baseIndex >>> 1;
                            final int n2 = baseIndex;
                            BytecodeManager.incBytecodes(12);
                            if (n <= n2) {
                                break;
                            }
                            final int n3 = 1;
                            BytecodeManager.incBytecodes(3);
                            this.addToPendingCount(n3);
                            final int batch2 = this.batch >>> 1;
                            this.batch = batch2;
                            final int baseLimit2 = n;
                            this.baseLimit = baseLimit2;
                            final int n4 = baseLimit;
                            final Node<K, V>[] tab = this.tab;
                            final MapReduceMappingsToDoubleTask<K, V> rights = this.rights;
                            final ToDoubleBiFunction<? super Object, ? super Object> toDoubleBiFunction2 = (ToDoubleBiFunction<? super Object, ? super Object>)transformer;
                            final double n5 = result;
                            final DoubleBinaryOperator doubleBinaryOperator2 = reducer;
                            BytecodeManager.incBytecodes(24);
                            final MapReduceMappingsToDoubleTask rights2 = new MapReduceMappingsToDoubleTask<K, V>(this, batch2, baseLimit2, n4, (Node<K, V>[])tab, rights, toDoubleBiFunction2, n5, doubleBinaryOperator2);
                            this.rights = rights2;
                            BytecodeManager.incBytecodes(2);
                            BytecodeManager.incBytecodes(1);
                            rights2.fork();
                            BytecodeManager.incBytecodes(2);
                        }
                        while (true) {
                            BytecodeManager.incBytecodes(2);
                            final Node<K, V> advance;
                            final Node<K, V> node = advance = this.advance();
                            BytecodeManager.incBytecodes(3);
                            if (node == null) {
                                break;
                            }
                            final DoubleBinaryOperator doubleBinaryOperator3 = reducer;
                            final double n6 = result;
                            final ToDoubleBiFunction<K, V> toDoubleBiFunction3 = (ToDoubleBiFunction<K, V>)transformer;
                            final K key = advance.key;
                            final V val = advance.val;
                            BytecodeManager.incBytecodes(8);
                            final double applyAsDouble = toDoubleBiFunction3.applyAsDouble(key, val);
                            BytecodeManager.incBytecodes(1);
                            result = doubleBinaryOperator3.applyAsDouble(n6, applyAsDouble);
                            BytecodeManager.incBytecodes(2);
                        }
                        this.result = result;
                        BytecodeManager.incBytecodes(3);
                        BytecodeManager.incBytecodes(2);
                        CountedCompleter<?> countedCompleter = this.firstComplete();
                        BytecodeManager.incBytecodes(1);
                        while (true) {
                            final CountedCompleter<?> countedCompleter2 = countedCompleter;
                            BytecodeManager.incBytecodes(2);
                            if (countedCompleter2 == null) {
                                break;
                            }
                            final MapReduceMappingsToDoubleTask<?, ?> mapReduceMappingsToDoubleTask = (MapReduceMappingsToDoubleTask<?, ?>)countedCompleter;
                            BytecodeManager.incBytecodes(3);
                            MapReduceMappingsToDoubleTask<?, ?> rights3 = mapReduceMappingsToDoubleTask.rights;
                            BytecodeManager.incBytecodes(3);
                            while (true) {
                                final MapReduceMappingsToDoubleTask<?, ?> mapReduceMappingsToDoubleTask2 = rights3;
                                BytecodeManager.incBytecodes(2);
                                if (mapReduceMappingsToDoubleTask2 == null) {
                                    break;
                                }
                                final MapReduceMappingsToDoubleTask<?, ?> mapReduceMappingsToDoubleTask3 = mapReduceMappingsToDoubleTask;
                                final DoubleBinaryOperator doubleBinaryOperator4 = reducer;
                                final double result2 = mapReduceMappingsToDoubleTask.result;
                                final double result3 = rights3.result;
                                BytecodeManager.incBytecodes(7);
                                mapReduceMappingsToDoubleTask3.result = doubleBinaryOperator4.applyAsDouble(result2, result3);
                                BytecodeManager.incBytecodes(1);
                                final MapReduceMappingsToDoubleTask<?, ?> mapReduceMappingsToDoubleTask4 = mapReduceMappingsToDoubleTask;
                                final MapReduceMappingsToDoubleTask<?, ?> nextRight = rights3.nextRight;
                                mapReduceMappingsToDoubleTask4.rights = nextRight;
                                rights3 = nextRight;
                                BytecodeManager.incBytecodes(7);
                            }
                            final MapReduceMappingsToDoubleTask<?, ?> mapReduceMappingsToDoubleTask5 = (MapReduceMappingsToDoubleTask<?, ?>)countedCompleter;
                            BytecodeManager.incBytecodes(2);
                            countedCompleter = mapReduceMappingsToDoubleTask5.nextComplete();
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
    }
    
    static final class MapReduceKeysToLongTask<K, V> extends BulkTask<K, V, Long>
    {
        final ToLongFunction<? super K> transformer;
        final LongBinaryOperator reducer;
        final long basis;
        long result;
        MapReduceKeysToLongTask<K, V> rights;
        MapReduceKeysToLongTask<K, V> nextRight;
        
        MapReduceKeysToLongTask(final BulkTask<K, V, ?> bulkTask, final int n, final int n2, final int n3, final Node<K, V>[] array, final MapReduceKeysToLongTask<K, V> nextRight, final ToLongFunction<? super K> transformer, final long basis, final LongBinaryOperator reducer) {
            try {
                BytecodeManager.incBytecodes(7);
                super(bulkTask, n, n2, n3, array);
                this.nextRight = nextRight;
                BytecodeManager.incBytecodes(3);
                this.transformer = transformer;
                BytecodeManager.incBytecodes(3);
                this.basis = basis;
                this.reducer = reducer;
                BytecodeManager.incBytecodes(6);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final Long getRawResult() {
            try {
                final long result = this.result;
                BytecodeManager.incBytecodes(3);
                final Long value = result;
                BytecodeManager.incBytecodes(1);
                return value;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final void compute() {
            try {
                final ToLongFunction<? super K> transformer;
                final ToLongFunction<? super K> toLongFunction = transformer = this.transformer;
                BytecodeManager.incBytecodes(5);
                if (toLongFunction != null) {
                    final LongBinaryOperator reducer;
                    final LongBinaryOperator longBinaryOperator = reducer = this.reducer;
                    BytecodeManager.incBytecodes(5);
                    if (longBinaryOperator != null) {
                        long result = this.basis;
                        BytecodeManager.incBytecodes(3);
                        final int baseIndex = this.baseIndex;
                        BytecodeManager.incBytecodes(3);
                        while (true) {
                            final int batch = this.batch;
                            BytecodeManager.incBytecodes(3);
                            if (batch <= 0) {
                                break;
                            }
                            final int baseLimit;
                            final int n = (baseLimit = this.baseLimit) + baseIndex >>> 1;
                            final int n2 = baseIndex;
                            BytecodeManager.incBytecodes(12);
                            if (n <= n2) {
                                break;
                            }
                            final int n3 = 1;
                            BytecodeManager.incBytecodes(3);
                            this.addToPendingCount(n3);
                            final int batch2 = this.batch >>> 1;
                            this.batch = batch2;
                            final int baseLimit2 = n;
                            this.baseLimit = baseLimit2;
                            final int n4 = baseLimit;
                            final Node<K, V>[] tab = this.tab;
                            final MapReduceKeysToLongTask<K, V> rights = this.rights;
                            final ToLongFunction<? super Object> toLongFunction2 = (ToLongFunction<? super Object>)transformer;
                            final long n5 = result;
                            final LongBinaryOperator longBinaryOperator2 = reducer;
                            BytecodeManager.incBytecodes(24);
                            final MapReduceKeysToLongTask rights2 = new MapReduceKeysToLongTask<K, V>(this, batch2, baseLimit2, n4, (Node<K, V>[])tab, rights, toLongFunction2, n5, longBinaryOperator2);
                            this.rights = rights2;
                            BytecodeManager.incBytecodes(2);
                            BytecodeManager.incBytecodes(1);
                            rights2.fork();
                            BytecodeManager.incBytecodes(2);
                        }
                        while (true) {
                            BytecodeManager.incBytecodes(2);
                            final Node<K, V> advance = this.advance();
                            BytecodeManager.incBytecodes(3);
                            if (advance == null) {
                                break;
                            }
                            final LongBinaryOperator longBinaryOperator3 = reducer;
                            final long n6 = result;
                            final ToLongFunction<K> toLongFunction3 = (ToLongFunction<K>)transformer;
                            final K key = advance.key;
                            BytecodeManager.incBytecodes(6);
                            final long applyAsLong = toLongFunction3.applyAsLong(key);
                            BytecodeManager.incBytecodes(1);
                            result = longBinaryOperator3.applyAsLong(n6, applyAsLong);
                            BytecodeManager.incBytecodes(2);
                        }
                        this.result = result;
                        BytecodeManager.incBytecodes(3);
                        BytecodeManager.incBytecodes(2);
                        CountedCompleter<?> countedCompleter = this.firstComplete();
                        BytecodeManager.incBytecodes(1);
                        while (true) {
                            final CountedCompleter<?> countedCompleter2 = countedCompleter;
                            BytecodeManager.incBytecodes(2);
                            if (countedCompleter2 == null) {
                                break;
                            }
                            final MapReduceKeysToLongTask<?, ?> mapReduceKeysToLongTask = (MapReduceKeysToLongTask<?, ?>)countedCompleter;
                            BytecodeManager.incBytecodes(3);
                            MapReduceKeysToLongTask<?, ?> rights3 = mapReduceKeysToLongTask.rights;
                            BytecodeManager.incBytecodes(3);
                            while (true) {
                                final MapReduceKeysToLongTask<?, ?> mapReduceKeysToLongTask2 = rights3;
                                BytecodeManager.incBytecodes(2);
                                if (mapReduceKeysToLongTask2 == null) {
                                    break;
                                }
                                final MapReduceKeysToLongTask<?, ?> mapReduceKeysToLongTask3 = mapReduceKeysToLongTask;
                                final LongBinaryOperator longBinaryOperator4 = reducer;
                                final long result2 = mapReduceKeysToLongTask.result;
                                final long result3 = rights3.result;
                                BytecodeManager.incBytecodes(7);
                                mapReduceKeysToLongTask3.result = longBinaryOperator4.applyAsLong(result2, result3);
                                BytecodeManager.incBytecodes(1);
                                final MapReduceKeysToLongTask<?, ?> mapReduceKeysToLongTask4 = mapReduceKeysToLongTask;
                                final MapReduceKeysToLongTask<?, ?> nextRight = rights3.nextRight;
                                mapReduceKeysToLongTask4.rights = nextRight;
                                rights3 = nextRight;
                                BytecodeManager.incBytecodes(7);
                            }
                            final MapReduceKeysToLongTask<?, ?> mapReduceKeysToLongTask5 = (MapReduceKeysToLongTask<?, ?>)countedCompleter;
                            BytecodeManager.incBytecodes(2);
                            countedCompleter = mapReduceKeysToLongTask5.nextComplete();
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
    }
    
    static final class MapReduceValuesToLongTask<K, V> extends BulkTask<K, V, Long>
    {
        final ToLongFunction<? super V> transformer;
        final LongBinaryOperator reducer;
        final long basis;
        long result;
        MapReduceValuesToLongTask<K, V> rights;
        MapReduceValuesToLongTask<K, V> nextRight;
        
        MapReduceValuesToLongTask(final BulkTask<K, V, ?> bulkTask, final int n, final int n2, final int n3, final Node<K, V>[] array, final MapReduceValuesToLongTask<K, V> nextRight, final ToLongFunction<? super V> transformer, final long basis, final LongBinaryOperator reducer) {
            try {
                BytecodeManager.incBytecodes(7);
                super(bulkTask, n, n2, n3, array);
                this.nextRight = nextRight;
                BytecodeManager.incBytecodes(3);
                this.transformer = transformer;
                BytecodeManager.incBytecodes(3);
                this.basis = basis;
                this.reducer = reducer;
                BytecodeManager.incBytecodes(6);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final Long getRawResult() {
            try {
                final long result = this.result;
                BytecodeManager.incBytecodes(3);
                final Long value = result;
                BytecodeManager.incBytecodes(1);
                return value;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final void compute() {
            try {
                final ToLongFunction<? super V> transformer;
                final ToLongFunction<? super V> toLongFunction = transformer = this.transformer;
                BytecodeManager.incBytecodes(5);
                if (toLongFunction != null) {
                    final LongBinaryOperator reducer;
                    final LongBinaryOperator longBinaryOperator = reducer = this.reducer;
                    BytecodeManager.incBytecodes(5);
                    if (longBinaryOperator != null) {
                        long result = this.basis;
                        BytecodeManager.incBytecodes(3);
                        final int baseIndex = this.baseIndex;
                        BytecodeManager.incBytecodes(3);
                        while (true) {
                            final int batch = this.batch;
                            BytecodeManager.incBytecodes(3);
                            if (batch <= 0) {
                                break;
                            }
                            final int baseLimit;
                            final int n = (baseLimit = this.baseLimit) + baseIndex >>> 1;
                            final int n2 = baseIndex;
                            BytecodeManager.incBytecodes(12);
                            if (n <= n2) {
                                break;
                            }
                            final int n3 = 1;
                            BytecodeManager.incBytecodes(3);
                            this.addToPendingCount(n3);
                            final int batch2 = this.batch >>> 1;
                            this.batch = batch2;
                            final int baseLimit2 = n;
                            this.baseLimit = baseLimit2;
                            final int n4 = baseLimit;
                            final Node<K, V>[] tab = this.tab;
                            final MapReduceValuesToLongTask<K, V> rights = this.rights;
                            final ToLongFunction<? super Object> toLongFunction2 = (ToLongFunction<? super Object>)transformer;
                            final long n5 = result;
                            final LongBinaryOperator longBinaryOperator2 = reducer;
                            BytecodeManager.incBytecodes(24);
                            final MapReduceValuesToLongTask rights2 = new MapReduceValuesToLongTask<K, V>(this, batch2, baseLimit2, n4, (Node<K, V>[])tab, rights, toLongFunction2, n5, longBinaryOperator2);
                            this.rights = rights2;
                            BytecodeManager.incBytecodes(2);
                            BytecodeManager.incBytecodes(1);
                            rights2.fork();
                            BytecodeManager.incBytecodes(2);
                        }
                        while (true) {
                            BytecodeManager.incBytecodes(2);
                            final Node<K, V> advance = this.advance();
                            BytecodeManager.incBytecodes(3);
                            if (advance == null) {
                                break;
                            }
                            final LongBinaryOperator longBinaryOperator3 = reducer;
                            final long n6 = result;
                            final ToLongFunction<V> toLongFunction3 = (ToLongFunction<V>)transformer;
                            final V val = advance.val;
                            BytecodeManager.incBytecodes(6);
                            final long applyAsLong = toLongFunction3.applyAsLong(val);
                            BytecodeManager.incBytecodes(1);
                            result = longBinaryOperator3.applyAsLong(n6, applyAsLong);
                            BytecodeManager.incBytecodes(2);
                        }
                        this.result = result;
                        BytecodeManager.incBytecodes(3);
                        BytecodeManager.incBytecodes(2);
                        CountedCompleter<?> countedCompleter = this.firstComplete();
                        BytecodeManager.incBytecodes(1);
                        while (true) {
                            final CountedCompleter<?> countedCompleter2 = countedCompleter;
                            BytecodeManager.incBytecodes(2);
                            if (countedCompleter2 == null) {
                                break;
                            }
                            final MapReduceValuesToLongTask<?, ?> mapReduceValuesToLongTask = (MapReduceValuesToLongTask<?, ?>)countedCompleter;
                            BytecodeManager.incBytecodes(3);
                            MapReduceValuesToLongTask<?, ?> rights3 = mapReduceValuesToLongTask.rights;
                            BytecodeManager.incBytecodes(3);
                            while (true) {
                                final MapReduceValuesToLongTask<?, ?> mapReduceValuesToLongTask2 = rights3;
                                BytecodeManager.incBytecodes(2);
                                if (mapReduceValuesToLongTask2 == null) {
                                    break;
                                }
                                final MapReduceValuesToLongTask<?, ?> mapReduceValuesToLongTask3 = mapReduceValuesToLongTask;
                                final LongBinaryOperator longBinaryOperator4 = reducer;
                                final long result2 = mapReduceValuesToLongTask.result;
                                final long result3 = rights3.result;
                                BytecodeManager.incBytecodes(7);
                                mapReduceValuesToLongTask3.result = longBinaryOperator4.applyAsLong(result2, result3);
                                BytecodeManager.incBytecodes(1);
                                final MapReduceValuesToLongTask<?, ?> mapReduceValuesToLongTask4 = mapReduceValuesToLongTask;
                                final MapReduceValuesToLongTask<?, ?> nextRight = rights3.nextRight;
                                mapReduceValuesToLongTask4.rights = nextRight;
                                rights3 = nextRight;
                                BytecodeManager.incBytecodes(7);
                            }
                            final MapReduceValuesToLongTask<?, ?> mapReduceValuesToLongTask5 = (MapReduceValuesToLongTask<?, ?>)countedCompleter;
                            BytecodeManager.incBytecodes(2);
                            countedCompleter = mapReduceValuesToLongTask5.nextComplete();
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
    }
    
    static final class MapReduceEntriesToLongTask<K, V> extends BulkTask<K, V, Long>
    {
        final ToLongFunction<Map.Entry<K, V>> transformer;
        final LongBinaryOperator reducer;
        final long basis;
        long result;
        MapReduceEntriesToLongTask<K, V> rights;
        MapReduceEntriesToLongTask<K, V> nextRight;
        
        MapReduceEntriesToLongTask(final BulkTask<K, V, ?> bulkTask, final int n, final int n2, final int n3, final Node<K, V>[] array, final MapReduceEntriesToLongTask<K, V> nextRight, final ToLongFunction<Map.Entry<K, V>> transformer, final long basis, final LongBinaryOperator reducer) {
            try {
                BytecodeManager.incBytecodes(7);
                super(bulkTask, n, n2, n3, array);
                this.nextRight = nextRight;
                BytecodeManager.incBytecodes(3);
                this.transformer = transformer;
                BytecodeManager.incBytecodes(3);
                this.basis = basis;
                this.reducer = reducer;
                BytecodeManager.incBytecodes(6);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final Long getRawResult() {
            try {
                final long result = this.result;
                BytecodeManager.incBytecodes(3);
                final Long value = result;
                BytecodeManager.incBytecodes(1);
                return value;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final void compute() {
            try {
                final ToLongFunction<Map.Entry<K, V>> transformer;
                final ToLongFunction<Map.Entry<K, V>> toLongFunction = transformer = this.transformer;
                BytecodeManager.incBytecodes(5);
                if (toLongFunction != null) {
                    final LongBinaryOperator reducer;
                    final LongBinaryOperator longBinaryOperator = reducer = this.reducer;
                    BytecodeManager.incBytecodes(5);
                    if (longBinaryOperator != null) {
                        long result = this.basis;
                        BytecodeManager.incBytecodes(3);
                        final int baseIndex = this.baseIndex;
                        BytecodeManager.incBytecodes(3);
                        while (true) {
                            final int batch = this.batch;
                            BytecodeManager.incBytecodes(3);
                            if (batch <= 0) {
                                break;
                            }
                            final int baseLimit;
                            final int n = (baseLimit = this.baseLimit) + baseIndex >>> 1;
                            final int n2 = baseIndex;
                            BytecodeManager.incBytecodes(12);
                            if (n <= n2) {
                                break;
                            }
                            final int n3 = 1;
                            BytecodeManager.incBytecodes(3);
                            this.addToPendingCount(n3);
                            final int batch2 = this.batch >>> 1;
                            this.batch = batch2;
                            final int baseLimit2 = n;
                            this.baseLimit = baseLimit2;
                            final int n4 = baseLimit;
                            final Node<K, V>[] tab = this.tab;
                            final MapReduceEntriesToLongTask<K, V> rights = this.rights;
                            final ToLongFunction<Map.Entry<Object, Object>> toLongFunction2 = (ToLongFunction<Map.Entry<Object, Object>>)transformer;
                            final long n5 = result;
                            final LongBinaryOperator longBinaryOperator2 = reducer;
                            BytecodeManager.incBytecodes(24);
                            final MapReduceEntriesToLongTask rights2 = new MapReduceEntriesToLongTask<K, V>(this, batch2, baseLimit2, n4, (Node<K, V>[])tab, rights, (ToLongFunction<Map.Entry<K, V>>)toLongFunction2, n5, longBinaryOperator2);
                            this.rights = rights2;
                            BytecodeManager.incBytecodes(2);
                            BytecodeManager.incBytecodes(1);
                            rights2.fork();
                            BytecodeManager.incBytecodes(2);
                        }
                        while (true) {
                            BytecodeManager.incBytecodes(2);
                            final Node<Object, Object> advance = (Node<Object, Object>)this.advance();
                            BytecodeManager.incBytecodes(3);
                            if (advance == null) {
                                break;
                            }
                            final LongBinaryOperator longBinaryOperator3 = reducer;
                            final long n6 = result;
                            final ToLongFunction<Map.Entry<K, V>> toLongFunction3 = transformer;
                            final Map.Entry<K, V> entry = (Map.Entry<K, V>)advance;
                            BytecodeManager.incBytecodes(5);
                            final long applyAsLong = toLongFunction3.applyAsLong(entry);
                            BytecodeManager.incBytecodes(1);
                            result = longBinaryOperator3.applyAsLong(n6, applyAsLong);
                            BytecodeManager.incBytecodes(2);
                        }
                        this.result = result;
                        BytecodeManager.incBytecodes(3);
                        BytecodeManager.incBytecodes(2);
                        CountedCompleter<?> countedCompleter = this.firstComplete();
                        BytecodeManager.incBytecodes(1);
                        while (true) {
                            final CountedCompleter<?> countedCompleter2 = countedCompleter;
                            BytecodeManager.incBytecodes(2);
                            if (countedCompleter2 == null) {
                                break;
                            }
                            final MapReduceEntriesToLongTask<?, ?> mapReduceEntriesToLongTask = (MapReduceEntriesToLongTask<?, ?>)countedCompleter;
                            BytecodeManager.incBytecodes(3);
                            MapReduceEntriesToLongTask<?, ?> rights3 = mapReduceEntriesToLongTask.rights;
                            BytecodeManager.incBytecodes(3);
                            while (true) {
                                final MapReduceEntriesToLongTask<?, ?> mapReduceEntriesToLongTask2 = rights3;
                                BytecodeManager.incBytecodes(2);
                                if (mapReduceEntriesToLongTask2 == null) {
                                    break;
                                }
                                final MapReduceEntriesToLongTask<?, ?> mapReduceEntriesToLongTask3 = mapReduceEntriesToLongTask;
                                final LongBinaryOperator longBinaryOperator4 = reducer;
                                final long result2 = mapReduceEntriesToLongTask.result;
                                final long result3 = rights3.result;
                                BytecodeManager.incBytecodes(7);
                                mapReduceEntriesToLongTask3.result = longBinaryOperator4.applyAsLong(result2, result3);
                                BytecodeManager.incBytecodes(1);
                                final MapReduceEntriesToLongTask<?, ?> mapReduceEntriesToLongTask4 = mapReduceEntriesToLongTask;
                                final MapReduceEntriesToLongTask<?, ?> nextRight = rights3.nextRight;
                                mapReduceEntriesToLongTask4.rights = nextRight;
                                rights3 = nextRight;
                                BytecodeManager.incBytecodes(7);
                            }
                            final MapReduceEntriesToLongTask<?, ?> mapReduceEntriesToLongTask5 = (MapReduceEntriesToLongTask<?, ?>)countedCompleter;
                            BytecodeManager.incBytecodes(2);
                            countedCompleter = mapReduceEntriesToLongTask5.nextComplete();
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
    }
    
    static final class MapReduceMappingsToLongTask<K, V> extends BulkTask<K, V, Long>
    {
        final ToLongBiFunction<? super K, ? super V> transformer;
        final LongBinaryOperator reducer;
        final long basis;
        long result;
        MapReduceMappingsToLongTask<K, V> rights;
        MapReduceMappingsToLongTask<K, V> nextRight;
        
        MapReduceMappingsToLongTask(final BulkTask<K, V, ?> bulkTask, final int n, final int n2, final int n3, final Node<K, V>[] array, final MapReduceMappingsToLongTask<K, V> nextRight, final ToLongBiFunction<? super K, ? super V> transformer, final long basis, final LongBinaryOperator reducer) {
            try {
                BytecodeManager.incBytecodes(7);
                super(bulkTask, n, n2, n3, array);
                this.nextRight = nextRight;
                BytecodeManager.incBytecodes(3);
                this.transformer = transformer;
                BytecodeManager.incBytecodes(3);
                this.basis = basis;
                this.reducer = reducer;
                BytecodeManager.incBytecodes(6);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final Long getRawResult() {
            try {
                final long result = this.result;
                BytecodeManager.incBytecodes(3);
                final Long value = result;
                BytecodeManager.incBytecodes(1);
                return value;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final void compute() {
            try {
                final ToLongBiFunction<? super K, ? super V> transformer;
                final ToLongBiFunction<? super K, ? super V> toLongBiFunction = transformer = this.transformer;
                BytecodeManager.incBytecodes(5);
                if (toLongBiFunction != null) {
                    final LongBinaryOperator reducer;
                    final LongBinaryOperator longBinaryOperator = reducer = this.reducer;
                    BytecodeManager.incBytecodes(5);
                    if (longBinaryOperator != null) {
                        long result = this.basis;
                        BytecodeManager.incBytecodes(3);
                        final int baseIndex = this.baseIndex;
                        BytecodeManager.incBytecodes(3);
                        while (true) {
                            final int batch = this.batch;
                            BytecodeManager.incBytecodes(3);
                            if (batch <= 0) {
                                break;
                            }
                            final int baseLimit;
                            final int n = (baseLimit = this.baseLimit) + baseIndex >>> 1;
                            final int n2 = baseIndex;
                            BytecodeManager.incBytecodes(12);
                            if (n <= n2) {
                                break;
                            }
                            final int n3 = 1;
                            BytecodeManager.incBytecodes(3);
                            this.addToPendingCount(n3);
                            final int batch2 = this.batch >>> 1;
                            this.batch = batch2;
                            final int baseLimit2 = n;
                            this.baseLimit = baseLimit2;
                            final int n4 = baseLimit;
                            final Node<K, V>[] tab = this.tab;
                            final MapReduceMappingsToLongTask<K, V> rights = this.rights;
                            final ToLongBiFunction<? super Object, ? super Object> toLongBiFunction2 = (ToLongBiFunction<? super Object, ? super Object>)transformer;
                            final long n5 = result;
                            final LongBinaryOperator longBinaryOperator2 = reducer;
                            BytecodeManager.incBytecodes(24);
                            final MapReduceMappingsToLongTask rights2 = new MapReduceMappingsToLongTask<K, V>(this, batch2, baseLimit2, n4, (Node<K, V>[])tab, rights, toLongBiFunction2, n5, longBinaryOperator2);
                            this.rights = rights2;
                            BytecodeManager.incBytecodes(2);
                            BytecodeManager.incBytecodes(1);
                            rights2.fork();
                            BytecodeManager.incBytecodes(2);
                        }
                        while (true) {
                            BytecodeManager.incBytecodes(2);
                            final Node<K, V> advance;
                            final Node<K, V> node = advance = this.advance();
                            BytecodeManager.incBytecodes(3);
                            if (node == null) {
                                break;
                            }
                            final LongBinaryOperator longBinaryOperator3 = reducer;
                            final long n6 = result;
                            final ToLongBiFunction<K, V> toLongBiFunction3 = (ToLongBiFunction<K, V>)transformer;
                            final K key = advance.key;
                            final V val = advance.val;
                            BytecodeManager.incBytecodes(8);
                            final long applyAsLong = toLongBiFunction3.applyAsLong(key, val);
                            BytecodeManager.incBytecodes(1);
                            result = longBinaryOperator3.applyAsLong(n6, applyAsLong);
                            BytecodeManager.incBytecodes(2);
                        }
                        this.result = result;
                        BytecodeManager.incBytecodes(3);
                        BytecodeManager.incBytecodes(2);
                        CountedCompleter<?> countedCompleter = this.firstComplete();
                        BytecodeManager.incBytecodes(1);
                        while (true) {
                            final CountedCompleter<?> countedCompleter2 = countedCompleter;
                            BytecodeManager.incBytecodes(2);
                            if (countedCompleter2 == null) {
                                break;
                            }
                            final MapReduceMappingsToLongTask<?, ?> mapReduceMappingsToLongTask = (MapReduceMappingsToLongTask<?, ?>)countedCompleter;
                            BytecodeManager.incBytecodes(3);
                            MapReduceMappingsToLongTask<?, ?> rights3 = mapReduceMappingsToLongTask.rights;
                            BytecodeManager.incBytecodes(3);
                            while (true) {
                                final MapReduceMappingsToLongTask<?, ?> mapReduceMappingsToLongTask2 = rights3;
                                BytecodeManager.incBytecodes(2);
                                if (mapReduceMappingsToLongTask2 == null) {
                                    break;
                                }
                                final MapReduceMappingsToLongTask<?, ?> mapReduceMappingsToLongTask3 = mapReduceMappingsToLongTask;
                                final LongBinaryOperator longBinaryOperator4 = reducer;
                                final long result2 = mapReduceMappingsToLongTask.result;
                                final long result3 = rights3.result;
                                BytecodeManager.incBytecodes(7);
                                mapReduceMappingsToLongTask3.result = longBinaryOperator4.applyAsLong(result2, result3);
                                BytecodeManager.incBytecodes(1);
                                final MapReduceMappingsToLongTask<?, ?> mapReduceMappingsToLongTask4 = mapReduceMappingsToLongTask;
                                final MapReduceMappingsToLongTask<?, ?> nextRight = rights3.nextRight;
                                mapReduceMappingsToLongTask4.rights = nextRight;
                                rights3 = nextRight;
                                BytecodeManager.incBytecodes(7);
                            }
                            final MapReduceMappingsToLongTask<?, ?> mapReduceMappingsToLongTask5 = (MapReduceMappingsToLongTask<?, ?>)countedCompleter;
                            BytecodeManager.incBytecodes(2);
                            countedCompleter = mapReduceMappingsToLongTask5.nextComplete();
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
    }
    
    static final class MapReduceKeysToIntTask<K, V> extends BulkTask<K, V, Integer>
    {
        final ToIntFunction<? super K> transformer;
        final IntBinaryOperator reducer;
        final int basis;
        int result;
        MapReduceKeysToIntTask<K, V> rights;
        MapReduceKeysToIntTask<K, V> nextRight;
        
        MapReduceKeysToIntTask(final BulkTask<K, V, ?> bulkTask, final int n, final int n2, final int n3, final Node<K, V>[] array, final MapReduceKeysToIntTask<K, V> nextRight, final ToIntFunction<? super K> transformer, final int basis, final IntBinaryOperator reducer) {
            try {
                BytecodeManager.incBytecodes(7);
                super(bulkTask, n, n2, n3, array);
                this.nextRight = nextRight;
                BytecodeManager.incBytecodes(3);
                this.transformer = transformer;
                BytecodeManager.incBytecodes(3);
                this.basis = basis;
                this.reducer = reducer;
                BytecodeManager.incBytecodes(6);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final Integer getRawResult() {
            try {
                final int result = this.result;
                BytecodeManager.incBytecodes(3);
                final Integer value = result;
                BytecodeManager.incBytecodes(1);
                return value;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final void compute() {
            try {
                final ToIntFunction<? super K> transformer;
                final ToIntFunction<? super K> toIntFunction = transformer = this.transformer;
                BytecodeManager.incBytecodes(5);
                if (toIntFunction != null) {
                    final IntBinaryOperator reducer;
                    final IntBinaryOperator intBinaryOperator = reducer = this.reducer;
                    BytecodeManager.incBytecodes(5);
                    if (intBinaryOperator != null) {
                        int result = this.basis;
                        BytecodeManager.incBytecodes(3);
                        final int baseIndex = this.baseIndex;
                        BytecodeManager.incBytecodes(3);
                        while (true) {
                            final int batch = this.batch;
                            BytecodeManager.incBytecodes(3);
                            if (batch <= 0) {
                                break;
                            }
                            final int baseLimit;
                            final int n = (baseLimit = this.baseLimit) + baseIndex >>> 1;
                            final int n2 = baseIndex;
                            BytecodeManager.incBytecodes(12);
                            if (n <= n2) {
                                break;
                            }
                            final int n3 = 1;
                            BytecodeManager.incBytecodes(3);
                            this.addToPendingCount(n3);
                            final int batch2 = this.batch >>> 1;
                            this.batch = batch2;
                            final int baseLimit2 = n;
                            this.baseLimit = baseLimit2;
                            final int n4 = baseLimit;
                            final Node<K, V>[] tab = this.tab;
                            final MapReduceKeysToIntTask<K, V> rights = this.rights;
                            final ToIntFunction<? super Object> toIntFunction2 = (ToIntFunction<? super Object>)transformer;
                            final int n5 = result;
                            final IntBinaryOperator intBinaryOperator2 = reducer;
                            BytecodeManager.incBytecodes(24);
                            final MapReduceKeysToIntTask rights2 = new MapReduceKeysToIntTask<K, V>(this, batch2, baseLimit2, n4, (Node<K, V>[])tab, rights, toIntFunction2, n5, intBinaryOperator2);
                            this.rights = rights2;
                            BytecodeManager.incBytecodes(2);
                            BytecodeManager.incBytecodes(1);
                            rights2.fork();
                            BytecodeManager.incBytecodes(2);
                        }
                        while (true) {
                            BytecodeManager.incBytecodes(2);
                            final Node<K, V> advance = this.advance();
                            BytecodeManager.incBytecodes(3);
                            if (advance == null) {
                                break;
                            }
                            final IntBinaryOperator intBinaryOperator3 = reducer;
                            final int n6 = result;
                            final ToIntFunction<K> toIntFunction3 = (ToIntFunction<K>)transformer;
                            final K key = advance.key;
                            BytecodeManager.incBytecodes(6);
                            final int applyAsInt = toIntFunction3.applyAsInt(key);
                            BytecodeManager.incBytecodes(1);
                            result = intBinaryOperator3.applyAsInt(n6, applyAsInt);
                            BytecodeManager.incBytecodes(2);
                        }
                        this.result = result;
                        BytecodeManager.incBytecodes(3);
                        BytecodeManager.incBytecodes(2);
                        CountedCompleter<?> countedCompleter = this.firstComplete();
                        BytecodeManager.incBytecodes(1);
                        while (true) {
                            final CountedCompleter<?> countedCompleter2 = countedCompleter;
                            BytecodeManager.incBytecodes(2);
                            if (countedCompleter2 == null) {
                                break;
                            }
                            final MapReduceKeysToIntTask<?, ?> mapReduceKeysToIntTask = (MapReduceKeysToIntTask<?, ?>)countedCompleter;
                            BytecodeManager.incBytecodes(3);
                            MapReduceKeysToIntTask<?, ?> rights3 = mapReduceKeysToIntTask.rights;
                            BytecodeManager.incBytecodes(3);
                            while (true) {
                                final MapReduceKeysToIntTask<?, ?> mapReduceKeysToIntTask2 = rights3;
                                BytecodeManager.incBytecodes(2);
                                if (mapReduceKeysToIntTask2 == null) {
                                    break;
                                }
                                final MapReduceKeysToIntTask<?, ?> mapReduceKeysToIntTask3 = mapReduceKeysToIntTask;
                                final IntBinaryOperator intBinaryOperator4 = reducer;
                                final int result2 = mapReduceKeysToIntTask.result;
                                final int result3 = rights3.result;
                                BytecodeManager.incBytecodes(7);
                                mapReduceKeysToIntTask3.result = intBinaryOperator4.applyAsInt(result2, result3);
                                BytecodeManager.incBytecodes(1);
                                final MapReduceKeysToIntTask<?, ?> mapReduceKeysToIntTask4 = mapReduceKeysToIntTask;
                                final MapReduceKeysToIntTask<?, ?> nextRight = rights3.nextRight;
                                mapReduceKeysToIntTask4.rights = nextRight;
                                rights3 = nextRight;
                                BytecodeManager.incBytecodes(7);
                            }
                            final MapReduceKeysToIntTask<?, ?> mapReduceKeysToIntTask5 = (MapReduceKeysToIntTask<?, ?>)countedCompleter;
                            BytecodeManager.incBytecodes(2);
                            countedCompleter = mapReduceKeysToIntTask5.nextComplete();
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
    }
    
    static final class MapReduceValuesToIntTask<K, V> extends BulkTask<K, V, Integer>
    {
        final ToIntFunction<? super V> transformer;
        final IntBinaryOperator reducer;
        final int basis;
        int result;
        MapReduceValuesToIntTask<K, V> rights;
        MapReduceValuesToIntTask<K, V> nextRight;
        
        MapReduceValuesToIntTask(final BulkTask<K, V, ?> bulkTask, final int n, final int n2, final int n3, final Node<K, V>[] array, final MapReduceValuesToIntTask<K, V> nextRight, final ToIntFunction<? super V> transformer, final int basis, final IntBinaryOperator reducer) {
            try {
                BytecodeManager.incBytecodes(7);
                super(bulkTask, n, n2, n3, array);
                this.nextRight = nextRight;
                BytecodeManager.incBytecodes(3);
                this.transformer = transformer;
                BytecodeManager.incBytecodes(3);
                this.basis = basis;
                this.reducer = reducer;
                BytecodeManager.incBytecodes(6);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final Integer getRawResult() {
            try {
                final int result = this.result;
                BytecodeManager.incBytecodes(3);
                final Integer value = result;
                BytecodeManager.incBytecodes(1);
                return value;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final void compute() {
            try {
                final ToIntFunction<? super V> transformer;
                final ToIntFunction<? super V> toIntFunction = transformer = this.transformer;
                BytecodeManager.incBytecodes(5);
                if (toIntFunction != null) {
                    final IntBinaryOperator reducer;
                    final IntBinaryOperator intBinaryOperator = reducer = this.reducer;
                    BytecodeManager.incBytecodes(5);
                    if (intBinaryOperator != null) {
                        int result = this.basis;
                        BytecodeManager.incBytecodes(3);
                        final int baseIndex = this.baseIndex;
                        BytecodeManager.incBytecodes(3);
                        while (true) {
                            final int batch = this.batch;
                            BytecodeManager.incBytecodes(3);
                            if (batch <= 0) {
                                break;
                            }
                            final int baseLimit;
                            final int n = (baseLimit = this.baseLimit) + baseIndex >>> 1;
                            final int n2 = baseIndex;
                            BytecodeManager.incBytecodes(12);
                            if (n <= n2) {
                                break;
                            }
                            final int n3 = 1;
                            BytecodeManager.incBytecodes(3);
                            this.addToPendingCount(n3);
                            final int batch2 = this.batch >>> 1;
                            this.batch = batch2;
                            final int baseLimit2 = n;
                            this.baseLimit = baseLimit2;
                            final int n4 = baseLimit;
                            final Node<K, V>[] tab = this.tab;
                            final MapReduceValuesToIntTask<K, V> rights = this.rights;
                            final ToIntFunction<? super Object> toIntFunction2 = (ToIntFunction<? super Object>)transformer;
                            final int n5 = result;
                            final IntBinaryOperator intBinaryOperator2 = reducer;
                            BytecodeManager.incBytecodes(24);
                            final MapReduceValuesToIntTask rights2 = new MapReduceValuesToIntTask<K, V>(this, batch2, baseLimit2, n4, (Node<K, V>[])tab, rights, toIntFunction2, n5, intBinaryOperator2);
                            this.rights = rights2;
                            BytecodeManager.incBytecodes(2);
                            BytecodeManager.incBytecodes(1);
                            rights2.fork();
                            BytecodeManager.incBytecodes(2);
                        }
                        while (true) {
                            BytecodeManager.incBytecodes(2);
                            final Node<K, V> advance = this.advance();
                            BytecodeManager.incBytecodes(3);
                            if (advance == null) {
                                break;
                            }
                            final IntBinaryOperator intBinaryOperator3 = reducer;
                            final int n6 = result;
                            final ToIntFunction<V> toIntFunction3 = (ToIntFunction<V>)transformer;
                            final V val = advance.val;
                            BytecodeManager.incBytecodes(6);
                            final int applyAsInt = toIntFunction3.applyAsInt(val);
                            BytecodeManager.incBytecodes(1);
                            result = intBinaryOperator3.applyAsInt(n6, applyAsInt);
                            BytecodeManager.incBytecodes(2);
                        }
                        this.result = result;
                        BytecodeManager.incBytecodes(3);
                        BytecodeManager.incBytecodes(2);
                        CountedCompleter<?> countedCompleter = this.firstComplete();
                        BytecodeManager.incBytecodes(1);
                        while (true) {
                            final CountedCompleter<?> countedCompleter2 = countedCompleter;
                            BytecodeManager.incBytecodes(2);
                            if (countedCompleter2 == null) {
                                break;
                            }
                            final MapReduceValuesToIntTask<?, ?> mapReduceValuesToIntTask = (MapReduceValuesToIntTask<?, ?>)countedCompleter;
                            BytecodeManager.incBytecodes(3);
                            MapReduceValuesToIntTask<?, ?> rights3 = mapReduceValuesToIntTask.rights;
                            BytecodeManager.incBytecodes(3);
                            while (true) {
                                final MapReduceValuesToIntTask<?, ?> mapReduceValuesToIntTask2 = rights3;
                                BytecodeManager.incBytecodes(2);
                                if (mapReduceValuesToIntTask2 == null) {
                                    break;
                                }
                                final MapReduceValuesToIntTask<?, ?> mapReduceValuesToIntTask3 = mapReduceValuesToIntTask;
                                final IntBinaryOperator intBinaryOperator4 = reducer;
                                final int result2 = mapReduceValuesToIntTask.result;
                                final int result3 = rights3.result;
                                BytecodeManager.incBytecodes(7);
                                mapReduceValuesToIntTask3.result = intBinaryOperator4.applyAsInt(result2, result3);
                                BytecodeManager.incBytecodes(1);
                                final MapReduceValuesToIntTask<?, ?> mapReduceValuesToIntTask4 = mapReduceValuesToIntTask;
                                final MapReduceValuesToIntTask<?, ?> nextRight = rights3.nextRight;
                                mapReduceValuesToIntTask4.rights = nextRight;
                                rights3 = nextRight;
                                BytecodeManager.incBytecodes(7);
                            }
                            final MapReduceValuesToIntTask<?, ?> mapReduceValuesToIntTask5 = (MapReduceValuesToIntTask<?, ?>)countedCompleter;
                            BytecodeManager.incBytecodes(2);
                            countedCompleter = mapReduceValuesToIntTask5.nextComplete();
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
    }
    
    static final class MapReduceEntriesToIntTask<K, V> extends BulkTask<K, V, Integer>
    {
        final ToIntFunction<Map.Entry<K, V>> transformer;
        final IntBinaryOperator reducer;
        final int basis;
        int result;
        MapReduceEntriesToIntTask<K, V> rights;
        MapReduceEntriesToIntTask<K, V> nextRight;
        
        MapReduceEntriesToIntTask(final BulkTask<K, V, ?> bulkTask, final int n, final int n2, final int n3, final Node<K, V>[] array, final MapReduceEntriesToIntTask<K, V> nextRight, final ToIntFunction<Map.Entry<K, V>> transformer, final int basis, final IntBinaryOperator reducer) {
            try {
                BytecodeManager.incBytecodes(7);
                super(bulkTask, n, n2, n3, array);
                this.nextRight = nextRight;
                BytecodeManager.incBytecodes(3);
                this.transformer = transformer;
                BytecodeManager.incBytecodes(3);
                this.basis = basis;
                this.reducer = reducer;
                BytecodeManager.incBytecodes(6);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final Integer getRawResult() {
            try {
                final int result = this.result;
                BytecodeManager.incBytecodes(3);
                final Integer value = result;
                BytecodeManager.incBytecodes(1);
                return value;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final void compute() {
            try {
                final ToIntFunction<Map.Entry<K, V>> transformer;
                final ToIntFunction<Map.Entry<K, V>> toIntFunction = transformer = this.transformer;
                BytecodeManager.incBytecodes(5);
                if (toIntFunction != null) {
                    final IntBinaryOperator reducer;
                    final IntBinaryOperator intBinaryOperator = reducer = this.reducer;
                    BytecodeManager.incBytecodes(5);
                    if (intBinaryOperator != null) {
                        int result = this.basis;
                        BytecodeManager.incBytecodes(3);
                        final int baseIndex = this.baseIndex;
                        BytecodeManager.incBytecodes(3);
                        while (true) {
                            final int batch = this.batch;
                            BytecodeManager.incBytecodes(3);
                            if (batch <= 0) {
                                break;
                            }
                            final int baseLimit;
                            final int n = (baseLimit = this.baseLimit) + baseIndex >>> 1;
                            final int n2 = baseIndex;
                            BytecodeManager.incBytecodes(12);
                            if (n <= n2) {
                                break;
                            }
                            final int n3 = 1;
                            BytecodeManager.incBytecodes(3);
                            this.addToPendingCount(n3);
                            final int batch2 = this.batch >>> 1;
                            this.batch = batch2;
                            final int baseLimit2 = n;
                            this.baseLimit = baseLimit2;
                            final int n4 = baseLimit;
                            final Node<K, V>[] tab = this.tab;
                            final MapReduceEntriesToIntTask<K, V> rights = this.rights;
                            final ToIntFunction<Map.Entry<Object, Object>> toIntFunction2 = (ToIntFunction<Map.Entry<Object, Object>>)transformer;
                            final int n5 = result;
                            final IntBinaryOperator intBinaryOperator2 = reducer;
                            BytecodeManager.incBytecodes(24);
                            final MapReduceEntriesToIntTask rights2 = new MapReduceEntriesToIntTask<K, V>(this, batch2, baseLimit2, n4, (Node<K, V>[])tab, rights, (ToIntFunction<Map.Entry<K, V>>)toIntFunction2, n5, intBinaryOperator2);
                            this.rights = rights2;
                            BytecodeManager.incBytecodes(2);
                            BytecodeManager.incBytecodes(1);
                            rights2.fork();
                            BytecodeManager.incBytecodes(2);
                        }
                        while (true) {
                            BytecodeManager.incBytecodes(2);
                            final Node<Object, Object> advance = (Node<Object, Object>)this.advance();
                            BytecodeManager.incBytecodes(3);
                            if (advance == null) {
                                break;
                            }
                            final IntBinaryOperator intBinaryOperator3 = reducer;
                            final int n6 = result;
                            final ToIntFunction<Map.Entry<K, V>> toIntFunction3 = transformer;
                            final Map.Entry<K, V> entry = (Map.Entry<K, V>)advance;
                            BytecodeManager.incBytecodes(5);
                            final int applyAsInt = toIntFunction3.applyAsInt(entry);
                            BytecodeManager.incBytecodes(1);
                            result = intBinaryOperator3.applyAsInt(n6, applyAsInt);
                            BytecodeManager.incBytecodes(2);
                        }
                        this.result = result;
                        BytecodeManager.incBytecodes(3);
                        BytecodeManager.incBytecodes(2);
                        CountedCompleter<?> countedCompleter = this.firstComplete();
                        BytecodeManager.incBytecodes(1);
                        while (true) {
                            final CountedCompleter<?> countedCompleter2 = countedCompleter;
                            BytecodeManager.incBytecodes(2);
                            if (countedCompleter2 == null) {
                                break;
                            }
                            final MapReduceEntriesToIntTask<?, ?> mapReduceEntriesToIntTask = (MapReduceEntriesToIntTask<?, ?>)countedCompleter;
                            BytecodeManager.incBytecodes(3);
                            MapReduceEntriesToIntTask<?, ?> rights3 = mapReduceEntriesToIntTask.rights;
                            BytecodeManager.incBytecodes(3);
                            while (true) {
                                final MapReduceEntriesToIntTask<?, ?> mapReduceEntriesToIntTask2 = rights3;
                                BytecodeManager.incBytecodes(2);
                                if (mapReduceEntriesToIntTask2 == null) {
                                    break;
                                }
                                final MapReduceEntriesToIntTask<?, ?> mapReduceEntriesToIntTask3 = mapReduceEntriesToIntTask;
                                final IntBinaryOperator intBinaryOperator4 = reducer;
                                final int result2 = mapReduceEntriesToIntTask.result;
                                final int result3 = rights3.result;
                                BytecodeManager.incBytecodes(7);
                                mapReduceEntriesToIntTask3.result = intBinaryOperator4.applyAsInt(result2, result3);
                                BytecodeManager.incBytecodes(1);
                                final MapReduceEntriesToIntTask<?, ?> mapReduceEntriesToIntTask4 = mapReduceEntriesToIntTask;
                                final MapReduceEntriesToIntTask<?, ?> nextRight = rights3.nextRight;
                                mapReduceEntriesToIntTask4.rights = nextRight;
                                rights3 = nextRight;
                                BytecodeManager.incBytecodes(7);
                            }
                            final MapReduceEntriesToIntTask<?, ?> mapReduceEntriesToIntTask5 = (MapReduceEntriesToIntTask<?, ?>)countedCompleter;
                            BytecodeManager.incBytecodes(2);
                            countedCompleter = mapReduceEntriesToIntTask5.nextComplete();
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
    }
    
    static final class MapReduceMappingsToIntTask<K, V> extends BulkTask<K, V, Integer>
    {
        final ToIntBiFunction<? super K, ? super V> transformer;
        final IntBinaryOperator reducer;
        final int basis;
        int result;
        MapReduceMappingsToIntTask<K, V> rights;
        MapReduceMappingsToIntTask<K, V> nextRight;
        
        MapReduceMappingsToIntTask(final BulkTask<K, V, ?> bulkTask, final int n, final int n2, final int n3, final Node<K, V>[] array, final MapReduceMappingsToIntTask<K, V> nextRight, final ToIntBiFunction<? super K, ? super V> transformer, final int basis, final IntBinaryOperator reducer) {
            try {
                BytecodeManager.incBytecodes(7);
                super(bulkTask, n, n2, n3, array);
                this.nextRight = nextRight;
                BytecodeManager.incBytecodes(3);
                this.transformer = transformer;
                BytecodeManager.incBytecodes(3);
                this.basis = basis;
                this.reducer = reducer;
                BytecodeManager.incBytecodes(6);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final Integer getRawResult() {
            try {
                final int result = this.result;
                BytecodeManager.incBytecodes(3);
                final Integer value = result;
                BytecodeManager.incBytecodes(1);
                return value;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final void compute() {
            try {
                final ToIntBiFunction<? super K, ? super V> transformer;
                final ToIntBiFunction<? super K, ? super V> toIntBiFunction = transformer = this.transformer;
                BytecodeManager.incBytecodes(5);
                if (toIntBiFunction != null) {
                    final IntBinaryOperator reducer;
                    final IntBinaryOperator intBinaryOperator = reducer = this.reducer;
                    BytecodeManager.incBytecodes(5);
                    if (intBinaryOperator != null) {
                        int result = this.basis;
                        BytecodeManager.incBytecodes(3);
                        final int baseIndex = this.baseIndex;
                        BytecodeManager.incBytecodes(3);
                        while (true) {
                            final int batch = this.batch;
                            BytecodeManager.incBytecodes(3);
                            if (batch <= 0) {
                                break;
                            }
                            final int baseLimit;
                            final int n = (baseLimit = this.baseLimit) + baseIndex >>> 1;
                            final int n2 = baseIndex;
                            BytecodeManager.incBytecodes(12);
                            if (n <= n2) {
                                break;
                            }
                            final int n3 = 1;
                            BytecodeManager.incBytecodes(3);
                            this.addToPendingCount(n3);
                            final int batch2 = this.batch >>> 1;
                            this.batch = batch2;
                            final int baseLimit2 = n;
                            this.baseLimit = baseLimit2;
                            final int n4 = baseLimit;
                            final Node<K, V>[] tab = this.tab;
                            final MapReduceMappingsToIntTask<K, V> rights = this.rights;
                            final ToIntBiFunction<? super Object, ? super Object> toIntBiFunction2 = (ToIntBiFunction<? super Object, ? super Object>)transformer;
                            final int n5 = result;
                            final IntBinaryOperator intBinaryOperator2 = reducer;
                            BytecodeManager.incBytecodes(24);
                            final MapReduceMappingsToIntTask rights2 = new MapReduceMappingsToIntTask<K, V>(this, batch2, baseLimit2, n4, (Node<K, V>[])tab, rights, toIntBiFunction2, n5, intBinaryOperator2);
                            this.rights = rights2;
                            BytecodeManager.incBytecodes(2);
                            BytecodeManager.incBytecodes(1);
                            rights2.fork();
                            BytecodeManager.incBytecodes(2);
                        }
                        while (true) {
                            BytecodeManager.incBytecodes(2);
                            final Node<K, V> advance;
                            final Node<K, V> node = advance = this.advance();
                            BytecodeManager.incBytecodes(3);
                            if (node == null) {
                                break;
                            }
                            final IntBinaryOperator intBinaryOperator3 = reducer;
                            final int n6 = result;
                            final ToIntBiFunction<K, V> toIntBiFunction3 = (ToIntBiFunction<K, V>)transformer;
                            final K key = advance.key;
                            final V val = advance.val;
                            BytecodeManager.incBytecodes(8);
                            final int applyAsInt = toIntBiFunction3.applyAsInt(key, val);
                            BytecodeManager.incBytecodes(1);
                            result = intBinaryOperator3.applyAsInt(n6, applyAsInt);
                            BytecodeManager.incBytecodes(2);
                        }
                        this.result = result;
                        BytecodeManager.incBytecodes(3);
                        BytecodeManager.incBytecodes(2);
                        CountedCompleter<?> countedCompleter = this.firstComplete();
                        BytecodeManager.incBytecodes(1);
                        while (true) {
                            final CountedCompleter<?> countedCompleter2 = countedCompleter;
                            BytecodeManager.incBytecodes(2);
                            if (countedCompleter2 == null) {
                                break;
                            }
                            final MapReduceMappingsToIntTask<?, ?> mapReduceMappingsToIntTask = (MapReduceMappingsToIntTask<?, ?>)countedCompleter;
                            BytecodeManager.incBytecodes(3);
                            MapReduceMappingsToIntTask<?, ?> rights3 = mapReduceMappingsToIntTask.rights;
                            BytecodeManager.incBytecodes(3);
                            while (true) {
                                final MapReduceMappingsToIntTask<?, ?> mapReduceMappingsToIntTask2 = rights3;
                                BytecodeManager.incBytecodes(2);
                                if (mapReduceMappingsToIntTask2 == null) {
                                    break;
                                }
                                final MapReduceMappingsToIntTask<?, ?> mapReduceMappingsToIntTask3 = mapReduceMappingsToIntTask;
                                final IntBinaryOperator intBinaryOperator4 = reducer;
                                final int result2 = mapReduceMappingsToIntTask.result;
                                final int result3 = rights3.result;
                                BytecodeManager.incBytecodes(7);
                                mapReduceMappingsToIntTask3.result = intBinaryOperator4.applyAsInt(result2, result3);
                                BytecodeManager.incBytecodes(1);
                                final MapReduceMappingsToIntTask<?, ?> mapReduceMappingsToIntTask4 = mapReduceMappingsToIntTask;
                                final MapReduceMappingsToIntTask<?, ?> nextRight = rights3.nextRight;
                                mapReduceMappingsToIntTask4.rights = nextRight;
                                rights3 = nextRight;
                                BytecodeManager.incBytecodes(7);
                            }
                            final MapReduceMappingsToIntTask<?, ?> mapReduceMappingsToIntTask5 = (MapReduceMappingsToIntTask<?, ?>)countedCompleter;
                            BytecodeManager.incBytecodes(2);
                            countedCompleter = mapReduceMappingsToIntTask5.nextComplete();
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
    }
}
