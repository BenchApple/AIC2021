// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import aic2021.engine.BytecodeManager;
import java.io.Serializable;

public class LinkedHashSet<E> extends HashSet<E> implements Set<E>, Cloneable, Serializable
{
    private static final long serialVersionUID = -2851667679971038690L;
    
    public LinkedHashSet(final int n, final float n2) {
        try {
            final boolean b = true;
            BytecodeManager.incBytecodes(5);
            super(n, n2, b);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public LinkedHashSet(final int n) {
        try {
            final float n2 = 0.75f;
            final boolean b = true;
            BytecodeManager.incBytecodes(5);
            super(n, n2, b);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public LinkedHashSet() {
        try {
            final int n = 16;
            final float n2 = 0.75f;
            final boolean b = true;
            BytecodeManager.incBytecodes(5);
            super(n, n2, b);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public LinkedHashSet(final Collection<? extends E> collection) {
        try {
            final int n = 2;
            BytecodeManager.incBytecodes(4);
            final int a = n * collection.size();
            final int b = 11;
            BytecodeManager.incBytecodes(3);
            final int max = Math.max(a, b);
            final float n2 = 0.75f;
            final boolean b2 = true;
            BytecodeManager.incBytecodes(3);
            super(max, n2, b2);
            BytecodeManager.incBytecodes(3);
            this.addAll(collection);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public Spliterator<E> spliterator() {
        try {
            final int n = 17;
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
