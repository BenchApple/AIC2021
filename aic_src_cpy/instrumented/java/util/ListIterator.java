// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import java.util.Iterator;

public interface ListIterator<E> extends Iterator<E>
{
    boolean hasNext();
    
    E next();
    
    boolean hasPrevious();
    
    E previous();
    
    int nextIndex();
    
    int previousIndex();
    
    void remove();
    
    void set(final E p0);
    
    void add(final E p0);
}
