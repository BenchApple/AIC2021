// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import instrumented.java.util.function.DoubleConsumer;
import instrumented.java.util.function.LongConsumer;
import instrumented.java.util.function.Consumer;
import aic2021.engine.BytecodeManager;
import instrumented.java.util.function.IntConsumer;
import java.util.Iterator;

public interface PrimitiveIterator<T, T_CONS> extends Iterator<T>
{
    void forEachRemaining(final T_CONS p0);
    
    public interface OfInt extends PrimitiveIterator<Integer, IntConsumer>
    {
        int nextInt();
        
        default void forEachRemaining(final IntConsumer intConsumer) {
            try {
                BytecodeManager.incBytecodes(2);
                Objects.requireNonNull(intConsumer);
                BytecodeManager.incBytecodes(1);
                while (true) {
                    BytecodeManager.incBytecodes(2);
                    final boolean hasNext = this.hasNext();
                    BytecodeManager.incBytecodes(1);
                    if (!hasNext) {
                        break;
                    }
                    BytecodeManager.incBytecodes(3);
                    final int nextInt = this.nextInt();
                    BytecodeManager.incBytecodes(1);
                    intConsumer.accept(nextInt);
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        default Integer next() {
            try {
                final boolean enabled = Tripwire.ENABLED;
                BytecodeManager.incBytecodes(2);
                if (enabled) {
                    BytecodeManager.incBytecodes(2);
                    final Class<? extends OfInt> class1 = this.getClass();
                    final String s = "{0} calling PrimitiveIterator.OfInt.nextInt()";
                    BytecodeManager.incBytecodes(2);
                    Tripwire.trip(class1, s);
                }
                BytecodeManager.incBytecodes(2);
                final int nextInt = this.nextInt();
                BytecodeManager.incBytecodes(1);
                final Integer value = nextInt;
                BytecodeManager.incBytecodes(1);
                return value;
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
                    BytecodeManager.incBytecodes(2);
                    Objects.requireNonNull(consumer);
                    BytecodeManager.incBytecodes(1);
                    final boolean enabled = Tripwire.ENABLED;
                    BytecodeManager.incBytecodes(2);
                    if (enabled) {
                        BytecodeManager.incBytecodes(2);
                        final Class<? extends OfInt> class1 = this.getClass();
                        final String s = "{0} calling PrimitiveIterator.OfInt.forEachRemainingInt(action::accept)";
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
    
    public interface OfLong extends PrimitiveIterator<Long, LongConsumer>
    {
        long nextLong();
        
        default void forEachRemaining(final LongConsumer longConsumer) {
            try {
                BytecodeManager.incBytecodes(2);
                Objects.requireNonNull(longConsumer);
                BytecodeManager.incBytecodes(1);
                while (true) {
                    BytecodeManager.incBytecodes(2);
                    final boolean hasNext = this.hasNext();
                    BytecodeManager.incBytecodes(1);
                    if (!hasNext) {
                        break;
                    }
                    BytecodeManager.incBytecodes(3);
                    final long nextLong = this.nextLong();
                    BytecodeManager.incBytecodes(1);
                    longConsumer.accept(nextLong);
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        default Long next() {
            try {
                final boolean enabled = Tripwire.ENABLED;
                BytecodeManager.incBytecodes(2);
                if (enabled) {
                    BytecodeManager.incBytecodes(2);
                    final Class<? extends OfLong> class1 = this.getClass();
                    final String s = "{0} calling PrimitiveIterator.OfLong.nextLong()";
                    BytecodeManager.incBytecodes(2);
                    Tripwire.trip(class1, s);
                }
                BytecodeManager.incBytecodes(2);
                final long nextLong = this.nextLong();
                BytecodeManager.incBytecodes(1);
                final Long value = nextLong;
                BytecodeManager.incBytecodes(1);
                return value;
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
                    BytecodeManager.incBytecodes(2);
                    Objects.requireNonNull(consumer);
                    BytecodeManager.incBytecodes(1);
                    final boolean enabled = Tripwire.ENABLED;
                    BytecodeManager.incBytecodes(2);
                    if (enabled) {
                        BytecodeManager.incBytecodes(2);
                        final Class<? extends OfLong> class1 = this.getClass();
                        final String s = "{0} calling PrimitiveIterator.OfLong.forEachRemainingLong(action::accept)";
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
    
    public interface OfDouble extends PrimitiveIterator<Double, DoubleConsumer>
    {
        double nextDouble();
        
        default void forEachRemaining(final DoubleConsumer doubleConsumer) {
            try {
                BytecodeManager.incBytecodes(2);
                Objects.requireNonNull(doubleConsumer);
                BytecodeManager.incBytecodes(1);
                while (true) {
                    BytecodeManager.incBytecodes(2);
                    final boolean hasNext = this.hasNext();
                    BytecodeManager.incBytecodes(1);
                    if (!hasNext) {
                        break;
                    }
                    BytecodeManager.incBytecodes(3);
                    final double nextDouble = this.nextDouble();
                    BytecodeManager.incBytecodes(1);
                    doubleConsumer.accept(nextDouble);
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        default Double next() {
            try {
                final boolean enabled = Tripwire.ENABLED;
                BytecodeManager.incBytecodes(2);
                if (enabled) {
                    BytecodeManager.incBytecodes(2);
                    final Class<? extends OfDouble> class1 = this.getClass();
                    final String s = "{0} calling PrimitiveIterator.OfDouble.nextLong()";
                    BytecodeManager.incBytecodes(2);
                    Tripwire.trip(class1, s);
                }
                BytecodeManager.incBytecodes(2);
                final double nextDouble = this.nextDouble();
                BytecodeManager.incBytecodes(1);
                final Double value = nextDouble;
                BytecodeManager.incBytecodes(1);
                return value;
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
                    BytecodeManager.incBytecodes(2);
                    Objects.requireNonNull(consumer);
                    BytecodeManager.incBytecodes(1);
                    final boolean enabled = Tripwire.ENABLED;
                    BytecodeManager.incBytecodes(2);
                    if (enabled) {
                        BytecodeManager.incBytecodes(2);
                        final Class<? extends OfDouble> class1 = this.getClass();
                        final String s = "{0} calling PrimitiveIterator.OfDouble.forEachRemainingDouble(action::accept)";
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
