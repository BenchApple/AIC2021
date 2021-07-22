// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.spi;

import instrumented.java.util.Locale;
import aic2021.engine.BytecodeManager;

public abstract class TimeZoneNameProvider extends LocaleServiceProvider
{
    protected TimeZoneNameProvider() {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public abstract String getDisplayName(final String p0, final boolean p1, final int p2, final Locale p3);
    
    public String getGenericDisplayName(final String s, final int n, final Locale locale) {
        try {
            final String s2 = null;
            BytecodeManager.incBytecodes(2);
            return s2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
