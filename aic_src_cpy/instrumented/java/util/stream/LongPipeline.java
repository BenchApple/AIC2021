// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.stream;

import java.util.Iterator;
import instrumented.java.util.function.BinaryOperator;
import instrumented.java.util.LongSummaryStatistics;
import instrumented.java.util.function.BiConsumer;
import instrumented.java.util.function.ObjLongConsumer;
import instrumented.java.util.OptionalDouble;
import instrumented.java.util.OptionalLong;
import instrumented.java.util.function.LongBinaryOperator;
import instrumented.java.util.function.ToLongFunction;
import instrumented.java.util.function.LongPredicate;
import instrumented.java.util.function.LongToDoubleFunction;
import instrumented.java.util.function.LongToIntFunction;
import instrumented.java.util.Objects;
import instrumented.java.util.function.LongUnaryOperator;
import instrumented.java.util.function.LongFunction;
import instrumented.java.util.Spliterators;
import instrumented.java.util.PrimitiveIterator;
import instrumented.java.util.function.IntFunction;
import instrumented.java.util.function.LongConsumer;
import aic2021.engine.BytecodeManager;
import instrumented.java.util.Spliterator;
import instrumented.java.util.function.Supplier;

abstract class LongPipeline<E_IN> extends AbstractPipeline<E_IN, Long, LongStream> implements LongStream
{
    LongPipeline(final Supplier<? extends Spliterator<Long>> supplier, final int n, final boolean b) {
        try {
            BytecodeManager.incBytecodes(5);
            super(supplier, n, b);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    LongPipeline(final Spliterator<Long> spliterator, final int n, final boolean b) {
        try {
            BytecodeManager.incBytecodes(5);
            super(spliterator, n, b);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    LongPipeline(final AbstractPipeline<?, E_IN, ?> abstractPipeline, final int n) {
        try {
            BytecodeManager.incBytecodes(4);
            super(abstractPipeline, n);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static LongConsumer adapt(final Sink<Long> sink) {
        try {
            final boolean b = sink instanceof LongConsumer;
            BytecodeManager.incBytecodes(3);
            if (b) {
                final LongConsumer longConsumer = (LongConsumer)sink;
                BytecodeManager.incBytecodes(3);
                return longConsumer;
            }
            final boolean enabled = Tripwire.ENABLED;
            BytecodeManager.incBytecodes(2);
            if (enabled) {
                final Class<AbstractPipeline> clazz = AbstractPipeline.class;
                final String s = "using LongStream.adapt(Sink<Long> s)";
                BytecodeManager.incBytecodes(3);
                Tripwire.trip(clazz, s);
            }
            BytecodeManager.incBytecodes(3);
            sink.getClass();
            final LongConsumer longConsumer2 = sink::accept;
            BytecodeManager.incBytecodes(2);
            return longConsumer2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static Spliterator.OfLong adapt(final Spliterator<Long> spliterator) {
        try {
            final boolean b = spliterator instanceof Spliterator.OfLong;
            BytecodeManager.incBytecodes(3);
            if (b) {
                final Spliterator.OfLong ofLong = (Spliterator.OfLong)spliterator;
                BytecodeManager.incBytecodes(3);
                return ofLong;
            }
            final boolean enabled = Tripwire.ENABLED;
            BytecodeManager.incBytecodes(2);
            if (enabled) {
                final Class<AbstractPipeline> clazz = AbstractPipeline.class;
                final String s = "using LongStream.adapt(Spliterator<Long> s)";
                BytecodeManager.incBytecodes(3);
                Tripwire.trip(clazz, s);
            }
            final String message = "LongStream.adapt(Spliterator<Long> s)";
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
            final StreamShape long_VALUE = StreamShape.LONG_VALUE;
            BytecodeManager.incBytecodes(2);
            return long_VALUE;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    final <P_IN> Node<Long> evaluateToNode(final PipelineHelper<Long> pipelineHelper, final Spliterator<P_IN> spliterator, final boolean b, final IntFunction<Long[]> intFunction) {
        try {
            BytecodeManager.incBytecodes(4);
            final Node.OfLong collectLong = Nodes.collectLong(pipelineHelper, spliterator, b);
            BytecodeManager.incBytecodes(1);
            return collectLong;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    final <P_IN> Spliterator<Long> wrap(final PipelineHelper<Long> pipelineHelper, final Supplier<Spliterator<P_IN>> supplier, final boolean b) {
        try {
            BytecodeManager.incBytecodes(6);
            final StreamSpliterators.LongWrappingSpliterator<Object> longWrappingSpliterator = new StreamSpliterators.LongWrappingSpliterator<Object>(pipelineHelper, (Supplier<Spliterator<Object>>)supplier, b);
            BytecodeManager.incBytecodes(1);
            return longWrappingSpliterator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    final Spliterator.OfLong lazySpliterator(final Supplier<? extends Spliterator<Long>> supplier) {
        try {
            BytecodeManager.incBytecodes(4);
            final StreamSpliterators.DelegatingSpliterator.OfLong ofLong = new StreamSpliterators.DelegatingSpliterator.OfLong((Supplier<Spliterator.OfLong>)supplier);
            BytecodeManager.incBytecodes(1);
            return ofLong;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    final void forEachWithCancel(final Spliterator<Long> spliterator, final Sink<Long> sink) {
        try {
            BytecodeManager.incBytecodes(2);
            final Spliterator.OfLong adapt = adapt(spliterator);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            final LongConsumer adapt2 = adapt(sink);
            BytecodeManager.incBytecodes(1);
            boolean tryAdvance;
            do {
                BytecodeManager.incBytecodes(2);
                final boolean cancellationRequested = sink.cancellationRequested();
                BytecodeManager.incBytecodes(1);
                if (cancellationRequested) {
                    break;
                }
                final Spliterator.OfLong ofLong = adapt;
                final LongConsumer longConsumer = adapt2;
                BytecodeManager.incBytecodes(3);
                tryAdvance = ofLong.tryAdvance(longConsumer);
                BytecodeManager.incBytecodes(1);
            } while (tryAdvance);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    final Node.Builder<Long> makeNodeBuilder(final long n, final IntFunction<Long[]> intFunction) {
        try {
            BytecodeManager.incBytecodes(2);
            final Node.Builder.OfLong longBuilder = Nodes.longBuilder(n);
            BytecodeManager.incBytecodes(1);
            return longBuilder;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final PrimitiveIterator.OfLong iterator() {
        try {
            BytecodeManager.incBytecodes(2);
            final Spliterator.OfLong spliterator = this.spliterator();
            BytecodeManager.incBytecodes(1);
            final PrimitiveIterator.OfLong iterator = Spliterators.iterator(spliterator);
            BytecodeManager.incBytecodes(1);
            return iterator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final Spliterator.OfLong spliterator() {
        try {
            BytecodeManager.incBytecodes(2);
            final Spliterator<Long> spliterator = super.spliterator();
            BytecodeManager.incBytecodes(1);
            final Spliterator.OfLong adapt = adapt(spliterator);
            BytecodeManager.incBytecodes(1);
            return adapt;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final DoubleStream asDoubleStream() {
        try {
            final StreamShape long_VALUE = StreamShape.LONG_VALUE;
            final int n = StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT;
            BytecodeManager.incBytecodes(9);
            final DoublePipeline.StatelessOp<Long> statelessOp = new DoublePipeline.StatelessOp<Long>(this, long_VALUE, n) {
                {
                    BytecodeManager.incBytecodes(1);
                }
                
                @Override
                Sink<Long> opWrapSink(final int n, final Sink<Double> sink) {
                    try {
                        BytecodeManager.incBytecodes(5);
                        final Sink.ChainedLong<Double> chainedLong = new Sink.ChainedLong<Double>(sink) {
                            {
                                BytecodeManager.incBytecodes(1);
                            }
                            
                            @Override
                            public void accept(final long n) {
                                try {
                                    final Sink<? super E_OUT> downstream = this.downstream;
                                    final double n2 = (double)n;
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
                        return chainedLong;
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
    public final Stream<Long> boxed() {
        try {
            final LongFunction<Long> longFunction = Long::valueOf;
            BytecodeManager.incBytecodes(2);
            final Stream<Object> mapToObj = this.mapToObj((LongFunction<?>)longFunction);
            BytecodeManager.incBytecodes(1);
            return (Stream<Long>)mapToObj;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final LongStream map(final LongUnaryOperator longUnaryOperator) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(longUnaryOperator);
            BytecodeManager.incBytecodes(1);
            final StreamShape long_VALUE = StreamShape.LONG_VALUE;
            final int n = StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT;
            BytecodeManager.incBytecodes(10);
            final StatelessOp<Long> statelessOp = new StatelessOp<Long>(this, long_VALUE, n) {
                {
                    BytecodeManager.incBytecodes(1);
                }
                
                @Override
                Sink<Long> opWrapSink(final int n, final Sink<Long> sink) {
                    try {
                        BytecodeManager.incBytecodes(5);
                        final Sink.ChainedLong<Long> chainedLong = new Sink.ChainedLong<Long>(sink) {
                            {
                                BytecodeManager.incBytecodes(1);
                            }
                            
                            @Override
                            public void accept(final long n) {
                                try {
                                    final Sink<? super E_OUT> downstream = this.downstream;
                                    final LongUnaryOperator val$mapper = longUnaryOperator;
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
                        return chainedLong;
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
    public final <U> Stream<U> mapToObj(final LongFunction<? extends U> longFunction) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(longFunction);
            BytecodeManager.incBytecodes(1);
            final StreamShape long_VALUE = StreamShape.LONG_VALUE;
            final int n = StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT;
            BytecodeManager.incBytecodes(10);
            final ReferencePipeline.StatelessOp<Long, U> statelessOp = new ReferencePipeline.StatelessOp<Long, U>(this, long_VALUE, n) {
                {
                    BytecodeManager.incBytecodes(1);
                }
                
                @Override
                Sink<Long> opWrapSink(final int n, final Sink<U> sink) {
                    try {
                        BytecodeManager.incBytecodes(5);
                        final Sink.ChainedLong<U> chainedLong = new Sink.ChainedLong<U>(sink) {
                            {
                                BytecodeManager.incBytecodes(1);
                            }
                            
                            @Override
                            public void accept(final long n) {
                                try {
                                    final Sink<? super E_OUT> downstream = this.downstream;
                                    final LongFunction val$mapper = longFunction;
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
                        return chainedLong;
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
    public final IntStream mapToInt(final LongToIntFunction longToIntFunction) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(longToIntFunction);
            BytecodeManager.incBytecodes(1);
            final StreamShape long_VALUE = StreamShape.LONG_VALUE;
            final int n = StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT;
            BytecodeManager.incBytecodes(10);
            final IntPipeline.StatelessOp<Long> statelessOp = new IntPipeline.StatelessOp<Long>(this, long_VALUE, n) {
                {
                    BytecodeManager.incBytecodes(1);
                }
                
                @Override
                Sink<Long> opWrapSink(final int n, final Sink<Integer> sink) {
                    try {
                        BytecodeManager.incBytecodes(5);
                        final Sink.ChainedLong<Integer> chainedLong = new Sink.ChainedLong<Integer>(sink) {
                            {
                                BytecodeManager.incBytecodes(1);
                            }
                            
                            @Override
                            public void accept(final long n) {
                                try {
                                    final Sink<? super E_OUT> downstream = this.downstream;
                                    final LongToIntFunction val$mapper = longToIntFunction;
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
                        return chainedLong;
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
    public final DoubleStream mapToDouble(final LongToDoubleFunction longToDoubleFunction) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(longToDoubleFunction);
            BytecodeManager.incBytecodes(1);
            final StreamShape long_VALUE = StreamShape.LONG_VALUE;
            final int n = StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT;
            BytecodeManager.incBytecodes(10);
            final DoublePipeline.StatelessOp<Long> statelessOp = new DoublePipeline.StatelessOp<Long>(this, long_VALUE, n) {
                {
                    BytecodeManager.incBytecodes(1);
                }
                
                @Override
                Sink<Long> opWrapSink(final int n, final Sink<Double> sink) {
                    try {
                        BytecodeManager.incBytecodes(5);
                        final Sink.ChainedLong<Double> chainedLong = new Sink.ChainedLong<Double>(sink) {
                            {
                                BytecodeManager.incBytecodes(1);
                            }
                            
                            @Override
                            public void accept(final long n) {
                                try {
                                    final Sink<? super E_OUT> downstream = this.downstream;
                                    final LongToDoubleFunction val$mapper = longToDoubleFunction;
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
                        return chainedLong;
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
    public final LongStream flatMap(final LongFunction<? extends LongStream> longFunction) {
        try {
            final StreamShape long_VALUE = StreamShape.LONG_VALUE;
            final int n = StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT | StreamOpFlag.NOT_SIZED;
            BytecodeManager.incBytecodes(12);
            final StatelessOp<Long> statelessOp = new StatelessOp<Long>(this, long_VALUE, n) {
                {
                    BytecodeManager.incBytecodes(1);
                }
                
                @Override
                Sink<Long> opWrapSink(final int n, final Sink<Long> sink) {
                    try {
                        BytecodeManager.incBytecodes(5);
                        final Sink.ChainedLong<Long> chainedLong = new Sink.ChainedLong<Long>(sink) {
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
                            public void accept(final long p0) {
                                // 
                                // This method could not be decompiled.
                                // 
                                // Original Bytecode:
                                // 
                                //     1: getfield        instrumented/java/util/stream/LongPipeline$6$1.this$1:Linstrumented/java/util/stream/LongPipeline$6;
                                //     4: getfield        instrumented/java/util/stream/LongPipeline$6.val$mapper:Linstrumented/java/util/function/LongFunction;
                                //     7: lload_1        
                                //     8: ldc             5
                                //    10: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //    13: invokeinterface instrumented/java/util/function/LongFunction.apply:(J)Ljava/lang/Object;
                                //    18: checkcast       Linstrumented/java/util/stream/LongStream;
                                //    21: astore_3       
                                //    22: aconst_null    
                                //    23: astore          4
                                //    25: ldc             4
                                //    27: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //    30: aload_3        
                                //    31: ldc             2
                                //    33: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //    36: ifnull          66
                                //    39: aload_3        
                                //    40: ldc             2
                                //    42: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //    45: invokeinterface instrumented/java/util/stream/LongStream.sequential:()Linstrumented/java/util/stream/LongStream;
                                //    50: aload_0        
                                //    51: invokedynamic   BootstrapMethod #0, accept:(Linstrumented/java/util/stream/LongPipeline$6$1;)Linstrumented/java/util/function/LongConsumer;
                                //    56: ldc             2
                                //    58: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //    61: invokeinterface instrumented/java/util/stream/LongStream.forEach:(Linstrumented/java/util/function/LongConsumer;)V
                                //    66: aload_3        
                                //    67: ldc             2
                                //    69: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //    72: ifnull          245
                                //    75: aload           4
                                //    77: ldc             2
                                //    79: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //    82: ifnull          126
                                //    85: aload_3        
                                //    86: ldc             2
                                //    88: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //    91: invokeinterface instrumented/java/util/stream/LongStream.close:()V
                                //    96: ldc             1
                                //    98: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   101: goto            245
                                //   104: astore          5
                                //   106: aload           4
                                //   108: aload           5
                                //   110: ldc             504
                                //   112: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   115: invokevirtual   java/lang/Throwable.addSuppressed:(Ljava/lang/Throwable;)V
                                //   118: ldc             1
                                //   120: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   123: goto            245
                                //   126: aload_3        
                                //   127: ldc             2
                                //   129: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   132: invokeinterface instrumented/java/util/stream/LongStream.close:()V
                                //   137: ldc             1
                                //   139: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   142: goto            245
                                //   145: astore          5
                                //   147: aload           5
                                //   149: astore          4
                                //   151: aload           5
                                //   153: ldc             505
                                //   155: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   158: athrow         
                                //   159: astore          6
                                //   161: ldc             501
                                //   163: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   166: aload_3        
                                //   167: ldc             2
                                //   169: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   172: ifnull          237
                                //   175: aload           4
                                //   177: ldc             2
                                //   179: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   182: ifnull          226
                                //   185: aload_3        
                                //   186: ldc             2
                                //   188: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   191: invokeinterface instrumented/java/util/stream/LongStream.close:()V
                                //   196: ldc             1
                                //   198: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   201: goto            237
                                //   204: astore          7
                                //   206: aload           4
                                //   208: aload           7
                                //   210: ldc             504
                                //   212: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   215: invokevirtual   java/lang/Throwable.addSuppressed:(Ljava/lang/Throwable;)V
                                //   218: ldc             1
                                //   220: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   223: goto            237
                                //   226: aload_3        
                                //   227: ldc             2
                                //   229: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   232: invokeinterface instrumented/java/util/stream/LongStream.close:()V
                                //   237: aload           6
                                //   239: ldc             2
                                //   241: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   244: athrow         
                                //   245: ldc             1
                                //   247: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   250: return         
                                //   251: athrow         
                                //   252: athrow         
                                //    StackMapTable: 00 0B FD 00 42 07 00 41 07 00 26 65 07 00 26 15 52 07 00 26 4D 07 00 26 FF 00 2C 00 06 07 00 02 04 07 00 41 07 00 26 00 07 00 26 00 01 07 00 26 15 0A FF 00 07 00 02 07 00 02 04 00 00 FF 00 05 00 00 00 01 07 00 26 FF 00 00 00 00 00 01 07 00 34
                                //    Exceptions:
                                //  Try           Handler
                                //  Start  End    Start  End    Type                           
                                //  -----  -----  -----  -----  -------------------------------
                                //  30     252    252    253    Ljava/lang/VirtualMachineError;
                                //  85     96     104    126    Ljava/lang/Throwable;
                                //  30     66     145    159    Ljava/lang/Throwable;
                                //  30     66     159    245    Any
                                //  185    196    204    226    Ljava/lang/Throwable;
                                //  145    166    159    245    Any
                                //  0      251    251    252    Any
                                // 
                                // The error that occurred was:
                                // 
                                // java.lang.IllegalStateException: Expression is linked from several locations: Label_0066:
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
                        return chainedLong;
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
    public LongStream unordered() {
        try {
            BytecodeManager.incBytecodes(2);
            final boolean ordered = this.isOrdered();
            BytecodeManager.incBytecodes(1);
            if (!ordered) {
                BytecodeManager.incBytecodes(2);
                return this;
            }
            final StreamShape long_VALUE = StreamShape.LONG_VALUE;
            final int not_ORDERED = StreamOpFlag.NOT_ORDERED;
            BytecodeManager.incBytecodes(7);
            final StatelessOp<Long> statelessOp = new StatelessOp<Long>(this, long_VALUE, not_ORDERED) {
                {
                    BytecodeManager.incBytecodes(1);
                }
                
                @Override
                Sink<Long> opWrapSink(final int n, final Sink<Long> sink) {
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
    public final LongStream filter(final LongPredicate longPredicate) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(longPredicate);
            BytecodeManager.incBytecodes(1);
            final StreamShape long_VALUE = StreamShape.LONG_VALUE;
            final int not_SIZED = StreamOpFlag.NOT_SIZED;
            BytecodeManager.incBytecodes(8);
            final StatelessOp<Long> statelessOp = new StatelessOp<Long>(this, long_VALUE, not_SIZED) {
                {
                    BytecodeManager.incBytecodes(1);
                }
                
                @Override
                Sink<Long> opWrapSink(final int n, final Sink<Long> sink) {
                    try {
                        BytecodeManager.incBytecodes(5);
                        final Sink.ChainedLong<Long> chainedLong = new Sink.ChainedLong<Long>(sink) {
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
                            public void accept(final long n) {
                                try {
                                    final LongPredicate val$predicate = longPredicate;
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
                        return chainedLong;
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
    public final LongStream peek(final LongConsumer longConsumer) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(longConsumer);
            BytecodeManager.incBytecodes(1);
            final StreamShape long_VALUE = StreamShape.LONG_VALUE;
            final int n = 0;
            BytecodeManager.incBytecodes(8);
            final StatelessOp<Long> statelessOp = new StatelessOp<Long>(this, long_VALUE, n) {
                {
                    BytecodeManager.incBytecodes(1);
                }
                
                @Override
                Sink<Long> opWrapSink(final int n, final Sink<Long> sink) {
                    try {
                        BytecodeManager.incBytecodes(5);
                        final Sink.ChainedLong<Long> chainedLong = new Sink.ChainedLong<Long>(sink) {
                            {
                                BytecodeManager.incBytecodes(1);
                            }
                            
                            @Override
                            public void accept(final long n) {
                                try {
                                    final LongConsumer val$action = longConsumer;
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
                        return chainedLong;
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
    public final LongStream limit(final long i) {
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
            final LongStream long1 = SliceOps.makeLong(this, n2, i);
            BytecodeManager.incBytecodes(1);
            return long1;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final LongStream skip(final long i) {
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
            final LongStream long1 = SliceOps.makeLong(this, i, n3);
            BytecodeManager.incBytecodes(1);
            return long1;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final LongStream sorted() {
        try {
            BytecodeManager.incBytecodes(2);
            final LongStream long1 = SortedOps.makeLong(this);
            BytecodeManager.incBytecodes(1);
            return long1;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final LongStream distinct() {
        try {
            BytecodeManager.incBytecodes(2);
            final Stream<Long> boxed = this.boxed();
            BytecodeManager.incBytecodes(1);
            final Stream<Long> distinct = boxed.distinct();
            final long n2;
            final ToLongFunction<? super Long> toLongFunction = n -> {
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
            final LongStream mapToLong = distinct.mapToLong(toLongFunction);
            BytecodeManager.incBytecodes(1);
            return mapToLong;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void forEach(final LongConsumer longConsumer) {
        try {
            final boolean b = false;
            BytecodeManager.incBytecodes(4);
            final TerminalOp<Long, Void> long1 = ForEachOps.makeLong(longConsumer, b);
            BytecodeManager.incBytecodes(1);
            this.evaluate((TerminalOp<Long, Object>)long1);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void forEachOrdered(final LongConsumer longConsumer) {
        try {
            final boolean b = true;
            BytecodeManager.incBytecodes(4);
            final TerminalOp<Long, Void> long1 = ForEachOps.makeLong(longConsumer, b);
            BytecodeManager.incBytecodes(1);
            this.evaluate((TerminalOp<Long, Object>)long1);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final long sum() {
        try {
            final long n = 0L;
            final LongBinaryOperator longBinaryOperator = Long::sum;
            BytecodeManager.incBytecodes(3);
            final long reduce = this.reduce(n, longBinaryOperator);
            BytecodeManager.incBytecodes(1);
            return reduce;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final OptionalLong min() {
        try {
            final LongBinaryOperator longBinaryOperator = Math::min;
            BytecodeManager.incBytecodes(2);
            final OptionalLong reduce = this.reduce(longBinaryOperator);
            BytecodeManager.incBytecodes(1);
            return reduce;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final OptionalLong max() {
        try {
            final LongBinaryOperator longBinaryOperator = Math::max;
            BytecodeManager.incBytecodes(2);
            final OptionalLong reduce = this.reduce(longBinaryOperator);
            BytecodeManager.incBytecodes(1);
            return reduce;
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
            final ObjLongConsumer<R> objLongConsumer = (array, n) -> {
                try {
                    ++array[n2];
                    BytecodeManager.incBytecodes(7);
                    array[n3] += n;
                    BytecodeManager.incBytecodes(7);
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
            final long[] array4 = this.collect((Supplier<long[]>)supplier, (ObjLongConsumer<long[]>)objLongConsumer, (BiConsumer<long[], long[]>)biConsumer);
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
    public final long count() {
        try {
            final long n;
            final LongUnaryOperator longUnaryOperator = p0 -> {
                try {
                    BytecodeManager.incBytecodes(2);
                    return n;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            BytecodeManager.incBytecodes(2);
            final LongStream map = this.map(longUnaryOperator);
            BytecodeManager.incBytecodes(1);
            final long sum = map.sum();
            BytecodeManager.incBytecodes(1);
            return sum;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final LongSummaryStatistics summaryStatistics() {
        try {
            final Supplier<LongSummaryStatistics> supplier = LongSummaryStatistics::new;
            final ObjLongConsumer<R> objLongConsumer = LongSummaryStatistics::accept;
            final BiConsumer<R, R> biConsumer = LongSummaryStatistics::combine;
            BytecodeManager.incBytecodes(2);
            final LongSummaryStatistics longSummaryStatistics = this.collect(supplier, (ObjLongConsumer<LongSummaryStatistics>)objLongConsumer, (BiConsumer<LongSummaryStatistics, LongSummaryStatistics>)biConsumer);
            BytecodeManager.incBytecodes(2);
            return longSummaryStatistics;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final long reduce(final long n, final LongBinaryOperator longBinaryOperator) {
        try {
            BytecodeManager.incBytecodes(4);
            final TerminalOp<Long, Long> long1 = ReduceOps.makeLong(n, longBinaryOperator);
            BytecodeManager.incBytecodes(1);
            final Long n2 = this.evaluate(long1);
            BytecodeManager.incBytecodes(2);
            final long longValue = n2;
            BytecodeManager.incBytecodes(1);
            return longValue;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final OptionalLong reduce(final LongBinaryOperator longBinaryOperator) {
        try {
            BytecodeManager.incBytecodes(3);
            final TerminalOp<Long, OptionalLong> long1 = ReduceOps.makeLong(longBinaryOperator);
            BytecodeManager.incBytecodes(1);
            final OptionalLong optionalLong = this.evaluate(long1);
            BytecodeManager.incBytecodes(2);
            return optionalLong;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final <R> R collect(final Supplier<R> supplier, final ObjLongConsumer<R> objLongConsumer, final BiConsumer<R, R> biConsumer) {
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
            final TerminalOp<Long, R> long1 = ReduceOps.makeLong(supplier, objLongConsumer, binaryOperator2);
            BytecodeManager.incBytecodes(1);
            final R evaluate = this.evaluate(long1);
            BytecodeManager.incBytecodes(1);
            return evaluate;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final boolean anyMatch(final LongPredicate longPredicate) {
        try {
            final MatchOps.MatchKind any = MatchOps.MatchKind.ANY;
            BytecodeManager.incBytecodes(4);
            final TerminalOp<Long, Boolean> long1 = MatchOps.makeLong(longPredicate, any);
            BytecodeManager.incBytecodes(1);
            final Boolean b = this.evaluate(long1);
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
    public final boolean allMatch(final LongPredicate longPredicate) {
        try {
            final MatchOps.MatchKind all = MatchOps.MatchKind.ALL;
            BytecodeManager.incBytecodes(4);
            final TerminalOp<Long, Boolean> long1 = MatchOps.makeLong(longPredicate, all);
            BytecodeManager.incBytecodes(1);
            final Boolean b = this.evaluate(long1);
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
    public final boolean noneMatch(final LongPredicate longPredicate) {
        try {
            final MatchOps.MatchKind none = MatchOps.MatchKind.NONE;
            BytecodeManager.incBytecodes(4);
            final TerminalOp<Long, Boolean> long1 = MatchOps.makeLong(longPredicate, none);
            BytecodeManager.incBytecodes(1);
            final Boolean b = this.evaluate(long1);
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
    public final OptionalLong findFirst() {
        try {
            final boolean b = true;
            BytecodeManager.incBytecodes(3);
            final TerminalOp<Long, OptionalLong> long1 = FindOps.makeLong(b);
            BytecodeManager.incBytecodes(1);
            final OptionalLong optionalLong = this.evaluate(long1);
            BytecodeManager.incBytecodes(2);
            return optionalLong;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final OptionalLong findAny() {
        try {
            final boolean b = false;
            BytecodeManager.incBytecodes(3);
            final TerminalOp<Long, OptionalLong> long1 = FindOps.makeLong(b);
            BytecodeManager.incBytecodes(1);
            final OptionalLong optionalLong = this.evaluate(long1);
            BytecodeManager.incBytecodes(2);
            return optionalLong;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final long[] toArray() {
        try {
            Long[] array;
            final IntFunction<Long[]> intFunction = n -> {
                try {
                    array = new Long[n];
                    BytecodeManager.incBytecodes(2);
                    return array;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            BytecodeManager.incBytecodes(2);
            final Node.OfLong ofLong = (Node.OfLong)this.evaluateToArrayNode(intFunction);
            BytecodeManager.incBytecodes(2);
            final Node.OfLong flattenLong = Nodes.flattenLong(ofLong);
            BytecodeManager.incBytecodes(1);
            final long[] array2 = ((Node.OfPrimitive<T, T_CONS, long[], T_SPLITR, T_NODE>)flattenLong).asPrimitiveArray();
            BytecodeManager.incBytecodes(2);
            return array2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static /* synthetic */ Spliterator.OfLong access$000(final Spliterator spliterator) {
        try {
            BytecodeManager.incBytecodes(2);
            final Spliterator.OfLong adapt = adapt(spliterator);
            BytecodeManager.incBytecodes(1);
            return adapt;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static class Head<E_IN> extends LongPipeline<E_IN>
    {
        Head(final Supplier<? extends Spliterator<Long>> supplier, final int n, final boolean b) {
            try {
                BytecodeManager.incBytecodes(5);
                super(supplier, n, b);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        Head(final Spliterator<Long> spliterator, final int n, final boolean b) {
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
        final Sink<E_IN> opWrapSink(final int n, final Sink<Long> sink) {
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
        public void forEach(final LongConsumer longConsumer) {
            try {
                BytecodeManager.incBytecodes(2);
                final boolean parallel = this.isParallel();
                BytecodeManager.incBytecodes(1);
                if (!parallel) {
                    BytecodeManager.incBytecodes(2);
                    final Spliterator<Long> sourceStageSpliterator = this.sourceStageSpliterator();
                    BytecodeManager.incBytecodes(1);
                    final Spliterator.OfLong access$000 = LongPipeline.access$000(sourceStageSpliterator);
                    BytecodeManager.incBytecodes(2);
                    access$000.forEachRemaining(longConsumer);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    BytecodeManager.incBytecodes(3);
                    super.forEach(longConsumer);
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void forEachOrdered(final LongConsumer longConsumer) {
            try {
                BytecodeManager.incBytecodes(2);
                final boolean parallel = this.isParallel();
                BytecodeManager.incBytecodes(1);
                if (!parallel) {
                    BytecodeManager.incBytecodes(2);
                    final Spliterator<Long> sourceStageSpliterator = this.sourceStageSpliterator();
                    BytecodeManager.incBytecodes(1);
                    final Spliterator.OfLong access$000 = LongPipeline.access$000(sourceStageSpliterator);
                    BytecodeManager.incBytecodes(2);
                    access$000.forEachRemaining(longConsumer);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    BytecodeManager.incBytecodes(3);
                    super.forEachOrdered(longConsumer);
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    abstract static class StatelessOp<E_IN> extends LongPipeline<E_IN>
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
                final Class<LongPipeline> clazz = LongPipeline.class;
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
    
    abstract static class StatefulOp<E_IN> extends LongPipeline<E_IN>
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
        abstract <P_IN> Node<Long> opEvaluateParallel(final PipelineHelper<Long> p0, final Spliterator<P_IN> p1, final IntFunction<Long[]> p2);
        
        static {
            try {
                final Class<LongPipeline> clazz = LongPipeline.class;
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
