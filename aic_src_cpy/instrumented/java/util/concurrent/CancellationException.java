// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.concurrent;

import aic2021.engine.BytecodeManager;

public class CancellationException extends IllegalStateException
{
    private static final long serialVersionUID = -9202173006928992231L;
    
    public CancellationException() {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public CancellationException(final String s) {
        try {
            BytecodeManager.incBytecodes(3);
            super(s);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
