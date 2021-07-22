// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import aic2021.engine.BytecodeManager;

public abstract class EventListenerProxy<T extends EventListener> implements EventListener
{
    private final T listener;
    
    public EventListenerProxy(final T listener) {
        try {
            BytecodeManager.incBytecodes(2);
            this.listener = listener;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public T getListener() {
        try {
            final EventListener listener = this.listener;
            BytecodeManager.incBytecodes(3);
            return (T)listener;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
