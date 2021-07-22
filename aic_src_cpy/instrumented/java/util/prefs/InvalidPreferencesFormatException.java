// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.prefs;

import aic2021.engine.BytecodeManager;

public class InvalidPreferencesFormatException extends Exception
{
    private static final long serialVersionUID = -791715184232119669L;
    
    public InvalidPreferencesFormatException(final Throwable cause) {
        try {
            BytecodeManager.incBytecodes(3);
            super(cause);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public InvalidPreferencesFormatException(final String message) {
        try {
            BytecodeManager.incBytecodes(3);
            super(message);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public InvalidPreferencesFormatException(final String message, final Throwable cause) {
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
