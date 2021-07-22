// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.stream;

import java.util.Iterator;
import instrumented.java.util.function.BinaryOperator;
import instrumented.java.util.IntSummaryStatistics;
import instrumented.java.util.function.BiConsumer;
import instrumented.java.util.function.ObjIntConsumer;
import instrumented.java.util.OptionalDouble;
import instrumented.java.util.OptionalInt;
import instrumented.java.util.function.IntBinaryOperator;
import instrumented.java.util.function.ToIntFunction;
import instrumented.java.util.function.IntPredicate;
import instrumented.java.util.function.IntToDoubleFunction;
import instrumented.java.util.function.IntToLongFunction;
import instrumented.java.util.Objects;
import instrumented.java.util.function.IntUnaryOperator;
import instrumented.java.util.Spliterators;
import instrumented.java.util.PrimitiveIterator;
import instrumented.java.util.function.IntFunction;
import instrumented.java.util.function.IntConsumer;
import aic2021.engine.BytecodeManager;
import instrumented.java.util.Spliterator;
import instrumented.java.util.function.Supplier;

abstract class IntPipeline<E_IN> extends AbstractPipeline<E_IN, Integer, IntStream> implements IntStream
{
    IntPipeline(final Supplier<? extends Spliterator<Integer>> supplier, final int n, final boolean b) {
        try {
            BytecodeManager.incBytecodes(5);
            super(supplier, n, b);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    IntPipeline(final Spliterator<Integer> spliterator, final int n, final boolean b) {
        try {
            BytecodeManager.incBytecodes(5);
            super(spliterator, n, b);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    IntPipeline(final AbstractPipeline<?, E_IN, ?> abstractPipeline, final int n) {
        try {
            BytecodeManager.incBytecodes(4);
            super(abstractPipeline, n);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static IntConsumer adapt(final Sink<Integer> sink) {
        try {
            final boolean b = sink instanceof IntConsumer;
            BytecodeManager.incBytecodes(3);
            if (b) {
                final IntConsumer intConsumer = (IntConsumer)sink;
                BytecodeManager.incBytecodes(3);
                return intConsumer;
            }
            final boolean enabled = Tripwire.ENABLED;
            BytecodeManager.incBytecodes(2);
            if (enabled) {
                final Class<AbstractPipeline> clazz = AbstractPipeline.class;
                final String s = "using IntStream.adapt(Sink<Integer> s)";
                BytecodeManager.incBytecodes(3);
                Tripwire.trip(clazz, s);
            }
            BytecodeManager.incBytecodes(3);
            sink.getClass();
            final IntConsumer intConsumer2 = sink::accept;
            BytecodeManager.incBytecodes(2);
            return intConsumer2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static Spliterator.OfInt adapt(final Spliterator<Integer> spliterator) {
        try {
            final boolean b = spliterator instanceof Spliterator.OfInt;
            BytecodeManager.incBytecodes(3);
            if (b) {
                final Spliterator.OfInt ofInt = (Spliterator.OfInt)spliterator;
                BytecodeManager.incBytecodes(3);
                return ofInt;
            }
            final boolean enabled = Tripwire.ENABLED;
            BytecodeManager.incBytecodes(2);
            if (enabled) {
                final Class<AbstractPipeline> clazz = AbstractPipeline.class;
                final String s = "using IntStream.adapt(Spliterator<Integer> s)";
                BytecodeManager.incBytecodes(3);
                Tripwire.trip(clazz, s);
            }
            final String message = "IntStream.adapt(Spliterator<Integer> s)";
            BytecodeManager.incBytecodes(4);
            final UnsupportedOperationException ex = new UnsupportedOperationException(message);
            BytecodeManager.incBytecodes(1);
            throw ex;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    final StreamShape getOutputShape() {
        try {
            final StreamShape int_VALUE = StreamShape.INT_VALUE;
            BytecodeManager.incBytecodes(2);
            return int_VALUE;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    final <P_IN> Node<Integer> evaluateToNode(final PipelineHelper<Integer> pipelineHelper, final Spliterator<P_IN> spliterator, final boolean b, final IntFunction<Integer[]> intFunction) {
        try {
            BytecodeManager.incBytecodes(4);
            final Node.OfInt collectInt = Nodes.collectInt(pipelineHelper, spliterator, b);
            BytecodeManager.incBytecodes(1);
            return collectInt;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    final <P_IN> Spliterator<Integer> wrap(final PipelineHelper<Integer> pipelineHelper, final Supplier<Spliterator<P_IN>> supplier, final boolean b) {
        try {
            BytecodeManager.incBytecodes(6);
            final StreamSpliterators.IntWrappingSpliterator<Object> intWrappingSpliterator = new StreamSpliterators.IntWrappingSpliterator<Object>(pipelineHelper, (Supplier<Spliterator<Object>>)supplier, b);
            BytecodeManager.incBytecodes(1);
            return intWrappingSpliterator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    final Spliterator.OfInt lazySpliterator(final Supplier<? extends Spliterator<Integer>> supplier) {
        try {
            BytecodeManager.incBytecodes(4);
            final StreamSpliterators.DelegatingSpliterator.OfInt ofInt = new StreamSpliterators.DelegatingSpliterator.OfInt((Supplier<Spliterator.OfInt>)supplier);
            BytecodeManager.incBytecodes(1);
            return ofInt;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    final void forEachWithCancel(final Spliterator<Integer> spliterator, final Sink<Integer> sink) {
        try {
            BytecodeManager.incBytecodes(2);
            final Spliterator.OfInt adapt = adapt(spliterator);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            final IntConsumer adapt2 = adapt(sink);
            BytecodeManager.incBytecodes(1);
            boolean tryAdvance;
            do {
                BytecodeManager.incBytecodes(2);
                final boolean cancellationRequested = sink.cancellationRequested();
                BytecodeManager.incBytecodes(1);
                if (cancellationRequested) {
                    break;
                }
                final Spliterator.OfInt ofInt = adapt;
                final IntConsumer intConsumer = adapt2;
                BytecodeManager.incBytecodes(3);
                tryAdvance = ofInt.tryAdvance(intConsumer);
                BytecodeManager.incBytecodes(1);
            } while (tryAdvance);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    final Node.Builder<Integer> makeNodeBuilder(final long n, final IntFunction<Integer[]> intFunction) {
        try {
            BytecodeManager.incBytecodes(2);
            final Node.Builder.OfInt intBuilder = Nodes.intBuilder(n);
            BytecodeManager.incBytecodes(1);
            return intBuilder;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final PrimitiveIterator.OfInt iterator() {
        try {
            BytecodeManager.incBytecodes(2);
            final Spliterator.OfInt spliterator = this.spliterator();
            BytecodeManager.incBytecodes(1);
            final PrimitiveIterator.OfInt iterator = Spliterators.iterator(spliterator);
            BytecodeManager.incBytecodes(1);
            return iterator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final Spliterator.OfInt spliterator() {
        try {
            BytecodeManager.incBytecodes(2);
            final Spliterator<Integer> spliterator = super.spliterator();
            BytecodeManager.incBytecodes(1);
            final Spliterator.OfInt adapt = adapt(spliterator);
            BytecodeManager.incBytecodes(1);
            return adapt;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final LongStream asLongStream() {
        try {
            final StreamShape int_VALUE = StreamShape.INT_VALUE;
            final int n = StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT;
            BytecodeManager.incBytecodes(9);
            final LongPipeline.StatelessOp<Integer> statelessOp = new LongPipeline.StatelessOp<Integer>(this, int_VALUE, n) {
                {
                    BytecodeManager.incBytecodes(1);
                }
                
                @Override
                Sink<Integer> opWrapSink(final int n, final Sink<Long> sink) {
                    try {
                        BytecodeManager.incBytecodes(5);
                        final Sink.ChainedInt<Long> chainedInt = new Sink.ChainedInt<Long>(sink) {
                            {
                                BytecodeManager.incBytecodes(1);
                            }
                            
                            @Override
                            public void accept(final int n) {
                                try {
                                    final Sink<? super E_OUT> downstream = this.downstream;
                                    final long n2 = n;
                                    BytecodeManager.incBytecodes(5);
                                    downstream.accept(n2);
                                    BytecodeManager.incBytecodes(1);
                                }
                                finally {
                                    throw loadexception(java.lang.Throwable.class);
                                }
                            }
                        };
                        BytecodeManager.incBytecodes(1);
                        return chainedInt;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
            };
            BytecodeManager.incBytecodes(1);
            return statelessOp;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final DoubleStream asDoubleStream() {
        try {
            final StreamShape int_VALUE = StreamShape.INT_VALUE;
            final int n = StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT;
            BytecodeManager.incBytecodes(9);
            final DoublePipeline.StatelessOp<Integer> statelessOp = new DoublePipeline.StatelessOp<Integer>(this, int_VALUE, n) {
                {
                    BytecodeManager.incBytecodes(1);
                }
                
                @Override
                Sink<Integer> opWrapSink(final int n, final Sink<Double> sink) {
                    try {
                        BytecodeManager.incBytecodes(5);
                        final Sink.ChainedInt<Double> chainedInt = new Sink.ChainedInt<Double>(sink) {
                            {
                                BytecodeManager.incBytecodes(1);
                            }
                            
                            @Override
                            public void accept(final int n) {
                                try {
                                    final Sink<? super E_OUT> downstream = this.downstream;
                                    final double n2 = n;
                                    BytecodeManager.incBytecodes(5);
                                    downstream.accept(n2);
                                    BytecodeManager.incBytecodes(1);
                                }
                                finally {
                                    throw loadexception(java.lang.Throwable.class);
                                }
                            }
                        };
                        BytecodeManager.incBytecodes(1);
                        return chainedInt;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
            };
            BytecodeManager.incBytecodes(1);
            return statelessOp;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final Stream<Integer> boxed() {
        try {
            final IntFunction<Integer> intFunction = Integer::valueOf;
            BytecodeManager.incBytecodes(2);
            final Stream<Object> mapToObj = this.mapToObj((IntFunction<?>)intFunction);
            BytecodeManager.incBytecodes(1);
            return (Stream<Integer>)mapToObj;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final IntStream map(final IntUnaryOperator intUnaryOperator) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(intUnaryOperator);
            BytecodeManager.incBytecodes(1);
            final StreamShape int_VALUE = StreamShape.INT_VALUE;
            final int n = StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT;
            BytecodeManager.incBytecodes(10);
            final StatelessOp<Integer> statelessOp = new StatelessOp<Integer>(this, int_VALUE, n) {
                {
                    BytecodeManager.incBytecodes(1);
                }
                
                @Override
                Sink<Integer> opWrapSink(final int n, final Sink<Integer> sink) {
                    try {
                        BytecodeManager.incBytecodes(5);
                        final Sink.ChainedInt<Integer> chainedInt = new Sink.ChainedInt<Integer>(sink) {
                            {
                                BytecodeManager.incBytecodes(1);
                            }
                            
                            @Override
                            public void accept(final int n) {
                                try {
                                    final Sink<? super E_OUT> downstream = this.downstream;
                                    final IntUnaryOperator val$mapper = intUnaryOperator;
                                    BytecodeManager.incBytecodes(7);
                                    final int applyAsInt = val$mapper.applyAsInt(n);
                                    BytecodeManager.incBytecodes(1);
                                    downstream.accept(applyAsInt);
                                    BytecodeManager.incBytecodes(1);
                                }
                                finally {
                                    throw loadexception(java.lang.Throwable.class);
                                }
                            }
                        };
                        BytecodeManager.incBytecodes(1);
                        return chainedInt;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
            };
            BytecodeManager.incBytecodes(1);
            return statelessOp;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final <U> Stream<U> mapToObj(final IntFunction<? extends U> intFunction) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(intFunction);
            BytecodeManager.incBytecodes(1);
            final StreamShape int_VALUE = StreamShape.INT_VALUE;
            final int n = StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT;
            BytecodeManager.incBytecodes(10);
            final ReferencePipeline.StatelessOp<Integer, U> statelessOp = new ReferencePipeline.StatelessOp<Integer, U>(this, int_VALUE, n) {
                {
                    BytecodeManager.incBytecodes(1);
                }
                
                @Override
                Sink<Integer> opWrapSink(final int n, final Sink<U> sink) {
                    try {
                        BytecodeManager.incBytecodes(5);
                        final Sink.ChainedInt<U> chainedInt = new Sink.ChainedInt<U>(sink) {
                            {
                                BytecodeManager.incBytecodes(1);
                            }
                            
                            @Override
                            public void accept(final int n) {
                                try {
                                    final Sink<? super E_OUT> downstream = this.downstream;
                                    final IntFunction val$mapper = intFunction;
                                    BytecodeManager.incBytecodes(7);
                                    final Object apply = val$mapper.apply(n);
                                    BytecodeManager.incBytecodes(1);
                                    downstream.accept(apply);
                                    BytecodeManager.incBytecodes(1);
                                }
                                finally {
                                    throw loadexception(java.lang.Throwable.class);
                                }
                            }
                        };
                        BytecodeManager.incBytecodes(1);
                        return chainedInt;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
            };
            BytecodeManager.incBytecodes(1);
            return statelessOp;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final LongStream mapToLong(final IntToLongFunction intToLongFunction) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(intToLongFunction);
            BytecodeManager.incBytecodes(1);
            final StreamShape int_VALUE = StreamShape.INT_VALUE;
            final int n = StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT;
            BytecodeManager.incBytecodes(10);
            final LongPipeline.StatelessOp<Integer> statelessOp = new LongPipeline.StatelessOp<Integer>(this, int_VALUE, n) {
                {
                    BytecodeManager.incBytecodes(1);
                }
                
                @Override
                Sink<Integer> opWrapSink(final int n, final Sink<Long> sink) {
                    try {
                        BytecodeManager.incBytecodes(5);
                        final Sink.ChainedInt<Long> chainedInt = new Sink.ChainedInt<Long>(sink) {
                            {
                                BytecodeManager.incBytecodes(1);
                            }
                            
                            @Override
                            public void accept(final int n) {
                                try {
                                    final Sink<? super E_OUT> downstream = this.downstream;
                                    final IntToLongFunction val$mapper = intToLongFunction;
                                    BytecodeManager.incBytecodes(7);
                                    final long applyAsLong = val$mapper.applyAsLong(n);
                                    BytecodeManager.incBytecodes(1);
                                    downstream.accept(applyAsLong);
                                    BytecodeManager.incBytecodes(1);
                                }
                                finally {
                                    throw loadexception(java.lang.Throwable.class);
                                }
                            }
                        };
                        BytecodeManager.incBytecodes(1);
                        return chainedInt;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
            };
            BytecodeManager.incBytecodes(1);
            return statelessOp;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final DoubleStream mapToDouble(final IntToDoubleFunction intToDoubleFunction) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(intToDoubleFunction);
            BytecodeManager.incBytecodes(1);
            final StreamShape int_VALUE = StreamShape.INT_VALUE;
            final int n = StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT;
            BytecodeManager.incBytecodes(10);
            final DoublePipeline.StatelessOp<Integer> statelessOp = new DoublePipeline.StatelessOp<Integer>(this, int_VALUE, n) {
                {
                    BytecodeManager.incBytecodes(1);
                }
                
                @Override
                Sink<Integer> opWrapSink(final int n, final Sink<Double> sink) {
                    try {
                        BytecodeManager.incBytecodes(5);
                        final Sink.ChainedInt<Double> chainedInt = new Sink.ChainedInt<Double>(sink) {
                            {
                                BytecodeManager.incBytecodes(1);
                            }
                            
                            @Override
                            public void accept(final int n) {
                                try {
                                    final Sink<? super E_OUT> downstream = this.downstream;
                                    final IntToDoubleFunction val$mapper = intToDoubleFunction;
                                    BytecodeManager.incBytecodes(7);
                                    final double applyAsDouble = val$mapper.applyAsDouble(n);
                                    BytecodeManager.incBytecodes(1);
                                    downstream.accept(applyAsDouble);
                                    BytecodeManager.incBytecodes(1);
                                }
                                finally {
                                    throw loadexception(java.lang.Throwable.class);
                                }
                            }
                        };
                        BytecodeManager.incBytecodes(1);
                        return chainedInt;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
            };
            BytecodeManager.incBytecodes(1);
            return statelessOp;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final IntStream flatMap(final IntFunction<? extends IntStream> intFunction) {
        try {
            final StreamShape int_VALUE = StreamShape.INT_VALUE;
            final int n = StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT | StreamOpFlag.NOT_SIZED;
            BytecodeManager.incBytecodes(12);
            final StatelessOp<Integer> statelessOp = new StatelessOp<Integer>(this, int_VALUE, n) {
                {
                    BytecodeManager.incBytecodes(1);
                }
                
                @Override
                Sink<Integer> opWrapSink(final int n, final Sink<Integer> sink) {
                    try {
                        BytecodeManager.incBytecodes(5);
                        final Sink.ChainedInt<Integer> chainedInt = new Sink.ChainedInt<Integer>(sink) {
                            {
                                BytecodeManager.incBytecodes(1);
                            }
                            
                            @Override
                            public void begin(final long n) {
                                try {
                                    final Sink<? super E_OUT> downstream = this.downstream;
                                    final long n2 = -1L;
                                    BytecodeManager.incBytecodes(4);
                                    downstream.begin(n2);
                                    BytecodeManager.incBytecodes(1);
                                }
                                finally {
                                    throw loadexception(java.lang.Throwable.class);
                                }
                            }
                            
                            @Override
                            public void accept(final int p0) {
                                // 
                                // This method could not be decompiled.
                                // 
                                // Original Bytecode:
                                // 
                                //     1: getfield        instrumented/java/util/stream/IntPipeline$7$1.this$1:Linstrumented/java/util/stream/IntPipeline$7;
                                //     4: getfield        instrumented/java/util/stream/IntPipeline$7.val$mapper:Linstrumented/java/util/function/IntFunction;
                                //     7: iload_1        
                                //     8: ldc             5
                                //    10: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //    13: invokeinterface instrumented/java/util/function/IntFunction.apply:(I)Ljava/lang/Object;
                                //    18: checkcast       Linstrumented/java/util/stream/IntStream;
                                //    21: astore_2       
                                //    22: aconst_null    
                                //    23: astore_3       
                                //    24: ldc             4
                                //    26: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //    29: aload_2        
                                //    30: ldc             2
                                //    32: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //    35: ifnull          65
                                //    38: aload_2        
                                //    39: ldc             2
                                //    41: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //    44: invokeinterface instrumented/java/util/stream/IntStream.sequential:()Linstrumented/java/util/stream/IntStream;
                                //    49: aload_0        
                                //    50: invokedynamic   BootstrapMethod #0, accept:(Linstrumented/java/util/stream/IntPipeline$7$1;)Linstrumented/java/util/function/IntConsumer;
                                //    55: ldc             2
                                //    57: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //    60: invokeinterface instrumented/java/util/stream/IntStream.forEach:(Linstrumented/java/util/function/IntConsumer;)V
                                //    65: aload_2        
                                //    66: ldc             2
                                //    68: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //    71: ifnull          239
                                //    74: aload_3        
                                //    75: ldc             2
                                //    77: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //    80: ifnull          123
                                //    83: aload_2        
                                //    84: ldc             2
                                //    86: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //    89: invokeinterface instrumented/java/util/stream/IntStream.close:()V
                                //    94: ldc             1
                                //    96: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //    99: goto            239
                                //   102: astore          4
                                //   104: aload_3        
                                //   105: aload           4
                                //   107: ldc             504
                                //   109: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   112: invokevirtual   java/lang/Throwable.addSuppressed:(Ljava/lang/Throwable;)V
                                //   115: ldc             1
                                //   117: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   120: goto            239
                                //   123: aload_2        
                                //   124: ldc             2
                                //   126: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   129: invokeinterface instrumented/java/util/stream/IntStream.close:()V
                                //   134: ldc             1
                                //   136: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   139: goto            239
                                //   142: astore          4
                                //   144: aload           4
                                //   146: astore_3       
                                //   147: aload           4
                                //   149: ldc             505
                                //   151: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   154: athrow         
                                //   155: astore          5
                                //   157: ldc             501
                                //   159: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   162: aload_2        
                                //   163: ldc             2
                                //   165: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   168: ifnull          231
                                //   171: aload_3        
                                //   172: ldc             2
                                //   174: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   177: ifnull          220
                                //   180: aload_2        
                                //   181: ldc             2
                                //   183: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   186: invokeinterface instrumented/java/util/stream/IntStream.close:()V
                                //   191: ldc             1
                                //   193: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   196: goto            231
                                //   199: astore          6
                                //   201: aload_3        
                                //   202: aload           6
                                //   204: ldc             504
                                //   206: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   209: invokevirtual   java/lang/Throwable.addSuppressed:(Ljava/lang/Throwable;)V
                                //   212: ldc             1
                                //   214: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   217: goto            231
                                //   220: aload_2        
                                //   221: ldc             2
                                //   223: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   226: invokeinterface instrumented/java/util/stream/IntStream.close:()V
                                //   231: aload           5
                                //   233: ldc             2
                                //   235: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   238: athrow         
                                //   239: ldc             1
                                //   241: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   244: return         
                                //   245: athrow         
                                //   246: athrow         
                                //    StackMapTable: 00 0B FD 00 41 07 00 41 07 00 26 64 07 00 26 14 52 07 00 26 4C 07 00 26 FF 00 2B 00 06 07 00 02 01 07 00 41 07 00 26 00 07 00 26 00 01 07 00 26 14 0A FF 00 07 00 02 07 00 02 01 00 00 FF 00 05 00 00 00 01 07 00 26 FF 00 00 00 00 00 01 07 00 34
                                //    Exceptions:
                                //  Try           Handler
                                //  Start  End    Start  End    Type                           
                                //  -----  -----  -----  -----  -------------------------------
                                //  29     246    246    247    Ljava/lang/VirtualMachineError;
                                //  83     94     102    123    Ljava/lang/Throwable;
                                //  29     65     142    155    Ljava/lang/Throwable;
                                //  29     65     155    239    Any
                                //  180    191    199    220    Ljava/lang/Throwable;
                                //  142    162    155    239    Any
                                //  0      245    245    246    Any
                                // 
                                // The error that occurred was:
                                // 
                                // java.lang.IllegalStateException: Expression is linked from several locations: Label_0065:
                                //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
                                //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2596)
                                //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
                                //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
                                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
                                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
                                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
                                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
                                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
                                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
                                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
                                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
                                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformCall(AstMethodBodyBuilder.java:1164)
                                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformByteCode(AstMethodBodyBuilder.java:1009)
                                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformExpression(AstMethodBodyBuilder.java:540)
                                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformByteCode(AstMethodBodyBuilder.java:554)
                                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformExpression(AstMethodBodyBuilder.java:540)
                                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformNode(AstMethodBodyBuilder.java:392)
                                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformBlock(AstMethodBodyBuilder.java:333)
                                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformNode(AstMethodBodyBuilder.java:494)
                                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformBlock(AstMethodBodyBuilder.java:333)
                                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:294)
                                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
                                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
                                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
                                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
                                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
                                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
                                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
                                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformCall(AstMethodBodyBuilder.java:1164)
                                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformByteCode(AstMethodBodyBuilder.java:1009)
                                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformExpression(AstMethodBodyBuilder.java:540)
                                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformByteCode(AstMethodBodyBuilder.java:554)
                                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformExpression(AstMethodBodyBuilder.java:540)
                                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformNode(AstMethodBodyBuilder.java:392)
                                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformBlock(AstMethodBodyBuilder.java:333)
                                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformNode(AstMethodBodyBuilder.java:494)
                                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformBlock(AstMethodBodyBuilder.java:333)
                                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:294)
                                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
                                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
                                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
                                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
                                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
                                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
                                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
                                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
                                //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
                                //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
                                //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
                                //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
                                //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
                                // 
                                throw new IllegalStateException("An error occurred while decompiling this method.");
                            }
                        };
                        BytecodeManager.incBytecodes(1);
                        return chainedInt;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
            };
            BytecodeManager.incBytecodes(1);
            return statelessOp;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public IntStream unordered() {
        try {
            BytecodeManager.incBytecodes(2);
            final boolean ordered = this.isOrdered();
            BytecodeManager.incBytecodes(1);
            if (!ordered) {
                BytecodeManager.incBytecodes(2);
                return this;
            }
            final StreamShape int_VALUE = StreamShape.INT_VALUE;
            final int not_ORDERED = StreamOpFlag.NOT_ORDERED;
            BytecodeManager.incBytecodes(7);
            final StatelessOp<Integer> statelessOp = new StatelessOp<Integer>(this, int_VALUE, not_ORDERED) {
                {
                    BytecodeManager.incBytecodes(1);
                }
                
                @Override
                Sink<Integer> opWrapSink(final int n, final Sink<Integer> sink) {
                    try {
                        BytecodeManager.incBytecodes(2);
                        return sink;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
            };
            BytecodeManager.incBytecodes(1);
            return statelessOp;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final IntStream filter(final IntPredicate intPredicate) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(intPredicate);
            BytecodeManager.incBytecodes(1);
            final StreamShape int_VALUE = StreamShape.INT_VALUE;
            final int not_SIZED = StreamOpFlag.NOT_SIZED;
            BytecodeManager.incBytecodes(8);
            final StatelessOp<Integer> statelessOp = new StatelessOp<Integer>(this, int_VALUE, not_SIZED) {
                {
                    BytecodeManager.incBytecodes(1);
                }
                
                @Override
                Sink<Integer> opWrapSink(final int n, final Sink<Integer> sink) {
                    try {
                        BytecodeManager.incBytecodes(5);
                        final Sink.ChainedInt<Integer> chainedInt = new Sink.ChainedInt<Integer>(sink) {
                            {
                                BytecodeManager.incBytecodes(1);
                            }
                            
                            @Override
                            public void begin(final long n) {
                                try {
                                    final Sink<? super E_OUT> downstream = this.downstream;
                                    final long n2 = -1L;
                                    BytecodeManager.incBytecodes(4);
                                    downstream.begin(n2);
                                    BytecodeManager.incBytecodes(1);
                                }
                                finally {
                                    throw loadexception(java.lang.Throwable.class);
                                }
                            }
                            
                            @Override
                            public void accept(final int n) {
                                try {
                                    final IntPredicate val$predicate = intPredicate;
                                    BytecodeManager.incBytecodes(5);
                                    final boolean test = val$predicate.test(n);
                                    BytecodeManager.incBytecodes(1);
                                    if (test) {
                                        final Sink<? super E_OUT> downstream = this.downstream;
                                        BytecodeManager.incBytecodes(4);
                                        downstream.accept(n);
                                    }
                                    BytecodeManager.incBytecodes(1);
                                }
                                finally {
                                    throw loadexception(java.lang.Throwable.class);
                                }
                            }
                        };
                        BytecodeManager.incBytecodes(1);
                        return chainedInt;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
            };
            BytecodeManager.incBytecodes(1);
            return statelessOp;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final IntStream peek(final IntConsumer intConsumer) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(intConsumer);
            BytecodeManager.incBytecodes(1);
            final StreamShape int_VALUE = StreamShape.INT_VALUE;
            final int n = 0;
            BytecodeManager.incBytecodes(8);
            final StatelessOp<Integer> statelessOp = new StatelessOp<Integer>(this, int_VALUE, n) {
                {
                    BytecodeManager.incBytecodes(1);
                }
                
                @Override
                Sink<Integer> opWrapSink(final int n, final Sink<Integer> sink) {
                    try {
                        BytecodeManager.incBytecodes(5);
                        final Sink.ChainedInt<Integer> chainedInt = new Sink.ChainedInt<Integer>(sink) {
                            {
                                BytecodeManager.incBytecodes(1);
                            }
                            
                            @Override
                            public void accept(final int n) {
                                try {
                                    final IntConsumer val$action = intConsumer;
                                    BytecodeManager.incBytecodes(5);
                                    val$action.accept(n);
                                    final Sink<? super E_OUT> downstream = this.downstream;
                                    BytecodeManager.incBytecodes(4);
                                    downstream.accept(n);
                                    BytecodeManager.incBytecodes(1);
                                }
                                finally {
                                    throw loadexception(java.lang.Throwable.class);
                                }
                            }
                        };
                        BytecodeManager.incBytecodes(1);
                        return chainedInt;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
            };
            BytecodeManager.incBytecodes(1);
            return statelessOp;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final IntStream limit(final long i) {
        try {
            final long n = lcmp(i, 0L);
            BytecodeManager.incBytecodes(4);
            if (n < 0) {
                BytecodeManager.incBytecodes(4);
                final String string = Long.toString(i);
                BytecodeManager.incBytecodes(1);
                final IllegalArgumentException ex = new IllegalArgumentException(string);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final long n2 = 0L;
            BytecodeManager.incBytecodes(4);
            final IntStream int1 = SliceOps.makeInt(this, n2, i);
            BytecodeManager.incBytecodes(1);
            return int1;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final IntStream skip(final long i) {
        try {
            final long n = lcmp(i, 0L);
            BytecodeManager.incBytecodes(4);
            if (n < 0) {
                BytecodeManager.incBytecodes(4);
                final String string = Long.toString(i);
                BytecodeManager.incBytecodes(1);
                final IllegalArgumentException ex = new IllegalArgumentException(string);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final long n2 = lcmp(i, 0L);
            BytecodeManager.incBytecodes(4);
            if (n2 == 0) {
                BytecodeManager.incBytecodes(2);
                return this;
            }
            final long n3 = -1L;
            BytecodeManager.incBytecodes(4);
            final IntStream int1 = SliceOps.makeInt(this, i, n3);
            BytecodeManager.incBytecodes(1);
            return int1;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final IntStream sorted() {
        try {
            BytecodeManager.incBytecodes(2);
            final IntStream int1 = SortedOps.makeInt(this);
            BytecodeManager.incBytecodes(1);
            return int1;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final IntStream distinct() {
        try {
            BytecodeManager.incBytecodes(2);
            final Stream<Integer> boxed = this.boxed();
            BytecodeManager.incBytecodes(1);
            final Stream<Integer> distinct = boxed.distinct();
            final int n2;
            final ToIntFunction<? super Integer> toIntFunction = n -> {
                try {
                    BytecodeManager.incBytecodes(2);
                    n;
                    BytecodeManager.incBytecodes(1);
                    return n2;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            BytecodeManager.incBytecodes(1);
            final IntStream mapToInt = distinct.mapToInt(toIntFunction);
            BytecodeManager.incBytecodes(1);
            return mapToInt;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void forEach(final IntConsumer intConsumer) {
        try {
            final boolean b = false;
            BytecodeManager.incBytecodes(4);
            final TerminalOp<Integer, Void> int1 = ForEachOps.makeInt(intConsumer, b);
            BytecodeManager.incBytecodes(1);
            this.evaluate((TerminalOp<Integer, Object>)int1);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void forEachOrdered(final IntConsumer intConsumer) {
        try {
            final boolean b = true;
            BytecodeManager.incBytecodes(4);
            final TerminalOp<Integer, Void> int1 = ForEachOps.makeInt(intConsumer, b);
            BytecodeManager.incBytecodes(1);
            this.evaluate((TerminalOp<Integer, Object>)int1);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final int sum() {
        try {
            final int n = 0;
            final IntBinaryOperator intBinaryOperator = Integer::sum;
            BytecodeManager.incBytecodes(3);
            final int reduce = this.reduce(n, intBinaryOperator);
            BytecodeManager.incBytecodes(1);
            return reduce;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final OptionalInt min() {
        try {
            final IntBinaryOperator intBinaryOperator = Math::min;
            BytecodeManager.incBytecodes(2);
            final OptionalInt reduce = this.reduce(intBinaryOperator);
            BytecodeManager.incBytecodes(1);
            return reduce;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final OptionalInt max() {
        try {
            final IntBinaryOperator intBinaryOperator = Math::max;
            BytecodeManager.incBytecodes(2);
            final OptionalInt reduce = this.reduce(intBinaryOperator);
            BytecodeManager.incBytecodes(1);
            return reduce;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final long count() {
        try {
            final long n;
            final IntToLongFunction intToLongFunction = p0 -> {
                try {
                    BytecodeManager.incBytecodes(2);
                    return n;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            BytecodeManager.incBytecodes(2);
            final LongStream mapToLong = this.mapToLong(intToLongFunction);
            BytecodeManager.incBytecodes(1);
            final long sum = mapToLong.sum();
            BytecodeManager.incBytecodes(1);
            return sum;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final OptionalDouble average() {
        try {
            Object o;
            final Supplier<Object> supplier = () -> {
                try {
                    o = new long[2];
                    BytecodeManager.incBytecodes(2);
                    return o;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            final int n2;
            final int n3;
            final ObjIntConsumer<R> objIntConsumer = (array, n) -> {
                try {
                    ++array[n2];
                    BytecodeManager.incBytecodes(7);
                    array[n3] += n;
                    BytecodeManager.incBytecodes(8);
                    BytecodeManager.incBytecodes(1);
                    return;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            final int n4;
            final int n5;
            final BiConsumer<R, R> biConsumer = (array2, array3) -> {
                try {
                    array2[n4] += array3[0];
                    BytecodeManager.incBytecodes(9);
                    array2[n5] += array3[1];
                    BytecodeManager.incBytecodes(9);
                    BytecodeManager.incBytecodes(1);
                    return;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            BytecodeManager.incBytecodes(2);
            final long[] array4 = this.collect((Supplier<long[]>)supplier, (ObjIntConsumer<long[]>)objIntConsumer, (BiConsumer<long[], long[]>)biConsumer);
            BytecodeManager.incBytecodes(2);
            final long n6 = lcmp(array4[0], 0L);
            BytecodeManager.incBytecodes(6);
            OptionalDouble optionalDouble;
            if (n6 > 0) {
                final double n7 = array4[1] / (double)array4[0];
                BytecodeManager.incBytecodes(9);
                BytecodeManager.incBytecodes(1);
                optionalDouble = OptionalDouble.of(n7);
                BytecodeManager.incBytecodes(1);
            }
            else {
                BytecodeManager.incBytecodes(1);
                optionalDouble = OptionalDouble.empty();
            }
            BytecodeManager.incBytecodes(1);
            return optionalDouble;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final IntSummaryStatistics summaryStatistics() {
        try {
            final Supplier<IntSummaryStatistics> supplier = IntSummaryStatistics::new;
            final ObjIntConsumer<R> objIntConsumer = IntSummaryStatistics::accept;
            final BiConsumer<R, R> biConsumer = IntSummaryStatistics::combine;
            BytecodeManager.incBytecodes(2);
            final IntSummaryStatistics intSummaryStatistics = this.collect(supplier, (ObjIntConsumer<IntSummaryStatistics>)objIntConsumer, (BiConsumer<IntSummaryStatistics, IntSummaryStatistics>)biConsumer);
            BytecodeManager.incBytecodes(2);
            return intSummaryStatistics;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final int reduce(final int n, final IntBinaryOperator intBinaryOperator) {
        try {
            BytecodeManager.incBytecodes(4);
            final TerminalOp<Integer, Integer> int1 = ReduceOps.makeInt(n, intBinaryOperator);
            BytecodeManager.incBytecodes(1);
            final Integer n2 = this.evaluate(int1);
            BytecodeManager.incBytecodes(2);
            final int intValue = n2;
            BytecodeManager.incBytecodes(1);
            return intValue;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final OptionalInt reduce(final IntBinaryOperator intBinaryOperator) {
        try {
            BytecodeManager.incBytecodes(3);
            final TerminalOp<Integer, OptionalInt> int1 = ReduceOps.makeInt(intBinaryOperator);
            BytecodeManager.incBytecodes(1);
            final OptionalInt optionalInt = this.evaluate(int1);
            BytecodeManager.incBytecodes(2);
            return optionalInt;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final <R> R collect(final Supplier<R> supplier, final ObjIntConsumer<R> objIntConsumer, final BiConsumer<R, R> biConsumer) {
        try {
            final BinaryOperator<R> binaryOperator = (r, r2) -> {
                try {
                    BytecodeManager.incBytecodes(4);
                    biConsumer.accept(r, r2);
                    BytecodeManager.incBytecodes(2);
                    return r;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            BytecodeManager.incBytecodes(2);
            final BinaryOperator<R> binaryOperator2 = binaryOperator;
            BytecodeManager.incBytecodes(5);
            final TerminalOp<Integer, R> int1 = ReduceOps.makeInt(supplier, objIntConsumer, binaryOperator2);
            BytecodeManager.incBytecodes(1);
            final R evaluate = this.evaluate(int1);
            BytecodeManager.incBytecodes(1);
            return evaluate;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final boolean anyMatch(final IntPredicate intPredicate) {
        try {
            final MatchOps.MatchKind any = MatchOps.MatchKind.ANY;
            BytecodeManager.incBytecodes(4);
            final TerminalOp<Integer, Boolean> int1 = MatchOps.makeInt(intPredicate, any);
            BytecodeManager.incBytecodes(1);
            final Boolean b = this.evaluate(int1);
            BytecodeManager.incBytecodes(2);
            final boolean booleanValue = b;
            BytecodeManager.incBytecodes(1);
            return booleanValue;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final boolean allMatch(final IntPredicate intPredicate) {
        try {
            final MatchOps.MatchKind all = MatchOps.MatchKind.ALL;
            BytecodeManager.incBytecodes(4);
            final TerminalOp<Integer, Boolean> int1 = MatchOps.makeInt(intPredicate, all);
            BytecodeManager.incBytecodes(1);
            final Boolean b = this.evaluate(int1);
            BytecodeManager.incBytecodes(2);
            final boolean booleanValue = b;
            BytecodeManager.incBytecodes(1);
            return booleanValue;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final boolean noneMatch(final IntPredicate intPredicate) {
        try {
            final MatchOps.MatchKind none = MatchOps.MatchKind.NONE;
            BytecodeManager.incBytecodes(4);
            final TerminalOp<Integer, Boolean> int1 = MatchOps.makeInt(intPredicate, none);
            BytecodeManager.incBytecodes(1);
            final Boolean b = this.evaluate(int1);
            BytecodeManager.incBytecodes(2);
            final boolean booleanValue = b;
            BytecodeManager.incBytecodes(1);
            return booleanValue;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final OptionalInt findFirst() {
        try {
            final boolean b = true;
            BytecodeManager.incBytecodes(3);
            final TerminalOp<Integer, OptionalInt> int1 = FindOps.makeInt(b);
            BytecodeManager.incBytecodes(1);
            final OptionalInt optionalInt = this.evaluate(int1);
            BytecodeManager.incBytecodes(2);
            return optionalInt;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final OptionalInt findAny() {
        try {
            final boolean b = false;
            BytecodeManager.incBytecodes(3);
            final TerminalOp<Integer, OptionalInt> int1 = FindOps.makeInt(b);
            BytecodeManager.incBytecodes(1);
            final OptionalInt optionalInt = this.evaluate(int1);
            BytecodeManager.incBytecodes(2);
            return optionalInt;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final int[] toArray() {
        try {
            Integer[] array;
            final IntFunction<Integer[]> intFunction = n -> {
                try {
                    array = new Integer[n];
                    BytecodeManager.incBytecodes(2);
                    return array;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            BytecodeManager.incBytecodes(2);
            final Node.OfInt ofInt = (Node.OfInt)this.evaluateToArrayNode(intFunction);
            BytecodeManager.incBytecodes(2);
            final Node.OfInt flattenInt = Nodes.flattenInt(ofInt);
            BytecodeManager.incBytecodes(1);
            final int[] array2 = ((Node.OfPrimitive<T, T_CONS, int[], T_SPLITR, T_NODE>)flattenInt).asPrimitiveArray();
            BytecodeManager.incBytecodes(2);
            return array2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static /* synthetic */ Spliterator.OfInt access$000(final Spliterator spliterator) {
        try {
            BytecodeManager.incBytecodes(2);
            final Spliterator.OfInt adapt = adapt(spliterator);
            BytecodeManager.incBytecodes(1);
            return adapt;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static class Head<E_IN> extends IntPipeline<E_IN>
    {
        Head(final Supplier<? extends Spliterator<Integer>> supplier, final int n, final boolean b) {
            try {
                BytecodeManager.incBytecodes(5);
                super(supplier, n, b);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        Head(final Spliterator<Integer> spliterator, final int n, final boolean b) {
            try {
                BytecodeManager.incBytecodes(5);
                super(spliterator, n, b);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        final boolean opIsStateful() {
            try {
                BytecodeManager.incBytecodes(3);
                final UnsupportedOperationException ex = new UnsupportedOperationException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        final Sink<E_IN> opWrapSink(final int n, final Sink<Integer> sink) {
            try {
                BytecodeManager.incBytecodes(3);
                final UnsupportedOperationException ex = new UnsupportedOperationException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void forEach(final IntConsumer intConsumer) {
            try {
                BytecodeManager.incBytecodes(2);
                final boolean parallel = this.isParallel();
                BytecodeManager.incBytecodes(1);
                if (!parallel) {
                    BytecodeManager.incBytecodes(2);
                    final Spliterator<Integer> sourceStageSpliterator = this.sourceStageSpliterator();
                    BytecodeManager.incBytecodes(1);
                    final Spliterator.OfInt access$000 = IntPipeline.access$000(sourceStageSpliterator);
                    BytecodeManager.incBytecodes(2);
                    access$000.forEachRemaining(intConsumer);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    BytecodeManager.incBytecodes(3);
                    super.forEach(intConsumer);
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void forEachOrdered(final IntConsumer intConsumer) {
            try {
                BytecodeManager.incBytecodes(2);
                final boolean parallel = this.isParallel();
                BytecodeManager.incBytecodes(1);
                if (!parallel) {
                    BytecodeManager.incBytecodes(2);
                    final Spliterator<Integer> sourceStageSpliterator = this.sourceStageSpliterator();
                    BytecodeManager.incBytecodes(1);
                    final Spliterator.OfInt access$000 = IntPipeline.access$000(sourceStageSpliterator);
                    BytecodeManager.incBytecodes(2);
                    access$000.forEachRemaining(intConsumer);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    BytecodeManager.incBytecodes(3);
                    super.forEachOrdered(intConsumer);
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    abstract static class StatelessOp<E_IN> extends IntPipeline<E_IN>
    {
        static final /* synthetic */ boolean $assertionsDisabled;
        
        StatelessOp(final AbstractPipeline<?, E_IN, ?> abstractPipeline, final StreamShape streamShape, final int n) {
            try {
                BytecodeManager.incBytecodes(4);
                super(abstractPipeline, n);
                final boolean $assertionsDisabled = StatelessOp.$assertionsDisabled;
                BytecodeManager.incBytecodes(2);
                if (!$assertionsDisabled) {
                    BytecodeManager.incBytecodes(2);
                    final StreamShape outputShape = abstractPipeline.getOutputShape();
                    BytecodeManager.incBytecodes(2);
                    if (outputShape != streamShape) {
                        BytecodeManager.incBytecodes(3);
                        final AssertionError assertionError = new AssertionError();
                        BytecodeManager.incBytecodes(1);
                        throw assertionError;
                    }
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        final boolean opIsStateful() {
            try {
                final boolean b = false;
                BytecodeManager.incBytecodes(2);
                return b;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static {
            try {
                final Class<IntPipeline> clazz = IntPipeline.class;
                BytecodeManager.incBytecodes(2);
                final boolean desiredAssertionStatus = clazz.desiredAssertionStatus();
                BytecodeManager.incBytecodes(1);
                boolean $assertionsDisabled2;
                if (!desiredAssertionStatus) {
                    $assertionsDisabled2 = true;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    $assertionsDisabled2 = false;
                    BytecodeManager.incBytecodes(1);
                }
                $assertionsDisabled = $assertionsDisabled2;
                BytecodeManager.incBytecodes(2);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    abstract static class StatefulOp<E_IN> extends IntPipeline<E_IN>
    {
        static final /* synthetic */ boolean $assertionsDisabled;
        
        StatefulOp(final AbstractPipeline<?, E_IN, ?> abstractPipeline, final StreamShape streamShape, final int n) {
            try {
                BytecodeManager.incBytecodes(4);
                super(abstractPipeline, n);
                final boolean $assertionsDisabled = StatefulOp.$assertionsDisabled;
                BytecodeManager.incBytecodes(2);
                if (!$assertionsDisabled) {
                    BytecodeManager.incBytecodes(2);
                    final StreamShape outputShape = abstractPipeline.getOutputShape();
                    BytecodeManager.incBytecodes(2);
                    if (outputShape != streamShape) {
                        BytecodeManager.incBytecodes(3);
                        final AssertionError assertionError = new AssertionError();
                        BytecodeManager.incBytecodes(1);
                        throw assertionError;
                    }
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        final boolean opIsStateful() {
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
        abstract <P_IN> Node<Integer> opEvaluateParallel(final PipelineHelper<Integer> p0, final Spliterator<P_IN> p1, final IntFunction<Integer[]> p2);
        
        static {
            try {
                final Class<IntPipeline> clazz = IntPipeline.class;
                BytecodeManager.incBytecodes(2);
                final boolean desiredAssertionStatus = clazz.desiredAssertionStatus();
                BytecodeManager.incBytecodes(1);
                boolean $assertionsDisabled2;
                if (!desiredAssertionStatus) {
                    $assertionsDisabled2 = true;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    $assertionsDisabled2 = false;
                    BytecodeManager.incBytecodes(1);
                }
                $assertionsDisabled = $assertionsDisabled2;
                BytecodeManager.incBytecodes(2);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
}
