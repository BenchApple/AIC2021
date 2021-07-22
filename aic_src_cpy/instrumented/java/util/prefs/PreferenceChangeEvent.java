// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.prefs;

import java.io.ObjectInputStream;
import java.io.NotSerializableException;
import java.io.ObjectOutputStream;
import aic2021.engine.BytecodeManager;
import instrumented.java.util.EventObject;

public class PreferenceChangeEvent extends EventObject
{
    private String key;
    private String newValue;
    private static final long serialVersionUID = 793724513368024975L;
    
    public PreferenceChangeEvent(final Preferences preferences, final String key, final String newValue) {
        try {
            BytecodeManager.incBytecodes(3);
            super(preferences);
            this.key = key;
            BytecodeManager.incBytecodes(3);
            this.newValue = newValue;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Preferences getNode() {
        try {
            BytecodeManager.incBytecodes(2);
            final Preferences preferences = (Preferences)this.getSource();
            BytecodeManager.incBytecodes(2);
            return preferences;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public String getKey() {
        try {
            final String key = this.key;
            BytecodeManager.incBytecodes(3);
            return key;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public String getNewValue() {
        try {
            final String newValue = this.newValue;
            BytecodeManager.incBytecodes(3);
            return newValue;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) throws NotSerializableException {
        try {
            final String classname = "Not serializable.";
            BytecodeManager.incBytecodes(4);
            final NotSerializableException ex = new NotSerializableException(classname);
            BytecodeManager.incBytecodes(1);
            throw ex;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void readObject(final ObjectInputStream objectInputStream) throws NotSerializableException {
        try {
            final String classname = "Not serializable.";
            BytecodeManager.incBytecodes(4);
            final NotSerializableException ex = new NotSerializableException(classname);
            BytecodeManager.incBytecodes(1);
            throw ex;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
