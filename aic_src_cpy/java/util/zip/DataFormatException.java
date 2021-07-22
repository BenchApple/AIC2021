// 
// Decompiled by Procyon v0.5.36
// 

package java.util.zip;

import aic2021.engine.BytecodeManager;

public class DataFormatException extends Exception
{
    private static final long serialVersionUID = 2219632870893641452L;
    
    public DataFormatException() {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public DataFormatException(final String message) {
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
