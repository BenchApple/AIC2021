// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import instrumented.java.util.stream.StreamSupport;
import instrumented.java.util.stream.Stream;
import aic2021.engine.BytecodeManager;
import instrumented.java.util.function.Predicate;
import java.util.Iterator;

public interface Collection<E> extends Iterable<E>
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
    
    boolean removeAll(final Collection<?> p0);
    
    default boolean removeIf(final Predicate<? super E> predicate) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(predicate);
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
                final boolean test = predicate.test((Object)next);
                BytecodeManager.incBytecodes(1);
                if (!test) {
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
    
    boolean retainAll(final Collection<?> p0);
    
    void clear();
    
    boolean equals(final Object p0);
    
    int hashCode();
    
    default Spliterator<E> spliterator() {
        try {
            final int n = 0;
            BytecodeManager.incBytecodes(3);
            final Spliterator<Object> spliterator = Spliterators.spliterator((Collection<?>)this, n);
            BytecodeManager.incBytecodes(1);
            return (Spliterator<E>)spliterator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    default Stream<E> stream() {
        try {
            BytecodeManager.incBytecodes(2);
            final Spliterator<E> spliterator = this.spliterator();
            final boolean b = false;
            BytecodeManager.incBytecodes(2);
            final Stream<E> stream = StreamSupport.stream(spliterator, b);
            BytecodeManager.incBytecodes(1);
            return stream;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    default Stream<E> parallelStream() {
        try {
            BytecodeManager.incBytecodes(2);
            final Spliterator<E> spliterator = this.spliterator();
            final boolean b = true;
            BytecodeManager.incBytecodes(2);
            final Stream<E> stream = StreamSupport.stream(spliterator, b);
            BytecodeManager.incBytecodes(1);
            return stream;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
