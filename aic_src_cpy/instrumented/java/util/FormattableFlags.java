// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import aic2021.engine.BytecodeManager;

public class FormattableFlags
{
    public static final int LEFT_JUSTIFY = 1;
    public static final int UPPERCASE = 2;
    public static final int ALTERNATE = 4;
    
    private FormattableFlags() {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
