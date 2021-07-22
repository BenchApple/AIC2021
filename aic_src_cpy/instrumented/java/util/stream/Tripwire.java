// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.stream;

import java.security.PrivilegedAction;
import java.security.AccessController;
import sun.util.logging.PlatformLogger;
import aic2021.engine.BytecodeManager;

final class Tripwire
{
    private static final String TRIPWIRE_PROPERTY = "org.openjdk.java.util.stream.tripwire";
    static final boolean ENABLED;
    
    private Tripwire() {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static void trip(final Class<?> clazz, final String msg) {
        try {
            BytecodeManager.incBytecodes(2);
            final String name = clazz.getName();
            BytecodeManager.incBytecodes(1);
            final PlatformLogger logger = PlatformLogger.getLogger(name);
            final Object[] params = { null };
            final int n = 0;
            BytecodeManager.incBytecodes(6);
            params[n] = clazz.getName();
            BytecodeManager.incBytecodes(2);
            logger.warning(msg, params);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static {
        try {
            final String name;
            final boolean b;
            final Object o;
            final PrivilegedAction<Object> action = () -> {
                try {
                    BytecodeManager.incBytecodes(2);
                    Boolean.getBoolean(name);
                    BytecodeManager.incBytecodes(1);
                    b;
                    BytecodeManager.incBytecodes(1);
                    return o;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            BytecodeManager.incBytecodes(1);
            final Boolean b2 = AccessController.doPrivileged((PrivilegedAction<Boolean>)action);
            BytecodeManager.incBytecodes(2);
            ENABLED = b2;
            BytecodeManager.incBytecodes(2);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
