// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import instrumented.java.util.function.DoubleConsumer;
import instrumented.java.util.function.LongConsumer;
import instrumented.java.util.function.IntConsumer;
import aic2021.engine.BytecodeManager;
import instrumented.java.util.function.Consumer;

public interface Spliterator<T>
{
    public static final int ORDERED = 16;
    public static final int DISTINCT = 1;
    public static final int SORTED = 4;
    public static final int SIZED = 64;
    public static final int NONNULL = 256;
    public static final int IMMUTABLE = 1024;
    public static final int CONCURRENT = 4096;
    public static final int SUBSIZED = 16384;
    
    boolean tryAdvance(final Consumer<? super T> p0);
    
    default void forEachRemaining(final Consumer<? super T> consumer) {
        try {
            boolean tryAdvance;
            do {
                BytecodeManager.incBytecodes(3);
                tryAdvance = this.tryAdvance(consumer);
                BytecodeManager.incBytecodes(1);
            } while (tryAdvance);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    Spliterator<T> trySplit();
    
    long estimateSize();
    
    default long getExactSizeIfKnown() {
        try {
            BytecodeManager.incBytecodes(2);
            final int n = this.characteristics() & 0x40;
            BytecodeManager.incBytecodes(3);
            long estimateSize;
            if (n == 0) {
                estimateSize = -1L;
                BytecodeManager.incBytecodes(2);
            }
            else {
                BytecodeManager.incBytecodes(2);
                estimateSize = this.estimateSize();
            }
            BytecodeManager.incBytecodes(1);
            return estimateSize;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    int characteristics();
    
    default boolean hasCharacteristics(final int n) {
        try {
            BytecodeManager.incBytecodes(2);
            final int n2 = this.characteristics() & n;
            BytecodeManager.incBytecodes(4);
            boolean b;
            if (n2 == n) {
                b = true;
                BytecodeManager.incBytecodes(2);
            }
            else {
                b = false;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return b;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    default Comparator<? super T> getComparator() {
        try {
            BytecodeManager.incBytecodes(3);
            final IllegalStateException ex = new IllegalStateException();
            BytecodeManager.incBytecodes(1);
            throw ex;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public interface OfPrimitive<T, T_CONS, T_SPLITR extends OfPrimitive<T, T_CONS, T_SPLITR>> extends Spliterator<T>
    {
        T_SPLITR trySplit();
        
        boolean tryAdvance(final T_CONS p0);
        
        default void forEachRemaining(final T_CONS t_CONS) {
            try {
                boolean tryAdvance;
                do {
                    BytecodeManager.incBytecodes(3);
                    tryAdvance = this.tryAdvance(t_CONS);
                    BytecodeManager.incBytecodes(1);
                } while (tryAdvance);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    public interface OfInt extends OfPrimitive<Integer, IntConsumer, OfInt>
    {
        OfInt trySplit();
        
        boolean tryAdvance(final IntConsumer p0);
        
        default void forEachRemaining(final IntConsumer intConsumer) {
            try {
                boolean tryAdvance;
                do {
                    BytecodeManager.incBytecodes(3);
                    tryAdvance = this.tryAdvance(intConsumer);
                    BytecodeManager.incBytecodes(1);
                } while (tryAdvance);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        default boolean tryAdvance(final Consumer<? super Integer> consumer) {
            try {
                final boolean b = consumer instanceof IntConsumer;
                BytecodeManager.incBytecodes(3);
                if (b) {
                    final IntConsumer intConsumer = (IntConsumer)consumer;
                    BytecodeManager.incBytecodes(4);
                    final boolean tryAdvance = this.tryAdvance(intConsumer);
                    BytecodeManager.incBytecodes(1);
                    return tryAdvance;
                }
                final boolean enabled = Tripwire.ENABLED;
                BytecodeManager.incBytecodes(2);
                if (enabled) {
                    BytecodeManager.incBytecodes(2);
                    final Class<? extends OfInt> class1 = this.getClass();
                    final String s = "{0} calling Spliterator.OfInt.tryAdvance((IntConsumer) action::accept)";
                    BytecodeManager.incBytecodes(2);
                    Tripwire.trip(class1, s);
                }
                BytecodeManager.incBytecodes(4);
                consumer.getClass();
                final IntConsumer intConsumer2 = consumer::accept;
                BytecodeManager.incBytecodes(2);
                final boolean tryAdvance2 = this.tryAdvance(intConsumer2);
                BytecodeManager.incBytecodes(1);
                return tryAdvance2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        default void forEachRemaining(final Consumer<? super Integer> consumer) {
            try {
                final boolean b = consumer instanceof IntConsumer;
                BytecodeManager.incBytecodes(3);
                if (b) {
                    final IntConsumer intConsumer = (IntConsumer)consumer;
                    BytecodeManager.incBytecodes(4);
                    this.forEachRemaining(intConsumer);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    final boolean enabled = Tripwire.ENABLED;
                    BytecodeManager.incBytecodes(2);
                    if (enabled) {
                        BytecodeManager.incBytecodes(2);
                        final Class<? extends OfInt> class1 = this.getClass();
                        final String s = "{0} calling Spliterator.OfInt.forEachRemaining((IntConsumer) action::accept)";
                        BytecodeManager.incBytecodes(2);
                        Tripwire.trip(class1, s);
                    }
                    BytecodeManager.incBytecodes(4);
                    consumer.getClass();
                    final IntConsumer intConsumer2 = consumer::accept;
                    BytecodeManager.incBytecodes(2);
                    this.forEachRemaining(intConsumer2);
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    public interface OfLong extends OfPrimitive<Long, LongConsumer, OfLong>
    {
        OfLong trySplit();
        
        boolean tryAdvance(final LongConsumer p0);
        
        default void forEachRemaining(final LongConsumer longConsumer) {
            try {
                boolean tryAdvance;
                do {
                    BytecodeManager.incBytecodes(3);
                    tryAdvance = this.tryAdvance(longConsumer);
                    BytecodeManager.incBytecodes(1);
                } while (tryAdvance);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        default boolean tryAdvance(final Consumer<? super Long> consumer) {
            try {
                final boolean b = consumer instanceof LongConsumer;
                BytecodeManager.incBytecodes(3);
                if (b) {
                    final LongConsumer longConsumer = (LongConsumer)consumer;
                    BytecodeManager.incBytecodes(4);
                    final boolean tryAdvance = this.tryAdvance(longConsumer);
                    BytecodeManager.incBytecodes(1);
                    return tryAdvance;
                }
                final boolean enabled = Tripwire.ENABLED;
                BytecodeManager.incBytecodes(2);
                if (enabled) {
                    BytecodeManager.incBytecodes(2);
                    final Class<? extends OfLong> class1 = this.getClass();
                    final String s = "{0} calling Spliterator.OfLong.tryAdvance((LongConsumer) action::accept)";
                    BytecodeManager.incBytecodes(2);
                    Tripwire.trip(class1, s);
                }
                BytecodeManager.incBytecodes(4);
                consumer.getClass();
                final LongConsumer longConsumer2 = consumer::accept;
                BytecodeManager.incBytecodes(2);
                final boolean tryAdvance2 = this.tryAdvance(longConsumer2);
                BytecodeManager.incBytecodes(1);
                return tryAdvance2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        default void forEachRemaining(final Consumer<? super Long> consumer) {
            try {
                final boolean b = consumer instanceof LongConsumer;
                BytecodeManager.incBytecodes(3);
                if (b) {
                    final LongConsumer longConsumer = (LongConsumer)consumer;
                    BytecodeManager.incBytecodes(4);
                    this.forEachRemaining(longConsumer);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    final boolean enabled = Tripwire.ENABLED;
                    BytecodeManager.incBytecodes(2);
                    if (enabled) {
                        BytecodeManager.incBytecodes(2);
                        final Class<? extends OfLong> class1 = this.getClass();
                        final String s = "{0} calling Spliterator.OfLong.forEachRemaining((LongConsumer) action::accept)";
                        BytecodeManager.incBytecodes(2);
                        Tripwire.trip(class1, s);
                    }
                    BytecodeManager.incBytecodes(4);
                    consumer.getClass();
                    final LongConsumer longConsumer2 = consumer::accept;
                    BytecodeManager.incBytecodes(2);
                    this.forEachRemaining(longConsumer2);
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    public interface OfDouble extends OfPrimitive<Double, DoubleConsumer, OfDouble>
    {
        OfDouble trySplit();
        
        boolean tryAdvance(final DoubleConsumer p0);
        
        default void forEachRemaining(final DoubleConsumer doubleConsumer) {
            try {
                boolean tryAdvance;
                do {
                    BytecodeManager.incBytecodes(3);
                    tryAdvance = this.tryAdvance(doubleConsumer);
                    BytecodeManager.incBytecodes(1);
                } while (tryAdvance);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        default boolean tryAdvance(final Consumer<? super Double> consumer) {
            try {
                final boolean b = consumer instanceof DoubleConsumer;
                BytecodeManager.incBytecodes(3);
                if (b) {
                    final DoubleConsumer doubleConsumer = (DoubleConsumer)consumer;
                    BytecodeManager.incBytecodes(4);
                    final boolean tryAdvance = this.tryAdvance(doubleConsumer);
                    BytecodeManager.incBytecodes(1);
                    return tryAdvance;
                }
                final boolean enabled = Tripwire.ENABLED;
                BytecodeManager.incBytecodes(2);
                if (enabled) {
                    BytecodeManager.incBytecodes(2);
                    final Class<? extends OfDouble> class1 = this.getClass();
                    final String s = "{0} calling Spliterator.OfDouble.tryAdvance((DoubleConsumer) action::accept)";
                    BytecodeManager.incBytecodes(2);
                    Tripwire.trip(class1, s);
                }
                BytecodeManager.incBytecodes(4);
                consumer.getClass();
                final DoubleConsumer doubleConsumer2 = consumer::accept;
                BytecodeManager.incBytecodes(2);
                final boolean tryAdvance2 = this.tryAdvance(doubleConsumer2);
                BytecodeManager.incBytecodes(1);
                return tryAdvance2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        default void forEachRemaining(final Consumer<? super Double> consumer) {
            try {
                final boolean b = consumer instanceof DoubleConsumer;
                BytecodeManager.incBytecodes(3);
                if (b) {
                    final DoubleConsumer doubleConsumer = (DoubleConsumer)consumer;
                    BytecodeManager.incBytecodes(4);
                    this.forEachRemaining(doubleConsumer);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    final boolean enabled = Tripwire.ENABLED;
                    BytecodeManager.incBytecodes(2);
                    if (enabled) {
                        BytecodeManager.incBytecodes(2);
                        final Class<? extends OfDouble> class1 = this.getClass();
                        final String s = "{0} calling Spliterator.OfDouble.forEachRemaining((DoubleConsumer) action::accept)";
                        BytecodeManager.incBytecodes(2);
                        Tripwire.trip(class1, s);
                    }
                    BytecodeManager.incBytecodes(4);
                    consumer.getClass();
                    final DoubleConsumer doubleConsumer2 = consumer::accept;
                    BytecodeManager.incBytecodes(2);
                    this.forEachRemaining(doubleConsumer2);
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
}
