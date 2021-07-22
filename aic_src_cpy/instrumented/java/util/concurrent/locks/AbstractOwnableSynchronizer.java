// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.concurrent.locks;

import aic2021.engine.BytecodeManager;
import java.io.Serializable;

public abstract class AbstractOwnableSynchronizer implements Serializable
{
    private static final long serialVersionUID = 3737899427754241961L;
    private transient Thread exclusiveOwnerThread;
    
    protected AbstractOwnableSynchronizer() {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    protected final void setExclusiveOwnerThread(final Thread exclusiveOwnerThread) {
        try {
            this.exclusiveOwnerThread = exclusiveOwnerThread;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    protected final Thread getExclusiveOwnerThread() {
        try {
            final Thread exclusiveOwnerThread = this.exclusiveOwnerThread;
            BytecodeManager.incBytecodes(3);
            return exclusiveOwnerThread;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
