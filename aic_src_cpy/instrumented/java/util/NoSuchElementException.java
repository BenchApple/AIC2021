// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import aic2021.engine.BytecodeManager;

public class NoSuchElementException extends RuntimeException
{
    private static final long serialVersionUID = 6769829250639411880L;
    
    public NoSuchElementException() {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public NoSuchElementException(final String message) {
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
