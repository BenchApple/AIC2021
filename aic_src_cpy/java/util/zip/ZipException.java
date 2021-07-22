// 
// Decompiled by Procyon v0.5.36
// 

package java.util.zip;

import aic2021.engine.BytecodeManager;
import java.io.IOException;

public class ZipException extends IOException
{
    private static final long serialVersionUID = 8000196834066748623L;
    
    public ZipException() {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public ZipException(final String message) {
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
