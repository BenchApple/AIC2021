// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import aic2021.engine.BytecodeManager;

public class InputMismatchException extends NoSuchElementException
{
    private static final long serialVersionUID = 8811230760997066428L;
    
    public InputMismatchException() {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public InputMismatchException(final String s) {
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
