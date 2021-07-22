// 
// Decompiled by Procyon v0.5.36
// 

package java.util.jar;

import aic2021.engine.BytecodeManager;
import java.util.zip.ZipException;

public class JarException extends ZipException
{
    private static final long serialVersionUID = 7159778400963954473L;
    
    public JarException() {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public JarException(final String s) {
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
