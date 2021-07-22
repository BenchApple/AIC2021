// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import instrumented.java.util.function.Consumer;
import java.lang.reflect.Array;
import instrumented.java.util.function.BiFunction;
import instrumented.java.util.function.BiConsumer;
import java.io.StreamCorruptedException;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import aic2021.engine.BytecodeManager;
import java.io.Serializable;

public class IdentityHashMap<K, V> extends AbstractMap<K, V> implements Map<K, V>, Serializable, Cloneable
{
    private static final int DEFAULT_CAPACITY = 32;
    private static final int MINIMUM_CAPACITY = 4;
    private static final int MAXIMUM_CAPACITY = 536870912;
    transient Object[] table;
    int size;
    transient int modCount;
    static final Object NULL_KEY;
    private transient Set<Entry<K, V>> entrySet;
    private static final long serialVersionUID = 8188218128353913216L;
    
    private static Object maskNull(final Object o) {
        try {
            BytecodeManager.incBytecodes(2);
            Object null_KEY;
            if (o == null) {
                null_KEY = IdentityHashMap.NULL_KEY;
                BytecodeManager.incBytecodes(2);
            }
            else {
                null_KEY = o;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return null_KEY;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static final Object unmaskNull(final Object o) {
        try {
            final Object null_KEY = IdentityHashMap.NULL_KEY;
            BytecodeManager.incBytecodes(3);
            Object o2;
            if (o == null_KEY) {
                o2 = null;
                BytecodeManager.incBytecodes(2);
            }
            else {
                o2 = o;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return o2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public IdentityHashMap() {
        try {
            BytecodeManager.incBytecodes(2);
            final int n = 32;
            BytecodeManager.incBytecodes(3);
            this.init(n);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public IdentityHashMap(final int i) {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            if (i < 0) {
                BytecodeManager.incBytecodes(5);
                final StringBuilder sb = new StringBuilder();
                final String str = "expectedMaxSize is negative: ";
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
            BytecodeManager.incBytecodes(3);
            final int capacity = capacity(i);
            BytecodeManager.incBytecodes(1);
            this.init(capacity);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static int capacity(final int n) {
        try {
            final int n2 = 178956970;
            BytecodeManager.incBytecodes(3);
            int highestOneBit;
            if (n > n2) {
                highestOneBit = 536870912;
                BytecodeManager.incBytecodes(2);
            }
            else {
                final int n3 = 2;
                BytecodeManager.incBytecodes(3);
                if (n <= n3) {
                    highestOneBit = 4;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final int i = n + (n << 1);
                    BytecodeManager.incBytecodes(5);
                    BytecodeManager.incBytecodes(1);
                    highestOneBit = Integer.highestOneBit(i);
                }
            }
            BytecodeManager.incBytecodes(1);
            return highestOneBit;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void init(final int n) {
        try {
            this.table = new Object[2 * n];
            BytecodeManager.incBytecodes(5);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public IdentityHashMap(final Map<? extends K, ? extends V> map) {
        try {
            final int n = 1;
            BytecodeManager.incBytecodes(4);
            final int n2 = (int)((n + map.size()) * 1.1);
            BytecodeManager.incBytecodes(6);
            this(n2);
            BytecodeManager.incBytecodes(3);
            this.putAll(map);
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
    
    private static int hash(final Object o, final int n) {
        try {
            BytecodeManager.incBytecodes(2);
            final int identityHashCode = System.identityHashCode(o);
            BytecodeManager.incBytecodes(1);
            final int n2 = (identityHashCode << 1) - (identityHashCode << 8) & n - 1;
            BytecodeManager.incBytecodes(12);
            return n2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static int nextKeyIndex(final int n, final int n2) {
        try {
            final int n3 = n + 2;
            BytecodeManager.incBytecodes(5);
            int n4;
            if (n3 < n2) {
                n4 = n + 2;
                BytecodeManager.incBytecodes(4);
            }
            else {
                n4 = 0;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return n4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public V get(final Object o) {
        try {
            BytecodeManager.incBytecodes(2);
            final Object maskNull = maskNull(o);
            BytecodeManager.incBytecodes(1);
            final Object[] table = this.table;
            BytecodeManager.incBytecodes(3);
            final int length = table.length;
            BytecodeManager.incBytecodes(3);
            final Object o2 = maskNull;
            final int n = length;
            BytecodeManager.incBytecodes(3);
            int n2 = hash(o2, n);
            BytecodeManager.incBytecodes(1);
            while (true) {
                final Object o3 = table[n2];
                BytecodeManager.incBytecodes(4);
                final Object o4 = o3;
                final Object o5 = maskNull;
                BytecodeManager.incBytecodes(3);
                if (o4 == o5) {
                    final Object o6 = table[n2 + 1];
                    BytecodeManager.incBytecodes(6);
                    return (V)o6;
                }
                final Object o7 = o3;
                BytecodeManager.incBytecodes(2);
                if (o7 == null) {
                    final V v = null;
                    BytecodeManager.incBytecodes(2);
                    return v;
                }
                final int n3 = n2;
                final int n4 = length;
                BytecodeManager.incBytecodes(3);
                n2 = nextKeyIndex(n3, n4);
                BytecodeManager.incBytecodes(1);
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
            BytecodeManager.incBytecodes(2);
            final Object maskNull = maskNull(o);
            BytecodeManager.incBytecodes(1);
            final Object[] table = this.table;
            BytecodeManager.incBytecodes(3);
            final int length = table.length;
            BytecodeManager.incBytecodes(3);
            final Object o2 = maskNull;
            final int n = length;
            BytecodeManager.incBytecodes(3);
            int n2 = hash(o2, n);
            BytecodeManager.incBytecodes(1);
            while (true) {
                final Object o3 = table[n2];
                BytecodeManager.incBytecodes(4);
                final Object o4 = o3;
                final Object o5 = maskNull;
                BytecodeManager.incBytecodes(3);
                if (o4 == o5) {
                    final boolean b = true;
                    BytecodeManager.incBytecodes(2);
                    return b;
                }
                final Object o6 = o3;
                BytecodeManager.incBytecodes(2);
                if (o6 == null) {
                    final boolean b2 = false;
                    BytecodeManager.incBytecodes(2);
                    return b2;
                }
                final int n3 = n2;
                final int n4 = length;
                BytecodeManager.incBytecodes(3);
                n2 = nextKeyIndex(n3, n4);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean containsValue(final Object o) {
        try {
            final Object[] table = this.table;
            BytecodeManager.incBytecodes(3);
            int n = 1;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n2 = n;
                final int length = table.length;
                BytecodeManager.incBytecodes(4);
                if (n2 >= length) {
                    final boolean b = false;
                    BytecodeManager.incBytecodes(2);
                    return b;
                }
                final Object o2 = table[n];
                BytecodeManager.incBytecodes(5);
                if (o2 == o) {
                    final Object o3 = table[n - 1];
                    BytecodeManager.incBytecodes(6);
                    if (o3 != null) {
                        final boolean b2 = true;
                        BytecodeManager.incBytecodes(2);
                        return b2;
                    }
                }
                n += 2;
                BytecodeManager.incBytecodes(2);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private boolean containsMapping(final Object o, final Object o2) {
        try {
            BytecodeManager.incBytecodes(2);
            final Object maskNull = maskNull(o);
            BytecodeManager.incBytecodes(1);
            final Object[] table = this.table;
            BytecodeManager.incBytecodes(3);
            final int length = table.length;
            BytecodeManager.incBytecodes(3);
            final Object o3 = maskNull;
            final int n = length;
            BytecodeManager.incBytecodes(3);
            int n2 = hash(o3, n);
            BytecodeManager.incBytecodes(1);
            while (true) {
                final Object o4 = table[n2];
                BytecodeManager.incBytecodes(4);
                final Object o5 = o4;
                final Object o6 = maskNull;
                BytecodeManager.incBytecodes(3);
                if (o5 == o6) {
                    final Object o7 = table[n2 + 1];
                    BytecodeManager.incBytecodes(7);
                    boolean b;
                    if (o7 == o2) {
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
                final Object o8 = o4;
                BytecodeManager.incBytecodes(2);
                if (o8 == null) {
                    final boolean b2 = false;
                    BytecodeManager.incBytecodes(2);
                    return b2;
                }
                final int n3 = n2;
                final int n4 = length;
                BytecodeManager.incBytecodes(3);
                n2 = nextKeyIndex(n3, n4);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public V put(final K k, final V v) {
        try {
            BytecodeManager.incBytecodes(2);
            final Object maskNull = maskNull(k);
            BytecodeManager.incBytecodes(1);
            Object[] table = null;
            int n2 = 0;
            int size = 0;
        Label_0195:
            while (true) {
                table = this.table;
                BytecodeManager.incBytecodes(3);
                final int length = table.length;
                BytecodeManager.incBytecodes(3);
                final Object o = maskNull;
                final int n = length;
                BytecodeManager.incBytecodes(3);
                n2 = hash(o, n);
                BytecodeManager.incBytecodes(1);
                while (true) {
                    final Object o2 = table[n2];
                    BytecodeManager.incBytecodes(6);
                    if (o2 != null) {
                        final Object o3 = o2;
                        final Object o4 = maskNull;
                        BytecodeManager.incBytecodes(3);
                        if (o3 == o4) {
                            final Object o5 = table[n2 + 1];
                            BytecodeManager.incBytecodes(6);
                            table[n2 + 1] = v;
                            BytecodeManager.incBytecodes(6);
                            final Object o6 = o5;
                            BytecodeManager.incBytecodes(2);
                            return (V)o6;
                        }
                        final int n3 = n2;
                        final int n4 = length;
                        BytecodeManager.incBytecodes(3);
                        n2 = nextKeyIndex(n3, n4);
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        size = this.size + 1;
                        BytecodeManager.incBytecodes(5);
                        final int n5 = size + (size << 1);
                        final int n6 = length;
                        BytecodeManager.incBytecodes(7);
                        if (n5 <= n6) {
                            break Label_0195;
                        }
                        final int n7 = length;
                        BytecodeManager.incBytecodes(3);
                        final boolean resize = this.resize(n7);
                        BytecodeManager.incBytecodes(1);
                        if (resize) {
                            BytecodeManager.incBytecodes(1);
                            break;
                        }
                        break Label_0195;
                    }
                }
            }
            ++this.modCount;
            BytecodeManager.incBytecodes(6);
            table[n2] = maskNull;
            BytecodeManager.incBytecodes(4);
            table[n2 + 1] = v;
            BytecodeManager.incBytecodes(6);
            this.size = size;
            BytecodeManager.incBytecodes(3);
            final V v2 = null;
            BytecodeManager.incBytecodes(2);
            return v2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private boolean resize(final int n) {
        try {
            final int n2 = n * 2;
            BytecodeManager.incBytecodes(4);
            final Object[] table = this.table;
            BytecodeManager.incBytecodes(3);
            final int length = table.length;
            BytecodeManager.incBytecodes(3);
            final int n3 = length;
            final int n4 = 1073741824;
            BytecodeManager.incBytecodes(3);
            if (n3 == n4) {
                final int size = this.size;
                final int n5 = 536870911;
                BytecodeManager.incBytecodes(4);
                if (size == n5) {
                    final String s = "Capacity exhausted.";
                    BytecodeManager.incBytecodes(4);
                    final IllegalStateException ex = new IllegalStateException(s);
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final boolean b = false;
                BytecodeManager.incBytecodes(2);
                return b;
            }
            else {
                final int n6 = length;
                final int n7 = n2;
                BytecodeManager.incBytecodes(3);
                if (n6 >= n7) {
                    final boolean b2 = false;
                    BytecodeManager.incBytecodes(2);
                    return b2;
                }
                final Object[] table2 = new Object[n2];
                BytecodeManager.incBytecodes(2);
                int n8 = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n9 = n8;
                    final int n10 = length;
                    BytecodeManager.incBytecodes(3);
                    if (n9 >= n10) {
                        break;
                    }
                    final Object o = table[n8];
                    BytecodeManager.incBytecodes(4);
                    final Object o2 = o;
                    BytecodeManager.incBytecodes(2);
                    if (o2 != null) {
                        final Object o3 = table[n8 + 1];
                        BytecodeManager.incBytecodes(6);
                        table[n8] = null;
                        BytecodeManager.incBytecodes(4);
                        table[n8 + 1] = null;
                        BytecodeManager.incBytecodes(6);
                        final Object o4 = o;
                        final int n11 = n2;
                        BytecodeManager.incBytecodes(3);
                        int n12 = hash(o4, n11);
                        BytecodeManager.incBytecodes(1);
                        while (true) {
                            final Object o5 = table2[n12];
                            BytecodeManager.incBytecodes(4);
                            if (o5 == null) {
                                break;
                            }
                            final int n13 = n12;
                            final int n14 = n2;
                            BytecodeManager.incBytecodes(3);
                            n12 = nextKeyIndex(n13, n14);
                            BytecodeManager.incBytecodes(2);
                        }
                        table2[n12] = o;
                        BytecodeManager.incBytecodes(4);
                        table2[n12 + 1] = o3;
                        BytecodeManager.incBytecodes(6);
                    }
                    n8 += 2;
                    BytecodeManager.incBytecodes(2);
                }
                this.table = table2;
                BytecodeManager.incBytecodes(3);
                final boolean b3 = true;
                BytecodeManager.incBytecodes(2);
                return b3;
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void putAll(final Map<? extends K, ? extends V> map) {
        try {
            BytecodeManager.incBytecodes(2);
            final int size = map.size();
            BytecodeManager.incBytecodes(1);
            final int n = size;
            BytecodeManager.incBytecodes(2);
            if (n == 0) {
                BytecodeManager.incBytecodes(1);
                return;
            }
            final int n2 = size;
            final int size2 = this.size;
            BytecodeManager.incBytecodes(4);
            if (n2 > size2) {
                final int n3 = size;
                BytecodeManager.incBytecodes(3);
                final int capacity = capacity(n3);
                BytecodeManager.incBytecodes(1);
                this.resize(capacity);
                BytecodeManager.incBytecodes(1);
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
                BytecodeManager.incBytecodes(3);
                final K key = (K)entry2.getKey();
                final Entry<? extends K, ? extends V> entry3 = entry;
                BytecodeManager.incBytecodes(2);
                final V value = (V)entry3.getValue();
                BytecodeManager.incBytecodes(1);
                this.put(key, value);
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
            BytecodeManager.incBytecodes(2);
            final Object maskNull = maskNull(o);
            BytecodeManager.incBytecodes(1);
            final Object[] table = this.table;
            BytecodeManager.incBytecodes(3);
            final int length = table.length;
            BytecodeManager.incBytecodes(3);
            final Object o2 = maskNull;
            final int n = length;
            BytecodeManager.incBytecodes(3);
            int n2 = hash(o2, n);
            BytecodeManager.incBytecodes(1);
            while (true) {
                final Object o3 = table[n2];
                BytecodeManager.incBytecodes(4);
                final Object o4 = o3;
                final Object o5 = maskNull;
                BytecodeManager.incBytecodes(3);
                if (o4 == o5) {
                    ++this.modCount;
                    BytecodeManager.incBytecodes(6);
                    --this.size;
                    BytecodeManager.incBytecodes(6);
                    final Object o6 = table[n2 + 1];
                    BytecodeManager.incBytecodes(6);
                    table[n2 + 1] = null;
                    BytecodeManager.incBytecodes(6);
                    table[n2] = null;
                    BytecodeManager.incBytecodes(4);
                    final int n3 = n2;
                    BytecodeManager.incBytecodes(3);
                    this.closeDeletion(n3);
                    final Object o7 = o6;
                    BytecodeManager.incBytecodes(2);
                    return (V)o7;
                }
                final Object o8 = o3;
                BytecodeManager.incBytecodes(2);
                if (o8 == null) {
                    final V v = null;
                    BytecodeManager.incBytecodes(2);
                    return v;
                }
                final int n4 = n2;
                final int n5 = length;
                BytecodeManager.incBytecodes(3);
                n2 = nextKeyIndex(n4, n5);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private boolean removeMapping(final Object o, final Object o2) {
        try {
            BytecodeManager.incBytecodes(2);
            final Object maskNull = maskNull(o);
            BytecodeManager.incBytecodes(1);
            final Object[] table = this.table;
            BytecodeManager.incBytecodes(3);
            final int length = table.length;
            BytecodeManager.incBytecodes(3);
            final Object o3 = maskNull;
            final int n = length;
            BytecodeManager.incBytecodes(3);
            int n2 = hash(o3, n);
            BytecodeManager.incBytecodes(1);
            while (true) {
                final Object o4 = table[n2];
                BytecodeManager.incBytecodes(4);
                final Object o5 = o4;
                final Object o6 = maskNull;
                BytecodeManager.incBytecodes(3);
                if (o5 == o6) {
                    final Object o7 = table[n2 + 1];
                    BytecodeManager.incBytecodes(7);
                    if (o7 != o2) {
                        final boolean b = false;
                        BytecodeManager.incBytecodes(2);
                        return b;
                    }
                    ++this.modCount;
                    BytecodeManager.incBytecodes(6);
                    --this.size;
                    BytecodeManager.incBytecodes(6);
                    table[n2] = null;
                    BytecodeManager.incBytecodes(4);
                    table[n2 + 1] = null;
                    BytecodeManager.incBytecodes(6);
                    final int n3 = n2;
                    BytecodeManager.incBytecodes(3);
                    this.closeDeletion(n3);
                    final boolean b2 = true;
                    BytecodeManager.incBytecodes(2);
                    return b2;
                }
                else {
                    final Object o8 = o4;
                    BytecodeManager.incBytecodes(2);
                    if (o8 == null) {
                        final boolean b3 = false;
                        BytecodeManager.incBytecodes(2);
                        return b3;
                    }
                    final int n4 = n2;
                    final int n5 = length;
                    BytecodeManager.incBytecodes(3);
                    n2 = nextKeyIndex(n4, n5);
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                }
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void closeDeletion(int n) {
        try {
            final Object[] table = this.table;
            BytecodeManager.incBytecodes(3);
            final int length = table.length;
            BytecodeManager.incBytecodes(3);
            final int n2 = n;
            final int n3 = length;
            BytecodeManager.incBytecodes(3);
            int n4 = nextKeyIndex(n2, n3);
            BytecodeManager.incBytecodes(1);
            while (true) {
                final Object o2;
                final Object o = o2 = table[n4];
                BytecodeManager.incBytecodes(6);
                if (o == null) {
                    break;
                }
                final Object o3 = o2;
                final int n5 = length;
                BytecodeManager.incBytecodes(3);
                final int hash = hash(o3, n5);
                BytecodeManager.incBytecodes(1);
                final int n6 = n4;
                final int n7 = hash;
                BytecodeManager.incBytecodes(3);
                Label_0180: {
                    Label_0124: {
                        if (n6 < n7) {
                            final int n8 = hash;
                            final int n9 = n;
                            BytecodeManager.incBytecodes(3);
                            if (n8 <= n9) {
                                break Label_0124;
                            }
                            final int n10 = n;
                            final int n11 = n4;
                            BytecodeManager.incBytecodes(3);
                            if (n10 <= n11) {
                                break Label_0124;
                            }
                        }
                        final int n12 = hash;
                        final int n13 = n;
                        BytecodeManager.incBytecodes(3);
                        if (n12 > n13) {
                            break Label_0180;
                        }
                        final int n14 = n;
                        final int n15 = n4;
                        BytecodeManager.incBytecodes(3);
                        if (n14 > n15) {
                            break Label_0180;
                        }
                    }
                    table[n] = o2;
                    BytecodeManager.incBytecodes(4);
                    table[n + 1] = table[n4 + 1];
                    BytecodeManager.incBytecodes(10);
                    table[n4] = null;
                    BytecodeManager.incBytecodes(4);
                    table[n4 + 1] = null;
                    BytecodeManager.incBytecodes(6);
                    n = n4;
                    BytecodeManager.incBytecodes(2);
                }
                final int n16 = n4;
                final int n17 = length;
                BytecodeManager.incBytecodes(3);
                n4 = nextKeyIndex(n16, n17);
                BytecodeManager.incBytecodes(2);
            }
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
            final Object[] table = this.table;
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
            this.size = 0;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean equals(final Object o) {
        try {
            BytecodeManager.incBytecodes(3);
            if (o == this) {
                final boolean b = true;
                BytecodeManager.incBytecodes(2);
                return b;
            }
            final boolean b2 = o instanceof IdentityHashMap;
            BytecodeManager.incBytecodes(3);
            if (b2) {
                final IdentityHashMap identityHashMap = (IdentityHashMap)o;
                BytecodeManager.incBytecodes(3);
                final IdentityHashMap identityHashMap2 = identityHashMap;
                BytecodeManager.incBytecodes(2);
                final int size = identityHashMap2.size();
                final int size2 = this.size;
                BytecodeManager.incBytecodes(3);
                if (size != size2) {
                    final boolean b3 = false;
                    BytecodeManager.incBytecodes(2);
                    return b3;
                }
                final Object[] table = identityHashMap.table;
                BytecodeManager.incBytecodes(3);
                int n = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n2 = n;
                    final int length = table.length;
                    BytecodeManager.incBytecodes(4);
                    if (n2 >= length) {
                        final boolean b4 = true;
                        BytecodeManager.incBytecodes(2);
                        return b4;
                    }
                    final Object o2 = table[n];
                    BytecodeManager.incBytecodes(4);
                    final Object o3 = o2;
                    BytecodeManager.incBytecodes(2);
                    if (o3 != null) {
                        final Object o4 = o2;
                        final Object o5 = table[n + 1];
                        BytecodeManager.incBytecodes(8);
                        final boolean containsMapping = this.containsMapping(o4, o5);
                        BytecodeManager.incBytecodes(1);
                        if (!containsMapping) {
                            final boolean b5 = false;
                            BytecodeManager.incBytecodes(2);
                            return b5;
                        }
                    }
                    n += 2;
                    BytecodeManager.incBytecodes(2);
                }
            }
            else {
                final boolean b6 = o instanceof Map;
                BytecodeManager.incBytecodes(3);
                if (b6) {
                    final Map map = (Map)o;
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(2);
                    final Set<Entry<K, V>> entrySet = this.entrySet();
                    final Map map2 = map;
                    BytecodeManager.incBytecodes(2);
                    final Set entrySet2 = map2.entrySet();
                    BytecodeManager.incBytecodes(1);
                    final boolean equals = entrySet.equals(entrySet2);
                    BytecodeManager.incBytecodes(1);
                    return equals;
                }
                final boolean b7 = false;
                BytecodeManager.incBytecodes(2);
                return b7;
            }
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
            final Object[] table = this.table;
            BytecodeManager.incBytecodes(3);
            int n2 = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n3 = n2;
                final int length = table.length;
                BytecodeManager.incBytecodes(4);
                if (n3 >= length) {
                    break;
                }
                final Object o = table[n2];
                BytecodeManager.incBytecodes(4);
                final Object o2 = o;
                BytecodeManager.incBytecodes(2);
                if (o2 != null) {
                    final Object o3 = o;
                    BytecodeManager.incBytecodes(2);
                    final Object unmaskNull = unmaskNull(o3);
                    BytecodeManager.incBytecodes(1);
                    final int n4 = n;
                    final Object o4 = unmaskNull;
                    BytecodeManager.incBytecodes(3);
                    final int identityHashCode = System.identityHashCode(o4);
                    final Object o5 = table[n2 + 1];
                    BytecodeManager.incBytecodes(5);
                    BytecodeManager.incBytecodes(1);
                    n = n4 + (identityHashCode ^ System.identityHashCode(o5));
                    BytecodeManager.incBytecodes(3);
                }
                n2 += 2;
                BytecodeManager.incBytecodes(2);
            }
            final int n5 = n;
            BytecodeManager.incBytecodes(2);
            return n5;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Object clone() {
        try {
            try {
                BytecodeManager.incBytecodes(2);
                final IdentityHashMap identityHashMap = (IdentityHashMap)super.clone();
                BytecodeManager.incBytecodes(2);
                identityHashMap.entrySet = null;
                BytecodeManager.incBytecodes(3);
                final IdentityHashMap identityHashMap2 = identityHashMap;
                final Object[] table = this.table;
                BytecodeManager.incBytecodes(4);
                identityHashMap2.table = table.clone();
                BytecodeManager.incBytecodes(2);
                final IdentityHashMap identityHashMap3 = identityHashMap;
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                return identityHashMap3;
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
    public Set<K> keySet() {
        try {
            final Set<K> keySet = this.keySet;
            BytecodeManager.incBytecodes(3);
            final Set<K> set = keySet;
            BytecodeManager.incBytecodes(2);
            if (set != null) {
                final Set<K> set2 = keySet;
                BytecodeManager.incBytecodes(2);
                return set2;
            }
            final Object object = null;
            BytecodeManager.incBytecodes(6);
            final KeySet keySet2 = new KeySet();
            this.keySet = keySet2;
            BytecodeManager.incBytecodes(3);
            return keySet2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public Collection<V> values() {
        try {
            final Collection<V> values = this.values;
            BytecodeManager.incBytecodes(3);
            final Collection<V> collection = values;
            BytecodeManager.incBytecodes(2);
            if (collection != null) {
                final Collection<V> collection2 = values;
                BytecodeManager.incBytecodes(2);
                return collection2;
            }
            final Object object = null;
            BytecodeManager.incBytecodes(6);
            final Values values2 = new Values();
            this.values = values2;
            BytecodeManager.incBytecodes(3);
            return values2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public Set<Entry<K, V>> entrySet() {
        try {
            final Set<Entry<K, V>> entrySet = this.entrySet;
            BytecodeManager.incBytecodes(3);
            final Set<Entry<K, V>> set = entrySet;
            BytecodeManager.incBytecodes(2);
            if (set != null) {
                final Set<Entry<K, V>> set2 = entrySet;
                BytecodeManager.incBytecodes(2);
                return set2;
            }
            final Object object = null;
            BytecodeManager.incBytecodes(6);
            final EntrySet entrySet2 = new EntrySet();
            this.entrySet = entrySet2;
            BytecodeManager.incBytecodes(3);
            return entrySet2;
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
            final Object[] table = this.table;
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
                final Object o = table[n];
                BytecodeManager.incBytecodes(4);
                final Object o2 = o;
                BytecodeManager.incBytecodes(2);
                if (o2 != null) {
                    final Object o3 = o;
                    BytecodeManager.incBytecodes(3);
                    final Object unmaskNull = unmaskNull(o3);
                    BytecodeManager.incBytecodes(1);
                    objectOutputStream.writeObject(unmaskNull);
                    final Object obj = table[n + 1];
                    BytecodeManager.incBytecodes(7);
                    objectOutputStream.writeObject(obj);
                }
                n += 2;
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
            final int int1 = objectInputStream.readInt();
            BytecodeManager.incBytecodes(1);
            final int n = int1;
            BytecodeManager.incBytecodes(2);
            if (n < 0) {
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
                final StreamCorruptedException ex = new StreamCorruptedException(string);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final int n2 = int1;
            BytecodeManager.incBytecodes(3);
            final int capacity = capacity(n2);
            BytecodeManager.incBytecodes(1);
            this.init(capacity);
            int n3 = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n4 = n3;
                final int n5 = int1;
                BytecodeManager.incBytecodes(3);
                if (n4 >= n5) {
                    break;
                }
                BytecodeManager.incBytecodes(2);
                final Object object = objectInputStream.readObject();
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(2);
                final Object object2 = objectInputStream.readObject();
                BytecodeManager.incBytecodes(1);
                final Object o = object;
                final Object o2 = object2;
                BytecodeManager.incBytecodes(4);
                this.putForCreate((K)o, (V)o2);
                ++n3;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void putForCreate(final K k, final V v) throws StreamCorruptedException {
        try {
            BytecodeManager.incBytecodes(2);
            final Object maskNull = maskNull(k);
            BytecodeManager.incBytecodes(1);
            final Object[] table = this.table;
            BytecodeManager.incBytecodes(3);
            final int length = table.length;
            BytecodeManager.incBytecodes(3);
            final Object o = maskNull;
            final int n = length;
            BytecodeManager.incBytecodes(3);
            int n2 = hash(o, n);
            BytecodeManager.incBytecodes(1);
            while (true) {
                final Object o2 = table[n2];
                BytecodeManager.incBytecodes(6);
                if (o2 == null) {
                    table[n2] = maskNull;
                    BytecodeManager.incBytecodes(4);
                    table[n2 + 1] = v;
                    BytecodeManager.incBytecodes(6);
                    BytecodeManager.incBytecodes(1);
                    return;
                }
                final Object o3 = o2;
                final Object o4 = maskNull;
                BytecodeManager.incBytecodes(3);
                if (o3 == o4) {
                    BytecodeManager.incBytecodes(3);
                    final StreamCorruptedException ex = new StreamCorruptedException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final int n3 = n2;
                final int n4 = length;
                BytecodeManager.incBytecodes(3);
                n2 = nextKeyIndex(n3, n4);
                BytecodeManager.incBytecodes(2);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void forEach(final BiConsumer<? super K, ? super V> biConsumer) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(biConsumer);
            BytecodeManager.incBytecodes(1);
            final int modCount = this.modCount;
            BytecodeManager.incBytecodes(3);
            final Object[] table = this.table;
            BytecodeManager.incBytecodes(3);
            int n = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n2 = n;
                final int length = table.length;
                BytecodeManager.incBytecodes(4);
                if (n2 >= length) {
                    BytecodeManager.incBytecodes(1);
                    return;
                }
                final Object o = table[n];
                BytecodeManager.incBytecodes(4);
                final Object o2 = o;
                BytecodeManager.incBytecodes(2);
                if (o2 != null) {
                    final Object o3 = o;
                    BytecodeManager.incBytecodes(3);
                    final Object unmaskNull = unmaskNull(o3);
                    final Object o4 = table[n + 1];
                    BytecodeManager.incBytecodes(6);
                    biConsumer.accept((Object)unmaskNull, (Object)o4);
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
                n += 2;
                BytecodeManager.incBytecodes(2);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void replaceAll(final BiFunction<? super K, ? super V, ? extends V> biFunction) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(biFunction);
            BytecodeManager.incBytecodes(1);
            final int modCount = this.modCount;
            BytecodeManager.incBytecodes(3);
            final Object[] table = this.table;
            BytecodeManager.incBytecodes(3);
            int n = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n2 = n;
                final int length = table.length;
                BytecodeManager.incBytecodes(4);
                if (n2 >= length) {
                    BytecodeManager.incBytecodes(1);
                    return;
                }
                final Object o = table[n];
                BytecodeManager.incBytecodes(4);
                final Object o2 = o;
                BytecodeManager.incBytecodes(2);
                if (o2 != null) {
                    final Object[] array = table;
                    final int n3 = n + 1;
                    final Object o3 = o;
                    BytecodeManager.incBytecodes(7);
                    final Object unmaskNull = unmaskNull(o3);
                    final Object o4 = table[n + 1];
                    BytecodeManager.incBytecodes(6);
                    array[n3] = biFunction.apply((Object)unmaskNull, (Object)o4);
                    BytecodeManager.incBytecodes(1);
                }
                final int modCount2 = this.modCount;
                final int n4 = modCount;
                BytecodeManager.incBytecodes(4);
                if (modCount2 != n4) {
                    BytecodeManager.incBytecodes(3);
                    final ConcurrentModificationException ex = new ConcurrentModificationException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                n += 2;
                BytecodeManager.incBytecodes(2);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static /* synthetic */ int access$000(final int n, final int n2) {
        try {
            BytecodeManager.incBytecodes(3);
            final int nextKeyIndex = nextKeyIndex(n, n2);
            BytecodeManager.incBytecodes(1);
            return nextKeyIndex;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static /* synthetic */ int access$100(final Object o, final int n) {
        try {
            BytecodeManager.incBytecodes(3);
            final int hash = hash(o, n);
            BytecodeManager.incBytecodes(1);
            return hash;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static /* synthetic */ boolean access$1100(final IdentityHashMap identityHashMap, final Object o, final Object o2) {
        try {
            BytecodeManager.incBytecodes(4);
            final boolean containsMapping = identityHashMap.containsMapping(o, o2);
            BytecodeManager.incBytecodes(1);
            return containsMapping;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static /* synthetic */ boolean access$1200(final IdentityHashMap identityHashMap, final Object o, final Object o2) {
        try {
            BytecodeManager.incBytecodes(4);
            final boolean removeMapping = identityHashMap.removeMapping(o, o2);
            BytecodeManager.incBytecodes(1);
            return removeMapping;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static {
        try {
            BytecodeManager.incBytecodes(3);
            NULL_KEY = new Object();
            BytecodeManager.incBytecodes(2);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private abstract class IdentityHashMapIterator<T> implements Iterator<T>
    {
        int index;
        int expectedModCount;
        int lastReturnedIndex;
        boolean indexValid;
        Object[] traversalTable;
        
        private IdentityHashMapIterator() {
            try {
                BytecodeManager.incBytecodes(5);
                final int size = IdentityHashMap.this.size;
                BytecodeManager.incBytecodes(5);
                int length;
                if (size != 0) {
                    length = 0;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    length = IdentityHashMap.this.table.length;
                    BytecodeManager.incBytecodes(4);
                }
                this.index = length;
                BytecodeManager.incBytecodes(1);
                this.expectedModCount = IdentityHashMap.this.modCount;
                BytecodeManager.incBytecodes(5);
                this.lastReturnedIndex = -1;
                BytecodeManager.incBytecodes(3);
                this.traversalTable = IdentityHashMap.this.table;
                BytecodeManager.incBytecodes(6);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean hasNext() {
            try {
                final Object[] traversalTable = this.traversalTable;
                BytecodeManager.incBytecodes(3);
                int index = this.index;
                BytecodeManager.incBytecodes(3);
                while (true) {
                    final int n = index;
                    final int length = traversalTable.length;
                    BytecodeManager.incBytecodes(4);
                    if (n >= length) {
                        this.index = traversalTable.length;
                        BytecodeManager.incBytecodes(4);
                        final boolean b = false;
                        BytecodeManager.incBytecodes(2);
                        return b;
                    }
                    final Object o = traversalTable[index];
                    BytecodeManager.incBytecodes(4);
                    final Object o2 = o;
                    BytecodeManager.incBytecodes(2);
                    if (o2 != null) {
                        this.index = index;
                        BytecodeManager.incBytecodes(3);
                        final boolean indexValid = true;
                        this.indexValid = indexValid;
                        BytecodeManager.incBytecodes(5);
                        return indexValid;
                    }
                    index += 2;
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        protected int nextIndex() {
            try {
                final int modCount = IdentityHashMap.this.modCount;
                final int expectedModCount = this.expectedModCount;
                BytecodeManager.incBytecodes(6);
                if (modCount != expectedModCount) {
                    BytecodeManager.incBytecodes(3);
                    final ConcurrentModificationException ex = new ConcurrentModificationException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final boolean indexValid = this.indexValid;
                BytecodeManager.incBytecodes(3);
                if (!indexValid) {
                    BytecodeManager.incBytecodes(2);
                    final boolean hasNext = this.hasNext();
                    BytecodeManager.incBytecodes(1);
                    if (!hasNext) {
                        BytecodeManager.incBytecodes(3);
                        final NoSuchElementException ex2 = new NoSuchElementException();
                        BytecodeManager.incBytecodes(1);
                        throw ex2;
                    }
                }
                this.indexValid = false;
                BytecodeManager.incBytecodes(3);
                this.lastReturnedIndex = this.index;
                BytecodeManager.incBytecodes(4);
                this.index += 2;
                BytecodeManager.incBytecodes(6);
                final int lastReturnedIndex = this.lastReturnedIndex;
                BytecodeManager.incBytecodes(3);
                return lastReturnedIndex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void remove() {
            try {
                final int lastReturnedIndex = this.lastReturnedIndex;
                final int n = -1;
                BytecodeManager.incBytecodes(4);
                if (lastReturnedIndex == n) {
                    BytecodeManager.incBytecodes(3);
                    final IllegalStateException ex = new IllegalStateException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final int modCount = IdentityHashMap.this.modCount;
                final int expectedModCount = this.expectedModCount;
                BytecodeManager.incBytecodes(6);
                if (modCount != expectedModCount) {
                    BytecodeManager.incBytecodes(3);
                    final ConcurrentModificationException ex2 = new ConcurrentModificationException();
                    BytecodeManager.incBytecodes(1);
                    throw ex2;
                }
                this.expectedModCount = ++IdentityHashMap.this.modCount;
                BytecodeManager.incBytecodes(10);
                final int lastReturnedIndex2 = this.lastReturnedIndex;
                BytecodeManager.incBytecodes(3);
                this.lastReturnedIndex = -1;
                BytecodeManager.incBytecodes(3);
                this.index = lastReturnedIndex2;
                BytecodeManager.incBytecodes(3);
                this.indexValid = false;
                BytecodeManager.incBytecodes(3);
                final Object[] traversalTable = this.traversalTable;
                BytecodeManager.incBytecodes(3);
                final int length = traversalTable.length;
                BytecodeManager.incBytecodes(3);
                int n2 = lastReturnedIndex2;
                BytecodeManager.incBytecodes(2);
                final Object o = traversalTable[n2];
                BytecodeManager.incBytecodes(4);
                traversalTable[n2] = null;
                BytecodeManager.incBytecodes(4);
                traversalTable[n2 + 1] = null;
                BytecodeManager.incBytecodes(6);
                final Object[] array = traversalTable;
                final Object[] table = IdentityHashMap.this.table;
                BytecodeManager.incBytecodes(5);
                if (array != table) {
                    final IdentityHashMap this$0 = IdentityHashMap.this;
                    final Object o2 = o;
                    BytecodeManager.incBytecodes(4);
                    this$0.remove(o2);
                    BytecodeManager.incBytecodes(1);
                    this.expectedModCount = IdentityHashMap.this.modCount;
                    BytecodeManager.incBytecodes(5);
                    BytecodeManager.incBytecodes(1);
                    return;
                }
                final IdentityHashMap this$2 = IdentityHashMap.this;
                --this$2.size;
                BytecodeManager.incBytecodes(7);
                final int n3 = n2;
                final int n4 = length;
                BytecodeManager.incBytecodes(3);
                int n5 = IdentityHashMap.access$000(n3, n4);
                BytecodeManager.incBytecodes(1);
                while (true) {
                    final Object o4;
                    final Object o3 = o4 = traversalTable[n5];
                    BytecodeManager.incBytecodes(6);
                    if (o3 == null) {
                        break;
                    }
                    final Object o5 = o4;
                    final int n6 = length;
                    BytecodeManager.incBytecodes(3);
                    final int access$100 = IdentityHashMap.access$100(o5, n6);
                    BytecodeManager.incBytecodes(1);
                    final int n7 = n5;
                    final int n8 = access$100;
                    BytecodeManager.incBytecodes(3);
                    Label_0535: {
                        Label_0377: {
                            if (n7 < n8) {
                                final int n9 = access$100;
                                final int n10 = n2;
                                BytecodeManager.incBytecodes(3);
                                if (n9 <= n10) {
                                    break Label_0377;
                                }
                                final int n11 = n2;
                                final int n12 = n5;
                                BytecodeManager.incBytecodes(3);
                                if (n11 <= n12) {
                                    break Label_0377;
                                }
                            }
                            final int n13 = access$100;
                            final int n14 = n2;
                            BytecodeManager.incBytecodes(3);
                            if (n13 > n14) {
                                break Label_0535;
                            }
                            final int n15 = n2;
                            final int n16 = n5;
                            BytecodeManager.incBytecodes(3);
                            if (n15 > n16) {
                                break Label_0535;
                            }
                        }
                        final int n17 = n5;
                        final int n18 = lastReturnedIndex2;
                        BytecodeManager.incBytecodes(3);
                        if (n17 < n18) {
                            final int n19 = n2;
                            final int n20 = lastReturnedIndex2;
                            BytecodeManager.incBytecodes(3);
                            if (n19 >= n20) {
                                final Object[] traversalTable2 = this.traversalTable;
                                final Object[] table2 = IdentityHashMap.this.table;
                                BytecodeManager.incBytecodes(6);
                                if (traversalTable2 == table2) {
                                    final int n21 = length - lastReturnedIndex2;
                                    BytecodeManager.incBytecodes(4);
                                    final Object[] traversalTable3 = new Object[n21];
                                    BytecodeManager.incBytecodes(2);
                                    final Object[] array2 = traversalTable;
                                    final int n22 = lastReturnedIndex2;
                                    final Object[] array3 = traversalTable3;
                                    final int n23 = 0;
                                    final int n24 = n21;
                                    BytecodeManager.incBytecodes(6);
                                    System.arraycopy(array2, n22, array3, n23, n24);
                                    this.traversalTable = traversalTable3;
                                    BytecodeManager.incBytecodes(3);
                                    this.index = 0;
                                    BytecodeManager.incBytecodes(3);
                                }
                            }
                        }
                        traversalTable[n2] = o4;
                        BytecodeManager.incBytecodes(4);
                        traversalTable[n2 + 1] = traversalTable[n5 + 1];
                        BytecodeManager.incBytecodes(10);
                        traversalTable[n5] = null;
                        BytecodeManager.incBytecodes(4);
                        traversalTable[n5 + 1] = null;
                        BytecodeManager.incBytecodes(6);
                        n2 = n5;
                        BytecodeManager.incBytecodes(2);
                    }
                    final int n25 = n5;
                    final int n26 = length;
                    BytecodeManager.incBytecodes(3);
                    n5 = IdentityHashMap.access$000(n25, n26);
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private class KeyIterator extends IdentityHashMapIterator<K>
    {
        private KeyIterator() {
            try {
                final Object object = null;
                BytecodeManager.incBytecodes(7);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public K next() {
            try {
                final Object[] traversalTable = this.traversalTable;
                BytecodeManager.incBytecodes(4);
                final Object o = traversalTable[this.nextIndex()];
                BytecodeManager.incBytecodes(2);
                final Object unmaskNull = IdentityHashMap.unmaskNull(o);
                BytecodeManager.incBytecodes(1);
                return (K)unmaskNull;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private class ValueIterator extends IdentityHashMapIterator<V>
    {
        private ValueIterator() {
            try {
                final Object object = null;
                BytecodeManager.incBytecodes(7);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public V next() {
            try {
                final Object[] traversalTable = this.traversalTable;
                BytecodeManager.incBytecodes(4);
                final Object o = traversalTable[this.nextIndex() + 1];
                BytecodeManager.incBytecodes(4);
                return (V)o;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private class EntryIterator extends IdentityHashMapIterator<Map.Entry<K, V>>
    {
        private Entry lastReturnedEntry;
        
        private EntryIterator() {
            try {
                final Object object = null;
                BytecodeManager.incBytecodes(7);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Map.Entry<K, V> next() {
            try {
                BytecodeManager.incBytecodes(6);
                final int nextIndex = this.nextIndex();
                final Object object = null;
                BytecodeManager.incBytecodes(2);
                this.lastReturnedEntry = new Entry(nextIndex);
                BytecodeManager.incBytecodes(1);
                final Entry lastReturnedEntry = this.lastReturnedEntry;
                BytecodeManager.incBytecodes(3);
                return lastReturnedEntry;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void remove() {
            try {
                final Entry entry = null;
                final Entry lastReturnedEntry = this.lastReturnedEntry;
                BytecodeManager.incBytecodes(5);
                int access$400;
                if (entry == lastReturnedEntry) {
                    access$400 = -1;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final Entry lastReturnedEntry2 = this.lastReturnedEntry;
                    BytecodeManager.incBytecodes(2);
                    BytecodeManager.incBytecodes(1);
                    access$400 = Entry.access$400(lastReturnedEntry2);
                }
                this.lastReturnedIndex = access$400;
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(2);
                super.remove();
                final Entry lastReturnedEntry3 = this.lastReturnedEntry;
                final int lastReturnedIndex = this.lastReturnedIndex;
                BytecodeManager.incBytecodes(5);
                Entry.access$402(lastReturnedEntry3, lastReturnedIndex);
                BytecodeManager.incBytecodes(1);
                this.lastReturnedEntry = null;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private class Entry implements Map.Entry<K, V>
        {
            private int index;
            
            private Entry(final int index) {
                try {
                    BytecodeManager.incBytecodes(5);
                    this.index = index;
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
                    BytecodeManager.incBytecodes(2);
                    this.checkIndexForEntryUse();
                    final Object o = EntryIterator.this.traversalTable[this.index];
                    BytecodeManager.incBytecodes(7);
                    final Object unmaskNull = IdentityHashMap.unmaskNull(o);
                    BytecodeManager.incBytecodes(1);
                    return (K)unmaskNull;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public V getValue() {
                try {
                    BytecodeManager.incBytecodes(2);
                    this.checkIndexForEntryUse();
                    final Object o = EntryIterator.this.traversalTable[this.index + 1];
                    BytecodeManager.incBytecodes(9);
                    return (V)o;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public V setValue(final V v) {
                try {
                    BytecodeManager.incBytecodes(2);
                    this.checkIndexForEntryUse();
                    final Object o = EntryIterator.this.traversalTable[this.index + 1];
                    BytecodeManager.incBytecodes(9);
                    EntryIterator.this.traversalTable[this.index + 1] = v;
                    BytecodeManager.incBytecodes(9);
                    final Object[] traversalTable = EntryIterator.this.traversalTable;
                    final Object[] table = IdentityHashMap.this.table;
                    BytecodeManager.incBytecodes(8);
                    if (traversalTable != table) {
                        final IdentityHashMap this$0 = IdentityHashMap.this;
                        final Object o2 = EntryIterator.this.traversalTable[this.index];
                        BytecodeManager.incBytecodes(11);
                        this$0.put(o2, v);
                        BytecodeManager.incBytecodes(1);
                    }
                    final Object o3 = o;
                    BytecodeManager.incBytecodes(2);
                    return (V)o3;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public boolean equals(final Object obj) {
                try {
                    final int index = this.index;
                    BytecodeManager.incBytecodes(3);
                    if (index < 0) {
                        BytecodeManager.incBytecodes(3);
                        final boolean equals = super.equals(obj);
                        BytecodeManager.incBytecodes(1);
                        return equals;
                    }
                    final boolean b = obj instanceof Map.Entry;
                    BytecodeManager.incBytecodes(3);
                    if (!b) {
                        final boolean b2 = false;
                        BytecodeManager.incBytecodes(2);
                        return b2;
                    }
                    final Map.Entry entry = (Map.Entry)obj;
                    BytecodeManager.incBytecodes(3);
                    final Map.Entry<Object, V> entry2 = (Map.Entry<Object, V>)entry;
                    BytecodeManager.incBytecodes(2);
                    final Object key = entry2.getKey();
                    final Object o = EntryIterator.this.traversalTable[this.index];
                    BytecodeManager.incBytecodes(7);
                    final Object unmaskNull = IdentityHashMap.unmaskNull(o);
                    BytecodeManager.incBytecodes(1);
                    boolean b3 = false;
                    Label_0149: {
                        if (key == unmaskNull) {
                            final Map.Entry<Object, Object> entry3 = (Map.Entry<Object, Object>)entry;
                            BytecodeManager.incBytecodes(1);
                            BytecodeManager.incBytecodes(1);
                            final Object value = entry3.getValue();
                            final Object o2 = EntryIterator.this.traversalTable[this.index + 1];
                            BytecodeManager.incBytecodes(9);
                            if (value == o2) {
                                b3 = true;
                                BytecodeManager.incBytecodes(2);
                                break Label_0149;
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
            public int hashCode() {
                try {
                    final int lastReturnedIndex = EntryIterator.this.lastReturnedIndex;
                    BytecodeManager.incBytecodes(4);
                    if (lastReturnedIndex < 0) {
                        BytecodeManager.incBytecodes(2);
                        final int hashCode = super.hashCode();
                        BytecodeManager.incBytecodes(1);
                        return hashCode;
                    }
                    final Object o = EntryIterator.this.traversalTable[this.index];
                    BytecodeManager.incBytecodes(7);
                    final Object unmaskNull = IdentityHashMap.unmaskNull(o);
                    BytecodeManager.incBytecodes(1);
                    final int identityHashCode = System.identityHashCode(unmaskNull);
                    final Object o2 = EntryIterator.this.traversalTable[this.index + 1];
                    BytecodeManager.incBytecodes(8);
                    BytecodeManager.incBytecodes(1);
                    final int n = identityHashCode ^ System.identityHashCode(o2);
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
                    final int index = this.index;
                    BytecodeManager.incBytecodes(3);
                    if (index < 0) {
                        BytecodeManager.incBytecodes(2);
                        final String string = super.toString();
                        BytecodeManager.incBytecodes(1);
                        return string;
                    }
                    BytecodeManager.incBytecodes(3);
                    final StringBuilder sb = new StringBuilder();
                    final Object o = EntryIterator.this.traversalTable[this.index];
                    BytecodeManager.incBytecodes(7);
                    final Object unmaskNull = IdentityHashMap.unmaskNull(o);
                    BytecodeManager.incBytecodes(1);
                    final StringBuilder append = sb.append(unmaskNull);
                    final String str = "=";
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append2 = append.append(str);
                    final Object obj = EntryIterator.this.traversalTable[this.index + 1];
                    BytecodeManager.incBytecodes(9);
                    final StringBuilder append3 = append2.append(obj);
                    BytecodeManager.incBytecodes(1);
                    final String string2 = append3.toString();
                    BytecodeManager.incBytecodes(1);
                    return string2;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            private void checkIndexForEntryUse() {
                try {
                    final int index = this.index;
                    BytecodeManager.incBytecodes(3);
                    if (index < 0) {
                        final String s = "Entry was removed";
                        BytecodeManager.incBytecodes(4);
                        final IllegalStateException ex = new IllegalStateException(s);
                        BytecodeManager.incBytecodes(1);
                        throw ex;
                    }
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            static /* synthetic */ int access$400(final Entry entry) {
                try {
                    final int index = entry.index;
                    BytecodeManager.incBytecodes(3);
                    return index;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            static /* synthetic */ int access$402(final Entry entry, final int index) {
                try {
                    entry.index = index;
                    BytecodeManager.incBytecodes(5);
                    return index;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
    }
    
    private class KeySet extends AbstractSet<K>
    {
        private KeySet() {
            try {
                BytecodeManager.incBytecodes(5);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Iterator<K> iterator() {
            try {
                final IdentityHashMap this$0 = IdentityHashMap.this;
                final Object object = null;
                BytecodeManager.incBytecodes(6);
                final KeyIterator keyIterator = new KeyIterator();
                BytecodeManager.incBytecodes(1);
                return keyIterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int size() {
            try {
                final int size = IdentityHashMap.this.size;
                BytecodeManager.incBytecodes(4);
                return size;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean contains(final Object o) {
            try {
                final IdentityHashMap this$0 = IdentityHashMap.this;
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
        public boolean remove(final Object o) {
            try {
                final int size = IdentityHashMap.this.size;
                BytecodeManager.incBytecodes(4);
                final IdentityHashMap this$0 = IdentityHashMap.this;
                BytecodeManager.incBytecodes(4);
                this$0.remove(o);
                BytecodeManager.incBytecodes(1);
                final int size2 = IdentityHashMap.this.size;
                final int n = size;
                BytecodeManager.incBytecodes(5);
                boolean b;
                if (size2 != n) {
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
        public boolean removeAll(final Collection<?> collection) {
            try {
                BytecodeManager.incBytecodes(2);
                Objects.requireNonNull(collection);
                BytecodeManager.incBytecodes(1);
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
        public void clear() {
            try {
                final IdentityHashMap this$0 = IdentityHashMap.this;
                BytecodeManager.incBytecodes(3);
                this$0.clear();
                BytecodeManager.incBytecodes(1);
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
                    n = n2 + System.identityHashCode(k);
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
        public Object[] toArray() {
            try {
                final Object[] array = new Object[0];
                BytecodeManager.incBytecodes(3);
                final Object[] array2 = this.toArray(array);
                BytecodeManager.incBytecodes(1);
                return array2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public <T> T[] toArray(T[] array) {
            try {
                final int modCount = IdentityHashMap.this.modCount;
                BytecodeManager.incBytecodes(4);
                BytecodeManager.incBytecodes(2);
                final int size = this.size();
                BytecodeManager.incBytecodes(1);
                final int length = array.length;
                final int n = size;
                BytecodeManager.incBytecodes(4);
                if (length < n) {
                    final T[] array2 = array;
                    BytecodeManager.incBytecodes(2);
                    final Class<? extends Object[]> class1 = array2.getClass();
                    BytecodeManager.incBytecodes(1);
                    final Class<?> componentType = class1.getComponentType();
                    final int length2 = size;
                    BytecodeManager.incBytecodes(2);
                    array = (T[])Array.newInstance(componentType, length2);
                    BytecodeManager.incBytecodes(3);
                }
                final Object[] table = IdentityHashMap.this.table;
                BytecodeManager.incBytecodes(4);
                int n2 = 0;
                BytecodeManager.incBytecodes(2);
                int n3 = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n4 = n3;
                    final int length3 = table.length;
                    BytecodeManager.incBytecodes(4);
                    if (n4 >= length3) {
                        final int n5 = n2;
                        final int n6 = size;
                        BytecodeManager.incBytecodes(3);
                        if (n5 >= n6) {
                            final int n7 = modCount;
                            final int modCount2 = IdentityHashMap.this.modCount;
                            BytecodeManager.incBytecodes(5);
                            if (n7 == modCount2) {
                                final int n8 = n2;
                                final int length4 = array.length;
                                BytecodeManager.incBytecodes(4);
                                if (n8 < length4) {
                                    array[n2] = null;
                                    BytecodeManager.incBytecodes(4);
                                }
                                final T[] array3 = array;
                                BytecodeManager.incBytecodes(2);
                                return array3;
                            }
                        }
                        BytecodeManager.incBytecodes(3);
                        final ConcurrentModificationException ex = new ConcurrentModificationException();
                        BytecodeManager.incBytecodes(1);
                        throw ex;
                    }
                    final Object o = table[n3];
                    BytecodeManager.incBytecodes(6);
                    if (o != null) {
                        final int n9 = n2;
                        final int n10 = size;
                        BytecodeManager.incBytecodes(3);
                        if (n9 >= n10) {
                            BytecodeManager.incBytecodes(3);
                            final ConcurrentModificationException ex2 = new ConcurrentModificationException();
                            BytecodeManager.incBytecodes(1);
                            throw ex2;
                        }
                        final T[] array4 = array;
                        final int n11 = n2++;
                        final Object o2 = o;
                        BytecodeManager.incBytecodes(5);
                        array4[n11] = (T)IdentityHashMap.unmaskNull(o2);
                        BytecodeManager.incBytecodes(1);
                    }
                    n3 += 2;
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Spliterator<K> spliterator() {
            try {
                final IdentityHashMap this$0 = IdentityHashMap.this;
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
    }
    
    private class Values extends AbstractCollection<V>
    {
        private Values() {
            try {
                BytecodeManager.incBytecodes(5);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Iterator<V> iterator() {
            try {
                final IdentityHashMap this$0 = IdentityHashMap.this;
                final Object object = null;
                BytecodeManager.incBytecodes(6);
                final ValueIterator valueIterator = new ValueIterator();
                BytecodeManager.incBytecodes(1);
                return valueIterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int size() {
            try {
                final int size = IdentityHashMap.this.size;
                BytecodeManager.incBytecodes(4);
                return size;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean contains(final Object o) {
            try {
                final IdentityHashMap this$0 = IdentityHashMap.this;
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
        public boolean remove(final Object o) {
            try {
                BytecodeManager.incBytecodes(2);
                final Iterator<V> iterator = this.iterator();
                BytecodeManager.incBytecodes(1);
                V next;
                do {
                    final Iterator<V> iterator2 = iterator;
                    BytecodeManager.incBytecodes(2);
                    final boolean hasNext = iterator2.hasNext();
                    BytecodeManager.incBytecodes(1);
                    if (!hasNext) {
                        final boolean b = false;
                        BytecodeManager.incBytecodes(2);
                        return b;
                    }
                    final Iterator<V> iterator3 = iterator;
                    BytecodeManager.incBytecodes(2);
                    next = iterator3.next();
                    BytecodeManager.incBytecodes(2);
                } while (next != o);
                final Iterator<V> iterator4 = iterator;
                BytecodeManager.incBytecodes(2);
                iterator4.remove();
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
                final IdentityHashMap this$0 = IdentityHashMap.this;
                BytecodeManager.incBytecodes(3);
                this$0.clear();
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Object[] toArray() {
            try {
                final Object[] array = new Object[0];
                BytecodeManager.incBytecodes(3);
                final Object[] array2 = this.toArray(array);
                BytecodeManager.incBytecodes(1);
                return array2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public <T> T[] toArray(T[] array) {
            try {
                final int modCount = IdentityHashMap.this.modCount;
                BytecodeManager.incBytecodes(4);
                BytecodeManager.incBytecodes(2);
                final int size = this.size();
                BytecodeManager.incBytecodes(1);
                final int length = array.length;
                final int n = size;
                BytecodeManager.incBytecodes(4);
                if (length < n) {
                    final T[] array2 = array;
                    BytecodeManager.incBytecodes(2);
                    final Class<? extends Object[]> class1 = array2.getClass();
                    BytecodeManager.incBytecodes(1);
                    final Class<?> componentType = class1.getComponentType();
                    final int length2 = size;
                    BytecodeManager.incBytecodes(2);
                    array = (T[])Array.newInstance(componentType, length2);
                    BytecodeManager.incBytecodes(3);
                }
                final Object[] table = IdentityHashMap.this.table;
                BytecodeManager.incBytecodes(4);
                int n2 = 0;
                BytecodeManager.incBytecodes(2);
                int n3 = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n4 = n3;
                    final int length3 = table.length;
                    BytecodeManager.incBytecodes(4);
                    if (n4 >= length3) {
                        final int n5 = n2;
                        final int n6 = size;
                        BytecodeManager.incBytecodes(3);
                        if (n5 >= n6) {
                            final int n7 = modCount;
                            final int modCount2 = IdentityHashMap.this.modCount;
                            BytecodeManager.incBytecodes(5);
                            if (n7 == modCount2) {
                                final int n8 = n2;
                                final int length4 = array.length;
                                BytecodeManager.incBytecodes(4);
                                if (n8 < length4) {
                                    array[n2] = null;
                                    BytecodeManager.incBytecodes(4);
                                }
                                final T[] array3 = array;
                                BytecodeManager.incBytecodes(2);
                                return array3;
                            }
                        }
                        BytecodeManager.incBytecodes(3);
                        final ConcurrentModificationException ex = new ConcurrentModificationException();
                        BytecodeManager.incBytecodes(1);
                        throw ex;
                    }
                    final Object o = table[n3];
                    BytecodeManager.incBytecodes(4);
                    if (o != null) {
                        final int n9 = n2;
                        final int n10 = size;
                        BytecodeManager.incBytecodes(3);
                        if (n9 >= n10) {
                            BytecodeManager.incBytecodes(3);
                            final ConcurrentModificationException ex2 = new ConcurrentModificationException();
                            BytecodeManager.incBytecodes(1);
                            throw ex2;
                        }
                        array[n2++] = (T)table[n3 + 1];
                        BytecodeManager.incBytecodes(9);
                    }
                    n3 += 2;
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Spliterator<V> spliterator() {
            try {
                final IdentityHashMap this$0 = IdentityHashMap.this;
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
    }
    
    private class EntrySet extends AbstractSet<Entry<K, V>>
    {
        private EntrySet() {
            try {
                BytecodeManager.incBytecodes(5);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Iterator<Entry<K, V>> iterator() {
            try {
                final IdentityHashMap this$0 = IdentityHashMap.this;
                final Object object = null;
                BytecodeManager.incBytecodes(6);
                final EntryIterator entryIterator = new EntryIterator();
                BytecodeManager.incBytecodes(1);
                return entryIterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean contains(final Object o) {
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
                final IdentityHashMap this$0 = IdentityHashMap.this;
                final Entry entry2 = entry;
                BytecodeManager.incBytecodes(4);
                final Object key = entry2.getKey();
                final Entry entry3 = entry;
                BytecodeManager.incBytecodes(2);
                final Object value = entry3.getValue();
                BytecodeManager.incBytecodes(1);
                final boolean access$1100 = IdentityHashMap.access$1100(this$0, key, value);
                BytecodeManager.incBytecodes(1);
                return access$1100;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean remove(final Object o) {
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
                final IdentityHashMap this$0 = IdentityHashMap.this;
                final Entry entry2 = entry;
                BytecodeManager.incBytecodes(4);
                final Object key = entry2.getKey();
                final Entry entry3 = entry;
                BytecodeManager.incBytecodes(2);
                final Object value = entry3.getValue();
                BytecodeManager.incBytecodes(1);
                final boolean access$1200 = IdentityHashMap.access$1200(this$0, key, value);
                BytecodeManager.incBytecodes(1);
                return access$1200;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int size() {
            try {
                final int size = IdentityHashMap.this.size;
                BytecodeManager.incBytecodes(4);
                return size;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void clear() {
            try {
                final IdentityHashMap this$0 = IdentityHashMap.this;
                BytecodeManager.incBytecodes(3);
                this$0.clear();
                BytecodeManager.incBytecodes(1);
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
                boolean b = false;
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(2);
                final Iterator<Entry<K, V>> iterator = this.iterator();
                BytecodeManager.incBytecodes(1);
                while (true) {
                    final Iterator<Entry<K, V>> iterator2 = iterator;
                    BytecodeManager.incBytecodes(2);
                    final boolean hasNext = iterator2.hasNext();
                    BytecodeManager.incBytecodes(1);
                    if (!hasNext) {
                        break;
                    }
                    final Iterator<Entry<K, V>> iterator3 = iterator;
                    BytecodeManager.incBytecodes(3);
                    final Entry<K, V> next = iterator3.next();
                    BytecodeManager.incBytecodes(1);
                    final boolean contains = collection.contains(next);
                    BytecodeManager.incBytecodes(1);
                    if (!contains) {
                        continue;
                    }
                    final Iterator<Entry<K, V>> iterator4 = iterator;
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
        public Object[] toArray() {
            try {
                final Object[] array = new Object[0];
                BytecodeManager.incBytecodes(3);
                final Object[] array2 = this.toArray(array);
                BytecodeManager.incBytecodes(1);
                return array2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public <T> T[] toArray(T[] array) {
            try {
                final int modCount = IdentityHashMap.this.modCount;
                BytecodeManager.incBytecodes(4);
                BytecodeManager.incBytecodes(2);
                final int size = this.size();
                BytecodeManager.incBytecodes(1);
                final int length = array.length;
                final int n = size;
                BytecodeManager.incBytecodes(4);
                if (length < n) {
                    final T[] array2 = array;
                    BytecodeManager.incBytecodes(2);
                    final Class<? extends Object[]> class1 = array2.getClass();
                    BytecodeManager.incBytecodes(1);
                    final Class<?> componentType = class1.getComponentType();
                    final int length2 = size;
                    BytecodeManager.incBytecodes(2);
                    array = (T[])Array.newInstance(componentType, length2);
                    BytecodeManager.incBytecodes(3);
                }
                final Object[] table = IdentityHashMap.this.table;
                BytecodeManager.incBytecodes(4);
                int n2 = 0;
                BytecodeManager.incBytecodes(2);
                int n3 = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n4 = n3;
                    final int length3 = table.length;
                    BytecodeManager.incBytecodes(4);
                    if (n4 >= length3) {
                        final int n5 = n2;
                        final int n6 = size;
                        BytecodeManager.incBytecodes(3);
                        if (n5 >= n6) {
                            final int n7 = modCount;
                            final int modCount2 = IdentityHashMap.this.modCount;
                            BytecodeManager.incBytecodes(5);
                            if (n7 == modCount2) {
                                final int n8 = n2;
                                final int length4 = array.length;
                                BytecodeManager.incBytecodes(4);
                                if (n8 < length4) {
                                    array[n2] = null;
                                    BytecodeManager.incBytecodes(4);
                                }
                                final T[] array3 = array;
                                BytecodeManager.incBytecodes(2);
                                return array3;
                            }
                        }
                        BytecodeManager.incBytecodes(3);
                        final ConcurrentModificationException ex = new ConcurrentModificationException();
                        BytecodeManager.incBytecodes(1);
                        throw ex;
                    }
                    final Object o = table[n3];
                    BytecodeManager.incBytecodes(6);
                    if (o != null) {
                        final int n9 = n2;
                        final int n10 = size;
                        BytecodeManager.incBytecodes(3);
                        if (n9 >= n10) {
                            BytecodeManager.incBytecodes(3);
                            final ConcurrentModificationException ex2 = new ConcurrentModificationException();
                            BytecodeManager.incBytecodes(1);
                            throw ex2;
                        }
                        final T[] array4 = array;
                        final int n11 = n2++;
                        final Object o2 = o;
                        BytecodeManager.incBytecodes(7);
                        final Object unmaskNull = IdentityHashMap.unmaskNull(o2);
                        final Object o3 = table[n3 + 1];
                        BytecodeManager.incBytecodes(6);
                        array4[n11] = (T)new SimpleEntry(unmaskNull, o3);
                        BytecodeManager.incBytecodes(1);
                    }
                    n3 += 2;
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Spliterator<Entry<K, V>> spliterator() {
            try {
                final IdentityHashMap this$0 = IdentityHashMap.this;
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
    }
    
    static class IdentityHashMapSpliterator<K, V>
    {
        final IdentityHashMap<K, V> map;
        int index;
        int fence;
        int est;
        int expectedModCount;
        
        IdentityHashMapSpliterator(final IdentityHashMap<K, V> map, final int index, final int fence, final int est, final int expectedModCount) {
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
                    this.est = this.map.size;
                    BytecodeManager.incBytecodes(5);
                    this.expectedModCount = this.map.modCount;
                    BytecodeManager.incBytecodes(5);
                    final int length = this.map.table.length;
                    this.fence = length;
                    fence = length;
                    BytecodeManager.incBytecodes(8);
                }
                final int n = fence;
                BytecodeManager.incBytecodes(2);
                return n;
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
    
    static final class KeySpliterator<K, V> extends IdentityHashMapSpliterator<K, V> implements Spliterator<K>
    {
        KeySpliterator(final IdentityHashMap<K, V> identityHashMap, final int n, final int n2, final int n3, final int n4) {
            try {
                BytecodeManager.incBytecodes(7);
                super(identityHashMap, n, n2, n3, n4);
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
                final int n = index + fence >>> 1 & 0xFFFFFFFE;
                BytecodeManager.incBytecodes(12);
                final int n2 = index;
                final int n3 = n;
                BytecodeManager.incBytecodes(3);
                KeySpliterator<K, V> keySpliterator;
                if (n2 >= n3) {
                    keySpliterator = null;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final IdentityHashMap<K, V> map;
                    final int n4;
                    final int index2;
                    final int est;
                    final int expectedModCount;
                    keySpliterator = new KeySpliterator<K, V>((IdentityHashMap<Object, Object>)map, n4, index2, est, expectedModCount);
                    map = this.map;
                    n4 = index;
                    index2 = n;
                    this.index = index2;
                    est = this.est >>> 1;
                    this.est = est;
                    expectedModCount = this.expectedModCount;
                    BytecodeManager.incBytecodes(19);
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
                final IdentityHashMap<K, V> map;
                final IdentityHashMap<K, V> identityHashMap = map = this.map;
                BytecodeManager.incBytecodes(5);
                if (identityHashMap != null) {
                    final Object[] table;
                    final Object[] array = table = map.table;
                    BytecodeManager.incBytecodes(5);
                    if (array != null) {
                        int index;
                        final int n = index = this.index;
                        BytecodeManager.incBytecodes(5);
                        if (n >= 0) {
                            BytecodeManager.incBytecodes(2);
                            BytecodeManager.incBytecodes(1);
                            final int fence;
                            final int index2 = fence = this.getFence();
                            this.index = index2;
                            final int length = table.length;
                            BytecodeManager.incBytecodes(7);
                            if (index2 <= length) {
                                while (true) {
                                    final int n2 = index;
                                    final int n3 = fence;
                                    BytecodeManager.incBytecodes(3);
                                    if (n2 >= n3) {
                                        break;
                                    }
                                    final Object o = table[index];
                                    BytecodeManager.incBytecodes(6);
                                    if (o != null) {
                                        final Object o2 = o;
                                        BytecodeManager.incBytecodes(3);
                                        final Object unmaskNull = IdentityHashMap.unmaskNull(o2);
                                        BytecodeManager.incBytecodes(1);
                                        consumer.accept((Object)unmaskNull);
                                    }
                                    index += 2;
                                    BytecodeManager.incBytecodes(2);
                                }
                                final int modCount = map.modCount;
                                final int expectedModCount = this.expectedModCount;
                                BytecodeManager.incBytecodes(5);
                                if (modCount == expectedModCount) {
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
        public boolean tryAdvance(final Consumer<? super K> consumer) {
            try {
                BytecodeManager.incBytecodes(2);
                if (consumer == null) {
                    BytecodeManager.incBytecodes(3);
                    final NullPointerException ex = new NullPointerException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final Object[] table = this.map.table;
                BytecodeManager.incBytecodes(4);
                BytecodeManager.incBytecodes(2);
                final int fence = this.getFence();
                BytecodeManager.incBytecodes(1);
                while (true) {
                    final int index = this.index;
                    final int n = fence;
                    BytecodeManager.incBytecodes(4);
                    if (index >= n) {
                        final boolean b = false;
                        BytecodeManager.incBytecodes(2);
                        return b;
                    }
                    final Object o = table[this.index];
                    BytecodeManager.incBytecodes(5);
                    this.index += 2;
                    BytecodeManager.incBytecodes(6);
                    final Object o2 = o;
                    BytecodeManager.incBytecodes(2);
                    if (o2 != null) {
                        final Object o3 = o;
                        BytecodeManager.incBytecodes(3);
                        final Object unmaskNull = IdentityHashMap.unmaskNull(o3);
                        BytecodeManager.incBytecodes(1);
                        consumer.accept((Object)unmaskNull);
                        final int modCount = this.map.modCount;
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
                    else {
                        BytecodeManager.incBytecodes(1);
                    }
                }
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
    
    static final class ValueSpliterator<K, V> extends IdentityHashMapSpliterator<K, V> implements Spliterator<V>
    {
        ValueSpliterator(final IdentityHashMap<K, V> identityHashMap, final int n, final int n2, final int n3, final int n4) {
            try {
                BytecodeManager.incBytecodes(7);
                super(identityHashMap, n, n2, n3, n4);
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
                final int n = index + fence >>> 1 & 0xFFFFFFFE;
                BytecodeManager.incBytecodes(12);
                final int n2 = index;
                final int n3 = n;
                BytecodeManager.incBytecodes(3);
                ValueSpliterator<K, V> valueSpliterator;
                if (n2 >= n3) {
                    valueSpliterator = null;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final IdentityHashMap<K, V> map;
                    final int n4;
                    final int index2;
                    final int est;
                    final int expectedModCount;
                    valueSpliterator = new ValueSpliterator<K, V>((IdentityHashMap<Object, Object>)map, n4, index2, est, expectedModCount);
                    map = this.map;
                    n4 = index;
                    index2 = n;
                    this.index = index2;
                    est = this.est >>> 1;
                    this.est = est;
                    expectedModCount = this.expectedModCount;
                    BytecodeManager.incBytecodes(19);
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
                final IdentityHashMap<K, V> map;
                final IdentityHashMap<K, V> identityHashMap = map = this.map;
                BytecodeManager.incBytecodes(5);
                if (identityHashMap != null) {
                    final Object[] table;
                    final Object[] array = table = map.table;
                    BytecodeManager.incBytecodes(5);
                    if (array != null) {
                        int index;
                        final int n = index = this.index;
                        BytecodeManager.incBytecodes(5);
                        if (n >= 0) {
                            BytecodeManager.incBytecodes(2);
                            BytecodeManager.incBytecodes(1);
                            final int fence;
                            final int index2 = fence = this.getFence();
                            this.index = index2;
                            final int length = table.length;
                            BytecodeManager.incBytecodes(7);
                            if (index2 <= length) {
                                while (true) {
                                    final int n2 = index;
                                    final int n3 = fence;
                                    BytecodeManager.incBytecodes(3);
                                    if (n2 >= n3) {
                                        break;
                                    }
                                    final Object o = table[index];
                                    BytecodeManager.incBytecodes(4);
                                    if (o != null) {
                                        final Object o2 = table[index + 1];
                                        BytecodeManager.incBytecodes(6);
                                        final Object o3 = o2;
                                        BytecodeManager.incBytecodes(3);
                                        consumer.accept((Object)o3);
                                    }
                                    index += 2;
                                    BytecodeManager.incBytecodes(2);
                                }
                                final int modCount = map.modCount;
                                final int expectedModCount = this.expectedModCount;
                                BytecodeManager.incBytecodes(5);
                                if (modCount == expectedModCount) {
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
        public boolean tryAdvance(final Consumer<? super V> consumer) {
            try {
                BytecodeManager.incBytecodes(2);
                if (consumer == null) {
                    BytecodeManager.incBytecodes(3);
                    final NullPointerException ex = new NullPointerException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final Object[] table = this.map.table;
                BytecodeManager.incBytecodes(4);
                BytecodeManager.incBytecodes(2);
                final int fence = this.getFence();
                BytecodeManager.incBytecodes(1);
                while (true) {
                    final int index = this.index;
                    final int n = fence;
                    BytecodeManager.incBytecodes(4);
                    if (index >= n) {
                        final boolean b = false;
                        BytecodeManager.incBytecodes(2);
                        return b;
                    }
                    final Object o = table[this.index];
                    BytecodeManager.incBytecodes(5);
                    final Object o2 = table[this.index + 1];
                    BytecodeManager.incBytecodes(7);
                    this.index += 2;
                    BytecodeManager.incBytecodes(6);
                    final Object o3 = o;
                    BytecodeManager.incBytecodes(2);
                    if (o3 != null) {
                        final Object o4 = o2;
                        BytecodeManager.incBytecodes(3);
                        consumer.accept((Object)o4);
                        final int modCount = this.map.modCount;
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
                    else {
                        BytecodeManager.incBytecodes(1);
                    }
                }
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
    
    static final class EntrySpliterator<K, V> extends IdentityHashMapSpliterator<K, V> implements Spliterator<Entry<K, V>>
    {
        EntrySpliterator(final IdentityHashMap<K, V> identityHashMap, final int n, final int n2, final int n3, final int n4) {
            try {
                BytecodeManager.incBytecodes(7);
                super(identityHashMap, n, n2, n3, n4);
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
                final int n = index + fence >>> 1 & 0xFFFFFFFE;
                BytecodeManager.incBytecodes(12);
                final int n2 = index;
                final int n3 = n;
                BytecodeManager.incBytecodes(3);
                EntrySpliterator<K, V> entrySpliterator;
                if (n2 >= n3) {
                    entrySpliterator = null;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final IdentityHashMap<K, V> map;
                    final int n4;
                    final int index2;
                    final int est;
                    final int expectedModCount;
                    entrySpliterator = new EntrySpliterator<K, V>((IdentityHashMap<Object, Object>)map, n4, index2, est, expectedModCount);
                    map = this.map;
                    n4 = index;
                    index2 = n;
                    this.index = index2;
                    est = this.est >>> 1;
                    this.est = est;
                    expectedModCount = this.expectedModCount;
                    BytecodeManager.incBytecodes(19);
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
                final IdentityHashMap<K, V> map;
                final IdentityHashMap<K, V> identityHashMap = map = this.map;
                BytecodeManager.incBytecodes(5);
                if (identityHashMap != null) {
                    final Object[] table;
                    final Object[] array = table = map.table;
                    BytecodeManager.incBytecodes(5);
                    if (array != null) {
                        int index;
                        final int n = index = this.index;
                        BytecodeManager.incBytecodes(5);
                        if (n >= 0) {
                            BytecodeManager.incBytecodes(2);
                            BytecodeManager.incBytecodes(1);
                            final int fence;
                            final int index2 = fence = this.getFence();
                            this.index = index2;
                            final int length = table.length;
                            BytecodeManager.incBytecodes(7);
                            if (index2 <= length) {
                                while (true) {
                                    final int n2 = index;
                                    final int n3 = fence;
                                    BytecodeManager.incBytecodes(3);
                                    if (n2 >= n3) {
                                        break;
                                    }
                                    final Object o = table[index];
                                    BytecodeManager.incBytecodes(4);
                                    final Object o2 = o;
                                    BytecodeManager.incBytecodes(2);
                                    if (o2 != null) {
                                        final Object o3 = o;
                                        BytecodeManager.incBytecodes(1);
                                        BytecodeManager.incBytecodes(1);
                                        final Object unmaskNull = IdentityHashMap.unmaskNull(o3);
                                        BytecodeManager.incBytecodes(1);
                                        final Object o4 = table[index + 1];
                                        BytecodeManager.incBytecodes(6);
                                        final Object o5 = unmaskNull;
                                        final Object o6 = o4;
                                        BytecodeManager.incBytecodes(6);
                                        final SimpleImmutableEntry simpleImmutableEntry = new SimpleImmutableEntry(o5, o6);
                                        BytecodeManager.incBytecodes(1);
                                        consumer.accept((Object)simpleImmutableEntry);
                                    }
                                    index += 2;
                                    BytecodeManager.incBytecodes(2);
                                }
                                final int modCount = map.modCount;
                                final int expectedModCount = this.expectedModCount;
                                BytecodeManager.incBytecodes(5);
                                if (modCount == expectedModCount) {
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
        public boolean tryAdvance(final Consumer<? super Entry<K, V>> consumer) {
            try {
                BytecodeManager.incBytecodes(2);
                if (consumer == null) {
                    BytecodeManager.incBytecodes(3);
                    final NullPointerException ex = new NullPointerException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final Object[] table = this.map.table;
                BytecodeManager.incBytecodes(4);
                BytecodeManager.incBytecodes(2);
                final int fence = this.getFence();
                BytecodeManager.incBytecodes(1);
                while (true) {
                    final int index = this.index;
                    final int n = fence;
                    BytecodeManager.incBytecodes(4);
                    if (index >= n) {
                        final boolean b = false;
                        BytecodeManager.incBytecodes(2);
                        return b;
                    }
                    final Object o = table[this.index];
                    BytecodeManager.incBytecodes(5);
                    final Object o2 = table[this.index + 1];
                    BytecodeManager.incBytecodes(7);
                    this.index += 2;
                    BytecodeManager.incBytecodes(6);
                    final Object o3 = o;
                    BytecodeManager.incBytecodes(2);
                    if (o3 != null) {
                        final Object o4 = o;
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                        final Object unmaskNull = IdentityHashMap.unmaskNull(o4);
                        BytecodeManager.incBytecodes(1);
                        final Object o5 = unmaskNull;
                        final Object o6 = o2;
                        BytecodeManager.incBytecodes(6);
                        final SimpleImmutableEntry simpleImmutableEntry = new SimpleImmutableEntry(o5, o6);
                        BytecodeManager.incBytecodes(1);
                        consumer.accept((Object)simpleImmutableEntry);
                        final int modCount = this.map.modCount;
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
                    else {
                        BytecodeManager.incBytecodes(1);
                    }
                }
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
}
