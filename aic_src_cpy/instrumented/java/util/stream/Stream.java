// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.stream;

import java.util.Iterator;
import instrumented.java.util.Objects;
import instrumented.java.util.function.UnaryOperator;
import instrumented.java.util.Arrays;
import instrumented.java.util.Spliterator;
import instrumented.java.util.Spliterators;
import aic2021.engine.BytecodeManager;
import instrumented.java.util.function.BiConsumer;
import instrumented.java.util.function.Supplier;
import instrumented.java.util.function.BiFunction;
import instrumented.java.util.Optional;
import instrumented.java.util.function.BinaryOperator;
import instrumented.java.util.function.IntFunction;
import instrumented.java.util.function.Consumer;
import instrumented.java.util.Comparator;
import instrumented.java.util.function.ToDoubleFunction;
import instrumented.java.util.function.ToLongFunction;
import instrumented.java.util.function.ToIntFunction;
import instrumented.java.util.function.Function;
import instrumented.java.util.function.Predicate;

public interface Stream<T> extends BaseStream<T, Stream<T>>
{
    Stream<T> filter(final Predicate<? super T> p0);
    
     <R> Stream<R> map(final Function<? super T, ? extends R> p0);
    
    IntStream mapToInt(final ToIntFunction<? super T> p0);
    
    LongStream mapToLong(final ToLongFunction<? super T> p0);
    
    DoubleStream mapToDouble(final ToDoubleFunction<? super T> p0);
    
     <R> Stream<R> flatMap(final Function<? super T, ? extends Stream<? extends R>> p0);
    
    IntStream flatMapToInt(final Function<? super T, ? extends IntStream> p0);
    
    LongStream flatMapToLong(final Function<? super T, ? extends LongStream> p0);
    
    DoubleStream flatMapToDouble(final Function<? super T, ? extends DoubleStream> p0);
    
    Stream<T> distinct();
    
    Stream<T> sorted();
    
    Stream<T> sorted(final Comparator<? super T> p0);
    
    Stream<T> peek(final Consumer<? super T> p0);
    
    Stream<T> limit(final long p0);
    
    Stream<T> skip(final long p0);
    
    void forEach(final Consumer<? super T> p0);
    
    void forEachOrdered(final Consumer<? super T> p0);
    
    Object[] toArray();
    
     <A> A[] toArray(final IntFunction<A[]> p0);
    
    T reduce(final T p0, final BinaryOperator<T> p1);
    
    Optional<T> reduce(final BinaryOperator<T> p0);
    
     <U> U reduce(final U p0, final BiFunction<U, ? super T, U> p1, final BinaryOperator<U> p2);
    
     <R> R collect(final Supplier<R> p0, final BiConsumer<R, ? super T> p1, final BiConsumer<R, R> p2);
    
     <R, A> R collect(final Collector<? super T, A, R> p0);
    
    Optional<T> min(final Comparator<? super T> p0);
    
    Optional<T> max(final Comparator<? super T> p0);
    
    long count();
    
    boolean anyMatch(final Predicate<? super T> p0);
    
    boolean allMatch(final Predicate<? super T> p0);
    
    boolean noneMatch(final Predicate<? super T> p0);
    
    Optional<T> findFirst();
    
    Optional<T> findAny();
    
    default <T> Builder<T> builder() {
        try {
            BytecodeManager.incBytecodes(3);
            final Streams.StreamBuilderImpl<T> streamBuilderImpl = new Streams.StreamBuilderImpl<T>();
            BytecodeManager.incBytecodes(1);
            return streamBuilderImpl;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    default <T> Stream<T> empty() {
        try {
            BytecodeManager.incBytecodes(1);
            final Spliterator<T> emptySpliterator = Spliterators.emptySpliterator();
            final boolean b = false;
            BytecodeManager.incBytecodes(2);
            final Stream<T> stream = StreamSupport.stream(emptySpliterator, b);
            BytecodeManager.incBytecodes(1);
            return stream;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    default <T> Stream<T> of(final T t) {
        try {
            BytecodeManager.incBytecodes(4);
            final Streams.StreamBuilderImpl streamBuilderImpl = new Streams.StreamBuilderImpl(t);
            final boolean b = false;
            BytecodeManager.incBytecodes(2);
            final Stream<T> stream = StreamSupport.stream((Spliterator<T>)streamBuilderImpl, b);
            BytecodeManager.incBytecodes(1);
            return stream;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @SafeVarargs
    default <T> Stream<T> of(final T... array) {
        try {
            BytecodeManager.incBytecodes(2);
            final Stream<T> stream = Arrays.stream(array);
            BytecodeManager.incBytecodes(1);
            return stream;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    default <T> Stream<T> iterate(final T t, final UnaryOperator<T> unaryOperator) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(unaryOperator);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(5);
            final Iterator<T> iterator = new Iterator<T>() {
                T t = Streams.NONE;
                
                {
                    BytecodeManager.incBytecodes(4);
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
                public T next() {
                    try {
                        final T t = this.t;
                        final Object none = Streams.NONE;
                        BytecodeManager.incBytecodes(5);
                        Object t2;
                        Object o;
                        if (t == none) {
                            o = (t2 = t);
                            BytecodeManager.incBytecodes(3);
                        }
                        else {
                            final UnaryOperator val$f = unaryOperator;
                            final T t3 = this.t;
                            BytecodeManager.incBytecodes(5);
                            o = (t2 = val$f.apply(t3));
                        }
                        this.t = (T)t2;
                        BytecodeManager.incBytecodes(3);
                        return (T)o;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
            };
            BytecodeManager.incBytecodes(1);
            final Iterator<T> iterator2 = iterator;
            final int n = 1040;
            BytecodeManager.incBytecodes(3);
            final Spliterator<Object> spliteratorUnknownSize = (Spliterator<Object>)Spliterators.spliteratorUnknownSize((Iterator<? extends T>)iterator2, n);
            final boolean b = false;
            BytecodeManager.incBytecodes(2);
            final Stream<T> stream = StreamSupport.stream((Spliterator<T>)spliteratorUnknownSize, b);
            BytecodeManager.incBytecodes(1);
            return stream;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    default <T> Stream<T> generate(final Supplier<T> supplier) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(supplier);
            BytecodeManager.incBytecodes(1);
            final long n = Long.MAX_VALUE;
            BytecodeManager.incBytecodes(5);
            final StreamSpliterators.InfiniteSupplyingSpliterator.OfRef ofRef = new StreamSpliterators.InfiniteSupplyingSpliterator.OfRef<T>(n, supplier);
            final boolean b = false;
            BytecodeManager.incBytecodes(2);
            final Stream<T> stream = StreamSupport.stream((Spliterator<T>)ofRef, b);
            BytecodeManager.incBytecodes(1);
            return stream;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    default <T> Stream<T> concat(final Stream<? extends T> stream, final Stream<? extends T> stream2) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(stream);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(stream2);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
            final Spliterator<T> spliterator = stream.spliterator();
            BytecodeManager.incBytecodes(2);
            final Spliterator<T> spliterator2 = stream2.spliterator();
            BytecodeManager.incBytecodes(1);
            final Streams.ConcatSpliterator.OfRef ofRef = new Streams.ConcatSpliterator.OfRef(spliterator, spliterator2);
            BytecodeManager.incBytecodes(1);
            final Streams.ConcatSpliterator.OfRef ofRef2 = ofRef;
            BytecodeManager.incBytecodes(3);
            final boolean parallel = stream.isParallel();
            BytecodeManager.incBytecodes(1);
            boolean b = false;
            Label_0129: {
                if (!parallel) {
                    BytecodeManager.incBytecodes(2);
                    final boolean parallel2 = stream2.isParallel();
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
            final Stream<Object> stream3 = StreamSupport.stream((Spliterator<Object>)ofRef2, b);
            BytecodeManager.incBytecodes(1);
            final Stream<Object> stream4 = stream3;
            BytecodeManager.incBytecodes(4);
            final Runnable composedClose = Streams.composedClose(stream, stream2);
            BytecodeManager.incBytecodes(1);
            final Stream<T> stream5 = stream4.onClose(composedClose);
            BytecodeManager.incBytecodes(2);
            return stream5;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public interface Builder<T> extends Consumer<T>
    {
        void accept(final T p0);
        
        default Builder<T> add(final T t) {
            try {
                BytecodeManager.incBytecodes(3);
                this.accept(t);
                BytecodeManager.incBytecodes(2);
                return this;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        Stream<T> build();
    }
}
