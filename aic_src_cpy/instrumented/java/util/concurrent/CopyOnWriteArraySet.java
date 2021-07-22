// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.concurrent;

import instrumented.java.util.Spliterators;
import instrumented.java.util.Spliterator;
import instrumented.java.util.function.Consumer;
import instrumented.java.util.function.Predicate;
import instrumented.java.util.Set;
import java.util.Iterator;
import instrumented.java.util.Collection;
import aic2021.engine.BytecodeManager;
import java.io.Serializable;
import instrumented.java.util.AbstractSet;

public class CopyOnWriteArraySet<E> extends AbstractSet<E> implements Serializable
{
    private static final long serialVersionUID = 5457747651344034263L;
    private final CopyOnWriteArrayList<E> al;
    
    public CopyOnWriteArraySet() {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(4);
            this.al = new CopyOnWriteArrayList<E>();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public CopyOnWriteArraySet(final Collection<? extends E> collection) {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            final Class<? extends CopyOnWriteArraySet> class1 = ((CopyOnWriteArraySet<? extends E>)collection).getClass();
            final Class<CopyOnWriteArraySet> clazz = CopyOnWriteArraySet.class;
            BytecodeManager.incBytecodes(2);
            if (class1 == clazz) {
                final CopyOnWriteArraySet<? extends E> set = (CopyOnWriteArraySet<? extends E>)collection;
                BytecodeManager.incBytecodes(3);
                final CopyOnWriteArrayList<? extends E> al = set.al;
                BytecodeManager.incBytecodes(6);
                this.al = new CopyOnWriteArrayList<E>(al);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            else {
                BytecodeManager.incBytecodes(4);
                this.al = new CopyOnWriteArrayList<E>();
                BytecodeManager.incBytecodes(1);
                final CopyOnWriteArrayList<E> al2 = this.al;
                BytecodeManager.incBytecodes(4);
                al2.addAllAbsent(collection);
                BytecodeManager.incBytecodes(1);
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
            final CopyOnWriteArrayList<E> al = this.al;
            BytecodeManager.incBytecodes(3);
            final int size = al.size();
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
            final CopyOnWriteArrayList<E> al = this.al;
            BytecodeManager.incBytecodes(3);
            final boolean empty = al.isEmpty();
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
            final CopyOnWriteArrayList<E> al = this.al;
            BytecodeManager.incBytecodes(4);
            final boolean contains = al.contains(o);
            BytecodeManager.incBytecodes(1);
            return contains;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public Object[] toArray() {
        try {
            final CopyOnWriteArrayList<E> al = this.al;
            BytecodeManager.incBytecodes(3);
            final Object[] array = al.toArray();
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
            final CopyOnWriteArrayList<E> al = this.al;
            BytecodeManager.incBytecodes(4);
            final T[] array2 = al.toArray(array);
            BytecodeManager.incBytecodes(1);
            return array2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void clear() {
        try {
            final CopyOnWriteArrayList<E> al = this.al;
            BytecodeManager.incBytecodes(3);
            al.clear();
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean remove(final Object o) {
        try {
            final CopyOnWriteArrayList<E> al = this.al;
            BytecodeManager.incBytecodes(4);
            final boolean remove = al.remove(o);
            BytecodeManager.incBytecodes(1);
            return remove;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean add(final E e) {
        try {
            final CopyOnWriteArrayList<E> al = this.al;
            BytecodeManager.incBytecodes(4);
            final boolean addIfAbsent = al.addIfAbsent(e);
            BytecodeManager.incBytecodes(1);
            return addIfAbsent;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean containsAll(final Collection<?> collection) {
        try {
            final CopyOnWriteArrayList<E> al = this.al;
            BytecodeManager.incBytecodes(4);
            final boolean containsAll = al.containsAll(collection);
            BytecodeManager.incBytecodes(1);
            return containsAll;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean addAll(final Collection<? extends E> collection) {
        try {
            final CopyOnWriteArrayList<E> al = this.al;
            BytecodeManager.incBytecodes(4);
            final int addAllAbsent = al.addAllAbsent(collection);
            BytecodeManager.incBytecodes(1);
            boolean b;
            if (addAllAbsent > 0) {
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
            final CopyOnWriteArrayList<E> al = this.al;
            BytecodeManager.incBytecodes(4);
            final boolean removeAll = al.removeAll(collection);
            BytecodeManager.incBytecodes(1);
            return removeAll;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean retainAll(final Collection<?> collection) {
        try {
            final CopyOnWriteArrayList<E> al = this.al;
            BytecodeManager.incBytecodes(4);
            final boolean retainAll = al.retainAll(collection);
            BytecodeManager.incBytecodes(1);
            return retainAll;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public Iterator<E> iterator() {
        try {
            final CopyOnWriteArrayList<E> al = this.al;
            BytecodeManager.incBytecodes(3);
            final Iterator<E> iterator = al.iterator();
            BytecodeManager.incBytecodes(1);
            return iterator;
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
            final boolean b2 = o instanceof Set;
            BytecodeManager.incBytecodes(3);
            if (!b2) {
                final boolean b3 = false;
                BytecodeManager.incBytecodes(2);
                return b3;
            }
            final Set set = (Set)o;
            BytecodeManager.incBytecodes(4);
            final Set<Object> set2 = (Set<Object>)set;
            BytecodeManager.incBytecodes(2);
            final Iterator<Object> iterator = set2.iterator();
            BytecodeManager.incBytecodes(1);
            final CopyOnWriteArrayList<E> al = this.al;
            BytecodeManager.incBytecodes(3);
            final Object[] array = al.getArray();
            BytecodeManager.incBytecodes(1);
            final int length = array.length;
            BytecodeManager.incBytecodes(3);
            final boolean[] array2 = new boolean[length];
            BytecodeManager.incBytecodes(2);
            int n = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final Iterator<Object> iterator2 = iterator;
                BytecodeManager.incBytecodes(2);
                final boolean hasNext = iterator2.hasNext();
                BytecodeManager.incBytecodes(1);
                if (!hasNext) {
                    final int n2 = n;
                    final int n3 = length;
                    BytecodeManager.incBytecodes(3);
                    boolean b4;
                    if (n2 == n3) {
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
                final int n4 = ++n;
                final int n5 = length;
                BytecodeManager.incBytecodes(4);
                if (n4 > n5) {
                    final boolean b5 = false;
                    BytecodeManager.incBytecodes(2);
                    return b5;
                }
                final Iterator<Object> iterator3 = iterator;
                BytecodeManager.incBytecodes(2);
                final Object next = iterator3.next();
                BytecodeManager.incBytecodes(1);
                int n6 = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n7 = n6;
                    final int n8 = length;
                    BytecodeManager.incBytecodes(3);
                    if (n7 >= n8) {
                        final boolean b6 = false;
                        BytecodeManager.incBytecodes(2);
                        return b6;
                    }
                    final boolean b7 = array2[n6];
                    BytecodeManager.incBytecodes(4);
                    if (!b7) {
                        final Object o2 = next;
                        final Object o3 = array[n6];
                        BytecodeManager.incBytecodes(5);
                        final boolean eq = eq(o2, o3);
                        BytecodeManager.incBytecodes(1);
                        if (eq) {
                            array2[n6] = true;
                            BytecodeManager.incBytecodes(4);
                            BytecodeManager.incBytecodes(1);
                            break;
                        }
                    }
                    ++n6;
                    BytecodeManager.incBytecodes(2);
                }
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean removeIf(final Predicate<? super E> predicate) {
        try {
            final CopyOnWriteArrayList<E> al = this.al;
            BytecodeManager.incBytecodes(4);
            final boolean removeIf = al.removeIf(predicate);
            BytecodeManager.incBytecodes(1);
            return removeIf;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void forEach(final Consumer<? super E> consumer) {
        try {
            final CopyOnWriteArrayList<E> al = this.al;
            BytecodeManager.incBytecodes(4);
            al.forEach(consumer);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public Spliterator<E> spliterator() {
        try {
            final CopyOnWriteArrayList<E> al = this.al;
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
            final Object[] array = al.getArray();
            final int n = 1025;
            BytecodeManager.incBytecodes(2);
            final Spliterator<Object> spliterator = Spliterators.spliterator(array, n);
            BytecodeManager.incBytecodes(1);
            return (Spliterator<E>)spliterator;
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
}
