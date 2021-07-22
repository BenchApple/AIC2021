// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.prefs;

import java.io.ObjectInputStream;
import java.io.NotSerializableException;
import java.io.ObjectOutputStream;
import aic2021.engine.BytecodeManager;
import instrumented.java.util.EventObject;

public class NodeChangeEvent extends EventObject
{
    private Preferences child;
    private static final long serialVersionUID = 8068949086596572957L;
    
    public NodeChangeEvent(final Preferences preferences, final Preferences child) {
        try {
            BytecodeManager.incBytecodes(3);
            super(preferences);
            this.child = child;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Preferences getParent() {
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
    
    public Preferences getChild() {
        try {
            final Preferences child = this.child;
            BytecodeManager.incBytecodes(3);
            return child;
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
