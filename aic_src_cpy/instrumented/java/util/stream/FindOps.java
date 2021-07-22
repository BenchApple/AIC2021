// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.stream;

import instrumented.java.util.concurrent.CountedCompleter;
import instrumented.java.util.Spliterator;
import instrumented.java.util.OptionalDouble;
import instrumented.java.util.OptionalLong;
import instrumented.java.util.OptionalInt;
import instrumented.java.util.function.Supplier;
import instrumented.java.util.function.Predicate;
import instrumented.java.util.Optional;
import aic2021.engine.BytecodeManager;

final class FindOps
{
    private FindOps() {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T> TerminalOp<T, Optional<T>> makeRef(final boolean b) {
        try {
            final StreamShape reference = StreamShape.REFERENCE;
            BytecodeManager.incBytecodes(5);
            final Optional<T> empty = Optional.empty();
            final Predicate<Optional<T>> predicate = Optional::isPresent;
            final Supplier<FindSink.OfRef> supplier = FindSink.OfRef::new;
            BytecodeManager.incBytecodes(1);
            final FindOp findOp = new FindOp<T, Optional<T>>(b, reference, empty, predicate, supplier);
            BytecodeManager.incBytecodes(1);
            return (TerminalOp<T, Optional<T>>)findOp;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static TerminalOp<Integer, OptionalInt> makeInt(final boolean b) {
        try {
            final StreamShape int_VALUE = StreamShape.INT_VALUE;
            BytecodeManager.incBytecodes(5);
            final OptionalInt empty = OptionalInt.empty();
            final Predicate<OptionalInt> predicate = OptionalInt::isPresent;
            final Supplier<FindSink.OfInt> supplier = FindSink.OfInt::new;
            BytecodeManager.incBytecodes(1);
            final FindOp findOp = new FindOp<Integer, OptionalInt>(b, int_VALUE, empty, predicate, supplier);
            BytecodeManager.incBytecodes(1);
            return (TerminalOp<Integer, OptionalInt>)findOp;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static TerminalOp<Long, OptionalLong> makeLong(final boolean b) {
        try {
            final StreamShape long_VALUE = StreamShape.LONG_VALUE;
            BytecodeManager.incBytecodes(5);
            final OptionalLong empty = OptionalLong.empty();
            final Predicate<OptionalLong> predicate = OptionalLong::isPresent;
            final Supplier<FindSink.OfLong> supplier = FindSink.OfLong::new;
            BytecodeManager.incBytecodes(1);
            final FindOp findOp = new FindOp<Long, OptionalLong>(b, long_VALUE, empty, predicate, supplier);
            BytecodeManager.incBytecodes(1);
            return (TerminalOp<Long, OptionalLong>)findOp;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static TerminalOp<Double, OptionalDouble> makeDouble(final boolean b) {
        try {
            final StreamShape double_VALUE = StreamShape.DOUBLE_VALUE;
            BytecodeManager.incBytecodes(5);
            final OptionalDouble empty = OptionalDouble.empty();
            final Predicate<OptionalDouble> predicate = OptionalDouble::isPresent;
            final Supplier<FindSink.OfDouble> supplier = FindSink.OfDouble::new;
            BytecodeManager.incBytecodes(1);
            final FindOp findOp = new FindOp<Double, OptionalDouble>(b, double_VALUE, empty, predicate, supplier);
            BytecodeManager.incBytecodes(1);
            return (TerminalOp<Double, OptionalDouble>)findOp;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static final class FindOp<T, O> implements TerminalOp<T, O>
    {
        private final StreamShape shape;
        final boolean mustFindFirst;
        final O emptyValue;
        final Predicate<O> presentPredicate;
        final Supplier<TerminalSink<T, O>> sinkSupplier;
        
        FindOp(final boolean mustFindFirst, final StreamShape shape, final O emptyValue, final Predicate<O> presentPredicate, final Supplier<TerminalSink<T, O>> sinkSupplier) {
            try {
                BytecodeManager.incBytecodes(2);
                this.mustFindFirst = mustFindFirst;
                BytecodeManager.incBytecodes(3);
                this.shape = shape;
                BytecodeManager.incBytecodes(3);
                this.emptyValue = emptyValue;
                BytecodeManager.incBytecodes(3);
                this.presentPredicate = presentPredicate;
                BytecodeManager.incBytecodes(3);
                this.sinkSupplier = sinkSupplier;
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
                final int is_SHORT_CIRCUIT = StreamOpFlag.IS_SHORT_CIRCUIT;
                final boolean mustFindFirst = this.mustFindFirst;
                BytecodeManager.incBytecodes(4);
                int not_ORDERED;
                if (mustFindFirst) {
                    not_ORDERED = 0;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    not_ORDERED = StreamOpFlag.NOT_ORDERED;
                    BytecodeManager.incBytecodes(1);
                }
                final int n = is_SHORT_CIRCUIT | not_ORDERED;
                BytecodeManager.incBytecodes(2);
                return n;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public StreamShape inputShape() {
            try {
                final StreamShape shape = this.shape;
                BytecodeManager.incBytecodes(3);
                return shape;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public <S> O evaluateSequential(final PipelineHelper<T> pipelineHelper, final Spliterator<S> spliterator) {
            try {
                final Supplier<TerminalSink<T, O>> sinkSupplier = this.sinkSupplier;
                BytecodeManager.incBytecodes(4);
                final TerminalSink<T, O> terminalSink = sinkSupplier.get();
                BytecodeManager.incBytecodes(3);
                final TerminalSink<?, Object> terminalSink2 = pipelineHelper.wrapAndCopyInto((TerminalSink<?, Object>)terminalSink, spliterator);
                BytecodeManager.incBytecodes(2);
                final O value = terminalSink2.get();
                BytecodeManager.incBytecodes(1);
                final O o = value;
                BytecodeManager.incBytecodes(2);
                O emptyValue;
                if (o != null) {
                    emptyValue = value;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    emptyValue = this.emptyValue;
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(1);
                return emptyValue;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public <P_IN> O evaluateParallel(final PipelineHelper<T> pipelineHelper, final Spliterator<P_IN> spliterator) {
            try {
                BytecodeManager.incBytecodes(6);
                final FindTask findTask = new FindTask(this, pipelineHelper, spliterator);
                BytecodeManager.incBytecodes(1);
                final O invoke = findTask.invoke();
                BytecodeManager.incBytecodes(1);
                return invoke;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private abstract static class FindSink<T, O> implements TerminalSink<T, O>
    {
        boolean hasValue;
        T value;
        
        FindSink() {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void accept(final T value) {
            try {
                final boolean hasValue = this.hasValue;
                BytecodeManager.incBytecodes(3);
                if (!hasValue) {
                    this.hasValue = true;
                    BytecodeManager.incBytecodes(3);
                    this.value = value;
                    BytecodeManager.incBytecodes(3);
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean cancellationRequested() {
            try {
                final boolean hasValue = this.hasValue;
                BytecodeManager.incBytecodes(3);
                return hasValue;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static final class OfRef<T> extends FindSink<T, Optional<T>>
        {
            OfRef() {
                try {
                    BytecodeManager.incBytecodes(2);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public Optional<T> get() {
                try {
                    final boolean hasValue = this.hasValue;
                    BytecodeManager.incBytecodes(3);
                    Optional<T> of;
                    if (hasValue) {
                        final T value = this.value;
                        BytecodeManager.incBytecodes(3);
                        of = Optional.of((T)value);
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        of = null;
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(1);
                    return of;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
        
        static final class OfInt extends FindSink<Integer, OptionalInt> implements Sink.OfInt
        {
            OfInt() {
                try {
                    BytecodeManager.incBytecodes(2);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public void accept(final int i) {
                try {
                    BytecodeManager.incBytecodes(3);
                    final Integer value = i;
                    BytecodeManager.incBytecodes(1);
                    ((FindSink<Integer, O>)this).accept(value);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public OptionalInt get() {
                try {
                    final boolean hasValue = this.hasValue;
                    BytecodeManager.incBytecodes(3);
                    OptionalInt of;
                    if (hasValue) {
                        final Integer n = (Integer)this.value;
                        BytecodeManager.incBytecodes(4);
                        final int intValue = n;
                        BytecodeManager.incBytecodes(1);
                        of = OptionalInt.of(intValue);
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        of = null;
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(1);
                    return of;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
        
        static final class OfLong extends FindSink<Long, OptionalLong> implements Sink.OfLong
        {
            OfLong() {
                try {
                    BytecodeManager.incBytecodes(2);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public void accept(final long l) {
                try {
                    BytecodeManager.incBytecodes(3);
                    final Long value = l;
                    BytecodeManager.incBytecodes(1);
                    ((FindSink<Long, O>)this).accept(value);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public OptionalLong get() {
                try {
                    final boolean hasValue = this.hasValue;
                    BytecodeManager.incBytecodes(3);
                    OptionalLong of;
                    if (hasValue) {
                        final Long n = (Long)this.value;
                        BytecodeManager.incBytecodes(4);
                        final long longValue = n;
                        BytecodeManager.incBytecodes(1);
                        of = OptionalLong.of(longValue);
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        of = null;
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(1);
                    return of;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
        
        static final class OfDouble extends FindSink<Double, OptionalDouble> implements Sink.OfDouble
        {
            OfDouble() {
                try {
                    BytecodeManager.incBytecodes(2);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public void accept(final double d) {
                try {
                    BytecodeManager.incBytecodes(3);
                    final Double value = d;
                    BytecodeManager.incBytecodes(1);
                    ((FindSink<Double, O>)this).accept(value);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public OptionalDouble get() {
                try {
                    final boolean hasValue = this.hasValue;
                    BytecodeManager.incBytecodes(3);
                    OptionalDouble of;
                    if (hasValue) {
                        final Double n = (Double)this.value;
                        BytecodeManager.incBytecodes(4);
                        final double doubleValue = n;
                        BytecodeManager.incBytecodes(1);
                        of = OptionalDouble.of(doubleValue);
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        of = null;
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(1);
                    return of;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
    }
    
    private static final class FindTask<P_IN, P_OUT, O> extends AbstractShortCircuitTask<P_IN, P_OUT, O, FindTask<P_IN, P_OUT, O>>
    {
        private final FindOp<P_OUT, O> op;
        
        FindTask(final FindOp<P_OUT, O> op, final PipelineHelper<P_OUT> pipelineHelper, final Spliterator<P_IN> spliterator) {
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
        
        FindTask(final FindTask<P_IN, P_OUT, O> findTask, final Spliterator<P_IN> spliterator) {
            try {
                BytecodeManager.incBytecodes(4);
                super(findTask, spliterator);
                this.op = findTask.op;
                BytecodeManager.incBytecodes(4);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        protected FindTask<P_IN, P_OUT, O> makeChild(final Spliterator<P_IN> spliterator) {
            try {
                BytecodeManager.incBytecodes(5);
                final FindTask<P_IN, P_OUT, O> findTask = new FindTask<P_IN, P_OUT, O>(this, spliterator);
                BytecodeManager.incBytecodes(1);
                return findTask;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        protected O getEmptyResult() {
            try {
                final O emptyValue = this.op.emptyValue;
                BytecodeManager.incBytecodes(4);
                return emptyValue;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private void foundResult(final O o) {
            try {
                BytecodeManager.incBytecodes(2);
                final boolean leftmostNode = this.isLeftmostNode();
                BytecodeManager.incBytecodes(1);
                if (leftmostNode) {
                    BytecodeManager.incBytecodes(3);
                    this.shortCircuit(o);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    BytecodeManager.incBytecodes(2);
                    this.cancelLaterNodes();
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        protected O doLeaf() {
            try {
                final PipelineHelper<P_OUT> helper = this.helper;
                final Supplier<TerminalSink<P_OUT, O>> sinkSupplier = this.op.sinkSupplier;
                BytecodeManager.incBytecodes(6);
                final TerminalSink<P_OUT, O> terminalSink = sinkSupplier.get();
                final Spliterator<P_IN> spliterator = this.spliterator;
                BytecodeManager.incBytecodes(4);
                final TerminalSink<?, Object> terminalSink2 = helper.wrapAndCopyInto((TerminalSink<?, Object>)terminalSink, spliterator);
                BytecodeManager.incBytecodes(2);
                final O value = terminalSink2.get();
                BytecodeManager.incBytecodes(1);
                final boolean mustFindFirst = this.op.mustFindFirst;
                BytecodeManager.incBytecodes(4);
                if (!mustFindFirst) {
                    final O o = value;
                    BytecodeManager.incBytecodes(2);
                    if (o != null) {
                        final O o2 = value;
                        BytecodeManager.incBytecodes(3);
                        this.shortCircuit(o2);
                    }
                    final O o3 = null;
                    BytecodeManager.incBytecodes(2);
                    return o3;
                }
                final O o4 = value;
                BytecodeManager.incBytecodes(2);
                if (o4 != null) {
                    final O o5 = value;
                    BytecodeManager.incBytecodes(3);
                    this.foundResult(o5);
                    final O o6 = value;
                    BytecodeManager.incBytecodes(2);
                    return o6;
                }
                final O o7 = null;
                BytecodeManager.incBytecodes(2);
                return o7;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void onCompletion(final CountedCompleter<?> countedCompleter) {
            try {
                final boolean mustFindFirst = this.op.mustFindFirst;
                BytecodeManager.incBytecodes(4);
                if (mustFindFirst) {
                    FindTask findTask = (FindTask)this.leftChild;
                    AbstractShortCircuitTask<P_IN, P_OUT, O, K> abstractShortCircuitTask = null;
                    BytecodeManager.incBytecodes(6);
                    while (true) {
                        final FindTask findTask2 = findTask;
                        final AbstractShortCircuitTask<P_IN, P_OUT, O, K> abstractShortCircuitTask2 = abstractShortCircuitTask;
                        BytecodeManager.incBytecodes(3);
                        if (findTask2 == abstractShortCircuitTask2) {
                            break;
                        }
                        final FindTask findTask3 = findTask;
                        BytecodeManager.incBytecodes(2);
                        final O localResult = findTask3.getLocalResult();
                        BytecodeManager.incBytecodes(1);
                        final O o = localResult;
                        BytecodeManager.incBytecodes(2);
                        if (o != null) {
                            final Predicate<O> presentPredicate = this.op.presentPredicate;
                            final O o2 = localResult;
                            BytecodeManager.incBytecodes(5);
                            final boolean test = presentPredicate.test(o2);
                            BytecodeManager.incBytecodes(1);
                            if (test) {
                                final O localResult2 = localResult;
                                BytecodeManager.incBytecodes(3);
                                this.setLocalResult(localResult2);
                                final O o3 = localResult;
                                BytecodeManager.incBytecodes(3);
                                this.foundResult(o3);
                                BytecodeManager.incBytecodes(1);
                                break;
                            }
                        }
                        abstractShortCircuitTask = (AbstractShortCircuitTask<P_IN, P_OUT, O, K>)findTask;
                        findTask = (FindTask)this.rightChild;
                        BytecodeManager.incBytecodes(7);
                    }
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
}
