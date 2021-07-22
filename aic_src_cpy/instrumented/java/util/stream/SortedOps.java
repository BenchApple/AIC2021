// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.stream;

import java.util.Iterator;
import instrumented.java.util.function.Consumer;
import instrumented.java.util.ArrayList;
import instrumented.java.util.Arrays;
import instrumented.java.util.function.IntFunction;
import instrumented.java.util.Spliterator;
import instrumented.java.util.Objects;
import instrumented.java.util.Comparator;
import aic2021.engine.BytecodeManager;

final class SortedOps
{
    private SortedOps() {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static <T> Stream<T> makeRef(final AbstractPipeline<?, T, ?> abstractPipeline) {
        try {
            BytecodeManager.incBytecodes(4);
            final OfRef ofRef = new OfRef(abstractPipeline);
            BytecodeManager.incBytecodes(1);
            return (Stream<T>)ofRef;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static <T> Stream<T> makeRef(final AbstractPipeline<?, T, ?> abstractPipeline, final Comparator<? super T> comparator) {
        try {
            BytecodeManager.incBytecodes(5);
            final OfRef ofRef = new OfRef(abstractPipeline, comparator);
            BytecodeManager.incBytecodes(1);
            return (Stream<T>)ofRef;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static <T> IntStream makeInt(final AbstractPipeline<?, Integer, ?> abstractPipeline) {
        try {
            BytecodeManager.incBytecodes(4);
            final OfInt ofInt = new OfInt(abstractPipeline);
            BytecodeManager.incBytecodes(1);
            return ofInt;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static <T> LongStream makeLong(final AbstractPipeline<?, Long, ?> abstractPipeline) {
        try {
            BytecodeManager.incBytecodes(4);
            final OfLong ofLong = new OfLong(abstractPipeline);
            BytecodeManager.incBytecodes(1);
            return ofLong;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static <T> DoubleStream makeDouble(final AbstractPipeline<?, Double, ?> abstractPipeline) {
        try {
            BytecodeManager.incBytecodes(4);
            final OfDouble ofDouble = new OfDouble(abstractPipeline);
            BytecodeManager.incBytecodes(1);
            return ofDouble;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static final class OfRef<T> extends StatefulOp<T, T>
    {
        private final boolean isNaturalSort;
        private final Comparator<? super T> comparator;
        
        OfRef(final AbstractPipeline<?, T, ?> abstractPipeline) {
            try {
                final StreamShape reference = StreamShape.REFERENCE;
                final int n = StreamOpFlag.IS_ORDERED | StreamOpFlag.IS_SORTED;
                BytecodeManager.incBytecodes(7);
                super(abstractPipeline, reference, n);
                this.isNaturalSort = true;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
                final Comparator<? super T> naturalOrder = Comparator.naturalOrder();
                BytecodeManager.incBytecodes(1);
                this.comparator = naturalOrder;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        OfRef(final AbstractPipeline<?, T, ?> abstractPipeline, final Comparator<? super T> comparator) {
            try {
                final StreamShape reference = StreamShape.REFERENCE;
                final int n = StreamOpFlag.IS_ORDERED | StreamOpFlag.NOT_SORTED;
                BytecodeManager.incBytecodes(7);
                super(abstractPipeline, reference, n);
                this.isNaturalSort = false;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(3);
                this.comparator = Objects.requireNonNull(comparator);
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public Sink<T> opWrapSink(final int n, final Sink<T> sink) {
            try {
                BytecodeManager.incBytecodes(2);
                Objects.requireNonNull(sink);
                BytecodeManager.incBytecodes(1);
                final StreamOpFlag sorted = StreamOpFlag.SORTED;
                BytecodeManager.incBytecodes(3);
                final boolean known = sorted.isKnown(n);
                BytecodeManager.incBytecodes(1);
                if (known) {
                    final boolean isNaturalSort = this.isNaturalSort;
                    BytecodeManager.incBytecodes(3);
                    if (isNaturalSort) {
                        BytecodeManager.incBytecodes(2);
                        return sink;
                    }
                }
                final StreamOpFlag sized = StreamOpFlag.SIZED;
                BytecodeManager.incBytecodes(3);
                final boolean known2 = sized.isKnown(n);
                BytecodeManager.incBytecodes(1);
                if (known2) {
                    final Comparator<? super T> comparator = this.comparator;
                    BytecodeManager.incBytecodes(6);
                    final SizedRefSortingSink sizedRefSortingSink = new SizedRefSortingSink(sink, comparator);
                    BytecodeManager.incBytecodes(1);
                    return (Sink<T>)sizedRefSortingSink;
                }
                final Comparator<? super T> comparator2 = this.comparator;
                BytecodeManager.incBytecodes(6);
                final RefSortingSink refSortingSink = new RefSortingSink(sink, comparator2);
                BytecodeManager.incBytecodes(1);
                return (Sink<T>)refSortingSink;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public <P_IN> Node<T> opEvaluateParallel(final PipelineHelper<T> pipelineHelper, final Spliterator<P_IN> spliterator, final IntFunction<T[]> intFunction) {
            try {
                final StreamOpFlag sorted = StreamOpFlag.SORTED;
                BytecodeManager.incBytecodes(3);
                final int streamAndOpFlags = pipelineHelper.getStreamAndOpFlags();
                BytecodeManager.incBytecodes(1);
                final boolean known = sorted.isKnown(streamAndOpFlags);
                BytecodeManager.incBytecodes(1);
                if (known) {
                    final boolean isNaturalSort = this.isNaturalSort;
                    BytecodeManager.incBytecodes(3);
                    if (isNaturalSort) {
                        final boolean b = false;
                        BytecodeManager.incBytecodes(5);
                        final Node<T> evaluate = pipelineHelper.evaluate(spliterator, b, intFunction);
                        BytecodeManager.incBytecodes(1);
                        return evaluate;
                    }
                }
                final boolean b2 = true;
                BytecodeManager.incBytecodes(5);
                final Node<T> evaluate2 = pipelineHelper.evaluate(spliterator, b2, intFunction);
                BytecodeManager.incBytecodes(2);
                final T[] array = evaluate2.asArray(intFunction);
                BytecodeManager.incBytecodes(1);
                final T[] array2 = array;
                final Comparator<? super T> comparator = this.comparator;
                BytecodeManager.incBytecodes(4);
                Arrays.parallelSort(array2, comparator);
                final T[] array3 = array;
                BytecodeManager.incBytecodes(2);
                final Node<T> node = Nodes.node(array3);
                BytecodeManager.incBytecodes(1);
                return node;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private static final class OfInt extends StatefulOp<Integer>
    {
        OfInt(final AbstractPipeline<?, Integer, ?> abstractPipeline) {
            try {
                final StreamShape int_VALUE = StreamShape.INT_VALUE;
                final int n = StreamOpFlag.IS_ORDERED | StreamOpFlag.IS_SORTED;
                BytecodeManager.incBytecodes(7);
                super(abstractPipeline, int_VALUE, n);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public Sink<Integer> opWrapSink(final int n, final Sink<Integer> sink) {
            try {
                BytecodeManager.incBytecodes(2);
                Objects.requireNonNull(sink);
                BytecodeManager.incBytecodes(1);
                final StreamOpFlag sorted = StreamOpFlag.SORTED;
                BytecodeManager.incBytecodes(3);
                final boolean known = sorted.isKnown(n);
                BytecodeManager.incBytecodes(1);
                if (known) {
                    BytecodeManager.incBytecodes(2);
                    return sink;
                }
                final StreamOpFlag sized = StreamOpFlag.SIZED;
                BytecodeManager.incBytecodes(3);
                final boolean known2 = sized.isKnown(n);
                BytecodeManager.incBytecodes(1);
                if (known2) {
                    BytecodeManager.incBytecodes(4);
                    final SizedIntSortingSink sizedIntSortingSink = new SizedIntSortingSink(sink);
                    BytecodeManager.incBytecodes(1);
                    return sizedIntSortingSink;
                }
                BytecodeManager.incBytecodes(4);
                final IntSortingSink intSortingSink = new IntSortingSink(sink);
                BytecodeManager.incBytecodes(1);
                return intSortingSink;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public <P_IN> Node<Integer> opEvaluateParallel(final PipelineHelper<Integer> pipelineHelper, final Spliterator<P_IN> spliterator, final IntFunction<Integer[]> intFunction) {
            try {
                final StreamOpFlag sorted = StreamOpFlag.SORTED;
                BytecodeManager.incBytecodes(3);
                final int streamAndOpFlags = pipelineHelper.getStreamAndOpFlags();
                BytecodeManager.incBytecodes(1);
                final boolean known = sorted.isKnown(streamAndOpFlags);
                BytecodeManager.incBytecodes(1);
                if (known) {
                    final boolean b = false;
                    BytecodeManager.incBytecodes(5);
                    final Node<Integer> evaluate = pipelineHelper.evaluate(spliterator, b, intFunction);
                    BytecodeManager.incBytecodes(1);
                    return evaluate;
                }
                final boolean b2 = true;
                BytecodeManager.incBytecodes(5);
                final Node.OfInt ofInt = (Node.OfInt)pipelineHelper.evaluate(spliterator, b2, intFunction);
                BytecodeManager.incBytecodes(2);
                final Node.OfPrimitive<T, T_CONS, int[], T_SPLITR, T_NODE> ofPrimitive = (Node.OfPrimitive<T, T_CONS, int[], T_SPLITR, T_NODE>)ofInt;
                BytecodeManager.incBytecodes(2);
                final int[] array = ofPrimitive.asPrimitiveArray();
                BytecodeManager.incBytecodes(2);
                final int[] array2 = array;
                BytecodeManager.incBytecodes(2);
                Arrays.parallelSort(array2);
                final int[] array3 = array;
                BytecodeManager.incBytecodes(2);
                final Node.OfInt node = Nodes.node(array3);
                BytecodeManager.incBytecodes(1);
                return node;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private static final class OfLong extends StatefulOp<Long>
    {
        OfLong(final AbstractPipeline<?, Long, ?> abstractPipeline) {
            try {
                final StreamShape long_VALUE = StreamShape.LONG_VALUE;
                final int n = StreamOpFlag.IS_ORDERED | StreamOpFlag.IS_SORTED;
                BytecodeManager.incBytecodes(7);
                super(abstractPipeline, long_VALUE, n);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public Sink<Long> opWrapSink(final int n, final Sink<Long> sink) {
            try {
                BytecodeManager.incBytecodes(2);
                Objects.requireNonNull(sink);
                BytecodeManager.incBytecodes(1);
                final StreamOpFlag sorted = StreamOpFlag.SORTED;
                BytecodeManager.incBytecodes(3);
                final boolean known = sorted.isKnown(n);
                BytecodeManager.incBytecodes(1);
                if (known) {
                    BytecodeManager.incBytecodes(2);
                    return sink;
                }
                final StreamOpFlag sized = StreamOpFlag.SIZED;
                BytecodeManager.incBytecodes(3);
                final boolean known2 = sized.isKnown(n);
                BytecodeManager.incBytecodes(1);
                if (known2) {
                    BytecodeManager.incBytecodes(4);
                    final SizedLongSortingSink sizedLongSortingSink = new SizedLongSortingSink(sink);
                    BytecodeManager.incBytecodes(1);
                    return sizedLongSortingSink;
                }
                BytecodeManager.incBytecodes(4);
                final LongSortingSink longSortingSink = new LongSortingSink(sink);
                BytecodeManager.incBytecodes(1);
                return longSortingSink;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public <P_IN> Node<Long> opEvaluateParallel(final PipelineHelper<Long> pipelineHelper, final Spliterator<P_IN> spliterator, final IntFunction<Long[]> intFunction) {
            try {
                final StreamOpFlag sorted = StreamOpFlag.SORTED;
                BytecodeManager.incBytecodes(3);
                final int streamAndOpFlags = pipelineHelper.getStreamAndOpFlags();
                BytecodeManager.incBytecodes(1);
                final boolean known = sorted.isKnown(streamAndOpFlags);
                BytecodeManager.incBytecodes(1);
                if (known) {
                    final boolean b = false;
                    BytecodeManager.incBytecodes(5);
                    final Node<Long> evaluate = pipelineHelper.evaluate(spliterator, b, intFunction);
                    BytecodeManager.incBytecodes(1);
                    return evaluate;
                }
                final boolean b2 = true;
                BytecodeManager.incBytecodes(5);
                final Node.OfLong ofLong = (Node.OfLong)pipelineHelper.evaluate(spliterator, b2, intFunction);
                BytecodeManager.incBytecodes(2);
                final Node.OfPrimitive<T, T_CONS, long[], T_SPLITR, T_NODE> ofPrimitive = (Node.OfPrimitive<T, T_CONS, long[], T_SPLITR, T_NODE>)ofLong;
                BytecodeManager.incBytecodes(2);
                final long[] array = ofPrimitive.asPrimitiveArray();
                BytecodeManager.incBytecodes(2);
                final long[] array2 = array;
                BytecodeManager.incBytecodes(2);
                Arrays.parallelSort(array2);
                final long[] array3 = array;
                BytecodeManager.incBytecodes(2);
                final Node.OfLong node = Nodes.node(array3);
                BytecodeManager.incBytecodes(1);
                return node;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private static final class OfDouble extends StatefulOp<Double>
    {
        OfDouble(final AbstractPipeline<?, Double, ?> abstractPipeline) {
            try {
                final StreamShape double_VALUE = StreamShape.DOUBLE_VALUE;
                final int n = StreamOpFlag.IS_ORDERED | StreamOpFlag.IS_SORTED;
                BytecodeManager.incBytecodes(7);
                super(abstractPipeline, double_VALUE, n);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public Sink<Double> opWrapSink(final int n, final Sink<Double> sink) {
            try {
                BytecodeManager.incBytecodes(2);
                Objects.requireNonNull(sink);
                BytecodeManager.incBytecodes(1);
                final StreamOpFlag sorted = StreamOpFlag.SORTED;
                BytecodeManager.incBytecodes(3);
                final boolean known = sorted.isKnown(n);
                BytecodeManager.incBytecodes(1);
                if (known) {
                    BytecodeManager.incBytecodes(2);
                    return sink;
                }
                final StreamOpFlag sized = StreamOpFlag.SIZED;
                BytecodeManager.incBytecodes(3);
                final boolean known2 = sized.isKnown(n);
                BytecodeManager.incBytecodes(1);
                if (known2) {
                    BytecodeManager.incBytecodes(4);
                    final SizedDoubleSortingSink sizedDoubleSortingSink = new SizedDoubleSortingSink(sink);
                    BytecodeManager.incBytecodes(1);
                    return sizedDoubleSortingSink;
                }
                BytecodeManager.incBytecodes(4);
                final DoubleSortingSink doubleSortingSink = new DoubleSortingSink(sink);
                BytecodeManager.incBytecodes(1);
                return doubleSortingSink;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public <P_IN> Node<Double> opEvaluateParallel(final PipelineHelper<Double> pipelineHelper, final Spliterator<P_IN> spliterator, final IntFunction<Double[]> intFunction) {
            try {
                final StreamOpFlag sorted = StreamOpFlag.SORTED;
                BytecodeManager.incBytecodes(3);
                final int streamAndOpFlags = pipelineHelper.getStreamAndOpFlags();
                BytecodeManager.incBytecodes(1);
                final boolean known = sorted.isKnown(streamAndOpFlags);
                BytecodeManager.incBytecodes(1);
                if (known) {
                    final boolean b = false;
                    BytecodeManager.incBytecodes(5);
                    final Node<Double> evaluate = pipelineHelper.evaluate(spliterator, b, intFunction);
                    BytecodeManager.incBytecodes(1);
                    return evaluate;
                }
                final boolean b2 = true;
                BytecodeManager.incBytecodes(5);
                final Node.OfDouble ofDouble = (Node.OfDouble)pipelineHelper.evaluate(spliterator, b2, intFunction);
                BytecodeManager.incBytecodes(2);
                final Node.OfPrimitive<T, T_CONS, double[], T_SPLITR, T_NODE> ofPrimitive = (Node.OfPrimitive<T, T_CONS, double[], T_SPLITR, T_NODE>)ofDouble;
                BytecodeManager.incBytecodes(2);
                final double[] array = ofPrimitive.asPrimitiveArray();
                BytecodeManager.incBytecodes(2);
                final double[] array2 = array;
                BytecodeManager.incBytecodes(2);
                Arrays.parallelSort(array2);
                final double[] array3 = array;
                BytecodeManager.incBytecodes(2);
                final Node.OfDouble node = Nodes.node(array3);
                BytecodeManager.incBytecodes(1);
                return node;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private abstract static class AbstractRefSortingSink<T> extends Sink.ChainedReference<T, T>
    {
        protected final Comparator<? super T> comparator;
        protected boolean cancellationWasRequested;
        
        AbstractRefSortingSink(final Sink<? super T> sink, final Comparator<? super T> comparator) {
            try {
                BytecodeManager.incBytecodes(3);
                super(sink);
                this.comparator = comparator;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final boolean cancellationRequested() {
            try {
                this.cancellationWasRequested = true;
                BytecodeManager.incBytecodes(3);
                final boolean b = false;
                BytecodeManager.incBytecodes(2);
                return b;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private static final class SizedRefSortingSink<T> extends AbstractRefSortingSink<T>
    {
        private T[] array;
        private int offset;
        
        SizedRefSortingSink(final Sink<? super T> sink, final Comparator<? super T> comparator) {
            try {
                BytecodeManager.incBytecodes(4);
                super(sink, comparator);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void begin(final long n) {
            try {
                final long n2 = lcmp(n, 2147483639L);
                BytecodeManager.incBytecodes(4);
                if (n2 >= 0) {
                    final String s = "Stream size exceeds max array size";
                    BytecodeManager.incBytecodes(4);
                    final IllegalArgumentException ex = new IllegalArgumentException(s);
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                this.array = (T[])new Object[(int)n];
                BytecodeManager.incBytecodes(5);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void end() {
            try {
                final T[] array = this.array;
                final int n = 0;
                final int offset = this.offset;
                final Comparator<? super T> comparator = this.comparator;
                BytecodeManager.incBytecodes(8);
                Arrays.sort(array, n, offset, comparator);
                final Sink<? super E_OUT> downstream = this.downstream;
                final long n2 = this.offset;
                BytecodeManager.incBytecodes(6);
                downstream.begin(n2);
                final boolean cancellationWasRequested = this.cancellationWasRequested;
                BytecodeManager.incBytecodes(3);
                if (!cancellationWasRequested) {
                    int n3 = 0;
                    BytecodeManager.incBytecodes(2);
                    while (true) {
                        final int n4 = n3;
                        final int offset2 = this.offset;
                        BytecodeManager.incBytecodes(4);
                        if (n4 >= offset2) {
                            break;
                        }
                        final Sink<? super E_OUT> downstream2 = this.downstream;
                        final T t = this.array[n3];
                        BytecodeManager.incBytecodes(7);
                        downstream2.accept(t);
                        ++n3;
                        BytecodeManager.incBytecodes(2);
                    }
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    int n5 = 0;
                    BytecodeManager.incBytecodes(2);
                    while (true) {
                        final int n6 = n5;
                        final int offset3 = this.offset;
                        BytecodeManager.incBytecodes(4);
                        if (n6 >= offset3) {
                            break;
                        }
                        final Sink<? super E_OUT> downstream3 = this.downstream;
                        BytecodeManager.incBytecodes(3);
                        final boolean cancellationRequested = downstream3.cancellationRequested();
                        BytecodeManager.incBytecodes(1);
                        if (cancellationRequested) {
                            break;
                        }
                        final Sink<? super E_OUT> downstream4 = this.downstream;
                        final T t2 = this.array[n5];
                        BytecodeManager.incBytecodes(7);
                        downstream4.accept(t2);
                        ++n5;
                        BytecodeManager.incBytecodes(2);
                    }
                }
                final Sink<? super E_OUT> downstream5 = this.downstream;
                BytecodeManager.incBytecodes(3);
                downstream5.end();
                this.array = null;
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
                this.array[this.offset++] = t;
                BytecodeManager.incBytecodes(11);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private static final class RefSortingSink<T> extends AbstractRefSortingSink<T>
    {
        private ArrayList<T> list;
        
        RefSortingSink(final Sink<? super T> sink, final Comparator<? super T> comparator) {
            try {
                BytecodeManager.incBytecodes(4);
                super(sink, comparator);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void begin(final long n) {
            try {
                final long n2 = lcmp(n, 2147483639L);
                BytecodeManager.incBytecodes(4);
                if (n2 >= 0) {
                    final String s = "Stream size exceeds max array size";
                    BytecodeManager.incBytecodes(4);
                    final IllegalArgumentException ex = new IllegalArgumentException(s);
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final long n3 = lcmp(n, 0L);
                BytecodeManager.incBytecodes(5);
                ArrayList<T> list;
                if (n3 >= 0) {
                    final int n4;
                    list = new ArrayList<T>(n4);
                    n4 = (int)n;
                    BytecodeManager.incBytecodes(5);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    list = new ArrayList<T>();
                    BytecodeManager.incBytecodes(3);
                }
                this.list = list;
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void end() {
            try {
                final ArrayList<T> list = this.list;
                final Comparator<? super T> comparator = this.comparator;
                BytecodeManager.incBytecodes(5);
                list.sort(comparator);
                final Sink<? super E_OUT> downstream = this.downstream;
                final ArrayList<T> list2 = this.list;
                BytecodeManager.incBytecodes(5);
                final long n = list2.size();
                BytecodeManager.incBytecodes(2);
                downstream.begin(n);
                final boolean cancellationWasRequested = this.cancellationWasRequested;
                BytecodeManager.incBytecodes(3);
                if (!cancellationWasRequested) {
                    final ArrayList<T> list3 = this.list;
                    final Sink<? super E_OUT> downstream2 = this.downstream;
                    BytecodeManager.incBytecodes(6);
                    downstream2.getClass();
                    final Consumer<Object> consumer = downstream2::accept;
                    BytecodeManager.incBytecodes(2);
                    list3.forEach(consumer);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    final ArrayList<T> list4 = this.list;
                    BytecodeManager.incBytecodes(3);
                    final Iterator<T> iterator = list4.iterator();
                    BytecodeManager.incBytecodes(1);
                    while (true) {
                        final Iterator<T> iterator2 = iterator;
                        BytecodeManager.incBytecodes(2);
                        final boolean hasNext = iterator2.hasNext();
                        BytecodeManager.incBytecodes(1);
                        if (!hasNext) {
                            break;
                        }
                        final Iterator<T> iterator3 = iterator;
                        BytecodeManager.incBytecodes(2);
                        final T next = iterator3.next();
                        BytecodeManager.incBytecodes(1);
                        final Sink<? super E_OUT> downstream3 = this.downstream;
                        BytecodeManager.incBytecodes(3);
                        final boolean cancellationRequested = downstream3.cancellationRequested();
                        BytecodeManager.incBytecodes(1);
                        if (cancellationRequested) {
                            BytecodeManager.incBytecodes(1);
                            break;
                        }
                        final Sink<? super E_OUT> downstream4 = this.downstream;
                        final T t = next;
                        BytecodeManager.incBytecodes(4);
                        downstream4.accept(t);
                        BytecodeManager.incBytecodes(1);
                    }
                }
                final Sink<? super E_OUT> downstream5 = this.downstream;
                BytecodeManager.incBytecodes(3);
                downstream5.end();
                this.list = null;
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
                final ArrayList<T> list = this.list;
                BytecodeManager.incBytecodes(4);
                list.add(t);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private abstract static class AbstractIntSortingSink extends Sink.ChainedInt<Integer>
    {
        protected boolean cancellationWasRequested;
        
        AbstractIntSortingSink(final Sink<? super Integer> sink) {
            try {
                BytecodeManager.incBytecodes(3);
                super(sink);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final boolean cancellationRequested() {
            try {
                this.cancellationWasRequested = true;
                BytecodeManager.incBytecodes(3);
                final boolean b = false;
                BytecodeManager.incBytecodes(2);
                return b;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private static final class SizedIntSortingSink extends AbstractIntSortingSink
    {
        private int[] array;
        private int offset;
        
        SizedIntSortingSink(final Sink<? super Integer> sink) {
            try {
                BytecodeManager.incBytecodes(3);
                super(sink);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void begin(final long n) {
            try {
                final long n2 = lcmp(n, 2147483639L);
                BytecodeManager.incBytecodes(4);
                if (n2 >= 0) {
                    final String s = "Stream size exceeds max array size";
                    BytecodeManager.incBytecodes(4);
                    final IllegalArgumentException ex = new IllegalArgumentException(s);
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                this.array = new int[(int)n];
                BytecodeManager.incBytecodes(4);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void end() {
            try {
                final int[] array = this.array;
                final int n = 0;
                final int offset = this.offset;
                BytecodeManager.incBytecodes(6);
                Arrays.sort(array, n, offset);
                final Sink<? super E_OUT> downstream = this.downstream;
                final long n2 = this.offset;
                BytecodeManager.incBytecodes(6);
                downstream.begin(n2);
                final boolean cancellationWasRequested = this.cancellationWasRequested;
                BytecodeManager.incBytecodes(3);
                if (!cancellationWasRequested) {
                    int n3 = 0;
                    BytecodeManager.incBytecodes(2);
                    while (true) {
                        final int n4 = n3;
                        final int offset2 = this.offset;
                        BytecodeManager.incBytecodes(4);
                        if (n4 >= offset2) {
                            break;
                        }
                        final Sink<? super E_OUT> downstream2 = this.downstream;
                        final int n5 = this.array[n3];
                        BytecodeManager.incBytecodes(7);
                        downstream2.accept(n5);
                        ++n3;
                        BytecodeManager.incBytecodes(2);
                    }
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    int n6 = 0;
                    BytecodeManager.incBytecodes(2);
                    while (true) {
                        final int n7 = n6;
                        final int offset3 = this.offset;
                        BytecodeManager.incBytecodes(4);
                        if (n7 >= offset3) {
                            break;
                        }
                        final Sink<? super E_OUT> downstream3 = this.downstream;
                        BytecodeManager.incBytecodes(3);
                        final boolean cancellationRequested = downstream3.cancellationRequested();
                        BytecodeManager.incBytecodes(1);
                        if (cancellationRequested) {
                            break;
                        }
                        final Sink<? super E_OUT> downstream4 = this.downstream;
                        final int n8 = this.array[n6];
                        BytecodeManager.incBytecodes(7);
                        downstream4.accept(n8);
                        ++n6;
                        BytecodeManager.incBytecodes(2);
                    }
                }
                final Sink<? super E_OUT> downstream5 = this.downstream;
                BytecodeManager.incBytecodes(3);
                downstream5.end();
                this.array = null;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void accept(final int n) {
            try {
                this.array[this.offset++] = n;
                BytecodeManager.incBytecodes(11);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private static final class IntSortingSink extends AbstractIntSortingSink
    {
        private SpinedBuffer.OfInt b;
        
        IntSortingSink(final Sink<? super Integer> sink) {
            try {
                BytecodeManager.incBytecodes(3);
                super(sink);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void begin(final long n) {
            try {
                final long n2 = lcmp(n, 2147483639L);
                BytecodeManager.incBytecodes(4);
                if (n2 >= 0) {
                    final String s = "Stream size exceeds max array size";
                    BytecodeManager.incBytecodes(4);
                    final IllegalArgumentException ex = new IllegalArgumentException(s);
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final long n3 = lcmp(n, 0L);
                BytecodeManager.incBytecodes(5);
                SpinedBuffer.OfInt b;
                if (n3 > 0) {
                    final int n4;
                    b = new SpinedBuffer.OfInt(n4);
                    n4 = (int)n;
                    BytecodeManager.incBytecodes(5);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    b = new SpinedBuffer.OfInt();
                    BytecodeManager.incBytecodes(3);
                }
                this.b = b;
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void end() {
            try {
                final SpinedBuffer.OfInt b = this.b;
                BytecodeManager.incBytecodes(3);
                final int[] array = ((SpinedBuffer.OfPrimitive<E, int[], T_CONS>)b).asPrimitiveArray();
                BytecodeManager.incBytecodes(2);
                final int[] array2 = array;
                BytecodeManager.incBytecodes(2);
                Arrays.sort(array2);
                final Sink<? super E_OUT> downstream = this.downstream;
                final long n = array.length;
                BytecodeManager.incBytecodes(6);
                downstream.begin(n);
                final boolean cancellationWasRequested = this.cancellationWasRequested;
                BytecodeManager.incBytecodes(3);
                if (!cancellationWasRequested) {
                    final int[] array3 = array;
                    final int length = array3.length;
                    int n2 = 0;
                    BytecodeManager.incBytecodes(7);
                    while (true) {
                        final int n3 = n2;
                        final int n4 = length;
                        BytecodeManager.incBytecodes(3);
                        if (n3 >= n4) {
                            break;
                        }
                        final int n5 = array3[n2];
                        BytecodeManager.incBytecodes(4);
                        final Sink<? super E_OUT> downstream2 = this.downstream;
                        final int n6 = n5;
                        BytecodeManager.incBytecodes(4);
                        downstream2.accept(n6);
                        ++n2;
                        BytecodeManager.incBytecodes(2);
                    }
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    final int[] array4 = array;
                    final int length2 = array4.length;
                    int n7 = 0;
                    BytecodeManager.incBytecodes(7);
                    while (true) {
                        final int n8 = n7;
                        final int n9 = length2;
                        BytecodeManager.incBytecodes(3);
                        if (n8 >= n9) {
                            break;
                        }
                        final int n10 = array4[n7];
                        BytecodeManager.incBytecodes(4);
                        final Sink<? super E_OUT> downstream3 = this.downstream;
                        BytecodeManager.incBytecodes(3);
                        final boolean cancellationRequested = downstream3.cancellationRequested();
                        BytecodeManager.incBytecodes(1);
                        if (cancellationRequested) {
                            BytecodeManager.incBytecodes(1);
                            break;
                        }
                        final Sink<? super E_OUT> downstream4 = this.downstream;
                        final int n11 = n10;
                        BytecodeManager.incBytecodes(4);
                        downstream4.accept(n11);
                        ++n7;
                        BytecodeManager.incBytecodes(2);
                    }
                }
                final Sink<? super E_OUT> downstream5 = this.downstream;
                BytecodeManager.incBytecodes(3);
                downstream5.end();
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void accept(final int n) {
            try {
                final SpinedBuffer.OfInt b = this.b;
                BytecodeManager.incBytecodes(4);
                b.accept(n);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private abstract static class AbstractLongSortingSink extends Sink.ChainedLong<Long>
    {
        protected boolean cancellationWasRequested;
        
        AbstractLongSortingSink(final Sink<? super Long> sink) {
            try {
                BytecodeManager.incBytecodes(3);
                super(sink);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final boolean cancellationRequested() {
            try {
                this.cancellationWasRequested = true;
                BytecodeManager.incBytecodes(3);
                final boolean b = false;
                BytecodeManager.incBytecodes(2);
                return b;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private static final class SizedLongSortingSink extends AbstractLongSortingSink
    {
        private long[] array;
        private int offset;
        
        SizedLongSortingSink(final Sink<? super Long> sink) {
            try {
                BytecodeManager.incBytecodes(3);
                super(sink);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void begin(final long n) {
            try {
                final long n2 = lcmp(n, 2147483639L);
                BytecodeManager.incBytecodes(4);
                if (n2 >= 0) {
                    final String s = "Stream size exceeds max array size";
                    BytecodeManager.incBytecodes(4);
                    final IllegalArgumentException ex = new IllegalArgumentException(s);
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                this.array = new long[(int)n];
                BytecodeManager.incBytecodes(4);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void end() {
            try {
                final long[] array = this.array;
                final int n = 0;
                final int offset = this.offset;
                BytecodeManager.incBytecodes(6);
                Arrays.sort(array, n, offset);
                final Sink<? super E_OUT> downstream = this.downstream;
                final long n2 = this.offset;
                BytecodeManager.incBytecodes(6);
                downstream.begin(n2);
                final boolean cancellationWasRequested = this.cancellationWasRequested;
                BytecodeManager.incBytecodes(3);
                if (!cancellationWasRequested) {
                    int n3 = 0;
                    BytecodeManager.incBytecodes(2);
                    while (true) {
                        final int n4 = n3;
                        final int offset2 = this.offset;
                        BytecodeManager.incBytecodes(4);
                        if (n4 >= offset2) {
                            break;
                        }
                        final Sink<? super E_OUT> downstream2 = this.downstream;
                        final long n5 = this.array[n3];
                        BytecodeManager.incBytecodes(7);
                        downstream2.accept(n5);
                        ++n3;
                        BytecodeManager.incBytecodes(2);
                    }
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    int n6 = 0;
                    BytecodeManager.incBytecodes(2);
                    while (true) {
                        final int n7 = n6;
                        final int offset3 = this.offset;
                        BytecodeManager.incBytecodes(4);
                        if (n7 >= offset3) {
                            break;
                        }
                        final Sink<? super E_OUT> downstream3 = this.downstream;
                        BytecodeManager.incBytecodes(3);
                        final boolean cancellationRequested = downstream3.cancellationRequested();
                        BytecodeManager.incBytecodes(1);
                        if (cancellationRequested) {
                            break;
                        }
                        final Sink<? super E_OUT> downstream4 = this.downstream;
                        final long n8 = this.array[n6];
                        BytecodeManager.incBytecodes(7);
                        downstream4.accept(n8);
                        ++n6;
                        BytecodeManager.incBytecodes(2);
                    }
                }
                final Sink<? super E_OUT> downstream5 = this.downstream;
                BytecodeManager.incBytecodes(3);
                downstream5.end();
                this.array = null;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void accept(final long n) {
            try {
                this.array[this.offset++] = n;
                BytecodeManager.incBytecodes(11);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private static final class LongSortingSink extends AbstractLongSortingSink
    {
        private SpinedBuffer.OfLong b;
        
        LongSortingSink(final Sink<? super Long> sink) {
            try {
                BytecodeManager.incBytecodes(3);
                super(sink);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void begin(final long n) {
            try {
                final long n2 = lcmp(n, 2147483639L);
                BytecodeManager.incBytecodes(4);
                if (n2 >= 0) {
                    final String s = "Stream size exceeds max array size";
                    BytecodeManager.incBytecodes(4);
                    final IllegalArgumentException ex = new IllegalArgumentException(s);
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final long n3 = lcmp(n, 0L);
                BytecodeManager.incBytecodes(5);
                SpinedBuffer.OfLong b;
                if (n3 > 0) {
                    final int n4;
                    b = new SpinedBuffer.OfLong(n4);
                    n4 = (int)n;
                    BytecodeManager.incBytecodes(5);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    b = new SpinedBuffer.OfLong();
                    BytecodeManager.incBytecodes(3);
                }
                this.b = b;
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void end() {
            try {
                final SpinedBuffer.OfLong b = this.b;
                BytecodeManager.incBytecodes(3);
                final long[] array = ((SpinedBuffer.OfPrimitive<E, long[], T_CONS>)b).asPrimitiveArray();
                BytecodeManager.incBytecodes(2);
                final long[] array2 = array;
                BytecodeManager.incBytecodes(2);
                Arrays.sort(array2);
                final Sink<? super E_OUT> downstream = this.downstream;
                final long n = array.length;
                BytecodeManager.incBytecodes(6);
                downstream.begin(n);
                final boolean cancellationWasRequested = this.cancellationWasRequested;
                BytecodeManager.incBytecodes(3);
                if (!cancellationWasRequested) {
                    final long[] array3 = array;
                    final int length = array3.length;
                    int n2 = 0;
                    BytecodeManager.incBytecodes(7);
                    while (true) {
                        final int n3 = n2;
                        final int n4 = length;
                        BytecodeManager.incBytecodes(3);
                        if (n3 >= n4) {
                            break;
                        }
                        final long n5 = array3[n2];
                        BytecodeManager.incBytecodes(4);
                        final Sink<? super E_OUT> downstream2 = this.downstream;
                        final long n6 = n5;
                        BytecodeManager.incBytecodes(4);
                        downstream2.accept(n6);
                        ++n2;
                        BytecodeManager.incBytecodes(2);
                    }
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    final long[] array4 = array;
                    final int length2 = array4.length;
                    int n7 = 0;
                    BytecodeManager.incBytecodes(7);
                    while (true) {
                        final int n8 = n7;
                        final int n9 = length2;
                        BytecodeManager.incBytecodes(3);
                        if (n8 >= n9) {
                            break;
                        }
                        final long n10 = array4[n7];
                        BytecodeManager.incBytecodes(4);
                        final Sink<? super E_OUT> downstream3 = this.downstream;
                        BytecodeManager.incBytecodes(3);
                        final boolean cancellationRequested = downstream3.cancellationRequested();
                        BytecodeManager.incBytecodes(1);
                        if (cancellationRequested) {
                            BytecodeManager.incBytecodes(1);
                            break;
                        }
                        final Sink<? super E_OUT> downstream4 = this.downstream;
                        final long n11 = n10;
                        BytecodeManager.incBytecodes(4);
                        downstream4.accept(n11);
                        ++n7;
                        BytecodeManager.incBytecodes(2);
                    }
                }
                final Sink<? super E_OUT> downstream5 = this.downstream;
                BytecodeManager.incBytecodes(3);
                downstream5.end();
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void accept(final long n) {
            try {
                final SpinedBuffer.OfLong b = this.b;
                BytecodeManager.incBytecodes(4);
                b.accept(n);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private abstract static class AbstractDoubleSortingSink extends Sink.ChainedDouble<Double>
    {
        protected boolean cancellationWasRequested;
        
        AbstractDoubleSortingSink(final Sink<? super Double> sink) {
            try {
                BytecodeManager.incBytecodes(3);
                super(sink);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final boolean cancellationRequested() {
            try {
                this.cancellationWasRequested = true;
                BytecodeManager.incBytecodes(3);
                final boolean b = false;
                BytecodeManager.incBytecodes(2);
                return b;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private static final class SizedDoubleSortingSink extends AbstractDoubleSortingSink
    {
        private double[] array;
        private int offset;
        
        SizedDoubleSortingSink(final Sink<? super Double> sink) {
            try {
                BytecodeManager.incBytecodes(3);
                super(sink);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void begin(final long n) {
            try {
                final long n2 = lcmp(n, 2147483639L);
                BytecodeManager.incBytecodes(4);
                if (n2 >= 0) {
                    final String s = "Stream size exceeds max array size";
                    BytecodeManager.incBytecodes(4);
                    final IllegalArgumentException ex = new IllegalArgumentException(s);
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                this.array = new double[(int)n];
                BytecodeManager.incBytecodes(4);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void end() {
            try {
                final double[] array = this.array;
                final int n = 0;
                final int offset = this.offset;
                BytecodeManager.incBytecodes(6);
                Arrays.sort(array, n, offset);
                final Sink<? super E_OUT> downstream = this.downstream;
                final long n2 = this.offset;
                BytecodeManager.incBytecodes(6);
                downstream.begin(n2);
                final boolean cancellationWasRequested = this.cancellationWasRequested;
                BytecodeManager.incBytecodes(3);
                if (!cancellationWasRequested) {
                    int n3 = 0;
                    BytecodeManager.incBytecodes(2);
                    while (true) {
                        final int n4 = n3;
                        final int offset2 = this.offset;
                        BytecodeManager.incBytecodes(4);
                        if (n4 >= offset2) {
                            break;
                        }
                        final Sink<? super E_OUT> downstream2 = this.downstream;
                        final double n5 = this.array[n3];
                        BytecodeManager.incBytecodes(7);
                        downstream2.accept(n5);
                        ++n3;
                        BytecodeManager.incBytecodes(2);
                    }
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    int n6 = 0;
                    BytecodeManager.incBytecodes(2);
                    while (true) {
                        final int n7 = n6;
                        final int offset3 = this.offset;
                        BytecodeManager.incBytecodes(4);
                        if (n7 >= offset3) {
                            break;
                        }
                        final Sink<? super E_OUT> downstream3 = this.downstream;
                        BytecodeManager.incBytecodes(3);
                        final boolean cancellationRequested = downstream3.cancellationRequested();
                        BytecodeManager.incBytecodes(1);
                        if (cancellationRequested) {
                            break;
                        }
                        final Sink<? super E_OUT> downstream4 = this.downstream;
                        final double n8 = this.array[n6];
                        BytecodeManager.incBytecodes(7);
                        downstream4.accept(n8);
                        ++n6;
                        BytecodeManager.incBytecodes(2);
                    }
                }
                final Sink<? super E_OUT> downstream5 = this.downstream;
                BytecodeManager.incBytecodes(3);
                downstream5.end();
                this.array = null;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void accept(final double n) {
            try {
                this.array[this.offset++] = n;
                BytecodeManager.incBytecodes(11);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private static final class DoubleSortingSink extends AbstractDoubleSortingSink
    {
        private SpinedBuffer.OfDouble b;
        
        DoubleSortingSink(final Sink<? super Double> sink) {
            try {
                BytecodeManager.incBytecodes(3);
                super(sink);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void begin(final long n) {
            try {
                final long n2 = lcmp(n, 2147483639L);
                BytecodeManager.incBytecodes(4);
                if (n2 >= 0) {
                    final String s = "Stream size exceeds max array size";
                    BytecodeManager.incBytecodes(4);
                    final IllegalArgumentException ex = new IllegalArgumentException(s);
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final long n3 = lcmp(n, 0L);
                BytecodeManager.incBytecodes(5);
                SpinedBuffer.OfDouble b;
                if (n3 > 0) {
                    final int n4;
                    b = new SpinedBuffer.OfDouble(n4);
                    n4 = (int)n;
                    BytecodeManager.incBytecodes(5);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    b = new SpinedBuffer.OfDouble();
                    BytecodeManager.incBytecodes(3);
                }
                this.b = b;
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void end() {
            try {
                final SpinedBuffer.OfDouble b = this.b;
                BytecodeManager.incBytecodes(3);
                final double[] array = ((SpinedBuffer.OfPrimitive<E, double[], T_CONS>)b).asPrimitiveArray();
                BytecodeManager.incBytecodes(2);
                final double[] array2 = array;
                BytecodeManager.incBytecodes(2);
                Arrays.sort(array2);
                final Sink<? super E_OUT> downstream = this.downstream;
                final long n = array.length;
                BytecodeManager.incBytecodes(6);
                downstream.begin(n);
                final boolean cancellationWasRequested = this.cancellationWasRequested;
                BytecodeManager.incBytecodes(3);
                if (!cancellationWasRequested) {
                    final double[] array3 = array;
                    final int length = array3.length;
                    int n2 = 0;
                    BytecodeManager.incBytecodes(7);
                    while (true) {
                        final int n3 = n2;
                        final int n4 = length;
                        BytecodeManager.incBytecodes(3);
                        if (n3 >= n4) {
                            break;
                        }
                        final double n5 = array3[n2];
                        BytecodeManager.incBytecodes(4);
                        final Sink<? super E_OUT> downstream2 = this.downstream;
                        final double n6 = n5;
                        BytecodeManager.incBytecodes(4);
                        downstream2.accept(n6);
                        ++n2;
                        BytecodeManager.incBytecodes(2);
                    }
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    final double[] array4 = array;
                    final int length2 = array4.length;
                    int n7 = 0;
                    BytecodeManager.incBytecodes(7);
                    while (true) {
                        final int n8 = n7;
                        final int n9 = length2;
                        BytecodeManager.incBytecodes(3);
                        if (n8 >= n9) {
                            break;
                        }
                        final double n10 = array4[n7];
                        BytecodeManager.incBytecodes(4);
                        final Sink<? super E_OUT> downstream3 = this.downstream;
                        BytecodeManager.incBytecodes(3);
                        final boolean cancellationRequested = downstream3.cancellationRequested();
                        BytecodeManager.incBytecodes(1);
                        if (cancellationRequested) {
                            BytecodeManager.incBytecodes(1);
                            break;
                        }
                        final Sink<? super E_OUT> downstream4 = this.downstream;
                        final double n11 = n10;
                        BytecodeManager.incBytecodes(4);
                        downstream4.accept(n11);
                        ++n7;
                        BytecodeManager.incBytecodes(2);
                    }
                }
                final Sink<? super E_OUT> downstream5 = this.downstream;
                BytecodeManager.incBytecodes(3);
                downstream5.end();
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void accept(final double n) {
            try {
                final SpinedBuffer.OfDouble b = this.b;
                BytecodeManager.incBytecodes(4);
                b.accept(n);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
}
