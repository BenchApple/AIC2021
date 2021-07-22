// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import aic2021.engine.BytecodeManager;

class RandomAccessSubList<E> extends SubList<E> implements RandomAccess
{
    RandomAccessSubList(final AbstractList<E> list, final int n, final int n2) {
        try {
            BytecodeManager.incBytecodes(5);
            super(list, n, n2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public List<E> subList(final int n, final int n2) {
        try {
            BytecodeManager.incBytecodes(6);
            final RandomAccessSubList list = new RandomAccessSubList((AbstractList<Object>)this, n, n2);
            BytecodeManager.incBytecodes(1);
            return list;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
