// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import aic2021.engine.BytecodeManager;
import java.io.Serializable;

public class HashSet<E> extends AbstractSet<E> implements Set<E>, Cloneable, Serializable
{
    static final long serialVersionUID = -5024744406713321676L;
    private transient HashMap<E, Object> map;
    private static final Object PRESENT;
    
    public HashSet() {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(4);
            this.map = new HashMap<E, Object>();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public HashSet(final Collection<? extends E> collection) {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(5);
            final int a = (int)(collection.size() / 0.75f) + 1;
            final int b = 16;
            BytecodeManager.incBytecodes(8);
            final int max = Math.max(a, b);
            BytecodeManager.incBytecodes(1);
            this.map = new HashMap<E, Object>(max);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            this.addAll(collection);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public HashSet(final int n, final float n2) {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(6);
            this.map = new HashMap<E, Object>(n, n2);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public HashSet(final int n) {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(5);
            this.map = new HashMap<E, Object>(n);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    HashSet(final int n, final float n2, final boolean b) {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(6);
            this.map = new LinkedHashMap<E, Object>(n, n2);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public Iterator<E> iterator() {
        try {
            final HashMap<E, Object> map = this.map;
            BytecodeManager.incBytecodes(3);
            final Set<E> keySet = map.keySet();
            BytecodeManager.incBytecodes(1);
            final Iterator<E> iterator = keySet.iterator();
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
            final HashMap<E, Object> map = this.map;
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
    public boolean isEmpty() {
        try {
            final HashMap<E, Object> map = this.map;
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
    public boolean contains(final Object o) {
        try {
            final HashMap<E, Object> map = this.map;
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
    public boolean add(final E e) {
        try {
            final HashMap<E, Object> map = this.map;
            final Object present = HashSet.PRESENT;
            BytecodeManager.incBytecodes(5);
            final Object put = map.put(e, present);
            BytecodeManager.incBytecodes(1);
            boolean b;
            if (put == null) {
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
    public boolean remove(final Object o) {
        try {
            final HashMap<E, Object> map = this.map;
            BytecodeManager.incBytecodes(4);
            final Object remove = map.remove(o);
            final Object present = HashSet.PRESENT;
            BytecodeManager.incBytecodes(2);
            boolean b;
            if (remove == present) {
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
            final HashMap<E, Object> map = this.map;
            BytecodeManager.incBytecodes(3);
            map.clear();
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Object clone() {
        try {
            try {
                BytecodeManager.incBytecodes(2);
                final HashSet set = (HashSet)super.clone();
                BytecodeManager.incBytecodes(2);
                final HashSet set2 = set;
                final HashMap<E, Object> map = this.map;
                BytecodeManager.incBytecodes(4);
                set2.map = (HashMap<E, Object>)map.clone();
                BytecodeManager.incBytecodes(2);
                final HashSet set3 = set;
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                return set3;
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
    
    private void writeObject(final ObjectOutputStream objectOutputStream) throws IOException {
        try {
            BytecodeManager.incBytecodes(2);
            objectOutputStream.defaultWriteObject();
            final HashMap<E, Object> map = this.map;
            BytecodeManager.incBytecodes(4);
            final int capacity = map.capacity();
            BytecodeManager.incBytecodes(1);
            objectOutputStream.writeInt(capacity);
            final HashMap<E, Object> map2 = this.map;
            BytecodeManager.incBytecodes(4);
            final float loadFactor = map2.loadFactor();
            BytecodeManager.incBytecodes(1);
            objectOutputStream.writeFloat(loadFactor);
            final HashMap<E, Object> map3 = this.map;
            BytecodeManager.incBytecodes(4);
            final int size = map3.size();
            BytecodeManager.incBytecodes(1);
            objectOutputStream.writeInt(size);
            final HashMap<E, Object> map4 = this.map;
            BytecodeManager.incBytecodes(3);
            final Set<E> keySet = map4.keySet();
            BytecodeManager.incBytecodes(1);
            final Iterator<E> iterator = keySet.iterator();
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
                final String str = "Illegal capacity: ";
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
            BytecodeManager.incBytecodes(2);
            final float float1 = objectInputStream.readFloat();
            BytecodeManager.incBytecodes(1);
            final float n2 = fcmpg(float1, 0.0f);
            BytecodeManager.incBytecodes(4);
            if (n2 > 0) {
                final float v = float1;
                BytecodeManager.incBytecodes(2);
                final boolean naN = Float.isNaN(v);
                BytecodeManager.incBytecodes(1);
                if (!naN) {
                    BytecodeManager.incBytecodes(2);
                    final int int2 = objectInputStream.readInt();
                    BytecodeManager.incBytecodes(1);
                    final int n3 = int2;
                    BytecodeManager.incBytecodes(2);
                    if (n3 < 0) {
                        BytecodeManager.incBytecodes(5);
                        final StringBuilder sb2 = new StringBuilder();
                        final String str2 = "Illegal size: ";
                        BytecodeManager.incBytecodes(2);
                        final StringBuilder append3 = sb2.append(str2);
                        final int j = int2;
                        BytecodeManager.incBytecodes(2);
                        final StringBuilder append4 = append3.append(j);
                        BytecodeManager.incBytecodes(1);
                        final String string2 = append4.toString();
                        BytecodeManager.incBytecodes(1);
                        final InvalidObjectException ex2 = new InvalidObjectException(string2);
                        BytecodeManager.incBytecodes(1);
                        throw ex2;
                    }
                    final float n4 = (float)int2;
                    final float a = 1.0f / float1;
                    final float b = 4.0f;
                    BytecodeManager.incBytecodes(7);
                    final float a2 = n4 * Math.min(a, b);
                    final float b2 = 1.07374182E9f;
                    BytecodeManager.incBytecodes(3);
                    final int n5 = (int)Math.min(a2, b2);
                    BytecodeManager.incBytecodes(2);
                    final boolean b3 = this instanceof LinkedHashSet;
                    BytecodeManager.incBytecodes(4);
                    HashMap map;
                    if (b3) {
                        final int n6;
                        final float n7;
                        map = new LinkedHashMap<E, Object>(n6, n7);
                        n6 = n5;
                        n7 = float1;
                        BytecodeManager.incBytecodes(5);
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        final int n8;
                        final float n9;
                        map = new HashMap<E, Object>(n8, n9);
                        n8 = n5;
                        n9 = float1;
                        BytecodeManager.incBytecodes(5);
                    }
                    this.map = (HashMap<E, Object>)map;
                    BytecodeManager.incBytecodes(1);
                    int n10 = 0;
                    BytecodeManager.incBytecodes(2);
                    while (true) {
                        final int n11 = n10;
                        final int n12 = int2;
                        BytecodeManager.incBytecodes(3);
                        if (n11 >= n12) {
                            break;
                        }
                        BytecodeManager.incBytecodes(2);
                        final Object object = objectInputStream.readObject();
                        BytecodeManager.incBytecodes(1);
                        final HashMap<E, Object> map2 = this.map;
                        final Object o = object;
                        final Object present = HashSet.PRESENT;
                        BytecodeManager.incBytecodes(5);
                        map2.put((E)o, present);
                        BytecodeManager.incBytecodes(1);
                        ++n10;
                        BytecodeManager.incBytecodes(2);
                    }
                    BytecodeManager.incBytecodes(1);
                    return;
                }
            }
            BytecodeManager.incBytecodes(5);
            final StringBuilder sb3 = new StringBuilder();
            final String str3 = "Illegal load factor: ";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append5 = sb3.append(str3);
            final float f = float1;
            BytecodeManager.incBytecodes(2);
            final StringBuilder append6 = append5.append(f);
            BytecodeManager.incBytecodes(1);
            final String string3 = append6.toString();
            BytecodeManager.incBytecodes(1);
            final InvalidObjectException ex3 = new InvalidObjectException(string3);
            BytecodeManager.incBytecodes(1);
            throw ex3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public Spliterator<E> spliterator() {
        try {
            final HashMap<E, Object> map = this.map;
            final int n = 0;
            final int n2 = -1;
            final int n3 = 0;
            final int n4 = 0;
            BytecodeManager.incBytecodes(9);
            final HashMap.KeySpliterator keySpliterator = new HashMap.KeySpliterator<E, Object>(map, n, n2, n3, n4);
            BytecodeManager.incBytecodes(1);
            return (Spliterator<E>)keySpliterator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static {
        try {
            BytecodeManager.incBytecodes(3);
            PRESENT = new Object();
            BytecodeManager.incBytecodes(2);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
