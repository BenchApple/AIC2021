// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.prefs;

import instrumented.java.util.EventListener;

@FunctionalInterface
public interface PreferenceChangeListener extends EventListener
{
    void preferenceChange(final PreferenceChangeEvent p0);
}
