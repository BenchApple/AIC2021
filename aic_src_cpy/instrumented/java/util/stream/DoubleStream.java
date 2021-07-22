// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.stream;

import java.util.Iterator;
import instrumented.java.util.function.DoubleSupplier;
import instrumented.java.util.Objects;
import instrumented.java.util.Arrays;
import instrumented.java.util.Spliterators;
import aic2021.engine.BytecodeManager;
import instrumented.java.util.Spliterator;
import instrumented.java.util.PrimitiveIterator;
import instrumented.java.util.DoubleSummaryStatistics;
import instrumented.java.util.function.BiConsumer;
import instrumented.java.util.function.ObjDoubleConsumer;
import instrumented.java.util.function.Supplier;
import instrumented.java.util.OptionalDouble;
import instrumented.java.util.function.DoubleBinaryOperator;
import instrumented.java.util.function.DoubleConsumer;
import instrumented.java.util.function.DoubleToLongFunction;
import instrumented.java.util.function.DoubleToIntFunction;
import instrumented.java.util.function.DoubleFunction;
import instrumented.java.util.function.DoubleUnaryOperator;
import instrumented.java.util.function.DoublePredicate;

public interface DoubleStream extends BaseStream<Double, DoubleStream>
{
    DoubleStream filter(final DoublePredicate p0);
    
    DoubleStream map(final DoubleUnaryOperator p0);
    
     <U> Stream<U> mapToObj(final DoubleFunction<? extends U> p0);
    
    IntStream mapToInt(final DoubleToIntFunction p0);
    
    LongStream mapToLong(final DoubleToLongFunction p0);
    
    DoubleStream flatMap(final DoubleFunction<? extends DoubleStream> p0);
    
    DoubleStream distinct();
    
    DoubleStream sorted();
    
    DoubleStream peek(final DoubleConsumer p0);
    
    DoubleStream limit(final long p0);
    
    DoubleStream skip(final long p0);
    
    void forEach(final DoubleConsumer p0);
    
    void forEachOrdered(final DoubleConsumer p0);
    
    double[] toArray();
    
    double reduce(final double p0, final DoubleBinaryOperator p1);
    
    OptionalDouble reduce(final DoubleBinaryOperator p0);
    
     <R> R collect(final Supplier<R> p0, final ObjDoubleConsumer<R> p1, final BiConsumer<R, R> p2);
    
    double sum();
    
    OptionalDouble min();
    
    OptionalDouble max();
    
    long count();
    
    OptionalDouble average();
    
    DoubleSummaryStatistics summaryStatistics();
    
    boolean anyMatch(final DoublePredicate p0);
    
    boolean allMatch(final DoublePredicate p0);
    
    boolean noneMatch(final DoublePredicate p0);
    
    OptionalDouble findFirst();
    
    OptionalDouble findAny();
    
    Stream<Double> boxed();
    
    DoubleStream sequential();
    
    DoubleStream parallel();
    
    PrimitiveIterator.OfDouble iterator();
    
    Spliterator.OfDouble spliterator();
    
    default Builder builder() {
        try {
            BytecodeManager.incBytecodes(3);
            final Streams.DoubleStreamBuilderImpl doubleStreamBuilderImpl = new Streams.DoubleStreamBuilderImpl();
            BytecodeManager.incBytecodes(1);
            return doubleStreamBuilderImpl;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    default DoubleStream empty() {
        try {
            BytecodeManager.incBytecodes(1);
            final Spliterator.OfDouble emptyDoubleSpliterator = Spliterators.emptyDoubleSpliterator();
            final boolean b = false;
            BytecodeManager.incBytecodes(2);
            final DoubleStream doubleStream = StreamSupport.doubleStream(emptyDoubleSpliterator, b);
            BytecodeManager.incBytecodes(1);
            return doubleStream;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    default DoubleStream of(final double n) {
        try {
            BytecodeManager.incBytecodes(4);
            final Streams.DoubleStreamBuilderImpl doubleStreamBuilderImpl = new Streams.DoubleStreamBuilderImpl(n);
            final boolean b = false;
            BytecodeManager.incBytecodes(2);
            final DoubleStream doubleStream = StreamSupport.doubleStream(doubleStreamBuilderImpl, b);
            BytecodeManager.incBytecodes(1);
            return doubleStream;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    default DoubleStream of(final double... array) {
        try {
            BytecodeManager.incBytecodes(2);
            final DoubleStream stream = Arrays.stream(array);
            BytecodeManager.incBytecodes(1);
            return stream;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    default DoubleStream iterate(final double n, final DoubleUnaryOperator doubleUnaryOperator) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(doubleUnaryOperator);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(5);
            final PrimitiveIterator.OfDouble ofDouble = new PrimitiveIterator.OfDouble() {
                double t = n;
                
                {
                    BytecodeManager.incBytecodes(5);
                }
                
                @Override
                public boolean hasNext() {
                    try {
                        final boolean b = true;
                        BytecodeManager.incBytecodes(2);
                        return b;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public double nextDouble() {
                    try {
                        final double t = this.t;
                        BytecodeManager.incBytecodes(3);
                        final DoubleUnaryOperator val$f = doubleUnaryOperator;
                        final double t2 = this.t;
                        BytecodeManager.incBytecodes(6);
                        this.t = val$f.applyAsDouble(t2);
                        BytecodeManager.incBytecodes(1);
                        final double n = t;
                        BytecodeManager.incBytecodes(2);
                        return n;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
            };
            BytecodeManager.incBytecodes(1);
            final PrimitiveIterator.OfDouble ofDouble2 = ofDouble;
            final int n2 = 1296;
            BytecodeManager.incBytecodes(3);
            final Spliterator.OfDouble spliteratorUnknownSize = Spliterators.spliteratorUnknownSize(ofDouble2, n2);
            final boolean b = false;
            BytecodeManager.incBytecodes(2);
            final DoubleStream doubleStream = StreamSupport.doubleStream(spliteratorUnknownSize, b);
            BytecodeManager.incBytecodes(1);
            return doubleStream;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    default DoubleStream generate(final DoubleSupplier doubleSupplier) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(doubleSupplier);
            BytecodeManager.incBytecodes(1);
            final long n = Long.MAX_VALUE;
            BytecodeManager.incBytecodes(5);
            final StreamSpliterators.InfiniteSupplyingSpliterator.OfDouble ofDouble = new StreamSpliterators.InfiniteSupplyingSpliterator.OfDouble(n, doubleSupplier);
            final boolean b = false;
            BytecodeManager.incBytecodes(2);
            final DoubleStream doubleStream = StreamSupport.doubleStream(ofDouble, b);
            BytecodeManager.incBytecodes(1);
            return doubleStream;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    default DoubleStream concat(final DoubleStream doubleStream, final DoubleStream doubleStream2) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(doubleStream);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(doubleStream2);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
            final Spliterator.OfDouble spliterator = doubleStream.spliterator();
            BytecodeManager.incBytecodes(2);
            final Spliterator.OfDouble spliterator2 = doubleStream2.spliterator();
            BytecodeManager.incBytecodes(1);
            final Streams.ConcatSpliterator.OfDouble ofDouble = new Streams.ConcatSpliterator.OfDouble(spliterator, spliterator2);
            BytecodeManager.incBytecodes(1);
            final Streams.ConcatSpliterator.OfDouble ofDouble2 = ofDouble;
            BytecodeManager.incBytecodes(3);
            final boolean parallel = doubleStream.isParallel();
            BytecodeManager.incBytecodes(1);
            boolean b = false;
            Label_0129: {
                if (!parallel) {
                    BytecodeManager.incBytecodes(2);
                    final boolean parallel2 = doubleStream2.isParallel();
                    BytecodeManager.incBytecodes(1);
                    if (!parallel2) {
                        b = false;
                        BytecodeManager.incBytecodes(1);
                        break Label_0129;
                    }
                }
                b = true;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
            final DoubleStream doubleStream3 = StreamSupport.doubleStream(ofDouble2, b);
            BytecodeManager.incBytecodes(1);
            final DoubleStream doubleStream4 = doubleStream3;
            BytecodeManager.incBytecodes(4);
            final Runnable composedClose = Streams.composedClose(doubleStream, doubleStream2);
            BytecodeManager.incBytecodes(1);
            final DoubleStream doubleStream5 = ((BaseStream<T, DoubleStream>)doubleStream4).onClose(composedClose);
            BytecodeManager.incBytecodes(2);
            return doubleStream5;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public interface Builder extends DoubleConsumer
    {
        void accept(final double p0);
        
        default Builder add(final double n) {
            try {
                BytecodeManager.incBytecodes(3);
                this.accept(n);
                BytecodeManager.incBytecodes(2);
                return this;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        DoubleStream build();
    }
}
