// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.concurrent;

import aic2021.engine.BytecodeManager;

public class TimeoutException extends Exception
{
    private static final long serialVersionUID = 1900926677490660714L;
    
    public TimeoutException() {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public TimeoutException(final String message) {
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
