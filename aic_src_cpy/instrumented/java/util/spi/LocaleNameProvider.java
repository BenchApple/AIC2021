// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.spi;

import instrumented.java.util.Locale;
import aic2021.engine.BytecodeManager;

public abstract class LocaleNameProvider extends LocaleServiceProvider
{
    protected LocaleNameProvider() {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public abstract String getDisplayLanguage(final String p0, final Locale p1);
    
    public String getDisplayScript(final String s, final Locale locale) {
        try {
            final String s2 = null;
            BytecodeManager.incBytecodes(2);
            return s2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public abstract String getDisplayCountry(final String p0, final Locale p1);
    
    public abstract String getDisplayVariant(final String p0, final Locale p1);
}
