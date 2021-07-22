// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import aic2021.engine.BytecodeManager;
import java.io.Serializable;

public class EventObject implements Serializable
{
    private static final long serialVersionUID = 5516075349620653480L;
    protected transient Object source;
    
    public EventObject(final Object source) {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            if (source == null) {
                final String s = "null source";
                BytecodeManager.incBytecodes(4);
                final IllegalArgumentException ex = new IllegalArgumentException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            this.source = source;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Object getSource() {
        try {
            final Object source = this.source;
            BytecodeManager.incBytecodes(3);
            return source;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public String toString() {
        try {
            BytecodeManager.incBytecodes(3);
            final StringBuilder sb = new StringBuilder();
            BytecodeManager.incBytecodes(2);
            final Class<? extends EventObject> class1 = this.getClass();
            BytecodeManager.incBytecodes(1);
            final String name = class1.getName();
            BytecodeManager.incBytecodes(1);
            final StringBuilder append = sb.append(name);
            final String str = "[source=";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append2 = append.append(str);
            final Object source = this.source;
            BytecodeManager.incBytecodes(3);
            final StringBuilder append3 = append2.append(source);
            final String str2 = "]";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append4 = append3.append(str2);
            BytecodeManager.incBytecodes(1);
            final String string = append4.toString();
            BytecodeManager.incBytecodes(1);
            return string;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
