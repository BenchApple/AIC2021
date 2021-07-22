// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import aic2021.engine.BytecodeManager;

public interface SortedSet<E> extends Set<E>
{
    Comparator<? super E> comparator();
    
    SortedSet<E> subSet(final E p0, final E p1);
    
    SortedSet<E> headSet(final E p0);
    
    SortedSet<E> tailSet(final E p0);
    
    E first();
    
    E last();
    
    default Spliterator<E> spliterator() {
        try {
            final int n = 21;
            BytecodeManager.incBytecodes(6);
            final Spliterators.IteratorSpliterator<E> iteratorSpliterator = new Spliterators.IteratorSpliterator<E>(this, n) {
                {
                    BytecodeManager.incBytecodes(1);
                }
                
                @Override
                public Comparator<? super E> getComparator() {
                    try {
                        final SortedSet this$0 = SortedSet.this;
                        BytecodeManager.incBytecodes(3);
                        final Comparator<? super E> comparator = this$0.comparator();
                        BytecodeManager.incBytecodes(1);
                        return comparator;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
            };
            BytecodeManager.incBytecodes(1);
            return iteratorSpliterator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
