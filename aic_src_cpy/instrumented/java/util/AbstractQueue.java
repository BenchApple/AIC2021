// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import java.util.Iterator;
import aic2021.engine.BytecodeManager;

public abstract class AbstractQueue<E> extends AbstractCollection<E> implements Queue<E>
{
    protected AbstractQueue() {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean add(final E e) {
        try {
            BytecodeManager.incBytecodes(3);
            final boolean offer = this.offer(e);
            BytecodeManager.incBytecodes(1);
            if (offer) {
                final boolean b = true;
                BytecodeManager.incBytecodes(2);
                return b;
            }
            final String s = "Queue full";
            BytecodeManager.incBytecodes(4);
            final IllegalStateException ex = new IllegalStateException(s);
            BytecodeManager.incBytecodes(1);
            throw ex;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public E remove() {
        try {
            BytecodeManager.incBytecodes(2);
            final E poll = this.poll();
            BytecodeManager.incBytecodes(1);
            final E e = poll;
            BytecodeManager.incBytecodes(2);
            if (e != null) {
                final E e2 = poll;
                BytecodeManager.incBytecodes(2);
                return e2;
            }
            BytecodeManager.incBytecodes(3);
            final NoSuchElementException ex = new NoSuchElementException();
            BytecodeManager.incBytecodes(1);
            throw ex;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public E element() {
        try {
            BytecodeManager.incBytecodes(2);
            final E peek = this.peek();
            BytecodeManager.incBytecodes(1);
            final E e = peek;
            BytecodeManager.incBytecodes(2);
            if (e != null) {
                final E e2 = peek;
                BytecodeManager.incBytecodes(2);
                return e2;
            }
            BytecodeManager.incBytecodes(3);
            final NoSuchElementException ex = new NoSuchElementException();
            BytecodeManager.incBytecodes(1);
            throw ex;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void clear() {
        try {
            while (true) {
                BytecodeManager.incBytecodes(2);
                final Object poll = this.poll();
                BytecodeManager.incBytecodes(1);
                if (poll == null) {
                    break;
                }
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean addAll(final Collection<? extends E> collection) {
        try {
            BytecodeManager.incBytecodes(2);
            if (collection == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(3);
            if (collection == this) {
                BytecodeManager.incBytecodes(3);
                final IllegalArgumentException ex2 = new IllegalArgumentException();
                BytecodeManager.incBytecodes(1);
                throw ex2;
            }
            boolean b = false;
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            final Iterator<E> iterator = collection.iterator();
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
                final E e = next;
                BytecodeManager.incBytecodes(3);
                final boolean add = this.add(e);
                BytecodeManager.incBytecodes(1);
                if (add) {
                    b = true;
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(1);
            }
            final boolean b2 = b;
            BytecodeManager.incBytecodes(2);
            return b2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
