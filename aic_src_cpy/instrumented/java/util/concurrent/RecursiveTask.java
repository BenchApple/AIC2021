// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.concurrent;

import aic2021.engine.BytecodeManager;

public abstract class RecursiveTask<V> extends ForkJoinTask<V>
{
    private static final long serialVersionUID = 5232453952276485270L;
    V result;
    
    public RecursiveTask() {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    protected abstract V compute();
    
    @Override
    public final V getRawResult() {
        try {
            final V result = this.result;
            BytecodeManager.incBytecodes(3);
            return result;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    protected final void setRawResult(final V result) {
        try {
            this.result = result;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    protected final boolean exec() {
        try {
            BytecodeManager.incBytecodes(3);
            this.result = this.compute();
            BytecodeManager.incBytecodes(1);
            final boolean b = true;
            BytecodeManager.incBytecodes(2);
            return b;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
