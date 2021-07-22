// 
// Decompiled by Procyon v0.5.36
// 

package java.util;

import instrumented.java.util.Objects;
import instrumented.java.util.function.Consumer;
import aic2021.engine.BytecodeManager;

public interface Iterator<E>
{
    boolean hasNext();
    
    E next();
    
    default void remove() {
        try {
            final String message = "remove";
            BytecodeManager.incBytecodes(4);
            final UnsupportedOperationException ex = new UnsupportedOperationException(message);
            BytecodeManager.incBytecodes(1);
            throw ex;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    default void forEachRemaining(final Consumer<? super E> consumer) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(consumer);
            BytecodeManager.incBytecodes(1);
            while (true) {
                BytecodeManager.incBytecodes(2);
                final boolean hasNext = this.hasNext();
                BytecodeManager.incBytecodes(1);
                if (!hasNext) {
                    break;
                }
                BytecodeManager.incBytecodes(3);
                final Object next = this.next();
                BytecodeManager.incBytecodes(1);
                consumer.accept((Object)next);
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
