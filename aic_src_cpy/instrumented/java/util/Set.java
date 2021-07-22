// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import aic2021.engine.BytecodeManager;
import java.util.Iterator;

public interface Set<E> extends Collection<E>
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
    
    boolean retainAll(final Collection<?> p0);
    
    boolean removeAll(final Collection<?> p0);
    
    void clear();
    
    boolean equals(final Object p0);
    
    int hashCode();
    
    default Spliterator<E> spliterator() {
        try {
            final int n = 1;
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
