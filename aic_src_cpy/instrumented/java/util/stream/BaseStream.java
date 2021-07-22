// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.stream;

import instrumented.java.util.Spliterator;
import java.util.Iterator;

public interface BaseStream<T, S extends BaseStream<T, S>> extends AutoCloseable
{
    Iterator<T> iterator();
    
    Spliterator<T> spliterator();
    
    boolean isParallel();
    
    S sequential();
    
    S parallel();
    
    S unordered();
    
    S onClose(final Runnable p0);
    
    void close();
}
