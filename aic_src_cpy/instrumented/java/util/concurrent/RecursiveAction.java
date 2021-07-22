// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.concurrent;

import aic2021.engine.BytecodeManager;

public abstract class RecursiveAction extends ForkJoinTask<Void>
{
    private static final long serialVersionUID = 5232453952276485070L;
    
    public RecursiveAction() {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    protected abstract void compute();
    
    @Override
    public final Void getRawResult() {
        try {
            final Void void1 = null;
            BytecodeManager.incBytecodes(2);
            return void1;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    protected final void setRawResult(final Void void1) {
        try {
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    protected final boolean exec() {
        try {
            BytecodeManager.incBytecodes(2);
            this.compute();
            final boolean b = true;
            BytecodeManager.incBytecodes(2);
            return b;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
