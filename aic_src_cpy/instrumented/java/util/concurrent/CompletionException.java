// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.concurrent;

import aic2021.engine.BytecodeManager;

public class CompletionException extends RuntimeException
{
    private static final long serialVersionUID = 7830266012832686185L;
    
    protected CompletionException() {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    protected CompletionException(final String message) {
        try {
            BytecodeManager.incBytecodes(3);
            super(message);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public CompletionException(final String message, final Throwable cause) {
        try {
            BytecodeManager.incBytecodes(4);
            super(message, cause);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public CompletionException(final Throwable cause) {
        try {
            BytecodeManager.incBytecodes(3);
            super(cause);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
