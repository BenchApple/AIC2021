// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import aic2021.engine.BytecodeManager;
import instrumented.java.util.function.UnaryOperator;
import java.util.Iterator;

public interface List<E> extends Collection<E>
{
    int size();
    
    boolean isEmpty();
    
    boolean contains(final Object p0);
    
    Iterator<E> iterator();
    
    Object[] toArray();
    
     <T> T[] toArray(final T[] p0);
    
    boolean add(final E p0);
    
    boolean remove(final Object p0);
    
    boolean containsAll(final Collection<?> p0);
    
    boolean addAll(final Collection<? extends E> p0);
    
    boolean addAll(final int p0, final Collection<? extends E> p1);
    
    boolean removeAll(final Collection<?> p0);
    
    boolean retainAll(final Collection<?> p0);
    
    default void replaceAll(final UnaryOperator<E> unaryOperator) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(unaryOperator);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            final ListIterator<E> listIterator = this.listIterator();
            BytecodeManager.incBytecodes(1);
            while (true) {
                final ListIterator<E> listIterator2 = listIterator;
                BytecodeManager.incBytecodes(2);
                final boolean hasNext = listIterator2.hasNext();
                BytecodeManager.incBytecodes(1);
                if (!hasNext) {
                    break;
                }
                final ListIterator<E> listIterator3 = listIterator;
                final ListIterator<E> listIterator4 = listIterator;
                BytecodeManager.incBytecodes(4);
                final E next = listIterator4.next();
                BytecodeManager.incBytecodes(1);
                final Object apply = unaryOperator.apply(next);
                BytecodeManager.incBytecodes(1);
                listIterator3.set((E)apply);
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    default void sort(final Comparator<? super E> comparator) {
        try {
            BytecodeManager.incBytecodes(2);
            final Object[] array = this.toArray();
            BytecodeManager.incBytecodes(1);
            final Object[] array2 = array;
            BytecodeManager.incBytecodes(3);
            Arrays.sort(array2, (Comparator<? super Object>)comparator);
            BytecodeManager.incBytecodes(2);
            final ListIterator<Object> listIterator = this.listIterator();
            BytecodeManager.incBytecodes(1);
            final Object[] array3 = array;
            final int length = array3.length;
            int n = 0;
            BytecodeManager.incBytecodes(7);
            while (true) {
                final int n2 = n;
                final int n3 = length;
                BytecodeManager.incBytecodes(3);
                if (n2 >= n3) {
                    break;
                }
                final Object o = array3[n];
                BytecodeManager.incBytecodes(4);
                final ListIterator<Object> listIterator2 = listIterator;
                BytecodeManager.incBytecodes(2);
                listIterator2.next();
                BytecodeManager.incBytecodes(1);
                final ListIterator<Object> listIterator3 = listIterator;
                final Object o2 = o;
                BytecodeManager.incBytecodes(3);
                listIterator3.set(o2);
                ++n;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    void clear();
    
    boolean equals(final Object p0);
    
    int hashCode();
    
    E get(final int p0);
    
    E set(final int p0, final E p1);
    
    void add(final int p0, final E p1);
    
    E remove(final int p0);
    
    int indexOf(final Object p0);
    
    int lastIndexOf(final Object p0);
    
    ListIterator<E> listIterator();
    
    ListIterator<E> listIterator(final int p0);
    
    List<E> subList(final int p0, final int p1);
    
    default Spliterator<E> spliterator() {
        try {
            final int n = 16;
            BytecodeManager.incBytecodes(3);
            final Spliterator<Object> spliterator = Spliterators.spliterator((Collection<?>)this, n);
            BytecodeManager.incBytecodes(1);
            return (Spliterator<E>)spliterator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
