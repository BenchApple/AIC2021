// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.stream;

import instrumented.java.util.Spliterator;
import instrumented.java.util.function.DoublePredicate;
import instrumented.java.util.function.LongPredicate;
import instrumented.java.util.function.IntPredicate;
import instrumented.java.util.function.Supplier;
import instrumented.java.util.Objects;
import instrumented.java.util.function.Predicate;
import aic2021.engine.BytecodeManager;

final class MatchOps
{
    private MatchOps() {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T> TerminalOp<T, Boolean> makeRef(final Predicate<? super T> predicate, final MatchKind matchKind) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(predicate);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(matchKind);
            BytecodeManager.incBytecodes(1);
            final StreamShape reference = StreamShape.REFERENCE;
            final Object o;
            class MatchSink extends BooleanTerminalSink<T>
            {
                MatchSink() {
                    try {
                        BytecodeManager.incBytecodes(6);
                        BytecodeManager.incBytecodes(3);
                        super(val$matchKind);
                        BytecodeManager.incBytecodes(1);
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public void accept(final T t) {
                    try {
                        final boolean stop = this.stop;
                        BytecodeManager.incBytecodes(3);
                        if (!stop) {
                            final Predicate val$predicate = predicate;
                            BytecodeManager.incBytecodes(4);
                            final boolean test = val$predicate.test(t);
                            final MatchKind val$matchKind = matchKind;
                            BytecodeManager.incBytecodes(3);
                            final boolean access$000 = MatchKind.access$000(val$matchKind);
                            BytecodeManager.incBytecodes(1);
                            if (test == access$000) {
                                this.stop = true;
                                BytecodeManager.incBytecodes(3);
                                final MatchKind val$matchKind2 = matchKind;
                                BytecodeManager.incBytecodes(4);
                                this.value = MatchKind.access$100(val$matchKind2);
                                BytecodeManager.incBytecodes(1);
                            }
                        }
                        BytecodeManager.incBytecodes(1);
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
            }
            final Supplier<Object> supplier = () -> {
                try {
                    // new(instrumented.java.util.stream.MatchOps.MatchSink.class)
                    BytecodeManager.incBytecodes(5);
                    new MatchSink();
                    BytecodeManager.incBytecodes(1);
                    return o;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            BytecodeManager.incBytecodes(7);
            final MatchOp matchOp = new MatchOp<T>(reference, matchKind, supplier);
            BytecodeManager.incBytecodes(1);
            return (TerminalOp<T, Boolean>)matchOp;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static TerminalOp<Integer, Boolean> makeInt(final IntPredicate intPredicate, final MatchKind matchKind) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(intPredicate);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(matchKind);
            BytecodeManager.incBytecodes(1);
            final StreamShape int_VALUE = StreamShape.INT_VALUE;
            final Object o;
            class MatchSink extends BooleanTerminalSink<Integer> implements Sink.OfInt
            {
                MatchSink() {
                    try {
                        BytecodeManager.incBytecodes(6);
                        BytecodeManager.incBytecodes(3);
                        super(val$matchKind);
                        BytecodeManager.incBytecodes(1);
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public void accept(final int n) {
                    try {
                        final boolean stop = this.stop;
                        BytecodeManager.incBytecodes(3);
                        if (!stop) {
                            final IntPredicate val$predicate = intPredicate;
                            BytecodeManager.incBytecodes(4);
                            final boolean test = val$predicate.test(n);
                            final MatchKind val$matchKind = matchKind;
                            BytecodeManager.incBytecodes(3);
                            final boolean access$000 = MatchKind.access$000(val$matchKind);
                            BytecodeManager.incBytecodes(1);
                            if (test == access$000) {
                                this.stop = true;
                                BytecodeManager.incBytecodes(3);
                                final MatchKind val$matchKind2 = matchKind;
                                BytecodeManager.incBytecodes(4);
                                this.value = MatchKind.access$100(val$matchKind2);
                                BytecodeManager.incBytecodes(1);
                            }
                        }
                        BytecodeManager.incBytecodes(1);
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
            }
            final Supplier<Object> supplier = () -> {
                try {
                    // new(instrumented.java.util.stream.MatchOps.MatchSink.class)
                    BytecodeManager.incBytecodes(5);
                    new MatchSink();
                    BytecodeManager.incBytecodes(1);
                    return o;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            BytecodeManager.incBytecodes(7);
            final MatchOp matchOp = new MatchOp<Integer>(int_VALUE, matchKind, supplier);
            BytecodeManager.incBytecodes(1);
            return (TerminalOp<Integer, Boolean>)matchOp;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static TerminalOp<Long, Boolean> makeLong(final LongPredicate longPredicate, final MatchKind matchKind) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(longPredicate);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(matchKind);
            BytecodeManager.incBytecodes(1);
            final StreamShape long_VALUE = StreamShape.LONG_VALUE;
            final Object o;
            class MatchSink extends BooleanTerminalSink<Long> implements Sink.OfLong
            {
                MatchSink() {
                    try {
                        BytecodeManager.incBytecodes(6);
                        BytecodeManager.incBytecodes(3);
                        super(val$matchKind);
                        BytecodeManager.incBytecodes(1);
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public void accept(final long n) {
                    try {
                        final boolean stop = this.stop;
                        BytecodeManager.incBytecodes(3);
                        if (!stop) {
                            final LongPredicate val$predicate = longPredicate;
                            BytecodeManager.incBytecodes(4);
                            final boolean test = val$predicate.test(n);
                            final MatchKind val$matchKind = matchKind;
                            BytecodeManager.incBytecodes(3);
                            final boolean access$000 = MatchKind.access$000(val$matchKind);
                            BytecodeManager.incBytecodes(1);
                            if (test == access$000) {
                                this.stop = true;
                                BytecodeManager.incBytecodes(3);
                                final MatchKind val$matchKind2 = matchKind;
                                BytecodeManager.incBytecodes(4);
                                this.value = MatchKind.access$100(val$matchKind2);
                                BytecodeManager.incBytecodes(1);
                            }
                        }
                        BytecodeManager.incBytecodes(1);
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
            }
            final Supplier<Object> supplier = () -> {
                try {
                    // new(instrumented.java.util.stream.MatchOps.MatchSink.class)
                    BytecodeManager.incBytecodes(5);
                    new MatchSink();
                    BytecodeManager.incBytecodes(1);
                    return o;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            BytecodeManager.incBytecodes(7);
            final MatchOp matchOp = new MatchOp<Long>(long_VALUE, matchKind, supplier);
            BytecodeManager.incBytecodes(1);
            return (TerminalOp<Long, Boolean>)matchOp;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static TerminalOp<Double, Boolean> makeDouble(final DoublePredicate doublePredicate, final MatchKind matchKind) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(doublePredicate);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(matchKind);
            BytecodeManager.incBytecodes(1);
            final StreamShape double_VALUE = StreamShape.DOUBLE_VALUE;
            final Object o;
            class MatchSink extends BooleanTerminalSink<Double> implements Sink.OfDouble
            {
                MatchSink() {
                    try {
                        BytecodeManager.incBytecodes(6);
                        BytecodeManager.incBytecodes(3);
                        super(val$matchKind);
                        BytecodeManager.incBytecodes(1);
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public void accept(final double n) {
                    try {
                        final boolean stop = this.stop;
                        BytecodeManager.incBytecodes(3);
                        if (!stop) {
                            final DoublePredicate val$predicate = doublePredicate;
                            BytecodeManager.incBytecodes(4);
                            final boolean test = val$predicate.test(n);
                            final MatchKind val$matchKind = matchKind;
                            BytecodeManager.incBytecodes(3);
                            final boolean access$000 = MatchKind.access$000(val$matchKind);
                            BytecodeManager.incBytecodes(1);
                            if (test == access$000) {
                                this.stop = true;
                                BytecodeManager.incBytecodes(3);
                                final MatchKind val$matchKind2 = matchKind;
                                BytecodeManager.incBytecodes(4);
                                this.value = MatchKind.access$100(val$matchKind2);
                                BytecodeManager.incBytecodes(1);
                            }
                        }
                        BytecodeManager.incBytecodes(1);
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
            }
            final Supplier<Object> supplier = () -> {
                try {
                    // new(instrumented.java.util.stream.MatchOps.MatchSink.class)
                    BytecodeManager.incBytecodes(5);
                    new MatchSink();
                    BytecodeManager.incBytecodes(1);
                    return o;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            BytecodeManager.incBytecodes(7);
            final MatchOp matchOp = new MatchOp<Double>(double_VALUE, matchKind, supplier);
            BytecodeManager.incBytecodes(1);
            return (TerminalOp<Double, Boolean>)matchOp;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    enum MatchKind
    {
        ANY(b, b2), 
        ALL(b3, b4), 
        NONE(b5, b6);
        
        private final boolean stopOnPredicateMatches;
        private final boolean shortCircuitResult;
        
        private MatchKind(final boolean stopOnPredicateMatches, final boolean shortCircuitResult) {
            try {
                BytecodeManager.incBytecodes(4);
                super(name, ordinal);
                this.stopOnPredicateMatches = stopOnPredicateMatches;
                BytecodeManager.incBytecodes(3);
                this.shortCircuitResult = shortCircuitResult;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static /* synthetic */ boolean access$000(final MatchKind matchKind) {
            try {
                final boolean stopOnPredicateMatches = matchKind.stopOnPredicateMatches;
                BytecodeManager.incBytecodes(3);
                return stopOnPredicateMatches;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static /* synthetic */ boolean access$100(final MatchKind matchKind) {
            try {
                final boolean shortCircuitResult = matchKind.shortCircuitResult;
                BytecodeManager.incBytecodes(3);
                return shortCircuitResult;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static {
            try {
                final String s = "ANY";
                final int n = 0;
                final boolean b = true;
                final boolean b2 = true;
                BytecodeManager.incBytecodes(7);
                BytecodeManager.incBytecodes(1);
                final String s2 = "ALL";
                final int n2 = 1;
                final boolean b3 = false;
                final boolean b4 = false;
                BytecodeManager.incBytecodes(7);
                BytecodeManager.incBytecodes(1);
                final String s3 = "NONE";
                final int n3 = 2;
                final boolean b5 = true;
                final boolean b6 = false;
                BytecodeManager.incBytecodes(7);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(15);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private static final class MatchOp<T> implements TerminalOp<T, Boolean>
    {
        private final StreamShape inputShape;
        final MatchKind matchKind;
        final Supplier<BooleanTerminalSink<T>> sinkSupplier;
        
        MatchOp(final StreamShape inputShape, final MatchKind matchKind, final Supplier<BooleanTerminalSink<T>> sinkSupplier) {
            try {
                BytecodeManager.incBytecodes(2);
                this.inputShape = inputShape;
                BytecodeManager.incBytecodes(3);
                this.matchKind = matchKind;
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
                final int n = StreamOpFlag.IS_SHORT_CIRCUIT | StreamOpFlag.NOT_ORDERED;
                BytecodeManager.incBytecodes(4);
                return n;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
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
        public <S> Boolean evaluateSequential(final PipelineHelper<T> pipelineHelper, final Spliterator<S> spliterator) {
            try {
                final Supplier<BooleanTerminalSink<T>> sinkSupplier = this.sinkSupplier;
                BytecodeManager.incBytecodes(4);
                final BooleanTerminalSink<T> booleanTerminalSink = sinkSupplier.get();
                BytecodeManager.incBytecodes(3);
                final BooleanTerminalSink<T> booleanTerminalSink2 = pipelineHelper.wrapAndCopyInto(booleanTerminalSink, spliterator);
                BytecodeManager.incBytecodes(2);
                final boolean andClearState = booleanTerminalSink2.getAndClearState();
                BytecodeManager.incBytecodes(1);
                final Boolean value = andClearState;
                BytecodeManager.incBytecodes(1);
                return value;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public <S> Boolean evaluateParallel(final PipelineHelper<T> pipelineHelper, final Spliterator<S> spliterator) {
            try {
                BytecodeManager.incBytecodes(6);
                final MatchTask matchTask = new MatchTask(this, pipelineHelper, spliterator);
                BytecodeManager.incBytecodes(1);
                final Boolean b = matchTask.invoke();
                BytecodeManager.incBytecodes(2);
                return b;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private abstract static class BooleanTerminalSink<T> implements Sink<T>
    {
        boolean stop;
        boolean value;
        
        BooleanTerminalSink(final MatchKind matchKind) {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(3);
                final boolean access$100 = MatchKind.access$100(matchKind);
                BytecodeManager.incBytecodes(1);
                boolean value;
                if (!access$100) {
                    value = true;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    value = false;
                    BytecodeManager.incBytecodes(1);
                }
                this.value = value;
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public boolean getAndClearState() {
            try {
                final boolean value = this.value;
                BytecodeManager.incBytecodes(3);
                return value;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean cancellationRequested() {
            try {
                final boolean stop = this.stop;
                BytecodeManager.incBytecodes(3);
                return stop;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private static final class MatchTask<P_IN, P_OUT> extends AbstractShortCircuitTask<P_IN, P_OUT, Boolean, MatchTask<P_IN, P_OUT>>
    {
        private final MatchOp<P_OUT> op;
        
        MatchTask(final MatchOp<P_OUT> op, final PipelineHelper<P_OUT> pipelineHelper, final Spliterator<P_IN> spliterator) {
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
        
        MatchTask(final MatchTask<P_IN, P_OUT> matchTask, final Spliterator<P_IN> spliterator) {
            try {
                BytecodeManager.incBytecodes(4);
                super(matchTask, spliterator);
                this.op = matchTask.op;
                BytecodeManager.incBytecodes(4);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        protected MatchTask<P_IN, P_OUT> makeChild(final Spliterator<P_IN> spliterator) {
            try {
                BytecodeManager.incBytecodes(5);
                final MatchTask<P_IN, P_OUT> matchTask = new MatchTask<P_IN, P_OUT>(this, spliterator);
                BytecodeManager.incBytecodes(1);
                return matchTask;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        protected Boolean doLeaf() {
            try {
                final PipelineHelper<P_OUT> helper = this.helper;
                final Supplier<BooleanTerminalSink<P_OUT>> sinkSupplier = this.op.sinkSupplier;
                BytecodeManager.incBytecodes(6);
                final BooleanTerminalSink<P_OUT> booleanTerminalSink = sinkSupplier.get();
                final Spliterator<P_IN> spliterator = this.spliterator;
                BytecodeManager.incBytecodes(4);
                final BooleanTerminalSink<P_OUT> booleanTerminalSink2 = helper.wrapAndCopyInto(booleanTerminalSink, spliterator);
                BytecodeManager.incBytecodes(2);
                final boolean andClearState = booleanTerminalSink2.getAndClearState();
                BytecodeManager.incBytecodes(1);
                final boolean b = andClearState;
                final MatchKind matchKind = this.op.matchKind;
                BytecodeManager.incBytecodes(5);
                final boolean access$100 = MatchKind.access$100(matchKind);
                BytecodeManager.incBytecodes(1);
                if (b == access$100) {
                    final boolean b2 = andClearState;
                    BytecodeManager.incBytecodes(3);
                    final Boolean value = b2;
                    BytecodeManager.incBytecodes(1);
                    this.shortCircuit(value);
                }
                final Boolean b3 = null;
                BytecodeManager.incBytecodes(2);
                return b3;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        protected Boolean getEmptyResult() {
            try {
                final MatchKind matchKind = this.op.matchKind;
                BytecodeManager.incBytecodes(4);
                final boolean access$100 = MatchKind.access$100(matchKind);
                BytecodeManager.incBytecodes(1);
                boolean b;
                if (!access$100) {
                    b = true;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    b = false;
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
                final Boolean value = b;
                BytecodeManager.incBytecodes(1);
                return value;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
}
