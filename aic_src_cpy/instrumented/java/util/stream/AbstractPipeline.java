// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.stream;

import instrumented.java.util.function.Consumer;
import instrumented.java.util.Objects;
import instrumented.java.util.function.IntFunction;
import aic2021.engine.BytecodeManager;
import instrumented.java.util.function.Supplier;
import instrumented.java.util.Spliterator;

abstract class AbstractPipeline<E_IN, E_OUT, S extends BaseStream<E_OUT, S>> extends PipelineHelper<E_OUT> implements BaseStream<E_OUT, S>
{
    private static final String MSG_STREAM_LINKED = "stream has already been operated upon or closed";
    private static final String MSG_CONSUMED = "source already consumed or closed";
    private final AbstractPipeline sourceStage;
    private final AbstractPipeline previousStage;
    protected final int sourceOrOpFlags;
    private AbstractPipeline nextStage;
    private int depth;
    private int combinedFlags;
    private Spliterator<?> sourceSpliterator;
    private Supplier<? extends Spliterator<?>> sourceSupplier;
    private boolean linkedOrConsumed;
    private boolean sourceAnyStateful;
    private Runnable sourceCloseAction;
    private boolean parallel;
    static final /* synthetic */ boolean $assertionsDisabled;
    
    AbstractPipeline(final Supplier<? extends Spliterator<?>> sourceSupplier, final int n, final boolean parallel) {
        try {
            BytecodeManager.incBytecodes(2);
            this.previousStage = null;
            BytecodeManager.incBytecodes(3);
            this.sourceSupplier = sourceSupplier;
            BytecodeManager.incBytecodes(3);
            this.sourceStage = this;
            BytecodeManager.incBytecodes(3);
            this.sourceOrOpFlags = (n & StreamOpFlag.STREAM_MASK);
            BytecodeManager.incBytecodes(5);
            this.combinedFlags = (~(this.sourceOrOpFlags << 1) & StreamOpFlag.INITIAL_OPS_VALUE);
            BytecodeManager.incBytecodes(10);
            this.depth = 0;
            BytecodeManager.incBytecodes(3);
            this.parallel = parallel;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    AbstractPipeline(final Spliterator<?> sourceSpliterator, final int n, final boolean parallel) {
        try {
            BytecodeManager.incBytecodes(2);
            this.previousStage = null;
            BytecodeManager.incBytecodes(3);
            this.sourceSpliterator = sourceSpliterator;
            BytecodeManager.incBytecodes(3);
            this.sourceStage = this;
            BytecodeManager.incBytecodes(3);
            this.sourceOrOpFlags = (n & StreamOpFlag.STREAM_MASK);
            BytecodeManager.incBytecodes(5);
            this.combinedFlags = (~(this.sourceOrOpFlags << 1) & StreamOpFlag.INITIAL_OPS_VALUE);
            BytecodeManager.incBytecodes(10);
            this.depth = 0;
            BytecodeManager.incBytecodes(3);
            this.parallel = parallel;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    AbstractPipeline(final AbstractPipeline<?, E_IN, ?> previousStage, final int n) {
        try {
            BytecodeManager.incBytecodes(2);
            final boolean linkedOrConsumed = previousStage.linkedOrConsumed;
            BytecodeManager.incBytecodes(3);
            if (linkedOrConsumed) {
                final String s = "stream has already been operated upon or closed";
                BytecodeManager.incBytecodes(4);
                final IllegalStateException ex = new IllegalStateException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            previousStage.linkedOrConsumed = true;
            BytecodeManager.incBytecodes(3);
            previousStage.nextStage = this;
            BytecodeManager.incBytecodes(3);
            this.previousStage = previousStage;
            BytecodeManager.incBytecodes(3);
            this.sourceOrOpFlags = (n & StreamOpFlag.OP_MASK);
            BytecodeManager.incBytecodes(5);
            final int combinedFlags = previousStage.combinedFlags;
            BytecodeManager.incBytecodes(5);
            this.combinedFlags = StreamOpFlag.combineOpFlags(n, combinedFlags);
            BytecodeManager.incBytecodes(1);
            this.sourceStage = previousStage.sourceStage;
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(2);
            final boolean opIsStateful = this.opIsStateful();
            BytecodeManager.incBytecodes(1);
            if (opIsStateful) {
                this.sourceStage.sourceAnyStateful = true;
                BytecodeManager.incBytecodes(4);
            }
            this.depth = previousStage.depth + 1;
            BytecodeManager.incBytecodes(6);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final <R> R evaluate(final TerminalOp<E_OUT, R> terminalOp) {
        try {
            final boolean $assertionsDisabled = AbstractPipeline.$assertionsDisabled;
            BytecodeManager.incBytecodes(2);
            if (!$assertionsDisabled) {
                BytecodeManager.incBytecodes(2);
                final StreamShape outputShape = this.getOutputShape();
                BytecodeManager.incBytecodes(2);
                final StreamShape inputShape = terminalOp.inputShape();
                BytecodeManager.incBytecodes(1);
                if (outputShape != inputShape) {
                    BytecodeManager.incBytecodes(3);
                    final AssertionError assertionError = new AssertionError();
                    BytecodeManager.incBytecodes(1);
                    throw assertionError;
                }
            }
            final boolean linkedOrConsumed = this.linkedOrConsumed;
            BytecodeManager.incBytecodes(3);
            if (linkedOrConsumed) {
                final String s = "stream has already been operated upon or closed";
                BytecodeManager.incBytecodes(4);
                final IllegalStateException ex = new IllegalStateException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            this.linkedOrConsumed = true;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(2);
            final boolean parallel = this.isParallel();
            BytecodeManager.incBytecodes(1);
            R r;
            if (parallel) {
                BytecodeManager.incBytecodes(4);
                BytecodeManager.incBytecodes(1);
                final int opFlags = terminalOp.getOpFlags();
                BytecodeManager.incBytecodes(1);
                final Spliterator<?> sourceSpliterator = this.sourceSpliterator(opFlags);
                BytecodeManager.incBytecodes(1);
                r = terminalOp.evaluateParallel(this, sourceSpliterator);
                BytecodeManager.incBytecodes(1);
            }
            else {
                BytecodeManager.incBytecodes(4);
                BytecodeManager.incBytecodes(1);
                final int opFlags2 = terminalOp.getOpFlags();
                BytecodeManager.incBytecodes(1);
                final Spliterator<?> sourceSpliterator2 = this.sourceSpliterator(opFlags2);
                BytecodeManager.incBytecodes(1);
                r = terminalOp.evaluateSequential(this, sourceSpliterator2);
            }
            BytecodeManager.incBytecodes(1);
            return r;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final Node<E_OUT> evaluateToArrayNode(final IntFunction<E_OUT[]> intFunction) {
        try {
            final boolean linkedOrConsumed = this.linkedOrConsumed;
            BytecodeManager.incBytecodes(3);
            if (linkedOrConsumed) {
                final String s = "stream has already been operated upon or closed";
                BytecodeManager.incBytecodes(4);
                final IllegalStateException ex = new IllegalStateException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            this.linkedOrConsumed = true;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(2);
            final boolean parallel = this.isParallel();
            BytecodeManager.incBytecodes(1);
            if (parallel) {
                final AbstractPipeline previousStage = this.previousStage;
                BytecodeManager.incBytecodes(3);
                if (previousStage != null) {
                    BytecodeManager.incBytecodes(2);
                    final boolean opIsStateful = this.opIsStateful();
                    BytecodeManager.incBytecodes(1);
                    if (opIsStateful) {
                        this.depth = 0;
                        BytecodeManager.incBytecodes(3);
                        final AbstractPipeline previousStage2 = this.previousStage;
                        final AbstractPipeline previousStage3 = this.previousStage;
                        final int n = 0;
                        BytecodeManager.incBytecodes(7);
                        final Spliterator sourceSpliterator = previousStage3.sourceSpliterator(n);
                        BytecodeManager.incBytecodes(2);
                        final Node<E_OUT> opEvaluateParallel = this.opEvaluateParallel(previousStage2, sourceSpliterator, intFunction);
                        BytecodeManager.incBytecodes(1);
                        return opEvaluateParallel;
                    }
                }
            }
            final int n2 = 0;
            BytecodeManager.incBytecodes(4);
            final Spliterator<?> sourceSpliterator2 = this.sourceSpliterator(n2);
            final boolean b = true;
            BytecodeManager.incBytecodes(3);
            final Node<E_OUT> evaluate = this.evaluate(sourceSpliterator2, b, intFunction);
            BytecodeManager.incBytecodes(1);
            return evaluate;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final Spliterator<E_OUT> sourceStageSpliterator() {
        try {
            final AbstractPipeline sourceStage = this.sourceStage;
            BytecodeManager.incBytecodes(4);
            if (this != sourceStage) {
                BytecodeManager.incBytecodes(3);
                final IllegalStateException ex = new IllegalStateException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final boolean linkedOrConsumed = this.linkedOrConsumed;
            BytecodeManager.incBytecodes(3);
            if (linkedOrConsumed) {
                final String s = "stream has already been operated upon or closed";
                BytecodeManager.incBytecodes(4);
                final IllegalStateException ex2 = new IllegalStateException(s);
                BytecodeManager.incBytecodes(1);
                throw ex2;
            }
            this.linkedOrConsumed = true;
            BytecodeManager.incBytecodes(3);
            final Spliterator<?> sourceSpliterator = this.sourceStage.sourceSpliterator;
            BytecodeManager.incBytecodes(4);
            if (sourceSpliterator != null) {
                final Spliterator<?> sourceSpliterator2 = this.sourceStage.sourceSpliterator;
                BytecodeManager.incBytecodes(4);
                this.sourceStage.sourceSpliterator = null;
                BytecodeManager.incBytecodes(4);
                final Spliterator<?> spliterator = sourceSpliterator2;
                BytecodeManager.incBytecodes(2);
                return (Spliterator<E_OUT>)spliterator;
            }
            final Supplier<? extends Spliterator<?>> sourceSupplier = this.sourceStage.sourceSupplier;
            BytecodeManager.incBytecodes(4);
            if (sourceSupplier != null) {
                final Supplier<? extends Spliterator<?>> sourceSupplier2 = this.sourceStage.sourceSupplier;
                BytecodeManager.incBytecodes(4);
                final Spliterator<E_OUT> spliterator2 = (Spliterator<E_OUT>)sourceSupplier2.get();
                BytecodeManager.incBytecodes(2);
                this.sourceStage.sourceSupplier = null;
                BytecodeManager.incBytecodes(4);
                final Spliterator<E_OUT> spliterator3 = spliterator2;
                BytecodeManager.incBytecodes(2);
                return spliterator3;
            }
            final String s2 = "source already consumed or closed";
            BytecodeManager.incBytecodes(4);
            final IllegalStateException ex3 = new IllegalStateException(s2);
            BytecodeManager.incBytecodes(1);
            throw ex3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final S sequential() {
        try {
            this.sourceStage.parallel = false;
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(2);
            return (S)this;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final S parallel() {
        try {
            this.sourceStage.parallel = true;
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(2);
            return (S)this;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void close() {
        try {
            this.linkedOrConsumed = true;
            BytecodeManager.incBytecodes(3);
            this.sourceSupplier = null;
            BytecodeManager.incBytecodes(3);
            this.sourceSpliterator = null;
            BytecodeManager.incBytecodes(3);
            final Runnable sourceCloseAction = this.sourceStage.sourceCloseAction;
            BytecodeManager.incBytecodes(4);
            if (sourceCloseAction != null) {
                final Runnable sourceCloseAction2 = this.sourceStage.sourceCloseAction;
                BytecodeManager.incBytecodes(4);
                this.sourceStage.sourceCloseAction = null;
                BytecodeManager.incBytecodes(4);
                final Runnable runnable = sourceCloseAction2;
                BytecodeManager.incBytecodes(2);
                runnable.run();
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public S onClose(final Runnable runnable) {
        try {
            final Runnable sourceCloseAction = this.sourceStage.sourceCloseAction;
            BytecodeManager.incBytecodes(4);
            final AbstractPipeline sourceStage = this.sourceStage;
            final Runnable runnable2 = sourceCloseAction;
            BytecodeManager.incBytecodes(4);
            Runnable composeWithExceptions;
            if (runnable2 == null) {
                composeWithExceptions = runnable;
                BytecodeManager.incBytecodes(2);
            }
            else {
                final Runnable runnable3 = sourceCloseAction;
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
                composeWithExceptions = Streams.composeWithExceptions(runnable3, runnable);
            }
            sourceStage.sourceCloseAction = composeWithExceptions;
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            return (S)this;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public Spliterator<E_OUT> spliterator() {
        try {
            final boolean linkedOrConsumed = this.linkedOrConsumed;
            BytecodeManager.incBytecodes(3);
            if (linkedOrConsumed) {
                final String s = "stream has already been operated upon or closed";
                BytecodeManager.incBytecodes(4);
                final IllegalStateException ex = new IllegalStateException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            this.linkedOrConsumed = true;
            BytecodeManager.incBytecodes(3);
            final AbstractPipeline sourceStage = this.sourceStage;
            BytecodeManager.incBytecodes(4);
            if (this != sourceStage) {
                final int n;
                final Object o;
                final Supplier<Object> supplier = () -> {
                    try {
                        BytecodeManager.incBytecodes(3);
                        this.sourceSpliterator(n);
                        BytecodeManager.incBytecodes(1);
                        return o;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                };
                BytecodeManager.incBytecodes(5);
                final boolean parallel = this.isParallel();
                BytecodeManager.incBytecodes(1);
                final Spliterator<E_OUT> wrap = this.wrap(this, (Supplier<Spliterator<Object>>)supplier, parallel);
                BytecodeManager.incBytecodes(1);
                return wrap;
            }
            final Spliterator<?> sourceSpliterator = this.sourceStage.sourceSpliterator;
            BytecodeManager.incBytecodes(4);
            if (sourceSpliterator != null) {
                final Spliterator<?> sourceSpliterator2 = this.sourceStage.sourceSpliterator;
                BytecodeManager.incBytecodes(4);
                this.sourceStage.sourceSpliterator = null;
                BytecodeManager.incBytecodes(4);
                final Spliterator<?> spliterator = sourceSpliterator2;
                BytecodeManager.incBytecodes(2);
                return (Spliterator<E_OUT>)spliterator;
            }
            final Supplier<? extends Spliterator<?>> sourceSupplier = this.sourceStage.sourceSupplier;
            BytecodeManager.incBytecodes(4);
            if (sourceSupplier != null) {
                final Supplier<? extends Spliterator<?>> sourceSupplier2 = this.sourceStage.sourceSupplier;
                BytecodeManager.incBytecodes(4);
                this.sourceStage.sourceSupplier = null;
                BytecodeManager.incBytecodes(4);
                final Supplier<? extends Spliterator<E_OUT>> supplier2 = (Supplier<? extends Spliterator<E_OUT>>)sourceSupplier2;
                BytecodeManager.incBytecodes(3);
                final Spliterator<E_OUT> lazySpliterator = this.lazySpliterator(supplier2);
                BytecodeManager.incBytecodes(1);
                return lazySpliterator;
            }
            final String s2 = "source already consumed or closed";
            BytecodeManager.incBytecodes(4);
            final IllegalStateException ex2 = new IllegalStateException(s2);
            BytecodeManager.incBytecodes(1);
            throw ex2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public final boolean isParallel() {
        try {
            final boolean parallel = this.sourceStage.parallel;
            BytecodeManager.incBytecodes(4);
            return parallel;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final int getStreamFlags() {
        try {
            final int combinedFlags = this.combinedFlags;
            BytecodeManager.incBytecodes(3);
            final int streamFlags = StreamOpFlag.toStreamFlags(combinedFlags);
            BytecodeManager.incBytecodes(1);
            return streamFlags;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private Spliterator<?> sourceSpliterator(final int n) {
        try {
            BytecodeManager.incBytecodes(2);
            final Spliterator<?> sourceSpliterator = this.sourceStage.sourceSpliterator;
            BytecodeManager.incBytecodes(4);
            Spliterator<?> spliterator;
            if (sourceSpliterator != null) {
                spliterator = this.sourceStage.sourceSpliterator;
                BytecodeManager.incBytecodes(4);
                this.sourceStage.sourceSpliterator = null;
                BytecodeManager.incBytecodes(5);
            }
            else {
                final Supplier<? extends Spliterator<?>> sourceSupplier = this.sourceStage.sourceSupplier;
                BytecodeManager.incBytecodes(4);
                if (sourceSupplier == null) {
                    final String s = "source already consumed or closed";
                    BytecodeManager.incBytecodes(4);
                    final IllegalStateException ex = new IllegalStateException(s);
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final Supplier<? extends Spliterator<?>> sourceSupplier2 = this.sourceStage.sourceSupplier;
                BytecodeManager.incBytecodes(4);
                spliterator = (Spliterator<?>)sourceSupplier2.get();
                BytecodeManager.incBytecodes(2);
                this.sourceStage.sourceSupplier = null;
                BytecodeManager.incBytecodes(5);
            }
            BytecodeManager.incBytecodes(2);
            final boolean parallel = this.isParallel();
            BytecodeManager.incBytecodes(1);
            if (parallel) {
                final boolean sourceAnyStateful = this.sourceStage.sourceAnyStateful;
                BytecodeManager.incBytecodes(4);
                if (sourceAnyStateful) {
                    int n2 = 1;
                    BytecodeManager.incBytecodes(2);
                    AbstractPipeline<E_IN, ?, S> sourceStage = (AbstractPipeline<E_IN, ?, S>)this.sourceStage;
                    AbstractPipeline<E_IN, ?, S> abstractPipeline = (AbstractPipeline<E_IN, ?, S>)this.sourceStage.nextStage;
                    BytecodeManager.incBytecodes(9);
                    while (true) {
                        final AbstractPipeline<E_IN, ?, S> abstractPipeline2 = sourceStage;
                        BytecodeManager.incBytecodes(3);
                        if (abstractPipeline2 == this) {
                            break;
                        }
                        int sourceOrOpFlags = abstractPipeline.sourceOrOpFlags;
                        BytecodeManager.incBytecodes(3);
                        final AbstractPipeline<E_IN, ?, S> abstractPipeline3 = abstractPipeline;
                        BytecodeManager.incBytecodes(2);
                        final boolean opIsStateful = abstractPipeline3.opIsStateful();
                        BytecodeManager.incBytecodes(1);
                        if (opIsStateful) {
                            n2 = 0;
                            BytecodeManager.incBytecodes(2);
                            final StreamOpFlag short_CIRCUIT = StreamOpFlag.SHORT_CIRCUIT;
                            final int n3 = sourceOrOpFlags;
                            BytecodeManager.incBytecodes(3);
                            final boolean known = short_CIRCUIT.isKnown(n3);
                            BytecodeManager.incBytecodes(1);
                            if (known) {
                                sourceOrOpFlags &= ~StreamOpFlag.IS_SHORT_CIRCUIT;
                                BytecodeManager.incBytecodes(6);
                            }
                            final AbstractPipeline<E_IN, ?, S> abstractPipeline4 = abstractPipeline;
                            final AbstractPipeline<E_IN, ?, S> abstractPipeline5 = sourceStage;
                            final Spliterator<Object> spliterator2 = (Spliterator<Object>)spliterator;
                            BytecodeManager.incBytecodes(4);
                            spliterator = abstractPipeline4.opEvaluateParallelLazy(abstractPipeline5, spliterator2);
                            BytecodeManager.incBytecodes(1);
                            final Spliterator<Object> spliterator3 = (Spliterator<Object>)spliterator;
                            final int n4 = 64;
                            BytecodeManager.incBytecodes(3);
                            final boolean hasCharacteristics = spliterator3.hasCharacteristics(n4);
                            BytecodeManager.incBytecodes(1);
                            int n5;
                            if (hasCharacteristics) {
                                n5 = ((sourceOrOpFlags & ~StreamOpFlag.NOT_SIZED) | StreamOpFlag.IS_SIZED);
                                BytecodeManager.incBytecodes(8);
                            }
                            else {
                                n5 = ((sourceOrOpFlags & ~StreamOpFlag.IS_SIZED) | StreamOpFlag.NOT_SIZED);
                                BytecodeManager.incBytecodes(7);
                            }
                            sourceOrOpFlags = n5;
                            BytecodeManager.incBytecodes(1);
                        }
                        abstractPipeline.depth = n2++;
                        BytecodeManager.incBytecodes(4);
                        final AbstractPipeline<E_IN, ?, S> abstractPipeline6 = abstractPipeline;
                        final int n6 = sourceOrOpFlags;
                        final int combinedFlags = sourceStage.combinedFlags;
                        BytecodeManager.incBytecodes(5);
                        abstractPipeline6.combinedFlags = StreamOpFlag.combineOpFlags(n6, combinedFlags);
                        BytecodeManager.incBytecodes(1);
                        sourceStage = abstractPipeline;
                        abstractPipeline = abstractPipeline.nextStage;
                        BytecodeManager.incBytecodes(6);
                    }
                }
            }
            BytecodeManager.incBytecodes(2);
            if (n != 0) {
                final int combinedFlags2 = this.combinedFlags;
                BytecodeManager.incBytecodes(5);
                this.combinedFlags = StreamOpFlag.combineOpFlags(n, combinedFlags2);
                BytecodeManager.incBytecodes(1);
            }
            final Spliterator<Object> spliterator4 = (Spliterator<Object>)spliterator;
            BytecodeManager.incBytecodes(2);
            return spliterator4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    final StreamShape getSourceShape() {
        try {
            AbstractPipeline previousStage = this;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int depth = previousStage.depth;
                BytecodeManager.incBytecodes(3);
                if (depth <= 0) {
                    break;
                }
                previousStage = previousStage.previousStage;
                BytecodeManager.incBytecodes(4);
            }
            final AbstractPipeline abstractPipeline = previousStage;
            BytecodeManager.incBytecodes(2);
            final StreamShape outputShape = abstractPipeline.getOutputShape();
            BytecodeManager.incBytecodes(1);
            return outputShape;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    final <P_IN> long exactOutputSizeIfKnown(final Spliterator<P_IN> spliterator) {
        try {
            final StreamOpFlag sized = StreamOpFlag.SIZED;
            BytecodeManager.incBytecodes(3);
            final int streamAndOpFlags = this.getStreamAndOpFlags();
            BytecodeManager.incBytecodes(1);
            final boolean known = sized.isKnown(streamAndOpFlags);
            BytecodeManager.incBytecodes(1);
            long exactSizeIfKnown;
            if (known) {
                BytecodeManager.incBytecodes(2);
                exactSizeIfKnown = spliterator.getExactSizeIfKnown();
                BytecodeManager.incBytecodes(1);
            }
            else {
                exactSizeIfKnown = -1L;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return exactSizeIfKnown;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    final <P_IN, S extends Sink<E_OUT>> S wrapAndCopyInto(final S n, final Spliterator<P_IN> spliterator) {
        try {
            BytecodeManager.incBytecodes(4);
            final Sink<E_OUT> sink = Objects.requireNonNull(n);
            BytecodeManager.incBytecodes(2);
            final Sink<Object> wrapSink = (Sink<Object>)this.wrapSink(sink);
            BytecodeManager.incBytecodes(2);
            this.copyInto((Sink<P_IN>)wrapSink, spliterator);
            BytecodeManager.incBytecodes(2);
            return n;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    final <P_IN> void copyInto(final Sink<P_IN> sink, final Spliterator<P_IN> spliterator) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(sink);
            BytecodeManager.incBytecodes(1);
            final StreamOpFlag short_CIRCUIT = StreamOpFlag.SHORT_CIRCUIT;
            BytecodeManager.incBytecodes(3);
            final int streamAndOpFlags = this.getStreamAndOpFlags();
            BytecodeManager.incBytecodes(1);
            final boolean known = short_CIRCUIT.isKnown(streamAndOpFlags);
            BytecodeManager.incBytecodes(1);
            if (!known) {
                BytecodeManager.incBytecodes(3);
                final long exactSizeIfKnown = spliterator.getExactSizeIfKnown();
                BytecodeManager.incBytecodes(1);
                sink.begin(exactSizeIfKnown);
                BytecodeManager.incBytecodes(3);
                spliterator.forEachRemaining(sink);
                BytecodeManager.incBytecodes(2);
                sink.end();
                BytecodeManager.incBytecodes(1);
            }
            else {
                BytecodeManager.incBytecodes(4);
                this.copyIntoWithCancel((Sink<Object>)sink, (Spliterator<Object>)spliterator);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    final <P_IN> void copyIntoWithCancel(final Sink<P_IN> sink, final Spliterator<P_IN> spliterator) {
        try {
            AbstractPipeline previousStage = this;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int depth = previousStage.depth;
                BytecodeManager.incBytecodes(3);
                if (depth <= 0) {
                    break;
                }
                previousStage = previousStage.previousStage;
                BytecodeManager.incBytecodes(4);
            }
            BytecodeManager.incBytecodes(3);
            final long exactSizeIfKnown = spliterator.getExactSizeIfKnown();
            BytecodeManager.incBytecodes(1);
            sink.begin(exactSizeIfKnown);
            final AbstractPipeline<E_IN, P_IN, S> abstractPipeline = (AbstractPipeline<E_IN, P_IN, S>)previousStage;
            BytecodeManager.incBytecodes(4);
            abstractPipeline.forEachWithCancel(spliterator, sink);
            BytecodeManager.incBytecodes(2);
            sink.end();
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    final int getStreamAndOpFlags() {
        try {
            final int combinedFlags = this.combinedFlags;
            BytecodeManager.incBytecodes(3);
            return combinedFlags;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final boolean isOrdered() {
        try {
            final StreamOpFlag ordered = StreamOpFlag.ORDERED;
            final int combinedFlags = this.combinedFlags;
            BytecodeManager.incBytecodes(4);
            final boolean known = ordered.isKnown(combinedFlags);
            BytecodeManager.incBytecodes(1);
            return known;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    final <P_IN> Sink<P_IN> wrapSink(final Sink<E_OUT> p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             2
        //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     6: invokestatic    instrumented/java/util/Objects.requireNonNull:(Ljava/lang/Object;)Ljava/lang/Object;
        //     9: pop            
        //    10: ldc             1
        //    12: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    15: aload_0        
        //    16: astore_2       
        //    17: ldc             2
        //    19: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    22: aload_2        
        //    23: getfield        instrumented/java/util/stream/AbstractPipeline.depth:I
        //    26: ldc             3
        //    28: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    31: ifle            70
        //    34: aload_2        
        //    35: aload_2        
        //    36: getfield        instrumented/java/util/stream/AbstractPipeline.previousStage:Linstrumented/java/util/stream/AbstractPipeline;
        //    39: getfield        instrumented/java/util/stream/AbstractPipeline.combinedFlags:I
        //    42: aload_1        
        //    43: ldc             6
        //    45: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    48: invokevirtual   instrumented/java/util/stream/AbstractPipeline.opWrapSink:(ILinstrumented/java/util/stream/Sink;)Linstrumented/java/util/stream/Sink;
        //    51: astore_1       
        //    52: ldc             1
        //    54: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    57: aload_2        
        //    58: getfield        instrumented/java/util/stream/AbstractPipeline.previousStage:Linstrumented/java/util/stream/AbstractPipeline;
        //    61: astore_2       
        //    62: ldc             4
        //    64: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    67: goto            22
        //    70: aload_1        
        //    71: ldc             2
        //    73: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    76: areturn        
        //    77: athrow         
        //    Signature:
        //  <P_IN:Ljava/lang/Object;>(Linstrumented/java/util/stream/Sink<TE_OUT;>;)Linstrumented/java/util/stream/Sink<TP_IN;>;
        //    StackMapTable: 00 03 FC 00 16 07 00 02 FA 00 2F FF 00 06 00 00 00 01 07 00 56
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  0      77     77     78     Any
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
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:778)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferCall(TypeAnalysis.java:2669)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1029)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:803)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:770)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:881)
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
    final <P_IN> Spliterator<E_OUT> wrapSpliterator(final Spliterator<P_IN> spliterator) {
        try {
            final int depth = this.depth;
            BytecodeManager.incBytecodes(3);
            if (depth == 0) {
                BytecodeManager.incBytecodes(2);
                return (Spliterator<E_OUT>)spliterator;
            }
            final Supplier<Spliterator<E_OUT>> supplier = () -> {
                try {
                    BytecodeManager.incBytecodes(2);
                    return (Spliterator<E_OUT>)spliterator;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            BytecodeManager.incBytecodes(5);
            final boolean parallel = this.isParallel();
            BytecodeManager.incBytecodes(1);
            final Spliterator<E_OUT> wrap = this.wrap(this, supplier, parallel);
            BytecodeManager.incBytecodes(1);
            return wrap;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    final <P_IN> Node<E_OUT> evaluate(final Spliterator<P_IN> spliterator, final boolean b, final IntFunction<E_OUT[]> intFunction) {
        try {
            BytecodeManager.incBytecodes(2);
            final boolean parallel = this.isParallel();
            BytecodeManager.incBytecodes(1);
            if (parallel) {
                BytecodeManager.incBytecodes(6);
                final Node<E_OUT> evaluateToNode = this.evaluateToNode(this, spliterator, b, intFunction);
                BytecodeManager.incBytecodes(1);
                return evaluateToNode;
            }
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
            final long exactOutputSizeIfKnown = this.exactOutputSizeIfKnown(spliterator);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
            final Node.Builder<E_OUT> nodeBuilder = this.makeNodeBuilder(exactOutputSizeIfKnown, intFunction);
            BytecodeManager.incBytecodes(1);
            final Node.Builder<E_OUT> builder = nodeBuilder;
            BytecodeManager.incBytecodes(4);
            final Node.Builder<E_OUT> builder2 = this.wrapAndCopyInto(builder, spliterator);
            BytecodeManager.incBytecodes(2);
            final Node<E_OUT> build = builder2.build();
            BytecodeManager.incBytecodes(1);
            return build;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    abstract StreamShape getOutputShape();
    
    abstract <P_IN> Node<E_OUT> evaluateToNode(final PipelineHelper<E_OUT> p0, final Spliterator<P_IN> p1, final boolean p2, final IntFunction<E_OUT[]> p3);
    
    abstract <P_IN> Spliterator<E_OUT> wrap(final PipelineHelper<E_OUT> p0, final Supplier<Spliterator<P_IN>> p1, final boolean p2);
    
    abstract Spliterator<E_OUT> lazySpliterator(final Supplier<? extends Spliterator<E_OUT>> p0);
    
    abstract void forEachWithCancel(final Spliterator<E_OUT> p0, final Sink<E_OUT> p1);
    
    @Override
    abstract Node.Builder<E_OUT> makeNodeBuilder(final long p0, final IntFunction<E_OUT[]> p1);
    
    abstract boolean opIsStateful();
    
    abstract Sink<E_IN> opWrapSink(final int p0, final Sink<E_OUT> p1);
    
     <P_IN> Node<E_OUT> opEvaluateParallel(final PipelineHelper<E_OUT> pipelineHelper, final Spliterator<P_IN> spliterator, final IntFunction<E_OUT[]> intFunction) {
        try {
            final String message = "Parallel evaluation is not supported";
            BytecodeManager.incBytecodes(4);
            final UnsupportedOperationException ex = new UnsupportedOperationException(message);
            BytecodeManager.incBytecodes(1);
            throw ex;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
     <P_IN> Spliterator<E_OUT> opEvaluateParallelLazy(final PipelineHelper<E_OUT> pipelineHelper, final Spliterator<P_IN> spliterator) {
        try {
            Object[] array;
            final IntFunction<Object> intFunction = (IntFunction<Object>)(n -> {
                try {
                    array = new Object[n];
                    BytecodeManager.incBytecodes(3);
                    return array;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            });
            BytecodeManager.incBytecodes(4);
            final Node<E_OUT> opEvaluateParallel = this.opEvaluateParallel(pipelineHelper, spliterator, (IntFunction<E_OUT[]>)intFunction);
            BytecodeManager.incBytecodes(1);
            final Spliterator<E_OUT> spliterator2 = opEvaluateParallel.spliterator();
            BytecodeManager.incBytecodes(1);
            return spliterator2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static {
        try {
            final Class<AbstractPipeline> clazz = AbstractPipeline.class;
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
