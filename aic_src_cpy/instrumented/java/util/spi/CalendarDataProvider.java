// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.spi;

import instrumented.java.util.Locale;
import aic2021.engine.BytecodeManager;

public abstract class CalendarDataProvider extends LocaleServiceProvider
{
    protected CalendarDataProvider() {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public abstract int getFirstDayOfWeek(final Locale p0);
    
    public abstract int getMinimalDaysInFirstWeek(final Locale p0);
}
