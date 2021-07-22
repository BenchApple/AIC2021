// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.stream;

import instrumented.java.util.Objects;
import instrumented.java.util.function.DoubleConsumer;
import instrumented.java.util.function.LongConsumer;
import instrumented.java.util.function.IntConsumer;
import aic2021.engine.BytecodeManager;
import instrumented.java.util.function.Consumer;

interface Sink<T> extends Consumer<T>
{
    default void begin(final long n) {
        try {
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    default void end() {
        try {
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    default boolean cancellationRequested() {
        try {
            final boolean b = false;
            BytecodeManager.incBytecodes(2);
            return b;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    default void accept(final int n) {
        try {
            final String s = "called wrong accept method";
            BytecodeManager.incBytecodes(4);
            final IllegalStateException ex = new IllegalStateException(s);
            BytecodeManager.incBytecodes(1);
            throw ex;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    default void accept(final long n) {
        try {
            final String s = "called wrong accept method";
            BytecodeManager.incBytecodes(4);
            final IllegalStateException ex = new IllegalStateException(s);
            BytecodeManager.incBytecodes(1);
            throw ex;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    default void accept(final double n) {
        try {
            final String s = "called wrong accept method";
            BytecodeManager.incBytecodes(4);
            final IllegalStateException ex = new IllegalStateException(s);
            BytecodeManager.incBytecodes(1);
            throw ex;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public interface OfInt extends Sink<Integer>, IntConsumer
    {
        void accept(final int p0);
        
        default void accept(final Integer n) {
            try {
                final boolean enabled = Tripwire.ENABLED;
                BytecodeManager.incBytecodes(2);
                if (enabled) {
                    BytecodeManager.incBytecodes(2);
                    final Class<? extends OfInt> class1 = this.getClass();
                    final String s = "{0} calling Sink.OfInt.accept(Integer)";
                    BytecodeManager.incBytecodes(2);
                    Tripwire.trip(class1, s);
                }
                BytecodeManager.incBytecodes(3);
                final int intValue = n;
                BytecodeManager.incBytecodes(1);
                this.accept(intValue);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    public interface OfLong extends Sink<Long>, LongConsumer
    {
        void accept(final long p0);
        
        default void accept(final Long n) {
            try {
                final boolean enabled = Tripwire.ENABLED;
                BytecodeManager.incBytecodes(2);
                if (enabled) {
                    BytecodeManager.incBytecodes(2);
                    final Class<? extends OfLong> class1 = this.getClass();
                    final String s = "{0} calling Sink.OfLong.accept(Long)";
                    BytecodeManager.incBytecodes(2);
                    Tripwire.trip(class1, s);
                }
                BytecodeManager.incBytecodes(3);
                final long longValue = n;
                BytecodeManager.incBytecodes(1);
                this.accept(longValue);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    public interface OfDouble extends Sink<Double>, DoubleConsumer
    {
        void accept(final double p0);
        
        default void accept(final Double n) {
            try {
                final boolean enabled = Tripwire.ENABLED;
                BytecodeManager.incBytecodes(2);
                if (enabled) {
                    BytecodeManager.incBytecodes(2);
                    final Class<? extends OfDouble> class1 = this.getClass();
                    final String s = "{0} calling Sink.OfDouble.accept(Double)";
                    BytecodeManager.incBytecodes(2);
                    Tripwire.trip(class1, s);
                }
                BytecodeManager.incBytecodes(3);
                final double doubleValue = n;
                BytecodeManager.incBytecodes(1);
                this.accept(doubleValue);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    public abstract static class ChainedReference<T, E_OUT> implements Sink<T>
    {
        protected final Sink<? super E_OUT> downstream;
        
        public ChainedReference(final Sink<? super E_OUT> sink) {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(3);
                this.downstream = Objects.requireNonNull(sink);
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void begin(final long n) {
            try {
                final Sink<? super E_OUT> downstream = this.downstream;
                BytecodeManager.incBytecodes(4);
                downstream.begin(n);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void end() {
            try {
                final Sink<? super E_OUT> downstream = this.downstream;
                BytecodeManager.incBytecodes(3);
                downstream.end();
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean cancellationRequested() {
            try {
                final Sink<? super E_OUT> downstream = this.downstream;
                BytecodeManager.incBytecodes(3);
                final boolean cancellationRequested = downstream.cancellationRequested();
                BytecodeManager.incBytecodes(1);
                return cancellationRequested;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    public abstract static class ChainedInt<E_OUT> implements OfInt
    {
        protected final Sink<? super E_OUT> downstream;
        
        public ChainedInt(final Sink<? super E_OUT> sink) {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(3);
                this.downstream = Objects.requireNonNull(sink);
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void begin(final long n) {
            try {
                final Sink<? super E_OUT> downstream = this.downstream;
                BytecodeManager.incBytecodes(4);
                downstream.begin(n);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void end() {
            try {
                final Sink<? super E_OUT> downstream = this.downstream;
                BytecodeManager.incBytecodes(3);
                downstream.end();
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean cancellationRequested() {
            try {
                final Sink<? super E_OUT> downstream = this.downstream;
                BytecodeManager.incBytecodes(3);
                final boolean cancellationRequested = downstream.cancellationRequested();
                BytecodeManager.incBytecodes(1);
                return cancellationRequested;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    public abstract static class ChainedLong<E_OUT> implements OfLong
    {
        protected final Sink<? super E_OUT> downstream;
        
        public ChainedLong(final Sink<? super E_OUT> sink) {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(3);
                this.downstream = Objects.requireNonNull(sink);
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void begin(final long n) {
            try {
                final Sink<? super E_OUT> downstream = this.downstream;
                BytecodeManager.incBytecodes(4);
                downstream.begin(n);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void end() {
            try {
                final Sink<? super E_OUT> downstream = this.downstream;
                BytecodeManager.incBytecodes(3);
                downstream.end();
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean cancellationRequested() {
            try {
                final Sink<? super E_OUT> downstream = this.downstream;
                BytecodeManager.incBytecodes(3);
                final boolean cancellationRequested = downstream.cancellationRequested();
                BytecodeManager.incBytecodes(1);
                return cancellationRequested;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    public abstract static class ChainedDouble<E_OUT> implements OfDouble
    {
        protected final Sink<? super E_OUT> downstream;
        
        public ChainedDouble(final Sink<? super E_OUT> sink) {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(3);
                this.downstream = Objects.requireNonNull(sink);
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void begin(final long n) {
            try {
                final Sink<? super E_OUT> downstream = this.downstream;
                BytecodeManager.incBytecodes(4);
                downstream.begin(n);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void end() {
            try {
                final Sink<? super E_OUT> downstream = this.downstream;
                BytecodeManager.incBytecodes(3);
                downstream.end();
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean cancellationRequested() {
            try {
                final Sink<? super E_OUT> downstream = this.downstream;
                BytecodeManager.incBytecodes(3);
                final boolean cancellationRequested = downstream.cancellationRequested();
                BytecodeManager.incBytecodes(1);
                return cancellationRequested;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
}
