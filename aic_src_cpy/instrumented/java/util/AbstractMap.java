// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import java.io.Serializable;
import java.util.Iterator;
import aic2021.engine.BytecodeManager;

public abstract class AbstractMap<K, V> implements Map<K, V>
{
    transient volatile Set<K> keySet;
    transient volatile Collection<V> values;
    
    protected AbstractMap() {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public int size() {
        try {
            BytecodeManager.incBytecodes(2);
            final Set<Entry<K, V>> entrySet = this.entrySet();
            BytecodeManager.incBytecodes(1);
            final int size = entrySet.size();
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
            BytecodeManager.incBytecodes(2);
            final int size = this.size();
            BytecodeManager.incBytecodes(1);
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
    public boolean containsValue(final Object o) {
        try {
            BytecodeManager.incBytecodes(2);
            final Set<Entry<K, V>> entrySet = this.entrySet();
            BytecodeManager.incBytecodes(1);
            final Iterator<Entry<K, V>> iterator = entrySet.iterator();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            if (o == null) {
                while (true) {
                    final Iterator<Entry<K, V>> iterator2 = iterator;
                    BytecodeManager.incBytecodes(2);
                    final boolean hasNext = iterator2.hasNext();
                    BytecodeManager.incBytecodes(1);
                    if (!hasNext) {
                        break;
                    }
                    final Iterator<Entry<K, V>> iterator3 = iterator;
                    BytecodeManager.incBytecodes(2);
                    final Entry<K, V> entry = iterator3.next();
                    BytecodeManager.incBytecodes(2);
                    final Entry<K, V> entry2 = entry;
                    BytecodeManager.incBytecodes(2);
                    final V value = entry2.getValue();
                    BytecodeManager.incBytecodes(1);
                    if (value == null) {
                        final boolean b = true;
                        BytecodeManager.incBytecodes(2);
                        return b;
                    }
                    BytecodeManager.incBytecodes(1);
                }
            }
            else {
                while (true) {
                    final Iterator<Entry<K, V>> iterator4 = iterator;
                    BytecodeManager.incBytecodes(2);
                    final boolean hasNext2 = iterator4.hasNext();
                    BytecodeManager.incBytecodes(1);
                    if (!hasNext2) {
                        break;
                    }
                    final Iterator<Entry<K, V>> iterator5 = iterator;
                    BytecodeManager.incBytecodes(2);
                    final Entry<K, V> entry3 = iterator5.next();
                    BytecodeManager.incBytecodes(2);
                    final Entry<K, V> entry4 = entry3;
                    BytecodeManager.incBytecodes(3);
                    final V value2 = entry4.getValue();
                    BytecodeManager.incBytecodes(1);
                    final boolean equals = o.equals(value2);
                    BytecodeManager.incBytecodes(1);
                    if (equals) {
                        final boolean b2 = true;
                        BytecodeManager.incBytecodes(2);
                        return b2;
                    }
                    BytecodeManager.incBytecodes(1);
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
    public boolean containsKey(final Object o) {
        try {
            BytecodeManager.incBytecodes(2);
            final Set<Entry<K, V>> entrySet = this.entrySet();
            BytecodeManager.incBytecodes(1);
            final Iterator<Entry<K, V>> iterator = entrySet.iterator();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            if (o == null) {
                while (true) {
                    final Iterator<Entry<K, V>> iterator2 = iterator;
                    BytecodeManager.incBytecodes(2);
                    final boolean hasNext = iterator2.hasNext();
                    BytecodeManager.incBytecodes(1);
                    if (!hasNext) {
                        break;
                    }
                    final Iterator<Entry<K, V>> iterator3 = iterator;
                    BytecodeManager.incBytecodes(2);
                    final Entry<K, V> entry = iterator3.next();
                    BytecodeManager.incBytecodes(2);
                    final Entry<K, V> entry2 = entry;
                    BytecodeManager.incBytecodes(2);
                    final K key = entry2.getKey();
                    BytecodeManager.incBytecodes(1);
                    if (key == null) {
                        final boolean b = true;
                        BytecodeManager.incBytecodes(2);
                        return b;
                    }
                    BytecodeManager.incBytecodes(1);
                }
            }
            else {
                while (true) {
                    final Iterator<Entry<K, V>> iterator4 = iterator;
                    BytecodeManager.incBytecodes(2);
                    final boolean hasNext2 = iterator4.hasNext();
                    BytecodeManager.incBytecodes(1);
                    if (!hasNext2) {
                        break;
                    }
                    final Iterator<Entry<K, V>> iterator5 = iterator;
                    BytecodeManager.incBytecodes(2);
                    final Entry<K, V> entry3 = iterator5.next();
                    BytecodeManager.incBytecodes(2);
                    final Entry<K, V> entry4 = entry3;
                    BytecodeManager.incBytecodes(3);
                    final K key2 = entry4.getKey();
                    BytecodeManager.incBytecodes(1);
                    final boolean equals = o.equals(key2);
                    BytecodeManager.incBytecodes(1);
                    if (equals) {
                        final boolean b2 = true;
                        BytecodeManager.incBytecodes(2);
                        return b2;
                    }
                    BytecodeManager.incBytecodes(1);
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
    public V get(final Object o) {
        try {
            BytecodeManager.incBytecodes(2);
            final Set<Entry<K, V>> entrySet = this.entrySet();
            BytecodeManager.incBytecodes(1);
            final Iterator<Entry<K, V>> iterator = entrySet.iterator();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            if (o == null) {
                while (true) {
                    final Iterator<Entry<K, V>> iterator2 = iterator;
                    BytecodeManager.incBytecodes(2);
                    final boolean hasNext = iterator2.hasNext();
                    BytecodeManager.incBytecodes(1);
                    if (!hasNext) {
                        break;
                    }
                    final Iterator<Entry<K, V>> iterator3 = iterator;
                    BytecodeManager.incBytecodes(2);
                    final Entry<K, V> entry = iterator3.next();
                    BytecodeManager.incBytecodes(2);
                    final Entry<K, V> entry2 = entry;
                    BytecodeManager.incBytecodes(2);
                    final K key = entry2.getKey();
                    BytecodeManager.incBytecodes(1);
                    if (key == null) {
                        final Entry<K, V> entry3 = entry;
                        BytecodeManager.incBytecodes(2);
                        final V value = entry3.getValue();
                        BytecodeManager.incBytecodes(1);
                        return value;
                    }
                    BytecodeManager.incBytecodes(1);
                }
            }
            else {
                while (true) {
                    final Iterator<Entry<K, V>> iterator4 = iterator;
                    BytecodeManager.incBytecodes(2);
                    final boolean hasNext2 = iterator4.hasNext();
                    BytecodeManager.incBytecodes(1);
                    if (!hasNext2) {
                        break;
                    }
                    final Iterator<Entry<K, V>> iterator5 = iterator;
                    BytecodeManager.incBytecodes(2);
                    final Entry<K, V> entry4 = iterator5.next();
                    BytecodeManager.incBytecodes(2);
                    final Entry<K, V> entry5 = entry4;
                    BytecodeManager.incBytecodes(3);
                    final K key2 = entry5.getKey();
                    BytecodeManager.incBytecodes(1);
                    final boolean equals = o.equals(key2);
                    BytecodeManager.incBytecodes(1);
                    if (equals) {
                        final Entry<K, V> entry6 = entry4;
                        BytecodeManager.incBytecodes(2);
                        final V value2 = entry6.getValue();
                        BytecodeManager.incBytecodes(1);
                        return value2;
                    }
                    BytecodeManager.incBytecodes(1);
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
    public V put(final K k, final V v) {
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
    public V remove(final Object o) {
        try {
            BytecodeManager.incBytecodes(2);
            final Set<Entry<K, V>> entrySet = this.entrySet();
            BytecodeManager.incBytecodes(1);
            final Iterator<Entry<K, V>> iterator = entrySet.iterator();
            BytecodeManager.incBytecodes(1);
            Object o2 = null;
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            if (o == null) {
                while (true) {
                    final Object o3 = o2;
                    BytecodeManager.incBytecodes(2);
                    if (o3 != null) {
                        break;
                    }
                    final Iterator<Entry<K, V>> iterator2 = iterator;
                    BytecodeManager.incBytecodes(2);
                    final boolean hasNext = iterator2.hasNext();
                    BytecodeManager.incBytecodes(1);
                    if (!hasNext) {
                        break;
                    }
                    final Iterator<Entry<K, V>> iterator3 = iterator;
                    BytecodeManager.incBytecodes(2);
                    final Entry<K, V> entry = iterator3.next();
                    BytecodeManager.incBytecodes(2);
                    final Entry<K, Object> entry2 = (Entry<K, Object>)entry;
                    BytecodeManager.incBytecodes(2);
                    final K key = entry2.getKey();
                    BytecodeManager.incBytecodes(1);
                    if (key == null) {
                        o2 = entry;
                        BytecodeManager.incBytecodes(2);
                    }
                    BytecodeManager.incBytecodes(1);
                }
            }
            else {
                while (true) {
                    final Object o4 = o2;
                    BytecodeManager.incBytecodes(2);
                    if (o4 != null) {
                        break;
                    }
                    final Iterator<Entry<K, V>> iterator4 = iterator;
                    BytecodeManager.incBytecodes(2);
                    final boolean hasNext2 = iterator4.hasNext();
                    BytecodeManager.incBytecodes(1);
                    if (!hasNext2) {
                        break;
                    }
                    final Iterator<Entry<K, V>> iterator5 = iterator;
                    BytecodeManager.incBytecodes(2);
                    final Entry<K, V> entry3 = iterator5.next();
                    BytecodeManager.incBytecodes(2);
                    final Entry<K, V> entry4 = entry3;
                    BytecodeManager.incBytecodes(3);
                    final K key2 = entry4.getKey();
                    BytecodeManager.incBytecodes(1);
                    final boolean equals = o.equals(key2);
                    BytecodeManager.incBytecodes(1);
                    if (equals) {
                        o2 = entry3;
                        BytecodeManager.incBytecodes(2);
                    }
                    BytecodeManager.incBytecodes(1);
                }
            }
            Object value = null;
            BytecodeManager.incBytecodes(2);
            final Object o5 = o2;
            BytecodeManager.incBytecodes(2);
            if (o5 != null) {
                final Entry<K, Object> entry5 = (Entry<K, Object>)o2;
                BytecodeManager.incBytecodes(2);
                value = entry5.getValue();
                BytecodeManager.incBytecodes(1);
                final Iterator<Entry<K, V>> iterator6 = iterator;
                BytecodeManager.incBytecodes(2);
                iterator6.remove();
            }
            final Object o6 = value;
            BytecodeManager.incBytecodes(2);
            return (V)o6;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void putAll(final Map<? extends K, ? extends V> map) {
        try {
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
    public void clear() {
        try {
            BytecodeManager.incBytecodes(2);
            final Set<Entry<K, V>> entrySet = this.entrySet();
            BytecodeManager.incBytecodes(1);
            entrySet.clear();
            BytecodeManager.incBytecodes(1);
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
                BytecodeManager.incBytecodes(5);
                this.keySet = new AbstractSet<K>() {
                    {
                        BytecodeManager.incBytecodes(1);
                    }
                    
                    @Override
                    public Iterator<K> iterator() {
                        try {
                            BytecodeManager.incBytecodes(4);
                            final Iterator<K> iterator = new Iterator<K>() {
                                private Iterator<Entry<K, V>> i;
                                
                                {
                                    final AbstractMap this$2 = AbstractMap.this;
                                    BytecodeManager.incBytecodes(5);
                                    final Set<Entry<K, V>> entrySet = this$2.entrySet();
                                    BytecodeManager.incBytecodes(1);
                                    this.i = entrySet.iterator();
                                    BytecodeManager.incBytecodes(2);
                                }
                                
                                @Override
                                public boolean hasNext() {
                                    try {
                                        final Iterator<Entry<K, V>> i = this.i;
                                        BytecodeManager.incBytecodes(3);
                                        final boolean hasNext = i.hasNext();
                                        BytecodeManager.incBytecodes(1);
                                        return hasNext;
                                    }
                                    finally {
                                        throw loadexception(java.lang.Throwable.class);
                                    }
                                }
                                
                                @Override
                                public K next() {
                                    try {
                                        final Iterator<Entry<K, V>> i = this.i;
                                        BytecodeManager.incBytecodes(3);
                                        final Entry<K, V> entry = i.next();
                                        BytecodeManager.incBytecodes(2);
                                        final K key = entry.getKey();
                                        BytecodeManager.incBytecodes(1);
                                        return key;
                                    }
                                    finally {
                                        throw loadexception(java.lang.Throwable.class);
                                    }
                                }
                                
                                @Override
                                public void remove() {
                                    try {
                                        final Iterator<Entry<K, V>> i = this.i;
                                        BytecodeManager.incBytecodes(3);
                                        i.remove();
                                        BytecodeManager.incBytecodes(1);
                                    }
                                    finally {
                                        throw loadexception(java.lang.Throwable.class);
                                    }
                                }
                            };
                            BytecodeManager.incBytecodes(1);
                            return iterator;
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                    
                    @Override
                    public int size() {
                        try {
                            final AbstractMap this$0 = AbstractMap.this;
                            BytecodeManager.incBytecodes(3);
                            final int size = this$0.size();
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
                            final AbstractMap this$0 = AbstractMap.this;
                            BytecodeManager.incBytecodes(3);
                            final boolean empty = this$0.isEmpty();
                            BytecodeManager.incBytecodes(1);
                            return empty;
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                    
                    @Override
                    public void clear() {
                        try {
                            final AbstractMap this$0 = AbstractMap.this;
                            BytecodeManager.incBytecodes(3);
                            this$0.clear();
                            BytecodeManager.incBytecodes(1);
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                    
                    @Override
                    public boolean contains(final Object o) {
                        try {
                            final AbstractMap this$0 = AbstractMap.this;
                            BytecodeManager.incBytecodes(4);
                            final boolean containsKey = this$0.containsKey(o);
                            BytecodeManager.incBytecodes(1);
                            return containsKey;
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                };
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
    public Collection<V> values() {
        try {
            final Collection<V> values = this.values;
            BytecodeManager.incBytecodes(3);
            if (values == null) {
                BytecodeManager.incBytecodes(5);
                this.values = new AbstractCollection<V>() {
                    {
                        BytecodeManager.incBytecodes(1);
                    }
                    
                    @Override
                    public Iterator<V> iterator() {
                        try {
                            BytecodeManager.incBytecodes(4);
                            final Iterator<V> iterator = new Iterator<V>() {
                                private Iterator<Entry<K, V>> i;
                                
                                {
                                    final AbstractMap this$2 = AbstractMap.this;
                                    BytecodeManager.incBytecodes(5);
                                    final Set<Entry<K, V>> entrySet = this$2.entrySet();
                                    BytecodeManager.incBytecodes(1);
                                    this.i = entrySet.iterator();
                                    BytecodeManager.incBytecodes(2);
                                }
                                
                                @Override
                                public boolean hasNext() {
                                    try {
                                        final Iterator<Entry<K, V>> i = this.i;
                                        BytecodeManager.incBytecodes(3);
                                        final boolean hasNext = i.hasNext();
                                        BytecodeManager.incBytecodes(1);
                                        return hasNext;
                                    }
                                    finally {
                                        throw loadexception(java.lang.Throwable.class);
                                    }
                                }
                                
                                @Override
                                public V next() {
                                    try {
                                        final Iterator<Entry<K, V>> i = this.i;
                                        BytecodeManager.incBytecodes(3);
                                        final Entry<K, V> entry = i.next();
                                        BytecodeManager.incBytecodes(2);
                                        final V value = entry.getValue();
                                        BytecodeManager.incBytecodes(1);
                                        return value;
                                    }
                                    finally {
                                        throw loadexception(java.lang.Throwable.class);
                                    }
                                }
                                
                                @Override
                                public void remove() {
                                    try {
                                        final Iterator<Entry<K, V>> i = this.i;
                                        BytecodeManager.incBytecodes(3);
                                        i.remove();
                                        BytecodeManager.incBytecodes(1);
                                    }
                                    finally {
                                        throw loadexception(java.lang.Throwable.class);
                                    }
                                }
                            };
                            BytecodeManager.incBytecodes(1);
                            return iterator;
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                    
                    @Override
                    public int size() {
                        try {
                            final AbstractMap this$0 = AbstractMap.this;
                            BytecodeManager.incBytecodes(3);
                            final int size = this$0.size();
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
                            final AbstractMap this$0 = AbstractMap.this;
                            BytecodeManager.incBytecodes(3);
                            final boolean empty = this$0.isEmpty();
                            BytecodeManager.incBytecodes(1);
                            return empty;
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                    
                    @Override
                    public void clear() {
                        try {
                            final AbstractMap this$0 = AbstractMap.this;
                            BytecodeManager.incBytecodes(3);
                            this$0.clear();
                            BytecodeManager.incBytecodes(1);
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                    
                    @Override
                    public boolean contains(final Object o) {
                        try {
                            final AbstractMap this$0 = AbstractMap.this;
                            BytecodeManager.incBytecodes(4);
                            final boolean containsValue = this$0.containsValue(o);
                            BytecodeManager.incBytecodes(1);
                            return containsValue;
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                };
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
    public abstract Set<Entry<K, V>> entrySet();
    
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
        //    46: aload_2        
        //    47: ldc             2
        //    49: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    52: invokeinterface instrumented/java/util/Map.size:()I
        //    57: aload_0        
        //    58: ldc             2
        //    60: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    63: invokevirtual   instrumented/java/util/AbstractMap.size:()I
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
        //    87: invokevirtual   instrumented/java/util/AbstractMap.entrySet:()Linstrumented/java/util/Set;
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
        //    StackMapTable: 00 0D 11 12 FC 00 2C 07 00 07 FC 00 18 07 00 3E FE 00 81 07 00 14 07 00 05 07 00 05 0B F8 00 2A FA 00 07 47 07 00 70 4C 07 00 72 0C FF 00 06 00 00 00 01 07 00 29 FF 00 00 00 00 00 01 07 00 6E
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
    public int hashCode() {
        try {
            int n = 0;
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            final Set<Entry<K, V>> entrySet = this.entrySet();
            BytecodeManager.incBytecodes(1);
            final Iterator<Entry<K, V>> iterator = entrySet.iterator();
            BytecodeManager.incBytecodes(1);
            while (true) {
                final Iterator<Entry<K, V>> iterator2 = iterator;
                BytecodeManager.incBytecodes(2);
                final boolean hasNext = iterator2.hasNext();
                BytecodeManager.incBytecodes(1);
                if (!hasNext) {
                    break;
                }
                final int n2 = n;
                final Iterator<Entry<K, V>> iterator3 = iterator;
                BytecodeManager.incBytecodes(3);
                final Entry<K, V> entry = iterator3.next();
                BytecodeManager.incBytecodes(2);
                n = n2 + entry.hashCode();
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
    public String toString() {
        try {
            BytecodeManager.incBytecodes(2);
            final Set<Entry<K, V>> entrySet = this.entrySet();
            BytecodeManager.incBytecodes(1);
            final Iterator<Entry<K, V>> iterator = entrySet.iterator();
            BytecodeManager.incBytecodes(1);
            final Iterator<Entry<K, V>> iterator2 = iterator;
            BytecodeManager.incBytecodes(2);
            final boolean hasNext = iterator2.hasNext();
            BytecodeManager.incBytecodes(1);
            if (!hasNext) {
                final String s = "{}";
                BytecodeManager.incBytecodes(2);
                return s;
            }
            BytecodeManager.incBytecodes(3);
            final StringBuilder sb = new StringBuilder();
            BytecodeManager.incBytecodes(1);
            final StringBuilder sb2 = sb;
            final char c = '{';
            BytecodeManager.incBytecodes(3);
            sb2.append(c);
            BytecodeManager.incBytecodes(1);
            while (true) {
                final Iterator<Entry<K, V>> iterator3 = iterator;
                BytecodeManager.incBytecodes(2);
                final Entry<K, V> entry = iterator3.next();
                BytecodeManager.incBytecodes(2);
                final Entry<K, V> entry2 = entry;
                BytecodeManager.incBytecodes(2);
                final K key = entry2.getKey();
                BytecodeManager.incBytecodes(1);
                final Entry<K, V> entry3 = entry;
                BytecodeManager.incBytecodes(2);
                final V value = entry3.getValue();
                BytecodeManager.incBytecodes(1);
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
                final V v = value;
                BytecodeManager.incBytecodes(4);
                Object obj2;
                if (v == this) {
                    obj2 = "(this Map)";
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    obj2 = value;
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
                sb5.append(obj2);
                BytecodeManager.incBytecodes(1);
                final Iterator<Entry<K, V>> iterator4 = iterator;
                BytecodeManager.incBytecodes(2);
                final boolean hasNext2 = iterator4.hasNext();
                BytecodeManager.incBytecodes(1);
                if (!hasNext2) {
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
    protected Object clone() throws CloneNotSupportedException {
        try {
            BytecodeManager.incBytecodes(2);
            final AbstractMap abstractMap = (AbstractMap)super.clone();
            BytecodeManager.incBytecodes(2);
            abstractMap.keySet = null;
            BytecodeManager.incBytecodes(3);
            abstractMap.values = null;
            BytecodeManager.incBytecodes(3);
            final AbstractMap abstractMap2 = abstractMap;
            BytecodeManager.incBytecodes(2);
            return abstractMap2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static boolean eq(final Object o, final Object obj) {
        try {
            BytecodeManager.incBytecodes(2);
            boolean equals;
            if (o == null) {
                BytecodeManager.incBytecodes(2);
                if (obj == null) {
                    equals = true;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    equals = false;
                    BytecodeManager.incBytecodes(2);
                }
            }
            else {
                BytecodeManager.incBytecodes(3);
                equals = o.equals(obj);
            }
            BytecodeManager.incBytecodes(1);
            return equals;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static /* synthetic */ boolean access$000(final Object o, final Object o2) {
        try {
            BytecodeManager.incBytecodes(3);
            final boolean eq = eq(o, o2);
            BytecodeManager.incBytecodes(1);
            return eq;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static class SimpleEntry<K, V> implements Entry<K, V>, Serializable
    {
        private static final long serialVersionUID = -8499721149061103585L;
        private final K key;
        private V value;
        
        public SimpleEntry(final K key, final V value) {
            try {
                BytecodeManager.incBytecodes(2);
                this.key = key;
                BytecodeManager.incBytecodes(3);
                this.value = value;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public SimpleEntry(final Entry<? extends K, ? extends V> entry) {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(3);
                this.key = (K)entry.getKey();
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(3);
                this.value = (V)entry.getValue();
                BytecodeManager.incBytecodes(1);
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
                final boolean b = o instanceof Entry;
                BytecodeManager.incBytecodes(3);
                if (!b) {
                    final boolean b2 = false;
                    BytecodeManager.incBytecodes(2);
                    return b2;
                }
                final Entry entry = (Entry)o;
                BytecodeManager.incBytecodes(3);
                final K key = this.key;
                final Entry entry2 = entry;
                BytecodeManager.incBytecodes(4);
                final Object key2 = entry2.getKey();
                BytecodeManager.incBytecodes(1);
                final boolean access$000 = AbstractMap.access$000(key, key2);
                BytecodeManager.incBytecodes(1);
                boolean b3 = false;
                Label_0106: {
                    if (access$000) {
                        final V value = this.value;
                        final Entry entry3 = entry;
                        BytecodeManager.incBytecodes(4);
                        final Object value2 = entry3.getValue();
                        BytecodeManager.incBytecodes(1);
                        final boolean access$2 = AbstractMap.access$000(value, value2);
                        BytecodeManager.incBytecodes(1);
                        if (access$2) {
                            b3 = true;
                            BytecodeManager.incBytecodes(2);
                            break Label_0106;
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
                final K key = this.key;
                BytecodeManager.incBytecodes(3);
                int hashCode;
                if (key == null) {
                    hashCode = 0;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final K key2 = this.key;
                    BytecodeManager.incBytecodes(3);
                    hashCode = key2.hashCode();
                }
                final V value = this.value;
                BytecodeManager.incBytecodes(3);
                int hashCode2;
                if (value == null) {
                    hashCode2 = 0;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final V value2 = this.value;
                    BytecodeManager.incBytecodes(2);
                    BytecodeManager.incBytecodes(1);
                    hashCode2 = value2.hashCode();
                }
                final int n = hashCode ^ hashCode2;
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
    }
    
    public static class SimpleImmutableEntry<K, V> implements Entry<K, V>, Serializable
    {
        private static final long serialVersionUID = 7138329143949025153L;
        private final K key;
        private final V value;
        
        public SimpleImmutableEntry(final K key, final V value) {
            try {
                BytecodeManager.incBytecodes(2);
                this.key = key;
                BytecodeManager.incBytecodes(3);
                this.value = value;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public SimpleImmutableEntry(final Entry<? extends K, ? extends V> entry) {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(3);
                this.key = (K)entry.getKey();
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(3);
                this.value = (V)entry.getValue();
                BytecodeManager.incBytecodes(1);
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
                final V value = this.value;
                BytecodeManager.incBytecodes(3);
                return value;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public V setValue(final V v) {
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
        public boolean equals(final Object o) {
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
                final K key = this.key;
                final Entry entry2 = entry;
                BytecodeManager.incBytecodes(4);
                final Object key2 = entry2.getKey();
                BytecodeManager.incBytecodes(1);
                final boolean access$000 = AbstractMap.access$000(key, key2);
                BytecodeManager.incBytecodes(1);
                boolean b3 = false;
                Label_0106: {
                    if (access$000) {
                        final V value = this.value;
                        final Entry entry3 = entry;
                        BytecodeManager.incBytecodes(4);
                        final Object value2 = entry3.getValue();
                        BytecodeManager.incBytecodes(1);
                        final boolean access$2 = AbstractMap.access$000(value, value2);
                        BytecodeManager.incBytecodes(1);
                        if (access$2) {
                            b3 = true;
                            BytecodeManager.incBytecodes(2);
                            break Label_0106;
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
                final K key = this.key;
                BytecodeManager.incBytecodes(3);
                int hashCode;
                if (key == null) {
                    hashCode = 0;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final K key2 = this.key;
                    BytecodeManager.incBytecodes(3);
                    hashCode = key2.hashCode();
                }
                final V value = this.value;
                BytecodeManager.incBytecodes(3);
                int hashCode2;
                if (value == null) {
                    hashCode2 = 0;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final V value2 = this.value;
                    BytecodeManager.incBytecodes(2);
                    BytecodeManager.incBytecodes(1);
                    hashCode2 = value2.hashCode();
                }
                final int n = hashCode ^ hashCode2;
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
    }
}
