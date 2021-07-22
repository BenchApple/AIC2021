// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import aic2021.engine.BytecodeManager;

public class ServiceConfigurationError extends Error
{
    private static final long serialVersionUID = 74132770414881L;
    
    public ServiceConfigurationError(final String message) {
        try {
            BytecodeManager.incBytecodes(3);
            super(message);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public ServiceConfigurationError(final String message, final Throwable cause) {
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
