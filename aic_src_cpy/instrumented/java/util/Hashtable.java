// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import java.io.StreamCorruptedException;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import instrumented.java.util.function.Function;
import instrumented.java.util.function.BiFunction;
import instrumented.java.util.function.BiConsumer;
import java.util.Iterator;
import aic2021.engine.BytecodeManager;
import java.io.Serializable;

public class Hashtable<K, V> extends Dictionary<K, V> implements Map<K, V>, Cloneable, Serializable
{
    private transient Entry<?, ?>[] table;
    private transient int count;
    private int threshold;
    private float loadFactor;
    private transient int modCount;
    private static final long serialVersionUID = 1421746759512286392L;
    private static final int MAX_ARRAY_SIZE = 2147483639;
    private transient volatile Set<K> keySet;
    private transient volatile Set<Map.Entry<K, V>> entrySet;
    private transient volatile Collection<V> values;
    private static final int KEYS = 0;
    private static final int VALUES = 1;
    private static final int ENTRIES = 2;
    
    public Hashtable(int n, final float f) {
        try {
            BytecodeManager.incBytecodes(2);
            this.modCount = 0;
            BytecodeManager.incBytecodes(3);
            final int n2 = n;
            BytecodeManager.incBytecodes(2);
            if (n2 < 0) {
                BytecodeManager.incBytecodes(5);
                final StringBuilder sb = new StringBuilder();
                final String str = "Illegal Capacity: ";
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
            final float n3 = fcmpg(f, 0.0f);
            BytecodeManager.incBytecodes(4);
            if (n3 > 0) {
                BytecodeManager.incBytecodes(2);
                final boolean naN = Float.isNaN(f);
                BytecodeManager.incBytecodes(1);
                if (!naN) {
                    final boolean b = n != 0;
                    BytecodeManager.incBytecodes(2);
                    if (!b) {
                        n = 1;
                        BytecodeManager.incBytecodes(2);
                    }
                    this.loadFactor = f;
                    BytecodeManager.incBytecodes(3);
                    this.table = (Entry<?, ?>[])new Entry[n];
                    BytecodeManager.incBytecodes(3);
                    final float a = n * f;
                    final float b2 = 2.14748365E9f;
                    BytecodeManager.incBytecodes(7);
                    this.threshold = (int)Math.min(a, b2);
                    BytecodeManager.incBytecodes(2);
                    BytecodeManager.incBytecodes(1);
                    return;
                }
            }
            BytecodeManager.incBytecodes(5);
            final StringBuilder sb2 = new StringBuilder();
            final String str2 = "Illegal Load: ";
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
    
    public Hashtable(final int n) {
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
    
    public Hashtable() {
        try {
            final int n = 11;
            final float n2 = 0.75f;
            BytecodeManager.incBytecodes(4);
            this(n, n2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Hashtable(final Map<? extends K, ? extends V> map) {
        try {
            final int n = 2;
            BytecodeManager.incBytecodes(4);
            final int a = n * map.size();
            final int b = 11;
            BytecodeManager.incBytecodes(3);
            final int max = Math.max(a, b);
            final float n2 = 0.75f;
            BytecodeManager.incBytecodes(2);
            this(max, n2);
            BytecodeManager.incBytecodes(3);
            this.putAll(map);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public synchronized int size() {
        try {
            final int count = this.count;
            BytecodeManager.incBytecodes(3);
            return count;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public synchronized boolean isEmpty() {
        try {
            final int count = this.count;
            BytecodeManager.incBytecodes(3);
            boolean b;
            if (count == 0) {
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
    public synchronized Enumeration<K> keys() {
        try {
            final int n = 0;
            BytecodeManager.incBytecodes(3);
            final Enumeration<Object> enumeration = this.getEnumeration(n);
            BytecodeManager.incBytecodes(1);
            return (Enumeration<K>)enumeration;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public synchronized Enumeration<V> elements() {
        try {
            final int n = 1;
            BytecodeManager.incBytecodes(3);
            final Enumeration<Object> enumeration = this.getEnumeration(n);
            BytecodeManager.incBytecodes(1);
            return (Enumeration<V>)enumeration;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public synchronized boolean contains(final Object obj) {
        try {
            BytecodeManager.incBytecodes(2);
            if (obj == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final Entry<?, ?>[] table = this.table;
            BytecodeManager.incBytecodes(3);
            int length = table.length;
            BytecodeManager.incBytecodes(3);
            while (true) {
                final int n = length--;
                BytecodeManager.incBytecodes(3);
                if (n <= 0) {
                    final boolean b = false;
                    BytecodeManager.incBytecodes(2);
                    return b;
                }
                Entry<?, ?> next = table[length];
                BytecodeManager.incBytecodes(4);
                while (true) {
                    final Entry<?, ?> entry = next;
                    BytecodeManager.incBytecodes(2);
                    if (entry == null) {
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    final Object value = next.value;
                    BytecodeManager.incBytecodes(4);
                    final boolean equals = value.equals(obj);
                    BytecodeManager.incBytecodes(1);
                    if (equals) {
                        final boolean b2 = true;
                        BytecodeManager.incBytecodes(2);
                        return b2;
                    }
                    next = next.next;
                    BytecodeManager.incBytecodes(4);
                }
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean containsValue(final Object o) {
        try {
            BytecodeManager.incBytecodes(3);
            final boolean contains = this.contains(o);
            BytecodeManager.incBytecodes(1);
            return contains;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public synchronized boolean containsKey(final Object obj) {
        try {
            final Entry<?, ?>[] table = this.table;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(2);
            final int hashCode = obj.hashCode();
            BytecodeManager.incBytecodes(1);
            final int n = (hashCode & Integer.MAX_VALUE) % table.length;
            BytecodeManager.incBytecodes(7);
            Entry<?, ?> next = table[n];
            BytecodeManager.incBytecodes(4);
            while (true) {
                final Entry<?, ?> entry = next;
                BytecodeManager.incBytecodes(2);
                if (entry == null) {
                    final boolean b = false;
                    BytecodeManager.incBytecodes(2);
                    return b;
                }
                final int hash = next.hash;
                final int n2 = hashCode;
                BytecodeManager.incBytecodes(4);
                if (hash == n2) {
                    final Object key = next.key;
                    BytecodeManager.incBytecodes(4);
                    final boolean equals = key.equals(obj);
                    BytecodeManager.incBytecodes(1);
                    if (equals) {
                        final boolean b2 = true;
                        BytecodeManager.incBytecodes(2);
                        return b2;
                    }
                }
                next = next.next;
                BytecodeManager.incBytecodes(4);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public synchronized V get(final Object obj) {
        try {
            final Entry<?, ?>[] table = this.table;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(2);
            final int hashCode = obj.hashCode();
            BytecodeManager.incBytecodes(1);
            final int n = (hashCode & Integer.MAX_VALUE) % table.length;
            BytecodeManager.incBytecodes(7);
            Entry<?, ?> next = table[n];
            BytecodeManager.incBytecodes(4);
            while (true) {
                final Entry<?, ?> entry = next;
                BytecodeManager.incBytecodes(2);
                if (entry == null) {
                    final V v = null;
                    BytecodeManager.incBytecodes(2);
                    return v;
                }
                final int hash = next.hash;
                final int n2 = hashCode;
                BytecodeManager.incBytecodes(4);
                if (hash == n2) {
                    final Object key = next.key;
                    BytecodeManager.incBytecodes(4);
                    final boolean equals = key.equals(obj);
                    BytecodeManager.incBytecodes(1);
                    if (equals) {
                        final Object value = next.value;
                        BytecodeManager.incBytecodes(3);
                        return (V)value;
                    }
                }
                next = next.next;
                BytecodeManager.incBytecodes(4);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    protected void rehash() {
        try {
            final int length = this.table.length;
            BytecodeManager.incBytecodes(4);
            final Entry<?, ?>[] table = this.table;
            BytecodeManager.incBytecodes(3);
            int n = (length << 1) + 1;
            BytecodeManager.incBytecodes(6);
            final int n2 = n - 2147483639;
            BytecodeManager.incBytecodes(4);
            if (n2 > 0) {
                final int n3 = length;
                final int n4 = 2147483639;
                BytecodeManager.incBytecodes(3);
                if (n3 == n4) {
                    BytecodeManager.incBytecodes(1);
                    return;
                }
                n = 2147483639;
                BytecodeManager.incBytecodes(2);
            }
            final Entry[] table2 = new Entry[n];
            BytecodeManager.incBytecodes(2);
            ++this.modCount;
            BytecodeManager.incBytecodes(6);
            final float a = n * this.loadFactor;
            final float b = 2.14748365E9f;
            BytecodeManager.incBytecodes(8);
            this.threshold = (int)Math.min(a, b);
            BytecodeManager.incBytecodes(2);
            this.table = (Entry<?, ?>[])table2;
            BytecodeManager.incBytecodes(3);
            int n5 = length;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n6 = n5--;
                BytecodeManager.incBytecodes(3);
                if (n6 <= 0) {
                    break;
                }
                Entry<?, ?> next = table[n5];
                BytecodeManager.incBytecodes(4);
                while (true) {
                    final Entry<?, ?> entry = next;
                    BytecodeManager.incBytecodes(2);
                    if (entry == null) {
                        break;
                    }
                    final Entry<?, ?> entry2 = next;
                    BytecodeManager.incBytecodes(2);
                    next = next.next;
                    BytecodeManager.incBytecodes(3);
                    final int n7 = (entry2.hash & Integer.MAX_VALUE) % n;
                    BytecodeManager.incBytecodes(7);
                    entry2.next = (Entry<?, ?>)table2[n7];
                    BytecodeManager.incBytecodes(5);
                    table2[n7] = entry2;
                    BytecodeManager.incBytecodes(4);
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void addEntry(int hashCode, final K k, final V v, int n) {
        try {
            ++this.modCount;
            BytecodeManager.incBytecodes(6);
            Entry<?, ?>[] array = this.table;
            BytecodeManager.incBytecodes(3);
            final int count = this.count;
            final int threshold = this.threshold;
            BytecodeManager.incBytecodes(5);
            if (count >= threshold) {
                BytecodeManager.incBytecodes(2);
                this.rehash();
                array = this.table;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(2);
                hashCode = k.hashCode();
                BytecodeManager.incBytecodes(1);
                n = (hashCode & Integer.MAX_VALUE) % array.length;
                BytecodeManager.incBytecodes(7);
            }
            final Entry<?, ?> entry = array[n];
            BytecodeManager.incBytecodes(4);
            final Entry<?, ?>[] array2 = array;
            final int n2 = n;
            final int n3 = hashCode;
            final Entry<Object, Object> entry2 = (Entry<Object, Object>)entry;
            BytecodeManager.incBytecodes(9);
            array2[n2] = new Entry<Object, Object>(n3, k, v, entry2);
            BytecodeManager.incBytecodes(1);
            ++this.count;
            BytecodeManager.incBytecodes(6);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public synchronized V put(final K obj, final V value) {
        try {
            BytecodeManager.incBytecodes(2);
            if (value == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final Entry<?, ?>[] table = this.table;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(2);
            final int hashCode = obj.hashCode();
            BytecodeManager.incBytecodes(1);
            final int n = (hashCode & Integer.MAX_VALUE) % table.length;
            BytecodeManager.incBytecodes(7);
            Entry<?, ?> next = table[n];
            BytecodeManager.incBytecodes(4);
            while (true) {
                final Entry<?, ?> entry = next;
                BytecodeManager.incBytecodes(2);
                if (entry == null) {
                    final int n2 = hashCode;
                    final int n3 = n;
                    BytecodeManager.incBytecodes(6);
                    this.addEntry(n2, obj, value, n3);
                    final V v = null;
                    BytecodeManager.incBytecodes(2);
                    return v;
                }
                final int hash = next.hash;
                final int n4 = hashCode;
                BytecodeManager.incBytecodes(4);
                if (hash == n4) {
                    final Object key = next.key;
                    BytecodeManager.incBytecodes(4);
                    final boolean equals = key.equals(obj);
                    BytecodeManager.incBytecodes(1);
                    if (equals) {
                        final Object value2 = next.value;
                        BytecodeManager.incBytecodes(3);
                        next.value = value;
                        BytecodeManager.incBytecodes(3);
                        final Object o = value2;
                        BytecodeManager.incBytecodes(2);
                        return (V)o;
                    }
                }
                next = next.next;
                BytecodeManager.incBytecodes(4);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public synchronized V remove(final Object obj) {
        try {
            final Entry<?, ?>[] table = this.table;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(2);
            final int hashCode = obj.hashCode();
            BytecodeManager.incBytecodes(1);
            final int n = (hashCode & Integer.MAX_VALUE) % table.length;
            BytecodeManager.incBytecodes(7);
            Entry<?, ?> next = table[n];
            BytecodeManager.incBytecodes(4);
            Entry<?, ?> entry = null;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final Entry<?, ?> entry2 = next;
                BytecodeManager.incBytecodes(2);
                if (entry2 == null) {
                    final V v = null;
                    BytecodeManager.incBytecodes(2);
                    return v;
                }
                final int hash = next.hash;
                final int n2 = hashCode;
                BytecodeManager.incBytecodes(4);
                if (hash == n2) {
                    final Object key = next.key;
                    BytecodeManager.incBytecodes(4);
                    final boolean equals = key.equals(obj);
                    BytecodeManager.incBytecodes(1);
                    if (equals) {
                        ++this.modCount;
                        BytecodeManager.incBytecodes(6);
                        final Entry<?, ?> entry3 = entry;
                        BytecodeManager.incBytecodes(2);
                        if (entry3 != null) {
                            entry.next = next.next;
                            BytecodeManager.incBytecodes(5);
                        }
                        else {
                            table[n] = next.next;
                            BytecodeManager.incBytecodes(5);
                        }
                        --this.count;
                        BytecodeManager.incBytecodes(6);
                        final Object value = next.value;
                        BytecodeManager.incBytecodes(3);
                        next.value = null;
                        BytecodeManager.incBytecodes(3);
                        final Object o = value;
                        BytecodeManager.incBytecodes(2);
                        return (V)o;
                    }
                }
                entry = next;
                next = next.next;
                BytecodeManager.incBytecodes(6);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public synchronized void putAll(final Map<? extends K, ? extends V> map) {
        try {
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
    public synchronized void clear() {
        try {
            final Entry<?, ?>[] table = this.table;
            BytecodeManager.incBytecodes(3);
            ++this.modCount;
            BytecodeManager.incBytecodes(6);
            int length = table.length;
            BytecodeManager.incBytecodes(3);
            while (true) {
                final int n = --length;
                BytecodeManager.incBytecodes(3);
                if (n < 0) {
                    break;
                }
                table[length] = null;
                BytecodeManager.incBytecodes(5);
            }
            this.count = 0;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public synchronized Object clone() {
        try {
            try {
                BytecodeManager.incBytecodes(2);
                final Hashtable hashtable = (Hashtable)super.clone();
                BytecodeManager.incBytecodes(2);
                hashtable.table = (Entry<?, ?>[])new Entry[this.table.length];
                BytecodeManager.incBytecodes(5);
                int length = this.table.length;
                BytecodeManager.incBytecodes(4);
                while (true) {
                    final int n = length--;
                    BytecodeManager.incBytecodes(3);
                    if (n <= 0) {
                        break;
                    }
                    final Entry<?, ?>[] table = hashtable.table;
                    final int n2 = length;
                    final Entry<?, ?> entry = this.table[length];
                    BytecodeManager.incBytecodes(8);
                    Entry<?, ?> entry3;
                    if (entry != null) {
                        final Entry<?, ?> entry2 = this.table[length];
                        BytecodeManager.incBytecodes(4);
                        BytecodeManager.incBytecodes(1);
                        entry3 = (Entry<?, ?>)entry2.clone();
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        entry3 = null;
                        BytecodeManager.incBytecodes(1);
                    }
                    table[n2] = entry3;
                    BytecodeManager.incBytecodes(2);
                }
                hashtable.keySet = null;
                BytecodeManager.incBytecodes(3);
                hashtable.entrySet = null;
                BytecodeManager.incBytecodes(3);
                hashtable.values = null;
                BytecodeManager.incBytecodes(3);
                hashtable.modCount = 0;
                BytecodeManager.incBytecodes(3);
                final Hashtable hashtable2 = hashtable;
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                return hashtable2;
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
    public synchronized String toString() {
        try {
            BytecodeManager.incBytecodes(2);
            final int n = this.size() - 1;
            BytecodeManager.incBytecodes(3);
            final int n2 = n;
            final int n3 = -1;
            BytecodeManager.incBytecodes(3);
            if (n2 == n3) {
                final String s = "{}";
                BytecodeManager.incBytecodes(2);
                return s;
            }
            BytecodeManager.incBytecodes(3);
            final StringBuilder sb = new StringBuilder();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            final Set<Map.Entry<K, V>> entrySet = this.entrySet();
            BytecodeManager.incBytecodes(1);
            final Iterator<Map.Entry<K, V>> iterator = entrySet.iterator();
            BytecodeManager.incBytecodes(1);
            final StringBuilder sb2 = sb;
            final char c = '{';
            BytecodeManager.incBytecodes(3);
            sb2.append(c);
            BytecodeManager.incBytecodes(1);
            int n4 = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final Iterator<Map.Entry<K, V>> iterator2 = iterator;
                BytecodeManager.incBytecodes(2);
                final Map.Entry<K, V> entry = iterator2.next();
                BytecodeManager.incBytecodes(2);
                final Map.Entry<K, V> entry2 = entry;
                BytecodeManager.incBytecodes(2);
                final K key = entry2.getKey();
                BytecodeManager.incBytecodes(1);
                final Map.Entry<K, V> entry3 = entry;
                BytecodeManager.incBytecodes(2);
                final V value = entry3.getValue();
                BytecodeManager.incBytecodes(1);
                final StringBuilder sb3 = sb;
                final K k = key;
                BytecodeManager.incBytecodes(4);
                String string;
                if (k == this) {
                    string = "(this Map)";
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final K i = key;
                    BytecodeManager.incBytecodes(2);
                    string = i.toString();
                }
                BytecodeManager.incBytecodes(1);
                sb3.append(string);
                BytecodeManager.incBytecodes(1);
                final StringBuilder sb4 = sb;
                final char c2 = '=';
                BytecodeManager.incBytecodes(3);
                sb4.append(c2);
                BytecodeManager.incBytecodes(1);
                final StringBuilder sb5 = sb;
                final V v = value;
                BytecodeManager.incBytecodes(4);
                String string2;
                if (v == this) {
                    string2 = "(this Map)";
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final V v2 = value;
                    BytecodeManager.incBytecodes(2);
                    string2 = v2.toString();
                }
                BytecodeManager.incBytecodes(1);
                sb5.append(string2);
                BytecodeManager.incBytecodes(1);
                final int n5 = n4;
                final int n6 = n;
                BytecodeManager.incBytecodes(3);
                if (n5 == n6) {
                    break;
                }
                final StringBuilder sb6 = sb;
                final String str = ", ";
                BytecodeManager.incBytecodes(3);
                sb6.append(str);
                BytecodeManager.incBytecodes(1);
                ++n4;
                BytecodeManager.incBytecodes(2);
            }
            final StringBuilder sb7 = sb;
            final char c3 = '}';
            BytecodeManager.incBytecodes(3);
            final StringBuilder append = sb7.append(c3);
            BytecodeManager.incBytecodes(1);
            final String string3 = append.toString();
            BytecodeManager.incBytecodes(1);
            return string3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private <T> Enumeration<T> getEnumeration(final int n) {
        try {
            final int count = this.count;
            BytecodeManager.incBytecodes(3);
            if (count == 0) {
                BytecodeManager.incBytecodes(1);
                final Enumeration<T> emptyEnumeration = Collections.emptyEnumeration();
                BytecodeManager.incBytecodes(1);
                return emptyEnumeration;
            }
            final boolean b = false;
            BytecodeManager.incBytecodes(6);
            final Enumerator enumerator = new Enumerator<T>(n, b);
            BytecodeManager.incBytecodes(1);
            return (Enumeration<T>)enumerator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private <T> Iterator<T> getIterator(final int n) {
        try {
            final int count = this.count;
            BytecodeManager.incBytecodes(3);
            if (count == 0) {
                BytecodeManager.incBytecodes(1);
                final Iterator<T> emptyIterator = Collections.emptyIterator();
                BytecodeManager.incBytecodes(1);
                return emptyIterator;
            }
            final boolean b = true;
            BytecodeManager.incBytecodes(6);
            final Enumerator enumerator = new Enumerator<T>(n, b);
            BytecodeManager.incBytecodes(1);
            return (Iterator<T>)enumerator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public Set<K> keySet() {
        try {
            final Set<K> keySet = this.keySet;
            BytecodeManager.incBytecodes(3);
            if (keySet == null) {
                final Object object = null;
                BytecodeManager.incBytecodes(6);
                final KeySet set = new KeySet();
                BytecodeManager.incBytecodes(2);
                this.keySet = Collections.synchronizedSet((Set<K>)set, this);
                BytecodeManager.incBytecodes(1);
            }
            final Set<K> keySet2 = this.keySet;
            BytecodeManager.incBytecodes(3);
            return keySet2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        try {
            final Set<Map.Entry<K, V>> entrySet = this.entrySet;
            BytecodeManager.incBytecodes(3);
            if (entrySet == null) {
                final Object object = null;
                BytecodeManager.incBytecodes(6);
                final EntrySet set = new EntrySet();
                BytecodeManager.incBytecodes(2);
                this.entrySet = Collections.synchronizedSet((Set<Map.Entry<K, V>>)set, this);
                BytecodeManager.incBytecodes(1);
            }
            final Set<Map.Entry<K, V>> entrySet2 = this.entrySet;
            BytecodeManager.incBytecodes(3);
            return entrySet2;
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
            if (values == null) {
                final Object object = null;
                BytecodeManager.incBytecodes(6);
                final ValueCollection collection = new ValueCollection();
                BytecodeManager.incBytecodes(2);
                this.values = Collections.synchronizedCollection((Collection<V>)collection, this);
                BytecodeManager.incBytecodes(1);
            }
            final Collection<V> values2 = this.values;
            BytecodeManager.incBytecodes(3);
            return values2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public synchronized boolean equals(final Object p0) {
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
        //    46: aload_2        
        //    47: ldc             2
        //    49: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    52: invokeinterface instrumented/java/util/Map.size:()I
        //    57: aload_0        
        //    58: ldc             2
        //    60: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    63: invokevirtual   instrumented/java/util/Hashtable.size:()I
        //    66: ldc             1
        //    68: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    71: if_icmpeq       81
        //    74: iconst_0       
        //    75: ldc             2
        //    77: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    80: ireturn        
        //    81: aload_0        
        //    82: ldc             2
        //    84: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    87: invokevirtual   instrumented/java/util/Hashtable.entrySet:()Linstrumented/java/util/Set;
        //    90: ldc             1
        //    92: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    95: invokeinterface instrumented/java/util/Set.iterator:()Ljava/util/Iterator;
        //   100: astore_3       
        //   101: ldc             1
        //   103: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   106: aload_3        
        //   107: ldc             2
        //   109: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   112: invokeinterface java/util/Iterator.hasNext:()Z
        //   117: ldc             1
        //   119: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   122: ifeq            299
        //   125: aload_3        
        //   126: ldc             2
        //   128: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   131: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   136: checkcast       Linstrumented/java/util/Map$Entry;
        //   139: astore          4
        //   141: ldc             2
        //   143: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   146: aload           4
        //   148: ldc             2
        //   150: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   153: invokeinterface instrumented/java/util/Map$Entry.getKey:()Ljava/lang/Object;
        //   158: astore          5
        //   160: ldc             1
        //   162: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   165: aload           4
        //   167: ldc             2
        //   169: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   172: invokeinterface instrumented/java/util/Map$Entry.getValue:()Ljava/lang/Object;
        //   177: astore          6
        //   179: ldc             1
        //   181: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   184: aload           6
        //   186: ldc             2
        //   188: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   191: ifnonnull       248
        //   194: aload_2        
        //   195: aload           5
        //   197: ldc             3
        //   199: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   202: invokeinterface instrumented/java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //   207: ldc             1
        //   209: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   212: ifnonnull       236
        //   215: aload_2        
        //   216: aload           5
        //   218: ldc             3
        //   220: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   223: invokeinterface instrumented/java/util/Map.containsKey:(Ljava/lang/Object;)Z
        //   228: ldc             1
        //   230: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   233: ifne            291
        //   236: iconst_0       
        //   237: ldc             1
        //   239: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   242: ldc             1
        //   244: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   247: ireturn        
        //   248: aload           6
        //   250: aload_2        
        //   251: aload           5
        //   253: ldc             4
        //   255: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   258: invokeinterface instrumented/java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //   263: ldc             1
        //   265: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   268: invokevirtual   java/lang/Object.equals:(Ljava/lang/Object;)Z
        //   271: ldc             1
        //   273: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   276: ifne            291
        //   279: iconst_0       
        //   280: ldc             1
        //   282: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   285: ldc             1
        //   287: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   290: ireturn        
        //   291: ldc             1
        //   293: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   296: goto            106
        //   299: ldc             1
        //   301: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   304: goto            333
        //   307: astore_3       
        //   308: ldc             501
        //   310: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   313: iconst_0       
        //   314: ldc             2
        //   316: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   319: ireturn        
        //   320: astore_3       
        //   321: ldc             501
        //   323: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   326: iconst_0       
        //   327: ldc             2
        //   329: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   332: ireturn        
        //   333: iconst_1       
        //   334: ldc             2
        //   336: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   339: ireturn        
        //   340: athrow         
        //   341: athrow         
        //    StackMapTable: 00 0D 11 12 FC 00 2C 07 00 07 FC 00 18 07 00 D4 FE 00 81 07 00 1D 07 00 A2 07 00 A2 0B F8 00 2A FA 00 07 47 07 01 22 4C 07 00 9A 0C FF 00 06 00 00 00 01 07 00 7C FF 00 00 00 00 00 01 07 00 E6
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                            
        //  -----  -----  -----  -----  --------------------------------
        //  81     341    341    342    Ljava/lang/VirtualMachineError;
        //  81     242    307    320    Ljava/lang/ClassCastException;
        //  248    285    307    320    Ljava/lang/ClassCastException;
        //  291    299    307    320    Ljava/lang/ClassCastException;
        //  81     242    320    333    Ljava/lang/NullPointerException;
        //  248    285    320    333    Ljava/lang/NullPointerException;
        //  291    299    320    333    Ljava/lang/NullPointerException;
        //  0      340    340    341    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0081:
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
    public synchronized int hashCode() {
        try {
            int n = 0;
            BytecodeManager.incBytecodes(2);
            final int count = this.count;
            BytecodeManager.incBytecodes(3);
            if (count != 0) {
                final float n2 = fcmpg(this.loadFactor, 0.0f);
                BytecodeManager.incBytecodes(5);
                if (n2 >= 0) {
                    this.loadFactor = -this.loadFactor;
                    BytecodeManager.incBytecodes(5);
                    final Entry<?, ?>[] table = this.table;
                    BytecodeManager.incBytecodes(3);
                    final Entry<?, ?>[] array = table;
                    final int length = array.length;
                    int n3 = 0;
                    BytecodeManager.incBytecodes(7);
                    while (true) {
                        final int n4 = n3;
                        final int n5 = length;
                        BytecodeManager.incBytecodes(3);
                        if (n4 >= n5) {
                            break;
                        }
                        Entry<?, ?> next = array[n3];
                        BytecodeManager.incBytecodes(4);
                        while (true) {
                            final Entry<?, ?> entry = next;
                            BytecodeManager.incBytecodes(2);
                            if (entry == null) {
                                break;
                            }
                            final int n6 = n;
                            final Entry<?, ?> entry2 = next;
                            BytecodeManager.incBytecodes(3);
                            n = n6 + entry2.hashCode();
                            BytecodeManager.incBytecodes(2);
                            next = next.next;
                            BytecodeManager.incBytecodes(4);
                        }
                        ++n3;
                        BytecodeManager.incBytecodes(2);
                    }
                    this.loadFactor = -this.loadFactor;
                    BytecodeManager.incBytecodes(5);
                    final int n7 = n;
                    BytecodeManager.incBytecodes(2);
                    return n7;
                }
            }
            final int n8 = n;
            BytecodeManager.incBytecodes(2);
            return n8;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public synchronized V getOrDefault(final Object o, final V v) {
        try {
            BytecodeManager.incBytecodes(3);
            final V value = this.get(o);
            BytecodeManager.incBytecodes(1);
            final V v2 = null;
            final V v3 = value;
            BytecodeManager.incBytecodes(3);
            V v4;
            if (v2 == v3) {
                v4 = v;
                BytecodeManager.incBytecodes(2);
            }
            else {
                v4 = value;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return v4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public synchronized void forEach(final BiConsumer<? super K, ? super V> biConsumer) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(biConsumer);
            BytecodeManager.incBytecodes(1);
            final int modCount = this.modCount;
            BytecodeManager.incBytecodes(3);
            final Entry<?, ?>[] table = this.table;
            BytecodeManager.incBytecodes(3);
            final Entry<?, ?>[] array = table;
            final int length = array.length;
            int n = 0;
            BytecodeManager.incBytecodes(7);
        Label_0051:
            while (true) {
                final int n2 = n;
                final int n3 = length;
                BytecodeManager.incBytecodes(3);
                if (n2 < n3) {
                    Entry<?, ?> next = array[n];
                    BytecodeManager.incBytecodes(4);
                    int i;
                    int modCount2;
                    do {
                        final Entry<?, ?> entry = next;
                        BytecodeManager.incBytecodes(2);
                        if (entry == null) {
                            ++n;
                            BytecodeManager.incBytecodes(2);
                            continue Label_0051;
                        }
                        final Object key = next.key;
                        final Object value = next.value;
                        BytecodeManager.incBytecodes(6);
                        biConsumer.accept((Object)key, (Object)value);
                        next = next.next;
                        BytecodeManager.incBytecodes(3);
                        i = modCount;
                        modCount2 = this.modCount;
                        BytecodeManager.incBytecodes(4);
                    } while (i == modCount2);
                    BytecodeManager.incBytecodes(3);
                    final ConcurrentModificationException ex = new ConcurrentModificationException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                BytecodeManager.incBytecodes(1);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public synchronized void replaceAll(final BiFunction<? super K, ? super V, ? extends V> biFunction) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(biFunction);
            BytecodeManager.incBytecodes(1);
            final int modCount = this.modCount;
            BytecodeManager.incBytecodes(3);
            final Entry<?, ?>[] array = this.table;
            BytecodeManager.incBytecodes(4);
            final Entry<?, ?>[] array2 = array;
            final int length = array2.length;
            int n = 0;
            BytecodeManager.incBytecodes(7);
        Label_0054:
            while (true) {
                final int n2 = n;
                final int n3 = length;
                BytecodeManager.incBytecodes(3);
                if (n2 < n3) {
                    Entry<?, ?> next = array2[n];
                    BytecodeManager.incBytecodes(4);
                    int i;
                    int modCount2;
                    do {
                        final Entry<?, ?> entry = next;
                        BytecodeManager.incBytecodes(2);
                        if (entry == null) {
                            ++n;
                            BytecodeManager.incBytecodes(2);
                            continue Label_0054;
                        }
                        final Entry<?, ?> entry2 = next;
                        final Object key = next.key;
                        final Object value = next.value;
                        BytecodeManager.incBytecodes(6);
                        BytecodeManager.incBytecodes(1);
                        final V apply = (V)biFunction.apply((Object)key, (Object)value);
                        BytecodeManager.incBytecodes(1);
                        entry2.value = Objects.requireNonNull((V)apply);
                        BytecodeManager.incBytecodes(1);
                        next = next.next;
                        BytecodeManager.incBytecodes(3);
                        i = modCount;
                        modCount2 = this.modCount;
                        BytecodeManager.incBytecodes(4);
                    } while (i == modCount2);
                    BytecodeManager.incBytecodes(3);
                    final ConcurrentModificationException ex = new ConcurrentModificationException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                BytecodeManager.incBytecodes(1);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public synchronized V putIfAbsent(final K obj, final V value) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(value);
            BytecodeManager.incBytecodes(1);
            final Entry<?, ?>[] table = this.table;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(2);
            final int hashCode = obj.hashCode();
            BytecodeManager.incBytecodes(1);
            final int n = (hashCode & Integer.MAX_VALUE) % table.length;
            BytecodeManager.incBytecodes(7);
            Entry<?, ?> next = table[n];
            BytecodeManager.incBytecodes(4);
            while (true) {
                final Entry<?, ?> entry = next;
                BytecodeManager.incBytecodes(2);
                if (entry == null) {
                    final int n2 = hashCode;
                    final int n3 = n;
                    BytecodeManager.incBytecodes(6);
                    this.addEntry(n2, obj, value, n3);
                    final V v = null;
                    BytecodeManager.incBytecodes(2);
                    return v;
                }
                final int hash = next.hash;
                final int n4 = hashCode;
                BytecodeManager.incBytecodes(4);
                if (hash == n4) {
                    final Object key = next.key;
                    BytecodeManager.incBytecodes(4);
                    final boolean equals = key.equals(obj);
                    BytecodeManager.incBytecodes(1);
                    if (equals) {
                        final Object value2 = next.value;
                        BytecodeManager.incBytecodes(3);
                        final Object o = value2;
                        BytecodeManager.incBytecodes(2);
                        if (o == null) {
                            next.value = value;
                            BytecodeManager.incBytecodes(3);
                        }
                        final Object o2 = value2;
                        BytecodeManager.incBytecodes(2);
                        return (V)o2;
                    }
                }
                next = next.next;
                BytecodeManager.incBytecodes(4);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public synchronized boolean remove(final Object obj, final Object obj2) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(obj2);
            BytecodeManager.incBytecodes(1);
            final Entry<?, ?>[] table = this.table;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(2);
            final int hashCode = obj.hashCode();
            BytecodeManager.incBytecodes(1);
            final int n = (hashCode & Integer.MAX_VALUE) % table.length;
            BytecodeManager.incBytecodes(7);
            Entry<?, ?> next = table[n];
            BytecodeManager.incBytecodes(4);
            Entry<?, ?> entry = null;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final Entry<?, ?> entry2 = next;
                BytecodeManager.incBytecodes(2);
                if (entry2 == null) {
                    final boolean b = false;
                    BytecodeManager.incBytecodes(2);
                    return b;
                }
                final int hash = next.hash;
                final int n2 = hashCode;
                BytecodeManager.incBytecodes(4);
                if (hash == n2) {
                    final Object key = next.key;
                    BytecodeManager.incBytecodes(4);
                    final boolean equals = key.equals(obj);
                    BytecodeManager.incBytecodes(1);
                    if (equals) {
                        final Object value = next.value;
                        BytecodeManager.incBytecodes(4);
                        final boolean equals2 = value.equals(obj2);
                        BytecodeManager.incBytecodes(1);
                        if (equals2) {
                            ++this.modCount;
                            BytecodeManager.incBytecodes(6);
                            final Entry<?, ?> entry3 = entry;
                            BytecodeManager.incBytecodes(2);
                            if (entry3 != null) {
                                entry.next = next.next;
                                BytecodeManager.incBytecodes(5);
                            }
                            else {
                                table[n] = next.next;
                                BytecodeManager.incBytecodes(5);
                            }
                            --this.count;
                            BytecodeManager.incBytecodes(6);
                            next.value = null;
                            BytecodeManager.incBytecodes(3);
                            final boolean b2 = true;
                            BytecodeManager.incBytecodes(2);
                            return b2;
                        }
                    }
                }
                entry = next;
                next = next.next;
                BytecodeManager.incBytecodes(6);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public synchronized boolean replace(final K obj, final V obj2, final V value) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(obj2);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(value);
            BytecodeManager.incBytecodes(1);
            final Entry<?, ?>[] table = this.table;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(2);
            final int hashCode = obj.hashCode();
            BytecodeManager.incBytecodes(1);
            final int n = (hashCode & Integer.MAX_VALUE) % table.length;
            BytecodeManager.incBytecodes(7);
            Entry<?, ?> next = table[n];
            BytecodeManager.incBytecodes(4);
            while (true) {
                final Entry<?, ?> entry = next;
                BytecodeManager.incBytecodes(2);
                if (entry == null) {
                    final boolean b = false;
                    BytecodeManager.incBytecodes(2);
                    return b;
                }
                final int hash = next.hash;
                final int n2 = hashCode;
                BytecodeManager.incBytecodes(4);
                if (hash == n2) {
                    final Object key = next.key;
                    BytecodeManager.incBytecodes(4);
                    final boolean equals = key.equals(obj);
                    BytecodeManager.incBytecodes(1);
                    if (equals) {
                        final Object value2 = next.value;
                        BytecodeManager.incBytecodes(4);
                        final boolean equals2 = value2.equals(obj2);
                        BytecodeManager.incBytecodes(1);
                        if (equals2) {
                            next.value = value;
                            BytecodeManager.incBytecodes(3);
                            final boolean b2 = true;
                            BytecodeManager.incBytecodes(2);
                            return b2;
                        }
                        final boolean b3 = false;
                        BytecodeManager.incBytecodes(2);
                        return b3;
                    }
                }
                next = next.next;
                BytecodeManager.incBytecodes(4);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public synchronized V replace(final K obj, final V value) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(value);
            BytecodeManager.incBytecodes(1);
            final Entry<?, ?>[] table = this.table;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(2);
            final int hashCode = obj.hashCode();
            BytecodeManager.incBytecodes(1);
            final int n = (hashCode & Integer.MAX_VALUE) % table.length;
            BytecodeManager.incBytecodes(7);
            Entry<?, ?> next = table[n];
            BytecodeManager.incBytecodes(4);
            while (true) {
                final Entry<?, ?> entry = next;
                BytecodeManager.incBytecodes(2);
                if (entry == null) {
                    final V v = null;
                    BytecodeManager.incBytecodes(2);
                    return v;
                }
                final int hash = next.hash;
                final int n2 = hashCode;
                BytecodeManager.incBytecodes(4);
                if (hash == n2) {
                    final Object key = next.key;
                    BytecodeManager.incBytecodes(4);
                    final boolean equals = key.equals(obj);
                    BytecodeManager.incBytecodes(1);
                    if (equals) {
                        final Object value2 = next.value;
                        BytecodeManager.incBytecodes(3);
                        next.value = value;
                        BytecodeManager.incBytecodes(3);
                        final Object o = value2;
                        BytecodeManager.incBytecodes(2);
                        return (V)o;
                    }
                }
                next = next.next;
                BytecodeManager.incBytecodes(4);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public synchronized V computeIfAbsent(final K obj, final Function<? super K, ? extends V> function) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(function);
            BytecodeManager.incBytecodes(1);
            final Entry<?, ?>[] table = this.table;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(2);
            final int hashCode = obj.hashCode();
            BytecodeManager.incBytecodes(1);
            final int n = (hashCode & Integer.MAX_VALUE) % table.length;
            BytecodeManager.incBytecodes(7);
            Entry<?, ?> next = table[n];
            BytecodeManager.incBytecodes(4);
            while (true) {
                final Entry<?, ?> entry = next;
                BytecodeManager.incBytecodes(2);
                if (entry == null) {
                    BytecodeManager.incBytecodes(3);
                    final V apply = (V)function.apply(obj);
                    BytecodeManager.incBytecodes(1);
                    final V v = apply;
                    BytecodeManager.incBytecodes(2);
                    if (v != null) {
                        final int n2 = hashCode;
                        final V v2 = apply;
                        final int n3 = n;
                        BytecodeManager.incBytecodes(6);
                        this.addEntry(n2, obj, v2, n3);
                    }
                    final V v3 = apply;
                    BytecodeManager.incBytecodes(2);
                    return v3;
                }
                final int hash = next.hash;
                final int n4 = hashCode;
                BytecodeManager.incBytecodes(4);
                if (hash == n4) {
                    final Object key = next.key;
                    BytecodeManager.incBytecodes(4);
                    final boolean equals = key.equals(obj);
                    BytecodeManager.incBytecodes(1);
                    if (equals) {
                        final Object value = next.value;
                        BytecodeManager.incBytecodes(3);
                        return (V)value;
                    }
                }
                next = next.next;
                BytecodeManager.incBytecodes(4);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public synchronized V computeIfPresent(final K obj, final BiFunction<? super K, ? super V, ? extends V> biFunction) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(biFunction);
            BytecodeManager.incBytecodes(1);
            final Entry<?, ?>[] table = this.table;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(2);
            final int hashCode = obj.hashCode();
            BytecodeManager.incBytecodes(1);
            final int n = (hashCode & Integer.MAX_VALUE) % table.length;
            BytecodeManager.incBytecodes(7);
            Entry<?, ?> next = table[n];
            BytecodeManager.incBytecodes(4);
            Entry<?, ?> entry = null;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final Entry<?, ?> entry2 = next;
                BytecodeManager.incBytecodes(2);
                if (entry2 == null) {
                    final V v = null;
                    BytecodeManager.incBytecodes(2);
                    return v;
                }
                final int hash = next.hash;
                final int n2 = hashCode;
                BytecodeManager.incBytecodes(4);
                if (hash == n2) {
                    final Object key = next.key;
                    BytecodeManager.incBytecodes(4);
                    final boolean equals = key.equals(obj);
                    BytecodeManager.incBytecodes(1);
                    if (equals) {
                        final Object value = next.value;
                        BytecodeManager.incBytecodes(5);
                        final V apply = (V)biFunction.apply(obj, (Object)value);
                        BytecodeManager.incBytecodes(1);
                        final V v2 = apply;
                        BytecodeManager.incBytecodes(2);
                        if (v2 == null) {
                            ++this.modCount;
                            BytecodeManager.incBytecodes(6);
                            final Entry<?, ?> entry3 = entry;
                            BytecodeManager.incBytecodes(2);
                            if (entry3 != null) {
                                entry.next = next.next;
                                BytecodeManager.incBytecodes(5);
                            }
                            else {
                                table[n] = next.next;
                                BytecodeManager.incBytecodes(5);
                            }
                            --this.count;
                            BytecodeManager.incBytecodes(7);
                        }
                        else {
                            next.value = apply;
                            BytecodeManager.incBytecodes(3);
                        }
                        final V v3 = apply;
                        BytecodeManager.incBytecodes(2);
                        return v3;
                    }
                }
                entry = next;
                next = next.next;
                BytecodeManager.incBytecodes(6);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public synchronized V compute(final K k, final BiFunction<? super K, ? super V, ? extends V> biFunction) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(biFunction);
            BytecodeManager.incBytecodes(1);
            final Entry<?, ?>[] table = this.table;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(2);
            final int hashCode = k.hashCode();
            BytecodeManager.incBytecodes(1);
            final int n = (hashCode & Integer.MAX_VALUE) % table.length;
            BytecodeManager.incBytecodes(7);
            Entry<?, ?> next = table[n];
            BytecodeManager.incBytecodes(4);
            Entry<?, ?> entry = null;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final Entry<?, ?> entry2 = next;
                BytecodeManager.incBytecodes(2);
                if (entry2 == null) {
                    final Object o = null;
                    BytecodeManager.incBytecodes(4);
                    final V apply = (V)biFunction.apply(k, (Object)o);
                    BytecodeManager.incBytecodes(1);
                    final V v = apply;
                    BytecodeManager.incBytecodes(2);
                    if (v != null) {
                        final int n2 = hashCode;
                        final V v2 = apply;
                        final int n3 = n;
                        BytecodeManager.incBytecodes(6);
                        this.addEntry(n2, k, v2, n3);
                    }
                    final V v3 = apply;
                    BytecodeManager.incBytecodes(2);
                    return v3;
                }
                final int hash = next.hash;
                final int n4 = hashCode;
                BytecodeManager.incBytecodes(4);
                if (hash == n4) {
                    final Object key = next.key;
                    BytecodeManager.incBytecodes(4);
                    final boolean equals = Objects.equals(key, k);
                    BytecodeManager.incBytecodes(1);
                    if (equals) {
                        final Object value = next.value;
                        BytecodeManager.incBytecodes(5);
                        final V apply2 = (V)biFunction.apply(k, (Object)value);
                        BytecodeManager.incBytecodes(1);
                        final V v4 = apply2;
                        BytecodeManager.incBytecodes(2);
                        if (v4 == null) {
                            ++this.modCount;
                            BytecodeManager.incBytecodes(6);
                            final Entry<?, ?> entry3 = entry;
                            BytecodeManager.incBytecodes(2);
                            if (entry3 != null) {
                                entry.next = next.next;
                                BytecodeManager.incBytecodes(5);
                            }
                            else {
                                table[n] = next.next;
                                BytecodeManager.incBytecodes(5);
                            }
                            --this.count;
                            BytecodeManager.incBytecodes(7);
                        }
                        else {
                            next.value = apply2;
                            BytecodeManager.incBytecodes(3);
                        }
                        final V v5 = apply2;
                        BytecodeManager.incBytecodes(2);
                        return v5;
                    }
                }
                entry = next;
                next = next.next;
                BytecodeManager.incBytecodes(6);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public synchronized V merge(final K obj, final V v, final BiFunction<? super V, ? super V, ? extends V> biFunction) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(biFunction);
            BytecodeManager.incBytecodes(1);
            final Entry<?, ?>[] table = this.table;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(2);
            final int hashCode = obj.hashCode();
            BytecodeManager.incBytecodes(1);
            final int n = (hashCode & Integer.MAX_VALUE) % table.length;
            BytecodeManager.incBytecodes(7);
            Entry<?, ?> next = table[n];
            BytecodeManager.incBytecodes(4);
            Entry<?, ?> entry = null;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final Entry<?, ?> entry2 = next;
                BytecodeManager.incBytecodes(2);
                if (entry2 == null) {
                    BytecodeManager.incBytecodes(2);
                    if (v != null) {
                        final int n2 = hashCode;
                        final int n3 = n;
                        BytecodeManager.incBytecodes(6);
                        this.addEntry(n2, obj, v, n3);
                    }
                    BytecodeManager.incBytecodes(2);
                    return v;
                }
                final int hash = next.hash;
                final int n4 = hashCode;
                BytecodeManager.incBytecodes(4);
                if (hash == n4) {
                    final Object key = next.key;
                    BytecodeManager.incBytecodes(4);
                    final boolean equals = key.equals(obj);
                    BytecodeManager.incBytecodes(1);
                    if (equals) {
                        final Object value = next.value;
                        BytecodeManager.incBytecodes(5);
                        final V apply = (V)biFunction.apply(value, v);
                        BytecodeManager.incBytecodes(1);
                        final V v2 = apply;
                        BytecodeManager.incBytecodes(2);
                        if (v2 == null) {
                            ++this.modCount;
                            BytecodeManager.incBytecodes(6);
                            final Entry<?, ?> entry3 = entry;
                            BytecodeManager.incBytecodes(2);
                            if (entry3 != null) {
                                entry.next = next.next;
                                BytecodeManager.incBytecodes(5);
                            }
                            else {
                                table[n] = next.next;
                                BytecodeManager.incBytecodes(5);
                            }
                            --this.count;
                            BytecodeManager.incBytecodes(7);
                        }
                        else {
                            next.value = apply;
                            BytecodeManager.incBytecodes(3);
                        }
                        final V v3 = apply;
                        BytecodeManager.incBytecodes(2);
                        return v3;
                    }
                }
                entry = next;
                next = next.next;
                BytecodeManager.incBytecodes(6);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void writeObject(final ObjectOutputStream p0) throws IOException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore_2       
        //     2: ldc             2
        //     4: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     7: aload_0        
        //     8: dup            
        //     9: astore_3       
        //    10: pop            
        //    11: ldc             4
        //    13: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    16: aload_1        
        //    17: ldc             2
        //    19: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    22: invokevirtual   java/io/ObjectOutputStream.defaultWriteObject:()V
        //    25: aload_1        
        //    26: aload_0        
        //    27: getfield        instrumented/java/util/Hashtable.table:[Linstrumented/java/util/Hashtable$Entry;
        //    30: arraylength    
        //    31: ldc             5
        //    33: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    36: invokevirtual   java/io/ObjectOutputStream.writeInt:(I)V
        //    39: aload_1        
        //    40: aload_0        
        //    41: getfield        instrumented/java/util/Hashtable.count:I
        //    44: ldc             4
        //    46: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    49: invokevirtual   java/io/ObjectOutputStream.writeInt:(I)V
        //    52: iconst_0       
        //    53: istore          4
        //    55: ldc             2
        //    57: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    60: iload           4
        //    62: aload_0        
        //    63: getfield        instrumented/java/util/Hashtable.table:[Linstrumented/java/util/Hashtable$Entry;
        //    66: arraylength    
        //    67: ldc             5
        //    69: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    72: if_icmpge       155
        //    75: aload_0        
        //    76: getfield        instrumented/java/util/Hashtable.table:[Linstrumented/java/util/Hashtable$Entry;
        //    79: iload           4
        //    81: aaload         
        //    82: astore          5
        //    84: ldc             5
        //    86: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    89: aload           5
        //    91: ldc             2
        //    93: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    96: ifnull          144
        //    99: new             Linstrumented/java/util/Hashtable$Entry;
        //   102: dup            
        //   103: iconst_0       
        //   104: aload           5
        //   106: getfield        instrumented/java/util/Hashtable$Entry.key:Ljava/lang/Object;
        //   109: aload           5
        //   111: getfield        instrumented/java/util/Hashtable$Entry.value:Ljava/lang/Object;
        //   114: aload_2        
        //   115: ldc             9
        //   117: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   120: invokespecial   instrumented/java/util/Hashtable$Entry.<init>:(ILjava/lang/Object;Ljava/lang/Object;Linstrumented/java/util/Hashtable$Entry;)V
        //   123: astore_2       
        //   124: ldc             1
        //   126: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   129: aload           5
        //   131: getfield        instrumented/java/util/Hashtable$Entry.next:Linstrumented/java/util/Hashtable$Entry;
        //   134: astore          5
        //   136: ldc             4
        //   138: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   141: goto            89
        //   144: iinc            4, 1
        //   147: ldc             2
        //   149: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   152: goto            60
        //   155: aload_3        
        //   156: pop            
        //   157: ldc             2
        //   159: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   162: ldc             1
        //   164: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   167: goto            188
        //   170: astore          6
        //   172: aload_3        
        //   173: pop            
        //   174: ldc_w           503
        //   177: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   180: aload           6
        //   182: ldc             2
        //   184: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   187: athrow         
        //   188: aload_2        
        //   189: ldc             2
        //   191: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   194: ifnull          236
        //   197: aload_1        
        //   198: aload_2        
        //   199: getfield        instrumented/java/util/Hashtable$Entry.key:Ljava/lang/Object;
        //   202: ldc             4
        //   204: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   207: invokevirtual   java/io/ObjectOutputStream.writeObject:(Ljava/lang/Object;)V
        //   210: aload_1        
        //   211: aload_2        
        //   212: getfield        instrumented/java/util/Hashtable$Entry.value:Ljava/lang/Object;
        //   215: ldc             4
        //   217: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   220: invokevirtual   java/io/ObjectOutputStream.writeObject:(Ljava/lang/Object;)V
        //   223: aload_2        
        //   224: getfield        instrumented/java/util/Hashtable$Entry.next:Linstrumented/java/util/Hashtable$Entry;
        //   227: astore_2       
        //   228: ldc             4
        //   230: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   233: goto            188
        //   236: ldc             1
        //   238: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   241: return         
        //   242: athrow         
        //   243: athrow         
        //    Exceptions:
        //  throws java.io.IOException
        //    StackMapTable: 00 09 FE 00 3C 07 00 0E 07 00 A2 01 FC 00 1C 07 00 0E FA 00 36 FA 00 0A 4E 07 00 7C FA 00 11 2F FF 00 05 00 00 00 01 07 00 7C FF 00 00 00 00 00 01 07 00 E6
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  16     243    243    244    Ljava/lang/VirtualMachineError;
        //  16     162    170    188    Any
        //  170    180    170    188    Any
        //  0      242    242    243    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0060:
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
    
    private void readObject(final ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            BytecodeManager.incBytecodes(2);
            objectInputStream.defaultReadObject();
            BytecodeManager.incBytecodes(2);
            final int int1 = objectInputStream.readInt();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            int int2 = objectInputStream.readInt();
            BytecodeManager.incBytecodes(1);
            int n = (int)(int2 * this.loadFactor) + int2 / 20 + 3;
            BytecodeManager.incBytecodes(13);
            final int n2 = n;
            final int n3 = int2;
            BytecodeManager.incBytecodes(3);
            if (n2 > n3) {
                final int n4 = n & 0x1;
                BytecodeManager.incBytecodes(4);
                if (n4 == 0) {
                    --n;
                    BytecodeManager.incBytecodes(1);
                }
            }
            final int n5 = int1;
            BytecodeManager.incBytecodes(2);
            if (n5 > 0) {
                final int n6 = n;
                final int n7 = int1;
                BytecodeManager.incBytecodes(3);
                if (n6 > n7) {
                    n = int1;
                    BytecodeManager.incBytecodes(2);
                }
            }
            this.table = (Entry<?, ?>[])new Entry[n];
            BytecodeManager.incBytecodes(3);
            final float a = n * this.loadFactor;
            final float b = 2.14748365E9f;
            BytecodeManager.incBytecodes(8);
            this.threshold = (int)Math.min(a, b);
            BytecodeManager.incBytecodes(2);
            this.count = 0;
            BytecodeManager.incBytecodes(3);
            while (true) {
                final int n8 = int2;
                BytecodeManager.incBytecodes(2);
                if (n8 <= 0) {
                    break;
                }
                BytecodeManager.incBytecodes(2);
                final Object object = objectInputStream.readObject();
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(2);
                final Object object2 = objectInputStream.readObject();
                BytecodeManager.incBytecodes(1);
                final Entry<?, ?>[] table = this.table;
                final Object o = object;
                final Object o2 = object2;
                BytecodeManager.incBytecodes(6);
                this.reconstitutionPut(table, (K)o, (V)o2);
                --int2;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void reconstitutionPut(final Entry<?, ?>[] array, final K obj, final V v) throws StreamCorruptedException {
        try {
            BytecodeManager.incBytecodes(2);
            if (v == null) {
                BytecodeManager.incBytecodes(3);
                final StreamCorruptedException ex = new StreamCorruptedException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(2);
            final int hashCode = obj.hashCode();
            BytecodeManager.incBytecodes(1);
            final int n = (hashCode & Integer.MAX_VALUE) % array.length;
            BytecodeManager.incBytecodes(7);
            Entry<?, ?> next = array[n];
            BytecodeManager.incBytecodes(4);
            while (true) {
                final Entry<?, ?> entry = next;
                BytecodeManager.incBytecodes(2);
                if (entry == null) {
                    final Entry<?, ?> entry2 = array[n];
                    BytecodeManager.incBytecodes(4);
                    final int n2 = n;
                    final int n3 = hashCode;
                    final Entry<Object, Object> entry3 = (Entry<Object, Object>)entry2;
                    BytecodeManager.incBytecodes(9);
                    array[n2] = new Entry<Object, Object>(n3, obj, v, entry3);
                    BytecodeManager.incBytecodes(1);
                    ++this.count;
                    BytecodeManager.incBytecodes(6);
                    BytecodeManager.incBytecodes(1);
                    return;
                }
                final int hash = next.hash;
                final int n4 = hashCode;
                BytecodeManager.incBytecodes(4);
                if (hash == n4) {
                    final Object key = next.key;
                    BytecodeManager.incBytecodes(4);
                    final boolean equals = key.equals(obj);
                    BytecodeManager.incBytecodes(1);
                    if (equals) {
                        BytecodeManager.incBytecodes(3);
                        final StreamCorruptedException ex2 = new StreamCorruptedException();
                        BytecodeManager.incBytecodes(1);
                        throw ex2;
                    }
                }
                next = next.next;
                BytecodeManager.incBytecodes(4);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static /* synthetic */ Iterator access$100(final Hashtable hashtable, final int n) {
        try {
            BytecodeManager.incBytecodes(3);
            final Iterator iterator = hashtable.getIterator(n);
            BytecodeManager.incBytecodes(1);
            return iterator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static /* synthetic */ int access$200(final Hashtable hashtable) {
        try {
            final int count = hashtable.count;
            BytecodeManager.incBytecodes(3);
            return count;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static /* synthetic */ Entry[] access$400(final Hashtable hashtable) {
        try {
            final Entry<?, ?>[] table = hashtable.table;
            BytecodeManager.incBytecodes(3);
            return table;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static /* synthetic */ int access$508(final Hashtable hashtable) {
        try {
            final int n = hashtable.modCount++;
            BytecodeManager.incBytecodes(8);
            return n;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static /* synthetic */ int access$210(final Hashtable hashtable) {
        try {
            final int n = hashtable.count--;
            BytecodeManager.incBytecodes(8);
            return n;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static /* synthetic */ int access$500(final Hashtable hashtable) {
        try {
            final int modCount = hashtable.modCount;
            BytecodeManager.incBytecodes(3);
            return modCount;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
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
                final Hashtable this$0 = Hashtable.this;
                final int n = 0;
                BytecodeManager.incBytecodes(4);
                final Iterator access$100 = Hashtable.access$100(this$0, n);
                BytecodeManager.incBytecodes(1);
                return (Iterator<K>)access$100;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int size() {
            try {
                final Hashtable this$0 = Hashtable.this;
                BytecodeManager.incBytecodes(3);
                final int access$200 = Hashtable.access$200(this$0);
                BytecodeManager.incBytecodes(1);
                return access$200;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean contains(final Object o) {
            try {
                final Hashtable this$0 = Hashtable.this;
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
                final Hashtable this$0 = Hashtable.this;
                BytecodeManager.incBytecodes(4);
                final Object remove = this$0.remove(o);
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
                final Hashtable this$0 = Hashtable.this;
                BytecodeManager.incBytecodes(3);
                this$0.clear();
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private class EntrySet extends AbstractSet<Map.Entry<K, V>>
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
        public Iterator<Map.Entry<K, V>> iterator() {
            try {
                final Hashtable this$0 = Hashtable.this;
                final int n = 2;
                BytecodeManager.incBytecodes(4);
                final Iterator access$100 = Hashtable.access$100(this$0, n);
                BytecodeManager.incBytecodes(1);
                return (Iterator<Map.Entry<K, V>>)access$100;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean add(final Map.Entry<K, V> entry) {
            try {
                BytecodeManager.incBytecodes(3);
                final boolean add = super.add(entry);
                BytecodeManager.incBytecodes(1);
                return add;
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
                final Map.Entry<Object, V> entry2 = (Map.Entry<Object, V>)entry;
                BytecodeManager.incBytecodes(2);
                final Object key = entry2.getKey();
                BytecodeManager.incBytecodes(1);
                final Hashtable this$0 = Hashtable.this;
                BytecodeManager.incBytecodes(3);
                final Entry[] access$400 = Hashtable.access$400(this$0);
                BytecodeManager.incBytecodes(1);
                final Object o2 = key;
                BytecodeManager.incBytecodes(2);
                final int hashCode = o2.hashCode();
                BytecodeManager.incBytecodes(1);
                final int n = (hashCode & Integer.MAX_VALUE) % access$400.length;
                BytecodeManager.incBytecodes(7);
                Entry next = access$400[n];
                BytecodeManager.incBytecodes(4);
                while (true) {
                    final Entry entry3 = next;
                    BytecodeManager.incBytecodes(2);
                    if (entry3 == null) {
                        final boolean b3 = false;
                        BytecodeManager.incBytecodes(2);
                        return b3;
                    }
                    final int hash = next.hash;
                    final int n2 = hashCode;
                    BytecodeManager.incBytecodes(4);
                    if (hash == n2) {
                        final Entry entry4 = next;
                        final Map.Entry<Object, V> entry5 = (Map.Entry<Object, V>)entry;
                        BytecodeManager.incBytecodes(3);
                        final boolean equals = entry4.equals(entry5);
                        BytecodeManager.incBytecodes(1);
                        if (equals) {
                            final boolean b4 = true;
                            BytecodeManager.incBytecodes(2);
                            return b4;
                        }
                    }
                    next = next.next;
                    BytecodeManager.incBytecodes(4);
                }
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
                final Map.Entry<Object, V> entry2 = (Map.Entry<Object, V>)entry;
                BytecodeManager.incBytecodes(2);
                final Object key = entry2.getKey();
                BytecodeManager.incBytecodes(1);
                final Hashtable this$0 = Hashtable.this;
                BytecodeManager.incBytecodes(3);
                final Entry[] access$400 = Hashtable.access$400(this$0);
                BytecodeManager.incBytecodes(1);
                final Object o2 = key;
                BytecodeManager.incBytecodes(2);
                final int hashCode = o2.hashCode();
                BytecodeManager.incBytecodes(1);
                final int n = (hashCode & Integer.MAX_VALUE) % access$400.length;
                BytecodeManager.incBytecodes(7);
                Entry next = access$400[n];
                BytecodeManager.incBytecodes(4);
                Entry entry3 = null;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final Entry entry4 = next;
                    BytecodeManager.incBytecodes(2);
                    if (entry4 == null) {
                        final boolean b3 = false;
                        BytecodeManager.incBytecodes(2);
                        return b3;
                    }
                    final int hash = next.hash;
                    final int n2 = hashCode;
                    BytecodeManager.incBytecodes(4);
                    if (hash == n2) {
                        final Entry entry5 = next;
                        final Map.Entry<Object, V> entry6 = (Map.Entry<Object, V>)entry;
                        BytecodeManager.incBytecodes(3);
                        final boolean equals = entry5.equals(entry6);
                        BytecodeManager.incBytecodes(1);
                        if (equals) {
                            final Hashtable this$2 = Hashtable.this;
                            BytecodeManager.incBytecodes(3);
                            Hashtable.access$508(this$2);
                            BytecodeManager.incBytecodes(1);
                            final Entry entry7 = entry3;
                            BytecodeManager.incBytecodes(2);
                            if (entry7 != null) {
                                entry3.next = next.next;
                                BytecodeManager.incBytecodes(5);
                            }
                            else {
                                access$400[n] = next.next;
                                BytecodeManager.incBytecodes(5);
                            }
                            final Hashtable this$3 = Hashtable.this;
                            BytecodeManager.incBytecodes(3);
                            Hashtable.access$210(this$3);
                            BytecodeManager.incBytecodes(1);
                            next.value = null;
                            BytecodeManager.incBytecodes(3);
                            final boolean b4 = true;
                            BytecodeManager.incBytecodes(2);
                            return b4;
                        }
                    }
                    entry3 = next;
                    next = next.next;
                    BytecodeManager.incBytecodes(6);
                }
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int size() {
            try {
                final Hashtable this$0 = Hashtable.this;
                BytecodeManager.incBytecodes(3);
                final int access$200 = Hashtable.access$200(this$0);
                BytecodeManager.incBytecodes(1);
                return access$200;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void clear() {
            try {
                final Hashtable this$0 = Hashtable.this;
                BytecodeManager.incBytecodes(3);
                this$0.clear();
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private class ValueCollection extends AbstractCollection<V>
    {
        private ValueCollection() {
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
                final Hashtable this$0 = Hashtable.this;
                final int n = 1;
                BytecodeManager.incBytecodes(4);
                final Iterator access$100 = Hashtable.access$100(this$0, n);
                BytecodeManager.incBytecodes(1);
                return (Iterator<V>)access$100;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int size() {
            try {
                final Hashtable this$0 = Hashtable.this;
                BytecodeManager.incBytecodes(3);
                final int access$200 = Hashtable.access$200(this$0);
                BytecodeManager.incBytecodes(1);
                return access$200;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean contains(final Object o) {
            try {
                final Hashtable this$0 = Hashtable.this;
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
        public void clear() {
            try {
                final Hashtable this$0 = Hashtable.this;
                BytecodeManager.incBytecodes(3);
                this$0.clear();
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private static class Entry<K, V> implements Map.Entry<K, V>
    {
        final int hash;
        final K key;
        V value;
        Entry<K, V> next;
        
        protected Entry(final int hash, final K key, final V value, final Entry<K, V> next) {
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
        protected Object clone() {
            try {
                final int hash = this.hash;
                final K key = this.key;
                final V value = this.value;
                final Entry<K, V> next = this.next;
                BytecodeManager.incBytecodes(11);
                Entry<Object, Object> entry;
                if (next == null) {
                    entry = null;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final Entry<K, V> next2 = this.next;
                    BytecodeManager.incBytecodes(2);
                    BytecodeManager.incBytecodes(1);
                    entry = (Entry<Object, Object>)next2.clone();
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
                final Entry entry2 = new Entry(hash, key, value, entry);
                BytecodeManager.incBytecodes(1);
                return entry2;
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
                final V value = this.value;
                BytecodeManager.incBytecodes(3);
                return value;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public V setValue(final V value) {
            try {
                BytecodeManager.incBytecodes(2);
                if (value == null) {
                    BytecodeManager.incBytecodes(3);
                    final NullPointerException ex = new NullPointerException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
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
        public boolean equals(final Object o) {
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
                final K key = this.key;
                BytecodeManager.incBytecodes(3);
                boolean b3 = false;
                Label_0189: {
                    Label_0183: {
                        if (key == null) {
                            final Map.Entry entry2 = entry;
                            BytecodeManager.incBytecodes(2);
                            final Object key2 = entry2.getKey();
                            BytecodeManager.incBytecodes(1);
                            if (key2 != null) {
                                break Label_0183;
                            }
                            BytecodeManager.incBytecodes(1);
                        }
                        else {
                            final K key3 = this.key;
                            final Map.Entry entry3 = entry;
                            BytecodeManager.incBytecodes(4);
                            final Object key4 = entry3.getKey();
                            BytecodeManager.incBytecodes(1);
                            final boolean equals = key3.equals(key4);
                            BytecodeManager.incBytecodes(1);
                            if (!equals) {
                                break Label_0183;
                            }
                        }
                        final V value = this.value;
                        BytecodeManager.incBytecodes(3);
                        if (value == null) {
                            final Map.Entry entry4 = entry;
                            BytecodeManager.incBytecodes(1);
                            BytecodeManager.incBytecodes(1);
                            final Object value2 = entry4.getValue();
                            BytecodeManager.incBytecodes(1);
                            if (value2 != null) {
                                break Label_0183;
                            }
                            BytecodeManager.incBytecodes(1);
                        }
                        else {
                            final V value3 = this.value;
                            final Map.Entry<Object, __Null> entry5 = (Map.Entry<Object, __Null>)entry;
                            BytecodeManager.incBytecodes(4);
                            final Object value4 = entry5.getValue();
                            BytecodeManager.incBytecodes(1);
                            final boolean equals2 = value3.equals(value4);
                            BytecodeManager.incBytecodes(1);
                            if (!equals2) {
                                break Label_0183;
                            }
                        }
                        b3 = true;
                        BytecodeManager.incBytecodes(2);
                        break Label_0189;
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
                final int hash = this.hash;
                final V value = this.value;
                BytecodeManager.incBytecodes(5);
                final int n = hash ^ Objects.hashCode(value);
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
                final String string = key.toString();
                BytecodeManager.incBytecodes(1);
                final StringBuilder append = sb.append(string);
                final String str = "=";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append2 = append.append(str);
                final V value = this.value;
                BytecodeManager.incBytecodes(3);
                final String string2 = value.toString();
                BytecodeManager.incBytecodes(1);
                final StringBuilder append3 = append2.append(string2);
                BytecodeManager.incBytecodes(1);
                final String string3 = append3.toString();
                BytecodeManager.incBytecodes(1);
                return string3;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private class Enumerator<T> implements Enumeration<T>, Iterator<T>
    {
        Entry<?, ?>[] table;
        int index;
        Entry<?, ?> entry;
        Entry<?, ?> lastReturned;
        int type;
        boolean iterator;
        protected int expectedModCount;
        
        Enumerator(final int type, final boolean iterator) {
            try {
                BytecodeManager.incBytecodes(5);
                final Hashtable this$2 = Hashtable.this;
                BytecodeManager.incBytecodes(4);
                this.table = (Entry<?, ?>[])Hashtable.access$400(this$2);
                BytecodeManager.incBytecodes(1);
                this.index = this.table.length;
                BytecodeManager.incBytecodes(5);
                final Hashtable this$3 = Hashtable.this;
                BytecodeManager.incBytecodes(4);
                this.expectedModCount = Hashtable.access$500(this$3);
                BytecodeManager.incBytecodes(1);
                this.type = type;
                BytecodeManager.incBytecodes(3);
                this.iterator = iterator;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean hasMoreElements() {
            try {
                Entry<?, ?> entry = this.entry;
                BytecodeManager.incBytecodes(3);
                int index = this.index;
                BytecodeManager.incBytecodes(3);
                final Entry<?, ?>[] table = this.table;
                BytecodeManager.incBytecodes(3);
                while (true) {
                    final Entry<?, ?> entry2 = entry;
                    BytecodeManager.incBytecodes(2);
                    if (entry2 != null) {
                        break;
                    }
                    final int n = index;
                    BytecodeManager.incBytecodes(2);
                    if (n <= 0) {
                        break;
                    }
                    entry = table[--index];
                    BytecodeManager.incBytecodes(6);
                }
                this.entry = entry;
                BytecodeManager.incBytecodes(3);
                this.index = index;
                BytecodeManager.incBytecodes(3);
                final Entry<?, ?> entry3 = entry;
                BytecodeManager.incBytecodes(2);
                boolean b;
                if (entry3 != null) {
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
        public T nextElement() {
            try {
                Entry<?, ?> entry = this.entry;
                BytecodeManager.incBytecodes(3);
                int index = this.index;
                BytecodeManager.incBytecodes(3);
                final Entry<?, ?>[] table = this.table;
                BytecodeManager.incBytecodes(3);
                while (true) {
                    final Entry<?, ?> entry2 = entry;
                    BytecodeManager.incBytecodes(2);
                    if (entry2 != null) {
                        break;
                    }
                    final int n = index;
                    BytecodeManager.incBytecodes(2);
                    if (n <= 0) {
                        break;
                    }
                    entry = table[--index];
                    BytecodeManager.incBytecodes(6);
                }
                this.entry = entry;
                BytecodeManager.incBytecodes(3);
                this.index = index;
                BytecodeManager.incBytecodes(3);
                final Entry<?, ?> entry3 = entry;
                BytecodeManager.incBytecodes(2);
                if (entry3 != null) {
                    final Entry<?, ?> entry4 = this.entry;
                    this.lastReturned = entry4;
                    final Entry<?, ?> entry5 = entry4;
                    BytecodeManager.incBytecodes(6);
                    this.entry = entry5.next;
                    BytecodeManager.incBytecodes(4);
                    final int type = this.type;
                    BytecodeManager.incBytecodes(3);
                    Object o;
                    if (type == 0) {
                        o = entry5.key;
                        BytecodeManager.incBytecodes(3);
                    }
                    else {
                        final int type2 = this.type;
                        final int n2 = 1;
                        BytecodeManager.incBytecodes(4);
                        if (type2 == n2) {
                            o = entry5.value;
                            BytecodeManager.incBytecodes(3);
                        }
                        else {
                            o = entry5;
                            BytecodeManager.incBytecodes(1);
                        }
                    }
                    BytecodeManager.incBytecodes(1);
                    return (T)o;
                }
                final String s = "Hashtable Enumerator";
                BytecodeManager.incBytecodes(4);
                final NoSuchElementException ex = new NoSuchElementException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean hasNext() {
            try {
                BytecodeManager.incBytecodes(2);
                final boolean hasMoreElements = this.hasMoreElements();
                BytecodeManager.incBytecodes(1);
                return hasMoreElements;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public T next() {
            try {
                final Hashtable this$0 = Hashtable.this;
                BytecodeManager.incBytecodes(3);
                final int access$500 = Hashtable.access$500(this$0);
                final int expectedModCount = this.expectedModCount;
                BytecodeManager.incBytecodes(3);
                if (access$500 != expectedModCount) {
                    BytecodeManager.incBytecodes(3);
                    final ConcurrentModificationException ex = new ConcurrentModificationException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                BytecodeManager.incBytecodes(2);
                final T nextElement = this.nextElement();
                BytecodeManager.incBytecodes(1);
                return nextElement;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void remove() {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: getfield        instrumented/java/util/Hashtable$Enumerator.iterator:Z
            //     4: ldc             3
            //     6: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //     9: ifne            30
            //    12: new             Ljava/lang/UnsupportedOperationException;
            //    15: dup            
            //    16: ldc             3
            //    18: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    21: invokespecial   java/lang/UnsupportedOperationException.<init>:()V
            //    24: ldc             1
            //    26: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    29: athrow         
            //    30: aload_0        
            //    31: getfield        instrumented/java/util/Hashtable$Enumerator.lastReturned:Linstrumented/java/util/Hashtable$Entry;
            //    34: ldc             3
            //    36: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    39: ifnonnull       62
            //    42: new             Ljava/lang/IllegalStateException;
            //    45: dup            
            //    46: ldc             "Hashtable Enumerator"
            //    48: ldc             4
            //    50: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    53: invokespecial   java/lang/IllegalStateException.<init>:(Ljava/lang/String;)V
            //    56: ldc             1
            //    58: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    61: athrow         
            //    62: aload_0        
            //    63: getfield        instrumented/java/util/Hashtable$Enumerator.this$0:Linstrumented/java/util/Hashtable;
            //    66: ldc             3
            //    68: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    71: invokestatic    instrumented/java/util/Hashtable.access$500:(Linstrumented/java/util/Hashtable;)I
            //    74: aload_0        
            //    75: getfield        instrumented/java/util/Hashtable$Enumerator.expectedModCount:I
            //    78: ldc             3
            //    80: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    83: if_icmpeq       104
            //    86: new             Linstrumented/java/util/ConcurrentModificationException;
            //    89: dup            
            //    90: ldc             3
            //    92: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    95: invokespecial   instrumented/java/util/ConcurrentModificationException.<init>:()V
            //    98: ldc             1
            //   100: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   103: athrow         
            //   104: aload_0        
            //   105: getfield        instrumented/java/util/Hashtable$Enumerator.this$0:Linstrumented/java/util/Hashtable;
            //   108: dup            
            //   109: astore_1       
            //   110: pop            
            //   111: ldc             5
            //   113: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   116: aload_0        
            //   117: getfield        instrumented/java/util/Hashtable$Enumerator.this$0:Linstrumented/java/util/Hashtable;
            //   120: ldc             3
            //   122: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   125: invokestatic    instrumented/java/util/Hashtable.access$400:(Linstrumented/java/util/Hashtable;)[Linstrumented/java/util/Hashtable$Entry;
            //   128: astore_2       
            //   129: ldc             1
            //   131: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   134: aload_0        
            //   135: getfield        instrumented/java/util/Hashtable$Enumerator.lastReturned:Linstrumented/java/util/Hashtable$Entry;
            //   138: getfield        instrumented/java/util/Hashtable$Entry.hash:I
            //   141: ldc             2147483647
            //   143: iand           
            //   144: aload_2        
            //   145: arraylength    
            //   146: irem           
            //   147: istore_3       
            //   148: ldc             9
            //   150: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   153: aload_2        
            //   154: iload_3        
            //   155: aaload         
            //   156: astore          4
            //   158: ldc             4
            //   160: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   163: aconst_null    
            //   164: astore          5
            //   166: ldc             2
            //   168: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   171: aload           4
            //   173: ldc             2
            //   175: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   178: ifnull          329
            //   181: aload           4
            //   183: aload_0        
            //   184: getfield        instrumented/java/util/Hashtable$Enumerator.lastReturned:Linstrumented/java/util/Hashtable$Entry;
            //   187: ldc             4
            //   189: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   192: if_acmpne       310
            //   195: aload_0        
            //   196: getfield        instrumented/java/util/Hashtable$Enumerator.this$0:Linstrumented/java/util/Hashtable;
            //   199: ldc             3
            //   201: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   204: invokestatic    instrumented/java/util/Hashtable.access$508:(Linstrumented/java/util/Hashtable;)I
            //   207: pop            
            //   208: ldc             1
            //   210: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   213: aload_0        
            //   214: dup            
            //   215: getfield        instrumented/java/util/Hashtable$Enumerator.expectedModCount:I
            //   218: iconst_1       
            //   219: iadd           
            //   220: putfield        instrumented/java/util/Hashtable$Enumerator.expectedModCount:I
            //   223: ldc             6
            //   225: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   228: aload           5
            //   230: ldc             2
            //   232: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   235: ifnonnull       254
            //   238: aload_2        
            //   239: iload_3        
            //   240: aload           4
            //   242: getfield        instrumented/java/util/Hashtable$Entry.next:Linstrumented/java/util/Hashtable$Entry;
            //   245: aastore        
            //   246: ldc             6
            //   248: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   251: goto            269
            //   254: aload           5
            //   256: aload           4
            //   258: getfield        instrumented/java/util/Hashtable$Entry.next:Linstrumented/java/util/Hashtable$Entry;
            //   261: putfield        instrumented/java/util/Hashtable$Entry.next:Linstrumented/java/util/Hashtable$Entry;
            //   264: ldc             4
            //   266: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   269: aload_0        
            //   270: getfield        instrumented/java/util/Hashtable$Enumerator.this$0:Linstrumented/java/util/Hashtable;
            //   273: ldc             3
            //   275: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   278: invokestatic    instrumented/java/util/Hashtable.access$210:(Linstrumented/java/util/Hashtable;)I
            //   281: pop            
            //   282: ldc             1
            //   284: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   287: aload_0        
            //   288: aconst_null    
            //   289: putfield        instrumented/java/util/Hashtable$Enumerator.lastReturned:Linstrumented/java/util/Hashtable$Entry;
            //   292: ldc             3
            //   294: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   297: aload_1        
            //   298: pop            
            //   299: ldc             2
            //   301: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   304: ldc             1
            //   306: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   309: return         
            //   310: aload           4
            //   312: astore          5
            //   314: aload           4
            //   316: getfield        instrumented/java/util/Hashtable$Entry.next:Linstrumented/java/util/Hashtable$Entry;
            //   319: astore          4
            //   321: ldc             6
            //   323: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   326: goto            171
            //   329: new             Linstrumented/java/util/ConcurrentModificationException;
            //   332: dup            
            //   333: ldc             3
            //   335: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   338: invokespecial   instrumented/java/util/ConcurrentModificationException.<init>:()V
            //   341: ldc             1
            //   343: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   346: athrow         
            //   347: astore          6
            //   349: aload_1        
            //   350: pop            
            //   351: ldc             503
            //   353: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   356: aload           6
            //   358: ldc             2
            //   360: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   363: athrow         
            //   364: athrow         
            //   365: athrow         
            //    StackMapTable: 00 0B 1E 1F 29 FF 00 42 00 06 07 00 02 07 00 05 07 00 49 01 07 00 0C 07 00 0C 00 00 FB 00 52 0E 28 FA 00 12 FF 00 11 00 02 07 00 02 07 00 05 00 01 07 00 44 FF 00 10 00 00 00 01 07 00 44 FF 00 00 00 00 00 01 07 00 6B
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                           
            //  -----  -----  -----  -----  -------------------------------
            //  116    365    365    366    Ljava/lang/VirtualMachineError;
            //  116    304    347    364    Any
            //  310    356    347    364    Any
            //  0      364    364    365    Any
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0171:
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
}
