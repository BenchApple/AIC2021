// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import aic2021.engine.BytecodeManager;

public class MissingResourceException extends RuntimeException
{
    private static final long serialVersionUID = -4876345176062000401L;
    private String className;
    private String key;
    
    public MissingResourceException(final String message, final String className, final String key) {
        try {
            BytecodeManager.incBytecodes(3);
            super(message);
            this.className = className;
            BytecodeManager.incBytecodes(3);
            this.key = key;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    MissingResourceException(final String message, final String className, final String key, final Throwable cause) {
        try {
            BytecodeManager.incBytecodes(4);
            super(message, cause);
            this.className = className;
            BytecodeManager.incBytecodes(3);
            this.key = key;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public String getClassName() {
        try {
            final String className = this.className;
            BytecodeManager.incBytecodes(3);
            return className;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public String getKey() {
        try {
            final String key = this.key;
            BytecodeManager.incBytecodes(3);
            return key;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
