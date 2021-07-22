// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import java.lang.reflect.Array;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import sun.misc.JavaLangAccess;
import sun.misc.SharedSecrets;
import java.util.Iterator;
import aic2021.engine.BytecodeManager;
import java.io.Serializable;

public class EnumMap<K extends Enum<K>, V> extends AbstractMap<K, V> implements Serializable, Cloneable
{
    private final Class<K> keyType;
    private transient K[] keyUniverse;
    private transient Object[] vals;
    private transient int size;
    private static final Object NULL;
    private static final Enum<?>[] ZERO_LENGTH_ENUM_ARRAY;
    private transient Set<Map.Entry<K, V>> entrySet;
    private static final long serialVersionUID = 458661240069192865L;
    
    private Object maskNull(final Object o) {
        try {
            BytecodeManager.incBytecodes(2);
            Object null;
            if (o == null) {
                null = EnumMap.NULL;
                BytecodeManager.incBytecodes(2);
            }
            else {
                null = o;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return null;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private V unmaskNull(final Object o) {
        try {
            final Object null = EnumMap.NULL;
            BytecodeManager.incBytecodes(3);
            Object o2;
            if (o == null) {
                o2 = null;
                BytecodeManager.incBytecodes(2);
            }
            else {
                o2 = o;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return (V)o2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public EnumMap(final Class<K> keyType) {
        try {
            BytecodeManager.incBytecodes(2);
            this.size = 0;
            BytecodeManager.incBytecodes(3);
            this.keyType = keyType;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(3);
            this.keyUniverse = getKeyUniverse(keyType);
            BytecodeManager.incBytecodes(1);
            this.vals = new Object[this.keyUniverse.length];
            BytecodeManager.incBytecodes(5);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public EnumMap(final EnumMap<K, ? extends V> enumMap) {
        try {
            BytecodeManager.incBytecodes(2);
            this.size = 0;
            BytecodeManager.incBytecodes(3);
            this.keyType = enumMap.keyType;
            BytecodeManager.incBytecodes(4);
            this.keyUniverse = enumMap.keyUniverse;
            BytecodeManager.incBytecodes(4);
            final Object[] vals = enumMap.vals;
            BytecodeManager.incBytecodes(4);
            this.vals = vals.clone();
            BytecodeManager.incBytecodes(2);
            this.size = enumMap.size;
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public EnumMap(final Map<K, ? extends V> map) {
        try {
            BytecodeManager.incBytecodes(2);
            this.size = 0;
            BytecodeManager.incBytecodes(3);
            final boolean b = map instanceof EnumMap;
            BytecodeManager.incBytecodes(3);
            if (b) {
                final EnumMap<Enum<Enum<K>>, Object> enumMap = (EnumMap<Enum<Enum<K>>, Object>)map;
                BytecodeManager.incBytecodes(3);
                this.keyType = (Class<K>)enumMap.keyType;
                BytecodeManager.incBytecodes(4);
                this.keyUniverse = (K[])enumMap.keyUniverse;
                BytecodeManager.incBytecodes(4);
                final Object[] vals = enumMap.vals;
                BytecodeManager.incBytecodes(4);
                this.vals = vals.clone();
                BytecodeManager.incBytecodes(2);
                this.size = enumMap.size;
                BytecodeManager.incBytecodes(4);
                BytecodeManager.incBytecodes(1);
            }
            else {
                BytecodeManager.incBytecodes(2);
                final boolean empty = map.isEmpty();
                BytecodeManager.incBytecodes(1);
                if (empty) {
                    final String s = "Specified map is empty";
                    BytecodeManager.incBytecodes(4);
                    final IllegalArgumentException ex = new IllegalArgumentException(s);
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                BytecodeManager.incBytecodes(3);
                final Set<Enum<K>> keySet = map.keySet();
                BytecodeManager.incBytecodes(1);
                final Iterator<Enum<K>> iterator = keySet.iterator();
                BytecodeManager.incBytecodes(1);
                final Enum<K> enum1 = iterator.next();
                BytecodeManager.incBytecodes(2);
                this.keyType = enum1.getDeclaringClass();
                BytecodeManager.incBytecodes(1);
                final Class<K> keyType = this.keyType;
                BytecodeManager.incBytecodes(4);
                this.keyUniverse = getKeyUniverse(keyType);
                BytecodeManager.incBytecodes(1);
                this.vals = new Object[this.keyUniverse.length];
                BytecodeManager.incBytecodes(5);
                BytecodeManager.incBytecodes(3);
                this.putAll((Map<? extends K, ? extends V>)map);
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
    public boolean containsValue(Object maskNull) {
        try {
            final Object o = maskNull;
            BytecodeManager.incBytecodes(3);
            maskNull = this.maskNull(o);
            BytecodeManager.incBytecodes(1);
            final Object[] vals = this.vals;
            final int length = vals.length;
            int n = 0;
            BytecodeManager.incBytecodes(8);
            while (true) {
                final int n2 = n;
                final int n3 = length;
                BytecodeManager.incBytecodes(3);
                if (n2 >= n3) {
                    final boolean b = false;
                    BytecodeManager.incBytecodes(2);
                    return b;
                }
                final Object o2 = vals[n];
                BytecodeManager.incBytecodes(4);
                final Object o3 = maskNull;
                final Object obj = o2;
                BytecodeManager.incBytecodes(3);
                final boolean equals = o3.equals(obj);
                BytecodeManager.incBytecodes(1);
                if (equals) {
                    final boolean b2 = true;
                    BytecodeManager.incBytecodes(2);
                    return b2;
                }
                ++n;
                BytecodeManager.incBytecodes(2);
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
            final boolean validKey = this.isValidKey(o);
            BytecodeManager.incBytecodes(1);
            boolean b = false;
            Label_0058: {
                if (validKey) {
                    final Object[] vals = this.vals;
                    final Enum enum1 = (Enum)o;
                    BytecodeManager.incBytecodes(5);
                    final Object o2 = vals[enum1.ordinal()];
                    BytecodeManager.incBytecodes(2);
                    if (o2 != null) {
                        b = true;
                        BytecodeManager.incBytecodes(2);
                        break Label_0058;
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
    
    private boolean containsMapping(final Object o, final Object o2) {
        try {
            BytecodeManager.incBytecodes(3);
            final boolean validKey = this.isValidKey(o);
            BytecodeManager.incBytecodes(1);
            boolean b = false;
            Label_0081: {
                if (validKey) {
                    BytecodeManager.incBytecodes(2);
                    BytecodeManager.incBytecodes(1);
                    final Object maskNull = this.maskNull(o2);
                    final Object[] vals = this.vals;
                    final Enum enum1 = (Enum)o;
                    BytecodeManager.incBytecodes(5);
                    final Object obj = vals[enum1.ordinal()];
                    BytecodeManager.incBytecodes(2);
                    final boolean equals = maskNull.equals(obj);
                    BytecodeManager.incBytecodes(1);
                    if (equals) {
                        b = true;
                        BytecodeManager.incBytecodes(2);
                        break Label_0081;
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
            BytecodeManager.incBytecodes(3);
            final boolean validKey = this.isValidKey(o);
            BytecodeManager.incBytecodes(1);
            V unmaskNull;
            if (validKey) {
                final Object[] vals = this.vals;
                final Enum enum1 = (Enum)o;
                BytecodeManager.incBytecodes(5);
                BytecodeManager.incBytecodes(1);
                final Object o2 = vals[enum1.ordinal()];
                BytecodeManager.incBytecodes(2);
                unmaskNull = this.unmaskNull(o2);
                BytecodeManager.incBytecodes(1);
            }
            else {
                unmaskNull = null;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return unmaskNull;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public V put(final K k, final V v) {
        try {
            BytecodeManager.incBytecodes(3);
            this.typeCheck(k);
            BytecodeManager.incBytecodes(2);
            final int ordinal = k.ordinal();
            BytecodeManager.incBytecodes(1);
            final Object o = this.vals[ordinal];
            BytecodeManager.incBytecodes(5);
            final Object[] vals = this.vals;
            final int n = ordinal;
            BytecodeManager.incBytecodes(6);
            vals[n] = this.maskNull(v);
            BytecodeManager.incBytecodes(1);
            final Object o2 = o;
            BytecodeManager.incBytecodes(2);
            if (o2 == null) {
                ++this.size;
                BytecodeManager.incBytecodes(6);
            }
            final Object o3 = o;
            BytecodeManager.incBytecodes(3);
            final V unmaskNull = this.unmaskNull(o3);
            BytecodeManager.incBytecodes(1);
            return unmaskNull;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public V remove(final Object o) {
        try {
            BytecodeManager.incBytecodes(3);
            final boolean validKey = this.isValidKey(o);
            BytecodeManager.incBytecodes(1);
            if (!validKey) {
                final V v = null;
                BytecodeManager.incBytecodes(2);
                return v;
            }
            final Enum enum1 = (Enum)o;
            BytecodeManager.incBytecodes(3);
            final int ordinal = enum1.ordinal();
            BytecodeManager.incBytecodes(1);
            final Object o2 = this.vals[ordinal];
            BytecodeManager.incBytecodes(5);
            this.vals[ordinal] = null;
            BytecodeManager.incBytecodes(5);
            final Object o3 = o2;
            BytecodeManager.incBytecodes(2);
            if (o3 != null) {
                --this.size;
                BytecodeManager.incBytecodes(6);
            }
            final Object o4 = o2;
            BytecodeManager.incBytecodes(3);
            final V unmaskNull = this.unmaskNull(o4);
            BytecodeManager.incBytecodes(1);
            return unmaskNull;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private boolean removeMapping(final Object o, final Object o2) {
        try {
            BytecodeManager.incBytecodes(3);
            final boolean validKey = this.isValidKey(o);
            BytecodeManager.incBytecodes(1);
            if (!validKey) {
                final boolean b = false;
                BytecodeManager.incBytecodes(2);
                return b;
            }
            final Enum enum1 = (Enum)o;
            BytecodeManager.incBytecodes(3);
            final int ordinal = enum1.ordinal();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            final Object maskNull = this.maskNull(o2);
            final Object obj = this.vals[ordinal];
            BytecodeManager.incBytecodes(5);
            final boolean equals = maskNull.equals(obj);
            BytecodeManager.incBytecodes(1);
            if (equals) {
                this.vals[ordinal] = null;
                BytecodeManager.incBytecodes(5);
                --this.size;
                BytecodeManager.incBytecodes(6);
                final boolean b2 = true;
                BytecodeManager.incBytecodes(2);
                return b2;
            }
            final boolean b3 = false;
            BytecodeManager.incBytecodes(2);
            return b3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private boolean isValidKey(final Object o) {
        try {
            BytecodeManager.incBytecodes(2);
            if (o == null) {
                final boolean b = false;
                BytecodeManager.incBytecodes(2);
                return b;
            }
            BytecodeManager.incBytecodes(2);
            final Class<?> class1 = o.getClass();
            BytecodeManager.incBytecodes(1);
            final Class<?> clazz = class1;
            final Class<K> keyType = this.keyType;
            BytecodeManager.incBytecodes(4);
            boolean b2 = false;
            Label_0080: {
                if (clazz != keyType) {
                    final Class<K> clazz2 = (Class<K>)class1;
                    BytecodeManager.incBytecodes(2);
                    final Class<? super K> superclass = clazz2.getSuperclass();
                    final Class<K> keyType2 = this.keyType;
                    BytecodeManager.incBytecodes(3);
                    if (superclass != keyType2) {
                        b2 = false;
                        BytecodeManager.incBytecodes(1);
                        break Label_0080;
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
    
    @Override
    public void putAll(final Map<? extends K, ? extends V> map) {
        try {
            final boolean b = map instanceof EnumMap;
            BytecodeManager.incBytecodes(3);
            if (b) {
                final EnumMap<? extends K, ? extends V> enumMap = (EnumMap<? extends K, ? extends V>)map;
                BytecodeManager.incBytecodes(3);
                final Class<? extends K> keyType = enumMap.keyType;
                final Class<K> keyType2 = this.keyType;
                BytecodeManager.incBytecodes(5);
                if (keyType != keyType2) {
                    final EnumMap<? extends K, ? extends V> enumMap2 = enumMap;
                    BytecodeManager.incBytecodes(2);
                    final boolean empty = enumMap2.isEmpty();
                    BytecodeManager.incBytecodes(1);
                    if (empty) {
                        BytecodeManager.incBytecodes(1);
                        return;
                    }
                    BytecodeManager.incBytecodes(5);
                    final StringBuilder sb = new StringBuilder();
                    final Class<? extends K> keyType3 = enumMap.keyType;
                    BytecodeManager.incBytecodes(3);
                    final StringBuilder append = sb.append(keyType3);
                    final String str = " != ";
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append2 = append.append(str);
                    final Class<K> keyType4 = this.keyType;
                    BytecodeManager.incBytecodes(3);
                    final StringBuilder append3 = append2.append(keyType4);
                    BytecodeManager.incBytecodes(1);
                    final String string = append3.toString();
                    BytecodeManager.incBytecodes(1);
                    final ClassCastException ex = new ClassCastException(string);
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                else {
                    int n = 0;
                    BytecodeManager.incBytecodes(2);
                    while (true) {
                        final int n2 = n;
                        final int length = this.keyUniverse.length;
                        BytecodeManager.incBytecodes(5);
                        if (n2 >= length) {
                            break;
                        }
                        final Object o = enumMap.vals[n];
                        BytecodeManager.incBytecodes(5);
                        final Object o2 = o;
                        BytecodeManager.incBytecodes(2);
                        if (o2 != null) {
                            final Object o3 = this.vals[n];
                            BytecodeManager.incBytecodes(5);
                            if (o3 == null) {
                                ++this.size;
                                BytecodeManager.incBytecodes(6);
                            }
                            this.vals[n] = o;
                            BytecodeManager.incBytecodes(5);
                        }
                        ++n;
                        BytecodeManager.incBytecodes(2);
                    }
                    BytecodeManager.incBytecodes(1);
                }
            }
            else {
                BytecodeManager.incBytecodes(3);
                super.putAll(map);
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
            final Object[] vals = this.vals;
            final Object o = null;
            BytecodeManager.incBytecodes(4);
            Arrays.fill(vals, o);
            this.size = 0;
            BytecodeManager.incBytecodes(3);
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
    public Set<Map.Entry<K, V>> entrySet() {
        try {
            final Set<Map.Entry<K, V>> entrySet = this.entrySet;
            BytecodeManager.incBytecodes(3);
            final Set<Map.Entry<K, V>> set = entrySet;
            BytecodeManager.incBytecodes(2);
            if (set != null) {
                final Set<Map.Entry<K, V>> set2 = entrySet;
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
    
    @Override
    public boolean equals(final Object o) {
        try {
            BytecodeManager.incBytecodes(3);
            if (this == o) {
                final boolean b = true;
                BytecodeManager.incBytecodes(2);
                return b;
            }
            final boolean b2 = o instanceof EnumMap;
            BytecodeManager.incBytecodes(3);
            if (b2) {
                final EnumMap enumMap = (EnumMap)o;
                BytecodeManager.incBytecodes(4);
                final boolean equals = this.equals(enumMap);
                BytecodeManager.incBytecodes(1);
                return equals;
            }
            final boolean b3 = o instanceof Map;
            BytecodeManager.incBytecodes(3);
            if (!b3) {
                final boolean b4 = false;
                BytecodeManager.incBytecodes(2);
                return b4;
            }
            final Map map = (Map)o;
            BytecodeManager.incBytecodes(3);
            final int size = this.size;
            final Map map2 = map;
            BytecodeManager.incBytecodes(4);
            final int size2 = map2.size();
            BytecodeManager.incBytecodes(1);
            if (size != size2) {
                final boolean b5 = false;
                BytecodeManager.incBytecodes(2);
                return b5;
            }
            int n = 0;
            BytecodeManager.incBytecodes(2);
            Label_0288: {
                Block_10: {
                    while (true) {
                        final int n2 = n;
                        final int length = this.keyUniverse.length;
                        BytecodeManager.incBytecodes(5);
                        if (n2 >= length) {
                            break Label_0288;
                        }
                        final Object o2 = null;
                        final Object o3 = this.vals[n];
                        BytecodeManager.incBytecodes(6);
                        if (o2 != o3) {
                            final Enum<K> enum1 = this.keyUniverse[n];
                            BytecodeManager.incBytecodes(5);
                            final Object o4 = this.vals[n];
                            BytecodeManager.incBytecodes(6);
                            final V unmaskNull = this.unmaskNull(o4);
                            BytecodeManager.incBytecodes(1);
                            final V v = null;
                            final V v2 = unmaskNull;
                            BytecodeManager.incBytecodes(3);
                            if (v == v2) {
                                final Object o5 = null;
                                final Map<K, Object> map3 = (Map<K, Object>)map;
                                final Enum<K> enum2 = enum1;
                                BytecodeManager.incBytecodes(4);
                                final Object value = map3.get(enum2);
                                BytecodeManager.incBytecodes(1);
                                if (o5 != value) {
                                    break;
                                }
                                final Map<K, Object> map4 = (Map<K, Object>)map;
                                final Enum<K> enum3 = enum1;
                                BytecodeManager.incBytecodes(3);
                                final boolean containsKey = map4.containsKey(enum3);
                                BytecodeManager.incBytecodes(1);
                                if (!containsKey) {
                                    break;
                                }
                            }
                            else {
                                final V v3 = unmaskNull;
                                final Map<K, Object> map5 = (Map<K, Object>)map;
                                final Enum<K> enum4 = enum1;
                                BytecodeManager.incBytecodes(4);
                                final Object value2 = map5.get(enum4);
                                BytecodeManager.incBytecodes(1);
                                final boolean equals2 = v3.equals(value2);
                                BytecodeManager.incBytecodes(1);
                                if (!equals2) {
                                    break Block_10;
                                }
                            }
                        }
                        ++n;
                        BytecodeManager.incBytecodes(2);
                    }
                    final boolean b6 = false;
                    BytecodeManager.incBytecodes(2);
                    return b6;
                }
                final boolean b7 = false;
                BytecodeManager.incBytecodes(2);
                return b7;
            }
            final boolean b8 = true;
            BytecodeManager.incBytecodes(2);
            return b8;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private boolean equals(final EnumMap<?, ?> enumMap) {
        try {
            final Class<?> keyType = enumMap.keyType;
            final Class<K> keyType2 = this.keyType;
            BytecodeManager.incBytecodes(5);
            if (keyType != keyType2) {
                final int size = this.size;
                BytecodeManager.incBytecodes(3);
                boolean b = false;
                Label_0055: {
                    if (size == 0) {
                        final int size2 = enumMap.size;
                        BytecodeManager.incBytecodes(3);
                        if (size2 == 0) {
                            b = true;
                            BytecodeManager.incBytecodes(2);
                            break Label_0055;
                        }
                    }
                    b = false;
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
                return b;
            }
            int n = 0;
            BytecodeManager.incBytecodes(2);
            Label_0170: {
                while (true) {
                    final int n2 = n;
                    final int length = this.keyUniverse.length;
                    BytecodeManager.incBytecodes(5);
                    if (n2 >= length) {
                        break Label_0170;
                    }
                    final Object o = this.vals[n];
                    BytecodeManager.incBytecodes(5);
                    final Object o2 = enumMap.vals[n];
                    BytecodeManager.incBytecodes(5);
                    final Object o3 = o2;
                    final Object o4 = o;
                    BytecodeManager.incBytecodes(3);
                    if (o3 != o4) {
                        final Object o5 = o2;
                        BytecodeManager.incBytecodes(2);
                        if (o5 == null) {
                            break;
                        }
                        final Object o6 = o2;
                        final Object obj = o;
                        BytecodeManager.incBytecodes(2);
                        BytecodeManager.incBytecodes(1);
                        final boolean equals = o6.equals(obj);
                        BytecodeManager.incBytecodes(1);
                        if (!equals) {
                            break;
                        }
                    }
                    ++n;
                    BytecodeManager.incBytecodes(2);
                }
                final boolean b2 = false;
                BytecodeManager.incBytecodes(2);
                return b2;
            }
            final boolean b3 = true;
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
            int n2 = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n3 = n2;
                final int length = this.keyUniverse.length;
                BytecodeManager.incBytecodes(5);
                if (n3 >= length) {
                    break;
                }
                final Object o = null;
                final Object o2 = this.vals[n2];
                BytecodeManager.incBytecodes(6);
                if (o != o2) {
                    final int n4 = n;
                    final int n5 = n2;
                    BytecodeManager.incBytecodes(4);
                    n = n4 + this.entryHashCode(n5);
                    BytecodeManager.incBytecodes(2);
                }
                ++n2;
                BytecodeManager.incBytecodes(2);
            }
            final int n6 = n;
            BytecodeManager.incBytecodes(2);
            return n6;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private int entryHashCode(final int n) {
        try {
            final Enum<K> enum1 = this.keyUniverse[n];
            BytecodeManager.incBytecodes(5);
            final int hashCode = enum1.hashCode();
            final Object o = this.vals[n];
            BytecodeManager.incBytecodes(5);
            final int n2 = hashCode ^ o.hashCode();
            BytecodeManager.incBytecodes(2);
            return n2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public EnumMap<K, V> clone() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore_1       
        //     2: ldc             2
        //     4: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     7: aload_0        
        //     8: ldc             2
        //    10: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    13: invokespecial   instrumented/java/util/AbstractMap.clone:()Ljava/lang/Object;
        //    16: checkcast       Linstrumented/java/util/EnumMap;
        //    19: astore_1       
        //    20: ldc             2
        //    22: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    25: ldc             1
        //    27: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    30: goto            57
        //    33: astore_2       
        //    34: ldc             501
        //    36: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    39: new             Ljava/lang/AssertionError;
        //    42: dup            
        //    43: ldc             3
        //    45: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    48: invokespecial   java/lang/AssertionError.<init>:()V
        //    51: ldc             1
        //    53: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    56: athrow         
        //    57: aload_1        
        //    58: aload_1        
        //    59: getfield        instrumented/java/util/EnumMap.vals:[Ljava/lang/Object;
        //    62: ldc             4
        //    64: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    67: invokevirtual   [java/lang/Object.clone:()Ljava/lang/Object;
        //    70: checkcast       [Ljava/lang/Object;
        //    73: putfield        instrumented/java/util/EnumMap.vals:[Ljava/lang/Object;
        //    76: ldc             2
        //    78: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    81: aload_1        
        //    82: aconst_null    
        //    83: putfield        instrumented/java/util/EnumMap.entrySet:Linstrumented/java/util/Set;
        //    86: ldc             3
        //    88: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    91: aload_1        
        //    92: ldc             2
        //    94: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    97: areturn        
        //    98: athrow         
        //    99: athrow         
        //    Signature:
        //  ()Linstrumented/java/util/EnumMap<TK;TV;>;
        //    StackMapTable: 00 04 FF 00 21 00 02 07 00 02 07 00 02 00 01 07 00 F2 17 FF 00 28 00 00 00 01 07 00 4B FF 00 00 00 00 00 01 07 00 F0
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                  
        //  -----  -----  -----  -----  --------------------------------------
        //  7      99     99     100    Ljava/lang/VirtualMachineError;
        //  7      25     33     57     Ljava/lang/CloneNotSupportedException;
        //  0      98     98     99     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0057:
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
    
    private void typeCheck(final K k) {
        try {
            BytecodeManager.incBytecodes(2);
            final Class<? extends Enum> class1 = k.getClass();
            BytecodeManager.incBytecodes(1);
            final Class<? extends Enum> clazz = class1;
            final Class<K> keyType = this.keyType;
            BytecodeManager.incBytecodes(4);
            if (clazz != keyType) {
                final Class<K> clazz2 = (Class<K>)class1;
                BytecodeManager.incBytecodes(2);
                final Class<? super K> superclass = clazz2.getSuperclass();
                final Class<K> keyType2 = this.keyType;
                BytecodeManager.incBytecodes(3);
                if (superclass != keyType2) {
                    BytecodeManager.incBytecodes(5);
                    final StringBuilder sb = new StringBuilder();
                    final Class<K> obj = (Class<K>)class1;
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append = sb.append(obj);
                    final String str = " != ";
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append2 = append.append(str);
                    final Class<K> keyType3 = this.keyType;
                    BytecodeManager.incBytecodes(3);
                    final StringBuilder append3 = append2.append(keyType3);
                    BytecodeManager.incBytecodes(1);
                    final String string = append3.toString();
                    BytecodeManager.incBytecodes(1);
                    final ClassCastException ex = new ClassCastException(string);
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static <K extends Enum<K>> K[] getKeyUniverse(final Class<K> clazz) {
        try {
            BytecodeManager.incBytecodes(1);
            final JavaLangAccess javaLangAccess = SharedSecrets.getJavaLangAccess();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
            final Enum[] enumConstantsShared = javaLangAccess.getEnumConstantsShared((Class)clazz);
            BytecodeManager.incBytecodes(1);
            return (K[])enumConstantsShared;
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
            int size2 = this.size;
            BytecodeManager.incBytecodes(3);
            int n = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n2 = size2;
                BytecodeManager.incBytecodes(2);
                if (n2 <= 0) {
                    break;
                }
                final Object o = null;
                final Object o2 = this.vals[n];
                BytecodeManager.incBytecodes(6);
                if (o != o2) {
                    final Enum<K> obj = this.keyUniverse[n];
                    BytecodeManager.incBytecodes(6);
                    objectOutputStream.writeObject(obj);
                    final Object o3 = this.vals[n];
                    BytecodeManager.incBytecodes(7);
                    final V unmaskNull = this.unmaskNull(o3);
                    BytecodeManager.incBytecodes(1);
                    objectOutputStream.writeObject(unmaskNull);
                    --size2;
                    BytecodeManager.incBytecodes(1);
                }
                ++n;
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
            final Class<K> keyType = this.keyType;
            BytecodeManager.incBytecodes(4);
            this.keyUniverse = getKeyUniverse(keyType);
            BytecodeManager.incBytecodes(1);
            this.vals = new Object[this.keyUniverse.length];
            BytecodeManager.incBytecodes(5);
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
                BytecodeManager.incBytecodes(2);
                final Enum enum1 = (Enum)objectInputStream.readObject();
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(2);
                final Object object = objectInputStream.readObject();
                BytecodeManager.incBytecodes(1);
                final Enum enum2 = enum1;
                final Object o = object;
                BytecodeManager.incBytecodes(4);
                this.put((K)enum2, (V)o);
                BytecodeManager.incBytecodes(1);
                ++n;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static /* synthetic */ int access$200(final EnumMap enumMap) {
        try {
            final int size = enumMap.size;
            BytecodeManager.incBytecodes(3);
            return size;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static /* synthetic */ Object access$500(final EnumMap enumMap, final Object o) {
        try {
            BytecodeManager.incBytecodes(3);
            final Object maskNull = enumMap.maskNull(o);
            BytecodeManager.incBytecodes(1);
            return maskNull;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static /* synthetic */ Object[] access$600(final EnumMap enumMap) {
        try {
            final Object[] vals = enumMap.vals;
            BytecodeManager.incBytecodes(3);
            return vals;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static /* synthetic */ int access$210(final EnumMap enumMap) {
        try {
            final int n = enumMap.size--;
            BytecodeManager.incBytecodes(8);
            return n;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static /* synthetic */ boolean access$900(final EnumMap enumMap, final Object o, final Object o2) {
        try {
            BytecodeManager.incBytecodes(4);
            final boolean containsMapping = enumMap.containsMapping(o, o2);
            BytecodeManager.incBytecodes(1);
            return containsMapping;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static /* synthetic */ boolean access$1000(final EnumMap enumMap, final Object o, final Object o2) {
        try {
            BytecodeManager.incBytecodes(4);
            final boolean removeMapping = enumMap.removeMapping(o, o2);
            BytecodeManager.incBytecodes(1);
            return removeMapping;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static /* synthetic */ Enum[] access$1100(final EnumMap enumMap) {
        try {
            final K[] keyUniverse = enumMap.keyUniverse;
            BytecodeManager.incBytecodes(3);
            return keyUniverse;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static /* synthetic */ Object access$1200(final EnumMap enumMap, final Object o) {
        try {
            BytecodeManager.incBytecodes(3);
            final Object unmaskNull = enumMap.unmaskNull(o);
            BytecodeManager.incBytecodes(1);
            return unmaskNull;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static /* synthetic */ int access$1600(final EnumMap enumMap, final int n) {
        try {
            BytecodeManager.incBytecodes(3);
            final int entryHashCode = enumMap.entryHashCode(n);
            BytecodeManager.incBytecodes(1);
            return entryHashCode;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static {
        try {
            BytecodeManager.incBytecodes(3);
            NULL = new Object() {
                {
                    BytecodeManager.incBytecodes(1);
                }
                
                @Override
                public int hashCode() {
                    try {
                        final int n = 0;
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
                        final String s = "java.util.EnumMap.NULL";
                        BytecodeManager.incBytecodes(2);
                        return s;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
            };
            BytecodeManager.incBytecodes(1);
            ZERO_LENGTH_ENUM_ARRAY = new Enum[0];
            BytecodeManager.incBytecodes(3);
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
                final EnumMap this$0 = EnumMap.this;
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
                final EnumMap this$0 = EnumMap.this;
                BytecodeManager.incBytecodes(3);
                final int access$200 = EnumMap.access$200(this$0);
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
                final EnumMap this$0 = EnumMap.this;
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
                final EnumMap this$0 = EnumMap.this;
                BytecodeManager.incBytecodes(3);
                final int access$200 = EnumMap.access$200(this$0);
                BytecodeManager.incBytecodes(1);
                final EnumMap this$2 = EnumMap.this;
                BytecodeManager.incBytecodes(4);
                this$2.remove(o);
                BytecodeManager.incBytecodes(1);
                final EnumMap this$3 = EnumMap.this;
                BytecodeManager.incBytecodes(3);
                final int access$201 = EnumMap.access$200(this$3);
                final int n = access$200;
                BytecodeManager.incBytecodes(2);
                boolean b;
                if (access$201 != n) {
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
                final EnumMap this$0 = EnumMap.this;
                BytecodeManager.incBytecodes(3);
                this$0.clear();
                BytecodeManager.incBytecodes(1);
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
                final EnumMap this$0 = EnumMap.this;
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
                final EnumMap this$0 = EnumMap.this;
                BytecodeManager.incBytecodes(3);
                final int access$200 = EnumMap.access$200(this$0);
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
                final EnumMap this$0 = EnumMap.this;
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
        public boolean remove(Object access$500) {
            try {
                final EnumMap this$0 = EnumMap.this;
                final Object o = access$500;
                BytecodeManager.incBytecodes(4);
                access$500 = EnumMap.access$500(this$0, o);
                BytecodeManager.incBytecodes(1);
                int n = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n2 = n;
                    final EnumMap this$2 = EnumMap.this;
                    BytecodeManager.incBytecodes(4);
                    final int length = EnumMap.access$600(this$2).length;
                    BytecodeManager.incBytecodes(2);
                    if (n2 >= length) {
                        final boolean b = false;
                        BytecodeManager.incBytecodes(2);
                        return b;
                    }
                    final Object o2 = access$500;
                    final EnumMap this$3 = EnumMap.this;
                    BytecodeManager.incBytecodes(4);
                    final Object obj = EnumMap.access$600(this$3)[n];
                    BytecodeManager.incBytecodes(3);
                    final boolean equals = o2.equals(obj);
                    BytecodeManager.incBytecodes(1);
                    if (equals) {
                        final EnumMap this$4 = EnumMap.this;
                        BytecodeManager.incBytecodes(3);
                        EnumMap.access$600(this$4)[n] = null;
                        BytecodeManager.incBytecodes(3);
                        final EnumMap this$5 = EnumMap.this;
                        BytecodeManager.incBytecodes(3);
                        EnumMap.access$210(this$5);
                        BytecodeManager.incBytecodes(1);
                        final boolean b2 = true;
                        BytecodeManager.incBytecodes(2);
                        return b2;
                    }
                    ++n;
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void clear() {
            try {
                final EnumMap this$0 = EnumMap.this;
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
                final EnumMap this$0 = EnumMap.this;
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
                final boolean b = o instanceof Map.Entry;
                BytecodeManager.incBytecodes(3);
                if (!b) {
                    final boolean b2 = false;
                    BytecodeManager.incBytecodes(2);
                    return b2;
                }
                final Map.Entry entry = (Map.Entry)o;
                BytecodeManager.incBytecodes(3);
                final EnumMap this$0 = EnumMap.this;
                final Map.Entry entry2 = entry;
                BytecodeManager.incBytecodes(4);
                final Object key = entry2.getKey();
                final Map.Entry entry3 = entry;
                BytecodeManager.incBytecodes(2);
                final Object value = entry3.getValue();
                BytecodeManager.incBytecodes(1);
                final boolean access$900 = EnumMap.access$900(this$0, key, value);
                BytecodeManager.incBytecodes(1);
                return access$900;
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
                final EnumMap this$0 = EnumMap.this;
                final Map.Entry entry2 = entry;
                BytecodeManager.incBytecodes(4);
                final Object key = entry2.getKey();
                final Map.Entry entry3 = entry;
                BytecodeManager.incBytecodes(2);
                final Object value = entry3.getValue();
                BytecodeManager.incBytecodes(1);
                final boolean access$1000 = EnumMap.access$1000(this$0, key, value);
                BytecodeManager.incBytecodes(1);
                return access$1000;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int size() {
            try {
                final EnumMap this$0 = EnumMap.this;
                BytecodeManager.incBytecodes(3);
                final int access$200 = EnumMap.access$200(this$0);
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
                final EnumMap this$0 = EnumMap.this;
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
                final EnumMap this$0 = EnumMap.this;
                BytecodeManager.incBytecodes(4);
                final Object[] array = new Object[EnumMap.access$200(this$0)];
                BytecodeManager.incBytecodes(1);
                final Object[] fillEntryArray = this.fillEntryArray(array);
                BytecodeManager.incBytecodes(1);
                return fillEntryArray;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public <T> T[] toArray(T[] array) {
            try {
                BytecodeManager.incBytecodes(2);
                final int size = this.size();
                BytecodeManager.incBytecodes(1);
                final int length = array.length;
                final int n = size;
                BytecodeManager.incBytecodes(4);
                if (length < n) {
                    final T[] array2 = array;
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    final Class<? extends Object[]> class1 = array2.getClass();
                    BytecodeManager.incBytecodes(1);
                    final Class<?> componentType = class1.getComponentType();
                    final int length2 = size;
                    BytecodeManager.incBytecodes(2);
                    array = (T[])Array.newInstance(componentType, length2);
                    BytecodeManager.incBytecodes(3);
                }
                final int length3 = array.length;
                final int n2 = size;
                BytecodeManager.incBytecodes(4);
                if (length3 > n2) {
                    array[size] = null;
                    BytecodeManager.incBytecodes(4);
                }
                final T[] array3 = array;
                BytecodeManager.incBytecodes(3);
                final Object[] array4 = this.fillEntryArray(array3);
                BytecodeManager.incBytecodes(2);
                return (T[])array4;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private Object[] fillEntryArray(final Object[] array) {
            try {
                int n = 0;
                BytecodeManager.incBytecodes(2);
                int n2 = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n3 = n2;
                    final EnumMap this$0 = EnumMap.this;
                    BytecodeManager.incBytecodes(4);
                    final int length = EnumMap.access$600(this$0).length;
                    BytecodeManager.incBytecodes(2);
                    if (n3 >= length) {
                        break;
                    }
                    final EnumMap this$2 = EnumMap.this;
                    BytecodeManager.incBytecodes(3);
                    final Object o = EnumMap.access$600(this$2)[n2];
                    BytecodeManager.incBytecodes(3);
                    if (o != null) {
                        final int n4 = n++;
                        final EnumMap this$3 = EnumMap.this;
                        BytecodeManager.incBytecodes(7);
                        BytecodeManager.incBytecodes(1);
                        final Enum enum1 = EnumMap.access$1100(this$3)[n2];
                        final EnumMap this$4 = EnumMap.this;
                        final EnumMap this$5 = EnumMap.this;
                        BytecodeManager.incBytecodes(7);
                        final Object o2 = EnumMap.access$600(this$5)[n2];
                        BytecodeManager.incBytecodes(3);
                        final Object access$1200 = EnumMap.access$1200(this$4, o2);
                        BytecodeManager.incBytecodes(1);
                        array[n4] = new SimpleEntry(enum1, access$1200);
                        BytecodeManager.incBytecodes(1);
                    }
                    ++n2;
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(2);
                return array;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private abstract class EnumMapIterator<T> implements Iterator<T>
    {
        int index;
        int lastReturnedIndex;
        
        private EnumMapIterator() {
            try {
                BytecodeManager.incBytecodes(5);
                this.index = 0;
                BytecodeManager.incBytecodes(3);
                this.lastReturnedIndex = -1;
                BytecodeManager.incBytecodes(4);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean hasNext() {
            try {
                while (true) {
                    final int index = this.index;
                    final EnumMap this$0 = EnumMap.this;
                    BytecodeManager.incBytecodes(5);
                    final int length = EnumMap.access$600(this$0).length;
                    BytecodeManager.incBytecodes(2);
                    if (index >= length) {
                        break;
                    }
                    final EnumMap this$2 = EnumMap.this;
                    BytecodeManager.incBytecodes(3);
                    final Object o = EnumMap.access$600(this$2)[this.index];
                    BytecodeManager.incBytecodes(4);
                    if (o != null) {
                        break;
                    }
                    ++this.index;
                    BytecodeManager.incBytecodes(7);
                }
                final int index2 = this.index;
                final EnumMap this$3 = EnumMap.this;
                BytecodeManager.incBytecodes(5);
                final int length2 = EnumMap.access$600(this$3).length;
                BytecodeManager.incBytecodes(2);
                boolean b;
                if (index2 != length2) {
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
        public void remove() {
            try {
                BytecodeManager.incBytecodes(2);
                this.checkLastReturnedIndex();
                final EnumMap this$0 = EnumMap.this;
                BytecodeManager.incBytecodes(3);
                final Object o = EnumMap.access$600(this$0)[this.lastReturnedIndex];
                BytecodeManager.incBytecodes(4);
                if (o != null) {
                    final EnumMap this$2 = EnumMap.this;
                    BytecodeManager.incBytecodes(3);
                    EnumMap.access$600(this$2)[this.lastReturnedIndex] = null;
                    BytecodeManager.incBytecodes(4);
                    final EnumMap this$3 = EnumMap.this;
                    BytecodeManager.incBytecodes(3);
                    EnumMap.access$210(this$3);
                    BytecodeManager.incBytecodes(1);
                }
                this.lastReturnedIndex = -1;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private void checkLastReturnedIndex() {
            try {
                final int lastReturnedIndex = this.lastReturnedIndex;
                BytecodeManager.incBytecodes(3);
                if (lastReturnedIndex < 0) {
                    BytecodeManager.incBytecodes(3);
                    final IllegalStateException ex = new IllegalStateException();
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
    
    private class KeyIterator extends EnumMapIterator<K>
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
                BytecodeManager.incBytecodes(2);
                final boolean hasNext = this.hasNext();
                BytecodeManager.incBytecodes(1);
                if (!hasNext) {
                    BytecodeManager.incBytecodes(3);
                    final NoSuchElementException ex = new NoSuchElementException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                this.lastReturnedIndex = this.index++;
                BytecodeManager.incBytecodes(9);
                final EnumMap this$0 = EnumMap.this;
                BytecodeManager.incBytecodes(3);
                final Enum enum1 = EnumMap.access$1100(this$0)[this.lastReturnedIndex];
                BytecodeManager.incBytecodes(4);
                return (K)enum1;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private class ValueIterator extends EnumMapIterator<V>
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
                BytecodeManager.incBytecodes(2);
                final boolean hasNext = this.hasNext();
                BytecodeManager.incBytecodes(1);
                if (!hasNext) {
                    BytecodeManager.incBytecodes(3);
                    final NoSuchElementException ex = new NoSuchElementException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                this.lastReturnedIndex = this.index++;
                BytecodeManager.incBytecodes(9);
                final EnumMap this$0 = EnumMap.this;
                final EnumMap this$2 = EnumMap.this;
                BytecodeManager.incBytecodes(5);
                final Object o = EnumMap.access$600(this$2)[this.lastReturnedIndex];
                BytecodeManager.incBytecodes(4);
                final Object access$1200 = EnumMap.access$1200(this$0, o);
                BytecodeManager.incBytecodes(1);
                return (V)access$1200;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private class EntryIterator extends EnumMapIterator<Map.Entry<K, V>>
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
                BytecodeManager.incBytecodes(2);
                final boolean hasNext = this.hasNext();
                BytecodeManager.incBytecodes(1);
                if (!hasNext) {
                    BytecodeManager.incBytecodes(3);
                    final NoSuchElementException ex = new NoSuchElementException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final int n = this.index++;
                final Object object = null;
                BytecodeManager.incBytecodes(13);
                this.lastReturnedEntry = new Entry(n);
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
                int access$1500;
                if (entry == lastReturnedEntry) {
                    access$1500 = -1;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final Entry lastReturnedEntry2 = this.lastReturnedEntry;
                    BytecodeManager.incBytecodes(2);
                    BytecodeManager.incBytecodes(1);
                    access$1500 = Entry.access$1500(lastReturnedEntry2);
                }
                this.lastReturnedIndex = access$1500;
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(2);
                super.remove();
                final Entry lastReturnedEntry3 = this.lastReturnedEntry;
                final int lastReturnedIndex = this.lastReturnedIndex;
                BytecodeManager.incBytecodes(5);
                Entry.access$1502(lastReturnedEntry3, lastReturnedIndex);
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
                    final EnumMap this$0 = EnumMap.this;
                    BytecodeManager.incBytecodes(4);
                    final Enum enum1 = EnumMap.access$1100(this$0)[this.index];
                    BytecodeManager.incBytecodes(4);
                    return (K)enum1;
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
                    final EnumMap this$0 = EnumMap.this;
                    final EnumMap this$2 = EnumMap.this;
                    BytecodeManager.incBytecodes(7);
                    final Object o = EnumMap.access$600(this$2)[this.index];
                    BytecodeManager.incBytecodes(4);
                    final Object access$1200 = EnumMap.access$1200(this$0, o);
                    BytecodeManager.incBytecodes(1);
                    return (V)access$1200;
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
                    final EnumMap this$0 = EnumMap.this;
                    final EnumMap this$2 = EnumMap.this;
                    BytecodeManager.incBytecodes(7);
                    final Object o = EnumMap.access$600(this$2)[this.index];
                    BytecodeManager.incBytecodes(4);
                    final Object access$1200 = EnumMap.access$1200(this$0, o);
                    BytecodeManager.incBytecodes(1);
                    final EnumMap this$3 = EnumMap.this;
                    BytecodeManager.incBytecodes(4);
                    final Object[] access$1201 = EnumMap.access$600(this$3);
                    final int index = this.index;
                    final EnumMap this$4 = EnumMap.this;
                    BytecodeManager.incBytecodes(7);
                    access$1201[index] = EnumMap.access$500(this$4, v);
                    BytecodeManager.incBytecodes(1);
                    final Object o2 = access$1200;
                    BytecodeManager.incBytecodes(2);
                    return (V)o2;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public boolean equals(final Object o) {
                try {
                    final int index = this.index;
                    BytecodeManager.incBytecodes(3);
                    if (index < 0) {
                        BytecodeManager.incBytecodes(3);
                        boolean b;
                        if (o == this) {
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
                    final boolean b2 = o instanceof Map.Entry;
                    BytecodeManager.incBytecodes(3);
                    if (!b2) {
                        final boolean b3 = false;
                        BytecodeManager.incBytecodes(2);
                        return b3;
                    }
                    final Map.Entry entry = (Map.Entry)o;
                    BytecodeManager.incBytecodes(3);
                    final EnumMap this$0 = EnumMap.this;
                    final EnumMap this$2 = EnumMap.this;
                    BytecodeManager.incBytecodes(7);
                    final Object o2 = EnumMap.access$600(this$2)[this.index];
                    BytecodeManager.incBytecodes(4);
                    final Object access$1200 = EnumMap.access$1200(this$0, o2);
                    BytecodeManager.incBytecodes(1);
                    final Map.Entry<K, Object> entry2 = (Map.Entry<K, Object>)entry;
                    BytecodeManager.incBytecodes(2);
                    final Object value = entry2.getValue();
                    BytecodeManager.incBytecodes(1);
                    final Map.Entry<Enum, Object> entry3 = (Map.Entry<Enum, Object>)entry;
                    BytecodeManager.incBytecodes(2);
                    final Enum key = entry3.getKey();
                    final EnumMap this$3 = EnumMap.this;
                    BytecodeManager.incBytecodes(4);
                    final Enum enum1 = EnumMap.access$1100(this$3)[this.index];
                    BytecodeManager.incBytecodes(4);
                    boolean b4 = false;
                    Label_0229: {
                        Label_0223: {
                            if (key == enum1) {
                                final Object o3 = access$1200;
                                final Object o4 = value;
                                BytecodeManager.incBytecodes(3);
                                if (o3 != o4) {
                                    final Object o5 = access$1200;
                                    BytecodeManager.incBytecodes(2);
                                    if (o5 == null) {
                                        break Label_0223;
                                    }
                                    final Object o6 = access$1200;
                                    final Object obj = value;
                                    BytecodeManager.incBytecodes(2);
                                    BytecodeManager.incBytecodes(1);
                                    final boolean equals = o6.equals(obj);
                                    BytecodeManager.incBytecodes(1);
                                    if (!equals) {
                                        break Label_0223;
                                    }
                                }
                                b4 = true;
                                BytecodeManager.incBytecodes(2);
                                break Label_0229;
                            }
                        }
                        b4 = false;
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(1);
                    return b4;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public int hashCode() {
                try {
                    final int index = this.index;
                    BytecodeManager.incBytecodes(3);
                    if (index < 0) {
                        BytecodeManager.incBytecodes(2);
                        final int hashCode = super.hashCode();
                        BytecodeManager.incBytecodes(1);
                        return hashCode;
                    }
                    final EnumMap this$0 = EnumMap.this;
                    final int index2 = this.index;
                    BytecodeManager.incBytecodes(6);
                    final int access$1600 = EnumMap.access$1600(this$0, index2);
                    BytecodeManager.incBytecodes(1);
                    return access$1600;
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
                    final EnumMap this$0 = EnumMap.this;
                    BytecodeManager.incBytecodes(4);
                    final Enum obj = EnumMap.access$1100(this$0)[this.index];
                    BytecodeManager.incBytecodes(4);
                    final StringBuilder append = sb.append(obj);
                    final String str = "=";
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append2 = append.append(str);
                    final EnumMap this$2 = EnumMap.this;
                    final EnumMap this$3 = EnumMap.this;
                    BytecodeManager.incBytecodes(6);
                    BytecodeManager.incBytecodes(1);
                    final Object o = EnumMap.access$600(this$3)[this.index];
                    BytecodeManager.incBytecodes(4);
                    final Object access$1200 = EnumMap.access$1200(this$2, o);
                    BytecodeManager.incBytecodes(1);
                    final StringBuilder append3 = append2.append(access$1200);
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
            
            static /* synthetic */ int access$1500(final Entry entry) {
                try {
                    final int index = entry.index;
                    BytecodeManager.incBytecodes(3);
                    return index;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            static /* synthetic */ int access$1502(final Entry entry, final int index) {
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
}
