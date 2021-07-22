// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

public interface Queue<E> extends Collection<E>
{
    boolean add(final E p0);
    
    boolean offer(final E p0);
    
    E remove();
    
    E poll();
    
    E element();
    
    E peek();
}
