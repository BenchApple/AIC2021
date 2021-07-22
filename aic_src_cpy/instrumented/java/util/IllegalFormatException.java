// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import aic2021.engine.BytecodeManager;

public class IllegalFormatException extends IllegalArgumentException
{
    private static final long serialVersionUID = 18830826L;
    
    IllegalFormatException() {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
