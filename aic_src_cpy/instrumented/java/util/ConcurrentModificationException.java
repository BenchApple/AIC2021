// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import aic2021.engine.BytecodeManager;

public class ConcurrentModificationException extends RuntimeException
{
    private static final long serialVersionUID = -3666751008965953603L;
    
    public ConcurrentModificationException() {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public ConcurrentModificationException(final String message) {
        try {
            BytecodeManager.incBytecodes(3);
            super(message);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public ConcurrentModificationException(final Throwable cause) {
        try {
            BytecodeManager.incBytecodes(3);
            super(cause);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public ConcurrentModificationException(final String message, final Throwable cause) {
        try {
            BytecodeManager.incBytecodes(4);
            super(message, cause);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
