// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.stream;

import instrumented.java.util.function.BiConsumer;
import instrumented.java.util.Set;
import instrumented.java.util.function.BiFunction;
import instrumented.java.util.function.BinaryOperator;
import instrumented.java.util.Optional;
import instrumented.java.util.Comparator;
import instrumented.java.util.function.LongConsumer;
import instrumented.java.util.function.DoubleConsumer;
import instrumented.java.util.function.IntConsumer;
import instrumented.java.util.function.ToDoubleFunction;
import instrumented.java.util.function.ToLongFunction;
import instrumented.java.util.function.ToIntFunction;
import instrumented.java.util.function.Function;
import instrumented.java.util.Objects;
import instrumented.java.util.function.Predicate;
import instrumented.java.util.Spliterators;
import java.util.Iterator;
import instrumented.java.util.function.Consumer;
import instrumented.java.util.function.IntFunction;
import aic2021.engine.BytecodeManager;
import instrumented.java.util.Spliterator;
import instrumented.java.util.function.Supplier;

abstract class ReferencePipeline<P_IN, P_OUT> extends AbstractPipeline<P_IN, P_OUT, Stream<P_OUT>> implements Stream<P_OUT>
{
    ReferencePipeline(final Supplier<? extends Spliterator<?>> supplier, final int n, final boolean b) {
        try {
            BytecodeManager.incBytecodes(5);
            super(supplier, n, b);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    ReferencePipeline(final Spliterator<?> spliterator, final int n, final boolean b) {
        try {
            BytecodeManager.incBytecodes(5);
            super(spliterator, n, b);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    ReferencePipeline(final AbstractPipeline<?, P_IN, ?> abstractPipeline, final int n) {
        try {
            BytecodeManager.incBytecodes(4);
            super(abstractPipeline, n);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    final StreamShape getOutputShape() {
        try {
            final StreamShape reference = StreamShape.REFERENCE;
            BytecodeManager.incBytecodes(2);
            return reference;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    final <P_IN> Node<P_OUT> evaluateToNode(final PipelineHelper<P_OUT> pipelineHelper, final Spliterator<P_IN> spliterator, final boolean b, final IntFunction<P_OUT[]> intFunction) {
        try {
            BytecodeManager.incBytecodes(5);
            final Node<P_OUT> collect = Nodes.collect(pipelineHelper, spliterator, b, intFunction);
            BytecodeManager.incBytecodes(1);
            return collect;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    final <P_IN> Spliterator<P_OUT> wrap(final PipelineHelper<P_OUT> pipelineHelper, final Supplier<Spliterator<P_IN>> supplier, final boolean b) {
        try {
            BytecodeManager.incBytecodes(6);
            final StreamSpliterators.WrappingSpliterator wrappingSpliterator = new StreamSpliterators.WrappingSpliterator(pipelineHelper, supplier, b);
            BytecodeManager.incBytecodes(1);
            return (Spliterator<P_OUT>)wrappingSpliterator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    final Spliterator<P_OUT> lazySpliterator(final Supplier<? extends Spliterator<P_OUT>> supplier) {
        try {
            BytecodeManager.incBytecodes(4);
            final StreamSpliterators.DelegatingSpliterator<P_OUT, Object> delegatingSpliterator = new StreamSpliterators.DelegatingSpliterator<P_OUT, Object>(supplier);
            BytecodeManager.incBytecodes(1);
            return delegatingSpliterator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    final void forEachWithCancel(final Spliterator<P_OUT> spliterator, final Sink<P_OUT> sink) {
        try {
            boolean tryAdvance;
            do {
                BytecodeManager.incBytecodes(2);
                final boolean cancellationRequested = sink.cancellationRequested();
                BytecodeManager.incBytecodes(1);
                if (cancellationRequested) {
                    break;
                }
                BytecodeManager.incBytecodes(3);
                tryAdvance = spliterator.tryAdvance(sink);
                BytecodeManager.incBytecodes(1);
            } while (tryAdvance);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    final Node.Builder<P_OUT> makeNodeBuilder(final long n, final IntFunction<P_OUT[]> intFunction) {
        try {
            BytecodeManager.incBytecodes(3);
            final Node.Builder<P_OUT> builder = Nodes.builder(n, intFunction);
            BytecodeManager.incBytecodes(1);
            return builder;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final Iterator<P_OUT> iterator() {
        try {
            BytecodeManager.incBytecodes(2);
            final Spliterator<P_OUT> spliterator = this.spliterator();
            BytecodeManager.incBytecodes(1);
            final Iterator<P_OUT> iterator = Spliterators.iterator((Spliterator<? extends P_OUT>)spliterator);
            BytecodeManager.incBytecodes(1);
            return iterator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public Stream<P_OUT> unordered() {
        try {
            BytecodeManager.incBytecodes(2);
            final boolean ordered = this.isOrdered();
            BytecodeManager.incBytecodes(1);
            if (!ordered) {
                BytecodeManager.incBytecodes(2);
                return this;
            }
            final StreamShape reference = StreamShape.REFERENCE;
            final int not_ORDERED = StreamOpFlag.NOT_ORDERED;
            BytecodeManager.incBytecodes(7);
            final StatelessOp<P_OUT, P_OUT> statelessOp = new StatelessOp<P_OUT, P_OUT>(this, reference, not_ORDERED) {
                {
                    BytecodeManager.incBytecodes(1);
                }
                
                @Override
                Sink<P_OUT> opWrapSink(final int n, final Sink<P_OUT> sink) {
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
    public final Stream<P_OUT> filter(final Predicate<? super P_OUT> predicate) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(predicate);
            BytecodeManager.incBytecodes(1);
            final StreamShape reference = StreamShape.REFERENCE;
            final int not_SIZED = StreamOpFlag.NOT_SIZED;
            BytecodeManager.incBytecodes(8);
            final StatelessOp<P_OUT, P_OUT> statelessOp = new StatelessOp<P_OUT, P_OUT>(this, reference, not_SIZED) {
                {
                    BytecodeManager.incBytecodes(1);
                }
                
                @Override
                Sink<P_OUT> opWrapSink(final int n, final Sink<P_OUT> sink) {
                    try {
                        BytecodeManager.incBytecodes(5);
                        final Sink.ChainedReference<P_OUT, P_OUT> chainedReference = new Sink.ChainedReference<P_OUT, P_OUT>(sink) {
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
                            public void accept(final P_OUT p_OUT) {
                                try {
                                    final Predicate val$predicate = predicate;
                                    BytecodeManager.incBytecodes(5);
                                    final boolean test = val$predicate.test(p_OUT);
                                    BytecodeManager.incBytecodes(1);
                                    if (test) {
                                        final Sink<? super E_OUT> downstream = this.downstream;
                                        BytecodeManager.incBytecodes(4);
                                        downstream.accept(p_OUT);
                                    }
                                    BytecodeManager.incBytecodes(1);
                                }
                                finally {
                                    throw loadexception(java.lang.Throwable.class);
                                }
                            }
                        };
                        BytecodeManager.incBytecodes(1);
                        return chainedReference;
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
    public final <R> Stream<R> map(final Function<? super P_OUT, ? extends R> function) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(function);
            BytecodeManager.incBytecodes(1);
            final StreamShape reference = StreamShape.REFERENCE;
            final int n = StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT;
            BytecodeManager.incBytecodes(10);
            final StatelessOp<P_OUT, R> statelessOp = new StatelessOp<P_OUT, R>(this, reference, n) {
                {
                    BytecodeManager.incBytecodes(1);
                }
                
                @Override
                Sink<P_OUT> opWrapSink(final int n, final Sink<R> sink) {
                    try {
                        BytecodeManager.incBytecodes(5);
                        final Sink.ChainedReference<P_OUT, R> chainedReference = new Sink.ChainedReference<P_OUT, R>(sink) {
                            {
                                BytecodeManager.incBytecodes(1);
                            }
                            
                            @Override
                            public void accept(final P_OUT p_OUT) {
                                try {
                                    final Sink<? super E_OUT> downstream = this.downstream;
                                    final Function val$mapper = function;
                                    BytecodeManager.incBytecodes(7);
                                    final Object apply = val$mapper.apply(p_OUT);
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
                        return chainedReference;
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
    public final IntStream mapToInt(final ToIntFunction<? super P_OUT> toIntFunction) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(toIntFunction);
            BytecodeManager.incBytecodes(1);
            final StreamShape reference = StreamShape.REFERENCE;
            final int n = StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT;
            BytecodeManager.incBytecodes(10);
            final IntPipeline.StatelessOp<P_OUT> statelessOp = new IntPipeline.StatelessOp<P_OUT>(this, reference, n) {
                {
                    BytecodeManager.incBytecodes(1);
                }
                
                @Override
                Sink<P_OUT> opWrapSink(final int n, final Sink<Integer> sink) {
                    try {
                        BytecodeManager.incBytecodes(5);
                        final Sink.ChainedReference<P_OUT, Integer> chainedReference = new Sink.ChainedReference<P_OUT, Integer>(sink) {
                            {
                                BytecodeManager.incBytecodes(1);
                            }
                            
                            @Override
                            public void accept(final P_OUT p_OUT) {
                                try {
                                    final Sink<? super E_OUT> downstream = this.downstream;
                                    final ToIntFunction val$mapper = toIntFunction;
                                    BytecodeManager.incBytecodes(7);
                                    final int applyAsInt = val$mapper.applyAsInt(p_OUT);
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
                        return chainedReference;
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
    public final LongStream mapToLong(final ToLongFunction<? super P_OUT> toLongFunction) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(toLongFunction);
            BytecodeManager.incBytecodes(1);
            final StreamShape reference = StreamShape.REFERENCE;
            final int n = StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT;
            BytecodeManager.incBytecodes(10);
            final LongPipeline.StatelessOp<P_OUT> statelessOp = new LongPipeline.StatelessOp<P_OUT>(this, reference, n) {
                {
                    BytecodeManager.incBytecodes(1);
                }
                
                @Override
                Sink<P_OUT> opWrapSink(final int n, final Sink<Long> sink) {
                    try {
                        BytecodeManager.incBytecodes(5);
                        final Sink.ChainedReference<P_OUT, Long> chainedReference = new Sink.ChainedReference<P_OUT, Long>(sink) {
                            {
                                BytecodeManager.incBytecodes(1);
                            }
                            
                            @Override
                            public void accept(final P_OUT p_OUT) {
                                try {
                                    final Sink<? super E_OUT> downstream = this.downstream;
                                    final ToLongFunction val$mapper = toLongFunction;
                                    BytecodeManager.incBytecodes(7);
                                    final long applyAsLong = val$mapper.applyAsLong(p_OUT);
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
                        return chainedReference;
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
    public final DoubleStream mapToDouble(final ToDoubleFunction<? super P_OUT> toDoubleFunction) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(toDoubleFunction);
            BytecodeManager.incBytecodes(1);
            final StreamShape reference = StreamShape.REFERENCE;
            final int n = StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT;
            BytecodeManager.incBytecodes(10);
            final DoublePipeline.StatelessOp<P_OUT> statelessOp = new DoublePipeline.StatelessOp<P_OUT>(this, reference, n) {
                {
                    BytecodeManager.incBytecodes(1);
                }
                
                @Override
                Sink<P_OUT> opWrapSink(final int n, final Sink<Double> sink) {
                    try {
                        BytecodeManager.incBytecodes(5);
                        final Sink.ChainedReference<P_OUT, Double> chainedReference = new Sink.ChainedReference<P_OUT, Double>(sink) {
                            {
                                BytecodeManager.incBytecodes(1);
                            }
                            
                            @Override
                            public void accept(final P_OUT p_OUT) {
                                try {
                                    final Sink<? super E_OUT> downstream = this.downstream;
                                    final ToDoubleFunction val$mapper = toDoubleFunction;
                                    BytecodeManager.incBytecodes(7);
                                    final double applyAsDouble = val$mapper.applyAsDouble(p_OUT);
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
                        return chainedReference;
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
    public final <R> Stream<R> flatMap(final Function<? super P_OUT, ? extends Stream<? extends R>> function) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(function);
            BytecodeManager.incBytecodes(1);
            final StreamShape reference = StreamShape.REFERENCE;
            final int n = StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT | StreamOpFlag.NOT_SIZED;
            BytecodeManager.incBytecodes(12);
            final StatelessOp<P_OUT, R> statelessOp = new StatelessOp<P_OUT, R>(this, reference, n) {
                {
                    BytecodeManager.incBytecodes(1);
                }
                
                @Override
                Sink<P_OUT> opWrapSink(final int n, final Sink<R> sink) {
                    try {
                        BytecodeManager.incBytecodes(5);
                        final Sink.ChainedReference<P_OUT, R> chainedReference = new Sink.ChainedReference<P_OUT, R>(sink) {
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
                            public void accept(final P_OUT p0) {
                                // 
                                // This method could not be decompiled.
                                // 
                                // Original Bytecode:
                                // 
                                //     1: getfield        instrumented/java/util/stream/ReferencePipeline$7$1.this$1:Linstrumented/java/util/stream/ReferencePipeline$7;
                                //     4: getfield        instrumented/java/util/stream/ReferencePipeline$7.val$mapper:Linstrumented/java/util/function/Function;
                                //     7: aload_1        
                                //     8: ldc             5
                                //    10: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //    13: invokeinterface instrumented/java/util/function/Function.apply:(Ljava/lang/Object;)Ljava/lang/Object;
                                //    18: checkcast       Linstrumented/java/util/stream/Stream;
                                //    21: astore_2       
                                //    22: aconst_null    
                                //    23: astore_3       
                                //    24: ldc             4
                                //    26: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //    29: aload_2        
                                //    30: ldc             2
                                //    32: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //    35: ifnull          66
                                //    38: aload_2        
                                //    39: ldc             2
                                //    41: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //    44: invokeinterface instrumented/java/util/stream/Stream.sequential:()Linstrumented/java/util/stream/BaseStream;
                                //    49: checkcast       Linstrumented/java/util/stream/Stream;
                                //    52: aload_0        
                                //    53: getfield        instrumented/java/util/stream/ReferencePipeline$7$1.downstream:Linstrumented/java/util/stream/Sink;
                                //    56: ldc             4
                                //    58: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //    61: invokeinterface instrumented/java/util/stream/Stream.forEach:(Linstrumented/java/util/function/Consumer;)V
                                //    66: aload_2        
                                //    67: ldc             2
                                //    69: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //    72: ifnull          240
                                //    75: aload_3        
                                //    76: ldc             2
                                //    78: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //    81: ifnull          124
                                //    84: aload_2        
                                //    85: ldc             2
                                //    87: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //    90: invokeinterface instrumented/java/util/stream/Stream.close:()V
                                //    95: ldc             1
                                //    97: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   100: goto            240
                                //   103: astore          4
                                //   105: aload_3        
                                //   106: aload           4
                                //   108: ldc             504
                                //   110: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   113: invokevirtual   java/lang/Throwable.addSuppressed:(Ljava/lang/Throwable;)V
                                //   116: ldc             1
                                //   118: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   121: goto            240
                                //   124: aload_2        
                                //   125: ldc             2
                                //   127: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   130: invokeinterface instrumented/java/util/stream/Stream.close:()V
                                //   135: ldc             1
                                //   137: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   140: goto            240
                                //   143: astore          4
                                //   145: aload           4
                                //   147: astore_3       
                                //   148: aload           4
                                //   150: ldc             505
                                //   152: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   155: athrow         
                                //   156: astore          5
                                //   158: ldc             501
                                //   160: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   163: aload_2        
                                //   164: ldc             2
                                //   166: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   169: ifnull          232
                                //   172: aload_3        
                                //   173: ldc             2
                                //   175: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   178: ifnull          221
                                //   181: aload_2        
                                //   182: ldc             2
                                //   184: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   187: invokeinterface instrumented/java/util/stream/Stream.close:()V
                                //   192: ldc             1
                                //   194: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   197: goto            232
                                //   200: astore          6
                                //   202: aload_3        
                                //   203: aload           6
                                //   205: ldc             504
                                //   207: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   210: invokevirtual   java/lang/Throwable.addSuppressed:(Ljava/lang/Throwable;)V
                                //   213: ldc             1
                                //   215: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   218: goto            232
                                //   221: aload_2        
                                //   222: ldc             2
                                //   224: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   227: invokeinterface instrumented/java/util/stream/Stream.close:()V
                                //   232: aload           5
                                //   234: ldc             2
                                //   236: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   239: athrow         
                                //   240: ldc             1
                                //   242: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   245: return         
                                //   246: athrow         
                                //   247: athrow         
                                //    Signature:
                                //  (TP_OUT;)V
                                //    StackMapTable: 00 0B FD 00 42 07 00 3D 07 00 21 64 07 00 21 14 52 07 00 21 4C 07 00 21 FF 00 2B 00 06 07 00 02 07 00 53 07 00 3D 07 00 21 00 07 00 21 00 01 07 00 21 14 0A FF 00 07 00 02 07 00 02 07 00 53 00 00 FF 00 05 00 00 00 01 07 00 21 FF 00 00 00 00 00 01 07 00 30
                                //    Exceptions:
                                //  Try           Handler
                                //  Start  End    Start  End    Type                           
                                //  -----  -----  -----  -----  -------------------------------
                                //  29     247    247    248    Ljava/lang/VirtualMachineError;
                                //  84     95     103    124    Ljava/lang/Throwable;
                                //  29     66     143    156    Ljava/lang/Throwable;
                                //  29     66     156    240    Any
                                //  181    192    200    221    Ljava/lang/Throwable;
                                //  143    163    156    240    Any
                                //  0      246    246    247    Any
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
                        return chainedReference;
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
    public final IntStream flatMapToInt(final Function<? super P_OUT, ? extends IntStream> function) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(function);
            BytecodeManager.incBytecodes(1);
            final StreamShape reference = StreamShape.REFERENCE;
            final int n = StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT | StreamOpFlag.NOT_SIZED;
            BytecodeManager.incBytecodes(12);
            final IntPipeline.StatelessOp<P_OUT> statelessOp = new IntPipeline.StatelessOp<P_OUT>(this, reference, n) {
                {
                    BytecodeManager.incBytecodes(1);
                }
                
                @Override
                Sink<P_OUT> opWrapSink(final int n, final Sink<Integer> sink) {
                    try {
                        BytecodeManager.incBytecodes(5);
                        final Sink.ChainedReference<P_OUT, Integer> chainedReference = new Sink.ChainedReference<P_OUT, Integer>(sink) {
                            IntConsumer downstreamAsInt;
                            
                            {
                                final Sink<? super E_OUT> downstream = this.downstream;
                                BytecodeManager.incBytecodes(5);
                                downstream.getClass();
                                this.downstreamAsInt = downstream::accept;
                                BytecodeManager.incBytecodes(3);
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
                            public void accept(final P_OUT p0) {
                                // 
                                // This method could not be decompiled.
                                // 
                                // Original Bytecode:
                                // 
                                //     1: getfield        instrumented/java/util/stream/ReferencePipeline$8$1.this$1:Linstrumented/java/util/stream/ReferencePipeline$8;
                                //     4: getfield        instrumented/java/util/stream/ReferencePipeline$8.val$mapper:Linstrumented/java/util/function/Function;
                                //     7: aload_1        
                                //     8: ldc             5
                                //    10: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //    13: invokeinterface instrumented/java/util/function/Function.apply:(Ljava/lang/Object;)Ljava/lang/Object;
                                //    18: checkcast       Linstrumented/java/util/stream/IntStream;
                                //    21: astore_2       
                                //    22: aconst_null    
                                //    23: astore_3       
                                //    24: ldc             4
                                //    26: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //    29: aload_2        
                                //    30: ldc             2
                                //    32: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //    35: ifnull          63
                                //    38: aload_2        
                                //    39: ldc             2
                                //    41: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //    44: invokeinterface instrumented/java/util/stream/IntStream.sequential:()Linstrumented/java/util/stream/IntStream;
                                //    49: aload_0        
                                //    50: getfield        instrumented/java/util/stream/ReferencePipeline$8$1.downstreamAsInt:Linstrumented/java/util/function/IntConsumer;
                                //    53: ldc             3
                                //    55: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //    58: invokeinterface instrumented/java/util/stream/IntStream.forEach:(Linstrumented/java/util/function/IntConsumer;)V
                                //    63: aload_2        
                                //    64: ldc             2
                                //    66: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //    69: ifnull          237
                                //    72: aload_3        
                                //    73: ldc             2
                                //    75: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //    78: ifnull          121
                                //    81: aload_2        
                                //    82: ldc             2
                                //    84: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //    87: invokeinterface instrumented/java/util/stream/IntStream.close:()V
                                //    92: ldc             1
                                //    94: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //    97: goto            237
                                //   100: astore          4
                                //   102: aload_3        
                                //   103: aload           4
                                //   105: ldc             504
                                //   107: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   110: invokevirtual   java/lang/Throwable.addSuppressed:(Ljava/lang/Throwable;)V
                                //   113: ldc             1
                                //   115: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   118: goto            237
                                //   121: aload_2        
                                //   122: ldc             2
                                //   124: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   127: invokeinterface instrumented/java/util/stream/IntStream.close:()V
                                //   132: ldc             1
                                //   134: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   137: goto            237
                                //   140: astore          4
                                //   142: aload           4
                                //   144: astore_3       
                                //   145: aload           4
                                //   147: ldc             505
                                //   149: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   152: athrow         
                                //   153: astore          5
                                //   155: ldc             501
                                //   157: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   160: aload_2        
                                //   161: ldc             2
                                //   163: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   166: ifnull          229
                                //   169: aload_3        
                                //   170: ldc             2
                                //   172: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   175: ifnull          218
                                //   178: aload_2        
                                //   179: ldc             2
                                //   181: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   184: invokeinterface instrumented/java/util/stream/IntStream.close:()V
                                //   189: ldc             1
                                //   191: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   194: goto            229
                                //   197: astore          6
                                //   199: aload_3        
                                //   200: aload           6
                                //   202: ldc             504
                                //   204: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   207: invokevirtual   java/lang/Throwable.addSuppressed:(Ljava/lang/Throwable;)V
                                //   210: ldc             1
                                //   212: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   215: goto            229
                                //   218: aload_2        
                                //   219: ldc             2
                                //   221: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   224: invokeinterface instrumented/java/util/stream/IntStream.close:()V
                                //   229: aload           5
                                //   231: ldc             2
                                //   233: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   236: athrow         
                                //   237: ldc             1
                                //   239: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   242: return         
                                //   243: athrow         
                                //   244: athrow         
                                //    Signature:
                                //  (TP_OUT;)V
                                //    StackMapTable: 00 0B FD 00 3F 07 00 5B 07 00 44 64 07 00 44 14 52 07 00 44 4C 07 00 44 FF 00 2B 00 06 07 00 02 07 00 2C 07 00 5B 07 00 44 00 07 00 44 00 01 07 00 44 14 0A FF 00 07 00 02 07 00 02 07 00 2C 00 00 FF 00 05 00 00 00 01 07 00 44 FF 00 00 00 00 00 01 07 00 4F
                                //    Exceptions:
                                //  Try           Handler
                                //  Start  End    Start  End    Type                           
                                //  -----  -----  -----  -----  -------------------------------
                                //  29     244    244    245    Ljava/lang/VirtualMachineError;
                                //  81     92     100    121    Ljava/lang/Throwable;
                                //  29     63     140    153    Ljava/lang/Throwable;
                                //  29     63     153    237    Any
                                //  178    189    197    218    Ljava/lang/Throwable;
                                //  140    160    153    237    Any
                                //  0      243    243    244    Any
                                // 
                                // The error that occurred was:
                                // 
                                // java.lang.IllegalStateException: Expression is linked from several locations: Label_0063:
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
                        return chainedReference;
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
    public final DoubleStream flatMapToDouble(final Function<? super P_OUT, ? extends DoubleStream> function) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(function);
            BytecodeManager.incBytecodes(1);
            final StreamShape reference = StreamShape.REFERENCE;
            final int n = StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT | StreamOpFlag.NOT_SIZED;
            BytecodeManager.incBytecodes(12);
            final DoublePipeline.StatelessOp<P_OUT> statelessOp = new DoublePipeline.StatelessOp<P_OUT>(this, reference, n) {
                {
                    BytecodeManager.incBytecodes(1);
                }
                
                @Override
                Sink<P_OUT> opWrapSink(final int n, final Sink<Double> sink) {
                    try {
                        BytecodeManager.incBytecodes(5);
                        final Sink.ChainedReference<P_OUT, Double> chainedReference = new Sink.ChainedReference<P_OUT, Double>(sink) {
                            DoubleConsumer downstreamAsDouble;
                            
                            {
                                final Sink<? super E_OUT> downstream = this.downstream;
                                BytecodeManager.incBytecodes(5);
                                downstream.getClass();
                                this.downstreamAsDouble = downstream::accept;
                                BytecodeManager.incBytecodes(3);
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
                            public void accept(final P_OUT p0) {
                                // 
                                // This method could not be decompiled.
                                // 
                                // Original Bytecode:
                                // 
                                //     1: getfield        instrumented/java/util/stream/ReferencePipeline$9$1.this$1:Linstrumented/java/util/stream/ReferencePipeline$9;
                                //     4: getfield        instrumented/java/util/stream/ReferencePipeline$9.val$mapper:Linstrumented/java/util/function/Function;
                                //     7: aload_1        
                                //     8: ldc             5
                                //    10: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //    13: invokeinterface instrumented/java/util/function/Function.apply:(Ljava/lang/Object;)Ljava/lang/Object;
                                //    18: checkcast       Linstrumented/java/util/stream/DoubleStream;
                                //    21: astore_2       
                                //    22: aconst_null    
                                //    23: astore_3       
                                //    24: ldc             4
                                //    26: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //    29: aload_2        
                                //    30: ldc             2
                                //    32: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //    35: ifnull          63
                                //    38: aload_2        
                                //    39: ldc             2
                                //    41: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //    44: invokeinterface instrumented/java/util/stream/DoubleStream.sequential:()Linstrumented/java/util/stream/DoubleStream;
                                //    49: aload_0        
                                //    50: getfield        instrumented/java/util/stream/ReferencePipeline$9$1.downstreamAsDouble:Linstrumented/java/util/function/DoubleConsumer;
                                //    53: ldc             3
                                //    55: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //    58: invokeinterface instrumented/java/util/stream/DoubleStream.forEach:(Linstrumented/java/util/function/DoubleConsumer;)V
                                //    63: aload_2        
                                //    64: ldc             2
                                //    66: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //    69: ifnull          237
                                //    72: aload_3        
                                //    73: ldc             2
                                //    75: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //    78: ifnull          121
                                //    81: aload_2        
                                //    82: ldc             2
                                //    84: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //    87: invokeinterface instrumented/java/util/stream/DoubleStream.close:()V
                                //    92: ldc             1
                                //    94: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //    97: goto            237
                                //   100: astore          4
                                //   102: aload_3        
                                //   103: aload           4
                                //   105: ldc             504
                                //   107: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   110: invokevirtual   java/lang/Throwable.addSuppressed:(Ljava/lang/Throwable;)V
                                //   113: ldc             1
                                //   115: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   118: goto            237
                                //   121: aload_2        
                                //   122: ldc             2
                                //   124: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   127: invokeinterface instrumented/java/util/stream/DoubleStream.close:()V
                                //   132: ldc             1
                                //   134: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   137: goto            237
                                //   140: astore          4
                                //   142: aload           4
                                //   144: astore_3       
                                //   145: aload           4
                                //   147: ldc             505
                                //   149: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   152: athrow         
                                //   153: astore          5
                                //   155: ldc             501
                                //   157: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   160: aload_2        
                                //   161: ldc             2
                                //   163: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   166: ifnull          229
                                //   169: aload_3        
                                //   170: ldc             2
                                //   172: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   175: ifnull          218
                                //   178: aload_2        
                                //   179: ldc             2
                                //   181: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   184: invokeinterface instrumented/java/util/stream/DoubleStream.close:()V
                                //   189: ldc             1
                                //   191: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   194: goto            229
                                //   197: astore          6
                                //   199: aload_3        
                                //   200: aload           6
                                //   202: ldc             504
                                //   204: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   207: invokevirtual   java/lang/Throwable.addSuppressed:(Ljava/lang/Throwable;)V
                                //   210: ldc             1
                                //   212: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   215: goto            229
                                //   218: aload_2        
                                //   219: ldc             2
                                //   221: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   224: invokeinterface instrumented/java/util/stream/DoubleStream.close:()V
                                //   229: aload           5
                                //   231: ldc             2
                                //   233: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   236: athrow         
                                //   237: ldc             1
                                //   239: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   242: return         
                                //   243: athrow         
                                //   244: athrow         
                                //    Signature:
                                //  (TP_OUT;)V
                                //    StackMapTable: 00 0B FD 00 3F 07 00 5C 07 00 45 64 07 00 45 14 52 07 00 45 4C 07 00 45 FF 00 2B 00 06 07 00 02 07 00 2C 07 00 5C 07 00 45 00 07 00 45 00 01 07 00 45 14 0A FF 00 07 00 02 07 00 02 07 00 2C 00 00 FF 00 05 00 00 00 01 07 00 45 FF 00 00 00 00 00 01 07 00 50
                                //    Exceptions:
                                //  Try           Handler
                                //  Start  End    Start  End    Type                           
                                //  -----  -----  -----  -----  -------------------------------
                                //  29     244    244    245    Ljava/lang/VirtualMachineError;
                                //  81     92     100    121    Ljava/lang/Throwable;
                                //  29     63     140    153    Ljava/lang/Throwable;
                                //  29     63     153    237    Any
                                //  178    189    197    218    Ljava/lang/Throwable;
                                //  140    160    153    237    Any
                                //  0      243    243    244    Any
                                // 
                                // The error that occurred was:
                                // 
                                // java.lang.IllegalStateException: Expression is linked from several locations: Label_0063:
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
                        return chainedReference;
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
    public final LongStream flatMapToLong(final Function<? super P_OUT, ? extends LongStream> function) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(function);
            BytecodeManager.incBytecodes(1);
            final StreamShape reference = StreamShape.REFERENCE;
            final int n = StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT | StreamOpFlag.NOT_SIZED;
            BytecodeManager.incBytecodes(12);
            final LongPipeline.StatelessOp<P_OUT> statelessOp = new LongPipeline.StatelessOp<P_OUT>(this, reference, n) {
                {
                    BytecodeManager.incBytecodes(1);
                }
                
                @Override
                Sink<P_OUT> opWrapSink(final int n, final Sink<Long> sink) {
                    try {
                        BytecodeManager.incBytecodes(5);
                        final Sink.ChainedReference<P_OUT, Long> chainedReference = new Sink.ChainedReference<P_OUT, Long>(sink) {
                            LongConsumer downstreamAsLong;
                            
                            {
                                final Sink<? super E_OUT> downstream = this.downstream;
                                BytecodeManager.incBytecodes(5);
                                downstream.getClass();
                                this.downstreamAsLong = downstream::accept;
                                BytecodeManager.incBytecodes(3);
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
                            public void accept(final P_OUT p0) {
                                // 
                                // This method could not be decompiled.
                                // 
                                // Original Bytecode:
                                // 
                                //     1: getfield        instrumented/java/util/stream/ReferencePipeline$10$1.this$1:Linstrumented/java/util/stream/ReferencePipeline$10;
                                //     4: getfield        instrumented/java/util/stream/ReferencePipeline$10.val$mapper:Linstrumented/java/util/function/Function;
                                //     7: aload_1        
                                //     8: ldc             5
                                //    10: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //    13: invokeinterface instrumented/java/util/function/Function.apply:(Ljava/lang/Object;)Ljava/lang/Object;
                                //    18: checkcast       Linstrumented/java/util/stream/LongStream;
                                //    21: astore_2       
                                //    22: aconst_null    
                                //    23: astore_3       
                                //    24: ldc             4
                                //    26: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //    29: aload_2        
                                //    30: ldc             2
                                //    32: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //    35: ifnull          63
                                //    38: aload_2        
                                //    39: ldc             2
                                //    41: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //    44: invokeinterface instrumented/java/util/stream/LongStream.sequential:()Linstrumented/java/util/stream/LongStream;
                                //    49: aload_0        
                                //    50: getfield        instrumented/java/util/stream/ReferencePipeline$10$1.downstreamAsLong:Linstrumented/java/util/function/LongConsumer;
                                //    53: ldc             3
                                //    55: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //    58: invokeinterface instrumented/java/util/stream/LongStream.forEach:(Linstrumented/java/util/function/LongConsumer;)V
                                //    63: aload_2        
                                //    64: ldc             2
                                //    66: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //    69: ifnull          237
                                //    72: aload_3        
                                //    73: ldc             2
                                //    75: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //    78: ifnull          121
                                //    81: aload_2        
                                //    82: ldc             2
                                //    84: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //    87: invokeinterface instrumented/java/util/stream/LongStream.close:()V
                                //    92: ldc             1
                                //    94: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //    97: goto            237
                                //   100: astore          4
                                //   102: aload_3        
                                //   103: aload           4
                                //   105: ldc             504
                                //   107: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   110: invokevirtual   java/lang/Throwable.addSuppressed:(Ljava/lang/Throwable;)V
                                //   113: ldc             1
                                //   115: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   118: goto            237
                                //   121: aload_2        
                                //   122: ldc             2
                                //   124: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   127: invokeinterface instrumented/java/util/stream/LongStream.close:()V
                                //   132: ldc             1
                                //   134: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   137: goto            237
                                //   140: astore          4
                                //   142: aload           4
                                //   144: astore_3       
                                //   145: aload           4
                                //   147: ldc             505
                                //   149: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   152: athrow         
                                //   153: astore          5
                                //   155: ldc             501
                                //   157: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   160: aload_2        
                                //   161: ldc             2
                                //   163: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   166: ifnull          229
                                //   169: aload_3        
                                //   170: ldc             2
                                //   172: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   175: ifnull          218
                                //   178: aload_2        
                                //   179: ldc             2
                                //   181: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   184: invokeinterface instrumented/java/util/stream/LongStream.close:()V
                                //   189: ldc             1
                                //   191: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   194: goto            229
                                //   197: astore          6
                                //   199: aload_3        
                                //   200: aload           6
                                //   202: ldc             504
                                //   204: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   207: invokevirtual   java/lang/Throwable.addSuppressed:(Ljava/lang/Throwable;)V
                                //   210: ldc             1
                                //   212: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   215: goto            229
                                //   218: aload_2        
                                //   219: ldc             2
                                //   221: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   224: invokeinterface instrumented/java/util/stream/LongStream.close:()V
                                //   229: aload           5
                                //   231: ldc             2
                                //   233: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   236: athrow         
                                //   237: ldc             1
                                //   239: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                                //   242: return         
                                //   243: athrow         
                                //   244: athrow         
                                //    Signature:
                                //  (TP_OUT;)V
                                //    StackMapTable: 00 0B FD 00 3F 07 00 5B 07 00 45 64 07 00 45 14 52 07 00 45 4C 07 00 45 FF 00 2B 00 06 07 00 02 07 00 2C 07 00 5B 07 00 45 00 07 00 45 00 01 07 00 45 14 0A FF 00 07 00 02 07 00 02 07 00 2C 00 00 FF 00 05 00 00 00 01 07 00 45 FF 00 00 00 00 00 01 07 00 4F
                                //    Exceptions:
                                //  Try           Handler
                                //  Start  End    Start  End    Type                           
                                //  -----  -----  -----  -----  -------------------------------
                                //  29     244    244    245    Ljava/lang/VirtualMachineError;
                                //  81     92     100    121    Ljava/lang/Throwable;
                                //  29     63     140    153    Ljava/lang/Throwable;
                                //  29     63     153    237    Any
                                //  178    189    197    218    Ljava/lang/Throwable;
                                //  140    160    153    237    Any
                                //  0      243    243    244    Any
                                // 
                                // The error that occurred was:
                                // 
                                // java.lang.IllegalStateException: Expression is linked from several locations: Label_0063:
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
                        return chainedReference;
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
    public final Stream<P_OUT> peek(final Consumer<? super P_OUT> consumer) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(consumer);
            BytecodeManager.incBytecodes(1);
            final StreamShape reference = StreamShape.REFERENCE;
            final int n = 0;
            BytecodeManager.incBytecodes(8);
            final StatelessOp<P_OUT, P_OUT> statelessOp = new StatelessOp<P_OUT, P_OUT>(this, reference, n) {
                {
                    BytecodeManager.incBytecodes(1);
                }
                
                @Override
                Sink<P_OUT> opWrapSink(final int n, final Sink<P_OUT> sink) {
                    try {
                        BytecodeManager.incBytecodes(5);
                        final Sink.ChainedReference<P_OUT, P_OUT> chainedReference = new Sink.ChainedReference<P_OUT, P_OUT>(sink) {
                            {
                                BytecodeManager.incBytecodes(1);
                            }
                            
                            @Override
                            public void accept(final P_OUT p_OUT) {
                                try {
                                    final Consumer val$action = consumer;
                                    BytecodeManager.incBytecodes(5);
                                    val$action.accept(p_OUT);
                                    final Sink<? super E_OUT> downstream = this.downstream;
                                    BytecodeManager.incBytecodes(4);
                                    downstream.accept(p_OUT);
                                    BytecodeManager.incBytecodes(1);
                                }
                                finally {
                                    throw loadexception(java.lang.Throwable.class);
                                }
                            }
                        };
                        BytecodeManager.incBytecodes(1);
                        return chainedReference;
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
    public final Stream<P_OUT> distinct() {
        try {
            BytecodeManager.incBytecodes(2);
            final ReferencePipeline<Object, Object> ref = DistinctOps.makeRef((AbstractPipeline<?, Object, ?>)this);
            BytecodeManager.incBytecodes(1);
            return (Stream<P_OUT>)ref;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final Stream<P_OUT> sorted() {
        try {
            BytecodeManager.incBytecodes(2);
            final Stream<P_OUT> ref = SortedOps.makeRef((AbstractPipeline<?, P_OUT, ?>)this);
            BytecodeManager.incBytecodes(1);
            return ref;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final Stream<P_OUT> sorted(final Comparator<? super P_OUT> comparator) {
        try {
            BytecodeManager.incBytecodes(3);
            final Stream<P_OUT> ref = SortedOps.makeRef((AbstractPipeline<?, P_OUT, ?>)this, comparator);
            BytecodeManager.incBytecodes(1);
            return ref;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final Stream<P_OUT> limit(final long i) {
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
            final Stream<P_OUT> ref = SliceOps.makeRef((AbstractPipeline<?, P_OUT, ?>)this, n2, i);
            BytecodeManager.incBytecodes(1);
            return ref;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final Stream<P_OUT> skip(final long i) {
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
            final Stream<P_OUT> ref = SliceOps.makeRef((AbstractPipeline<?, P_OUT, ?>)this, i, n3);
            BytecodeManager.incBytecodes(1);
            return ref;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void forEach(final Consumer<? super P_OUT> consumer) {
        try {
            final boolean b = false;
            BytecodeManager.incBytecodes(4);
            final TerminalOp<Object, Void> ref = (TerminalOp<Object, Void>)ForEachOps.makeRef(consumer, b);
            BytecodeManager.incBytecodes(1);
            this.evaluate((TerminalOp<P_OUT, Object>)ref);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void forEachOrdered(final Consumer<? super P_OUT> consumer) {
        try {
            final boolean b = true;
            BytecodeManager.incBytecodes(4);
            final TerminalOp<Object, Void> ref = (TerminalOp<Object, Void>)ForEachOps.makeRef(consumer, b);
            BytecodeManager.incBytecodes(1);
            this.evaluate((TerminalOp<P_OUT, Object>)ref);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final <A> A[] toArray(final IntFunction<A[]> intFunction) {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(3);
            final Node<P_OUT> evaluateToArrayNode = this.evaluateToArrayNode((IntFunction<P_OUT[]>)intFunction);
            BytecodeManager.incBytecodes(2);
            final Node<P_OUT> flatten = Nodes.flatten(evaluateToArrayNode, (IntFunction<P_OUT[]>)intFunction);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
            final P_OUT[] array = flatten.asArray((IntFunction<P_OUT[]>)intFunction);
            BytecodeManager.incBytecodes(2);
            return (A[])array;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final Object[] toArray() {
        try {
            Object[] array;
            final IntFunction<Object> intFunction = n -> {
                try {
                    array = new Object[n];
                    BytecodeManager.incBytecodes(2);
                    return array;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            BytecodeManager.incBytecodes(2);
            final Object[] array2 = this.toArray((IntFunction<Object[]>)intFunction);
            BytecodeManager.incBytecodes(1);
            return array2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final boolean anyMatch(final Predicate<? super P_OUT> predicate) {
        try {
            final MatchOps.MatchKind any = MatchOps.MatchKind.ANY;
            BytecodeManager.incBytecodes(4);
            final TerminalOp<Object, Boolean> ref = MatchOps.makeRef((Predicate<? super Object>)predicate, any);
            BytecodeManager.incBytecodes(1);
            final Boolean b = this.evaluate((TerminalOp<P_OUT, Boolean>)ref);
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
    public final boolean allMatch(final Predicate<? super P_OUT> predicate) {
        try {
            final MatchOps.MatchKind all = MatchOps.MatchKind.ALL;
            BytecodeManager.incBytecodes(4);
            final TerminalOp<Object, Boolean> ref = MatchOps.makeRef((Predicate<? super Object>)predicate, all);
            BytecodeManager.incBytecodes(1);
            final Boolean b = this.evaluate((TerminalOp<P_OUT, Boolean>)ref);
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
    public final boolean noneMatch(final Predicate<? super P_OUT> predicate) {
        try {
            final MatchOps.MatchKind none = MatchOps.MatchKind.NONE;
            BytecodeManager.incBytecodes(4);
            final TerminalOp<Object, Boolean> ref = MatchOps.makeRef((Predicate<? super Object>)predicate, none);
            BytecodeManager.incBytecodes(1);
            final Boolean b = this.evaluate((TerminalOp<P_OUT, Boolean>)ref);
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
    public final Optional<P_OUT> findFirst() {
        try {
            final boolean b = true;
            BytecodeManager.incBytecodes(3);
            final TerminalOp<Object, Optional<Object>> ref = FindOps.makeRef(b);
            BytecodeManager.incBytecodes(1);
            final Optional<P_OUT> optional = this.evaluate((TerminalOp<P_OUT, Optional<P_OUT>>)ref);
            BytecodeManager.incBytecodes(2);
            return optional;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final Optional<P_OUT> findAny() {
        try {
            final boolean b = false;
            BytecodeManager.incBytecodes(3);
            final TerminalOp<Object, Optional<Object>> ref = FindOps.makeRef(b);
            BytecodeManager.incBytecodes(1);
            final Optional<P_OUT> optional = this.evaluate((TerminalOp<P_OUT, Optional<P_OUT>>)ref);
            BytecodeManager.incBytecodes(2);
            return optional;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final P_OUT reduce(final P_OUT p0, final BinaryOperator<P_OUT> p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: aload_1        
        //     2: aload_2        
        //     3: aload_2        
        //     4: ldc             5
        //     6: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     9: invokestatic    instrumented/java/util/stream/ReduceOps.makeRef:(Ljava/lang/Object;Linstrumented/java/util/function/BiFunction;Linstrumented/java/util/function/BinaryOperator;)Linstrumented/java/util/stream/TerminalOp;
        //    12: ldc             1
        //    14: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    17: invokevirtual   instrumented/java/util/stream/ReferencePipeline.evaluate:(Linstrumented/java/util/stream/TerminalOp;)Ljava/lang/Object;
        //    20: ldc             1
        //    22: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    25: areturn        
        //    26: athrow         
        //    Signature:
        //  (TP_OUT;Linstrumented/java/util/function/BinaryOperator<TP_OUT;>;)TP_OUT;
        //    StackMapTable: 00 01 FF 00 1A 00 00 00 01 07 00 51
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  0      26     26     27     Any
        // 
        // The error that occurred was:
        // 
        // com.strobel.assembler.metadata.MetadataHelper$AdaptFailure
        //     at com.strobel.assembler.metadata.MetadataHelper$Adapter.visitGenericParameter(MetadataHelper.java:2300)
        //     at com.strobel.assembler.metadata.MetadataHelper$Adapter.visitGenericParameter(MetadataHelper.java:2221)
        //     at com.strobel.assembler.metadata.GenericParameter.accept(GenericParameter.java:85)
        //     at com.strobel.assembler.metadata.DefaultTypeVisitor.visit(DefaultTypeVisitor.java:25)
        //     at com.strobel.assembler.metadata.MetadataHelper$Adapter.adaptRecursive(MetadataHelper.java:2255)
        //     at com.strobel.assembler.metadata.MetadataHelper$Adapter.adaptRecursive(MetadataHelper.java:2232)
        //     at com.strobel.assembler.metadata.MetadataHelper$Adapter.visitParameterizedType(MetadataHelper.java:2245)
        //     at com.strobel.assembler.metadata.MetadataHelper$Adapter.visitParameterizedType(MetadataHelper.java:2221)
        //     at com.strobel.assembler.metadata.ParameterizedType.accept(ParameterizedType.java:103)
        //     at com.strobel.assembler.metadata.DefaultTypeVisitor.visit(DefaultTypeVisitor.java:25)
        //     at com.strobel.assembler.metadata.MetadataHelper.adapt(MetadataHelper.java:1312)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:932)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:803)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferCall(TypeAnalysis.java:2695)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1029)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:803)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:770)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:881)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:803)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:672)
        //     at com.strobel.decompiler.ast.TypeAnalysis.invalidateDependentExpressions(TypeAnalysis.java:759)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1011)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:803)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:778)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1656)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:803)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:672)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:655)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:365)
        //     at com.strobel.decompiler.ast.TypeAnalysis.run(TypeAnalysis.java:96)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:109)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
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
    
    @Override
    public final Optional<P_OUT> reduce(final BinaryOperator<P_OUT> binaryOperator) {
        try {
            BytecodeManager.incBytecodes(3);
            final TerminalOp<P_OUT, Optional<P_OUT>> ref = ReduceOps.makeRef(binaryOperator);
            BytecodeManager.incBytecodes(1);
            final Optional<P_OUT> optional = this.evaluate(ref);
            BytecodeManager.incBytecodes(2);
            return optional;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final <R> R reduce(final R r, final BiFunction<R, ? super P_OUT, R> biFunction, final BinaryOperator<R> binaryOperator) {
        try {
            BytecodeManager.incBytecodes(5);
            final TerminalOp<P_OUT, R> ref = ReduceOps.makeRef(r, biFunction, binaryOperator);
            BytecodeManager.incBytecodes(1);
            final R evaluate = this.evaluate(ref);
            BytecodeManager.incBytecodes(1);
            return evaluate;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final <R, A> R collect(final Collector<? super P_OUT, A, R> collector) {
        try {
            BytecodeManager.incBytecodes(2);
            final boolean parallel = this.isParallel();
            BytecodeManager.incBytecodes(1);
            Object o2 = null;
            Label_0200: {
                Label_0176: {
                    if (parallel) {
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                        final Set<Collector.Characteristics> characteristics = collector.characteristics();
                        final Collector.Characteristics concurrent = Collector.Characteristics.CONCURRENT;
                        BytecodeManager.incBytecodes(2);
                        final boolean contains = characteristics.contains(concurrent);
                        BytecodeManager.incBytecodes(1);
                        if (contains) {
                            BytecodeManager.incBytecodes(1);
                            BytecodeManager.incBytecodes(1);
                            final boolean ordered = this.isOrdered();
                            BytecodeManager.incBytecodes(1);
                            if (ordered) {
                                BytecodeManager.incBytecodes(2);
                                final Set<Collector.Characteristics> characteristics2 = collector.characteristics();
                                final Collector.Characteristics unordered = Collector.Characteristics.UNORDERED;
                                BytecodeManager.incBytecodes(2);
                                final boolean contains2 = characteristics2.contains(unordered);
                                BytecodeManager.incBytecodes(1);
                                if (!contains2) {
                                    break Label_0176;
                                }
                            }
                            BytecodeManager.incBytecodes(2);
                            final Supplier<A> supplier = collector.supplier();
                            BytecodeManager.incBytecodes(1);
                            o2 = supplier.get();
                            BytecodeManager.incBytecodes(1);
                            BytecodeManager.incBytecodes(2);
                            collector.accumulator();
                            BytecodeManager.incBytecodes(1);
                            final BiConsumer<Object, Object> biConsumer;
                            final Object o3;
                            final Consumer<? super P_OUT> consumer = o -> {
                                try {
                                    BytecodeManager.incBytecodes(4);
                                    biConsumer.accept(o3, o);
                                    BytecodeManager.incBytecodes(1);
                                    return;
                                }
                                finally {
                                    throw loadexception(java.lang.Throwable.class);
                                }
                            };
                            BytecodeManager.incBytecodes(4);
                            this.forEach(consumer);
                            BytecodeManager.incBytecodes(1);
                            break Label_0200;
                        }
                    }
                }
                BytecodeManager.incBytecodes(3);
                final TerminalOp<P_OUT, A> ref = ReduceOps.makeRef((Collector<? super P_OUT, A, ?>)collector);
                BytecodeManager.incBytecodes(1);
                o2 = this.evaluate((TerminalOp<P_OUT, R>)ref);
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(2);
            final Set<Collector.Characteristics> characteristics3 = collector.characteristics();
            final Collector.Characteristics identity_FINISH = Collector.Characteristics.IDENTITY_FINISH;
            BytecodeManager.incBytecodes(2);
            final boolean contains3 = characteristics3.contains(identity_FINISH);
            BytecodeManager.incBytecodes(1);
            Object apply;
            if (contains3) {
                apply = o2;
                BytecodeManager.incBytecodes(2);
            }
            else {
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                final Function<A, ?> finisher = collector.finisher();
                final Object o4 = o2;
                BytecodeManager.incBytecodes(2);
                apply = finisher.apply((A)o4);
            }
            BytecodeManager.incBytecodes(1);
            return (R)apply;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final <R> R collect(final Supplier<R> supplier, final BiConsumer<R, ? super P_OUT> biConsumer, final BiConsumer<R, R> biConsumer2) {
        try {
            BytecodeManager.incBytecodes(5);
            final TerminalOp<P_OUT, R> ref = ReduceOps.makeRef(supplier, biConsumer, biConsumer2);
            BytecodeManager.incBytecodes(1);
            final R evaluate = this.evaluate(ref);
            BytecodeManager.incBytecodes(1);
            return evaluate;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final Optional<P_OUT> max(final Comparator<? super P_OUT> comparator) {
        try {
            BytecodeManager.incBytecodes(3);
            final BinaryOperator<P_OUT> maxBy = BinaryOperator.maxBy(comparator);
            BytecodeManager.incBytecodes(1);
            final Optional<P_OUT> reduce = this.reduce(maxBy);
            BytecodeManager.incBytecodes(1);
            return reduce;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final Optional<P_OUT> min(final Comparator<? super P_OUT> comparator) {
        try {
            BytecodeManager.incBytecodes(3);
            final BinaryOperator<P_OUT> minBy = BinaryOperator.minBy(comparator);
            BytecodeManager.incBytecodes(1);
            final Optional<P_OUT> reduce = this.reduce(minBy);
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
            final ToLongFunction<? super P_OUT> toLongFunction = p0 -> {
                try {
                    BytecodeManager.incBytecodes(2);
                    return n;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            BytecodeManager.incBytecodes(2);
            final LongStream mapToLong = this.mapToLong(toLongFunction);
            BytecodeManager.incBytecodes(1);
            final long sum = mapToLong.sum();
            BytecodeManager.incBytecodes(1);
            return sum;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static class Head<E_IN, E_OUT> extends ReferencePipeline<E_IN, E_OUT>
    {
        Head(final Supplier<? extends Spliterator<?>> supplier, final int n, final boolean b) {
            try {
                BytecodeManager.incBytecodes(5);
                super(supplier, n, b);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        Head(final Spliterator<?> spliterator, final int n, final boolean b) {
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
        final Sink<E_IN> opWrapSink(final int n, final Sink<E_OUT> sink) {
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
        public void forEach(final Consumer<? super E_OUT> consumer) {
            try {
                BytecodeManager.incBytecodes(2);
                final boolean parallel = this.isParallel();
                BytecodeManager.incBytecodes(1);
                if (!parallel) {
                    BytecodeManager.incBytecodes(2);
                    final Spliterator<P_OUT> sourceStageSpliterator = this.sourceStageSpliterator();
                    BytecodeManager.incBytecodes(2);
                    sourceStageSpliterator.forEachRemaining((Consumer<? super P_OUT>)consumer);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    BytecodeManager.incBytecodes(3);
                    super.forEach(consumer);
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void forEachOrdered(final Consumer<? super E_OUT> consumer) {
            try {
                BytecodeManager.incBytecodes(2);
                final boolean parallel = this.isParallel();
                BytecodeManager.incBytecodes(1);
                if (!parallel) {
                    BytecodeManager.incBytecodes(2);
                    final Spliterator<P_OUT> sourceStageSpliterator = this.sourceStageSpliterator();
                    BytecodeManager.incBytecodes(2);
                    sourceStageSpliterator.forEachRemaining((Consumer<? super P_OUT>)consumer);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    BytecodeManager.incBytecodes(3);
                    super.forEachOrdered(consumer);
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    abstract static class StatelessOp<E_IN, E_OUT> extends ReferencePipeline<E_IN, E_OUT>
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
                final Class<ReferencePipeline> clazz = ReferencePipeline.class;
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
    
    abstract static class StatefulOp<E_IN, E_OUT> extends ReferencePipeline<E_IN, E_OUT>
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
        abstract <P_IN> Node<E_OUT> opEvaluateParallel(final PipelineHelper<E_OUT> p0, final Spliterator<P_IN> p1, final IntFunction<E_OUT[]> p2);
        
        static {
            try {
                final Class<ReferencePipeline> clazz = ReferencePipeline.class;
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
