// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.stream;

import instrumented.java.util.function.IntFunction;
import instrumented.java.util.concurrent.ConcurrentHashMap;
import instrumented.java.util.concurrent.CountedCompleter;
import instrumented.java.util.Spliterator;
import instrumented.java.util.function.DoubleConsumer;
import instrumented.java.util.function.LongConsumer;
import instrumented.java.util.function.IntConsumer;
import instrumented.java.util.Objects;
import instrumented.java.util.function.Consumer;
import aic2021.engine.BytecodeManager;

final class ForEachOps
{
    private ForEachOps() {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T> TerminalOp<T, Void> makeRef(final Consumer<? super T> consumer, final boolean b) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(consumer);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(5);
            final ForEachOp.OfRef<T> ofRef = new ForEachOp.OfRef<T>(consumer, b);
            BytecodeManager.incBytecodes(1);
            return ofRef;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static TerminalOp<Integer, Void> makeInt(final IntConsumer intConsumer, final boolean b) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(intConsumer);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(5);
            final ForEachOp.OfInt ofInt = new ForEachOp.OfInt(intConsumer, b);
            BytecodeManager.incBytecodes(1);
            return ofInt;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static TerminalOp<Long, Void> makeLong(final LongConsumer longConsumer, final boolean b) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(longConsumer);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(5);
            final ForEachOp.OfLong ofLong = new ForEachOp.OfLong(longConsumer, b);
            BytecodeManager.incBytecodes(1);
            return ofLong;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static TerminalOp<Double, Void> makeDouble(final DoubleConsumer doubleConsumer, final boolean b) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(doubleConsumer);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(5);
            final ForEachOp.OfDouble ofDouble = new ForEachOp.OfDouble(doubleConsumer, b);
            BytecodeManager.incBytecodes(1);
            return ofDouble;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    abstract static class ForEachOp<T> implements TerminalOp<T, Void>, TerminalSink<T, Void>
    {
        private final boolean ordered;
        
        protected ForEachOp(final boolean ordered) {
            try {
                BytecodeManager.incBytecodes(2);
                this.ordered = ordered;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int getOpFlags() {
            try {
                final boolean ordered = this.ordered;
                BytecodeManager.incBytecodes(3);
                int not_ORDERED;
                if (ordered) {
                    not_ORDERED = 0;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    not_ORDERED = StreamOpFlag.NOT_ORDERED;
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
                return not_ORDERED;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public <S> Void evaluateSequential(final PipelineHelper<T> pipelineHelper, final Spliterator<S> spliterator) {
            try {
                BytecodeManager.incBytecodes(4);
                final ForEachOp forEachOp = pipelineHelper.wrapAndCopyInto(this, spliterator);
                BytecodeManager.incBytecodes(2);
                final Void value = forEachOp.get();
                BytecodeManager.incBytecodes(1);
                return value;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public <S> Void evaluateParallel(final PipelineHelper<T> pipelineHelper, final Spliterator<S> spliterator) {
            try {
                final boolean ordered = this.ordered;
                BytecodeManager.incBytecodes(3);
                if (ordered) {
                    BytecodeManager.incBytecodes(6);
                    final ForEachOrderedTask forEachOrderedTask = new ForEachOrderedTask((PipelineHelper<T>)pipelineHelper, (Spliterator<S>)spliterator, (Sink<T>)this);
                    BytecodeManager.incBytecodes(1);
                    forEachOrderedTask.invoke();
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    BytecodeManager.incBytecodes(7);
                    final Sink<Object> wrapSink = pipelineHelper.wrapSink((Sink<T>)this);
                    BytecodeManager.incBytecodes(1);
                    final ForEachTask forEachTask = new ForEachTask(pipelineHelper, spliterator, wrapSink);
                    BytecodeManager.incBytecodes(1);
                    forEachTask.invoke();
                    BytecodeManager.incBytecodes(1);
                }
                final Void void1 = null;
                BytecodeManager.incBytecodes(2);
                return void1;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Void get() {
            try {
                final Void void1 = null;
                BytecodeManager.incBytecodes(2);
                return void1;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static final class OfRef<T> extends ForEachOp<T>
        {
            final Consumer<? super T> consumer;
            
            OfRef(final Consumer<? super T> consumer, final boolean b) {
                try {
                    BytecodeManager.incBytecodes(3);
                    super(b);
                    this.consumer = consumer;
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public void accept(final T t) {
                try {
                    final Consumer<? super T> consumer = this.consumer;
                    BytecodeManager.incBytecodes(4);
                    consumer.accept(t);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
        
        static final class OfInt extends ForEachOp<Integer> implements Sink.OfInt
        {
            final IntConsumer consumer;
            
            OfInt(final IntConsumer consumer, final boolean b) {
                try {
                    BytecodeManager.incBytecodes(3);
                    super(b);
                    this.consumer = consumer;
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public StreamShape inputShape() {
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
            public void accept(final int n) {
                try {
                    final IntConsumer consumer = this.consumer;
                    BytecodeManager.incBytecodes(4);
                    consumer.accept(n);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
        
        static final class OfLong extends ForEachOp<Long> implements Sink.OfLong
        {
            final LongConsumer consumer;
            
            OfLong(final LongConsumer consumer, final boolean b) {
                try {
                    BytecodeManager.incBytecodes(3);
                    super(b);
                    this.consumer = consumer;
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public StreamShape inputShape() {
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
            public void accept(final long n) {
                try {
                    final LongConsumer consumer = this.consumer;
                    BytecodeManager.incBytecodes(4);
                    consumer.accept(n);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
        
        static final class OfDouble extends ForEachOp<Double> implements Sink.OfDouble
        {
            final DoubleConsumer consumer;
            
            OfDouble(final DoubleConsumer consumer, final boolean b) {
                try {
                    BytecodeManager.incBytecodes(3);
                    super(b);
                    this.consumer = consumer;
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public StreamShape inputShape() {
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
            public void accept(final double n) {
                try {
                    final DoubleConsumer consumer = this.consumer;
                    BytecodeManager.incBytecodes(4);
                    consumer.accept(n);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
    }
    
    static final class ForEachTask<S, T> extends CountedCompleter<Void>
    {
        private Spliterator<S> spliterator;
        private final Sink<S> sink;
        private final PipelineHelper<T> helper;
        private long targetSize;
        
        ForEachTask(final PipelineHelper<T> helper, final Spliterator<S> spliterator, final Sink<S> sink) {
            try {
                final CountedCompleter countedCompleter = null;
                BytecodeManager.incBytecodes(3);
                super(countedCompleter);
                this.sink = sink;
                BytecodeManager.incBytecodes(3);
                this.helper = helper;
                BytecodeManager.incBytecodes(3);
                this.spliterator = spliterator;
                BytecodeManager.incBytecodes(3);
                this.targetSize = 0L;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        ForEachTask(final ForEachTask<S, T> forEachTask, final Spliterator<S> spliterator) {
            try {
                BytecodeManager.incBytecodes(3);
                super(forEachTask);
                this.spliterator = spliterator;
                BytecodeManager.incBytecodes(3);
                this.sink = forEachTask.sink;
                BytecodeManager.incBytecodes(4);
                this.targetSize = forEachTask.targetSize;
                BytecodeManager.incBytecodes(4);
                this.helper = forEachTask.helper;
                BytecodeManager.incBytecodes(4);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void compute() {
            try {
                Spliterator<S> spliterator = this.spliterator;
                BytecodeManager.incBytecodes(3);
                final Spliterator<S> spliterator2 = spliterator;
                BytecodeManager.incBytecodes(2);
                long n = spliterator2.estimateSize();
                BytecodeManager.incBytecodes(1);
                long targetSize;
                final long n2 = lcmp(targetSize = this.targetSize, 0L);
                BytecodeManager.incBytecodes(7);
                if (n2 == 0) {
                    final long n3 = n;
                    BytecodeManager.incBytecodes(3);
                    targetSize = (this.targetSize = AbstractTask.suggestTargetSize(n3));
                    BytecodeManager.incBytecodes(3);
                }
                final StreamOpFlag short_CIRCUIT = StreamOpFlag.SHORT_CIRCUIT;
                final PipelineHelper<T> helper = this.helper;
                BytecodeManager.incBytecodes(4);
                final int streamAndOpFlags = helper.getStreamAndOpFlags();
                BytecodeManager.incBytecodes(1);
                final boolean known = short_CIRCUIT.isKnown(streamAndOpFlags);
                BytecodeManager.incBytecodes(1);
                boolean b = false;
                BytecodeManager.incBytecodes(2);
                final Sink<S> sink = this.sink;
                BytecodeManager.incBytecodes(3);
                ForEachTask<Object, Object> forEachTask = (ForEachTask<Object, Object>)this;
                BytecodeManager.incBytecodes(2);
                Label_0351: {
                    while (true) {
                        final boolean b2 = known;
                        BytecodeManager.incBytecodes(2);
                        if (b2) {
                            final Sink<S> sink2 = sink;
                            BytecodeManager.incBytecodes(2);
                            final boolean cancellationRequested = sink2.cancellationRequested();
                            BytecodeManager.incBytecodes(1);
                            if (cancellationRequested) {
                                break Label_0351;
                            }
                        }
                        final long n4 = lcmp(n, targetSize);
                        BytecodeManager.incBytecodes(4);
                        if (n4 <= 0) {
                            break;
                        }
                        final Spliterator<S> spliterator3 = spliterator;
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                        final Spliterator<S> trySplit;
                        final Spliterator<S> spliterator4 = trySplit = spliterator3.trySplit();
                        BytecodeManager.incBytecodes(3);
                        if (spliterator4 == null) {
                            break;
                        }
                        final ForEachTask<Object, Object> forEachTask2 = forEachTask;
                        final Spliterator<S> spliterator5 = trySplit;
                        BytecodeManager.incBytecodes(5);
                        final ForEachTask forEachTask3 = new ForEachTask<Object, Object>(forEachTask2, (Spliterator<Object>)spliterator5);
                        BytecodeManager.incBytecodes(1);
                        final ForEachTask<Object, Object> forEachTask4 = forEachTask;
                        final int n5 = 1;
                        BytecodeManager.incBytecodes(3);
                        forEachTask4.addToPendingCount(n5);
                        final boolean b3 = b;
                        BytecodeManager.incBytecodes(2);
                        ForEachTask<Object, Object> forEachTask5;
                        if (b3) {
                            b = false;
                            BytecodeManager.incBytecodes(2);
                            spliterator = trySplit;
                            BytecodeManager.incBytecodes(2);
                            forEachTask5 = forEachTask;
                            BytecodeManager.incBytecodes(2);
                            forEachTask = (ForEachTask<Object, Object>)forEachTask3;
                            BytecodeManager.incBytecodes(3);
                        }
                        else {
                            b = true;
                            BytecodeManager.incBytecodes(2);
                            forEachTask5 = (ForEachTask<Object, Object>)forEachTask3;
                            BytecodeManager.incBytecodes(2);
                        }
                        final ForEachTask<Object, Object> forEachTask6 = forEachTask5;
                        BytecodeManager.incBytecodes(2);
                        forEachTask6.fork();
                        BytecodeManager.incBytecodes(1);
                        final Spliterator<S> spliterator6 = spliterator;
                        BytecodeManager.incBytecodes(2);
                        n = spliterator6.estimateSize();
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                    }
                    final PipelineHelper<Object> helper2 = forEachTask.helper;
                    final Sink<S> sink3 = sink;
                    final Spliterator<S> spliterator7 = spliterator;
                    BytecodeManager.incBytecodes(5);
                    helper2.copyInto(sink3, spliterator7);
                    BytecodeManager.incBytecodes(1);
                }
                forEachTask.spliterator = null;
                BytecodeManager.incBytecodes(3);
                final ForEachTask<Object, Object> forEachTask7 = forEachTask;
                BytecodeManager.incBytecodes(2);
                forEachTask7.propagateCompletion();
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class ForEachOrderedTask<S, T> extends CountedCompleter<Void>
    {
        private final PipelineHelper<T> helper;
        private Spliterator<S> spliterator;
        private final long targetSize;
        private final ConcurrentHashMap<ForEachOrderedTask<S, T>, ForEachOrderedTask<S, T>> completionMap;
        private final Sink<T> action;
        private final ForEachOrderedTask<S, T> leftPredecessor;
        private Node<T> node;
        
        protected ForEachOrderedTask(final PipelineHelper<T> helper, final Spliterator<S> spliterator, final Sink<T> action) {
            try {
                final CountedCompleter countedCompleter = null;
                BytecodeManager.incBytecodes(3);
                super(countedCompleter);
                this.helper = helper;
                BytecodeManager.incBytecodes(3);
                this.spliterator = spliterator;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(3);
                final long estimateSize = spliterator.estimateSize();
                BytecodeManager.incBytecodes(1);
                this.targetSize = AbstractTask.suggestTargetSize(estimateSize);
                BytecodeManager.incBytecodes(1);
                final int a = 16;
                final int b = AbstractTask.LEAF_TARGET << 1;
                BytecodeManager.incBytecodes(8);
                final int max = Math.max(a, b);
                BytecodeManager.incBytecodes(1);
                this.completionMap = new ConcurrentHashMap<ForEachOrderedTask<S, T>, ForEachOrderedTask<S, T>>(max);
                BytecodeManager.incBytecodes(1);
                this.action = action;
                BytecodeManager.incBytecodes(3);
                this.leftPredecessor = null;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        ForEachOrderedTask(final ForEachOrderedTask<S, T> forEachOrderedTask, final Spliterator<S> spliterator, final ForEachOrderedTask<S, T> leftPredecessor) {
            try {
                BytecodeManager.incBytecodes(3);
                super(forEachOrderedTask);
                this.helper = forEachOrderedTask.helper;
                BytecodeManager.incBytecodes(4);
                this.spliterator = spliterator;
                BytecodeManager.incBytecodes(3);
                this.targetSize = forEachOrderedTask.targetSize;
                BytecodeManager.incBytecodes(4);
                this.completionMap = forEachOrderedTask.completionMap;
                BytecodeManager.incBytecodes(4);
                this.action = forEachOrderedTask.action;
                BytecodeManager.incBytecodes(4);
                this.leftPredecessor = leftPredecessor;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final void compute() {
            try {
                BytecodeManager.incBytecodes(2);
                doCompute((ForEachOrderedTask<Object, Object>)this);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private static <S, T> void doCompute(ForEachOrderedTask<S, T> forEachOrderedTask) {
            try {
                Object spliterator = forEachOrderedTask.spliterator;
                BytecodeManager.incBytecodes(3);
                final long targetSize = forEachOrderedTask.targetSize;
                BytecodeManager.incBytecodes(3);
                boolean b = false;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final Object o = spliterator;
                    BytecodeManager.incBytecodes(2);
                    final long n2 = lcmp(((Spliterator)o).estimateSize(), targetSize);
                    BytecodeManager.incBytecodes(3);
                    if (n2 <= 0) {
                        break;
                    }
                    final Object o2 = spliterator;
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    final Spliterator<Object> trySplit;
                    final Spliterator<Object> spliterator2 = trySplit = ((Spliterator<Object>)o2).trySplit();
                    BytecodeManager.incBytecodes(3);
                    if (spliterator2 == null) {
                        break;
                    }
                    final ForEachOrderedTask forEachOrderedTask2 = forEachOrderedTask;
                    final Spliterator<Object> spliterator3 = trySplit;
                    final ForEachOrderedTask<S, T> leftPredecessor = forEachOrderedTask.leftPredecessor;
                    BytecodeManager.incBytecodes(7);
                    final ForEachOrderedTask forEachOrderedTask3 = new ForEachOrderedTask<Object, Object>((ForEachOrderedTask<Object, Object>)forEachOrderedTask2, spliterator3, (ForEachOrderedTask<Object, Object>)leftPredecessor);
                    BytecodeManager.incBytecodes(1);
                    final ForEachOrderedTask forEachOrderedTask4 = forEachOrderedTask;
                    final Object o3 = spliterator;
                    final ForEachOrderedTask<Object, Object> forEachOrderedTask5 = (ForEachOrderedTask<Object, Object>)forEachOrderedTask3;
                    BytecodeManager.incBytecodes(6);
                    final ForEachOrderedTask forEachOrderedTask6 = new ForEachOrderedTask<Object, Object>((ForEachOrderedTask<Object, Object>)forEachOrderedTask4, (Spliterator<Object>)o3, forEachOrderedTask5);
                    BytecodeManager.incBytecodes(1);
                    final ForEachOrderedTask forEachOrderedTask7 = forEachOrderedTask;
                    final int n3 = 1;
                    BytecodeManager.incBytecodes(3);
                    forEachOrderedTask7.addToPendingCount(n3);
                    final ForEachOrderedTask forEachOrderedTask8 = forEachOrderedTask6;
                    final int n4 = 1;
                    BytecodeManager.incBytecodes(3);
                    forEachOrderedTask8.addToPendingCount(n4);
                    final ConcurrentHashMap<ForEachOrderedTask<S, T>, ForEachOrderedTask<S, T>> completionMap = forEachOrderedTask.completionMap;
                    final ForEachOrderedTask<S, T> forEachOrderedTask9 = forEachOrderedTask3;
                    final ForEachOrderedTask forEachOrderedTask10 = forEachOrderedTask6;
                    BytecodeManager.incBytecodes(5);
                    completionMap.put(forEachOrderedTask9, forEachOrderedTask10);
                    BytecodeManager.incBytecodes(1);
                    final ForEachOrderedTask<S, T> leftPredecessor2 = forEachOrderedTask.leftPredecessor;
                    BytecodeManager.incBytecodes(3);
                    if (leftPredecessor2 != null) {
                        final ForEachOrderedTask<Object, Object> forEachOrderedTask11 = (ForEachOrderedTask<Object, Object>)forEachOrderedTask3;
                        final int n5 = 1;
                        BytecodeManager.incBytecodes(3);
                        forEachOrderedTask11.addToPendingCount(n5);
                        final ConcurrentHashMap<ForEachOrderedTask<S, T>, ForEachOrderedTask<S, T>> completionMap2 = forEachOrderedTask.completionMap;
                        final ForEachOrderedTask<S, T> leftPredecessor3 = forEachOrderedTask.leftPredecessor;
                        final ForEachOrderedTask forEachOrderedTask12 = forEachOrderedTask;
                        final ForEachOrderedTask<S, T> forEachOrderedTask13 = forEachOrderedTask3;
                        BytecodeManager.incBytecodes(7);
                        final boolean replace = completionMap2.replace(leftPredecessor3, forEachOrderedTask12, forEachOrderedTask13);
                        BytecodeManager.incBytecodes(1);
                        if (replace) {
                            final ForEachOrderedTask forEachOrderedTask14 = forEachOrderedTask;
                            final int n6 = -1;
                            BytecodeManager.incBytecodes(3);
                            forEachOrderedTask14.addToPendingCount(n6);
                            BytecodeManager.incBytecodes(1);
                        }
                        else {
                            final ForEachOrderedTask<Object, Object> forEachOrderedTask15 = (ForEachOrderedTask<Object, Object>)forEachOrderedTask3;
                            final int n7 = -1;
                            BytecodeManager.incBytecodes(3);
                            forEachOrderedTask15.addToPendingCount(n7);
                        }
                    }
                    final boolean b2 = b;
                    BytecodeManager.incBytecodes(2);
                    ForEachOrderedTask<Object, Object> forEachOrderedTask16;
                    if (b2) {
                        b = false;
                        BytecodeManager.incBytecodes(2);
                        spliterator = trySplit;
                        BytecodeManager.incBytecodes(2);
                        forEachOrderedTask = forEachOrderedTask3;
                        BytecodeManager.incBytecodes(2);
                        forEachOrderedTask16 = (ForEachOrderedTask<Object, Object>)forEachOrderedTask6;
                        BytecodeManager.incBytecodes(3);
                    }
                    else {
                        b = true;
                        BytecodeManager.incBytecodes(2);
                        forEachOrderedTask = forEachOrderedTask6;
                        BytecodeManager.incBytecodes(2);
                        forEachOrderedTask16 = (ForEachOrderedTask<Object, Object>)forEachOrderedTask3;
                        BytecodeManager.incBytecodes(2);
                    }
                    final ForEachOrderedTask<Object, Object> forEachOrderedTask17 = forEachOrderedTask16;
                    BytecodeManager.incBytecodes(2);
                    forEachOrderedTask17.fork();
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                }
                final ForEachOrderedTask forEachOrderedTask18 = forEachOrderedTask;
                BytecodeManager.incBytecodes(2);
                final int pendingCount = forEachOrderedTask18.getPendingCount();
                BytecodeManager.incBytecodes(1);
                if (pendingCount > 0) {
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
                    BytecodeManager.incBytecodes(1);
                    final PipelineHelper<T> helper = forEachOrderedTask.helper;
                    final PipelineHelper<T> helper2 = forEachOrderedTask.helper;
                    final Object o4 = spliterator;
                    BytecodeManager.incBytecodes(5);
                    BytecodeManager.incBytecodes(1);
                    final long exactOutputSizeIfKnown = helper2.exactOutputSizeIfKnown((Spliterator<Object>)o4);
                    final IntFunction<T[]> intFunction2 = (IntFunction<T[]>)intFunction;
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    final Node.Builder<T> nodeBuilder = helper.makeNodeBuilder(exactOutputSizeIfKnown, intFunction2);
                    BytecodeManager.incBytecodes(1);
                    final ForEachOrderedTask forEachOrderedTask19 = forEachOrderedTask;
                    final PipelineHelper<T> helper3 = forEachOrderedTask.helper;
                    final Node.Builder<T> builder = nodeBuilder;
                    final Object o5 = spliterator;
                    BytecodeManager.incBytecodes(6);
                    final Node.Builder<T> builder2 = helper3.wrapAndCopyInto(builder, (Spliterator<Object>)o5);
                    BytecodeManager.incBytecodes(2);
                    forEachOrderedTask19.node = builder2.build();
                    BytecodeManager.incBytecodes(1);
                    forEachOrderedTask.spliterator = null;
                    BytecodeManager.incBytecodes(3);
                }
                final ForEachOrderedTask forEachOrderedTask20 = forEachOrderedTask;
                BytecodeManager.incBytecodes(2);
                forEachOrderedTask20.tryComplete();
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void onCompletion(final CountedCompleter<?> countedCompleter) {
            try {
                final Node<T> node = this.node;
                BytecodeManager.incBytecodes(3);
                if (node != null) {
                    final Node<T> node2 = this.node;
                    final Sink<T> action = this.action;
                    BytecodeManager.incBytecodes(5);
                    node2.forEach(action);
                    this.node = null;
                    BytecodeManager.incBytecodes(4);
                }
                else {
                    final Spliterator<S> spliterator = this.spliterator;
                    BytecodeManager.incBytecodes(3);
                    if (spliterator != null) {
                        final PipelineHelper<T> helper = this.helper;
                        final Sink<T> action2 = this.action;
                        final Spliterator<S> spliterator2 = this.spliterator;
                        BytecodeManager.incBytecodes(7);
                        helper.wrapAndCopyInto(action2, spliterator2);
                        BytecodeManager.incBytecodes(1);
                        this.spliterator = null;
                        BytecodeManager.incBytecodes(3);
                    }
                }
                final ConcurrentHashMap<ForEachOrderedTask<S, T>, ForEachOrderedTask<S, T>> completionMap = this.completionMap;
                BytecodeManager.incBytecodes(4);
                final ForEachOrderedTask<S, T> forEachOrderedTask = completionMap.remove(this);
                BytecodeManager.incBytecodes(2);
                final ForEachOrderedTask<S, T> forEachOrderedTask2 = forEachOrderedTask;
                BytecodeManager.incBytecodes(2);
                if (forEachOrderedTask2 != null) {
                    final ForEachOrderedTask<S, T> forEachOrderedTask3 = forEachOrderedTask;
                    BytecodeManager.incBytecodes(2);
                    forEachOrderedTask3.tryComplete();
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
}
