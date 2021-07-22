// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import java.io.ObjectInputStream;
import java.io.NotSerializableException;
import java.io.ObjectOutputStream;
import aic2021.engine.BytecodeManager;
import java.io.IOException;

public class InvalidPropertiesFormatException extends IOException
{
    private static final long serialVersionUID = 7763056076009360219L;
    
    public InvalidPropertiesFormatException(final Throwable cause) {
        try {
            BytecodeManager.incBytecodes(3);
            String string;
            if (cause == null) {
                string = null;
                BytecodeManager.incBytecodes(2);
            }
            else {
                BytecodeManager.incBytecodes(2);
                string = cause.toString();
            }
            BytecodeManager.incBytecodes(1);
            super(string);
            BytecodeManager.incBytecodes(3);
            this.initCause(cause);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public InvalidPropertiesFormatException(final String message) {
        try {
            BytecodeManager.incBytecodes(3);
            super(message);
            BytecodeManager.incBytecodes(1);
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
