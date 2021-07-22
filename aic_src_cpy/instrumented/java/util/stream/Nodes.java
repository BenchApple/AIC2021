// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.stream;

import instrumented.java.util.function.BinaryOperator;
import instrumented.java.util.function.LongFunction;
import instrumented.java.util.concurrent.CountedCompleter;
import instrumented.java.util.ArrayDeque;
import instrumented.java.util.Deque;
import instrumented.java.util.Objects;
import java.util.Iterator;
import instrumented.java.util.Arrays;
import instrumented.java.util.function.DoubleConsumer;
import instrumented.java.util.function.LongConsumer;
import instrumented.java.util.function.IntConsumer;
import instrumented.java.util.Spliterators;
import instrumented.java.util.function.Consumer;
import instrumented.java.util.Spliterator;
import instrumented.java.util.function.IntFunction;
import instrumented.java.util.Collection;
import aic2021.engine.BytecodeManager;

final class Nodes
{
    static final long MAX_ARRAY_SIZE = 2147483639L;
    static final String BAD_SIZE = "Stream size exceeds max array size";
    private static final Node EMPTY_NODE;
    private static final Node.OfInt EMPTY_INT_NODE;
    private static final Node.OfLong EMPTY_LONG_NODE;
    private static final Node.OfDouble EMPTY_DOUBLE_NODE;
    private static final int[] EMPTY_INT_ARRAY;
    private static final long[] EMPTY_LONG_ARRAY;
    private static final double[] EMPTY_DOUBLE_ARRAY;
    
    private Nodes() {
        try {
            BytecodeManager.incBytecodes(2);
            final String message = "no instances";
            BytecodeManager.incBytecodes(4);
            final Error error = new Error(message);
            BytecodeManager.incBytecodes(1);
            throw error;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static <T> Node<T> emptyNode(final StreamShape obj) {
        try {
            final int[] $SwitchMap$java$util$stream$StreamShape = Nodes$1.$SwitchMap$java$util$stream$StreamShape;
            BytecodeManager.incBytecodes(3);
            final int n = $SwitchMap$java$util$stream$StreamShape[obj.ordinal()];
            BytecodeManager.incBytecodes(2);
            switch (n) {
                case 1: {
                    final Node empty_NODE = Nodes.EMPTY_NODE;
                    BytecodeManager.incBytecodes(2);
                    return (Node<T>)empty_NODE;
                }
                case 2: {
                    final Node.OfInt empty_INT_NODE = Nodes.EMPTY_INT_NODE;
                    BytecodeManager.incBytecodes(2);
                    return (Node<T>)empty_INT_NODE;
                }
                case 3: {
                    final Node.OfLong empty_LONG_NODE = Nodes.EMPTY_LONG_NODE;
                    BytecodeManager.incBytecodes(2);
                    return (Node<T>)empty_LONG_NODE;
                }
                case 4: {
                    final Node.OfDouble empty_DOUBLE_NODE = Nodes.EMPTY_DOUBLE_NODE;
                    BytecodeManager.incBytecodes(2);
                    return (Node<T>)empty_DOUBLE_NODE;
                }
                default: {
                    BytecodeManager.incBytecodes(5);
                    final StringBuilder sb = new StringBuilder();
                    final String str = "Unknown shape ";
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append = sb.append(str);
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append2 = append.append(obj);
                    BytecodeManager.incBytecodes(1);
                    final String string = append2.toString();
                    BytecodeManager.incBytecodes(1);
                    final IllegalStateException ex = new IllegalStateException(string);
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static <T> Node<T> conc(final StreamShape obj, final Node<T> node, final Node<T> node2) {
        try {
            final int[] $SwitchMap$java$util$stream$StreamShape = Nodes$1.$SwitchMap$java$util$stream$StreamShape;
            BytecodeManager.incBytecodes(3);
            final int n = $SwitchMap$java$util$stream$StreamShape[obj.ordinal()];
            BytecodeManager.incBytecodes(2);
            switch (n) {
                case 1: {
                    BytecodeManager.incBytecodes(5);
                    final ConcNode concNode = new ConcNode((Node<Object>)node, (Node<Object>)node2);
                    BytecodeManager.incBytecodes(1);
                    return (Node<T>)concNode;
                }
                case 2: {
                    final Node.OfInt ofInt = (Node.OfInt)node;
                    final Node.OfInt ofInt2 = (Node.OfInt)node2;
                    BytecodeManager.incBytecodes(7);
                    final ConcNode.OfInt ofInt3 = new ConcNode.OfInt(ofInt, ofInt2);
                    BytecodeManager.incBytecodes(1);
                    return (Node<T>)ofInt3;
                }
                case 3: {
                    final Node.OfLong ofLong = (Node.OfLong)node;
                    final Node.OfLong ofLong2 = (Node.OfLong)node2;
                    BytecodeManager.incBytecodes(7);
                    final ConcNode.OfLong ofLong3 = new ConcNode.OfLong(ofLong, ofLong2);
                    BytecodeManager.incBytecodes(1);
                    return (Node<T>)ofLong3;
                }
                case 4: {
                    final Node.OfDouble ofDouble = (Node.OfDouble)node;
                    final Node.OfDouble ofDouble2 = (Node.OfDouble)node2;
                    BytecodeManager.incBytecodes(7);
                    final ConcNode.OfDouble ofDouble3 = new ConcNode.OfDouble(ofDouble, ofDouble2);
                    BytecodeManager.incBytecodes(1);
                    return (Node<T>)ofDouble3;
                }
                default: {
                    BytecodeManager.incBytecodes(5);
                    final StringBuilder sb = new StringBuilder();
                    final String str = "Unknown shape ";
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append = sb.append(str);
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append2 = append.append(obj);
                    BytecodeManager.incBytecodes(1);
                    final String string = append2.toString();
                    BytecodeManager.incBytecodes(1);
                    final IllegalStateException ex = new IllegalStateException(string);
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static <T> Node<T> node(final T[] array) {
        try {
            BytecodeManager.incBytecodes(4);
            final ArrayNode<T> arrayNode = new ArrayNode<T>(array);
            BytecodeManager.incBytecodes(1);
            return arrayNode;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static <T> Node<T> node(final Collection<T> collection) {
        try {
            BytecodeManager.incBytecodes(4);
            final CollectionNode<T> collectionNode = new CollectionNode<T>(collection);
            BytecodeManager.incBytecodes(1);
            return collectionNode;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static <T> Node.Builder<T> builder(final long n, final IntFunction<T[]> intFunction) {
        try {
            final long n2 = lcmp(n, 0L);
            BytecodeManager.incBytecodes(4);
            Node.Builder<T> builder = null;
            Label_0054: {
                if (n2 >= 0) {
                    final long n3 = lcmp(n, 2147483639L);
                    BytecodeManager.incBytecodes(4);
                    if (n3 < 0) {
                        builder = new FixedNodeBuilder<T>(n, intFunction);
                        BytecodeManager.incBytecodes(5);
                        BytecodeManager.incBytecodes(1);
                        break Label_0054;
                    }
                }
                BytecodeManager.incBytecodes(1);
                builder = builder();
            }
            BytecodeManager.incBytecodes(1);
            return builder;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static <T> Node.Builder<T> builder() {
        try {
            BytecodeManager.incBytecodes(3);
            final SpinedNodeBuilder<T> spinedNodeBuilder = new SpinedNodeBuilder<T>();
            BytecodeManager.incBytecodes(1);
            return spinedNodeBuilder;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static Node.OfInt node(final int[] array) {
        try {
            BytecodeManager.incBytecodes(4);
            final IntArrayNode intArrayNode = new IntArrayNode(array);
            BytecodeManager.incBytecodes(1);
            return intArrayNode;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static Node.Builder.OfInt intBuilder(final long n) {
        try {
            final long n2 = lcmp(n, 0L);
            BytecodeManager.incBytecodes(4);
            Node.Builder.OfInt intBuilder = null;
            Label_0053: {
                if (n2 >= 0) {
                    final long n3 = lcmp(n, 2147483639L);
                    BytecodeManager.incBytecodes(4);
                    if (n3 < 0) {
                        intBuilder = new IntFixedNodeBuilder(n);
                        BytecodeManager.incBytecodes(4);
                        BytecodeManager.incBytecodes(1);
                        break Label_0053;
                    }
                }
                BytecodeManager.incBytecodes(1);
                intBuilder = intBuilder();
            }
            BytecodeManager.incBytecodes(1);
            return intBuilder;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static Node.Builder.OfInt intBuilder() {
        try {
            BytecodeManager.incBytecodes(3);
            final IntSpinedNodeBuilder intSpinedNodeBuilder = new IntSpinedNodeBuilder();
            BytecodeManager.incBytecodes(1);
            return intSpinedNodeBuilder;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static Node.OfLong node(final long[] array) {
        try {
            BytecodeManager.incBytecodes(4);
            final LongArrayNode longArrayNode = new LongArrayNode(array);
            BytecodeManager.incBytecodes(1);
            return longArrayNode;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static Node.Builder.OfLong longBuilder(final long n) {
        try {
            final long n2 = lcmp(n, 0L);
            BytecodeManager.incBytecodes(4);
            Node.Builder.OfLong longBuilder = null;
            Label_0053: {
                if (n2 >= 0) {
                    final long n3 = lcmp(n, 2147483639L);
                    BytecodeManager.incBytecodes(4);
                    if (n3 < 0) {
                        longBuilder = new LongFixedNodeBuilder(n);
                        BytecodeManager.incBytecodes(4);
                        BytecodeManager.incBytecodes(1);
                        break Label_0053;
                    }
                }
                BytecodeManager.incBytecodes(1);
                longBuilder = longBuilder();
            }
            BytecodeManager.incBytecodes(1);
            return longBuilder;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static Node.Builder.OfLong longBuilder() {
        try {
            BytecodeManager.incBytecodes(3);
            final LongSpinedNodeBuilder longSpinedNodeBuilder = new LongSpinedNodeBuilder();
            BytecodeManager.incBytecodes(1);
            return longSpinedNodeBuilder;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static Node.OfDouble node(final double[] array) {
        try {
            BytecodeManager.incBytecodes(4);
            final DoubleArrayNode doubleArrayNode = new DoubleArrayNode(array);
            BytecodeManager.incBytecodes(1);
            return doubleArrayNode;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static Node.Builder.OfDouble doubleBuilder(final long n) {
        try {
            final long n2 = lcmp(n, 0L);
            BytecodeManager.incBytecodes(4);
            Node.Builder.OfDouble doubleBuilder = null;
            Label_0053: {
                if (n2 >= 0) {
                    final long n3 = lcmp(n, 2147483639L);
                    BytecodeManager.incBytecodes(4);
                    if (n3 < 0) {
                        doubleBuilder = new DoubleFixedNodeBuilder(n);
                        BytecodeManager.incBytecodes(4);
                        BytecodeManager.incBytecodes(1);
                        break Label_0053;
                    }
                }
                BytecodeManager.incBytecodes(1);
                doubleBuilder = doubleBuilder();
            }
            BytecodeManager.incBytecodes(1);
            return doubleBuilder;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static Node.Builder.OfDouble doubleBuilder() {
        try {
            BytecodeManager.incBytecodes(3);
            final DoubleSpinedNodeBuilder doubleSpinedNodeBuilder = new DoubleSpinedNodeBuilder();
            BytecodeManager.incBytecodes(1);
            return doubleSpinedNodeBuilder;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <P_IN, P_OUT> Node<P_OUT> collect(final PipelineHelper<P_OUT> pipelineHelper, final Spliterator<P_IN> spliterator, final boolean b, final IntFunction<P_OUT[]> intFunction) {
        try {
            BytecodeManager.incBytecodes(3);
            final long exactOutputSizeIfKnown = pipelineHelper.exactOutputSizeIfKnown(spliterator);
            BytecodeManager.incBytecodes(1);
            final long n = lcmp(exactOutputSizeIfKnown, 0L);
            BytecodeManager.incBytecodes(4);
            if (n >= 0) {
                final int n2 = 16384;
                BytecodeManager.incBytecodes(3);
                final boolean hasCharacteristics = spliterator.hasCharacteristics(n2);
                BytecodeManager.incBytecodes(1);
                if (hasCharacteristics) {
                    final long n3 = lcmp(exactOutputSizeIfKnown, 2147483639L);
                    BytecodeManager.incBytecodes(4);
                    if (n3 >= 0) {
                        final String s = "Stream size exceeds max array size";
                        BytecodeManager.incBytecodes(4);
                        final IllegalArgumentException ex = new IllegalArgumentException(s);
                        BytecodeManager.incBytecodes(1);
                        throw ex;
                    }
                    final int n4 = (int)exactOutputSizeIfKnown;
                    BytecodeManager.incBytecodes(4);
                    final P_OUT[] array = intFunction.apply(n4);
                    BytecodeManager.incBytecodes(2);
                    final P_OUT[] array2 = array;
                    BytecodeManager.incBytecodes(6);
                    final SizedCollectorTask.OfRef ofRef = new SizedCollectorTask.OfRef((Spliterator<Object>)spliterator, (PipelineHelper<Object>)pipelineHelper, array2);
                    BytecodeManager.incBytecodes(1);
                    ofRef.invoke();
                    BytecodeManager.incBytecodes(1);
                    final P_OUT[] array3 = array;
                    BytecodeManager.incBytecodes(2);
                    final Node<P_OUT> node = node(array3);
                    BytecodeManager.incBytecodes(1);
                    return node;
                }
            }
            BytecodeManager.incBytecodes(6);
            final CollectorTask.OfRef ofRef2 = new CollectorTask.OfRef(pipelineHelper, intFunction, spliterator);
            BytecodeManager.incBytecodes(1);
            final Node<T> node2 = ofRef2.invoke();
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            Node<P_OUT> flatten;
            if (b) {
                final Node<T> node3 = node2;
                BytecodeManager.incBytecodes(3);
                flatten = flatten((Node<P_OUT>)node3, intFunction);
                BytecodeManager.incBytecodes(1);
            }
            else {
                flatten = (Node<P_OUT>)node2;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return flatten;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <P_IN> Node.OfInt collectInt(final PipelineHelper<Integer> pipelineHelper, final Spliterator<P_IN> spliterator, final boolean b) {
        try {
            BytecodeManager.incBytecodes(3);
            final long exactOutputSizeIfKnown = pipelineHelper.exactOutputSizeIfKnown(spliterator);
            BytecodeManager.incBytecodes(1);
            final long n = lcmp(exactOutputSizeIfKnown, 0L);
            BytecodeManager.incBytecodes(4);
            if (n >= 0) {
                final int n2 = 16384;
                BytecodeManager.incBytecodes(3);
                final boolean hasCharacteristics = spliterator.hasCharacteristics(n2);
                BytecodeManager.incBytecodes(1);
                if (hasCharacteristics) {
                    final long n3 = lcmp(exactOutputSizeIfKnown, 2147483639L);
                    BytecodeManager.incBytecodes(4);
                    if (n3 >= 0) {
                        final String s = "Stream size exceeds max array size";
                        BytecodeManager.incBytecodes(4);
                        final IllegalArgumentException ex = new IllegalArgumentException(s);
                        BytecodeManager.incBytecodes(1);
                        throw ex;
                    }
                    final int[] array = new int[(int)exactOutputSizeIfKnown];
                    BytecodeManager.incBytecodes(3);
                    final int[] array2 = array;
                    BytecodeManager.incBytecodes(6);
                    final SizedCollectorTask.OfInt ofInt = new SizedCollectorTask.OfInt((Spliterator<Object>)spliterator, pipelineHelper, array2);
                    BytecodeManager.incBytecodes(1);
                    ofInt.invoke();
                    BytecodeManager.incBytecodes(1);
                    final int[] array3 = array;
                    BytecodeManager.incBytecodes(2);
                    final Node.OfInt node = node(array3);
                    BytecodeManager.incBytecodes(1);
                    return node;
                }
            }
            BytecodeManager.incBytecodes(5);
            final CollectorTask.OfInt<Node.OfInt> ofInt2 = new CollectorTask.OfInt<Node.OfInt>(pipelineHelper, (Spliterator<Node.OfInt>)spliterator);
            BytecodeManager.incBytecodes(1);
            final Node.OfInt ofInt3 = ofInt2.invoke();
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            Node.OfInt flattenInt;
            if (b) {
                final Node.OfInt ofInt4 = ofInt3;
                BytecodeManager.incBytecodes(2);
                flattenInt = flattenInt(ofInt4);
                BytecodeManager.incBytecodes(1);
            }
            else {
                flattenInt = ofInt3;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return flattenInt;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <P_IN> Node.OfLong collectLong(final PipelineHelper<Long> pipelineHelper, final Spliterator<P_IN> spliterator, final boolean b) {
        try {
            BytecodeManager.incBytecodes(3);
            final long exactOutputSizeIfKnown = pipelineHelper.exactOutputSizeIfKnown(spliterator);
            BytecodeManager.incBytecodes(1);
            final long n = lcmp(exactOutputSizeIfKnown, 0L);
            BytecodeManager.incBytecodes(4);
            if (n >= 0) {
                final int n2 = 16384;
                BytecodeManager.incBytecodes(3);
                final boolean hasCharacteristics = spliterator.hasCharacteristics(n2);
                BytecodeManager.incBytecodes(1);
                if (hasCharacteristics) {
                    final long n3 = lcmp(exactOutputSizeIfKnown, 2147483639L);
                    BytecodeManager.incBytecodes(4);
                    if (n3 >= 0) {
                        final String s = "Stream size exceeds max array size";
                        BytecodeManager.incBytecodes(4);
                        final IllegalArgumentException ex = new IllegalArgumentException(s);
                        BytecodeManager.incBytecodes(1);
                        throw ex;
                    }
                    final long[] array = new long[(int)exactOutputSizeIfKnown];
                    BytecodeManager.incBytecodes(3);
                    final long[] array2 = array;
                    BytecodeManager.incBytecodes(6);
                    final SizedCollectorTask.OfLong ofLong = new SizedCollectorTask.OfLong((Spliterator<Object>)spliterator, pipelineHelper, array2);
                    BytecodeManager.incBytecodes(1);
                    ofLong.invoke();
                    BytecodeManager.incBytecodes(1);
                    final long[] array3 = array;
                    BytecodeManager.incBytecodes(2);
                    final Node.OfLong node = node(array3);
                    BytecodeManager.incBytecodes(1);
                    return node;
                }
            }
            BytecodeManager.incBytecodes(5);
            final CollectorTask.OfLong<Node.OfLong> ofLong2 = new CollectorTask.OfLong<Node.OfLong>(pipelineHelper, (Spliterator<Node.OfLong>)spliterator);
            BytecodeManager.incBytecodes(1);
            final Node.OfLong ofLong3 = ofLong2.invoke();
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            Node.OfLong flattenLong;
            if (b) {
                final Node.OfLong ofLong4 = ofLong3;
                BytecodeManager.incBytecodes(2);
                flattenLong = flattenLong(ofLong4);
                BytecodeManager.incBytecodes(1);
            }
            else {
                flattenLong = ofLong3;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return flattenLong;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <P_IN> Node.OfDouble collectDouble(final PipelineHelper<Double> pipelineHelper, final Spliterator<P_IN> spliterator, final boolean b) {
        try {
            BytecodeManager.incBytecodes(3);
            final long exactOutputSizeIfKnown = pipelineHelper.exactOutputSizeIfKnown(spliterator);
            BytecodeManager.incBytecodes(1);
            final long n = lcmp(exactOutputSizeIfKnown, 0L);
            BytecodeManager.incBytecodes(4);
            if (n >= 0) {
                final int n2 = 16384;
                BytecodeManager.incBytecodes(3);
                final boolean hasCharacteristics = spliterator.hasCharacteristics(n2);
                BytecodeManager.incBytecodes(1);
                if (hasCharacteristics) {
                    final long n3 = lcmp(exactOutputSizeIfKnown, 2147483639L);
                    BytecodeManager.incBytecodes(4);
                    if (n3 >= 0) {
                        final String s = "Stream size exceeds max array size";
                        BytecodeManager.incBytecodes(4);
                        final IllegalArgumentException ex = new IllegalArgumentException(s);
                        BytecodeManager.incBytecodes(1);
                        throw ex;
                    }
                    final double[] array = new double[(int)exactOutputSizeIfKnown];
                    BytecodeManager.incBytecodes(3);
                    final double[] array2 = array;
                    BytecodeManager.incBytecodes(6);
                    final SizedCollectorTask.OfDouble ofDouble = new SizedCollectorTask.OfDouble((Spliterator<Object>)spliterator, pipelineHelper, array2);
                    BytecodeManager.incBytecodes(1);
                    ofDouble.invoke();
                    BytecodeManager.incBytecodes(1);
                    final double[] array3 = array;
                    BytecodeManager.incBytecodes(2);
                    final Node.OfDouble node = node(array3);
                    BytecodeManager.incBytecodes(1);
                    return node;
                }
            }
            BytecodeManager.incBytecodes(5);
            final CollectorTask.OfDouble<Node.OfDouble> ofDouble2 = new CollectorTask.OfDouble<Node.OfDouble>(pipelineHelper, (Spliterator<Node.OfDouble>)spliterator);
            BytecodeManager.incBytecodes(1);
            final Node.OfDouble ofDouble3 = ofDouble2.invoke();
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            Node.OfDouble flattenDouble;
            if (b) {
                final Node.OfDouble ofDouble4 = ofDouble3;
                BytecodeManager.incBytecodes(2);
                flattenDouble = flattenDouble(ofDouble4);
                BytecodeManager.incBytecodes(1);
            }
            else {
                flattenDouble = ofDouble3;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return flattenDouble;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T> Node<T> flatten(final Node<T> node, final IntFunction<T[]> intFunction) {
        try {
            BytecodeManager.incBytecodes(2);
            final int childCount = node.getChildCount();
            BytecodeManager.incBytecodes(1);
            if (childCount <= 0) {
                BytecodeManager.incBytecodes(2);
                return node;
            }
            BytecodeManager.incBytecodes(2);
            final long count = node.count();
            BytecodeManager.incBytecodes(1);
            final long n = lcmp(count, 2147483639L);
            BytecodeManager.incBytecodes(4);
            if (n >= 0) {
                final String s = "Stream size exceeds max array size";
                BytecodeManager.incBytecodes(4);
                final IllegalArgumentException ex = new IllegalArgumentException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final int n2 = (int)count;
            BytecodeManager.incBytecodes(4);
            final T[] array = intFunction.apply(n2);
            BytecodeManager.incBytecodes(2);
            final T[] array2 = array;
            final int n3 = 0;
            final Object object = null;
            BytecodeManager.incBytecodes(7);
            final ToArrayTask.OfRef ofRef = new ToArrayTask.OfRef((Node)node, (Object[])array2, n3);
            BytecodeManager.incBytecodes(1);
            ofRef.invoke();
            BytecodeManager.incBytecodes(1);
            final T[] array3 = array;
            BytecodeManager.incBytecodes(2);
            final Node<T> node2 = node(array3);
            BytecodeManager.incBytecodes(1);
            return node2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static Node.OfInt flattenInt(final Node.OfInt ofInt) {
        try {
            BytecodeManager.incBytecodes(2);
            final int childCount = ofInt.getChildCount();
            BytecodeManager.incBytecodes(1);
            if (childCount <= 0) {
                BytecodeManager.incBytecodes(2);
                return ofInt;
            }
            BytecodeManager.incBytecodes(2);
            final long count = ofInt.count();
            BytecodeManager.incBytecodes(1);
            final long n = lcmp(count, 2147483639L);
            BytecodeManager.incBytecodes(4);
            if (n >= 0) {
                final String s = "Stream size exceeds max array size";
                BytecodeManager.incBytecodes(4);
                final IllegalArgumentException ex = new IllegalArgumentException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final int[] array = new int[(int)count];
            BytecodeManager.incBytecodes(3);
            final int[] array2 = array;
            final int n2 = 0;
            final Object object = null;
            BytecodeManager.incBytecodes(7);
            final ToArrayTask.OfInt ofInt2 = new ToArrayTask.OfInt(ofInt, array2, n2);
            BytecodeManager.incBytecodes(1);
            ofInt2.invoke();
            BytecodeManager.incBytecodes(1);
            final int[] array3 = array;
            BytecodeManager.incBytecodes(2);
            final Node.OfInt node = node(array3);
            BytecodeManager.incBytecodes(1);
            return node;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static Node.OfLong flattenLong(final Node.OfLong ofLong) {
        try {
            BytecodeManager.incBytecodes(2);
            final int childCount = ofLong.getChildCount();
            BytecodeManager.incBytecodes(1);
            if (childCount <= 0) {
                BytecodeManager.incBytecodes(2);
                return ofLong;
            }
            BytecodeManager.incBytecodes(2);
            final long count = ofLong.count();
            BytecodeManager.incBytecodes(1);
            final long n = lcmp(count, 2147483639L);
            BytecodeManager.incBytecodes(4);
            if (n >= 0) {
                final String s = "Stream size exceeds max array size";
                BytecodeManager.incBytecodes(4);
                final IllegalArgumentException ex = new IllegalArgumentException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final long[] array = new long[(int)count];
            BytecodeManager.incBytecodes(3);
            final long[] array2 = array;
            final int n2 = 0;
            final Object object = null;
            BytecodeManager.incBytecodes(7);
            final ToArrayTask.OfLong ofLong2 = new ToArrayTask.OfLong(ofLong, array2, n2);
            BytecodeManager.incBytecodes(1);
            ofLong2.invoke();
            BytecodeManager.incBytecodes(1);
            final long[] array3 = array;
            BytecodeManager.incBytecodes(2);
            final Node.OfLong node = node(array3);
            BytecodeManager.incBytecodes(1);
            return node;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static Node.OfDouble flattenDouble(final Node.OfDouble ofDouble) {
        try {
            BytecodeManager.incBytecodes(2);
            final int childCount = ofDouble.getChildCount();
            BytecodeManager.incBytecodes(1);
            if (childCount <= 0) {
                BytecodeManager.incBytecodes(2);
                return ofDouble;
            }
            BytecodeManager.incBytecodes(2);
            final long count = ofDouble.count();
            BytecodeManager.incBytecodes(1);
            final long n = lcmp(count, 2147483639L);
            BytecodeManager.incBytecodes(4);
            if (n >= 0) {
                final String s = "Stream size exceeds max array size";
                BytecodeManager.incBytecodes(4);
                final IllegalArgumentException ex = new IllegalArgumentException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final double[] array = new double[(int)count];
            BytecodeManager.incBytecodes(3);
            final double[] array2 = array;
            final int n2 = 0;
            final Object object = null;
            BytecodeManager.incBytecodes(7);
            final ToArrayTask.OfDouble ofDouble2 = new ToArrayTask.OfDouble(ofDouble, array2, n2);
            BytecodeManager.incBytecodes(1);
            ofDouble2.invoke();
            BytecodeManager.incBytecodes(1);
            final double[] array3 = array;
            BytecodeManager.incBytecodes(2);
            final Node.OfDouble node = node(array3);
            BytecodeManager.incBytecodes(1);
            return node;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static /* synthetic */ int[] access$500() {
        try {
            final int[] empty_INT_ARRAY = Nodes.EMPTY_INT_ARRAY;
            BytecodeManager.incBytecodes(2);
            return empty_INT_ARRAY;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static /* synthetic */ long[] access$600() {
        try {
            final long[] empty_LONG_ARRAY = Nodes.EMPTY_LONG_ARRAY;
            BytecodeManager.incBytecodes(2);
            return empty_LONG_ARRAY;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static /* synthetic */ double[] access$700() {
        try {
            final double[] empty_DOUBLE_ARRAY = Nodes.EMPTY_DOUBLE_ARRAY;
            BytecodeManager.incBytecodes(2);
            return empty_DOUBLE_ARRAY;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static {
        try {
            final Object object = null;
            BytecodeManager.incBytecodes(4);
            EMPTY_NODE = new EmptyNode.OfRef();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            EMPTY_INT_NODE = new EmptyNode.OfInt();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            EMPTY_LONG_NODE = new EmptyNode.OfLong();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            EMPTY_DOUBLE_NODE = new EmptyNode.OfDouble();
            BytecodeManager.incBytecodes(1);
            EMPTY_INT_ARRAY = new int[0];
            BytecodeManager.incBytecodes(2);
            EMPTY_LONG_ARRAY = new long[0];
            BytecodeManager.incBytecodes(2);
            EMPTY_DOUBLE_ARRAY = new double[0];
            BytecodeManager.incBytecodes(3);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private abstract static class EmptyNode<T, T_ARR, T_CONS> implements Node<T>
    {
        EmptyNode() {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public T[] asArray(final IntFunction<T[]> intFunction) {
            try {
                final int n = 0;
                BytecodeManager.incBytecodes(3);
                final T[] array = intFunction.apply(n);
                BytecodeManager.incBytecodes(2);
                return array;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public void copyInto(final T_ARR t_ARR, final int n) {
            try {
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public long count() {
            try {
                final long n = 0L;
                BytecodeManager.incBytecodes(2);
                return n;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public void forEach(final T_CONS t_CONS) {
            try {
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private static class OfRef<T> extends EmptyNode<T, T[], Consumer<? super T>>
        {
            private OfRef() {
                try {
                    BytecodeManager.incBytecodes(2);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public Spliterator<T> spliterator() {
                try {
                    BytecodeManager.incBytecodes(1);
                    final Spliterator<T> emptySpliterator = Spliterators.emptySpliterator();
                    BytecodeManager.incBytecodes(1);
                    return emptySpliterator;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
        
        private static final class OfInt extends EmptyNode<Integer, int[], IntConsumer> implements Node.OfInt
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
            public Spliterator.OfInt spliterator() {
                try {
                    BytecodeManager.incBytecodes(1);
                    final Spliterator.OfInt emptyIntSpliterator = Spliterators.emptyIntSpliterator();
                    BytecodeManager.incBytecodes(1);
                    return emptyIntSpliterator;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public int[] asPrimitiveArray() {
                try {
                    BytecodeManager.incBytecodes(1);
                    final int[] access$500 = Nodes.access$500();
                    BytecodeManager.incBytecodes(1);
                    return access$500;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
        
        private static final class OfLong extends EmptyNode<Long, long[], LongConsumer> implements Node.OfLong
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
            public Spliterator.OfLong spliterator() {
                try {
                    BytecodeManager.incBytecodes(1);
                    final Spliterator.OfLong emptyLongSpliterator = Spliterators.emptyLongSpliterator();
                    BytecodeManager.incBytecodes(1);
                    return emptyLongSpliterator;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public long[] asPrimitiveArray() {
                try {
                    BytecodeManager.incBytecodes(1);
                    final long[] access$600 = Nodes.access$600();
                    BytecodeManager.incBytecodes(1);
                    return access$600;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
        
        private static final class OfDouble extends EmptyNode<Double, double[], DoubleConsumer> implements Node.OfDouble
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
            public Spliterator.OfDouble spliterator() {
                try {
                    BytecodeManager.incBytecodes(1);
                    final Spliterator.OfDouble emptyDoubleSpliterator = Spliterators.emptyDoubleSpliterator();
                    BytecodeManager.incBytecodes(1);
                    return emptyDoubleSpliterator;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public double[] asPrimitiveArray() {
                try {
                    BytecodeManager.incBytecodes(1);
                    final double[] access$700 = Nodes.access$700();
                    BytecodeManager.incBytecodes(1);
                    return access$700;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
    }
    
    private static class ArrayNode<T> implements Node<T>
    {
        final T[] array;
        int curSize;
        
        ArrayNode(final long n, final IntFunction<T[]> intFunction) {
            try {
                BytecodeManager.incBytecodes(2);
                final long n2 = lcmp(n, 2147483639L);
                BytecodeManager.incBytecodes(4);
                if (n2 >= 0) {
                    final String s = "Stream size exceeds max array size";
                    BytecodeManager.incBytecodes(4);
                    final IllegalArgumentException ex = new IllegalArgumentException(s);
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final int n3 = (int)n;
                BytecodeManager.incBytecodes(5);
                this.array = intFunction.apply(n3);
                BytecodeManager.incBytecodes(2);
                this.curSize = 0;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        ArrayNode(final T[] array) {
            try {
                BytecodeManager.incBytecodes(2);
                this.array = array;
                BytecodeManager.incBytecodes(3);
                this.curSize = array.length;
                BytecodeManager.incBytecodes(4);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Spliterator<T> spliterator() {
            try {
                final T[] array = this.array;
                final int n = 0;
                final int curSize = this.curSize;
                BytecodeManager.incBytecodes(6);
                final Spliterator<T> spliterator = Arrays.spliterator(array, n, curSize);
                BytecodeManager.incBytecodes(1);
                return spliterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void copyInto(final T[] array, final int n) {
            try {
                final T[] array2 = this.array;
                final int n2 = 0;
                final int curSize = this.curSize;
                BytecodeManager.incBytecodes(8);
                System.arraycopy(array2, n2, array, n, curSize);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public T[] asArray(final IntFunction<T[]> intFunction) {
            try {
                final int length = this.array.length;
                final int curSize = this.curSize;
                BytecodeManager.incBytecodes(6);
                if (length == curSize) {
                    final T[] array = this.array;
                    BytecodeManager.incBytecodes(3);
                    return array;
                }
                BytecodeManager.incBytecodes(3);
                final IllegalStateException ex = new IllegalStateException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public long count() {
            try {
                final long n = this.curSize;
                BytecodeManager.incBytecodes(4);
                return n;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void forEach(final Consumer<? super T> consumer) {
            try {
                int n = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n2 = n;
                    final int curSize = this.curSize;
                    BytecodeManager.incBytecodes(4);
                    if (n2 >= curSize) {
                        break;
                    }
                    final T t = this.array[n];
                    BytecodeManager.incBytecodes(6);
                    consumer.accept(t);
                    ++n;
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public String toString() {
            try {
                final String format = "ArrayNode[%d][%s]";
                final Object[] args = new Object[2];
                final int n = 0;
                final int i = this.array.length - this.curSize;
                BytecodeManager.incBytecodes(10);
                BytecodeManager.incBytecodes(1);
                args[n] = i;
                final int n2 = 1;
                final T[] array = this.array;
                BytecodeManager.incBytecodes(6);
                args[n2] = Arrays.toString(array);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                final String format2 = String.format(format, args);
                BytecodeManager.incBytecodes(1);
                return format2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private static final class CollectionNode<T> implements Node<T>
    {
        private final Collection<T> c;
        
        CollectionNode(final Collection<T> c) {
            try {
                BytecodeManager.incBytecodes(2);
                this.c = c;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Spliterator<T> spliterator() {
            try {
                final Collection<T> c = this.c;
                BytecodeManager.incBytecodes(3);
                final Stream<T> stream = c.stream();
                BytecodeManager.incBytecodes(1);
                final Spliterator<T> spliterator = stream.spliterator();
                BytecodeManager.incBytecodes(1);
                return spliterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void copyInto(final T[] array, int n) {
            try {
                final Collection<T> c = this.c;
                BytecodeManager.incBytecodes(3);
                final Iterator<T> iterator = c.iterator();
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
                    array[n++] = next;
                    BytecodeManager.incBytecodes(6);
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public T[] asArray(final IntFunction<T[]> intFunction) {
            try {
                final Collection<T> c = this.c;
                final Collection<T> c2 = this.c;
                BytecodeManager.incBytecodes(6);
                final int size = c2.size();
                BytecodeManager.incBytecodes(1);
                final T[] array = intFunction.apply(size);
                BytecodeManager.incBytecodes(2);
                final T[] array2 = c.toArray(array);
                BytecodeManager.incBytecodes(1);
                return array2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public long count() {
            try {
                final Collection<T> c = this.c;
                BytecodeManager.incBytecodes(3);
                final long n = c.size();
                BytecodeManager.incBytecodes(2);
                return n;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void forEach(final Consumer<? super T> consumer) {
            try {
                final Collection<T> c = this.c;
                BytecodeManager.incBytecodes(4);
                c.forEach((Consumer)consumer);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public String toString() {
            try {
                final String format = "CollectionNode[%d][%s]";
                final Object[] args = new Object[2];
                final int n = 0;
                final Collection<T> c = this.c;
                BytecodeManager.incBytecodes(7);
                final int size = c.size();
                BytecodeManager.incBytecodes(1);
                args[n] = size;
                args[1] = this.c;
                BytecodeManager.incBytecodes(7);
                final String format2 = String.format(format, args);
                BytecodeManager.incBytecodes(1);
                return format2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private abstract static class AbstractConcNode<T, T_NODE extends Node<T>> implements Node<T>
    {
        protected final T_NODE left;
        protected final T_NODE right;
        private final long size;
        
        AbstractConcNode(final T_NODE left, final T_NODE right) {
            try {
                BytecodeManager.incBytecodes(2);
                this.left = left;
                BytecodeManager.incBytecodes(3);
                this.right = right;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(3);
                final long count = left.count();
                BytecodeManager.incBytecodes(2);
                this.size = count + right.count();
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int getChildCount() {
            try {
                final int n = 2;
                BytecodeManager.incBytecodes(2);
                return n;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public T_NODE getChild(final int n) {
            try {
                BytecodeManager.incBytecodes(2);
                if (n == 0) {
                    final Node<T> left = this.left;
                    BytecodeManager.incBytecodes(3);
                    return (T_NODE)left;
                }
                final int n2 = 1;
                BytecodeManager.incBytecodes(3);
                if (n == n2) {
                    final Node<T> right = this.right;
                    BytecodeManager.incBytecodes(3);
                    return (T_NODE)right;
                }
                BytecodeManager.incBytecodes(3);
                final IndexOutOfBoundsException ex = new IndexOutOfBoundsException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public long count() {
            try {
                final long size = this.size;
                BytecodeManager.incBytecodes(3);
                return size;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class ConcNode<T> extends AbstractConcNode<T, Node<T>> implements Node<T>
    {
        ConcNode(final Node<T> node, final Node<T> node2) {
            try {
                BytecodeManager.incBytecodes(4);
                super(node, node2);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Spliterator<T> spliterator() {
            try {
                BytecodeManager.incBytecodes(4);
                final InternalNodeSpliterator.OfRef ofRef = new InternalNodeSpliterator.OfRef(this);
                BytecodeManager.incBytecodes(1);
                return (Spliterator<T>)ofRef;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void copyInto(final T[] array, final int n) {
            try {
                BytecodeManager.incBytecodes(2);
                Objects.requireNonNull(array);
                BytecodeManager.incBytecodes(1);
                final Node<T> left = this.left;
                BytecodeManager.incBytecodes(5);
                left.copyInto((T[])array, n);
                final Node<T> right = this.right;
                final Node<T> left2 = this.left;
                BytecodeManager.incBytecodes(7);
                final int n2 = n + (int)left2.count();
                BytecodeManager.incBytecodes(3);
                right.copyInto((T[])array, n2);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public T[] asArray(final IntFunction<T[]> intFunction) {
            try {
                BytecodeManager.incBytecodes(2);
                final long count = this.count();
                BytecodeManager.incBytecodes(1);
                final long n = lcmp(count, 2147483639L);
                BytecodeManager.incBytecodes(4);
                if (n >= 0) {
                    final String s = "Stream size exceeds max array size";
                    BytecodeManager.incBytecodes(4);
                    final IllegalArgumentException ex = new IllegalArgumentException(s);
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final int n2 = (int)count;
                BytecodeManager.incBytecodes(4);
                final T[] array = intFunction.apply(n2);
                BytecodeManager.incBytecodes(2);
                final T[] array2 = array;
                final int n3 = 0;
                BytecodeManager.incBytecodes(4);
                this.copyInto(array2, n3);
                final T[] array3 = array;
                BytecodeManager.incBytecodes(2);
                return array3;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void forEach(final Consumer<? super T> consumer) {
            try {
                final Node<T> left = this.left;
                BytecodeManager.incBytecodes(4);
                left.forEach((Consumer<? super T>)consumer);
                final Node<T> right = this.right;
                BytecodeManager.incBytecodes(4);
                right.forEach((Consumer<? super T>)consumer);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Node<T> truncate(final long n, final long n2, final IntFunction<T[]> intFunction) {
            try {
                final long n3 = lcmp(n, 0L);
                BytecodeManager.incBytecodes(4);
                if (n3 == 0) {
                    BytecodeManager.incBytecodes(3);
                    final long n4 = lcmp(n2, this.count());
                    BytecodeManager.incBytecodes(2);
                    if (n4 == 0) {
                        BytecodeManager.incBytecodes(2);
                        return this;
                    }
                }
                final Node<T> left = this.left;
                BytecodeManager.incBytecodes(3);
                final long count = left.count();
                BytecodeManager.incBytecodes(1);
                final long n5 = lcmp(n, count);
                BytecodeManager.incBytecodes(4);
                if (n5 >= 0) {
                    final Node<T> right = this.right;
                    final long n6 = n - count;
                    final long n7 = n2 - count;
                    BytecodeManager.incBytecodes(10);
                    final Node<T> truncate = right.truncate(n6, n7, intFunction);
                    BytecodeManager.incBytecodes(1);
                    return truncate;
                }
                final long n8 = lcmp(n2, count);
                BytecodeManager.incBytecodes(4);
                if (n8 <= 0) {
                    final Node<T> left2 = this.left;
                    BytecodeManager.incBytecodes(6);
                    final Node<T> truncate2 = left2.truncate(n, n2, intFunction);
                    BytecodeManager.incBytecodes(1);
                    return truncate2;
                }
                BytecodeManager.incBytecodes(2);
                final StreamShape shape = this.getShape();
                final Node<T> left3 = this.left;
                final long n9 = count;
                BytecodeManager.incBytecodes(6);
                final Node<T> truncate3 = left3.truncate(n, n9, intFunction);
                final Node<T> right2 = this.right;
                final long n10 = 0L;
                final long n11 = n2 - count;
                BytecodeManager.incBytecodes(7);
                BytecodeManager.incBytecodes(1);
                final Node<T> truncate4 = right2.truncate(n10, n11, intFunction);
                BytecodeManager.incBytecodes(1);
                final Node<T> conc = Nodes.conc(shape, truncate3, truncate4);
                BytecodeManager.incBytecodes(1);
                return conc;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public String toString() {
            try {
                BytecodeManager.incBytecodes(2);
                final long n = lcmp(this.count(), 32L);
                BytecodeManager.incBytecodes(3);
                if (n < 0) {
                    final String format = "ConcNode[%s.%s]";
                    final Object[] args = { this.left, this.right };
                    BytecodeManager.incBytecodes(13);
                    final String format2 = String.format(format, args);
                    BytecodeManager.incBytecodes(1);
                    return format2;
                }
                final String format3 = "ConcNode[size=%d]";
                final Object[] args2 = { null };
                final int n2 = 0;
                BytecodeManager.incBytecodes(6);
                final long count = this.count();
                BytecodeManager.incBytecodes(1);
                args2[n2] = count;
                BytecodeManager.incBytecodes(2);
                final String format4 = String.format(format3, args2);
                BytecodeManager.incBytecodes(1);
                return format4;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private abstract static class OfPrimitive<E, T_CONS, T_ARR, T_SPLITR extends Spliterator.OfPrimitive<E, T_CONS, T_SPLITR>, T_NODE extends Node.OfPrimitive<E, T_CONS, T_ARR, T_SPLITR, T_NODE>> extends AbstractConcNode<E, T_NODE> implements Node.OfPrimitive<E, T_CONS, T_ARR, T_SPLITR, T_NODE>
        {
            OfPrimitive(final T_NODE t_NODE, final T_NODE t_NODE2) {
                try {
                    BytecodeManager.incBytecodes(4);
                    super(t_NODE, t_NODE2);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public void forEach(final T_CONS t_CONS) {
                try {
                    final Node.OfPrimitive ofPrimitive = (Node.OfPrimitive)this.left;
                    BytecodeManager.incBytecodes(5);
                    ofPrimitive.forEach(t_CONS);
                    final Node.OfPrimitive ofPrimitive2 = (Node.OfPrimitive)this.right;
                    BytecodeManager.incBytecodes(5);
                    ofPrimitive2.forEach(t_CONS);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public void copyInto(final T_ARR t_ARR, final int n) {
                try {
                    final Node.OfPrimitive ofPrimitive = (Node.OfPrimitive)this.left;
                    BytecodeManager.incBytecodes(6);
                    ofPrimitive.copyInto(t_ARR, n);
                    final Node.OfPrimitive ofPrimitive2 = (Node.OfPrimitive)this.right;
                    final Node.OfPrimitive ofPrimitive3 = (Node.OfPrimitive)this.left;
                    BytecodeManager.incBytecodes(9);
                    final int n2 = n + (int)ofPrimitive3.count();
                    BytecodeManager.incBytecodes(3);
                    ofPrimitive2.copyInto(t_ARR, n2);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public T_ARR asPrimitiveArray() {
                try {
                    BytecodeManager.incBytecodes(2);
                    final long count = this.count();
                    BytecodeManager.incBytecodes(1);
                    final long n = lcmp(count, 2147483639L);
                    BytecodeManager.incBytecodes(4);
                    if (n >= 0) {
                        final String s = "Stream size exceeds max array size";
                        BytecodeManager.incBytecodes(4);
                        final IllegalArgumentException ex = new IllegalArgumentException(s);
                        BytecodeManager.incBytecodes(1);
                        throw ex;
                    }
                    final int n2 = (int)count;
                    BytecodeManager.incBytecodes(4);
                    final T_ARR array = this.newArray(n2);
                    BytecodeManager.incBytecodes(1);
                    final T_ARR t_ARR = array;
                    final int n3 = 0;
                    BytecodeManager.incBytecodes(4);
                    this.copyInto(t_ARR, n3);
                    final T_ARR t_ARR2 = array;
                    BytecodeManager.incBytecodes(2);
                    return t_ARR2;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public String toString() {
                try {
                    BytecodeManager.incBytecodes(2);
                    final long n = lcmp(this.count(), 32L);
                    BytecodeManager.incBytecodes(3);
                    if (n < 0) {
                        final String format = "%s[%s.%s]";
                        final Object[] args = new Object[3];
                        final int n2 = 0;
                        BytecodeManager.incBytecodes(6);
                        final Class<? extends OfPrimitive> class1 = this.getClass();
                        BytecodeManager.incBytecodes(1);
                        args[n2] = class1.getName();
                        args[1] = this.left;
                        args[2] = this.right;
                        BytecodeManager.incBytecodes(12);
                        final String format2 = String.format(format, args);
                        BytecodeManager.incBytecodes(1);
                        return format2;
                    }
                    final String format3 = "%s[size=%d]";
                    final Object[] args2 = new Object[2];
                    final int n3 = 0;
                    BytecodeManager.incBytecodes(6);
                    final Class<? extends OfPrimitive> class2 = this.getClass();
                    BytecodeManager.incBytecodes(1);
                    args2[n3] = class2.getName();
                    final int n4 = 1;
                    BytecodeManager.incBytecodes(5);
                    final long count = this.count();
                    BytecodeManager.incBytecodes(1);
                    args2[n4] = count;
                    BytecodeManager.incBytecodes(2);
                    final String format4 = String.format(format3, args2);
                    BytecodeManager.incBytecodes(1);
                    return format4;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
        
        static final class OfInt extends ConcNode.OfPrimitive<Integer, IntConsumer, int[], Spliterator.OfInt, Node.OfInt> implements Node.OfInt
        {
            OfInt(final Node.OfInt ofInt, final Node.OfInt ofInt2) {
                try {
                    BytecodeManager.incBytecodes(4);
                    super(ofInt, ofInt2);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public Spliterator.OfInt spliterator() {
                try {
                    BytecodeManager.incBytecodes(4);
                    final InternalNodeSpliterator.OfInt ofInt = new InternalNodeSpliterator.OfInt(this);
                    BytecodeManager.incBytecodes(1);
                    return ofInt;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
        
        static final class OfLong extends ConcNode.OfPrimitive<Long, LongConsumer, long[], Spliterator.OfLong, Node.OfLong> implements Node.OfLong
        {
            OfLong(final Node.OfLong ofLong, final Node.OfLong ofLong2) {
                try {
                    BytecodeManager.incBytecodes(4);
                    super(ofLong, ofLong2);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public Spliterator.OfLong spliterator() {
                try {
                    BytecodeManager.incBytecodes(4);
                    final InternalNodeSpliterator.OfLong ofLong = new InternalNodeSpliterator.OfLong(this);
                    BytecodeManager.incBytecodes(1);
                    return ofLong;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
        
        static final class OfDouble extends ConcNode.OfPrimitive<Double, DoubleConsumer, double[], Spliterator.OfDouble, Node.OfDouble> implements Node.OfDouble
        {
            OfDouble(final Node.OfDouble ofDouble, final Node.OfDouble ofDouble2) {
                try {
                    BytecodeManager.incBytecodes(4);
                    super(ofDouble, ofDouble2);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public Spliterator.OfDouble spliterator() {
                try {
                    BytecodeManager.incBytecodes(4);
                    final InternalNodeSpliterator.OfDouble ofDouble = new InternalNodeSpliterator.OfDouble(this);
                    BytecodeManager.incBytecodes(1);
                    return ofDouble;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
    }
    
    private abstract static class InternalNodeSpliterator<T, S extends Spliterator<T>, N extends Node<T>> implements Spliterator<T>
    {
        N curNode;
        int curChildIndex;
        S lastNodeSpliterator;
        S tryAdvanceSpliterator;
        Deque<N> tryAdvanceStack;
        
        InternalNodeSpliterator(final N curNode) {
            try {
                BytecodeManager.incBytecodes(2);
                this.curNode = curNode;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        protected final Deque<N> initStack() {
            try {
                final int n = 8;
                BytecodeManager.incBytecodes(4);
                final ArrayDeque arrayDeque = new ArrayDeque<N>(n);
                BytecodeManager.incBytecodes(1);
                final Node<T> curNode = this.curNode;
                BytecodeManager.incBytecodes(3);
                int n2 = curNode.getChildCount() - 1;
                BytecodeManager.incBytecodes(3);
                while (true) {
                    final int n3 = n2;
                    final int curChildIndex = this.curChildIndex;
                    BytecodeManager.incBytecodes(4);
                    if (n3 < curChildIndex) {
                        break;
                    }
                    final ArrayDeque arrayDeque2 = arrayDeque;
                    final Node<T> curNode2 = this.curNode;
                    final int n4 = n2;
                    BytecodeManager.incBytecodes(5);
                    final Node<T> child = curNode2.getChild(n4);
                    BytecodeManager.incBytecodes(1);
                    arrayDeque2.addFirst(child);
                    --n2;
                    BytecodeManager.incBytecodes(2);
                }
                final ArrayDeque arrayDeque3 = arrayDeque;
                BytecodeManager.incBytecodes(2);
                return (Deque<N>)arrayDeque3;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        protected final N findNextLeafNode(final Deque<N> deque) {
            try {
                BytecodeManager.incBytecodes(2);
                while (true) {
                    BytecodeManager.incBytecodes(2);
                    final Node<T> node2;
                    final Node<T> node = node2 = deque.pollFirst();
                    BytecodeManager.incBytecodes(4);
                    if (node == null) {
                        final Node<T> node3 = null;
                        BytecodeManager.incBytecodes(2);
                        return (N)node3;
                    }
                    final Node<T> node4 = node2;
                    BytecodeManager.incBytecodes(2);
                    final int childCount = node4.getChildCount();
                    BytecodeManager.incBytecodes(1);
                    if (childCount == 0) {
                        final Node<T> node5 = node2;
                        BytecodeManager.incBytecodes(2);
                        final long n = lcmp(node5.count(), 0L);
                        BytecodeManager.incBytecodes(3);
                        if (n > 0) {
                            final Node<T> node6 = node2;
                            BytecodeManager.incBytecodes(2);
                            return (N)node6;
                        }
                        continue;
                    }
                    else {
                        final Node<T> node7 = node2;
                        BytecodeManager.incBytecodes(2);
                        int n2 = node7.getChildCount() - 1;
                        BytecodeManager.incBytecodes(3);
                        while (true) {
                            final int n3 = n2;
                            BytecodeManager.incBytecodes(2);
                            if (n3 < 0) {
                                break;
                            }
                            final Node<T> node8 = node2;
                            final int n4 = n2;
                            BytecodeManager.incBytecodes(4);
                            final Node<T> child = node8.getChild(n4);
                            BytecodeManager.incBytecodes(1);
                            deque.addFirst((N)child);
                            --n2;
                            BytecodeManager.incBytecodes(2);
                        }
                        BytecodeManager.incBytecodes(1);
                    }
                }
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        protected final boolean initTryAdvance() {
            try {
                final Node<T> curNode = this.curNode;
                BytecodeManager.incBytecodes(3);
                if (curNode == null) {
                    final boolean b = false;
                    BytecodeManager.incBytecodes(2);
                    return b;
                }
                final Spliterator<T> tryAdvanceSpliterator = this.tryAdvanceSpliterator;
                BytecodeManager.incBytecodes(3);
                if (tryAdvanceSpliterator == null) {
                    final Spliterator<T> lastNodeSpliterator = this.lastNodeSpliterator;
                    BytecodeManager.incBytecodes(3);
                    if (lastNodeSpliterator == null) {
                        BytecodeManager.incBytecodes(3);
                        this.tryAdvanceStack = this.initStack();
                        BytecodeManager.incBytecodes(1);
                        final Deque<N> tryAdvanceStack = this.tryAdvanceStack;
                        BytecodeManager.incBytecodes(4);
                        final Node<T> nextLeafNode = this.findNextLeafNode((Deque<Node<T>>)tryAdvanceStack);
                        BytecodeManager.incBytecodes(1);
                        final Node<T> node = nextLeafNode;
                        BytecodeManager.incBytecodes(2);
                        if (node == null) {
                            this.curNode = null;
                            BytecodeManager.incBytecodes(3);
                            final boolean b2 = false;
                            BytecodeManager.incBytecodes(2);
                            return b2;
                        }
                        final Node<T> node2 = nextLeafNode;
                        BytecodeManager.incBytecodes(3);
                        this.tryAdvanceSpliterator = (S)node2.spliterator();
                        BytecodeManager.incBytecodes(2);
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        this.tryAdvanceSpliterator = this.lastNodeSpliterator;
                        BytecodeManager.incBytecodes(4);
                    }
                }
                final boolean b3 = true;
                BytecodeManager.incBytecodes(2);
                return b3;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final S trySplit() {
            try {
                final Node<T> curNode = this.curNode;
                BytecodeManager.incBytecodes(3);
                if (curNode != null) {
                    final Spliterator<T> tryAdvanceSpliterator = this.tryAdvanceSpliterator;
                    BytecodeManager.incBytecodes(3);
                    if (tryAdvanceSpliterator == null) {
                        final Spliterator<T> lastNodeSpliterator = this.lastNodeSpliterator;
                        BytecodeManager.incBytecodes(3);
                        if (lastNodeSpliterator != null) {
                            final Spliterator<T> lastNodeSpliterator2 = this.lastNodeSpliterator;
                            BytecodeManager.incBytecodes(3);
                            final Spliterator<T> trySplit = lastNodeSpliterator2.trySplit();
                            BytecodeManager.incBytecodes(1);
                            return (S)trySplit;
                        }
                        final int curChildIndex = this.curChildIndex;
                        final Node<T> curNode2 = this.curNode;
                        BytecodeManager.incBytecodes(5);
                        final int n = curNode2.getChildCount() - 1;
                        BytecodeManager.incBytecodes(3);
                        if (curChildIndex < n) {
                            final Node<T> curNode3 = this.curNode;
                            final int n2 = this.curChildIndex++;
                            BytecodeManager.incBytecodes(10);
                            final Node<T> child = curNode3.getChild(n2);
                            BytecodeManager.incBytecodes(1);
                            final Spliterator<T> spliterator = child.spliterator();
                            BytecodeManager.incBytecodes(1);
                            return (S)spliterator;
                        }
                        final Node<T> curNode4 = this.curNode;
                        final int curChildIndex2 = this.curChildIndex;
                        BytecodeManager.incBytecodes(6);
                        this.curNode = (N)curNode4.getChild(curChildIndex2);
                        BytecodeManager.incBytecodes(1);
                        final Node<T> curNode5 = this.curNode;
                        BytecodeManager.incBytecodes(3);
                        final int childCount = curNode5.getChildCount();
                        BytecodeManager.incBytecodes(1);
                        if (childCount == 0) {
                            final Node<T> curNode6 = this.curNode;
                            BytecodeManager.incBytecodes(4);
                            this.lastNodeSpliterator = (S)curNode6.spliterator();
                            BytecodeManager.incBytecodes(1);
                            final Spliterator<T> lastNodeSpliterator3 = this.lastNodeSpliterator;
                            BytecodeManager.incBytecodes(3);
                            final Spliterator<T> trySplit2 = lastNodeSpliterator3.trySplit();
                            BytecodeManager.incBytecodes(1);
                            return (S)trySplit2;
                        }
                        this.curChildIndex = 0;
                        BytecodeManager.incBytecodes(3);
                        final Node<T> curNode7 = this.curNode;
                        final int n3 = this.curChildIndex++;
                        BytecodeManager.incBytecodes(10);
                        final Node<T> child2 = curNode7.getChild(n3);
                        BytecodeManager.incBytecodes(1);
                        final Spliterator<T> spliterator2 = child2.spliterator();
                        BytecodeManager.incBytecodes(1);
                        return (S)spliterator2;
                    }
                }
                final Spliterator<T> spliterator3 = null;
                BytecodeManager.incBytecodes(2);
                return (S)spliterator3;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final long estimateSize() {
            try {
                final Node<T> curNode = this.curNode;
                BytecodeManager.incBytecodes(3);
                if (curNode == null) {
                    final long n = 0L;
                    BytecodeManager.incBytecodes(2);
                    return n;
                }
                final Spliterator<T> lastNodeSpliterator = this.lastNodeSpliterator;
                BytecodeManager.incBytecodes(3);
                if (lastNodeSpliterator != null) {
                    final Spliterator<T> lastNodeSpliterator2 = this.lastNodeSpliterator;
                    BytecodeManager.incBytecodes(3);
                    final long estimateSize = lastNodeSpliterator2.estimateSize();
                    BytecodeManager.incBytecodes(1);
                    return estimateSize;
                }
                long n2 = 0L;
                BytecodeManager.incBytecodes(2);
                int curChildIndex = this.curChildIndex;
                BytecodeManager.incBytecodes(3);
                while (true) {
                    final int n3 = curChildIndex;
                    final Node<T> curNode2 = this.curNode;
                    BytecodeManager.incBytecodes(4);
                    final int childCount = curNode2.getChildCount();
                    BytecodeManager.incBytecodes(1);
                    if (n3 >= childCount) {
                        break;
                    }
                    final long n4 = n2;
                    final Node<T> curNode3 = this.curNode;
                    final int n5 = curChildIndex;
                    BytecodeManager.incBytecodes(5);
                    final Node<T> child = curNode3.getChild(n5);
                    BytecodeManager.incBytecodes(1);
                    n2 = n4 + child.count();
                    BytecodeManager.incBytecodes(2);
                    ++curChildIndex;
                    BytecodeManager.incBytecodes(2);
                }
                final long n6 = n2;
                BytecodeManager.incBytecodes(2);
                return n6;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final int characteristics() {
            try {
                final int n = 64;
                BytecodeManager.incBytecodes(2);
                return n;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private static final class OfRef<T> extends InternalNodeSpliterator<T, Spliterator<T>, Node<T>>
        {
            OfRef(final Node<T> node) {
                try {
                    BytecodeManager.incBytecodes(3);
                    super(node);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public boolean tryAdvance(final Consumer<? super T> consumer) {
                try {
                    BytecodeManager.incBytecodes(2);
                    final boolean initTryAdvance = this.initTryAdvance();
                    BytecodeManager.incBytecodes(1);
                    if (!initTryAdvance) {
                        final boolean b = false;
                        BytecodeManager.incBytecodes(2);
                        return b;
                    }
                    final Spliterator<T> tryAdvanceSpliterator = this.tryAdvanceSpliterator;
                    BytecodeManager.incBytecodes(4);
                    final boolean tryAdvance = tryAdvanceSpliterator.tryAdvance((Consumer<? super T>)consumer);
                    BytecodeManager.incBytecodes(1);
                    final boolean b2 = tryAdvance;
                    BytecodeManager.incBytecodes(2);
                    if (!b2) {
                        final Spliterator<T> lastNodeSpliterator = this.lastNodeSpliterator;
                        BytecodeManager.incBytecodes(3);
                        if (lastNodeSpliterator == null) {
                            final Deque<N> tryAdvanceStack = this.tryAdvanceStack;
                            BytecodeManager.incBytecodes(4);
                            final Node<T> nextLeafNode = this.findNextLeafNode((Deque<Node<T>>)tryAdvanceStack);
                            BytecodeManager.incBytecodes(1);
                            final Node<T> node = nextLeafNode;
                            BytecodeManager.incBytecodes(2);
                            if (node != null) {
                                final Node<T> node2 = nextLeafNode;
                                BytecodeManager.incBytecodes(3);
                                this.tryAdvanceSpliterator = (S)node2.spliterator();
                                BytecodeManager.incBytecodes(1);
                                final Spliterator<T> tryAdvanceSpliterator2 = this.tryAdvanceSpliterator;
                                BytecodeManager.incBytecodes(4);
                                final boolean tryAdvance2 = tryAdvanceSpliterator2.tryAdvance((Consumer<? super T>)consumer);
                                BytecodeManager.incBytecodes(1);
                                return tryAdvance2;
                            }
                        }
                        this.curNode = null;
                        BytecodeManager.incBytecodes(3);
                    }
                    final boolean b3 = tryAdvance;
                    BytecodeManager.incBytecodes(2);
                    return b3;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public void forEachRemaining(final Consumer<? super T> consumer) {
                try {
                    final Node<T> curNode = this.curNode;
                    BytecodeManager.incBytecodes(3);
                    if (curNode == null) {
                        BytecodeManager.incBytecodes(1);
                        return;
                    }
                    final Spliterator<T> tryAdvanceSpliterator = this.tryAdvanceSpliterator;
                    BytecodeManager.incBytecodes(3);
                    if (tryAdvanceSpliterator == null) {
                        final Spliterator<T> lastNodeSpliterator = this.lastNodeSpliterator;
                        BytecodeManager.incBytecodes(3);
                        if (lastNodeSpliterator == null) {
                            BytecodeManager.incBytecodes(2);
                            final Deque<Node<T>> initStack = this.initStack();
                            BytecodeManager.incBytecodes(1);
                            while (true) {
                                final Deque<Node<T>> deque = initStack;
                                BytecodeManager.incBytecodes(3);
                                final Node<T> nextLeafNode = this.findNextLeafNode(deque);
                                BytecodeManager.incBytecodes(3);
                                if (nextLeafNode == null) {
                                    break;
                                }
                                final Node<T> node = nextLeafNode;
                                BytecodeManager.incBytecodes(3);
                                node.forEach(consumer);
                                BytecodeManager.incBytecodes(1);
                            }
                            this.curNode = null;
                            BytecodeManager.incBytecodes(3);
                            BytecodeManager.incBytecodes(1);
                        }
                        else {
                            final Spliterator<T> lastNodeSpliterator2 = this.lastNodeSpliterator;
                            BytecodeManager.incBytecodes(4);
                            lastNodeSpliterator2.forEachRemaining((Consumer<? super T>)consumer);
                            BytecodeManager.incBytecodes(1);
                        }
                    }
                    else {
                        while (true) {
                            BytecodeManager.incBytecodes(3);
                            final boolean tryAdvance = this.tryAdvance(consumer);
                            BytecodeManager.incBytecodes(1);
                            if (!tryAdvance) {
                                break;
                            }
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
        
        private abstract static class OfPrimitive<T, T_CONS, T_ARR, T_SPLITR extends Spliterator.OfPrimitive<T, T_CONS, T_SPLITR>, N extends Node.OfPrimitive<T, T_CONS, T_ARR, T_SPLITR, N>> extends InternalNodeSpliterator<T, T_SPLITR, N> implements Spliterator.OfPrimitive<T, T_CONS, T_SPLITR>
        {
            OfPrimitive(final N n) {
                try {
                    BytecodeManager.incBytecodes(3);
                    super(n);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public boolean tryAdvance(final T_CONS t_CONS) {
                try {
                    BytecodeManager.incBytecodes(2);
                    final boolean initTryAdvance = this.initTryAdvance();
                    BytecodeManager.incBytecodes(1);
                    if (!initTryAdvance) {
                        final boolean b = false;
                        BytecodeManager.incBytecodes(2);
                        return b;
                    }
                    final Spliterator.OfPrimitive ofPrimitive = (Spliterator.OfPrimitive)this.tryAdvanceSpliterator;
                    BytecodeManager.incBytecodes(5);
                    final boolean tryAdvance = ofPrimitive.tryAdvance(t_CONS);
                    BytecodeManager.incBytecodes(1);
                    final boolean b2 = tryAdvance;
                    BytecodeManager.incBytecodes(2);
                    if (!b2) {
                        final Spliterator<T> lastNodeSpliterator = this.lastNodeSpliterator;
                        BytecodeManager.incBytecodes(3);
                        if (lastNodeSpliterator == null) {
                            final Deque<N> tryAdvanceStack = this.tryAdvanceStack;
                            BytecodeManager.incBytecodes(4);
                            final Node.OfPrimitive<T, T_CONS, T_ARR, T_SPLITR, N> ofPrimitive2 = this.findNextLeafNode((Deque<N>)tryAdvanceStack);
                            BytecodeManager.incBytecodes(2);
                            final Node.OfPrimitive<T, T_CONS, T_ARR, T_SPLITR, N> ofPrimitive3 = ofPrimitive2;
                            BytecodeManager.incBytecodes(2);
                            if (ofPrimitive3 != null) {
                                final Node.OfPrimitive<T, T_CONS, T_ARR, T_SPLITR, N> ofPrimitive4 = ofPrimitive2;
                                BytecodeManager.incBytecodes(3);
                                this.tryAdvanceSpliterator = (S)ofPrimitive4.spliterator();
                                BytecodeManager.incBytecodes(1);
                                final Spliterator.OfPrimitive ofPrimitive5 = (Spliterator.OfPrimitive)this.tryAdvanceSpliterator;
                                BytecodeManager.incBytecodes(5);
                                final boolean tryAdvance2 = ofPrimitive5.tryAdvance(t_CONS);
                                BytecodeManager.incBytecodes(1);
                                return tryAdvance2;
                            }
                        }
                        this.curNode = null;
                        BytecodeManager.incBytecodes(3);
                    }
                    final boolean b3 = tryAdvance;
                    BytecodeManager.incBytecodes(2);
                    return b3;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public void forEachRemaining(final T_CONS t_CONS) {
                try {
                    final Node<T> curNode = this.curNode;
                    BytecodeManager.incBytecodes(3);
                    if (curNode == null) {
                        BytecodeManager.incBytecodes(1);
                        return;
                    }
                    final Spliterator<T> tryAdvanceSpliterator = this.tryAdvanceSpliterator;
                    BytecodeManager.incBytecodes(3);
                    if (tryAdvanceSpliterator == null) {
                        final Spliterator<T> lastNodeSpliterator = this.lastNodeSpliterator;
                        BytecodeManager.incBytecodes(3);
                        if (lastNodeSpliterator == null) {
                            BytecodeManager.incBytecodes(2);
                            final Deque<N> initStack = this.initStack();
                            BytecodeManager.incBytecodes(1);
                            while (true) {
                                final Deque<N> deque = initStack;
                                BytecodeManager.incBytecodes(3);
                                final Node.OfPrimitive<T, T_CONS, T_ARR, T_SPLITR, N> ofPrimitive = this.findNextLeafNode(deque);
                                BytecodeManager.incBytecodes(4);
                                if (ofPrimitive == null) {
                                    break;
                                }
                                final Node.OfPrimitive<T, T_CONS, T_ARR, T_SPLITR, N> ofPrimitive2 = ofPrimitive;
                                BytecodeManager.incBytecodes(3);
                                ofPrimitive2.forEach(t_CONS);
                                BytecodeManager.incBytecodes(1);
                            }
                            this.curNode = null;
                            BytecodeManager.incBytecodes(3);
                            BytecodeManager.incBytecodes(1);
                        }
                        else {
                            final Spliterator.OfPrimitive ofPrimitive3 = (Spliterator.OfPrimitive)this.lastNodeSpliterator;
                            BytecodeManager.incBytecodes(5);
                            ofPrimitive3.forEachRemaining(t_CONS);
                            BytecodeManager.incBytecodes(1);
                        }
                    }
                    else {
                        while (true) {
                            BytecodeManager.incBytecodes(3);
                            final boolean tryAdvance = this.tryAdvance(t_CONS);
                            BytecodeManager.incBytecodes(1);
                            if (!tryAdvance) {
                                break;
                            }
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
        
        private static final class OfInt extends InternalNodeSpliterator.OfPrimitive<Integer, IntConsumer, int[], Spliterator.OfInt, Node.OfInt> implements Spliterator.OfInt
        {
            OfInt(final Node.OfInt ofInt) {
                try {
                    BytecodeManager.incBytecodes(3);
                    super(ofInt);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
        
        private static final class OfLong extends InternalNodeSpliterator.OfPrimitive<Long, LongConsumer, long[], Spliterator.OfLong, Node.OfLong> implements Spliterator.OfLong
        {
            OfLong(final Node.OfLong ofLong) {
                try {
                    BytecodeManager.incBytecodes(3);
                    super(ofLong);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
        
        private static final class OfDouble extends InternalNodeSpliterator.OfPrimitive<Double, DoubleConsumer, double[], Spliterator.OfDouble, Node.OfDouble> implements Spliterator.OfDouble
        {
            OfDouble(final Node.OfDouble ofDouble) {
                try {
                    BytecodeManager.incBytecodes(3);
                    super(ofDouble);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
    }
    
    private static final class FixedNodeBuilder<T> extends ArrayNode<T> implements Node.Builder<T>
    {
        static final /* synthetic */ boolean $assertionsDisabled;
        
        FixedNodeBuilder(final long n, final IntFunction<T[]> intFunction) {
            try {
                BytecodeManager.incBytecodes(4);
                super(n, intFunction);
                final boolean $assertionsDisabled = FixedNodeBuilder.$assertionsDisabled;
                BytecodeManager.incBytecodes(2);
                if (!$assertionsDisabled) {
                    final long n2 = lcmp(n, 2147483639L);
                    BytecodeManager.incBytecodes(4);
                    if (n2 >= 0) {
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
        public Node<T> build() {
            try {
                final int curSize = this.curSize;
                final int length = this.array.length;
                BytecodeManager.incBytecodes(6);
                if (curSize < length) {
                    final String format = "Current size %d is less than fixed size %d";
                    final Object[] args = new Object[2];
                    final int n = 0;
                    final int curSize2 = this.curSize;
                    BytecodeManager.incBytecodes(8);
                    BytecodeManager.incBytecodes(1);
                    args[n] = curSize2;
                    final int n2 = 1;
                    final int length2 = this.array.length;
                    BytecodeManager.incBytecodes(7);
                    args[n2] = length2;
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    final String format2 = String.format(format, args);
                    BytecodeManager.incBytecodes(1);
                    final IllegalStateException ex = new IllegalStateException(format2);
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                BytecodeManager.incBytecodes(2);
                return this;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void begin(final long l) {
            try {
                final long n = lcmp(l, (long)this.array.length);
                BytecodeManager.incBytecodes(7);
                if (n != 0) {
                    final String format = "Begin size %d is not equal to fixed size %d";
                    final Object[] args = new Object[2];
                    final int n2 = 0;
                    BytecodeManager.incBytecodes(7);
                    BytecodeManager.incBytecodes(1);
                    args[n2] = l;
                    final int n3 = 1;
                    final int length = this.array.length;
                    BytecodeManager.incBytecodes(7);
                    args[n3] = length;
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    final String format2 = String.format(format, args);
                    BytecodeManager.incBytecodes(1);
                    final IllegalStateException ex = new IllegalStateException(format2);
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                this.curSize = 0;
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
                final int curSize = this.curSize;
                final int length = this.array.length;
                BytecodeManager.incBytecodes(6);
                if (curSize < length) {
                    this.array[this.curSize++] = t;
                    BytecodeManager.incBytecodes(12);
                    BytecodeManager.incBytecodes(1);
                    return;
                }
                final String format = "Accept exceeded fixed size of %d";
                final Object[] args = { null };
                final int n = 0;
                final int length2 = this.array.length;
                BytecodeManager.incBytecodes(9);
                BytecodeManager.incBytecodes(1);
                args[n] = length2;
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                final String format2 = String.format(format, args);
                BytecodeManager.incBytecodes(1);
                final IllegalStateException ex = new IllegalStateException(format2);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void end() {
            try {
                final int curSize = this.curSize;
                final int length = this.array.length;
                BytecodeManager.incBytecodes(6);
                if (curSize < length) {
                    final String format = "End size %d is less than fixed size %d";
                    final Object[] args = new Object[2];
                    final int n = 0;
                    final int curSize2 = this.curSize;
                    BytecodeManager.incBytecodes(8);
                    BytecodeManager.incBytecodes(1);
                    args[n] = curSize2;
                    final int n2 = 1;
                    final int length2 = this.array.length;
                    BytecodeManager.incBytecodes(7);
                    args[n2] = length2;
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    final String format2 = String.format(format, args);
                    BytecodeManager.incBytecodes(1);
                    final IllegalStateException ex = new IllegalStateException(format2);
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public String toString() {
            try {
                final String format = "FixedNodeBuilder[%d][%s]";
                final Object[] args = new Object[2];
                final int n = 0;
                final int i = this.array.length - this.curSize;
                BytecodeManager.incBytecodes(10);
                BytecodeManager.incBytecodes(1);
                args[n] = i;
                final int n2 = 1;
                final T[] array = this.array;
                BytecodeManager.incBytecodes(6);
                args[n2] = Arrays.toString(array);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                final String format2 = String.format(format, args);
                BytecodeManager.incBytecodes(1);
                return format2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static {
            try {
                final Class<Nodes> clazz = Nodes.class;
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
    
    private static final class SpinedNodeBuilder<T> extends SpinedBuffer<T> implements Node<T>, Builder<T>
    {
        private boolean building;
        static final /* synthetic */ boolean $assertionsDisabled;
        
        SpinedNodeBuilder() {
            try {
                BytecodeManager.incBytecodes(2);
                this.building = false;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Spliterator<T> spliterator() {
            try {
                final boolean $assertionsDisabled = SpinedNodeBuilder.$assertionsDisabled;
                BytecodeManager.incBytecodes(2);
                if (!$assertionsDisabled) {
                    final boolean building = this.building;
                    BytecodeManager.incBytecodes(3);
                    if (building) {
                        final String detailMessage = "during building";
                        BytecodeManager.incBytecodes(4);
                        final AssertionError assertionError = new AssertionError((Object)detailMessage);
                        BytecodeManager.incBytecodes(1);
                        throw assertionError;
                    }
                }
                BytecodeManager.incBytecodes(2);
                final Spliterator<T> spliterator = super.spliterator();
                BytecodeManager.incBytecodes(1);
                return spliterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void forEach(final Consumer<? super T> consumer) {
            try {
                final boolean $assertionsDisabled = SpinedNodeBuilder.$assertionsDisabled;
                BytecodeManager.incBytecodes(2);
                if (!$assertionsDisabled) {
                    final boolean building = this.building;
                    BytecodeManager.incBytecodes(3);
                    if (building) {
                        final String detailMessage = "during building";
                        BytecodeManager.incBytecodes(4);
                        final AssertionError assertionError = new AssertionError((Object)detailMessage);
                        BytecodeManager.incBytecodes(1);
                        throw assertionError;
                    }
                }
                BytecodeManager.incBytecodes(3);
                super.forEach(consumer);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void begin(final long n) {
            try {
                final boolean $assertionsDisabled = SpinedNodeBuilder.$assertionsDisabled;
                BytecodeManager.incBytecodes(2);
                if (!$assertionsDisabled) {
                    final boolean building = this.building;
                    BytecodeManager.incBytecodes(3);
                    if (building) {
                        final String detailMessage = "was already building";
                        BytecodeManager.incBytecodes(4);
                        final AssertionError assertionError = new AssertionError((Object)detailMessage);
                        BytecodeManager.incBytecodes(1);
                        throw assertionError;
                    }
                }
                this.building = true;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(2);
                this.clear();
                BytecodeManager.incBytecodes(3);
                this.ensureCapacity(n);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void accept(final T t) {
            try {
                final boolean $assertionsDisabled = SpinedNodeBuilder.$assertionsDisabled;
                BytecodeManager.incBytecodes(2);
                if (!$assertionsDisabled) {
                    final boolean building = this.building;
                    BytecodeManager.incBytecodes(3);
                    if (!building) {
                        final String detailMessage = "not building";
                        BytecodeManager.incBytecodes(4);
                        final AssertionError assertionError = new AssertionError((Object)detailMessage);
                        BytecodeManager.incBytecodes(1);
                        throw assertionError;
                    }
                }
                BytecodeManager.incBytecodes(3);
                super.accept(t);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void end() {
            try {
                final boolean $assertionsDisabled = SpinedNodeBuilder.$assertionsDisabled;
                BytecodeManager.incBytecodes(2);
                if (!$assertionsDisabled) {
                    final boolean building = this.building;
                    BytecodeManager.incBytecodes(3);
                    if (!building) {
                        final String detailMessage = "was not building";
                        BytecodeManager.incBytecodes(4);
                        final AssertionError assertionError = new AssertionError((Object)detailMessage);
                        BytecodeManager.incBytecodes(1);
                        throw assertionError;
                    }
                }
                this.building = false;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void copyInto(final T[] array, final int n) {
            try {
                final boolean $assertionsDisabled = SpinedNodeBuilder.$assertionsDisabled;
                BytecodeManager.incBytecodes(2);
                if (!$assertionsDisabled) {
                    final boolean building = this.building;
                    BytecodeManager.incBytecodes(3);
                    if (building) {
                        final String detailMessage = "during building";
                        BytecodeManager.incBytecodes(4);
                        final AssertionError assertionError = new AssertionError((Object)detailMessage);
                        BytecodeManager.incBytecodes(1);
                        throw assertionError;
                    }
                }
                BytecodeManager.incBytecodes(4);
                super.copyInto(array, n);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public T[] asArray(final IntFunction<T[]> intFunction) {
            try {
                final boolean $assertionsDisabled = SpinedNodeBuilder.$assertionsDisabled;
                BytecodeManager.incBytecodes(2);
                if (!$assertionsDisabled) {
                    final boolean building = this.building;
                    BytecodeManager.incBytecodes(3);
                    if (building) {
                        final String detailMessage = "during building";
                        BytecodeManager.incBytecodes(4);
                        final AssertionError assertionError = new AssertionError((Object)detailMessage);
                        BytecodeManager.incBytecodes(1);
                        throw assertionError;
                    }
                }
                BytecodeManager.incBytecodes(3);
                final T[] array = super.asArray(intFunction);
                BytecodeManager.incBytecodes(1);
                return array;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Node<T> build() {
            try {
                final boolean $assertionsDisabled = SpinedNodeBuilder.$assertionsDisabled;
                BytecodeManager.incBytecodes(2);
                if (!$assertionsDisabled) {
                    final boolean building = this.building;
                    BytecodeManager.incBytecodes(3);
                    if (building) {
                        final String detailMessage = "during building";
                        BytecodeManager.incBytecodes(4);
                        final AssertionError assertionError = new AssertionError((Object)detailMessage);
                        BytecodeManager.incBytecodes(1);
                        throw assertionError;
                    }
                }
                BytecodeManager.incBytecodes(2);
                return this;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static {
            try {
                final Class<Nodes> clazz = Nodes.class;
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
    
    private static class IntArrayNode implements Node.OfInt
    {
        final int[] array;
        int curSize;
        
        IntArrayNode(final long n) {
            try {
                BytecodeManager.incBytecodes(2);
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
                this.curSize = 0;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        IntArrayNode(final int[] array) {
            try {
                BytecodeManager.incBytecodes(2);
                this.array = array;
                BytecodeManager.incBytecodes(3);
                this.curSize = array.length;
                BytecodeManager.incBytecodes(4);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Spliterator.OfInt spliterator() {
            try {
                final int[] array = this.array;
                final int n = 0;
                final int curSize = this.curSize;
                BytecodeManager.incBytecodes(6);
                final Spliterator.OfInt spliterator = Arrays.spliterator(array, n, curSize);
                BytecodeManager.incBytecodes(1);
                return spliterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int[] asPrimitiveArray() {
            try {
                final int length = this.array.length;
                final int curSize = this.curSize;
                BytecodeManager.incBytecodes(6);
                if (length == curSize) {
                    final int[] array = this.array;
                    BytecodeManager.incBytecodes(3);
                    return array;
                }
                final int[] array2 = this.array;
                final int curSize2 = this.curSize;
                BytecodeManager.incBytecodes(5);
                final int[] copy = Arrays.copyOf(array2, curSize2);
                BytecodeManager.incBytecodes(1);
                return copy;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void copyInto(final int[] array, final int n) {
            try {
                final int[] array2 = this.array;
                final int n2 = 0;
                final int curSize = this.curSize;
                BytecodeManager.incBytecodes(8);
                System.arraycopy(array2, n2, array, n, curSize);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public long count() {
            try {
                final long n = this.curSize;
                BytecodeManager.incBytecodes(4);
                return n;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void forEach(final IntConsumer intConsumer) {
            try {
                int n = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n2 = n;
                    final int curSize = this.curSize;
                    BytecodeManager.incBytecodes(4);
                    if (n2 >= curSize) {
                        break;
                    }
                    final int n3 = this.array[n];
                    BytecodeManager.incBytecodes(6);
                    intConsumer.accept(n3);
                    ++n;
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public String toString() {
            try {
                final String format = "IntArrayNode[%d][%s]";
                final Object[] args = new Object[2];
                final int n = 0;
                final int i = this.array.length - this.curSize;
                BytecodeManager.incBytecodes(10);
                BytecodeManager.incBytecodes(1);
                args[n] = i;
                final int n2 = 1;
                final int[] array = this.array;
                BytecodeManager.incBytecodes(6);
                args[n2] = Arrays.toString(array);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                final String format2 = String.format(format, args);
                BytecodeManager.incBytecodes(1);
                return format2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private static class LongArrayNode implements Node.OfLong
    {
        final long[] array;
        int curSize;
        
        LongArrayNode(final long n) {
            try {
                BytecodeManager.incBytecodes(2);
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
                this.curSize = 0;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        LongArrayNode(final long[] array) {
            try {
                BytecodeManager.incBytecodes(2);
                this.array = array;
                BytecodeManager.incBytecodes(3);
                this.curSize = array.length;
                BytecodeManager.incBytecodes(4);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Spliterator.OfLong spliterator() {
            try {
                final long[] array = this.array;
                final int n = 0;
                final int curSize = this.curSize;
                BytecodeManager.incBytecodes(6);
                final Spliterator.OfLong spliterator = Arrays.spliterator(array, n, curSize);
                BytecodeManager.incBytecodes(1);
                return spliterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public long[] asPrimitiveArray() {
            try {
                final int length = this.array.length;
                final int curSize = this.curSize;
                BytecodeManager.incBytecodes(6);
                if (length == curSize) {
                    final long[] array = this.array;
                    BytecodeManager.incBytecodes(3);
                    return array;
                }
                final long[] array2 = this.array;
                final int curSize2 = this.curSize;
                BytecodeManager.incBytecodes(5);
                final long[] copy = Arrays.copyOf(array2, curSize2);
                BytecodeManager.incBytecodes(1);
                return copy;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void copyInto(final long[] array, final int n) {
            try {
                final long[] array2 = this.array;
                final int n2 = 0;
                final int curSize = this.curSize;
                BytecodeManager.incBytecodes(8);
                System.arraycopy(array2, n2, array, n, curSize);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public long count() {
            try {
                final long n = this.curSize;
                BytecodeManager.incBytecodes(4);
                return n;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void forEach(final LongConsumer longConsumer) {
            try {
                int n = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n2 = n;
                    final int curSize = this.curSize;
                    BytecodeManager.incBytecodes(4);
                    if (n2 >= curSize) {
                        break;
                    }
                    final long n3 = this.array[n];
                    BytecodeManager.incBytecodes(6);
                    longConsumer.accept(n3);
                    ++n;
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public String toString() {
            try {
                final String format = "LongArrayNode[%d][%s]";
                final Object[] args = new Object[2];
                final int n = 0;
                final int i = this.array.length - this.curSize;
                BytecodeManager.incBytecodes(10);
                BytecodeManager.incBytecodes(1);
                args[n] = i;
                final int n2 = 1;
                final long[] array = this.array;
                BytecodeManager.incBytecodes(6);
                args[n2] = Arrays.toString(array);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                final String format2 = String.format(format, args);
                BytecodeManager.incBytecodes(1);
                return format2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private static class DoubleArrayNode implements Node.OfDouble
    {
        final double[] array;
        int curSize;
        
        DoubleArrayNode(final long n) {
            try {
                BytecodeManager.incBytecodes(2);
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
                this.curSize = 0;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        DoubleArrayNode(final double[] array) {
            try {
                BytecodeManager.incBytecodes(2);
                this.array = array;
                BytecodeManager.incBytecodes(3);
                this.curSize = array.length;
                BytecodeManager.incBytecodes(4);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Spliterator.OfDouble spliterator() {
            try {
                final double[] array = this.array;
                final int n = 0;
                final int curSize = this.curSize;
                BytecodeManager.incBytecodes(6);
                final Spliterator.OfDouble spliterator = Arrays.spliterator(array, n, curSize);
                BytecodeManager.incBytecodes(1);
                return spliterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public double[] asPrimitiveArray() {
            try {
                final int length = this.array.length;
                final int curSize = this.curSize;
                BytecodeManager.incBytecodes(6);
                if (length == curSize) {
                    final double[] array = this.array;
                    BytecodeManager.incBytecodes(3);
                    return array;
                }
                final double[] array2 = this.array;
                final int curSize2 = this.curSize;
                BytecodeManager.incBytecodes(5);
                final double[] copy = Arrays.copyOf(array2, curSize2);
                BytecodeManager.incBytecodes(1);
                return copy;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void copyInto(final double[] array, final int n) {
            try {
                final double[] array2 = this.array;
                final int n2 = 0;
                final int curSize = this.curSize;
                BytecodeManager.incBytecodes(8);
                System.arraycopy(array2, n2, array, n, curSize);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public long count() {
            try {
                final long n = this.curSize;
                BytecodeManager.incBytecodes(4);
                return n;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void forEach(final DoubleConsumer doubleConsumer) {
            try {
                int n = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n2 = n;
                    final int curSize = this.curSize;
                    BytecodeManager.incBytecodes(4);
                    if (n2 >= curSize) {
                        break;
                    }
                    final double n3 = this.array[n];
                    BytecodeManager.incBytecodes(6);
                    doubleConsumer.accept(n3);
                    ++n;
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public String toString() {
            try {
                final String format = "DoubleArrayNode[%d][%s]";
                final Object[] args = new Object[2];
                final int n = 0;
                final int i = this.array.length - this.curSize;
                BytecodeManager.incBytecodes(10);
                BytecodeManager.incBytecodes(1);
                args[n] = i;
                final int n2 = 1;
                final double[] array = this.array;
                BytecodeManager.incBytecodes(6);
                args[n2] = Arrays.toString(array);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                final String format2 = String.format(format, args);
                BytecodeManager.incBytecodes(1);
                return format2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private static final class IntFixedNodeBuilder extends IntArrayNode implements Node.Builder.OfInt
    {
        static final /* synthetic */ boolean $assertionsDisabled;
        
        IntFixedNodeBuilder(final long n) {
            try {
                BytecodeManager.incBytecodes(3);
                super(n);
                final boolean $assertionsDisabled = IntFixedNodeBuilder.$assertionsDisabled;
                BytecodeManager.incBytecodes(2);
                if (!$assertionsDisabled) {
                    final long n2 = lcmp(n, 2147483639L);
                    BytecodeManager.incBytecodes(4);
                    if (n2 >= 0) {
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
        public Node.OfInt build() {
            try {
                final int curSize = this.curSize;
                final int length = this.array.length;
                BytecodeManager.incBytecodes(6);
                if (curSize < length) {
                    final String format = "Current size %d is less than fixed size %d";
                    final Object[] args = new Object[2];
                    final int n = 0;
                    final int curSize2 = this.curSize;
                    BytecodeManager.incBytecodes(8);
                    BytecodeManager.incBytecodes(1);
                    args[n] = curSize2;
                    final int n2 = 1;
                    final int length2 = this.array.length;
                    BytecodeManager.incBytecodes(7);
                    args[n2] = length2;
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    final String format2 = String.format(format, args);
                    BytecodeManager.incBytecodes(1);
                    final IllegalStateException ex = new IllegalStateException(format2);
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                BytecodeManager.incBytecodes(2);
                return this;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void begin(final long l) {
            try {
                final long n = lcmp(l, (long)this.array.length);
                BytecodeManager.incBytecodes(7);
                if (n != 0) {
                    final String format = "Begin size %d is not equal to fixed size %d";
                    final Object[] args = new Object[2];
                    final int n2 = 0;
                    BytecodeManager.incBytecodes(7);
                    BytecodeManager.incBytecodes(1);
                    args[n2] = l;
                    final int n3 = 1;
                    final int length = this.array.length;
                    BytecodeManager.incBytecodes(7);
                    args[n3] = length;
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    final String format2 = String.format(format, args);
                    BytecodeManager.incBytecodes(1);
                    final IllegalStateException ex = new IllegalStateException(format2);
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                this.curSize = 0;
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
                final int curSize = this.curSize;
                final int length = this.array.length;
                BytecodeManager.incBytecodes(6);
                if (curSize < length) {
                    this.array[this.curSize++] = n;
                    BytecodeManager.incBytecodes(12);
                    BytecodeManager.incBytecodes(1);
                    return;
                }
                final String format = "Accept exceeded fixed size of %d";
                final Object[] args = { null };
                final int n2 = 0;
                final int length2 = this.array.length;
                BytecodeManager.incBytecodes(9);
                BytecodeManager.incBytecodes(1);
                args[n2] = length2;
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                final String format2 = String.format(format, args);
                BytecodeManager.incBytecodes(1);
                final IllegalStateException ex = new IllegalStateException(format2);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void end() {
            try {
                final int curSize = this.curSize;
                final int length = this.array.length;
                BytecodeManager.incBytecodes(6);
                if (curSize < length) {
                    final String format = "End size %d is less than fixed size %d";
                    final Object[] args = new Object[2];
                    final int n = 0;
                    final int curSize2 = this.curSize;
                    BytecodeManager.incBytecodes(8);
                    BytecodeManager.incBytecodes(1);
                    args[n] = curSize2;
                    final int n2 = 1;
                    final int length2 = this.array.length;
                    BytecodeManager.incBytecodes(7);
                    args[n2] = length2;
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    final String format2 = String.format(format, args);
                    BytecodeManager.incBytecodes(1);
                    final IllegalStateException ex = new IllegalStateException(format2);
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public String toString() {
            try {
                final String format = "IntFixedNodeBuilder[%d][%s]";
                final Object[] args = new Object[2];
                final int n = 0;
                final int i = this.array.length - this.curSize;
                BytecodeManager.incBytecodes(10);
                BytecodeManager.incBytecodes(1);
                args[n] = i;
                final int n2 = 1;
                final int[] array = this.array;
                BytecodeManager.incBytecodes(6);
                args[n2] = Arrays.toString(array);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                final String format2 = String.format(format, args);
                BytecodeManager.incBytecodes(1);
                return format2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static {
            try {
                final Class<Nodes> clazz = Nodes.class;
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
    
    private static final class LongFixedNodeBuilder extends LongArrayNode implements Node.Builder.OfLong
    {
        static final /* synthetic */ boolean $assertionsDisabled;
        
        LongFixedNodeBuilder(final long n) {
            try {
                BytecodeManager.incBytecodes(3);
                super(n);
                final boolean $assertionsDisabled = LongFixedNodeBuilder.$assertionsDisabled;
                BytecodeManager.incBytecodes(2);
                if (!$assertionsDisabled) {
                    final long n2 = lcmp(n, 2147483639L);
                    BytecodeManager.incBytecodes(4);
                    if (n2 >= 0) {
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
        public Node.OfLong build() {
            try {
                final int curSize = this.curSize;
                final int length = this.array.length;
                BytecodeManager.incBytecodes(6);
                if (curSize < length) {
                    final String format = "Current size %d is less than fixed size %d";
                    final Object[] args = new Object[2];
                    final int n = 0;
                    final int curSize2 = this.curSize;
                    BytecodeManager.incBytecodes(8);
                    BytecodeManager.incBytecodes(1);
                    args[n] = curSize2;
                    final int n2 = 1;
                    final int length2 = this.array.length;
                    BytecodeManager.incBytecodes(7);
                    args[n2] = length2;
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    final String format2 = String.format(format, args);
                    BytecodeManager.incBytecodes(1);
                    final IllegalStateException ex = new IllegalStateException(format2);
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                BytecodeManager.incBytecodes(2);
                return this;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void begin(final long l) {
            try {
                final long n = lcmp(l, (long)this.array.length);
                BytecodeManager.incBytecodes(7);
                if (n != 0) {
                    final String format = "Begin size %d is not equal to fixed size %d";
                    final Object[] args = new Object[2];
                    final int n2 = 0;
                    BytecodeManager.incBytecodes(7);
                    BytecodeManager.incBytecodes(1);
                    args[n2] = l;
                    final int n3 = 1;
                    final int length = this.array.length;
                    BytecodeManager.incBytecodes(7);
                    args[n3] = length;
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    final String format2 = String.format(format, args);
                    BytecodeManager.incBytecodes(1);
                    final IllegalStateException ex = new IllegalStateException(format2);
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                this.curSize = 0;
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
                final int curSize = this.curSize;
                final int length = this.array.length;
                BytecodeManager.incBytecodes(6);
                if (curSize < length) {
                    this.array[this.curSize++] = n;
                    BytecodeManager.incBytecodes(12);
                    BytecodeManager.incBytecodes(1);
                    return;
                }
                final String format = "Accept exceeded fixed size of %d";
                final Object[] args = { null };
                final int n2 = 0;
                final int length2 = this.array.length;
                BytecodeManager.incBytecodes(9);
                BytecodeManager.incBytecodes(1);
                args[n2] = length2;
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                final String format2 = String.format(format, args);
                BytecodeManager.incBytecodes(1);
                final IllegalStateException ex = new IllegalStateException(format2);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void end() {
            try {
                final int curSize = this.curSize;
                final int length = this.array.length;
                BytecodeManager.incBytecodes(6);
                if (curSize < length) {
                    final String format = "End size %d is less than fixed size %d";
                    final Object[] args = new Object[2];
                    final int n = 0;
                    final int curSize2 = this.curSize;
                    BytecodeManager.incBytecodes(8);
                    BytecodeManager.incBytecodes(1);
                    args[n] = curSize2;
                    final int n2 = 1;
                    final int length2 = this.array.length;
                    BytecodeManager.incBytecodes(7);
                    args[n2] = length2;
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    final String format2 = String.format(format, args);
                    BytecodeManager.incBytecodes(1);
                    final IllegalStateException ex = new IllegalStateException(format2);
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public String toString() {
            try {
                final String format = "LongFixedNodeBuilder[%d][%s]";
                final Object[] args = new Object[2];
                final int n = 0;
                final int i = this.array.length - this.curSize;
                BytecodeManager.incBytecodes(10);
                BytecodeManager.incBytecodes(1);
                args[n] = i;
                final int n2 = 1;
                final long[] array = this.array;
                BytecodeManager.incBytecodes(6);
                args[n2] = Arrays.toString(array);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                final String format2 = String.format(format, args);
                BytecodeManager.incBytecodes(1);
                return format2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static {
            try {
                final Class<Nodes> clazz = Nodes.class;
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
    
    private static final class DoubleFixedNodeBuilder extends DoubleArrayNode implements Node.Builder.OfDouble
    {
        static final /* synthetic */ boolean $assertionsDisabled;
        
        DoubleFixedNodeBuilder(final long n) {
            try {
                BytecodeManager.incBytecodes(3);
                super(n);
                final boolean $assertionsDisabled = DoubleFixedNodeBuilder.$assertionsDisabled;
                BytecodeManager.incBytecodes(2);
                if (!$assertionsDisabled) {
                    final long n2 = lcmp(n, 2147483639L);
                    BytecodeManager.incBytecodes(4);
                    if (n2 >= 0) {
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
        public Node.OfDouble build() {
            try {
                final int curSize = this.curSize;
                final int length = this.array.length;
                BytecodeManager.incBytecodes(6);
                if (curSize < length) {
                    final String format = "Current size %d is less than fixed size %d";
                    final Object[] args = new Object[2];
                    final int n = 0;
                    final int curSize2 = this.curSize;
                    BytecodeManager.incBytecodes(8);
                    BytecodeManager.incBytecodes(1);
                    args[n] = curSize2;
                    final int n2 = 1;
                    final int length2 = this.array.length;
                    BytecodeManager.incBytecodes(7);
                    args[n2] = length2;
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    final String format2 = String.format(format, args);
                    BytecodeManager.incBytecodes(1);
                    final IllegalStateException ex = new IllegalStateException(format2);
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                BytecodeManager.incBytecodes(2);
                return this;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void begin(final long l) {
            try {
                final long n = lcmp(l, (long)this.array.length);
                BytecodeManager.incBytecodes(7);
                if (n != 0) {
                    final String format = "Begin size %d is not equal to fixed size %d";
                    final Object[] args = new Object[2];
                    final int n2 = 0;
                    BytecodeManager.incBytecodes(7);
                    BytecodeManager.incBytecodes(1);
                    args[n2] = l;
                    final int n3 = 1;
                    final int length = this.array.length;
                    BytecodeManager.incBytecodes(7);
                    args[n3] = length;
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    final String format2 = String.format(format, args);
                    BytecodeManager.incBytecodes(1);
                    final IllegalStateException ex = new IllegalStateException(format2);
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                this.curSize = 0;
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
                final int curSize = this.curSize;
                final int length = this.array.length;
                BytecodeManager.incBytecodes(6);
                if (curSize < length) {
                    this.array[this.curSize++] = n;
                    BytecodeManager.incBytecodes(12);
                    BytecodeManager.incBytecodes(1);
                    return;
                }
                final String format = "Accept exceeded fixed size of %d";
                final Object[] args = { null };
                final int n2 = 0;
                final int length2 = this.array.length;
                BytecodeManager.incBytecodes(9);
                BytecodeManager.incBytecodes(1);
                args[n2] = length2;
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                final String format2 = String.format(format, args);
                BytecodeManager.incBytecodes(1);
                final IllegalStateException ex = new IllegalStateException(format2);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void end() {
            try {
                final int curSize = this.curSize;
                final int length = this.array.length;
                BytecodeManager.incBytecodes(6);
                if (curSize < length) {
                    final String format = "End size %d is less than fixed size %d";
                    final Object[] args = new Object[2];
                    final int n = 0;
                    final int curSize2 = this.curSize;
                    BytecodeManager.incBytecodes(8);
                    BytecodeManager.incBytecodes(1);
                    args[n] = curSize2;
                    final int n2 = 1;
                    final int length2 = this.array.length;
                    BytecodeManager.incBytecodes(7);
                    args[n2] = length2;
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    final String format2 = String.format(format, args);
                    BytecodeManager.incBytecodes(1);
                    final IllegalStateException ex = new IllegalStateException(format2);
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public String toString() {
            try {
                final String format = "DoubleFixedNodeBuilder[%d][%s]";
                final Object[] args = new Object[2];
                final int n = 0;
                final int i = this.array.length - this.curSize;
                BytecodeManager.incBytecodes(10);
                BytecodeManager.incBytecodes(1);
                args[n] = i;
                final int n2 = 1;
                final double[] array = this.array;
                BytecodeManager.incBytecodes(6);
                args[n2] = Arrays.toString(array);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                final String format2 = String.format(format, args);
                BytecodeManager.incBytecodes(1);
                return format2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static {
            try {
                final Class<Nodes> clazz = Nodes.class;
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
    
    private static final class IntSpinedNodeBuilder extends SpinedBuffer.OfInt implements Node.OfInt, Node.Builder.OfInt
    {
        private boolean building;
        static final /* synthetic */ boolean $assertionsDisabled;
        
        IntSpinedNodeBuilder() {
            try {
                BytecodeManager.incBytecodes(2);
                this.building = false;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Spliterator.OfInt spliterator() {
            try {
                final boolean $assertionsDisabled = IntSpinedNodeBuilder.$assertionsDisabled;
                BytecodeManager.incBytecodes(2);
                if (!$assertionsDisabled) {
                    final boolean building = this.building;
                    BytecodeManager.incBytecodes(3);
                    if (building) {
                        final String detailMessage = "during building";
                        BytecodeManager.incBytecodes(4);
                        final AssertionError assertionError = new AssertionError((Object)detailMessage);
                        BytecodeManager.incBytecodes(1);
                        throw assertionError;
                    }
                }
                BytecodeManager.incBytecodes(2);
                final Spliterator.OfInt spliterator = super.spliterator();
                BytecodeManager.incBytecodes(1);
                return spliterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void forEach(final IntConsumer intConsumer) {
            try {
                final boolean $assertionsDisabled = IntSpinedNodeBuilder.$assertionsDisabled;
                BytecodeManager.incBytecodes(2);
                if (!$assertionsDisabled) {
                    final boolean building = this.building;
                    BytecodeManager.incBytecodes(3);
                    if (building) {
                        final String detailMessage = "during building";
                        BytecodeManager.incBytecodes(4);
                        final AssertionError assertionError = new AssertionError((Object)detailMessage);
                        BytecodeManager.incBytecodes(1);
                        throw assertionError;
                    }
                }
                BytecodeManager.incBytecodes(3);
                super.forEach(intConsumer);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void begin(final long n) {
            try {
                final boolean $assertionsDisabled = IntSpinedNodeBuilder.$assertionsDisabled;
                BytecodeManager.incBytecodes(2);
                if (!$assertionsDisabled) {
                    final boolean building = this.building;
                    BytecodeManager.incBytecodes(3);
                    if (building) {
                        final String detailMessage = "was already building";
                        BytecodeManager.incBytecodes(4);
                        final AssertionError assertionError = new AssertionError((Object)detailMessage);
                        BytecodeManager.incBytecodes(1);
                        throw assertionError;
                    }
                }
                this.building = true;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(2);
                this.clear();
                BytecodeManager.incBytecodes(3);
                this.ensureCapacity(n);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void accept(final int n) {
            try {
                final boolean $assertionsDisabled = IntSpinedNodeBuilder.$assertionsDisabled;
                BytecodeManager.incBytecodes(2);
                if (!$assertionsDisabled) {
                    final boolean building = this.building;
                    BytecodeManager.incBytecodes(3);
                    if (!building) {
                        final String detailMessage = "not building";
                        BytecodeManager.incBytecodes(4);
                        final AssertionError assertionError = new AssertionError((Object)detailMessage);
                        BytecodeManager.incBytecodes(1);
                        throw assertionError;
                    }
                }
                BytecodeManager.incBytecodes(3);
                super.accept(n);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void end() {
            try {
                final boolean $assertionsDisabled = IntSpinedNodeBuilder.$assertionsDisabled;
                BytecodeManager.incBytecodes(2);
                if (!$assertionsDisabled) {
                    final boolean building = this.building;
                    BytecodeManager.incBytecodes(3);
                    if (!building) {
                        final String detailMessage = "was not building";
                        BytecodeManager.incBytecodes(4);
                        final AssertionError assertionError = new AssertionError((Object)detailMessage);
                        BytecodeManager.incBytecodes(1);
                        throw assertionError;
                    }
                }
                this.building = false;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void copyInto(final int[] array, final int n) throws IndexOutOfBoundsException {
            try {
                final boolean $assertionsDisabled = IntSpinedNodeBuilder.$assertionsDisabled;
                BytecodeManager.incBytecodes(2);
                if (!$assertionsDisabled) {
                    final boolean building = this.building;
                    BytecodeManager.incBytecodes(3);
                    if (building) {
                        final String detailMessage = "during building";
                        BytecodeManager.incBytecodes(4);
                        final AssertionError assertionError = new AssertionError((Object)detailMessage);
                        BytecodeManager.incBytecodes(1);
                        throw assertionError;
                    }
                }
                BytecodeManager.incBytecodes(4);
                super.copyInto(array, n);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int[] asPrimitiveArray() {
            try {
                final boolean $assertionsDisabled = IntSpinedNodeBuilder.$assertionsDisabled;
                BytecodeManager.incBytecodes(2);
                if (!$assertionsDisabled) {
                    final boolean building = this.building;
                    BytecodeManager.incBytecodes(3);
                    if (building) {
                        final String detailMessage = "during building";
                        BytecodeManager.incBytecodes(4);
                        final AssertionError assertionError = new AssertionError((Object)detailMessage);
                        BytecodeManager.incBytecodes(1);
                        throw assertionError;
                    }
                }
                BytecodeManager.incBytecodes(2);
                final int[] array = super.asPrimitiveArray();
                BytecodeManager.incBytecodes(2);
                return array;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Node.OfInt build() {
            try {
                final boolean $assertionsDisabled = IntSpinedNodeBuilder.$assertionsDisabled;
                BytecodeManager.incBytecodes(2);
                if (!$assertionsDisabled) {
                    final boolean building = this.building;
                    BytecodeManager.incBytecodes(3);
                    if (building) {
                        final String detailMessage = "during building";
                        BytecodeManager.incBytecodes(4);
                        final AssertionError assertionError = new AssertionError((Object)detailMessage);
                        BytecodeManager.incBytecodes(1);
                        throw assertionError;
                    }
                }
                BytecodeManager.incBytecodes(2);
                return this;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static {
            try {
                final Class<Nodes> clazz = Nodes.class;
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
    
    private static final class LongSpinedNodeBuilder extends SpinedBuffer.OfLong implements Node.OfLong, Node.Builder.OfLong
    {
        private boolean building;
        static final /* synthetic */ boolean $assertionsDisabled;
        
        LongSpinedNodeBuilder() {
            try {
                BytecodeManager.incBytecodes(2);
                this.building = false;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Spliterator.OfLong spliterator() {
            try {
                final boolean $assertionsDisabled = LongSpinedNodeBuilder.$assertionsDisabled;
                BytecodeManager.incBytecodes(2);
                if (!$assertionsDisabled) {
                    final boolean building = this.building;
                    BytecodeManager.incBytecodes(3);
                    if (building) {
                        final String detailMessage = "during building";
                        BytecodeManager.incBytecodes(4);
                        final AssertionError assertionError = new AssertionError((Object)detailMessage);
                        BytecodeManager.incBytecodes(1);
                        throw assertionError;
                    }
                }
                BytecodeManager.incBytecodes(2);
                final Spliterator.OfLong spliterator = super.spliterator();
                BytecodeManager.incBytecodes(1);
                return spliterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void forEach(final LongConsumer longConsumer) {
            try {
                final boolean $assertionsDisabled = LongSpinedNodeBuilder.$assertionsDisabled;
                BytecodeManager.incBytecodes(2);
                if (!$assertionsDisabled) {
                    final boolean building = this.building;
                    BytecodeManager.incBytecodes(3);
                    if (building) {
                        final String detailMessage = "during building";
                        BytecodeManager.incBytecodes(4);
                        final AssertionError assertionError = new AssertionError((Object)detailMessage);
                        BytecodeManager.incBytecodes(1);
                        throw assertionError;
                    }
                }
                BytecodeManager.incBytecodes(3);
                super.forEach(longConsumer);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void begin(final long n) {
            try {
                final boolean $assertionsDisabled = LongSpinedNodeBuilder.$assertionsDisabled;
                BytecodeManager.incBytecodes(2);
                if (!$assertionsDisabled) {
                    final boolean building = this.building;
                    BytecodeManager.incBytecodes(3);
                    if (building) {
                        final String detailMessage = "was already building";
                        BytecodeManager.incBytecodes(4);
                        final AssertionError assertionError = new AssertionError((Object)detailMessage);
                        BytecodeManager.incBytecodes(1);
                        throw assertionError;
                    }
                }
                this.building = true;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(2);
                this.clear();
                BytecodeManager.incBytecodes(3);
                this.ensureCapacity(n);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void accept(final long n) {
            try {
                final boolean $assertionsDisabled = LongSpinedNodeBuilder.$assertionsDisabled;
                BytecodeManager.incBytecodes(2);
                if (!$assertionsDisabled) {
                    final boolean building = this.building;
                    BytecodeManager.incBytecodes(3);
                    if (!building) {
                        final String detailMessage = "not building";
                        BytecodeManager.incBytecodes(4);
                        final AssertionError assertionError = new AssertionError((Object)detailMessage);
                        BytecodeManager.incBytecodes(1);
                        throw assertionError;
                    }
                }
                BytecodeManager.incBytecodes(3);
                super.accept(n);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void end() {
            try {
                final boolean $assertionsDisabled = LongSpinedNodeBuilder.$assertionsDisabled;
                BytecodeManager.incBytecodes(2);
                if (!$assertionsDisabled) {
                    final boolean building = this.building;
                    BytecodeManager.incBytecodes(3);
                    if (!building) {
                        final String detailMessage = "was not building";
                        BytecodeManager.incBytecodes(4);
                        final AssertionError assertionError = new AssertionError((Object)detailMessage);
                        BytecodeManager.incBytecodes(1);
                        throw assertionError;
                    }
                }
                this.building = false;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void copyInto(final long[] array, final int n) {
            try {
                final boolean $assertionsDisabled = LongSpinedNodeBuilder.$assertionsDisabled;
                BytecodeManager.incBytecodes(2);
                if (!$assertionsDisabled) {
                    final boolean building = this.building;
                    BytecodeManager.incBytecodes(3);
                    if (building) {
                        final String detailMessage = "during building";
                        BytecodeManager.incBytecodes(4);
                        final AssertionError assertionError = new AssertionError((Object)detailMessage);
                        BytecodeManager.incBytecodes(1);
                        throw assertionError;
                    }
                }
                BytecodeManager.incBytecodes(4);
                super.copyInto(array, n);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public long[] asPrimitiveArray() {
            try {
                final boolean $assertionsDisabled = LongSpinedNodeBuilder.$assertionsDisabled;
                BytecodeManager.incBytecodes(2);
                if (!$assertionsDisabled) {
                    final boolean building = this.building;
                    BytecodeManager.incBytecodes(3);
                    if (building) {
                        final String detailMessage = "during building";
                        BytecodeManager.incBytecodes(4);
                        final AssertionError assertionError = new AssertionError((Object)detailMessage);
                        BytecodeManager.incBytecodes(1);
                        throw assertionError;
                    }
                }
                BytecodeManager.incBytecodes(2);
                final long[] array = super.asPrimitiveArray();
                BytecodeManager.incBytecodes(2);
                return array;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Node.OfLong build() {
            try {
                final boolean $assertionsDisabled = LongSpinedNodeBuilder.$assertionsDisabled;
                BytecodeManager.incBytecodes(2);
                if (!$assertionsDisabled) {
                    final boolean building = this.building;
                    BytecodeManager.incBytecodes(3);
                    if (building) {
                        final String detailMessage = "during building";
                        BytecodeManager.incBytecodes(4);
                        final AssertionError assertionError = new AssertionError((Object)detailMessage);
                        BytecodeManager.incBytecodes(1);
                        throw assertionError;
                    }
                }
                BytecodeManager.incBytecodes(2);
                return this;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static {
            try {
                final Class<Nodes> clazz = Nodes.class;
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
    
    private static final class DoubleSpinedNodeBuilder extends SpinedBuffer.OfDouble implements Node.OfDouble, Node.Builder.OfDouble
    {
        private boolean building;
        static final /* synthetic */ boolean $assertionsDisabled;
        
        DoubleSpinedNodeBuilder() {
            try {
                BytecodeManager.incBytecodes(2);
                this.building = false;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Spliterator.OfDouble spliterator() {
            try {
                final boolean $assertionsDisabled = DoubleSpinedNodeBuilder.$assertionsDisabled;
                BytecodeManager.incBytecodes(2);
                if (!$assertionsDisabled) {
                    final boolean building = this.building;
                    BytecodeManager.incBytecodes(3);
                    if (building) {
                        final String detailMessage = "during building";
                        BytecodeManager.incBytecodes(4);
                        final AssertionError assertionError = new AssertionError((Object)detailMessage);
                        BytecodeManager.incBytecodes(1);
                        throw assertionError;
                    }
                }
                BytecodeManager.incBytecodes(2);
                final Spliterator.OfDouble spliterator = super.spliterator();
                BytecodeManager.incBytecodes(1);
                return spliterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void forEach(final DoubleConsumer doubleConsumer) {
            try {
                final boolean $assertionsDisabled = DoubleSpinedNodeBuilder.$assertionsDisabled;
                BytecodeManager.incBytecodes(2);
                if (!$assertionsDisabled) {
                    final boolean building = this.building;
                    BytecodeManager.incBytecodes(3);
                    if (building) {
                        final String detailMessage = "during building";
                        BytecodeManager.incBytecodes(4);
                        final AssertionError assertionError = new AssertionError((Object)detailMessage);
                        BytecodeManager.incBytecodes(1);
                        throw assertionError;
                    }
                }
                BytecodeManager.incBytecodes(3);
                super.forEach(doubleConsumer);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void begin(final long n) {
            try {
                final boolean $assertionsDisabled = DoubleSpinedNodeBuilder.$assertionsDisabled;
                BytecodeManager.incBytecodes(2);
                if (!$assertionsDisabled) {
                    final boolean building = this.building;
                    BytecodeManager.incBytecodes(3);
                    if (building) {
                        final String detailMessage = "was already building";
                        BytecodeManager.incBytecodes(4);
                        final AssertionError assertionError = new AssertionError((Object)detailMessage);
                        BytecodeManager.incBytecodes(1);
                        throw assertionError;
                    }
                }
                this.building = true;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(2);
                this.clear();
                BytecodeManager.incBytecodes(3);
                this.ensureCapacity(n);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void accept(final double n) {
            try {
                final boolean $assertionsDisabled = DoubleSpinedNodeBuilder.$assertionsDisabled;
                BytecodeManager.incBytecodes(2);
                if (!$assertionsDisabled) {
                    final boolean building = this.building;
                    BytecodeManager.incBytecodes(3);
                    if (!building) {
                        final String detailMessage = "not building";
                        BytecodeManager.incBytecodes(4);
                        final AssertionError assertionError = new AssertionError((Object)detailMessage);
                        BytecodeManager.incBytecodes(1);
                        throw assertionError;
                    }
                }
                BytecodeManager.incBytecodes(3);
                super.accept(n);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void end() {
            try {
                final boolean $assertionsDisabled = DoubleSpinedNodeBuilder.$assertionsDisabled;
                BytecodeManager.incBytecodes(2);
                if (!$assertionsDisabled) {
                    final boolean building = this.building;
                    BytecodeManager.incBytecodes(3);
                    if (!building) {
                        final String detailMessage = "was not building";
                        BytecodeManager.incBytecodes(4);
                        final AssertionError assertionError = new AssertionError((Object)detailMessage);
                        BytecodeManager.incBytecodes(1);
                        throw assertionError;
                    }
                }
                this.building = false;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void copyInto(final double[] array, final int n) {
            try {
                final boolean $assertionsDisabled = DoubleSpinedNodeBuilder.$assertionsDisabled;
                BytecodeManager.incBytecodes(2);
                if (!$assertionsDisabled) {
                    final boolean building = this.building;
                    BytecodeManager.incBytecodes(3);
                    if (building) {
                        final String detailMessage = "during building";
                        BytecodeManager.incBytecodes(4);
                        final AssertionError assertionError = new AssertionError((Object)detailMessage);
                        BytecodeManager.incBytecodes(1);
                        throw assertionError;
                    }
                }
                BytecodeManager.incBytecodes(4);
                super.copyInto(array, n);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public double[] asPrimitiveArray() {
            try {
                final boolean $assertionsDisabled = DoubleSpinedNodeBuilder.$assertionsDisabled;
                BytecodeManager.incBytecodes(2);
                if (!$assertionsDisabled) {
                    final boolean building = this.building;
                    BytecodeManager.incBytecodes(3);
                    if (building) {
                        final String detailMessage = "during building";
                        BytecodeManager.incBytecodes(4);
                        final AssertionError assertionError = new AssertionError((Object)detailMessage);
                        BytecodeManager.incBytecodes(1);
                        throw assertionError;
                    }
                }
                BytecodeManager.incBytecodes(2);
                final double[] array = super.asPrimitiveArray();
                BytecodeManager.incBytecodes(2);
                return array;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Node.OfDouble build() {
            try {
                final boolean $assertionsDisabled = DoubleSpinedNodeBuilder.$assertionsDisabled;
                BytecodeManager.incBytecodes(2);
                if (!$assertionsDisabled) {
                    final boolean building = this.building;
                    BytecodeManager.incBytecodes(3);
                    if (building) {
                        final String detailMessage = "during building";
                        BytecodeManager.incBytecodes(4);
                        final AssertionError assertionError = new AssertionError((Object)detailMessage);
                        BytecodeManager.incBytecodes(1);
                        throw assertionError;
                    }
                }
                BytecodeManager.incBytecodes(2);
                return this;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static {
            try {
                final Class<Nodes> clazz = Nodes.class;
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
    
    private abstract static class SizedCollectorTask<P_IN, P_OUT, T_SINK extends Sink<P_OUT>, K extends SizedCollectorTask<P_IN, P_OUT, T_SINK, K>> extends CountedCompleter<Void> implements Sink<P_OUT>
    {
        protected final Spliterator<P_IN> spliterator;
        protected final PipelineHelper<P_OUT> helper;
        protected final long targetSize;
        protected long offset;
        protected long length;
        protected int index;
        protected int fence;
        static final /* synthetic */ boolean $assertionsDisabled;
        
        SizedCollectorTask(final Spliterator<P_IN> spliterator, final PipelineHelper<P_OUT> helper, final int n) {
            try {
                BytecodeManager.incBytecodes(2);
                final boolean $assertionsDisabled = SizedCollectorTask.$assertionsDisabled;
                BytecodeManager.incBytecodes(2);
                if (!$assertionsDisabled) {
                    final int n2 = 16384;
                    BytecodeManager.incBytecodes(3);
                    final boolean hasCharacteristics = spliterator.hasCharacteristics(n2);
                    BytecodeManager.incBytecodes(1);
                    if (!hasCharacteristics) {
                        BytecodeManager.incBytecodes(3);
                        final AssertionError assertionError = new AssertionError();
                        BytecodeManager.incBytecodes(1);
                        throw assertionError;
                    }
                }
                this.spliterator = spliterator;
                BytecodeManager.incBytecodes(3);
                this.helper = helper;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(3);
                final long estimateSize = spliterator.estimateSize();
                BytecodeManager.incBytecodes(1);
                this.targetSize = AbstractTask.suggestTargetSize(estimateSize);
                BytecodeManager.incBytecodes(1);
                this.offset = 0L;
                BytecodeManager.incBytecodes(3);
                this.length = n;
                BytecodeManager.incBytecodes(4);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        SizedCollectorTask(final K k, final Spliterator<P_IN> spliterator, final long l, final long n, final int i) {
            try {
                BytecodeManager.incBytecodes(3);
                super(k);
                final boolean $assertionsDisabled = SizedCollectorTask.$assertionsDisabled;
                BytecodeManager.incBytecodes(2);
                if (!$assertionsDisabled) {
                    final int n2 = 16384;
                    BytecodeManager.incBytecodes(3);
                    final boolean hasCharacteristics = spliterator.hasCharacteristics(n2);
                    BytecodeManager.incBytecodes(1);
                    if (!hasCharacteristics) {
                        BytecodeManager.incBytecodes(3);
                        final AssertionError assertionError = new AssertionError();
                        BytecodeManager.incBytecodes(1);
                        throw assertionError;
                    }
                }
                this.spliterator = spliterator;
                BytecodeManager.incBytecodes(3);
                this.helper = k.helper;
                BytecodeManager.incBytecodes(4);
                this.targetSize = k.targetSize;
                BytecodeManager.incBytecodes(4);
                this.offset = l;
                BytecodeManager.incBytecodes(3);
                this.length = n;
                BytecodeManager.incBytecodes(3);
                final long n3 = lcmp(l, 0L);
                BytecodeManager.incBytecodes(4);
                if (n3 >= 0) {
                    final long n4 = lcmp(n, 0L);
                    BytecodeManager.incBytecodes(4);
                    if (n4 >= 0) {
                        final long n5 = lcmp(l + n - 1L, (long)i);
                        BytecodeManager.incBytecodes(9);
                        if (n5 < 0) {
                            BytecodeManager.incBytecodes(1);
                            return;
                        }
                    }
                }
                final String format = "offset and length interval [%d, %d + %d) is not within array size interval [0, %d)";
                final Object[] args = new Object[4];
                final int n6 = 0;
                BytecodeManager.incBytecodes(7);
                BytecodeManager.incBytecodes(1);
                args[n6] = l;
                final int n7 = 1;
                BytecodeManager.incBytecodes(5);
                args[n7] = l;
                final int n8 = 2;
                BytecodeManager.incBytecodes(5);
                args[n8] = n;
                final int n9 = 3;
                BytecodeManager.incBytecodes(5);
                args[n9] = i;
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                final String format2 = String.format(format, args);
                BytecodeManager.incBytecodes(1);
                final IllegalArgumentException ex = new IllegalArgumentException(format2);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void compute() {
            try {
                SizedCollectorTask<P_IN, P_OUT, T_SINK, SizedCollectorTask> child = (SizedCollectorTask<P_IN, P_OUT, T_SINK, SizedCollectorTask>)this;
                BytecodeManager.incBytecodes(2);
                final Spliterator<P_IN> spliterator = this.spliterator;
                BytecodeManager.incBytecodes(3);
                while (true) {
                    final Spliterator<P_IN> spliterator2 = spliterator;
                    BytecodeManager.incBytecodes(2);
                    final long n = lcmp(spliterator2.estimateSize(), child.targetSize);
                    BytecodeManager.incBytecodes(4);
                    if (n <= 0) {
                        break;
                    }
                    final Spliterator<P_IN> spliterator3 = spliterator;
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    final Spliterator<P_IN> trySplit;
                    final Spliterator<P_IN> spliterator4 = trySplit = spliterator3.trySplit();
                    BytecodeManager.incBytecodes(3);
                    if (spliterator4 == null) {
                        break;
                    }
                    final SizedCollectorTask<P_IN, P_OUT, T_SINK, SizedCollectorTask> sizedCollectorTask = child;
                    final int pendingCount = 1;
                    BytecodeManager.incBytecodes(3);
                    sizedCollectorTask.setPendingCount(pendingCount);
                    final Spliterator<P_IN> spliterator5 = trySplit;
                    BytecodeManager.incBytecodes(2);
                    final long estimateSize = spliterator5.estimateSize();
                    BytecodeManager.incBytecodes(1);
                    final SizedCollectorTask<P_IN, P_OUT, T_SINK, SizedCollectorTask> sizedCollectorTask2 = child;
                    final Spliterator<P_IN> spliterator6 = trySplit;
                    final long offset = child.offset;
                    final long n2 = estimateSize;
                    BytecodeManager.incBytecodes(6);
                    final SizedCollectorTask<P_IN, P_OUT, T_SINK, SizedCollectorTask> child2 = sizedCollectorTask2.makeChild(spliterator6, offset, n2);
                    BytecodeManager.incBytecodes(1);
                    child2.fork();
                    BytecodeManager.incBytecodes(1);
                    final SizedCollectorTask<P_IN, P_OUT, T_SINK, SizedCollectorTask> sizedCollectorTask3 = child;
                    final Spliterator<P_IN> spliterator7 = spliterator;
                    final long n3 = child.offset + estimateSize;
                    final long n4 = child.length - estimateSize;
                    BytecodeManager.incBytecodes(11);
                    child = sizedCollectorTask3.makeChild(spliterator7, n3, n4);
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                }
                final boolean $assertionsDisabled = SizedCollectorTask.$assertionsDisabled;
                BytecodeManager.incBytecodes(2);
                if (!$assertionsDisabled) {
                    final long n5 = lcmp(child.offset + child.length, 2147483639L);
                    BytecodeManager.incBytecodes(8);
                    if (n5 >= 0) {
                        BytecodeManager.incBytecodes(3);
                        final AssertionError assertionError = new AssertionError();
                        BytecodeManager.incBytecodes(1);
                        throw assertionError;
                    }
                }
                final SizedCollectorTask<P_IN, P_OUT, T_SINK, SizedCollectorTask> sizedCollectorTask4 = child;
                BytecodeManager.incBytecodes(2);
                final PipelineHelper<P_OUT> helper = child.helper;
                final SizedCollectorTask<P_IN, P_OUT, T_SINK, SizedCollectorTask> sizedCollectorTask5 = sizedCollectorTask4;
                final Spliterator<P_IN> spliterator8 = spliterator;
                BytecodeManager.incBytecodes(5);
                helper.wrapAndCopyInto((SizedCollectorTask<P_IN, P_OUT, T_SINK, SizedCollectorTask<P_IN, P_OUT, T_SINK, SizedCollectorTask<P_IN, P_OUT, T_SINK, SizedCollectorTask>>>)sizedCollectorTask5, spliterator8);
                BytecodeManager.incBytecodes(1);
                final SizedCollectorTask<P_IN, P_OUT, T_SINK, SizedCollectorTask> sizedCollectorTask6 = child;
                BytecodeManager.incBytecodes(2);
                sizedCollectorTask6.propagateCompletion();
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        abstract K makeChild(final Spliterator<P_IN> p0, final long p1, final long p2);
        
        @Override
        public void begin(final long n) {
            try {
                final long n2 = lcmp(n, this.length);
                BytecodeManager.incBytecodes(5);
                if (n2 > 0) {
                    final String s = "size passed to Sink.begin exceeds array length";
                    BytecodeManager.incBytecodes(4);
                    final IllegalStateException ex = new IllegalStateException(s);
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                this.index = (int)this.offset;
                BytecodeManager.incBytecodes(5);
                this.fence = this.index + (int)this.length;
                BytecodeManager.incBytecodes(8);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static {
            try {
                final Class<Nodes> clazz = Nodes.class;
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
        
        static final class OfRef<P_IN, P_OUT> extends SizedCollectorTask<P_IN, P_OUT, Sink<P_OUT>, OfRef<P_IN, P_OUT>> implements Sink<P_OUT>
        {
            private final P_OUT[] array;
            
            OfRef(final Spliterator<P_IN> spliterator, final PipelineHelper<P_OUT> pipelineHelper, final P_OUT[] array) {
                try {
                    final int length = array.length;
                    BytecodeManager.incBytecodes(6);
                    super(spliterator, pipelineHelper, length);
                    this.array = array;
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            OfRef(final OfRef<P_IN, P_OUT> ofRef, final Spliterator<P_IN> spliterator, final long n, final long n2) {
                try {
                    final int length = ofRef.array.length;
                    BytecodeManager.incBytecodes(9);
                    super(ofRef, spliterator, n, n2, length);
                    this.array = ofRef.array;
                    BytecodeManager.incBytecodes(4);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            OfRef<P_IN, P_OUT> makeChild(final Spliterator<P_IN> spliterator, final long n, final long n2) {
                try {
                    BytecodeManager.incBytecodes(7);
                    final OfRef<P_IN, P_OUT> ofRef = new OfRef<P_IN, P_OUT>(this, spliterator, n, n2);
                    BytecodeManager.incBytecodes(1);
                    return ofRef;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public void accept(final P_OUT p_OUT) {
                try {
                    final int index = this.index;
                    final int fence = this.fence;
                    BytecodeManager.incBytecodes(5);
                    if (index >= fence) {
                        final int index2 = this.index;
                        BytecodeManager.incBytecodes(5);
                        final String string = Integer.toString(index2);
                        BytecodeManager.incBytecodes(1);
                        final IndexOutOfBoundsException ex = new IndexOutOfBoundsException(string);
                        BytecodeManager.incBytecodes(1);
                        throw ex;
                    }
                    this.array[this.index++] = p_OUT;
                    BytecodeManager.incBytecodes(11);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
        
        static final class OfInt<P_IN> extends SizedCollectorTask<P_IN, Integer, Sink.OfInt, OfInt<P_IN>> implements Sink.OfInt
        {
            private final int[] array;
            
            OfInt(final Spliterator<P_IN> spliterator, final PipelineHelper<Integer> pipelineHelper, final int[] array) {
                try {
                    final int length = array.length;
                    BytecodeManager.incBytecodes(6);
                    super(spliterator, (PipelineHelper<Object>)pipelineHelper, length);
                    this.array = array;
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            OfInt(final OfInt<P_IN> ofInt, final Spliterator<P_IN> spliterator, final long n, final long n2) {
                try {
                    final int length = ofInt.array.length;
                    BytecodeManager.incBytecodes(9);
                    super(ofInt, spliterator, n, n2, length);
                    this.array = ofInt.array;
                    BytecodeManager.incBytecodes(4);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            OfInt<P_IN> makeChild(final Spliterator<P_IN> spliterator, final long n, final long n2) {
                try {
                    BytecodeManager.incBytecodes(7);
                    final OfInt<P_IN> ofInt = new OfInt<P_IN>(this, spliterator, n, n2);
                    BytecodeManager.incBytecodes(1);
                    return ofInt;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public void accept(final int n) {
                try {
                    final int index = this.index;
                    final int fence = this.fence;
                    BytecodeManager.incBytecodes(5);
                    if (index >= fence) {
                        final int index2 = this.index;
                        BytecodeManager.incBytecodes(5);
                        final String string = Integer.toString(index2);
                        BytecodeManager.incBytecodes(1);
                        final IndexOutOfBoundsException ex = new IndexOutOfBoundsException(string);
                        BytecodeManager.incBytecodes(1);
                        throw ex;
                    }
                    this.array[this.index++] = n;
                    BytecodeManager.incBytecodes(11);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
        
        static final class OfLong<P_IN> extends SizedCollectorTask<P_IN, Long, Sink.OfLong, OfLong<P_IN>> implements Sink.OfLong
        {
            private final long[] array;
            
            OfLong(final Spliterator<P_IN> spliterator, final PipelineHelper<Long> pipelineHelper, final long[] array) {
                try {
                    final int length = array.length;
                    BytecodeManager.incBytecodes(6);
                    super(spliterator, (PipelineHelper<Object>)pipelineHelper, length);
                    this.array = array;
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            OfLong(final OfLong<P_IN> ofLong, final Spliterator<P_IN> spliterator, final long n, final long n2) {
                try {
                    final int length = ofLong.array.length;
                    BytecodeManager.incBytecodes(9);
                    super(ofLong, spliterator, n, n2, length);
                    this.array = ofLong.array;
                    BytecodeManager.incBytecodes(4);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            OfLong<P_IN> makeChild(final Spliterator<P_IN> spliterator, final long n, final long n2) {
                try {
                    BytecodeManager.incBytecodes(7);
                    final OfLong<P_IN> ofLong = new OfLong<P_IN>(this, spliterator, n, n2);
                    BytecodeManager.incBytecodes(1);
                    return ofLong;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public void accept(final long n) {
                try {
                    final int index = this.index;
                    final int fence = this.fence;
                    BytecodeManager.incBytecodes(5);
                    if (index >= fence) {
                        final int index2 = this.index;
                        BytecodeManager.incBytecodes(5);
                        final String string = Integer.toString(index2);
                        BytecodeManager.incBytecodes(1);
                        final IndexOutOfBoundsException ex = new IndexOutOfBoundsException(string);
                        BytecodeManager.incBytecodes(1);
                        throw ex;
                    }
                    this.array[this.index++] = n;
                    BytecodeManager.incBytecodes(11);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
        
        static final class OfDouble<P_IN> extends SizedCollectorTask<P_IN, Double, Sink.OfDouble, OfDouble<P_IN>> implements Sink.OfDouble
        {
            private final double[] array;
            
            OfDouble(final Spliterator<P_IN> spliterator, final PipelineHelper<Double> pipelineHelper, final double[] array) {
                try {
                    final int length = array.length;
                    BytecodeManager.incBytecodes(6);
                    super(spliterator, (PipelineHelper<Object>)pipelineHelper, length);
                    this.array = array;
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            OfDouble(final OfDouble<P_IN> ofDouble, final Spliterator<P_IN> spliterator, final long n, final long n2) {
                try {
                    final int length = ofDouble.array.length;
                    BytecodeManager.incBytecodes(9);
                    super(ofDouble, spliterator, n, n2, length);
                    this.array = ofDouble.array;
                    BytecodeManager.incBytecodes(4);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            OfDouble<P_IN> makeChild(final Spliterator<P_IN> spliterator, final long n, final long n2) {
                try {
                    BytecodeManager.incBytecodes(7);
                    final OfDouble<P_IN> ofDouble = new OfDouble<P_IN>(this, spliterator, n, n2);
                    BytecodeManager.incBytecodes(1);
                    return ofDouble;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public void accept(final double n) {
                try {
                    final int index = this.index;
                    final int fence = this.fence;
                    BytecodeManager.incBytecodes(5);
                    if (index >= fence) {
                        final int index2 = this.index;
                        BytecodeManager.incBytecodes(5);
                        final String string = Integer.toString(index2);
                        BytecodeManager.incBytecodes(1);
                        final IndexOutOfBoundsException ex = new IndexOutOfBoundsException(string);
                        BytecodeManager.incBytecodes(1);
                        throw ex;
                    }
                    this.array[this.index++] = n;
                    BytecodeManager.incBytecodes(11);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
    }
    
    private abstract static class ToArrayTask<T, T_NODE extends Node<T>, K extends ToArrayTask<T, T_NODE, K>> extends CountedCompleter<Void>
    {
        protected final T_NODE node;
        protected final int offset;
        
        ToArrayTask(final T_NODE node, final int offset) {
            try {
                BytecodeManager.incBytecodes(2);
                this.node = node;
                BytecodeManager.incBytecodes(3);
                this.offset = offset;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        ToArrayTask(final K k, final T_NODE node, final int offset) {
            try {
                BytecodeManager.incBytecodes(3);
                super(k);
                this.node = node;
                BytecodeManager.incBytecodes(3);
                this.offset = offset;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        abstract void copyNodeToArray();
        
        abstract K makeChild(final int p0, final int p1);
        
        @Override
        public void compute() {
            try {
                ToArrayTask<T, T_NODE, ToArrayTask> child = (ToArrayTask<T, T_NODE, ToArrayTask>)this;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final Node<T> node = child.node;
                    BytecodeManager.incBytecodes(3);
                    final int childCount = node.getChildCount();
                    BytecodeManager.incBytecodes(1);
                    if (childCount == 0) {
                        break;
                    }
                    final ToArrayTask<T, T_NODE, ToArrayTask> toArrayTask = child;
                    final Node<T> node2 = child.node;
                    BytecodeManager.incBytecodes(4);
                    final int pendingCount = node2.getChildCount() - 1;
                    BytecodeManager.incBytecodes(3);
                    toArrayTask.setPendingCount(pendingCount);
                    int n = 0;
                    BytecodeManager.incBytecodes(2);
                    int n2 = 0;
                    BytecodeManager.incBytecodes(2);
                    while (true) {
                        final int n3 = n2;
                        final Node<T> node3 = child.node;
                        BytecodeManager.incBytecodes(4);
                        final int n4 = node3.getChildCount() - 1;
                        BytecodeManager.incBytecodes(3);
                        if (n3 >= n4) {
                            break;
                        }
                        final ToArrayTask<T, T_NODE, ToArrayTask> toArrayTask2 = child;
                        final int n5 = n2;
                        final int n6 = child.offset + n;
                        BytecodeManager.incBytecodes(7);
                        final ToArrayTask child2 = toArrayTask2.makeChild(n5, n6);
                        BytecodeManager.incBytecodes(1);
                        final long n7 = n;
                        final Node<T> node4 = child2.node;
                        BytecodeManager.incBytecodes(5);
                        n = (int)(n7 + node4.count());
                        BytecodeManager.incBytecodes(3);
                        final ToArrayTask toArrayTask3 = child2;
                        BytecodeManager.incBytecodes(2);
                        toArrayTask3.fork();
                        BytecodeManager.incBytecodes(1);
                        ++n2;
                        BytecodeManager.incBytecodes(2);
                    }
                    final ToArrayTask<T, T_NODE, ToArrayTask> toArrayTask4 = child;
                    final int n8 = n2;
                    final int n9 = child.offset + n;
                    BytecodeManager.incBytecodes(7);
                    child = toArrayTask4.makeChild(n8, n9);
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                }
                final ToArrayTask<T, T_NODE, ToArrayTask> toArrayTask5 = child;
                BytecodeManager.incBytecodes(2);
                toArrayTask5.copyNodeToArray();
                final ToArrayTask<T, T_NODE, ToArrayTask> toArrayTask6 = child;
                BytecodeManager.incBytecodes(2);
                toArrayTask6.propagateCompletion();
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private static final class OfRef<T> extends ToArrayTask<T, Node<T>, OfRef<T>>
        {
            private final T[] array;
            
            private OfRef(final Node<T> node, final T[] array, final int n) {
                try {
                    BytecodeManager.incBytecodes(4);
                    super(node, n);
                    this.array = array;
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            private OfRef(final OfRef<T> ofRef, final Node<T> node, final int n) {
                try {
                    BytecodeManager.incBytecodes(5);
                    super(ofRef, node, n);
                    this.array = ofRef.array;
                    BytecodeManager.incBytecodes(4);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            OfRef<T> makeChild(final int n, final int n2) {
                try {
                    final Node<T> node = this.node;
                    BytecodeManager.incBytecodes(7);
                    final Node<T> child = node.getChild(n);
                    BytecodeManager.incBytecodes(2);
                    final OfRef ofRef = new OfRef<T>((OfRef<Object>)this, (Node<Object>)child, n2);
                    BytecodeManager.incBytecodes(1);
                    return ofRef;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            void copyNodeToArray() {
                try {
                    final Node<T> node = this.node;
                    final T[] array = this.array;
                    final int offset = this.offset;
                    BytecodeManager.incBytecodes(7);
                    node.copyInto((T[])array, offset);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
        
        private static class OfPrimitive<T, T_CONS, T_ARR, T_SPLITR extends Spliterator.OfPrimitive<T, T_CONS, T_SPLITR>, T_NODE extends Node.OfPrimitive<T, T_CONS, T_ARR, T_SPLITR, T_NODE>> extends ToArrayTask<T, T_NODE, OfPrimitive<T, T_CONS, T_ARR, T_SPLITR, T_NODE>>
        {
            private final T_ARR array;
            
            private OfPrimitive(final T_NODE t_NODE, final T_ARR array, final int n) {
                try {
                    BytecodeManager.incBytecodes(4);
                    super(t_NODE, n);
                    this.array = array;
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            private OfPrimitive(final OfPrimitive<T, T_CONS, T_ARR, T_SPLITR, T_NODE> ofPrimitive, final T_NODE t_NODE, final int n) {
                try {
                    BytecodeManager.incBytecodes(5);
                    super(ofPrimitive, t_NODE, n);
                    this.array = ofPrimitive.array;
                    BytecodeManager.incBytecodes(4);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            OfPrimitive<T, T_CONS, T_ARR, T_SPLITR, T_NODE> makeChild(final int n, final int n2) {
                try {
                    final Node.OfPrimitive ofPrimitive = (Node.OfPrimitive)this.node;
                    BytecodeManager.incBytecodes(8);
                    final Node.OfPrimitive child = ofPrimitive.getChild(n);
                    BytecodeManager.incBytecodes(2);
                    final OfPrimitive ofPrimitive2 = new OfPrimitive<T, T_CONS, T_ARR, T_SPLITR, T_NODE>((OfPrimitive<Object, Object, Object, Spliterator.OfPrimitive, Node.OfPrimitive>)this, child, n2);
                    BytecodeManager.incBytecodes(1);
                    return ofPrimitive2;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            void copyNodeToArray() {
                try {
                    final Node.OfPrimitive ofPrimitive = (Node.OfPrimitive)this.node;
                    final T_ARR array = this.array;
                    final int offset = this.offset;
                    BytecodeManager.incBytecodes(8);
                    ofPrimitive.copyInto(array, offset);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
        
        private static final class OfInt extends OfPrimitive<Integer, IntConsumer, int[], Spliterator.OfInt, Node.OfInt>
        {
            private OfInt(final Node.OfInt ofInt, final int[] array, final int n) {
                try {
                    final Object object = null;
                    BytecodeManager.incBytecodes(6);
                    super((Node.OfPrimitive)ofInt, (Object)array, n);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
        
        private static final class OfLong extends OfPrimitive<Long, LongConsumer, long[], Spliterator.OfLong, Node.OfLong>
        {
            private OfLong(final Node.OfLong ofLong, final long[] array, final int n) {
                try {
                    final Object object = null;
                    BytecodeManager.incBytecodes(6);
                    super((Node.OfPrimitive)ofLong, (Object)array, n);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
        
        private static final class OfDouble extends OfPrimitive<Double, DoubleConsumer, double[], Spliterator.OfDouble, Node.OfDouble>
        {
            private OfDouble(final Node.OfDouble ofDouble, final double[] array, final int n) {
                try {
                    final Object object = null;
                    BytecodeManager.incBytecodes(6);
                    super((Node.OfPrimitive)ofDouble, (Object)array, n);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
    }
    
    private static class CollectorTask<P_IN, P_OUT, T_NODE extends Node<P_OUT>, T_BUILDER extends Node.Builder<P_OUT>> extends AbstractTask<P_IN, P_OUT, T_NODE, CollectorTask<P_IN, P_OUT, T_NODE, T_BUILDER>>
    {
        protected final PipelineHelper<P_OUT> helper;
        protected final LongFunction<T_BUILDER> builderFactory;
        protected final BinaryOperator<T_NODE> concFactory;
        
        CollectorTask(final PipelineHelper<P_OUT> helper, final Spliterator<P_IN> spliterator, final LongFunction<T_BUILDER> builderFactory, final BinaryOperator<T_NODE> concFactory) {
            try {
                BytecodeManager.incBytecodes(4);
                super(helper, spliterator);
                this.helper = helper;
                BytecodeManager.incBytecodes(3);
                this.builderFactory = builderFactory;
                BytecodeManager.incBytecodes(3);
                this.concFactory = concFactory;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        CollectorTask(final CollectorTask<P_IN, P_OUT, T_NODE, T_BUILDER> collectorTask, final Spliterator<P_IN> spliterator) {
            try {
                BytecodeManager.incBytecodes(4);
                super(collectorTask, spliterator);
                this.helper = collectorTask.helper;
                BytecodeManager.incBytecodes(4);
                this.builderFactory = collectorTask.builderFactory;
                BytecodeManager.incBytecodes(4);
                this.concFactory = collectorTask.concFactory;
                BytecodeManager.incBytecodes(4);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        protected CollectorTask<P_IN, P_OUT, T_NODE, T_BUILDER> makeChild(final Spliterator<P_IN> spliterator) {
            try {
                BytecodeManager.incBytecodes(5);
                final CollectorTask<P_IN, P_OUT, T_NODE, T_BUILDER> collectorTask = new CollectorTask<P_IN, P_OUT, T_NODE, T_BUILDER>(this, spliterator);
                BytecodeManager.incBytecodes(1);
                return collectorTask;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        protected T_NODE doLeaf() {
            try {
                final LongFunction<T_BUILDER> builderFactory = this.builderFactory;
                final PipelineHelper<P_OUT> helper = this.helper;
                final Spliterator<P_IN> spliterator = this.spliterator;
                BytecodeManager.incBytecodes(7);
                final long exactOutputSizeIfKnown = helper.exactOutputSizeIfKnown(spliterator);
                BytecodeManager.incBytecodes(1);
                final Node.Builder<P_OUT> builder = builderFactory.apply(exactOutputSizeIfKnown);
                BytecodeManager.incBytecodes(2);
                final PipelineHelper<P_OUT> helper2 = this.helper;
                final Node.Builder<P_OUT> builder2 = builder;
                final Spliterator<P_IN> spliterator2 = this.spliterator;
                BytecodeManager.incBytecodes(6);
                final Node.Builder<P_OUT> builder3 = helper2.wrapAndCopyInto(builder2, spliterator2);
                BytecodeManager.incBytecodes(2);
                final Node<P_OUT> build = builder3.build();
                BytecodeManager.incBytecodes(1);
                return (T_NODE)build;
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
                    final BinaryOperator<T_NODE> concFactory = this.concFactory;
                    final CollectorTask collectorTask = (CollectorTask)this.leftChild;
                    BytecodeManager.incBytecodes(7);
                    final Node<P_OUT> localResult = collectorTask.getLocalResult();
                    final CollectorTask collectorTask2 = (CollectorTask)this.rightChild;
                    BytecodeManager.incBytecodes(4);
                    final Node<P_OUT> localResult2 = collectorTask2.getLocalResult();
                    BytecodeManager.incBytecodes(1);
                    final Object apply = concFactory.apply((T_NODE)localResult, (T_NODE)localResult2);
                    BytecodeManager.incBytecodes(1);
                    this.setLocalResult((T_NODE)apply);
                }
                BytecodeManager.incBytecodes(3);
                super.onCompletion(countedCompleter);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private static final class OfRef<P_IN, P_OUT> extends CollectorTask<P_IN, P_OUT, Node<P_OUT>, Node.Builder<P_OUT>>
        {
            OfRef(final PipelineHelper<P_OUT> pipelineHelper, final IntFunction<P_OUT[]> intFunction, final Spliterator<P_IN> spliterator) {
                try {
                    final Object o;
                    final LongFunction<Object> longFunction = n -> {
                        try {
                            BytecodeManager.incBytecodes(3);
                            Nodes.builder(n, intFunction);
                            BytecodeManager.incBytecodes(1);
                            return o;
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    };
                    final BinaryOperator<Node> binaryOperator = ConcNode::new;
                    BytecodeManager.incBytecodes(5);
                    super(pipelineHelper, spliterator, (LongFunction<Node.Builder>)longFunction, binaryOperator);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
        
        private static final class OfInt<P_IN> extends CollectorTask<P_IN, Integer, Node.OfInt, Node.Builder.OfInt>
        {
            OfInt(final PipelineHelper<Integer> pipelineHelper, final Spliterator<P_IN> spliterator) {
                try {
                    final LongFunction<Node.Builder.OfInt> longFunction = Nodes::intBuilder;
                    final BinaryOperator<Node> binaryOperator = ConcNode.OfInt::new;
                    BytecodeManager.incBytecodes(4);
                    super((PipelineHelper<Object>)pipelineHelper, spliterator, (LongFunction<Node.Builder>)longFunction, binaryOperator);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
        
        private static final class OfLong<P_IN> extends CollectorTask<P_IN, Long, Node.OfLong, Node.Builder.OfLong>
        {
            OfLong(final PipelineHelper<Long> pipelineHelper, final Spliterator<P_IN> spliterator) {
                try {
                    final LongFunction<Node.Builder.OfLong> longFunction = Nodes::longBuilder;
                    final BinaryOperator<Node> binaryOperator = ConcNode.OfLong::new;
                    BytecodeManager.incBytecodes(4);
                    super((PipelineHelper<Object>)pipelineHelper, spliterator, (LongFunction<Node.Builder>)longFunction, binaryOperator);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
        
        private static final class OfDouble<P_IN> extends CollectorTask<P_IN, Double, Node.OfDouble, Node.Builder.OfDouble>
        {
            OfDouble(final PipelineHelper<Double> pipelineHelper, final Spliterator<P_IN> spliterator) {
                try {
                    final LongFunction<Node.Builder.OfDouble> longFunction = Nodes::doubleBuilder;
                    final BinaryOperator<Node> binaryOperator = ConcNode.OfDouble::new;
                    BytecodeManager.incBytecodes(4);
                    super((PipelineHelper<Object>)pipelineHelper, spliterator, (LongFunction<Node.Builder>)longFunction, binaryOperator);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
    }
}
