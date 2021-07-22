// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.stream;

import java.util.Iterator;
import instrumented.java.util.function.IntSupplier;
import instrumented.java.util.Objects;
import instrumented.java.util.Arrays;
import instrumented.java.util.Spliterators;
import aic2021.engine.BytecodeManager;
import instrumented.java.util.Spliterator;
import instrumented.java.util.PrimitiveIterator;
import instrumented.java.util.IntSummaryStatistics;
import instrumented.java.util.OptionalDouble;
import instrumented.java.util.function.BiConsumer;
import instrumented.java.util.function.ObjIntConsumer;
import instrumented.java.util.function.Supplier;
import instrumented.java.util.OptionalInt;
import instrumented.java.util.function.IntBinaryOperator;
import instrumented.java.util.function.IntConsumer;
import instrumented.java.util.function.IntToDoubleFunction;
import instrumented.java.util.function.IntToLongFunction;
import instrumented.java.util.function.IntFunction;
import instrumented.java.util.function.IntUnaryOperator;
import instrumented.java.util.function.IntPredicate;

public interface IntStream extends BaseStream<Integer, IntStream>
{
    IntStream filter(final IntPredicate p0);
    
    IntStream map(final IntUnaryOperator p0);
    
     <U> Stream<U> mapToObj(final IntFunction<? extends U> p0);
    
    LongStream mapToLong(final IntToLongFunction p0);
    
    DoubleStream mapToDouble(final IntToDoubleFunction p0);
    
    IntStream flatMap(final IntFunction<? extends IntStream> p0);
    
    IntStream distinct();
    
    IntStream sorted();
    
    IntStream peek(final IntConsumer p0);
    
    IntStream limit(final long p0);
    
    IntStream skip(final long p0);
    
    void forEach(final IntConsumer p0);
    
    void forEachOrdered(final IntConsumer p0);
    
    int[] toArray();
    
    int reduce(final int p0, final IntBinaryOperator p1);
    
    OptionalInt reduce(final IntBinaryOperator p0);
    
     <R> R collect(final Supplier<R> p0, final ObjIntConsumer<R> p1, final BiConsumer<R, R> p2);
    
    int sum();
    
    OptionalInt min();
    
    OptionalInt max();
    
    long count();
    
    OptionalDouble average();
    
    IntSummaryStatistics summaryStatistics();
    
    boolean anyMatch(final IntPredicate p0);
    
    boolean allMatch(final IntPredicate p0);
    
    boolean noneMatch(final IntPredicate p0);
    
    OptionalInt findFirst();
    
    OptionalInt findAny();
    
    LongStream asLongStream();
    
    DoubleStream asDoubleStream();
    
    Stream<Integer> boxed();
    
    IntStream sequential();
    
    IntStream parallel();
    
    PrimitiveIterator.OfInt iterator();
    
    Spliterator.OfInt spliterator();
    
    default Builder builder() {
        try {
            BytecodeManager.incBytecodes(3);
            final Streams.IntStreamBuilderImpl intStreamBuilderImpl = new Streams.IntStreamBuilderImpl();
            BytecodeManager.incBytecodes(1);
            return intStreamBuilderImpl;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    default IntStream empty() {
        try {
            BytecodeManager.incBytecodes(1);
            final Spliterator.OfInt emptyIntSpliterator = Spliterators.emptyIntSpliterator();
            final boolean b = false;
            BytecodeManager.incBytecodes(2);
            final IntStream intStream = StreamSupport.intStream(emptyIntSpliterator, b);
            BytecodeManager.incBytecodes(1);
            return intStream;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    default IntStream of(final int n) {
        try {
            BytecodeManager.incBytecodes(4);
            final Streams.IntStreamBuilderImpl intStreamBuilderImpl = new Streams.IntStreamBuilderImpl(n);
            final boolean b = false;
            BytecodeManager.incBytecodes(2);
            final IntStream intStream = StreamSupport.intStream(intStreamBuilderImpl, b);
            BytecodeManager.incBytecodes(1);
            return intStream;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    default IntStream of(final int... array) {
        try {
            BytecodeManager.incBytecodes(2);
            final IntStream stream = Arrays.stream(array);
            BytecodeManager.incBytecodes(1);
            return stream;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    default IntStream iterate(final int n, final IntUnaryOperator intUnaryOperator) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(intUnaryOperator);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(5);
            final PrimitiveIterator.OfInt ofInt = new PrimitiveIterator.OfInt() {
                int t = n;
                
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
                public int nextInt() {
                    try {
                        final int t = this.t;
                        BytecodeManager.incBytecodes(3);
                        final IntUnaryOperator val$f = intUnaryOperator;
                        final int t2 = this.t;
                        BytecodeManager.incBytecodes(6);
                        this.t = val$f.applyAsInt(t2);
                        BytecodeManager.incBytecodes(1);
                        final int n = t;
                        BytecodeManager.incBytecodes(2);
                        return n;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
            };
            BytecodeManager.incBytecodes(1);
            final PrimitiveIterator.OfInt ofInt2 = ofInt;
            final int n2 = 1296;
            BytecodeManager.incBytecodes(3);
            final Spliterator.OfInt spliteratorUnknownSize = Spliterators.spliteratorUnknownSize(ofInt2, n2);
            final boolean b = false;
            BytecodeManager.incBytecodes(2);
            final IntStream intStream = StreamSupport.intStream(spliteratorUnknownSize, b);
            BytecodeManager.incBytecodes(1);
            return intStream;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    default IntStream generate(final IntSupplier intSupplier) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(intSupplier);
            BytecodeManager.incBytecodes(1);
            final long n = Long.MAX_VALUE;
            BytecodeManager.incBytecodes(5);
            final StreamSpliterators.InfiniteSupplyingSpliterator.OfInt ofInt = new StreamSpliterators.InfiniteSupplyingSpliterator.OfInt(n, intSupplier);
            final boolean b = false;
            BytecodeManager.incBytecodes(2);
            final IntStream intStream = StreamSupport.intStream(ofInt, b);
            BytecodeManager.incBytecodes(1);
            return intStream;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    default IntStream range(final int n, final int n2) {
        try {
            BytecodeManager.incBytecodes(3);
            if (n >= n2) {
                BytecodeManager.incBytecodes(1);
                final IntStream empty = empty();
                BytecodeManager.incBytecodes(1);
                return empty;
            }
            final boolean b = false;
            BytecodeManager.incBytecodes(6);
            final Streams.RangeIntSpliterator rangeIntSpliterator = new Streams.RangeIntSpliterator(n, n2, b);
            final boolean b2 = false;
            BytecodeManager.incBytecodes(2);
            final IntStream intStream = StreamSupport.intStream(rangeIntSpliterator, b2);
            BytecodeManager.incBytecodes(1);
            return intStream;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    default IntStream rangeClosed(final int n, final int n2) {
        try {
            BytecodeManager.incBytecodes(3);
            if (n > n2) {
                BytecodeManager.incBytecodes(1);
                final IntStream empty = empty();
                BytecodeManager.incBytecodes(1);
                return empty;
            }
            final boolean b = true;
            BytecodeManager.incBytecodes(6);
            final Streams.RangeIntSpliterator rangeIntSpliterator = new Streams.RangeIntSpliterator(n, n2, b);
            final boolean b2 = false;
            BytecodeManager.incBytecodes(2);
            final IntStream intStream = StreamSupport.intStream(rangeIntSpliterator, b2);
            BytecodeManager.incBytecodes(1);
            return intStream;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    default IntStream concat(final IntStream intStream, final IntStream intStream2) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(intStream);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(intStream2);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
            final Spliterator.OfInt spliterator = intStream.spliterator();
            BytecodeManager.incBytecodes(2);
            final Spliterator.OfInt spliterator2 = intStream2.spliterator();
            BytecodeManager.incBytecodes(1);
            final Streams.ConcatSpliterator.OfInt ofInt = new Streams.ConcatSpliterator.OfInt(spliterator, spliterator2);
            BytecodeManager.incBytecodes(1);
            final Streams.ConcatSpliterator.OfInt ofInt2 = ofInt;
            BytecodeManager.incBytecodes(3);
            final boolean parallel = intStream.isParallel();
            BytecodeManager.incBytecodes(1);
            boolean b = false;
            Label_0129: {
                if (!parallel) {
                    BytecodeManager.incBytecodes(2);
                    final boolean parallel2 = intStream2.isParallel();
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
            final IntStream intStream3 = StreamSupport.intStream(ofInt2, b);
            BytecodeManager.incBytecodes(1);
            final IntStream intStream4 = intStream3;
            BytecodeManager.incBytecodes(4);
            final Runnable composedClose = Streams.composedClose(intStream, intStream2);
            BytecodeManager.incBytecodes(1);
            final IntStream intStream5 = ((BaseStream<T, IntStream>)intStream4).onClose(composedClose);
            BytecodeManager.incBytecodes(2);
            return intStream5;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public interface Builder extends IntConsumer
    {
        void accept(final int p0);
        
        default Builder add(final int n) {
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
        
        IntStream build();
    }
}
