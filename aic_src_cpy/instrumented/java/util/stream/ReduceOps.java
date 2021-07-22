// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.stream;

import instrumented.java.util.concurrent.CountedCompleter;
import instrumented.java.util.Spliterator;
import instrumented.java.util.function.ObjDoubleConsumer;
import instrumented.java.util.OptionalDouble;
import instrumented.java.util.function.DoubleBinaryOperator;
import instrumented.java.util.function.ObjLongConsumer;
import instrumented.java.util.OptionalLong;
import instrumented.java.util.function.LongBinaryOperator;
import instrumented.java.util.function.ObjIntConsumer;
import instrumented.java.util.OptionalInt;
import instrumented.java.util.function.IntBinaryOperator;
import instrumented.java.util.Set;
import instrumented.java.util.function.BiConsumer;
import instrumented.java.util.function.Supplier;
import instrumented.java.util.Optional;
import instrumented.java.util.Objects;
import instrumented.java.util.function.BinaryOperator;
import instrumented.java.util.function.BiFunction;
import aic2021.engine.BytecodeManager;

final class ReduceOps
{
    private ReduceOps() {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T, U> TerminalOp<T, U> makeRef(final U u, final BiFunction<U, ? super T, U> biFunction, final BinaryOperator<U> binaryOperator) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(biFunction);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(binaryOperator);
            BytecodeManager.incBytecodes(1);
            final StreamShape reference = StreamShape.REFERENCE;
            BytecodeManager.incBytecodes(7);
            class ReducingSink extends Box<U> implements AccumulatingSink<T, U, ReducingSink>
            {
                ReducingSink() {
                    try {
                        BytecodeManager.incBytecodes(11);
                        BytecodeManager.incBytecodes(1);
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public void begin(final long n) {
                    try {
                        this.state = (U)val$seed;
                        BytecodeManager.incBytecodes(4);
                        BytecodeManager.incBytecodes(1);
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public void accept(final T t) {
                    try {
                        final BiFunction val$reducer = val$reducer;
                        final U state = this.state;
                        BytecodeManager.incBytecodes(7);
                        this.state = val$reducer.apply(state, t);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public void combine(final ReducingSink reducingSink) {
                    try {
                        final BinaryOperator val$combiner = val$combiner;
                        final U state = this.state;
                        final U state2 = reducingSink.state;
                        BytecodeManager.incBytecodes(8);
                        this.state = (U)val$combiner.apply(state, state2);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
            }
            final ReduceOp<T, U, ReducingSink> reduceOp = new ReduceOp<T, U, ReducingSink>(reference) {
                {
                    BytecodeManager.incBytecodes(1);
                }
                
                @Override
                public ReduceOps.ReducingSink makeSink() {
                    try {
                        final Object val$seed = u;
                        final BiFunction val$reducer = biFunction;
                        final BinaryOperator val$combiner = binaryOperator;
                        BytecodeManager.incBytecodes(9);
                        final ReduceOps.ReducingSink reducingSink = new ReduceOps.ReducingSink();
                        BytecodeManager.incBytecodes(1);
                        return reducingSink;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
            };
            BytecodeManager.incBytecodes(1);
            return reduceOp;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T> TerminalOp<T, Optional<T>> makeRef(final BinaryOperator<T> binaryOperator) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(binaryOperator);
            BytecodeManager.incBytecodes(1);
            final StreamShape reference = StreamShape.REFERENCE;
            BytecodeManager.incBytecodes(5);
            class ReducingSink implements AccumulatingSink<T, Optional<T>, ReducingSink>
            {
                private boolean empty;
                private T state;
                
                ReducingSink() {
                    try {
                        BytecodeManager.incBytecodes(5);
                        BytecodeManager.incBytecodes(1);
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public void begin(final long n) {
                    try {
                        this.empty = true;
                        BytecodeManager.incBytecodes(3);
                        this.state = null;
                        BytecodeManager.incBytecodes(3);
                        BytecodeManager.incBytecodes(1);
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public void accept(final T state) {
                    try {
                        final boolean empty = this.empty;
                        BytecodeManager.incBytecodes(3);
                        if (empty) {
                            this.empty = false;
                            BytecodeManager.incBytecodes(3);
                            this.state = state;
                            BytecodeManager.incBytecodes(4);
                        }
                        else {
                            final BinaryOperator val$operator = val$operator;
                            final T state2 = this.state;
                            BytecodeManager.incBytecodes(7);
                            this.state = (T)val$operator.apply(state2, state);
                            BytecodeManager.incBytecodes(1);
                        }
                        BytecodeManager.incBytecodes(1);
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public Optional<T> get() {
                    try {
                        final boolean empty = this.empty;
                        BytecodeManager.incBytecodes(3);
                        Optional<T> optional;
                        if (empty) {
                            BytecodeManager.incBytecodes(1);
                            optional = Optional.empty();
                            BytecodeManager.incBytecodes(1);
                        }
                        else {
                            final T state = this.state;
                            BytecodeManager.incBytecodes(3);
                            optional = Optional.of(state);
                        }
                        BytecodeManager.incBytecodes(1);
                        return optional;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public void combine(final ReducingSink reducingSink) {
                    try {
                        final boolean empty = reducingSink.empty;
                        BytecodeManager.incBytecodes(3);
                        if (!empty) {
                            final T state = reducingSink.state;
                            BytecodeManager.incBytecodes(4);
                            this.accept(state);
                        }
                        BytecodeManager.incBytecodes(1);
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
            }
            final ReduceOp<T, Optional<T>, ReducingSink> reduceOp = new ReduceOp<T, Optional<T>, ReducingSink>(reference) {
                {
                    BytecodeManager.incBytecodes(1);
                }
                
                @Override
                public ReduceOps.ReducingSink makeSink() {
                    try {
                        final BinaryOperator val$operator = binaryOperator;
                        BytecodeManager.incBytecodes(5);
                        final ReduceOps.ReducingSink reducingSink = new ReduceOps.ReducingSink();
                        BytecodeManager.incBytecodes(1);
                        return reducingSink;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
            };
            BytecodeManager.incBytecodes(1);
            return reduceOp;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T, I> TerminalOp<T, I> makeRef(final Collector<? super T, I, ?> collector) {
        try {
            BytecodeManager.incBytecodes(2);
            final Collector<? super T, I, ?> collector2 = Objects.requireNonNull(collector);
            BytecodeManager.incBytecodes(2);
            final Supplier<I> supplier = collector2.supplier();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            final BiConsumer<I, ? super T> accumulator = collector.accumulator();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            final BinaryOperator<I> combiner = collector.combiner();
            BytecodeManager.incBytecodes(1);
            final StreamShape reference = StreamShape.REFERENCE;
            final BinaryOperator<I> binaryOperator = combiner;
            final BiConsumer<I, ? super T> biConsumer = accumulator;
            final Supplier<I> supplier2 = supplier;
            BytecodeManager.incBytecodes(8);
            class ReducingSink extends Box<I> implements AccumulatingSink<T, I, ReducingSink>
            {
                ReducingSink() {
                    try {
                        BytecodeManager.incBytecodes(11);
                        BytecodeManager.incBytecodes(1);
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public void begin(final long n) {
                    try {
                        final Supplier val$supplier = val$supplier;
                        BytecodeManager.incBytecodes(4);
                        this.state = val$supplier.get();
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public void accept(final T t) {
                    try {
                        final BiConsumer val$accumulator = val$accumulator;
                        final U state = this.state;
                        BytecodeManager.incBytecodes(6);
                        val$accumulator.accept(state, t);
                        BytecodeManager.incBytecodes(1);
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public void combine(final ReducingSink reducingSink) {
                    try {
                        final BinaryOperator val$combiner = val$combiner;
                        final U state = this.state;
                        final U state2 = reducingSink.state;
                        BytecodeManager.incBytecodes(8);
                        this.state = (U)val$combiner.apply(state, state2);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
            }
            final ReduceOp<T, I, ReducingSink> reduceOp = new ReduceOp<T, I, ReducingSink>(reference) {
                {
                    BytecodeManager.incBytecodes(1);
                }
                
                @Override
                public ReduceOps.ReducingSink makeSink() {
                    try {
                        final Supplier val$supplier = supplier2;
                        final BiConsumer val$accumulator = biConsumer;
                        final BinaryOperator val$combiner = binaryOperator;
                        BytecodeManager.incBytecodes(9);
                        final ReduceOps.ReducingSink reducingSink = new ReduceOps.ReducingSink();
                        BytecodeManager.incBytecodes(1);
                        return reducingSink;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public int getOpFlags() {
                    try {
                        final Collector val$collector = collector;
                        BytecodeManager.incBytecodes(3);
                        final Set characteristics = val$collector.characteristics();
                        final Collector.Characteristics unordered = Collector.Characteristics.UNORDERED;
                        BytecodeManager.incBytecodes(2);
                        final boolean contains = characteristics.contains(unordered);
                        BytecodeManager.incBytecodes(1);
                        int not_ORDERED;
                        if (contains) {
                            not_ORDERED = StreamOpFlag.NOT_ORDERED;
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            not_ORDERED = 0;
                            BytecodeManager.incBytecodes(1);
                        }
                        BytecodeManager.incBytecodes(1);
                        return not_ORDERED;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
            };
            BytecodeManager.incBytecodes(1);
            return reduceOp;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T, R> TerminalOp<T, R> makeRef(final Supplier<R> supplier, final BiConsumer<R, ? super T> biConsumer, final BiConsumer<R, R> biConsumer2) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(supplier);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(biConsumer);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(biConsumer2);
            BytecodeManager.incBytecodes(1);
            final StreamShape reference = StreamShape.REFERENCE;
            BytecodeManager.incBytecodes(7);
            class ReducingSink extends Box<R> implements AccumulatingSink<T, R, ReducingSink>
            {
                ReducingSink() {
                    try {
                        BytecodeManager.incBytecodes(11);
                        BytecodeManager.incBytecodes(1);
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public void begin(final long n) {
                    try {
                        final Supplier val$seedFactory = val$seedFactory;
                        BytecodeManager.incBytecodes(4);
                        this.state = val$seedFactory.get();
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public void accept(final T t) {
                    try {
                        final BiConsumer val$accumulator = val$accumulator;
                        final U state = this.state;
                        BytecodeManager.incBytecodes(6);
                        val$accumulator.accept(state, t);
                        BytecodeManager.incBytecodes(1);
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public void combine(final ReducingSink reducingSink) {
                    try {
                        final BiConsumer val$reducer = val$reducer;
                        final U state = this.state;
                        final U state2 = reducingSink.state;
                        BytecodeManager.incBytecodes(7);
                        val$reducer.accept(state, state2);
                        BytecodeManager.incBytecodes(1);
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
            }
            final ReduceOp<T, R, ReducingSink> reduceOp = new ReduceOp<T, R, ReducingSink>(reference) {
                {
                    BytecodeManager.incBytecodes(1);
                }
                
                @Override
                public ReduceOps.ReducingSink makeSink() {
                    try {
                        final Supplier val$seedFactory = supplier;
                        final BiConsumer val$accumulator = biConsumer;
                        final BiConsumer val$reducer = biConsumer2;
                        BytecodeManager.incBytecodes(9);
                        final ReduceOps.ReducingSink reducingSink = new ReduceOps.ReducingSink();
                        BytecodeManager.incBytecodes(1);
                        return reducingSink;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
            };
            BytecodeManager.incBytecodes(1);
            return reduceOp;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static TerminalOp<Integer, Integer> makeInt(final int n, final IntBinaryOperator intBinaryOperator) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(intBinaryOperator);
            BytecodeManager.incBytecodes(1);
            final StreamShape int_VALUE = StreamShape.INT_VALUE;
            BytecodeManager.incBytecodes(6);
            class ReducingSink implements AccumulatingSink<Integer, Integer, ReducingSink>, Sink.OfInt
            {
                private int state;
                
                ReducingSink() {
                    try {
                        BytecodeManager.incBytecodes(8);
                        BytecodeManager.incBytecodes(1);
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public void begin(final long n) {
                    try {
                        this.state = val$identity;
                        BytecodeManager.incBytecodes(4);
                        BytecodeManager.incBytecodes(1);
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public void accept(final int n) {
                    try {
                        final IntBinaryOperator val$operator = val$operator;
                        final int state = this.state;
                        BytecodeManager.incBytecodes(7);
                        this.state = val$operator.applyAsInt(state, n);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public Integer get() {
                    try {
                        final int state = this.state;
                        BytecodeManager.incBytecodes(3);
                        final Integer value = state;
                        BytecodeManager.incBytecodes(1);
                        return value;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public void combine(final ReducingSink reducingSink) {
                    try {
                        final int state = reducingSink.state;
                        BytecodeManager.incBytecodes(4);
                        this.accept(state);
                        BytecodeManager.incBytecodes(1);
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
            }
            final ReduceOp<Integer, Integer, ReducingSink> reduceOp = new ReduceOp<Integer, Integer, ReducingSink>(int_VALUE) {
                {
                    BytecodeManager.incBytecodes(1);
                }
                
                @Override
                public ReduceOps.ReducingSink makeSink() {
                    try {
                        final int val$identity = n;
                        final IntBinaryOperator val$operator = intBinaryOperator;
                        BytecodeManager.incBytecodes(7);
                        final ReduceOps.ReducingSink reducingSink = new ReduceOps.ReducingSink();
                        BytecodeManager.incBytecodes(1);
                        return reducingSink;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
            };
            BytecodeManager.incBytecodes(1);
            return reduceOp;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static TerminalOp<Integer, OptionalInt> makeInt(final IntBinaryOperator intBinaryOperator) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(intBinaryOperator);
            BytecodeManager.incBytecodes(1);
            final StreamShape int_VALUE = StreamShape.INT_VALUE;
            BytecodeManager.incBytecodes(5);
            class ReducingSink implements AccumulatingSink<Integer, OptionalInt, ReducingSink>, Sink.OfInt
            {
                private boolean empty;
                private int state;
                
                ReducingSink() {
                    try {
                        BytecodeManager.incBytecodes(5);
                        BytecodeManager.incBytecodes(1);
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public void begin(final long n) {
                    try {
                        this.empty = true;
                        BytecodeManager.incBytecodes(3);
                        this.state = 0;
                        BytecodeManager.incBytecodes(3);
                        BytecodeManager.incBytecodes(1);
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public void accept(final int state) {
                    try {
                        final boolean empty = this.empty;
                        BytecodeManager.incBytecodes(3);
                        if (empty) {
                            this.empty = false;
                            BytecodeManager.incBytecodes(3);
                            this.state = state;
                            BytecodeManager.incBytecodes(4);
                        }
                        else {
                            final IntBinaryOperator val$operator = val$operator;
                            final int state2 = this.state;
                            BytecodeManager.incBytecodes(7);
                            this.state = val$operator.applyAsInt(state2, state);
                            BytecodeManager.incBytecodes(1);
                        }
                        BytecodeManager.incBytecodes(1);
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public OptionalInt get() {
                    try {
                        final boolean empty = this.empty;
                        BytecodeManager.incBytecodes(3);
                        OptionalInt optionalInt;
                        if (empty) {
                            BytecodeManager.incBytecodes(1);
                            optionalInt = OptionalInt.empty();
                            BytecodeManager.incBytecodes(1);
                        }
                        else {
                            final int state = this.state;
                            BytecodeManager.incBytecodes(3);
                            optionalInt = OptionalInt.of(state);
                        }
                        BytecodeManager.incBytecodes(1);
                        return optionalInt;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public void combine(final ReducingSink reducingSink) {
                    try {
                        final boolean empty = reducingSink.empty;
                        BytecodeManager.incBytecodes(3);
                        if (!empty) {
                            final int state = reducingSink.state;
                            BytecodeManager.incBytecodes(4);
                            this.accept(state);
                        }
                        BytecodeManager.incBytecodes(1);
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
            }
            final ReduceOp<Integer, OptionalInt, ReducingSink> reduceOp = new ReduceOp<Integer, OptionalInt, ReducingSink>(int_VALUE) {
                {
                    BytecodeManager.incBytecodes(1);
                }
                
                @Override
                public ReduceOps.ReducingSink makeSink() {
                    try {
                        final IntBinaryOperator val$operator = intBinaryOperator;
                        BytecodeManager.incBytecodes(5);
                        final ReduceOps.ReducingSink reducingSink = new ReduceOps.ReducingSink();
                        BytecodeManager.incBytecodes(1);
                        return reducingSink;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
            };
            BytecodeManager.incBytecodes(1);
            return reduceOp;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <R> TerminalOp<Integer, R> makeInt(final Supplier<R> supplier, final ObjIntConsumer<R> objIntConsumer, final BinaryOperator<R> binaryOperator) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(supplier);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(objIntConsumer);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(binaryOperator);
            BytecodeManager.incBytecodes(1);
            final StreamShape int_VALUE = StreamShape.INT_VALUE;
            BytecodeManager.incBytecodes(7);
            class ReducingSink extends Box<R> implements AccumulatingSink<Integer, R, ReducingSink>, Sink.OfInt
            {
                ReducingSink() {
                    try {
                        BytecodeManager.incBytecodes(11);
                        BytecodeManager.incBytecodes(1);
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public void begin(final long n) {
                    try {
                        final Supplier val$supplier = val$supplier;
                        BytecodeManager.incBytecodes(4);
                        this.state = val$supplier.get();
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public void accept(final int n) {
                    try {
                        final ObjIntConsumer val$accumulator = val$accumulator;
                        final U state = this.state;
                        BytecodeManager.incBytecodes(6);
                        val$accumulator.accept(state, n);
                        BytecodeManager.incBytecodes(1);
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public void combine(final ReducingSink reducingSink) {
                    try {
                        final BinaryOperator val$combiner = val$combiner;
                        final U state = this.state;
                        final U state2 = reducingSink.state;
                        BytecodeManager.incBytecodes(8);
                        this.state = (U)val$combiner.apply(state, state2);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
            }
            final ReduceOp<Integer, R, ReducingSink> reduceOp = new ReduceOp<Integer, R, ReducingSink>(int_VALUE) {
                {
                    BytecodeManager.incBytecodes(1);
                }
                
                @Override
                public ReduceOps.ReducingSink makeSink() {
                    try {
                        final Supplier val$supplier = supplier;
                        final ObjIntConsumer val$accumulator = objIntConsumer;
                        final BinaryOperator val$combiner = binaryOperator;
                        BytecodeManager.incBytecodes(9);
                        final ReduceOps.ReducingSink reducingSink = new ReduceOps.ReducingSink();
                        BytecodeManager.incBytecodes(1);
                        return reducingSink;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
            };
            BytecodeManager.incBytecodes(1);
            return reduceOp;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static TerminalOp<Long, Long> makeLong(final long n, final LongBinaryOperator longBinaryOperator) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(longBinaryOperator);
            BytecodeManager.incBytecodes(1);
            final StreamShape long_VALUE = StreamShape.LONG_VALUE;
            BytecodeManager.incBytecodes(6);
            class ReducingSink implements AccumulatingSink<Long, Long, ReducingSink>, Sink.OfLong
            {
                private long state;
                
                ReducingSink() {
                    try {
                        BytecodeManager.incBytecodes(8);
                        BytecodeManager.incBytecodes(1);
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public void begin(final long n) {
                    try {
                        this.state = val$identity;
                        BytecodeManager.incBytecodes(4);
                        BytecodeManager.incBytecodes(1);
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public void accept(final long n) {
                    try {
                        final LongBinaryOperator val$operator = val$operator;
                        final long state = this.state;
                        BytecodeManager.incBytecodes(7);
                        this.state = val$operator.applyAsLong(state, n);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public Long get() {
                    try {
                        final long state = this.state;
                        BytecodeManager.incBytecodes(3);
                        final Long value = state;
                        BytecodeManager.incBytecodes(1);
                        return value;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public void combine(final ReducingSink reducingSink) {
                    try {
                        final long state = reducingSink.state;
                        BytecodeManager.incBytecodes(4);
                        this.accept(state);
                        BytecodeManager.incBytecodes(1);
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
            }
            final ReduceOp<Long, Long, ReducingSink> reduceOp = new ReduceOp<Long, Long, ReducingSink>(long_VALUE) {
                {
                    BytecodeManager.incBytecodes(1);
                }
                
                @Override
                public ReduceOps.ReducingSink makeSink() {
                    try {
                        final long val$identity = n;
                        final LongBinaryOperator val$operator = longBinaryOperator;
                        BytecodeManager.incBytecodes(7);
                        final ReduceOps.ReducingSink reducingSink = new ReduceOps.ReducingSink();
                        BytecodeManager.incBytecodes(1);
                        return reducingSink;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
            };
            BytecodeManager.incBytecodes(1);
            return reduceOp;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static TerminalOp<Long, OptionalLong> makeLong(final LongBinaryOperator longBinaryOperator) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(longBinaryOperator);
            BytecodeManager.incBytecodes(1);
            final StreamShape long_VALUE = StreamShape.LONG_VALUE;
            BytecodeManager.incBytecodes(5);
            class ReducingSink implements AccumulatingSink<Long, OptionalLong, ReducingSink>, Sink.OfLong
            {
                private boolean empty;
                private long state;
                
                ReducingSink() {
                    try {
                        BytecodeManager.incBytecodes(5);
                        BytecodeManager.incBytecodes(1);
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public void begin(final long n) {
                    try {
                        this.empty = true;
                        BytecodeManager.incBytecodes(3);
                        this.state = 0L;
                        BytecodeManager.incBytecodes(3);
                        BytecodeManager.incBytecodes(1);
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public void accept(final long state) {
                    try {
                        final boolean empty = this.empty;
                        BytecodeManager.incBytecodes(3);
                        if (empty) {
                            this.empty = false;
                            BytecodeManager.incBytecodes(3);
                            this.state = state;
                            BytecodeManager.incBytecodes(4);
                        }
                        else {
                            final LongBinaryOperator val$operator = val$operator;
                            final long state2 = this.state;
                            BytecodeManager.incBytecodes(7);
                            this.state = val$operator.applyAsLong(state2, state);
                            BytecodeManager.incBytecodes(1);
                        }
                        BytecodeManager.incBytecodes(1);
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public OptionalLong get() {
                    try {
                        final boolean empty = this.empty;
                        BytecodeManager.incBytecodes(3);
                        OptionalLong optionalLong;
                        if (empty) {
                            BytecodeManager.incBytecodes(1);
                            optionalLong = OptionalLong.empty();
                            BytecodeManager.incBytecodes(1);
                        }
                        else {
                            final long state = this.state;
                            BytecodeManager.incBytecodes(3);
                            optionalLong = OptionalLong.of(state);
                        }
                        BytecodeManager.incBytecodes(1);
                        return optionalLong;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public void combine(final ReducingSink reducingSink) {
                    try {
                        final boolean empty = reducingSink.empty;
                        BytecodeManager.incBytecodes(3);
                        if (!empty) {
                            final long state = reducingSink.state;
                            BytecodeManager.incBytecodes(4);
                            this.accept(state);
                        }
                        BytecodeManager.incBytecodes(1);
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
            }
            final ReduceOp<Long, OptionalLong, ReducingSink> reduceOp = new ReduceOp<Long, OptionalLong, ReducingSink>(long_VALUE) {
                {
                    BytecodeManager.incBytecodes(1);
                }
                
                @Override
                public ReduceOps.ReducingSink makeSink() {
                    try {
                        final LongBinaryOperator val$operator = longBinaryOperator;
                        BytecodeManager.incBytecodes(5);
                        final ReduceOps.ReducingSink reducingSink = new ReduceOps.ReducingSink();
                        BytecodeManager.incBytecodes(1);
                        return reducingSink;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
            };
            BytecodeManager.incBytecodes(1);
            return reduceOp;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <R> TerminalOp<Long, R> makeLong(final Supplier<R> supplier, final ObjLongConsumer<R> objLongConsumer, final BinaryOperator<R> binaryOperator) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(supplier);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(objLongConsumer);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(binaryOperator);
            BytecodeManager.incBytecodes(1);
            final StreamShape long_VALUE = StreamShape.LONG_VALUE;
            BytecodeManager.incBytecodes(7);
            class ReducingSink extends Box<R> implements AccumulatingSink<Long, R, ReducingSink>, Sink.OfLong
            {
                ReducingSink() {
                    try {
                        BytecodeManager.incBytecodes(11);
                        BytecodeManager.incBytecodes(1);
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public void begin(final long n) {
                    try {
                        final Supplier val$supplier = val$supplier;
                        BytecodeManager.incBytecodes(4);
                        this.state = val$supplier.get();
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public void accept(final long n) {
                    try {
                        final ObjLongConsumer val$accumulator = val$accumulator;
                        final U state = this.state;
                        BytecodeManager.incBytecodes(6);
                        val$accumulator.accept(state, n);
                        BytecodeManager.incBytecodes(1);
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public void combine(final ReducingSink reducingSink) {
                    try {
                        final BinaryOperator val$combiner = val$combiner;
                        final U state = this.state;
                        final U state2 = reducingSink.state;
                        BytecodeManager.incBytecodes(8);
                        this.state = (U)val$combiner.apply(state, state2);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
            }
            final ReduceOp<Long, R, ReducingSink> reduceOp = new ReduceOp<Long, R, ReducingSink>(long_VALUE) {
                {
                    BytecodeManager.incBytecodes(1);
                }
                
                @Override
                public ReduceOps.ReducingSink makeSink() {
                    try {
                        final Supplier val$supplier = supplier;
                        final ObjLongConsumer val$accumulator = objLongConsumer;
                        final BinaryOperator val$combiner = binaryOperator;
                        BytecodeManager.incBytecodes(9);
                        final ReduceOps.ReducingSink reducingSink = new ReduceOps.ReducingSink();
                        BytecodeManager.incBytecodes(1);
                        return reducingSink;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
            };
            BytecodeManager.incBytecodes(1);
            return reduceOp;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static TerminalOp<Double, Double> makeDouble(final double n, final DoubleBinaryOperator doubleBinaryOperator) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(doubleBinaryOperator);
            BytecodeManager.incBytecodes(1);
            final StreamShape double_VALUE = StreamShape.DOUBLE_VALUE;
            BytecodeManager.incBytecodes(6);
            class ReducingSink implements AccumulatingSink<Double, Double, ReducingSink>, Sink.OfDouble
            {
                private double state;
                
                ReducingSink() {
                    try {
                        BytecodeManager.incBytecodes(8);
                        BytecodeManager.incBytecodes(1);
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public void begin(final long n) {
                    try {
                        this.state = val$identity;
                        BytecodeManager.incBytecodes(4);
                        BytecodeManager.incBytecodes(1);
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public void accept(final double n) {
                    try {
                        final DoubleBinaryOperator val$operator = val$operator;
                        final double state = this.state;
                        BytecodeManager.incBytecodes(7);
                        this.state = val$operator.applyAsDouble(state, n);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public Double get() {
                    try {
                        final double state = this.state;
                        BytecodeManager.incBytecodes(3);
                        final Double value = state;
                        BytecodeManager.incBytecodes(1);
                        return value;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public void combine(final ReducingSink reducingSink) {
                    try {
                        final double state = reducingSink.state;
                        BytecodeManager.incBytecodes(4);
                        this.accept(state);
                        BytecodeManager.incBytecodes(1);
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
            }
            final ReduceOp<Double, Double, ReducingSink> reduceOp = new ReduceOp<Double, Double, ReducingSink>(double_VALUE) {
                {
                    BytecodeManager.incBytecodes(1);
                }
                
                @Override
                public ReduceOps.ReducingSink makeSink() {
                    try {
                        final double val$identity = n;
                        final DoubleBinaryOperator val$operator = doubleBinaryOperator;
                        BytecodeManager.incBytecodes(7);
                        final ReduceOps.ReducingSink reducingSink = new ReduceOps.ReducingSink();
                        BytecodeManager.incBytecodes(1);
                        return reducingSink;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
            };
            BytecodeManager.incBytecodes(1);
            return reduceOp;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static TerminalOp<Double, OptionalDouble> makeDouble(final DoubleBinaryOperator doubleBinaryOperator) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(doubleBinaryOperator);
            BytecodeManager.incBytecodes(1);
            final StreamShape double_VALUE = StreamShape.DOUBLE_VALUE;
            BytecodeManager.incBytecodes(5);
            class ReducingSink implements AccumulatingSink<Double, OptionalDouble, ReducingSink>, Sink.OfDouble
            {
                private boolean empty;
                private double state;
                
                ReducingSink() {
                    try {
                        BytecodeManager.incBytecodes(5);
                        BytecodeManager.incBytecodes(1);
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public void begin(final long n) {
                    try {
                        this.empty = true;
                        BytecodeManager.incBytecodes(3);
                        this.state = 0.0;
                        BytecodeManager.incBytecodes(3);
                        BytecodeManager.incBytecodes(1);
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public void accept(final double state) {
                    try {
                        final boolean empty = this.empty;
                        BytecodeManager.incBytecodes(3);
                        if (empty) {
                            this.empty = false;
                            BytecodeManager.incBytecodes(3);
                            this.state = state;
                            BytecodeManager.incBytecodes(4);
                        }
                        else {
                            final DoubleBinaryOperator val$operator = val$operator;
                            final double state2 = this.state;
                            BytecodeManager.incBytecodes(7);
                            this.state = val$operator.applyAsDouble(state2, state);
                            BytecodeManager.incBytecodes(1);
                        }
                        BytecodeManager.incBytecodes(1);
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public OptionalDouble get() {
                    try {
                        final boolean empty = this.empty;
                        BytecodeManager.incBytecodes(3);
                        OptionalDouble optionalDouble;
                        if (empty) {
                            BytecodeManager.incBytecodes(1);
                            optionalDouble = OptionalDouble.empty();
                            BytecodeManager.incBytecodes(1);
                        }
                        else {
                            final double state = this.state;
                            BytecodeManager.incBytecodes(3);
                            optionalDouble = OptionalDouble.of(state);
                        }
                        BytecodeManager.incBytecodes(1);
                        return optionalDouble;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public void combine(final ReducingSink reducingSink) {
                    try {
                        final boolean empty = reducingSink.empty;
                        BytecodeManager.incBytecodes(3);
                        if (!empty) {
                            final double state = reducingSink.state;
                            BytecodeManager.incBytecodes(4);
                            this.accept(state);
                        }
                        BytecodeManager.incBytecodes(1);
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
            }
            final ReduceOp<Double, OptionalDouble, ReducingSink> reduceOp = new ReduceOp<Double, OptionalDouble, ReducingSink>(double_VALUE) {
                {
                    BytecodeManager.incBytecodes(1);
                }
                
                @Override
                public ReduceOps.ReducingSink makeSink() {
                    try {
                        final DoubleBinaryOperator val$operator = doubleBinaryOperator;
                        BytecodeManager.incBytecodes(5);
                        final ReduceOps.ReducingSink reducingSink = new ReduceOps.ReducingSink();
                        BytecodeManager.incBytecodes(1);
                        return reducingSink;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
            };
            BytecodeManager.incBytecodes(1);
            return reduceOp;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <R> TerminalOp<Double, R> makeDouble(final Supplier<R> supplier, final ObjDoubleConsumer<R> objDoubleConsumer, final BinaryOperator<R> binaryOperator) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(supplier);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(objDoubleConsumer);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(binaryOperator);
            BytecodeManager.incBytecodes(1);
            final StreamShape double_VALUE = StreamShape.DOUBLE_VALUE;
            BytecodeManager.incBytecodes(7);
            class ReducingSink extends Box<R> implements AccumulatingSink<Double, R, ReducingSink>, Sink.OfDouble
            {
                ReducingSink() {
                    try {
                        BytecodeManager.incBytecodes(11);
                        BytecodeManager.incBytecodes(1);
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public void begin(final long n) {
                    try {
                        final Supplier val$supplier = val$supplier;
                        BytecodeManager.incBytecodes(4);
                        this.state = val$supplier.get();
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public void accept(final double n) {
                    try {
                        final ObjDoubleConsumer val$accumulator = val$accumulator;
                        final U state = this.state;
                        BytecodeManager.incBytecodes(6);
                        val$accumulator.accept(state, n);
                        BytecodeManager.incBytecodes(1);
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public void combine(final ReducingSink reducingSink) {
                    try {
                        final BinaryOperator val$combiner = val$combiner;
                        final U state = this.state;
                        final U state2 = reducingSink.state;
                        BytecodeManager.incBytecodes(8);
                        this.state = (U)val$combiner.apply(state, state2);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
            }
            final ReduceOp<Double, R, ReducingSink> reduceOp = new ReduceOp<Double, R, ReducingSink>(double_VALUE) {
                {
                    BytecodeManager.incBytecodes(1);
                }
                
                @Override
                public ReduceOps.ReducingSink makeSink() {
                    try {
                        final Supplier val$supplier = supplier;
                        final ObjDoubleConsumer val$accumulator = objDoubleConsumer;
                        final BinaryOperator val$combiner = binaryOperator;
                        BytecodeManager.incBytecodes(9);
                        final ReduceOps.ReducingSink reducingSink = new ReduceOps.ReducingSink();
                        BytecodeManager.incBytecodes(1);
                        return reducingSink;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
            };
            BytecodeManager.incBytecodes(1);
            return reduceOp;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private abstract static class Box<U>
    {
        U state;
        
        Box() {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public U get() {
            try {
                final U state = this.state;
                BytecodeManager.incBytecodes(3);
                return state;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private abstract static class ReduceOp<T, R, S extends AccumulatingSink<T, R, S>> implements TerminalOp<T, R>
    {
        private final StreamShape inputShape;
        
        ReduceOp(final StreamShape inputShape) {
            try {
                BytecodeManager.incBytecodes(2);
                this.inputShape = inputShape;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public abstract S makeSink();
        
        @Override
        public StreamShape inputShape() {
            try {
                final StreamShape inputShape = this.inputShape;
                BytecodeManager.incBytecodes(3);
                return inputShape;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public <P_IN> R evaluateSequential(final PipelineHelper<T> pipelineHelper, final Spliterator<P_IN> spliterator) {
            try {
                BytecodeManager.incBytecodes(3);
                final AccumulatingSink<?, Object, ?> sink = this.makeSink();
                BytecodeManager.incBytecodes(2);
                final AccumulatingSink<?, Object, ?> accumulatingSink = pipelineHelper.wrapAndCopyInto(sink, spliterator);
                BytecodeManager.incBytecodes(2);
                final R value = accumulatingSink.get();
                BytecodeManager.incBytecodes(1);
                return value;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public <P_IN> R evaluateParallel(final PipelineHelper<T> pipelineHelper, final Spliterator<P_IN> spliterator) {
            try {
                BytecodeManager.incBytecodes(6);
                final ReduceTask reduceTask = new ReduceTask((ReduceOp<Object, Object, AccumulatingSink>)this, (PipelineHelper<Object>)pipelineHelper, (Spliterator<Object>)spliterator);
                BytecodeManager.incBytecodes(1);
                final AccumulatingSink<?, Object, ?> accumulatingSink = reduceTask.invoke();
                BytecodeManager.incBytecodes(2);
                final R value = accumulatingSink.get();
                BytecodeManager.incBytecodes(1);
                return value;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private static final class ReduceTask<P_IN, P_OUT, R, S extends AccumulatingSink<P_OUT, R, S>> extends AbstractTask<P_IN, P_OUT, S, ReduceTask<P_IN, P_OUT, R, S>>
    {
        private final ReduceOp<P_OUT, R, S> op;
        
        ReduceTask(final ReduceOp<P_OUT, R, S> op, final PipelineHelper<P_OUT> pipelineHelper, final Spliterator<P_IN> spliterator) {
            try {
                BytecodeManager.incBytecodes(4);
                super(pipelineHelper, spliterator);
                this.op = op;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        ReduceTask(final ReduceTask<P_IN, P_OUT, R, S> reduceTask, final Spliterator<P_IN> spliterator) {
            try {
                BytecodeManager.incBytecodes(4);
                super(reduceTask, spliterator);
                this.op = reduceTask.op;
                BytecodeManager.incBytecodes(4);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        protected ReduceTask<P_IN, P_OUT, R, S> makeChild(final Spliterator<P_IN> spliterator) {
            try {
                BytecodeManager.incBytecodes(5);
                final ReduceTask<P_IN, P_OUT, R, S> reduceTask = new ReduceTask<P_IN, P_OUT, R, S>(this, spliterator);
                BytecodeManager.incBytecodes(1);
                return reduceTask;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        protected S doLeaf() {
            try {
                final PipelineHelper<P_OUT> helper = this.helper;
                final ReduceOp<P_OUT, R, S> op = this.op;
                BytecodeManager.incBytecodes(5);
                final AccumulatingSink<P_OUT, R, S> sink = op.makeSink();
                final Spliterator<P_IN> spliterator = this.spliterator;
                BytecodeManager.incBytecodes(3);
                final AccumulatingSink<P_OUT, R, S> accumulatingSink = helper.wrapAndCopyInto(sink, spliterator);
                BytecodeManager.incBytecodes(2);
                return (S)accumulatingSink;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void onCompletion(final CountedCompleter<?> countedCompleter) {
            try {
                BytecodeManager.incBytecodes(2);
                final boolean leaf = this.isLeaf();
                BytecodeManager.incBytecodes(1);
                if (!leaf) {
                    final ReduceTask reduceTask = (ReduceTask)this.leftChild;
                    BytecodeManager.incBytecodes(4);
                    final AccumulatingSink<T, R, AccumulatingSink> accumulatingSink = reduceTask.getLocalResult();
                    BytecodeManager.incBytecodes(2);
                    final AccumulatingSink<P_OUT, R, S> accumulatingSink2 = (AccumulatingSink<P_OUT, R, S>)accumulatingSink;
                    final ReduceTask reduceTask2 = (ReduceTask)this.rightChild;
                    BytecodeManager.incBytecodes(5);
                    final AccumulatingSink accumulatingSink3 = reduceTask2.getLocalResult();
                    BytecodeManager.incBytecodes(2);
                    accumulatingSink2.combine((S)accumulatingSink3);
                    final AccumulatingSink<P_OUT, R, S> localResult = (AccumulatingSink<P_OUT, R, S>)accumulatingSink;
                    BytecodeManager.incBytecodes(3);
                    this.setLocalResult((S)localResult);
                }
                BytecodeManager.incBytecodes(3);
                super.onCompletion(countedCompleter);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private interface AccumulatingSink<T, R, K extends AccumulatingSink<T, R, K>> extends TerminalSink<T, R>
    {
        void combine(final K p0);
    }
}
