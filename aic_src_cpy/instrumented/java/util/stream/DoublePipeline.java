// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.stream;

import java.util.Iterator;
import instrumented.java.util.function.BinaryOperator;
import instrumented.java.util.DoubleSummaryStatistics;
import instrumented.java.util.function.DoubleBinaryOperator;
import instrumented.java.util.OptionalDouble;
import instrumented.java.util.function.BiConsumer;
import instrumented.java.util.function.ObjDoubleConsumer;
import instrumented.java.util.function.ToDoubleFunction;
import instrumented.java.util.function.DoublePredicate;
import instrumented.java.util.function.DoubleToLongFunction;
import instrumented.java.util.function.DoubleToIntFunction;
import instrumented.java.util.Objects;
import instrumented.java.util.function.DoubleUnaryOperator;
import instrumented.java.util.function.DoubleFunction;
import instrumented.java.util.Spliterators;
import instrumented.java.util.PrimitiveIterator;
import instrumented.java.util.function.IntFunction;
import instrumented.java.util.function.DoubleConsumer;
import aic2021.engine.BytecodeManager;
import instrumented.java.util.Spliterator;
import instrumented.java.util.function.Supplier;

abstract class DoublePipeline<E_IN> extends AbstractPipeline<E_IN, Double, DoubleStream> implements DoubleStream
{
    DoublePipeline(final Supplier<? extends Spliterator<Double>> supplier, final int n, final boolean b) {
        try {
            BytecodeManager.incBytecodes(5);
            super(supplier, n, b);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    DoublePipeline(final Spliterator<Double> spliterator, final int n, final boolean b) {
        try {
            BytecodeManager.incBytecodes(5);
            super(spliterator, n, b);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    DoublePipeline(final AbstractPipeline<?, E_IN, ?> abstractPipeline, final int n) {
        try {
            BytecodeManager.incBytecodes(4);
            super(abstractPipeline, n);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static DoubleConsumer adapt(final Sink<Double> sink) {
        try {
            final boolean b = sink instanceof DoubleConsumer;
            BytecodeManager.incBytecodes(3);
            if (b) {
                final DoubleConsumer doubleConsumer = (DoubleConsumer)sink;
                BytecodeManager.incBytecodes(3);
                return doubleConsumer;
            }
            final boolean enabled = Tripwire.ENABLED;
            BytecodeManager.incBytecodes(2);
            if (enabled) {
                final Class<AbstractPipeline> clazz = AbstractPipeline.class;
                final String s = "using DoubleStream.adapt(Sink<Double> s)";
                BytecodeManager.incBytecodes(3);
                Tripwire.trip(clazz, s);
            }
            BytecodeManager.incBytecodes(3);
            sink.getClass();
            final DoubleConsumer doubleConsumer2 = sink::accept;
            BytecodeManager.incBytecodes(2);
            return doubleConsumer2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static Spliterator.OfDouble adapt(final Spliterator<Double> spliterator) {
        try {
            final boolean b = spliterator instanceof Spliterator.OfDouble;
            BytecodeManager.incBytecodes(3);
            if (b) {
                final Spliterator.OfDouble ofDouble = (Spliterator.OfDouble)spliterator;
                BytecodeManager.incBytecodes(3);
                return ofDouble;
            }
            final boolean enabled = Tripwire.ENABLED;
            BytecodeManager.incBytecodes(2);
            if (enabled) {
                final Class<AbstractPipeline> clazz = AbstractPipeline.class;
                final String s = "using DoubleStream.adapt(Spliterator<Double> s)";
                BytecodeManager.incBytecodes(3);
                Tripwire.trip(clazz, s);
            }
            final String message = "DoubleStream.adapt(Spliterator<Double> s)";
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
            final StreamShape double_VALUE = StreamShape.DOUBLE_VALUE;
            BytecodeManager.incBytecodes(2);
            return double_VALUE;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    final <P_IN> Node<Double> evaluateToNode(final PipelineHelper<Double> pipelineHelper, final Spliterator<P_IN> spliterator, final boolean b, final IntFunction<Double[]> intFunction) {
        try {
            BytecodeManager.incBytecodes(4);
            final Node.OfDouble collectDouble = Nodes.collectDouble(pipelineHelper, spliterator, b);
            BytecodeManager.incBytecodes(1);
            return collectDouble;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    final <P_IN> Spliterator<Double> wrap(final PipelineHelper<Double> pipelineHelper, final Supplier<Spliterator<P_IN>> supplier, final boolean b) {
        try {
            BytecodeManager.incBytecodes(6);
            final StreamSpliterators.DoubleWrappingSpliterator<Object> doubleWrappingSpliterator = new StreamSpliterators.DoubleWrappingSpliterator<Object>(pipelineHelper, (Supplier<Spliterator<Object>>)supplier, b);
            BytecodeManager.incBytecodes(1);
            return doubleWrappingSpliterator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    final Spliterator.OfDouble lazySpliterator(final Supplier<? extends Spliterator<Double>> supplier) {
        try {
            BytecodeManager.incBytecodes(4);
            final StreamSpliterators.DelegatingSpliterator.OfDouble ofDouble = new StreamSpliterators.DelegatingSpliterator.OfDouble((Supplier<Spliterator.OfDouble>)supplier);
            BytecodeManager.incBytecodes(1);
            return ofDouble;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    final void forEachWithCancel(final Spliterator<Double> spliterator, final Sink<Double> sink) {
        try {
            BytecodeManager.incBytecodes(2);
            final Spliterator.OfDouble adapt = adapt(spliterator);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            final DoubleConsumer adapt2 = adapt(sink);
            BytecodeManager.incBytecodes(1);
            boolean tryAdvance;
            do {
                BytecodeManager.incBytecodes(2);
                final boolean cancellationRequested = sink.cancellationRequested();
                BytecodeManager.incBytecodes(1);
                if (cancellationRequested) {
                    break;
                }
                final Spliterator.OfDouble ofDouble = adapt;
                final DoubleConsumer doubleConsumer = adapt2;
                BytecodeManager.incBytecodes(3);
                tryAdvance = ofDouble.tryAdvance(doubleConsumer);
                BytecodeManager.incBytecodes(1);
            } while (tryAdvance);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    final Node.Builder<Double> makeNodeBuilder(final long n, final IntFunction<Double[]> intFunction) {
        try {
            BytecodeManager.incBytecodes(2);
            final Node.Builder.OfDouble doubleBuilder = Nodes.doubleBuilder(n);
            BytecodeManager.incBytecodes(1);
            return doubleBuilder;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final PrimitiveIterator.OfDouble iterator() {
        try {
            BytecodeManager.incBytecodes(2);
            final Spliterator.OfDouble spliterator = this.spliterator();
            BytecodeManager.incBytecodes(1);
            final PrimitiveIterator.OfDouble iterator = Spliterators.iterator(spliterator);
            BytecodeManager.incBytecodes(1);
            return iterator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final Spliterator.OfDouble spliterator() {
        try {
            BytecodeManager.incBytecodes(2);
            final Spliterator<Double> spliterator = super.spliterator();
            BytecodeManager.incBytecodes(1);
            final Spliterator.OfDouble adapt = adapt(spliterator);
            BytecodeManager.incBytecodes(1);
            return adapt;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final Stream<Double> boxed() {
        try {
            final DoubleFunction<Double> doubleFunction = Double::valueOf;
            BytecodeManager.incBytecodes(2);
            final Stream<Object> mapToObj = this.mapToObj((DoubleFunction<?>)doubleFunction);
            BytecodeManager.incBytecodes(1);
            return (Stream<Double>)mapToObj;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final DoubleStream map(final DoubleUnaryOperator doubleUnaryOperator) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(doubleUnaryOperator);
            BytecodeManager.incBytecodes(1);
            final StreamShape double_VALUE = StreamShape.DOUBLE_VALUE;
            final int n = StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT;
            BytecodeManager.incBytecodes(10);
            final StatelessOp<Double> statelessOp = new StatelessOp<Double>(this, double_VALUE, n) {
                {
                    BytecodeManager.incBytecodes(1);
                }
                
                @Override
                Sink<Double> opWrapSink(final int n, final Sink<Double> sink) {
                    try {
                        BytecodeManager.incBytecodes(5);
                        final Sink.ChainedDouble<Double> chainedDouble = new Sink.ChainedDouble<Double>(sink) {
                            {
                                BytecodeManager.incBytecodes(1);
                            }
                            
                            @Override
                            public void accept(final double n) {
                                try {
                                    final Sink<? super E_OUT> downstream = this.downstream;
                                    final DoubleUnaryOperator val$mapper = doubleUnaryOperator;
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
                        return chainedDouble;
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
    public final <U> Stream<U> mapToObj(final DoubleFunction<? extends U> doubleFunction) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(doubleFunction);
            BytecodeManager.incBytecodes(1);
            final StreamShape double_VALUE = StreamShape.DOUBLE_VALUE;
            final int n = StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT;
            BytecodeManager.incBytecodes(10);
            final ReferencePipeline.StatelessOp<Double, U> statelessOp = new ReferencePipeline.StatelessOp<Double, U>(this, double_VALUE, n) {
                {
                    BytecodeManager.incBytecodes(1);
                }
                
                @Override
                Sink<Double> opWrapSink(final int n, final Sink<U> sink) {
                    try {
                        BytecodeManager.incBytecodes(5);
                        final Sink.ChainedDouble<U> chainedDouble = new Sink.ChainedDouble<U>(sink) {
                            {
                                BytecodeManager.incBytecodes(1);
                            }
                            
                            @Override
                            public void accept(final double n) {
                                try {
                                    final Sink<? super E_OUT> downstream = this.downstream;
                                    final DoubleFunction val$mapper = doubleFunction;
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
                        return chainedDouble;
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
    public final IntStream mapToInt(final DoubleToIntFunction doubleToIntFunction) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(doubleToIntFunction);
            BytecodeManager.incBytecodes(1);
            final StreamShape double_VALUE = StreamShape.DOUBLE_VALUE;
            final int n = StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT;
            BytecodeManager.incBytecodes(10);
            final IntPipeline.StatelessOp<Double> statelessOp = new IntPipeline.StatelessOp<Double>(this, double_VALUE, n) {
                {
                    BytecodeManager.incBytecodes(1);
                }
                
                @Override
                Sink<Double> opWrapSink(final int n, final Sink<Integer> sink) {
                    try {
                        BytecodeManager.incBytecodes(5);
                        final Sink.ChainedDouble<Integer> chainedDouble = new Sink.ChainedDouble<Integer>(sink) {
                            {
                                BytecodeManager.incBytecodes(1);
                            }
                            
                            @Override
                            public void accept(final double n) {
                                try {
                                    final Sink<? super E_OUT> downstream = this.downstream;
                                    final DoubleToIntFunction val$mapper = doubleToIntFunction;
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
                        return chainedDouble;
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
    public final LongStream mapToLong(final DoubleToLongFunction doubleToLongFunction) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(doubleToLongFunction);
            BytecodeManager.incBytecodes(1);
            final StreamShape double_VALUE = StreamShape.DOUBLE_VALUE;
            final int n = StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT;
            BytecodeManager.incBytecodes(10);
            final LongPipeline.StatelessOp<Double> statelessOp = new LongPipeline.StatelessOp<Double>(this, double_VALUE, n) {
                {
                    BytecodeManager.incBytecodes(1);
                }
                
                @Override
                Sink<Double> opWrapSink(final int n, final Sink<Long> sink) {
                    try {
                        BytecodeManager.incBytecodes(5);
                        final Sink.ChainedDouble<Long> chainedDouble = new Sink.ChainedDouble<Long>(sink) {
                            {
                                BytecodeManager.incBytecodes(1);
                            }
                            
                            @Override
                            public void accept(final double n) {
                                try {
                                    final Sink<? super E_OUT> downstream = this.downstream;
                                    final DoubleToLongFunction val$mapper = doubleToLongFunction;
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
                        return chainedDouble;
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
    public final DoubleStream flatMap(final DoubleFunction<? extends DoubleStream> doubleFunction) {
        try {
            final StreamShape double_VALUE = StreamShape.DOUBLE_VALUE;
            final int n = StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT | StreamOpFlag.NOT_SIZED;
            BytecodeManager.incBytecodes(12);
            final StatelessOp<Double> statelessOp = new StatelessOp<Double>(this, double_VALUE, n) {
                {
                    BytecodeManager.incBytecodes(1);
                }
                
                @Override
                Sink<Double> opWrapSink(final int n, final Sink<Double> sink) {
                    try {
                        BytecodeManager.incBytecodes(5);
                        final Sink.ChainedDouble<Double> chainedDouble = new Sink.ChainedDouble<Double>(sink) {
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
                            public void accept(final double p0) {
                                // 
                                // This method could not be decompiled.
                                // 
                                // Original Bytecode:
                                // 
                                //     1: getfield        instrumented/java/util/stream/DoublePipeline$5$1.this$1:Linstrumented/java/util/stream/DoublePipeline$5;
                                //     4: getfield        instrumented/java/util/stream/DoublePipeline$5.val$mapper:Linstrumented/java/util/function/DoubleFunction;
                                //     7: dload_1        
                                //     8: ldc             5
                                //    10: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //    13: invokeinterface instrumented/java/util/function/DoubleFunction.apply:(D)Ljava/lang/Object;
                                //    18: checkcast       Linstrumented/java/util/stream/DoubleStream;
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
                                //    45: invokeinterface instrumented/java/util/stream/DoubleStream.sequential:()Linstrumented/java/util/stream/DoubleStream;
                                //    50: aload_0        
                                //    51: invokedynamic   BootstrapMethod #0, accept:(Linstrumented/java/util/stream/DoublePipeline$5$1;)Linstrumented/java/util/function/DoubleConsumer;
                                //    56: ldc             2
                                //    58: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //    61: invokeinterface instrumented/java/util/stream/DoubleStream.forEach:(Linstrumented/java/util/function/DoubleConsumer;)V
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
                                //    91: invokeinterface instrumented/java/util/stream/DoubleStream.close:()V
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
                                //   132: invokeinterface instrumented/java/util/stream/DoubleStream.close:()V
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
                                //   191: invokeinterface instrumented/java/util/stream/DoubleStream.close:()V
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
                                //   232: invokeinterface instrumented/java/util/stream/DoubleStream.close:()V
                                //   237: aload           6
                                //   239: ldc             2
                                //   241: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   244: athrow         
                                //   245: ldc             1
                                //   247: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   250: return         
                                //   251: athrow         
                                //   252: athrow         
                                //    StackMapTable: 00 0B FD 00 42 07 00 42 07 00 26 65 07 00 26 15 52 07 00 26 4D 07 00 26 FF 00 2C 00 06 07 00 02 03 07 00 42 07 00 26 00 07 00 26 00 01 07 00 26 15 0A FF 00 07 00 02 07 00 02 03 00 00 FF 00 05 00 00 00 01 07 00 26 FF 00 00 00 00 00 01 07 00 35
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
                        return chainedDouble;
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
    public DoubleStream unordered() {
        try {
            BytecodeManager.incBytecodes(2);
            final boolean ordered = this.isOrdered();
            BytecodeManager.incBytecodes(1);
            if (!ordered) {
                BytecodeManager.incBytecodes(2);
                return this;
            }
            final StreamShape double_VALUE = StreamShape.DOUBLE_VALUE;
            final int not_ORDERED = StreamOpFlag.NOT_ORDERED;
            BytecodeManager.incBytecodes(7);
            final StatelessOp<Double> statelessOp = new StatelessOp<Double>(this, double_VALUE, not_ORDERED) {
                {
                    BytecodeManager.incBytecodes(1);
                }
                
                @Override
                Sink<Double> opWrapSink(final int n, final Sink<Double> sink) {
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
    public final DoubleStream filter(final DoublePredicate doublePredicate) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(doublePredicate);
            BytecodeManager.incBytecodes(1);
            final StreamShape double_VALUE = StreamShape.DOUBLE_VALUE;
            final int not_SIZED = StreamOpFlag.NOT_SIZED;
            BytecodeManager.incBytecodes(8);
            final StatelessOp<Double> statelessOp = new StatelessOp<Double>(this, double_VALUE, not_SIZED) {
                {
                    BytecodeManager.incBytecodes(1);
                }
                
                @Override
                Sink<Double> opWrapSink(final int n, final Sink<Double> sink) {
                    try {
                        BytecodeManager.incBytecodes(5);
                        final Sink.ChainedDouble<Double> chainedDouble = new Sink.ChainedDouble<Double>(sink) {
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
                            public void accept(final double n) {
                                try {
                                    final DoublePredicate val$predicate = doublePredicate;
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
                        return chainedDouble;
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
    public final DoubleStream peek(final DoubleConsumer doubleConsumer) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(doubleConsumer);
            BytecodeManager.incBytecodes(1);
            final StreamShape double_VALUE = StreamShape.DOUBLE_VALUE;
            final int n = 0;
            BytecodeManager.incBytecodes(8);
            final StatelessOp<Double> statelessOp = new StatelessOp<Double>(this, double_VALUE, n) {
                {
                    BytecodeManager.incBytecodes(1);
                }
                
                @Override
                Sink<Double> opWrapSink(final int n, final Sink<Double> sink) {
                    try {
                        BytecodeManager.incBytecodes(5);
                        final Sink.ChainedDouble<Double> chainedDouble = new Sink.ChainedDouble<Double>(sink) {
                            {
                                BytecodeManager.incBytecodes(1);
                            }
                            
                            @Override
                            public void accept(final double n) {
                                try {
                                    final DoubleConsumer val$action = doubleConsumer;
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
                        return chainedDouble;
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
    public final DoubleStream limit(final long i) {
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
            final DoubleStream double1 = SliceOps.makeDouble(this, n2, i);
            BytecodeManager.incBytecodes(1);
            return double1;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final DoubleStream skip(final long i) {
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
            BytecodeManager.incBytecodes(2);
            final long n4 = n3;
            BytecodeManager.incBytecodes(4);
            final DoubleStream double1 = SliceOps.makeDouble(this, i, n4);
            BytecodeManager.incBytecodes(1);
            return double1;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final DoubleStream sorted() {
        try {
            BytecodeManager.incBytecodes(2);
            final DoubleStream double1 = SortedOps.makeDouble(this);
            BytecodeManager.incBytecodes(1);
            return double1;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final DoubleStream distinct() {
        try {
            BytecodeManager.incBytecodes(2);
            final Stream<Double> boxed = this.boxed();
            BytecodeManager.incBytecodes(1);
            final Stream<Double> distinct = boxed.distinct();
            final double n2;
            final ToDoubleFunction<? super Double> toDoubleFunction = n -> {
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
            final DoubleStream mapToDouble = distinct.mapToDouble(toDoubleFunction);
            BytecodeManager.incBytecodes(1);
            return mapToDouble;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void forEach(final DoubleConsumer doubleConsumer) {
        try {
            final boolean b = false;
            BytecodeManager.incBytecodes(4);
            final TerminalOp<Double, Void> double1 = ForEachOps.makeDouble(doubleConsumer, b);
            BytecodeManager.incBytecodes(1);
            this.evaluate((TerminalOp<Double, Object>)double1);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void forEachOrdered(final DoubleConsumer doubleConsumer) {
        try {
            final boolean b = true;
            BytecodeManager.incBytecodes(4);
            final TerminalOp<Double, Void> double1 = ForEachOps.makeDouble(doubleConsumer, b);
            BytecodeManager.incBytecodes(1);
            this.evaluate((TerminalOp<Double, Object>)double1);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final double sum() {
        try {
            Object o;
            final Supplier<Object> supplier = () -> {
                try {
                    o = new double[3];
                    BytecodeManager.incBytecodes(2);
                    return o;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            final int n2;
            final ObjDoubleConsumer<R> objDoubleConsumer = (array, n) -> {
                try {
                    BytecodeManager.incBytecodes(3);
                    Collectors.sumWithCompensation(array, n);
                    BytecodeManager.incBytecodes(1);
                    array[n2] += n;
                    BytecodeManager.incBytecodes(7);
                    BytecodeManager.incBytecodes(1);
                    return;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            double n3;
            double n4;
            final int n5;
            final BiConsumer<R, R> biConsumer = (array2, array3) -> {
                try {
                    n3 = array3[0];
                    BytecodeManager.incBytecodes(5);
                    Collectors.sumWithCompensation(array2, n3);
                    BytecodeManager.incBytecodes(1);
                    n4 = array3[1];
                    BytecodeManager.incBytecodes(5);
                    Collectors.sumWithCompensation(array2, n4);
                    BytecodeManager.incBytecodes(1);
                    array2[n5] += array3[2];
                    BytecodeManager.incBytecodes(9);
                    BytecodeManager.incBytecodes(1);
                    return;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            BytecodeManager.incBytecodes(2);
            final double[] array4 = this.collect((Supplier<double[]>)supplier, (ObjDoubleConsumer<double[]>)objDoubleConsumer, (BiConsumer<double[], double[]>)biConsumer);
            BytecodeManager.incBytecodes(2);
            final double[] array5 = array4;
            BytecodeManager.incBytecodes(2);
            final double computeFinalSum = Collectors.computeFinalSum(array5);
            BytecodeManager.incBytecodes(1);
            return computeFinalSum;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final OptionalDouble min() {
        try {
            final DoubleBinaryOperator doubleBinaryOperator = Math::min;
            BytecodeManager.incBytecodes(2);
            final OptionalDouble reduce = this.reduce(doubleBinaryOperator);
            BytecodeManager.incBytecodes(1);
            return reduce;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final OptionalDouble max() {
        try {
            final DoubleBinaryOperator doubleBinaryOperator = Math::max;
            BytecodeManager.incBytecodes(2);
            final OptionalDouble reduce = this.reduce(doubleBinaryOperator);
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
                    o = new double[4];
                    BytecodeManager.incBytecodes(2);
                    return o;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            final int n2;
            final int n3;
            final ObjDoubleConsumer<R> objDoubleConsumer = (array, n) -> {
                try {
                    ++array[n2];
                    BytecodeManager.incBytecodes(7);
                    BytecodeManager.incBytecodes(3);
                    Collectors.sumWithCompensation(array, n);
                    BytecodeManager.incBytecodes(1);
                    array[n3] += n;
                    BytecodeManager.incBytecodes(7);
                    BytecodeManager.incBytecodes(1);
                    return;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            double n4;
            double n5;
            final int n6;
            final int n7;
            final BiConsumer<R, R> biConsumer = (array2, array3) -> {
                try {
                    n4 = array3[0];
                    BytecodeManager.incBytecodes(5);
                    Collectors.sumWithCompensation(array2, n4);
                    BytecodeManager.incBytecodes(1);
                    n5 = array3[1];
                    BytecodeManager.incBytecodes(5);
                    Collectors.sumWithCompensation(array2, n5);
                    BytecodeManager.incBytecodes(1);
                    array2[n6] += array3[2];
                    BytecodeManager.incBytecodes(9);
                    array2[n7] += array3[3];
                    BytecodeManager.incBytecodes(9);
                    BytecodeManager.incBytecodes(1);
                    return;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            BytecodeManager.incBytecodes(2);
            final double[] array4 = this.collect((Supplier<double[]>)supplier, (ObjDoubleConsumer<double[]>)objDoubleConsumer, (BiConsumer<double[], double[]>)biConsumer);
            BytecodeManager.incBytecodes(2);
            final double n8 = dcmpl(array4[2], 0.0);
            BytecodeManager.incBytecodes(6);
            OptionalDouble optionalDouble;
            if (n8 > 0) {
                final double[] array5 = array4;
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                final double n9 = Collectors.computeFinalSum(array5) / array4[2];
                BytecodeManager.incBytecodes(5);
                optionalDouble = OptionalDouble.of(n9);
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
            final DoubleToLongFunction doubleToLongFunction = p0 -> {
                try {
                    BytecodeManager.incBytecodes(2);
                    return n;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            BytecodeManager.incBytecodes(2);
            final LongStream mapToLong = this.mapToLong(doubleToLongFunction);
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
    public final DoubleSummaryStatistics summaryStatistics() {
        try {
            final Supplier<DoubleSummaryStatistics> supplier = DoubleSummaryStatistics::new;
            final ObjDoubleConsumer<R> objDoubleConsumer = DoubleSummaryStatistics::accept;
            final BiConsumer<R, R> biConsumer = DoubleSummaryStatistics::combine;
            BytecodeManager.incBytecodes(2);
            final DoubleSummaryStatistics doubleSummaryStatistics = this.collect(supplier, (ObjDoubleConsumer<DoubleSummaryStatistics>)objDoubleConsumer, (BiConsumer<DoubleSummaryStatistics, DoubleSummaryStatistics>)biConsumer);
            BytecodeManager.incBytecodes(2);
            return doubleSummaryStatistics;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final double reduce(final double n, final DoubleBinaryOperator doubleBinaryOperator) {
        try {
            BytecodeManager.incBytecodes(4);
            final TerminalOp<Double, Double> double1 = ReduceOps.makeDouble(n, doubleBinaryOperator);
            BytecodeManager.incBytecodes(1);
            final Double n2 = this.evaluate(double1);
            BytecodeManager.incBytecodes(2);
            final double doubleValue = n2;
            BytecodeManager.incBytecodes(1);
            return doubleValue;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final OptionalDouble reduce(final DoubleBinaryOperator doubleBinaryOperator) {
        try {
            BytecodeManager.incBytecodes(3);
            final TerminalOp<Double, OptionalDouble> double1 = ReduceOps.makeDouble(doubleBinaryOperator);
            BytecodeManager.incBytecodes(1);
            final OptionalDouble optionalDouble = this.evaluate(double1);
            BytecodeManager.incBytecodes(2);
            return optionalDouble;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final <R> R collect(final Supplier<R> supplier, final ObjDoubleConsumer<R> objDoubleConsumer, final BiConsumer<R, R> biConsumer) {
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
            final TerminalOp<Double, R> double1 = ReduceOps.makeDouble(supplier, objDoubleConsumer, binaryOperator2);
            BytecodeManager.incBytecodes(1);
            final R evaluate = this.evaluate(double1);
            BytecodeManager.incBytecodes(1);
            return evaluate;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final boolean anyMatch(final DoublePredicate doublePredicate) {
        try {
            final MatchOps.MatchKind any = MatchOps.MatchKind.ANY;
            BytecodeManager.incBytecodes(4);
            final TerminalOp<Double, Boolean> double1 = MatchOps.makeDouble(doublePredicate, any);
            BytecodeManager.incBytecodes(1);
            final Boolean b = this.evaluate(double1);
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
    public final boolean allMatch(final DoublePredicate doublePredicate) {
        try {
            final MatchOps.MatchKind all = MatchOps.MatchKind.ALL;
            BytecodeManager.incBytecodes(4);
            final TerminalOp<Double, Boolean> double1 = MatchOps.makeDouble(doublePredicate, all);
            BytecodeManager.incBytecodes(1);
            final Boolean b = this.evaluate(double1);
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
    public final boolean noneMatch(final DoublePredicate doublePredicate) {
        try {
            final MatchOps.MatchKind none = MatchOps.MatchKind.NONE;
            BytecodeManager.incBytecodes(4);
            final TerminalOp<Double, Boolean> double1 = MatchOps.makeDouble(doublePredicate, none);
            BytecodeManager.incBytecodes(1);
            final Boolean b = this.evaluate(double1);
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
    public final OptionalDouble findFirst() {
        try {
            final boolean b = true;
            BytecodeManager.incBytecodes(3);
            final TerminalOp<Double, OptionalDouble> double1 = FindOps.makeDouble(b);
            BytecodeManager.incBytecodes(1);
            final OptionalDouble optionalDouble = this.evaluate(double1);
            BytecodeManager.incBytecodes(2);
            return optionalDouble;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final OptionalDouble findAny() {
        try {
            final boolean b = false;
            BytecodeManager.incBytecodes(3);
            final TerminalOp<Double, OptionalDouble> double1 = FindOps.makeDouble(b);
            BytecodeManager.incBytecodes(1);
            final OptionalDouble optionalDouble = this.evaluate(double1);
            BytecodeManager.incBytecodes(2);
            return optionalDouble;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final double[] toArray() {
        try {
            Double[] array;
            final IntFunction<Double[]> intFunction = n -> {
                try {
                    array = new Double[n];
                    BytecodeManager.incBytecodes(2);
                    return array;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            BytecodeManager.incBytecodes(2);
            final Node.OfDouble ofDouble = (Node.OfDouble)this.evaluateToArrayNode(intFunction);
            BytecodeManager.incBytecodes(2);
            final Node.OfDouble flattenDouble = Nodes.flattenDouble(ofDouble);
            BytecodeManager.incBytecodes(1);
            final double[] array2 = ((Node.OfPrimitive<T, T_CONS, double[], T_SPLITR, T_NODE>)flattenDouble).asPrimitiveArray();
            BytecodeManager.incBytecodes(2);
            return array2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static /* synthetic */ Spliterator.OfDouble access$000(final Spliterator spliterator) {
        try {
            BytecodeManager.incBytecodes(2);
            final Spliterator.OfDouble adapt = adapt(spliterator);
            BytecodeManager.incBytecodes(1);
            return adapt;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static class Head<E_IN> extends DoublePipeline<E_IN>
    {
        Head(final Supplier<? extends Spliterator<Double>> supplier, final int n, final boolean b) {
            try {
                BytecodeManager.incBytecodes(5);
                super(supplier, n, b);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        Head(final Spliterator<Double> spliterator, final int n, final boolean b) {
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
        final Sink<E_IN> opWrapSink(final int n, final Sink<Double> sink) {
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
        public void forEach(final DoubleConsumer doubleConsumer) {
            try {
                BytecodeManager.incBytecodes(2);
                final boolean parallel = this.isParallel();
                BytecodeManager.incBytecodes(1);
                if (!parallel) {
                    BytecodeManager.incBytecodes(2);
                    final Spliterator<Double> sourceStageSpliterator = this.sourceStageSpliterator();
                    BytecodeManager.incBytecodes(1);
                    final Spliterator.OfDouble access$000 = DoublePipeline.access$000(sourceStageSpliterator);
                    BytecodeManager.incBytecodes(2);
                    access$000.forEachRemaining(doubleConsumer);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    BytecodeManager.incBytecodes(3);
                    super.forEach(doubleConsumer);
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void forEachOrdered(final DoubleConsumer doubleConsumer) {
            try {
                BytecodeManager.incBytecodes(2);
                final boolean parallel = this.isParallel();
                BytecodeManager.incBytecodes(1);
                if (!parallel) {
                    BytecodeManager.incBytecodes(2);
                    final Spliterator<Double> sourceStageSpliterator = this.sourceStageSpliterator();
                    BytecodeManager.incBytecodes(1);
                    final Spliterator.OfDouble access$000 = DoublePipeline.access$000(sourceStageSpliterator);
                    BytecodeManager.incBytecodes(2);
                    access$000.forEachRemaining(doubleConsumer);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    BytecodeManager.incBytecodes(3);
                    super.forEachOrdered(doubleConsumer);
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    abstract static class StatelessOp<E_IN> extends DoublePipeline<E_IN>
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
                final Class<DoublePipeline> clazz = DoublePipeline.class;
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
    
    abstract static class StatefulOp<E_IN> extends DoublePipeline<E_IN>
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
        abstract <P_IN> Node<Double> opEvaluateParallel(final PipelineHelper<Double> p0, final Spliterator<P_IN> p1, final IntFunction<Double[]> p2);
        
        static {
            try {
                final Class<DoublePipeline> clazz = DoublePipeline.class;
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
