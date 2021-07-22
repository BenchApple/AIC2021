// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.stream;

import java.util.Iterator;
import instrumented.java.util.function.LongSupplier;
import instrumented.java.util.Objects;
import instrumented.java.util.Arrays;
import instrumented.java.util.Spliterators;
import aic2021.engine.BytecodeManager;
import instrumented.java.util.Spliterator;
import instrumented.java.util.PrimitiveIterator;
import instrumented.java.util.LongSummaryStatistics;
import instrumented.java.util.OptionalDouble;
import instrumented.java.util.function.BiConsumer;
import instrumented.java.util.function.ObjLongConsumer;
import instrumented.java.util.function.Supplier;
import instrumented.java.util.OptionalLong;
import instrumented.java.util.function.LongBinaryOperator;
import instrumented.java.util.function.LongConsumer;
import instrumented.java.util.function.LongToDoubleFunction;
import instrumented.java.util.function.LongToIntFunction;
import instrumented.java.util.function.LongFunction;
import instrumented.java.util.function.LongUnaryOperator;
import instrumented.java.util.function.LongPredicate;

public interface LongStream extends BaseStream<Long, LongStream>
{
    LongStream filter(final LongPredicate p0);
    
    LongStream map(final LongUnaryOperator p0);
    
     <U> Stream<U> mapToObj(final LongFunction<? extends U> p0);
    
    IntStream mapToInt(final LongToIntFunction p0);
    
    DoubleStream mapToDouble(final LongToDoubleFunction p0);
    
    LongStream flatMap(final LongFunction<? extends LongStream> p0);
    
    LongStream distinct();
    
    LongStream sorted();
    
    LongStream peek(final LongConsumer p0);
    
    LongStream limit(final long p0);
    
    LongStream skip(final long p0);
    
    void forEach(final LongConsumer p0);
    
    void forEachOrdered(final LongConsumer p0);
    
    long[] toArray();
    
    long reduce(final long p0, final LongBinaryOperator p1);
    
    OptionalLong reduce(final LongBinaryOperator p0);
    
     <R> R collect(final Supplier<R> p0, final ObjLongConsumer<R> p1, final BiConsumer<R, R> p2);
    
    long sum();
    
    OptionalLong min();
    
    OptionalLong max();
    
    long count();
    
    OptionalDouble average();
    
    LongSummaryStatistics summaryStatistics();
    
    boolean anyMatch(final LongPredicate p0);
    
    boolean allMatch(final LongPredicate p0);
    
    boolean noneMatch(final LongPredicate p0);
    
    OptionalLong findFirst();
    
    OptionalLong findAny();
    
    DoubleStream asDoubleStream();
    
    Stream<Long> boxed();
    
    LongStream sequential();
    
    LongStream parallel();
    
    PrimitiveIterator.OfLong iterator();
    
    Spliterator.OfLong spliterator();
    
    default Builder builder() {
        try {
            BytecodeManager.incBytecodes(3);
            final Streams.LongStreamBuilderImpl longStreamBuilderImpl = new Streams.LongStreamBuilderImpl();
            BytecodeManager.incBytecodes(1);
            return longStreamBuilderImpl;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    default LongStream empty() {
        try {
            BytecodeManager.incBytecodes(1);
            final Spliterator.OfLong emptyLongSpliterator = Spliterators.emptyLongSpliterator();
            final boolean b = false;
            BytecodeManager.incBytecodes(2);
            final LongStream longStream = StreamSupport.longStream(emptyLongSpliterator, b);
            BytecodeManager.incBytecodes(1);
            return longStream;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    default LongStream of(final long n) {
        try {
            BytecodeManager.incBytecodes(4);
            final Streams.LongStreamBuilderImpl longStreamBuilderImpl = new Streams.LongStreamBuilderImpl(n);
            final boolean b = false;
            BytecodeManager.incBytecodes(2);
            final LongStream longStream = StreamSupport.longStream(longStreamBuilderImpl, b);
            BytecodeManager.incBytecodes(1);
            return longStream;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    default LongStream of(final long... array) {
        try {
            BytecodeManager.incBytecodes(2);
            final LongStream stream = Arrays.stream(array);
            BytecodeManager.incBytecodes(1);
            return stream;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    default LongStream iterate(final long n, final LongUnaryOperator longUnaryOperator) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(longUnaryOperator);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(5);
            final PrimitiveIterator.OfLong ofLong = new PrimitiveIterator.OfLong() {
                long t = n;
                
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
                public long nextLong() {
                    try {
                        final long t = this.t;
                        BytecodeManager.incBytecodes(3);
                        final LongUnaryOperator val$f = longUnaryOperator;
                        final long t2 = this.t;
                        BytecodeManager.incBytecodes(6);
                        this.t = val$f.applyAsLong(t2);
                        BytecodeManager.incBytecodes(1);
                        final long n = t;
                        BytecodeManager.incBytecodes(2);
                        return n;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
            };
            BytecodeManager.incBytecodes(1);
            final PrimitiveIterator.OfLong ofLong2 = ofLong;
            final int n2 = 1296;
            BytecodeManager.incBytecodes(3);
            final Spliterator.OfLong spliteratorUnknownSize = Spliterators.spliteratorUnknownSize(ofLong2, n2);
            final boolean b = false;
            BytecodeManager.incBytecodes(2);
            final LongStream longStream = StreamSupport.longStream(spliteratorUnknownSize, b);
            BytecodeManager.incBytecodes(1);
            return longStream;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    default LongStream generate(final LongSupplier longSupplier) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(longSupplier);
            BytecodeManager.incBytecodes(1);
            final long n = Long.MAX_VALUE;
            BytecodeManager.incBytecodes(5);
            final StreamSpliterators.InfiniteSupplyingSpliterator.OfLong ofLong = new StreamSpliterators.InfiniteSupplyingSpliterator.OfLong(n, longSupplier);
            final boolean b = false;
            BytecodeManager.incBytecodes(2);
            final LongStream longStream = StreamSupport.longStream(ofLong, b);
            BytecodeManager.incBytecodes(1);
            return longStream;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    default LongStream range(final long n, final long n2) {
        try {
            final long n3 = lcmp(n, n2);
            BytecodeManager.incBytecodes(4);
            if (n3 >= 0) {
                BytecodeManager.incBytecodes(1);
                final LongStream empty = empty();
                BytecodeManager.incBytecodes(1);
                return empty;
            }
            final long n4 = lcmp(n2 - n, 0L);
            BytecodeManager.incBytecodes(6);
            if (n4 < 0) {
                final long dividend = n2 - n;
                final long divisor = 2L;
                BytecodeManager.incBytecodes(6);
                final long n5 = n + Long.divideUnsigned(dividend, divisor) + 1L;
                BytecodeManager.incBytecodes(4);
                final long n6 = n5;
                BytecodeManager.incBytecodes(3);
                final LongStream range = range(n, n6);
                final long n7 = n5;
                BytecodeManager.incBytecodes(3);
                final LongStream range2 = range(n7, n2);
                BytecodeManager.incBytecodes(1);
                final LongStream concat = concat(range, range2);
                BytecodeManager.incBytecodes(1);
                return concat;
            }
            final boolean b = false;
            BytecodeManager.incBytecodes(6);
            final Streams.RangeLongSpliterator rangeLongSpliterator = new Streams.RangeLongSpliterator(n, n2, b);
            final boolean b2 = false;
            BytecodeManager.incBytecodes(2);
            final LongStream longStream = StreamSupport.longStream(rangeLongSpliterator, b2);
            BytecodeManager.incBytecodes(1);
            return longStream;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    default LongStream rangeClosed(final long n, final long n2) {
        try {
            final long n3 = lcmp(n, n2);
            BytecodeManager.incBytecodes(4);
            if (n3 > 0) {
                BytecodeManager.incBytecodes(1);
                final LongStream empty = empty();
                BytecodeManager.incBytecodes(1);
                return empty;
            }
            final long n4 = lcmp(n2 - n + 1L, 0L);
            BytecodeManager.incBytecodes(8);
            if (n4 <= 0) {
                final long dividend = n2 - n;
                final long divisor = 2L;
                BytecodeManager.incBytecodes(6);
                final long n5 = n + Long.divideUnsigned(dividend, divisor) + 1L;
                BytecodeManager.incBytecodes(4);
                final long n6 = n5;
                BytecodeManager.incBytecodes(3);
                final LongStream range = range(n, n6);
                final long n7 = n5;
                BytecodeManager.incBytecodes(3);
                final LongStream rangeClosed = rangeClosed(n7, n2);
                BytecodeManager.incBytecodes(1);
                final LongStream concat = concat(range, rangeClosed);
                BytecodeManager.incBytecodes(1);
                return concat;
            }
            final boolean b = true;
            BytecodeManager.incBytecodes(6);
            final Streams.RangeLongSpliterator rangeLongSpliterator = new Streams.RangeLongSpliterator(n, n2, b);
            final boolean b2 = false;
            BytecodeManager.incBytecodes(2);
            final LongStream longStream = StreamSupport.longStream(rangeLongSpliterator, b2);
            BytecodeManager.incBytecodes(1);
            return longStream;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    default LongStream concat(final LongStream longStream, final LongStream longStream2) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(longStream);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(longStream2);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
            final Spliterator.OfLong spliterator = longStream.spliterator();
            BytecodeManager.incBytecodes(2);
            final Spliterator.OfLong spliterator2 = longStream2.spliterator();
            BytecodeManager.incBytecodes(1);
            final Streams.ConcatSpliterator.OfLong ofLong = new Streams.ConcatSpliterator.OfLong(spliterator, spliterator2);
            BytecodeManager.incBytecodes(1);
            final Streams.ConcatSpliterator.OfLong ofLong2 = ofLong;
            BytecodeManager.incBytecodes(3);
            final boolean parallel = longStream.isParallel();
            BytecodeManager.incBytecodes(1);
            boolean b = false;
            Label_0129: {
                if (!parallel) {
                    BytecodeManager.incBytecodes(2);
                    final boolean parallel2 = longStream2.isParallel();
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
            final LongStream longStream3 = StreamSupport.longStream(ofLong2, b);
            BytecodeManager.incBytecodes(1);
            final LongStream longStream4 = longStream3;
            BytecodeManager.incBytecodes(4);
            final Runnable composedClose = Streams.composedClose(longStream, longStream2);
            BytecodeManager.incBytecodes(1);
            final LongStream longStream5 = ((BaseStream<T, LongStream>)longStream4).onClose(composedClose);
            BytecodeManager.incBytecodes(2);
            return longStream5;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public interface Builder extends LongConsumer
    {
        void accept(final long p0);
        
        default Builder add(final long n) {
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
        
        LongStream build();
    }
}
