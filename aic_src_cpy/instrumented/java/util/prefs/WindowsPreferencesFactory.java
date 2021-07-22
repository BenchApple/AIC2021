// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.prefs;

import aic2021.engine.BytecodeManager;

class WindowsPreferencesFactory implements PreferencesFactory
{
    WindowsPreferencesFactory() {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public Preferences userRoot() {
        try {
            final Preferences userRoot = WindowsPreferences.userRoot;
            BytecodeManager.incBytecodes(2);
            return userRoot;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public Preferences systemRoot() {
        try {
            final Preferences systemRoot = WindowsPreferences.systemRoot;
            BytecodeManager.incBytecodes(2);
            return systemRoot;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
