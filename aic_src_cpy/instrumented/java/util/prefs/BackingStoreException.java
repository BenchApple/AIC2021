// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.prefs;

import aic2021.engine.BytecodeManager;

public class BackingStoreException extends Exception
{
    private static final long serialVersionUID = 859796500401108469L;
    
    public BackingStoreException(final String message) {
        try {
            BytecodeManager.incBytecodes(3);
            super(message);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public BackingStoreException(final Throwable cause) {
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
