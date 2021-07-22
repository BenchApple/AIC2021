// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.spi;

import instrumented.java.util.Locale;
import aic2021.engine.BytecodeManager;

public abstract class LocaleServiceProvider
{
    protected LocaleServiceProvider() {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public abstract Locale[] getAvailableLocales();
    
    public boolean isSupportedLocale(Locale stripExtensions) {
        try {
            final Locale locale = stripExtensions;
            BytecodeManager.incBytecodes(2);
            stripExtensions = locale.stripExtensions();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            final Locale[] availableLocales = this.getAvailableLocales();
            final int length = availableLocales.length;
            int n = 0;
            BytecodeManager.incBytecodes(6);
            while (true) {
                final int n2 = n;
                final int n3 = length;
                BytecodeManager.incBytecodes(3);
                if (n2 >= n3) {
                    final boolean b = false;
                    BytecodeManager.incBytecodes(2);
                    return b;
                }
                final Locale locale2 = availableLocales[n];
                BytecodeManager.incBytecodes(4);
                final Locale locale3 = stripExtensions;
                final Locale locale4 = locale2;
                BytecodeManager.incBytecodes(3);
                final Locale stripExtensions2 = locale4.stripExtensions();
                BytecodeManager.incBytecodes(1);
                final boolean equals = locale3.equals(stripExtensions2);
                BytecodeManager.incBytecodes(1);
                if (equals) {
                    final boolean b2 = true;
                    BytecodeManager.incBytecodes(2);
                    return b2;
                }
                ++n;
                BytecodeManager.incBytecodes(2);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
