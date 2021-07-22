// 
// Decompiled by Procyon v0.5.36
// 

package java.util.zip;

import aic2021.engine.BytecodeManager;

public class ZipError extends InternalError
{
    private static final long serialVersionUID = 853973422266861979L;
    
    public ZipError(final String message) {
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
