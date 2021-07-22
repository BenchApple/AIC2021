// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import aic2021.engine.BytecodeManager;
import java.io.Serializable;

public class TreeSet<E> extends AbstractSet<E> implements NavigableSet<E>, Cloneable, Serializable
{
    private transient NavigableMap<E, Object> m;
    private static final Object PRESENT;
    private static final long serialVersionUID = -2479143000061671589L;
    
    TreeSet(final NavigableMap<E, Object> m) {
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
    
    public TreeSet() {
        try {
            BytecodeManager.incBytecodes(4);
            final TreeMap treeMap = new TreeMap();
            BytecodeManager.incBytecodes(1);
            this(treeMap);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public TreeSet(final Comparator<? super E> comparator) {
        try {
            BytecodeManager.incBytecodes(5);
            final TreeMap treeMap = new TreeMap(comparator);
            BytecodeManager.incBytecodes(1);
            this(treeMap);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public TreeSet(final Collection<? extends E> collection) {
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
    
    public TreeSet(final SortedSet<E> set) {
        try {
            BytecodeManager.incBytecodes(3);
            final Comparator<? super E> comparator = set.comparator();
            BytecodeManager.incBytecodes(1);
            this(comparator);
            BytecodeManager.incBytecodes(3);
            this.addAll((Collection<? extends E>)set);
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
            final NavigableMap<E, Object> m = this.m;
            BytecodeManager.incBytecodes(3);
            final NavigableSet<E> navigableKeySet = m.navigableKeySet();
            BytecodeManager.incBytecodes(1);
            final Iterator<E> iterator = navigableKeySet.iterator();
            BytecodeManager.incBytecodes(1);
            return iterator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public Iterator<E> descendingIterator() {
        try {
            final NavigableMap<E, Object> m = this.m;
            BytecodeManager.incBytecodes(3);
            final NavigableSet<E> descendingKeySet = m.descendingKeySet();
            BytecodeManager.incBytecodes(1);
            final Iterator<E> iterator = descendingKeySet.iterator();
            BytecodeManager.incBytecodes(1);
            return iterator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public NavigableSet<E> descendingSet() {
        try {
            final NavigableMap<E, Object> m = this.m;
            BytecodeManager.incBytecodes(5);
            final NavigableMap<E, Object> descendingMap = m.descendingMap();
            BytecodeManager.incBytecodes(1);
            final TreeSet set = new TreeSet((NavigableMap<Object, Object>)descendingMap);
            BytecodeManager.incBytecodes(1);
            return set;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public int size() {
        try {
            final NavigableMap<E, Object> m = this.m;
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
            final NavigableMap<E, Object> m = this.m;
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
            final NavigableMap<E, Object> m = this.m;
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
    public boolean add(final E e) {
        try {
            final NavigableMap<E, Object> m = this.m;
            final Object present = TreeSet.PRESENT;
            BytecodeManager.incBytecodes(5);
            final Object put = m.put(e, present);
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
            final NavigableMap<E, Object> m = this.m;
            BytecodeManager.incBytecodes(4);
            final Object remove = m.remove(o);
            final Object present = TreeSet.PRESENT;
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
            final NavigableMap<E, Object> m = this.m;
            BytecodeManager.incBytecodes(3);
            m.clear();
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean addAll(final Collection<? extends E> collection) {
        try {
            final NavigableMap<E, Object> m = this.m;
            BytecodeManager.incBytecodes(3);
            final int size = m.size();
            BytecodeManager.incBytecodes(1);
            Label_0189: {
                if (size == 0) {
                    BytecodeManager.incBytecodes(2);
                    final int size2 = collection.size();
                    BytecodeManager.incBytecodes(1);
                    if (size2 > 0) {
                        final boolean b = collection instanceof SortedSet;
                        BytecodeManager.incBytecodes(3);
                        if (b) {
                            final boolean b2 = this.m instanceof TreeMap;
                            BytecodeManager.incBytecodes(4);
                            if (b2) {
                                final SortedSet<? extends E> set = (SortedSet<? extends E>)collection;
                                BytecodeManager.incBytecodes(3);
                                final TreeMap treeMap = (TreeMap)this.m;
                                BytecodeManager.incBytecodes(4);
                                final SortedSet<? extends E> set2 = set;
                                BytecodeManager.incBytecodes(2);
                                final Comparator<? super E> comparator = set2.comparator();
                                BytecodeManager.incBytecodes(1);
                                final TreeMap treeMap2 = treeMap;
                                BytecodeManager.incBytecodes(2);
                                final Comparator<? super Object> comparator2 = treeMap2.comparator();
                                BytecodeManager.incBytecodes(1);
                                final Comparator<? super E> comparator3 = comparator;
                                final Comparator<? super Object> comparator4 = comparator2;
                                BytecodeManager.incBytecodes(3);
                                if (comparator3 != comparator4) {
                                    final Comparator<? super Object> comparator5 = (Comparator<? super Object>)comparator;
                                    BytecodeManager.incBytecodes(2);
                                    if (comparator5 == null) {
                                        break Label_0189;
                                    }
                                    final Comparator<? super Object> comparator6 = (Comparator<? super Object>)comparator;
                                    final Comparator<? super Object> comparator7 = comparator2;
                                    BytecodeManager.incBytecodes(3);
                                    final boolean equals = comparator6.equals(comparator7);
                                    BytecodeManager.incBytecodes(1);
                                    if (!equals) {
                                        break Label_0189;
                                    }
                                }
                                final TreeMap treeMap3 = treeMap;
                                final SortedSet<? extends E> set3 = set;
                                final Object present = TreeSet.PRESENT;
                                BytecodeManager.incBytecodes(4);
                                treeMap3.addAllForTreeSet(set3, present);
                                final boolean b3 = true;
                                BytecodeManager.incBytecodes(2);
                                return b3;
                            }
                        }
                    }
                }
            }
            BytecodeManager.incBytecodes(3);
            final boolean addAll = super.addAll(collection);
            BytecodeManager.incBytecodes(1);
            return addAll;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public NavigableSet<E> subSet(final E e, final boolean b, final E e2, final boolean b2) {
        try {
            final NavigableMap<E, Object> m = this.m;
            BytecodeManager.incBytecodes(9);
            final NavigableMap<E, Object> subMap = m.subMap(e, b, e2, b2);
            BytecodeManager.incBytecodes(1);
            final TreeSet set = new TreeSet((NavigableMap<Object, Object>)subMap);
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
            final NavigableMap<E, Object> m = this.m;
            BytecodeManager.incBytecodes(7);
            final NavigableMap<E, Object> headMap = m.headMap(e, b);
            BytecodeManager.incBytecodes(1);
            final TreeSet set = new TreeSet((NavigableMap<Object, Object>)headMap);
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
            final NavigableMap<E, Object> m = this.m;
            BytecodeManager.incBytecodes(7);
            final NavigableMap<E, Object> tailMap = m.tailMap(e, b);
            BytecodeManager.incBytecodes(1);
            final TreeSet set = new TreeSet((NavigableMap<Object, Object>)tailMap);
            BytecodeManager.incBytecodes(1);
            return set;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public SortedSet<E> subSet(final E e, final E e2) {
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
    public SortedSet<E> headSet(final E e) {
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
    public SortedSet<E> tailSet(final E e) {
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
    public Comparator<? super E> comparator() {
        try {
            final NavigableMap<E, Object> m = this.m;
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
            final NavigableMap<E, Object> m = this.m;
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
            final NavigableMap<E, Object> m = this.m;
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
    public E lower(final E e) {
        try {
            final NavigableMap<E, Object> m = this.m;
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
            final NavigableMap<E, Object> m = this.m;
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
            final NavigableMap<E, Object> m = this.m;
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
            final NavigableMap<E, Object> m = this.m;
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
    public E pollFirst() {
        try {
            final NavigableMap<E, Object> m = this.m;
            BytecodeManager.incBytecodes(3);
            final Map.Entry<E, V> pollFirstEntry = m.pollFirstEntry();
            BytecodeManager.incBytecodes(1);
            final Map.Entry<E, V> entry = pollFirstEntry;
            BytecodeManager.incBytecodes(2);
            E key;
            if (entry == null) {
                key = null;
                BytecodeManager.incBytecodes(2);
            }
            else {
                final Map.Entry<E, V> entry2 = pollFirstEntry;
                BytecodeManager.incBytecodes(2);
                key = entry2.getKey();
            }
            BytecodeManager.incBytecodes(1);
            return key;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public E pollLast() {
        try {
            final NavigableMap<E, Object> m = this.m;
            BytecodeManager.incBytecodes(3);
            final Map.Entry<E, V> pollLastEntry = m.pollLastEntry();
            BytecodeManager.incBytecodes(1);
            final Map.Entry<E, V> entry = pollLastEntry;
            BytecodeManager.incBytecodes(2);
            E key;
            if (entry == null) {
                key = null;
                BytecodeManager.incBytecodes(2);
            }
            else {
                final Map.Entry<E, V> entry2 = pollLastEntry;
                BytecodeManager.incBytecodes(2);
                key = entry2.getKey();
            }
            BytecodeManager.incBytecodes(1);
            return key;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Object clone() {
        try {
            try {
                TreeSet set;
                try {
                    BytecodeManager.incBytecodes(2);
                    set = (TreeSet)super.clone();
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
                final TreeSet set2 = set;
                final NavigableMap<E, Object> m = this.m;
                BytecodeManager.incBytecodes(6);
                set2.m = new TreeMap<E, Object>((SortedMap<Object, ?>)m);
                BytecodeManager.incBytecodes(1);
                final TreeSet set3 = set;
                BytecodeManager.incBytecodes(2);
                return set3;
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
            final NavigableMap<E, Object> m = this.m;
            BytecodeManager.incBytecodes(4);
            final Comparator<? super Object> comparator = m.comparator();
            BytecodeManager.incBytecodes(1);
            objectOutputStream.writeObject(comparator);
            final NavigableMap<E, Object> i = this.m;
            BytecodeManager.incBytecodes(4);
            final int size = i.size();
            BytecodeManager.incBytecodes(1);
            objectOutputStream.writeInt(size);
            final NavigableMap<E, Object> j = this.m;
            BytecodeManager.incBytecodes(3);
            final Set<Object> keySet = j.keySet();
            BytecodeManager.incBytecodes(1);
            final Iterator<Object> iterator = keySet.iterator();
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
                final Object next = iterator3.next();
                BytecodeManager.incBytecodes(1);
                final Object obj = next;
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
            final Comparator comparator = (Comparator)objectInputStream.readObject();
            BytecodeManager.incBytecodes(2);
            final Comparator comparator2 = comparator;
            BytecodeManager.incBytecodes(4);
            final TreeMap m = new TreeMap<E, Object>(comparator2);
            BytecodeManager.incBytecodes(1);
            this.m = (NavigableMap<E, Object>)m;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(2);
            final int int1 = objectInputStream.readInt();
            BytecodeManager.incBytecodes(1);
            final TreeMap<E, Object> treeMap = (TreeMap<E, Object>)m;
            final int n = int1;
            final Object present = TreeSet.PRESENT;
            BytecodeManager.incBytecodes(5);
            treeMap.readTreeSet(n, objectInputStream, present);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public Spliterator<E> spliterator() {
        try {
            final NavigableMap<E, Object> m = this.m;
            BytecodeManager.incBytecodes(3);
            final Spliterator<E> keySpliterator = TreeMap.keySpliteratorFor(m);
            BytecodeManager.incBytecodes(1);
            return keySpliterator;
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
