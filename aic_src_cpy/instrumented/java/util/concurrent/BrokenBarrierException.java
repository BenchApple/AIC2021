// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.concurrent;

import aic2021.engine.BytecodeManager;

public class BrokenBarrierException extends Exception
{
    private static final long serialVersionUID = 7117394618823254244L;
    
    public BrokenBarrierException() {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BrokenBarrierException(final String message) {
        try {
            BytecodeManager.incBytecodes(3);
            super(message);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
