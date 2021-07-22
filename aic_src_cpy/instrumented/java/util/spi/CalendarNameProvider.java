// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.spi;

import instrumented.java.util.Map;
import instrumented.java.util.Locale;
import aic2021.engine.BytecodeManager;

public abstract class CalendarNameProvider extends LocaleServiceProvider
{
    protected CalendarNameProvider() {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public abstract String getDisplayName(final String p0, final int p1, final int p2, final int p3, final Locale p4);
    
    public abstract Map<String, Integer> getDisplayNames(final String p0, final int p1, final int p2, final Locale p3);
}
